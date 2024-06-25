package org.apache.tools.bzip2;

import java.io.IOException;
import java.io.InputStream;

public class CBZip2InputStream extends InputStream implements BZip2Constants {
   private int last;
   private int origPtr;
   private int blockSize100k;
   private boolean blockRandomised;
   private int bsBuff;
   private int bsLive;
   private final CRC crc = new CRC();
   private int nInUse;
   private InputStream in;
   private int currentChar = -1;
   private static final int EOF = 0;
   private static final int START_BLOCK_STATE = 1;
   private static final int RAND_PART_A_STATE = 2;
   private static final int RAND_PART_B_STATE = 3;
   private static final int RAND_PART_C_STATE = 4;
   private static final int NO_RAND_PART_A_STATE = 5;
   private static final int NO_RAND_PART_B_STATE = 6;
   private static final int NO_RAND_PART_C_STATE = 7;
   private int currentState = 1;
   private int storedBlockCRC;
   private int storedCombinedCRC;
   private int computedBlockCRC;
   private int computedCombinedCRC;
   private int su_count;
   private int su_ch2;
   private int su_chPrev;
   private int su_i2;
   private int su_j2;
   private int su_rNToGo;
   private int su_rTPos;
   private int su_tPos;
   private char su_z;
   private CBZip2InputStream.Data data;

   private static void reportCRCError() throws IOException {
      throw new IOException("crc error");
   }

   private void makeMaps() {
      boolean[] inUse = this.data.inUse;
      byte[] seqToUnseq = this.data.seqToUnseq;
      int nInUseShadow = 0;

      for(int i = 0; i < 256; ++i) {
         if (inUse[i]) {
            seqToUnseq[nInUseShadow++] = (byte)i;
         }
      }

      this.nInUse = nInUseShadow;
   }

   public CBZip2InputStream(InputStream in) throws IOException {
      this.in = in;
      this.init();
   }

   @Override
   public int read() throws IOException {
      if (this.in != null) {
         return this.read0();
      } else {
         throw new IOException("stream closed");
      }
   }

   @Override
   public int read(byte[] dest, int offs, int len) throws IOException {
      if (offs < 0) {
         throw new IndexOutOfBoundsException("offs(" + offs + ") < 0.");
      } else if (len < 0) {
         throw new IndexOutOfBoundsException("len(" + len + ") < 0.");
      } else if (offs + len > dest.length) {
         throw new IndexOutOfBoundsException("offs(" + offs + ") + len(" + len + ") > dest.length(" + dest.length + ").");
      } else if (this.in == null) {
         throw new IOException("stream closed");
      } else {
         int hi = offs + len;
         int destOffs = offs;

         int b;
         while(destOffs < hi && (b = this.read0()) >= 0) {
            dest[destOffs++] = (byte)b;
         }

         return destOffs == offs ? -1 : destOffs - offs;
      }
   }

   private int read0() throws IOException {
      int retChar = this.currentChar;
      switch(this.currentState) {
         case 0:
            return -1;
         case 1:
            throw new IllegalStateException();
         case 2:
            throw new IllegalStateException();
         case 3:
            this.setupRandPartB();
            break;
         case 4:
            this.setupRandPartC();
            break;
         case 5:
            throw new IllegalStateException();
         case 6:
            this.setupNoRandPartB();
            break;
         case 7:
            this.setupNoRandPartC();
            break;
         default:
            throw new IllegalStateException();
      }

      return retChar;
   }

   private void init() throws IOException {
      if (this.in == null) {
         throw new IOException("No InputStream");
      } else if (this.in.available() == 0) {
         throw new IOException("Empty InputStream");
      } else {
         int magic2 = this.in.read();
         if (magic2 != 104) {
            throw new IOException("Stream is not BZip2 formatted: expected 'h' as first byte but got '" + (char)magic2 + "'");
         } else {
            int blockSize = this.in.read();
            if (blockSize >= 49 && blockSize <= 57) {
               this.blockSize100k = blockSize - 48;
               this.initBlock();
               this.setupBlock();
            } else {
               throw new IOException("Stream is not BZip2 formatted: illegal blocksize " + (char)blockSize);
            }
         }
      }
   }

   private void initBlock() throws IOException {
      char magic0 = this.bsGetUByte();
      char magic1 = this.bsGetUByte();
      char magic2 = this.bsGetUByte();
      char magic3 = this.bsGetUByte();
      char magic4 = this.bsGetUByte();
      char magic5 = this.bsGetUByte();
      if (magic0 == 23 && magic1 == 'r' && magic2 == 'E' && magic3 == '8' && magic4 == 'P' && magic5 == 144) {
         this.complete();
      } else {
         if (magic0 != '1' || magic1 != 'A' || magic2 != 'Y' || magic3 != '&' || magic4 != 'S' || magic5 != 'Y') {
            this.currentState = 0;
            throw new IOException("bad block header");
         }

         this.storedBlockCRC = this.bsGetInt();
         this.blockRandomised = this.bsR(1) == 1;
         if (this.data == null) {
            this.data = new CBZip2InputStream.Data(this.blockSize100k);
         }

         this.getAndMoveToFrontDecode();
         this.crc.initialiseCRC();
         this.currentState = 1;
      }
   }

   private void endBlock() throws IOException {
      this.computedBlockCRC = this.crc.getFinalCRC();
      if (this.storedBlockCRC != this.computedBlockCRC) {
         this.computedCombinedCRC = this.storedCombinedCRC << 1 | this.storedCombinedCRC >>> 31;
         this.computedCombinedCRC ^= this.storedBlockCRC;
         reportCRCError();
      }

      this.computedCombinedCRC = this.computedCombinedCRC << 1 | this.computedCombinedCRC >>> 31;
      this.computedCombinedCRC ^= this.computedBlockCRC;
   }

   private void complete() throws IOException {
      this.storedCombinedCRC = this.bsGetInt();
      this.currentState = 0;
      this.data = null;
      if (this.storedCombinedCRC != this.computedCombinedCRC) {
         reportCRCError();
      }
   }

   @Override
   public void close() throws IOException {
      InputStream inShadow = this.in;
      if (inShadow != null) {
         try {
            if (inShadow != System.in) {
               inShadow.close();
            }
         } finally {
            this.data = null;
            this.in = null;
         }
      }
   }

   private int bsR(int n) throws IOException {
      int bsLiveShadow = this.bsLive;
      int bsBuffShadow = this.bsBuff;
      if (bsLiveShadow < n) {
         InputStream inShadow = this.in;

         do {
            int thech = inShadow.read();
            if (thech < 0) {
               throw new IOException("unexpected end of stream");
            }

            bsBuffShadow = bsBuffShadow << 8 | thech;
            bsLiveShadow += 8;
         } while(bsLiveShadow < n);

         this.bsBuff = bsBuffShadow;
      }

      this.bsLive = bsLiveShadow - n;
      return bsBuffShadow >> bsLiveShadow - n & (1 << n) - 1;
   }

   private boolean bsGetBit() throws IOException {
      int bsLiveShadow = this.bsLive;
      int bsBuffShadow = this.bsBuff;
      if (bsLiveShadow < 1) {
         int thech = this.in.read();
         if (thech < 0) {
            throw new IOException("unexpected end of stream");
         }

         bsBuffShadow = bsBuffShadow << 8 | thech;
         bsLiveShadow += 8;
         this.bsBuff = bsBuffShadow;
      }

      this.bsLive = bsLiveShadow - 1;
      return (bsBuffShadow >> bsLiveShadow - 1 & 1) != 0;
   }

   private char bsGetUByte() throws IOException {
      return (char)this.bsR(8);
   }

   private int bsGetInt() throws IOException {
      return ((this.bsR(8) << 8 | this.bsR(8)) << 8 | this.bsR(8)) << 8 | this.bsR(8);
   }

   private static void hbCreateDecodeTables(int[] limit, int[] base, int[] perm, char[] length, int minLen, int maxLen, int alphaSize) {
      int i = minLen;

      for(int pp = 0; i <= maxLen; ++i) {
         for(int j = 0; j < alphaSize; ++j) {
            if (length[j] == i) {
               perm[pp++] = j;
            }
         }
      }

      for(int ix = 23; --ix > 0; limit[ix] = 0) {
         base[ix] = 0;
      }

      for(int ix = 0; ix < alphaSize; ++ix) {
         base[length[ix] + 1]++;
      }

      i = 1;

      for(int b = base[0]; i < 23; ++i) {
         b += base[i];
         base[i] = b;
      }

      i = minLen;
      int vec = 0;

      for(int b = base[minLen]; i <= maxLen; ++i) {
         int nb = base[i + 1];
         vec += nb - b;
         b = nb;
         limit[i] = vec - 1;
         vec <<= 1;
      }

      for(int ix = minLen + 1; ix <= maxLen; ++ix) {
         base[ix] = (limit[ix - 1] + 1 << 1) - base[ix];
      }
   }

   private void recvDecodingTables() throws IOException {
      CBZip2InputStream.Data dataShadow = this.data;
      boolean[] inUse = dataShadow.inUse;
      byte[] pos = dataShadow.recvDecodingTables_pos;
      byte[] selector = dataShadow.selector;
      byte[] selectorMtf = dataShadow.selectorMtf;
      int inUse16 = 0;

      for(int i = 0; i < 16; ++i) {
         if (this.bsGetBit()) {
            inUse16 |= 1 << i;
         }
      }

      int i = 256;

      while(--i >= 0) {
         inUse[i] = false;
      }

      for(int ix = 0; ix < 16; ++ix) {
         if ((inUse16 & 1 << ix) != 0) {
            int i16 = ix << 4;

            for(int j = 0; j < 16; ++j) {
               if (this.bsGetBit()) {
                  inUse[i16 + j] = true;
               }
            }
         }
      }

      this.makeMaps();
      i = this.nInUse + 2;
      int nGroups = this.bsR(3);
      int nSelectors = this.bsR(15);

      for(int ix = 0; ix < nSelectors; ++ix) {
         int j = 0;

         while(this.bsGetBit()) {
            ++j;
         }

         selectorMtf[ix] = (byte)j;
      }

      int v = nGroups;

      while(--v >= 0) {
         pos[v] = (byte)v;
      }

      for(int ix = 0; ix < nSelectors; ++ix) {
         int vx = selectorMtf[ix] & 255;

         byte tmp;
         for(tmp = pos[vx]; vx > 0; --vx) {
            pos[vx] = pos[vx - 1];
         }

         pos[0] = tmp;
         selector[ix] = tmp;
      }

      char[][] len = dataShadow.temp_charArray2d;

      for(int t = 0; t < nGroups; ++t) {
         int curr = this.bsR(5);
         char[] len_t = len[t];

         for(int ix = 0; ix < i; ++ix) {
            while(this.bsGetBit()) {
               curr += this.bsGetBit() ? -1 : 1;
            }

            len_t[ix] = (char)curr;
         }
      }

      this.createHuffmanDecodingTables(i, nGroups);
   }

   private void createHuffmanDecodingTables(int alphaSize, int nGroups) {
      CBZip2InputStream.Data dataShadow = this.data;
      char[][] len = dataShadow.temp_charArray2d;
      int[] minLens = dataShadow.minLens;
      int[][] limit = dataShadow.limit;
      int[][] base = dataShadow.base;
      int[][] perm = dataShadow.perm;

      for(int t = 0; t < nGroups; ++t) {
         int minLen = 32;
         int maxLen = 0;
         char[] len_t = len[t];
         int i = alphaSize;

         while(--i >= 0) {
            char lent = len_t[i];
            if (lent > maxLen) {
               maxLen = lent;
            }

            if (lent < minLen) {
               minLen = lent;
            }
         }

         hbCreateDecodeTables(limit[t], base[t], perm[t], len[t], minLen, maxLen, alphaSize);
         minLens[t] = minLen;
      }
   }

   private void getAndMoveToFrontDecode() throws IOException {
      this.origPtr = this.bsR(24);
      this.recvDecodingTables();
      InputStream inShadow = this.in;
      CBZip2InputStream.Data dataShadow = this.data;
      byte[] ll8 = dataShadow.ll8;
      int[] unzftab = dataShadow.unzftab;
      byte[] selector = dataShadow.selector;
      byte[] seqToUnseq = dataShadow.seqToUnseq;
      char[] yy = dataShadow.getAndMoveToFrontDecode_yy;
      int[] minLens = dataShadow.minLens;
      int[][] limit = dataShadow.limit;
      int[][] base = dataShadow.base;
      int[][] perm = dataShadow.perm;
      int limitLast = this.blockSize100k * 100000;

      for(int i = 256; --i >= 0; unzftab[i] = 0) {
         yy[i] = (char)i;
      }

      int groupNo = 0;
      int groupPos = 49;
      int eob = this.nInUse + 1;
      int nextSym = this.getAndMoveToFrontDecode0(0);
      int bsBuffShadow = this.bsBuff;
      int bsLiveShadow = this.bsLive;
      int lastShadow = -1;
      int zt = selector[groupNo] & 255;
      int[] base_zt = base[zt];
      int[] limit_zt = limit[zt];
      int[] perm_zt = perm[zt];
      int minLens_zt = minLens[zt];

      while(nextSym != eob) {
         if (nextSym != 0 && nextSym != 1) {
            if (++lastShadow >= limitLast) {
               throw new IOException("block overrun");
            }

            char tmp = yy[nextSym - 1];
            unzftab[seqToUnseq[tmp] & 255]++;
            ll8[lastShadow] = seqToUnseq[tmp];
            if (nextSym <= 16) {
               int j = nextSym - 1;

               while(j > 0) {
                  yy[j--] = yy[j];
               }
            } else {
               System.arraycopy(yy, 0, yy, 1, nextSym - 1);
            }

            yy[0] = tmp;
            if (groupPos == 0) {
               groupPos = 49;
               zt = selector[++groupNo] & 255;
               base_zt = base[zt];
               limit_zt = limit[zt];
               perm_zt = perm[zt];
               minLens_zt = minLens[zt];
            } else {
               --groupPos;
            }

            int zn;
            for(zn = minLens_zt; bsLiveShadow < zn; bsLiveShadow += 8) {
               int thech = inShadow.read();
               if (thech < 0) {
                  throw new IOException("unexpected end of stream");
               }

               bsBuffShadow = bsBuffShadow << 8 | thech;
            }

            int zvec = bsBuffShadow >> bsLiveShadow - zn & (1 << zn) - 1;

            for(bsLiveShadow -= zn; zvec > limit_zt[zn]; zvec = zvec << 1 | bsBuffShadow >> --bsLiveShadow & 1) {
               ++zn;

               while(bsLiveShadow < 1) {
                  int thech = inShadow.read();
                  if (thech < 0) {
                     throw new IOException("unexpected end of stream");
                  }

                  bsBuffShadow = bsBuffShadow << 8 | thech;
                  bsLiveShadow += 8;
               }
            }

            nextSym = perm_zt[zvec - base_zt[zn]];
         } else {
            int s = -1;
            int n = 1;

            while(true) {
               if (nextSym == 0) {
                  s += n;
               } else {
                  if (nextSym != 1) {
                     byte ch = seqToUnseq[yy[0]];

                     for(unzftab[ch & 255] += s + 1; s-- >= 0; ll8[lastShadow] = ch) {
                        ++lastShadow;
                     }

                     if (lastShadow >= limitLast) {
                        throw new IOException("block overrun");
                     }
                     break;
                  }

                  s += n << 1;
               }

               if (groupPos == 0) {
                  groupPos = 49;
                  zt = selector[++groupNo] & 255;
                  base_zt = base[zt];
                  limit_zt = limit[zt];
                  perm_zt = perm[zt];
                  minLens_zt = minLens[zt];
               } else {
                  --groupPos;
               }

               int zn;
               for(zn = minLens_zt; bsLiveShadow < zn; bsLiveShadow += 8) {
                  int thech = inShadow.read();
                  if (thech < 0) {
                     throw new IOException("unexpected end of stream");
                  }

                  bsBuffShadow = bsBuffShadow << 8 | thech;
               }

               int zvec = bsBuffShadow >> bsLiveShadow - zn & (1 << zn) - 1;

               for(bsLiveShadow -= zn; zvec > limit_zt[zn]; zvec = zvec << 1 | bsBuffShadow >> --bsLiveShadow & 1) {
                  ++zn;

                  while(bsLiveShadow < 1) {
                     int thech = inShadow.read();
                     if (thech < 0) {
                        throw new IOException("unexpected end of stream");
                     }

                     bsBuffShadow = bsBuffShadow << 8 | thech;
                     bsLiveShadow += 8;
                  }
               }

               nextSym = perm_zt[zvec - base_zt[zn]];
               n <<= 1;
            }
         }
      }

      this.last = lastShadow;
      this.bsLive = bsLiveShadow;
      this.bsBuff = bsBuffShadow;
   }

   private int getAndMoveToFrontDecode0(int groupNo) throws IOException {
      InputStream inShadow = this.in;
      CBZip2InputStream.Data dataShadow = this.data;
      int zt = dataShadow.selector[groupNo] & 255;
      int[] limit_zt = dataShadow.limit[zt];
      int zn = dataShadow.minLens[zt];
      int zvec = this.bsR(zn);
      int bsLiveShadow = this.bsLive;

      int bsBuffShadow;
      for(bsBuffShadow = this.bsBuff; zvec > limit_zt[zn]; zvec = zvec << 1 | bsBuffShadow >> --bsLiveShadow & 1) {
         ++zn;

         while(bsLiveShadow < 1) {
            int thech = inShadow.read();
            if (thech < 0) {
               throw new IOException("unexpected end of stream");
            }

            bsBuffShadow = bsBuffShadow << 8 | thech;
            bsLiveShadow += 8;
         }
      }

      this.bsLive = bsLiveShadow;
      this.bsBuff = bsBuffShadow;
      return dataShadow.perm[zt][zvec - dataShadow.base[zt][zn]];
   }

   private void setupBlock() throws IOException {
      if (this.data != null) {
         int[] cftab = this.data.cftab;
         int[] tt = this.data.initTT(this.last + 1);
         byte[] ll8 = this.data.ll8;
         cftab[0] = 0;
         System.arraycopy(this.data.unzftab, 0, cftab, 1, 256);
         int i = 1;

         for(int c = cftab[0]; i <= 256; ++i) {
            c += cftab[i];
            cftab[i] = c;
         }

         i = 0;
         int lastShadow = this.last;

         while(i <= lastShadow) {
            tt[cftab[ll8[i] & 255]++] = i++;
         }

         if (this.origPtr >= 0 && this.origPtr < tt.length) {
            this.su_tPos = tt[this.origPtr];
            this.su_count = 0;
            this.su_i2 = 0;
            this.su_ch2 = 256;
            if (this.blockRandomised) {
               this.su_rNToGo = 0;
               this.su_rTPos = 0;
               this.setupRandPartA();
            } else {
               this.setupNoRandPartA();
            }
         } else {
            throw new IOException("stream corrupted");
         }
      }
   }

   private void setupRandPartA() throws IOException {
      if (this.su_i2 <= this.last) {
         this.su_chPrev = this.su_ch2;
         int su_ch2Shadow = this.data.ll8[this.su_tPos] & 255;
         this.su_tPos = this.data.tt[this.su_tPos];
         if (this.su_rNToGo == 0) {
            this.su_rNToGo = BZip2Constants.rNums[this.su_rTPos] - 1;
            if (++this.su_rTPos == 512) {
               this.su_rTPos = 0;
            }
         } else {
            --this.su_rNToGo;
         }

         int var2;
         this.su_ch2 = var2 = su_ch2Shadow ^ (this.su_rNToGo == 1 ? 1 : 0);
         ++this.su_i2;
         this.currentChar = var2;
         this.currentState = 3;
         this.crc.updateCRC(var2);
      } else {
         this.endBlock();
         this.initBlock();
         this.setupBlock();
      }
   }

   private void setupNoRandPartA() throws IOException {
      if (this.su_i2 <= this.last) {
         this.su_chPrev = this.su_ch2;
         int su_ch2Shadow = this.data.ll8[this.su_tPos] & 255;
         this.su_ch2 = su_ch2Shadow;
         this.su_tPos = this.data.tt[this.su_tPos];
         ++this.su_i2;
         this.currentChar = su_ch2Shadow;
         this.currentState = 6;
         this.crc.updateCRC(su_ch2Shadow);
      } else {
         this.currentState = 5;
         this.endBlock();
         this.initBlock();
         this.setupBlock();
      }
   }

   private void setupRandPartB() throws IOException {
      if (this.su_ch2 != this.su_chPrev) {
         this.currentState = 2;
         this.su_count = 1;
         this.setupRandPartA();
      } else if (++this.su_count >= 4) {
         this.su_z = (char)(this.data.ll8[this.su_tPos] & 255);
         this.su_tPos = this.data.tt[this.su_tPos];
         if (this.su_rNToGo == 0) {
            this.su_rNToGo = BZip2Constants.rNums[this.su_rTPos] - 1;
            if (++this.su_rTPos == 512) {
               this.su_rTPos = 0;
            }
         } else {
            --this.su_rNToGo;
         }

         this.su_j2 = 0;
         this.currentState = 4;
         if (this.su_rNToGo == 1) {
            this.su_z = (char)(this.su_z ^ 1);
         }

         this.setupRandPartC();
      } else {
         this.currentState = 2;
         this.setupRandPartA();
      }
   }

   private void setupRandPartC() throws IOException {
      if (this.su_j2 < this.su_z) {
         this.currentChar = this.su_ch2;
         this.crc.updateCRC(this.su_ch2);
         ++this.su_j2;
      } else {
         this.currentState = 2;
         ++this.su_i2;
         this.su_count = 0;
         this.setupRandPartA();
      }
   }

   private void setupNoRandPartB() throws IOException {
      if (this.su_ch2 != this.su_chPrev) {
         this.su_count = 1;
         this.setupNoRandPartA();
      } else if (++this.su_count >= 4) {
         this.su_z = (char)(this.data.ll8[this.su_tPos] & 255);
         this.su_tPos = this.data.tt[this.su_tPos];
         this.su_j2 = 0;
         this.setupNoRandPartC();
      } else {
         this.setupNoRandPartA();
      }
   }

   private void setupNoRandPartC() throws IOException {
      if (this.su_j2 < this.su_z) {
         int su_ch2Shadow = this.su_ch2;
         this.currentChar = su_ch2Shadow;
         this.crc.updateCRC(su_ch2Shadow);
         ++this.su_j2;
         this.currentState = 7;
      } else {
         ++this.su_i2;
         this.su_count = 0;
         this.setupNoRandPartA();
      }
   }

   private static final class Data {
      final boolean[] inUse = new boolean[256];
      final byte[] seqToUnseq = new byte[256];
      final byte[] selector = new byte[18002];
      final byte[] selectorMtf = new byte[18002];
      final int[] unzftab = new int[256];
      final int[][] limit = new int[6][258];
      final int[][] base = new int[6][258];
      final int[][] perm = new int[6][258];
      final int[] minLens = new int[6];
      final int[] cftab = new int[257];
      final char[] getAndMoveToFrontDecode_yy = new char[256];
      final char[][] temp_charArray2d = new char[6][258];
      final byte[] recvDecodingTables_pos = new byte[6];
      int[] tt;
      byte[] ll8;

      Data(int blockSize100k) {
         this.ll8 = new byte[blockSize100k * 100000];
      }

      int[] initTT(int length) {
         int[] ttShadow = this.tt;
         if (ttShadow == null || ttShadow.length < length) {
            this.tt = ttShadow = new int[length];
         }

         return ttShadow;
      }
   }
}
