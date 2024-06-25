package jagdx;

import jaclib.peer.os;
import jaclib.peer.ti;

public class VertexElementCollection extends os {
   public final native void addElement(int var1, int var2, int var3, int var4, int var5, int var6);

   private final native void init();

   public VertexElementCollection(ti var_ti) {
      super(var_ti);
      this.init();
   }

   public final native void reset();

   public final native void finish();
}
