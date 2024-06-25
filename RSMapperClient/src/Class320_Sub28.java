public class Class320_Sub28 extends Class320 {
   static int anInt8469;
   static int anInt8470;
   static int anInt8471;
   static int anInt8472;
   static int anInt8473;
   static Object anObject8474;
   static int anInt8475;
   static int anInt8476;
   static int anInt8477;

   static final void method3784(byte b) {
      ++anInt8475;
      if (!Mobile_Sub4.aBoolean10988) {
         Node_Sub36_Sub1.cameraRotationVerticalIncrement += (12.0F - Node_Sub36_Sub1.cameraRotationVerticalIncrement) / 2.0F;
         Mobile_Sub4.aBoolean10988 = true;
         if (b != -7) {
            method3784((byte)-54);
         }

         Node_Sub25_Sub1.aBoolean9950 = true;
      }
   }

   @Override
   final int method3677(int i) {
      ++anInt8476;
      if (this.aNode_Sub27_4063.method2694(i ^ -13725).method1877((byte)71) < 96) {
         return 0;
      } else {
         if (i != 0) {
            this.method3673((byte)-52);
         }

         return 2;
      }
   }

   @Override
   final int method3675(int i, byte b) {
      ++anInt8473;
      if (~this.aNode_Sub27_4063.method2694(-13725).method1877((byte)71) > -97) {
         return 3;
      } else {
         if (b != 54) {
            anInt8469 = -9;
         }

         return 1;
      }
   }

   @Override
   final void method3676(boolean bool, int i) {
      ++anInt8471;
      if (bool) {
         anInt8469 = -115;
      }

      this.anInt4064 = i;
      Class366.method4071(this.anInt4064, 63);
   }

   public static void method3785(int i) {
      anObject8474 = null;
      if (i != -97) {
         method3785(-25);
      }
   }

   Class320_Sub28(Node_Sub27 node_sub27) {
      super(node_sub27);
      Class366.method4071(this.anInt4064, 62);
   }

   final boolean method3786(byte b) {
      ++anInt8470;
      if (b <= 63) {
         anInt8469 = 85;
      }

      return this.aNode_Sub27_4063.method2694(-13725).method1877((byte)71) >= 96;
   }

   Class320_Sub28(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
      Class366.method4071(this.anInt4064, 80);
   }

   final int method3787(boolean bool) {
      if (bool) {
         return 92;
      } else {
         ++anInt8472;
         return this.anInt4064;
      }
   }

   @Override
   final void method3673(byte b) {
      ++anInt8477;
      if (~this.aNode_Sub27_4063.method2694(-13725).method1877((byte)71) > -97) {
         this.anInt4064 = 0;
      }

      if (b >= -35) {
         anInt8469 = -126;
      }

      if (~this.anInt4064 > -1 || ~this.anInt4064 < -3) {
         this.anInt4064 = this.method3677(0);
      }
   }
}
