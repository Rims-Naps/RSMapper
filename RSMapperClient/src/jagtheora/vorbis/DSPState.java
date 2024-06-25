package jagtheora.vorbis;

import jagtheora.misc.SimplePeer;

public class DSPState extends SimplePeer {
   public final native float[][] pcmOut(int var1);

   private final native void init(VorbisInfo var1);

   public final native double granuleTime();

   public DSPState(VorbisInfo vorbisinfo) {
      this.init(vorbisinfo);
      if (this.b()) {
         throw new IllegalStateException();
      }
   }

   @Override
   protected final native void clear();

   public final native void blockIn(VorbisBlock var1);

   public final native void read(int var1);
}
