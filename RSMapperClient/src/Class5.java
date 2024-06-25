public class Class5 {
   private AbstractToolkit anAbstractToolkit126;
   private Interface13_Impl1[] anInterface13_Impl1Array127;
   protected boolean aBoolean128;
   protected Interface13_Impl3 anInterface13_Impl3_129 = null;
   protected Interface13_Impl3 anInterface13_Impl3_130;
   protected Interface13_Impl1[] anInterface13_Impl1Array131 = null;
   static int anInt132;
   static int anInt133;

   final boolean method172(int i) {
      if (this.anInterface13_Impl3_129 == null) {
         if (Class105.anObject5203 == null) {
            byte[] bs = Class320_Sub20.method3756(16, 8, 128, 4.0F, 4.0F, 0.5F, i ^ 10103, 128, 16.0F, 0.6F, new Class328_Sub1(419684));
            Class105.anObject5203 = Class135.method1588(bs);
         }

         byte[] bs = Class320_Sub15.method3739((byte)2, false, Class105.anObject5203);
         byte[] bs_0_ = new byte[4 * bs.length];
         int i_1_ = 0;

         for(int i_2_ = 0; i_2_ < 16; ++i_2_) {
            int i_3_ = i_2_ * 128 * 128;
            int i_4_ = i_3_;

            for(int i_5_ = 0; i_5_ < 128; ++i_5_) {
               int i_6_ = i_4_ - -(i_5_ * 128);
               int i_7_ = i_4_ - -(128 * (127 & i_5_ - 1));
               int i_8_ = (i_5_ - -1 & 127) * 128 + i_4_;

               for(int i_9_ = 0; ~i_9_ > -129; ++i_9_) {
                  float f = (float)(-(255 & bs[i_9_ + i_8_]) + (255 & bs[i_7_ - -i_9_]));
                  float f_10_ = (float)(-(bs[i_6_ - -(1 + i_9_ & 127)] & 255) + (255 & bs[i_6_ + (127 & -1 + i_9_)]));
                  float f_11_ = (float)(128.0 / Math.sqrt((double)(f * f + f_10_ * f_10_ + 16384.0F)));
                  bs_0_[i_1_++] = (byte)((int)(f_10_ * f_11_ + 127.0F));
                  bs_0_[i_1_++] = (byte)((int)(128.0F * f_11_ + 127.0F));
                  bs_0_[i_1_++] = (byte)((int)(127.0F + f * f_11_));
                  bs_0_[i_1_++] = bs[i_3_++];
               }
            }
         }

         this.anInterface13_Impl3_129 = this.anAbstractToolkit126.method1262(Class99.aClass68_1290, bs_0_, (byte)-57, 128, 16, 128);
      }

      if (i != 10103) {
         return true;
      } else {
         ++anInt133;
         return this.anInterface13_Impl3_129 != null;
      }
   }

   final boolean method173(int i) {
      ++anInt132;
      if (i != 4) {
         this.anInterface13_Impl1Array127 = null;
      }

      if (!this.aBoolean128) {
         return this.anInterface13_Impl1Array131 != null;
      } else {
         return this.anInterface13_Impl3_130 != null;
      }
   }

   Class5(AbstractToolkit abstracttoolkit) {
      this.anInterface13_Impl3_130 = null;
      this.anInterface13_Impl1Array127 = null;
      this.anAbstractToolkit126 = abstracttoolkit;
      this.aBoolean128 = this.anAbstractToolkit126.aBoolean6366;
      if (this.aBoolean128 && !this.anAbstractToolkit126.method1377(Class372.aClass372_4594, RenderDefinitions.aClass68_3268, (byte)-72)) {
         this.aBoolean128 = false;
      }

      if (this.aBoolean128 || this.anAbstractToolkit126.method1295(RenderDefinitions.aClass68_3268, Class372.aClass372_4594, 1)) {
         Class169_Sub1.method1768(0);
         if (this.aBoolean128) {
            byte[] bs = Class320_Sub15.method3739((byte)8, false, Class320_Sub6.anObject8265);
            this.anInterface13_Impl3_130 = this.anAbstractToolkit126.method1262(RenderDefinitions.aClass68_3268, bs, (byte)-57, 128, 16, 128);
            bs = Class320_Sub15.method3739((byte)127, false, Class347.anObject4286);
            this.anAbstractToolkit126.method1262(RenderDefinitions.aClass68_3268, bs, (byte)-57, 128, 16, 128);
         } else {
            this.anInterface13_Impl1Array131 = new Interface13_Impl1[16];

            for(int i = 0; ~i > -17; ++i) {
               byte[] bs = Node_Sub38_Sub5.method2801(32768, Class320_Sub6.anObject8265, 1, 16384 * i * 2);
               this.anInterface13_Impl1Array131[i] = this.anAbstractToolkit126.method1252(128, bs, RenderDefinitions.aClass68_3268, 128, (byte)-3, true);
            }

            this.anInterface13_Impl1Array127 = new Interface13_Impl1[16];

            for(int i = 0; i < 16; ++i) {
               byte[] bs = Node_Sub38_Sub5.method2801(32768, Class347.anObject4286, 1, 128 * i * 256);
               this.anInterface13_Impl1Array127[i] = this.anAbstractToolkit126.method1252(128, bs, RenderDefinitions.aClass68_3268, 128, (byte)-3, true);
            }
         }
      }
   }
}
