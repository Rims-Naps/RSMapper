package org.rsmapper.game.player;

import java.io.Serializable;
import org.rsmapper.game.Entity;
import org.rsmapper.game.WorldObject;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.FloorItem;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.controlers.Controller;
import org.rsmapper.game.player.controlers.ControllerHandler;

public final class ControlerManager implements Serializable {
   private static final long serialVersionUID = 2084691334731830796L;
   private transient Player player;
   private transient Controller controler;
   private transient boolean inited;
   private Object[] lastControlerArguments;
   private String lastControler = "";

   public void setPlayer(Player player) {
      this.player = player;
   }

   public Controller getController() {
      return this.controler;
   }

   public void startController(String key, Object... parameters) {
      if (this.controler != null) {
         this.forceStop();
      }

      this.controler = ControllerHandler.getControler(key);
      if (this.controler != null) {
         this.controler.setPlayer(this.player);
         this.lastControlerArguments = parameters;
         this.lastControler = key;
         this.controler.start();
         this.inited = true;
      }
   }

   public void login() {
      if (this.lastControler != null) {
         this.controler = ControllerHandler.getControler(this.lastControler);
         if (this.controler == null) {
            this.forceStop();
         } else {
            this.controler.setPlayer(this.player);
            if (this.controler.login()) {
               this.forceStop();
            } else {
               this.inited = true;
            }

         }
      }
   }

   public void logout() {
      if (this.controler != null) {
         if (this.controler.logout()) {
            this.forceStop();
         }

      }
   }

   public boolean canWalk() {
      return this.controler != null && this.inited ? this.controler.canWalk() : true;
   }

   public boolean canTrade(Player player) {
      return this.controler != null && this.inited ? this.controler.canTrade(player) : true;
   }

   public boolean canMove(int dir) {
      return this.controler != null && this.inited ? this.controler.canMove(dir) : true;
   }

   public boolean checkWalkStep(int lastX, int lastY, int nextX, int nextY) {
      return this.controler != null && this.inited ? this.controler.checkWalkStep(lastX, lastY, nextX, nextY) : true;
   }

   public boolean keepCombating(Entity target) {
      return this.controler != null && this.inited ? this.controler.keepCombating(target) : true;
   }

   public boolean canEquip(int slotId, int itemId) {
      return this.controler != null && this.inited ? this.controler.canEquip(slotId, itemId) : true;
   }

   public boolean canAddInventoryItem(int itemId, int amount) {
      return this.controler != null && this.inited ? this.controler.canAddInventoryItem(itemId, amount) : true;
   }

   public void trackXP(int skillId, int addedXp) {
      if (this.controler != null && this.inited) {
         this.controler.trackXP(skillId, addedXp);
      }
   }

   public boolean canDeleteInventoryItem(int itemId, int amount) {
      return this.controler != null && this.inited ? this.controler.canDeleteInventoryItem(itemId, amount) : true;
   }

   public boolean canUseItemOnItem(Item itemUsed, Item usedWith) {
      return this.controler != null && this.inited ? this.controler.canUseItemOnItem(itemUsed, usedWith) : true;
   }

   public boolean canAttack(Entity entity) {
      return this.controler != null && this.inited ? this.controler.canAttack(entity) : true;
   }

   public boolean canPlayerOption1(Player target) {
      return this.controler != null && this.inited ? this.controler.canPlayerOption1(target) : true;
   }

   public boolean canHit(Entity entity) {
      return this.controler != null && this.inited ? this.controler.canHit(entity) : true;
   }

   public void moved() {
      if (this.controler != null && this.inited) {
         this.controler.moved();
      }
   }

   public void magicTeleported(int type) {
      if (this.controler != null && this.inited) {
         this.controler.magicTeleported(type);
      }
   }

   public void sendInterfaces() {
      if (this.controler != null && this.inited) {
         this.controler.sendInterfaces();
      }
   }

   public void process() {
      if (this.controler != null && this.inited) {
         this.controler.process();
      }
   }

   public boolean sendDeath() {
      return this.controler != null && this.inited ? this.controler.sendDeath() : true;
   }

   public boolean useDialogueScript(Object key) {
      return this.controler != null && this.inited ? this.controler.useDialogueScript(key) : true;
   }

   public boolean processMagicTeleport(WorldTile toTile) {
      return this.controler != null && this.inited ? this.controler.processMagicTeleport(toTile) : true;
   }

   public boolean processItemTeleport(WorldTile toTile) {
      return this.controler != null && this.inited ? this.controler.processItemTeleport(toTile) : true;
   }

   public boolean processObjectTeleport(WorldTile toTile) {
      return this.controler != null && this.inited ? this.controler.processObjectTeleport(toTile) : true;
   }

   public boolean processObjectClick1(WorldObject object) {
      return this.controler != null && this.inited ? this.controler.processObjectClick1(object) : true;
   }

   public boolean processButtonClick(int interfaceId, int componentId, int slotId, int packetId) {
      return this.controler != null && this.inited ? this.controler.processButtonClick(interfaceId, componentId, slotId, packetId) : true;
   }

   public boolean processNPCClick1(NPC npc) {
      return this.controler != null && this.inited ? this.controler.processNPCClick1(npc) : true;
   }

   public boolean processNPCClick2(NPC npc) {
      return this.controler != null && this.inited ? this.controler.processNPCClick2(npc) : true;
   }

   public boolean processNPCClick3(NPC npc) {
      return this.controler != null && this.inited ? this.controler.processNPCClick3(npc) : true;
   }

   public boolean processObjectClick2(WorldObject object) {
      return this.controler != null && this.inited ? this.controler.processObjectClick2(object) : true;
   }

   public boolean processObjectClick3(WorldObject object) {
      return this.controler != null && this.inited ? this.controler.processObjectClick3(object) : true;
   }

   public boolean processItemOnNPC(NPC npc, Item item) {
      return this.controler != null && this.inited ? this.controler.processItemOnNPC(npc, item) : true;
   }

   public void processNPCDeath(int id) {
      if (this.controler != null && this.inited) {
         this.controler.processNPCDeath(id);
      }
   }

   public boolean canSummonFamiliar() {
      return this.controler != null && this.inited ? this.controler.canSummonFamiliar() : true;
   }

   public void forceStop() {
      if (this.controler != null) {
         this.controler.forceClose();
         this.controler = null;
      }

      this.lastControlerArguments = null;
      this.lastControler = null;
      this.inited = false;
   }

   public void removeControllerWithoutCheck() {
      this.controler = null;
      this.lastControlerArguments = null;
      this.lastControler = null;
      this.inited = false;
   }

   public Object[] getLastControlerArguments() {
      return this.lastControlerArguments;
   }

   public void setLastControlerArguments(Object[] lastControlerArguments) {
      this.lastControlerArguments = lastControlerArguments;
   }

   public boolean canDropItem(Item item) {
      return this.controler != null && this.inited ? this.controler.canDropItem(item) : true;
   }

   public boolean handleItemOnObject(WorldObject object, Item item) {
      return this.controler != null && this.inited ? this.controler.handleItemOnObject(object, item) : true;
   }

   public boolean canTakeItem(FloorItem item) {
      return this.controler != null && this.inited ? this.controler.canTakeItem(item) : true;
   }

   public boolean canPlayerOption2(Player target) {
      return this.controler != null && this.inited ? this.controler.canPlayerOption2(target) : true;
   }

   public boolean canPlayerOption3(Player target) {
      return this.controler != null && this.inited ? this.controler.canPlayerOption3(target) : true;
   }

   public boolean canPlayerOption4(Player target) {
      return this.controler != null && this.inited ? this.controler.canPlayerOption4(target) : true;
   }

   public boolean processItemOnPlayer(Player p2, Item item) {
      return this.controler != null && this.inited ? this.controler.processItemOnPlayer(p2, item) : true;
   }

   public boolean addWalkStep(int lastX, int lastY, int nextX, int nextY) {
      return this.controler != null && this.inited ? this.controler.checkWalkStep(lastX, lastY, nextX, nextY) : true;
   }

   public boolean handleItemOption1(Player playerr, int slotId, int itemId, Item item) {
      if (itemId != item.getId()) {
         return false;
      } else {
         switch(itemId) {
         case -1:
            return false;
         default:
            return true;
         }
      }
   }

   public boolean processObjectClick4(WorldObject object) {
      return this.controler != null && this.inited ? this.controler.processObjectClick4(object) : true;
   }

   public boolean processObjectClick5(WorldObject object) {
      return this.controler != null && this.inited ? this.controler.processObjectClick5(object) : true;
   }
}
