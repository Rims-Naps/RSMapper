package com.rs.cache.loaders;

import com.alex.io.InputStream;
import com.alex.io.OutputStream;
import com.rs.cache.Cache;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ObjectDefinitions {
   public static ConcurrentHashMap<Integer, ObjectDefinitions> objectDefinitions = new ConcurrentHashMap<>();
   public short[] originalColors;
   public int[] toObjectIds;
   public static int anInt3832;
   public int[] animations = null;
   public int positionXOffset;
   public int optionSprite1;
   public static int anInt3836;
   public byte aByte3837;
   public int mapSpriteId = -1;
   public boolean aBoolean3839;
   public int anInt3840;
   public int height;
   public static int anInt3842;
   public static int anInt3843;
   public int indexOfOptionSprite2;
   public boolean aBoolean3845;
   public static int anInt3846;
   public byte aByte3847;
   public byte aByte3849;
   public int anInt3850;
   public int mapAreaId;
   public boolean secondBool;
   public boolean hasShadow;
   public int anInt3855;
   public boolean ignoreClipOnAlternativeRoute;
   public int indexOfOptionSprite1;
   public byte[] aByteArray3858;
   public int[] anIntArray3859;
   public int anInt3860;
   public String[] options;
   public int configFileId;
   public short[] modifiedColors;
   public int anInt3865;
   public boolean aBoolean3866;
   public boolean aBoolean3867;
   public boolean projectileCliped;
   public int[] anIntArray3869;
   public boolean aBoolean3870;
   public int sizeY;
   public boolean aBoolean3872;
   public boolean aBoolean3873;
   public int thirdInt;
   public int positionZOffset;
   public int animation;
   public int positionYOffset;
   public int anInt3878;
   public int clipType;
   public int anInt3882;
   public int anInt3883;
   public Object loader;
   public int anInt3889;
   public int sizeX;
   public boolean aBoolean3891;
   public int anInt3892;
   public int secondInt;
   public boolean aBoolean3894;
   public boolean aBoolean3895;
   public int anInt3896;
   public int configId;
   public byte[] possibleTypes;
   public int anInt3900;
   public String name;
   public int widthX;
   public int anInt3904;
   public int anInt3905;
   public boolean aBoolean3906;
   public int[] anIntArray3908;
   public byte bendToPlane = -2;
   public int optionSprite2;
   public byte aByte3914;
   public int anInt3915;
   public int[][] modelIds;
   public int widthY;
   public short[] modifiedTextures;
   public short[] originalTextures;
   public int standingOnHeightOffset;
   public HashMap<Integer, Object> parameters;
   public boolean aBoolean3923;
   public boolean aBoolean3924;
   public int cflag;
   public int id;
   public int mapSpriteOffset1;
   public int mapSpriteOffset2;
   public int anInt3032;
   public int anInt2962;

   private void readValues(InputStream stream, int opcode) {
      if (opcode == 1 || opcode == 5) {
         boolean aBoolean1162 = false;
         if (opcode == 5 && aBoolean1162) {
            this.skipReadModelIds(stream);
         }

         int i_73_ = stream.readUnsignedByte();
         this.modelIds = new int[i_73_][];
         this.possibleTypes = new byte[i_73_];

         for(int i_74_ = 0; i_74_ < i_73_; ++i_74_) {
            this.possibleTypes[i_74_] = (byte)stream.readByte();
            int i_75_ = stream.readUnsignedByte();
            this.modelIds[i_74_] = new int[i_75_];

            for(int i_76_ = 0; i_75_ > i_76_; ++i_76_) {
               this.modelIds[i_74_][i_76_] = stream.readUnsignedShort();
            }
         }

         if (opcode == 5 && !aBoolean1162) {
            this.skipReadModelIds(stream);
         }
      } else if (opcode != 2) {
         if (opcode != 14) {
            if (opcode != 15) {
               if (opcode == 17) {
                  this.projectileCliped = false;
                  this.clipType = 0;
               } else if (opcode != 18) {
                  if (opcode == 19) {
                     this.secondInt = stream.readUnsignedByte();
                  } else if (opcode == 21) {
                     this.bendToPlane = 1;
                  } else if (opcode != 22) {
                     if (opcode != 23) {
                        if (opcode != 24) {
                           if (opcode == 27) {
                              this.clipType = 1;
                           } else if (opcode == 28) {
                              this.anInt3892 = stream.readUnsignedByte() << 2;
                           } else if (opcode != 29) {
                              if (opcode != 39) {
                                 if (opcode >= 30 && opcode < 35) {
                                    this.options[-30 + opcode] = stream.readString();
                                 } else if (opcode == 40) {
                                    int size = stream.readUnsignedByte();
                                    this.originalColors = new short[size];
                                    this.modifiedColors = new short[size];

                                    for(int index = 0; index < size; ++index) {
                                       this.modifiedColors[index] = (short)stream.readUnsignedShort();
                                       this.originalColors[index] = (short)stream.readUnsignedShort();
                                    }
                                 } else if (opcode != 41) {
                                    if (opcode != 42) {
                                       if (opcode != 62) {
                                          if (opcode != 64) {
                                             if (opcode == 65) {
                                                this.widthX = stream.readUnsignedShort();
                                             } else if (opcode != 66) {
                                                if (opcode != 67) {
                                                   if (opcode == 69) {
                                                      this.cflag = stream.readUnsignedByte();
                                                   } else if (opcode != 70) {
                                                      if (opcode == 71) {
                                                         this.anInt3889 = stream.readShort() << 2;
                                                      } else if (opcode != 72) {
                                                         if (opcode == 73) {
                                                            this.secondBool = true;
                                                         } else if (opcode == 74) {
                                                            this.ignoreClipOnAlternativeRoute = true;
                                                         } else if (opcode != 75) {
                                                            if (opcode == 77 || opcode == 92) {
                                                               this.configFileId = stream.readUnsignedShort();
                                                               if (this.configFileId == 65535) {
                                                                  this.configFileId = -1;
                                                               }

                                                               this.configId = stream.readUnsignedShort();
                                                               if (this.configId == 65535) {
                                                                  this.configId = -1;
                                                               }

                                                               int i_66_ = -1;
                                                               if (opcode == 92) {
                                                                  i_66_ = stream.readUnsignedShort();
                                                               }

                                                               int i_67_ = stream.readUnsignedByte();
                                                               this.toObjectIds = new int[i_67_ - -2];

                                                               for(int i_68_ = 0; i_67_ >= i_68_; ++i_68_) {
                                                                  this.toObjectIds[i_68_] = stream.readUnsignedShort();
                                                               }

                                                               this.toObjectIds[i_67_ + 1] = i_66_;
                                                            } else if (opcode == 78) {
                                                               this.anInt3860 = stream.readUnsignedShort();
                                                               this.anInt3904 = stream.readUnsignedByte();
                                                            } else if (opcode != 79) {
                                                               if (opcode == 81) {
                                                                  this.bendToPlane = 2;
                                                                  this.anInt3882 = 256 * stream.readUnsignedByte();
                                                               } else if (opcode != 82) {
                                                                  if (opcode == 88) {
                                                                     this.hasShadow = false;
                                                                  } else if (opcode != 89) {
                                                                     if (opcode == 90) {
                                                                        this.aBoolean3870 = true;
                                                                     } else if (opcode != 91) {
                                                                        if (opcode != 93) {
                                                                           if (opcode == 94) {
                                                                              this.bendToPlane = 4;
                                                                           } else if (opcode != 95) {
                                                                              if (opcode != 96) {
                                                                                 if (opcode == 97) {
                                                                                    this.aBoolean3866 = true;
                                                                                 } else if (opcode == 98) {
                                                                                    this.aBoolean3923 = true;
                                                                                 } else if (opcode == 99) {
                                                                                    this.indexOfOptionSprite1 = stream.readUnsignedByte();
                                                                                    this.optionSprite1 = stream.readUnsignedShort();
                                                                                 } else if (opcode == 100) {
                                                                                    this.indexOfOptionSprite2 = stream.readUnsignedByte();
                                                                                    this.optionSprite2 = stream.readUnsignedShort();
                                                                                 } else if (opcode != 101) {
                                                                                    if (opcode == 102) {
                                                                                       this.mapSpriteId = stream.readUnsignedShort();
                                                                                    } else if (opcode == 103) {
                                                                                       this.thirdInt = 0;
                                                                                    } else if (opcode != 104) {
                                                                                       if (opcode == 105) {
                                                                                          this.aBoolean3906 = true;
                                                                                       } else if (opcode == 106) {
                                                                                          int i_55_ = stream.readUnsignedByte();
                                                                                          this.anIntArray3869 = new int[i_55_];
                                                                                          this.animations = new int[i_55_];

                                                                                          for(int i_56_ = 0; i_56_ < i_55_; ++i_56_) {
                                                                                             this.animations[i_56_] = stream.readUnsignedShort();
                                                                                             System.out.println(this.animations[i_56_]);
                                                                                             int i_57_ = stream.readUnsignedByte();
                                                                                             this.anIntArray3869[i_56_] = i_57_;
                                                                                          }
                                                                                       } else if (opcode == 107) {
                                                                                          this.mapAreaId = stream.readUnsignedShort();
                                                                                       } else if (opcode >= 150 && opcode < 155) {
                                                                                          this.options[opcode + -150] = stream.readString();
                                                                                       } else if (opcode != 160) {
                                                                                          if (opcode == 162) {
                                                                                             this.bendToPlane = 3;
                                                                                             this.anInt3882 = stream.readInt();
                                                                                          } else if (opcode == 163) {
                                                                                             this.aByte3847 = (byte)stream.readByte();
                                                                                             this.aByte3849 = (byte)stream.readByte();
                                                                                             this.aByte3837 = (byte)stream.readByte();
                                                                                             this.aByte3914 = (byte)stream.readByte();
                                                                                          } else if (opcode != 164) {
                                                                                             if (opcode != 165) {
                                                                                                if (opcode != 166) {
                                                                                                   if (opcode == 167) {
                                                                                                      this.standingOnHeightOffset = stream.readUnsignedShort();
                                                                                                   } else if (opcode != 168) {
                                                                                                      if (opcode == 169) {
                                                                                                         this.aBoolean3845 = true;
                                                                                                      } else if (opcode == 170) {
                                                                                                         this.anInt3032 = stream.readUnsignedSmart();
                                                                                                      } else if (opcode == 171) {
                                                                                                         this.anInt2962 = stream.readUnsignedSmart();
                                                                                                      } else if (opcode == 173) {
                                                                                                         this.mapSpriteOffset1 = stream.readUnsignedShort();
                                                                                                         this.mapSpriteOffset2 = stream.readUnsignedShort();
                                                                                                      } else if (opcode != 177) {
                                                                                                         if (opcode == 178) {
                                                                                                            stream.readUnsignedByte();
                                                                                                         } else if (opcode != 189 && opcode == 249) {
                                                                                                            int length = stream.readUnsignedByte();
                                                                                                            if (this.parameters == null) {
                                                                                                               this.parameters = new HashMap<>(length);
                                                                                                            }

                                                                                                            for(int i_60_ = 0; i_60_ < length; ++i_60_) {
                                                                                                               boolean bool = stream.readUnsignedByte() == 1;
                                                                                                               int key = stream.read24BitInt();
                                                                                                               if (!bool) {
                                                                                                                  int value = stream.readInt();
                                                                                                                  this.parameters.put(key, value);
                                                                                                               } else {
                                                                                                                  String value = stream.readString();
                                                                                                                  this.parameters.put(key, value);
                                                                                                               }
                                                                                                            }
                                                                                                         }
                                                                                                      }
                                                                                                   } else {
                                                                                                      this.aBoolean3894 = true;
                                                                                                   }
                                                                                                } else {
                                                                                                   this.positionYOffset = stream.readShort();
                                                                                                }
                                                                                             } else {
                                                                                                this.positionZOffset = stream.readShort();
                                                                                             }
                                                                                          } else {
                                                                                             this.positionXOffset = stream.readShort();
                                                                                          }
                                                                                       } else {
                                                                                          int i_62_ = stream.readUnsignedByte();
                                                                                          this.anIntArray3908 = new int[i_62_];

                                                                                          for(int i_63_ = 0; i_62_ > i_63_; ++i_63_) {
                                                                                             this.anIntArray3908[i_63_] = stream.readUnsignedShort();
                                                                                          }
                                                                                       }
                                                                                    } else {
                                                                                       this.anInt3865 = stream.readUnsignedByte();
                                                                                    }
                                                                                 } else {
                                                                                    this.anInt3850 = stream.readUnsignedByte();
                                                                                 }
                                                                              } else {
                                                                                 this.aBoolean3924 = true;
                                                                              }
                                                                           } else {
                                                                              this.bendToPlane = 5;
                                                                              this.anInt3882 = stream.readShort();
                                                                           }
                                                                        } else {
                                                                           this.bendToPlane = 3;
                                                                           this.anInt3882 = stream.readUnsignedShort();
                                                                        }
                                                                     } else {
                                                                        this.aBoolean3873 = true;
                                                                     }
                                                                  } else {
                                                                     this.aBoolean3895 = false;
                                                                  }
                                                               } else {
                                                                  this.aBoolean3891 = true;
                                                               }
                                                            } else {
                                                               this.anInt3900 = stream.readUnsignedShort();
                                                               this.anInt3905 = stream.readUnsignedShort();
                                                               this.anInt3904 = stream.readUnsignedByte();
                                                               int i_64_ = stream.readUnsignedByte();
                                                               this.anIntArray3859 = new int[i_64_];

                                                               for(int i_65_ = 0; i_65_ < i_64_; ++i_65_) {
                                                                  this.anIntArray3859[i_65_] = stream.readUnsignedShort();
                                                               }
                                                            }
                                                         } else {
                                                            this.anInt3855 = stream.readUnsignedByte();
                                                         }
                                                      } else {
                                                         this.anInt3915 = stream.readShort() << 2;
                                                      }
                                                   } else {
                                                      this.anInt3883 = stream.readShort() << 2;
                                                   }
                                                } else {
                                                   this.widthY = stream.readUnsignedShort();
                                                }
                                             } else {
                                                this.height = stream.readUnsignedShort();
                                             }
                                          } else {
                                             this.aBoolean3872 = false;
                                          }
                                       } else {
                                          this.aBoolean3839 = true;
                                       }
                                    } else {
                                       int i_69_ = stream.readUnsignedByte();
                                       this.aByteArray3858 = new byte[i_69_];

                                       for(int i_70_ = 0; i_70_ < i_69_; ++i_70_) {
                                          this.aByteArray3858[i_70_] = (byte)stream.readByte();
                                       }
                                    }
                                 } else {
                                    int size = stream.readUnsignedByte();
                                    this.originalTextures = new short[size];
                                    this.modifiedTextures = new short[size];

                                    for(int index = 0; size > index; ++index) {
                                       this.modifiedTextures[index] = (short)stream.readUnsignedShort();
                                       this.originalTextures[index] = (short)stream.readUnsignedShort();
                                    }
                                 }
                              } else {
                                 this.anInt3840 = stream.readByte() * 5;
                              }
                           } else {
                              this.anInt3878 = stream.readByte();
                           }
                        } else {
                           this.animation = stream.readUnsignedShort();
                        }
                     } else {
                        this.thirdInt = 1;
                     }
                  } else {
                     this.aBoolean3867 = true;
                  }
               } else {
                  this.projectileCliped = false;
               }
            } else {
               this.sizeY = stream.readUnsignedByte();
            }
         } else {
            this.sizeX = stream.readUnsignedByte();
         }
      } else {
         this.name = stream.readString();
      }
   }

   private void skipReadModelIds(InputStream stream) {
      int length = stream.readUnsignedByte();

      for(int index = 0; index < length; ++index) {
         stream.skip(1);
         int length2 = stream.readUnsignedByte();

         for(int i = 0; i < length2; ++i) {
            stream.readUnsignedShort();
         }
      }
   }

   private void readValueLoop(InputStream stream) {
      while(true) {
         int opcode = stream.readUnsignedByte();
         if (opcode == 0) {
            return;
         }

         this.readValues(stream, opcode);
      }
   }

   public byte[] encode() {
      OutputStream out = new OutputStream();
      if (this.modelIds != null) {
         out.writeByte(1);
         out.writeByte(this.modelIds.length);

         for(int i = 0; i < this.modelIds.length; ++i) {
            out.writeByte(this.possibleTypes[i]);
            int[] models = this.modelIds[i];
            out.writeByte(models.length);

            for(int index = 0; index < models.length; ++index) {
               out.writeShort(models[index]);
            }
         }
      }

      if (this.name != null) {
         out.writeByte(2);
         out.writeString(this.name);
      }

      out.writeByte(14);
      out.writeByte(this.sizeX);
      out.writeByte(15);
      out.writeByte(this.sizeY);
      if (this.clipType == 0) {
         out.writeByte(17);
      }

      if (!this.projectileCliped) {
         out.writeByte(18);
      }

      if (this.bendToPlane == 1) {
         out.writeByte(21);
      }

      if (this.aBoolean3867) {
         out.writeByte(22);
      }

      out.writeByte(24);
      out.writeShort(this.animation);
      if (this.clipType == 1) {
         out.writeByte(27);
      }

      for(int i = 0; i < 5; ++i) {
         if (this.options[i] != null) {
            out.writeByte(30 + i);
            out.writeString(this.options[i]);
         }
      }

      out.writeByte(39);
      out.writeByte(this.anInt3840 / 5);
      if (this.modifiedColors != null && this.originalColors != null) {
         out.writeByte(40);
         out.writeByte(this.modifiedColors.length);

         for(int i = 0; i < this.modifiedColors.length; ++i) {
            out.writeShort(this.originalColors[i]);
            out.writeShort(this.modifiedColors[i]);
         }
      }

      if (this.modifiedTextures != null && this.originalTextures != null) {
         out.writeByte(41);
         out.writeByte(this.modifiedTextures.length);

         for(int i = 0; i < this.modifiedTextures.length; ++i) {
            out.writeShort(this.originalTextures[i]);
            out.writeShort(this.modifiedTextures[i]);
         }
      }

      if (this.aBoolean3839) {
         out.writeByte(62);
      }

      if (!this.aBoolean3872) {
         out.writeByte(64);
      }

      out.writeByte(65);
      out.writeShort(this.widthX);
      out.writeByte(66);
      out.writeShort(this.height);
      out.writeByte(67);
      out.writeShort(this.widthY);
      if (this.cflag != 0) {
         out.writeByte(69);
         out.writeByte(this.cflag);
      }

      if (this.anInt3883 != 0) {
         out.writeByte(70);
         out.writeShort(this.anInt3883 >> 2);
      }

      if (this.anInt3889 != 0) {
         out.writeByte(71);
         out.writeShort(this.anInt3889 >> 2);
      }

      if (this.anInt3915 != 0) {
         out.writeByte(72);
         out.writeShort(this.anInt3915 >> 2);
      }

      if (this.secondBool) {
         out.writeByte(73);
      }

      if (this.ignoreClipOnAlternativeRoute) {
         out.writeByte(74);
      }

      out.writeByte(75);
      out.writeByte(this.anInt3855);
      out.writeByte(78);
      out.writeShort(this.anInt3860);
      out.writeByte(this.anInt3904);
      if (this.aBoolean3891) {
         out.writeByte(82);
      }

      if (!this.hasShadow) {
         out.writeByte(88);
      }

      if (!this.aBoolean3895) {
         out.writeByte(89);
      }

      if (this.aBoolean3873) {
         out.writeByte(91);
      }

      if (this.aBoolean3924) {
         out.writeByte(96);
      }

      if (this.aBoolean3866) {
         out.writeByte(97);
      }

      if (this.aBoolean3923) {
         out.writeByte(98);
      }

      if (this.optionSprite1 != -1 && this.optionSprite1 != 65535) {
         out.writeByte(99);
         out.writeByte(this.indexOfOptionSprite1);
         out.writeShort(this.optionSprite1);
      }

      if (this.optionSprite2 != -1 && this.optionSprite2 != 65535 && this.indexOfOptionSprite1 != this.indexOfOptionSprite2) {
         out.writeByte(100);
         out.writeByte(this.indexOfOptionSprite2);
         out.writeShort(this.optionSprite2);
      }

      if (this.mapSpriteId >= 0) {
         out.writeByte(102);
         out.writeShort(this.mapSpriteId);
      }

      if (this.thirdInt == 0) {
         out.writeByte(103);
      }

      if (this.aBoolean3906) {
         out.writeByte(105);
      }

      if (this.animations != null) {
         out.writeByte(106);
         out.writeByte(this.animations.length);

         for(int i = 0; i < this.animations.length; ++i) {
            out.writeShort(this.animations[i]);
            out.writeByte(this.anIntArray3869[i]);
         }
      } else {
         out.writeByte(106);
         out.writeByte(1);
         out.writeShort(-1);
         out.writeByte(1);
      }

      if (this.options != null) {
         for(int i = 0; i < this.options.length; ++i) {
            if (this.options[i] != null) {
               out.writeByte(150 + i);
               out.writeString(this.options[i]);
            }
         }
      }

      out.writeByte(164);
      out.writeShort(this.positionXOffset);
      out.writeByte(165);
      out.writeShort(this.positionZOffset);
      out.writeByte(166);
      out.writeShort(this.positionYOffset);
      out.writeByte(167);
      out.writeShort(this.standingOnHeightOffset);
      if (this.aBoolean3894) {
         out.writeByte(168);
      }

      if (this.aBoolean3845) {
         out.writeByte(169);
      }

      out.writeByte(170);
      out.writeSmart(this.anInt3032);
      out.writeByte(171);
      out.writeSmart(this.anInt2962);
      out.writeByte(173);
      out.writeShort(this.mapSpriteOffset1);
      out.writeShort(this.mapSpriteOffset2);
      if (this.parameters != null) {
         out.writeByte(249);
         out.writeByte(this.parameters.size());

         for(int key : this.parameters.keySet()) {
            Object value = this.parameters.get(key);
            boolean string_value = value instanceof String;
            out.writeByte(string_value ? 1 : 0);
            out.write24BitInt(key);
            if (string_value) {
               out.writeString((String)value);
            } else {
               out.writeInt((Integer)value);
            }
         }
      }

      out.writeByte(0);
      byte[] data = new byte[out.getOffset()];
      out.setOffset(0);
      out.getBytes(data, 0, data.length);
      return data;
   }

   private ObjectDefinitions() {
      this.optionSprite1 = -1;
      this.anInt3860 = -1;
      this.configFileId = -1;
      this.aBoolean3866 = false;
      this.mapAreaId = -1;
      this.anInt3865 = 255;
      this.aBoolean3845 = false;
      this.aBoolean3867 = false;
      this.anInt3850 = 0;
      this.indexOfOptionSprite2 = -1;
      this.indexOfOptionSprite1 = -1;
      this.aBoolean3872 = true;
      this.anInt3882 = -1;
      this.positionXOffset = 0;
      this.options = new String[5];
      this.positionZOffset = 0;
      this.aBoolean3839 = false;
      this.anIntArray3869 = null;
      this.sizeY = 1;
      this.thirdInt = -1;
      this.anInt3883 = 0;
      this.aBoolean3895 = true;
      this.anInt3840 = 0;
      this.aBoolean3870 = false;
      this.anInt3889 = 0;
      this.hasShadow = true;
      this.secondBool = false;
      this.clipType = 2;
      this.projectileCliped = true;
      this.ignoreClipOnAlternativeRoute = false;
      this.anInt3855 = -1;
      this.anInt3878 = 0;
      this.anInt3904 = 0;
      this.sizeX = 1;
      this.animation = -1;
      this.aBoolean3891 = false;
      this.anInt3905 = 0;
      this.name = "null";
      this.optionSprite2 = -1;
      this.aBoolean3906 = false;
      this.aBoolean3873 = false;
      this.aByte3914 = 0;
      this.anInt3915 = 0;
      this.anInt3900 = 0;
      this.secondInt = -1;
      this.aBoolean3894 = false;
      this.bendToPlane = 0;
      this.standingOnHeightOffset = 0;
      this.widthX = 128;
      this.configId = -1;
      this.positionYOffset = 0;
      this.cflag = 0;
      this.anInt3892 = 64;
      this.aBoolean3923 = false;
      this.aBoolean3924 = false;
      this.height = 128;
      this.widthY = 128;
      this.mapSpriteOffset1 = 256;
      this.mapSpriteOffset2 = 256;
      this.anInt2962 = 0;
      this.anInt3032 = 960;
   }

   final void method3287() {
      if (this.secondInt == -1) {
         this.secondInt = 0;
         if (this.possibleTypes != null && this.possibleTypes.length == 1 && this.possibleTypes[0] == 10) {
            this.secondInt = 1;
         }

         for(int i_13_ = 0; i_13_ < 5; ++i_13_) {
            if (this.options[i_13_] != null) {
               this.secondInt = 1;
               break;
            }
         }
      }

      if (this.anInt3855 == -1) {
         this.anInt3855 = this.clipType != 0 ? 1 : 0;
      }
   }

   public final int getFirstAnimation() {
      if (this.animations != null) {
         if (this.animations.length >= 1) {
            return this.animations[0];
         }

         int i_42_ = (int)(65535.0 * Math.random());

         for(int i_43_ = 0; i_43_ < this.animations.length; ++i_43_) {
            if (i_42_ <= this.anIntArray3869[i_43_]) {
               return this.animations[i_43_];
            }

            i_42_ -= this.anIntArray3869[i_43_];
         }
      }

      return -1;
   }

   private static int getArchiveId(int i_0_) {
      return i_0_ >>> -1135990488;
   }

   public static ObjectDefinitions getObjectDefinitions(int id) {
      ObjectDefinitions def = objectDefinitions.get(id);
      if (def == null) {
         def = new ObjectDefinitions();
         def.id = id;
         byte[] data = Cache.STORE.getIndexes()[16].getFile(getArchiveId(id), id & 0xFF);
         if (data != null) {
            def.readValueLoop(new InputStream(data));
         }

         def.method3287();
         objectDefinitions.put(id, def);
      }

      return def;
   }

   public int getAccessBlockFlag() {
      return this.cflag;
   }

   public static void clearObjectDefinitions() {
      objectDefinitions.clear();
   }

   public static final int getObjectDefinitionsSize() {
      int lastArchiveId = Cache.STORE.getIndexes()[16].getLastArchiveId();
      return lastArchiveId * 256 + Cache.STORE.getIndexes()[16].getValidFilesCount(lastArchiveId);
   }
}
