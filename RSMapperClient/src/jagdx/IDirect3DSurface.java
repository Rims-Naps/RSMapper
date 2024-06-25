package jagdx;

import jaclib.peer.IUnknown;
import jaclib.peer.ti;

public class IDirect3DSurface extends IUnknown {
   IDirect3DSurface(ti var_ti) {
      super(var_ti);
   }

   public final native int LockRect(int var1, int var2, int var3, int var4, int var5, PixelBuffer var6);

   public final native boolean UnlockRect();
}
