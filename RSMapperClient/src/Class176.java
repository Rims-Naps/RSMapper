public class Class176 {
   private Index aClass302_2101;
   static Index index28;
   static int anInt2103;
   private Class61 aClass61_2104 = new Class61(64);
   protected int anInt2105;
   static Node_Sub9_Sub3 aNode_Sub9_Sub3_2106;

   final Class254 method1805(int i, int i_0_) {
      ++anInt2103;
      if (i_0_ != -4409) {
         return null;
      } else {
         Class254 class254;
         synchronized(this.aClass61_2104) {
            class254 = (Class254)this.aClass61_2104.method607((long)i, 0);
         }

         if (class254 != null) {
            return class254;
         } else {
            byte[] bs;
            synchronized(this.aClass302_2101) {
               bs = this.aClass302_2101.getFile(false, i, 19);
            }

            class254 = new Class254();
            if (bs != null) {
               class254.method3109((byte)100, new Buffer(bs));
            }

            synchronized(this.aClass61_2104) {
               this.aClass61_2104.method601(class254, 25566, (long)i);
               return class254;
            }
         }
      }
   }

   public static void method1806(int i) {
      index28 = null;
      if (i != -25421) {
         method1806(-44);
      }

      aNode_Sub9_Sub3_2106 = null;
   }

   Class176(Class353 class353, int i, Index class302) {
      this.aClass302_2101 = class302;
      this.anInt2105 = this.aClass302_2101.method3537(-2, 19);
   }
}
