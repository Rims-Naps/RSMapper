public class Class314 {
   static int anInt4015;
   static int anInt4016;
   static Node_Sub41[] LocalNPCs = new Node_Sub41[1024];
   protected int anInt4018;
   static int anInt4019;
   static int anInt4020;
   protected int anInt4021;
   protected char aChar4022;
   protected int anInt4023;

   public static void method3651(boolean bool) {
      if (!bool) {
         Node_Sub43.aBoolean7231 = bool;
         method3651(true);
      }

      LocalNPCs = null;
   }

   static final void method3652(int i) {
      ++anInt4020;
      int i_0_ = 256 + 512 * Renderer.anInt3663;
      int i_1_ = Node_Sub38_Sub38.anInt10490 * 512 + 256;
      int i_2_ = Node_Sub38_Sub7.getTileMedianHeight(CacheNode_Sub20_Sub1.myPlayerPlane, -29754, i_1_, i_0_) + -Class194.anInt2370;
      if (ItemDefinitions.anInt1858 >= 100) {
         Class98.cameraPosX = 512 * Renderer.anInt3663 + 256;
         Node_Sub10.cameraPosY = 512 * Node_Sub38_Sub38.anInt10490 + 256;
         Class190.cameraHeight = Node_Sub38_Sub7.getTileMedianHeight(CacheNode_Sub20_Sub1.myPlayerPlane, -29754, Node_Sub10.cameraPosY, Class98.cameraPosX)
            - Class194.anInt2370;
      } else {
         if (~Class98.cameraPosX > ~i_0_) {
            Class98.cameraPosX += Class169_Sub3.anInt8821 - -((-Class98.cameraPosX + i_0_) * ItemDefinitions.anInt1858 / 1000);
            if (i_0_ < Class98.cameraPosX) {
               Class98.cameraPosX = i_0_;
            }
         }

         if (i_2_ > Class190.cameraHeight) {
            Class190.cameraHeight += Class169_Sub3.anInt8821 + ItemDefinitions.anInt1858 * (i_2_ + -Class190.cameraHeight) / 1000;
            if (i_2_ < Class190.cameraHeight) {
               Class190.cameraHeight = i_2_;
            }
         }

         if (~i_0_ > ~Class98.cameraPosX) {
            Class98.cameraPosX -= Class169_Sub3.anInt8821 + (-i_0_ + Class98.cameraPosX) * ItemDefinitions.anInt1858 / 1000;
            if (~i_0_ < ~Class98.cameraPosX) {
               Class98.cameraPosX = i_0_;
            }
         }

         if (Class190.cameraHeight > i_2_) {
            Class190.cameraHeight -= Class169_Sub3.anInt8821 + (Class190.cameraHeight - i_2_) * ItemDefinitions.anInt1858 / 1000;
            if (~i_2_ < ~Class190.cameraHeight) {
               Class190.cameraHeight = i_2_;
            }
         }

         if (~Node_Sub10.cameraPosY > ~i_1_) {
            Node_Sub10.cameraPosY += Class169_Sub3.anInt8821 - -((i_1_ - Node_Sub10.cameraPosY) * ItemDefinitions.anInt1858 / 1000);
            if (~i_1_ > ~Node_Sub10.cameraPosY) {
               Node_Sub10.cameraPosY = i_1_;
            }
         }

         if (~Node_Sub10.cameraPosY < ~i_1_) {
            Node_Sub10.cameraPosY -= ItemDefinitions.anInt1858 * (Node_Sub10.cameraPosY + -i_1_) / 1000 + Class169_Sub3.anInt8821;
            if (~i_1_ < ~Node_Sub10.cameraPosY) {
               Node_Sub10.cameraPosY = i_1_;
            }
         }
      }

      i_1_ = 256 + 512 * Class10.anInt174;
      i_0_ = Class238.anInt2911 * 512 + 256;
      i_2_ = Node_Sub38_Sub7.getTileMedianHeight(CacheNode_Sub20_Sub1.myPlayerPlane, -29754, i_1_, i_0_) - Class134_Sub1.anInt9015;
      int i_3_ = i_0_ - Class98.cameraPosX;
      int i_4_ = -Class190.cameraHeight + i_2_;
      int i_5_ = -Node_Sub10.cameraPosY + i_1_;
      int i_6_ = (int)Math.sqrt((double)(i_5_ * i_5_ + i_3_ * i_3_));
      int i_7_ = (int)(2607.5945876176133 * Math.atan2((double)i_4_, (double)i_6_)) & 16383;
      int i_8_ = 16383 & (int)(-2607.5945876176133 * Math.atan2((double)i_3_, (double)i_5_));
      if (~i_7_ > -1025) {
         i_7_ = 1024;
      }

      if (~i_7_ < -3073) {
         i_7_ = 3072;
      }

      if (i >= 39) {
         if (OutgoingPacket.anInt4050 < i_7_) {
            OutgoingPacket.anInt4050 += (-OutgoingPacket.anInt4050 + i_7_ >> 3) * OutgoingPacketBuffer.anInt7116 / 1000 + Node_Sub24.anInt7229 << 3;
            if (i_7_ < OutgoingPacket.anInt4050) {
               OutgoingPacket.anInt4050 = i_7_;
            }
         }

         if (~OutgoingPacket.anInt4050 < ~i_7_) {
            OutgoingPacket.anInt4050 -= Node_Sub24.anInt7229 + OutgoingPacketBuffer.anInt7116 * (OutgoingPacket.anInt4050 + -i_7_ >> 3) / 1000 << 3;
            if (OutgoingPacket.anInt4050 < i_7_) {
               OutgoingPacket.anInt4050 = i_7_;
            }
         }

         int i_9_ = i_8_ + -Class170.anInt2053;
         if (i_9_ > 8192) {
            i_9_ -= 16384;
         }

         if (~i_9_ > 8191) {
            i_9_ += 16384;
         }

         i_9_ >>= 3;
         if (~i_9_ < -1) {
            Class170.anInt2053 += Node_Sub24.anInt7229 - -(OutgoingPacketBuffer.anInt7116 * i_9_ / 1000) << 3;
            Class170.anInt2053 &= 16383;
         }

         if (i_9_ < 0) {
            Class170.anInt2053 -= OutgoingPacketBuffer.anInt7116 * -i_9_ / 1000 + Node_Sub24.anInt7229 << 3;
            Class170.anInt2053 &= 16383;
         }

         int i_10_ = i_8_ + -Class170.anInt2053;
         if (i_10_ > 8192) {
            i_10_ -= 16384;
         }

         if (i_10_ < -8192) {
            i_10_ += 16384;
         }

         Class48.anInt704 = 0;
         if (i_10_ < 0 && i_9_ > 0 || ~i_10_ < -1 && ~i_9_ > -1) {
            Class170.anInt2053 = i_8_;
         }
      }
   }

   private final void method3653(int i, Buffer buffer, boolean bool) {
      if (~i != -2) {
         if (i == 2) {
            this.anInt4021 = buffer.readUnsignedShort();
            this.anInt4018 = buffer.readUnsignedByte();
            this.anInt4023 = buffer.readUnsignedByte();
         }
      } else {
         this.aChar4022 = Class20_Sub1.method294(buffer.readByte(), (byte)108);
      }

      if (!bool) {
         this.anInt4023 = -54;
      }

      ++anInt4019;
   }

   final void method3654(Buffer buffer, int i) {
      if (i == -1050722685) {
         ++anInt4015;

         while(true) {
            int i_11_ = buffer.readUnsignedByte();
            if (i_11_ == 0) {
               break;
            }

            this.method3653(i_11_, buffer, true);
         }
      }
   }
}
