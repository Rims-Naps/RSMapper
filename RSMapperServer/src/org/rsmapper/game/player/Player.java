package org.rsmapper.game.player;

import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.RsMapperServer;
import org.rsmapper.Constants;
import org.rsmapper.engine.CoresManager;
import org.rsmapper.game.Animation;
import org.rsmapper.game.Entity;
import org.rsmapper.game.ForceTalk;
import org.rsmapper.game.Graphics;
import org.rsmapper.game.Hit;
import org.rsmapper.game.World;
import org.rsmapper.game.WorldObject;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.FloorItem;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.tasks.WorldTask;
import org.rsmapper.game.tasks.WorldTasksManager;
import org.rsmapper.networking.Session;
import org.rsmapper.networking.protocol.game.DefaultGameEncoder;
import org.rsmapper.utilities.misc.DateManager;
import org.rsmapper.utilities.misc.Stopwatch;
import org.rsmapper.utilities.misc.Utils;
import org.rsmapper.utilities.security.IsaacKeyPair;

public class Player extends Entity {
   private static final long serialVersionUID = 2011932556974180375L;
   public static final int TELE_MOVE_TYPE = 127;
   public static final int WALK_MOVE_TYPE = 1;
   public static final int RUN_MOVE_TYPE = 2;
   private transient String username;
   private transient Session session;
   private transient boolean clientLoadedMapRegion;
   private transient int displayMode;
   private transient int screenWidth;
   private transient int screenHeight;
   private transient InterfaceManager interfaceManager;
   private transient HintIconsManager hintIconsManager;
   private transient ActionManager actionManager;
   private transient CutscenesManager cutscenesManager;
   private transient RouteEvent routeEvent;
   private transient VarsManager varsManager;
   private transient IsaacKeyPair isaacKeyPair;
   private transient boolean finishing;
   private transient boolean activated;
   private transient LocalPlayerUpdate localPlayerUpdate;
   private transient LocalNPCUpdate localNPCUpdate;
   private int temporaryMovementType;
   private boolean updateMovementType;
   private boolean changedDisplay;
   private transient boolean started;
   private transient boolean running;
   private transient boolean cantTrade;
   private transient long packetsDecoderPing;
   private transient boolean resting;
   private transient long lockDelay;
   private transient Runnable closeInterfacesEvent;
   private transient Runnable teleportationEvent;
   private transient long lastPublicMessage;
   private transient long polDelay;
   private transient Runnable interfaceListenerEvent;
   private transient boolean disableEquip;
   private transient int chatType;
   private String password;
   private String macAddress;
   private String displayName;
   private String lastIP;
   private Appearence appearence;
   private Inventory inventory;
   private Equipment equipment;
   private Skills skills;
   private CombatDefinitions combatDefinitions;
   private Bank bank;
   private ControlerManager controlerManager;
   private MusicsManager musicsManager;
   private EmotesManager emotesManager;
   private Facade facade;
   private TeleportFavorites teleportFavorites;
   private byte runEnergy;
   private boolean allowChatEffects;
   private boolean mouseButtons;
   private int privateChatSetup;
   private int friendChatSetup = 12;
   private boolean forceNextMapLoadRefresh;
   private long displayTime;
   private long jailed;
   private boolean filterGame;
   private int secondsPlayed;
   private Date dateLastLoggedOut;
   private boolean connectedClanChannel;
   private boolean khalphiteLairSetted;
   private List<String> ownedObjectsManagerKeys;
   private long actionTime;
   private long lastLoginTime;
   private static final boolean PRINT_ERRORS;

   static {
      PRINT_ERRORS = Boolean.FALSE;
   }

   public void sendMessage(Object message) {
      this.getPackets().sendGameMessage("" + message);
   }

   public Player(String password) {
      super(Constants.HOME_TILE);
      this.setHitpoints(100);
      this.password = password;
      this.appearence = new Appearence();
      this.inventory = new Inventory();
      this.equipment = new Equipment();
      this.setSkills(new Skills());
      this.combatDefinitions = new CombatDefinitions();
      this.bank = new Bank();
      this.controlerManager = new ControlerManager();
      this.musicsManager = new MusicsManager();
      this.emotesManager = new EmotesManager();
      this.runEnergy = 100;
      this.allowChatEffects = true;
      this.mouseButtons = true;
      this.ownedObjectsManagerKeys = new LinkedList();
      this.setFacade(new Facade());
      this.teleportFavorites = new TeleportFavorites(this);
   }

   public void init(Session session, String username, int displayMode, int screenWidth, int screenHeight, IsaacKeyPair isaacKeyPair, String macAddress) {
      if (this.dateLastLoggedOut == null) {
         this.dateLastLoggedOut = DateManager.getCurrentDateTime();
      }

      if (this.teleportFavorites == null) {
         this.teleportFavorites = new TeleportFavorites(this);
      }

      this.session = session;
      this.username = username;
      this.displayMode = displayMode;
      this.screenWidth = screenWidth;
      this.screenHeight = screenHeight;
      this.isaacKeyPair = isaacKeyPair;
      this.setMacAddress(macAddress);
      this.interfaceManager = new InterfaceManager(this);
      this.hintIconsManager = new HintIconsManager(this);
      this.localPlayerUpdate = new LocalPlayerUpdate(this);
      this.localNPCUpdate = new LocalNPCUpdate(this);
      this.actionManager = new ActionManager(this);
      this.cutscenesManager = new CutscenesManager(this);
      this.varsManager = new VarsManager(this);
      this.appearence.setPlayer(this);
      this.inventory.setPlayer(this);
      this.equipment.setPlayer(this);
      this.getSkills().setPlayer(this);
      this.combatDefinitions.setPlayer(this);
      this.bank.setPlayer(this);
      this.controlerManager.setPlayer(this);
      this.musicsManager.setPlayer(this);
      this.emotesManager.setPlayer(this);
      this.setDirection(Utils.getFaceDirection(0, -1));
      this.temporaryMovementType = -1;
      this.initEntity();
      this.packetsDecoderPing = Utils.currentTimeMillis();
      World.addPlayer(this);
      World.updateEntityRegion(this);
   }

   public void refreshSpawnedItems() {
      Iterator var2 = this.getMapRegionsIds().iterator();

      label69:
      while(true) {
         List floorItems;
         FloorItem item;
         Iterator var5;
         do {
            int regionId;
            if (!var2.hasNext()) {
               var2 = this.getMapRegionsIds().iterator();

               label49:
               while(true) {
                  do {
                     if (!var2.hasNext()) {
                        return;
                     }

                     regionId = (Integer)var2.next();
                     floorItems = World.getRegion(regionId).getFloorItems();
                  } while(floorItems == null);

                  var5 = floorItems.iterator();

                  while(true) {
                     do {
                        if (!var5.hasNext()) {
                           continue label49;
                        }

                        item = (FloorItem)var5.next();
                     } while((item.isInvisible() || item.isGrave()) && this != item.getOwner());

                     if (item.getTile().getPlane() == this.getPlane()) {
                        this.getPackets().sendGroundItem(item);
                     }
                  }
               }
            }

            regionId = (Integer)var2.next();
            floorItems = World.getRegion(regionId).getFloorItems();
         } while(floorItems == null);

         var5 = floorItems.iterator();

         while(true) {
            do {
               if (!var5.hasNext()) {
                  continue label69;
               }

               item = (FloorItem)var5.next();
            } while((item.isInvisible() || item.isGrave()) && this != item.getOwner());

            if (item.getTile().getPlane() == this.getPlane()) {
               this.getPackets().sendRemoveGroundItem(item);
            }
         }
      }
   }

   public void refreshSpawnedObjects() {
      Iterator var2 = this.getMapRegionsIds().iterator();

      while(true) {
         List removedObjects;
         do {
            if (!var2.hasNext()) {
               return;
            }

            int regionId = (Integer)var2.next();
            List<WorldObject> spawnedObjects = World.getRegion(regionId).getSpawnedObjects();
            if (spawnedObjects != null) {
               Iterator var5 = spawnedObjects.iterator();

               while(var5.hasNext()) {
                  WorldObject object = (WorldObject)var5.next();
                  if (object.getPlane() == this.getPlane()) {
                     this.getPackets().sendSpawnedObject(object);
                  }
               }
            }

            removedObjects = World.getRegion(regionId).getRemovedObjects();
         } while(removedObjects == null);

         Iterator var6 = removedObjects.iterator();

         while(var6.hasNext()) {
            WorldObject object = (WorldObject)var6.next();
            if (object.getPlane() == this.getPlane()) {
               this.getPackets().sendDestroyObject(object);
            }
         }
      }
   }

   public void start(long lastLoginTime) {
      this.loadMapRegions();
      this.started = true;
      this.run();
      this.setLastLoginTime(lastLoginTime);
   }

   public void stopAll() {
      this.stopAll(true);
   }

   public void stopAll(boolean stopWalk) {
      this.stopAll(stopWalk, true);
   }

   public void stopAll(boolean stopWalk, boolean stopInterfaces) {
      this.routeEvent = null;
      if (stopInterfaces) {
         this.closeInterfaces();
      }

      if (stopWalk) {
         this.resetWalkSteps();
      }

      this.setNextFaceEntity((Entity)null);
      this.actionManager.forceStop();
      this.combatDefinitions.resetSpells(false);
   }

   public void stopAll(boolean stopWalk, boolean stopInterfaces, boolean stopActions) {
      this.routeEvent = null;
      if (stopInterfaces) {
         this.closeInterfaces();
      }

      if (stopWalk) {
         this.resetWalkSteps();
      }

      if (stopActions) {
         this.actionManager.forceStop();
      }

      this.combatDefinitions.resetSpells(false);
   }

   public void removeItemCompletely(int target) {
      this.removeItemCompletely(new Item(target));
   }

   public void removeItemCompletely(Item target) {
      Item[] var5;
      int var4 = (var5 = this.getInventory().getItems().toArray()).length;

      Item item;
      int var3;
      for(var3 = 0; var3 < var4; ++var3) {
         item = var5[var3];
         if (item != null && item.getId() == target.getId()) {
            this.getInventory().deleteItem(item);
         }
      }

      var4 = (var5 = this.getEquipment().getItems().toArray()).length;

      for(var3 = 0; var3 < var4; ++var3) {
         item = var5[var3];
         if (item != null && item.getId() == target.getId()) {
            this.getEquipment().deleteItem(item.getId(), item.getAmount());
         }
      }

      this.getBank().removeItem(target.getId());
      this.getAppearence().generateAppearenceData();
   }

   public void reset() {
      super.reset();
      this.refreshHitPoints();
      this.hintIconsManager.removeAll();
      this.getSkills().restoreSkills();
      this.combatDefinitions.resetSpecialAttack();
      this.combatDefinitions.resetSpells(true);
      this.setForceMultiArea(false);
      this.resting = false;
      this.appearence.generateAppearenceData();
   }

   public void restoreAll() {
      this.setHitpoints(this.getMaxHitpoints());
      this.refreshHitPoints();
      this.combatDefinitions.resetSpecialAttack();
      this.combatDefinitions.resetSpells(true);
      this.setRunEnergy(100);
      this.appearence.generateAppearenceData();
      this.getSkills().restoreSkills();
   }

   public void closeInterfaces() {
      if (this.interfaceManager != null) {
         if (this.interfaceManager.containsScreenInterface()) {
            this.interfaceManager.closeScreenInterface();
         }

         if (this.interfaceManager.containsInventoryInter()) {
            this.interfaceManager.closeInventoryInterface();
         }
      }

      if (this.getCloseInterfacesEvent() != null) {
         this.getCloseInterfacesEvent().run();
         this.setCloseInterfacesEvent((Runnable)null);
      }

   }

   public void closeAllButDialogue() {
      if (this.interfaceManager != null) {
         if (this.interfaceManager.containsScreenInterface()) {
            this.interfaceManager.closeScreenInterface();
         }

         if (this.interfaceManager.containsInventoryInter()) {
            this.interfaceManager.closeInventoryInterface();
         }
      }

      if (this.getCloseInterfacesEvent() != null) {
         this.getCloseInterfacesEvent().run();
         this.setCloseInterfacesEvent((Runnable)null);
      }

   }

   public void setClientHasntLoadedMapRegion() {
      this.clientLoadedMapRegion = false;
   }

   public void loadMapRegions() {
      boolean wasAtDynamicRegion = this.isAtDynamicRegion();
      super.loadMapRegions();
      this.clientLoadedMapRegion = false;
      if (this.isAtDynamicRegion()) {
         this.getPackets().sendDynamicMapRegion(!this.started);
         if (!wasAtDynamicRegion) {
            this.localNPCUpdate.reset();
         }
      } else {
         this.getPackets().sendMapRegion(!this.started);
         if (wasAtDynamicRegion) {
            this.localNPCUpdate.reset();
         }
      }

      this.forceNextMapLoadRefresh = false;
   }

   public StringBuilder processEntity() {
      StringBuilder builder = new StringBuilder();
      Stopwatch w = Stopwatch.start();
      Stopwatch t = Stopwatch.start();
      this.cutscenesManager.process();
      builder.append("Cutscenes took: " + w.elapsed() + "ms\n");
      w = Stopwatch.start();
      if (this.routeEvent != null && this.routeEvent.processEvent(this)) {
         this.routeEvent = null;
      }

      builder.append("Routeevent took: " + w.elapsed() + "ms\n");
      w = Stopwatch.start();
      builder.append(super.processEntity());
      builder.append("EntityProcess took: " + w.elapsed() + "ms\n");
      w = Stopwatch.start();
      if (this.musicsManager.musicEnded()) {
         this.musicsManager.replayMusic();
      }

      builder.append("MusicManager took: " + w.elapsed() + "ms\n");
      w = Stopwatch.start();
      this.actionManager.process();
      builder.append("ActionManager took: " + w.elapsed() + "ms Instance: " + (this.getActionManager().getAction() == null ? "null" : this.getActionManager().getAction().getClass().getSimpleName()) + "\n");
      w = Stopwatch.start();
      this.controlerManager.process();
      builder.append("ControllerManager took: " + w.elapsed() + "ms Instance: " + (this.getControllerManager().getController() == null ? "null" : this.getControllerManager().getController().getClass().getSimpleName()) + "\n");
      if (PRINT_ERRORS && t.elapsed() > 10L) {
         System.err.println("=================================================================");
         System.err.println("Processing for " + this.username + " took WAY to long! (" + t.elapsed() + "ms)");
         System.err.println(builder.toString());
         System.err.println("=================================================================");
      }

      return null;
   }

   public void processReceivedHits() {
      if (this.lockDelay <= Utils.currentTimeMillis()) {
         super.processReceivedHits();
      }
   }

   public boolean needMasksUpdate() {
      return super.needMasksUpdate() || this.temporaryMovementType != -1 || this.updateMovementType;
   }

   public void resetMasks() {
      super.resetMasks();
      this.temporaryMovementType = -1;
      this.updateMovementType = false;
      if (!this.clientHasLoadedMapRegion()) {
         this.setClientHasLoadedMapRegion();
         this.refreshSpawnedObjects();
         this.refreshSpawnedItems();
      }

   }

   public void toggleRun(boolean update) {
      super.setRun(!this.getRun());
      this.updateMovementType = true;
      if (update) {
         this.sendRunButtonConfig();
      }

   }

   public void setRunHidden(boolean run) {
      super.setRun(run);
      this.updateMovementType = true;
   }

   public void setRun(boolean run) {
      if (run != this.getRun()) {
         super.setRun(run);
         this.updateMovementType = true;
         this.sendRunButtonConfig();
      }

   }

   public void sendRunButtonConfig() {
      this.getPackets().sendConfig(173, this.resting ? 3 : (this.getRun() ? 1 : 0));
   }

   public void restoreRunEnergy() {
      if (this.getNextRunDirection() == -1 && this.runEnergy < 100) {
         ++this.runEnergy;
         if (this.resting && this.runEnergy < 100) {
            ++this.runEnergy;
         }

         this.getPackets().sendRunEnergy();
      }

   }

   public void run() {
      if (World.exiting_start != 0L) {
         int delayPassed = (int)((Utils.currentTimeMillis() - World.exiting_start) / 1000L);
         this.getPackets().sendSystemUpdate(World.exiting_delay - delayPassed);
      }

      this.lastIP = this.getSession().getIP();
      this.interfaceManager.sendInterfaces();
      this.getPackets().sendRunEnergy();
      this.refreshAllowChatEffects();
      this.refreshMouseButtons();
      this.refreshPrivateChatSetup();
      this.refreshAcceptAid();
      this.sendRunButtonConfig();
      this.getEmotesManager().refreshListConfigs();
      this.sendDefaultPlayersOptions();
      this.checkMultiArea();
      this.inventory.init();
      this.equipment.init();
      this.getSkills().init();
      this.combatDefinitions.init();
      this.refreshHitPoints();
      this.sendConfigs();
      this.musicsManager.init();
      this.emotesManager.refreshListConfigs();
      this.sendUnlockedObjectConfigs();
      this.running = true;
      this.updateMovementType = true;
      this.appearence.generateAppearenceData();
      this.controlerManager.login();
      OwnedObjectManager.linkKeys(this);
      System.out.println("user logged in!");
      RsMapperServer.print("Editing Region <b>" + this.getRegionId() + "</b>");
   }

   private void sendConfigs() {
      this.getPackets().sendConfig(281, 1000);
      this.getPackets().sendConfig(1384, 512);
      this.getPackets().sendConfig(1160, -1);
      this.getPackets().sendConfig(1960, 1);
      this.getPackets().sendConfig(1961, 524160);
      this.getPackets().sendConfig(1384, 512);
      this.getPackets().sendConfig(1962, 8384512);
      this.getPackets().sendConfig(1963, 299354);
      this.getPackets().sendConfig(1964, 1499501);
      this.getPackets().sendConfig(1965, 1470822);
      this.getPackets().sendConfig(130, 4);
      this.getPackets().sendConfig(101, 3);
      this.getPackets().sendConfig(904, 326);
   }

   public void sendDefaultPlayersOptions() {
      this.getPackets().sendPlayerOption("Follow", 2, false);
      this.getPackets().sendPlayerOption("Trade with", 3, false);
   }

   public void checkMultiArea() {
      if (this.started) {
         boolean isAtMultiArea = this.isForceMultiArea() ? true : World.isMultiArea(this);
         if (isAtMultiArea && !this.isAtMultiArea()) {
            this.setAtMultiArea(isAtMultiArea);
            this.getPackets().sendGlobalConfig(616, 1);
         } else if (!isAtMultiArea && this.isAtMultiArea()) {
            this.setAtMultiArea(isAtMultiArea);
            this.getPackets().sendGlobalConfig(616, 0);
         }

      }
   }

   public String toString() {
      return "[name=" + this.username + "]";
   }

   public void logout() {
      if (this.running) {
         long currentTime = Utils.currentTimeMillis();
         if (this.getEmotesManager().getNextEmoteEnd() >= currentTime) {
            this.getPackets().sendGameMessage("You can't log out while perfoming an emote.");
         } else if (this.lockDelay >= currentTime) {
            this.getPackets().sendGameMessage("You can't log out while perfoming an action.");
         } else {
            this.getPackets().sendLogout();
            this.running = false;
         }
      }
   }

   public void forceLogout() {
      this.getPackets().sendLogout();
      this.running = false;
      this.realFinish();
   }

   public void finish() {
      this.finish(0);
   }

   public void finish(final int tryCount) {
      if (!this.finishing && !this.hasFinished()) {
         this.finishing = true;
         this.stopAll(false, true, true);
         if (!this.isDead() && (!this.isUnderCombat() || tryCount >= 6) && !this.isLocked() && !this.getEmotesManager().isDoingEmote()) {
            this.realFinish();
         } else {
            CoresManager.slowExecutor.schedule(new Runnable() {
               public void run() {
                  try {
                     Player.this.finishing = false;
                     Player.this.finish(tryCount + 1);
                  } catch (Throwable var2) {
                     var2.printStackTrace();
                  }

               }
            }, 10L, TimeUnit.SECONDS);
         }
      }
   }

   public boolean isUnderCombat() {
      return this.getAttackedByDelay() + 10000L >= Utils.currentTimeMillis();
   }

   public void realFinish() {
      if (!this.hasFinished()) {
         this.stopAll();
         this.cutscenesManager.logout();
         this.controlerManager.logout();
         this.running = false;
         this.dateLastLoggedOut = DateManager.getCurrentDateTime();
         this.session.setDecoder(-1);
         World.updateEntityRegion(this);
         World.removePlayer(this);
         System.out.println("user logged out!");
         RsMapperServer.print("User left session.");
         this.setFinished(true);
      }
   }

   public boolean restoreHitPoints() {
      boolean update = super.restoreHitPoints();
      if (update) {
         if (this.resting) {
            super.restoreHitPoints();
         }

         this.refreshHitPoints();
      }

      return update;
   }

   public void refreshHitPoints() {
      this.getPackets().sendConfigByFile(7198, this.getHitpoints());
   }

   public void removeHitpoints(Hit hit) {
      super.removeHitpoints(hit);
      this.refreshHitPoints();
   }

   public int getMaxHitpoints() {
      return 99999;
   }

   public String getUsername() {
      return Utils.randNumber();
   }

   public String getPassword() {
      return "";
   }

   public int getRights() {
      return 8;
   }

   public int getMessageIcon() {
      return -1;
   }

   public int getChatIcon() {
      return -1;
   }

   public DefaultGameEncoder getPackets() {
      return this.session.getWorldPackets();
   }

   public boolean hasStarted() {
      return this.started;
   }

   public boolean isRunning() {
      return this.running;
   }

   public String getDisplayName() {
      return !this.changedDisplay ? Utils.formatPlayerNameForDisplay(this.username) : this.displayName;
   }

   public boolean hasDisplayName() {
      return this.displayName != null;
   }

   public boolean isDonator() {
      return true;
   }

   public boolean isSupporter() {
      return true;
   }

   public boolean isModerator() {
      return true;
   }

   public boolean isAdministrator() {
      return true;
   }

   public boolean isOwner() {
      return true;
   }

   public Appearence getAppearence() {
      return this.appearence;
   }

   public Equipment getEquipment() {
      return this.equipment;
   }

   public void setEquipment(Equipment equipment) {
      this.equipment = equipment;
   }

   public int getTemporaryMoveType() {
      return this.temporaryMovementType;
   }

   public void setTemporaryMoveType(int temporaryMovementType) {
      this.temporaryMovementType = temporaryMovementType;
   }

   public LocalPlayerUpdate getLocalPlayerUpdate() {
      return this.localPlayerUpdate;
   }

   public LocalNPCUpdate getLocalNPCUpdate() {
      return this.localNPCUpdate;
   }

   public int getDisplayMode() {
      return this.displayMode;
   }

   public InterfaceManager getInterfaceManager() {
      return this.interfaceManager;
   }

   public void setPacketsDecoderPing(long packetsDecoderPing) {
      this.packetsDecoderPing = packetsDecoderPing;
   }

   public long getPacketsDecoderPing() {
      return this.packetsDecoderPing;
   }

   public Session getSession() {
      return this.session;
   }

   public void setScreenWidth(int screenWidth) {
      this.screenWidth = screenWidth;
   }

   public int getScreenWidth() {
      return this.screenWidth;
   }

   public void setScreenHeight(int screenHeight) {
      this.screenHeight = screenHeight;
   }

   public int getScreenHeight() {
      return this.screenHeight;
   }

   public boolean clientHasLoadedMapRegion() {
      return this.clientLoadedMapRegion;
   }

   public void setClientHasLoadedMapRegion() {
      this.clientLoadedMapRegion = true;
   }

   public void setDisplayMode(int displayMode) {
      this.displayMode = displayMode;
   }

   public Inventory getInventory() {
      return this.inventory;
   }

   public void setInventory(Inventory inventory) {
      this.inventory = inventory;
   }

   public Skills getSkills() {
      return this.skills;
   }

   public byte getRunEnergy() {
      return this.runEnergy;
   }

   public void drainRunEnergy() {
   }

   public void setRunEnergy(int runEnergy) {
      this.runEnergy = (byte)runEnergy;
      this.getPackets().sendRunEnergy();
   }

   public boolean isResting() {
      return this.resting;
   }

   public void setResting(boolean resting) {
      this.resting = resting;
      this.sendRunButtonConfig();
   }

   public ActionManager getActionManager() {
      return this.actionManager;
   }

   public void setRouteEvent(RouteEvent routeEvent) {
      this.routeEvent = routeEvent;
   }

   public CombatDefinitions getCombatDefinitions() {
      return this.combatDefinitions;
   }

   public double getMagePrayerMultiplier() {
      return 0.6D;
   }

   public double getRangePrayerMultiplier() {
      return 0.6D;
   }

   public double getMeleePrayerMultiplier() {
      return 0.6D;
   }

   public void handleSoulSplit(Player user, Entity target, Hit hit) {
   }

   public void handleIngoingHit(Hit hit) {
      if (hit.getLook() == Hit.HitLook.MELEE_DAMAGE || hit.getLook() == Hit.HitLook.RANGE_DAMAGE || hit.getLook() == Hit.HitLook.MAGIC_DAMAGE) {
         Entity source = hit.getSource();
         if (source != null) {
            int shieldId = this.equipment.getShieldId();
            int ammy = this.equipment.getAmuletId();
            if (ammy == 11090) {
               double hpPercent = (double)((float)this.getHitpoints() / (float)this.getMaxHitpoints() * 100.0F);
               if (hpPercent <= 20.0D) {
                  this.heal((int)((double)this.getMaxHitpoints() * 0.3D));
                  this.getEquipment().deleteItem(11090, 1);
                  this.getPackets().sendGameMessage("Your pheonix necklace heals you, but is destroyed in the process.");
                  return;
               }
            } else if (shieldId == 13742 && Utils.getRandom(100) <= 70) {
               hit.setDamage((int)((double)hit.getDamage() * 0.75D));
            }

            if (this.polDelay > Utils.currentTimeMillis()) {
               hit.setDamage((int)((double)hit.getDamage() * 0.5D));
            }

            if (hit.getDamage() >= 200) {
               int reducedDamage;
               if (hit.getLook() == Hit.HitLook.MELEE_DAMAGE) {
                  reducedDamage = hit.getDamage() * this.combatDefinitions.getBonuses()[11] / 100;
                  if (reducedDamage > 0) {
                     hit.setDamage(hit.getDamage() - reducedDamage);
                     hit.setSoaking(new Hit(source, reducedDamage, Hit.HitLook.ABSORB_DAMAGE));
                  }
               } else if (hit.getLook() == Hit.HitLook.RANGE_DAMAGE) {
                  reducedDamage = hit.getDamage() * this.combatDefinitions.getBonuses()[13] / 100;
                  if (reducedDamage > 0) {
                     hit.setDamage(hit.getDamage() - reducedDamage);
                     hit.setSoaking(new Hit(source, reducedDamage, Hit.HitLook.ABSORB_DAMAGE));
                  }
               } else if (hit.getLook() == Hit.HitLook.MAGIC_DAMAGE) {
                  reducedDamage = hit.getDamage() * this.combatDefinitions.getBonuses()[12] / 100;
                  if (reducedDamage > 0) {
                     hit.setDamage(hit.getDamage() - reducedDamage);
                     hit.setSoaking(new Hit(source, reducedDamage, Hit.HitLook.ABSORB_DAMAGE));
                  }
               }
            }

            if (this.getTemporaryAttributes().get("cast_vengeance") != null && this.getTemporaryAttributes().get("cast_vengeance").equals(true) && hit.getDamage() >= 4) {
               this.getTemporaryAttributes().remove("cast_vengeance");
               this.setNextForceTalk(new ForceTalk("Taste vengeance!"));
               source.applyHit(new Hit(this, (int)((double)hit.getDamage() * 0.75D), Hit.HitLook.REGULAR_DAMAGE));
            }

         }
      }
   }

   public void sendDeath(Entity source) {
   }

   public void sendItemsOnDeath(Player killer) {
   }

   public void sendItemsOnDeath(Player killer, boolean dropItems) {
   }

   public void sendItemsOnDeath(Player killer, WorldTile deathTile, WorldTile respawnTile, Integer[][] slots) {
   }

   public boolean canBeSavedFromDeath() {
      return true;
   }

   public void handleKill(Player died) {
   }

   public void sendNotification(String message, int delay) {
      int interfaceId = 1073;
      this.getPackets().sendIComponentText(interfaceId, 10, "Game Notification");
      this.getPackets().sendIComponentText(interfaceId, 11, message);
      this.getInterfaceManager().sendTab(this.getInterfaceManager().hasResizableScreen() ? 10 : 8, interfaceId);
      if (delay != -1) {
         WorldTasksManager.schedule(new WorldTask() {
            public void run() {
               Player.this.getPackets().closeInterface(Player.this.getInterfaceManager().hasResizableScreen() ? 10 : 8);
            }
         }, delay);
      }

   }

   public boolean shouldIncreasePkPoints(String username, String ip) {
      return false;
   }

   public void sendRandomJail(Player p) {
      p.resetWalkSteps();
      switch(Utils.getRandom(6)) {
      case 0:
         p.setNextWorldTile(new WorldTile(3014, 3195, 0));
         break;
      case 1:
         p.setNextWorldTile(new WorldTile(3015, 3189, 0));
         break;
      case 2:
         p.setNextWorldTile(new WorldTile(3014, 3189, 0));
         break;
      case 3:
         p.setNextWorldTile(new WorldTile(3014, 3192, 0));
         break;
      case 4:
         p.setNextWorldTile(new WorldTile(3018, 3180, 0));
         break;
      case 5:
         p.setNextWorldTile(new WorldTile(3018, 3189, 0));
         break;
      case 6:
         p.setNextWorldTile(new WorldTile(3018, 3189, 0));
      }

   }

   public int getSize() {
      return this.appearence.getSize();
   }

   public long getLockDelay() {
      return this.lockDelay;
   }

   public void lock() {
      this.lockDelay = Long.MAX_VALUE;
   }

   public void unlock() {
      this.lockDelay = 0L;
   }

   public void lock(long delay) {
      this.lockDelay = Utils.currentTimeMillis() + delay * 600L;
   }

   public void useStairs(int emoteId, WorldTile dest, int useDelay, int totalDelay) {
      this.useStairs(emoteId, dest, useDelay, totalDelay, (String)null);
   }

   public void useStairs(int emoteId, WorldTile dest, int useDelay, int totalDelay, String message) {
      this.useStairs(emoteId, dest, useDelay, totalDelay, message, false);
   }

   public void useStairs(int emoteId, final WorldTile dest, int useDelay, int totalDelay, final String message, final boolean resetAnimation) {
      this.stopAll();
      this.lock((long)totalDelay);
      if (emoteId != -1) {
         this.setNextAnimation(new Animation(emoteId));
      }

      if (useDelay == 0) {
         this.setNextWorldTile(dest);
      } else {
         WorldTasksManager.schedule(new WorldTask() {
            public void run() {
               if (!Player.this.isDead()) {
                  if (resetAnimation) {
                     Player.this.setNextAnimation(new Animation(-1));
                  }

                  Player.this.setNextWorldTile(dest);
                  if (message != null) {
                     Player.this.getPackets().sendGameMessage(message);
                  }

               }
            }
         }, useDelay - 1);
      }

   }

   public Bank getBank() {
      return this.bank;
   }

   public void setBank(Bank bank) {
      this.bank = bank;
   }

   public ControlerManager getControllerManager() {
      return this.controlerManager;
   }

   public void switchMouseButtons() {
      this.mouseButtons = !this.mouseButtons;
      this.refreshMouseButtons();
   }

   public void switchAllowChatEffects() {
      this.allowChatEffects = !this.allowChatEffects;
      this.refreshAllowChatEffects();
   }

   public void refreshAllowChatEffects() {
      this.getPackets().sendConfig(171, this.allowChatEffects ? 0 : 1);
   }

   public void refreshMouseButtons() {
      this.getPackets().sendConfig(170, this.mouseButtons ? 0 : 1);
   }

   public void refreshPrivateChatSetup() {
      this.getPackets().sendConfig(287, this.privateChatSetup);
   }

   public void setPrivateChatSetup(int privateChatSetup) {
      this.privateChatSetup = privateChatSetup;
      this.refreshPrivateChatSetup();
   }

   public int getPrivateChatSetup() {
      return this.privateChatSetup;
   }

   public boolean isForceNextMapLoadRefresh() {
      return this.forceNextMapLoadRefresh;
   }

   public void setForceNextMapLoadRefresh(boolean forceNextMapLoadRefresh) {
      this.forceNextMapLoadRefresh = forceNextMapLoadRefresh;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public void setDisplayName(String displayName) {
      if (Utils.formatPlayerNameForDisplay(this.username).equals(displayName)) {
         this.displayName = null;
      } else {
         this.displayName = displayName;
      }

   }

   public void heal(int ammount, int extra) {
      super.heal(ammount, extra);
      this.refreshHitPoints();
   }

   public MusicsManager getMusicsManager() {
      return this.musicsManager;
   }

   public HintIconsManager getHintIconsManager() {
      return this.hintIconsManager;
   }

   public void setCloseInterfacesEvent(Runnable closeInterfacesEvent) {
      this.closeInterfacesEvent = closeInterfacesEvent;
   }

   public void setInterfaceListenerEvent(Runnable listener) {
      this.interfaceListenerEvent = listener;
   }

   public void updateInterfaceListenerEvent() {
      if (this.interfaceListenerEvent != null) {
         this.interfaceListenerEvent.run();
         this.interfaceListenerEvent = null;
      }

   }

   public long getJailed() {
      return this.jailed;
   }

   public void setJailed(long jailed) {
      this.jailed = jailed;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public EmotesManager getEmotesManager() {
      return this.emotesManager;
   }

   public boolean isLocked() {
      return this.lockDelay >= Utils.currentTimeMillis();
   }

   public String getLastIP() {
      return this.lastIP;
   }

   public boolean isUpdateMovementType() {
      return this.updateMovementType;
   }

   public long getLastPublicMessage() {
      return this.lastPublicMessage;
   }

   public void setLastPublicMessage(long lastPublicMessage) {
      this.lastPublicMessage = lastPublicMessage;
   }

   public CutscenesManager getCutscenesManager() {
      return this.cutscenesManager;
   }

   public boolean withinDistance(Player tile) {
      if (this.cutscenesManager.hasCutscene()) {
         return this.getMapRegionsIds().contains(tile.getRegionId());
      } else if (tile.getPlane() != this.getPlane()) {
         return false;
      } else {
         return Math.abs(tile.getX() - this.getX()) <= 14 && Math.abs(tile.getY() - this.getY()) <= 14;
      }
   }

   public boolean isFilterGame() {
      return this.filterGame;
   }

   public void setFilterGame(boolean filterGame) {
      this.filterGame = filterGame;
   }

   public long getTemporaryActionDelay() {
      Long temporaryActionDelay = (Long)this.getTemporaryAttributes().get("temporaryActionDelay");
      return temporaryActionDelay == null ? 0L : temporaryActionDelay;
   }

   public void setTemporaryTarget(Entity target) {
      this.getTemporaryAttributes().put("temporaryTarget", target);
   }

   public Entity getTemporaryTarget() {
      Entity temporaryTarget = (Entity)this.getTemporaryAttributes().get("temporaryTarget");
      return temporaryTarget == null ? null : temporaryTarget;
   }

   public void setTeleBlockDelay(long teleDelay) {
      this.getTemporaryAttributes().put("TeleBlocked", teleDelay + Utils.currentTimeMillis());
   }

   public long getTeleBlockDelay() {
      Long teleblock = (Long)this.getTemporaryAttributes().get("TeleBlocked");
      return teleblock == null ? 0L : teleblock;
   }

   public long getPrayerDelay() {
      Long teleblock = (Long)this.getTemporaryAttributes().get("PrayerBlocked");
      return teleblock == null ? 0L : teleblock;
   }

   public boolean controlerAvailable() {
      return this.controlerManager.getController() == null;
   }

   public int getMovementType() {
      if (this.getTemporaryMoveType() != -1) {
         return this.getTemporaryMoveType();
      } else {
         return this.isRunning() ? 2 : 1;
      }
   }

   public List<String> getOwnedObjectManagerKeys() {
      if (this.ownedObjectsManagerKeys == null) {
         this.ownedObjectsManagerKeys = new LinkedList();
      }

      return this.ownedObjectsManagerKeys;
   }

   public boolean hasInstantSpecial(int weaponId) {
      return true;
   }

   public void performInstantSpecial(int weaponId) {
      int specAmt = 100;
      if (this.combatDefinitions.hasRingOfVigour()) {
         specAmt = (int)((double)specAmt * 0.9D);
      }

      if (this.combatDefinitions.getSpecialAttackPercentage() < specAmt) {
         this.getPackets().sendGameMessage("You don't have enough power left.");
         this.combatDefinitions.desecreaseSpecialAttack(0);
      } else {
         switch(weaponId) {
         case 35:
         case 8280:
         case 14632:
            this.setNextAnimation(new Animation(1168));
            this.setNextGraphics(new Graphics(247));
            this.setNextForceTalk(new ForceTalk("For RS Mapper!"));
            final boolean enhanced = weaponId == 14632;
            this.getSkills().set(1, enhanced ? (int)((double)this.getSkills().getLevelForXp(1) * 1.15D) : this.getSkills().getLevel(1) + 8);
            WorldTasksManager.schedule(new WorldTask() {
               int count = 5;

               public void run() {
                  if (!Player.this.isDead() && !Player.this.hasFinished() && Player.this.getHitpoints() < Player.this.getMaxHitpoints()) {
                     Player.this.heal(enhanced ? 80 : 40);
                     if (this.count-- == 0) {
                        this.stop();
                     }
                  } else {
                     this.stop();
                  }
               }
            }, 4, 2);
            this.combatDefinitions.desecreaseSpecialAttack(specAmt);
            break;
         case 1377:
         case 13472:
            this.setNextAnimation(new Animation(1056));
            this.setNextGraphics(new Graphics(246));
            this.setNextForceTalk(new ForceTalk("Raarrrrrgggggghhhhhhh!"));
            int defence = (int)((double)this.getSkills().getLevelForXp(1) * 0.9D);
            int attack = (int)((double)this.getSkills().getLevelForXp(0) * 0.9D);
            int range = (int)((double)this.getSkills().getLevelForXp(4) * 0.9D);
            int magic = (int)((double)this.getSkills().getLevelForXp(6) * 0.9D);
            int strength = (int)((double)this.getSkills().getLevelForXp(2) * 1.2D);
            this.getSkills().set(1, defence);
            this.getSkills().set(0, attack);
            this.getSkills().set(4, range);
            this.getSkills().set(6, magic);
            this.getSkills().set(2, strength);
            this.combatDefinitions.desecreaseSpecialAttack(specAmt);
         case 4153:
         case 14679:
         default:
            break;
         case 15486:
         case 22207:
         case 22209:
         case 22211:
         case 22213:
            this.setNextAnimation(new Animation(12804));
            this.setNextGraphics(new Graphics(2319));
            this.setNextGraphics(new Graphics(2321));
            this.combatDefinitions.desecreaseSpecialAttack(specAmt);
            break;
         case 24455:
         case 24456:
         case 24457:
            this.getPackets().sendGameMessage("Aren't you strong enough already?");
         }

      }
   }

   public boolean takeMoney(int amount) {
      if (this.inventory.getNumberOf(995) >= amount) {
         this.inventory.deleteItem(995, amount);
         return true;
      } else {
         return false;
      }
   }

   public void switchAcceptAid() {
      this.facade.setAcceptingAid(!this.facade.isAcceptingAid());
      this.refreshAcceptAid();
   }

   private void refreshAcceptAid() {
      this.getPackets().sendConfig(427, this.facade.isAcceptingAid() ? 1 : 0);
   }

   public void setDisableEquip(boolean equip) {
      this.disableEquip = equip;
   }

   public boolean isEquipDisabled() {
      return this.disableEquip;
   }

   public void addDisplayTime(long i) {
      this.displayTime = i + Utils.currentTimeMillis();
   }

   public long getDisplayTime() {
      return this.displayTime;
   }

   public boolean isCantTrade() {
      return this.cantTrade;
   }

   public Facade getFacade() {
      return this.facade;
   }

   public void setFacade(Facade facade) {
      this.facade = facade;
   }

   public TeleportFavorites getTeleportFavorites() {
      return this.teleportFavorites;
   }

   public int getSecondsPlayed() {
      return this.secondsPlayed;
   }

   public boolean isFrozen() {
      return this.getFreezeDelay() >= Utils.currentTimeMillis();
   }

   public void setSecondsPlayed(int secondsPlayed) {
      this.secondsPlayed = secondsPlayed;
   }

   public String getTimePlayed() {
      if (this.secondsPlayed < 600) {
         return this.secondsPlayed + " Seconds";
      } else {
         return this.secondsPlayed < 3600 ? TimeUnit.SECONDS.toMinutes((long)this.secondsPlayed) + " Minutes" : TimeUnit.SECONDS.toHours((long)this.secondsPlayed) + " Hours";
      }
   }

   public int getFriendChatSetup() {
      return this.friendChatSetup;
   }

   public VarsManager getVarsManager() {
      return this.varsManager;
   }

   public boolean isConnectedClanChannel() {
      return this.connectedClanChannel;
   }

   public void setConnectedClanChannel(boolean connectedClanChannel) {
      this.connectedClanChannel = connectedClanChannel;
   }

   public boolean containsOneItem(boolean checkBank, int... itemIds) {
      if (this.getInventory().containsOneItem(itemIds)) {
         return true;
      } else if (this.getEquipment().containsOneItem(itemIds)) {
         return true;
      } else {
         if (checkBank) {
            int[] var6 = itemIds;
            int var5 = itemIds.length;

            for(int var4 = 0; var4 < var5; ++var4) {
               int id = var6[var4];
               if (this.getBank().containsItem(id, 1)) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   public void sendSoulSplit(final Hit hit, final Entity user) {
      if (hit.getDamage() > 0) {
         World.sendProjectile((Entity)user, (Entity)this, 2263, 11, 11, 20, 5, 0, 0);
      }

      user.heal(hit.getDamage() / 5);
      WorldTasksManager.schedule(new WorldTask() {
         public void run() {
            Player.this.setNextGraphics(new Graphics(2264));
            if (hit.getDamage() > 0) {
               World.sendProjectile((Entity)Player.this, (Entity)user, 2263, 11, 11, 20, 5, 0, 0);
            }

         }
      }, 0);
   }

   public long getActionTime() {
      return this.actionTime;
   }

   public void setActionTime(long actionTime) {
      this.actionTime = actionTime;
   }

   public Runnable getCloseInterfacesEvent() {
      return this.closeInterfacesEvent;
   }

   public int getChatType() {
      return this.chatType;
   }

   public IsaacKeyPair getIsaacKeyPair() {
      return this.isaacKeyPair;
   }

   private void sendUnlockedObjectConfigs() {
      this.refreshKalphiteLair();
   }

   private void refreshKalphiteLair() {
      if (this.khalphiteLairSetted) {
         this.getVarsManager().sendVarBit(7263, 1);
      }

   }

   public void setKalphiteLair() {
      this.khalphiteLairSetted = true;
      this.refreshKalphiteLair();
   }

   public boolean isKalphiteLairSetted() {
      return this.khalphiteLairSetted;
   }

   public String getMacAddress() {
      return this.macAddress;
   }

   public void setMacAddress(String macAddress) {
      this.macAddress = macAddress;
   }

   public boolean isPlayer() {
      return true;
   }

   public long getLastLoginTime() {
      return this.lastLoginTime;
   }

   public Date getDateLastLogout() {
      return this.dateLastLoggedOut;
   }

   public void setLastLoginTime(long lastLoginTime) {
      this.lastLoginTime = lastLoginTime;
   }

   public void setSkills(Skills skills) {
      this.skills = skills;
   }

   public boolean isActivated() {
      return this.activated;
   }

   public void setActivated() {
      if (!this.activated) {
         this.activated = true;
      }

   }

   public boolean isChangedDisplay() {
      return this.changedDisplay;
   }

   public void setChangedDisplay(boolean changedDisplay) {
      this.changedDisplay = changedDisplay;
   }

   public Runnable getTeleportationEvent() {
      return this.teleportationEvent;
   }

   public void setTeleportationEvent(Runnable teleportationEvent) {
      this.teleportationEvent = teleportationEvent;
   }
}
