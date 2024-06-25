package jaclib.peer;

class NativeHeapPeerReference extends PeerReference {
   @Override
   protected final native long releasePeer(long var1);

   NativeHeapPeerReference(os var_os, ti var_ti) {
      super(var_os, var_ti);
   }
}
