public class Node_Sub18 extends Node {
   protected String aString7149;
   static Index index25;
   static OutgoingPacket aClass318_7151 = new OutgoingPacket(1, -1);
   static int anInt7152;
   static int anInt7153;

   public static void method2605(byte b) {
      index25 = null;
      if (b == -59) {
         aClass318_7151 = null;
      }
   }

   public Node_Sub18() {
   }

   static final void method2606(int i) {
      ++anInt7153;
      Class10.aGLSprite172 = null;
      Class346.anInt4278 = -1;
      if (i != 126) {
         method2605((byte)62);
      }
   }

   Node_Sub18(String string) {
      this.aString7149 = string;
   }

   static final int method2607(byte b, int i, int i_0_) {
      ++anInt7152;
      if (b != 31) {
         return -18;
      } else {
         i = (i_0_ & 127) * i >> 7;
         if (i >= 2) {
            if (~i < -127) {
               i = 126;
            }
         } else {
            i = 2;
         }

         return i + (i_0_ & 65408);
      }
   }
}
