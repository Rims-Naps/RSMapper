package org.rsmapper.game.route;

import org.rsmapper.game.Region;
import org.rsmapper.game.RegionMap;
import org.rsmapper.game.World;

public class WalkRouteFinder {
   private static final int GRAPH_SIZE = 128;
   private static final int QUEUE_SIZE = 4096;
   private static final int ALTERNATIVE_ROUTE_MAX_DISTANCE = 100;
   private static final int ALTERNATIVE_ROUTE_RANGE = 10;
   private static final int DIR_NORTH = 1;
   private static final int DIR_EAST = 2;
   private static final int DIR_SOUTH = 4;
   private static final int DIR_WEST = 8;
   private static final int[][] directions = new int[128][128];
   private static final int[][] distances = new int[128][128];
   private static final int[][] clip = new int[128][128];
   private static final int[] bufferX = new int[4096];
   private static final int[] bufferY = new int[4096];
   private static int exitX = -1;
   private static int exitY = -1;
   private static boolean isAlternative;
   public static boolean debug = true;
   public static long debug_transmittime = 0L;

   protected static int findRoute(int srcX, int srcY, int srcZ, int srcSizeXY, RouteStrategy strategy, boolean findAlternative) {
      isAlternative = false;

      int graphBaseX;
      for(int x = 0; x < 128; ++x) {
         for(graphBaseX = 0; graphBaseX < 128; ++graphBaseX) {
            directions[x][graphBaseX] = 0;
            distances[x][graphBaseX] = 99999999;
         }
      }

      if (debug) {
         long start = System.nanoTime();
         transmitClipData(srcX, srcY, srcZ);
         debug_transmittime = System.nanoTime() - start;
      } else {
         transmitClipData(srcX, srcY, srcZ);
      }

      boolean found = false;
      switch(srcSizeXY) {
      case 1:
         found = performCalculationS1(srcX, srcY, strategy);
         break;
      case 2:
         found = performCalculationS2(srcX, srcY, strategy);
         break;
      default:
         found = performCalculationSX(srcX, srcY, srcSizeXY, strategy);
      }

      if (!found && !findAlternative) {
         return -1;
      } else {
         graphBaseX = srcX - 64;
         int graphBaseY = srcY - 64;
         int endX = exitX;
         int endY = exitY;
         int lowestCost;
         int lowestDistance;
         int traceY;
         int direction;
         int checkX;
         if (!found && findAlternative) {
            isAlternative = true;
            lowestCost = Integer.MAX_VALUE;
            lowestDistance = Integer.MAX_VALUE;
            traceY = strategy.getApproxDestinationX();
            direction = strategy.getApproxDestinationY();
            checkX = traceY - 10;

            while(true) {
               if (checkX > traceY + 10) {
                  if (lowestCost != Integer.MAX_VALUE && lowestDistance != Integer.MAX_VALUE) {
                     break;
                  }

                  return -1;
               }

               for(int checkY = direction - 10; checkY <= direction + 10; ++checkY) {
                  int graphX = checkX - graphBaseX;
                  int graphY = checkY - graphBaseY;
                  if (graphX >= 0 && graphY >= 0 && graphX < 128 && graphY < 128 && distances[graphX][graphY] < 100) {
                     int deltaX = false;
                     int deltaY = false;
                     int deltaX;
                     if (traceY <= checkX) {
                        deltaX = 1 - traceY - (strategy.getApproxDestinationSizeX() - checkX);
                     } else {
                        deltaX = traceY - checkX;
                     }

                     int deltaY;
                     if (direction <= checkY) {
                        deltaY = 1 - direction - (strategy.getApproxDestinationSizeY() - checkY);
                     } else {
                        deltaY = direction - checkY;
                     }

                     int cost = deltaX * deltaX + deltaY * deltaY;
                     if (cost < lowestCost || cost <= lowestCost && distances[graphX][graphY] < lowestDistance) {
                        lowestCost = cost;
                        lowestDistance = distances[graphX][graphY];
                        endX = checkX;
                        endY = checkY;
                     }
                  }
               }

               ++checkX;
            }
         }

         if (endX == srcX && endY == srcY) {
            return 0;
         } else {
            int steps = 0;
            lowestDistance = endX;
            traceY = endY;
            direction = directions[endX - graphBaseX][endY - graphBaseY];
            checkX = direction;
            bufferX[steps] = endX;
            lowestCost = steps + 1;

            for(bufferY[steps] = endY; lowestDistance != srcX || traceY != srcY; direction = directions[lowestDistance - graphBaseX][traceY - graphBaseY]) {
               if (checkX != direction) {
                  bufferX[lowestCost] = lowestDistance;
                  bufferY[lowestCost++] = traceY;
                  checkX = direction;
               }

               if ((direction & 2) != 0) {
                  ++lowestDistance;
               } else if ((direction & 8) != 0) {
                  --lowestDistance;
               }

               if ((direction & 1) != 0) {
                  ++traceY;
               } else if ((direction & 4) != 0) {
                  --traceY;
               }
            }

            return lowestCost;
         }
      }
   }

   private static boolean performCalculationS1(int srcX, int srcY, RouteStrategy strategy) {
      int[][] _directions = directions;
      int[][] _distances = distances;
      int[][] _clip = clip;
      int[] _bufferX = bufferX;
      int[] _bufferY = bufferY;
      int graphBaseX = srcX - 64;
      int graphBaseY = srcY - 64;
      int currentX = srcX;
      int currentY = srcY;
      int currentGraphX = srcX - graphBaseX;
      int currentGraphY = srcY - graphBaseY;
      _distances[currentGraphX][currentGraphY] = 0;
      _directions[currentGraphX][currentGraphY] = 99;
      int read = 0;
      int write = 0;
      _bufferX[write] = srcX;
      byte var10001 = write;
      int write = write + 1;
      _bufferY[var10001] = srcY;

      while(read != write) {
         currentX = _bufferX[read];
         currentY = _bufferY[read];
         read = read + 1 & 4095;
         currentGraphX = currentX - graphBaseX;
         currentGraphY = currentY - graphBaseY;
         if (strategy.canExit(currentX, currentY, 1, _clip, graphBaseX, graphBaseY)) {
            exitX = currentX;
            exitY = currentY;
            return true;
         }

         int nextDistance = _distances[currentGraphX][currentGraphY] + 1;
         if (currentGraphX > 0 && _directions[currentGraphX - 1][currentGraphY] == 0 && (_clip[currentGraphX - 1][currentGraphY] & 1109655552) == 0) {
            _bufferX[write] = currentX - 1;
            _bufferY[write] = currentY;
            write = write + 1 & 4095;
            _directions[currentGraphX - 1][currentGraphY] = 2;
            _distances[currentGraphX - 1][currentGraphY] = nextDistance;
         }

         if (currentGraphX < 127 && _directions[currentGraphX + 1][currentGraphY] == 0 && (_clip[currentGraphX + 1][currentGraphY] & 1612972032) == 0) {
            _bufferX[write] = currentX + 1;
            _bufferY[write] = currentY;
            write = write + 1 & 4095;
            _directions[currentGraphX + 1][currentGraphY] = 8;
            _distances[currentGraphX + 1][currentGraphY] = nextDistance;
         }

         if (currentGraphY > 0 && _directions[currentGraphX][currentGraphY - 1] == 0 && (_clip[currentGraphX][currentGraphY - 1] & 1084489728) == 0) {
            _bufferX[write] = currentX;
            _bufferY[write] = currentY - 1;
            write = write + 1 & 4095;
            _directions[currentGraphX][currentGraphY - 1] = 1;
            _distances[currentGraphX][currentGraphY - 1] = nextDistance;
         }

         if (currentGraphY < 127 && _directions[currentGraphX][currentGraphY + 1] == 0 && (_clip[currentGraphX][currentGraphY + 1] & 1210318848) == 0) {
            _bufferX[write] = currentX;
            _bufferY[write] = currentY + 1;
            write = write + 1 & 4095;
            _directions[currentGraphX][currentGraphY + 1] = 4;
            _distances[currentGraphX][currentGraphY + 1] = nextDistance;
         }

         if (currentGraphX > 0 && currentGraphY > 0 && _directions[currentGraphX - 1][currentGraphY - 1] == 0 && (_clip[currentGraphX - 1][currentGraphY - 1] & 1134821376) == 0 && (_clip[currentGraphX - 1][currentGraphY] & 1109655552) == 0 && (clip[currentGraphX][currentGraphY - 1] & 1084489728) == 0) {
            _bufferX[write] = currentX - 1;
            _bufferY[write] = currentY - 1;
            write = write + 1 & 4095;
            _directions[currentGraphX - 1][currentGraphY - 1] = 3;
            _distances[currentGraphX - 1][currentGraphY - 1] = nextDistance;
         }

         if (currentGraphX < 127 && currentGraphY > 0 && _directions[currentGraphX + 1][currentGraphY - 1] == 0 && (_clip[currentGraphX + 1][currentGraphY - 1] & 1625554944) == 0 && (_clip[currentGraphX + 1][currentGraphY] & 1612972032) == 0 && (_clip[currentGraphX][currentGraphY - 1] & 1084489728) == 0) {
            _bufferX[write] = currentX + 1;
            _bufferY[write] = currentY - 1;
            write = write + 1 & 4095;
            _directions[currentGraphX + 1][currentGraphY - 1] = 9;
            _distances[currentGraphX + 1][currentGraphY - 1] = nextDistance;
         }

         if (currentGraphX > 0 && currentGraphY < 127 && _directions[currentGraphX - 1][currentGraphY + 1] == 0 && (_clip[currentGraphX - 1][currentGraphY + 1] & 1310982144) == 0 && (_clip[currentGraphX - 1][currentGraphY] & 1109655552) == 0 && (_clip[currentGraphX][currentGraphY + 1] & 1210318848) == 0) {
            _bufferX[write] = currentX - 1;
            _bufferY[write] = currentY + 1;
            write = write + 1 & 4095;
            _directions[currentGraphX - 1][currentGraphY + 1] = 6;
            _distances[currentGraphX - 1][currentGraphY + 1] = nextDistance;
         }

         if (currentGraphX < 127 && currentGraphY < 127 && _directions[currentGraphX + 1][currentGraphY + 1] == 0 && (_clip[currentGraphX + 1][currentGraphY + 1] & 2015625216) == 0 && (_clip[currentGraphX + 1][currentGraphY] & 1612972032) == 0 && (_clip[currentGraphX][currentGraphY + 1] & 1210318848) == 0) {
            _bufferX[write] = currentX + 1;
            _bufferY[write] = currentY + 1;
            write = write + 1 & 4095;
            _directions[currentGraphX + 1][currentGraphY + 1] = 12;
            _distances[currentGraphX + 1][currentGraphY + 1] = nextDistance;
         }
      }

      exitX = currentX;
      exitY = currentY;
      return false;
   }

   private static boolean performCalculationS2(int srcX, int srcY, RouteStrategy strategy) {
      return performCalculationSX(srcX, srcY, 2, strategy);
   }

   private static boolean performCalculationSX(int srcX, int srcY, int size, RouteStrategy strategy) {
      int[][] _directions = directions;
      int[][] _distances = distances;
      int[][] _clip = clip;
      int[] _bufferX = bufferX;
      int[] _bufferY = bufferY;
      int graphBaseX = srcX - 64;
      int graphBaseY = srcY - 64;
      int currentX = srcX;
      int currentY = srcY;
      int currentGraphX = srcX - graphBaseX;
      int currentGraphY = srcY - graphBaseY;
      _distances[currentGraphX][currentGraphY] = 0;
      _directions[currentGraphX][currentGraphY] = 99;
      int read = 0;
      int write = 0;
      _bufferX[write] = srcX;
      int write = write + 1;
      _bufferY[write] = srcY;

      label204:
      while(read != write) {
         currentX = _bufferX[read];
         currentY = _bufferY[read];
         read = read + 1 & 4095;
         currentGraphX = currentX - graphBaseX;
         currentGraphY = currentY - graphBaseY;
         if (strategy.canExit(currentX, currentY, size, _clip, graphBaseX, graphBaseY)) {
            exitX = currentX;
            exitY = currentY;
            return true;
         }

         int nextDistance = _distances[currentGraphX][currentGraphY] + 1;
         int y;
         if (currentGraphX > 0 && _directions[currentGraphX - 1][currentGraphY] == 0 && (_clip[currentGraphX - 1][currentGraphY] & 1134821376) == 0 && (_clip[currentGraphX - 1][currentGraphY + (size - 1)] & 1310982144) == 0) {
            y = 1;

            while(true) {
               if (y >= size - 1) {
                  _bufferX[write] = currentX - 1;
                  _bufferY[write] = currentY;
                  write = write + 1 & 4095;
                  _directions[currentGraphX - 1][currentGraphY] = 2;
                  _distances[currentGraphX - 1][currentGraphY] = nextDistance;
                  break;
               }

               if ((_clip[currentGraphX - 1][currentGraphY + y] & 1336147968) != 0) {
                  break;
               }

               ++y;
            }
         }

         if (currentGraphX < 128 - size && _directions[currentGraphX + 1][currentGraphY] == 0 && (_clip[currentGraphX + size][currentGraphY] & 1625554944) == 0 && (_clip[currentGraphX + size][currentGraphY + (size - 1)] & 2015625216) == 0) {
            y = 1;

            while(true) {
               if (y >= size - 1) {
                  _bufferX[write] = currentX + 1;
                  _bufferY[write] = currentY;
                  write = write + 1 & 4095;
                  _directions[currentGraphX + 1][currentGraphY] = 8;
                  _distances[currentGraphX + 1][currentGraphY] = nextDistance;
                  break;
               }

               if ((_clip[currentGraphX + size][currentGraphY + y] & 2028208128) != 0) {
                  break;
               }

               ++y;
            }
         }

         if (currentGraphY > 0 && _directions[currentGraphX][currentGraphY - 1] == 0 && (_clip[currentGraphX][currentGraphY - 1] & 1134821376) == 0 && (_clip[currentGraphX + (size - 1)][currentGraphY - 1] & 1625554944) == 0) {
            y = 1;

            while(true) {
               if (y >= size - 1) {
                  _bufferX[write] = currentX;
                  _bufferY[write] = currentY - 1;
                  write = write + 1 & 4095;
                  _directions[currentGraphX][currentGraphY - 1] = 1;
                  _distances[currentGraphX][currentGraphY - 1] = nextDistance;
                  break;
               }

               if ((_clip[currentGraphX + y][currentGraphY - 1] & 1675886592) != 0) {
                  break;
               }

               ++y;
            }
         }

         if (currentGraphY < 128 - size && _directions[currentGraphX][currentGraphY + 1] == 0 && (_clip[currentGraphX][currentGraphY + size] & 1310982144) == 0 && (_clip[currentGraphX + (size - 1)][currentGraphY + size] & 2015625216) == 0) {
            y = 1;

            while(true) {
               if (y >= size - 1) {
                  _bufferX[write] = currentX;
                  _bufferY[write] = currentY + 1;
                  write = write + 1 & 4095;
                  _directions[currentGraphX][currentGraphY + 1] = 4;
                  _distances[currentGraphX][currentGraphY + 1] = nextDistance;
                  break;
               }

               if ((_clip[currentGraphX + y][currentGraphY + size] & 2116288512) != 0) {
                  break;
               }

               ++y;
            }
         }

         if (currentGraphX > 0 && currentGraphY > 0 && _directions[currentGraphX - 1][currentGraphY - 1] == 0 && (_clip[currentGraphX - 1][currentGraphY - 1] & 1134821376) == 0) {
            y = 1;

            while(true) {
               if (y >= size) {
                  _bufferX[write] = currentX - 1;
                  _bufferY[write] = currentY - 1;
                  write = write + 1 & 4095;
                  _directions[currentGraphX - 1][currentGraphY - 1] = 3;
                  _distances[currentGraphX - 1][currentGraphY - 1] = nextDistance;
                  break;
               }

               if ((_clip[currentGraphX - 1][currentGraphY + (y - 1)] & 1336147968) != 0 || (_clip[currentGraphX + (y - 1)][currentGraphY - 1] & 1675886592) != 0) {
                  break;
               }

               ++y;
            }
         }

         if (currentGraphX < 128 - size && currentGraphY > 0 && _directions[currentGraphX + 1][currentGraphY - 1] == 0 && (_clip[currentGraphX + size][currentGraphY - 1] & 1625554944) == 0) {
            y = 1;

            while(true) {
               if (y >= size) {
                  _bufferX[write] = currentX + 1;
                  _bufferY[write] = currentY - 1;
                  write = write + 1 & 4095;
                  _directions[currentGraphX + 1][currentGraphY - 1] = 9;
                  _distances[currentGraphX + 1][currentGraphY - 1] = nextDistance;
                  break;
               }

               if ((_clip[currentGraphX + size][currentGraphY + (y - 1)] & 2028208128) != 0 || (_clip[currentGraphX + y][currentGraphY - 1] & 1675886592) != 0) {
                  break;
               }

               ++y;
            }
         }

         if (currentGraphX > 0 && currentGraphY < 128 - size && _directions[currentGraphX - 1][currentGraphY + 1] == 0 && (_clip[currentGraphX - 1][currentGraphY + size] & 1310982144) == 0) {
            y = 1;

            while(true) {
               if (y >= size) {
                  _bufferX[write] = currentX - 1;
                  _bufferY[write] = currentY + 1;
                  write = write + 1 & 4095;
                  _directions[currentGraphX - 1][currentGraphY + 1] = 6;
                  _distances[currentGraphX - 1][currentGraphY + 1] = nextDistance;
                  break;
               }

               if ((_clip[currentGraphX - 1][currentGraphY + y] & 1336147968) != 0 || (_clip[currentGraphX + (y - 1)][currentGraphY + size] & 2116288512) != 0) {
                  break;
               }

               ++y;
            }
         }

         if (currentGraphX < 128 - size && currentGraphY < 128 - size && _directions[currentGraphX + 1][currentGraphY + 1] == 0 && (_clip[currentGraphX + size][currentGraphY + size] & 2015625216) == 0) {
            for(y = 1; y < size; ++y) {
               if ((_clip[currentGraphX + y][currentGraphY + size] & 2116288512) != 0 || (_clip[currentGraphX + size][currentGraphY + y] & 2028208128) != 0) {
                  continue label204;
               }
            }

            _bufferX[write] = currentX + 1;
            _bufferY[write] = currentY + 1;
            write = write + 1 & 4095;
            _directions[currentGraphX + 1][currentGraphY + 1] = 12;
            _distances[currentGraphX + 1][currentGraphY + 1] = nextDistance;
         }
      }

      exitX = currentX;
      exitY = currentY;
      return false;
   }

   private static void transmitClipData(int x, int y, int z) {
      int graphBaseX = x - 64;
      int graphBaseY = y - 64;

      for(int transmitRegionX = graphBaseX >> 6; transmitRegionX <= graphBaseX + 127 >> 6; ++transmitRegionX) {
         for(int transmitRegionY = graphBaseY >> 6; transmitRegionY <= graphBaseY + 127 >> 6; ++transmitRegionY) {
            int startX = Math.max(graphBaseX, transmitRegionX << 6);
            int startY = Math.max(graphBaseY, transmitRegionY << 6);
            int endX = Math.min(graphBaseX + 128, (transmitRegionX << 6) + 64);
            int endY = Math.min(graphBaseY + 128, (transmitRegionY << 6) + 64);
            Region region = World.getRegion(transmitRegionX << 8 | transmitRegionY, true);
            RegionMap map = region.getRegionMap();
            int fillX;
            if (map != null && region.getLoadMapStage() == 2 && region.isLoadedObjectSpawns()) {
               int[][] masks = map.getMasks()[z];

               for(fillX = startX; fillX < endX; ++fillX) {
                  for(int fillY = startY; fillY < endY; ++fillY) {
                     clip[fillX - graphBaseX][fillY - graphBaseY] = masks[fillX & 63][fillY & 63];
                  }
               }
            } else {
               for(int fillX = startX; fillX < endX; ++fillX) {
                  for(fillX = startY; fillX < endY; ++fillX) {
                     clip[fillX - graphBaseX][fillX - graphBaseY] = -1;
                  }
               }
            }
         }
      }

   }

   protected static int[] getLastPathBufferX() {
      return bufferX;
   }

   protected static int[] getLastPathBufferY() {
      return bufferY;
   }

   protected static boolean lastIsAlternative() {
      return isAlternative;
   }
}
