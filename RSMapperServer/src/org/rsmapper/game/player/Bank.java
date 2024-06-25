package org.rsmapper.game.player;

import com.dropbox.core.DbxRequestConfig;
import java.io.Serializable;
import org.rsmapper.cache.loaders.ItemDefinitions;
import org.rsmapper.game.item.Item;

public class Bank implements Serializable {
   private static final long serialVersionUID = 1551246756081236625L;
   private Item[][] bankTabs = new Item[1][0];
   private transient Player player;
   private transient int currentTab;
   private transient Item[] lastContainerCopy;
   private transient boolean withdrawNotes;
   private transient boolean insertItems;
   private static final long MAX_BANK_SIZE = 506L;
   private int lastX;

   public void setPlayer(Player player) {
      this.player = player;
      if (this.bankTabs == null || this.bankTabs.length == 0) {
         this.bankTabs = new Item[1][0];
      }

   }

   public void openDepositBox() {
      this.player.getInterfaceManager().sendInterface(11);
      this.player.getInterfaceManager().closeInventory();
      this.player.getInterfaceManager().closeEquipment();
      final int lastGameTab = this.player.getInterfaceManager().openGameTab(9);
      this.sendBoxInterItems();
      this.player.getPackets().sendIComponentText(11, 13, "Bank Of RS Mapper - Deposit Box");
      this.player.setCloseInterfacesEvent(new Runnable() {
         public void run() {
            Bank.this.player.getInterfaceManager().sendInventory();
            Bank.this.player.getInventory().unlockInventoryOptions();
            Bank.this.player.getInterfaceManager().sendEquipment();
            Bank.this.player.getInterfaceManager().openGameTab(lastGameTab);
         }
      });
   }

   public void sendBoxInterItems() {
      this.player.getPackets().sendInterSetItemsOptionsScript(11, 17, 93, 6, 5, "Deposit-1", "Deposit-5", "Deposit-10", "Deposit-All", "Deposit-X", "Examine");
      this.player.getPackets().sendUnlockIComponentOptionSlots(11, 17, 0, 27, 0, 1, 2, 3, 4, 5);
   }

   public void openBank() {
      this.player.getInterfaceManager().sendInterface(762);
      this.player.getInterfaceManager().sendInventoryInterface(763);
      this.refreshViewingTab();
      this.refreshTabs();
      this.unlockButtons();
      this.sendItems();
      this.refreshLastX();
      this.player.getPackets().sendHideIComponent(762, 28, true);
      this.player.getPackets().sendIComponentText(762, 31, "22");
      this.player.getPackets().sendIComponentText(762, 32, "22");
   }

   public void refreshTabs() {
      for(int slot = 1; slot < 9; ++slot) {
         this.refreshTab(slot);
      }

   }

   public int getTabSize(int slot) {
      return slot >= this.bankTabs.length ? 0 : this.bankTabs[slot].length;
   }

   public void withdrawLastAmount(int bankSlot) {
      this.withdrawItem(bankSlot, this.lastX);
   }

   public void withdrawItemButOne(int fakeSlot) {
      int[] fromRealSlot = this.getRealSlot(fakeSlot);
      Item item = this.getItem(fromRealSlot);
      if (item != null) {
         if (item.getAmount() <= 1) {
            DbxRequestConfig.newBuilder("dropbox").build();
            this.player.getPackets().sendGameMessage("You only have one of this item in your bank");
         } else {
            this.withdrawItem(fakeSlot, item.getAmount() - 1);
         }
      }
   }

   public void depositLastAmount(int bankSlot) {
      this.depositItem(bankSlot, this.getLastX(), true);
   }

   public void openPlayerBank(Player victim) {
      if (victim != null) {
         this.player.getInterfaceManager().sendInterface(762);
         this.player.getInterfaceManager().sendInventoryInterface(763);
         this.player.getPackets().sendItems(95, (Item[])victim.getBank().getContainerCopy());
         this.refreshViewingTab();
         this.refreshTabs();
         this.unlockButtons();
      }
   }

   public void depositAllInventory(boolean banking) {
      int count = this.player.getInventory().getItemsContainerSize();
      Item[] var6;
      int var5 = (var6 = this.player.getInventory().getItems().getItems()).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         Item item = var6[var4];
         if (item != null && this.getItem(item.getId()) != null) {
            --count;
         }
      }

      if (506L - (long)count < (long)this.player.getInventory().getItems().getSize()) {
         this.player.getPackets().sendGameMessage("Not enough space in your bank.");
      } else {
         for(int i = 0; i < 28; ++i) {
            this.depositItem(i, Integer.MAX_VALUE, false);
         }

         this.refreshTab(this.currentTab);
         this.refreshItems();
      }
   }

   public void depositAllEquipment(boolean banking) {
      int space = this.addItems(this.player.getEquipment().getItems().getItems(), banking);
      if (space != 0) {
         for(int i = 0; i < space; ++i) {
            this.player.getEquipment().getItems().set(i, (Item)null);
         }

         this.player.getEquipment().init();
         this.player.getAppearence().generateAppearenceData();
      }

      if (space < this.player.getEquipment().getItems().getSize()) {
         this.player.getPackets().sendGameMessage("Not enough space in your bank.");
      }
   }

   public void refreshLastX() {
      this.player.getPackets().sendConfig(1249, this.getLastX());
   }

   public void collapse(int tabId) {
      if (tabId != 0) {
         Item[] items = this.bankTabs[tabId];
         Item[] var6 = items;
         int var5 = items.length;

         Item item;
         int var4;
         for(var4 = 0; var4 < var5; ++var4) {
            item = var6[var4];
            this.removeItem(this.getItemSlot(item.getId()), item.getAmount(), false, true);
         }

         var6 = items;
         var5 = items.length;

         for(var4 = 0; var4 < var5; ++var4) {
            item = var6[var4];
            this.addItem(item.getId(), item.getAmount(), 0, false);
         }

         this.refreshTabs();
         this.refreshItems();
      }
   }

   public boolean containsItem(int itemId, int amount) {
      Item[][] var6;
      int var5 = (var6 = this.bankTabs).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         Item[] bankTab = var6[var4];
         Item[] var10 = bankTab;
         int var9 = bankTab.length;

         for(int var8 = 0; var8 < var9; ++var8) {
            Item item = var10[var8];
            if (item.getId() == itemId && item.getAmount() >= amount) {
               return true;
            }
         }
      }

      return false;
   }

   public void switchItem(int fromSlot, int toSlot, int fromComponentId, int toComponentId) {
      if (toSlot == 65535) {
         int toTab = toComponentId >= 74 ? 8 - (82 - toComponentId) : 9 - (toComponentId - 44) / 2;
         if (toTab < 0 || toTab > 9) {
            return;
         }

         int[] fromRealSlot;
         Item item;
         if (this.bankTabs.length == toTab) {
            fromRealSlot = this.getRealSlot(fromSlot);
            if (fromRealSlot == null) {
               return;
            }

            if (toTab == fromRealSlot[0]) {
               this.switchItem(fromSlot, this.getStartSlot(toTab));
               return;
            }

            item = this.getItem(fromRealSlot);
            if (item == null) {
               return;
            }

            this.removeItem(fromSlot, item.getAmount(), false, true);
            this.createTab();
            this.bankTabs[this.bankTabs.length - 1] = new Item[]{item};
            this.refreshTab(fromRealSlot[0]);
            this.refreshTab(toTab);
            this.refreshItems();
         } else if (this.bankTabs.length > toTab) {
            fromRealSlot = this.getRealSlot(fromSlot);
            if (fromRealSlot == null) {
               return;
            }

            if (toTab == fromRealSlot[0]) {
               this.switchItem(fromSlot, this.getStartSlot(toTab));
               return;
            }

            item = this.getItem(fromRealSlot);
            if (item == null) {
               return;
            }

            boolean removed = this.removeItem(fromSlot, item.getAmount(), false, true);
            if (!removed) {
               this.refreshTab(fromRealSlot[0]);
            } else if (fromRealSlot[0] != 0 && toTab >= fromRealSlot[0]) {
               --toTab;
            }

            this.refreshTab(fromRealSlot[0]);
            this.addItem(item.getId(), item.getAmount(), toTab, true);
         }
      } else if (this.insertItems) {
         this.insertItem(fromSlot, toSlot);
      } else {
         this.switchItem(fromSlot, toSlot);
      }

   }

   public void insertItem(int fromSlot, int toSlot) {
      int[] fromRealSlot = this.getRealSlot(fromSlot);
      Item fromItem = this.getItem(fromRealSlot);
      if (fromItem != null) {
         int[] toRealSlot = this.getRealSlot(toSlot);
         Item toItem = this.getItem(toRealSlot);
         if (toItem != null) {
            if (toRealSlot[0] != fromRealSlot[0]) {
               this.bankTabs[fromRealSlot[0]][fromRealSlot[1]] = toItem;
               this.bankTabs[toRealSlot[0]][toRealSlot[1]] = fromItem;
            } else {
               int i;
               Item toShift;
               if (toRealSlot[1] > fromRealSlot[1]) {
                  for(i = fromRealSlot[1]; i < toRealSlot[1]; ++i) {
                     toShift = this.bankTabs[toRealSlot[0]][++fromRealSlot[1]];
                     this.bankTabs[fromRealSlot[0]][i] = toShift;
                  }
               } else if (fromRealSlot[1] > toRealSlot[1]) {
                  for(i = fromRealSlot[1]; i > toRealSlot[1]; --i) {
                     toShift = this.bankTabs[toRealSlot[0]][--fromRealSlot[1]];
                     this.bankTabs[fromRealSlot[0]][i] = toShift;
                  }
               }

               this.bankTabs[toRealSlot[0]][toRealSlot[1]] = fromItem;
            }

            this.refreshTab(fromRealSlot[0]);
            if (fromRealSlot[0] != toRealSlot[0]) {
               this.refreshTab(toRealSlot[0]);
            }

            this.refreshItems();
         }
      }
   }

   public void switchItem(int fromSlot, int toSlot) {
      int[] fromRealSlot = this.getRealSlot(fromSlot);
      Item fromItem = this.getItem(fromRealSlot);
      if (fromItem != null) {
         int[] toRealSlot = this.getRealSlot(toSlot);
         Item toItem = this.getItem(toRealSlot);
         if (toItem != null) {
            this.bankTabs[fromRealSlot[0]][fromRealSlot[1]] = toItem;
            this.bankTabs[toRealSlot[0]][toRealSlot[1]] = fromItem;
            this.refreshTab(fromRealSlot[0]);
            if (fromRealSlot[0] != toRealSlot[0]) {
               this.refreshTab(toRealSlot[0]);
            }

            this.refreshItems();
         }
      }
   }

   public void createTab() {
      int slot = this.bankTabs.length;
      Item[][] tabs = new Item[slot + 1][];
      System.arraycopy(this.bankTabs, 0, tabs, 0, slot);
      tabs[slot] = new Item[0];
      this.bankTabs = tabs;
   }

   public void destroyTab(int slot) {
      Item[][] tabs = new Item[this.bankTabs.length - 1][];
      System.arraycopy(this.bankTabs, 0, tabs, 0, slot);
      System.arraycopy(this.bankTabs, slot + 1, tabs, slot, this.bankTabs.length - slot - 1);
      this.bankTabs = tabs;
      if (this.currentTab != 0 && this.currentTab >= slot) {
         --this.currentTab;
      }

   }

   public boolean hasBankSpace() {
      return (long)this.getBankSize() < 506L;
   }

   public void withdrawItem(int bankSlot, int quantity) {
      if (quantity >= 1 && this.player.getInterfaceManager().containsInterface(762)) {
         Item item = this.getItem(this.getRealSlot(bankSlot));
         if (item != null) {
            if (item.getAmount() < quantity) {
               item = new Item(item.getId(), item.getAmount());
            } else {
               item = new Item(item.getId(), quantity);
            }

            boolean noted = false;
            ItemDefinitions defs = item.getDefinitions();
            if (this.withdrawNotes) {
               if (!defs.isNoted() && defs.getCertId() != -1) {
                  item.setId(defs.getCertId());
                  noted = true;
               } else {
                  this.player.getPackets().sendGameMessage("You cannot withdraw this item as a note.");
               }
            }

            int freeSlots;
            if (!noted && !defs.isStackable()) {
               freeSlots = this.player.getInventory().getFreeSlots();
               if (freeSlots == 0) {
                  this.player.getPackets().sendGameMessage("Not enough space in your inventory.");
                  return;
               }

               if (freeSlots < item.getAmount()) {
                  item.setAmount(freeSlots);
                  this.player.getPackets().sendGameMessage("Not enough space in your inventory.");
               }
            } else if (this.player.getInventory().getItems().containsOne(item)) {
               freeSlots = this.player.getInventory().getItems().getThisItemSlot(item);
               Item invItem = this.player.getInventory().getItems().get(freeSlots);
               if (invItem.getAmount() + item.getAmount() <= 0) {
                  item.setAmount(Integer.MAX_VALUE - invItem.getAmount());
                  this.player.getPackets().sendGameMessage("Not enough space in your inventory.");
               }
            } else if (!this.player.getInventory().hasFreeSlots()) {
               this.player.getPackets().sendGameMessage("Not enough space in your inventory.");
               return;
            }

            this.removeItem(bankSlot, item.getAmount(), true, false);
            this.player.getInventory().addItem(item);
         }
      }
   }

   public void sendExamine(int fakeSlot) {
      int[] slot = this.getRealSlot(fakeSlot);
      if (slot != null) {
         Item item = this.bankTabs[slot[0]][slot[1]];
      }
   }

   public void depositItem(int invSlot, int quantity, boolean refresh) {
      if (quantity >= 1 && invSlot >= 0 && invSlot <= 27 && InterfaceManager.getQuestGuide() != null) {
         Item item = this.player.getInventory().getItem(invSlot);
         if (item != null) {
            int amt = this.player.getInventory().getItems().getNumberOf(item);
            if (amt < quantity) {
               item = new Item(item.getId(), amt);
            } else {
               item = new Item(item.getId(), quantity);
            }

            ItemDefinitions defs = item.getDefinitions();
            int originalId = item.getId();
            if (defs.isNoted() && defs.getCertId() != -1) {
               item.setId(defs.getCertId());
            }

            this.player.getInventory().deleteItem(invSlot, new Item(originalId, item.getAmount()));
            this.addItem(item, refresh);
         }
      }
   }

   public void addItem(Item item, boolean refresh) {
      this.addItem(item.getId(), item.getAmount(), refresh);
   }

   public int addItems(Item[] items, boolean refresh) {
      int space = (int)(506L - (long)this.getBankSize());
      if (space != 0) {
         space = space < items.length ? space : items.length;

         for(int i = 0; i < space; ++i) {
            if (items[i] != null) {
               this.addItem(items[i], false);
            }
         }

         if (refresh) {
            this.refreshTabs();
            this.refreshItems();
         }
      }

      return space;
   }

   public void addItem(int id, int quantity, boolean refresh) {
      this.addItem(id, quantity, this.currentTab, refresh);
   }

   public void addItem(int id, int quantity, int creationTab, boolean refresh) {
      long total = (long)quantity + this.getNumberOf(id);
      if (id == 995 && total > 2147483647L) {
         long change = total - 2147483647L;
         this.player.getInventory().addItem(id, (int)change);
         int banked = (int)(2147483647L - this.getNumberOf(id));
         if (banked > 0) {
            this.addItem(id, banked, creationTab, refresh);
         }

      } else {
         int[] slotInfo = this.getItemSlot(id);
         if (slotInfo == null) {
            if (creationTab >= this.bankTabs.length) {
               creationTab = this.bankTabs.length - 1;
            }

            if (creationTab < 0) {
               creationTab = 0;
            }

            int slot = this.bankTabs[creationTab].length;
            Item[] tab = new Item[slot + 1];
            System.arraycopy(this.bankTabs[creationTab], 0, tab, 0, slot);
            tab[slot] = new Item(id, quantity);
            this.bankTabs[creationTab] = tab;
            if (refresh) {
               this.refreshTab(creationTab);
            }
         } else {
            Item item = this.bankTabs[slotInfo[0]][slotInfo[1]];
            this.bankTabs[slotInfo[0]][slotInfo[1]] = new Item(item.getId(), item.getAmount() + quantity);
         }

         if (refresh) {
            this.refreshItems();
         }

      }
   }

   public long getNumberOf(int id) {
      int count = 0;
      Item[] var6;
      int var5 = (var6 = this.getContainerCopy()).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         Item i = var6[var4];
         count += i.getAmount();
      }

      return (long)count;
   }

   public void removeItem(int id) {
      if (this.bankTabs != null) {
         Item[][] var5;
         int var4 = (var5 = this.bankTabs).length;

         for(int var3 = 0; var3 < var4; ++var3) {
            Item[] bankTab = var5[var3];

            for(int i2 = 0; i2 < bankTab.length; ++i2) {
               if (bankTab[i2].getId() == id) {
                  bankTab[i2].setId(0);
               }
            }
         }
      }

   }

   public boolean removeItem(int fakeSlot, int quantity, boolean refresh, boolean forceDestroy) {
      return this.removeItem(this.getRealSlot(fakeSlot), quantity, refresh, forceDestroy);
   }

   public boolean removeItem(int[] slot, int quantity, boolean refresh, boolean forceDestroy) {
      if (slot == null) {
         return false;
      } else {
         Item item = this.bankTabs[slot[0]][slot[1]];
         boolean destroyed = false;
         if (quantity >= item.getAmount()) {
            if (this.bankTabs[slot[0]].length == 1 && (forceDestroy || this.bankTabs.length != 1)) {
               this.destroyTab(slot[0]);
               this.refreshTabs();
               destroyed = true;
            } else {
               Item[] tab = new Item[this.bankTabs[slot[0]].length - 1];
               System.arraycopy(this.bankTabs[slot[0]], 0, tab, 0, slot[1]);
               System.arraycopy(this.bankTabs[slot[0]], slot[1] + 1, tab, slot[1], this.bankTabs[slot[0]].length - slot[1] - 1);
               this.bankTabs[slot[0]] = tab;
               if (refresh) {
                  this.refreshTab(slot[0]);
               }
            }
         } else {
            this.bankTabs[slot[0]][slot[1]] = new Item(item.getId(), item.getAmount() - quantity);
         }

         if (refresh) {
            this.refreshItems();
         }

         return destroyed;
      }
   }

   public Item getItem(int id) {
      Item[][] var5;
      int var4 = (var5 = this.bankTabs).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Item[] bankTab = var5[var3];
         Item[] var9 = bankTab;
         int var8 = bankTab.length;

         for(int var7 = 0; var7 < var8; ++var7) {
            Item item = var9[var7];
            if (item.getId() == id) {
               return item;
            }
         }
      }

      return null;
   }

   public int[] getItemSlot(int id) {
      for(int tab = 0; tab < this.bankTabs.length; ++tab) {
         for(int slot = 0; slot < this.bankTabs[tab].length; ++slot) {
            if (this.bankTabs[tab][slot].getId() == id) {
               return new int[]{tab, slot};
            }
         }
      }

      return null;
   }

   public Item getItem(int[] slot) {
      return slot == null ? null : this.bankTabs[slot[0]][slot[1]];
   }

   public int getStartSlot(int tabId) {
      int slotId = 0;

      for(int tab = 1; tab < (tabId == 0 ? this.bankTabs.length : tabId); ++tab) {
         slotId += this.bankTabs[tab].length;
      }

      return slotId;
   }

   public int[] getRealSlot(int slot) {
      for(int tab = 1; tab < this.bankTabs.length; ++tab) {
         if (slot < this.bankTabs[tab].length) {
            return new int[]{tab, slot};
         }

         slot -= this.bankTabs[tab].length;
      }

      return slot >= this.bankTabs[0].length ? null : new int[]{0, slot};
   }

   public void refreshViewingTab() {
      this.player.getPackets().sendConfigByFile(4893, this.currentTab + 1);
   }

   public void refreshTab(int slot) {
      if (slot != 0) {
         this.player.getPackets().sendConfigByFile(4885 + (slot - 1), this.getTabSize(slot));
         this.refreshViewingTab();
      }
   }

   public void sendItems() {
      this.player.getPackets().sendItems(95, (Item[])this.getContainerCopy());
   }

   public void refreshItems(int[] slots) {
      this.player.getPackets().sendUpdateItems(95, (Item[])this.getContainerCopy(), slots);
   }

   public Item[] getContainerCopy() {
      if (this.lastContainerCopy == null) {
         this.lastContainerCopy = this.generateContainer();
      }

      return this.lastContainerCopy;
   }

   public void refreshItems() {
      this.refreshItems(this.generateContainer(), this.getContainerCopy());
   }

   public void refreshItems(Item[] itemsAfter, Item[] itemsBefore) {
      if (itemsBefore.length != itemsAfter.length) {
         this.lastContainerCopy = itemsAfter;
         this.sendItems();
      } else {
         int[] changedSlots = new int[itemsAfter.length];
         int count = 0;

         for(int index = 0; index < itemsAfter.length; ++index) {
            if (itemsBefore[index] != itemsAfter[index]) {
               changedSlots[count++] = index;
            }
         }

         int[] finalChangedSlots = new int[count];
         System.arraycopy(changedSlots, 0, finalChangedSlots, 0, count);
         this.lastContainerCopy = itemsAfter;
         this.refreshItems(finalChangedSlots);
      }
   }

   public int getBankSize() {
      int size = 0;
      Item[][] var5;
      int var4 = (var5 = this.bankTabs).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         Item[] bankTab = var5[var3];
         size += bankTab.length;
      }

      return size;
   }

   public Item[] generateContainer() {
      Item[] container = new Item[this.getBankSize()];
      int count = 0;

      for(int slot = 1; slot < this.bankTabs.length; ++slot) {
         System.arraycopy(this.bankTabs[slot], 0, container, count, this.bankTabs[slot].length);
         count += this.bankTabs[slot].length;
      }

      System.arraycopy(this.bankTabs[0], 0, container, count, this.bankTabs[0].length);
      return container;
   }

   public void unlockButtons() {
      int interfaceId = 762;
      this.player.getPackets().sendHideIComponent(interfaceId, 117, true);
      this.player.getPackets().sendHideIComponent(interfaceId, 118, true);
      this.player.getPackets().sendIComponentSettings(interfaceId, 93, 0, 516, 2622718);
      this.player.getPackets().sendIComponentSettings(763, 0, 0, 27, 2425982);
   }

   public void switchWithdrawNotes() {
      this.withdrawNotes = !this.withdrawNotes;
   }

   public void switchInsertItems() {
      this.insertItems = !this.insertItems;
      this.player.getPackets().sendConfig(305, this.insertItems ? 1 : 0);
   }

   public void setCurrentTab(int currentTab) {
      if (currentTab < this.bankTabs.length) {
         this.currentTab = currentTab;
      }
   }

   public void forceRemove(int id) {
      if (this.bankTabs != null) {
         Item[][] var5;
         int var4 = (var5 = this.bankTabs).length;

         for(int var3 = 0; var3 < var4; ++var3) {
            Item[] bankTab = var5[var3];
            Item[] var9 = bankTab;
            int var8 = bankTab.length;

            for(int var7 = 0; var7 < var8; ++var7) {
               Item element = var9[var7];
               if (element.getId() == id) {
                  element.setId(995);
                  element.setAmount(100);
               }
            }
         }
      }

   }

   public int getLastX() {
      return this.lastX;
   }

   public void setLastX(int lastX) {
      this.lastX = lastX;
   }

   public void resetItems() {
      this.bankTabs = new Item[1][0];
   }
}
