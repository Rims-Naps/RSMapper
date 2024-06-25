public class EntityNode_Sub6 extends EntityNode {
   static Class299 aClass299_5988;
   static int anInt5989;
   protected Animable anAnimable5990;
   static String aString5991 = null;
   static int anInt5992;
   static int anInt5993;
   protected boolean aBoolean5994;
   protected EntityNode_Sub5[] anEntityNode_Sub5Array5995;
   static Class<?> aClass5996;

   static final boolean method969(GraphicsToolkit graphicstoolkit, int i, int i_0_) {
      ++anInt5989;
      int i_1_ = (Node_Sub54.GAME_SCENE_WDITH + -104) / 2;
      int i_2_ = (-104 + Class377_Sub1.GAME_SCENE_HEIGHT) / 2;
      boolean bool = true;

      for(int i_3_ = i_1_; ~i_3_ > ~(104 + i_1_); ++i_3_) {
         for(int i_4_ = i_2_; ~i_4_ > ~(104 + i_2_); ++i_4_) {
            for(int i_5_ = i; ~i_5_ >= -4; ++i_5_) {
               if (Class369.method4085(i_4_, i_0_ + -6400, i, i_3_, i_5_)) {
                  int i_6_ = i_5_;
                  if (Class238.tileHasBridgeFlag(i_4_, i_3_, 84)) {
                     i_6_ = i_5_ - 1;
                  }

                  if (i_6_ >= 0) {
                     bool &= Class296.method3474(i_3_, i_4_, i_6_, 121);
                  }
               }
            }
         }
      }

      if (!bool) {
         return false;
      } else {
         int[] is = new int[262144];

         for(int i_7_ = 0; ~is.length < ~i_7_; ++i_7_) {
            is[i_7_] = -16777216;
         }

         Class10.aGLSprite172 = graphicstoolkit.method1235(512, 512, 512, is, 0, 7468);
         Class55.method562((byte)18);
         if (i_0_ != 6400) {
            return true;
         } else {
            int i_8_ = 238 + (int)(Math.random() * 20.0) + -10 + (228 - -((int)(Math.random() * 20.0)) << 8) + (-10 + (int)(20.0 * Math.random()) + 238 << 16)
               | 0xFF000000;
            int i_9_ = (-10 + (int)(Math.random() * 20.0) + 238 | -1643839744) << 16;
            int i_10_ = (int)(8.0 * Math.random()) << 16 | (int)(8.0 * Math.random()) << 8 | (int)(8.0 * Math.random());
            boolean[][] bools = new boolean[1 + Class111.anInt1415 + 2][Class111.anInt1415 - -3];

            for(int i_11_ = i_1_; i_11_ < 104 + i_1_; i_11_ += Class111.anInt1415) {
               for(int i_12_ = i_2_; i_12_ < i_2_ - -104; i_12_ += Class111.anInt1415) {
                  int i_13_ = 0;
                  int i_14_ = 0;
                  int i_15_ = i_11_;
                  if (~i_11_ < -1) {
                     i_15_ = i_11_ - 1;
                     i_13_ += 4;
                  }

                  int i_16_ = i_12_;
                  if (i_12_ > 0) {
                     i_16_ = i_12_ - 1;
                  }

                  int i_17_ = Class111.anInt1415 + i_11_;
                  if (i_17_ < 104) {
                     ++i_17_;
                  }

                  int i_18_ = i_12_ - -Class111.anInt1415;
                  if (~i_18_ > -105) {
                     ++i_18_;
                     i_14_ += 4;
                  }

                  graphicstoolkit.KA(0, 0, Class111.anInt1415 * 4 + i_13_, i_14_ - -(4 * Class111.anInt1415));
                  graphicstoolkit.GA(-16777216);

                  for(int i_19_ = i; ~i_19_ >= -4; ++i_19_) {
                     for(int i_20_ = 0; i_20_ <= Class111.anInt1415; ++i_20_) {
                        for(int i_21_ = 0; i_21_ <= Class111.anInt1415; ++i_21_) {
                           bools[i_20_][i_21_] = Class369.method4085(i_21_ + i_16_, 0, i, i_15_ + i_20_, i_19_);
                        }
                     }

                     Node_Sub38_Sub37.aPlaneArray10466[i_19_].method3255(0, 0, 1024, i_15_, i_16_, i_17_, i_18_, bools);
                     if (!Class320_Sub3.aBoolean8235) {
                        for(int i_22_ = -4; ~Class111.anInt1415 < ~i_22_; ++i_22_) {
                           for(int i_23_ = -4; ~i_23_ > ~Class111.anInt1415; ++i_23_) {
                              int i_24_ = i_22_ + i_11_;
                              int i_25_ = i_23_ + i_12_;
                              if (~i_1_ >= ~i_24_ && i_25_ >= i_2_ && Class369.method4085(i_25_, i_0_ + -6400, i, i_24_, i_19_)) {
                                 int i_26_ = i_19_;
                                 if (Class238.tileHasBridgeFlag(i_25_, i_24_, -33)) {
                                    i_26_ = i_19_ - 1;
                                 }

                                 if (i_26_ >= 0) {
                                    Class117_Sub1.drawMinimapObjects(
                                       graphicstoolkit,
                                       i_8_,
                                       i_24_,
                                       i_25_,
                                       i_13_ - -(i_22_ * 4),
                                       (-i_23_ + Class111.anInt1415) * 4 + i_14_ + -4,
                                       4827,
                                       i_26_,
                                       i_9_
                                    );
                                 }
                              }
                           }
                        }
                     }
                  }

                  if (Class320_Sub3.aBoolean8235) {
                     Class84 class84 = Class304.SCENE_CLIP_DATA_PLANES[i];

                     for(int i_27_ = 0; ~i_27_ > ~Class111.anInt1415; ++i_27_) {
                        for(int i_28_ = 0; ~Class111.anInt1415 < ~i_28_; ++i_28_) {
                           int i_29_ = i_11_ + i_27_;
                           int i_30_ = i_28_ + i_12_;
                           int i_31_ = class84.clipMasks[i_29_ + -class84.anInt1139][i_30_ + -class84.anInt1135];
                           if (~(i_31_ & 1076101120) != -1) {
                              graphicstoolkit.method1239(4, 4, -4 + (-i_28_ + Class111.anInt1415) * 4 + i_14_, (byte)116, i_13_ + 4 * i_27_, -1713569622);
                           } else if (~(i_31_ & 8388608) != -1) {
                              graphicstoolkit.method1242(-4 + (Class111.anInt1415 + -i_28_) * 4 + i_14_, -1713569622, i_13_ - -(i_27_ * 4), false, 4);
                           } else if ((33554432 & i_31_) != 0) {
                              graphicstoolkit.method1243(4, -4 + i_14_ + (-i_28_ + Class111.anInt1415) * 4, -1713569622, 3 + 4 * i_27_ + i_13_, i_0_ + -6398);
                           } else if (~(134217728 & i_31_) != -1) {
                              graphicstoolkit.method1242(3 + (-i_28_ + Class111.anInt1415) * 4 + i_14_ + -4, -1713569622, 4 * i_27_ + i_13_, false, 4);
                           } else if ((i_31_ & 536870912) != 0) {
                              graphicstoolkit.method1243(4, -4 + (Class111.anInt1415 - i_28_) * 4 + i_14_, -1713569622, 4 * i_27_ + i_13_, 2);
                           }
                        }
                     }
                  }

                  graphicstoolkit.aa(i_13_, i_14_, 4 * Class111.anInt1415, 4 * Class111.anInt1415, i_10_, 2);
                  Class10.aGLSprite172
                     .method1195(
                        48 - -(4 * (i_11_ - i_1_)),
                        -(4 * Class111.anInt1415) + -((i_12_ + -i_2_) * 4) + 464,
                        Class111.anInt1415 * 4,
                        4 * Class111.anInt1415,
                        i_13_,
                        i_14_
                     );
               }
            }

            graphicstoolkit.la();
            graphicstoolkit.GA(-16777215);
            Class320_Sub21.method3764(i_0_ + -6505);
            Class283.totalMinimapAreaIcons = 0;
            Node_Sub47.aClass312_7558.method3614(-601);
            if (!Class320_Sub3.aBoolean8235) {
               for(int localX = i_1_; ~localX > ~(104 + i_1_); ++localX) {
                  for(int localY = i_2_; ~localY > ~(i_2_ + 104); ++localY) {
                     for(int plane = i; plane <= i + 1 && plane <= 3; ++plane) {
                        if (Class369.method4085(localY, 0, i, localX, plane)) {
                           WorldObject interface19 = (WorldObject)Class270_Sub1_Sub1.method3303(plane, localX, localY);
                           if (interface19 == null) {
                              interface19 = (WorldObject)Class262_Sub20.method3203(
                                 plane, localX, localY, aClass5996 != null ? aClass5996 : (aClass5996 = method972("WorldObject"))
                              );
                           }

                           if (interface19 == null) {
                              interface19 = (WorldObject)Node_Sub38_Sub12.method2830(plane, localX, localY);
                           }

                           if (interface19 == null) {
                              interface19 = (WorldObject)CacheNode_Sub8.method2320(plane, localX, localY);
                           }

                           if (interface19 != null) {
                              ObjectDefinition objectdefinition = Class186.aClass112_2256.getObjectDefinitionsForId(interface19.getId(-32136), 100);
                              if (!objectdefinition.aBoolean3002 || Class101.aBoolean1313) {
                                 int areaSprite = objectdefinition.mapAreaId;
                                 if (objectdefinition.anIntArray2984 != null) {
                                    for(int i_36_ = 0; i_36_ < objectdefinition.anIntArray2984.length; ++i_36_) {
                                       if (objectdefinition.anIntArray2984[i_36_] != -1) {
                                          ObjectDefinition objectdefinition_37_ = Class186.aClass112_2256
                                             .getObjectDefinitionsForId(objectdefinition.anIntArray2984[i_36_], i_0_ ^ 6487);
                                          if (~objectdefinition_37_.mapAreaId <= -1) {
                                             areaSprite = objectdefinition_37_.mapAreaId;
                                          }
                                       }
                                    }
                                 }

                                 if (areaSprite >= 0) {
                                    Class281.minimapAreaIconObjectIds[Class283.totalMinimapAreaIcons] = objectdefinition.objectId;
                                    Class298.minimapAreaIconLocalXPositions[Class283.totalMinimapAreaIcons] = localX;
                                    Class184.minimapAreaIconLocalYPositions[Class283.totalMinimapAreaIcons] = localY;
                                    ++Class283.totalMinimapAreaIcons;
                                 }
                              }
                           }
                        }
                     }
                  }
               }

               if (Class262_Sub15_Sub1.aClass224_10520 != null) {
                  Class4.index2.anInt3795 = 1;
                  Class304.aClass215_3834.method2068(-1, 1024, 64);

                  for(int i_46_ = 0; i_46_ < Class262_Sub15_Sub1.aClass224_10520.anInt2670; ++i_46_) {
                     int i_47_ = Class262_Sub15_Sub1.aClass224_10520.anIntArray2668[i_46_];
                     if (Class295.myPlayer.plane == i_47_ >> 28) {
                        int i_48_ = -Node_Sub53.gameSceneBaseX + (16383 & i_47_ >> 14);
                        int i_49_ = (16383 & i_47_) + -Class320_Sub4.gameSceneBaseY;
                        if (~i_48_ <= -1 && ~i_48_ > ~Node_Sub54.GAME_SCENE_WDITH && ~i_49_ <= -1 && i_49_ < Class377_Sub1.GAME_SCENE_HEIGHT) {
                           Node_Sub47.aClass312_7558.method3625((byte)-54, new Node_Sub32(i_46_));
                        } else {
                           AreaDefinitions class79 = Class304.aClass215_3834
                              .getAreaDefinitions((byte)116, Class262_Sub15_Sub1.aClass224_10520.anIntArray2669[i_46_]);
                           if (class79.anIntArray1049 != null
                              && ~(class79.anInt1089 + i_48_) <= -1
                              && ~(i_48_ - -class79.anInt1068) > ~Node_Sub54.GAME_SCENE_WDITH
                              && class79.anInt1060 + i_49_ >= 0
                              && ~(i_49_ + class79.anInt1051) > ~Class377_Sub1.GAME_SCENE_HEIGHT) {
                              Node_Sub47.aClass312_7558.method3625((byte)-54, new Node_Sub32(i_46_));
                           }
                        }
                     }
                  }

                  Class304.aClass215_3834.method2068(i_0_ + -6401, 128, 64);
                  Class4.index2.anInt3795 = 2;
                  Class4.index2.method3521((byte)-18);
               }
            }

            return true;
         }
      }
   }

   public static void method970(int i) {
      aString5991 = null;
      aClass299_5988 = null;
      if (i != 0) {
         aClass299_5988 = null;
      }
   }

   final boolean method971(GraphicsToolkit graphicstoolkit, byte b, int i, int i_50_) {
      ++anInt5992;
      int i_51_ = this.anAnimable5990.method818((byte)47);
      if (this.anEntityNode_Sub5Array5995 != null) {
         for(int i_52_ = 0; i_52_ < this.anEntityNode_Sub5Array5995.length; ++i_52_) {
            this.anEntityNode_Sub5Array5995[i_52_].anInt5983 <<= i_51_;
            if (this.anEntityNode_Sub5Array5995[i_52_].method968(i_50_, i) && this.anAnimable5990.method810(i, i_50_, false, graphicstoolkit)) {
               this.anEntityNode_Sub5Array5995[i_52_].anInt5983 >>= i_51_;
               return true;
            }

            this.anEntityNode_Sub5Array5995[i_52_].anInt5983 >>= i_51_;
         }
      }

      int i_53_ = -42 % ((b - 71) / 34);
      return false;
   }

   EntityNode_Sub6() {
   }

   static Class<?> method972(String string) {
      try {
         return Class.forName(string);
      } catch (ClassNotFoundException var3) {
         throw (NoClassDefFoundError)new NoClassDefFoundError().initCause(var3);
      }
   }
}
