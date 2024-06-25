public class n extends Class52 implements Interface3 {
   protected long nativeid;

   @Override
   final native void fa(char var1, int var2, int var3, int var4, boolean var5);

   private final native void PA(char var1, int var2, int var3, int var4, boolean var5, aa var6, int var7, int var8);

   n(oa var_oa, ya var_ya, Class357 class357, Class383[] class383s, GLSprite[] glsprites) {
      super(var_oa, class357);
      byte[][] bs = new byte[class383s.length][];
      int[] is = new int[class383s.length];
      int[] is_6_ = new int[class383s.length];
      int[] is_7_ = new int[class383s.length];
      int[] is_8_ = new int[class383s.length];

      for(int i = 0; i < class383s.length; ++i) {
         bs[i] = class383s[i].aByteArray4903;
         is[i] = class383s[i].anInt4897;
         is_6_[i] = class383s[i].anInt4900;
         is_7_[i] = class383s[i].anInt4902;
         is_8_[i] = class383s[i].anInt4898;
      }

      this.S(var_oa, var_ya, bs, class383s[0].anIntArray4904, is, is_6_, is_7_, is_8_);
   }

   private final native void S(oa var1, ya var2, byte[][] var3, int[] var4, int[] var5, int[] var6, int[] var7, int[] var8);

   @Override
   public final native void w(boolean var1);

   @Override
   final void method526(char c, int i, int i_13_, int i_14_, boolean bool, aa var_aa, int i_15_, int i_16_) {
      this.PA(c, i, i_13_, i_14_, bool, var_aa, i_15_, i_16_);
   }

   @Override
   protected final void finalize() {
      if (this.nativeid != 0L) {
         Class164.method1739(0, this);
      }
   }
}
