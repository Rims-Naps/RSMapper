public class PureJavaDrawableModel extends DrawableModel {
   private int anInt5711;
   private Class185 aClass185_5712;
   private int[] anIntArray5713;
   private int[] anIntArray5714;
   private boolean aBoolean5715 = false;
   private int[] anIntArray5716;
   private int[] anIntArray5717;
   private int anInt5718;
   private short[] aShortArray5719;
   private boolean aBoolean5720;
   private int[] anIntArray5721;
   private int[][] anIntArrayArray5722;
   private boolean aBoolean5723;
   static int anInt5724 = 4096;
   private int[][] anIntArrayArray5725;
   private Class374 aClass374_5726;
   private int anInt5727;
   private int[] anIntArray5728;
   private int[] anIntArray5729;
   private short aShort5730;
   private short[] aShortArray5731;
   private short aShort5732;
   private PureJavaDrawableModel[] aPureJavaDrawableModelArray5733;
   private boolean aBoolean5734;
   private Class354[] aClass354Array5735;
   private byte[] aByteArray5736;
   private int[] anIntArray5737;
   private int[] anIntArray5738;
   private int[] anIntArray5739;
   private short[] aShortArray5740;
   private Class374 aClass374_5741;
   static int anInt5742 = 4096;
   private int anInt5743;
   private int anInt5744;
   private int[] anIntArray5745;
   private int anInt5746;
   private short[] aShortArray5747;
   private int[] anIntArray5748;
   private int[] anIntArray5749;
   private PureJavaDrawableModel[] aPureJavaDrawableModelArray5750;
   private short aShort5751;
   private int anInt5752;
   private int anInt5753;
   private int[] anIntArray5754;
   private short aShort5755;
   private int[] anIntArray5756;
   private short aShort5757;
   private int[] anIntArray5758;
   private short aShort5759;
   private int[] anIntArray5760;
   private int[] anIntArray5761;
   private int anInt5762;
   private float[][] aFloatArrayArray5763;
   private Class218[] aClass218Array5764;
   private Class214[] aClass214Array5765;
   private short aShort5766;
   private short[] aShortArray5767;
   private byte[] aByteArray5768;
   private int[] anIntArray5769;
   private PureJavaToolkit aPureJavaToolkit5770;
   private int[] anIntArray5771;
   private int[] anIntArray5772;
   private short[] aShortArray5773;
   private Class354[] aClass354Array5774;
   private Class272[] aClass272Array5775;
   private float[][] aFloatArrayArray5776;
   private short aShort5777;
   private Class336_Sub2 aClass336_Sub2_5778;
   private int anInt5779;
   private static int anInt5780 = 0;
   private int[] anIntArray5781;
   private Class300[] aClass300Array5782;
   private int[][] anIntArrayArray5783;
   private byte[] aByteArray5784;
   private int[] anIntArray5785;
   private boolean aBoolean5786;
   private short[] aShortArray5787;
   private boolean aBoolean5788;
   private short[] aShortArray5789;
   private Class209[] aClass209Array5790;
   private int anInt5791;
   private boolean aBoolean5792;

   @Override
   final void O(int i, int i_0_, int i_1_) {
      if (i != 128 && (this.anInt5746 & 1) != 1) {
         throw new IllegalStateException();
      } else if (i_0_ != 128 && (this.anInt5746 & 2) != 2) {
         throw new IllegalStateException();
      } else if (i_1_ != 128 && (this.anInt5746 & 4) != 4) {
         throw new IllegalStateException();
      } else {
         synchronized(this) {
            for(int i_2_ = 0; i_2_ < this.anInt5718; ++i_2_) {
               this.anIntArray5748[i_2_] = this.anIntArray5748[i_2_] * i >> 7;
               this.anIntArray5772[i_2_] = this.anIntArray5772[i_2_] * i_0_ >> 7;
               this.anIntArray5717[i_2_] = this.anIntArray5717[i_2_] * i_1_ >> 7;
            }

            this.aBoolean5792 = false;
         }
      }
   }

   @Override
   final int na() {
      if (!this.aBoolean5792) {
         this.method677();
      }

      return this.aShort5777;
   }

   private final void method653() {
      synchronized(this) {
         for(int i = 0; i < this.anInt5718; ++i) {
            this.anIntArray5748[i] = -this.anIntArray5748[i];
            this.anIntArray5717[i] = -this.anIntArray5717[i];
         }

         this.method656();
      }
   }

   @Override
   final void v() {
      if ((this.anInt5746 & 16) != 16) {
         throw new IllegalStateException();
      } else {
         synchronized(this) {
            for(int i = 0; i < this.anInt5718; ++i) {
               this.anIntArray5717[i] = -this.anIntArray5717[i];
            }

            if (this.aClass354Array5774 != null) {
               for(int i = 0; i < this.anInt5753; ++i) {
                  if (this.aClass354Array5774[i] != null) {
                     this.aClass354Array5774[i].anInt4346 = -this.aClass354Array5774[i].anInt4346;
                  }
               }
            }

            if (this.aClass354Array5735 != null) {
               for(int i = 0; i < this.anInt5753; ++i) {
                  if (this.aClass354Array5735[i] != null) {
                     this.aClass354Array5735[i].anInt4346 = -this.aClass354Array5735[i].anInt4346;
                  }
               }
            }

            if (this.aClass272Array5775 != null) {
               for(int i = 0; i < this.anInt5711; ++i) {
                  if (this.aClass272Array5775[i] != null) {
                     this.aClass272Array5775[i].anInt3483 = -this.aClass272Array5775[i].anInt3483;
                  }
               }
            }

            short[] ses = this.aShortArray5767;
            this.aShortArray5767 = this.aShortArray5789;
            this.aShortArray5789 = ses;
            if (this.aFloatArrayArray5763 != null) {
               for(int i = 0; i < this.anInt5711; ++i) {
                  if (this.aFloatArrayArray5763[i] != null) {
                     float f = this.aFloatArrayArray5763[i][0];
                     this.aFloatArrayArray5763[i][0] = this.aFloatArrayArray5763[i][2];
                     this.aFloatArrayArray5763[i][2] = f;
                  }

                  if (this.aFloatArrayArray5776[i] != null) {
                     float f = this.aFloatArrayArray5776[i][0];
                     this.aFloatArrayArray5776[i][0] = this.aFloatArrayArray5776[i][2];
                     this.aFloatArrayArray5776[i][2] = f;
                  }
               }
            }

            this.aBoolean5792 = false;
            this.anInt5744 = 0;
         }
      }
   }

   @Override
   final int HA() {
      if (!this.aBoolean5792) {
         this.method677();
      }

      return this.aShort5732;
   }

   @Override
   final void a(int i) {
      if ((this.anInt5746 & 5) != 5) {
         throw new IllegalStateException();
      } else {
         if (i == 4096) {
            this.method657();
         } else if (i == 8192) {
            this.method653();
         } else if (i == 12288) {
            this.method667();
         } else {
            int i_3_ = Class335.anIntArray4167[i];
            int i_4_ = Class335.anIntArray4165[i];
            synchronized(this) {
               for(int i_5_ = 0; i_5_ < this.anInt5718; ++i_5_) {
                  int i_6_ = this.anIntArray5717[i_5_] * i_3_ + this.anIntArray5748[i_5_] * i_4_ >> 14;
                  this.anIntArray5717[i_5_] = this.anIntArray5717[i_5_] * i_4_ - this.anIntArray5748[i_5_] * i_3_ >> 14;
                  this.anIntArray5748[i_5_] = i_6_;
               }

               this.method656();
            }
         }
      }
   }

   private final void method654(int i) {
      if (!this.aClass374_5741.aBoolean4617) {
         short s = this.aShortArray5767[i];
         short s_7_ = this.aShortArray5731[i];
         short s_8_ = this.aShortArray5789[i];
         int i_9_ = this.anIntArray5758[s] - this.aClass374_5741.anInt4618;
         if (i_9_ > 255) {
            i_9_ = 255;
         } else if (i_9_ < 0) {
            i_9_ = 0;
         }

         int i_10_ = this.anIntArray5758[s_7_] - this.aClass374_5741.anInt4618;
         if (i_10_ > 255) {
            i_10_ = 255;
         } else if (i_10_ < 0) {
            i_10_ = 0;
         }

         int i_11_ = this.anIntArray5758[s_8_] - this.aClass374_5741.anInt4618;
         if (i_11_ > 255) {
            i_11_ = 255;
         } else if (i_11_ < 0) {
            i_11_ = 0;
         }

         int i_12_ = i_9_ + i_10_ + i_11_;
         if (i_12_ != 765) {
            if (i_12_ == 0) {
               this.method669(i);
            } else {
               if (this.aByteArray5784 == null) {
                  this.aClass185_5712.anInt2220 = 0;
               } else {
                  this.aClass185_5712.anInt2220 = this.aByteArray5784[i] & 255;
               }

               if (this.aShortArray5773 != null && this.aShortArray5773[i] != -1) {
                  int i_13_ = -16777216;
                  if (this.aByteArray5784 != null) {
                     i_13_ = 255 - (this.aByteArray5784[i] & 255) << 24;
                  }

                  if (this.anIntArray5761[i] == -1) {
                     int i_14_ = i_13_ | this.anIntArray5754[i] & 16777215;
                     this.aClass185_5712
                        .method1863(
                           (float)this.anIntArray5716[s],
                           (float)this.anIntArray5716[s_7_],
                           (float)this.anIntArray5716[s_8_],
                           (float)this.anIntArray5713[s],
                           (float)this.anIntArray5713[s_7_],
                           (float)this.anIntArray5713[s_8_],
                           (float)this.anIntArray5758[s],
                           (float)this.anIntArray5758[s_7_],
                           (float)this.anIntArray5758[s_8_],
                           this.aFloatArrayArray5763[i][0],
                           this.aFloatArrayArray5763[i][1],
                           this.aFloatArrayArray5763[i][2],
                           this.aFloatArrayArray5776[i][0],
                           this.aFloatArrayArray5776[i][1],
                           this.aFloatArrayArray5776[i][2],
                           i_14_,
                           i_14_,
                           i_14_,
                           this.aClass374_5741.anInt4611,
                           i_9_,
                           i_10_,
                           i_11_,
                           this.aShortArray5773[i]
                        );
                  } else {
                     this.aClass185_5712
                        .method1863(
                           (float)this.anIntArray5716[s],
                           (float)this.anIntArray5716[s_7_],
                           (float)this.anIntArray5716[s_8_],
                           (float)this.anIntArray5713[s],
                           (float)this.anIntArray5713[s_7_],
                           (float)this.anIntArray5713[s_8_],
                           (float)this.anIntArray5758[s],
                           (float)this.anIntArray5758[s_7_],
                           (float)this.anIntArray5758[s_8_],
                           this.aFloatArrayArray5763[i][0],
                           this.aFloatArrayArray5763[i][1],
                           this.aFloatArrayArray5763[i][2],
                           this.aFloatArrayArray5776[i][0],
                           this.aFloatArrayArray5776[i][1],
                           this.aFloatArrayArray5776[i][2],
                           i_13_ | this.anIntArray5754[i] & 16777215,
                           i_13_ | this.anIntArray5739[i] & 16777215,
                           i_13_ | this.anIntArray5761[i] & 16777215,
                           this.aClass374_5741.anInt4611,
                           i_9_,
                           i_10_,
                           i_11_,
                           this.aShortArray5773[i]
                        );
                  }
               } else if (this.anIntArray5761[i] == -1) {
                  this.aClass185_5712
                     .method1852(
                        (float)this.anIntArray5716[s],
                        (float)this.anIntArray5716[s_7_],
                        (float)this.anIntArray5716[s_8_],
                        (float)this.anIntArray5713[s],
                        (float)this.anIntArray5713[s_7_],
                        (float)this.anIntArray5713[s_8_],
                        (float)this.anIntArray5758[s],
                        (float)this.anIntArray5758[s_7_],
                        (float)this.anIntArray5758[s_8_],
                        Class249.method3086(i_9_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56),
                        Class249.method3086(i_10_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56),
                        Class249.method3086(i_11_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56)
                     );
               } else {
                  this.aClass185_5712
                     .method1852(
                        (float)this.anIntArray5716[s],
                        (float)this.anIntArray5716[s_7_],
                        (float)this.anIntArray5716[s_8_],
                        (float)this.anIntArray5713[s],
                        (float)this.anIntArray5713[s_7_],
                        (float)this.anIntArray5713[s_8_],
                        (float)this.anIntArray5758[s],
                        (float)this.anIntArray5758[s_7_],
                        (float)this.anIntArray5758[s_8_],
                        Class249.method3086(i_9_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56),
                        Class249.method3086(i_10_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5739[i] & 65535], (byte)-56),
                        Class249.method3086(i_11_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5761[i] & 65535], (byte)-56)
                     );
               }
            }
         }
      } else {
         short s = this.aShortArray5767[i];
         short s_15_ = this.aShortArray5731[i];
         short s_16_ = this.aShortArray5789[i];
         int i_17_ = 0;
         int i_18_ = 0;
         int i_19_ = 0;
         if (this.anIntArray5769[s] > this.aClass374_5741.anInt4620) {
            i_17_ = 255;
         } else if (this.anIntArray5769[s] > this.aClass374_5741.anInt4624) {
            i_17_ = (this.aClass374_5741.anInt4624 - this.anIntArray5769[s]) * 255 / (this.aClass374_5741.anInt4624 - this.aClass374_5741.anInt4620);
         }

         if (this.anIntArray5769[s_15_] > this.aClass374_5741.anInt4620) {
            i_18_ = 255;
         } else if (this.anIntArray5769[s_15_] > this.aClass374_5741.anInt4624) {
            i_18_ = (this.aClass374_5741.anInt4624 - this.anIntArray5769[s_15_]) * 255 / (this.aClass374_5741.anInt4624 - this.aClass374_5741.anInt4620);
         }

         if (this.anIntArray5769[s_16_] > this.aClass374_5741.anInt4620) {
            i_19_ = 255;
         } else if (this.anIntArray5769[s_16_] > this.aClass374_5741.anInt4624) {
            i_19_ = (this.aClass374_5741.anInt4624 - this.anIntArray5769[s_16_]) * 255 / (this.aClass374_5741.anInt4624 - this.aClass374_5741.anInt4620);
         }

         if (this.aByteArray5784 == null) {
            this.aClass185_5712.anInt2220 = 0;
         } else {
            this.aClass185_5712.anInt2220 = this.aByteArray5784[i] & 255;
         }

         if (this.aShortArray5773 != null && this.aShortArray5773[i] != -1) {
            int i_20_ = -16777216;
            if (this.aByteArray5784 != null) {
               i_20_ = 255 - (this.aByteArray5784[i] & 255) << 24;
            }

            if (this.anIntArray5761[i] == -1) {
               int i_21_ = i_20_ | this.anIntArray5754[i] & 16777215;
               this.aClass185_5712
                  .method1863(
                     (float)this.anIntArray5716[s],
                     (float)this.anIntArray5716[s_15_],
                     (float)this.anIntArray5716[s_16_],
                     (float)this.anIntArray5713[s],
                     (float)this.anIntArray5713[s_15_],
                     (float)this.anIntArray5713[s_16_],
                     (float)this.anIntArray5758[s],
                     (float)this.anIntArray5758[s_15_],
                     (float)this.anIntArray5758[s_16_],
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_21_,
                     i_21_,
                     i_21_,
                     this.aClass374_5741.anInt4611,
                     i_17_,
                     i_18_,
                     i_19_,
                     this.aShortArray5773[i]
                  );
            } else {
               this.aClass185_5712
                  .method1863(
                     (float)this.anIntArray5716[s],
                     (float)this.anIntArray5716[s_15_],
                     (float)this.anIntArray5716[s_16_],
                     (float)this.anIntArray5713[s],
                     (float)this.anIntArray5713[s_15_],
                     (float)this.anIntArray5713[s_16_],
                     (float)this.anIntArray5758[s],
                     (float)this.anIntArray5758[s_15_],
                     (float)this.anIntArray5758[s_16_],
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_20_ | this.anIntArray5754[i] & 16777215,
                     i_20_ | this.anIntArray5739[i] & 16777215,
                     i_20_ | this.anIntArray5761[i] & 16777215,
                     this.aClass374_5741.anInt4611,
                     i_17_,
                     i_18_,
                     i_19_,
                     this.aShortArray5773[i]
                  );
            }
         } else if (this.anIntArray5761[i] == -1) {
            this.aClass185_5712
               .method1852(
                  (float)this.anIntArray5716[s],
                  (float)this.anIntArray5716[s_15_],
                  (float)this.anIntArray5716[s_16_],
                  (float)this.anIntArray5713[s],
                  (float)this.anIntArray5713[s_15_],
                  (float)this.anIntArray5713[s_16_],
                  (float)this.anIntArray5758[s],
                  (float)this.anIntArray5758[s_15_],
                  (float)this.anIntArray5758[s_16_],
                  Class249.method3086(i_17_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56),
                  Class249.method3086(i_18_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56),
                  Class249.method3086(i_19_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56)
               );
         } else {
            this.aClass185_5712
               .method1852(
                  (float)this.anIntArray5716[s],
                  (float)this.anIntArray5716[s_15_],
                  (float)this.anIntArray5716[s_16_],
                  (float)this.anIntArray5713[s],
                  (float)this.anIntArray5713[s_15_],
                  (float)this.anIntArray5713[s_16_],
                  (float)this.anIntArray5758[s],
                  (float)this.anIntArray5758[s_15_],
                  (float)this.anIntArray5758[s_16_],
                  Class249.method3086(i_17_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56),
                  Class249.method3086(i_18_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5739[i] & 65535], (byte)-56),
                  Class249.method3086(i_19_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5761[i] & 65535], (byte)-56)
               );
         }
      }
   }

   private final void method655(boolean bool) {
      if (this.aPureJavaToolkit5770.anInt6795 > 1) {
         synchronized(this) {
            this.method664(bool);
         }
      } else {
         this.method664(bool);
      }
   }

   private final void method656() {
      this.aClass354Array5774 = null;
      this.aClass354Array5735 = null;
      this.aClass272Array5775 = null;
      this.aBoolean5792 = false;
   }

   @Override
   final void method626(int i, int i_22_, int i_23_, int i_24_) {
      if ((this.anInt5746 & 524288) != 524288) {
         throw new IllegalStateException("FMT");
      } else {
         for(int i_25_ = 0; i_25_ < this.anInt5711; ++i_25_) {
            int i_26_ = this.aShortArray5740[i_25_] & '\uffff';
            int i_27_ = i_26_ >> 10 & 63;
            int i_28_ = i_26_ >> 7 & 7;
            int i_29_ = i_26_ & 127;
            if (i != -1) {
               i_27_ += (i - i_27_) * i_24_ >> 7;
            }

            if (i_22_ != -1) {
               i_28_ += (i_22_ - i_28_) * i_24_ >> 7;
            }

            if (i_23_ != -1) {
               i_29_ += (i_23_ - i_29_) * i_24_ >> 7;
            }

            this.aShortArray5740[i_25_] = (short)(i_27_ << 10 | i_28_ << 7 | i_29_);
         }

         if (this.aClass209Array5790 != null) {
            for(int i_30_ = 0; i_30_ < this.anInt5762; ++i_30_) {
               Class209 class209 = this.aClass209Array5790[i_30_];
               Class214 class214 = this.aClass214Array5765[i_30_];
               class214.anInt2519 = class214.anInt2519 & 0xFF000000
                  | Class170.anIntArray2054[Node_Sub15_Sub2.method2560(5310, this.aShortArray5740[class209.anInt2485] & '\uffff') & '\uffff'] & 16777215;
            }
         }

         if (this.anInt5744 == 2) {
            this.anInt5744 = 1;
         }
      }
   }

   @Override
   final int EA() {
      if (!this.aBoolean5792) {
         this.method677();
      }

      return this.aShort5751;
   }

   @Override
   final void I(int i, int[] is, int i_31_, int i_32_, int i_33_, boolean bool, int i_34_, int[] is_35_) {
      int i_36_ = is.length;
      if (i == 0) {
         i_31_ <<= 4;
         i_32_ <<= 4;
         i_33_ <<= 4;
         if (!this.aBoolean5723) {
            for(int i_37_ = 0; i_37_ < this.anInt5718; ++i_37_) {
               this.anIntArray5748[i_37_] <<= 4;
               this.anIntArray5772[i_37_] <<= 4;
               this.anIntArray5717[i_37_] <<= 4;
            }

            this.aBoolean5723 = true;
         }

         int i_38_ = 0;
         this.anInt5779 = 0;
         this.anInt5752 = 0;
         this.anInt5743 = 0;

         for(int i_39_ = 0; i_39_ < i_36_; ++i_39_) {
            int i_40_ = is[i_39_];
            if (i_40_ < this.anIntArrayArray5722.length) {
               int[] is_41_ = this.anIntArrayArray5722[i_40_];

               for(int i_42_ = 0; i_42_ < is_41_.length; ++i_42_) {
                  int i_43_ = is_41_[i_42_];
                  if (this.aShortArray5747 == null || (i_34_ & this.aShortArray5747[i_43_]) != 0) {
                     this.anInt5779 += this.anIntArray5748[i_43_];
                     this.anInt5752 += this.anIntArray5772[i_43_];
                     this.anInt5743 += this.anIntArray5717[i_43_];
                     ++i_38_;
                  }
               }
            }
         }

         if (i_38_ > 0) {
            this.anInt5779 = this.anInt5779 / i_38_ + i_31_;
            this.anInt5752 = this.anInt5752 / i_38_ + i_32_;
            this.anInt5743 = this.anInt5743 / i_38_ + i_33_;
            this.aBoolean5734 = true;
         } else {
            this.anInt5779 = i_31_;
            this.anInt5752 = i_32_;
            this.anInt5743 = i_33_;
         }
      } else if (i == 1) {
         if (is_35_ != null) {
            int i_44_ = is_35_[0] * i_31_ + is_35_[1] * i_32_ + is_35_[2] * i_33_ + 8192 >> 14;
            int i_45_ = is_35_[3] * i_31_ + is_35_[4] * i_32_ + is_35_[5] * i_33_ + 8192 >> 14;
            int i_46_ = is_35_[6] * i_31_ + is_35_[7] * i_32_ + is_35_[8] * i_33_ + 8192 >> 14;
            i_31_ = i_44_;
            i_32_ = i_45_;
            i_33_ = i_46_;
         }

         i_31_ <<= 4;
         i_32_ <<= 4;
         i_33_ <<= 4;
         if (!this.aBoolean5723) {
            for(int i_47_ = 0; i_47_ < this.anInt5718; ++i_47_) {
               this.anIntArray5748[i_47_] <<= 4;
               this.anIntArray5772[i_47_] <<= 4;
               this.anIntArray5717[i_47_] <<= 4;
            }

            this.aBoolean5723 = true;
         }

         for(int i_48_ = 0; i_48_ < i_36_; ++i_48_) {
            int i_49_ = is[i_48_];
            if (i_49_ < this.anIntArrayArray5722.length) {
               int[] is_50_ = this.anIntArrayArray5722[i_49_];

               for(int i_51_ = 0; i_51_ < is_50_.length; ++i_51_) {
                  int i_52_ = is_50_[i_51_];
                  if (this.aShortArray5747 == null || (i_34_ & this.aShortArray5747[i_52_]) != 0) {
                     this.anIntArray5748[i_52_] += i_31_;
                     this.anIntArray5772[i_52_] += i_32_;
                     this.anIntArray5717[i_52_] += i_33_;
                  }
               }
            }
         }
      } else if (i == 2) {
         if (is_35_ != null) {
            if (!this.aBoolean5723) {
               for(int i_53_ = 0; i_53_ < this.anInt5718; ++i_53_) {
                  this.anIntArray5748[i_53_] <<= 4;
                  this.anIntArray5772[i_53_] <<= 4;
                  this.anIntArray5717[i_53_] <<= 4;
               }

               this.aBoolean5723 = true;
            }

            int i_54_ = is_35_[9] << 4;
            int i_55_ = is_35_[10] << 4;
            int i_56_ = is_35_[11] << 4;
            int i_57_ = is_35_[12] << 4;
            int i_58_ = is_35_[13] << 4;
            int i_59_ = is_35_[14] << 4;
            if (this.aBoolean5734) {
               int i_60_ = is_35_[0] * this.anInt5779 + is_35_[3] * this.anInt5752 + is_35_[6] * this.anInt5743 + 8192 >> 14;
               int i_61_ = is_35_[1] * this.anInt5779 + is_35_[4] * this.anInt5752 + is_35_[7] * this.anInt5743 + 8192 >> 14;
               int i_62_ = is_35_[2] * this.anInt5779 + is_35_[5] * this.anInt5752 + is_35_[8] * this.anInt5743 + 8192 >> 14;
               i_60_ += i_57_;
               i_61_ += i_58_;
               i_62_ += i_59_;
               this.anInt5779 = i_60_;
               this.anInt5752 = i_61_;
               this.anInt5743 = i_62_;
               this.aBoolean5734 = false;
            }

            int[] is_63_ = new int[9];
            int i_64_ = Class335.anIntArray4165[i_31_];
            int i_65_ = Class335.anIntArray4167[i_31_];
            int i_66_ = Class335.anIntArray4165[i_32_];
            int i_67_ = Class335.anIntArray4167[i_32_];
            int i_68_ = Class335.anIntArray4165[i_33_];
            int i_69_ = Class335.anIntArray4167[i_33_];
            int i_70_ = i_65_ * i_68_ + 8192 >> 14;
            int i_71_ = i_65_ * i_69_ + 8192 >> 14;
            is_63_[0] = i_66_ * i_68_ + i_67_ * i_71_ + 8192 >> 14;
            is_63_[1] = -i_66_ * i_69_ + i_67_ * i_70_ + 8192 >> 14;
            is_63_[2] = i_67_ * i_64_ + 8192 >> 14;
            is_63_[3] = i_64_ * i_69_ + 8192 >> 14;
            is_63_[4] = i_64_ * i_68_ + 8192 >> 14;
            is_63_[5] = -i_65_;
            is_63_[6] = -i_67_ * i_68_ + i_66_ * i_71_ + 8192 >> 14;
            is_63_[7] = i_67_ * i_69_ + i_66_ * i_70_ + 8192 >> 14;
            is_63_[8] = i_66_ * i_64_ + 8192 >> 14;
            int i_72_ = is_63_[0] * -this.anInt5779 + is_63_[1] * -this.anInt5752 + is_63_[2] * -this.anInt5743 + 8192 >> 14;
            int i_73_ = is_63_[3] * -this.anInt5779 + is_63_[4] * -this.anInt5752 + is_63_[5] * -this.anInt5743 + 8192 >> 14;
            int i_74_ = is_63_[6] * -this.anInt5779 + is_63_[7] * -this.anInt5752 + is_63_[8] * -this.anInt5743 + 8192 >> 14;
            int i_75_ = i_72_ + this.anInt5779;
            int i_76_ = i_73_ + this.anInt5752;
            int i_77_ = i_74_ + this.anInt5743;
            int[] is_78_ = new int[9];

            for(int i_79_ = 0; i_79_ < 3; ++i_79_) {
               for(int i_80_ = 0; i_80_ < 3; ++i_80_) {
                  int i_81_ = 0;

                  for(int i_82_ = 0; i_82_ < 3; ++i_82_) {
                     i_81_ += is_63_[i_79_ * 3 + i_82_] * is_35_[i_80_ * 3 + i_82_];
                  }

                  is_78_[i_79_ * 3 + i_80_] = i_81_ + 8192 >> 14;
               }
            }

            int i_83_ = is_63_[0] * i_57_ + is_63_[1] * i_58_ + is_63_[2] * i_59_ + 8192 >> 14;
            int i_84_ = is_63_[3] * i_57_ + is_63_[4] * i_58_ + is_63_[5] * i_59_ + 8192 >> 14;
            int i_85_ = is_63_[6] * i_57_ + is_63_[7] * i_58_ + is_63_[8] * i_59_ + 8192 >> 14;
            i_83_ += i_75_;
            i_84_ += i_76_;
            i_85_ += i_77_;
            int[] is_86_ = new int[9];

            for(int i_87_ = 0; i_87_ < 3; ++i_87_) {
               for(int i_88_ = 0; i_88_ < 3; ++i_88_) {
                  int i_89_ = 0;

                  for(int i_90_ = 0; i_90_ < 3; ++i_90_) {
                     i_89_ += is_35_[i_87_ * 3 + i_90_] * is_78_[i_88_ + i_90_ * 3];
                  }

                  is_86_[i_87_ * 3 + i_88_] = i_89_ + 8192 >> 14;
               }
            }

            int i_91_ = is_35_[0] * i_83_ + is_35_[1] * i_84_ + is_35_[2] * i_85_ + 8192 >> 14;
            int i_92_ = is_35_[3] * i_83_ + is_35_[4] * i_84_ + is_35_[5] * i_85_ + 8192 >> 14;
            int i_93_ = is_35_[6] * i_83_ + is_35_[7] * i_84_ + is_35_[8] * i_85_ + 8192 >> 14;
            i_91_ += i_54_;
            i_92_ += i_55_;
            i_93_ += i_56_;

            for(int i_94_ = 0; i_94_ < i_36_; ++i_94_) {
               int i_95_ = is[i_94_];
               if (i_95_ < this.anIntArrayArray5722.length) {
                  int[] is_96_ = this.anIntArrayArray5722[i_95_];

                  for(int i_97_ = 0; i_97_ < is_96_.length; ++i_97_) {
                     int i_98_ = is_96_[i_97_];
                     if (this.aShortArray5747 == null || (i_34_ & this.aShortArray5747[i_98_]) != 0) {
                        int i_99_ = is_86_[0] * this.anIntArray5748[i_98_]
                              + is_86_[1] * this.anIntArray5772[i_98_]
                              + is_86_[2] * this.anIntArray5717[i_98_]
                              + 8192
                           >> 14;
                        int i_100_ = is_86_[3] * this.anIntArray5748[i_98_]
                              + is_86_[4] * this.anIntArray5772[i_98_]
                              + is_86_[5] * this.anIntArray5717[i_98_]
                              + 8192
                           >> 14;
                        int i_101_ = is_86_[6] * this.anIntArray5748[i_98_]
                              + is_86_[7] * this.anIntArray5772[i_98_]
                              + is_86_[8] * this.anIntArray5717[i_98_]
                              + 8192
                           >> 14;
                        i_99_ += i_91_;
                        i_100_ += i_92_;
                        i_101_ += i_93_;
                        this.anIntArray5748[i_98_] = i_99_;
                        this.anIntArray5772[i_98_] = i_100_;
                        this.anIntArray5717[i_98_] = i_101_;
                     }
                  }
               }
            }
         } else {
            for(int i_102_ = 0; i_102_ < i_36_; ++i_102_) {
               int i_103_ = is[i_102_];
               if (i_103_ < this.anIntArrayArray5722.length) {
                  int[] is_104_ = this.anIntArrayArray5722[i_103_];

                  for(int i_105_ = 0; i_105_ < is_104_.length; ++i_105_) {
                     int i_106_ = is_104_[i_105_];
                     if (this.aShortArray5747 == null || (i_34_ & this.aShortArray5747[i_106_]) != 0) {
                        this.anIntArray5748[i_106_] -= this.anInt5779;
                        this.anIntArray5772[i_106_] -= this.anInt5752;
                        this.anIntArray5717[i_106_] -= this.anInt5743;
                        if (i_33_ != 0) {
                           int i_107_ = Class335.anIntArray4167[i_33_];
                           int i_108_ = Class335.anIntArray4165[i_33_];
                           int i_109_ = this.anIntArray5772[i_106_] * i_107_ + this.anIntArray5748[i_106_] * i_108_ + 16383 >> 14;
                           this.anIntArray5772[i_106_] = this.anIntArray5772[i_106_] * i_108_ - this.anIntArray5748[i_106_] * i_107_ + 16383 >> 14;
                           this.anIntArray5748[i_106_] = i_109_;
                        }

                        if (i_31_ != 0) {
                           int i_110_ = Class335.anIntArray4167[i_31_];
                           int i_111_ = Class335.anIntArray4165[i_31_];
                           int i_112_ = this.anIntArray5772[i_106_] * i_111_ - this.anIntArray5717[i_106_] * i_110_ + 16383 >> 14;
                           this.anIntArray5717[i_106_] = this.anIntArray5772[i_106_] * i_110_ + this.anIntArray5717[i_106_] * i_111_ + 16383 >> 14;
                           this.anIntArray5772[i_106_] = i_112_;
                        }

                        if (i_32_ != 0) {
                           int i_113_ = Class335.anIntArray4167[i_32_];
                           int i_114_ = Class335.anIntArray4165[i_32_];
                           int i_115_ = this.anIntArray5717[i_106_] * i_113_ + this.anIntArray5748[i_106_] * i_114_ + 16383 >> 14;
                           this.anIntArray5717[i_106_] = this.anIntArray5717[i_106_] * i_114_ - this.anIntArray5748[i_106_] * i_113_ + 16383 >> 14;
                           this.anIntArray5748[i_106_] = i_115_;
                        }

                        this.anIntArray5748[i_106_] += this.anInt5779;
                        this.anIntArray5772[i_106_] += this.anInt5752;
                        this.anIntArray5717[i_106_] += this.anInt5743;
                     }
                  }
               }
            }
         }
      } else if (i == 3) {
         if (is_35_ != null) {
            if (!this.aBoolean5723) {
               for(int i_116_ = 0; i_116_ < this.anInt5718; ++i_116_) {
                  this.anIntArray5748[i_116_] <<= 4;
                  this.anIntArray5772[i_116_] <<= 4;
                  this.anIntArray5717[i_116_] <<= 4;
               }

               this.aBoolean5723 = true;
            }

            int i_117_ = is_35_[9] << 4;
            int i_118_ = is_35_[10] << 4;
            int i_119_ = is_35_[11] << 4;
            int i_120_ = is_35_[12] << 4;
            int i_121_ = is_35_[13] << 4;
            int i_122_ = is_35_[14] << 4;
            if (this.aBoolean5734) {
               int i_123_ = is_35_[0] * this.anInt5779 + is_35_[3] * this.anInt5752 + is_35_[6] * this.anInt5743 + 8192 >> 14;
               int i_124_ = is_35_[1] * this.anInt5779 + is_35_[4] * this.anInt5752 + is_35_[7] * this.anInt5743 + 8192 >> 14;
               int i_125_ = is_35_[2] * this.anInt5779 + is_35_[5] * this.anInt5752 + is_35_[8] * this.anInt5743 + 8192 >> 14;
               i_123_ += i_120_;
               i_124_ += i_121_;
               i_125_ += i_122_;
               this.anInt5779 = i_123_;
               this.anInt5752 = i_124_;
               this.anInt5743 = i_125_;
               this.aBoolean5734 = false;
            }

            int i_126_ = i_31_ << 15 >> 7;
            int i_127_ = i_32_ << 15 >> 7;
            int i_128_ = i_33_ << 15 >> 7;
            int i_129_ = i_126_ * -this.anInt5779 + 8192 >> 14;
            int i_130_ = i_127_ * -this.anInt5752 + 8192 >> 14;
            int i_131_ = i_128_ * -this.anInt5743 + 8192 >> 14;
            int i_132_ = i_129_ + this.anInt5779;
            int i_133_ = i_130_ + this.anInt5752;
            int i_134_ = i_131_ + this.anInt5743;
            int[] is_135_ = new int[]{
               i_126_ * is_35_[0] + 8192 >> 14,
               i_126_ * is_35_[3] + 8192 >> 14,
               i_126_ * is_35_[6] + 8192 >> 14,
               i_127_ * is_35_[1] + 8192 >> 14,
               i_127_ * is_35_[4] + 8192 >> 14,
               i_127_ * is_35_[7] + 8192 >> 14,
               i_128_ * is_35_[2] + 8192 >> 14,
               i_128_ * is_35_[5] + 8192 >> 14,
               i_128_ * is_35_[8] + 8192 >> 14
            };
            int i_136_ = i_126_ * i_120_ + 8192 >> 14;
            int i_137_ = i_127_ * i_121_ + 8192 >> 14;
            int i_138_ = i_128_ * i_122_ + 8192 >> 14;
            i_136_ += i_132_;
            i_137_ += i_133_;
            i_138_ += i_134_;
            int[] is_139_ = new int[9];

            for(int i_140_ = 0; i_140_ < 3; ++i_140_) {
               for(int i_141_ = 0; i_141_ < 3; ++i_141_) {
                  int i_142_ = 0;

                  for(int i_143_ = 0; i_143_ < 3; ++i_143_) {
                     i_142_ += is_35_[i_140_ * 3 + i_143_] * is_135_[i_141_ + i_143_ * 3];
                  }

                  is_139_[i_140_ * 3 + i_141_] = i_142_ + 8192 >> 14;
               }
            }

            int i_144_ = is_35_[0] * i_136_ + is_35_[1] * i_137_ + is_35_[2] * i_138_ + 8192 >> 14;
            int i_145_ = is_35_[3] * i_136_ + is_35_[4] * i_137_ + is_35_[5] * i_138_ + 8192 >> 14;
            int i_146_ = is_35_[6] * i_136_ + is_35_[7] * i_137_ + is_35_[8] * i_138_ + 8192 >> 14;
            i_144_ += i_117_;
            i_145_ += i_118_;
            i_146_ += i_119_;

            for(int i_147_ = 0; i_147_ < i_36_; ++i_147_) {
               int i_148_ = is[i_147_];
               if (i_148_ < this.anIntArrayArray5722.length) {
                  int[] is_149_ = this.anIntArrayArray5722[i_148_];

                  for(int i_150_ = 0; i_150_ < is_149_.length; ++i_150_) {
                     int i_151_ = is_149_[i_150_];
                     if (this.aShortArray5747 == null || (i_34_ & this.aShortArray5747[i_151_]) != 0) {
                        int i_152_ = is_139_[0] * this.anIntArray5748[i_151_]
                              + is_139_[1] * this.anIntArray5772[i_151_]
                              + is_139_[2] * this.anIntArray5717[i_151_]
                              + 8192
                           >> 14;
                        int i_153_ = is_139_[3] * this.anIntArray5748[i_151_]
                              + is_139_[4] * this.anIntArray5772[i_151_]
                              + is_139_[5] * this.anIntArray5717[i_151_]
                              + 8192
                           >> 14;
                        int i_154_ = is_139_[6] * this.anIntArray5748[i_151_]
                              + is_139_[7] * this.anIntArray5772[i_151_]
                              + is_139_[8] * this.anIntArray5717[i_151_]
                              + 8192
                           >> 14;
                        i_152_ += i_144_;
                        i_153_ += i_145_;
                        i_154_ += i_146_;
                        this.anIntArray5748[i_151_] = i_152_;
                        this.anIntArray5772[i_151_] = i_153_;
                        this.anIntArray5717[i_151_] = i_154_;
                     }
                  }
               }
            }
         } else {
            for(int i_155_ = 0; i_155_ < i_36_; ++i_155_) {
               int i_156_ = is[i_155_];
               if (i_156_ < this.anIntArrayArray5722.length) {
                  int[] is_157_ = this.anIntArrayArray5722[i_156_];

                  for(int i_158_ = 0; i_158_ < is_157_.length; ++i_158_) {
                     int i_159_ = is_157_[i_158_];
                     if (this.aShortArray5747 == null || (i_34_ & this.aShortArray5747[i_159_]) != 0) {
                        this.anIntArray5748[i_159_] -= this.anInt5779;
                        this.anIntArray5772[i_159_] -= this.anInt5752;
                        this.anIntArray5717[i_159_] -= this.anInt5743;
                        this.anIntArray5748[i_159_] = this.anIntArray5748[i_159_] * i_31_ / 128;
                        this.anIntArray5772[i_159_] = this.anIntArray5772[i_159_] * i_32_ / 128;
                        this.anIntArray5717[i_159_] = this.anIntArray5717[i_159_] * i_33_ / 128;
                        this.anIntArray5748[i_159_] += this.anInt5779;
                        this.anIntArray5772[i_159_] += this.anInt5752;
                        this.anIntArray5717[i_159_] += this.anInt5743;
                     }
                  }
               }
            }
         }
      } else if (i == 5) {
         if (this.anIntArrayArray5725 != null && this.aByteArray5784 != null) {
            for(int i_160_ = 0; i_160_ < i_36_; ++i_160_) {
               int i_161_ = is[i_160_];
               if (i_161_ < this.anIntArrayArray5725.length) {
                  int[] is_162_ = this.anIntArrayArray5725[i_161_];

                  for(int i_163_ = 0; i_163_ < is_162_.length; ++i_163_) {
                     int i_164_ = is_162_[i_163_];
                     if (this.aShortArray5787 == null || (i_34_ & this.aShortArray5787[i_164_]) != 0) {
                        int i_165_ = (this.aByteArray5784[i_164_] & 255) + i_31_ * 8;
                        if (i_165_ < 0) {
                           i_165_ = 0;
                        } else if (i_165_ > 255) {
                           i_165_ = 255;
                        }

                        this.aByteArray5784[i_164_] = (byte)i_165_;
                     }
                  }
               }
            }

            if (this.aClass209Array5790 != null) {
               for(int i_166_ = 0; i_166_ < this.anInt5762; ++i_166_) {
                  Class209 class209 = this.aClass209Array5790[i_166_];
                  Class214 class214 = this.aClass214Array5765[i_166_];
                  class214.anInt2519 = class214.anInt2519 & 16777215 | 255 - (this.aByteArray5784[class209.anInt2485] & 255) << 24;
               }
            }
         }
      } else if (i == 7) {
         if (this.anIntArrayArray5725 != null) {
            for(int i_167_ = 0; i_167_ < i_36_; ++i_167_) {
               int i_168_ = is[i_167_];
               if (i_168_ < this.anIntArrayArray5725.length) {
                  int[] is_169_ = this.anIntArrayArray5725[i_168_];

                  for(int i_170_ = 0; i_170_ < is_169_.length; ++i_170_) {
                     int i_171_ = is_169_[i_170_];
                     if (this.aShortArray5787 == null || (i_34_ & this.aShortArray5787[i_171_]) != 0) {
                        int i_172_ = this.aShortArray5740[i_171_] & '\uffff';
                        int i_173_ = i_172_ >> 10 & 63;
                        int i_174_ = i_172_ >> 7 & 7;
                        int i_175_ = i_172_ & 127;
                        i_173_ = i_173_ + i_31_ & 63;
                        i_174_ += i_32_;
                        if (i_174_ < 0) {
                           i_174_ = 0;
                        } else if (i_174_ > 7) {
                           i_174_ = 7;
                        }

                        i_175_ += i_33_;
                        if (i_175_ < 0) {
                           i_175_ = 0;
                        } else if (i_175_ > 127) {
                           i_175_ = 127;
                        }

                        this.aShortArray5740[i_171_] = (short)(i_173_ << 10 | i_174_ << 7 | i_175_);
                     }
                  }

                  this.aBoolean5786 = true;
               }
            }

            if (this.aClass209Array5790 != null) {
               for(int i_176_ = 0; i_176_ < this.anInt5762; ++i_176_) {
                  Class209 class209 = this.aClass209Array5790[i_176_];
                  Class214 class214 = this.aClass214Array5765[i_176_];
                  class214.anInt2519 = class214.anInt2519 & 0xFF000000
                     | Class170.anIntArray2054[Node_Sub15_Sub2.method2560(5310, this.aShortArray5740[class209.anInt2485] & '\uffff') & '\uffff'] & 16777215;
               }
            }
         }
      } else if (i == 8) {
         if (this.anIntArrayArray5783 != null) {
            for(int i_177_ = 0; i_177_ < i_36_; ++i_177_) {
               int i_178_ = is[i_177_];
               if (i_178_ < this.anIntArrayArray5783.length) {
                  int[] is_179_ = this.anIntArrayArray5783[i_178_];

                  for(int i_180_ = 0; i_180_ < is_179_.length; ++i_180_) {
                     Class214 class214 = this.aClass214Array5765[is_179_[i_180_]];
                     class214.anInt2516 += i_31_;
                     class214.anInt2523 += i_32_;
                  }
               }
            }
         }
      } else if (i == 10) {
         if (this.anIntArrayArray5783 != null) {
            for(int i_181_ = 0; i_181_ < i_36_; ++i_181_) {
               int i_182_ = is[i_181_];
               if (i_182_ < this.anIntArrayArray5783.length) {
                  int[] is_183_ = this.anIntArrayArray5783[i_182_];

                  for(int i_184_ = 0; i_184_ < is_183_.length; ++i_184_) {
                     Class214 class214 = this.aClass214Array5765[is_183_[i_184_]];
                     class214.anInt2517 = class214.anInt2517 * i_31_ >> 7;
                     class214.anInt2520 = class214.anInt2520 * i_32_ >> 7;
                  }
               }
            }
         }
      } else if (i == 9 && this.anIntArrayArray5783 != null) {
         for(int i_185_ = 0; i_185_ < i_36_; ++i_185_) {
            int i_186_ = is[i_185_];
            if (i_186_ < this.anIntArrayArray5783.length) {
               int[] is_187_ = this.anIntArrayArray5783[i_186_];

               for(int i_188_ = 0; i_188_ < is_187_.length; ++i_188_) {
                  Class214 class214 = this.aClass214Array5765[is_187_[i_188_]];
                  class214.anInt2525 = class214.anInt2525 + i_31_ & 16383;
               }
            }
         }
      }
   }

   @Override
   final boolean method624(int i, int i_189_, Class336 class336, boolean bool, int i_190_) {
      return this.method665(i, i_189_, class336, bool, i_190_, -1);
   }

   private final void method657() {
      synchronized(this) {
         for(int i = 0; i < this.anInt5718; ++i) {
            int i_191_ = this.anIntArray5748[i];
            this.anIntArray5748[i] = this.anIntArray5717[i];
            this.anIntArray5717[i] = -i_191_;
         }

         this.method656();
      }
   }

   @Override
   final r ba(r var_r) {
      return null;
   }

   private final boolean method658(int i) {
      if (this.aByteArray5784 == null) {
         return false;
      } else {
         return this.aByteArray5784[i] != 0;
      }
   }

   @Override
   final int RA() {
      if (!this.aBoolean5792) {
         this.method677();
      }

      return this.aShort5766;
   }

   private final void method659(int i) {
      if (!this.aClass374_5741.aBoolean4617) {
         short s = this.aShortArray5767[i];
         short s_192_ = this.aShortArray5731[i];
         short s_193_ = this.aShortArray5789[i];
         int i_194_ = this.anIntArray5758[s] - this.aClass374_5741.anInt4618;
         if (i_194_ > 255) {
            i_194_ = 255;
         } else if (i_194_ < 0) {
            i_194_ = 0;
         }

         int i_195_ = this.anIntArray5758[s_192_] - this.aClass374_5741.anInt4618;
         if (i_195_ > 255) {
            i_195_ = 255;
         } else if (i_195_ < 0) {
            i_195_ = 0;
         }

         int i_196_ = this.anIntArray5758[s_193_] - this.aClass374_5741.anInt4618;
         if (i_196_ > 255) {
            i_196_ = 255;
         } else if (i_196_ < 0) {
            i_196_ = 0;
         }

         int i_197_ = i_194_ + i_195_ + i_196_;
         if (i_197_ != 765) {
            if (i_197_ == 0) {
               this.method685(i);
            } else {
               if (this.aByteArray5784 == null) {
                  this.aClass185_5712.anInt2220 = 0;
               } else {
                  this.aClass185_5712.anInt2220 = this.aByteArray5784[i] & 255;
               }

               if (this.aShortArray5773 != null && this.aShortArray5773[i] != -1) {
                  int i_198_ = -16777216;
                  if (this.aByteArray5784 != null) {
                     i_198_ = 255 - (this.aByteArray5784[i] & 255) << 24;
                  }

                  if (this.anIntArray5761[i] == -1) {
                     int i_199_ = i_198_ | this.anIntArray5754[i] & 16777215;
                     this.aClass185_5712
                        .method1859(
                           (float)this.anIntArray5716[s],
                           (float)this.anIntArray5716[s_192_],
                           (float)this.anIntArray5716[s_193_],
                           (float)this.anIntArray5713[s],
                           (float)this.anIntArray5713[s_192_],
                           (float)this.anIntArray5713[s_193_],
                           (float)this.anIntArray5758[s],
                           (float)this.anIntArray5758[s_192_],
                           (float)this.anIntArray5758[s_193_],
                           this.aFloatArrayArray5763[i][0],
                           this.aFloatArrayArray5763[i][1],
                           this.aFloatArrayArray5763[i][2],
                           this.aFloatArrayArray5776[i][0],
                           this.aFloatArrayArray5776[i][1],
                           this.aFloatArrayArray5776[i][2],
                           i_199_,
                           i_199_,
                           i_199_,
                           this.aClass374_5741.anInt4611,
                           i_194_,
                           i_195_,
                           i_196_,
                           this.aShortArray5773[i]
                        );
                  } else {
                     this.aClass185_5712
                        .method1859(
                           (float)this.anIntArray5716[s],
                           (float)this.anIntArray5716[s_192_],
                           (float)this.anIntArray5716[s_193_],
                           (float)this.anIntArray5713[s],
                           (float)this.anIntArray5713[s_192_],
                           (float)this.anIntArray5713[s_193_],
                           (float)this.anIntArray5758[s],
                           (float)this.anIntArray5758[s_192_],
                           (float)this.anIntArray5758[s_193_],
                           this.aFloatArrayArray5763[i][0],
                           this.aFloatArrayArray5763[i][1],
                           this.aFloatArrayArray5763[i][2],
                           this.aFloatArrayArray5776[i][0],
                           this.aFloatArrayArray5776[i][1],
                           this.aFloatArrayArray5776[i][2],
                           i_198_ | this.anIntArray5754[i] & 16777215,
                           i_198_ | this.anIntArray5739[i] & 16777215,
                           i_198_ | this.anIntArray5761[i] & 16777215,
                           this.aClass374_5741.anInt4611,
                           i_194_,
                           i_195_,
                           i_196_,
                           this.aShortArray5773[i]
                        );
                  }
               } else if (this.anIntArray5761[i] == -1) {
                  this.aClass185_5712
                     .method1850(
                        (float)this.anIntArray5716[s],
                        (float)this.anIntArray5716[s_192_],
                        (float)this.anIntArray5716[s_193_],
                        (float)this.anIntArray5713[s],
                        (float)this.anIntArray5713[s_192_],
                        (float)this.anIntArray5713[s_193_],
                        (float)this.anIntArray5758[s],
                        (float)this.anIntArray5758[s_192_],
                        (float)this.anIntArray5758[s_193_],
                        Class249.method3086(i_194_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56),
                        Class249.method3086(i_195_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56),
                        Class249.method3086(i_196_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56)
                     );
               } else {
                  this.aClass185_5712
                     .method1850(
                        (float)this.anIntArray5716[s],
                        (float)this.anIntArray5716[s_192_],
                        (float)this.anIntArray5716[s_193_],
                        (float)this.anIntArray5713[s],
                        (float)this.anIntArray5713[s_192_],
                        (float)this.anIntArray5713[s_193_],
                        (float)this.anIntArray5758[s],
                        (float)this.anIntArray5758[s_192_],
                        (float)this.anIntArray5758[s_193_],
                        Class249.method3086(i_194_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56),
                        Class249.method3086(i_195_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5739[i] & 65535], (byte)-56),
                        Class249.method3086(i_196_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5761[i] & 65535], (byte)-56)
                     );
               }
            }
         }
      } else {
         short s = this.aShortArray5767[i];
         short s_200_ = this.aShortArray5731[i];
         short s_201_ = this.aShortArray5789[i];
         int i_202_ = 0;
         int i_203_ = 0;
         int i_204_ = 0;
         if (this.anIntArray5769[s] > this.aClass374_5741.anInt4620) {
            i_202_ = 255;
         } else if (this.anIntArray5769[s] > this.aClass374_5741.anInt4624) {
            i_202_ = (this.aClass374_5741.anInt4624 - this.anIntArray5769[s]) * 255 / (this.aClass374_5741.anInt4624 - this.aClass374_5741.anInt4620);
         }

         if (this.anIntArray5769[s_200_] > this.aClass374_5741.anInt4620) {
            i_203_ = 255;
         } else if (this.anIntArray5769[s_200_] > this.aClass374_5741.anInt4624) {
            i_203_ = (this.aClass374_5741.anInt4624 - this.anIntArray5769[s_200_]) * 255 / (this.aClass374_5741.anInt4624 - this.aClass374_5741.anInt4620);
         }

         if (this.anIntArray5769[s_201_] > this.aClass374_5741.anInt4620) {
            i_204_ = 255;
         } else if (this.anIntArray5769[s_201_] > this.aClass374_5741.anInt4624) {
            i_204_ = (this.aClass374_5741.anInt4624 - this.anIntArray5769[s_201_]) * 255 / (this.aClass374_5741.anInt4624 - this.aClass374_5741.anInt4620);
         }

         if (this.aByteArray5784 == null) {
            this.aClass185_5712.anInt2220 = 0;
         } else {
            this.aClass185_5712.anInt2220 = this.aByteArray5784[i] & 255;
         }

         if (this.aShortArray5773 != null && this.aShortArray5773[i] != -1) {
            int i_205_ = -16777216;
            if (this.aByteArray5784 != null) {
               i_205_ = 255 - (this.aByteArray5784[i] & 255) << 24;
            }

            if (this.anIntArray5761[i] == -1) {
               int i_206_ = i_205_ | this.anIntArray5754[i] & 16777215;
               this.aClass185_5712
                  .method1859(
                     (float)this.anIntArray5716[s],
                     (float)this.anIntArray5716[s_200_],
                     (float)this.anIntArray5716[s_201_],
                     (float)this.anIntArray5713[s],
                     (float)this.anIntArray5713[s_200_],
                     (float)this.anIntArray5713[s_201_],
                     (float)this.anIntArray5758[s],
                     (float)this.anIntArray5758[s_200_],
                     (float)this.anIntArray5758[s_201_],
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_206_,
                     i_206_,
                     i_206_,
                     this.aClass374_5741.anInt4611,
                     i_202_,
                     i_203_,
                     i_204_,
                     this.aShortArray5773[i]
                  );
            } else {
               this.aClass185_5712
                  .method1859(
                     (float)this.anIntArray5716[s],
                     (float)this.anIntArray5716[s_200_],
                     (float)this.anIntArray5716[s_201_],
                     (float)this.anIntArray5713[s],
                     (float)this.anIntArray5713[s_200_],
                     (float)this.anIntArray5713[s_201_],
                     (float)this.anIntArray5758[s],
                     (float)this.anIntArray5758[s_200_],
                     (float)this.anIntArray5758[s_201_],
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_205_ | this.anIntArray5754[i] & 16777215,
                     i_205_ | this.anIntArray5739[i] & 16777215,
                     i_205_ | this.anIntArray5761[i] & 16777215,
                     this.aClass374_5741.anInt4611,
                     i_202_,
                     i_203_,
                     i_204_,
                     this.aShortArray5773[i]
                  );
            }
         } else if (this.anIntArray5761[i] == -1) {
            this.aClass185_5712
               .method1850(
                  (float)this.anIntArray5716[s],
                  (float)this.anIntArray5716[s_200_],
                  (float)this.anIntArray5716[s_201_],
                  (float)this.anIntArray5713[s],
                  (float)this.anIntArray5713[s_200_],
                  (float)this.anIntArray5713[s_201_],
                  (float)this.anIntArray5758[s],
                  (float)this.anIntArray5758[s_200_],
                  (float)this.anIntArray5758[s_201_],
                  Class249.method3086(i_202_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56),
                  Class249.method3086(i_203_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56),
                  Class249.method3086(i_204_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56)
               );
         } else {
            this.aClass185_5712
               .method1850(
                  (float)this.anIntArray5716[s],
                  (float)this.anIntArray5716[s_200_],
                  (float)this.anIntArray5716[s_201_],
                  (float)this.anIntArray5713[s],
                  (float)this.anIntArray5713[s_200_],
                  (float)this.anIntArray5713[s_201_],
                  (float)this.anIntArray5758[s],
                  (float)this.anIntArray5758[s_200_],
                  (float)this.anIntArray5758[s_201_],
                  Class249.method3086(i_202_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5754[i] & 65535], (byte)-56),
                  Class249.method3086(i_203_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5739[i] & 65535], (byte)-56),
                  Class249.method3086(i_204_ << 24 | this.aClass374_5741.anInt4611, Class170.anIntArray2054[this.anIntArray5761[i] & 65535], (byte)-56)
               );
         }
      }
   }

   @Override
   final DrawableModel method633(byte b, int i, boolean bool) {
      this.method687(Thread.currentThread());
      boolean bool_207_ = false;
      PureJavaDrawableModel purejavadrawablemodel_208_;
      PureJavaDrawableModel purejavadrawablemodel_209_;
      if (b > 0 && b <= 7) {
         purejavadrawablemodel_209_ = this.aPureJavaDrawableModelArray5733[b - 1];
         purejavadrawablemodel_208_ = this.aPureJavaDrawableModelArray5750[b - 1];
         bool_207_ = true;
      } else {
         purejavadrawablemodel_208_ = purejavadrawablemodel_209_ = new PureJavaDrawableModel(this.aPureJavaToolkit5770);
      }

      return this.method666(purejavadrawablemodel_208_, purejavadrawablemodel_209_, i, bool_207_, bool);
   }

   @Override
   final void method629() {
      if (this.aPureJavaToolkit5770.anInt6795 > 1) {
         synchronized(this) {
            while(this.aBoolean914) {
               try {
                  this.wait();
               } catch (InterruptedException var3) {
               }
            }

            this.aBoolean914 = true;
         }
      }
   }

   @Override
   final void method617() {
   }

   @Override
   final void P(int i, int i_210_, int i_211_, int i_212_) {
      if (i == 0) {
         int i_213_ = 0;
         this.anInt5779 = 0;
         this.anInt5752 = 0;
         this.anInt5743 = 0;

         for(int i_214_ = 0; i_214_ < this.anInt5718; ++i_214_) {
            this.anInt5779 += this.anIntArray5748[i_214_];
            this.anInt5752 += this.anIntArray5772[i_214_];
            this.anInt5743 += this.anIntArray5717[i_214_];
            ++i_213_;
         }

         if (i_213_ > 0) {
            this.anInt5779 = this.anInt5779 / i_213_ + i_210_;
            this.anInt5752 = this.anInt5752 / i_213_ + i_211_;
            this.anInt5743 = this.anInt5743 / i_213_ + i_212_;
         } else {
            this.anInt5779 = i_210_;
            this.anInt5752 = i_211_;
            this.anInt5743 = i_212_;
         }
      } else if (i == 1) {
         for(int i_215_ = 0; i_215_ < this.anInt5718; ++i_215_) {
            this.anIntArray5748[i_215_] += i_210_;
            this.anIntArray5772[i_215_] += i_211_;
            this.anIntArray5717[i_215_] += i_212_;
         }
      } else if (i == 2) {
         for(int i_216_ = 0; i_216_ < this.anInt5718; ++i_216_) {
            this.anIntArray5748[i_216_] -= this.anInt5779;
            this.anIntArray5772[i_216_] -= this.anInt5752;
            this.anIntArray5717[i_216_] -= this.anInt5743;
            if (i_212_ != 0) {
               int i_217_ = Class335.anIntArray4167[i_212_];
               int i_218_ = Class335.anIntArray4165[i_212_];
               int i_219_ = this.anIntArray5772[i_216_] * i_217_ + this.anIntArray5748[i_216_] * i_218_ + 16383 >> 14;
               this.anIntArray5772[i_216_] = this.anIntArray5772[i_216_] * i_218_ - this.anIntArray5748[i_216_] * i_217_ + 16383 >> 14;
               this.anIntArray5748[i_216_] = i_219_;
            }

            if (i_210_ != 0) {
               int i_220_ = Class335.anIntArray4167[i_210_];
               int i_221_ = Class335.anIntArray4165[i_210_];
               int i_222_ = this.anIntArray5772[i_216_] * i_221_ - this.anIntArray5717[i_216_] * i_220_ + 16383 >> 14;
               this.anIntArray5717[i_216_] = this.anIntArray5772[i_216_] * i_220_ + this.anIntArray5717[i_216_] * i_221_ + 16383 >> 14;
               this.anIntArray5772[i_216_] = i_222_;
            }

            if (i_211_ != 0) {
               int i_223_ = Class335.anIntArray4167[i_211_];
               int i_224_ = Class335.anIntArray4165[i_211_];
               int i_225_ = this.anIntArray5717[i_216_] * i_223_ + this.anIntArray5748[i_216_] * i_224_ + 16383 >> 14;
               this.anIntArray5717[i_216_] = this.anIntArray5717[i_216_] * i_224_ - this.anIntArray5748[i_216_] * i_223_ + 16383 >> 14;
               this.anIntArray5748[i_216_] = i_225_;
            }

            this.anIntArray5748[i_216_] += this.anInt5779;
            this.anIntArray5772[i_216_] += this.anInt5752;
            this.anIntArray5717[i_216_] += this.anInt5743;
         }
      } else if (i == 3) {
         for(int i_226_ = 0; i_226_ < this.anInt5718; ++i_226_) {
            this.anIntArray5748[i_226_] -= this.anInt5779;
            this.anIntArray5772[i_226_] -= this.anInt5752;
            this.anIntArray5717[i_226_] -= this.anInt5743;
            this.anIntArray5748[i_226_] = this.anIntArray5748[i_226_] * i_210_ / 128;
            this.anIntArray5772[i_226_] = this.anIntArray5772[i_226_] * i_211_ / 128;
            this.anIntArray5717[i_226_] = this.anIntArray5717[i_226_] * i_212_ / 128;
            this.anIntArray5748[i_226_] += this.anInt5779;
            this.anIntArray5772[i_226_] += this.anInt5752;
            this.anIntArray5717[i_226_] += this.anInt5743;
         }
      } else if (i == 5) {
         for(int i_227_ = 0; i_227_ < this.anInt5711; ++i_227_) {
            int i_228_ = (this.aByteArray5784[i_227_] & 255) + i_210_ * 8;
            if (i_228_ < 0) {
               i_228_ = 0;
            } else if (i_228_ > 255) {
               i_228_ = 255;
            }

            this.aByteArray5784[i_227_] = (byte)i_228_;
         }

         if (this.aClass209Array5790 != null) {
            for(int i_229_ = 0; i_229_ < this.anInt5762; ++i_229_) {
               Class209 class209 = this.aClass209Array5790[i_229_];
               Class214 class214 = this.aClass214Array5765[i_229_];
               class214.anInt2519 = class214.anInt2519 & 16777215 | 255 - (this.aByteArray5784[class209.anInt2485] & 255) << 24;
            }
         }
      } else if (i == 7) {
         for(int i_230_ = 0; i_230_ < this.anInt5711; ++i_230_) {
            int i_231_ = this.aShortArray5740[i_230_] & '\uffff';
            int i_232_ = i_231_ >> 10 & 63;
            int i_233_ = i_231_ >> 7 & 7;
            int i_234_ = i_231_ & 127;
            i_232_ = i_232_ + i_210_ & 63;
            i_233_ += i_211_;
            if (i_233_ < 0) {
               i_233_ = 0;
            } else if (i_233_ > 7) {
               i_233_ = 7;
            }

            i_234_ += i_212_;
            if (i_234_ < 0) {
               i_234_ = 0;
            } else if (i_234_ > 127) {
               i_234_ = 127;
            }

            this.aShortArray5740[i_230_] = (short)(i_232_ << 10 | i_233_ << 7 | i_234_);
         }

         this.aBoolean5786 = true;
         if (this.aClass209Array5790 != null) {
            for(int i_235_ = 0; i_235_ < this.anInt5762; ++i_235_) {
               Class209 class209 = this.aClass209Array5790[i_235_];
               Class214 class214 = this.aClass214Array5765[i_235_];
               class214.anInt2519 = class214.anInt2519 & 0xFF000000
                  | Class170.anIntArray2054[Node_Sub15_Sub2.method2560(5310, this.aShortArray5740[class209.anInt2485] & '\uffff') & '\uffff'] & 16777215;
            }
         }
      } else if (i == 8) {
         for(int i_236_ = 0; i_236_ < this.anInt5762; ++i_236_) {
            Class214 class214 = this.aClass214Array5765[i_236_];
            class214.anInt2516 += i_210_;
            class214.anInt2523 += i_211_;
         }
      } else if (i == 10) {
         for(int i_237_ = 0; i_237_ < this.anInt5762; ++i_237_) {
            Class214 class214 = this.aClass214Array5765[i_237_];
            class214.anInt2517 = class214.anInt2517 * i_210_ >> 7;
            class214.anInt2520 = class214.anInt2520 * i_211_ >> 7;
         }
      } else if (i == 9) {
         for(int i_238_ = 0; i_238_ < this.anInt5762; ++i_238_) {
            Class214 class214 = this.aClass214Array5765[i_238_];
            class214.anInt2525 = class214.anInt2525 + i_210_ & 16383;
         }
      }
   }

   @Override
   final void LA(int i) {
      if ((this.anInt5746 & 8192) != 8192) {
         throw new IllegalStateException();
      } else {
         this.anInt5727 = i;
         this.anInt5744 = 0;
      }
   }

   @Override
   final void method614(Class336 class336) {
      Class336_Sub2 class336_sub2 = (Class336_Sub2)class336;
      if (this.aClass300Array5782 != null) {
         for(int i = 0; i < this.aClass300Array5782.length; ++i) {
            Class300 class300 = this.aClass300Array5782[i];
            Class300 class300_239_ = class300;
            if (class300.aClass300_3763 != null) {
               class300_239_ = class300.aClass300_3763;
            }

            class300_239_.anInt3769 = (int)(
               class336_sub2.aFloat8583
                  + class336_sub2.aFloat8580 * (float)this.anIntArray5748[class300.anInt3764]
                  + class336_sub2.aFloat8571 * (float)this.anIntArray5772[class300.anInt3764]
                  + class336_sub2.aFloat8566 * (float)this.anIntArray5717[class300.anInt3764]
            );
            class300_239_.anInt3751 = (int)(
               class336_sub2.aFloat8579
                  + class336_sub2.aFloat8578 * (float)this.anIntArray5748[class300.anInt3764]
                  + class336_sub2.aFloat8561 * (float)this.anIntArray5772[class300.anInt3764]
                  + class336_sub2.aFloat8558 * (float)this.anIntArray5717[class300.anInt3764]
            );
            class300_239_.anInt3753 = (int)(
               class336_sub2.aFloat8589
                  + class336_sub2.aFloat8577 * (float)this.anIntArray5748[class300.anInt3764]
                  + class336_sub2.aFloat8567 * (float)this.anIntArray5772[class300.anInt3764]
                  + class336_sub2.aFloat8584 * (float)this.anIntArray5717[class300.anInt3764]
            );
            class300_239_.anInt3766 = (int)(
               class336_sub2.aFloat8583
                  + class336_sub2.aFloat8580 * (float)this.anIntArray5748[class300.anInt3757]
                  + class336_sub2.aFloat8571 * (float)this.anIntArray5772[class300.anInt3757]
                  + class336_sub2.aFloat8566 * (float)this.anIntArray5717[class300.anInt3757]
            );
            class300_239_.anInt3756 = (int)(
               class336_sub2.aFloat8579
                  + class336_sub2.aFloat8578 * (float)this.anIntArray5748[class300.anInt3757]
                  + class336_sub2.aFloat8561 * (float)this.anIntArray5772[class300.anInt3757]
                  + class336_sub2.aFloat8558 * (float)this.anIntArray5717[class300.anInt3757]
            );
            class300_239_.anInt3758 = (int)(
               class336_sub2.aFloat8589
                  + class336_sub2.aFloat8577 * (float)this.anIntArray5748[class300.anInt3757]
                  + class336_sub2.aFloat8567 * (float)this.anIntArray5772[class300.anInt3757]
                  + class336_sub2.aFloat8584 * (float)this.anIntArray5717[class300.anInt3757]
            );
            class300_239_.anInt3761 = (int)(
               class336_sub2.aFloat8583
                  + class336_sub2.aFloat8580 * (float)this.anIntArray5748[class300.anInt3754]
                  + class336_sub2.aFloat8571 * (float)this.anIntArray5772[class300.anInt3754]
                  + class336_sub2.aFloat8566 * (float)this.anIntArray5717[class300.anInt3754]
            );
            class300_239_.anInt3752 = (int)(
               class336_sub2.aFloat8579
                  + class336_sub2.aFloat8578 * (float)this.anIntArray5748[class300.anInt3754]
                  + class336_sub2.aFloat8561 * (float)this.anIntArray5772[class300.anInt3754]
                  + class336_sub2.aFloat8558 * (float)this.anIntArray5717[class300.anInt3754]
            );
            class300_239_.anInt3771 = (int)(
               class336_sub2.aFloat8589
                  + class336_sub2.aFloat8577 * (float)this.anIntArray5748[class300.anInt3754]
                  + class336_sub2.aFloat8567 * (float)this.anIntArray5772[class300.anInt3754]
                  + class336_sub2.aFloat8584 * (float)this.anIntArray5717[class300.anInt3754]
            );
         }
      }

      if (this.aClass218Array5764 != null) {
         for(int i = 0; i < this.aClass218Array5764.length; ++i) {
            Class218 class218 = this.aClass218Array5764[i];
            Class218 class218_240_ = class218;
            if (class218.aClass218_2561 != null) {
               class218_240_ = class218.aClass218_2561;
            }

            if (class218.aClass336_2562 != null) {
               class218.aClass336_2562.method3857(class336_sub2);
            } else {
               class218.aClass336_2562 = class336_sub2.method3858();
            }

            class218_240_.anInt2559 = (int)(
               class336_sub2.aFloat8583
                  + class336_sub2.aFloat8580 * (float)this.anIntArray5748[class218.anInt2554]
                  + class336_sub2.aFloat8571 * (float)this.anIntArray5772[class218.anInt2554]
                  + class336_sub2.aFloat8566 * (float)this.anIntArray5717[class218.anInt2554]
            );
            class218_240_.anInt2557 = (int)(
               class336_sub2.aFloat8579
                  + class336_sub2.aFloat8578 * (float)this.anIntArray5748[class218.anInt2554]
                  + class336_sub2.aFloat8561 * (float)this.anIntArray5772[class218.anInt2554]
                  + class336_sub2.aFloat8558 * (float)this.anIntArray5717[class218.anInt2554]
            );
            class218_240_.anInt2556 = (int)(
               class336_sub2.aFloat8589
                  + class336_sub2.aFloat8577 * (float)this.anIntArray5748[class218.anInt2554]
                  + class336_sub2.aFloat8567 * (float)this.anIntArray5772[class218.anInt2554]
                  + class336_sub2.aFloat8584 * (float)this.anIntArray5717[class218.anInt2554]
            );
         }
      }
   }

   private final void method660(int i, boolean bool, boolean bool_241_) {
      if (this.anIntArray5761[i] != -2) {
         short s = this.aShortArray5767[i];
         short s_242_ = this.aShortArray5731[i];
         short s_243_ = this.aShortArray5789[i];
         int i_244_ = this.anIntArray5713[s];
         int i_245_ = this.anIntArray5713[s_242_];
         int i_246_ = this.anIntArray5713[s_243_];
         if (!bool || i_244_ != -5000 && i_245_ != -5000 && i_246_ != -5000) {
            if (this.anIntArray5756[i] != -1
               || (i_244_ - i_245_) * (this.anIntArray5716[s_243_] - this.anIntArray5716[s_242_])
                     - (this.anIntArray5716[s] - this.anIntArray5716[s_242_]) * (i_246_ - i_245_)
                  > 0) {
               if (i_244_ >= 0
                  && i_245_ >= 0
                  && i_246_ >= 0
                  && i_244_ <= this.aClass374_5741.anInt4635
                  && i_245_ <= this.aClass374_5741.anInt4635
                  && i_246_ <= this.aClass374_5741.anInt4635) {
                  this.aClass185_5712.aBoolean2217 = false;
               } else {
                  this.aClass185_5712.aBoolean2217 = true;
               }

               if (bool_241_) {
                  int i_259_ = this.anIntArray5756[i];
                  if (i_259_ == -1 || !this.aClass209Array5790[i_259_].aBoolean2495) {
                     this.method654(i);
                  }
               } else {
                  int i_260_ = this.anIntArray5756[i];
                  if (i_260_ != -1) {
                     Class209 class209 = this.aClass209Array5790[i_260_];
                     Class214 class214 = this.aClass214Array5765[i_260_];
                     if (!class209.aBoolean2495) {
                        this.method669(i);
                     }

                     this.aPureJavaToolkit5770
                        .method1504(
                           class214.anInt2515,
                           class214.anInt2521,
                           class214.anInt2518,
                           class214.anInt2526,
                           class214.anInt2514,
                           class214.anInt2525,
                           class209.aShort2488 & '\uffff',
                           class214.anInt2519,
                           class209.aByte2489,
                           class209.aByte2487
                        );
                  } else {
                     this.method669(i);
                  }
               }
            }
         } else {
            int i_247_ = this.anIntArray5714[s];
            int i_248_ = this.anIntArray5714[s_242_];
            int i_249_ = this.anIntArray5714[s_243_];
            int i_250_ = this.anIntArray5728[s];
            int i_251_ = this.anIntArray5728[s_242_];
            int i_252_ = this.anIntArray5728[s_243_];
            int i_253_ = this.anIntArray5721[s];
            int i_254_ = this.anIntArray5721[s_242_];
            int i_255_ = this.anIntArray5721[s_243_];
            i_247_ -= i_248_;
            i_249_ -= i_248_;
            i_250_ -= i_251_;
            i_252_ -= i_251_;
            i_253_ -= i_254_;
            i_255_ -= i_254_;
            int i_256_ = i_250_ * i_255_ - i_253_ * i_252_;
            int i_257_ = i_253_ * i_249_ - i_247_ * i_255_;
            int i_258_ = i_247_ * i_252_ - i_250_ * i_249_;
            if (i_248_ * i_256_ + i_251_ * i_257_ + i_254_ * i_258_ > 0) {
               this.method670(i);
            }
         }
      }
   }

   private final void method661() {
      if (this.anInt5744 == 0) {
         this.method655(false);
      } else if (this.aPureJavaToolkit5770.anInt6795 > 1) {
         synchronized(this) {
            this.method679();
         }
      } else {
         this.method679();
      }
   }

   @Override
   final void method636(byte b, byte[] bs) {
      if ((this.anInt5746 & 1048576) == 0) {
         throw new RuntimeException();
      } else {
         if (this.aByteArray5784 == null) {
            this.aByteArray5784 = new byte[this.anInt5711];
         }

         if (bs == null) {
            for(int i = 0; i < this.anInt5711; ++i) {
               this.aByteArray5784[i] = b;
            }
         } else {
            for(int i = 0; i < this.anInt5711; ++i) {
               int i_261_ = 255 - (255 - (bs[i] & 255)) * (255 - (b & 255)) / 255;
               this.aByteArray5784[i] = (byte)i_261_;
            }
         }

         if (this.anInt5744 == 2) {
            this.anInt5744 = 1;
         }
      }
   }

   @Override
   final Class300[] method620() {
      return this.aClass300Array5782;
   }

   @Override
   final void ia(short s, short s_262_) {
      for(int i = 0; i < this.anInt5711; ++i) {
         if (this.aShortArray5740[i] == s) {
            this.aShortArray5740[i] = s_262_;
         }
      }

      if (this.aClass209Array5790 != null) {
         for(int i = 0; i < this.anInt5762; ++i) {
            Class209 class209 = this.aClass209Array5790[i];
            Class214 class214 = this.aClass214Array5765[i];
            class214.anInt2519 = class214.anInt2519 & 0xFF000000
               | Class170.anIntArray2054[Node_Sub15_Sub2.method2560(5310, this.aShortArray5740[class209.anInt2485]) & '\uffff'] & 16777215;
         }
      }

      if (this.anInt5744 == 2) {
         this.anInt5744 = 1;
      }
   }

   @Override
   final boolean method621(int i, int i_263_, Class336 class336, boolean bool, int i_264_, int i_265_) {
      return this.method665(i, i_263_, class336, bool, i_264_, i_265_);
   }

   private final void method662() {
      this.aClass354Array5774 = new Class354[this.anInt5753];

      for(int i = 0; i < this.anInt5753; ++i) {
         this.aClass354Array5774[i] = new Class354();
      }

      for(int i = 0; i < this.anInt5711; ++i) {
         short s = this.aShortArray5767[i];
         short s_266_ = this.aShortArray5731[i];
         short s_267_ = this.aShortArray5789[i];
         int i_268_ = this.anIntArray5748[s_266_] - this.anIntArray5748[s];
         int i_269_ = this.anIntArray5772[s_266_] - this.anIntArray5772[s];
         int i_270_ = this.anIntArray5717[s_266_] - this.anIntArray5717[s];
         int i_271_ = this.anIntArray5748[s_267_] - this.anIntArray5748[s];
         int i_272_ = this.anIntArray5772[s_267_] - this.anIntArray5772[s];
         int i_273_ = this.anIntArray5717[s_267_] - this.anIntArray5717[s];
         int i_274_ = i_269_ * i_273_ - i_272_ * i_270_;
         int i_275_ = i_270_ * i_271_ - i_273_ * i_268_;

         int i_276_;
         for(i_276_ = i_268_ * i_272_ - i_271_ * i_269_;
            i_274_ > 8192 || i_275_ > 8192 || i_276_ > 8192 || i_274_ < -8192 || i_275_ < -8192 || i_276_ < -8192;
            i_276_ >>= 1
         ) {
            i_274_ >>= 1;
            i_275_ >>= 1;
         }

         int i_277_ = (int)Math.sqrt((double)(i_274_ * i_274_ + i_275_ * i_275_ + i_276_ * i_276_));
         if (i_277_ <= 0) {
            i_277_ = 1;
         }

         i_274_ = i_274_ * 256 / i_277_;
         i_275_ = i_275_ * 256 / i_277_;
         i_276_ = i_276_ * 256 / i_277_;
         byte b;
         if (this.aByteArray5736 == null) {
            b = 0;
         } else {
            b = this.aByteArray5736[i];
         }

         if (b == 0) {
            Class354 class354 = this.aClass354Array5774[s];
            class354.anInt4347 += i_274_;
            class354.anInt4348 += i_275_;
            class354.anInt4346 += i_276_;
            ++class354.anInt4345;
            class354 = this.aClass354Array5774[s_266_];
            class354.anInt4347 += i_274_;
            class354.anInt4348 += i_275_;
            class354.anInt4346 += i_276_;
            ++class354.anInt4345;
            class354 = this.aClass354Array5774[s_267_];
            class354.anInt4347 += i_274_;
            class354.anInt4348 += i_275_;
            class354.anInt4346 += i_276_;
            ++class354.anInt4345;
         } else if (b == 1) {
            if (this.aClass272Array5775 == null) {
               this.aClass272Array5775 = new Class272[this.anInt5711];
            }

            Class272 class272 = this.aClass272Array5775[i] = new Class272();
            class272.anInt3484 = i_274_;
            class272.anInt3485 = i_275_;
            class272.anInt3483 = i_276_;
         }
      }
   }

   @Override
   final void method622(Class336 class336, EntityNode_Sub5 entitynode_sub5, int i, int i_278_) {
      this.method680(class336, entitynode_sub5, i, i_278_);
   }

   @Override
   final Class218[] method618() {
      return this.aClass218Array5764;
   }

   private final void method663() {
      synchronized(this) {
         for(int i = 0; i < this.anInt5753; ++i) {
            int i_279_ = this.anIntArray5748[i];
            this.anIntArray5748[i] = this.anIntArray5717[i];
            this.anIntArray5717[i] = -i_279_;
            if (this.aClass354Array5774[i] != null) {
               i_279_ = this.aClass354Array5774[i].anInt4347;
               this.aClass354Array5774[i].anInt4347 = this.aClass354Array5774[i].anInt4346;
               this.aClass354Array5774[i].anInt4346 = -i_279_;
            }
         }

         if (this.aClass272Array5775 != null) {
            for(int i = 0; i < this.anInt5711; ++i) {
               if (this.aClass272Array5775[i] != null) {
                  int i_280_ = this.aClass272Array5775[i].anInt3484;
                  this.aClass272Array5775[i].anInt3484 = this.aClass272Array5775[i].anInt3483;
                  this.aClass272Array5775[i].anInt3483 = -i_280_;
               }
            }
         }

         for(int i = this.anInt5753; i < this.anInt5718; ++i) {
            int i_281_ = this.anIntArray5748[i];
            this.anIntArray5748[i] = this.anIntArray5717[i];
            this.anIntArray5717[i] = -i_281_;
         }

         this.anInt5744 = 0;
         this.aBoolean5792 = false;
      }
   }

   @Override
   final void method619(DrawableModel drawablemodel, int i, int i_282_, int i_283_, boolean bool) {
      PureJavaDrawableModel purejavadrawablemodel_284_ = (PureJavaDrawableModel)drawablemodel;
      if ((this.anInt5746 & 65536) != 65536) {
         throw new IllegalStateException("");
      } else if ((purejavadrawablemodel_284_.anInt5746 & 65536) != 65536) {
         throw new IllegalStateException("");
      } else {
         this.method671(Thread.currentThread());
         this.method677();
         this.method675();
         purejavadrawablemodel_284_.method677();
         purejavadrawablemodel_284_.method675();
         ++anInt5780;
         int i_285_ = 0;
         int[] is = purejavadrawablemodel_284_.anIntArray5748;
         int i_286_ = purejavadrawablemodel_284_.anInt5753;

         for(int i_287_ = 0; i_287_ < this.anInt5753; ++i_287_) {
            Class354 class354 = this.aClass354Array5774[i_287_];
            if (class354.anInt4345 != 0) {
               int i_288_ = this.anIntArray5772[i_287_] - i_282_;
               if (i_288_ >= purejavadrawablemodel_284_.aShort5759 && i_288_ <= purejavadrawablemodel_284_.aShort5751) {
                  int i_289_ = this.anIntArray5748[i_287_] - i;
                  if (i_289_ >= purejavadrawablemodel_284_.aShort5757 && i_289_ <= purejavadrawablemodel_284_.aShort5766) {
                     int i_290_ = this.anIntArray5717[i_287_] - i_283_;
                     if (i_290_ >= purejavadrawablemodel_284_.aShort5732 && i_290_ <= purejavadrawablemodel_284_.aShort5730) {
                        for(int i_291_ = 0; i_291_ < i_286_; ++i_291_) {
                           Class354 class354_292_ = purejavadrawablemodel_284_.aClass354Array5774[i_291_];
                           if (i_289_ == is[i_291_]
                              && i_290_ == purejavadrawablemodel_284_.anIntArray5717[i_291_]
                              && i_288_ == purejavadrawablemodel_284_.anIntArray5772[i_291_]
                              && class354_292_.anInt4345 != 0) {
                              if (this.aClass354Array5735 == null) {
                                 this.aClass354Array5735 = new Class354[this.anInt5753];
                              }

                              if (purejavadrawablemodel_284_.aClass354Array5735 == null) {
                                 purejavadrawablemodel_284_.aClass354Array5735 = new Class354[i_286_];
                              }

                              Class354 class354_293_ = this.aClass354Array5735[i_287_];
                              if (class354_293_ == null) {
                                 class354_293_ = this.aClass354Array5735[i_287_] = new Class354(class354);
                              }

                              Class354 class354_294_ = purejavadrawablemodel_284_.aClass354Array5735[i_291_];
                              if (class354_294_ == null) {
                                 class354_294_ = purejavadrawablemodel_284_.aClass354Array5735[i_291_] = new Class354(class354_292_);
                              }

                              class354_293_.anInt4347 += class354_292_.anInt4347;
                              class354_293_.anInt4348 += class354_292_.anInt4348;
                              class354_293_.anInt4346 += class354_292_.anInt4346;
                              class354_293_.anInt4345 += class354_292_.anInt4345;
                              class354_294_.anInt4347 += class354.anInt4347;
                              class354_294_.anInt4348 += class354.anInt4348;
                              class354_294_.anInt4346 += class354.anInt4346;
                              class354_294_.anInt4345 += class354.anInt4345;
                              ++i_285_;
                              this.anIntArray5771[i_287_] = anInt5780;
                              this.anIntArray5749[i_291_] = anInt5780;
                           }
                        }
                     }
                  }
               }
            }
         }

         if (i_285_ >= 3 && bool) {
            for(int i_295_ = 0; i_295_ < this.anInt5711; ++i_295_) {
               if (this.anIntArray5771[this.aShortArray5767[i_295_]] == anInt5780
                  && this.anIntArray5771[this.aShortArray5731[i_295_]] == anInt5780
                  && this.anIntArray5771[this.aShortArray5789[i_295_]] == anInt5780) {
                  if (this.aByteArray5736 == null) {
                     this.aByteArray5736 = new byte[this.anInt5711];
                  }

                  this.aByteArray5736[i_295_] = 2;
               }
            }

            for(int i_296_ = 0; i_296_ < purejavadrawablemodel_284_.anInt5711; ++i_296_) {
               if (this.anIntArray5749[purejavadrawablemodel_284_.aShortArray5767[i_296_]] == anInt5780
                  && this.anIntArray5749[purejavadrawablemodel_284_.aShortArray5731[i_296_]] == anInt5780
                  && this.anIntArray5749[purejavadrawablemodel_284_.aShortArray5789[i_296_]] == anInt5780) {
                  if (purejavadrawablemodel_284_.aByteArray5736 == null) {
                     purejavadrawablemodel_284_.aByteArray5736 = new byte[purejavadrawablemodel_284_.anInt5711];
                  }

                  purejavadrawablemodel_284_.aByteArray5736[i_296_] = 2;
               }
            }
         }
      }
   }

   @Override
   final boolean F() {
      return this.aBoolean5720;
   }

   @Override
   final void H(int i, int i_297_, int i_298_) {
      if (i != 0 && (this.anInt5746 & 1) != 1) {
         throw new IllegalStateException();
      } else if (i_297_ != 0 && (this.anInt5746 & 2) != 2) {
         throw new IllegalStateException();
      } else if (i_298_ != 0 && (this.anInt5746 & 4) != 4) {
         throw new IllegalStateException();
      } else {
         synchronized(this) {
            for(int i_299_ = 0; i_299_ < this.anInt5718; ++i_299_) {
               this.anIntArray5748[i_299_] += i;
               this.anIntArray5772[i_299_] += i_297_;
               this.anIntArray5717[i_299_] += i_298_;
            }
         }
      }
   }

   @Override
   final void method637(int i, int[] is, int i_300_, int i_301_, int i_302_, int i_303_, boolean bool) {
      int i_304_ = is.length;
      if (i == 0) {
         i_300_ <<= 4;
         i_301_ <<= 4;
         i_302_ <<= 4;
         if (!this.aBoolean5723) {
            for(int i_305_ = 0; i_305_ < this.anInt5718; ++i_305_) {
               this.anIntArray5748[i_305_] <<= 4;
               this.anIntArray5772[i_305_] <<= 4;
               this.anIntArray5717[i_305_] <<= 4;
            }

            this.aBoolean5723 = true;
         }

         int i_306_ = 0;
         this.anInt5779 = 0;
         this.anInt5752 = 0;
         this.anInt5743 = 0;

         for(int i_307_ = 0; i_307_ < i_304_; ++i_307_) {
            int i_308_ = is[i_307_];
            if (i_308_ < this.anIntArrayArray5722.length) {
               int[] is_309_ = this.anIntArrayArray5722[i_308_];

               for(int i_310_ = 0; i_310_ < is_309_.length; ++i_310_) {
                  int i_311_ = is_309_[i_310_];
                  this.anInt5779 += this.anIntArray5748[i_311_];
                  this.anInt5752 += this.anIntArray5772[i_311_];
                  this.anInt5743 += this.anIntArray5717[i_311_];
                  ++i_306_;
               }
            }
         }

         if (i_306_ > 0) {
            this.anInt5779 = this.anInt5779 / i_306_ + i_300_;
            this.anInt5752 = this.anInt5752 / i_306_ + i_301_;
            this.anInt5743 = this.anInt5743 / i_306_ + i_302_;
         } else {
            this.anInt5779 = i_300_;
            this.anInt5752 = i_301_;
            this.anInt5743 = i_302_;
         }
      } else if (i == 1) {
         i_300_ <<= 4;
         i_301_ <<= 4;
         i_302_ <<= 4;
         if (!this.aBoolean5723) {
            for(int i_312_ = 0; i_312_ < this.anInt5718; ++i_312_) {
               this.anIntArray5748[i_312_] <<= 4;
               this.anIntArray5772[i_312_] <<= 4;
               this.anIntArray5717[i_312_] <<= 4;
            }

            this.aBoolean5723 = true;
         }

         for(int i_313_ = 0; i_313_ < i_304_; ++i_313_) {
            int i_314_ = is[i_313_];
            if (i_314_ < this.anIntArrayArray5722.length) {
               int[] is_315_ = this.anIntArrayArray5722[i_314_];

               for(int i_316_ = 0; i_316_ < is_315_.length; ++i_316_) {
                  int i_317_ = is_315_[i_316_];
                  this.anIntArray5748[i_317_] += i_300_;
                  this.anIntArray5772[i_317_] += i_301_;
                  this.anIntArray5717[i_317_] += i_302_;
               }
            }
         }
      } else if (i == 2) {
         for(int i_318_ = 0; i_318_ < i_304_; ++i_318_) {
            int i_319_ = is[i_318_];
            if (i_319_ < this.anIntArrayArray5722.length) {
               int[] is_320_ = this.anIntArrayArray5722[i_319_];
               if ((i_303_ & 1) == 0) {
                  for(int i_321_ = 0; i_321_ < is_320_.length; ++i_321_) {
                     int i_322_ = is_320_[i_321_];
                     this.anIntArray5748[i_322_] -= this.anInt5779;
                     this.anIntArray5772[i_322_] -= this.anInt5752;
                     this.anIntArray5717[i_322_] -= this.anInt5743;
                     if (i_302_ != 0) {
                        int i_323_ = Class335.anIntArray4167[i_302_];
                        int i_324_ = Class335.anIntArray4165[i_302_];
                        int i_325_ = this.anIntArray5772[i_322_] * i_323_ + this.anIntArray5748[i_322_] * i_324_ + 16383 >> 14;
                        this.anIntArray5772[i_322_] = this.anIntArray5772[i_322_] * i_324_ - this.anIntArray5748[i_322_] * i_323_ + 16383 >> 14;
                        this.anIntArray5748[i_322_] = i_325_;
                     }

                     if (i_300_ != 0) {
                        int i_326_ = Class335.anIntArray4167[i_300_];
                        int i_327_ = Class335.anIntArray4165[i_300_];
                        int i_328_ = this.anIntArray5772[i_322_] * i_327_ - this.anIntArray5717[i_322_] * i_326_ + 16383 >> 14;
                        this.anIntArray5717[i_322_] = this.anIntArray5772[i_322_] * i_326_ + this.anIntArray5717[i_322_] * i_327_ + 16383 >> 14;
                        this.anIntArray5772[i_322_] = i_328_;
                     }

                     if (i_301_ != 0) {
                        int i_329_ = Class335.anIntArray4167[i_301_];
                        int i_330_ = Class335.anIntArray4165[i_301_];
                        int i_331_ = this.anIntArray5717[i_322_] * i_329_ + this.anIntArray5748[i_322_] * i_330_ + 16383 >> 14;
                        this.anIntArray5717[i_322_] = this.anIntArray5717[i_322_] * i_330_ - this.anIntArray5748[i_322_] * i_329_ + 16383 >> 14;
                        this.anIntArray5748[i_322_] = i_331_;
                     }

                     this.anIntArray5748[i_322_] += this.anInt5779;
                     this.anIntArray5772[i_322_] += this.anInt5752;
                     this.anIntArray5717[i_322_] += this.anInt5743;
                  }
               } else {
                  for(int i_332_ = 0; i_332_ < is_320_.length; ++i_332_) {
                     int i_333_ = is_320_[i_332_];
                     this.anIntArray5748[i_333_] -= this.anInt5779;
                     this.anIntArray5772[i_333_] -= this.anInt5752;
                     this.anIntArray5717[i_333_] -= this.anInt5743;
                     if (i_300_ != 0) {
                        int i_334_ = Class335.anIntArray4167[i_300_];
                        int i_335_ = Class335.anIntArray4165[i_300_];
                        int i_336_ = this.anIntArray5772[i_333_] * i_335_ - this.anIntArray5717[i_333_] * i_334_ + 16383 >> 14;
                        this.anIntArray5717[i_333_] = this.anIntArray5772[i_333_] * i_334_ + this.anIntArray5717[i_333_] * i_335_ + 16383 >> 14;
                        this.anIntArray5772[i_333_] = i_336_;
                     }

                     if (i_302_ != 0) {
                        int i_337_ = Class335.anIntArray4167[i_302_];
                        int i_338_ = Class335.anIntArray4165[i_302_];
                        int i_339_ = this.anIntArray5772[i_333_] * i_337_ + this.anIntArray5748[i_333_] * i_338_ + 16383 >> 14;
                        this.anIntArray5772[i_333_] = this.anIntArray5772[i_333_] * i_338_ - this.anIntArray5748[i_333_] * i_337_ + 16383 >> 14;
                        this.anIntArray5748[i_333_] = i_339_;
                     }

                     if (i_301_ != 0) {
                        int i_340_ = Class335.anIntArray4167[i_301_];
                        int i_341_ = Class335.anIntArray4165[i_301_];
                        int i_342_ = this.anIntArray5717[i_333_] * i_340_ + this.anIntArray5748[i_333_] * i_341_ + 16383 >> 14;
                        this.anIntArray5717[i_333_] = this.anIntArray5717[i_333_] * i_341_ - this.anIntArray5748[i_333_] * i_340_ + 16383 >> 14;
                        this.anIntArray5748[i_333_] = i_342_;
                     }

                     this.anIntArray5748[i_333_] += this.anInt5779;
                     this.anIntArray5772[i_333_] += this.anInt5752;
                     this.anIntArray5717[i_333_] += this.anInt5743;
                  }
               }
            }
         }
      } else if (i == 3) {
         for(int i_343_ = 0; i_343_ < i_304_; ++i_343_) {
            int i_344_ = is[i_343_];
            if (i_344_ < this.anIntArrayArray5722.length) {
               int[] is_345_ = this.anIntArrayArray5722[i_344_];

               for(int i_346_ = 0; i_346_ < is_345_.length; ++i_346_) {
                  int i_347_ = is_345_[i_346_];
                  this.anIntArray5748[i_347_] -= this.anInt5779;
                  this.anIntArray5772[i_347_] -= this.anInt5752;
                  this.anIntArray5717[i_347_] -= this.anInt5743;
                  this.anIntArray5748[i_347_] = this.anIntArray5748[i_347_] * i_300_ / 128;
                  this.anIntArray5772[i_347_] = this.anIntArray5772[i_347_] * i_301_ / 128;
                  this.anIntArray5717[i_347_] = this.anIntArray5717[i_347_] * i_302_ / 128;
                  this.anIntArray5748[i_347_] += this.anInt5779;
                  this.anIntArray5772[i_347_] += this.anInt5752;
                  this.anIntArray5717[i_347_] += this.anInt5743;
               }
            }
         }
      } else if (i == 5) {
         if (this.anIntArrayArray5725 != null && this.aByteArray5784 != null) {
            for(int i_348_ = 0; i_348_ < i_304_; ++i_348_) {
               int i_349_ = is[i_348_];
               if (i_349_ < this.anIntArrayArray5725.length) {
                  int[] is_350_ = this.anIntArrayArray5725[i_349_];

                  for(int i_351_ = 0; i_351_ < is_350_.length; ++i_351_) {
                     int i_352_ = is_350_[i_351_];
                     int i_353_ = (this.aByteArray5784[i_352_] & 255) + i_300_ * 8;
                     if (i_353_ < 0) {
                        i_353_ = 0;
                     } else if (i_353_ > 255) {
                        i_353_ = 255;
                     }

                     this.aByteArray5784[i_352_] = (byte)i_353_;
                  }
               }
            }

            if (this.aClass209Array5790 != null) {
               for(int i_354_ = 0; i_354_ < this.anInt5762; ++i_354_) {
                  Class209 class209 = this.aClass209Array5790[i_354_];
                  Class214 class214 = this.aClass214Array5765[i_354_];
                  class214.anInt2519 = class214.anInt2519 & 16777215 | 255 - (this.aByteArray5784[class209.anInt2485] & 255) << 24;
               }
            }
         }
      } else if (i == 7) {
         if (this.anIntArrayArray5725 != null) {
            for(int i_355_ = 0; i_355_ < i_304_; ++i_355_) {
               int i_356_ = is[i_355_];
               if (i_356_ < this.anIntArrayArray5725.length) {
                  int[] is_357_ = this.anIntArrayArray5725[i_356_];

                  for(int i_358_ = 0; i_358_ < is_357_.length; ++i_358_) {
                     int i_359_ = is_357_[i_358_];
                     int i_360_ = this.aShortArray5740[i_359_] & '\uffff';
                     int i_361_ = i_360_ >> 10 & 63;
                     int i_362_ = i_360_ >> 7 & 7;
                     int i_363_ = i_360_ & 127;
                     i_361_ = i_361_ + i_300_ & 63;
                     i_362_ += i_301_;
                     if (i_362_ < 0) {
                        i_362_ = 0;
                     } else if (i_362_ > 7) {
                        i_362_ = 7;
                     }

                     i_363_ += i_302_;
                     if (i_363_ < 0) {
                        i_363_ = 0;
                     } else if (i_363_ > 127) {
                        i_363_ = 127;
                     }

                     this.aShortArray5740[i_359_] = (short)(i_361_ << 10 | i_362_ << 7 | i_363_);
                  }

                  this.aBoolean5786 = true;
               }
            }

            if (this.aClass209Array5790 != null) {
               for(int i_364_ = 0; i_364_ < this.anInt5762; ++i_364_) {
                  Class209 class209 = this.aClass209Array5790[i_364_];
                  Class214 class214 = this.aClass214Array5765[i_364_];
                  class214.anInt2519 = class214.anInt2519 & 0xFF000000
                     | Class170.anIntArray2054[Node_Sub15_Sub2.method2560(5310, this.aShortArray5740[class209.anInt2485] & '\uffff') & '\uffff'] & 16777215;
               }
            }
         }
      } else if (i == 8) {
         if (this.anIntArrayArray5783 != null) {
            for(int i_365_ = 0; i_365_ < i_304_; ++i_365_) {
               int i_366_ = is[i_365_];
               if (i_366_ < this.anIntArrayArray5783.length) {
                  int[] is_367_ = this.anIntArrayArray5783[i_366_];

                  for(int i_368_ = 0; i_368_ < is_367_.length; ++i_368_) {
                     Class214 class214 = this.aClass214Array5765[is_367_[i_368_]];
                     class214.anInt2516 += i_300_;
                     class214.anInt2523 += i_301_;
                  }
               }
            }
         }
      } else if (i == 10) {
         if (this.anIntArrayArray5783 != null) {
            for(int i_369_ = 0; i_369_ < i_304_; ++i_369_) {
               int i_370_ = is[i_369_];
               if (i_370_ < this.anIntArrayArray5783.length) {
                  int[] is_371_ = this.anIntArrayArray5783[i_370_];

                  for(int i_372_ = 0; i_372_ < is_371_.length; ++i_372_) {
                     Class214 class214 = this.aClass214Array5765[is_371_[i_372_]];
                     class214.anInt2517 = class214.anInt2517 * i_300_ >> 7;
                     class214.anInt2520 = class214.anInt2520 * i_301_ >> 7;
                  }
               }
            }
         }
      } else if (i == 9 && this.anIntArrayArray5783 != null) {
         for(int i_373_ = 0; i_373_ < i_304_; ++i_373_) {
            int i_374_ = is[i_373_];
            if (i_374_ < this.anIntArrayArray5783.length) {
               int[] is_375_ = this.anIntArrayArray5783[i_374_];

               for(int i_376_ = 0; i_376_ < is_375_.length; ++i_376_) {
                  Class214 class214 = this.aClass214Array5765[is_375_[i_376_]];
                  class214.anInt2525 = class214.anInt2525 + i_300_ & 16383;
               }
            }
         }
      }
   }

   private final void method664(boolean bool) {
      if (this.anInt5744 == 1) {
         this.method661();
      } else if (this.anInt5744 == 2) {
         if ((this.anInt5746 & 618648) == 0 && this.aFloatArrayArray5763 == null) {
            this.aShortArray5740 = null;
         }

         if (bool) {
            this.aByteArray5736 = null;
         }
      } else {
         this.method675();
         int i = this.aPureJavaToolkit5770.anInt6764;
         int i_377_ = this.aPureJavaToolkit5770.anInt6784;
         int i_378_ = this.aPureJavaToolkit5770.anInt6774;
         int i_379_ = this.aPureJavaToolkit5770.anInt6780 >> 8;
         int i_380_ = this.aPureJavaToolkit5770.anInt6766 * 768 / this.anInt5727;
         int i_381_ = this.aPureJavaToolkit5770.anInt6761 * 768 / this.anInt5727;
         if (this.anIntArray5754 == null) {
            this.anIntArray5754 = new int[this.anInt5711];
            this.anIntArray5739 = new int[this.anInt5711];
            this.anIntArray5761 = new int[this.anInt5711];
         }

         for(int i_382_ = 0; i_382_ < this.anInt5711; ++i_382_) {
            byte b;
            if (this.aByteArray5736 == null) {
               b = 0;
            } else {
               b = this.aByteArray5736[i_382_];
            }

            byte b_383_;
            if (this.aByteArray5784 == null) {
               b_383_ = 0;
            } else {
               b_383_ = this.aByteArray5784[i_382_];
            }

            short s;
            if (this.aShortArray5773 == null) {
               s = -1;
            } else {
               s = this.aShortArray5773[i_382_];
            }

            if (b_383_ == -2) {
               b = 3;
            }

            if (b_383_ == -1) {
               b = 2;
            }

            if (s == -1) {
               if (b == 0) {
                  int i_384_ = this.aShortArray5740[i_382_] & '\uffff';
                  int i_385_ = (i_384_ & 127) * this.anInt5791 >> 7;
                  short s_386_ = Node_Sub15_Sub2.method2560(5310, i_384_ & -128 | i_385_);
                  Class354 class354;
                  if (this.aClass354Array5735 != null && this.aClass354Array5735[this.aShortArray5767[i_382_]] != null) {
                     class354 = this.aClass354Array5735[this.aShortArray5767[i_382_]];
                  } else {
                     class354 = this.aClass354Array5774[this.aShortArray5767[i_382_]];
                  }

                  int i_387_ = (i * class354.anInt4347 + i_377_ * class354.anInt4348 + i_378_ * class354.anInt4346) / class354.anInt4345 >> 16;
                  int i_388_ = i_387_ > 256 ? i_380_ : i_381_;
                  int i_389_ = (i_379_ >> 1) + (i_388_ * i_387_ >> 17);
                  this.anIntArray5754[i_382_] = i_389_ << 17 | Node_Sub18.method2607((byte)31, i_389_, s_386_);
                  if (this.aClass354Array5735 != null && this.aClass354Array5735[this.aShortArray5731[i_382_]] != null) {
                     class354 = this.aClass354Array5735[this.aShortArray5731[i_382_]];
                  } else {
                     class354 = this.aClass354Array5774[this.aShortArray5731[i_382_]];
                  }

                  i_387_ = (i * class354.anInt4347 + i_377_ * class354.anInt4348 + i_378_ * class354.anInt4346) / class354.anInt4345 >> 16;
                  i_388_ = i_387_ > 256 ? i_380_ : i_381_;
                  i_389_ = (i_379_ >> 1) + (i_388_ * i_387_ >> 17);
                  this.anIntArray5739[i_382_] = i_389_ << 17 | Node_Sub18.method2607((byte)31, i_389_, s_386_);
                  if (this.aClass354Array5735 != null && this.aClass354Array5735[this.aShortArray5789[i_382_]] != null) {
                     class354 = this.aClass354Array5735[this.aShortArray5789[i_382_]];
                  } else {
                     class354 = this.aClass354Array5774[this.aShortArray5789[i_382_]];
                  }

                  i_387_ = (i * class354.anInt4347 + i_377_ * class354.anInt4348 + i_378_ * class354.anInt4346) / class354.anInt4345 >> 16;
                  i_388_ = i_387_ > 256 ? i_380_ : i_381_;
                  i_389_ = (i_379_ >> 1) + (i_388_ * i_387_ >> 17);
                  this.anIntArray5761[i_382_] = i_389_ << 17 | Node_Sub18.method2607((byte)31, i_389_, s_386_);
               } else if (b == 1) {
                  int i_390_ = this.aShortArray5740[i_382_] & '\uffff';
                  int i_391_ = (i_390_ & 127) * this.anInt5791 >> 7;
                  short s_392_ = Node_Sub15_Sub2.method2560(5310, i_390_ & -128 | i_391_);
                  Class272 class272 = this.aClass272Array5775[i_382_];
                  int i_393_ = i * class272.anInt3484 + i_377_ * class272.anInt3485 + i_378_ * class272.anInt3483 >> 16;
                  int i_394_ = i_393_ > 256 ? i_380_ : i_381_;
                  int i_395_ = (i_379_ >> 1) + (i_394_ * i_393_ >> 17);
                  this.anIntArray5754[i_382_] = i_395_ << 17 | Node_Sub18.method2607((byte)31, i_395_, s_392_);
                  this.anIntArray5761[i_382_] = -1;
               } else if (b == 3) {
                  this.anIntArray5754[i_382_] = 128;
                  this.anIntArray5761[i_382_] = -1;
               } else {
                  this.anIntArray5761[i_382_] = -2;
               }
            } else {
               int i_396_ = this.aShortArray5740[i_382_] & '\uffff';
               if (b == 0) {
                  Class354 class354;
                  if (this.aClass354Array5735 != null && this.aClass354Array5735[this.aShortArray5767[i_382_]] != null) {
                     class354 = this.aClass354Array5735[this.aShortArray5767[i_382_]];
                  } else {
                     class354 = this.aClass354Array5774[this.aShortArray5767[i_382_]];
                  }

                  int i_397_ = (i * class354.anInt4347 + i_377_ * class354.anInt4348 + i_378_ * class354.anInt4346) / class354.anInt4345 >> 16;
                  int i_398_ = i_397_ > 256 ? i_380_ : i_381_;
                  int i_399_ = this.method676((i_379_ >> 2) + (i_398_ * i_397_ >> 18));
                  this.anIntArray5754[i_382_] = i_399_ << 24 | this.method683(i_396_, s, i_399_);
                  if (this.aClass354Array5735 != null && this.aClass354Array5735[this.aShortArray5731[i_382_]] != null) {
                     class354 = this.aClass354Array5735[this.aShortArray5731[i_382_]];
                  } else {
                     class354 = this.aClass354Array5774[this.aShortArray5731[i_382_]];
                  }

                  i_397_ = (i * class354.anInt4347 + i_377_ * class354.anInt4348 + i_378_ * class354.anInt4346) / class354.anInt4345 >> 16;
                  i_398_ = i_397_ > 256 ? i_380_ : i_381_;
                  i_399_ = this.method676((i_379_ >> 2) + (i_398_ * i_397_ >> 18));
                  this.anIntArray5739[i_382_] = i_399_ << 24 | this.method683(i_396_, s, i_399_);
                  if (this.aClass354Array5735 != null && this.aClass354Array5735[this.aShortArray5789[i_382_]] != null) {
                     class354 = this.aClass354Array5735[this.aShortArray5789[i_382_]];
                  } else {
                     class354 = this.aClass354Array5774[this.aShortArray5789[i_382_]];
                  }

                  i_397_ = (i * class354.anInt4347 + i_377_ * class354.anInt4348 + i_378_ * class354.anInt4346) / class354.anInt4345 >> 16;
                  i_398_ = i_397_ > 256 ? i_380_ : i_381_;
                  i_399_ = this.method676((i_379_ >> 2) + (i_398_ * i_397_ >> 18));
                  this.anIntArray5761[i_382_] = i_399_ << 24 | this.method683(i_396_, s, i_399_);
               } else if (b == 1) {
                  Class272 class272 = this.aClass272Array5775[i_382_];
                  int i_400_ = i * class272.anInt3484 + i_377_ * class272.anInt3485 + i_378_ * class272.anInt3483 >> 16;
                  int i_401_ = i_400_ > 256 ? i_380_ : i_381_;
                  int i_402_ = this.method676((i_379_ >> 2) + (i_401_ * i_400_ >> 18));
                  this.anIntArray5754[i_382_] = i_402_ << 24 | this.method683(i_396_, s, i_402_);
                  this.anIntArray5761[i_382_] = -1;
               } else {
                  this.anIntArray5761[i_382_] = -2;
               }
            }
         }

         this.aClass354Array5774 = null;
         this.aClass354Array5735 = null;
         this.aClass272Array5775 = null;
         if ((this.anInt5746 & 618648) == 0 && this.aFloatArrayArray5763 == null) {
            this.aShortArray5740 = null;
         }

         if (bool) {
            this.aByteArray5736 = null;
         }

         this.anInt5744 = 2;
      }
   }

   @Override
   final void wa() {
      if (this.aBoolean5723) {
         for(int i = 0; i < this.anInt5718; ++i) {
            this.anIntArray5748[i] = this.anIntArray5748[i] + 7 >> 4;
            this.anIntArray5772[i] = this.anIntArray5772[i] + 7 >> 4;
            this.anIntArray5717[i] = this.anIntArray5717[i] + 7 >> 4;
         }

         this.aBoolean5723 = false;
      }

      if (this.aBoolean5786) {
         this.method661();
         this.aBoolean5786 = false;
      }

      this.aBoolean5792 = false;
   }

   private final boolean method665(int i, int i_403_, Class336 class336, boolean bool, int i_404_, int i_405_) {
      this.aClass336_Sub2_5778 = (Class336_Sub2)class336;
      Class336_Sub2 class336_sub2 = this.aPureJavaToolkit5770.aClass336_Sub2_6788;
      float f = class336_sub2.aFloat8583
         + class336_sub2.aFloat8580 * this.aClass336_Sub2_5778.aFloat8583
         + class336_sub2.aFloat8571 * this.aClass336_Sub2_5778.aFloat8579
         + class336_sub2.aFloat8566 * this.aClass336_Sub2_5778.aFloat8589;
      float f_406_ = class336_sub2.aFloat8579
         + class336_sub2.aFloat8578 * this.aClass336_Sub2_5778.aFloat8583
         + class336_sub2.aFloat8561 * this.aClass336_Sub2_5778.aFloat8579
         + class336_sub2.aFloat8558 * this.aClass336_Sub2_5778.aFloat8589;
      float f_407_ = class336_sub2.aFloat8589
         + class336_sub2.aFloat8577 * this.aClass336_Sub2_5778.aFloat8583
         + class336_sub2.aFloat8567 * this.aClass336_Sub2_5778.aFloat8579
         + class336_sub2.aFloat8584 * this.aClass336_Sub2_5778.aFloat8589;
      float f_408_ = class336_sub2.aFloat8580 * this.aClass336_Sub2_5778.aFloat8580
         + class336_sub2.aFloat8571 * this.aClass336_Sub2_5778.aFloat8578
         + class336_sub2.aFloat8566 * this.aClass336_Sub2_5778.aFloat8577;
      float f_409_ = class336_sub2.aFloat8580 * this.aClass336_Sub2_5778.aFloat8571
         + class336_sub2.aFloat8571 * this.aClass336_Sub2_5778.aFloat8561
         + class336_sub2.aFloat8566 * this.aClass336_Sub2_5778.aFloat8567;
      float f_410_ = class336_sub2.aFloat8580 * this.aClass336_Sub2_5778.aFloat8566
         + class336_sub2.aFloat8571 * this.aClass336_Sub2_5778.aFloat8558
         + class336_sub2.aFloat8566 * this.aClass336_Sub2_5778.aFloat8584;
      float f_411_ = class336_sub2.aFloat8578 * this.aClass336_Sub2_5778.aFloat8580
         + class336_sub2.aFloat8561 * this.aClass336_Sub2_5778.aFloat8578
         + class336_sub2.aFloat8558 * this.aClass336_Sub2_5778.aFloat8577;
      float f_412_ = class336_sub2.aFloat8578 * this.aClass336_Sub2_5778.aFloat8571
         + class336_sub2.aFloat8561 * this.aClass336_Sub2_5778.aFloat8561
         + class336_sub2.aFloat8558 * this.aClass336_Sub2_5778.aFloat8567;
      float f_413_ = class336_sub2.aFloat8578 * this.aClass336_Sub2_5778.aFloat8566
         + class336_sub2.aFloat8561 * this.aClass336_Sub2_5778.aFloat8558
         + class336_sub2.aFloat8558 * this.aClass336_Sub2_5778.aFloat8584;
      float f_414_ = class336_sub2.aFloat8577 * this.aClass336_Sub2_5778.aFloat8580
         + class336_sub2.aFloat8567 * this.aClass336_Sub2_5778.aFloat8578
         + class336_sub2.aFloat8584 * this.aClass336_Sub2_5778.aFloat8577;
      float f_415_ = class336_sub2.aFloat8577 * this.aClass336_Sub2_5778.aFloat8571
         + class336_sub2.aFloat8567 * this.aClass336_Sub2_5778.aFloat8561
         + class336_sub2.aFloat8584 * this.aClass336_Sub2_5778.aFloat8567;
      float f_416_ = class336_sub2.aFloat8577 * this.aClass336_Sub2_5778.aFloat8566
         + class336_sub2.aFloat8567 * this.aClass336_Sub2_5778.aFloat8558
         + class336_sub2.aFloat8584 * this.aClass336_Sub2_5778.aFloat8584;
      boolean bool_417_ = false;
      int i_418_ = this.aPureJavaToolkit5770.anInt6786;
      int i_419_ = this.aPureJavaToolkit5770.anInt6769;
      int i_420_ = this.aPureJavaToolkit5770.anInt6785;
      int i_421_ = this.aPureJavaToolkit5770.anInt6763;
      int i_422_ = Integer.MAX_VALUE;
      int i_423_ = Integer.MIN_VALUE;
      int i_424_ = Integer.MAX_VALUE;
      int i_425_ = Integer.MIN_VALUE;
      this.method671(Thread.currentThread());
      if (!this.aBoolean5792) {
         this.method677();
      }

      int i_426_ = this.aShort5766 - this.aShort5757 >> 1;
      int i_427_ = this.aShort5751 - this.aShort5759 >> 1;
      int i_428_ = this.aShort5730 - this.aShort5732 >> 1;
      int i_429_ = this.aShort5757 + i_426_;
      int i_430_ = this.aShort5759 + i_427_;
      int i_431_ = this.aShort5732 + i_428_;
      int i_432_ = i_429_ - (i_426_ << i_404_);
      int i_433_ = i_430_ - (i_427_ << i_404_);
      int i_434_ = i_431_ - (i_428_ << i_404_);
      int i_435_ = i_429_ + (i_426_ << i_404_);
      int i_436_ = i_430_ + (i_427_ << i_404_);
      int i_437_ = i_431_ + (i_428_ << i_404_);
      this.anIntArray5737[0] = i_432_;
      this.anIntArray5745[0] = i_433_;
      this.anIntArray5729[0] = i_434_;
      this.anIntArray5737[1] = i_435_;
      this.anIntArray5745[1] = i_433_;
      this.anIntArray5729[1] = i_434_;
      this.anIntArray5737[2] = i_432_;
      this.anIntArray5745[2] = i_436_;
      this.anIntArray5729[2] = i_434_;
      this.anIntArray5737[3] = i_435_;
      this.anIntArray5745[3] = i_436_;
      this.anIntArray5729[3] = i_434_;
      this.anIntArray5737[4] = i_432_;
      this.anIntArray5745[4] = i_433_;
      this.anIntArray5729[4] = i_437_;
      this.anIntArray5737[5] = i_435_;
      this.anIntArray5745[5] = i_433_;
      this.anIntArray5729[5] = i_437_;
      this.anIntArray5737[6] = i_432_;
      this.anIntArray5745[6] = i_436_;
      this.anIntArray5729[6] = i_437_;
      this.anIntArray5737[7] = i_435_;
      this.anIntArray5745[7] = i_436_;
      this.anIntArray5729[7] = i_437_;

      for(int i_438_ = 0; i_438_ < 8; ++i_438_) {
         int i_439_ = this.anIntArray5737[i_438_];
         int i_440_ = this.anIntArray5745[i_438_];
         int i_441_ = this.anIntArray5729[i_438_];
         float f_442_ = f + f_408_ * (float)i_439_ + f_409_ * (float)i_440_ + f_410_ * (float)i_441_;
         float f_443_ = f_406_ + f_411_ * (float)i_439_ + f_412_ * (float)i_440_ + f_413_ * (float)i_441_;
         float f_444_ = f_407_ + f_414_ * (float)i_439_ + f_415_ * (float)i_440_ + f_416_ * (float)i_441_;
         if (f_444_ >= (float)this.aPureJavaToolkit5770.anInt6798) {
            if (i_405_ > 0) {
               f_444_ = (float)i_405_;
            }

            int i_445_ = i_418_ + (int)(f_442_ * (float)i_420_ / f_444_);
            int i_446_ = i_419_ + (int)(f_443_ * (float)i_421_ / f_444_);
            if (i_445_ < i_422_) {
               i_422_ = i_445_;
            }

            if (i_445_ > i_423_) {
               i_423_ = i_445_;
            }

            if (i_446_ < i_424_) {
               i_424_ = i_446_;
            }

            if (i_446_ > i_425_) {
               i_425_ = i_446_;
            }

            bool_417_ = true;
         }
      }

      if (bool_417_ && i > i_422_ && i < i_423_ && i_403_ > i_424_ && i_403_ < i_425_) {
         if (bool) {
            return true;
         }

         for(int i_447_ = 0; i_447_ < this.anInt5718; ++i_447_) {
            int i_448_ = this.anIntArray5748[i_447_];
            int i_449_ = this.anIntArray5772[i_447_];
            int i_450_ = this.anIntArray5717[i_447_];
            float f_451_ = f + f_408_ * (float)i_448_ + f_409_ * (float)i_449_ + f_410_ * (float)i_450_;
            float f_452_ = f_406_ + f_411_ * (float)i_448_ + f_412_ * (float)i_449_ + f_413_ * (float)i_450_;
            float f_453_ = f_407_ + f_414_ * (float)i_448_ + f_415_ * (float)i_449_ + f_416_ * (float)i_450_;
            if (f_453_ >= (float)this.aPureJavaToolkit5770.anInt6798) {
               if (i_405_ > 0) {
                  f_453_ = (float)i_405_;
               }

               this.anIntArray5713[i_447_] = i_418_ + (int)(f_451_ * (float)i_420_ / f_453_);
               this.anIntArray5716[i_447_] = i_419_ + (int)(f_452_ * (float)i_421_ / f_453_);
            } else {
               this.anIntArray5713[i_447_] = -999999;
            }
         }

         for(int i_454_ = 0; i_454_ < this.anInt5711; ++i_454_) {
            if (this.anIntArray5713[this.aShortArray5767[i_454_]] != -999999
               && this.anIntArray5713[this.aShortArray5731[i_454_]] != -999999
               && this.anIntArray5713[this.aShortArray5789[i_454_]] != -999999
               && this.method672(
                  i,
                  i_403_,
                  this.anIntArray5716[this.aShortArray5767[i_454_]],
                  this.anIntArray5716[this.aShortArray5731[i_454_]],
                  this.anIntArray5716[this.aShortArray5789[i_454_]],
                  this.anIntArray5713[this.aShortArray5767[i_454_]],
                  this.anIntArray5713[this.aShortArray5731[i_454_]],
                  this.anIntArray5713[this.aShortArray5789[i_454_]]
               )) {
               return true;
            }
         }
      }

      return false;
   }

   private final DrawableModel method666(
      PureJavaDrawableModel purejavadrawablemodel_455_, PureJavaDrawableModel purejavadrawablemodel_456_, int i, boolean bool, boolean bool_457_
   ) {
      purejavadrawablemodel_455_.aBoolean5792 = this.aBoolean5792;
      if (this.aBoolean5792) {
         purejavadrawablemodel_455_.aShort5766 = this.aShort5766;
         purejavadrawablemodel_455_.aShort5751 = this.aShort5751;
         purejavadrawablemodel_455_.aShort5730 = this.aShort5730;
         purejavadrawablemodel_455_.aShort5757 = this.aShort5757;
         purejavadrawablemodel_455_.aShort5759 = this.aShort5759;
         purejavadrawablemodel_455_.aShort5732 = this.aShort5732;
         purejavadrawablemodel_455_.aShort5777 = this.aShort5777;
         purejavadrawablemodel_455_.aShort5755 = this.aShort5755;
      }

      purejavadrawablemodel_455_.anInt5791 = this.anInt5791;
      purejavadrawablemodel_455_.anInt5727 = this.anInt5727;
      purejavadrawablemodel_455_.anInt5718 = this.anInt5718;
      purejavadrawablemodel_455_.anInt5753 = this.anInt5753;
      purejavadrawablemodel_455_.anInt5711 = this.anInt5711;
      purejavadrawablemodel_455_.anInt5762 = this.anInt5762;
      if ((i & 256) != 0) {
         purejavadrawablemodel_455_.aBoolean5720 = true;
      } else {
         purejavadrawablemodel_455_.aBoolean5720 = this.aBoolean5720;
      }

      purejavadrawablemodel_455_.aBoolean5788 = this.aBoolean5788;
      boolean bool_458_ = (i & 7) == 7 | (i & 32) != 0;
      boolean bool_459_ = bool_458_ || (i & 1) != 0;
      boolean bool_460_ = bool_458_ || (i & 2) != 0;
      boolean bool_461_ = bool_458_ || (i & 4) != 0 || (i & 16) != 0;
      if (!bool_459_ && !bool_460_ && !bool_461_) {
         purejavadrawablemodel_455_.anIntArray5748 = this.anIntArray5748;
         purejavadrawablemodel_455_.anIntArray5772 = this.anIntArray5772;
         purejavadrawablemodel_455_.anIntArray5717 = this.anIntArray5717;
      } else {
         if (!bool_459_) {
            purejavadrawablemodel_455_.anIntArray5748 = this.anIntArray5748;
         } else {
            if (purejavadrawablemodel_456_.anIntArray5748 != null && purejavadrawablemodel_456_.anIntArray5748.length >= this.anInt5718) {
               purejavadrawablemodel_455_.anIntArray5748 = purejavadrawablemodel_456_.anIntArray5748;
            } else {
               purejavadrawablemodel_455_.anIntArray5748 = purejavadrawablemodel_456_.anIntArray5748 = new int[this.anInt5718];
            }

            for(int i_462_ = 0; i_462_ < this.anInt5718; ++i_462_) {
               purejavadrawablemodel_455_.anIntArray5748[i_462_] = this.anIntArray5748[i_462_];
            }
         }

         if (!bool_460_) {
            purejavadrawablemodel_455_.anIntArray5772 = this.anIntArray5772;
         } else {
            if (purejavadrawablemodel_456_.anIntArray5772 != null && purejavadrawablemodel_456_.anIntArray5772.length >= this.anInt5718) {
               purejavadrawablemodel_455_.anIntArray5772 = purejavadrawablemodel_456_.anIntArray5772;
            } else {
               purejavadrawablemodel_455_.anIntArray5772 = purejavadrawablemodel_456_.anIntArray5772 = new int[this.anInt5718];
            }

            for(int i_463_ = 0; i_463_ < this.anInt5718; ++i_463_) {
               purejavadrawablemodel_455_.anIntArray5772[i_463_] = this.anIntArray5772[i_463_];
            }
         }

         if (bool_461_) {
            if (purejavadrawablemodel_456_.anIntArray5717 != null && purejavadrawablemodel_456_.anIntArray5717.length >= this.anInt5718) {
               purejavadrawablemodel_455_.anIntArray5717 = purejavadrawablemodel_456_.anIntArray5717;
            } else {
               purejavadrawablemodel_455_.anIntArray5717 = purejavadrawablemodel_456_.anIntArray5717 = new int[this.anInt5718];
            }

            for(int i_464_ = 0; i_464_ < this.anInt5718; ++i_464_) {
               purejavadrawablemodel_455_.anIntArray5717[i_464_] = this.anIntArray5717[i_464_];
            }
         } else {
            purejavadrawablemodel_455_.anIntArray5717 = this.anIntArray5717;
         }
      }

      if ((i & 540800) != 0) {
         if (purejavadrawablemodel_456_.aShortArray5740 != null && purejavadrawablemodel_456_.aShortArray5740.length >= this.anInt5711) {
            purejavadrawablemodel_455_.aShortArray5740 = purejavadrawablemodel_456_.aShortArray5740;
         } else {
            int i_465_ = this.anInt5711;
            purejavadrawablemodel_455_.aShortArray5740 = purejavadrawablemodel_456_.aShortArray5740 = new short[i_465_];
         }

         for(int i_466_ = 0; i_466_ < this.anInt5711; ++i_466_) {
            purejavadrawablemodel_455_.aShortArray5740[i_466_] = this.aShortArray5740[i_466_];
         }
      } else {
         purejavadrawablemodel_455_.aShortArray5740 = this.aShortArray5740;
      }

      if ((i & 618520) != 0) {
         purejavadrawablemodel_455_.anInt5744 = 0;
         purejavadrawablemodel_455_.anIntArray5754 = purejavadrawablemodel_455_.anIntArray5739 = purejavadrawablemodel_455_.anIntArray5761 = null;
      } else if ((i & 128) != 0) {
         if (bool_457_) {
            this.method655(false);
         }

         if (this.anIntArray5754 != null) {
            if (purejavadrawablemodel_456_.anIntArray5754 != null && purejavadrawablemodel_456_.anIntArray5754.length >= this.anInt5711) {
               purejavadrawablemodel_455_.anIntArray5754 = purejavadrawablemodel_456_.anIntArray5754;
               purejavadrawablemodel_455_.anIntArray5739 = purejavadrawablemodel_456_.anIntArray5739;
               purejavadrawablemodel_455_.anIntArray5761 = purejavadrawablemodel_456_.anIntArray5761;
            } else {
               int i_467_ = this.anInt5711;
               purejavadrawablemodel_455_.anIntArray5754 = purejavadrawablemodel_456_.anIntArray5754 = new int[i_467_];
               purejavadrawablemodel_455_.anIntArray5739 = purejavadrawablemodel_456_.anIntArray5739 = new int[i_467_];
               purejavadrawablemodel_455_.anIntArray5761 = purejavadrawablemodel_456_.anIntArray5761 = new int[i_467_];
            }

            for(int i_468_ = 0; i_468_ < this.anInt5711; ++i_468_) {
               purejavadrawablemodel_455_.anIntArray5754[i_468_] = this.anIntArray5754[i_468_];
               purejavadrawablemodel_455_.anIntArray5739[i_468_] = this.anIntArray5739[i_468_];
               purejavadrawablemodel_455_.anIntArray5761[i_468_] = this.anIntArray5761[i_468_];
            }
         }

         purejavadrawablemodel_455_.anInt5744 = this.anInt5744;
      } else {
         if (bool_457_) {
            this.method655(false);
         }

         purejavadrawablemodel_455_.anIntArray5754 = this.anIntArray5754;
         purejavadrawablemodel_455_.anIntArray5739 = this.anIntArray5739;
         purejavadrawablemodel_455_.anIntArray5761 = this.anIntArray5761;
         purejavadrawablemodel_455_.anInt5744 = this.anInt5744;
      }

      if ((i & 256) != 0) {
         if (purejavadrawablemodel_456_.aByteArray5784 != null && purejavadrawablemodel_456_.aByteArray5784.length >= this.anInt5711) {
            purejavadrawablemodel_455_.aByteArray5784 = purejavadrawablemodel_456_.aByteArray5784;
         } else {
            int i_469_ = this.anInt5711;
            purejavadrawablemodel_455_.aByteArray5784 = purejavadrawablemodel_456_.aByteArray5784 = new byte[i_469_];
         }

         if (this.aByteArray5784 != null) {
            for(int i_470_ = 0; i_470_ < this.anInt5711; ++i_470_) {
               purejavadrawablemodel_455_.aByteArray5784[i_470_] = this.aByteArray5784[i_470_];
            }
         } else {
            for(int i_471_ = 0; i_471_ < this.anInt5711; ++i_471_) {
               purejavadrawablemodel_455_.aByteArray5784[i_471_] = 0;
            }
         }
      } else {
         purejavadrawablemodel_455_.aByteArray5784 = this.aByteArray5784;
      }

      if ((i & 8) == 0 && (i & 16) == 0) {
         if (bool_457_) {
            this.method675();
         }

         purejavadrawablemodel_455_.aClass354Array5774 = this.aClass354Array5774;
         purejavadrawablemodel_455_.aClass272Array5775 = this.aClass272Array5775;
      } else {
         if (purejavadrawablemodel_456_.aClass354Array5774 != null && purejavadrawablemodel_456_.aClass354Array5774.length >= this.anInt5753) {
            purejavadrawablemodel_455_.aClass354Array5774 = purejavadrawablemodel_456_.aClass354Array5774;
         } else {
            int i_472_ = this.anInt5753;
            purejavadrawablemodel_455_.aClass354Array5774 = purejavadrawablemodel_456_.aClass354Array5774 = new Class354[i_472_];
         }

         if (this.aClass354Array5774 != null) {
            for(int i_473_ = 0; i_473_ < this.anInt5753; ++i_473_) {
               purejavadrawablemodel_455_.aClass354Array5774[i_473_] = new Class354(this.aClass354Array5774[i_473_]);
            }
         } else {
            purejavadrawablemodel_455_.aClass354Array5774 = null;
         }

         if (this.aClass272Array5775 != null) {
            if (purejavadrawablemodel_456_.aClass272Array5775 != null && purejavadrawablemodel_456_.aClass272Array5775.length >= this.anInt5711) {
               purejavadrawablemodel_455_.aClass272Array5775 = purejavadrawablemodel_456_.aClass272Array5775;
            } else {
               int i_474_ = this.anInt5711;
               purejavadrawablemodel_455_.aClass272Array5775 = purejavadrawablemodel_456_.aClass272Array5775 = new Class272[i_474_];
            }

            for(int i_475_ = 0; i_475_ < this.anInt5711; ++i_475_) {
               purejavadrawablemodel_455_.aClass272Array5775[i_475_] = this.aClass272Array5775[i_475_] != null
                  ? new Class272(this.aClass272Array5775[i_475_])
                  : null;
            }
         } else {
            purejavadrawablemodel_455_.aClass272Array5775 = null;
         }
      }

      if ((i & 32768) != 0) {
         if (this.aShortArray5773 == null) {
            purejavadrawablemodel_455_.aShortArray5773 = null;
         } else {
            if (purejavadrawablemodel_456_.aShortArray5773 != null && purejavadrawablemodel_456_.aShortArray5773.length >= this.anInt5711) {
               purejavadrawablemodel_455_.aShortArray5773 = purejavadrawablemodel_456_.aShortArray5773;
            } else {
               int i_476_ = this.anInt5711;
               purejavadrawablemodel_455_.aShortArray5773 = purejavadrawablemodel_456_.aShortArray5773 = new short[i_476_];
            }

            for(int i_477_ = 0; i_477_ < this.anInt5711; ++i_477_) {
               purejavadrawablemodel_455_.aShortArray5773[i_477_] = this.aShortArray5773[i_477_];
            }
         }
      } else {
         purejavadrawablemodel_455_.aShortArray5773 = this.aShortArray5773;
      }

      if ((i & 65536) != 0) {
         if (this.aByteArray5736 == null) {
            purejavadrawablemodel_455_.aByteArray5736 = null;
         } else {
            if (purejavadrawablemodel_456_.aByteArray5736 != null && purejavadrawablemodel_456_.aByteArray5736.length >= this.anInt5711) {
               purejavadrawablemodel_455_.aByteArray5736 = purejavadrawablemodel_456_.aByteArray5736;
            } else {
               int i_478_ = bool ? this.anInt5711 + 100 : this.anInt5711;
               purejavadrawablemodel_455_.aByteArray5736 = purejavadrawablemodel_456_.aByteArray5736 = new byte[i_478_];
            }

            for(int i_479_ = 0; i_479_ < this.anInt5711; ++i_479_) {
               purejavadrawablemodel_455_.aByteArray5736[i_479_] = this.aByteArray5736[i_479_];
            }
         }
      } else {
         purejavadrawablemodel_455_.aByteArray5736 = this.aByteArray5736;
      }

      if ((i & 50560) != 0) {
         if (purejavadrawablemodel_456_.aClass214Array5765 != null && purejavadrawablemodel_456_.aClass214Array5765.length >= this.anInt5762) {
            purejavadrawablemodel_455_.aClass214Array5765 = purejavadrawablemodel_456_.aClass214Array5765;

            for(int i_482_ = 0; i_482_ < this.anInt5762; ++i_482_) {
               purejavadrawablemodel_455_.aClass214Array5765[i_482_].method2058(this.aClass214Array5765[i_482_], 84);
            }
         } else {
            int i_480_ = this.anInt5762;
            purejavadrawablemodel_455_.aClass214Array5765 = purejavadrawablemodel_456_.aClass214Array5765 = new Class214[i_480_];

            for(int i_481_ = 0; i_481_ < this.anInt5762; ++i_481_) {
               purejavadrawablemodel_455_.aClass214Array5765[i_481_] = this.aClass214Array5765[i_481_].method2059((byte)-90);
            }
         }
      } else {
         purejavadrawablemodel_455_.aClass214Array5765 = this.aClass214Array5765;
      }

      if (this.aFloatArrayArray5763 != null && (i & 16) != 0) {
         if (purejavadrawablemodel_456_.aFloatArrayArray5763 != null && purejavadrawablemodel_456_.aFloatArrayArray5763.length >= this.anInt5711) {
            purejavadrawablemodel_455_.aFloatArrayArray5763 = purejavadrawablemodel_456_.aFloatArrayArray5763;
         } else {
            int i_483_ = bool ? this.anInt5711 + 100 : this.anInt5711;
            purejavadrawablemodel_455_.aFloatArrayArray5763 = purejavadrawablemodel_456_.aFloatArrayArray5763 = new float[i_483_][3];
         }

         for(int i_484_ = 0; i_484_ < this.anInt5711; ++i_484_) {
            if (this.aFloatArrayArray5763[i_484_] != null) {
               purejavadrawablemodel_455_.aFloatArrayArray5763[i_484_][0] = this.aFloatArrayArray5763[i_484_][0];
               purejavadrawablemodel_455_.aFloatArrayArray5763[i_484_][1] = this.aFloatArrayArray5763[i_484_][1];
               purejavadrawablemodel_455_.aFloatArrayArray5763[i_484_][2] = this.aFloatArrayArray5763[i_484_][2];
            }
         }

         if (purejavadrawablemodel_456_.aFloatArrayArray5776 != null && purejavadrawablemodel_456_.aFloatArrayArray5776.length >= this.anInt5711) {
            purejavadrawablemodel_455_.aFloatArrayArray5776 = purejavadrawablemodel_456_.aFloatArrayArray5776;
         } else {
            int i_485_ = bool ? this.anInt5711 + 100 : this.anInt5711;
            purejavadrawablemodel_455_.aFloatArrayArray5776 = purejavadrawablemodel_456_.aFloatArrayArray5776 = new float[i_485_][3];
         }

         for(int i_486_ = 0; i_486_ < this.anInt5711; ++i_486_) {
            if (this.aFloatArrayArray5776[i_486_] != null) {
               purejavadrawablemodel_455_.aFloatArrayArray5776[i_486_][0] = this.aFloatArrayArray5776[i_486_][0];
               purejavadrawablemodel_455_.aFloatArrayArray5776[i_486_][1] = this.aFloatArrayArray5776[i_486_][1];
               purejavadrawablemodel_455_.aFloatArrayArray5776[i_486_][2] = this.aFloatArrayArray5776[i_486_][2];
            }
         }
      } else {
         purejavadrawablemodel_455_.aFloatArrayArray5763 = this.aFloatArrayArray5763;
         purejavadrawablemodel_455_.aFloatArrayArray5776 = this.aFloatArrayArray5776;
      }

      purejavadrawablemodel_455_.anIntArrayArray5722 = this.anIntArrayArray5722;
      purejavadrawablemodel_455_.anIntArrayArray5725 = this.anIntArrayArray5725;
      purejavadrawablemodel_455_.anIntArrayArray5783 = this.anIntArrayArray5783;
      purejavadrawablemodel_455_.aShortArray5747 = this.aShortArray5747;
      purejavadrawablemodel_455_.aShortArray5787 = this.aShortArray5787;
      purejavadrawablemodel_455_.aByteArray5768 = this.aByteArray5768;
      purejavadrawablemodel_455_.aShortArray5767 = this.aShortArray5767;
      purejavadrawablemodel_455_.aShortArray5731 = this.aShortArray5731;
      purejavadrawablemodel_455_.aShortArray5789 = this.aShortArray5789;
      purejavadrawablemodel_455_.aClass300Array5782 = this.aClass300Array5782;
      purejavadrawablemodel_455_.aClass218Array5764 = this.aClass218Array5764;
      purejavadrawablemodel_455_.aClass209Array5790 = this.aClass209Array5790;
      purejavadrawablemodel_455_.aShortArray5719 = this.aShortArray5719;
      purejavadrawablemodel_455_.anInt5746 = i;
      return purejavadrawablemodel_455_;
   }

   private final void method667() {
      synchronized(this) {
         for(int i = 0; i < this.anInt5718; ++i) {
            int i_487_ = this.anIntArray5717[i];
            this.anIntArray5717[i] = this.anIntArray5748[i];
            this.anIntArray5748[i] = -i_487_;
         }

         this.method656();
      }
   }

   @Override
   final void k(int i) {
      if ((this.anInt5746 & 13) != 13) {
         throw new IllegalStateException();
      } else {
         if (this.aClass354Array5774 != null) {
            if (i == 4096) {
               this.method663();
            } else if (i == 8192) {
               this.method682();
            } else if (i == 12288) {
               this.method684();
            } else {
               int i_488_ = Class335.anIntArray4167[i];
               int i_489_ = Class335.anIntArray4165[i];
               synchronized(this) {
                  for(int i_490_ = 0; i_490_ < this.anInt5753; ++i_490_) {
                     int i_491_ = this.anIntArray5717[i_490_] * i_488_ + this.anIntArray5748[i_490_] * i_489_ >> 14;
                     this.anIntArray5717[i_490_] = this.anIntArray5717[i_490_] * i_489_ - this.anIntArray5748[i_490_] * i_488_ >> 14;
                     this.anIntArray5748[i_490_] = i_491_;
                     if (this.aClass354Array5774[i_490_] != null) {
                        i_491_ = this.aClass354Array5774[i_490_].anInt4346 * i_488_ + this.aClass354Array5774[i_490_].anInt4347 * i_489_ >> 14;
                        this.aClass354Array5774[i_490_].anInt4346 = this.aClass354Array5774[i_490_].anInt4346 * i_489_
                              - this.aClass354Array5774[i_490_].anInt4347 * i_488_
                           >> 14;
                        this.aClass354Array5774[i_490_].anInt4347 = i_491_;
                     }
                  }

                  if (this.aClass272Array5775 != null) {
                     for(int i_492_ = 0; i_492_ < this.anInt5711; ++i_492_) {
                        if (this.aClass272Array5775[i_492_] != null) {
                           int i_493_ = this.aClass272Array5775[i_492_].anInt3483 * i_488_ + this.aClass272Array5775[i_492_].anInt3484 * i_489_ >> 14;
                           this.aClass272Array5775[i_492_].anInt3483 = this.aClass272Array5775[i_492_].anInt3483 * i_489_
                                 - this.aClass272Array5775[i_492_].anInt3484 * i_488_
                              >> 14;
                           this.aClass272Array5775[i_492_].anInt3484 = i_493_;
                        }
                     }
                  }

                  for(int i_494_ = this.anInt5753; i_494_ < this.anInt5718; ++i_494_) {
                     int i_495_ = this.anIntArray5717[i_494_] * i_488_ + this.anIntArray5748[i_494_] * i_489_ >> 14;
                     this.anIntArray5717[i_494_] = this.anIntArray5717[i_494_] * i_489_ - this.anIntArray5748[i_494_] * i_488_ >> 14;
                     this.anIntArray5748[i_494_] = i_495_;
                  }

                  this.anInt5744 = 0;
                  this.aBoolean5792 = false;
               }
            }
         } else {
            this.a(i);
         }
      }
   }

   private final void method668(boolean bool, boolean bool_496_, int i, int i_497_) {
      Class209 class209;
      if (this.aClass209Array5790 != null) {
         for(int i_498_ = 0; i_498_ < this.anInt5762; this.anIntArray5756[class209.anInt2485] = i_498_++) {
            class209 = this.aClass209Array5790[i_498_];
         }
      }

      if (!this.aBoolean5720 && this.aClass209Array5790 == null) {
         for(int i_504_ = 0; i_504_ < this.anInt5711; ++i_504_) {
            this.method660(i_504_, bool, bool_496_);
         }
      } else if ((this.anInt5746 & 256) == 0 && this.aShortArray5719 != null) {
         for(int i_499_ = 0; i_499_ < this.anInt5711; ++i_499_) {
            short s = this.aShortArray5719[i_499_];
            this.method660(s, bool, bool_496_);
         }
      } else {
         for(int i_500_ = 0; i_500_ < this.anInt5711; ++i_500_) {
            if (!this.method658(i_500_) && !this.method678(i_500_)) {
               this.method660(i_500_, bool, bool_496_);
            }
         }

         if (this.aByteArray5768 == null) {
            for(int i_501_ = 0; i_501_ < this.anInt5711; ++i_501_) {
               if (this.method658(i_501_) || this.method678(i_501_)) {
                  this.method660(i_501_, bool, bool_496_);
               }
            }
         } else {
            for(int i_502_ = 0; i_502_ < 12; ++i_502_) {
               for(int i_503_ = 0; i_503_ < this.anInt5711; ++i_503_) {
                  if (this.aByteArray5768[i_503_] == i_502_ && (this.method658(i_503_) || this.method678(i_503_))) {
                     this.method660(i_503_, bool, bool_496_);
                  }
               }
            }
         }
      }
   }

   private final void method669(int i) {
      short s = this.aShortArray5767[i];
      short s_505_ = this.aShortArray5731[i];
      short s_506_ = this.aShortArray5789[i];
      if (this.aShortArray5773 != null && this.aShortArray5773[i] != -1) {
         int i_507_ = -16777216;
         if (this.aByteArray5784 != null) {
            i_507_ = 255 - (this.aByteArray5784[i] & 255) << 24;
         }

         if (this.anIntArray5761[i] == -1) {
            int i_508_ = i_507_ | this.anIntArray5754[i] & 16777215;
            this.aClass185_5712
               .method1863(
                  (float)this.anIntArray5716[s],
                  (float)this.anIntArray5716[s_505_],
                  (float)this.anIntArray5716[s_506_],
                  (float)this.anIntArray5713[s],
                  (float)this.anIntArray5713[s_505_],
                  (float)this.anIntArray5713[s_506_],
                  (float)this.anIntArray5758[s],
                  (float)this.anIntArray5758[s_505_],
                  (float)this.anIntArray5758[s_506_],
                  this.aFloatArrayArray5763[i][0],
                  this.aFloatArrayArray5763[i][1],
                  this.aFloatArrayArray5763[i][2],
                  this.aFloatArrayArray5776[i][0],
                  this.aFloatArrayArray5776[i][1],
                  this.aFloatArrayArray5776[i][2],
                  i_508_,
                  i_508_,
                  i_508_,
                  this.aClass374_5741.anInt4611,
                  0,
                  0,
                  0,
                  this.aShortArray5773[i]
               );
         } else {
            this.aClass185_5712
               .method1863(
                  (float)this.anIntArray5716[s],
                  (float)this.anIntArray5716[s_505_],
                  (float)this.anIntArray5716[s_506_],
                  (float)this.anIntArray5713[s],
                  (float)this.anIntArray5713[s_505_],
                  (float)this.anIntArray5713[s_506_],
                  (float)this.anIntArray5758[s],
                  (float)this.anIntArray5758[s_505_],
                  (float)this.anIntArray5758[s_506_],
                  this.aFloatArrayArray5763[i][0],
                  this.aFloatArrayArray5763[i][1],
                  this.aFloatArrayArray5763[i][2],
                  this.aFloatArrayArray5776[i][0],
                  this.aFloatArrayArray5776[i][1],
                  this.aFloatArrayArray5776[i][2],
                  i_507_ | this.anIntArray5754[i] & 16777215,
                  i_507_ | this.anIntArray5739[i] & 16777215,
                  i_507_ | this.anIntArray5761[i] & 16777215,
                  this.aClass374_5741.anInt4611,
                  0,
                  0,
                  0,
                  this.aShortArray5773[i]
               );
         }
      } else {
         if (this.aByteArray5784 == null) {
            this.aClass185_5712.anInt2220 = 0;
         } else {
            this.aClass185_5712.anInt2220 = this.aByteArray5784[i] & 255;
         }

         if (this.anIntArray5761[i] == -1) {
            this.aClass185_5712
               .method1853(
                  (float)this.anIntArray5716[s],
                  (float)this.anIntArray5716[s_505_],
                  (float)this.anIntArray5716[s_506_],
                  (float)this.anIntArray5713[s],
                  (float)this.anIntArray5713[s_505_],
                  (float)this.anIntArray5713[s_506_],
                  (float)this.anIntArray5758[s],
                  (float)this.anIntArray5758[s_505_],
                  (float)this.anIntArray5758[s_506_],
                  Class170.anIntArray2054[this.anIntArray5754[i] & 65535]
               );
         } else {
            this.aClass185_5712
               .method1862(
                  (float)this.anIntArray5716[s],
                  (float)this.anIntArray5716[s_505_],
                  (float)this.anIntArray5716[s_506_],
                  (float)this.anIntArray5713[s],
                  (float)this.anIntArray5713[s_505_],
                  (float)this.anIntArray5713[s_506_],
                  (float)this.anIntArray5758[s],
                  (float)this.anIntArray5758[s_505_],
                  (float)this.anIntArray5758[s_506_],
                  (float)(this.anIntArray5754[i] & 65535),
                  (float)(this.anIntArray5739[i] & 65535),
                  (float)(this.anIntArray5761[i] & 65535)
               );
         }
      }
   }

   @Override
   final int WA() {
      return this.anInt5791;
   }

   private final void method670(int i) {
      int i_509_ = 0;
      int i_510_ = this.aPureJavaToolkit5770.anInt6798;
      short s = this.aShortArray5767[i];
      short s_511_ = this.aShortArray5731[i];
      short s_512_ = this.aShortArray5789[i];
      int i_513_ = this.anIntArray5721[s];
      int i_514_ = this.anIntArray5721[s_511_];
      int i_515_ = this.anIntArray5721[s_512_];
      if (this.aByteArray5784 == null) {
         this.aClass185_5712.anInt2220 = 0;
      } else {
         this.aClass185_5712.anInt2220 = this.aByteArray5784[i] & 255;
      }

      if (i_513_ >= i_510_) {
         this.anIntArray5738[i_509_] = this.anIntArray5713[s];
         this.anIntArray5781[i_509_] = this.anIntArray5716[s];
         this.anIntArray5760[i_509_] = this.anIntArray5758[s];
         this.anIntArray5785[i_509_++] = this.anIntArray5754[i] & 65535;
      } else {
         int i_516_ = this.anIntArray5714[s];
         int i_517_ = this.anIntArray5728[s];
         int i_518_ = this.anIntArray5754[i] & 65535;
         if (i_515_ >= i_510_) {
            int i_519_ = (i_510_ - i_513_) * (65536 / (i_515_ - i_513_));
            this.anIntArray5738[i_509_] = this.aClass374_5741.anInt4633
               + (i_516_ + ((this.anIntArray5714[s_512_] - i_516_) * i_519_ >> 16)) * this.aPureJavaToolkit5770.anInt6785 / i_510_;
            this.anIntArray5781[i_509_] = this.aClass374_5741.anInt4653
               + (i_517_ + ((this.anIntArray5728[s_512_] - i_517_) * i_519_ >> 16)) * this.aPureJavaToolkit5770.anInt6763 / i_510_;
            this.anIntArray5760[i_509_] = i_510_;
            this.anIntArray5785[i_509_++] = i_518_ + (((this.anIntArray5761[i] & 65535) - i_518_) * i_519_ >> 16);
         }

         if (i_514_ >= i_510_) {
            int i_520_ = (i_510_ - i_513_) * (65536 / (i_514_ - i_513_));
            this.anIntArray5738[i_509_] = this.aClass374_5741.anInt4633
               + (i_516_ + ((this.anIntArray5714[s_511_] - i_516_) * i_520_ >> 16)) * this.aPureJavaToolkit5770.anInt6785 / i_510_;
            this.anIntArray5781[i_509_] = this.aClass374_5741.anInt4653
               + (i_517_ + ((this.anIntArray5728[s_511_] - i_517_) * i_520_ >> 16)) * this.aPureJavaToolkit5770.anInt6763 / i_510_;
            this.anIntArray5760[i_509_] = i_510_;
            this.anIntArray5785[i_509_++] = i_518_ + (((this.anIntArray5739[i] & 65535) - i_518_) * i_520_ >> 16);
         }
      }

      if (i_514_ >= i_510_) {
         this.anIntArray5738[i_509_] = this.anIntArray5713[s_511_];
         this.anIntArray5781[i_509_] = this.anIntArray5716[s_511_];
         this.anIntArray5760[i_509_] = this.anIntArray5758[s_511_];
         this.anIntArray5785[i_509_++] = this.anIntArray5739[i] & 65535;
      } else {
         int i_521_ = this.anIntArray5714[s_511_];
         int i_522_ = this.anIntArray5728[s_511_];
         int i_523_ = this.anIntArray5739[i] & 65535;
         if (i_513_ >= i_510_) {
            int i_524_ = (i_510_ - i_514_) * (65536 / (i_513_ - i_514_));
            this.anIntArray5738[i_509_] = this.aClass374_5741.anInt4633
               + (i_521_ + ((this.anIntArray5714[s] - i_521_) * i_524_ >> 16)) * this.aPureJavaToolkit5770.anInt6785 / i_510_;
            this.anIntArray5781[i_509_] = this.aClass374_5741.anInt4653
               + (i_522_ + ((this.anIntArray5728[s] - i_522_) * i_524_ >> 16)) * this.aPureJavaToolkit5770.anInt6763 / i_510_;
            this.anIntArray5760[i_509_] = i_510_;
            this.anIntArray5785[i_509_++] = i_523_ + (((this.anIntArray5754[i] & 65535) - i_523_) * i_524_ >> 16);
         }

         if (i_515_ >= i_510_) {
            int i_525_ = (i_510_ - i_514_) * (65536 / (i_515_ - i_514_));
            this.anIntArray5738[i_509_] = this.aClass374_5741.anInt4633
               + (i_521_ + ((this.anIntArray5714[s_512_] - i_521_) * i_525_ >> 16)) * this.aPureJavaToolkit5770.anInt6785 / i_510_;
            this.anIntArray5781[i_509_] = this.aClass374_5741.anInt4653
               + (i_522_ + ((this.anIntArray5728[s_512_] - i_522_) * i_525_ >> 16)) * this.aPureJavaToolkit5770.anInt6763 / i_510_;
            this.anIntArray5760[i_509_] = i_510_;
            this.anIntArray5785[i_509_++] = i_523_ + (((this.anIntArray5761[i] & 65535) - i_523_) * i_525_ >> 16);
         }
      }

      if (i_515_ >= i_510_) {
         this.anIntArray5738[i_509_] = this.anIntArray5713[s_512_];
         this.anIntArray5781[i_509_] = this.anIntArray5716[s_512_];
         this.anIntArray5760[i_509_] = this.anIntArray5758[s_512_];
         this.anIntArray5785[i_509_++] = this.anIntArray5761[i] & 65535;
      } else {
         int i_526_ = this.anIntArray5714[s_512_];
         int i_527_ = this.anIntArray5728[s_512_];
         int i_528_ = this.anIntArray5761[i] & 65535;
         if (i_514_ >= i_510_) {
            int i_529_ = (i_510_ - i_515_) * (65536 / (i_514_ - i_515_));
            this.anIntArray5738[i_509_] = this.aClass374_5741.anInt4633
               + (i_526_ + ((this.anIntArray5714[s_511_] - i_526_) * i_529_ >> 16)) * this.aPureJavaToolkit5770.anInt6785 / i_510_;
            this.anIntArray5781[i_509_] = this.aClass374_5741.anInt4653
               + (i_527_ + ((this.anIntArray5728[s_511_] - i_527_) * i_529_ >> 16)) * this.aPureJavaToolkit5770.anInt6763 / i_510_;
            this.anIntArray5760[i_509_] = i_510_;
            this.anIntArray5785[i_509_++] = i_528_ + (((this.anIntArray5739[i] & 65535) - i_528_) * i_529_ >> 16);
         }

         if (i_513_ >= i_510_) {
            int i_530_ = (i_510_ - i_515_) * (65536 / (i_513_ - i_515_));
            this.anIntArray5738[i_509_] = this.aClass374_5741.anInt4633
               + (i_526_ + ((this.anIntArray5714[s] - i_526_) * i_530_ >> 16)) * this.aPureJavaToolkit5770.anInt6785 / i_510_;
            this.anIntArray5781[i_509_] = this.aClass374_5741.anInt4653
               + (i_527_ + ((this.anIntArray5728[s] - i_527_) * i_530_ >> 16)) * this.aPureJavaToolkit5770.anInt6763 / i_510_;
            this.anIntArray5760[i_509_] = i_510_;
            this.anIntArray5785[i_509_++] = i_528_ + (((this.anIntArray5754[i] & 65535) - i_528_) * i_530_ >> 16);
         }
      }

      int i_531_ = this.anIntArray5738[0];
      int i_532_ = this.anIntArray5738[1];
      int i_533_ = this.anIntArray5738[2];
      int i_534_ = this.anIntArray5781[0];
      int i_535_ = this.anIntArray5781[1];
      int i_536_ = this.anIntArray5781[2];
      i_513_ = this.anIntArray5760[0];
      i_514_ = this.anIntArray5760[1];
      i_515_ = this.anIntArray5760[2];
      this.aClass185_5712.aBoolean2217 = false;
      if (i_509_ == 3) {
         if (i_531_ < 0
            || i_532_ < 0
            || i_533_ < 0
            || i_531_ > this.aClass374_5741.anInt4635
            || i_532_ > this.aClass374_5741.anInt4635
            || i_533_ > this.aClass374_5741.anInt4635) {
            this.aClass185_5712.aBoolean2217 = true;
         }

         if (this.aShortArray5773 != null && this.aShortArray5773[i] != -1) {
            int i_537_ = -16777216;
            if (this.aByteArray5784 != null) {
               i_537_ = 255 - (this.aByteArray5784[i] & 255) << 24;
            }

            int i_538_ = i_537_ | this.anIntArray5754[i] & 16777215;
            if (this.anIntArray5761[i] == -1) {
               this.aClass185_5712
                  .method1863(
                     (float)i_534_,
                     (float)i_535_,
                     (float)i_536_,
                     (float)i_531_,
                     (float)i_532_,
                     (float)i_533_,
                     (float)i_513_,
                     (float)i_514_,
                     (float)i_515_,
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_538_,
                     i_538_,
                     i_538_,
                     this.aClass374_5741.anInt4611,
                     0,
                     0,
                     0,
                     this.aShortArray5773[i]
                  );
            } else {
               this.aClass185_5712
                  .method1863(
                     (float)i_534_,
                     (float)i_535_,
                     (float)i_536_,
                     (float)i_531_,
                     (float)i_532_,
                     (float)i_533_,
                     (float)i_513_,
                     (float)i_514_,
                     (float)i_515_,
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_538_,
                     i_538_,
                     i_538_,
                     this.aClass374_5741.anInt4611,
                     0,
                     0,
                     0,
                     this.aShortArray5773[i]
                  );
            }
         } else if (this.anIntArray5761[i] == -1) {
            this.aClass185_5712
               .method1853(
                  (float)i_534_,
                  (float)i_535_,
                  (float)i_536_,
                  (float)i_531_,
                  (float)i_532_,
                  (float)i_533_,
                  (float)i_513_,
                  (float)i_514_,
                  (float)i_515_,
                  Class170.anIntArray2054[this.anIntArray5754[i] & 65535]
               );
         } else {
            this.aClass185_5712
               .method1862(
                  (float)i_534_,
                  (float)i_535_,
                  (float)i_536_,
                  (float)i_531_,
                  (float)i_532_,
                  (float)i_533_,
                  (float)i_513_,
                  (float)i_514_,
                  (float)i_515_,
                  (float)this.anIntArray5785[0],
                  (float)this.anIntArray5785[1],
                  (float)this.anIntArray5785[2]
               );
         }
      }

      if (i_509_ == 4) {
         if (i_531_ < 0
            || i_532_ < 0
            || i_533_ < 0
            || i_531_ > this.aClass374_5741.anInt4635
            || i_532_ > this.aClass374_5741.anInt4635
            || i_533_ > this.aClass374_5741.anInt4635
            || this.anIntArray5738[3] < 0
            || this.anIntArray5738[3] > this.aClass374_5741.anInt4635) {
            this.aClass185_5712.aBoolean2217 = true;
         }

         if (this.aShortArray5773 != null && this.aShortArray5773[i] != -1) {
            int i_540_ = -16777216;
            if (this.aByteArray5784 != null) {
               i_540_ = 255 - (this.aByteArray5784[i] & 255) << 24;
            }

            int i_541_ = i_540_ | this.anIntArray5754[i] & 16777215;
            if (this.anIntArray5761[i] == -1) {
               this.aClass185_5712
                  .method1863(
                     (float)i_534_,
                     (float)i_535_,
                     (float)i_536_,
                     (float)i_531_,
                     (float)i_532_,
                     (float)i_533_,
                     (float)i_513_,
                     (float)i_514_,
                     (float)i_515_,
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_541_,
                     i_541_,
                     i_541_,
                     this.aClass374_5741.anInt4611,
                     0,
                     0,
                     0,
                     this.aShortArray5773[i]
                  );
               this.aClass185_5712
                  .method1863(
                     (float)i_534_,
                     (float)i_536_,
                     (float)this.anIntArray5781[3],
                     (float)i_531_,
                     (float)i_533_,
                     (float)this.anIntArray5738[3],
                     (float)i_513_,
                     (float)i_515_,
                     (float)this.anIntArray5760[3],
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_541_,
                     i_541_,
                     i_541_,
                     this.aClass374_5741.anInt4611,
                     0,
                     0,
                     0,
                     this.aShortArray5773[i]
                  );
            } else {
               this.aClass185_5712
                  .method1863(
                     (float)i_534_,
                     (float)i_535_,
                     (float)i_536_,
                     (float)i_531_,
                     (float)i_532_,
                     (float)i_533_,
                     (float)i_513_,
                     (float)i_514_,
                     (float)i_515_,
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_541_,
                     i_541_,
                     i_541_,
                     this.aClass374_5741.anInt4611,
                     0,
                     0,
                     0,
                     this.aShortArray5773[i]
                  );
               this.aClass185_5712
                  .method1863(
                     (float)i_534_,
                     (float)i_536_,
                     (float)this.anIntArray5781[3],
                     (float)i_531_,
                     (float)i_533_,
                     (float)this.anIntArray5738[3],
                     (float)i_513_,
                     (float)i_515_,
                     (float)this.anIntArray5760[3],
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_541_,
                     i_541_,
                     i_541_,
                     this.aClass374_5741.anInt4611,
                     0,
                     0,
                     0,
                     this.aShortArray5773[i]
                  );
            }
         } else if (this.anIntArray5761[i] == -1) {
            int i_539_ = Class170.anIntArray2054[this.anIntArray5754[i] & 65535];
            this.aClass185_5712
               .method1853(
                  (float)i_534_,
                  (float)i_535_,
                  (float)i_536_,
                  (float)i_531_,
                  (float)i_532_,
                  (float)i_533_,
                  (float)i_513_,
                  (float)i_514_,
                  (float)i_515_,
                  i_539_
               );
            this.aClass185_5712
               .method1853(
                  (float)i_534_,
                  (float)i_536_,
                  (float)this.anIntArray5781[3],
                  (float)i_531_,
                  (float)i_533_,
                  (float)this.anIntArray5738[3],
                  (float)i_513_,
                  (float)i_514_,
                  (float)this.anIntArray5760[3],
                  i_539_
               );
         } else {
            this.aClass185_5712
               .method1862(
                  (float)i_534_,
                  (float)i_535_,
                  (float)i_536_,
                  (float)i_531_,
                  (float)i_532_,
                  (float)i_533_,
                  (float)i_513_,
                  (float)i_514_,
                  (float)i_515_,
                  (float)this.anIntArray5785[0],
                  (float)this.anIntArray5785[1],
                  (float)this.anIntArray5785[2]
               );
            this.aClass185_5712
               .method1862(
                  (float)i_534_,
                  (float)i_536_,
                  (float)this.anIntArray5781[3],
                  (float)i_531_,
                  (float)i_533_,
                  (float)this.anIntArray5738[3],
                  (float)i_513_,
                  (float)i_514_,
                  (float)this.anIntArray5760[3],
                  (float)this.anIntArray5785[0],
                  (float)this.anIntArray5785[2],
                  (float)this.anIntArray5785[3]
               );
         }
      }
   }

   private final void method671(Thread thread) {
      Class374 class374 = this.aPureJavaToolkit5770.method1494(thread);
      this.aClass185_5712 = class374.aClass185_4627;
      if (class374 != this.aClass374_5741) {
         this.aClass374_5741 = class374;
         this.anIntArray5769 = this.aClass374_5741.anIntArray4640;
         this.anIntArray5714 = this.aClass374_5741.anIntArray4649;
         this.anIntArray5728 = this.aClass374_5741.anIntArray4644;
         this.anIntArray5721 = this.aClass374_5741.anIntArray4631;
         this.anIntArray5713 = this.aClass374_5741.anIntArray4646;
         this.anIntArray5716 = this.aClass374_5741.anIntArray4641;
         this.anIntArray5758 = this.aClass374_5741.anIntArray4630;
         this.anIntArray5737 = this.aClass374_5741.anIntArray4639;
         this.anIntArray5745 = this.aClass374_5741.anIntArray4636;
         this.anIntArray5729 = this.aClass374_5741.anIntArray4629;
         this.anIntArray5738 = this.aClass374_5741.anIntArray4642;
         this.anIntArray5781 = this.aClass374_5741.anIntArray4645;
         this.anIntArray5760 = this.aClass374_5741.anIntArray4634;
         this.anIntArray5785 = this.aClass374_5741.anIntArray4643;
         this.anIntArray5771 = this.aClass374_5741.anIntArray4626;
         this.anIntArray5749 = this.aClass374_5741.anIntArray4628;
         this.anIntArray5756 = this.aClass374_5741.anIntArray4648;
      }
   }

   private final boolean method672(int i, int i_542_, int i_543_, int i_544_, int i_545_, int i_546_, int i_547_, int i_548_) {
      if (i_542_ < i_543_ && i_542_ < i_544_ && i_542_ < i_545_) {
         return false;
      } else if (i_542_ > i_543_ && i_542_ > i_544_ && i_542_ > i_545_) {
         return false;
      } else if (i < i_546_ && i < i_547_ && i < i_548_) {
         return false;
      } else {
         return i <= i_546_ || i <= i_547_ || i <= i_548_;
      }
   }

   @Override
   final void method630(Class336 class336, int i, boolean bool) {
      if (this.aShortArray5747 != null) {
         int[] is = new int[3];

         for(int i_549_ = 0; i_549_ < this.anInt5753; ++i_549_) {
            if ((i & this.aShortArray5747[i_549_]) != 0) {
               if (bool) {
                  class336.method3869(this.anIntArray5748[i_549_], this.anIntArray5772[i_549_], this.anIntArray5717[i_549_], is);
               } else {
                  class336.method3853(this.anIntArray5748[i_549_], this.anIntArray5772[i_549_], this.anIntArray5717[i_549_], is);
               }

               this.anIntArray5748[i_549_] = is[0];
               this.anIntArray5772[i_549_] = is[1];
               this.anIntArray5717[i_549_] = is[2];
            }
         }
      }
   }

   private final void method673(int i) {
      int i_550_ = 0;
      int i_551_ = this.aPureJavaToolkit5770.anInt6798;
      short s = this.aShortArray5767[i];
      short s_552_ = this.aShortArray5731[i];
      short s_553_ = this.aShortArray5789[i];
      int i_554_ = this.anIntArray5721[s];
      int i_555_ = this.anIntArray5721[s_552_];
      int i_556_ = this.anIntArray5721[s_553_];
      if (this.aByteArray5784 == null) {
         this.aClass185_5712.anInt2220 = 0;
      } else {
         this.aClass185_5712.anInt2220 = this.aByteArray5784[i] & 255;
      }

      if (i_554_ >= i_551_) {
         this.anIntArray5738[i_550_] = this.anIntArray5713[s];
         this.anIntArray5781[i_550_] = this.anIntArray5716[s];
         this.anIntArray5760[i_550_] = this.anIntArray5758[s];
         this.anIntArray5785[i_550_++] = this.anIntArray5754[i] & 65535;
      } else {
         int i_557_ = this.anIntArray5714[s];
         int i_558_ = this.anIntArray5728[s];
         int i_559_ = this.anIntArray5754[i] & 65535;
         if (i_556_ >= i_551_) {
            int i_560_ = (i_551_ - i_554_) * (65536 / (i_556_ - i_554_));
            this.anIntArray5738[i_550_] = this.aClass374_5741.anInt4633
               + (i_557_ + ((this.anIntArray5714[s_553_] - i_557_) * i_560_ >> 16)) * this.aPureJavaToolkit5770.anInt6785 / i_551_;
            this.anIntArray5781[i_550_] = this.aClass374_5741.anInt4653
               + (i_558_ + ((this.anIntArray5728[s_553_] - i_558_) * i_560_ >> 16)) * this.aPureJavaToolkit5770.anInt6763 / i_551_;
            this.anIntArray5760[i_550_] = i_551_;
            this.anIntArray5785[i_550_++] = i_559_ + (((this.anIntArray5761[i] & 65535) - i_559_) * i_560_ >> 16);
         }

         if (i_555_ >= i_551_) {
            int i_561_ = (i_551_ - i_554_) * (65536 / (i_555_ - i_554_));
            this.anIntArray5738[i_550_] = this.aClass374_5741.anInt4633
               + (i_557_ + ((this.anIntArray5714[s_552_] - i_557_) * i_561_ >> 16)) * this.aPureJavaToolkit5770.anInt6785 / i_551_;
            this.anIntArray5781[i_550_] = this.aClass374_5741.anInt4653
               + (i_558_ + ((this.anIntArray5728[s_552_] - i_558_) * i_561_ >> 16)) * this.aPureJavaToolkit5770.anInt6763 / i_551_;
            this.anIntArray5760[i_550_] = i_551_;
            this.anIntArray5785[i_550_++] = i_559_ + (((this.anIntArray5739[i] & 65535) - i_559_) * i_561_ >> 16);
         }
      }

      if (i_555_ >= i_551_) {
         this.anIntArray5738[i_550_] = this.anIntArray5713[s_552_];
         this.anIntArray5781[i_550_] = this.anIntArray5716[s_552_];
         this.anIntArray5760[i_550_] = this.anIntArray5758[s_552_];
         this.anIntArray5785[i_550_++] = this.anIntArray5739[i] & 65535;
      } else {
         int i_562_ = this.anIntArray5714[s_552_];
         int i_563_ = this.anIntArray5728[s_552_];
         int i_564_ = this.anIntArray5739[i] & 65535;
         if (i_554_ >= i_551_) {
            int i_565_ = (i_551_ - i_555_) * (65536 / (i_554_ - i_555_));
            this.anIntArray5738[i_550_] = this.aClass374_5741.anInt4633
               + (i_562_ + ((this.anIntArray5714[s] - i_562_) * i_565_ >> 16)) * this.aPureJavaToolkit5770.anInt6785 / i_551_;
            this.anIntArray5781[i_550_] = this.aClass374_5741.anInt4653
               + (i_563_ + ((this.anIntArray5728[s] - i_563_) * i_565_ >> 16)) * this.aPureJavaToolkit5770.anInt6763 / i_551_;
            this.anIntArray5760[i_550_] = i_551_;
            this.anIntArray5785[i_550_++] = i_564_ + (((this.anIntArray5754[i] & 65535) - i_564_) * i_565_ >> 16);
         }

         if (i_556_ >= i_551_) {
            int i_566_ = (i_551_ - i_555_) * (65536 / (i_556_ - i_555_));
            this.anIntArray5738[i_550_] = this.aClass374_5741.anInt4633
               + (i_562_ + ((this.anIntArray5714[s_553_] - i_562_) * i_566_ >> 16)) * this.aPureJavaToolkit5770.anInt6785 / i_551_;
            this.anIntArray5781[i_550_] = this.aClass374_5741.anInt4653
               + (i_563_ + ((this.anIntArray5728[s_553_] - i_563_) * i_566_ >> 16)) * this.aPureJavaToolkit5770.anInt6763 / i_551_;
            this.anIntArray5760[i_550_] = i_551_;
            this.anIntArray5785[i_550_++] = i_564_ + (((this.anIntArray5761[i] & 65535) - i_564_) * i_566_ >> 16);
         }
      }

      if (i_556_ >= i_551_) {
         this.anIntArray5738[i_550_] = this.anIntArray5713[s_553_];
         this.anIntArray5781[i_550_] = this.anIntArray5716[s_553_];
         this.anIntArray5760[i_550_] = this.anIntArray5758[s_553_];
         this.anIntArray5785[i_550_++] = this.anIntArray5761[i] & 65535;
      } else {
         int i_567_ = this.anIntArray5714[s_553_];
         int i_568_ = this.anIntArray5728[s_553_];
         int i_569_ = this.anIntArray5761[i] & 65535;
         if (i_555_ >= i_551_) {
            int i_570_ = (i_551_ - i_556_) * (65536 / (i_555_ - i_556_));
            this.anIntArray5738[i_550_] = this.aClass374_5741.anInt4633
               + (i_567_ + ((this.anIntArray5714[s_552_] - i_567_) * i_570_ >> 16)) * this.aPureJavaToolkit5770.anInt6785 / i_551_;
            this.anIntArray5781[i_550_] = this.aClass374_5741.anInt4653
               + (i_568_ + ((this.anIntArray5728[s_552_] - i_568_) * i_570_ >> 16)) * this.aPureJavaToolkit5770.anInt6763 / i_551_;
            this.anIntArray5760[i_550_] = i_551_;
            this.anIntArray5785[i_550_++] = i_569_ + (((this.anIntArray5739[i] & 65535) - i_569_) * i_570_ >> 16);
         }

         if (i_554_ >= i_551_) {
            int i_571_ = (i_551_ - i_556_) * (65536 / (i_554_ - i_556_));
            this.anIntArray5738[i_550_] = this.aClass374_5741.anInt4633
               + (i_567_ + ((this.anIntArray5714[s] - i_567_) * i_571_ >> 16)) * this.aPureJavaToolkit5770.anInt6785 / i_551_;
            this.anIntArray5781[i_550_] = this.aClass374_5741.anInt4653
               + (i_568_ + ((this.anIntArray5728[s] - i_568_) * i_571_ >> 16)) * this.aPureJavaToolkit5770.anInt6763 / i_551_;
            this.anIntArray5760[i_550_] = i_551_;
            this.anIntArray5785[i_550_++] = i_569_ + (((this.anIntArray5754[i] & 65535) - i_569_) * i_571_ >> 16);
         }
      }

      int i_572_ = this.anIntArray5738[0];
      int i_573_ = this.anIntArray5738[1];
      int i_574_ = this.anIntArray5738[2];
      int i_575_ = this.anIntArray5781[0];
      int i_576_ = this.anIntArray5781[1];
      int i_577_ = this.anIntArray5781[2];
      i_554_ = this.anIntArray5760[0];
      i_555_ = this.anIntArray5760[1];
      i_556_ = this.anIntArray5760[2];
      this.aClass185_5712.aBoolean2217 = false;
      if (i_550_ == 3) {
         if (i_572_ < 0
            || i_573_ < 0
            || i_574_ < 0
            || i_572_ > this.aClass374_5741.anInt4635
            || i_573_ > this.aClass374_5741.anInt4635
            || i_574_ > this.aClass374_5741.anInt4635) {
            this.aClass185_5712.aBoolean2217 = true;
         }

         if (this.aShortArray5773 != null && this.aShortArray5773[i] != -1) {
            int i_578_ = -16777216;
            if (this.aByteArray5784 != null) {
               i_578_ = 255 - (this.aByteArray5784[i] & 255) << 24;
            }

            int i_579_ = i_578_ | this.anIntArray5754[i] & 16777215;
            if (this.anIntArray5761[i] == -1) {
               this.aClass185_5712
                  .method1859(
                     (float)i_575_,
                     (float)i_576_,
                     (float)i_577_,
                     (float)i_572_,
                     (float)i_573_,
                     (float)i_574_,
                     (float)i_554_,
                     (float)i_555_,
                     (float)i_556_,
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_579_,
                     i_579_,
                     i_579_,
                     this.aClass374_5741.anInt4611,
                     0,
                     0,
                     0,
                     this.aShortArray5773[i]
                  );
            } else {
               this.aClass185_5712
                  .method1859(
                     (float)i_575_,
                     (float)i_576_,
                     (float)i_577_,
                     (float)i_572_,
                     (float)i_573_,
                     (float)i_574_,
                     (float)i_554_,
                     (float)i_555_,
                     (float)i_556_,
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_579_,
                     i_579_,
                     i_579_,
                     this.aClass374_5741.anInt4611,
                     0,
                     0,
                     0,
                     this.aShortArray5773[i]
                  );
            }
         } else if (this.anIntArray5761[i] == -1) {
            this.aClass185_5712
               .method1867(
                  (float)i_575_,
                  (float)i_576_,
                  (float)i_577_,
                  (float)i_572_,
                  (float)i_573_,
                  (float)i_574_,
                  (float)i_554_,
                  (float)i_555_,
                  (float)i_556_,
                  Class170.anIntArray2054[this.anIntArray5754[i] & 65535]
               );
         } else {
            this.aClass185_5712
               .method1865(
                  (float)i_575_,
                  (float)i_576_,
                  (float)i_577_,
                  (float)i_572_,
                  (float)i_573_,
                  (float)i_574_,
                  (float)i_554_,
                  (float)i_555_,
                  (float)i_556_,
                  (float)this.anIntArray5785[0],
                  (float)this.anIntArray5785[1],
                  (float)this.anIntArray5785[2]
               );
         }
      }

      if (i_550_ == 4) {
         if (i_572_ < 0
            || i_573_ < 0
            || i_574_ < 0
            || i_572_ > this.aClass374_5741.anInt4635
            || i_573_ > this.aClass374_5741.anInt4635
            || i_574_ > this.aClass374_5741.anInt4635
            || this.anIntArray5738[3] < 0
            || this.anIntArray5738[3] > this.aClass374_5741.anInt4635) {
            this.aClass185_5712.aBoolean2217 = true;
         }

         if (this.aShortArray5773 != null && this.aShortArray5773[i] != -1) {
            int i_581_ = -16777216;
            if (this.aByteArray5784 != null) {
               i_581_ = 255 - (this.aByteArray5784[i] & 255) << 24;
            }

            int i_582_ = i_581_ | this.anIntArray5754[i] & 16777215;
            if (this.anIntArray5761[i] == -1) {
               this.aClass185_5712
                  .method1859(
                     (float)i_575_,
                     (float)i_576_,
                     (float)i_577_,
                     (float)i_572_,
                     (float)i_573_,
                     (float)i_574_,
                     (float)i_554_,
                     (float)i_555_,
                     (float)i_556_,
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_582_,
                     i_582_,
                     i_582_,
                     this.aClass374_5741.anInt4611,
                     0,
                     0,
                     0,
                     this.aShortArray5773[i]
                  );
               this.aClass185_5712
                  .method1859(
                     (float)i_575_,
                     (float)i_577_,
                     (float)this.anIntArray5781[3],
                     (float)i_572_,
                     (float)i_574_,
                     (float)this.anIntArray5738[3],
                     (float)i_554_,
                     (float)i_556_,
                     (float)this.anIntArray5760[3],
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_582_,
                     i_582_,
                     i_582_,
                     this.aClass374_5741.anInt4611,
                     0,
                     0,
                     0,
                     this.aShortArray5773[i]
                  );
            } else {
               this.aClass185_5712
                  .method1859(
                     (float)i_575_,
                     (float)i_576_,
                     (float)i_577_,
                     (float)i_572_,
                     (float)i_573_,
                     (float)i_574_,
                     (float)i_554_,
                     (float)i_555_,
                     (float)i_556_,
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_582_,
                     i_582_,
                     i_582_,
                     this.aClass374_5741.anInt4611,
                     0,
                     0,
                     0,
                     this.aShortArray5773[i]
                  );
               this.aClass185_5712
                  .method1859(
                     (float)i_575_,
                     (float)i_577_,
                     (float)this.anIntArray5781[3],
                     (float)i_572_,
                     (float)i_574_,
                     (float)this.anIntArray5738[3],
                     (float)i_554_,
                     (float)i_556_,
                     (float)this.anIntArray5760[3],
                     this.aFloatArrayArray5763[i][0],
                     this.aFloatArrayArray5763[i][1],
                     this.aFloatArrayArray5763[i][2],
                     this.aFloatArrayArray5776[i][0],
                     this.aFloatArrayArray5776[i][1],
                     this.aFloatArrayArray5776[i][2],
                     i_582_,
                     i_582_,
                     i_582_,
                     this.aClass374_5741.anInt4611,
                     0,
                     0,
                     0,
                     this.aShortArray5773[i]
                  );
            }
         } else if (this.anIntArray5761[i] == -1) {
            int i_580_ = Class170.anIntArray2054[this.anIntArray5754[i] & 65535];
            this.aClass185_5712
               .method1867(
                  (float)i_575_,
                  (float)i_576_,
                  (float)i_577_,
                  (float)i_572_,
                  (float)i_573_,
                  (float)i_574_,
                  (float)i_554_,
                  (float)i_555_,
                  (float)i_556_,
                  i_580_
               );
            this.aClass185_5712
               .method1867(
                  (float)i_575_,
                  (float)i_577_,
                  (float)this.anIntArray5781[3],
                  (float)i_572_,
                  (float)i_574_,
                  (float)this.anIntArray5738[3],
                  (float)i_554_,
                  (float)i_555_,
                  (float)this.anIntArray5760[3],
                  i_580_
               );
         } else {
            this.aClass185_5712
               .method1865(
                  (float)i_575_,
                  (float)i_576_,
                  (float)i_577_,
                  (float)i_572_,
                  (float)i_573_,
                  (float)i_574_,
                  (float)i_554_,
                  (float)i_555_,
                  (float)i_556_,
                  (float)this.anIntArray5785[0],
                  (float)this.anIntArray5785[1],
                  (float)this.anIntArray5785[2]
               );
            this.aClass185_5712
               .method1865(
                  (float)i_575_,
                  (float)i_577_,
                  (float)this.anIntArray5781[3],
                  (float)i_572_,
                  (float)i_574_,
                  (float)this.anIntArray5738[3],
                  (float)i_554_,
                  (float)i_555_,
                  (float)this.anIntArray5760[3],
                  (float)this.anIntArray5785[0],
                  (float)this.anIntArray5785[2],
                  (float)this.anIntArray5785[3]
               );
         }
      }
   }

   private final void method674(int i, boolean bool, boolean bool_583_) {
      if (this.anIntArray5761[i] != -2) {
         short s = this.aShortArray5767[i];
         short s_584_ = this.aShortArray5731[i];
         short s_585_ = this.aShortArray5789[i];
         int i_586_ = this.anIntArray5713[s];
         int i_587_ = this.anIntArray5713[s_584_];
         int i_588_ = this.anIntArray5713[s_585_];
         if (!bool || i_586_ != -5000 && i_587_ != -5000 && i_588_ != -5000) {
            if (this.anIntArray5756[i] != -1
               || (i_586_ - i_587_) * (this.anIntArray5716[s_585_] - this.anIntArray5716[s_584_])
                     - (this.anIntArray5716[s] - this.anIntArray5716[s_584_]) * (i_588_ - i_587_)
                  > 0) {
               if (i_586_ >= 0
                  && i_587_ >= 0
                  && i_588_ >= 0
                  && i_586_ <= this.aClass374_5741.anInt4635
                  && i_587_ <= this.aClass374_5741.anInt4635
                  && i_588_ <= this.aClass374_5741.anInt4635) {
                  this.aClass185_5712.aBoolean2217 = false;
               } else {
                  this.aClass185_5712.aBoolean2217 = true;
               }

               if (bool_583_) {
                  int i_601_ = this.anIntArray5756[i];
                  if (i_601_ == -1 || !this.aClass209Array5790[i_601_].aBoolean2495) {
                     this.method659(i);
                  }
               } else {
                  int i_602_ = this.anIntArray5756[i];
                  if (i_602_ != -1) {
                     Class209 class209 = this.aClass209Array5790[i_602_];
                     Class214 class214 = this.aClass214Array5765[i_602_];
                     if (!class209.aBoolean2495) {
                        this.method685(i);
                     }

                     this.aPureJavaToolkit5770
                        .method1498(
                           class214.anInt2515,
                           class214.anInt2521,
                           class214.anInt2518,
                           class214.anInt2526,
                           class214.anInt2514,
                           class214.anInt2525,
                           class209.aShort2488 & '\uffff',
                           class214.anInt2519,
                           class209.aByte2489,
                           class209.aByte2487
                        );
                  } else {
                     this.method685(i);
                  }
               }
            }
         } else {
            int i_589_ = this.anIntArray5714[s];
            int i_590_ = this.anIntArray5714[s_584_];
            int i_591_ = this.anIntArray5714[s_585_];
            int i_592_ = this.anIntArray5728[s];
            int i_593_ = this.anIntArray5728[s_584_];
            int i_594_ = this.anIntArray5728[s_585_];
            int i_595_ = this.anIntArray5721[s];
            int i_596_ = this.anIntArray5721[s_584_];
            int i_597_ = this.anIntArray5721[s_585_];
            i_589_ -= i_590_;
            i_591_ -= i_590_;
            i_592_ -= i_593_;
            i_594_ -= i_593_;
            i_595_ -= i_596_;
            i_597_ -= i_596_;
            int i_598_ = i_592_ * i_597_ - i_595_ * i_594_;
            int i_599_ = i_595_ * i_591_ - i_589_ * i_597_;
            int i_600_ = i_589_ * i_594_ - i_592_ * i_591_;
            if (i_590_ * i_598_ + i_593_ * i_599_ + i_596_ * i_600_ > 0) {
               this.method673(i);
            }
         }
      }
   }

   @Override
   final void C(int i) {
      if ((this.anInt5746 & 4096) != 4096) {
         throw new IllegalStateException();
      } else {
         this.anInt5791 = i;
         this.anInt5744 = 0;
      }
   }

   @Override
   final boolean method612() {
      if (this.aShortArray5773 == null) {
         return true;
      } else {
         for(int i = 0; i < this.aShortArray5773.length; ++i) {
            if (this.aShortArray5773[i] != -1 && !this.aPureJavaToolkit5770.method1493(this.aShortArray5773[i])) {
               return false;
            }
         }

         return true;
      }
   }

   @Override
   final void method611(Class336 class336, EntityNode_Sub5 entitynode_sub5, int i) {
      this.method680(class336, entitynode_sub5, -1, i);
   }

   @Override
   final void FA(int i) {
      if ((this.anInt5746 & 6) != 6) {
         throw new IllegalStateException();
      } else {
         int i_603_ = Class335.anIntArray4167[i];
         int i_604_ = Class335.anIntArray4165[i];
         synchronized(this) {
            for(int i_605_ = 0; i_605_ < this.anInt5718; ++i_605_) {
               int i_606_ = this.anIntArray5772[i_605_] * i_604_ - this.anIntArray5717[i_605_] * i_603_ >> 14;
               this.anIntArray5717[i_605_] = this.anIntArray5772[i_605_] * i_603_ + this.anIntArray5717[i_605_] * i_604_ >> 14;
               this.anIntArray5772[i_605_] = i_606_;
            }

            this.method656();
         }
      }
   }

   @Override
   final byte[] method627() {
      return this.aByteArray5784;
   }

   private final void method675() {
      if (this.anInt5744 == 0 && this.aClass354Array5774 == null) {
         if (this.aPureJavaToolkit5770.anInt6795 > 1) {
            synchronized(this) {
               this.method662();
            }
         } else {
            this.method662();
         }
      }
   }

   @Override
   final int da() {
      return this.anInt5727;
   }

   @Override
   final int ua() {
      return this.anInt5746;
   }

   private final int method676(int i) {
      if (i < 2) {
         i = 2;
      } else if (i > 126) {
         i = 126;
      }

      return i;
   }

   @Override
   final int V() {
      if (!this.aBoolean5792) {
         this.method677();
      }

      return this.aShort5757;
   }

   private final void method677() {
      if (!this.aBoolean5792) {
         int i = 0;
         int i_607_ = 0;
         int i_608_ = 32767;
         int i_609_ = 32767;
         int i_610_ = 32767;
         int i_611_ = -32768;
         int i_612_ = -32768;
         int i_613_ = -32768;

         for(int i_614_ = 0; i_614_ < this.anInt5753; ++i_614_) {
            int i_615_ = this.anIntArray5748[i_614_];
            int i_616_ = this.anIntArray5772[i_614_];
            int i_617_ = this.anIntArray5717[i_614_];
            if (i_615_ < i_608_) {
               i_608_ = i_615_;
            }

            if (i_615_ > i_611_) {
               i_611_ = i_615_;
            }

            if (i_616_ < i_609_) {
               i_609_ = i_616_;
            }

            if (i_616_ > i_612_) {
               i_612_ = i_616_;
            }

            if (i_617_ < i_610_) {
               i_610_ = i_617_;
            }

            if (i_617_ > i_613_) {
               i_613_ = i_617_;
            }

            int i_618_ = i_615_ * i_615_ + i_617_ * i_617_;
            if (i_618_ > i) {
               i = i_618_;
            }

            i_618_ += i_616_ * i_616_;
            if (i_618_ > i_607_) {
               i_607_ = i_618_;
            }
         }

         this.aShort5757 = (short)i_608_;
         this.aShort5766 = (short)i_611_;
         this.aShort5759 = (short)i_609_;
         this.aShort5751 = (short)i_612_;
         this.aShort5732 = (short)i_610_;
         this.aShort5730 = (short)i_613_;
         this.aShort5777 = (short)((int)(Math.sqrt((double)i) + 0.99));
         this.aShort5755 = (short)((int)(Math.sqrt((double)i_607_) + 0.99));
         this.aBoolean5792 = true;
      }
   }

   private final boolean method678(int i) {
      if (this.anIntArray5756 == null) {
         return false;
      } else {
         return this.anIntArray5756[i] != -1;
      }
   }

   private final void method679() {
      for(int i = 0; i < this.anInt5711; ++i) {
         short s = this.aShortArray5773 != null ? this.aShortArray5773[i] : -1;
         if (s == -1) {
            int i_619_ = this.aShortArray5740[i] & '\uffff';
            int i_620_ = (i_619_ & 127) * this.anInt5791 >> 7;
            short s_621_ = Node_Sub15_Sub2.method2560(5310, i_619_ & -128 | i_620_);
            if (this.anIntArray5761[i] == -1) {
               int i_622_ = this.anIntArray5754[i] & -131072;
               this.anIntArray5754[i] = i_622_ | Node_Sub18.method2607((byte)31, i_622_ >> 17, s_621_);
            } else if (this.anIntArray5761[i] != -2) {
               int i_623_ = this.anIntArray5754[i] & -131072;
               this.anIntArray5754[i] = i_623_ | Node_Sub18.method2607((byte)31, i_623_ >> 17, s_621_);
               i_623_ = this.anIntArray5739[i] & -131072;
               this.anIntArray5739[i] = i_623_ | Node_Sub18.method2607((byte)31, i_623_ >> 17, s_621_);
               i_623_ = this.anIntArray5761[i] & -131072;
               this.anIntArray5761[i] = i_623_ | Node_Sub18.method2607((byte)31, i_623_ >> 17, s_621_);
            }
         }
      }

      this.anInt5744 = 2;
   }

   @Override
   final int fa() {
      if (!this.aBoolean5792) {
         this.method677();
      }

      return this.aShort5759;
   }

   @Override
   final void method632() {
      if (this.aPureJavaToolkit5770.anInt6795 > 1) {
         synchronized(this) {
            this.aBoolean914 = false;
            this.notifyAll();
         }
      }
   }

   private final void method680(Class336 class336, EntityNode_Sub5 entitynode_sub5, int i, int i_624_) {
      if (this.anInt5753 >= 1) {
         this.aClass336_Sub2_5778 = (Class336_Sub2)class336;
         Class336_Sub2 class336_sub2 = this.aPureJavaToolkit5770.aClass336_Sub2_6788;
         if (!this.aBoolean5792) {
            this.method677();
         }

         boolean bool = false;
         if (this.aClass336_Sub2_5778.aFloat8580 == 16384.0F
            && this.aClass336_Sub2_5778.aFloat8571 == 0.0F
            && this.aClass336_Sub2_5778.aFloat8566 == 0.0F
            && this.aClass336_Sub2_5778.aFloat8578 == 0.0F
            && this.aClass336_Sub2_5778.aFloat8561 == 16384.0F
            && this.aClass336_Sub2_5778.aFloat8558 == 0.0F
            && this.aClass336_Sub2_5778.aFloat8577 == 0.0F
            && this.aClass336_Sub2_5778.aFloat8567 == 0.0F
            && this.aClass336_Sub2_5778.aFloat8584 == 16384.0F) {
            bool = true;
         }

         float f = class336_sub2.aFloat8589
            + class336_sub2.aFloat8577 * this.aClass336_Sub2_5778.aFloat8583
            + class336_sub2.aFloat8567 * this.aClass336_Sub2_5778.aFloat8579
            + class336_sub2.aFloat8584 * this.aClass336_Sub2_5778.aFloat8589;
         float f_625_ = bool
            ? class336_sub2.aFloat8567
            : class336_sub2.aFloat8577 * this.aClass336_Sub2_5778.aFloat8571
               + class336_sub2.aFloat8567 * this.aClass336_Sub2_5778.aFloat8561
               + class336_sub2.aFloat8584 * this.aClass336_Sub2_5778.aFloat8567;
         int i_626_ = (int)(f + (float)this.aShort5759 * f_625_);
         int i_627_ = (int)(f + (float)this.aShort5751 * f_625_);
         int i_628_;
         int i_629_;
         if (i_626_ > i_627_) {
            i_628_ = i_627_ - this.aShort5777;
            i_629_ = i_626_ + this.aShort5777;
         } else {
            i_628_ = i_626_ - this.aShort5777;
            i_629_ = i_627_ + this.aShort5777;
         }

         if (i_628_ < this.aPureJavaToolkit5770.anInt6776 && i_629_ > this.aPureJavaToolkit5770.anInt6798) {
            float f_630_ = class336_sub2.aFloat8583
               + class336_sub2.aFloat8580 * this.aClass336_Sub2_5778.aFloat8583
               + class336_sub2.aFloat8571 * this.aClass336_Sub2_5778.aFloat8579
               + class336_sub2.aFloat8566 * this.aClass336_Sub2_5778.aFloat8589;
            float f_631_ = bool
               ? class336_sub2.aFloat8571
               : class336_sub2.aFloat8580 * this.aClass336_Sub2_5778.aFloat8571
                  + class336_sub2.aFloat8571 * this.aClass336_Sub2_5778.aFloat8561
                  + class336_sub2.aFloat8566 * this.aClass336_Sub2_5778.aFloat8567;
            int i_632_ = (int)(f_630_ + (float)this.aShort5759 * f_631_);
            int i_633_ = (int)(f_630_ + (float)this.aShort5751 * f_631_);
            int i_634_;
            int i_635_;
            if (i_632_ > i_633_) {
               i_634_ = (i_633_ - this.aShort5777) * this.aPureJavaToolkit5770.anInt6785;
               i_635_ = (i_632_ + this.aShort5777) * this.aPureJavaToolkit5770.anInt6785;
            } else {
               i_634_ = (i_632_ - this.aShort5777) * this.aPureJavaToolkit5770.anInt6785;
               i_635_ = (i_633_ + this.aShort5777) * this.aPureJavaToolkit5770.anInt6785;
            }

            if (i == -1) {
               if (i_634_ / i_629_ >= this.aPureJavaToolkit5770.anInt6768 || i_635_ / i_629_ <= this.aPureJavaToolkit5770.anInt6793) {
                  return;
               }
            } else if (i_634_ / i >= this.aPureJavaToolkit5770.anInt6768 || i_635_ / i <= this.aPureJavaToolkit5770.anInt6793) {
               return;
            }

            float f_636_ = class336_sub2.aFloat8579
               + class336_sub2.aFloat8578 * this.aClass336_Sub2_5778.aFloat8583
               + class336_sub2.aFloat8561 * this.aClass336_Sub2_5778.aFloat8579
               + class336_sub2.aFloat8558 * this.aClass336_Sub2_5778.aFloat8589;
            float f_637_ = bool
               ? class336_sub2.aFloat8561
               : class336_sub2.aFloat8578 * this.aClass336_Sub2_5778.aFloat8571
                  + class336_sub2.aFloat8561 * this.aClass336_Sub2_5778.aFloat8561
                  + class336_sub2.aFloat8558 * this.aClass336_Sub2_5778.aFloat8567;
            int i_638_ = (int)(f_636_ + (float)this.aShort5759 * f_637_);
            int i_639_ = (int)(f_636_ + (float)this.aShort5751 * f_637_);
            int i_640_;
            int i_641_;
            if (i_638_ > i_639_) {
               i_640_ = (i_639_ - this.aShort5777) * this.aPureJavaToolkit5770.anInt6763;
               i_641_ = (i_638_ + this.aShort5777) * this.aPureJavaToolkit5770.anInt6763;
            } else {
               i_640_ = (i_638_ - this.aShort5777) * this.aPureJavaToolkit5770.anInt6763;
               i_641_ = (i_639_ + this.aShort5777) * this.aPureJavaToolkit5770.anInt6763;
            }

            if (i == -1) {
               if (i_640_ / i_629_ >= this.aPureJavaToolkit5770.anInt6779 || i_641_ / i_629_ <= this.aPureJavaToolkit5770.anInt6790) {
                  return;
               }
            } else if (i_640_ / i >= this.aPureJavaToolkit5770.anInt6779 || i_641_ / i <= this.aPureJavaToolkit5770.anInt6790) {
               return;
            }

            float f_642_;
            float f_643_;
            float f_644_;
            float f_645_;
            float f_646_;
            float f_647_;
            if (bool) {
               f_642_ = class336_sub2.aFloat8580;
               f_643_ = class336_sub2.aFloat8578;
               f_644_ = class336_sub2.aFloat8577;
               f_645_ = class336_sub2.aFloat8566;
               f_646_ = class336_sub2.aFloat8558;
               f_647_ = class336_sub2.aFloat8584;
            } else {
               f_642_ = class336_sub2.aFloat8580 * this.aClass336_Sub2_5778.aFloat8580
                  + class336_sub2.aFloat8571 * this.aClass336_Sub2_5778.aFloat8578
                  + class336_sub2.aFloat8566 * this.aClass336_Sub2_5778.aFloat8577;
               f_643_ = class336_sub2.aFloat8578 * this.aClass336_Sub2_5778.aFloat8580
                  + class336_sub2.aFloat8561 * this.aClass336_Sub2_5778.aFloat8578
                  + class336_sub2.aFloat8558 * this.aClass336_Sub2_5778.aFloat8577;
               f_644_ = class336_sub2.aFloat8577 * this.aClass336_Sub2_5778.aFloat8580
                  + class336_sub2.aFloat8567 * this.aClass336_Sub2_5778.aFloat8578
                  + class336_sub2.aFloat8584 * this.aClass336_Sub2_5778.aFloat8577;
               f_645_ = class336_sub2.aFloat8580 * this.aClass336_Sub2_5778.aFloat8566
                  + class336_sub2.aFloat8571 * this.aClass336_Sub2_5778.aFloat8558
                  + class336_sub2.aFloat8566 * this.aClass336_Sub2_5778.aFloat8584;
               f_646_ = class336_sub2.aFloat8578 * this.aClass336_Sub2_5778.aFloat8566
                  + class336_sub2.aFloat8561 * this.aClass336_Sub2_5778.aFloat8558
                  + class336_sub2.aFloat8558 * this.aClass336_Sub2_5778.aFloat8584;
               f_647_ = class336_sub2.aFloat8577 * this.aClass336_Sub2_5778.aFloat8566
                  + class336_sub2.aFloat8567 * this.aClass336_Sub2_5778.aFloat8558
                  + class336_sub2.aFloat8584 * this.aClass336_Sub2_5778.aFloat8584;
            }

            if (this.aPureJavaToolkit5770.anInt6795 > 1) {
               synchronized(this) {
                  while(this.aBoolean5715) {
                     try {
                        this.wait();
                     } catch (InterruptedException var55) {
                     }
                  }

                  this.aBoolean5715 = true;
               }
            }

            this.method671(Thread.currentThread());
            if ((i_624_ & 2) != 0) {
               this.aClass185_5712.method1851(true);
            } else {
               this.aClass185_5712.method1851(false);
            }

            boolean bool_648_ = false;
            boolean bool_649_ = i_628_ <= this.aPureJavaToolkit5770.anInt6798;
            boolean bool_650_ = bool_649_ || this.aClass300Array5782 != null || this.aClass218Array5764 != null;
            this.aClass374_5741.anInt4635 = this.aClass185_5712.anInt2222;
            this.aClass374_5741.anInt4633 = this.aClass185_5712.anInt2216;
            this.aClass374_5741.anInt4653 = this.aClass185_5712.anInt2213;
            int i_651_ = this.aPureJavaToolkit5770.anInt6785;
            int i_652_ = this.aPureJavaToolkit5770.anInt6763;
            int i_653_ = this.aPureJavaToolkit5770.anInt6798;
            if (i == -1) {
               for(int i_654_ = 0; i_654_ < this.anInt5718; ++i_654_) {
                  int i_655_ = this.anIntArray5748[i_654_];
                  int i_656_ = this.anIntArray5772[i_654_];
                  int i_657_ = this.anIntArray5717[i_654_];
                  float f_658_ = f_630_ + f_642_ * (float)i_655_ + f_631_ * (float)i_656_ + f_645_ * (float)i_657_;
                  float f_659_ = f_636_ + f_643_ * (float)i_655_ + f_637_ * (float)i_656_ + f_646_ * (float)i_657_;
                  float f_660_ = f + f_644_ * (float)i_655_ + f_625_ * (float)i_656_ + f_647_ * (float)i_657_;
                  this.anIntArray5758[i_654_] = (int)f_660_;
                  if (f_660_ >= (float)i_653_) {
                     this.anIntArray5713[i_654_] = this.aClass374_5741.anInt4633 + (int)(f_658_ * (float)i_651_ / f_660_);
                     this.anIntArray5716[i_654_] = this.aClass374_5741.anInt4653 + (int)(f_659_ * (float)i_652_ / f_660_);
                  } else {
                     this.anIntArray5713[i_654_] = -5000;
                     bool_648_ = true;
                  }

                  if (bool_650_) {
                     this.anIntArray5714[i_654_] = (int)f_658_;
                     this.anIntArray5728[i_654_] = (int)f_659_;
                     this.anIntArray5721[i_654_] = (int)f_660_;
                  }

                  if (this.aClass374_5741.aBoolean4617) {
                     this.anIntArray5769[i_654_] = (int)(
                        this.aClass336_Sub2_5778.aFloat8579
                           + this.aClass336_Sub2_5778.aFloat8578 * (float)i_655_
                           + this.aClass336_Sub2_5778.aFloat8561 * (float)i_656_
                           + this.aClass336_Sub2_5778.aFloat8558 * (float)i_657_
                     );
                  }
               }

               if (this.aClass209Array5790 != null) {
                  for(int i_661_ = 0; i_661_ < this.anInt5762; ++i_661_) {
                     Class209 class209 = this.aClass209Array5790[i_661_];
                     Class214 class214 = this.aClass214Array5765[i_661_];
                     short s = this.aShortArray5767[class209.anInt2485];
                     short s_662_ = this.aShortArray5731[class209.anInt2485];
                     short s_663_ = this.aShortArray5789[class209.anInt2485];
                     int i_664_ = (this.anIntArray5748[s] + this.anIntArray5748[s_662_] + this.anIntArray5748[s_663_]) / 3;
                     int i_665_ = (this.anIntArray5772[s] + this.anIntArray5772[s_662_] + this.anIntArray5772[s_663_]) / 3;
                     int i_666_ = (this.anIntArray5717[s] + this.anIntArray5717[s_662_] + this.anIntArray5717[s_663_]) / 3;
                     float f_667_ = (float)class214.anInt2516 + f_630_ + f_642_ * (float)i_664_ + f_631_ * (float)i_665_ + f_645_ * (float)i_666_;
                     float f_668_ = (float)class214.anInt2523 + f_636_ + f_643_ * (float)i_664_ + f_637_ * (float)i_665_ + f_646_ * (float)i_666_;
                     float f_669_ = f + f_644_ * (float)i_664_ + f_625_ * (float)i_665_ + f_647_ * (float)i_666_;
                     if (f_669_ > (float)this.aPureJavaToolkit5770.anInt6798) {
                        class214.anInt2515 = this.aPureJavaToolkit5770.anInt6786 + (int)(f_667_ * (float)i_651_ / f_669_);
                        class214.anInt2521 = this.aPureJavaToolkit5770.anInt6769 + (int)(f_668_ * (float)i_652_ / f_669_);
                        class214.anInt2518 = (int)f_669_ - class209.anInt2486;
                        class214.anInt2526 = (int)((float)(class214.anInt2517 * class209.aShort2484 * i_651_) / (f_669_ * 128.0F));
                        class214.anInt2514 = (int)((float)(class214.anInt2520 * class209.aShort2494 * i_652_) / (f_669_ * 128.0F));
                     } else {
                        class214.anInt2526 = class214.anInt2514 = 0;
                     }
                  }
               }
            } else {
               for(int i_670_ = 0; i_670_ < this.anInt5718; ++i_670_) {
                  int i_671_ = this.anIntArray5748[i_670_];
                  int i_672_ = this.anIntArray5772[i_670_];
                  int i_673_ = this.anIntArray5717[i_670_];
                  float f_674_ = f_630_ + f_642_ * (float)i_671_ + f_631_ * (float)i_672_ + f_645_ * (float)i_673_;
                  float f_675_ = f_636_ + f_643_ * (float)i_671_ + f_637_ * (float)i_672_ + f_646_ * (float)i_673_;
                  float f_676_ = f + f_644_ * (float)i_671_ + f_625_ * (float)i_672_ + f_647_ * (float)i_673_;
                  this.anIntArray5758[i_670_] = (int)f_676_;
                  this.anIntArray5713[i_670_] = this.aClass374_5741.anInt4633 + (int)(f_674_ * (float)i_651_ / (float)i);
                  this.anIntArray5716[i_670_] = this.aClass374_5741.anInt4653 + (int)(f_675_ * (float)i_652_ / (float)i);
                  if (bool_650_) {
                     this.anIntArray5714[i_670_] = (int)f_674_;
                     this.anIntArray5728[i_670_] = (int)f_675_;
                     this.anIntArray5721[i_670_] = i;
                  }

                  if (this.aClass374_5741.aBoolean4617) {
                     this.anIntArray5769[i_670_] = (int)(
                        this.aClass336_Sub2_5778.aFloat8579
                           + this.aClass336_Sub2_5778.aFloat8578 * (float)i_671_
                           + this.aClass336_Sub2_5778.aFloat8561 * (float)i_672_
                           + this.aClass336_Sub2_5778.aFloat8558 * (float)i_673_
                     );
                  }
               }

               if (this.aClass209Array5790 != null) {
                  for(int i_677_ = 0; i_677_ < this.anInt5762; ++i_677_) {
                     Class209 class209 = this.aClass209Array5790[i_677_];
                     Class214 class214 = this.aClass214Array5765[i_677_];
                     short s = this.aShortArray5767[class209.anInt2485];
                     short s_678_ = this.aShortArray5731[class209.anInt2485];
                     short s_679_ = this.aShortArray5789[class209.anInt2485];
                     int i_680_ = (this.anIntArray5748[s] + this.anIntArray5748[s_678_] + this.anIntArray5748[s_679_]) / 3;
                     int i_681_ = (this.anIntArray5772[s] + this.anIntArray5772[s_678_] + this.anIntArray5772[s_679_]) / 3;
                     int i_682_ = (this.anIntArray5717[s] + this.anIntArray5717[s_678_] + this.anIntArray5717[s_679_]) / 3;
                     float f_683_ = f_630_ + f_642_ * (float)i_680_ + f_631_ * (float)i_681_ + f_645_ * (float)i_682_;
                     float f_684_ = f_636_ + f_643_ * (float)i_680_ + f_637_ * (float)i_681_ + f_646_ * (float)i_682_;
                     class214.anInt2515 = this.aPureJavaToolkit5770.anInt6786 + (int)(f_683_ * (float)i_651_ / (float)i);
                     class214.anInt2521 = this.aPureJavaToolkit5770.anInt6769 + (int)(f_684_ * (float)i_652_ / (float)i);
                     class214.anInt2518 = i - class209.anInt2486;
                     class214.anInt2526 = class214.anInt2517 * class209.aShort2484 * i_651_ / (i << 7);
                     class214.anInt2514 = class214.anInt2520 * class209.aShort2494 * i_652_ / (i << 7);
                  }
               }
            }

            if (entitynode_sub5 != null) {
               boolean bool_686_ = false;
               boolean bool_687_ = true;
               int i_688_ = this.aShort5757 + this.aShort5766 >> 1;
               int i_689_ = this.aShort5732 + this.aShort5730 >> 1;
               short s = this.aShort5759;
               float f_692_ = f_630_ + f_642_ * (float)i_688_ + f_631_ * (float)s + f_645_ * (float)i_689_;
               float f_693_ = f_636_ + f_643_ * (float)i_688_ + f_637_ * (float)s + f_646_ * (float)i_689_;
               float f_694_ = f + f_644_ * (float)i_688_ + f_625_ * (float)s + f_647_ * (float)i_689_;
               if (f_694_ >= (float)i_653_) {
                  int i_695_ = (int)f_694_;
                  if (i != -1) {
                     i_695_ = i;
                  }

                  entitynode_sub5.anInt5985 = this.aPureJavaToolkit5770.anInt6786 + (int)(f_692_ * (float)i_651_ / (float)i_695_);
                  entitynode_sub5.anInt5986 = this.aPureJavaToolkit5770.anInt6769 + (int)(f_693_ * (float)i_652_ / (float)i_695_);
               } else {
                  bool_686_ = true;
               }

               s = this.aShort5751;
               float f_696_ = f_630_ + f_642_ * (float)i_688_ + f_631_ * (float)s + f_645_ * (float)i_689_;
               float f_697_ = f_636_ + f_643_ * (float)i_688_ + f_637_ * (float)s + f_646_ * (float)i_689_;
               float f_698_ = f + f_644_ * (float)i_688_ + f_625_ * (float)s + f_647_ * (float)i_689_;
               if (f_698_ >= (float)i_653_) {
                  int i_699_ = (int)f_698_;
                  if (i != -1) {
                     i_699_ = i;
                  }

                  entitynode_sub5.anInt5982 = this.aPureJavaToolkit5770.anInt6786 + (int)(f_696_ * (float)i_651_ / (float)i_699_);
                  entitynode_sub5.anInt5984 = this.aPureJavaToolkit5770.anInt6769 + (int)(f_697_ * (float)i_652_ / (float)i_699_);
               } else {
                  bool_686_ = true;
               }

               if (bool_686_) {
                  if (f_694_ < (float)i_653_ && f_698_ < (float)i_653_) {
                     bool_687_ = false;
                  } else if (f_694_ < (float)i_653_) {
                     float f_700_ = (f_698_ - (float)this.aPureJavaToolkit5770.anInt6798) / (f_698_ - f_694_);
                     int i_701_ = (int)(f_696_ + (f_696_ - f_692_) * f_700_);
                     int i_702_ = (int)(f_697_ + (f_697_ - f_693_) * f_700_);
                     int i_703_ = i_653_;
                     if (i != -1) {
                        i_703_ = i;
                     }

                     entitynode_sub5.anInt5985 = this.aPureJavaToolkit5770.anInt6786 + i_701_ * i_651_ / i_703_;
                     entitynode_sub5.anInt5986 = this.aPureJavaToolkit5770.anInt6769 + i_702_ * i_652_ / i_703_;
                  } else if (f_698_ < (float)i_653_) {
                     float f_704_ = (f_694_ - (float)i_653_) / (f_694_ - f_698_);
                     int i_705_ = (int)(f_692_ + (f_692_ - f_696_) * f_704_);
                     int i_706_ = (int)(f_693_ + (f_693_ - f_697_) * f_704_);
                     int i_707_ = i_653_;
                     if (i != -1) {
                        i_707_ = i;
                     }

                     entitynode_sub5.anInt5985 = this.aPureJavaToolkit5770.anInt6786 + i_705_ * i_651_ / i_707_;
                     entitynode_sub5.anInt5986 = this.aPureJavaToolkit5770.anInt6769 + i_706_ * i_652_ / i_707_;
                  }
               }

               if (bool_687_) {
                  if (f_694_ > f_698_) {
                     int i_708_ = (int)f_694_;
                     if (i != -1) {
                        i_708_ = i;
                     }

                     entitynode_sub5.anInt5983 = this.aPureJavaToolkit5770.anInt6786
                        + (int)((f_692_ + (float)this.aShort5777) * (float)i_651_ / (float)i_708_)
                        - entitynode_sub5.anInt5985;
                  } else {
                     int i_709_ = (int)f_698_;
                     if (i != -1) {
                        i_709_ = i;
                     }

                     entitynode_sub5.anInt5983 = this.aPureJavaToolkit5770.anInt6786
                        + (int)((f_696_ + (float)this.aShort5777) * (float)i_651_ / (float)i_709_)
                        - entitynode_sub5.anInt5982;
                  }

                  entitynode_sub5.aBoolean5987 = true;
               }
            }

            this.method655(true);
            this.aClass185_5712.aBoolean2226 = (i_624_ & 1) == 0;
            this.aClass185_5712.aBoolean2212 = false;

            try {
               boolean bool_710_ = (i_624_ & 4) != 0;
               if (bool_710_) {
                  this.method668(
                     bool_648_,
                     this.aClass374_5741.aBoolean4621 && i_629_ > this.aClass374_5741.anInt4618 || this.aClass374_5741.aBoolean4617,
                     i_628_,
                     i_629_ - i_628_
                  );
               } else {
                  this.method681(
                     bool_648_,
                     this.aClass374_5741.aBoolean4621 && i_629_ > this.aClass374_5741.anInt4618 || this.aClass374_5741.aBoolean4617,
                     i_628_,
                     i_629_ - i_628_
                  );
               }
            } catch (Exception var56) {
            }

            if (this.aClass209Array5790 != null) {
               for(int i_711_ = 0; i_711_ < this.anInt5711; ++i_711_) {
                  this.anIntArray5756[i_711_] = -1;
               }
            }

            this.aClass185_5712 = null;
            if (this.aPureJavaToolkit5770.anInt6795 > 1) {
               synchronized(this) {
                  this.aBoolean5715 = false;
                  this.notifyAll();
               }
            }
         }
      }
   }

   @Override
   final void s(int i) {
      if (this.aPureJavaToolkit5770.anInt6795 > 1) {
         synchronized(this) {
            if ((this.anInt5746 & 65536) == 65536 && (i & 65536) == 0) {
               this.method655(true);
            }

            this.anInt5746 = i;
         }
      } else {
         if ((this.anInt5746 & 65536) == 65536 && (i & 65536) == 0) {
            this.method655(true);
         }

         this.anInt5746 = i;
      }
   }

   private final void method681(boolean bool, boolean bool_712_, int i, int i_713_) {
      Class209 class209;
      if (this.aClass209Array5790 != null) {
         for(int i_714_ = 0; i_714_ < this.anInt5762; this.anIntArray5756[class209.anInt2485] = i_714_++) {
            class209 = this.aClass209Array5790[i_714_];
         }
      }

      if (!this.aBoolean5720 && this.aClass209Array5790 == null) {
         for(int i_720_ = 0; i_720_ < this.anInt5711; ++i_720_) {
            this.method674(i_720_, bool, bool_712_);
         }
      } else if ((this.anInt5746 & 256) == 0 && this.aShortArray5719 != null) {
         for(int i_715_ = 0; i_715_ < this.anInt5711; ++i_715_) {
            short s = this.aShortArray5719[i_715_];
            this.method674(s, bool, bool_712_);
         }
      } else {
         for(int i_716_ = 0; i_716_ < this.anInt5711; ++i_716_) {
            if (!this.method658(i_716_) && !this.method678(i_716_)) {
               this.method674(i_716_, bool, bool_712_);
            }
         }

         if (this.aByteArray5768 == null) {
            for(int i_717_ = 0; i_717_ < this.anInt5711; ++i_717_) {
               if (this.method658(i_717_) || this.method678(i_717_)) {
                  this.method674(i_717_, bool, bool_712_);
               }
            }
         } else {
            for(int i_718_ = 0; i_718_ < 12; ++i_718_) {
               for(int i_719_ = 0; i_719_ < this.anInt5711; ++i_719_) {
                  if (this.aByteArray5768[i_719_] == i_718_ && (this.method658(i_719_) || this.method678(i_719_))) {
                     this.method674(i_719_, bool, bool_712_);
                  }
               }
            }
         }
      }
   }

   @Override
   final int ma() {
      if (!this.aBoolean5792) {
         this.method677();
      }

      return this.aShort5755;
   }

   @Override
   final void aa(short s, short s_721_) {
      if (this.aShortArray5773 != null) {
         if (!this.aBoolean5788 && s_721_ >= 0) {
            TextureDefinitions class91 = this.aPureJavaToolkit5770.aD1543.getTexture(s_721_ & '\uffff', -8217);
            if (class91.speedU != 0 || class91.speedV != 0) {
               this.aBoolean5788 = true;
            }
         }

         for(int i = 0; i < this.anInt5711; ++i) {
            if (this.aShortArray5773[i] == s) {
               this.aShortArray5773[i] = s_721_;
            }
         }
      }
   }

   private final void method682() {
      synchronized(this) {
         for(int i = 0; i < this.anInt5753; ++i) {
            this.anIntArray5748[i] = -this.anIntArray5748[i];
            this.anIntArray5717[i] = -this.anIntArray5717[i];
            if (this.aClass354Array5774[i] != null) {
               this.aClass354Array5774[i].anInt4347 = -this.aClass354Array5774[i].anInt4347;
               this.aClass354Array5774[i].anInt4346 = -this.aClass354Array5774[i].anInt4346;
            }
         }

         if (this.aClass272Array5775 != null) {
            for(int i = 0; i < this.anInt5711; ++i) {
               if (this.aClass272Array5775[i] != null) {
                  this.aClass272Array5775[i].anInt3484 = -this.aClass272Array5775[i].anInt3484;
                  this.aClass272Array5775[i].anInt3483 = -this.aClass272Array5775[i].anInt3483;
               }
            }
         }

         for(int i = this.anInt5753; i < this.anInt5718; ++i) {
            this.anIntArray5748[i] = -this.anIntArray5748[i];
            this.anIntArray5717[i] = -this.anIntArray5717[i];
         }

         this.anInt5744 = 0;
         this.aBoolean5792 = false;
      }
   }

   private final int method683(int i, short s, int i_722_) {
      int i_723_ = Class85.colors[this.method686(i, i_722_)];
      TextureDefinitions class91 = this.aPureJavaToolkit5770.aD1543.getTexture(s & '\uffff', -8217);
      int i_724_ = class91.shadowFactor & 255;
      if (i_724_ != 0) {
         int i_725_ = 131586 * i_722_;
         if (i_724_ == 256) {
            i_723_ = i_725_;
         } else {
            int i_727_ = 256 - i_724_;
            i_723_ = ((i_725_ & 16711935) * i_724_ + (i_723_ & 16711935) * i_727_ & -16711936)
                  + ((i_725_ & 0xFF00) * i_724_ + (i_723_ & 0xFF00) * i_727_ & 0xFF0000)
               >> 8;
         }
      }

      int i_728_ = class91.brightness & 255;
      if (i_728_ != 0) {
         i_728_ += 256;
         int i_729_ = ((i_723_ & 0xFF0000) >> 16) * i_728_;
         if (i_729_ > 65535) {
            i_729_ = 65535;
         }

         int i_730_ = ((i_723_ & 0xFF00) >> 8) * i_728_;
         if (i_730_ > 65535) {
            i_730_ = 65535;
         }

         int i_731_ = (i_723_ & 0xFF) * i_728_;
         if (i_731_ > 65535) {
            i_731_ = 65535;
         }

         i_723_ = (i_729_ << 8 & 0xFF0000) + (i_730_ & 0xFF00) + (i_731_ >> 8);
      }

      return i_723_;
   }

   @Override
   final void VA(int i) {
      if ((this.anInt5746 & 3) != 3) {
         throw new IllegalStateException();
      } else {
         int i_732_ = Class335.anIntArray4167[i];
         int i_733_ = Class335.anIntArray4165[i];
         synchronized(this) {
            for(int i_734_ = 0; i_734_ < this.anInt5718; ++i_734_) {
               int i_735_ = this.anIntArray5772[i_734_] * i_732_ + this.anIntArray5748[i_734_] * i_733_ >> 14;
               this.anIntArray5772[i_734_] = this.anIntArray5772[i_734_] * i_733_ - this.anIntArray5748[i_734_] * i_732_ >> 14;
               this.anIntArray5748[i_734_] = i_735_;
            }

            this.method656();
         }
      }
   }

   private final void method684() {
      synchronized(this) {
         for(int i = 0; i < this.anInt5753; ++i) {
            int i_736_ = this.anIntArray5717[i];
            this.anIntArray5717[i] = this.anIntArray5748[i];
            this.anIntArray5748[i] = -i_736_;
            if (this.aClass354Array5774[i] != null) {
               i_736_ = this.aClass354Array5774[i].anInt4346;
               this.aClass354Array5774[i].anInt4346 = this.aClass354Array5774[i].anInt4347;
               this.aClass354Array5774[i].anInt4347 = -i_736_;
            }
         }

         if (this.aClass272Array5775 != null) {
            for(int i = 0; i < this.anInt5711; ++i) {
               if (this.aClass272Array5775[i] != null) {
                  int i_737_ = this.aClass272Array5775[i].anInt3483;
                  this.aClass272Array5775[i].anInt3483 = this.aClass272Array5775[i].anInt3484;
                  this.aClass272Array5775[i].anInt3484 = -i_737_;
               }
            }
         }

         for(int i = this.anInt5753; i < this.anInt5718; ++i) {
            int i_738_ = this.anIntArray5717[i];
            this.anIntArray5717[i] = this.anIntArray5748[i];
            this.anIntArray5748[i] = -i_738_;
         }

         this.anInt5744 = 0;
         this.aBoolean5792 = false;
      }
   }

   @Override
   final int G() {
      if (!this.aBoolean5792) {
         this.method677();
      }

      return this.aShort5730;
   }

   private final void method685(int i) {
      short s = this.aShortArray5767[i];
      short s_739_ = this.aShortArray5731[i];
      short s_740_ = this.aShortArray5789[i];
      if (this.aShortArray5773 != null && this.aShortArray5773[i] != -1) {
         int i_741_ = -16777216;
         if (this.aByteArray5784 != null) {
            i_741_ = 255 - (this.aByteArray5784[i] & 255) << 24;
         }

         if (this.anIntArray5761[i] == -1) {
            int i_742_ = i_741_ | this.anIntArray5754[i] & 16777215;
            this.aClass185_5712
               .method1859(
                  (float)this.anIntArray5716[s],
                  (float)this.anIntArray5716[s_739_],
                  (float)this.anIntArray5716[s_740_],
                  (float)this.anIntArray5713[s],
                  (float)this.anIntArray5713[s_739_],
                  (float)this.anIntArray5713[s_740_],
                  (float)this.anIntArray5758[s],
                  (float)this.anIntArray5758[s_739_],
                  (float)this.anIntArray5758[s_740_],
                  this.aFloatArrayArray5763[i][0],
                  this.aFloatArrayArray5763[i][1],
                  this.aFloatArrayArray5763[i][2],
                  this.aFloatArrayArray5776[i][0],
                  this.aFloatArrayArray5776[i][1],
                  this.aFloatArrayArray5776[i][2],
                  i_742_,
                  i_742_,
                  i_742_,
                  this.aClass374_5741.anInt4611,
                  0,
                  0,
                  0,
                  this.aShortArray5773[i]
               );
         } else {
            this.aClass185_5712
               .method1859(
                  (float)this.anIntArray5716[s],
                  (float)this.anIntArray5716[s_739_],
                  (float)this.anIntArray5716[s_740_],
                  (float)this.anIntArray5713[s],
                  (float)this.anIntArray5713[s_739_],
                  (float)this.anIntArray5713[s_740_],
                  (float)this.anIntArray5758[s],
                  (float)this.anIntArray5758[s_739_],
                  (float)this.anIntArray5758[s_740_],
                  this.aFloatArrayArray5763[i][0],
                  this.aFloatArrayArray5763[i][1],
                  this.aFloatArrayArray5763[i][2],
                  this.aFloatArrayArray5776[i][0],
                  this.aFloatArrayArray5776[i][1],
                  this.aFloatArrayArray5776[i][2],
                  i_741_ | this.anIntArray5754[i] & 16777215,
                  i_741_ | this.anIntArray5739[i] & 16777215,
                  i_741_ | this.anIntArray5761[i] & 16777215,
                  this.aClass374_5741.anInt4611,
                  0,
                  0,
                  0,
                  this.aShortArray5773[i]
               );
         }
      } else {
         if (this.aByteArray5784 == null) {
            this.aClass185_5712.anInt2220 = 0;
         } else {
            this.aClass185_5712.anInt2220 = this.aByteArray5784[i] & 255;
         }

         if (this.anIntArray5761[i] == -1) {
            this.aClass185_5712
               .method1867(
                  (float)this.anIntArray5716[s],
                  (float)this.anIntArray5716[s_739_],
                  (float)this.anIntArray5716[s_740_],
                  (float)this.anIntArray5713[s],
                  (float)this.anIntArray5713[s_739_],
                  (float)this.anIntArray5713[s_740_],
                  (float)this.anIntArray5758[s],
                  (float)this.anIntArray5758[s_739_],
                  (float)this.anIntArray5758[s_740_],
                  Class170.anIntArray2054[this.anIntArray5754[i] & 65535]
               );
         } else {
            this.aClass185_5712
               .method1865(
                  (float)this.anIntArray5716[s],
                  (float)this.anIntArray5716[s_739_],
                  (float)this.anIntArray5716[s_740_],
                  (float)this.anIntArray5713[s],
                  (float)this.anIntArray5713[s_739_],
                  (float)this.anIntArray5713[s_740_],
                  (float)this.anIntArray5758[s],
                  (float)this.anIntArray5758[s_739_],
                  (float)this.anIntArray5758[s_740_],
                  (float)(this.anIntArray5754[i] & 65535),
                  (float)(this.anIntArray5739[i] & 65535),
                  (float)(this.anIntArray5761[i] & 65535)
               );
         }
      }
   }

   @Override
   final boolean r() {
      return this.aBoolean5788;
   }

   @Override
   final boolean NA() {
      if (this.anIntArrayArray5722 == null) {
         return false;
      } else {
         this.anInt5779 = 0;
         this.anInt5752 = 0;
         this.anInt5743 = 0;
         return true;
      }
   }

   @Override
   final void p(int i, int i_743_, Plane plane, Plane plane_744_, int i_745_, int i_746_, int i_747_) {
      if (i == 3) {
         if ((this.anInt5746 & 7) != 7) {
            throw new IllegalStateException();
         }
      } else if ((this.anInt5746 & 2) != 2) {
         throw new IllegalStateException();
      }

      if (!this.aBoolean5792) {
         this.method677();
      }

      int i_748_ = i_745_ + this.aShort5757;
      int i_749_ = i_745_ + this.aShort5766;
      int i_750_ = i_747_ + this.aShort5732;
      int i_751_ = i_747_ + this.aShort5730;
      if (i == 4
         || i_748_ >= 0
            && i_749_ + plane.anInt3398 >> plane.anInt3410 < plane.anInt3408
            && i_750_ >= 0
            && i_751_ + plane.anInt3398 >> plane.anInt3410 < plane.anInt3404) {
         int[][] is = ((Plane_Sub1)plane).tileVerticeHeights;
         int[][] is_752_ = null;
         if (plane_744_ != null) {
            is_752_ = ((Plane_Sub1)plane_744_).tileVerticeHeights;
         }

         if (i != 4 && i != 5) {
            i_748_ >>= plane.anInt3410;
            i_749_ = i_749_ + plane.anInt3398 - 1 >> plane.anInt3410;
            i_750_ >>= plane.anInt3410;
            i_751_ = i_751_ + plane.anInt3398 - 1 >> plane.anInt3410;
            if (is[i_748_][i_750_] == i_746_ && is[i_749_][i_750_] == i_746_ && is[i_748_][i_751_] == i_746_ && is[i_749_][i_751_] == i_746_) {
               return;
            }
         } else if (plane_744_ == null
            || i_748_ < 0
            || i_749_ + plane_744_.anInt3398 >> plane_744_.anInt3410 >= plane_744_.anInt3408
            || i_750_ < 0
            || i_751_ + plane_744_.anInt3398 >> plane_744_.anInt3410 >= plane_744_.anInt3404) {
            return;
         }

         synchronized(this) {
            if (i == 1) {
               int i_753_ = plane.anInt3398 - 1;

               for(int i_754_ = 0; i_754_ < this.anInt5753; ++i_754_) {
                  int i_755_ = this.anIntArray5748[i_754_] + i_745_;
                  int i_756_ = this.anIntArray5717[i_754_] + i_747_;
                  int i_757_ = i_755_ & i_753_;
                  int i_758_ = i_756_ & i_753_;
                  int i_759_ = i_755_ >> plane.anInt3410;
                  int i_760_ = i_756_ >> plane.anInt3410;
                  int i_761_ = is[i_759_][i_760_] * (plane.anInt3398 - i_757_) + is[i_759_ + 1][i_760_] * i_757_ >> plane.anInt3410;
                  int i_762_ = is[i_759_][i_760_ + 1] * (plane.anInt3398 - i_757_) + is[i_759_ + 1][i_760_ + 1] * i_757_ >> plane.anInt3410;
                  int i_763_ = i_761_ * (plane.anInt3398 - i_758_) + i_762_ * i_758_ >> plane.anInt3410;
                  this.anIntArray5772[i_754_] = this.anIntArray5772[i_754_] + i_763_ - i_746_;
               }

               for(int i_764_ = this.anInt5753; i_764_ < this.anInt5718; ++i_764_) {
                  int i_765_ = this.anIntArray5748[i_764_] + i_745_;
                  int i_766_ = this.anIntArray5717[i_764_] + i_747_;
                  int i_767_ = i_765_ & i_753_;
                  int i_768_ = i_766_ & i_753_;
                  int i_769_ = i_765_ >> plane.anInt3410;
                  int i_770_ = i_766_ >> plane.anInt3410;
                  if (i_769_ >= 0 && i_769_ < is.length - 1 && i_770_ >= 0 && i_770_ < is[0].length - 1) {
                     int i_771_ = is[i_769_][i_770_] * (plane.anInt3398 - i_767_) + is[i_769_ + 1][i_770_] * i_767_ >> plane.anInt3410;
                     int i_772_ = is[i_769_][i_770_ + 1] * (plane.anInt3398 - i_767_) + is[i_769_ + 1][i_770_ + 1] * i_767_ >> plane.anInt3410;
                     int i_773_ = i_771_ * (plane.anInt3398 - i_768_) + i_772_ * i_768_ >> plane.anInt3410;
                     this.anIntArray5772[i_764_] = this.anIntArray5772[i_764_] + i_773_ - i_746_;
                  }
               }
            } else if (i == 2) {
               int i_774_ = plane.anInt3398 - 1;

               for(int i_775_ = 0; i_775_ < this.anInt5753; ++i_775_) {
                  int i_776_ = (this.anIntArray5772[i_775_] << 16) / this.aShort5759;
                  if (i_776_ < i_743_) {
                     int i_777_ = this.anIntArray5748[i_775_] + i_745_;
                     int i_778_ = this.anIntArray5717[i_775_] + i_747_;
                     int i_779_ = i_777_ & i_774_;
                     int i_780_ = i_778_ & i_774_;
                     int i_781_ = i_777_ >> plane.anInt3410;
                     int i_782_ = i_778_ >> plane.anInt3410;
                     int i_783_ = is[i_781_][i_782_] * (plane.anInt3398 - i_779_) + is[i_781_ + 1][i_782_] * i_779_ >> plane.anInt3410;
                     int i_784_ = is[i_781_][i_782_ + 1] * (plane.anInt3398 - i_779_) + is[i_781_ + 1][i_782_ + 1] * i_779_ >> plane.anInt3410;
                     int i_785_ = i_783_ * (plane.anInt3398 - i_780_) + i_784_ * i_780_ >> plane.anInt3410;
                     this.anIntArray5772[i_775_] += (i_785_ - i_746_) * (i_743_ - i_776_) / i_743_;
                  } else {
                     this.anIntArray5772[i_775_] = this.anIntArray5772[i_775_];
                  }
               }

               for(int i_786_ = this.anInt5753; i_786_ < this.anInt5718; ++i_786_) {
                  int i_787_ = (this.anIntArray5772[i_786_] << 16) / this.aShort5759;
                  if (i_787_ < i_743_) {
                     int i_788_ = this.anIntArray5748[i_786_] + i_745_;
                     int i_789_ = this.anIntArray5717[i_786_] + i_747_;
                     int i_790_ = i_788_ & i_774_;
                     int i_791_ = i_789_ & i_774_;
                     int i_792_ = i_788_ >> plane.anInt3410;
                     int i_793_ = i_789_ >> plane.anInt3410;
                     if (i_792_ >= 0 && i_792_ < plane.anInt3408 - 1 && i_793_ >= 0 && i_793_ < plane.anInt3404 - 1) {
                        int i_794_ = is[i_792_][i_793_] * (plane.anInt3398 - i_790_) + is[i_792_ + 1][i_793_] * i_790_ >> plane.anInt3410;
                        int i_795_ = is[i_792_][i_793_ + 1] * (plane.anInt3398 - i_790_) + is[i_792_ + 1][i_793_ + 1] * i_790_ >> plane.anInt3410;
                        int i_796_ = i_794_ * (plane.anInt3398 - i_791_) + i_795_ * i_791_ >> plane.anInt3410;
                        this.anIntArray5772[i_786_] += (i_796_ - i_746_) * (i_743_ - i_787_) / i_743_;
                     }
                  } else {
                     this.anIntArray5772[i_786_] = this.anIntArray5772[i_786_];
                  }
               }
            } else if (i == 3) {
               int i_797_ = (i_743_ & 0xFF) * 4;
               int i_798_ = (i_743_ >> 8 & 0xFF) * 4;
               int i_799_ = (i_743_ >> 16 & 0xFF) << 6;
               int i_800_ = (i_743_ >> 24 & 0xFF) << 6;
               if (i_745_ - (i_797_ >> 1) < 0
                  || i_745_ + (i_797_ >> 1) + plane.anInt3398 >= plane.anInt3408 << plane.anInt3410
                  || i_747_ - (i_798_ >> 1) < 0
                  || i_747_ + (i_798_ >> 1) + plane.anInt3398 >= plane.anInt3404 << plane.anInt3410) {
                  return;
               }

               this.method628(i_746_, i_799_, i_745_, -7024, i_797_, i_747_, i_798_, plane, i_800_);
            } else if (i == 4) {
               int i_801_ = plane_744_.anInt3398 - 1;
               int i_802_ = this.aShort5751 - this.aShort5759;

               for(int i_803_ = 0; i_803_ < this.anInt5753; ++i_803_) {
                  int i_804_ = this.anIntArray5748[i_803_] + i_745_;
                  int i_805_ = this.anIntArray5717[i_803_] + i_747_;
                  int i_806_ = i_804_ & i_801_;
                  int i_807_ = i_805_ & i_801_;
                  int i_808_ = i_804_ >> plane_744_.anInt3410;
                  int i_809_ = i_805_ >> plane_744_.anInt3410;
                  int i_810_ = is_752_[i_808_][i_809_] * (plane_744_.anInt3398 - i_806_) + is_752_[i_808_ + 1][i_809_] * i_806_ >> plane_744_.anInt3410;
                  int i_811_ = is_752_[i_808_][i_809_ + 1] * (plane_744_.anInt3398 - i_806_) + is_752_[i_808_ + 1][i_809_ + 1] * i_806_
                     >> plane_744_.anInt3410;
                  int i_812_ = i_810_ * (plane_744_.anInt3398 - i_807_) + i_811_ * i_807_ >> plane_744_.anInt3410;
                  this.anIntArray5772[i_803_] = this.anIntArray5772[i_803_] + i_812_ - i_746_ + i_802_;
               }

               for(int i_813_ = this.anInt5753; i_813_ < this.anInt5718; ++i_813_) {
                  int i_814_ = this.anIntArray5748[i_813_] + i_745_;
                  int i_815_ = this.anIntArray5717[i_813_] + i_747_;
                  int i_816_ = i_814_ & i_801_;
                  int i_817_ = i_815_ & i_801_;
                  int i_818_ = i_814_ >> plane_744_.anInt3410;
                  int i_819_ = i_815_ >> plane_744_.anInt3410;
                  if (i_818_ >= 0 && i_818_ < plane_744_.anInt3408 - 1 && i_819_ >= 0 && i_819_ < plane_744_.anInt3404 - 1) {
                     int i_820_ = is_752_[i_818_][i_819_] * (plane_744_.anInt3398 - i_816_) + is_752_[i_818_ + 1][i_819_] * i_816_ >> plane_744_.anInt3410;
                     int i_821_ = is_752_[i_818_][i_819_ + 1] * (plane_744_.anInt3398 - i_816_) + is_752_[i_818_ + 1][i_819_ + 1] * i_816_
                        >> plane_744_.anInt3410;
                     int i_822_ = i_820_ * (plane_744_.anInt3398 - i_817_) + i_821_ * i_817_ >> plane_744_.anInt3410;
                     this.anIntArray5772[i_813_] = this.anIntArray5772[i_813_] + i_822_ - i_746_ + i_802_;
                  }
               }
            } else if (i == 5) {
               int i_823_ = plane_744_.anInt3398 - 1;
               int i_824_ = this.aShort5751 - this.aShort5759;

               for(int i_825_ = 0; i_825_ < this.anInt5753; ++i_825_) {
                  int i_826_ = this.anIntArray5748[i_825_] + i_745_;
                  int i_827_ = this.anIntArray5717[i_825_] + i_747_;
                  int i_828_ = i_826_ & i_823_;
                  int i_829_ = i_827_ & i_823_;
                  int i_830_ = i_826_ >> plane.anInt3410;
                  int i_831_ = i_827_ >> plane.anInt3410;
                  int i_832_ = is[i_830_][i_831_] * (plane.anInt3398 - i_828_) + is[i_830_ + 1][i_831_] * i_828_ >> plane.anInt3410;
                  int i_833_ = is[i_830_][i_831_ + 1] * (plane.anInt3398 - i_828_) + is[i_830_ + 1][i_831_ + 1] * i_828_ >> plane.anInt3410;
                  int i_834_ = i_832_ * (plane.anInt3398 - i_829_) + i_833_ * i_829_ >> plane.anInt3410;
                  i_832_ = is_752_[i_830_][i_831_] * (plane_744_.anInt3398 - i_828_) + is_752_[i_830_ + 1][i_831_] * i_828_ >> plane_744_.anInt3410;
                  i_833_ = is_752_[i_830_][i_831_ + 1] * (plane_744_.anInt3398 - i_828_) + is_752_[i_830_ + 1][i_831_ + 1] * i_828_ >> plane_744_.anInt3410;
                  int i_835_ = i_832_ * (plane_744_.anInt3398 - i_829_) + i_833_ * i_829_ >> plane_744_.anInt3410;
                  int i_836_ = i_834_ - i_835_ - i_743_;
                  this.anIntArray5772[i_825_] = ((this.anIntArray5772[i_825_] << 8) / i_824_ * i_836_ >> 8) - (i_746_ - i_834_);
               }

               for(int i_837_ = this.anInt5753; i_837_ < this.anInt5718; ++i_837_) {
                  int i_838_ = this.anIntArray5748[i_837_] + i_745_;
                  int i_839_ = this.anIntArray5717[i_837_] + i_747_;
                  int i_840_ = i_838_ & i_823_;
                  int i_841_ = i_839_ & i_823_;
                  int i_842_ = i_838_ >> plane.anInt3410;
                  int i_843_ = i_839_ >> plane.anInt3410;
                  if (i_842_ >= 0
                     && i_842_ < plane.anInt3408 - 1
                     && i_842_ < plane_744_.anInt3408 - 1
                     && i_843_ >= 0
                     && i_843_ < plane.anInt3404 - 1
                     && i_843_ < plane_744_.anInt3404 - 1) {
                     int i_844_ = is[i_842_][i_843_] * (plane.anInt3398 - i_840_) + is[i_842_ + 1][i_843_] * i_840_ >> plane.anInt3410;
                     int i_845_ = is[i_842_][i_843_ + 1] * (plane.anInt3398 - i_840_) + is[i_842_ + 1][i_843_ + 1] * i_840_ >> plane.anInt3410;
                     int i_846_ = i_844_ * (plane.anInt3398 - i_841_) + i_845_ * i_841_ >> plane.anInt3410;
                     i_844_ = is_752_[i_842_][i_843_] * (plane_744_.anInt3398 - i_840_) + is_752_[i_842_ + 1][i_843_] * i_840_ >> plane_744_.anInt3410;
                     i_845_ = is_752_[i_842_][i_843_ + 1] * (plane_744_.anInt3398 - i_840_) + is_752_[i_842_ + 1][i_843_ + 1] * i_840_ >> plane_744_.anInt3410;
                     int i_847_ = i_844_ * (plane_744_.anInt3398 - i_841_) + i_845_ * i_841_ >> plane_744_.anInt3410;
                     int i_848_ = i_846_ - i_847_ - i_743_;
                     this.anIntArray5772[i_837_] = ((this.anIntArray5772[i_837_] << 8) / i_824_ * i_848_ >> 8) - (i_746_ - i_846_);
                  }
               }
            }

            this.aBoolean5792 = false;
         }
      }
   }

   private final int method686(int i, int i_849_) {
      i_849_ = i_849_ * (i & 127) >> 7;
      if (i_849_ < 2) {
         i_849_ = 2;
      } else if (i_849_ > 126) {
         i_849_ = 126;
      }

      return (i & 65408) + i_849_;
   }

   private final void method687(Thread thread) {
      Class374 class374 = this.aPureJavaToolkit5770.method1494(thread);
      if (class374 != this.aClass374_5726) {
         this.aClass374_5726 = class374;
         this.aPureJavaDrawableModelArray5750 = this.aClass374_5726.aPureJavaDrawableModelArray4652;
         this.aPureJavaDrawableModelArray5733 = this.aClass374_5726.aPureJavaDrawableModelArray4651;
      }
   }

   PureJavaDrawableModel(PureJavaToolkit purejavatoolkit) {
      this.anInt5711 = 0;
      this.anInt5753 = 0;
      this.anInt5718 = 0;
      this.aBoolean5734 = false;
      this.aBoolean5720 = false;
      this.anInt5744 = 0;
      this.aBoolean5723 = false;
      this.aBoolean5792 = false;
      this.aBoolean5788 = false;
      this.aPureJavaToolkit5770 = purejavatoolkit;
   }

   PureJavaDrawableModel(PureJavaToolkit purejavatoolkit, Model model, int i, int i_850_, int i_851_, int i_852_) {
      this.anInt5711 = 0;
      this.anInt5753 = 0;
      this.anInt5718 = 0;
      this.aBoolean5734 = false;
      this.aBoolean5720 = false;
      this.anInt5744 = 0;
      this.aBoolean5723 = false;
      this.aBoolean5792 = false;
      this.aBoolean5788 = false;
      this.aPureJavaToolkit5770 = purejavatoolkit;
      this.anInt5746 = i;
      this.anInt5791 = i_850_;
      this.anInt5727 = i_851_;
      d var_d = this.aPureJavaToolkit5770.aD1543;
      this.anInt5718 = model.anInt2599;
      this.anInt5753 = model.anInt2573;
      this.anIntArray5748 = model.anIntArray2616;
      this.anIntArray5772 = model.anIntArray2576;
      this.anIntArray5717 = model.anIntArray2574;
      this.anInt5711 = model.anInt2572;
      this.aShortArray5767 = model.aShortArray2600;
      this.aShortArray5731 = model.aShortArray2583;
      this.aShortArray5789 = model.aShortArray2589;
      this.aByteArray5768 = model.aByteArray2607;
      this.aShortArray5740 = model.aShortArray2580;
      this.aByteArray5784 = model.aByteArray2622;
      this.aShortArray5787 = model.aShortArray2575;
      this.aByteArray5736 = model.aByteArray2594;
      this.aClass300Array5782 = model.aClass300Array2590;
      this.aClass218Array5764 = model.aClass218Array2620;
      this.aShortArray5747 = model.aShortArray2582;
      int[] is = new int[this.anInt5711];
      int i_853_ = 0;

      while(i_853_ < this.anInt5711) {
         is[i_853_] = i_853_++;
      }

      long[] ls = new long[this.anInt5711];
      boolean bool = (this.anInt5746 & 256) != 0;

      for(int i_854_ = 0; i_854_ < this.anInt5711; ++i_854_) {
         int i_855_ = is[i_854_];
         TextureDefinitions class91 = null;
         int i_856_ = 0;
         int i_857_ = 0;
         int i_858_ = 0;
         int i_859_ = 0;
         if (model.aClass17Array2621 != null) {
            boolean bool_860_ = false;

            for(int i_861_ = 0; i_861_ < model.aClass17Array2621.length; ++i_861_) {
               Class17 class17 = model.aClass17Array2621[i_861_];
               if (i_855_ == class17.anInt273) {
                  Class352 class352 = Class215.method2067(0, class17.anInt279);
                  if (class352.aBoolean4325) {
                     bool_860_ = true;
                  }

                  if (class352.anInt4330 != -1) {
                     TextureDefinitions class91_862_ = var_d.getTexture(class352.anInt4330, -8217);
                     if (class91_862_.unknown1 == 2) {
                        this.aBoolean5720 = true;
                     }
                  }
               }
            }

            if (bool_860_) {
               ls[i_854_] = Long.MAX_VALUE;
            }
         }

         int i_863_ = -1;
         if (model.aShortArray2587 != null) {
            i_863_ = model.aShortArray2587[i_855_];
            if (i_863_ != -1) {
               class91 = var_d.getTexture(i_863_ & 65535, -8217);
               if ((i_852_ & 64) != 0 && class91.meshGround) {
                  i_863_ = -1;
               } else {
                  i_858_ = class91.effect;
                  i_859_ = class91.effectParam1;
               }
            }
         }

         boolean bool_864_ = this.aByteArray5784 != null && this.aByteArray5784[i_855_] != 0 || class91 != null && class91.unknown1 == 2;
         if ((bool || bool_864_) && this.aByteArray5768 != null) {
            i_856_ += this.aByteArray5768[i_855_] << 17;
         }

         if (bool_864_) {
            i_856_ += 65536;
         }

         i_856_ += (i_858_ & 0xFF) << 8;
         i_856_ += i_859_ & 0xFF;
         i_857_ += (i_863_ & 65535) << 16;
         i_857_ += i_854_ & 65535;
         ls[i_854_] = ((long)i_856_ << 32) + (long)i_857_;
         this.aBoolean5720 |= bool_864_;
      }

      Node_Sub3.method2170(122, ls, is);
      if (model.aClass17Array2621 != null) {
         this.anInt5762 = model.aClass17Array2621.length;
         this.aClass209Array5790 = new Class209[this.anInt5762];
         this.aClass214Array5765 = new Class214[this.anInt5762];

         for(int i_865_ = 0; i_865_ < model.aClass17Array2621.length; ++i_865_) {
            Class17 class17 = model.aClass17Array2621[i_865_];
            Class352 class352 = Class215.method2067(0, class17.anInt279);
            int i_866_ = Class170.anIntArray2054[model.aShortArray2580[class17.anInt273] & '\uffff'] & 16777215;
            i_866_ |= 255 - (model.aByteArray2622 != null ? model.aByteArray2622[class17.anInt273] & 255 : 0) << 24;
            this.aClass209Array5790[i_865_] = new Class209(
               class17.anInt273,
               model.aShortArray2600[class17.anInt273],
               model.aShortArray2583[class17.anInt273],
               model.aShortArray2589[class17.anInt273],
               class352.anInt4334,
               class352.anInt4326,
               class352.anInt4330,
               class352.anInt4336,
               class352.anInt4324,
               class352.aBoolean4325,
               class17.anInt278
            );
            this.aClass214Array5765[i_865_] = new Class214(i_866_);
         }
      }

      this.aFloatArrayArray5763 = new float[this.anInt5711][];
      this.aFloatArrayArray5776 = new float[this.anInt5711][];
      Class345 class345 = Class34.method367(87, model, this.anInt5711, is);
      Class374 class374 = this.aPureJavaToolkit5770.method1494(Thread.currentThread());
      float[] fs = class374.aFloatArray4638;
      boolean bool_867_ = false;

      for(int i_868_ = 0; i_868_ < this.anInt5711; ++i_868_) {
         int i_869_ = is[i_868_];
         int i_870_;
         if (model.aByteArray2610 == null) {
            i_870_ = -1;
         } else {
            i_870_ = model.aByteArray2610[i_869_];
         }

         int i_871_ = model.aShortArray2587 == null ? -1 : model.aShortArray2587[i_869_];
         if (i_871_ != -1 && (i_852_ & 64) != 0) {
            TextureDefinitions class91 = var_d.getTexture(i_871_ & 65535, -8217);
            if (class91.meshGround) {
               i_871_ = -1;
            }
         }

         if (i_871_ != -1) {
            bool_867_ = true;
            float[] fs_872_ = this.aFloatArrayArray5763[i_869_] = new float[3];
            float[] fs_873_ = this.aFloatArrayArray5776[i_869_] = new float[3];
            if (i_870_ == -1) {
               fs_872_[0] = 0.0F;
               fs_873_[0] = 1.0F;
               fs_872_[1] = 1.0F;
               fs_873_[1] = 1.0F;
               fs_872_[2] = 0.0F;
               fs_873_[2] = 0.0F;
            } else {
               i_870_ &= 255;
               byte b = model.aByteArray2586[i_870_];
               if (b == 0) {
                  short s = this.aShortArray5767[i_869_];
                  short s_875_ = this.aShortArray5731[i_869_];
                  short s_876_ = this.aShortArray5789[i_869_];
                  short s_877_ = model.aShortArray2613[i_870_];
                  short s_878_ = model.aShortArray2577[i_870_];
                  short s_879_ = model.aShortArray2604[i_870_];
                  float f = (float)this.anIntArray5748[s_877_];
                  float f_880_ = (float)this.anIntArray5772[s_877_];
                  float f_881_ = (float)this.anIntArray5717[s_877_];
                  float f_882_ = (float)this.anIntArray5748[s_878_] - f;
                  float f_883_ = (float)this.anIntArray5772[s_878_] - f_880_;
                  float f_884_ = (float)this.anIntArray5717[s_878_] - f_881_;
                  float f_885_ = (float)this.anIntArray5748[s_879_] - f;
                  float f_886_ = (float)this.anIntArray5772[s_879_] - f_880_;
                  float f_887_ = (float)this.anIntArray5717[s_879_] - f_881_;
                  float f_888_ = (float)this.anIntArray5748[s] - f;
                  float f_889_ = (float)this.anIntArray5772[s] - f_880_;
                  float f_890_ = (float)this.anIntArray5717[s] - f_881_;
                  float f_891_ = (float)this.anIntArray5748[s_875_] - f;
                  float f_892_ = (float)this.anIntArray5772[s_875_] - f_880_;
                  float f_893_ = (float)this.anIntArray5717[s_875_] - f_881_;
                  float f_894_ = (float)this.anIntArray5748[s_876_] - f;
                  float f_895_ = (float)this.anIntArray5772[s_876_] - f_880_;
                  float f_896_ = (float)this.anIntArray5717[s_876_] - f_881_;
                  float f_897_ = f_883_ * f_887_ - f_884_ * f_886_;
                  float f_898_ = f_884_ * f_885_ - f_882_ * f_887_;
                  float f_899_ = f_882_ * f_886_ - f_883_ * f_885_;
                  float f_900_ = f_886_ * f_899_ - f_887_ * f_898_;
                  float f_901_ = f_887_ * f_897_ - f_885_ * f_899_;
                  float f_902_ = f_885_ * f_898_ - f_886_ * f_897_;
                  float f_903_ = 1.0F / (f_900_ * f_882_ + f_901_ * f_883_ + f_902_ * f_884_);
                  fs_872_[0] = (f_900_ * f_888_ + f_901_ * f_889_ + f_902_ * f_890_) * f_903_;
                  fs_872_[1] = (f_900_ * f_891_ + f_901_ * f_892_ + f_902_ * f_893_) * f_903_;
                  fs_872_[2] = (f_900_ * f_894_ + f_901_ * f_895_ + f_902_ * f_896_) * f_903_;
                  f_900_ = f_883_ * f_899_ - f_884_ * f_898_;
                  f_901_ = f_884_ * f_897_ - f_882_ * f_899_;
                  f_902_ = f_882_ * f_898_ - f_883_ * f_897_;
                  f_903_ = 1.0F / (f_900_ * f_885_ + f_901_ * f_886_ + f_902_ * f_887_);
                  fs_873_[0] = (f_900_ * f_888_ + f_901_ * f_889_ + f_902_ * f_890_) * f_903_;
                  fs_873_[1] = (f_900_ * f_891_ + f_901_ * f_892_ + f_902_ * f_893_) * f_903_;
                  fs_873_[2] = (f_900_ * f_894_ + f_901_ * f_895_ + f_902_ * f_896_) * f_903_;
               } else {
                  short s = this.aShortArray5767[i_869_];
                  short s_904_ = this.aShortArray5731[i_869_];
                  short s_905_ = this.aShortArray5789[i_869_];
                  int i_906_ = class345.anIntArray4268[i_870_];
                  int i_907_ = class345.anIntArray4272[i_870_];
                  int i_908_ = class345.anIntArray4266[i_870_];
                  float[] fs_909_ = class345.aFloatArrayArray4265[i_870_];
                  byte b_910_ = model.aByteArray2585[i_870_];
                  float f = (float)model.anIntArray2617[i_870_] / 256.0F;
                  if (b == 1) {
                     float f_911_ = (float)model.anIntArray2593[i_870_] / 1024.0F;
                     Class262_Sub1.method3151(
                        fs_909_, f, i_908_, this.anIntArray5748[s], b_910_, fs, f_911_, i_907_, -2356, this.anIntArray5772[s], this.anIntArray5717[s], i_906_
                     );
                     fs_872_[0] = fs[0];
                     fs_873_[0] = fs[1];
                     Class262_Sub1.method3151(
                        fs_909_,
                        f,
                        i_908_,
                        this.anIntArray5748[s_904_],
                        b_910_,
                        fs,
                        f_911_,
                        i_907_,
                        -2356,
                        this.anIntArray5772[s_904_],
                        this.anIntArray5717[s_904_],
                        i_906_
                     );
                     fs_872_[1] = fs[0];
                     fs_873_[1] = fs[1];
                     Class262_Sub1.method3151(
                        fs_909_,
                        f,
                        i_908_,
                        this.anIntArray5748[s_905_],
                        b_910_,
                        fs,
                        f_911_,
                        i_907_,
                        -2356,
                        this.anIntArray5772[s_905_],
                        this.anIntArray5717[s_905_],
                        i_906_
                     );
                     fs_872_[2] = fs[0];
                     fs_873_[2] = fs[1];
                     float f_912_ = f_911_ / 2.0F;
                     if ((b_910_ & 1) == 0) {
                        if (fs_872_[1] - fs_872_[0] > f_912_) {
                           fs_872_[1] -= f_911_;
                        } else if (fs_872_[0] - fs_872_[1] > f_912_) {
                           fs_872_[1] += f_911_;
                        }

                        if (fs_872_[2] - fs_872_[0] > f_912_) {
                           fs_872_[2] -= f_911_;
                        } else if (fs_872_[0] - fs_872_[2] > f_912_) {
                           fs_872_[2] += f_911_;
                        }
                     } else {
                        if (fs_873_[1] - fs_873_[0] > f_912_) {
                           fs_873_[1] -= f_911_;
                        } else if (fs_873_[0] - fs_873_[1] > f_912_) {
                           fs_873_[1] += f_911_;
                        }

                        if (fs_873_[2] - fs_873_[0] > f_912_) {
                           fs_873_[2] -= f_911_;
                        } else if (fs_873_[0] - fs_873_[2] > f_912_) {
                           fs_873_[2] += f_911_;
                        }
                     }
                  } else if (b == 2) {
                     float f_913_ = (float)model.anIntArray2615[i_870_] / 256.0F;
                     float f_914_ = (float)model.anIntArray2584[i_870_] / 256.0F;
                     int i_915_ = this.anIntArray5748[s_904_] - this.anIntArray5748[s];
                     int i_916_ = this.anIntArray5772[s_904_] - this.anIntArray5772[s];
                     int i_917_ = this.anIntArray5717[s_904_] - this.anIntArray5717[s];
                     int i_918_ = this.anIntArray5748[s_905_] - this.anIntArray5748[s];
                     int i_919_ = this.anIntArray5772[s_905_] - this.anIntArray5772[s];
                     int i_920_ = this.anIntArray5717[s_905_] - this.anIntArray5717[s];
                     int i_921_ = i_916_ * i_920_ - i_919_ * i_917_;
                     int i_922_ = i_917_ * i_918_ - i_920_ * i_915_;
                     int i_923_ = i_915_ * i_919_ - i_918_ * i_916_;
                     float f_924_ = 64.0F / (float)model.anIntArray2603[i_870_];
                     float f_925_ = 64.0F / (float)model.anIntArray2588[i_870_];
                     float f_926_ = 64.0F / (float)model.anIntArray2593[i_870_];
                     float f_927_ = ((float)i_921_ * fs_909_[0] + (float)i_922_ * fs_909_[1] + (float)i_923_ * fs_909_[2]) / f_924_;
                     float f_928_ = ((float)i_921_ * fs_909_[3] + (float)i_922_ * fs_909_[4] + (float)i_923_ * fs_909_[5]) / f_925_;
                     float f_929_ = ((float)i_921_ * fs_909_[6] + (float)i_922_ * fs_909_[7] + (float)i_923_ * fs_909_[8]) / f_926_;
                     int i_930_ = TextureDefinitions.method1036(2, f_929_, f_927_, f_928_);
                     Class39.method407(
                        f,
                        i_930_,
                        this.anIntArray5748[s],
                        f_913_,
                        i_907_,
                        fs,
                        this.anIntArray5772[s],
                        99,
                        this.anIntArray5717[s],
                        i_906_,
                        i_908_,
                        f_914_,
                        fs_909_,
                        b_910_
                     );
                     fs_872_[0] = fs[0];
                     fs_873_[0] = fs[1];
                     Class39.method407(
                        f,
                        i_930_,
                        this.anIntArray5748[s_904_],
                        f_913_,
                        i_907_,
                        fs,
                        this.anIntArray5772[s_904_],
                        108,
                        this.anIntArray5717[s_904_],
                        i_906_,
                        i_908_,
                        f_914_,
                        fs_909_,
                        b_910_
                     );
                     fs_872_[1] = fs[0];
                     fs_873_[1] = fs[1];
                     Class39.method407(
                        f,
                        i_930_,
                        this.anIntArray5748[s_905_],
                        f_913_,
                        i_907_,
                        fs,
                        this.anIntArray5772[s_905_],
                        75,
                        this.anIntArray5717[s_905_],
                        i_906_,
                        i_908_,
                        f_914_,
                        fs_909_,
                        b_910_
                     );
                     fs_872_[2] = fs[0];
                     fs_873_[2] = fs[1];
                  } else if (b == 3) {
                     Class212.method2053(
                        i_906_, this.anIntArray5717[s], this.anIntArray5772[s], fs, i_908_, f, fs_909_, b_910_, this.anIntArray5748[s], -4, i_907_
                     );
                     fs_872_[0] = fs[0];
                     fs_873_[0] = fs[1];
                     Class212.method2053(
                        i_906_,
                        this.anIntArray5717[s_904_],
                        this.anIntArray5772[s_904_],
                        fs,
                        i_908_,
                        f,
                        fs_909_,
                        b_910_,
                        this.anIntArray5748[s_904_],
                        -4,
                        i_907_
                     );
                     fs_872_[1] = fs[0];
                     fs_873_[1] = fs[1];
                     Class212.method2053(
                        i_906_,
                        this.anIntArray5717[s_905_],
                        this.anIntArray5772[s_905_],
                        fs,
                        i_908_,
                        f,
                        fs_909_,
                        b_910_,
                        this.anIntArray5748[s_905_],
                        -4,
                        i_907_
                     );
                     fs_872_[2] = fs[0];
                     fs_873_[2] = fs[1];
                     if ((b_910_ & 1) == 0) {
                        if (fs_872_[1] - fs_872_[0] > 0.5F) {
                           fs_872_[1]--;
                        } else if (fs_872_[0] - fs_872_[1] > 0.5F) {
                           fs_872_[1]++;
                        }

                        if (fs_872_[2] - fs_872_[0] > 0.5F) {
                           fs_872_[2]--;
                        } else if (fs_872_[0] - fs_872_[2] > 0.5F) {
                           fs_872_[2]++;
                        }
                     } else {
                        if (fs_873_[1] - fs_873_[0] > 0.5F) {
                           fs_873_[1]--;
                        } else if (fs_873_[0] - fs_873_[1] > 0.5F) {
                           fs_873_[1]++;
                        }

                        if (fs_873_[2] - fs_873_[0] > 0.5F) {
                           fs_873_[2]--;
                        } else if (fs_873_[0] - fs_873_[2] > 0.5F) {
                           fs_873_[2]++;
                        }
                     }
                  }
               }
            }
         }
      }

      if (!bool_867_) {
         this.aFloatArrayArray5763 = this.aFloatArrayArray5776 = null;
      }

      if (model.anIntArray2598 != null && (this.anInt5746 & 32) != 0) {
         this.anIntArrayArray5722 = model.method2083(0, true);
      }

      if (model.anIntArray2602 != null && (this.anInt5746 & 384) != 0) {
         this.anIntArrayArray5725 = model.method2090((byte)73);
      }

      if (model.aClass17Array2621 != null && (this.anInt5746 & 1024) != 0) {
         this.anIntArrayArray5783 = model.method2088((byte)-80);
      }

      if (model.aShortArray2587 != null) {
         this.aShortArray5773 = new short[this.anInt5711];
         boolean bool_931_ = false;

         for(int i_932_ = 0; i_932_ < this.anInt5711; ++i_932_) {
            short s = model.aShortArray2587[i_932_];
            if (s != -1) {
               TextureDefinitions class91 = this.aPureJavaToolkit5770.aD1543.getTexture(s, -8217);
               if ((i_852_ & 64) != 0 && class91.meshGround) {
                  this.aShortArray5773[i_932_] = -1;
               } else {
                  this.aShortArray5773[i_932_] = s;
                  bool_931_ = true;
                  if (class91.unknown1 == 2) {
                     this.aBoolean5720 = true;
                  }

                  if (class91.speedU != 0 || class91.speedV != 0) {
                     this.aBoolean5788 = true;
                  }
               }
            } else {
               this.aShortArray5773[i_932_] = -1;
            }
         }

         if (!bool_931_) {
            this.aShortArray5773 = null;
         }
      } else {
         this.aShortArray5773 = null;
      }

      if (this.aBoolean5720 || this.aClass209Array5790 != null) {
         this.aShortArray5719 = new short[this.anInt5711];

         for(int i_933_ = 0; i_933_ < this.anInt5711; ++i_933_) {
            this.aShortArray5719[i_933_] = (short)is[i_933_];
         }
      }
   }
}
