package jagdx;

import jaclib.peer.IUnknown;
import jaclib.peer.ti;

public class IDirect3DSwapChain extends IUnknown {
   private ti b;

   public final native int Present(int var1);

   IDirect3DSwapChain(ti var_ti) {
      super(var_ti);
      this.b = var_ti;
   }

   private final native int _GetBackBuffer(int var1, int var2, IDirect3DSurface var3);

   public final IDirect3DSurface a(int i, int i_1_) {
      IDirect3DSurface idirect3dsurface = new IDirect3DSurface(this.b);
      int i_2_ = this._GetBackBuffer(i, i_1_, idirect3dsurface);
      if (lh.a(i_2_, true)) {
         throw new sja(String.valueOf(i_2_));
      } else {
         return idirect3dsurface;
      }
   }
}
