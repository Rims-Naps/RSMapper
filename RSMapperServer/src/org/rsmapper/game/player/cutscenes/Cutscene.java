package org.rsmapper.game.player.cutscenes;

import org.rsmapper.Constants;
import org.rsmapper.engine.CoresManager;
import org.rsmapper.game.RegionBuilder;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.cutscenes.actions.CutsceneAction;
import org.rsmapper.game.tasks.WorldTask;
import org.rsmapper.game.tasks.WorldTasksManager;

public abstract class Cutscene {
   private int stage;
   private Object[] cache;
   private CutsceneAction[] actions;
   private int delay;
   private boolean constructingRegion;
   private int[] currentMapData;
   private WorldTile endTile;

   public abstract boolean hiddenMinimap();

   public abstract CutsceneAction[] getActions(Player var1);

   public final void stopCutscene(Player player) {
      if (player.getX() != this.endTile.getX() || player.getY() != this.endTile.getY() || player.getPlane() != this.endTile.getPlane()) {
         player.setNextWorldTile(this.endTile);
      }

      if (this.hiddenMinimap()) {
         player.getPackets().sendBlackOut(0);
      }

      player.getPackets().sendConfig(1241, 0);
      player.getPackets().sendResetCamera();
      player.unlock();
      this.deleteCache();
      if (this.currentMapData != null) {
         CoresManager.slowExecutor.execute(new Runnable() {
            public void run() {
               try {
                  if (Cutscene.this.currentMapData != null) {
                     RegionBuilder.destroyMap(Cutscene.this.currentMapData[0], Cutscene.this.currentMapData[1], Cutscene.this.currentMapData[1], Cutscene.this.currentMapData[2]);
                  }
               } catch (Throwable var2) {
                  var2.printStackTrace();
               }

            }
         });
      }

   }

   public final void startCutscene(Player player) {
      if (this.hiddenMinimap()) {
         player.getPackets().sendBlackOut(2);
      }

      player.getPackets().sendConfig(1241, 1);
      player.lock();
      player.stopAll(true, false);
   }

   public void constructArea(final Player player, final int baseChunkX, final int baseChunkY, final int widthChunks, final int heightChunks) {
      this.constructingRegion = true;
      player.getPackets().sendWindowsPane(56, 0);
      CoresManager.slowExecutor.execute(new Runnable() {
         public void run() {
            try {
               final int[] oldData = Cutscene.this.currentMapData;
               int[] mapBaseChunks = RegionBuilder.findEmptyChunkBound(widthChunks, heightChunks);
               RegionBuilder.copyAllPlanesMap(baseChunkX, baseChunkY, mapBaseChunks[0], mapBaseChunks[1], widthChunks, heightChunks);
               Cutscene.this.currentMapData = new int[]{mapBaseChunks[0], mapBaseChunks[1], widthChunks, heightChunks};
               player.setNextWorldTile(new WorldTile(Cutscene.this.getBaseX() + widthChunks * 4, Cutscene.this.getBaseY() + heightChunks * 4, 0));
               Cutscene.this.constructingRegion = false;
               if (Constants.DEBUG) {
                  System.out.println("Bases: " + Cutscene.this.getBaseX() + ", " + Cutscene.this.getBaseY());
               }

               WorldTasksManager.schedule(new WorldTask() {
                  public void run() {
                     CoresManager.slowExecutor.execute(new Runnable() {
                        public void run() {
                           player.getPackets().sendWindowsPane(player.getInterfaceManager().hasResizableScreen() ? 746 : 548, 0);
                           if (oldData != null) {
                              RegionBuilder.destroyMap(oldData[0], oldData[1], oldData[1], oldData[2]);
                           }

                        }
                     });
                  }
               }, 1);
            } catch (Throwable var3) {
               var3.printStackTrace();
            }

         }
      });
   }

   public int getLocalX(Player player, int x) {
      return this.currentMapData == null ? x : getX(player, this.getBaseX() + x);
   }

   public int getLocalY(Player player, int y) {
      return this.currentMapData == null ? y : getY(player, this.getBaseY() + y);
   }

   public int getBaseX() {
      return this.currentMapData == null ? 0 : this.currentMapData[0] << 3;
   }

   public int getBaseY() {
      return this.currentMapData == null ? 0 : this.currentMapData[1] << 3;
   }

   public final void logout(Player player) {
      this.stopCutscene(player);
   }

   public final boolean process(Player player) {
      if (this.delay > 0) {
         --this.delay;
         return true;
      } else {
         while(!this.constructingRegion) {
            if (this.stage == this.actions.length) {
               this.stopCutscene(player);
               return false;
            }

            if (this.stage == 0) {
               this.startCutscene(player);
            }

            CutsceneAction action = this.actions[this.stage++];
            action.process(player, this.cache);
            int delay = action.getActionDelay();
            if (delay != -1) {
               this.delay = delay;
               return true;
            }
         }

         return true;
      }
   }

   public void deleteCache() {
      Object[] var4;
      int var3 = (var4 = this.cache).length;

      for(int var2 = 0; var2 < var3; ++var2) {
         Object object = var4[var2];
         this.destroyCache(object);
      }

   }

   public void destroyCache(Object object) {
      if (object instanceof NPC) {
         NPC n = (NPC)object;
         n.finish();
      }

   }

   public final void createCache(Player player) {
      this.actions = this.getActions(player);
      this.endTile = new WorldTile(player);
      int lastIndex = 0;
      CutsceneAction[] var6;
      int var5 = (var6 = this.actions).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         CutsceneAction action = var6[var4];
         if (action.getCachedObjectIndex() > lastIndex) {
            lastIndex = action.getCachedObjectIndex();
         }
      }

      this.cache = new Object[lastIndex + 1];
      this.cache[0] = this;
   }

   public static int getX(Player player, int x) {
      return (new WorldTile(x, 0, 0)).getLocalX(player.getLastLoadedMapRegionTile(), player.getMapSize());
   }

   public static int getY(Player player, int y) {
      return (new WorldTile(0, y, 0)).getLocalY(player.getLastLoadedMapRegionTile(), player.getMapSize());
   }
}
