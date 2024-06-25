import java.util.ArrayList;

public class Class262_Sub6 extends Class262 {
   static int anInt7742;
   static int anInt7743;
   static int anInt7744;
   static Class124 aClass124_7745 = new Class124(42);
   private int anInt7746;
   private int anInt7747;
   static IncommingPacket aClass192_7748 = new IncommingPacket(84, 6);

   Class262_Sub6(Buffer buffer) {
      super(buffer);
      this.anInt7747 = buffer.readUnsignedShort();
      this.anInt7746 = buffer.method2183();
   }

   @Override
   final void method3148(int i) {
      ++anInt7742;
      Class369 class369 = Node_Sub39.aClass369Array7497[this.anInt7747];
      if (i >= -102) {
         clearItemsFromContainerWithKey(-55, false, (byte)-71);
      }

      Class110.method1131(
         class369.anInt4557,
         class369.anInt4563,
         class369.anInt4556,
         this.anInt7746,
         class369.anInt4560,
         class369.anInt4552,
         -4,
         Class248.objectTypeFlags[class369.anInt4556]
      );
   }

   static final void clearItemsFromContainerWithKey(int key, boolean keyLessIntegerSize, byte b) {
      ++anInt7744;
      Node_Sub16 node_sub16 = Class295.getItemContainer(key, (byte)18, keyLessIntegerSize);
      if (node_sub16 != null) {
         int i_0_ = 0;

         for(int i_1_ = -16 / ((b - -58) / 52); ~i_0_ > ~node_sub16.slotItemIds.length; ++i_0_) {
            node_sub16.slotItemIds[i_0_] = -1;
            node_sub16.slotItemAmounts[i_0_] = 0;
         }
      }
   }

   public static void method3165(int i) {
      aClass192_7748 = null;
      aClass124_7745 = null;
      if (i != 0) {
         aClass124_7745 = null;
      }
   }

   static final void drawTileMarkers(byte b, int i, int i_2_, int i_3_, int i_4_, int i_5_, int i_6_) {
      ++anInt7743;
      if (b <= 41) {
         aClass192_7748 = null;
      }

      int baseX = 64 * (RSMapperClient.regionId >> 8);
      int baseY = 64 * (RSMapperClient.regionId & 0xFF);
      int maxX = baseX + 63;
      int maxY = baseY + 63;
      if (!RSMapperClient.settings.HIDE_CAMERA_ICON && Class295.myPlayer.isHidden) {
         r.createTextMarker("<copy>", Class295.myPlayer.x >> 9, Class295.myPlayer.y >> 9, Class295.myPlayer.plane, -20, 255, 1);
      }

      if (RSMapperClient.settings.markPropertyText != null && !RSMapperClient.settings.markPropertyText.equalsIgnoreCase("none")) {
         for(int x = baseX; x <= maxX; ++x) {
            for(int y = baseY; y <= maxY; ++y) {
               if (RSMapperClient.settings.canMarkTile(x, y, Class295.myPlayer.plane)) {
                  boolean hovered = Class93_Sub2.mouseCoordX == x && Class93_Sub2.mouseCoordY == y;
                  String property = RSMapperClient.settings.markPropertyText;
                  String marker = property.equalsIgnoreCase("Objects") ? "o" : (property.equalsIgnoreCase("Hide Roof") ? "^" : "<times>");
                  int color = hovered
                     ? RSMapperClient.settings.selectedOverlayColor
                     : (property.equalsIgnoreCase("Bridge") ? 573195 : (property.equalsIgnoreCase("Objects") ? 3440107 : 16711680));
                  r.createTextMarker(
                     marker,
                     Utils.getLocalXFromCoordX(x, RSMapperClient.regionId),
                     Utils.getLocalYFromCoordY(y, RSMapperClient.regionId),
                     Class295.myPlayer.plane,
                     RSMapperClient.settings.overlayTextHeight,
                     color,
                     1
                  );
               }
            }
         }
      }

      int padding = Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false) == 1 ? 4 + Class308.orthoZoom / 1000 : 1;

      for(TileMarker entitynode_sub2 = (TileMarker)Class226.aClass103_2684.method1113((byte)122);
         entitynode_sub2 != null;
         entitynode_sub2 = (TileMarker)Class226.aClass103_2684.method1108(88)
      ) {
         if (~entitynode_sub2.completeCycle >= ~Class174.clientCycle) {
            entitynode_sub2.method803(false);
         }

         if (!WorldmapDefinitions.worldmapIsOpen()) {
            switch(entitynode_sub2.type) {
               case TEXT:
                  Animable_Sub3.method919(
                     entitynode_sub2.plane,
                     (entitynode_sub2.y << 9) + 256 * entitynode_sub2.pointY1,
                     2 * entitynode_sub2.height,
                     (entitynode_sub2.x << 9) + 256 * entitynode_sub2.pointX1,
                     false,
                     0
                  );
                  Class262_Sub4.aClass52_7721
                     .method537(
                        0,
                        (byte)111,
                        Class119.anIntArray1516[0] + i_6_,
                        entitynode_sub2.message,
                        Class119.anIntArray1516[1] + i_5_,
                        entitynode_sub2.color | 0xFF000000
                     );
                  break;
               case TILE:
                  for(int x = 0; x <= 512; x += padding) {
                     Animable_Sub3.method919(entitynode_sub2.plane, entitynode_sub2.y << 9, 2 * entitynode_sub2.height, (entitynode_sub2.x << 9) + x, false, 0);
                     Class262_Sub4.aClass52_7721
                        .method537(
                           0,
                           (byte)111,
                           Class119.anIntArray1516[0] + i_6_,
                           ".",
                           Class119.anIntArray1516[1] + i_5_,
                           (x <= 32 ? 14878985 : entitynode_sub2.color) | 0xFF000000
                        );
                     Animable_Sub3.method919(
                        entitynode_sub2.plane, (entitynode_sub2.y << 9) + 512, 2 * entitynode_sub2.height, (entitynode_sub2.x << 9) + x, false, 0
                     );
                     Class262_Sub4.aClass52_7721
                        .method537(0, (byte)111, Class119.anIntArray1516[0] + i_6_, ".", Class119.anIntArray1516[1] + i_5_, entitynode_sub2.color | 0xFF000000);
                  }

                  for(int y = 0; y <= 512; y += padding) {
                     Animable_Sub3.method919(entitynode_sub2.plane, (entitynode_sub2.y << 9) + y, 2 * entitynode_sub2.height, entitynode_sub2.x << 9, false, 0);
                     Class262_Sub4.aClass52_7721
                        .method537(
                           0,
                           (byte)111,
                           Class119.anIntArray1516[0] + i_6_,
                           ".",
                           Class119.anIntArray1516[1] + i_5_,
                           (y <= 32 ? 14878985 : entitynode_sub2.color) | 0xFF000000
                        );
                     Animable_Sub3.method919(
                        entitynode_sub2.plane, (entitynode_sub2.y << 9) + y, 2 * entitynode_sub2.height, (entitynode_sub2.x << 9) + 512, false, 0
                     );
                     Class262_Sub4.aClass52_7721
                        .method537(0, (byte)111, Class119.anIntArray1516[0] + i_6_, ".", Class119.anIntArray1516[1] + i_5_, entitynode_sub2.color | 0xFF000000);
                  }
                  break;
               case SHAPE:
                  int x1 = entitynode_sub2.gridPoints ? entitynode_sub2.pointX1 * 256 : entitynode_sub2.pointX1;
                  int x2 = entitynode_sub2.gridPoints ? entitynode_sub2.pointX2 * 256 : entitynode_sub2.pointX2;
                  int y1 = entitynode_sub2.gridPoints ? entitynode_sub2.pointY1 * 256 : entitynode_sub2.pointY1;
                  int y2 = entitynode_sub2.gridPoints ? entitynode_sub2.pointY2 * 256 : entitynode_sub2.pointY2;
                  ArrayList<int[]> points = new ArrayList<>();
                  if (x1 != 0 && x2 != 0 && x1 != 512 && x2 != 512 && (x2 - x1 == 0 || x1 - x2 == 0)) {
                     for(int k = 0; k < 512; k += 2) {
                        points.add(new int[]{x1, y1 > y2 ? y1 - k : y1 + k});
                     }
                  } else if (y1 != 0 && y2 != 0 && y1 != 512 && y2 != 512 && (y2 - y1 == 0 || y1 - y2 == 0)) {
                     for(int k = 0; k < 512; k += 2) {
                        points.add(new int[]{x1 > x2 ? x1 - k : x1 + k, y1});
                     }
                  } else if ((y1 != y2 || x1 == x2) && (x1 != x2 || y1 == y2) && (x2 != 256 || y2 != 256)) {
                     int ydiff = y2 - y1;
                     int xdiff = x2 - x1;
                     double slope = x2 - x1 == 0 ? 0.0 : (double)(y2 - y1) / (double)(x2 - x1);
                     int quantity = Math.abs(xdiff) != 512 && Math.abs(ydiff) != 512 ? 120 : 160;
                     --quantity;

                     for(double k = 0.0; k < (double)quantity; ++k) {
                        double addY = slope == 0.0 ? 0.0 : (double)ydiff * (k / (double)quantity);
                        double addX = slope == 0.0 ? (double)xdiff * (k / (double)quantity) : addY / slope;
                        points.add(new int[]{(int)Math.round(addX) + x1, (int)Math.round(addY) + y1});
                     }

                     points.add(new int[]{x2, y2});
                  }

                  if (points.size() > 0) {
                     for(int[] point : points) {
                        int ix = point[0];
                        int iy = point[1];
                        Animable_Sub3.method919(
                           entitynode_sub2.plane, (entitynode_sub2.y << 9) + iy, 2 * entitynode_sub2.height, (entitynode_sub2.x << 9) + ix, false, 0
                        );
                        Class262_Sub4.aClass52_7721
                           .method537(
                              0, (byte)111, Class119.anIntArray1516[0] + i_6_, ".", Class119.anIntArray1516[1] + i_5_, entitynode_sub2.color | 0xFF000000
                           );
                     }
                  }
                  break;
               case LINE:
                   x1 = entitynode_sub2.pointX1;
                   x2 = entitynode_sub2.pointX2;
                   y1 = entitynode_sub2.pointY1;
                   y2 = entitynode_sub2.pointY2;
                   points = new ArrayList<>();
                  if (x1 == 0 && x2 == 0) {
                     for(int k = 0; k < y2; k += 4) {
                        points.add(new int[]{x1, y1 + k});
                     }
                  } else if (y1 == 0 && y2 == 0) {
                     for(int k = 0; k < x2; k += 4) {
                        points.add(new int[]{x1 + k, y1});
                     }
                  }

                  points.add(new int[]{x2, y2});
                  if (points.size() > 0) {
                     for(int[] point : points) {
                        int ix = point[0];
                        int iy = point[1];
                        Animable_Sub3.method919(
                           entitynode_sub2.plane, (entitynode_sub2.y << 9) + iy, 2 * entitynode_sub2.height, (entitynode_sub2.x << 9) + ix, false, 0
                        );
                        Class262_Sub4.aClass52_7721
                           .method537(
                              0, (byte)111, Class119.anIntArray1516[0] + i_6_, ".", Class119.anIntArray1516[1] + i_5_, entitynode_sub2.color | 0xFF000000
                           );
                     }
                  }
                  break;
               case HEIGHT:
                  int x = entitynode_sub2.gridPoints ? entitynode_sub2.pointX1 * 256 : entitynode_sub2.pointX1;
                  int y = entitynode_sub2.gridPoints ? entitynode_sub2.pointY1 * 256 : entitynode_sub2.pointY1;
                  int endHeight = entitynode_sub2.height;

                  for(int h = 0; h < endHeight; h += 2) {
                     Animable_Sub3.method919(entitynode_sub2.plane, (entitynode_sub2.y << 9) + y, h, (entitynode_sub2.x << 9) + x, false, 0);
                     Class262_Sub4.aClass52_7721
                        .method537(0, (byte)111, Class119.anIntArray1516[0] + i_6_, ".", Class119.anIntArray1516[1] + i_5_, entitynode_sub2.color | 0xFF000000);
                  }
                  break;
               default:
                  if (entitynode_sub2.spriteId != -1) {
                     sendSpriteOnTile(
                        entitynode_sub2.spriteId, entitynode_sub2.x, 200, entitynode_sub2.y, 256, entitynode_sub2.plane, entitynode_sub2.height, false, false
                     );
                  }
            }
         }
      }
   }

   public static void sendSpriteOnTile(int id, int x, int xOffset, int y, int yOffset, int plane, int height, boolean hflip, boolean vflip) {
      Animable_Sub3.method919(plane, (y << 9) + yOffset, 2 * height, (x << 9) + xOffset, false, 0);
      Class262_Sub4.aClass52_7721
         .method536b(
            IComponentDefinitions.getSprite(id, hflip, vflip, false, Class93.aGraphicsToolkit1241),
            RSMapperClient.settings.selectedOverlayColor | 0xFF000000,
            0,
            Class119.anIntArray1516[1],
            Class119.anIntArray1516[0],
            Class290_Sub6.anIntArray8123
         );
   }
}
