public class Node_Sub29_Sub2 extends Node_Sub29 {
   static int anInt10015 = 0;
   static int anInt10016;
   static int anInt10017;
   static int anInt10018;
   static int anInt10019;
   static int anInt10020;

   static final int method2714(int i) {
      if (i >= -52) {
         method2715((byte)-40, false, 64);
      }

      ++anInt10020;
      return Class320_Sub20.anInt8397 == 1 ? CacheNode_Sub15.anInt9589 : Animable_Sub1_Sub2.anInt10668;
   }

   static final String method2715(byte b, boolean bool, int i) {
      ++anInt10018;
      if (bool && i >= 0) {
         if (b != 9) {
            method2716(-104, -31);
         }

         return Node_Sub38_Sub7.method2811(false, i, 10, bool);
      } else {
         return Integer.toString(i);
      }
   }

   Node_Sub29_Sub2(int i, int i_0_, int i_1_, int i_2_, int i_3_, float f) {
      super(i, i_0_, i_1_, i_2_, i_3_, f);
   }

   @Override
   final void setReferencePositionsAndHeight(int i, int referenceX, int referenceY, int height) {
      if (i != 4752) {
         method2716(61, -81);
      }

      ++anInt10019;
      this.referenceY = referenceY;
      this.referenceX = referenceX;
      this.height = height;
   }

   static final int method2716(int i, int i_7_) {
      ++anInt10016;
      if (i != 0) {
         anInt10015 = -93;
      }

      return i_7_ >>> 8;
   }

   @Override
   final void method2712(byte b, float f) {
      ++anInt10017;
      this.aFloat7339 = f;
      if (b < 55) {
         method2715((byte)-30, true, -18);
      }
   }
}
