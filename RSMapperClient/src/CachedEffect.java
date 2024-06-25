public class CachedEffect {
   int localX;
   int localY;
   int offsetX;
   int offsetY;
   int referenceX;
   int referenceY;
   int plane;
   int planeflag;
   int height;
   int spread;
   int colorIndex;
   int flickerType2;
   int flickerType;
   int[] coverage;

   public CachedEffect(int referenceX, int referenceY, int plane, int planeflag, int height, int spread, int[] coverage, int colorIndex, int flicker) {
      this.referenceX = referenceX;
      this.referenceY = referenceY;
      int regionLocalX = 64 * (RSMapperClient.regionId >> 8) - Node_Sub53.gameSceneBaseX;
      int regionLocalY = 64 * (RSMapperClient.regionId & 0xFF) - Class320_Sub4.gameSceneBaseY;
      int i_35_ = (regionLocalX << 9) + referenceX;
      int i_36_ = (regionLocalY << 9) + referenceY;
      this.localX = i_35_ >> 9;
      this.localY = i_36_ >> 9;
      this.offsetX = (this.localX << 9) + referenceX - (this.localX + (referenceX >> 9) << 9);
      this.offsetY = (this.localY << 9) + referenceY - (this.localY + (referenceY >> 9) << 9);
      this.plane = plane;
      this.planeflag = (planeflag & 7) < 0 ? 0 : ((planeflag & 7) > 3 ? 3 : planeflag);
      this.height = height;
      this.spread = spread;
      this.coverage = coverage;
      this.colorIndex = colorIndex;
      this.flickerType2 = flicker;
   }

   public void setFlickerType(int value) {
      this.flickerType = value;
   }

   @Override
   public boolean equals(Object obj) {
      if (obj instanceof CachedEffect) {
         CachedEffect fx = (CachedEffect)obj;
         return this.localX == fx.localX && this.localY == fx.localY && this.plane == fx.plane;
      } else {
         return false;
      }
   }

   @Override
   public int hashCode() {
      return "cfx".hashCode() + (this.plane << 28) + (this.localX << 14) + this.localY;
   }
}
