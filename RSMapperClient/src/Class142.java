public class Class142 {
   static int[] anIntArray1759 = new int[2];
   protected int anInt1760;
   static int anInt1761;
   private Index aClass302_1762;
   static int anInt1763;

   public static void method1619(boolean bool) {
      anIntArray1759 = null;
      if (bool) {
         anIntArray1759 = null;
      }
   }

   static final void method1620(boolean bool, int i, int i_0_, int i_1_, String string) {
      ++anInt1763;
      int i_2_ = -5 % ((i - 67) / 48);
      FixedAnimator.getItemsForGrandExchangeSearch(false, (byte)-50, bool, i_0_, i_1_, string, null);
   }

   Class142(Class353 class353, int i, Index class302) {
      new Class61(64);
      this.aClass302_1762 = class302;
      this.anInt1760 = this.aClass302_1762.method3537(-2, 15);
   }

   static final void decodeGlobalPlayerUpdate(Packet packet) {
      packet.initBitAccess();
      int skip = 0;

      for(int i = 0; Class178.LOCAL_PLAYERS_INDEXES_COUNT > i; ++i) {
         int playerIndex = Class66_Sub1.LOCAL_PLAYERS_INDEXES[i];
         if (skip > 0) {
            --skip;
         } else {
            int needLocalUpdate = packet.readBits(1);
            if (needLocalUpdate == 0) {
               skip = Node_Sub5.skipPlayersCount(packet);
            } else {
               Class324.processLocalUpdate(playerIndex, packet);
            }
         }
      }

      packet.finishBitAccess();
      if (skip != 0) {
         throw new RuntimeException("nsn0");
      } else {
         packet.initBitAccess();

         for(int i = 0; i < Class35.OUTSIDE_PLAYERS_INDEXES_COUNT; ++i) {
            int playerIndex = Node_Sub38_Sub19.OUTSIDE_PLAYERS_INDEXES[i];
            if (skip > 0) {
               --skip;
            } else {
               int needOutsideUpdate = packet.readBits(1);
               if (needOutsideUpdate == 0) {
                  skip = Node_Sub5.skipPlayersCount(packet);
               } else {
                  Class339_Sub5.processOutsideUpdate(playerIndex, packet, 28460);
               }
            }
         }

         packet.finishBitAccess();
         if (skip != 0) {
            throw new RuntimeException("nsn1");
         } else {
            Class35.OUTSIDE_PLAYERS_INDEXES_COUNT = 0;
            Class178.LOCAL_PLAYERS_INDEXES_COUNT = 0;

            for(int i_16_ = 1; i_16_ < 2048; ++i_16_) {
               Player player = Class270_Sub2.LOCAL_PLAYERS[i_16_];
               if (player == null) {
                  Node_Sub38_Sub19.OUTSIDE_PLAYERS_INDEXES[Class35.OUTSIDE_PLAYERS_INDEXES_COUNT++] = i_16_;
               } else {
                  Class66_Sub1.LOCAL_PLAYERS_INDEXES[Class178.LOCAL_PLAYERS_INDEXES_COUNT++] = i_16_;
               }
            }
         }
      }
   }
}
