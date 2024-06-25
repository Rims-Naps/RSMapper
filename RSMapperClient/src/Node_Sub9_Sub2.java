public class Node_Sub9_Sub2 extends Node_Sub9 {
   private int anInt9706;
   private int anInt9707;
   private int anInt9708;
   private int anInt9709;
   private int anInt9710;
   private int anInt9711;
   private int anInt9712;
   private int anInt9713;
   private int anInt9714;
   private int anInt9715;
   private int anInt9716;
   private boolean aBoolean9717;
   private int anInt9718;
   private int anInt9719;
   private int anInt9720;

   private final int method2472(int[] is, int i, int i_0_, int i_1_, int i_2_) {
      while(this.anInt9715 > 0) {
         int i_3_ = i + this.anInt9715;
         if (i_3_ > i_1_) {
            i_3_ = i_1_;
         }

         this.anInt9715 += i;
         if (this.anInt9710 == -256 && (this.anInt9718 & 0xFF) == 0) {
            if (DrawableModel.aBoolean913) {
               i = method2505(
                  0,
                  ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504,
                  is,
                  this.anInt9718,
                  i,
                  this.anInt9711,
                  this.anInt9708,
                  this.anInt9714,
                  this.anInt9719,
                  0,
                  i_3_,
                  i_0_,
                  this
               );
            } else {
               i = method2495(
                  ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504, is, this.anInt9718, i, this.anInt9707, this.anInt9709, 0, i_3_, i_0_, this
               );
            }
         } else if (DrawableModel.aBoolean913) {
            i = method2489(
               0,
               0,
               ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504,
               is,
               this.anInt9718,
               i,
               this.anInt9711,
               this.anInt9708,
               this.anInt9714,
               this.anInt9719,
               0,
               i_3_,
               i_0_,
               this,
               this.anInt9710,
               i_2_
            );
         } else {
            i = method2510(
               0,
               0,
               ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504,
               is,
               this.anInt9718,
               i,
               this.anInt9707,
               this.anInt9709,
               0,
               i_3_,
               i_0_,
               this,
               this.anInt9710,
               i_2_
            );
         }

         this.anInt9715 -= i;
         if (this.anInt9715 != 0) {
            return i;
         }

         if (this.method2508()) {
            return i_1_;
         }
      }

      if (this.anInt9710 == -256 && (this.anInt9718 & 0xFF) == 0) {
         return DrawableModel.aBoolean913
            ? method2497(
               0, ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504, is, this.anInt9718, i, this.anInt9711, this.anInt9708, 0, i_1_, i_0_, this
            )
            : method2506(((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504, is, this.anInt9718, i, this.anInt9707, 0, i_1_, i_0_, this);
      } else {
         return DrawableModel.aBoolean913
            ? method2487(
               0,
               0,
               ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504,
               is,
               this.anInt9718,
               i,
               this.anInt9711,
               this.anInt9708,
               0,
               i_1_,
               i_0_,
               this,
               this.anInt9710,
               i_2_
            )
            : method2502(
               0,
               0,
               ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504,
               is,
               this.anInt9718,
               i,
               this.anInt9707,
               0,
               i_1_,
               i_0_,
               this,
               this.anInt9710,
               i_2_
            );
      }
   }

   @Override
   final synchronized void method2427(int[] is, int i, int i_4_) {
      if (this.anInt9716 == 0 && this.anInt9715 == 0) {
         this.method2426(i_4_);
      } else {
         Node_Sub45_Sub1 node_sub45_sub1 = (Node_Sub45_Sub1)this.aNode_Sub45_7075;
         int i_5_ = this.anInt9712 << 8;
         int i_6_ = this.anInt9706 << 8;
         int i_7_ = node_sub45_sub1.aByteArray10504.length << 8;
         int i_8_ = i_6_ - i_5_;
         if (i_8_ <= 0) {
            this.anInt9720 = 0;
         }

         int i_9_ = i;
         i_4_ += i;
         if (this.anInt9718 < 0) {
            if (this.anInt9710 <= 0) {
               this.method2498();
               this.method2160((byte)50);
               return;
            }

            this.anInt9718 = 0;
         }

         if (this.anInt9718 >= i_7_) {
            if (this.anInt9710 >= 0) {
               this.method2498();
               this.method2160((byte)30);
               return;
            }

            this.anInt9718 = i_7_ - 1;
         }

         if (this.anInt9720 < 0) {
            if (this.aBoolean9717) {
               if (this.anInt9710 < 0) {
                  i_9_ = this.method2472(is, i, i_5_, i_4_, node_sub45_sub1.aByteArray10504[this.anInt9712]);
                  if (this.anInt9718 >= i_5_) {
                     return;
                  }

                  this.anInt9718 = i_5_ + i_5_ - 1 - this.anInt9718;
                  this.anInt9710 = -this.anInt9710;
               }

               while(true) {
                  i_9_ = this.method2480(is, i_9_, i_6_, i_4_, node_sub45_sub1.aByteArray10504[this.anInt9706 - 1]);
                  if (this.anInt9718 < i_6_) {
                     break;
                  }

                  this.anInt9718 = i_6_ + i_6_ - 1 - this.anInt9718;
                  this.anInt9710 = -this.anInt9710;
                  i_9_ = this.method2472(is, i_9_, i_5_, i_4_, node_sub45_sub1.aByteArray10504[this.anInt9712]);
                  if (this.anInt9718 >= i_5_) {
                     break;
                  }

                  this.anInt9718 = i_5_ + i_5_ - 1 - this.anInt9718;
                  this.anInt9710 = -this.anInt9710;
               }
            } else if (this.anInt9710 < 0) {
               while(true) {
                  i_9_ = this.method2472(is, i_9_, i_5_, i_4_, node_sub45_sub1.aByteArray10504[this.anInt9706 - 1]);
                  if (this.anInt9718 >= i_5_) {
                     break;
                  }

                  this.anInt9718 = i_6_ - 1 - (i_6_ - 1 - this.anInt9718) % i_8_;
               }
            } else {
               while(true) {
                  i_9_ = this.method2480(is, i_9_, i_6_, i_4_, node_sub45_sub1.aByteArray10504[this.anInt9712]);
                  if (this.anInt9718 < i_6_) {
                     break;
                  }

                  this.anInt9718 = i_5_ + (this.anInt9718 - i_5_) % i_8_;
               }
            }
         } else {
            if (this.anInt9720 > 0) {
               label105:
               if (this.aBoolean9717) {
                  if (this.anInt9710 < 0) {
                     i_9_ = this.method2472(is, i, i_5_, i_4_, node_sub45_sub1.aByteArray10504[this.anInt9712]);
                     if (this.anInt9718 >= i_5_) {
                        return;
                     }

                     this.anInt9718 = i_5_ + i_5_ - 1 - this.anInt9718;
                     this.anInt9710 = -this.anInt9710;
                     if (--this.anInt9720 == 0) {
                        break label105;
                     }
                  }

                  do {
                     i_9_ = this.method2480(is, i_9_, i_6_, i_4_, node_sub45_sub1.aByteArray10504[this.anInt9706 - 1]);
                     if (this.anInt9718 < i_6_) {
                        return;
                     }

                     this.anInt9718 = i_6_ + i_6_ - 1 - this.anInt9718;
                     this.anInt9710 = -this.anInt9710;
                     if (--this.anInt9720 == 0) {
                        break;
                     }

                     i_9_ = this.method2472(is, i_9_, i_5_, i_4_, node_sub45_sub1.aByteArray10504[this.anInt9712]);
                     if (this.anInt9718 >= i_5_) {
                        return;
                     }

                     this.anInt9718 = i_5_ + i_5_ - 1 - this.anInt9718;
                     this.anInt9710 = -this.anInt9710;
                  } while(--this.anInt9720 != 0);
               } else if (this.anInt9710 < 0) {
                  while(true) {
                     i_9_ = this.method2472(is, i_9_, i_5_, i_4_, node_sub45_sub1.aByteArray10504[this.anInt9706 - 1]);
                     if (this.anInt9718 >= i_5_) {
                        return;
                     }

                     int i_10_ = (i_6_ - 1 - this.anInt9718) / i_8_;
                     if (i_10_ >= this.anInt9720) {
                        this.anInt9718 += i_8_ * this.anInt9720;
                        this.anInt9720 = 0;
                        break;
                     }

                     this.anInt9718 += i_8_ * i_10_;
                     this.anInt9720 -= i_10_;
                  }
               } else {
                  while(true) {
                     i_9_ = this.method2480(is, i_9_, i_6_, i_4_, node_sub45_sub1.aByteArray10504[this.anInt9712]);
                     if (this.anInt9718 < i_6_) {
                        return;
                     }

                     int i_11_ = (this.anInt9718 - i_5_) / i_8_;
                     if (i_11_ >= this.anInt9720) {
                        this.anInt9718 -= i_8_ * this.anInt9720;
                        this.anInt9720 = 0;
                        break;
                     }

                     this.anInt9718 -= i_8_ * i_11_;
                     this.anInt9720 -= i_11_;
                  }
               }
            }

            if (this.anInt9710 < 0) {
               this.method2472(is, i_9_, 0, i_4_, 0);
               if (this.anInt9718 < 0) {
                  this.anInt9718 = -1;
                  this.method2498();
                  this.method2160((byte)94);
               }
            } else {
               this.method2480(is, i_9_, i_7_, i_4_, 0);
               if (this.anInt9718 >= i_7_) {
                  this.anInt9718 = i_7_;
                  this.method2498();
                  this.method2160((byte)121);
               }
            }
         }
      }
   }

   private static final int method2473(byte[] bs, int[] is, int i, int i_12_, int i_13_, int i_14_, int i_15_, int i_16_, Node_Sub9_Sub2 node_sub9_sub2) {
      i >>= 8;
      i_16_ >>= 8;
      i_13_ <<= 2;
      if ((i_14_ = i_12_ + i_16_ - i) > i_15_) {
         i_14_ = i_15_;
      }

      int var23;
      for(i_14_ -= 3; i_12_ < i_14_; is[var23] += bs[i++] * i_13_) {
         var23 = i_12_++;
         is[var23] += bs[i++] * i_13_;
         var23 = i_12_++;
         is[var23] += bs[i++] * i_13_;
         var23 = i_12_++;
         is[var23] += bs[i++] * i_13_;
         var23 = i_12_++;
      }

      for(int var19 = i_14_ + 3; i_12_ < var19; is[var23] += bs[i++] * i_13_) {
         var23 = i_12_++;
      }

      node_sub9_sub2.anInt9718 = i << 8;
      return i_12_;
   }

   final boolean method2474() {
      return this.anInt9718 < 0 || this.anInt9718 >= ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504.length << 8;
   }

   private static final int method2475(
      int i,
      int i_17_,
      byte[] bs,
      int[] is,
      int i_18_,
      int i_19_,
      int i_20_,
      int i_21_,
      int i_22_,
      int i_23_,
      int i_24_,
      Node_Sub9_Sub2 node_sub9_sub2,
      int i_25_,
      int i_26_
   ) {
      if (i_25_ == 0 || (i_22_ = i_19_ + (i_24_ - i_18_ + i_25_ - 257) / i_25_) > i_23_) {
         i_22_ = i_23_;
      }

      i_19_ <<= 1;

      for(i_22_ <<= 1; i_19_ < i_22_; i_18_ += i_25_) {
         i_17_ = i_18_ >> 8;
         int var14 = bs[i_17_];
         var14 = (var14 << 8) + (bs[i_17_ + 1] - var14) * (i_18_ & 0xFF);
         int var10001 = i_19_++;
         is[var10001] += var14 * i_20_ >> 6;
         var10001 = i_19_++;
         is[var10001] += var14 * i_21_ >> 6;
      }

      if (i_25_ == 0 || (i_22_ = (i_19_ >> 1) + (i_24_ - i_18_ + i_25_ - 1) / i_25_) > i_23_) {
         i_22_ = i_23_;
      }

      i_22_ <<= 1;

      for(int var19 = i_26_; i_19_ < i_22_; i_18_ += i_25_) {
         int var16 = bs[i_18_ >> 8];
         var16 = (var16 << 8) + (var19 - var16) * (i_18_ & 0xFF);
         int var26 = i_19_++;
         is[var26] += var16 * i_20_ >> 6;
         var26 = i_19_++;
         is[var26] += var16 * i_21_ >> 6;
      }

      node_sub9_sub2.anInt9718 = i_18_;
      return i_19_ >> 1;
   }

   private static final int method2476(
      int i,
      int i_27_,
      byte[] bs,
      int[] is,
      int i_28_,
      int i_29_,
      int i_30_,
      int i_31_,
      int i_32_,
      int i_33_,
      int i_34_,
      int i_35_,
      int i_36_,
      Node_Sub9_Sub2 node_sub9_sub2,
      int i_37_,
      int i_38_
   ) {
      node_sub9_sub2.anInt9707 -= node_sub9_sub2.anInt9709 * i_29_;
      if (i_37_ == 0 || (i_34_ = i_29_ + (i_36_ - i_28_ + i_37_ - 257) / i_37_) > i_35_) {
         i_34_ = i_35_;
      }

      i_29_ <<= 1;

      for(i_34_ <<= 1; i_29_ < i_34_; i_28_ += i_37_) {
         i_27_ = i_28_ >> 8;
         int var16 = bs[i_27_];
         var16 = (var16 << 8) + (bs[i_27_ + 1] - var16) * (i_28_ & 0xFF);
         int var10001 = i_29_++;
         is[var10001] += var16 * i_30_ >> 6;
         i_30_ += i_32_;
         var10001 = i_29_++;
         is[var10001] += var16 * i_31_ >> 6;
         i_31_ += i_33_;
      }

      if (i_37_ == 0 || (i_34_ = (i_29_ >> 1) + (i_36_ - i_28_ + i_37_ - 1) / i_37_) > i_35_) {
         i_34_ = i_35_;
      }

      i_34_ <<= 1;

      for(int var21 = i_38_; i_29_ < i_34_; i_28_ += i_37_) {
         int var18 = bs[i_28_ >> 8];
         var18 = (var18 << 8) + (var21 - var18) * (i_28_ & 0xFF);
         int var29 = i_29_++;
         is[var29] += var18 * i_30_ >> 6;
         i_30_ += i_32_;
         var29 = i_29_++;
         is[var29] += var18 * i_31_ >> 6;
         i_31_ += i_33_;
      }

      i_29_ >>= 1;
      node_sub9_sub2.anInt9707 += node_sub9_sub2.anInt9709 * i_29_;
      node_sub9_sub2.anInt9711 = i_30_;
      node_sub9_sub2.anInt9708 = i_31_;
      node_sub9_sub2.anInt9718 = i_28_;
      return i_29_;
   }

   private final void method2477() {
      this.anInt9707 = this.anInt9716;
      this.anInt9711 = method2493(this.anInt9716, this.anInt9713);
      this.anInt9708 = method2491(this.anInt9716, this.anInt9713);
   }

   final synchronized void method2478(int i, int i_39_) {
      this.method2501(i, i_39_, this.method2511());
   }

   private static final int method2479(
      int i,
      int i_40_,
      byte[] bs,
      int[] is,
      int i_41_,
      int i_42_,
      int i_43_,
      int i_44_,
      int i_45_,
      int i_46_,
      Node_Sub9_Sub2 node_sub9_sub2,
      int i_47_,
      int i_48_
   ) {
      if (i_47_ == 0 || (i_44_ = i_42_ + (i_46_ - i_41_ + i_47_ - 257) / i_47_) > i_45_) {
         i_44_ = i_45_;
      }

      while(i_42_ < i_44_) {
         i_40_ = i_41_ >> 8;
         int var13 = bs[i_40_];
         int var10001 = i_42_++;
         is[var10001] += ((var13 << 8) + (bs[i_40_ + 1] - var13) * (i_41_ & 0xFF)) * i_43_ >> 6;
         i_41_ += i_47_;
      }

      if (i_47_ == 0 || (i_44_ = i_42_ + (i_46_ - i_41_ + i_47_ - 1) / i_47_) > i_45_) {
         i_44_ = i_45_;
      }

      for(int var16 = i_48_; i_42_ < i_44_; i_41_ += i_47_) {
         int var14 = bs[i_41_ >> 8];
         int var17 = i_42_++;
         is[var17] += ((var14 << 8) + (var16 - var14) * (i_41_ & 0xFF)) * i_43_ >> 6;
      }

      node_sub9_sub2.anInt9718 = i_41_;
      return i_42_;
   }

   private final int method2480(int[] is, int i, int i_49_, int i_50_, int i_51_) {
      while(this.anInt9715 > 0) {
         int i_52_ = i + this.anInt9715;
         if (i_52_ > i_50_) {
            i_52_ = i_50_;
         }

         this.anInt9715 += i;
         if (this.anInt9710 == 256 && (this.anInt9718 & 0xFF) == 0) {
            if (DrawableModel.aBoolean913) {
               i = method2488(
                  0,
                  ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504,
                  is,
                  this.anInt9718,
                  i,
                  this.anInt9711,
                  this.anInt9708,
                  this.anInt9714,
                  this.anInt9719,
                  0,
                  i_52_,
                  i_49_,
                  this
               );
            } else {
               i = method2484(
                  ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504, is, this.anInt9718, i, this.anInt9707, this.anInt9709, 0, i_52_, i_49_, this
               );
            }
         } else if (DrawableModel.aBoolean913) {
            i = method2476(
               0,
               0,
               ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504,
               is,
               this.anInt9718,
               i,
               this.anInt9711,
               this.anInt9708,
               this.anInt9714,
               this.anInt9719,
               0,
               i_52_,
               i_49_,
               this,
               this.anInt9710,
               i_51_
            );
         } else {
            i = method2494(
               0,
               0,
               ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504,
               is,
               this.anInt9718,
               i,
               this.anInt9707,
               this.anInt9709,
               0,
               i_52_,
               i_49_,
               this,
               this.anInt9710,
               i_51_
            );
         }

         this.anInt9715 -= i;
         if (this.anInt9715 != 0) {
            return i;
         }

         if (this.method2508()) {
            return i_50_;
         }
      }

      if (this.anInt9710 == 256 && (this.anInt9718 & 0xFF) == 0) {
         return DrawableModel.aBoolean913
            ? method2492(
               0, ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504, is, this.anInt9718, i, this.anInt9711, this.anInt9708, 0, i_50_, i_49_, this
            )
            : method2473(((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504, is, this.anInt9718, i, this.anInt9707, 0, i_50_, i_49_, this);
      } else {
         return DrawableModel.aBoolean913
            ? method2475(
               0,
               0,
               ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504,
               is,
               this.anInt9718,
               i,
               this.anInt9711,
               this.anInt9708,
               0,
               i_50_,
               i_49_,
               this,
               this.anInt9710,
               i_51_
            )
            : method2479(
               0,
               0,
               ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504,
               is,
               this.anInt9718,
               i,
               this.anInt9707,
               0,
               i_50_,
               i_49_,
               this,
               this.anInt9710,
               i_51_
            );
      }
   }

   final synchronized void method2481(int i) {
      this.anInt9720 = i;
   }

   final synchronized void method2482(int i) {
      if (this.anInt9710 < 0) {
         this.anInt9710 = -i;
      } else {
         this.anInt9710 = i;
      }
   }

   final synchronized void method2483(int i) {
      if (i == 0) {
         this.method2485(0);
         this.method2160((byte)45);
      } else if (this.anInt9711 == 0 && this.anInt9708 == 0) {
         this.anInt9715 = 0;
         this.anInt9716 = 0;
         this.anInt9707 = 0;
         this.method2160((byte)27);
      } else {
         int i_53_ = -this.anInt9707;
         if (this.anInt9707 > i_53_) {
            i_53_ = this.anInt9707;
         }

         if (-this.anInt9711 > i_53_) {
            i_53_ = -this.anInt9711;
         }

         if (this.anInt9711 > i_53_) {
            i_53_ = this.anInt9711;
         }

         if (-this.anInt9708 > i_53_) {
            i_53_ = -this.anInt9708;
         }

         if (this.anInt9708 > i_53_) {
            i_53_ = this.anInt9708;
         }

         if (i > i_53_) {
            i = i_53_;
         }

         this.anInt9715 = i;
         this.anInt9716 = Integer.MIN_VALUE;
         this.anInt9709 = -this.anInt9707 / i;
         this.anInt9714 = -this.anInt9711 / i;
         this.anInt9719 = -this.anInt9708 / i;
      }
   }

   private static final int method2484(
      byte[] bs, int[] is, int i, int i_54_, int i_55_, int i_56_, int i_57_, int i_58_, int i_59_, Node_Sub9_Sub2 node_sub9_sub2
   ) {
      i >>= 8;
      i_59_ >>= 8;
      i_55_ <<= 2;
      i_56_ <<= 2;
      if ((i_57_ = i_54_ + i_59_ - i) > i_58_) {
         i_57_ = i_58_;
      }

      node_sub9_sub2.anInt9711 += node_sub9_sub2.anInt9714 * (i_57_ - i_54_);
      node_sub9_sub2.anInt9708 += node_sub9_sub2.anInt9719 * (i_57_ - i_54_);

      for(i_57_ -= 3; i_54_ < i_57_; i_55_ += i_56_) {
         int var10001 = i_54_++;
         is[var10001] += bs[i++] * i_55_;
         int var18 = i_55_ + i_56_;
         var10001 = i_54_++;
         is[var10001] += bs[i++] * var18;
         int var19 = var18 + i_56_;
         var10001 = i_54_++;
         is[var10001] += bs[i++] * var19;
         i_55_ = var19 + i_56_;
         var10001 = i_54_++;
         is[var10001] += bs[i++] * i_55_;
      }

      for(int var24 = i_57_ + 3; i_54_ < var24; i_55_ += i_56_) {
         int var29 = i_54_++;
         is[var29] += bs[i++] * i_55_;
      }

      node_sub9_sub2.anInt9707 = i_55_ >> 2;
      node_sub9_sub2.anInt9718 = i << 8;
      return i_54_;
   }

   private final synchronized void method2485(int i) {
      this.method2500(i, this.method2511());
   }

   final synchronized void method2486(boolean bool) {
      this.anInt9710 = (this.anInt9710 ^ this.anInt9710 >> 31) + (this.anInt9710 >>> 31);
      if (bool) {
         this.anInt9710 = -this.anInt9710;
      }
   }

   private static final int method2487(
      int i,
      int i_60_,
      byte[] bs,
      int[] is,
      int i_61_,
      int i_62_,
      int i_63_,
      int i_64_,
      int i_65_,
      int i_66_,
      int i_67_,
      Node_Sub9_Sub2 node_sub9_sub2,
      int i_68_,
      int i_69_
   ) {
      if (i_68_ == 0 || (i_65_ = i_62_ + (i_67_ + 256 - i_61_ + i_68_) / i_68_) > i_66_) {
         i_65_ = i_66_;
      }

      i_62_ <<= 1;

      for(i_65_ <<= 1; i_62_ < i_65_; i_61_ += i_68_) {
         i_60_ = i_61_ >> 8;
         int var14 = bs[i_60_ - 1];
         var14 = (var14 << 8) + (bs[i_60_] - var14) * (i_61_ & 0xFF);
         int var10001 = i_62_++;
         is[var10001] += var14 * i_63_ >> 6;
         var10001 = i_62_++;
         is[var10001] += var14 * i_64_ >> 6;
      }

      if (i_68_ == 0 || (i_65_ = (i_62_ >> 1) + (i_67_ - i_61_ + i_68_) / i_68_) > i_66_) {
         i_65_ = i_66_;
      }

      i_65_ <<= 1;

      for(int var18 = i_69_; i_62_ < i_65_; i_61_ += i_68_) {
         i = (var18 << 8) + (bs[i_61_ >> 8] - var18) * (i_61_ & 0xFF);
         int var25 = i_62_++;
         is[var25] += i * i_63_ >> 6;
         var25 = i_62_++;
         is[var25] += i * i_64_ >> 6;
      }

      node_sub9_sub2.anInt9718 = i_61_;
      return i_62_ >> 1;
   }

   private static final int method2488(
      int i,
      byte[] bs,
      int[] is,
      int i_70_,
      int i_71_,
      int i_72_,
      int i_73_,
      int i_74_,
      int i_75_,
      int i_76_,
      int i_77_,
      int i_78_,
      Node_Sub9_Sub2 node_sub9_sub2
   ) {
      i_70_ >>= 8;
      i_78_ >>= 8;
      i_72_ <<= 2;
      i_73_ <<= 2;
      i_74_ <<= 2;
      i_75_ <<= 2;
      if ((i_76_ = i_71_ + i_78_ - i_70_) > i_77_) {
         i_76_ = i_77_;
      }

      node_sub9_sub2.anInt9707 += node_sub9_sub2.anInt9709 * (i_76_ - i_71_);
      i_71_ <<= 1;
      i_76_ <<= 1;

      for(i_76_ -= 6; i_71_ < i_76_; i_73_ += i_75_) {
         int var13 = bs[i_70_++];
         int var46 = i_71_++;
         is[var46] += var13 * i_72_;
         i_72_ += i_74_;
         var46 = i_71_++;
         is[var46] += var13 * i_73_;
         int var36 = i_73_ + i_75_;
         var13 = bs[i_70_++];
         var46 = i_71_++;
         is[var46] += var13 * i_72_;
         i_72_ += i_74_;
         var46 = i_71_++;
         is[var46] += var13 * var36;
         int var37 = var36 + i_75_;
         var13 = bs[i_70_++];
         var46 = i_71_++;
         is[var46] += var13 * i_72_;
         i_72_ += i_74_;
         var46 = i_71_++;
         is[var46] += var13 * var37;
         i_73_ = var37 + i_75_;
         var13 = bs[i_70_++];
         var46 = i_71_++;
         is[var46] += var13 * i_72_;
         i_72_ += i_74_;
         var46 = i_71_++;
         is[var46] += var13 * i_73_;
      }

      for(int var44 = i_76_ + 6; i_71_ < var44; i_73_ += i_75_) {
         int var17 = bs[i_70_++];
         int var58 = i_71_++;
         is[var58] += var17 * i_72_;
         i_72_ += i_74_;
         var58 = i_71_++;
         is[var58] += var17 * i_73_;
      }

      node_sub9_sub2.anInt9711 = i_72_ >> 2;
      node_sub9_sub2.anInt9708 = i_73_ >> 2;
      node_sub9_sub2.anInt9718 = i_70_ << 8;
      return i_71_ >> 1;
   }

   private static final int method2489(
      int i,
      int i_79_,
      byte[] bs,
      int[] is,
      int i_80_,
      int i_81_,
      int i_82_,
      int i_83_,
      int i_84_,
      int i_85_,
      int i_86_,
      int i_87_,
      int i_88_,
      Node_Sub9_Sub2 node_sub9_sub2,
      int i_89_,
      int i_90_
   ) {
      node_sub9_sub2.anInt9707 -= node_sub9_sub2.anInt9709 * i_81_;
      if (i_89_ == 0 || (i_86_ = i_81_ + (i_88_ + 256 - i_80_ + i_89_) / i_89_) > i_87_) {
         i_86_ = i_87_;
      }

      i_81_ <<= 1;

      for(i_86_ <<= 1; i_81_ < i_86_; i_80_ += i_89_) {
         i_79_ = i_80_ >> 8;
         int var16 = bs[i_79_ - 1];
         var16 = (var16 << 8) + (bs[i_79_] - var16) * (i_80_ & 0xFF);
         int var10001 = i_81_++;
         is[var10001] += var16 * i_82_ >> 6;
         i_82_ += i_84_;
         var10001 = i_81_++;
         is[var10001] += var16 * i_83_ >> 6;
         i_83_ += i_85_;
      }

      if (i_89_ == 0 || (i_86_ = (i_81_ >> 1) + (i_88_ - i_80_ + i_89_) / i_89_) > i_87_) {
         i_86_ = i_87_;
      }

      i_86_ <<= 1;

      for(int var20 = i_90_; i_81_ < i_86_; i_80_ += i_89_) {
         i = (var20 << 8) + (bs[i_80_ >> 8] - var20) * (i_80_ & 0xFF);
         int var28 = i_81_++;
         is[var28] += i * i_82_ >> 6;
         i_82_ += i_84_;
         var28 = i_81_++;
         is[var28] += i * i_83_ >> 6;
         i_83_ += i_85_;
      }

      i_81_ >>= 1;
      node_sub9_sub2.anInt9707 += node_sub9_sub2.anInt9709 * i_81_;
      node_sub9_sub2.anInt9711 = i_82_;
      node_sub9_sub2.anInt9708 = i_83_;
      node_sub9_sub2.anInt9718 = i_80_;
      return i_81_;
   }

   @Override
   final Node_Sub9 method2429() {
      return null;
   }

   final synchronized void method2490(int i) {
      this.method2500(i << 6, this.method2511());
   }

   private static final int method2491(int i, int i_91_) {
      return i_91_ < 0 ? -i : (int)((double)i * Math.sqrt((double)i_91_ * 1.2207031E-4F) + 0.5);
   }

   private static final int method2492(
      int i, byte[] bs, int[] is, int i_92_, int i_93_, int i_94_, int i_95_, int i_96_, int i_97_, int i_98_, Node_Sub9_Sub2 node_sub9_sub2
   ) {
      i_92_ >>= 8;
      i_98_ >>= 8;
      i_94_ <<= 2;
      i_95_ <<= 2;
      if ((i_96_ = i_93_ + i_98_ - i_92_) > i_97_) {
         i_96_ = i_97_;
      }

      i_93_ <<= 1;
      i_96_ <<= 1;

      int var46;
      byte var14;
      for(i_96_ -= 6; i_93_ < i_96_; is[var46] += var14 * i_95_) {
         int var11 = bs[i_92_++];
         var46 = i_93_++;
         is[var46] += var11 * i_94_;
         var46 = i_93_++;
         is[var46] += var11 * i_95_;
         var11 = bs[i_92_++];
         var46 = i_93_++;
         is[var46] += var11 * i_94_;
         var46 = i_93_++;
         is[var46] += var11 * i_95_;
         var11 = bs[i_92_++];
         var46 = i_93_++;
         is[var46] += var11 * i_94_;
         var46 = i_93_++;
         is[var46] += var11 * i_95_;
         var14 = bs[i_92_++];
         var46 = i_93_++;
         is[var46] += var14 * i_94_;
         var46 = i_93_++;
      }

      byte var15;
      for(int var34 = i_96_ + 6; i_93_ < var34; is[var46] += var15 * i_95_) {
         var15 = bs[i_92_++];
         var46 = i_93_++;
         is[var46] += var15 * i_94_;
         var46 = i_93_++;
      }

      node_sub9_sub2.anInt9718 = i_92_ << 8;
      return i_93_ >> 1;
   }

   private static final int method2493(int i, int i_99_) {
      return i_99_ < 0 ? i : (int)((double)i * Math.sqrt((double)(16384 - i_99_) * 1.2207031E-4F) + 0.5);
   }

   private static final int method2494(
      int i,
      int i_100_,
      byte[] bs,
      int[] is,
      int i_101_,
      int i_102_,
      int i_103_,
      int i_104_,
      int i_105_,
      int i_106_,
      int i_107_,
      Node_Sub9_Sub2 node_sub9_sub2,
      int i_108_,
      int i_109_
   ) {
      node_sub9_sub2.anInt9711 -= node_sub9_sub2.anInt9714 * i_102_;
      node_sub9_sub2.anInt9708 -= node_sub9_sub2.anInt9719 * i_102_;
      if (i_108_ == 0 || (i_105_ = i_102_ + (i_107_ - i_101_ + i_108_ - 257) / i_108_) > i_106_) {
         i_105_ = i_106_;
      }

      while(i_102_ < i_105_) {
         i_100_ = i_101_ >> 8;
         int var14 = bs[i_100_];
         int var10001 = i_102_++;
         is[var10001] += ((var14 << 8) + (bs[i_100_ + 1] - var14) * (i_101_ & 0xFF)) * i_103_ >> 6;
         i_103_ += i_104_;
         i_101_ += i_108_;
      }

      if (i_108_ == 0 || (i_105_ = i_102_ + (i_107_ - i_101_ + i_108_ - 1) / i_108_) > i_106_) {
         i_105_ = i_106_;
      }

      for(int var17 = i_109_; i_102_ < i_105_; i_101_ += i_108_) {
         int var15 = bs[i_101_ >> 8];
         int var18 = i_102_++;
         is[var18] += ((var15 << 8) + (var17 - var15) * (i_101_ & 0xFF)) * i_103_ >> 6;
         i_103_ += i_104_;
      }

      node_sub9_sub2.anInt9711 += node_sub9_sub2.anInt9714 * i_102_;
      node_sub9_sub2.anInt9708 += node_sub9_sub2.anInt9719 * i_102_;
      node_sub9_sub2.anInt9707 = i_103_;
      node_sub9_sub2.anInt9718 = i_101_;
      return i_102_;
   }

   private static final int method2495(
      byte[] bs, int[] is, int i, int i_110_, int i_111_, int i_112_, int i_113_, int i_114_, int i_115_, Node_Sub9_Sub2 node_sub9_sub2
   ) {
      i >>= 8;
      i_115_ >>= 8;
      i_111_ <<= 2;
      i_112_ <<= 2;
      if ((i_113_ = i_110_ + i - (i_115_ - 1)) > i_114_) {
         i_113_ = i_114_;
      }

      node_sub9_sub2.anInt9711 += node_sub9_sub2.anInt9714 * (i_113_ - i_110_);
      node_sub9_sub2.anInt9708 += node_sub9_sub2.anInt9719 * (i_113_ - i_110_);

      for(i_113_ -= 3; i_110_ < i_113_; i_111_ += i_112_) {
         int var10001 = i_110_++;
         is[var10001] += bs[i--] * i_111_;
         int var18 = i_111_ + i_112_;
         var10001 = i_110_++;
         is[var10001] += bs[i--] * var18;
         int var19 = var18 + i_112_;
         var10001 = i_110_++;
         is[var10001] += bs[i--] * var19;
         i_111_ = var19 + i_112_;
         var10001 = i_110_++;
         is[var10001] += bs[i--] * i_111_;
      }

      for(int var24 = i_113_ + 3; i_110_ < var24; i_111_ += i_112_) {
         int var29 = i_110_++;
         is[var29] += bs[i--] * i_111_;
      }

      node_sub9_sub2.anInt9707 = i_111_ >> 2;
      node_sub9_sub2.anInt9718 = i << 8;
      return i_110_;
   }

   final synchronized void method2496(int i) {
      this.method2500(this.method2504(), i);
   }

   private static final int method2497(
      int i, byte[] bs, int[] is, int i_116_, int i_117_, int i_118_, int i_119_, int i_120_, int i_121_, int i_122_, Node_Sub9_Sub2 node_sub9_sub2
   ) {
      i_116_ >>= 8;
      i_122_ >>= 8;
      i_118_ <<= 2;
      i_119_ <<= 2;
      if ((i_120_ = i_117_ + i_116_ - (i_122_ - 1)) > i_121_) {
         i_120_ = i_121_;
      }

      i_117_ <<= 1;
      i_120_ <<= 1;

      int var46;
      byte var14;
      for(i_120_ -= 6; i_117_ < i_120_; is[var46] += var14 * i_119_) {
         int var11 = bs[i_116_--];
         var46 = i_117_++;
         is[var46] += var11 * i_118_;
         var46 = i_117_++;
         is[var46] += var11 * i_119_;
         var11 = bs[i_116_--];
         var46 = i_117_++;
         is[var46] += var11 * i_118_;
         var46 = i_117_++;
         is[var46] += var11 * i_119_;
         var11 = bs[i_116_--];
         var46 = i_117_++;
         is[var46] += var11 * i_118_;
         var46 = i_117_++;
         is[var46] += var11 * i_119_;
         var14 = bs[i_116_--];
         var46 = i_117_++;
         is[var46] += var14 * i_118_;
         var46 = i_117_++;
      }

      byte var15;
      for(int var34 = i_120_ + 6; i_117_ < var34; is[var46] += var15 * i_119_) {
         var15 = bs[i_116_--];
         var46 = i_117_++;
         is[var46] += var15 * i_118_;
         var46 = i_117_++;
      }

      node_sub9_sub2.anInt9718 = i_116_ << 8;
      return i_117_ >> 1;
   }

   private final void method2498() {
      if (this.anInt9715 != 0) {
         if (this.anInt9716 == Integer.MIN_VALUE) {
            this.anInt9716 = 0;
         }

         this.anInt9715 = 0;
         this.method2477();
      }
   }

   final boolean method2499() {
      return this.anInt9715 != 0;
   }

   private final synchronized void method2500(int i, int i_123_) {
      this.anInt9716 = i;
      this.anInt9713 = i_123_;
      this.anInt9715 = 0;
      this.method2477();
   }

   final synchronized void method2501(int i, int i_124_, int i_125_) {
      if (i == 0) {
         this.method2500(i_124_, i_125_);
      } else {
         int i_126_ = method2493(i_124_, i_125_);
         int i_127_ = method2491(i_124_, i_125_);
         if (this.anInt9711 == i_126_ && this.anInt9708 == i_127_) {
            this.anInt9715 = 0;
         } else {
            int i_128_ = i_124_ - this.anInt9707;
            if (this.anInt9707 - i_124_ > i_128_) {
               i_128_ = this.anInt9707 - i_124_;
            }

            if (i_126_ - this.anInt9711 > i_128_) {
               i_128_ = i_126_ - this.anInt9711;
            }

            if (this.anInt9711 - i_126_ > i_128_) {
               i_128_ = this.anInt9711 - i_126_;
            }

            if (i_127_ - this.anInt9708 > i_128_) {
               i_128_ = i_127_ - this.anInt9708;
            }

            if (this.anInt9708 - i_127_ > i_128_) {
               i_128_ = this.anInt9708 - i_127_;
            }

            if (i > i_128_) {
               i = i_128_;
            }

            this.anInt9715 = i;
            this.anInt9716 = i_124_;
            this.anInt9713 = i_125_;
            this.anInt9709 = (i_124_ - this.anInt9707) / i;
            this.anInt9714 = (i_126_ - this.anInt9711) / i;
            this.anInt9719 = (i_127_ - this.anInt9708) / i;
         }
      }
   }

   private static final int method2502(
      int i,
      int i_129_,
      byte[] bs,
      int[] is,
      int i_130_,
      int i_131_,
      int i_132_,
      int i_133_,
      int i_134_,
      int i_135_,
      Node_Sub9_Sub2 node_sub9_sub2,
      int i_136_,
      int i_137_
   ) {
      if (i_136_ == 0 || (i_133_ = i_131_ + (i_135_ + 256 - i_130_ + i_136_) / i_136_) > i_134_) {
         i_133_ = i_134_;
      }

      while(i_131_ < i_133_) {
         i_129_ = i_130_ >> 8;
         int var13 = bs[i_129_ - 1];
         int var10001 = i_131_++;
         is[var10001] += ((var13 << 8) + (bs[i_129_] - var13) * (i_130_ & 0xFF)) * i_132_ >> 6;
         i_130_ += i_136_;
      }

      if (i_136_ == 0 || (i_133_ = i_131_ + (i_135_ - i_130_ + i_136_) / i_136_) > i_134_) {
         i_133_ = i_134_;
      }

      i = i_137_;

      for(int var16 = i_136_; i_131_ < i_133_; i_130_ += var16) {
         int var17 = i_131_++;
         is[var17] += ((i << 8) + (bs[i_130_ >> 8] - i) * (i_130_ & 0xFF)) * i_132_ >> 6;
      }

      node_sub9_sub2.anInt9718 = i_130_;
      return i_131_;
   }

   @Override
   final int method2428() {
      return this.anInt9716 == 0 && this.anInt9715 == 0 ? 0 : 1;
   }

   final synchronized int method2503() {
      return this.anInt9710 < 0 ? -this.anInt9710 : this.anInt9710;
   }

   final synchronized int method2504() {
      return this.anInt9716 == Integer.MIN_VALUE ? 0 : this.anInt9716;
   }

   private static final int method2505(
      int i,
      byte[] bs,
      int[] is,
      int i_138_,
      int i_139_,
      int i_140_,
      int i_141_,
      int i_142_,
      int i_143_,
      int i_144_,
      int i_145_,
      int i_146_,
      Node_Sub9_Sub2 node_sub9_sub2
   ) {
      i_138_ >>= 8;
      i_146_ >>= 8;
      i_140_ <<= 2;
      i_141_ <<= 2;
      i_142_ <<= 2;
      i_143_ <<= 2;
      if ((i_144_ = i_139_ + i_138_ - (i_146_ - 1)) > i_145_) {
         i_144_ = i_145_;
      }

      node_sub9_sub2.anInt9707 += node_sub9_sub2.anInt9709 * (i_144_ - i_139_);
      i_139_ <<= 1;
      i_144_ <<= 1;

      for(i_144_ -= 6; i_139_ < i_144_; i_141_ += i_143_) {
         int var13 = bs[i_138_--];
         int var46 = i_139_++;
         is[var46] += var13 * i_140_;
         i_140_ += i_142_;
         var46 = i_139_++;
         is[var46] += var13 * i_141_;
         int var36 = i_141_ + i_143_;
         var13 = bs[i_138_--];
         var46 = i_139_++;
         is[var46] += var13 * i_140_;
         i_140_ += i_142_;
         var46 = i_139_++;
         is[var46] += var13 * var36;
         int var37 = var36 + i_143_;
         var13 = bs[i_138_--];
         var46 = i_139_++;
         is[var46] += var13 * i_140_;
         i_140_ += i_142_;
         var46 = i_139_++;
         is[var46] += var13 * var37;
         i_141_ = var37 + i_143_;
         var13 = bs[i_138_--];
         var46 = i_139_++;
         is[var46] += var13 * i_140_;
         i_140_ += i_142_;
         var46 = i_139_++;
         is[var46] += var13 * i_141_;
      }

      for(int var44 = i_144_ + 6; i_139_ < var44; i_141_ += i_143_) {
         int var17 = bs[i_138_--];
         int var58 = i_139_++;
         is[var58] += var17 * i_140_;
         i_140_ += i_142_;
         var58 = i_139_++;
         is[var58] += var17 * i_141_;
      }

      node_sub9_sub2.anInt9711 = i_140_ >> 2;
      node_sub9_sub2.anInt9708 = i_141_ >> 2;
      node_sub9_sub2.anInt9718 = i_138_ << 8;
      return i_139_ >> 1;
   }

   @Override
   final synchronized void method2426(int i) {
      if (this.anInt9715 > 0) {
         if (i >= this.anInt9715) {
            if (this.anInt9716 == Integer.MIN_VALUE) {
               this.anInt9716 = 0;
               this.anInt9707 = this.anInt9711 = this.anInt9708 = 0;
               this.method2160((byte)118);
               i = this.anInt9715;
            }

            this.anInt9715 = 0;
            this.method2477();
         } else {
            this.anInt9707 += this.anInt9709 * i;
            this.anInt9711 += this.anInt9714 * i;
            this.anInt9708 += this.anInt9719 * i;
            this.anInt9715 -= i;
         }
      }

      Node_Sub45_Sub1 node_sub45_sub1 = (Node_Sub45_Sub1)this.aNode_Sub45_7075;
      int i_147_ = this.anInt9712 << 8;
      int i_148_ = this.anInt9706 << 8;
      int i_149_ = node_sub45_sub1.aByteArray10504.length << 8;
      int i_150_ = i_148_ - i_147_;
      if (i_150_ <= 0) {
         this.anInt9720 = 0;
      }

      if (this.anInt9718 < 0) {
         if (this.anInt9710 <= 0) {
            this.method2498();
            this.method2160((byte)32);
            return;
         }

         this.anInt9718 = 0;
      }

      if (this.anInt9718 >= i_149_) {
         if (this.anInt9710 >= 0) {
            this.method2498();
            this.method2160((byte)90);
            return;
         }

         this.anInt9718 = i_149_ - 1;
      }

      this.anInt9718 += this.anInt9710 * i;
      if (this.anInt9720 < 0) {
         if (this.aBoolean9717) {
            if (this.anInt9710 < 0) {
               if (this.anInt9718 >= i_147_) {
                  return;
               }

               this.anInt9718 = i_147_ + i_147_ - 1 - this.anInt9718;
               this.anInt9710 = -this.anInt9710;
            }

            while(this.anInt9718 >= i_148_) {
               this.anInt9718 = i_148_ + i_148_ - 1 - this.anInt9718;
               this.anInt9710 = -this.anInt9710;
               if (this.anInt9718 >= i_147_) {
                  break;
               }

               this.anInt9718 = i_147_ + i_147_ - 1 - this.anInt9718;
               this.anInt9710 = -this.anInt9710;
            }
         } else if (this.anInt9710 < 0) {
            if (this.anInt9718 < i_147_) {
               this.anInt9718 = i_148_ - 1 - (i_148_ - 1 - this.anInt9718) % i_150_;
            }
         } else if (this.anInt9718 >= i_148_) {
            this.anInt9718 = i_147_ + (this.anInt9718 - i_147_) % i_150_;
         }
      } else {
         if (this.anInt9720 > 0) {
            label109:
            if (this.aBoolean9717) {
               if (this.anInt9710 < 0) {
                  if (this.anInt9718 >= i_147_) {
                     return;
                  }

                  this.anInt9718 = i_147_ + i_147_ - 1 - this.anInt9718;
                  this.anInt9710 = -this.anInt9710;
                  if (--this.anInt9720 == 0) {
                     break label109;
                  }
               }

               do {
                  if (this.anInt9718 < i_148_) {
                     return;
                  }

                  this.anInt9718 = i_148_ + i_148_ - 1 - this.anInt9718;
                  this.anInt9710 = -this.anInt9710;
                  if (--this.anInt9720 == 0) {
                     break;
                  }

                  if (this.anInt9718 >= i_147_) {
                     return;
                  }

                  this.anInt9718 = i_147_ + i_147_ - 1 - this.anInt9718;
                  this.anInt9710 = -this.anInt9710;
               } while(--this.anInt9720 != 0);
            } else if (this.anInt9710 < 0) {
               if (this.anInt9718 >= i_147_) {
                  return;
               }

               int i_151_ = (i_148_ - 1 - this.anInt9718) / i_150_;
               if (i_151_ < this.anInt9720) {
                  this.anInt9718 += i_150_ * i_151_;
                  this.anInt9720 -= i_151_;
                  return;
               }

               this.anInt9718 += i_150_ * this.anInt9720;
               this.anInt9720 = 0;
            } else {
               if (this.anInt9718 < i_148_) {
                  return;
               }

               int i_152_ = (this.anInt9718 - i_147_) / i_150_;
               if (i_152_ < this.anInt9720) {
                  this.anInt9718 -= i_150_ * i_152_;
                  this.anInt9720 -= i_152_;
                  return;
               }

               this.anInt9718 -= i_150_ * this.anInt9720;
               this.anInt9720 = 0;
            }
         }

         if (this.anInt9710 < 0) {
            if (this.anInt9718 < 0) {
               this.anInt9718 = -1;
               this.method2498();
               this.method2160((byte)59);
            }
         } else if (this.anInt9718 >= i_149_) {
            this.anInt9718 = i_149_;
            this.method2498();
            this.method2160((byte)61);
         }
      }
   }

   private static final int method2506(byte[] bs, int[] is, int i, int i_153_, int i_154_, int i_155_, int i_156_, int i_157_, Node_Sub9_Sub2 node_sub9_sub2) {
      i >>= 8;
      i_157_ >>= 8;
      i_154_ <<= 2;
      if ((i_155_ = i_153_ + i - (i_157_ - 1)) > i_156_) {
         i_155_ = i_156_;
      }

      int var23;
      for(i_155_ -= 3; i_153_ < i_155_; is[var23] += bs[i--] * i_154_) {
         var23 = i_153_++;
         is[var23] += bs[i--] * i_154_;
         var23 = i_153_++;
         is[var23] += bs[i--] * i_154_;
         var23 = i_153_++;
         is[var23] += bs[i--] * i_154_;
         var23 = i_153_++;
      }

      for(int var19 = i_155_ + 3; i_153_ < var19; is[var23] += bs[i--] * i_154_) {
         var23 = i_153_++;
      }

      node_sub9_sub2.anInt9718 = i << 8;
      return i_153_;
   }

   final synchronized void method2507(int i) {
      int i_158_ = ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504.length << 8;
      if (i < -1) {
         i = -1;
      }

      if (i > i_158_) {
         i = i_158_;
      }

      this.anInt9718 = i;
   }

   @Override
   final Node_Sub9 method2431() {
      return null;
   }

   private final boolean method2508() {
      int i = this.anInt9716;
      int i_159_;
      int i_160_;
      if (i == Integer.MIN_VALUE) {
         i_160_ = 0;
         i_159_ = 0;
         i = 0;
      } else {
         i_159_ = method2493(i, this.anInt9713);
         i_160_ = method2491(i, this.anInt9713);
      }

      if (this.anInt9707 == i && this.anInt9711 == i_159_ && this.anInt9708 == i_160_) {
         if (this.anInt9716 == Integer.MIN_VALUE) {
            this.anInt9716 = 0;
            this.anInt9707 = this.anInt9711 = this.anInt9708 = 0;
            this.method2160((byte)100);
            return true;
         } else {
            this.method2477();
            return false;
         }
      } else {
         if (this.anInt9707 < i) {
            this.anInt9709 = 1;
            this.anInt9715 = i - this.anInt9707;
         } else if (this.anInt9707 > i) {
            this.anInt9709 = -1;
            this.anInt9715 = this.anInt9707 - i;
         } else {
            this.anInt9709 = 0;
         }

         if (this.anInt9711 < i_159_) {
            this.anInt9714 = 1;
            if (this.anInt9715 == 0 || this.anInt9715 > i_159_ - this.anInt9711) {
               this.anInt9715 = i_159_ - this.anInt9711;
            }
         } else if (this.anInt9711 > i_159_) {
            this.anInt9714 = -1;
            if (this.anInt9715 == 0 || this.anInt9715 > this.anInt9711 - i_159_) {
               this.anInt9715 = this.anInt9711 - i_159_;
            }
         } else {
            this.anInt9714 = 0;
         }

         if (this.anInt9708 < i_160_) {
            this.anInt9719 = 1;
            if (this.anInt9715 == 0 || this.anInt9715 > i_160_ - this.anInt9708) {
               this.anInt9715 = i_160_ - this.anInt9708;
            }
         } else if (this.anInt9708 > i_160_) {
            this.anInt9719 = -1;
            if (this.anInt9715 == 0 || this.anInt9715 > this.anInt9708 - i_160_) {
               this.anInt9715 = this.anInt9708 - i_160_;
            }
         } else {
            this.anInt9719 = 0;
         }

         return false;
      }
   }

   static final Node_Sub9_Sub2 method2509(Node_Sub45_Sub1 node_sub45_sub1, int i, int i_161_, int i_162_) {
      return node_sub45_sub1.aByteArray10504 != null && node_sub45_sub1.aByteArray10504.length != 0
         ? new Node_Sub9_Sub2(node_sub45_sub1, i, i_161_, i_162_)
         : null;
   }

   private static final int method2510(
      int i,
      int i_163_,
      byte[] bs,
      int[] is,
      int i_164_,
      int i_165_,
      int i_166_,
      int i_167_,
      int i_168_,
      int i_169_,
      int i_170_,
      Node_Sub9_Sub2 node_sub9_sub2,
      int i_171_,
      int i_172_
   ) {
      node_sub9_sub2.anInt9711 -= node_sub9_sub2.anInt9714 * i_165_;
      node_sub9_sub2.anInt9708 -= node_sub9_sub2.anInt9719 * i_165_;
      if (i_171_ == 0 || (i_168_ = i_165_ + (i_170_ + 256 - i_164_ + i_171_) / i_171_) > i_169_) {
         i_168_ = i_169_;
      }

      while(i_165_ < i_168_) {
         i_163_ = i_164_ >> 8;
         int var14 = bs[i_163_ - 1];
         int var10001 = i_165_++;
         is[var10001] += ((var14 << 8) + (bs[i_163_] - var14) * (i_164_ & 0xFF)) * i_166_ >> 6;
         i_166_ += i_167_;
         i_164_ += i_171_;
      }

      if (i_171_ == 0 || (i_168_ = i_165_ + (i_170_ - i_164_ + i_171_) / i_171_) > i_169_) {
         i_168_ = i_169_;
      }

      i = i_172_;

      for(int var17 = i_171_; i_165_ < i_168_; i_164_ += var17) {
         int var18 = i_165_++;
         is[var18] += ((i << 8) + (bs[i_164_ >> 8] - i) * (i_164_ & 0xFF)) * i_166_ >> 6;
         i_166_ += i_167_;
      }

      node_sub9_sub2.anInt9711 += node_sub9_sub2.anInt9714 * i_165_;
      node_sub9_sub2.anInt9708 += node_sub9_sub2.anInt9719 * i_165_;
      node_sub9_sub2.anInt9707 = i_166_;
      node_sub9_sub2.anInt9718 = i_164_;
      return i_165_;
   }

   private Node_Sub9_Sub2(Node_Sub45_Sub1 node_sub45_sub1, int i, int i_173_, int i_174_) {
      this.aNode_Sub45_7075 = node_sub45_sub1;
      this.anInt9712 = node_sub45_sub1.anInt10503;
      this.anInt9706 = node_sub45_sub1.anInt10505;
      this.aBoolean9717 = node_sub45_sub1.aBoolean10501;
      this.anInt9710 = i;
      this.anInt9716 = i_173_;
      this.anInt9713 = i_174_;
      this.anInt9718 = 0;
      this.method2477();
   }

   @Override
   final int method2432() {
      int i = this.anInt9707 * 3 >> 6;
      i = (i ^ i >> 31) + (i >>> 31);
      if (this.anInt9720 == 0) {
         i -= i * this.anInt9718 / (((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504.length << 8);
      } else if (this.anInt9720 >= 0) {
         i -= i * this.anInt9712 / ((Node_Sub45_Sub1)this.aNode_Sub45_7075).aByteArray10504.length;
      }

      return i > 255 ? 255 : i;
   }

   final synchronized int method2511() {
      return this.anInt9713 < 0 ? -1 : this.anInt9713;
   }
}
