public class CachedObject {
   WorldTile tile;
   int typeRotationHash;

   public CachedObject(WorldTile tile, int typeRotationHash) {
      this.tile = tile;
      this.typeRotationHash = typeRotationHash;
   }

   public CachedObject(WorldTile tile, int type, int rotation) {
      this.tile = tile;
      this.typeRotationHash = this.findByteForTypeRotation(type, rotation);
   }

   public WorldTile getTile() {
      return this.tile;
   }

   public int getX() {
      return this.tile.getX();
   }

   public void setX(int x) {
      this.tile = new WorldTile(x, this.tile.getY(), this.tile.getPlane(), false);
   }

   public int getY() {
      return this.tile.getY();
   }

   public void setY(int y) {
      this.tile = new WorldTile(this.tile.getX(), y, this.tile.getPlane(), false);
   }

   public int getPlane() {
      return this.tile.getPlane();
   }

   public void setPlane(int plane) {
      this.tile = new WorldTile(this.tile.getX(), this.tile.getY(), plane, false);
   }

   public int getTypeRotationHash() {
      return this.typeRotationHash;
   }

   public void setTypeRotationHash(int typeRotationHash) {
      this.typeRotationHash = typeRotationHash;
   }

   public int getType() {
      return this.typeRotationHash >> 2;
   }

   public void setType(int type) {
      if (type >= 0 && type <= 22) {
         this.typeRotationHash = this.findByteForTypeRotation(type, this.typeRotationHash & 3);
      }
   }

   public int getRotation() {
      return this.typeRotationHash & 3;
   }

   public void setRotation(int rotation) {
      rotation &= 3;
      this.typeRotationHash = this.findByteForTypeRotation(this.typeRotationHash >> 2, rotation);
   }

   private int findByteForTypeRotation(int type, int rotation) {
      for(int i = 0; i < 128; ++i) {
         int t = i >> 2;
         int r = i & 3;
         if (type == t && rotation == r) {
            return i;
         }
      }

      return -1;
   }

   public int getPositionHash() {
      for(int i = 0; i < 50000; ++i) {
         int checkX = ((i & 4086) >> 6) + Utils.getRegionCoordX(RSMapperClient.regionId);
         int checkY = (i & 63) + Utils.getRegionCoordY(RSMapperClient.regionId);
         int checkPlane = i >> 12;
         if (checkX == this.tile.getX() && checkY == this.tile.getY() && checkPlane == this.tile.getPlane()) {
            return i;
         }
      }

      return -1;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj instanceof CachedEffect) {
         CachedObject temp = (CachedObject)obj;
         if (this.getX() == temp.getX()
            && this.getY() == temp.getY()
            && this.getPlane() == temp.getPlane()
            && this.getTypeRotationHash() == temp.getTypeRotationHash()
            && this.getType() == temp.getType()
            && this.getRotation() == temp.getRotation()) {
            return true;
         }
      }

      return false;
   }

   @Override
   public int hashCode() {
      return (this.getPositionHash() + "_" + this.getTypeRotationHash() + "_" + (this.getPlane() + 1)).hashCode();
   }
}
