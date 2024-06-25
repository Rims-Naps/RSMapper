public class Node_Sub26 extends Node {
   private GLToolkit aGLToolkit7240;
   private float[][] aFloatArrayArray7241;
   private int anInt7242;
   private int anInt7243;
   private Class69 aClass69_7244;
   static int anInt7245;
   private PacketParser aFloatBuffer7246;
   private Node_Sub29 aNode_Sub29_7247;
   private Class69 aClass69_7248;
   private int anInt7249;
   private float[][] aFloatArrayArray7250;
   private Buffer aBuffer7251;
   static int anInt7252;
   private HashTable aHashTable7253;
   private Interface9 anInterface9_7254;
   static int[] anIntArray7255 = new int[2];
   private Interface1 anInterface1_7256;
   private float[][] aFloatArrayArray7257;
   private int anInt7258;
   private int anInt7259;
   static int anInt7260;
   private int anInt7261;
   private GLPlane aGLPlane7262;

   private final void method2684(int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, int i_5_) {
      ++anInt7260;
      long l = -1L;
      int i_6_ = (i_4_ << this.aGLPlane7262.anInt3410) + i_0_;
      int i_7_ = i + (i_1_ << this.aGLPlane7262.anInt3410);
      int i_8_ = this.aGLPlane7262.getMedianHeightFromVertices(i_7_, -127, i_6_);
      if (~(127 & i_0_) == -1 || ~(127 & i) == -1) {
         l = ((long)i_7_ & 65535L) << 16 | (long)i_6_ & 65535L;
         Node node = this.aHashTable7253.get(3512, l);
         if (node != null) {
            this.method2686((byte)-56, ((Node_Sub46)node).aShort7554);
            return;
         }
      }

      short s = (short)(this.anInt7259++);
      if (l != -1L) {
         this.aHashTable7253.put(l, new Node_Sub46(s), -128);
      }

      float f;
      float f_9_;
      float f_10_;
      if (~i_0_ == -1 && i == 0) {
         f_10_ = this.aFloatArrayArray7257[i_5_][i_3_];
         f_9_ = this.aFloatArrayArray7241[i_5_][i_3_];
         f = this.aFloatArrayArray7250[i_5_][i_3_];
      } else if (this.aGLPlane7262.anInt3398 == i_0_ && i == 0) {
         f = this.aFloatArrayArray7250[1 + i_5_][i_3_];
         f_9_ = this.aFloatArrayArray7241[i_5_ - -1][i_3_];
         f_10_ = this.aFloatArrayArray7257[1 + i_5_][i_3_];
      } else if (this.aGLPlane7262.anInt3398 == i_0_ && ~i == ~this.aGLPlane7262.anInt3398) {
         f = this.aFloatArrayArray7250[i_5_ - -1][i_3_ + 1];
         f_10_ = this.aFloatArrayArray7257[i_5_ + 1][1 + i_3_];
         f_9_ = this.aFloatArrayArray7241[i_5_ + 1][1 + i_3_];
      } else if (i_0_ == 0 && ~i == ~this.aGLPlane7262.anInt3398) {
         f_10_ = this.aFloatArrayArray7257[i_5_][1 + i_3_];
         f_9_ = this.aFloatArrayArray7241[i_5_][i_3_ + 1];
         f = this.aFloatArrayArray7250[i_5_][i_3_ - -1];
      } else {
         float f_11_ = (float)i_0_ / (float)this.aGLPlane7262.anInt3398;
         float f_12_ = (float)i / (float)this.aGLPlane7262.anInt3398;
         float f_13_ = this.aFloatArrayArray7257[i_5_][i_3_];
         float f_14_ = this.aFloatArrayArray7241[i_5_][i_3_];
         float f_15_ = this.aFloatArrayArray7250[i_5_][i_3_];
         float f_16_ = this.aFloatArrayArray7257[i_5_ + 1][i_3_];
         float f_17_ = this.aFloatArrayArray7241[1 + i_5_][i_3_];
         f_17_ += (this.aFloatArrayArray7241[1 + i_5_][i_3_ + 1] - f_17_) * f_11_;
         f_16_ += (this.aFloatArrayArray7257[1 + i_5_][1 + i_3_] - f_16_) * f_11_;
         f_15_ += f_11_ * (-f_15_ + this.aFloatArrayArray7250[i_5_][1 + i_3_]);
         float f_18_ = this.aFloatArrayArray7250[i_5_ - -1][i_3_];
         f_14_ += f_11_ * (-f_14_ + this.aFloatArrayArray7241[i_5_][1 + i_3_]);
         f_13_ += (this.aFloatArrayArray7257[i_5_][1 + i_3_] - f_13_) * f_11_;
         f_9_ = f_12_ * (f_17_ - f_14_) + f_14_;
         f_18_ += (-f_18_ + this.aFloatArrayArray7250[1 + i_5_][1 + i_3_]) * f_11_;
         f_10_ = f_13_ + f_12_ * (-f_13_ + f_16_);
         f = f_12_ * (f_18_ - f_15_) + f_15_;
      }

      float f_19_ = (float)(this.aNode_Sub29_7247.getReferenceX(32311) + -i_6_);
      float f_20_ = (float)(this.aNode_Sub29_7247.getHeight(30) + -i_8_);
      float f_21_ = (float)(-i_7_ + this.aNode_Sub29_7247.getReferenceY(27433));
      float f_22_ = (float)Math.sqrt((double)(f_21_ * f_21_ + f_19_ * f_19_ + f_20_ * f_20_));
      float f_23_ = 1.0F / f_22_;
      f_20_ *= f_23_;
      f_21_ *= f_23_;
      f_19_ *= f_23_;
      float f_24_ = f_22_ / (float)this.aNode_Sub29_7247.getFlickerType(122);
      float f_25_ = 1.0F - f_24_ * f_24_;
      if (f_25_ < 0.0F) {
         f_25_ = 0.0F;
      }

      float f_26_ = f * f_21_ + f_10_ * f_19_ + f_9_ * f_20_;
      int i_27_ = 70 % ((53 - i_2_) / 35);
      if (f_26_ < 0.0F) {
         f_26_ = 0.0F;
      }

      float f_28_ = f_25_ * f_26_ * 2.0F;
      if (f_28_ > 1.0F) {
         f_28_ = 1.0F;
      }

      int i_29_ = this.aNode_Sub29_7247.getColor((byte)119);
      int i_30_ = (int)(f_28_ * (float)((i_29_ & 16759530) >> 16));
      if (i_30_ > 255) {
         i_30_ = 255;
      }

      int i_31_ = (int)((float)((65519 & i_29_) >> 8) * f_28_);
      if (i_31_ > 255) {
         i_31_ = 255;
      }

      int i_32_ = (int)(f_28_ * (float)(0xFF & i_29_));
      if (!this.aGLToolkit7240.aBoolean6736) {
         this.aFloatBuffer7246.method2252(-229385392, (float)i_6_);
         this.aFloatBuffer7246.method2252(-229385392, (float)i_8_);
         this.aFloatBuffer7246.method2252(-229385392, (float)i_7_);
      } else {
         this.aFloatBuffer7246.method2251(8, (float)i_6_);
         this.aFloatBuffer7246.method2251(8, (float)i_8_);
         this.aFloatBuffer7246.method2251(8, (float)i_7_);
      }

      if (~i_32_ < -256) {
         i_32_ = 255;
      }

      this.aFloatBuffer7246.writeByte(i_30_);
      this.aFloatBuffer7246.writeByte(i_31_);
      this.aFloatBuffer7246.writeByte(i_32_);
      this.aFloatBuffer7246.writeByte(255);
      this.method2686((byte)-50, s);
   }

   final void method2685(int i, boolean[][] bools, byte b, int i_33_, int i_34_) {
      ++anInt7245;
      if (this.anInterface1_7256 != null
         && ~(i_33_ + i) <= ~this.anInt7258
         && ~this.anInt7242 <= ~(i - i_33_)
         && ~this.anInt7249 >= ~(i_33_ + i_34_)
         && -i_33_ + i_34_ <= this.anInt7261) {
         if (b >= -104) {
            this.anInt7243 = -112;
         }

         for(int i_35_ = this.anInt7249; i_35_ <= this.anInt7261; ++i_35_) {
            for(int i_36_ = this.anInt7258; ~i_36_ >= ~this.anInt7242; ++i_36_) {
               int i_37_ = i_36_ - i;
               int i_38_ = i_35_ - i_34_;
               if (~i_37_ < ~(-i_33_) && ~i_33_ < ~i_37_ && -i_33_ < i_38_ && i_38_ < i_33_ && bools[i_37_ + i_33_][i_38_ + i_33_]) {
                  this.aGLToolkit7240.method1428((int)(this.aNode_Sub29_7247.method2707(1) * 255.0F) << 24, (byte)30);
                  this.aGLToolkit7240.method1482((byte)127, this.aClass69_7248, null, this.aClass69_7244, null);
                  this.aGLToolkit7240.method1477((byte)85, 0, 4, this.anInterface1_7256, this.anInt7243);
                  return;
               }
            }
         }
      }
   }

   private final void method2686(byte b, short s) {
      ++anInt7252;
      if (this.aGLToolkit7240.aBoolean6736) {
         this.aBuffer7251.writeShort(s);
      } else {
         this.aBuffer7251.method2191(-76, s);
      }

      if (b >= -13) {
         method2687(-65);
      }
   }

   public static void method2687(int i) {
      if (i != -1) {
         anIntArray7255 = null;
      }

      anIntArray7255 = null;
   }

   Node_Sub26(GLToolkit gltoolkit, GLPlane glplane, Node_Sub29 node_sub29, int[] is) {
      this.aGLPlane7262 = glplane;
      this.aNode_Sub29_7247 = node_sub29;
      this.aGLToolkit7240 = gltoolkit;
      int i = this.aNode_Sub29_7247.getFlickerType(117) + -(glplane.anInt3398 >> 1);
      this.anInt7258 = -i + this.aNode_Sub29_7247.getReferenceX(32311) >> glplane.anInt3410;
      this.anInt7242 = i + this.aNode_Sub29_7247.getReferenceX(32311) >> glplane.anInt3410;
      this.anInt7249 = this.aNode_Sub29_7247.getReferenceY(27433) - i >> glplane.anInt3410;
      this.anInt7261 = this.aNode_Sub29_7247.getReferenceY(27433) + i >> glplane.anInt3410;
      int i_39_ = this.anInt7242 - (this.anInt7258 + -1);
      int i_40_ = this.anInt7261 - this.anInt7249 + 1;
      this.aFloatArrayArray7250 = new float[1 + i_39_][i_40_ + 1];
      this.aFloatArrayArray7257 = new float[1 + i_39_][i_40_ - -1];
      this.aFloatArrayArray7241 = new float[i_39_ - -1][i_40_ - -1];

      for(int i_41_ = 0; ~i_41_ >= ~i_40_; ++i_41_) {
         int i_42_ = i_41_ - -this.anInt7249;
         if (~i_42_ < -1 && ~i_42_ > ~(-1 + this.aGLPlane7262.anInt3404)) {
            for(int i_43_ = 0; i_39_ >= i_43_; ++i_43_) {
               int i_44_ = this.anInt7258 + i_43_;
               if (~i_44_ < -1 && this.aGLPlane7262.anInt3408 - 1 > i_44_) {
                  int i_45_ = glplane.getVerticeHeight(i_42_, i_44_ - -1, (byte)-118) - glplane.getVerticeHeight(i_42_, -1 + i_44_, (byte)-118);
                  int i_46_ = glplane.getVerticeHeight(i_42_ + 1, i_44_, (byte)-118) + -glplane.getVerticeHeight(i_42_ + -1, i_44_, (byte)-118);
                  float f = (float)(1.0 / Math.sqrt((double)(i_45_ * i_45_ - (-65536 + -(i_46_ * i_46_)))));
                  this.aFloatArrayArray7257[i_43_][i_41_] = (float)i_45_ * f;
                  this.aFloatArrayArray7241[i_43_][i_41_] = f * -256.0F;
                  this.aFloatArrayArray7250[i_43_][i_41_] = f * (float)i_46_;
               }
            }
         }
      }

      int i_47_ = 0;

      for(int i_48_ = this.anInt7249; this.anInt7261 >= i_48_; ++i_48_) {
         if (~i_48_ <= -1 && i_48_ < glplane.anInt3404) {
            for(int i_49_ = this.anInt7258; ~i_49_ >= ~this.anInt7242; ++i_49_) {
               if (~i_49_ <= -1 && ~i_49_ > ~glplane.anInt3408) {
                  int i_50_ = is[i_47_];
                  int[] is_51_ = glplane.anIntArrayArrayArray7934[i_49_][i_48_];
                  if (is_51_ != null && i_50_ != 0) {
                     if (~i_50_ != -2) {
                        this.anInt7243 += 3;
                     } else {
                        int i_52_ = 0;

                        while(i_52_ < is_51_.length) {
                           if (is_51_[i_52_++] != -1 && is_51_[i_52_++] != -1 && is_51_[i_52_++] != -1) {
                              this.anInt7243 += 3;
                           }
                        }
                     }
                  }
               }

               ++i_47_;
            }
         } else {
            i_47_ += -this.anInt7258 + this.anInt7242;
         }
      }

      if (~this.anInt7243 >= -1) {
         this.anInterface9_7254 = null;
         this.aClass69_7244 = null;
         this.aClass69_7248 = null;
         this.anInterface1_7256 = null;
      } else {
         this.aBuffer7251 = new Buffer(this.anInt7243 * 2);
         this.aFloatBuffer7246 = new PacketParser(16 * this.anInt7243);
         this.aHashTable7253 = new HashTable(Class320_Sub19.method3753(this.anInt7243));
         int i_53_ = 0;
         i_47_ = 0;

         for(int i_54_ = this.anInt7249; i_54_ <= this.anInt7261; ++i_54_) {
            if (~i_54_ <= -1 && ~i_54_ > ~glplane.anInt3404) {
               int i_55_ = 0;

               for(int i_56_ = this.anInt7258; ~this.anInt7242 <= ~i_56_; ++i_56_) {
                  if (i_56_ >= 0 && ~glplane.anInt3408 < ~i_56_) {
                     int i_57_ = is[i_47_];
                     int[] is_58_ = glplane.anIntArrayArrayArray7934[i_56_][i_54_];
                     if (is_58_ != null && ~i_57_ != -1) {
                        if (~i_57_ != -2) {
                           if (~i_57_ != -4) {
                              if (~i_57_ == -3) {
                                 this.method2684(0, glplane.anInt3398, i_54_, -39, i_53_, i_56_, i_55_);
                                 this.method2684(glplane.anInt3398, glplane.anInt3398, i_54_, 111, i_53_, i_56_, i_55_);
                                 this.method2684(0, 0, i_54_, -124, i_53_, i_56_, i_55_);
                              } else if (i_57_ == 5) {
                                 this.method2684(glplane.anInt3398, glplane.anInt3398, i_54_, 118, i_53_, i_56_, i_55_);
                                 this.method2684(glplane.anInt3398, 0, i_54_, 103, i_53_, i_56_, i_55_);
                                 this.method2684(0, glplane.anInt3398, i_54_, -18, i_53_, i_56_, i_55_);
                              } else if (~i_57_ == -5) {
                                 this.method2684(glplane.anInt3398, 0, i_54_, 111, i_53_, i_56_, i_55_);
                                 this.method2684(0, 0, i_54_, -124, i_53_, i_56_, i_55_);
                                 this.method2684(glplane.anInt3398, glplane.anInt3398, i_54_, 109, i_53_, i_56_, i_55_);
                              }
                           } else {
                              this.method2684(0, 0, i_54_, 99, i_53_, i_56_, i_55_);
                              this.method2684(0, glplane.anInt3398, i_54_, 125, i_53_, i_56_, i_55_);
                              this.method2684(glplane.anInt3398, 0, i_54_, 119, i_53_, i_56_, i_55_);
                           }
                        } else {
                           int[] is_59_ = glplane.anIntArrayArrayArray7929[i_56_][i_54_];
                           int[] is_60_ = glplane.anIntArrayArrayArray7909[i_56_][i_54_];
                           int i_61_ = 0;

                           while(~i_61_ > ~is_58_.length) {
                              if (is_58_[i_61_] != -1 && is_58_[1 + i_61_] != -1 && is_58_[2 + i_61_] != -1) {
                                 this.method2684(is_60_[i_61_], is_59_[i_61_], i_54_, -111, i_53_, i_56_, i_55_);
                                 this.method2684(is_60_[++i_61_], is_59_[i_61_], i_54_, -51, i_53_, i_56_, i_55_);
                                 this.method2684(is_60_[++i_61_], is_59_[i_61_], i_54_, 99, i_53_, i_56_, i_55_);
                                 ++i_61_;
                              } else {
                                 i_61_ += 3;
                              }
                           }
                        }
                     }
                  }

                  ++i_47_;
                  ++i_55_;
               }
            } else {
               i_47_ += this.anInt7242 + -this.anInt7258;
            }

            ++i_53_;
         }

         this.anInterface1_7256 = this.aGLToolkit7240.method1453(26099, false, this.aBuffer7251.offset, 5123, this.aBuffer7251.buffer);
         this.anInterface9_7254 = this.aGLToolkit7240.method1467(false, this.aFloatBuffer7246.offset, this.aFloatBuffer7246.buffer, 16, -53);
         this.aClass69_7244 = new Class69(this.anInterface9_7254, 5126, 3, 0);
         this.aClass69_7248 = new Class69(this.anInterface9_7254, 5121, 4, 12);
      }

      this.aHashTable7253 = null;
      this.aFloatBuffer7246 = null;
      this.aBuffer7251 = null;
      this.aFloatArrayArray7257 = this.aFloatArrayArray7241 = this.aFloatArrayArray7250 = null;
   }
}
