public class Class3 implements Interface10 {
   static SeekableFile aSeekableFile5156;
   static int anInt5157;
   static int anInt5158;
   static Class212 aClass212_5159 = new Class212("", 15);
   static int anInt5160;
   static int anInt5161 = -1;
   static int anInt5162;
   private Class116 aClass116_5163;

   public static void method169(int i) {
      aSeekableFile5156 = null;
      aClass212_5159 = null;
      if (i != -19320) {
         method169(74);
      }
   }

   @Override
   public final void method26(int i) {
      if (i != 99) {
         this.aClass116_5163 = null;
      }

      ++anInt5158;
   }

   @Override
   public final boolean method25(int i) {
      ++anInt5157;
      if (i != 421) {
         anInt5161 = 41;
      }

      return true;
   }

   @Override
   public final void method27(boolean bool, int i) {
      int i_0_ = -77 % ((i - 66) / 42);
      ++anInt5160;
      if (bool) {
         Class93.aGraphicsToolkit1241.aa(0, 0, Class360.canvasWidth, Class205.canvasHeight, this.aClass116_5163.anInt5071, 0);
      }
   }

   Class3(Class116 class116) {
      this.aClass116_5163 = class116;
   }
}
