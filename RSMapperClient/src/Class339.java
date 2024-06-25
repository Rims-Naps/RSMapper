abstract class Class339 {
   protected GLToolkit aGLToolkit4202;
   static int anInt4203;
   static int anInt4204 = -1;
   static int anInt4205;

   static final void method3916(boolean bool, int i) {
      ++anInt4205;
      if (!bool) {
         anInt4204 = -11;
      }

      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 6, (long)i);
      cachenode_sub2.method2291((byte)121);
   }

   abstract void method3917(Class169 var1, int var2, int var3);

   abstract void method3918(int var1);

   abstract void method3919(int var1, int var2, int var3);

   abstract void method3920(int var1, boolean var2);

   static final int method3921(int i, int i_3_, int i_4_, int i_5_) {
      i_5_ &= 3;
      ++anInt4203;
      if (i_4_ != 7) {
         return -97;
      } else if (i_5_ == 0) {
         return i;
      } else if (~i_5_ == -2) {
         return i_3_;
      } else {
         return ~i_5_ == -3 ? 7 + -i : -i_3_ + 7;
      }
   }

   Class339(GLToolkit gltoolkit) {
      this.aGLToolkit4202 = gltoolkit;
   }

   abstract boolean method3922(byte var1);

   abstract void method3923(boolean var1, int var2);
}
