import java.awt.Color;
import java.awt.geom.Point2D;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JTextField;

public class Class78 {
   protected int anInt1022;
   protected Node_Sub45_Sub1 aNode_Sub45_Sub1_1023;
   static int anInt1024;
   protected Node_Sub9_Sub2 aNode_Sub9_Sub2_1025;
   protected int anInt1026;
   protected byte aByte1027;
   protected int anInt1028;
   static int anInt1029;
   static int[] anIntArray1030 = new int[2];
   static int[] anIntArray1031 = new int[8];
   static int anInt1032;
   static Index index14;
   protected int anInt1034;
   protected Node_Sub49 aNode_Sub49_1035;
   protected int anInt1036;
   static int anInt1037;
   protected int anInt1038;
   protected Class65 aClass65_1039;
   static int anInt1040;
   protected Animable anAnimable1041;
   public static boolean MAP_CHANGED = false;
   public static boolean REFRESH_MINIMAP = false;
   public static long MINIMAP_REFRESH_DELAY = 0L;
   public static boolean SELECTING_OBJECT = false;
   public static EntityNode_Sub6 OBJECT_UNDER_CURSOR = null;

   public static void sendTeleport(int x, int y, int plane, boolean fullCoords) {
      int localX = new WorldTile(x, y, plane, false).getLocalX();
      int localY = new WorldTile(x, y, plane, false).getLocalY();
      Class333.baseX = localX << 3;
      Node_Sub21.baseY = localY << 3;
      Class50.basePlane = plane;
      Node_Sub23_Sub1.DECODE_MASKS_PLAYERS_INDEXES_LIST[Node_Sub9_Sub4.DECODE_MASKS_PLAYERS_COUNT++] = Class295.myPlayer.index;
      int xOffset = fullCoords ? localX - (Class295.myPlayer.x >> 9) : x;
      int yOffset = fullCoords ? localY - (Class295.myPlayer.y >> 9) : y;
      int i_19_ = -Node_Sub53.gameSceneBaseX + (Class295.myPlayer.scenePositionXQueue[0] - -Node_Sub53.gameSceneBaseX - -xOffset & 16383);
      int i_20_ = -Class320_Sub4.gameSceneBaseY + (16383 & yOffset + Class295.myPlayer.scenePositionYQueue[0] + Class320_Sub4.gameSceneBaseY);
      Class295.myPlayer.processMovement(i_20_, i_19_, -9380, Class73.movementTypes[Class295.myPlayer.index]);
      Class295.myPlayer.plane = (byte)plane;
      if (Class238.tileHasBridgeFlag(i_20_, i_19_, -108)) {
         Class295.myPlayer.aByte5931 = (byte)(Class295.myPlayer.aByte5931 + 1);
      }

      CacheNode_Sub20_Sub1.myPlayerPlane = plane;
   }

   static final void method776(int i, int i_0_, int i_1_, GraphicsToolkit graphicstoolkit) {
      ++anInt1029;
      if (~i_1_ <= -1 && ~i <= -1 && ~ClanChat.anInt764 != -1 && Class150_Sub2.anInt8955 != 0) {
         int i_2_;
         int i_3_;
         int i_4_;
         int i_5_;
         Class336 class336;
         int mouseXOnScreen;
         int mouseYOnScreen;
         if (Class71.aBoolean967) {
            Class379.method4159(3, false);
            class336 = graphicstoolkit.n();
            int[] is = graphicstoolkit.Y();
            i_4_ = is[1];
            i_2_ = is[2];
            i_3_ = is[3];
            i_5_ = is[0];
            mouseXOnScreen = Class132.method1564(12447, false) + i_1_;
            mouseYOnScreen = Node_Sub36_Sub4.method2764(-1, false) + i;
         } else {
            graphicstoolkit.DA(Class97.anInt1279, IComponentDefinitions.anInt4859, ClanChat.anInt764, Class150_Sub2.anInt8955);
            i_2_ = ClanChat.anInt764;
            i_3_ = Class150_Sub2.anInt8955;
            i_4_ = IComponentDefinitions.anInt4859;
            i_5_ = Class97.anInt1279;
            graphicstoolkit.KA(Class385.anInt4913, Node_Sub14.anInt7119, ClanChat.anInt764, Class150_Sub2.anInt8955);
            class336 = graphicstoolkit.y();
            class336.method3864(
               Class339_Sub6.anInt8694, Class231.anInt2764, Class194_Sub3.anInt6907, Class320_Sub23.anInt8434, Node_Sub15_Sub5.anInt9806, Class375.anInt4657
            );
            mouseXOnScreen = i_1_;
            graphicstoolkit.a(class336);
            mouseYOnScreen = i;
         }

         Class377_Sub1.method4130(true, -10385);
         if (~i_3_ == -1) {
            i_3_ = 1;
         }

         if (~i_2_ == -1) {
            i_2_ = 1;
         }

         if (Node_Sub38_Sub37.aPlaneArray10466 != null && (!Class87.removeWalkHere || (64 & Class200_Sub2.anInt4943) != 0)) {
            int localX = -1;
            int localY = -1;
            java.awt.Point pointOnTile = new java.awt.Point();
            int pointX = -1;
            int pointY = -1;
            int i_10_ = graphicstoolkit.i();
            int i_11_ = graphicstoolkit.XA();
            int i_12_;
            int i_13_;
            int i_14_;
            int i_15_;
            if (!Node_Sub15_Sub10.aBoolean9850) {
               i_14_ = (-i_4_ + mouseYOnScreen) * i_10_ / i_3_;
               i_13_ = i_11_ * (-i_5_ + mouseXOnScreen) / i_2_;
               i_12_ = (-i_5_ + mouseXOnScreen) * i_10_ / i_2_;
               i_15_ = (-i_4_ + mouseYOnScreen) * i_11_ / i_3_;
            } else {
               i_12_ = i_13_ = Class308.anInt3912 * (mouseXOnScreen - i_5_) / i_2_;
               i_14_ = i_15_ = Class308.anInt3912 * (-i_4_ + mouseYOnScreen) / i_3_;
            }

            int[] is = new int[]{i_12_, i_14_, i_10_};
            int[] is_16_ = new int[]{i_13_, i_15_, i_11_};
            class336.method3855(is);
            class336.method3855(is_16_);
            float f = CacheNode_Sub20_Sub1.method2412(
               (byte)56, (float)is[0], (float)is_16_[2], 4, (float)is[2], (float)is_16_[1], (float)is[1], (float)is_16_[0]
            );
            if (f > 0.0F) {
               int i_17_ = is_16_[0] + -is[0];
               int i_18_ = is_16_[2] + -is[2];
               int i_19_ = (int)((float)is[0] + f * (float)i_17_);
               int i_20_ = (int)((float)is[2] + f * (float)i_18_);
               localX = i_19_ + (Class295.myPlayer.getSize((byte)111) - 1 << 8) >> 9;
               localY = i_20_ - -(-1 + Class295.myPlayer.getSize((byte)102) << 8) >> 9;
               float xInTile = (float)((double)i_19_ / 170.666667 - (double)(i_19_ / 512 * 3));
               float yInTile = (float)((double)i_20_ / 170.666667 - (double)(i_20_ / 512 * 3));
               byte var41;
               if (xInTile >= 0.0F && (double)xInTile <= 0.8) {
                  var41 = 0;
               } else if ((double)xInTile > 0.75 && (double)xInTile <= 2.0) {
                  var41 = 1;
               } else {
                  var41 = 2;
               }

               byte var42;
               if (yInTile >= 0.0F && (double)yInTile <= 0.8) {
                  var42 = 0;
               } else if ((double)yInTile > 0.75 && (double)yInTile <= 2.0) {
                  var42 = 1;
               } else {
                  var42 = 2;
               }

               pointOnTile = new java.awt.Point(var41, var42);
               Class93_Sub2.mouseCoordXOnTile = (int)((float)(i_19_ / 1 - i_19_ / 512 * 512));
               Class93_Sub2.mouseCoordYOnTile = (int)((float)(i_20_ / 1 - i_20_ / 512 * 512));
            }

            if (Class175.aClass291_2100.isKeyHeld(-67, 32) && !SELECTING_OBJECT) {
               SELECTING_OBJECT = true;
               ((JButton)UIPanels.generalComponents.get("mouse_select_obj")).setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
            }

            if (localX != -1 && localY != -1) {
               if (Class87.removeWalkHere && ~(64 & Class200_Sub2.anInt4943) != -1) {
                  IComponentDefinitions widget = Node_Sub3.method2169(i_0_ ^ -101, Class46.anInt681, Node_Sub15_Sub9.anInt9839);
                  if (widget != null) {
                     Node_Sub32.drawRightClickOptions(
                        false, -1, 0L, localX, localY, Class84.aString1148, 21, true, Class201.anInt2444, " ->", (long)(localX << 0 | localY), (byte)-18, true
                     );
                  } else {
                     Node_Sub38_Sub23.method2863(-19316);
                  }
               } else {
                  if (Class377_Sub1.showFaceHere) {
                     Node_Sub32.drawRightClickOptions(
                        false,
                        -1,
                        0L,
                        localX,
                        localY,
                        Class22.aClass22_390.getStoredString(Class35.language),
                        11,
                        true,
                        -1,
                        "",
                        (long)(localY | localX << 0),
                        (byte)-18,
                        true
                     );
                  }

                  if (!SELECTING_OBJECT && RSMapperClient.editor.tool != null && RSMapperClient.editor.tool.getActionText() != null) {
                     for(int k = RSMapperClient.editor.tool.getActionText().length - 1; k >= 0; --k) {
                        Node_Sub32.drawRightClickOptions(
                           false,
                           RSMapperClient.editor.tool.getActionValues()[k],
                           0L,
                           localX,
                           localY,
                           RSMapperClient.editor.tool.getActionText()[k],
                           58,
                           true,
                           Class173.anInt2086,
                           "",
                           (long)(localY | localX << 0),
                           (byte)-18,
                           true
                        );
                     }
                  }

                  Node_Sub32.drawRightClickOptions(
                     false,
                     ToolData.ActionValues.TELEPORT.getValue(),
                     0L,
                     localX,
                     localY,
                     "<col=ffffff>Teleport</col>",
                     58,
                     true,
                     Class173.anInt2086,
                     "",
                     (long)(localY | localX << 0),
                     (byte)-18,
                     true
                  );
                  Node_Sub32.drawRightClickOptions(
                     false, 1, 0L, localX, localY, Class173.aString2085, 58, true, Class173.anInt2086, "", (long)(localY | localX << 0), (byte)-18, true
                  );
                  ++InputStream_Sub1.anInt76;
               }
            }

            if (localX >= 0 && localX < 104 && localY >= 0 && localY < 104) {
               if (!SELECTING_OBJECT) {
                  OBJECT_UNDER_CURSOR = null;
                  if (RSMapperClient.settings.displayHoverOverlay) {
                     RSMapperClient.editor.tool.handleTileHover(localX, localY);
                  }
               } else {
                  int camX = ((Class98.cameraPosX >> 9) + Node_Sub53.gameSceneBaseX & 63) + 16;
                  int camY = ((Node_Sub10.cameraPosY >> 9) + Class320_Sub4.gameSceneBaseY & 63) + 16;
                  OBJECT_UNDER_CURSOR = null;
                  double closestDistance = 999999.0;

                  for(int i_22_ = i_0_; ~i_22_ > ~(Class71.aBoolean967 ? 2 : 1); ++i_22_) {
                     boolean bool = i_22_ == 0;
                     Class179 class179 = !bool ? Class7.aClass179_157 : Node_Sub36_Sub3.aClass179_10058;
                     Class103 class103 = class179.aClass103_2124;

                     for(EntityNode_Sub6 entitynode_sub6 = (EntityNode_Sub6)class103.method1113((byte)-113);
                        entitynode_sub6 != null;
                        entitynode_sub6 = (EntityNode_Sub6)class103.method1108(115)
                     ) {
                        if ((Node_Sub25_Sub1.aBoolean9952 || ~entitynode_sub6.anAnimable5990.plane == ~Class295.myPlayer.plane)
                           && entitynode_sub6.method971(graphicstoolkit, (byte)126, mouseYOnScreen, mouseXOnScreen)) {
                           int lx;
                           int ly;
                           if (!(entitynode_sub6.anAnimable5990 instanceof Mobile)) {
                              lx = entitynode_sub6.anAnimable5990.x >> 9;
                              ly = entitynode_sub6.anAnimable5990.y >> 9;
                           } else {
                              lx = ((Mobile)entitynode_sub6.anAnimable5990).aShort9119;
                              ly = ((Mobile)entitynode_sub6.anAnimable5990).aShort9120;
                           }

                           if (entitynode_sub6.anAnimable5990 instanceof WorldObject) {
                              WorldObject interface19 = (WorldObject)entitynode_sub6.anAnimable5990;
                              if (interface19 != null) {
                                 ObjectDefinition objectdefinition = Class186.aClass112_2256.getObjectDefinitionsForId(interface19.getId(-32136), 102);
                                 if (objectdefinition != null) {
                                    double distance = Point2D.distance((double)lx, (double)ly, (double)camX, (double)camY);
                                    if (distance < closestDistance) {
                                       OBJECT_UNDER_CURSOR = entitynode_sub6;
                                       closestDistance = distance;
                                    } else if (distance == closestDistance
                                       && OBJECT_UNDER_CURSOR != null
                                       && OBJECT_UNDER_CURSOR.anAnimable5990 != null
                                       && ((WorldObject)OBJECT_UNDER_CURSOR.anAnimable5990).getType(-118) == 22) {
                                       OBJECT_UNDER_CURSOR = entitynode_sub6;
                                    }
                                 }
                              }
                           }
                        }
                     }

                     if (Class71.aBoolean967) {
                        Class258.method3127((byte)122);
                     }

                     if (OBJECT_UNDER_CURSOR != null) {
                        outlineObjectUnderCursor();
                     } else if (RSMapperClient.editor.objectEditor.VIEWER_OPEN) {
                        RSMapperClient.editor.objectEditor.displayObjectOnModelViewer(0, 0);
                     }
                  }
               }
            }

            Class93_Sub2.mouseLocalX = localX;
            Class93_Sub2.mouseLocalY = localY;
            Class93_Sub2.mouseCoordX = localX + Node_Sub53.gameSceneBaseX;
            Class93_Sub2.mouseCoordY = localY + Class320_Sub4.gameSceneBaseY;
            Class93_Sub2.mousePointOnTile = pointOnTile;
            ((JTextField)UIPanels.generalComponents.get("mouse_x")).setText("" + (localX + Node_Sub53.gameSceneBaseX));
            ((JTextField)UIPanels.generalComponents.get("mouse_y")).setText("" + (localY + Class320_Sub4.gameSceneBaseY));
            ((JTextField)UIPanels.generalComponents.get("mouse_p")).setText("" + Class295.myPlayer.plane);
            Class173.aString2085 = "(" + localX + ", " + localY + ", " + Class295.myPlayer.plane + ")";
            int baseX = 64 * (RSMapperClient.regionId >> 8);
            int baseY = 64 * (RSMapperClient.regionId & 0xFF);
            int maxX = baseX + 63;
            int maxY = baseY + 63;
            if (localX + Node_Sub53.gameSceneBaseX <= maxX
               && localY + Class320_Sub4.gameSceneBaseY <= maxY
               && localX + Node_Sub53.gameSceneBaseX >= baseX
               && localY + Class320_Sub4.gameSceneBaseY >= baseY
               && RSMapperClient.settings.hoverOverlayText != null
               && !RSMapperClient.settings.hoverOverlayText.equalsIgnoreCase("none")) {
               String text = RSMapperClient.settings.getOverlayText(Class93_Sub2.mouseCoordX, Class93_Sub2.mouseCoordY, Class295.myPlayer.plane);
               r.createTextMarker(
                  text.equalsIgnoreCase("-1") ? "0" : text,
                  Class93_Sub2.mouseCoordX,
                  Class93_Sub2.mouseCoordY,
                  Class295.myPlayer.plane,
                  RSMapperClient.settings.overlayTextHeight,
                  16777215,
                  1
               );
               if (RSMapperClient.settings.displayTextOnAllHovered
                  && RSMapperClient.editor.brush.getSize() > 1
                  && !RSMapperClient.settings.hoverOverlayText.equalsIgnoreCase("distance")) {
                  for(WorldTile tile : RSMapperClient.editor.brush.getTilesBasedOnBrushAndSize(localX, localY, Class295.myPlayer.plane, true)) {
                     if (tile.getLocalX() != localX || tile.getLocalY() != localY) {
                        text = RSMapperClient.settings.getOverlayText(tile.getX(), tile.getY(), tile.getPlane());
                        r.createTextMarker(
                           text.equalsIgnoreCase("-1") ? "0" : text,
                           tile.getLocalX(),
                           tile.getLocalY(),
                           tile.getPlane(),
                           RSMapperClient.settings.overlayTextHeight,
                           16777215,
                           1
                        );
                     }
                  }
               }
            }
         }

         if (Class71.aBoolean967) {
            Class258.method3127((byte)122);
         }
      }
   }

   public static void outlineObjectUnderCursor() {
      if (OBJECT_UNDER_CURSOR != null) {
         WorldObject object = (WorldObject)OBJECT_UNDER_CURSOR.anAnimable5990;
         if (object != null) {
            int lx;
            int ly;
            if (!(OBJECT_UNDER_CURSOR.anAnimable5990 instanceof Mobile)) {
               lx = OBJECT_UNDER_CURSOR.anAnimable5990.x >> 9;
               ly = OBJECT_UNDER_CURSOR.anAnimable5990.y >> 9;
            } else {
               lx = ((Mobile)OBJECT_UNDER_CURSOR.anAnimable5990).aShort9119;
               ly = ((Mobile)OBJECT_UNDER_CURSOR.anAnimable5990).aShort9120;
            }

            ObjectDefinition objectdefinition = Class186.aClass112_2256.getObjectDefinitionsForId(object.getId(-32136), 102);
            if (RSMapperClient.editor.objectEditor.VIEWER_OPEN) {
               RSMapperClient.editor
                  .objectEditor
                  .displayObjectOnModelViewer(objectdefinition.objectId, objectdefinition.possibleTypes != null ? objectdefinition.possibleTypes[0] : 10);
            }

            boolean ortho = Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false) == 1;
            int sizeX = (object.getRotation(23796) + 1) % 2 == 1 ? objectdefinition.sizeX : objectdefinition.sizeY;
            int sizeY = (object.getRotation(23796) + 1) % 2 == 1 ? objectdefinition.sizeY : objectdefinition.sizeX;
            if (!ortho && Class167.anInt2033 < Node_Sub25_Sub2.aClass54Array9959.length - 3) {
               Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asTileBorder(24, sizeX, sizeY, lx, ly, Class295.myPlayer.plane);
               Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asVerticeHighlight(22, lx, ly, Class295.myPlayer.plane);
            } else if (ortho) {
               for(int x = lx; x < lx + sizeX; ++x) {
                  for(int y = ly; y < ly + sizeY; ++y) {
                     if (x < 104 && x >= 0 && y < 104 && y >= 0) {
                        r.createTileMarker(x, y, Class295.myPlayer.plane, 0, RSMapperClient.settings.hoverOverlayColor, 0);
                     }
                  }
               }
            }
         }
      }
   }

   public static void setMinimapRefreshDelay() {
      MINIMAP_REFRESH_DELAY = System.currentTimeMillis() + 1000L;
   }

   public static void refreshMapWithNewProperties() {
      if (RSMapperClient.MAP_LOADED) {
         boolean undermap = RSMapperClient.undermapArchiveId != -1 || RSMapperClient.underlandArchiveId != -1;
         int i_35_;
         if (~Class213.aNode_Sub27_2512.aClass320_Sub16_7316.method3744(false) == -2) {
            i_35_ = CacheNode_Sub15.anIntArray9586[Node_Sub38_Sub25.CURRENT_GAME_SCENE_SIZE];
         } else {
            i_35_ = CacheNode_Sub14.anIntArray9575[Node_Sub38_Sub25.CURRENT_GAME_SCENE_SIZE];
         }

         if (Class93.aGraphicsToolkit1241.p()) {
            ++i_35_;
         }

         AbstractToolkit.method1267(
            Class93.aGraphicsToolkit1241,
            Class244.RENDER_CORES,
            Node_Sub54.GAME_SCENE_WDITH,
            Class377_Sub1.GAME_SCENE_HEIGHT,
            i_35_,
            undermap,
            Class93.aGraphicsToolkit1241.getanInt6367() > 0
         );
         Class59.aBoolean867 = false;
         Node_Sub9_Sub5.method2528(1390489120);
         Class237.anInt2906 = Class213.aNode_Sub27_2512.aClass320_Sub12_7282.method3730(false);
         Class339_Sub6.aBoolean8715 = Class201.anInt2446 >= 96;
         Class34.aBoolean532 = Class213.aNode_Sub27_2512.aClass320_Sub26_7269.method3779(false) == 2;
         Class163.aBoolean2015 = Class213.aNode_Sub27_2512.aClass320_Sub24_7317.method3773(false) == 1;
         Class256.anInt3237 = ~Class213.aNode_Sub27_2512.aClass320_Sub19_7301.method3751(false) == -2 ? -1 : Class94.anInt1249;
         Class382.aBoolean5254 = Class213.aNode_Sub27_2512.aClass320_Sub23_7290.method3770(false) == 1;
         Class169_Sub2_Sub1.aBoolean10563 = Class213.aNode_Sub27_2512.aClass320_Sub30_7275.method3796(false) == 1;
         Runtime runtime = Runtime.getRuntime();
         int memoryUsage = (int)((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
         if (memoryUsage >= 350000) {
            System.gc();
         }

         Node_Sub38_Sub1.aClass277_Sub1_Map = new Class277_Sub1(4, Node_Sub54.GAME_SCENE_WDITH, Class377_Sub1.GAME_SCENE_HEIGHT, false);
         if (Class61.anInt898 == 0) {
            Actor.loadCachedMap(Class188_Sub1_Sub1.mapFileData, (byte)-74, Node_Sub38_Sub1.aClass277_Sub1_Map, false);
            if (RSMapperClient.editor.mapEditor.dataLoaded) {
               Node_Sub38_Sub1.aClass277_Sub1_Map.tileHeights = RSMapperClient.editor.mapEditor.heights;
               Node_Sub38_Sub1.aClass277_Sub1_Map.tileOverlays = RSMapperClient.editor.mapEditor.overlays;
               Node_Sub38_Sub1.aClass277_Sub1_Map.tileUnderlays = RSMapperClient.editor.mapEditor.underlays;
               Node_Sub38_Sub1.aClass277_Sub1_Map.tileShapes = RSMapperClient.editor.mapEditor.shapes;
               Node_Sub38_Sub1.aClass277_Sub1_Map.tileRotations = RSMapperClient.editor.mapEditor.rotations;
               Class277.tileFlags = RSMapperClient.editor.mapEditor.flags;
            }
         } else {
            Class368.method4078(Class188_Sub1_Sub1.mapFileData, (byte)-119, Node_Sub38_Sub1.aClass277_Sub1_Map);
         }

         Class290_Sub2.method3426(Node_Sub54.GAME_SCENE_WDITH >> 4, (byte)119, Class377_Sub1.GAME_SCENE_HEIGHT >> 4);
         Class89.method1022(false);
         if (undermap) {
            Node_Sub38_Sub17.method2842(true);
            Class270_Sub1.aClass277_Sub1_Undermap = new Class277_Sub1(1, Node_Sub54.GAME_SCENE_WDITH, Class377_Sub1.GAME_SCENE_HEIGHT, true);
            if (Class61.anInt898 == 0) {
               Actor.loadCachedMap(Class320_Sub6.undermapFileData, (byte)-74, Class270_Sub1.aClass277_Sub1_Undermap, false);
               Node_Sub24.method2650(true, -14651);
            } else {
               Class368.method4078(Class320_Sub6.undermapFileData, (byte)-116, Class270_Sub1.aClass277_Sub1_Undermap);
               Node_Sub24.method2650(true, -14651);
            }

            Class270_Sub1.aClass277_Sub1_Undermap.method3343(Node_Sub38_Sub1.aClass277_Sub1_Map.tileHeights[0], (byte)119, 0);
            if (RSMapperClient.editor.mapEditor.dataLoaded) {
               for(int j = 0; j < RSMapperClient.editor.mapEditor.um_heights[0].length; ++j) {
                  for(int k = 0; k < RSMapperClient.editor.mapEditor.um_heights[0][j].length; ++k) {
                     RSMapperClient.editor.mapEditor.um_heights[0][j][k] += RSMapperClient.editor.mapEditor.heights[0][j][k];
                  }
               }

               Class270_Sub1.aClass277_Sub1_Undermap.tileHeights = RSMapperClient.editor.mapEditor.um_heights;
               Class270_Sub1.aClass277_Sub1_Undermap.tileOverlays = RSMapperClient.editor.mapEditor.um_overlays;
               Class270_Sub1.aClass277_Sub1_Undermap.tileUnderlays = RSMapperClient.editor.mapEditor.um_underlays;
               Class270_Sub1.aClass277_Sub1_Undermap.tileShapes = RSMapperClient.editor.mapEditor.um_shapes;
               Class270_Sub1.aClass277_Sub1_Undermap.tileRotations = RSMapperClient.editor.mapEditor.um_rotations;
            }

            Class270_Sub1.aClass277_Sub1_Undermap.method3339(-2, null, Class93.aGraphicsToolkit1241, null);
            Node_Sub38_Sub17.method2842(false);
         }

         Node_Sub38_Sub1.aClass277_Sub1_Map
            .method3339(-2, undermap ? Class270_Sub1.aClass277_Sub1_Undermap.tileHeights : null, Class93.aGraphicsToolkit1241, Class304.SCENE_CLIP_DATA_PLANES);
         if (!RSMapperClient.editor.objectEditor.HIDE_OBJECTS) {
            if (Class61.anInt898 != 0) {
               Node_Sub24.method2650(true, -14651);
               CacheNode_Sub7.method2317(FileOnDisk.landFileData, (byte)-122, Node_Sub38_Sub1.aClass277_Sub1_Map);
            } else {
               Node_Sub24.method2650(true, -14651);
               Class178.spawnCachedObjects(31269, FileOnDisk.landFileData, Node_Sub38_Sub1.aClass277_Sub1_Map);
               if (Class194.npcFileData != null) {
                  Class201.loadCachedNPCs();
               }
            }

            Node_Sub36_Sub2.method2761((byte)125);
            if (Class201.anInt2446 < 96) {
               Class189.method1934((byte)17);
            }
         }

         Node_Sub24.method2650(true, -14651);
         Node_Sub38_Sub1.aClass277_Sub1_Map.method3346((byte)75, Class93.aGraphicsToolkit1241, undermap ? Class368.aPlaneArray4548[0] : null, null);
         Node_Sub38_Sub1.aClass277_Sub1_Map.method3356(false, Class93.aGraphicsToolkit1241, (byte)83);
         Node_Sub24.method2650(true, -14651);
         if (undermap) {
            Node_Sub38_Sub17.method2842(true);
            Node_Sub24.method2650(true, -14651);
            if (~Class61.anInt898 != -1) {
               CacheNode_Sub7.method2317(Class320_Sub18.underLandFileData, (byte)-92, Class270_Sub1.aClass277_Sub1_Undermap);
            } else if (!RSMapperClient.editor.objectEditor.HIDE_OBJECTS) {
               Class178.spawnCachedObjects(31269, Class320_Sub18.underLandFileData, Class270_Sub1.aClass277_Sub1_Undermap);
            }

            Node_Sub36_Sub2.method2761((byte)125);
            Node_Sub24.method2650(true, -14651);
            Class270_Sub1.aClass277_Sub1_Undermap.method3346((byte)75, Class93.aGraphicsToolkit1241, null, Node_Sub38_Sub37.aPlaneArray10466[0]);
            Class270_Sub1.aClass277_Sub1_Undermap.method3356(true, Class93.aGraphicsToolkit1241, (byte)83);
            Node_Sub24.method2650(true, -14651);
            Node_Sub38_Sub17.method2842(false);
         }

         Class115.method1159(-122);

         for(int j = 0; j < RSMapperClient.editor.mapEditor.um_heights[0].length; ++j) {
            for(int k = 0; k < RSMapperClient.editor.mapEditor.um_heights[0][j].length; ++k) {
               RSMapperClient.editor.mapEditor.um_heights[0][j][k] -= RSMapperClient.editor.mapEditor.heights[0][j][k];
            }
         }
      }
   }

   final boolean method777(byte b) {
      ++anInt1037;
      if (b != -9) {
         this.method777((byte)66);
      }

      return this.aByte1027 == 2 || ~this.aByte1027 == -4;
   }

   static final boolean method778(int i, int i_59_, int i_60_, boolean bool, int i_61_, int i_62_, int i_63_, int i_64_, int i_65_) {
      ++anInt1040;
      int i_66_ = 10 % ((i_64_ - -14) / 44);
      int i_67_ = Class295.myPlayer.scenePositionXQueue[0];
      int i_68_ = Class295.myPlayer.scenePositionYQueue[0];
      if (~i_67_ > -1 || i_67_ >= Node_Sub54.GAME_SCENE_WDITH || ~i_68_ > -1 || ~Class377_Sub1.GAME_SCENE_HEIGHT >= ~i_68_) {
         return false;
      } else if (i_61_ >= 0 && ~Node_Sub54.GAME_SCENE_WDITH < ~i_61_ && ~i_59_ <= -1 && i_59_ < Class377_Sub1.GAME_SCENE_HEIGHT) {
         int i_69_ = Class275.method3332(
            i_59_,
            Class295.myPlayer.getSize((byte)107),
            bool,
            i_62_,
            i_67_,
            i_60_,
            Class258.calculatedScenePositionYs,
            (byte)-41,
            i_65_,
            i_68_,
            i_63_,
            Class304.SCENE_CLIP_DATA_PLANES[Class295.myPlayer.plane],
            Class328_Sub1.calculatedScenePositionXs,
            i_61_,
            i
         );
         if (i_69_ < 1) {
            return false;
         } else {
            Class359.minimapFlagLocalX = Class328_Sub1.calculatedScenePositionXs[-1 + i_69_];
            Node_Sub15_Sub4.minimapFlagLocalY = Class258.calculatedScenePositionYs[i_69_ - 1];
            Class144.aBoolean1791 = false;
            NpcDefinition.method3002((byte)97);
            return true;
         }
      } else {
         return false;
      }
   }

   static final void method779(int i, int i_70_, byte b) {
      ++anInt1032;
      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 5, (long)i);
      cachenode_sub2.method2288(0);
      if (b != -36) {
         index14 = null;
      }

      cachenode_sub2.anInt9434 = i_70_;
   }

   static final void method780(long l, int i, GraphicsToolkit graphicstoolkit) {
      CacheNode_Sub12.anInt9555 = Class280.anInt3570;
      ++anInt1024;
      Class228.anInt2719 = i;
      za_Sub2.anInt10514 = 0;
      Class280.anInt3570 = 0;
      long l_71_ = Class313.method3650(false);

      for(EntityNode_Sub4 entitynode_sub4 = (EntityNode_Sub4)Animable_Sub2.aClass103_9116.method1113((byte)-128);
         entitynode_sub4 != null;
         entitynode_sub4 = (EntityNode_Sub4)Animable_Sub2.aClass103_9116.method1108(109)
      ) {
         if (entitynode_sub4.method962(graphicstoolkit, l)) {
            ++za_Sub2.anInt10514;
         }
      }

      if (Class327.aBoolean5347 && ~(l % 100L) == -1L) {
         System.out.println("Particle system count: " + Animable_Sub2.aClass103_9116.method1107(-1) + ", running: " + za_Sub2.anInt10514);
         System.out
            .println("Emitters: " + Class228.anInt2719 + " Particles: " + Class280.anInt3570 + ". Time taken: " + (-l_71_ + Class313.method3650(false)) + "ms");
      }
   }

   public static void method781(boolean bool) {
      anIntArray1030 = null;
      if (!bool) {
         method779(-3, 113, (byte)76);
      }

      anIntArray1031 = null;
      index14 = null;
   }

   public static void handleCameraMove(char key) {
      if (key == 'w' || key == 'a' || key == 's' || key == 'd') {
         RSMapperClient.settings.HIDE_CAMERA_ICON = true;
         int angle = (int)Node_Sub12.cameraRotationHorizontal >> 3;
         int direction = 0;
         if (angle < 1920 && angle >= 1665) {
            direction = 1;
         } else if (angle < 1665 && angle >= 1410) {
            direction = 2;
         } else if (angle < 1410 && angle >= 1160) {
            direction = 3;
         } else if (angle < 1160 && angle >= 900) {
            direction = 4;
         } else if (angle < 900 && angle >= 630) {
            direction = 5;
         } else if (angle < 630 && angle >= 390) {
            direction = 6;
         } else if (angle < 390 && angle >= 120) {
            direction = 7;
         }

         if (key == 'w') {
            switch(direction) {
               case 0:
                  sendTeleport(0, 1, Class295.myPlayer.plane, false);
                  break;
               case 1:
                  sendTeleport(1, 1, Class295.myPlayer.plane, false);
                  break;
               case 2:
                  sendTeleport(1, 0, Class295.myPlayer.plane, false);
                  break;
               case 3:
                  sendTeleport(1, -1, Class295.myPlayer.plane, false);
                  break;
               case 4:
                  sendTeleport(0, -1, Class295.myPlayer.plane, false);
                  break;
               case 5:
                  sendTeleport(-1, -1, Class295.myPlayer.plane, false);
                  break;
               case 6:
                  sendTeleport(-1, 0, Class295.myPlayer.plane, false);
                  break;
               case 7:
                  sendTeleport(-1, 1, Class295.myPlayer.plane, false);
            }
         }

         if (key == 'a') {
            switch(direction) {
               case 0:
                  sendTeleport(-1, 0, Class295.myPlayer.plane, false);
                  break;
               case 1:
                  sendTeleport(-1, 1, Class295.myPlayer.plane, false);
                  break;
               case 2:
                  sendTeleport(0, 1, Class295.myPlayer.plane, false);
                  break;
               case 3:
                  sendTeleport(1, 1, Class295.myPlayer.plane, false);
                  break;
               case 4:
                  sendTeleport(1, 0, Class295.myPlayer.plane, false);
                  break;
               case 5:
                  sendTeleport(1, -1, Class295.myPlayer.plane, false);
                  break;
               case 6:
                  sendTeleport(0, -1, Class295.myPlayer.plane, false);
                  break;
               case 7:
                  sendTeleport(-1, -1, Class295.myPlayer.plane, false);
            }
         }

         if (key == 's') {
            switch(direction) {
               case 0:
                  sendTeleport(0, -1, Class295.myPlayer.plane, false);
                  break;
               case 1:
                  sendTeleport(-1, -1, Class295.myPlayer.plane, false);
                  break;
               case 2:
                  sendTeleport(-1, 0, Class295.myPlayer.plane, false);
                  break;
               case 3:
                  sendTeleport(-1, 1, Class295.myPlayer.plane, false);
                  break;
               case 4:
                  sendTeleport(0, 1, Class295.myPlayer.plane, false);
                  break;
               case 5:
                  sendTeleport(1, 1, Class295.myPlayer.plane, false);
                  break;
               case 6:
                  sendTeleport(1, 0, Class295.myPlayer.plane, false);
                  break;
               case 7:
                  sendTeleport(1, -1, Class295.myPlayer.plane, false);
            }
         }

         if (key == 'd') {
            switch(direction) {
               case 0:
                  sendTeleport(1, 0, Class295.myPlayer.plane, false);
                  break;
               case 1:
                  sendTeleport(1, -1, Class295.myPlayer.plane, false);
                  break;
               case 2:
                  sendTeleport(0, -1, Class295.myPlayer.plane, false);
                  break;
               case 3:
                  sendTeleport(-1, -1, Class295.myPlayer.plane, false);
                  break;
               case 4:
                  sendTeleport(-1, 0, Class295.myPlayer.plane, false);
                  break;
               case 5:
                  sendTeleport(-1, 1, Class295.myPlayer.plane, false);
                  break;
               case 6:
                  sendTeleport(0, 1, Class295.myPlayer.plane, false);
                  break;
               case 7:
                  sendTeleport(1, 1, Class295.myPlayer.plane, false);
            }
         }

         switch(direction) {
            case 0:
               Class295.myPlayer.method849(8192, 1, true);
               break;
            case 1:
               Class295.myPlayer.method849(10240, 1, true);
               break;
            case 2:
               Class295.myPlayer.method849(12288, 1, true);
               break;
            case 3:
               Class295.myPlayer.method849(14336, 1, true);
               break;
            case 4:
               Class295.myPlayer.method849(0, 1, true);
               break;
            case 5:
               Class295.myPlayer.method849(2048, 1, true);
               break;
            case 6:
               Class295.myPlayer.method849(4096, 1, true);
               break;
            case 7:
               Class295.myPlayer.method849(6144, 1, true);
         }
      }
   }

   public static void handleMoveTileSelection(char key) {
      if (key == 'w' || key == 'a' || key == 's' || key == 'd') {
         WorldTile selectedTile = RSMapperClient.editor.selectedTile;
         int x = selectedTile.getLocalX();
         int y = selectedTile.getLocalY();
         int p = selectedTile.getPlane();
         int angle = (int)Node_Sub12.cameraRotationHorizontal >> 3;
         int direction = 0;
         if (angle < 1920 && angle >= 1665) {
            direction = 1;
         } else if (angle < 1665 && angle >= 1410) {
            direction = 2;
         } else if (angle < 1410 && angle >= 1160) {
            direction = 3;
         } else if (angle < 1160 && angle >= 900) {
            direction = 4;
         } else if (angle < 900 && angle >= 630) {
            direction = 5;
         } else if (angle < 630 && angle >= 390) {
            direction = 6;
         } else if (angle < 390 && angle >= 120) {
            direction = 7;
         }

         if (key == 'w') {
            switch(direction) {
               case 0:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x, y + 1, p, true));
                  break;
               case 1:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x + 1, y + 1, p, true));
                  break;
               case 2:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x + 1, y, p, true));
                  break;
               case 3:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x + 1, y - 1, p, true));
                  break;
               case 4:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x, y - 1, p, true));
                  break;
               case 5:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x - 1, y - 1, p, true));
                  break;
               case 6:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x - 1, y, p, true));
                  break;
               case 7:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x - 1, y + 1, p, true));
            }
         }

         if (key == 'a') {
            switch(direction) {
               case 0:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x - 1, y, p, true));
                  break;
               case 1:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x - 1, y + 1, p, true));
                  break;
               case 2:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x, y + 1, p, true));
                  break;
               case 3:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x + 1, y + 1, p, true));
                  break;
               case 4:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x + 1, y, p, true));
                  break;
               case 5:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x + 1, y - 1, p, true));
                  break;
               case 6:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x, y - 1, p, true));
                  break;
               case 7:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x - 1, y - 1, p, true));
            }
         }

         if (key == 's') {
            switch(direction) {
               case 0:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x, y - 1, p, true));
                  break;
               case 1:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x - 1, y - 1, p, true));
                  break;
               case 2:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x - 1, y, p, true));
                  break;
               case 3:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x - 1, y + 1, p, true));
                  break;
               case 4:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x, y + 1, p, true));
                  break;
               case 5:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x + 1, y + 1, p, true));
                  break;
               case 6:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x + 1, y, p, true));
                  break;
               case 7:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x + 1, y - 1, p, true));
            }
         }

         if (key == 'd') {
            switch(direction) {
               case 0:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x + 1, y, p, true));
                  break;
               case 1:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x + 1, y - 1, p, true));
                  break;
               case 2:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x, y - 1, p, true));
                  break;
               case 3:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x - 1, y - 1, p, true));
                  break;
               case 4:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x - 1, y, p, true));
                  break;
               case 5:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x - 1, y + 1, p, true));
                  break;
               case 6:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x, y + 1, p, true));
                  break;
               case 7:
                  RSMapperClient.editor.setSelectedTile(new WorldTile(x + 1, y + 1, p, true));
            }
         }
      }
   }

   Class78(byte b, int i, int i_72_, int i_73_, int i_74_, int i_75_, int i_76_, Animable animable) {
      this.anInt1026 = i_76_;
      this.aByte1027 = b;
      this.anInt1038 = i;
      this.anInt1022 = i_73_;
      this.anInt1036 = i_75_;
      this.anInt1028 = i_72_;
      this.anAnimable1041 = animable;
      this.anInt1034 = i_74_;
   }
}
