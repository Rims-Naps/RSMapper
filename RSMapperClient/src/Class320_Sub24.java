public class Class320_Sub24 extends Class320 {
   static int anInt8436;
   static int anInt8437;
   static Class223[] cachedHintIcons = new Class223[8];
   static int anInt8439;
   static int anInt8440;
   static int anInt8441;
   static int anInt8442;
   static Class197 aClass197_8443;
   static int anInt8444;

   public static void method3771(int i) {
      if (i != 0) {
         aClass197_8443 = null;
      }

      aClass197_8443 = null;
      cachedHintIcons = null;
   }

   @Override
   final void method3673(byte b) {
      if (this.anInt4064 != 1 && ~this.anInt4064 != -1) {
         this.anInt4064 = this.method3677(0);
      }

      ++anInt8437;
      if (b > -35) {
         method3771(-117);
      }
   }

   @Override
   final int method3677(int i) {
      ++anInt8440;
      return i != 0 ? 102 : 1;
   }

   static final void method3772(int i, byte b, int i_0_, int i_1_, int i_2_) {
      int i_3_ = 78 % ((23 - b) / 49);
      IComponentDefinitions.anInt4859 = i_0_;
      ClanChat.anInt764 = i_1_;
      Class150_Sub2.anInt8955 = i;
      ++anInt8439;
      Class97.anInt1279 = i_2_;
   }

   final int method3773(boolean bool) {
      if (bool) {
         this.method3675(-93, (byte)21);
      }

      ++anInt8444;
      return this.anInt4064;
   }

   @Override
   final void method3676(boolean bool, int i) {
      this.anInt4064 = i;
      ++anInt8442;
      if (bool) {
         method3775(66, -57, -111);
      }
   }

   Class320_Sub24(Node_Sub27 node_sub27) {
      super(node_sub27);
   }

   Class320_Sub24(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }

   static final void method3774(int i) {
      ++anInt8436;
      if (i <= -7) {
         for(CacheNode_Sub12 cachenode_sub12 = (CacheNode_Sub12)Class270.aClass312_3477.method3613(65280);
            cachenode_sub12 != null;
            cachenode_sub12 = (CacheNode_Sub12)Class270.aClass312_3477.method3620(16776960)
         ) {
            Mobile_Sub1 mobile_sub1 = cachenode_sub12.aMobile_Sub1_9554;
            if (Class174.clientCycle <= mobile_sub1.anInt10923) {
               if (~Class174.clientCycle <= ~mobile_sub1.anInt10958) {
                  mobile_sub1.method898(false);
                  if (~mobile_sub1.anInt10942 < -1) {
                     if (~aa.anInt101 == -4) {
                        Actor actor = Class121.aClass206Array1529[mobile_sub1.anInt10942 - 1].method2037(-102);
                        if (actor != null
                           && ~actor.x <= -1
                           && actor.x < Node_Sub54.GAME_SCENE_WDITH * 512
                           && actor.y >= 0
                           && ~actor.y > ~(512 * Class377_Sub1.GAME_SCENE_HEIGHT)) {
                           mobile_sub1.method895(
                              Node_Sub38_Sub7.getTileMedianHeight(mobile_sub1.plane, -29754, actor.y, actor.x) + -mobile_sub1.anInt10938,
                              false,
                              Class174.clientCycle,
                              actor.y,
                              actor.x
                           );
                        }
                     } else {
                        Node_Sub41 node_sub41 = (Node_Sub41)Class12.aHashTable187.get(3512, (long)(-1 + mobile_sub1.anInt10942));
                        if (node_sub41 != null) {
                           Npc npc = node_sub41.aNpc7518;
                           if (npc.x >= 0 && npc.x < Node_Sub54.GAME_SCENE_WDITH * 512 && npc.y >= 0 && ~npc.y > ~(512 * Class377_Sub1.GAME_SCENE_HEIGHT)) {
                              mobile_sub1.method895(
                                 Node_Sub38_Sub7.getTileMedianHeight(mobile_sub1.plane, -29754, npc.y, npc.x) - mobile_sub1.anInt10938,
                                 false,
                                 Class174.clientCycle,
                                 npc.y,
                                 npc.x
                              );
                           }
                        }
                     }
                  }

                  if (mobile_sub1.anInt10942 < 0) {
                     int i_4_ = -mobile_sub1.anInt10942 + -1;
                     Player player;
                     if (i_4_ == Class166.myPlayerIndex) {
                        player = Class295.myPlayer;
                     } else {
                        player = Class270_Sub2.LOCAL_PLAYERS[i_4_];
                     }

                     if (player != null
                        && player.x >= 0
                        && Node_Sub54.GAME_SCENE_WDITH * 512 > player.x
                        && player.y >= 0
                        && 512 * Class377_Sub1.GAME_SCENE_HEIGHT > player.y) {
                        mobile_sub1.method895(
                           Node_Sub38_Sub7.getTileMedianHeight(mobile_sub1.plane, -29754, player.y, player.x) - mobile_sub1.anInt10938,
                           false,
                           Class174.clientCycle,
                           player.y,
                           player.x
                        );
                     }
                  }

                  mobile_sub1.method901((byte)56, Node_Sub9_Sub1.anInt9637);
                  Node_Sub38_Sub7.method2810(mobile_sub1, true);
               }
            } else {
               cachenode_sub12.method2160((byte)60);
               mobile_sub1.method897(-90);
            }
         }
      }
   }

   @Override
   final int method3675(int i, byte b) {
      ++anInt8441;
      if (b != 54) {
         cachedHintIcons = null;
      }

      return 1;
   }

   static final void method3775(int i, int i_5_, int i_6_) {
      boolean bool = Class175.aClass261ArrayArrayArray2099[0][i_5_][i_6_] != null
         && Class175.aClass261ArrayArrayArray2099[0][i_5_][i_6_].aClass261_3310 != null;

      for(int i_7_ = i; i_7_ >= 0; --i_7_) {
         if (Class175.aClass261ArrayArrayArray2099[i_7_][i_5_][i_6_] == null) {
            Class261 class261 = Class175.aClass261ArrayArrayArray2099[i_7_][i_5_][i_6_] = new Class261(i_7_);
            if (bool) {
               ++class261.aByte3311;
            }
         }
      }
   }
}
