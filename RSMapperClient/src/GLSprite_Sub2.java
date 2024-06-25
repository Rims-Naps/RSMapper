abstract class GLSprite_Sub2 extends GLSprite {
   static int anInt8881;
   static int anInt8882;
   static int anInt8883;
   protected int anInt8884;
   protected int anInt8885;
   protected PureJavaToolkit aPureJavaToolkit8886;
   private static int anInt8887 = 0;
   static int anInt8888;
   protected int anInt8889;
   static int anInt8890 = 0;
   private static int anInt8891 = 0;
   private static int anInt8892;
   protected int anInt8893;
   static int anInt8894;
   static int anInt8895 = 0;
   static int anInt8896 = 0;
   protected int anInt8897;
   private static int anInt8898;
   protected int anInt8899;
   static int anInt8900;
   static int anInt8901;
   static int anInt8902;
   static int anInt8903 = 0;
   static int anInt8904;
   private static int anInt8905;
   static int anInt8906 = 0;
   static int anInt8907;
   static int anInt8908;
   static int anInt8909;
   static int anInt8910 = 0;
   private int[] anIntArray8911;
   private static int anInt8912;
   static int anInt8913;

   @Override
   final int method1186() {
      return this.anInt8899 + this.anInt8897 + this.anInt8884;
   }

   @Override
   abstract void method1189(int var1, int var2, aa var3, int var4, int var5);

   @Override
   final void method1187(int[] is) {
      is[0] = this.anInt8889;
      is[1] = this.anInt8899;
      is[2] = this.anInt8885;
      is[3] = this.anInt8884;
   }

   @Override
   final int method1176() {
      return this.anInt8897;
   }

   @Override
   abstract void method1184(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8);

   abstract void method1207(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9);

   abstract void method1208(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9);

   @Override
   final int method1193() {
      return this.anInt8893;
   }

   @Override
   final void method1188(float f, float f_26_, float f_27_, float f_28_, float f_29_, float f_30_, int i, aa var_aa, int i_31_, int i_32_) {
      if (this.aPureJavaToolkit8886.method1492()) {
         throw new IllegalStateException();
      } else {
         if (this.method1211(f, f_26_, f_27_, f_28_, f_29_, f_30_)) {
            aa_Sub1 var_aa_Sub1 = (aa_Sub1)var_aa;
            this.method1210(var_aa_Sub1.anIntArray5487, var_aa_Sub1.anIntArray5488, anInt8892 - i_31_, -i_32_ - (anInt8888 - anInt8905));
         }
      }
   }

   @Override
   final void method1194(float f, float f_33_, float f_34_, float f_35_, float f_36_, float f_37_, int i, int i_38_, int i_39_, int i_40_) {
      if (this.aPureJavaToolkit8886.method1492()) {
         throw new IllegalStateException();
      } else {
         if (this.method1211(f, f_33_, f_34_, f_35_, f_36_, f_37_)) {
            anInt8904 = i_38_;
            if (i != 1) {
               anInt8895 = i_38_ >>> 24;
               anInt8903 = 256 - anInt8895;
               if (i == 0) {
                  anInt8910 = (i_38_ & 0xFF0000) >> 16;
                  anInt8890 = (i_38_ & 0xFF00) >> 8;
                  anInt8906 = i_38_ & 0xFF;
               } else if (i == 2) {
                  anInt8887 = i_38_ >>> 24;
                  anInt8891 = 256 - anInt8887;
                  int i_41_ = (i_38_ & 16711935) * anInt8891 & -16711936;
                  int i_42_ = (i_38_ & 0xFF00) * anInt8891 & 0xFF0000;
                  anInt8896 = (i_41_ | i_42_) >>> 8;
               }
            }

            if (i == 1) {
               if (i_39_ == 0) {
                  this.method1209(1, 0);
               } else if (i_39_ == 1) {
                  this.method1209(1, 1);
               } else if (i_39_ == 2) {
                  this.method1209(1, 2);
               }
            } else if (i == 0) {
               if (i_39_ == 0) {
                  this.method1209(0, 0);
               } else if (i_39_ == 1) {
                  this.method1209(0, 1);
               } else if (i_39_ == 2) {
                  this.method1209(0, 2);
               }
            } else if (i == 3) {
               if (i_39_ == 0) {
                  this.method1209(3, 0);
               } else if (i_39_ == 1) {
                  this.method1209(3, 1);
               } else if (i_39_ == 2) {
                  this.method1209(3, 2);
               }
            } else if (i == 2) {
               if (i_39_ == 0) {
                  this.method1209(2, 0);
               } else if (i_39_ == 1) {
                  this.method1209(2, 1);
               } else if (i_39_ == 2) {
                  this.method1209(2, 2);
               }
            }
         }
      }
   }

   @Override
   final int method1197() {
      return this.anInt8889 + this.anInt8893 + this.anInt8885;
   }

   @Override
   final void method1178(int i, int i_43_, int i_44_, int i_45_) {
      this.anInt8889 = i;
      this.anInt8899 = i_43_;
      this.anInt8885 = i_44_;
      this.anInt8884 = i_45_;
   }

   @Override
   abstract void method1191(int var1, int var2, int var3, int var4, int var5);

   @Override
   final void method1183(int i, int i_50_, int i_51_, int i_52_, int i_53_, int i_54_, int i_55_) {
      if (this.aPureJavaToolkit8886.method1492()) {
         throw new IllegalStateException();
      } else {
         if (this.anIntArray8911 == null) {
            this.anIntArray8911 = new int[4];
         }

         this.aPureJavaToolkit8886.K(this.anIntArray8911);
         this.aPureJavaToolkit8886.T(this.aPureJavaToolkit8886.anInt6767, this.aPureJavaToolkit8886.anInt6760, i + i_51_, i_50_ + i_52_);
         int i_56_ = this.method1197();
         int i_57_ = this.method1186();
         int i_58_ = (i_51_ + i_56_ - 1) / i_56_;
         int i_59_ = (i_52_ + i_57_ - 1) / i_57_;

         for(int i_60_ = 0; i_60_ < i_59_; ++i_60_) {
            int i_61_ = i_60_ * i_57_;

            for(int i_62_ = 0; i_62_ < i_58_; ++i_62_) {
               this.method1191(i + i_62_ * i_56_, i_50_ + i_61_, i_53_, i_54_, i_55_);
            }
         }

         this.aPureJavaToolkit8886.KA(this.anIntArray8911[0], this.anIntArray8911[1], this.anIntArray8911[2], this.anIntArray8911[3]);
      }
   }

   abstract void method1209(int var1, int var2);

   abstract void method1210(int[] var1, int[] var2, int var3, int var4);

   GLSprite_Sub2(PureJavaToolkit purejavatoolkit, int i, int i_66_) {
      this.aPureJavaToolkit8886 = purejavatoolkit;
      this.anInt8893 = i;
      this.anInt8897 = i_66_;
   }

   private final boolean method1211(float f, float f_67_, float f_68_, float f_69_, float f_70_, float f_71_) {
      int i = this.anInt8889 + this.anInt8893 + this.anInt8885;
      int i_72_ = this.anInt8899 + this.anInt8897 + this.anInt8884;
      if (i != this.anInt8893 || i_72_ != this.anInt8897) {
         float f_73_ = (f_68_ - f) / (float)i;
         float f_74_ = (f_69_ - f_67_) / (float)i;
         float f_75_ = (f_70_ - f) / (float)i_72_;
         float f_76_ = (f_71_ - f_67_) / (float)i_72_;
         float f_77_ = f_75_ * (float)this.anInt8899;
         float f_78_ = f_76_ * (float)this.anInt8899;
         float f_79_ = f_73_ * (float)this.anInt8889;
         float f_80_ = f_74_ * (float)this.anInt8889;
         float f_81_ = -f_73_ * (float)this.anInt8885;
         float f_82_ = -f_74_ * (float)this.anInt8885;
         float f_83_ = -f_75_ * (float)this.anInt8884;
         float f_84_ = -f_76_ * (float)this.anInt8884;
         f += f_79_ + f_77_;
         f_67_ += f_80_ + f_78_;
         f_68_ += f_81_ + f_77_;
         f_69_ += f_82_ + f_78_;
         f_70_ += f_79_ + f_83_;
         f_71_ += f_80_ + f_84_;
      }

      float f_85_ = f_70_ + (f_68_ - f);
      float f_86_ = f_69_ + (f_71_ - f_67_);
      float f_87_;
      float f_88_;
      if (f < f_68_) {
         f_87_ = f;
         f_88_ = f_68_;
      } else {
         f_87_ = f_68_;
         f_88_ = f;
      }

      if (f_70_ < f_87_) {
         f_87_ = f_70_;
      }

      if (f_85_ < f_87_) {
         f_87_ = f_85_;
      }

      if (f_70_ > f_88_) {
         f_88_ = f_70_;
      }

      if (f_85_ > f_88_) {
         f_88_ = f_85_;
      }

      float f_89_;
      float f_90_;
      if (f_67_ < f_69_) {
         f_89_ = f_67_;
         f_90_ = f_69_;
      } else {
         f_89_ = f_69_;
         f_90_ = f_67_;
      }

      if (f_71_ < f_89_) {
         f_89_ = f_71_;
      }

      if (f_86_ < f_89_) {
         f_89_ = f_86_;
      }

      if (f_71_ > f_90_) {
         f_90_ = f_71_;
      }

      if (f_86_ > f_90_) {
         f_90_ = f_86_;
      }

      if (f_87_ < (float)this.aPureJavaToolkit8886.anInt6767) {
         f_87_ = (float)this.aPureJavaToolkit8886.anInt6767;
      }

      if (f_88_ > (float)this.aPureJavaToolkit8886.anInt6778) {
         f_88_ = (float)this.aPureJavaToolkit8886.anInt6778;
      }

      if (f_89_ < (float)this.aPureJavaToolkit8886.anInt6760) {
         f_89_ = (float)this.aPureJavaToolkit8886.anInt6760;
      }

      if (f_90_ > (float)this.aPureJavaToolkit8886.anInt6772) {
         f_90_ = (float)this.aPureJavaToolkit8886.anInt6772;
      }

      f_88_ = f_87_ - f_88_;
      if (f_88_ >= 0.0F) {
         return false;
      } else {
         f_90_ = f_89_ - f_90_;
         if (f_90_ >= 0.0F) {
            return false;
         } else {
            anInt8881 = this.aPureJavaToolkit8886.anInt6789;
            anInt8882 = (int)((float)((int)f_89_ * anInt8881) + f_87_);
            float f_91_ = (f_68_ - f) * (f_71_ - f_67_) - (f_69_ - f_67_) * (f_70_ - f);
            float f_92_ = (f_70_ - f) * (f_69_ - f_67_) - (f_71_ - f_67_) * (f_68_ - f);
            anInt8913 = (int)((f_71_ - f_67_) * 4096.0F * (float)this.anInt8893 / f_91_);
            anInt8900 = (int)((f_69_ - f_67_) * 4096.0F * (float)this.anInt8897 / f_92_);
            anInt8902 = (int)((f_70_ - f) * 4096.0F * (float)this.anInt8893 / f_92_);
            anInt8883 = (int)((f_68_ - f) * 4096.0F * (float)this.anInt8897 / f_91_);
            anInt8912 = (int)(f_87_ * 16.0F + 8.0F - (f + f_68_ + f_70_ + f_85_) / 4.0F * 16.0F);
            anInt8898 = (int)(f_89_ * 16.0F + 8.0F - (f_67_ + f_69_ + f_71_ + f_86_) / 4.0F * 16.0F);
            anInt8901 = (this.anInt8893 >> 1 << 12) + (anInt8898 * anInt8902 >> 4);
            anInt8908 = (this.anInt8897 >> 1 << 12) + (anInt8898 * anInt8883 >> 4);
            anInt8909 = anInt8912 * anInt8913 >> 4;
            anInt8907 = anInt8912 * anInt8900 >> 4;
            anInt8892 = (int)f_87_;
            anInt8894 = (int)f_88_;
            anInt8905 = (int)f_89_;
            anInt8888 = (int)f_90_;
            return true;
         }
      }
   }
}
