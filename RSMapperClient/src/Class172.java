public class Class172 {
   static int anInt2075;
   static int anInt2076;
   static Class172 aClass172_2077 = new Class172();
   static Class172 aClass172_2078 = new Class172();
   static Class172 aClass172_2079 = new Class172();
   static Class172 aClass172_2080 = new Class172();

   public static void method1796(int i) {
      aClass172_2078 = null;
      aClass172_2080 = null;
      aClass172_2079 = null;
      aClass172_2077 = null;
      if (i != -1) {
         aClass172_2077 = null;
      }
   }

   static final int method1797(int i, Player player) {
      ++anInt2075;
      int i_0_ = player.anInt11153;
      RenderDefinitions class259 = player.method868((byte)-127);
      int i_1_ = player.anAnimator10860.getAnimationId();
      if (i != i_1_ && !player.aBoolean10867) {
         if (~class259.anInt3252 == ~i_1_ || ~i_1_ == ~class259.anInt3271 || class259.anInt3293 == i_1_ || class259.anInt3270 == i_1_) {
            i_0_ = player.anInt11182;
         } else if (~class259.anInt3262 == ~i_1_ || class259.anInt3297 == i_1_ || ~class259.anInt3304 == ~i_1_ || class259.anInt3269 == i_1_) {
            i_0_ = player.anInt11172;
         }
      } else {
         i_0_ = player.anInt11167;
      }

      return i_0_;
   }

   @Override
   public final String toString() {
      ++anInt2076;
      throw new IllegalStateException();
   }
}
