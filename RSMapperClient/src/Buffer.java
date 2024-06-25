class Buffer extends Node {
   static int anInt6952;
   static int anInt6953;
   static int anInt6954;
   static int anInt6955;
   static int anInt6956;
   static int anInt6957;
   static int anInt6958;
   static int anInt6959;
   static int anInt6960;
   static int anInt6961;
   static int anInt6962;
   static int anInt6963;
   static int anInt6964;
   static int anInt6965;
   static int anInt6966;
   static int anInt6967;
   static int anInt6968;
   static int anInt6969;
   static int anInt6970;
   static int anInt6971;
   static int anInt6972;
   static int anInt6973;
   static int anInt6974;
   static int anInt6975;
   static int anInt6976;
   static int anInt6977;
   static int anInt6978;
   static int anInt6979;
   static int anInt6980;
   static int anInt6981;
   static int anInt6982;
   static int anInt6983;
   static int anInt6984;
   static int anInt6985;
   static int anInt6986;
   static int anInt6987;
   static int anInt6988;
   static int anInt6989;
   static int anInt6990;
   static int anInt6991;
   static int anInt6992;
   static int anInt6993;
   static int anInt6994;
   static int anInt6995;
   static int anInt6996;
   static int anInt6997;
   static int anInt6998;
   static int anInt6999;
   static int anInt7000;
   static int anInt7001;
   protected int offset;
   static int anInt7003;
   static int anInt7004;
   static int anInt7005;
   static int anInt7006;
   static int anInt7007;
   static int anInt7008;
   static int anInt7009;
   static int anInt7010;
   static int anInt7011;
   static int anInt7012;
   static int anInt7013;
   static IncommingPacket aClass192_7014 = new IncommingPacket(136, 6);
   static int anInt7015;
   static int anInt7016;
   static int anInt7017;
   static int anInt7018;
   protected byte[] buffer;
   static int anInt7020;
   static int anInt7021;
   static int anInt7022;
   static int anInt7023;
   static int anInt7024;
   static int anInt7025;

   final int readIntLE() {
      this.offset += 4;
      return (0xFF & this.buffer[-4 + this.offset])
         + ((0xFF & this.buffer[-2 + this.offset]) << 16)
         + (this.buffer[-1 + this.offset] << 24 & 0xFF000000)
         - -((0xFF & this.buffer[-3 + this.offset]) << 8);
   }

   final int readIntV1() {
      this.offset += 4;
      return ((this.buffer[this.offset + -1] & 0xFF) << 16)
         + (this.buffer[this.offset - 2] << 24 & 0xFF000000)
         - (-((this.buffer[-4 + this.offset] & 0xFF) << 8) + -(this.buffer[-3 + this.offset] & 0xFF));
   }

   final void writeByteC(int i) {
      this.buffer[this.offset++] = (byte)(-i);
   }

   final void writeInt(int i) {
      this.buffer[this.offset++] = (byte)(i >> 24);
      this.buffer[this.offset++] = (byte)(i >> 16);
      this.buffer[this.offset++] = (byte)(i >> 8);
      this.buffer[this.offset++] = (byte)i;
   }

   final String method2180(byte b) {
      ++anInt7025;
      byte b_0_ = this.buffer[this.offset++];
      if (b_0_ != 0) {
         throw new IllegalStateException("Bad version number in gjstr2");
      } else {
         int i = this.offset;

         while(this.buffer[this.offset++] != 0) {
         }

         int i_2_ = this.offset + -i + -1;
         return ~i_2_ == -1 ? "" : Class184.method1846(i, this.buffer, i_2_, (byte)-127);
      }
   }

   final void readBytes(byte[] data, int dataStartOffset, int length) {
      for(int dataOffset = dataStartOffset; dataOffset < length + dataStartOffset; ++dataOffset) {
         data[dataOffset] = this.buffer[this.offset++];
      }
   }

   final int method2183() {
      if (this.buffer[this.offset] < 0) {
         return this.readInt() & 2147483647;
      } else {
         int i = this.readUnsignedShort();
         return ~i == -32768 ? -1 : i;
      }
   }

   final void writeIntV2(int i) {
      this.buffer[this.offset++] = (byte)(i >> 16);
      this.buffer[this.offset++] = (byte)(i >> 24);
      this.buffer[this.offset++] = (byte)i;
      this.buffer[this.offset++] = (byte)(i >> 8);
   }

   final byte read128Byte() {
      return (byte)(128 - this.buffer[this.offset++]);
   }

   final int readInt() {
      this.offset += 4;
      return ((0xFF & this.buffer[this.offset + -4]) << 24)
         - (-((0xFF & this.buffer[-3 + this.offset]) << 16) - (this.buffer[this.offset - 2] << 8 & 0xFF00) - (this.buffer[-1 + this.offset] & 0xFF));
   }

   final void writeIntV1(int i) {
      this.buffer[this.offset++] = (byte)(i >> 8);
      this.buffer[this.offset++] = (byte)i;
      this.buffer[this.offset++] = (byte)(i >> 24);
      this.buffer[this.offset++] = (byte)(i >> 16);
   }

   final int method2188(int i) {
      if (i <= 110) {
         return 97;
      } else {
         ++anInt7008;
         this.offset += 4;
         return (0xFF & this.buffer[-4 + this.offset])
            + (this.buffer[this.offset + -1] << 24 & 0xFF000000)
            + ((this.buffer[-2 + this.offset] & 0xFF) << 16)
            - -(0xFF00 & this.buffer[this.offset + -3] << 8);
      }
   }

   final int method2190(int i, boolean bool) {
      if (bool) {
         anInt7023 = -121;
      }

      ++anInt6979;
      int i_10_ = Class10.method188((byte)-58, this.offset, i, this.buffer);
      this.writeInt(i_10_);
      return i_10_;
   }

   final void method2191(int i, int i_11_) {
      this.buffer[this.offset++] = (byte)i_11_;
      ++anInt6981;
      if (i <= -24) {
         this.buffer[this.offset++] = (byte)(i_11_ >> 8);
      }
   }

   final void method2192(int[] is, int i) {
      if (i <= 96) {
         anInt7023 = -75;
      }

      ++anInt6985;
      int i_12_ = this.offset / 8;
      this.offset = 0;

      for(int i_13_ = 0; i_12_ > i_13_; ++i_13_) {
         int i_14_ = this.readInt();
         int i_15_ = this.readInt();
         int i_16_ = -957401312;
         int i_17_ = -1640531527;

         for(int i_18_ = 32; i_18_-- > 0; i_14_ -= i_16_ + is[i_16_ & 3] ^ i_15_ + (i_15_ << 4 ^ i_15_ >>> 5)) {
            i_15_ -= (i_14_ >>> 5 ^ i_14_ << 4) - -i_14_ ^ i_16_ - -is[(i_16_ & 6196) >>> 11];
            i_16_ -= i_17_;
         }

         this.offset -= 8;
         this.writeInt(i_14_);
         this.writeInt(i_15_);
      }
   }

   final int readShort() {
      this.offset += 2;
      int i_19_ = (255 & this.buffer[-1 + this.offset]) + ((this.buffer[-2 + this.offset] & 255) << 8);
      if (~i_19_ < -32768) {
         i_19_ -= 65536;
      }

      return i_19_;
   }

   final void method2194(int i, int i_20_) {
      ++anInt6988;
      this.buffer[this.offset + -i - 2] = (byte)(i >> 8);
      this.buffer[-1 + this.offset - i] = (byte)i;
      if (i_20_ != -2887) {
         this.readString2();
      }
   }

   final String readString() {
      int i_21_ = this.offset;

      while(~this.buffer[this.offset++] != -1) {
      }

      int i_22_ = this.offset + -i_21_ - 1;
      return i_22_ == 0 ? "" : Class184.method1846(i_21_, this.buffer, i_22_, (byte)-118);
   }

   final long method2196(byte b) {
      if (b != -104) {
         return -23L;
      } else {
         ++anInt7003;
         long l = 4294967295L & (long)this.method2188(114);
         long l_23_ = 4294967295L & (long)this.method2188(112);
         return l + (l_23_ << 32);
      }
   }

   final int method2197(int i) {
      ++anInt6975;
      int i_24_ = this.buffer[this.offset] & 255;
      return ~i_24_ > i ? this.readUnsignedByte() - 64 : -49152 + this.readUnsignedShort();
   }

   final void writeJagString(String string, int i) {
      ++anInt6977;
      int i_26_ = string.indexOf(0);
      if (i_26_ >= 0) {
         throw new IllegalArgumentException("NUL character at " + i_26_ + " - cannot pjstr2");
      } else {
         this.buffer[this.offset++] = 0;
         this.offset += Class173.method1801(string, string.length(), this.buffer, true, this.offset, 0);
         this.buffer[this.offset++] = 0;
      }
   }

   final void writeShortLE(int i) {
      this.buffer[this.offset++] = (byte)i;
      this.buffer[this.offset++] = (byte)(i >> 8);
   }

   final void writeLong(long l) {
      this.buffer[this.offset++] = (byte)((int)(l >> 56));
      ++anInt6986;
      this.buffer[this.offset++] = (byte)((int)(l >> 48));
      this.buffer[this.offset++] = (byte)((int)(l >> 40));
      this.buffer[this.offset++] = (byte)((int)(l >> 32));
      this.buffer[this.offset++] = (byte)((int)(l >> 24));
      this.buffer[this.offset++] = (byte)((int)(l >> 16));
      this.buffer[this.offset++] = (byte)((int)(l >> 8));
      this.buffer[this.offset++] = (byte)((int)l);
   }

   final void method2202(int i) {
      ++anInt7011;
      if (this.buffer != null) {
         Class111.method1137(this.buffer, -251);
      }

      this.buffer = null;
   }

   final void encryptXteas(int[] is, int i, boolean bool, int i_29_) {
      ++anInt7012;
      int i_30_ = this.offset;
      this.offset = i;
      int i_31_ = (i_29_ - i) / 8;

      for(int i_32_ = 0; i_32_ < i_31_; ++i_32_) {
         int i_33_ = this.readInt();
         int i_34_ = this.readInt();
         int i_35_ = 0;
         int i_36_ = -1640531527;

         for(int i_37_ = 32; ~(i_37_--) < -1; i_34_ += (i_33_ >>> 5 ^ i_33_ << 4) + i_33_ ^ i_35_ + is[i_35_ >>> 11 & -390070269]) {
            i_33_ += i_34_ + (i_34_ << 4 ^ i_34_ >>> 5) ^ i_35_ + is[3 & i_35_];
            i_35_ += i_36_;
         }

         this.offset -= 8;
         this.writeInt(i_33_);
         this.writeInt(i_34_);
      }

      if (bool) {
         this.readUnsignedByteC();
      }

      this.offset = i_30_;
   }

   final void method2204(int i, byte b) {
      ++anInt6999;
      this.buffer[-i + this.offset + -4] = (byte)(i >> 24);
      this.buffer[-3 + -i + this.offset] = (byte)(i >> 16);
      this.buffer[this.offset - i + -2] = (byte)(i >> 8);
      this.buffer[this.offset + -i - 1] = (byte)i;
      if (b < 126) {
         method2205(-97, null, null);
      }
   }

   static final void method2205(int i, Node node, Node node_38_) {
      if (node_38_.aNode2799 != null) {
         node_38_.method2160((byte)31);
      }

      ++anInt6960;
      node_38_.aNode2800 = node;
      node_38_.aNode2799 = node.aNode2799;
      node_38_.aNode2799.aNode2800 = node_38_;
      node_38_.aNode2800.aNode2799 = node_38_;
   }

   final void method2206(byte b, int i, long l) {
      --i;
      ++anInt7010;
      if (b <= 112) {
         this.buffer = null;
      }

      if (i >= 0 && ~i >= -8) {
         for(int i_40_ = 8 * i; i_40_ >= 0; i_40_ -= 8) {
            this.buffer[this.offset++] = (byte)((int)(l >> i_40_));
         }
      } else {
         throw new IllegalArgumentException();
      }
   }

   final void writeShortLE128(int i) {
      this.buffer[this.offset++] = (byte)(i + 128);
      this.buffer[this.offset++] = (byte)(i >> 8);
   }

   final int readIntV2() {
      this.offset += 4;
      return (this.buffer[this.offset + -4] << 16 & 0xFF0000)
         + ((this.buffer[this.offset + -3] & 0xFF) << 24)
         - -((0xFF & this.buffer[this.offset + -1]) << 8)
         - -(this.buffer[this.offset - 2] & 0xFF);
   }

   final int readUnsignedShortLE() {
      this.offset += 2;
      return (0xFF & this.buffer[this.offset - 2]) + ((0xFF & this.buffer[this.offset - 1]) << 8);
   }

   final void writeShort(int i) {
      this.buffer[this.offset++] = (byte)(i >> 8);
      this.buffer[this.offset++] = (byte)i;
   }

   final int readUnsignedByte128() {
      return this.buffer[this.offset++] + -128 & 0xFF;
   }

   final int readShortLE128() {
      this.offset += 2;
      int i_43_ = (this.buffer[this.offset + -1] << 8 & 0xFF00) + (0xFF & this.buffer[-2 + this.offset] - 128);
      if (i_43_ > 32767) {
         i_43_ -= 65536;
      }

      return i_43_;
   }

   final int readUnsigned128Byte() {
      return 0xFF & -this.buffer[this.offset++] + 128;
   }

   final byte readByte() {
      return this.buffer[this.offset++];
   }

   final void writeIntLE(int i) {
      this.buffer[this.offset++] = (byte)i;
      this.buffer[this.offset++] = (byte)(i >> 8);
      this.buffer[this.offset++] = (byte)(i >> 16);
      this.buffer[this.offset++] = (byte)(i >> 24);
   }

   final boolean method2216(int i) {
      ++anInt6995;
      this.offset -= 4;
      int i_45_ = Class10.method188((byte)-58, this.offset, i, this.buffer);
      int i_46_ = this.readInt();
      return i_45_ == i_46_;
   }

   final void method2217(int i) {
      this.buffer[this.offset - (i + 1)] = (byte)i;
   }

   final int method2218(int i) {
      this.offset += 2;
      ++anInt6976;
      int i_48_ = (255 & this.buffer[-2 + this.offset]) + (this.buffer[this.offset - 1] << 8 & 0xFF00);
      if (i_48_ > 32767) {
         i_48_ -= 65536;
      }

      return i_48_;
   }

   final int readUnsignedShort() {
      this.offset += 2;
      return (0xFF & this.buffer[-1 + this.offset]) + ((this.buffer[-2 + this.offset] & 0xFF) << 8);
   }

   final int read24BitInteger() {
      this.offset += 3;
      return ((this.buffer[this.offset - 2] & 0xFF) << 8) + ((0xFF & this.buffer[this.offset - 3]) << 16) - -(this.buffer[-1 + this.offset] & 0xFF);
   }

   final void writeByte128(int i) {
      this.buffer[this.offset++] = (byte)(i + 128);
   }

   final void encodeRSA() {
   }

   final void writeBytes(int i, byte[] bs, int i_54_) {
      for(int i_55_ = i_54_; i + i_54_ > i_55_; ++i_55_) {
         this.buffer[this.offset++] = bs[i_55_];
      }
   }

   final int readUnsignedShort128() {
      this.offset += 2;
      return (0xFF00 & this.buffer[this.offset + -2] << 8) + (-128 + this.buffer[this.offset - 1] & 0xFF);
   }

   final void write24BitInt(byte b, int i) {
      this.buffer[this.offset++] = (byte)(i >> 16);
      ++anInt6990;
      this.buffer[this.offset++] = (byte)(i >> 8);
      if (b < 54) {
         this.writeIntV1(89);
      }

      this.buffer[this.offset++] = (byte)i;
   }

   final void writeByte(int i) {
      this.buffer[this.offset++] = (byte)i;
   }

   final void writeSmart(int i, int i_9_) {
      ++anInt6968;
      if (i_9_ != 32768) {
         this.method2197(71);
      }

      if (i >= 0 && i < 128) {
         this.writeByte(i);
      } else {
         if (i < 0 || i >= 32768) {
            throw new IllegalArgumentException();
         }

         this.writeShort(i + 32768);
      }
   }

   final int readSmart() {
      int i = this.buffer[this.offset] & 255;
      return i < 128 ? this.readUnsignedByte() : this.readUnsignedShort() + -32768;
   }

   final int readSmart2(boolean bool) {
      ++anInt6964;
      int i = 0;

      int i_6_;
      for(i_6_ = this.readSmart(); i_6_ == 32767; i_6_ = this.readSmart()) {
         i += 32767;
      }

      i += i_6_;
      if (!bool) {
         this.buffer = null;
      }

      return i;
   }

   final int readBigSmart() {
      if (-1 < ~this.buffer[this.offset]) {
         return 2147483647 & this.readInt();
      } else {
         int i = this.readUnsignedShort();
         return 32767 == i ? -1 : i;
      }
   }

   final void writeString(String string) {
      ++anInt6963;
      int i_56_ = string.indexOf(0);
      if (i_56_ >= 0) {
         throw new IllegalArgumentException("NUL character at " + i_56_ + " - cannot pjstr");
      } else {
         this.offset += Class173.method1801(string, string.length(), this.buffer, true, this.offset, 0);
         this.buffer[this.offset++] = 0;
      }
   }

   final int read24BitInteger(byte b) {
      ++anInt7000;
      this.offset += 3;
      int i = (255 & this.buffer[-1 + this.offset]) + ((255 & this.buffer[-3 + this.offset]) << 16) + ((this.buffer[-2 + this.offset] & 255) << 8);
      if (~i < -8388608) {
         i -= 16777216;
      }

      return i;
   }

   final void writeShort128(int i) {
      this.buffer[this.offset++] = (byte)(i >> 8);
      this.buffer[this.offset++] = (byte)(128 + i);
   }

   final void method2231(int i, int[] is, int i_59_, int i_60_) {
      ++anInt6970;
      int i_61_ = this.offset;
      this.offset = i;
      int i_62_ = (-i + i_59_) / 8;
      if (i_60_ != -4901) {
         this.method2246(-11);
      }

      for(int i_63_ = 0; i_63_ < i_62_; ++i_63_) {
         int i_64_ = this.readInt();
         int i_65_ = this.readInt();
         int i_66_ = -957401312;
         int i_67_ = -1640531527;

         for(int i_68_ = 32; i_68_-- > 0; i_64_ -= i_65_ + (i_65_ >>> 5 ^ i_65_ << 4) ^ i_66_ - -is[i_66_ & 3]) {
            i_65_ -= (i_64_ << 4 ^ i_64_ >>> 5) + i_64_ ^ is[(7931 & i_66_) >>> 11] + i_66_;
            i_66_ -= i_67_;
         }

         this.offset -= 8;
         this.writeInt(i_64_);
         this.writeInt(i_65_);
      }

      this.offset = i_61_;
   }

   final void method2232(int i, int i_69_) {
      if (~(i_69_ & -128) != -1) {
         if (~(i_69_ & -16384) != -1) {
            if ((-2097152 & i_69_) != 0) {
               if (~(-268435456 & i_69_) != -1) {
                  this.writeByte(i_69_ >>> 28 | 128);
               }

               this.writeByte((i_69_ | 269660370) >>> 21);
            }

            this.writeByte((i_69_ | 2113347) >>> 14);
         }

         this.writeByte((i_69_ | 16442) >>> 7);
      }

      ++anInt7022;
      this.writeByte(127 & i_69_);
      if (i != 65280) {
         this.readLong();
      }
   }

   final int readUnsignedByte() {
      return this.buffer[this.offset++] & 0xFF;
   }

   public static void method2234(boolean bool) {
      aClass192_7014 = null;
      if (!bool) {
         method2205(-95, null, null);
      }
   }

   final long readLong() {
      long l = 4294967295L & (long)this.readInt();
      long l_70_ = 4294967295L & (long)this.readInt();
      return l_70_ + (l << 32);
   }

   final byte readByteC() {
      return (byte)(-this.buffer[this.offset++]);
   }

   final void method2237(int i, int i_71_) {
      ++anInt6958;
      if (i != 0) {
         this.buffer = null;
      }

      this.buffer[this.offset++] = (byte)i_71_;
      this.buffer[this.offset++] = (byte)(i_71_ >> 8);
      this.buffer[this.offset++] = (byte)(i_71_ >> 16);
      this.buffer[this.offset++] = (byte)(i_71_ >> 24);
   }

   final int readUnsignedByteC() {
      return 0xFF & -this.buffer[this.offset++];
   }

   final int method2239(int i) {
      ++anInt6962;
      int i_72_ = this.buffer[this.offset++];

      int i_73_;
      for(i_73_ = i; i_72_ < 0; i_72_ = this.buffer[this.offset++]) {
         i_73_ = (i_73_ | 127 & i_72_) << 7;
      }

      return i_72_ | i_73_;
   }

   final String readString2() {
      if (this.buffer[this.offset] == 0) {
         ++this.offset;
         return null;
      } else {
         return this.readString();
      }
   }

   final long method2241(int i) {
      ++anInt6998;
      if (i > -53) {
         return -50L;
      } else {
         long l = 4294967295L & (long)this.readUnsignedByte();
         long l_74_ = 4294967295L & (long)this.readInt();
         return l_74_ + (l << 32);
      }
   }

   Buffer(int i) {
      this.offset = 0;
      this.buffer = Class111.method1139(true, i);
   }

   final byte readByte128() {
      return (byte)(this.buffer[this.offset++] - 128);
   }

   final int readUnsignedShortLE128() {
      this.offset += 2;
      return (-128 + this.buffer[this.offset - 2] & 0xFF) + ((0xFF & this.buffer[this.offset - 1]) << 8);
   }

   final long method2244(int i, int i_75_) {
      ++anInt7020;
      --i;
      if (~i <= -1 && i <= 7) {
         int i_76_ = i * i_75_;

         long l;
         for(l = 0L; i_76_ >= 0; i_76_ -= 8) {
            l |= (255L & (long)this.buffer[this.offset++]) << i_76_;
         }

         return l;
      } else {
         throw new IllegalArgumentException();
      }
   }

   Buffer(byte[] bs) {
      this.buffer = bs;
      this.offset = 0;
   }

   final void write128Byte(int i) {
      this.buffer[this.offset++] = (byte)(-i + 128);
   }

   final int method2246(int i) {
      ++anInt6967;
      if (i != -22301) {
         this.offset = -18;
      }

      this.offset += 3;
      return ((0xFF & this.buffer[this.offset - 3]) << 16) - (-(this.buffer[this.offset - 1] << 8 & 0xFF00) - (0xFF & this.buffer[-2 + this.offset]));
   }
}
