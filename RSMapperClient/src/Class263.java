import jaclib.memory.Stream;

public class Class263 {
   static int anInt3329;
   private int anInt3330;
   private AbstractToolkit anAbstractToolkit3331;
   static int anInt3332;
   static int anInt3333;
   private int anInt3334;
   static int anInt3335;
   static int anInt3336 = 1;
   static Class104 aClass104_3337 = new Class104();
   static int anInt3338;
   static int anInt3339;
   static Class119 aClass119_3340;
   private int anInt3341;
   private Class245[][] aClass245ArrayArray3342;
   protected byte[] aByteArray3343;
   private StandardPlane aStandardPlane3344;
   private int anInt3345;
   static int anInt3346;
   protected int anInt3347;

   private final void method3217(int i, int i_0_, int i_1_, int i_2_, int i_3_) {
      if (i_1_ == 0) {
         ++anInt3329;
         if (this.aClass245ArrayArray3342 != null) {
            int i_4_ = i_2_ + -1 >> 7;
            int i_5_ = -1 + i_3_ + -1 + i_2_ >> 7;
            int i_6_ = -1 + i_0_ >> 7;
            int i_7_ = -1 + i + -1 + i_0_ >> 7;

            for(int i_8_ = i_4_; i_8_ <= i_5_; ++i_8_) {
               Class245[] class245s = this.aClass245ArrayArray3342[i_8_];

               for(int i_9_ = i_6_; ~i_7_ <= ~i_9_; ++i_9_) {
                  if (class245s[i_9_] != null) {
                     class245s[i_9_].aBoolean3099 = true;
                  }
               }
            }
         }
      }
   }

   final void method3218(boolean[][] bools, int i, int i_10_, int i_11_, boolean bool, int i_12_) {
      ++anInt3335;
      this.anAbstractToolkit3331.method1296(126, false);
      if (i_12_ != -1) {
         this.method3220(null, -45, -2, -18);
      }

      this.anAbstractToolkit3331.method1307(-113, false);
      this.anAbstractToolkit3331.method1277((byte)61, 1);
      this.anAbstractToolkit3331.method1278((byte)-12, 1);
      this.anAbstractToolkit3331.method1332(i_12_ ^ -4, false, -2, false);
      float f = 1.0F / (float)(this.anAbstractToolkit3331.anInt6320 * 128);
      if (bool) {
         for(int i_13_ = 0; ~this.anInt3345 < ~i_13_; ++i_13_) {
            int i_14_ = i_13_ << this.anInt3330;
            int i_15_ = i_13_ - -1 << this.anInt3330;

            label141:
            for(int i_16_ = 0; this.anInt3334 > i_16_; ++i_16_) {
               if (this.aClass245ArrayArray3342[i_16_][i_13_] != null) {
                  int i_17_ = i_16_ << this.anInt3330;
                  int i_18_ = i_16_ - -1 << this.anInt3330;

                  for(int i_19_ = i_17_; i_18_ > i_19_; ++i_19_) {
                     if (~(i_19_ - i_11_) <= ~(-i) && ~i <= ~(-i_11_ + i_19_)) {
                        for(int i_20_ = i_14_; ~i_15_ < ~i_20_; ++i_20_) {
                           if (-i <= -i_10_ + i_20_ && -i_10_ + i_20_ <= i && bools[i + -i_11_ + i_19_][i_20_ - i_10_ - -i]) {
                              Class336_Sub1 class336_sub1 = this.anAbstractToolkit3331.method1306(7);
                              class336_sub1.method3877(1.0F, (byte)-112, f, f);
                              class336_sub1.method3863(-i_16_, -i_13_, 0);
                              this.anAbstractToolkit3331.method1297(-21029, BufferedConnection.aClass346_615);
                              this.aClass245ArrayArray3342[i_16_][i_13_].method3070(i_12_);
                              continue label141;
                           }
                        }
                     }
                  }
               }
            }
         }
      } else {
         for(int i_21_ = 0; ~this.anInt3345 < ~i_21_; ++i_21_) {
            int i_22_ = i_21_ << this.anInt3330;
            int i_23_ = 1 + i_21_ << this.anInt3330;

            for(int i_24_ = 0; this.anInt3334 > i_24_; ++i_24_) {
               Class245 class245 = this.aClass245ArrayArray3342[i_24_][i_21_];
               if (class245 != null) {
                  Interface15_Impl1 interface15_impl1 = this.anAbstractToolkit3331.method1298(i_12_ + 1, class245.anInt3100 * 3);
                  jaclib.memory.Buffer buffer = interface15_impl1.method54(true, (byte)83);
                  if (buffer != null) {
                     Stream stream = this.anAbstractToolkit3331.method1324(true, buffer);
                     int i_25_ = 0;
                     int i_26_ = i_24_ << this.anInt3330;
                     int i_27_ = i_24_ - -1 << this.anInt3330;

                     for(int i_28_ = i_22_; ~i_23_ < ~i_28_; ++i_28_) {
                        if (~(i_28_ + -i_10_) <= ~(-i) && ~i <= ~(i_28_ - i_10_)) {
                           int i_29_ = i_26_ + this.aStandardPlane3344.anInt3408 * i_28_;

                           for(int i_30_ = i_26_; ~i_27_ < ~i_30_; ++i_30_) {
                              if (~(-i) >= ~(i_30_ + -i_11_) && ~(i_30_ - i_11_) >= ~i && bools[i + i_30_ + -i_11_][i_28_ - (i_10_ - i)]) {
                                 short[] ses = this.aStandardPlane3344.aShortArrayArray7985[i_29_];
                                 if (ses != null) {
                                    if (!Stream.b()) {
                                       for(int i_31_ = 0; ~ses.length < ~i_31_; ++i_31_) {
                                          stream.c('\uffff' & ses[i_31_]);
                                          ++i_25_;
                                       }
                                    } else {
                                       for(int i_32_ = 0; i_32_ < ses.length; ++i_32_) {
                                          stream.b(ses[i_32_] & '\uffff');
                                          ++i_25_;
                                       }
                                    }
                                 }
                              }

                              ++i_29_;
                           }
                        }
                     }

                     stream.c();
                     if (interface15_impl1.method53(-3308) && ~i_25_ < -1) {
                        Class336_Sub1 class336_sub1 = this.anAbstractToolkit3331.method1306(7);
                        class336_sub1.method3877(1.0F, (byte)-112, f, f);
                        class336_sub1.method3863(-i_24_, -i_21_, 0);
                        this.anAbstractToolkit3331.method1297(-21029, BufferedConnection.aClass346_615);
                        class245.method3067(103, interface15_impl1, i_25_ / 3);
                     }
                  }
               }
            }
         }
      }

      this.anAbstractToolkit3331.method1255((byte)-12);
   }

   public static void method3219(boolean bool) {
      aClass119_3340 = null;
      if (bool) {
         aClass104_3337 = null;
      }
   }

   final void method3220(r var_r, int i, int i_33_, int i_34_) {
      ++anInt3339;
      if (i >= -47) {
         this.method3222(null, 91, -19, 127);
      }

      r_Sub1 var_r_Sub1 = (r_Sub1)var_r;
      i_34_ += var_r_Sub1.anInt11052 + 1;
      i_33_ += 1 + var_r_Sub1.anInt11050;
      int i_35_ = i_33_ + i_34_ * this.anInt3347;
      int i_36_ = 0;
      int i_37_ = var_r_Sub1.anInt11049;
      int i_38_ = var_r_Sub1.anInt11042;
      int i_39_ = -i_38_ + this.anInt3347;
      int i_40_ = 0;
      if (i_34_ <= 0) {
         int i_41_ = -i_34_ + 1;
         i_36_ += i_38_ * i_41_;
         i_34_ = 1;
         i_37_ -= i_41_;
         i_35_ += this.anInt3347 * i_41_;
      }

      if (~this.anInt3341 >= ~(i_37_ + i_34_)) {
         int i_42_ = i_37_ + i_34_ + 1 + -this.anInt3341;
         i_37_ -= i_42_;
      }

      if (i_33_ <= 0) {
         int i_43_ = 1 + -i_33_;
         i_35_ += i_43_;
         i_39_ += i_43_;
         i_33_ = 1;
         i_38_ -= i_43_;
         i_40_ += i_43_;
         i_36_ += i_43_;
      }

      if (~this.anInt3347 >= ~(i_38_ + i_33_)) {
         int i_44_ = 1 + i_38_ + i_33_ - this.anInt3347;
         i_40_ += i_44_;
         i_38_ -= i_44_;
         i_39_ += i_44_;
      }

      if (~i_38_ < -1 && ~i_37_ < -1) {
         aa_Sub3.method162(i_39_, i_36_, this.aByteArray3343, i_37_, i_35_, 3, var_r_Sub1.aByteArray11044, i_38_, i_40_);
         this.method3217(i_37_, i_34_, 0, i_33_, i_38_);
      }
   }

   final boolean method3221(int i, r var_r, int i_45_, byte b) {
      ++anInt3333;
      r_Sub1 var_r_Sub1 = (r_Sub1)var_r;
      i_45_ += var_r_Sub1.anInt11052 - -1;
      i += var_r_Sub1.anInt11050 - -1;
      int i_46_ = i_45_ * this.anInt3347 + i;
      int i_47_ = var_r_Sub1.anInt11049;
      if (b >= -95) {
         method3219(false);
      }

      int i_48_ = var_r_Sub1.anInt11042;
      int i_49_ = this.anInt3347 - i_48_;
      if (~i_45_ >= -1) {
         int i_50_ = 1 + -i_45_;
         i_47_ -= i_50_;
         i_46_ += i_50_ * this.anInt3347;
         i_45_ = 1;
      }

      if (this.anInt3341 <= i_45_ + i_47_) {
         int i_51_ = 1 + i_47_ + i_45_ - this.anInt3341;
         i_47_ -= i_51_;
      }

      if (~i >= -1) {
         int i_52_ = -i + 1;
         i_49_ += i_52_;
         i = 1;
         i_48_ -= i_52_;
         i_46_ += i_52_;
      }

      if (~(i - -i_48_) <= ~this.anInt3347) {
         int i_53_ = -this.anInt3347 + 1 + i_48_ + i;
         i_48_ -= i_53_;
         i_49_ += i_53_;
      }

      if (~i_48_ < -1 && ~i_47_ < -1) {
         int i_54_ = 8;
         i_49_ += this.anInt3347 * (-1 + i_54_);
         return Node_Sub15_Sub2.method2559(i_47_, i_46_, i_54_, i_49_, this.aByteArray3343, i_48_, -1941613085);
      } else {
         return false;
      }
   }

   final void method3222(r var_r, int i, int i_55_, int i_56_) {
      ++anInt3346;
      r_Sub1 var_r_Sub1 = (r_Sub1)var_r;
      i_55_ += 1 + var_r_Sub1.anInt11050;
      i += 1 + var_r_Sub1.anInt11052;
      int i_57_ = i * this.anInt3347 + i_55_;
      int i_58_ = 0;
      int i_59_ = var_r_Sub1.anInt11049;
      int i_60_ = var_r_Sub1.anInt11042;
      int i_61_ = this.anInt3347 - i_60_;
      if (~i >= -1) {
         int i_62_ = 1 - i;
         i = 1;
         i_59_ -= i_62_;
         i_58_ += i_62_ * i_60_;
         i_57_ += i_62_ * this.anInt3347;
      }

      int i_63_ = 0;
      if (i - -i_59_ >= this.anInt3341) {
         int i_64_ = 1 + i_59_ + i - this.anInt3341;
         i_59_ -= i_64_;
      }

      if (~i_55_ >= -1) {
         int i_65_ = 1 - i_55_;
         i_55_ = 1;
         i_63_ += i_65_;
         i_61_ += i_65_;
         i_60_ -= i_65_;
         i_57_ += i_65_;
         i_58_ += i_65_;
      }

      if (i_55_ + i_60_ >= this.anInt3347) {
         int i_66_ = 1 + i_55_ + i_60_ - this.anInt3347;
         i_60_ -= i_66_;
         i_61_ += i_66_;
         i_63_ += i_66_;
      }

      if (i_60_ > 0 && ~i_59_ < -1) {
         Class339_Sub3.method3930(this.aByteArray3343, var_r_Sub1.aByteArray11044, i_57_, i_61_, i_63_, i_58_, -126, i_60_, i_59_);
         this.method3217(i_59_, i, i_56_, i_55_, i_60_);
      }
   }

   static final void method3223(int i, int i_67_, int i_68_, int i_69_, int i_70_, int i_71_, int i_72_, int i_73_) {
      ++anInt3338;
      int i_74_ = 0;
      int i_75_ = i_69_;
      int i_76_ = 0;
      int i_77_ = -i_73_ + i_67_;
      int i_78_ = i_69_ - i_73_;
      int i_79_ = i_67_ * i_67_;
      int i_80_ = i_69_ * i_69_;
      if (i_68_ != -21595) {
         method3219(true);
      }

      int i_81_ = i_77_ * i_77_;
      int i_82_ = i_78_ * i_78_;
      int i_83_ = i_80_ << 1;
      int i_84_ = i_79_ << 1;
      int i_85_ = i_82_ << 1;
      int i_86_ = i_81_ << 1;
      int i_87_ = i_69_ << 1;
      int i_88_ = i_78_ << 1;
      int i_89_ = (1 - i_87_) * i_79_ - -i_83_;
      int i_90_ = i_80_ - (-1 + i_87_) * i_84_;
      int i_91_ = i_85_ + i_81_ * (-i_88_ + 1);
      int i_92_ = -((-1 + i_88_) * i_86_) + i_82_;
      int i_93_ = i_79_ << 2;
      int i_94_ = i_80_ << 2;
      int i_95_ = i_81_ << 2;
      int i_96_ = i_82_ << 2;
      int i_97_ = 3 * i_83_;
      int i_98_ = i_84_ * (-3 + i_87_);
      int i_99_ = 3 * i_85_;
      int i_100_ = (i_88_ + -3) * i_86_;
      int i_101_ = i_94_;
      int i_102_ = (i_69_ - 1) * i_93_;
      int i_103_ = i_96_;
      int i_104_ = i_95_ * (i_78_ + -1);
      if (Class384.anInt4906 <= i_71_ && ~i_71_ >= ~Node_Sub25_Sub1.anInt9936) {
         int[] is = Class169_Sub4.anIntArrayArray8826[i_71_];
         int i_105_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, -i_67_ + i);
         int i_106_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, i_68_ ^ -929811639, i - -i_67_);
         int i_107_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, i - i_77_);
         int i_108_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, i + i_77_);
         Class369.method4086(i_107_, i_70_, i_105_, is, 0);
         Class369.method4086(i_108_, i_72_, i_107_, is, 0);
         Class369.method4086(i_106_, i_70_, i_108_, is, 0);
      }

      while(~i_75_ < -1) {
         boolean bool = ~i_78_ <= ~i_75_;
         if (bool) {
            if (~i_91_ > -1) {
               while(~i_91_ > -1) {
                  i_92_ += i_103_;
                  i_91_ += i_99_;
                  i_103_ += i_96_;
                  i_99_ += i_96_;
                  ++i_76_;
               }
            }

            if (~i_92_ > -1) {
               i_91_ += i_99_;
               i_92_ += i_103_;
               i_99_ += i_96_;
               ++i_76_;
               i_103_ += i_96_;
            }

            i_91_ += -i_104_;
            i_92_ += -i_100_;
            i_104_ -= i_95_;
            i_100_ -= i_95_;
         }

         if (i_89_ < 0) {
            while(~i_89_ > -1) {
               i_89_ += i_97_;
               i_90_ += i_101_;
               ++i_74_;
               i_97_ += i_94_;
               i_101_ += i_94_;
            }
         }

         if (i_90_ < 0) {
            i_90_ += i_101_;
            i_89_ += i_97_;
            i_97_ += i_94_;
            i_101_ += i_94_;
            ++i_74_;
         }

         i_90_ += -i_98_;
         i_89_ += -i_102_;
         i_102_ -= i_93_;
         i_98_ -= i_93_;
         int i_109_ = -(--i_75_) + i_71_;
         int i_110_ = i_71_ - -i_75_;
         if (i_110_ >= Class384.anInt4906 && ~i_109_ >= ~Node_Sub25_Sub1.anInt9936) {
            int i_111_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, i_68_ ^ -929811639, i - -i_74_);
            int i_112_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, i - i_74_);
            if (bool) {
               int i_113_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, i_68_ + 929819975, i - -i_76_);
               int i_114_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, i_68_ + 929819975, i - i_76_);
               if (Class384.anInt4906 <= i_109_) {
                  int[] is = Class169_Sub4.anIntArrayArray8826[i_109_];
                  Class369.method4086(i_114_, i_70_, i_112_, is, 0);
                  Class369.method4086(i_113_, i_72_, i_114_, is, 0);
                  Class369.method4086(i_111_, i_70_, i_113_, is, 0);
               }

               if (~Node_Sub25_Sub1.anInt9936 <= ~i_110_) {
                  int[] is = Class169_Sub4.anIntArrayArray8826[i_110_];
                  Class369.method4086(i_114_, i_70_, i_112_, is, 0);
                  Class369.method4086(i_113_, i_72_, i_114_, is, 0);
                  Class369.method4086(i_111_, i_70_, i_113_, is, 0);
               }
            } else {
               if (~i_109_ <= ~Class384.anInt4906) {
                  Class369.method4086(i_111_, i_70_, i_112_, Class169_Sub4.anIntArrayArray8826[i_109_], 0);
               }

               if (i_110_ <= Node_Sub25_Sub1.anInt9936) {
                  Class369.method4086(i_111_, i_70_, i_112_, Class169_Sub4.anIntArrayArray8826[i_110_], 0);
               }
            }
         }
      }
   }

   final void method3224(byte b) {
      ++anInt3332;
      this.aClass245ArrayArray3342 = new Class245[this.anInt3334][this.anInt3345];
      int i = 0;
      if (b == 122) {
         while(this.anInt3345 > i) {
            for(int i_115_ = 0; this.anInt3334 > i_115_; ++i_115_) {
               this.aClass245ArrayArray3342[i_115_][i] = new Class245(
                  this.anAbstractToolkit3331, this, this.aStandardPlane3344, i_115_, i, this.anInt3330, 1 + 128 * i_115_, 128 * i - -1
               );
               if (this.aClass245ArrayArray3342[i_115_][i].anInt3100 == 0) {
                  this.aClass245ArrayArray3342[i_115_][i] = null;
               }
            }

            ++i;
         }
      }
   }

   Class263(AbstractToolkit abstracttoolkit, StandardPlane standardplane) {
      this.aStandardPlane3344 = standardplane;
      this.anAbstractToolkit3331 = abstracttoolkit;
      this.anInt3347 = 2 + (this.aStandardPlane3344.anInt3408 * this.aStandardPlane3344.anInt3398 >> this.anAbstractToolkit3331.anInt6350);
      this.anInt3341 = 2 - -(this.aStandardPlane3344.anInt3398 * this.aStandardPlane3344.anInt3404 >> this.anAbstractToolkit3331.anInt6350);
      this.aByteArray3343 = new byte[this.anInt3347 * this.anInt3341];
      this.anInt3330 = this.anAbstractToolkit3331.anInt6350 + 7 - this.aStandardPlane3344.anInt3410;
      this.anInt3334 = this.aStandardPlane3344.anInt3408 >> this.anInt3330;
      this.anInt3345 = this.aStandardPlane3344.anInt3404 >> this.anInt3330;
   }
}
