public class Node_Sub15_Sub1 extends Node_Sub15 {
   static int anInt9769;
   static int anInt9770;
   static int anInt9771;
   static int anInt9772;
   private int anInt9773;
   private long aLong9774;

   static final boolean method2557(int i, int i_0_, int i_1_) {
      if (i_0_ != 1024) {
         return false;
      } else {
         ++anInt9771;
         return ~(1024 & i_1_) != -1;
      }
   }

   @Override
   final void method2556(ClanChat clanchat, int i) {
      ++anInt9770;
      if (i != 16) {
         this.aLong9774 = -38L;
      }

      clanchat.method499((byte)89, this.anInt9773, this.aLong9774);
   }

   @Override
   final void method2554(int i, Buffer buffer) {
      ++anInt9769;
      this.anInt9773 = buffer.readInt();
      this.aLong9774 = buffer.readLong();
      if (i != 29147) {
         this.aLong9774 = 79L;
      }
   }

   static final void method2558(int i) {
      ++anInt9772;
      if (i != -1) {
         method2557(-79, 88, -65);
      }

      int[] is = Class66_Sub1.LOCAL_PLAYERS_INDEXES;

      for(int i_2_ = 0; Class178.LOCAL_PLAYERS_INDEXES_COUNT > i_2_; ++i_2_) {
         Player player = Class270_Sub2.LOCAL_PLAYERS[is[i_2_]];
         if (player != null) {
            player.method847(i);
         }
      }

      for(int i_3_ = 0; i_3_ < Node_Sub25_Sub3.localNPCsCount; ++i_3_) {
         long l = (long)Class54.LocalNPCsIndexes[i_3_];
         Node_Sub41 node_sub41 = (Node_Sub41)Class12.aHashTable187.get(i + 3513, l);
         if (node_sub41 != null) {
            node_sub41.aNpc7518.method847(-1);
         }
      }

      if (aa.anInt101 == 3) {
         for(int i_4_ = 0; Class121.aClass206Array1529.length > i_4_; ++i_4_) {
            Class206 class206 = Class121.aClass206Array1529[i_4_];
            if (class206.aBoolean2472) {
               class206.method2037(-99).method847(-1);
            }
         }
      }
   }

   Node_Sub15_Sub1() {
   }
}
