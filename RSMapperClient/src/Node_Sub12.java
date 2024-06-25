public class Node_Sub12 extends Node implements Interface21 {
   static int anInt5448;
   static int anInt5449;
   static float cameraRotationHorizontal = 0.0F;
   static int anInt5451;
   static int anInt5452;
   static int anInt5453 = -2;
   protected int anInt5454;
   static int anInt5455;
   static boolean aBoolean5456 = false;
   static int anInt5457;
   protected char aChar5458;
   static int[] anIntArray5459 = new int[1];
   static int anInt5460;
   protected long aLong5461;
   protected int anInt5462;
   protected int anInt5463;
   static int anInt5464 = 1;

   @Override
   public final int method79(boolean bool) {
      ++anInt5460;
      return bool ? 68 : this.anInt5463;
   }

   public static void method2544(int i) {
      if (i != 121) {
         method2545(105, 43);
      }

      anIntArray5459 = null;
   }

   @Override
   public final long method76(int i) {
      ++anInt5452;
      if (i != -31100) {
         anInt5455 = 60;
      }

      return this.aLong5461;
   }

   static final int method2545(int i, int i_0_) {
      ++anInt5457;
      i = (1431655765 & i >>> 1) + (1431655765 & i);
      i = (i_0_ & i) - -((-858993458 & i) >>> 2);
      i = 252645135 & i - -(i >>> 4);
      i += i >>> 8;
      i += i >>> 16;
      return i & 0xFF;
   }

   @Override
   public final char method77(int i) {
      ++anInt5451;
      if (i != -24069) {
         this.method79(true);
      }

      return this.aChar5458;
   }

   @Override
   public final int method78(int i) {
      int i_1_ = -17 % ((6 - i) / 62);
      ++anInt5449;
      return this.anInt5462;
   }

   @Override
   public final int method75(int i) {
      if (i != -29764) {
         anIntArray5459 = null;
      }

      ++anInt5448;
      return this.anInt5454;
   }

   Node_Sub12() {
   }
}
