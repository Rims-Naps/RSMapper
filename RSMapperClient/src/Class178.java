public class Class178 {
   static int anInt2118 = 0;
   static int anInt2119;
   static int LOCAL_PLAYERS_INDEXES_COUNT = 0;
   static int anInt2121;
   static int anInt2122;

   static final void spawnCachedObjects(int junk, byte[][] bs, Class277_Sub1 class277_sub1) {
      ++anInt2121;
      int i_0_ = Class188_Sub1_Sub1.mapFileData.length;

      for(int i_1_ = 0; i_1_ < i_0_; ++i_1_) {
         if (Class262_Sub1.MAP_REGION_HASHES[i_1_] == RSMapperClient.regionId || RSMapperClient.LOAD_ALL_REGIONS) {
            byte[] bs_2_ = bs[i_1_];
            if (bs_2_ != null) {
               int regionX = 64 * (Class262_Sub1.MAP_REGION_HASHES[i_1_] >> 8) - Node_Sub53.gameSceneBaseX;
               int regionY = 64 * (Class262_Sub1.MAP_REGION_HASHES[i_1_] & 0xFF) - Class320_Sub4.gameSceneBaseY;
               CacheNode_Sub16_Sub1.method2387((byte)-114);
               class277_sub1.loadAndDrawCachedObjects(
                  regionX, regionY, -94, Class304.SCENE_CLIP_DATA_PLANES, Class93.aGraphicsToolkit1241, bs_2_, Class262_Sub1.MAP_REGION_HASHES[i_1_]
               );
            }

            if (Class262_Sub1.MAP_REGION_HASHES[i_1_] == RSMapperClient.regionId
               && !RSMapperClient.editor.objectEditor.dataLoaded
               && (RSMapperClient.undermapArchiveId == -1 || class277_sub1.undermap)) {
               RSMapperClient.editor.objectEditor.dataLoaded = true;
            }
         }
      }

      if (junk != 31269) {
         anInt2118 = 93;
      }
   }

   static final int method1812(int i) {
      ++anInt2122;
      if (Class213.rightClickDialogueIsOpen) {
         return 6;
      } else {
         if (i != 5) {
            LOCAL_PLAYERS_INDEXES_COUNT = -106;
         }

         if (Node_Sub38_Sub23.aCacheNode_Sub13_10343 == null) {
            return 0;
         } else {
            int i_5_ = Node_Sub38_Sub23.aCacheNode_Sub13_10343.anInt9562;
            if (Class251.method3101(i_5_, (byte)-62)) {
               return 1;
            } else if (Class134.method1574(false, i_5_)) {
               return 2;
            } else if (Class194_Sub3.method1973(i_5_, 31922)) {
               return 3;
            } else if (OutgoingPacket.method3666(i_5_, (byte)112)) {
               return 4;
            } else if (Class262_Sub2.method3155(i_5_, (byte)-18)) {
               return 7;
            } else {
               return i_5_ == 4 ? 8 : 5;
            }
         }
      }
   }
}
