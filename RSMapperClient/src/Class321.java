public class Class321 {
   static int anInt4066;
   static int[] anIntArray4067 = new int[16];
   static long aLong4068 = 0L;
   static int anInt4069;
   static int anInt4070;

   static final void method3799(long l, int i) {
      ++anInt4066;
      int i_0_ = Class295.myPlayer.x - -Class262_Sub17.anInt7839;
      int i_1_ = Class295.myPlayer.y - -Class76.anInt1011;
      if (~(-i_0_ + Mobile_Sub4.playerPositionX) > 1999
         || -i_0_ + Mobile_Sub4.playerPositionX > 2000
         || ~(-i_1_ + Class25.playerPositionY) > 1999
         || ~(Class25.playerPositionY - i_1_) < -2001) {
         Class25.playerPositionY = i_1_;
         Mobile_Sub4.playerPositionX = i_0_;
      }

      if (~i_0_ != ~Mobile_Sub4.playerPositionX) {
         int i_2_ = -Mobile_Sub4.playerPositionX + i_0_;
         int i_3_ = (int)(l * (long)i_2_ / 320L);
         if (i_2_ <= 0) {
            if (~i_3_ != -1) {
               if (~i_3_ > ~i_2_) {
                  i_3_ = i_2_;
               }
            } else {
               i_3_ = -1;
            }
         } else if (i_3_ != 0) {
            if (~i_2_ > ~i_3_) {
               i_3_ = i_2_;
            }
         } else {
            i_3_ = 1;
         }

         Mobile_Sub4.playerPositionX += i_3_;
      }

      if (i_1_ != Class25.playerPositionY) {
         int i_4_ = i_1_ + -Class25.playerPositionY;
         int i_5_ = (int)((long)i_4_ * l / 320L);
         if (i_4_ > 0) {
            if (~i_5_ == -1) {
               i_5_ = 1;
            } else if (i_5_ > i_4_) {
               i_5_ = i_4_;
            }
         } else if (~i_5_ != -1) {
            if (i_4_ > i_5_) {
               i_5_ = i_4_;
            }
         } else {
            i_5_ = -1;
         }

         Class25.playerPositionY += i_5_;
      }

      Class257.cameraRotationVertical += Node_Sub36_Sub1.cameraRotationVerticalIncrement * Node_Sub36_Sub1.cameraRotationVerticalMultiplier * (float)l / 6.0F;
      Node_Sub12.cameraRotationHorizontal += (float)l * Class291.cameraRotationHorizontalIncrement * Class291.cameraRotationHorizontalMultiplier / 6.0F;
      Class169_Sub4.method1787((byte)12);
      if (i != 320) {
         anIntArray4067 = null;
      }
   }

   static final boolean method3800(int i, int i_6_, int i_7_) {
      if (i_7_ != 126) {
         method3799(64L, -95);
      }

      ++anInt4070;
      return (i & 52) != 0;
   }

   static final boolean method3801(byte b, char c) {
      ++anInt4069;
      if (c >= ' ' && c <= '~') {
         return true;
      } else {
         if (b <= 100) {
            anIntArray4067 = null;
         }

         if (~c <= -161 && ~c >= -256) {
            return true;
         } else {
            return ~c == -8365 || ~c == -339 || ~c == -8213 || c == 339 || c == 376;
         }
      }
   }

   public static void method3802(int i) {
      if (i != 1999) {
         aLong4068 = 76L;
      }

      anIntArray4067 = null;
   }
}
