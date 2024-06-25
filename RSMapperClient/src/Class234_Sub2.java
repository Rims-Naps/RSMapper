public class Class234_Sub2 extends Class234 {
   private long aLong6919 = 0L;
   private long aLong6920 = 0L;
   private long aLong6921 = 0L;
   private int anInt6922;
   private int anInt6923;
   private long[] aLongArray6924 = new long[10];

   @Override
   final int method2145(byte b, long l) {
      if (b <= 68) {
         return -115;
      } else if (this.aLong6919 > this.aLong6920) {
         this.aLong6921 += this.aLong6919 + -this.aLong6920;
         this.aLong6920 += this.aLong6919 + -this.aLong6920;
         this.aLong6919 += l;
         return 1;
      } else {
         int i = 0;

         do {
            this.aLong6919 += l;
         } while(~(++i) > -11 && this.aLong6920 > this.aLong6919);

         if (~this.aLong6919 > ~this.aLong6920) {
            this.aLong6919 = this.aLong6920;
         }

         return i;
      }
   }

   @Override
   final long method2148(byte b) {
      this.aLong6920 += this.method2153((byte)90);
      if (b < 88) {
         this.method2148((byte)-34);
      }

      return this.aLong6920 < this.aLong6919 ? (this.aLong6919 + -this.aLong6920) / 1000000L : 0L;
   }

   @Override
   final long method2151(int i) {
      if (i != 0) {
         this.aLong6919 = 100L;
      }

      return this.aLong6920;
   }

   private final long method2153(byte b) {
      long l = System.nanoTime();
      long l_0_ = -this.aLong6921 + l;
      this.aLong6921 = l;
      if (l_0_ > -5000000000L && ~l_0_ > -5000000001L) {
         this.aLongArray6924[this.anInt6923] = l_0_;
         this.anInt6923 = (this.anInt6923 + 1) % 10;
         if (~this.anInt6922 > -2) {
            ++this.anInt6922;
         }
      }

      long l_1_ = 0L;

      for(int i = 1; this.anInt6922 >= i; ++i) {
         l_1_ += this.aLongArray6924[(this.anInt6923 + -i - -10) % 10];
      }

      int i = -38 / ((b - -10) / 54);
      return l_1_ / (long)this.anInt6922;
   }

   @Override
   final void method2146(int i) {
      if (i != -4756) {
         this.anInt6922 = -107;
      }

      if (this.aLong6919 > this.aLong6920) {
         this.aLong6920 += this.aLong6919 + -this.aLong6920;
      }

      this.aLong6921 = 0L;
   }

   Class234_Sub2() {
      this.anInt6923 = 0;
      this.anInt6922 = 1;
      this.aLong6920 = System.nanoTime();
      this.aLong6919 = System.nanoTime();
   }
}
