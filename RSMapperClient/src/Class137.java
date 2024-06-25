import jaggl.OpenGL;

public class Class137 {
   static int anInt1701;
   private int anInt1702;
   private Class349[][] aClass349ArrayArray1703;
   protected byte[] aByteArray1704;
   static int anInt1705;
   protected int anInt1706;
   private GLPlane aGLPlane1707;
   private int anInt1708;
   static IncommingPacket aClass192_1709 = new IncommingPacket(72, 2);
   static int anInt1710;
   private int anInt1711;
   private int anInt1712;
   static int anInt1713;
   private GLToolkit aGLToolkit1714;
   static boolean aBoolean1715 = false;
   static int anInt1716;
   static int anInt1717;

   final void method1594(byte b) {
      ++anInt1713;
      this.aClass349ArrayArray1703 = new Class349[this.anInt1702][this.anInt1708];
      if (b < 0) {
         for(int i = 0; i < this.anInt1708; ++i) {
            for(int i_0_ = 0; i_0_ < this.anInt1702; ++i_0_) {
               this.aClass349ArrayArray1703[i_0_][i] = new Class349(
                  this.aGLToolkit1714, this, this.aGLPlane1707, i_0_, i, this.anInt1711, i_0_ * 128 + 1, 1 + i * 128
               );
            }
         }
      }
   }

   final void method1595(byte b, int i, int i_1_, r var_r) {
      ++anInt1701;
      r_Sub2 var_r_Sub2 = (r_Sub2)var_r;
      i += var_r_Sub2.anInt11064 - -1;
      i_1_ += 1 + var_r_Sub2.anInt11067;
      int i_2_ = i_1_ * this.anInt1706 + i;
      int i_3_ = 0;
      int i_4_ = var_r_Sub2.anInt11055;
      int i_5_ = var_r_Sub2.anInt11057;
      if (b <= 61) {
         method1600(-78);
      }

      int i_6_ = -i_5_ + this.anInt1706;
      if (~i_1_ >= -1) {
         int i_7_ = -i_1_ + 1;
         i_1_ = 1;
         i_2_ += i_7_ * this.anInt1706;
         i_4_ -= i_7_;
         i_3_ += i_7_ * i_5_;
      }

      int i_8_ = 0;
      if (i_1_ + i_4_ >= this.anInt1712) {
         int i_9_ = i_1_ - (-i_4_ - (1 + -this.anInt1712));
         i_4_ -= i_9_;
      }

      if (i <= 0) {
         int i_10_ = 1 - i;
         i_6_ += i_10_;
         i_5_ -= i_10_;
         i_8_ += i_10_;
         i = 1;
         i_2_ += i_10_;
         i_3_ += i_10_;
      }

      if (i - -i_5_ >= this.anInt1706) {
         int i_11_ = 1 + i_5_ + i + -this.anInt1706;
         i_6_ += i_11_;
         i_8_ += i_11_;
         i_5_ -= i_11_;
      }

      if (i_5_ > 0 && ~i_4_ < -1) {
         GLXToolkit.method1405(this.aByteArray1704, i_8_, i_2_, i_5_, i_4_, i_6_, -59, var_r_Sub2.aByteArray11058, i_3_);
         this.method1599(-1, i_1_, i_4_, i_5_, i);
      }
   }

   final void method1596(int i, boolean bool, boolean bool_12_, int i_13_, boolean[][] bools, int i_14_) {
      ++anInt1717;
      this.aGLToolkit1714.method1451(false, -31277);
      if (!bool_12_) {
         this.method1595((byte)59, -97, -49, null);
      }

      this.aGLToolkit1714.method1415(771, false);
      this.aGLToolkit1714.method1489(-2, -2);
      this.aGLToolkit1714.method1434((byte)104, 1);
      this.aGLToolkit1714.method1460(1, 3);
      float f = 1.0F / (float)(this.aGLToolkit1714.anInt6606 * 128);
      if (bool) {
         for(int i_15_ = 0; ~this.anInt1708 < ~i_15_; ++i_15_) {
            int i_16_ = i_15_ << this.anInt1711;
            int i_17_ = i_15_ + 1 << this.anInt1711;

            label131:
            for(int i_18_ = 0; i_18_ < this.anInt1702; ++i_18_) {
               int i_19_ = i_18_ << this.anInt1711;
               int i_20_ = i_18_ + 1 << this.anInt1711;

               for(int i_21_ = i_19_; ~i_20_ < ~i_21_; ++i_21_) {
                  if (-i_14_ <= -i + i_21_ && -i + i_21_ <= i_14_) {
                     for(int i_22_ = i_16_; i_17_ > i_22_; ++i_22_) {
                        if (-i_14_ <= -i_13_ + i_22_ && ~i_14_ <= ~(i_22_ - i_13_) && bools[i_14_ + -i + i_21_][i_14_ + i_22_ + -i_13_]) {
                           OpenGL.glMatrixMode(5890);
                           OpenGL.glLoadIdentity();
                           OpenGL.glScalef(f, f, 1.0F);
                           OpenGL.glTranslatef((float)(-i_18_) / f, (float)(-i_15_) / f, 1.0F);
                           OpenGL.glMatrixMode(5888);
                           this.aClass349ArrayArray1703[i_18_][i_15_].method3987(125);
                           continue label131;
                        }
                     }
                  }
               }
            }
         }
      } else {
         for(int i_23_ = 0; ~this.anInt1708 < ~i_23_; ++i_23_) {
            int i_24_ = i_23_ << this.anInt1711;
            int i_25_ = 1 + i_23_ << this.anInt1711;

            for(int i_26_ = 0; ~i_26_ > ~this.anInt1702; ++i_26_) {
               int i_27_ = 0;
               int i_28_ = i_26_ << this.anInt1711;
               int i_29_ = i_26_ - -1 << this.anInt1711;
               PacketParser floatbuffer = this.aGLToolkit1714.aFloatBuffer6661;
               floatbuffer.offset = 0;

               for(int i_30_ = i_24_; i_30_ < i_25_; ++i_30_) {
                  if (-i_14_ <= i_30_ + -i_13_ && ~(-i_13_ + i_30_) >= ~i_14_) {
                     int i_31_ = i_28_ + i_30_ * this.aGLPlane1707.anInt3408;

                     for(int i_32_ = i_28_; i_29_ > i_32_; ++i_32_) {
                        if (~(-i + i_32_) <= ~(-i_14_) && ~(-i + i_32_) >= ~i_14_ && bools[i_14_ + i_32_ - i][-i_13_ + i_30_ + i_14_]) {
                           short[] ses = this.aGLPlane1707.aShortArrayArray7925[i_31_];
                           if (ses != null) {
                              if (!this.aGLToolkit1714.aBoolean6736) {
                                 for(int i_33_ = 0; ~ses.length < ~i_33_; ++i_33_) {
                                    floatbuffer.method2191(-116, '\uffff' & ses[i_33_]);
                                    ++i_27_;
                                 }
                              } else {
                                 for(int i_34_ = 0; ~ses.length < ~i_34_; ++i_34_) {
                                    ++i_27_;
                                    floatbuffer.writeShort(ses[i_34_] & '\uffff');
                                 }
                              }
                           }
                        }

                        ++i_31_;
                     }
                  }
               }

               if (~i_27_ < -1) {
                  OpenGL.glMatrixMode(5890);
                  OpenGL.glLoadIdentity();
                  OpenGL.glScalef(f, f, 1.0F);
                  OpenGL.glTranslatef((float)(-i_26_) / f, (float)(-i_23_) / f, 1.0F);
                  OpenGL.glMatrixMode(5888);
                  this.aClass349ArrayArray1703[i_26_][i_23_].method3990(5123, floatbuffer.buffer, (byte)-78, i_27_);
               }
            }
         }
      }

      OpenGL.glMatrixMode(5890);
      OpenGL.glLoadIdentity();
      OpenGL.glMatrixMode(5888);
   }

   final boolean method1597(int i, int i_35_, r var_r, int i_36_) {
      ++anInt1710;
      r_Sub2 var_r_Sub2 = (r_Sub2)var_r;
      i_36_ += var_r_Sub2.anInt11067 - -1;
      i_35_ += i + var_r_Sub2.anInt11064;
      int i_37_ = i_36_ * this.anInt1706 + i_35_;
      int i_38_ = var_r_Sub2.anInt11055;
      int i_39_ = var_r_Sub2.anInt11057;
      int i_40_ = -i_39_ + this.anInt1706;
      if (~i_36_ >= -1) {
         int i_41_ = 1 - i_36_;
         i_36_ = 1;
         i_38_ -= i_41_;
         i_37_ += this.anInt1706 * i_41_;
      }

      if (~(i_38_ + i_36_) <= ~this.anInt1712) {
         int i_42_ = -this.anInt1712 + i_38_ + i_36_ + 1;
         i_38_ -= i_42_;
      }

      if (~i_35_ >= -1) {
         int i_43_ = -i_35_ + 1;
         i_35_ = 1;
         i_39_ -= i_43_;
         i_40_ += i_43_;
         i_37_ += i_43_;
      }

      if (this.anInt1706 <= i_35_ + i_39_) {
         int i_44_ = -this.anInt1706 + i_35_ + i_39_ + 1;
         i_39_ -= i_44_;
         i_40_ += i_44_;
      }

      if (~i_39_ < -1 && ~i_38_ < -1) {
         int i_45_ = 8;
         i_40_ += (-1 + i_45_) * this.anInt1706;
         return Class134_Sub2.method1582(i_45_, i_37_, this.aByteArray1704, i_39_, (byte)-78, i_38_, i_40_);
      } else {
         return false;
      }
   }

   final void method1598(int i, r var_r, int i_46_, byte b) {
      ++anInt1705;
      r_Sub2 var_r_Sub2 = (r_Sub2)var_r;
      i += 1 + var_r_Sub2.anInt11067;
      i_46_ += var_r_Sub2.anInt11064 - -1;
      int i_47_ = this.anInt1706 * i + i_46_;
      if (b <= 60) {
         method1600(30);
      }

      int i_48_ = 0;
      int i_49_ = var_r_Sub2.anInt11055;
      int i_50_ = var_r_Sub2.anInt11057;
      int i_51_ = -i_50_ + this.anInt1706;
      int i_52_ = 0;
      if (~i >= -1) {
         int i_53_ = -i + 1;
         i_49_ -= i_53_;
         i = 1;
         i_48_ += i_50_ * i_53_;
         i_47_ += i_53_ * this.anInt1706;
      }

      if (this.anInt1712 <= i + i_49_) {
         int i_54_ = -this.anInt1712 + 1 + i_49_ + i;
         i_49_ -= i_54_;
      }

      if (~i_46_ >= -1) {
         int i_55_ = -i_46_ + 1;
         i_50_ -= i_55_;
         i_48_ += i_55_;
         i_51_ += i_55_;
         i_47_ += i_55_;
         i_46_ = 1;
         i_52_ += i_55_;
      }

      if (i_46_ - -i_50_ >= this.anInt1706) {
         int i_56_ = i_50_ + i_46_ - (-1 - -this.anInt1706);
         i_51_ += i_56_;
         i_52_ += i_56_;
         i_50_ -= i_56_;
      }

      if (~i_50_ < -1 && ~i_49_ < -1) {
         Node_Sub38_Sub33.method2898(i_52_, i_51_, i_47_, this.aByteArray1704, i_48_, var_r_Sub2.aByteArray11058, i_49_, i_50_, 0);
         this.method1599(-1, i, i_49_, i_50_, i_46_);
      }
   }

   private final void method1599(int i, int i_57_, int i_58_, int i_59_, int i_60_) {
      ++anInt1716;
      if (this.aClass349ArrayArray1703 != null) {
         int i_61_ = i_60_ + -1 >> 7;
         int i_62_ = i + -1 + i_60_ + i_59_ >> 7;
         int i_63_ = -1 + i_57_ >> 7;
         int i_64_ = -2 + i_57_ + i_58_ >> 7;

         for(int i_65_ = i_61_; ~i_62_ <= ~i_65_; ++i_65_) {
            Class349[] class349s = this.aClass349ArrayArray1703[i_65_];

            for(int i_66_ = i_63_; ~i_64_ <= ~i_66_; ++i_66_) {
               class349s[i_66_].aBoolean4307 = true;
            }
         }
      }
   }

   Class137(GLToolkit gltoolkit, GLPlane glplane) {
      this.aGLToolkit1714 = gltoolkit;
      this.aGLPlane1707 = glplane;
      this.anInt1706 = (this.aGLPlane1707.anInt3408 * this.aGLPlane1707.anInt3398 >> this.aGLToolkit1714.anInt6611) + 2;
      this.anInt1712 = (this.aGLPlane1707.anInt3404 * this.aGLPlane1707.anInt3398 >> this.aGLToolkit1714.anInt6611) + 2;
      this.anInt1711 = 7 + this.aGLToolkit1714.anInt6611 - this.aGLPlane1707.anInt3410;
      this.aByteArray1704 = new byte[this.anInt1712 * this.anInt1706];
      this.anInt1702 = this.aGLPlane1707.anInt3408 >> this.anInt1711;
      this.anInt1708 = this.aGLPlane1707.anInt3404 >> this.anInt1711;
   }

   public static void method1600(int i) {
      aClass192_1709 = null;
      if (i != 0) {
         method1600(18);
      }
   }
}
