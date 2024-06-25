public class Node_Sub5_Sub2 extends Node_Sub5 {
   protected int anInt9408;
   static int anInt9409;
   static int anInt9410;
   protected int anInt9411;
   static int anInt9412 = 0;
   static Class49[] aClass49Array9413 = null;
   protected int anInt9414;
   protected long aLong9415;
   static int anInt9416;
   static int anInt9417;
   static int anInt9418;
   protected int anInt9419;

   @Override
   final int getLastMouseY(int i) {
      ++anInt9409;
      return i != 5 ? -83 : this.anInt9408;
   }

   @Override
   final int getMouseNotches(byte b) {
      ++anInt9418;
      if (b != -111) {
         this.getLastMouseY(77);
      }

      return this.anInt9414;
   }

   @Override
   final int getLastMouseX(int i) {
      if (i != 2) {
         method2274((byte)-63);
      }

      ++anInt9416;
      return this.anInt9411;
   }

   public static void method2274(byte b) {
      if (b > -126) {
         anInt9412 = -102;
      }

      aClass49Array9413 = null;
   }

   @Override
   final long getTimeSinceMouseClicked(byte b) {
      if (b != -69) {
         this.getMouseNotches((byte)45);
      }

      ++anInt9417;
      return this.aLong9415;
   }

   @Override
   final int getlastClickedMouseButton(boolean bool) {
      ++anInt9410;
      return !bool ? -21 : this.anInt9419;
   }

   Node_Sub5_Sub2() {
   }
}
