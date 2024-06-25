package org.rsmapper.game.route;

public abstract class RouteStrategy {
   public static final int BLOCK_FLAG_NORTH = 1;
   public static final int BLOCK_FLAG_EAST = 2;
   public static final int BLOCK_FLAG_SOUTH = 4;
   public static final int BLOCK_FLAG_WEST = 8;

   public abstract boolean canExit(int var1, int var2, int var3, int[][] var4, int var5, int var6);

   public abstract int getApproxDestinationX();

   public abstract int getApproxDestinationY();

   public abstract int getApproxDestinationSizeX();

   public abstract int getApproxDestinationSizeY();

   public abstract boolean equals(Object var1);

   protected static boolean checkWallDecorationInteract(int[][] clip, int currentX, int currentY, int sizeXY, int targetX, int targetY, int targetType, int targetRotation) {
      if (currentX == targetX && currentY == targetY) {
         return true;
      } else {
         if (targetType != 6 && targetType != 7) {
            if (targetType == 8) {
               if (currentX == targetX && currentY == targetY + 1 && (clip[currentX][currentY] & 32) == 0) {
                  return true;
               }

               if (currentX == targetX && currentY == targetY - 1 && (clip[currentX][currentY] & 2) == 0) {
                  return true;
               }

               if (currentX == targetX - 1 && currentY == targetY && (clip[currentX][currentY] & 8) == 0) {
                  return true;
               }

               if (currentX == targetX + 1 && currentY == targetY && (clip[currentX][currentY] & 128) == 0) {
                  return true;
               }
            }
         } else {
            if (targetType == 7) {
               targetRotation = targetRotation + 2 & 3;
            }

            if (targetRotation == 0) {
               if (currentX == targetX + 1 && currentY == targetY && (clip[currentX][currentY] & 128) == 0) {
                  return true;
               }

               if (currentX == targetX && currentY == targetY - 1 && (clip[currentX][currentY] & 2) == 0) {
                  return true;
               }
            } else if (targetRotation == 1) {
               if (currentX == targetX - 1 && currentY == targetY && (clip[currentX][currentY] & 8) == 0) {
                  return true;
               }

               if (currentX == targetX && currentY == targetY - 1 && (clip[currentX][currentY] & 2) == 0) {
                  return true;
               }
            } else if (targetRotation == 2) {
               if (currentX == targetX - 1 && currentY == targetY && (clip[currentX][currentY] & 8) == 0) {
                  return true;
               }

               if (currentX == targetX && currentY == targetY + 1 && (clip[currentX][currentY] & 32) == 0) {
                  return true;
               }
            } else if (targetRotation == 3) {
               if (currentX == targetX + 1 && currentY == targetY && (clip[currentX][currentY] & 128) == 0) {
                  return true;
               }

               if (currentX == targetX && currentY == targetY + 1 && (clip[currentX][currentY] & 32) == 0) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   protected static boolean checkWallInteract(int[][] clips, int currentX, int currentY, int sizeXY, int targetX, int targetY, int targetType, int targetRotation) {
      if (sizeXY == 1) {
         if (currentX == targetX && currentY == targetY) {
            return true;
         }
      } else if (targetX >= currentX && targetX <= currentX + sizeXY - 1 && targetY <= targetY + sizeXY - 1) {
         return true;
      }

      if (sizeXY == 1) {
         if (targetType == 0) {
            if (targetRotation == 0) {
               if (targetX - 1 == currentX && currentY == targetY) {
                  return true;
               }

               if (currentX == targetX && targetY + 1 == currentY && (clips[currentX][currentY] & 2883872) == 0) {
                  return true;
               }

               if (targetX == currentX && currentY == targetY - 1 && (clips[currentX][currentY] & 2883842) == 0) {
                  return true;
               }
            } else if (targetRotation == 1) {
               if (currentX == targetX && targetY + 1 == currentY) {
                  return true;
               }

               if (currentX == targetX - 1 && targetY == currentY && (clips[currentX][currentY] & 2883848) == 0) {
                  return true;
               }

               if (targetX + 1 == currentX && currentY == targetY && (clips[currentX][currentY] & 2883968) == 0) {
                  return true;
               }
            } else if (targetRotation == 2) {
               if (targetX + 1 == currentX && currentY == targetY) {
                  return true;
               }

               if (targetX == currentX && currentY == targetY + 1 && (clips[currentX][currentY] & 2883872) == 0) {
                  return true;
               }

               if (targetX == currentX && currentY == targetY - 1 && (clips[currentX][currentY] & 2883842) == 0) {
                  return true;
               }
            } else if (targetRotation == 3) {
               if (currentX == targetX && targetY - 1 == currentY) {
                  return true;
               }

               if (targetX - 1 == currentX && currentY == targetY && (clips[currentX][currentY] & 2883848) == 0) {
                  return true;
               }

               if (targetX + 1 == currentX && targetY == currentY && (clips[currentX][currentY] & 2883968) == 0) {
                  return true;
               }
            }
         }

         if (targetType == 2) {
            if (targetRotation == 0) {
               if (currentX == targetX - 1 && currentY == targetY) {
                  return true;
               }

               if (targetX == currentX && targetY + 1 == currentY) {
                  return true;
               }

               if (currentX == targetX + 1 && targetY == currentY && (clips[currentX][currentY] & 2883968) == 0) {
                  return true;
               }

               if (targetX == currentX && targetY - 1 == currentY && (clips[currentX][currentY] & 2883842) == 0) {
                  return true;
               }
            } else if (targetRotation == 1) {
               if (targetX - 1 == currentX && targetY == currentY && (clips[currentX][currentY] & 2883848) == 0) {
                  return true;
               }

               if (targetX == currentX && targetY + 1 == currentY) {
                  return true;
               }

               if (targetX + 1 == currentX && currentY == targetY) {
                  return true;
               }

               if (targetX == currentX && currentY == targetY - 1 && (clips[currentX][currentY] & 2883842) == 0) {
                  return true;
               }
            } else if (targetRotation == 2) {
               if (targetX - 1 == currentX && currentY == targetY && (clips[currentX][currentY] & 2883848) == 0) {
                  return true;
               }

               if (currentX == targetX && currentY == targetY + 1 && (clips[currentX][currentY] & 2883872) == 0) {
                  return true;
               }

               if (currentX == targetX + 1 && targetY == currentY) {
                  return true;
               }

               if (currentX == targetX && targetY - 1 == currentY) {
                  return true;
               }
            } else if (targetRotation == 3) {
               if (targetX - 1 == currentX && currentY == targetY) {
                  return true;
               }

               if (targetX == currentX && targetY + 1 == currentY && (clips[currentX][currentY] & 2883872) == 0) {
                  return true;
               }

               if (currentX == targetX + 1 && targetY == currentY && (clips[currentX][currentY] & 2883968) == 0) {
                  return true;
               }

               if (currentX == targetX && targetY - 1 == currentY) {
                  return true;
               }
            }
         }

         if (targetType == 9) {
            if (targetX == currentX && targetY + 1 == currentY && (clips[currentX][currentY] & 32) == 0) {
               return true;
            }

            if (currentX == targetX && targetY - 1 == currentY && (clips[currentX][currentY] & 2) == 0) {
               return true;
            }

            if (currentX == targetX - 1 && currentY == targetY && (clips[currentX][currentY] & 8) == 0) {
               return true;
            }

            if (currentX == targetX + 1 && currentY == targetY && (clips[currentX][currentY] & 128) == 0) {
               return true;
            }
         }
      } else {
         int i_66_ = currentX + sizeXY - 1;
         int i_67_ = sizeXY + currentY - 1;
         if (targetType == 0) {
            if (targetRotation == 0) {
               if (targetX - sizeXY == currentX && targetY >= currentY && targetY <= i_67_) {
                  return true;
               }

               if (targetX >= currentX && targetX <= i_66_ && currentY == targetY + 1 && (clips[targetX][currentY] & 2883872) == 0) {
                  return true;
               }

               if (targetX >= currentX && targetX <= i_66_ && targetY - sizeXY == currentY && (clips[targetX][i_67_] & 2883842) == 0) {
                  return true;
               }
            } else if (targetRotation == 1) {
               if (targetX >= currentX && targetX <= i_66_ && targetY + 1 == currentY) {
                  return true;
               }

               if (currentX == targetX - sizeXY && targetY >= currentY && targetY <= i_67_ && (clips[i_66_][targetY] & 2883848) == 0) {
                  return true;
               }

               if (targetX + 1 == currentX && targetY >= currentY && targetY <= i_67_ && (clips[currentX][targetY] & 2883968) == 0) {
                  return true;
               }
            } else if (targetRotation == 2) {
               if (targetX + 1 == currentX && targetY >= currentY && targetY <= i_67_) {
                  return true;
               }

               if (targetX >= currentX && targetX <= i_66_ && currentY == targetY + 1 && (clips[targetX][currentY] & 2883872) == 0) {
                  return true;
               }

               if (targetX >= currentX && targetX <= i_66_ && currentY == targetY - sizeXY && (clips[targetX][i_67_] & 2883842) == 0) {
                  return true;
               }
            } else if (targetRotation == 3) {
               if (targetX >= currentX && targetX <= i_66_ && targetY - sizeXY == currentY) {
                  return true;
               }

               if (currentX == targetX - sizeXY && targetY >= currentY && targetY <= i_67_ && (clips[i_66_][targetY] & 2883848) == 0) {
                  return true;
               }

               if (targetX + 1 == currentX && targetY >= currentY && targetY <= i_67_ && (clips[currentX][targetY] & 2883968) == 0) {
                  return true;
               }
            }
         }

         if (targetType == 2) {
            if (targetRotation == 0) {
               if (targetX - sizeXY == currentX && targetY >= currentY && targetY <= i_67_) {
                  return true;
               }

               if (targetX >= currentX && targetX <= i_66_ && targetY + 1 == currentY) {
                  return true;
               }

               if (targetX + 1 == currentX && targetY >= currentY && targetY <= i_67_ && (clips[currentX][targetY] & 2883968) == 0) {
                  return true;
               }

               if (targetX >= currentX && targetX <= i_66_ && targetY - sizeXY == currentY && (clips[targetX][i_67_] & 2883842) == 0) {
                  return true;
               }
            } else if (targetRotation == 1) {
               if (currentX == targetX - sizeXY && targetY >= currentY && targetY <= i_67_ && (clips[i_66_][targetY] & 2883848) == 0) {
                  return true;
               }

               if (targetX >= currentX && targetX <= i_66_ && currentY == targetY + 1) {
                  return true;
               }

               if (targetX + 1 == currentX && targetY >= currentY && targetY <= i_67_) {
                  return true;
               }

               if (targetX >= currentX && targetX <= i_66_ && currentY == targetY - sizeXY && (clips[targetX][i_67_] & 2883842) == 0) {
                  return true;
               }
            } else if (targetRotation == 2) {
               if (currentX == targetX - sizeXY && targetY >= currentY && targetY <= i_67_ && (clips[i_66_][targetY] & 2883848) == 0) {
                  return true;
               }

               if (targetX >= currentX && targetX <= i_66_ && targetY + 1 == currentY && (clips[targetX][currentY] & 2883872) == 0) {
                  return true;
               }

               if (targetX + 1 == currentX && targetY >= currentY && targetY <= i_67_) {
                  return true;
               }

               if (targetX >= currentX && targetX <= i_66_ && currentY == targetY - sizeXY) {
                  return true;
               }
            } else if (targetRotation == 3) {
               if (targetX - sizeXY == currentX && targetY >= currentY && targetY <= i_67_) {
                  return true;
               }

               if (targetX >= currentX && targetX <= i_66_ && currentY == targetY + 1 && (clips[targetX][currentY] & 2883872) == 0) {
                  return true;
               }

               if (targetX + 1 == currentX && targetY >= currentY && targetY <= i_67_ && (clips[currentX][targetY] & 2883968) == 0) {
                  return true;
               }

               if (targetX >= currentX && targetX <= i_66_ && currentY == targetY - sizeXY) {
                  return true;
               }
            }
         }

         if (targetType == 9) {
            if (targetX >= currentX && targetX <= i_66_ && targetY + 1 == currentY && (clips[targetX][currentY] & 2883872) == 0) {
               return true;
            }

            if (targetX >= currentX && targetX <= i_66_ && targetY - sizeXY == currentY && (clips[targetX][i_67_] & 2883842) == 0) {
               return true;
            }

            if (targetX - sizeXY == currentX && targetY >= currentY && targetY <= i_67_ && (clips[i_66_][targetY] & 2883848) == 0) {
               return true;
            }

            if (currentX == targetX + 1 && targetY >= currentY && targetY <= i_67_ && (clips[currentX][targetY] & 2883968) == 0) {
               return true;
            }
         }
      }

      return false;
   }

   protected static boolean checkFilledRectangularInteract(int[][] clip, int currentX, int currentY, int sizeX, int sizeY, int targetX, int targetY, int targetSizeX, int targetSizeY, int accessBlockFlag) {
      int srcEndX = currentX + sizeX;
      int srcEndY = currentY + sizeY;
      int destEndX = targetX + targetSizeX;
      int destEndY = targetY + targetSizeY;
      int i_18_;
      int i_19_;
      if (destEndX == currentX && (accessBlockFlag & 2) == 0) {
         i_18_ = currentY > targetY ? currentY : targetY;

         for(i_19_ = srcEndY < destEndY ? srcEndY : destEndY; i_18_ < i_19_; ++i_18_) {
            if ((clip[destEndX - 1][i_18_] & 8) == 0) {
               return true;
            }
         }
      } else if (srcEndX == targetX && (accessBlockFlag & 8) == 0) {
         i_18_ = currentY > targetY ? currentY : targetY;

         for(i_19_ = srcEndY < destEndY ? srcEndY : destEndY; i_18_ < i_19_; ++i_18_) {
            if ((clip[targetX][i_18_] & 128) == 0) {
               return true;
            }
         }
      } else if (currentY == destEndY && (accessBlockFlag & 1) == 0) {
         i_18_ = currentX > targetX ? currentX : targetX;

         for(i_19_ = srcEndX < destEndX ? srcEndX : destEndX; i_18_ < i_19_; ++i_18_) {
            if ((clip[i_18_][destEndY - 1] & 2) == 0) {
               return true;
            }
         }
      } else if (targetY == srcEndY && (accessBlockFlag & 4) == 0) {
         i_18_ = currentX > targetX ? currentX : targetX;

         for(i_19_ = srcEndX < destEndX ? srcEndX : destEndX; i_18_ < i_19_; ++i_18_) {
            if ((clip[i_18_][targetY] & 32) == 0) {
               return true;
            }
         }
      }

      return false;
   }
}
