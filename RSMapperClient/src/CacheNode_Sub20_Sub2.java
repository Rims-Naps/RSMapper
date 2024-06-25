import java.lang.ref.SoftReference;

public class CacheNode_Sub20_Sub2 extends CacheNode_Sub20 {
   private SoftReference<Object> aSoftReference11094;

   @Override
   final Object method2409(byte b) {
      if (b >= -39) {
         this.aSoftReference11094 = null;
      }

      return this.aSoftReference11094.get();
   }

   @Override
   final boolean method2411(int i) {
      if (i >= -77) {
         this.method2411(-47);
      }

      return true;
   }

   CacheNode_Sub20_Sub2(Object object, int i) {
      super(i);
      this.aSoftReference11094 = new SoftReference<>(object);
   }
}
