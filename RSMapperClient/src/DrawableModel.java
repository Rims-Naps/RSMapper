import java.awt.Frame;

abstract class DrawableModel {
   static Frame aFrame907;
   static int anInt908;
   static int anInt909;
   static int anInt910;
   static String[] aStringArray911 = new String[100];
   static int anInt912;
   static boolean aBoolean913;
   protected boolean aBoolean914 = false;
   static int anInt915;
   static int anInt916;
   static int anInt917;
   static int anInt918;
   static int anInt919;

   abstract void method611(Class336 var1, EntityNode_Sub5 var2, int var3);

   abstract void I(int var1, int[] var2, int var3, int var4, int var5, boolean var6, int var7, int[] var8);

   abstract boolean method612();

   private final void method613(int i, int i_5_, int i_6_, int[] is, int[] is_7_, boolean bool, boolean bool_8_, int i_9_, int i_10_, int i_11_) {
      if (~i_9_ == -2) {
         if (i_5_ == 0 || ~i_5_ == -2) {
            int i_12_ = -i_10_;
            i_10_ = i;
            i = i_12_;
         } else if (i_5_ == 3) {
            int i_13_ = i_10_;
            i_10_ = i;
            i = i_13_;
         } else if (i_5_ == 2) {
            int i_14_ = i_10_;
            i_10_ = 16383 & -i;
            i = i_14_ & 16383;
         }
      } else if (i_9_ == 2) {
         if (i_5_ == 0 || ~i_5_ == -2) {
            i_10_ = -i_10_;
            i = -i;
         } else if (~i_5_ == -3) {
            i = 16383 & -i;
            i_10_ = -i_10_ & 16383;
         }
      } else if (i_9_ == 3) {
         if (~i_5_ == -1 || ~i_5_ == -2) {
            int i_15_ = i_10_;
            i_10_ = -i;
            i = i_15_;
         } else if (~i_5_ != -4) {
            if (~i_5_ == -3) {
               int i_16_ = i_10_;
               i_10_ = 16383 & i;
               i = 16383 & -i_16_;
            }
         } else {
            int i_17_ = i_10_;
            i_10_ = i;
            i = i_17_;
         }
      }

      ++anInt919;
      if (!bool_8_) {
         if (~i_6_ != -65536) {
            this.I(i_5_, is, i_10_, i_11_, i, bool, i_6_, is_7_);
         } else {
            this.method637(i_5_, is, i_10_, i_11_, i, i_9_, bool);
         }
      }
   }

   abstract boolean F();

   abstract void method614(Class336 var1);

   abstract void LA(int var1);

   abstract void aa(short var1, short var2);

   abstract void VA(int var1);

   final void method615(
      int i,
      int i_19_,
      CacheNode_Sub15 cachenode_sub15,
      int i_20_,
      int i_21_,
      int i_22_,
      CacheNode_Sub15 cachenode_sub15_23_,
      CacheNode_Sub15 cachenode_sub15_24_,
      int i_25_,
      boolean bool,
      int i_26_,
      CacheNode_Sub15 cachenode_sub15_27_,
      boolean[] bools,
      int i_28_,
      int i_29_
   ) {
      ++anInt912;
      if (~i_19_ != 0) {
         if (bools != null && ~i_29_ != 0) {
            this.method629();
            if (!this.NA()) {
               this.method632();
            } else {
               Class222 class222 = cachenode_sub15_24_.aClass222Array9595[i_19_];
               Node_Sub40 node_sub40 = class222.aNode_Sub40_2634;
               Class222 class222_30_ = null;
               if (cachenode_sub15 != null) {
                  class222_30_ = cachenode_sub15.aClass222Array9595[i_22_];
                  if (class222_30_.aNode_Sub40_2634 != node_sub40) {
                     class222_30_ = null;
                  }
               }

               this.method635(class222_30_, bools, i_25_, false, (byte)82, null, 0, i_28_, class222, node_sub40, 65535, bool);
               Class222 class222_31_ = cachenode_sub15_27_.aClass222Array9595[i_29_];
               Class222 class222_32_ = null;
               if (cachenode_sub15_23_ != null) {
                  class222_32_ = cachenode_sub15_23_.aClass222Array9595[i_20_];
                  if (node_sub40 != class222_32_.aNode_Sub40_2634) {
                     class222_32_ = null;
                  }
               }

               this.method637(0, new int[0], 0, 0, 0, 0, bool);
               this.method635(class222_32_, bools, i, true, (byte)116, null, 0, i_26_, class222_31_, class222_31_.aNode_Sub40_2634, 65535, bool);
               this.wa();
               if (i_21_ >= -7) {
                  aBoolean913 = false;
               }

               this.method632();
            }
         } else {
            this.method625(cachenode_sub15_24_, i_25_, i_28_, cachenode_sub15, i_19_, i_22_, 0, -110, bool);
         }
      }
   }

   abstract r ba(r var1);

   static final void method616(int i, int i_33_, int i_34_, int i_35_, int i_36_, int i_37_, int i_38_, int i_39_, int i_40_, int i_41_) {
      ++anInt908;
      if (i_34_ > -52) {
         aStringArray911 = null;
      }

      if (i >= Class262_Sub4.anInt7722
         && i <= za_Sub2.anInt10513
         && ~Class262_Sub4.anInt7722 >= ~i_41_
         && za_Sub2.anInt10513 >= i_41_
         && i_37_ >= Class262_Sub4.anInt7722
         && ~i_37_ >= ~za_Sub2.anInt10513
         && Class262_Sub4.anInt7722 <= i_40_
         && i_40_ <= za_Sub2.anInt10513
         && ~i_39_ <= ~Class384.anInt4906
         && i_39_ <= Node_Sub25_Sub1.anInt9936
         && ~i_33_ <= ~Class384.anInt4906
         && ~Node_Sub25_Sub1.anInt9936 <= ~i_33_
         && i_35_ >= Class384.anInt4906
         && ~i_35_ >= ~Node_Sub25_Sub1.anInt9936
         && ~i_38_ <= ~Class384.anInt4906
         && ~i_38_ >= ~Node_Sub25_Sub1.anInt9936) {
         RuntimeException_Sub1.method4209(i_39_, i_33_, i_36_, -74, i_37_, i, i_35_, i_38_, i_41_, i_40_);
      } else {
         Class200_Sub1.method2013((byte)-120, i_39_, i_36_, i_38_, i_35_, i_37_, i_33_, i_41_, i, i_40_);
      }
   }

   abstract void method617();

   abstract void s(int var1);

   abstract Class218[] method618();

   abstract void method619(DrawableModel var1, int var2, int var3, int var4, boolean var5);

   abstract void P(int var1, int var2, int var3, int var4);

   abstract Class300[] method620();

   abstract boolean method621(int var1, int var2, Class336 var3, boolean var4, int var5, int var6);

   abstract int HA();

   abstract void method622(Class336 var1, EntityNode_Sub5 var2, int var3, int var4);

   public static void method623(int i) {
      aFrame907 = null;
      aStringArray911 = null;
      if (i != -3581) {
         aBoolean913 = true;
      }
   }

   abstract boolean method624(int var1, int var2, Class336 var3, boolean var4, int var5);

   final void method625(
      CacheNode_Sub15 cachenode_sub15, int i, int i_54_, CacheNode_Sub15 cachenode_sub15_55_, int i_56_, int i_57_, int i_58_, int i_59_, boolean bool
   ) {
      ++anInt918;
      if (~i_56_ != 0) {
         this.method629();
         if (!this.NA()) {
            this.method632();
         } else {
            Class222 class222 = cachenode_sub15.aClass222Array9595[i_56_];
            Node_Sub40 node_sub40 = class222.aNode_Sub40_2634;
            Class222 class222_60_ = null;
            if (cachenode_sub15_55_ != null) {
               class222_60_ = cachenode_sub15_55_.aClass222Array9595[i_57_];
               if (class222_60_.aNode_Sub40_2634 != node_sub40) {
                  class222_60_ = null;
               }
            }

            this.method635(class222_60_, null, i, false, (byte)121, null, i_58_, i_54_, class222, node_sub40, 65535, bool);
            if (i_59_ > -23) {
               this.method620();
            }

            this.wa();
            this.method632();
         }
      }
   }

   abstract void H(int var1, int var2, int var3);

   abstract void method626(int var1, int var2, int var3, int var4);

   abstract void wa();

   abstract int da();

   abstract byte[] method627();

   abstract void a(int var1);

   abstract void v();

   abstract int ua();

   abstract boolean NA();

   abstract int na();

   abstract int G();

   final void method628(int i, int i_66_, int i_67_, int i_68_, int i_69_, int i_70_, int i_71_, Plane plane, int i_72_) {
      ++anInt916;
      if (i_68_ != -7024) {
         this.aBoolean914 = true;
      }

      int i_75_ = -i_69_ / 2;
      int i_76_ = -i_71_ / 2;
      int i_77_ = plane.getMedianHeightFromVertices(i_76_ + i_70_, -124, i_67_ - -i_75_);
      int i_78_ = i_69_ / 2;
      int i_79_ = -i_71_ / 2;
      int i_80_ = plane.getMedianHeightFromVertices(i_79_ + i_70_, i_68_ + 6908, i_67_ + i_78_);
      int i_81_ = -i_69_ / 2;
      int i_82_ = i_71_ / 2;
      int i_83_ = plane.getMedianHeightFromVertices(i_82_ + i_70_, i_68_ ^ 6942, i_81_ + i_67_);
      int i_84_ = i_69_ / 2;
      int i_85_ = i_71_ / 2;
      int i_86_ = plane.getMedianHeightFromVertices(i_85_ + i_70_, -121, i_67_ - -i_84_);
      int i_87_ = ~i_80_ < ~i_77_ ? i_77_ : i_80_;
      int i_88_ = ~i_86_ >= ~i_83_ ? i_86_ : i_83_;
      int i_89_ = i_80_ >= i_86_ ? i_86_ : i_80_;
      int i_90_ = i_83_ > i_77_ ? i_77_ : i_83_;
      if (i_71_ != 0) {
         int i_91_ = 16383 & (int)(2607.5945876176133 * Math.atan2((double)(i_87_ - i_88_), (double)i_71_));
         if (i_91_ != 0) {
            if (i_66_ != 0) {
               if (i_91_ > 8192) {
                  int i_92_ = 16384 - i_66_;
                  if (i_91_ < i_92_) {
                     i_91_ = i_92_;
                  }
               } else if (i_66_ < i_91_) {
                  i_91_ = i_66_;
               }
            }

            this.FA(i_91_);
         }
      }

      int i_93_ = i_77_ + i_86_;
      if (i_69_ != 0) {
         int i_94_ = (int)(2607.5945876176133 * Math.atan2((double)(i_90_ - i_89_), (double)i_69_)) & 16383;
         if (i_94_ != 0) {
            if (i_72_ != 0) {
               if (i_94_ > 8192) {
                  int i_95_ = 16384 + -i_72_;
                  if (i_95_ > i_94_) {
                     i_94_ = i_95_;
                  }
               } else if (i_94_ > i_72_) {
                  i_94_ = i_72_;
               }
            }

            this.VA(i_94_);
         }
      }

      if (i_93_ > i_80_ + i_83_) {
         i_93_ = i_83_ + i_80_;
      }

      i_93_ = (i_93_ >> 1) + -i;
      if (i_93_ != 0) {
         this.H(0, i_93_, 0);
      }
   }

   abstract void method629();

   abstract void ia(short var1, short var2);

   abstract int EA();

   abstract void method630(Class336 var1, int var2, boolean var3);

   final void method631(int i, int i_97_, CacheNode_Sub15 cachenode_sub15) {
      ++anInt915;
      if (~i != 0) {
         this.method629();
         if (!this.NA()) {
            this.method632();
         } else {
            Class222 class222 = cachenode_sub15.aClass222Array9595[i];
            Node_Sub40 node_sub40 = class222.aNode_Sub40_2634;

            for(int i_99_ = 0; class222.anInt2642 > i_99_; ++i_99_) {
               short s = class222.aShortArray2636[i_99_];
               if (node_sub40.aBooleanArray7502[s]) {
                  if (class222.aShortArray2635[i_99_] != -1) {
                     this.P(0, 0, 0, 0);
                  }

                  this.P(node_sub40.anIntArray7511[s], class222.aShortArray2648[i_99_], class222.aShortArray2649[i_99_], class222.aShortArray2643[i_99_]);
               }
            }

            this.wa();
            this.method632();
         }
      }
   }

   abstract void method632();

   abstract DrawableModel method633(byte var1, int var2, boolean var3);

   abstract void C(int var1);

   abstract void FA(int var1);

   abstract boolean r();

   final void method634(
      int i,
      CacheNode_Sub15 cachenode_sub15,
      CacheNode_Sub15 cachenode_sub15_100_,
      int i_101_,
      int i_102_,
      int[] is,
      byte b,
      int i_103_,
      boolean bool,
      int i_104_,
      int i_105_
   ) {
      ++anInt909;
      if (i_101_ != -1) {
         this.method629();
         if (!this.NA()) {
            this.method632();
         } else {
            if (b != -83) {
               this.method617();
            }

            Class222 class222 = cachenode_sub15.aClass222Array9595[i_101_];
            Node_Sub40 node_sub40 = class222.aNode_Sub40_2634;
            Class222 class222_106_ = null;
            if (cachenode_sub15_100_ != null) {
               class222_106_ = cachenode_sub15_100_.aClass222Array9595[i_104_];
               if (class222_106_.aNode_Sub40_2634 != node_sub40) {
                  class222_106_ = null;
               }
            }

            this.method635(class222_106_, null, i, false, (byte)84, is, i_102_, i_103_, class222, node_sub40, i_105_, bool);
            this.wa();
            this.method632();
         }
      }
   }

   private final void method635(
      Class222 class222,
      boolean[] bools,
      int i,
      boolean bool,
      byte b,
      int[] is,
      int i_107_,
      int i_108_,
      Class222 class222_109_,
      Node_Sub40 node_sub40,
      int i_110_,
      boolean bool_111_
   ) {
      ++anInt910;
      if (class222 != null && i != 0) {
         int i_114_ = 0;
         int i_115_ = 0;
         if (b > 65) {
            for(int i_116_ = 0; ~node_sub40.anInt7503 < ~i_116_; ++i_116_) {
               boolean bool_117_ = false;
               if (~class222_109_.anInt2642 < ~i_114_ && i_116_ == class222_109_.aShortArray2636[i_114_]) {
                  bool_117_ = true;
               }

               boolean bool_118_ = false;
               if (class222.anInt2642 > i_115_ && i_116_ == class222.aShortArray2636[i_115_]) {
                  bool_118_ = true;
               }

               if (bool_117_ || bool_118_) {
                  if (bools != null && !bools[i_116_] == bool && ~node_sub40.anIntArray7511[i_116_] != -1) {
                     if (bool_118_) {
                        ++i_115_;
                     }

                     if (bool_117_) {
                        ++i_114_;
                     }
                  } else {
                     int i_119_ = 0;
                     int i_120_ = node_sub40.anIntArray7511[i_116_];
                     if (i_120_ == 3 || i_120_ == 10) {
                        i_119_ = 128;
                     }

                     byte b_121_;
                     int i_122_;
                     int i_123_;
                     short s;
                     int i_124_;
                     if (bool_117_) {
                        i_122_ = class222_109_.aShortArray2643[i_114_];
                        s = class222_109_.aShortArray2635[i_114_];
                        i_124_ = class222_109_.aShortArray2649[i_114_];
                        i_123_ = class222_109_.aShortArray2648[i_114_];
                        b_121_ = class222_109_.aByteArray2641[i_114_];
                        ++i_114_;
                     } else {
                        b_121_ = 0;
                        i_122_ = i_119_;
                        i_123_ = i_119_;
                        s = -1;
                        i_124_ = i_119_;
                     }

                     int i_125_;
                     int i_126_;
                     byte b_127_;
                     short s_128_;
                     int i_129_;
                     if (bool_118_) {
                        i_129_ = class222.aShortArray2648[i_115_];
                        i_126_ = class222.aShortArray2643[i_115_];
                        b_127_ = class222.aByteArray2641[i_115_];
                        i_125_ = class222.aShortArray2649[i_115_];
                        s_128_ = class222.aShortArray2635[i_115_];
                        ++i_115_;
                     } else {
                        i_125_ = i_119_;
                        i_126_ = i_119_;
                        b_127_ = 0;
                        s_128_ = -1;
                        i_129_ = i_119_;
                     }

                     if (~s == 0) {
                        if (~s_128_ != 0) {
                           this.method613(
                              0, 0, i_110_ & node_sub40.anIntArray7510[s_128_], node_sub40.anIntArrayArray7499[s_128_], is, bool_111_, false, i_107_, 0, 0
                           );
                        }
                     } else {
                        this.method613(0, 0, i_110_ & node_sub40.anIntArray7510[s], node_sub40.anIntArrayArray7499[s], is, bool_111_, false, i_107_, 0, 0);
                     }

                     int i_130_;
                     int i_131_;
                     int i_132_;
                     if (~(b_121_ & 2) != -1 || (1 & b_127_) != 0) {
                        i_130_ = i_124_;
                        i_131_ = i_123_;
                        i_132_ = i_122_;
                     } else if (i_120_ == 2) {
                        int i_133_ = 16383 & -i_123_ + i_129_;
                        int i_134_ = -i_124_ + i_125_ & 16383;
                        int i_135_ = 16383 & i_126_ - i_122_;
                        if (i_133_ >= 8192) {
                           i_133_ -= 16384;
                        }

                        if (~i_134_ <= -8193) {
                           i_134_ -= 16384;
                        }

                        i_130_ = 16383 & i_124_ + i * i_134_ / i_108_;
                        i_131_ = i_133_ * i / i_108_ + i_123_ & 16383;
                        if (i_135_ >= 8192) {
                           i_135_ -= 16384;
                        }

                        i_132_ = i * i_135_ / i_108_ + i_122_ & 16383;
                     } else if (~i_120_ != -10) {
                        if (~i_120_ != -8) {
                           i_132_ = i_122_ + (i_126_ + -i_122_) * i / i_108_;
                           i_130_ = (i_125_ + -i_124_) * i / i_108_ + i_124_;
                           i_131_ = i * (-i_123_ + i_129_) / i_108_ + i_123_;
                        } else {
                           int i_136_ = 63 & -i_123_ + i_129_;
                           if (~i_136_ <= -33) {
                              i_136_ -= 64;
                           }

                           i_132_ = (-i_122_ + i_126_) * i / i_108_ + i_122_;
                           i_130_ = (i_125_ + -i_124_) * i / i_108_ + i_124_;
                           i_131_ = 63 & i_123_ - -(i * i_136_ / i_108_);
                        }
                     } else {
                        int i_137_ = 16383 & -i_123_ + i_129_;
                        if (i_137_ >= 8192) {
                           i_137_ -= 16384;
                        }

                        i_132_ = 0;
                        i_130_ = 0;
                        i_131_ = 16383 & i_123_ - -(i * i_137_ / i_108_);
                     }

                     this.method613(
                        i_132_,
                        i_120_,
                        node_sub40.anIntArray7510[i_116_] & i_110_,
                        node_sub40.anIntArrayArray7499[i_116_],
                        is,
                        bool_111_,
                        false,
                        i_107_,
                        i_131_,
                        i_130_
                     );
                  }
               }
            }
         }
      } else {
         for(int i_112_ = 0; ~class222_109_.anInt2642 < ~i_112_; ++i_112_) {
            short s = class222_109_.aShortArray2636[i_112_];
            if (bools == null || !bool != bools[s] || node_sub40.anIntArray7511[s] == 0) {
               short s_113_ = class222_109_.aShortArray2635[i_112_];
               if (~s_113_ != 0) {
                  this.method613(0, 0, i_110_ & node_sub40.anIntArray7510[s_113_], node_sub40.anIntArrayArray7499[s_113_], is, bool_111_, false, i_107_, 0, 0);
               }

               this.method613(
                  class222_109_.aShortArray2643[i_112_],
                  node_sub40.anIntArray7511[s],
                  i_110_ & node_sub40.anIntArray7510[s],
                  node_sub40.anIntArrayArray7499[s],
                  is,
                  bool_111_,
                  false,
                  i_107_,
                  class222_109_.aShortArray2648[i_112_],
                  class222_109_.aShortArray2649[i_112_]
               );
            }
         }
      }
   }

   abstract void method636(byte var1, byte[] var2);

   abstract int RA();

   abstract int fa();

   abstract void p(int var1, int var2, Plane var3, Plane var4, int var5, int var6, int var7);

   abstract int WA();

   abstract int ma();

   abstract void O(int var1, int var2, int var3);

   abstract int V();

   abstract void method637(int var1, int[] var2, int var3, int var4, int var5, int var6, boolean var7);

   static final void method638(int i, String[] strings, int[] is, int i_149_, int i_150_) {
      if (i != -20788) {
         aFrame907 = null;
      }

      if (i_150_ < i_149_) {
         int i_151_ = (i_150_ - -i_149_) / 2;
         int i_152_ = i_150_;
         String string = strings[i_151_];
         strings[i_151_] = strings[i_149_];
         strings[i_149_] = string;
         int i_153_ = is[i_151_];
         is[i_151_] = is[i_149_];
         is[i_149_] = i_153_;

         for(int i_154_ = i_150_; ~i_149_ < ~i_154_; ++i_154_) {
            if (string == null || strings[i_154_] != null && (i_154_ & 1) > strings[i_154_].compareTo(string)) {
               String string_155_ = strings[i_154_];
               strings[i_154_] = strings[i_152_];
               strings[i_152_] = string_155_;
               int i_156_ = is[i_154_];
               is[i_154_] = is[i_152_];
               is[i_152_++] = i_156_;
            }
         }

         strings[i_149_] = strings[i_152_];
         strings[i_152_] = string;
         is[i_149_] = is[i_152_];
         is[i_152_] = i_153_;
         method638(-20788, strings, is, i_152_ + -1, i_150_);
         method638(-20788, strings, is, i_149_, i_152_ - -1);
      }

      ++anInt917;
   }

   public DrawableModel() {
   }

   abstract void k(int var1);
}
