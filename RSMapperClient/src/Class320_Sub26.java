public class Class320_Sub26 extends Class320 {
   static IncommingPacket aClass192_8450 = new IncommingPacket(127, 6);
   static int anInt8451;
   static int anInt8452;
   static int anInt8453;
   static int anInt8454;
   static int anInt8455;
   static int anInt8456 = 13156520;
   static int anInt8457;
   static int anInt8458;
   static OutgoingPacket aClass318_8459 = new OutgoingPacket(88, -1);

   static final void method3777() {
      if (Class256.aClass261ArrayArrayArray3240 != null) {
         for(int i = 0; i < Class256.aClass261ArrayArrayArray3240.length; ++i) {
            for(int i_0_ = 0; i_0_ < Class328.SCENE_WIDTH_X; ++i_0_) {
               for(int i_1_ = 0; i_1_ < Node_Sub50.SCENE_WIDTH_Y; ++i_1_) {
                  if (Class256.aClass261ArrayArrayArray3240[i][i_0_][i_1_] != null) {
                     Class256.aClass261ArrayArrayArray3240[i][i_0_][i_1_].method3141(-124);
                  }

                  Class256.aClass261ArrayArrayArray3240[i][i_0_][i_1_] = null;
               }
            }
         }
      }

      Class256.aClass261ArrayArrayArray3240 = null;
      Node_Sub38_Sub37.aPlaneArray10466 = null;
      if (Class225.aClass261ArrayArrayArray2680 != null) {
         for(int i = 0; i < Class225.aClass261ArrayArrayArray2680.length; ++i) {
            for(int i_2_ = 0; i_2_ < Class328.SCENE_WIDTH_X; ++i_2_) {
               for(int i_3_ = 0; i_3_ < Node_Sub50.SCENE_WIDTH_Y; ++i_3_) {
                  if (Class225.aClass261ArrayArrayArray2680[i][i_2_][i_3_] != null) {
                     Class225.aClass261ArrayArrayArray2680[i][i_2_][i_3_].method3141(-109);
                  }

                  Class225.aClass261ArrayArrayArray2680[i][i_2_][i_3_] = null;
               }
            }
         }
      }

      Class225.aClass261ArrayArrayArray2680 = null;
      Class368.aPlaneArray4548 = null;
      Class175.aClass261ArrayArrayArray2099 = null;
      Class320_Sub10.aPlaneArray8300 = null;
      Class139.aBooleanArrayArray1730 = null;
      Class75.aBooleanArrayArray1002 = null;
      Node_Sub38_Sub7.anIntArray10150 = null;
      Class234.aBooleanArrayArrayArray2790 = null;
      Class150_Sub2.aBooleanArrayArrayArray8960 = null;
      Class262_Sub13.method3183(9844);
      if (Node_Sub52.aMobileArray7648 != null) {
         for(int i = 0; i < Class63.anInt923; ++i) {
            Node_Sub52.aMobileArray7648[i] = null;
         }

         Class63.anInt923 = 0;
      }

      Class303.anAnimableArray3827 = null;
      SeekableFile.anAnimableArray3884 = null;
      Node_Sub36.anAnimableArray7429 = null;
      if (Class32.staticObjectsInScene != null) {
         for(int i = 0; i < Class32.staticObjectsInScene.length; ++i) {
            Class32.staticObjectsInScene[i] = null;
         }

         Node_Sub42.anInt7527 = 0;
      }

      if (Class262_Sub15.animatedObjectsInScene != null) {
         for(int i = 0; i < Class262_Sub15.animatedObjectsInScene.length; ++i) {
            Class262_Sub15.animatedObjectsInScene[i] = null;
         }

         Class348.anInt4290 = 0;
      }

      if (Class143.aLightFXArray1771 != null) {
         for(int i = 0; i < Class188_Sub1_Sub1.fxCount; ++i) {
            Class143.aLightFXArray1771[i] = null;
         }

         for(int i = 0; i < Class159.anInt1995; ++i) {
            for(int i_4_ = 0; i_4_ < Class328.SCENE_WIDTH_X; ++i_4_) {
               for(int i_5_ = 0; i_5_ < Node_Sub50.SCENE_WIDTH_Y; ++i_5_) {
                  TextureDefinitions.aLongArrayArrayArray1228[i][i_4_][i_5_] = 0L;
               }
            }
         }

         Class188_Sub1_Sub1.fxCount = 0;
      }

      Class262_Sub22.method3206(0);
      Node_Sub36_Sub3.aClass179_10058 = Node_Sub36_Sub3.aClass179_10062;
      Node_Sub36_Sub3.aClass179_10058.method1815((byte)74);
      Class320_Sub18.aByteArrayArray8379 = null;
      Player.anIntArrayArray11128 = null;
      Class146.aShortArrayArray1802 = null;
      if (GraphicsToolkit.aClass33Array1549 != null) {
         Class262_Sub8.method3169();
         CacheNode_Sub18.aGraphicsToolkit9607.j(1);
         CacheNode_Sub18.aGraphicsToolkit9607.k(0);
      }

      if (Class364.aClass273Array4513 != null) {
         Class364.aClass273Array4513 = null;
      }

      CacheNode_Sub18.aGraphicsToolkit9607 = null;
   }

   Class320_Sub26(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }

   @Override
   final int method3675(int i, byte b) {
      ++anInt8455;
      if (this.aNode_Sub27_4063.method2697(-101)) {
         return 3;
      } else if (i == 0 || ~this.aNode_Sub27_4063.aClass320_Sub23_7290.method3770(false) == -2) {
         return 1;
      } else {
         return b != 54 ? -45 : 2;
      }
   }

   public static void method3778(int i) {
      aClass192_8450 = null;
      if (i > 43) {
         aClass318_8459 = null;
      }
   }

   final int method3779(boolean bool) {
      if (bool) {
         this.method3677(62);
      }

      ++anInt8458;
      return this.anInt4064;
   }

   final boolean method3780(byte b) {
      ++anInt8454;
      if (b < 63) {
         return false;
      } else {
         return !this.aNode_Sub27_4063.method2697(-100);
      }
   }

   @Override
   final int method3677(int i) {
      if (i != 0) {
         method3777();
      }

      ++anInt8457;
      return 1;
   }

   Class320_Sub26(Node_Sub27 node_sub27) {
      super(node_sub27);
   }

   @Override
   final void method3673(byte b) {
      if (this.aNode_Sub27_4063.method2697(-117)) {
         this.anInt4064 = 0;
      }

      ++anInt8452;
      if (this.anInt4064 < 0 && this.anInt4064 > 2) {
         this.anInt4064 = this.method3677(0);
      }

      if (b >= -35) {
         anInt8451 = 67;
      }
   }

   @Override
   final void method3676(boolean bool, int i) {
      ++anInt8453;
      this.anInt4064 = i;
      if (bool) {
         this.method3677(28);
      }
   }
}
