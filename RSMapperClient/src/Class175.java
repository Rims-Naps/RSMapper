public class Class175 {
   static IncommingPacket aClass192_2096 = new IncommingPacket(71, 2);
   static int anInt2097 = 0;
   static char[] aCharArray2098 = new char[]{
      ' ',
           '\u00A0',
      '_',
      '-',
           '\u00E0',
           '\u00E1',
           '\u00E2',
           '\u00E4',
           '\u00E3',
           '\u00C0',
           '\u00C1',
           '\u00C2',
           '\u00C4',
           '\u00C3',
           '\u00E8',
           '\u00E9',
           '\u00EA',
           '\u00EB',
           '\u00C8',
           '\u00C9',
           '\u00CA',
           '\u00CB',
           '\u00ED',
           '\u00EE',
           '\u00EF',
           '\u00CD',
           '\u00CE',
           '\u00CF',
           '\u00F2',
           '\u00F3',
           '\u00F4',
           '\u00F6',
           '\u00F5',
           '\u00D2',
           '\u00D3',
           '\u00D4',
           '\u00D6',
           '\u00D5',
           '\u00F9',
           '\u00FA',
           '\u00FB',
           '\u00FC',
           '\u00D9',
           '\u00DA',
           '\u00DB',
           '\u00DC',
           '\u00E7',
           '\u00C7',
           '\u00FF',
           '\u0178',
           '\u00F1',
           '\u00D1',
           '\u00DF'
   };
   static Class261[][][] aClass261ArrayArrayArray2099;
   static Class291 aClass291_2100;

   static final void method1803() {
      int i = 10;
      int i_0_ = 10;
      if (Class364.anInt4514 != 0 && Class132.aClass52_1673 != null) {
         CacheNode_Sub18.aGraphicsToolkit9607.K(Class129.anIntArray1669);

         for(int i_1_ = 0; i_1_ < Node_Sub38_Sub25.anIntArray10358.length; ++i_1_) {
            CacheNode_Sub18.aGraphicsToolkit9607
               .method1243(
                  Class129.anIntArray1669[3] - Class129.anIntArray1669[1],
                  Class129.anIntArray1669[1],
                  -256,
                  Node_Sub38_Sub25.anIntArray10358[i_1_] + Class270_Sub2.anIntArray8039[i_1_],
                  2
               );
         }

         for(int i_2_ = 0; i_2_ < Class320_Sub21.anInt8406; ++i_2_) {
            Class54 class54 = Node_Sub44.aClass54Array7548[i_2_];
            CacheNode_Sub18.aGraphicsToolkit9607.H(class54.anIntArray810[0], class54.anIntArray814[0], class54.anIntArray820[0], Class332.anIntArray4146);
            CacheNode_Sub18.aGraphicsToolkit9607.H(class54.anIntArray810[1], class54.anIntArray814[1], class54.anIntArray820[1], MainFile.anIntArray146);
            CacheNode_Sub18.aGraphicsToolkit9607
               .H(class54.anIntArray810[2], class54.anIntArray814[2], class54.anIntArray820[2], InputStream_Sub2.anIntArray81);
            CacheNode_Sub18.aGraphicsToolkit9607.H(class54.anIntArray810[3], class54.anIntArray814[3], class54.anIntArray820[3], Class160.anIntArray2000);
            if (Class332.anIntArray4146[2] != -1
               && MainFile.anIntArray146[2] != -1
               && InputStream_Sub2.anIntArray81[2] != -1
               && Class160.anIntArray2000[2] != -1) {
               int color = -65536;
               if (class54.type == 4) {
                  color = -16776961;
               }

               CacheNode_Sub18.aGraphicsToolkit9607
                  .method1236(MainFile.anIntArray146[1], Class332.anIntArray4146[1], MainFile.anIntArray146[0], color, 1, Class332.anIntArray4146[0]);
               CacheNode_Sub18.aGraphicsToolkit9607
                  .method1236(
                     InputStream_Sub2.anIntArray81[1], MainFile.anIntArray146[1], InputStream_Sub2.anIntArray81[0], color, 1, MainFile.anIntArray146[0]
                  );
               CacheNode_Sub18.aGraphicsToolkit9607
                  .method1236(
                     Class160.anIntArray2000[1], InputStream_Sub2.anIntArray81[1], Class160.anIntArray2000[0], color, 1, InputStream_Sub2.anIntArray81[0]
                  );
               CacheNode_Sub18.aGraphicsToolkit9607
                  .method1236(Class332.anIntArray4146[1], Class160.anIntArray2000[1], Class332.anIntArray4146[0], color, 1, Class160.anIntArray2000[0]);
               CacheNode_Sub18.aGraphicsToolkit9607
                  .method1236(
                     InputStream_Sub2.anIntArray81[1], Class332.anIntArray4146[1], InputStream_Sub2.anIntArray81[0], color, 1, Class332.anIntArray4146[0]
                  );
            }
         }

         Class132.aClass52_1673.method538(i, i_0_ + 45, "Dynamic: " + Class63.anInt923 + "/" + 5000, -16777216, 1, -256);
         Class132.aClass52_1673.method538(i, i_0_ + 60, "Total Opaque Onscreen: " + Node_Sub42.anInt7527 + "/" + 10000, -16777216, 1, -256);
         Class132.aClass52_1673.method538(i, i_0_ + 75, "Total Trans Onscreen: " + Class348.anInt4290 + "/" + 5000, -16777216, 1, -256);
         Class132.aClass52_1673
            .method538(
               i, i_0_ + 90, "Occluders: " + (Class167.anInt2033 + NpcDefinition.anInt2885) + " Active: " + Class320_Sub21.anInt8406, -16777216, 1, -256
            );
         Class132.aClass52_1673
            .method538(
               i,
               i_0_ + 105,
               "Occluded: Ground:"
                  + ProducingGraphicsBuffer.anInt9880
                  + " Walls: "
                  + Node_Sub52.anInt7651
                  + " CPs: "
                  + Class187.anInt2267
                  + " Pixels: "
                  + Class233.anInt2786,
               -16777216,
               1,
               -256
            );
         Class132.aClass52_1673.method538(i, i_0_ + 120, "Occlude Calc Took: " + Node_Sub38_Sub31.aLong10420 / 1000L + "us", -16777216, 1, -256);
         if (Class364.anInt4514 == 2 && Node_Sub38.anIntArray7451 != null) {
            for(int i_4_ = 0; i_4_ < Node_Sub38.anIntArray7451.length; ++i_4_) {
               float f = (float)Node_Sub38.anIntArray7451[i_4_];
               f /= 4194304.0F;
               if (f > 1.0F) {
                  f = 1.0F;
               }

               f *= 255.0F;
               f = 255.0F - f;
               int i_5_ = (int)f;
               Node_Sub38.anIntArray7451[i_4_] = i_5_ | i_5_ << 8 | i_5_ << 16 | 0xFF000000;
            }

            GLSprite glsprite = CacheNode_Sub18.aGraphicsToolkit9607
               .method1235(Class144_Sub1.anInt6806, Class144_Sub1.anInt6806, Class331.anInt4130, Node_Sub38.anIntArray7451, 0, 7468);
            glsprite.method1191(i, 170, 1, 0, 0);
         }
      }

      for(int i_2_ = 0; i_2_ < Class320_Sub21.anInt8406; ++i_2_) {
         Class54 class54 = Node_Sub44.aClass54Array7548[i_2_];
         if (class54.type >= 20) {
            CacheNode_Sub18.aGraphicsToolkit9607.H(class54.anIntArray810[0], class54.anIntArray814[0], class54.anIntArray820[0], Class332.anIntArray4146);
            CacheNode_Sub18.aGraphicsToolkit9607.H(class54.anIntArray810[1], class54.anIntArray814[1], class54.anIntArray820[1], MainFile.anIntArray146);
            CacheNode_Sub18.aGraphicsToolkit9607
               .H(class54.anIntArray810[2], class54.anIntArray814[2], class54.anIntArray820[2], InputStream_Sub2.anIntArray81);
            CacheNode_Sub18.aGraphicsToolkit9607.H(class54.anIntArray810[3], class54.anIntArray814[3], class54.anIntArray820[3], Class160.anIntArray2000);
            if (Class332.anIntArray4146[2] != -1
               && MainFile.anIntArray146[2] != -1
               && InputStream_Sub2.anIntArray81[2] != -1
               && Class160.anIntArray2000[2] != -1) {
               int color = -30420000;
               if (class54.type == 21) {
                  color = -11990009;
               } else if (class54.type == 22) {
                  color = -65536;
               } else if (class54.type == 23) {
                  color = -250;
               }

               CacheNode_Sub18.aGraphicsToolkit9607
                  .method1236(MainFile.anIntArray146[1], Class332.anIntArray4146[1], MainFile.anIntArray146[0], color, 1, Class332.anIntArray4146[0]);
               CacheNode_Sub18.aGraphicsToolkit9607
                  .method1236(
                     InputStream_Sub2.anIntArray81[1], MainFile.anIntArray146[1], InputStream_Sub2.anIntArray81[0], color, 1, MainFile.anIntArray146[0]
                  );
               CacheNode_Sub18.aGraphicsToolkit9607
                  .method1236(
                     Class160.anIntArray2000[1], InputStream_Sub2.anIntArray81[1], Class160.anIntArray2000[0], color, 1, InputStream_Sub2.anIntArray81[0]
                  );
               CacheNode_Sub18.aGraphicsToolkit9607
                  .method1236(Class332.anIntArray4146[1], Class160.anIntArray2000[1], Class332.anIntArray4146[0], color, 1, Class160.anIntArray2000[0]);
               if (class54.type == 24) {
                  CacheNode_Sub18.aGraphicsToolkit9607
                     .method1236(
                        InputStream_Sub2.anIntArray81[1], Class332.anIntArray4146[1], InputStream_Sub2.anIntArray81[0], color, 1, Class332.anIntArray4146[0]
                     );
               }
            }
         }
      }
   }

   public static void method1804(boolean bool) {
      aCharArray2098 = null;
      aClass261ArrayArrayArray2099 = null;
      if (!bool) {
         method1804(false);
      }

      aClass192_2096 = null;
      aClass291_2100 = null;
   }
}
