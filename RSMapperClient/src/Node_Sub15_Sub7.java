public class Node_Sub15_Sub7 extends Node_Sub15 {
   static int anInt9820;
   static float aFloat9821;
   static boolean[][] aBooleanArrayArray9822 = new boolean[][]{
      new boolean[13],
      {false, false, true, true, true, true, true, false, false, false, false, false, true},
      {true, true, true, true, true, true, false, false, false, false, false, false, false},
      {true, true, true, false, false, true, true, true, false, false, false, false, false},
      {true, false, false, false, false, true, true, true, false, false, false, false, false},
      {false, false, true, true, true, true, false, false, false, false, false, false, false},
      {false, true, true, true, true, true, false, false, false, false, false, false, true},
      {false, true, true, true, true, true, true, true, false, false, false, false, true},
      {true, true, false, false, false, false, false, true, false, false, false, false, false},
      {true, true, true, true, true, false, false, false, true, true, false, false, false},
      {true, false, false, false, true, true, true, true, true, true, false, false, false},
      {true, false, true, true, true, true, true, true, false, false, true, true, false},
      {true, true, true, true, true, true, true, true, true, true, true, true, true},
      new boolean[13],
      {true, true, true, true, true, true, true, true, true, true, true, true, true}
   };
   private String aString9823 = null;
   static int anInt9824;
   private int anInt9825 = 0;
   private long aLong9826 = -1L;
   static Class26 aClass26_9827 = new Class26();
   static GLSprite[] aGLSpriteArray9828;

   public static void method2574(int i) {
      if (i != -256) {
         method2574(83);
      }

      aGLSpriteArray9828 = null;
      aBooleanArrayArray9822 = null;
      aClass26_9827 = null;
   }

   @Override
   final void method2556(ClanChat clanchat, int i) {
      ++anInt9820;
      clanchat.method488(0, this.aString9823, this.aLong9826, this.anInt9825);
      if (i != 16) {
         this.aString9823 = null;
      }
   }

   @Override
   final void method2554(int i, Buffer buffer) {
      if (i == 29147) {
         if (~buffer.readUnsignedByte() != -256) {
            --buffer.offset;
            this.aLong9826 = buffer.readLong();
         }

         ++anInt9824;
         this.aString9823 = buffer.readString2();
         this.anInt9825 = buffer.readUnsignedShort();
      }
   }

   Node_Sub15_Sub7() {
   }
}
