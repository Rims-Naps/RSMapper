package org.rsmapper.game.npc;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.rsmapper.cache.loaders.NPCDefinitions;
import org.rsmapper.engine.CoresManager;
import org.rsmapper.game.Animation;
import org.rsmapper.game.Entity;
import org.rsmapper.game.Graphics;
import org.rsmapper.game.Hit;
import org.rsmapper.game.SecondaryBar;
import org.rsmapper.game.World;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTask;
import org.rsmapper.game.tasks.WorldTasksManager;
import org.rsmapper.utilities.misc.Utils;

public class NPC extends Entity implements Serializable {
   private static final long serialVersionUID = -4794678936277614443L;
   public static int NO_WALK = 0;
   public static int NORMAL_WALK = 2;
   public static int WATER_WALK = 4;
   public static int FLY_WALK = 8;
   private int id;
   private WorldTile respawnTile;
   private WorldTile startTile;
   private int mapAreaNameHash;
   private boolean canBeAttackFromOutOfArea;
   private boolean randomwalk;
   private int[] bonuses;
   private boolean spawned;
   private WorldTile forceWalk;
   private long lastAttackedByTarget;
   private boolean cantInteract;
   private int capDamage;
   private int lureDelay;
   private int respawnDelay;
   private boolean cantFollowUnderCombat;
   private boolean forceAgressive;
   private int forceTargetDistance;
   private boolean forceFollowClose;
   private int walkType;
   private boolean forceMultiAttacked;
   private String customName;
   private boolean intelligentRouteFinder;
   private transient SecondaryBar nextSecondaryBar;
   private String name;
   private transient boolean changedName;
   private int combatLevel;
   private transient boolean changedCombatLevel;
   private transient NPCDefinitions definitions;

   public NPC(int id, WorldTile tile, int mapAreaNameHash, boolean canBeAttackFromOutOfArea) {
      this(id, tile, mapAreaNameHash, canBeAttackFromOutOfArea, false, -1);
   }

   public NPC(int id, WorldTile tile, int mapAreaNameHash, boolean canBeAttackFromOutOfArea, boolean spawned) {
      this(id, tile, mapAreaNameHash, canBeAttackFromOutOfArea, spawned, -1);
   }

   public NPC(int id, WorldTile tile, int mapAreaNameHash, boolean canBeAttackFromOutOfArea, boolean spawned, int respawnDelay) {
      super(tile);
      this.id = id;
      this.respawnTile = new WorldTile(tile);
      this.mapAreaNameHash = mapAreaNameHash;
      this.canBeAttackFromOutOfArea = canBeAttackFromOutOfArea;
      this.setSpawned(spawned);
      this.setDefinitions(NPCDefinitions.getNPCDefinitions(id));
      this.combatLevel = -1;
      this.setStartTile(tile);
      this.setHitpoints(this.getMaxHitpoints());
      this.setDirection(0);
      this.capDamage = -1;
      this.lureDelay = 12000;
      this.respawnDelay = respawnDelay;
      this.initEntity();
      World.addNPC(this);
      World.updateEntityRegion(this);
      this.loadMapRegions();
      this.checkMultiArea();
   }

   public boolean needMasksUpdate() {
      return super.needMasksUpdate() || this.nextSecondaryBar != null || this.changedCombatLevel || this.changedName;
   }

   public void setNextNPCTransformation(NPC npc) {
      this.setNPC(npc.getId());
   }

   public void transformInto(int id) {
      this.setNPC(id);
   }

   public void setNPC(int id) {
      this.id = id;
      this.setDefinitions(NPCDefinitions.getNPCDefinitions(id));
   }

   public void resetMasks() {
      super.resetMasks();
      this.changedCombatLevel = false;
      this.changedName = false;
      this.nextSecondaryBar = null;
   }

   public int getMapAreaNameHash() {
      return this.mapAreaNameHash;
   }

   public boolean canBeAttackFromOutOfArea() {
      return this.canBeAttackFromOutOfArea;
   }

   public NPCDefinitions getDefinitions() {
      if (this.definitions == null) {
         this.definitions = NPCDefinitions.getNPCDefinitions(this.id);
      }

      return this.definitions;
   }

   public int getMaxHitpoints() {
      return 10000;
   }

   public int getId() {
      return this.id;
   }

   public void processNPC() {
      if (!this.isDead()) {
         try {
            if (this.customName != null) {
               this.setName(this.customName);
            }
         } catch (Exception var2) {
            System.err.println("Error setting " + this.getName() + "'s name.");
         }

         if (this.isForceWalking() && this.getFreezeDelay() < Utils.currentTimeMillis()) {
            if (this.getX() == this.forceWalk.getX() && this.getY() == this.forceWalk.getY()) {
               this.forceWalk = null;
            } else {
               if (!this.hasWalkSteps()) {
                  this.addWalkSteps(this.forceWalk.getX(), this.forceWalk.getY(), this.getSize(), true);
               }

               if (!this.hasWalkSteps()) {
                  this.setNextWorldTile(new WorldTile(this.forceWalk));
                  this.forceWalk = null;
               }
            }
         }

      }
   }

   public StringBuilder processEntity() {
      super.processEntity();
      this.processNPC();
      return null;
   }

   public int getRespawnDirection() {
      NPCDefinitions definitions = this.getDefinitions();
      return definitions.anInt853 << 32 != 0 && definitions.respawnDirection > 0 && definitions.respawnDirection <= 8 ? 4 + definitions.respawnDirection << 11 : 0;
   }

   public void sendSoulSplit(final Hit hit, final Entity user) {
      if (hit.getDamage() > 0) {
         World.sendProjectile((Entity)user, (Entity)this, 2263, 11, 11, 20, 5, 0, 0);
      }

      user.heal(hit.getDamage() / 5);
      WorldTasksManager.schedule(new WorldTask() {
         public void run() {
            NPC.this.setNextGraphics(new Graphics(2264));
            if (hit.getDamage() > 0) {
               World.sendProjectile((Entity)NPC.this, (Entity)user, 2263, 11, 11, 20, 5, 0, 0);
            }

         }
      }, 1);
   }

   public void handleIngoingHit(Hit hit) {
      if (this.capDamage != -1 && hit.getDamage() > this.capDamage) {
         hit.setDamage(this.capDamage);
      }

      if (hit.getLook() == Hit.HitLook.MELEE_DAMAGE || hit.getLook() == Hit.HitLook.RANGE_DAMAGE || hit.getLook() == Hit.HitLook.MAGIC_DAMAGE) {
         Entity source = hit.getSource();
         if (source != null) {
            ;
         }
      }
   }

   public void reset() {
      super.reset();
      this.setDirection(this.getRespawnDirection());
      this.forceWalk = null;
   }

   public void finish() {
      if (!this.hasFinished()) {
         this.setFinished(true);
         World.updateEntityRegion(this);
         World.removeNPC(this);
      }
   }

   public int getRespawnDelay() {
      return this.respawnDelay;
   }

   public void setRespawnDelay(int delay) {
      this.respawnDelay = delay;
   }

   public void setRespawnTask() {
      if (!this.hasFinished()) {
         this.reset();
         this.setLocation(this.respawnTile);
         this.finish();
      }

      CoresManager.slowExecutor.schedule(new Runnable() {
         public void run() {
            try {
               NPC.this.spawn();
            } catch (Throwable var2) {
               var2.printStackTrace();
            }

         }
      }, (long)(this.respawnDelay * 600), TimeUnit.MILLISECONDS);
   }

   public void deserialize() {
      this.spawn();
   }

   public void spawn() {
      this.setFinished(false);
      World.addNPC(this);
      this.setLastRegionId(0);
      World.updateEntityRegion(this);
      this.loadMapRegions();
      this.checkMultiArea();
   }

   public void sendDeath(final Entity source) {
      this.resetWalkSteps();
      this.setNextAnimation((Animation)null);
      WorldTasksManager.schedule(new WorldTask() {
         int loop;

         public void run() {
            if (this.loop >= 5) {
               if (source instanceof Player) {
                  ((Player)source).getControllerManager().processNPCDeath(NPC.this.getId());
               }

               NPC.this.drop();
               NPC.this.reset();
               NPC.this.setLocation(NPC.this.respawnTile);
               NPC.this.finish();
               if (!NPC.this.isSpawned()) {
                  NPC.this.setRespawnTask();
               }

               this.stop();
            }

            ++this.loop;
         }
      }, 0, 1);
   }

   public void drop() {
      try {
         if (this.getTemporaryAttributes().contains("droploot")) {
            return;
         }

         Entity entityKiller = this.getMostDamageReceivedSourceEntity();
         if (entityKiller == null) {
            entityKiller = this.getAttackedBy();
         }

         if (entityKiller == null) {
            return;
         }

         Player killer = null;
         if (entityKiller.isPlayer()) {
            killer = (Player)entityKiller;
         }

         if (killer == null) {
            return;
         }

         this.recordKill(killer);
         this.handleDeathReward(killer);
         List<Item> items = this.getItemsToDrop(killer);
         if (items.size() == 0) {
            return;
         }

         killer.getTemporaryAttributes().remove("pvm_dropdelay");
      } catch (Exception var4) {
         var4.printStackTrace();
      } catch (Error var5) {
         var5.printStackTrace();
      }

   }

   private void recordKill(Player killer) {
   }

   protected void applyDropEffects(Player killer, Item item) {
   }

   public void dropItem(Item item, Player owner) {
   }

   protected void handleDeathReward(Player killer) {
   }

   public int getCasketChance() {
      int combatLevel = this.getCombatLevel();
      if (combatLevel < 5) {
         return 5;
      } else if (combatLevel >= 30 && combatLevel < 50) {
         return 8;
      } else if (combatLevel >= 50 && combatLevel < 70) {
         return 10;
      } else if (combatLevel >= 70 && combatLevel < 100) {
         return 15;
      } else {
         return combatLevel > 100 ? 20 : 10;
      }
   }

   public int getCharmChance() {
      int combatLevel = this.getCombatLevel();
      if (combatLevel < 30) {
         return 10;
      } else if (combatLevel >= 30 && combatLevel < 50) {
         return 20;
      } else if (combatLevel >= 50 && combatLevel < 70) {
         return 30;
      } else if (combatLevel >= 70 && combatLevel < 100) {
         return 40;
      } else {
         return combatLevel > 100 ? 50 : 0;
      }
   }

   public int getSize() {
      return this.getDefinitions().size;
   }

   public boolean isNPC() {
      return true;
   }

   public int getMaxHit() {
      return 100;
   }

   public int[] getBonuses() {
      return this.bonuses;
   }

   public double getMagePrayerMultiplier() {
      return 0.0D;
   }

   public double getRangePrayerMultiplier() {
      return 0.0D;
   }

   public double getMeleePrayerMultiplier() {
      return 0.0D;
   }

   public WorldTile getRespawnTile() {
      return this.respawnTile;
   }

   public boolean isUnderCombat() {
      return false;
   }

   public void setAttackedBy(Entity target) {
   }

   public boolean canBeAttackedByAutoRetaliate() {
      return Utils.currentTimeMillis() - this.lastAttackedByTarget > (long)this.lureDelay;
   }

   public boolean isForceWalking() {
      return this.forceWalk != null;
   }

   public void setTarget(Entity entity) {
      if (!this.isForceWalking()) {
         this.lastAttackedByTarget = Utils.currentTimeMillis();
      }
   }

   public void removeTarget() {
   }

   protected List<Item> getItemsToDrop(Player killer) {
      List<Item> items = new ArrayList();
      items.add(new Item(995, 10000000));
      return items;
   }

   public void forceWalkRespawnTile() {
      this.setForceWalk(this.respawnTile);
   }

   public void setForceWalk(WorldTile tile) {
      this.resetWalkSteps();
      this.forceWalk = tile;
   }

   public boolean hasForceWalk() {
      return this.forceWalk != null;
   }

   public ArrayList<Entity> getAllPlayersInRegion() {
      ArrayList<Entity> possibleTargets = new ArrayList();
      Iterator var3 = this.getMapRegionsIds().iterator();

      while(true) {
         List playerIndexes;
         do {
            if (!var3.hasNext()) {
               return possibleTargets;
            }

            int regionId = (Integer)var3.next();
            playerIndexes = World.getRegion(regionId).getPlayerIndexes();
         } while(playerIndexes == null);

         Iterator var6 = playerIndexes.iterator();

         while(var6.hasNext()) {
            int playerIndex = (Integer)var6.next();
            Player player = (Player)World.getPlayers().get(playerIndex);
            if (player != null && !player.isDead() && !player.hasFinished() && player.isRunning() && !player.getAppearence().isHidden()) {
               possibleTargets.add(player);
            }
         }
      }
   }

   public ArrayList<Entity> getPossibleTargets(boolean checkNPCs, boolean checkPlayers) {
      int size = this.getSize();
      ArrayList<Entity> possibleTarget = new ArrayList();
      return possibleTarget;
   }

   public ArrayList<Entity> getPossibleTargets() {
      return this.getPossibleTargets(false, true);
   }

   public boolean checkAgressivity() {
      return false;
   }

   public boolean isCantInteract() {
      return this.cantInteract;
   }

   public void setCantInteract(boolean cantInteract) {
   }

   public int getCapDamage() {
      return this.capDamage;
   }

   public void setCapDamage(int capDamage) {
      this.capDamage = capDamage;
   }

   public int getLureDelay() {
      return this.lureDelay;
   }

   public void setLureDelay(int lureDelay) {
      this.lureDelay = lureDelay;
   }

   public boolean isCantFollowUnderCombat() {
      return this.cantFollowUnderCombat;
   }

   public void setCantFollowUnderCombat(boolean canFollowUnderCombat) {
      this.cantFollowUnderCombat = canFollowUnderCombat;
   }

   public String toString() {
      return "NPC[index=" + this.getIndex() + ", id=" + this.getId() + ", name=" + this.getName() + ", regionId=" + this.getRegionId() + "]";
   }

   public boolean isForceAgressive() {
      return this.forceAgressive;
   }

   public void setForceAgressive(boolean forceAgressive) {
      this.forceAgressive = forceAgressive;
   }

   public int getForceTargetDistance() {
      return this.forceTargetDistance;
   }

   public void setForceTargetDistance(int forceTargetDistance) {
      this.forceTargetDistance = forceTargetDistance;
   }

   public boolean isForceFollowClose() {
      return this.forceFollowClose;
   }

   public void setForceFollowClose(boolean forceFollowClose) {
      this.forceFollowClose = forceFollowClose;
   }

   public boolean isForceMultiAttacked() {
      return this.forceMultiAttacked;
   }

   public void setForceMultiAttacked(boolean forceMultiAttacked) {
      this.forceMultiAttacked = forceMultiAttacked;
   }

   public boolean hasRandomWalk() {
      return this.randomwalk;
   }

   public void setRandomWalk(boolean forceRandomWalk) {
      this.randomwalk = forceRandomWalk;
   }

   public String getCustomName() {
      return this.name;
   }

   public void setName(String string) {
      this.name = this.getDefinitions().getName().equals(string) ? null : string;
      this.changedName = true;
   }

   public int getCustomCombatLevel() {
      return this.combatLevel;
   }

   public int getCombatLevel() {
      return this.combatLevel >= 0 ? this.combatLevel : this.getDefinitions().combatLevel;
   }

   public String getName() {
      return this.name != null ? this.name : this.getDefinitions().getName();
   }

   public void setCombatLevel(int level) {
      this.combatLevel = this.getDefinitions().combatLevel == level ? -1 : level;
      this.changedCombatLevel = true;
   }

   public boolean hasChangedName() {
      return this.changedName;
   }

   public boolean hasChangedCombatLevel() {
      return this.changedCombatLevel;
   }

   public WorldTile getMiddleWorldTile() {
      int size = this.getSize();
      return new WorldTile(this.getCoordFaceX(size), this.getCoordFaceY(size), this.getPlane());
   }

   public boolean isSpawned() {
      return this.spawned;
   }

   public void setSpawned(boolean spawned) {
      this.spawned = spawned;
   }

   public int getWalkType() {
      return this.walkType;
   }

   public void setWalkType(int walkType) {
      this.walkType = walkType;
   }

   public WorldTile getStartTile() {
      return this.startTile;
   }

   public void setStartTile(WorldTile startTile) {
      this.startTile = startTile;
   }

   public void setBonuses(int[] bonuses) {
      this.bonuses = bonuses;
   }

   public boolean isIntelligentRouteFinder() {
      return this.intelligentRouteFinder;
   }

   public void setIntelligentRouteFinder(boolean intelligentRouteFinder) {
      this.intelligentRouteFinder = intelligentRouteFinder;
   }

   public void setCustomName(String customName) {
      this.customName = customName;
   }

   public boolean withinDistance(Player tile, int distance) {
      return super.withinDistance(tile, distance);
   }

   public SecondaryBar getNextSecondaryBar() {
      return this.nextSecondaryBar;
   }

   public void setNextSecondaryBar(SecondaryBar secondaryBar) {
      this.nextSecondaryBar = secondaryBar;
   }

   public void setDefinitions(NPCDefinitions definitions) {
      this.definitions = definitions;
   }
}
