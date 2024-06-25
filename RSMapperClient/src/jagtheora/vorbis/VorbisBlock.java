package jagtheora.vorbis;

import jagtheora.misc.SimplePeer;
import jagtheora.ogg.OggPacket;

public class VorbisBlock extends SimplePeer {
   public VorbisBlock(DSPState dspstate) {
      this.init(dspstate);
      if (this.b()) {
         throw new IllegalStateException();
      }
   }

   public final native int synthesis(OggPacket var1);

   private final native void init(DSPState var1);

   @Override
   protected final native void clear();
}
