package org.rsmapper.game.item;

import java.io.Serializable;
import org.rsmapper.cache.loaders.ItemDefinitions;
import org.rsmapper.cache.loaders.ItemEquipIds;

public class Item implements Serializable {
   private static final long serialVersionUID = -6485003878697568087L;
   private short id;
   protected int amount;

   public int getId() {
      return this.id;
   }

   public int getModelId() {
      return this.getDefinitions().modelId;
   }

   public Item clone() {
      return new Item(this.id, this.amount);
   }

   public Item(int id) {
      this(id, 1);
   }

   public Item(int id, int amount) {
      this(id, amount, false);
   }

   public Item(int id, int amount, boolean amt0) {
      this.id = (short)id;
      this.amount = amount;
      if (this.amount <= 0 && !amt0) {
         this.amount = 1;
      }

   }

   public ItemDefinitions getDefinitions() {
      return ItemDefinitions.getItemDefinitions(this.id);
   }

   public int getEquipId() {
      return ItemEquipIds.getEquipId(this.id);
   }

   public void setAmount(int amount) {
      this.amount = amount;
   }

   public void setId(int id) {
      this.id = (short)id;
   }

   public int getAmount() {
      return this.amount;
   }

   public String toString() {
      return "Item[" + this.id + ", " + this.getAmount() + ", " + this.getDefinitions().getName() + "]";
   }

   public String getName() {
      return this.getDefinitions().getName();
   }
}
