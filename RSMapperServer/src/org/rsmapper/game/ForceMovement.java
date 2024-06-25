package org.rsmapper.game;

public final class ForceMovement {
   public static final int NORTH = 0;
   public static final int EAST = 1;
   public static final int SOUTH = 2;
   public static final int WEST = 3;
   private WorldTile toFirstTile;
   private WorldTile toSecondTile;
   private int firstTileTicketDelay;
   private int secondTileTicketDelay;
   private int direction;

   public ForceMovement(WorldTile toFirstTile, int firstTileTicketDelay, int direction) {
      this(toFirstTile, firstTileTicketDelay, (WorldTile)null, 0, direction);
   }

   public ForceMovement(WorldTile toFirstTile, int firstTileTicketDelay, WorldTile toSecondTile, int secondTileTicketDelay, int direction) {
      this.toFirstTile = toFirstTile;
      this.firstTileTicketDelay = firstTileTicketDelay;
      this.toSecondTile = toSecondTile;
      this.secondTileTicketDelay = secondTileTicketDelay;
      this.direction = direction;
   }

   public WorldTile getToFirstTile() {
      return this.toFirstTile;
   }

   public WorldTile getToSecondTile() {
      return this.toSecondTile;
   }

   public int getFirstTileTicketDelay() {
      return this.firstTileTicketDelay;
   }

   public int getSecondTileTicketDelay() {
      return this.secondTileTicketDelay;
   }

   public int getDirection() {
      return this.direction;
   }
}
