public class Class346 {
   static int anInt4273;
   static int anInt4274;
   static int[] anIntArray4275 = new int[128];
   static int anInt4276;
   static double aDouble4277;
   static int anInt4278;
   static int anInt4279;

   static {
      for(int i = 0; anIntArray4275.length > i; ++i) {
         anIntArray4275[i] = -1;
      }

      for(int i = 65; ~i >= -91; ++i) {
         anIntArray4275[i] = i - 65;
      }

      for(int i = 97; ~i >= -123; ++i) {
         anIntArray4275[i] = -71 + i;
      }

      for(int i = 48; i <= 57; ++i) {
         anIntArray4275[i] = 4 + i;
      }

      anIntArray4275[42] = anIntArray4275[43] = 62;
      anIntArray4275[45] = anIntArray4275[47] = 63;
      anInt4278 = -1;
   }

   static final boolean method3973(int i, int i_0_, int i_1_) {
      if (i_0_ != 18518) {
         aDouble4277 = -1.3654076136903865;
      }

      ++anInt4273;
      return Class377.method4127(i_1_, i_0_ ^ -13483, i) || Class153.method1697(95, i_1_, i);
   }

   static final GraphicsToolkit method3974(int i, int i_2_, d var_d, int i_3_, java.awt.Canvas canvas) {
      if (i_2_ != 31206) {
         return null;
      } else {
         ++anInt4279;
         return new PureJavaToolkit(canvas, var_d, i, i_3_);
      }
   }

   static final void method3975(int i, int i_4_, IComponentDefinitions[] widgets) {
      for(int i_5_ = 0; i_5_ < widgets.length; ++i_5_) {
         IComponentDefinitions widget = widgets[i_5_];
         if (widget != null && widget.parentId == i_4_ && !Client.method112(widget)) {
            if (~widget.type == -1) {
               method3975(i, widget.ihash, widgets);
               if (widget.aWidgetArray4793 != null) {
                  method3975(-18690, widget.ihash, widget.aWidgetArray4793);
               }

               Node_Sub2 node_sub2 = (Node_Sub2)OverlayDefinition.aHashTable3630.get(3512, (long)widget.ihash);
               if (node_sub2 != null) {
                  Class290_Sub1.method3424(-23620, node_sub2.interfaceId);
               }
            }

            if (widget.type == 6 && ~widget.animationId != 0) {
               if (widget.anAnimator4755 == null) {
                  widget.anAnimator4755 = new FixedAnimator();
                  widget.anAnimator4755.method249(true, widget.animationId);
               }

               if (widget.anAnimator4755 != null
                  && widget.anAnimator4755.method248(i ^ 18799, Node_Sub9_Sub1.anInt9637)
                  && widget.anAnimator4755.method238(-54)) {
                  widget.anAnimator4755.method235(i + 18690);
               }
            }
         }
      }

      if (i != -18690) {
         method3974(21, -8, null, -125, null);
      }

      ++anInt4276;
   }

   public static void method3976(int i) {
      if (i != 5258) {
         anInt4278 = -7;
      }

      anIntArray4275 = null;
   }

   @Override
   public final String toString() {
      ++anInt4274;
      throw new IllegalStateException();
   }
}
