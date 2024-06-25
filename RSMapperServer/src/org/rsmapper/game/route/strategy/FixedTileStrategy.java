package org.rsmapper.game.route.strategy;

import org.rsmapper.game.route.RouteStrategy;

public class FixedTileStrategy extends RouteStrategy {
   private int x;
   private int y;

   public FixedTileStrategy(int x, int y) {
      this.x = x;
      this.y = y;
   }

   public boolean canExit(int currentX, int currentY, int sizeXY, int[][] clip, int clipBaseX, int clipBaseY) {
      return currentX == this.x && currentY == this.y;
   }

   public int getApproxDestinationX() {
      return this.x;
   }

   public int getApproxDestinationY() {
      return this.y;
   }

   public int getApproxDestinationSizeX() {
      return 1;
   }

   public int getApproxDestinationSizeY() {
      return 1;
   }

   public boolean equals(Object other) {
      if (!(other instanceof FixedTileStrategy)) {
         return false;
      } else {
         FixedTileStrategy strategy = (FixedTileStrategy)other;
         return this.x == strategy.x && this.y == strategy.y;
      }
   }
}
