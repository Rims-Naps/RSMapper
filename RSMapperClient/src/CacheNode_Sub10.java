public class CacheNode_Sub10 extends CacheNode {
   static int anInt9514;
   private int[][] anIntArrayArray9515;
   protected Class109 aClass109_9516;
   static int anInt9517;
   private int[] anIntArray9518;
   static int anInt9519;
   static int[] anIntArray9520 = new int[32];
   protected boolean aBoolean9521 = true;
   protected int[] anIntArray9522;
   static int anInt9523;
   static int anInt9524;
   static int anInt9525;
   static int anInt9526;
   static int anInt9527;
   static int anInt9528;
   private String[] aStringArray9529;
   static HashTable aHashTable9530 = new HashTable(8);

   final Class151 method2324(int i, int i_0_) {
      ++anInt9526;
      int i_1_ = 19 % ((43 - i) / 62);
      return this.anIntArray9518 != null && ~i_0_ <= -1 && ~i_0_ >= ~this.anIntArray9518.length
         ? Class240.method3028((byte)31, this.anIntArray9518[i_0_])
         : null;
   }

   final void method2325(Buffer buffer, int i) {
      while(true) {
         int i_2_ = buffer.readUnsignedByte();
         if (i_2_ == 0) {
            if (i != -958) {
               this.method2328(-6);
            }

            ++anInt9514;
            return;
         }

         this.method2333(buffer, i + 958, i_2_);
      }
   }

   final int method2326(int i, boolean bool, int i_3_) {
      ++anInt9523;
      if (this.anIntArray9518 == null || ~i > -1 || ~i < ~this.anIntArray9518.length) {
         return -1;
      } else if (this.anIntArrayArray9515[i] != null && i_3_ >= 0 && ~i_3_ >= ~this.anIntArrayArray9515[i].length) {
         if (!bool) {
            this.method2326(68, true, 121);
         }

         return this.anIntArrayArray9515[i][i_3_];
      } else {
         return -1;
      }
   }

   final int method2327(byte b) {
      ++anInt9519;
      if (b <= 31) {
         return 39;
      } else {
         return this.anIntArray9518 == null ? 0 : this.anIntArray9518.length;
      }
   }

   final void method2328(int i) {
      ++anInt9527;
      if (this.anIntArray9522 != null) {
         for(int i_4_ = 0; i_4_ < this.anIntArray9522.length; ++i_4_) {
            this.anIntArray9522[i_4_] = Node_Sub16.method2590(this.anIntArray9522[i_4_], 32768);
         }
      }

      if (i < 0) {
         this.method2327((byte)-55);
      }
   }

   final String method2329(Buffer buffer) {
      ++anInt9525;
      StringBuffer stringbuffer = new StringBuffer(80);
      if (this.anIntArray9518 != null) {
         for(int i = 0; ~i > ~this.anIntArray9518.length; ++i) {
            stringbuffer.append(this.aStringArray9529[i]);
            stringbuffer.append(
               this.aClass109_9516
                  .method1126(
                     this.method2324(-28, i),
                     buffer.method2244(Class240.method3028((byte)9, this.anIntArray9518[i]).anInt1847, 8),
                     this.anIntArrayArray9515[i],
                     1
                  )
            );
         }
      }

      stringbuffer.append(this.aStringArray9529[-1 + this.aStringArray9529.length]);
      return stringbuffer.toString();
   }

   final void method2330(Buffer buffer, int[] is, int i) {
      ++anInt9524;
      if (this.anIntArray9518 != null && i >= 118) {
         for(int i_5_ = 0; this.anIntArray9518.length > i_5_ && is.length > i_5_; ++i_5_) {
            int i_6_ = this.method2324(105, i_5_).anInt1846;
            if (~i_6_ < -1) {
               buffer.method2206((byte)126, i_6_, (long)is[i_5_]);
            }
         }
      }
   }

   public static void method2331(int i) {
      anIntArray9520 = null;
      aHashTable9530 = null;
      if (i != 1) {
         aHashTable9530 = null;
      }
   }

   final String method2332(int i) {
      ++anInt9528;
      StringBuffer stringbuffer = new StringBuffer(80);
      if (this.aStringArray9529 == null) {
         return "";
      } else {
         stringbuffer.append(this.aStringArray9529[0]);
         if (i != -19244) {
            anIntArray9520 = null;
         }

         for(int i_7_ = 1; this.aStringArray9529.length > i_7_; ++i_7_) {
            stringbuffer.append("...");
            stringbuffer.append(this.aStringArray9529[i_7_]);
         }

         return stringbuffer.toString();
      }
   }

   private final void method2333(Buffer buffer, int i, int opcode) {
      ++anInt9517;
      if (~opcode != -2) {
         if (~opcode == -3) {
            int i_9_ = buffer.readUnsignedByte();
            this.anIntArray9522 = new int[i_9_];

            for(int i_10_ = 0; ~i_10_ > ~i_9_; ++i_10_) {
               this.anIntArray9522[i_10_] = buffer.readUnsignedShort();
            }
         } else if (~opcode == -4) {
            int i_11_ = buffer.readUnsignedByte();
            this.anIntArrayArray9515 = new int[i_11_][];
            this.anIntArray9518 = new int[i_11_];

            for(int i_12_ = 0; ~i_12_ > ~i_11_; ++i_12_) {
               int i_13_ = buffer.readUnsignedShort();
               Class151 class151 = Class240.method3028((byte)84, i_13_);
               if (class151 != null) {
                  this.anIntArray9518[i_12_] = i_13_;
                  this.anIntArrayArray9515[i_12_] = new int[class151.anInt1842];

                  for(int i_14_ = 0; ~class151.anInt1842 < ~i_14_; ++i_14_) {
                     this.anIntArrayArray9515[i_12_][i_14_] = buffer.readUnsignedShort();
                  }
               }
            }
         } else if (opcode == 4) {
            this.aBoolean9521 = false;
         }
      } else {
         this.aStringArray9529 = Class106.method1120((byte)-102, buffer.readString(), '<');
      }

      if (i != 0) {
         this.method2326(21, true, -113);
      }
   }
}
