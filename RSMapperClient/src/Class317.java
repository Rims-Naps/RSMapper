public class Class317 {
   static int anInt4038 = -1;
   static int anInt4039;
   static int anInt4040;
   static int anInt4041;
   static int anInt4042;

   static final int getItemIdInSlot(int key, int junk, int slot, boolean keyLessIntegerSize) {
      ++anInt4042;
      if (junk != -1) {
         method3665(-37, null, false, 93);
      }

      Node_Sub16 node_sub16 = Class295.getItemContainer(key, (byte)18, keyLessIntegerSize);
      if (node_sub16 == null) {
         return -1;
      } else {
         return slot >= 0 && ~slot > ~node_sub16.slotItemIds.length ? node_sub16.slotItemIds[slot] : -1;
      }
   }

   static final byte[] method3664(int i, byte[] bs, int i_2_) {
      ++anInt4040;
      if (i != 1) {
         return null;
      } else {
         byte[] bs_3_ = new byte[i_2_];
         Class311.method3608(bs, 0, bs_3_, 0, i_2_);
         return bs_3_;
      }
   }

   static final void method3665(int i, IComponentDefinitions widget, boolean bool, int i_4_) {
      ++anInt4041;
      if (Class58.aWidget861 == null && !Class213.rightClickDialogueIsOpen && widget != null && Class308.method3585(widget, !bool) != null) {
         if (!bool) {
            anInt4038 = 51;
         }

         Class58.aWidget861 = widget;
         Class186.aWidget2257 = Class308.method3585(widget, false);
         Class83.anInt5179 = i;
         Node_Sub5_Sub2.anInt9412 = i_4_;
         Class99.aBoolean1282 = false;
         RuntimeException_Sub1.anInt4916 = 0;
      }
   }
}
