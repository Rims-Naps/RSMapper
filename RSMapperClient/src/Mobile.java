abstract class Mobile extends Animable {
   static int anInt9117;
   static boolean aBoolean9118 = false;
   protected short aShort9119;
   protected short aShort9120;
   protected boolean aBoolean9121;
   static int[][] anIntArrayArray9122 = new int[6][];
   static int anInt9123;
   protected short aShort9124;
   static int anInt9125;
   static int anInt9126;
   protected byte aByte9127;
   static Buffer aBuffer9128;
   static int anInt9129;
   protected short aShort9130;

   @Override
   final int method819(Node_Sub29[] node_sub29s, int i) {
      ++anInt9123;
      int i_0_ = 0;
      if (i != 1) {
         return -78;
      } else {
         label118:
         for(int i_1_ = this.aShort9119; this.aShort9130 >= i_1_; ++i_1_) {
            for(int i_2_ = this.aShort9120; ~i_2_ >= ~this.aShort9124; ++i_2_) {
               long l = TextureDefinitions.aLongArrayArrayArray1228[this.plane][i_1_][i_2_];
               long l_3_ = 0L;

               label113:
               while(l_3_ <= 48L) {
                  int i_4_ = (int)(65535L & l >>> (int)l_3_);
                  if (~i_4_ >= -1) {
                     break;
                  }

                  LightFX class326 = Class143.aLightFXArray1771[-1 + i_4_];

                  for(int i_5_ = 0; i_0_ > i_5_; ++i_5_) {
                     if (node_sub29s[i_5_] == class326.aNode_Sub29_4100) {
                        l_3_ += 16L;
                        continue label113;
                     }
                  }

                  node_sub29s[i_0_++] = class326.aNode_Sub29_4100;
                  if (i_0_ == 4) {
                     break label118;
                  }

                  l_3_ += 16L;
               }
            }
         }

         for(int i_6_ = i_0_; ~i_6_ > -5; ++i_6_) {
            node_sub29s[i_6_] = null;
         }

         if (~this.aByte9127 != -1) {
            int i_7_ = -(Class98.cameraPosX >> 9) + this.aShort9119;
            int i_8_ = -(Node_Sub10.cameraPosY >> 9) + this.aShort9120;
            short s;
            short s_11_;
            int i_9_;
            int i_10_;
            if (~this.aByte9127 != -2) {
               if (i_8_ > -i_7_) {
                  i_10_ = this.aShort9119 - 1;
                  s = this.aShort9119;
                  i_9_ = -1 + this.aShort9120;
                  s_11_ = this.aShort9120;
               } else {
                  i_10_ = this.aShort9119 + 1;
                  s = this.aShort9119;
                  i_9_ = this.aShort9120 - -1;
                  s_11_ = this.aShort9120;
               }
            } else if (~i_7_ <= ~i_8_) {
               i_9_ = this.aShort9120 - -1;
               s = this.aShort9119;
               i_10_ = this.aShort9119 - 1;
               s_11_ = this.aShort9120;
            } else {
               i_9_ = -1 + this.aShort9120;
               s = this.aShort9119;
               s_11_ = this.aShort9120;
               i_10_ = this.aShort9119 - -1;
            }

            label82:
            for(int i_12_ = 0; ~i_0_ < ~i_12_; ++i_12_) {
               long l = TextureDefinitions.aLongArrayArrayArray1228[this.plane][s][i_9_];

               while(l != 0L) {
                  LightFX class326 = Class143.aLightFXArray1771[(int)(-1L + (65535L & l))];
                  l >>>= 16;
                  if (node_sub29s[i_12_] == class326.aNode_Sub29_4100) {
                     continue label82;
                  }
               }

               l = TextureDefinitions.aLongArrayArrayArray1228[this.plane][i_10_][s_11_];

               while(~l != -1L) {
                  LightFX class326 = Class143.aLightFXArray1771[(int)((l & 65535L) + -1L)];
                  l >>>= 16;
                  if (class326.aNode_Sub29_4100 == node_sub29s[i_12_]) {
                     continue label82;
                  }
               }

               for(int i_13_ = i_12_; -1 + i_0_ > i_13_; ++i_13_) {
                  node_sub29s[i_13_] = node_sub29s[1 + i_13_];
               }

               --i_0_;
            }
         }

         return i_0_;
      }
   }

   @Override
   final boolean method815(byte b, GraphicsToolkit graphicstoolkit) {
      if (b != 59) {
         this.method815((byte)-4, null);
      }

      ++anInt9129;
      return Node_Sub3.method2171(
         this.aShort9120, this.aShort9130, (byte)-127, this.method809(graphicstoolkit, -115), this.aShort9124, this.aShort9119, this.aByte5931
      );
   }

   @Override
   final boolean method806(int i) {
      ++anInt9126;
      if (i != 0) {
         method844(null, (byte)-66);
      }

      for(int i_14_ = this.aShort9119; ~this.aShort9130 <= ~i_14_; ++i_14_) {
         for(int i_15_ = this.aShort9120; i_15_ <= this.aShort9124; ++i_15_) {
            int i_16_ = Node_Sub9_Sub1.anInt9656 + i_14_ + -Class216.anInt2551;
            if (~i_16_ <= -1 && ~i_16_ > ~Class139.aBooleanArrayArray1730.length) {
               int i_17_ = Node_Sub9_Sub1.anInt9656 + -EntityNode_Sub7.anInt6013 + i_15_;
               if (~i_17_ <= -1 && ~i_17_ > ~Class139.aBooleanArrayArray1730.length && Class139.aBooleanArrayArray1730[i_16_][i_17_]) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   static final String method844(CacheNode_Sub13 cachenode_sub13, byte b) {
      if (b < 125) {
         method844(null, (byte)118);
      }

      ++anInt9117;
      if (cachenode_sub13.aString9565 != null && ~cachenode_sub13.aString9565.length() != -1) {
         return cachenode_sub13.aString9558 != null && ~cachenode_sub13.aString9558.length() < -1
            ? cachenode_sub13.aString9560
               + Class22.aClass22_395.getStoredString(Class35.language)
               + cachenode_sub13.aString9558
               + Class22.aClass22_395.getStoredString(Class35.language)
               + cachenode_sub13.aString9565
            : cachenode_sub13.aString9560 + Class22.aClass22_395.getStoredString(Class35.language) + cachenode_sub13.aString9565;
      } else {
         return cachenode_sub13.aString9558 != null && cachenode_sub13.aString9558.length() > 0
            ? cachenode_sub13.aString9560 + Class22.aClass22_395.getStoredString(Class35.language) + cachenode_sub13.aString9558
            : cachenode_sub13.aString9560;
      }
   }

   void method845(int i) {
      ++anInt9125;
      int i_18_ = -111 % ((i - -48) / 43);
   }

   public static void method846(boolean bool) {
      if (!bool) {
         aBuffer9128 = null;
         anIntArrayArray9122 = null;
      }
   }

   Mobile(int i, int i_19_, int i_20_, int i_21_, int i_22_, int i_23_, int i_24_, int i_25_, int i_26_, boolean bool, byte b) {
      this.aShort9120 = (short)i_25_;
      this.anInt5937 = i_21_;
      this.plane = (byte)i;
      this.aShort9124 = (short)i_26_;
      this.aByte5931 = (byte)i_19_;
      this.y = i_22_;
      this.x = i_20_;
      this.aBoolean9121 = bool;
      this.aByte9127 = b;
      this.aShort9130 = (short)i_24_;
      this.aShort9119 = (short)i_23_;
   }
}
