package jagtheora.theora;

import jagtheora.misc.SimplePeer;
import jagtheora.ogg.OggPacket;

public class DecoderContext extends SimplePeer {
   public final native double granuleTime(GranulePos var1);

   public final native int decodePacketIn(OggPacket var1, GranulePos var2);

   public final native int getMaxPostProcessingLevel();

   public final native long granuleFrame(GranulePos var1);

   public final native int setPostProcessingLevel(int var1);

   public final native int setGranulePosition(long var1);

   public final native int decodeFrame(Frame var1);

   public DecoderContext(TheoraInfo theorainfo, SetupInfo setupinfo) {
      this.init(theorainfo, setupinfo);
      if (this.b()) {
         throw new IllegalArgumentException("");
      }
   }

   private final native void init(TheoraInfo var1, SetupInfo var2);

   @Override
   protected final native void clear();
}
