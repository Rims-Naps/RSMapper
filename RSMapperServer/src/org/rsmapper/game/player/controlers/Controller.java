package org.rsmapper.game.player.controlers;

import org.rsmapper.game.Entity;
import org.rsmapper.game.WorldObject;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.FloorItem;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;

public abstract class Controller {
   protected Player player;

   public final void setPlayer(Player player) {
      this.player = player;
   }

   public Player getPlayer() {
      return this.player;
   }

   public final Object[] getArguments() {
      return this.player.getControllerManager().getLastControlerArguments();
   }

   public final void setArguments(Object[] objects) {
      this.player.getControllerManager().setLastControlerArguments(objects);
   }

   public final void removeController() {
      this.player.getControllerManager().removeControllerWithoutCheck();
   }

   public abstract void start();

   public boolean canTrade(Player player) {
      return true;
   }

   public boolean handleItemOnObject(WorldObject object, Item item) {
      return true;
   }

   public boolean keepCombating(Entity target) {
      return true;
   }

   public boolean canEquip(int slotId, int itemId) {
      return true;
   }

   public boolean canAttack(Entity target) {
      return true;
   }

   public void trackXP(int skillId, int addedXp) {
   }

   public boolean canDeleteInventoryItem(int itemId, int amount) {
      return true;
   }

   public boolean canUseItemOnItem(Item itemUsed, Item usedWith) {
      return true;
   }

   public boolean canAddInventoryItem(int itemId, int amount) {
      return true;
   }

   public boolean canPlayerOption1(Player target) {
      return true;
   }

   public boolean canHit(Entity entity) {
      return true;
   }

   public void process() {
   }

   public void moved() {
   }

   public void magicTeleported(int type) {
   }

   public void sendInterfaces() {
   }

   public boolean useDialogueScript(Object key) {
      return true;
   }

   public boolean processMagicTeleport(WorldTile toTile) {
      return true;
   }

   public boolean processItemTeleport(WorldTile toTile) {
      return true;
   }

   public boolean processObjectTeleport(WorldTile toTile) {
      return true;
   }

   public boolean processObjectClick1(WorldObject object) {
      return true;
   }

   public boolean processButtonClick(int interfaceId, int componentId, int slotId, int packetId) {
      return true;
   }

   public boolean processNPCClick1(NPC npc) {
      return true;
   }

   public boolean processNPCClick2(NPC npc) {
      return true;
   }

   public boolean canSummonFamiliar() {
      return true;
   }

   public boolean processNPCClick3(NPC npc) {
      return true;
   }

   public boolean canDropItem(Item item) {
      return true;
   }

   public boolean processObjectClick2(WorldObject object) {
      return true;
   }

   public boolean processObjectClick3(WorldObject object) {
      return true;
   }

   public boolean sendDeath() {
      return true;
   }

   public boolean canMove(int dir) {
      return true;
   }

   public boolean checkWalkStep(int lastX, int lastY, int nextX, int nextY) {
      return true;
   }

   public boolean login() {
      return true;
   }

   public boolean logout() {
      return true;
   }

   public void forceClose() {
   }

   public boolean processItemOnNPC(NPC npc, Item item) {
      return true;
   }

   public boolean handleItemOption1(Player player, int slotId, int itemId, Item item) {
      return true;
   }

   public boolean canWalk() {
      return true;
   }

   public boolean canTakeItem(FloorItem item) {
      return true;
   }

   public boolean canPlayerOption2(Player target) {
      return true;
   }

   public boolean canPlayerOption3(Player target) {
      return true;
   }

   public boolean canPlayerOption4(Player target) {
      return true;
   }

   public boolean processItemOnPlayer(Player p2, Item item) {
      return true;
   }

   public boolean addWalkStep(int lastX, int lastY, int nextX, int nextY) {
      return true;
   }

   public void processNPCDeath(int id) {
   }

   public boolean processObjectClick4(WorldObject object) {
      return true;
   }

   public boolean processObjectClick5(WorldObject object) {
      return true;
   }
}
