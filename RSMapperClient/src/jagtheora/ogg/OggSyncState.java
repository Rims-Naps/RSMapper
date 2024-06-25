package jagtheora.ogg;

import jagtheora.misc.SimplePeer;

public class OggSyncState extends SimplePeer {
   public OggSyncState() {
      this.init();
      if (this.b()) {
         throw new IllegalStateException();
      }
   }

   @Override
   protected final native void clear();

   private final native void init();

   public final native long pageSeek(OggPage var1);

   public final native int pageOut(OggPage var1);

   public final native boolean write(byte[] var1, int var2);

   public final native boolean reset();
}
