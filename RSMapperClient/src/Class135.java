public class Class135 {
   static int anInt1689;
   static int anInt1690;
   static int anInt1691;
   static int INT_9_;

   static final void method1587(Player player) {
      ++anInt1689;
      Node_Sub47 node_sub47 = (Node_Sub47)Class320_Sub3.aHashTable8234.get(3512, (long)player.index);
      if (node_sub47 != null) {
         node_sub47.method2951();
      } else {
         Class262_Sub1.method3150(player.plane, player, player.scenePositionXQueue[0], player.scenePositionYQueue[0], null, null, 0);
      }
   }

   static final Object method1588(byte[] bs) {
      ++anInt1691;
      if (bs == null) {
         return null;
      } else {
         if (bs.length > 136 && !Class169_Sub1.aBoolean8783) {
            try {
               Class201 class201 = (Class201)Class.forName("Class201_Sub1").newInstance();
               class201.method2021(bs, 0);
               return class201;
            } catch (Throwable var2) {
               Class169_Sub1.aBoolean8783 = true;
            }
         }

         return bs;
      }
   }
}
