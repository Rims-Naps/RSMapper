package org.apache.tools.bzip2;

import java.io.IOException;
import java.io.OutputStream;

public class CBZip2OutputStream extends OutputStream implements BZip2Constants {
   public static final int MIN_BLOCKSIZE = 1;
   public static final int MAX_BLOCKSIZE = 9;
   protected static final int SETMASK = 2097152;
   protected static final int CLEARMASK = -2097153;
   protected static final int GREATER_ICOST = 15;
   protected static final int LESSER_ICOST = 0;
   protected static final int SMALL_THRESH = 20;
   protected static final int DEPTH_THRESH = 10;
   protected static final int WORK_FACTOR = 30;
   protected static final int QSORT_STACK_SIZE = 1000;
   private static final int[] INCS = new int[]{1, 4, 13, 40, 121, 364, 1093, 3280, 9841, 29524, 88573, 265720, 797161, 2391484};
   private int last;
   private int origPtr;
   private final int blockSize100k;
   private boolean blockRandomised;
   private int bsBuff;
   private int bsLive;
   private final CRC crc;
   private int nInUse;
   private int nMTF;
   private int workDone;
   private int workLimit;
   private boolean firstAttempt;
   private int currentChar;
   private int runLength;
   private int blockCRC;
   private int combinedCRC;
   private int allowableBlockSize;
   private CBZip2OutputStream.Data data;
   private OutputStream out;

   protected static void hbMakeCodeLengths(char[] len, int[] freq, int alphaSize, int maxLen) {
      int[] heap = new int[516];
      int[] weight = new int[516];
      int[] parent = new int[516];
      int i = alphaSize;

      while(true) {
         --i;
         if (i < 0) {
            boolean tooLong = true;

            while(true) {
               int n1;
               int yy;
               do {
                  if (!tooLong) {
                     return;
                  }

                  tooLong = false;
                  int nNodes = alphaSize;
                  int nHeap = 0;
                  heap[0] = 0;
                  weight[0] = 0;
                  parent[0] = -2;

                  int zz;
                  for(n1 = 1; n1 <= alphaSize; ++n1) {
                     parent[n1] = -1;
                     ++nHeap;
                     heap[nHeap] = n1;
                     yy = nHeap;

                     for(zz = heap[nHeap]; weight[zz] < weight[heap[yy >> 1]]; yy >>= 1) {
                        heap[yy] = heap[yy >> 1];
                     }

                     heap[yy] = zz;
                  }

                  int tmp;
                  while(nHeap > 1) {
                     n1 = heap[1];
                     heap[1] = heap[nHeap];
                     --nHeap;
                     int yy = false;
                     zz = 1;
                     tmp = heap[1];

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
                     yy = false;
                     zz = 1;
                     tmp = heap[1];

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
                     ++nNodes;
                     parent[n1] = parent[n2] = nNodes;
                     int weight_n1 = weight[n1];
                     int weight_n2 = weight[n2];
                     weight[nNodes] = (weight_n1 & -256) + (weight_n2 & -256) | 1 + ((weight_n1 & 255) > (weight_n2 & 255) ? weight_n1 & 255 : weight_n2 & 255);
                     parent[nNodes] = -1;
                     ++nHeap;
                     heap[nHeap] = nNodes;
                     int tmp = false;
                     zz = nHeap;
                     tmp = heap[nHeap];

                     for(int weight_tmp = weight[tmp]; weight_tmp < weight[heap[zz >> 1]]; zz >>= 1) {
                        heap[zz] = heap[zz >> 1];
                     }

                     heap[zz] = tmp;
                  }

                  for(n1 = 1; n1 <= alphaSize; ++n1) {
                     yy = 0;

                     for(zz = n1; (tmp = parent[zz]) >= 0; ++yy) {
                        zz = tmp;
                     }

                     len[n1 - 1] = (char)yy;
                     if (yy > maxLen) {
                        tooLong = true;
                     }
                  }
               } while(!tooLong);

               for(n1 = 1; n1 < alphaSize; ++n1) {
                  yy = weight[n1] >> 8;
                  yy = 1 + (yy >> 1);
                  weight[n1] = yy << 8;
               }
            }
         }

         weight[i + 1] = (freq[i] == 0 ? 1 : freq[i]) << 8;
      }
   }

   private static void hbMakeCodeLengths(byte[] len, int[] freq, CBZip2OutputStream.Data dat, int alphaSize, int maxLen) {
      int[] heap = dat.heap;
      int[] weight = dat.weight;
      int[] parent = dat.parent;
      int i = alphaSize;

      while(true) {
         --i;
         if (i < 0) {
            boolean tooLong = true;

            while(true) {
               int n1;
               int yy;
               do {
                  if (!tooLong) {
                     return;
                  }

                  tooLong = false;
                  int nNodes = alphaSize;
                  int nHeap = 0;
                  heap[0] = 0;
                  weight[0] = 0;
                  parent[0] = -2;

                  int zz;
                  for(n1 = 1; n1 <= alphaSize; ++n1) {
                     parent[n1] = -1;
                     ++nHeap;
                     heap[nHeap] = n1;
                     yy = nHeap;

                     for(zz = heap[nHeap]; weight[zz] < weight[heap[yy >> 1]]; yy >>= 1) {
                        heap[yy] = heap[yy >> 1];
                     }

                     heap[yy] = zz;
                  }

                  int tmp;
                  while(nHeap > 1) {
                     n1 = heap[1];
                     heap[1] = heap[nHeap];
                     --nHeap;
                     int yy = false;
                     zz = 1;
                     tmp = heap[1];

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
                     yy = false;
                     zz = 1;
                     tmp = heap[1];

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
                     ++nNodes;
                     parent[n1] = parent[n2] = nNodes;
                     int weight_n1 = weight[n1];
                     int weight_n2 = weight[n2];
                     weight[nNodes] = (weight_n1 & -256) + (weight_n2 & -256) | 1 + ((weight_n1 & 255) > (weight_n2 & 255) ? weight_n1 & 255 : weight_n2 & 255);
                     parent[nNodes] = -1;
                     ++nHeap;
                     heap[nHeap] = nNodes;
                     int tmp = false;
                     zz = nHeap;
                     tmp = heap[nHeap];

                     for(int weight_tmp = weight[tmp]; weight_tmp < weight[heap[zz >> 1]]; zz >>= 1) {
                        heap[zz] = heap[zz >> 1];
                     }

                     heap[zz] = tmp;
                  }

                  for(n1 = 1; n1 <= alphaSize; ++n1) {
                     yy = 0;

                     for(zz = n1; (tmp = parent[zz]) >= 0; ++yy) {
                        zz = tmp;
                     }

                     len[n1 - 1] = (byte)yy;
                     if (yy > maxLen) {
                        tooLong = true;
                     }
                  }
               } while(!tooLong);

               for(n1 = 1; n1 < alphaSize; ++n1) {
                  yy = weight[n1] >> 8;
                  yy = 1 + (yy >> 1);
                  weight[n1] = yy << 8;
               }
            }
         }

         weight[i + 1] = (freq[i] == 0 ? 1 : freq[i]) << 8;
      }
   }

   public static int chooseBlockSize(long inputLength) {
      return inputLength > 0L ? (int)Math.min(inputLength / 132000L + 1L, 9L) : 9;
   }

   public CBZip2OutputStream(OutputStream out) throws IOException {
      this(out, 9);
   }

   public CBZip2OutputStream(OutputStream out, int blockSize) throws IOException {
      this.crc = new CRC();
      this.currentChar = -1;
      this.runLength = 0;
      if (blockSize < 1) {
         throw new IllegalArgumentException("blockSize(" + blockSize + ") < 1");
      } else if (blockSize > 9) {
         throw new IllegalArgumentException("blockSize(" + blockSize + ") > 9");
      } else {
         this.blockSize100k = blockSize;
         this.out = out;
         this.init();
      }
   }

   public void write(int b) throws IOException {
      if (this.out != null) {
         this.write0(b);
      } else {
         throw new IOException("closed");
      }
   }

   private void writeRun() throws IOException {
      int lastShadow = this.last;
      if (lastShadow < this.allowableBlockSize) {
         int currentCharShadow = this.currentChar;
         CBZip2OutputStream.Data dataShadow = this.data;
         dataShadow.inUse[currentCharShadow] = true;
         byte ch = (byte)currentCharShadow;
         int runLengthShadow = this.runLength;
         this.crc.updateCRC(currentCharShadow, runLengthShadow);
         byte[] block;
         switch(runLengthShadow) {
         case 1:
            dataShadow.block[lastShadow + 2] = ch;
            this.last = lastShadow + 1;
            break;
         case 2:
            dataShadow.block[lastShadow + 2] = ch;
            dataShadow.block[lastShadow + 3] = ch;
            this.last = lastShadow + 2;
            break;
         case 3:
            block = dataShadow.block;
            block[lastShadow + 2] = ch;
            block[lastShadow + 3] = ch;
            block[lastShadow + 4] = ch;
            this.last = lastShadow + 3;
            break;
         default:
            runLengthShadow -= 4;
            dataShadow.inUse[runLengthShadow] = true;
            block = dataShadow.block;
            block[lastShadow + 2] = ch;
            block[lastShadow + 3] = ch;
            block[lastShadow + 4] = ch;
            block[lastShadow + 5] = ch;
            block[lastShadow + 6] = (byte)runLengthShadow;
            this.last = lastShadow + 5;
         }
      } else {
         this.endBlock();
         this.initBlock();
         this.writeRun();
      }

   }

   protected void finalize() throws Throwable {
      this.finish();
      super.finalize();
   }

   public void finish() throws IOException {
      if (this.out != null) {
         try {
            if (this.runLength > 0) {
               this.writeRun();
            }

            this.currentChar = -1;
            this.endBlock();
            this.endCompression();
         } finally {
            this.out = null;
            this.data = null;
         }
      }

   }

   public void close() throws IOException {
      if (this.out != null) {
         OutputStream outShadow = this.out;
         this.finish();
         outShadow.close();
      }

   }

   public void flush() throws IOException {
      OutputStream outShadow = this.out;
      if (outShadow != null) {
         outShadow.flush();
      }

   }

   private void init() throws IOException {
      this.data = new CBZip2OutputStream.Data(this.blockSize100k);
      this.bsPutUByte(104);
      this.bsPutUByte(48 + this.blockSize100k);
      this.combinedCRC = 0;
      this.initBlock();
   }

   private void initBlock() {
      this.crc.initialiseCRC();
      this.last = -1;
      boolean[] inUse = this.data.inUse;
      int i = 256;

      while(true) {
         --i;
         if (i < 0) {
            this.allowableBlockSize = this.blockSize100k * 100000 - 20;
            return;
         }

         inUse[i] = false;
      }
   }

   private void endBlock() throws IOException {
      this.blockCRC = this.crc.getFinalCRC();
      this.combinedCRC = this.combinedCRC << 1 | this.combinedCRC >>> 31;
      this.combinedCRC ^= this.blockCRC;
      if (this.last != -1) {
         this.blockSort();
         this.bsPutUByte(49);
         this.bsPutUByte(65);
         this.bsPutUByte(89);
         this.bsPutUByte(38);
         this.bsPutUByte(83);
         this.bsPutUByte(89);
         this.bsPutInt(this.blockCRC);
         if (this.blockRandomised) {
            this.bsW(1, 1);
         } else {
            this.bsW(1, 0);
         }

         this.moveToFrontCodeAndSend();
      }
   }

   private void endCompression() throws IOException {
      this.bsPutUByte(23);
      this.bsPutUByte(114);
      this.bsPutUByte(69);
      this.bsPutUByte(56);
      this.bsPutUByte(80);
      this.bsPutUByte(144);
      this.bsPutInt(this.combinedCRC);
      this.bsFinishedWithStream();
   }

   public final int getBlockSize() {
      return this.blockSize100k;
   }

   public void write(byte[] buf, int offs, int len) throws IOException {
      if (offs < 0) {
         throw new IndexOutOfBoundsException("offs(" + offs + ") < 0.");
      } else if (len < 0) {
         throw new IndexOutOfBoundsException("len(" + len + ") < 0.");
      } else if (offs + len > buf.length) {
         throw new IndexOutOfBoundsException("offs(" + offs + ") + len(" + len + ") > buf.length(" + buf.length + ").");
      } else if (this.out == null) {
         throw new IOException("stream closed");
      } else {
         int hi = offs + len;

         while(offs < hi) {
            this.write0(buf[offs++]);
         }

      }
   }

   private void write0(int b) throws IOException {
      if (this.currentChar != -1) {
         b &= 255;
         if (this.currentChar == b) {
            if (++this.runLength > 254) {
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
         this.currentChar = b & 255;
         ++this.runLength;
      }

   }

   private static void hbAssignCodes(int[] code, byte[] length, int minLen, int maxLen, int alphaSize) {
      int vec = 0;

      for(int n = minLen; n <= maxLen; ++n) {
         for(int i = 0; i < alphaSize; ++i) {
            if ((length[i] & 255) == n) {
               code[i] = vec++;
            }
         }

         vec <<= 1;
      }

   }

   private void bsFinishedWithStream() throws IOException {
      while(this.bsLive > 0) {
         int ch = this.bsBuff >> 24;
         this.out.write(ch);
         this.bsBuff <<= 8;
         this.bsLive -= 8;
      }

   }

   private void bsW(int n, int v) throws IOException {
      OutputStream outShadow = this.out;
      int bsLiveShadow = this.bsLive;

      int bsBuffShadow;
      for(bsBuffShadow = this.bsBuff; bsLiveShadow >= 8; bsLiveShadow -= 8) {
         outShadow.write(bsBuffShadow >> 24);
         bsBuffShadow <<= 8;
      }

      this.bsBuff = bsBuffShadow | v << 32 - bsLiveShadow - n;
      this.bsLive = bsLiveShadow + n;
   }

   private void bsPutUByte(int c) throws IOException {
      this.bsW(8, c);
   }

   private void bsPutInt(int u) throws IOException {
      this.bsW(8, u >> 24 & 255);
      this.bsW(8, u >> 16 & 255);
      this.bsW(8, u >> 8 & 255);
      this.bsW(8, u & 255);
   }

   private void sendMTFValues() throws IOException {
      byte[][] len = this.data.sendMTFValues_len;
      int alphaSize = this.nInUse + 2;
      int t = 6;

      while(true) {
         --t;
         if (t < 0) {
            t = this.nMTF < 200 ? 2 : (this.nMTF < 600 ? 3 : (this.nMTF < 1200 ? 4 : (this.nMTF < 2400 ? 5 : 6)));
            this.sendMTFValues0(t, alphaSize);
            int nSelectors = this.sendMTFValues1(t, alphaSize);
            this.sendMTFValues2(t, nSelectors);
            this.sendMTFValues3(t, alphaSize);
            this.sendMTFValues4();
            this.sendMTFValues5(t, nSelectors);
            this.sendMTFValues6(t, alphaSize);
            this.sendMTFValues7(nSelectors);
            return;
         }

         byte[] len_t = len[t];
         int v = alphaSize;

         while(true) {
            --v;
            if (v < 0) {
               break;
            }

            len_t[v] = 15;
         }
      }
   }

   private void sendMTFValues0(int nGroups, int alphaSize) {
      byte[][] len = this.data.sendMTFValues_len;
      int[] mtfFreq = this.data.mtfFreq;
      int remF = this.nMTF;
      int gs = 0;

      label50:
      for(int nPart = nGroups; nPart > 0; --nPart) {
         int tFreq = remF / nPart;
         int ge = gs - 1;
         int aFreq = 0;

         for(int a = alphaSize - 1; aFreq < tFreq && ge < a; aFreq += mtfFreq[ge]) {
            ++ge;
         }

         if (ge > gs && nPart != nGroups && nPart != 1 && (nGroups - nPart & 1) != 0) {
            aFreq -= mtfFreq[ge--];
         }

         byte[] len_np = len[nPart - 1];
         int v = alphaSize;

         while(true) {
            while(true) {
               --v;
               if (v < 0) {
                  gs = ge + 1;
                  remF -= aFreq;
                  continue label50;
               }

               if (v >= gs && v <= ge) {
                  len_np[v] = 0;
               } else {
                  len_np[v] = 15;
               }
            }
         }
      }

   }

   private int sendMTFValues1(int nGroups, int alphaSize) {
      CBZip2OutputStream.Data dataShadow = this.data;
      int[][] rfreq = dataShadow.sendMTFValues_rfreq;
      int[] fave = dataShadow.sendMTFValues_fave;
      short[] cost = dataShadow.sendMTFValues_cost;
      char[] sfmap = dataShadow.sfmap;
      byte[] selector = dataShadow.selector;
      byte[][] len = dataShadow.sendMTFValues_len;
      byte[] len_0 = len[0];
      byte[] len_1 = len[1];
      byte[] len_2 = len[2];
      byte[] len_3 = len[3];
      byte[] len_4 = len[4];
      byte[] len_5 = len[5];
      int nMTFShadow = this.nMTF;
      int nSelectors = 0;

      for(int iter = 0; iter < 4; ++iter) {
         int gs = nGroups;

         while(true) {
            --gs;
            int bt;
            if (gs < 0) {
               nSelectors = 0;

               int ge;
               for(gs = 0; gs < this.nMTF; gs = ge + 1) {
                  ge = Math.min(gs + 50 - 1, nMTFShadow - 1);
                  int i;
                  short cost_t;
                  if (nGroups == 6) {
                     short cost0 = 0;
                     short cost1 = 0;
                     short cost2 = 0;
                     cost_t = 0;
                     short cost4 = 0;
                     short cost5 = 0;

                     for(int i = gs; i <= ge; ++i) {
                        int icv = sfmap[i];
                        cost0 = (short)(cost0 + (len_0[icv] & 255));
                        cost1 = (short)(cost1 + (len_1[icv] & 255));
                        cost2 = (short)(cost2 + (len_2[icv] & 255));
                        cost_t = (short)(cost_t + (len_3[icv] & 255));
                        cost4 = (short)(cost4 + (len_4[icv] & 255));
                        cost5 = (short)(cost5 + (len_5[icv] & 255));
                     }

                     cost[0] = cost0;
                     cost[1] = cost1;
                     cost[2] = cost2;
                     cost[3] = cost_t;
                     cost[4] = cost4;
                     cost[5] = cost5;
                  } else {
                     bt = nGroups;

                     while(true) {
                        --bt;
                        if (bt < 0) {
                           for(bt = gs; bt <= ge; ++bt) {
                              int icv = sfmap[bt];
                              i = nGroups;

                              while(true) {
                                 --i;
                                 if (i < 0) {
                                    break;
                                 }

                                 cost[i] = (short)(cost[i] + (len[i][icv] & 255));
                              }
                           }
                           break;
                        }

                        cost[bt] = 0;
                     }
                  }

                  bt = -1;
                  int t = nGroups;
                  i = 999999999;

                  while(true) {
                     --t;
                     if (t < 0) {
                        int var10002 = fave[bt]++;
                        selector[nSelectors] = (byte)bt;
                        ++nSelectors;
                        int[] rfreq_bt = rfreq[bt];

                        for(i = gs; i <= ge; ++i) {
                           ++rfreq_bt[sfmap[i]];
                        }
                        break;
                     }

                     cost_t = cost[t];
                     if (cost_t < i) {
                        i = cost_t;
                        bt = t;
                     }
                  }
               }

               for(gs = 0; gs < nGroups; ++gs) {
                  hbMakeCodeLengths(len[gs], rfreq[gs], this.data, alphaSize, 20);
               }
               break;
            }

            fave[gs] = 0;
            int[] rfreqt = rfreq[gs];
            bt = alphaSize;

            while(true) {
               --bt;
               if (bt < 0) {
                  break;
               }

               rfreqt[bt] = 0;
            }
         }
      }

      return nSelectors;
   }

   private void sendMTFValues2(int nGroups, int nSelectors) {
      CBZip2OutputStream.Data dataShadow = this.data;
      byte[] pos = dataShadow.sendMTFValues2_pos;
      int i = nGroups;

      while(true) {
         --i;
         if (i < 0) {
            for(i = 0; i < nSelectors; ++i) {
               byte ll_i = dataShadow.selector[i];
               byte tmp = pos[0];

               int j;
               byte tmp2;
               for(j = 0; ll_i != tmp; pos[j] = tmp2) {
                  ++j;
                  tmp2 = tmp;
                  tmp = pos[j];
               }

               pos[0] = tmp;
               dataShadow.selectorMtf[i] = (byte)j;
            }

            return;
         }

         pos[i] = (byte)i;
      }
   }

   private void sendMTFValues3(int nGroups, int alphaSize) {
      int[][] code = this.data.sendMTFValues_code;
      byte[][] len = this.data.sendMTFValues_len;

      for(int t = 0; t < nGroups; ++t) {
         int minLen = 32;
         int maxLen = 0;
         byte[] len_t = len[t];
         int i = alphaSize;

         while(true) {
            --i;
            if (i < 0) {
               hbAssignCodes(code[t], len[t], minLen, maxLen, alphaSize);
               break;
            }

            int l = len_t[i] & 255;
            if (l > maxLen) {
               maxLen = l;
            }

            if (l < minLen) {
               minLen = l;
            }
         }
      }

   }

   private void sendMTFValues4() throws IOException {
      boolean[] inUse = this.data.inUse;
      boolean[] inUse16 = this.data.sentMTFValues4_inUse16;
      int i = 16;

      while(true) {
         --i;
         int bsLiveShadow;
         int bsBuffShadow;
         if (i < 0) {
            for(i = 0; i < 16; ++i) {
               this.bsW(1, inUse16[i] ? 1 : 0);
            }

            OutputStream outShadow = this.out;
            bsLiveShadow = this.bsLive;
            bsBuffShadow = this.bsBuff;

            for(int i = 0; i < 16; ++i) {
               if (inUse16[i]) {
                  int i16 = i * 16;

                  for(int j = 0; j < 16; ++j) {
                     while(bsLiveShadow >= 8) {
                        outShadow.write(bsBuffShadow >> 24);
                        bsBuffShadow <<= 8;
                        bsLiveShadow -= 8;
                     }

                     if (inUse[i16 + j]) {
                        bsBuffShadow |= 1 << 32 - bsLiveShadow - 1;
                     }

                     ++bsLiveShadow;
                  }
               }
            }

            this.bsBuff = bsBuffShadow;
            this.bsLive = bsLiveShadow;
            return;
         }

         inUse16[i] = false;
         bsLiveShadow = i * 16;
         bsBuffShadow = 16;

         while(true) {
            --bsBuffShadow;
            if (bsBuffShadow < 0) {
               break;
            }

            if (inUse[bsLiveShadow + bsBuffShadow]) {
               inUse16[i] = true;
            }
         }
      }
   }

   private void sendMTFValues5(int nGroups, int nSelectors) throws IOException {
      this.bsW(3, nGroups);
      this.bsW(15, nSelectors);
      OutputStream outShadow = this.out;
      byte[] selectorMtf = this.data.selectorMtf;
      int bsLiveShadow = this.bsLive;
      int bsBuffShadow = this.bsBuff;

      for(int i = 0; i < nSelectors; ++i) {
         int j = 0;

         for(int hj = selectorMtf[i] & 255; j < hj; ++j) {
            while(bsLiveShadow >= 8) {
               outShadow.write(bsBuffShadow >> 24);
               bsBuffShadow <<= 8;
               bsLiveShadow -= 8;
            }

            bsBuffShadow |= 1 << 32 - bsLiveShadow - 1;
            ++bsLiveShadow;
         }

         while(bsLiveShadow >= 8) {
            outShadow.write(bsBuffShadow >> 24);
            bsBuffShadow <<= 8;
            bsLiveShadow -= 8;
         }

         ++bsLiveShadow;
      }

      this.bsBuff = bsBuffShadow;
      this.bsLive = bsLiveShadow;
   }

   private void sendMTFValues6(int nGroups, int alphaSize) throws IOException {
      byte[][] len = this.data.sendMTFValues_len;
      OutputStream outShadow = this.out;
      int bsLiveShadow = this.bsLive;
      int bsBuffShadow = this.bsBuff;

      for(int t = 0; t < nGroups; ++t) {
         byte[] len_t = len[t];

         int curr;
         for(curr = len_t[0] & 255; bsLiveShadow >= 8; bsLiveShadow -= 8) {
            outShadow.write(bsBuffShadow >> 24);
            bsBuffShadow <<= 8;
         }

         bsBuffShadow |= curr << 32 - bsLiveShadow - 5;
         bsLiveShadow += 5;

         for(int i = 0; i < alphaSize; ++i) {
            int lti;
            for(lti = len_t[i] & 255; curr < lti; ++curr) {
               while(bsLiveShadow >= 8) {
                  outShadow.write(bsBuffShadow >> 24);
                  bsBuffShadow <<= 8;
                  bsLiveShadow -= 8;
               }

               bsBuffShadow |= 2 << 32 - bsLiveShadow - 2;
               bsLiveShadow += 2;
            }

            while(curr > lti) {
               while(bsLiveShadow >= 8) {
                  outShadow.write(bsBuffShadow >> 24);
                  bsBuffShadow <<= 8;
                  bsLiveShadow -= 8;
               }

               bsBuffShadow |= 3 << 32 - bsLiveShadow - 2;
               bsLiveShadow += 2;
               --curr;
            }

            while(bsLiveShadow >= 8) {
               outShadow.write(bsBuffShadow >> 24);
               bsBuffShadow <<= 8;
               bsLiveShadow -= 8;
            }

            ++bsLiveShadow;
         }
      }

      this.bsBuff = bsBuffShadow;
      this.bsLive = bsLiveShadow;
   }

   private void sendMTFValues7(int nSelectors) throws IOException {
      CBZip2OutputStream.Data dataShadow = this.data;
      byte[][] len = dataShadow.sendMTFValues_len;
      int[][] code = dataShadow.sendMTFValues_code;
      OutputStream outShadow = this.out;
      byte[] selector = dataShadow.selector;
      char[] sfmap = dataShadow.sfmap;
      int nMTFShadow = this.nMTF;
      int selCtr = 0;
      int bsLiveShadow = this.bsLive;
      int bsBuffShadow = this.bsBuff;

      for(int gs = 0; gs < nMTFShadow; ++selCtr) {
         int ge = Math.min(gs + 50 - 1, nMTFShadow - 1);
         int selector_selCtr = selector[selCtr] & 255;
         int[] code_selCtr = code[selector_selCtr];

         for(byte[] len_selCtr = len[selector_selCtr]; gs <= ge; ++gs) {
            char sfmap_i;
            for(sfmap_i = sfmap[gs]; bsLiveShadow >= 8; bsLiveShadow -= 8) {
               outShadow.write(bsBuffShadow >> 24);
               bsBuffShadow <<= 8;
            }

            int n = len_selCtr[sfmap_i] & 255;
            bsBuffShadow |= code_selCtr[sfmap_i] << 32 - bsLiveShadow - n;
            bsLiveShadow += n;
         }

         gs = ge + 1;
      }

      this.bsBuff = bsBuffShadow;
      this.bsLive = bsLiveShadow;
   }

   private void moveToFrontCodeAndSend() throws IOException {
      this.bsW(24, this.origPtr);
      this.generateMTFValues();
      this.sendMTFValues();
   }

   private boolean mainSimpleSort(CBZip2OutputStream.Data dataShadow, int lo, int hi, int d) {
      int bigN = hi - lo + 1;
      if (bigN < 2) {
         return this.firstAttempt && this.workDone > this.workLimit;
      } else {
         int hp;
         for(hp = 0; INCS[hp] < bigN; ++hp) {
         }

         int[] fmap = dataShadow.fmap;
         char[] quadrant = dataShadow.quadrant;
         byte[] block = dataShadow.block;
         int lastShadow = this.last;
         int lastPlus1 = lastShadow + 1;
         boolean firstAttemptShadow = this.firstAttempt;
         int workLimitShadow = this.workLimit;
         int workDoneShadow = this.workDone;

         label187:
         while(true) {
            --hp;
            if (hp < 0) {
               break;
            }

            int h = INCS[hp];
            int mj = lo + h - 1;
            int i = lo + h;

            while(i <= hi) {
               for(int k = 3; i <= hi; ++i) {
                  --k;
                  if (k < 0) {
                     break;
                  }

                  int v = fmap[i];
                  int vd = v + d;
                  int j = i;
                  boolean onceRunned = false;
                  int a = 0;

                  int i1;
                  int i2;
                  label179:
                  do {
                     while(true) {
                        while(true) {
                           while(true) {
                              while(true) {
                                 while(true) {
                                    while(true) {
                                       while(true) {
                                          if (onceRunned) {
                                             fmap[j] = a;
                                             if ((j -= h) <= mj) {
                                                break label179;
                                             }
                                          } else {
                                             onceRunned = true;
                                          }

                                          a = fmap[j - h];
                                          i1 = a + d;
                                          if (block[i1 + 1] == block[vd + 1]) {
                                             if (block[i1 + 2] == block[vd + 2]) {
                                                if (block[i1 + 3] == block[vd + 3]) {
                                                   if (block[i1 + 4] == block[vd + 4]) {
                                                      if (block[i1 + 5] == block[vd + 5]) {
                                                         i1 += 6;
                                                         byte var10000 = block[i1];
                                                         i2 = vd + 6;
                                                         if (var10000 == block[i2]) {
                                                            int x = lastShadow;

                                                            while(true) {
                                                               if (x <= 0) {
                                                                  break label179;
                                                               }

                                                               x -= 4;
                                                               if (block[i1 + 1] != block[i2 + 1]) {
                                                                  if ((block[i1 + 1] & 255) <= (block[i2 + 1] & 255)) {
                                                                     break label179;
                                                                  }
                                                                  break;
                                                               }

                                                               if (quadrant[i1] != quadrant[i2]) {
                                                                  if (quadrant[i1] <= quadrant[i2]) {
                                                                     break label179;
                                                                  }
                                                                  break;
                                                               }

                                                               if (block[i1 + 2] != block[i2 + 2]) {
                                                                  if ((block[i1 + 2] & 255) <= (block[i2 + 2] & 255)) {
                                                                     break label179;
                                                                  }
                                                                  break;
                                                               }

                                                               if (quadrant[i1 + 1] != quadrant[i2 + 1]) {
                                                                  if (quadrant[i1 + 1] <= quadrant[i2 + 1]) {
                                                                     break label179;
                                                                  }
                                                                  break;
                                                               }

                                                               if (block[i1 + 3] != block[i2 + 3]) {
                                                                  if ((block[i1 + 3] & 255) <= (block[i2 + 3] & 255)) {
                                                                     break label179;
                                                                  }
                                                                  break;
                                                               }

                                                               if (quadrant[i1 + 2] != quadrant[i2 + 2]) {
                                                                  if (quadrant[i1 + 2] <= quadrant[i2 + 2]) {
                                                                     break label179;
                                                                  }
                                                                  break;
                                                               }

                                                               if (block[i1 + 4] != block[i2 + 4]) {
                                                                  if ((block[i1 + 4] & 255) <= (block[i2 + 4] & 255)) {
                                                                     break label179;
                                                                  }
                                                                  break;
                                                               }

                                                               if (quadrant[i1 + 3] != quadrant[i2 + 3]) {
                                                                  continue label179;
                                                               }

                                                               i1 += 4;
                                                               if (i1 >= lastPlus1) {
                                                                  i1 -= lastPlus1;
                                                               }

                                                               i2 += 4;
                                                               if (i2 >= lastPlus1) {
                                                                  i2 -= lastPlus1;
                                                               }

                                                               ++workDoneShadow;
                                                            }
                                                         } else if ((block[i1] & 255) <= (block[i2] & 255)) {
                                                            break label179;
                                                         }
                                                      } else if ((block[i1 + 5] & 255) <= (block[vd + 5] & 255)) {
                                                         break label179;
                                                      }
                                                   } else if ((block[i1 + 4] & 255) <= (block[vd + 4] & 255)) {
                                                      break label179;
                                                   }
                                                } else if ((block[i1 + 3] & 255) <= (block[vd + 3] & 255)) {
                                                   break label179;
                                                }
                                             } else if ((block[i1 + 2] & 255) <= (block[vd + 2] & 255)) {
                                                break label179;
                                             }
                                          } else if ((block[i1 + 1] & 255) <= (block[vd + 1] & 255)) {
                                             break label179;
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                  } while(quadrant[i1 + 3] > quadrant[i2 + 3]);

                  fmap[j] = v;
               }

               if (firstAttemptShadow && i <= hi && workDoneShadow > workLimitShadow) {
                  break label187;
               }
            }
         }

         this.workDone = workDoneShadow;
         return firstAttemptShadow && workDoneShadow > workLimitShadow;
      }
   }

   private static void vswap(int[] fmap, int p1, int p2, int n) {
      int t;
      for(n += p1; p1 < n; fmap[p2++] = t) {
         t = fmap[p1];
         fmap[p1++] = fmap[p2];
      }

   }

   private static byte med3(byte a, byte b, byte c) {
      return a < b ? (b < c ? b : (a < c ? c : a)) : (b > c ? b : (a > c ? c : a));
   }

   private void blockSort() {
      this.workLimit = 30 * this.last;
      this.workDone = 0;
      this.blockRandomised = false;
      this.firstAttempt = true;
      this.mainSort();
      if (this.firstAttempt && this.workDone > this.workLimit) {
         this.workLimit = this.workDone = 0;
         this.firstAttempt = false;
         this.mainSort();
      }

      int[] fmap = this.data.fmap;
      this.origPtr = -1;
      int i = 0;

      for(int lastShadow = this.last; i <= lastShadow; ++i) {
         if (fmap[i] == 0) {
            this.origPtr = i;
            break;
         }
      }

   }

   private void mainQSort3(CBZip2OutputStream.Data dataShadow, int loSt, int hiSt, int dSt) {
      int[] stack_ll = dataShadow.stack_ll;
      int[] stack_hh = dataShadow.stack_hh;
      int[] stack_dd = dataShadow.stack_dd;
      int[] fmap = dataShadow.fmap;
      byte[] block = dataShadow.block;
      stack_ll[0] = loSt;
      stack_hh[0] = hiSt;
      stack_dd[0] = dSt;
      int sp = 1;

      while(true) {
         label46:
         while(true) {
            --sp;
            if (sp < 0) {
               return;
            }

            int lo = stack_ll[sp];
            int hi = stack_hh[sp];
            int d = stack_dd[sp];
            if (hi - lo >= 20 && d <= 10) {
               int d1 = d + 1;
               int med = med3(block[fmap[lo] + d1], block[fmap[hi] + d1], block[fmap[lo + hi >>> 1] + d1]) & 255;
               int unLo = lo;
               int unHi = hi;
               int ltLo = lo;
               int gtHi = hi;

               while(true) {
                  while(true) {
                     int n;
                     int m;
                     if (unLo <= unHi) {
                        n = (block[fmap[unLo] + d1] & 255) - med;
                        if (n == 0) {
                           m = fmap[unLo];
                           fmap[unLo++] = fmap[ltLo];
                           fmap[ltLo++] = m;
                           continue;
                        }

                        if (n < 0) {
                           ++unLo;
                           continue;
                        }
                     }

                     while(unLo <= unHi) {
                        n = (block[fmap[unHi] + d1] & 255) - med;
                        if (n == 0) {
                           m = fmap[unHi];
                           fmap[unHi--] = fmap[gtHi];
                           fmap[gtHi--] = m;
                        } else {
                           if (n <= 0) {
                              break;
                           }

                           --unHi;
                        }
                     }

                     if (unLo > unHi) {
                        if (gtHi < ltLo) {
                           stack_ll[sp] = lo;
                           stack_hh[sp] = hi;
                           stack_dd[sp] = d1;
                           ++sp;
                        } else {
                           n = ltLo - lo < unLo - ltLo ? ltLo - lo : unLo - ltLo;
                           vswap(fmap, lo, unLo - n, n);
                           m = hi - gtHi < gtHi - unHi ? hi - gtHi : gtHi - unHi;
                           vswap(fmap, unLo, hi - m + 1, m);
                           n = lo + unLo - ltLo - 1;
                           m = hi - (gtHi - unHi) + 1;
                           stack_ll[sp] = lo;
                           stack_hh[sp] = n;
                           stack_dd[sp] = d;
                           ++sp;
                           stack_ll[sp] = n + 1;
                           stack_hh[sp] = m - 1;
                           stack_dd[sp] = d1;
                           ++sp;
                           stack_ll[sp] = m;
                           stack_hh[sp] = hi;
                           stack_dd[sp] = d;
                           ++sp;
                        }
                        continue label46;
                     }

                     n = fmap[unLo];
                     fmap[unLo++] = fmap[unHi];
                     fmap[unHi--] = n;
                  }
               }
            } else if (this.mainSimpleSort(dataShadow, lo, hi, d)) {
               return;
            }
         }
      }
   }

   private void mainSort() {
      CBZip2OutputStream.Data dataShadow = this.data;
      int[] runningOrder = dataShadow.mainSort_runningOrder;
      int[] copy = dataShadow.mainSort_copy;
      boolean[] bigDone = dataShadow.mainSort_bigDone;
      int[] ftab = dataShadow.ftab;
      byte[] block = dataShadow.block;
      int[] fmap = dataShadow.fmap;
      char[] quadrant = dataShadow.quadrant;
      int lastShadow = this.last;
      int workLimitShadow = this.workLimit;
      boolean firstAttemptShadow = this.firstAttempt;
      int c1 = 65537;

      while(true) {
         --c1;
         if (c1 < 0) {
            for(c1 = 0; c1 < 20; ++c1) {
               block[lastShadow + c1 + 2] = block[c1 % (lastShadow + 1) + 1];
            }

            c1 = lastShadow + 20 + 1;

            while(true) {
               --c1;
               if (c1 < 0) {
                  block[0] = block[lastShadow + 1];
                  c1 = block[0] & 255;

                  int i;
                  int ss;
                  for(i = 0; i <= lastShadow; ++i) {
                     ss = block[i + 1] & 255;
                     ++ftab[(c1 << 8) + ss];
                     c1 = ss;
                  }

                  for(i = 1; i <= 65536; ++i) {
                     ftab[i] += ftab[i - 1];
                  }

                  c1 = block[1] & 255;

                  for(i = 0; i < lastShadow; ++i) {
                     ss = block[i + 2] & 255;
                     fmap[--ftab[(c1 << 8) + ss]] = i;
                     c1 = ss;
                  }

                  fmap[--ftab[((block[lastShadow + 1] & 255) << 8) + (block[1] & 255)]] = lastShadow;
                  i = 256;

                  while(true) {
                     --i;
                     if (i < 0) {
                        i = 364;

                        int bbStart;
                        int bbSize;
                        int shifts;
                        int j;
                        int a2update;
                        while(i != 1) {
                           i /= 3;

                           for(ss = i; ss <= 255; ++ss) {
                              bbStart = runningOrder[ss];
                              bbSize = ftab[bbStart + 1 << 8] - ftab[bbStart << 8];
                              shifts = i - 1;
                              j = ss;

                              for(a2update = runningOrder[ss - i]; ftab[a2update + 1 << 8] - ftab[a2update << 8] > bbSize; a2update = runningOrder[j - i]) {
                                 runningOrder[j] = a2update;
                                 j -= i;
                                 if (j <= shifts) {
                                    break;
                                 }
                              }

                              runningOrder[j] = bbStart;
                           }
                        }

                        for(i = 0; i <= 255; ++i) {
                           ss = runningOrder[i];

                           for(bbStart = 0; bbStart <= 255; ++bbStart) {
                              bbSize = (ss << 8) + bbStart;
                              shifts = ftab[bbSize];
                              if ((shifts & 2097152) != 2097152) {
                                 j = shifts & -2097153;
                                 a2update = (ftab[bbSize + 1] & -2097153) - 1;
                                 if (a2update > j) {
                                    this.mainQSort3(dataShadow, j, a2update, 2);
                                    if (firstAttemptShadow && this.workDone > workLimitShadow) {
                                       return;
                                    }
                                 }

                                 ftab[bbSize] = shifts | 2097152;
                              }
                           }

                           for(bbStart = 0; bbStart <= 255; ++bbStart) {
                              copy[bbStart] = ftab[(bbStart << 8) + ss] & -2097153;
                           }

                           bbStart = ftab[ss << 8] & -2097153;

                           for(bbSize = ftab[ss + 1 << 8] & -2097153; bbStart < bbSize; ++bbStart) {
                              shifts = fmap[bbStart];
                              c1 = block[shifts] & 255;
                              if (!bigDone[c1]) {
                                 fmap[copy[c1]] = shifts == 0 ? lastShadow : shifts - 1;
                                 int var10002 = copy[c1]++;
                              }
                           }

                           bbStart = 256;

                           while(true) {
                              --bbStart;
                              if (bbStart < 0) {
                                 bigDone[ss] = true;
                                 if (i < 255) {
                                    bbStart = ftab[ss << 8] & -2097153;
                                    bbSize = (ftab[ss + 1 << 8] & -2097153) - bbStart;

                                    for(shifts = 0; bbSize >> shifts > 65534; ++shifts) {
                                    }

                                    for(j = 0; j < bbSize; ++j) {
                                       a2update = fmap[bbStart + j];
                                       char qVal = (char)(j >> shifts);
                                       quadrant[a2update] = qVal;
                                       if (a2update < 20) {
                                          quadrant[a2update + lastShadow + 1] = qVal;
                                       }
                                    }
                                 }
                                 break;
                              }

                              ftab[(bbStart << 8) + ss] |= 2097152;
                           }
                        }

                        return;
                     }

                     bigDone[i] = false;
                     runningOrder[i] = i;
                  }
               }

               quadrant[c1] = 0;
            }
         }

         ftab[c1] = 0;
      }
   }

   private void randomiseBlock() {
      boolean[] inUse = this.data.inUse;
      byte[] block = this.data.block;
      int lastShadow = this.last;
      int rNToGo = 256;

      while(true) {
         --rNToGo;
         if (rNToGo < 0) {
            rNToGo = 0;
            int rTPos = 0;
            int i = 0;

            for(int j = 1; i <= lastShadow; i = j++) {
               if (rNToGo == 0) {
                  rNToGo = (char)BZip2Constants.rNums[rTPos];
                  ++rTPos;
                  if (rTPos == 512) {
                     rTPos = 0;
                  }
               }

               --rNToGo;
               block[j] = (byte)(block[j] ^ (rNToGo == 1 ? 1 : 0));
               inUse[block[j] & 255] = true;
            }

            this.blockRandomised = true;
            return;
         }

         inUse[rNToGo] = false;
      }
   }

   private void generateMTFValues() {
      int lastShadow = this.last;
      CBZip2OutputStream.Data dataShadow = this.data;
      boolean[] inUse = dataShadow.inUse;
      byte[] block = dataShadow.block;
      int[] fmap = dataShadow.fmap;
      char[] sfmap = dataShadow.sfmap;
      int[] mtfFreq = dataShadow.mtfFreq;
      byte[] unseqToSeq = dataShadow.unseqToSeq;
      byte[] yy = dataShadow.generateMTFValues_yy;
      int nInUseShadow = 0;

      int eob;
      for(eob = 0; eob < 256; ++eob) {
         if (inUse[eob]) {
            unseqToSeq[eob] = (byte)nInUseShadow;
            ++nInUseShadow;
         }
      }

      this.nInUse = nInUseShadow;
      eob = nInUseShadow + 1;

      int wr;
      for(wr = eob; wr >= 0; --wr) {
         mtfFreq[wr] = 0;
      }

      wr = nInUseShadow;

      while(true) {
         --wr;
         if (wr < 0) {
            wr = 0;
            int zPend = 0;

            int var10002;
            for(int i = 0; i <= lastShadow; ++i) {
               byte ll_i = unseqToSeq[block[fmap[i]] & 255];
               byte tmp = yy[0];

               int j;
               byte tmp2;
               for(j = 0; ll_i != tmp; yy[j] = tmp2) {
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
                        if ((zPend & 1) == 0) {
                           sfmap[wr] = 0;
                           ++wr;
                           var10002 = mtfFreq[0]++;
                        } else {
                           sfmap[wr] = 1;
                           ++wr;
                           var10002 = mtfFreq[1]++;
                        }

                        if (zPend < 2) {
                           zPend = 0;
                           break;
                        }

                        zPend = zPend - 2 >> 1;
                     }
                  }

                  sfmap[wr] = (char)(j + 1);
                  ++wr;
                  ++mtfFreq[j + 1];
               }
            }

            if (zPend > 0) {
               --zPend;

               while(true) {
                  if ((zPend & 1) == 0) {
                     sfmap[wr] = 0;
                     ++wr;
                     var10002 = mtfFreq[0]++;
                  } else {
                     sfmap[wr] = 1;
                     ++wr;
                     var10002 = mtfFreq[1]++;
                  }

                  if (zPend < 2) {
                     break;
                  }

                  zPend = zPend - 2 >> 1;
               }
            }

            sfmap[wr] = (char)eob;
            var10002 = mtfFreq[eob]++;
            this.nMTF = wr + 1;
            return;
         }

         yy[wr] = (byte)wr;
      }
   }

   private static final class Data {
      final boolean[] inUse = new boolean[256];
      final byte[] unseqToSeq = new byte[256];
      final int[] mtfFreq = new int[258];
      final byte[] selector = new byte[18002];
      final byte[] selectorMtf = new byte[18002];
      final byte[] generateMTFValues_yy = new byte[256];
      final byte[][] sendMTFValues_len = new byte[6][258];
      final int[][] sendMTFValues_rfreq = new int[6][258];
      final int[] sendMTFValues_fave = new int[6];
      final short[] sendMTFValues_cost = new short[6];
      final int[][] sendMTFValues_code = new int[6][258];
      final byte[] sendMTFValues2_pos = new byte[6];
      final boolean[] sentMTFValues4_inUse16 = new boolean[16];
      final int[] stack_ll = new int[1000];
      final int[] stack_hh = new int[1000];
      final int[] stack_dd = new int[1000];
      final int[] mainSort_runningOrder = new int[256];
      final int[] mainSort_copy = new int[256];
      final boolean[] mainSort_bigDone = new boolean[256];
      final int[] heap = new int[260];
      final int[] weight = new int[516];
      final int[] parent = new int[516];
      final int[] ftab = new int[65537];
      final byte[] block;
      final int[] fmap;
      final char[] sfmap;
      final char[] quadrant;

      Data(int blockSize100k) {
         int n = blockSize100k * 100000;
         this.block = new byte[n + 1 + 20];
         this.fmap = new int[n];
         this.sfmap = new char[2 * n];
         this.quadrant = this.sfmap;
      }
   }
}
