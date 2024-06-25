public class Class170 {
   protected int anInt2047;
   static int anInt2048;
   static int anInt2049;
   static int anInt2050;
   static OutgoingPacket aClass318_2051 = new OutgoingPacket(64, 8);
   static int anInt2052;
   static int anInt2053;
   static int[] anIntArray2054;
   static int anInt2055;
   static int anInt2056 = 0;

   static final void method1788() {
      for(int i = Class320_Sub12.anInt8327; i < Class159.anInt1995; ++i) {
         for(int i_0_ = 0; i_0_ < Class328.SCENE_WIDTH_X; ++i_0_) {
            for(int i_1_ = 0; i_1_ < Node_Sub50.SCENE_WIDTH_Y; ++i_1_) {
               Class261 class261 = Class175.aClass261ArrayArrayArray2099[i][i_0_][i_1_];
               if (class261 != null) {
                  Animable_Sub2 animable_sub2 = class261.anAnimable_Sub2_3314;
                  Animable_Sub2 animable_sub2_2_ = class261.anAnimable_Sub2_3308;
                  if (animable_sub2 != null && animable_sub2.method821(0)) {
                     Class336_Sub3.method3901(animable_sub2, i, i_0_, i_1_, 1, 1);
                     if (animable_sub2_2_ != null && animable_sub2_2_.method821(0)) {
                        Class336_Sub3.method3901(animable_sub2_2_, i, i_0_, i_1_, 1, 1);
                        animable_sub2_2_.method816(0, false, CacheNode_Sub18.aGraphicsToolkit9607, 0, (byte)126, 0, animable_sub2);
                        animable_sub2_2_.method811(27811);
                     }

                     animable_sub2.method811(27811);
                  }

                  for(Class256 class256 = class261.aClass256_3312; class256 != null; class256 = class256.aClass256_3238) {
                     Mobile mobile = class256.aMobile3239;
                     if (mobile != null && mobile.method821(0)) {
                        Class336_Sub3.method3901(mobile, i, i_0_, i_1_, mobile.aShort9130 - mobile.aShort9119 + 1, mobile.aShort9124 - mobile.aShort9120 + 1);
                        mobile.method811(27811);
                     }
                  }

                  Animable_Sub1 animable_sub1 = class261.anAnimable_Sub1_3317;
                  if (animable_sub1 != null && animable_sub1.method821(0)) {
                     Class134_Sub3.method1583(animable_sub1, i, i_0_, i_1_);
                     animable_sub1.method811(27811);
                  }
               }
            }
         }
      }
   }

   Class170(int i, int i_3_) {
      this.anInt2047 = i_3_;
   }

   static final void method1789(int junk) {
      ++anInt2050;
      int displaySetting = 0;
      if (Class213.aNode_Sub27_2512 != null) {
         displaySetting = Class213.aNode_Sub27_2512.aClass320_Sub18_7303.method3749(false);
      }

      if (junk >= -4) {
         anInt2056 = 0;
      }

      Class131.canvasOffsetY = 0;
      Class205.canvasHeight = CacheNode_Sub3.anInt9441;
      Class360.canvasWidth = Class36.anInt542;
      Class270_Sub1.canvasOffsetX = 0;
   }

   static final int method1790(int i, int i_9_, byte b, int i_10_, int i_11_, int i_12_) {
      ++anInt2049;
      if (b < 107) {
         method1791((byte)40);
      }

      if (Class320_Sub10.aPlaneArray8300 == null) {
         return 0;
      } else {
         if (~i_9_ > -4) {
            int i_13_ = i_12_ >> 9;
            int i_14_ = i >> 9;
            if (i_10_ < 0 || i_11_ < 0 || Node_Sub54.GAME_SCENE_WDITH + -1 < i_10_ || ~(-1 + Class377_Sub1.GAME_SCENE_HEIGHT) > ~i_11_) {
               return 0;
            }

            if (i_13_ < 1 || ~i_14_ > -2 || ~i_13_ < ~(Node_Sub54.GAME_SCENE_WDITH + -1) || i_14_ > -1 + Class377_Sub1.GAME_SCENE_HEIGHT) {
               return 0;
            }

            boolean bool = ~(Class277.tileFlags[1][i_12_ >> 9][i >> 9] & 2) != -1;
            if ((511 & i_12_) == 0) {
               boolean bool_15_ = ~(2 & Class277.tileFlags[1][-1 + i_13_][i >> 9]) != -1;
               boolean bool_16_ = (Class277.tileFlags[1][i_13_][i >> 9] & 2) != 0;
               if (bool_15_ == !bool_16_) {
                  bool = (2 & Class277.tileFlags[1][i_10_][i_11_]) != 0;
               }
            }

            if (~(511 & i) == -1) {
               boolean bool_17_ = ~(2 & Class277.tileFlags[1][i_12_ >> 9][i_14_ + -1]) != -1;
               boolean bool_18_ = (Class277.tileFlags[1][i_12_ >> 9][i_14_] & 2) != 0;
               if (!bool_18_ != !bool_17_) {
                  bool = (2 & Class277.tileFlags[1][i_10_][i_11_]) != 0;
               }
            }

            if (bool) {
               ++i_9_;
            }
         }

         return Class320_Sub10.aPlaneArray8300[i_9_].getMedianHeightFromVertices(i, -119, i_12_);
      }
   }

   @Override
   public final String toString() {
      ++anInt2048;
      throw new IllegalStateException();
   }

   public static void method1791(byte b) {
      aClass318_2051 = null;
      anIntArray2054 = null;
      int i = -10 / ((b - -71) / 54);
   }
}
