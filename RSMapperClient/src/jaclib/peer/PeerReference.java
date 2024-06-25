package jaclib.peer;

import java.lang.ref.WeakReference;

abstract class PeerReference extends WeakReference<Object> {
   protected PeerReference b;
   protected PeerReference a;
   private long peer;

   final void setPeer(long l) {
      this.b(0);
      this.peer = l;
   }

   PeerReference(Peer peer, ti var_ti) {
      super(peer, var_ti.b);
      var_ti.a(this, (byte)92);
   }

   final boolean a(int i) {
      if (i != 0) {
         this.b(111);
      }

      return ~this.peer != -1L;
   }

   final long b(int i) {
      if (i != 0) {
         return 30L;
      } else {
         long l;
         if (-1L == ~this.peer) {
            l = 0L;
         } else {
            l = this.releasePeer(this.peer);
            this.peer = 0L;
         }

         return l;
      }
   }

   protected abstract long releasePeer(long var1);
}
