public class Class308 {
   private Index aClass302_3906;
   static Class124 aClass124_3907 = new Class124(3);
   private Class61 aClass61_3908 = new Class61(64);
   static Index aClass302_3909;
   static int anInt3910;
   static int anInt3911;
   static int anInt3912 = Class308.orthoZoom;
   static int anInt3913;
   static int anInt3914;
   static Class139 aClass139_3915 = new Class139();
   static int orthoZoom = 7000;

   public static void method3583(int i) {
      if (i != 5) {
         method3583(-74);
      }

      aClass139_3915 = null;
      aClass124_3907 = null;
      aClass302_3909 = null;
   }

   final CacheNode_Sub6 method3584(int key, int junk) {
      ++anInt3910;
      CacheNode_Sub6 cachenode_sub6;
      synchronized(this.aClass61_3908) {
         cachenode_sub6 = (CacheNode_Sub6)this.aClass61_3908.method607((long)key, 0);
      }

      if (cachenode_sub6 != null) {
         return cachenode_sub6;
      } else {
         byte[] bs;
         synchronized(this.aClass302_3906) {
            bs = this.aClass302_3906.getFile(false, key, 5);
         }

         cachenode_sub6 = new CacheNode_Sub6();
         if (bs != null) {
            cachenode_sub6.method2315(new Buffer(bs));
         }

         synchronized(this.aClass61_3908) {
            this.aClass61_3908.method601(cachenode_sub6, 25566, (long)key);
         }

         if (junk != -13798) {
            method3585(null, false);
         }

         return cachenode_sub6;
      }
   }

   static final IComponentDefinitions method3585(IComponentDefinitions widget, boolean bool) {
      ++anInt3911;
      if (bool) {
         method3585(null, true);
      }

      IComponentDefinitions widget_1_ = Client.method109(widget);
      if (widget_1_ == null) {
         widget_1_ = widget.aWidget4836;
      }

      return widget_1_;
   }

   Class308(Class353 class353, int i, Index class302) {
      this.aClass302_3906 = class302;
      this.aClass302_3906.method3537(-2, 5);
   }
}
