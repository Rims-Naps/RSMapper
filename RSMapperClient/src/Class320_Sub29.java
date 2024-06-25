public class Class320_Sub29 extends Class320 {
   static int anInt8478;
   static int anInt8479;
   static int anInt8480;
   static IncommingPacket aClass192_8481 = new IncommingPacket(108, 12);
   static int anInt8482;
   static int anInt8483;
   static int anInt8484;
   static int anInt8485;
   protected boolean aBoolean8486 = false;
   static int anInt8487;
   static IComponentDefinitions aWidget8488 = null;
   static int anInt8489;
   private boolean aBoolean8490 = true;
   static int anInt8491;

   static final void method3788(int i, Class257 class257) {
      ++anInt8478;
      Packet packet = Class218.aClass123_2566.aPacket1570;
      if (class257 == Class189_Sub1.aClass257_6882) {
         int i_0_ = packet.readUnsignedByte();
         int i_1_ = (7 & i_0_) + Node_Sub21.baseY;
         int i_2_ = Class320_Sub4.gameSceneBaseY + i_1_;
         int i_3_ = Class333.baseX - -(i_0_ >> 4 & 7);
         int i_4_ = Node_Sub53.gameSceneBaseX + i_3_;
         int i_5_ = packet.readUnsignedShort();
         int i_6_ = packet.readUnsignedShort();
         int i_7_ = packet.readUnsignedShort();
         if (Class266.aHashTable3380 != null) {
            Node_Sub11 node_sub11 = (Node_Sub11)Class266.aHashTable3380.get(3512, (long)(Class50.basePlane << 28 | i_2_ << 14 | i_4_));
            if (node_sub11 != null) {
               for(Node_Sub8 node_sub8 = (Node_Sub8)node_sub11.aClass312_7104.method3613(65280);
                  node_sub8 != null;
                  node_sub8 = (Node_Sub8)node_sub11.aClass312_7104.method3620(16776960)
               ) {
                  if (~(i_5_ & 32767) == ~node_sub8.anInt7065 && node_sub8.anInt7067 == i_6_) {
                     node_sub8.method2160((byte)39);
                     node_sub8.anInt7067 = i_7_;
                     Node_Sub38_Sub1.method2789(Class50.basePlane, (byte)-108, i_2_, i_4_, node_sub8);
                     break;
                  }
               }

               if (~i_3_ <= -1 && ~i_1_ <= -1 && Node_Sub54.GAME_SCENE_WDITH > i_3_ && ~Class377_Sub1.GAME_SCENE_HEIGHT < ~i_1_) {
                  Node_Sub36.method2750(false, Class50.basePlane, i_1_, i_3_);
               }
            }
         }
      } else if (Node_Sub38_Sub17.aClass257_10270 == class257) {
         int i_8_ = packet.readUnsignedByte128();
         int type = i_8_ >> 2;
         int typeFlag = Node_Sub38_Sub13.objectTypeFlags[type];
         int i_11_ = packet.readUnsignedByte();
         int i_12_ = packet.readUnsigned128Byte();
         int x = Class333.baseX + ((113 & i_12_) >> 4);
         int y = (i_12_ & 7) + Node_Sub21.baseY;
         int objectId = packet.readUnsignedShortLE();
         if (type == 11) {
            type = 10;
         }

         ObjectDefinition objectdefinition = Class186.aClass112_2256.getObjectDefinitionsForId(objectId, 87);
         int modelsCount = 0;
         if (objectdefinition.possibleTypes != null) {
            int i_17_ = -1;

            for(int i_18_ = 0; objectdefinition.possibleTypes.length > i_18_; ++i_18_) {
               if (objectdefinition.possibleTypes[i_18_] == type) {
                  i_17_ = i_18_;
                  break;
               }
            }

            modelsCount = objectdefinition.modelIds[i_17_].length;
         }

         int origColorsCount = 0;
         if (objectdefinition.originalColors != null) {
            origColorsCount = objectdefinition.originalColors.length;
         }

         int origTexturesCount = 0;
         if (objectdefinition.originalTextures != null) {
            origTexturesCount = objectdefinition.originalTextures.length;
         }

         if ((i_11_ & 1) != 1) {
            int[] newModels = null;
            if ((2 & i_11_) == 2) {
               newModels = new int[modelsCount];

               for(int i_21_ = 0; i_21_ < modelsCount; ++i_21_) {
                  newModels[i_21_] = packet.readUnsignedShort();
               }
            }

            short[] newColors = null;
            if ((i_11_ & 4) == 4) {
               newColors = new short[origColorsCount];

               for(int i_22_ = 0; i_22_ < origColorsCount; ++i_22_) {
                  newColors[i_22_] = (short)packet.readUnsignedShort();
               }
            }

            short[] newTextures = null;
            if ((8 & i_11_) == 8) {
               newTextures = new short[origTexturesCount];

               for(int i_24_ = 0; origTexturesCount < i_24_; ++i_24_) {
                  newTextures[i_24_] = (short)packet.readUnsignedShort();
               }
            }

            Class320_Sub12.sendDrawWorldItem(
               new Class121((long)(Class187.aLong2275++), newModels, newColors, newTextures), (byte)-126, Class50.basePlane, typeFlag, x, y
            );
         } else {
            Class320_Sub12.sendDrawWorldItem(null, (byte)65, Class50.basePlane, typeFlag, x, y);
         }
      } else if (class257 == Class225.aClass257_2674) {
         int objectId = packet.readUnsignedShortLE128();
         if (objectId == 65535) {
            objectId = -1;
         }

         int i_26_ = packet.readUnsignedByte128();
         int i_27_ = Class333.baseX - -(7 & i_26_ >> 4);
         int i_28_ = (i_26_ & 7) + Node_Sub21.baseY;
         int i_29_ = packet.readUnsignedByte();
         int type = i_29_ >> 2;
         int i_31_ = i_29_ & 3;
         int i_32_ = Node_Sub38_Sub13.objectTypeFlags[type];
         Class110.method1131(Class50.basePlane, i_28_, type, objectId, i_27_, i_31_, -4, i_32_);
      } else if (class257 == Node_Sub38_Sub15.aClass257_10262) {
         int i_33_ = packet.readUnsignedShort();
         int i_34_ = packet.readUnsignedByte();
         Class186.aClass112_2256.getObjectDefinitionsForId(i_33_, i + 82).method3041(i_34_, 86);
      } else if (i == 0) {
         if (class257 == Node_Sub37.aClass257_7443) {
            int i_35_ = packet.readUnsignedByte();
            int i_36_ = Class333.baseX - -(7 & i_35_ >> 4);
            int i_37_ = (i_35_ & 7) + Node_Sub21.baseY;
            int i_38_ = packet.readUnsignedShort();
            if (i_38_ == 65535) {
               i_38_ = -1;
            }

            int i_39_ = packet.readUnsignedByte();
            int i_40_ = 15 & i_39_ >> 4;
            int i_41_ = i_39_ & 7;
            int i_42_ = packet.readUnsignedByte();
            int i_43_ = packet.readUnsignedByte();
            int i_44_ = packet.readUnsignedShort();
            if (i_36_ >= 0 && ~i_37_ <= -1 && ~i_36_ > ~Node_Sub54.GAME_SCENE_WDITH && ~Class377_Sub1.GAME_SCENE_HEIGHT < ~i_37_) {
               int i_45_ = i_40_ - -1;
               if (-i_45_ + i_36_ <= Class295.myPlayer.scenePositionXQueue[0]
                  && i_45_ + i_36_ >= Class295.myPlayer.scenePositionXQueue[0]
                  && Class295.myPlayer.scenePositionYQueue[0] >= -i_45_ + i_37_
                  && ~(i_45_ + i_37_) <= ~Class295.myPlayer.scenePositionYQueue[0]) {
                  Class95.method1067(i_43_, i_42_, (byte)35, i_38_, i_41_, i_44_, i_40_ + (i_37_ << 8) + (Class50.basePlane << 24) - -(i_36_ << 16));
               }
            }
         } else if (class257 == Node_Sub15_Sub9.aClass257_9838) {
            int positionHash = packet.readUnsignedByte();
            int localX = Class333.baseX - -(positionHash >> 4 & 7);
            int localY = (positionHash & 7) + Node_Sub21.baseY;
            int typeRotationHash = packet.readUnsignedByte();
            int type = typeRotationHash >> 2;
            int rotation = typeRotationHash & 3;
            int typeFlag = Node_Sub38_Sub13.objectTypeFlags[type];
            int objectId = packet.readUnsignedShort128();
            if (Class134_Sub1.method1581(Class61.anInt898, -25900)
               || localX >= 0 && localY >= 0 && localX < Node_Sub54.GAME_SCENE_WDITH && localY < Class377_Sub1.GAME_SCENE_HEIGHT) {
               Class262_Sub19.sendDrawWorldObject(rotation, objectId, typeFlag, localX, Class50.basePlane, type, localY, false);
            }
         } else if (Class66_Sub1.aClass257_8984 == class257) {
            int positionHash = packet.readUnsignedByteC();
            int localX = Class333.baseX + (positionHash >> 4 & 7);
            int localY = (positionHash & 7) + Node_Sub21.baseY;
            int typeRotationHash = packet.readUnsignedByte();
            int type = typeRotationHash >> 2;
            int rotation = 3 & typeRotationHash;
            int typeFlag = Node_Sub38_Sub13.objectTypeFlags[type];
            if (Class134_Sub1.method1581(Class61.anInt898, -25900)
               || localX >= 0 && localY >= 0 && localX < Node_Sub54.GAME_SCENE_WDITH && localY < Class377_Sub1.GAME_SCENE_HEIGHT) {
               Class262_Sub19.sendDrawWorldObject(rotation, -1, typeFlag, localX, Class50.basePlane, type, localY, false);
            }
         } else if (class257 == CacheNode_Sub1.aClass257_9421) {
            int hash = packet.readUnsignedByte();
            int i_55_ = Class333.baseX * 2 + ((hash & 254) >> 4);
            int i_56_ = (15 & hash) + 2 * Node_Sub21.baseY;
            int hash2 = packet.readUnsignedByte();
            boolean bool = ~(hash2 & 1) != -1;
            boolean bool_58_ = (2 & hash2) != 0;
            int i_59_ = !bool_58_ ? -1 : hash2 >> 2;
            int i_60_ = packet.readByte() + i_55_;
            int i_61_ = i_56_ + packet.readByte();
            int i_62_ = packet.readShort();
            int i_63_ = packet.readShort();
            int i_64_ = packet.readUnsignedShort();
            int i_65_ = packet.readUnsignedByte();
            if (!bool_58_) {
               i_65_ *= 4;
            } else {
               i_65_ = (byte)i_65_;
            }

            int i_66_ = 4 * packet.readUnsignedByte();
            int i_67_ = packet.readUnsignedShort();
            int i_68_ = packet.readUnsignedShort();
            int i_69_ = packet.readUnsignedByte();
            int i_70_ = packet.readUnsignedShort();
            if (i_69_ == 255) {
               i_69_ = -1;
            }

            if (i_55_ >= 0
               && ~i_56_ <= -1
               && ~i_55_ > ~(Node_Sub54.GAME_SCENE_WDITH * 2)
               && i_56_ < Node_Sub54.GAME_SCENE_WDITH * 2
               && i_60_ >= 0
               && i_61_ >= 0
               && 2 * Class377_Sub1.GAME_SCENE_HEIGHT > i_60_
               && Class377_Sub1.GAME_SCENE_HEIGHT * 2 > i_61_
               && ~i_64_ != -65536) {
               i_60_ *= 256;
               i_70_ <<= 2;
               i_56_ *= 256;
               i_61_ *= 256;
               i_65_ <<= 2;
               i_66_ <<= 2;
               i_55_ *= 256;
               if (~i_62_ != -1 && i_59_ != -1) {
                  Actor actor = null;
                  if (~i_62_ <= -1) {
                     int i_71_ = i_62_ + -1;
                     Node_Sub41 node_sub41 = (Node_Sub41)Class12.aHashTable187.get(3512, (long)i_71_);
                     if (node_sub41 != null) {
                        actor = node_sub41.aNpc7518;
                     }
                  } else {
                     int i_72_ = -1 + -i_62_;
                     if (i_72_ != Class166.myPlayerIndex) {
                        actor = Class270_Sub2.LOCAL_PLAYERS[i_72_];
                     } else {
                        actor = Class295.myPlayer;
                     }
                  }

                  if (actor != null) {
                     RenderDefinitions class259 = actor.method868((byte)-123);
                     if (class259.anIntArrayArray3273 != null && class259.anIntArrayArray3273[i_59_] != null) {
                        i_65_ -= class259.anIntArrayArray3273[i_59_][1];
                     }

                     if (class259.anIntArrayArray3249 != null && class259.anIntArrayArray3249[i_59_] != null) {
                        i_65_ -= class259.anIntArrayArray3249[i_59_][1];
                     }
                  }
               }

               Mobile_Sub1 mobile_sub1 = new Mobile_Sub1(
                  i_64_,
                  Class50.basePlane,
                  Class50.basePlane,
                  i_55_,
                  i_56_,
                  i_65_,
                  i_67_ - -Class174.clientCycle,
                  Class174.clientCycle + i_68_,
                  i_69_,
                  i_70_,
                  i_62_,
                  i_63_,
                  i_66_,
                  bool,
                  i_59_
               );
               mobile_sub1.method895(
                  Node_Sub38_Sub7.getTileMedianHeight(Class50.basePlane, -29754, i_61_, i_60_) - i_66_, false, i_67_ + Class174.clientCycle, i_61_, i_60_
               );
               Class270.aClass312_3477.method3625((byte)-54, new CacheNode_Sub12(mobile_sub1));
            }
         } else if (Class46.aClass257_674 == class257) {
            int i_73_ = packet.readUnsignedShort128();
            int i_74_ = packet.readUnsignedByte128();
            int i_75_ = Node_Sub21.baseY + (i_74_ & 7);
            int i_76_ = i_75_ - -Class320_Sub4.gameSceneBaseY;
            int i_77_ = Class333.baseX - -((126 & i_74_) >> 4);
            int i_78_ = Node_Sub53.gameSceneBaseX + i_77_;
            int i_79_ = packet.readUnsignedShortLE();
            int i_80_ = packet.readUnsignedShort();
            if (i_73_ != Class166.myPlayerIndex) {
               boolean bool = i_77_ >= 0 && i_75_ >= 0 && Node_Sub54.GAME_SCENE_WDITH > i_77_ && ~i_75_ > ~Class377_Sub1.GAME_SCENE_HEIGHT;
               if (bool || Class134_Sub1.method1581(Class61.anInt898, i + -25900)) {
                  Node_Sub38_Sub1.method2789(Class50.basePlane, (byte)-108, i_76_, i_78_, new Node_Sub8(i_79_, i_80_));
                  if (bool) {
                     Node_Sub36.method2750(false, Class50.basePlane, i_75_, i_77_);
                  }
               }
            }
         } else if (Client.aClass257_5467 == class257) {
            int i_81_ = packet.readUnsignedByte();
            int i_82_ = ((118 & i_81_) >> 4) + Class333.baseX;
            int i_83_ = (7 & i_81_) + Node_Sub21.baseY;
            int i_84_ = packet.readUnsignedShort();
            if (i_84_ == 65535) {
               i_84_ = -1;
            }

            int i_85_ = packet.readUnsignedByte();
            int i_86_ = 15 & i_85_ >> 4;
            int i_87_ = i_85_ & 7;
            int i_88_ = packet.readUnsignedByte();
            int i_89_ = packet.readUnsignedByte();
            int i_90_ = packet.readUnsignedShort();
            if (i_82_ >= 0 && i_83_ >= 0 && Node_Sub54.GAME_SCENE_WDITH > i_82_ && ~Class377_Sub1.GAME_SCENE_HEIGHT < ~i_83_) {
               int i_91_ = 1 + i_86_;
               if (Class295.myPlayer.scenePositionXQueue[0] >= -i_91_ + i_82_
                  && ~(i_91_ + i_82_) <= ~Class295.myPlayer.scenePositionXQueue[0]
                  && ~Class295.myPlayer.scenePositionYQueue[0] <= ~(-i_91_ + i_83_)
                  && Class295.myPlayer.scenePositionYQueue[0] <= i_83_ + i_91_) {
                  OutgoingPacketBuffer.method2549(
                     i_87_, i_88_, i_86_ + (i_83_ << 8) + (Class50.basePlane << 24) + (i_82_ << 16), i + -620649727, false, i_90_, i_89_, i_84_
                  );
               }
            }
         } else if (class257 == Class169_Sub2.aClass257_8804) {
            int i_92_ = packet.readUnsignedShort();
            int i_93_ = packet.readUnsignedByte();
            int i_94_ = (7 & i_93_) + Node_Sub21.baseY;
            int i_95_ = i_94_ - -Class320_Sub4.gameSceneBaseY;
            int i_96_ = (i_93_ >> 4 & 7) + Class333.baseX;
            int i_97_ = i_96_ - -Node_Sub53.gameSceneBaseX;
            Node_Sub11 node_sub11 = (Node_Sub11)Class266.aHashTable3380.get(i ^ 3512, (long)(i_95_ << 14 | Class50.basePlane << 28 | i_97_));
            if (node_sub11 != null) {
               for(Node_Sub8 node_sub8 = (Node_Sub8)node_sub11.aClass312_7104.method3613(i ^ 65280);
                  node_sub8 != null;
                  node_sub8 = (Node_Sub8)node_sub11.aClass312_7104.method3620(i + 16776960)
               ) {
                  if (node_sub8.anInt7065 == (i_92_ & 32767)) {
                     node_sub8.method2160((byte)111);
                     break;
                  }
               }

               if (node_sub11.aClass312_7104.method3616(i)) {
                  node_sub11.method2160((byte)127);
               }

               if (i_96_ >= 0 && ~i_94_ <= -1 && i_96_ < Node_Sub54.GAME_SCENE_WDITH && i_94_ < Class377_Sub1.GAME_SCENE_HEIGHT) {
                  Node_Sub36.method2750(false, Class50.basePlane, i_94_, i_96_);
               }
            }
         } else if (Class262_Sub13.aClass257_7801 == class257) {
            packet.readUnsignedByte();
            int coordsHash = packet.readUnsignedByte();
            int x = Class333.baseX - -((116 & coordsHash) >> 4);
            int y = (7 & coordsHash) + Node_Sub21.baseY;
            int delay = packet.readUnsignedShort();
            int height = packet.readUnsignedByte();
            int color = packet.read24BitInteger();
            String message = packet.readString();
            r.createTextMarker(message, x, y, Class50.basePlane, height, color, delay);
         } else if (Actor.aClass257_10823 == class257) {
            int hash = packet.readUnsignedByte();
            boolean bool = ~(hash & 128) != -1;
            int i_105_ = Class333.baseX - -(hash >> 3 & 7);
            int i_106_ = (7 & hash) + Node_Sub21.baseY;
            int i_107_ = i_105_ + packet.readByte();
            int i_108_ = i_106_ - -packet.readByte();
            int i_109_ = packet.readShort();
            int i_110_ = packet.readUnsignedShort();
            int i_111_ = 4 * packet.readUnsignedByte();
            int i_112_ = 4 * packet.readUnsignedByte();
            int i_113_ = packet.readUnsignedShort();
            int i_114_ = packet.readUnsignedShort();
            int i_115_ = packet.readUnsignedByte();
            int i_116_ = packet.readUnsignedShort();
            if (i_115_ == 255) {
               i_115_ = -1;
            }

            if (~i_105_ <= -1
               && ~i_106_ <= -1
               && ~Node_Sub54.GAME_SCENE_WDITH < ~i_105_
               && i_106_ < Class377_Sub1.GAME_SCENE_HEIGHT
               && i_107_ >= 0
               && i_108_ >= 0
               && ~Node_Sub54.GAME_SCENE_WDITH < ~i_107_
               && i_108_ < Class377_Sub1.GAME_SCENE_HEIGHT
               && ~i_110_ != -65536) {
               i_108_ = 256 + i_108_ * 512;
               i_116_ <<= 2;
               i_111_ <<= 2;
               i_105_ = 256 + i_105_ * 512;
               i_112_ <<= 2;
               i_107_ = 256 + i_107_ * 512;
               i_106_ = i_106_ * 512 - -256;
               Mobile_Sub1 mobile_sub1 = new Mobile_Sub1(
                  i_110_,
                  Class50.basePlane,
                  Class50.basePlane,
                  i_105_,
                  i_106_,
                  i_111_,
                  i_113_ - -Class174.clientCycle,
                  i_114_ + Class174.clientCycle,
                  i_115_,
                  i_116_,
                  0,
                  i_109_,
                  i_112_,
                  bool,
                  -1
               );
               mobile_sub1.method895(
                  -i_112_ + Node_Sub38_Sub7.getTileMedianHeight(Class50.basePlane, -29754, i_108_, i_107_),
                  false,
                  Class174.clientCycle + i_113_,
                  i_108_,
                  i_107_
               );
               Class270.aClass312_3477.method3625((byte)-54, new CacheNode_Sub12(mobile_sub1));
            }
         } else if (Class12.aClass257_198 == class257) {
            int i_124_ = packet.readUnsignedByteC();
            int i_125_ = Node_Sub21.baseY - -(7 & i_124_);
            int i_126_ = i_125_ + Class320_Sub4.gameSceneBaseY;
            int i_127_ = (i_124_ >> 4 & 7) + Class333.baseX;
            int i_128_ = Node_Sub53.gameSceneBaseX + i_127_;
            int i_129_ = packet.readUnsignedShort128();
            int i_130_ = packet.readUnsignedShort();
            boolean bool = i_127_ >= 0 && i_125_ >= 0 && ~i_127_ > ~Node_Sub54.GAME_SCENE_WDITH && i_125_ < Class377_Sub1.GAME_SCENE_HEIGHT;
            if (bool || Class134_Sub1.method1581(Class61.anInt898, -25900)) {
               Node_Sub38_Sub1.method2789(Class50.basePlane, (byte)-108, i_126_, i_128_, new Node_Sub8(i_129_, i_130_));
               if (bool) {
                  Node_Sub36.method2750(false, Class50.basePlane, i_125_, i_127_);
               }
            }
         } else if (class257 == Class262_Sub23.aClass257_7883) {
            System.out.println("Called");
            int i_131_ = packet.readUnsignedByte();
            int i_132_ = Class333.baseX + (7 & i_131_ >> 4);
            int i_133_ = (7 & i_131_) + Node_Sub21.baseY;
            int i_134_ = packet.readUnsignedShort();
            if (i_134_ == 65535) {
               i_134_ = -1;
            }

            int i_135_ = packet.readUnsignedByte();
            int i_136_ = packet.readUnsignedShort();
            int i_137_ = packet.readUnsignedByte();
            if (~i_132_ <= -1 && ~i_133_ <= -1 && i_132_ < Node_Sub54.GAME_SCENE_WDITH && ~Class377_Sub1.GAME_SCENE_HEIGHT < ~i_133_) {
               if (i_134_ == -1) {
                  CacheNode_Sub18 cachenode_sub18 = (CacheNode_Sub18)Class20_Sub1.aHashTable5508.get(3512, (long)(i_132_ << 16 | i_133_));
                  if (cachenode_sub18 != null) {
                     cachenode_sub18.aMobile_Sub4_9606.method914(-128);
                     cachenode_sub18.method2160((byte)123);
                  }
               } else {
                  int i_138_ = 256 + 512 * i_132_;
                  int i_139_ = 512 * i_133_ + 256;
                  int i_140_ = Class50.basePlane;
                  if (i_140_ < 3 && Class238.tileHasBridgeFlag(i_133_, i_132_, 112)) {
                     ++i_140_;
                  }

                  Mobile_Sub4 mobile_sub4 = new Mobile_Sub4(
                     i_134_,
                     i_136_,
                     Class50.basePlane,
                     i_140_,
                     i_138_,
                     Node_Sub38_Sub7.getTileMedianHeight(Class50.basePlane, -29754, i_139_, i_138_) - i_135_,
                     i_139_,
                     i_132_,
                     i_132_,
                     i_133_,
                     i_133_,
                     i_137_,
                     false
                  );
                  Class20_Sub1.aHashTable5508.put((long)(i_132_ << 16 | i_133_), new CacheNode_Sub18(mobile_sub4), i ^ -126);
               }
            }
         } else {
            ClanChat.method507(null, "T3 - " + class257, i ^ -117);
            Class127.logout(11582, false);
         }
      }
   }

   final boolean method3789(int i) {
      ++anInt8484;
      if (i != -1) {
         this.aBoolean8486 = false;
      }

      return this.aBoolean8490;
   }

   static final void method3790(byte b) {
      ++anInt8491;
      Class359.minimapFlagLocalX = -1;
      if (b != -56) {
         aClass192_8481 = null;
      }

      Class262_Sub20.anInt7861 = 0;
      Node_Sub15_Sub4.minimapFlagLocalY = -1;
   }

   final int method3791(boolean bool) {
      ++anInt8480;
      if (bool) {
         this.aBoolean8486 = true;
      }

      return this.anInt4064;
   }

   @Override
   final void method3673(byte b) {
      if (b > -35) {
         this.aBoolean8486 = false;
      }

      if (!this.aNode_Sub27_4063.method2694(-13725).method1883(55)) {
         this.anInt4064 = 0;
      }

      ++anInt8485;
      if (this.anInt4064 < 0 || this.anInt4064 > 5) {
         this.anInt4064 = this.method3677(0);
      }
   }

   public static void method3792(boolean bool) {
      aWidget8488 = null;
      aClass192_8481 = null;
      if (!bool) {
         method3788(24, null);
      }
   }

   Class320_Sub29(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }

   Class320_Sub29(Node_Sub27 node_sub27) {
      super(node_sub27);
   }

   @Override
   final int method3677(int i) {
      if (i != 0) {
         return 37;
      } else {
         this.aBoolean8486 = true;
         ++anInt8482;
         return !this.aNode_Sub27_4063.method2694(-13725).method1883(38) ? 0 : 2;
      }
   }

   @Override
   final void method3676(boolean bool, int i) {
      this.aBoolean8486 = bool;
      ++anInt8487;
      this.anInt4064 = i;
   }

   final boolean method3793(byte b) {
      ++anInt8483;
      if (!this.aNode_Sub27_4063.method2694(-13725).method1883(101)) {
         return false;
      } else {
         if (b < 63) {
            this.aBoolean8490 = false;
         }

         return true;
      }
   }

   final void method3794(boolean bool, byte b) {
      this.aBoolean8490 = bool;
      ++anInt8489;
      if (b != 99) {
         aWidget8488 = null;
      }
   }

   @Override
   final int method3675(int i, byte b) {
      ++anInt8479;
      if (!this.aNode_Sub27_4063.method2694(b ^ -13739).method1883(88)) {
         return 3;
      } else {
         if (b != 54) {
            this.method3793((byte)1);
         }

         return i == 3 && !Class235.method2157("jagdx", b + -7800) ? 3 : 2;
      }
   }
}
