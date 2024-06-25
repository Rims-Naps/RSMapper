public class Class329 {
   static float aFloat4117;
   static int anInt4118;
   static int anInt4119;
   static int anInt4120;
   static int anInt4121;
   static Class256 aClass256_4122;
   protected int anInt4123;
   static int anInt4124;

   static final boolean method3833(byte b, int i) {
      ++anInt4124;
      if (b != -61) {
         method3835(null, true);
      }

      return i == 7 || i == 8 || i == 9 || i == 10;
   }

   static final void markMiniMap(
      int localY, int i_0_, int i_1_, aa var_aa, GraphicsToolkit graphicstoolkit, int areaId, int i_3_, int localX, IComponentDefinitions widget
   ) {
      ++anInt4120;
      AreaDefinitions class79 = Class304.aClass215_3834.getAreaDefinitions((byte)101, areaId);
      if (class79 != null && class79.aBoolean1079 && class79.method784((byte)109, Class24.aClass275_442)) {
         if (class79.anIntArray1049 != null) {
            int[] is = new int[class79.anIntArray1049.length];

            for(int i_5_ = 0; i_5_ < is.length / 2; ++i_5_) {
               int i_6_;
               if (Class320_Sub22.anInt8415 != 4) {
                  i_6_ = 16383 & (int)Node_Sub12.cameraRotationHorizontal - -Mobile_Sub1.anInt10960;
               } else {
                  i_6_ = 16383 & (int)Node_Sub12.cameraRotationHorizontal;
               }

               int i_7_ = Class335.anIntArray4167[i_6_];
               int i_8_ = Class335.anIntArray4165[i_6_];
               if (~Class320_Sub22.anInt8415 != -5) {
                  i_7_ = 256 * i_7_ / (256 + Node_Sub15_Sub13.anInt9870);
                  i_8_ = 256 * i_8_ / (256 + Node_Sub15_Sub13.anInt9870);
               }

               is[i_5_ * 2] = widget.width / 2
                  + i_1_
                  - -(i_8_ * (4 * class79.anIntArray1049[i_5_ * 2] + localX) + i_7_ * (localY + class79.anIntArray1049[2 * i_5_ + 1] * 4) >> 14);
               is[2 * i_5_ + 1] = -(
                     i_8_ * (localY - -(class79.anIntArray1049[2 * i_5_ - -1] * 4)) - i_7_ * (localX - -(4 * class79.anIntArray1049[2 * i_5_])) >> 14
                  )
                  + i_3_
                  + widget.height / 2;
            }

            Class127 class127 = widget.method4145(graphicstoolkit, 1);
            if (class127 != null) {
               Class74.method761(graphicstoolkit, is, class79.anInt1084, class127.anIntArray1641, class127.anIntArray1635);
            }

            if (class79.anInt1074 > 0) {
               for(int i_9_ = 0; i_9_ < is.length / 2 + -1; ++i_9_) {
                  int i_10_ = is[2 * i_9_];
                  int i_11_ = is[1 + 2 * i_9_];
                  int i_12_ = is[2 + 2 * i_9_];
                  int i_13_ = is[2 + i_9_ * 2 + 1];
                  if (~i_10_ < ~i_12_) {
                     int i_14_ = i_10_;
                     int i_15_ = i_11_;
                     i_10_ = i_12_;
                     i_12_ = i_14_;
                     i_11_ = i_13_;
                     i_13_ = i_15_;
                  } else if (~i_10_ == ~i_12_ && i_13_ < i_11_) {
                     int i_16_ = i_11_;
                     i_11_ = i_13_;
                     i_13_ = i_16_;
                  }

                  graphicstoolkit.a(
                     i_10_,
                     i_11_,
                     i_12_,
                     i_13_,
                     class79.anIntArray1066[class79.aByteArray1057[i_9_] & 255],
                     1,
                     var_aa,
                     i_1_,
                     i_3_,
                     class79.anInt1074,
                     class79.anInt1050,
                     class79.anInt1080
                  );
               }

               int i_17_ = is[is.length - 2];
               int i_18_ = is[is.length + -1];
               int i_19_ = is[0];
               int i_20_ = is[1];
               if (i_19_ < i_17_) {
                  int i_21_ = i_17_;
                  int i_22_ = i_18_;
                  i_17_ = i_19_;
                  i_19_ = i_21_;
                  i_18_ = i_20_;
                  i_20_ = i_22_;
               } else if (~i_17_ == ~i_19_ && ~i_18_ < ~i_20_) {
                  int i_23_ = i_18_;
                  i_18_ = i_20_;
                  i_20_ = i_23_;
               }

               graphicstoolkit.a(
                  i_17_,
                  i_18_,
                  i_19_,
                  i_20_,
                  class79.anIntArray1066[class79.aByteArray1057[-1 + class79.aByteArray1057.length] & 255],
                  1,
                  var_aa,
                  i_1_,
                  i_3_,
                  class79.anInt1074,
                  class79.anInt1050,
                  class79.anInt1080
               );
            } else {
               for(int i_24_ = 0; ~i_24_ > ~(is.length / 2 - 1); ++i_24_) {
                  graphicstoolkit.a(
                     is[2 * i_24_],
                     is[2 * i_24_ + 1],
                     is[i_24_ * 2 + 2],
                     is[1 + (1 + i_24_) * 2],
                     class79.anIntArray1066[255 & class79.aByteArray1057[i_24_]],
                     1,
                     var_aa,
                     i_1_,
                     i_3_
                  );
               }

               graphicstoolkit.a(
                  is[-2 + is.length],
                  is[is.length - 1],
                  is[0],
                  is[1],
                  class79.anIntArray1066[255 & class79.aByteArray1057[-1 + class79.aByteArray1057.length]],
                  1,
                  var_aa,
                  i_1_,
                  i_3_
               );
            }
         }

         GLSprite glsprite = null;
         if (~class79.spriteId != 0) {
            glsprite = class79.method790(false, (byte)-91, graphicstoolkit);
            if (glsprite != null) {
               Class4.positionMinimapAreaSprites((byte)-116, i_3_, var_aa, glsprite, localY, localX, widget, i_1_);
            }
         }

         if (class79.nameLabel != null) {
            int i_25_ = 0;
            if (glsprite != null) {
               i_25_ = glsprite.method1176();
            }

            Class52 class52 = CacheNode_Sub18.aClass52_9609;
            Class357 class357 = Class85.aClass357_1159;
            if (~class79.anInt1090 == -2) {
               class52 = StandardSprite.aClass52_8945;
               class357 = Class169_Sub3.aClass357_8820;
            }

            if (class79.anInt1090 == 2) {
               class357 = Class262_Sub15_Sub1.aClass357_10524;
               class52 = Class262_Sub4.aClass52_7721;
            }

            Node_Sub20.method2615(class52, class79.nameLabel, class357, i_1_, class79.textColor, i_25_, false, widget, var_aa, localY, i_3_, localX);
         }
      }

      if (i_0_ >= -116) {
         aFloat4117 = -1.2767835F;
      }
   }

   static final String method3835(byte[] bs, boolean bool) {
      if (!bool) {
         return null;
      } else {
         ++anInt4121;
         return Class184.method1846(0, bs, bs.length, (byte)-127);
      }
   }

   @Override
   public final String toString() {
      ++anInt4119;
      throw new IllegalStateException();
   }

   static final void method3836(int i, int i_26_, int i_27_, int i_28_, int i_29_, int i_30_, int i_31_) {
      Node_Sub15_Sub5.anInt9806 = i;
      Class231.anInt2764 = i_29_;
      if (i_26_ == 327263118) {
         Class320_Sub23.anInt8434 = i_30_;
         Class339_Sub6.anInt8694 = i_31_;
         Class375.anInt4657 = i_28_;
         Class194_Sub3.anInt6907 = i_27_;
         ++anInt4118;
      }
   }

   public static void method3837(byte b) {
      if (b <= 115) {
         aFloat4117 = 0.03802057F;
      }

      aClass256_4122 = null;
   }

   Class329(String string, String string_32_, String string_33_, int i) {
      this.anInt4123 = i;
   }
}
