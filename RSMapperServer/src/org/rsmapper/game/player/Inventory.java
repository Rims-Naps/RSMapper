package org.rsmapper.game.player;

import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import org.rsmapper.game.World;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.item.ItemsContainer;
import org.rsmapper.utilities.misc.Utils;

public final class Inventory implements Serializable {
   private static final long serialVersionUID = 8842800123753277093L;
   private ItemsContainer<Item> items = new ItemsContainer(28, false);
   private transient Player player;
   public static final int INVENTORY_INTERFACE = 679;

   public int size() {
      return this.items.getSize() - this.items.freeSlots();
   }

   public void setPlayer(Player player) {
      this.player = player;
   }

   public void init() {
      this.player.getPackets().sendItems(93, (ItemsContainer)this.items);
   }

   public int getCoinsAmount() {
      int coins = this.items.getNumberOf(995);
      return coins < 0 ? Integer.MAX_VALUE : coins;
   }

   public void unlockInventoryOptions() {
      this.player.getPackets().sendIComponentSettings(679, 0, 0, 27, 4554126);
      this.player.getPackets().sendIComponentSettings(679, 0, 28, 55, 2097152);
   }

   public void reset() {
      this.items.reset();
      this.init();
      this.refresh();
   }

   public void refresh(int... slots) {
      this.player.getPackets().sendUpdateItems(93, (ItemsContainer)this.items, slots);
   }

   public void addAll(ItemsContainer<Item> items) {
      if (items != null) {
         for(int i = 0; i < items.getSize(); ++i) {
            if (items.get(i) != null) {
               this.items.add(items.get(i));
            }
         }
      }

   }

   public void refresh(ItemsContainer<Item> items) {
      if (items != null && this.player != null) {
         this.player.getPackets().sendItems(93, (ItemsContainer)items);
      }

   }

   public boolean addItem(int itemId, int amount) {
      if (itemId >= 0 && amount >= 0 && itemId < Utils.getItemDefinitionsSize() && this.player.getControllerManager().canAddInventoryItem(itemId, amount)) {
         Item[] itemsBefore = this.items.getItemsCopy();
         if (!this.items.add(new Item(itemId, amount))) {
            this.items.add(new Item(itemId, this.items.getFreeSlots()));
            this.player.getPackets().sendGameMessage("Not enough space in your inventory.");
            this.refreshItems(itemsBefore);
            return false;
         } else {
            this.refreshItems(itemsBefore);
            return true;
         }
      } else {
         return false;
      }
   }

   public void addMassItem(Item... items) {
      boolean banked = false;
      Item item;
      int var4;
      int var5;
      Item[] var6;
      if (this.player.getControllerManager().getController() == null) {
         var6 = items;
         var5 = items.length;

         for(var4 = 0; var4 < var5; ++var4) {
            item = var6[var4];
            if (!this.player.getInventory().getItems().hasSpaceFor(item)) {
               this.player.getBank().addItem(item.getId(), item.getAmount(), true);
               banked = true;
            } else if (!this.player.getInventory().addItem(item)) {
               this.player.getBank().addItem(item.getId(), item.getAmount(), true);
               banked = true;
            }
         }
      } else {
         var6 = items;
         var5 = items.length;

         for(var4 = 0; var4 < var5; ++var4) {
            item = var6[var4];
            this.player.getBank().addItem(item.getId(), item.getAmount(), true);
            banked = true;
         }
      }

      if (banked) {
         this.player.sendMessage("You did not have space for an item so it was placed in your bank!");
      }

   }

   public boolean addItem(Item item) {
      if (item.getId() >= 0 && item.getAmount() >= 0 && item.getId() < Utils.getItemDefinitionsSize() && this.player.getControllerManager().canAddInventoryItem(item.getId(), item.getAmount())) {
         int result = this.getNumberOf(item.getId()) + item.getAmount();
         if (item.getId() == 995 && (result < 0 || result > Integer.MAX_VALUE)) {
            this.player.getPackets().sendGameMessage("You cannot hold such a large amount of cash in your inventory.");
            World.addGroundItem(item, this.player, this.player, true, 300L);
            return false;
         } else {
            Item[] itemsBefore = this.items.getItemsCopy();
            if (!this.items.add(item)) {
               this.items.add(new Item(item.getId(), this.items.getFreeSlots()));
               this.player.getPackets().sendGameMessage("Not enough space in your inventory.");
               this.refreshItems(itemsBefore);
               return false;
            } else {
               this.refreshItems(itemsBefore);
               return true;
            }
         }
      } else {
         return false;
      }
   }

   public void deleteItem(int slot, Item item) {
      if (this.player.getControllerManager().canDeleteInventoryItem(item.getId(), item.getAmount())) {
         Item[] itemsBefore = this.items.getItemsCopy();
         this.items.remove(slot, item);
         this.refreshItems(itemsBefore);
      }
   }

   public boolean removeItems(Item... list) {
      Item[] var5 = list;
      int var4 = list.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Item item = var5[var3];
         if (item != null) {
            this.deleteItem(item);
         }
      }

      return true;
   }

   public boolean removeItems(List<Item> list) {
      Iterator var3 = list.iterator();

      while(var3.hasNext()) {
         Item item = (Item)var3.next();
         if (item != null) {
            this.deleteItem(item);
         }
      }

      return true;
   }

   public void deleteItem(int itemId, int amount) {
      if (this.player.getControllerManager().canDeleteInventoryItem(itemId, amount)) {
         Item[] itemsBefore = this.items.getItemsCopy();
         this.items.remove(new Item(itemId, amount));
         this.refreshItems(itemsBefore);
      }
   }

   public void deleteItem(Item item) {
      if (this.player.getControllerManager().canDeleteInventoryItem(item.getId(), item.getAmount())) {
         Item[] itemsBefore = this.items.getItemsCopy();
         this.items.remove(item);
         this.refreshItems(itemsBefore);
      }
   }

   public void switchItem(int fromSlot, int toSlot) {
      Item[] itemsBefore = this.items.getItemsCopy();
      Item fromItem = this.items.get(fromSlot);
      Item toItem = this.items.get(toSlot);
      this.items.set(fromSlot, toItem);
      this.items.set(toSlot, fromItem);
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

   public ItemsContainer<Item> getItems() {
      return this.items;
   }

   public boolean hasFreeSlots() {
      return this.items.getFreeSlot() != -1;
   }

   public int getFreeSlots() {
      return this.items.getFreeSlots();
   }

   public Item getItem(int slot) {
      return this.items.get(slot);
   }

   public int getItemsContainerSize() {
      return this.items.getSize();
   }

   public void addDroppable(Item item) {
      if (item.getId() >= 0 && item.getAmount() >= 0 && Utils.itemExists(item.getId()) && this.player.getControllerManager().canAddInventoryItem(item.getId(), item.getAmount())) {
         boolean canAdd = true;
         if (this.getFreeSlots() == 0) {
            if (this.contains(item.getId())) {
               if (!item.getDefinitions().isStackable() || this.getAmountOf(item.getId()) + item.getAmount() > Integer.MAX_VALUE) {
                  canAdd = false;
               }
            } else {
               canAdd = false;
            }
         }

         Item[] itemsBefore = this.items.getItemsCopy();
         if (!canAdd) {
            this.player.getPackets().sendGameMessage("Not enough inventory space for this item!");
            World.addGroundItem(item, this.player, this.player, true, 60L);
         } else {
            this.items.add(item);
         }

         this.refreshItems(itemsBefore);
      }
   }

   public boolean contains(int itemId) {
      return this.items.contains(new Item(itemId, 1));
   }

   public boolean containsItems(Item[] item) {
      for(int i = 0; i < item.length; ++i) {
         if (!this.items.contains(item[i])) {
            return false;
         }
      }

      return true;
   }

   public boolean containsItems(List<Item> list) {
      Iterator var3 = list.iterator();

      while(var3.hasNext()) {
         Item item = (Item)var3.next();
         if (!this.items.contains(item)) {
            return false;
         }
      }

      return true;
   }

   public boolean containsItems(int[] itemIds, int[] ammounts) {
      int size = itemIds.length > ammounts.length ? ammounts.length : itemIds.length;

      for(int i = 0; i < size; ++i) {
         if (!this.items.contains(new Item(itemIds[i], ammounts[i]))) {
            return false;
         }
      }

      return true;
   }

   public boolean containsItem(int itemId, int amount) {
      return this.items.contains(new Item(itemId, amount));
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

   public void sendExamine(int slotId) {
      if (slotId < this.getItemsContainerSize()) {
         Item item = this.items.get(slotId);
         if (item != null) {
            ;
         }
      }
   }

   public int getNumberOf(int itemId) {
      return this.items.getNumberOf(itemId);
   }

   public void replaceItem(int id, int amount, int slot) {
      Item item = this.items.get(slot);
      if (item != null) {
         item.setId(id);
         item.setAmount(amount);
         this.refresh(slot);
      }
   }

   public boolean addItemDrop(int itemId, int amount, WorldTile tile) {
      if (itemId >= 0 && amount >= 0 && Utils.itemExists(itemId) && this.player.getControllerManager().canAddInventoryItem(itemId, amount)) {
         Item[] itemsBefore = this.items.getItemsCopy();
         Item item = new Item(itemId, amount);
         if (!this.items.add(item)) {
            if (!item.getDefinitions().isNoted() && !item.getDefinitions().isStackable() && item.getDefinitions().getCertId() != -1) {
               item.setId(item.getDefinitions().getCertId());
               if (this.items.add(item)) {
                  this.refreshItems(itemsBefore);
                  return true;
               }
            }

            World.addGroundItem(item, tile, this.player, true, 180L);
         } else {
            this.refreshItems(itemsBefore);
         }

         return true;
      } else {
         return false;
      }
   }

   public void forceRemove(int itemId, int amount) {
      this.items.remove(new Item(itemId, amount));
   }

   public boolean addItemDrop(int itemId, int amount) {
      return this.addItemDrop(itemId, amount, new WorldTile(this.player));
   }

   public int getAmountOf(int itemId) {
      return this.items.getNumberOf(itemId);
   }
}
