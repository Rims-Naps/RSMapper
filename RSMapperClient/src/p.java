import java.awt.Dimension;
import java.awt.Rectangle;

public class p extends Node implements Interface3 {
   private static long aLong5014;
   protected int anInt5015;
   protected int anInt5016;
   protected long nativeid;
   private static boolean aBoolean5017 = false;
   protected java.awt.Canvas aCanvas5018;

   final void method2767(int i, int i_0_) {
      try {
         synchronized(this.aCanvas5018.getTreeLock()) {
            Dimension dimension = this.aCanvas5018.getSize();
            this.H(i, i_0_, dimension.width, dimension.height);
            aBoolean5017 = false;
         }
      } catch (Exception var6) {
         this.method2769(var6);
      }
   }

   private final native void K(int var1, int var2, int var3, int var4, int var5, int var6);

   private final native void H(int var1, int var2, int var3, int var4);

   final void method2768(java.awt.Canvas canvas, int i, int i_9_) {
      this.anInt5015 = i;
      this.anInt5016 = i_9_;
      this.oa(canvas, i, i_9_);
   }

   private final void method2769(Exception exception) {
      if (!aBoolean5017) {
         aLong5014 = Class313.method3650(false);
         aBoolean5017 = true;
      } else {
         if (Class313.method3650(false) - aLong5014 >= 30000L) {
            throw new RuntimeException(exception.getMessage());
         }

         this.aCanvas5018.repaint();
      }
   }

   final void method2770(Rectangle[] rectangles, int i, int i_10_, int i_11_) {
      try {
         synchronized(this.aCanvas5018.getTreeLock()) {
            for(int i_12_ = 0; i_12_ < i; ++i_12_) {
               Rectangle rectangle = rectangles[i_12_];
               if (rectangle.width > 0 && rectangle.height > 0) {
                  this.K(rectangle.x, rectangle.y, rectangle.width, rectangle.height, i_10_, i_11_);
               }
            }

            aBoolean5017 = false;
         }
      } catch (Exception var9) {
         this.method2769(var9);
      }
   }

   @Override
   public final native void w(boolean var1);

   private final native void sa(oa var1, java.awt.Canvas var2, int var3, int var4);

   @Override
   protected final void finalize() {
      if (this.nativeid != 0L) {
         Class164.method1739(0, this);
      }
   }

   final void method2771() {
      this.w(true);
      this.nativeid = 0L;
      this.aCanvas5018 = null;
   }

   p(oa var_oa, java.awt.Canvas canvas, int i, int i_14_) {
      this.aCanvas5018 = canvas;
      this.anInt5015 = i;
      this.anInt5016 = i_14_;
      this.sa(var_oa, this.aCanvas5018, i, i_14_);
   }

   private final native void oa(java.awt.Canvas var1, int var2, int var3);
}
