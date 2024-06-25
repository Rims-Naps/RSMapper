public class ja extends Class336 implements Interface3 {
   protected long nativeid;

   private final native void XA(long var1, int var3, int var4, int var5, int[] var6);

   @Override
   final void method3854(int i, int i_2_, int i_3_) {
      this.FA(this.nativeid, i, i_2_, i_3_);
   }

   @Override
   final void method3864(int i, int i_4_, int i_5_, int i_6_, int i_7_, int i_8_) {
      this.P(this.nativeid, i, i_4_, i_5_, i_6_, i_7_, i_8_);
   }

   private final native void l(long var1, long var3);

   private final native void m(long var1, int var3);

   private final native void VA(long var1, int var3);

   @Override
   final void method3867(int i, int i_10_, int i_11_, int[] is) {
      this.XA(this.nativeid, i, i_10_, i_11_, is);
   }

   private final native void a(long var1, int var3, int var4, int var5);

   @Override
   final void method3861(int i) {
      this.NA(this.nativeid, i);
   }

   @Override
   public final void w(boolean bool) {
      this.AA(this.nativeid, bool);
   }

   @Override
   final void method3862() {
      this.u(this.nativeid);
   }

   private final native void J(long var1, int var3);

   private final native void P(long var1, int var3, int var4, int var5, int var6, int var7, int var8);

   @Override
   final void method3868(int i) {
      this.za(this.nativeid, i);
   }

   private final native void la();

   private final native void b(long var1, int var3, int var4, int var5, int[] var6);

   private final native void AA(long var1, boolean var3);

   @Override
   final void method3853(int i, int i_21_, int i_22_, int[] is) {
      this.b(this.nativeid, i, i_21_, i_22_, is);
   }

   @Override
   final void method3865(int i) {
      this.VA(this.nativeid, i);
   }

   @Override
   final void method3856(int i) {
      this.m(this.nativeid, i);
   }

   @Override
   final void method3857(Class336 class336) {
      this.l(this.nativeid, ((ja)class336).nativeid);
   }

   @Override
   protected final void finalize() {
      if (this.nativeid != 0L) {
         Class164.method1739(0, this);
      }
   }

   @Override
   final void method3859(int i) {
      this.J(this.nativeid, i);
   }

   @Override
   final void method3869(int i, int i_23_, int i_24_, int[] is) {
      this.va(this.nativeid, i, i_23_, i_24_, is);
   }

   @Override
   final void method3863(int i, int i_25_, int i_26_) {
      this.a(this.nativeid, i, i_25_, i_26_);
   }

   private final native void FA(long var1, int var3, int var4, int var5);

   @Override
   final Class336 method3858() {
      ja var_ja_29_ = new ja();
      var_ja_29_.method3857(this);
      return var_ja_29_;
   }

   private final native void za(long var1, int var3);

   @Override
   final void method3860(int i) {
      this.t(this.nativeid, i);
   }

   private final native void w(long var1, int[] var3);

   @Override
   final void method3855(int[] is) {
      this.w(this.nativeid, is);
   }

   private final native void va(long var1, int var3, int var4, int var5, int[] var6);

   private final native void NA(long var1, int var3);

   ja() {
      this.la();
   }

   private final native void t(long var1, int var3);

   private final native void u(long var1);
}
