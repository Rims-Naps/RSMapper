public class Node_Sub50 extends Node {
   static int SCENE_WIDTH_Y;
   protected int anInt7624;
   static int anInt7625;
   protected int anInt7626;
   static int anInt7627;

   static final void method2966(String contextText, String username, int i, String text, String string_2_, boolean bool, int junk, String message, int type) {
      if (!contextText.contains("<euro>") && !text.contains("<euro>")) {
         ++anInt7627;
         Class253 class253 = r_Sub2.aClass253Array11063[99];

         for(int i_6_ = 99; ~i_6_ < -1; --i_6_) {
            r_Sub2.aClass253Array11063[i_6_] = r_Sub2.aClass253Array11063[-1 + i_6_];
         }

         if (class253 == null) {
            class253 = new Class253(type, junk, username, contextText, message, string_2_, i, text);
         } else {
            class253.method3104(i, junk, username, text, type, contextText, false, string_2_, message);
         }

         r_Sub2.aClass253Array11063[0] = class253;
         if (!bool) {
            Class381.anInt4894 = Class345.anInt4270;
            ++Class336_Sub2.anInt8581;
         }
      }
   }

   Node_Sub50(int i, int i_7_) {
      this.anInt7626 = i_7_;
      this.anInt7624 = i;
   }
}
