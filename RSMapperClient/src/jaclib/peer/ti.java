package jaclib.peer;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;

public class ti {
   private PeerReference a;
   private PeerReference c;
   protected ReferenceQueue<Object> b = new ReferenceQueue<>();

   private final void a(int i) {
      while (true) {
         Reference<? extends Object> reference = this.b.poll();
         if (reference == null) {
            if (i != 26588) {
               this.b = null;
            }

            return;
         }

         PeerReference peerreference = (PeerReference)reference;
         this.a(peerreference, i ^ 13789);
      }
   }

   final void a(PeerReference peerreference, byte b) {
      peerreference.b = this.a;
      peerreference.a = null;
      if (this.c == null) {
         this.c = peerreference;
      } else {
         this.a.a = peerreference;
      }

      this.a = peerreference;
   }

   private final void a(PeerReference peerreference, int i) {
      peerreference.b(0);
      if (this.c == peerreference) {
         this.c = peerreference.a;
      }

      if (this.a == peerreference) {
         this.a = peerreference.b;
      }

      if (peerreference.a != null) {
         peerreference.a.b = peerreference.b;
      }

      if (peerreference.b != null) {
         peerreference.b.a = peerreference.a;
      }

      if (i != 20993) {
         this.b = null;
      }
   }

   public final void b(int i) {
      this.a(26588);
      if (i != -23417) {
         this.a(null, (byte)32);
      }

      while (this.a != null) {
         this.a(this.a, 20993);
      }

      this.a(26588);
   }

   public final void c(int i) {
      this.a(26588);
      if (i > -85) {
         this.a(null, (byte)119);
      }
   }
}
