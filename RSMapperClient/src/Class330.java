import java.util.Random;

public class Class330 {
   static int anInt4125;
   static String[] aStringArray4126 = new String[100];
   static boolean[] aBooleanArray4127 = new boolean[200];
   static int[][][] anIntArrayArrayArray4128;

   static final int method3838(int i, int i_0_, Random random) {
      ++anInt4125;
      if (i != -5208) {
         method3839((byte)25);
      }

      if (~i_0_ >= -1) {
         throw new IllegalArgumentException();
      } else if (Class371.method4094(i_0_, false)) {
         return (int)(((long)random.nextInt() & 4294967295L) * (long)i_0_ >> 32);
      } else {
         int i_1_ = -((int)(4294967296L % (long)i_0_)) + Integer.MIN_VALUE;

         int i_2_;
         do {
            i_2_ = random.nextInt();
         } while(i_2_ >= i_1_);

         return AnimableAnimator.method254(i_2_, i + 22147, i_0_);
      }
   }

   public static void method3839(byte b) {
      anIntArrayArrayArray4128 = null;
      aStringArray4126 = null;
      aBooleanArray4127 = null;
      if (b > -45) {
         method3839((byte)-35);
      }
   }
}
