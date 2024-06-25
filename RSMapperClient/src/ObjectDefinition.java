import java.awt.event.ActionEvent;

public class ObjectDefinition {
   protected int anInt2958;
   static int anInt2959;
   private byte aByte2960;
   protected boolean aBoolean2961 = false;
   protected int anInt2962;
   protected int positionZOffset;
   protected int positionXOffset;
   static int anInt2965;
   static int anInt2966;
   protected byte[] possibleTypes;
   private int anInt2968;
   protected int widthX;
   protected int anInt2970;
   protected int anInt2971;
   protected boolean hasShadow = true;
   protected int height = 128;
   private byte aByte2974;
   protected int anInt2975;
   static int anInt2976;
   protected int anInt2977;
   static int anInt2978;
   static int anInt2979;
   protected String[] options;
   protected int[] rightClickImages;
   static int anInt2982;
   protected int standingOnHeightOffset;
   protected int[] anIntArray2984;
   private int anInt2985;
   protected int sizeY;
   protected int indexOfOptionSprite1;
   protected short[] originalTextures;
   protected int anInt2989;
   protected boolean aBoolean2990;
   static int anInt2991;
   protected boolean aBoolean2992;
   protected boolean aBoolean2993;
   protected int mapAreaId;
   int[] anIntArray2995;
   private byte[] aByteArray2996;
   static int anInt2997;
   protected boolean aBoolean2998;
   protected String name;
   protected boolean aBoolean3000;
   static int anInt3001;
   protected boolean aBoolean3002;
   static int anInt3003;
   static int anInt3004;
   static int anInt3005;
   protected int mapSpriteId;
   protected boolean aBoolean3007;
   protected int optionSprite1;
   protected int widthY;
   protected int clipType;
   protected int anInt3011;
   protected int anInt3012;
   protected int optionSprite2;
   private HashTable aHashTable3014;
   protected int anInt3015;
   protected boolean aBoolean3016;
   private int anInt3017;
   protected int positionYOffset;
   protected int[] animations;
   protected int mapSpriteOffset2;
   static int anInt3021;
   static int anInt3022;
   private int anInt3023;
   protected int anInt3024;
   protected short[] originalColors;
   private int anInt3026;
   protected byte bendToMap;
   protected Class112 aClass112_3028;
   static int anInt3029;
   protected int objectId;
   protected int[][] modelIds;
   protected int anInt3032;
   protected boolean aBoolean3033;
   protected boolean aBoolean3034;
   private int anInt3035;
   protected int[] anIntArray3036;
   private int anInt3037;
   protected int indexOfOptionSprite2;
   protected boolean aBoolean3039;
   protected int anInt3040;
   static int anInt3041;
   private int anInt3042;
   static int anInt3043;
   protected short[] modifiedTextures;
   private byte aByte3045;
   static int anInt3046;
   protected short[] modifiedColors;
   static int anInt3048;
   static int anInt3049;
   protected int mapSpriteOffset1;
   protected boolean aBoolean3051;
   private byte aByte3052;
   protected boolean aBoolean3053;
   static int anInt3054;
   protected int sizeX;
   protected boolean aBoolean3056;
   protected int anInt3057;

   final boolean hasMoreThanOneAnimation() {
      ++anInt3022;
      return this.animations != null && this.animations.length > 1;
   }

   private final void decode(Buffer buffer, int opcode, int i_0_) {
      if (i_0_ == 21120) {
         ++anInt2982;
         if (opcode != 1 && opcode != 5) {
            if (opcode == 2) {
               this.name = buffer.readString();
            } else if (opcode != 14) {
               if (opcode != 15) {
                  if (opcode == 17) {
                     this.aBoolean3034 = false;
                     this.clipType = 0;
                  } else if (opcode == 18) {
                     this.aBoolean3034 = false;
                  } else if (opcode == 19) {
                     this.anInt3057 = buffer.readUnsignedByte();
                  } else if (opcode != 21) {
                     if (opcode != 22) {
                        if (opcode != 23) {
                           if (opcode != 24) {
                              if (opcode == 27) {
                                 this.clipType = 1;
                              } else if (opcode == 28) {
                                 this.anInt3011 = buffer.readUnsignedByte() << 2;
                              } else if (opcode != 29) {
                                 if (opcode == 39) {
                                    this.anInt3026 = 5 * buffer.readByte();
                                 } else if (opcode >= 30 && opcode < 35) {
                                    this.options[opcode + -30] = buffer.readString();
                                 } else if (opcode != 40) {
                                    if (opcode != 41) {
                                       if (opcode == 42) {
                                          int i_5_ = buffer.readUnsignedByte();
                                          this.aByteArray2996 = new byte[i_5_];

                                          for(int i_6_ = 0; ~i_5_ < ~i_6_; ++i_6_) {
                                             this.aByteArray2996[i_6_] = buffer.readByte();
                                          }
                                       } else if (opcode != 62) {
                                          if (opcode != 64) {
                                             if (opcode == 65) {
                                                this.widthX = buffer.readUnsignedShort();
                                             } else if (opcode != 66) {
                                                if (opcode == 67) {
                                                   this.widthY = buffer.readUnsignedShort();
                                                } else if (opcode == 69) {
                                                   this.anInt3040 = buffer.readUnsignedByte();
                                                } else if (opcode == 70) {
                                                   this.anInt2968 = buffer.readShort() << 2;
                                                } else if (opcode != 71) {
                                                   if (opcode == 72) {
                                                      this.anInt2985 = buffer.readShort() << 2;
                                                   } else if (opcode != 73) {
                                                      if (opcode == 74) {
                                                         this.aBoolean3016 = true;
                                                      } else if (~opcode != -76) {
                                                         if (opcode == 77 || opcode == 92) {
                                                            this.anInt3017 = buffer.readUnsignedShort();
                                                            if (this.anInt3017 == 65535) {
                                                               this.anInt3017 = -1;
                                                            }

                                                            this.anInt3035 = buffer.readUnsignedShort();
                                                            if (this.anInt3035 == 65535) {
                                                               this.anInt3035 = -1;
                                                            }

                                                            int i_19_ = -1;
                                                            if (~opcode == -93) {
                                                               i_19_ = buffer.readUnsignedShort();
                                                               if (~i_19_ == -65536) {
                                                                  i_19_ = -1;
                                                               }
                                                            }

                                                            int i_20_ = buffer.readUnsignedByte();
                                                            this.anIntArray2984 = new int[i_20_ + 2];

                                                            for(int i_21_ = 0; i_20_ >= i_21_; ++i_21_) {
                                                               this.anIntArray2984[i_21_] = buffer.readUnsignedShort();
                                                               if (~this.anIntArray2984[i_21_] == -65536) {
                                                                  this.anIntArray2984[i_21_] = -1;
                                                               }
                                                            }

                                                            this.anIntArray2984[1 + i_20_] = i_19_;
                                                         } else if (opcode != 78) {
                                                            if (opcode == 79) {
                                                               this.anInt2989 = buffer.readUnsignedShort();
                                                               this.anInt2971 = buffer.readUnsignedShort();
                                                               this.anInt3012 = buffer.readUnsignedByte();
                                                               int i_7_ = buffer.readUnsignedByte();
                                                               this.anIntArray3036 = new int[i_7_];

                                                               for(int i_8_ = 0; ~i_7_ < ~i_8_; ++i_8_) {
                                                                  this.anIntArray3036[i_8_] = buffer.readUnsignedShort();
                                                               }
                                                            } else if (opcode != 81) {
                                                               if (opcode != 82) {
                                                                  if (opcode == 88) {
                                                                     this.hasShadow = false;
                                                                  } else if (opcode != 89) {
                                                                     if (opcode != 91) {
                                                                        if (opcode == 93) {
                                                                           this.bendToMap = 3;
                                                                           this.anInt3023 = buffer.readUnsignedShort();
                                                                        } else if (opcode != 94) {
                                                                           if (opcode != 95) {
                                                                              if (opcode != 97) {
                                                                                 if (opcode == 98) {
                                                                                    this.aBoolean2998 = true;
                                                                                 } else if (opcode != 99) {
                                                                                    if (opcode != 100) {
                                                                                       if (opcode == 101) {
                                                                                          this.anInt2958 = buffer.readUnsignedByte();
                                                                                       } else if (opcode == 102) {
                                                                                          this.mapSpriteId = buffer.readUnsignedShort();
                                                                                       } else if (opcode == 103) {
                                                                                          this.anInt2977 = 0;
                                                                                       } else if (opcode == 104) {
                                                                                          this.anInt3024 = buffer.readUnsignedByte();
                                                                                       } else if (opcode != 105) {
                                                                                          if (opcode == 106) {
                                                                                             int size = buffer.readUnsignedByte();
                                                                                             int i_10_ = 0;
                                                                                             this.animations = new int[size];
                                                                                             this.anIntArray2995 = new int[size];

                                                                                             for(int index = 0; index < size; ++index) {
                                                                                                this.animations[index] = buffer.readUnsignedShort();
                                                                                                if (this.animations[index] == 65535) {
                                                                                                   this.animations[index] = -1;
                                                                                                }

                                                                                                i_10_ += this.anIntArray2995[index] = buffer.readUnsignedByte();
                                                                                             }

                                                                                             for(int index = 0; index < size; ++index) {
                                                                                                this.anIntArray2995[index] = 65535
                                                                                                   * this.anIntArray2995[index]
                                                                                                   / i_10_;
                                                                                             }
                                                                                          } else if (opcode != 107) {
                                                                                             if (~opcode <= -151 && opcode < 155) {
                                                                                                this.options[-150 + opcode] = buffer.readString();
                                                                                                if (!this.aClass112_3028.aBoolean1431) {
                                                                                                   this.options[-150 + opcode] = null;
                                                                                                }
                                                                                             } else if (~opcode != -161) {
                                                                                                if (~opcode != -163) {
                                                                                                   if (~opcode == -164) {
                                                                                                      this.aByte2974 = buffer.readByte();
                                                                                                      this.aByte3045 = buffer.readByte();
                                                                                                      this.aByte3052 = buffer.readByte();
                                                                                                      this.aByte2960 = buffer.readByte();
                                                                                                   } else if (opcode != 164) {
                                                                                                      if (opcode == 165) {
                                                                                                         this.positionZOffset = buffer.readShort();
                                                                                                      } else if (opcode != 166) {
                                                                                                         if (opcode == 167) {
                                                                                                            this.standingOnHeightOffset = buffer.readUnsignedShort(
                                                                                                               
                                                                                                            );
                                                                                                         } else if (opcode != 168) {
                                                                                                            if (opcode == 169) {
                                                                                                               this.aBoolean2993 = true;
                                                                                                            } else if (opcode == 170) {
                                                                                                               this.anInt3032 = buffer.readSmart();
                                                                                                            } else if (opcode != 171) {
                                                                                                               if (opcode == 173) {
                                                                                                                  this.mapSpriteOffset1 = buffer.readUnsignedShort(
                                                                                                                     
                                                                                                                  );
                                                                                                                  this.mapSpriteOffset2 = buffer.readUnsignedShort(
                                                                                                                     
                                                                                                                  );
                                                                                                               } else if (opcode != 177) {
                                                                                                                  if (opcode == 178) {
                                                                                                                     this.anInt2975 = buffer.readUnsignedByte();
                                                                                                                  } else if (opcode != 189) {
                                                                                                                     if (opcode == 249) {
                                                                                                                        int i_13_ = buffer.readUnsignedByte();
                                                                                                                        if (this.aHashTable3014 == null) {
                                                                                                                           int i_14_ = Class320_Sub19.method3753(
                                                                                                                              i_13_
                                                                                                                           );
                                                                                                                           this.aHashTable3014 = new HashTable(
                                                                                                                              i_14_
                                                                                                                           );
                                                                                                                        }

                                                                                                                        for(int i_15_ = 0;
                                                                                                                           ~i_13_ < ~i_15_;
                                                                                                                           ++i_15_
                                                                                                                        ) {
                                                                                                                           boolean bool = buffer.readUnsignedByte(
                                                                                                                                 
                                                                                                                              )
                                                                                                                              == 1;
                                                                                                                           int i_16_ = buffer.read24BitInteger(
                                                                                                                              
                                                                                                                           );
                                                                                                                           Node node;
                                                                                                                           if (bool) {
                                                                                                                              node = new Node_Sub18(
                                                                                                                                 buffer.readString()
                                                                                                                              );
                                                                                                                           } else {
                                                                                                                              node = new Node_Sub32(
                                                                                                                                 buffer.readInt()
                                                                                                                              );
                                                                                                                           }

                                                                                                                           this.aHashTable3014
                                                                                                                              .put((long)i_16_, node, -125);
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        System.out
                                                                                                                           .println("OBJECT DEF: " + opcode);
                                                                                                                     }
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  this.aBoolean2992 = true;
                                                                                                               }
                                                                                                            } else {
                                                                                                               this.anInt2962 = buffer.readSmart();
                                                                                                            }
                                                                                                         } else {
                                                                                                            this.aBoolean2961 = true;
                                                                                                         }
                                                                                                      } else {
                                                                                                         this.positionYOffset = buffer.readShort();
                                                                                                      }
                                                                                                   } else {
                                                                                                      this.positionXOffset = buffer.readShort();
                                                                                                   }
                                                                                                } else {
                                                                                                   this.bendToMap = 3;
                                                                                                   this.anInt3023 = buffer.readInt();
                                                                                                }
                                                                                             } else {
                                                                                                int i_17_ = buffer.readUnsignedByte();
                                                                                                this.rightClickImages = new int[i_17_];

                                                                                                for(int i_18_ = 0; i_17_ > i_18_; ++i_18_) {
                                                                                                   this.rightClickImages[i_18_] = buffer.readUnsignedShort();
                                                                                                }
                                                                                             }
                                                                                          } else {
                                                                                             this.mapAreaId = buffer.readUnsignedShort();
                                                                                          }
                                                                                       } else {
                                                                                          this.aBoolean3007 = true;
                                                                                       }
                                                                                    } else {
                                                                                       this.indexOfOptionSprite2 = buffer.readUnsignedByte();
                                                                                       this.optionSprite2 = buffer.readUnsignedShort();
                                                                                    }
                                                                                 } else {
                                                                                    this.indexOfOptionSprite1 = buffer.readUnsignedByte();
                                                                                    this.optionSprite1 = buffer.readUnsignedShort();
                                                                                 }
                                                                              } else {
                                                                                 this.aBoolean3056 = true;
                                                                              }
                                                                           } else {
                                                                              this.bendToMap = 5;
                                                                              this.anInt3023 = buffer.readShort();
                                                                           }
                                                                        } else {
                                                                           this.bendToMap = 4;
                                                                        }
                                                                     } else {
                                                                        this.aBoolean3002 = true;
                                                                     }
                                                                  } else {
                                                                     this.aBoolean3000 = false;
                                                                  }
                                                               } else {
                                                                  this.aBoolean2990 = true;
                                                               }
                                                            } else {
                                                               this.bendToMap = 2;
                                                               this.anInt3023 = 256 * buffer.readUnsignedByte();
                                                            }
                                                         } else {
                                                            this.anInt3015 = buffer.readUnsignedShort();
                                                            this.anInt3012 = buffer.readUnsignedByte();
                                                         }
                                                      } else {
                                                         this.anInt2970 = buffer.readUnsignedByte();
                                                      }
                                                   } else {
                                                      this.aBoolean3051 = true;
                                                   }
                                                } else {
                                                   this.anInt3037 = buffer.readShort() << 2;
                                                }
                                             } else {
                                                this.height = buffer.readUnsignedShort();
                                             }
                                          } else {
                                             this.aBoolean3033 = false;
                                          }
                                       } else {
                                          this.aBoolean3039 = true;
                                       }
                                    } else {
                                       int i_22_ = buffer.readUnsignedByte();
                                       this.originalTextures = new short[i_22_];
                                       this.modifiedTextures = new short[i_22_];

                                       for(int i_23_ = 0; i_22_ > i_23_; ++i_23_) {
                                          this.modifiedTextures[i_23_] = (short)buffer.readUnsignedShort();
                                          this.originalTextures[i_23_] = (short)buffer.readUnsignedShort();
                                       }
                                    }
                                 } else {
                                    int i_24_ = buffer.readUnsignedByte();
                                    this.originalColors = new short[i_24_];
                                    this.modifiedColors = new short[i_24_];

                                    for(int i_25_ = 0; i_25_ < i_24_; ++i_25_) {
                                       this.modifiedColors[i_25_] = (short)buffer.readUnsignedShort();
                                       this.originalColors[i_25_] = (short)buffer.readUnsignedShort();
                                    }
                                 }
                              } else {
                                 this.anInt3042 = buffer.readByte();
                              }
                           } else {
                              int animation = buffer.readUnsignedShort();
                              if (animation != 65535) {
                                 this.animations = new int[]{animation};
                              }
                           }
                        } else {
                           this.anInt2977 = 1;
                        }
                     } else {
                        this.aBoolean3053 = true;
                     }
                  } else {
                     this.bendToMap = 1;
                  }
               } else {
                  this.sizeY = buffer.readUnsignedByte();
               }
            } else {
               this.sizeX = buffer.readUnsignedByte();
            }
         } else {
            if (opcode == 5 && this.aClass112_3028.aBoolean1424) {
               this.method3052((byte)-111, buffer);
            }

            int i_1_ = buffer.readUnsignedByte();
            this.possibleTypes = new byte[i_1_];
            this.modelIds = new int[i_1_][];

            for(int i_2_ = 0; i_2_ < i_1_; ++i_2_) {
               this.possibleTypes[i_2_] = buffer.readByte();
               int i_3_ = buffer.readUnsignedByte();
               this.modelIds[i_2_] = new int[i_3_];

               for(int i_4_ = 0; i_4_ < i_3_; ++i_4_) {
                  this.modelIds[i_2_][i_4_] = buffer.readUnsignedShort();
               }
            }

            if (opcode == 5 && !this.aClass112_3028.aBoolean1424) {
               this.method3052((byte)-111, buffer);
            }
         }
      }
   }

   final String method3034(String string, int i, boolean bool) {
      ++anInt3005;
      if (this.aHashTable3014 == null) {
         return string;
      } else {
         if (bool) {
            this.anInt3035 = 79;
         }

         Node_Sub18 node_sub18 = (Node_Sub18)this.aHashTable3014.get(3512, (long)i);
         return node_sub18 == null ? string : node_sub18.aString7149;
      }
   }

   final boolean hasAnimationId(int animation) {
      ++anInt3048;
      if (this.animations != null && animation != -1) {
         for(int i = 0; i < this.animations.length; ++i) {
            if (animation == this.animations[i]) {
               return true;
            }
         }
      }

      return false;
   }

   static final void method3036(int i, int i_29_, int i_30_, Animable_Sub1 animable_sub1) {
      Class261 class261 = Node_Sub15_Sub6.method2572(i, i_29_, i_30_);
      if (class261 != null) {
         class261.anAnimable_Sub1_3317 = animable_sub1;
         int i_31_ = Class320_Sub10.aPlaneArray8300 == Class368.aPlaneArray4548 ? 1 : 0;
         if (animable_sub1.method814((byte)-52)) {
            if (animable_sub1.method813(0)) {
               animable_sub1.anAnimable5941 = SeekableFile.anAnimableArray3884[i_31_];
               SeekableFile.anAnimableArray3884[i_31_] = animable_sub1;
            } else {
               animable_sub1.anAnimable5941 = Class303.anAnimableArray3827[i_31_];
               Class303.anAnimableArray3827[i_31_] = animable_sub1;
               Class194_Sub1.aBoolean6892 = true;
            }
         } else {
            animable_sub1.anAnimable5941 = Node_Sub36.anAnimableArray7429[i_31_];
            Node_Sub36.anAnimableArray7429[i_31_] = animable_sub1;
         }
      }
   }

   final boolean animationsAreNotNull() {
      ++anInt2965;
      return this.animations != null;
   }

   final ObjectDefinition method3038(int i, Interface17 interface17) {
      ++anInt2991;
      int i_32_ = -1;
      if (i != 13) {
         this.hasMoreThanOneAnimation();
      }

      if (~this.anInt3017 == 0) {
         if (~this.anInt3035 != 0) {
            i_32_ = interface17.method65(this.anInt3035, -3);
         }
      } else {
         i_32_ = interface17.getVarpBit(this.anInt3017, (byte)-42);
      }

      if (~i_32_ <= -1 && ~(-1 + this.anIntArray2984.length) < ~i_32_ && this.anIntArray2984[i_32_] != -1) {
         return this.aClass112_3028.getObjectDefinitionsForId(this.anIntArray2984[i_32_], 81);
      } else {
         int i_33_ = this.anIntArray2984[-1 + this.anIntArray2984.length];
         return i_33_ != -1 ? this.aClass112_3028.getObjectDefinitionsForId(i_33_, i + 99) : null;
      }
   }

   final boolean method3039(int i) {
      ++anInt2978;
      if (this.modelIds == null) {
         return true;
      } else {
         boolean bool = true;
         synchronized(this.aClass112_3028.aClass302_1433) {
            for(int i_34_ = 0; ~this.modelIds.length < ~i_34_; ++i_34_) {
               for(int i_35_ = 0; ~i_35_ > ~this.modelIds[i_34_].length; ++i_35_) {
                  bool &= this.aClass112_3028.aClass302_1433.method3515(0, this.modelIds[i_34_][i_35_], 0);
               }
            }
         }

         if (i <= 76) {
            this.anInt3023 = -86;
         }

         return bool;
      }
   }

   final boolean method3040(int i) {
      ++anInt2976;
      if (this.anIntArray2984 == null) {
         return this.anInt3015 != -1 || this.anIntArray3036 != null;
      } else {
         if (i != -4617) {
            this.method3034(null, 122, false);
         }

         for(int i_36_ = 0; i_36_ < this.anIntArray2984.length; ++i_36_) {
            if (~this.anIntArray2984[i_36_] != 0) {
               ObjectDefinition objectdefinition_37_ = this.aClass112_3028.getObjectDefinitionsForId(this.anIntArray2984[i_36_], 59);
               if (objectdefinition_37_.anInt3015 != -1 || objectdefinition_37_.anIntArray3036 != null) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   final boolean method3041(int i, int i_38_) {
      ++anInt3043;
      if (this.modelIds == null) {
         return true;
      } else {
         synchronized(this.aClass112_3028.aClass302_1433) {
            if (i_38_ <= 12) {
               return true;
            } else {
               for(int i_39_ = 0; ~i_39_ > ~this.possibleTypes.length; ++i_39_) {
                  if (i == this.possibleTypes[i_39_]) {
                     for(int i_40_ = 0; ~i_40_ > ~this.modelIds[i_39_].length; ++i_40_) {
                        if (!this.aClass112_3028.aClass302_1433.method3515(0, this.modelIds[i_39_][i_40_], 0)) {
                           return false;
                        }
                     }

                     return true;
                  }
               }

               return true;
            }
         }
      }
   }

   final void method3042(byte b, Buffer buffer) {
      while(true) {
         int i = buffer.readUnsignedByte();
         if (~i == -1) {
            if (b == 123) {
               ++anInt3049;
            }

            return;
         }

         this.decode(buffer, i, 21120);
      }
   }

   final void method3043(int i) {
      if (i == 5) {
         ++anInt2979;
         if (~this.anInt3057 == 0) {
            this.anInt3057 = 0;
            if (this.possibleTypes != null && this.possibleTypes.length == 1 && this.possibleTypes[0] == 10) {
               this.anInt3057 = 1;
            }

            for(int i_41_ = 0; i_41_ < 5; ++i_41_) {
               if (this.options[i_41_] != null) {
                  this.anInt3057 = 1;
                  break;
               }
            }
         }

         if (this.anInt2970 == -1) {
            this.anInt2970 = this.clipType == 0 ? 0 : 1;
         }

         if (this.animationsAreNotNull() || this.aBoolean2998 || this.anIntArray2984 != null) {
            this.aBoolean2992 = true;
         }
      }
   }

   final int getFirstAnimation() {
      ++anInt2966;
      if (this.animations != null) {
         if (this.animations.length >= 1) {
            return this.animations[0];
         }

         int i_42_ = (int)(65535.0 * Math.random());

         for(int i_43_ = 0; i_43_ < this.animations.length; ++i_43_) {
            if (i_42_ <= this.anIntArray2995[i_43_]) {
               return this.animations[i_43_];
            }

            i_42_ -= this.anIntArray2995[i_43_];
         }
      }

      return -1;
   }

   static final void method3045(long[] ls, Object[] objects, boolean bool) {
      ++anInt3046;
      Class286.method3393(objects, (byte)-66, ls, 0, -1 + ls.length);
   }

   final Class243 method3046(
      int i,
      int y,
      int x,
      Plane plane,
      boolean bool,
      byte b,
      int i_46_,
      int i_47_,
      GraphicsToolkit graphicstoolkit,
      Class121 class121,
      int i_48_,
      Plane plane_49_
   ) {
      ++anInt3003;
      if (Class243.method3062(i_47_, (byte)51)) {
         i_47_ = 4;
      }

      long l = (long)(i + (this.objectId << 10) + (i_47_ << 3));
      l |= (long)(graphicstoolkit.anInt1537 << 29);
      if (class121 != null) {
         l |= class121.aLong1522 << 32;
      }

      int i_50_ = i_48_;
      if (this.bendToMap == 3) {
         i_50_ = i_48_ | 7;
      } else {
         if (this.bendToMap != 0 || this.positionZOffset != 0) {
            i_50_ = i_48_ | 2;
         }

         if (this.positionXOffset != 0) {
            i_50_ |= 1;
         }

         if (this.positionYOffset != 0) {
            i_50_ |= 4;
         }
      }

      if (bool) {
         i_50_ |= 262144;
      }

      Class243 class243;
      synchronized(this.aClass112_3028.aClass61_1435) {
         class243 = (Class243)this.aClass112_3028.aClass61_1435.method607(l, b);
      }

      DrawableModel drawablemodel = class243 != null ? class243.aDrawableModel3064 : null;
      r var_r = null;
      if (drawablemodel != null && graphicstoolkit.b(drawablemodel.ua(), i_50_) == 0) {
         drawablemodel = class243.aDrawableModel3064;
         var_r = class243.aR3072;
         if (bool && var_r == null) {
            var_r = class243.aR3072 = drawablemodel.ba(null);
         }
      } else {
         if (drawablemodel != null) {
            i_50_ = graphicstoolkit.c(i_50_, drawablemodel.ua());
         }

         int i_51_ = i_50_;
         if (~i_47_ == -11 && i > 3) {
            i_51_ = i_50_ | 5;
         }

         drawablemodel = this.prepareModel(graphicstoolkit, i_51_, class121, (byte)76, i, i_47_, false, x, y);
         if (drawablemodel == null) {
            return null;
         }

         if (i_47_ == 10 && ~i < -4) {
            drawablemodel.a(2048);
         }

         if (bool) {
            var_r = drawablemodel.ba(null);
         }

         drawablemodel.s(i_50_);
         class243 = new Class243();
         class243.aR3072 = var_r;
         class243.aDrawableModel3064 = drawablemodel;
         synchronized(this.aClass112_3028.aClass61_1435) {
            this.aClass112_3028.aClass61_1435.method601(class243, b ^ 25566, l);
         }
      }

      if (b != 0) {
         this.method3041(-47, 126);
      }

      boolean bool_52_ = this.bendToMap != 0 && (plane != null || plane_49_ != null);
      boolean bool_53_ = this.positionXOffset != 0 || ~this.positionZOffset != -1 || this.positionYOffset != 0;
      if (!bool_52_ && !bool_53_) {
         drawablemodel = drawablemodel.method633((byte)0, i_48_, true);
      } else {
         drawablemodel = drawablemodel.method633((byte)0, i_50_, true);
         if (bool_52_) {
            drawablemodel.p(this.bendToMap, this.anInt3023, plane, plane_49_, x, i_46_, y);
         }

         if (bool_53_) {
            drawablemodel.H(this.positionXOffset, this.positionZOffset, this.positionYOffset);
         }

         drawablemodel.s(i_48_);
      }

      Node_Sub21.aClass243_7185.aDrawableModel3064 = drawablemodel;
      Node_Sub21.aClass243_7185.aR3072 = var_r;
      return Node_Sub21.aClass243_7185;
   }

   static final int method3047(int i, int i_54_) {
      if (i_54_ != -1) {
         method3049(null, null, (byte)-38);
      }

      ++anInt2997;
      int i_55_ = (i * i >> 12) * i >> 12;
      int i_56_ = -61440 + 6 * i;
      int i_57_ = 40960 + (i * i_56_ >> 12);
      return i_57_ * i_55_ >> 12;
   }

   final DrawableModel method3048(
      int i,
      int i_58_,
      int i_59_,
      int i_60_,
      Plane plane,
      Animator animator,
      int i_61_,
      GraphicsToolkit graphicstoolkit,
      Plane plane_62_,
      Class121 class121,
      int i_63_,
      int i_64_
   ) {
      ++anInt3021;
      if (Class243.method3062(i_59_, (byte)46)) {
         i_59_ = 4;
      }

      long l = (long)((this.objectId << 10) + (i_59_ << 3) - -i);
      int i_65_ = i_63_;
      l |= (long)(graphicstoolkit.anInt1537 << 29);
      if (class121 != null) {
         l |= class121.aLong1522 << 32;
      }

      if (animator != null) {
         i_63_ |= animator.method237((byte)-128);
      }

      if (this.bendToMap != 3) {
         if (this.bendToMap != 0 || this.positionZOffset != 0) {
            i_63_ |= 2;
         }

         if (this.positionXOffset != 0) {
            i_63_ |= 1;
         }

         if (this.positionYOffset != 0) {
            i_63_ |= 4;
         }
      } else {
         i_63_ |= 7;
      }

      if (~i_59_ == -11 && ~i < -4) {
         i_63_ |= 5;
      }

      DrawableModel drawablemodel;
      synchronized(this.aClass112_3028.aClass61_1436) {
         drawablemodel = (DrawableModel)this.aClass112_3028.aClass61_1436.method607(l, 0);
      }

      if (drawablemodel == null || ~graphicstoolkit.b(drawablemodel.ua(), i_63_) != -1) {
         if (drawablemodel != null) {
            i_63_ = graphicstoolkit.c(i_63_, drawablemodel.ua());
         }

         drawablemodel = this.prepareModel(graphicstoolkit, i_63_, class121, (byte)76, i, i_59_, false, i_60_, i_64_);
         if (drawablemodel == null) {
            return null;
         }

         synchronized(this.aClass112_3028.aClass61_1436) {
            this.aClass112_3028.aClass61_1436.method601(drawablemodel, 25566, l);
         }
      }

      boolean bool = false;
      if (animator != null) {
         drawablemodel = drawablemodel.method633((byte)1, i_63_, true);
         bool = true;
         animator.method225(0, drawablemodel, 3 & i);
      }

      if (i_59_ == 10 && ~i < -4) {
         if (!bool) {
            drawablemodel = drawablemodel.method633((byte)3, i_63_, true);
            bool = true;
         }

         drawablemodel.a(2048);
      }

      if (this.bendToMap != 0) {
         if (!bool) {
            bool = true;
            drawablemodel = drawablemodel.method633((byte)3, i_63_, true);
         }

         drawablemodel.p(this.bendToMap, this.anInt3023, plane_62_, plane, i_60_, i_64_, i_58_);
      }

      if (~this.positionXOffset != -1 || ~this.positionZOffset != -1 || ~this.positionYOffset != -1) {
         if (!bool) {
            drawablemodel = drawablemodel.method633((byte)3, i_63_, true);
            bool = true;
         }

         drawablemodel.H(this.positionXOffset, this.positionZOffset, this.positionYOffset);
      }

      if (bool) {
         drawablemodel.s(i_65_);
      }

      if (i_61_ != 1521375267) {
         this.optionSprite2 = 89;
      }

      return drawablemodel;
   }

   static final void method3049(SignLink signlink, Object object, byte b) {
      ++anInt3001;
      if (b <= 63) {
         method3045(null, null, true);
      }

      if (signlink.anEventQueue4002 != null) {
         for(int i = 0; ~i > -51 && signlink.anEventQueue4002.peekEvent() != null; ++i) {
            Class262_Sub22.method3208(1L, false);
         }

         try {
            if (object != null) {
               signlink.anEventQueue4002.postEvent(new ActionEvent(object, 1001, "dummy"));
            }
         } catch (Exception var4) {
         }
      }
   }

   static final int method3050(int i) {
      ++anInt3041;
      return 0xFF & i;
   }

   public final DrawableModel prepareModel(
      GraphicsToolkit graphicstoolkit, int i, Class121 class121, byte b, int typeFlag, int type, boolean forInterface, int x, int y
   ) {
      ++anInt3054;
      int i_68_ = 64 + this.anInt3042;
      int i_69_ = this.anInt3026 - -850;
      int i_70_ = i;
      boolean bool = this.aBoolean3039 || type == 2 && typeFlag > 3;
      if (bool) {
         i |= 16;
      }

      int wx = (int)(!forInterface ? (double)this.widthX : (this.sizeX == 1 && this.sizeY == 1 ? (double)this.widthX : (double)this.widthX / 1.5));
      int wy = (int)(!forInterface ? (double)this.widthY : (this.sizeX == 1 && this.sizeY == 1 ? (double)this.widthY : (double)this.widthY / 1.5));
      int h = (int)(!forInterface ? (double)this.height : (this.sizeX == 1 && this.sizeY == 1 ? (double)this.height : (double)this.height / 1.5));
      if (typeFlag != 0) {
         i |= 13;
      } else {
         if (wx != 128 || this.anInt2968 != 0) {
            i |= 1;
         }

         if (wy != 128 || this.anInt2985 != 0) {
            i |= 4;
         }
      }

      if (h != 128 || this.anInt3037 != 0) {
         i |= 2;
      }

      if (this.modifiedColors != null) {
         i |= 16384;
      }

      if (this.modifiedTextures != null) {
         i |= 32768;
      }

      if (this.aByte2960 != 0) {
         i |= 524288;
      }

      DrawableModel drawablemodel = null;
      if (this.possibleTypes == null) {
         return null;
      } else {
         int i_71_ = -1;
         if (b != 76) {
            return null;
         } else {
            for(int i_72_ = 0; this.possibleTypes.length > i_72_; ++i_72_) {
               if (this.possibleTypes[i_72_] == type) {
                  i_71_ = i_72_;
                  break;
               }
            }

            if (i_71_ == -1) {
               return null;
            } else {
               int[] is = class121 != null && class121.anIntArray1526 != null ? class121.anIntArray1526 : this.modelIds[i_71_];
               int i_73_ = is.length;
               if (~i_73_ < -1) {
                  long l = (long)graphicstoolkit.anInt1537;

                  for(int i_74_ = 0; i_74_ < i_73_; ++i_74_) {
                     l = l * 67783L + (long)is[i_74_];
                  }

                  synchronized(this.aClass112_3028.aClass61_1434) {
                     drawablemodel = (DrawableModel)this.aClass112_3028.aClass61_1434.method607(l, 0);
                  }

                  if (drawablemodel != null) {
                     if (drawablemodel.WA() != i_68_) {
                        i |= 4096;
                     }

                     if (~i_69_ != ~drawablemodel.da()) {
                        i |= 8192;
                     }
                  }

                  if (drawablemodel == null || graphicstoolkit.b(drawablemodel.ua(), i) != 0) {
                     int i_75_ = i | 127007;
                     if (drawablemodel != null) {
                        i_75_ = graphicstoolkit.c(i_75_, drawablemodel.ua());
                     }

                     Model model = null;
                     synchronized(WorldItem.aModelArray11008) {
                        for(int i_76_ = 0; i_76_ < i_73_; ++i_76_) {
                           synchronized(this.aClass112_3028.aClass302_1433) {
                              model = Renderer.method3448(is[i_76_] & 65535, 7, 0, this.aClass112_3028.aClass302_1433);
                           }

                           if (model == null) {
                              return null;
                           }

                           if (~model.anInt2614 > -14) {
                              model.method2081(2, 0);
                           }

                           if (i_73_ > 1) {
                              WorldItem.aModelArray11008[i_76_] = model;
                           }
                        }

                        if (~i_73_ < -2) {
                           model = new Model(WorldItem.aModelArray11008, i_73_);
                        }
                     }

                     drawablemodel = graphicstoolkit.a(model, i_75_, this.aClass112_3028.anInt1437, i_68_, i_69_);
                     synchronized(this.aClass112_3028.aClass61_1434) {
                        this.aClass112_3028.aClass61_1434.method601(drawablemodel, 25566, l);
                     }
                  }
               }

               if (drawablemodel == null) {
                  return null;
               } else {
                  DrawableModel drawablemodel_77_ = drawablemodel.method633((byte)0, i, true);
                  if (i_68_ != drawablemodel.WA()) {
                     drawablemodel_77_.C(i_68_);
                  }

                  if (drawablemodel.da() != i_69_) {
                     drawablemodel_77_.LA(i_69_);
                  }

                  if (bool) {
                     drawablemodel_77_.v();
                  }

                  if (~type == -5 && ~typeFlag < -4) {
                     drawablemodel_77_.k(2048);
                     drawablemodel_77_.H(180, 0, -180);
                  }

                  typeFlag &= 3;
                  if (typeFlag != 1) {
                     if (typeFlag != 2) {
                        if (typeFlag == 3) {
                           drawablemodel_77_.k(12288);
                        }
                     } else {
                        drawablemodel_77_.k(8192);
                     }
                  } else {
                     drawablemodel_77_.k(4096);
                  }

                  if (this.modifiedColors != null) {
                     short[] ses;
                     if (class121 != null && class121.aShortArray1523 != null) {
                        ses = class121.aShortArray1523;
                     } else {
                        ses = this.originalColors;
                     }

                     for(int i_78_ = 0; ~i_78_ > ~this.modifiedColors.length; ++i_78_) {
                        if (this.aByteArray2996 != null && this.aByteArray2996.length > i_78_) {
                           drawablemodel_77_.ia(this.modifiedColors[i_78_], EntityNode_Sub3_Sub1.aShortArray9165[255 & this.aByteArray2996[i_78_]]);
                        } else {
                           drawablemodel_77_.ia(this.modifiedColors[i_78_], ses[i_78_]);
                        }
                     }
                  }

                  if (this.modifiedTextures != null) {
                     short[] ses;
                     if (class121 != null && class121.aShortArray1524 != null) {
                        ses = class121.aShortArray1524;
                     } else {
                        ses = this.originalTextures;
                     }

                     for(int i_79_ = 0; this.modifiedTextures.length > i_79_; ++i_79_) {
                        drawablemodel_77_.aa(this.modifiedTextures[i_79_], ses[i_79_]);
                     }
                  }

                  if (this.aByte2960 != 0) {
                     drawablemodel_77_.method626(this.aByte2974, this.aByte3045, this.aByte3052, this.aByte2960 & 255);
                  }

                  if (wx != 128 || h != 128 || ~wy != -129) {
                     drawablemodel_77_.O(wx, h, wy);
                  }

                  if (~this.anInt2968 != -1 || ~this.anInt3037 != -1 || ~this.anInt2985 != -1) {
                     drawablemodel_77_.H(this.anInt2968, this.anInt3037, this.anInt2985);
                  }

                  drawablemodel_77_.s(i_70_);
                  return drawablemodel_77_;
               }
            }
         }
      }
   }

   private final void method3052(byte b, Buffer buffer) {
      ++anInt3004;
      if (b == -111) {
         int i = buffer.readUnsignedByte();

         for(int i_80_ = 0; ~i_80_ > ~i; ++i_80_) {
            ++buffer.offset;
            int length2 = buffer.readUnsignedByte();

            for(int i2 = 0; i2 < length2; ++i2) {
               buffer.readUnsignedShort();
            }
         }
      }
   }

   final int method3053(int i, int i_82_, int i_83_) {
      ++anInt3029;
      if (this.aHashTable3014 == null) {
         return i;
      } else {
         Node_Sub32 node_sub32 = (Node_Sub32)this.aHashTable3014.get(3512, (long)i_83_);
         if (i_82_ < 6) {
            this.method3034(null, 124, true);
         }

         return node_sub32 == null ? i : node_sub32.anInt7381;
      }
   }

   public ObjectDefinition() {
      this.positionZOffset = 0;
      this.aByte2960 = 0;
      this.standingOnHeightOffset = 0;
      this.anInt2971 = 0;
      this.sizeY = 1;
      this.indexOfOptionSprite1 = -1;
      this.anInt2975 = 0;
      this.positionXOffset = 0;
      this.widthX = 128;
      this.name = "null";
      this.anInt2985 = 0;
      this.aBoolean3002 = false;
      this.anInt2970 = -1;
      this.mapAreaId = -1;
      this.anInt2977 = -1;
      this.anInt3012 = 0;
      this.anInt3015 = -1;
      this.anInt3017 = -1;
      this.aBoolean3016 = false;
      this.aBoolean3007 = false;
      this.widthY = 128;
      this.positionYOffset = 0;
      this.anInt3024 = 255;
      this.anInt2958 = 0;
      this.animations = null;
      this.anInt3023 = -1;
      this.anInt2989 = 0;
      this.optionSprite1 = -1;
      this.anInt3032 = 960;
      this.aBoolean3000 = true;
      this.anInt3011 = 64;
      this.anIntArray2995 = null;
      this.bendToMap = 0;
      this.mapSpriteOffset2 = 256;
      this.indexOfOptionSprite2 = -1;
      this.anInt2968 = 0;
      this.anInt3042 = 0;
      this.clipType = 2;
      this.aBoolean2993 = false;
      this.aBoolean2998 = false;
      this.anInt3037 = 0;
      this.anInt3040 = 0;
      this.mapSpriteOffset1 = 256;
      this.anInt3026 = 0;
      this.aBoolean3051 = false;
      this.aBoolean2990 = false;
      this.aBoolean3034 = true;
      this.aBoolean2992 = false;
      this.aBoolean3053 = false;
      this.sizeX = 1;
      this.anInt2962 = 0;
      this.mapSpriteId = -1;
      this.anInt3035 = -1;
      this.optionSprite2 = -1;
      this.aBoolean3033 = true;
      this.aBoolean3056 = false;
      this.aBoolean3039 = false;
      this.anInt3057 = -1;
   }
}
