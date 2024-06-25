public class Node_Sub15_Sub10 extends Node_Sub15 {
   static int anInt9844;
   private int anInt9845;
   private int anInt9846 = -1;
   private int anInt9847;
   private int anInt9848;
   static IncommingPacket aClass192_9849 = new IncommingPacket(16, 3);
   static boolean aBoolean9850 = false;
   static int anInt9851;
   static int anInt9852;
   static Index index35;

   @Override
   final void method2556(ClanChat clanchat, int i) {
      ++anInt9844;
      if (i == 16) {
         clanchat.method486(this.anInt9845, this.anInt9846, this.anInt9847, this.anInt9848, 15883);
      }
   }

   static final int method2578(byte b) {
      ++anInt9851;
      int i = -106 % ((-82 - b) / 34);
      return (int)(1000000000L / Class171.aLong2071);
   }

   public static void method2579(byte b) {
      index35 = null;
      if (b > 27) {
         aClass192_9849 = null;
      }
   }

   @Override
   final void method2554(int i, Buffer buffer) {
      ++anInt9852;
      this.anInt9846 = buffer.readUnsignedShort();
      this.anInt9845 = buffer.readInt();
      this.anInt9848 = buffer.readUnsignedByte();
      this.anInt9847 = buffer.readUnsignedByte();
      if (i != 29147) {
         aBoolean9850 = true;
      }
   }

   Node_Sub15_Sub10() {
   }
}
