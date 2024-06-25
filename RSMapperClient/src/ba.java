public class ba extends r implements Interface3 {
   protected long nativeid;

   @Override
   public final native void w(boolean var1);

   @Override
   protected final void finalize() {
      if (this.nativeid != 0L) {
         Class164.method1739(0, this);
      }
   }

   ba(oa var_oa) {
   }
}
