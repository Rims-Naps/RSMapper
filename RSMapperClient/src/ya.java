public class ya extends za implements Interface3 {
   protected long nativeid;

   final native void ga();

   @Override
   protected final void finalize() {
      if (this.nativeid != 0L) {
         Class164.method1739(0, this);
      }
   }

   ya(oa var_oa, int i) {
      this.aa(var_oa, i);
   }

   private final native void aa(oa var1, int var2);

   final native void r();

   @Override
   public final native void w(boolean var1);
}
