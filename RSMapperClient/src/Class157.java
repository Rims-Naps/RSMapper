import jaggl.OpenGL;
import java.net.InetAddress;

public class Class157 {
   static int anInt1972;
   static byte[] aByteArray1973 = new byte[520];
   static int anInt1974;
   static int anInt1975;
   private Class312 aClass312_1976;
   static int anInt1977;
   static int anInt1978;
   static int anInt1979;
   private Node aNode1980;
   static double aDouble1981;
   static int anInt1982;

   static final Class106 method1709(GLXToolkit glxtoolkit, int i, int i_0_, byte[] bs) {
      ++anInt1982;
      if (bs == null) {
         return null;
      } else if (i_0_ > -55) {
         InetAddress ip = null;
         return null;
      } else {
         int i_1_ = OpenGL.glGenProgramARB();
         OpenGL.glBindProgramARB(i, i_1_);
         OpenGL.glProgramRawARB(i, 34933, bs);
         OpenGL.glGetIntegerv(34379, Class297.anIntArray3703, 0);
         if (Class297.anIntArray3703[0] != -1) {
            OpenGL.glBindProgramARB(i, 0);
            return null;
         } else {
            OpenGL.glBindProgramARB(i, 0);
            return new Class106(glxtoolkit, i, i_1_);
         }
      }
   }

   static final void method1710(int i, int screenSizeSettingRelated1, boolean bool, int canvasSizeY, int canvasSizeX, int screenSizeSettingRelated2) {
      ++anInt1978;
      if (Class175.aClass261ArrayArrayArray2099 == null) {
         Class93.aGraphicsToolkit1241.method1239(canvasSizeY, canvasSizeX, screenSizeSettingRelated1, (byte)116, screenSizeSettingRelated2, -16777216);
      } else {
         boolean bool_6_ = false;
         if (aa.anInt101 == 0) {
            if (Class295.myPlayer.x < 0
               || ~Class295.myPlayer.x <= ~(512 * Node_Sub54.GAME_SCENE_WDITH)
               || Class295.myPlayer.y < 0
               || Class295.myPlayer.y >= Class377_Sub1.GAME_SCENE_HEIGHT * 512) {
               bool_6_ = true;
            }
         } else if (!Class320_Sub18.aBoolean8375) {
            bool_6_ = true;
         }

         if (bool_6_) {
            Class93.aGraphicsToolkit1241.method1239(canvasSizeY, canvasSizeX, screenSizeSettingRelated1, (byte)116, screenSizeSettingRelated2, -16777216);
         } else {
            ++Class110.anInt1412;
            if (Class295.myPlayer != null
               && ~(Class295.myPlayer.x + -(256 * Class295.myPlayer.getSize((byte)45)) + 256 >> 9) == ~Class359.minimapFlagLocalX
               && ~(Class295.myPlayer.y + -(256 * (Class295.myPlayer.getSize((byte)48) + -1)) >> 9) == ~Node_Sub15_Sub4.minimapFlagLocalY) {
               Class359.minimapFlagLocalX = -1;
               Node_Sub15_Sub4.minimapFlagLocalY = -1;
               NpcDefinition.method3002((byte)97);
            }

            Class377.method4125(96);
            if (i > -40) {
               aByteArray1973 = null;
            }

            if (!bool) {
               Class320_Sub24.method3774(-51);
            }

            Class34_Sub1.method375(screenSizeSettingRelated2, true, screenSizeSettingRelated1, canvasSizeX, (byte)-95, canvasSizeY);
            screenSizeSettingRelated2 = Class22.anInt428;
            canvasSizeY = Class132.anInt1684;
            Class308.anInt3912 = Class308.orthoZoom;
            screenSizeSettingRelated1 = Mobile_Sub2.anInt10722;
            canvasSizeX = Class111.anInt1418;
            if (~Class320_Sub22.anInt8415 == -2) {
               int verticalRotation = (int)Class257.cameraRotationVertical;
               if (Class200_Sub1.anInt5145 >> 8 > verticalRotation) {
                  verticalRotation = Class200_Sub1.anInt5145 >> 8;
               }

               if (Plane.aBooleanArray3401[4] && verticalRotation < Class262_Sub3.anIntArray7713[4] + 128) {
                  verticalRotation = Class262_Sub3.anIntArray7713[4] + 128;
               }

               int horizontalRotation = (int)Node_Sub12.cameraRotationHorizontal & 16383;
               int playerHeight = Node_Sub38_Sub7.getTileMedianHeight(CacheNode_Sub20_Sub1.myPlayerPlane, -29754, Class295.myPlayer.y, Class295.myPlayer.x);
               Node_Sub23.setCameraVariables(
                  verticalRotation,
                  (verticalRotation >> 3) * Constants.ZOOM_MODIFIER + 600 << 2,
                  canvasSizeX,
                  101,
                  Mobile_Sub4.playerPositionX,
                  horizontalRotation,
                  Class25.playerPositionY,
                  playerHeight + 200
               );
            } else if (~Class320_Sub22.anInt8415 == -5) {
               int i_9_ = (int)Class257.cameraRotationVertical;
               if (~(Class200_Sub1.anInt5145 >> 8) < ~i_9_) {
                  i_9_ = Class200_Sub1.anInt5145 >> 8;
               }

               if (Plane.aBooleanArray3401[4] && ~(Class262_Sub3.anIntArray7713[4] - -128) < ~i_9_) {
                  i_9_ = 128 + Class262_Sub3.anIntArray7713[4];
               }

               int i_10_ = 16383 & (int)Node_Sub12.cameraRotationHorizontal;
               Node_Sub23.setCameraVariables(
                  i_9_,
                  (i_9_ >> 3) * Constants.ZOOM_MODIFIER + 600 << 2,
                  canvasSizeX,
                  76,
                  Mobile_Sub4.playerPositionX,
                  i_10_,
                  Class25.playerPositionY,
                  -200 + Node_Sub38_Sub7.getTileMedianHeight(CacheNode_Sub20_Sub1.myPlayerPlane, -29754, Node_Sub19.anInt7173, Class234.anInt2792)
               );
            } else if (~Class320_Sub22.anInt8415 == -6) {
               Node_Sub10.method2537(canvasSizeX, false);
            }

            int i_11_ = Class98.cameraPosX;
            int i_12_ = Class190.cameraHeight;
            int i_13_ = Node_Sub10.cameraPosY;
            int i_14_ = OutgoingPacket.anInt4050;
            int i_15_ = Class170.anInt2053;

            for(int i_16_ = 0; i_16_ < 5; ++i_16_) {
               if (Plane.aBooleanArray3401[i_16_]) {
                  int i_17_ = (int)(
                     (double)(-Class173.anIntArray2091[i_16_])
                        + (double)(2 * Class173.anIntArray2091[i_16_] + 1) * Math.random()
                        + Math.sin((double)Class193.anIntArray2362[i_16_] / 100.0 * (double)Class320_Sub7.anIntArray8271[i_16_])
                           * (double)Class262_Sub3.anIntArray7713[i_16_]
                  );
                  if (~i_16_ == -4) {
                     Class170.anInt2053 = 16383 & i_17_ + Class170.anInt2053;
                  }

                  if (i_16_ == 0) {
                     Class98.cameraPosX += i_17_ << 2;
                  }

                  if (~i_16_ == -2) {
                     Class190.cameraHeight += i_17_ << 2;
                  }

                  if (~i_16_ == -3) {
                     Node_Sub10.cameraPosY += i_17_ << 2;
                  }

                  if (~i_16_ == -5) {
                     OutgoingPacket.anInt4050 += i_17_;
                     if (OutgoingPacket.anInt4050 >= 1024) {
                        if (OutgoingPacket.anInt4050 > 3072) {
                           OutgoingPacket.anInt4050 = 3072;
                        }
                     } else {
                        OutgoingPacket.anInt4050 = 1024;
                     }
                  }
               }
            }

            if (~Class98.cameraPosX > -1) {
               Class98.cameraPosX = 0;
            }

            if (~Node_Sub10.cameraPosY > -1) {
               Node_Sub10.cameraPosY = 0;
            }

            if (~Class98.cameraPosX < ~((Class328.SCENE_WIDTH_X << 9) + -1)) {
               Class98.cameraPosX = -1 + (Class328.SCENE_WIDTH_X << 9);
            }

            if (Node_Sub10.cameraPosY > -1 + (Node_Sub50.SCENE_WIDTH_Y << 9)) {
               Node_Sub10.cameraPosY = (Node_Sub50.SCENE_WIDTH_Y << 9) + -1;
            }

            Class194_Sub2.method1972(4);
            Class93.aGraphicsToolkit1241
               .KA(screenSizeSettingRelated2, screenSizeSettingRelated1, canvasSizeY + screenSizeSettingRelated2, screenSizeSettingRelated1 + canvasSizeX);
            Class377_Sub1.method4130(true, -10385);
            int i_18_ = Class138.anInt1726;
            Class290_Sub6.aClass336_8114
               .method3864(
                  Class98.cameraPosX,
                  Class190.cameraHeight,
                  Node_Sub10.cameraPosY,
                  16383 & -OutgoingPacket.anInt4050,
                  -Class170.anInt2053 & 16383,
                  16383 & -Class48.anInt704
               );
            Class93.aGraphicsToolkit1241.a(Class290_Sub6.aClass336_8114);
            Class93.aGraphicsToolkit1241
               .DA(
                  canvasSizeY / 2 + screenSizeSettingRelated2,
                  canvasSizeX / 2 + screenSizeSettingRelated1,
                  Class339_Sub6.anInt8713 << 1,
                  Class339_Sub6.anInt8713 << 1
               );
            if (!Class71.aBoolean967) {
               if (Class245.aClass119_3085 == null) {
                  Class93.aGraphicsToolkit1241.GA(i_18_);
                  Class93.aGraphicsToolkit1241.ya();
               } else {
                  Class93.aGraphicsToolkit1241.xa(1.0F);
                  Class93.aGraphicsToolkit1241.ZA(16777215, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F);
                  Class245.aClass119_3085
                     .method1216(
                        true,
                        screenSizeSettingRelated1,
                        Class93.aGraphicsToolkit1241,
                        Class170.anInt2053,
                        canvasSizeY,
                        i_18_,
                        Class48.anInt704,
                        canvasSizeX,
                        screenSizeSettingRelated2,
                        Class235.anInt5127 << 3,
                        OutgoingPacket.anInt4050,
                        false,
                        (byte)-32
                     );
               }
            } else {
               Class254.method3108(Class138.anInt1726, 4);
               if (Class92.anInt1235 != Class308.anInt3912) {
                  Class194_Sub1.aBoolean6892 = true;
               }

               Class92.anInt1235 = Class308.anInt3912;
               Class93.aGraphicsToolkit1241.GA(i_18_);
               Class93.aGraphicsToolkit1241.ya();
            }

            CacheNode_Sub16_Sub1.method2387((byte)-114);
            Class320_Sub24.method3772(
               Class339_Sub6.anInt8713 << 1,
               (byte)-27,
               canvasSizeX / 2 + screenSizeSettingRelated1,
               Class339_Sub6.anInt8713 << 1,
               screenSizeSettingRelated2 - -(canvasSizeY / 2)
            );
            Class329.method3836(
               16383 & -Class170.anInt2053,
               327263118,
               Node_Sub10.cameraPosY,
               -Class48.anInt704 & 16383,
               Class190.cameraHeight,
               -OutgoingPacket.anInt4050 & 16383,
               Class98.cameraPosX
            );
            Class89.method1022(false);
            byte b = ~Class213.aNode_Sub27_2512.aClass320_Sub4_7304.method3694(false) != -3 ? 1 : (byte)Class110.anInt1412;
            if (Class71.aBoolean967) {
               Class291_Sub1.method3454(16383 & -Class170.anInt2053, 16383 & -Class48.anInt704, -OutgoingPacket.anInt4050 & 16383, 128);
               Class251.method3099(
                  b,
                  Class98.cameraPosX,
                  Node_Sub10.cameraPosY,
                  Class190.cameraHeight,
                  Class295.myPlayer.y >> 9,
                  Class246.anIntArray3107,
                  Class362.anIntArray4497,
                  Class174.clientCycle,
                  1 + Class295.myPlayer.plane,
                  RenderDefinitions.anIntArray3296,
                  Class213.aNode_Sub27_2512.aClass320_Sub8_7280.method3712(false) == 0,
                  true,
                  Class308.anInt3912,
                  MainFile.anIntArray135,
                  Node_Sub38_Sub15.aByteArrayArrayArray10261,
                  Class84.anIntArray1147,
                  Class295.myPlayer.x >> 9,
                  1
               );
            } else {
               Class151.method1671(
                  Class174.clientCycle,
                  Class295.myPlayer.x,
                  Class190.cameraHeight,
                  Class295.myPlayer.y,
                  Node_Sub38_Sub15.aByteArrayArrayArray10261,
                  RenderDefinitions.anIntArray3296,
                  MainFile.anIntArray135,
                  Class246.anIntArray3107,
                  Class84.anIntArray1147,
                  Class362.anIntArray4497,
                  1 + Class295.myPlayer.plane,
                  b,
                  Class295.myPlayer.x >> 9,
                  Class295.myPlayer.y >> 9,
                  ~Class213.aNode_Sub27_2512.aClass320_Sub8_7280.method3712(false) == -1,
                  true,
                  !Node_Sub15_Sub10.aBoolean9850 ? -1 : Class308.anInt3912,
                  0,
                  false
               );
            }

            CacheNode_Sub16_Sub1.method2387((byte)-114);
            if (Class151.anInt1843 == 11) {
               RSMapperClient.editor.tool.createTileMarkers();
               Class262_Sub6.drawTileMarkers((byte)55, canvasSizeY, 256, canvasSizeX, 256, screenSizeSettingRelated1, screenSizeSettingRelated2);
               Class339_Sub7.method3942(screenSizeSettingRelated1, canvasSizeY, 256, 256, screenSizeSettingRelated2, canvasSizeX, true);
               Class127.drawHintIcons(3, 256, 256, canvasSizeY, screenSizeSettingRelated1, screenSizeSettingRelated2, canvasSizeX);
               Class150_Sub1.drawClickedSprite(canvasSizeY, screenSizeSettingRelated2, 16427, screenSizeSettingRelated1, canvasSizeX);
            }

            Npc.method874();
            Node_Sub10.cameraPosY = i_13_;
            Class98.cameraPosX = i_11_;
            OutgoingPacket.anInt4050 = i_14_;
            Class190.cameraHeight = i_12_;
            Class170.anInt2053 = i_15_;
            Node_Sub36_Sub1.aBoolean10030 = false;
            if (Class230.aBoolean5214 && ~Class267.aClass266_3449.method3236(0) == -1) {
               Class230.aBoolean5214 = false;
            }

            if (Class230.aBoolean5214) {
               Class93.aGraphicsToolkit1241.method1239(canvasSizeY, canvasSizeX, screenSizeSettingRelated1, (byte)116, screenSizeSettingRelated2, -16777216);
               Class169_Sub3.method1779(
                  Class93.aGraphicsToolkit1241,
                  Class22.aClass22_375.getStoredString(Class35.language),
                  false,
                  Class169_Sub3.aClass357_8820,
                  StandardSprite.aClass52_8945,
                  -16777216
               );
            }

            Class377_Sub1.method4130(false, -10385);
         }
      }
   }

   public static void method1711(int i) {
      if (i >= 45) {
         aByteArray1973 = null;
      }
   }

   public Class157() {
   }

   Class157(Class312 class312) {
      this.aClass312_1976 = class312;
   }

   public static String method09671() {
      return Class141.method1698(Class54.aBoolean817 ? null : "", 19);
   }

   static final Node_Sub38 method1712(int i, Buffer buffer) {
      buffer.readUnsignedByte();
      ++anInt1977;
      int i_19_ = buffer.readUnsignedByte();
      Node_Sub38 node_sub38 = Class52.method530(i_19_, 83);
      if (i >= -56) {
         return null;
      } else {
         node_sub38.anInt7450 = buffer.readUnsignedByte();
         int i_20_ = buffer.readUnsignedByte();

         for(int i_21_ = 0; i_20_ > i_21_; ++i_21_) {
            int i_22_ = buffer.readUnsignedByte();
            node_sub38.method2780(false, buffer, i_22_);
         }

         node_sub38.method2785(7);
         return node_sub38;
      }
   }

   final Node method1713(byte b) {
      ++anInt1974;
      if (b != -34) {
         return null;
      } else {
         Node node = this.aNode1980;
         if (this.aClass312_1976.aNode3958 == node) {
            this.aNode1980 = null;
            return null;
         } else {
            this.aNode1980 = node.aNode2800;
            return node;
         }
      }
   }

   final Node method1714(int i) {
      ++anInt1975;
      Node node = this.aClass312_1976.aNode3958.aNode2800;
      if (this.aClass312_1976.aNode3958 == node) {
         this.aNode1980 = null;
         return null;
      } else {
         this.aNode1980 = node.aNode2800;
         if (i != 2) {
            aByteArray1973 = null;
         }

         return node;
      }
   }

   final void method1715(Class312 class312, int i) {
      if (i < 34) {
         aByteArray1973 = null;
      }

      this.aClass312_1976 = class312;
      ++anInt1979;
   }
}
