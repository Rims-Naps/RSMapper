class AnimableAnimator extends Animator {
   static int anInt5495;
   static int anInt5496;
   private Animable anAnimable5497;
   static Class42 aClass42_5498;
   static int anInt5499;
   static Class124 aClass124_5500 = new Class124(60);
   static int anInt5501;

   public static void method252(int i) {
      aClass124_5500 = null;
      aClass42_5498 = null;
      if (i != 7) {
         aClass124_5500 = null;
      }
   }

   static final void worldmapExecutor(d var_d, GraphicsToolkit graphicstoolkit, boolean bool) {
      ++anInt5496;
      if (WorldmapDefinitions.currentWorldmapArea != null) {
         if (Node_Sub25_Sub1.worldmapLoaded < 10) {
            if (!WorldmapDefinitions.aClass302_314.method3527(WorldmapDefinitions.currentWorldmapArea.archivename, 0)) {
               Node_Sub25_Sub1.worldmapLoaded = r_Sub1.index23.method3522((byte)127, WorldmapDefinitions.currentWorldmapArea.archivename) / 10;
               return;
            }

            Class371.method4096((byte)-118);
            Node_Sub25_Sub1.worldmapLoaded = 10;
         }

         if (Node_Sub25_Sub1.worldmapLoaded == 10) {
            WorldmapDefinitions.regionXWorldCoordinate = WorldmapDefinitions.currentWorldmapArea.anInt9541 >> 6 << 6;
            WorldmapDefinitions.regionYWorldCoordinate = WorldmapDefinitions.currentWorldmapArea.anInt9540 >> 6 << 6;
            WorldmapDefinitions.totalXTiles = (WorldmapDefinitions.currentWorldmapArea.anInt9531 >> 6 << 6)
               - (WorldmapDefinitions.regionXWorldCoordinate - 64);
            WorldmapDefinitions.totalYTiles = 64 + -WorldmapDefinitions.regionYWorldCoordinate + (WorldmapDefinitions.currentWorldmapArea.anInt9545 >> 6 << 6);
            int[] is = new int[3];
            int i = -1;
            int i_0_ = -1;
            if (WorldmapDefinitions.currentWorldmapArea
               .method2337(
                  -12584,
                  is,
                  Class320_Sub4.gameSceneBaseY - -(Class295.myPlayer.y >> 9),
                  Class295.myPlayer.plane,
                  (Class295.myPlayer.x >> 9) + Node_Sub53.gameSceneBaseX
               )) {
               i = -WorldmapDefinitions.regionXWorldCoordinate + is[1];
               i_0_ = is[2] + -WorldmapDefinitions.regionYWorldCoordinate;
            }

            if (!Class369.aBoolean4555 && i >= 0 && WorldmapDefinitions.totalXTiles > i && i_0_ >= 0 && i_0_ < WorldmapDefinitions.totalYTiles) {
               i_0_ += (int)(10.0 * Math.random()) - 5;
               i += -5 + (int)(10.0 * Math.random());
               Class94.anInt1250 = i;
               Class327.anInt5360 = i_0_;
            } else if (~Class262_Sub8.anInt7756 != 0 && ~IOException_Sub1.anInt84 != 0) {
               WorldmapDefinitions.currentWorldmapArea.method2334(2048, Class262_Sub8.anInt7756, IOException_Sub1.anInt84, is);
               if (is != null) {
                  Class327.anInt5360 = is[2] - WorldmapDefinitions.regionYWorldCoordinate;
                  Class94.anInt1250 = -WorldmapDefinitions.regionXWorldCoordinate + is[1];
               }

               Class369.aBoolean4555 = false;
               IOException_Sub1.anInt84 = -1;
               Class262_Sub8.anInt7756 = -1;
            } else {
               WorldmapDefinitions.currentWorldmapArea
                  .method2334(
                     2048,
                     (268420999 & WorldmapDefinitions.currentWorldmapArea.centerLocationHash) >> 14,
                     WorldmapDefinitions.currentWorldmapArea.centerLocationHash & 16383,
                     is
                  );
               Class327.anInt5360 = is[2] - WorldmapDefinitions.regionYWorldCoordinate;
               Class94.anInt1250 = -WorldmapDefinitions.regionXWorldCoordinate + is[1];
            }

            if (~WorldmapDefinitions.currentWorldmapArea.zoomOnLoad != -38) {
               if (WorldmapDefinitions.currentWorldmapArea.zoomOnLoad != 50) {
                  if (WorldmapDefinitions.currentWorldmapArea.zoomOnLoad != 75) {
                     if (WorldmapDefinitions.currentWorldmapArea.zoomOnLoad != 100) {
                        if (~WorldmapDefinitions.currentWorldmapArea.zoomOnLoad == -201) {
                           WorldmapDefinitions.adjustingZoomFactor = 16.0F;
                           WorldmapDefinitions.zoomFactorPrecise = 16.0F;
                        } else {
                           WorldmapDefinitions.adjustingZoomFactor = 8.0F;
                           WorldmapDefinitions.zoomFactorPrecise = 8.0F;
                        }
                     } else {
                        WorldmapDefinitions.adjustingZoomFactor = 8.0F;
                        WorldmapDefinitions.zoomFactorPrecise = 8.0F;
                     }
                  } else {
                     WorldmapDefinitions.adjustingZoomFactor = 6.0F;
                     WorldmapDefinitions.zoomFactorPrecise = 6.0F;
                  }
               } else {
                  WorldmapDefinitions.adjustingZoomFactor = 4.0F;
                  WorldmapDefinitions.zoomFactorPrecise = 4.0F;
               }
            } else {
               WorldmapDefinitions.adjustingZoomFactor = 3.0F;
               WorldmapDefinitions.zoomFactorPrecise = 3.0F;
            }

            WorldmapDefinitions.zoomFactor = (int)WorldmapDefinitions.adjustingZoomFactor >> 1;
            WorldmapDefinitions.aByteArrayArrayArray332 = Node_Sub29_Sub3.method2719(-7499, WorldmapDefinitions.zoomFactor);
            Class207.method2039(80);
            WorldmapDefinitions.method279();
            Node_Sub43.aClass312_7541 = new Class312();
            WorldmapDefinitions.anInt323 += (int)(5.0 * Math.random()) - 2;
            if (~WorldmapDefinitions.anInt323 > 7) {
               WorldmapDefinitions.anInt323 = -8;
            }

            WorldmapDefinitions.anInt324 += (int)(5.0 * Math.random()) - 2;
            if (WorldmapDefinitions.anInt323 > 8) {
               WorldmapDefinitions.anInt323 = 8;
            }

            if (~WorldmapDefinitions.anInt324 > 15) {
               WorldmapDefinitions.anInt324 = -16;
            }

            if (~WorldmapDefinitions.anInt324 < -17) {
               WorldmapDefinitions.anInt324 = 16;
            }

            WorldmapDefinitions.populateOverlayColorsArray(var_d, WorldmapDefinitions.anInt323 >> 2 << 10, WorldmapDefinitions.anInt324 >> 1);
            WorldmapDefinitions.aClass215_322.method2068(-1, 1024, 256);
            WorldmapDefinitions.aClass338_315.method3912(256, 120, 256);
            WorldmapDefinitions.aClass112_319.method1144(64, 4096);
            IOException_Sub1.aClass128_85.method1543(16509, 256);
            Node_Sub25_Sub1.worldmapLoaded = 20;
         } else {
            if (bool) {
               worldmapExecutor(null, null, false);
            }

            if (~Node_Sub25_Sub1.worldmapLoaded == -21) {
               Node_Sub24.method2650(true, -14651);
               WorldmapDefinitions.loadWorldMapArea(graphicstoolkit, WorldmapDefinitions.anInt323, WorldmapDefinitions.anInt324);
               Node_Sub25_Sub1.worldmapLoaded = 60;
               Node_Sub24.method2650(true, -14651);
               Node_Sub38_Sub10.method2824(0);
            } else if (Node_Sub25_Sub1.worldmapLoaded == 60) {
               if (!WorldmapDefinitions.aClass302_314.method3516(WorldmapDefinitions.currentWorldmapArea.archivename + "_staticelements", -74)) {
                  WorldmapDefinitions.aClass224_330 = new Class224(0);
               } else {
                  if (!WorldmapDefinitions.aClass302_314.method3527(WorldmapDefinitions.currentWorldmapArea.archivename + "_staticelements", 0)) {
                     return;
                  }

                  WorldmapDefinitions.aClass224_330 = Class152.method1695(
                     Class101.aBoolean1313, 0, WorldmapDefinitions.aClass302_314, WorldmapDefinitions.currentWorldmapArea.archivename + "_staticelements"
                  );
               }

               WorldmapDefinitions.method289();
               Node_Sub25_Sub1.worldmapLoaded = 70;
               Node_Sub24.method2650(true, -14651);
               Node_Sub38_Sub10.method2824(0);
            } else if (~Node_Sub25_Sub1.worldmapLoaded == -71) {
               Packet.aClass299_9394 = new Class299(graphicstoolkit, 11, true, Node_Sub38_Sub20.GAME_CANVAS);
               Node_Sub25_Sub1.worldmapLoaded = 73;
               Node_Sub24.method2650(true, -14651);
               Node_Sub38_Sub10.method2824(0);
            } else if (~Node_Sub25_Sub1.worldmapLoaded == -74) {
               EntityNode_Sub6.aClass299_5988 = new Class299(graphicstoolkit, 12, true, Node_Sub38_Sub20.GAME_CANVAS);
               Node_Sub25_Sub1.worldmapLoaded = 76;
               Node_Sub24.method2650(true, -14651);
               Node_Sub38_Sub10.method2824(0);
            } else if (~Node_Sub25_Sub1.worldmapLoaded == -77) {
               Class75.aClass299_1007 = new Class299(graphicstoolkit, 14, true, Node_Sub38_Sub20.GAME_CANVAS);
               Node_Sub25_Sub1.worldmapLoaded = 79;
               Node_Sub24.method2650(true, -14651);
               Node_Sub38_Sub10.method2824(0);
            } else if (~Node_Sub25_Sub1.worldmapLoaded == -80) {
               Class352.aClass299_4329 = new Class299(graphicstoolkit, 17, true, Node_Sub38_Sub20.GAME_CANVAS);
               Node_Sub25_Sub1.worldmapLoaded = 82;
               Node_Sub24.method2650(true, -14651);
               Node_Sub38_Sub10.method2824(0);
            } else if (Node_Sub25_Sub1.worldmapLoaded == 82) {
               Class150_Sub2.aClass299_8962 = new Class299(graphicstoolkit, 19, true, Node_Sub38_Sub20.GAME_CANVAS);
               Node_Sub25_Sub1.worldmapLoaded = 85;
               Node_Sub24.method2650(true, -14651);
               Node_Sub38_Sub10.method2824(0);
            } else if (~Node_Sub25_Sub1.worldmapLoaded == -86) {
               Node_Sub25_Sub3.aClass299_9980 = new Class299(graphicstoolkit, 22, true, Node_Sub38_Sub20.GAME_CANVAS);
               Node_Sub25_Sub1.worldmapLoaded = 88;
               Node_Sub24.method2650(true, -14651);
               Node_Sub38_Sub10.method2824(0);
            } else if (~Node_Sub25_Sub1.worldmapLoaded == -89) {
               Class195.aClass299_2380 = new Class299(graphicstoolkit, 26, true, Node_Sub38_Sub20.GAME_CANVAS);
               Node_Sub25_Sub1.worldmapLoaded = 91;
               Node_Sub24.method2650(true, -14651);
               Node_Sub38_Sub10.method2824(0);
            } else {
               Class190.aClass299_2330 = new Class299(graphicstoolkit, 30, true, Node_Sub38_Sub20.GAME_CANVAS);
               Node_Sub25_Sub1.worldmapLoaded = 100;
               Node_Sub24.method2650(true, -14651);
               Node_Sub38_Sub10.method2824(0);
               System.gc();
            }
         }
      }
   }

   static final int method254(int i, int i_1_, int i_2_) {
      ++anInt5499;
      if (i_1_ != 16939) {
         aClass42_5498 = null;
      }

      int i_3_ = i_2_ - 1 & i >> 31;
      return i_3_ + (i + (i >>> 31)) % i_2_;
   }

   @Override
   final void method222(int i, Class48 class48, byte b) {
      BufferedConnection.method427(class48, i, this.anAnimable5497, (byte)-63);
      ++anInt5495;
      if (b <= 3) {
         method254(-77, 48, 34);
      }
   }

   AnimableAnimator(Animable animable, boolean bool) {
      super(bool);
      this.anAnimable5497 = animable;
   }
}
