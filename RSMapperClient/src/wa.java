public class wa implements Interface6 {
   protected j aJ5050;
   private long aLong5051 = 0L;
   protected xa aXa5052;

   private final native void Z(long var1, long var3, long var5, int var7, int var8, int var9, int var10, int var11, int var12, boolean var13, boolean var14);

   @Override
   public final void method19(int i, int i_8_, int i_9_, int i_10_, int i_11_, int i_12_, boolean bool, boolean bool_13_) {
      this.Z(this.aLong5051, this.aJ5050.nativeid, this.aXa5052.nativeid, i, i_8_, i_9_, i_10_, i_11_, i_12_, bool, bool_13_);
   }

   private final native void X(long var1, long var3, long var5, int var7, int var8, int var9, int var10, int var11, int var12, boolean var13, boolean var14);

   @Override
   public final void method18(int i, int i_22_, int i_23_, int i_24_, int i_25_, int i_26_, boolean bool, boolean bool_27_) {
      this.X(this.aLong5051, this.aJ5050.nativeid, this.aXa5052.nativeid, i, i_22_, i_23_, i_24_, i_25_, i_26_, bool, bool_27_);
   }

   wa(oa var_oa, j var_j, xa var_xa) {
      this.aLong5051 = var_oa.nativeid;
      this.aJ5050 = var_j;
      this.aXa5052 = var_xa;
   }
}
