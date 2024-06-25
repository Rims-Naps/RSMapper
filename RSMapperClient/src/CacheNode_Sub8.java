public class CacheNode_Sub8 extends CacheNode {
   protected short[][] aShortArrayArray9491;
   static int anInt9493 = -1;
   static int anInt9492 = -1;
   static int anInt9494 = -1;
   protected double aDouble9495;

   static final void method2318(int i, int i_0_, byte b, long l, aa var_aa, int i_1_, int i_2_, int i_3_, IComponentDefinitions widget) {
      if (b == 124) {
         int i_4_ = i_3_ * i_3_ + i * i;
         if ((long)i_4_ <= l) {
            int i_5_ = Math.min(widget.width / 2, widget.height / 2);
            if (i_4_ <= i_5_ * i_5_) {
               Class4.positionMinimapAreaSprites((byte)-116, i_2_, var_aa, Class101.aGLSpriteArray1301[i_1_], i_3_, i, widget, i_0_);
            } else {
               i_5_ -= 10;
               int i_6_;
               if (Class320_Sub22.anInt8415 == 4) {
                  i_6_ = (int)Node_Sub12.cameraRotationHorizontal & 16383;
               } else {
                  i_6_ = Mobile_Sub1.anInt10960 + (int)Node_Sub12.cameraRotationHorizontal & 16383;
               }

               int i_7_ = Class335.anIntArray4167[i_6_];
               int i_8_ = Class335.anIntArray4165[i_6_];
               if (Class320_Sub22.anInt8415 != 4) {
                  i_8_ = i_8_ * 256 / (Node_Sub15_Sub13.anInt9870 + 256);
                  i_7_ = i_7_ * 256 / (Node_Sub15_Sub13.anInt9870 + 256);
               }

               int i_9_ = i_8_ * i + i_7_ * i_3_ >> 14;
               int i_10_ = -(i * i_7_) + i_8_ * i_3_ >> 14;
               double d = Math.atan2((double)i_9_, (double)i_10_);
               int i_11_ = (int)((double)i_5_ * Math.sin(d));
               int i_12_ = (int)((double)i_5_ * Math.cos(d));
               Class150_Sub3.aGLSpriteArray8973[i_1_]
                  .method1180(
                     (float)i_11_ + (float)widget.width / 2.0F + (float)i_0_,
                     (float)(-i_12_) + (float)widget.height / 2.0F + (float)i_2_,
                     4096,
                     (int)(-d / (Math.PI * 2) * 65535.0)
                  );
            }
         }
      }
   }

   final long method2319(boolean bool) {
      return bool ? -33L : (long)(this.aShortArrayArray9491.length << 0 | this.aShortArrayArray9491[0].length);
   }

   static final Animable_Sub4 method2320(int i, int i_13_, int i_14_) {
      Class261 class261 = Class175.aClass261ArrayArrayArray2099[i][i_13_][i_14_];
      return class261 == null ? null : class261.anAnimable_Sub4_3315;
   }

   CacheNode_Sub8(short[][] ses, double d) {
      this.aDouble9495 = d;
      this.aShortArrayArray9491 = ses;
   }
}
