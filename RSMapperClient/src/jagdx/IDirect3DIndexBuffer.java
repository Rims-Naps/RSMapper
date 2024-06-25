package jagdx;

import jaclib.peer.IUnknown;
import jaclib.peer.ti;

public class IDirect3DIndexBuffer extends IUnknown {
   @Override
   protected final long a() {
      return super.a();
   }

   private final native boolean _Update(long var1, int var3, int var4);

   public final native int Lock(int var1, int var2, int var3, GeometryBuffer var4);

   public final native int Unlock();

   IDirect3DIndexBuffer(ti var_ti) {
      super(var_ti);
   }
}
