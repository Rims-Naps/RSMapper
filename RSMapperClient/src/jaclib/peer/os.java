package jaclib.peer;

public class os extends Peer {
   protected os(ti var_ti) {
      this.reference = new NativeHeapPeerReference(this, var_ti);
   }
}
