public class Class383 {
   protected int anInt4897;
   protected int anInt4898;
   protected int anInt4899;
   protected int anInt4900;
   protected int anInt4901;
   protected int anInt4902;
   protected byte[] aByteArray4903;
   protected int[] anIntArray4904;
   protected byte[] aByteArray4905;

   static final Class383[] method4187(Index class302, int i, int i_0_) {
      byte[] bs = class302.getFile(false, i_0_, i);
      return bs == null ? null : method4188(bs);
   }

   private static final Class383[] method4188(byte[] bs) {
      Buffer buffer = new Buffer(bs);
      buffer.offset = bs.length - 2;
      int i = buffer.readUnsignedShort();
      Class383[] class383s = new Class383[i];

      for(int i_1_ = 0; i_1_ < i; ++i_1_) {
         class383s[i_1_] = new Class383();
      }

      buffer.offset = bs.length - 7 - i * 8;
      int i_2_ = buffer.readUnsignedShort();
      int i_3_ = buffer.readUnsignedShort();
      int i_4_ = (buffer.readUnsignedByte() & 0xFF) + 1;

      for(int i_5_ = 0; i_5_ < i; ++i_5_) {
         class383s[i_5_].anInt4902 = buffer.readUnsignedShort();
      }

      for(int i_6_ = 0; i_6_ < i; ++i_6_) {
         class383s[i_6_].anInt4898 = buffer.readUnsignedShort();
      }

      for(int i_7_ = 0; i_7_ < i; ++i_7_) {
         class383s[i_7_].anInt4897 = buffer.readUnsignedShort();
      }

      for(int i_8_ = 0; i_8_ < i; ++i_8_) {
         class383s[i_8_].anInt4900 = buffer.readUnsignedShort();
      }

      for(int i_9_ = 0; i_9_ < i; ++i_9_) {
         Class383 class383 = class383s[i_9_];
         class383.anInt4901 = i_2_ - class383.anInt4897 - class383.anInt4902;
         class383.anInt4899 = i_3_ - class383.anInt4900 - class383.anInt4898;
      }

      buffer.offset = bs.length - 7 - i * 8 - (i_4_ - 1) * 3;
      int[] is = new int[i_4_];

      for(int i_10_ = 1; i_10_ < i_4_; ++i_10_) {
         is[i_10_] = buffer.read24BitInteger();
         if (is[i_10_] == 0) {
            is[i_10_] = 1;
         }
      }

      for(int i_11_ = 0; i_11_ < i; ++i_11_) {
         class383s[i_11_].anIntArray4904 = is;
      }

      buffer.offset = 0;

      for(int i_12_ = 0; i_12_ < i; ++i_12_) {
         Class383 class383 = class383s[i_12_];
         int i_13_ = class383.anInt4897 * class383.anInt4900;
         class383.aByteArray4903 = new byte[i_13_];
         int i_14_ = buffer.readUnsignedByte();
         if ((i_14_ & 2) == 0) {
            if ((i_14_ & 1) == 0) {
               for(int i_15_ = 0; i_15_ < i_13_; ++i_15_) {
                  class383.aByteArray4903[i_15_] = buffer.readByte();
               }
            } else {
               for(int i_16_ = 0; i_16_ < class383.anInt4897; ++i_16_) {
                  for(int i_17_ = 0; i_17_ < class383.anInt4900; ++i_17_) {
                     class383.aByteArray4903[i_16_ + i_17_ * class383.anInt4897] = buffer.readByte();
                  }
               }
            }
         } else {
            boolean bool = false;
            class383.aByteArray4905 = new byte[i_13_];
            if ((i_14_ & 1) == 0) {
               for(int i_18_ = 0; i_18_ < i_13_; ++i_18_) {
                  class383.aByteArray4903[i_18_] = buffer.readByte();
               }

               for(int i_19_ = 0; i_19_ < i_13_; ++i_19_) {
                  byte b = class383.aByteArray4905[i_19_] = buffer.readByte();
                  bool |= b != -1;
               }
            } else {
               for(int i_20_ = 0; i_20_ < class383.anInt4897; ++i_20_) {
                  for(int i_21_ = 0; i_21_ < class383.anInt4900; ++i_21_) {
                     class383.aByteArray4903[i_20_ + i_21_ * class383.anInt4897] = buffer.readByte();
                  }
               }

               for(int i_22_ = 0; i_22_ < class383.anInt4897; ++i_22_) {
                  for(int i_23_ = 0; i_23_ < class383.anInt4900; ++i_23_) {
                     byte b = class383.aByteArray4905[i_22_ + i_23_ * class383.anInt4897] = buffer.readByte();
                     bool |= b != -1;
                  }
               }
            }

            if (!bool) {
               class383.aByteArray4905 = null;
            }
         }
      }

      return class383s;
   }

   final void method4189() {
      byte[] bs = this.aByteArray4903;
      if (this.aByteArray4905 == null) {
         for(int i = (this.anInt4900 >> 1) - 1; i >= 0; --i) {
            int i_24_ = i * this.anInt4897;
            int i_25_ = (this.anInt4900 - i - 1) * this.anInt4897;

            for(int i_26_ = -this.anInt4897; i_26_ < 0; ++i_26_) {
               byte b = bs[i_24_];
               bs[i_24_] = bs[i_25_];
               bs[i_25_] = b;
               ++i_24_;
               ++i_25_;
            }
         }
      } else {
         byte[] bs_27_ = this.aByteArray4905;

         for(int i = (this.anInt4900 >> 1) - 1; i >= 0; --i) {
            int i_28_ = i * this.anInt4897;
            int i_29_ = (this.anInt4900 - i - 1) * this.anInt4897;

            for(int i_30_ = -this.anInt4897; i_30_ < 0; ++i_30_) {
               byte b = bs[i_28_];
               bs[i_28_] = bs[i_29_];
               bs[i_29_] = b;
               b = bs_27_[i_28_];
               bs_27_[i_28_] = bs_27_[i_29_];
               bs_27_[i_29_] = b;
               ++i_28_;
               ++i_29_;
            }
         }
      }

      int i = this.anInt4898;
      this.anInt4898 = this.anInt4899;
      this.anInt4899 = i;
   }

   final int method4190() {
      return this.anInt4897 + this.anInt4902 + this.anInt4901;
   }

   static final Class383 method4191(Index class302, int i) {
      byte[] bs = class302.method3518((byte)-127, i);
      return bs == null ? null : method4188(bs)[0];
   }

   final void method4192(int i) {
      int i_31_ = this.method4190();
      int i_32_ = this.method4196();
      if (this.anInt4897 != i_31_ || this.anInt4900 != i_32_) {
         int i_33_ = i;
         if (i > this.anInt4902) {
            i_33_ = this.anInt4902;
         }

         int i_34_ = i;
         if (i + this.anInt4902 + this.anInt4897 > i_31_) {
            i_34_ = i_31_ - this.anInt4902 - this.anInt4897;
         }

         int i_35_ = i;
         if (i > this.anInt4898) {
            i_35_ = this.anInt4898;
         }

         int i_36_ = i;
         if (i + this.anInt4898 + this.anInt4900 > i_32_) {
            i_36_ = i_32_ - this.anInt4898 - this.anInt4900;
         }

         int i_37_ = this.anInt4897 + i_33_ + i_34_;
         int i_38_ = this.anInt4900 + i_35_ + i_36_;
         byte[] bs = new byte[i_37_ * i_38_];
         if (this.aByteArray4905 == null) {
            for(int i_39_ = 0; i_39_ < this.anInt4900; ++i_39_) {
               int i_40_ = i_39_ * this.anInt4897;
               int i_41_ = (i_39_ + i_35_) * i_37_ + i_33_;

               for(int i_42_ = 0; i_42_ < this.anInt4897; ++i_42_) {
                  bs[i_41_++] = this.aByteArray4903[i_40_++];
               }
            }
         } else {
            byte[] bs_43_ = new byte[i_37_ * i_38_];

            for(int i_44_ = 0; i_44_ < this.anInt4900; ++i_44_) {
               int i_45_ = i_44_ * this.anInt4897;
               int i_46_ = (i_44_ + i_35_) * i_37_ + i_33_;

               for(int i_47_ = 0; i_47_ < this.anInt4897; ++i_47_) {
                  bs_43_[i_46_] = this.aByteArray4905[i_45_];
                  bs[i_46_++] = this.aByteArray4903[i_45_++];
               }
            }

            this.aByteArray4905 = bs_43_;
         }

         this.anInt4902 -= i_33_;
         this.anInt4898 -= i_35_;
         this.anInt4901 -= i_34_;
         this.anInt4899 -= i_36_;
         this.anInt4897 = i_37_;
         this.anInt4900 = i_38_;
         this.aByteArray4903 = bs;
      }
   }

   final void method4193(int i) {
      int i_48_ = -1;
      if (this.anIntArray4904.length < 255) {
         for(int i_49_ = 0; i_49_ < this.anIntArray4904.length; ++i_49_) {
            if (this.anIntArray4904[i_49_] == i) {
               i_48_ = i_49_;
               break;
            }
         }

         if (i_48_ == -1) {
            i_48_ = this.anIntArray4904.length;
            int[] is = new int[this.anIntArray4904.length + 1];
            Class311.method3609(this.anIntArray4904, 0, is, 0, this.anIntArray4904.length);
            this.anIntArray4904 = is;
            is[i_48_] = i;
         }
      } else {
         int i_50_ = Integer.MAX_VALUE;
         int i_51_ = i >> 16 & 0xFF;
         int i_52_ = i >> 8 & 0xFF;
         int i_53_ = i & 0xFF;

         for(int i_54_ = 0; i_54_ < this.anIntArray4904.length; ++i_54_) {
            int i_55_ = this.anIntArray4904[i_54_];
            int i_56_ = i_55_ >> 16 & 0xFF;
            int i_57_ = i_55_ >> 8 & 0xFF;
            int i_58_ = i_55_ & 0xFF;
            int i_59_ = i_51_ - i_56_;
            if (i_59_ < 0) {
               i_59_ = -i_59_;
            }

            int i_60_ = i_52_ - i_57_;
            if (i_60_ < 0) {
               i_60_ = -i_60_;
            }

            int i_61_ = i_53_ - i_58_;
            if (i_61_ < 0) {
               i_61_ = -i_61_;
            }

            int i_62_ = i_59_ + i_60_ + i_61_;
            if (i_62_ < i_50_) {
               i_50_ = i_62_;
               i_48_ = i_54_;
            }
         }
      }

      for(int i_63_ = this.anInt4900 - 1; i_63_ > 0; --i_63_) {
         int i_64_ = i_63_ * this.anInt4897;

         for(int i_65_ = this.anInt4897 - 1; i_65_ > 0; --i_65_) {
            if (this.anIntArray4904[this.aByteArray4903[i_65_ + i_64_] & 255] == 0
               && this.anIntArray4904[this.aByteArray4903[i_65_ + i_64_ - 1 - this.anInt4897] & 255] != 0) {
               this.aByteArray4903[i_65_ + i_64_] = (byte)i_48_;
            }
         }
      }
   }

   static final Class383 method4194(Index class302, int i, int i_66_) {
      byte[] bs = class302.getFile(false, i_66_, i);
      return bs == null ? null : method4188(bs)[0];
   }

   final int[] method4195() {
      int i = this.method4190();
      int[] is = new int[i * this.method4196()];
      if (this.aByteArray4905 != null) {
         for(int i_67_ = 0; i_67_ < this.anInt4900; ++i_67_) {
            int i_68_ = i_67_ * this.anInt4897;
            int i_69_ = this.anInt4902 + (i_67_ + this.anInt4898) * i;

            for(int i_70_ = 0; i_70_ < this.anInt4897; ++i_70_) {
               is[i_69_++] = this.aByteArray4905[i_68_] << 24 | this.anIntArray4904[this.aByteArray4903[i_68_] & 255];
               ++i_68_;
            }
         }
      } else {
         for(int i_71_ = 0; i_71_ < this.anInt4900; ++i_71_) {
            int i_72_ = i_71_ * this.anInt4897;
            int i_73_ = this.anInt4902 + (i_71_ + this.anInt4898) * i;

            for(int i_74_ = 0; i_74_ < this.anInt4897; ++i_74_) {
               int i_75_ = this.anIntArray4904[this.aByteArray4903[i_72_++] & 255];
               if (i_75_ != 0) {
                  is[i_73_++] = 0xFF000000 | i_75_;
               } else {
                  is[i_73_++] = 0;
               }
            }
         }
      }

      return is;
   }

   final int method4196() {
      return this.anInt4900 + this.anInt4898 + this.anInt4899;
   }

   final void method4197(int i) {
      int i_76_ = -1;
      if (this.anIntArray4904.length < 255) {
         for(int i_77_ = 0; i_77_ < this.anIntArray4904.length; ++i_77_) {
            if (this.anIntArray4904[i_77_] == i) {
               i_76_ = i_77_;
               break;
            }
         }

         if (i_76_ == -1) {
            i_76_ = this.anIntArray4904.length;
            int[] is = new int[this.anIntArray4904.length + 1];
            Class311.method3609(this.anIntArray4904, 0, is, 0, this.anIntArray4904.length);
            this.anIntArray4904 = is;
            is[i_76_] = i;
         }
      } else {
         int i_78_ = Integer.MAX_VALUE;
         int i_79_ = i >> 16 & 0xFF;
         int i_80_ = i >> 8 & 0xFF;
         int i_81_ = i & 0xFF;

         for(int i_82_ = 0; i_82_ < this.anIntArray4904.length; ++i_82_) {
            int i_83_ = this.anIntArray4904[i_82_];
            int i_84_ = i_83_ >> 16 & 0xFF;
            int i_85_ = i_83_ >> 8 & 0xFF;
            int i_86_ = i_83_ & 0xFF;
            int i_87_ = i_79_ - i_84_;
            if (i_87_ < 0) {
               i_87_ = -i_87_;
            }

            int i_88_ = i_80_ - i_85_;
            if (i_88_ < 0) {
               i_88_ = -i_88_;
            }

            int i_89_ = i_81_ - i_86_;
            if (i_89_ < 0) {
               i_89_ = -i_89_;
            }

            int i_90_ = i_87_ + i_88_ + i_89_;
            if (i_90_ < i_78_) {
               i_78_ = i_90_;
               i_76_ = i_82_;
            }
         }
      }

      int i_91_ = 0;
      byte[] bs = new byte[this.anInt4897 * this.anInt4900];

      for(int i_92_ = 0; i_92_ < this.anInt4900; ++i_92_) {
         for(int i_93_ = 0; i_93_ < this.anInt4897; ++i_93_) {
            int i_94_ = this.aByteArray4903[i_91_] & 255;
            if (this.anIntArray4904[i_94_] == 0) {
               if (i_93_ > 0 && this.anIntArray4904[this.aByteArray4903[i_91_ - 1] & 255] != 0) {
                  i_94_ = i_76_;
               } else if (i_92_ > 0 && this.anIntArray4904[this.aByteArray4903[i_91_ - this.anInt4897] & 255] != 0) {
                  i_94_ = i_76_;
               } else if (i_93_ < this.anInt4897 - 1 && this.anIntArray4904[this.aByteArray4903[i_91_ + 1] & 255] != 0) {
                  i_94_ = i_76_;
               } else if (i_92_ < this.anInt4900 - 1 && this.anIntArray4904[this.aByteArray4903[i_91_ + this.anInt4897] & 255] != 0) {
                  i_94_ = i_76_;
               }
            }

            bs[i_91_++] = (byte)i_94_;
         }
      }

      this.aByteArray4903 = bs;
   }

   final void method4198() {
      byte[] bs = new byte[this.anInt4897 * this.anInt4900];
      int i = 0;
      if (this.aByteArray4905 == null) {
         for(int i_95_ = 0; i_95_ < this.anInt4897; ++i_95_) {
            for(int i_96_ = this.anInt4900 - 1; i_96_ >= 0; --i_96_) {
               bs[i++] = this.aByteArray4903[i_95_ + i_96_ * this.anInt4897];
            }
         }

         this.aByteArray4903 = bs;
      } else {
         byte[] bs_97_ = new byte[this.anInt4897 * this.anInt4900];

         for(int i_98_ = 0; i_98_ < this.anInt4897; ++i_98_) {
            for(int i_99_ = this.anInt4900 - 1; i_99_ >= 0; --i_99_) {
               bs[i] = this.aByteArray4903[i_98_ + i_99_ * this.anInt4897];
               bs_97_[i++] = this.aByteArray4905[i_98_ + i_99_ * this.anInt4897];
            }
         }

         this.aByteArray4903 = bs;
         this.aByteArray4905 = bs_97_;
      }

      int i_100_ = this.anInt4898;
      this.anInt4898 = this.anInt4902;
      this.anInt4902 = this.anInt4899;
      this.anInt4899 = this.anInt4901;
      this.anInt4901 = this.anInt4898;
      i_100_ = this.anInt4900;
      this.anInt4900 = this.anInt4897;
      this.anInt4897 = i_100_;
   }

   static final Class383[] method4199(Index class302, int i) {
      byte[] bs = class302.method3518((byte)4, i);
      return bs == null ? null : method4188(bs);
   }

   final void method4200() {
      byte[] bs = this.aByteArray4903;
      if (this.aByteArray4905 == null) {
         for(int i = this.anInt4900 - 1; i >= 0; --i) {
            int i_101_ = i * this.anInt4897;

            for(int i_102_ = (i + 1) * this.anInt4897; i_101_ < i_102_; ++i_101_) {
               --i_102_;
               byte b = bs[i_101_];
               bs[i_101_] = bs[i_102_];
               bs[i_102_] = b;
            }
         }
      } else {
         byte[] bs_103_ = this.aByteArray4905;

         for(int i = this.anInt4900 - 1; i >= 0; --i) {
            int i_104_ = i * this.anInt4897;

            for(int i_105_ = (i + 1) * this.anInt4897; i_104_ < i_105_; ++i_104_) {
               --i_105_;
               byte b = bs[i_104_];
               bs[i_104_] = bs[i_105_];
               bs[i_105_] = b;
               b = bs_103_[i_104_];
               bs_103_[i_104_] = bs_103_[i_105_];
               bs_103_[i_105_] = b;
            }
         }
      }

      int i = this.anInt4902;
      this.anInt4902 = this.anInt4901;
      this.anInt4901 = i;
   }

   final void method4201() {
      int i = this.method4190();
      int i_106_ = this.method4196();
      if (this.anInt4897 != i || this.anInt4900 != i_106_) {
         byte[] bs = new byte[i * i_106_];
         if (this.aByteArray4905 != null) {
            byte[] bs_107_ = new byte[i * i_106_];

            for(int i_108_ = 0; i_108_ < this.anInt4900; ++i_108_) {
               int i_109_ = i_108_ * this.anInt4897;
               int i_110_ = (i_108_ + this.anInt4898) * i + this.anInt4902;

               for(int i_111_ = 0; i_111_ < this.anInt4897; ++i_111_) {
                  bs[i_110_] = this.aByteArray4903[i_109_];
                  bs_107_[i_110_++] = this.aByteArray4905[i_109_++];
               }
            }

            this.aByteArray4905 = bs_107_;
         } else {
            for(int i_112_ = 0; i_112_ < this.anInt4900; ++i_112_) {
               int i_113_ = i_112_ * this.anInt4897;
               int i_114_ = (i_112_ + this.anInt4898) * i + this.anInt4902;

               for(int i_115_ = 0; i_115_ < this.anInt4897; ++i_115_) {
                  bs[i_114_++] = this.aByteArray4903[i_113_++];
               }
            }
         }

         this.anInt4902 = this.anInt4901 = this.anInt4898 = this.anInt4899 = 0;
         this.anInt4897 = i;
         this.anInt4900 = i_106_;
         this.aByteArray4903 = bs;
      }
   }
}
