public class Class51_Sub2 extends Class51 implements Interface15_Impl1 {
   static int anInt9065;
   static int anInt9066;
   static int anInt9067;
   static int[] anIntArray9068 = new int[4];
   static int anInt9069 = 0;
   static int anInt9070 = 0;
   private Class372 aClass372_9071;
   static int anInt9072;
   static int anInt9073;
   static float aFloat9074;
   static int anInt9075;

   @Override
   public final jaclib.memory.Buffer method54(boolean bool, byte b) {
      ++anInt9075;
      if (b <= 66) {
         this.method56(31, 118);
      }

      return super.method519(bool, this.aGLXToolkit5332.aMapBuffer9308, -5934);
   }

   public static void method524(byte b) {
      anIntArray9068 = null;
      if (b != -68) {
         method524((byte)89);
      }
   }

   @Override
   public final int method57(byte b) {
      if (b > -56) {
         anIntArray9068 = null;
      }

      ++anInt9067;
      return super.method57((byte)-79);
   }

   @Override
   public final Class372 method55(int i) {
      int i_0_ = 121 / ((55 - i) / 39);
      ++anInt9073;
      return this.aClass372_9071;
   }

   @Override
   public final void method56(int i, int i_1_) {
      super.method56(i, this.aClass372_9071.anInt4591 * i_1_);
      ++anInt9072;
   }

   @Override
   public final boolean method53(int i) {
      ++anInt9066;
      return i != -3308 ? false : super.method517(0, this.aGLXToolkit5332.aMapBuffer9308);
   }

   @Override
   public final void method38(boolean bool) {
      if (!bool) {
         ++anInt9065;
         super.method38(bool);
      }
   }

   Class51_Sub2(GLXToolkit glxtoolkit, Class372 class372, boolean bool) {
      super(glxtoolkit, 34963, bool);
      this.aClass372_9071 = class372;
   }
}
