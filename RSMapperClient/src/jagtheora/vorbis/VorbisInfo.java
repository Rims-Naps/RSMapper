package jagtheora.vorbis;

import jagtheora.misc.SimplePeer;
import jagtheora.ogg.OggPacket;

public class VorbisInfo extends SimplePeer {
   public int rate;
   public int channels;

   static {
      initFields();
   }

   private static final native void initFields();

   @Override
   protected final native void clear();

   public final native int headerIn(VorbisComment var1, OggPacket var2);

   private final native void init();

   public VorbisInfo() {
      this.init();
      if (this.b()) {
         throw new IllegalStateException();
      }
   }
}
