package jagtheora.theora;

import jagtheora.misc.SimplePeer;

public class Frame extends SimplePeer {
   public int a;
   public int b;
   public int[] pixels;

   static {
      init();
   }

   public Frame(int i, int i_0_) {
      this.b = i;
      this.a = i_0_;
      this.pixels = new int[this.a * this.b];
   }

   private static final native void init();

   @Override
   protected final native void clear();
}
