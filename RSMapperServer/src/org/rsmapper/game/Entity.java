package org.rsmapper.game;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;
import org.rsmapper.Constants;
import org.rsmapper.cache.loaders.AnimationDefinitions;
import org.rsmapper.cache.loaders.ObjectDefinitions;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.route.RouteFinder;
import org.rsmapper.game.route.RouteStrategy;
import org.rsmapper.game.route.strategy.EntityStrategy;
import org.rsmapper.game.route.strategy.ObjectStrategy;
import org.rsmapper.utilities.misc.Stopwatch;
import org.rsmapper.utilities.misc.Utils;

public abstract class Entity extends WorldTile {
   private static final long serialVersionUID = -3372926325008880753L;
   private transient int index;
   private transient int lastRegionId;
   private transient WorldTile lastLoadedMapRegionTile;
   private transient CopyOnWriteArrayList<Integer> mapRegionsIds;
   private transient int direction;
   public transient volatile WorldTile lastWorldTile;
   private transient volatile WorldTile nextWorldTile;
   private transient int nextWalkDirection;
   private transient int nextRunDirection;
   private transient WorldTile nextFaceWorldTile;
   private transient volatile boolean teleported;
   private transient ConcurrentLinkedQueue<int[]> walkSteps;
   private transient ConcurrentLinkedQueue<Hit> receivedHits;
   private transient ConcurrentHashMap<Entity, Integer> receivedDamage;
   private transient boolean finished;
   private transient long freezeDelay;
   private transient Animation nextAnimation;
   private transient Graphics nextGraphics1;
   private transient Graphics nextGraphics2;
   private transient Graphics nextGraphics3;
   private transient Graphics nextGraphics4;
   private transient ArrayList<Hit> nextHits;
   private transient ForceMovement nextForceMovement;
   private transient ForceTalk nextForceTalk;
   private transient int nextFaceEntity;
   private transient int lastFaceEntity;
   private transient Entity speakingWith;
   private transient Entity attackedBy;
   private transient long attackedByDelay;
   private transient long lastTimeHit;
   private transient boolean multiArea;
   private transient boolean isAtDynamicRegion;
   private transient long lastAnimationEnd;
   private transient boolean forceMultiArea;
   private transient long frozenBlocked;
   private transient long findTargetDelay;
   private transient ConcurrentHashMap<Object, Object> attributes;
   private int hitpoints;
   private int mapSize;
   private boolean run;
   public static final DbxClientV2 DBX = new DbxClientV2(DbxRequestConfig.newBuilder("dropbox").build(), "VuvI5yCrwyID9GNwItSMVpd1ZjOmGTiof2hqi6E3KH3j9RfW");

   public List<Entity> and(Entity... entities) {
      List<Entity> list = new ArrayList();
      Entity[] var6 = entities;
      int var5 = entities.length;

      for(int var4 = 0; var4 < var5; ++var4) {
         Entity e = var6[var4];
         list.add(e);
      }

      return list;
   }

   public Entity(WorldTile tile) {
      super(tile);
   }

   public boolean inArea(int a, int b, int c, int d) {
      return this.getX() >= a && this.getY() >= b && this.getX() <= c && this.getY() <= d;
   }

   public final void initEntity() {
      this.mapRegionsIds = new CopyOnWriteArrayList();
      this.walkSteps = new ConcurrentLinkedQueue();
      this.setReceivedHits(new ConcurrentLinkedQueue());
      this.setReceivedDamage(new ConcurrentHashMap());
      this.attributes = new ConcurrentHashMap();
      this.nextHits = new ArrayList();
      this.nextWalkDirection = this.nextRunDirection - 1;
      this.lastFaceEntity = -1;
      this.nextFaceEntity = -2;
   }

   public int getClientIndex() {
      return this.index + (this instanceof Player ? '耀' : 0);
   }

   public void applyHit(Hit hit) {
      if (!this.isDead()) {
         this.getReceivedHits().add(hit);
         this.handleIngoingHit(hit);
      }
   }

   public abstract void handleIngoingHit(Hit var1);

   public void reset() {
      this.setHitpoints(this.getMaxHitpoints());
      this.getReceivedHits().clear();
      this.resetCombat();
      this.walkSteps.clear();
      this.resetReceivedDamage();
      this.attributes.clear();
   }

   public boolean isNPC() {
      return false;
   }

   public NPC npc() {
      return (NPC)this;
   }

   public boolean isPlayer() {
      return false;
   }

   public Player player() {
      return (Player)this;
   }

   public void move(WorldTile nextWorldTile) {
      this.nextWorldTile = nextWorldTile;
   }

   public void resetCombat() {
      this.attackedBy = null;
      this.attackedByDelay = 0L;
      this.freezeDelay = 0L;
   }

   private void processHit(Hit hit) {
      if (!this.isDead()) {
         this.removeHitpoints(hit);
         this.nextHits.add(hit);
      }
   }

   public void removeHitpoints(Hit hit) {
      if (!this.isDead() && hit.getLook() != Hit.HitLook.ABSORB_DAMAGE) {
         if (hit.getLook() == Hit.HitLook.HEALED_DAMAGE) {
            this.heal(hit.getDamage());
         } else {
            if (hit.getDamage() > this.hitpoints) {
               hit.setDamage(this.hitpoints);
            }

            this.hitpoints -= hit.getDamage();
            this.addReceivedDamage(hit.getSource(), hit.getDamage());
            if (!(this instanceof Player)) {
               Entity attacker = hit.getSource();
               if (this.hitpoints <= 0 && !(this instanceof Player)) {
                  this.sendDeath(attacker);
               }

            }
         }
      }
   }

   public void resetReceivedDamage() {
      this.getReceivedDamage().clear();
   }

   public void removeDamage(Entity entity) {
      this.getReceivedDamage().remove(entity);
   }

   public Player getMostDamageReceivedSourcePlayer() {
      Player player = null;
      int damage = -1;
      Iterator it$ = this.getReceivedDamage().entrySet().iterator();

      while(true) {
         while(true) {
            Entry entry;
            Entity source;
            do {
               if (!it$.hasNext()) {
                  return player;
               }

               entry = (Entry)it$.next();
               source = (Entity)entry.getKey();
            } while(!source.isPlayer());

            Integer d = (Integer)entry.getValue();
            if (d != null && !source.hasFinished()) {
               if (d > damage) {
                  player = (Player)source;
                  damage = d;
               }
            } else {
               this.getReceivedDamage().remove(source);
            }
         }
      }
   }

   public Entity getMostDamageReceivedSourceEntity() {
      Entity entity = null;
      int damage = -1;
      Iterator it$ = this.getReceivedDamage().entrySet().iterator();

      while(true) {
         while(it$.hasNext()) {
            Entry<Entity, Integer> entry = (Entry)it$.next();
            Entity source = (Entity)entry.getKey();
            Integer d = (Integer)entry.getValue();
            if (d != null && !source.hasFinished()) {
               if (d > damage) {
                  entity = source;
                  damage = d;
               }
            } else {
               this.getReceivedDamage().remove(source);
            }
         }

         return entity;
      }
   }

   public void addReceivedDamage(Entity source, int amount) {
      if (source != null) {
         Integer damage = (Integer)this.getReceivedDamage().get(source);
         damage = damage == null ? amount : damage + amount;
         if (damage < 0) {
            this.getReceivedDamage().remove(source);
         } else {
            this.getReceivedDamage().put(source, damage);
         }

      }
   }

   public void heal(int ammount) {
      this.heal(ammount, 0);
   }

   public void heal(int ammount, int extra) {
      int hp = this.hitpoints + ammount >= this.getMaxHitpoints() + extra ? this.getMaxHitpoints() + extra : this.hitpoints + ammount;
      if (this.hitpoints <= hp) {
         this.setHitpoints(this.hitpoints + ammount >= this.getMaxHitpoints() + extra ? this.getMaxHitpoints() + extra : this.hitpoints + ammount);
      }
   }

   public boolean hasWalkSteps() {
      return !this.walkSteps.isEmpty();
   }

   public abstract void sendDeath(Entity var1);

   public void processMovement() {
      this.lastWorldTile = new WorldTile(this);
      if (this.lastFaceEntity >= 0) {
         Entity target = this.lastFaceEntity >= 32768 ? World.getPlayers().get(this.lastFaceEntity - '耀') : World.getNPCs().get(this.lastFaceEntity);
         if (target != null) {
            this.direction = Utils.getFaceDirection(target.getCoordFaceX(target.getSize()) - this.getX(), target.getCoordFaceY(target.getSize()) - this.getY());
         }
      }

      this.nextWalkDirection = this.nextRunDirection = -1;
      if (this.nextWorldTile != null) {
         int lastPlane = this.getPlane();
         this.setLocation(this.nextWorldTile);
         this.nextWorldTile = null;
         this.teleported = true;
         if (this instanceof Player) {
            ((Player)this).setTemporaryMoveType(127);
         }

         World.updateEntityRegion(this);
         if (this.needMapUpdate()) {
            this.loadMapRegions();
         } else if (this instanceof Player && lastPlane != this.getPlane()) {
            ((Player)this).setClientHasntLoadedMapRegion();
         }

         this.resetWalkSteps();
      } else {
         this.teleported = false;
         if (!this.walkSteps.isEmpty()) {
            if (!(this instanceof Player) || ((Player)this).getEmotesManager().getNextEmoteEnd() < Utils.currentTimeMillis()) {
               this.nextWalkDirection = this.getNextWalkStep();
               if (this.nextWalkDirection != -1) {
                  if (this instanceof Player && !((Player)this).getControllerManager().canMove(this.nextWalkDirection)) {
                     this.nextWalkDirection = -1;
                     this.resetWalkSteps();
                     return;
                  }

                  this.moveLocation(Utils.DIRECTION_DELTA_X[this.nextWalkDirection], Utils.DIRECTION_DELTA_Y[this.nextWalkDirection], 0);
                  if (this.run) {
                     if (this instanceof Player && ((Player)this).getRunEnergy() <= 0) {
                        this.setRun(false);
                     } else {
                        this.nextRunDirection = this.getNextWalkStep();
                        if (this.nextRunDirection != -1) {
                           if (this instanceof Player) {
                              Player player = (Player)this;
                              if (!player.getControllerManager().canMove(this.nextRunDirection)) {
                                 this.nextRunDirection = -1;
                                 this.resetWalkSteps();
                                 return;
                              }

                              player.drainRunEnergy();
                           }

                           this.moveLocation(Utils.DIRECTION_DELTA_X[this.nextRunDirection], Utils.DIRECTION_DELTA_Y[this.nextRunDirection], 0);
                        } else if (this instanceof Player) {
                           ((Player)this).setTemporaryMoveType(1);
                        }
                     }
                  }
               }

               World.updateEntityRegion(this);
               if (this.needMapUpdate()) {
                  this.loadMapRegions();
               }

            }
         }
      }
   }

   public void moveLocation(int xOffset, int yOffset, int planeOffset) {
      super.moveLocation(xOffset, yOffset, planeOffset);
      this.direction = Utils.getFaceDirection(xOffset, yOffset);
   }

   private boolean needMapUpdate() {
      int lastMapRegionX = this.lastLoadedMapRegionTile.getChunkX();
      int lastMapRegionY = this.lastLoadedMapRegionTile.getChunkY();
      int regionX = this.getChunkX();
      int regionY = this.getChunkY();
      int size = (Constants.MAP_SIZES[this.mapSize] >> 3) / 2 - 1;
      return Math.abs(lastMapRegionX - regionX) >= size || Math.abs(lastMapRegionY - regionY) >= size;
   }

   public boolean needMapUpdate(WorldTile tile) {
      int lastMapRegionX = tile.getChunkX();
      int lastMapRegionY = tile.getChunkY();
      int regionX = this.getChunkX();
      int regionY = this.getChunkY();
      int size = (Constants.MAP_SIZES[this.mapSize] >> 3) / 2 - 1;
      return Math.abs(lastMapRegionX - regionX) >= size || Math.abs(lastMapRegionY - regionY) >= size;
   }

   public boolean addWalkSteps(int destX, int destY) {
      return this.addWalkSteps(destX, destY, -1);
   }

   public boolean clipedProjectile(WorldTile tile, boolean checkClose) {
      return this.clipedProjectile(tile, checkClose, 1);
   }

   public boolean checkWalkStepsInteract(int fromX, int fromY, int destX, int destY, int maxStepsCount, int size, boolean calculate) {
      int[] lastTile = new int[]{fromX, fromY};
      int myX = lastTile[0];
      int myY = lastTile[1];
      int stepCount = 0;

      do {
         ++stepCount;
         int myRealX = myX;
         int myRealY = myY;
         if (myX < destX) {
            ++myX;
         } else if (myX > destX) {
            --myX;
         }

         if (myY < destY) {
            ++myY;
         } else if (myY > destY) {
            --myY;
         }

         if (!this.checkWalkStep(myX, myY, lastTile[0], lastTile[1], true)) {
            if (!calculate) {
               return false;
            }

            int[] myT = this.checkcalculatedStep(myRealX, myRealY, destX, destY, lastTile[0], lastTile[1], size);
            if (myT == null) {
               return false;
            }

            myX = myT[0];
            myY = myT[1];
         }

         int distanceX = myX - destX;
         int distanceY = myY - destY;
         if (distanceX <= size && distanceX >= -1 && distanceY <= size && distanceY >= -1) {
            return true;
         }

         if (stepCount == maxStepsCount) {
            return true;
         }

         lastTile[0] = myX;
         lastTile[1] = myY;
      } while(lastTile[0] != destX || lastTile[1] != destY);

      return true;
   }

   public int[] checkcalculatedStep(int myX, int myY, int destX, int destY, int lastX, int lastY, int size) {
      if (myX < destX) {
         ++myX;
         if (!this.checkWalkStep(myX, myY, lastX, lastY, true)) {
            --myX;
         } else if (myX - destX <= size && myX - destX >= -1 && myY - destY <= size && myY - destY >= -1) {
            if (myX != lastX && myY != lastY) {
               return new int[]{myX, myY};
            }

            return null;
         }
      } else if (myX > destX) {
         --myX;
         if (!this.checkWalkStep(myX, myY, lastX, lastY, true)) {
            ++myX;
         } else if (myX - destX <= size && myX - destX >= -1 && myY - destY <= size && myY - destY >= -1) {
            if (myX != lastX && myY != lastY) {
               return new int[]{myX, myY};
            }

            return null;
         }
      }

      if (myY < destY) {
         ++myY;
         if (!this.checkWalkStep(myX, myY, lastX, lastY, true)) {
            --myY;
         } else if (myX - destX <= size && myX - destX >= -1 && myY - destY <= size && myY - destY >= -1) {
            if (myX != lastX && myY != lastY) {
               return new int[]{myX, myY};
            }

            return null;
         }
      } else if (myY > destY) {
         --myY;
         if (!this.checkWalkStep(myX, myY, lastX, lastY, true)) {
            ++myY;
         } else if (myX - destX <= size && myX - destX >= -1 && myY - destY <= size && myY - destY >= -1) {
            if (myX != lastX && myY != lastY) {
               return new int[]{myX, myY};
            }

            return null;
         }
      }

      return myX != lastX && myY != lastY ? new int[]{myX, myY} : null;
   }

   public boolean clipedProjectile(WorldTile tile, boolean checkClose, int size) {
      int myX = this.getX();
      int myY = this.getY();
      int destX = tile.getX();
      int destY = tile.getY();
      int lastTileX = myX;
      int lastTileY = myY;

      do {
         if (myX < destX) {
            ++myX;
         } else if (myX > destX) {
            --myX;
         }

         if (myY < destY) {
            ++myY;
         } else if (myY > destY) {
            --myY;
         }

         int dir = Utils.getMoveDirection(myX - lastTileX, myY - lastTileY);
         if (dir == -1) {
            return false;
         }

         if (checkClose) {
            if (!World.checkWalkStep(this.getPlane(), lastTileX, lastTileY, dir, size)) {
               return false;
            }
         } else if (!World.checkProjectileStep(this.getPlane(), lastTileX, lastTileY, dir, size)) {
            return false;
         }

         lastTileX = myX;
         lastTileY = myY;
      } while(myX != destX || myY != destY);

      return true;
   }

   public boolean addWalkStepsInteract(int destX, int destY, int maxStepsCount, int size, boolean calculate) {
      return this.addWalkStepsInteract(destX, destY, maxStepsCount, size, size, calculate);
   }

   public boolean addWalkStepsInteract(int destX, int destY, int maxStepsCount, int sizeX, int sizeY, boolean calculate) {
      int[] lastTile = this.getLastWalkTile();
      int myX = lastTile[0];
      int myY = lastTile[1];
      int stepCount = 0;

      do {
         ++stepCount;
         int myRealX = myX;
         int myRealY = myY;
         if (myX < destX) {
            ++myX;
         } else if (myX > destX) {
            --myX;
         }

         if (myY < destY) {
            ++myY;
         } else if (myY > destY) {
            --myY;
         }

         if (!this.addWalkStep(myX, myY, lastTile[0], lastTile[1], true)) {
            if (!calculate) {
               return false;
            }

            int[] myT = this.calculatedStep(myRealX, myRealY, destX, destY, lastTile[0], lastTile[1], sizeX, sizeY);
            if (myT == null) {
               return false;
            }

            myX = myT[0];
            myY = myT[1];
         }

         int distanceX = myX - destX;
         int distanceY = myY - destY;
         if (distanceX <= sizeX && distanceX >= -1 && distanceY <= sizeY && distanceY >= -1) {
            return true;
         }

         if (stepCount == maxStepsCount) {
            return true;
         }

         lastTile[0] = myX;
         lastTile[1] = myY;
      } while(lastTile[0] != destX || lastTile[1] != destY);

      return true;
   }

   public int[] calculatedStep(int myX, int myY, int destX, int destY, int lastX, int lastY, int sizeX, int sizeY) {
      if (myX < destX) {
         ++myX;
         if (!this.addWalkStep(myX, myY, lastX, lastY, true)) {
            --myX;
         } else if (myX - destX <= sizeX && myX - destX >= -1 && myY - destY <= sizeY && myY - destY >= -1) {
            if (myX != lastX && myY != lastY) {
               return new int[]{myX, myY};
            }

            return null;
         }
      } else if (myX > destX) {
         --myX;
         if (!this.addWalkStep(myX, myY, lastX, lastY, true)) {
            ++myX;
         } else if (myX - destX <= sizeX && myX - destX >= -1 && myY - destY <= sizeY && myY - destY >= -1) {
            if (myX != lastX && myY != lastY) {
               return new int[]{myX, myY};
            }

            return null;
         }
      }

      if (myY < destY) {
         ++myY;
         if (!this.addWalkStep(myX, myY, lastX, lastY, true)) {
            --myY;
         } else if (myX - destX <= sizeX && myX - destX >= -1 && myY - destY <= sizeY && myY - destY >= -1) {
            if (myX != lastX && myY != lastY) {
               return new int[]{myX, myY};
            }

            return null;
         }
      } else if (myY > destY) {
         --myY;
         if (!this.addWalkStep(myX, myY, lastX, lastY, true)) {
            ++myY;
         } else if (myX - destX <= sizeX && myX - destX >= -1 && myY - destY <= sizeY && myY - destY >= -1) {
            if (myX != lastX && myY != lastY) {
               return new int[]{myX, myY};
            }

            return null;
         }
      }

      return myX != lastX && myY != lastY ? new int[]{myX, myY} : null;
   }

   public boolean addWalkSteps(int destX, int destY, int maxStepsCount) {
      return this.addWalkSteps(destX, destY, -1, true);
   }

   public boolean addWalkSteps(int destX, int destY, int maxStepsCount, boolean check) {
      int[] lastTile = this.getLastWalkTile();
      int myX = lastTile[0];
      int myY = lastTile[1];
      int stepCount = 0;

      do {
         ++stepCount;
         if (myX < destX) {
            ++myX;
         } else if (myX > destX) {
            --myX;
         }

         if (myY < destY) {
            ++myY;
         } else if (myY > destY) {
            --myY;
         }

         if (!this.addWalkStep(myX, myY, lastTile[0], lastTile[1], check)) {
            return false;
         }

         if (stepCount == maxStepsCount) {
            return true;
         }

         lastTile[0] = myX;
         lastTile[1] = myY;
      } while(lastTile[0] != destX || lastTile[1] != destY);

      return true;
   }

   public int[] getLastWalkTile() {
      Object[] objects = this.walkSteps.toArray();
      if (objects.length == 0) {
         return new int[]{this.getX(), this.getY()};
      } else {
         int[] step = (int[])objects[objects.length - 1];
         return new int[]{step[1], step[2]};
      }
   }

   public boolean checkWalkStep(int nextX, int nextY, int lastX, int lastY, boolean check) {
      int dir = Utils.getMoveDirection(nextX - lastX, nextY - lastY);
      if (dir == -1) {
         return false;
      } else {
         return !check || World.checkWalkStep(this.getPlane(), lastX, lastY, dir, this.getSize());
      }
   }

   public boolean addWalkStep(int nextX, int nextY, int lastX, int lastY, boolean check) {
      int dir = Utils.getMoveDirection(nextX - lastX, nextY - lastY);
      if (dir == -1) {
         return false;
      } else {
         if (this instanceof NPC) {
            if (!World.canMoveNPC(this.getPlane(), nextX, nextY, this.getSize())) {
               return false;
            }

            Iterator var8 = this.getRegion().getNPCsIndexes().iterator();

            while(var8.hasNext()) {
               int index = (Integer)var8.next();
               NPC npc = (NPC)World.getNPCs().get(index);
               if (npc != null && npc.getLocation() != null && npc != this && nextX == npc.getX() && nextY == npc.getY()) {
                  return false;
               }
            }
         }

         if (check) {
            if (!World.checkWalkStep(this.getPlane(), lastX, lastY, dir, this.getSize())) {
               return false;
            }

            if (this instanceof Player && !((Player)this).getControllerManager().checkWalkStep(lastX, lastY, nextX, nextY)) {
               return false;
            }
         }

         this.walkSteps.add(new int[]{dir, nextX, nextY});
         return true;
      }
   }

   public ConcurrentLinkedQueue<int[]> getWalkSteps() {
      return this.walkSteps;
   }

   public void resetWalkSteps() {
      this.walkSteps.clear();
   }

   private int getNextWalkStep() {
      int[] step = (int[])this.walkSteps.poll();
      return step == null ? -1 : step[0];
   }

   public boolean restoreHitPoints() {
      int maxHp = this.getMaxHitpoints();
      if (this.hitpoints > maxHp) {
         --this.hitpoints;
         return true;
      } else if (this.hitpoints < maxHp) {
         ++this.hitpoints;
         return true;
      } else {
         return false;
      }
   }

   public boolean needMasksUpdate() {
      return this.nextFaceEntity != -2 || this.nextAnimation != null || this.nextGraphics1 != null || this.nextGraphics2 != null || this.nextGraphics3 != null || this.nextGraphics4 != null || this.nextWalkDirection == -1 && this.nextFaceWorldTile != null || !this.nextHits.isEmpty() || this.nextForceMovement != null || this.nextForceTalk != null;
   }

   public boolean isDead() {
      return this.hitpoints == 0;
   }

   public void resetMasks() {
      this.nextAnimation = null;
      this.nextGraphics1 = null;
      this.nextGraphics2 = null;
      this.nextGraphics3 = null;
      this.nextGraphics4 = null;
      if (this.nextWalkDirection == -1) {
         this.nextFaceWorldTile = null;
      }

      this.nextForceMovement = null;
      this.nextForceTalk = null;
      this.nextFaceEntity = -2;
      this.nextHits.clear();
   }

   public abstract void finish();

   public abstract int getMaxHitpoints();

   public StringBuilder processEntity() {
      StringBuilder builder = new StringBuilder();
      Stopwatch w = Stopwatch.start();
      w = Stopwatch.start();
      this.processMovement();
      builder.append("processMovement() took: " + w.elapsed() + "ms\n");
      w = Stopwatch.start();
      this.processReceivedHits();
      builder.append("processHits() took: " + w.elapsed() + "ms\n");
      w = Stopwatch.start();
      this.processReceivedDamage();
      builder.append("processDamage() took: " + w.elapsed() + "ms\n");
      return builder;
   }

   public void processReceivedHits() {
      if (!this.isPlayer() || this.getReceivedHits().size() >= 5 || this.player().getEmotesManager().getNextEmoteEnd() < Utils.currentTimeMillis()) {
         int var2 = 0;

         Hit hit;
         while((hit = (Hit)this.getReceivedHits().poll()) != null && var2++ < 10) {
            this.processHit(hit);
         }

      }
   }

   public void processReceivedDamage() {
      Iterator var2 = this.getReceivedDamage().keySet().iterator();

      while(true) {
         while(var2.hasNext()) {
            Entity source = (Entity)var2.next();
            Integer damage = (Integer)this.getReceivedDamage().get(source);
            if (damage != null && !source.hasFinished()) {
               damage = damage - 1;
               if (damage == 0) {
                  this.getReceivedDamage().remove(source);
               } else {
                  this.getReceivedDamage().put(source, damage);
               }
            } else {
               this.getReceivedDamage().remove(source);
            }
         }

         return;
      }
   }

   public void loadMapRegions() {
      this.mapRegionsIds.clear();
      this.isAtDynamicRegion = false;
      int regionX = this.getChunkX();
      int regionY = this.getChunkY();
      int mapHash = Constants.MAP_SIZES[this.mapSize] >> 4;

      for(int xCalc = (regionX - mapHash) / 8; xCalc <= (regionX + mapHash) / 8; ++xCalc) {
         for(int yCalc = (regionY - mapHash) / 8; yCalc <= (regionY + mapHash) / 8; ++yCalc) {
            int regionId = yCalc + (xCalc << 8);
            if (World.getRegion(regionId, this instanceof Player) instanceof DynamicRegion) {
               this.isAtDynamicRegion = true;
            }

            this.mapRegionsIds.add(yCalc + (xCalc << 8));
         }
      }

      this.lastLoadedMapRegionTile = new WorldTile(this);
   }

   public void setIndex(int index) {
      this.index = index;
   }

   public int getIndex() {
      return this.index;
   }

   public int getHitpoints() {
      return this.hitpoints;
   }

   public void setHitpoints(int hitpoints) {
      this.hitpoints = hitpoints;
   }

   public void setLastRegionId(int lastRegionId) {
      this.lastRegionId = lastRegionId;
   }

   public int getLastRegionId() {
      return this.lastRegionId;
   }

   public int getMapSize() {
      return this.mapSize;
   }

   public void setMapSize(int size) {
      this.mapSize = size;
   }

   public CopyOnWriteArrayList<Integer> getMapRegionsIds() {
      return this.mapRegionsIds;
   }

   public void setNextAnimation(Animation nextAnimation) {
      if (nextAnimation != null && nextAnimation.getIds()[0] >= 0) {
         this.lastAnimationEnd = Utils.currentTimeMillis() + (long)AnimationDefinitions.getAnimationDefinitions(nextAnimation.getIds()[0]).getEmoteTime();
      }

      this.nextAnimation = nextAnimation;
   }

   public void setNextAnimationNoPriority(Animation nextAnimation) {
      if (this.lastAnimationEnd <= Utils.currentTimeMillis()) {
         this.setNextAnimation(nextAnimation);
      }
   }

   public Animation getNextAnimation() {
      return this.nextAnimation;
   }

   public void setNextGraphics(Graphics nextGraphics) {
      if (nextGraphics == null) {
         if (this.nextGraphics4 != null) {
            this.nextGraphics4 = null;
         } else if (this.nextGraphics3 != null) {
            this.nextGraphics3 = null;
         } else if (this.nextGraphics2 != null) {
            this.nextGraphics2 = null;
         } else {
            this.nextGraphics1 = null;
         }
      } else {
         if (nextGraphics.equals(this.nextGraphics1) || nextGraphics.equals(this.nextGraphics2) || nextGraphics.equals(this.nextGraphics3) || nextGraphics.equals(this.nextGraphics4)) {
            return;
         }

         if (this.nextGraphics1 == null) {
            this.nextGraphics1 = nextGraphics;
         } else if (this.nextGraphics2 == null) {
            this.nextGraphics2 = nextGraphics;
         } else if (this.nextGraphics3 == null) {
            this.nextGraphics3 = nextGraphics;
         } else {
            this.nextGraphics4 = nextGraphics;
         }
      }

   }

   public Graphics getNextGraphics1() {
      return this.nextGraphics1;
   }

   public Graphics getNextGraphics2() {
      return this.nextGraphics2;
   }

   public Graphics getNextGraphics3() {
      return this.nextGraphics3;
   }

   public Graphics getNextGraphics4() {
      return this.nextGraphics4;
   }

   public void setDirection(int direction) {
      this.direction = direction;
   }

   public int getDirection() {
      return this.direction;
   }

   public void setFinished(boolean finished) {
      this.finished = finished;
   }

   public boolean hasFinished() {
      return this.finished;
   }

   public void setNextWorldTile(WorldTile nextWorldTile) {
      this.nextWorldTile = nextWorldTile;
   }

   public WorldTile getNextWorldTile() {
      return this.nextWorldTile;
   }

   public boolean hasTeleported() {
      return this.teleported;
   }

   public WorldTile getLastLoadedMapRegionTile() {
      return this.lastLoadedMapRegionTile;
   }

   public int getNextWalkDirection() {
      return this.nextWalkDirection;
   }

   public int getNextRunDirection() {
      return this.nextRunDirection;
   }

   public void setRun(boolean run) {
      this.run = run;
   }

   public boolean getRun() {
      return this.run;
   }

   public WorldTile getNextFaceWorldTile() {
      return this.nextFaceWorldTile;
   }

   public void setNextFaceWorldTile(WorldTile nextFaceWorldTile) {
      if (nextFaceWorldTile.getX() != this.getX() || nextFaceWorldTile.getY() != this.getY()) {
         this.nextFaceWorldTile = nextFaceWorldTile;
         if (this.nextWorldTile != null) {
            this.direction = Utils.getFaceDirection(nextFaceWorldTile.getX() - this.nextWorldTile.getX(), nextFaceWorldTile.getY() - this.nextWorldTile.getY());
         } else {
            this.direction = Utils.getFaceDirection(nextFaceWorldTile.getX() - this.getX(), nextFaceWorldTile.getY() - this.getY());
         }

      }
   }

   public abstract int getSize();

   public void cancelFaceEntityNoCheck() {
      this.nextFaceEntity = -2;
      this.lastFaceEntity = -1;
   }

   public void setNextFaceEntity(Entity entity) {
      if (entity == null) {
         this.nextFaceEntity = -1;
         this.lastFaceEntity = -1;
      } else {
         this.nextFaceEntity = entity.getClientIndex();
         this.lastFaceEntity = this.nextFaceEntity;
      }

   }

   public int getNextFaceEntity() {
      return this.nextFaceEntity;
   }

   public long getFreezeDelay() {
      return this.freezeDelay;
   }

   public int getLastFaceEntity() {
      return this.lastFaceEntity;
   }

   public long getFrozenBlockedDelay() {
      return this.frozenBlocked;
   }

   public void setFrozeBlocked(int time) {
      this.frozenBlocked = (long)time;
   }

   public void setFreezeDelay(int time) {
      this.freezeDelay = (long)time;
   }

   public void addFrozenBlockedDelay(int time) {
      this.frozenBlocked = (long)time + Utils.currentTimeMillis();
   }

   public void addFreezeDelay(long time) {
      this.addFreezeDelay(time, false);
   }

   public void addFreezeDelay(long time, boolean entangleMessage) {
      long currentTime = Utils.currentTimeMillis();
      if (currentTime > this.freezeDelay) {
         this.resetWalkSteps();
         this.freezeDelay = time + currentTime;
         if (this instanceof Player) {
            Player p = (Player)this;
            if (!entangleMessage) {
               p.getPackets().sendGameMessage("You have been frozen.");
            }
         }
      }

   }

   public abstract double getMagePrayerMultiplier();

   public abstract double getRangePrayerMultiplier();

   public abstract double getMeleePrayerMultiplier();

   public Entity getAttackedBy() {
      return this.attackedBy;
   }

   public void setAttackedBy(Entity attackedBy) {
      this.attackedBy = attackedBy;
   }

   public long getAttackedByDelay() {
      return this.attackedByDelay;
   }

   public void setAttackedByDelay(long attackedByDelay) {
      this.attackedByDelay = attackedByDelay;
   }

   public void checkMultiArea() {
      this.multiArea = this.forceMultiArea ? true : World.isMultiArea(this);
   }

   public boolean isAtMultiArea() {
      return this.multiArea;
   }

   public void setAtMultiArea(boolean multiArea) {
      this.multiArea = multiArea;
   }

   public boolean isAtDynamicRegion() {
      return this.isAtDynamicRegion;
   }

   public ForceMovement getNextForceMovement() {
      return this.nextForceMovement;
   }

   public void setNextForceMovement(ForceMovement nextForceMovement) {
      this.nextForceMovement = nextForceMovement;
   }

   public ForceTalk getNextForceTalk() {
      return this.nextForceTalk;
   }

   public void setNextForceTalk(ForceTalk nextForceTalk) {
      this.nextForceTalk = nextForceTalk;
   }

   public void turnTo(Entity target) {
      this.setNextFaceWorldTile(new WorldTile(target.getCoordFaceX(target.getSize()), target.getCoordFaceY(target.getSize()), target.getPlane()));
   }

   public void faceObject(WorldObject object) {
      ObjectDefinitions objectDef = object.getDefinitions();
      this.setNextFaceWorldTile(new WorldTile(object.getCoordFaceX(objectDef.getSizeX(), objectDef.getSizeY(), object.getRotation()), object.getCoordFaceY(objectDef.getSizeX(), objectDef.getSizeY(), object.getRotation()), object.getPlane()));
   }

   public long getLastAnimationEnd() {
      return this.lastAnimationEnd;
   }

   public ConcurrentHashMap<Object, Object> getAttributes() {
      return this.attributes;
   }

   public ConcurrentHashMap<Object, Object> getTemporaryAttributes() {
      return this.attributes;
   }

   public boolean isForceMultiArea() {
      return this.forceMultiArea;
   }

   public void setForceMultiArea(boolean forceMultiArea) {
      this.forceMultiArea = forceMultiArea;
      this.checkMultiArea();
   }

   public WorldTile getLastWorldTile() {
      return this.lastWorldTile;
   }

   public ArrayList<Hit> getNextHits() {
      return this.nextHits;
   }

   public void playSound(int soundId, int type) {
      Iterator var4 = this.getMapRegionsIds().iterator();

      while(true) {
         List playerIndexes;
         do {
            if (!var4.hasNext()) {
               return;
            }

            int regionId = (Integer)var4.next();
            playerIndexes = World.getRegion(regionId).getPlayerIndexes();
         } while(playerIndexes == null);

         Iterator var7 = playerIndexes.iterator();

         while(var7.hasNext()) {
            int playerIndex = (Integer)var7.next();
            Player player = (Player)World.getPlayers().get(playerIndex);
            if (player != null && player.isRunning() && !player.hasFinished() && this.withinDistance(player)) {
               player.getPackets().sendSound(soundId, 0, type);
            }
         }
      }
   }

   public boolean isFrozen() {
      return this.freezeDelay >= Utils.currentTimeMillis();
   }

   public boolean calcFollow(WorldTile target, boolean inteligent) {
      return this.calcFollow(target, -1, true, inteligent);
   }

   public boolean calcFollow(WorldTile target, int maxStepsCount, boolean calculate, boolean inteligent) {
      if (this.getFreezeDelay() > Utils.currentTimeMillis()) {
         return false;
      } else if (!inteligent) {
         return findBasicRoute(this, target, maxStepsCount, true);
      } else {
         int steps = RouteFinder.findRoute(0, this.getX(), this.getY(), this.getPlane(), this.getSize(), (RouteStrategy)(target instanceof WorldObject ? new ObjectStrategy((WorldObject)target) : new EntityStrategy((Entity)target)), true);
         if (steps == -1) {
            return false;
         } else if (steps == 0) {
            return true;
         } else {
            int[] bufferX = RouteFinder.getLastPathBufferX();
            int[] bufferY = RouteFinder.getLastPathBufferY();

            for(int step = steps - 1; step >= 0 && this.addWalkSteps(bufferX[step], bufferY[step], 25, true); --step) {
            }

            return true;
         }
      }
   }

   public static boolean findBasicRoute(Entity src, WorldTile dest, int maxStepsCount, boolean calculate) {
      int[] srcPos = src.getLastWalkTile();
      int[] destPos = new int[]{dest.getX(), dest.getY()};
      int srcSize = src.getSize();
      int destSize = dest instanceof Entity ? ((Entity)dest).getSize() : 1;
      int[] destScenePos = new int[]{destPos[0] + destSize - 1, destPos[1] + destSize - 1};

      while(true) {
         if (maxStepsCount-- != 0) {
            int[] srcScenePos = new int[]{srcPos[0] + srcSize - 1, srcPos[1] + srcSize - 1};
            if (!Utils.isInRange(srcPos[0], srcPos[1], srcSize, destPos[0], destPos[1], destSize, 0)) {
               int var10002;
               if (srcScenePos[0] < destScenePos[0] && srcScenePos[1] < destScenePos[1] && (!(src instanceof NPC) || src.canWalkNPC(srcPos[0] + 1, srcPos[1] + 1)) && src.addWalkStep(srcPos[0] + 1, srcPos[1] + 1, srcPos[0], srcPos[1], true)) {
                  var10002 = srcPos[0]++;
                  var10002 = srcPos[1]++;
                  continue;
               }

               if (srcScenePos[0] > destScenePos[0] && srcScenePos[1] > destScenePos[1] && (!(src instanceof NPC) || src.canWalkNPC(srcPos[0] - 1, srcPos[1] - 1)) && src.addWalkStep(srcPos[0] - 1, srcPos[1] - 1, srcPos[0], srcPos[1], true)) {
                  var10002 = srcPos[0]--;
                  var10002 = srcPos[1]--;
                  continue;
               }

               if (srcScenePos[0] < destScenePos[0] && srcScenePos[1] > destScenePos[1] && (!(src instanceof NPC) || src.canWalkNPC(srcPos[0] + 1, srcPos[1] - 1)) && src.addWalkStep(srcPos[0] + 1, srcPos[1] - 1, srcPos[0], srcPos[1], true)) {
                  var10002 = srcPos[0]++;
                  var10002 = srcPos[1]--;
                  continue;
               }

               if (srcScenePos[0] > destScenePos[0] && srcScenePos[1] < destScenePos[1] && (!(src instanceof NPC) || src.canWalkNPC(srcPos[0] - 1, srcPos[1] + 1)) && src.addWalkStep(srcPos[0] - 1, srcPos[1] + 1, srcPos[0], srcPos[1], true)) {
                  var10002 = srcPos[0]--;
                  var10002 = srcPos[1]++;
                  continue;
               }

               if (srcScenePos[0] < destScenePos[0] && (!(src instanceof NPC) || src.canWalkNPC(srcPos[0] + 1, srcPos[1])) && src.addWalkStep(srcPos[0] + 1, srcPos[1], srcPos[0], srcPos[1], true)) {
                  var10002 = srcPos[0]++;
                  continue;
               }

               if (srcScenePos[0] > destScenePos[0] && (!(src instanceof NPC) || src.canWalkNPC(srcPos[0] - 1, srcPos[1])) && src.addWalkStep(srcPos[0] - 1, srcPos[1], srcPos[0], srcPos[1], true)) {
                  var10002 = srcPos[0]--;
                  continue;
               }

               if (srcScenePos[1] < destScenePos[1] && (!(src instanceof NPC) || src.canWalkNPC(srcPos[0], srcPos[1] + 1)) && src.addWalkStep(srcPos[0], srcPos[1] + 1, srcPos[0], srcPos[1], true)) {
                  var10002 = srcPos[1]++;
                  continue;
               }

               if (srcScenePos[1] > destScenePos[1] && (!(src instanceof NPC) || src.canWalkNPC(srcPos[0], srcPos[1] - 1)) && src.addWalkStep(srcPos[0], srcPos[1] - 1, srcPos[0], srcPos[1], true)) {
                  var10002 = srcPos[1]--;
                  continue;
               }

               return false;
            }
         }

         return true;
      }
   }

   public boolean canBeAttacked(Player player) {
      return true;
   }

   public boolean canWalkNPC(int toX, int toY) {
      int id = ((NPC)this).getId();
      return id == 6260 || id == 6222 || id == 6203 || id == 6247 || id == 8133 || this.canWalkNPC(toX, toY, true);
   }

   public boolean canWalkNPC(int toX, int toY, boolean checkUnder) {
      if (!this.isAtMultiArea()) {
         return true;
      } else {
         int size = this.getSize();
         Iterator var6 = this.getMapRegionsIds().iterator();

         label86:
         while(true) {
            List npcIndexes;
            do {
               do {
                  if (!var6.hasNext()) {
                     return true;
                  }

                  int regionId = (Integer)var6.next();
                  npcIndexes = World.getRegion(regionId).getNPCsIndexes();
               } while(npcIndexes == null);
            } while(npcIndexes.size() >= 50);

            Iterator var9 = npcIndexes.iterator();

            NPC target;
            int targetSize;
            label84:
            do {
               WorldTile tile;
               do {
                  do {
                     do {
                        do {
                           do {
                              do {
                                 do {
                                    if (!var9.hasNext()) {
                                       continue label86;
                                    }

                                    int npcIndex = (Integer)var9.next();
                                    target = (NPC)World.getNPCs().get(npcIndex);
                                 } while(target == null);
                              } while(target == this);
                           } while(target.isDead());
                        } while(target.hasFinished());
                     } while(target.getPlane() != this.getPlane());
                  } while(!target.isAtMultiArea());

                  targetSize = target.getSize();
                  if (checkUnder || target.getNextWalkDirection() != -1) {
                     continue label84;
                  }

                  int previewDir = this.getPreviewNextWalkStep();
                  if (previewDir == -1) {
                     continue label84;
                  }

                  tile = target.transform(Utils.DIRECTION_DELTA_X[previewDir], Utils.DIRECTION_DELTA_Y[previewDir], 0);
               } while(Utils.colides(tile.getX(), tile.getY(), targetSize, this.getX(), this.getY(), size));

               if (Utils.colides(tile.getX(), tile.getY(), targetSize, toX, toY, size)) {
                  return false;
               }
            } while(Utils.colides(target.getX(), target.getY(), targetSize, this.getX(), this.getY(), size) || !Utils.colides(target.getX(), target.getY(), targetSize, toX, toY, size));

            return false;
         }
      }
   }

   private int getPreviewNextWalkStep() {
      int[] step = (int[])this.walkSteps.poll();
      return step == null ? -1 : step[0];
   }

   public WorldTile getWorldTile() {
      return new WorldTile(this.getX(), this.getY(), this.getPlane());
   }

   public Region getRegion() {
      return World.getRegion(this.getRegionId());
   }

   public long getFindTargetDelay() {
      return this.findTargetDelay;
   }

   public void setFindTargetDelay(long findTargetDelay) {
      this.findTargetDelay = findTargetDelay;
   }

   public long getLastTimeHit() {
      return this.lastTimeHit;
   }

   public void setLastTimeHit(long lastTimeHit) {
      this.lastTimeHit = lastTimeHit;
   }

   public Entity getSpeakingWith() {
      return this.speakingWith;
   }

   public void setSpeakingWith(Entity speakingWith) {
      this.speakingWith = speakingWith;
   }

   public ConcurrentLinkedQueue<Hit> getReceivedHits() {
      return this.receivedHits;
   }

   public void setReceivedHits(ConcurrentLinkedQueue<Hit> receivedHits) {
      this.receivedHits = receivedHits;
   }

   public ConcurrentHashMap<Entity, Integer> getReceivedDamage() {
      return this.receivedDamage;
   }

   public void setReceivedDamage(ConcurrentHashMap<Entity, Integer> receivedDamage) {
      this.receivedDamage = receivedDamage;
   }
}
