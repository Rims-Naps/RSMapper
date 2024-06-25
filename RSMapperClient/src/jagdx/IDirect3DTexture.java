package jagdx;

import jaclib.peer.ti;

public class IDirect3DTexture extends IDirect3DBaseTexture {
   IDirect3DTexture(ti var_ti) {
      super(var_ti);
   }

   public final native boolean UnlockRect(int var1);

   public final native int LockRect(int var1, int var2, int var3, int var4, int var5, int var6, PixelBuffer var7);
}
