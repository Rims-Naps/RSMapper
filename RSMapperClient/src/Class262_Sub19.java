public class Class262_Sub19 extends Class262 {
   private long hash;
   static short[] aShortArray7852 = new short[256];
   private int value;
   static int[][] anIntArrayArray7854 = new int[][]{
      {0, 1, 2, 3},
      {1, -1, -1, 0},
      {-1, 2, -1, 0},
      {-1, 0, -1, 2},
      {0, 1, -1, 2},
      {1, 2, -1, 0},
      {-1, 4, -1, 1},
      {-1, 3, 4, -1},
      {-1, 0, 2, -1},
      {-1, -1, 2, 0},
      {0, 2, 5, 3},
      {0, -1, 6, -1},
      {0, 1, 2, 3}
   };
   static int anInt7855;
   static int anInt7856;
   static int anInt7857;

   static final void sendCreateCursorObject(int rotation, int id, int typeFlag, int localX, int plane, int type, int localY, boolean bool, int addedCondition) {
      Node_Sub19 node_sub19 = null;

      for(Node_Sub19 node_sub19_6_ = (Node_Sub19)Class89.aClass312_1199.method3613(65280);
         node_sub19_6_ != null;
         node_sub19_6_ = (Node_Sub19)Class89.aClass312_1199.method3620(16776960)
      ) {
         if (plane == node_sub19_6_.plane
            && node_sub19_6_.x == localX
            && localY == node_sub19_6_.y
            && node_sub19_6_.typeFlag == typeFlag
            && node_sub19_6_.addedCondition == addedCondition) {
            node_sub19 = node_sub19_6_;
            break;
         }
      }

      if (node_sub19 == null) {
         node_sub19 = new Node_Sub19();
         node_sub19.typeFlag = typeFlag;
         node_sub19.plane = plane;
         node_sub19.y = localY;
         node_sub19.x = localX;
         if (localX >= 0 && localY >= 0 && Node_Sub54.GAME_SCENE_WDITH > localX && localY < Class377_Sub1.GAME_SCENE_HEIGHT) {
            PacketParser.method2247(103, node_sub19);
         }

         Class89.aClass312_1199.method3625((byte)-54, node_sub19);
      }

      node_sub19.aBoolean7159 = true;
      node_sub19.rotation = rotation;
      node_sub19.type = type;
      node_sub19.aBoolean7156 = bool;
      node_sub19.id = id;
      node_sub19.addedCondition = addedCondition;
   }

   static final void sendDrawWorldObjectFromEditor(int rotation, int id, int typeFlag, int localX, int plane, int type, int localY, boolean bool) {
      Node_Sub19 node_sub19 = null;

      for(Node_Sub19 node_sub19_6_ = (Node_Sub19)Class89.aClass312_1199.method3613(65280);
         node_sub19_6_ != null;
         node_sub19_6_ = (Node_Sub19)Class89.aClass312_1199.method3620(16776960)
      ) {
         if (plane == node_sub19_6_.plane && node_sub19_6_.x == localX && localY == node_sub19_6_.y && node_sub19_6_.typeFlag == typeFlag) {
            node_sub19 = node_sub19_6_;
            break;
         }
      }

      if (node_sub19 == null) {
         node_sub19 = new Node_Sub19();
         node_sub19.typeFlag = typeFlag;
         node_sub19.plane = plane;
         node_sub19.y = localY;
         node_sub19.x = localX;
         if (localX >= 0 && localY >= 0 && Node_Sub54.GAME_SCENE_WDITH > localX && localY < Class377_Sub1.GAME_SCENE_HEIGHT) {
            PacketParser.method2247(103, node_sub19);
         }

         Class89.aClass312_1199.method3625((byte)-54, node_sub19);
      }

      node_sub19.aBoolean7159 = true;
      node_sub19.rotation = rotation;
      node_sub19.type = type;
      node_sub19.aBoolean7156 = bool;
      node_sub19.id = id;
      node_sub19.addedCondition = -1;
   }

   static final void sendDrawWorldObject(int rotation, int id, int typeFlag, int localX, int plane, int type, int localY, boolean bool) {
      ++anInt7857;
      Node_Sub19 node_sub19 = null;

      for(Node_Sub19 node_sub19_6_ = (Node_Sub19)Class89.aClass312_1199.method3613(65280);
         node_sub19_6_ != null;
         node_sub19_6_ = (Node_Sub19)Class89.aClass312_1199.method3620(16776960)
      ) {
         if (plane == node_sub19_6_.plane && node_sub19_6_.x == localX && localY == node_sub19_6_.y && node_sub19_6_.typeFlag == typeFlag) {
            node_sub19 = node_sub19_6_;
            break;
         }
      }

      if (node_sub19 == null) {
         node_sub19 = new Node_Sub19();
         node_sub19.typeFlag = typeFlag;
         node_sub19.plane = plane;
         node_sub19.y = localY;
         node_sub19.x = localX;
         if (localX >= 0 && localY >= 0 && Node_Sub54.GAME_SCENE_WDITH > localX && localY < Class377_Sub1.GAME_SCENE_HEIGHT) {
            PacketParser.method2247(103, node_sub19);
         }

         Class89.aClass312_1199.method3625((byte)-54, node_sub19);
      }

      node_sub19.aBoolean7159 = true;
      node_sub19.rotation = rotation;
      node_sub19.type = type;
      node_sub19.aBoolean7156 = bool;
      node_sub19.id = id;
      node_sub19.addedCondition = -1;
   }

   static final void method3201(int i) {
      ++anInt7855;
      Class335.aClass61_4161.method602((byte)-128);
      if (i != -23303) {
         anIntArrayArray7854 = null;
      }
   }

   public static void method3202(int i) {
      aShortArray7852 = null;
      int i_7_ = 49 / ((-59 - i) / 47);
      anIntArrayArray7854 = null;
   }

   @Override
   final void method3148(int i) {
      ++anInt7856;
      Node_Sub32 node_sub32 = (Node_Sub32)Class18.aHashTable308.get(3512, this.hash);
      if (node_sub32 != null) {
         node_sub32.anInt7381 = this.value;
      } else {
         if (i > -102) {
            aShortArray7852 = null;
         }

         Class18.aHashTable308.put(this.hash, new Node_Sub32(this.value), -126);
      }
   }

   Class262_Sub19(Buffer buffer, boolean bool) {
      super(buffer);
      int i = buffer.readUnsignedShort();
      if (!bool) {
         this.hash = (long)i;
      } else {
         this.hash = 4294967296L | (long)i;
      }

      this.value = buffer.readInt();
   }
}
