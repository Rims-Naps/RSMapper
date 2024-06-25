public class Class320_Sub8 extends Class320 {
   static int anInt8279;
   static int anInt8280;
   static int anInt8281 = 0;
   static int anInt8282;
   static int anInt8283;
   static int anInt8284;
   static int anInt8285;

   @Override
   final void method3676(boolean bool, int i) {
      if (bool) {
         anInt8281 = 29;
      }

      ++anInt8283;
      this.anInt4064 = i;
   }

   @Override
   final int method3677(int i) {
      ++anInt8279;
      if (i != 0) {
         anInt8281 = 27;
      }

      return 1;
   }

   Class320_Sub8(Node_Sub27 node_sub27) {
      super(node_sub27);
   }

   final int method3712(boolean bool) {
      if (bool) {
         return -31;
      } else {
         ++anInt8282;
         return this.anInt4064;
      }
   }

   @Override
   final int method3675(int i, byte b) {
      if (b != 54) {
         return 85;
      } else {
         ++anInt8284;
         return 1;
      }
   }

   Class320_Sub8(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }

   @Override
   final void method3673(byte b) {
      ++anInt8280;
      if (this.anInt4064 != 1 && ~this.anInt4064 != -1) {
         this.anInt4064 = this.method3677(0);
      }

      if (b > -35) {
         this.method3673((byte)-33);
      }
   }
}
