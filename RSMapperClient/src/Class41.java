import java.io.IOException;
import java.net.Socket;

abstract class Class41 {
   static IComponentDefinitions aWidget622;
   static int anInt623;
   protected int anInt624;
   protected String aString625;
   static int anInt626;
   static int anInt627;
   static int anInt628;

   public static void method433(int i) {
      aWidget622 = null;
      if (i != 0) {
         getItemAmountInContainerWithKey(5, -42, false, (byte)-127);
      }
   }

   final Socket method434(boolean bool) throws IOException {
      ++anInt628;
      if (bool) {
         anInt626 = -36;
      }

      return new Socket(this.aString625, this.anInt624);
   }

   public Class41() {
   }

   abstract Socket method435(int var1) throws IOException;

   static final void method436(int i, String string, int i_0_) {
      if (i == 29459) {
         Class28.method331(string, "", -85, 0, "", "", i_0_);
         ++anInt623;
      }
   }

   static final int getItemAmountInContainerWithKey(int itemId, int key, boolean keyLessIntegerSize, byte junk) {
      ++anInt627;
      Node_Sub16 node_sub16 = Class295.getItemContainer(key, (byte)18, keyLessIntegerSize);
      if (node_sub16 == null) {
         return 0;
      } else if (itemId == -1) {
         return 0;
      } else {
         int amount = 0;
         if (junk <= 34) {
            return 82;
         } else {
            for(int slot = 0; node_sub16.slotItemAmounts.length > slot; ++slot) {
               if (itemId == node_sub16.slotItemIds[slot]) {
                  amount += node_sub16.slotItemAmounts[slot];
               }
            }

            return amount;
         }
      }
   }
}
