import java.util.Random;

public class Node_Sub38_Sub7 extends Node_Sub38 {
   private int anInt10140;
   private int anInt10141;
   static int anInt10142;
   static int[] anIntArray10143 = new int[]{0, 1, 2, 2, 1, 1, 2, 3, 1, 3, 3, 4, 2, 0, 4};
   static int anInt10144;
   private int anInt10145;
   private int anInt10146;
   private int anInt10147;
   private int anInt10148;
   private int anInt10149 = 2048;
   static int[] anIntArray10150;
   static int anInt10151;
   static int anInt10152;
   static int anInt10153 = 0;
   static int anInt10154;
   private int anInt10155;
   private int anInt10156;
   private int anInt10157;
   static int anInt10158;
   static int anInt10159;

   static final void method2805() {
      Node_Sub36_Sub3.aClass179_10058 = Node_Sub36_Sub3.aClass179_10062;
   }

   static final void method2806(byte b) {
      ++anInt10152;
      int i = 16 % ((b - 59) / 43);

      for(int i_0_ = 0; i_0_ < 100; ++i_0_) {
         r_Sub2.aClass253Array11063[i_0_] = null;
      }

      Class336_Sub2.anInt8581 = 0;
   }

   @Override
   final int[] method2775(int i, int i_1_) {
      ++anInt10159;
      int[] is = this.aClass146_7460.method1645(27356, i_1_);
      if (i <= 107) {
         method2811(true, -62, 43, true);
      }

      if (this.aClass146_7460.aBoolean1819) {
         int[][] is_2_ = this.aClass146_7460.method1642((byte)126);
         int i_3_ = 0;
         int i_4_ = 0;
         int i_5_ = 0;
         int i_6_ = 0;
         int i_7_ = 0;
         boolean bool = true;
         boolean bool_8_ = true;
         int i_9_ = 0;
         int i_10_ = 0;
         int i_11_ = Class339_Sub7.anInt8728 * this.anInt10155 >> 12;
         int i_12_ = this.anInt10149 * Class339_Sub7.anInt8728 >> 12;
         int i_13_ = Node_Sub38_Sub1.anInt10083 * this.anInt10156 >> 12;
         int i_14_ = this.anInt10146 * Node_Sub38_Sub1.anInt10083 >> 12;
         if (i_14_ <= 1) {
            return is_2_[i_1_];
         }

         this.anInt10148 = Class339_Sub7.anInt8728 / 8 * this.anInt10145 >> 12;
         int i_15_ = Class339_Sub7.anInt8728 / i_11_ + 1;
         int[][] is_16_ = new int[i_15_][3];
         int[][] is_17_ = new int[i_15_][3];
         Random random = new Random((long)this.anInt10147);

         while(true) {
            int i_18_ = i_11_ + Class330.method3838(-5208, i_12_ + -i_11_, random);
            int i_19_ = i_13_ + Class330.method3838(-5208, i_14_ + -i_13_, random);
            int i_20_ = i_6_ - -i_18_;
            if (i_20_ > Class339_Sub7.anInt8728) {
               i_18_ = -i_6_ + Class339_Sub7.anInt8728;
               i_20_ = Class339_Sub7.anInt8728;
            }

            int i_21_;
            if (bool_8_) {
               i_21_ = 0;
            } else {
               int i_22_ = i_7_;
               int[] is_23_ = is_17_[i_7_];
               int i_24_ = 0;
               int i_25_ = i_3_ + i_20_;
               if (i_25_ < 0) {
                  i_25_ += Class339_Sub7.anInt8728;
               }

               if (Class339_Sub7.anInt8728 < i_25_) {
                  i_25_ -= Class339_Sub7.anInt8728;
               }

               i_21_ = is_23_[2];

               while(true) {
                  int[] is_26_ = is_17_[i_22_];
                  if (~is_26_[0] >= ~i_25_ && is_26_[1] >= i_25_) {
                     if (~i_22_ != ~i_7_) {
                        int i_27_ = i_3_ + i_6_;
                        if (i_27_ < 0) {
                           i_27_ += Class339_Sub7.anInt8728;
                        }

                        if (Class339_Sub7.anInt8728 < i_27_) {
                           i_27_ -= Class339_Sub7.anInt8728;
                        }

                        for(int i_28_ = 1; ~i_24_ <= ~i_28_; ++i_28_) {
                           int[] is_29_ = is_17_[(i_28_ + i_7_) % i_9_];
                           i_21_ = Math.max(i_21_, is_29_[2]);
                        }

                        for(int i_30_ = 0; i_24_ >= i_30_; ++i_30_) {
                           int[] is_31_ = is_17_[(i_30_ + i_7_) % i_9_];
                           int i_32_ = is_31_[2];
                           if (~i_32_ != ~i_21_) {
                              int i_33_ = is_31_[0];
                              int i_34_ = is_31_[1];
                              int i_35_;
                              int i_36_;
                              if (i_27_ < i_25_) {
                                 i_35_ = Math.max(i_27_, i_33_);
                                 i_36_ = Math.min(i_25_, i_34_);
                              } else if (i_33_ == 0) {
                                 i_35_ = 0;
                                 i_36_ = Math.min(i_25_, i_34_);
                              } else {
                                 i_35_ = Math.max(i_27_, i_33_);
                                 i_36_ = Class339_Sub7.anInt8728;
                              }

                              this.method2807(is_2_, i_21_ + -i_32_, random, i_32_, i_5_ + i_35_, -i_35_ + i_36_, (byte)-58);
                           }
                        }
                     }

                     i_7_ = i_22_;
                     break;
                  }

                  ++i_24_;
                  if (~i_9_ >= ~(++i_22_)) {
                     i_22_ = 0;
                  }
               }
            }

            if (~(i_21_ - -i_19_) < ~Node_Sub38_Sub1.anInt10083) {
               i_19_ = -i_21_ + Node_Sub38_Sub1.anInt10083;
            } else {
               bool = false;
            }

            if (~i_20_ == ~Class339_Sub7.anInt8728) {
               this.method2807(is_2_, i_19_, random, i_21_, i_4_ + i_6_, i_18_, (byte)-58);
               if (bool) {
                  break;
               }

               bool = true;
               int[] is_37_ = is_16_[i_10_++];
               is_37_[1] = i_20_;
               is_37_[2] = i_19_ + i_21_;
               is_37_[0] = i_6_;
               int[][] is_38_ = is_17_;
               is_17_ = is_16_;
               i_9_ = i_10_;
               is_16_ = is_38_;
               i_10_ = 0;
               i_5_ = i_4_;
               i_4_ = Class330.method3838(-5208, Class339_Sub7.anInt8728, random);
               i_3_ = -i_5_ + i_4_;
               i_6_ = 0;
               int i_39_ = i_3_;
               if (~i_3_ > -1) {
                  i_39_ = i_3_ + Class339_Sub7.anInt8728;
               }

               if (Class339_Sub7.anInt8728 < i_39_) {
                  i_39_ -= Class339_Sub7.anInt8728;
               }

               i_7_ = 0;

               while(true) {
                  int[] is_40_ = is_17_[i_7_];
                  if (i_39_ >= is_40_[0] && ~i_39_ >= ~is_40_[1]) {
                     bool_8_ = false;
                     break;
                  }

                  if (~(++i_7_) <= ~i_9_) {
                     i_7_ = 0;
                  }
               }
            } else {
               int[] is_41_ = is_16_[i_10_++];
               is_41_[2] = i_19_ + i_21_;
               is_41_[1] = i_20_;
               is_41_[0] = i_6_;
               this.method2807(is_2_, i_19_, random, i_21_, i_6_ + i_4_, i_18_, (byte)-58);
               i_6_ = i_20_;
            }
         }
      }

      return is;
   }

   @Override
   final void method2785(int i) {
      if (i != 7) {
         this.method2807(null, 27, null, 76, -2, -58, (byte)89);
      }

      ++anInt10142;
   }

   private final void method2807(int[][] is, int i, Random random, int i_42_, int i_43_, int i_44_, byte b) {
      ++anInt10158;
      int i_45_ = this.anInt10157 <= 0 ? 4096 : -Class330.method3838(b + -5150, this.anInt10157, random) + 4096;
      int i_46_ = this.anInt10141 * this.anInt10148 >> 12;
      int i_47_ = this.anInt10148 + -(~i_46_ >= -1 ? 0 : Class330.method3838(b ^ 5230, i_46_, random));
      if (Class339_Sub7.anInt8728 <= i_43_) {
         i_43_ -= Class339_Sub7.anInt8728;
      }

      if (b == -58) {
         if (~i_47_ >= -1) {
            if (~Class339_Sub7.anInt8728 > ~(i_44_ + i_43_)) {
               int i_48_ = -i_43_ + Class339_Sub7.anInt8728;

               for(int i_49_ = 0; i_49_ < i; ++i_49_) {
                  int[] is_50_ = is[i_49_ + i_42_];
                  Class311.method3604(is_50_, i_43_, i_48_, i_45_);
                  Class311.method3604(is_50_, 0, -i_48_ + i_44_, i_45_);
               }
            } else {
               for(int i_51_ = 0; i > i_51_; ++i_51_) {
                  Class311.method3604(is[i_51_ + i_42_], i_43_, i_44_, i_45_);
               }
            }
         } else if (~i < -1 && i_44_ > 0) {
            int i_52_ = i_44_ / 2;
            int i_53_ = i / 2;
            int i_54_ = ~i_47_ < ~i_52_ ? i_52_ : i_47_;
            int i_55_ = ~i_53_ <= ~i_47_ ? i_47_ : i_53_;
            int i_56_ = i_54_ + i_43_;
            int i_57_ = i_44_ + -(i_54_ * 2);

            for(int i_58_ = 0; i > i_58_; ++i_58_) {
               int[] is_59_ = is[i_42_ + i_58_];
               if (~i_58_ > ~i_55_) {
                  int i_60_ = i_45_ * i_58_ / i_55_;
                  if (this.anInt10140 == 0) {
                     for(int i_61_ = 0; i_54_ > i_61_; ++i_61_) {
                        int i_62_ = i_61_ * i_45_ / i_54_;
                        is_59_[Node_Sub30.method2723(i_61_ + i_43_, Class303.anInt3824)] = is_59_[Node_Sub30.method2723(
                           Class303.anInt3824, i_44_ + i_43_ - i_61_ - 1
                        )] = i_62_ * i_60_ >> 12;
                     }
                  } else {
                     for(int i_63_ = 0; i_54_ > i_63_; ++i_63_) {
                        int i_64_ = i_63_ * i_45_ / i_54_;
                        is_59_[Node_Sub30.method2723(Class303.anInt3824, i_63_ + i_43_)] = is_59_[Node_Sub30.method2723(
                           Class303.anInt3824, -i_63_ + i_43_ - (-i_44_ - -1)
                        )] = i_60_ > i_64_ ? i_64_ : i_60_;
                     }
                  }

                  if (Class339_Sub7.anInt8728 < i_56_ - -i_57_) {
                     int i_65_ = -i_56_ + Class339_Sub7.anInt8728;
                     Class311.method3604(is_59_, i_56_, i_65_, i_60_);
                     Class311.method3604(is_59_, 0, -i_65_ + i_57_, i_60_);
                  } else {
                     Class311.method3604(is_59_, i_56_, i_57_, i_60_);
                  }
               } else {
                  int i_66_ = i - i_58_ - 1;
                  if (~i_66_ > ~i_55_) {
                     int i_67_ = i_66_ * i_45_ / i_55_;
                     if (this.anInt10140 != 0) {
                        for(int i_68_ = 0; ~i_54_ < ~i_68_; ++i_68_) {
                           int i_69_ = i_68_ * i_45_ / i_54_;
                           is_59_[Node_Sub30.method2723(Class303.anInt3824, i_43_ + i_68_)] = is_59_[Node_Sub30.method2723(
                              i_43_ + i_44_ + -i_68_ + -1, Class303.anInt3824
                           )] = i_67_ > i_69_ ? i_69_ : i_67_;
                        }
                     } else {
                        for(int i_70_ = 0; i_70_ < i_54_; ++i_70_) {
                           int i_71_ = i_45_ * i_70_ / i_54_;
                           is_59_[Node_Sub30.method2723(i_43_ - -i_70_, Class303.anInt3824)] = is_59_[Node_Sub30.method2723(
                              -1 + -i_70_ + i_44_ + i_43_, Class303.anInt3824
                           )] = i_67_ * i_71_ >> 12;
                        }
                     }

                     if (Class339_Sub7.anInt8728 >= i_57_ + i_56_) {
                        Class311.method3604(is_59_, i_56_, i_57_, i_67_);
                     } else {
                        int i_72_ = Class339_Sub7.anInt8728 - i_56_;
                        Class311.method3604(is_59_, i_56_, i_72_, i_67_);
                        Class311.method3604(is_59_, 0, -i_72_ + i_57_, i_67_);
                     }
                  } else {
                     for(int i_73_ = 0; ~i_73_ > ~i_54_; ++i_73_) {
                        is_59_[Node_Sub30.method2723(Class303.anInt3824, i_43_ - -i_73_)] = is_59_[Node_Sub30.method2723(
                           Class303.anInt3824, -1 + -i_73_ + i_44_ + i_43_
                        )] = i_73_ * i_45_ / i_54_;
                     }

                     if (~Class339_Sub7.anInt8728 <= ~(i_56_ + i_57_)) {
                        Class311.method3604(is_59_, i_56_, i_57_, i_45_);
                     } else {
                        int i_74_ = Class339_Sub7.anInt8728 + -i_56_;
                        Class311.method3604(is_59_, i_56_, i_74_, i_45_);
                        Class311.method3604(is_59_, 0, -i_74_ + i_57_, i_45_);
                     }
                  }
               }
            }
         }
      }
   }

   public Node_Sub38_Sub7() {
      super(0, true);
      this.anInt10145 = 1024;
      this.anInt10140 = 0;
      this.anInt10146 = 819;
      this.anInt10147 = 0;
      this.anInt10141 = 1024;
      this.anInt10155 = 1024;
      this.anInt10156 = 409;
      this.anInt10157 = 1024;
   }

   public static void method2808(byte b) {
      anIntArray10143 = null;
      if (b == 24) {
         anIntArray10150 = null;
      }
   }

   static final int getTileMedianHeight(int plane, int junk, int y, int x) {
      if (junk != -29754) {
         method2810(null, false);
      }

      ++anInt10151;
      if (Class320_Sub10.aPlaneArray8300 != null && Class320_Sub10.aPlaneArray8300[plane] != null) {
         int localX = x >> 9;
         int localY = y >> 9;
         return ~localX <= -1 && ~localY <= -1 && -1 + Node_Sub54.GAME_SCENE_WDITH >= localX && Class377_Sub1.GAME_SCENE_HEIGHT + -1 >= localY
            ? Class320_Sub10.aPlaneArray8300[plane].getMedianHeightFromVertices(y, -121, x)
            : 0;
      } else {
         return 0;
      }
   }

   static final boolean method2810(Mobile mobile, boolean bool) {
      boolean bool_81_ = Class320_Sub10.aPlaneArray8300 == Class368.aPlaneArray4548;
      int i = 0;
      short s = 0;
      byte b = 0;
      mobile.method845(86);
      if (mobile.aShort9119 >= 0 && mobile.aShort9120 >= 0 && mobile.aShort9130 < Class328.SCENE_WIDTH_X && mobile.aShort9124 < Node_Sub50.SCENE_WIDTH_Y) {
         short s_82_ = 0;

         for(int i_83_ = mobile.aShort9119; i_83_ <= mobile.aShort9130; ++i_83_) {
            for(int i_84_ = mobile.aShort9120; i_84_ <= mobile.aShort9124; ++i_84_) {
               Class261 class261 = Node_Sub15_Sub6.method2572(mobile.plane, i_83_, i_84_);
               if (class261 != null) {
                  Class256 class256 = Animator.method231(false, mobile);
                  Class256 class256_85_ = class261.aClass256_3312;
                  if (class256_85_ == null) {
                     class261.aClass256_3312 = class256;
                  } else {
                     while(class256_85_.aClass256_3238 != null) {
                        class256_85_ = class256_85_.aClass256_3238;
                     }

                     class256_85_.aClass256_3238 = class256;
                  }

                  if (bool_81_ && (Player.anIntArrayArray11128[i_83_][i_84_] & 0xFF000000) != 0) {
                     i = Player.anIntArrayArray11128[i_83_][i_84_];
                     s = Class146.aShortArrayArray1802[i_83_][i_84_];
                     b = Class320_Sub18.aByteArrayArray8379[i_83_][i_84_];
                  }

                  if (!bool && class261.anAnimable_Sub1_3317 != null && class261.anAnimable_Sub1_3317.aShort9102 > s_82_) {
                     s_82_ = class261.anAnimable_Sub1_3317.aShort9102;
                  }
               }
            }
         }

         if (bool_81_ && (i & 0xFF000000) != 0) {
            for(int i_86_ = mobile.aShort9119; i_86_ <= mobile.aShort9130; ++i_86_) {
               for(int i_87_ = mobile.aShort9120; i_87_ <= mobile.aShort9124; ++i_87_) {
                  if ((Player.anIntArrayArray11128[i_86_][i_87_] & 0xFF000000) == 0) {
                     Player.anIntArrayArray11128[i_86_][i_87_] = i;
                     Class146.aShortArrayArray1802[i_86_][i_87_] = s;
                     Class320_Sub18.aByteArrayArray8379[i_86_][i_87_] = b;
                  }
               }
            }
         }

         if (bool) {
            Node_Sub52.aMobileArray7648[Class63.anInt923++] = mobile;
         } else {
            int i_88_ = Class320_Sub10.aPlaneArray8300 == Class368.aPlaneArray4548 ? 1 : 0;
            if (mobile.method814((byte)-59)) {
               if (mobile.method813(0)) {
                  mobile.anAnimable5941 = SeekableFile.anAnimableArray3884[i_88_];
                  SeekableFile.anAnimableArray3884[i_88_] = mobile;
               } else {
                  mobile.anAnimable5941 = Class303.anAnimableArray3827[i_88_];
                  Class303.anAnimableArray3827[i_88_] = mobile;
                  Class194_Sub1.aBoolean6892 = true;
               }
            } else {
               mobile.anAnimable5941 = Node_Sub36.anAnimableArray7429[i_88_];
               Node_Sub36.anAnimableArray7429[i_88_] = mobile;
            }
         }

         if (bool) {
            mobile.anInt5937 -= s_82_;
         }

         return true;
      } else {
         return false;
      }
   }

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      if (bool) {
         this.method2775(39, 29);
      }

      ++anInt10144;
      if (i != 0) {
         if (i != 1) {
            if (i != 2) {
               if (~i != -4) {
                  if (~i != -5) {
                     if (~i != -6) {
                        if (~i != -7) {
                           if (i != 7) {
                              if (~i == -9) {
                                 this.anInt10157 = buffer.readUnsignedShort();
                              }
                           } else {
                              this.anInt10141 = buffer.readUnsignedShort();
                           }
                        } else {
                           this.anInt10140 = buffer.readUnsignedByte();
                        }
                     } else {
                        this.anInt10145 = buffer.readUnsignedShort();
                     }
                  } else {
                     this.anInt10146 = buffer.readUnsignedShort();
                  }
               } else {
                  this.anInt10156 = buffer.readUnsignedShort();
               }
            } else {
               this.anInt10149 = buffer.readUnsignedShort();
            }
         } else {
            this.anInt10155 = buffer.readUnsignedShort();
         }
      } else {
         this.anInt10147 = buffer.readUnsignedByte();
      }
   }

   static final String method2811(boolean bool, int i, int i_90_, boolean bool_91_) {
      ++anInt10154;
      if (i_90_ >= 2 && ~i_90_ >= -37) {
         if (bool_91_ && i >= 0) {
            if (bool) {
               getTileMedianHeight(21, 69, -79, 83);
            }

            int i_92_ = 2;

            for(int i_93_ = i / i_90_; i_93_ != 0; i_93_ /= i_90_) {
               ++i_92_;
            }

            char[] cs = new char[i_92_];
            cs[0] = '+';

            for(int i_94_ = i_92_ + -1; i_94_ > 0; --i_94_) {
               int i_95_ = i;
               i /= i_90_;
               int i_96_ = -(i * i_90_) + i_95_;
               if (i_96_ < 10) {
                  cs[i_94_] = (char)(48 + i_96_);
               } else {
                  cs[i_94_] = (char)(87 + i_96_);
               }
            }

            return new String(cs);
         } else {
            return Integer.toString(i, i_90_);
         }
      } else {
         throw new IllegalArgumentException("Invalid radix:" + i_90_);
      }
   }
}
