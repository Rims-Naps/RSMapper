public class Node_Sub29_Sub1 extends Node_Sub29 {
   static int anInt10012 = -1;
   static int anInt10013;
   static int anInt10014;

   @Override
   final void method2712(byte b, float f) {
      ++anInt10013;
      this.aFloat7339 = f;
      if (b <= 55) {
         anInt10012 = -25;
      }
   }

   Node_Sub29_Sub1(int i, int i_0_, int i_1_, int i_2_, int i_3_, float f) {
      super(i, i_0_, i_1_, i_2_, i_3_, f);
   }

   @Override
   final void setReferencePositionsAndHeight(int i, int referenceX, int referenceY, int height) {
      this.referenceX = referenceX;
      this.height = height;
      if (i != 4752) {
         this.setReferencePositionsAndHeight(28, 12, 13, -12);
      }

      ++anInt10014;
      this.referenceY = referenceY;
   }
}
