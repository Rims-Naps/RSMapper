package org.rsmapper.game.item;

import java.io.Serializable;

public final class ItemsContainer<T extends Item> implements Serializable {
   private static final long serialVersionUID = 1099313426737026107L;
   private Item[] data;
   private boolean alwaysStackable = false;

   public ItemsContainer(int size, boolean alwaysStackable) {
      this.data = new Item[size];
      this.alwaysStackable = alwaysStackable;
   }

   public boolean goesOverAmount(ItemsContainer<T> container) {
      for(int i = 0; i < container.getSize(); ++i) {
         Item item = container.get(i);
         if (item != null && this.getNumberOf(item) + item.getAmount() < 0) {
            return true;
         }
      }

      return false;
   }

   public void shift() {
      Item[] oldData = this.data;
      this.data = new Item[oldData.length];
      int ptr = 0;

      for(int i = 0; i < this.data.length; ++i) {
         if (oldData[i] != null) {
            this.data[ptr++] = oldData[i];
         }
      }

   }

   public T get(int slot) {
      return slot >= 0 && slot < this.data.length ? this.data[slot] : null;
   }

   public void set(int slot, T item) {
      if (slot >= 0 && slot < this.data.length) {
         this.data[slot] = item;
      }
   }

   public void set2(int slot, Item item) {
      if (slot >= 0 && slot < this.data.length) {
         this.data[slot] = item;
      }
   }

   public boolean forceAdd(T item) {
      for(int i = 0; i < this.data.length; ++i) {
         if (this.data[i] == null) {
            this.data[i] = item;
            return true;
         }
      }

      return false;
   }

   public boolean add(T item) {
      if (item == null) {
         return false;
      } else {
         int total = this.getNumberOf(item) + item.getAmount();
         if (total <= Integer.MAX_VALUE && total >= 0) {
            int i;
            if (!this.alwaysStackable && !item.getDefinitions().isStackable() && !item.getDefinitions().isNoted()) {
               if (item.getAmount() > 1) {
                  if (this.freeSlots() < item.getAmount()) {
                     return false;
                  }

                  for(i = 0; i < item.getAmount(); ++i) {
                     int index = this.freeSlot();
                     this.data[index] = new Item(item.getId(), 1);
                  }

                  return true;
               }
            } else {
               for(i = 0; i < this.data.length; ++i) {
                  if (this.data[i] != null && this.data[i].getId() == item.getId()) {
                     this.data[i] = new Item(this.data[i].getId(), this.data[i].getAmount() + item.getAmount());
                     return true;
                  }
               }
            }

            i = this.freeSlot();
            if (i == -1) {
               return false;
            } else {
               this.data[i] = item;
               return true;
            }
         } else {
            return false;
         }
      }
   }

   public int freeSlots() {
      int j = 0;
      Item[] var5;
      int var4 = (var5 = this.data).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Item aData = var5[var3];
         if (aData == null) {
            ++j;
         }
      }

      return j;
   }

   public int remove(T item) {
      int removed = 0;
      int toRemove = item.getAmount();

      for(int i = 0; i < this.data.length; ++i) {
         if (this.data[i] != null && this.data[i].getId() == item.getId()) {
            int amt = this.data[i].getAmount();
            if (amt > toRemove) {
               removed += toRemove;
               amt -= toRemove;
               int toRemove = false;
               this.data[i] = new Item(this.data[i].getId(), amt);
               return removed;
            }

            removed += amt;
            toRemove -= amt;
            this.data[i] = null;
         }
      }

      return removed;
   }

   public void removeAll(T item) {
      for(int i = 0; i < this.data.length; ++i) {
         if (this.data[i] != null && this.data[i].getId() == item.getId()) {
            this.data[i] = null;
         }
      }

   }

   public boolean containsOne(T item) {
      Item[] var5;
      int var4 = (var5 = this.data).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Item aData = var5[var3];
         if (aData != null && aData.getId() == item.getId()) {
            return true;
         }
      }

      return false;
   }

   public boolean contains(T item) {
      int amtOf = 0;
      Item[] var6;
      int var5 = (var6 = this.data).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         Item aData = var6[var4];
         if (aData != null && aData.getId() == item.getId()) {
            amtOf += aData.getAmount();
         }
      }

      if (amtOf >= item.getAmount()) {
         return true;
      } else {
         return false;
      }
   }

   public int freeSlot() {
      for(int i = 0; i < this.data.length; ++i) {
         if (this.data[i] == null) {
            return i;
         }
      }

      return -1;
   }

   public void clear() {
      for(int i = 0; i < this.data.length; ++i) {
         this.data[i] = null;
      }

   }

   public int getSize() {
      return this.data.length;
   }

   public int getFreeSlots() {
      int s = 0;
      Item[] var5;
      int var4 = (var5 = this.data).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Item aData = var5[var3];
         if (aData == null) {
            ++s;
         }
      }

      return s;
   }

   public int getUsedSlots() {
      int s = 0;
      Item[] var5;
      int var4 = (var5 = this.data).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Item aData = var5[var3];
         if (aData != null) {
            ++s;
         }
      }

      return s;
   }

   public int getNumberOf(Item item) {
      if (item == null) {
         return 0;
      } else {
         int count = 0;
         Item[] var6;
         int var5 = (var6 = this.data).length;

         for(int var4 = 0; var4 < var5; ++var4) {
            Item aData = var6[var4];
            if (aData != null && aData.getId() == item.getId()) {
               count += aData.getAmount();
            }
         }

         return count;
      }
   }

   public int getNumberOf(int item) {
      int count = 0;
      Item[] var6;
      int var5 = (var6 = this.data).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         Item aData = var6[var4];
         if (aData != null && aData.getId() == item) {
            count += aData.getAmount();
         }
      }

      return count;
   }

   public Item[] getItems() {
      return this.data;
   }

   public Item[] getItemsCopy() {
      Item[] newData = new Item[this.data.length];
      System.arraycopy(this.data, 0, newData, 0, newData.length);
      return newData;
   }

   public ItemsContainer<Item> asItemContainer() {
      ItemsContainer<Item> c = new ItemsContainer(this.data.length, this.alwaysStackable);
      System.arraycopy(this.data, 0, c.data, 0, this.data.length);
      return c;
   }

   public int getFreeSlot() {
      for(int i = 0; i < this.data.length; ++i) {
         if (this.data[i] == null) {
            return i;
         }
      }

      return -1;
   }

   public int getThisItemSlot(T item) {
      for(int i = 0; i < this.data.length; ++i) {
         if (this.data[i] != null && this.data[i].getId() == item.getId()) {
            return i;
         }
      }

      return this.getFreeSlot();
   }

   public Item lookup(int id) {
      Item[] var5;
      int var4 = (var5 = this.data).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Item aData = var5[var3];
         if (aData != null && aData.getId() == id) {
            return aData;
         }
      }

      return null;
   }

   public int lookupSlot(int id) {
      for(int i = 0; i < this.data.length; ++i) {
         if (this.data[i] != null && this.data[i].getId() == id) {
            return i;
         }
      }

      return -1;
   }

   public void reset() {
      this.data = new Item[this.data.length];
   }

   public int remove(int preferredSlot, Item item) {
      int removed = 0;
      int toRemove = item.getAmount();
      int i;
      boolean toRemove;
      if (this.data[preferredSlot] != null && this.data[preferredSlot].getId() == item.getId()) {
         i = this.data[preferredSlot].getAmount();
         if (i > toRemove) {
            removed += toRemove;
            i -= toRemove;
            toRemove = false;
            this.set2(preferredSlot, new Item(this.data[preferredSlot].getId(), i));
            return removed;
         }

         removed += i;
         toRemove -= i;
         this.set(preferredSlot, (Item)null);
      }

      for(i = 0; i < this.data.length; ++i) {
         if (this.data[i] != null && this.data[i].getId() == item.getId()) {
            int amt = this.data[i].getAmount();
            if (amt > toRemove) {
               removed += toRemove;
               amt -= toRemove;
               toRemove = false;
               this.set2(i, new Item(this.data[i].getId(), amt));
               return removed;
            }

            removed += amt;
            toRemove -= amt;
            this.set(i, (Item)null);
         }
      }

      return removed;
   }

   public void addAll(Item[] container) {
      Item[] var5 = container;
      int var4 = container.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Item item = var5[var3];
         if (item != null) {
            this.add(item);
         }
      }

   }

   public void addAll(ItemsContainer<T> container) {
      for(int i = 0; i < container.getSize(); ++i) {
         T item = container.get(i);
         if (item != null) {
            this.add(item);
         }
      }

   }

   public boolean hasSpaceFor(ItemsContainer<T> container) {
      for(int i = 0; i < container.getSize(); ++i) {
         T item = container.get(i);
         if (item != null && !this.hasSpaceForItem(item)) {
            return false;
         }
      }

      return true;
   }

   private boolean hasSpaceForItem(T item) {
      if (!this.alwaysStackable && !item.getDefinitions().isStackable() && !item.getDefinitions().isNoted()) {
         if (item.getAmount() > 1) {
            if (this.freeSlots() >= item.getAmount()) {
               return true;
            }

            return false;
         }
      } else {
         Item[] var5;
         int var4 = (var5 = this.data).length;

         for(int var3 = 0; var3 < var4; ++var3) {
            Item aData = var5[var3];
            if (aData != null && aData.getId() == item.getId()) {
               return true;
            }
         }
      }

      int index = this.freeSlot();
      return index != -1;
   }

   public Item[] toArray() {
      return this.getItems();
   }

   public boolean hasSpaceFor(Item item) {
      return this.hasSpaceForItem(item);
   }

   public String toString() {
      StringBuilder builder = new StringBuilder();
      Item[] var5;
      int var4 = (var5 = this.getItems()).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Item item = var5[var3];
         if (item != null) {
            builder.append("[" + item.getDefinitions().getName() + ": " + item.getId() + ", " + item.getAmount() + "] ");
         }
      }

      return builder.toString();
   }
}
