public class Node_Sub30 extends Node {
   static int anInt7351;
   protected int anInt7352;
   static int anInt7353;
   protected int anInt7354;
   protected boolean aBoolean7355;
   protected int anInt7356;
   static int anInt7357;
   protected int anInt7358;
   static int anInt7359;
   static OutgoingPacket aClass318_7360 = new OutgoingPacket(20, 8);
   protected int anInt7361;
   static OutgoingPacketBuffer[] aNode_Sub13Array7362 = new OutgoingPacketBuffer[300];

   static final int method2720(int i, int i_0_, int i_1_) {
      ++anInt7359;
      return ~i_0_ != -2 && ~i_0_ != -4 ? Node_Sub29.anIntArray7345[i & 3] : Node_Sub38_Sub5.anIntArray10131[i & 3];
   }

   static final int method2721(boolean bool, boolean bool_3_) {
      if (bool_3_) {
         aNode_Sub13Array7362 = null;
      }

      ++anInt7353;
      if (Class291.anIntArray3665 == null) {
         return 0;
      } else if (!bool && Node_Sub5_Sub2.aClass49Array9413 != null) {
         return Class291.anIntArray3665.length * 2;
      } else {
         int i = 0;

         for(int i_4_ = 0; i_4_ < Class291.anIntArray3665.length; ++i_4_) {
            int i_5_ = Class291.anIntArray3665[i_4_];
            if (Class294.aClass302_3690.method3510(i_5_, (byte)63)) {
               ++i;
            }

            if (Class188_Sub1.aClass302_6849.method3510(i_5_, (byte)63)) {
               ++i;
            }
         }

         return i;
      }
   }

   static final int method2722(int i, IComponentDefinitions widget, int i_6_) {
      ++anInt7357;
      if (!Client.method113(widget).method2748((byte)-96, i) && widget.anObjectArray4770 == null) {
         return -1;
      } else if (i_6_ != 7113) {
         return 116;
      } else {
         return widget.anIntArray4863 != null && i < widget.anIntArray4863.length ? widget.anIntArray4863[i] : -1;
      }
   }

   static int method2723(int i, int i_7_) {
      return i & i_7_;
   }

   public static void method2724(byte b) {
      aClass318_7360 = null;
      aNode_Sub13Array7362 = null;
   }

   Node_Sub30(int i, int i_8_, int i_9_, int i_10_, int i_11_, boolean bool) {
      this.anInt7354 = i_11_;
      this.anInt7352 = i_8_;
      this.aBoolean7355 = bool;
      this.anInt7356 = i_10_;
      this.anInt7361 = i;
      this.anInt7358 = i_9_;
   }
}
