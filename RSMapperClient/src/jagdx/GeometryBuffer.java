package jagdx;

import jaclib.peer.os;
import jaclib.peer.ti;

public class GeometryBuffer extends os implements jaclib.memory.Buffer {
   private final native void putub(byte[] var1, int var2, int var3, int var4);

   private final native void getub(byte[] var1, int var2, int var3, int var4);

   @Override
   public final void a(byte[] bs, int i, int i_4_, int i_5_) {
      if (!(bs.length < i + i_5_ | i < 0 | bs == null | -1 < ~i_4_) && ~(i_5_ + i_4_) >= ~this.getSize()) {
         this.putub(bs, i, i_4_, i_5_);
      } else {
         throw new sja();
      }
   }

   public GeometryBuffer(ti var_ti) {
      super(var_ti);
      this.init();
   }

   @Override
   public final native long getAddress();

   private final native void init();

   @Override
   public final native int getSize();
}
