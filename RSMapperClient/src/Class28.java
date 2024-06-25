public class Class28 {
   static int anInt467;
   static int anInt468;
   static int anInt469;

   static final void method331(String text, String username, int i, int junk, String message, String displayName, int type) {
      Node_Sub50.method2966(displayName, username, -1, text, null, false, junk, message, type);
      int i_5_ = 33 % ((i - 36) / 62);
      ++anInt467;
   }

   static final void method332(int i, IComponentDefinitions widget) {
      ++anInt469;
      IComponentDefinitions widget_6_ = Class295.method3468((byte)-105, widget);
      if (i != 0) {
         method331(null, null, 119, -40, null, null, -8);
      }

      int i_7_;
      int i_8_;
      if (widget_6_ != null) {
         i_8_ = widget_6_.width;
         i_7_ = widget_6_.height;
      } else {
         i_7_ = Class205.canvasHeight;
         i_8_ = Class360.canvasWidth;
      }

      Node_Sub39.method2921(false, i_7_, 18815, i_8_, widget);
      Node_Sub38_Sub23.adjustWidgetPositions(widget, i_8_, i_7_, -8525);
   }

   static final void method333(Class37 class37, int i) {
      ++anInt468;
      Class367.aClass37_4540 = class37;
      if (i != -1) {
         method333(null, -56);
      }
   }
}
