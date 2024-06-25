package jagtheora.theora;

import jagtheora.misc.SimplePeer;

public class GranulePos extends SimplePeer {
   public long position;

   static {
      init();
   }

   private static final native void init();

   @Override
   protected final native void clear();
}
