package com.apache;

import java.io.IOException;
import java.io.OutputStream;

public class CBZip2OutputStream extends OutputStream implements BZip2Constants {
   protected static final int SETMASK = 2097152;
   protected static final int CLEARMASK = -2097153;
   protected static final int GREATER_ICOST = 15;
   protected static final int LESSER_ICOST = 0;
   protected static final int SMALL_THRESH = 20;
   protected static final int DEPTH_THRESH = 10;
   protected static final int QSORT_STACK_SIZE = 1000;
   int last;
   int origPtr;
   int blockSize100k;
   boolean blockRandomised;
   int bytesOut;
   int bsBuff;
   int bsLive;
   CRC mCrc = new CRC();
   private boolean[] inUse = new boolean[256];
   private int nInUse;
   private char[] seqToUnseq = new char[256];
   private char[] unseqToSeq = new char[256];
   private char[] selector = new char[18002];
   private char[] selectorMtf = new char[18002];
   private char[] block;
   private int[] quadrant;
   private int[] zptr;
   private short[] szptr;
   private int[] ftab;
   private int nMTF;
   private int[] mtfFreq = new int[258];
   private int workFactor;
   private int workDone;
   private int workLimit;
   private boolean firstAttempt;
   private int nBlocksRandomised;
   private int currentChar = -1;
   private int runLength = 0;
   boolean closed = false;
   private int blockCRC;
   private int combinedCRC;
   private int allowableBlockSize;
   private OutputStream bsStream;
   private int[] incs = new int[]{1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};

   private static void panic() {
      System.out.println("panic");
   }

   private void makeMaps() {
      this.nInUse = 0;

      for(int i = 0; i < 256; ++i) {
         if (this.inUse[i]) {
            this.seqToUnseq[this.nInUse] = (char)i;
            this.unseqToSeq[i] = (char)this.nInUse;
            ++this.nInUse;
         }
      }
   }

   protected static void hbMakeCodeLengths(char[] len, int[] freq, int alphaSize, int maxLen) {
      int[] heap = new int[260];
      int[] weight = new int[516];
      int[] parent = new int[516];

      for(int i = 0; i < alphaSize; ++i) {
         weight[i + 1] = (freq[i] == 0 ? 1 : freq[i]) << 8;
      }

      while(true) {
         int nNodes = alphaSize;
         int nHeap = 0;
         heap[0] = 0;
         weight[0] = 0;
         parent[0] = -2;

         for(int var20 = 1; var20 <= alphaSize; ++var20) {
            parent[var20] = -1;
            ++nHeap;
            heap[nHeap] = var20;
            int zz = nHeap;

            int tmp;
            for(tmp = heap[nHeap]; weight[tmp] < weight[heap[zz >> 1]]; zz >>= 1) {
               heap[zz] = heap[zz >> 1];
            }

            heap[zz] = tmp;
         }

         if (nHeap >= 260) {
            panic();
         }

         while(nHeap > 1) {
            int n1 = heap[1];
            heap[1] = heap[nHeap];
            --nHeap;
            int zz = 0;
            int yy = 0;
            int tmp = 0;
            zz = 1;
            tmp = heap[zz];

            while(true) {
               yy = zz << 1;
               if (yy > nHeap) {
                  break;
               }

               if (yy < nHeap && weight[heap[yy + 1]] < weight[heap[yy]]) {
                  ++yy;
               }

               if (weight[tmp] < weight[heap[yy]]) {
                  break;
               }

               heap[zz] = heap[yy];
               zz = yy;
            }

            heap[zz] = tmp;
            int n2 = heap[1];
            heap[1] = heap[nHeap];
            --nHeap;
            zz = 0;
            yy = 0;
            tmp = 0;
            zz = 1;
            tmp = heap[zz];

            while(true) {
               yy = zz << 1;
               if (yy > nHeap) {
                  break;
               }

               if (yy < nHeap && weight[heap[yy + 1]] < weight[heap[yy]]) {
                  ++yy;
               }

               if (weight[tmp] < weight[heap[yy]]) {
                  break;
               }

               heap[zz] = heap[yy];
               zz = yy;
            }

            heap[zz] = tmp;
            parent[n1] = parent[n2] = ++nNodes;
            weight[nNodes] = (weight[n1] & -256) + (weight[n2] & -256)
               | 1 + ((weight[n1] & 0xFF) > (weight[n2] & 0xFF) ? weight[n1] & 0xFF : weight[n2] & 0xFF);
            parent[nNodes] = -1;
            ++nHeap;
            heap[nHeap] = nNodes;
            zz = 0;
            yy = 0;
            zz = nHeap;

            for(yy = heap[nHeap]; weight[yy] < weight[heap[zz >> 1]]; zz >>= 1) {
               heap[zz] = heap[zz >> 1];
            }

            heap[zz] = yy;
         }

         if (nNodes >= 516) {
            panic();
         }

         boolean tooLong = false;

         for(int var21 = 1; var21 <= alphaSize; ++var21) {
            int j = 0;

            for(int k = var21; parent[k] >= 0; ++j) {
               k = parent[k];
            }

            len[var21 - 1] = (char)j;
            if (j > maxLen) {
               tooLong = true;
            }
         }

         if (!tooLong) {
            return;
         }

         for(int var22 = 1; var22 < alphaSize; ++var22) {
            int j = weight[var22] >> 8;
            j = 1 + j / 2;
            weight[var22] = j << 8;
         }
      }
   }

   public CBZip2OutputStream(OutputStream inStream) throws IOException {
      this(inStream, 9);
   }

   public CBZip2OutputStream(OutputStream inStream, int inBlockSize) throws IOException {
      this.block = null;
      this.quadrant = null;
      this.zptr = null;
      this.ftab = null;
      this.bsSetStream(inStream);
      this.workFactor = 50;
      if (inBlockSize > 9) {
         inBlockSize = 9;
      }

      if (inBlockSize < 1) {
         inBlockSize = 1;
      }

      this.blockSize100k = inBlockSize;
      this.allocateCompressStructures();
      this.initialize();
      this.initBlock();
   }

   @Override
   public void write(int bv) throws IOException {
      int b = (256 + bv) % 256;
      if (this.currentChar != -1) {
         if (this.currentChar == b) {
            ++this.runLength;
            if (this.runLength > 254) {
               this.writeRun();
               this.currentChar = -1;
               this.runLength = 0;
            }
         } else {
            this.writeRun();
            this.runLength = 1;
            this.currentChar = b;
         }
      } else {
         this.currentChar = b;
         ++this.runLength;
      }
   }

   private void writeRun() throws IOException {
      if (this.last < this.allowableBlockSize) {
         this.inUse[this.currentChar] = true;

         for(int i = 0; i < this.runLength; ++i) {
            this.mCrc.updateCRC((char)this.currentChar);
         }

         switch(this.runLength) {
            case 1:
               ++this.last;
               this.block[this.last + 1] = (char)this.currentChar;
               break;
            case 2:
               ++this.last;
               this.block[this.last + 1] = (char)this.currentChar;
               ++this.last;
               this.block[this.last + 1] = (char)this.currentChar;
               break;
            case 3:
               ++this.last;
               this.block[this.last + 1] = (char)this.currentChar;
               ++this.last;
               this.block[this.last + 1] = (char)this.currentChar;
               ++this.last;
               this.block[this.last + 1] = (char)this.currentChar;
               break;
            default:
               this.inUse[this.runLength - 4] = true;
               ++this.last;
               this.block[this.last + 1] = (char)this.currentChar;
               ++this.last;
               this.block[this.last + 1] = (char)this.currentChar;
               ++this.last;
               this.block[this.last + 1] = (char)this.currentChar;
               ++this.last;
               this.block[this.last + 1] = (char)this.currentChar;
               ++this.last;
               this.block[this.last + 1] = (char)(this.runLength - 4);
         }
      } else {
         this.endBlock();
         this.initBlock();
         this.writeRun();
      }
   }

   @Override
   protected void finalize() throws Throwable {
      this.close();
      super.finalize();
   }

   @Override
   public void close() throws IOException {
      if (!this.closed) {
         if (this.runLength > 0) {
            this.writeRun();
         }

         this.currentChar = -1;
         this.endBlock();
         this.endCompression();
         this.closed = true;
         super.close();
         this.bsStream.close();
      }
   }

   @Override
   public void flush() throws IOException {
      super.flush();
      this.bsStream.flush();
   }

   private void initialize() throws IOException {
      this.bytesOut = 0;
      this.nBlocksRandomised = 0;
      this.bsPutUChar(104);
      this.bsPutUChar(48 + this.blockSize100k);
      this.combinedCRC = 0;
   }

   private void initBlock() {
      this.mCrc.initialiseCRC();
      this.last = -1;

      for(int i = 0; i < 256; ++i) {
         this.inUse[i] = false;
      }

      this.allowableBlockSize = 100000 * this.blockSize100k - 20;
   }

   private void endBlock() throws IOException {
      this.blockCRC = this.mCrc.getFinalCRC();
      this.combinedCRC = this.combinedCRC << 1 | this.combinedCRC >>> 31;
      this.combinedCRC ^= this.blockCRC;
      this.doReversibleTransformation();
      this.bsPutUChar(49);
      this.bsPutUChar(65);
      this.bsPutUChar(89);
      this.bsPutUChar(38);
      this.bsPutUChar(83);
      this.bsPutUChar(89);
      this.bsPutint(this.blockCRC);
      if (this.blockRandomised) {
         this.bsW(1, 1);
         ++this.nBlocksRandomised;
      } else {
         this.bsW(1, 0);
      }

      this.moveToFrontCodeAndSend();
   }

   private void endCompression() throws IOException {
      this.bsPutUChar(23);
      this.bsPutUChar(114);
      this.bsPutUChar(69);
      this.bsPutUChar(56);
      this.bsPutUChar(80);
      this.bsPutUChar(144);
      this.bsPutint(this.combinedCRC);
      this.bsFinishedWithStream();
   }

   private void hbAssignCodes(int[] code, char[] length, int minLen, int maxLen, int alphaSize) {
      int vec = 0;

      for(int n = minLen; n <= maxLen; ++n) {
         for(int i = 0; i < alphaSize; ++i) {
            if (length[i] == n) {
               code[i] = vec++;
            }
         }

         vec <<= 1;
      }
   }

   private void bsSetStream(OutputStream f) {
      this.bsStream = f;
      this.bsLive = 0;
      this.bsBuff = 0;
      this.bytesOut = 0;
   }

   private void bsFinishedWithStream() throws IOException {
      while(this.bsLive > 0) {
         int ch = this.bsBuff >> 24;

         try {
            this.bsStream.write(ch);
         } catch (IOException var3) {
            throw var3;
         }

         this.bsBuff <<= 8;
         this.bsLive -= 8;
         ++this.bytesOut;
      }
   }

   private void bsW(int n, int v) throws IOException {
      while(this.bsLive >= 8) {
         int ch = this.bsBuff >> 24;

         try {
            this.bsStream.write(ch);
         } catch (IOException var5) {
            throw var5;
         }

         this.bsBuff <<= 8;
         this.bsLive -= 8;
         ++this.bytesOut;
      }

      this.bsBuff |= v << 32 - this.bsLive - n;
      this.bsLive += n;
   }

   private void bsPutUChar(int c) throws IOException {
      this.bsW(8, c);
   }

   private void bsPutint(int u) throws IOException {
      this.bsW(8, u >> 24 & 0xFF);
      this.bsW(8, u >> 16 & 0xFF);
      this.bsW(8, u >> 8 & 0xFF);
      this.bsW(8, u & 0xFF);
   }

   private void bsPutIntVS(int numBits, int c) throws IOException {
      this.bsW(numBits, c);
   }

   private void sendMTFValues() throws IOException {
      char[][] len = new char[6][258];
      int nSelectors = 0;
      int alphaSize = this.nInUse + 2;

      for(int t = 0; t < 6; ++t) {
         for(int v = 0; v < alphaSize; ++v) {
            len[t][v] = 15;
         }
      }

      if (this.nMTF <= 0) {
         panic();
      }

      int nGroups;
      if (this.nMTF < 200) {
         nGroups = 2;
      } else if (this.nMTF < 600) {
         nGroups = 3;
      } else if (this.nMTF < 1200) {
         nGroups = 4;
      } else if (this.nMTF < 2400) {
         nGroups = 5;
      } else {
         nGroups = 6;
      }

      int nPart = nGroups;
      int remF = this.nMTF;

      int aFreq;
      for(int gs = 0; nPart > 0; remF -= aFreq) {
         int tFreq = remF / nPart;
         int ge = gs - 1;
         aFreq = 0;

         while(aFreq < tFreq && ge < alphaSize - 1) {
            aFreq += this.mtfFreq[++ge];
         }

         if (ge > gs && nPart != nGroups && nPart != 1 && (nGroups - nPart) % 2 == 1) {
            aFreq -= this.mtfFreq[ge];
            --ge;
         }

         for(int v = 0; v < alphaSize; ++v) {
            if (v >= gs && v <= ge) {
               len[nPart - 1][v] = 0;
            } else {
               len[nPart - 1][v] = 15;
            }
         }

         --nPart;
         gs = ge + 1;
      }

      int[][] rfreq = new int[6][258];
      int[] fave = new int[6];
      short[] cost = new short[6];

      for(int iter = 0; iter < 4; ++iter) {
         for(int var31 = 0; var31 < nGroups; ++var31) {
            fave[var31] = 0;
         }

         for(int var32 = 0; var32 < nGroups; ++var32) {
            for(int v = 0; v < alphaSize; ++v) {
               rfreq[var32][v] = 0;
            }
         }

         nSelectors = 0;
         int totc = 0;

         int ge;
         for(int var53 = 0; var53 < this.nMTF; var53 = ge + 1) {
            ge = var53 + 50 - 1;
            if (ge >= this.nMTF) {
               ge = this.nMTF - 1;
            }

            for(int var33 = 0; var33 < nGroups; ++var33) {
               cost[var33] = 0;
            }

            if (nGroups == 6) {
               short cost5 = 0;
               short cost4 = 0;
               short cost3 = 0;
               short cost2 = 0;
               short cost1 = 0;
               short cost0 = 0;

               for(int i = var53; i <= ge; ++i) {
                  short icv = this.szptr[i];
                  cost0 = (short)(cost0 + len[0][icv]);
                  cost1 = (short)(cost1 + len[1][icv]);
                  cost2 = (short)(cost2 + len[2][icv]);
                  cost3 = (short)(cost3 + len[3][icv]);
                  cost4 = (short)(cost4 + len[4][icv]);
                  cost5 = (short)(cost5 + len[5][icv]);
               }

               cost[0] = cost0;
               cost[1] = cost1;
               cost[2] = cost2;
               cost[3] = cost3;
               cost[4] = cost4;
               cost[5] = cost5;
            } else {
               for(int i = var53; i <= ge; ++i) {
                  short icv = this.szptr[i];

                  for(int var34 = 0; var34 < nGroups; ++var34) {
                     cost[var34] = (short)(cost[var34] + len[var34][icv]);
                  }
               }
            }

            int bc = 999999999;
            int bt = -1;

            for(int var35 = 0; var35 < nGroups; ++var35) {
               if (cost[var35] < bc) {
                  bc = cost[var35];
                  bt = var35;
               }
            }

            totc += bc;
            fave[bt]++;
            this.selector[nSelectors] = (char)bt;
            ++nSelectors;

            for(int var40 = var53; var40 <= ge; ++var40) {
               rfreq[bt][this.szptr[var40]]++;
            }
         }

         for(int var36 = 0; var36 < nGroups; ++var36) {
            hbMakeCodeLengths(len[var36], rfreq[var36], alphaSize, 20);
         }
      }

      int[][] var61 = null;
      int[] var63 = null;
      short[] var65 = null;
      if (nGroups >= 8) {
         panic();
      }

      if (nSelectors >= 32768 || nSelectors > 18002) {
         panic();
      }

      char[] pos = new char[6];

      for(int i = 0; i < nGroups; ++i) {
         pos[i] = (char)i;
      }

      for(int var42 = 0; var42 < nSelectors; ++var42) {
         char ll_i = this.selector[var42];
         int j = 0;

         char tmp2;
         char tmp;
         for(tmp = pos[j]; ll_i != tmp; pos[j] = tmp2) {
            ++j;
            tmp2 = tmp;
            tmp = pos[j];
         }

         pos[0] = tmp;
         this.selectorMtf[var42] = (char)j;
      }

      int[][] code = new int[6][258];

      for(int var37 = 0; var37 < nGroups; ++var37) {
         int minLen = 32;
         int maxLen = 0;

         for(int var43 = 0; var43 < alphaSize; ++var43) {
            if (len[var37][var43] > maxLen) {
               maxLen = len[var37][var43];
            }

            if (len[var37][var43] < minLen) {
               minLen = len[var37][var43];
            }
         }

         if (maxLen > 20) {
            panic();
         }

         if (minLen < 1) {
            panic();
         }

         this.hbAssignCodes(code[var37], len[var37], minLen, maxLen, alphaSize);
      }

      boolean[] inUse16 = new boolean[16];

      for(int var44 = 0; var44 < 16; ++var44) {
         inUse16[var44] = false;

         for(int j = 0; j < 16; ++j) {
            if (this.inUse[var44 * 16 + j]) {
               inUse16[var44] = true;
            }
         }
      }

      int nBytes = this.bytesOut;

      for(int var45 = 0; var45 < 16; ++var45) {
         if (inUse16[var45]) {
            this.bsW(1, 1);
         } else {
            this.bsW(1, 0);
         }
      }

      for(int var46 = 0; var46 < 16; ++var46) {
         if (inUse16[var46]) {
            for(int j = 0; j < 16; ++j) {
               if (this.inUse[var46 * 16 + j]) {
                  this.bsW(1, 1);
               } else {
                  this.bsW(1, 0);
               }
            }
         }
      }

      nBytes = this.bytesOut;
      this.bsW(3, nGroups);
      this.bsW(15, nSelectors);

      for(int var47 = 0; var47 < nSelectors; ++var47) {
         for(int j = 0; j < this.selectorMtf[var47]; ++j) {
            this.bsW(1, 1);
         }

         this.bsW(1, 0);
      }

      nBytes = this.bytesOut;

      for(int var38 = 0; var38 < nGroups; ++var38) {
         int curr = len[var38][0];
         this.bsW(5, curr);

         for(int var48 = 0; var48 < alphaSize; ++var48) {
            while(curr < len[var38][var48]) {
               this.bsW(2, 2);
               ++curr;
            }

            while(curr > len[var38][var48]) {
               this.bsW(2, 3);
               --curr;
            }

            this.bsW(1, 0);
         }
      }

      nBytes = this.bytesOut;
      int selCtr = 0;

      for(int var54 = 0; var54 < this.nMTF; ++selCtr) {
         int ge = var54 + 50 - 1;
         if (ge >= this.nMTF) {
            ge = this.nMTF - 1;
         }

         for(int var49 = var54; var49 <= ge; ++var49) {
            this.bsW(len[this.selector[selCtr]][this.szptr[var49]], code[this.selector[selCtr]][this.szptr[var49]]);
         }

         var54 = ge + 1;
      }

      if (selCtr != nSelectors) {
         panic();
      }
   }

   private void moveToFrontCodeAndSend() throws IOException {
      this.bsPutIntVS(24, this.origPtr);
      this.generateMTFValues();
      this.sendMTFValues();
   }

   private void simpleSort(int lo, int hi, int d) {
      int bigN = hi - lo + 1;
      if (bigN >= 2) {
         int hp = 0;

         while(this.incs[hp] < bigN) {
            ++hp;
         }

         --hp;

         for(; hp >= 0; --hp) {
            int h = this.incs[hp];
            int i = lo + h;

            while(i <= hi) {
               int v = this.zptr[i];
               int j = i;

               while(this.fullGtU(this.zptr[j - h] + d, v + d)) {
                  this.zptr[j] = this.zptr[j - h];
                  j -= h;
                  if (j <= lo + h - 1) {
                     break;
                  }
               }

               this.zptr[j] = v;
               if (++i > hi) {
                  break;
               }

               v = this.zptr[i];
               j = i;

               while(this.fullGtU(this.zptr[j - h] + d, v + d)) {
                  this.zptr[j] = this.zptr[j - h];
                  j -= h;
                  if (j <= lo + h - 1) {
                     break;
                  }
               }

               this.zptr[j] = v;
               if (++i > hi) {
                  break;
               }

               v = this.zptr[i];
               j = i;

               while(this.fullGtU(this.zptr[j - h] + d, v + d)) {
                  this.zptr[j] = this.zptr[j - h];
                  j -= h;
                  if (j <= lo + h - 1) {
                     break;
                  }
               }

               this.zptr[j] = v;
               ++i;
               if (this.workDone > this.workLimit && this.firstAttempt) {
                  return;
               }
            }
         }
      }
   }

   private void vswap(int p1, int p2, int n) {
      for(int temp = 0; n > 0; --n) {
         temp = this.zptr[p1];
         this.zptr[p1] = this.zptr[p2];
         this.zptr[p2] = temp;
         ++p1;
         ++p2;
      }
   }

   private char med3(char a, char b, char c) {
      if (a > b) {
         char t = a;
         a = b;
         b = t;
      }

      if (b > c) {
         b = c;
      }

      if (a > b) {
         b = a;
      }

      return b;
   }

   private void qSort3(int loSt, int hiSt, int dSt) {
      CBZip2OutputStream.StackElem[] stack = new CBZip2OutputStream.StackElem[1000];

      for(int count = 0; count < 1000; ++count) {
         stack[count] = new CBZip2OutputStream.StackElem(null);
      }

      int sp = 0;
      stack[sp].ll = loSt;
      stack[sp].hh = hiSt;
      stack[sp].dd = dSt;
      ++sp;

      label82:
      while(sp > 0) {
         if (sp >= 1000) {
            panic();
         }

         int lo = stack[--sp].ll;
         int hi = stack[sp].hh;
         int d = stack[sp].dd;
         if (hi - lo >= 20 && d <= 10) {
            int med = this.med3(this.block[this.zptr[lo] + d + 1], this.block[this.zptr[hi] + d + 1], this.block[this.zptr[lo + hi >> 1] + d + 1]);
            int ltLo = lo;
            int unLo = lo;
            int gtHi = hi;
            int unHi = hi;

            while(true) {
               if (unLo <= unHi) {
                  int n = this.block[this.zptr[unLo] + d + 1] - med;
                  if (n == 0) {
                     int temp = 0;
                     temp = this.zptr[unLo];
                     this.zptr[unLo] = this.zptr[ltLo];
                     this.zptr[ltLo] = temp;
                     ++ltLo;
                     ++unLo;
                     continue;
                  }

                  if (n <= 0) {
                     ++unLo;
                     continue;
                  }
               }

               while(true) {
                  if (unLo <= unHi) {
                     int n = this.block[this.zptr[unHi] + d + 1] - med;
                     if (n == 0) {
                        int temp = 0;
                        temp = this.zptr[unHi];
                        this.zptr[unHi] = this.zptr[gtHi];
                        this.zptr[gtHi] = temp;
                        --gtHi;
                        --unHi;
                        continue;
                     }

                     if (n >= 0) {
                        --unHi;
                        continue;
                     }
                  }

                  if (unLo > unHi) {
                     if (gtHi < ltLo) {
                        stack[sp].ll = lo;
                        stack[sp].hh = hi;
                        stack[sp].dd = d + 1;
                        ++sp;
                     } else {
                        int n = ltLo - lo < unLo - ltLo ? ltLo - lo : unLo - ltLo;
                        this.vswap(lo, unLo - n, n);
                        int m = hi - gtHi < gtHi - unHi ? hi - gtHi : gtHi - unHi;
                        this.vswap(unLo, hi - m + 1, m);
                        n = lo + unLo - ltLo - 1;
                        m = hi - (gtHi - unHi) + 1;
                        stack[sp].ll = lo;
                        stack[sp].hh = n;
                        stack[sp].dd = d;
                        ++sp;
                        stack[sp].ll = n + 1;
                        stack[sp].hh = m - 1;
                        stack[sp].dd = d + 1;
                        ++sp;
                        stack[sp].ll = m;
                        stack[sp].hh = hi;
                        stack[sp].dd = d;
                        ++sp;
                     }
                     continue label82;
                  }

                  int temp = 0;
                  temp = this.zptr[unLo];
                  this.zptr[unLo] = this.zptr[unHi];
                  this.zptr[unHi] = temp;
                  ++unLo;
                  --unHi;
                  break;
               }
            }
         } else {
            this.simpleSort(lo, hi, d);
            if (this.workDone > this.workLimit && this.firstAttempt) {
               return;
            }
         }
      }
   }

   private void mainSort() {
      int[] runningOrder = new int[256];
      int[] copy = new int[256];
      boolean[] bigDone = new boolean[256];

      for(int i = 0; i < 20; ++i) {
         this.block[this.last + i + 2] = this.block[i % (this.last + 1) + 1];
      }

      for(int var16 = 0; var16 <= this.last + 20; ++var16) {
         this.quadrant[var16] = 0;
      }

      this.block[0] = this.block[this.last + 1];
      if (this.last < 4000) {
         int var17 = 0;

         while(var17 <= this.last) {
            this.zptr[var17] = var17++;
         }

         this.firstAttempt = false;
         this.workDone = this.workLimit = 0;
         this.simpleSort(0, this.last, 0);
      } else {
         int numQSorted = 0;

         for(int var18 = 0; var18 <= 255; ++var18) {
            bigDone[var18] = false;
         }

         for(int var19 = 0; var19 <= 65536; ++var19) {
            this.ftab[var19] = 0;
         }

         int c1 = this.block[0];

         for(int var20 = 0; var20 <= this.last; ++var20) {
            int c2 = this.block[var20 + 1];
            this.ftab[(c1 << 8) + c2]++;
            c1 = c2;
         }

         for(int var21 = 1; var21 <= 65536; ++var21) {
            this.ftab[var21] += this.ftab[var21 - 1];
         }

         c1 = this.block[1];

         int j;
         for(int var22 = 0; var22 < this.last; this.zptr[this.ftab[j]] = var22++) {
            int c2 = this.block[var22 + 2];
            j = (c1 << 8) + c2;
            c1 = c2;
            this.ftab[j]--;
         }

         j = (this.block[this.last + 1] << '\b') + this.block[1];
         this.ftab[j]--;
         this.zptr[this.ftab[j]] = this.last;
         int var23 = 0;

         while(var23 <= 255) {
            runningOrder[var23] = var23++;
         }

         int h = 1;

         do {
            h = 3 * h + 1;
         } while(h <= 256);

         do {
            h /= 3;

            for(int var24 = h; var24 <= 255; ++var24) {
               int vv = runningOrder[var24];
               j = var24;

               while(this.ftab[runningOrder[j - h] + 1 << 8] - this.ftab[runningOrder[j - h] << 8] > this.ftab[vv + 1 << 8] - this.ftab[vv << 8]) {
                  runningOrder[j] = runningOrder[j - h];
                  j -= h;
                  if (j <= h - 1) {
                     break;
                  }
               }

               runningOrder[j] = vv;
            }
         } while(h != 1);

         for(int var25 = 0; var25 <= 255; ++var25) {
            int ss = runningOrder[var25];

            for(int var28 = 0; var28 <= 255; ++var28) {
               int sb = (ss << 8) + var28;
               if ((this.ftab[sb] & 2097152) != 2097152) {
                  int lo = this.ftab[sb] & -2097153;
                  h = (this.ftab[sb + 1] & -2097153) - 1;
                  if (h > lo) {
                     this.qSort3(lo, h, 2);
                     numQSorted += h - lo + 1;
                     if (this.workDone > this.workLimit && this.firstAttempt) {
                        return;
                     }
                  }

                  this.ftab[sb] |= 2097152;
               }
            }

            bigDone[ss] = true;
            if (var25 < 255) {
               int bbStart = this.ftab[ss << 8] & -2097153;
               h = (this.ftab[ss + 1 << 8] & -2097153) - bbStart;
               int shifts = 0;

               while(h >> shifts > 65534) {
                  ++shifts;
               }

               for(int var29 = 0; var29 < h; ++var29) {
                  int a2update = this.zptr[bbStart + var29];
                  int qVal = var29 >> shifts;
                  this.quadrant[a2update] = qVal;
                  if (a2update < 20) {
                     this.quadrant[a2update + this.last + 1] = qVal;
                  }
               }

               if (h - 1 >> shifts > 65535) {
                  panic();
               }
            }

            for(int var30 = 0; var30 <= 255; ++var30) {
               copy[var30] = this.ftab[(var30 << 8) + ss] & -2097153;
            }

            for(int var31 = this.ftab[ss << 8] & -2097153; var31 < (this.ftab[ss + 1 << 8] & -2097153); ++var31) {
               int var34 = this.block[this.zptr[var31]];
               if (!bigDone[var34]) {
                  this.zptr[copy[var34]] = this.zptr[var31] == 0 ? this.last : this.zptr[var31] - 1;
                  copy[var34]++;
               }
            }

            for(int var32 = 0; var32 <= 255; ++var32) {
               this.ftab[(var32 << 8) + ss] |= 2097152;
            }
         }
      }
   }

   private void randomiseBlock() {
      int rNToGo = 0;
      int rTPos = 0;

      for(int i = 0; i < 256; ++i) {
         this.inUse[i] = false;
      }

      for(int var4 = 0; var4 <= this.last; ++var4) {
         if (rNToGo == 0) {
            rNToGo = (char)rNums[rTPos];
            if (++rTPos == 512) {
               rTPos = 0;
            }
         }

         --rNToGo;
         this.block[var4 + 1] = (char)(this.block[var4 + 1] ^ (rNToGo == 1 ? 1 : 0));
         this.block[var4 + 1] = (char)(this.block[var4 + 1] & 255);
         this.inUse[this.block[var4 + 1]] = true;
      }
   }

   private void doReversibleTransformation() {
      this.workLimit = this.workFactor * this.last;
      this.workDone = 0;
      this.blockRandomised = false;
      this.firstAttempt = true;
      this.mainSort();
      if (this.workDone > this.workLimit && this.firstAttempt) {
         this.randomiseBlock();
         this.workLimit = this.workDone = 0;
         this.blockRandomised = true;
         this.firstAttempt = false;
         this.mainSort();
      }

      this.origPtr = -1;

      for(int i = 0; i <= this.last; ++i) {
         if (this.zptr[i] == 0) {
            this.origPtr = i;
            break;
         }
      }

      if (this.origPtr == -1) {
         panic();
      }
   }

   private boolean fullGtU(int i1, int i2) {
      char c1 = this.block[i1 + 1];
      char c2 = this.block[i2 + 1];
      if (c1 != c2) {
         return c1 > c2;
      } else {
         ++i1;
         ++i2;
         c1 = this.block[i1 + 1];
         c2 = this.block[i2 + 1];
         if (c1 != c2) {
            return c1 > c2;
         } else {
            ++i1;
            ++i2;
            c1 = this.block[i1 + 1];
            c2 = this.block[i2 + 1];
            if (c1 != c2) {
               return c1 > c2;
            } else {
               ++i1;
               ++i2;
               c1 = this.block[i1 + 1];
               c2 = this.block[i2 + 1];
               if (c1 != c2) {
                  return c1 > c2;
               } else {
                  ++i1;
                  ++i2;
                  c1 = this.block[i1 + 1];
                  c2 = this.block[i2 + 1];
                  if (c1 != c2) {
                     return c1 > c2;
                  } else {
                     ++i1;
                     ++i2;
                     c1 = this.block[i1 + 1];
                     c2 = this.block[i2 + 1];
                     if (c1 != c2) {
                        return c1 > c2;
                     } else {
                        ++i1;
                        ++i2;
                        int k = this.last + 1;

                        do {
                           c1 = this.block[i1 + 1];
                           c2 = this.block[i2 + 1];
                           if (c1 != c2) {
                              return c1 > c2;
                           }

                           int s1 = this.quadrant[i1];
                           int s2 = this.quadrant[i2];
                           if (s1 != s2) {
                              if (s1 > s2) {
                                 return true;
                              }

                              return false;
                           }

                           ++i1;
                           ++i2;
                           c1 = this.block[i1 + 1];
                           c2 = this.block[i2 + 1];
                           if (c1 != c2) {
                              if (c1 > c2) {
                                 return true;
                              }

                              return false;
                           }

                           s1 = this.quadrant[i1];
                           s2 = this.quadrant[i2];
                           if (s1 != s2) {
                              if (s1 > s2) {
                                 return true;
                              }

                              return false;
                           }

                           ++i1;
                           ++i2;
                           c1 = this.block[i1 + 1];
                           c2 = this.block[i2 + 1];
                           if (c1 != c2) {
                              if (c1 > c2) {
                                 return true;
                              }

                              return false;
                           }

                           s1 = this.quadrant[i1];
                           s2 = this.quadrant[i2];
                           if (s1 != s2) {
                              if (s1 > s2) {
                                 return true;
                              }

                              return false;
                           }

                           ++i1;
                           ++i2;
                           c1 = this.block[i1 + 1];
                           c2 = this.block[i2 + 1];
                           if (c1 != c2) {
                              if (c1 > c2) {
                                 return true;
                              }

                              return false;
                           }

                           s1 = this.quadrant[i1];
                           s2 = this.quadrant[i2];
                           if (s1 != s2) {
                              if (s1 > s2) {
                                 return true;
                              }

                              return false;
                           }

                           ++i1;
                           ++i2;
                           if (i1 > this.last) {
                              i1 -= this.last;
                              --i1;
                           }

                           if (i2 > this.last) {
                              i2 -= this.last;
                              --i2;
                           }

                           k -= 4;
                           ++this.workDone;
                        } while(k >= 0);

                        return false;
                     }
                  }
               }
            }
         }
      }
   }

   private void allocateCompressStructures() {
      int n = 100000 * this.blockSize100k;
      this.block = new char[n + 1 + 20];
      this.quadrant = new int[n + 20];
      this.zptr = new int[n];
      this.ftab = new int[65537];
      if (this.block != null && this.quadrant != null && this.zptr != null) {
      }

      this.szptr = new short[2 * n];
   }

   private void generateMTFValues() {
      char[] yy = new char[256];
      this.makeMaps();
      int EOB = this.nInUse + 1;

      for(int i = 0; i <= EOB; ++i) {
         this.mtfFreq[i] = 0;
      }

      int wr = 0;
      int zPend = 0;

      for(int var10 = 0; var10 < this.nInUse; ++var10) {
         yy[var10] = (char)var10;
      }

      for(int var11 = 0; var11 <= this.last; ++var11) {
         char ll_i = this.unseqToSeq[this.block[this.zptr[var11]]];
         int j = 0;

         char tmp;
         char tmp2;
         for(tmp = yy[j]; ll_i != tmp; yy[j] = tmp2) {
            ++j;
            tmp2 = tmp;
            tmp = yy[j];
         }

         yy[0] = tmp;
         if (j == 0) {
            ++zPend;
         } else {
            if (zPend > 0) {
               --zPend;

               while(true) {
                  switch(zPend % 2) {
                     case 0:
                        this.szptr[wr] = 0;
                        ++wr;
                        this.mtfFreq[0]++;
                        break;
                     case 1:
                        this.szptr[wr] = 1;
                        ++wr;
                        this.mtfFreq[1]++;
                  }

                  if (zPend < 2) {
                     zPend = 0;
                     break;
                  }

                  zPend = (zPend - 2) / 2;
               }
            }

            this.szptr[wr] = (short)(j + 1);
            ++wr;
            this.mtfFreq[j + 1]++;
         }
      }

      if (zPend > 0) {
         --zPend;

         while(true) {
            switch(zPend % 2) {
               case 0:
                  this.szptr[wr] = 0;
                  ++wr;
                  this.mtfFreq[0]++;
                  break;
               case 1:
                  this.szptr[wr] = 1;
                  ++wr;
                  this.mtfFreq[1]++;
            }

            if (zPend < 2) {
               break;
            }

            zPend = (zPend - 2) / 2;
         }
      }

      this.szptr[wr] = (short)EOB;
      ++wr;
      this.mtfFreq[EOB]++;
      this.nMTF = wr;
   }

   private static class StackElem {
      int ll;
      int hh;
      int dd;

      private StackElem() {
      }

      public StackElem(Object o) {
      }
   }
}
