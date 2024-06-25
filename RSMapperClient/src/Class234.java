abstract class Class234 {
   static int anInt2787 = -1;
   static int anInt2788;
   static int anInt2789;
   static boolean[][][] aBooleanArrayArrayArray2790;
   static int anInt2791;
   static int anInt2792 = 0;

   static final Class233 method2144(int i) {
      ++anInt2789;
      if (i <= 64) {
         anInt2787 = 90;
      }

      try {
         return (Class233)Class.forName("Class233_Sub1").newInstance();
      } catch (Throwable var2) {
         return null;
      }
   }

   public Class234() {
   }

   abstract int method2145(byte var1, long var2);

   abstract void method2146(int var1);

   final int method2147(long l, int i) {
      ++anInt2788;
      if (i <= 50) {
         return -89;
      } else {
         long l_0_ = this.method2148((byte)92);
         if (~l_0_ < -1L) {
            Class262_Sub22.method3208(l_0_, false);
         }

         return this.method2145((byte)84, l);
      }
   }

   abstract long method2148(byte var1);

   public static void method2149(byte b) {
      aBooleanArrayArrayArray2790 = null;
      if (b != -70) {
         anInt2792 = 54;
      }
   }

   static final boolean method2150(int i, int i_1_, int i_2_) {
      ++anInt2791;
      if (i_1_ != 256) {
         method2144(-6);
      }

      return ~(i_2_ & 256) != -1;
   }

   abstract long method2151(int var1);
}
