package jaclib.peer;

class IUnknownReference extends PeerReference {
   IUnknownReference(IUnknown iunknown, ti var_ti) {
      super(iunknown, var_ti);
   }

   @Override
   protected final native long releasePeer(long var1);
}
