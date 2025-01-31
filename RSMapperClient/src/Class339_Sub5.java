import jaggl.OpenGL;

public class Class339_Sub5 extends Class339 {
   static int anInt8681;
   static int anInt8682;
   static int anInt8683;
   static int anInt8684 = -1;
   static IncommingPacket aClass192_8685 = new IncommingPacket(50, -2);
   static int anInt8686;
   static int anInt8687;
   private Class301 aClass301_8688;
   static int anInt8689;
   static int anInt8690;
   static int anInt8691;
   private Class25 aClass25_8692;

   static final boolean processOutsideUpdate(int playerIndex, Packet packet, int i_0_) {
      int opcode = packet.readBits(2);
      if (opcode == 0) {
         System.out.println("Called 0");
         if (packet.readBits(1) != 0) {
            processOutsideUpdate(playerIndex, packet, 28460);
         }

         int offsetX = packet.readBits(6);
         int offsetY = packet.readBits(6);
         boolean needUpdate = ~packet.readBits(1) == -2;
         if (needUpdate) {
            Node_Sub23_Sub1.DECODE_MASKS_PLAYERS_INDEXES_LIST[Node_Sub9_Sub4.DECODE_MASKS_PLAYERS_COUNT++] = playerIndex;
         }

         if (Class270_Sub2.LOCAL_PLAYERS[playerIndex] != null) {
            throw new RuntimeException("hr:lr");
         } else {
            PlayerUpdateReference class323 = Class320_Sub10.aClass323Array8296[playerIndex];
            Player player = Class270_Sub2.LOCAL_PLAYERS[playerIndex] = new Player();
            player.index = playerIndex;
            if (Class249.cachedAppearences[playerIndex] != null) {
               player.decodeAppearence(Class249.cachedAppearences[playerIndex], 0);
            }

            player.method849(class323.anInt4079, -73, true);
            player.faceEntity = class323.anInt4074;
            int hash = class323.globalPositionHash;
            int plane = hash >> 28;
            int baseX = hash >> 14 & 0xFF;
            int baseY = hash & 0xFF;
            int x = (baseX << 6) + offsetX - Node_Sub53.gameSceneBaseX;
            player.aBoolean11135 = class323.aBoolean4082;
            int y = (baseY << 6) + offsetY - Class320_Sub4.gameSceneBaseY;
            player.aBoolean11157 = class323.aBoolean4076;
            player.movementTypeQueue[0] = Class73.movementTypes[playerIndex];
            player.plane = player.aByte5931 = (byte)plane;
            if (Class238.tileHasBridgeFlag(y, x, -87)) {
               player.aByte5931 = (byte)(player.aByte5931 + 1);
            }

            player.method888(x, -100, y);
            player.aBoolean11156 = false;
            Class320_Sub10.aClass323Array8296[playerIndex] = null;
            return true;
         }
      } else if (opcode == 1) {
         System.out.println("Called 1");
         int planeOffset = packet.readBits(2);
         int oldHash = Class320_Sub10.aClass323Array8296[playerIndex].globalPositionHash;
         Class320_Sub10.aClass323Array8296[playerIndex].globalPositionHash = ((3 & (oldHash >> 28) + planeOffset) << 28) + (oldHash & 268435455);
         return false;
      } else if (opcode == 2) {
         System.out.println("Called 2");
         int offsetHash = packet.readBits(5);
         int planeOffset = offsetHash >> 3;
         int moveType = offsetHash & 7;
         int hash = Class320_Sub10.aClass323Array8296[playerIndex].globalPositionHash;
         int newPlane = 3 & (hash >> 28) - -planeOffset;
         int x = hash >> 14 & 0xFF;
         int y = 0xFF & hash;
         if (moveType == 0) {
            --y;
            --x;
         }

         if (moveType == 1) {
            --y;
         }

         if (moveType == 2) {
            ++x;
            --y;
         }

         if (~moveType == -4) {
            --x;
         }

         if (moveType == 4) {
            ++x;
         }

         if (~moveType == -6) {
            --x;
            ++y;
         }

         if (moveType == 6) {
            ++y;
         }

         if (moveType == 7) {
            ++x;
            ++y;
         }

         Class320_Sub10.aClass323Array8296[playerIndex].globalPositionHash = y + (x << 14) + (newPlane << 28);
         return false;
      } else {
         int offsetHash = packet.readBits(18);
         int planeOffset = offsetHash >> 16;
         int xOffset = offsetHash >> 8 & 0xFF;
         int yOffset = 0xFF & offsetHash;
         int i_23_ = Class320_Sub10.aClass323Array8296[playerIndex].globalPositionHash;
         int i_24_ = planeOffset + (i_23_ >> 28) & 3;
         int i_25_ = 0xFF & xOffset + (i_23_ >> 14);
         int i_26_ = 0xFF & i_23_ - -yOffset;
         Class320_Sub10.aClass323Array8296[playerIndex].globalPositionHash = i_26_ + (i_25_ << 14) + (i_24_ << 28);
         return false;
      }
   }

   @Override
   final void method3920(int i, boolean bool) {
      if (i != -1) {
         this.method3923(false, -21);
      }

      ++anInt8690;
   }

   Class339_Sub5(GLToolkit gltoolkit, Class301 class301) {
      super(gltoolkit);
      this.aClass301_8688 = class301;
      this.aClass25_8692 = new Class25(gltoolkit, 2);
      this.aClass25_8692.method307(0, 4864);
      this.aGLToolkit4202.method1457(33984, 1);
      if (this.aClass301_8688.aBoolean3780) {
         OpenGL.glTexGeni(8194, 9472, 9217);
         OpenGL.glEnable(3170);
      }

      OpenGL.glTexGeni(8192, 9472, 9216);
      OpenGL.glTexGeni(8193, 9472, 9216);
      OpenGL.glEnable(3168);
      OpenGL.glEnable(3169);
      this.aGLToolkit4202.method1457(33984, 0);
      this.aClass25_8692.method309(false);
      this.aClass25_8692.method307(1, 4864);
      this.aGLToolkit4202.method1457(33984, 1);
      if (this.aClass301_8688.aBoolean3780) {
         OpenGL.glDisable(3170);
      }

      OpenGL.glDisable(3168);
      OpenGL.glDisable(3169);
      this.aGLToolkit4202.method1457(33984, 0);
      this.aClass25_8692.method309(false);
   }

   @Override
   final boolean method3922(byte b) {
      if (b > -44) {
         return false;
      } else {
         ++anInt8683;
         return true;
      }
   }

   public static void method3936(int i) {
      if (i <= 111) {
         method3936(-111);
      }

      aClass192_8685 = null;
   }

   @Override
   final void method3917(Class169 class169, int i, int i_27_) {
      this.aGLToolkit4202.method1444(-2, class169);
      if (i_27_ != -28289) {
         this.method3922((byte)64);
      }

      ++anInt8687;
      this.aGLToolkit4202.method1434((byte)-57, i);
   }

   @Override
   final void method3918(int i) {
      this.aClass25_8692.method310('\u0001', (byte)-48);
      if (i != 20937) {
         aClass192_8685 = null;
      }

      ++anInt8691;
      this.aGLToolkit4202.method1457(i ^ 54537, 1);
      this.aGLToolkit4202.method1444(-2, null);
      this.aGLToolkit4202.method1457(33984, 0);
   }

   @Override
   final void method3923(boolean bool, int i) {
      this.aClass25_8692.method310('\u0000', (byte)-75);
      if (i != 0) {
         anInt8684 = 111;
      }

      ++anInt8682;
      if (this.aClass301_8688.aBoolean3780) {
         this.aGLToolkit4202.method1457(33984, 1);
         this.aGLToolkit4202.method1444(-2, this.aClass301_8688.aClass169_Sub3_3776);
         this.aGLToolkit4202.method1457(33984, 0);
      }
   }

   @Override
   final void method3919(int i, int i_28_, int i_29_) {
      ++anInt8689;
      float f = -5.0E-4F * (float)(1 + (i_29_ & 3));
      float f_30_ = (float)((3 & i_29_ >> 3) + 1) * 5.0E-4F;
      float f_31_ = ~(i_29_ & 64) == -1 ? 4.8828125E-4F : 9.765625E-4F;
      boolean bool = ~(128 & i_29_) != -1;
      this.aGLToolkit4202.method1457(i + 47421, 1);
      if (bool) {
         Class290_Sub11.aFloatArray8183[1] = 0.0F;
         Class290_Sub11.aFloatArray8183[2] = 0.0F;
         Class290_Sub11.aFloatArray8183[0] = f_31_;
         Class290_Sub11.aFloatArray8183[3] = 0.0F;
      } else {
         Class290_Sub11.aFloatArray8183[1] = 0.0F;
         Class290_Sub11.aFloatArray8183[0] = 0.0F;
         Class290_Sub11.aFloatArray8183[3] = 0.0F;
         Class290_Sub11.aFloatArray8183[2] = f_31_;
      }

      OpenGL.glTexGenfv(8192, 9474, Class290_Sub11.aFloatArray8183, 0);
      Class290_Sub11.aFloatArray8183[2] = 0.0F;
      if (i == -13437) {
         Class290_Sub11.aFloatArray8183[1] = f_31_;
         Class290_Sub11.aFloatArray8183[0] = 0.0F;
         Class290_Sub11.aFloatArray8183[3] = (float)this.aGLToolkit4202.anInt6605 * f % 1.0F;
         OpenGL.glTexGenfv(8193, 9474, Class290_Sub11.aFloatArray8183, 0);
         if (!this.aClass301_8688.aBoolean3780) {
            int i_32_ = (int)(16.0F * (float)this.aGLToolkit4202.anInt6605 * f_30_);
            this.aGLToolkit4202.method1444(-2, this.aClass301_8688.aClass169_Sub2Array3779[i_32_ % 16]);
         } else {
            Class290_Sub11.aFloatArray8183[3] = (float)this.aGLToolkit4202.anInt6605 * f_30_ % 1.0F;
            Class290_Sub11.aFloatArray8183[0] = 0.0F;
            Class290_Sub11.aFloatArray8183[1] = 0.0F;
            Class290_Sub11.aFloatArray8183[2] = 0.0F;
            OpenGL.glTexGenfv(8194, 9473, Class290_Sub11.aFloatArray8183, 0);
         }

         this.aGLToolkit4202.method1457(33984, 0);
      }
   }

   static final boolean method3937(byte b, int i, int i_33_) {
      ++anInt8686;
      if (b != -97) {
         return false;
      } else {
         return (2048 & i_33_) != 0 | Class294.method3466(i_33_, b + 96, i) || Node_Sub41.method2932(b ^ 5, i_33_, i);
      }
   }
}
