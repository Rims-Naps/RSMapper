package jagdx;

import jaclib.peer.os;
import jaclib.peer.ti;

public class PixelBuffer extends os implements jaclib.memory.Buffer {
   public final void b(int[] is, int i, int i_0_, int i_1_) {
      if (!(~is.length > ~(i - -i_1_) | -1 < ~i | is == null | i_0_ < 0) && this.getSize() >= i_1_ * 4 + i_0_) {
         this.puti(is, i, i_0_, i_1_);
      } else {
         throw new sja();
      }
   }

   public PixelBuffer(ti var_ti) {
      super(var_ti);
      this.init();
   }

   private final native void getub(byte[] var1, int var2, int var3, int var4);

   public final native int getSlicePitch();

   private final native void geti(int[] var1, int var2, int var3, int var4);

   public final void a(int[] is, int i, int i_6_, int i_7_) {
      if (!(~i > -1 | is == null | is.length < i_7_ + i | i_6_ < 0) && this.getSize() >= 4 * i_7_ + i_6_) {
         this.geti(is, i, i_6_, i_7_);
      } else {
         throw new sja();
      }
   }

   private final native void putub(byte[] var1, int var2, int var3, int var4);

   @Override
   public final long getAddress() {
      return 0L;
   }

   private final native void puti(int[] var1, int var2, int var3, int var4);

   @Override
   public final void a(byte[] bs, int i, int i_12_, int i_13_) {
      if (!(~i_12_ > -1 | i_13_ + i > bs.length | bs == null | ~i > -1) && ~(i_13_ + i_12_) >= ~this.getSize()) {
         this.putub(bs, i, i_12_, i_13_);
      } else {
         throw new sja();
      }
   }

   public final native int getRowPitch();

   private final native void init();

   @Override
   public final native int getSize();
}
