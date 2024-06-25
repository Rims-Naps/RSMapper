package jagtheora.theora;

import jagtheora.misc.SimplePeer;

public class TheoraComment extends SimplePeer {
   public TheoraComment() {
      this.init();
      if (this.b()) {
         throw new IllegalStateException();
      }
   }

   private final native void init();

   @Override
   protected final native void clear();
}
