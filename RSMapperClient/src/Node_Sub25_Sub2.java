import jagtheora.ogg.OggPacket;
import jagtheora.ogg.OggStreamState;

public class Node_Sub25_Sub2 extends Node_Sub25 {
   static int anInt9954;
   static int anInt9955;
   static int anInt9956;
   static Class124 aClass124_9957 = new Class124(14);
   static IncommingPacket sendClanChannel = new IncommingPacket(7, -2);
   static Class54[] aClass54Array9959;

   @Override
   final void method2656(int i) {
      ++anInt9956;
      if (i != 100) {
         this.method2656(-92);
      }
   }

   @Override
   final void method2654(int i, OggPacket oggpacket) {
      ++anInt9954;
   }

   Node_Sub25_Sub2(OggStreamState oggstreamstate) {
      super(oggstreamstate);
   }

   static final boolean method2665(int i, byte b) {
      ++anInt9955;
      if (b != -41) {
         return false;
      } else {
         return ~i == -8 || ~i == -10;
      }
   }

   public static void method2666(int i) {
      aClass54Array9959 = null;
      if (i != -2) {
         sendClanChannel = null;
      }

      aClass124_9957 = null;
      sendClanChannel = null;
   }
}
