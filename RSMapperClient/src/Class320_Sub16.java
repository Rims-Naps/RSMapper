public class Class320_Sub16 extends Class320 {
   static int anInt8356;
   static int anInt8357;
   static Class312 aClass312_8358 = new Class312();
   static int anInt8359;
   static int anInt8360;
   static int anInt8361;
   static int anInt8362;
   static int anInt8363;
   static int anInt8364;
   static int anInt8365;

   final boolean method3741(byte b) {
      if (b <= 63) {
         aClass312_8358 = null;
      }

      ++anInt8362;
      return true;
   }

   @Override
   final void method3676(boolean bool, int i) {
      this.anInt4064 = i;
      ++anInt8356;
      if (bool) {
         method3742(82, -38);
      }
   }

   static final int method3742(int i, int i_0_) {
      ++anInt8357;
      if (~i_0_ == -6408 || i_0_ == 34843 || ~i_0_ == -34838) {
         return 6407;
      } else if (i_0_ == 6408 || ~i_0_ == -34843 || i_0_ == 34836) {
         return 6408;
      } else if (~i_0_ == -6407 || ~i_0_ == -34845) {
         return 6406;
      } else if (i_0_ == 6409 || i_0_ == 34846) {
         return 6409;
      } else if (i_0_ != 6410 && ~i_0_ != -34848) {
         if (i != 6406) {
            method3743((byte)-98);
         }

         if (i_0_ == 6402) {
            return 6402;
         } else {
            throw new IllegalArgumentException("");
         }
      } else {
         return 6410;
      }
   }

   public static void method3743(byte b) {
      aClass312_8358 = null;
      int i = 53 % ((b - -66) / 33);
   }

   final int method3744(boolean bool) {
      if (bool) {
         return 40;
      } else {
         ++anInt8363;
         return this.anInt4064;
      }
   }

   Class320_Sub16(Node_Sub27 node_sub27) {
      super(node_sub27);
   }

   Class320_Sub16(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }

   @Override
   final int method3675(int i, byte b) {
      ++anInt8365;
      if (~i != -1 && ~this.aNode_Sub27_4063.aClass320_Sub23_7290.method3770(false) != -2) {
         if (b != 54) {
            this.method3676(false, 84);
         }

         return 2;
      } else {
         return 1;
      }
   }

   @Override
   final int method3677(int i) {
      ++anInt8364;
      if (i != 0) {
         this.method3675(16, (byte)82);
      }

      return 1;
   }

   @Override
   final void method3673(byte b) {
      if (this.anInt4064 != 0 && this.aNode_Sub27_4063.aClass320_Sub23_7290.method3770(false) != 1) {
         this.anInt4064 = 0;
      }

      ++anInt8359;
      if (this.anInt4064 < 0 || ~this.anInt4064 < -2) {
         this.anInt4064 = this.method3677(0);
      }

      if (b >= -35) {
         aClass312_8358 = null;
      }
   }
}
