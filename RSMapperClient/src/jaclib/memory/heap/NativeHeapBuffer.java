package jaclib.memory.heap;

import jaclib.memory.Source;

public class NativeHeapBuffer implements jaclib.memory.Buffer, Source {
   private int c;
   private NativeHeap a;
   public int b;
   private boolean d = true;

   @Override
   public final int getSize() {
      return this.b;
   }

   @Override
   public final synchronized void a(byte[] bs, int i, int i_0_, int i_1_) {
      if (~i_0_ > -1 | bs == null | !this.a() | ~i > -1 | ~(i + i_1_) < ~bs.length | ~this.b > ~(i_0_ + i_1_)) {
         throw new RuntimeException();
      } else {
         this.a.put(this.c, bs, i, i_0_, i_1_);
      }
   }

   @Override
   public final long getAddress() {
      return this.a.getBufferAddress(this.c);
   }

   private final synchronized boolean a() {
      return this.a.a() && this.d;
   }

   private final synchronized void b() {
      if (this.a()) {
         this.a.deallocateBuffer(this.c);
      }

      this.d = false;
   }

   @Override
   protected final synchronized void finalize() throws Throwable {
      super.finalize();
      this.b();
   }

   NativeHeapBuffer(NativeHeap nativeheap, int i, int i_2_) {
      this.b = i_2_;
      this.a = nativeheap;
      this.c = i;
   }
}
