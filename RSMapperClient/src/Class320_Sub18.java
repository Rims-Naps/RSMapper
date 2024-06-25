public class Class320_Sub18 extends Class320 {
   static int anInt8373;
   static int anInt8374;
   static boolean aBoolean8375 = false;
   static int anInt8376;
   static int anInt8377;
   static byte[][] underLandFileData;
   static byte[][] aByteArrayArray8379;
   static int anInt8380;
   static int anInt8381;
   static int[] anIntArray8382 = new int[8];

   public static void method3748(byte b) {
      anIntArray8382 = null;
      underLandFileData = null;
      if (b <= -42) {
         aByteArrayArray8379 = null;
      }
   }

   final int method3749(boolean bool) {
      if (bool) {
         this.method3675(31, (byte)18);
      }

      ++anInt8374;
      return this.anInt4064;
   }

   Class320_Sub18(Node_Sub27 node_sub27) {
      super(node_sub27);
   }

   @Override
   final void method3673(byte b) {
      if (this.aNode_Sub27_4063.method2697(-116)) {
         this.anInt4064 = 2;
      }

      ++anInt8376;
      if (this.anInt4064 < 0 || this.anInt4064 > 2) {
         this.anInt4064 = this.method3677(0);
      }

      if (b > -35) {
         this.method3676(false, -119);
      }
   }

   @Override
   final void method3676(boolean bool, int i) {
      ++anInt8373;
      this.anInt4064 = i;
      if (bool) {
         aByteArrayArray8379 = null;
      }
   }

   @Override
   final int method3677(int i) {
      ++anInt8380;
      if (i != 0) {
         this.method3676(false, -124);
      }

      if (this.aNode_Sub27_4063.method2697(-124)) {
         return 2;
      } else {
         return this.aNode_Sub27_4063.aClass320_Sub29_7270.method3789(-1)
               && Class250.method3096(this.aNode_Sub27_4063.aClass320_Sub29_7270.method3791(false), -111)
            ? 1
            : 0;
      }
   }

   final boolean method3750(byte b) {
      ++anInt8381;
      if (b <= 63) {
         method3748((byte)-118);
      }

      return !this.aNode_Sub27_4063.method2697(-108);
   }

   @Override
   final int method3675(int i, byte b) {
      ++anInt8377;
      if (this.aNode_Sub27_4063.method2697(b + -173)) {
         return 3;
      } else {
         if (b != 54) {
            this.method3675(-31, (byte)69);
         }

         return 1;
      }
   }

   Class320_Sub18(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }
}
