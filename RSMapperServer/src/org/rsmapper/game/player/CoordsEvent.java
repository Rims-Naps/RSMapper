package org.rsmapper.game.player;

import org.rsmapper.game.WorldTile;

public final class CoordsEvent {
   private WorldTile tile;
   private Runnable event;
   private int sizeX;
   private int sizeY;

   public CoordsEvent(WorldTile tile, Runnable event, int sizeX, int sizeY, int rotation) {
      this.tile = tile;
      this.event = event;
      if (rotation != 1 && rotation != 3) {
         this.sizeX = sizeX;
         this.sizeY = sizeY;
      } else {
         this.sizeX = sizeY;
         this.sizeY = sizeX;
      }

   }

   public CoordsEvent(WorldTile tile, Runnable event, int sizeX, int sizeY) {
      this(tile, event, sizeX, sizeY, -1);
   }

   public CoordsEvent(WorldTile tile, Runnable event, int size) {
      this(tile, event, size, size);
   }

   public boolean processEvent(Player player) {
      if (player.getPlane() != this.tile.getPlane()) {
         return true;
      } else {
         System.out.println(player.hasWalkSteps());
         int distanceX = player.getX() - this.tile.getX();
         int distanceY = player.getY() - this.tile.getY();
         if (distanceX <= this.sizeX && distanceX >= -1 && distanceY <= this.sizeY && distanceY >= -1) {
            if (player.hasWalkSteps()) {
               player.resetWalkSteps();
            }

            this.event.run();
            return true;
         } else {
            return this.cantReach(player);
         }
      }
   }

   public boolean cantReach(Player player) {
      if (!player.hasWalkSteps() && player.getNextWalkDirection() == -1) {
         player.getPackets().sendGameMessage("You can't reach that.");
         return true;
      } else {
         return false;
      }
   }
}
