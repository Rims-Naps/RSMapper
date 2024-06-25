package org.rsmapper.game.item;

import org.rsmapper.game.WorldTile;
import org.rsmapper.game.player.Player;

public class FloorItem extends Item {
   private static final long serialVersionUID = 1490108289233691666L;
   private WorldTile tile;
   private Player owner;
   private boolean invisible;
   private boolean grave;
   private int type;

   public FloorItem(int id) {
      super(id);
   }

   public void setAmount(int amount) {
      this.amount = amount;
   }

   public FloorItem(Item item, WorldTile tile, Player owner, boolean underGrave, boolean invisible) {
      super(item.getId(), item.getAmount());
      this.tile = tile;
      this.owner = owner;
      this.grave = underGrave;
      this.invisible = invisible;
   }

   public FloorItem(Item item, WorldTile tile, boolean appearforever) {
      super(item.getId(), item.getAmount());
      this.tile = tile;
      this.type = appearforever ? 2 : 0;
   }

   public WorldTile getTile() {
      return this.tile;
   }

   public boolean isGrave() {
      return this.grave;
   }

   public boolean isInvisible() {
      return this.invisible;
   }

   public Player getOwner() {
      return this.owner;
   }

   public boolean hasOwner() {
      return this.owner != null;
   }

   public boolean isForever() {
      return this.type == 2;
   }

   public void setInvisible(boolean invisible) {
      this.invisible = invisible;
   }
}
