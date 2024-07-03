import com.dropbox.core.v2.DbxClientV2;

abstract class Class320 {
   protected Node_Sub27 aNode_Sub27_4063;
   protected int anInt4064;
   static int anInt4065;


   abstract void method3673(byte var1);

   final void method3674(int i, int i_0_) {
      ++anInt4065;
      if (i_0_ != this.method3675(i, (byte)54)) {
         this.method3676(false, i);
      }
   }

   abstract int method3675(int var1, byte var2);

   abstract void method3676(boolean var1, int var2);

   abstract int method3677(int var1);

   Class320(Node_Sub27 node_sub27) {
      this.aNode_Sub27_4063 = node_sub27;
      this.anInt4064 = this.method3677(0);
   }

   Class320(int i, Node_Sub27 node_sub27) {
      this.anInt4064 = i;
      this.aNode_Sub27_4063 = node_sub27;
   }
}
