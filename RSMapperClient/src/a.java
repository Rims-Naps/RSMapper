public class a implements Interface3 {
   private oa anOa4983;
   protected long nativeid;
   protected Runnable aRunnable4984;
   private i[] anIArray4985 = new i[7];
   private i[] anIArray4986 = new i[7];

   private final native void na(long var1, GraphicsToolkit var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10);

   private final native void O(long var1, GraphicsToolkit var3, int[] var4, int[] var5, int[] var6, short[] var7, int var8);

   private final native void Z(long var1, long var3, int var5, int var6, int var7);

   final void method142() {
      this.aRunnable4984 = Thread.currentThread();
      this.method148();
   }

   private final native void f(long var1, long var3, long var5, int[] var7, int var8, int var9);

   @Override
   public final void w(boolean bool) {
      this.E(this.nativeid, bool);
   }

   final void method143(Plane plane, int i, int i_14_) {
      this.H(this.nativeid, ((t)plane).nativeid, i, i_14_);
   }

   private final native void r(long var1, long var3, long var5, int var7, int var8, int var9, boolean var10);

   private final native void ta(long var1, long var3, int var5, int var6, int var7, int var8, int var9, int var10, int var11, boolean[][] var12);

   final DrawableModel method144(i var_i, byte b, int i, boolean bool) {
      boolean bool_26_ = false;
      i var_i_27_;
      i var_i_28_;
      if (b > 0 && b <= 7) {
         var_i_28_ = this.anIArray4985[b - 1];
         var_i_27_ = this.anIArray4986[b - 1];
         bool_26_ = true;
      } else {
         var_i_27_ = var_i_28_ = new i(this.anOa4983);
      }

      var_i.ZA(var_i_27_, var_i_28_, i, bool_26_, bool);
      var_i_27_.aClass300Array4987 = var_i.aClass300Array4987;
      var_i_27_.aClass218Array4990 = var_i.aClass218Array4990;
      return var_i_27_;
   }

   final void method145(GraphicsToolkit graphicstoolkit, int[] is, int[] is_29_, int[] is_30_, short[] ses, int i) {
      this.O(this.nativeid, graphicstoolkit, is, is_29_, is_30_, ses, i);
   }

   final boolean method146(DrawableModel drawablemodel, int i, int i_31_, Class336 class336, boolean bool, int i_32_) {
      return this.n(this.nativeid, ((i)drawablemodel).nativeid, i, i_31_, ((ja)class336).nativeid, bool, i_32_);
   }

   private final native void H(long var1, long var3, int var5, int var6);

   @Override
   protected final void finalize() {
      if (this.nativeid != 0L) {
         Class164.method1739(0, this);
      }
   }

   private final native void UA(long var1, long var3, long var5, int[] var7, int var8);

   final void method147(Plane plane, int i, int i_37_, int i_38_) {
      this.Z(this.nativeid, ((t)plane).nativeid, i, i_37_, i_38_);
   }

   private final void method148() {
      this.M(this.nativeid);
   }

   final void method149(DrawableModel drawablemodel, Class336 class336, int[] is, int i) {
      this.UA(this.nativeid, ((i)drawablemodel).nativeid, ((ja)class336).nativeid, is, i);
   }

   final void method150(DrawableModel drawablemodel, Class336 class336, int[] is, int i, int i_39_) {
      this.f(this.nativeid, ((i)drawablemodel).nativeid, ((ja)class336).nativeid, is, i, i_39_);
   }

   final void method151(DrawableModel drawablemodel, DrawableModel drawablemodel_40_, int i, int i_41_, int i_42_, boolean bool) {
      this.r(this.nativeid, ((i)drawablemodel).nativeid, ((i)drawablemodel_40_).nativeid, i, i_41_, i_42_, bool);
   }

   private final native boolean n(long var1, long var3, int var5, int var6, long var7, boolean var9, int var10);

   private final native void E(long var1, boolean var3);

   final boolean method152(DrawableModel drawablemodel, int i, int i_47_, Class336 class336, boolean bool) {
      return this.R(this.nativeid, ((i)drawablemodel).nativeid, i, i_47_, ((ja)class336).nativeid, bool);
   }

   private final void method153() {
      this.W(this.nativeid);
   }

   private final native void e(long var1, long var3, int[] var5, long var6);

   private final native void HA(long var1, GraphicsToolkit var3, int var4, int var5);

   a(oa var_oa, int i, int i_51_) {
      this.anOa4983 = var_oa;

      for(int i_52_ = 0; i_52_ < 7; ++i_52_) {
         this.anIArray4986[i_52_] = new i(this.anOa4983);
         this.anIArray4985[i_52_] = new i(this.anOa4983);
      }

      this.HA(this.nativeid, var_oa, i, i_51_);
   }

   final void method154(Plane plane, int i, int i_53_, int i_54_, int i_55_, int i_56_, int i_57_, int i_58_, boolean[][] bools) {
      this.ta(this.nativeid, ((t)plane).nativeid, i, i_53_, i_54_, i_55_, i_56_, i_57_, i_58_, bools);
   }

   private final native boolean R(long var1, long var3, int var5, int var6, long var7, boolean var9);

   private final native void W(long var1);

   private final native void M(long var1);

   final void method155() {
      this.aRunnable4984 = null;
      this.method153();
   }

   final void method156(DrawableModel drawablemodel, int[] is, Class336 class336) {
      this.e(this.nativeid, ((i)drawablemodel).nativeid, is, ((ja)class336).nativeid);
   }

   final void method157(GraphicsToolkit graphicstoolkit, int i, int i_62_, int i_63_, int i_64_, int i_65_, int i_66_, int i_67_) {
      this.na(this.nativeid, graphicstoolkit, i, i_62_, i_63_, i_64_, i_65_, i_66_, i_67_);
   }
}
