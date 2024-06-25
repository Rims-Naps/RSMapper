package org.rsmapper.game;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.RsMapperServer;
import org.rsmapper.Constants;
import org.rsmapper.api.database.ConnectionPool;
import org.rsmapper.api.database.DatabaseConnection;
import org.rsmapper.engine.CoresManager;
import org.rsmapper.engine.game.GameWorker;
import org.rsmapper.game.item.FloorItem;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.item.ItemConstants;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.InterfaceManager;
import org.rsmapper.game.player.OwnedObjectManager;
import org.rsmapper.game.player.Player;
import org.rsmapper.utilities.misc.Utils;

public final class World {
   private static final Predicate<Player> VALID_PLAYER = (p) -> {
      return p != null && p.hasStarted() && !p.hasFinished();
   };
   private static final Predicate<NPC> VALID_NPC = (n) -> {
      return n != null && !n.hasFinished();
   };
   public static int exiting_delay;
   public static long exiting_start;
   private static final EntityList<Player> players = new EntityList(2048);
   private static final EntityList<NPC> npcs = new EntityList(32767);
   private static final Map<Integer, Region> regions = Collections.synchronizedMap(new HashMap());
   private static boolean checkAgility;
   public static long updateIn = 0L;
   private static boolean requestedRestart = false;
   private static ConnectionPool<? extends DatabaseConnection> connectionPool;
   private static final GameWorker GAME_WORKER = new GameWorker();
   private static final ExecutorService EXECUTOR_SERVICE = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

   public static Stream<Entity> entities() {
      return Stream.concat(players(), npcs());
   }

   public static Stream<Player> players() {
      return players.stream().filter(VALID_PLAYER);
   }

   public static Stream<NPC> npcs() {
      return npcs.stream().filter(VALID_NPC);
   }

   public static void init() {
      try {
         addRestoreRunEnergyTask();
         addRestoreHitPointsTask();
         addRestoreSkillsTask();
         addRestoreSpecialAttackTask();
         addOwnedObjectsTask();
         loadConfiguration();
         EXECUTOR_SERVICE.submit(getGameWorker());
      } catch (Throwable var1) {
         var1.printStackTrace();
      }

   }

   public List<Player> getPlayersInWilderness() {
      List<Player> players = new ArrayList();
      return players;
   }

   private static void loadConfiguration() throws IOException, ClassNotFoundException, InstantiationException, IllegalAccessException {
   }

   private static void addOwnedObjectsTask() {
      CoresManager.slowExecutor.scheduleWithFixedDelay(new Runnable() {
         public void run() {
            try {
               OwnedObjectManager.processAll();
            } catch (Throwable var2) {
               var2.printStackTrace();
            }

         }
      }, 0L, 1L, TimeUnit.SECONDS);
   }

   private static final void addRestoreSpecialAttackTask() {
      CoresManager.fastExecutor.schedule(new TimerTask() {
         public void run() {
            try {
               Iterator var2 = World.getPlayers().iterator();

               while(var2.hasNext()) {
                  Player player = (Player)var2.next();
                  if (player != null && !player.isDead() && player.isRunning() && InterfaceManager.getQuestGuide() != null) {
                     player.getCombatDefinitions().restoreSpecialAttack();
                  }
               }
            } catch (Throwable var3) {
               var3.printStackTrace();
            }

         }
      }, 0L, 30000L);
   }

   private static final void addRestoreRunEnergyTask() {
      CoresManager.fastExecutor.schedule(new TimerTask() {
         public void run() {
            try {
               Iterator var2 = World.getPlayers().iterator();

               while(true) {
                  Player player;
                  do {
                     do {
                        do {
                           do {
                              if (!var2.hasNext()) {
                                 World.checkAgility = !World.checkAgility;
                                 return;
                              }

                              player = (Player)var2.next();
                           } while(player == null);
                        } while(player.isDead());
                     } while(!player.isRunning());
                  } while(World.checkAgility && player.getSkills().getLevel(16) < 70);

                  player.restoreRunEnergy();
               }
            } catch (Throwable var3) {
               var3.printStackTrace();
            }
         }
      }, 0L, 1000L);
   }

   private static final void addRestoreHitPointsTask() {
      CoresManager.fastExecutor.schedule(new TimerTask() {
         public void run() {
            try {
               Iterator var2 = World.getPlayers().iterator();

               while(var2.hasNext()) {
                  Player player = (Player)var2.next();
                  if (player != null && !player.isDead() && player.isRunning()) {
                     player.restoreHitPoints();
                  }
               }

               var2 = World.npcs.iterator();

               while(var2.hasNext()) {
                  NPC npc = (NPC)var2.next();
                  if (npc != null && !npc.isDead() && !npc.hasFinished()) {
                     npc.restoreHitPoints();
                  }
               }
            } catch (Throwable var3) {
               var3.printStackTrace();
            }

         }
      }, 0L, 6000L);
   }

   private static final void addRestoreSkillsTask() {
      CoresManager.fastExecutor.schedule(new TimerTask() {
         public void run() {
            try {
               Iterator var2 = World.getPlayers().iterator();

               while(true) {
                  Player player;
                  do {
                     do {
                        if (!var2.hasNext()) {
                           return;
                        }

                        player = (Player)var2.next();
                     } while(player == null);
                  } while(!player.isRunning());

                  int ammountTimes = 1;
                  if (player.isResting()) {
                     ++ammountTimes;
                  }

                  boolean berserker = false;

                  for(int skill = 0; skill < 25; ++skill) {
                     if (skill != 23) {
                        for(int time = 0; time < ammountTimes; ++time) {
                           int currentLevel = player.getSkills().getLevel(skill);
                           int normalLevel = player.getSkills().getLevelForXp(skill);
                           if (currentLevel <= normalLevel) {
                              if (currentLevel >= normalLevel) {
                                 break;
                              }

                              player.getSkills().set(skill, currentLevel + 1);
                           } else if (skill != 0 && skill != 2 && skill != 1 && skill != 4 && skill != 6 || !berserker || Utils.getRandom(100) > 15) {
                              player.getSkills().set(skill, currentLevel - 1);
                           }
                        }
                     }
                  }
               }
            } catch (Throwable var9) {
               var9.printStackTrace();
            }
         }
      }, 0L, 30000L);
   }

   public static final Map<Integer, Region> getRegions() {
      return regions;
   }

   public static final Region getRegion(int id) {
      try {
         return getRegion(id, false);
      } catch (Exception var2) {
         var2.printStackTrace();
         return null;
      }
   }

   public static boolean isTileFree(int plane, int x, int y, int size) {
      for(int tileX = x; tileX < x + size; ++tileX) {
         for(int tileY = y; tileY < y + size; ++tileY) {
            if (!isFloorFree(plane, tileX, tileY) || !isWallsFree(plane, tileX, tileY)) {
               return false;
            }
         }
      }

      return true;
   }

   public static boolean isFloorFree(int plane, int x, int y) {
      return (getMask(plane, x, y) & 2359552) == 0;
   }

   public static boolean isWallsFree(int plane, int x, int y) {
      return (getMask(plane, x, y) & 255) == 0;
   }

   public static final void spawnTempGroundObject(final WorldObject object, final int replaceId, long time) {
      spawnObject(object);
      CoresManager.slowExecutor.schedule(new Runnable() {
         public void run() {
            try {
               World.removeObject(object);
               World.addGroundItem(new Item(replaceId), object, (Player)null, false, 180L);
            } catch (Throwable var2) {
               var2.printStackTrace();
            }

         }
      }, time, TimeUnit.MILLISECONDS);
   }

   public static final Region getRegion(int id, boolean load) {
      Region region = (Region)regions.get(id);
      if (region == null) {
         region = new Region(id);
         regions.put(id, region);
      }

      if (load) {
         region.checkLoadMap();
      }

      return region;
   }

   public static final void addPlayer(Player player) {
      players.add((Entity)player);
   }

   public static void removePlayer(Player player) {
      players.remove(player);
   }

   public static final void addNPC(NPC npc) {
      npcs.add((Entity)npc);
   }

   public static final void removeNPC(NPC npc) {
      npcs.remove(npc);
   }

   public static final NPC spawnNPC(int id, WorldTile tile, int mapAreaNameHash, boolean canBeAttackFromOutOfArea, boolean spawned) {
      return spawnNPC(id, tile, mapAreaNameHash, canBeAttackFromOutOfArea, spawned, -1);
   }

   public static final NPC spawnNPC(int id, WorldTile tile, int mapAreaNameHash, boolean canBeAttackFromOutOfArea, boolean spawned, int respawnDelay) {
      return new NPC(id, tile, mapAreaNameHash, canBeAttackFromOutOfArea, spawned, respawnDelay);
   }

   public static final NPC spawnNPC(int id, WorldTile tile, int mapAreaNameHash, boolean canBeAttackFromOutOfArea) {
      return spawnNPC(id, tile, mapAreaNameHash, canBeAttackFromOutOfArea, false);
   }

   public static final void updateEntityRegion(Entity entity) {
      if (entity.hasFinished()) {
         if (entity instanceof Player) {
            getRegion(entity.getLastRegionId()).removePlayerIndex(entity.getIndex());
         } else {
            getRegion(entity.getLastRegionId()).removeNPCIndex(entity.getIndex());
         }

      } else {
         int regionId = entity.getRegionId();
         if (entity.getLastRegionId() != regionId) {
            if (entity instanceof Player) {
               if (entity.getLastRegionId() > 0) {
                  getRegion(entity.getLastRegionId()).removePlayerIndex(entity.getIndex());
               }

               Region region = getRegion(regionId);
               region.addPlayerIndex(entity.getIndex());
               Player player = (Player)entity;
               player.getControllerManager().moved();
               int musicId = region.getMusicId();
               if (musicId != -1) {
                  player.getMusicsManager().checkMusic(region.getMusicId());
               }

               if (player.isRunning() && player.getControllerManager().getController() == null) {
                  checkControllersAtMove(player);
               }
            } else {
               if (entity.getLastRegionId() > 0) {
                  getRegion(entity.getLastRegionId()).removeNPCIndex(entity.getIndex());
               }

               getRegion(regionId).addNPCIndex(entity.getIndex());
            }

            entity.checkMultiArea();
            entity.setLastRegionId(regionId);
         } else {
            if (entity instanceof Player) {
               Player player = (Player)entity;
               player.getControllerManager().moved();
               if (player.isRunning() && player.getControllerManager().getController() == null) {
                  checkControllersAtMove(player);
               }
            }

            entity.checkMultiArea();
         }

      }
   }

   private static void checkControllersAtMove(Player player) {
   }

   public static boolean canMoveNPC(int plane, int x, int y, int size) {
      for(int tileX = x; tileX < x + size; ++tileX) {
         for(int tileY = y; tileY < y + size; ++tileY) {
            if (getMask(plane, tileX, tileY) != 0) {
               return false;
            }
         }
      }

      return true;
   }

   public static int getMask(int plane, int x, int y) {
      WorldTile tile = new WorldTile(x, y, plane);
      Region region = getRegion(tile.getRegionId());
      return region == null ? -1 : region.getMask(tile.getPlane(), tile.getXInRegion(), tile.getYInRegion());
   }

   private static int getClipedOnlyMask(int plane, int x, int y) {
      WorldTile tile = new WorldTile(x, y, plane);
      Region region = getRegion(tile.getRegionId());
      return region == null ? -1 : region.getMaskClipedOnly(tile.getPlane(), tile.getXInRegion(), tile.getYInRegion());
   }

   public static final boolean checkProjectileStep(int plane, int x, int y, int dir, int size) {
      int xOffset = Utils.DIRECTION_DELTA_X[dir];
      int yOffset = Utils.DIRECTION_DELTA_Y[dir];
      int sizeOffset;
      if (size == 1) {
         sizeOffset = getClipedOnlyMask(plane, x + Utils.DIRECTION_DELTA_X[dir], y + Utils.DIRECTION_DELTA_Y[dir]);
         if (xOffset == -1 && yOffset == 0) {
            if ((sizeOffset & 1109655552) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 1 && yOffset == 0) {
            if ((sizeOffset & 1612972032) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 0 && yOffset == -1) {
            if ((sizeOffset & 1084489728) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 0 && yOffset == 1) {
            if ((sizeOffset & 1210318848) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == -1 && yOffset == -1) {
            if ((sizeOffset & 1134821376) == 0 && (getClipedOnlyMask(plane, x - 1, y) & 1109655552) == 0 && (getClipedOnlyMask(plane, x, y - 1) & 1084489728) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 1 && yOffset == -1) {
            if ((sizeOffset & 1625554944) == 0 && (getClipedOnlyMask(plane, x + 1, y) & 1612972032) == 0 && (getClipedOnlyMask(plane, x, y - 1) & 1084489728) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == -1 && yOffset == 1) {
            if ((sizeOffset & 1310982144) == 0 && (getClipedOnlyMask(plane, x - 1, y) & 1109655552) == 0 && (getClipedOnlyMask(plane, x, y + 1) & 1210318848) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 1 && yOffset == 1) {
            if ((sizeOffset & 2015625216) == 0 && (getClipedOnlyMask(plane, x + 1, y) & 1612972032) == 0 && (getClipedOnlyMask(plane, x, y + 1) & 1210318848) == 0) {
               return true;
            }

            return false;
         }
      } else if (size == 2) {
         if (xOffset == -1 && yOffset == 0) {
            if ((getClipedOnlyMask(plane, x - 1, y) & 1134821376) == 0 && (getClipedOnlyMask(plane, x - 1, y + 1) & 1310982144) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 1 && yOffset == 0) {
            if ((getClipedOnlyMask(plane, x + 2, y) & 1625554944) == 0 && (getClipedOnlyMask(plane, x + 2, y + 1) & 2015625216) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 0 && yOffset == -1) {
            if ((getClipedOnlyMask(plane, x, y - 1) & 1134821376) == 0 && (getClipedOnlyMask(plane, x + 1, y - 1) & 1625554944) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 0 && yOffset == 1) {
            if ((getClipedOnlyMask(plane, x, y + 2) & 1310982144) == 0 && (getClipedOnlyMask(plane, x + 1, y + 2) & 2015625216) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == -1 && yOffset == -1) {
            if ((getClipedOnlyMask(plane, x - 1, y) & 1336147968) == 0 && (getClipedOnlyMask(plane, x - 1, y - 1) & 1134821376) == 0 && (getClipedOnlyMask(plane, x, y - 1) & 1675886592) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 1 && yOffset == -1) {
            if ((getClipedOnlyMask(plane, x + 1, y - 1) & 1675886592) == 0 && (getClipedOnlyMask(plane, x + 2, y - 1) & 1625554944) == 0 && (getClipedOnlyMask(plane, x + 2, y) & 2028208128) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == -1 && yOffset == 1) {
            if ((getClipedOnlyMask(plane, x - 1, y + 1) & 1336147968) == 0 && (getClipedOnlyMask(plane, x - 1, y + 1) & 1310982144) == 0 && (getClipedOnlyMask(plane, x, y + 2) & 2116288512) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 1 && yOffset == 1) {
            if ((getClipedOnlyMask(plane, x + 1, y + 2) & 2116288512) == 0 && (getClipedOnlyMask(plane, x + 2, y + 2) & 2015625216) == 0 && (getClipedOnlyMask(plane, x + 1, y + 1) & 2028208128) == 0) {
               return true;
            }

            return false;
         }
      } else if (xOffset == -1 && yOffset == 0) {
         if ((getClipedOnlyMask(plane, x - 1, y) & 1134821376) != 0 || (getClipedOnlyMask(plane, x - 1, -1 + y + size) & 1310982144) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size - 1; ++sizeOffset) {
            if ((getClipedOnlyMask(plane, x - 1, y + sizeOffset) & 1336147968) != 0) {
               return false;
            }
         }
      } else if (xOffset == 1 && yOffset == 0) {
         if ((getClipedOnlyMask(plane, x + size, y) & 1625554944) != 0 || (getClipedOnlyMask(plane, x + size, y - (-size + 1)) & 2015625216) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size - 1; ++sizeOffset) {
            if ((getClipedOnlyMask(plane, x + size, y + sizeOffset) & 2028208128) != 0) {
               return false;
            }
         }
      } else if (xOffset == 0 && yOffset == -1) {
         if ((getClipedOnlyMask(plane, x, y - 1) & 1134821376) != 0 || (getClipedOnlyMask(plane, x + size - 1, y - 1) & 1625554944) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size - 1; ++sizeOffset) {
            if ((getClipedOnlyMask(plane, x + sizeOffset, y - 1) & 1675886592) != 0) {
               return false;
            }
         }
      } else if (xOffset == 0 && yOffset == 1) {
         if ((getClipedOnlyMask(plane, x, y + size) & 1310982144) != 0 || (getClipedOnlyMask(plane, x + (size - 1), y + size) & 2015625216) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size - 1; ++sizeOffset) {
            if ((getClipedOnlyMask(plane, x + sizeOffset, y + size) & 2116288512) != 0) {
               return false;
            }
         }
      } else if (xOffset == -1 && yOffset == -1) {
         if ((getClipedOnlyMask(plane, x - 1, y - 1) & 1134821376) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size; ++sizeOffset) {
            if ((getClipedOnlyMask(plane, x - 1, y + -1 + sizeOffset) & 1336147968) != 0 || (getClipedOnlyMask(plane, sizeOffset - 1 + x, y - 1) & 1675886592) != 0) {
               return false;
            }
         }
      } else if (xOffset == 1 && yOffset == -1) {
         if ((getClipedOnlyMask(plane, x + size, y - 1) & 1625554944) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size; ++sizeOffset) {
            if ((getClipedOnlyMask(plane, x + size, sizeOffset + -1 + y) & 2028208128) != 0 || (getClipedOnlyMask(plane, x + sizeOffset, y - 1) & 1675886592) != 0) {
               return false;
            }
         }
      } else if (xOffset == -1 && yOffset == 1) {
         if ((getClipedOnlyMask(plane, x - 1, y + size) & 1310982144) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size; ++sizeOffset) {
            if ((getClipedOnlyMask(plane, x - 1, y + sizeOffset) & 1336147968) != 0 || (getClipedOnlyMask(plane, -1 + x + sizeOffset, y + size) & 2116288512) != 0) {
               return false;
            }
         }
      } else if (xOffset == 1 && yOffset == 1) {
         if ((getClipedOnlyMask(plane, x + size, y + size) & 2015625216) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size; ++sizeOffset) {
            if ((getClipedOnlyMask(plane, x + sizeOffset, y + size) & 2116288512) != 0 || (getClipedOnlyMask(plane, x + size, y + sizeOffset) & 2028208128) != 0) {
               return false;
            }
         }
      }

      return true;
   }

   public static int getRotation(int plane, int x, int y) {
      WorldTile tile = new WorldTile(x, y, plane);
      int regionId = tile.getRegionId();
      Region region = getRegion(regionId);
      if (region == null) {
         return 0;
      } else {
         int baseLocalX = x - (regionId >> 8) * 64;
         int baseLocalY = y - (regionId & 255) * 64;
         return region.getRotation(tile.getPlane(), baseLocalX, baseLocalY);
      }
   }

   public static final boolean checkWalkStep(int plane, int x, int y, int dir, int size) {
      return checkWalkStep(plane, x, y, Utils.DIRECTION_DELTA_X[dir], Utils.DIRECTION_DELTA_Y[dir], size);
   }

   public static final boolean checkWalkStep(int plane, int x, int y, int xOffset, int yOffset, int size) {
      int sizeOffset;
      if (size == 1) {
         sizeOffset = getMask(plane, x + xOffset, y + yOffset);
         if (xOffset == -1 && yOffset == 0) {
            if ((sizeOffset & 2359560) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 1 && yOffset == 0) {
            if ((sizeOffset & 2359680) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 0 && yOffset == -1) {
            if ((sizeOffset & 2359554) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 0 && yOffset == 1) {
            if ((sizeOffset & 2359584) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == -1 && yOffset == -1) {
            if ((sizeOffset & 2359566) == 0 && (getMask(plane, x - 1, y) & 2359560) == 0 && (getMask(plane, x, y - 1) & 2359554) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 1 && yOffset == -1) {
            if ((sizeOffset & 2359683) == 0 && (getMask(plane, x + 1, y) & 2359680) == 0 && (getMask(plane, x, y - 1) & 2359554) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == -1 && yOffset == 1) {
            if ((sizeOffset & 2359608) == 0 && (getMask(plane, x - 1, y) & 2359560) == 0 && (getMask(plane, x, y + 1) & 2359584) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 1 && yOffset == 1) {
            if ((sizeOffset & 2359776) == 0 && (getMask(plane, x + 1, y) & 2359680) == 0 && (getMask(plane, x, y + 1) & 2359584) == 0) {
               return true;
            }

            return false;
         }
      } else if (size == 2) {
         if (xOffset == -1 && yOffset == 0) {
            if ((getMask(plane, x - 1, y) & 2359566) == 0 && (getMask(plane, x - 1, y + 1) & 2359608) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 1 && yOffset == 0) {
            if ((getMask(plane, x + 2, y) & 2359683) == 0 && (getMask(plane, x + 2, y + 1) & 2359776) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 0 && yOffset == -1) {
            if ((getMask(plane, x, y - 1) & 2359566) == 0 && (getMask(plane, x + 1, y - 1) & 2359683) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 0 && yOffset == 1) {
            if ((getMask(plane, x, y + 2) & 2359608) == 0 && (getMask(plane, x + 1, y + 2) & 2359776) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == -1 && yOffset == -1) {
            if ((getMask(plane, x - 1, y) & 2359614) == 0 && (getMask(plane, x - 1, y - 1) & 2359566) == 0 && (getMask(plane, x, y - 1) & 2359695) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 1 && yOffset == -1) {
            if ((getMask(plane, x + 1, y - 1) & 2359695) == 0 && (getMask(plane, x + 2, y - 1) & 2359683) == 0 && (getMask(plane, x + 2, y) & 2359779) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == -1 && yOffset == 1) {
            if ((getMask(plane, x - 1, y + 1) & 2359614) == 0 && (getMask(plane, x - 1, y + 1) & 2359608) == 0 && (getMask(plane, x, y + 2) & 2359800) == 0) {
               return true;
            }

            return false;
         }

         if (xOffset == 1 && yOffset == 1) {
            if ((getMask(plane, x + 1, y + 2) & 2359800) == 0 && (getMask(plane, x + 2, y + 2) & 2359776) == 0 && (getMask(plane, x + 1, y + 1) & 2359779) == 0) {
               return true;
            }

            return false;
         }
      } else if (xOffset == -1 && yOffset == 0) {
         if ((getMask(plane, x - 1, y) & 2359566) != 0 || (getMask(plane, x - 1, -1 + y + size) & 2359608) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size - 1; ++sizeOffset) {
            if ((getMask(plane, x - 1, y + sizeOffset) & 2359614) != 0) {
               return false;
            }
         }
      } else if (xOffset == 1 && yOffset == 0) {
         if ((getMask(plane, x + size, y) & 2359683) != 0 || (getMask(plane, x + size, y - (-size + 1)) & 2359776) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size - 1; ++sizeOffset) {
            if ((getMask(plane, x + size, y + sizeOffset) & 2359779) != 0) {
               return false;
            }
         }
      } else if (xOffset == 0 && yOffset == -1) {
         if ((getMask(plane, x, y - 1) & 2359566) != 0 || (getMask(plane, x + size - 1, y - 1) & 2359683) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size - 1; ++sizeOffset) {
            if ((getMask(plane, x + sizeOffset, y - 1) & 2359695) != 0) {
               return false;
            }
         }
      } else if (xOffset == 0 && yOffset == 1) {
         if ((getMask(plane, x, y + size) & 2359608) != 0 || (getMask(plane, x + (size - 1), y + size) & 2359776) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size - 1; ++sizeOffset) {
            if ((getMask(plane, x + sizeOffset, y + size) & 2359800) != 0) {
               return false;
            }
         }
      } else if (xOffset == -1 && yOffset == -1) {
         if ((getMask(plane, x - 1, y - 1) & 2359566) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size; ++sizeOffset) {
            if ((getMask(plane, x - 1, y + -1 + sizeOffset) & 2359614) != 0 || (getMask(plane, sizeOffset - 1 + x, y - 1) & 2359695) != 0) {
               return false;
            }
         }
      } else if (xOffset == 1 && yOffset == -1) {
         if ((getMask(plane, x + size, y - 1) & 2359683) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size; ++sizeOffset) {
            if ((getMask(plane, x + size, sizeOffset + -1 + y) & 2359779) != 0 || (getMask(plane, x + sizeOffset, y - 1) & 2359695) != 0) {
               return false;
            }
         }
      } else if (xOffset == -1 && yOffset == 1) {
         if ((getMask(plane, x - 1, y + size) & 2359608) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size; ++sizeOffset) {
            if ((getMask(plane, x - 1, y + sizeOffset) & 2359614) != 0 || (getMask(plane, -1 + x + sizeOffset, y + size) & 2359800) != 0) {
               return false;
            }
         }
      } else if (xOffset == 1 && yOffset == 1) {
         if ((getMask(plane, x + size, y + size) & 2359776) != 0) {
            return false;
         }

         for(sizeOffset = 1; sizeOffset < size; ++sizeOffset) {
            if ((getMask(plane, x + sizeOffset, y + size) & 2359800) != 0 || (getMask(plane, x + size, y + sizeOffset) & 2359779) != 0) {
               return false;
            }
         }
      }

      return true;
   }

   public static final boolean containsPlayer(String username) {
      Iterator var2 = players.iterator();

      Player p2;
      do {
         if (!var2.hasNext()) {
            return false;
         }

         p2 = (Player)var2.next();
      } while(p2 == null || !p2.getUsername().equals(username));

      return true;
   }

   public static Player getPlayer(String username) {
      Iterator var2 = getPlayers().iterator();

      Player player;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         player = (Player)var2.next();
      } while(player == null || !player.getUsername().equals(username));

      return player;
   }

   public static final Player getPlayerByDisplayName(String username) {
      String formatedUsername = Utils.formatPlayerNameForProtocol(username);
      Iterator var3 = getPlayers().iterator();

      Player player;
      do {
         do {
            if (!var3.hasNext()) {
               return null;
            }

            player = (Player)var3.next();
         } while(player == null);
      } while(!player.getUsername().equals(formatedUsername) && !player.getDisplayName().equals(username));

      return player;
   }

   public static final EntityList<Player> getPlayers() {
      return players;
   }

   public static final EntityList<NPC> getNPCs() {
      return npcs;
   }

   private World() {
   }

   public static final void safeShutdown(final boolean restart, final int delay) {
      exiting_start = Utils.currentTimeMillis();
      exiting_delay = delay;
      final long updateTime = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis((long)delay);
      updateIn = (long)delay;
      CoresManager.slowExecutor.scheduleAtFixedRate(new Runnable() {
         int seconds = 0;

         public void run() {
            Player player;
            Iterator var2;
            if (this.seconds++ == delay) {
               try {
                  var2 = World.getPlayers().iterator();

                  while(var2.hasNext()) {
                     player = (Player)var2.next();
                     if (player != null && player.hasStarted()) {
                        player.realFinish();
                     }
                  }

                  if (restart) {
                     RsMapperServer.restart();
                  } else {
                     RsMapperServer.shutdown();
                     System.exit(-1);
                  }
               } catch (Throwable var5) {
                  var5.printStackTrace();
               }
            } else {
               var2 = World.getPlayers().iterator();

               while(var2.hasNext()) {
                  player = (Player)var2.next();
                  if (player != null && player.hasStarted() && !player.hasFinished()) {
                     long updates = TimeUnit.MILLISECONDS.toSeconds(updateTime - System.currentTimeMillis());
                     player.sendNotification((World.requestedRestart ? "Server Restart" : "Update") + " In: " + updates, -1);
                     World.updateIn = updates;
                  }
               }
            }

         }
      }, 0L, 1L, TimeUnit.SECONDS);
   }

   public static final void spawnTemporaryObject(final WorldObject object, long time) {
      spawnObject(object);
      CoresManager.slowExecutor.schedule(new Runnable() {
         public void run() {
            try {
               if (!World.isSpawnedObject(object)) {
                  return;
               }

               World.removeObject(object);
            } catch (Throwable var2) {
               var2.printStackTrace();
            }

         }
      }, time, TimeUnit.MILLISECONDS);
   }

   public static final boolean removeObjectTemporary(final WorldObject object, long time) {
      removeObject(object);
      CoresManager.slowExecutor.schedule(new Runnable() {
         public void run() {
            try {
               World.spawnObject(object);
            } catch (Throwable var2) {
               var2.printStackTrace();
            }

         }
      }, time, TimeUnit.MILLISECONDS);
      return true;
   }

   public static final boolean isSpawnedObject(WorldObject object) {
      return getRegion(object.getRegionId()).getSpawnedObjects().contains(object);
   }

   public static final boolean removeTemporaryObject(final WorldObject object, long time) {
      removeObject(object);
      CoresManager.slowExecutor.schedule(new Runnable() {
         public void run() {
            try {
               World.spawnObject(object);
            } catch (Throwable var2) {
               var2.printStackTrace();
            }

         }
      }, time, TimeUnit.MILLISECONDS);
      return true;
   }

   public static final void spawnObject(WorldObject object) {
      getRegion(object.getRegionId()).spawnObject(object, object.getPlane(), object.getXInRegion(), object.getYInRegion(), false);
   }

   public static final void unclipTile(WorldTile tile) {
      getRegion(tile.getRegionId()).unclip(tile.getPlane(), tile.getXInRegion(), tile.getYInRegion());
   }

   public static final void removeObject(WorldObject object) {
      getRegion(object.getRegionId()).removeObject(object, object.getPlane(), object.getXInRegion(), object.getYInRegion());
   }

   public static final boolean containsObjectWithId(WorldTile tile, int id) {
      return getRegion(tile.getRegionId()).containsObjectWithId(tile.getPlane(), tile.getXInRegion(), tile.getYInRegion(), id);
   }

   public static final boolean containsObjectWithId(int id, WorldTile tile) {
      return getRegion(tile.getRegionId()).containsObjectWithId(tile.getPlane(), tile.getXInRegion(), tile.getYInRegion(), id);
   }

   public static final WorldObject getObjectWithId(int id, WorldTile tile) {
      return getRegion(tile.getRegionId()).getObjectWithId(tile.getPlane(), tile.getXInRegion(), tile.getYInRegion(), id);
   }

   public static final WorldObject getObjectWithId(WorldTile tile, int id) {
      return getRegion(tile.getRegionId()).getObjectWithId(tile.getPlane(), tile.getXInRegion(), tile.getYInRegion(), id);
   }

   public static final WorldObject getStandardObject(WorldTile tile) {
      return getRegion(tile.getRegionId()).getStandardObject(tile.getPlane(), tile.getXInRegion(), tile.getYInRegion());
   }

   public static final WorldObject getObjectWithType(WorldTile tile, int type) {
      return getRegion(tile.getRegionId()).getObjectWithType(tile.getPlane(), tile.getXInRegion(), tile.getYInRegion(), type);
   }

   public static final WorldObject getObjectWithSlot(WorldTile tile, int slot) {
      return getRegion(tile.getRegionId()).getObjectWithSlot(tile.getPlane(), tile.getXInRegion(), tile.getYInRegion(), slot);
   }

   public static final void addGroundItem(Item item, WorldTile tile) {
      addGroundItem(item, tile, (Player)null, false, -1L, 2, -1);
   }

   public static final void addGroundItem(Item item, WorldTile tile, Player owner, boolean invisible, long hiddenTime) {
      addGroundItem(item, tile, owner, invisible, hiddenTime, 2, 150);
   }

   public static final FloorItem addGroundItem(Item item, WorldTile tile, Player owner, boolean invisible, long hiddenTime, int type) {
      return addGroundItem(item, tile, owner, invisible, hiddenTime, type, 150);
   }

   public static final FloorItem addGroundItem(Item item, WorldTile tile, Player owner, boolean invisible, long hiddenTime, int type, final int publicTime) {
      if (type != 2 && (type == 0 && !ItemConstants.isTradeable(item) || type == 1 && ItemConstants.isDestroy(item))) {
         int price = item.getDefinitions().getValue();
         if (price <= 0) {
            return null;
         }

         item.setId(995);
         item.setAmount(price);
      }

      final FloorItem floorItem = new FloorItem(item, tile, owner, owner != null, invisible);
      Region region = getRegion(tile.getRegionId());
      region.forceGetFloorItems().add(floorItem);
      if (invisible) {
         if (owner != null) {
            owner.getPackets().sendGroundItem(floorItem);
         }

         if (hiddenTime != -1L) {
            CoresManager.slowExecutor.schedule(new Runnable() {
               public void run() {
                  try {
                     World.turnPublic(floorItem, publicTime);
                  } catch (Throwable var2) {
                     var2.printStackTrace();
                  }

               }
            }, hiddenTime, TimeUnit.SECONDS);
         }
      } else {
         int regionId = tile.getRegionId();
         players().filter((p) -> {
            return tile.getPlane() == p.getPlane() && p.getMapRegionsIds().contains(regionId);
         }).forEach((p) -> {
            p.getPackets().sendGroundItem(floorItem);
         });
         if (publicTime != -1) {
            removeGroundItem(floorItem, (long)publicTime);
         }
      }

      return floorItem;
   }

   public static final void spawnObjectTemporary(final WorldObject object, long time) {
      spawnObject(object);
      CoresManager.slowExecutor.schedule(new Runnable() {
         public void run() {
            try {
               if (!World.isSpawnedObject(object)) {
                  return;
               }

               World.removeObject(object);
            } catch (Throwable var2) {
               var2.printStackTrace();
            }

         }
      }, time, TimeUnit.MILLISECONDS);
   }

   public static final void turnPublic(FloorItem floorItem, int publicTime) {
      if (floorItem.isInvisible()) {
         int regionId = floorItem.getTile().getRegionId();
         Region region = getRegion(regionId);
         if (region.forceGetFloorItems().contains(floorItem)) {
            Player realOwner = floorItem.hasOwner() ? getPlayer(floorItem.getOwner().getUsername()) : null;
            if (!ItemConstants.isTradeable(floorItem)) {
               region.forceGetFloorItems().remove(floorItem);
               if (realOwner != null && realOwner.getMapRegionsIds().contains(regionId) && realOwner.getPlane() == floorItem.getTile().getPlane()) {
                  realOwner.getPackets().sendRemoveGroundItem(floorItem);
               }

            } else {
               floorItem.setInvisible(false);
               Iterator var6 = players.iterator();

               while(var6.hasNext()) {
                  Player player = (Player)var6.next();
                  if (player != null && player != realOwner && player.hasStarted() && !player.hasFinished() && player.getPlane() == floorItem.getTile().getPlane() && player.getMapRegionsIds().contains(regionId)) {
                     player.getPackets().sendGroundItem(floorItem);
                  }
               }

               if (publicTime != -1) {
                  removeGroundItem(floorItem, (long)publicTime);
               }

            }
         }
      }
   }

   public static final void updateGroundItem(Item item, WorldTile tile, Player owner) {
      FloorItem floorItem = getRegion(tile.getRegionId()).getFloorItem(item.getId(), tile, owner);
      if (floorItem == null) {
         addGroundItem(item, tile, owner, true, 360L);
      } else {
         floorItem.setAmount(floorItem.getAmount() + item.getAmount());
         owner.getPackets().sendRemoveGroundItem(floorItem);
         owner.getPackets().sendGroundItem(floorItem);
      }
   }

   private static final void removeGroundItem(final FloorItem floorItem, long publicTime) {
      CoresManager.slowExecutor.schedule(new Runnable() {
         public void run() {
            try {
               int regionId = floorItem.getTile().getRegionId();
               Region region = World.getRegion(regionId);
               if (!region.forceGetFloorItems().contains(floorItem)) {
                  return;
               }

               region.forceGetFloorItems().remove(floorItem);
               World.players().filter((p) -> {
                  return p.getPlane() == floorItem.getTile().getPlane() && p.getMapRegionsIds().contains(regionId);
               }).forEach((p) -> {
                  p.getPackets().sendRemoveGroundItem(floorItem);
               });
            } catch (Throwable var3) {
               var3.printStackTrace();
            }

         }
      }, publicTime, TimeUnit.SECONDS);
   }

   public static final boolean removeGroundItem(Player player, FloorItem floorItem) {
      return removeGroundItem(player, floorItem, true);
   }

   public static final void addGroundItemForever(Item item, WorldTile tile) {
      int regionId = tile.getRegionId();
      FloorItem floorItem = new FloorItem(item, tile, true);
      Region region = getRegion(tile.getRegionId());
      region.forceGetFloorItems().add(floorItem);
      Iterator var6 = players.iterator();

      while(var6.hasNext()) {
         Player player = (Player)var6.next();
         if (player != null && player.hasStarted() && !player.hasFinished() && player.getPlane() == floorItem.getTile().getPlane() && player.getMapRegionsIds().contains(regionId)) {
            player.getPackets().sendGroundItem(floorItem);
         }
      }

   }

   public static final boolean removeGroundItem(Player player, final FloorItem floorItem, boolean addToInventory) {
      int regionId = floorItem.getTile().getRegionId();
      Region region = getRegion(regionId);
      if (!region.forceGetFloorItems().contains(floorItem)) {
         return false;
      } else if (player == null || player.getInventory().getFreeSlots() != 0 || floorItem.getDefinitions().isStackable() && player.getInventory().containsItem(floorItem.getId(), 1)) {
         region.forceGetFloorItems().remove(floorItem);
         if (player != null && addToInventory) {
            player.getInventory().addItem(floorItem);
         }

         if (player != null && floorItem.isInvisible()) {
            player.getPackets().sendRemoveGroundItem(floorItem);
            return true;
         } else {
            Iterator var6 = getPlayers().iterator();

            while(var6.hasNext()) {
               Player p2 = (Player)var6.next();
               if (p2 != null && p2.hasStarted() && !p2.hasFinished() && p2.getPlane() == floorItem.getTile().getPlane() && p2.getMapRegionsIds().contains(regionId)) {
                  p2.getPackets().sendRemoveGroundItem(floorItem);
               }
            }

            if (floorItem.isForever()) {
               CoresManager.slowExecutor.schedule(new Runnable() {
                  public void run() {
                     try {
                        World.addGroundItemForever(floorItem, floorItem.getTile());
                     } catch (Throwable var2) {
                        var2.printStackTrace();
                     }

                  }
               }, 60L, TimeUnit.SECONDS);
            }

            return true;
         }
      } else {
         player.getPackets().sendGameMessage("Not enough space in your inventory.");
         return false;
      }
   }

   public static final void sendGraphics(Entity creator, Graphics graphics, WorldTile tile) {
      Iterator var4;
      if (creator == null) {
         var4 = getPlayers().iterator();

         while(var4.hasNext()) {
            Player player = (Player)var4.next();
            if (player != null && player.hasStarted() && !player.hasFinished() && player.withinDistance(tile)) {
               player.getPackets().sendGraphics(graphics, tile);
            }
         }

      } else {
         var4 = creator.getMapRegionsIds().iterator();

         while(true) {
            List playersIndexes;
            do {
               if (!var4.hasNext()) {
                  return;
               }

               int regionId = (Integer)var4.next();
               playersIndexes = getRegion(regionId).getPlayerIndexes();
            } while(playersIndexes == null);

            Iterator var7 = playersIndexes.iterator();

            while(var7.hasNext()) {
               Integer playerIndex = (Integer)var7.next();
               Player player = (Player)players.get(playerIndex);
               if (player != null && player.hasStarted() && !player.hasFinished() && player.withinDistance(tile)) {
                  player.getPackets().sendGraphics(graphics, tile);
               }
            }
         }
      }
   }

   public static final void sendProjectile(Entity shooter, WorldTile startTile, WorldTile receiver, int gfxId, int startHeight, int endHeight, int speed, int delay, int curve, int startDistanceOffset) {
      Iterator var11 = shooter.getMapRegionsIds().iterator();

      label47:
      while(true) {
         List playersIndexes;
         do {
            if (!var11.hasNext()) {
               return;
            }

            int regionId = (Integer)var11.next();
            playersIndexes = getRegion(regionId).getPlayerIndexes();
         } while(playersIndexes == null);

         Iterator var14 = playersIndexes.iterator();

         while(true) {
            Player player;
            do {
               do {
                  do {
                     do {
                        if (!var14.hasNext()) {
                           continue label47;
                        }

                        Integer playerIndex = (Integer)var14.next();
                        player = (Player)players.get(playerIndex);
                     } while(player == null);
                  } while(!player.hasStarted());
               } while(player.hasFinished());
            } while(!player.withinDistance(shooter) && !player.withinDistance(receiver));

            player.getPackets().sendProjectile((Entity)null, startTile, receiver, gfxId, startHeight, endHeight, speed, delay, curve, startDistanceOffset, 1);
         }
      }
   }

   public static final void sendProjectile(Entity shooter, WorldTile receiver, int gfxId, int startHeight, int endHeight, int speed, int delay, int curve, int startDistanceOffset) {
      Iterator var10 = shooter.getMapRegionsIds().iterator();

      label47:
      while(true) {
         List playersIndexes;
         do {
            if (!var10.hasNext()) {
               return;
            }

            int regionId = (Integer)var10.next();
            playersIndexes = getRegion(regionId).getPlayerIndexes();
         } while(playersIndexes == null);

         Iterator var13 = playersIndexes.iterator();

         while(true) {
            Player player;
            do {
               do {
                  do {
                     do {
                        if (!var13.hasNext()) {
                           continue label47;
                        }

                        Integer playerIndex = (Integer)var13.next();
                        player = (Player)players.get(playerIndex);
                     } while(player == null);
                  } while(!player.hasStarted());
               } while(player.hasFinished());
            } while(!player.withinDistance(shooter) && !player.withinDistance(receiver));

            player.getPackets().sendProjectile((Entity)null, shooter, receiver, gfxId, startHeight, endHeight, speed, delay, curve, startDistanceOffset, shooter.getSize());
         }
      }
   }

   public static final void sendProjectile(WorldObject object, WorldTile startTile, WorldTile endTile, int gfxId, int startHeight, int endHeight, int speed, int delay, int curve, int startOffset) {
      Iterator var11 = players.iterator();

      while(var11.hasNext()) {
         Player pl = (Player)var11.next();
         if (pl != null && pl.withinDistance(object, 20)) {
            pl.getPackets().sendProjectile((Entity)null, startTile, endTile, gfxId, startHeight, endHeight, speed, delay, curve, startOffset, 1);
         }
      }

   }

   public static final void sendProjectile(Entity shooter, Entity receiver, int gfxId, int startHeight, int endHeight, int speed, int delay, int curve, int startDistanceOffset) {
      Iterator var10 = shooter.getMapRegionsIds().iterator();

      label47:
      while(true) {
         List playersIndexes;
         do {
            if (!var10.hasNext()) {
               return;
            }

            int regionId = (Integer)var10.next();
            playersIndexes = getRegion(regionId).getPlayerIndexes();
         } while(playersIndexes == null);

         Iterator var13 = playersIndexes.iterator();

         while(true) {
            Player player;
            do {
               do {
                  do {
                     do {
                        if (!var13.hasNext()) {
                           continue label47;
                        }

                        Integer playerIndex = (Integer)var13.next();
                        player = (Player)players.get(playerIndex);
                     } while(player == null);
                  } while(!player.hasStarted());
               } while(player.hasFinished());
            } while(!player.withinDistance(shooter) && !player.withinDistance(receiver));

            int size = shooter.getSize();
            player.getPackets().sendProjectile(receiver, new WorldTile(shooter.getCoordFaceX(size), shooter.getCoordFaceY(size), shooter.getPlane()), receiver, gfxId, startHeight, endHeight, speed, delay, curve, startDistanceOffset, size);
         }
      }
   }

   public static final boolean isMultiArea(WorldTile tile) {
      int destX = tile.getX();
      int destY = tile.getY();
      return destX >= 3200 && destX <= 3390 && destY >= 3840 && destY <= 3967 || destX >= 2835 && destX <= 2880 && destY >= 5905 && destY <= 5950 || destX >= 2992 && destX <= 3007 && destY >= 3912 && destY <= 3967 || destX >= 2946 && destX <= 2959 && destY >= 3816 && destY <= 3831 || destX >= 3008 && destX <= 3199 && destY >= 3856 && destY <= 3903 || destX >= 3008 && destX <= 3071 && destY >= 3600 && destY <= 3711 || destX >= 3270 && destX <= 3346 && destY >= 3532 && destY <= 3625 || destX >= 2965 && destX <= 3050 && destY >= 3904 && destY <= 3959 || destX >= 2815 && destX <= 2966 && destY >= 5240 && destY <= 5375 || destX >= 2840 && destX <= 2950 && destY >= 5190 && destY <= 5230 || destX >= 3547 && destX <= 3555 && destY >= 9690 && destY <= 9699 || tile.getRegionId() == 11589 || tile.getRegionId() == 7492 || destX <= 2395 && destX >= 2370 && destY <= 4695 && destY >= 4675 || tile.getRegionId() == 11150 || destX >= 2622 && destY >= 5696 && destX <= 2573 && destY <= 5752 || tile.getRegionId() == 10074 || destX >= 2368 && destY >= 3072 && destX <= 2431 && destY <= 3135 || destX >= 2365 && destY >= 9470 && destX <= 2436 && destY <= 9532 || destX >= 2948 && destY >= 5537 && destX <= 3071 && destY <= 5631 || destX >= 2756 && destY >= 5537 && destX <= 2879 && destY <= 5631 || tile.getRegionId() == 10554 || destX >= 2970 && destX <= 3000 && destY >= 4365 && destY <= 4400 || destX >= 3136 && destX <= 3327 && destY >= 3520 && destY <= 3970 || destX >= 2376 && 5127 >= destY && destX <= 2422 && 5168 <= destY || destX >= 2374 && destY >= 5129 && destX <= 2424 && destY <= 5168 || destX >= 2622 && destY >= 5696 && destX <= 2573 && destY <= 5752 || destX >= 2368 && destY >= 3072 && destX <= 2431 && destY <= 3135 || destX >= 3086 && destY >= 5536 && destX <= 3315 && destY <= 5530 || tile.getRegionId() == 15159 || tile.getRegionId() == 13972 || tile.getRegionId() == 12190 || tile.getRegionId() == 12446 || tile.getX() >= 3526 && tile.getX() <= 3550 && tile.getY() >= 5185 && tile.getY() <= 5215 || destX >= 2365 && destY >= 9470 && destX <= 2436 && destY <= 9532 || destX >= 1597 && destY >= 5246 && destX <= 1669 && destY <= 5318 || destX >= 3614 && destX <= 3625 && destY >= 3334 && destY <= 3349 && tile.getPlane() == 0;
   }

   public static final boolean isPvpArea(WorldTile tile) {
      return false;
   }

   public static final boolean inSafe(WorldTile tile) {
      int destX = tile.getX();
      int destY = tile.getY();
      return destX >= 3008 && destX <= 3019 && destY >= 3353 && destY <= 3358 || destX >= 2943 && destX <= 3949 && destY >= 3367 && destY <= 3373;
   }

   public static final boolean isFalaPK(WorldTile tile) {
      int destX = tile.getX();
      int destY = tile.getY();
      return destX >= 2936 && destX <= 3065 && destY >= 3309 && destY <= 3394 && !inSafe(tile);
   }

   public static int getIdFromName(String playerName) {
      String name = Utils.formatPlayerNameForProtocol(playerName);
      Iterator var3 = players.iterator();

      Player p;
      do {
         if (!var3.hasNext()) {
            return 0;
         }

         p = (Player)var3.next();
      } while(p == null || !p.getUsername().equalsIgnoreCase(name));

      return p.getIndex();
   }

   public static final Player getPlayerByIndex(int index) {
      return (Player)players().filter((p) -> {
         return index == p.getIndex();
      }).findFirst().get();
   }

   public static final void sendObjectAnimation(WorldObject object, Animation animation) {
      sendObjectAnimation((Entity)null, object, animation);
   }

   public static final void sendObjectAnimation(Entity creator, WorldObject object, Animation animation) {
      Iterator var4;
      if (creator == null) {
         var4 = getPlayers().iterator();

         while(var4.hasNext()) {
            Player player = (Player)var4.next();
            if (player != null && player.hasStarted() && !player.hasFinished() && player.withinDistance(object)) {
               player.getPackets().sendObjectAnimation(object, animation);
            }
         }

      } else {
         var4 = creator.getMapRegionsIds().iterator();

         while(true) {
            List playersIndexes;
            do {
               if (!var4.hasNext()) {
                  return;
               }

               int regionId = (Integer)var4.next();
               playersIndexes = getRegion(regionId).getPlayerIndexes();
            } while(playersIndexes == null);

            Iterator var7 = playersIndexes.iterator();

            while(var7.hasNext()) {
               Integer playerIndex = (Integer)var7.next();
               Player player = (Player)players.get(playerIndex);
               if (player != null && player.hasStarted() && !player.hasFinished() && player.withinDistance(object)) {
                  player.getPackets().sendObjectAnimation(object, animation);
               }
            }
         }
      }
   }

   public static final void sendProjectile(WorldTile shooter, Entity receiver, int gfxId, int startHeight, int endHeight, int speed, int delay, int curve, int startDistanceOffset) {
      Iterator var10 = receiver.getMapRegionsIds().iterator();

      label47:
      while(true) {
         List playersIndexes;
         do {
            if (!var10.hasNext()) {
               return;
            }

            int regionId = (Integer)var10.next();
            playersIndexes = getRegion(regionId).getPlayerIndexes();
         } while(playersIndexes == null);

         Iterator var13 = playersIndexes.iterator();

         while(true) {
            Player player;
            do {
               do {
                  do {
                     do {
                        if (!var13.hasNext()) {
                           continue label47;
                        }

                        Integer playerIndex = (Integer)var13.next();
                        player = (Player)players.get(playerIndex);
                     } while(player == null);
                  } while(!player.hasStarted());
               } while(player.hasFinished());
            } while(!player.withinDistance(shooter) && !player.withinDistance(receiver));

            player.getPackets().sendProjectile((Entity)null, shooter, receiver, gfxId, startHeight, endHeight, speed, delay, curve, startDistanceOffset, 1);
         }
      }
   }

   public static void sendWorldMessage(String message, boolean forStaff, boolean hide_global) {
      if (!hide_global) {
         message = "<col=000FF>[</col><col=800000>ANNOUNCEMENT</col><col=000FF>]</col>: " + message;
      }

      Stream<Player> players = players();
      players.forEach((p) -> {
         p.sendMessage(message);
      });
      if (Constants.DEBUG) {
         System.out.println(message);
      }

   }

   public static ConnectionPool<? extends DatabaseConnection> getConnectionPool() {
      return connectionPool;
   }

   public static void setConnectionPool(ConnectionPool<? extends DatabaseConnection> connectionPool) {
      World.connectionPool = connectionPool;
   }

   public static GameWorker getGameWorker() {
      return GAME_WORKER;
   }
}
