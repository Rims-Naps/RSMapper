package jagex3.graphics2.hw;

public class NativeInterface {
   protected long peer;

   public final native void copyNormals(short[] var1, short[] var2, short[] var3, byte[] var4, float var5, float var6, int var7, int var8, int var9, long var10);

   public final native void release();

   public final native void copyLighting(
      short[] var1,
      byte[] var2,
      short[] var3,
      short[] var4,
      short[] var5,
      short[] var6,
      byte[] var7,
      int var8,
      int var9,
      short[] var10,
      int var11,
      int var12,
      int var13,
      long var14
   );

   private final native void init(int var1, int var2);

   public NativeInterface(int i, int i_16_) {
      this.init(i, i_16_);
   }

   public final native void initTextureMetrics(int var1, byte var2, byte var3);

   public final native void setSunColour(float var1, float var2, float var3, float var4, float var5);

   public final native void setSunDirection(float var1, float var2, float var3);

   public final native void copyPositions(int[] var1, int[] var2, int[] var3, short[] var4, int var5, int var6, int var7, long var8);

   public final native void copyTexCoords(float[] var1, float[] var2, int var3, int var4, int var5, long var6);

   public final native void setAmbient(float var1);

   public final native void copyColours(short[] var1, byte[] var2, short[] var3, int var4, short[] var5, int var6, int var7, int var8, long var9);
}
