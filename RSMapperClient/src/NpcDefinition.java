public class NpcDefinition {
   protected int anInt2803;
   protected int anInt2804;
   static Class61 aClass61_2805 = new Class61(4);
   protected int headIcon;
   static int anInt2807;
   static int anInt2808;
   protected int anInt2809;
   protected int anInt2810;
   protected int size;
   protected int anInt2812;
   private HashTable aHashTable2813;
   protected int stackSpriteId = -1;
   protected int indexOfOptionSprite1;
   protected byte aByte2816;
   protected boolean aBoolean2817;
   static int anInt2818;
   static int anInt2819;
   private byte[] aByteArray2820;
   protected String name;
   static int anInt2822;
   private short[] modifiedColors;
   protected boolean aBoolean2824;
   protected boolean aBoolean2825;
   protected int anInt2826;
   protected int[] anIntArray2827;
   protected int anInt2828;
   protected short[] originalColors;
   protected int height;
   protected int registerClickRadius;
   protected int[] rightClickImages;
   protected int anInt2833;
   protected String[] rightClickActions;
   static int anInt2835;
   private byte aByte2836;
   protected int renderEmote;
   protected int combatLevel;
   private byte aByte2839;
   static int anInt2840;
   private short[] modifiedTextures;
   private int[][] anIntArrayArray2842;
   protected boolean aBoolean2843;
   protected int anInt2844;
   static int anInt2845;
   static int anInt2846;
   protected int[] anIntArray2847;
   int anInt2848;
   protected int anInt2849;
   static int anInt2850;
   static int anInt2851;
   protected int anInt2852;
   private byte aByte2853;
   protected boolean showOnMinimap;
   protected byte canClick;
   protected int indexOfOptionSprite2;
   private byte aByte2857;
   protected int width;
   protected int optionSprite1;
   protected int mouseHoverSprite;
   protected Class279 aClass279_2861;
   protected int anInt2862;
   protected short innerShadowColor;
   protected int anInt2864;
   protected int[] modelIds;
   static int anInt2866;
   protected int anInt2867;
   protected byte outerShadowBrightness;
   static int anInt2869;
   static int anInt2870;
   protected short outerShadowColor;
   int anInt2872;
   protected byte aByte2873;
   protected short[] originalTextures;
   protected boolean hasShadow;
   protected int anInt2876;
   protected byte innerShadowBrightness;
   protected int anInt2878;
   protected boolean isVisibleOnMap;
   static Class157 aClass157_2880 = new Class157();
   private int anInt2881;
   private int anInt2882;
   protected boolean aBoolean2883;
   static IncommingPacket aClass192_2884 = new IncommingPacket(42, -1);
   static int anInt2885;
   protected int optionSprite2;

   final void method2997(byte b) {
      if (this.modelIds == null) {
         this.modelIds = new int[0];
      }

      ++anInt2835;
      if (~this.canClick == 0) {
         if (Node_Sub38_Sub34.aClass353_10443 != this.aClass279_2861.aClass353_3553) {
            this.canClick = 0;
         } else {
            this.canClick = 1;
         }
      }

      if (b != -110) {
         this.aBoolean2883 = false;
      }
   }

   final boolean method2998(byte b) {
      ++anInt2866;
      if (this.anIntArray2827 == null) {
         return ~this.anInt2812 != 0 || ~this.anInt2809 != 0 || this.anInt2810 != -1;
      } else {
         int i = 0;
         if (b != 91) {
            aClass61_2805 = null;
         }

         for(; ~this.anIntArray2827.length < ~i; ++i) {
            if (~this.anIntArray2827[i] != 0) {
               NpcDefinition npcdefinition_0_ = this.aClass279_2861.getNPCDefinitions(this.anIntArray2827[i], (byte)107);
               if (npcdefinition_0_.anInt2812 != -1 || ~npcdefinition_0_.anInt2809 != 0 || ~npcdefinition_0_.anInt2810 != 0) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   final NpcDefinition method2999(int i, Interface17 interface17) {
      ++anInt2870;
      if (i != 65535) {
         return null;
      } else {
         int i_1_ = -1;
         if (this.anInt2881 != -1) {
            i_1_ = interface17.getVarpBit(this.anInt2881, (byte)-42);
         } else if (~this.anInt2882 != 0) {
            i_1_ = interface17.method65(this.anInt2882, 119);
         }

         if (i_1_ >= 0 && ~(this.anIntArray2827.length + -1) < ~i_1_ && ~this.anIntArray2827[i_1_] != 0) {
            return this.aClass279_2861.getNPCDefinitions(this.anIntArray2827[i_1_], (byte)107);
         } else {
            int i_2_ = this.anIntArray2827[this.anIntArray2827.length - 1];
            return ~i_2_ == 0 ? null : this.aClass279_2861.getNPCDefinitions(i_2_, (byte)107);
         }
      }
   }

   final void method3000(byte b, Buffer buffer) {
      ++anInt2840;
      if (b < 38) {
         this.anInt2833 = -38;
      }

      while(true) {
         int i = buffer.readUnsignedByte();
         if (i == 0) {
            return;
         }

         this.method3004(i, buffer, (byte)-121);
      }
   }

   static final void method3001(Index class302, Index class302_3_, Index class302_4_, byte b, Index class302_5_) {
      Class262_Sub10.aClass302_7776 = class302_4_;
      ++anInt2807;
      Node_Sub38_Sub31.aClass302_10422 = class302;
      if (b >= 17) {
         GLXToolkit.aClass302_9274 = class302_5_;
         Class134_Sub3.aWidgetArrayArray9035 = new IComponentDefinitions[Node_Sub38_Sub31.aClass302_10422.method3526(-20871)][];
         Class169_Sub1.aBooleanArray8788 = new boolean[Node_Sub38_Sub31.aClass302_10422.method3526(-20871)];
      }
   }

   static final void method3002(byte b) {
      if (b == 97) {
         ++anInt2819;
         CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 15, 0L);
         cachenode_sub2.method2291((byte)121);
      }
   }

   public static void method3003(byte b) {
      aClass157_2880 = null;
      if (b >= -24) {
         aClass157_2880 = null;
      }

      aClass192_2884 = null;
      aClass61_2805 = null;
   }

   private final void method3004(int opcode, Buffer buffer, byte b) {
      ++anInt2808;
      if (opcode == 1) {
         int i_6_ = buffer.readUnsignedByte();
         this.modelIds = new int[i_6_];

         for(int i_7_ = 0; ~i_6_ < ~i_7_; ++i_7_) {
            this.modelIds[i_7_] = buffer.readUnsignedShort();
            if (~this.modelIds[i_7_] == -65536) {
               this.modelIds[i_7_] = -1;
            }
         }
      } else if (opcode == 2) {
         this.name = buffer.readString();
      } else if (opcode == 12) {
         this.size = buffer.readUnsignedByte();
      } else if (opcode >= 30 && ~opcode > -36) {
         this.rightClickActions[-30 + opcode] = buffer.readString();
      } else if (~opcode != -41) {
         if (opcode == 41) {
            int i_8_ = buffer.readUnsignedByte();
            this.originalTextures = new short[i_8_];
            this.modifiedTextures = new short[i_8_];

            for(int i_9_ = 0; i_9_ < i_8_; ++i_9_) {
               this.modifiedTextures[i_9_] = (short)buffer.readUnsignedShort();
               this.originalTextures[i_9_] = (short)buffer.readUnsignedShort();
            }
         } else if (opcode != 42) {
            if (opcode == 60) {
               int i_10_ = buffer.readUnsignedByte();
               this.anIntArray2847 = new int[i_10_];

               for(int i_11_ = 0; ~i_10_ < ~i_11_; ++i_11_) {
                  this.anIntArray2847[i_11_] = buffer.readUnsignedShort();
               }
            } else if (opcode == 93) {
               this.isVisibleOnMap = false;
            } else if (opcode != 95) {
               if (opcode == 97) {
                  this.width = buffer.readUnsignedShort();
               } else if (opcode != 98) {
                  if (opcode != 99) {
                     if (opcode != 100) {
                        if (opcode != 101) {
                           if (opcode == 102) {
                              this.headIcon = buffer.readUnsignedShort();
                           } else if (opcode != 103) {
                              if (opcode == 106 || opcode == 118) {
                                 this.anInt2881 = buffer.readUnsignedShort();
                                 if (this.anInt2881 == 65535) {
                                    this.anInt2881 = -1;
                                 }

                                 this.anInt2882 = buffer.readUnsignedShort();
                                 if (this.anInt2882 == 65535) {
                                    this.anInt2882 = -1;
                                 }

                                 int i_12_ = -1;
                                 if (opcode == 118) {
                                    i_12_ = buffer.readUnsignedShort();
                                    if (i_12_ == 65535) {
                                       i_12_ = -1;
                                    }
                                 }

                                 int i_13_ = buffer.readUnsignedByte();
                                 this.anIntArray2827 = new int[i_13_ - -2];

                                 for(int i_14_ = 0; i_13_ >= i_14_; ++i_14_) {
                                    this.anIntArray2827[i_14_] = buffer.readUnsignedShort();
                                    if (this.anIntArray2827[i_14_] == 65535) {
                                       this.anIntArray2827[i_14_] = -1;
                                    }
                                 }

                                 this.anIntArray2827[i_13_ - -1] = i_12_;
                              } else if (opcode != 107) {
                                 if (opcode == 109) {
                                    this.aBoolean2817 = false;
                                 } else if (opcode != 111) {
                                    if (opcode == 113) {
                                       this.innerShadowColor = (short)buffer.readUnsignedShort();
                                       this.outerShadowColor = (short)buffer.readUnsignedShort();
                                    } else if (opcode == 114) {
                                       this.innerShadowBrightness = buffer.readByte();
                                       this.outerShadowBrightness = buffer.readByte();
                                    } else if (~opcode != -120) {
                                       if (~opcode != -122) {
                                          if (~opcode != -123) {
                                             if (~opcode != -124) {
                                                if (opcode == 125) {
                                                   this.aByte2873 = buffer.readByte();
                                                } else if (opcode != 127) {
                                                   if (opcode == 128) {
                                                      buffer.readUnsignedByte();
                                                   } else if (opcode == 134) {
                                                      this.anInt2812 = buffer.readUnsignedShort();
                                                      if (this.anInt2812 == 65535) {
                                                         this.anInt2812 = -1;
                                                      }

                                                      this.anInt2833 = buffer.readUnsignedShort();
                                                      if (this.anInt2833 == 65535) {
                                                         this.anInt2833 = -1;
                                                      }

                                                      this.anInt2809 = buffer.readUnsignedShort();
                                                      if (this.anInt2809 == 65535) {
                                                         this.anInt2809 = -1;
                                                      }

                                                      this.anInt2810 = buffer.readUnsignedShort();
                                                      if (this.anInt2810 == 65535) {
                                                         this.anInt2810 = -1;
                                                      }

                                                      this.anInt2864 = buffer.readUnsignedByte();
                                                   } else if (~opcode != -136) {
                                                      if (~opcode != -137) {
                                                         if (~opcode == -138) {
                                                            this.mouseHoverSprite = buffer.readUnsignedShort();
                                                         } else if (opcode != 138) {
                                                            if (~opcode == -140) {
                                                               this.anInt2826 = buffer.readUnsignedShort();
                                                            } else if (opcode == 140) {
                                                               this.anInt2828 = buffer.readUnsignedByte();
                                                            } else if (~opcode != -142) {
                                                               if (~opcode == -143) {
                                                                  this.anInt2849 = buffer.readUnsignedShort();
                                                               } else if (~opcode == -144) {
                                                                  this.aBoolean2825 = true;
                                                               } else if (~opcode <= -151 && ~opcode > -156) {
                                                                  this.rightClickActions[-150 + opcode] = buffer.readString();
                                                                  if (!this.aClass279_2861.aBoolean3556) {
                                                                     this.rightClickActions[opcode + -150] = null;
                                                                  }
                                                               } else if (~opcode != -156) {
                                                                  if (~opcode != -159) {
                                                                     if (opcode == 159) {
                                                                        this.canClick = 0;
                                                                     } else if (opcode == 160) {
                                                                        int i_15_ = buffer.readUnsignedByte();
                                                                        this.rightClickImages = new int[i_15_];

                                                                        for(int i_16_ = 0; ~i_16_ > ~i_15_; ++i_16_) {
                                                                           this.rightClickImages[i_16_] = buffer.readUnsignedShort();
                                                                        }
                                                                     } else if (opcode != 162) {
                                                                        if (opcode == 163) {
                                                                           this.anInt2803 = buffer.readUnsignedByte();
                                                                        } else if (opcode != 164) {
                                                                           if (~opcode == -166) {
                                                                              this.registerClickRadius = buffer.readUnsignedByte();
                                                                           } else if (opcode == 168) {
                                                                              this.anInt2862 = buffer.readUnsignedByte();
                                                                           } else if (opcode == 249) {
                                                                              int i_17_ = buffer.readUnsignedByte();
                                                                              if (this.aHashTable2813 == null) {
                                                                                 int i_18_ = Class320_Sub19.method3753(i_17_);
                                                                                 this.aHashTable2813 = new HashTable(i_18_);
                                                                              }

                                                                              for(int i_19_ = 0; ~i_17_ < ~i_19_; ++i_19_) {
                                                                                 boolean bool = buffer.readUnsignedByte() == 1;
                                                                                 int i_20_ = buffer.read24BitInteger();
                                                                                 Node node;
                                                                                 if (!bool) {
                                                                                    node = new Node_Sub32(buffer.readInt());
                                                                                 } else {
                                                                                    node = new Node_Sub18(buffer.readString());
                                                                                 }

                                                                                 this.aHashTable2813.put((long)i_20_, node, -127);
                                                                              }
                                                                           } else {
                                                                              System.out.println("NPC DEF: " + opcode);
                                                                           }
                                                                        } else {
                                                                           this.anInt2844 = buffer.readUnsignedShort();
                                                                           this.anInt2852 = buffer.readUnsignedShort();
                                                                        }
                                                                     } else {
                                                                        this.aBoolean2883 = true;
                                                                     }
                                                                  } else {
                                                                     this.canClick = 1;
                                                                  }
                                                               } else {
                                                                  this.aByte2836 = buffer.readByte();
                                                                  this.aByte2853 = buffer.readByte();
                                                                  this.aByte2857 = buffer.readByte();
                                                                  this.aByte2839 = buffer.readByte();
                                                               }
                                                            } else {
                                                               this.aBoolean2843 = true;
                                                            }
                                                         } else {
                                                            this.stackSpriteId = buffer.readUnsignedShort();
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
                                                   this.renderEmote = buffer.readUnsignedShort();
                                                }
                                             } else {
                                                this.anInt2804 = buffer.readUnsignedShort();
                                             }
                                          } else {
                                             this.anInt2878 = buffer.readUnsignedShort();
                                          }
                                       } else {
                                          this.anIntArrayArray2842 = new int[this.modelIds.length][];
                                          int i_21_ = buffer.readUnsignedByte();

                                          for(int i_22_ = 0; i_22_ < i_21_; ++i_22_) {
                                             int i_23_ = buffer.readUnsignedByte();
                                             int[] is = this.anIntArrayArray2842[i_23_] = new int[3];
                                             is[0] = buffer.readByte();
                                             is[1] = buffer.readByte();
                                             is[2] = buffer.readByte();
                                          }
                                       }
                                    } else {
                                       this.aByte2816 = buffer.readByte();
                                    }
                                 } else {
                                    this.hasShadow = false;
                                 }
                              } else {
                                 this.showOnMinimap = false;
                              }
                           } else {
                              this.anInt2876 = buffer.readUnsignedShort();
                           }
                        } else {
                           this.anInt2872 = 5 * buffer.readByte();
                        }
                     } else {
                        this.anInt2848 = buffer.readByte();
                     }
                  } else {
                     this.aBoolean2824 = true;
                  }
               } else {
                  this.height = buffer.readUnsignedShort();
               }
            } else {
               this.combatLevel = buffer.readUnsignedShort();
            }
         } else {
            int i_24_ = buffer.readUnsignedByte();
            this.aByteArray2820 = new byte[i_24_];

            for(int i_25_ = 0; ~i_24_ < ~i_25_; ++i_25_) {
               this.aByteArray2820[i_25_] = buffer.readByte();
            }
         }
      } else {
         int i_26_ = buffer.readUnsignedByte();
         this.originalColors = new short[i_26_];
         this.modifiedColors = new short[i_26_];

         for(int i_27_ = 0; ~i_26_ < ~i_27_; ++i_27_) {
            this.modifiedColors[i_27_] = (short)buffer.readUnsignedShort();
            this.originalColors[i_27_] = (short)buffer.readUnsignedShort();
         }
      }

      if (b >= -66) {
         this.width = 38;
      }
   }

   final String method3005(byte b, String string, int i) {
      ++anInt2851;
      if (b >= -118) {
         return null;
      } else if (this.aHashTable2813 == null) {
         return string;
      } else {
         Node_Sub18 node_sub18 = (Node_Sub18)this.aHashTable2813.get(3512, (long)i);
         return node_sub18 == null ? string : node_sub18.aString7149;
      }
   }

   final DrawableModel prepareModelToInterface(
      int i, Animator animator, Class361 class361, int i_28_, GraphicsToolkit graphicstoolkit, Interface17 interface17
   ) {
      ++anInt2846;
      if (this.anIntArray2827 != null) {
         NpcDefinition npcdefinition_29_ = this.method2999(i_28_ + -412695537, interface17);
         return npcdefinition_29_ == null ? null : npcdefinition_29_.prepareModelToInterface(i, animator, class361, 412761072, graphicstoolkit, interface17);
      } else if (this.anIntArray2847 != null || class361 != null && class361.anIntArray4482 != null) {
         if (i_28_ != 412761072) {
            this.combatLevel = 31;
         }

         int i_30_ = i;
         if (animator != null) {
            i_30_ = i | animator.method237((byte)-126);
         }

         long l = (long)(graphicstoolkit.anInt1537 << 16 | this.anInt2867);
         if (class361 != null) {
            l |= class361.aLong4488 << 24;
         }

         DrawableModel drawablemodel;
         synchronized(this.aClass279_2861.aClass61_3566) {
            drawablemodel = (DrawableModel)this.aClass279_2861.aClass61_3566.method607(l, 0);
         }

         if (drawablemodel == null || ~(drawablemodel.ua() & i_30_) != ~i_30_) {
            if (drawablemodel != null) {
               i_30_ |= drawablemodel.ua();
            }

            int i_31_ = i_30_;
            if (this.modifiedColors != null) {
               i_31_ = i_30_ | 16384;
            }

            if (this.modifiedTextures != null) {
               i_31_ |= 32768;
            }

            if (~this.aByte2839 != -1) {
               i_31_ |= 524288;
            }

            int[] is = class361 != null && class361.anIntArray4482 != null ? class361.anIntArray4482 : this.anIntArray2847;
            boolean bool = false;
            synchronized(this.aClass279_2861.aClass302_3564) {
               for(int i_32_ = 0; ~i_32_ > ~is.length; ++i_32_) {
                  if (!this.aClass279_2861.aClass302_3564.method3515(0, is[i_32_], 0)) {
                     bool = true;
                  }
               }
            }

            if (bool) {
               return null;
            }

            Model[] models = new Model[is.length];
            synchronized(this.aClass279_2861.aClass302_3564) {
               for(int i_33_ = 0; ~i_33_ > ~is.length; ++i_33_) {
                  models[i_33_] = Renderer.method3448(is[i_33_], 7, 0, this.aClass279_2861.aClass302_3564);
               }
            }

            for(int i_34_ = 0; i_34_ < is.length; ++i_34_) {
               if (models[i_34_] != null && models[i_34_].anInt2614 < 13) {
                  models[i_34_].method2081(2, 0);
               }
            }

            Model model;
            if (~models.length != -2) {
               model = new Model(models, models.length);
            } else {
               model = models[0];
            }

            drawablemodel = graphicstoolkit.a(model, i_31_, this.aClass279_2861.anInt3567, 64, 768);
            if (this.modifiedColors != null) {
               short[] ses;
               if (class361 != null && class361.aShortArray4487 != null) {
                  ses = class361.aShortArray4487;
               } else {
                  ses = this.originalColors;
               }

               for(int i_35_ = 0; ~i_35_ > ~this.modifiedColors.length; ++i_35_) {
                  if (this.aByteArray2820 != null && this.aByteArray2820.length > i_35_) {
                     drawablemodel.ia(this.modifiedColors[i_35_], Class262_Sub19.aShortArray7852[this.aByteArray2820[i_35_] & 255]);
                  } else {
                     drawablemodel.ia(this.modifiedColors[i_35_], ses[i_35_]);
                  }
               }
            }

            if (this.modifiedTextures != null) {
               short[] ses;
               if (class361 != null && class361.aShortArray4485 != null) {
                  ses = class361.aShortArray4485;
               } else {
                  ses = this.originalTextures;
               }

               for(int i_36_ = 0; ~i_36_ > ~this.modifiedTextures.length; ++i_36_) {
                  drawablemodel.aa(this.modifiedTextures[i_36_], ses[i_36_]);
               }
            }

            if (this.aByte2839 != 0) {
               drawablemodel.method626(this.aByte2836, this.aByte2853, this.aByte2857, 255 & this.aByte2839);
            }

            drawablemodel.s(i_30_);
            synchronized(this.aClass279_2861.aClass61_3566) {
               this.aClass279_2861.aClass61_3566.method601(drawablemodel, 25566, l);
            }
         }

         if (animator != null) {
            drawablemodel = drawablemodel.method633((byte)1, i_30_, true);
            animator.method225(0, drawablemodel, 0);
         }

         drawablemodel.s(i);
         return drawablemodel;
      } else {
         return null;
      }
   }

   final DrawableModel prepareModel(
      Interface17 interface17,
      GraphicsToolkit graphicstoolkit,
      Class281 class281,
      byte b,
      Animator animator,
      int i,
      int[] is,
      Class361 class361,
      Animator animator_37_,
      int i_38_,
      Animator[] animators
   ) {
      ++anInt2869;
      if (this.anIntArray2827 != null) {
         NpcDefinition npcdefinition_39_ = this.method2999(65535, interface17);
         return npcdefinition_39_ == null
            ? null
            : npcdefinition_39_.prepareModel(interface17, graphicstoolkit, class281, (byte)-93, animator, i, is, class361, animator_37_, i_38_, animators);
      } else {
         int i_40_ = i_38_;
         if (this.height != 128) {
            i_40_ = i_38_ | 2;
         }

         if (this.width != 128) {
            i_40_ |= 5;
         }

         boolean bool = false;
         int i_41_ = animators == null ? 0 : animators.length;

         for(int i_42_ = 0; ~i_41_ < ~i_42_; ++i_42_) {
            if (animators[i_42_] != null) {
               i_40_ |= animators[i_42_].method237((byte)-126);
               bool = true;
            }
         }

         if (animator != null) {
            bool = true;
            i_40_ |= animator.method237((byte)-128);
         }

         if (animator_37_ != null) {
            i_40_ |= animator_37_.method237((byte)-128);
            bool = true;
         }

         long l = (long)(this.anInt2867 | graphicstoolkit.anInt1537 << 16);
         if (class361 != null) {
            l |= class361.aLong4488 << 24;
         }

         DrawableModel drawablemodel;
         synchronized(this.aClass279_2861.aClass61_3565) {
            drawablemodel = (DrawableModel)this.aClass279_2861.aClass61_3565.method607(l, 0);
         }

         RenderDefinitions animDefinitions = null;
         if (this.renderEmote != -1) {
            animDefinitions = class281.getAnimationAndSoundDefinitionsFor(this.renderEmote);
         }

         if (drawablemodel == null || i_40_ != (drawablemodel.ua() & i_40_)) {
            if (drawablemodel != null) {
               i_40_ |= drawablemodel.ua();
            }

            int i_43_ = i_40_;
            if (this.modifiedColors != null) {
               i_43_ = i_40_ | 16384;
            }

            if (this.modifiedTextures != null) {
               i_43_ |= 32768;
            }

            if (this.aByte2839 != 0) {
               i_43_ |= 524288;
            }

            int[] is_44_ = class361 != null && class361.anIntArray4482 != null ? class361.anIntArray4482 : this.modelIds;
            boolean bool_45_ = false;
            synchronized(this.aClass279_2861.aClass302_3564) {
               for(int i_46_ = 0; i_46_ < is_44_.length; ++i_46_) {
                  if (is_44_[i_46_] != -1 && !this.aClass279_2861.aClass302_3564.method3515(0, is_44_[i_46_], 0)) {
                     bool_45_ = true;
                  }
               }
            }

            if (bool_45_) {
               return null;
            }

            Model[] models = new Model[is_44_.length];

            for(int i_47_ = 0; i_47_ < is_44_.length; ++i_47_) {
               if (is_44_[i_47_] != -1) {
                  synchronized(this.aClass279_2861.aClass302_3564) {
                     models[i_47_] = Renderer.method3448(is_44_[i_47_], 7, 0, this.aClass279_2861.aClass302_3564);
                  }

                  if (models[i_47_] != null) {
                     if (models[i_47_].anInt2614 < 13) {
                        models[i_47_].method2081(2, 0);
                     }

                     if (this.anIntArrayArray2842 != null && this.anIntArrayArray2842[i_47_] != null) {
                        models[i_47_]
                           .method2082(this.anIntArrayArray2842[i_47_][0], this.anIntArrayArray2842[i_47_][1], 126, this.anIntArrayArray2842[i_47_][2]);
                     }
                  }
               }
            }

            if (animDefinitions != null && animDefinitions.anIntArrayArray3273 != null) {
               for(int i_48_ = 0; i_48_ < animDefinitions.anIntArrayArray3273.length; ++i_48_) {
                  if (i_48_ < models.length && models[i_48_] != null) {
                     int i_49_ = 0;
                     int i_50_ = 0;
                     int i_51_ = 0;
                     int i_52_ = 0;
                     int i_53_ = 0;
                     int i_54_ = 0;
                     if (animDefinitions.anIntArrayArray3273[i_48_] != null) {
                        i_52_ = animDefinitions.anIntArrayArray3273[i_48_][3] << 3;
                        i_53_ = animDefinitions.anIntArrayArray3273[i_48_][4] << 3;
                        i_50_ = animDefinitions.anIntArrayArray3273[i_48_][1];
                        i_49_ = animDefinitions.anIntArrayArray3273[i_48_][0];
                        i_54_ = animDefinitions.anIntArrayArray3273[i_48_][5] << 3;
                        i_51_ = animDefinitions.anIntArrayArray3273[i_48_][2];
                     }

                     if (i_52_ != 0 || i_53_ != 0 || i_54_ != 0) {
                        models[i_48_].method2085(i_54_, i_52_, -119, i_53_);
                     }

                     if (i_49_ != 0 || i_50_ != 0 || i_51_ != 0) {
                        models[i_48_].method2082(i_49_, i_50_, -79, i_51_);
                     }
                  }
               }
            }

            Model model;
            if (models.length == 1) {
               model = models[0];
            } else {
               model = new Model(models, models.length);
            }

            drawablemodel = graphicstoolkit.a(model, i_43_, this.aClass279_2861.anInt3567, this.anInt2848 + 64, 850 + this.anInt2872);
            if (this.modifiedColors != null) {
               short[] ses;
               if (class361 != null && class361.aShortArray4487 != null) {
                  ses = class361.aShortArray4487;
               } else {
                  ses = this.originalColors;
               }

               for(int i_55_ = 0; i_55_ < this.modifiedColors.length; ++i_55_) {
                  if (this.aByteArray2820 != null && i_55_ < this.aByteArray2820.length) {
                     drawablemodel.ia(this.modifiedColors[i_55_], Class262_Sub19.aShortArray7852[255 & this.aByteArray2820[i_55_]]);
                  } else {
                     drawablemodel.ia(this.modifiedColors[i_55_], ses[i_55_]);
                  }
               }
            }

            if (this.modifiedTextures != null) {
               short[] ses;
               if (class361 != null && class361.aShortArray4485 != null) {
                  ses = class361.aShortArray4485;
               } else {
                  ses = this.originalTextures;
               }

               for(int i_56_ = 0; i_56_ < this.modifiedTextures.length; ++i_56_) {
                  drawablemodel.aa(this.modifiedTextures[i_56_], ses[i_56_]);
               }
            }

            if (this.aByte2839 != 0) {
               drawablemodel.method626(this.aByte2836, this.aByte2853, this.aByte2857, 255 & this.aByte2839);
            }

            drawablemodel.s(i_40_);
            synchronized(this.aClass279_2861.aClass61_3565) {
               this.aClass279_2861.aClass61_3565.method601(drawablemodel, 25566, l);
            }
         }

         DrawableModel drawablemodel_57_ = drawablemodel.method633((byte)4, i_40_, true);
         boolean bool_59_ = false;
         if (is != null) {
            for(int i_60_ = 0; i_60_ < 12; ++i_60_) {
               if (is[i_60_] != -1) {
                  bool_59_ = true;
               }
            }
         }

         if (!bool && !bool_59_) {
            return drawablemodel_57_;
         } else {
            Class336[] class336s = null;
            if (animDefinitions != null) {
               class336s = animDefinitions.method3131(3, graphicstoolkit);
            }

            if (bool_59_ && class336s != null) {
               for(int i_61_ = 0; i_61_ < 12; ++i_61_) {
                  if (class336s[i_61_] != null) {
                     drawablemodel_57_.method630(class336s[i_61_], 1 << i_61_, true);
                  }
               }
            }

            int i_62_ = 0;

            for(int i_63_ = 1; i_62_ < i_41_; i_63_ <<= 1) {
               if (animators[i_62_] != null) {
                  animators[i_62_].method246(i_63_, 0, true, drawablemodel_57_);
               }

               ++i_62_;
            }

            if (bool_59_) {
               for(int i_64_ = 0; i_64_ < 12; ++i_64_) {
                  if (is[i_64_] != -1) {
                     int i_65_ = is[i_64_] - i;
                     i_65_ &= 16383;
                     Class336 class336 = graphicstoolkit.y();
                     class336.method3860(i_65_);
                     drawablemodel_57_.method630(class336, 1 << i_64_, false);
                  }
               }
            }

            if (bool_59_ && class336s != null) {
               for(int i_66_ = 0; i_66_ < 12; ++i_66_) {
                  if (class336s[i_66_] != null) {
                     drawablemodel_57_.method630(class336s[i_66_], 1 << i_66_, false);
                  }
               }
            }

            if (animator != null && animator_37_ != null) {
               Node_Sub36.method2754(animator, drawablemodel_57_, animator_37_, (byte)-14);
            } else if (animator == null && animator_37_ != null) {
               animator_37_.method225(0, drawablemodel_57_, 0);
            } else {
               animator.method225(0, drawablemodel_57_, 0);
            }

            if (this.width != 128 || this.height != 128) {
               drawablemodel_57_.O(this.width, this.height, this.width);
            }

            drawablemodel_57_.s(i_38_);
            return drawablemodel_57_;
         }
      }
   }

   static final Class355 method3008(byte b, int i) {
      ++anInt2822;
      Class355 class355 = (Class355)Class155.aClass61_1952.method607((long)i, 0);
      if (class355 != null) {
         return class355;
      } else {
         byte[] bs = Node_Sub38_Sub19.aClass302_10286.getFile(false, i, 0);
         class355 = new Class355();
         if (bs != null) {
            class355.method4018((byte)105, new Buffer(bs));
         }

         class355.method4016(2);
         Class155.aClass61_1952.method601(class355, 25566, (long)i);
         return class355;
      }
   }

   final int method3009(int i, int i_68_, int i_69_) {
      ++anInt2850;
      if (this.aHashTable2813 == null) {
         return i_69_;
      } else {
         Node_Sub32 node_sub32 = (Node_Sub32)this.aHashTable2813.get(3512, (long)i_68_);
         return node_sub32 == null ? i_69_ : node_sub32.anInt7381;
      }
   }

   final boolean method3010(byte b, Interface17 interface17) {
      ++anInt2818;
      if (this.anIntArray2827 == null) {
         return true;
      } else {
         if (b < 18) {
            this.anInt2878 = 75;
         }

         int i = -1;
         if (this.anInt2881 == -1) {
            if (~this.anInt2882 != 0) {
               i = interface17.method65(this.anInt2882, 111);
            }
         } else {
            i = interface17.getVarpBit(this.anInt2881, (byte)-42);
         }

         if (i >= 0 && i < -1 + this.anIntArray2827.length && this.anIntArray2827[i] != -1) {
            return true;
         } else {
            int i_71_ = this.anIntArray2827[-1 + this.anIntArray2827.length];
            return i_71_ != -1;
         }
      }
   }

   public NpcDefinition() {
      this.anInt2809 = -1;
      this.size = 1;
      this.anInt2803 = -1;
      this.aBoolean2817 = true;
      this.anInt2804 = -1;
      this.aBoolean2843 = false;
      this.height = 128;
      this.anInt2833 = -1;
      this.aBoolean2825 = false;
      this.combatLevel = -1;
      this.anInt2826 = -1;
      this.aBoolean2824 = false;
      this.canClick = -1;
      this.aByte2816 = 0;
      this.aByte2839 = 0;
      this.anInt2812 = -1;
      this.anInt2844 = 256;
      this.showOnMinimap = true;
      this.name = "null";
      this.width = 128;
      this.anInt2810 = -1;
      this.headIcon = -1;
      this.anInt2852 = 256;
      this.mouseHoverSprite = -1;
      this.optionSprite1 = -1;
      this.registerClickRadius = 0;
      this.renderEmote = -1;
      this.anInt2862 = 0;
      this.innerShadowColor = 0;
      this.anInt2864 = 0;
      this.outerShadowBrightness = -16;
      this.anInt2848 = 0;
      this.anInt2849 = -1;
      this.indexOfOptionSprite2 = -1;
      this.hasShadow = true;
      this.outerShadowColor = 0;
      this.anInt2872 = 0;
      this.anInt2828 = 255;
      this.anInt2881 = -1;
      this.innerShadowBrightness = -96;
      this.isVisibleOnMap = true;
      this.anInt2878 = -1;
      this.aByte2873 = 4;
      this.anInt2882 = -1;
      this.indexOfOptionSprite1 = -1;
      this.anInt2876 = 32;
      this.optionSprite2 = -1;
   }
}
