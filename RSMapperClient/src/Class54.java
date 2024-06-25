import java.awt.Image;

public class Class54 {
   protected short[] aShortArray809;
   protected int[] anIntArray810;
   protected short[] aShortArray811;
   protected short[] aShortArray812;
   static Image anImage813;
   protected int[] anIntArray814;
   protected short aShort815;
   static int[] LocalNPCsIndexes = new int[1024];
   static boolean aBoolean817 = false;
   protected short aShort818;
   protected short aShort819;
   protected int[] anIntArray820 = new int[4];
   protected short aShort821;
   protected byte type;
   static Class56 aClass56_823 = new Class56();
   protected byte aByte824;
   protected int color;

   public static void method557(boolean bool) {
      anImage813 = null;
      LocalNPCsIndexes = null;
      aClass56_823 = null;
      if (!bool) {
         LocalNPCsIndexes = null;
      }
   }

   Class54() {
   }

   Class54(
      int type,
      int displaySetting,
      int bottomLeftPositionX,
      int bottomRightPositionX,
      int topRightPositionX,
      int topLeftPositionX,
      int bottomLeftHeight,
      int bottomRightHeight,
      int topRightHeight,
      int topLeftHeight,
      int bottomLeftPositionY,
      int bottomRightPositionY,
      int topRightPositionY,
      int topLeftPositionY
   ) {
      this.type = (byte)type;
      if (type >= 20 && Class213.aNode_Sub27_2512 != null) {
         this.aByte824 = (byte)(Class213.aNode_Sub27_2512.aClass320_Sub18_7303.method3749(false) == 2 ? 0 : 1);
      } else {
         this.aByte824 = (byte)displaySetting;
      }

      this.anIntArray814 = new int[4];
      this.anIntArray810 = new int[4];
      this.anIntArray810[3] = topLeftPositionX;
      this.anIntArray810[0] = bottomLeftPositionX;
      this.anIntArray810[2] = topRightPositionX;
      this.anIntArray810[1] = bottomRightPositionX;
      this.anIntArray814[3] = topLeftHeight;
      this.anIntArray814[0] = bottomLeftHeight;
      this.anIntArray814[2] = topRightHeight;
      this.anIntArray814[1] = bottomRightHeight;
      this.anIntArray820[0] = bottomLeftPositionY;
      this.anIntArray820[2] = topRightPositionY;
      this.anIntArray820[1] = bottomRightPositionY;
      this.aShort821 = (short)(bottomLeftPositionX >> Class36.INT_9);
      this.anIntArray820[3] = topLeftPositionY;
      this.aShort818 = (short)(topRightPositionX >> Class36.INT_9);
      this.aShort815 = (short)(bottomLeftPositionY >> Class36.INT_9);
      this.aShortArray809 = new short[4];
      this.aShort819 = (short)(topRightPositionY >> Class36.INT_9);
      this.aShortArray811 = new short[4];
      this.aShortArray812 = new short[4];
   }

   public static Class54 asTileBorder(int type, int sizeX, int sizeY, int localX, int localY, int plane) {
      if (localX < 104 && localX >= 0 && localY < 104 && localY >= 0 && plane >= 0 && plane < 4) {
         int topLeftHeight = RSMapperClient.editor.mapEditor.heights[plane][localX][localY + sizeX >= 104 ? 103 : localY + sizeY];
         int topRightHeight = RSMapperClient.editor.mapEditor.heights[plane][localX + sizeX >= 104 ? 103 : localX + sizeX][localY + sizeY >= 104
            ? 103
            : localY + sizeY];
         int bottomLeftHeight = RSMapperClient.editor.mapEditor.heights[plane][localX][localY];
         int bottomRightHeight = RSMapperClient.editor.mapEditor.heights[plane][localX + sizeX >= 104 ? 103 : localX + sizeX][localY];
         int leftPositionX = localX << 9;
         int rightPositionX = (localX << 9) + sizeX * 512;
         int topPositionY = (localY << 9) + sizeY * 512;
         int bottomPositionY = localY << 9;
         return new Class54(
            type,
            -1,
            leftPositionX,
            rightPositionX,
            rightPositionX,
            leftPositionX,
            bottomLeftHeight,
            bottomRightHeight,
            topRightHeight,
            topLeftHeight,
            bottomPositionY,
            bottomPositionY,
            topPositionY,
            topPositionY
         );
      } else {
         return null;
      }
   }

   public static Class54 asTileBorder(int type, int localX, int localY, int plane) {
      return asTileBorder(type, 1, 1, localX, localY, plane);
   }

   public static Class54 asVerticeHighlight(int type, int localX, int localY, int plane) {
      if (localX < 104 && localX >= 0 && localY < 104 && localY >= 0 && plane >= 0 && plane < 4) {
         int leftPositionX = (localX << 9) + 2;
         int topPositionY = (localY << 9) + 512;
         int bottomPositionY = (localY << 9) + 2;
         int ownedVerticeHeight = RSMapperClient.editor.mapEditor.heights[plane][localX][localY] - 2;
         int bottomRightHeight = RSMapperClient.editor.mapEditor.heights[plane][localX + 1][localY];
         int difference = Math.max(ownedVerticeHeight, bottomRightHeight) - Math.min(ownedVerticeHeight, bottomRightHeight);
         bottomRightHeight = ownedVerticeHeight - (ownedVerticeHeight > bottomRightHeight ? difference / 16 : -(difference / 16));
         int topLeftHeight = RSMapperClient.editor.mapEditor.heights[plane][localX][localY + 1];
         difference = Math.max(ownedVerticeHeight, topLeftHeight) - Math.min(ownedVerticeHeight, topLeftHeight);
         topLeftHeight = ownedVerticeHeight - (ownedVerticeHeight > topLeftHeight ? difference / 16 : -(difference / 16));
         return new Class54(
            type,
            -1,
            leftPositionX,
            leftPositionX + 32,
            leftPositionX,
            leftPositionX,
            ownedVerticeHeight,
            bottomRightHeight,
            topLeftHeight,
            topLeftHeight,
            bottomPositionY,
            bottomPositionY,
            topPositionY - 480,
            topPositionY - 480
         );
      } else {
         return null;
      }
   }
}
