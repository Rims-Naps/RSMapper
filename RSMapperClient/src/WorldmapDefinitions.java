class WorldmapDefinitions {
   static Index aClass302_314;
   static Class338 aClass338_315;
   static HashTable aHashTable316 = new HashTable(16);
   static Interface17 anInterface17_317;
   static WorldmapAreaDetail currentWorldmapArea;
   static Class112 aClass112_319;
   static Class71 aClass71_320;
   static Class58 aClass58_321;
   static Class215 aClass215_322;
   static int anInt323 = (int)(Math.random() * 11.0) - 5;
   static int anInt324 = (int)(Math.random() * 17.0) - 8;
   static byte[] aByteArray325 = new byte[1];
   static int[] aShortArray326 = new int[1];
   static float adjustingZoomFactor;
   static int zoomFactor;
   static float zoomFactorPrecise;
   static Class224 aClass224_330;
   static Class312 aClass312_331 = new Class312();
   static byte[][][] aByteArrayArrayArray332;
   static int totalYTiles;
   static int[] worldmapObjectIds;
   static byte[] aByteArray335;
   static byte[] worldmapUnderlays;
   static int maxHeight;
   static short[] aShortArray338;
   static int anInt339;
   static byte[] worldmapObjectOrientations;
   static int maxWidth;
   static int[] overlayColors;
   static int regionYWorldCoordinate;
   static int anInt344;
   static int totalXTiles;
   static byte[] worldmapShapeAndRotations;
   static HashTable aHashTable347;
   static int anInt348;
   static int baseX;
   static int anInt350;
   static byte[] worldmapOverlays;
   static int baseY;
   static Class103[][][] aClass103ArrayArrayArray353;
   static int regionXWorldCoordinate;
   static int drawnBaseCoordX;
   static int drawnBaseCoordY;
   static int mouseHoveredX;
   static int mouseHoveredY;

   static final WorldmapAreaDetail method269(int i) {
      return (WorldmapAreaDetail)aHashTable316.get(3512, (long)i);
   }

   public static boolean worldmapIsOpen() {
      return Class320_Sub15.WINDOWS_PANE_ID == 755;
   }

   public static void closeWorldmap() {
      Class46.method467(-1, true);
      Class169.method1760(true);
      Class320_Sub15.WINDOWS_PANE_ID = 746;
      Node_Sub11.method2543(746, 0);
      Node_Sub29_Sub3.method2717(1, false);
      ClientScriptsExecutor.parseIComponentScript(746);

      for(int i_91_ = 0; ~i_91_ > -101; ++i_91_) {
         Class195.aBooleanArray2387[i_91_] = true;
      }
   }

   static final void updateWorldMap(GraphicsToolkit graphicstoolkit) {
      int i = maxWidth - baseX;
      int i_0_ = maxHeight - baseY;
      int i_1_ = (anInt348 - anInt344 << 16) / i;
      int i_2_ = (anInt339 - anInt350 << 16) / i_0_;
      drawAndUpdateWorldMap(graphicstoolkit, i_1_, i_2_, 0, 0);
   }

   static byte findByteForShapeRotation(int shape, int rotation) {
      for(int i = 0; i < 256; ++i) {
         if ((i & 63) == shape && (i >> 6 & 3) == rotation) {
            return (byte)i;
         }
      }

      return 0;
   }

   static final void drawShape(
      int sizeY,
      byte[][][] shapeData,
      int overlayColor,
      int sizeX,
      int zoom,
      int offsetX,
      GraphicsToolkit graphicstoolkit,
      int i_7_,
      int rotation,
      byte junk,
      int offsetY,
      int underlayColor,
      int shape
   ) {
      ++Class117_Sub2.anInt5153;
      if (shape != 0 && zoom != 0) {
         if (shape == 9) {
            rotation = rotation + 1 & 3;
            shape = 1;
         }

         if (shape == 10) {
            shape = 1;
            rotation = 3 & 3 + rotation;
         }

         if (shape == 11) {
            rotation = 3 & rotation + 3;
            shape = 2;
         }

         graphicstoolkit.Q(offsetX, offsetY, sizeX, sizeY, underlayColor, overlayColor, shapeData[-1 + shape][rotation], zoom, i_7_);
         int var13 = -68 / (-junk / 58);
      }
   }

   private static final void draw(
      GraphicsToolkit graphicstoolkit,
      int offsetX,
      int offsetY,
      int sizeX,
      int sizeY,
      int underlayColor,
      int overlayId,
      int shapeRotation,
      int[] objectIds,
      byte[] objectOrientations,
      boolean drawOverlay,
      int editorMarker
   ) {
      if (drawOverlay || underlayColor != 0 || overlayId > 0) {
         if (overlayId == 0) {
            graphicstoolkit.aa(offsetX, offsetY, sizeX, sizeY, underlayColor, 0);
         } else {
            int shape = shapeRotation & 63;
            if (shape != 0 && sizeX > 1 && sizeY > 1) {
               drawShape(
                  sizeY,
                  aByteArrayArrayArray332,
                  overlayColors[overlayId >= overlayColors.length ? overlayColors.length - 1 : overlayId],
                  sizeX,
                  zoomFactor,
                  offsetX,
                  graphicstoolkit,
                  drawOverlay ? 0 : 1,
                  shapeRotation >> 6 & 3,
                  (byte)-122,
                  offsetY,
                  underlayColor,
                  shape
               );
            } else {
               int overlayColor = overlayColors[overlayId >= overlayColors.length ? overlayColors.length - 1 : overlayId];
               if (drawOverlay || overlayColor != 0) {
                  graphicstoolkit.aa(offsetX, offsetY, sizeX, sizeY, overlayColor, 0);
               }
            }
         }
      }

      if (objectIds != null) {
         int rotatedOffsetX;
         if (sizeX == 1) {
            rotatedOffsetX = offsetX;
         } else {
            rotatedOffsetX = offsetX + sizeX - 1;
         }

         int rotatedOffsetY;
         if (sizeY == 1) {
            rotatedOffsetY = offsetY;
         } else {
            rotatedOffsetY = offsetY + sizeY - 1;
         }

         for(int i = 0; i < objectIds.length; ++i) {
            int type = objectOrientations[i] & 63;
            if (type == 0 || type == 2 || type == 3 || type == 9) {
               ObjectDefinition objectdefinition = aClass112_319.getObjectDefinitionsForId(objectIds[i] & 65535, 55);
               if (objectdefinition.mapSpriteId == -1) {
                  int wallColor = editorMarker == 0
                     ? RSMapperClient.settings.hoverOverlayColor
                     : (editorMarker == 1 ? RSMapperClient.settings.selectedOverlayColor : -3355444);
                  if (objectdefinition.anInt3057 == 1) {
                     wallColor = editorMarker == 0
                        ? RSMapperClient.settings.hoverOverlayColor
                        : (editorMarker == 1 ? RSMapperClient.settings.selectedOverlayColor : -3407872);
                  }

                  int rotation = objectOrientations[i] >> 6 & 3;
                  if (type == 0) {
                     if (rotation == 0) {
                        graphicstoolkit.P(offsetX, offsetY, sizeY, wallColor, 0);
                     } else if (rotation == 1) {
                        graphicstoolkit.U(offsetX, offsetY, sizeX, wallColor, 0);
                     } else if (rotation == 2) {
                        graphicstoolkit.P(rotatedOffsetX, offsetY, sizeY, wallColor, 0);
                     } else {
                        graphicstoolkit.U(offsetX, rotatedOffsetY, sizeX, wallColor, 0);
                     }
                  } else if (type == 2) {
                     if (rotation == 0) {
                        graphicstoolkit.P(offsetX, offsetY, sizeY, wallColor, 0);
                        graphicstoolkit.U(offsetX, offsetY, sizeX, wallColor, 0);
                     } else if (rotation == 1) {
                        graphicstoolkit.P(rotatedOffsetX, offsetY, sizeY, wallColor, 0);
                        graphicstoolkit.U(offsetX, offsetY, sizeX, wallColor, 0);
                     } else if (rotation == 2) {
                        graphicstoolkit.P(rotatedOffsetX, offsetY, sizeY, wallColor, 0);
                        graphicstoolkit.U(offsetX, rotatedOffsetY, sizeX, wallColor, 0);
                     } else {
                        graphicstoolkit.P(offsetX, offsetY, sizeY, wallColor, 0);
                        graphicstoolkit.U(offsetX, rotatedOffsetY, sizeX, wallColor, 0);
                     }
                  } else if (type == 3) {
                     if (rotation == 0) {
                        graphicstoolkit.U(offsetX, offsetY, 1, wallColor, 0);
                     } else if (rotation == 1) {
                        graphicstoolkit.U(rotatedOffsetX, offsetY, 1, wallColor, 0);
                     } else if (rotation == 2) {
                        graphicstoolkit.U(rotatedOffsetX, rotatedOffsetY, 1, wallColor, 0);
                     } else {
                        graphicstoolkit.U(offsetX, rotatedOffsetY, 1, wallColor, 0);
                     }
                  } else if (type == 9) {
                     if (rotation != 0 && rotation != 2) {
                        for(int i_19_ = 0; i_19_ < sizeY; ++i_19_) {
                           graphicstoolkit.U(offsetX + i_19_, offsetY + i_19_, 1, wallColor, 0);
                        }
                     } else {
                        for(int i_18_ = 0; i_18_ < sizeY; ++i_18_) {
                           graphicstoolkit.U(offsetX + i_18_, rotatedOffsetY - i_18_, 1, wallColor, 0);
                        }
                     }
                  }
               }
            }
         }
      }
   }

   static final void method272(int i, int i_20_, int i_21_, int i_22_, int i_23_, int i_24_, int i_25_, int i_26_) {
      baseX = i - regionXWorldCoordinate;
      maxHeight = i_20_ - regionYWorldCoordinate;
      maxWidth = i_21_ - regionXWorldCoordinate;
      baseY = i_22_ - regionYWorldCoordinate;
      anInt344 = i_23_;
      anInt350 = i_24_;
      anInt348 = i_25_;
      anInt339 = i_26_;
   }

   private static final void method273(GraphicsToolkit graphicstoolkit, int i, int i_27_, int i_28_, int i_29_, int[] ses, byte[] bs) {
      if (ses != null) {
         for(int i_30_ = 0; i_30_ < ses.length; ++i_30_) {
            ObjectDefinition objectdefinition = aClass112_319.getObjectDefinitionsForId(ses[i_30_] & 65535, 116);
            int spriteId = objectdefinition.mapSpriteId;
            if (spriteId != -1) {
               Class140 class140 = aClass338_315.method3909(spriteId, 34);
               GLSprite glsprite = class140.method1606(
                  objectdefinition.aBoolean3056 ? bs[i_30_] >> 6 & 3 : 0,
                  graphicstoolkit,
                  objectdefinition.aBoolean3007 ? objectdefinition.aBoolean3039 : false,
                  0
               );
               if (glsprite != null) {
                  int i_32_ = i_28_ * glsprite.method1197() >> 2;
                  int i_33_ = i_29_ * glsprite.method1186() >> 2;
                  if (class140.aBoolean1741) {
                     int i_34_ = objectdefinition.sizeX;
                     int i_35_ = objectdefinition.sizeY;
                     if ((bs[i_30_] >> 6 & 1) == 1) {
                        int i_36_ = i_34_;
                        i_34_ = i_35_;
                        i_35_ = i_36_;
                     }

                     i_32_ = i_34_ * i_28_;
                     i_33_ = i_35_ * i_29_;
                  }

                  if (i_32_ != 0 && i_33_ != 0) {
                     if (class140.anInt1737 != 0) {
                        glsprite.method1199(i, i_27_ - i_33_ + i_29_, i_32_, i_33_, 0, 0xFF000000 | class140.anInt1737, 1);
                     } else {
                        glsprite.method1200(i, i_27_ - i_33_ + i_29_, i_32_, i_33_);
                     }
                  }
               }
            }
         }
      }
   }

   static final void method274(byte[] underlays, byte[] bs_37_, short[] ses, int i, int i_38_) {
      int[] is = new int[totalYTiles];
      int[] is_39_ = new int[totalYTiles];
      int[] is_40_ = new int[totalYTiles];
      int[] is_41_ = new int[totalYTiles];
      int[] is_42_ = new int[totalYTiles];

      for(int i_43_ = -5; i_43_ < totalXTiles; ++i_43_) {
         int i_44_ = i_43_ + 5;
         int i_45_ = i_43_ - 5;

         for(int i_46_ = 0; i_46_ < totalYTiles; ++i_46_) {
            if (i_44_ < totalXTiles) {
               int underlay = underlays[i_44_ + i_46_ * totalXTiles] & 255;
               if (underlay > 0) {
                  UnderlayDefinition underlayDef = aClass58_321.getUnderlayDefinitions(-17993, underlay - 1);
                  is[i_46_] += underlayDef.anInt2888;
                  is_39_[i_46_] += underlayDef.anInt2897;
                  is_40_[i_46_] += underlayDef.anInt2901;
                  is_41_[i_46_] += underlayDef.anInt2890;
                  is_42_[i_46_]++;
               }
            }

            if (i_45_ >= 0) {
               int underlay = underlays[i_45_ + i_46_ * totalXTiles] & 255;
               if (underlay > 0) {
                  UnderlayDefinition class236 = aClass58_321.getUnderlayDefinitions(-17993, underlay - 1);
                  is[i_46_] -= class236.anInt2888;
                  is_39_[i_46_] -= class236.anInt2897;
                  is_40_[i_46_] -= class236.anInt2901;
                  is_41_[i_46_] -= class236.anInt2890;
                  is_42_[i_46_]--;
               }
            }
         }

         if (i_43_ >= 0) {
            int i_49_ = 0;
            int i_50_ = 0;
            int i_51_ = 0;
            int i_52_ = 0;
            int i_53_ = 0;

            for(int i_54_ = -5; i_54_ < totalYTiles; ++i_54_) {
               int i_55_ = i_54_ + 5;
               if (i_55_ < totalYTiles) {
                  i_49_ += is[i_55_];
                  i_50_ += is_39_[i_55_];
                  i_51_ += is_40_[i_55_];
                  i_52_ += is_41_[i_55_];
                  i_53_ += is_42_[i_55_];
               }

               int i_56_ = i_54_ - 5;
               if (i_56_ >= 0) {
                  i_49_ -= is[i_56_];
                  i_50_ -= is_39_[i_56_];
                  i_51_ -= is_40_[i_56_];
                  i_52_ -= is_41_[i_56_];
                  i_53_ -= is_42_[i_56_];
               }

               if (i_54_ >= 0 && i_53_ > 0) {
                  if ((underlays[i_43_ + i_54_ * totalXTiles] & 255) == 0) {
                     int i_57_ = i_43_ + i_54_ * totalXTiles;
                     bs_37_[i_57_] = 0;
                     ses[i_57_] = 0;
                  } else {
                     int i_58_ = i_52_ == 0 ? 0 : Node_Sub25.method2651(i_51_ / i_53_, i_50_ / i_53_, false, i_49_ * 256 / i_52_);
                     int i_59_ = (i_58_ & 127) + i_38_;
                     if (i_59_ < 0) {
                        i_59_ = 0;
                     } else if (i_59_ > 127) {
                        i_59_ = 127;
                     }

                     int i_60_ = (i_58_ + i & 64512) + (i_58_ & 896) + i_59_;
                     int i_61_ = i_43_ + i_54_ * totalXTiles;
                     int i_62_ = Class170.anIntArray2054[Node_Sub15_Sub2.method2560(5310, Class194_Sub1.method1964(96, -14042, i_60_)) & '\uffff'];
                     bs_37_[i_61_] = (byte)(i_62_ >> 16 & 0xFF);
                     ses[i_61_] = (short)(i_62_ & 65535);
                  }
               }
            }
         }
      }
   }

   static final void method275(
      Index class302, Class71 class71, Class58 class58, Class112 class112, Class215 class215, Class338 class338, Interface17 interface17
   ) {
      aClass302_314 = class302;
      aClass71_320 = class71;
      aClass58_321 = class58;
      aClass112_319 = class112;
      aClass215_322 = class215;
      aClass338_315 = class338;
      anInterface17_317 = interface17;
      aHashTable316.method1517(false);
      int archiveId = aClass302_314.method3519("details", (byte)93);
      int[] is = aClass302_314.method3532(archiveId, 0);
      if (is != null) {
         for(int i_63_ = 0; i_63_ < is.length; ++i_63_) {
            WorldmapAreaDetail cachenode_sub11 = Class274.loadWorldmapAreaDetails(aClass302_314, archiveId, is[i_63_], 0);
            aHashTable316.put((long)cachenode_sub11.fileId, cachenode_sub11, -123);
         }
      }

      Class110.method1132(0, false, true);
   }

   private static final void drawAndUpdateWorldMap(GraphicsToolkit graphicstoolkit, int i, int i_64_, int i_65_, int i_66_) {
      int widthDrawn = maxWidth - baseX;
      int heightDrawn = maxHeight - baseY;
      if (maxWidth < totalXTiles) {
         ++widthDrawn;
      }

      if (maxHeight < totalYTiles) {
         ++heightDrawn;
      }

      for(int x = 0; x < widthDrawn; ++x) {
         int offsetX = (i_65_ + i * x >> 16) + anInt344;
         int rotatedOffsetX = (i_65_ + i * (x + 1) >> 16) + anInt344;
         int sizeX = rotatedOffsetX - offsetX;
         if (sizeX > 0) {
            int tileOnX = baseX + x;
            if (tileOnX >= 0 && tileOnX < totalXTiles) {
               for(int y = 0; y < heightDrawn; ++y) {
                  int offsetY = anInt339 - (i_66_ + i_64_ * (y + 1) >> 16);
                  int rotatedOffsetY = anInt339 - (i_66_ + i_64_ * y >> 16);
                  int sizeY = rotatedOffsetY - offsetY;
                  if (sizeY > 0) {
                     int tileOnY = y + baseY;
                     int worldX = regionXWorldCoordinate + tileOnX;
                     int worldY = regionYWorldCoordinate + tileOnY;
                     int posHash = tileOnX + tileOnY * totalXTiles;
                     boolean isHover = RSMapperClient.editor
                        .brush
                        .getTilesBasedOnBrushAndSize(mouseHoveredX, mouseHoveredY, 0, false)
                        .contains(new WorldTile(worldX, worldY, 0, false));
                     boolean isSelected = worldX == RSMapperClient.editor.selectedTile.getX() && worldY == RSMapperClient.editor.selectedTile.getY();
                     if (worldX < Utils.getRegionCoordX(RSMapperClient.regionId)
                        || worldY < Utils.getRegionCoordY(RSMapperClient.regionId)
                        || worldX >= Utils.getRegionCoordX(RSMapperClient.regionId) + 64
                        || worldY >= Utils.getRegionCoordY(RSMapperClient.regionId) + 64) {
                        isHover = false;
                     }

                     boolean isRegionBorder = worldX == Utils.getRegionCoordX(Utils.getRegionId(worldX, worldY))
                        || worldY == Utils.getRegionCoordY(Utils.getRegionId(worldX, worldY))
                        || worldX == Utils.getRegionCoordX(Utils.getRegionId(worldX, worldY) + 64)
                        || worldY == Utils.getRegionCoordY(Utils.getRegionId(worldX, worldY) + 64);
                     int color = 0;
                     int overlay = 0;
                     int objectId = 0;
                     if (tileOnY >= 0 && tileOnY < totalYTiles) {
                        color = (aByteArray335[posHash] & 255) << 16 | aShortArray338[posHash] & '\uffff';
                        if (color != 0) {
                           color |= -16777216;
                        }

                        overlay = worldmapOverlays[posHash] & 255;
                        objectId = worldmapObjectIds[posHash] & 65535;
                        if (isHover || isSelected || isRegionBorder) {
                           objectId = isRegionBorder ? 9027 : 9026;
                        }
                     }

                     if (color == 0 && overlay == 0 && objectId == 0) {
                        if (currentWorldmapArea.emptySpaceDisplayType != -1) {
                           color = 0xFF000000 | currentWorldmapArea.emptySpaceDisplayType;
                        } else if ((x + baseX & 4) != (y + maxHeight & 4)) {
                           color = -11840664;
                        } else {
                           color = overlayColors[aClass71_320.anInt961 + 1];
                        }

                        if (color == 0) {
                           color = -16777216;
                        }

                        graphicstoolkit.aa(offsetX, offsetY, sizeX, sizeY, color, 0);
                     } else if (objectId > 0) {
                        if (objectId == 65535) {
                           Node_Sub17 node_sub17 = (Node_Sub17)aHashTable347.get(3512, (long)(tileOnX << 16 | tileOnY));
                           if (node_sub17 != null) {
                              draw(
                                 graphicstoolkit,
                                 offsetX,
                                 offsetY,
                                 sizeX,
                                 sizeY,
                                 color,
                                 overlay,
                                 worldmapShapeAndRotations[posHash],
                                 node_sub17.aShortArray7148,
                                 node_sub17.aByteArray7147,
                                 true,
                                 -1
                              );
                           }
                        } else if (!isHover && !isSelected) {
                           aShortArray326[0] = (short)(objectId - 1);
                           if (worldX == Utils.getRegionCoordX(Utils.getRegionId(worldX, worldY))) {
                              aByteArray325[0] = findByteForShapeRotation(0, 0);
                           } else if (worldX == Utils.getRegionCoordX(Utils.getRegionId(worldX, worldY)) + 64) {
                              aByteArray325[0] = findByteForShapeRotation(0, 2);
                           } else if (worldY == Utils.getRegionCoordY(Utils.getRegionId(worldX, worldY))) {
                              aByteArray325[0] = findByteForShapeRotation(0, 3);
                           } else if (worldY == Utils.getRegionCoordY(Utils.getRegionId(worldX, worldY)) + 64) {
                              aByteArray325[0] = findByteForShapeRotation(0, 1);
                           } else {
                              aByteArray325[0] = worldmapObjectOrientations[posHash];
                           }

                           boolean editingRegion = isRegionBorder
                              && worldX >= Utils.getRegionCoordX(RSMapperClient.regionId)
                              && worldX <= Utils.getRegionCoordX(RSMapperClient.regionId) + 64
                              && worldY >= Utils.getRegionCoordY(RSMapperClient.regionId)
                              && worldY <= Utils.getRegionCoordY(RSMapperClient.regionId) + 64;
                           draw(
                              graphicstoolkit,
                              offsetX,
                              offsetY,
                              sizeX,
                              sizeY,
                              color,
                              overlay,
                              worldmapShapeAndRotations[posHash],
                              aShortArray326,
                              aByteArray325,
                              true,
                              editingRegion ? 0 : -1
                           );
                        } else {
                           aShortArray326 = new int[]{objectId - 1, objectId - 1};
                           aByteArray325 = new byte[]{findByteForShapeRotation(2, 2), findByteForShapeRotation(2, 0)};
                           draw(
                              graphicstoolkit,
                              offsetX,
                              offsetY,
                              sizeX,
                              sizeY,
                              color,
                              overlay,
                              worldmapShapeAndRotations[posHash],
                              aShortArray326,
                              aByteArray325,
                              true,
                              isSelected ? 1 : 0
                           );
                           aShortArray326 = new int[1];
                           aByteArray325 = new byte[1];
                        }
                     } else {
                        draw(graphicstoolkit, offsetX, offsetY, sizeX, sizeY, color, overlay, worldmapShapeAndRotations[posHash], null, null, true, -1);
                     }
                  }
               }
            } else {
               for(int y = 0; y < heightDrawn; ++y) {
                  int i_75_ = anInt339 - (i_66_ + i_64_ * (y + 1) >> 16);
                  int i_76_ = anInt339 - (i_66_ + i_64_ * y >> 16);
                  int i_77_ = i_76_ - i_75_;
                  int i_78_;
                  if (currentWorldmapArea.emptySpaceDisplayType != -1) {
                     i_78_ = 0xFF000000 | currentWorldmapArea.emptySpaceDisplayType;
                  } else if ((x + baseX & 4) != (y + maxHeight & 4)) {
                     i_78_ = -11840664;
                  } else {
                     i_78_ = overlayColors[aClass71_320.anInt961 + 1];
                  }

                  if (i_78_ == 0) {
                     i_78_ = -16777216;
                  }

                  graphicstoolkit.aa(offsetX, i_75_, sizeX, i_77_, i_78_, 0);
               }
            }
         }
      }

      for(int x = -16; x < widthDrawn + 16; ++x) {
         int i_89_ = (i_65_ + i * x >> 16) + anInt344;
         int i_90_ = (i_65_ + i * (x + 1) >> 16) + anInt344;
         int i_91_ = i_90_ - i_89_;
         if (i_91_ > 0) {
            int i_92_ = x + baseX;
            if (i_92_ >= 0 && i_92_ < totalXTiles) {
               for(int y = -16; y < heightDrawn + 16; ++y) {
                  int i_94_ = anInt339 - (i_66_ + i_64_ * (y + 1) >> 16);
                  int i_95_ = anInt339 - (i_66_ + i_64_ * y >> 16);
                  int i_96_ = i_95_ - i_94_;
                  if (i_96_ > 0) {
                     int i_97_ = y + baseY;
                     if (i_97_ >= 0 && i_97_ < totalYTiles) {
                        int i_98_ = worldmapObjectIds[i_92_ + i_97_ * totalXTiles] & 65535;
                        if (i_98_ > 0) {
                           if (i_98_ == 65535) {
                              Node_Sub17 node_sub17 = (Node_Sub17)aHashTable347.get(3512, (long)(i_92_ << 16 | i_97_));
                              if (node_sub17 != null) {
                                 method273(graphicstoolkit, i_89_, i_94_, i_91_, i_96_, node_sub17.aShortArray7148, node_sub17.aByteArray7147);
                              }
                           } else {
                              aShortArray326[0] = (short)(i_98_ - 1);
                              aByteArray325[0] = worldmapObjectOrientations[i_92_ + i_97_ * totalXTiles];
                              method273(graphicstoolkit, i_89_, i_94_, i_91_, i_96_, aShortArray326, aByteArray325);
                           }
                        } else {
                           method273(graphicstoolkit, i_89_, i_94_, i_91_, i_96_, null, null);
                        }
                     }
                  }
               }
            }
         }
      }

      int i_99_ = baseX >> 6;
      int i_100_ = baseY >> 6;
      if (i_99_ < 0) {
         i_99_ = 0;
      }

      if (i_100_ < 0) {
         i_100_ = 0;
      }

      int i_101_ = maxWidth >> 6;
      int i_102_ = maxHeight >> 6;
      if (i_101_ >= aClass103ArrayArrayArray353[0].length) {
         i_101_ = aClass103ArrayArrayArray353[0].length - 1;
      }

      if (i_102_ >= aClass103ArrayArrayArray353[0][0].length) {
         i_102_ = aClass103ArrayArrayArray353[0][0].length - 1;
      }

      for(int plane = 0; plane < 3; ++plane) {
         for(int x = i_99_; x <= i_101_; ++x) {
            for(int y = i_100_; y <= i_102_; ++y) {
               Class103 class103 = aClass103ArrayArrayArray353[plane][x][y];
               if (class103 != null) {
                  int i_106_ = (x + (regionXWorldCoordinate >> 6)) * 64;
                  int i_107_ = (y + (regionYWorldCoordinate >> 6)) * 64;

                  for(EntityNode_Sub9 entitynode_sub9 = (EntityNode_Sub9)class103.method1113((byte)-118);
                     entitynode_sub9 != null;
                     entitynode_sub9 = (EntityNode_Sub9)class103.method1108(106)
                  ) {
                     int i_108_ = i_106_ + entitynode_sub9.aByte6029 - regionXWorldCoordinate - baseX;
                     int i_109_ = i_107_ + entitynode_sub9.aByte6031 - regionYWorldCoordinate - baseY;
                     int i_110_ = (i_65_ + i * i_108_ >> 16) + anInt344;
                     int i_111_ = (i_65_ + i * (i_108_ + 1) >> 16) + anInt344;
                     int i_112_ = anInt339 - (i_66_ + i_64_ * (i_109_ + 1) >> 16);
                     int i_113_ = anInt339 - (i_66_ + i_64_ * i_109_ >> 16);
                     draw(
                        graphicstoolkit,
                        i_110_,
                        i_112_,
                        i_111_ - i_110_,
                        i_113_ - i_112_,
                        entitynode_sub9.anInt6027,
                        entitynode_sub9.aByte6028 & 255,
                        entitynode_sub9.aByte6026,
                        entitynode_sub9.aShortArray6025,
                        entitynode_sub9.aByteArray6030,
                        false,
                        -1
                     );
                  }
               }
            }
         }

         for(int i_114_ = i_99_; i_114_ <= i_101_; ++i_114_) {
            for(int i_115_ = i_100_; i_115_ <= i_102_; ++i_115_) {
               Class103 class103 = aClass103ArrayArrayArray353[plane][i_114_][i_115_];
               if (class103 != null) {
                  int i_116_ = (i_114_ + (regionXWorldCoordinate >> 6)) * 64;
                  int i_117_ = (i_115_ + (regionYWorldCoordinate >> 6)) * 64;

                  for(EntityNode_Sub9 entitynode_sub9 = (EntityNode_Sub9)class103.method1113((byte)127);
                     entitynode_sub9 != null;
                     entitynode_sub9 = (EntityNode_Sub9)class103.method1108(94)
                  ) {
                     int i_118_ = i_116_ + entitynode_sub9.aByte6029 - regionXWorldCoordinate - baseX;
                     int i_119_ = i_117_ + entitynode_sub9.aByte6031 - regionYWorldCoordinate - baseY;
                     int i_120_ = (i_65_ + i * i_118_ >> 16) + anInt344;
                     int i_121_ = (i_65_ + i * (i_118_ + 1) >> 16) + anInt344;
                     int i_122_ = anInt339 - (i_66_ + i_64_ * (i_119_ + 1) >> 16);
                     int i_123_ = anInt339 - (i_66_ + i_64_ * i_119_ >> 16);
                     method273(
                        graphicstoolkit, i_120_, i_122_, i_121_ - i_120_, i_123_ - i_122_, entitynode_sub9.aShortArray6025, entitynode_sub9.aByteArray6030
                     );
                  }
               }
            }
         }
      }
   }

   static final void populateOverlayColorsArray(d var_d, int i, int i_124_) {
      for(int i_125_ = 0; i_125_ < aClass71_320.anInt956; ++i_125_) {
         overlayColors[i_125_ + 1] = getOverlayColor(var_d, i_125_, i, i_124_);
      }
   }

   private static final int getOverlayColor(d var_d, int overlayId, int i_126_, int i_127_) {
      OverlayDefinition class289 = aClass71_320.getOverlayDefinitions(overlayId, (byte)64);
      if (class289 == null) {
         return 0;
      } else {
         int i_128_ = class289.texture;
         if (i_128_ >= 0 && var_d.getTexture(i_128_, -8217).meshGround) {
            i_128_ = -1;
         }

         int i_129_;
         if (class289.mapColor >= 0) {
            int i_130_ = class289.mapColor;
            int i_131_ = (i_130_ & 127) + i_127_;
            if (i_131_ < 0) {
               i_131_ = 0;
            } else if (i_131_ > 127) {
               i_131_ = 127;
            }

            int i_132_ = (i_130_ + i_126_ & 64512) + (i_130_ & 896) + i_131_;
            i_129_ = 0xFF000000 | Class170.anIntArray2054[Node_Sub15_Sub2.method2560(5310, Class113.method1148(true, 96, i_132_)) & '\uffff'];
         } else if (i_128_ >= 0) {
            i_129_ = 0xFF000000
               | Class170.anIntArray2054[Node_Sub15_Sub2.method2560(5310, Class113.method1148(true, 96, var_d.getTexture(i_128_, -8217).colorIndex))
                  & '\uffff'];
         } else if (class289.anInt3631 == -1) {
            i_129_ = 0;
         } else {
            int i_133_ = class289.anInt3631;
            int i_134_ = (i_133_ & 127) + i_127_;
            if (i_134_ < 0) {
               i_134_ = 0;
            } else if (i_134_ > 127) {
               i_134_ = 127;
            }

            int i_135_ = (i_133_ + i_126_ & 64512) + (i_133_ & 896) + i_134_;
            i_129_ = 0xFF000000 | Class170.anIntArray2054[Node_Sub15_Sub2.method2560(5310, Class113.method1148(true, 96, i_135_)) & '\uffff'];
         }

         return i_129_;
      }
   }

   static final void method279() {
      worldmapUnderlays = new byte[totalXTiles * totalYTiles];
      worldmapOverlays = new byte[totalXTiles * totalYTiles];
      worldmapShapeAndRotations = new byte[totalXTiles * totalYTiles];
      worldmapObjectIds = new int[totalXTiles * totalYTiles];
      worldmapObjectOrientations = new byte[totalXTiles * totalYTiles];
      aHashTable347 = new HashTable(1024);
      aClass103ArrayArrayArray353 = new Class103[3][totalXTiles >> 6][totalYTiles >> 6];
      overlayColors = new int[aClass71_320.anInt956 + 1];
   }

   static final void method280() {
      worldmapUnderlays = null;
      aByteArray335 = null;
      aShortArray338 = null;
      worldmapOverlays = null;
      worldmapShapeAndRotations = null;
      worldmapObjectIds = null;
      worldmapObjectOrientations = null;
      aHashTable347 = null;
      aClass103ArrayArrayArray353 = null;
      overlayColors = null;
   }

   static final void method281(GraphicsToolkit graphicstoolkit, Node_Sub14 node_sub14, AreaDefinitions class79) {
      if (class79.anIntArray1049 != null) {
         int[] is = new int[class79.anIntArray1049.length];

         for(int i = 0; i < is.length / 2; ++i) {
            int i_136_ = class79.anIntArray1049[i * 2] + node_sub14.anInt7125;
            int i_137_ = class79.anIntArray1049[i * 2 + 1] + node_sub14.anInt7120;
            is[i * 2] = anInt344 + (anInt348 - anInt344) * (i_136_ - baseX) / (maxWidth - baseX);
            is[i * 2 + 1] = anInt339 - (anInt339 - anInt350) * (i_137_ - baseY) / (maxHeight - baseY);
         }

         Class74.method755(graphicstoolkit, is, class79.anInt1084);
         if (class79.anInt1074 > 0) {
            for(int i = 0; i < is.length / 2 - 1; ++i) {
               int i_138_ = is[i * 2];
               int i_139_ = is[i * 2 + 1];
               int i_140_ = is[(i + 1) * 2];
               int i_141_ = is[(i + 1) * 2 + 1];
               if (i_140_ < i_138_) {
                  int i_142_ = i_138_;
                  int i_143_ = i_139_;
                  i_138_ = i_140_;
                  i_139_ = i_141_;
                  i_140_ = i_142_;
                  i_141_ = i_143_;
               } else if (i_140_ == i_138_ && i_141_ < i_139_) {
                  int i_144_ = i_139_;
                  i_139_ = i_141_;
                  i_141_ = i_144_;
               }

               graphicstoolkit.a(
                  i_138_,
                  i_139_,
                  i_140_,
                  i_141_,
                  class79.anIntArray1066[class79.aByteArray1057[i] & 255],
                  1,
                  class79.anInt1074,
                  class79.anInt1050,
                  class79.anInt1080
               );
            }

            int i = is[is.length - 2];
            int i_145_ = is[is.length - 1];
            int i_146_ = is[0];
            int i_147_ = is[1];
            if (i_146_ < i) {
               int i_148_ = i;
               int i_149_ = i_145_;
               i = i_146_;
               i_145_ = i_147_;
               i_146_ = i_148_;
               i_147_ = i_149_;
            } else if (i_146_ == i && i_147_ < i_145_) {
               int i_150_ = i_145_;
               i_145_ = i_147_;
               i_147_ = i_150_;
            }

            graphicstoolkit.a(
               i,
               i_145_,
               i_146_,
               i_147_,
               class79.anIntArray1066[class79.aByteArray1057[class79.aByteArray1057.length - 1] & 255],
               1,
               class79.anInt1074,
               class79.anInt1050,
               class79.anInt1080
            );
         } else {
            for(int i = 0; i < is.length / 2 - 1; ++i) {
               graphicstoolkit.method1236(
                  is[(i + 1) * 2 + 1], is[i * 2 + 1], is[(i + 1) * 2], class79.anIntArray1066[class79.aByteArray1057[i] & 255], 1, is[i * 2]
               );
            }

            graphicstoolkit.method1236(
               is[1], is[is.length - 1], is[0], class79.anIntArray1066[class79.aByteArray1057[class79.aByteArray1057.length - 1] & 255], 1, is[is.length - 2]
            );
         }
      }
   }

   static final void method282(int i) {
      currentWorldmapArea = (WorldmapAreaDetail)aHashTable316.get(3512, (long)i);
   }

   private static final void method283(GraphicsToolkit graphicstoolkit, Node_Sub14 node_sub14, int i, int i_151_, int i_152_, int i_153_) {
      node_sub14.anInt7126 = anInt344 + (i_152_ + i * (node_sub14.anInt7125 - baseX) >> 16);
      node_sub14.anInt7118 = anInt339 - (i_153_ + i_151_ * (node_sub14.anInt7120 - baseY) >> 16);
   }

   private static final void decodeWorldMapTerrain(
      Buffer buffer, int regionLocalX, int regionLocalY, int tileOnX, int tileOnY, int[] underlayPalette, int[] overlayPalette
   ) {
      int posHash = tileOnX + tileOnY * totalXTiles;
      if (regionXWorldCoordinate + tileOnX >= Utils.getRegionCoordX(RSMapperClient.regionId)
         && regionXWorldCoordinate + tileOnX <= Utils.getRegionCoordX(RSMapperClient.regionId) + 64
         && regionYWorldCoordinate + tileOnY >= Utils.getRegionCoordY(RSMapperClient.regionId)
         && regionYWorldCoordinate + tileOnY <= Utils.getRegionCoordY(RSMapperClient.regionId) + 64) {
         readEmptyWorldMapTerrain(buffer);
         int localX = Utils.getLocalXFromCoordX(regionXWorldCoordinate + tileOnX, RSMapperClient.regionId);
         int localY = Utils.getLocalYFromCoordY(regionYWorldCoordinate + tileOnY, RSMapperClient.regionId);
         int plane = 0;
         if ((RSMapperClient.editor.mapEditor.flags[1][localX][localY] & 2) == 2 || (RSMapperClient.editor.mapEditor.flags[1][localX][localY] & 8) == 8) {
            ++plane;
         }

         int overlayOnTile = RSMapperClient.editor.mapEditor.overlays[plane][localX][localY];
         int underlayOnTile = RSMapperClient.editor.mapEditor.underlays[plane][localX][localY];
         int shapeOnTile = RSMapperClient.editor.mapEditor.shapes[plane][localX][localY];
         int rotationOnTile = RSMapperClient.editor.mapEditor.rotations[plane][localX][localY];
         if (plane <= 0) {
            worldmapOverlays[posHash] = (byte)overlayOnTile;
            worldmapUnderlays[posHash] = (byte)underlayOnTile;
            worldmapShapeAndRotations[posHash] = findByteForShapeRotation(shapeOnTile, rotationOnTile);
         } else {
            int overlayOnBottomTile = RSMapperClient.editor.mapEditor.overlays[plane - 1][localX][localY];
            int underlayOnBottomTile = RSMapperClient.editor.mapEditor.underlays[plane - 1][localX][localY];
            int shapeOnBottomTile = RSMapperClient.editor.mapEditor.shapes[plane - 1][localX][localY];
            int rotationOnBottomTile = RSMapperClient.editor.mapEditor.rotations[plane - 1][localX][localY];
            if ((RSMapperClient.editor.mapEditor.flags[1][localX][localY] & 2) != 2) {
               if (overlayOnBottomTile != 0 && overlayOnBottomTile != 42) {
                  worldmapOverlays[posHash] = (byte)overlayOnBottomTile;
               } else if (overlayOnTile != 0 && overlayOnTile != 42) {
                  worldmapOverlays[posHash] = (byte)overlayOnTile;
               } else {
                  worldmapOverlays[posHash] = 0;
                  worldmapUnderlays[posHash] = (byte)underlayOnBottomTile;
               }
            } else if (overlayOnTile != 0 && overlayOnTile != 42) {
               worldmapOverlays[posHash] = (byte)overlayOnTile;
            } else {
               worldmapOverlays[posHash] = 0;
               worldmapUnderlays[posHash] = (byte)underlayOnBottomTile;
            }

            if (underlayOnBottomTile != 0) {
               worldmapUnderlays[posHash] = (byte)underlayOnBottomTile;
            } else if (underlayOnTile != 0) {
               worldmapUnderlays[posHash] = (byte)underlayOnTile;
            } else {
               worldmapUnderlays[posHash] = (byte)underlayPalette[0];
            }

            if ((RSMapperClient.editor.mapEditor.flags[1][localX][localY] & 2) != 2) {
               if (shapeOnBottomTile != 0 && shapeOnBottomTile != 12) {
                  worldmapShapeAndRotations[posHash] = findByteForShapeRotation(shapeOnBottomTile, rotationOnBottomTile);
               } else if (shapeOnTile != 0 && shapeOnTile != 12) {
                  worldmapShapeAndRotations[posHash] = findByteForShapeRotation(shapeOnTile, rotationOnTile);
               } else {
                  worldmapShapeAndRotations[posHash] = 0;
               }
            } else if (shapeOnTile != 0 && shapeOnTile != 12) {
               worldmapShapeAndRotations[posHash] = findByteForShapeRotation(shapeOnTile, rotationOnTile);
            } else {
               worldmapShapeAndRotations[posHash] = 0;
            }
         }

         int[][] objs = RSMapperClient.editor
            .objectEditor
            .getObjectsOnTile(
               new WorldTile(
                  regionXWorldCoordinate + tileOnX,
                  regionYWorldCoordinate + tileOnY,
                  (RSMapperClient.editor.mapEditor.flags[1][localX][localY] & 8) == 8 ? plane - 1 : plane,
                  false
               ),
               false
            );
         int count = 0;

         for(int[] obj : objs) {
            if (obj[0] > 0) {
               ++count;
            }
         }

         if (count == 1) {
            for(int[] obj : objs) {
               if (obj[0] > 0) {
                  worldmapObjectIds[posHash >= 0 ? posHash : 0] = obj[0] + 1;
                  worldmapObjectOrientations[posHash >= 0 ? posHash : 0] = findByteForShapeRotation(obj[1], obj[2]);
                  break;
               }
            }
         } else if (count > 1) {
            worldmapObjectIds[posHash >= 0 ? posHash : 0] = -1;
            int[] ses = new int[count];
            byte[] bs = new byte[count];
            int index = 0;

            for(int[] obj : objs) {
               if (obj[0] > 0) {
                  ses[index] = obj[0];
                  bs[index] = findByteForShapeRotation(obj[1], obj[2]);
                  ++index;
               }
            }

            aHashTable347.put((long)(tileOnX << 16 | tileOnY), new Node_Sub17(ses, bs), -123);
         }
      } else {
         int mask = buffer.readUnsignedByte();
         if ((mask & 1) == 0) {
            boolean setUnderlay = (mask & 2) == 0;
            int textureId = mask >> 2 & 63;
            if (textureId != 62) {
               if (textureId == 63) {
                  textureId = buffer.readUnsignedByte();
               } else if (setUnderlay) {
                  textureId = underlayPalette[textureId];
               } else {
                  textureId = overlayPalette[textureId];
               }

               if (setUnderlay) {
                  worldmapUnderlays[posHash] = (byte)textureId;
                  worldmapOverlays[posHash] = 0;
               } else {
                  worldmapOverlays[posHash] = (byte)textureId;
                  worldmapShapeAndRotations[posHash] = 0;
                  worldmapUnderlays[posHash] = buffer.readByte();
               }
            }
         } else {
            int numIterations = (mask >> 1 & 3) + 1;
            boolean setOverlay = (mask & 8) != 0;
            boolean hasObjects = (mask & 16) != 0;

            for(int iteration = 0; iteration < numIterations; ++iteration) {
               int underlay = buffer.readUnsignedByte();
               int overlay = 0;
               int shapeRotationHash = 0;
               if (setOverlay) {
                  overlay = buffer.readUnsignedByte();
                  shapeRotationHash = buffer.readUnsignedByte();
               }

               int numObjects = 0;
               if (hasObjects) {
                  numObjects = buffer.readUnsignedByte();
               }

               if (iteration == 0) {
                  if (posHash >= 0) {
                     worldmapUnderlays[posHash] = (byte)underlay;
                     worldmapOverlays[posHash] = (byte)overlay;
                     worldmapShapeAndRotations[posHash] = (byte)shapeRotationHash;
                  }

                  if (numObjects == 1) {
                     int objectId = buffer.readUnsignedShort() + 1;
                     byte typeRotation = buffer.readByte();
                     worldmapObjectIds[posHash >= 0 ? posHash : 0] = objectId;
                     worldmapObjectOrientations[posHash >= 0 ? posHash : 0] = typeRotation;
                  } else if (numObjects > 1) {
                     worldmapObjectIds[posHash >= 0 ? posHash : 0] = -1;
                     int[] ses = new int[numObjects];
                     byte[] bs = new byte[numObjects];

                     for(int i_167_ = 0; i_167_ < numObjects; ++i_167_) {
                        ses[i_167_] = buffer.readUnsignedShort();
                        bs[i_167_] = buffer.readByte();
                     }

                     aHashTable347.put((long)(tileOnX << 16 | tileOnY), new Node_Sub17(ses, bs), -123);
                  }
               } else {
                  int[] ses = null;
                  byte[] bs = null;
                  if (numObjects > 0) {
                     ses = new int[numObjects];
                     bs = new byte[numObjects];

                     for(int i_168_ = 0; i_168_ < numObjects; ++i_168_) {
                        ses[i_168_] = buffer.readUnsignedShort();
                        bs[i_168_] = buffer.readByte();
                     }
                  }

                  if (iteration - 1 >= 0 && regionLocalX - (regionXWorldCoordinate >> 6) >= 0 && regionLocalY - (regionYWorldCoordinate >> 6) >= 0) {
                     if (aClass103ArrayArrayArray353[iteration - 1][regionLocalX - (regionXWorldCoordinate >> 6)][regionLocalY - (regionYWorldCoordinate >> 6)]
                        == null) {
                        aClass103ArrayArrayArray353[iteration - 1][regionLocalX - (regionXWorldCoordinate >> 6)][regionLocalY - (regionYWorldCoordinate >> 6)] = new Class103(
                           
                        );
                     }

                     EntityNode_Sub9 entitynode_sub9 = new EntityNode_Sub9(tileOnX & 63, tileOnY & 63, underlay, overlay, shapeRotationHash, ses, bs);
                     aClass103ArrayArrayArray353[iteration - 1][regionLocalX - (regionXWorldCoordinate >> 6)][regionLocalY - (regionYWorldCoordinate >> 6)]
                        .method1110(false, entitynode_sub9);
                  }
               }
            }
         }
      }
   }

   static final void readEmptyWorldMapTerrain(Buffer buffer) {
      int i_158_ = buffer.readUnsignedByte();
      if ((i_158_ & 1) == 0) {
         boolean bool = (i_158_ & 2) == 0;
         int i_159_ = i_158_ >> 2 & 63;
         if (i_159_ != 62) {
            if (i_159_ == 63) {
               i_159_ = buffer.readUnsignedByte();
            }

            if (!bool) {
               buffer.readByte();
            }
         }
      } else {
         int i_160_ = (i_158_ >> 1 & 3) + 1;
         boolean bool = (i_158_ & 8) != 0;
         boolean bool_161_ = (i_158_ & 16) != 0;

         for(int i_162_ = 0; i_162_ < i_160_; ++i_162_) {
            buffer.readUnsignedByte();
            if (bool) {
               buffer.readUnsignedByte();
               buffer.readUnsignedByte();
            }

            int i_166_ = 0;
            if (bool_161_) {
               i_166_ = buffer.readUnsignedByte();
            }

            if (i_162_ == 0) {
               if (i_166_ == 1) {
                  buffer.readUnsignedShort();
                  buffer.readByte();
               } else if (i_166_ > 1) {
                  for(int i_167_ = 0; i_167_ < i_166_; ++i_167_) {
                     buffer.readUnsignedShort();
                     buffer.readByte();
                  }
               }
            } else if (i_166_ > 0) {
               for(int i_168_ = 0; i_168_ < i_166_; ++i_168_) {
                  buffer.readUnsignedShort();
                  buffer.readByte();
               }
            }
         }
      }
   }

   private static final void method285() {
      for(int i = 0; i < totalXTiles; ++i) {
         for(int i_169_ = 0; i_169_ < totalYTiles; ++i_169_) {
            int i_170_ = worldmapObjectIds[i + i_169_ * totalXTiles] & 65535;
            if (i_170_ != 0) {
               if (i_170_ == 65535) {
                  Node_Sub17 node_sub17 = (Node_Sub17)aHashTable347.get(3512, (long)(i << 16 | i_169_));
                  if (node_sub17 != null) {
                     for(int i_171_ = 0; i_171_ < node_sub17.aShortArray7148.length; ++i_171_) {
                        ObjectDefinition objectdefinition = aClass112_319.getObjectDefinitionsForId(node_sub17.aShortArray7148[i_171_] & 65535, 115);
                        int i_172_ = objectdefinition.mapAreaId;
                        if (objectdefinition.anIntArray2984 != null) {
                           objectdefinition = objectdefinition.method3038(13, anInterface17_317);
                           if (objectdefinition != null) {
                              i_172_ = objectdefinition.mapAreaId;
                           }
                        }

                        if (i_172_ != -1) {
                           Node_Sub14 node_sub14 = new Node_Sub14(i_172_);
                           node_sub14.anInt7125 = i;
                           node_sub14.anInt7120 = i_169_;
                           aClass312_331.method3625((byte)-54, node_sub14);
                        }
                     }
                  }
               } else {
                  ObjectDefinition objectdefinition = aClass112_319.getObjectDefinitionsForId(i_170_ - 1, 115);
                  int i_173_ = objectdefinition.mapAreaId;
                  if (objectdefinition.anIntArray2984 != null) {
                     objectdefinition = objectdefinition.method3038(13, anInterface17_317);
                     if (objectdefinition != null) {
                        i_173_ = objectdefinition.mapAreaId;
                     }
                  }

                  if (i_173_ != -1) {
                     Node_Sub14 node_sub14 = new Node_Sub14(i_173_);
                     node_sub14.anInt7125 = i;
                     node_sub14.anInt7120 = i_169_;
                     aClass312_331.method3625((byte)-54, node_sub14);
                  }
               }
            }
         }
      }

      for(int i = 0; i < 3; ++i) {
         for(int i_174_ = 0; i_174_ < aClass103ArrayArrayArray353[0].length; ++i_174_) {
            for(int i_175_ = 0; i_175_ < aClass103ArrayArrayArray353[0][0].length; ++i_175_) {
               Class103 class103 = aClass103ArrayArrayArray353[i][i_174_][i_175_];
               if (class103 != null) {
                  for(EntityNode_Sub9 entitynode_sub9 = (EntityNode_Sub9)class103.method1113((byte)-44);
                     entitynode_sub9 != null;
                     entitynode_sub9 = (EntityNode_Sub9)class103.method1108(124)
                  ) {
                     if (entitynode_sub9.aShortArray6025 != null) {
                        for(int i_176_ = 0; i_176_ < entitynode_sub9.aShortArray6025.length; ++i_176_) {
                           ObjectDefinition objectdefinition = aClass112_319.getObjectDefinitionsForId(entitynode_sub9.aShortArray6025[i_176_] & 65535, 126);
                           int i_177_ = objectdefinition.mapAreaId;
                           if (objectdefinition.anIntArray2984 != null) {
                              objectdefinition = objectdefinition.method3038(13, anInterface17_317);
                              if (objectdefinition != null) {
                                 i_177_ = objectdefinition.mapAreaId;
                              }
                           }

                           if (i_177_ != -1) {
                              Node_Sub14 node_sub14 = new Node_Sub14(i_177_);
                              node_sub14.anInt7125 = (i_174_ + (regionXWorldCoordinate >> 6)) * 64 + entitynode_sub9.aByte6029 - regionXWorldCoordinate;
                              node_sub14.anInt7120 = (i_175_ + (regionYWorldCoordinate >> 6)) * 64 + entitynode_sub9.aByte6031 - regionYWorldCoordinate;
                              aClass312_331.method3625((byte)-54, node_sub14);
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   static final Class158 method286(int i, int i_178_) {
      Class158 class158 = new Class158();

      for(WorldmapAreaDetail cachenode_sub11 = (WorldmapAreaDetail)aHashTable316.method1516(false);
         cachenode_sub11 != null;
         cachenode_sub11 = (WorldmapAreaDetail)aHashTable316.method1520(101)
      ) {
         if (cachenode_sub11.canOpenMapLinks && cachenode_sub11.method2335((byte)88, i, i_178_)) {
            class158.method1719(true, cachenode_sub11);
         }
      }

      return class158;
   }

   public static void method287() {
      aClass71_320 = null;
      aClass58_321 = null;
      aClass112_319 = null;
      aClass215_322 = null;
      aClass338_315 = null;
      anInterface17_317 = null;
      currentWorldmapArea = null;
      aClass302_314 = null;
      aHashTable316 = null;
      aByteArrayArrayArray332 = null;
      aShortArray326 = null;
      aByteArray325 = null;
      aClass224_330 = null;
      aClass312_331 = null;
      overlayColors = null;
      worldmapUnderlays = null;
      aByteArray335 = null;
      aShortArray338 = null;
      worldmapOverlays = null;
      worldmapShapeAndRotations = null;
      worldmapObjectIds = null;
      worldmapObjectOrientations = null;
      aHashTable347 = null;
      aClass103ArrayArrayArray353 = null;
   }

   static final WorldmapAreaDetail method288(int i, int i_179_) {
      for(WorldmapAreaDetail cachenode_sub11 = (WorldmapAreaDetail)aHashTable316.method1516(false);
         cachenode_sub11 != null;
         cachenode_sub11 = (WorldmapAreaDetail)aHashTable316.method1520(115)
      ) {
         if (cachenode_sub11.canOpenMapLinks && cachenode_sub11.method2335((byte)119, i, i_179_)) {
            return cachenode_sub11;
         }
      }

      return null;
   }

   static final void method289() {
      int[] is = new int[3];

      for(int i = 0; i < aClass224_330.anInt2670; ++i) {
         boolean bool = currentWorldmapArea.method2337(
            -12584, is, aClass224_330.anIntArray2668[i] & 16383, aClass224_330.anIntArray2668[i] >> 28 & 3, aClass224_330.anIntArray2668[i] >> 14 & 16383
         );
         if (bool) {
            Node_Sub14 node_sub14 = new Node_Sub14(aClass224_330.anIntArray2669[i]);
            node_sub14.anInt7125 = is[1] - regionXWorldCoordinate;
            node_sub14.anInt7120 = is[2] - regionYWorldCoordinate;
            aClass312_331.method3625((byte)-54, node_sub14);
         }
      }
   }

   static final void loadWorldMapArea(GraphicsToolkit graphicstoolkit, int i, int i_180_) {
      Buffer buffer = new Buffer(aClass302_314.method3529(currentWorldmapArea.archivename, "area", 1));
      int underlayPaletteSize = buffer.readUnsignedByte();
      int[] underlayPalette = new int[underlayPaletteSize];

      for(int i_182_ = 0; i_182_ < underlayPaletteSize; ++i_182_) {
         underlayPalette[i_182_] = buffer.readUnsignedByte();
      }

      int overlayPaletteSize = buffer.readUnsignedByte();
      System.out.println("WM (" + currentWorldmapArea.archivename + "): " + underlayPaletteSize + " - " + overlayPaletteSize);
      int[] overlayPalette = new int[overlayPaletteSize];

      for(int i_185_ = 0; i_185_ < overlayPaletteSize; ++i_185_) {
         overlayPalette[i_185_] = buffer.readUnsignedByte();
      }

      Class24.aClass275_442.setVarpBit(6174, 1);
      String archivename = (String)RSMapperClient.editor.worldmapEditor.getDetailsAttribute("archivename");
      System.out.println("CURRENT: " + archivename);

      while(buffer.offset < buffer.buffer.length) {
         if (buffer.readUnsignedByte() == 0) {
            int regionLocalX = buffer.readUnsignedByte();
            int regionLocalY = buffer.readUnsignedByte();

            for(int localX = 0; localX < 64; ++localX) {
               for(int localY = 0; localY < 64; ++localY) {
                  int xWorldCoordinate = regionLocalX * 64 + localX;
                  int yWorldCoordinate = regionLocalY * 64 + localY;
                  int tileOnX = xWorldCoordinate - regionXWorldCoordinate;
                  int tileOnY = yWorldCoordinate - regionYWorldCoordinate;
                  decodeWorldMapTerrain(buffer, regionLocalX, regionLocalY, tileOnX, tileOnY, underlayPalette, overlayPalette);
               }
            }
         } else {
            int regionLocalX = buffer.readUnsignedByte();
            int regionLocalY = buffer.readUnsignedByte();
            int sizeX = buffer.readUnsignedByte();
            int sizeY = buffer.readUnsignedByte();

            for(int xInChunk = 0; xInChunk < 8; ++xInChunk) {
               for(int yInChunk = 0; yInChunk < 8; ++yInChunk) {
                  int tileOnX = regionLocalX * 64 + sizeX * 8 + xInChunk - regionXWorldCoordinate;
                  int tileOnY = regionLocalY * 64 + sizeY * 8 + yInChunk - regionYWorldCoordinate;
                  decodeWorldMapTerrain(buffer, regionLocalX, regionLocalY, tileOnX, tileOnY, underlayPalette, overlayPalette);
               }
            }
         }
      }

      Object object = null;
      aByteArray335 = new byte[totalXTiles * totalYTiles];
      aShortArray338 = new short[totalXTiles * totalYTiles];

      for(int i_200_ = 0; i_200_ < 3; ++i_200_) {
         byte[] bs = new byte[totalXTiles * totalYTiles];

         for(int i_201_ = 0; i_201_ < aClass103ArrayArrayArray353[i_200_].length; ++i_201_) {
            for(int i_202_ = 0; i_202_ < aClass103ArrayArrayArray353[i_200_][0].length; ++i_202_) {
               Class103 class103 = aClass103ArrayArrayArray353[i_200_][i_201_][i_202_];
               if (class103 != null) {
                  for(EntityNode_Sub9 entitynode_sub9 = (EntityNode_Sub9)class103.method1113((byte)98);
                     entitynode_sub9 != null;
                     entitynode_sub9 = (EntityNode_Sub9)class103.method1108(117)
                  ) {
                     bs[i_201_ * 64 + entitynode_sub9.aByte6029 + (i_202_ * 64 + entitynode_sub9.aByte6031) * totalXTiles] = (byte)entitynode_sub9.anInt6027;
                  }
               }
            }
         }

         method274(bs, aByteArray335, aShortArray338, i, i_180_);

         for(int i_203_ = 0; i_203_ < aClass103ArrayArrayArray353[i_200_].length; ++i_203_) {
            for(int i_204_ = 0; i_204_ < aClass103ArrayArrayArray353[i_200_][0].length; ++i_204_) {
               Class103 class103 = aClass103ArrayArrayArray353[i_200_][i_203_][i_204_];
               if (class103 != null) {
                  for(EntityNode_Sub9 entitynode_sub9 = (EntityNode_Sub9)class103.method1113((byte)124);
                     entitynode_sub9 != null;
                     entitynode_sub9 = (EntityNode_Sub9)class103.method1108(109)
                  ) {
                     int i_205_ = i_203_ * 64 + entitynode_sub9.aByte6029 + (i_204_ * 64 + entitynode_sub9.aByte6031) * totalXTiles;
                     entitynode_sub9.anInt6027 = (aByteArray335[i_205_] & 255) << 16 | aShortArray338[i_205_] & '\uffff';
                     if (entitynode_sub9.anInt6027 != 0) {
                        entitynode_sub9.anInt6027 |= -16777216;
                     }
                  }
               }
            }
         }
      }

      method274(worldmapUnderlays, aByteArray335, aShortArray338, i, i_180_);
      method285();
   }

   static final Class312 method291(GraphicsToolkit graphicstoolkit) {
      int i = maxWidth - baseX;
      int i_206_ = maxHeight - baseY;
      int i_207_ = (anInt348 - anInt344 << 16) / i;
      int i_208_ = (anInt339 - anInt350 << 16) / i_206_;
      return method292(graphicstoolkit, i_207_, i_208_, 0, 0);
   }

   private static final Class312 method292(GraphicsToolkit graphicstoolkit, int i, int i_209_, int i_210_, int i_211_) {
      for(Node_Sub14 node_sub14 = (Node_Sub14)aClass312_331.method3613(65280); node_sub14 != null; node_sub14 = (Node_Sub14)aClass312_331.method3620(16776960)) {
         method283(graphicstoolkit, node_sub14, i, i_209_, i_210_, i_211_);
      }

      return aClass312_331;
   }
}
