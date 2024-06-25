package jagdx;

import jaclib.peer.ti;

public class IDirect3DCubeTexture extends IDirect3DBaseTexture {
   public final native boolean UnlockRect(int var1, int var2);

   IDirect3DCubeTexture(ti var_ti) {
      super(var_ti);
   }

   public final native int LockRect(int var1, int var2, int var3, int var4, int var5, int var6, int var7, PixelBuffer var8);
}
