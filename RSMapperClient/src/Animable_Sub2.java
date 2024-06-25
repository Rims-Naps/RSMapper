abstract class Animable_Sub2 extends Animable {
   static int anInt9106;
   static int anInt9107;
   static int anInt9108;
   static int anInt9109;
   protected short aShort9110;
   static int anInt9111;
   static int anInt9112;
   static int anInt9113;
   static OutgoingPacket aClass318_9114 = new OutgoingPacket(47, 9);
   static int anInt9115;
   static Class103 aClass103_9116;

   static final void method834(int i, Class163 class163) {
      Class342.aClass163_4236 = class163;
      if (i >= -106) {
         aClass103_9116 = null;
      }

      ++anInt9115;
   }

   static final boolean method835(Class171 class171, byte b) {
      ++anInt9112;
      if (class171 == null) {
         return false;
      } else {
         if (b < 91) {
            aClass318_9114 = null;
         }

         return Node_Sub25.method2653(
            -class171.anInt2059 + class171.anInt2063,
            -class171.anInt2072 + class171.anInt2073,
            class171.anInt2059,
            255,
            class171.anInt2068,
            class171.anInt2072,
            class171.anInt2061 - class171.anInt2068
         );
      }
   }

   @Override
   final boolean method815(byte b, GraphicsToolkit graphicstoolkit) {
      if (b != 59) {
         this.aShort9110 = -17;
      }

      ++anInt9109;
      return Actor.method859(this.x >> Class36.INT_9, this.y >> Class36.INT_9, 4297, this, this.aByte5931);
   }

   static final void method836(int i, boolean bool) {
      ++anInt9108;
      Class152.anInt1941 = i;
      if (!bool) {
         aClass103_9116 = null;
      }
   }

   @Override
   final int method819(Node_Sub29[] node_sub29s, int i) {
      ++anInt9106;
      int i_0_ = this.x >> Class36.INT_9;
      if (i != 1) {
         return 71;
      } else {
         int i_1_ = this.y >> Class36.INT_9;
         int i_2_ = 0;
         if (Class98.cameraPosX >> 9 == i_0_) {
            ++i_2_;
         } else if (~(Class98.cameraPosX >> 9) > ~i_0_) {
            i_2_ += 2;
         }

         if (~i_1_ != ~(Node_Sub10.cameraPosY >> 9)) {
            if (~(Node_Sub10.cameraPosY >> 9) < ~i_1_) {
               i_2_ += 6;
            }
         } else {
            i_2_ += 3;
         }

         int i_3_ = Class1.anIntArray109[i_2_];
         if (~(this.aShort9110 & i_3_) != -1) {
            return this.method808(-23024, node_sub29s, i_1_, i_0_);
         } else if (~this.aShort9110 == -2 && i_0_ > 0) {
            return this.method808(-23024, node_sub29s, i_1_, -1 + i_0_);
         } else if (this.aShort9110 == 4 && Class328.SCENE_WIDTH_X >= i_0_) {
            return this.method808(-23024, node_sub29s, i_1_, i_0_ + 1);
         } else if (~this.aShort9110 == -9 && i_1_ > 0) {
            return this.method808(-23024, node_sub29s, -1 + i_1_, i_0_);
         } else if (~this.aShort9110 == -3 && ~Node_Sub50.SCENE_WIDTH_Y <= ~i_1_) {
            return this.method808(-23024, node_sub29s, 1 + i_1_, i_0_);
         } else if (~this.aShort9110 == -17 && ~i_0_ < -1 && i_1_ <= Node_Sub50.SCENE_WIDTH_Y) {
            return this.method808(-23024, node_sub29s, 1 + i_1_, -1 + i_0_);
         } else if (this.aShort9110 == 32 && i_0_ <= Class328.SCENE_WIDTH_X && Node_Sub50.SCENE_WIDTH_Y >= i_1_) {
            return this.method808(-23024, node_sub29s, i_1_ + 1, 1 + i_0_);
         } else if (~this.aShort9110 == -129 && ~i_0_ < -1 && i_1_ > 0) {
            return this.method808(-23024, node_sub29s, -1 + i_1_, i_0_ + -1);
         } else if (~this.aShort9110 == -65 && Class328.SCENE_WIDTH_X >= i_0_ && i_1_ > 0) {
            return this.method808(i ^ -23023, node_sub29s, -1 + i_1_, i_0_ + 1);
         } else {
            throw new RuntimeException("");
         }
      }
   }

   static final void updateGameSceneSize(int sceneSize) {
      if (sceneSize != Node_Sub38_Sub25.CURRENT_GAME_SCENE_SIZE) {
         Node_Sub54.GAME_SCENE_WDITH = Class377_Sub1.GAME_SCENE_HEIGHT = Class129.VALID_GAME_SCENE_SIZES[sceneSize];
         Class116.method1163(2);
         Class330.anIntArrayArrayArray4128 = new int[4][Node_Sub54.GAME_SCENE_WDITH >> 3][Class377_Sub1.GAME_SCENE_HEIGHT >> 3];
         AreaDefinitions.anIntArrayArray1070 = new int[Node_Sub54.GAME_SCENE_WDITH][Class377_Sub1.GAME_SCENE_HEIGHT];
         Node_Sub38_Sub16.anIntArrayArray10269 = new int[Node_Sub54.GAME_SCENE_WDITH][Class377_Sub1.GAME_SCENE_HEIGHT];

         for(int i_4_ = 0; ~i_4_ > -5; ++i_4_) {
            Class304.SCENE_CLIP_DATA_PLANES[i_4_] = Class63.method707(Node_Sub54.GAME_SCENE_WDITH, Class377_Sub1.GAME_SCENE_HEIGHT, (byte)42);
         }

         Node_Sub38_Sub15.aByteArrayArrayArray10261 = new byte[4][Node_Sub54.GAME_SCENE_WDITH][Class377_Sub1.GAME_SCENE_HEIGHT];
         Class376.method4119(Node_Sub54.GAME_SCENE_WDITH, -128, Class377_Sub1.GAME_SCENE_HEIGHT, 4);
         Class325.method3814(Class93.aGraphicsToolkit1241, 18521, Class377_Sub1.GAME_SCENE_HEIGHT >> 3, Node_Sub54.GAME_SCENE_WDITH >> 3);
         Node_Sub38_Sub25.CURRENT_GAME_SCENE_SIZE = sceneSize;
      }
   }

   public static void method838(int i) {
      aClass103_9116 = null;
      if (i > -31) {
         updateGameSceneSize(59);
      }

      aClass318_9114 = null;
   }

   @Override
   final boolean method806(int i) {
      ++anInt9107;
      if (i != 0) {
         aClass103_9116 = null;
      }

      return Class139.aBooleanArrayArray1730[-Class216.anInt2551 + (this.x >> Class36.INT_9) + Node_Sub9_Sub1.anInt9656][Node_Sub9_Sub1.anInt9656
         + -EntityNode_Sub7.anInt6013
         + (this.y >> Class36.INT_9)];
   }

   Animable_Sub2(int i, int i_5_, int i_6_, int i_7_, int i_8_, int i_9_) {
      this.aShort9110 = (short)i_9_;
      this.anInt5937 = i_5_;
      this.plane = (byte)i_7_;
      this.y = i_6_;
      this.x = i;
      this.aByte5931 = (byte)i_8_;
   }
}
