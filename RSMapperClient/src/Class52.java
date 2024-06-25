import java.util.Random;

abstract class Class52 {
   static int anInt784;
   static int anInt785;
   static int anInt786;
   static int anInt787;
   static CacheNode_Sub13 aCacheNode_Sub13_788;
   private Class357 aClass357_789;
   static int anInt790;
   static int anInt791;
   static int anInt792;
   static int anInt793;
   static int anInt794;
   static int anInt795;
   static int anInt796;
   static int anInt797;
   static int anInt798;
   private GraphicsToolkit aGraphicsToolkit799;
   static int anInt800 = 0;
   static int anInt801;
   static int anInt802;
   static int anInt803;
   static int anInt804;
   static int anInt805;
   static int anInt806;

   final int method525(GLSprite[] glsprites, int i, int i_0_, int i_1_, int i_2_, String string, int[] is, int i_3_, Random random, int i_4_) {
      ++anInt792;
      if (string == null) {
         return 0;
      } else {
         random.setSeed((long)i);
         int i_5_ = 192 - -(random.nextInt() & 31);
         this.method534(1, i_5_ << 24 | i_0_ & 16777215, i_5_ << 24 | 16777215 & i_3_);
         int i_6_ = string.length();
         int[] is_7_ = new int[i_6_];
         if (i_2_ != 8906) {
            this.method534(-14, -66, -70);
         }

         int i_8_ = 0;

         for(int i_9_ = 0; ~i_6_ < ~i_9_; ++i_9_) {
            is_7_[i_9_] = i_8_;
            if (~(3 & random.nextInt()) == -1) {
               ++i_8_;
            }
         }

         this.method529(is_7_, string, i_1_, glsprites, i_4_, null, true, is);
         return i_8_;
      }
   }

   abstract void method526(char var1, int var2, int var3, int var4, boolean var5, aa var6, int var7, int var8);

   final void method527(int i, int i_14_, int i_15_, int i_16_, int i_17_, String string, int i_18_, int i_19_) {
      ++anInt790;
      if (string != null) {
         this.method534(i_19_ ^ -1071, i_17_, i_18_);
         if (i_19_ != -1072) {
            this.aGraphicsToolkit799 = null;
         }

         double d = -((double)i / 8.0) + 7.0;
         if (d < 0.0) {
            d = 0.0;
         }

         int i_20_ = string.length();
         int[] is = new int[i_20_];

         for(int i_21_ = 0; i_20_ > i_21_; ++i_21_) {
            is[i_21_] = (int)(Math.sin((double)i_15_ + (double)i_21_ / 1.5) * d);
         }

         this.method529(null, string, i_16_, null, -(this.aClass357_789.method4033((byte)-6, string) / 2) + i_14_, is, true, null);
      }
   }

   static final void method528(int i, int i_22_) {
      ++anInt793;
      if (i != 255) {
         aCacheNode_Sub13_788 = null;
      }

      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(i ^ 252, 4, (long)i_22_);
      cachenode_sub2.method2291((byte)121);
   }

   private final void method529(int[] is, String string, int i, GLSprite[] glsprites, int i_23_, int[] is_24_, boolean bool, int[] is_25_) {
      i -= this.aClass357_789.anInt4430;
      ++anInt786;
      int i_26_ = -1;
      int i_27_ = -1;
      int i_28_ = 0;
      int i_29_ = string.length();
      if (!bool) {
         method532((byte)-47);
      }

      for(int i_30_ = 0; i_29_ > i_30_; ++i_30_) {
         char c = (char)(Class26.method312(string.charAt(i_30_), (byte)-81) & 255);
         if (c == '<') {
            i_26_ = i_30_;
         } else {
            if (c == '>' && i_26_ != -1) {
               String string_31_ = string.substring(1 + i_26_, i_30_);
               i_26_ = -1;
               if (string_31_.equals("lt")) {
                  c = '<';
               } else if (string_31_.equals("gt")) {
                  c = '>';
               } else if (string_31_.equals("nbsp")) {
                  c = 160;
               } else if (string_31_.equals("shy")) {
                  c = 173;
               } else if (string_31_.equals("times")) {
                  c = 215;
               } else if (!string_31_.equals("euro")) {
                  if (string_31_.equals("copy")) {
                     c = 169;
                  } else {
                     if (!string_31_.equals("reg")) {
                        if (string_31_.startsWith("img=")) {
                           try {
                              int i_32_;
                              if (is == null) {
                                 i_32_ = 0;
                              } else {
                                 i_32_ = is[i_28_];
                              }

                              int i_33_;
                              if (is_24_ == null) {
                                 i_33_ = 0;
                              } else {
                                 i_33_ = is_24_[i_28_];
                              }

                              ++i_28_;
                              int i_34_ = Class350.method3998(string_31_.substring(4), -1);
                              GLSprite glsprite = glsprites[i_34_];
                              int i_35_ = is_25_ == null ? glsprite.method1186() : is_25_[i_34_];
                              glsprite.method1191(i_32_ + i_23_, i_33_ + -i_35_ + i + this.aClass357_789.anInt4430, 1, 0, 1);
                              i_27_ = -1;
                              i_23_ += glsprites[i_34_].method1197();
                           } catch (Exception var21) {
                           }
                        } else {
                           this.method540(-119, string_31_);
                        }
                        continue;
                     }

                     c = 174;
                  }
               } else {
                  c = 8364;
               }
            }

            if (i_26_ == -1) {
               if (~i_27_ != 0) {
                  i_23_ += this.aClass357_789.method4026(c, i_27_, 255);
               }

               int i_36_;
               if (is == null) {
                  i_36_ = 0;
               } else {
                  i_36_ = is[i_28_];
               }

               int i_37_;
               if (is_24_ == null) {
                  i_37_ = 0;
               } else {
                  i_37_ = is_24_[i_28_];
               }

               if (c != ' ') {
                  if ((CacheNode_Sub4.anInt9465 & 0xFF000000) != 0) {
                     this.fa(c, 1 + i_23_ + i_36_, i_37_ + i - -1, CacheNode_Sub4.anInt9465, true);
                  }

                  this.fa(c, i_23_ + i_36_, i_37_ + i, Class270_Sub2_Sub2.anInt10558, false);
               } else if (Class25.anInt446 > 0) {
                  Class150_Sub3.anInt8970 += Class25.anInt446;
                  i_23_ += Class150_Sub3.anInt8970 >> 8;
                  Class150_Sub3.anInt8970 &= 255;
               }

               ++i_28_;
               int i_38_ = this.aClass357_789.method4027(c, !bool);
               if (~Class339.anInt4204 != 0) {
                  this.aGraphicsToolkit799.method1242((int)(0.7 * (double)this.aClass357_789.anInt4430) + i, Class339.anInt4204, i_23_, false, i_38_);
               }

               if (~Class370.anInt4568 != 0) {
                  this.aGraphicsToolkit799.method1242(this.aClass357_789.anInt4430 + i, Class370.anInt4568, i_23_, false, i_38_);
               }

               i_23_ += i_38_;
               i_27_ = c;
            }
         }
      }
   }

   static final Node_Sub38 method530(int i, int i_39_) {
      ++anInt803;
      if (~i != -1) {
         if (i != 1) {
            if (i != 2) {
               if (~i != -4) {
                  if (i != 4) {
                     if (i != 5) {
                        if (~i != -7) {
                           if (i != 7) {
                              if (~i != -9) {
                                 if (~i != -10) {
                                    if (~i != -11) {
                                       if (i != 11) {
                                          if (i != 12) {
                                             if (i != 13) {
                                                if (~i != -15) {
                                                   if (i != 15) {
                                                      if (~i != -17) {
                                                         if (~i != -18) {
                                                            if (i != 18) {
                                                               if (i != 19) {
                                                                  if (~i != -21) {
                                                                     if (~i != -22) {
                                                                        if (~i != -23) {
                                                                           if (~i != -24) {
                                                                              if (~i != -25) {
                                                                                 if (i != 25) {
                                                                                    if (i != 26) {
                                                                                       if (~i != -28) {
                                                                                          if (~i != -29) {
                                                                                             if (~i != -30) {
                                                                                                if (~i != -31) {
                                                                                                   if (i != 31) {
                                                                                                      if (i != 32) {
                                                                                                         if (~i != -34) {
                                                                                                            if (~i != -35) {
                                                                                                               if (i != 35) {
                                                                                                                  if (~i != -37) {
                                                                                                                     if (i != 37) {
                                                                                                                        if (i != 38) {
                                                                                                                           if (i != 39) {
                                                                                                                              int i_40_ = 15
                                                                                                                                 / ((-30 - i_39_) / 62);
                                                                                                                              return null;
                                                                                                                           } else {
                                                                                                                              return new Node_Sub38_Sub8();
                                                                                                                           }
                                                                                                                        } else {
                                                                                                                           return new Node_Sub38_Sub15();
                                                                                                                        }
                                                                                                                     } else {
                                                                                                                        return new Node_Sub38_Sub20();
                                                                                                                     }
                                                                                                                  } else {
                                                                                                                     return new Node_Sub38_Sub1();
                                                                                                                  }
                                                                                                               } else {
                                                                                                                  return new Node_Sub38_Sub22();
                                                                                                               }
                                                                                                            } else {
                                                                                                               return new Node_Sub38_Sub27();
                                                                                                            }
                                                                                                         } else {
                                                                                                            return new Node_Sub38_Sub19();
                                                                                                         }
                                                                                                      } else {
                                                                                                         return new Node_Sub38_Sub32();
                                                                                                      }
                                                                                                   } else {
                                                                                                      return new Node_Sub38_Sub36();
                                                                                                   }
                                                                                                } else {
                                                                                                   return new Node_Sub38_Sub13();
                                                                                                }
                                                                                             } else {
                                                                                                return new Node_Sub38_Sub24();
                                                                                             }
                                                                                          } else {
                                                                                             return new Node_Sub38_Sub7();
                                                                                          }
                                                                                       } else {
                                                                                          return new Node_Sub38_Sub28();
                                                                                       }
                                                                                    } else {
                                                                                       return new Node_Sub38_Sub6();
                                                                                    }
                                                                                 } else {
                                                                                    return new Node_Sub38_Sub5();
                                                                                 }
                                                                              } else {
                                                                                 return new Node_Sub38_Sub21();
                                                                              }
                                                                           } else {
                                                                              return new Node_Sub38_Sub31();
                                                                           }
                                                                        } else {
                                                                           return new Node_Sub38_Sub16();
                                                                        }
                                                                     } else {
                                                                        return new Node_Sub38_Sub2();
                                                                     }
                                                                  } else {
                                                                     return new Node_Sub38_Sub30();
                                                                  }
                                                               } else {
                                                                  return new Node_Sub38_Sub10();
                                                               }
                                                            } else {
                                                               return new Node_Sub38_Sub8_Sub1();
                                                            }
                                                         } else {
                                                            return new Node_Sub38_Sub9();
                                                         }
                                                      } else {
                                                         return new Node_Sub38_Sub39();
                                                      }
                                                   } else {
                                                      return new Node_Sub38_Sub23();
                                                   }
                                                } else {
                                                   return new Node_Sub38_Sub29();
                                                }
                                             } else {
                                                return new Node_Sub38_Sub34();
                                             }
                                          } else {
                                             return new Node_Sub38_Sub4();
                                          }
                                       } else {
                                          return new Node_Sub38_Sub3();
                                       }
                                    } else {
                                       return new Node_Sub38_Sub14();
                                    }
                                 } else {
                                    return new Node_Sub38_Sub38();
                                 }
                              } else {
                                 return new Node_Sub38_Sub37();
                              }
                           } else {
                              return new Node_Sub38_Sub18();
                           }
                        } else {
                           return new Node_Sub38_Sub35();
                        }
                     } else {
                        return new Node_Sub38_Sub12();
                     }
                  } else {
                     return new Node_Sub38_Sub11();
                  }
               } else {
                  return new Node_Sub38_Sub25();
               }
            } else {
               return new Node_Sub38_Sub33();
            }
         } else {
            return new Node_Sub38_Sub26();
         }
      } else {
         return new Node_Sub38_Sub17();
      }
   }

   private final void method531(byte b, int i, String string) {
      ++anInt796;
      int i_41_ = 0;
      boolean bool = false;
      int i_42_ = -117 % ((28 - b) / 37);

      for(int i_43_ = 0; ~string.length() < ~i_43_; ++i_43_) {
         char c = string.charAt(i_43_);
         if (c == '<') {
            bool = true;
         } else if (c != '>') {
            if (!bool && c == ' ') {
               ++i_41_;
            }
         } else {
            bool = false;
         }
      }

      if (~i_41_ < -1) {
         Class25.anInt446 = (i - this.aClass357_789.method4033((byte)-6, string) << 8) / i_41_;
      }
   }

   public static void method532(byte b) {
      if (b > -65) {
         method532((byte)-3);
      }

      aCacheNode_Sub13_788 = null;
   }

   private final void method533(GLSprite[] glsprites, int i, int i_44_, String string, int i_45_, boolean bool, aa var_aa, int i_46_, int[] is) {
      i_46_ -= this.aClass357_789.anInt4430;
      ++anInt806;
      int i_47_ = -1;
      if (bool) {
         int i_48_ = -1;
         int i_49_ = string.length();

         for(int i_50_ = 0; ~i_49_ < ~i_50_; ++i_50_) {
            char c = (char)(255 & Class26.method312(string.charAt(i_50_), (byte)-54));
            if (c == '<') {
               i_47_ = i_50_;
            } else {
               if (c == '>' && i_47_ != -1) {
                  String string_51_ = string.substring(1 + i_47_, i_50_);
                  i_47_ = -1;
                  if (string_51_.equals("lt")) {
                     c = '<';
                  } else if (!string_51_.equals("gt")) {
                     if (string_51_.equals("nbsp")) {
                        c = 160;
                     } else if (string_51_.equals("shy")) {
                        c = 173;
                     } else if (!string_51_.equals("times")) {
                        if (!string_51_.equals("euro")) {
                           if (string_51_.equals("copy")) {
                              c = 169;
                           } else {
                              if (!string_51_.equals("reg")) {
                                 if (string_51_.startsWith("img=")) {
                                    try {
                                       int i_52_ = Class350.method3998(string_51_.substring(4), -1);
                                       GLSprite glsprite = glsprites[i_52_];
                                       int i_53_ = is != null ? is[i_52_] : glsprite.method1186();
                                       if (~(Class270_Sub2_Sub2.anInt10558 & 0xFF000000) == 16777215) {
                                          glsprite.method1191(i_45_, -i_53_ + this.aClass357_789.anInt4430 + i_46_, 1, 0, 1);
                                       } else {
                                          glsprite.method1191(
                                             i_45_, -i_53_ + i_46_ + this.aClass357_789.anInt4430, 0, Class270_Sub2_Sub2.anInt10558 & 0xFF000000 | 16777215, 1
                                          );
                                       }

                                       i_48_ = -1;
                                       i_45_ += glsprites[i_52_].method1197();
                                    } catch (Exception var19) {
                                    }
                                 } else {
                                    this.method540(-66, string_51_);
                                 }
                                 continue;
                              }

                              c = 174;
                           }
                        } else {
                           c = 8364;
                        }
                     } else {
                        c = 215;
                     }
                  } else {
                     c = '>';
                  }
               }

               if (i_47_ == -1) {
                  if (i_48_ != -1) {
                     i_45_ += this.aClass357_789.method4026(c, i_48_, 255);
                  }

                  if (~c == -33) {
                     if (Class25.anInt446 > 0) {
                        Class150_Sub3.anInt8970 += Class25.anInt446;
                        i_45_ += Class150_Sub3.anInt8970 >> 8;
                        Class150_Sub3.anInt8970 &= 255;
                     }
                  } else if (var_aa == null) {
                     if (~(CacheNode_Sub4.anInt9465 & 0xFF000000) != -1) {
                        this.fa(c, 1 + i_45_, i_46_ - -1, CacheNode_Sub4.anInt9465, true);
                     }

                     this.fa(c, i_45_, i_46_, Class270_Sub2_Sub2.anInt10558, false);
                  } else {
                     if ((CacheNode_Sub4.anInt9465 & 0xFF000000) != 0) {
                        this.method526(c, 1 + i_45_, i_46_ - -1, CacheNode_Sub4.anInt9465, true, var_aa, i_44_, i);
                     }

                     this.method526(c, i_45_, i_46_, Class270_Sub2_Sub2.anInt10558, false, var_aa, i_44_, i);
                  }

                  int i_54_ = this.aClass357_789.method4027(c, false);
                  if (~Class339.anInt4204 != 0) {
                     this.aGraphicsToolkit799.method1242(i_46_ + (int)(0.7 * (double)this.aClass357_789.anInt4430), Class339.anInt4204, i_45_, false, i_54_);
                  }

                  if (~Class370.anInt4568 != 0) {
                     this.aGraphicsToolkit799.method1242(1 + this.aClass357_789.anInt4430 + i_46_, Class370.anInt4568, i_45_, false, i_54_);
                  }

                  i_48_ = c;
                  i_45_ += i_54_;
               }
            }
         }
      }
   }

   private final void method534(int i, int i_55_, int i_56_) {
      if (i != 1) {
         aCacheNode_Sub13_788 = null;
      }

      Class25.anInt446 = 0;
      Node_Sub25_Sub4.anInt10011 = i_55_;
      Class270_Sub2_Sub2.anInt10558 = i_55_;
      ++anInt784;
      Class150_Sub3.anInt8970 = 0;
      Class370.anInt4568 = -1;
      Class339.anInt4204 = -1;
      if (i_56_ == -1) {
         i_56_ = 0;
      }

      Node_Sub25_Sub4.anInt10009 = i_56_;
      CacheNode_Sub4.anInt9465 = i_56_;
   }

   final int method535(
      int i,
      int[] is,
      int i_57_,
      String string,
      aa var_aa,
      GLSprite[] glsprites,
      int i_58_,
      int i_59_,
      int i_60_,
      int i_61_,
      int i_62_,
      int i_63_,
      int i_64_,
      int i_65_,
      int i_66_,
      int i_67_
   ) {
      ++anInt798;
      if (i_60_ <= 70) {
         this.method536(98, 77, -16, null, 105, 89, null, null);
      }

      return this.method539(i_64_, 2, i_57_, i_59_, glsprites, 0, i, i_58_, i_67_, i_61_, var_aa, i_65_, i_66_, i_63_, i_62_, is, string);
   }

   abstract void fa(char var1, int var2, int var3, int var4, boolean var5);

   final void method536b(GLSprite glsprite, int i, int i_70_, int i_71_, int i_73_, int[] is) {
      ++anInt794;
      this.method534(1, i, i_70_);
      this.method533(new GLSprite[]{glsprite}, 0, 0, "<img=0>", i_73_, true, null, i_71_, is);
   }

   final void method536(int i, int i_70_, int i_71_, String string, int junk, int i_73_, GLSprite[] glsprites, int[] is) {
      if (junk == -238946248) {
         ++anInt794;
         if (string != null) {
            this.method534(1, i, i_70_);
            this.method533(glsprites, 0, 0, string, i_73_, true, null, i_71_, is);
         }
      }
   }

   final void method537(int i, byte junk, int i_74_, String string, int i_75_, int i_76_) {
      if (junk >= 95) {
         ++anInt785;
         if (string != null) {
            this.method534(1, i_76_, i);
            this.method533(null, 0, 0, string, -(this.aClass357_789.method4033((byte)-6, string) / 2) + i_74_, true, null, i_75_, null);
         }
      }
   }

   final void method538(int i, int i_77_, String string, int i_78_, int i_79_, int i_80_) {
      ++anInt804;
      if (string != null) {
         this.method534(i_79_, i_80_, i_78_);
         this.method533(null, 0, 0, string, i, true, null, i_77_, null);
      }
   }

   final int method539(
      int i,
      int i_81_,
      int i_82_,
      int i_83_,
      GLSprite[] glsprites,
      int i_84_,
      int i_85_,
      int i_86_,
      int i_87_,
      int i_88_,
      aa var_aa,
      int i_89_,
      int i_90_,
      int i_91_,
      int i_92_,
      int[] is,
      String string
   ) {
      ++anInt795;
      if (string == null) {
         return 0;
      } else {
         if (i_81_ != 2) {
            this.method539(-69, 108, -103, 49, null, 53, -66, 62, 11, 81, null, -110, -87, -20, 114, null, null);
         }

         this.method534(1, i_82_, i_83_);
         if (~i_89_ == -1) {
            i_89_ = this.aClass357_789.anInt4430;
         }

         int[] is_93_;
         if (~(i_89_ + this.aClass357_789.anInt4442 + this.aClass357_789.anInt4434) < ~i_87_ && ~i_87_ > ~(i_89_ - -i_89_)) {
            is_93_ = null;
         } else {
            is_93_ = new int[]{i_90_};
         }

         int i_94_ = this.aClass357_789.method4029(Class9.aStringArray167, is_93_, -78, glsprites, string);
         if (~i_84_ == 0) {
            i_84_ = i_87_ / i_89_;
            if (~i_84_ >= -1) {
               i_84_ = 1;
            }
         }

         if (~i_84_ < -1 && ~i_84_ >= ~i_94_) {
            i_94_ = i_84_;
            Class9.aStringArray167[i_84_ - 1] = this.aClass357_789.method4032(Class9.aStringArray167[i_84_ + -1], glsprites, i_90_, i_81_ + -3);
         }

         if (i == 3 && i_94_ == 1) {
            i = 1;
         }

         int i_95_;
         if (~i != -1) {
            if (~i == -2) {
               i_95_ = (-this.aClass357_789.anInt4442 + -this.aClass357_789.anInt4434 + i_87_ - i_89_ * (-1 + i_94_)) / 2
                  + this.aClass357_789.anInt4434
                  + i_86_;
            } else if (i == 2) {
               i_95_ = -(i_89_ * (i_94_ - 1)) + -this.aClass357_789.anInt4442 + i_87_ + i_86_;
            } else {
               int i_96_ = (-this.aClass357_789.anInt4434 + i_87_ + -this.aClass357_789.anInt4442 - i_89_ * (i_94_ - 1)) / (1 + i_94_);
               if (~i_96_ > -1) {
                  i_96_ = 0;
               }

               i_89_ += i_96_;
               i_95_ = i_86_ + this.aClass357_789.anInt4434 - -i_96_;
            }
         } else {
            i_95_ = this.aClass357_789.anInt4434 + i_86_;
         }

         for(int i_97_ = 0; ~i_94_ < ~i_97_; ++i_97_) {
            if (~i_92_ != -1) {
               if (i_92_ != 1) {
                  if (~i_92_ == -3) {
                     this.method533(
                        glsprites,
                        i_85_,
                        i_88_,
                        Class9.aStringArray167[i_97_],
                        i_91_ + i_90_ + -this.aClass357_789.method4033((byte)-6, Class9.aStringArray167[i_97_]),
                        true,
                        var_aa,
                        i_95_,
                        is
                     );
                  } else if (i_94_ - 1 == i_97_) {
                     this.method533(glsprites, i_85_, i_88_, Class9.aStringArray167[i_97_], i_91_, true, var_aa, i_95_, is);
                  } else {
                     this.method531((byte)93, i_90_, Class9.aStringArray167[i_97_]);
                     this.method533(glsprites, i_85_, i_88_, Class9.aStringArray167[i_97_], i_91_, true, var_aa, i_95_, is);
                     Class25.anInt446 = 0;
                  }
               } else {
                  this.method533(
                     glsprites,
                     i_85_,
                     i_88_,
                     Class9.aStringArray167[i_97_],
                     i_91_ - -((i_90_ - this.aClass357_789.method4033((byte)-6, Class9.aStringArray167[i_97_])) / 2),
                     true,
                     var_aa,
                     i_95_,
                     is
                  );
               }
            } else {
               this.method533(glsprites, i_85_, i_88_, Class9.aStringArray167[i_97_], i_91_, true, var_aa, i_95_, is);
            }

            i_95_ += i_89_;
         }

         return i_94_;
      }
   }

   private final void method540(int i, String string) {
      try {
         if (string.startsWith("col=")) {
            Class270_Sub2_Sub2.anInt10558 = Class270_Sub2_Sub2.anInt10558 & 0xFF000000 | Class10.method187(string.substring(4), 16, true) & 16777215;
         } else if (string.equals("/col")) {
            Class270_Sub2_Sub2.anInt10558 = Class270_Sub2_Sub2.anInt10558 & 0xFF000000 | Node_Sub25_Sub4.anInt10011 & 16777215;
         }

         if (!string.startsWith("argb=")) {
            if (string.equals("/argb")) {
               Class270_Sub2_Sub2.anInt10558 = Node_Sub25_Sub4.anInt10011;
            } else if (!string.startsWith("str=")) {
               if (string.equals("str")) {
                  Class339.anInt4204 = Class270_Sub2_Sub2.anInt10558 & 0xFF000000 | 8388608;
               } else if (!string.equals("/str")) {
                  if (!string.startsWith("u=")) {
                     if (string.equals("u")) {
                        Class370.anInt4568 = Class270_Sub2_Sub2.anInt10558 & 0xFF000000;
                     } else if (!string.equals("/u")) {
                        if (!string.equalsIgnoreCase("shad=-1")) {
                           if (string.startsWith("shad=")) {
                              CacheNode_Sub4.anInt9465 = Class270_Sub2_Sub2.anInt10558 & 0xFF000000 | Class10.method187(string.substring(5), 16, true);
                           } else if (string.equals("shad")) {
                              CacheNode_Sub4.anInt9465 = 0xFF000000 & Class270_Sub2_Sub2.anInt10558;
                           } else if (string.equals("/shad")) {
                              CacheNode_Sub4.anInt9465 = Node_Sub25_Sub4.anInt10009;
                           } else if (string.equals("br")) {
                              this.method534(1, Node_Sub25_Sub4.anInt10011, Node_Sub25_Sub4.anInt10009);
                           }
                        } else {
                           CacheNode_Sub4.anInt9465 = 0;
                        }
                     } else {
                        Class370.anInt4568 = -1;
                     }
                  } else {
                     Class370.anInt4568 = 0xFF000000 & Class270_Sub2_Sub2.anInt10558 | Class10.method187(string.substring(2), 16, true);
                  }
               } else {
                  Class339.anInt4204 = -1;
               }
            } else {
               Class339.anInt4204 = 0xFF000000 & Class270_Sub2_Sub2.anInt10558 | Class10.method187(string.substring(4), 16, true);
            }
         } else {
            Class270_Sub2_Sub2.anInt10558 = Class10.method187(string.substring(5), 16, true);
         }
      } catch (Exception var4) {
      }

      ++anInt797;
      if (i >= -23) {
         this.method536(-98, 105, -36, null, 25, 51, null, null);
      }
   }

   final void method541(int i, int i_98_, String string, int i_99_, int i_100_, int i_101_, int i_102_) {
      ++anInt805;
      if (string != null) {
         this.method534(1, i_100_, i);
         int i_103_ = string.length();
         int[] is = new int[i_103_];
         int[] is_104_ = new int[i_103_];
         if (i_102_ == 16777215) {
            for(int i_105_ = 0; ~i_103_ < ~i_105_; ++i_105_) {
               is[i_105_] = (int)(5.0 * Math.sin((double)i_105_ / 5.0 + (double)i_98_ / 5.0));
               is_104_[i_105_] = (int)(5.0 * Math.sin((double)i_105_ / 3.0 + (double)i_98_ / 5.0));
            }

            this.method529(is, string, i_101_, null, -(this.aClass357_789.method4033((byte)-6, string) / 2) + i_99_, is_104_, true, null);
         }
      }
   }

   final void method542(int i, int i_106_, int i_107_, String string, int i_108_, int i_109_, int i_110_) {
      ++anInt787;
      if (string != null) {
         this.method534(1, i_106_, i_110_);
         int i_111_ = string.length();
         if (i == 5) {
            int[] is = new int[i_111_];

            for(int i_112_ = 0; i_111_ > i_112_; ++i_112_) {
               is[i_112_] = (int)(5.0 * Math.sin((double)i_112_ / 2.0 + (double)i_107_ / 5.0));
            }

            this.method529(null, string, i_109_, null, i_108_ - this.aClass357_789.method4033((byte)-6, string) / 2, is, true, null);
         }
      }
   }

   final void method543(byte b, int i, String string, int i_113_, int i_114_, int i_115_) {
      ++anInt802;
      int i_116_ = -65 % ((43 - b) / 37);
      if (string != null) {
         this.method534(1, i_113_, i_114_);
         this.method533(null, 0, 0, string, i + -this.aClass357_789.method4033((byte)-6, string), true, null, i_115_, null);
      }
   }

   static final void method544(int i, int i_117_, int i_118_, int i_119_, byte b) {
      ++anInt791;
      za_Sub2.anInt10513 = i_118_;
      Node_Sub25_Sub1.anInt9936 = i;
      if (b >= -124) {
         method528(89, -7);
      }

      Class262_Sub4.anInt7722 = i_117_;
      Class384.anInt4906 = i_119_;
   }

   final int method545(
      int[] is,
      int i,
      int i_120_,
      int i_121_,
      int[] is_122_,
      int i_123_,
      int i_124_,
      Random random,
      String string,
      int i_125_,
      int i_126_,
      GLSprite[] glsprites,
      int i_127_,
      int i_128_,
      int i_129_
   ) {
      ++anInt801;
      if (string == null) {
         return 0;
      } else {
         random.setSeed((long)i_127_);
         int i_130_ = 192 + (31 & random.nextInt());
         this.method534(1, i_130_ << 24 | 16777215 & i_123_, i_130_ << 24 | i_126_ & 16777215);
         int i_131_ = string.length();
         int[] is_132_ = new int[i_131_];
         int i_133_ = i_121_;

         for(int i_134_ = 0; ~i_131_ < ~i_134_; ++i_134_) {
            is_132_[i_134_] = i_133_;
            if ((3 & random.nextInt()) == 0) {
               ++i_133_;
            }
         }

         int i_135_ = i_125_;
         int i_136_ = this.aClass357_789.anInt4434 + i_128_;
         if (i_129_ != 1) {
            if (i_129_ == 2) {
               i_136_ = i_128_ + i_124_ + -this.aClass357_789.anInt4442;
            }
         } else {
            i_136_ += (-this.aClass357_789.anInt4434 + i_124_ + -this.aClass357_789.anInt4442) / 2;
         }

         int i_137_ = -1;
         if (~i != -2) {
            if (i == 2) {
               i_137_ = i_133_ + this.aClass357_789.method4033((byte)-6, string);
               i_135_ = i_125_ + (i_120_ - i_137_);
            }
         } else {
            i_137_ = i_133_ + this.aClass357_789.method4033((byte)-6, string);
            i_135_ = i_125_ + (-i_137_ + i_120_) / 2;
         }

         this.method529(is_132_, string, i_136_, glsprites, i_135_, null, true, is_122_);
         if (is != null) {
            if (~i_137_ == 0) {
               i_137_ = i_133_ + this.aClass357_789.method4033((byte)-6, string);
            }

            is[3] = this.aClass357_789.anInt4442 + this.aClass357_789.anInt4434;
            is[0] = i_135_;
            is[2] = i_137_;
            is[1] = -this.aClass357_789.anInt4434 + i_136_;
         }

         return i_133_;
      }
   }

   Class52(GraphicsToolkit graphicstoolkit, Class357 class357) {
      this.aGraphicsToolkit799 = graphicstoolkit;
      this.aClass357_789 = class357;
   }
}
