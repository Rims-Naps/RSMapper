package jaclib.memory.heap;

public class NativeHeap {
   private int a;
   protected long peer;
   private boolean b;

   private final native void allocateHeap(int var1);

   @Override
   protected final synchronized void finalize() throws Throwable {
      super.finalize();
      this.b();
   }

   final synchronized native void deallocateBuffer(int var1);

   final synchronized native int allocateBuffer(int var1, boolean var2);

   private final native void deallocateHeap();

   public final NativeHeapBuffer a(int i, boolean bool) {
      if (!this.b) {
         throw new IllegalStateException();
      } else {
         return new NativeHeapBuffer(this, this.allocateBuffer(i, bool), i);
      }
   }

   final synchronized native void put(int var1, byte[] var2, int var3, int var4, int var5);

   final synchronized native void get(int var1, byte[] var2, int var3, int var4, int var5);

   final synchronized boolean a() {
      return this.b;
   }

   final synchronized native long getBufferAddress(int var1);

   public NativeHeap(int i) {
      this.a = i;
      this.allocateHeap(this.a);
      this.b = true;
   }

   public final synchronized void b() {
      if (this.b) {
         this.deallocateHeap();
      }

      this.b = false;
   }
}
