public class Node_Sub38_Sub16 extends Node_Sub38 {
   static int anInt10264;
   static int anInt10265;
   static int anInt10266;
   static int anInt10267;
   static Class335 aClass335_10268 = new Class335(64);
   static int[][] anIntArrayArray10269;

   public static void method2839(int i) {
      if (i != 5) {
         method2839(-89);
      }

      anIntArrayArray10269 = null;
      aClass335_10268 = null;
   }

   @Override
   final int[] method2775(int i, int i_0_) {
      ++anInt10266;
      int[] is = this.aClass146_7460.method1645(27356, i_0_);
      if (this.aClass146_7460.aBoolean1819) {
         int[] is_1_ = this.method2786(i_0_, 0, 0);

         for(int i_2_ = 0; Class339_Sub7.anInt8728 > i_2_; ++i_2_) {
            is[i_2_] = -is_1_[i_2_] + 4096;
         }
      }

      return i <= 107 ? null : is;
   }

   @Override
   final int[][] method2778(int i, boolean bool) {
      if (!bool) {
         anIntArrayArray10269 = null;
      }

      ++anInt10264;
      int[][] is = this.aClass348_7454.method3981(i, 3168);
      if (this.aClass348_7454.aBoolean4300) {
         int[][] is_3_ = this.method2777(-113, 0, i);
         int[] is_4_ = is_3_[0];
         int[] is_5_ = is_3_[1];
         int[] is_6_ = is_3_[2];
         int[] is_7_ = is[0];
         int[] is_8_ = is[1];
         int[] is_9_ = is[2];

         for(int i_10_ = 0; Class339_Sub7.anInt8728 > i_10_; ++i_10_) {
            is_7_[i_10_] = -is_4_[i_10_] + 4096;
            is_8_[i_10_] = 4096 + -is_5_[i_10_];
            is_9_[i_10_] = -is_6_[i_10_] + 4096;
         }
      }

      return is;
   }

   static final void method2840(int i) {
      if (i == 0) {
         if (Class22.INT_ONE == 2) {
            GraphicsToolkit.aClass33Array1549[0].method364(Class364.aClass273Array4513[0]);
            GraphicsToolkit.aClass33Array1549[1].method364(Class364.aClass273Array4513[1]);
         } else if (Class22.INT_ONE == 3) {
            GraphicsToolkit.aClass33Array1549[0].method364(Class364.aClass273Array4513[0]);
            GraphicsToolkit.aClass33Array1549[1].method364(Class364.aClass273Array4513[1]);
            GraphicsToolkit.aClass33Array1549[2].method364(Class364.aClass273Array4513[2]);
         } else {
            GraphicsToolkit.aClass33Array1549[0].method364(Class364.aClass273Array4513[0]);
            GraphicsToolkit.aClass33Array1549[1].method364(Class364.aClass273Array4513[1]);
            GraphicsToolkit.aClass33Array1549[2].method364(Class364.aClass273Array4513[2]);
            GraphicsToolkit.aClass33Array1549[3].method364(Class364.aClass273Array4513[3]);
         }
      } else if (i == 1) {
         if (Class22.INT_ONE == 2) {
            GraphicsToolkit.aClass33Array1549[0].method364(Class364.aClass273Array4513[2]);
         } else if (Class22.INT_ONE == 3) {
            GraphicsToolkit.aClass33Array1549[0].method364(Class364.aClass273Array4513[3]);
            GraphicsToolkit.aClass33Array1549[1].method364(Class364.aClass273Array4513[4]);
         } else {
            GraphicsToolkit.aClass33Array1549[0].method364(Class364.aClass273Array4513[4]);
            GraphicsToolkit.aClass33Array1549[1].method364(Class364.aClass273Array4513[5]);
            GraphicsToolkit.aClass33Array1549[2].method364(Class364.aClass273Array4513[6]);
         }
      } else if (i == 2) {
         if (Class22.INT_ONE == 2) {
            GraphicsToolkit.aClass33Array1549[0].method364(Class364.aClass273Array4513[3]);
         } else if (Class22.INT_ONE == 3) {
            GraphicsToolkit.aClass33Array1549[0].method364(Class364.aClass273Array4513[5]);
         } else {
            GraphicsToolkit.aClass33Array1549[0].method364(Class364.aClass273Array4513[7]);
         }
      }
   }

   static final void sendItemOnContainerWithKeyInSlot(boolean keyLessIntegerSize, int junk, int amount, int slot, int id, int key) {
      ++anInt10267;
      if (junk <= -119) {
         long l = (long)((keyLessIntegerSize ? Integer.MIN_VALUE : 0) | key);
         Node_Sub16 node_sub16 = (Node_Sub16)Class153.aHashTable1947.get(3512, l);
         if (node_sub16 == null) {
            node_sub16 = new Node_Sub16();
            Class153.aHashTable1947.put(l, node_sub16, -128);
         }

         if (slot >= node_sub16.slotItemIds.length) {
            int[] newItemIds = new int[slot + 1];
            int[] newItemAmounts = new int[slot + 1];

            for(int i = 0; ~node_sub16.slotItemIds.length < ~i; ++i) {
               newItemIds[i] = node_sub16.slotItemIds[i];
               newItemAmounts[i] = node_sub16.slotItemAmounts[i];
            }

            for(int i = node_sub16.slotItemIds.length; ~i > ~slot; ++i) {
               newItemIds[i] = -1;
               newItemAmounts[i] = 0;
            }

            node_sub16.slotItemAmounts = newItemAmounts;
            node_sub16.slotItemIds = newItemIds;
         }

         node_sub16.slotItemIds[slot] = id;
         node_sub16.slotItemAmounts[slot] = amount;
      }
   }

   public Node_Sub38_Sub16() {
      super(1, false);
   }

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      if (bool) {
         method2840(111);
      }

      if (i == 0) {
         this.aBoolean7463 = buffer.readUnsignedByte() == 1;
      }

      ++anInt10265;
   }
}
