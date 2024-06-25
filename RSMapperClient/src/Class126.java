import jagex3.jagmisc.jagmisc;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Class126 {
   static int anInt1611;
   private int anInt1612;
   static int anInt1613;
   static int anInt1614;
   static int anInt1615;
   static int anInt1616;
   private Class372 aClass372_1617;
   static int anInt1618;
   static int anInt1619;
   static Class126 aClass126_1620 = new Class126(0, 3, Class372.aClass372_4598);
   protected int anInt1621;
   static int anInt1622;
   static int anInt1623;
   protected int anInt1624;
   static Class126 aClass126_1625 = new Class126(1, 3, Class372.aClass372_4598);
   static Class126 aClass126_1626 = new Class126(2, 4, Class372.aClass372_4594);
   static Class126 aClass126_1627 = new Class126(3, 1, Class372.aClass372_4598);
   static Class126 aClass126_1628 = new Class126(4, 2, Class372.aClass372_4598);
   static Class126 aClass126_1629 = new Class126(5, 3, Class372.aClass372_4598);
   static Class126 aClass126_1630 = new Class126(6, 4, Class372.aClass372_4598);
   static int anInt1631 = Node_Sub38_Sub20.method2855(16, (byte)-71);
   static OutgoingPacket aClass318_1632 = new OutgoingPacket(34, 4);
   static IncommingPacket aClass192_1633 = new IncommingPacket(34, 6);
   static int anInt1634;

   static final void method1532(int i) {
      if (Class93.aGraphicsToolkit1241 != null) {
         if (Class71.aBoolean967) {
            Class94.method1065(113);
         }

         Node_Sub36_Sub3.aClass179_10058.method1815((byte)74);
         Class320_Sub26.method3777();
         Node_Sub18.method2606(126);
         GameStub.method101(-15332);
         Class262_Sub22.method3206(0);
         CacheNode_Sub4.method2304(-62);
         Class48.method481(0);
         Node_Sub36_Sub2.method2761((byte)125);
         Class113.method1150((byte)-99);
         Animable_Sub1.method825((byte)-68);
         Class262_Sub23.method3212(false, 1295);

         for(int i_0_ = 0; ~i_0_ > -2049; ++i_0_) {
            Player player = Class270_Sub2.LOCAL_PLAYERS[i_0_];
            if (player != null) {
               for(int i_1_ = 0; player.aDrawableModelArray10909.length > i_1_; ++i_1_) {
                  player.aDrawableModelArray10909[i_1_] = null;
               }
            }
         }

         for(int i_2_ = 0; ~i_2_ > ~Node_Sub32.cachedNPCcsCount; ++i_2_) {
            Npc npc = Class314.LocalNPCs[i_2_].aNpc7518;
            if (npc != null) {
               for(int i_3_ = 0; i_3_ < npc.aDrawableModelArray10909.length; ++i_3_) {
                  npc.aDrawableModelArray10909[i_3_] = null;
               }
            }
         }

         Node_Sub5.aClass336_7032 = null;
         Class290_Sub6.aClass336_8114 = null;
         Class93.aGraphicsToolkit1241.method1233(-7751);
         Class93.aGraphicsToolkit1241 = null;
      }

      ++anInt1623;
      int i_4_ = 73 / ((16 - i) / 49);
   }

   public static void method1533(int i) {
      aClass192_1633 = null;
      aClass126_1629 = null;
      aClass126_1628 = null;
      aClass126_1626 = null;
      if (i == 1) {
         aClass126_1620 = null;
         aClass318_1632 = null;
         aClass126_1627 = null;
         aClass126_1625 = null;
         aClass126_1630 = null;
      }
   }

   @Override
   public final String toString() {
      ++anInt1615;
      throw new IllegalStateException();
   }

   static final Class126 method1534(int i, int i_5_) {
      ++anInt1613;
      if (i_5_ > -103) {
         aClass192_1633 = null;
      }

      if (~i != -1) {
         if (i != 1) {
            if (~i != -3) {
               if (i != 3) {
                  if (i != 4) {
                     if (i != 5) {
                        return ~i == -7 ? aClass126_1630 : null;
                     } else {
                        return aClass126_1629;
                     }
                  } else {
                     return aClass126_1628;
                  }
               } else {
                  return aClass126_1627;
               }
            } else {
               return aClass126_1626;
            }
         } else {
            return aClass126_1625;
         }
      } else {
         return aClass126_1620;
      }
   }

   static final void method1535(int i, int i_7_, int i_8_, int componentHash, int i_10_) {
      ++anInt1614;
      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 8, (long)componentHash);
      cachenode_sub2.method2288(0);
      if (i_8_ < 91) {
         processClientCommand(54, false, false, null);
      }

      cachenode_sub2.anInt9432 = i_10_;
      cachenode_sub2.anInt9429 = i_7_;
      cachenode_sub2.anInt9434 = i;
   }

   static final int method1536(int i, String string) {
      if (i != -20826) {
         return -51;
      } else {
         ++anInt1611;
         return string.length() - -1;
      }
   }

   static final RuntimeException_Sub1 method1537(Throwable throwable, String string) {
      ++anInt1619;
      RuntimeException_Sub1 runtimeexception_sub1;
      if (!(throwable instanceof RuntimeException_Sub1)) {
         runtimeexception_sub1 = new RuntimeException_Sub1(throwable, string);
      } else {
         runtimeexception_sub1 = (RuntimeException_Sub1)throwable;
         runtimeexception_sub1.aString4919 = runtimeexception_sub1.aString4919 + ' ' + string;
      }

      return runtimeexception_sub1;
   }

   static final void processClientCommand(int i, boolean bool, boolean bool_11_, String string) {
      ++anInt1618;

      try {
         if (string.equalsIgnoreCase("commands") || string.equalsIgnoreCase("help")) {
            Node_Sub7.writeToConsole((byte)43, "commands - This command");
            Node_Sub7.writeToConsole((byte)43, "cls - Clear console");
            Node_Sub7.writeToConsole((byte)43, "displayfps - Toggle FPS and other information");
            Node_Sub7.writeToConsole((byte)43, "renderer - Print graphics renderer information");
            Node_Sub7.writeToConsole((byte)43, "heap - Print java memory information");
            Node_Sub7.writeToConsole((byte)43, "ortho - (0/1) enable or disable orthographic camera view");
            Node_Sub7.writeToConsole((byte)43, "orthozoom - Adjust orhographic zoom");
            Node_Sub7.writeToConsole((byte)43, "getcamerapos - Print location and direction of camera for use in bug reports");
            Node_Sub7.writeToConsole((byte)43, "getcamerarot - Print angle and rotation of camera for use in bug reports");
            Node_Sub7.writeToConsole((byte)43, "getoverlay - Get definitions of an overlay");
            Node_Sub7.writeToConsole((byte)43, "getunderlay - Get definitions of an underlay");
            return;
         }

         if (string.contains("getoverlay ")) {
            int index = string.indexOf(" ");
            int value = Integer.parseInt(string.substring(index + 1).trim());
            OverlayDefinition o = Class290_Sub7.aClass71_8134.getOverlayDefinitions((0xFF & value) - 1, (byte)118);
            TextureDefinitions t = Class376.aD4661.getTexture(o.texture, -8217);
            Node_Sub7.writeToConsole((byte)43, "Texture: " + o.texture);
            Node_Sub7.writeToConsole((byte)43, "Effect: " + t.effect);
            Node_Sub7.writeToConsole((byte)43, "Effect P1: " + t.effectParam1);
            Node_Sub7.writeToConsole((byte)43, "Effect P2: " + t.effectParam2);
            Node_Sub7.writeToConsole((byte)43, "Shadow: " + t.shadowFactor);
            Node_Sub7.writeToConsole((byte)43, "Brightness: " + t.brightness);
            Node_Sub7.writeToConsole((byte)43, "Speed U: " + t.speedU);
            Node_Sub7.writeToConsole((byte)43, "Speed V: " + t.speedV);
            Node_Sub7.writeToConsole((byte)43, "Combined M: " + t.combinedMode);
            Node_Sub7.writeToConsole((byte)43, "Mipmaps: " + t.mipmaps);
            Node_Sub7.writeToConsole((byte)43, "Repeat T: " + t.repeatTop);
            Node_Sub7.writeToConsole((byte)43, "Repeat S: " + t.repeatSides);
            Node_Sub7.writeToConsole((byte)43, "Brick Tile: " + t.brickTile);
            Node_Sub7.writeToConsole((byte)43, "Ground Mesh: " + t.meshGround);
            Node_Sub7.writeToConsole((byte)43, "HDR: " + t.hdr);
            Node_Sub7.writeToConsole((byte)43, "Translucent: " + t.translucent);
            Node_Sub7.writeToConsole((byte)43, "Skip Triangles: " + t.skipTriangles);
            Node_Sub7.writeToConsole((byte)43, "Unknown Bool: " + t.unknown);
            Node_Sub7.writeToConsole((byte)43, "Unknown Int: " + t.unknown1);
            return;
         }

         if (string.contains("convertworldmap")) {
            RSMapperClient.editor.worldmapEditor.exportConverted("area");
         }

         if (string.contains("getunderlay ")) {
            int index = string.indexOf(" ");
            int value = Integer.parseInt(string.substring(index + 1).trim());
            UnderlayDefinition u = WorldmapDefinitions.aClass58_321.getUnderlayDefinitions(-17993, (0xFF & value) - 1);
            TextureDefinitions t = Class376.aD4661.getTexture(u.texture, -8217);
            Node_Sub7.writeToConsole((byte)43, "Texture: " + u.texture);
            Node_Sub7.writeToConsole((byte)43, "Effect: " + t.effect);
            Node_Sub7.writeToConsole((byte)43, "Effect P1: " + t.effectParam1);
            Node_Sub7.writeToConsole((byte)43, "Effect P2: " + t.effectParam2);
            Node_Sub7.writeToConsole((byte)43, "Shadow: " + t.shadowFactor);
            Node_Sub7.writeToConsole((byte)43, "Brightness: " + t.brightness);
            Node_Sub7.writeToConsole((byte)43, "Speed U: " + t.speedU);
            Node_Sub7.writeToConsole((byte)43, "Speed V: " + t.speedV);
            Node_Sub7.writeToConsole((byte)43, "Combined M: " + t.combinedMode);
            Node_Sub7.writeToConsole((byte)43, "Mipmaps: " + t.mipmaps);
            Node_Sub7.writeToConsole((byte)43, "Repeat T: " + t.repeatTop);
            Node_Sub7.writeToConsole((byte)43, "Repeat S: " + t.repeatSides);
            Node_Sub7.writeToConsole((byte)43, "Brick Tile: " + t.brickTile);
            Node_Sub7.writeToConsole((byte)43, "Ground Mesh: " + t.meshGround);
            Node_Sub7.writeToConsole((byte)43, "HDR: " + t.hdr);
            Node_Sub7.writeToConsole((byte)43, "Translucent: " + t.translucent);
            Node_Sub7.writeToConsole((byte)43, "Skip Triangles: " + t.skipTriangles);
            Node_Sub7.writeToConsole((byte)43, "Unknown Bool: " + t.unknown);
            Node_Sub7.writeToConsole((byte)43, "Unknown Int: " + t.unknown1);
            return;
         }

         if (string.contains("getvarc ")) {
            int idIndex = string.indexOf(" ");
            int varcId = Integer.parseInt(string.substring(idIndex + 1).trim());
            Node_Sub7.writeToConsole((byte)43, "VARC[" + varcId + "] = " + Class320_Sub22.anIntArray8417[varcId]);
            return;
         }

         if (string.contains("getvarpbit ")) {
            int idIndex = string.indexOf(" ");
            int varpbitId = Integer.parseInt(string.substring(idIndex + 1).trim());
            Node_Sub7.writeToConsole((byte)43, "VARPBIT[" + varpbitId + "] = " + Class24.aClass275_442.getVarpBit(varpbitId, (byte)-42));
            return;
         }

         if (string.contains("npc")) {
            int idIndex = string.indexOf(" ");
            int npcId = Integer.parseInt(string.substring(idIndex + 1));
            int i_2_ = -1;

            for(int i_3_ = 0; i_3_ < Class262_Sub5.anInt7739; ++i_3_) {
               if (RSMapperClient.regionId == Class320_Sub5.anIntArray8255[i_3_]) {
                  i_2_ = i_3_;
                  break;
               }
            }

            if (i_2_ == -1) {
               Class320_Sub5.anIntArray8255[Class262_Sub5.anInt7739] = RSMapperClient.regionId;
               i_2_ = Class262_Sub5.anInt7739++;
            }

            int i_4_ = 0;
            int index = i_2_ | i_4_++ << 6;
            int plane = RSMapperClient.editor.selectedTile.getPlane();
            int localX = RSMapperClient.editor.selectedTile.getLocalX();
            int localY = RSMapperClient.editor.selectedTile.getLocalY();
            NpcDefinition npcdefinition = Class366.aClass279_4526.getNPCDefinitions(npcId, (byte)107);
            Node_Sub41 node_sub41 = (Node_Sub41)Class12.aHashTable187.get(3512, (long)index);
            if (node_sub41 == null
               && (1 & npcdefinition.aByte2816) > 0
               && plane == Class94.anInt1249
               && localX >= 0
               && npcdefinition.size + localX < Node_Sub54.GAME_SCENE_WDITH
               && localY >= 0
               && localY + npcdefinition.size < Class377_Sub1.GAME_SCENE_HEIGHT) {
               Npc npc = new Npc();
               npc.index = index;
               Node_Sub41 node_sub41_12_ = new Node_Sub41(npc);
               Class12.aHashTable187.put((long)index, node_sub41_12_, -127);
               Class314.LocalNPCs[Node_Sub32.cachedNPCcsCount++] = node_sub41_12_;
               Class54.LocalNPCsIndexes[Node_Sub25_Sub3.localNPCsCount++] = index;
               npc.anInt10880 = Class174.clientCycle;
               npc.method879(npcdefinition, true);
               npc.method861(-1000, npc.definitions.size);
               npc.anInt10890 = npc.definitions.anInt2876 << 3;
               npc.method849((-2141192185 & 4 + npc.definitions.aByte2873) << 11, 0, true);
               npc.method877(-15694, true, localY, localX, plane, npc.getSize((byte)119));
            }

            return;
         }

         if (string.equalsIgnoreCase("erase")) {
            Class303.anAnimableArray3827 = new Animable[2];
            SeekableFile.anAnimableArray3884 = new Animable[2];
            Node_Sub36.anAnimableArray7429 = new Animable[2];
            Class32.staticObjectsInScene = new Animable[10000];
            Class262_Sub15.animatedObjectsInScene = new Animable[5000];
            return;
         }

         if (string.equalsIgnoreCase("nosound")) {
            Class320_Sub2.method3685(-86);
            Class377_Sub1.aBoolean8775 = false;
            return;
         }

         if (string.equalsIgnoreCase("reloadcs2")) {
            RSMapperClient.loadCS2();
            Node_Sub7.writeToConsole((byte)43, "External CS2 reloaded");
            return;
         }

         if (string.equalsIgnoreCase("cls")) {
            Class118.anInt5406 = 0;
            Class144_Sub4.anInt6848 = 0;
            return;
         }

         if (string.equalsIgnoreCase("tst1")) {
            Class169_Sub1.aBooleanArray8788[0] = !Class169_Sub1.aBooleanArray8788[0];
            return;
         }

         if (i < 74) {
            return;
         }

         if (string.equalsIgnoreCase("displayfps")) {
            Node_Sub15_Sub2.aBoolean9780 = !Node_Sub15_Sub2.aBoolean9780;
            if (!Node_Sub15_Sub2.aBoolean9780) {
               Node_Sub7.writeToConsole((byte)43, "FPS off");
               return;
            }

            Node_Sub7.writeToConsole((byte)43, "FPS on");
            return;
         }

         if (string.equals("renderer")) {
            Renderer renderer = Class93.aGraphicsToolkit1241.c();
            Node_Sub7.writeToConsole((byte)43, "Vendor: " + renderer.anInt3656);
            Node_Sub7.writeToConsole((byte)43, "Name: " + renderer.aString3664);
            Node_Sub7.writeToConsole((byte)43, "Version: " + renderer.anInt3658);
            Node_Sub7.writeToConsole((byte)43, "Device: " + renderer.aString3660);
            Node_Sub7.writeToConsole((byte)43, "Driver Version: " + renderer.aLong3661);
            return;
         }

         if (string.equals("heap")) {
            Node_Sub7.writeToConsole((byte)43, "Heap: " + Class201.anInt2446 + "MB");
            return;
         }

         if (string.equalsIgnoreCase("getcamerapos")) {
            Node_Sub7.writeToConsole(
               (byte)43,
               "Pos: Plane: "
                  + Class295.myPlayer.plane
                  + " - Raw: ("
                  + Class98.cameraPosX
                  + ", "
                  + Node_Sub10.cameraPosY
                  + ") - Unknown: ("
                  + ((Class98.cameraPosX >> 9) + Node_Sub53.gameSceneBaseX >> 6)
                  + ", "
                  + ((Node_Sub10.cameraPosY >> 9) + Class320_Sub4.gameSceneBaseY >> 6)
                  + ") - Raw Local: ("
                  + ((Class98.cameraPosX >> 9) + Node_Sub53.gameSceneBaseX & 63)
                  + ", "
                  + ((Node_Sub10.cameraPosY >> 9) + Class320_Sub4.gameSceneBaseY & 63)
                  + ") - Local: ("
                  + (((Class98.cameraPosX >> 9) + Node_Sub53.gameSceneBaseX & 63) + 16)
                  + ", "
                  + (((Node_Sub10.cameraPosY >> 9) + Class320_Sub4.gameSceneBaseY & 63) + 16)
                  + ") - Height: "
                  + (Node_Sub38_Sub7.getTileMedianHeight(Class295.myPlayer.plane, -29754, Node_Sub10.cameraPosY, Class98.cameraPosX) + -Class190.cameraHeight)
            );
            Node_Sub7.writeToConsole(
               (byte)43,
               "Look: "
                  + Class295.myPlayer.plane
                  + ","
                  + (Class238.anInt2911 + Node_Sub53.gameSceneBaseX >> 6)
                  + ","
                  + (Class320_Sub4.gameSceneBaseY + Class10.anInt174 >> 6)
                  + ","
                  + (63 & Node_Sub53.gameSceneBaseX + Class238.anInt2911)
                  + ","
                  + (63 & Class320_Sub4.gameSceneBaseY + Class10.anInt174)
                  + " Height: "
                  + (Node_Sub38_Sub7.getTileMedianHeight(Class295.myPlayer.plane, -29754, Class10.anInt174, Class238.anInt2911) + -Class134_Sub1.anInt9015)
            );
            return;
         }

         if (string.equalsIgnoreCase("getcamerarot")) {
            Node_Sub7.writeToConsole((byte)43, "Vertical: " + ((int)Class257.cameraRotationVertical >> 3));
            Node_Sub7.writeToConsole((byte)43, "Horizontal: " + ((int)Node_Sub12.cameraRotationHorizontal >> 3));
         }

         if (string.equalsIgnoreCase("getplayerpos")) {
            Node_Sub7.writeToConsole(
               (byte)43, "Player position: (" + Class295.myPlayer.x + ", " + Class295.myPlayer.y + ", " + CacheNode_Sub20_Sub1.myPlayerPlane + ")"
            );
         }

         if (string.contains("setcameraspeed ")) {
            int index = string.indexOf(" ");
            int speed = Integer.parseInt(string.substring(index + 1).trim());
            if (speed <= 0) {
               speed = 1;
            }

            Class291.cameraRotationHorizontalMultiplier = (float)speed;
            Node_Sub36_Sub1.cameraRotationVerticalMultiplier = (float)speed;
         }
      } catch (Exception var22) {
         Node_Sub7.writeToConsole((byte)43, Class22.aClass22_365.getStoredString(Class35.language));
         return;
      }

      if (Class339_Sub7.rights >= -100) {
         if (string.equalsIgnoreCase("errortest")) {
            throw new RuntimeException();
         }

         if (string.equals("nativememerror")) {
            throw new OutOfMemoryError("native(MPR");
         }

         try {
            if (string.equalsIgnoreCase("printfps")) {
               Node_Sub7.writeToConsole((byte)43, "FPS: " + Node_Sub9_Sub4.anInt9732);
               return;
            }

            if (string.equalsIgnoreCase("occlude")) {
               Class12.aBoolean194 = !Class12.aBoolean194;
               if (!Class12.aBoolean194) {
                  Node_Sub7.writeToConsole((byte)43, "Occlsion now off!");
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "Occlsion now on!");
               return;
            }

            if (string.equalsIgnoreCase("fpson")) {
               Node_Sub15_Sub2.aBoolean9780 = true;
               Node_Sub7.writeToConsole((byte)43, "fps debug enabled");
               return;
            }

            if (string.equalsIgnoreCase("fpsoff")) {
               Node_Sub15_Sub2.aBoolean9780 = false;
               Node_Sub7.writeToConsole((byte)43, "fps debug disabled");
               return;
            }

            if (string.equals("systemmem")) {
               try {
                  Node_Sub7.writeToConsole(
                     (byte)43, "System memory: " + jagmisc.getAvailablePhysicalMemory() / 1048576L + "/" + Node_Sub23.aNode_Sub39_7201.anInt7484 + "Mb"
                  );
               } catch (Throwable var16) {
               }

               return;
            }

            if (string.equalsIgnoreCase("cleartext")) {
               Class226.aClass103_2684.method1112((byte)-122);
               Node_Sub7.writeToConsole((byte)43, "Text coords cleared");
               return;
            }

            if (string.equalsIgnoreCase("gc")) {
               Class355.method4021(60);

               for(int i_12_ = 0; ~i_12_ > -11; ++i_12_) {
                  System.gc();
               }

               Runtime runtime = Runtime.getRuntime();
               int i_13_ = (int)((runtime.totalMemory() + -runtime.freeMemory()) / 1024L);
               Node_Sub7.writeToConsole((byte)43, "mem=" + i_13_ + "k");
               return;
            }

            if (string.equalsIgnoreCase("compact")) {
               Class355.method4021(49);

               for(int i_14_ = 0; i_14_ < 10; ++i_14_) {
                  System.gc();
               }

               Runtime runtime = Runtime.getRuntime();
               int i_15_ = (int)((runtime.totalMemory() + -runtime.freeMemory()) / 1024L);
               Node_Sub7.writeToConsole((byte)43, "Memory before cleanup=" + i_15_ + "k");
               Class189.method1934((byte)17);
               Class355.method4021(112);

               for(int i_16_ = 0; ~i_16_ > -11; ++i_16_) {
                  System.gc();
               }

               i_15_ = (int)((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
               Node_Sub7.writeToConsole((byte)43, "Memory after cleanup=" + i_15_ + "k");
               return;
            }

            if (string.equalsIgnoreCase("unloadnatives")) {
               Node_Sub7.writeToConsole((byte)43, !Class377_Sub1.method4128(0) ? "Library unloading failed!" : "Libraries unloaded");
               return;
            }

            if (string.equalsIgnoreCase("clientdrop")) {
               Node_Sub7.writeToConsole((byte)43, "Dropped client connection");
               if (Class151.anInt1843 != 11) {
                  if (Class151.anInt1843 == 12) {
                     Class218.aClass123_2566.aBoolean1580 = true;
                  }
               } else {
                  Class262_Sub13.method3182(false);
               }

               return;
            }

            if (string.equalsIgnoreCase("rotateconnectmethods")) {
               Class181.aClass197_2155.method1997(17418);
               Node_Sub7.writeToConsole((byte)43, "Rotated connection methods");
               return;
            }

            if (string.equalsIgnoreCase("clientjs5drop")) {
               Class267.aClass266_3449.method3235(false);
               Node_Sub7.writeToConsole((byte)43, "Dropped client js5 net queue");
               return;
            }

            if (string.equalsIgnoreCase("serverjs5drop")) {
               Class267.aClass266_3449.method3242(-110);
               Node_Sub7.writeToConsole((byte)43, "Dropped server js5 net queue");
               return;
            }

            if (string.equalsIgnoreCase("breakcon")) {
               Class240.aSignLink2946.method3644((byte)-64);
               Class123[] class123s = Class218.aClass123Array2567;

               for(int i_17_ = 0; ~class123s.length < ~i_17_; ++i_17_) {
                  Class123 class123 = class123s[i_17_];
                  if (class123.aClass365_1557 != null) {
                     class123.aClass365_1557.method4063(0);
                  }
               }

               Class267.aClass266_3449.method3245(-2);
               Node_Sub7.writeToConsole((byte)43, "Breaking new connections for 5 seconds");
               return;
            }

            if (string.equalsIgnoreCase("rebuild")) {
               Class243.method3061(7);
               Node_Sub18.method2606(126);
               Node_Sub7.writeToConsole((byte)43, "Rebuilding map");
               return;
            }

            if (string.equalsIgnoreCase("rebuildprofile")) {
               Class366.aLong4528 = Class313.method3650(false);
               DrawMiniMapSprites.aBoolean313 = true;
               Class243.method3061(7);
               Node_Sub18.method2606(126);
               Node_Sub7.writeToConsole((byte)43, "Rebuilding map (with profiling)");
               return;
            }

            if (string.equalsIgnoreCase("wm1")) {
               Node_Sub38_Sub19.method2850(3, 1, -1, false, -1);
               if (Class188_Sub2_Sub1.getDisplayMode(3) != 1) {
                  Node_Sub7.writeToConsole((byte)43, "wm1 failed");
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "wm1 succeeded");
               return;
            }

            if (string.equalsIgnoreCase("wm2")) {
               Node_Sub38_Sub19.method2850(3, 2, -1, false, -1);
               if (Class188_Sub2_Sub1.getDisplayMode(3) != 2) {
                  Node_Sub7.writeToConsole((byte)43, "wm2 failed");
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "wm2 succeeded");
               return;
            }

            if (string.equalsIgnoreCase("wm3")) {
               Node_Sub38_Sub19.method2850(3, 3, 1024, false, 768);
               if (Class188_Sub2_Sub1.getDisplayMode(3) != 3) {
                  Node_Sub7.writeToConsole((byte)43, "wm3 failed");
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "wm3 succeeded");
               return;
            }

            if (string.equalsIgnoreCase("tk0")) {
               Class22.method300(0, true, false);
               if (~Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false) == -1) {
                  Node_Sub7.writeToConsole((byte)43, "Entered tk0");
                  Class213.aNode_Sub27_2512.method2690(102, 0, Class213.aNode_Sub27_2512.aClass320_Sub29_7291);
                  Node_Sub38_Sub31.method2893(1);
                  Class269.aBoolean3472 = false;
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "Failed to enter tk0");
               return;
            }

            if (string.equalsIgnoreCase("tk1")) {
               Class22.method300(1, true, false);
               if (Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false) == 1) {
                  Node_Sub7.writeToConsole((byte)43, "Entered tk1");
                  Class213.aNode_Sub27_2512.method2690(103, 1, Class213.aNode_Sub27_2512.aClass320_Sub29_7291);
                  Node_Sub38_Sub31.method2893(1);
                  Class269.aBoolean3472 = false;
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "Failed to enter tk1");
               return;
            }

            if (string.equalsIgnoreCase("tk2")) {
               Class22.method300(2, true, false);
               if (Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false) == 2) {
                  Node_Sub7.writeToConsole((byte)43, "Entered tk2");
                  Class213.aNode_Sub27_2512.method2690(104, 2, Class213.aNode_Sub27_2512.aClass320_Sub29_7291);
                  Node_Sub38_Sub31.method2893(1);
                  Class269.aBoolean3472 = false;
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "Failed to enter tk2");
               return;
            }

            if (string.equalsIgnoreCase("tk3")) {
               Class22.method300(3, true, false);
               if (Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false) != 3) {
                  Node_Sub7.writeToConsole((byte)43, "Failed to enter tk3");
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "Entered tk3");
               Class213.aNode_Sub27_2512.method2690(27, 3, Class213.aNode_Sub27_2512.aClass320_Sub29_7291);
               Node_Sub38_Sub31.method2893(1);
               Class269.aBoolean3472 = false;
               return;
            }

            if (string.equalsIgnoreCase("tk5")) {
               Class22.method300(5, true, false);
               if (Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false) == 5) {
                  Node_Sub7.writeToConsole((byte)43, "Entered tk5");
                  Class213.aNode_Sub27_2512.method2690(127, 5, Class213.aNode_Sub27_2512.aClass320_Sub29_7291);
                  Node_Sub38_Sub31.method2893(1);
                  Class269.aBoolean3472 = false;
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "Failed to enter tk5");
               return;
            }

            if (string.startsWith("setba")) {
               if (string.length() < 6) {
                  Node_Sub7.writeToConsole((byte)43, "Invalid buildarea value");
                  return;
               }

               int i_18_ = Class350.method3998(string.substring(6), -1);
               if (i_18_ >= 0 && ~i_18_ >= ~Class248.method3084(Class201.anInt2446, 128)) {
                  Class213.aNode_Sub27_2512.method2690(28, i_18_, Class213.aNode_Sub27_2512.aClass320_Sub5_7297);
                  Node_Sub38_Sub31.method2893(1);
                  Class269.aBoolean3472 = false;
                  Node_Sub7.writeToConsole((byte)43, "maxbuildarea=" + Class213.aNode_Sub27_2512.aClass320_Sub5_7297.method3697(false));
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "Invalid buildarea value");
               return;
            }

            if (string.startsWith("rect_debug")) {
               if (~string.length() > -11) {
                  Node_Sub7.writeToConsole((byte)43, "Invalid rect_debug value");
                  return;
               }

               Class12.anInt193 = Class350.method3998(string.substring(10).trim(), -1);
               Node_Sub7.writeToConsole((byte)43, "rect_debug=" + Class12.anInt193);
               return;
            }

            if (string.equalsIgnoreCase("qa_op_test")) {
               Class54.aBoolean817 = true;
               Node_Sub7.writeToConsole((byte)43, "qa_op_test=" + Class54.aBoolean817);
               return;
            }

            if (string.equalsIgnoreCase("clipcomponents")) {
               Class204.aBoolean2454 = !Class204.aBoolean2454;
               Node_Sub7.writeToConsole((byte)43, "clipcomponents=" + Class204.aBoolean2454);
               return;
            }

            if (string.startsWith("bloom")) {
               boolean bool_19_ = Class93.aGraphicsToolkit1241.w();
               if (Node_Sub19.method2610((byte)-58, !bool_19_)) {
                  if (bool_19_) {
                     Node_Sub7.writeToConsole((byte)43, "Bloom disabled");
                  } else {
                     Node_Sub7.writeToConsole((byte)43, "Bloom enabled");
                  }

                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "Failed to enable bloom");
               return;
            }

            if (string.equalsIgnoreCase("tween")) {
               if (!Class320_Sub12.aBoolean8325) {
                  Class320_Sub12.aBoolean8325 = true;
                  Node_Sub7.writeToConsole((byte)43, "Forced tweening ENABLED!");
                  return;
               }

               Class320_Sub12.aBoolean8325 = false;
               Node_Sub7.writeToConsole((byte)43, "Forced tweening disabled.");
               return;
            }

            if (string.equalsIgnoreCase("shiftclick")) {
               if (Class116.aBoolean5072) {
                  Node_Sub7.writeToConsole((byte)43, "Shift-click disabled.");
                  Class116.aBoolean5072 = false;
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "Shift-click ENABLED!");
               Class116.aBoolean5072 = true;
               return;
            }

            if (string.equalsIgnoreCase("getcgcoord")) {
               Node_Sub7.writeToConsole((byte)43, "x:" + (Class295.myPlayer.x >> 9) + " z:" + (Class295.myPlayer.y >> 9));
               return;
            }

            if (string.equalsIgnoreCase("getheight")) {
               Node_Sub7.writeToConsole(
                  (byte)43,
                  "Height: "
                     + Class320_Sub10.aPlaneArray8300[Class295.myPlayer.plane]
                        .getVerticeHeight(Class295.myPlayer.y >> 9, Class295.myPlayer.x >> 9, (byte)-118)
               );
               return;
            }

            if (string.equalsIgnoreCase("resetminimap")) {
               Node_Sub38_Sub39.index8.method3523((byte)-46);
               Node_Sub38_Sub39.index8.method3521((byte)-18);
               Node_Sub54.aClass338_7671.method3908(-32478);
               Class304.aClass215_3834.method2071(7);
               Node_Sub18.method2606(126);
               Node_Sub7.writeToConsole((byte)43, "Minimap reset");
               return;
            }

            if (string.startsWith("mc")) {
               if (Class93.aGraphicsToolkit1241.s()) {
                  int i_20_ = Integer.parseInt(string.substring(3));
                  if (~i_20_ <= -2) {
                     if (~i_20_ < -5) {
                        i_20_ = 4;
                     }
                  } else {
                     i_20_ = 1;
                  }

                  Class244.RENDER_CORES = i_20_;
                  Class243.method3061(7);
                  Node_Sub7.writeToConsole((byte)43, "Render cores now: " + Class244.RENDER_CORES);
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "Current toolkit doesn't support multiple cores");
               return;
            }

            if (string.startsWith("cachespace")) {
               Node_Sub7.writeToConsole((byte)43, "I(s): " + Class252.aClass61_3190.method595(1188) + "/" + Class252.aClass61_3190.method597(22349));
               Node_Sub7.writeToConsole((byte)43, "I(m): " + Class166.aClass61_5097.method595(1188) + "/" + Class166.aClass61_5097.method597(22349));
               Node_Sub7.writeToConsole(
                  (byte)43,
                  "O(s): "
                     + EntityNode_Sub3_Sub1.aClass86_9166.aClass12_1179.method201(48)
                     + "/"
                     + EntityNode_Sub3_Sub1.aClass86_9166.aClass12_1179.method200(0)
               );
               return;
            }

            if (string.equals("renderprofile") || string.equals("rp")) {
               Class186.aBoolean2259 = !Class186.aBoolean2259;
               Class93.aGraphicsToolkit1241.b(Class186.aBoolean2259);
               Class64.method712(25053);
               Node_Sub7.writeToConsole((byte)43, "showprofiling=" + Class186.aBoolean2259);
               return;
            }

            if (string.startsWith("performancetest")) {
               int i_21_ = -1;
               int i_22_ = 1000;
               if (string.length() > 15) {
                  String[] strings = Class106.method1120((byte)-128, string, ' ');

                  try {
                     if (~strings.length < -2) {
                        i_22_ = Integer.parseInt(strings[1]);
                     }
                  } catch (Throwable var18) {
                  }

                  try {
                     if (strings.length > 2) {
                        i_21_ = Integer.parseInt(strings[2]);
                     }
                  } catch (Throwable var17) {
                  }
               }

               if (~i_21_ != 0) {
                  Node_Sub7.writeToConsole((byte)43, "Performance: " + Class194.method1961(i_22_, i_21_, 13968));
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "Java toolkit: " + Class194.method1961(i_22_, 0, 13968));
               Node_Sub7.writeToConsole((byte)43, "SSE toolkit:  " + Class194.method1961(i_22_, 2, 13968));
               Node_Sub7.writeToConsole((byte)43, "D3D toolkit:  " + Class194.method1961(i_22_, 3, 13968));
               Node_Sub7.writeToConsole((byte)43, "GL toolkit:   " + Class194.method1961(i_22_, 1, 13968));
               Node_Sub7.writeToConsole((byte)43, "GLX toolkit:  " + Class194.method1961(i_22_, 5, 13968));
               return;
            }

            if (string.equals("nonpcs")) {
               Node_Sub29.showNpcs = !Node_Sub29.showNpcs;
               Node_Sub7.writeToConsole((byte)43, "nonpcs=" + Node_Sub29.showNpcs);
               return;
            }

            if (string.equals("autoworld")) {
               EntityNode.method802(2126);
               Node_Sub7.writeToConsole((byte)43, "auto world selected");
               return;
            }

            if (string.startsWith("switchworld")) {
               int i_23_ = Integer.parseInt(string.substring(12));
               Class188_Sub1_Sub2.method1899(i_23_, (byte)27, Class327.method3823(100, i_23_).aString8773);
               Node_Sub7.writeToConsole((byte)43, "switched");
               return;
            }

            if (string.equals("getworld")) {
               Node_Sub7.writeToConsole((byte)43, "w: " + Class181.aClass197_2155.id);
               return;
            }

            if (string.startsWith("pc")) {
               Class123 class123 = Class262_Sub23.method3213((byte)-60);
               OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class133.aClass318_1687, class123.issacKeys);
               node_sub13.currentOutgoingPacket.writeByte(0);
               int i_24_ = node_sub13.currentOutgoingPacket.offset;
               int i_25_ = string.indexOf(" ", 4);
               node_sub13.currentOutgoingPacket.writeString(string.substring(3, i_25_));
               Class194_Sub3.method1975(69, node_sub13.currentOutgoingPacket, string.substring(i_25_));
               node_sub13.currentOutgoingPacket.method2217(-i_24_ + node_sub13.currentOutgoingPacket.offset);
               class123.sendPacket(126, node_sub13);
               return;
            }

            if (string.equals("savevarcs")) {
               Class144.method1631((byte)125);
               Node_Sub7.writeToConsole((byte)43, "perm varcs saved");
               return;
            }

            if (string.equals("scramblevarcs")) {
               for(int i_26_ = 0; i_26_ < Class320_Sub22.anIntArray8417.length; ++i_26_) {
                  if (FileOnDisk.aBooleanArray1332[i_26_]) {
                     Class320_Sub22.anIntArray8417[i_26_] = (int)(99999.0 * Math.random());
                     if (Math.random() > 0.5) {
                        Class320_Sub22.anIntArray8417[i_26_] *= -1;
                     }
                  }
               }

               Class144.method1631((byte)118);
               Node_Sub7.writeToConsole((byte)43, "perm varcs scrambled");
               return;
            }

            if (string.equals("showcolmap")) {
               Class320_Sub3.aBoolean8235 = true;
               Node_Sub18.method2606(126);
               Node_Sub7.writeToConsole((byte)43, "colmap is shown");
               return;
            }

            if (string.equals("hidecolmap")) {
               Class320_Sub3.aBoolean8235 = false;
               Node_Sub18.method2606(126);
               Node_Sub7.writeToConsole((byte)43, "colmap is hidden");
               return;
            }

            if (string.equals("resetcache")) {
               Node_Sub36_Sub2.method2761((byte)125);
               Node_Sub7.writeToConsole((byte)43, "Caches reset");
               return;
            }

            if (string.equals("profilecpu")) {
               Node_Sub7.writeToConsole((byte)43, String.valueOf(CacheNode_Sub4.method2302((byte)88)) + "ms");
               return;
            }

            if (string.startsWith("getclientvarpbit")) {
               int i_27_ = Integer.parseInt(string.substring(17));
               Node_Sub7.writeToConsole((byte)43, "varpbit=" + Class24.aClass275_442.getVarpBit(i_27_, (byte)-42));
               return;
            }

            if (string.startsWith("getclientvarp")) {
               int i_28_ = Integer.parseInt(string.substring(14));
               Node_Sub7.writeToConsole((byte)43, "varp=" + Class24.aClass275_442.method65(i_28_, 107));
               return;
            }

            if (string.startsWith("directlogin")) {
               String[] strings = Class106.method1120((byte)115, string.substring(12), ' ');
               if (strings.length >= 2) {
                  int i_29_ = ~strings.length < -3 ? Integer.parseInt(strings[2]) : 0;
                  Class39.login(i_29_, strings[1], strings[0], 106);
                  return;
               }
            }

            if (string.startsWith("snlogin ")) {
               String[] strings = Class106.method1120((byte)-110, string.substring(8), ' ');
               int i_30_ = Integer.parseInt(strings[0]);
               int i_31_ = strings.length == 2 ? Integer.parseInt(strings[1]) : 0;
               Animable.method822(i_30_, i_31_, 4);
               return;
            }

            if (string.startsWith("csprofileclear")) {
               ClientScriptsExecutor.method3564();
               return;
            }

            if (string.startsWith("csprofileoutputc")) {
               ClientScriptsExecutor.method3554(100, false);
               return;
            }

            if (string.startsWith("csprofileoutputt")) {
               ClientScriptsExecutor.method3554(10, true);
               return;
            }

            if (string.startsWith("textsize")) {
               int i_32_ = Integer.parseInt(string.substring(8));
               Class93.aGraphicsToolkit1241.f(i_32_);
               return;
            }

            if (string.equals("soundstreamcount")) {
               Node_Sub7.writeToConsole((byte)43, "Active streams: " + Class176.aNode_Sub9_Sub3_2106.method2512());
               return;
            }

            if (string.equals("autosetup")) {
               Node_Sub41.autoSetupGraphics((byte)-103);
               Node_Sub7.writeToConsole((byte)43, "Complete. Toolkit now: " + Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false));
               return;
            }

            if (string.equals("errormessage")) {
               Node_Sub7.writeToConsole((byte)43, Class158.aClient1983.method100(10));
               return;
            }

            if (string.equals("heapdump")) {
               if (!SignLink.aString3981.startsWith("win")) {
                  AbstractToolkit.method1272(0, new File("/tmp/heap.dump"), false);
               } else {
                  AbstractToolkit.method1272(0, new File("C:\\Temp\\heap.dump"), false);
               }

               Node_Sub7.writeToConsole((byte)43, "Done");
               return;
            }

            if (string.equals("os")) {
               Node_Sub7.writeToConsole((byte)43, "Name: " + SignLink.aString3981);
               Node_Sub7.writeToConsole((byte)43, "Arch: " + SignLink.aString3984);
               Node_Sub7.writeToConsole((byte)43, "Ver: " + SignLink.aString3982);
               return;
            }

            if (string.startsWith("w2debug")) {
               int i_33_ = Integer.parseInt(string.substring(8, 9));
               Node_Sub9_Sub5.anInt9766 = i_33_;
               Class243.method3061(7);
               Node_Sub7.writeToConsole((byte)43, "Toggled!");
               return;
            }

            if (string.startsWith("ortho ")) {
               int i_34_ = string.indexOf(32);
               if (i_34_ < 0) {
                  Node_Sub7.writeToConsole((byte)43, "Syntax: ortho <n>");
                  return;
               }

               int i_35_ = Class350.method3998(string.substring(i_34_ + 1), -1);
               Class213.aNode_Sub27_2512.method2690(119, i_35_, Class213.aNode_Sub27_2512.aClass320_Sub3_7298);
               Node_Sub38_Sub31.method2893(1);
               Class269.aBoolean3472 = false;
               Class34_Sub1.method378(-4);
               if (i_35_ != Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false)) {
                  Node_Sub7.writeToConsole((byte)43, "Failed to change ortho mode");
                  return;
               }

               Node_Sub7.writeToConsole((byte)43, "Successfully changed ortho mode");
               if (i_35_ == 1) {
                  Class339_Sub8.mouseNotches = 0;
                  Constants.ZOOM_MODIFIER = 0;
                  Class308.orthoZoom = 45000;
                  Class336_Sub2.orthoLocked = false;
               }

               return;
            }

            if (string.startsWith("orthozoom ")) {
               if (~Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false) == -1) {
                  Node_Sub7.writeToConsole((byte)43, "enable ortho mode first (use 'ortho <n>')");
                  return;
               }

               int i_36_ = Class350.method3998(string.substring(1 + string.indexOf(32)), -1);
               Class308.orthoZoom = i_36_;
               Node_Sub7.writeToConsole((byte)43, "orthozoom=" + Class308.orthoZoom);
               return;
            }

            if (string.startsWith("orthotilesize ")) {
               int i_37_ = Class350.method3998(string.substring(1 + string.indexOf(32)), -1);
               Node_Sub36_Sub1.anInt10039 = i_37_;
               Class22.anInt432 = i_37_;
               Node_Sub7.writeToConsole((byte)43, "ortho tile size=" + i_37_);
               Class34_Sub1.method378(-4);
               return;
            }

            if (string.equals("orthocamlock")) {
               Class336_Sub2.orthoLocked = !Class336_Sub2.orthoLocked;
               Node_Sub7.writeToConsole((byte)43, "ortho camera lock is " + (Class336_Sub2.orthoLocked ? "on" : "off"));
               return;
            }

            if (string.startsWith("skydetail ")) {
               int i_38_ = Class350.method3998(string.substring(string.indexOf(32) - -1), -1);
               Class213.aNode_Sub27_2512.method2690(36, i_38_, Class213.aNode_Sub27_2512.aClass320_Sub2_7272);
               Node_Sub7.writeToConsole((byte)43, "skydetail is " + (Class213.aNode_Sub27_2512.aClass320_Sub2_7272.method3686(false) != 0 ? "high" : "low"));
               return;
            }

            if (string.startsWith("setoutput ")) {
               File file = new File(string.substring(10));
               if (file.exists()) {
                  file = new File(string.substring(10) + "." + Class313.method3650(false) + ".log");
                  if (file.exists()) {
                     Node_Sub7.writeToConsole((byte)43, "file already exists!");
                     return;
                  }
               }

               if (Class270_Sub1.aFileOutputStream8027 != null) {
                  Class270_Sub1.aFileOutputStream8027.close();
                  Class270_Sub1.aFileOutputStream8027 = null;
               }

               try {
                  Class270_Sub1.aFileOutputStream8027 = new FileOutputStream(file);
               } catch (FileNotFoundException var19) {
                  Node_Sub7.writeToConsole((byte)43, "Could not create " + file.getName());
               } catch (SecurityException var20) {
                  Node_Sub7.writeToConsole((byte)43, "Cannot write to " + file.getName());
               }

               return;
            }

            if (string.equals("closeoutput")) {
               if (Class270_Sub1.aFileOutputStream8027 != null) {
                  Class270_Sub1.aFileOutputStream8027.close();
               }

               Class270_Sub1.aFileOutputStream8027 = null;
               return;
            }

            if (string.startsWith("runscript ")) {
               File file = new File("resources" + File.separator + "cs2" + File.separator + string.substring(10).trim() + ".dat");
               System.out.println("Exec CS2: " + file);
               if (!file.exists()) {
                  Node_Sub7.writeToConsole((byte)43, "No such file");
                  return;
               }

               byte[] bs = Class337.method3904((byte)113, file);
               if (bs == null) {
                  Node_Sub7.writeToConsole((byte)43, "Failed to read file");
                  return;
               }

               String[] strings = Class106.method1120((byte)-57, Class197.method1998(Class329.method3835(bs, true), "", (byte)26, '\r'), '\n');
               Class194.method1960(strings);
            }

            if (string.startsWith("zoom ")) {
               short s = (short)Class350.method3998(string.substring(5), -1);
               if (s > 0) {
                  Class268.aShort3455 = s;
               }

               return;
            }

            if (string.startsWith("cs2debug")) {
               if (~string.length() < -10 && ~string.charAt(8) == -33) {
                  ClientScriptsExecutor.aString3870 = string.substring(9);
                  ClientScriptsExecutor.aBoolean3868 = true;
                  Node_Sub7.writeToConsole((byte)43, "cs2debug: (" + ClientScriptsExecutor.aString3870 + ")");
                  return;
               }

               ClientScriptsExecutor.aString3870 = null;
               ClientScriptsExecutor.aBoolean3868 = !ClientScriptsExecutor.aBoolean3868;
               Node_Sub7.writeToConsole((byte)43, "cs2debug:" + ClientScriptsExecutor.aBoolean3868);
               return;
            }

            if (~Class151.anInt1843 == -12) {
               ++CacheNode_Sub6.anInt9483;
               OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class247.aClass318_3130, Class218.aClass123_2566.issacKeys);
               node_sub13.currentOutgoingPacket.writeByte(3 + string.length());
               node_sub13.currentOutgoingPacket.writeByte(!bool ? 0 : 1);
               node_sub13.currentOutgoingPacket.writeByte(bool_11_ ? 1 : 0);
               node_sub13.currentOutgoingPacket.writeString(string);
               Class218.aClass123_2566.sendPacket(127, node_sub13);
            }

            if (string.startsWith("fps ") && Node_Sub38_Sub1.aClass329_10086 != Class240.aClass329_2943) {
               Class384.method4203(Class350.method3998(string.substring(4), -1), 0);
               return;
            }
         } catch (Exception var21) {
            Node_Sub7.writeToConsole((byte)43, Class22.aClass22_365.getStoredString(Class35.language));
            return;
         }
      }

      if (Class151.anInt1843 != 11) {
         Node_Sub7.writeToConsole((byte)43, Class22.aClass22_366.getStoredString(Class35.language) + string);
      }
   }

   static final void method1539(boolean bool, String string, byte b) {
      ++anInt1622;
      if (string != null) {
         if (~Class235.anInt5122 <= -101) {
            Class41.method436(b ^ -29479, Class22.aClass22_402.getStoredString(Class35.language), 4);
         } else {
            String string_39_ = Node_Sub25_Sub3.method2671(-13472, string);
            if (string_39_ != null) {
               for(int i = 0; Class235.anInt5122 > i; ++i) {
                  String string_40_ = Node_Sub25_Sub3.method2671(-13472, Class338.aStringArray4197[i]);
                  if (string_40_ != null && string_40_.equals(string_39_)) {
                     Class41.method436(29459, string + Class22.aClass22_403.getStoredString(Class35.language), 4);
                     return;
                  }

                  if (Class7.aStringArray164[i] != null) {
                     String string_41_ = Node_Sub25_Sub3.method2671(b + -13418, Class7.aStringArray164[i]);
                     if (string_41_ != null && string_41_.equals(string_39_)) {
                        Class41.method436(29459, string + Class22.aClass22_403.getStoredString(Class35.language), 4);
                        return;
                     }
                  }
               }

               for(int i = 0; ~Node_Sub38_Sub14.anInt10242 < ~i; ++i) {
                  String string_42_ = Node_Sub25_Sub3.method2671(b ^ 13482, Class262_Sub12.aStringArray7793[i]);
                  if (string_42_ != null && string_42_.equals(string_39_)) {
                     Class41.method436(
                        29459, Class22.aClass22_408.getStoredString(Class35.language) + string + Class22.aClass22_409.getStoredString(Class35.language), 4
                     );
                     return;
                  }

                  if (Plane.aStringArray3403[i] != null) {
                     String string_43_ = Node_Sub25_Sub3.method2671(-13472, Plane.aStringArray3403[i]);
                     if (string_43_ != null && string_43_.equals(string_39_)) {
                        Class41.method436(
                           29459, Class22.aClass22_408.getStoredString(Class35.language) + string + Class22.aClass22_409.getStoredString(Class35.language), 4
                        );
                        return;
                     }
                  }
               }

               if (Node_Sub25_Sub3.method2671(-13472, Class295.myPlayer.aString11142).equals(string_39_)) {
                  Class41.method436(29459, Class22.aClass22_405.getStoredString(Class35.language), 4);
               } else {
                  ++Class239.anInt2927;
                  Class123 class123 = Class262_Sub23.method3213((byte)-95);
                  OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class320_Sub3.addIgnore, class123.issacKeys);
                  node_sub13.currentOutgoingPacket.writeByte(method1536(-20826, string) + 1);
                  if (b != -54) {
                     anInt1631 = -43;
                  }

                  node_sub13.currentOutgoingPacket.writeString(string);
                  node_sub13.currentOutgoingPacket.writeByte(!bool ? 0 : 1);
                  class123.sendPacket(127, node_sub13);
               }
            }
         }
      }
   }

   private Class126(int i, int i_44_, Class372 class372) {
      this.anInt1612 = i_44_;
      this.aClass372_1617 = class372;
      this.anInt1621 = i;
      this.anInt1624 = this.anInt1612 * this.aClass372_1617.anInt4591;
      if (~this.anInt1621 <= -17) {
         throw new RuntimeException();
      }
   }
}
