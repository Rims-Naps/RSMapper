abstract class Node_Sub9 extends Node {
   protected Node_Sub9 aNode_Sub9_7072;
   protected int anInt7073;
   volatile boolean aBoolean7074 = true;
   protected Node_Sub45 aNode_Sub45_7075;

   abstract void method2426(int var1);

   abstract void method2427(int[] var1, int var2, int var3);

   abstract int method2428();

   abstract Node_Sub9 method2429();

   final void method2430(int[] is, int i, int i_1_) {
      if (this.aBoolean7074) {
         this.method2427(is, i, i_1_);
      } else {
         this.method2426(i_1_);
      }
   }

   abstract Node_Sub9 method2431();

   int method2432() {
      return 255;
   }

   public Node_Sub9() {
   }
}
