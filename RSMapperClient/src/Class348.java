public class Class348 {
   private int anInt4289;
   static int anInt4290;
   private int anInt4291;
   private int anInt4292 = -1;
   private int[][][] anIntArrayArrayArray4293;
   static int anInt4294;
   private Node_Sub21[] aNode_Sub21Array4295;
   private int anInt4296 = 0;
   static int anInt4297;
   static int anInt4298;
   private Class312 aClass312_4299 = new Class312();
   protected boolean aBoolean4300 = false;

   final void method3980(boolean bool) {
      ++anInt4298;
      if (!bool) {
         this.method3980(true);
      }

      for(int i = 0; ~this.anInt4289 < ~i; ++i) {
         this.anIntArrayArrayArray4293[i][0] = null;
         this.anIntArrayArrayArray4293[i][1] = null;
         this.anIntArrayArrayArray4293[i][2] = null;
         this.anIntArrayArrayArray4293[i] = null;
      }

      this.anIntArrayArrayArray4293 = null;
      this.aNode_Sub21Array4295 = null;
      this.aClass312_4299.method3614(-601);
      this.aClass312_4299 = null;
   }

   final int[][] method3981(int i, int i_0_) {
      ++anInt4294;
      if (i_0_ != 3168) {
         this.method3981(-101, -42);
      }

      if (this.anInt4289 == this.anInt4291) {
         this.aBoolean4300 = this.aNode_Sub21Array4295[i] == null;
         this.aNode_Sub21Array4295[i] = Class279.aNode_Sub21_3555;
         return this.anIntArrayArrayArray4293[i];
      } else if (~this.anInt4289 == -2) {
         this.aBoolean4300 = ~this.anInt4292 != ~i;
         this.anInt4292 = i;
         return this.anIntArrayArrayArray4293[0];
      } else {
         Node_Sub21 node_sub21 = this.aNode_Sub21Array4295[i];
         if (node_sub21 == null) {
            this.aBoolean4300 = true;
            if (this.anInt4296 < this.anInt4289) {
               node_sub21 = new Node_Sub21(i, this.anInt4296);
               ++this.anInt4296;
            } else {
               Node_Sub21 node_sub21_1_ = (Node_Sub21)this.aClass312_4299.method3622((byte)-60);
               node_sub21 = new Node_Sub21(i, node_sub21_1_.anInt7181);
               this.aNode_Sub21Array4295[node_sub21_1_.anInt7187] = null;
               node_sub21_1_.method2160((byte)36);
            }

            this.aNode_Sub21Array4295[i] = node_sub21;
         } else {
            this.aBoolean4300 = false;
         }

         this.aClass312_4299.method3611(node_sub21, -127);
         return this.anIntArrayArrayArray4293[node_sub21.anInt7181];
      }
   }

   final int[][][] method3982(int i) {
      ++anInt4297;
      if (this.anInt4291 != this.anInt4289) {
         throw new RuntimeException("Can only retrieve a full image cache");
      } else {
         for(int i_2_ = i; ~i_2_ > ~this.anInt4289; ++i_2_) {
            this.aNode_Sub21Array4295[i_2_] = Class279.aNode_Sub21_3555;
         }

         return this.anIntArrayArrayArray4293;
      }
   }

   Class348(int i, int i_3_, int i_4_) {
      this.anInt4289 = i;
      this.anInt4291 = i_3_;
      this.aNode_Sub21Array4295 = new Node_Sub21[this.anInt4291];
      this.anIntArrayArrayArray4293 = new int[this.anInt4289][3][i_4_];
   }
}
