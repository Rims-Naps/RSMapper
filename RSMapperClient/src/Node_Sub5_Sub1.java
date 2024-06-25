public class Node_Sub5_Sub1 extends Node_Sub5 {
   protected int lastMouseY;
   protected int lastClickedMouseButton;
   protected long timeSinceMouseClicked;
   protected int lastMouseX;
   protected int mouseNotches;

   @Override
   final int getMouseNotches(byte b) {
      return b != -111 ? -5 : this.mouseNotches;
   }

   @Override
   final int getLastMouseY(int junk) {
      return this.lastMouseY;
   }

   @Override
   final long getTimeSinceMouseClicked(byte junk) {
      return this.timeSinceMouseClicked;
   }

   @Override
   final int getlastClickedMouseButton(boolean junk) {
      return this.lastClickedMouseButton;
   }

   @Override
   final int getLastMouseX(int junk) {
      return this.lastMouseX;
   }

   Node_Sub5_Sub1() {
   }
}
