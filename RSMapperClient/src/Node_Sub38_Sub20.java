public class Node_Sub38_Sub20 extends Node_Sub38 {
   static int anInt10297;
   static int anInt10298;
   private int anInt10299;
   static int anInt10300;
   static int anInt10301;
   static int anInt10302;
   private int anInt10303 = 4096;
   static int anInt10304;
   static int anInt10305;
   private int anInt10306 = 12288;
   private int anInt10307;
   static int anInt10308;
   static java.awt.Canvas GAME_CANVAS;
   static int anInt10310;
   private int anInt10311;
   private int anInt10312;
   static int anInt10313;
   private int anInt10314;

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      if (bool) {
         anInt10298 = -73;
      }

      if (i != 0) {
         if (i != 1) {
            if (i != 2) {
               if (i != 3) {
                  if (i != 4) {
                     if (i != 5) {
                        if (~i == -7) {
                           this.anInt10299 = buffer.readUnsignedShort();
                        }
                     } else {
                        this.anInt10303 = buffer.readUnsignedShort();
                     }
                  } else {
                     this.anInt10306 = buffer.readUnsignedShort();
                  }
               } else {
                  this.anInt10311 = buffer.readUnsignedShort();
               }
            } else {
               this.anInt10307 = buffer.readUnsignedShort();
            }
         } else {
            this.anInt10314 = buffer.readUnsignedShort();
         }
      } else {
         this.anInt10312 = buffer.readUnsignedShort();
      }

      ++anInt10304;
   }

   public Node_Sub38_Sub20() {
      super(0, true);
      this.anInt10299 = 8192;
      this.anInt10307 = 0;
      this.anInt10311 = 2048;
      this.anInt10312 = 2048;
      this.anInt10314 = 0;
   }

   @Override
   final void method2785(int i) {
      Node_Sub37.method2772((byte)54);
      if (i == 7) {
         ++anInt10300;
      }
   }

   public static void method2852(int i) {
      if (i == -9200) {
         GAME_CANVAS = null;
      }
   }

   private final boolean method2853(int i, int i_1_, int i_2_) {
      ++anInt10297;
      int i_3_ = (i + -i_1_) * this.anInt10306 >> 12;
      if (i_2_ != 3857) {
         this.method2780(false, null, -68);
      }

      int i_4_ = Class17.anIntArray277[255 * i_3_ >> 12 & 0xFF];
      i_4_ = (i_4_ << 12) / this.anInt10306;
      i_4_ = (i_4_ << 12) / this.anInt10299;
      i_4_ = this.anInt10303 * i_4_ >> 12;
      return ~(i + i_1_) > ~i_4_ && -i_4_ < i_1_ + i;
   }

   @Override
   final int[] method2775(int i, int i_5_) {
      if (i < 107) {
         return null;
      } else {
         ++anInt10302;
         int[] is = this.aClass146_7460.method1645(27356, i_5_);
         if (this.aClass146_7460.aBoolean1819) {
            int i_6_ = Node_Sub25_Sub1.anIntArray9941[i_5_] + -2048;

            for(int i_7_ = 0; Class339_Sub7.anInt8728 > i_7_; ++i_7_) {
               int i_8_ = CacheNode_Sub3.anIntArray9442[i_7_] + -2048;
               int i_9_ = this.anInt10312 + i_8_;
               i_9_ = i_9_ < -2048 ? 4096 + i_9_ : i_9_;
               i_9_ = ~i_9_ < -2049 ? -4096 + i_9_ : i_9_;
               int i_10_ = this.anInt10314 + i_6_;
               i_10_ = ~i_10_ <= 2047 ? i_10_ : i_10_ + 4096;
               i_10_ = i_10_ <= 2048 ? i_10_ : -4096 + i_10_;
               int i_11_ = this.anInt10307 + i_8_;
               i_11_ = ~i_11_ > 2047 ? 4096 + i_11_ : i_11_;
               i_11_ = ~i_11_ < -2049 ? i_11_ - 4096 : i_11_;
               int i_12_ = i_6_ - -this.anInt10311;
               i_12_ = i_12_ < -2048 ? 4096 + i_12_ : i_12_;
               i_12_ = i_12_ <= 2048 ? i_12_ : -4096 + i_12_;
               is[i_7_] = !this.method2853(i_10_, i_9_, 3857) && !this.method2854(504017132, i_11_, i_12_) ? 0 : 4096;
            }
         }

         return is;
      }
   }

   private final boolean method2854(int i, int i_13_, int i_14_) {
      ++anInt10308;
      if (i != 504017132) {
         return true;
      } else {
         int i_15_ = this.anInt10306 * (i_13_ + i_14_) >> 12;
         int i_16_ = Class17.anIntArray277[0xFF & i_15_ * 255 >> 12];
         i_16_ = (i_16_ << 12) / this.anInt10306;
         i_16_ = (i_16_ << 12) / this.anInt10299;
         i_16_ = i_16_ * this.anInt10303 >> 12;
         return ~(-i_13_ + i_14_) > ~i_16_ && ~(-i_16_) > ~(-i_13_ + i_14_);
      }
   }

   static final int method2855(int i, byte b) {
      ++anInt10301;
      int i_17_ = 0;
      if (~i > -1 || i >= 65536) {
         i >>>= 16;
         i_17_ += 16;
      }

      if (i >= 256) {
         i_17_ += 8;
         i >>>= 8;
      }

      if (~i <= -17) {
         i_17_ += 4;
         i >>>= 4;
      }

      if (~i <= -5) {
         i_17_ += 2;
         i >>>= 2;
      }

      if (b > -47) {
         decodeReceivedMapRegions(7);
      }

      if (i >= 1) {
         i >>>= 1;
         ++i_17_;
      }

      return i_17_ + i;
   }

   static final boolean method2856(
      int i, Class84 class84, int i_18_, int i_19_, int routeType, int i_21_, int i_22_, int i_23_, int i_24_, int i_25_, int i_26_, int i_27_
   ) {
      ++anInt10305;
      int i_28_ = i_18_;
      int i_29_ = i_21_;
      int i_30_ = 64;
      int i_31_ = 64;
      int i_32_ = -i_30_ + i_18_;
      Node_Sub36_Sub2.anIntArrayArray10047[i_30_][i_31_] = 99;
      int i_33_ = -i_31_ + i_21_;
      Class262_Sub23.anIntArrayArray7892[i_30_][i_31_] = 0;
      int i_34_ = 0;
      Node_Sub39.routeFinderXArray[i_34_] = i_18_;
      int i_35_ = 0;
      Class339_Sub6.routeFinderYArray[i_34_++] = i_21_;
      int[][] is = class84.clipMasks;

      label288:
      while(~i_34_ != ~i_35_) {
         i_29_ = Class339_Sub6.routeFinderYArray[i_35_];
         i_28_ = Node_Sub39.routeFinderXArray[i_35_];
         i_35_ = 1 + i_35_ & 4095;
         i_31_ = -i_33_ + i_29_;
         i_30_ = i_28_ + -i_32_;
         int i_36_ = i_28_ - class84.anInt1139;
         int i_37_ = i_29_ + -class84.anInt1135;
         if (routeType != -4) {
            if (~routeType != 2) {
               if (routeType != -2) {
                  if (~routeType != 0) {
                     if (routeType != 0 && routeType != 1 && ~routeType != -3 && ~routeType != -4 && ~routeType != -10) {
                        if (class84.method982(i_28_, 25451, routeType, i_23_, i_24_, i, i_29_, i_25_)) {
                           Class219.anInt2623 = i_29_;
                           Class315.anInt4033 = i_28_;
                           return true;
                        }
                     } else if (class84.method989(i_25_, routeType, i_24_, i_29_, i_28_, i_23_, i, 2883842)) {
                        Class219.anInt2623 = i_29_;
                        Class315.anInt4033 = i_28_;
                        return true;
                     }
                  } else if (class84.method988(i_24_, i_26_ ^ 7733, i_22_, i_23_, i_28_, i_25_, i_27_, i_19_, i_29_)) {
                     Class219.anInt2623 = i_29_;
                     Class315.anInt4033 = i_28_;
                     return true;
                  }
               } else if (class84.method984(i_25_, i_24_, (byte)-93, i_25_, i_28_, i_23_, i_22_, i_27_, i_29_, i_19_)) {
                  Class219.anInt2623 = i_29_;
                  Class315.anInt4033 = i_28_;
                  return true;
               }
            } else if (Class150_Sub2.method1659(i_23_, i_25_, i_28_, i_26_ ^ 17, i_19_, i_27_, i_29_, i_24_, i_25_)) {
               Class219.anInt2623 = i_29_;
               Class315.anInt4033 = i_28_;
               return true;
            }
         } else if (~i_28_ == ~i_23_ && i_24_ == i_29_) {
            Class219.anInt2623 = i_29_;
            Class315.anInt4033 = i_28_;
            return true;
         }

         int i_38_ = Class262_Sub23.anIntArrayArray7892[i_30_][i_31_] - -1;
         if (~i_30_ < -1
            && ~Node_Sub36_Sub2.anIntArrayArray10047[-1 + i_30_][i_31_] == -1
            && ~(1134821376 & is[i_36_ + -1][i_37_]) == -1
            && ~(1310982144 & is[i_36_ - 1][-1 + i_25_ + i_37_]) == -1) {
            int i_39_ = 1;

            while(true) {
               if (i_39_ >= i_25_ + -1) {
                  Node_Sub39.routeFinderXArray[i_34_] = i_28_ - 1;
                  Class339_Sub6.routeFinderYArray[i_34_] = i_29_;
                  i_34_ = i_34_ + 1 & 4095;
                  Node_Sub36_Sub2.anIntArrayArray10047[-1 + i_30_][i_31_] = 2;
                  Class262_Sub23.anIntArrayArray7892[i_30_ - 1][i_31_] = i_38_;
                  break;
               }

               if (~(1336147968 & is[-1 + i_36_][i_37_ + i_39_]) != -1) {
                  break;
               }

               ++i_39_;
            }
         }

         if (128 - i_25_ > i_30_
            && ~Node_Sub36_Sub2.anIntArrayArray10047[i_30_ - -1][i_31_] == -1
            && ~(is[i_36_ - -i_25_][i_37_] & 1625554944) == -1
            && (2015625216 & is[i_36_ - -i_25_][-1 + i_37_ + i_25_]) == 0) {
            int i_40_ = 1;

            while(true) {
               if (i_25_ - 1 <= i_40_) {
                  Node_Sub39.routeFinderXArray[i_34_] = 1 + i_28_;
                  Class339_Sub6.routeFinderYArray[i_34_] = i_29_;
                  Node_Sub36_Sub2.anIntArrayArray10047[i_30_ - -1][i_31_] = 8;
                  i_34_ = i_34_ + 1 & 4095;
                  Class262_Sub23.anIntArrayArray7892[i_30_ - -1][i_31_] = i_38_;
                  break;
               }

               if ((is[i_25_ + i_36_][i_40_ + i_37_] & 2028208128) != 0) {
                  break;
               }

               ++i_40_;
            }
         }

         if (~i_31_ < -1
            && Node_Sub36_Sub2.anIntArrayArray10047[i_30_][i_31_ - 1] == 0
            && (1134821376 & is[i_36_][-1 + i_37_]) == 0
            && (is[i_36_ + i_25_ - 1][-1 + i_37_] & 1625554944) == 0) {
            int i_41_ = 1;

            while(true) {
               if (-1 + i_25_ <= i_41_) {
                  Node_Sub39.routeFinderXArray[i_34_] = i_28_;
                  Class339_Sub6.routeFinderYArray[i_34_] = i_29_ + -1;
                  i_34_ = 4095 & 1 + i_34_;
                  Node_Sub36_Sub2.anIntArrayArray10047[i_30_][i_31_ - 1] = 1;
                  Class262_Sub23.anIntArrayArray7892[i_30_][i_31_ + -1] = i_38_;
                  break;
               }

               if (~(is[i_41_ + i_36_][-1 + i_37_] & 1675886592) != -1) {
                  break;
               }

               ++i_41_;
            }
         }

         if (128 - i_25_ > i_31_
            && Node_Sub36_Sub2.anIntArrayArray10047[i_30_][1 + i_31_] == 0
            && ~(is[i_36_][i_37_ - -i_25_] & 1310982144) == -1
            && ~(is[i_36_ - (-i_25_ + 1)][i_25_ + i_37_] & 2015625216) == -1) {
            int i_42_ = 1;

            while(true) {
               if (~(i_25_ + -1) >= ~i_42_) {
                  Node_Sub39.routeFinderXArray[i_34_] = i_28_;
                  Class339_Sub6.routeFinderYArray[i_34_] = 1 + i_29_;
                  i_34_ = 1 + i_34_ & 4095;
                  Node_Sub36_Sub2.anIntArrayArray10047[i_30_][i_31_ + 1] = 4;
                  Class262_Sub23.anIntArrayArray7892[i_30_][i_31_ - -1] = i_38_;
                  break;
               }

               if ((is[i_42_ + i_36_][i_25_ + i_37_] & 2116288512) != 0) {
                  break;
               }

               ++i_42_;
            }
         }

         if (i_30_ > 0 && i_31_ > 0 && ~Node_Sub36_Sub2.anIntArrayArray10047[i_30_ + -1][-1 + i_31_] == -1 && (is[-1 + i_36_][i_37_ + -1] & 1134821376) == 0) {
            int i_43_ = 1;

            while(true) {
               if (i_43_ >= i_25_) {
                  Node_Sub39.routeFinderXArray[i_34_] = i_28_ + -1;
                  Class339_Sub6.routeFinderYArray[i_34_] = -1 + i_29_;
                  Node_Sub36_Sub2.anIntArrayArray10047[-1 + i_30_][-1 + i_31_] = 3;
                  i_34_ = 4095 & i_34_ + 1;
                  Class262_Sub23.anIntArrayArray7892[i_30_ - 1][-1 + i_31_] = i_38_;
                  break;
               }

               if (~(1336147968 & is[-1 + i_36_][i_43_ + i_37_ + -1]) != -1 || (1675886592 & is[i_36_ + -1 - -i_43_][i_37_ - 1]) != 0) {
                  break;
               }

               ++i_43_;
            }
         }

         if (~(128 - i_25_) < ~i_30_
            && ~i_31_ < -1
            && ~Node_Sub36_Sub2.anIntArrayArray10047[1 + i_30_][i_31_ + -1] == -1
            && ~(1625554944 & is[i_36_ + i_25_][i_37_ + -1]) == -1) {
            int i_44_ = 1;

            while(true) {
               if (i_44_ >= i_25_) {
                  Node_Sub39.routeFinderXArray[i_34_] = 1 + i_28_;
                  Class339_Sub6.routeFinderYArray[i_34_] = -1 + i_29_;
                  Node_Sub36_Sub2.anIntArrayArray10047[i_30_ - -1][-1 + i_31_] = 9;
                  i_34_ = 1 + i_34_ & 4095;
                  Class262_Sub23.anIntArrayArray7892[i_30_ + 1][i_31_ + -1] = i_38_;
                  break;
               }

               if ((2028208128 & is[i_36_ + i_25_][i_44_ + -1 + i_37_]) != 0 || (is[i_44_ + i_36_][i_37_ - 1] & 1675886592) != 0) {
                  break;
               }

               ++i_44_;
            }
         }

         if (i_30_ > 0
            && i_31_ < 128 + -i_25_
            && Node_Sub36_Sub2.anIntArrayArray10047[i_30_ - 1][1 + i_31_] == 0
            && ~(1310982144 & is[-1 + i_36_][i_25_ + i_37_]) == -1) {
            int i_45_ = 1;

            while(true) {
               if (~i_45_ <= ~i_25_) {
                  Node_Sub39.routeFinderXArray[i_34_] = i_28_ - 1;
                  Class339_Sub6.routeFinderYArray[i_34_] = i_29_ + 1;
                  Node_Sub36_Sub2.anIntArrayArray10047[-1 + i_30_][i_31_ - -1] = 6;
                  i_34_ = 4095 & 1 + i_34_;
                  Class262_Sub23.anIntArrayArray7892[i_30_ - 1][i_31_ + 1] = i_38_;
                  break;
               }

               if ((is[i_36_ - 1][i_37_ + i_45_] & 1336147968) != 0 || (is[i_45_ + i_36_ - 1][i_25_ + i_37_] & 2116288512) != 0) {
                  break;
               }

               ++i_45_;
            }
         }

         if (i_30_ < -i_25_ + 128
            && ~i_31_ > ~(-i_25_ + 128)
            && Node_Sub36_Sub2.anIntArrayArray10047[1 + i_30_][1 + i_31_] == 0
            && ~(is[i_25_ + i_36_][i_25_ + i_37_] & 2015625216) == -1) {
            for(int i_46_ = 1; i_25_ > i_46_; ++i_46_) {
               if (~(2116288512 & is[i_46_ + i_36_][i_37_ - -i_25_]) != -1 || (2028208128 & is[i_36_ - -i_25_][i_37_ - -i_46_]) != 0) {
                  continue label288;
               }
            }

            Node_Sub39.routeFinderXArray[i_34_] = 1 + i_28_;
            Class339_Sub6.routeFinderYArray[i_34_] = i_29_ + 1;
            Node_Sub36_Sub2.anIntArrayArray10047[i_30_ - -1][1 + i_31_] = 12;
            i_34_ = i_34_ + 1 & 4095;
            Class262_Sub23.anIntArrayArray7892[1 + i_30_][1 + i_31_] = i_38_;
         }
      }

      if (i_26_ != -1) {
         anInt10298 = -65;
      }

      Class219.anInt2623 = i_29_;
      Class315.anInt4033 = i_28_;
      return false;
   }

   static final void decodeReceivedMapRegions(int i) {
      if (!RSMapperClient.MAP_LOADED) {
         ++anInt10310;
         Class61.anInt898 = 0;
         Packet packet = Class218.aClass123_2566.aPacket1570;
         int gameSceneSize = packet.readUnsignedByteC();
         boolean forceRefresh = ~packet.readUnsignedByte() == -2;
         int gameSceneBaseRegionX = packet.readUnsignedShortLE();
         int gameSceneBaseRegionY = packet.readUnsignedShort();
         Class95.method1066(-111);
         Animable_Sub2.updateGameSceneSize(gameSceneSize);
         int i_50_ = (Class218.aClass123_2566.anInt1581 + -packet.offset) / 16;
         Class15.XTEA_KEYS = new int[i_50_][4];

         for(int count = 0; count < i_50_; ++count) {
            for(int index = 0; ~index > -5; ++index) {
               Class15.XTEA_KEYS[count][index] = packet.readInt();
            }
         }

         Class194.npcFileData = null;
         Class188_Sub1_Sub1.mapFileData = new byte[i_50_][];
         FileOnDisk.landFileData = new byte[i_50_][];
         Class144.landArchiveIds = new int[i_50_];
         Class320_Sub6.undermapFileData = new byte[i_50_][];
         StandardPlane.mapArchiveIds = new int[i_50_];
         Class42.undermapArchiveIds = new int[i_50_];
         ProducingGraphicsBuffer.underlandArchiveIds = new int[i_50_];
         Class204.npcArchiveIds = null;
         if (i > -2) {
            anInt10313 = 30;
         }

         Class262_Sub1.MAP_REGION_HASHES = new int[i_50_];
         Class320_Sub18.underLandFileData = new byte[i_50_][];
         i_50_ = 0;

         for(int thisRegionX = (-(Node_Sub54.GAME_SCENE_WDITH >> 4) + gameSceneBaseRegionX) / 8;
            ((Node_Sub54.GAME_SCENE_WDITH >> 4) + gameSceneBaseRegionX) / 8 >= thisRegionX;
            ++thisRegionX
         ) {
            for(int thisRegionY = (-(Class377_Sub1.GAME_SCENE_HEIGHT >> 4) + gameSceneBaseRegionY) / 8;
               ~thisRegionY >= ~((gameSceneBaseRegionY + (Class377_Sub1.GAME_SCENE_HEIGHT >> 4)) / 8);
               ++thisRegionY
            ) {
               Class262_Sub1.MAP_REGION_HASHES[i_50_] = (thisRegionX << 8) + thisRegionY;
               StandardPlane.mapArchiveIds[i_50_] = Animable_Sub1_Sub1.index5.method3519("m" + thisRegionX + "_" + thisRegionY, (byte)33);
               Class144.landArchiveIds[i_50_] = Animable_Sub1_Sub1.index5.method3519("l" + thisRegionX + "_" + thisRegionY, (byte)19);
               Class42.undermapArchiveIds[i_50_] = Animable_Sub1_Sub1.index5.method3519("um" + thisRegionX + "_" + thisRegionY, (byte)87);
               if ((thisRegionX << 8) + thisRegionY == 11826) {
                  System.out.println("FILE: " + Class42.undermapArchiveIds[i_50_] + " - um" + thisRegionX + "_" + thisRegionY);
               }

               ProducingGraphicsBuffer.underlandArchiveIds[i_50_] = Animable_Sub1_Sub1.index5.method3519("ul" + thisRegionX + "_" + thisRegionY, (byte)109);
               ++i_50_;
            }
         }

         Class364.method4057(forceRefresh, gameSceneBaseRegionX, 12, gameSceneBaseRegionY, (byte)-36);
      }
   }
}
