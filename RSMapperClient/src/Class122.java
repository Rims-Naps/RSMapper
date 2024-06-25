public class Class122 {
   private Index aClass302_1550;
   static int anInt1551;
   static int anInt1552;
   private Index aClass302_1553;
   private Class61 aClass61_1554 = new Class61(64);
   static boolean[][] aBooleanArrayArray1555;
   static int[] anIntArray1556;

   public static void method1507(int i) {
      anIntArray1556 = null;
      aBooleanArrayArray1555 = null;
      if (i > -110) {
         method1507(-92);
      }
   }

   final CacheNode_Sub3 method1508(byte b, int i) {
      ++anInt1551;
      CacheNode_Sub3 cachenode_sub3 = (CacheNode_Sub3)this.aClass61_1554.method607((long)i, 0);
      if (cachenode_sub3 != null) {
         return cachenode_sub3;
      } else {
         byte[] bs;
         if (~i > -32769) {
            bs = this.aClass302_1550.getFile(false, i, 0);
         } else {
            bs = this.aClass302_1553.getFile(false, i & 32767, 0);
         }

         int i_0_ = 10 / ((41 - b) / 47);
         cachenode_sub3 = new CacheNode_Sub3();
         if (bs != null) {
            cachenode_sub3.method2293(new Buffer(bs), false);
         }

         if (~i <= -32769) {
            cachenode_sub3.method2299((byte)-18);
         }

         this.aClass61_1554.method601(cachenode_sub3, 25566, (long)i);
         return cachenode_sub3;
      }
   }

   Class122(int i, Index class302, Index class302_1_) {
      this.aClass302_1553 = class302_1_;
      this.aClass302_1550 = class302;
      if (this.aClass302_1550 != null) {
         this.aClass302_1550.method3537(-2, 0);
      }

      if (this.aClass302_1553 != null) {
         this.aClass302_1553.method3537(-2, 0);
      }
   }
}
