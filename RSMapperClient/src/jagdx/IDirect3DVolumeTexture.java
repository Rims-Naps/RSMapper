package jagdx;

import jaclib.peer.ti;

public class IDirect3DVolumeTexture extends IDirect3DBaseTexture {
   public final native int LockBox(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, PixelBuffer var9);

   IDirect3DVolumeTexture(ti var_ti) {
      super(var_ti);
   }

   public final native boolean UnlockBox(int var1);
}
