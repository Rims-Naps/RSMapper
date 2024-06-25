public class Class324 {
   static IComponentDefinitions aWidget4085 = null;
   static int anInt4086;
   static int anInt4087;

   static final void processLocalUpdate(int playerIndex, Packet packet) {
      ++anInt4086;
      boolean needMasksUpdate = packet.readBits(1) == 1;
      if (needMasksUpdate) {
         Node_Sub23_Sub1.DECODE_MASKS_PLAYERS_INDEXES_LIST[Node_Sub9_Sub4.DECODE_MASKS_PLAYERS_COUNT++] = playerIndex;
      }

      int opcode = packet.readBits(2);
      Player player = Class270_Sub2.LOCAL_PLAYERS[playerIndex];
      if (~opcode == -1) {
         if (needMasksUpdate) {
            player.aBoolean11156 = false;
         } else {
            if (Class166.myPlayerIndex == playerIndex) {
               throw new RuntimeException("s:lr");
            }

            PlayerUpdateReference class323 = Class320_Sub10.aClass323Array8296[playerIndex] = new PlayerUpdateReference();
            class323.globalPositionHash = (player.plane << 28)
               + (Node_Sub53.gameSceneBaseX + player.scenePositionXQueue[0] >> 6 << 14)
               - -(Class320_Sub4.gameSceneBaseY + player.scenePositionYQueue[0] >> 6);
            if (~player.anInt11180 != 0) {
               class323.anInt4079 = player.anInt11180;
            } else {
               class323.anInt4079 = player.aClass99_10893.method1086(16383);
            }

            class323.anInt4074 = player.faceEntity;
            class323.aBoolean4076 = player.aBoolean11157;
            class323.aBoolean4082 = player.aBoolean11135;
            if (player.anInt11164 > 0) {
               Class45.method462((byte)49, player);
            }

            Class270_Sub2.LOCAL_PLAYERS[playerIndex] = null;
            if (packet.readBits(1) != 0) {
               Class339_Sub5.processOutsideUpdate(playerIndex, packet, 28460);
            }
         }
      } else if (opcode == 1) {
         int i_2_ = packet.readBits(3);
         int x = player.scenePositionXQueue[0];
         int y = player.scenePositionYQueue[0];
         if (i_2_ != 0) {
            if (i_2_ == 1) {
               --y;
            } else if (~i_2_ == -3) {
               --y;
               ++x;
            } else if (~i_2_ == -4) {
               --x;
            } else if (i_2_ != 4) {
               if (~i_2_ != -6) {
                  if (i_2_ != 6) {
                     if (~i_2_ == -8) {
                        ++x;
                        ++y;
                     }
                  } else {
                     ++y;
                  }
               } else {
                  ++y;
                  --x;
               }
            } else {
               ++x;
            }
         } else {
            --y;
            --x;
         }

         if (!needMasksUpdate) {
            player.processMovement(y, x, -9380, Class73.movementTypes[playerIndex]);
         } else {
            player.anInt11160 = y;
            player.anInt11147 = x;
            player.aBoolean11156 = true;
         }
      } else if (opcode == 2) {
         int i_5_ = packet.readBits(4);
         int i_6_ = player.scenePositionXQueue[0];
         int i_7_ = player.scenePositionYQueue[0];
         if (~i_5_ == -1) {
            i_6_ -= 2;
            i_7_ -= 2;
         } else if (~i_5_ == -2) {
            --i_6_;
            i_7_ -= 2;
         } else if (i_5_ == 2) {
            i_7_ -= 2;
         } else if (~i_5_ == -4) {
            ++i_6_;
            i_7_ -= 2;
         } else if (~i_5_ != -5) {
            if (~i_5_ != -6) {
               if (i_5_ != 6) {
                  if (i_5_ != 7) {
                     if (~i_5_ != -9) {
                        if (~i_5_ != -10) {
                           if (i_5_ != 10) {
                              if (~i_5_ != -12) {
                                 if (~i_5_ != -13) {
                                    if (i_5_ != 13) {
                                       if (~i_5_ == -15) {
                                          i_7_ += 2;
                                          ++i_6_;
                                       } else if (i_5_ == 15) {
                                          i_6_ += 2;
                                          i_7_ += 2;
                                       }
                                    } else {
                                       i_7_ += 2;
                                    }
                                 } else {
                                    i_7_ += 2;
                                    --i_6_;
                                 }
                              } else {
                                 i_7_ += 2;
                                 i_6_ -= 2;
                              }
                           } else {
                              i_6_ += 2;
                              ++i_7_;
                           }
                        } else {
                           i_6_ -= 2;
                           ++i_7_;
                        }
                     } else {
                        i_6_ += 2;
                     }
                  } else {
                     i_6_ -= 2;
                  }
               } else {
                  i_6_ += 2;
                  --i_7_;
               }
            } else {
               --i_7_;
               i_6_ -= 2;
            }
         } else {
            i_7_ -= 2;
            i_6_ += 2;
         }

         if (!needMasksUpdate) {
            player.processMovement(i_7_, i_6_, -9380, Class73.movementTypes[playerIndex]);
         } else {
            player.anInt11147 = i_6_;
            player.anInt11160 = i_7_;
            player.aBoolean11156 = true;
         }
      } else {
         int teleportType = packet.readBits(1);
         if (teleportType == 0) {
            int i_9_ = packet.readBits(12);
            int planeOffset = i_9_ >> 10;
            int xOffset = i_9_ >> 5 & 31;
            if (~xOffset < -16) {
               xOffset -= 32;
            }

            int yOffset = 31 & i_9_;
            if (~yOffset < -16) {
               yOffset -= 32;
            }

            int i_13_ = player.scenePositionXQueue[0] + xOffset;
            int i_14_ = yOffset + player.scenePositionYQueue[0];
            if (!needMasksUpdate) {
               player.processMovement(i_14_, i_13_, -9380, Class73.movementTypes[playerIndex]);
            } else {
               player.anInt11147 = i_13_;
               player.aBoolean11156 = true;
               player.anInt11160 = i_14_;
            }

            player.plane = player.aByte5931 = (byte)(player.plane + planeOffset & 3);
            if (Class238.tileHasBridgeFlag(i_14_, i_13_, -53)) {
               player.aByte5931 = (byte)(player.aByte5931 + 1);
            }

            if (~Class166.myPlayerIndex == ~playerIndex) {
               if (~player.plane != ~CacheNode_Sub20_Sub1.myPlayerPlane) {
                  Class194_Sub1.aBoolean6892 = true;
               }

               CacheNode_Sub20_Sub1.myPlayerPlane = player.plane;
            }
         } else {
            int i_15_ = packet.readBits(30);
            int planeOffset = i_15_ >> 28;
            int xOffset = 16383 & i_15_ >> 14;
            int yOffset = i_15_ & 16383;
            int i_19_ = -Node_Sub53.gameSceneBaseX + (player.scenePositionXQueue[0] - -Node_Sub53.gameSceneBaseX - -xOffset & 16383);
            int i_20_ = -Class320_Sub4.gameSceneBaseY + (16383 & yOffset + player.scenePositionYQueue[0] + Class320_Sub4.gameSceneBaseY);
            if (needMasksUpdate) {
               player.aBoolean11156 = true;
               player.anInt11160 = i_20_;
               player.anInt11147 = i_19_;
            } else {
               player.processMovement(i_20_, i_19_, -9380, Class73.movementTypes[playerIndex]);
            }

            player.plane = player.aByte5931 = (byte)(3 & planeOffset + player.plane);
            if (Class238.tileHasBridgeFlag(i_20_, i_19_, -108)) {
               player.aByte5931 = (byte)(player.aByte5931 + 1);
            }

            if (~Class166.myPlayerIndex == ~playerIndex) {
               CacheNode_Sub20_Sub1.myPlayerPlane = player.plane;
            }
         }
      }
   }

   public static void method3813(int i) {
      aWidget4085 = null;
      if (i != 10) {
         method3813(-58);
      }
   }
}
