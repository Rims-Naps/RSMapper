abstract class Node_Sub23 extends Node {
   static int anInt7194;
   static int anInt7195;
   static int anInt7196;
   protected GLToolkit aGLToolkit7197;
   static int anInt7198;
   static int anInt7199;
   static int[] anIntArray7200 = new int[1];
   static Node_Sub39 aNode_Sub39_7201;
   static int anInt7202;
   static long aLong7203;
   static int anInt7204;
   protected boolean aBoolean7205;

   static final void method2622(int i, GraphicsToolkit graphicstoolkit, int i_0_, int i_1_, int i_2_, byte b, int i_3_) {
      ++anInt7196;
      if (b != -77) {
         aNode_Sub39_7201 = null;
      }

      if ((Class290_Sub1.aGLSprite8062 == null || Class40.aGLSprite621 == null || Exception_Sub1.aGLSprite98 == null)
         && Node_Sub38_Sub39.index8.method3510(GLDrawableModel.anInt5710, (byte)63)
         && Node_Sub38_Sub39.index8.method3510(EntityNode_Sub3.anInt5965, (byte)63)
         && Node_Sub38_Sub39.index8.method3510(Class150.anInt5088, (byte)63)) {
         Class383 class383 = Class383.method4194(Node_Sub38_Sub39.index8, EntityNode_Sub3.anInt5965, 0);
         Class40.aGLSprite621 = graphicstoolkit.a(class383, true);
         class383.method4200();
         Class286.aGLSprite3604 = graphicstoolkit.a(class383, true);
         Class290_Sub1.aGLSprite8062 = graphicstoolkit.a(Class383.method4194(Node_Sub38_Sub39.index8, GLDrawableModel.anInt5710, 0), true);
         Class383 class383_4_ = Class383.method4194(Node_Sub38_Sub39.index8, Class150.anInt5088, 0);
         Exception_Sub1.aGLSprite98 = graphicstoolkit.a(class383_4_, true);
         class383_4_.method4200();
         Class296.aGLSprite5437 = graphicstoolkit.a(class383_4_, true);
      }

      if (Class290_Sub1.aGLSprite8062 != null && Class40.aGLSprite621 != null && Exception_Sub1.aGLSprite98 != null) {
         int i_5_ = (i_1_ - 2 * Exception_Sub1.aGLSprite98.method1193()) / Class290_Sub1.aGLSprite8062.method1193();

         for(int i_6_ = 0; ~i_6_ > ~i_5_; ++i_6_) {
            Class290_Sub1.aGLSprite8062
               .method1196(
                  Exception_Sub1.aGLSprite98.method1193() + i_0_ - -(Class290_Sub1.aGLSprite8062.method1193() * i_6_),
                  -Class290_Sub1.aGLSprite8062.method1176() + i_3_ + i
               );
         }

         int i_7_ = (i_3_ + -i_2_ + -Exception_Sub1.aGLSprite98.method1176()) / Class40.aGLSprite621.method1176();

         for(int i_8_ = 0; ~i_7_ < ~i_8_; ++i_8_) {
            Class40.aGLSprite621.method1196(i_0_, i_2_ + i + Class40.aGLSprite621.method1176() * i_8_);
            Class286.aGLSprite3604.method1196(-Class286.aGLSprite3604.method1193() + i_1_ + i_0_, i - -i_2_ + Class40.aGLSprite621.method1176() * i_8_);
         }

         Exception_Sub1.aGLSprite98.method1196(i_0_, -Exception_Sub1.aGLSprite98.method1176() + i + i_3_);
         Class296.aGLSprite5437.method1196(i_1_ + i_0_ + -Exception_Sub1.aGLSprite98.method1193(), i_3_ + i - Exception_Sub1.aGLSprite98.method1176());
      }
   }

   final int method2623(int i) {
      ++anInt7204;
      return i != 1 ? 4 : 1;
   }

   static final void setCameraVariables(
      int verticalRotation, int zoomRelated, int canvasSizeX, int junk, int playerPosX, int horizontalRotation, int playerPosY, int height
   ) {
      ++anInt7195;
      int i_16_ = -334 + canvasSizeX;
      if (~i_16_ > -1) {
         i_16_ = 0;
      } else if (i_16_ > 100) {
         i_16_ = 100;
      }

      int i_17_ = i_16_ * (Class268.aShort3455 - Class144_Sub1.aShort6804) / 100 + Class144_Sub1.aShort6804;
      Class308.anInt3912 = Class308.orthoZoom * i_17_ >> 8;
      zoomRelated = i_17_ * zoomRelated >> 8;
      int i_18_ = 16383 & -verticalRotation + 16384;
      if (junk < 63) {
         aLong7203 = -9L;
      }

      int i_19_ = 16384 - horizontalRotation & 16383;
      int i_20_ = 0;
      int i_21_ = 0;
      int zoomOffset = zoomRelated;
      if (i_18_ != 0) {
         i_21_ = Class335.anIntArray4167[i_18_] * -zoomRelated >> 14;
         zoomOffset = zoomRelated * Class335.anIntArray4165[i_18_] >> 14;
      }

      if (i_19_ != 0) {
         i_20_ = zoomOffset * Class335.anIntArray4167[i_19_] >> 14;
         zoomOffset = Class335.anIntArray4165[i_19_] * zoomOffset >> 14;
      }

      OutgoingPacket.anInt4050 = verticalRotation;
      Node_Sub10.cameraPosY = playerPosY - zoomOffset;
      Class98.cameraPosX = playerPosX - i_20_;
      Class190.cameraHeight = -i_21_ + height;
      Class48.anInt704 = 0;
      Class170.anInt2053 = horizontalRotation;
   }

   abstract void method2625(byte var1, int var2);

   abstract void method2626(byte var1);

   abstract boolean method2627(byte var1);

   public static void method2628(boolean bool) {
      aNode_Sub39_7201 = null;
      if (!bool) {
         anIntArray7200 = null;
      }

      anIntArray7200 = null;
   }

   abstract void method2629(Class169_Sub2 var1, Class169_Sub2 var2, int var3, int var4);

   int method2630(int i) {
      ++anInt7199;
      if (i != 1) {
         aNode_Sub39_7201 = null;
      }

      return 0;
   }

   final boolean method2631(byte b) {
      if (b > -66) {
         this.aBoolean7205 = false;
      }

      ++anInt7194;
      return false;
   }

   abstract void method2632(int var1, int var2, int var3);

   static final void method2633(int i) {
      Node_Sub38_Sub23.anInt10347 = -1;
      Class320_Sub23.aClass123_8432 = Class218.aClass123_2560;
      ++anInt7202;
      Class159.loginType = 1;
      if (i == 5966) {
         String string = null;
         if (Class143.aByteArray1773 != null) {
            Buffer buffer = new Buffer(Class143.aByteArray1773);
            string = Class154.method1699(buffer.readLong(), 25589);
            Class188_Sub1_Sub2.aLong9342 = buffer.readLong();
         }

         if (string == null) {
            Animable_Sub2.method836(35, true);
         } else {
            Class129.method1556(false, string, true, true, "");
         }
      }
   }

   final boolean method2634(int i) {
      ++anInt7198;
      if (i != 16383) {
         this.method2630(-115);
      }

      return this.aBoolean7205;
   }

   abstract boolean method2635(byte var1);

   static final void method2636(r var_r, int i, int i_27_, int i_28_, boolean[] bools) {
      if (Class320_Sub10.aPlaneArray8300 != Class368.aPlaneArray4548) {
         int i_29_ = Node_Sub38_Sub37.aPlaneArray10466[i].getMedianHeightFromVertices(i_28_, -128, i_27_);

         for(int i_30_ = 0; i_30_ <= i; ++i_30_) {
            if (bools == null || bools[i_30_]) {
               Plane plane = Node_Sub38_Sub37.aPlaneArray10466[i_30_];
               if (plane != null) {
                  plane.wa(var_r, i_27_, i_29_ - plane.getMedianHeightFromVertices(i_28_, -125, i_27_), i_28_, 0, false);
               }
            }
         }
      }
   }

   Node_Sub23(GLToolkit gltoolkit) {
      this.aGLToolkit7197 = gltoolkit;
   }
}
