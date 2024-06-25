public class WorldTile {
   private int x;
   private int y;
   private int plane;
   private int localX;
   private int localY;

   public WorldTile(int x, int y, int plane, boolean localCoords) {
      this.plane = plane < 0 ? 0 : (plane > 3 ? 3 : plane);
      if (localCoords) {
         this.localX = x;
         this.localY = y;
         this.x = Utils.getRegionCoordX(RSMapperClient.regionId) - 16 + x;
         this.y = Utils.getRegionCoordY(RSMapperClient.regionId) - 16 + y;
      } else {
         this.x = x;
         this.y = y;
         this.localX = Utils.getLocalXFromCoordX(x, RSMapperClient.regionId);
         this.localY = Utils.getLocalYFromCoordY(y, RSMapperClient.regionId);
      }
   }

   public int getX() {
      return this.x;
   }

   public int getY() {
      return this.y;
   }

   public int getPlane() {
      return this.plane;
   }

   public int getLocalX() {
      return this.localX;
   }

   public int getLocalY() {
      return this.localY;
   }

   public boolean isWithinRegionBounds() {
      int baseX = Utils.getRegionCoordX(RSMapperClient.regionId);
      int baseY = Utils.getRegionCoordY(RSMapperClient.regionId);
      int maxX = baseX + 63;
      int maxY = baseY + 63;
      return this.localX + baseX - 16 <= maxX && this.localY + baseY - 16 <= maxY && this.localX + baseX - 16 >= baseX && this.localY + baseY - 16 >= baseY;
   }

   @Override
   public String toString() {
      return "(" + this.x + ", " + this.y + ", " + this.plane + ")";
   }

   @Override
   public boolean equals(Object obj) {
      if (obj instanceof WorldTile) {
         WorldTile temp = (WorldTile)obj;
         return this.x == temp.x && this.y == temp.y && this.plane == temp.plane;
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return (this.plane << 28) + (this.localX << 14) + this.localY;
   }
}
