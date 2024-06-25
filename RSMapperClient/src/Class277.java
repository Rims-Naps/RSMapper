class Class277 {
   static CacheNode_Sub13 aCacheNode_Sub13_3509;
   private Class58 aClass58_3536;
   private Class71 aClass71_3512;
   private int[] anIntArray3513 = new int[]{0, 0, 0, 256, 512, 512, 512, 256, 256, 384, 128, 128, 256};
   private int[] anIntArray3522 = new int[]{0, 256, 512, 512, 512, 256, 0, 0, 128, 256, 128, 384, 256};
   static int anInt3510;
   static int anInt3511;
   static int anInt3514;
   static int anInt3515;
   static int anInt3517;
   static int anInt3519;
   static int anInt3523;
   static int anInt3529;
   static int anInt3531;
   static int anInt3532;
   static int anInt3533;
   static int anInt3534;
   boolean undermap;
   static int regionY;
   int mapSizeX;
   int mapSizeY;
   int maxPlanes;
   static byte[][][] tileFlags;
   int[][][] tileHeights;
   byte[][][] tileOverlays;
   byte[][][] tileUnderlays;
   byte[][][] tileShapes;
   byte[][][] tileRotations;
   byte[][][] aByteArrayArrayArray3518;

   final void loadHeightMap(Buffer buffer, int localY, Class84[] class84s, int gameSceneY, int archiveId, int gameSceneX, int localX) {
      if (!this.undermap) {
         for(int plane = 0; plane < 4; ++plane) {
            Class84 class84 = class84s[plane];

            for(int x = 0; x < 64; ++x) {
               for(int y = 0; y < 64; ++y) {
                  int i_6_ = x + localX;
                  int i_7_ = y + localY;
                  if (i_6_ >= 0 && this.mapSizeX > i_6_ && i_7_ >= 0 && i_7_ < this.mapSizeY) {
                     class84.setClipMask(i_7_, i_6_, -121);
                  }
               }
            }
         }
      }

      ++anInt3534;
      int coordX = localX + gameSceneX;
      int coordY = gameSceneY + localY;

      for(int plane = 0; plane < this.maxPlanes; ++plane) {
         for(int x = 0; x < 64; ++x) {
            for(int y = 0; y < 64; ++y) {
               this.decodeMapDefinitions(0, localY + y, 0, x + localX, coordX + x, buffer, 0, y + coordY, plane, false, archiveId);
            }
         }
      }
   }

   final void method3338(int i_13_, int i_14_, int i_15_, int i_16_) {
      for(int i_17_ = 0; ~i_17_ > ~this.maxPlanes; ++i_17_) {
         this.method3347(-13972, i_13_, i_16_, i_14_, i_17_, i_15_);
      }

      ++anInt3532;
   }

   final void method3339(int i, int[][][] is, GraphicsToolkit graphicstoolkit, Class84[] class84s) {
      if (!this.undermap) {
         for(int i_18_ = 0; ~i_18_ > -5; ++i_18_) {
            for(int i_19_ = 0; ~i_19_ > ~this.mapSizeX; ++i_19_) {
               for(int i_20_ = 0; ~i_20_ > ~this.mapSizeY; ++i_20_) {
                  if ((1 & tileFlags[i_18_][i_19_][i_20_]) != 0) {
                     int i_21_ = i_18_;
                     if ((2 & tileFlags[1][i_19_][i_20_]) != 0) {
                        i_21_ = i_18_ - 1;
                     }

                     if (i_21_ >= 0) {
                        class84s[i_21_].method990(i_20_, i_19_, -17078);
                     }
                  }
               }
            }
         }
      }

      ++anInt3519;
      if (i == -2) {
         for(int i_22_ = 0; ~this.maxPlanes < ~i_22_; ++i_22_) {
            int i_23_ = 0;
            int i_24_ = 0;
            if (!this.undermap) {
               if (Class34.aBoolean532) {
                  i_24_ |= 8;
               }

               if (Class163.aBoolean2015) {
                  i_23_ |= 2;
               }

               if (Class237.anInt2906 != 0) {
                  i_23_ |= 1;
                  if (~i_22_ == -1 | Class339_Sub6.aBoolean8715) {
                     i_24_ |= 16;
                  }
               }
            }

            if (Class163.aBoolean2015) {
               i_24_ |= 7;
            }

            if (!Class169_Sub2_Sub1.aBoolean10563) {
               i_24_ |= 32;
            }

            int[][] is_25_ = is != null && i_22_ < is.length ? is[i_22_] : this.tileHeights[i_22_];
            Class232.method2141(i_22_, graphicstoolkit.a(this.mapSizeX, this.mapSizeY, this.tileHeights[i_22_], is_25_, 512, i_23_, i_24_));
         }
      }
   }

   private final void method3340(int i, byte b, GraphicsToolkit graphicstoolkit, int[][] is, Plane plane, Plane plane_26_, Plane plane_27_) {
      for(int i_28_ = 0; ~this.mapSizeX < ~i_28_; ++i_28_) {
         for(int i_29_ = 0; i_29_ < this.mapSizeY; ++i_29_) {
            if (Class256.anInt3237 == -1 || Class369.method4085(i_29_, 0, Class256.anInt3237, i_28_, i)) {
               byte b_30_ = RSMapperClient.MAP_LOADED
                  ? (this.undermap ? RSMapperClient.editor.mapEditor.um_shapes[i][i_28_][i_29_] : RSMapperClient.editor.mapEditor.shapes[i][i_28_][i_29_])
                  : this.tileShapes[i][i_28_][i_29_];
               byte b_31_ = RSMapperClient.MAP_LOADED
                  ? (
                     this.undermap
                        ? RSMapperClient.editor.mapEditor.um_rotations[i][i_28_][i_29_]
                        : RSMapperClient.editor.mapEditor.rotations[i][i_28_][i_29_]
                  )
                  : this.tileRotations[i][i_28_][i_29_];
               int i_32_ = (
                     RSMapperClient.MAP_LOADED
                        ? (
                           this.undermap
                              ? RSMapperClient.editor.mapEditor.um_overlays[i][i_28_][i_29_]
                              : RSMapperClient.editor.mapEditor.overlays[i][i_28_][i_29_]
                        )
                        : this.tileOverlays[i][i_28_][i_29_]
                  )
                  & 255;
               int i_33_ = (
                     RSMapperClient.MAP_LOADED
                        ? (
                           this.undermap
                              ? RSMapperClient.editor.mapEditor.um_underlays[i][i_28_][i_29_]
                              : RSMapperClient.editor.mapEditor.underlays[i][i_28_][i_29_]
                        )
                        : this.tileUnderlays[i][i_28_][i_29_]
                  )
                  & 255;
               OverlayDefinition class289 = i_32_ != 0 ? this.aClass71_3512.getOverlayDefinitions(i_32_ - 1, (byte)90) : null;
               if (b_30_ == 0 && class289 == null) {
                  b_30_ = 12;
               }

               UnderlayDefinition underlaydefs = i_33_ == 0 ? null : this.aClass58_3536.getUnderlayDefinitions(-17993, -1 + i_33_);
               if (class289 != null && ~class289.anInt3631 == 0 && ~class289.mapColor == 0) {
                  class289 = null;
               }

               if (class289 != null || underlaydefs != null) {
                  int i_35_ = Node_Sub38_Sub7.anIntArray10143[b_30_];
                  int i_36_ = ProducingGraphicsBuffer.anIntArray9881[b_30_];
                  int i_37_ = (underlaydefs == null ? 0 : i_35_) + (class289 != null ? i_36_ : 0);
                  int i_38_ = 0;
                  int i_39_ = 0;
                  int i_40_ = class289 == null ? -1 : class289.texture;
                  int i_41_ = underlaydefs != null ? underlaydefs.texture : -1;
                  int[] is_42_ = new int[i_37_];
                  int[] is_43_ = new int[i_37_];
                  int[] is_44_ = new int[i_37_];
                  int[] is_45_ = new int[i_37_];
                  int[] is_46_ = new int[i_37_];
                  int[] is_47_ = new int[i_37_];
                  int[] is_48_ = class289 != null && class289.mapColor != -1 ? new int[i_37_] : null;
                  if (class289 != null) {
                     for(int i_49_ = 0; ~i_36_ < ~i_49_; ++i_49_) {
                        is_42_[i_38_] = Class141.anIntArrayArray1755[b_30_][i_39_];
                        is_43_[i_38_] = Class262_Sub21.anIntArrayArray7868[b_30_][i_39_];
                        is_44_[i_38_] = Node_Sub43.anIntArrayArray7538[b_30_][i_39_];
                        is_46_[i_38_] = i_40_;
                        is_47_[i_38_] = class289.anInt3632;
                        is_45_[i_38_] = class289.anInt3631;
                        if (is_48_ != null) {
                           is_48_[i_38_] = class289.mapColor;
                        }

                        ++i_38_;
                        ++i_39_;
                     }

                     if (!this.undermap && i == 0) {
                        Class158.method1725(i_28_, i_29_, class289.anInt3646, 8 * class289.anInt3634, class289.anInt3641);
                     }
                  } else {
                     i_39_ += i_36_;
                  }

                  if (underlaydefs != null) {
                     for(int i_50_ = 0; i_35_ > i_50_; ++i_50_) {
                        is_42_[i_38_] = Class141.anIntArrayArray1755[b_30_][i_39_];
                        is_43_[i_38_] = Class262_Sub21.anIntArrayArray7868[b_30_][i_39_];
                        is_44_[i_38_] = Node_Sub43.anIntArrayArray7538[b_30_][i_39_];
                        is_46_[i_38_] = i_41_;
                        is_47_[i_38_] = underlaydefs.anInt2894;
                        is_45_[i_38_] = is[i_28_][i_29_];
                        if (is_48_ != null) {
                           is_48_[i_38_] = is_45_[i_38_];
                        }

                        ++i_39_;
                        ++i_38_;
                     }
                  }

                  int i_51_ = this.anIntArray3522.length;
                  int[] is_52_ = new int[i_51_];
                  int[] is_53_ = new int[i_51_];
                  int[] is_54_ = plane == null ? null : new int[i_51_];
                  int[] is_55_ = plane == null && plane_27_ == null ? null : new int[i_51_];

                  for(int i_56_ = 0; ~i_51_ < ~i_56_; ++i_56_) {
                     int i_57_ = this.anIntArray3522[i_56_];
                     int i_58_ = this.anIntArray3513[i_56_];
                     if (b_31_ != 0) {
                        if (~b_31_ != -2) {
                           if (~b_31_ == -3) {
                              is_52_[i_56_] = 512 - i_57_;
                              is_53_[i_56_] = 512 - i_58_;
                           } else if (~b_31_ == -4) {
                              is_52_[i_56_] = 512 + -i_58_;
                              is_53_[i_56_] = i_57_;
                           }
                        } else {
                           is_52_[i_56_] = i_58_;
                           is_53_[i_56_] = -i_57_ + 512;
                        }
                     } else {
                        is_52_[i_56_] = i_57_;
                        is_53_[i_56_] = i_58_;
                     }

                     if (is_54_ != null && GLPlane.aBooleanArrayArray7950[b_30_][i_56_]) {
                        int i_61_ = is_52_[i_56_] + (i_28_ << 9);
                        int i_62_ = (i_29_ << 9) + is_53_[i_56_];
                        is_54_[i_56_] = plane.getMedianHeightFromVertices(i_62_, -128, i_61_) - plane_26_.getMedianHeightFromVertices(i_62_, -127, i_61_);
                     }

                     if (is_55_ != null) {
                        if (plane != null && !GLPlane.aBooleanArrayArray7950[b_30_][i_56_]) {
                           int i_65_ = is_52_[i_56_] + (i_28_ << 9);
                           int i_66_ = (i_29_ << 9) + is_53_[i_56_];
                           is_55_[i_56_] = plane_26_.getMedianHeightFromVertices(i_66_, -128, i_65_) + -plane.getMedianHeightFromVertices(i_66_, -115, i_65_);
                        } else if (plane_27_ != null && !Node_Sub15_Sub7.aBooleanArrayArray9822[b_30_][i_56_]) {
                           int i_63_ = (i_28_ << 9) + is_52_[i_56_];
                           int i_64_ = is_53_[i_56_] + (i_29_ << 9);
                           is_55_[i_56_] = plane_27_.getMedianHeightFromVertices(i_64_, -126, i_63_)
                              + -plane_26_.getMedianHeightFromVertices(i_64_, -114, i_63_);
                        }
                     }
                  }

                  int i_72_ = 0;
                  int i_73_ = 0;
                  int i_74_ = 0;
                  if (this.undermap) {
                     i_72_ = Class320_Sub2.method3684(i_28_, i_29_);
                     i_73_ = Class184.method1844(i_28_, i_29_);
                     i_74_ = Class117_Sub2.method1172(i_28_, i_29_);
                  }

                  plane_26_.method3253(
                     i_28_, i_29_, is_52_, is_54_, is_53_, is_55_, is_42_, is_43_, is_44_, is_45_, is_48_, is_46_, is_47_, i_72_, i_73_, i_74_, false
                  );
                  Class320_Sub24.method3775(i, i_28_, i_29_);
               }
            }
         }
      }

      if (b >= -61) {
         aCacheNode_Sub13_3509 = null;
      }

      ++anInt3511;
   }

   private final void method3341(
      int shape,
      OverlayDefinition overlay,
      byte[][] bs,
      int i_75_,
      int i_76_,
      int i_77_,
      int i_78_,
      int i_79_,
      GraphicsToolkit graphicstoolkit,
      int i_80_,
      boolean[] bools,
      UnderlayDefinition underlay,
      byte[][] bs_81_,
      byte[][] bs_82_
   ) {
      ++anInt3533;
      boolean[] bools_83_ = overlay != null && overlay.blend ? Class250.aBooleanArrayArray3168[shape] : Node_Sub33.aBooleanArrayArray7406[shape];
      if (i_80_ > 0) {
         if (i_77_ > 0) {
            int i_84_ = 255 & bs_82_[i_77_ + -1][i_80_ - 1];
            if (~i_84_ < -1) {
               OverlayDefinition class289_85_ = this.aClass71_3512.getOverlayDefinitions(i_84_ + -1, (byte)38);
               if (~class289_85_.anInt3631 != 0 && class289_85_.blend) {
                  byte b = bs_81_[i_77_ + -1][-1 + i_80_];
                  int i_86_ = bs[-1 + i_77_][i_80_ + -1] * 2 + 4 & 7;
                  int i_87_ = Class382.method4179(class289_85_, (byte)-125, graphicstoolkit);
                  if (GLPlane.aBooleanArrayArray7950[b][i_86_]) {
                     Class188_Sub1_Sub1.anIntArray9339[0] = class289_85_.anInt3631;
                     Class262_Sub10.anIntArray7773[0] = i_87_;
                     Class84.anIntArray1136[0] = class289_85_.texture;
                     Class385.anIntArray4914[0] = class289_85_.anInt3632;
                     Class327.anIntArray5348[0] = class289_85_.anInt3633;
                     Class136.anIntArray1695[0] = 256;
                  }
               }
            }
         }

         if (-1 + i_75_ > i_77_) {
            int i_88_ = 255 & bs_82_[1 + i_77_][i_80_ - 1];
            if (~i_88_ < -1) {
               OverlayDefinition class289_89_ = this.aClass71_3512.getOverlayDefinitions(i_88_ - 1, (byte)49);
               if (~class289_89_.anInt3631 != 0 && class289_89_.blend) {
                  byte b = bs_81_[1 + i_77_][-1 + i_80_];
                  int i_90_ = 7 & 2 * bs[1 + i_77_][i_80_ - 1] + 6;
                  int i_91_ = Class382.method4179(class289_89_, (byte)-120, graphicstoolkit);
                  if (GLPlane.aBooleanArrayArray7950[b][i_90_]) {
                     Class188_Sub1_Sub1.anIntArray9339[2] = class289_89_.anInt3631;
                     Class262_Sub10.anIntArray7773[2] = i_91_;
                     Class84.anIntArray1136[2] = class289_89_.texture;
                     Class385.anIntArray4914[2] = class289_89_.anInt3632;
                     Class327.anIntArray5348[2] = class289_89_.anInt3633;
                     Class136.anIntArray1695[2] = 512;
                  }
               }
            }
         }
      }

      if (~(i_79_ - 1) < ~i_80_) {
         if (~i_77_ < -1) {
            int i_92_ = bs_82_[-1 + i_77_][i_80_ - -1] & 255;
            if (i_92_ > 0) {
               OverlayDefinition class289_93_ = this.aClass71_3512.getOverlayDefinitions(-1 + i_92_, (byte)66);
               if (class289_93_.anInt3631 != -1 && class289_93_.blend) {
                  byte b = bs_81_[i_77_ - 1][1 + i_80_];
                  int i_94_ = 7 & 2 * bs[i_77_ + -1][1 + i_80_] + 2;
                  int i_95_ = Class382.method4179(class289_93_, (byte)-15, graphicstoolkit);
                  if (GLPlane.aBooleanArrayArray7950[b][i_94_]) {
                     Class188_Sub1_Sub1.anIntArray9339[6] = class289_93_.anInt3631;
                     Class262_Sub10.anIntArray7773[6] = i_95_;
                     Class84.anIntArray1136[6] = class289_93_.texture;
                     Class385.anIntArray4914[6] = class289_93_.anInt3632;
                     Class327.anIntArray5348[6] = class289_93_.anInt3633;
                     Class136.anIntArray1695[6] = 64;
                  }
               }
            }
         }

         if (~(-1 + i_75_) < ~i_77_) {
            int i_96_ = 255 & bs_82_[1 + i_77_][1 + i_80_];
            if (i_96_ > 0) {
               OverlayDefinition class289_97_ = this.aClass71_3512.getOverlayDefinitions(-1 + i_96_, (byte)113);
               if (class289_97_.anInt3631 != -1 && class289_97_.blend) {
                  byte b = bs_81_[1 + i_77_][1 + i_80_];
                  int i_98_ = -(-(2 * bs[1 + i_77_][1 + i_80_])) & 7;
                  int i_99_ = Class382.method4179(class289_97_, (byte)-128, graphicstoolkit);
                  if (GLPlane.aBooleanArrayArray7950[b][i_98_]) {
                     Class188_Sub1_Sub1.anIntArray9339[4] = class289_97_.anInt3631;
                     Class262_Sub10.anIntArray7773[4] = i_99_;
                     Class84.anIntArray1136[4] = class289_97_.texture;
                     Class385.anIntArray4914[4] = class289_97_.anInt3632;
                     Class327.anIntArray5348[4] = class289_97_.anInt3633;
                     Class136.anIntArray1695[4] = 128;
                  }
               }
            }
         }
      }

      if (i_80_ > 0) {
         int i_100_ = 255 & bs_82_[i_77_][i_80_ - 1];
         if (i_100_ > 0) {
            OverlayDefinition class289_101_ = this.aClass71_3512.getOverlayDefinitions(-1 + i_100_, (byte)40);
            if (~class289_101_.anInt3631 != 0) {
               byte b = bs_81_[i_77_][-1 + i_80_];
               int i_102_ = bs[i_77_][-1 + i_80_];
               if (class289_101_.blend) {
                  int i_103_ = 2;
                  int i_104_ = i_102_ * 2 + 4;
                  int i_105_ = Class382.method4179(class289_101_, (byte)-123, graphicstoolkit);

                  for(int i_106_ = 0; ~i_106_ > -4; ++i_106_) {
                     i_103_ &= 7;
                     i_104_ &= 7;
                     if (GLPlane.aBooleanArrayArray7950[b][i_104_] && ~class289_101_.anInt3633 <= ~Class327.anIntArray5348[i_103_]) {
                        Class188_Sub1_Sub1.anIntArray9339[i_103_] = class289_101_.anInt3631;
                        Class262_Sub10.anIntArray7773[i_103_] = i_105_;
                        Class84.anIntArray1136[i_103_] = class289_101_.texture;
                        Class385.anIntArray4914[i_103_] = class289_101_.anInt3632;
                        if (~Class327.anIntArray5348[i_103_] != ~class289_101_.anInt3633) {
                           Class136.anIntArray1695[i_103_] = 32;
                        } else {
                           Class136.anIntArray1695[i_103_] = Node_Sub16.method2590(Class136.anIntArray1695[i_103_], 32);
                        }

                        Class327.anIntArray5348[i_103_] = class289_101_.anInt3633;
                     }

                     --i_103_;
                     ++i_104_;
                  }

                  if (!bools_83_[i_78_ & 3]) {
                     bools[0] = Class250.aBooleanArrayArray3168[b][Node_Sub30.method2723(3, 2 - -i_102_)];
                  }
               } else if (!bools_83_[3 & i_78_]) {
                  bools[0] = Node_Sub33.aBooleanArrayArray7406[b][Node_Sub30.method2723(2 - -i_102_, 3)];
               }
            }
         }
      }

      if (~(-1 + i_79_) < ~i_80_) {
         int i_107_ = 255 & bs_82_[i_77_][i_80_ + 1];
         if (i_107_ > 0) {
            OverlayDefinition class289_108_ = this.aClass71_3512.getOverlayDefinitions(-1 + i_107_, (byte)48);
            if (class289_108_.anInt3631 != -1) {
               byte b = bs_81_[i_77_][i_80_ + 1];
               int i_109_ = bs[i_77_][1 + i_80_];
               if (class289_108_.blend) {
                  int i_110_ = 4;
                  int i_111_ = 2 + i_109_ * 2;
                  int i_112_ = Class382.method4179(class289_108_, (byte)16, graphicstoolkit);

                  for(int i_113_ = 0; i_113_ < 3; ++i_113_) {
                     i_110_ &= 7;
                     i_111_ &= 7;
                     if (GLPlane.aBooleanArrayArray7950[b][i_111_] && Class327.anIntArray5348[i_110_] <= class289_108_.anInt3633) {
                        Class188_Sub1_Sub1.anIntArray9339[i_110_] = class289_108_.anInt3631;
                        Class262_Sub10.anIntArray7773[i_110_] = i_112_;
                        Class84.anIntArray1136[i_110_] = class289_108_.texture;
                        Class385.anIntArray4914[i_110_] = class289_108_.anInt3632;
                        if (~Class327.anIntArray5348[i_110_] != ~class289_108_.anInt3633) {
                           Class136.anIntArray1695[i_110_] = 16;
                        } else {
                           Class136.anIntArray1695[i_110_] = Node_Sub16.method2590(Class136.anIntArray1695[i_110_], 16);
                        }

                        Class327.anIntArray5348[i_110_] = class289_108_.anInt3633;
                     }

                     ++i_110_;
                     --i_111_;
                  }

                  if (!bools_83_[i_78_ + 2 & 3]) {
                     bools[2] = Class250.aBooleanArrayArray3168[b][Node_Sub30.method2723(3, --i_109_)];
                  }
               } else if (!bools_83_[2 + i_78_ & 3]) {
                  bools[2] = Node_Sub33.aBooleanArrayArray7406[b][Node_Sub30.method2723(i_109_, 3)];
               }
            }
         }
      }

      if (~i_77_ < -1) {
         int i_114_ = 255 & bs_82_[-1 + i_77_][i_80_];
         if (~i_114_ < -1) {
            OverlayDefinition class289_115_ = this.aClass71_3512.getOverlayDefinitions(-1 + i_114_, (byte)125);
            if (class289_115_.anInt3631 != -1) {
               byte b = bs_81_[i_77_ - 1][i_80_];
               int i_116_ = bs[i_77_ - 1][i_80_];
               if (class289_115_.blend) {
                  int i_117_ = 6;
                  int i_118_ = 2 * i_116_ + 4;
                  int i_119_ = Class382.method4179(class289_115_, (byte)-125, graphicstoolkit);

                  for(int i_120_ = 0; ~i_120_ > -4; ++i_120_) {
                     i_117_ &= 7;
                     i_118_ &= 7;
                     if (GLPlane.aBooleanArrayArray7950[b][i_118_] && Class327.anIntArray5348[i_117_] <= class289_115_.anInt3633) {
                        Class188_Sub1_Sub1.anIntArray9339[i_117_] = class289_115_.anInt3631;
                        Class262_Sub10.anIntArray7773[i_117_] = i_119_;
                        Class84.anIntArray1136[i_117_] = class289_115_.texture;
                        Class385.anIntArray4914[i_117_] = class289_115_.anInt3632;
                        if (~class289_115_.anInt3633 == ~Class327.anIntArray5348[i_117_]) {
                           Class136.anIntArray1695[i_117_] = Node_Sub16.method2590(Class136.anIntArray1695[i_117_], 8);
                        } else {
                           Class136.anIntArray1695[i_117_] = 8;
                        }

                        Class327.anIntArray5348[i_117_] = class289_115_.anInt3633;
                     }

                     ++i_117_;
                     --i_118_;
                  }

                  if (!bools_83_[3 & i_78_ + 3]) {
                     bools[3] = Class250.aBooleanArrayArray3168[b][Node_Sub30.method2723(1 + i_116_, 3)];
                  }
               } else if (!bools_83_[3 + i_78_ & 3]) {
                  bools[3] = Node_Sub33.aBooleanArrayArray7406[b][Node_Sub30.method2723(3, i_116_ + 1)];
               }
            }
         }
      }

      if (i_76_ != 8) {
         this.method3346((byte)-102, null, null, null);
      }

      if (i_77_ < i_75_ + -1) {
         int i_121_ = bs_82_[1 + i_77_][i_80_] & 255;
         if (~i_121_ < -1) {
            OverlayDefinition class289_122_ = this.aClass71_3512.getOverlayDefinitions(-1 + i_121_, (byte)43);
            if (~class289_122_.anInt3631 != 0) {
               byte b = bs_81_[i_77_ + 1][i_80_];
               int i_123_ = bs[1 + i_77_][i_80_];
               if (class289_122_.blend) {
                  int i_124_ = 4;
                  int i_125_ = 2 * i_123_ + 6;
                  int i_126_ = Class382.method4179(class289_122_, (byte)-126, graphicstoolkit);

                  for(int i_127_ = 0; i_127_ < 3; ++i_127_) {
                     i_125_ &= 7;
                     i_124_ &= 7;
                     if (GLPlane.aBooleanArrayArray7950[b][i_125_] && ~class289_122_.anInt3633 <= ~Class327.anIntArray5348[i_124_]) {
                        Class188_Sub1_Sub1.anIntArray9339[i_124_] = class289_122_.anInt3631;
                        Class262_Sub10.anIntArray7773[i_124_] = i_126_;
                        Class84.anIntArray1136[i_124_] = class289_122_.texture;
                        Class385.anIntArray4914[i_124_] = class289_122_.anInt3632;
                        if (Class327.anIntArray5348[i_124_] != class289_122_.anInt3633) {
                           Class136.anIntArray1695[i_124_] = 4;
                        } else {
                           Class136.anIntArray1695[i_124_] = Node_Sub16.method2590(Class136.anIntArray1695[i_124_], 4);
                        }

                        Class327.anIntArray5348[i_124_] = class289_122_.anInt3633;
                     }

                     --i_124_;
                     ++i_125_;
                  }

                  if (!bools_83_[3 & i_78_ + 1]) {
                     bools[1] = Class250.aBooleanArrayArray3168[b][Node_Sub30.method2723(3, i_123_ + 3)];
                  }
               } else if (!bools_83_[3 & 1 - -i_78_]) {
                  bools[1] = Node_Sub33.aBooleanArrayArray7406[b][Node_Sub30.method2723(3, 3 - -i_123_)];
               }
            }
         }
      }

      if (overlay != null) {
         int i_128_ = Class382.method4179(overlay, (byte)-128, graphicstoolkit);
         if (overlay.blend) {
            for(int i_129_ = 0; ~i_129_ > -9; ++i_129_) {
               int i_130_ = -(i_78_ * 2) + i_129_ & 7;
               if (GLPlane.aBooleanArrayArray7950[shape][i_129_] && ~overlay.anInt3633 <= ~Class327.anIntArray5348[i_130_]) {
                  Class188_Sub1_Sub1.anIntArray9339[i_130_] = overlay.anInt3631;
                  Class262_Sub10.anIntArray7773[i_130_] = i_128_;
                  Class84.anIntArray1136[i_130_] = overlay.texture;
                  Class385.anIntArray4914[i_130_] = overlay.anInt3632;
                  if (overlay.anInt3633 == Class327.anIntArray5348[i_130_]) {
                     Class136.anIntArray1695[i_130_] = Node_Sub16.method2590(Class136.anIntArray1695[i_130_], 2);
                  } else {
                     Class136.anIntArray1695[i_130_] = 2;
                  }

                  Class327.anIntArray5348[i_130_] = overlay.anInt3633;
               }
            }
         }
      }
   }

   public static void method3342(boolean bool) {
      aCacheNode_Sub13_3509 = null;
      if (!bool) {
         regionY = 40;
      }
   }

   final void method3343(int[][] is, byte b, int i) {
      ++anInt3517;
      int[][] is_132_ = this.tileHeights[i];

      for(int i_133_ = 0; 1 + this.mapSizeX > i_133_; ++i_133_) {
         for(int i_134_ = 0; ~i_134_ > ~(1 + this.mapSizeY); ++i_134_) {
            is_132_[i_133_][i_134_] += is[i_133_][i_134_];
         }
      }
   }

   static final void method3344(int i, boolean bool, int i_135_) {
      if (i != 1420162185) {
         method3342(true);
      }

      ++anInt3529;
      Node_Sub43 node_sub43 = !bool ? ItemDefinitions.aNode_Sub43_1925 : Class29.aNode_Sub43_477;
      if (node_sub43 != null && ~i_135_ <= -1 && ~node_sub43.anInt7531 < ~i_135_) {
         Class24 class24 = node_sub43.aClass24Array7533[i_135_];
         if (~class24.aByte438 == 0) {
            String string = class24.aString437;
            Class123 class123 = Class262_Sub23.method3213((byte)-85);
            OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class246.aClass318_3103, class123.issacKeys);
            node_sub13.currentOutgoingPacket.writeByte(Class126.method1536(i + -1420183011, string) + 3);
            node_sub13.currentOutgoingPacket.writeByte(bool ? 1 : 0);
            node_sub13.currentOutgoingPacket.writeShort(i_135_);
            node_sub13.currentOutgoingPacket.writeString(string);
            class123.sendPacket(i ^ 1420162294, node_sub13);
         }
      }
   }

   private final void decodeMapDefinitions(
      int i, int localY, int paddingY, int localX, int coordX, Buffer buffer, int paddingX, int coordY, int plane, boolean skipShapes, int archiveId
   ) {
      if (i == 1) {
         paddingY = 1;
         if (archiveId == RSMapperClient.mapArchiveId) {
            System.out.println("y set to 1");
         }
      } else if (i != 2) {
         if (i == 3) {
            paddingX = 1;
            if (archiveId == RSMapperClient.mapArchiveId) {
               System.out.println("x set to 1");
            }
         }
      } else {
         paddingX = 1;
         paddingY = 1;
         if (archiveId == RSMapperClient.mapArchiveId) {
            System.out.println("both set to 1");
         }
      }

      ++anInt3515;
      if (localX >= 0 && localX < this.mapSizeX && localY >= 0 && localY < this.mapSizeY) {
         if (!this.undermap && !skipShapes) {
            if (RSMapperClient.editor.mapEditor.dataLoaded && archiveId == RSMapperClient.mapArchiveId) {
               tileFlags[plane][localX][localY] = RSMapperClient.editor.mapEditor.flags[plane][localX][localY];
            } else {
               tileFlags[plane][localX][localY] = 0;
            }
         }

         while(true) {
            int flag = buffer.readUnsignedByte();
            if (flag == 0) {
               if (!this.undermap) {
                  if (plane == 0) {
                     this.tileHeights[0][localX + paddingX][localY + paddingY] = 8 * -Class339_Sub1.method3925(coordX + 932731, 114, coordY + 556238) << 2;
                  } else {
                     this.tileHeights[plane][paddingX + localX][paddingY + localY] = this.tileHeights[plane - 1][localX + paddingX][localY + paddingY] - 960;
                  }
               } else {
                  this.tileHeights[0][paddingX + localX][localY + paddingY] = 0;
               }
               break;
            }

            if (flag == 1) {
               int height = buffer.readUnsignedByte();
               if (!this.undermap) {
                  if (height == 1) {
                     height = 0;
                  }

                  if (plane == 0) {
                     this.tileHeights[0][paddingX + localX][paddingY + localY] = 8 * -height << 2;
                  } else {
                     this.tileHeights[plane][paddingX + localX][localY + paddingY] = this.tileHeights[plane - 1][localX + paddingX][paddingY + localY]
                        - (8 * height << 2);
                  }
               } else {
                  this.tileHeights[0][paddingX + localX][paddingY + localY] = 8 * height << 2;
               }
               break;
            }

            if (flag <= 49) {
               if (skipShapes) {
                  buffer.readUnsignedByte();
               } else {
                  this.tileOverlays[plane][localX][localY] = buffer.readByte();
                  this.tileShapes[plane][localX][localY] = (byte)((flag - 2) / 4);
                  this.tileRotations[plane][localX][localY] = (byte)(3 & flag - 2 + i);
               }
            } else if (flag <= 81) {
               if (!this.undermap && !skipShapes) {
                  if (RSMapperClient.editor.mapEditor.dataLoaded && archiveId == RSMapperClient.mapArchiveId) {
                     tileFlags[plane][localX][localY] = RSMapperClient.editor.mapEditor.flags[plane][localX][localY];
                  } else {
                     tileFlags[plane][localX][localY] = (byte)(flag - 49);
                     if (!RSMapperClient.editor.mapEditor.dataLoaded && archiveId == RSMapperClient.mapArchiveId) {
                        RSMapperClient.editor.mapEditor.flags[plane][localX][localY] = (byte)(flag - 49);
                     }
                  }
               }
            } else if (!skipShapes) {
               this.tileUnderlays[plane][localX][localY] = (byte)(flag - 81);
            }
         }
      } else {
         while(true) {
            int flag = buffer.readUnsignedByte();
            if (flag == 0) {
               break;
            }

            if (flag == 1) {
               buffer.readUnsignedByte();
               break;
            }

            if (flag <= 49) {
               buffer.readUnsignedByte();
            }
         }
      }
   }

   final void method3346(byte b, GraphicsToolkit graphicstoolkit, Plane plane, Plane plane_147_) {
      ++anInt3510;
      if (b == 75) {
         if (Class212.anIntArray5128 == null || this.mapSizeY != Class212.anIntArray5128.length) {
            Class377_Sub1.anIntArray8776 = new int[this.mapSizeY];
            Animable_Sub3.anIntArray9142 = new int[this.mapSizeY];
            Class212.anIntArray5128 = new int[this.mapSizeY];
            Class190.anIntArray2328 = new int[this.mapSizeY];
            Class290_Sub7.anIntArray8131 = new int[this.mapSizeY];
         }

         int[][] is = new int[this.mapSizeX][this.mapSizeY];

         for(int i = 0; ~this.maxPlanes < ~i; ++i) {
            for(int i_148_ = 0; this.mapSizeY > i_148_; ++i_148_) {
               Class212.anIntArray5128[i_148_] = 0;
               Class290_Sub7.anIntArray8131[i_148_] = 0;
               Class377_Sub1.anIntArray8776[i_148_] = 0;
               Class190.anIntArray2328[i_148_] = 0;
               Animable_Sub3.anIntArray9142[i_148_] = 0;
            }

            for(int i_149_ = -5; ~this.mapSizeX < ~i_149_; ++i_149_) {
               for(int i_150_ = 0; ~this.mapSizeY < ~i_150_; ++i_150_) {
                  int i_151_ = i_149_ + 5;
                  if (i_151_ < this.mapSizeX) {
                     int i_152_ = (
                           RSMapperClient.MAP_LOADED
                              ? (
                                 this.undermap
                                    ? RSMapperClient.editor.mapEditor.um_underlays[i][i_151_][i_150_]
                                    : RSMapperClient.editor.mapEditor.underlays[i][i_151_][i_150_]
                              )
                              : this.tileUnderlays[i][i_151_][i_150_]
                        )
                        & 255;
                     if (~i_152_ < -1) {
                        UnderlayDefinition class236 = this.aClass58_3536.getUnderlayDefinitions(-17993, -1 + i_152_);
                        Class212.anIntArray5128[i_150_] += class236.anInt2888;
                        Class290_Sub7.anIntArray8131[i_150_] += class236.anInt2897;
                        Class377_Sub1.anIntArray8776[i_150_] += class236.anInt2901;
                        Class190.anIntArray2328[i_150_] += class236.anInt2890;
                        Animable_Sub3.anIntArray9142[i_150_]++;
                     }
                  }

                  int i_153_ = i_149_ - 5;
                  if (i_153_ >= 0) {
                     int i_154_ = (
                           RSMapperClient.MAP_LOADED
                              ? (
                                 this.undermap
                                    ? RSMapperClient.editor.mapEditor.um_underlays[i][i_153_][i_150_]
                                    : RSMapperClient.editor.mapEditor.underlays[i][i_153_][i_150_]
                              )
                              : this.tileUnderlays[i][i_153_][i_150_]
                        )
                        & 255;
                     if (i_154_ > 0) {
                        UnderlayDefinition class236 = this.aClass58_3536.getUnderlayDefinitions(-17993, -1 + i_154_);
                        Class212.anIntArray5128[i_150_] -= class236.anInt2888;
                        Class290_Sub7.anIntArray8131[i_150_] -= class236.anInt2897;
                        Class377_Sub1.anIntArray8776[i_150_] -= class236.anInt2901;
                        Class190.anIntArray2328[i_150_] -= class236.anInt2890;
                        Animable_Sub3.anIntArray9142[i_150_]--;
                     }
                  }
               }

               if (i_149_ >= 0) {
                  int i_155_ = 0;
                  int i_156_ = 0;
                  int i_157_ = 0;
                  int i_158_ = 0;
                  int i_159_ = 0;

                  for(int i_160_ = -5; i_160_ < this.mapSizeY; ++i_160_) {
                     int i_161_ = 5 + i_160_;
                     if (~this.mapSizeY < ~i_161_) {
                        i_156_ += Class290_Sub7.anIntArray8131[i_161_];
                        i_155_ += Class212.anIntArray5128[i_161_];
                        i_158_ += Class190.anIntArray2328[i_161_];
                        i_157_ += Class377_Sub1.anIntArray8776[i_161_];
                        i_159_ += Animable_Sub3.anIntArray9142[i_161_];
                     }

                     int i_162_ = i_160_ - 5;
                     if (i_162_ >= 0) {
                        i_157_ -= Class377_Sub1.anIntArray8776[i_162_];
                        i_158_ -= Class190.anIntArray2328[i_162_];
                        i_155_ -= Class212.anIntArray5128[i_162_];
                        i_159_ -= Animable_Sub3.anIntArray9142[i_162_];
                        i_156_ -= Class290_Sub7.anIntArray8131[i_162_];
                     }

                     if (~i_160_ <= -1 && ~i_158_ < -1 && i_159_ > 0) {
                        is[i_149_][i_160_] = Node_Sub25.method2651(i_157_ / i_159_, i_156_ / i_159_, false, i_155_ * 256 / i_158_);
                     }
                  }
               }
            }

            if (!Class382.aBoolean5254) {
               this.method3340(i, (byte)-78, graphicstoolkit, is, i == 0 ? plane_147_ : null, Class320_Sub10.aPlaneArray8300[i], ~i == -1 ? plane : null);
            } else {
               this.method3348(i == 0 ? plane_147_ : null, false, is, i != 0 ? null : plane, Class320_Sub10.aPlaneArray8300[i], graphicstoolkit, i);
            }
         }

         if (!this.undermap) {
            if (~Class237.anInt2906 != -1) {
               EntityNode_Sub3.method939();
            }

            if (Class163.aBoolean2015) {
               Class189.method1925();
            }
         }

         for(int i = 0; ~this.maxPlanes < ~i; ++i) {
            Class320_Sub10.aPlaneArray8300[i].YA();
         }
      }
   }

   final void method3347(int i, int i_163_, int i_164_, int i_165_, int i_166_, int i_167_) {
      ++anInt3523;

      for(int i_168_ = i_164_; ~i_168_ > ~(i_163_ + i_164_); ++i_168_) {
         for(int i_169_ = i_165_; i_165_ + i_167_ > i_169_; ++i_169_) {
            if (i_169_ >= 0 && ~this.mapSizeX < ~i_169_ && i_168_ >= 0 && i_168_ < this.mapSizeY) {
               this.tileHeights[i_166_][i_169_][i_168_] = ~i_166_ >= -1 ? 0 : this.tileHeights[i_166_ + -1][i_169_][i_168_] + -960;
            }
         }
      }

      if (i_165_ > 0 && ~i_165_ > ~this.mapSizeX) {
         for(int i_170_ = i_164_ - -1; i_170_ < i_164_ - -i_163_; ++i_170_) {
            if (i_170_ >= 0 && i_170_ < this.mapSizeY) {
               this.tileHeights[i_166_][i_165_][i_170_] = this.tileHeights[i_166_][i_165_ + -1][i_170_];
            }
         }
      }

      if (i_164_ > 0 && i_164_ < this.mapSizeY) {
         for(int i_171_ = 1 + i_165_; i_171_ < i_165_ - -i_167_; ++i_171_) {
            if (i_171_ >= 0 && i_171_ < this.mapSizeX) {
               this.tileHeights[i_166_][i_171_][i_164_] = this.tileHeights[i_166_][i_171_][i_164_ + -1];
            }
         }
      }

      if (i != -13972) {
         this.method3349(-48, -54, -84, -107, -23, null, -123, -43, null, (byte)71);
      }

      if (~i_165_ <= -1 && ~i_164_ <= -1 && ~this.mapSizeX < ~i_165_ && ~this.mapSizeY < ~i_164_) {
         if (~i_166_ == -1) {
            if (~i_165_ < -1 && ~this.tileHeights[i_166_][i_165_ + -1][i_164_] != -1) {
               this.tileHeights[i_166_][i_165_][i_164_] = this.tileHeights[i_166_][i_165_ - 1][i_164_];
            } else if (i_164_ > 0 && this.tileHeights[i_166_][i_165_][-1 + i_164_] != 0) {
               this.tileHeights[i_166_][i_165_][i_164_] = this.tileHeights[i_166_][i_165_][i_164_ - 1];
            } else if (i_165_ > 0 && i_164_ > 0 && ~this.tileHeights[i_166_][-1 + i_165_][-1 + i_164_] != -1) {
               this.tileHeights[i_166_][i_165_][i_164_] = this.tileHeights[i_166_][i_165_ - 1][-1 + i_164_];
            }
         } else if (~i_165_ < -1 && this.tileHeights[i_166_][i_165_ - 1][i_164_] != this.tileHeights[i_166_ + -1][i_165_ + -1][i_164_]) {
            this.tileHeights[i_166_][i_165_][i_164_] = this.tileHeights[i_166_][-1 + i_165_][i_164_];
         } else if (i_164_ > 0 && this.tileHeights[i_166_][i_165_][i_164_ + -1] != this.tileHeights[i_166_ + -1][i_165_][-1 + i_164_]) {
            this.tileHeights[i_166_][i_165_][i_164_] = this.tileHeights[i_166_][i_165_][i_164_ - 1];
         } else if (i_165_ > 0 && i_164_ > 0 && ~this.tileHeights[-1 + i_166_][i_165_ - 1][-1 + i_164_] != ~this.tileHeights[i_166_][i_165_ + -1][-1 + i_164_]
            )
          {
            this.tileHeights[i_166_][i_165_][i_164_] = this.tileHeights[i_166_][i_165_ - 1][i_164_ + -1];
         }
      }
   }

   private final void method3348(Plane plane, boolean bool, int[][] is, Plane plane_172_, Plane plane_173_, GraphicsToolkit graphicstoolkit, int planeNum) {
      ++anInt3531;
      byte[][] shapes = RSMapperClient.MAP_LOADED
         ? (this.undermap ? RSMapperClient.editor.mapEditor.um_shapes[planeNum] : RSMapperClient.editor.mapEditor.shapes[planeNum])
         : this.tileShapes[planeNum];
      byte[][] shapeRotations = RSMapperClient.MAP_LOADED
         ? (this.undermap ? RSMapperClient.editor.mapEditor.um_rotations[planeNum] : RSMapperClient.editor.mapEditor.rotations[planeNum])
         : this.tileRotations[planeNum];
      if (bool) {
         this.aClass71_3512 = null;
      }

      byte[][] underlays = RSMapperClient.MAP_LOADED
         ? (this.undermap ? RSMapperClient.editor.mapEditor.um_underlays[planeNum] : RSMapperClient.editor.mapEditor.underlays[planeNum])
         : this.tileUnderlays[planeNum];
      byte[][] overlays = RSMapperClient.MAP_LOADED
         ? (this.undermap ? RSMapperClient.editor.mapEditor.um_overlays[planeNum] : RSMapperClient.editor.mapEditor.overlays[planeNum])
         : this.tileOverlays[planeNum];

      for(int x = 0; x < this.mapSizeX; ++x) {
         int paddedX = this.mapSizeX - 1 > x ? 1 + x : x;

         for(int y = 0; y < this.mapSizeY; ++y) {
            int paddedY = y < this.mapSizeY - 1 ? 1 + y : y;
            if (Class256.anInt3237 == -1 || Class369.method4085(y, 0, Class256.anInt3237, x, planeNum)) {
               boolean bool_181_ = false;
               boolean blendWithOverlay = false;
               boolean[] bools = new boolean[4];
               byte shapeOnTile = shapes[x][y];
               int rotationOnTile = shapeRotations[x][y];
               int overlayOnTile = 255 & overlays[x][y];
               int underlayOnTile = 255 & underlays[x][y];
               if (x == 48) {
               }

               int underlayOnPaddedX = 255 & underlays[paddedX][y];
               int underlayOnPaddedY = 255 & underlays[x][paddedY];
               int underlayOnPaddedTile = 255 & underlays[paddedX][paddedY];
               if (overlayOnTile != 0 || underlayOnTile != 0) {
                  OverlayDefinition overlay = overlayOnTile == 0 ? null : this.aClass71_3512.getOverlayDefinitions(overlayOnTile - 1, (byte)118);
                  UnderlayDefinition underlay = underlayOnTile == 0 ? null : this.aClass58_3536.getUnderlayDefinitions(-17993, underlayOnTile - 1);
                  if (shapeOnTile == 0 && overlay == null) {
                     shapeOnTile = 12;
                  }

                  if (overlay != null) {
                     if (overlay.anInt3631 == -1 && overlay.mapColor == -1) {
                        overlay = null;
                     } else if (underlay != null && shapeOnTile != 0) {
                        blendWithOverlay = overlay.blend;
                     }
                  }

                  if ((shapeOnTile == 0 || shapeOnTile == 12) && x > 0 && y > 0 && x < this.mapSizeX && y < this.mapSizeY) {
                     int i_190_ = 0;
                     int i_191_ = 0;
                     int i_192_ = 0;
                     i_191_ += underlayOnTile == underlays[paddedX][-1 + y] ? 1 : -1;
                     i_190_ += underlays[x + -1][-1 + y] == underlayOnTile ? 1 : -1;
                     i_192_ += underlayOnTile == underlays[paddedX][paddedY] ? 1 : -1;
                     int i_193_ = 0;
                     if (~underlays[x][y + -1] != ~underlayOnTile) {
                        --i_191_;
                        --i_190_;
                     } else {
                        ++i_191_;
                        ++i_190_;
                     }

                     i_193_ += underlays[x + -1][paddedY] == underlayOnTile ? 1 : -1;
                     if (underlayOnTile != underlays[paddedX][y]) {
                        --i_191_;
                        --i_192_;
                     } else {
                        ++i_192_;
                        ++i_191_;
                     }

                     if (underlayOnTile != underlays[x][paddedY]) {
                        --i_192_;
                        --i_193_;
                     } else {
                        ++i_192_;
                        ++i_193_;
                     }

                     if (underlayOnTile == underlays[x + -1][y]) {
                        ++i_190_;
                        ++i_193_;
                     } else {
                        --i_190_;
                        --i_193_;
                     }

                     int i_194_ = -i_192_ + i_190_;
                     if (~i_194_ > -1) {
                        i_194_ = -i_194_;
                     }

                     int i_195_ = i_191_ - i_193_;
                     if (~i_195_ > -1) {
                        i_195_ = -i_195_;
                     }

                     if (i_194_ == i_195_) {
                        i_194_ = plane_173_.getVerticeHeight(y, x, (byte)-118) - plane_173_.getVerticeHeight(paddedY, paddedX, (byte)-118);
                        if (~i_194_ > -1) {
                           i_194_ = -i_194_;
                        }

                        i_195_ = plane_173_.getVerticeHeight(y, paddedX, (byte)-118) - plane_173_.getVerticeHeight(paddedY, x, (byte)-118);
                        if (i_195_ < 0) {
                           i_195_ = -i_195_;
                        }
                     }

                     rotationOnTile = i_195_ > i_194_ ? 1 : 0;
                  }

                  for(int i_196_ = 0; i_196_ < 13; ++i_196_) {
                     Class327.anIntArray5348[i_196_] = -1;
                     Class136.anIntArray1695[i_196_] = 1;
                  }

                  boolean[] bools_197_ = overlay != null && overlay.blend
                     ? Class250.aBooleanArrayArray3168[shapeOnTile]
                     : Node_Sub33.aBooleanArrayArray7406[shapeOnTile];
                  this.method3341(
                     shapeOnTile,
                     overlay,
                     shapeRotations,
                     this.mapSizeX,
                     8,
                     x,
                     rotationOnTile,
                     this.mapSizeY,
                     graphicstoolkit,
                     y,
                     bools,
                     underlay,
                     shapes,
                     overlays
                  );
                  boolean bool_198_ = overlay != null && ~overlay.anInt3631 != ~overlay.mapColor;
                  if (!bool_198_) {
                     for(int i_199_ = 0; i_199_ < 8; ++i_199_) {
                        if (Class327.anIntArray5348[i_199_] >= 0 && ~Class262_Sub10.anIntArray7773[i_199_] != ~Class188_Sub1_Sub1.anIntArray9339[i_199_]) {
                           bool_198_ = true;
                           break;
                        }
                     }
                  }

                  if (!bools_197_[3 & 1 + rotationOnTile]) {
                     bools[1] = Class313.method3647(bools[1], ~Node_Sub30.method2723(Class136.anIntArray1695[2], Class136.anIntArray1695[4]) == -1);
                  }

                  if (!bools_197_[3 & 3 + rotationOnTile]) {
                     bools[3] = Class313.method3647(bools[3], Node_Sub30.method2723(Class136.anIntArray1695[6], Class136.anIntArray1695[0]) == 0);
                  }

                  if (!bools_197_[rotationOnTile & 3]) {
                     bools[0] = Class313.method3647(bools[0], ~Node_Sub30.method2723(Class136.anIntArray1695[0], Class136.anIntArray1695[2]) == -1);
                  }

                  if (!bools_197_[3 & 2 + rotationOnTile]) {
                     bools[2] = Class313.method3647(bools[2], ~Node_Sub30.method2723(Class136.anIntArray1695[6], Class136.anIntArray1695[4]) == -1);
                  }

                  if (!blendWithOverlay && (~shapeOnTile == -1 || shapeOnTile == 12)) {
                     if (bools[0] && !bools[1] && !bools[2] && bools[3]) {
                        bools[0] = bools[3] = false;
                        shapeOnTile = (byte)(~shapeOnTile != -1 ? 14 : 13);
                        rotationOnTile = 0;
                     } else if (bools[0] && bools[1] && !bools[2] && !bools[3]) {
                        shapeOnTile = (byte)(~shapeOnTile != -1 ? 14 : 13);
                        rotationOnTile = 3;
                        bools[0] = bools[1] = false;
                     } else if (!bools[0] && bools[1] && bools[2] && !bools[3]) {
                        shapeOnTile = (byte)(~shapeOnTile != -1 ? 14 : 13);
                        bools[1] = bools[2] = false;
                        rotationOnTile = 2;
                     } else if (!bools[0] && !bools[1] && bools[2] && bools[3]) {
                        shapeOnTile = (byte)(shapeOnTile != 0 ? 14 : 13);
                        rotationOnTile = 1;
                        bools[2] = bools[3] = false;
                     }
                  }

                  boolean bool_200_ = !blendWithOverlay && !bools[0] && !bools[2] && !bools[1] && !bools[3];
                  int[] is_201_ = null;
                  int i_204_;
                  int[] is_205_;
                  int[] is_206_;
                  int i_202_;
                  int[] is_203_;
                  if (bool_200_) {
                     is_205_ = Class141.anIntArrayArray1755[shapeOnTile];
                     i_204_ = overlay == null ? 0 : ProducingGraphicsBuffer.anIntArray9881[shapeOnTile];
                     is_203_ = Node_Sub43.anIntArrayArray7538[shapeOnTile];
                     is_206_ = Class262_Sub21.anIntArrayArray7868[shapeOnTile];
                     i_202_ = underlay == null ? 0 : Node_Sub38_Sub7.anIntArray10143[shapeOnTile];
                  } else if (!blendWithOverlay) {
                     i_202_ = underlay == null ? 0 : Class206.anIntArray2463[shapeOnTile];
                     is_203_ = Class262.anIntArrayArray3328[shapeOnTile];
                     i_204_ = overlay == null ? 0 : Class264.anIntArray3352[shapeOnTile];
                     is_205_ = Class60.anIntArrayArray882[shapeOnTile];
                     is_201_ = Node.anIntArrayArray2801[shapeOnTile];
                     is_206_ = Class114.anIntArrayArray1455[shapeOnTile];
                  } else {
                     is_203_ = Node_Sub15_Sub4.anIntArrayArray9799[shapeOnTile];
                     i_204_ = overlay == null ? 0 : Node_Sub27.anIntArray7296[shapeOnTile];
                     is_205_ = Class127.anIntArrayArray1642[shapeOnTile];
                     is_201_ = Class262_Sub19.anIntArrayArray7854[shapeOnTile];
                     is_206_ = Class320_Sub22.anIntArrayArray8425[shapeOnTile];
                     i_202_ = underlay == null ? 0 : Class188_Sub2.anIntArray6877[shapeOnTile];
                  }

                  int i_207_ = i_204_ + i_202_;
                  if (~i_207_ >= -1) {
                     Class320_Sub24.method3775(planeNum, x, y);
                  } else {
                     if (bools[0]) {
                        ++i_207_;
                     }

                     if (bools[2]) {
                        ++i_207_;
                     }

                     if (bools[1]) {
                        ++i_207_;
                     }

                     if (bools[3]) {
                        ++i_207_;
                     }

                     int i_208_ = 0;
                     int i_209_ = 0;
                     int i_210_ = i_207_ * 3;
                     int[] is_211_ = !bool_198_ ? null : new int[i_210_];
                     int[] is_212_ = new int[i_210_];
                     int[] is_213_ = new int[i_210_];
                     int[] is_214_ = new int[i_210_];
                     int[] is_215_ = new int[i_210_];
                     int[] is_216_ = new int[i_210_];
                     int[] is_217_ = plane == null ? null : new int[i_210_];
                     int[] is_218_ = plane == null && plane_172_ == null ? null : new int[i_210_];
                     int i_219_ = -1;
                     int i_220_ = -1;
                     int i_221_ = 256;
                     if (overlay == null) {
                        if (!bool_200_) {
                           if (blendWithOverlay) {
                              i_208_ += Node_Sub27.anIntArray7296[shapeOnTile];
                           } else {
                              i_208_ += Class264.anIntArray3352[shapeOnTile];
                           }
                        } else {
                           i_208_ += ProducingGraphicsBuffer.anIntArray9881[shapeOnTile];
                        }
                     } else {
                        i_221_ = overlay.anInt3632;
                        i_219_ = overlay.anInt3631;
                        i_220_ = overlay.texture;
                        int i_222_ = Class382.method4179(overlay, (byte)-31, graphicstoolkit);

                        for(int i_223_ = 0; i_223_ < i_204_; ++i_223_) {
                           int i_225_;
                           if (bools[-rotationOnTile & 3] && ~is_201_[0] == ~i_208_) {
                              Node_Sub38_Sub26.anIntArray10370[0] = is_205_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[1] = 1;
                              Node_Sub38_Sub26.anIntArray10370[2] = is_203_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[3] = 1;
                              Node_Sub38_Sub26.anIntArray10370[4] = is_206_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[5] = is_203_[i_208_];
                              i_225_ = 6;
                           } else if (bools[3 & 2 - rotationOnTile] && ~is_201_[2] == ~i_208_) {
                              Node_Sub38_Sub26.anIntArray10370[0] = is_205_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[1] = 5;
                              Node_Sub38_Sub26.anIntArray10370[2] = is_203_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[3] = 5;
                              Node_Sub38_Sub26.anIntArray10370[4] = is_206_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[5] = is_203_[i_208_];
                              i_225_ = 6;
                           } else if (bools[1 - rotationOnTile & 3] && ~is_201_[1] == ~i_208_) {
                              Node_Sub38_Sub26.anIntArray10370[0] = is_205_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[1] = 3;
                              Node_Sub38_Sub26.anIntArray10370[2] = is_203_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[3] = 3;
                              Node_Sub38_Sub26.anIntArray10370[4] = is_206_[i_208_];
                              i_225_ = 6;
                              Node_Sub38_Sub26.anIntArray10370[5] = is_203_[i_208_];
                           } else if (bools[3 + -rotationOnTile & 3] && ~is_201_[3] == ~i_208_) {
                              Node_Sub38_Sub26.anIntArray10370[0] = is_205_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[1] = 7;
                              Node_Sub38_Sub26.anIntArray10370[2] = is_203_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[3] = 7;
                              Node_Sub38_Sub26.anIntArray10370[4] = is_206_[i_208_];
                              i_225_ = 6;
                              Node_Sub38_Sub26.anIntArray10370[5] = is_203_[i_208_];
                           } else {
                              Node_Sub38_Sub26.anIntArray10370[0] = is_205_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[1] = is_206_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[2] = is_203_[i_208_];
                              i_225_ = 3;
                           }

                           for(int i_226_ = 0; i_225_ > i_226_; ++i_226_) {
                              int i_227_ = Node_Sub38_Sub26.anIntArray10370[i_226_];
                              int i_228_ = 7 & -(rotationOnTile * 2) + i_227_;
                              int i_229_ = this.anIntArray3522[i_227_];
                              int i_230_ = this.anIntArray3513[i_227_];
                              int i_231_;
                              int i_232_;
                              if (rotationOnTile != 1) {
                                 if (rotationOnTile == 2) {
                                    i_231_ = 512 + -i_230_;
                                    i_232_ = 512 - i_229_;
                                 } else if (~rotationOnTile != -4) {
                                    i_232_ = i_229_;
                                    i_231_ = i_230_;
                                 } else {
                                    i_232_ = 512 - i_230_;
                                    i_231_ = i_229_;
                                 }
                              } else {
                                 i_231_ = -i_229_ + 512;
                                 i_232_ = i_230_;
                              }

                              is_212_[i_209_] = i_232_;
                              is_213_[i_209_] = i_231_;
                              if (is_217_ != null && GLPlane.aBooleanArrayArray7950[shapeOnTile][i_227_]) {
                                 int i_233_ = i_232_ + (x << 9);
                                 int i_234_ = (y << 9) - -i_231_;
                                 is_217_[i_209_] = plane.getMedianHeightFromVertices(i_234_, -115, i_233_)
                                    + -plane_173_.getMedianHeightFromVertices(i_234_, -112, i_233_);
                              }

                              if (is_218_ != null) {
                                 if (plane != null && !GLPlane.aBooleanArrayArray7950[shapeOnTile][i_227_]) {
                                    int i_237_ = i_232_ + (x << 9);
                                    int i_238_ = (y << 9) - -i_231_;
                                    is_218_[i_209_] = plane_173_.getMedianHeightFromVertices(i_238_, -128, i_237_)
                                       - plane.getMedianHeightFromVertices(i_238_, -111, i_237_);
                                 } else if (plane_172_ != null && !Node_Sub15_Sub7.aBooleanArrayArray9822[shapeOnTile][i_227_]) {
                                    int i_235_ = i_232_ + (x << 9);
                                    int i_236_ = i_231_ + (y << 9);
                                    is_218_[i_209_] = plane_172_.getMedianHeightFromVertices(i_236_, -109, i_235_)
                                       - plane_173_.getMedianHeightFromVertices(i_236_, -115, i_235_);
                                 }
                              }

                              if (i_227_ < 8 && Class327.anIntArray5348[i_228_] > overlay.anInt3633) {
                                 if (is_211_ != null) {
                                    is_211_[i_209_] = Class262_Sub10.anIntArray7773[i_228_];
                                 }

                                 is_216_[i_209_] = Class385.anIntArray4914[i_228_];
                                 is_215_[i_209_] = Class84.anIntArray1136[i_228_];
                                 is_214_[i_209_] = Class188_Sub1_Sub1.anIntArray9339[i_228_];
                              } else {
                                 if (is_211_ != null) {
                                    is_211_[i_209_] = i_222_;
                                 }

                                 is_215_[i_209_] = overlay.texture;
                                 is_216_[i_209_] = overlay.anInt3632;
                                 is_214_[i_209_] = i_219_;
                              }

                              ++i_209_;
                           }

                           ++i_208_;
                        }

                        if (!this.undermap && planeNum == 0) {
                           Class158.method1725(x, y, overlay.anInt3646, overlay.anInt3634 * 8, overlay.anInt3641);
                        }

                        if (~shapeOnTile != -13 && ~overlay.anInt3631 != 0 && overlay.aBoolean3638) {
                           bool_181_ = true;
                        }
                     }

                     if (underlay != null) {
                        if (~underlayOnPaddedX == -1) {
                           underlayOnPaddedX = underlayOnTile;
                        }

                        if (underlayOnPaddedTile == 0) {
                           underlayOnPaddedTile = underlayOnTile;
                        }

                        if (~underlayOnPaddedY == -1) {
                           underlayOnPaddedY = underlayOnTile;
                        }

                        UnderlayDefinition class236_239_ = this.aClass58_3536.getUnderlayDefinitions(-17993, -1 + underlayOnTile);
                        UnderlayDefinition class236_240_ = this.aClass58_3536.getUnderlayDefinitions(-17993, -1 + underlayOnPaddedY);
                        UnderlayDefinition class236_241_ = this.aClass58_3536.getUnderlayDefinitions(-17993, -1 + underlayOnPaddedTile);
                        UnderlayDefinition class236_242_ = this.aClass58_3536.getUnderlayDefinitions(-17993, underlayOnPaddedX - 1);

                        for(int i_243_ = 0; ~i_202_ < ~i_243_; ++i_243_) {
                           int i_245_;
                           if (bools[3 & -rotationOnTile] && is_201_[0] == i_208_) {
                              Node_Sub38_Sub26.anIntArray10370[0] = is_205_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[1] = 1;
                              Node_Sub38_Sub26.anIntArray10370[2] = is_203_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[3] = 1;
                              Node_Sub38_Sub26.anIntArray10370[4] = is_206_[i_208_];
                              i_245_ = 6;
                              Node_Sub38_Sub26.anIntArray10370[5] = is_203_[i_208_];
                           } else if (bools[-rotationOnTile + 2 & 3] && is_201_[2] == i_208_) {
                              Node_Sub38_Sub26.anIntArray10370[0] = is_205_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[1] = 5;
                              Node_Sub38_Sub26.anIntArray10370[2] = is_203_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[3] = 5;
                              Node_Sub38_Sub26.anIntArray10370[4] = is_206_[i_208_];
                              i_245_ = 6;
                              Node_Sub38_Sub26.anIntArray10370[5] = is_203_[i_208_];
                           } else if (bools[3 & -rotationOnTile + 1] && is_201_[1] == i_208_) {
                              Node_Sub38_Sub26.anIntArray10370[0] = is_205_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[1] = 3;
                              Node_Sub38_Sub26.anIntArray10370[2] = is_203_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[3] = 3;
                              Node_Sub38_Sub26.anIntArray10370[4] = is_206_[i_208_];
                              i_245_ = 6;
                              Node_Sub38_Sub26.anIntArray10370[5] = is_203_[i_208_];
                           } else if (bools[-rotationOnTile + 3 & 3] && ~is_201_[3] == ~i_208_) {
                              Node_Sub38_Sub26.anIntArray10370[0] = is_205_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[1] = 7;
                              Node_Sub38_Sub26.anIntArray10370[2] = is_203_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[3] = 7;
                              Node_Sub38_Sub26.anIntArray10370[4] = is_206_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[5] = is_203_[i_208_];
                              i_245_ = 6;
                           } else {
                              Node_Sub38_Sub26.anIntArray10370[0] = is_205_[i_208_];
                              Node_Sub38_Sub26.anIntArray10370[1] = is_206_[i_208_];
                              i_245_ = 3;
                              Node_Sub38_Sub26.anIntArray10370[2] = is_203_[i_208_];
                           }

                           ++i_208_;

                           for(int i_246_ = 0; i_246_ < i_245_; ++i_246_) {
                              int i_247_ = Node_Sub38_Sub26.anIntArray10370[i_246_];
                              int i_248_ = 7 & i_247_ + -(rotationOnTile * 2);
                              int i_249_ = this.anIntArray3522[i_247_];
                              int i_250_ = this.anIntArray3513[i_247_];
                              int i_252_;
                              int i_251_;
                              if (~rotationOnTile != -2) {
                                 if (~rotationOnTile == -3) {
                                    i_251_ = -i_249_ + 512;
                                    i_252_ = 512 + -i_250_;
                                 } else if (~rotationOnTile == -4) {
                                    i_252_ = i_249_;
                                    i_251_ = -i_250_ + 512;
                                 } else {
                                    i_251_ = i_249_;
                                    i_252_ = i_250_;
                                 }
                              } else {
                                 i_251_ = i_250_;
                                 i_252_ = -i_249_ + 512;
                              }

                              is_212_[i_209_] = i_251_;
                              is_213_[i_209_] = i_252_;
                              if (is_217_ != null && GLPlane.aBooleanArrayArray7950[shapeOnTile][i_247_]) {
                                 int i_253_ = i_251_ + (x << 9);
                                 int i_254_ = i_252_ + (y << 9);
                                 is_217_[i_209_] = plane.getMedianHeightFromVertices(i_254_, -123, i_253_)
                                    - plane_173_.getMedianHeightFromVertices(i_254_, -111, i_253_);
                              }

                              if (is_218_ != null) {
                                 if (plane != null && !GLPlane.aBooleanArrayArray7950[shapeOnTile][i_247_]) {
                                    int i_257_ = (x << 9) + i_251_;
                                    int i_258_ = i_252_ + (y << 9);
                                    is_218_[i_209_] = plane_173_.getMedianHeightFromVertices(i_258_, -117, i_257_)
                                       - plane.getMedianHeightFromVertices(i_258_, -116, i_257_);
                                 } else if (plane_172_ != null && !Node_Sub15_Sub7.aBooleanArrayArray9822[shapeOnTile][i_247_]) {
                                    int i_255_ = i_251_ + (x << 9);
                                    int i_256_ = (y << 9) + i_252_;
                                    is_218_[i_209_] = plane_172_.getMedianHeightFromVertices(i_256_, -124, i_255_)
                                       - plane_173_.getMedianHeightFromVertices(i_256_, -121, i_255_);
                                 }
                              }

                              if (i_247_ < 8 && Class327.anIntArray5348[i_248_] >= 0) {
                                 if (is_211_ != null) {
                                    is_211_[i_209_] = Class262_Sub10.anIntArray7773[i_248_];
                                 }

                                 is_216_[i_209_] = Class385.anIntArray4914[i_248_];
                                 is_215_[i_209_] = Class84.anIntArray1136[i_248_];
                                 is_214_[i_209_] = Class188_Sub1_Sub1.anIntArray9339[i_248_];
                              } else {
                                 if (blendWithOverlay && GLPlane.aBooleanArrayArray7950[shapeOnTile][i_247_]) {
                                    is_215_[i_209_] = i_220_;
                                    is_216_[i_209_] = i_221_;
                                    is_214_[i_209_] = i_219_;
                                 } else if (~i_251_ == -1 && i_252_ == 0) {
                                    is_214_[i_209_] = is[x][y];
                                    is_215_[i_209_] = class236_239_.texture;
                                    is_216_[i_209_] = class236_239_.anInt2894;
                                 } else if (i_251_ == 0 && ~i_252_ == -513) {
                                    is_214_[i_209_] = is[x][paddedY];
                                    is_215_[i_209_] = class236_240_.texture;
                                    is_216_[i_209_] = class236_240_.anInt2894;
                                 } else if (i_251_ == 512 && i_252_ == 512) {
                                    is_214_[i_209_] = is[paddedX][paddedY];
                                    is_215_[i_209_] = class236_241_.texture;
                                    is_216_[i_209_] = class236_241_.anInt2894;
                                 } else if (i_251_ == 512 && ~i_252_ == -1) {
                                    is_214_[i_209_] = is[paddedX][y];
                                    is_215_[i_209_] = class236_242_.texture;
                                    is_216_[i_209_] = class236_242_.anInt2894;
                                 } else {
                                    if (~i_251_ <= -257) {
                                       if (i_252_ < 256) {
                                          is_215_[i_209_] = class236_242_.texture;
                                          is_216_[i_209_] = class236_242_.anInt2894;
                                       } else {
                                          is_215_[i_209_] = class236_241_.texture;
                                          is_216_[i_209_] = class236_241_.anInt2894;
                                       }
                                    } else if (i_252_ < 256) {
                                       is_215_[i_209_] = class236_239_.texture;
                                       is_216_[i_209_] = class236_239_.anInt2894;
                                    } else {
                                       is_215_[i_209_] = class236_240_.texture;
                                       is_216_[i_209_] = class236_240_.anInt2894;
                                    }

                                    int i_259_ = Node_Sub25_Sub1.method2664(is[paddedX][y], 128, i_251_ << 7 >> 9, is[x][y]);
                                    int i_260_ = Node_Sub25_Sub1.method2664(is[paddedX][paddedY], 128, i_251_ << 7 >> 9, is[x][paddedY]);
                                    is_214_[i_209_] = Node_Sub25_Sub1.method2664(i_260_, 128, i_252_ << 7 >> 9, i_259_);
                                 }

                                 if (is_211_ != null) {
                                    is_211_[i_209_] = is_214_[i_209_];
                                 }
                              }

                              ++i_209_;
                           }
                        }

                        if (~shapeOnTile != -1 && underlay.aBoolean2896) {
                           bool_181_ = true;
                        }
                     }

                     int i_267_ = 0;
                     int i_268_ = 0;
                     int i_269_ = 0;
                     if (this.undermap) {
                        i_267_ = Class320_Sub2.method3684(x, y);
                        i_268_ = Class184.method1844(x, y);
                        i_269_ = Class117_Sub2.method1172(x, y);
                     }

                     plane_173_.U(x, y, is_212_, is_217_, is_213_, is_218_, is_214_, is_211_, is_215_, is_216_, i_267_, i_268_, i_269_, bool_181_);
                     Class320_Sub24.method3775(planeNum, x, y);
                  }
               }
            }
         }
      }
   }

   final void method3349(int i, int i_270_, int i_271_, int i_272_, int i_273_, Buffer buffer, int i_274_, int i_275_, Class84[] class84s, byte b) {
      ++anInt3514;
      if (b > -115) {
         this.maxPlanes = 62;
      }

      int i_276_ = (i_275_ & 7) * 8;
      int i_277_ = 8 * (i_272_ & 7);
      if (!this.undermap) {
         Class84 class84 = class84s[i];

         for(int i_278_ = 0; i_278_ < 8; ++i_278_) {
            for(int i_279_ = 0; i_279_ < 8; ++i_279_) {
               int i_280_ = i_271_ - -Class339.method3921(7 & i_278_, i_279_ & 7, 7, i_274_);
               int i_281_ = i_273_ + Class280.method3378(i_279_ & 7, i_278_ & 7, (byte)125, i_274_);
               if (~i_280_ < -1 && ~(this.mapSizeX + -1) < ~i_280_ && i_281_ > 0 && ~i_281_ > ~(this.mapSizeY - 1)) {
                  class84.setClipMask(i_281_, i_280_, -117);
               }
            }
         }
      }

      int i_282_ = (-8 & i_275_) << 3;
      int i_283_ = (-8 & i_272_) << 3;
      int i_284_ = 0;
      int i_285_ = 0;
      if (i_274_ == 1) {
         i_285_ = 1;
      } else if (~i_274_ == -3) {
         i_285_ = 1;
         i_284_ = 1;
      } else if (i_274_ == 3) {
         i_284_ = 1;
      }

      for(int i_286_ = 0; i_286_ < this.maxPlanes; ++i_286_) {
         for(int i_287_ = 0; ~i_287_ > -65; ++i_287_) {
            for(int i_288_ = 0; i_288_ < 64; ++i_288_) {
               if (~i_270_ == ~i_286_ && ~i_287_ <= ~i_276_ && i_287_ <= 8 + i_276_ && ~i_277_ >= ~i_288_ && i_288_ <= 8 + i_277_) {
                  int i_289_;
                  int i_290_;
                  if (~(i_276_ - -8) != ~i_287_ && i_288_ != 8 + i_277_) {
                     i_289_ = i_271_ + Class339.method3921(7 & i_287_, i_288_ & 7, 7, i_274_);
                     i_290_ = Class280.method3378(7 & i_288_, 7 & i_287_, (byte)126, i_274_) + i_273_;
                     this.decodeMapDefinitions(i_274_, i_290_, i_285_, i_289_, i_287_ + i_282_, buffer, i_284_, i_288_ + i_283_, i, false, -1);
                  } else {
                     if (i_274_ != 0) {
                        if (i_274_ == 1) {
                           i_289_ = i_271_ + i_288_ + -i_277_;
                           i_290_ = i_276_ + -i_287_ + i_273_ - -8;
                        } else if (~i_274_ == -3) {
                           i_289_ = 8 + i_271_ - (i_287_ + -i_276_);
                           i_290_ = i_277_ - (i_288_ - 8 - i_273_);
                        } else {
                           i_290_ = i_287_ + -i_276_ + i_273_;
                           i_289_ = i_271_ - (-8 + i_288_ + -i_277_);
                        }
                     } else {
                        i_289_ = i_271_ - i_276_ - -i_287_;
                        i_290_ = i_273_ - i_277_ - -i_288_;
                     }

                     this.decodeMapDefinitions(0, i_290_, 0, i_289_, i_287_ + i_282_, buffer, 0, i_288_ + i_283_, i, true, -1);
                  }

                  if (i_287_ == 63 || i_288_ == 63) {
                     int i_291_ = 1;
                     if (~i_287_ == -64 && i_288_ == 63) {
                        i_291_ = 3;
                     }

                     for(int i_292_ = 0; ~i_291_ < ~i_292_; ++i_292_) {
                        int i_293_ = i_287_;
                        int i_294_ = i_288_;
                        if (i_292_ != 0) {
                           if (~i_292_ == -2) {
                              i_293_ = 64;
                           } else if (i_292_ == 2) {
                              i_294_ = 64;
                           }
                        } else {
                           i_294_ = ~i_288_ == -64 ? 64 : i_288_;
                           i_293_ = ~i_287_ != -64 ? i_287_ : 64;
                        }

                        int i_295_;
                        int i_296_;
                        if (i_274_ == 0) {
                           i_295_ = i_273_ - (i_277_ + -i_294_);
                           i_296_ = -i_276_ - -i_293_ + i_271_;
                        } else if (~i_274_ != -2) {
                           if (~i_274_ == -3) {
                              i_295_ = -i_294_ - (-i_277_ - i_273_ + -8);
                              i_296_ = -i_293_ - -i_276_ + 8 + i_271_;
                           } else {
                              i_295_ = i_273_ + i_293_ + -i_276_;
                              i_296_ = i_271_ + 8 - (i_294_ + -i_277_);
                           }
                        } else {
                           i_296_ = i_294_ - (i_277_ - i_271_);
                           i_295_ = 8 + i_273_ + i_276_ + -i_293_;
                        }

                        if (i_296_ >= 0 && this.mapSizeX > i_296_ && i_295_ >= 0 && this.mapSizeY > i_295_) {
                           this.tileHeights[i][i_296_][i_295_] = this.tileHeights[i][i_284_ + i_289_][i_290_ - -i_285_];
                        }
                     }
                  }
               } else {
                  this.decodeMapDefinitions(0, -1, 0, -1, 0, buffer, 0, 0, 0, false, -1);
               }
            }
         }
      }
   }

   Class277(int i, int i_297_, int i_298_, boolean bool, Class71 class71, Class58 class58) {
      this.aClass58_3536 = class58;
      this.mapSizeY = i_298_;
      this.maxPlanes = i;
      this.undermap = bool;
      this.mapSizeX = i_297_;
      this.aClass71_3512 = class71;
      this.tileRotations = new byte[this.maxPlanes][this.mapSizeX][this.mapSizeY];
      this.tileUnderlays = new byte[this.maxPlanes][this.mapSizeX][this.mapSizeY];
      this.tileOverlays = new byte[this.maxPlanes][this.mapSizeX][this.mapSizeY];
      this.tileShapes = new byte[this.maxPlanes][this.mapSizeX][this.mapSizeY];
      this.tileHeights = new int[this.maxPlanes][1 + this.mapSizeX][this.mapSizeY - -1];
   }
}
