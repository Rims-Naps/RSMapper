public class Node_Sub15_Sub5 extends Node_Sub15 {
   private int anInt9803 = -1;
   static int anInt9804;
   static Index index21;
   static int anInt9806;
   static int anInt9807;
   static int anInt9808;
   static int anInt9809;
   private byte aByte9810;

   @Override
   final void method2556(ClanChat clanchat, int i) {
      ++anInt9809;
      clanchat.method500(this.aByte9810, (byte)126, this.anInt9803);
      if (i != 16) {
         this.method2554(-120, null);
      }
   }

   static final long method2568(int i) {
      ++anInt9808;
      if (i != -1) {
         method2570(33);
      }

      return WorldItem.aClass234_11017.method2151(0);
   }

   @Override
   final void method2554(int i, Buffer buffer) {
      if (i != 29147) {
         index21 = null;
      }

      this.anInt9803 = buffer.readUnsignedShort();
      ++anInt9804;
      this.aByte9810 = buffer.readByte();
   }

   static final void method2569(byte b) {
      ++anInt9807;

      for(Node_Sub19 node_sub19 = (Node_Sub19)Class89.aClass312_1199.method3613(65280);
         node_sub19 != null;
         node_sub19 = (Node_Sub19)Class89.aClass312_1199.method3620(16776960)
      ) {
         Class287.method3401(node_sub19, false, -1);
      }

      for(Node_Sub19 node_sub19 = (Node_Sub19)Class262_Sub8.aClass312_7755.method3613(b + '\uFEEF');
          node_sub19 != null;
          node_sub19 = (Node_Sub19)Class262_Sub8.aClass312_7755.method3620(16776960)
      ) {
         Class287.method3401(node_sub19, true, -1);
      }

      if (b != 17) {
         index21 = null;
      }
   }

   public static void method2570(int i) {
      index21 = null;
      if (i >= -24) {
         anInt9806 = 108;
      }
   }

   Node_Sub15_Sub5() {
   }
}
