import java.awt.Graphics;

abstract class GraphicsBuffer extends Node {
   static int anInt7141;
   protected int anInt7142;
   static int anInt7143;
   static int anInt7144;
   protected int[] anIntArray7145;
   protected int anInt7146;

   abstract void method2595(boolean var1, int var2, int var3, java.awt.Canvas var4);

   static final boolean method2596(int i, int i_1_, int i_2_) {
      ++anInt7143;
      return i != -1 ? true : Class144_Sub2.method1634(i_2_, i_1_, false) & Node_Sub9_Sub4.method2522(~i, i_1_, i_2_);
   }

   abstract void method2597(int var1, int var2, int var3, boolean var4, Graphics var5, int var6, int var7, int var8);

   static final boolean method2598(int i, int i_8_, int i_9_) {
      if (i != 2048) {
         return true;
      } else {
         ++anInt7141;
         return ~(i_8_ & 2048) != -1 && (i_9_ & 55) != 0;
      }
   }

   public GraphicsBuffer() {
   }
}
