public class Class320_Sub23 extends Class320 {
   static int anInt8426;
   static int anInt8427;
   static int anInt8428;
   static int anInt8429;
   static int anInt8430;
   static int anInt8431;
   static Class123 aClass123_8432;
   static int anInt8433;
   static int anInt8434;
   static int anInt8435;

   @Override
   final int method3675(int i, byte b) {
      ++anInt8430;
      if (this.aNode_Sub27_4063.method2697(-90)) {
         return 3;
      } else if (this.aNode_Sub27_4063.method2691(b + -51) == Node_Sub38_Sub34.aClass353_10443) {
         if (~i == -1) {
            if (this.aNode_Sub27_4063.aClass320_Sub16_7316.method3744(false) == 1) {
               return 2;
            }

            if (~this.aNode_Sub27_4063.aClass320_Sub30_7275.method3796(false) == -2) {
               return 2;
            }

            if (~this.aNode_Sub27_4063.aClass320_Sub26_7269.method3779(false) < -1) {
               return 2;
            }
         }

         return 1;
      } else {
         if (b != 54) {
            method3768((byte)-127);
         }

         return 3;
      }
   }

   @Override
   final void method3673(byte b) {
      ++anInt8428;
      if (this.aNode_Sub27_4063.method2691(3) == Node_Sub38_Sub34.aClass353_10443) {
         if (this.aNode_Sub27_4063.method2697(-97)) {
            this.anInt4064 = 0;
         }
      } else {
         this.anInt4064 = 1;
      }

      if (this.anInt4064 != 0 && ~this.anInt4064 != -2) {
         this.anInt4064 = this.method3677(0);
      }

      if (b >= -35) {
         this.method3673((byte)32);
      }
   }

   @Override
   final void method3676(boolean bool, int i) {
      this.anInt4064 = i;
      ++anInt8426;
      if (bool) {
         this.method3677(70);
      }
   }

   public static void method3768(byte b) {
      aClass123_8432 = null;
      if (b != -96) {
         anInt8434 = -36;
      }
   }

   final boolean method3769(byte b) {
      if (b <= 63) {
         this.method3673((byte)-124);
      }

      ++anInt8427;
      if (this.aNode_Sub27_4063.method2697(-106)) {
         return false;
      } else {
         return this.aNode_Sub27_4063.method2691(3) == Node_Sub38_Sub34.aClass353_10443;
      }
   }

   @Override
   final int method3677(int i) {
      if (i != 0) {
         this.method3677(-52);
      }

      ++anInt8429;
      return 1;
   }

   Class320_Sub23(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }

   final int method3770(boolean bool) {
      ++anInt8435;
      return bool ? -66 : this.anInt4064;
   }

   Class320_Sub23(Node_Sub27 node_sub27) {
      super(node_sub27);
   }
}
