package org.rsmapper.game.player;

import java.io.Serializable;
import java.util.LinkedHashMap;
import org.rsmapper.game.WorldTile;

public class TeleportFavorites implements Serializable {
   private static final long serialVersionUID = 2254552521928246155L;
   private Player player;
   private LinkedHashMap<String, Object[]> favorites;

   public TeleportFavorites(Player player) {
      this.player = player;
      this.favorites = new LinkedHashMap(3, 1.0F);
      this.favorites.put("0", new Object[0]);
      this.favorites.put("1", new Object[0]);
      this.favorites.put("2", new Object[0]);
   }

   public LinkedHashMap<String, Object[]> getFavorites() {
      return this.favorites;
   }

   public boolean addToFavorites(String name, int subslot) {
      if (!this.player.isDonator()) {
         this.player.sendMessage("You must be atleast a silver donator to use this feature.");
         return false;
      } else {
         int slot = this.getNextAvailableSlot();
         if (slot >= 0 && slot <= 2 && this.hasSlotsLeft()) {
            if (this.favoritesContainsTeleport(name)) {
               this.player.sendMessage("'" + name + "' is already on your favorites.");
               return false;
            } else {
               this.favorites.put(Integer.toString(slot), new Object[]{name, subslot});
               return true;
            }
         } else {
            this.player.sendMessage("You've reached the limit of favorites, remove one to add another.");
            return false;
         }
      }
   }

   public boolean removeFromFavorites(int slot) {
      if (this.getTeleportInSlot(slot) == null) {
         this.player.sendMessage("This favorites slot is already empty.");
         return false;
      } else {
         this.favorites.put(Integer.toString(slot), new Object[0]);
         return true;
      }
   }

   public int getSlotsLeft() {
      int count = 0;

      for(int i = 0; i < 3; ++i) {
         if (this.favorites.get(Integer.toString(i)) == null || ((Object[])this.favorites.get(Integer.toString(i))).length < 1) {
            ++count;
         }
      }

      return count;
   }

   public boolean hasSlotsLeft() {
      return this.getSlotsLeft() > 0;
   }

   public int getNextAvailableSlot() {
      for(int i = 0; i < 3; ++i) {
         if (this.favorites.get(Integer.toString(i)) == null || ((Object[])this.favorites.get(Integer.toString(i))).length < 2) {
            return i;
         }
      }

      return -1;
   }

   public boolean favoritesContainsTeleport(String name) {
      for(int i = 0; i < 3; ++i) {
         if (this.favorites.get(Integer.toString(i)) != null && ((Object[])this.favorites.get(Integer.toString(i))).length > 1 && ((String)((Object[])this.favorites.get(Integer.toString(i)))[0]).equalsIgnoreCase(name)) {
            return true;
         }
      }

      return false;
   }

   public WorldTile getTeleportInSlot(int slot) {
      Object[] var10000 = (Object[])this.favorites.get(Integer.toString(slot));
      return null;
   }
}
