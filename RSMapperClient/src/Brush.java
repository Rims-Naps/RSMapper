import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JCheckBox;

public class Brush {
   static int MAX_SIZE = 15;
   BrushType type;
   int size;
   boolean multi;

   public Brush(BrushType type, int size, boolean multi) {
      this.type = type;
      this.size = size;
      this.setMulti(multi);
   }

   public BrushType getType() {
      return this.type;
   }

   public void setType(BrushType type) {
      this.type = type;
   }

   public int getSize() {
      return this.size;
   }

   public void setSize(int size) {
      this.size = size;
   }

   public boolean isMulti() {
      return this.multi;
   }

   public void setMulti(boolean multi) {
      JCheckBox chck = (JCheckBox)UIPanels.generalComponents.get("toggle_multi");
      Tool tool = RSMapperClient.editor != null && RSMapperClient.editor.tool != null ? RSMapperClient.editor.tool : null;
      if (tool != null && (tool == null || tool.supportsMulti())) {
         this.multi = multi;
         chck.setEnabled(tool.supportsMulti());
      } else {
         this.multi = false;
         chck.setEnabled(false);
      }

      chck.setSelected(this.multi);
      UIPanels.generalComponents.put("toggle_multi", chck);
   }

   public ArrayList<WorldTile> getTilesBasedOnBrushAndSize(WorldTile tile) {
      return this.getTilesBasedOnBrushAndSize(tile.getX(), tile.getY(), tile.getPlane(), false);
   }

   public ArrayList<WorldTile> getTilesBasedOnBrushAndSize(int x, int y, int plane, boolean localCoords) {
      ArrayList<WorldTile> tiles = new ArrayList<>();
      if (this.size == 1) {
         tiles.add(new WorldTile(x, y, plane, localCoords));
         return tiles;
      } else {
         int baseX = 64 * (RSMapperClient.regionId >> 8);
         int baseY = 64 * (RSMapperClient.regionId & 0xFF);
         if (localCoords) {
            x += baseX - 16;
            y += baseY - 16;
         }

         label165:
         switch(this.type) {
            case SQUARE:
               int startX = x - this.size / 2;
               int endX = x + this.size / 2;
               int startY = y - this.size / 2;
               int endY = y + this.size / 2;

               for(int iy = startY; iy <= endY; ++iy) {
                  for(int ix = startX; ix <= endX; ++ix) {
                     int localX = Utils.getLocalXFromCoordX(ix, RSMapperClient.regionId);
                     int localY = Utils.getLocalYFromCoordY(iy, RSMapperClient.regionId);
                     tiles.add(new WorldTile(localX, localY, plane, true));
                  }
               }
               break;
            case RHOMBUS:
               for(int radius = this.size / 2; radius >= 1; --radius) {
                  int ax = 0;
                  int ay = radius;

                  do {
                     tiles.add(new WorldTile(x + ax, y + ay, plane, false));
                     tiles.add(new WorldTile(x + ax, y - ay, plane, false));
                     tiles.add(new WorldTile(x - ax, y + ay, plane, false));
                     tiles.add(new WorldTile(x - ax, y - ay, plane, false));
                     tiles.add(new WorldTile(x + ay, y + ax, plane, false));
                     tiles.add(new WorldTile(x + ay, y - ax, plane, false));
                     tiles.add(new WorldTile(x - ay, y + ax, plane, false));
                     tiles.add(new WorldTile(x - ay, y - ax, plane, false));
                     --ay;
                  } while(++ax > ay);
               }

               tiles.add(new WorldTile(x, y, plane, false));
               break;
            case CIRCLE:
               for(int radius = this.size / 2; radius >= 1; --radius) {
                  int d = 3 - 2 * radius;
                  int ax = 0;
                  int ay = radius;

                  do {
                     tiles.add(new WorldTile(x + ax, y + ay, plane, false));
                     tiles.add(new WorldTile(x + ax, y - ay, plane, false));
                     tiles.add(new WorldTile(x - ax, y + ay, plane, false));
                     tiles.add(new WorldTile(x - ax, y - ay, plane, false));
                     tiles.add(new WorldTile(x + ay, y + ax, plane, false));
                     tiles.add(new WorldTile(x + ay, y - ax, plane, false));
                     tiles.add(new WorldTile(x - ay, y + ax, plane, false));
                     tiles.add(new WorldTile(x - ay, y - ax, plane, false));
                     if (d < 0) {
                        d = d + 4 * ax + 6;
                     } else {
                        d = d + 4 * (ax - ay) + 10;
                        --ay;
                     }
                  } while(++ax > ay);
               }

               if (this.size >= 5) {
                  tiles.add(new WorldTile(x - 1, y + 1, plane, false));
                  tiles.add(new WorldTile(x - 1, y - 1, plane, false));
                  tiles.add(new WorldTile(x + 1, y + 1, plane, false));
                  tiles.add(new WorldTile(x + 1, y - 1, plane, false));
                  if (this.size >= 11) {
                     tiles.add(new WorldTile(x - 4, y + 2, plane, false));
                     tiles.add(new WorldTile(x - 4, y - 2, plane, false));
                     tiles.add(new WorldTile(x - 2, y + 4, plane, false));
                     tiles.add(new WorldTile(x - 2, y - 4, plane, false));
                     tiles.add(new WorldTile(x + 4, y + 2, plane, false));
                     tiles.add(new WorldTile(x + 4, y - 2, plane, false));
                     tiles.add(new WorldTile(x + 2, y + 4, plane, false));
                     tiles.add(new WorldTile(x + 2, y - 4, plane, false));
                  }
               }

               tiles.add(new WorldTile(x, y, plane, false));
               break;
            case LINE_X:
                startX = x - this.size / 2;
                endX = x + this.size / 2;

               for(int ix = startX; ix <= endX; ++ix) {
                  int localX = Utils.getLocalXFromCoordX(ix, RSMapperClient.regionId);
                  tiles.add(new WorldTile(localX, Utils.getLocalYFromCoordY(y, RSMapperClient.regionId), plane, true));
               }
               break;
            case LINE_Y:
                startY = y - this.size / 2;
                endY = y + this.size / 2;

               for(int iy = startY; iy <= endY; ++iy) {
                  int localY = Utils.getLocalYFromCoordY(iy, RSMapperClient.regionId);
                  tiles.add(new WorldTile(Utils.getLocalXFromCoordX(x, RSMapperClient.regionId), localY, plane, true));
               }
               break;
            case CHECKERED:
                startX = x - this.size / 2;
                endX = x + this.size / 2;
                startY = y - this.size / 2;
                endY = y + this.size / 2;
               int xCount = 0;

               for(int iy = startY; iy <= endY; ++iy) {
                  for(int ix = startX; ix <= endX; ++ix) {
                     if (++xCount % 2 != 0) {
                        int localX = Utils.getLocalXFromCoordX(ix, RSMapperClient.regionId);
                        int localY = Utils.getLocalYFromCoordY(iy, RSMapperClient.regionId);
                        tiles.add(new WorldTile(localX, localY, plane, true));
                     }
                  }
               }
               break;
            case SQUARE_BORDER:
                startX = x - this.size / 2;
                endX = x + this.size / 2;
                startY = y - this.size / 2;
                endY = y + this.size / 2;

               for(int iy = startY; iy <= endY; ++iy) {
                  for(int ix = startX; ix <= endX; ++ix) {
                     if (iy == startY || iy == endY || ix == startX || ix == endX) {
                        int localX = Utils.getLocalXFromCoordX(ix, RSMapperClient.regionId);
                        int localY = Utils.getLocalYFromCoordY(iy, RSMapperClient.regionId);
                        tiles.add(new WorldTile(localX, localY, plane, true));
                     }
                  }
               }
               break;
            case RHOMBUS_BORDER:
               int radius = this.size / 2;
               int d = 3 - 2 * radius;
               int ax = 0;
               int ay = radius;

               while(true) {
                  tiles.add(new WorldTile(x + ax, y + ay, plane, false));
                  tiles.add(new WorldTile(x + ax, y - ay, plane, false));
                  tiles.add(new WorldTile(x - ax, y + ay, plane, false));
                  tiles.add(new WorldTile(x - ax, y - ay, plane, false));
                  tiles.add(new WorldTile(x + ay, y + ax, plane, false));
                  tiles.add(new WorldTile(x + ay, y - ax, plane, false));
                  tiles.add(new WorldTile(x - ay, y + ax, plane, false));
                  tiles.add(new WorldTile(x - ay, y - ax, plane, false));
                  --ay;
                  if (++ax > ay) {
                     break label165;
                  }
               }
            case CIRCLE_BORDER:
                radius = this.size / 2;
                d = 3 - 2 * radius;
                ax = 0;
                ay = radius;

               do {
                  tiles.add(new WorldTile(x + ax, y + ay, plane, false));
                  tiles.add(new WorldTile(x + ax, y - ay, plane, false));
                  tiles.add(new WorldTile(x - ax, y + ay, plane, false));
                  tiles.add(new WorldTile(x - ax, y - ay, plane, false));
                  tiles.add(new WorldTile(x + ay, y + ax, plane, false));
                  tiles.add(new WorldTile(x + ay, y - ax, plane, false));
                  tiles.add(new WorldTile(x - ay, y + ax, plane, false));
                  tiles.add(new WorldTile(x - ay, y - ax, plane, false));
                  if (d < 0) {
                     d = d + 4 * ax + 6;
                  } else {
                     d = d + 4 * (ax - ay) + 10;
                     --ay;
                  }
               } while(++ax <= ay);
         }

         Set<WorldTile> set = new HashSet<>(tiles);
         tiles.clear();
         tiles.addAll(set);
         return tiles;
      }
   }
}
