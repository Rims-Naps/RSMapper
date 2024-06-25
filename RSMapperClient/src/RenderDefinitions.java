public class RenderDefinitions {
   static int anInt3248;
   protected int[][] anIntArrayArray3249;
   protected int anInt3250;
   static int anInt3251;
   protected int anInt3252;
   protected int anInt3253;
   static int anInt3254 = 0;
   protected int[] anIntArray3255;
   protected int anInt3256;
   static int anInt3257;
   protected int anInt3258 = 0;
   protected int idleAnimation;
   protected int anInt3260;
   protected int modelHeightOffset1;
   protected int anInt3262;
   protected int anInt3263;
   static int anInt3264;
   protected Class281 aClass281_3265;
   protected int anInt3266;
   protected boolean aBoolean3267;
   static Class68 aClass68_3268 = new Class68(2);
   protected int anInt3269;
   protected int anInt3270;
   protected int anInt3271 = -1;
   protected int anInt3272;
   protected int[][] anIntArrayArray3273;
   protected int anInt3274;
   protected int anInt3275;
   protected int[] anIntArray3276;
   protected int walkAnimation;
   protected int anInt3278 = 0;
   static int anInt3279;
   private Class336[] aClass336Array3280;
   private int anInt3281;
   protected int anInt3282;
   protected int anInt3283;
   protected int anInt3284;
   protected int anInt3285;
   protected int anInt3286;
   protected int anInt3287;
   static int anInt3288;
   protected int anInt3289;
   protected int anInt3290;
   protected int anInt3291;
   protected int anInt3292;
   protected int anInt3293;
   protected int[] anIntArray3294;
   private int anInt3295;
   static int[] anIntArray3296 = new int[2];
   protected int anInt3297;
   protected int anInt3298;
   protected int anInt3299;
   static int anInt3300;
   protected int anInt3301;
   protected int[] anIntArray3302;
   protected int anInt3303;
   protected int anInt3304;
   protected int anInt3305;

   final int method3128(boolean bool) {
      ++anInt3288;
      if (bool) {
         this.method3128(false);
      }

      if (~this.idleAnimation != 0) {
         return this.idleAnimation;
      } else if (this.anIntArray3294 == null) {
         return -1;
      } else {
         int i = (int)((double)this.anInt3281 * Math.random());

         int i_0_;
         for(i_0_ = 0; i >= this.anIntArray3302[i_0_]; ++i_0_) {
            i -= this.anIntArray3302[i_0_];
         }

         return this.anIntArray3294[i_0_];
      }
   }

   public static void method3129(byte b) {
      anIntArray3296 = null;
      aClass68_3268 = null;
      if (b <= 21) {
         method3129((byte)11);
      }
   }

   final boolean method3130(int i, byte b) {
      ++anInt3279;
      if (i == -1) {
         return false;
      } else if (i == this.idleAnimation) {
         return true;
      } else {
         if (b >= -126) {
            this.anInt3304 = -27;
         }

         if (this.anIntArray3294 != null) {
            for(int i_1_ = 0; ~this.anIntArray3294.length < ~i_1_; ++i_1_) {
               if (~this.anIntArray3294[i_1_] == ~i) {
                  return true;
               }
            }
         }

         return false;
      }
   }

   final Class336[] method3131(int i, GraphicsToolkit graphicstoolkit) {
      ++anInt3257;
      if (this.aClass336Array3280 != null && ~this.anInt3295 == ~graphicstoolkit.anInt1537) {
         return this.aClass336Array3280;
      } else if (this.anIntArrayArray3273 == null) {
         return null;
      } else {
         this.aClass336Array3280 = new Class336[this.anIntArrayArray3273.length];

         for(int i_2_ = 0; i_2_ < this.anIntArrayArray3273.length; ++i_2_) {
            int i_3_ = 0;
            int i_4_ = 0;
            int i_5_ = 0;
            int i_6_ = 0;
            int i_7_ = 0;
            int i_8_ = 0;
            if (this.anIntArrayArray3273[i_2_] != null) {
               i_5_ = this.anIntArrayArray3273[i_2_][2];
               i_8_ = this.anIntArrayArray3273[i_2_][5] << 3;
               i_7_ = this.anIntArrayArray3273[i_2_][4] << 3;
               i_4_ = this.anIntArrayArray3273[i_2_][1];
               i_6_ = this.anIntArrayArray3273[i_2_][3] << 3;
               i_3_ = this.anIntArrayArray3273[i_2_][0];
            }

            if (i_3_ != 0 || i_4_ != 0 || ~i_5_ != -1 || i_6_ != 0 || ~i_7_ != -1 || i_8_ != 0) {
               Class336 class336 = this.aClass336Array3280[i_2_] = graphicstoolkit.y();
               if (i_8_ != 0) {
                  class336.method3868(i_8_);
               }

               if (i_6_ != 0) {
                  class336.method3859(i_6_);
               }

               if (~i_7_ != -1) {
                  class336.method3856(i_7_);
               }

               class336.method3863(i_3_, i_4_, i_5_);
            }
         }

         if (i != 3) {
            this.method3133(-108, null, -55);
         }

         return this.aClass336Array3280;
      }
   }

   static final void method3132(int i, int i_9_, int i_10_, byte b) {
      ++anInt3248;
      i = Class213.aNode_Sub27_2512.aClass320_Sub25_7274.method3776(false) * i >> 8;
      System.out.println("method3132 (sound): " + i + " - " + i_9_ + " - " + i_10_);
      if (~i != -1 && ~i_9_ != 0) {
         if (!Class377_Sub1.aBoolean8775 && ~Class313.anInt4013 != 0 && Class36.method390(b ^ 17) && !Class113.method1152(-85)) {
            EntityNode_Sub1.aNode_Sub9_Sub1_5929 = Class230.method2129((byte)-127);
            Node_Sub9_Sub1 node_sub9_sub1 = Class32.method359(EntityNode_Sub1.aNode_Sub9_Sub1_5929, -9293);
            AnimableAnimator_Sub1.method256(true, 1405, node_sub9_sub1);
         }

         Class339_Sub8.method3946(i_9_, 0, i, Class179.index11, false, 23732);
         Class304.method3544(255, -1, b ^ 28);
         Class377_Sub1.aBoolean8775 = true;
      }

      if (b != 110) {
         method3132(82, -60, -41, (byte)29);
      }
   }

   private final void method3133(int i, Buffer buffer, int i_11_) {
      if (i < -114) {
         if (i_11_ == 1) {
            this.idleAnimation = buffer.readUnsignedShort();
            this.walkAnimation = buffer.readUnsignedShort();
            if (~this.idleAnimation == -65536) {
               this.idleAnimation = -1;
            }

            if (~this.walkAnimation == -65536) {
               this.walkAnimation = -1;
            }
         } else if (i_11_ != 2) {
            if (i_11_ == 3) {
               this.anInt3297 = buffer.readUnsignedShort();
            } else if (~i_11_ == -5) {
               this.anInt3269 = buffer.readUnsignedShort();
            } else if (~i_11_ != -6) {
               if (i_11_ != 6) {
                  if (~i_11_ != -8) {
                     if (i_11_ != 8) {
                        if (i_11_ != 9) {
                           if (~i_11_ != -27) {
                              if (~i_11_ == -28) {
                                 if (this.anIntArrayArray3273 == null) {
                                    this.anIntArrayArray3273 = new int[this.aClass281_3265.aClass363_3578.anIntArray4508.length][];
                                 }

                                 int i_12_ = buffer.readUnsignedByte();
                                 this.anIntArrayArray3273[i_12_] = new int[6];

                                 for(int i_13_ = 0; i_13_ < 6; ++i_13_) {
                                    this.anIntArrayArray3273[i_12_][i_13_] = buffer.readShort();
                                 }
                              } else if (i_11_ != 28) {
                                 if (i_11_ != 29) {
                                    if (i_11_ != 30) {
                                       if (i_11_ != 31) {
                                          if (~i_11_ == -33) {
                                             this.anInt3284 = buffer.readUnsignedShort();
                                          } else if (~i_11_ != -34) {
                                             if (~i_11_ != -35) {
                                                if (~i_11_ == -36) {
                                                   this.anInt3289 = buffer.readUnsignedShort();
                                                } else if (~i_11_ == -37) {
                                                   this.anInt3285 = buffer.readShort();
                                                } else if (~i_11_ == -38) {
                                                   this.anInt3256 = buffer.readUnsignedByte();
                                                } else if (i_11_ == 38) {
                                                   this.anInt3299 = buffer.readUnsignedShort();
                                                } else if (i_11_ != 39) {
                                                   if (i_11_ == 40) {
                                                      this.anInt3286 = buffer.readUnsignedShort();
                                                   } else if (i_11_ == 41) {
                                                      this.anInt3301 = buffer.readUnsignedShort();
                                                   } else if (i_11_ == 42) {
                                                      this.anInt3287 = buffer.readUnsignedShort();
                                                   } else if (~i_11_ != -44) {
                                                      if (i_11_ == 44) {
                                                         this.anInt3292 = buffer.readUnsignedShort();
                                                      } else if (~i_11_ == -46) {
                                                         this.anInt3303 = buffer.readUnsignedShort();
                                                      } else if (~i_11_ != -47) {
                                                         if (i_11_ == 47) {
                                                            this.anInt3260 = buffer.readUnsignedShort();
                                                         } else if (~i_11_ != -49) {
                                                            if (i_11_ == 49) {
                                                               this.anInt3253 = buffer.readUnsignedShort();
                                                            } else if (~i_11_ == -51) {
                                                               this.anInt3298 = buffer.readUnsignedShort();
                                                            } else if (~i_11_ == -52) {
                                                               this.anInt3305 = buffer.readUnsignedShort();
                                                            } else if (i_11_ == 52) {
                                                               int i_14_ = buffer.readUnsignedByte();
                                                               this.anIntArray3294 = new int[i_14_];
                                                               this.anIntArray3302 = new int[i_14_];

                                                               for(int i_15_ = 0; i_15_ < i_14_; ++i_15_) {
                                                                  this.anIntArray3294[i_15_] = buffer.readUnsignedShort();
                                                                  int i_16_ = buffer.readUnsignedByte();
                                                                  this.anIntArray3302[i_15_] = i_16_;
                                                                  this.anInt3281 += i_16_;
                                                               }
                                                            } else if (i_11_ == 53) {
                                                               this.aBoolean3267 = false;
                                                            } else if (~i_11_ != -55) {
                                                               if (i_11_ != 55) {
                                                                  if (i_11_ == 56) {
                                                                     if (this.anIntArrayArray3249 == null) {
                                                                        this.anIntArrayArray3249 = new int[this.aClass281_3265.aClass363_3578.anIntArray4508.length][];
                                                                     }

                                                                     int i_17_ = buffer.readUnsignedByte();
                                                                     this.anIntArrayArray3249[i_17_] = new int[3];

                                                                     for(int i_18_ = 0; ~i_18_ > -4; ++i_18_) {
                                                                        this.anIntArrayArray3249[i_17_][i_18_] = buffer.readShort();
                                                                     }
                                                                  }
                                                               } else {
                                                                  if (this.anIntArray3255 == null) {
                                                                     this.anIntArray3255 = new int[this.aClass281_3265.aClass363_3578.anIntArray4508.length];
                                                                  }

                                                                  int i_19_ = buffer.readUnsignedByte();
                                                                  this.anIntArray3255[i_19_] = buffer.readUnsignedShort();
                                                               }
                                                            } else {
                                                               this.anInt3263 = buffer.readUnsignedByte() << 6;
                                                               this.anInt3291 = buffer.readUnsignedByte() << 6;
                                                            }
                                                         } else {
                                                            this.anInt3282 = buffer.readUnsignedShort();
                                                         }
                                                      } else {
                                                         this.anInt3275 = buffer.readUnsignedShort();
                                                      }
                                                   } else {
                                                      this.anInt3290 = buffer.readUnsignedShort();
                                                   }
                                                } else {
                                                   this.anInt3274 = buffer.readUnsignedShort();
                                                }
                                             } else {
                                                this.anInt3272 = buffer.readUnsignedByte();
                                             }
                                          } else {
                                             this.anInt3250 = buffer.readShort();
                                          }
                                       } else {
                                          this.anInt3278 = buffer.readUnsignedByte();
                                       }
                                    } else {
                                       this.anInt3283 = buffer.readUnsignedShort();
                                    }
                                 } else {
                                    this.anInt3258 = buffer.readUnsignedByte();
                                 }
                              } else {
                                 int i_20_ = buffer.readUnsignedByte();
                                 this.anIntArray3276 = new int[i_20_];

                                 for(int i_21_ = 0; i_20_ > i_21_; ++i_21_) {
                                    this.anIntArray3276[i_21_] = buffer.readUnsignedByte();
                                    if (this.anIntArray3276[i_21_] == 255) {
                                       this.anIntArray3276[i_21_] = -1;
                                    }
                                 }
                              }
                           } else {
                              this.modelHeightOffset1 = (short)(4 * buffer.readUnsignedByte());
                              this.anInt3266 = (short)(4 * buffer.readUnsignedByte());
                           }
                        } else {
                           this.anInt3293 = buffer.readUnsignedShort();
                        }
                     } else {
                        this.anInt3270 = buffer.readUnsignedShort();
                     }
                  } else {
                     this.anInt3271 = buffer.readUnsignedShort();
                  }
               } else {
                  this.anInt3252 = buffer.readUnsignedShort();
               }
            } else {
               this.anInt3304 = buffer.readUnsignedShort();
            }
         } else {
            this.anInt3262 = buffer.readUnsignedShort();
         }

         ++anInt3251;
      }
   }

   final void method3134(byte b, Buffer buffer) {
      while(true) {
         int i = buffer.readUnsignedByte();
         if (i == 0) {
            if (b != -33) {
               this.method3130(78, (byte)43);
            }

            ++anInt3264;
            return;
         }

         this.method3133(-116, buffer, i);
      }
   }

   public RenderDefinitions() {
      this.modelHeightOffset1 = 0;
      this.anInt3275 = -1;
      this.anInt3253 = -1;
      this.anInt3252 = -1;
      this.anInt3250 = 0;
      this.anInt3272 = 0;
      this.anInt3282 = -1;
      this.anInt3263 = 0;
      this.anInt3287 = -1;
      this.anInt3281 = 0;
      this.anInt3284 = 0;
      this.walkAnimation = -1;
      this.anInt3260 = -1;
      this.anInt3286 = -1;
      this.aBoolean3267 = true;
      this.anInt3290 = -1;
      this.anInt3256 = -1;
      this.anIntArray3294 = null;
      this.anInt3295 = -1;
      this.anInt3292 = -1;
      this.anInt3269 = -1;
      this.idleAnimation = -1;
      this.anInt3299 = -1;
      this.anInt3289 = 0;
      this.anInt3298 = -1;
      this.anInt3291 = 0;
      this.anInt3266 = 0;
      this.anInt3285 = 0;
      this.anInt3270 = -1;
      this.anInt3283 = 0;
      this.anInt3274 = -1;
      this.anInt3297 = -1;
      this.anInt3262 = -1;
      this.anInt3301 = -1;
      this.anIntArray3302 = null;
      this.anInt3293 = -1;
      this.anInt3305 = -1;
      this.anInt3303 = -1;
      this.anInt3304 = -1;
   }
}
