package jagtheora.misc;

public abstract class SimplePeer {
   private long peer;

   static {
      init();
   }

   protected abstract void clear();

   public final boolean b() {
      return this.peer == 0L;
   }

   private final void setPeer(long l) {
      this.peer = l;
   }

   public final void a() {
      if (!this.b()) {
         this.clear();
      }
   }

   private static final native void init();

   @Override
   protected final void finalize() throws Throwable {
      if (!this.b()) {
         this.a();
      }

      super.finalize();
   }
}
