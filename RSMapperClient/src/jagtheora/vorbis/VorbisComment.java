package jagtheora.vorbis;

import jagtheora.misc.SimplePeer;

public class VorbisComment extends SimplePeer {
   private final native void init();

   public VorbisComment() {
      this.init();
      if (this.b()) {
         throw new IllegalStateException();
      }
   }

   @Override
   protected final native void clear();
}
