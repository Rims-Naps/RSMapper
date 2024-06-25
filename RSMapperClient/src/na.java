public class na extends aa implements Interface3 {
   protected long nativeid;

   @Override
   protected final void finalize() {
      if (this.nativeid != 0L) {
         Class164.method1739(0, this);
      }
   }

   na(oa var_oa, ya var_ya, int i, int i_0_, int[] is, int[] is_1_) {
      this.ma(var_oa, var_ya, i, i_0_, is, is_1_);
   }

   private final native void ma(oa var1, ya var2, int var3, int var4, int[] var5, int[] var6);

   @Override
   public final native void w(boolean var1);
}
