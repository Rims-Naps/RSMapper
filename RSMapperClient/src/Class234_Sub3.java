import jagex3.jagmisc.jagmisc;

public class Class234_Sub3 extends Class234 {
   private long aLong6925 = 0L;
   private long aLong6926 = 0L;
   private int anInt6927;
   private long aLong6928 = 0L;
   private long[] aLongArray6929;
   private int anInt6930;

   @Override
   final void method2146(int i) {
      this.aLong6928 = 0L;
      if (~this.aLong6926 > ~this.aLong6925) {
         this.aLong6926 += -this.aLong6926 + this.aLong6925;
      }

      if (i != -4756) {
         this.method2151(-37);
      }
   }

   private final long method2154(int i) {
      long l = jagmisc.nanoTime();
      if (i != 26477) {
         this.method2146(2);
      }

      long l_0_ = l - this.aLong6928;
      this.aLong6928 = l;
      if (l_0_ > -5000000000L && ~l_0_ > -5000000001L) {
         this.aLongArray6929[this.anInt6927] = l_0_;
         if (this.anInt6930 < 1) {
            ++this.anInt6930;
         }

         this.anInt6927 = (1 + this.anInt6927) % 10;
      }

      long l_1_ = 0L;

      for(int i_2_ = 1; i_2_ <= this.anInt6930; ++i_2_) {
         l_1_ += this.aLongArray6929[(this.anInt6927 + -i_2_ - -10) % 10];
      }

      return l_1_ / (long)this.anInt6930;
   }

   @Override
   final long method2151(int i) {
      if (i != 0) {
         this.anInt6930 = 42;
      }

      return this.aLong6926;
   }

   @Override
   final long method2148(byte b) {
      if (b <= 88) {
         this.aLong6925 = 62L;
      }

      this.aLong6926 += this.method2154(26477);
      return this.aLong6925 > this.aLong6926 ? (this.aLong6925 - this.aLong6926) / 1000000L : 0L;
   }

   @Override
   final int method2145(byte b, long l) {
      if (b < 68) {
         this.aLongArray6929 = null;
      }

      if (this.aLong6925 > this.aLong6926) {
         this.aLong6928 += -this.aLong6926 + this.aLong6925;
         this.aLong6926 += -this.aLong6926 + this.aLong6925;
         this.aLong6925 += l;
         return 1;
      } else {
         int i = 0;

         do {
            this.aLong6925 += l;
         } while(++i < 10 && ~this.aLong6926 < ~this.aLong6925);

         if (this.aLong6926 > this.aLong6925) {
            this.aLong6925 = this.aLong6926;
         }

         return i;
      }
   }

   Class234_Sub3() {
      this.anInt6927 = 0;
      this.aLongArray6929 = new long[10];
      this.anInt6930 = 1;
      this.aLong6925 = this.aLong6926 = jagmisc.nanoTime();
      if (this.aLong6926 == 0L) {
         throw new RuntimeException();
      }
   }
}
