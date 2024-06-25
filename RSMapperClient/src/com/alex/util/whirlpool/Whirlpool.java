package com.alex.util.whirlpool;

import java.util.Arrays;

public class Whirlpool {
   public static final int DIGESTBITS = 512;
   public static final int DIGESTBYTES = 64;
   protected static final int R = 10;
   private static final String sbox = "\u1823\uC6E8\u87B8\u014F\u36A6\uD2F5\u796F\u9152\u60BC\u9B8E\uA30C\u7B35\u1DE0\uD7C2\u2E4B\uFE57\u1577\u37E5\u9FF0\u4ADA\u58C9\u290A\uB1A0\u6B85\uBD5D\u10F4\uCB3E\u0567\ue427\u418B\uA77D\u95D8\uFBEE\u7C66\udd17\u479E\uCA2D\uBF07\uAD5A\u8333\u6302\uAA71\uC819\u49D9\uf2e3\u5B88\u9A26\u32B0\ue90f\uD580\uBECD\u3448\uFF7A\u905F\u2068\u1aae\uB454\u9322\u64F1\u7312\u4008\uC3EC\udba1\u8D3D\u9700\uCF2B\u7682\uD61B\uB5AF\u6A50\u45F3\u30EF\u3F55\uA2EA\u65BA\u2FC0\ude1c\uFD4D\u9275\u068A\uB2E6\u0E1F\u62D4\uA896\uF9C5\u2559\u8472\u394C\u5E78\u388C\uD1A5\ue261\uB321\u9C1E\u43C7\uFC04\u5199\u6D0D\ufadf\u7E24\u3BAB\uCE11\u8F4E\uB7EB\u3C81\u94F7\uB913\u2CD3\ue76e\uC403\u5644\u7FA9\u2ABB\uC153\udc0b\u9D6C\u3174\uf646\uAC89\u14E1\u163A\u6909\u70B6\uD0ED\uCC42\u98A4\u285C\uf886";
   private static long[][] C = new long[8][256];
   private static long[] rc = new long[11];
   protected byte[] bitLength = new byte[32];
   protected byte[] buffer = new byte[64];
   protected int bufferBits = 0;
   protected int bufferPos = 0;
   protected long[] hash = new long[8];
   protected long[] K = new long[8];
   protected long[] L = new long[8];
   protected long[] block = new long[8];
   protected long[] state = new long[8];

   static {
      for(int x = 0; x < 256; ++x) {
         char c = "\u1823\uC6E8\u87B8\u014F\u36A6\uD2F5\u796F\u9152\u60BC\u9B8E\uA30C\u7B35\u1DE0\uD7C2\u2E4B\uFE57\u1577\u37E5\u9FF0\u4ADA\u58C9\u290A\uB1A0\u6B85\uBD5D\u10F4\uCB3E\u0567\ue427\u418B\uA77D\u95D8\uFBEE\u7C66\udd17\u479E\uCA2D\uBF07\uAD5A\u8333\u6302\uAA71\uC819\u49D9\uf2e3\u5B88\u9A26\u32B0\ue90f\uD580\uBECD\u3448\uFF7A\u905F\u2068\u1aae\uB454\u9322\u64F1\u7312\u4008\uC3EC\udba1\u8D3D\u9700\uCF2B\u7682\uD61B\uB5AF\u6A50\u45F3\u30EF\u3F55\uA2EA\u65BA\u2FC0\ude1c\uFD4D\u9275\u068A\uB2E6\u0E1F\u62D4\uA896\uF9C5\u2559\u8472\u394C\u5E78\u388C\uD1A5\ue261\uB321\u9C1E\u43C7\uFC04\u5199\u6D0D\ufadf\u7E24\u3BAB\uCE11\u8F4E\uB7EB\u3C81\u94F7\uB913\u2CD3\ue76e\uC403\u5644\u7FA9\u2ABB\uC153\udc0b\u9D6C\u3174\uf646\uAC89\u14E1\u163A\u6909\u70B6\uD0ED\uCC42\u98A4\u285C\uf886"
            .charAt(x / 2);
         long v1 = (long)((x & 1) == 0 ? c >>> '\b' : c & 255);
         long v2 = v1 << 1;
         if (v2 >= 256L) {
            v2 ^= 285L;
         }

         long v4 = v2 << 1;
         if (v4 >= 256L) {
            v4 ^= 285L;
         }

         long v5 = v4 ^ v1;
         long v8 = v4 << 1;
         if (v8 >= 256L) {
            v8 ^= 285L;
         }

         long v9 = v8 ^ v1;
         C[0][x] = v1 << 56 | v1 << 48 | v4 << 40 | v1 << 32 | v8 << 24 | v5 << 16 | v2 << 8 | v9;

         for(int t = 1; t < 8; ++t) {
            C[t][x] = C[t - 1][x] >>> 8 | C[t - 1][x] << 56;
         }
      }

      rc[0] = 0L;

      for(int r = 1; r <= 10; ++r) {
         int i = 8 * (r - 1);
         rc[r] = C[0][i] & -72057594037927936L
            ^ C[1][i + 1] & 71776119061217280L
            ^ C[2][i + 2] & 280375465082880L
            ^ C[3][i + 3] & 1095216660480L
            ^ C[4][i + 4] & 4278190080L
            ^ C[5][i + 5] & 16711680L
            ^ C[6][i + 6] & 65280L
            ^ C[7][i + 7] & 255L;
      }
   }

   public static byte[] getHash(byte[] data, int off, int len) {
      byte[] source;
      if (off <= 0) {
         source = data;
      } else {
         source = new byte[len];

         for(int i = 0; i < len; ++i) {
            source[i] = data[off + i];
         }
      }

      Whirlpool whirlpool = new Whirlpool();
      whirlpool.NESSIEinit();
      whirlpool.NESSIEadd(source, (long)(len * 8));
      byte[] digest = new byte[64];
      whirlpool.NESSIEfinalize(digest);
      return digest;
   }

   protected void processBuffer() {
      int i = 0;

      for(int j = 0; i < 8; j += 8) {
         this.block[i] = (long)this.buffer[j] << 56
            ^ ((long)this.buffer[j + 1] & 255L) << 48
            ^ ((long)this.buffer[j + 2] & 255L) << 40
            ^ ((long)this.buffer[j + 3] & 255L) << 32
            ^ ((long)this.buffer[j + 4] & 255L) << 24
            ^ ((long)this.buffer[j + 5] & 255L) << 16
            ^ ((long)this.buffer[j + 6] & 255L) << 8
            ^ (long)this.buffer[j + 7] & 255L;
         ++i;
      }

      for(int ix = 0; ix < 8; ++ix) {
         this.state[ix] = this.block[ix] ^ (this.K[ix] = this.hash[ix]);
      }

      for(int r = 1; r <= 10; ++r) {
         for(int ix = 0; ix < 8; ++ix) {
            this.L[ix] = 0L;
            int t = 0;

            for(int s = 56; t < 8; s -= 8) {
               this.L[ix] ^= C[t][(int)(this.K[ix - t & 7] >>> s) & 0xFF];
               ++t;
            }
         }

         for(int ix = 0; ix < 8; ++ix) {
            this.K[ix] = this.L[ix];
         }

         this.K[0] ^= rc[r];

         for(int ix = 0; ix < 8; ++ix) {
            this.L[ix] = this.K[ix];
            int t = 0;

            for(int s = 56; t < 8; s -= 8) {
               this.L[ix] ^= C[t][(int)(this.state[ix - t & 7] >>> s) & 0xFF];
               ++t;
            }
         }

         for(int ix = 0; ix < 8; ++ix) {
            this.state[ix] = this.L[ix];
         }
      }

      for(int ix = 0; ix < 8; ++ix) {
         this.hash[ix] ^= this.state[ix] ^ this.block[ix];
      }
   }

   public void NESSIEinit() {
      Arrays.fill(this.bitLength, (byte)0);
      this.bufferBits = this.bufferPos = 0;
      this.buffer[0] = 0;
      Arrays.fill(this.hash, 0L);
   }

   public void NESSIEadd(byte[] source, long sourceBits) {
      int sourcePos = 0;
      int sourceGap = 8 - ((int)sourceBits & 7) & 7;
      int bufferRem = this.bufferBits & 7;
      long value = sourceBits;
      int i = 31;

      for(int carry = 0; i >= 0; --i) {
         carry += (this.bitLength[i] & 255) + ((int)value & 0xFF);
         this.bitLength[i] = (byte)carry;
         carry >>>= 8;
         value >>>= 8;
      }

      while(sourceBits > 8L) {
         int b = source[sourcePos] << sourceGap & 0xFF | (source[sourcePos + 1] & 255) >>> 8 - sourceGap;
         if (b < 0 || b >= 256) {
            throw new RuntimeException("LOGIC ERROR");
         }

         byte[] var10000 = this.buffer;
         int var10001 = this.bufferPos++;
         var10000[var10001] = (byte)(var10000[var10001] | b >>> bufferRem);
         this.bufferBits += 8 - bufferRem;
         if (this.bufferBits == 512) {
            this.processBuffer();
            this.bufferBits = this.bufferPos = 0;
         }

         this.buffer[this.bufferPos] = (byte)(b << 8 - bufferRem & 0xFF);
         this.bufferBits += bufferRem;
         sourceBits -= 8L;
         ++sourcePos;
      }

      int b;
      if (sourceBits > 0L) {
         b = source[sourcePos] << sourceGap & 0xFF;
         this.buffer[this.bufferPos] = (byte)(this.buffer[this.bufferPos] | b >>> bufferRem);
      } else {
         b = 0;
      }

      if ((long)bufferRem + sourceBits < 8L) {
         this.bufferBits = (int)((long)this.bufferBits + sourceBits);
      } else {
         ++this.bufferPos;
         this.bufferBits += 8 - bufferRem;
         sourceBits -= (long)(8 - bufferRem);
         if (this.bufferBits == 512) {
            this.processBuffer();
            this.bufferBits = this.bufferPos = 0;
         }

         this.buffer[this.bufferPos] = (byte)(b << 8 - bufferRem & 0xFF);
         this.bufferBits += (int)sourceBits;
      }
   }

   public void NESSIEfinalize(byte[] digest) {
      this.buffer[this.bufferPos] = (byte)(this.buffer[this.bufferPos] | 128 >>> (this.bufferBits & 7));
      ++this.bufferPos;
      if (this.bufferPos > 32) {
         while(this.bufferPos < 64) {
            this.buffer[this.bufferPos++] = 0;
         }

         this.processBuffer();
         this.bufferPos = 0;
      }

      while(this.bufferPos < 32) {
         this.buffer[this.bufferPos++] = 0;
      }

      System.arraycopy(this.bitLength, 0, this.buffer, 32, 32);
      this.processBuffer();
      int i = 0;

      for(int j = 0; i < 8; j += 8) {
         long h = this.hash[i];
         digest[j] = (byte)((int)(h >>> 56));
         digest[j + 1] = (byte)((int)(h >>> 48));
         digest[j + 2] = (byte)((int)(h >>> 40));
         digest[j + 3] = (byte)((int)(h >>> 32));
         digest[j + 4] = (byte)((int)(h >>> 24));
         digest[j + 5] = (byte)((int)(h >>> 16));
         digest[j + 6] = (byte)((int)(h >>> 8));
         digest[j + 7] = (byte)((int)h);
         ++i;
      }
   }

   public void NESSIEadd(String source) {
      if (source.length() > 0) {
         byte[] data = new byte[source.length()];

         for(int i = 0; i < source.length(); ++i) {
            data[i] = (byte)source.charAt(i);
         }

         this.NESSIEadd(data, (long)(8 * data.length));
      }
   }
}
