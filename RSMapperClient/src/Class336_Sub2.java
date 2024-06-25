public class Class336_Sub2 extends Class336 {
   static int anInt8557;
   protected float aFloat8558;
   static int anInt8559;
   static int anInt8560;
   protected float aFloat8561;
   static Class103 aClass103_8562 = new Class103();
   static int anInt8563;
   static int anInt8564;
   static int anInt8565;
   protected float aFloat8566;
   protected float aFloat8567;
   static Class77 aClass77_8568;
   static int anInt8569;
   static int anInt8570;
   protected float aFloat8571;
   static int anInt8572;
   static int anInt8573;
   static int anInt8574;
   static int anInt8575;
   static int anInt8576;
   protected float aFloat8577;
   protected float aFloat8578;
   protected float aFloat8579;
   protected float aFloat8580;
   static int anInt8581;
   static int anInt8582;
   protected float aFloat8583;
   protected float aFloat8584;
   static int anInt8585;
   static int anInt8586 = -1;
   static int anInt8587;
   static boolean orthoLocked = true;
   protected float aFloat8589;
   static int anInt8590;

   @Override
   final void method3863(int i, int i_0_, int i_1_) {
      ++anInt8572;
      this.aFloat8579 += (float)i_0_;
      this.aFloat8589 += (float)i_1_;
      this.aFloat8583 += (float)i;
   }

   @Override
   final void method3855(int[] is) {
      ++anInt8563;
      float f = (float)is[0] - this.aFloat8583;
      float f_2_ = (float)is[1] - this.aFloat8579;
      float f_3_ = (float)is[2] - this.aFloat8589;
      is[0] = (int)(this.aFloat8577 * f_3_ + this.aFloat8578 * f_2_ + f * this.aFloat8580);
      is[1] = (int)(f_3_ * this.aFloat8567 + this.aFloat8561 * f_2_ + this.aFloat8571 * f);
      is[2] = (int)(this.aFloat8584 * f_3_ + f * this.aFloat8566 + this.aFloat8558 * f_2_);
   }

   @Override
   final void method3861(int i) {
      ++anInt8570;
      this.aFloat8584 = 1.0F;
      this.aFloat8580 = this.aFloat8561 = Class93.aFloatArray1242[16383 & i];
      this.aFloat8578 = Class93.aFloatArray1238[16383 & i];
      this.aFloat8566 = this.aFloat8583 = this.aFloat8558 = this.aFloat8579 = this.aFloat8577 = this.aFloat8567 = this.aFloat8589 = 0.0F;
      this.aFloat8571 = -this.aFloat8578;
   }

   @Override
   final void method3854(int i, int i_4_, int i_5_) {
      this.aFloat8578 = this.aFloat8577 = this.aFloat8571 = this.aFloat8567 = this.aFloat8566 = this.aFloat8558 = 0.0F;
      ++anInt8587;
      this.aFloat8589 = (float)i_5_;
      this.aFloat8580 = this.aFloat8561 = this.aFloat8584 = 1.0F;
      this.aFloat8579 = (float)i_4_;
      this.aFloat8583 = (float)i;
   }

   @Override
   final void method3869(int i, int i_6_, int i_7_, int[] is) {
      i_7_ = (int)((float)i_7_ - this.aFloat8589);
      ++anInt8585;
      i_6_ = (int)((float)i_6_ - this.aFloat8579);
      i = (int)((float)i - this.aFloat8583);
      is[2] = (int)(this.aFloat8566 * (float)i + (float)i_6_ * this.aFloat8558 + (float)i_7_ * this.aFloat8584);
      is[1] = (int)(this.aFloat8567 * (float)i_7_ + this.aFloat8571 * (float)i + this.aFloat8561 * (float)i_6_);
      is[0] = (int)((float)i_7_ * this.aFloat8577 + this.aFloat8580 * (float)i + this.aFloat8578 * (float)i_6_);
   }

   @Override
   final void method3859(int i) {
      ++anInt8569;
      float f = Class93.aFloatArray1242[i & 16383];
      float f_8_ = Class93.aFloatArray1238[i & 16383];
      float f_9_ = this.aFloat8578;
      float f_10_ = this.aFloat8561;
      float f_11_ = this.aFloat8558;
      float f_12_ = this.aFloat8579;
      this.aFloat8578 = f_9_ * f - this.aFloat8577 * f_8_;
      this.aFloat8577 = f_8_ * f_9_ + f * this.aFloat8577;
      this.aFloat8561 = f * f_10_ - this.aFloat8567 * f_8_;
      this.aFloat8567 = this.aFloat8567 * f + f_10_ * f_8_;
      this.aFloat8558 = -(this.aFloat8584 * f_8_) + f * f_11_;
      this.aFloat8584 = f * this.aFloat8584 + f_8_ * f_11_;
      this.aFloat8579 = -(this.aFloat8589 * f_8_) + f * f_12_;
      this.aFloat8589 = f * this.aFloat8589 + f_8_ * f_12_;
   }

   @Override
   final void method3853(int i, int i_13_, int i_14_, int[] is) {
      is[0] = (int)(this.aFloat8571 * (float)i_13_ + this.aFloat8580 * (float)i + (float)i_14_ * this.aFloat8566 + this.aFloat8583);
      is[1] = (int)(this.aFloat8558 * (float)i_14_ + this.aFloat8578 * (float)i + (float)i_13_ * this.aFloat8561 + this.aFloat8579);
      ++anInt8560;
      is[2] = (int)((float)i_14_ * this.aFloat8584 + (float)i * this.aFloat8577 + (float)i_13_ * this.aFloat8567 + this.aFloat8589);
   }

   @Override
   final void method3864(int i, int i_15_, int i_16_, int i_17_, int i_18_, int i_19_) {
      ++anInt8575;
      float f = Class93.aFloatArray1242[i_17_ & 16383];
      float f_20_ = Class93.aFloatArray1238[i_17_ & 16383];
      float f_21_ = Class93.aFloatArray1242[16383 & i_18_];
      float f_22_ = Class93.aFloatArray1238[i_18_ & 16383];
      float f_23_ = Class93.aFloatArray1242[16383 & i_19_];
      float f_24_ = Class93.aFloatArray1238[16383 & i_19_];
      float f_25_ = f_23_ * f_20_;
      float f_26_ = f_24_ * f_20_;
      this.aFloat8571 = f * f_24_;
      this.aFloat8558 = f_24_ * f_22_ + f_21_ * f_25_;
      this.aFloat8567 = -f_20_;
      this.aFloat8584 = f * f_21_;
      this.aFloat8566 = -f_22_ * f_23_ + f_21_ * f_26_;
      this.aFloat8577 = f * f_22_;
      this.aFloat8561 = f * f_23_;
      this.aFloat8578 = f_24_ * -f_21_ + f_25_ * f_22_;
      this.aFloat8580 = f_21_ * f_23_ + f_26_ * f_22_;
      this.aFloat8589 = -((float)i_16_ * this.aFloat8584) + -((float)i_15_ * this.aFloat8567) + (float)(-i) * this.aFloat8577;
      this.aFloat8583 = -(this.aFloat8566 * (float)i_16_) + -(this.aFloat8571 * (float)i_15_) + this.aFloat8580 * (float)(-i);
      this.aFloat8579 = -((float)i_15_ * this.aFloat8561) + this.aFloat8578 * (float)(-i) - (float)i_16_ * this.aFloat8558;
   }

   @Override
   final void method3867(int i, int i_27_, int i_28_, int[] is) {
      is[1] = (int)(this.aFloat8561 * (float)i_27_ + this.aFloat8578 * (float)i + (float)i_28_ * this.aFloat8558);
      ++anInt8576;
      is[0] = (int)((float)i * this.aFloat8580 + (float)i_27_ * this.aFloat8571 + this.aFloat8566 * (float)i_28_);
      is[2] = (int)((float)i_28_ * this.aFloat8584 + this.aFloat8567 * (float)i_27_ + (float)i * this.aFloat8577);
   }

   @Override
   final Class336 method3858() {
      ++anInt8582;
      Class336_Sub2 class336_sub2_29_ = new Class336_Sub2();
      class336_sub2_29_.aFloat8589 = this.aFloat8589;
      class336_sub2_29_.aFloat8566 = this.aFloat8566;
      class336_sub2_29_.aFloat8561 = this.aFloat8561;
      class336_sub2_29_.aFloat8558 = this.aFloat8558;
      class336_sub2_29_.aFloat8584 = this.aFloat8584;
      class336_sub2_29_.aFloat8583 = this.aFloat8583;
      class336_sub2_29_.aFloat8579 = this.aFloat8579;
      class336_sub2_29_.aFloat8571 = this.aFloat8571;
      class336_sub2_29_.aFloat8567 = this.aFloat8567;
      class336_sub2_29_.aFloat8580 = this.aFloat8580;
      class336_sub2_29_.aFloat8577 = this.aFloat8577;
      class336_sub2_29_.aFloat8578 = this.aFloat8578;
      return class336_sub2_29_;
   }

   @Override
   final void method3862() {
      this.aFloat8580 = this.aFloat8561 = this.aFloat8584 = 1.0F;
      ++anInt8574;
      this.aFloat8578 = this.aFloat8577 = this.aFloat8571 = this.aFloat8567 = this.aFloat8566 = this.aFloat8558 = this.aFloat8583 = this.aFloat8579 = this.aFloat8589 = 0.0F;
   }

   public static void method3892(int i) {
      aClass103_8562 = null;
      aClass77_8568 = null;
      if (i > -4) {
         method3892(-75);
      }
   }

   @Override
   final void method3860(int i) {
      ++anInt8573;
      this.aFloat8561 = 1.0F;
      this.aFloat8580 = this.aFloat8584 = Class93.aFloatArray1242[16383 & i];
      this.aFloat8566 = Class93.aFloatArray1238[i & 16383];
      this.aFloat8571 = this.aFloat8583 = this.aFloat8578 = this.aFloat8558 = this.aFloat8579 = this.aFloat8567 = this.aFloat8589 = 0.0F;
      this.aFloat8577 = -this.aFloat8566;
   }

   @Override
   final void method3865(int i) {
      this.aFloat8580 = 1.0F;
      ++anInt8557;
      this.aFloat8561 = this.aFloat8584 = Class93.aFloatArray1242[16383 & i];
      this.aFloat8567 = Class93.aFloatArray1238[i & 16383];
      this.aFloat8558 = -this.aFloat8567;
      this.aFloat8571 = this.aFloat8566 = this.aFloat8583 = this.aFloat8578 = this.aFloat8579 = this.aFloat8577 = this.aFloat8589 = 0.0F;
   }

   @Override
   final void method3868(int i) {
      ++anInt8590;
      float f = Class93.aFloatArray1242[16383 & i];
      float f_30_ = Class93.aFloatArray1238[16383 & i];
      float f_31_ = this.aFloat8580;
      float f_32_ = this.aFloat8571;
      float f_33_ = this.aFloat8566;
      float f_34_ = this.aFloat8583;
      this.aFloat8580 = -(f_30_ * this.aFloat8578) + f * f_31_;
      this.aFloat8571 = -(this.aFloat8561 * f_30_) + f * f_32_;
      this.aFloat8578 = this.aFloat8578 * f + f_30_ * f_31_;
      this.aFloat8561 = this.aFloat8561 * f + f_30_ * f_32_;
      this.aFloat8566 = -(this.aFloat8558 * f_30_) + f_33_ * f;
      this.aFloat8558 = f_30_ * f_33_ + f * this.aFloat8558;
      this.aFloat8583 = f * f_34_ - this.aFloat8579 * f_30_;
      this.aFloat8579 = this.aFloat8579 * f + f_30_ * f_34_;
   }

   @Override
   final void method3856(int i) {
      ++anInt8559;
      float f = Class93.aFloatArray1242[i & 16383];
      float f_35_ = Class93.aFloatArray1238[i & 16383];
      float f_36_ = this.aFloat8580;
      float f_37_ = this.aFloat8571;
      float f_38_ = this.aFloat8566;
      this.aFloat8580 = f_36_ * f + f_35_ * this.aFloat8577;
      float f_39_ = this.aFloat8583;
      this.aFloat8577 = f * this.aFloat8577 - f_36_ * f_35_;
      this.aFloat8571 = f_35_ * this.aFloat8567 + f_37_ * f;
      this.aFloat8567 = -(f_37_ * f_35_) + this.aFloat8567 * f;
      this.aFloat8566 = f * f_38_ + f_35_ * this.aFloat8584;
      this.aFloat8583 = f_39_ * f + f_35_ * this.aFloat8589;
      this.aFloat8584 = -(f_38_ * f_35_) + f * this.aFloat8584;
      this.aFloat8589 = f * this.aFloat8589 - f_39_ * f_35_;
   }

   @Override
   final void method3857(Class336 class336) {
      ++anInt8565;
      Class336_Sub2 class336_sub2_40_ = (Class336_Sub2)class336;
      this.aFloat8577 = class336_sub2_40_.aFloat8577;
      this.aFloat8566 = class336_sub2_40_.aFloat8566;
      this.aFloat8561 = class336_sub2_40_.aFloat8561;
      this.aFloat8567 = class336_sub2_40_.aFloat8567;
      this.aFloat8578 = class336_sub2_40_.aFloat8578;
      this.aFloat8589 = class336_sub2_40_.aFloat8589;
      this.aFloat8580 = class336_sub2_40_.aFloat8580;
      this.aFloat8571 = class336_sub2_40_.aFloat8571;
      this.aFloat8584 = class336_sub2_40_.aFloat8584;
      this.aFloat8579 = class336_sub2_40_.aFloat8579;
      this.aFloat8558 = class336_sub2_40_.aFloat8558;
      this.aFloat8583 = class336_sub2_40_.aFloat8583;
   }

   public Class336_Sub2() {
      this.method3862();
   }

   static final void method3893(byte b) {
      Class194_Sub3_Sub1.aBoolean9378 = false;
      if (b > 85) {
         ++anInt8564;
         Class320_Sub21.method3764(-122);
      }
   }
}
