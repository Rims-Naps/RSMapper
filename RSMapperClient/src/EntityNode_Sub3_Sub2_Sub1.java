public class EntityNode_Sub3_Sub2_Sub1 extends EntityNode_Sub3_Sub2 {
   private short aShort11020;
   private short aShort11021;
   private short aShort11022;
   private int anInt11023;
   private short aShort11024;
   private short aShort11025;
   private short aShort11026;
   protected EntityNode_Sub7 anEntityNode_Sub7_11027;
   private int anInt11028;

   private final void method947() {
      int i = this.anEntityNode_Sub7_11027.anEntityNode_Sub4_6009.anInt5974;
      if (this.anEntityNode_Sub7_11027.anEntityNode_Sub4_6009.anEntityNode_Sub3_Sub2_Sub1Array5970[i] != null) {
         this.anEntityNode_Sub7_11027.anEntityNode_Sub4_6009.anEntityNode_Sub3_Sub2_Sub1Array5970[i].method951();
      }

      this.anEntityNode_Sub7_11027.anEntityNode_Sub4_6009.anEntityNode_Sub3_Sub2_Sub1Array5970[i] = this;
      this.aShort11020 = (short)this.anEntityNode_Sub7_11027.anEntityNode_Sub4_6009.anInt5974;
      this.anEntityNode_Sub7_11027.anEntityNode_Sub4_6009.anInt5974 = i + 1 & 8191;
      this.anEntityNode_Sub7_11027.aClass103_6006.method1110(false, this);
   }

   final void method948(long l, int i) {
      this.aShort11026 = (short)(this.aShort11026 - i);
      if (this.aShort11026 <= 0) {
         this.method951();
      } else {
         int i_0_ = this.anInt9174 >> 12;
         int i_1_ = this.anInt9171 >> 12;
         int i_2_ = this.anInt9173 >> 12;
         EntityNode_Sub4 entitynode_sub4 = this.anEntityNode_Sub7_11027.anEntityNode_Sub4_6009;
         Class355 class355 = this.anEntityNode_Sub7_11027.aClass355_6011;
         if (class355.anInt4409 != 0) {
            if (this.aShort11022 - this.aShort11026 <= class355.anInt4387) {
               int i_3_ = (this.anInt9176 >> 8 & 0xFF00) + (this.anInt11023 >> 16 & 0xFF) + class355.anInt4422 * i;
               int i_4_ = (this.anInt9176 & 0xFF00) + (this.anInt11023 >> 8 & 0xFF) + class355.anInt4410 * i;
               int i_5_ = (this.anInt9176 << 8 & 0xFF00) + (this.anInt11023 & 0xFF) + class355.anInt4405 * i;
               if (i_3_ < 0) {
                  i_3_ = 0;
               } else if (i_3_ > 65535) {
                  i_3_ = 65535;
               }

               if (i_4_ < 0) {
                  i_4_ = 0;
               } else if (i_4_ > 65535) {
                  i_4_ = 65535;
               }

               if (i_5_ < 0) {
                  i_5_ = 0;
               } else if (i_5_ > 65535) {
                  i_5_ = 65535;
               }

               this.anInt9176 &= -16777216;
               this.anInt9176 |= ((i_3_ & 0xFF00) << 8) + (i_4_ & 0xFF00) + ((i_5_ & 0xFF00) >> 8);
               this.anInt11023 &= -16777216;
               this.anInt11023 |= ((i_3_ & 0xFF) << 16) + ((i_4_ & 0xFF) << 8) + (i_5_ & 0xFF);
            }

            if (this.aShort11022 - this.aShort11026 <= class355.anInt4416) {
               int i_6_ = (this.anInt9176 >> 16 & 0xFF00) + (this.anInt11023 >> 24 & 0xFF) + class355.anInt4364 * i;
               if (i_6_ < 0) {
                  i_6_ = 0;
               } else if (i_6_ > 65535) {
                  i_6_ = 65535;
               }

               this.anInt9176 &= 16777215;
               this.anInt9176 |= (i_6_ & 0xFF00) << 16;
               this.anInt11023 &= 16777215;
               this.anInt11023 |= (i_6_ & 0xFF) << 24;
            }
         }

         if (class355.anInt4413 != -1 && this.aShort11022 - this.aShort11026 <= class355.anInt4384) {
            this.anInt11028 += class355.anInt4368 * i;
         }

         if (class355.anInt4419 != -1 && this.aShort11022 - this.aShort11026 <= class355.anInt4398) {
            this.anInt9172 += class355.anInt4399 * i;
         }

         double d = (double)this.aShort11021;
         double d_7_ = (double)this.aShort11025;
         double d_8_ = (double)this.aShort11024;
         boolean bool = false;
         if (class355.anInt4380 == 1) {
            int i_9_ = i_0_ - this.anEntityNode_Sub7_11027.aClass143_6005.anInt1767;
            int i_10_ = i_1_ - this.anEntityNode_Sub7_11027.aClass143_6005.anInt1776;
            int i_11_ = i_2_ - this.anEntityNode_Sub7_11027.aClass143_6005.anInt1769;
            int i_12_ = (int)Math.sqrt((double)(i_9_ * i_9_ + i_10_ * i_10_ + i_11_ * i_11_)) >> 2;
            long l_13_ = (long)(class355.anInt4404 * i_12_ * i);
            this.anInt11028 = (int)((long)this.anInt11028 - ((long)this.anInt11028 * l_13_ >> 18));
         } else if (class355.anInt4380 == 2) {
            int i_14_ = i_0_ - this.anEntityNode_Sub7_11027.aClass143_6005.anInt1767;
            int i_15_ = i_1_ - this.anEntityNode_Sub7_11027.aClass143_6005.anInt1776;
            int i_16_ = i_2_ - this.anEntityNode_Sub7_11027.aClass143_6005.anInt1769;
            int i_17_ = i_14_ * i_14_ + i_15_ * i_15_ + i_16_ * i_16_;
            long l_18_ = (long)(class355.anInt4404 * i_17_ * i);
            this.anInt11028 = (int)((long)this.anInt11028 - ((long)this.anInt11028 * l_18_ >> 28));
         }

         if (class355.anIntArray4362 != null) {
            Node node = entitynode_sub4.aClass312_5976.aNode3958;

            for(Node node_19_ = node.aNode2800; node_19_ != node; node_19_ = node_19_.aNode2800) {
               CacheNode_Sub5 cachenode_sub5 = (CacheNode_Sub5)node_19_;
               Class249 class249 = cachenode_sub5.aClass249_9473;
               if (class249.anInt3160 != 1) {
                  boolean bool_20_ = false;

                  for(int i_21_ = 0; i_21_ < class355.anIntArray4362.length; ++i_21_) {
                     if (class355.anIntArray4362[i_21_] == class249.anInt3158) {
                        bool_20_ = true;
                        break;
                     }
                  }

                  if (bool_20_) {
                     double d_22_ = (double)(i_0_ - cachenode_sub5.anInt9475);
                     double d_23_ = (double)(i_1_ - cachenode_sub5.anInt9471);
                     double d_24_ = (double)(i_2_ - cachenode_sub5.anInt9468);
                     double d_25_ = d_22_ * d_22_ + d_23_ * d_23_ + d_24_ * d_24_;
                     if (d_25_ <= (double)class249.aLong3156) {
                        double d_26_ = Math.sqrt(d_25_);
                        if (d_26_ == 0.0) {
                           d_26_ = 1.0;
                        }

                        double d_27_ = (
                              d_22_ * (double)cachenode_sub5.anInt9472 + d_23_ * (double)class249.anInt3166 + d_24_ * (double)cachenode_sub5.anInt9470
                           )
                           * 65535.0
                           / ((double)class249.anInt3164 * d_26_);
                        if (d_27_ >= (double)class249.anInt3152) {
                           double d_28_ = 0.0;
                           if (class249.anInt3163 == 1) {
                              d_28_ = d_26_ / 16.0 * (double)class249.anInt3148;
                           } else if (class249.anInt3163 == 2) {
                              d_28_ = d_26_ / 16.0 * (d_26_ / 16.0) * (double)class249.anInt3148;
                           }

                           if (class249.anInt3162 == 0) {
                              if (class249.anInt3155 == 0) {
                                 d += ((double)cachenode_sub5.anInt9472 - d_28_) * (double)i;
                                 d_7_ += ((double)class249.anInt3166 - d_28_) * (double)i;
                                 d_8_ += ((double)cachenode_sub5.anInt9470 - d_28_) * (double)i;
                                 bool = true;
                              } else {
                                 this.anInt9174 = (int)((double)this.anInt9174 + ((double)cachenode_sub5.anInt9472 - d_28_) * (double)i);
                                 this.anInt9171 = (int)((double)this.anInt9171 + ((double)class249.anInt3166 - d_28_) * (double)i);
                                 this.anInt9173 = (int)((double)this.anInt9173 + ((double)cachenode_sub5.anInt9470 - d_28_) * (double)i);
                              }
                           } else {
                              double d_29_ = d_22_ / d_26_ * (double)class249.anInt3164;
                              double d_30_ = d_23_ / d_26_ * (double)class249.anInt3164;
                              double d_31_ = d_24_ / d_26_ * (double)class249.anInt3164;
                              if (class249.anInt3155 == 0) {
                                 d += d_29_ * (double)i;
                                 d_7_ += d_30_ * (double)i;
                                 d_8_ += d_31_ * (double)i;
                                 bool = true;
                              } else {
                                 this.anInt9174 = (int)((double)this.anInt9174 + d_29_ * (double)i);
                                 this.anInt9171 = (int)((double)this.anInt9171 + d_30_ * (double)i);
                                 this.anInt9173 = (int)((double)this.anInt9173 + d_31_ * (double)i);
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         if (class355.anIntArray4371 != null) {
            for(int i_32_ = 0; i_32_ < class355.anIntArray4371.length; ++i_32_) {
               CacheNode_Sub5 cachenode_sub5 = (CacheNode_Sub5)Node_Sub41.aClass114_7519.method1157((long)class355.anIntArray4371[i_32_], 1);

               while(cachenode_sub5 != null) {
                  Class249 class249 = cachenode_sub5.aClass249_9473;
                  double d_33_ = (double)(i_0_ - cachenode_sub5.anInt9475);
                  double d_34_ = (double)(i_1_ - cachenode_sub5.anInt9471);
                  double d_35_ = (double)(i_2_ - cachenode_sub5.anInt9468);
                  double d_36_ = d_33_ * d_33_ + d_34_ * d_34_ + d_35_ * d_35_;
                  if (d_36_ > (double)class249.aLong3156) {
                     cachenode_sub5 = (CacheNode_Sub5)Node_Sub41.aClass114_7519.method1158(-1);
                  } else {
                     double d_37_ = Math.sqrt(d_36_);
                     if (d_37_ == 0.0) {
                        d_37_ = 1.0;
                     }

                     double d_38_ = (d_33_ * (double)cachenode_sub5.anInt9472 + d_34_ * (double)class249.anInt3166 + d_35_ * (double)cachenode_sub5.anInt9470)
                        * 65535.0
                        / ((double)class249.anInt3164 * d_37_);
                     if (d_38_ < (double)class249.anInt3152) {
                        cachenode_sub5 = (CacheNode_Sub5)Node_Sub41.aClass114_7519.method1158(-1);
                     } else {
                        double d_39_ = 0.0;
                        if (class249.anInt3163 == 1) {
                           d_39_ = d_37_ / 16.0 * (double)class249.anInt3148;
                        } else if (class249.anInt3163 == 2) {
                           d_39_ = d_37_ / 16.0 * (d_37_ / 16.0) * (double)class249.anInt3148;
                        }

                        if (class249.anInt3162 == 0) {
                           if (class249.anInt3155 == 0) {
                              d += ((double)cachenode_sub5.anInt9472 - d_39_) * (double)i;
                              d_7_ += ((double)class249.anInt3166 - d_39_) * (double)i;
                              d_8_ += ((double)cachenode_sub5.anInt9470 - d_39_) * (double)i;
                              bool = true;
                           } else {
                              this.anInt9174 = (int)((double)this.anInt9174 + ((double)cachenode_sub5.anInt9472 - d_39_) * (double)i);
                              this.anInt9171 = (int)((double)this.anInt9171 + ((double)class249.anInt3166 - d_39_) * (double)i);
                              this.anInt9173 = (int)((double)this.anInt9173 + ((double)cachenode_sub5.anInt9470 - d_39_) * (double)i);
                           }
                        } else {
                           double d_40_ = d_33_ / d_37_ * (double)class249.anInt3164;
                           double d_41_ = d_34_ / d_37_ * (double)class249.anInt3164;
                           double d_42_ = d_35_ / d_37_ * (double)class249.anInt3164;
                           if (class249.anInt3155 == 0) {
                              d += d_40_ * (double)i;
                              d_7_ += d_41_ * (double)i;
                              d_8_ += d_42_ * (double)i;
                              bool = true;
                           } else {
                              this.anInt9174 = (int)((double)this.anInt9174 + d_40_ * (double)i);
                              this.anInt9171 = (int)((double)this.anInt9171 + d_41_ * (double)i);
                              this.anInt9173 = (int)((double)this.anInt9173 + d_42_ * (double)i);
                           }
                        }

                        cachenode_sub5 = (CacheNode_Sub5)Node_Sub41.aClass114_7519.method1158(-1);
                     }
                  }
               }
            }
         }

         if (class355.anIntArray4414 != null) {
            if (class355.anIntArray4352 == null) {
               class355.anIntArray4352 = new int[class355.anIntArray4414.length];

               for(int i_43_ = 0; i_43_ < class355.anIntArray4414.length; ++i_43_) {
                  Class320_Sub1.method3680(1, class355.anIntArray4414[i_43_]);
                  class355.anIntArray4352[i_43_] = ((Node_Sub32)Class269.aHashTable3465.get(3512, (long)class355.anIntArray4414[i_43_])).anInt7381;
               }
            }

            for(int i_44_ = 0; i_44_ < class355.anIntArray4352.length; ++i_44_) {
               Class249 class249 = Class198.aClass249Array2428[class355.anIntArray4352[i_44_]];
               if (class249.anInt3155 == 0) {
                  d += (double)(class249.anInt3157 * i);
                  d_7_ += (double)(class249.anInt3166 * i);
                  d_8_ += (double)(class249.anInt3150 * i);
                  bool = true;
               } else {
                  this.anInt9174 += class249.anInt3157 * i;
                  this.anInt9171 += class249.anInt3166 * i;
                  this.anInt9173 += class249.anInt3150 * i;
               }
            }
         }

         if (bool) {
            while(d > 32767.0 || d_7_ > 32767.0 || d_8_ > 32767.0 || d < -32767.0 || d_7_ < -32767.0 || d_8_ < -32767.0) {
               d /= 2.0;
               d_7_ /= 2.0;
               d_8_ /= 2.0;
               this.anInt11028 <<= 1;
            }

            this.aShort11021 = (short)((int)d);
            this.aShort11025 = (short)((int)d_7_);
            this.aShort11024 = (short)((int)d_8_);
         }

         this.anInt9174 = (int)((long)this.anInt9174 + ((long)this.aShort11021 * (long)(this.anInt11028 << 2) >> 23) * (long)i);
         this.anInt9171 = (int)((long)this.anInt9171 + ((long)this.aShort11025 * (long)(this.anInt11028 << 2) >> 23) * (long)i);
         this.anInt9173 = (int)((long)this.anInt9173 + ((long)this.aShort11024 * (long)(this.anInt11028 << 2) >> 23) * (long)i);
      }
   }

   final void method949(GraphicsToolkit graphicstoolkit, long l) {
      int i = this.anInt9174 >> 12 + Class36.INT_9;
      int i_45_ = this.anInt9173 >> 12 + Class36.INT_9;
      int i_46_ = this.anInt9171 >> 12;
      if (i_46_ <= 0 && i_46_ >= -262144 && i >= 0 && i < Class328.SCENE_WIDTH_X && i_45_ >= 0 && i_45_ < Node_Sub50.SCENE_WIDTH_Y) {
         EntityNode_Sub4 entitynode_sub4 = this.anEntityNode_Sub7_11027.anEntityNode_Sub4_6009;
         Class355 class355 = this.anEntityNode_Sub7_11027.aClass355_6011;
         Plane[] planes = Class320_Sub10.aPlaneArray8300;
         int i_47_ = entitynode_sub4.anInt5979;
         Class261 class261 = Class175.aClass261ArrayArrayArray2099[entitynode_sub4.anInt5979][i][i_45_];
         if (class261 != null) {
            i_47_ = class261.aByte3311;
         }

         int i_48_ = planes[i_47_].getVerticeHeight(i_45_, i, (byte)-118);
         int i_49_;
         if (i_47_ < Class159.anInt1995 - 1) {
            i_49_ = planes[i_47_ + 1].getVerticeHeight(i_45_, i, (byte)-118);
         } else {
            i_49_ = i_48_ - (8 << Class36.INT_9);
         }

         if (class355.aBoolean4406) {
            if (class355.anInt4407 == -1 && i_46_ > i_48_) {
               this.method951();
               return;
            }

            if (class355.anInt4407 >= 0 && i_46_ > planes[class355.anInt4407].getVerticeHeight(i_45_, i, (byte)-118)) {
               this.method951();
               return;
            }

            if (class355.anInt4374 == -1 && i_46_ < i_49_) {
               this.method951();
               return;
            }

            if (class355.anInt4374 >= 0 && i_46_ < planes[class355.anInt4374 + 1].getVerticeHeight(i_45_, i, (byte)-118)) {
               this.method951();
               return;
            }
         }

         int i_50_ = Class159.anInt1995 - 1;

         while(i_50_ > 0 && i_46_ > planes[i_50_].getVerticeHeight(i_45_, i, (byte)-118)) {
            --i_50_;
         }

         if (class355.aBoolean4354 && i_50_ == 0 && i_46_ > planes[0].getVerticeHeight(i_45_, i, (byte)-118)) {
            this.method951();
         } else if (i_50_ == Class159.anInt1995 - 1 && planes[i_50_].getVerticeHeight(i_45_, i, (byte)-118) - i_46_ > 8 << Class36.INT_9) {
            this.method951();
         } else {
            class261 = Class175.aClass261ArrayArrayArray2099[i_50_][i][i_45_];
            if (class261 == null) {
               if (i_50_ == 0 || Class175.aClass261ArrayArrayArray2099[0][i][i_45_] == null) {
                  class261 = Class175.aClass261ArrayArrayArray2099[0][i][i_45_] = new Class261(0);
               }

               boolean bool = Class175.aClass261ArrayArrayArray2099[0][i][i_45_].aClass261_3310 != null;
               if (i_50_ == 3 && bool) {
                  this.method951();
                  return;
               }

               for(int i_51_ = 1; i_51_ <= i_50_; ++i_51_) {
                  if (Class175.aClass261ArrayArrayArray2099[i_51_][i][i_45_] == null) {
                     class261 = Class175.aClass261ArrayArrayArray2099[i_51_][i][i_45_] = new Class261(i_51_);
                     if (bool) {
                        ++class261.aByte3311;
                     }
                  }
               }
            }

            if (class355.aBoolean4355) {
               int i_52_ = this.anInt9174 >> 12;
               int i_53_ = this.anInt9173 >> 12;
               if (class261.anAnimable_Sub2_3314 != null) {
                  Class171 class171 = class261.anAnimable_Sub2_3314.method809(graphicstoolkit, -105);
                  if (class171 != null && class171.method1795(i_46_, (byte)119, i_53_, i_52_)) {
                     this.method951();
                     return;
                  }
               }

               if (class261.anAnimable_Sub2_3308 != null) {
                  Class171 class171 = class261.anAnimable_Sub2_3308.method809(graphicstoolkit, -120);
                  if (class171 != null && class171.method1795(i_46_, (byte)120, i_53_, i_52_)) {
                     this.method951();
                     return;
                  }
               }

               if (class261.anAnimable_Sub1_3317 != null) {
                  Class171 class171 = class261.anAnimable_Sub1_3317.method809(graphicstoolkit, -109);
                  if (class171 != null && class171.method1795(i_46_, (byte)107, i_53_, i_52_)) {
                     this.method951();
                     return;
                  }
               }

               for(Class256 class256 = class261.aClass256_3312; class256 != null; class256 = class256.aClass256_3238) {
                  Class171 class171 = class256.aMobile3239.method809(graphicstoolkit, -117);
                  if (class171 != null && class171.method1795(i_46_, (byte)119, i_53_, i_52_)) {
                     this.method951();
                     return;
                  }
               }
            }

            entitynode_sub4.aClass198_5977.aClass87_2429.method1012(127, this);
         }
      } else {
         this.method951();
      }
   }

   EntityNode_Sub3_Sub2_Sub1(
      EntityNode_Sub7 entitynode_sub7,
      int i,
      int i_54_,
      int i_55_,
      int i_56_,
      int i_57_,
      int i_58_,
      int i_59_,
      int i_60_,
      int i_61_,
      int i_62_,
      int i_63_,
      boolean bool,
      boolean bool_64_
   ) {
      this.anEntityNode_Sub7_11027 = entitynode_sub7;
      this.anInt9174 = i << 12;
      this.anInt9171 = i_54_ << 12;
      this.anInt9173 = i_55_ << 12;
      this.anInt9176 = i_61_;
      this.aShort11022 = this.aShort11026 = (short)i_60_;
      this.anInt9172 = i_62_;
      this.anInt9177 = i_63_;
      this.aBoolean9169 = bool_64_;
      this.aShort11021 = (short)i_56_;
      this.aShort11025 = (short)i_57_;
      this.aShort11024 = (short)i_58_;
      this.anInt11028 = i_59_;
      this.aByte9170 = this.anEntityNode_Sub7_11027.aClass300_6003.aByte3768;
      this.method947();
   }

   final void method950(
      EntityNode_Sub7 entitynode_sub7,
      int i,
      int i_65_,
      int i_66_,
      int i_67_,
      int i_68_,
      int i_69_,
      int i_70_,
      int i_71_,
      int i_72_,
      int i_73_,
      int i_74_,
      boolean bool,
      boolean bool_75_
   ) {
      this.anEntityNode_Sub7_11027 = entitynode_sub7;
      this.anInt9174 = i << 12;
      this.anInt9171 = i_65_ << 12;
      this.anInt9173 = i_66_ << 12;
      this.anInt9176 = i_72_;
      this.aShort11022 = this.aShort11026 = (short)i_71_;
      this.anInt9172 = i_73_;
      this.anInt9177 = i_74_;
      this.aBoolean9169 = bool_75_;
      this.aShort11021 = (short)i_67_;
      this.aShort11025 = (short)i_68_;
      this.aShort11024 = (short)i_69_;
      this.anInt11028 = i_70_;
      this.aByte9170 = this.anEntityNode_Sub7_11027.aClass300_6003.aByte3768;
      this.method947();
   }

   final void method951() {
      this.anEntityNode_Sub7_11027.anEntityNode_Sub4_6009.anEntityNode_Sub3_Sub2_Sub1Array5970[this.aShort11020] = null;
      Class284.anEntityNode_Sub3_Sub2_Sub1Array3596[Packet.anInt9386] = this;
      Packet.anInt9386 = Packet.anInt9386 + 1 & 1023;
      this.method803(false);
      this.method937(true);
   }
}
