public class Class283 {
   static int anInt3589;
   static int totalMinimapAreaIcons = 0;
   static int anInt3591 = 0;

   static final int getItemAmountInSlotWithKey(int slot, boolean keyLessIntegerSize, byte junk, int key) {
      ++anInt3589;
      Node_Sub16 node_sub16 = Class295.getItemContainer(key, (byte)18, keyLessIntegerSize);
      if (node_sub16 == null) {
         return 0;
      } else if (slot < 0 || ~node_sub16.slotItemAmounts.length >= ~slot) {
         return 0;
      } else {
         return junk <= 60 ? -79 : node_sub16.slotItemAmounts[slot];
      }
   }
}
