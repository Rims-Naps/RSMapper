package org.rsmapper.game.route.strategy;

import org.rsmapper.game.WorldObject;
import org.rsmapper.game.route.RouteStrategy;

public class ObjectStrategy extends RouteStrategy {
   private int x;
   private int y;
   private int routeType;
   private int type;
   private int rotation;
   private int sizeX;
   private int sizeY;
   private int accessBlockFlag;

   public ObjectStrategy(WorldObject object) {
      this.x = object.getX();
      this.y = object.getY();
      this.routeType = this.getType(object);
      this.type = object.getType();
      this.rotation = object.getRotation();
      this.sizeX = this.rotation != 0 && this.rotation != 2 ? object.getDefinitions().getSizeY() : object.getDefinitions().getSizeX();
      this.sizeY = this.rotation != 0 && this.rotation != 2 ? object.getDefinitions().getSizeX() : object.getDefinitions().getSizeY();
      this.accessBlockFlag = object.getDefinitions().getAccessBlockFlag();
      if (this.rotation != 0) {
         this.accessBlockFlag = (this.accessBlockFlag << this.rotation & 15) + (this.accessBlockFlag >> 4 - this.rotation);
      }

   }

   public boolean canExit(int currentX, int currentY, int sizeXY, int[][] clip, int clipBaseX, int clipBaseY) {
      switch(this.routeType) {
      case 0:
         return RouteStrategy.checkWallInteract(clip, currentX - clipBaseX, currentY - clipBaseY, sizeXY, this.x - clipBaseX, this.y - clipBaseY, this.type, this.rotation);
      case 1:
         return RouteStrategy.checkWallDecorationInteract(clip, currentX - clipBaseX, currentY - clipBaseY, sizeXY, this.x - clipBaseX, this.y - clipBaseY, this.type, this.rotation);
      case 2:
         return RouteStrategy.checkFilledRectangularInteract(clip, currentX - clipBaseX, currentY - clipBaseY, sizeXY, sizeXY, this.x - clipBaseX, this.y - clipBaseY, this.sizeX, this.sizeY, this.accessBlockFlag);
      case 3:
         if (currentX == this.x && currentY == this.y) {
            return true;
         }

         return false;
      default:
         return false;
      }
   }

   public int getApproxDestinationX() {
      return this.x;
   }

   public int getApproxDestinationY() {
      return this.y;
   }

   public int getApproxDestinationSizeX() {
      return this.sizeX;
   }

   public int getApproxDestinationSizeY() {
      return this.sizeY;
   }

   private int getType(WorldObject object) {
      int type = object.getType();
      if ((type < 0 || type > 3) && type != 9) {
         if (type < 9) {
            return 1;
         } else {
            return type != 10 && type != 11 && type != 22 ? 3 : 2;
         }
      } else {
         return 0;
      }
   }

   public boolean equals(Object other) {
      if (!(other instanceof ObjectStrategy)) {
         return false;
      } else {
         ObjectStrategy strategy = (ObjectStrategy)other;
         return this.x == strategy.x && this.y == strategy.y && this.routeType == strategy.routeType && this.type == strategy.type && this.rotation == strategy.rotation && this.sizeX == strategy.sizeX && this.sizeY == strategy.sizeY && this.accessBlockFlag == strategy.accessBlockFlag;
      }
   }
}
