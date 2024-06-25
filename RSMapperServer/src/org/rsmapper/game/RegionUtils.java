package org.rsmapper.game;

import org.rsmapper.utilities.misc.Utils;

public class RegionUtils {
   public static RegionUtils.Area getArea(int minX, int minY, int maxX, int maxY) {
      return getArea(RegionUtils.Structure.TILE, minX, minY, maxX, maxY);
   }

   public static RegionUtils.Area getArea(RegionUtils.Structure structure, int minX, int minY, int maxX, int maxY) {
      return new RegionUtils.Area(structure, minX, minY, maxX - minY, maxY - minY);
   }

   public static RegionUtils.Area convert(RegionUtils.Structure to, RegionUtils.Area area) {
      int x = area.getMapX() / to.getWidth();
      int y = area.getMapY() / to.getHeight();
      int width = area.getMapWidth() / to.getWidth();
      int height = area.getMapHeight() / to.getHeight();
      return new RegionUtils.Area(to, x, y, width, height);
   }

   public static int[] convert(RegionUtils.Structure from, RegionUtils.Structure to, int... xy) {
      return new int[]{xy[0] * from.getWidth() / to.getWidth(), xy[1] * from.getHeight() / to.getHeight()};
   }

   public static int encode(RegionUtils.Structure structure, int... xyp) {
      return structure.encode(xyp[0], xyp[1], xyp.length == 3 ? xyp[2] : 0);
   }

   public static final class Area {
      private RegionUtils.Structure structure;
      private int x;
      private int y;
      private int width;
      private int height;

      public Area(RegionUtils.Structure structure, int x, int y, int width, int height) {
         this.structure = structure;
         this.x = x;
         this.y = y;
         this.width = width;
         this.height = height;
      }

      public int getX() {
         return this.x;
      }

      public int getY() {
         return this.y;
      }

      public int getMapX() {
         return this.x * this.structure.getWidth();
      }

      public int getMapY() {
         return this.y * this.structure.getHeight();
      }

      public int getMapWidth() {
         return this.width * this.structure.getWidth();
      }

      public int getMapHeight() {
         return this.height * this.structure.getHeight();
      }

      public RegionUtils.Structure getStructure() {
         return this.structure;
      }

      public int hashCode() {
         return this.structure.encode(this.x, this.y, 0);
      }

      public String toString() {
         return "Structure: " + this.structure.toString() + ", x: " + this.x + ", y: " + this.y + ", width: " + this.width + ", height: " + this.height;
      }
   }

   public static enum Structure {
      TILE((RegionUtils.Structure)null, 1, 1, new RegionUtils.StructureEncoder() {
         public int encode(int x, int y, int plane) {
            return y | x << 14 | plane << 28;
         }
      }),
      CHUNK(TILE, 8, 8, new RegionUtils.StructureEncoder() {
         public int encode(int x, int y, int plane) {
            return x << 14 | y << 3 | plane << 24;
         }
      }),
      REGION(CHUNK, 8, 8, new RegionUtils.StructureEncoder() {
         public int encode(int x, int y, int plane) {
            return x << 8 | y | plane << 16;
         }
      }),
      MAP(REGION, 255, 255);

      private RegionUtils.Structure child;
      private int width;
      private int height;
      private RegionUtils.StructureEncoder encoder;

      private Structure(RegionUtils.Structure child, int width, int height, RegionUtils.StructureEncoder encode) {
         this.child = child;
         this.width = width;
         this.height = height;
         this.encoder = encode;
      }

      private Structure(RegionUtils.Structure child, int width, int height) {
         this(child, width, height, (RegionUtils.StructureEncoder)null);
      }

      public int getWidth() {
         int x = this.width;

         for(RegionUtils.Structure nextChild = this.child; nextChild != null; nextChild = nextChild.child) {
            x *= nextChild.width;
         }

         return x;
      }

      public int getChildWidth() {
         return this.width;
      }

      public int getHeight() {
         int y = this.height;

         for(RegionUtils.Structure nextChild = this.child; nextChild != null; nextChild = nextChild.child) {
            y *= nextChild.height;
         }

         return y;
      }

      public int encode(int x, int y) {
         return this.encode(x, y, 0);
      }

      public int encode(int x, int y, int plane) {
         return this.encoder == null ? -1 : this.encoder.encode(x, y, plane);
      }

      public int getChildHeight() {
         return this.width;
      }

      public String toString() {
         return Utils.formatPlayerNameForDisplay(this.name());
      }
   }

   private interface StructureEncoder {
      int encode(int var1, int var2, int var3);
   }
}
