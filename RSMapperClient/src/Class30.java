public class Class30 {
   static int anInt491;
   static int anInt492;
   static int anInt493;
   static Class103[] aClass103Array494 = new Class103[5];
   static IncommingPacket aClass192_495;

   static {
      for(int i = 0; i < aClass103Array494.length; ++i) {
         aClass103Array494[i] = new Class103();
      }

      aClass192_495 = new IncommingPacket(101, 3);
   }

   static final int getTotalFreeSlotsInContainerWithKey(byte junk, boolean keyLessIntegerSize, int key) {
      ++anInt492;
      if (keyLessIntegerSize) {
         return 0;
      } else {
         Node_Sub16 node_sub16 = Class295.getItemContainer(key, (byte)18, keyLessIntegerSize);
         if (node_sub16 == null) {
            return Class269.aClass308_3469.method3584(key, -13798).itemsCount;
         } else {
            int freeSlots = 0;
            if (junk != 88) {
               anInt491 = 95;
            }

            for(int slot = 0; ~slot > ~node_sub16.slotItemIds.length; ++slot) {
               if (node_sub16.slotItemIds[slot] == -1) {
                  ++freeSlots;
               }
            }

            return freeSlots + (Class269.aClass308_3469.method3584(key, -13798).itemsCount - node_sub16.slotItemIds.length);
         }
      }
   }

   public static void method342(int i) {
      if (i != -1) {
         method342(-36);
      }

      aClass192_495 = null;
      aClass103Array494 = null;
   }

   static final void method343(int i) {
      ++anInt493;

      for(Node_Sub3 node_sub3 = (Node_Sub3)Class56.aHashTable839.method1516(false);
         node_sub3 != null;
         node_sub3 = (Node_Sub3)Class56.aHashTable839.method1520(73)
      ) {
         Renderer.method3446(node_sub3.anInt6947, 5);
      }

      if (i >= -113) {
         method343(-70);
      }
   }
}
