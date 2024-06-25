public class xa implements Interface20, Interface3 {
   protected long nativeid = 0L;

   @Override
   protected final void finalize() {
      if (this.nativeid != 0L) {
         Class164.method1739(0, this);
      }
   }

   private final native void r(int var1, int var2);

   private final native void va(long var1, boolean var3);

   @Override
   public final void w(boolean bool) {
      this.va(this.nativeid, bool);
   }

   xa(int i, int i_1_) {
      this.r(i, i_1_);
   }
}
