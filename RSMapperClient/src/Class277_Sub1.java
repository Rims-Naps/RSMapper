import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Class277_Sub1 extends Class277 {
   static int anInt8040;
   static int anInt8041;
   static int[][][] anIntArrayArrayArray8042 = new int[2][][];
   static int anInt8043;
   static int anInt8044;
   static int anInt8045;
   protected int anInt8046 = 99;
   static int anInt8047;
   static int anInt8048;
   static int anInt8049;
   static OutgoingPacket aClass318_8050 = new OutgoingPacket(29, -1);
   static int anInt8051;
   static int anInt8052;
   static Class<?> aClass8053;

   final void loadAndDrawCachedObjects(
      int regionBaseX, int regionBaseY, int i_1_, Class84[] class84s, GraphicsToolkit graphicstoolkit, byte[] bs, int regionId
   ) {
      ++anInt8052;
      if (regionId == RSMapperClient.regionId
         && RSMapperClient.editor.objectEditor.dataLoaded
         && (
            !this.undermap && RSMapperClient.editor.objectEditor.cachedObjects != null
               || this.undermap && RSMapperClient.editor.objectEditor.cachedUnderObjects != null
         )) {
         Map<Integer, ArrayList<CachedObject>> synchMap = Collections.synchronizedMap(
            this.undermap ? RSMapperClient.editor.objectEditor.cachedUnderObjects : RSMapperClient.editor.objectEditor.cachedObjects
         );
         synchronized(synchMap) {
            Iterator<Entry<Integer, ArrayList<CachedObject>>> it = Collections.synchronizedSet(synchMap.entrySet()).iterator();
            synchronized(it) {
               while(it.hasNext()) {
                  Entry<Integer, ArrayList<CachedObject>> pair = it.next();
                  int objectId = pair.getKey();

                  for(CachedObject object : pair.getValue()) {
                     int localX = Utils.getLocalXFromCoordX(object.getX(), regionId);
                     int localY = Utils.getLocalYFromCoordY(object.getY(), regionId);
                     int plane = object.getPlane();
                     if (localX > 0 && localY > 0 && localX < this.mapSizeX - 1 && localY < this.mapSizeY - 1) {
                        Class84 class84 = null;
                        if (!this.undermap) {
                           int i_15_ = plane;
                           if ((Class277.tileFlags[1][localX][localY] & 2) == 2) {
                              i_15_ = plane - 1;
                           }

                           if (i_15_ >= 0) {
                              class84 = class84s[i_15_];
                           }
                        }

                        this.drawWorldObject(object.getType(), objectId, class84, localY, graphicstoolkit, localX, object.getRotation(), -69, plane, plane, -1);
                     }
                  }
               }
            }
         }
      } else {
         if (!this.undermap
            && regionId == RSMapperClient.regionId
            && RSMapperClient.editor.objectEditor.cachedObjects == null
            && !RSMapperClient.editor.objectEditor.dataLoaded) {
            RSMapperClient.editor.objectEditor.cachedObjects = new LinkedHashMap<>();
         }

         if (this.undermap
            && regionId == RSMapperClient.regionId
            && RSMapperClient.editor.objectEditor.cachedUnderObjects == null
            && !RSMapperClient.editor.objectEditor.dataLoaded) {
            RSMapperClient.editor.objectEditor.cachedUnderObjects = new LinkedHashMap<>();
         }

         Buffer buffer = new Buffer(bs);
         int objectId = -1;

         while(true) {
            int objectIdIncrement = buffer.readSmart2(true);
            if (objectIdIncrement == 0) {
               break;
            }

            objectId += objectIdIncrement;
            ArrayList<CachedObject> objectsWithSameId = new ArrayList<>();
            int positionHash = 0;

            while(true) {
               int positionIncrement = buffer.readSmart();
               if (positionIncrement == 0) {
                  break;
               }

               positionHash += positionIncrement + -1;
               int xIncrement = (positionHash & 4086) >> 6;
               int yIncrement = positionHash & 63;
               int plane = positionHash >> 12;
               int typeRotationHash = buffer.readUnsignedByte();
               int type = typeRotationHash >> 2;
               int rotation = typeRotationHash & 3;
               if (regionId == RSMapperClient.regionId) {
                  objectsWithSameId.add(
                     new CachedObject(
                        new WorldTile(xIncrement + Utils.getRegionCoordX(regionId), yIncrement + Utils.getRegionCoordY(regionId), plane, false),
                        typeRotationHash
                     )
                  );
               }

               int localX = regionBaseX + xIncrement;
               int localY = regionBaseY + yIncrement;
               if (localX > 0 && localY > 0 && localX < this.mapSizeX - 1 && localY < this.mapSizeY - 1) {
                  Class84 class84 = null;
                  if (!this.undermap) {
                     int i_15_ = plane;
                     if ((Class277.tileFlags[1][localX][localY] & 2) == 2) {
                        i_15_ = plane - 1;
                     }

                     if (i_15_ >= 0) {
                        class84 = class84s[i_15_];
                     }

                     if (regionId == RSMapperClient.regionId) {
                        RSMapperClient.editor.objectEditor.cachedObjects.put(Integer.valueOf(objectId), objectsWithSameId);
                     }
                  } else if (this.undermap && regionId == RSMapperClient.regionId) {
                     RSMapperClient.editor.objectEditor.cachedUnderObjects.put(Integer.valueOf(objectId), objectsWithSameId);
                  }

                  this.drawWorldObject(type, objectId, class84, localY, graphicstoolkit, localX, rotation, -69, plane, plane, -1);
               }
            }
         }
      }
   }

   final void loadMapEnvironmentAndFX(int localY, Buffer buffer, int localX, GraphicsToolkit graphicstoolkit, int junk, int archiveId) {
      ++anInt8043;
      if (!this.undermap) {
         boolean bool = false;
         Class343 class343 = null;
         if (junk != 17986) {
            method3360((byte)-79, null, null, null);
         }

         while(buffer.buffer.length > buffer.offset) {
            int opcode = buffer.readUnsignedByte();
            if (opcode != 0) {
               if (opcode != 1) {
                  if (opcode != 2) {
                     if (opcode == 128) {
                        if (class343 == null) {
                           class343 = new Class343();
                        }

                        class343.method3964(buffer, -4807);
                     } else {
                        if (opcode != 129) {
                           throw new IllegalStateException("");
                        }

                        if (this.aByteArrayArrayArray3518 == null) {
                           this.aByteArrayArrayArray3518 = new byte[4][][];
                        }

                        bool = true;

                        for(int plane = 0; plane < 4; ++plane) {
                           byte b = buffer.readByte();
                           if (b == 0 && this.aByteArrayArrayArray3518[plane] != null) {
                              int i_29_ = localX;
                              int i_30_ = 64 + localX;
                              int i_31_ = localY;
                              int i_32_ = 64 + localY;
                              if (localX >= 0) {
                                 if (~localX <= ~this.mapSizeX) {
                                    i_29_ = this.mapSizeX;
                                 }
                              } else {
                                 i_29_ = 0;
                              }

                              if (localY >= 0) {
                                 if (~localY <= ~this.mapSizeY) {
                                    i_31_ = this.mapSizeY;
                                 }
                              } else {
                                 i_31_ = 0;
                              }

                              if (~i_30_ > -1) {
                                 i_30_ = 0;
                              } else if (~this.mapSizeX >= ~i_30_) {
                                 i_30_ = this.mapSizeX;
                              }

                              if (i_32_ >= 0) {
                                 if (~i_32_ <= ~this.mapSizeY) {
                                    i_32_ = this.mapSizeY;
                                 }
                              } else {
                                 i_32_ = 0;
                              }

                              while(i_30_ > i_29_) {
                                 while(i_31_ < i_32_) {
                                    this.aByteArrayArrayArray3518[plane][i_29_][i_31_] = 0;
                                    ++i_31_;
                                 }

                                 ++i_29_;
                              }
                           } else if (b != 1) {
                              if (b == 2) {
                                 if (this.aByteArrayArrayArray3518[plane] == null) {
                                    this.aByteArrayArrayArray3518[plane] = new byte[1 + this.mapSizeX][this.mapSizeY + 1];
                                 }

                                 if (plane > 0) {
                                    int i_20_ = localX;
                                    int i_21_ = localX + 64;
                                    int i_22_ = localY;
                                    int i_23_ = 64 + localY;
                                    if (~i_21_ > -1) {
                                       i_21_ = 0;
                                    } else if (this.mapSizeX <= i_21_) {
                                       i_21_ = this.mapSizeX;
                                    }

                                    if (localX >= 0) {
                                       if (localX >= this.mapSizeX) {
                                          i_20_ = this.mapSizeX;
                                       }
                                    } else {
                                       i_20_ = 0;
                                    }

                                    if (localY < 0) {
                                       i_22_ = 0;
                                    } else if (localY >= this.mapSizeY) {
                                       i_22_ = this.mapSizeY;
                                    }

                                    if (~i_23_ <= -1) {
                                       if (~i_23_ <= ~this.mapSizeY) {
                                          i_23_ = this.mapSizeY;
                                       }
                                    } else {
                                       i_23_ = 0;
                                    }

                                    System.out.println("CALLED ASSFUCK");

                                    while(~i_20_ > ~i_21_) {
                                       while(i_23_ > i_22_) {
                                          this.aByteArrayArrayArray3518[plane][i_20_][i_22_] = this.aByteArrayArrayArray3518[-1 + plane][i_20_][i_22_];
                                          ++i_22_;
                                       }

                                       ++i_20_;
                                    }
                                 }
                              }
                           } else {
                              if (this.aByteArrayArrayArray3518[plane] == null) {
                                 this.aByteArrayArrayArray3518[plane] = new byte[1 + this.mapSizeX][1 + this.mapSizeY];
                              }

                              for(int i_24_ = 0; i_24_ < 64; i_24_ += 4) {
                                 for(int i_25_ = 0; i_25_ < 64; i_25_ += 4) {
                                    byte b_26_ = buffer.readByte();

                                    for(int i_27_ = i_24_ - -localX; ~i_27_ > ~(4 + i_24_ + localX); ++i_27_) {
                                       for(int i_28_ = localY + i_25_; ~i_28_ > ~(localY + i_25_ - -4); ++i_28_) {
                                          if (~i_27_ <= -1 && ~this.mapSizeX < ~i_27_ && i_28_ >= 0 && this.mapSizeY > i_28_) {
                                             this.aByteArrayArrayArray3518[plane][i_27_][i_28_] = b_26_;
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  } else {
                     if (class343 == null) {
                        class343 = new Class343();
                     }

                     class343.method3965(buffer, true);
                  }
               } else if (RSMapperClient.editor.mapEditor.dataLoaded && archiveId == RSMapperClient.mapArchiveId) {
                  int fxcount = buffer.readUnsignedByte();
                  if (fxcount > 0) {
                     for(int i = 0; i < fxcount; ++i) {
                        buffer.readUnsignedByte();
                        buffer.readUnsignedShort();
                        buffer.readUnsignedShort();
                        buffer.readUnsignedShort();
                        int i_19_ = buffer.readUnsignedByte();
                        int i_20_ = 2 * i_19_ + 1;

                        for(int i_21_ = 0; i_21_ < i_20_; ++i_21_) {
                           buffer.readUnsignedShort();
                        }

                        buffer.readUnsignedShort();
                        int i_26_ = buffer.readUnsignedByte();
                        int anInt4110 = i_26_ & 31;
                        if (anInt4110 == 31) {
                           buffer.readUnsignedShort();
                        }
                     }
                  }
               } else {
                  int fxcount = buffer.readUnsignedByte();
                  if (fxcount > 0) {
                     for(int i = 0; i < fxcount; ++i) {
                        LightFX class326 = new LightFX(graphicstoolkit, buffer, 2, archiveId);
                        int flickerType = 1;
                        if (class326.anInt4110 == 31) {
                           flickerType = buffer.readUnsignedShort();
                           Class367 class367 = Class32.aClass359_508.method4039(flickerType, (byte)123);
                           class326.method3819(class367.anInt4538, (byte)-27, class367.anInt4536, class367.anInt4537, class367.anInt4542);
                        }

                        if (graphicstoolkit.getanInt6367() > 0) {
                           Node_Sub29 node_sub29 = class326.aNode_Sub29_4100;
                           int i_35_ = (localX << 9) + node_sub29.getReferenceX(32311);
                           int i_36_ = (localY << 9) + node_sub29.getReferenceY(27433);
                           int lX = i_35_ >> 9;
                           int lY = i_36_ >> 9;
                           if (!RSMapperClient.editor.mapEditor.dataLoaded && archiveId == RSMapperClient.mapArchiveId) {
                              RSMapperClient.editor.mapEditor.effects.get(new WorldTile(lX, lY, class326.plane, true)).setFlickerType(flickerType);
                           }

                           if (lX >= 0 && lY >= 0 && this.mapSizeX > lX && this.mapSizeY > lY) {
                              node_sub29.setReferencePositionsAndHeight(
                                 4752, i_35_, i_36_, this.tileHeights[class326.plane][lX][lY] - node_sub29.getHeight(30)
                              );
                              Class370.method4089(class326);
                           }
                        }
                     }
                  }
               }
            } else if (class343 == null) {
               class343 = new Class343(buffer, archiveId);
            } else {
               class343.decodeEnvironment(buffer, junk ^ 6194, archiveId);
            }
         }

         if (RSMapperClient.editor.mapEditor.dataLoaded && archiveId == RSMapperClient.mapArchiveId) {
            int fxcount = RSMapperClient.editor.mapEditor.effects.size();
            if (fxcount > 0) {
               for(Entry<WorldTile, CachedEffect> pair : RSMapperClient.editor.mapEditor.effects.entrySet()) {
                  CachedEffect fx = pair.getValue();
                  LightFX class326 = new LightFX();
                  int planeFlag = fx.planeflag;
                  class326.aBoolean4090 = (16 & planeFlag) != 0;
                  class326.aBoolean4102 = (planeFlag & 8) != 0;
                  class326.plane = 7 & planeFlag;
                  int referenceX = fx.referenceX;
                  int referenceY = fx.referenceY;
                  int height = fx.height;
                  int i_20_ = 2 * fx.spread + 1;
                  class326.aShortArray4105 = new short[i_20_];

                  for(int i_21_ = 0; i_21_ < class326.aShortArray4105.length; ++i_21_) {
                     int i_22_ = (short)fx.coverage[i_21_];
                     int i_23_ = i_22_ >>> 8;
                     if (i_23_ >= i_20_) {
                        i_23_ = i_20_ - 1;
                     }

                     int i_24_ = i_22_ & 0xFF;
                     if (i_24_ > i_20_ - i_23_) {
                        i_24_ = i_20_ - i_23_;
                     }

                     class326.aShortArray4105[i_21_] = (short)(i_24_ | i_23_ << 8);
                  }

                  int i_19_ = (fx.spread << Class36.INT_9) + Class135.INT_9_;
                  int color = Class85.colors != null
                     ? Class85.colors[fx.colorIndex]
                     : Class170.anIntArray2054['\uffff' & Node_Sub15_Sub2.method2560(5310, fx.colorIndex)];
                  int i_26_ = fx.flickerType2;
                  class326.anInt4094 = 1792 & i_26_ << 3;
                  class326.anInt4110 = i_26_ & 31;
                  if (class326.anInt4110 != 31) {
                     class326.method3822(0);
                  }

                  class326.method3821(graphicstoolkit, referenceY, height, referenceX, color, i_19_, 1);
                  if (class326.anInt4110 == 31) {
                     Class367 class367 = Class32.aClass359_508.method4039(fx.flickerType, (byte)123);
                     class326.method3819(class367.anInt4538, (byte)-27, class367.anInt4536, class367.anInt4537, class367.anInt4542);
                  }

                  if (graphicstoolkit.getanInt6367() > 0) {
                     Node_Sub29 node_sub29 = class326.aNode_Sub29_4100;
                     int i_35_ = (localX << 9) + node_sub29.getReferenceX(32311);
                     int i_36_ = (localY << 9) + node_sub29.getReferenceY(27433);
                     int lX = i_35_ >> 9;
                     int lY = i_36_ >> 9;
                     if (lX >= 0 && lY >= 0 && this.mapSizeX > lX && this.mapSizeY > lY) {
                        node_sub29.setReferencePositionsAndHeight(
                           4752, i_35_, i_36_, RSMapperClient.editor.mapEditor.heights[class326.plane][lX][lY] - node_sub29.getHeight(30)
                        );
                        Class370.method4089(class326);
                     }
                  }
               }
            }
         }

         if (class343 != null) {
            for(int i_39_ = 0; i_39_ < 8; ++i_39_) {
               for(int i_40_ = 0; i_40_ < 8; ++i_40_) {
                  int i_41_ = i_39_ + (localX >> 3);
                  int i_42_ = i_40_ + (localY >> 3);
                  if (~i_41_ <= -1 && this.mapSizeX >> 3 > i_41_ && i_42_ >= 0 && ~(this.mapSizeY >> 3) < ~i_42_) {
                     Node_Sub15_Sub3.method2563(i_42_, i_41_, (byte)-63, class343);
                  }
               }
            }
         }

         if (!bool && this.aByteArrayArrayArray3518 != null) {
            for(int i_43_ = 0; i_43_ < 4; ++i_43_) {
               if (this.aByteArrayArrayArray3518[i_43_] != null) {
                  for(int i_44_ = 0; i_44_ < 16; ++i_44_) {
                     for(int i_45_ = 0; ~i_45_ > -17; ++i_45_) {
                        int i_46_ = (localX >> 2) - -i_44_;
                        int i_47_ = (localY >> 2) - -i_45_;
                        if (~i_46_ <= -1 && ~i_46_ > -27 && ~i_47_ <= -1 && ~i_47_ > -27) {
                           this.aByteArrayArrayArray3518[i_43_][i_46_][i_47_] = 0;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   final void drawWorldObject(
      int type,
      int objectId,
      Class84 sceneClipPlaneData,
      int localY,
      GraphicsToolkit graphicstoolkit,
      int localX,
      int rotation,
      int i_52_,
      int referencesPlane,
      int realPlane,
      int animationId
   ) {
      ++anInt8048;
      if (Class213.aNode_Sub27_2512.aClass320_Sub19_7301.method3751(false) != 0 || Class369.method4085(localY, 0, Class94.anInt1249, localX, referencesPlane)) {
         if (realPlane < this.anInt8046) {
            this.anInt8046 = realPlane;
         }

         ObjectDefinition objectdefinition = Class186.aClass112_2256.getObjectDefinitionsForId(objectId, 82);
         if (Class213.aNode_Sub27_2512.aClass320_Sub30_7275.method3796(false) != 0 || !objectdefinition.aBoolean2990) {
            int sizeY;
            int sizeX;
            if (rotation != 1 && rotation != 3) {
               sizeX = objectdefinition.sizeX;
               sizeY = objectdefinition.sizeY;
            } else {
               sizeY = objectdefinition.sizeX;
               sizeX = objectdefinition.sizeY;
            }

            int i_58_;
            int i_59_;
            if (~(localX - -sizeX) >= ~this.mapSizeX) {
               i_58_ = (sizeX + 1 >> 1) + localX;
               i_59_ = (sizeX >> 1) + localX;
            } else {
               i_58_ = 1 + localX;
               i_59_ = localX;
            }

            int i_60_;
            int i_61_;
            if (this.mapSizeY < sizeY + localY) {
               i_61_ = localY - -1;
               i_60_ = localY;
            } else {
               i_60_ = localY - -(sizeY >> 1);
               i_61_ = localY + (sizeY - -1 >> 1);
            }

            Plane plane = Class320_Sub10.aPlaneArray8300[referencesPlane];
            int i_62_ = plane.getVerticeHeight(i_60_, i_59_, (byte)-118)
                  + plane.getVerticeHeight(i_60_, i_58_, (byte)-118)
                  - (-plane.getVerticeHeight(i_61_, i_59_, (byte)-118) - plane.getVerticeHeight(i_61_, i_58_, (byte)-118))
               >> 2;
            int i_63_ = (sizeX << 8) + (localX << 9);
            int i_64_ = (sizeY << 8) + (localY << 9);
            boolean bool = Class217.aBoolean2552 && !this.undermap && objectdefinition.aBoolean3053;
            if (objectdefinition.method3040(-4617)) {
               Class262_Sub1.method3150(realPlane, null, localX, localY, null, objectdefinition, rotation);
            }

            boolean bool_65_ = animationId == -1
               && !objectdefinition.animationsAreNotNull()
               && objectdefinition.anIntArray2984 == null
               && !objectdefinition.aBoolean2998
               && !objectdefinition.aBoolean2992;
            if (!LightFX.aBoolean4109
               || (!r.method2361(type, 35) || objectdefinition.anInt2977 == 1)
                  && (!Node_Sub38_Sub18.method2844(type, true) || objectdefinition.anInt2977 != 0)) {
               if (type == 22) {
                  if (Class213.aNode_Sub27_2512.aClass320_Sub6_7267.method3701(false) != 0
                     || objectdefinition.anInt3057 != 0
                     || objectdefinition.clipType == 1
                     || objectdefinition.aBoolean3051) {
                     Animable_Sub1 animable_sub1;
                     if (!bool_65_) {
                        animable_sub1 = new Animable_Sub1_Sub2(
                           graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, rotation, animationId
                        );
                     } else {
                        Animable_Sub1_Sub1 animable_sub1_sub1 = new Animable_Sub1_Sub1(
                           graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, rotation, bool
                        );
                        animable_sub1 = animable_sub1_sub1;
                        if (animable_sub1_sub1.method73(-19717)) {
                           animable_sub1_sub1.method74(graphicstoolkit, -81);
                        }
                     }

                     ObjectDefinition.method3036(realPlane, localX, localY, animable_sub1);
                     if (objectdefinition.clipType == 1 && sceneClipPlaneData != null) {
                        sceneClipPlaneData.method994(localY, localX, -62);
                     }
                  }
               } else if (type != 10 && type != 11) {
                  if ((type < 12 || type > 17) && (type < 18 || type > 21)) {
                     if (type == 0) {
                        int i_70_ = objectdefinition.anInt2977;
                        if (Class291_Sub1.aBoolean8188 && objectdefinition.anInt2977 == -1) {
                           i_70_ = 1;
                        }

                        Animable_Sub2 animable_sub2;
                        if (bool_65_) {
                           Animable_Sub2_Sub2 animable_sub2_sub2 = new Animable_Sub2_Sub2(
                              graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, type, rotation, bool
                           );
                           animable_sub2 = animable_sub2_sub2;
                           if (animable_sub2_sub2.method73(-19717)) {
                              animable_sub2_sub2.method74(graphicstoolkit, -113);
                           }
                        } else {
                           animable_sub2 = new Animable_Sub2_Sub1(
                              graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, type, rotation, animationId
                           );
                        }

                        Class320_Sub27.method3781(realPlane, localX, localY, animable_sub2, null);
                        if (rotation != 0) {
                           if (rotation == 1) {
                              if (Class217.aBoolean2552 && objectdefinition.aBoolean3033) {
                                 plane.ka(localX, localY + 1, 50);
                                 plane.ka(1 + localX, localY - -1, 50);
                              }

                              if (~i_70_ == -2 && !this.undermap) {
                                 Class320_Sub6.method3703(2, (byte)86, -objectdefinition.anInt2962, 1 + localY, localX, realPlane, objectdefinition.anInt3032);
                              }
                           } else if (rotation != 2) {
                              if (rotation == 3) {
                                 if (Class217.aBoolean2552 && objectdefinition.aBoolean3033) {
                                    plane.ka(localX, localY, 50);
                                    plane.ka(1 + localX, localY, 50);
                                 }

                                 if (~i_70_ == -2 && !this.undermap) {
                                    Class320_Sub6.method3703(2, (byte)109, objectdefinition.anInt2962, localY, localX, realPlane, objectdefinition.anInt3032);
                                 }
                              }
                           } else {
                              if (Class217.aBoolean2552 && objectdefinition.aBoolean3033) {
                                 plane.ka(localX + 1, localY, 50);
                                 plane.ka(localX + 1, 1 + localY, 50);
                              }

                              if (i_70_ == 1 && !this.undermap) {
                                 Class320_Sub6.method3703(1, (byte)83, -objectdefinition.anInt2962, localY, 1 + localX, realPlane, objectdefinition.anInt3032);
                              }
                           }
                        } else {
                           if (Class217.aBoolean2552 && objectdefinition.aBoolean3033) {
                              plane.ka(localX, localY, 50);
                              plane.ka(localX, 1 + localY, 50);
                           }

                           if (~i_70_ == -2 && !this.undermap) {
                              Class320_Sub6.method3703(1, (byte)53, objectdefinition.anInt2962, localY, localX, realPlane, objectdefinition.anInt3032);
                           }
                        }

                        if (~objectdefinition.clipType != -1 && sceneClipPlaneData != null) {
                           sceneClipPlaneData.method986(106, objectdefinition.aBoolean3034, !objectdefinition.aBoolean3016, localY, rotation, type, localX);
                        }

                        if (~objectdefinition.anInt3011 != -65) {
                           Class320_Sub17.method3746(realPlane, localX, localY, objectdefinition.anInt3011);
                        }
                     } else if (type == 1) {
                        Animable_Sub2 animable_sub2;
                        if (!bool_65_) {
                           animable_sub2 = new Animable_Sub2_Sub1(
                              graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, type, rotation, animationId
                           );
                        } else {
                           Animable_Sub2_Sub2 animable_sub2_sub2 = new Animable_Sub2_Sub2(
                              graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, type, rotation, bool
                           );
                           animable_sub2 = animable_sub2_sub2;
                           if (animable_sub2_sub2.method73(-19717)) {
                              animable_sub2_sub2.method74(graphicstoolkit, -68);
                           }
                        }

                        Class320_Sub27.method3781(realPlane, localX, localY, animable_sub2, null);
                        if (objectdefinition.aBoolean3033 && Class217.aBoolean2552) {
                           if (~rotation == -1) {
                              plane.ka(localX, localY - -1, 50);
                           } else if (~rotation != -2) {
                              if (~rotation == -3) {
                                 plane.ka(localX + 1, localY, 50);
                              } else if (rotation == 3) {
                                 plane.ka(localX, localY, 50);
                              }
                           } else {
                              plane.ka(1 + localX, localY - -1, 50);
                           }
                        }

                        if (objectdefinition.clipType != 0 && sceneClipPlaneData != null) {
                           sceneClipPlaneData.method986(76, objectdefinition.aBoolean3034, !objectdefinition.aBoolean3016, localY, rotation, type, localX);
                        }
                     } else if (type == 2) {
                        int i_71_ = 3 & 1 + rotation;
                        Animable_Sub2 animable_sub2;
                        Animable_Sub2 animable_sub2_72_;
                        if (!bool_65_) {
                           animable_sub2_72_ = new Animable_Sub2_Sub1(
                              graphicstoolkit,
                              objectdefinition,
                              realPlane,
                              referencesPlane,
                              i_63_,
                              i_62_,
                              i_64_,
                              this.undermap,
                              type,
                              4 + rotation,
                              animationId
                           );
                           animable_sub2 = new Animable_Sub2_Sub1(
                              graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, type, i_71_, animationId
                           );
                        } else {
                           Animable_Sub2_Sub2 animable_sub2_sub2 = new Animable_Sub2_Sub2(
                              graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, type, rotation + 4, bool
                           );
                           Animable_Sub2_Sub2 animable_sub2_sub2_73_ = new Animable_Sub2_Sub2(
                              graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, type, i_71_, bool
                           );
                           if (animable_sub2_sub2.method73(-19717)) {
                              animable_sub2_sub2.method74(graphicstoolkit, -62);
                           }

                           animable_sub2 = animable_sub2_sub2_73_;
                           if (animable_sub2_sub2_73_.method73(-19717)) {
                              animable_sub2_sub2_73_.method74(graphicstoolkit, -57);
                           }

                           animable_sub2_72_ = animable_sub2_sub2;
                        }

                        Class320_Sub27.method3781(realPlane, localX, localY, animable_sub2_72_, animable_sub2);
                        if ((objectdefinition.anInt2977 == 1 || Class291_Sub1.aBoolean8188 && objectdefinition.anInt2977 == -1) && !this.undermap) {
                           if (rotation == 0) {
                              Class320_Sub6.method3703(1, (byte)110, objectdefinition.anInt2962, localY, localX, realPlane, objectdefinition.anInt3032);
                              Class320_Sub6.method3703(2, (byte)106, objectdefinition.anInt2962, 1 + localY, localX, realPlane, objectdefinition.anInt3032);
                           } else if (rotation == 1) {
                              Class320_Sub6.method3703(1, (byte)42, objectdefinition.anInt2962, localY, localX + 1, realPlane, objectdefinition.anInt3032);
                              Class320_Sub6.method3703(2, (byte)37, objectdefinition.anInt2962, 1 + localY, localX, realPlane, objectdefinition.anInt3032);
                           } else if (rotation == 2) {
                              Class320_Sub6.method3703(1, (byte)117, objectdefinition.anInt2962, localY, 1 + localX, realPlane, objectdefinition.anInt3032);
                              Class320_Sub6.method3703(2, (byte)55, objectdefinition.anInt2962, localY, localX, realPlane, objectdefinition.anInt3032);
                           } else if (rotation == 3) {
                              Class320_Sub6.method3703(1, (byte)95, objectdefinition.anInt2962, localY, localX, realPlane, objectdefinition.anInt3032);
                              Class320_Sub6.method3703(2, (byte)44, objectdefinition.anInt2962, localY, localX, realPlane, objectdefinition.anInt3032);
                           }
                        }

                        if (objectdefinition.clipType != 0 && sceneClipPlaneData != null) {
                           sceneClipPlaneData.method986(-35, objectdefinition.aBoolean3034, !objectdefinition.aBoolean3016, localY, rotation, type, localX);
                        }

                        if (objectdefinition.anInt3011 != 64) {
                           Class320_Sub17.method3746(realPlane, localX, localY, objectdefinition.anInt3011);
                        }
                     } else if (type == 3) {
                        Animable_Sub2 animable_sub2;
                        if (!bool_65_) {
                           animable_sub2 = new Animable_Sub2_Sub1(
                              graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, type, rotation, animationId
                           );
                        } else {
                           Animable_Sub2_Sub2 animable_sub2_sub2 = new Animable_Sub2_Sub2(
                              graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, type, rotation, bool
                           );
                           if (animable_sub2_sub2.method73(-19717)) {
                              animable_sub2_sub2.method74(graphicstoolkit, -63);
                           }

                           animable_sub2 = animable_sub2_sub2;
                        }

                        Class320_Sub27.method3781(realPlane, localX, localY, animable_sub2, null);
                        if (objectdefinition.aBoolean3033 && Class217.aBoolean2552) {
                           if (~rotation != -1) {
                              if (~rotation != -2) {
                                 if (~rotation != -3) {
                                    if (rotation == 3) {
                                       plane.ka(localX, localY, 50);
                                    }
                                 } else {
                                    plane.ka(localX - -1, localY, 50);
                                 }
                              } else {
                                 plane.ka(localX - -1, localY - -1, 50);
                              }
                           } else {
                              plane.ka(localX, 1 + localY, 50);
                           }
                        }

                        if (~objectdefinition.clipType != -1 && sceneClipPlaneData != null) {
                           sceneClipPlaneData.method986(-43, objectdefinition.aBoolean3034, !objectdefinition.aBoolean3016, localY, rotation, type, localX);
                        }
                     } else if (type == 9) {
                        Mobile mobile;
                        if (!bool_65_) {
                           mobile = new Mobile_Sub3(
                              graphicstoolkit,
                              objectdefinition,
                              realPlane,
                              referencesPlane,
                              i_63_,
                              i_62_,
                              i_64_,
                              this.undermap,
                              localX,
                              -1 + sizeX + localX,
                              localY,
                              sizeY + localY + -1,
                              type,
                              rotation,
                              animationId
                           );
                        } else {
                           Mobile_Sub2 mobile_sub2 = new Mobile_Sub2(
                              graphicstoolkit,
                              objectdefinition,
                              realPlane,
                              referencesPlane,
                              i_63_,
                              i_62_,
                              i_64_,
                              this.undermap,
                              localX,
                              localX,
                              localY,
                              localY,
                              type,
                              rotation,
                              bool
                           );
                           if (mobile_sub2.method73(-19717)) {
                              mobile_sub2.method74(graphicstoolkit, -114);
                           }

                           mobile = mobile_sub2;
                        }

                        Node_Sub38_Sub7.method2810(mobile, false);
                        if (objectdefinition.anInt2977 == 1 && !this.undermap) {
                           int i_74_;
                           if ((1 & rotation) == 0) {
                              i_74_ = 8;
                           } else {
                              i_74_ = 16;
                           }

                           Class320_Sub6.method3703(i_74_, (byte)65, 0, localY, localX, realPlane, objectdefinition.anInt3032);
                        }

                        if (objectdefinition.clipType != 0 && sceneClipPlaneData != null) {
                           sceneClipPlaneData.method996(localX, sizeY, 1, localY, !objectdefinition.aBoolean3016, sizeX, objectdefinition.aBoolean3034);
                        }

                        if (~objectdefinition.anInt3011 != -65) {
                           Class320_Sub17.method3746(realPlane, localX, localY, objectdefinition.anInt3011);
                        }
                     } else if (type == 4) {
                        Animable_Sub4 animable_sub4;
                        if (bool_65_) {
                           Animable_Sub4_Sub1 animable_sub4_sub1 = new Animable_Sub4_Sub1(
                              graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, 0, 0, type, rotation
                           );
                           if (animable_sub4_sub1.method73(-19717)) {
                              animable_sub4_sub1.method74(graphicstoolkit, -59);
                           }

                           animable_sub4 = animable_sub4_sub1;
                        } else {
                           animable_sub4 = new Animable_Sub4_Sub2(
                              graphicstoolkit,
                              objectdefinition,
                              realPlane,
                              referencesPlane,
                              i_63_,
                              i_62_,
                              i_64_,
                              this.undermap,
                              0,
                              0,
                              type,
                              rotation,
                              animationId
                           );
                        }

                        Class320_Sub6.method3705(realPlane, localX, localY, animable_sub4, null);
                     } else if (type == 5) {
                        int i_75_ = 65;
                        WorldObject interface19 = (WorldObject)Node_Sub38_Sub12.method2830(realPlane, localX, localY);
                        if (interface19 != null) {
                           i_75_ = 1 + Class186.aClass112_2256.getObjectDefinitionsForId(interface19.getId(-32136), 32).anInt3011;
                        }

                        Animable_Sub4 animable_sub4;
                        if (!bool_65_) {
                           animable_sub4 = new Animable_Sub4_Sub2(
                              graphicstoolkit,
                              objectdefinition,
                              realPlane,
                              referencesPlane,
                              i_63_,
                              i_62_,
                              i_64_,
                              this.undermap,
                              Node_Sub38.anIntArray7452[rotation] * i_75_,
                              i_75_ * PlayerUpdateReference.anIntArray4083[rotation],
                              type,
                              rotation,
                              animationId
                           );
                        } else {
                           Animable_Sub4_Sub1 animable_sub4_sub1 = new Animable_Sub4_Sub1(
                              graphicstoolkit,
                              objectdefinition,
                              realPlane,
                              referencesPlane,
                              i_63_,
                              i_62_,
                              i_64_,
                              this.undermap,
                              Node_Sub38.anIntArray7452[rotation] * i_75_,
                              PlayerUpdateReference.anIntArray4083[rotation] * i_75_,
                              type,
                              rotation
                           );
                           if (animable_sub4_sub1.method73(-19717)) {
                              animable_sub4_sub1.method74(graphicstoolkit, -113);
                           }

                           animable_sub4 = animable_sub4_sub1;
                        }

                        Class320_Sub6.method3705(realPlane, localX, localY, animable_sub4, null);
                     } else if (type == 6) {
                        int i_76_ = 33;
                        WorldObject interface19 = (WorldObject)Node_Sub38_Sub12.method2830(realPlane, localX, localY);
                        if (interface19 != null) {
                           i_76_ = 1 + Class186.aClass112_2256.getObjectDefinitionsForId(interface19.getId(-32136), 115).anInt3011 / 2;
                        }

                        Animable_Sub4 animable_sub4;
                        if (bool_65_) {
                           Animable_Sub4_Sub1 animable_sub4_sub1 = new Animable_Sub4_Sub1(
                              graphicstoolkit,
                              objectdefinition,
                              realPlane,
                              referencesPlane,
                              i_63_,
                              i_62_,
                              i_64_,
                              this.undermap,
                              Node_Sub38.anIntArray7452[rotation] * i_76_,
                              i_76_ * PlayerUpdateReference.anIntArray4083[rotation],
                              type,
                              rotation - -4
                           );
                           animable_sub4 = animable_sub4_sub1;
                           if (animable_sub4_sub1.method73(-19717)) {
                              animable_sub4_sub1.method74(graphicstoolkit, -105);
                           }
                        } else {
                           animable_sub4 = new Animable_Sub4_Sub2(
                              graphicstoolkit,
                              objectdefinition,
                              realPlane,
                              referencesPlane,
                              i_63_,
                              i_62_,
                              i_64_,
                              this.undermap,
                              Class219.anIntArray2625[rotation] * i_76_,
                              Class342.anIntArray4237[rotation] * i_76_,
                              type,
                              4 + rotation,
                              animationId
                           );
                        }

                        Class320_Sub6.method3705(realPlane, localX, localY, animable_sub4, null);
                     } else if (type == 7) {
                        int i_77_ = rotation - -2 & 3;
                        Animable_Sub4 animable_sub4;
                        if (bool_65_) {
                           Animable_Sub4_Sub1 animable_sub4_sub1 = new Animable_Sub4_Sub1(
                              graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, 0, 0, type, i_77_ + 4
                           );
                           animable_sub4 = animable_sub4_sub1;
                           if (animable_sub4_sub1.method73(-19717)) {
                              animable_sub4_sub1.method74(graphicstoolkit, -58);
                           }
                        } else {
                           animable_sub4 = new Animable_Sub4_Sub2(
                              graphicstoolkit,
                              objectdefinition,
                              realPlane,
                              referencesPlane,
                              i_63_,
                              i_62_,
                              i_64_,
                              this.undermap,
                              0,
                              0,
                              type,
                              i_77_ + 4,
                              animationId
                           );
                        }

                        Class320_Sub6.method3705(realPlane, localX, localY, animable_sub4, null);
                     } else if (type == 8) {
                        int i_79_ = 2 + rotation & 3;
                        int i_80_ = 33;
                        WorldObject interface19 = (WorldObject)Node_Sub38_Sub12.method2830(realPlane, localX, localY);
                        if (interface19 != null) {
                           i_80_ = Class186.aClass112_2256.getObjectDefinitionsForId(interface19.getId(-32136), 92).anInt3011 / 2 - -1;
                        }

                        Animable_Sub4 animable_sub4;
                        Animable_Sub4 animable_sub4_81_;
                        if (!bool_65_) {
                           Animable_Sub4_Sub2 animable_sub4_sub2 = new Animable_Sub4_Sub2(
                              graphicstoolkit,
                              objectdefinition,
                              realPlane,
                              referencesPlane,
                              i_63_,
                              i_62_,
                              i_64_,
                              this.undermap,
                              Class219.anIntArray2625[rotation] * i_80_,
                              Class342.anIntArray4237[rotation] * i_80_,
                              type,
                              rotation - -4,
                              animationId
                           );
                           animable_sub4_81_ = animable_sub4_sub2;
                           Animable_Sub4_Sub2 animable_sub4_sub2_82_ = new Animable_Sub4_Sub2(
                              graphicstoolkit,
                              objectdefinition,
                              realPlane,
                              referencesPlane,
                              i_63_,
                              i_62_,
                              i_64_,
                              this.undermap,
                              0,
                              0,
                              type,
                              4 + i_79_,
                              animationId
                           );
                           animable_sub4 = animable_sub4_sub2_82_;
                        } else {
                           Animable_Sub4_Sub1 animable_sub4_sub1 = new Animable_Sub4_Sub1(
                              graphicstoolkit,
                              objectdefinition,
                              realPlane,
                              referencesPlane,
                              i_63_,
                              i_62_,
                              i_64_,
                              this.undermap,
                              Class219.anIntArray2625[rotation] * i_80_,
                              Class342.anIntArray4237[rotation] * i_80_,
                              type,
                              4 + rotation
                           );
                           Animable_Sub4_Sub1 animable_sub4_sub1_83_ = new Animable_Sub4_Sub1(
                              graphicstoolkit, objectdefinition, realPlane, referencesPlane, i_63_, i_62_, i_64_, this.undermap, 0, 0, type, 4 + i_79_
                           );
                           if (animable_sub4_sub1.method73(-19717)) {
                              animable_sub4_sub1.method74(graphicstoolkit, -96);
                           }

                           animable_sub4 = animable_sub4_sub1_83_;
                           if (animable_sub4_sub1_83_.method73(-19717)) {
                              animable_sub4_sub1_83_.method74(graphicstoolkit, -52);
                           }

                           animable_sub4_81_ = animable_sub4_sub1;
                        }

                        Class320_Sub6.method3705(realPlane, localX, localY, animable_sub4_81_, animable_sub4);
                     }
                  } else {
                     Mobile mobile;
                     if (bool_65_) {
                        Mobile_Sub2 mobile_sub2 = new Mobile_Sub2(
                           graphicstoolkit,
                           objectdefinition,
                           realPlane,
                           referencesPlane,
                           i_63_,
                           i_62_,
                           i_64_,
                           this.undermap,
                           localX,
                           -1 + localX - -sizeX,
                           localY,
                           -1 + localY - -sizeY,
                           type,
                           rotation,
                           bool
                        );
                        if (mobile_sub2.method73(-19717)) {
                           mobile_sub2.method74(graphicstoolkit, -80);
                        }

                        mobile = mobile_sub2;
                     } else {
                        mobile = new Mobile_Sub3(
                           graphicstoolkit,
                           objectdefinition,
                           realPlane,
                           referencesPlane,
                           i_63_,
                           i_62_,
                           i_64_,
                           this.undermap,
                           localX,
                           -1 + sizeX + localX,
                           localY,
                           localY - (-sizeY - -1),
                           type,
                           rotation,
                           animationId
                        );
                     }

                     Node_Sub38_Sub7.method2810(mobile, false);
                     if (~objectdefinition.clipType != -1 && sceneClipPlaneData != null) {
                        sceneClipPlaneData.method996(localX, sizeY, 1, localY, !objectdefinition.aBoolean3016, sizeX, objectdefinition.aBoolean3034);
                     }
                  }
               } else {
                  Mobile_Sub2 mobile_sub2 = null;
                  Mobile mobile;
                  int i_66_;
                  if (bool_65_) {
                     Mobile_Sub2 mobile_sub2_67_ = new Mobile_Sub2(
                        graphicstoolkit,
                        objectdefinition,
                        realPlane,
                        referencesPlane,
                        i_63_,
                        i_62_,
                        i_64_,
                        this.undermap,
                        localX,
                        -1 + localX - -sizeX,
                        localY,
                        -1 + localY - -sizeY,
                        type,
                        rotation,
                        bool
                     );
                     mobile_sub2 = mobile_sub2_67_;
                     mobile = mobile_sub2_67_;
                     i_66_ = mobile_sub2_67_.method903(-78);
                  } else {
                     i_66_ = 15;
                     mobile = new Mobile_Sub3(
                        graphicstoolkit,
                        objectdefinition,
                        realPlane,
                        referencesPlane,
                        i_63_,
                        i_62_,
                        i_64_,
                        this.undermap,
                        localX,
                        -1 + localX + sizeX,
                        localY,
                        -1 + localY - -sizeY,
                        type,
                        rotation,
                        animationId
                     );
                  }

                  if (Node_Sub38_Sub7.method2810(mobile, false)) {
                     if (mobile_sub2 != null && mobile_sub2.method73(-19717)) {
                        mobile_sub2.method74(graphicstoolkit, -77);
                     }

                     if (objectdefinition.aBoolean3033 && Class217.aBoolean2552) {
                        if (i_66_ > 30) {
                           i_66_ = 30;
                        }

                        for(int i_68_ = 0; sizeX >= i_68_; ++i_68_) {
                           for(int i_69_ = 0; i_69_ <= sizeY; ++i_69_) {
                              plane.ka(i_68_ + localX, i_69_ + localY, i_66_);
                           }
                        }
                     }
                  }

                  if (objectdefinition.clipType != 0 && sceneClipPlaneData != null) {
                     sceneClipPlaneData.method996(localX, sizeY, 1, localY, !objectdefinition.aBoolean3016, sizeX, objectdefinition.aBoolean3034);
                  }
               }
            }
         }
      }
   }

   final void loadMapEnvironment(
      int i, int i_84_, GraphicsToolkit graphicstoolkit, int i_85_, Buffer buffer, int i_86_, int i_87_, int i_88_, int i_89_, int i_90_, int regionId
   ) {
      ++anInt8051;
      if (!this.undermap) {
         boolean bool = false;
         Class343 class343 = null;
         int i_91_ = 8 * (7 & i_87_);
         int i_92_ = 8 * (7 & i_85_);
         if (i_84_ != -1670) {
            aClass318_8050 = null;
         }

         while(~buffer.offset > ~buffer.buffer.length) {
            int opcode = buffer.readUnsignedByte();
            if (opcode == 0) {
               if (class343 != null) {
                  class343.decodeEnvironment(buffer, 24176, regionId);
               } else {
                  class343 = new Class343(buffer, regionId);
               }
            } else if (opcode == 1) {
               int i_94_ = buffer.readUnsignedByte();
               if (~i_94_ < -1) {
                  for(int i_95_ = 0; ~i_95_ > ~i_94_; ++i_95_) {
                     LightFX class326 = new LightFX(graphicstoolkit, buffer, 2, regionId);
                     if (class326.anInt4110 == 31) {
                        Class367 class367 = Class32.aClass359_508.method4039(buffer.readUnsignedShort(), (byte)123);
                        class326.method3819(class367.anInt4538, (byte)-27, class367.anInt4536, class367.anInt4537, class367.anInt4542);
                     }

                     if (graphicstoolkit.getanInt6367() > 0) {
                        Node_Sub29 node_sub29 = class326.aNode_Sub29_4100;
                        int i_96_ = node_sub29.getReferenceX(i_84_ + 33981) >> 9;
                        int i_97_ = node_sub29.getReferenceY(27433) >> 9;
                        if (i_89_ == class326.plane && i_96_ >= i_91_ && ~i_96_ > ~(8 + i_91_) && ~i_97_ <= ~i_92_ && i_92_ + 8 > i_97_) {
                           int i_98_ = Class17.method261(false, 4095 & node_sub29.getReferenceX(32311), 4095 & node_sub29.getReferenceY(27433), i_88_)
                              + (i << 9);
                           i_96_ = i_98_ >> 9;
                           int i_99_ = (i_90_ << 9)
                              + Node_Sub38.method2781(4095 & node_sub29.getReferenceY(i_84_ + 29103), i_88_, 4095 & node_sub29.getReferenceX(32311), 27542);
                           i_97_ = i_99_ >> 9;
                           if (~i_96_ <= -1 && i_97_ >= 0 && i_96_ < this.mapSizeX && this.mapSizeY > i_97_) {
                              node_sub29.setReferencePositionsAndHeight(
                                 i_84_ ^ -5142, i_98_, i_99_, this.tileHeights[i_89_][i_96_][i_97_] - node_sub29.getHeight(30)
                              );
                              Class370.method4089(class326);
                           }
                        }
                     }
                  }
               }
            } else if (opcode == 2) {
               if (class343 == null) {
                  class343 = new Class343();
               }

               class343.method3965(buffer, true);
            } else if (opcode == 128) {
               if (class343 == null) {
                  class343 = new Class343();
               }

               class343.method3964(buffer, -4807);
            } else {
               if (opcode != 129) {
                  throw new IllegalStateException("");
               }

               if (this.aByteArrayArrayArray3518 == null) {
                  this.aByteArrayArrayArray3518 = new byte[4][][];
               }

               for(int i_100_ = 0; i_100_ < 4; ++i_100_) {
                  byte b = buffer.readByte();
                  if (b == 0 && this.aByteArrayArrayArray3518[i_86_] != null) {
                     if (i_89_ >= i_100_) {
                        int i_101_ = i;
                        int i_102_ = 7 + i;
                        int i_103_ = i_90_;
                        if (~i > -1) {
                           i_101_ = 0;
                        } else if (~i <= ~this.mapSizeX) {
                           i_101_ = this.mapSizeX;
                        }

                        if (~i_102_ <= -1) {
                           if (i_102_ >= this.mapSizeX) {
                              i_102_ = this.mapSizeX;
                           }
                        } else {
                           i_102_ = 0;
                        }

                        int i_104_ = i_90_ + 7;
                        if (~i_90_ > -1) {
                           i_103_ = 0;
                        } else if (i_90_ >= this.mapSizeY) {
                           i_103_ = this.mapSizeY;
                        }

                        if (~i_104_ > -1) {
                           i_104_ = 0;
                        } else if (~this.mapSizeY >= ~i_104_) {
                           i_104_ = this.mapSizeY;
                        }

                        while(i_102_ > i_101_) {
                           while(i_104_ > i_103_) {
                              this.aByteArrayArrayArray3518[i_86_][i_101_][i_103_] = 0;
                              ++i_103_;
                           }

                           ++i_101_;
                        }
                     }
                  } else if (~b == -2) {
                     if (this.aByteArrayArrayArray3518[i_86_] == null) {
                        this.aByteArrayArrayArray3518[i_86_] = new byte[this.mapSizeX - -1][this.mapSizeY - -1];
                     }

                     for(int i_105_ = 0; i_105_ < 64; i_105_ += 4) {
                        for(int i_106_ = 0; i_106_ < 64; i_106_ += 4) {
                           byte b_107_ = buffer.readByte();
                           if (~i_89_ <= ~i_100_) {
                              for(int i_108_ = i_105_; ~i_108_ > ~(i_105_ - -4); ++i_108_) {
                                 for(int i_109_ = i_106_; ~(4 + i_106_) < ~i_109_; ++i_109_) {
                                    if (~i_108_ <= ~i_91_ && 8 + i_91_ > i_108_ && i_109_ >= i_92_ && ~(i_92_ - -8) < ~i_109_) {
                                       int i_110_ = i + Class339.method3921(7 & i_108_, i_109_ & 7, 7, i_88_);
                                       int i_111_ = i_90_ - -Class280.method3378(7 & i_109_, i_108_ & 7, (byte)125, i_88_);
                                       if (i_110_ >= 0 && i_110_ < this.mapSizeX && ~i_111_ <= -1 && i_111_ < this.mapSizeY) {
                                          this.aByteArrayArrayArray3518[i_86_][i_110_][i_111_] = b_107_;
                                          bool = true;
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         if (class343 != null) {
            Node_Sub15_Sub3.method2563(i_90_ >> 3, i >> 3, (byte)-50, class343);
         }

         if (!bool && this.aByteArrayArrayArray3518 != null && this.aByteArrayArrayArray3518[i_86_] != null) {
            int i_112_ = i - -7;
            int i_113_ = i_90_ - -7;

            for(int i_114_ = i; i_114_ < i_112_; ++i_114_) {
               for(int i_115_ = i_90_; i_115_ < i_113_; ++i_115_) {
                  this.aByteArrayArrayArray3518[i_86_][i_114_][i_115_] = 0;
               }
            }
         }
      }
   }

   static final WorldObject getWorldObjectWithTypeAtCoordinates(int x, int y, int plane, int typeFlag, boolean fullSearch) {
      ++anInt8049;
      WorldObject interface19 = null;

      try {
         if (typeFlag == 0) {
            interface19 = (WorldObject)Node_Sub38_Sub12.method2830(plane, x, y);
         }

         if (typeFlag == 1) {
            interface19 = (WorldObject)CacheNode_Sub8.method2320(plane, x, y);
            if (interface19 == null && fullSearch) {
               interface19 = (WorldObject)Class328.method3827(plane, x, y);
            }
         }

         if (typeFlag == 2) {
            interface19 = (WorldObject)Class262_Sub20.method3203(plane, x, y, aClass8053 != null ? aClass8053 : (aClass8053 = method3361("WorldObject")));
            if (interface19 == null && fullSearch) {
               interface19 = (WorldObject)CacheNode_Sub8.method2320(plane, x, y);
            }
         }

         if (typeFlag == 3) {
            interface19 = (WorldObject)Class270_Sub1_Sub1.method3303(plane, x, y);
         }
      } catch (Exception var7) {
      }

      return interface19;
   }

   final void method3355(
      int i, Class84[] class84s, int plane, GraphicsToolkit graphicstoolkit, byte b, int i_121_, int i_122_, byte[] bs, int i_123_, int i_124_, int i_125_
   ) {
      ++anInt8041;
      if (b <= 8) {
         this.method3355(-100, null, -1, null, (byte)19, -94, 86, null, -54, -118, -40);
      }

      Buffer buffer = new Buffer(bs);
      int objectid = -1;

      while(true) {
         int i_127_ = buffer.readSmart2(true);
         if (i_127_ == 0) {
            return;
         }

         objectid += i_127_;
         int i_128_ = 0;

         while(true) {
            int i_129_ = buffer.readSmart();
            if (i_129_ == 0) {
               break;
            }

            i_128_ += -1 + i_129_;
            int i_130_ = 63 & i_128_;
            int i_131_ = (4092 & i_128_) >> 6;
            int i_132_ = i_128_ >> 12;
            int i_133_ = buffer.readUnsignedByte();
            int type = i_133_ >> 2;
            int i_135_ = 3 & i_133_;
            if (i_124_ == i_132_ && i <= i_131_ && ~i_131_ > ~(i + 8) && i_125_ <= i_130_ && i_130_ < 8 + i_125_) {
               ObjectDefinition objectdefinition = Class186.aClass112_2256.getObjectDefinitionsForId(objectid, 89);
               int localX = Class32.method354(objectdefinition.sizeX, 7 & i_130_, (byte)45, objectdefinition.sizeY, i_135_, i_131_ & 7, i_123_) + i_121_;
               int localY = Class275.method3336(i_123_, 7 & i_130_, objectdefinition.sizeY, i_135_, objectdefinition.sizeX, i_131_ & 7, 104) + i_122_;
               if (localX > 0 && localY > 0 && ~localX > ~(-1 + this.mapSizeX) && ~localY > ~(-1 + this.mapSizeY)) {
                  Class84 sceneClipPlaneData = null;
                  if (!this.undermap) {
                     int i_138_ = plane;
                     if ((Class277.tileFlags[1][localX][localY] & 2) == 2) {
                        i_138_ = plane - 1;
                     }

                     if (i_138_ >= 0) {
                        sceneClipPlaneData = class84s[i_138_];
                     }
                  }

                  this.drawWorldObject(type, objectid, sceneClipPlaneData, localY, graphicstoolkit, localX, 3 & i_123_ + i_135_, 84, plane, plane, -1);
               }
            }
         }
      }
   }

   final void method3356(boolean bool, GraphicsToolkit graphicstoolkit, byte b) {
      ++anInt8045;
      Class170.method1788();
      if (b != 83) {
         method3358(true);
      }

      if (!bool && ~this.maxPlanes < -2) {
         for(int i = 0; ~i > ~this.mapSizeX; ++i) {
            for(int i_139_ = 0; ~this.mapSizeY < ~i_139_; ++i_139_) {
               if ((Class277.tileFlags[1][i][i_139_] & 2) == 2) {
                  Class349.method3984(i, i_139_);
               }
            }
         }
      }
   }

   Class277_Sub1(int i, int i_151_, int i_152_, boolean bool) {
      super(i, i_151_, i_152_, bool, Class290_Sub7.aClass71_8134, r.aClass58_9578);
   }

   static final void method3357(boolean bool) {
      ClientScript.method2321(-1, Class58.aWidget861);
      ++anInt8047;
      ++RuntimeException_Sub1.anInt4916;
      if (Class372.aBoolean4599 && Class180.aBoolean2135) {
         int i = 0;
         int i_153_ = 0;
         if (Class71.aBoolean967) {
            i = Class67.method733(-99);
            i_153_ = Class226.method2112(256);
         }

         int i_154_ = i + Class106.aClass93_1356.getLastMousePosX();
         int i_155_ = Class106.aClass93_1356.getLastMousePosY(bool) + i_153_;
         i_154_ -= Node_Sub5_Sub2.anInt9412;
         i_155_ -= Class83.anInt5179;
         if (~Class62.anInt905 < ~i_154_) {
            i_154_ = Class62.anInt905;
         }

         if (Class58.aWidget861.width + i_154_ > Class62.anInt905 - -Class186.aWidget2257.width) {
            i_154_ = Class186.aWidget2257.width + Class62.anInt905 - Class58.aWidget861.width;
         }

         if (i_155_ < Class339_Sub2.anInt8650) {
            i_155_ = Class339_Sub2.anInt8650;
         }

         if (Class339_Sub2.anInt8650 + Class186.aWidget2257.height < i_155_ - -Class58.aWidget861.height) {
            i_155_ = -Class58.aWidget861.height + Class339_Sub2.anInt8650 + Class186.aWidget2257.height;
         }

         int i_156_ = Class186.aWidget2257.scrollX + -Class62.anInt905 + i_154_;
         int i_157_ = Class186.aWidget2257.scrollY + -Class339_Sub2.anInt8650 + i_155_;
         if (Class106.aClass93_1356.method1041((byte)34)) {
            if (Class58.aWidget861.anInt4795 < RuntimeException_Sub1.anInt4916) {
               int i_158_ = i_154_ - Node_Sub25_Sub4.anInt10005;
               int i_159_ = -Class60.anInt880 + i_155_;
               if (~Class58.aWidget861.anInt4708 > ~i_158_
                  || ~(-Class58.aWidget861.anInt4708) < ~i_158_
                  || ~Class58.aWidget861.anInt4708 > ~i_159_
                  || i_159_ < -Class58.aWidget861.anInt4708) {
                  Class99.aBoolean1282 = true;
               }
            }

            if (Class58.aWidget861.anObjectArray4852 != null && Class99.aBoolean1282) {
               Node_Sub37 node_sub37 = new Node_Sub37();
               node_sub37.aWidget7437 = Class58.aWidget861;
               node_sub37.anInt7439 = i_156_;
               node_sub37.notches = i_157_;
               node_sub37.parameters = Class58.aWidget861.anObjectArray4852;
               ClientScriptsExecutor.sendRunScript(node_sub37);
            }
         } else {
            if (Class99.aBoolean1282) {
               Node_Sub38_Sub23.method2863(-19316);
               if (Class58.aWidget861.anObjectArray4711 != null) {
                  Node_Sub37 node_sub37 = new Node_Sub37();
                  node_sub37.aWidget7432 = Node_Sub38_Sub14.aWidget10244;
                  node_sub37.anInt7439 = i_156_;
                  node_sub37.aWidget7437 = Class58.aWidget861;
                  node_sub37.notches = i_157_;
                  node_sub37.parameters = Class58.aWidget861.anObjectArray4711;
                  ClientScriptsExecutor.sendRunScript(node_sub37);
               }

               if (Node_Sub38_Sub14.aWidget10244 != null && Client.method109(Class58.aWidget861) != null) {
                  Class377.method4124(27547, Class58.aWidget861, Node_Sub38_Sub14.aWidget10244);
               }
            } else if ((Class121.anInt1521 == 1 || Node_Sub16.method2594(true)) && Class315.anInt4035 > 2) {
               Class244.method3064((byte)-86, Node_Sub5_Sub2.anInt9412 - -Node_Sub25_Sub4.anInt10005, Class60.anInt880 + Class83.anInt5179);
            } else if (Class46.method469(255)) {
               Class244.method3064((byte)-80, Node_Sub25_Sub4.anInt10005 + Node_Sub5_Sub2.anInt9412, Class60.anInt880 + Class83.anInt5179);
            }

            Class58.aWidget861 = null;
         }
      } else if (~RuntimeException_Sub1.anInt4916 < -2) {
         Class58.aWidget861 = null;
      }
   }

   public static void method3358(boolean bool) {
      anIntArrayArrayArray8042 = null;
      aClass318_8050 = null;
      if (bool) {
         anIntArrayArrayArray8042 = null;
      }
   }

   final void method3359(int typeFlag, byte b, int localY, Class84 sceneClipPlaneData, int plane, int localX, GraphicsToolkit graphicstoolkit) {
      ++anInt8040;
      WorldObject interface19 = getWorldObjectWithTypeAtCoordinates(localX, localY, plane, typeFlag, false);
      if (interface19 != null) {
         ObjectDefinition objectdefinition = Class186.aClass112_2256.getObjectDefinitionsForId(interface19.getId(-32136), 98);
         int i_163_ = interface19.getType(69);
         int i_164_ = interface19.getRotation(23796);
         if (objectdefinition.method3040(-4617)) {
            CacheNode_Sub14.method2348(localX, localY, plane, objectdefinition, 100);
         }

         if (interface19.method73(-19717)) {
            interface19.method70(graphicstoolkit, -88);
         }

         if (typeFlag != 0) {
            if (typeFlag == 1) {
               Class290_Sub4.method3432(plane, localX, localY);
            } else if (typeFlag != 2) {
               if (typeFlag == 3) {
                  PlayerUpdateReference.method3807(plane, localX, localY);
                  if (objectdefinition.clipType == 1) {
                     sceneClipPlaneData.method997(localY, true, localX);
                  }
               }
            } else {
               Class7.method181(plane, localX, localY, aClass8053 != null ? aClass8053 : (aClass8053 = method3361("WorldObject")));
               if (objectdefinition.clipType != 0
                  && ~this.mapSizeX < ~(objectdefinition.sizeX + localX)
                  && this.mapSizeY > objectdefinition.sizeX + localY
                  && localX + objectdefinition.sizeY < this.mapSizeX
                  && objectdefinition.sizeY + localY < this.mapSizeY) {
                  sceneClipPlaneData.method992(
                     objectdefinition.aBoolean3034,
                     !objectdefinition.aBoolean3016,
                     (byte)-106,
                     localX,
                     objectdefinition.sizeX,
                     objectdefinition.sizeY,
                     i_164_,
                     localY
                  );
               }

               if (~i_163_ == -10) {
                  if ((i_164_ & 1) == 0) {
                     Class270_Sub1_Sub1.method3302(localX, plane, (byte)117, 8, localY);
                  } else {
                     Class270_Sub1_Sub1.method3302(localX, plane, (byte)122, 16, localY);
                  }
               }
            }
         } else {
            Class290_Sub1.method3425(plane, localX, localY);
            if (objectdefinition.clipType != 0) {
               sceneClipPlaneData.method987(localY, i_164_, i_163_, (byte)-70, !objectdefinition.aBoolean3016, localX, objectdefinition.aBoolean3034);
            }

            if (~objectdefinition.anInt2977 == -2) {
               if (i_164_ != 0) {
                  if (i_164_ != 1) {
                     if (~i_164_ != -3) {
                        if (i_164_ == 3) {
                           Class270_Sub1_Sub1.method3302(localX, plane, (byte)120, 2, localY);
                        }
                     } else {
                        Class270_Sub1_Sub1.method3302(1 + localX, plane, (byte)126, 1, localY);
                     }
                  } else {
                     Class270_Sub1_Sub1.method3302(localX, plane, (byte)101, 2, localY - -1);
                  }
               } else {
                  Class270_Sub1_Sub1.method3302(localX, plane, (byte)115, 1, localY);
               }
            }
         }
      }

      if (b <= 34) {
         this.anInt8046 = -25;
      }
   }

   static final void method3360(byte b, Node_Sub14 node_sub14, GraphicsToolkit graphicstoolkit, AreaDefinitions class79) {
      ++anInt8044;
      GLSprite glsprite = class79.method787(32394, graphicstoolkit);
      if (glsprite != null) {
         int i = glsprite.method1193();
         if (~glsprite.method1176() < ~i) {
            i = glsprite.method1176();
         }

         int i_165_ = 10;
         int i_166_ = node_sub14.anInt7126;
         int i_167_ = node_sub14.anInt7118;
         int i_168_ = 0;
         int i_169_ = 0;
         int i_170_ = 0;
         if (class79.nameLabel != null) {
            i_168_ = Class85.aClass357_1159.method4029(Node_Sub38_Sub3.aStringArray10107, null, b + -84, null, class79.nameLabel);

            for(int i_171_ = 0; i_168_ > i_171_; ++i_171_) {
               String string = Node_Sub38_Sub3.aStringArray10107[i_171_];
               if (i_171_ < -1 + i_168_) {
                  string = string.substring(0, -4 + string.length());
               }

               int i_172_ = Class75.aClass299_1007.method3490(string);
               if (i_172_ > i_169_) {
                  i_169_ = i_172_;
               }
            }

            i_170_ = Class75.aClass299_1007.method3487() * i_168_ - -(Class75.aClass299_1007.method3489() / 2);
         }

         int i_173_ = i / 2 + node_sub14.anInt7126;
         if (~i_166_ > ~(WorldmapDefinitions.anInt344 + i)) {
            i_173_ = 5 + i_165_ + i / 2 + WorldmapDefinitions.anInt344 - -(i_169_ / 2);
            i_166_ = WorldmapDefinitions.anInt344;
         } else if (~(WorldmapDefinitions.anInt348 - i) > ~i_166_) {
            i_166_ = -i + WorldmapDefinitions.anInt348;
            i_173_ = WorldmapDefinitions.anInt348 - (i / 2 + i_165_ + i_169_ / 2 - -5);
         }

         int i_174_ = node_sub14.anInt7118;
         if (i + WorldmapDefinitions.anInt350 > i_167_) {
            i_174_ = i_165_ + WorldmapDefinitions.anInt350 + i / 2;
            i_167_ = WorldmapDefinitions.anInt350;
         } else if (~(WorldmapDefinitions.anInt339 + -i) > ~i_167_) {
            i_174_ = -i_165_ + -(i / 2) + WorldmapDefinitions.anInt339 + -i_170_;
            i_167_ = WorldmapDefinitions.anInt339 + -i;
         }

         int i_175_ = (int)(32767.0 * (Math.atan2((double)(i_166_ - node_sub14.anInt7126), (double)(i_167_ - node_sub14.anInt7118)) / Math.PI)) & 65535;
         glsprite.method1180((float)i_166_ + (float)i / 2.0F, (float)i_167_ + (float)i / 2.0F, 4096, i_175_);
         int i_176_ = -2;
         int i_177_ = -2;
         if (b != 43) {
            method3357(true);
         }

         int i_178_ = -2;
         int i_179_ = -2;
         if (class79.nameLabel != null) {
            i_176_ = -5 + i_173_ - i_169_ / 2;
            i_177_ = i_174_;
            i_178_ = i_169_ + i_176_ + 10;
            i_179_ = Class75.aClass299_1007.method3487() * i_168_ + i_174_ - -3;
            if (~class79.anInt1077 != -1) {
               graphicstoolkit.method1239(i_178_ + -i_176_, i_179_ - i_174_, i_174_, (byte)116, i_176_, class79.anInt1077);
            }

            if (~class79.anInt1081 != -1) {
               graphicstoolkit.method1234(i_174_, class79.anInt1081, i_178_ + -i_176_, i_179_ - i_174_, (byte)-64, i_176_);
            }

            for(int i_180_ = 0; i_168_ > i_180_; ++i_180_) {
               String string = Node_Sub38_Sub3.aStringArray10107[i_180_];
               if (~(i_168_ - 1) < ~i_180_) {
                  string = string.substring(0, -4 + string.length());
               }

               Class75.aClass299_1007.method3491(graphicstoolkit, string, i_173_, i_174_, class79.textColor, true);
               i_174_ += Class75.aClass299_1007.method3487();
            }
         }

         if (class79.spriteId != -1 || class79.nameLabel != null) {
            i >>= 1;
            Node_Sub31 node_sub31 = new Node_Sub31(node_sub14);
            node_sub31.anInt7369 = i + i_166_;
            node_sub31.anInt7366 = i_179_;
            node_sub31.anInt7371 = i_176_;
            node_sub31.anInt7374 = -i + i_166_;
            node_sub31.anInt7370 = i_167_ + i;
            node_sub31.anInt7365 = i_167_ - i;
            node_sub31.anInt7363 = i_177_;
            node_sub31.anInt7364 = i_178_;
            Node_Sub43.aClass312_7541.method3625((byte)-54, node_sub31);
         }
      }
   }

   static Class<?> method3361(String string) {
      try {
         return Class.forName(string);
      } catch (ClassNotFoundException var3) {
         throw (NoClassDefFoundError)new NoClassDefFoundError().initCause(var3);
      }
   }
}
