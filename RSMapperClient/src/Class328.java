abstract class Class328 {
   static Class362 aClass362_4112;
   static int anInt4113;
   static IncommingPacket aClass192_4114 = new IncommingPacket(68, 1);
   static int SCENE_WIDTH_X;
   static int anInt4116;

   static final void method3825(int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_) {
      ++anInt4113;
      int i_5_ = 0;
      int i_6_ = i_1_;
      if (i_2_ == 68) {
         int i_7_ = i_0_ * i_0_;
         int i_8_ = i_1_ * i_1_;
         int i_9_ = i_8_ << 1;
         int i_10_ = i_7_ << 1;
         int i_11_ = i_1_ << 1;
         int i_12_ = i_9_ + i_7_ * (1 - i_11_);
         int i_13_ = -(i_10_ * (i_11_ - 1)) + i_8_;
         int i_14_ = i_7_ << 2;
         int i_15_ = i_8_ << 2;
         int i_16_ = ((i_5_ << 1) - -3) * i_9_;
         int i_17_ = ((i_1_ << 1) - 3) * i_10_;
         int i_18_ = (i_5_ + 1) * i_15_;
         int i_19_ = (i_1_ - 1) * i_14_;
         if (i >= Class384.anInt4906 && Node_Sub25_Sub1.anInt9936 >= i) {
            int i_20_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, i_0_ + i_3_);
            int i_21_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, -i_0_ + i_3_);
            Class369.method4086(i_20_, i_4_, i_21_, Class169_Sub4.anIntArrayArray8826[i], 0);
         }

         while(~i_6_ < -1) {
            if (i_12_ < 0) {
               while(i_12_ < 0) {
                  i_13_ += i_18_;
                  i_12_ += i_16_;
                  i_18_ += i_15_;
                  ++i_5_;
                  i_16_ += i_15_;
               }
            }

            if (~i_13_ > -1) {
               i_12_ += i_16_;
               i_13_ += i_18_;
               ++i_5_;
               i_18_ += i_15_;
               i_16_ += i_15_;
            }

            i_12_ += -i_19_;
            i_13_ += -i_17_;
            --i_6_;
            i_19_ -= i_14_;
            i_17_ -= i_14_;
            int i_22_ = i - i_6_;
            int i_23_ = i - -i_6_;
            if (~Class384.anInt4906 >= ~i_23_ && Node_Sub25_Sub1.anInt9936 >= i_22_) {
               int i_24_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, i_3_ - -i_5_);
               int i_25_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, -i_5_ + i_3_);
               if (Class384.anInt4906 <= i_22_) {
                  Class369.method4086(i_24_, i_4_, i_25_, Class169_Sub4.anIntArrayArray8826[i_22_], 0);
               }

               if (~Node_Sub25_Sub1.anInt9936 <= ~i_23_) {
                  Class369.method4086(i_24_, i_4_, i_25_, Class169_Sub4.anIntArrayArray8826[i_23_], 0);
               }
            }
         }
      }
   }

   public Class328() {
   }

   abstract void method3826(float var1, float var2, int var3, float[] var4, int var5, float var6, int var7, float var8, int var9, byte var10, int var11);

   static final Animable_Sub2 method3827(int i, int i_33_, int i_34_) {
      Class261 class261 = Class175.aClass261ArrayArrayArray2099[i][i_33_][i_34_];
      return class261 == null ? null : class261.anAnimable_Sub2_3308;
   }

   public static void method3828(int i) {
      aClass192_4114 = null;
      aClass362_4112 = null;
      if (i != 1) {
         method3829(16, 83);
      }
   }

   static final void method3829(int i, int i_35_) {
      Class159.loginType = 2;
      ++anInt4116;
      Class320_Sub23.aClass123_8432 = Class218.aClass123_2566;
      if (i_35_ != -11951) {
         SCENE_WIDTH_X = -28;
      }

      Node_Sub38_Sub23.anInt10347 = i;
      String string = null;
      if (Class143.aByteArray1773 != null) {
         Buffer buffer = new Buffer(Class143.aByteArray1773);
         string = Class154.method1699(buffer.readLong(), 25589);
         Class188_Sub1_Sub2.aLong9342 = buffer.readLong();
      }

      if (string == null) {
         Animable_Sub2.method836(35, true);
      } else {
         Class129.method1556(false, string, true, true, "");
      }
   }
}