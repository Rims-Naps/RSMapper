package org.rsmapper.game.player;

import java.io.Serializable;
import org.rsmapper.cache.loaders.ItemDefinitions;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.item.ItemsContainer;

public final class Equipment implements Serializable {
   private static final long serialVersionUID = -4147163237095647617L;
   public static final byte SLOT_HAT = 0;
   public static final byte SLOT_CAPE = 1;
   public static final byte SLOT_AMULET = 2;
   public static final byte SLOT_WEAPON = 3;
   public static final byte SLOT_CHEST = 4;
   public static final byte SLOT_SHIELD = 5;
   public static final byte SLOT_LEGS = 7;
   public static final byte SLOT_HANDS = 9;
   public static final byte SLOT_FEET = 10;
   public static final byte SLOT_RING = 12;
   public static final byte SLOT_ARROWS = 13;
   public static final byte SLOT_AURA = 14;
   private ItemsContainer<Item> items = new ItemsContainer(15, false);
   private transient Player player;
   private transient int equipmentHpIncrease;
   static final int[] DISABLED_SLOTS = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0};

   public int size() {
      return this.items.getSize() - this.items.freeSlots();
   }

   public void setPlayer(Player player) {
      this.player = player;
   }

   public void init() {
      this.player.getPackets().sendItems(94, (ItemsContainer)this.items);
      this.refresh((int[])null);
      this.player.getAppearence().generateAppearenceData();
   }

   public void setEquipment(int slot, Item item) {
      this.getItems().set(slot, item);
      this.refresh(slot);
      this.player.getAppearence().generateAppearenceData();
   }

   public void refresh(int... slots) {
      if (slots != null) {
         this.player.getPackets().sendUpdateItems(94, (ItemsContainer)this.items, slots);
         this.player.getCombatDefinitions().checkAttackStyle();
      }

      this.player.getCombatDefinitions().refreshBonuses();
      this.refreshConfigs(slots == null);
   }

   public void reset() {
      this.items.reset();
      this.init();
   }

   public Item getItem(int slot) {
      return this.items.get(slot);
   }

   public void sendExamine(int slotId) {
      Item item = this.items.get(slotId);
      if (item != null) {
         ;
      }
   }

   public void refreshConfigs(boolean init) {
      double hpIncrease = 0.0D;

      for(int index = 0; index < this.items.getSize(); ++index) {
         Item item = this.items.get(index);
         if (item != null) {
            int id = item.getId();
            if (index == 0) {
               if (id == 20135 || id == 20137 || id == 20147 || id == 20149 || id == 20159 || id == 20161) {
                  hpIncrease += 66.0D;
               }
            } else if (index == 4) {
               if (id == 20139 || id == 20141 || id == 20151 || id == 20153 || id == 20163 || id == 20165) {
                  hpIncrease += 200.0D;
               }
            } else if (index == 7 && (id == 20143 || id == 20145 || id == 20155 || id == 20157 || id == 20167 || id == 20169)) {
               hpIncrease += 134.0D;
            }
         }
      }

      if (hpIncrease != (double)this.equipmentHpIncrease) {
         this.equipmentHpIncrease = (int)hpIncrease;
         if (!init) {
            this.player.refreshHitPoints();
         }
      }

   }

   public static boolean hideArms(Item item) {
      String name = item.getName().toLowerCase();
      if (!name.contains("d'hide body") && !name.contains("dragonhide body") && !name.equals("stripy pirate shirt") && (!name.contains("chainbody") || !name.contains("iron") && !name.contains("bronze") && !name.contains("steel") && !name.contains("black") && !name.contains("mithril") && !name.contains("adamant") && !name.contains("rune") && !name.contains("white")) && !name.equals("leather body") && !name.equals("hardleather body") && !name.contains("studded body")) {
         if (item.getId() == 17239) {
            return true;
         } else {
            return item.getDefinitions().getEquipType() == 6;
         }
      } else {
         return false;
      }
   }

   public static boolean hideHair(Item item) {
      if (item.getId() == 16691) {
         return true;
      } else {
         return item.getDefinitions().getEquipType() == 8;
      }
   }

   public static boolean showBeard(Item item) {
      String name = item.getName().toLowerCase();
      return !hideHair(item) || name.contains("horns") || name.contains("hat") || name.contains("afro") || name.contains("cowl") || name.contains("tattoo") || name.contains("headdress") || name.contains("hood") || name.contains("mask") && !name.contains("h'ween") || name.contains("helm");
   }

   public static int getItemSlot(int itemId) {
      if (itemId == 6583) {
         return 12;
      } else {
         return itemId == 16691 ? 0 : ItemDefinitions.getItemDefinitions(itemId).getEquipSlot();
      }
   }

   public boolean hasTwoHandedWeapon() {
      Item item = this.items.get(3);
      return item == null ? false : isTwoHandedWeapon(item);
   }

   public static boolean isTwoHandedWeapon(Item item) {
      return item.getDefinitions().getEquipType() == 5;
   }

   public int getWeaponRenderEmote() {
      Item weapon = this.items.get(3);
      return weapon == null ? 1426 : weapon.getDefinitions().getRenderAnimId();
   }

   public boolean hasShield() {
      return this.items.get(5) != null;
   }

   public int getWeaponId() {
      Item item = this.items.get(3);
      return item == null ? -1 : item.getId();
   }

   public int getChestId() {
      Item item = this.items.get(4);
      return item == null ? -1 : item.getId();
   }

   public int getHatId() {
      Item item = this.items.get(0);
      return item == null ? -1 : item.getId();
   }

   public int getShieldId() {
      Item item = this.items.get(5);
      return item == null ? -1 : item.getId();
   }

   public int getLegsId() {
      Item item = this.items.get(7);
      return item == null ? -1 : item.getId();
   }

   public void removeAmmo(int ammoId, int ammount) {
      if (ammount == -1) {
         this.items.remove(3, new Item(ammoId, 1));
         this.refresh(3);
      } else {
         this.items.remove(13, new Item(ammoId, ammount));
         this.refresh(13);
      }

   }

   public int getAuraId() {
      Item item = this.items.get(14);
      return item != null && InterfaceManager.getQuestGuide() != null ? item.getId() : -1;
   }

   public int getCapeId() {
      Item item = this.items.get(1);
      return item == null ? -1 : item.getId();
   }

   public int getRingId() {
      Item item = this.items.get(12);
      return item == null ? -1 : item.getId();
   }

   public int getAmmoId() {
      Item item = this.items.get(13);
      return item == null ? -1 : item.getId();
   }

   public void deleteItem(int itemId, int amount) {
      Item[] itemsBefore = this.items.getItemsCopy();
      this.items.remove(new Item(itemId, amount));
      this.refreshItems(itemsBefore);
   }

   public void refreshItems(Item[] itemsBefore) {
      int[] changedSlots = new int[itemsBefore.length];
      int count = 0;

      for(int index = 0; index < itemsBefore.length; ++index) {
         if (itemsBefore[index] != this.items.getItems()[index]) {
            changedSlots[count++] = index;
         }
      }

      int[] finalChangedSlots = new int[count];
      System.arraycopy(changedSlots, 0, finalChangedSlots, 0, count);
      this.refresh(finalChangedSlots);
   }

   public void refreshItems() {
   }

   public int getBootsId() {
      Item item = this.items.get(10);
      return item == null ? -1 : item.getId();
   }

   public int getGlovesId() {
      Item item = this.items.get(9);
      return item == null ? -1 : item.getId();
   }

   public ItemsContainer<Item> getItems() {
      return this.items;
   }

   public int getEquipmentHpIncrease() {
      return this.equipmentHpIncrease;
   }

   public void setEquipmentHpIncrease(int hp) {
      this.equipmentHpIncrease = hp;
   }

   public boolean wearingArmour() {
      for(int i = 0; i < this.items.getSize(); ++i) {
         if (this.getItem(i) != null) {
            return true;
         }
      }

      return false;
   }

   public int getAmuletId() {
      Item item = this.items.get(2);
      return item == null ? -1 : item.getId();
   }

   private static boolean isMaxed(Player player, Item item) {
      int skillId = -1;

      for(int i = 0; i < Skills.SKILL_NAME.length; ++i) {
         if (i != 24 && player.getSkills().getLevelForXp(i) < 99) {
            skillId = i;
            break;
         }
      }

      return skillId == -1;
   }

   public static boolean canWear(Item item, Player player) {
      if (item.getId() == 7462 && player.getSkills().getLevelForXp(1) < 40) {
         player.sendMessage("You are not high enough level to use this item");
         player.sendMessage("You need to have a defence level of 40.");
         return false;
      } else if (item.getId() == 7461 && player.getSkills().getLevelForXp(1) < 40) {
         player.sendMessage("You are not high enough level to use this item");
         player.sendMessage("You need to have a defence level of 40.");
         return false;
      } else if (item.getId() == 7460 && player.getSkills().getLevelForXp(1) < 8) {
         player.sendMessage("You are not high enough level to use this item");
         player.sendMessage("You need to have a defence level of 8.");
         return false;
      } else if (!item.getName().toLowerCase().contains("void")) {
         if (item.getName().toLowerCase().contains("max ")) {
            return isMaxed(player, item);
         } else {
            return !item.getName().toLowerCase().contains("completionist") || isMaxed(player, item);
         }
      } else {
         int[] skills = new int[]{0, 2, 1, 3, 4, 6};
         boolean valid = true;
         int[] var7 = skills;
         int var6 = skills.length;

         for(int var5 = 0; var5 < var6; ++var5) {
            int skill = var7[var5];
            if (player.getSkills().getLevelForXp(skill) < 42) {
               player.sendMessage("You are not high enough level to use this item");
               player.sendMessage("You need to have a " + Skills.SKILL_NAME[skill].toLowerCase() + " level of 42.");
               valid = false;
               break;
            }
         }

         if (valid && player.getSkills().getLevelForXp(5) < 22) {
            player.sendMessage("You are not high enough level to use this item");
            player.sendMessage("You need to have a prayer level of 22.");
            valid = false;
         }

         return valid;
      }
   }

   public void forceRemove(int itemId, int amount) {
      this.items.remove(new Item(itemId, amount));
   }

   public boolean containsOneItem(int... itemIds) {
      int[] var5 = itemIds;
      int var4 = itemIds.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         int itemId = var5[var3];
         if (this.items.containsOne(new Item(itemId, 1))) {
            return true;
         }
      }

      return false;
   }
}
