public class CacheNode_Sub7 extends CacheNode {
   static int anInt9486;
   static int anInt9487;
   static int anInt9488;
   static int anInt9489;
   protected byte[] aByteArray9490;

   static final void method2316(int i) {
      ++anInt9486;

      for(Node_Sub47 node_sub47 = (Node_Sub47)Class290_Sub6.aClass312_8122.method3613(65280);
         node_sub47 != null;
         node_sub47 = (Node_Sub47)Class290_Sub6.aClass312_8122.method3620(16776960)
      ) {
         if (node_sub47.aBoolean7574) {
            node_sub47.method2951();
         }
      }

      for(Node_Sub47 node_sub47 = (Node_Sub47)Class200_Sub2.aClass312_4942.method3613(i ^ 65287);
         node_sub47 != null;
         node_sub47 = (Node_Sub47)Class200_Sub2.aClass312_4942.method3620(16776960)
      ) {
         if (node_sub47.aBoolean7574) {
            node_sub47.method2951();
         }
      }

      if (i != 7) {
         anInt9487 = 95;
      }
   }

   static final void method2317(byte[][] bs, byte b, Class277_Sub1 class277_sub1) {
      for(int i = 0; ~i > ~class277_sub1.maxPlanes; ++i) {
         CacheNode_Sub16_Sub1.method2387((byte)-114);

         for(int i_0_ = 0; ~(Node_Sub54.GAME_SCENE_WDITH >> 3) < ~i_0_; ++i_0_) {
            for(int i_1_ = 0; Class377_Sub1.GAME_SCENE_HEIGHT >> 3 > i_1_; ++i_1_) {
               int i_2_ = Class330.anIntArrayArrayArray4128[i][i_0_][i_1_];
               if (i_2_ != -1) {
                  int i_3_ = (65358064 & i_2_) >> 24;
                  if (!class277_sub1.undermap || ~i_3_ == -1) {
                     int i_4_ = i_2_ >> 1 & 3;
                     int i_5_ = (16769600 & i_2_) >> 14;
                     int i_6_ = (i_2_ & 16377) >> 3;
                     int i_7_ = i_6_ / 8 + (i_5_ / 8 << 8);

                     for(int i_8_ = 0; ~i_8_ > ~Class262_Sub1.MAP_REGION_HASHES.length; ++i_8_) {
                        if (Class262_Sub1.MAP_REGION_HASHES[i_8_] == i_7_ && bs[i_8_] != null) {
                           class277_sub1.method3355(
                              8 * (i_5_ & 7),
                              Class304.SCENE_CLIP_DATA_PLANES,
                              i,
                              Class93.aGraphicsToolkit1241,
                              (byte)50,
                              8 * i_0_,
                              8 * i_1_,
                              bs[i_8_],
                              i_4_,
                              i_3_,
                              (7 & i_6_) * 8
                           );
                           break;
                        }
                     }
                  }
               }
            }
         }
      }

      if (b >= -86) {
         anInt9488 = -23;
      }

      ++anInt9489;
   }

   CacheNode_Sub7(byte[] bs) {
      this.aByteArray9490 = bs;
   }
}
