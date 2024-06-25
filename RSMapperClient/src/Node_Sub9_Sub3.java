public class Node_Sub9_Sub3 extends Node_Sub9 {
   private Class312 aClass312_9721 = new Class312();
   private Class312 aClass312_9722 = new Class312();
   private int anInt9723 = 0;
   private int anInt9724 = -1;

   @Override
   final int method2428() {
      return 0;
   }

   @Override
   final synchronized void method2427(int[] is, int i, int i_0_) {
      while(true) {
         if (this.anInt9724 < 0) {
            this.method2516(is, i, i_0_);
         } else if (this.anInt9723 + i_0_ < this.anInt9724) {
            this.anInt9723 += i_0_;
            this.method2516(is, i, i_0_);
         } else {
            int i_1_ = this.anInt9724 - this.anInt9723;
            this.method2516(is, i, i_1_);
            i += i_1_;
            i_0_ -= i_1_;
            this.anInt9723 += i_1_;
            this.method2518();
            Node_Sub1 node_sub1 = (Node_Sub1)this.aClass312_9722.method3613(65280);
            synchronized(node_sub1) {
               int i_2_ = node_sub1.method2166(this);
               if (i_2_ < 0) {
                  node_sub1.anInt6931 = 0;
                  this.method2519(node_sub1);
               } else {
                  node_sub1.anInt6931 = i_2_;
                  this.method2517(node_sub1.aNode2800, node_sub1);
               }
            }

            if (i_0_ != 0) {
               continue;
            }
         }

         return;
      }
   }

   final synchronized int method2512() {
      return this.aClass312_9721.method3615(-128);
   }

   final synchronized void method2513(Node_Sub9 node_sub9) {
      this.aClass312_9721.method3611(node_sub9, -91);
   }

   final synchronized void method2514(Node_Sub9 node_sub9) {
      node_sub9.method2160((byte)50);
   }

   private final void method2515(int i) {
      for(Node_Sub9 node_sub9 = (Node_Sub9)this.aClass312_9721.method3613(65280);
         node_sub9 != null;
         node_sub9 = (Node_Sub9)this.aClass312_9721.method3620(16776960)
      ) {
         node_sub9.method2426(i);
      }
   }

   private final void method2516(int[] is, int i, int i_3_) {
      for(Node_Sub9 node_sub9 = (Node_Sub9)this.aClass312_9721.method3613(65280);
         node_sub9 != null;
         node_sub9 = (Node_Sub9)this.aClass312_9721.method3620(16776960)
      ) {
         node_sub9.method2430(is, i, i_3_);
      }
   }

   @Override
   final Node_Sub9 method2431() {
      return (Node_Sub9)this.aClass312_9721.method3620(16776960);
   }

   private final void method2517(Node node, Node_Sub1 node_sub1) {
      while(node != this.aClass312_9722.aNode3958 && ((Node_Sub1)node).anInt6931 <= node_sub1.anInt6931) {
         node = node.aNode2800;
      }

      Buffer.method2205(-59, node, node_sub1);
      this.anInt9724 = ((Node_Sub1)this.aClass312_9722.aNode3958.aNode2800).anInt6931;
   }

   @Override
   final Node_Sub9 method2429() {
      return (Node_Sub9)this.aClass312_9721.method3613(65280);
   }

   @Override
   final synchronized void method2426(int i) {
      while(true) {
         if (this.anInt9724 < 0) {
            this.method2515(i);
         } else if (this.anInt9723 + i < this.anInt9724) {
            this.anInt9723 += i;
            this.method2515(i);
         } else {
            int i_4_ = this.anInt9724 - this.anInt9723;
            this.method2515(i_4_);
            i -= i_4_;
            this.anInt9723 += i_4_;
            this.method2518();
            Node_Sub1 node_sub1 = (Node_Sub1)this.aClass312_9722.method3613(65280);
            synchronized(node_sub1) {
               int i_5_ = node_sub1.method2166(this);
               if (i_5_ < 0) {
                  node_sub1.anInt6931 = 0;
                  this.method2519(node_sub1);
               } else {
                  node_sub1.anInt6931 = i_5_;
                  this.method2517(node_sub1.aNode2800, node_sub1);
               }
            }

            if (i != 0) {
               continue;
            }
         }

         return;
      }
   }

   private final void method2518() {
      if (this.anInt9723 > 0) {
         for(Node_Sub1 node_sub1 = (Node_Sub1)this.aClass312_9722.method3613(65280);
            node_sub1 != null;
            node_sub1 = (Node_Sub1)this.aClass312_9722.method3620(16776960)
         ) {
            node_sub1.anInt6931 -= this.anInt9723;
         }

         this.anInt9724 -= this.anInt9723;
         this.anInt9723 = 0;
      }
   }

   private final void method2519(Node_Sub1 node_sub1) {
      node_sub1.method2160((byte)90);
      node_sub1.method2165();
      Node node = this.aClass312_9722.aNode3958.aNode2800;
      if (node == this.aClass312_9722.aNode3958) {
         this.anInt9724 = -1;
      } else {
         this.anInt9724 = ((Node_Sub1)node).anInt6931;
      }
   }
}
