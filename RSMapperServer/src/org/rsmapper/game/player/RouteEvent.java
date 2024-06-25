package org.rsmapper.game.player;

import org.rsmapper.game.Entity;
import org.rsmapper.game.WorldObject;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.FloorItem;
import org.rsmapper.game.route.RouteFinder;
import org.rsmapper.game.route.RouteStrategy;
import org.rsmapper.game.route.strategy.EntityStrategy;
import org.rsmapper.game.route.strategy.FixedTileStrategy;
import org.rsmapper.game.route.strategy.FloorItemStrategy;
import org.rsmapper.game.route.strategy.ObjectStrategy;

public class RouteEvent {
   private Object object;
   private Runnable event;
   private boolean alternative;
   private RouteStrategy[] last;

   public RouteEvent(Object object, Runnable event) {
      this(object, event, false);
   }

   public RouteEvent(Object object, Runnable event, boolean alternative) {
      this.object = object;
      this.event = event;
      this.alternative = alternative;
   }

   public boolean processEvent(Player player) {
      if (!this.simpleCheck(player)) {
         player.getPackets().sendGameMessage("You can't reach that.");
         player.getPackets().sendResetMinimapFlag();
         return true;
      } else {
         RouteStrategy[] strategies = this.generateStrategies();
         if (this.object instanceof Entity) {
            player.setNextFaceEntity((Entity)this.object);
         }

         if (this.last != null && this.match(strategies, this.last) && player.hasWalkSteps()) {
            return false;
         } else {
            int i;
            RouteStrategy strategy;
            int steps;
            if (this.last != null && this.match(strategies, this.last) && !player.hasWalkSteps()) {
               for(i = 0; i < strategies.length; ++i) {
                  strategy = strategies[i];
                  steps = RouteFinder.findRoute(0, player.getX(), player.getY(), player.getPlane(), player.getSize(), strategy, i == strategies.length - 1);
                  if (steps != -1 && (!RouteFinder.lastIsAlternative() && steps <= 0 || this.alternative)) {
                     player.setNextFaceEntity((Entity)null);
                     if (this.alternative) {
                        player.getPackets().sendResetMinimapFlag();
                     }

                     this.event.run();
                     return true;
                  }
               }

               player.getPackets().sendGameMessage("You can't reach that.");
               player.getPackets().sendResetMinimapFlag();
               return true;
            } else {
               this.last = strategies;

               for(i = 0; i < strategies.length; ++i) {
                  strategy = strategies[i];
                  steps = RouteFinder.findRoute(0, player.getX(), player.getY(), player.getPlane(), player.getSize(), strategy, i == strategies.length - 1);
                  if (steps != -1) {
                     if (!RouteFinder.lastIsAlternative() && steps <= 0) {
                        if (this.alternative) {
                           player.getPackets().sendResetMinimapFlag();
                        }

                        this.event.run();
                        return true;
                     }

                     int[] bufferX = RouteFinder.getLastPathBufferX();
                     int[] bufferY = RouteFinder.getLastPathBufferY();
                     WorldTile last = new WorldTile(bufferX[0], bufferY[0], player.getPlane());
                     player.resetWalkSteps();
                     player.getPackets().sendMinimapFlag(last.getLocalX(player.getLastLoadedMapRegionTile(), player.getMapSize()), last.getLocalY(player.getLastLoadedMapRegionTile(), player.getMapSize()));
                     if (player.isFrozen()) {
                        return false;
                     }

                     for(int step = steps - 1; step >= 0 && player.addWalkSteps(bufferX[step], bufferY[step], 25, true); --step) {
                     }

                     return false;
                  }
               }

               player.getPackets().sendGameMessage("You can't reach that.");
               player.getPackets().sendResetMinimapFlag();
               return true;
            }
         }
      }
   }

   private boolean simpleCheck(Player player) {
      if (this.object instanceof Entity) {
         return player.getPlane() == ((Entity)this.object).getPlane();
      } else if (this.object instanceof WorldObject) {
         return player.getPlane() == ((WorldObject)this.object).getPlane();
      } else if (this.object instanceof FloorItem) {
         return player.getPlane() == ((FloorItem)this.object).getTile().getPlane();
      } else if (this.object instanceof WorldTile) {
         return player.getPlane() == ((WorldTile)this.object).getPlane();
      } else {
         throw new RuntimeException(this.object + " is not instanceof any reachable entity.");
      }
   }

   private RouteStrategy[] generateStrategies() {
      if (this.object instanceof Entity) {
         return new RouteStrategy[]{new EntityStrategy((Entity)this.object)};
      } else if (this.object instanceof WorldObject) {
         return new RouteStrategy[]{new ObjectStrategy((WorldObject)this.object)};
      } else if (this.object instanceof FloorItem) {
         FloorItem item = (FloorItem)this.object;
         return new RouteStrategy[]{new FixedTileStrategy(item.getTile().getX(), item.getTile().getY()), new FloorItemStrategy(item)};
      } else if (this.object instanceof WorldTile) {
         WorldTile loc = (WorldTile)this.object;
         return new RouteStrategy[]{new FixedTileStrategy(loc.getX(), loc.getY()), new FixedTileStrategy(loc.getX(), loc.getY())};
      } else {
         throw new RuntimeException(this.object + " is not instanceof any reachable entity.");
      }
   }

   private boolean match(RouteStrategy[] a1, RouteStrategy[] a2) {
      if (a1.length != a2.length) {
         return false;
      } else {
         for(int i = 0; i < a1.length; ++i) {
            if (!a1[i].equals(a2[i])) {
               return false;
            }
         }

         return true;
      }
   }
}
