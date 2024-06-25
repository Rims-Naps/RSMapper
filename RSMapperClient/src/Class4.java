public class Class4 {
   static int anInt121 = 0;
   static Index index2;
   static long aLong123 = 0L;
   static int anInt124 = 0;
   static int anInt125;

   public static void method170(int i) {
      if (i != 2) {
         positionMinimapAreaSprites((byte)90, 123, null, null, -116, 86, null, 116);
      }

      index2 = null;
   }

   static final void positionMinimapAreaSprites(byte b, int i, aa var_aa, GLSprite glsprite, int localY, int localX, IComponentDefinitions widget, int i_2_) {
      ++anInt125;
      if (glsprite != null) {
         int rotation;
         if (Class320_Sub22.anInt8415 == 4) {
            rotation = (int)Node_Sub12.cameraRotationHorizontal & 16383;
         } else {
            rotation = (int)Node_Sub12.cameraRotationHorizontal - -Mobile_Sub1.anInt10960 & 16383;
         }

         int i_4_ = Math.max(widget.width / 2, widget.height / 2) + 10;
         int i_5_ = localY * localY + localX * localX;
         if (~(i_4_ * i_4_) <= ~i_5_) {
            int posOffset1 = Class335.anIntArray4167[rotation];
            int posOffset2 = Class335.anIntArray4165[rotation];
            if (Class320_Sub22.anInt8415 != 4) {
               posOffset1 = 256 * posOffset1 / (256 + Node_Sub15_Sub13.anInt9870);
               posOffset2 = 256 * posOffset2 / (Node_Sub15_Sub13.anInt9870 + 256);
            }

            if (b == -116) {
               int i_8_ = posOffset2 * localX + posOffset1 * localY >> 14;
               int i_9_ = -(localX * posOffset1) + localY * posOffset2 >> 14;
               glsprite.method1189(
                  i_8_ + widget.width / 2 + i_2_ + -(glsprite.method1197() / 2), widget.height / 2 + i - i_9_ + -(glsprite.method1186() / 2), var_aa, i_2_, i
               );
            }
         }
      }
   }
}
