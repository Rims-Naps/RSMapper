public class CacheNode_Sub2 extends CacheNode {
   protected String aString9428;
   protected int anInt9429;
   static int anInt9430;
   static int anInt9431;
   protected int anInt9432;
   static int anInt9433;
   protected int anInt9434;
   static int anInt9435;
   static Class329 aClass329_9436 = new Class329("LOCAL", "", "local", 4);
   static int anInt9437;
   static Class357 aClass357_9438;

   public static void method2286(int i) {
      aClass357_9438 = null;
      if (i != -9303) {
         aClass357_9438 = null;
      }

      aClass329_9436 = null;
   }

   final long method2287(int i) {
      if (i != 13) {
         return -50L;
      } else {
         ++anInt9433;
         return this.aLong7037 & Long.MAX_VALUE;
      }
   }

   final void method2288(int i) {
      this.aLong7037 |= Long.MIN_VALUE;
      ++anInt9430;
      if (this.method2287(13) == (long)i) {
         Class72.aClass158_974.method1719(true, this);
      }
   }

   final int method2289(int i) {
      ++anInt9437;
      if (i != 255) {
         this.aString9428 = null;
      }

      return (int)(255L & this.scriptId >>> 56);
   }

   final long method2290(int i) {
      ++anInt9431;
      if (i <= 79) {
         this.method2288(40);
      }

      return 72057594037927935L & this.scriptId;
   }

   final void method2291(byte b) {
      if (b != 121) {
         this.anInt9434 = 69;
      }

      this.aLong7037 = Class313.method3650(false) + 500L | this.aLong7037 & Long.MIN_VALUE;
      ++anInt9435;
      Node_Sub5.aClass158_7027.method1719(true, this);
   }

   CacheNode_Sub2(int i, long l) {
      this.scriptId = l | (long)i << 56;
   }
}
