public class Class380 {
   static int anInt4874;
   static int anInt4875;
   private byte[] aByteArray4876;
   static int anInt4877 = 0;
   private long[] aLongArray4878;
   private long[] aLongArray4879 = new long[8];
   static int anInt4880;
   private byte[] aByteArray4881;
   private long[] aLongArray4882 = new long[8];
   private int anInt4883;
   static int anInt4884;
   private long[] aLongArray4885;
   static int anInt4886;
   static int[] anIntArray4887 = new int[200];
   private long[] aLongArray4888;
   static int anInt4889;
   static int anInt4890;
   private int anInt4891;

   final void method4165(int i) {
      for(int i_0_ = 0; i_0_ < 32; ++i_0_) {
         this.aByteArray4881[i_0_] = 0;
      }

      ++anInt4890;
      this.anInt4891 = this.anInt4883 = 0;
      this.aByteArray4876[0] = 0;
      if (i < 29) {
         method4170(null, 79, null, -124, false);
      }

      for(int i_1_ = 0; ~i_1_ > -9; ++i_1_) {
         this.aLongArray4878[i_1_] = 0L;
      }
   }

   final void method4166(long l, byte[] bs, int i) {
      ++anInt4875;
      int i_2_ = 0;
      if (i != -27938) {
         method4171((byte)-98);
      }

      int i_3_ = -(7 & (int)l) + 8 & 7;
      int i_4_ = this.anInt4891 & 7;
      long l_5_ = l;
      int i_6_ = 31;

      for(int i_7_ = 0; i_6_ >= 0; --i_6_) {
         i_7_ += (255 & this.aByteArray4881[i_6_]) + ((int)l_5_ & 0xFF);
         this.aByteArray4881[i_6_] = (byte)i_7_;
         l_5_ >>>= 8;
         i_7_ >>>= 8;
      }

      while(~l < -9L) {
         int i_8_ = bs[i_2_] << i_3_ & 0xFF | (255 & bs[i_2_ - -1]) >>> 8 - i_3_;
         if (i_8_ < 0 || ~i_8_ <= -257) {
            throw new RuntimeException("LOGIC ERROR");
         }

         this.aByteArray4876[this.anInt4883] = (byte)Node_Sub16.method2590(this.aByteArray4876[this.anInt4883], i_8_ >>> i_4_);
         this.anInt4891 += 8 + -i_4_;
         ++this.anInt4883;
         if (this.anInt4891 == 512) {
            this.method4168((byte)118);
            this.anInt4891 = this.anInt4883 = 0;
         }

         this.aByteArray4876[this.anInt4883] = (byte)Node_Sub30.method2723(i_8_ << -i_4_ + 8, 255);
         this.anInt4891 += i_4_;
         ++i_2_;
         l -= 8L;
      }

      int i_9_;
      if (l <= 0L) {
         i_9_ = 0;
      } else {
         i_9_ = bs[i_2_] << i_3_ & 0xFF;
         this.aByteArray4876[this.anInt4883] = (byte)Node_Sub16.method2590(this.aByteArray4876[this.anInt4883], i_9_ >>> i_4_);
      }

      if (l + (long)i_4_ < 8L) {
         this.anInt4891 = (int)((long)this.anInt4891 + l);
      } else {
         this.anInt4891 += -i_4_ + 8;
         ++this.anInt4883;
         l -= (long)(-i_4_ + 8);
         if (this.anInt4891 == 512) {
            this.method4168((byte)117);
            this.anInt4891 = this.anInt4883 = 0;
         }

         this.aByteArray4876[this.anInt4883] = (byte)Node_Sub30.method2723(255, i_9_ << 8 + -i_4_);
         this.anInt4891 += (int)l;
      }
   }

   final void method4167(byte[] bs, int i, int i_10_) {
      ++anInt4886;
      this.aByteArray4876[this.anInt4883] = (byte)Node_Sub16.method2590(this.aByteArray4876[this.anInt4883], 128 >>> Node_Sub30.method2723(7, this.anInt4891));
      ++this.anInt4883;
      if (this.anInt4883 > 32) {
         while(~this.anInt4883 > -65) {
            this.aByteArray4876[this.anInt4883++] = 0;
         }

         this.method4168((byte)122);
         this.anInt4883 = 0;
      }

      if (i_10_ == 3) {
         while(~this.anInt4883 > -33) {
            this.aByteArray4876[this.anInt4883++] = 0;
         }

         Class311.method3608(this.aByteArray4881, 0, this.aByteArray4876, 32, 32);
         this.method4168((byte)127);
         int i_11_ = 0;

         for(int i_12_ = i; i_11_ < 8; ++i_11_) {
            long l = this.aLongArray4878[i_11_];
            bs[i_12_] = (byte)((int)(l >>> 56));
            bs[1 + i_12_] = (byte)((int)(l >>> 48));
            bs[i_12_ - -2] = (byte)((int)(l >>> 40));
            bs[3 + i_12_] = (byte)((int)(l >>> 32));
            bs[i_12_ + 4] = (byte)((int)(l >>> 24));
            bs[5 + i_12_] = (byte)((int)(l >>> 16));
            bs[i_12_ - -6] = (byte)((int)(l >>> 8));
            bs[7 + i_12_] = (byte)((int)l);
            i_12_ += 8;
         }
      }
   }

   private final void method4168(byte b) {
      ++anInt4874;
      int i = 0;

      for(int i_13_ = 0; ~i > -9; ++i) {
         this.aLongArray4885[i] = Class262_Sub11.method3177(
            Class300.method3496(255L, (long)this.aByteArray4876[i_13_ + 7]),
            Class262_Sub11.method3177(
               Class300.method3496(65280L, (long)this.aByteArray4876[i_13_ + 6] << 8),
               Class262_Sub11.method3177(
                  Class262_Sub11.method3177(
                     Class262_Sub11.method3177(
                        Class262_Sub11.method3177(
                           Class300.method3496(280375465082880L, (long)this.aByteArray4876[i_13_ + 2] << 40),
                           Class262_Sub11.method3177(
                              Class300.method3496(255L, (long)this.aByteArray4876[i_13_ - -1]) << 48, (long)this.aByteArray4876[i_13_] << 56
                           )
                        ),
                        Class300.method3496(1095216660480L, (long)this.aByteArray4876[3 + i_13_] << 32)
                     ),
                     Class300.method3496(255L, (long)this.aByteArray4876[4 + i_13_]) << 24
                  ),
                  Class300.method3496((long)this.aByteArray4876[i_13_ - -5], 255L) << 16
               )
            )
         );
         i_13_ += 8;
      }

      for(int i_14_ = 0; ~i_14_ > -9; ++i_14_) {
         this.aLongArray4879[i_14_] = Class262_Sub11.method3177(this.aLongArray4885[i_14_], this.aLongArray4882[i_14_] = this.aLongArray4878[i_14_]);
      }

      for(int i_15_ = 1; ~i_15_ >= -11; ++i_15_) {
         for(int i_16_ = 0; i_16_ < 8; ++i_16_) {
            this.aLongArray4888[i_16_] = 0L;
            int i_17_ = 0;

            for(int i_18_ = 56; i_17_ < 8; ++i_17_) {
               this.aLongArray4888[i_16_] = Class262_Sub11.method3177(
                  this.aLongArray4888[i_16_],
                  Class66_Sub2_Sub1.aLongArrayArray10584[i_17_][Node_Sub30.method2723(
                     255, (int)(this.aLongArray4882[Node_Sub30.method2723(7, -i_17_ + i_16_)] >>> i_18_)
                  )]
               );
               i_18_ -= 8;
            }
         }

         for(int i_19_ = 0; i_19_ < 8; ++i_19_) {
            this.aLongArray4882[i_19_] = this.aLongArray4888[i_19_];
         }

         this.aLongArray4882[0] = Class262_Sub11.method3177(this.aLongArray4882[0], Class66_Sub2_Sub1.aLongArray10583[i_15_]);

         for(int i_20_ = 0; i_20_ < 8; ++i_20_) {
            this.aLongArray4888[i_20_] = this.aLongArray4882[i_20_];
            int i_21_ = 0;

            for(int i_22_ = 56; i_21_ < 8; i_22_ -= 8) {
               this.aLongArray4888[i_20_] = Class262_Sub11.method3177(
                  this.aLongArray4888[i_20_],
                  Class66_Sub2_Sub1.aLongArrayArray10584[i_21_][Node_Sub30.method2723(
                     (int)(this.aLongArray4879[Node_Sub30.method2723(7, -i_21_ + i_20_)] >>> i_22_), 255
                  )]
               );
               ++i_21_;
            }
         }

         for(int i_23_ = 0; ~i_23_ > -9; ++i_23_) {
            this.aLongArray4879[i_23_] = this.aLongArray4888[i_23_];
         }
      }

      for(int i_24_ = 0; ~i_24_ > -9; ++i_24_) {
         this.aLongArray4878[i_24_] = Class262_Sub11.method3177(
            this.aLongArray4878[i_24_], Class262_Sub11.method3177(this.aLongArray4879[i_24_], this.aLongArray4885[i_24_])
         );
      }

      if (b <= 116) {
         this.anInt4883 = -14;
      }
   }

   static final Class150_Sub3 method4169(byte b, Buffer buffer) {
      ++anInt4884;
      Class150 class150 = Class338.method3906(buffer, -87);
      int i = buffer.readUnsignedShort();
      int i_25_ = buffer.readUnsignedShort();
      int i_26_ = buffer.readUnsignedShort();
      int i_27_ = buffer.readUnsignedShort();
      int i_28_ = buffer.readUnsignedShort();
      if (b != 110) {
         return null;
      } else {
         int i_29_ = buffer.readUnsignedShort();
         return new Class150_Sub3(
            class150.aClass379_5079,
            class150.aClass77_5087,
            class150.anInt5092,
            class150.anInt5080,
            class150.anInt5086,
            class150.anInt5081,
            class150.anInt5084,
            class150.anInt5083,
            class150.anInt5090,
            i,
            i_25_,
            i_26_,
            i_27_,
            i_28_,
            i_29_
         );
      }
   }

   static final void method4170(String string, int i, String string_30_, int i_31_, boolean bool) {
      FixedAnimator.getItemsForGrandExchangeSearch(true, (byte)-50, bool, -1, i, string, string_30_);
      ++anInt4880;
      if (i_31_ != 8) {
         method4170(null, 91, null, -101, true);
      }
   }

   public static void method4171(byte b) {
      anIntArray4887 = null;
      if (b != -39) {
         method4171((byte)-105);
      }
   }

   public Class380() {
      this.aByteArray4876 = new byte[64];
      this.aLongArray4878 = new long[8];
      this.anInt4883 = 0;
      this.aLongArray4888 = new long[8];
      this.aByteArray4881 = new byte[32];
      this.anInt4891 = 0;
      this.aLongArray4885 = new long[8];
   }
}
