public class Node_Sub16 extends Node {
   static int anInt7130;
   static int anInt7131;
   static Class124 aClass124_7132 = new Class124(22);
   static int anInt7133;
   static int anInt7134;
   static int anInt7135;
   static int anInt7136;
   protected int[] slotItemIds = new int[]{-1};
   protected int[] slotItemAmounts = new int[1];
   static Class312 aClass312_7139 = new Class312();
   static int anInt7140;

   private final long method2587(boolean bool, int i, int[] is, int[] is_0_, boolean bool_1_) {
      ++anInt7133;
      long[] ls = CacheNode_Sub20.aLongArray9626;
      long l = -1L;
      l = ls[(int)((l ^ (long)(i >> 8)) & 255L)] ^ l >>> 8;
      l = ls[(int)((l ^ (long)i) & 255L)] ^ l >>> 8;

      for(int i_2_ = 0; is.length > i_2_; ++i_2_) {
         l = l >>> 8 ^ ls[(int)((l ^ (long)(is[i_2_] >> 24)) & 255L)];
         l = ls[(int)(255L & (l ^ (long)(is[i_2_] >> 16)))] ^ l >>> 8;
         l = l >>> 8 ^ ls[(int)(255L & ((long)(is[i_2_] >> 8) ^ l))];
         l = l >>> 8 ^ ls[(int)(255L & ((long)is[i_2_] ^ l))];
      }

      if (is_0_ != null) {
         for(int i_3_ = 0; ~i_3_ > -6; ++i_3_) {
            l = l >>> 8 ^ ls[(int)(255L & (l ^ (long)is_0_[i_3_]))];
         }
      }

      l = ls[(int)((l ^ (long)(!bool ? 0 : 1)) & 255L)] ^ l >>> 8;
      if (!bool_1_) {
         method2593(87, 65, 50, -18, -126, 94, 103, -128, false, -37, null);
      }

      return l;
   }

   final DrawableModel method2588(
      int i, int i_4_, GraphicsToolkit graphicstoolkit, int i_5_, boolean bool, Animator animator, PlayerDefinition playerdefinition
   ) {
      ++anInt7140;
      DrawableModel drawablemodel = null;
      int i_6_ = i_5_;
      RenderDefinitions class259 = null;
      if (~i != 0) {
         class259 = InputStream_Sub2.aClass281_83.getAnimationAndSoundDefinitionsFor(i);
      }

      int[] is = this.slotItemIds;
      if (i_4_ != 1) {
         this.slotItemAmounts = null;
      }

      if (class259 != null && class259.anIntArray3276 != null) {
         is = new int[class259.anIntArray3276.length];

         for(int i_7_ = 0; ~i_7_ > ~class259.anIntArray3276.length; ++i_7_) {
            int i_8_ = class259.anIntArray3276[i_7_];
            if (i_8_ >= 0 && ~this.slotItemIds.length < ~i_8_) {
               is[i_7_] = this.slotItemIds[i_8_];
            } else {
               is[i_7_] = -1;
            }
         }
      }

      if (animator != null) {
         i_6_ = i_5_ | animator.method237((byte)-127);
      }

      long l = this.method2587(bool, i, is, playerdefinition == null ? null : playerdefinition.anIntArray3430, true);
      if (Class96.aClass61_1272 != null) {
         drawablemodel = (DrawableModel)Class96.aClass61_1272.method607(l, i_4_ ^ 1);
      }

      if (drawablemodel == null || ~graphicstoolkit.b(drawablemodel.ua(), i_6_) != -1) {
         if (drawablemodel != null) {
            i_6_ = graphicstoolkit.c(i_6_, drawablemodel.ua());
         }

         int i_9_ = i_6_;
         boolean bool_10_ = false;

         for(int i_11_ = 0; ~i_11_ > ~is.length; ++i_11_) {
            if (is[i_11_] != -1 && !EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(is[i_11_]).method1686(bool, null, i_4_ + -50)) {
               bool_10_ = true;
            }
         }

         if (bool_10_) {
            return null;
         }

         Model[] models = new Model[is.length];

         for(int i_12_ = 0; i_12_ < is.length; ++i_12_) {
            if (~is[i_12_] != 0) {
               models[i_12_] = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(is[i_12_]).method1683(null, bool, Node_Sub19.method2612(i_4_, -52));
            }
         }

         if (class259 != null && class259.anIntArrayArray3273 != null) {
            for(int i_13_ = 0; ~i_13_ > ~class259.anIntArrayArray3273.length; ++i_13_) {
               if (class259.anIntArrayArray3273[i_13_] != null && models[i_13_] != null) {
                  int i_14_ = class259.anIntArrayArray3273[i_13_][0];
                  int i_15_ = class259.anIntArrayArray3273[i_13_][1];
                  int i_16_ = class259.anIntArrayArray3273[i_13_][2];
                  int i_17_ = class259.anIntArrayArray3273[i_13_][3];
                  int i_18_ = class259.anIntArrayArray3273[i_13_][4];
                  int i_19_ = class259.anIntArrayArray3273[i_13_][5];
                  if (~i_17_ != -1 || i_18_ != 0 || i_19_ != 0) {
                     models[i_13_].method2085(i_19_, i_17_, -89, i_18_);
                  }

                  if (~i_14_ != -1 || ~i_15_ != -1 || ~i_16_ != -1) {
                     models[i_13_].method2082(i_14_, i_15_, -96, i_16_);
                  }
               }
            }
         }

         Model model = new Model(models, models.length);
         if (playerdefinition != null) {
            i_9_ = i_6_ | 16384;
         }

         drawablemodel = graphicstoolkit.a(model, i_9_, Class320_Sub27.anInt8461, 64, 850);
         if (playerdefinition != null) {
            for(int i_20_ = 0; i_20_ < 10; ++i_20_) {
               for(int i_21_ = 0; i_21_ < Class45.aShortArrayArray5265[i_20_].length; ++i_21_) {
                  if (Class117_Sub2.aShortArrayArrayArray5151[i_20_][i_21_].length > playerdefinition.anIntArray3430[i_20_]) {
                     drawablemodel.ia(
                        Class45.aShortArrayArray5265[i_20_][i_21_],
                        Class117_Sub2.aShortArrayArrayArray5151[i_20_][i_21_][playerdefinition.anIntArray3430[i_20_]]
                     );
                  }
               }
            }
         }

         if (Class96.aClass61_1272 != null) {
            drawablemodel.s(i_6_);
            Class96.aClass61_1272.method601(drawablemodel, 25566, l);
         }
      }

      if (animator == null) {
         return drawablemodel;
      } else {
         DrawableModel drawablemodel_22_ = drawablemodel.method633((byte)1, i_6_, true);
         animator.method225(0, drawablemodel_22_, 0);
         return drawablemodel_22_;
      }
   }

   static final void method2589(Index class302, int i) {
      Class89.anInt1197 = class302.method3519("hitbar_default", (byte)39);
      ++anInt7131;
      Node_Sub38_Sub20.anInt10313 = class302.method3519("timerbar_default", (byte)46);
      Class41.anInt626 = class302.method3519("headicons_pk", (byte)19);
      Class162.anInt2004 = class302.method3519("headicons_prayer", (byte)19);
      Class347.anInt4281 = class302.method3519("hint_headicons", (byte)45);
      Node_Sub9_Sub5.anInt9767 = class302.method3519("hint_mapmarkers", (byte)5);
      Class169_Sub1.anInt8787 = class302.method3519("mapflag", (byte)97);
      Node_Sub21.anInt7186 = class302.method3519("cross", (byte)98);
      OutgoingPacket.anInt4045 = class302.method3519("mapdots", (byte)127);
      Class163.anInt2019 = class302.method3519("scrollbar", (byte)117);
      if (i != 1) {
         method2589(null, 94);
      }

      OverlayDefinition.anInt3645 = class302.method3519("name_icons", (byte)103);
      Class320_Sub3.anInt8225 = class302.method3519("floorshadows", (byte)100);
      Node_Sub38_Sub32.anInt10436 = class302.method3519("compass", (byte)61);
      Class153.anInt1943 = class302.method3519("otherlevel", (byte)34);
      CacheNode_Sub18.anInt9603 = class302.method3519("hint_mapedge", (byte)20);
   }

   static int method2590(int i, int i_23_) {
      return i | i_23_;
   }

   static final int method2591(byte b, char c) {
      if (b != -115) {
         return -13;
      } else {
         ++anInt7134;
         return ~c <= -1 && ~Class346.anIntArray4275.length < ~c ? Class346.anIntArray4275[c] : -1;
      }
   }

   public static void method2592(int i) {
      aClass312_7139 = null;
      if (i == -127) {
         aClass124_7132 = null;
      }
   }

   static final boolean method2593(
      int i, int i_24_, int i_25_, int i_26_, int i_27_, int i_28_, int i_29_, int i_30_, boolean bool, int i_31_, Class84 class84
   ) {
      ++anInt7130;
      int i_32_ = i_24_;
      int i_33_ = i_31_;
      int i_34_ = 64;
      int i_35_ = 64;
      int i_36_ = -i_34_ + i_24_;
      int i_37_ = i_31_ + -i_35_;
      Node_Sub36_Sub2.anIntArrayArray10047[i_34_][i_35_] = 99;
      Class262_Sub23.anIntArrayArray7892[i_34_][i_35_] = 0;
      int i_38_ = 0;
      Node_Sub39.routeFinderXArray[i_38_] = i_24_;
      int i_39_ = 0;
      if (bool) {
         method2589(null, 37);
      }

      Class339_Sub6.routeFinderYArray[i_38_++] = i_31_;
      int[][] is = class84.clipMasks;

      while(~i_38_ != ~i_39_) {
         i_33_ = Class339_Sub6.routeFinderYArray[i_39_];
         i_32_ = Node_Sub39.routeFinderXArray[i_39_];
         i_35_ = i_33_ - i_37_;
         i_34_ = i_32_ + -i_36_;
         i_39_ = 4095 & 1 + i_39_;
         int i_40_ = -class84.anInt1139 + i_32_;
         int i_41_ = -class84.anInt1135 + i_33_;
         if (~i_28_ != 3) {
            if (~i_28_ != 2) {
               if (i_28_ != -2) {
                  if (~i_28_ != 0) {
                     if (i_28_ != 0 && ~i_28_ != -2 && ~i_28_ != -3 && ~i_28_ != -4 && i_28_ != 9) {
                        if (class84.method982(i_32_, 25451, i_28_, i_26_, i_30_, i_27_, i_33_, 2)) {
                           Class219.anInt2623 = i_33_;
                           Class315.anInt4033 = i_32_;
                           return true;
                        }
                     } else if (class84.method989(2, i_28_, i_30_, i_33_, i_32_, i_26_, i_27_, 2883842)) {
                        Class315.anInt4033 = i_32_;
                        Class219.anInt2623 = i_33_;
                        return true;
                     }
                  } else if (class84.method988(i_30_, -7734, i, i_26_, i_32_, 2, i_25_, i_29_, i_33_)) {
                     Class219.anInt2623 = i_33_;
                     Class315.anInt4033 = i_32_;
                     return true;
                  }
               } else if (class84.method984(2, i_30_, (byte)-78, 2, i_32_, i_26_, i, i_25_, i_33_, i_29_)) {
                  Class219.anInt2623 = i_33_;
                  Class315.anInt4033 = i_32_;
                  return true;
               }
            } else if (Class150_Sub2.method1659(i_26_, 2, i_32_, -98, i_29_, i_25_, i_33_, i_30_, 2)) {
               Class219.anInt2623 = i_33_;
               Class315.anInt4033 = i_32_;
               return true;
            }
         } else if (~i_26_ == ~i_32_ && i_33_ == i_30_) {
            Class315.anInt4033 = i_32_;
            Class219.anInt2623 = i_33_;
            return true;
         }

         int i_42_ = Class262_Sub23.anIntArrayArray7892[i_34_][i_35_] + 1;
         if (~i_34_ < -1
            && Node_Sub36_Sub2.anIntArrayArray10047[-1 + i_34_][i_35_] == 0
            && (1134821376 & is[-1 + i_40_][i_41_]) == 0
            && ~(is[i_40_ + -1][1 + i_41_] & 1310982144) == -1) {
            Node_Sub39.routeFinderXArray[i_38_] = -1 + i_32_;
            Class339_Sub6.routeFinderYArray[i_38_] = i_33_;
            i_38_ = 1 + i_38_ & 4095;
            Node_Sub36_Sub2.anIntArrayArray10047[-1 + i_34_][i_35_] = 2;
            Class262_Sub23.anIntArrayArray7892[i_34_ + -1][i_35_] = i_42_;
         }

         if (~i_34_ > -127
            && Node_Sub36_Sub2.anIntArrayArray10047[1 + i_34_][i_35_] == 0
            && ~(1625554944 & is[2 + i_40_][i_41_]) == -1
            && (2015625216 & is[2 + i_40_][i_41_ + 1]) == 0) {
            Node_Sub39.routeFinderXArray[i_38_] = 1 + i_32_;
            Class339_Sub6.routeFinderYArray[i_38_] = i_33_;
            Node_Sub36_Sub2.anIntArrayArray10047[1 + i_34_][i_35_] = 8;
            i_38_ = i_38_ - -1 & 4095;
            Class262_Sub23.anIntArrayArray7892[i_34_ - -1][i_35_] = i_42_;
         }

         if (i_35_ > 0
            && ~Node_Sub36_Sub2.anIntArrayArray10047[i_34_][-1 + i_35_] == -1
            && (is[i_40_][-1 + i_41_] & 1134821376) == 0
            && (1625554944 & is[1 + i_40_][-1 + i_41_]) == 0) {
            Node_Sub39.routeFinderXArray[i_38_] = i_32_;
            Class339_Sub6.routeFinderYArray[i_38_] = -1 + i_33_;
            Node_Sub36_Sub2.anIntArrayArray10047[i_34_][-1 + i_35_] = 1;
            i_38_ = 1 + i_38_ & 4095;
            Class262_Sub23.anIntArrayArray7892[i_34_][i_35_ - 1] = i_42_;
         }

         if (~i_35_ > -127
            && ~Node_Sub36_Sub2.anIntArrayArray10047[i_34_][i_35_ - -1] == -1
            && ~(is[i_40_][i_41_ - -2] & 1310982144) == -1
            && (is[1 + i_40_][2 + i_41_] & 2015625216) == 0) {
            Node_Sub39.routeFinderXArray[i_38_] = i_32_;
            Class339_Sub6.routeFinderYArray[i_38_] = i_33_ + 1;
            i_38_ = i_38_ - -1 & 4095;
            Node_Sub36_Sub2.anIntArrayArray10047[i_34_][1 + i_35_] = 4;
            Class262_Sub23.anIntArrayArray7892[i_34_][i_35_ + 1] = i_42_;
         }

         if (i_34_ > 0
            && i_35_ > 0
            && Node_Sub36_Sub2.anIntArrayArray10047[-1 + i_34_][-1 + i_35_] == 0
            && ~(1336147968 & is[-1 + i_40_][i_41_]) == -1
            && (1134821376 & is[i_40_ - 1][i_41_ + -1]) == 0
            && (is[i_40_][i_41_ - 1] & 1675886592) == 0) {
            Node_Sub39.routeFinderXArray[i_38_] = i_32_ - 1;
            Class339_Sub6.routeFinderYArray[i_38_] = i_33_ + -1;
            i_38_ = 4095 & 1 + i_38_;
            Node_Sub36_Sub2.anIntArrayArray10047[-1 + i_34_][-1 + i_35_] = 3;
            Class262_Sub23.anIntArrayArray7892[-1 + i_34_][i_35_ - 1] = i_42_;
         }

         if (~i_34_ > -127
            && i_35_ > 0
            && Node_Sub36_Sub2.anIntArrayArray10047[i_34_ - -1][i_35_ + -1] == 0
            && (is[i_40_ - -1][-1 + i_41_] & 1675886592) == 0
            && ~(is[2 + i_40_][i_41_ - 1] & 1625554944) == -1
            && (is[i_40_ + 2][i_41_] & 2028208128) == 0) {
            Node_Sub39.routeFinderXArray[i_38_] = i_32_ - -1;
            Class339_Sub6.routeFinderYArray[i_38_] = -1 + i_33_;
            i_38_ = 4095 & i_38_ - -1;
            Node_Sub36_Sub2.anIntArrayArray10047[i_34_ - -1][i_35_ - 1] = 9;
            Class262_Sub23.anIntArrayArray7892[1 + i_34_][-1 + i_35_] = i_42_;
         }

         if (~i_34_ < -1
            && i_35_ < 126
            && ~Node_Sub36_Sub2.anIntArrayArray10047[i_34_ + -1][1 + i_35_] == -1
            && ~(is[-1 + i_40_][i_41_ + 1] & 1336147968) == -1
            && ~(is[-1 + i_40_][i_41_ + 2] & 1310982144) == -1
            && (2116288512 & is[i_40_][2 + i_41_]) == 0) {
            Node_Sub39.routeFinderXArray[i_38_] = -1 + i_32_;
            Class339_Sub6.routeFinderYArray[i_38_] = i_33_ + 1;
            i_38_ = 4095 & i_38_ + 1;
            Node_Sub36_Sub2.anIntArrayArray10047[i_34_ + -1][1 + i_35_] = 6;
            Class262_Sub23.anIntArrayArray7892[i_34_ - 1][i_35_ + 1] = i_42_;
         }

         if (i_34_ < 126
            && i_35_ < 126
            && ~Node_Sub36_Sub2.anIntArrayArray10047[1 + i_34_][i_35_ - -1] == -1
            && (is[1 + i_40_][2 + i_41_] & 2116288512) == 0
            && ~(is[i_40_ - -2][i_41_ - -2] & 2015625216) == -1
            && (is[i_40_ + 2][1 + i_41_] & 2028208128) == 0) {
            Node_Sub39.routeFinderXArray[i_38_] = i_32_ - -1;
            Class339_Sub6.routeFinderYArray[i_38_] = i_33_ - -1;
            Node_Sub36_Sub2.anIntArrayArray10047[i_34_ + 1][1 + i_35_] = 12;
            i_38_ = 1 + i_38_ & 4095;
            Class262_Sub23.anIntArrayArray7892[1 + i_34_][i_35_ + 1] = i_42_;
         }
      }

      Class219.anInt2623 = i_33_;
      Class315.anInt4033 = i_32_;
      return false;
   }

   static final boolean method2594(boolean bool) {
      ++anInt7135;
      if (Class52.aCacheNode_Sub13_788 == null) {
         return false;
      } else {
         if (~Class52.aCacheNode_Sub13_788.anInt9562 <= -2001) {
            Class52.aCacheNode_Sub13_788.anInt9562 -= 2000;
         }

         if (!bool) {
            method2589(null, -33);
         }

         return Class52.aCacheNode_Sub13_788.anInt9562 == 1002;
      }
   }
}
