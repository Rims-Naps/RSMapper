public class Class191 {
   static int anInt2341;
   private int anInt2342;
   static int anInt2343;
   static int anInt2344;
   static int anInt2345;
   static int anInt2346;
   static int anInt2347;
   private int[][] anIntArrayArray2348;
   static Class139 aClass139_2349 = new Class139();
   static String aString2350;
   static int anInt2351;
   private int anInt2352;
   static int anInt2353;

   static final boolean method1944(int i, int i_0_) {
      ++anInt2346;
      if (Class3.anInt5161 != i || ClientScript.aClass216_9498 == null) {
         ProducingGraphicsBuffer.method2601(-85);
         Class3.anInt5161 = i;
         ClientScript.aClass216_9498 = Class216.aClass216_2546;
      }

      int i_1_ = 73 % ((-6 - i_0_) / 63);
      if (Class216.aClass216_2546 == ClientScript.aClass216_9498) {
         byte[] bs = Node_Sub15_Sub10.index35.method3518((byte)113, i);
         if (bs == null) {
            return false;
         }

         Buffer buffer = new Buffer(bs);
         Class10.method189(buffer, 101);
         int i_2_ = buffer.readUnsignedByte();

         for(int i_3_ = 0; ~i_2_ < ~i_3_; ++i_3_) {
            Class320_Sub16.aClass312_8358.method3625((byte)-54, new Node_Sub28(buffer));
         }

         int i_4_ = buffer.readSmart();
         Class194_Sub1.aClass331Array6894 = new Class331[i_4_];

         for(int i_5_ = 0; ~i_5_ > ~i_4_; ++i_5_) {
            Class194_Sub1.aClass331Array6894[i_5_] = new Class331(buffer);
         }

         int i_6_ = buffer.readSmart();
         Class121.aClass206Array1529 = new Class206[i_6_];

         for(int i_7_ = 0; ~i_7_ > ~i_6_; ++i_7_) {
            Class121.aClass206Array1529[i_7_] = new Class206(buffer, i_7_);
         }

         int i_8_ = buffer.readSmart();
         Node_Sub39.aClass369Array7497 = new Class369[i_8_];

         for(int i_9_ = 0; ~i_9_ > ~i_8_; ++i_9_) {
            Node_Sub39.aClass369Array7497[i_9_] = new Class369(buffer);
         }

         int i_10_ = buffer.readSmart();
         Class262_Sub5.aClass199Array7732 = new Class199[i_10_];

         for(int i_11_ = 0; i_11_ < i_10_; ++i_11_) {
            Class262_Sub5.aClass199Array7732[i_11_] = new Class199(buffer);
         }

         int i_12_ = buffer.readSmart();
         Class214.aClass262Array2528 = new Class262[i_12_];

         for(int i_13_ = 0; i_13_ < i_12_; ++i_13_) {
            Class214.aClass262Array2528[i_13_] = Class128.method1548(buffer, (byte)61);
         }

         ClientScript.aClass216_9498 = Class216.aClass216_2547;
      }

      if (ClientScript.aClass216_9498 == Class216.aClass216_2547) {
         boolean bool = true;
         Class262[] class262s = Class214.aClass262Array2528;

         for(int i_14_ = 0; ~i_14_ > ~class262s.length; ++i_14_) {
            Class262 class262 = class262s[i_14_];
            if (!class262.method3145(true)) {
               bool = false;
            }
         }

         if (!bool) {
            return false;
         }

         ClientScript.aClass216_9498 = Class216.aClass216_2549;
      }

      return true;
   }

   final int method1945(int i, int i_15_) {
      if (this.anIntArrayArray2348 != null) {
         i_15_ = (int)((long)i_15_ * (long)this.anInt2352 / (long)this.anInt2342) + 6;
      }

      ++anInt2343;
      if (i != 5692) {
         this.method1948(-63, -114);
      }

      return i_15_;
   }

   static final void method1946(Player player, int i, boolean bool, byte b, int i_16_) {
      ++anInt2341;
      int i_17_ = player.scenePositionXQueue[0];
      int i_18_ = player.scenePositionYQueue[0];
      if (i_17_ >= 0
         && i_17_ < Node_Sub54.GAME_SCENE_WDITH
         && i_18_ >= 0
         && Class377_Sub1.GAME_SCENE_HEIGHT > i_18_
         && i >= 0
         && i < Node_Sub54.GAME_SCENE_WDITH
         && ~i_16_ <= -1
         && Class377_Sub1.GAME_SCENE_HEIGHT > i_16_) {
         int i_19_ = Class275.method3332(
            i_16_,
            player.getSize((byte)65),
            bool,
            0,
            i_17_,
            0,
            Class258.calculatedScenePositionYs,
            (byte)-41,
            0,
            i_18_,
            -4,
            Class304.SCENE_CLIP_DATA_PLANES[player.plane],
            Class328_Sub1.calculatedScenePositionXs,
            i,
            0
         );
         if (~i_19_ <= -2 && ~i_19_ >= -4) {
            for(int i_20_ = 0; ~(i_19_ + -1) < ~i_20_; ++i_20_) {
               player.method887(-24527, Class258.calculatedScenePositionYs[i_20_], Class328_Sub1.calculatedScenePositionXs[i_20_], b);
            }
         }
      }
   }

   static final String method1947(int i, int i_21_) {
      ++anInt2347;
      String string = Integer.toString(i_21_);

      for(int i_22_ = string.length() - i; ~i_22_ < -1; i_22_ -= 3) {
         string = string.substring(0, i_22_) + "," + string.substring(i_22_);
      }

      if (~string.length() < -10) {
         return " <col=00ff80>"
            + string.substring(0, -8 + string.length())
            + Class22.aClass22_396.getStoredString(Class35.language)
            + " ("
            + string
            + ")</col>";
      } else {
         return string.length() > 6
            ? " <col=ffffff>" + string.substring(0, -4 + string.length()) + Class22.aClass22_398.getStoredString(Class35.language) + " (" + string + ")</col>"
            : " <col=ffff00>" + string + "</col>";
      }
   }

   final int method1948(int i, int i_23_) {
      if (this.anIntArrayArray2348 != null) {
         i_23_ = (int)((long)this.anInt2352 * (long)i_23_ / (long)this.anInt2342);
      }

      ++anInt2344;
      return i != 0 ? 44 : i_23_;
   }

   final byte[] method1949(int i, byte[] bs) {
      if (this.anIntArrayArray2348 != null) {
         int i_24_ = (int)((long)bs.length * (long)this.anInt2352 / (long)this.anInt2342) + 14;
         int[] is = new int[i_24_];
         int i_25_ = 0;
         int i_26_ = 0;

         for(int i_27_ = 0; i_27_ < bs.length; ++i_27_) {
            int i_28_ = bs[i_27_];
            int[] is_29_ = this.anIntArrayArray2348[i_26_];

            for(int i_30_ = 0; ~i_30_ > -15; ++i_30_) {
               is[i_25_ + i_30_] += is_29_[i_30_] * i_28_;
            }

            i_26_ += this.anInt2352;
            int i_31_ = i_26_ / this.anInt2342;
            i_26_ -= this.anInt2342 * i_31_;
            i_25_ += i_31_;
         }

         bs = new byte[i_24_];

         for(int i_32_ = 0; i_32_ < i_24_; ++i_32_) {
            int i_33_ = is[i_32_] - -32768 >> 16;
            if (i_33_ >= -128) {
               if (~i_33_ < -128) {
                  bs[i_32_] = 127;
               } else {
                  bs[i_32_] = (byte)i_33_;
               }
            } else {
               bs[i_32_] = -128;
            }
         }
      }

      ++anInt2345;
      if (i != -14) {
         this.method1945(-56, 114);
      }

      return bs;
   }

   public static void method1950(boolean bool) {
      aString2350 = null;
      aClass139_2349 = null;
      if (bool) {
         aString2350 = null;
      }
   }

   final short[] method1951(short[] ses, int i) {
      ++anInt2351;
      if (this.anIntArrayArray2348 != null) {
         int i_34_ = (int)((long)this.anInt2352 * (long)ses.length / (long)this.anInt2342) - -14;
         int[] is = new int[i_34_];
         int i_35_ = 0;
         int i_36_ = 0;

         for(int i_37_ = 0; i_37_ < ses.length; ++i_37_) {
            int i_38_ = ses[i_37_];
            int[] is_39_ = this.anIntArrayArray2348[i_36_];

            for(int i_40_ = 0; ~i_40_ > -15; ++i_40_) {
               is[i_35_ + i_40_] += is_39_[i_40_] * i_38_ >> 2;
            }

            i_36_ += this.anInt2352;
            int i_41_ = i_36_ / this.anInt2342;
            i_35_ += i_41_;
            i_36_ -= this.anInt2342 * i_41_;
         }

         ses = new short[i_34_];

         for(int i_42_ = 0; ~i_34_ < ~i_42_; ++i_42_) {
            int i_43_ = is[i_42_] - -8192 >> 14;
            if (i_43_ >= -32768) {
               if (i_43_ > 32767) {
                  ses[i_42_] = 32767;
               } else {
                  ses[i_42_] = (short)i_43_;
               }
            } else {
               ses[i_42_] = -32768;
            }
         }
      }

      return i != 30664 ? null : ses;
   }

   Class191(int i, int i_44_) {
      if (~i_44_ != ~i) {
         int i_45_ = Class167.method1748(i_44_, (byte)-21, i);
         i /= i_45_;
         i_44_ /= i_45_;
         this.anIntArrayArray2348 = new int[i][14];
         this.anInt2342 = i;
         this.anInt2352 = i_44_;

         for(int i_46_ = 0; i > i_46_; ++i_46_) {
            int[] is = this.anIntArrayArray2348[i_46_];
            double d = (double)i_46_ / (double)i + 6.0;
            int i_47_ = (int)Math.floor(-7.0 + d + 1.0);
            if (i_47_ < 0) {
               i_47_ = 0;
            }

            int i_48_ = (int)Math.ceil(d + 7.0);
            if (i_48_ > 14) {
               i_48_ = 14;
            }

            for(double d_49_ = (double)i_44_ / (double)i; i_47_ < i_48_; ++i_47_) {
               double d_50_ = Math.PI * ((double)i_47_ - d);
               double d_51_ = d_49_;
               if (d_50_ < -1.0E-4 || d_50_ > 1.0E-4) {
                  d_51_ = d_49_ * (Math.sin(d_50_) / d_50_);
               }

               d_51_ *= 0.54 + 0.46 * Math.cos(((double)i_47_ - d) * (Math.PI / 14));
               is[i_47_] = (int)Math.floor(65536.0 * d_51_ + 0.5);
            }
         }
      }
   }
}