import java.io.IOException;

abstract class Class365 {
   static int anInt4522;
   static int anInt4523;
   static int anInt4524;
   static int[] anIntArray4525 = new int[1];

   abstract void method4062(int var1);

   abstract void method4063(int var1);

   public static void method4064(int i) {
      anIntArray4525 = null;
      if (i != 29838) {
         method4064(-34);
      }
   }

   public Class365() {
   }

   abstract int method4065(byte var1, byte[] var2, int var3, int var4) throws IOException;

   static final void method4066(long l, int i) {
      if (Class175.aClass261ArrayArrayArray2099 != null) {
         if (Class320_Sub22.anInt8415 == 1 || Class320_Sub22.anInt8415 == 5) {
            Class321.method3799(l, 320);
         } else if (Class320_Sub22.anInt8415 == 4) {
            Node_Sub28.method2703(false, l);
         }
      }

      ++anInt4522;
      Class78.method780((long)Class174.clientCycle, 0, Class93.aGraphicsToolkit1241);
      if (~Class320_Sub15.WINDOWS_PANE_ID != 0) {
         Class290_Sub1.method3424(-23620, Class320_Sub15.WINDOWS_PANE_ID);
      }

      for(int i_1_ = 0; Node_Sub11.anInt7105 > i_1_; ++i_1_) {
         if (Class195.aBooleanArray2387[i_1_]) {
            Class320_Sub21.aBooleanArray8403[i_1_] = true;
         }

         Class190.aBooleanArray2326[i_1_] = Class195.aBooleanArray2387[i_1_];
         Class195.aBooleanArray2387[i_1_] = false;
      }

      Node_Sub12.anInt5453 = Class174.clientCycle;
      Class243.method3059(-1, (byte)29, -1, null);
      if (i > 103) {
         if (~Class320_Sub15.WINDOWS_PANE_ID != 0) {
            Node_Sub11.anInt7105 = 0;
            Exception_Sub1.method141(90);
         }

         Class93.aGraphicsToolkit1241.la();
         Class93_Sub2.checkCreateRightClickDialogue(Class93.aGraphicsToolkit1241, false);
         int i_2_ = Node_Sub52.method2972(false);
         if (~i_2_ == 0) {
            i_2_ = Class239.anInt2928;
         }

         if (i_2_ == -1) {
            i_2_ = Animable_Sub4_Sub1.anInt10687;
         }

         Class60.method594(6, i_2_);
         int i_3_ = Class295.myPlayer.getSize((byte)70) << 8;
         Class320_Sub9.method3714(Node_Sub9_Sub1.anInt9637, (byte)-127, i_3_ + Class295.myPlayer.y, Class295.myPlayer.x - -i_3_, Class295.myPlayer.plane);
         Node_Sub9_Sub1.anInt9637 = 0;
      }
   }

   abstract void method4067(byte[] var1, int var2, byte var3, int var4) throws IOException;

   abstract boolean method4068(int var1, int var2) throws IOException;
}
