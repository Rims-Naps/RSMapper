package jagtheora.ogg;

import jagtheora.misc.SimplePeer;

public class OggStreamState extends SimplePeer {
   private final native boolean init(int var1);

   public final native int packetOut();

   public final native boolean isEOS();

   public final native int packetPeek(OggPacket var1);

   @Override
   protected final native void clear();

   public final native boolean reset();

   public final native int packetOut(OggPacket var1);

   public OggStreamState(int i) {
      if (!this.init(i)) {
         throw new IllegalStateException();
      }
   }

   public final native int packetPeek();

   public final native boolean resetSerialNo(int var1);

   public final native boolean pageIn(OggPage var1);
}
