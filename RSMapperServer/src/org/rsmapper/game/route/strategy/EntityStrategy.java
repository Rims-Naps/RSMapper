package org.rsmapper.game.route.strategy;

import org.rsmapper.game.Entity;
import org.rsmapper.game.route.RouteStrategy;

public class EntityStrategy extends RouteStrategy {
   private int x;
   private int y;
   private int size;
   private int accessBlockFlag;

   public EntityStrategy(Entity entity) {
      this(entity, 0);
   }

   public EntityStrategy(Entity entity, int accessBlockFlag) {
      this.x = entity.getX();
      this.y = entity.getY();
      this.size = entity.getSize();
      this.accessBlockFlag = accessBlockFlag;
   }

   public boolean canExit(int currentX, int currentY, int sizeXY, int[][] clip, int clipBaseX, int clipBaseY) {
      return RouteStrategy.checkFilledRectangularInteract(clip, currentX - clipBaseX, currentY - clipBaseY, sizeXY, sizeXY, this.x - clipBaseX, this.y - clipBaseY, this.size, this.size, this.accessBlockFlag);
   }

   public int getApproxDestinationX() {
      return this.x;
   }

   public int getApproxDestinationY() {
      return this.y;
   }

   public int getApproxDestinationSizeX() {
      return this.size;
   }

   public int getApproxDestinationSizeY() {
      return this.size;
   }

   public boolean equals(Object other) {
      if (!(other instanceof EntityStrategy)) {
         return false;
      } else {
         EntityStrategy strategy = (EntityStrategy)other;
         return this.x == strategy.x && this.y == strategy.y && this.size == strategy.size && this.accessBlockFlag == strategy.accessBlockFlag;
      }
   }
}
