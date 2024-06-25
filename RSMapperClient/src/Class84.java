public class Class84 {
   static int anInt1129;
   static int anInt1130;
   static int anInt1131;
   static int anInt1132;
   protected int anInt1133;
   static int anInt1134;
   protected int anInt1135;
   static int[] anIntArray1136 = new int[13];
   static int anInt1137;
   protected int[][] clipMasks;
   protected int anInt1139;
   static int anInt1140;
   static int anInt1141;
   static int anInt1142;
   static int anInt1143;
   static Class61 aClass61_1144 = new Class61(64);
   static int anInt1145;
   protected int anInt1146;
   static int[] anIntArray1147 = new int[2];
   static String aString1148 = null;
   static int anInt1149;
   static int anInt1150;
   static int anInt1151;
   static int anInt1152;
   static int anInt1153;

   public static void method981(byte b) {
      aString1148 = null;
      aClass61_1144 = null;
      anIntArray1136 = null;
      int i = -5 % ((12 - b) / 36);
      anIntArray1147 = null;
   }

   final boolean method982(int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, int i_5_, int i_6_) {
      ++anInt1152;
      if (~i_6_ == -2) {
         if (i_2_ == i && i_5_ == i_3_) {
            return true;
         }
      } else if (~i_2_ <= ~i && -1 + i_6_ + i >= i_2_ && i_3_ <= i_3_ && i_3_ <= -1 + i_6_ + i_3_) {
         return true;
      }

      i_3_ -= this.anInt1135;
      i_5_ -= this.anInt1135;
      i -= this.anInt1139;
      i_2_ -= this.anInt1139;
      if (i_6_ == 1) {
         if (~i_1_ == -7 || i_1_ == 7) {
            if (i_1_ == 7) {
               i_4_ = 3 & i_4_ - -2;
            }

            if (~i_4_ == -1) {
               if (~(1 + i_2_) == ~i && ~i_3_ == ~i_5_ && (128 & this.clipMasks[i][i_5_]) == 0) {
                  return true;
               }

               if (~i == ~i_2_ && i_5_ == -1 + i_3_ && ~(2 & this.clipMasks[i][i_5_]) == -1) {
                  return true;
               }
            } else if (i_4_ == 1) {
               if (i == -1 + i_2_ && ~i_3_ == ~i_5_ && ~(this.clipMasks[i][i_5_] & 8) == -1) {
                  return true;
               }

               if (i_2_ == i && ~(-1 + i_3_) == ~i_5_ && ~(this.clipMasks[i][i_5_] & 2) == -1) {
                  return true;
               }
            } else if (~i_4_ == -3) {
               if (~(i_2_ - 1) == ~i && ~i_5_ == ~i_3_ && ~(this.clipMasks[i][i_5_] & 8) == -1) {
                  return true;
               }

               if (i_2_ == i && i_5_ == 1 + i_3_ && (32 & this.clipMasks[i][i_5_]) == 0) {
                  return true;
               }
            } else if (i_4_ == 3) {
               if (~i == ~(1 + i_2_) && ~i_3_ == ~i_5_ && ~(this.clipMasks[i][i_5_] & 128) == -1) {
                  return true;
               }

               if (i_2_ == i && ~(1 + i_3_) == ~i_5_ && ~(32 & this.clipMasks[i][i_5_]) == -1) {
                  return true;
               }
            }
         }

         if (~i_1_ == -9) {
            if (i_2_ == i && ~(1 + i_3_) == ~i_5_ && ~(32 & this.clipMasks[i][i_5_]) == -1) {
               return true;
            }

            if (~i_2_ == ~i && i_3_ + -1 == i_5_ && ~(this.clipMasks[i][i_5_] & 2) == -1) {
               return true;
            }

            if (~(i_2_ + -1) == ~i && ~i_5_ == ~i_3_ && ~(8 & this.clipMasks[i][i_5_]) == -1) {
               return true;
            }

            if (~i == ~(i_2_ - -1) && i_3_ == i_5_ && (128 & this.clipMasks[i][i_5_]) == 0) {
               return true;
            }
         }
      } else {
         int i_7_ = i_6_ + i - 1;
         int i_8_ = -1 + i_5_ + i_6_;
         if (i_1_ == 6 || i_1_ == 7) {
            if (~i_1_ == -8) {
               i_4_ = i_4_ + 2 & 3;
            }

            if (i_4_ != 0) {
               if (~i_4_ == -2) {
                  if (i == i_2_ - i_6_ && ~i_5_ >= ~i_3_ && i_3_ <= i_8_ && ~(this.clipMasks[i_7_][i_3_] & 8) == -1) {
                     return true;
                  }

                  if (~i_2_ <= ~i && i_2_ <= i_7_ && i_5_ == -i_6_ + i_3_ && (this.clipMasks[i_2_][i_8_] & 2) == 0) {
                     return true;
                  }
               } else if (i_4_ != 2) {
                  if (i_4_ == 3) {
                     if (~(i_2_ - -1) == ~i && ~i_3_ <= ~i_5_ && i_3_ <= i_8_ && ~(128 & this.clipMasks[i][i_3_]) == -1) {
                        return true;
                     }

                     if (i_2_ >= i && ~i_2_ >= ~i_7_ && i_5_ == i_3_ + 1 && ~(this.clipMasks[i_2_][i_5_] & 32) == -1) {
                        return true;
                     }
                  }
               } else {
                  if (-i_6_ + i_2_ == i && ~i_5_ >= ~i_3_ && i_3_ <= i_8_ && ~(this.clipMasks[i_7_][i_3_] & 8) == -1) {
                     return true;
                  }

                  if (~i >= ~i_2_ && ~i_2_ >= ~i_7_ && ~i_5_ == ~(1 + i_3_) && ~(32 & this.clipMasks[i_2_][i_5_]) == -1) {
                     return true;
                  }
               }
            } else {
               if (i == i_2_ + 1 && i_5_ <= i_3_ && ~i_8_ <= ~i_3_ && ~(128 & this.clipMasks[i][i_3_]) == -1) {
                  return true;
               }

               if (~i >= ~i_2_ && i_2_ <= i_7_ && ~(i_3_ + -i_6_) == ~i_5_ && (2 & this.clipMasks[i_2_][i_8_]) == 0) {
                  return true;
               }
            }
         }

         if (~i_1_ == -9) {
            if (~i_2_ <= ~i && ~i_2_ >= ~i_7_ && ~(1 + i_3_) == ~i_5_ && ~(32 & this.clipMasks[i_2_][i_5_]) == -1) {
               return true;
            }

            if (~i >= ~i_2_ && i_2_ <= i_7_ && i_5_ == -i_6_ + i_3_ && ~(2 & this.clipMasks[i_2_][i_8_]) == -1) {
               return true;
            }

            if (i == i_2_ + -i_6_ && ~i_3_ <= ~i_5_ && i_3_ <= i_8_ && ~(this.clipMasks[i_7_][i_3_] & 8) == -1) {
               return true;
            }

            if (i == 1 + i_2_ && ~i_3_ <= ~i_5_ && ~i_8_ <= ~i_3_ && (128 & this.clipMasks[i][i_3_]) == 0) {
               return true;
            }
         }
      }

      if (i_0_ != 25451) {
         this.method991(-108);
      }

      return false;
   }

   private final void method983(int i, int i_9_, int i_10_, boolean bool) {
      this.clipMasks[i_10_][i] = Node_Sub30.method2723(this.clipMasks[i_10_][i], ~i_9_);
      ++anInt1130;
      if (!bool) {
         aClass61_1144 = null;
      }
   }

   final boolean method984(int i, int i_11_, byte b, int i_12_, int i_13_, int i_14_, int i_15_, int i_16_, int i_17_, int i_18_) {
      ++anInt1145;
      int i_19_ = i + i_13_;
      int i_20_ = i_12_ + i_17_;
      int i_21_ = 44 % ((b - -7) / 60);
      int i_22_ = i_18_ + i_14_;
      int i_23_ = i_16_ + i_11_;
      if (i_13_ == i_22_ && (2 & i_15_) == 0) {
         int i_30_ = i_11_ < i_17_ ? i_17_ : i_11_;

         for(int i_31_ = ~i_20_ <= ~i_23_ ? i_23_ : i_20_; i_30_ < i_31_; ++i_30_) {
            if ((this.clipMasks[i_22_ + -1 + -this.anInt1139][-this.anInt1135 + i_30_] & 8) == 0) {
               return true;
            }
         }
      } else if (~i_14_ == ~i_19_ && ~(i_15_ & 8) == -1) {
         int i_28_ = i_17_ <= i_11_ ? i_11_ : i_17_;

         for(int i_29_ = ~i_20_ <= ~i_23_ ? i_23_ : i_20_; ~i_29_ < ~i_28_; ++i_28_) {
            if ((128 & this.clipMasks[i_14_ - this.anInt1139][i_28_ + -this.anInt1135]) == 0) {
               return true;
            }
         }
      } else if (i_23_ == i_17_ && (1 & i_15_) == 0) {
         int i_24_ = i_13_ <= i_14_ ? i_14_ : i_13_;

         for(int i_25_ = i_22_ <= i_19_ ? i_22_ : i_19_; i_24_ < i_25_; ++i_24_) {
            if ((this.clipMasks[-this.anInt1139 + i_24_][-this.anInt1135 + i_23_ - 1] & 2) == 0) {
               return true;
            }
         }
      } else if (i_20_ == i_11_ && ~(4 & i_15_) == -1) {
         int i_26_ = ~i_14_ > ~i_13_ ? i_13_ : i_14_;

         for(int i_27_ = ~i_22_ >= ~i_19_ ? i_22_ : i_19_; ~i_27_ < ~i_26_; ++i_26_) {
            if ((32 & this.clipMasks[-this.anInt1139 + i_26_][i_11_ - this.anInt1135]) == 0) {
               return true;
            }
         }
      }

      return false;
   }

   static final void method985(int i, Class343 class343, int i_32_) {
      ++anInt1132;
      if (Class320_Sub27.aBoolean8465) {
         i = 0;
         Class320_Sub27.aBoolean8465 = false;
      }

      if (Class20_Sub1.aClass343_5509 == null || !Class20_Sub1.aClass343_5509.method3968((byte)97, class343)) {
         Class20_Sub1.aClass343_5509 = class343;
         Class181.aLong2157 = Class313.method3650(false);
         Class290_Sub4.anInt8100 = i;
         Class312.anInt3955 = i;
         if (~Class312.anInt3955 != -1) {
            Class44.aClass119_670 = Class245.aClass119_3085;
            WorldItem.aFloat11014 = Animable.aFloat5932;
            Class357.aFloat4439 = Class363.aFloat4502;
            Class188_Sub2_Sub2.anInt9360 = Class320_Sub20.anInt8402;
            Class113.aFloat1439 = Class39.aFloat580;
            Class44.aClass270_669 = Class229.aClass270_2733;
            Class284.aFloat3597 = Class69.aFloat944;
            Class191.anInt2353 = Class138.anInt1726;
            CacheNode_Sub17.aFloat8847 = CacheNode_Sub16_Sub2.aFloat11082;
            Class329.aFloat4117 = Node_Sub25.aFloat7236;
            Node_Sub52.anInt7644 = Node_Sub12.anInt5455;
            if (Class245.aClass119_3085 != null) {
               if (Class245.aClass119_3085.method1222((byte)105)) {
                  Class44.aClass119_670 = Class245.aClass119_3085.method1224((byte)58);
                  Class245.aClass119_3085 = Class44.aClass119_670;
               }

               if (Class245.aClass119_3085 != null && Class20_Sub1.aClass343_5509.aClass119_4238 != Class245.aClass119_3085) {
                  Class245.aClass119_3085.method1220((byte)-35, Class20_Sub1.aClass343_5509.aClass119_4238);
               }
            }
         } else {
            CacheNode_Sub14.method2349((byte)5);
         }
      }

      if (i_32_ != 1) {
         method985(9, null, -91);
      }
   }

   final void method986(int i, boolean bool, boolean bool_33_, int i_34_, int i_35_, int i_36_, int i_37_) {
      ++anInt1129;
      i_34_ -= this.anInt1135;
      i_37_ -= this.anInt1139;
      int i_38_ = -91 % ((i - 3) / 34);
      if (~i_36_ == -1) {
         if (i_35_ == 0) {
            this.method995(i_37_, i_34_, 128, 94);
            this.method995(-1 + i_37_, i_34_, 8, -104);
         }

         if (~i_35_ == -2) {
            this.method995(i_37_, i_34_, 2, 98);
            this.method995(i_37_, i_34_ - -1, 32, 124);
         }

         if (~i_35_ == -3) {
            this.method995(i_37_, i_34_, 8, -124);
            this.method995(1 + i_37_, i_34_, 128, -121);
         }

         if (i_35_ == 3) {
            this.method995(i_37_, i_34_, 32, -102);
            this.method995(i_37_, i_34_ - 1, 2, 5);
         }
      }

      if (i_36_ == 1 || ~i_36_ == -4) {
         if (~i_35_ == -1) {
            this.method995(i_37_, i_34_, 1, -5);
            this.method995(i_37_ - 1, i_34_ - -1, 16, 64);
         }

         if (i_35_ == 1) {
            this.method995(i_37_, i_34_, 4, 3);
            this.method995(i_37_ + 1, 1 + i_34_, 64, -112);
         }

         if (~i_35_ == -3) {
            this.method995(i_37_, i_34_, 16, 106);
            this.method995(i_37_ + 1, -1 + i_34_, 1, 63);
         }

         if (i_35_ == 3) {
            this.method995(i_37_, i_34_, 64, -103);
            this.method995(-1 + i_37_, -1 + i_34_, 4, 38);
         }
      }

      if (i_36_ == 2) {
         if (~i_35_ == -1) {
            this.method995(i_37_, i_34_, 130, -116);
            this.method995(i_37_ - 1, i_34_, 8, 112);
            this.method995(i_37_, 1 + i_34_, 32, -99);
         }

         if (i_35_ == 1) {
            this.method995(i_37_, i_34_, 10, -126);
            this.method995(i_37_, i_34_ + 1, 32, -120);
            this.method995(i_37_ + 1, i_34_, 128, -106);
         }

         if (~i_35_ == -3) {
            this.method995(i_37_, i_34_, 40, -124);
            this.method995(i_37_ + 1, i_34_, 128, 9);
            this.method995(i_37_, i_34_ + -1, 2, 60);
         }

         if (i_35_ == 3) {
            this.method995(i_37_, i_34_, 160, 73);
            this.method995(i_37_, -1 + i_34_, 2, 39);
            this.method995(i_37_ - 1, i_34_, 8, -127);
         }
      }

      if (bool) {
         if (~i_36_ == -1) {
            if (i_35_ == 0) {
               this.method995(i_37_, i_34_, 65536, -105);
               this.method995(-1 + i_37_, i_34_, 4096, -10);
            }

            if (~i_35_ == -2) {
               this.method995(i_37_, i_34_, 1024, -115);
               this.method995(i_37_, i_34_ + 1, 16384, 26);
            }

            if (~i_35_ == -3) {
               this.method995(i_37_, i_34_, 4096, -110);
               this.method995(1 + i_37_, i_34_, 65536, -124);
            }

            if (~i_35_ == -4) {
               this.method995(i_37_, i_34_, 16384, -119);
               this.method995(i_37_, i_34_ + -1, 1024, 121);
            }
         }

         if (~i_36_ == -2 || i_36_ == 3) {
            if (i_35_ == 0) {
               this.method995(i_37_, i_34_, 512, 60);
               this.method995(i_37_ - 1, i_34_ + 1, 8192, -104);
            }

            if (~i_35_ == -2) {
               this.method995(i_37_, i_34_, 2048, 51);
               this.method995(i_37_ - -1, 1 + i_34_, 32768, 84);
            }

            if (~i_35_ == -3) {
               this.method995(i_37_, i_34_, 8192, -122);
               this.method995(1 + i_37_, i_34_ + -1, 512, -118);
            }

            if (i_35_ == 3) {
               this.method995(i_37_, i_34_, 32768, -99);
               this.method995(i_37_ - 1, -1 + i_34_, 2048, -104);
            }
         }

         if (~i_36_ == -3) {
            if (i_35_ == 0) {
               this.method995(i_37_, i_34_, 66560, 63);
               this.method995(-1 + i_37_, i_34_, 4096, 2);
               this.method995(i_37_, i_34_ - -1, 16384, 56);
            }

            if (~i_35_ == -2) {
               this.method995(i_37_, i_34_, 5120, -116);
               this.method995(i_37_, 1 + i_34_, 16384, -99);
               this.method995(1 + i_37_, i_34_, 65536, -127);
            }

            if (i_35_ == 2) {
               this.method995(i_37_, i_34_, 20480, -127);
               this.method995(1 + i_37_, i_34_, 65536, 6);
               this.method995(i_37_, -1 + i_34_, 1024, 10);
            }

            if (i_35_ == 3) {
               this.method995(i_37_, i_34_, 81920, 13);
               this.method995(i_37_, -1 + i_34_, 1024, 66);
               this.method995(-1 + i_37_, i_34_, 4096, -120);
            }
         }
      }

      if (bool_33_) {
         if (i_36_ == 0) {
            if (~i_35_ == -1) {
               this.method995(i_37_, i_34_, 536870912, 30);
               this.method995(i_37_ - 1, i_34_, 33554432, 115);
            }

            if (~i_35_ == -2) {
               this.method995(i_37_, i_34_, 8388608, -118);
               this.method995(i_37_, 1 + i_34_, 134217728, -1);
            }

            if (i_35_ == 2) {
               this.method995(i_37_, i_34_, 33554432, -102);
               this.method995(i_37_ + 1, i_34_, 536870912, -111);
            }

            if (i_35_ == 3) {
               this.method995(i_37_, i_34_, 134217728, -127);
               this.method995(i_37_, i_34_ + -1, 8388608, 34);
            }
         }

         if (i_36_ == 1 || ~i_36_ == -4) {
            if (i_35_ == 0) {
               this.method995(i_37_, i_34_, 4194304, -121);
               this.method995(-1 + i_37_, i_34_ + 1, 67108864, 74);
            }

            if (~i_35_ == -2) {
               this.method995(i_37_, i_34_, 16777216, -109);
               this.method995(1 + i_37_, i_34_ - -1, 268435456, 104);
            }

            if (~i_35_ == -3) {
               this.method995(i_37_, i_34_, 67108864, 31);
               this.method995(i_37_ - -1, -1 + i_34_, 4194304, -109);
            }

            if (i_35_ == 3) {
               this.method995(i_37_, i_34_, 268435456, 62);
               this.method995(i_37_ - 1, i_34_ + -1, 16777216, -102);
            }
         }

         if (~i_36_ == -3) {
            if (i_35_ == 0) {
               this.method995(i_37_, i_34_, 545259520, -99);
               this.method995(-1 + i_37_, i_34_, 33554432, -107);
               this.method995(i_37_, i_34_ + 1, 134217728, 35);
            }

            if (i_35_ == 1) {
               this.method995(i_37_, i_34_, 41943040, 101);
               this.method995(i_37_, 1 + i_34_, 134217728, -123);
               this.method995(i_37_ - -1, i_34_, 536870912, -109);
            }

            if (~i_35_ == -3) {
               this.method995(i_37_, i_34_, 167772160, 6);
               this.method995(i_37_ - -1, i_34_, 536870912, 35);
               this.method995(i_37_, -1 + i_34_, 8388608, 24);
            }

            if (i_35_ == 3) {
               this.method995(i_37_, i_34_, 671088640, 15);
               this.method995(i_37_, i_34_ + -1, 8388608, -121);
               this.method995(-1 + i_37_, i_34_, 33554432, 66);
            }
         }
      }
   }

   final void method987(int i, int i_39_, int i_40_, byte b, boolean bool, int i_41_, boolean bool_42_) {
      i_41_ -= this.anInt1139;
      int i_43_ = 92 % ((b - -36) / 32);
      i -= this.anInt1135;
      ++anInt1153;
      if (~i_40_ == -1) {
         if (~i_39_ == -1) {
            this.method983(i, 128, i_41_, true);
            this.method983(i, 8, i_41_ + -1, true);
         }

         if (i_39_ == 1) {
            this.method983(i, 2, i_41_, true);
            this.method983(1 + i, 32, i_41_, true);
         }

         if (~i_39_ == -3) {
            this.method983(i, 8, i_41_, true);
            this.method983(i, 128, 1 + i_41_, true);
         }

         if (i_39_ == 3) {
            this.method983(i, 32, i_41_, true);
            this.method983(-1 + i, 2, i_41_, true);
         }
      }

      if (~i_40_ == -2 || i_40_ == 3) {
         if (~i_39_ == -1) {
            this.method983(i, 1, i_41_, true);
            this.method983(i + 1, 16, -1 + i_41_, true);
         }

         if (~i_39_ == -2) {
            this.method983(i, 4, i_41_, true);
            this.method983(i - -1, 64, i_41_ + 1, true);
         }

         if (i_39_ == 2) {
            this.method983(i, 16, i_41_, true);
            this.method983(-1 + i, 1, i_41_ + 1, true);
         }

         if (i_39_ == 3) {
            this.method983(i, 64, i_41_, true);
            this.method983(-1 + i, 4, -1 + i_41_, true);
         }
      }

      if (i_40_ == 2) {
         if (~i_39_ == -1) {
            this.method983(i, 130, i_41_, true);
            this.method983(i, 8, -1 + i_41_, true);
            this.method983(1 + i, 32, i_41_, true);
         }

         if (i_39_ == 1) {
            this.method983(i, 10, i_41_, true);
            this.method983(i - -1, 32, i_41_, true);
            this.method983(i, 128, 1 + i_41_, true);
         }

         if (~i_39_ == -3) {
            this.method983(i, 40, i_41_, true);
            this.method983(i, 128, i_41_ + 1, true);
            this.method983(-1 + i, 2, i_41_, true);
         }

         if (i_39_ == 3) {
            this.method983(i, 160, i_41_, true);
            this.method983(-1 + i, 2, i_41_, true);
            this.method983(i, 8, i_41_ - 1, true);
         }
      }

      if (bool_42_) {
         if (i_40_ == 0) {
            if (~i_39_ == -1) {
               this.method983(i, 65536, i_41_, true);
               this.method983(i, 4096, -1 + i_41_, true);
            }

            if (i_39_ == 1) {
               this.method983(i, 1024, i_41_, true);
               this.method983(1 + i, 16384, i_41_, true);
            }

            if (~i_39_ == -3) {
               this.method983(i, 4096, i_41_, true);
               this.method983(i, 65536, 1 + i_41_, true);
            }

            if (~i_39_ == -4) {
               this.method983(i, 16384, i_41_, true);
               this.method983(i + -1, 1024, i_41_, true);
            }
         }

         if (i_40_ == 1 || ~i_40_ == -4) {
            if (i_39_ == 0) {
               this.method983(i, 512, i_41_, true);
               this.method983(1 + i, 8192, i_41_ - 1, true);
            }

            if (~i_39_ == -2) {
               this.method983(i, 2048, i_41_, true);
               this.method983(i - -1, 32768, i_41_ - -1, true);
            }

            if (~i_39_ == -3) {
               this.method983(i, 8192, i_41_, true);
               this.method983(i + -1, 512, 1 + i_41_, true);
            }

            if (i_39_ == 3) {
               this.method983(i, 32768, i_41_, true);
               this.method983(-1 + i, 2048, -1 + i_41_, true);
            }
         }

         if (~i_40_ == -3) {
            if (~i_39_ == -1) {
               this.method983(i, 66560, i_41_, true);
               this.method983(i, 4096, -1 + i_41_, true);
               this.method983(1 + i, 16384, i_41_, true);
            }

            if (i_39_ == 1) {
               this.method983(i, 5120, i_41_, true);
               this.method983(i - -1, 16384, i_41_, true);
               this.method983(i, 65536, 1 + i_41_, true);
            }

            if (i_39_ == 2) {
               this.method983(i, 20480, i_41_, true);
               this.method983(i, 65536, 1 + i_41_, true);
               this.method983(-1 + i, 1024, i_41_, true);
            }

            if (~i_39_ == -4) {
               this.method983(i, 81920, i_41_, true);
               this.method983(i - 1, 1024, i_41_, true);
               this.method983(i, 4096, i_41_ - 1, true);
            }
         }
      }

      if (bool) {
         if (~i_40_ == -1) {
            if (~i_39_ == -1) {
               this.method983(i, 536870912, i_41_, true);
               this.method983(i, 33554432, i_41_ + -1, true);
            }

            if (i_39_ == 1) {
               this.method983(i, 8388608, i_41_, true);
               this.method983(i + 1, 134217728, i_41_, true);
            }

            if (i_39_ == 2) {
               this.method983(i, 33554432, i_41_, true);
               this.method983(i, 536870912, 1 + i_41_, true);
            }

            if (~i_39_ == -4) {
               this.method983(i, 134217728, i_41_, true);
               this.method983(i + -1, 8388608, i_41_, true);
            }
         }

         if (~i_40_ == -2 || i_40_ == 3) {
            if (~i_39_ == -1) {
               this.method983(i, 4194304, i_41_, true);
               this.method983(1 + i, 67108864, i_41_ + -1, true);
            }

            if (~i_39_ == -2) {
               this.method983(i, 16777216, i_41_, true);
               this.method983(i + 1, 268435456, 1 + i_41_, true);
            }

            if (i_39_ == 2) {
               this.method983(i, 67108864, i_41_, true);
               this.method983(i - 1, 4194304, i_41_ - -1, true);
            }

            if (~i_39_ == -4) {
               this.method983(i, 268435456, i_41_, true);
               this.method983(i + -1, 16777216, i_41_ - 1, true);
            }
         }

         if (i_40_ == 2) {
            if (i_39_ == 0) {
               this.method983(i, 545259520, i_41_, true);
               this.method983(i, 33554432, -1 + i_41_, true);
               this.method983(i - -1, 134217728, i_41_, true);
            }

            if (~i_39_ == -2) {
               this.method983(i, 41943040, i_41_, true);
               this.method983(i - -1, 134217728, i_41_, true);
               this.method983(i, 536870912, i_41_ + 1, true);
            }

            if (i_39_ == 2) {
               this.method983(i, 167772160, i_41_, true);
               this.method983(i, 536870912, 1 + i_41_, true);
               this.method983(-1 + i, 8388608, i_41_, true);
            }

            if (~i_39_ == -4) {
               this.method983(i, 671088640, i_41_, true);
               this.method983(i - 1, 8388608, i_41_, true);
               this.method983(i, 33554432, i_41_ - 1, true);
            }
         }
      }
   }

   final boolean method988(int i, int i_44_, int i_45_, int i_46_, int i_47_, int i_48_, int i_49_, int i_50_, int i_51_) {
      ++anInt1150;
      if (~i_48_ < -2) {
         return Class150_Sub2.method1659(i_46_, i_48_, i_47_, -119, i_50_, i_49_, i_51_, i, i_48_)
            ? true
            : this.method984(i_48_, i, (byte)123, i_48_, i_47_, i_46_, i_45_, i_49_, i_51_, i_50_);
      } else {
         if (i_44_ != -7734) {
            this.method997(-56, true, 111);
         }

         int i_52_ = i_50_ + i_46_ + -1;
         int i_53_ = i_49_ + i - 1;
         if (i_46_ <= i_47_ && ~i_52_ <= ~i_47_ && ~i >= ~i_51_ && i_51_ <= i_53_) {
            return true;
         } else if (~i_47_ == ~(i_46_ - 1)
            && ~i_51_ <= ~i
            && i_51_ <= i_53_
            && (8 & this.clipMasks[i_47_ + -this.anInt1139][-this.anInt1135 + i_51_]) == 0
            && ~(8 & i_45_) == -1) {
            return true;
         } else if (i_47_ == 1 + i_52_
            && ~i >= ~i_51_
            && i_53_ >= i_51_
            && (this.clipMasks[i_47_ - this.anInt1139][i_51_ + -this.anInt1135] & 128) == 0
            && (i_45_ & 2) == 0) {
            return true;
         } else if (~(-1 + i) == ~i_51_
            && i_47_ >= i_46_
            && ~i_47_ >= ~i_52_
            && ~(2 & this.clipMasks[i_47_ - this.anInt1139][-this.anInt1135 + i_51_]) == -1
            && ~(4 & i_45_) == -1) {
            return true;
         } else {
            return i_51_ == 1 + i_53_
               && ~i_47_ <= ~i_46_
               && ~i_47_ >= ~i_52_
               && (32 & this.clipMasks[-this.anInt1139 + i_47_][-this.anInt1135 + i_51_]) == 0
               && ~(1 & i_45_) == -1;
         }
      }
   }

   final boolean method989(int i, int i_54_, int i_55_, int i_56_, int i_57_, int i_58_, int i_59_, int i_60_) {
      ++anInt1140;
      if (~i != -2) {
         if (i_58_ >= i_57_ && ~i_58_ >= ~(i_57_ - -i - 1) && ~i_55_ <= ~i_55_ && ~(-1 + i_55_ + i) <= ~i_55_) {
            return true;
         }
      } else if (i_58_ == i_57_ && i_56_ == i_55_) {
         return true;
      }

      i_57_ -= this.anInt1139;
      i_55_ -= this.anInt1135;
      i_58_ -= this.anInt1139;
      i_56_ -= this.anInt1135;
      if (i_60_ != 2883842) {
         this.clipMasks = null;
      }

      if (i != 1) {
         int i_61_ = -1 + i + i_57_;
         int i_62_ = -1 + i + i_56_;
         if (~i_54_ == -1) {
            if (i_59_ != 0) {
               if (~i_59_ == -2) {
                  if (i_58_ >= i_57_ && i_61_ >= i_58_ && ~(i_55_ + 1) == ~i_56_) {
                     return true;
                  }

                  if (~i_57_ == ~(-i + i_58_) && i_55_ >= i_56_ && ~i_55_ >= ~i_62_ && ~(this.clipMasks[i_61_][i_55_] & 2883848) == -1) {
                     return true;
                  }

                  if (1 + i_58_ == i_57_ && ~i_55_ <= ~i_56_ && i_62_ >= i_55_ && ~(this.clipMasks[i_57_][i_55_] & 2883968) == -1) {
                     return true;
                  }
               } else if (~i_59_ == -3) {
                  if (~(1 + i_58_) == ~i_57_ && i_56_ <= i_55_ && i_55_ <= i_62_) {
                     return true;
                  }

                  if (~i_58_ <= ~i_57_ && i_58_ <= i_61_ && i_56_ == i_55_ + 1 && ~(this.clipMasks[i_58_][i_56_] & 2883872) == -1) {
                     return true;
                  }

                  if (~i_57_ >= ~i_58_ && ~i_61_ <= ~i_58_ && i_55_ - i == i_56_ && ~(2883842 & this.clipMasks[i_58_][i_62_]) == -1) {
                     return true;
                  }
               } else if (~i_59_ == -4) {
                  if (~i_58_ <= ~i_57_ && ~i_58_ >= ~i_61_ && i_56_ == i_55_ + -i) {
                     return true;
                  }

                  if (~i_57_ == ~(-i + i_58_) && i_55_ >= i_56_ && ~i_55_ >= ~i_62_ && (this.clipMasks[i_61_][i_55_] & 2883848) == 0) {
                     return true;
                  }

                  if (i_57_ == 1 + i_58_ && i_56_ <= i_55_ && i_62_ >= i_55_ && (2883968 & this.clipMasks[i_57_][i_55_]) == 0) {
                     return true;
                  }
               }
            } else {
               if (-i + i_58_ == i_57_ && ~i_55_ <= ~i_56_ && i_55_ <= i_62_) {
                  return true;
               }

               if (i_58_ >= i_57_ && ~i_61_ <= ~i_58_ && 1 + i_55_ == i_56_ && (this.clipMasks[i_58_][i_56_] & 2883872) == 0) {
                  return true;
               }

               if (~i_58_ <= ~i_57_ && i_61_ >= i_58_ && ~(i_55_ + -i) == ~i_56_ && ~(this.clipMasks[i_58_][i_62_] & 2883842) == -1) {
                  return true;
               }
            }
         }

         if (i_54_ == 2) {
            if (~i_59_ != -1) {
               if (i_59_ != 1) {
                  if (i_59_ == 2) {
                     if (i_57_ == i_58_ + -i && i_55_ >= i_56_ && ~i_62_ <= ~i_55_ && ~(2883848 & this.clipMasks[i_61_][i_55_]) == -1) {
                        return true;
                     }

                     if (i_58_ >= i_57_ && ~i_58_ >= ~i_61_ && ~(1 + i_55_) == ~i_56_ && ~(2883872 & this.clipMasks[i_58_][i_56_]) == -1) {
                        return true;
                     }

                     if (i_58_ - -1 == i_57_ && i_55_ >= i_56_ && i_62_ >= i_55_) {
                        return true;
                     }

                     if (~i_58_ <= ~i_57_ && ~i_61_ <= ~i_58_ && i_56_ == i_55_ + -i) {
                        return true;
                     }
                  } else if (~i_59_ == -4) {
                     if (~(-i + i_58_) == ~i_57_ && ~i_55_ <= ~i_56_ && ~i_62_ <= ~i_55_) {
                        return true;
                     }

                     if (~i_57_ >= ~i_58_ && i_61_ >= i_58_ && ~i_56_ == ~(1 + i_55_) && (2883872 & this.clipMasks[i_58_][i_56_]) == 0) {
                        return true;
                     }

                     if (i_57_ == i_58_ + 1 && ~i_56_ >= ~i_55_ && i_55_ <= i_62_ && (this.clipMasks[i_57_][i_55_] & 2883968) == 0) {
                        return true;
                     }

                     if (i_57_ <= i_58_ && ~i_58_ >= ~i_61_ && ~i_56_ == ~(i_55_ - i)) {
                        return true;
                     }
                  }
               } else {
                  if (~i_57_ == ~(-i + i_58_) && i_56_ <= i_55_ && i_55_ <= i_62_ && ~(this.clipMasks[i_61_][i_55_] & 2883848) == -1) {
                     return true;
                  }

                  if (i_58_ >= i_57_ && i_61_ >= i_58_ && ~i_56_ == ~(i_55_ + 1)) {
                     return true;
                  }

                  if (1 + i_58_ == i_57_ && ~i_56_ >= ~i_55_ && i_62_ >= i_55_) {
                     return true;
                  }

                  if (~i_57_ >= ~i_58_ && i_61_ >= i_58_ && ~(i_55_ + -i) == ~i_56_ && (this.clipMasks[i_58_][i_62_] & 2883842) == 0) {
                     return true;
                  }
               }
            } else {
               if (i_58_ + -i == i_57_ && ~i_56_ >= ~i_55_ && ~i_55_ >= ~i_62_) {
                  return true;
               }

               if (~i_58_ <= ~i_57_ && i_61_ >= i_58_ && i_56_ == 1 + i_55_) {
                  return true;
               }

               if (i_57_ == i_58_ - -1 && i_55_ >= i_56_ && ~i_55_ >= ~i_62_ && ~(this.clipMasks[i_57_][i_55_] & 2883968) == -1) {
                  return true;
               }

               if (~i_58_ <= ~i_57_ && i_58_ <= i_61_ && ~i_56_ == ~(-i + i_55_) && (2883842 & this.clipMasks[i_58_][i_62_]) == 0) {
                  return true;
               }
            }
         }

         if (~i_54_ == -10) {
            if (i_57_ <= i_58_ && i_58_ <= i_61_ && ~(1 + i_55_) == ~i_56_ && (this.clipMasks[i_58_][i_56_] & 2883872) == 0) {
               return true;
            }

            if (i_58_ >= i_57_ && i_61_ >= i_58_ && -i + i_55_ == i_56_ && ~(2883842 & this.clipMasks[i_58_][i_62_]) == -1) {
               return true;
            }

            if (~i_57_ == ~(-i + i_58_) && i_55_ >= i_56_ && ~i_62_ <= ~i_55_ && ~(this.clipMasks[i_61_][i_55_] & 2883848) == -1) {
               return true;
            }

            if (i_58_ - -1 == i_57_ && ~i_56_ >= ~i_55_ && i_62_ >= i_55_ && (2883968 & this.clipMasks[i_57_][i_55_]) == 0) {
               return true;
            }
         }
      } else {
         if (i_54_ == 0) {
            if (i_59_ != 0) {
               if (~i_59_ == -2) {
                  if (~i_58_ == ~i_57_ && i_55_ - -1 == i_56_) {
                     return true;
                  }

                  if (-1 + i_58_ == i_57_ && ~i_56_ == ~i_55_ && (2883848 & this.clipMasks[i_57_][i_56_]) == 0) {
                     return true;
                  }

                  if (~i_57_ == ~(i_58_ - -1) && ~i_55_ == ~i_56_ && ~(this.clipMasks[i_57_][i_56_] & 2883968) == -1) {
                     return true;
                  }
               } else if (i_59_ == 2) {
                  if (i_57_ == i_58_ - -1 && ~i_56_ == ~i_55_) {
                     return true;
                  }

                  if (~i_58_ == ~i_57_ && ~i_56_ == ~(1 + i_55_) && (2883872 & this.clipMasks[i_57_][i_56_]) == 0) {
                     return true;
                  }

                  if (~i_58_ == ~i_57_ && -1 + i_55_ == i_56_ && (2883842 & this.clipMasks[i_57_][i_56_]) == 0) {
                     return true;
                  }
               } else if (~i_59_ == -4) {
                  if (i_58_ == i_57_ && i_56_ == -1 + i_55_) {
                     return true;
                  }

                  if (~i_57_ == ~(i_58_ - 1) && ~i_55_ == ~i_56_ && (this.clipMasks[i_57_][i_56_] & 2883848) == 0) {
                     return true;
                  }

                  if (i_57_ == i_58_ + 1 && i_55_ == i_56_ && ~(this.clipMasks[i_57_][i_56_] & 2883968) == -1) {
                     return true;
                  }
               }
            } else {
               if (i_57_ == i_58_ - 1 && ~i_56_ == ~i_55_) {
                  return true;
               }

               if (i_57_ == i_58_ && 1 + i_55_ == i_56_ && (2883872 & this.clipMasks[i_57_][i_56_]) == 0) {
                  return true;
               }

               if (i_58_ == i_57_ && i_56_ == i_55_ - 1 && (2883842 & this.clipMasks[i_57_][i_56_]) == 0) {
                  return true;
               }
            }
         }

         if (~i_54_ == -3) {
            if (~i_59_ != -1) {
               if (~i_59_ != -2) {
                  if (~i_59_ == -3) {
                     if (-1 + i_58_ == i_57_ && ~i_55_ == ~i_56_ && ~(this.clipMasks[i_57_][i_56_] & 2883848) == -1) {
                        return true;
                     }

                     if (i_58_ == i_57_ && ~(1 + i_55_) == ~i_56_ && ~(2883872 & this.clipMasks[i_57_][i_56_]) == -1) {
                        return true;
                     }

                     if (i_58_ + 1 == i_57_ && i_56_ == i_55_) {
                        return true;
                     }

                     if (i_58_ == i_57_ && i_55_ - 1 == i_56_) {
                        return true;
                     }
                  } else if (i_59_ == 3) {
                     if (~(i_58_ - 1) == ~i_57_ && i_56_ == i_55_) {
                        return true;
                     }

                     if (~i_57_ == ~i_58_ && i_56_ == i_55_ + 1 && (2883872 & this.clipMasks[i_57_][i_56_]) == 0) {
                        return true;
                     }

                     if (~i_57_ == ~(1 + i_58_) && i_55_ == i_56_ && ~(this.clipMasks[i_57_][i_56_] & 2883968) == -1) {
                        return true;
                     }

                     if (~i_58_ == ~i_57_ && ~(-1 + i_55_) == ~i_56_) {
                        return true;
                     }
                  }
               } else {
                  if (i_57_ == i_58_ - 1 && i_56_ == i_55_ && (2883848 & this.clipMasks[i_57_][i_56_]) == 0) {
                     return true;
                  }

                  if (i_57_ == i_58_ && ~i_56_ == ~(i_55_ + 1)) {
                     return true;
                  }

                  if (i_57_ == 1 + i_58_ && ~i_56_ == ~i_55_) {
                     return true;
                  }

                  if (i_58_ == i_57_ && i_56_ == -1 + i_55_ && ~(this.clipMasks[i_57_][i_56_] & 2883842) == -1) {
                     return true;
                  }
               }
            } else {
               if (~i_57_ == ~(-1 + i_58_) && ~i_55_ == ~i_56_) {
                  return true;
               }

               if (~i_58_ == ~i_57_ && i_56_ == i_55_ - -1) {
                  return true;
               }

               if (~i_57_ == ~(1 + i_58_) && i_55_ == i_56_ && (2883968 & this.clipMasks[i_57_][i_56_]) == 0) {
                  return true;
               }

               if (~i_58_ == ~i_57_ && -1 + i_55_ == i_56_ && (2883842 & this.clipMasks[i_57_][i_56_]) == 0) {
                  return true;
               }
            }
         }

         if (~i_54_ == -10) {
            if (i_58_ == i_57_ && 1 + i_55_ == i_56_ && (32 & this.clipMasks[i_57_][i_56_]) == 0) {
               return true;
            }

            if (~i_58_ == ~i_57_ && i_55_ + -1 == i_56_ && (this.clipMasks[i_57_][i_56_] & 2) == 0) {
               return true;
            }

            if (-1 + i_58_ == i_57_ && ~i_55_ == ~i_56_ && (8 & this.clipMasks[i_57_][i_56_]) == 0) {
               return true;
            }

            if (1 + i_58_ == i_57_ && ~i_55_ == ~i_56_ && ~(this.clipMasks[i_57_][i_56_] & 128) == -1) {
               return true;
            }
         }
      }

      return false;
   }

   final void method990(int i, int i_63_, int i_64_) {
      if (i_64_ != -17078) {
         aString1148 = null;
      }

      ++anInt1142;
      i_63_ -= this.anInt1139;
      i -= this.anInt1135;
      this.clipMasks[i_63_][i] = Node_Sub16.method2590(this.clipMasks[i_63_][i], 2097152);
   }

   final void method991(int i) {
      ++anInt1143;

      for(int i_65_ = 0; ~this.anInt1133 < ~i_65_; ++i_65_) {
         for(int i_66_ = 0; ~this.anInt1146 < ~i_66_; ++i_66_) {
            if (i_65_ != 0 && i_66_ != 0 && ~i_65_ > ~(-5 + this.anInt1133) && this.anInt1146 - 5 > i_66_) {
               this.clipMasks[i_65_][i_66_] = 2097152;
            } else {
               this.clipMasks[i_65_][i_66_] = -1;
            }
         }
      }

      if (i >= -86) {
         this.method988(-4, -128, 38, 51, 96, -103, 64, 8, -26);
      }
   }

   final void method992(boolean bool, boolean bool_67_, byte b, int i, int i_68_, int i_69_, int i_70_, int i_71_) {
      ++anInt1134;
      int i_72_ = 256;
      if (bool) {
         i_72_ |= 131072;
      }

      i_71_ -= this.anInt1135;
      i -= this.anInt1139;
      if (~i_70_ == -2 || i_70_ == 3) {
         int i_73_ = i_68_;
         i_68_ = i_69_;
         i_69_ = i_73_;
      }

      if (bool_67_) {
         i_72_ |= 1073741824;
      }

      int i_74_ = i;

      for(int i_75_ = -121 % ((82 - b) / 41); i_74_ < i_68_ + i; ++i_74_) {
         if (i_74_ >= 0 && this.anInt1133 > i_74_) {
            for(int i_76_ = i_71_; i_71_ - -i_69_ > i_76_; ++i_76_) {
               if (~i_76_ <= -1 && ~i_76_ > ~this.anInt1146) {
                  this.method983(i_76_, i_72_, i_74_, true);
               }
            }
         }
      }
   }

   final void setClipMask(int localY, int localX, int junk) {
      if (junk > -109) {
         anIntArray1147 = null;
      }

      localY -= this.anInt1135;
      ++anInt1137;
      localX -= this.anInt1139;
      this.clipMasks[localX][localY] = Node_Sub30.method2723(this.clipMasks[localX][localY], -2097153);
   }

   final void method994(int i, int i_79_, int i_80_) {
      ++anInt1141;
      i_79_ -= this.anInt1139;
      i -= this.anInt1135;
      this.clipMasks[i_79_][i] = Node_Sub16.method2590(this.clipMasks[i_79_][i], 262144);
      int i_81_ = 31 % ((i_80_ - 44) / 59);
   }

   private final void method995(int i, int i_82_, int i_83_, int i_84_) {
      this.clipMasks[i][i_82_] = Node_Sub16.method2590(this.clipMasks[i][i_82_], i_83_);
      ++anInt1131;
      int i_85_ = 77 / ((-55 - i_84_) / 44);
   }

   final void method996(int i, int i_86_, int i_87_, int i_88_, boolean bool, int i_89_, boolean bool_90_) {
      ++anInt1151;
      int i_91_ = 256;
      if (bool_90_) {
         i_91_ |= 131072;
      }

      if (bool) {
         i_91_ |= 1073741824;
      }

      i_88_ -= this.anInt1135;
      if (i_87_ == 1) {
         i -= this.anInt1139;

         for(int i_92_ = i; i_92_ < i + i_89_; ++i_92_) {
            if (i_92_ >= 0 && this.anInt1133 > i_92_) {
               for(int i_93_ = i_88_; i_86_ + i_88_ > i_93_; ++i_93_) {
                  if (i_93_ >= 0 && this.anInt1146 > i_93_) {
                     this.method995(i_92_, i_93_, i_91_, i_87_ ^ -100);
                  }
               }
            }
         }
      }
   }

   final void method997(int i, boolean bool, int i_94_) {
      if (!bool) {
         this.method989(-11, -28, 10, -29, 59, 57, 109, 80);
      }

      i -= this.anInt1135;
      i_94_ -= this.anInt1139;
      ++anInt1149;
      this.clipMasks[i_94_][i] = Node_Sub30.method2723(this.clipMasks[i_94_][i], -262145);
   }

   Class84() {
   }
}
