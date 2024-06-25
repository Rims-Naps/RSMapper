package org.rsmapper.game;

import java.io.Serializable;
import org.rsmapper.Constants;
import org.rsmapper.utilities.misc.Utils;

public class WorldTile implements Serializable {
   private static final long serialVersionUID = -6567346497259686765L;
   private short x;
   private short y;
   private byte plane;

   public WorldTile(int x, int y, int plane) {
      this.x = (short)x;
      this.y = (short)y;
      this.plane = (byte)plane;
   }

   public final WorldTile getLocation() {
      WorldTile tile = new WorldTile(this.x, this.y, this.plane);
      return tile;
   }

   public WorldTile(WorldTile tile) {
      this.x = tile.x;
      this.y = tile.y;
      this.plane = tile.plane;
   }

   public WorldTile(WorldTile tile, int randomize) {
      this.x = (short)(tile.x + Utils.getRandom(randomize * 2) - randomize);
      this.y = (short)(tile.y + Utils.getRandom(randomize * 2) - randomize);
      this.plane = tile.plane;
   }

   public WorldTile(int x, int y) {
      this.x = (short)x;
      this.y = (short)y;
      this.plane = 0;
   }

   public static WorldTile delta(WorldTile t, WorldTile d) {
      return new WorldTile(d.x - t.x, d.y - t.y, d.plane - t.plane);
   }

   public WorldTile transform(int x, int y, int plane) {
      return new WorldTile(this.x + x, this.y + y, this.plane + plane);
   }

   public void moveLocation(int xOffset, int yOffset, int planeOffset) {
      this.x = (short)(this.x + xOffset);
      this.y = (short)(this.y + yOffset);
      this.plane = (byte)(this.plane + planeOffset);
   }

   public final void setLocation(WorldTile tile) {
      this.setLocation(tile.x, tile.y, tile.plane);
   }

   public final void setLocation(int x, int y, int plane) {
      this.x = (short)x;
      this.y = (short)y;
      this.plane = (byte)plane;
   }

   public int getX() {
      return this.x;
   }

   public int getXInRegion() {
      return this.x & 63;
   }

   public int getYInRegion() {
      return this.y & 63;
   }

   public int getY() {
      return this.y;
   }

   public int getPlane() {
      return this.plane > 3 ? 3 : this.plane;
   }

   public int getChunkX() {
      return this.x >> 3;
   }

   public int getChunkY() {
      return this.y >> 3;
   }

   public int getRegionX() {
      return this.x >> 6;
   }

   public int getRegionY() {
      return this.y >> 6;
   }

   public int getRegionId() {
      return (this.getRegionX() << 8) + this.getRegionY();
   }

   public int getLocalX(WorldTile tile, int mapSize) {
      return this.x - 8 * (tile.getChunkX() - (Constants.MAP_SIZES[mapSize] >> 4));
   }

   public int getLocalY(WorldTile tile, int mapSize) {
      return this.y - 8 * (tile.getChunkY() - (Constants.MAP_SIZES[mapSize] >> 4));
   }

   public int getLocalX(WorldTile tile) {
      return this.getLocalX(tile, 0);
   }

   public int getLocalY(WorldTile tile) {
      return this.getLocalY(tile, 0);
   }

   public int getLocalX() {
      return this.getLocalX(this);
   }

   public int getLocalY() {
      return this.getLocalY(this);
   }

   public int get18BitsLocationHash() {
      return this.getRegionY() + (this.getRegionX() << 8) + (this.plane << 16);
   }

   public int get30BitsLocationHash() {
      return this.y + (this.x << 14) + (this.plane << 28);
   }

   public boolean withinDistance(WorldTile tile, int distance) {
      if (tile.plane != this.plane) {
         return false;
      } else {
         int deltaX = tile.x - this.x;
         int deltaY = tile.y - this.y;
         return deltaX <= distance && deltaX >= -distance && deltaY <= distance && deltaY >= -distance;
      }
   }

   public int getDistance(WorldTile tile) {
      return tile.x - this.x + (tile.y - this.y);
   }

   public int hashCode() {
      int prime = true;
      int result = 1;
      int result = 31 * result + this.plane;
      result = 31 * result + this.x;
      result = 31 * result + this.y;
      return result;
   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (obj == null) {
         return false;
      } else if (this.getClass() != obj.getClass()) {
         return false;
      } else {
         WorldTile other = (WorldTile)obj;
         if (this.plane != other.plane) {
            return false;
         } else if (this.x != other.x) {
            return false;
         } else {
            return this.y == other.y;
         }
      }
   }

   public boolean withinDistance(WorldTile tile) {
      if (tile.plane != this.plane) {
         return false;
      } else {
         return Math.abs(tile.x - this.x) <= 15 && Math.abs(tile.y - this.y) <= 15;
      }
   }

   public int getCoordFaceX(int sizeX) {
      return this.getCoordFaceX(sizeX, -1, -1);
   }

   public static final int getCoordFaceX(int x, int sizeX, int sizeY, int rotation) {
      return x + ((rotation != 1 && rotation != 3 ? sizeX : sizeY) - 1) / 2;
   }

   public static final int getCoordFaceY(int y, int sizeX, int sizeY, int rotation) {
      return y + ((rotation != 1 && rotation != 3 ? sizeY : sizeX) - 1) / 2;
   }

   public int getCoordFaceX(int sizeX, int sizeY, int rotation) {
      return this.x + ((rotation != 1 && rotation != 3 ? sizeX : sizeY) - 1) / 2;
   }

   public int getCoordFaceY(int sizeY) {
      return this.getCoordFaceY(-1, sizeY, -1);
   }

   public int getCoordFaceY(int sizeX, int sizeY, int rotation) {
      return this.y + ((rotation != 1 && rotation != 3 ? sizeY : sizeX) - 1) / 2;
   }

   public String toString() {
      return "WorldTile[x=" + this.x + ", y=" + this.y + ", plane=" + this.plane + "]";
   }

   public boolean matches(WorldTile other) {
      return this.x == other.x && this.y == other.y && this.plane == other.plane;
   }

   public int getRegionHash() {
      return this.getRegionY() + (this.getRegionX() << 8) + (this.plane << 16);
   }

   public int getTileHash() {
      return this.y + (this.x << 14) + (this.plane << 28);
   }

   public int getXInChunk() {
      return this.x & 7;
   }

   public int getYInChunk() {
      return this.y & 7;
   }
}
