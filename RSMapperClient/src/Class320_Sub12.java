public class Class320_Sub12 extends Class320 {
   static int anInt8316;
   static int anInt8317;
   static int anInt8318;
   static int anInt8319;
   static int anInt8320;
   static int anInt8321;
   static int anInt8322;
   static int anInt8323;
   static Class251 aClass251_8324 = new Class251(2);
   static boolean aBoolean8325 = false;
   static Index aClass302_8326;
   static int anInt8327 = 0;

   final boolean method3726(byte b) {
      ++anInt8320;
      if (this.aNode_Sub27_4063.method2697(-82)) {
         return false;
      } else {
         if (b < 63) {
            this.method3676(false, -32);
         }

         return this.aNode_Sub27_4063.aClass320_Sub30_7275.method3796(false) != 0;
      }
   }

   static final void sendDrawWorldItem(Class121 class121, byte b, int i, int i_0_, int i_1_, int i_2_) {
      ++anInt8318;
      int i_3_ = -41 / ((-70 - b) / 56);
      Node_Sub19 node_sub19 = null;

      for(Node_Sub19 node_sub19_4_ = (Node_Sub19)Class262_Sub8.aClass312_7755.method3613(65280);
         node_sub19_4_ != null;
         node_sub19_4_ = (Node_Sub19)Class262_Sub8.aClass312_7755.method3620(16776960)
      ) {
         if (node_sub19_4_.plane == i && node_sub19_4_.x == i_1_ && ~node_sub19_4_.y == ~i_2_ && ~i_0_ == ~node_sub19_4_.typeFlag) {
            node_sub19 = node_sub19_4_;
            break;
         }
      }

      if (node_sub19 == null) {
         node_sub19 = new Node_Sub19();
         node_sub19.plane = i;
         node_sub19.x = i_1_;
         node_sub19.y = i_2_;
         node_sub19.typeFlag = i_0_;
         Class262_Sub8.aClass312_7755.method3625((byte)-54, node_sub19);
      }

      node_sub19.aBoolean7156 = false;
      node_sub19.aClass121_7160 = class121;
      node_sub19.aBoolean7159 = true;
   }

   Class320_Sub12(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }

   @Override
   final int method3677(int i) {
      if (i != 0) {
         method3728(89);
      }

      ++anInt8321;
      return 2;
   }

   static final void method3728(int i) {
      ++anInt8317;
      int i_5_ = 0;
      if (Class213.aNode_Sub27_2512.aClass320_Sub24_7317.method3773(false) == 1) {
         i_5_ |= 1;
         i_5_ |= 16;
         i_5_ |= 32;
         i_5_ |= 2;
         i_5_ |= 4;
      }

      if (i == Class213.aNode_Sub27_2512.aClass320_Sub30_7275.method3796(false)) {
         i_5_ |= 64;
      }

      Class144_Sub2.method1633(-112, i_5_);
      Class186.aClass112_2256.method1147(i_5_, 29988);
      EntityNode_Sub3_Sub1.aClass86_9166.method1005(i_5_, -64);
      Class366.aClass279_4526.method3377(false, i_5_);
      Class16.aClass101_228.method1091((byte)-52, i_5_);
      Class26.method313((byte)-85, i_5_);
      ProducingGraphicsBuffer.method2604(i + 2, i_5_);
      Class282.method3387(i + -25116, i_5_);
      Class98.method1081(i_5_, (byte)-68);
      Class243.method3061(i + 7);
   }

   @Override
   final void method3676(boolean bool, int i) {
      ++anInt8319;
      this.anInt4064 = i;
      if (bool) {
         aClass251_8324 = null;
      }
   }

   public static void method3729(byte b) {
      if (b <= 36) {
         sendDrawWorldItem(null, (byte)13, -123, 102, -91, -121);
      }

      aClass251_8324 = null;
      aClass302_8326 = null;
   }

   final int method3730(boolean bool) {
      if (bool) {
         return 109;
      } else {
         ++anInt8322;
         return this.anInt4064;
      }
   }

   Class320_Sub12(Node_Sub27 node_sub27) {
      super(node_sub27);
   }

   @Override
   final int method3675(int i, byte b) {
      ++anInt8323;
      if (this.aNode_Sub27_4063.method2697(-89)) {
         return 3;
      } else {
         if (b != 54) {
            aBoolean8325 = false;
         }

         return this.aNode_Sub27_4063.aClass320_Sub30_7275.method3796(false) == 0 ? 3 : 1;
      }
   }

   @Override
   final void method3673(byte b) {
      if (b >= -35) {
         aClass251_8324 = null;
      }

      if (this.aNode_Sub27_4063.method2697(-126)) {
         this.anInt4064 = 0;
      }

      ++anInt8316;
      if (~this.aNode_Sub27_4063.aClass320_Sub30_7275.method3796(false) == -1) {
         this.anInt4064 = 0;
      }

      if (~this.anInt4064 > -1 || this.anInt4064 > 2) {
         this.anInt4064 = this.method3677(0);
      }
   }
}
