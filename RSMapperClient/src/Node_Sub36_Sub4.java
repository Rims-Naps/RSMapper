public class Node_Sub36_Sub4 extends Node_Sub36 {
   static int anInt10063;
   private int anInt10064 = -1;
   static Class61 aClass61_10065 = new Class61(260);
   static int anInt10066;
   private int anInt10067;
   static int anInt10068;
   static int anInt10069;
   private String aString10070;
   private byte aByte10071;
   static float aFloat10072;
   static int anInt10073 = -2;

   static final int method2764(int i, boolean bool) {
      ++anInt10063;
      if (i != -1) {
         method2766(70, 71);
      }

      int i_0_ = Class320_Sub20.anInt8397;
      if (~i_0_ != -1) {
         if (~i_0_ != -2) {
            return i_0_ == 2 ? 0 : 0;
         } else {
            return Class166.anInt5100;
         }
      } else {
         return bool ? 0 : Class166.anInt5100;
      }
   }

   @Override
   final void method2756(Buffer buffer, int i) {
      this.anInt10064 = buffer.readUnsignedShort();
      ++anInt10069;
      this.aByte10071 = buffer.readByte();
      this.anInt10067 = buffer.readUnsignedShort();
      buffer.readLong();
      this.aString10070 = buffer.readString();
   }

   @Override
   final void method2751(Node_Sub43 node_sub43, int i) {
      ++anInt10066;
      Class24 class24 = node_sub43.aClass24Array7533[this.anInt10064];
      class24.anInt441 = this.anInt10067;
      if (i != 0) {
         this.anInt10064 = 19;
      }

      class24.aByte438 = this.aByte10071;
      class24.aString437 = this.aString10070;
   }

   public static void method2765(boolean bool) {
      aClass61_10065 = null;
      if (!bool) {
         aClass61_10065 = null;
      }
   }

   static final void method2766(int i, int i_1_) {
      ++anInt10068;
      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 10, (long)i);
      cachenode_sub2.method2291((byte)121);
      int i_2_ = -84 / ((48 - i_1_) / 54);
   }

   Node_Sub36_Sub4() {
   }
}
