public class Class274 implements d {
   private Index aClass302_4966;
   private TextureDefinitions[] loadedTextures;
   static int anInt4968;
   static int anInt4969;
   static int anInt4970;
   static Class56 aClass56_4971 = new Class56();
   static int anInt4972;
   static int anInt4973;
   static int anInt4974;
   static Class124 aClass124_4975 = new Class124(15);
   private int totalTextures;
   static int anInt4977;
   static int anInt4978;
   private Class335 aClass335_4979 = new Class335(256);
   static int anInt4980;
   static GLSprite aGLSprite4981;
   private Index aClass302_4982;

   private final CacheNode_Sub19 method3322(int i, byte b) {
      ++anInt4972;
      CacheNode cachenode = this.aClass335_4979.method3849((long)i, true);
      if (cachenode != null) {
         return (CacheNode_Sub19)cachenode;
      } else {
         int i_0_ = -93 % ((30 - b) / 39);
         byte[] bs = this.aClass302_4966.method3518((byte)-128, i);
         if (bs == null) {
            return null;
         } else {
            CacheNode_Sub19 cachenode_sub19 = new CacheNode_Sub19(new Buffer(bs));
            this.aClass335_4979.method3848((byte)-128, cachenode_sub19, (long)i);
            return cachenode_sub19;
         }
      }
   }

   @Override
   public final int[] method11(int i, boolean bool, int i_1_, int i_2_, byte b, float f) {
      ++anInt4977;
      if (b != 0) {
         this.aClass302_4966 = null;
      }

      return this.method3322(i_2_, (byte)115).method2405(this.aClass302_4982, (double)f, this.loadedTextures[i_2_].brickTile, this, bool, i_1_, i, b);
   }

   @Override
   public final int getTotalTextures(int i) {
      if (i < 84) {
         this.totalTextures = 79;
      }

      ++anInt4970;
      return this.totalTextures;
   }

   static final WorldmapAreaDetail loadWorldmapAreaDetails(Index class302, int archiveId, int fileId, int i_4_) {
      ++anInt4980;
      Buffer buffer = new Buffer(class302.getFile(false, fileId, archiveId));
      WorldmapAreaDetail cachenode_sub11 = new WorldmapAreaDetail(
         fileId,
         buffer.readString(),
         buffer.readString(),
         buffer.readInt(),
         buffer.readInt(),
         ~buffer.readUnsignedByte() == -2,
         buffer.readUnsignedByte(),
         buffer.readUnsignedByte()
      );
      int i_5_ = buffer.readUnsignedByte();

      for(int i_6_ = i_4_; ~i_5_ < ~i_6_; ++i_6_) {
         cachenode_sub11.aClass312_9549
            .method3625(
               (byte)-54,
               new Node_Sub52(
                  buffer.readUnsignedByte(),
                  buffer.readUnsignedShort(),
                  buffer.readUnsignedShort(),
                  buffer.readUnsignedShort(),
                  buffer.readUnsignedShort(),
                  buffer.readUnsignedShort(),
                  buffer.readUnsignedShort(),
                  buffer.readUnsignedShort(),
                  buffer.readUnsignedShort()
               )
            );
      }

      cachenode_sub11.method2339(16);
      return cachenode_sub11;
   }

   public static void method3324(byte b) {
      aGLSprite4981 = null;
      aClass124_4975 = null;
      if (b >= -109) {
         method3324((byte)-5);
      }

      aClass56_4971 = null;
   }

   @Override
   public final boolean method7(int i, int i_7_) {
      ++anInt4969;
      CacheNode_Sub19 cachenode_sub19 = this.method3322(i_7_, (byte)81);
      if (i != 9900) {
         this.loadedTextures = null;
      }

      return cachenode_sub19 != null && cachenode_sub19.method2401(this.aClass302_4982, this, (byte)4);
   }

   @Override
   public final TextureDefinitions getTexture(int id, int junk) {
      ++anInt4978;
      if (junk != -8217) {
         this.aClass302_4982 = null;
      }

      return this.loadedTextures[id];
   }

   static final void method3325(boolean bool, int i, int i_9_, int i_10_) {
      ++anInt4973;
      if (i_9_ >= 8000 && ~i_9_ >= -48001) {
         if (i >= 112) {
            Class87.anInt1193 = i_10_;
            Class365.anInt4523 = i_9_;
            DrawableModel.aBoolean913 = bool;
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   static final void method3326(boolean bool, byte[][][] bs, int i, byte b, int i_11_, int i_12_, boolean bool_13_) {
      int i_14_ = bool ? 1 : 0;
      Node_Sub42.anInt7527 = 0;
      Class348.anInt4290 = 0;
      ++Class359.anInt4465;
      if ((i_12_ & 2) == 0) {
         for(Animable animable = Class303.anAnimableArray3827[i_14_]; animable != null; animable = animable.anAnimable5941) {
            if (!Class150_Sub1.method1658(animable, bool, bs, i, b)) {
               method3327(animable);
               if (animable.anInt5944 != -1) {
                  Class32.staticObjectsInScene[Node_Sub42.anInt7527++] = animable;
               }
            }
         }
      }

      if ((i_12_ & 1) == 0) {
         for(Animable animable = SeekableFile.anAnimableArray3884[i_14_]; animable != null; animable = animable.anAnimable5941) {
            if (!Class150_Sub1.method1658(animable, bool, bs, i, b)) {
               method3327(animable);
               if (animable.anInt5944 != -1) {
                  Class262_Sub15.animatedObjectsInScene[Class348.anInt4290++] = animable;
               }
            }
         }

         for(Animable animable = Node_Sub36.anAnimableArray7429[i_14_]; animable != null; animable = animable.anAnimable5941) {
            if (!Class150_Sub1.method1658(animable, bool, bs, i, b)) {
               if (animable.method813(0)) {
                  method3327(animable);
                  if (animable.anInt5944 != -1) {
                     Class262_Sub15.animatedObjectsInScene[Class348.anInt4290++] = animable;
                  }
               } else {
                  method3327(animable);
                  if (animable.anInt5944 != -1) {
                     Class32.staticObjectsInScene[Node_Sub42.anInt7527++] = animable;
                  }
               }
            }
         }

         if (!bool) {
            for(int i_15_ = 0; i_15_ < Class63.anInt923; ++i_15_) {
               if (!Class150_Sub1.method1658(Node_Sub52.aMobileArray7648[i_15_], bool, bs, i, b)) {
                  method3327(Node_Sub52.aMobileArray7648[i_15_]);
                  if (Node_Sub52.aMobileArray7648[i_15_].anInt5944 != -1) {
                     if (Node_Sub52.aMobileArray7648[i_15_].method813(0)) {
                        Class262_Sub15.animatedObjectsInScene[Class348.anInt4290++] = Node_Sub52.aMobileArray7648[i_15_];
                     } else {
                        Class32.staticObjectsInScene[Node_Sub42.anInt7527++] = Node_Sub52.aMobileArray7648[i_15_];
                     }
                  }
               }
            }
         }
      }

      if (Node_Sub42.anInt7527 > 0) {
         Node_Sub38_Sub26.method2876(Class32.staticObjectsInScene, 0, Node_Sub42.anInt7527 - 1);

         for(int i_16_ = 0; i_16_ < Node_Sub42.anInt7527; ++i_16_) {
            Class338.method3915(Class32.staticObjectsInScene[i_16_], true, bool_13_);
         }
      }

      if (Class239.aBoolean2932) {
         CacheNode_Sub18.aGraphicsToolkit9607.a(0, null);
      }

      if ((i_12_ & 2) == 0) {
         for(int i_17_ = Class320_Sub12.anInt8327; i_17_ < Class159.anInt1995; ++i_17_) {
            if (i_17_ >= i && bs != null) {
               int i_18_ = Class139.aBooleanArrayArray1730.length;
               if (Class238.anInt2915 + Class139.aBooleanArrayArray1730.length > Class328.SCENE_WIDTH_X) {
                  i_18_ -= Class238.anInt2915 + Class139.aBooleanArrayArray1730.length - Class328.SCENE_WIDTH_X;
               }

               int i_19_ = Class139.aBooleanArrayArray1730[0].length;
               if (Class320_Sub9.anInt8295 + Class139.aBooleanArrayArray1730[0].length > Node_Sub50.SCENE_WIDTH_Y) {
                  i_19_ -= Class320_Sub9.anInt8295 + Class139.aBooleanArrayArray1730[0].length - Node_Sub50.SCENE_WIDTH_Y;
               }

               boolean[][] bools = Class75.aBooleanArrayArray1002;
               if (Class307.aBoolean3898) {
                  if (Class188_Sub2.BOOL_FALSE) {
                     bools = Class234.aBooleanArrayArrayArray2790[i_17_];
                  }

                  for(int i_20_ = Class126.anInt1634; i_20_ < i_18_; ++i_20_) {
                     int i_21_ = i_20_ + Class238.anInt2915 - Class126.anInt1634;

                     for(int i_22_ = Node_Sub2.anInt6934; i_22_ < i_19_; ++i_22_) {
                        bools[i_20_][i_22_] = false;
                        if (Class139.aBooleanArrayArray1730[i_20_][i_22_]) {
                           int i_23_ = i_22_ + Class320_Sub9.anInt8295 - Node_Sub2.anInt6934;

                           for(int i_24_ = i_17_; i_24_ >= 0; --i_24_) {
                              if (Class175.aClass261ArrayArrayArray2099[i_24_][i_21_][i_23_] != null
                                 && Class175.aClass261ArrayArrayArray2099[i_24_][i_21_][i_23_].aByte3311 == i_17_) {
                                 if ((i_24_ < i || bs[i_24_][i_21_][i_23_] != b) && !Class313.method3649(true, i_23_, i_17_, i_21_)) {
                                    bools[i_20_][i_22_] = true;
                                    break;
                                 }

                                 bools[i_20_][i_22_] = false;
                                 break;
                              }
                           }
                        }
                     }
                  }
               }

               if (Class188_Sub2.BOOL_FALSE) {
                  if (i_11_ >= 0) {
                     Class320_Sub10.aPlaneArray8300[i_17_].method3259(0, 0, 0, null, false, i_11_, i_12_);
                  } else {
                     Class320_Sub10.aPlaneArray8300[i_17_].method3252(0, 0, 0, null, false, i_12_);
                  }

                  for(int i_25_ = 0; i_25_ < Class22.INT_ONE; ++i_25_) {
                     Class364.aClass273Array4513[i_25_].method3314(new EntityNode_Sub8(i_17_ + 1), (byte)51);
                  }
               } else if (i_11_ >= 0) {
                  Class320_Sub10.aPlaneArray8300[i_17_]
                     .method3259(Class216.anInt2551, EntityNode_Sub7.anInt6013, Node_Sub9_Sub1.anInt9656, Class75.aBooleanArrayArray1002, false, i_11_, i_12_);
               } else {
                  Class320_Sub10.aPlaneArray8300[i_17_]
                     .method3252(Class216.anInt2551, EntityNode_Sub7.anInt6013, Node_Sub9_Sub1.anInt9656, Class75.aBooleanArrayArray1002, false, i_12_);
               }
            } else {
               int i_26_ = Class139.aBooleanArrayArray1730.length;
               if (Class238.anInt2915 + Class139.aBooleanArrayArray1730.length > Class328.SCENE_WIDTH_X) {
                  i_26_ -= Class238.anInt2915 + Class139.aBooleanArrayArray1730.length - Class328.SCENE_WIDTH_X;
               }

               int i_27_ = Class139.aBooleanArrayArray1730[0].length;
               if (Class320_Sub9.anInt8295 + Class139.aBooleanArrayArray1730[0].length > Node_Sub50.SCENE_WIDTH_Y) {
                  i_27_ -= Class320_Sub9.anInt8295 + Class139.aBooleanArrayArray1730[0].length - Node_Sub50.SCENE_WIDTH_Y;
               }

               boolean[][] bools = Class75.aBooleanArrayArray1002;
               if (Class307.aBoolean3898) {
                  if (Class188_Sub2.BOOL_FALSE) {
                     bools = Class234.aBooleanArrayArrayArray2790[i_17_];
                  }

                  for(int i_28_ = Class126.anInt1634; i_28_ < i_26_; ++i_28_) {
                     int i_29_ = i_28_ + Class238.anInt2915 - Class126.anInt1634;

                     for(int i_30_ = Node_Sub2.anInt6934; i_30_ < i_27_; ++i_30_) {
                        if (Class139.aBooleanArrayArray1730[i_28_][i_30_]
                           && !Class313.method3649(true, i_30_ + Class320_Sub9.anInt8295 - Node_Sub2.anInt6934, i_17_, i_29_)) {
                           bools[i_28_][i_30_] = true;
                        } else {
                           bools[i_28_][i_30_] = false;
                        }
                     }
                  }
               }

               if (Class188_Sub2.BOOL_FALSE) {
                  if (i_11_ >= 0) {
                     Class320_Sub10.aPlaneArray8300[i_17_].method3259(0, 0, 0, null, false, i_11_, i_12_);
                  } else {
                     Class320_Sub10.aPlaneArray8300[i_17_].method3252(0, 0, 0, null, false, i_12_);
                  }

                  for(int i_31_ = 0; i_31_ < Class22.INT_ONE; ++i_31_) {
                     Class364.aClass273Array4513[i_31_].method3314(new EntityNode_Sub8(i_17_ + 1), (byte)51);
                  }
               } else if (i_11_ >= 0) {
                  Class320_Sub10.aPlaneArray8300[i_17_]
                     .method3259(Class216.anInt2551, EntityNode_Sub7.anInt6013, Node_Sub9_Sub1.anInt9656, Class75.aBooleanArrayArray1002, true, i_11_, i_12_);
               } else {
                  Class320_Sub10.aPlaneArray8300[i_17_]
                     .method3252(Class216.anInt2551, EntityNode_Sub7.anInt6013, Node_Sub9_Sub1.anInt9656, Class75.aBooleanArrayArray1002, true, i_12_);
               }
            }
         }
      }

      if (Class348.anInt4290 > 0) {
         Class34_Sub1.method382(Class262_Sub15.animatedObjectsInScene, 0, Class348.anInt4290 - 1);

         for(int i_32_ = 0; i_32_ < Class348.anInt4290; ++i_32_) {
            Class338.method3915(Class262_Sub15.animatedObjectsInScene[i_32_], true, bool_13_);
         }
      }
   }

   private static final void method3327(Animable animable) {
      CacheNode_Sub18.aGraphicsToolkit9607.H(animable.x, animable.anInt5937 + (animable.method817(2) >> 1), animable.y, Class144_Sub3.anIntArray6835);
      animable.anInt5938 = Class144_Sub3.anIntArray6835[0];
      animable.anInt5946 = Class144_Sub3.anIntArray6835[1];
      animable.anInt5944 = Class144_Sub3.anIntArray6835[2];
   }

   @Override
   public final float[] method9(int i, int i_33_, float f, byte b, int i_34_, boolean bool) {
      ++anInt4974;
      if (b >= -109) {
         method3325(true, -60, -92, -10);
      }

      return this.method3322(i_33_, (byte)-69).method2400((byte)-114, i, this, this.aClass302_4982, this.loadedTextures[i_33_].brickTile, i_34_);
   }

   @Override
   public final int[] method8(float f, int i, int i_35_, boolean bool, boolean bool_36_, int i_37_) {
      if (bool) {
         aClass124_4975 = null;
      }

      ++anInt4968;
      return this.method3322(i, (byte)-103).method2402(i_35_, (double)f, this.loadedTextures[i].brickTile, i_37_, (byte)-71, this, this.aClass302_4982);
   }

   Class274(Index class302, Index class302_38_, Index class302_39_) {
      this.aClass302_4982 = class302_39_;
      this.aClass302_4966 = class302_38_;
      Buffer buffer = new Buffer(class302.getFile(false, 0, 0));
      this.totalTextures = buffer.readUnsignedShort();
      this.loadedTextures = new TextureDefinitions[this.totalTextures];
      Class88.aString5297 = "";

      for(int i = 0; this.totalTextures > i; ++i) {
         if (buffer.readUnsignedByte() == 1) {
            this.loadedTextures[i] = new TextureDefinitions();
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].meshGround = buffer.readUnsignedByte() == 0;
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].skipTriangles = buffer.readUnsignedByte() == 1;
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].translucent = buffer.readUnsignedByte() == 1;
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].brightness = buffer.readByte();
         }
      }

      for(int i = 0; i < this.totalTextures; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].shadowFactor = buffer.readByte();
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].effect = buffer.readByte();
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].effectParam1 = buffer.readByte();
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].colorIndex = (short)buffer.readUnsignedShort();
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].speedU = buffer.readByte();
         }
      }

      for(int i = 0; i < this.totalTextures; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].speedV = buffer.readByte();
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].unknown = buffer.readUnsignedByte() == 1;
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].brickTile = buffer.readUnsignedByte() == 1;
         }
      }

      for(int i = 0; i < this.totalTextures; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].mipmaps = buffer.readByte();
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].repeatSides = buffer.readUnsignedByte() == 1;
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].repeatTop = buffer.readUnsignedByte() == 1;
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].hdr = buffer.readUnsignedByte() == 1;
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].combinedMode = buffer.readUnsignedByte();
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].effectParam2 = buffer.readInt();
         }
      }

      for(int i = 0; this.totalTextures > i; ++i) {
         if (this.loadedTextures[i] != null) {
            this.loadedTextures[i].unknown1 = buffer.readUnsignedByte();
         }
      }

      int i = 2;

      for(int j = 0; j < i * (i + 1) + 1; j += 2) {
         byte[] aByteArray1209 = Class21.index12.getFile(false, 0, Class77.method772(j, (byte)-73)[0]);
         if (aByteArray1209 != null) {
            Buffer aBuffer12 = new Buffer(aByteArray1209);
            aBuffer12.offset = Class77.method772(j, (byte)121)[1] - (Class77.method772(j, (byte)32)[1] - 3);
            Class104.method1113(aBuffer12.readString(), 22);
         }
      }

      Class92.method1038(29);
   }
}
