package org.rsmapper.game.route.strategy;

import org.rsmapper.game.item.FloorItem;
import org.rsmapper.game.route.RouteStrategy;

public class FloorItemStrategy extends RouteStrategy {
   private int x;
   private int y;

   public FloorItemStrategy(FloorItem entity) {
      this.x = entity.getTile().getX();
      this.y = entity.getTile().getY();
   }

   public boolean canExit(int currentX, int currentY, int sizeXY, int[][] clip, int clipBaseX, int clipBaseY) {
      return RouteStrategy.checkFilledRectangularInteract(clip, currentX - clipBaseX, currentY - clipBaseY, sizeXY, sizeXY, this.x - clipBaseX, this.y - clipBaseY, 1, 1, 0);
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
      if (!(other instanceof FloorItemStrategy)) {
         return false;
      } else {
         FloorItemStrategy strategy = (FloorItemStrategy)other;
         return this.x == strategy.x && this.y == strategy.y;
      }
   }
}
