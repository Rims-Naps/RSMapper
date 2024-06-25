abstract class Node_Sub38 extends Node {
   static int anInt7447;
   static int anInt7448;
   static int anInt7449;
   protected int anInt7450;
   static int[] anIntArray7451;
   static int[] anIntArray7452 = new int[]{1, 0, -1, 0};
   protected Node_Sub38[] aNode_Sub38Array7453;
   protected Class348 aClass348_7454;
   static int anInt7455;
   static int anInt7456;
   static int[] anIntArray7457 = new int[3];
   static int anInt7458;
   static int anInt7459;
   protected Class146 aClass146_7460;
   static int anInt7461;
   static int anInt7462;
   protected boolean aBoolean7463;
   static int anInt7464;
   static int anInt7465;
   static int anInt7466;
   static int anInt7467;

   public static void method2774(int i) {
      if (i != 16369) {
         method2774(-4);
      }

      anIntArray7451 = null;
      anIntArray7452 = null;
      anIntArray7457 = null;
   }

   int[] method2775(int i, int i_0_) {
      ++anInt7467;
      if (i < 107) {
         return null;
      } else {
         throw new IllegalStateException("This operation does not have a monochrome output");
      }
   }

   int method2776(byte b) {
      ++anInt7449;
      return -1;
   }

   final int[][] method2777(int i, int i_1_, int i_2_) {
      if (i > -62) {
         this.method2778(-94, true);
      }

      ++anInt7458;
      if (!this.aNode_Sub38Array7453[i_1_].aBoolean7463) {
         return this.aNode_Sub38Array7453[i_1_].method2778(i_2_, true);
      } else {
         int[] is = this.aNode_Sub38Array7453[i_1_].method2775(111, i_2_);
         return new int[][]{is, is, is};
      }
   }

   int[][] method2778(int i, boolean bool) {
      ++anInt7447;
      if (!bool) {
         this.method2782(82, -57, true);
      }

      throw new IllegalStateException("This operation does not have a colour output");
   }

   static final void method2779(IComponentDefinitions widget, int i, GraphicsToolkit graphicstoolkit) {
      ++anInt7448;
      if (i == 28564) {
         boolean bool = EntityNode_Sub3_Sub1.aClass86_9166
               .method1007(
                  widget.aBoolean4723 ? Class295.myPlayer.aPlayerDefinition11137 : null,
                  (byte)96,
                  graphicstoolkit,
                  widget.anInt4714,
                  widget.itemId,
                  widget.anInt4744,
                  widget.itemAmount,
                  0xFF000000 | widget.anInt4796
               )
            == null;
         if (bool) {
            Class69.aClass312_940
               .method3625(
                  (byte)-54,
                  new Node_Sub30(widget.itemId, widget.itemAmount, widget.anInt4744, widget.anInt4796 | 0xFF000000, widget.anInt4714, widget.aBoolean4723)
               );
            ClientScript.method2321(-1, widget);
         }
      }
   }

   void method2780(boolean bool, Buffer buffer, int i) {
      ++anInt7461;
      if (bool) {
         method2784(true, null, 33);
      }
   }

   static final int method2781(int i, int i_4_, int i_5_, int i_6_) {
      i_4_ &= 3;
      ++anInt7459;
      if (i_4_ == 0) {
         return i;
      } else {
         if (i_6_ != 27542) {
            anIntArray7457 = null;
         }

         if (~i_4_ == -2) {
            return -i_5_ + 4095;
         } else {
            return i_4_ == 2 ? 4095 - i : i_5_;
         }
      }
   }

   void method2782(int i, int i_7_, boolean bool) {
      ++anInt7465;
      if (bool) {
         anIntArray7451 = null;
      }

      int i_8_ = ~this.anInt7450 == -256 ? i : this.anInt7450;
      if (!this.aBoolean7463) {
         this.aClass348_7454 = new Class348(i_8_, i, i_7_);
      } else {
         this.aClass146_7460 = new Class146(i_8_, i, i_7_);
      }
   }

   int method2783(int i) {
      if (i != -1) {
         anIntArray7457 = null;
      }

      ++anInt7466;
      return -1;
   }

   static final float[] method2784(boolean bool, float[] fs, int i) {
      if (bool) {
         return null;
      } else {
         ++anInt7455;
         float[] fs_9_ = new float[i];
         Class311.method3603(fs, 0, fs_9_, 0, i);
         return fs_9_;
      }
   }

   void method2785(int i) {
      if (i != 7) {
         anIntArray7451 = null;
      }

      ++anInt7456;
   }

   Node_Sub38(int i, boolean bool) {
      this.aBoolean7463 = bool;
      this.aNode_Sub38Array7453 = new Node_Sub38[i];
   }

   final int[] method2786(int i, int i_10_, int i_11_) {
      ++anInt7464;
      if (i_10_ != 0) {
         this.aBoolean7463 = true;
      }

      return this.aNode_Sub38Array7453[i_11_].aBoolean7463
         ? this.aNode_Sub38Array7453[i_11_].method2775(i_10_ + 120, i)
         : this.aNode_Sub38Array7453[i_11_].method2778(i, true)[0];
   }

   void method2787(int i) {
      ++anInt7462;
      if (!this.aBoolean7463) {
         this.aClass348_7454.method3980(true);
         this.aClass348_7454 = null;
      } else {
         this.aClass146_7460.method1644(-119);
         this.aClass146_7460 = null;
      }
   }
}
