package jaclib.peer;

abstract class Peer {
   protected PeerReference reference;
   static Class<?> a;

   static {
      init((Class<? extends Object>)(a == null ? (a = a("jaclib.peer.PeerReference")) : a));
   }

   protected long a() {
      return this.reference.b(0);
   }

   public final boolean a(byte b) {
      if (b > -61) {
         this.reference = null;
      }

      return this.reference.a(0);
   }

   private static final native void init(Class<? extends Object> var0);

   protected Peer() {
   }

   static Class<?> a(String string) {
      try {
         return Class.forName(string);
      } catch (ClassNotFoundException var3) {
         throw new NoClassDefFoundError(var3.getMessage());
      }
   }
}
