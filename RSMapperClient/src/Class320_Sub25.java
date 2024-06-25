public class Class320_Sub25 extends Class320 {
   static int anInt8445;
   static int anInt8446;
   static int anInt8447;
   static int anInt8448;
   static int anInt8449;

   @Override
   final void method3676(boolean bool, int i) {
      ++anInt8446;
      this.anInt4064 = i;
   }

   @Override
   final void method3673(byte b) {
      if (~this.anInt4064 > -1 && ~this.anInt4064 < -128) {
         this.anInt4064 = this.method3677(0);
      }

      ++anInt8447;
   }

   @Override
   final int method3675(int i, byte b) {
      if (b != 54) {
         return 73;
      } else {
         ++anInt8445;
         return 1;
      }
   }

   Class320_Sub25(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }

   final int method3776(boolean bool) {
      ++anInt8448;
      if (bool) {
         this.method3675(60, (byte)-5);
      }

      return this.anInt4064;
   }

   @Override
   final int method3677(int i) {
      ++anInt8449;
      return i != 0 ? 25 : 127;
   }

   Class320_Sub25(Node_Sub27 node_sub27) {
      super(node_sub27);
   }
}
