public class Class336_Sub3 extends Class336 {
   protected float aFloat8591;
   static int anInt8592;
   protected float aFloat8593;
   protected float aFloat8594;
   static int anInt8595;
   protected float aFloat8596;
   static int anInt8597;
   static int anInt8598;
   static int anInt8599;
   static int anInt8600;
   static int anInt8601;
   static int anInt8602;
   static int anInt8603;
   protected float aFloat8604;
   protected float aFloat8605;
   static int anInt8606;
   protected float aFloat8607;
   protected float aFloat8608;
   protected float aFloat8609;
   static int anInt8610;
   static int anInt8611;
   static int anInt8612;
   static Class170 aClass170_8613 = new Class170(3, 2);
   static int anInt8614;
   protected float aFloat8615;
   static int anInt8616;
   protected float aFloat8617;
   static int anInt8618;
   static int anInt8619;
   static int anInt8620;
   static int anInt8621;
   static int anInt8622;
   static int anInt8623;
   static Class383 aClass383_8624;
   protected float aFloat8625;
   static int anInt8626;

   @Override
   final void method3856(int i) {
      ++anInt8620;
      float f = GameStub.aFloatArray39[16383 & i];
      float f_0_ = GameStub.aFloatArray42[i & 16383];
      float f_1_ = this.aFloat8596;
      float f_2_ = this.aFloat8608;
      float f_3_ = this.aFloat8617;
      this.aFloat8596 = f_0_ * this.aFloat8605 + f * f_1_;
      float f_4_ = this.aFloat8594;
      this.aFloat8605 = f * this.aFloat8605 - f_0_ * f_1_;
      this.aFloat8608 = this.aFloat8593 * f_0_ + f_2_ * f;
      this.aFloat8593 = -(f_0_ * f_2_) + f * this.aFloat8593;
      this.aFloat8617 = this.aFloat8604 * f_0_ + f * f_3_;
      this.aFloat8594 = this.aFloat8615 * f_0_ + f * f_4_;
      this.aFloat8604 = -(f_3_ * f_0_) + this.aFloat8604 * f;
      this.aFloat8615 = f * this.aFloat8615 - f_0_ * f_4_;
   }

   @Override
   final void method3853(int i, int i_5_, int i_6_, int[] is) {
      is[0] = (int)(this.aFloat8594 + this.aFloat8617 * (float)i_6_ + (float)i * this.aFloat8596 + this.aFloat8608 * (float)i_5_);
      is[2] = (int)(this.aFloat8615 + this.aFloat8604 * (float)i_6_ + (float)i * this.aFloat8605 + this.aFloat8593 * (float)i_5_);
      is[1] = (int)(this.aFloat8625 * (float)i + (float)i_5_ * this.aFloat8607 + (float)i_6_ * this.aFloat8591 + this.aFloat8609);
      ++anInt8598;
   }

   final void method3894(int i) {
      this.aFloat8605 = -this.aFloat8605;
      this.aFloat8604 = -this.aFloat8604;
      this.aFloat8591 = -this.aFloat8591;
      if (i != 0) {
         this.method3896(0.34738505F, 0.74615884F, -0.7928313F, 0.15693718F, null, (byte)-111);
      }

      this.aFloat8625 = -this.aFloat8625;
      this.aFloat8609 = -this.aFloat8609;
      this.aFloat8593 = -this.aFloat8593;
      this.aFloat8607 = -this.aFloat8607;
      ++anInt8602;
      this.aFloat8615 = -this.aFloat8615;
   }

   final void method3895(byte b, Class336 class336) {
      ++anInt8592;
      Class336_Sub3 class336_sub3_7_ = (Class336_Sub3)class336;
      this.aFloat8617 = class336_sub3_7_.aFloat8605;
      this.aFloat8596 = class336_sub3_7_.aFloat8596;
      this.aFloat8608 = class336_sub3_7_.aFloat8625;
      this.aFloat8607 = class336_sub3_7_.aFloat8607;
      this.aFloat8625 = class336_sub3_7_.aFloat8608;
      this.aFloat8591 = class336_sub3_7_.aFloat8593;
      this.aFloat8605 = class336_sub3_7_.aFloat8617;
      this.aFloat8594 = -(
         this.aFloat8617 * class336_sub3_7_.aFloat8615 + this.aFloat8596 * class336_sub3_7_.aFloat8594 + class336_sub3_7_.aFloat8609 * this.aFloat8608
      );
      this.aFloat8593 = class336_sub3_7_.aFloat8591;
      this.aFloat8604 = class336_sub3_7_.aFloat8604;
      this.aFloat8609 = -(
         class336_sub3_7_.aFloat8615 * this.aFloat8591 + class336_sub3_7_.aFloat8594 * this.aFloat8625 + this.aFloat8607 * class336_sub3_7_.aFloat8609
      );
      this.aFloat8615 = -(
         class336_sub3_7_.aFloat8594 * this.aFloat8605 + class336_sub3_7_.aFloat8609 * this.aFloat8593 + this.aFloat8604 * class336_sub3_7_.aFloat8615
      );
      if (b < 26) {
         this.aFloat8608 = -1.4741409F;
      }
   }

   @Override
   final Class336 method3858() {
      ++anInt8606;
      Class336_Sub3 class336_sub3_8_ = new Class336_Sub3();
      class336_sub3_8_.aFloat8609 = this.aFloat8609;
      class336_sub3_8_.aFloat8607 = this.aFloat8607;
      class336_sub3_8_.aFloat8593 = this.aFloat8593;
      class336_sub3_8_.aFloat8605 = this.aFloat8605;
      class336_sub3_8_.aFloat8625 = this.aFloat8625;
      class336_sub3_8_.aFloat8617 = this.aFloat8617;
      class336_sub3_8_.aFloat8608 = this.aFloat8608;
      class336_sub3_8_.aFloat8604 = this.aFloat8604;
      class336_sub3_8_.aFloat8591 = this.aFloat8591;
      class336_sub3_8_.aFloat8594 = this.aFloat8594;
      class336_sub3_8_.aFloat8615 = this.aFloat8615;
      class336_sub3_8_.aFloat8596 = this.aFloat8596;
      return class336_sub3_8_;
   }

   @Override
   final void method3869(int i, int i_9_, int i_10_, int[] is) {
      i_9_ = (int)((float)i_9_ - this.aFloat8609);
      i = (int)((float)i - this.aFloat8594);
      ++anInt8595;
      i_10_ = (int)((float)i_10_ - this.aFloat8615);
      is[1] = (int)((float)i_10_ * this.aFloat8593 + (float)i_9_ * this.aFloat8607 + this.aFloat8608 * (float)i);
      is[2] = (int)((float)i * this.aFloat8617 + this.aFloat8591 * (float)i_9_ + this.aFloat8604 * (float)i_10_);
      is[0] = (int)((float)i_10_ * this.aFloat8605 + (float)i_9_ * this.aFloat8625 + (float)i * this.aFloat8596);
   }

   @Override
   final void method3862() {
      this.aFloat8596 = this.aFloat8607 = this.aFloat8604 = 1.0F;
      ++anInt8626;
      this.aFloat8625 = this.aFloat8605 = this.aFloat8608 = this.aFloat8593 = this.aFloat8617 = this.aFloat8591 = this.aFloat8594 = this.aFloat8609 = this.aFloat8615 = 0.0F;
   }

   @Override
   final void method3855(int[] is) {
      ++anInt8610;
      float f = -this.aFloat8594 + (float)is[0];
      float f_11_ = (float)is[1] - this.aFloat8609;
      float f_12_ = -this.aFloat8615 + (float)is[2];
      is[0] = (int)(this.aFloat8625 * f_11_ + this.aFloat8596 * f + f_12_ * this.aFloat8605);
      is[1] = (int)(this.aFloat8593 * f_12_ + this.aFloat8608 * f + this.aFloat8607 * f_11_);
      is[2] = (int)(f_12_ * this.aFloat8604 + f_11_ * this.aFloat8591 + this.aFloat8617 * f);
   }

   @Override
   final void method3868(int i) {
      ++anInt8597;
      float f = GameStub.aFloatArray39[16383 & i];
      float f_13_ = GameStub.aFloatArray42[i & 16383];
      float f_14_ = this.aFloat8596;
      float f_15_ = this.aFloat8608;
      float f_16_ = this.aFloat8617;
      this.aFloat8596 = -(f_13_ * this.aFloat8625) + f_14_ * f;
      float f_17_ = this.aFloat8594;
      this.aFloat8608 = -(this.aFloat8607 * f_13_) + f_15_ * f;
      this.aFloat8625 = f_14_ * f_13_ + this.aFloat8625 * f;
      this.aFloat8607 = f_15_ * f_13_ + f * this.aFloat8607;
      this.aFloat8617 = -(f_13_ * this.aFloat8591) + f_16_ * f;
      this.aFloat8591 = f * this.aFloat8591 + f_16_ * f_13_;
      this.aFloat8594 = f_17_ * f - f_13_ * this.aFloat8609;
      this.aFloat8609 = f * this.aFloat8609 + f_13_ * f_17_;
   }

   final void method3896(float f, float f_18_, float f_19_, float f_20_, float[] fs, byte b) {
      ++anInt8621;
      fs[0] = f_20_ * this.aFloat8596 + this.aFloat8608 * f_19_ + this.aFloat8617 * f;
      fs[1] = this.aFloat8625 * f_20_ + f_19_ * this.aFloat8607 + this.aFloat8591 * f;
      float f_21_;
      float f_22_;
      float f_23_;
      if (!(f_20_ <= 0.00390625F) || !(f_20_ >= -0.00390625F)) {
         float f_26_ = -f_18_ / f_20_;
         f_21_ = f_26_ * this.aFloat8605 + this.aFloat8615;
         f_22_ = this.aFloat8609 + f_26_ * this.aFloat8625;
         f_23_ = this.aFloat8594 + this.aFloat8596 * f_26_;
      } else if (f_19_ <= 0.00390625F && f_19_ >= -0.00390625F) {
         float f_24_ = -f_18_ / f;
         f_23_ = f_24_ * this.aFloat8617 + this.aFloat8594;
         f_21_ = this.aFloat8604 * f_24_ + this.aFloat8615;
         f_22_ = this.aFloat8609 + this.aFloat8591 * f_24_;
      } else {
         float f_25_ = -f_18_ / f_19_;
         f_22_ = this.aFloat8607 * f_25_ + this.aFloat8609;
         f_21_ = this.aFloat8615 + f_25_ * this.aFloat8593;
         f_23_ = this.aFloat8608 * f_25_ + this.aFloat8594;
      }

      fs[2] = f * this.aFloat8604 + this.aFloat8605 * f_20_ + this.aFloat8593 * f_19_;
      if (b != -35) {
         this.method3853(-62, 94, 34, null);
      }

      fs[3] = -(fs[1] * f_22_ + f_23_ * fs[0] + f_21_ * fs[2]);
   }

   @Override
   final void method3864(int i, int i_27_, int i_28_, int i_29_, int i_30_, int i_31_) {
      ++anInt8623;
      float f = GameStub.aFloatArray39[16383 & i_29_];
      float f_32_ = GameStub.aFloatArray42[i_29_ & 16383];
      float f_33_ = GameStub.aFloatArray39[i_30_ & 16383];
      float f_34_ = GameStub.aFloatArray42[16383 & i_30_];
      float f_35_ = GameStub.aFloatArray39[16383 & i_31_];
      float f_36_ = GameStub.aFloatArray42[i_31_ & 16383];
      float f_37_ = f_35_ * f_32_;
      float f_38_ = f_32_ * f_36_;
      this.aFloat8593 = -f_32_;
      this.aFloat8591 = f_34_ * f_36_ + f_33_ * f_37_;
      this.aFloat8625 = f_34_ * f_37_ + -f_33_ * f_36_;
      this.aFloat8605 = f_34_ * f;
      this.aFloat8617 = f_38_ * f_33_ + -f_34_ * f_35_;
      this.aFloat8608 = f * f_36_;
      this.aFloat8604 = f_33_ * f;
      this.aFloat8607 = f * f_35_;
      this.aFloat8596 = f_34_ * f_38_ + f_33_ * f_35_;
      this.aFloat8609 = -(this.aFloat8591 * (float)i_28_) + (this.aFloat8625 * (float)(-i) - this.aFloat8607 * (float)i_27_);
      this.aFloat8594 = (float)(-i) * this.aFloat8596 - (float)i_27_ * this.aFloat8608 - this.aFloat8617 * (float)i_28_;
      this.aFloat8615 = -((float)i_28_ * this.aFloat8604) + (this.aFloat8605 * (float)(-i) - (float)i_27_ * this.aFloat8593);
   }

   final void method3897(byte b, int i, float f, int i_39_, int i_40_, float f_41_, float f_42_) {
      if (~i_39_ != -1) {
         float f_43_ = GameStub.aFloatArray39[i_39_ & 16383];
         float f_44_ = GameStub.aFloatArray42[i_39_ & 16383];
         this.aFloat8607 = f_43_ * (float)i_40_;
         this.aFloat8596 = (float)i * f_43_;
         this.aFloat8625 = (float)i * f_44_;
         this.aFloat8605 = this.aFloat8593 = this.aFloat8617 = this.aFloat8591 = 0.0F;
         this.aFloat8608 = -f_44_ * (float)i_40_;
         this.aFloat8604 = 1.0F;
      } else {
         this.aFloat8604 = 1.0F;
         this.aFloat8596 = (float)i;
         this.aFloat8625 = this.aFloat8605 = this.aFloat8608 = this.aFloat8593 = this.aFloat8617 = this.aFloat8591 = 0.0F;
         this.aFloat8607 = (float)i_40_;
      }

      if (b >= 6) {
         ++anInt8618;
         this.aFloat8615 = f_41_;
         this.aFloat8609 = f_42_;
         this.aFloat8594 = f;
      }
   }

   @Override
   final void method3863(int i, int i_45_, int i_46_) {
      this.aFloat8615 += (float)i_46_;
      ++anInt8612;
      this.aFloat8594 += (float)i;
      this.aFloat8609 += (float)i_45_;
   }

   final float[] method3898(byte b) {
      ++anInt8622;
      LightFX.aFloatArray4097[0] = this.aFloat8596;
      LightFX.aFloatArray4097[2] = this.aFloat8605;
      LightFX.aFloatArray4097[13] = 0.0F;
      LightFX.aFloatArray4097[1] = this.aFloat8625;
      LightFX.aFloatArray4097[14] = 0.0F;
      LightFX.aFloatArray4097[6] = this.aFloat8593;
      LightFX.aFloatArray4097[4] = this.aFloat8608;
      if (b >= -69) {
         return null;
      } else {
         LightFX.aFloatArray4097[10] = this.aFloat8604;
         LightFX.aFloatArray4097[12] = 0.0F;
         LightFX.aFloatArray4097[9] = this.aFloat8591;
         LightFX.aFloatArray4097[8] = this.aFloat8617;
         LightFX.aFloatArray4097[5] = this.aFloat8607;
         return LightFX.aFloatArray4097;
      }
   }

   @Override
   final void method3861(int i) {
      ++anInt8603;
      this.aFloat8604 = 1.0F;
      this.aFloat8596 = this.aFloat8607 = GameStub.aFloatArray39[16383 & i];
      this.aFloat8625 = GameStub.aFloatArray42[i & 16383];
      this.aFloat8617 = this.aFloat8594 = this.aFloat8591 = this.aFloat8609 = this.aFloat8605 = this.aFloat8593 = this.aFloat8615 = 0.0F;
      this.aFloat8608 = -this.aFloat8625;
   }

   @Override
   final void method3865(int i) {
      ++anInt8600;
      this.aFloat8596 = 1.0F;
      this.aFloat8607 = this.aFloat8604 = GameStub.aFloatArray39[i & 16383];
      this.aFloat8593 = GameStub.aFloatArray42[16383 & i];
      this.aFloat8591 = -this.aFloat8593;
      this.aFloat8608 = this.aFloat8617 = this.aFloat8594 = this.aFloat8625 = this.aFloat8609 = this.aFloat8605 = this.aFloat8615 = 0.0F;
   }

   @Override
   final void method3859(int i) {
      ++anInt8601;
      float f = GameStub.aFloatArray39[i & 16383];
      float f_47_ = GameStub.aFloatArray42[i & 16383];
      float f_48_ = this.aFloat8625;
      float f_49_ = this.aFloat8607;
      float f_50_ = this.aFloat8591;
      this.aFloat8625 = f_48_ * f - f_47_ * this.aFloat8605;
      float f_51_ = this.aFloat8609;
      this.aFloat8605 = f * this.aFloat8605 + f_48_ * f_47_;
      this.aFloat8607 = -(this.aFloat8593 * f_47_) + f_49_ * f;
      this.aFloat8591 = f_50_ * f - f_47_ * this.aFloat8604;
      this.aFloat8593 = this.aFloat8593 * f + f_47_ * f_49_;
      this.aFloat8604 = f * this.aFloat8604 + f_47_ * f_50_;
      this.aFloat8609 = -(this.aFloat8615 * f_47_) + f * f_51_;
      this.aFloat8615 = this.aFloat8615 * f + f_47_ * f_51_;
   }

   final float[] method3899(int i) {
      LightFX.aFloatArray4097[12] = this.aFloat8594;
      LightFX.aFloatArray4097[0] = this.aFloat8596;
      LightFX.aFloatArray4097[5] = this.aFloat8607;
      LightFX.aFloatArray4097[1] = this.aFloat8625;
      if (i >= -47) {
         this.method3856(-61);
      }

      LightFX.aFloatArray4097[2] = this.aFloat8605;
      LightFX.aFloatArray4097[8] = this.aFloat8617;
      LightFX.aFloatArray4097[10] = this.aFloat8604;
      LightFX.aFloatArray4097[4] = this.aFloat8608;
      LightFX.aFloatArray4097[9] = this.aFloat8591;
      LightFX.aFloatArray4097[14] = this.aFloat8615;
      ++anInt8611;
      LightFX.aFloatArray4097[13] = this.aFloat8609;
      LightFX.aFloatArray4097[6] = this.aFloat8593;
      return LightFX.aFloatArray4097;
   }

   public static void method3900(int i) {
      aClass383_8624 = null;
      aClass170_8613 = null;
      if (i < 34) {
         method3901(null, -119, 119, -109, -4, 13);
      }
   }

   @Override
   final void method3867(int i, int i_52_, int i_53_, int[] is) {
      is[2] = (int)((float)i * this.aFloat8605 + this.aFloat8593 * (float)i_52_ + this.aFloat8604 * (float)i_53_);
      ++anInt8619;
      is[0] = (int)(this.aFloat8617 * (float)i_53_ + (float)i * this.aFloat8596 + (float)i_52_ * this.aFloat8608);
      is[1] = (int)((float)i_52_ * this.aFloat8607 + this.aFloat8625 * (float)i + this.aFloat8591 * (float)i_53_);
   }

   @Override
   final void method3860(int i) {
      this.aFloat8607 = 1.0F;
      ++anInt8599;
      this.aFloat8596 = this.aFloat8604 = GameStub.aFloatArray39[i & 16383];
      this.aFloat8617 = GameStub.aFloatArray42[i & 16383];
      this.aFloat8608 = this.aFloat8594 = this.aFloat8625 = this.aFloat8591 = this.aFloat8609 = this.aFloat8593 = this.aFloat8615 = 0.0F;
      this.aFloat8605 = -this.aFloat8617;
   }

   public Class336_Sub3() {
      this.method3862();
   }

   @Override
   final void method3854(int i, int i_54_, int i_55_) {
      this.aFloat8615 = (float)i_55_;
      this.aFloat8625 = this.aFloat8605 = this.aFloat8608 = this.aFloat8593 = this.aFloat8617 = this.aFloat8591 = 0.0F;
      this.aFloat8609 = (float)i_54_;
      ++anInt8614;
      this.aFloat8596 = this.aFloat8607 = this.aFloat8604 = 1.0F;
      this.aFloat8594 = (float)i;
   }

   @Override
   final void method3857(Class336 class336) {
      ++anInt8616;
      Class336_Sub3 class336_sub3_56_ = (Class336_Sub3)class336;
      this.aFloat8605 = class336_sub3_56_.aFloat8605;
      this.aFloat8617 = class336_sub3_56_.aFloat8617;
      this.aFloat8609 = class336_sub3_56_.aFloat8609;
      this.aFloat8604 = class336_sub3_56_.aFloat8604;
      this.aFloat8625 = class336_sub3_56_.aFloat8625;
      this.aFloat8594 = class336_sub3_56_.aFloat8594;
      this.aFloat8593 = class336_sub3_56_.aFloat8593;
      this.aFloat8591 = class336_sub3_56_.aFloat8591;
      this.aFloat8608 = class336_sub3_56_.aFloat8608;
      this.aFloat8615 = class336_sub3_56_.aFloat8615;
      this.aFloat8607 = class336_sub3_56_.aFloat8607;
      this.aFloat8596 = class336_sub3_56_.aFloat8596;
   }

   static final void method3901(Animable animable, int i, int i_57_, int i_58_, int i_59_, int i_60_) {
      boolean bool = true;
      int i_61_ = i_57_;
      int i_62_ = i_57_ + i_59_;
      int i_63_ = i_58_ - 1;
      int i_64_ = i_58_ + i_60_;

      for(int i_65_ = i; i_65_ <= i + 1; ++i_65_) {
         if (i_65_ != Class159.anInt1995) {
            for(int i_66_ = i_61_; i_66_ <= i_62_; ++i_66_) {
               if (i_66_ >= 0 && i_66_ < Class328.SCENE_WIDTH_X) {
                  for(int i_67_ = i_63_; i_67_ <= i_64_; ++i_67_) {
                     if (i_67_ >= 0 && i_67_ < Node_Sub50.SCENE_WIDTH_Y && (!bool || i_66_ >= i_62_ || i_67_ >= i_64_ || i_67_ < i_58_ && i_66_ != i_57_)) {
                        Class261 class261 = Class175.aClass261ArrayArrayArray2099[i_65_][i_66_][i_67_];
                        if (class261 != null) {
                           int i_68_ = (
                                    Class320_Sub10.aPlaneArray8300[i_65_].getVerticeHeight(i_67_, i_66_, (byte)-118)
                                       + Class320_Sub10.aPlaneArray8300[i_65_].getVerticeHeight(i_67_, i_66_ + 1, (byte)-118)
                                       + Class320_Sub10.aPlaneArray8300[i_65_].getVerticeHeight(i_67_ + 1, i_66_, (byte)-118)
                                       + Class320_Sub10.aPlaneArray8300[i_65_].getVerticeHeight(i_67_ + 1, i_66_ + 1, (byte)-118)
                                 )
                                 / 4
                              - (
                                    Class320_Sub10.aPlaneArray8300[i].getVerticeHeight(i_58_, i_57_, (byte)-118)
                                       + Class320_Sub10.aPlaneArray8300[i].getVerticeHeight(i_58_, i_57_ + 1, (byte)-118)
                                       + Class320_Sub10.aPlaneArray8300[i].getVerticeHeight(i_58_ + 1, i_57_, (byte)-118)
                                       + Class320_Sub10.aPlaneArray8300[i].getVerticeHeight(i_58_ + 1, i_57_ + 1, (byte)-118)
                                 )
                                 / 4;
                           Animable_Sub2 animable_sub2 = class261.anAnimable_Sub2_3314;
                           Animable_Sub2 animable_sub2_69_ = class261.anAnimable_Sub2_3308;
                           if (animable_sub2 != null && animable_sub2.method821(0)) {
                              animable.method816(
                                 i_68_,
                                 bool,
                                 CacheNode_Sub18.aGraphicsToolkit9607,
                                 (i_67_ - i_58_) * Class179.INT_18 + (1 - i_60_) * Class135.INT_9_,
                                 (byte)110,
                                 (i_66_ - i_57_) * Class179.INT_18 + (1 - i_59_) * Class135.INT_9_,
                                 animable_sub2
                              );
                           }

                           if (animable_sub2_69_ != null && animable_sub2_69_.method821(0)) {
                              animable.method816(
                                 i_68_,
                                 bool,
                                 CacheNode_Sub18.aGraphicsToolkit9607,
                                 (i_67_ - i_58_) * Class179.INT_18 + (1 - i_60_) * Class135.INT_9_,
                                 (byte)115,
                                 (i_66_ - i_57_) * Class179.INT_18 + (1 - i_59_) * Class135.INT_9_,
                                 animable_sub2_69_
                              );
                           }

                           for(Class256 class256 = class261.aClass256_3312; class256 != null; class256 = class256.aClass256_3238) {
                              Mobile mobile = class256.aMobile3239;
                              if (mobile != null
                                 && mobile.method821(0)
                                 && (i_66_ == mobile.aShort9119 || i_66_ == i_61_)
                                 && (i_67_ == mobile.aShort9120 || i_67_ == i_63_)) {
                                 int i_70_ = mobile.aShort9130 - mobile.aShort9119 + 1;
                                 int i_71_ = mobile.aShort9124 - mobile.aShort9120 + 1;
                                 animable.method816(
                                    i_68_,
                                    bool,
                                    CacheNode_Sub18.aGraphicsToolkit9607,
                                    (mobile.aShort9120 - i_58_) * Class179.INT_18 + (i_71_ - i_60_) * Class135.INT_9_,
                                    (byte)114,
                                    (mobile.aShort9119 - i_57_) * Class179.INT_18 + (i_70_ - i_59_) * Class135.INT_9_,
                                    mobile
                                 );
                              }
                           }
                        }
                     }
                  }
               }
            }

            --i_61_;
            bool = false;
         }
      }
   }
}
