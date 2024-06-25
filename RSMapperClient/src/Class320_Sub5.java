public class Class320_Sub5 extends Class320 {
   static int anInt8244;
   static int anInt8245;
   static int anInt8246;
   static int anInt8247;
   static int anInt8248;
   static int anInt8249;
   static int anInt8250;
   static IncommingPacket aClass192_8251 = new IncommingPacket(137, 8);
   static int anInt8252;
   static Class124 aClass124_8253 = new Class124(41);
   static GLSprite[] aGLSpriteArray8254;
   static int[] anIntArray8255 = new int[64];

   Class320_Sub5(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }

   static final void method3695(Class179 class179) {
      Node_Sub36_Sub3.aClass179_10058 = class179;
   }

   @Override
   final void method3676(boolean bool, int i) {
      this.anInt4064 = i;
      if (bool) {
         this.method3697(true);
      }

      ++anInt8248;
   }

   public static void method3696(int i) {
      aClass124_8253 = null;
      aGLSpriteArray8254 = null;
      anIntArray8255 = null;
      aClass192_8251 = null;
      if (i != -15183) {
         anIntArray8255 = null;
      }
   }

   final int method3697(boolean bool) {
      if (bool) {
         method3699(-30);
      }

      ++anInt8247;
      return this.anInt4064;
   }

   Class320_Sub5(Node_Sub27 node_sub27) {
      super(node_sub27);
   }

   final boolean method3698(byte b) {
      ++anInt8246;
      int i = this.aNode_Sub27_4063.method2694(-13725).method1877((byte)71);
      if (b <= 63) {
         return false;
      } else {
         return ~i <= -97;
      }
   }

   @Override
   final void method3673(byte b) {
      if (b >= -35) {
         anIntArray8255 = null;
      }

      ++anInt8252;
      int i = this.aNode_Sub27_4063.method2694(-13725).method1877((byte)71);
      if (i < 96) {
         this.anInt4064 = 0;
      }

      if (~this.anInt4064 < -2 && ~i > -129) {
         this.anInt4064 = 1;
      }

      if (~this.anInt4064 < -3 && i < 192) {
         this.anInt4064 = 2;
      }

      if (this.anInt4064 < 0 || this.anInt4064 > 3) {
         this.anInt4064 = this.method3677(0);
      }
   }

   @Override
   final int method3677(int i) {
      ++anInt8244;
      return i != 0 ? -39 : 0;
   }

   static final OutgoingPacketBuffer method3699(int i) {
      ++anInt8249;
      if (i <= 82) {
         method3695(null);
      }

      return Class45.anInt5270 == 0 ? new OutgoingPacketBuffer() : Node_Sub30.aNode_Sub13Array7362[--Class45.anInt5270];
   }

   @Override
   final int method3675(int i, byte b) {
      ++anInt8250;
      int i_0_ = this.aNode_Sub27_4063.method2694(-13725).method1877((byte)71);
      if (b != 54) {
         anIntArray8255 = null;
      }

      if (~i_0_ > -97) {
         return 3;
      } else if (~i < -2 && i_0_ < 128) {
         return 3;
      } else {
         return i > 3 && ~i_0_ > -193 ? 3 : 1;
      }
   }

   static final boolean method3700(int i, byte b, int i_1_) {
      ++anInt8245;
      if (b <= 122) {
         method3700(-11, (byte)-127, 7);
      }

      return ~(33 & i_1_) != -1;
   }
}
