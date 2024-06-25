package jaclib.memory;

public class NativeBuffer implements jaclib.memory.Buffer, Source {
   private int a = -1;
   private long b;

   @Override
   public void a(byte[] bs, int i, int i_0_, int i_1_) {
      if (~i_0_ > -1 | bs == null | this.b == 0L | ~i > -1 | ~bs.length > ~(i + i_1_) | i_0_ - -i_1_ > this.a) {
         throw new RuntimeException();
      } else {
         this.put(this.b, bs, i, i_0_, i_1_);
      }
   }

   protected final void a(long l, int i) {
      this.b = l;
      this.a = i;
   }

   @Override
   public final long getAddress() {
      return this.b;
   }

   private final native void put(long var1, byte[] var3, int var4, int var5, int var6);

   private final native void get(long var1, byte[] var3, int var4, int var5, int var6);

   @Override
   public final int getSize() {
      return this.a;
   }
}
