public class j extends GLSprite implements Interface3 {
   protected long nativeid;

   @Override
   final void method1188(float f, float f_0_, float f_1_, float f_2_, float f_3_, float f_4_, int i, aa var_aa, int i_5_, int i_6_) {
      this.UA(this.nativeid, f, f_0_, f_1_, f_2_, f_3_, f_4_, i, ((na)var_aa).nativeid, i_5_, i_6_);
   }

   @Override
   final void method1184(int i, int i_7_, int i_8_, int i_9_, int i_10_, int i_11_, int i_12_, int i_13_) {
      this.RA(this.nativeid, i, i_7_, i_8_, i_9_, i_10_, i_11_, i_12_, i_13_);
   }

   @Override
   final int method1176() {
      return this.I(this.nativeid);
   }

   private final native void A(long var1, int var3, int var4, int var5, int var6);

   @Override
   public final void w(boolean bool) {
      this.R(this.nativeid, bool);
   }

   private final native void h(oa var1, int var2, int var3, int var4, int var5, boolean var6);

   private final native void V(long var1, int var3, int var4, long var5, int var7, int var8);

   @Override
   final void method1183(int i, int i_24_, int i_25_, int i_26_, int i_27_, int i_28_, int i_29_) {
      this.P(this.nativeid, i, i_24_, i_25_, i_26_, i_27_, i_28_, i_29_);
   }

   @Override
   final void method1187(int[] is) {
      this.CA(this.nativeid, is);
   }

   private final native void RA(long var1, int var3, int var4, int var5, int var6, int var7, int var8, int var9, int var10);

   private final native void b(long var1, float var3, float var4, float var5, float var6, float var7, float var8, int var9, int var10, int var11, int var12);

   private final native int JA(long var1);

   private final native void ma(oa var1, int[] var2, byte[] var3, byte[] var4, int var5, int var6, int var7, int var8);

   private final native void N(long var1, int var3, int var4, int var5);

   private final native int M(long var1);

   @Override
   final int method1193() {
      return this.M(this.nativeid);
   }

   @Override
   protected final void finalize() {
      if (this.nativeid != 0L) {
         Class164.method1739(0, this);
      }
   }

   @Override
   final void method1194(float f, float f_51_, float f_52_, float f_53_, float f_54_, float f_55_, int i, int i_56_, int i_57_, int i_58_) {
      this.b(this.nativeid, f, f_51_, f_52_, f_53_, f_54_, f_55_, i, i_56_, i_57_, i_58_);
   }

   private final native void ua(oa var1, int[] var2, int var3, int var4, int var5, int var6, boolean var7);

   private final native int wa(long var1);

   private final native void P(long var1, int var3, int var4, int var5, int var6, int var7, int var8, int var9);

   private final native void R(long var1, boolean var3);

   @Override
   final int method1197() {
      return this.wa(this.nativeid);
   }

   @Override
   final void method1191(int i, int i_68_, int i_69_, int i_70_, int i_71_) {
      this.W(this.nativeid, i, i_68_, i_69_, i_70_, i_71_);
   }

   @Override
   final void method1178(int i, int i_72_, int i_73_, int i_74_) {
      this.A(this.nativeid, i, i_72_, i_73_, i_74_);
   }

   private final native void CA(long var1, int[] var3);

   @Override
   final void method1195(int i, int i_75_, int i_76_, int i_77_, int i_78_, int i_79_) {
      this.YA(this.nativeid, i, i_75_, i_76_, i_77_, i_78_, i_79_);
   }

   private final native void EA(oa var1, int var2, int var3);

   private final native void UA(long var1, float var3, float var4, float var5, float var6, float var7, float var8, int var9, long var10, int var12, int var13);

   private final native void YA(long var1, int var3, int var4, int var5, int var6, int var7, int var8);

   @Override
   final int method1186() {
      return this.JA(this.nativeid);
   }

   @Override
   final void method1190(int i, int i_94_, int i_95_) {
      this.N(this.nativeid, i, i_94_, i_95_);
   }

   @Override
   final void method1189(int i, int i_96_, aa var_aa, int i_97_, int i_98_) {
      this.V(this.nativeid, i, i_96_, ((na)var_aa).nativeid, i_97_, i_98_);
   }

   j(oa var_oa, int i, int i_99_) {
      this.EA(var_oa, i, i_99_);
   }

   private final native int I(long var1);

   private final native void W(long var1, int var3, int var4, int var5, int var6, int var7);

   j(oa var_oa, int[] is, int i, int i_104_, int i_105_, int i_106_, boolean bool) {
      this.ua(var_oa, is, i, i_104_, i_105_, i_106_, bool);
   }

   j(oa var_oa, int[] is, byte[] bs, byte[] bs_107_, int i, int i_108_, int i_109_, int i_110_) {
      this.ma(var_oa, is, bs, bs_107_, i, i_108_, i_109_, i_110_);
   }

   j(oa var_oa, int i, int i_111_, int i_112_, int i_113_, boolean bool) {
      this.h(var_oa, i, i_111_, i_112_, i_113_, bool);
   }
}
