public class Node_Sub34 extends Node {
   static int anInt7408;
   static int anInt7409;
   static Class115 aClass115_7410 = Class262_Sub22.method3209(true);
   protected int[] anIntArray7411;

   public static void method2740(byte b) {
      aClass115_7410 = null;
      if (b > -92) {
         aClass115_7410 = null;
      }
   }

   static final void method2741(boolean bool) {
      ++anInt7408;
      if (~Class320_Sub15.WINDOWS_PANE_ID != 0) {
         int i = Class106.aClass93_1356.getLastMousePosX();
         int i_0_ = Class106.aClass93_1356.getLastMousePosY(!bool);
         Node_Sub5 node_sub5 = (Node_Sub5)GraphicsToolkit.aClass312_1545.method3613(65280);
         if (node_sub5 != null) {
            i = node_sub5.getLastMouseX(2);
            i_0_ = node_sub5.getLastMouseY(5);
         }

         if (!bool) {
            int i_1_ = 0;
            int i_2_ = 0;
            if (Class71.aBoolean967) {
               i_1_ = Class67.method733(-106);
               i_2_ = Class226.method2112(256);
            }

            BufferedConnection.method422(
               i_2_ - -Class205.canvasHeight,
               i_2_,
               -1,
               i_2_,
               i_0_,
               i_0_ + i_2_,
               i_1_ + Class360.canvasWidth,
               i_1_,
               Class320_Sub15.WINDOWS_PANE_ID,
               i,
               i_1_ + i,
               i_1_
            );
            if (Class66_Sub1.aWidget8983 != null) {
               Node_Sub15_Sub11.handleWorldmapRightClickOptions((byte)-114, i + i_1_, i_0_ - -i_2_);
            }
         }
      }
   }

   static final String method2742(IComponentDefinitions widget, int i, int i_3_) {
      ++anInt7409;
      if (!Client.method113(widget).method2748((byte)-57, i) && widget.anObjectArray4770 == null) {
         return null;
      } else {
         if (i_3_ != -27187) {
            aClass115_7410 = null;
         }

         if (widget.rightClickActions != null
            && ~i > ~widget.rightClickActions.length
            && widget.rightClickActions[i] != null
            && ~widget.rightClickActions[i].trim().length() != -1) {
            return widget.rightClickActions[i];
         } else {
            return Class54.aBoolean817 ? "Hidden-" + i : null;
         }
      }
   }

   Node_Sub34(int i) {
      this.anIntArray7411 = new int[i];
   }
}
