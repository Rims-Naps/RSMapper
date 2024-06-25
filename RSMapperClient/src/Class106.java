public class Class106 {
   static int anInt1349;
   protected int anInt1350;
   static int anInt1351;
   static int anInt1352;
   private GLXToolkit aGLXToolkit1353;
   static Class135 aClass135_1354 = new Class135();
   static int anInt1355;
   static Class93 aClass93_1356;
   static Class170 aClass170_1357 = new Class170(7, 2);
   static int anInt1358;

   static final String[] method1120(byte b, String string, char c) {
      ++anInt1352;
      int i = Node_Sub15_Sub3.method2564(string, true, c);
      String[] strings = new String[1 + i];
      int i_1_ = 0;
      int i_2_ = 0;

      for(int i_3_ = 0; i > i_3_; ++i_3_) {
         int i_4_ = i_2_;

         while(~c != ~string.charAt(i_4_)) {
            ++i_4_;
         }

         strings[i_1_++] = string.substring(i_2_, i_4_);
         i_2_ = 1 + i_4_;
      }

      strings[i] = string.substring(i_2_);
      return strings;
   }

   @Override
   protected final void finalize() throws Throwable {
      ++anInt1355;
      this.aGLXToolkit1353.method1400(this.anInt1350, -15743);
      super.finalize();
   }

   static final boolean method1121(int i, char c) {
      ++anInt1351;
      if (i >= -96) {
         aClass170_1357 = null;
      }

      if ((c <= 0 || ~c <= -129) && (c < 160 || c > 255)) {
         if (c != 0) {
            char[] cs = Class204.aCharArray2455;

            for(int i_5_ = 0; ~cs.length < ~i_5_; ++i_5_) {
               int i_6_ = cs[i_5_];
               if (~i_6_ == ~c) {
                  return true;
               }
            }
         }

         return false;
      } else {
         return true;
      }
   }

   public static void method1122(byte b) {
      aClass135_1354 = null;
      aClass170_1357 = null;
      aClass93_1356 = null;
   }

   static final Class251 method1123(int i, byte b) {
      ++anInt1358;
      Class251[] class251s = Class213.method2056(false);
      int i_7_ = 0;
      if (b != 39) {
         aClass135_1354 = null;
      }

      while(~i_7_ > ~class251s.length) {
         Class251 class251 = class251s[i_7_];
         if (i == class251.anInt3182) {
            return class251;
         }

         ++i_7_;
      }

      return null;
   }

   Class106(GLXToolkit glxtoolkit, int i, int i_8_) {
      this.aGLXToolkit1353 = glxtoolkit;
      this.anInt1350 = i_8_;
   }
}
