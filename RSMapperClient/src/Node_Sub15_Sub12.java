public class Node_Sub15_Sub12 extends Node_Sub15 {
   static int anInt9861;
   private String aString9862;
   static int anInt9863;
   static int anInt9864;
   private int anInt9865;
   static int anInt9866;
   static String aString9867;

   static final int getColor(int decimal, int junk) {
      ++anInt9866;
      if (decimal == 16711935) {
         return -1;
      } else {
         if (junk != -1) {
            method2583(null, (byte)-21);
         }

         return Class96.getColorFromInt(-71, decimal);
      }
   }

   static final int method2583(String string, byte b) {
      if (b < 50) {
         return -93;
      } else {
         ++anInt9864;
         return 2 + string.length();
      }
   }

   public static void method2584(byte b) {
      int i = -16 % ((b - -67) / 56);
      aString9867 = null;
   }

   @Override
   final void method2556(ClanChat clanchat, int i) {
      if (i != 16) {
         this.anInt9865 = -104;
      }

      clanchat.method492(this.aString9862, this.anInt9865, true);
      ++anInt9861;
   }

   Node_Sub15_Sub12() {
   }

   @Override
   final void method2554(int i, Buffer buffer) {
      ++anInt9863;
      this.anInt9865 = buffer.readInt();
      if (i != 29147) {
         this.aString9862 = null;
      }

      this.aString9862 = buffer.readString();
   }
}
