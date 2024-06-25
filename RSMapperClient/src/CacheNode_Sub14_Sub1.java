import java.lang.ref.SoftReference;

public class CacheNode_Sub14_Sub1 extends CacheNode_Sub14 {
   private SoftReference<Object> aSoftReference11029;

   @Override
   final Object method2347(int i) {
      if (i != 27670) {
         this.method2350((byte)-12);
      }

      return this.aSoftReference11029.get();
   }

   CacheNode_Sub14_Sub1(Interface18 interface18, Object object, int i) {
      super(interface18, i);
      this.aSoftReference11029 = new SoftReference<>(object);
   }

   @Override
   final boolean method2350(byte b) {
      if (b != -38) {
         this.method2347(13);
      }

      return true;
   }
}
