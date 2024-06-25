package jagdx;

import jaclib.memory.Source;
import jaclib.peer.IUnknown;
import jaclib.peer.ti;

public class IDirect3DVertexBuffer extends IUnknown {
   protected int b;

   public final boolean a(Source source, int i, int i_0_, int i_1_, int i_2_) {
      if (source == null || i < 0 || ~i_1_ < ~(i - -source.getSize())) {
         throw new sja("");
      } else if (i_0_ >= 0 && this.b + i_0_ >= i_1_) {
         return this._Update((long)i + source.getAddress(), i_0_, i_1_, i_2_);
      } else {
         throw new sja("");
      }
   }

   IDirect3DVertexBuffer(ti var_ti) {
      super(var_ti);
   }

   private final native boolean _Update(long var1, int var3, int var4, int var5);

   @Override
   protected final long a() {
      this.b = 0;
      return super.a();
   }

   public final native int Lock(int var1, int var2, int var3, GeometryBuffer var4);

   public final native int Unlock();
}
