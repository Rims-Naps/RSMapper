public class Class320_Sub4 extends Class320 {
   static int anInt8236;
   static int anInt8237;
   static int anInt8238;
   static int anInt8239;
   static int anInt8240;
   static int anInt8241;
   static int anInt8242;
   static int gameSceneBaseY;

   Class320_Sub4(Node_Sub27 node_sub27) {
      super(node_sub27);
   }

   @Override
   final void method3676(boolean bool, int i) {
      if (bool) {
         method3693(125, 70, 79);
      }

      this.anInt4064 = i;
      ++anInt8236;
   }

   static final boolean method3693(int i, int i_0_, int i_1_) {
      if (i < 20) {
         gameSceneBaseY = 87;
      }

      ++anInt8237;
      return (2048 & i_0_) != 0;
   }

   @Override
   final void method3673(byte b) {
      ++anInt8242;
      if (this.aNode_Sub27_4063.aClass320_Sub3_7298.method3689((byte)121) && ~this.anInt4064 == -3) {
         this.anInt4064 = 1;
      }

      if (~this.anInt4064 > -1 || ~this.anInt4064 < -3) {
         this.anInt4064 = this.method3677(0);
      }

      if (b > -35) {
         this.method3694(true);
      }
   }

   @Override
   final int method3677(int i) {
      if (i != 0) {
         this.method3675(-2, (byte)-51);
      }

      ++anInt8240;
      return 2;
   }

   Class320_Sub4(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }

   final int method3694(boolean bool) {
      if (bool) {
         gameSceneBaseY = 102;
      }

      ++anInt8238;
      return this.anInt4064;
   }

   @Override
   final int method3675(int i, byte b) {
      if (b != 54) {
         method3693(-57, 54, 121);
      }

      ++anInt8239;
      return 1;
   }
}
