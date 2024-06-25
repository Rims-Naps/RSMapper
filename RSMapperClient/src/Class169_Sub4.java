import jaggl.OpenGL;

public class Class169_Sub4 extends Class169 {
   static int anInt8822;
   static int anInt8823;
   private int anInt8824;
   static Class353 aClass353_8825 = new Class353("stellardawn", "Stellar Dawn", 1);
   static int[][] anIntArrayArray8826;
   static int anInt8827;
   static int anInt8828;
   static volatile boolean aBoolean8829 = false;
   static String clanChatDisplayName = null;
   static int anInt8831;

   final void method1784(int i, boolean bool) {
      this.aGLToolkit4947.method1444(-2, this);
      if (i != 33071) {
         this.method5(37);
      }

      ++anInt8823;
      OpenGL.glTexParameteri(this.anInt4951, 10242, !bool ? '\u812F' : 10497);
   }

   public static void method1785(int i) {
      aClass353_8825 = null;
      clanChatDisplayName = null;
      if (i == -19734) {
         anIntArrayArray8826 = null;
      }
   }

   @Override
   public final void method5(int i) {
      if (i != 0) {
         clanChatDisplayName = null;
      }

      ++anInt8822;
   }

   Class169_Sub4(GLToolkit gltoolkit, int i, int i_0_, byte[] bs, int i_1_) {
      super(gltoolkit, 3552, i, i_0_, false);
      this.anInt8824 = i_0_;
      this.aGLToolkit4947.method1444(-2, this);
      OpenGL.glPixelStorei(3317, 1);
      OpenGL.glTexImage1Dub(this.anInt4951, 0, this.anInt4950, this.anInt8824, 0, i_1_, 5121, bs, 0);
      OpenGL.glPixelStorei(3317, 4);
      this.method1757(false, true);
   }

   static final void method1786(int i) {
      if (i <= 87) {
         clanChatDisplayName = null;
      }

      CacheNode_Sub10.aHashTable9530.method1517(false);
      ++anInt8827;
      IComponentDefinitions.aHashTable4827.method1517(false);
   }

   static final void method1787(byte b) {
      ++anInt8828;
      int minVerticalRotation = 0;
      int maxVerticalRotation = 4096;
      if (Class257.cameraRotationVertical < (float)minVerticalRotation) {
         Class257.cameraRotationVertical = (float)minVerticalRotation;
      }

      while(Node_Sub12.cameraRotationHorizontal >= 16384.0F) {
         Node_Sub12.cameraRotationHorizontal -= 16384.0F;
      }

      if (Class257.cameraRotationVertical > (float)maxVerticalRotation) {
         Class257.cameraRotationVertical = (float)maxVerticalRotation;
      }

      while(Node_Sub12.cameraRotationHorizontal < 0.0F) {
         Node_Sub12.cameraRotationHorizontal += 16384.0F;
      }

      int i_3_ = Mobile_Sub4.playerPositionX >> 9;
      int i_4_ = Class25.playerPositionY >> 9;
      int i_5_ = 99 / ((73 - b) / 34);
      int i_6_ = Node_Sub38_Sub7.getTileMedianHeight(CacheNode_Sub20_Sub1.myPlayerPlane, -29754, Class25.playerPositionY, Mobile_Sub4.playerPositionX);
      int i_7_ = 0;
      if (~i_3_ < -4 && ~i_4_ < -4 && -4 + Node_Sub54.GAME_SCENE_WDITH > i_3_ && i_4_ < Class377_Sub1.GAME_SCENE_HEIGHT - 4) {
         for(int i_8_ = i_3_ - 4; 4 + i_3_ >= i_8_; ++i_8_) {
            for(int i_9_ = i_4_ - 4; ~i_9_ >= ~(i_4_ - -4); ++i_9_) {
               int i_10_ = CacheNode_Sub20_Sub1.myPlayerPlane;
               if (i_10_ < 3 && Class238.tileHasBridgeFlag(i_9_, i_8_, -83)) {
                  ++i_10_;
               }
            }
         }
      }

      int i_13_ = (i_7_ >> 2) * 1536;
      if (i_13_ < 200000) {
         i_13_ = 200000;
      }

      if (Class200_Sub1.anInt5145 > i_13_) {
         Class200_Sub1.anInt5145 += (i_13_ - Class200_Sub1.anInt5145) / 24;
      } else if (Class200_Sub1.anInt5145 < i_13_) {
         Class200_Sub1.anInt5145 += (i_13_ + -Class200_Sub1.anInt5145) / 80;
      }
   }
}
