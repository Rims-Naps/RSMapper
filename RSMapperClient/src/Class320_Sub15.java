public class Class320_Sub15 extends Class320 {
   static int anInt8348;
   static int anInt8349;
   static int anInt8350;
   static int anInt8351;
   static int anInt8352;
   static int anInt8353;
   static String[] aStringArray8354;
   static volatile int WINDOWS_PANE_ID = -1;

   @Override
   final int method3675(int i, byte b) {
      ++anInt8353;
      if (b != 54) {
         method3739((byte)-14, true, null);
      }

      return 1;
   }

   Class320_Sub15(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }

   @Override
   final void method3676(boolean bool, int i) {
      ++anInt8350;
      if (bool) {
         this.method3677(121);
      }

      this.anInt4064 = i;
   }

   @Override
   final void method3673(byte b) {
      if (~this.anInt4064 > -1 || this.anInt4064 > 4) {
         this.anInt4064 = this.method3677(0);
      }

      ++anInt8352;
      if (b >= -35) {
         this.method3677(-78);
      }
   }

   final int method3738(boolean bool) {
      ++anInt8349;
      return bool ? -64 : this.anInt4064;
   }

   static final byte[] method3739(byte junk, boolean bool, Object object) {
      ++anInt8351;
      if (object == null) {
         return null;
      } else if (object instanceof byte[]) {
         byte[] bs = (byte[])object;
         return bool ? Class93.method1046(bs, 7348) : bs;
      } else if (object instanceof Class201) {
         Class201 class201 = (Class201)object;
         return class201.method2022((byte)92);
      } else {
         int i = 16 / ((92 - junk) / 33);
         throw new IllegalArgumentException();
      }
   }

   @Override
   final int method3677(int i) {
      if (i != 0) {
         aStringArray8354 = null;
      }

      ++anInt8348;
      return 0;
   }

   public static void method3740(boolean bool) {
      aStringArray8354 = null;
      if (!bool) {
         aStringArray8354 = null;
      }
   }

   Class320_Sub15(Node_Sub27 node_sub27) {
      super(node_sub27);
   }
}
