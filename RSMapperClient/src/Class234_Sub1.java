public class Class234_Sub1 extends Class234 {
   private int anInt6913;
   private long[] aLongArray6914;
   private long aLong6915 = 0L;
   private int anInt6916 = 0;
   private long aLong6917;
   private long aLong6918;

   @Override
   final void method2146(int i) {
      this.aLong6918 = 0L;
      if (i != -4756) {
         this.aLong6915 = 33L;
      }

      if (~this.aLong6917 < ~this.aLong6915) {
         this.aLong6915 += this.aLong6917 - this.aLong6915;
      }
   }

   @Override
   final long method2148(byte b) {
      this.aLong6915 += this.method2152((byte)-15);
      if (b <= 88) {
         return 7L;
      } else {
         return this.aLong6915 < this.aLong6917 ? (-this.aLong6915 + this.aLong6917) / 1000000L : 0L;
      }
   }

   @Override
   final long method2151(int i) {
      return i != 0 ? 41L : this.aLong6915;
   }

   @Override
   final int method2145(byte b, long l) {
      if (b < 68) {
         this.method2151(70);
      }

      if (this.aLong6917 > this.aLong6915) {
         this.aLong6918 += -this.aLong6915 + this.aLong6917;
         this.aLong6915 += -this.aLong6915 + this.aLong6917;
         this.aLong6917 += l;
         return 1;
      } else {
         int i = 0;

         do {
            ++i;
            this.aLong6917 += l;
         } while(~i > -11 && ~this.aLong6915 < ~this.aLong6917);

         if (this.aLong6915 > this.aLong6917) {
            this.aLong6917 = this.aLong6915;
         }

         return i;
      }
   }

   private final long method2152(byte b) {
      if (b != -15) {
         return 4L;
      } else {
         long l = 1000000L * Class313.method3650(false);
         long l_0_ = -this.aLong6918 + l;
         this.aLong6918 = l;
         if (~l_0_ < 4999999999L && l_0_ < 5000000000L) {
            this.aLongArray6914[this.anInt6916] = l_0_;
            this.anInt6916 = (this.anInt6916 + 1) % 10;
            if (this.anInt6913 < 10) {
               ++this.anInt6913;
            }
         }

         long l_1_ = 0L;

         for(int i = 1; ~this.anInt6913 <= ~i; ++i) {
            l_1_ += this.aLongArray6914[(this.anInt6916 - i - -10) % 10];
         }

         return l_1_ / (long)this.anInt6913;
      }
   }

   Class234_Sub1() {
      this.aLongArray6914 = new long[10];
      this.anInt6913 = 1;
      this.aLong6917 = 0L;
      this.aLong6918 = 0L;
   }
}
