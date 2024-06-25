package jagtheora.theora;

import jagtheora.misc.SimplePeer;
import jagtheora.ogg.OggPacket;

public class SetupInfo extends SimplePeer {
   @Override
   protected final native void clear();

   public final native int decodeHeader(TheoraInfo var1, TheoraComment var2, OggPacket var3);
}
