import jaggl.OpenGL;

public class Class339_Sub1 extends Class339 {
   private Class169_Sub1[] aClass169_Sub1Array8627;
   static int anInt8628;
   static int anInt8629;
   static int anInt8630;
   static String[] aStringArray8631;
   static int anInt8632;
   private boolean aBoolean8633;
   static int anInt8634;
   private Class25 aClass25_8635;
   static int anInt8636;
   private boolean aBoolean8637 = false;
   static int anInt8638;
   static int anInt8639;

   @Override
   final boolean method3922(byte b) {
      if (b > -44) {
         this.aClass169_Sub1Array8627 = null;
      }

      ++anInt8639;
      return true;
   }

   @Override
   final void method3919(int i, int i_0_, int i_1_) {
      if (i != -13437) {
         this.method3917(null, -28, -126);
      }

      if (this.aBoolean8637) {
         this.aGLToolkit4202.method1457(33984, 1);
         this.aGLToolkit4202.method1444(-2, this.aClass169_Sub1Array8627[i_1_ + -1]);
         this.aGLToolkit4202.method1457(33984, 0);
      }

      ++anInt8636;
   }

   @Override
   final void method3918(int i) {
      ++anInt8630;
      if (i != 20937) {
         method3926(72);
      }

      if (!this.aBoolean8637) {
         this.aGLToolkit4202.method1472(-96, 0, 770, 5890);
      } else {
         if (!this.aBoolean8633) {
            this.aGLToolkit4202.method1457(33984, 2);
            this.aGLToolkit4202.method1444(-2, null);
         }

         this.aGLToolkit4202.method1457(33984, 1);
         this.aGLToolkit4202.method1444(-2, null);
         this.aGLToolkit4202.method1457(i + 13047, 0);
         this.aClass25_8635.method310('\u0001', (byte)-116);
         this.aBoolean8637 = false;
      }

      this.aGLToolkit4202.method1474(126, 8448, 8448);
   }

   @Override
   final void method3917(Class169 class169, int i, int i_2_) {
      this.aGLToolkit4202.method1444(-2, class169);
      if (i_2_ != -28289) {
         this.aClass25_8635 = null;
      }

      ++anInt8638;
      this.aGLToolkit4202.method1434((byte)55, i);
   }

   private final void method3924(byte b) {
      this.aClass25_8635 = new Class25(this.aGLToolkit4202, 2);
      ++anInt8634;
      if (b != 57) {
         this.method3922((byte)-52);
      }

      this.aClass25_8635.method307(0, b + 4807);
      this.aGLToolkit4202.method1457(33984, 1);
      OpenGL.glTexGeni(8192, 9472, 34065);
      OpenGL.glTexGeni(8193, 9472, 34065);
      OpenGL.glTexGeni(8194, 9472, 34065);
      OpenGL.glEnable(3168);
      OpenGL.glEnable(3169);
      OpenGL.glEnable(3170);
      OpenGL.glMatrixMode(5890);
      OpenGL.glLoadIdentity();
      OpenGL.glRotatef(22.5F, 1.0F, 0.0F, 0.0F);
      OpenGL.glMatrixMode(5888);
      if (!this.aBoolean8633) {
         this.aGLToolkit4202.method1474(126, 8448, 7681);
         this.aGLToolkit4202.method1464(34168, 768, 0, (byte)-51);
         this.aGLToolkit4202.method1457(b ^ '\u84F9', 2);
         this.aGLToolkit4202.method1474(-83, 7681, 260);
         this.aGLToolkit4202.method1464(34168, 768, 0, (byte)-51);
         this.aGLToolkit4202.method1464(34168, 770, 1, (byte)-51);
         this.aGLToolkit4202.method1472(-32, 0, 770, 34167);
      } else {
         this.aGLToolkit4202.method1474(126, 7681, 260);
         this.aGLToolkit4202.method1464(5890, 770, 0, (byte)-51);
         this.aGLToolkit4202.method1472(-103, 0, 770, 34167);
      }

      this.aGLToolkit4202.method1457(b ^ '\u84F9', 0);
      this.aClass25_8635.method309(false);
      this.aClass25_8635.method307(1, 4864);
      this.aGLToolkit4202.method1457(33984, 1);
      OpenGL.glDisable(3168);
      OpenGL.glDisable(3169);
      OpenGL.glDisable(3170);
      OpenGL.glMatrixMode(5890);
      OpenGL.glLoadIdentity();
      OpenGL.glMatrixMode(5888);
      if (!this.aBoolean8633) {
         this.aGLToolkit4202.method1474(b ^ -60, 8448, 8448);
         this.aGLToolkit4202.method1464(5890, 768, 0, (byte)-51);
         this.aGLToolkit4202.method1457(b ^ '\u84F9', 2);
         this.aGLToolkit4202.method1474(127, 8448, 8448);
         this.aGLToolkit4202.method1464(5890, 768, 0, (byte)-51);
         this.aGLToolkit4202.method1464(34168, 768, 1, (byte)-51);
         this.aGLToolkit4202.method1472(-36, 0, 770, 5890);
      } else {
         this.aGLToolkit4202.method1474(-49, 8448, 8448);
         this.aGLToolkit4202.method1464(5890, 768, 0, (byte)-51);
         this.aGLToolkit4202.method1472(-44, 0, 770, 5890);
      }

      this.aGLToolkit4202.method1457(b + '\u8487', 0);
      this.aClass25_8635.method309(false);
   }

   @Override
   final void method3920(int i, boolean bool) {
      if (i == -1) {
         this.aGLToolkit4202.method1474(127, 7681, 8448);
         ++anInt8632;
      }
   }

   Class339_Sub1(GLToolkit gltoolkit) {
      super(gltoolkit);
      if (gltoolkit.aBoolean6654) {
         this.aBoolean8633 = gltoolkit.anInt6680 < 3;
         int i = !this.aBoolean8633 ? 127 : 48;
         byte[][] bs = new byte[6][4096];
         byte[][] bs_3_ = new byte[6][4096];
         byte[][] bs_4_ = new byte[6][4096];
         int i_5_ = 0;

         for(int i_6_ = 0; ~i_6_ > -65; ++i_6_) {
            for(int i_7_ = 0; ~i_7_ > -65; ++i_7_) {
               float f = (float)i_6_ * 2.0F / 64.0F - 1.0F;
               float f_8_ = -1.0F + (float)i_7_ * 2.0F / 64.0F;
               float f_9_ = (float)(1.0 / Math.sqrt((double)(f_8_ * f_8_ + 1.0F + f * f)));
               f *= f_9_;
               f_8_ *= f_9_;

               for(int i_10_ = 0; i_10_ < 6; ++i_10_) {
                  float f_11_;
                  if (~i_10_ != -1) {
                     if (i_10_ != 1) {
                        if (i_10_ != 2) {
                           if (~i_10_ == -4) {
                              f_11_ = -f;
                           } else if (i_10_ == 4) {
                              f_11_ = f_9_;
                           } else {
                              f_11_ = -f_9_;
                           }
                        } else {
                           f_11_ = f;
                        }
                     } else {
                        f_11_ = f_8_;
                     }
                  } else {
                     f_11_ = -f_8_;
                  }

                  int i_12_;
                  int i_13_;
                  int i_14_;
                  if (f_11_ <= 0.0F) {
                     i_14_ = 0;
                     i_13_ = 0;
                     i_12_ = 0;
                  } else {
                     i_12_ = (int)(Math.pow((double)f_11_, 96.0) * (double)i);
                     i_13_ = (int)((double)i * Math.pow((double)f_11_, 36.0));
                     i_14_ = (int)((double)i * Math.pow((double)f_11_, 12.0));
                  }

                  bs_3_[i_10_][i_5_] = (byte)i_12_;
                  bs_4_[i_10_][i_5_] = (byte)i_13_;
                  bs[i_10_][i_5_] = (byte)i_14_;
               }

               ++i_5_;
            }
         }

         this.aClass169_Sub1Array8627 = new Class169_Sub1[3];
         this.aClass169_Sub1Array8627[0] = new Class169_Sub1(this.aGLToolkit4202, 6406, 64, false, bs_3_, 6406);
         this.aClass169_Sub1Array8627[1] = new Class169_Sub1(this.aGLToolkit4202, 6406, 64, false, bs_4_, 6406);
         this.aClass169_Sub1Array8627[2] = new Class169_Sub1(this.aGLToolkit4202, 6406, 64, false, bs, 6406);
         this.method3924((byte)57);
      }
   }

   static final int method3925(int i, int i_15_, int i_16_) {
      ++anInt8628;
      int i_17_ = Class270_Sub2_Sub1.method3306(i + 45365, (byte)91, 4, i_16_ + 91923)
         - (
            128
               - (Class270_Sub2_Sub1.method3306(i - -10294, (byte)91, 2, 37821 + i_16_) - 128 >> 1)
               + -(Class270_Sub2_Sub1.method3306(i, (byte)91, 1, i_16_) + -128 >> 2)
         );
      int i_18_ = -20 / ((i_15_ - 23) / 62);
      i_17_ = (int)(0.3 * (double)i_17_) - -35;
      if (i_17_ >= 10) {
         if (i_17_ > 60) {
            i_17_ = 60;
         }
      } else {
         i_17_ = 10;
      }

      return i_17_;
   }

   public static void method3926(int i) {
      if (i != -31657) {
         method3925(-68, 52, -87);
      }

      aStringArray8631 = null;
   }

   @Override
   final void method3923(boolean bool, int i) {
      ++anInt8629;
      if (this.aClass25_8635 != null && bool) {
         if (!this.aBoolean8633) {
            this.aGLToolkit4202.method1457(33984, 2);
            this.aGLToolkit4202.method1444(-2, this.aGLToolkit4202.aClass169_Sub2_6683);
            this.aGLToolkit4202.method1457(i + 33984, 0);
         }

         this.aClass25_8635.method310('\u0000', (byte)-77);
         this.aBoolean8637 = true;
      } else {
         this.aGLToolkit4202.method1472(i + -37, 0, 770, 34168);
      }

      if (i != 0) {
         this.aClass25_8635 = null;
      }
   }
}
