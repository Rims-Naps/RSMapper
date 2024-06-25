public class Class27 {
   private Buffer aBuffer458 = new Buffer(null);
   protected int[] anIntArray459;
   private static byte[] aByteArray460 = new byte[]{
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      1,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      2,
      0,
      1,
      2,
      1,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0,
      0
   };
   private long aLong461;
   private int[] anIntArray462;
   protected int anInt463;
   private int anInt464;
   private int[] anIntArray465;
   private int[] anIntArray466;

   final boolean method315() {
      return this.aBuffer458.buffer != null;
   }

   final long method316(int i) {
      return this.aLong461 + (long)i * (long)this.anInt464;
   }

   final int method317(int i) {
      return this.method327(i);
   }

   final void method318(int i) {
      this.anIntArray465[i] = this.aBuffer458.offset;
   }

   final void method319() {
      this.aBuffer458.buffer = null;
      this.anIntArray462 = null;
      this.anIntArray465 = null;
      this.anIntArray459 = null;
      this.anIntArray466 = null;
   }

   private final int method320(int i, int i_1_) {
      if (i_1_ == 255) {
         int i_2_ = this.aBuffer458.readUnsignedByte();
         int i_3_ = this.aBuffer458.method2239(0);
         if (i_2_ == 47) {
            this.aBuffer458.offset += i_3_;
            return 1;
         } else if (i_2_ == 81) {
            int i_4_ = this.aBuffer458.read24BitInteger();
            i_3_ -= 3;
            int i_5_ = this.anIntArray459[i];
            this.aLong461 += (long)i_5_ * (long)(this.anInt464 - i_4_);
            this.anInt464 = i_4_;
            this.aBuffer458.offset += i_3_;
            return 2;
         } else {
            this.aBuffer458.offset += i_3_;
            return 3;
         }
      } else {
         byte b = aByteArray460[i_1_ - 128];
         int i_6_ = i_1_;
         if (b >= 1) {
            i_6_ = i_1_ | this.aBuffer458.readUnsignedByte() << 8;
         }

         if (b >= 2) {
            i_6_ |= this.aBuffer458.readUnsignedByte() << 16;
         }

         return i_6_;
      }
   }

   final void method321(byte[] bs) {
      this.aBuffer458.buffer = bs;
      this.aBuffer458.offset = 10;
      int i = this.aBuffer458.readUnsignedShort();
      this.anInt463 = this.aBuffer458.readUnsignedShort();
      this.anInt464 = 500000;
      this.anIntArray462 = new int[i];

      int i_9_;
      for(int i_7_ = 0; i_7_ < i; this.aBuffer458.offset += i_9_) {
         int i_8_ = this.aBuffer458.readInt();
         i_9_ = this.aBuffer458.readInt();
         if (i_8_ == 1297379947) {
            this.anIntArray462[i_7_] = this.aBuffer458.offset;
            ++i_7_;
         }
      }

      this.aLong461 = 0L;
      this.anIntArray465 = new int[i];

      for(int i_10_ = 0; i_10_ < i; ++i_10_) {
         this.anIntArray465[i_10_] = this.anIntArray462[i_10_];
      }

      this.anIntArray459 = new int[i];
      this.anIntArray466 = new int[i];
   }

   final int method322() {
      int i = this.anIntArray465.length;
      int i_11_ = -1;
      int i_12_ = Integer.MAX_VALUE;

      for(int i_13_ = 0; i_13_ < i; ++i_13_) {
         if (this.anIntArray465[i_13_] >= 0 && this.anIntArray459[i_13_] < i_12_) {
            i_11_ = i_13_;
            i_12_ = this.anIntArray459[i_13_];
         }
      }

      return i_11_;
   }

   final void method323(int i) {
      this.aBuffer458.offset = this.anIntArray465[i];
   }

   final void method324() {
      this.aBuffer458.offset = -1;
   }

   public static void method325() {
      aByteArray460 = null;
   }

   final void method326(long l) {
      this.aLong461 = l;
      int i = this.anIntArray465.length;

      for(int i_14_ = 0; i_14_ < i; ++i_14_) {
         this.anIntArray459[i_14_] = 0;
         this.anIntArray466[i_14_] = 0;
         this.aBuffer458.offset = this.anIntArray462[i_14_];
         this.method329(i_14_);
         this.anIntArray465[i_14_] = this.aBuffer458.offset;
      }
   }

   private final int method327(int i) {
      int i_15_ = this.aBuffer458.buffer[this.aBuffer458.offset];
      if (i_15_ < 0) {
         i_15_ &= 255;
         this.anIntArray466[i] = i_15_;
         ++this.aBuffer458.offset;
      } else {
         i_15_ = this.anIntArray466[i];
      }

      if (i_15_ != 240 && i_15_ != 247) {
         return this.method320(i, i_15_);
      } else {
         int i_16_ = this.aBuffer458.method2239(0);
         if (i_15_ == 247 && i_16_ > 0) {
            int i_17_ = this.aBuffer458.buffer[this.aBuffer458.offset] & 255;
            if (i_17_ >= 241 && i_17_ <= 243 || i_17_ == 246 || i_17_ == 248 || i_17_ >= 250 && i_17_ <= 252 || i_17_ == 254) {
               ++this.aBuffer458.offset;
               this.anIntArray466[i] = i_17_;
               return this.method320(i, i_17_);
            }
         }

         this.aBuffer458.offset += i_16_;
         return 0;
      }
   }

   final boolean method328() {
      int i = this.anIntArray465.length;

      for(int i_18_ = 0; i_18_ < i; ++i_18_) {
         if (this.anIntArray465[i_18_] >= 0) {
            return false;
         }
      }

      return true;
   }

   final void method329(int i) {
      int i_19_ = this.aBuffer458.method2239(0);
      this.anIntArray459[i] += i_19_;
   }

   final int method330() {
      return this.anIntArray465.length;
   }

   public Class27() {
   }

   Class27(byte[] bs) {
      this.method321(bs);
   }
}
