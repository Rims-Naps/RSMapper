public class Class117_Sub2 extends Class117 implements Interface9 {
   static int anInt5147;
   static int anInt5148;
   static int anInt5149;
   static int anInt5150;
   static short[][][] aShortArrayArrayArray5151;
   static int anInt5152;
   static int anInt5153;
   static Buffer aBuffer5154;
   private int anInt5155;

   Class117_Sub2(GLToolkit gltoolkit, int i, byte[] bs, int i_0_, boolean bool) {
      super(gltoolkit, 34962, bs, i_0_, bool);
      this.anInt5155 = i;
   }

   @Override
   public final int method21(int i) {
      if (i != 23144) {
         this.method22(null, 15, -83, (byte)-8);
      }

      ++anInt5148;
      return this.anInt5155;
   }

   @Override
   public final long method23(int i) {
      if (i != 28552) {
         this.anInt5155 = -59;
      }

      ++anInt5147;
      return 0L;
   }

   @Override
   public final int method24(int i) {
      ++anInt5152;
      if (i != 29121) {
         method1173((byte)-49);
      }

      return this.anInt1476;
   }

   Class117_Sub2(GLToolkit gltoolkit, int i, jaclib.memory.Buffer buffer, int i_1_, boolean bool) {
      super(gltoolkit, 34962, buffer, i_1_, bool);
      this.anInt5155 = i;
   }

   static final int method1172(int i, int i_2_) {
      return Class320_Sub18.aByteArrayArray8379 != null ? Class320_Sub18.aByteArrayArray8379[i][i_2_] & 0xFF : 0;
   }

   public static void method1173(byte b) {
      aBuffer5154 = null;
      if (b < -116) {
         aShortArrayArrayArray5151 = null;
      }
   }

   @Override
   final void method1167(int i) {
      ++anInt5150;
      this.aGLToolkit1474.method1408(i + 24020, this);
      if (i != -20931) {
         this.method1167(12);
      }
   }

   @Override
   public final void method22(byte[] bs, int i, int i_13_, byte b) {
      this.method1165((byte)110, i, bs);
      ++anInt5149;
      if (b != 74) {
         aBuffer5154 = null;
      }

      this.anInt5155 = i_13_;
   }
}
