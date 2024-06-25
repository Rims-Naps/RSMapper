public class Class145 {
   static int anInt1792;
   static int anInt1793;
   static int anInt1794;
   protected long aLong1795;
   static int anInt1796;
   private GLToolkit aGLToolkit1797;
   static IncommingPacket aClass192_1798 = new IncommingPacket(6, -2);
   static Index aClass302_1799;

   static final int method1638(int i, String string, int i_0_, boolean bool) {
      ++anInt1796;
      if (i_0_ >= 2 && ~i_0_ >= -37) {
         boolean bool_1_ = false;
         boolean bool_2_ = false;
         if (i != 21642) {
            return 35;
         } else {
            int i_3_ = 0;
            int i_4_ = string.length();

            for(int i_5_ = 0; i_4_ > i_5_; ++i_5_) {
               int i_6_ = string.charAt(i_5_);
               if (~i_5_ == -1) {
                  if (~i_6_ == -46) {
                     bool_1_ = true;
                     continue;
                  }

                  if (i_6_ == 43 && bool) {
                     continue;
                  }
               }

               if (i_6_ >= 48 && i_6_ <= 57) {
                  i_6_ -= 48;
               } else if (i_6_ >= 65 && i_6_ <= 90) {
                  i_6_ -= 55;
               } else {
                  if (~i_6_ > -98 || i_6_ > 122) {
                     throw new NumberFormatException();
                  }

                  i_6_ -= 87;
               }

               if (~i_6_ <= ~i_0_) {
                  throw new NumberFormatException();
               }

               if (bool_1_) {
                  i_6_ = -i_6_;
               }

               int i_7_ = i_6_ + i_0_ * i_3_;
               if (i_3_ != i_7_ / i_0_) {
                  throw new NumberFormatException();
               }

               bool_2_ = true;
               i_3_ = i_7_;
            }

            if (!bool_2_) {
               throw new NumberFormatException();
            } else {
               return i_3_;
            }
         }
      } else {
         throw new IllegalArgumentException("Invalid radix:" + i_0_);
      }
   }

   Class145(GLToolkit gltoolkit, long l, Class210[] class210s) {
      this.aLong1795 = l;
      this.aGLToolkit1797 = gltoolkit;
   }

   static final void method1639(boolean bool) {
      ++anInt1794;
      if (!bool) {
         aClass192_1798 = null;
      }

      Class258.aClass335_5293.method3852((byte)120);
   }

   public static void method1640(byte b) {
      if (b > -8) {
         method1638(-111, null, -48, true);
      }

      aClass302_1799 = null;
      aClass192_1798 = null;
   }

   @Override
   protected final void finalize() throws Throwable {
      ++anInt1793;
      this.aGLToolkit1797.method1485(this.aLong1795, 1015629296);
      super.finalize();
   }

   static final void method1641(
      int type,
      int endYPositionUnshifted,
      int startXPositionUnshifted,
      int startHeight,
      int startYPositionUnshifted,
      int endHeight,
      byte b,
      int i_13_,
      int endXPositionUnshifted
   ) {
      ++anInt1792;
   }

   static final void drawRectangleOnMap() {
   }
}
