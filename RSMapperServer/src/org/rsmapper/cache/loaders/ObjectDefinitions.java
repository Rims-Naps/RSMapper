package org.rsmapper.cache.loaders;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;

public class ObjectDefinitions {
   private static final ConcurrentHashMap<Integer, ObjectDefinitions> objectDefinitions = new ConcurrentHashMap();
   private short[] originalColors;
   int[] toObjectIds;
   static int anInt3832;
   int[] anIntArray3833 = null;
   private int anInt3834 = 0;
   int anInt3835 = -1;
   static int anInt3836;
   private byte aByte3837;
   public int mapSpriteId = -1;
   boolean aBoolean3839 = false;
   private int anInt3840 = 0;
   private int anInt3841 = 128;
   static int anInt3842;
   static int anInt3843;
   int anInt3844 = -1;
   boolean aBoolean3845 = false;
   static int anInt3846;
   private byte aByte3847;
   private byte aByte3849;
   int anInt3850 = 0;
   public int mapAreaId = -1;
   public boolean secondBool = false;
   public boolean aBoolean3853 = true;
   int anInt3855 = -1;
   public boolean ignoreClipOnAlternativeRoute = false;
   int anInt3857 = -1;
   private byte[] aByteArray3858;
   int[] anIntArray3859;
   int anInt3860 = -1;
   public String[] options = new String[5];
   public int configFileId = -1;
   private short[] modifiedColors;
   int anInt3865 = 255;
   boolean aBoolean3866 = false;
   boolean aBoolean3867 = false;
   public boolean projectileCliped = true;
   private int[] anIntArray3869 = null;
   boolean aBoolean3870 = false;
   public int sizeY = 1;
   boolean aBoolean3872 = true;
   boolean aBoolean3873 = false;
   public int thirdInt = -1;
   private int anInt3875 = 0;
   public int anInt3876 = -1;
   private int anInt3877 = 0;
   private int anInt3878 = 0;
   public int clipType = 2;
   private int anInt3882 = -1;
   private int anInt3883 = 0;
   Object loader;
   private int anInt3889 = 0;
   public int sizeX = 1;
   public boolean aBoolean3891 = false;
   int anInt3892 = 64;
   public int secondInt = -1;
   boolean aBoolean3894 = false;
   boolean aBoolean3895 = true;
   int anInt3896;
   int configId = -1;
   private byte[] aByteArray3899;
   int anInt3900 = 0;
   public String name = "null";
   private int anInt3902 = 128;
   int anInt3904 = 0;
   int anInt3905 = 0;
   boolean aBoolean3906 = false;
   int[] anIntArray3908;
   int anInt3913 = -1;
   private byte aByte3914 = 0;
   private int anInt3915 = 0;
   public int[][] modelIds;
   private int anInt3917 = 128;
   private short[] modifiedTextures;
   private short[] originalTextures;
   int anInt3921 = 0;
   private HashMap<Integer, Object> parameters;
   boolean aBoolean3923 = false;
   boolean aBoolean3924 = false;
   int cflag = 0;
   public int id;

   public static void main(String[] args) throws IOException {
      Cache.init();

      for(int i = 4903; i < 4904; ++i) {
         ObjectDefinitions defs = getObjectDefinitions(i);
         System.out.println(i + ", " + defs.configId);
      }

   }

   public int getModelId() {
      try {
         return this.modelIds[0][0];
      } catch (NullPointerException var2) {
         return -1;
      }
   }

   public String getFirstOption() {
      return this.options != null && this.options.length >= 1 ? this.options[0] : "";
   }

   public String getSecondOption() {
      return this.options != null && this.options.length >= 2 ? this.options[1] : "";
   }

   public String getOption(int option) {
      return this.options != null && this.options.length >= option && option != 0 ? this.options[option - 1] : "";
   }

   public String getThirdOption() {
      return this.options != null && this.options.length >= 3 ? this.options[2] : "";
   }

   public boolean containsOption(int i, String option) {
      return this.options != null && this.options.length > i && this.options[i] != null ? this.options[i].equals(option) : false;
   }

   public boolean containsOption(String o) {
      if (this.options == null) {
         return false;
      } else {
         String[] var5;
         int var4 = (var5 = this.options).length;

         for(int var3 = 0; var3 < var4; ++var3) {
            String option = var5[var3];
            if (option != null && option.equalsIgnoreCase(o)) {
               return true;
            }
         }

         return false;
      }
   }

   private void readValues(InputStream stream, int opcode) {
      int i_60_;
      int i_57_;
      int i_61_;
      if (opcode != 1 && opcode != 5) {
         if (opcode != 2) {
            if (opcode != 14) {
               if (opcode != 15) {
                  if (opcode == 17) {
                     this.projectileCliped = false;
                     this.clipType = 0;
                  } else if (opcode != 18) {
                     if (opcode == 19) {
                        this.secondInt = stream.readUnsignedByte();
                     } else if (opcode != 21) {
                        if (opcode != 22) {
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
                                       } else {
                                          int length;
                                          if (opcode == 40) {
                                             length = stream.readUnsignedByte();
                                             this.originalColors = new short[length];
                                             this.modifiedColors = new short[length];

                                             for(i_60_ = 0; length > i_60_; ++i_60_) {
                                                this.originalColors[i_60_] = (short)stream.readUnsignedShort();
                                                this.modifiedColors[i_60_] = (short)stream.readUnsignedShort();
                                             }
                                          } else if (opcode != 41) {
                                             if (opcode != 42) {
                                                if (opcode != 62) {
                                                   if (opcode != 64) {
                                                      if (opcode == 65) {
                                                         this.anInt3902 = stream.readUnsignedShort();
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
                                                                     if (opcode != 77 && opcode != 92) {
                                                                        if (opcode == 78) {
                                                                           this.anInt3860 = stream.readUnsignedShort();
                                                                           this.anInt3904 = stream.readUnsignedByte();
                                                                        } else if (opcode != 79) {
                                                                           if (opcode == 81) {
                                                                              this.anInt3882 = 256 * stream.readUnsignedByte();
                                                                           } else if (opcode != 82) {
                                                                              if (opcode == 88) {
                                                                                 this.aBoolean3853 = false;
                                                                              } else if (opcode != 89) {
                                                                                 if (opcode == 90) {
                                                                                    this.aBoolean3870 = true;
                                                                                 } else if (opcode != 91) {
                                                                                    if (opcode != 93) {
                                                                                       if (opcode != 94) {
                                                                                          if (opcode != 95) {
                                                                                             if (opcode != 96) {
                                                                                                if (opcode == 97) {
                                                                                                   this.aBoolean3866 = true;
                                                                                                } else if (opcode == 98) {
                                                                                                   this.aBoolean3923 = true;
                                                                                                } else if (opcode == 99) {
                                                                                                   this.anInt3857 = stream.readUnsignedByte();
                                                                                                   this.anInt3835 = stream.readUnsignedShort();
                                                                                                } else if (opcode == 100) {
                                                                                                   this.anInt3844 = stream.readUnsignedByte();
                                                                                                   this.anInt3913 = stream.readUnsignedShort();
                                                                                                } else if (opcode != 101) {
                                                                                                   if (opcode == 102) {
                                                                                                      this.mapSpriteId = stream.readUnsignedShort();
                                                                                                   } else if (opcode == 103) {
                                                                                                      this.thirdInt = 0;
                                                                                                   } else if (opcode != 104) {
                                                                                                      if (opcode == 105) {
                                                                                                         this.aBoolean3906 = true;
                                                                                                      } else if (opcode == 106) {
                                                                                                         length = stream.readUnsignedByte();
                                                                                                         this.anIntArray3869 = new int[length];
                                                                                                         this.anIntArray3833 = new int[length];

                                                                                                         for(i_60_ = 0; i_60_ < length; ++i_60_) {
                                                                                                            this.anIntArray3833[i_60_] = stream.readUnsignedShort();
                                                                                                            i_57_ = stream.readUnsignedByte();
                                                                                                            this.anIntArray3869[i_60_] = i_57_;
                                                                                                         }
                                                                                                      } else if (opcode == 107) {
                                                                                                         this.mapAreaId = stream.readUnsignedShort();
                                                                                                      } else if (opcode >= 150 && opcode < 155) {
                                                                                                         this.options[opcode + -150] = stream.readString();
                                                                                                      } else if (opcode != 160) {
                                                                                                         if (opcode == 162) {
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
                                                                                                                     this.anInt3921 = stream.readUnsignedShort();
                                                                                                                  } else if (opcode != 168) {
                                                                                                                     if (opcode == 169) {
                                                                                                                        this.aBoolean3845 = true;
                                                                                                                     } else if (opcode == 170) {
                                                                                                                        stream.readUnsignedSmart();
                                                                                                                     } else if (opcode == 171) {
                                                                                                                        stream.readUnsignedSmart();
                                                                                                                     } else if (opcode == 173) {
                                                                                                                        stream.readUnsignedShort();
                                                                                                                        stream.readUnsignedShort();
                                                                                                                     } else if (opcode != 177) {
                                                                                                                        if (opcode == 178) {
                                                                                                                           stream.readUnsignedByte();
                                                                                                                        } else if (opcode != 189 && opcode == 249) {
                                                                                                                           length = stream.readUnsignedByte();
                                                                                                                           if (this.parameters == null) {
                                                                                                                              this.parameters = new HashMap(length);
                                                                                                                           }

                                                                                                                           for(i_60_ = 0; i_60_ < length; ++i_60_) {
                                                                                                                              boolean bool = stream.readUnsignedByte() == 1;
                                                                                                                              i_61_ = stream.read24BitInt();
                                                                                                                              if (!bool) {
                                                                                                                                 this.parameters.put(i_61_, stream.readInt());
                                                                                                                              } else {
                                                                                                                                 this.parameters.put(i_61_, stream.readString());
                                                                                                                              }
                                                                                                                           }
                                                                                                                        }
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     this.aBoolean3894 = true;
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  this.anInt3877 = stream.readShort();
                                                                                                               }
                                                                                                            } else {
                                                                                                               this.anInt3875 = stream.readShort();
                                                                                                            }
                                                                                                         } else {
                                                                                                            this.anInt3834 = stream.readShort();
                                                                                                         }
                                                                                                      } else {
                                                                                                         length = stream.readUnsignedByte();
                                                                                                         this.anIntArray3908 = new int[length];

                                                                                                         for(i_60_ = 0; length > i_60_; ++i_60_) {
                                                                                                            this.anIntArray3908[i_60_] = stream.readUnsignedShort();
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
                                                                                             this.anInt3882 = stream.readShort();
                                                                                          }
                                                                                       }
                                                                                    } else {
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
                                                                           length = stream.readUnsignedByte();
                                                                           this.anIntArray3859 = new int[length];

                                                                           for(i_60_ = 0; i_60_ < length; ++i_60_) {
                                                                              this.anIntArray3859[i_60_] = stream.readUnsignedShort();
                                                                           }
                                                                        }
                                                                     } else {
                                                                        this.configFileId = stream.readUnsignedShort();
                                                                        if (this.configFileId == 65535) {
                                                                           this.configFileId = -1;
                                                                        }

                                                                        this.configId = stream.readUnsignedShort();
                                                                        if (this.configId == 65535) {
                                                                           this.configId = -1;
                                                                        }

                                                                        length = -1;
                                                                        if (opcode == 92) {
                                                                           length = stream.readUnsignedShort();
                                                                        }

                                                                        i_60_ = stream.readUnsignedByte();
                                                                        this.toObjectIds = new int[i_60_ - -2];

                                                                        for(i_57_ = 0; i_60_ >= i_57_; ++i_57_) {
                                                                           this.toObjectIds[i_57_] = stream.readUnsignedShort();
                                                                        }

                                                                        this.toObjectIds[i_60_ + 1] = length;
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
                                                            this.anInt3917 = stream.readUnsignedShort();
                                                         }
                                                      } else {
                                                         this.anInt3841 = stream.readUnsignedShort();
                                                      }
                                                   } else {
                                                      this.aBoolean3872 = false;
                                                   }
                                                } else {
                                                   this.aBoolean3839 = true;
                                                }
                                             } else {
                                                length = stream.readUnsignedByte();
                                                this.aByteArray3858 = new byte[length];

                                                for(i_60_ = 0; i_60_ < length; ++i_60_) {
                                                   this.aByteArray3858[i_60_] = (byte)stream.readByte();
                                                }
                                             }
                                          } else {
                                             length = stream.readUnsignedByte();
                                             this.originalTextures = new short[length];
                                             this.modifiedTextures = new short[length];

                                             for(i_60_ = 0; length > i_60_; ++i_60_) {
                                                this.modifiedTextures[i_60_] = (short)stream.readUnsignedShort();
                                                this.originalTextures[i_60_] = (short)stream.readUnsignedShort();
                                             }
                                          }
                                       }
                                    } else {
                                       this.anInt3840 = stream.readByte() * 5;
                                    }
                                 } else {
                                    this.anInt3878 = stream.readByte();
                                 }
                              } else {
                                 this.anInt3876 = stream.readUnsignedShort();
                              }
                           } else {
                              this.thirdInt = 1;
                           }
                        } else {
                           this.aBoolean3867 = true;
                        }
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
      } else {
         boolean aBoolean1162 = false;
         if (opcode == 5 && aBoolean1162) {
            this.skipReadModelIds(stream);
         }

         i_60_ = stream.readUnsignedByte();
         this.modelIds = new int[i_60_][];
         this.aByteArray3899 = new byte[i_60_];

         for(i_57_ = 0; i_57_ < i_60_; ++i_57_) {
            this.aByteArray3899[i_57_] = (byte)stream.readByte();
            i_61_ = stream.readUnsignedByte();
            this.modelIds[i_57_] = new int[i_61_];

            for(int i_76_ = 0; i_61_ > i_76_; ++i_76_) {
               this.modelIds[i_57_][i_76_] = stream.readUnsignedShort();
            }
         }

         if (opcode == 5 && !aBoolean1162) {
            this.skipReadModelIds(stream);
         }
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

   private ObjectDefinitions() {
   }

   final void method3287() {
      if (this.secondInt == -1) {
         this.secondInt = 0;
         if (this.aByteArray3899 != null && this.aByteArray3899.length == 1 && this.aByteArray3899[0] == 10) {
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

   private static int getArchiveId(int i_0_) {
      return i_0_ >>> -1135990488;
   }

   public static ObjectDefinitions getObjectDefinitions(int id) {
      ObjectDefinitions def = (ObjectDefinitions)objectDefinitions.get(id);
      if (def == null) {
         def = new ObjectDefinitions();
         def.id = id;
         byte[] data = Cache.STORE.getIndexes()[16].getFile(getArchiveId(id), id & 255);
         if (data != null) {
            def.readValueLoop(new InputStream(data));
         }

         def.method3287();
         if (def.name != null && (def.name.equalsIgnoreCase("bank booth") || def.name.equalsIgnoreCase("counter"))) {
            def.ignoreClipOnAlternativeRoute = false;
            def.projectileCliped = true;
            if (def.clipType == 0) {
               def.clipType = 1;
            }
         }

         if (def.ignoreClipOnAlternativeRoute) {
            def.projectileCliped = false;
            def.clipType = 0;
         }

         objectDefinitions.put(id, def);
      }

      return def;
   }

   public int getClipType() {
      return this.clipType;
   }

   public boolean isProjectileCliped() {
      return this.projectileCliped;
   }

   public int getSizeX() {
      return this.sizeX;
   }

   public int getSizeY() {
      return this.sizeY;
   }

   public int getAccessBlockFlag() {
      return this.cflag;
   }

   public static void clearObjectDefinitions() {
      objectDefinitions.clear();
   }
}
