public class Node_Sub41 extends Node {
   static Class129 aClass129_7515 = new Class129("RC", 1);
   static int anInt7516;
   static int anInt7517;
   protected Npc aNpc7518;
   static Class114 aClass114_7519 = new Class114(8);

   public static void method2930(int i) {
      if (i == 17334) {
         aClass114_7519 = null;
         aClass129_7515 = null;
      }
   }

   static final int autoSetupGraphics(byte b) {
      ++anInt7516;
      boolean bool = false;
      boolean bool_0_ = false;
      boolean bool_1_ = false;
      if (Class240.aSignLink2946.aBoolean4005 && !Class240.aSignLink2946.aBoolean3985) {
         bool = true;
         if (Node_Sub23.aNode_Sub39_7201.anInt7484 < 512 && ~Node_Sub23.aNode_Sub39_7201.anInt7484 != -1) {
            bool = false;
         }

         if (SignLink.aString3981.startsWith("win")) {
            bool_1_ = true;
            bool_0_ = true;
         } else {
            bool_0_ = true;
         }
      }

      if (Class370.aBoolean4570) {
         bool_0_ = false;
      }

      if (Class270_Sub2_Sub1.aBoolean10549) {
         bool_1_ = false;
      }

      if (Class243.aBoolean3075) {
         bool = false;
      }

      if (!bool && !bool_0_ && !bool_1_) {
         return Class332.method3844(-97);
      } else {
         int i = -29 % ((-43 - b) / 57);
         int i_2_ = -1;
         int i_3_ = -1;
         int i_4_ = -1;
         if (bool) {
            try {
               i_2_ = Class194.method1961(1000, 2, 13968);
            } catch (Exception var14) {
            }
         }

         if (bool_1_) {
            try {
               i_4_ = Class194.method1961(1000, 3, 13968);
               if (~Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false) == -4) {
                  Renderer renderer = Class93.aGraphicsToolkit1241.c();
                  long l = renderer.aLong3661 & 281474976710655L;
                  int i_5_ = renderer.anInt3656;
                  if (~i_5_ != -4319) {
                     if (i_5_ == 4098) {
                        bool_0_ &= ~l <= -60129613780L;
                     }
                  } else {
                     bool_0_ &= l >= 64425238954L;
                  }
               }
            } catch (Exception var13) {
            }
         }

         if (bool_0_) {
            try {
               i_3_ = Class194.method1961(1000, 1, 13968);
            } catch (Exception var12) {
            }
         }

         if (~i_2_ == 0 && i_3_ == -1 && ~i_4_ == 0) {
            return Class332.method3844(-97);
         } else {
            i_3_ = (int)((float)i_3_ * 1.1F);
            i_4_ = (int)((float)i_4_ * 1.1F);
            if (~i_2_ < ~i_4_ && i_2_ > i_3_) {
               return Class339_Sub8.method3945(false, i_2_);
            } else {
               return ~i_4_ < ~i_3_ ? Canvas.method125(3, i_4_, (byte)-45) : Canvas.method125(1, i_3_, (byte)-45);
            }
         }
      }
   }

   Node_Sub41(Npc npc) {
      this.aNpc7518 = npc;
   }

   static final boolean method2932(int i, int i_6_, int i_7_) {
      ++anInt7517;
      if (i > -59) {
         method2932(111, -62, 11);
      }

      if (!WorldmapAreaDetail.method2336(-1, i_7_, i_6_)) {
         return false;
      } else {
         return Class46.method470(i_7_, -77, i_6_) | ~(36864 & i_6_) != -1 | Class234.method2150(i_7_, 256, i_6_)
            ? true
            : ~(55 & i_7_) == -1 & (Class278.method3367(i_7_, i_6_, (byte)-119) | ~(8192 & i_6_) != -1 | Class320_Sub9.method3713(122, i_6_, i_7_));
      }
   }
}
