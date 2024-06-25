public class IsaacCipher {
   static Class139 aClass139_1829 = new Class139();
   private int anInt1830;
   private int anInt1831;
   private int[] anIntArray1832 = new int[256];
   static int anInt1833;
   private int[] anIntArray1834 = new int[256];
   static int anInt1835;
   private int anInt1836;
   static int anInt1837;
   static int anInt1838;
   private int anInt1839;
   static Class54[] aClass54Array1840;

   private final void method1666(int i) {
      ++anInt1833;
      int i_7_ = -1640531527;
      int i_6_ = -1640531527;
      int i_5_ = -1640531527;
      int i_4_ = -1640531527;
      int i_3_ = -1640531527;
      int i_2_ = -1640531527;
      int i_1_ = -1640531527;
      int i_0_ = -1640531527;

      for(int i_8_ = 0; ~i_8_ > -5; ++i_8_) {
         i_0_ ^= i_1_ << 11;
         int var11 = i_1_ + i_2_;
         int var27 = i_3_ + i_0_;
         int var12 = var11 ^ i_2_ >>> 2;
         i_2_ += var27;
         int var35 = i_4_ + var12;
         i_2_ ^= var27 << 8;
         int var43 = i_5_ + i_2_;
         int var28 = var27 + var35;
         i_3_ = var28 ^ var35 >>> 16;
         int var36 = var35 + var43;
         int var51 = i_6_ + i_3_;
         i_4_ = var36 ^ var43 << 10;
         int var59 = i_7_ + i_4_;
         int var44 = var43 + var51;
         i_5_ = var44 ^ var51 >>> 4;
         i_0_ += i_5_;
         int var52 = var51 + var59;
         i_6_ = var52 ^ var59 << 8;
         int var60 = var59 + i_0_;
         i_1_ = var12 + i_6_;
         i_7_ = var60 ^ i_0_ >>> 9;
         i_2_ += i_7_;
         i_0_ += i_1_;
      }

      if (i != 17544) {
         aClass54Array1840 = null;
      }

      for(int i_9_ = 0; ~i_9_ > -257; i_9_ += 8) {
         int var53 = i_6_ + this.anIntArray1832[6 + i_9_];
         int var45 = i_5_ + this.anIntArray1832[5 + i_9_];
         int var69 = i_0_ + this.anIntArray1832[i_9_];
         int var29 = i_3_ + this.anIntArray1832[3 + i_9_];
         int var37 = i_4_ + this.anIntArray1832[i_9_ - -4];
         int var61 = i_7_ + this.anIntArray1832[i_9_ - -7];
         int var13 = i_1_ + this.anIntArray1832[1 + i_9_];
         int var21 = i_2_ + this.anIntArray1832[2 + i_9_];
         int var70 = var69 ^ var13 << 11;
         int var30 = var29 + var70;
         int var14 = var13 + var21;
         int var15 = var14 ^ var21 >>> 2;
         int var38 = var37 + var15;
         int var22 = var21 + var30;
         int var23 = var22 ^ var30 << 8;
         int var46 = var45 + var23;
         int var31 = var30 + var38;
         i_3_ = var31 ^ var38 >>> 16;
         int var54 = var53 + i_3_;
         int var39 = var38 + var46;
         i_4_ = var39 ^ var46 << 10;
         int var62 = var61 + i_4_;
         int var47 = var46 + var54;
         i_5_ = var47 ^ var54 >>> 4;
         int var71 = var70 + i_5_;
         int var55 = var54 + var62;
         i_6_ = var55 ^ var62 << 8;
         i_1_ = var15 + i_6_;
         int var63 = var62 + var71;
         i_7_ = var63 ^ var71 >>> 9;
         i_0_ = var71 + i_1_;
         i_2_ = var23 + i_7_;
         this.anIntArray1834[i_9_] = i_0_;
         this.anIntArray1834[1 + i_9_] = i_1_;
         this.anIntArray1834[i_9_ - -2] = i_2_;
         this.anIntArray1834[i_9_ + 3] = i_3_;
         this.anIntArray1834[i_9_ - -4] = i_4_;
         this.anIntArray1834[5 + i_9_] = i_5_;
         this.anIntArray1834[6 + i_9_] = i_6_;
         this.anIntArray1834[i_9_ + 7] = i_7_;
      }

      for(int i_10_ = 0; i_10_ < 256; i_10_ += 8) {
         int var64 = i_7_ + this.anIntArray1834[7 + i_10_];
         int var16 = i_1_ + this.anIntArray1834[1 + i_10_];
         int var40 = i_4_ + this.anIntArray1834[i_10_ + 4];
         int var32 = i_3_ + this.anIntArray1834[i_10_ - -3];
         int var24 = i_2_ + this.anIntArray1834[2 + i_10_];
         int var56 = i_6_ + this.anIntArray1834[6 + i_10_];
         int var48 = i_5_ + this.anIntArray1834[5 + i_10_];
         int var72 = i_0_ + this.anIntArray1834[i_10_];
         int var73 = var72 ^ var16 << 11;
         int var33 = var32 + var73;
         int var17 = var16 + var24;
         int var18 = var17 ^ var24 >>> 2;
         int var25 = var24 + var33;
         int var41 = var40 + var18;
         int var26 = var25 ^ var33 << 8;
         int var34 = var33 + var41;
         int var49 = var48 + var26;
         i_3_ = var34 ^ var41 >>> 16;
         int var42 = var41 + var49;
         int var57 = var56 + i_3_;
         i_4_ = var42 ^ var49 << 10;
         int var65 = var64 + i_4_;
         int var50 = var49 + var57;
         i_5_ = var50 ^ var57 >>> 4;
         int var58 = var57 + var65;
         int var74 = var73 + i_5_;
         i_6_ = var58 ^ var65 << 8;
         int var66 = var65 + var74;
         i_1_ = var18 + i_6_;
         i_7_ = var66 ^ var74 >>> 9;
         i_2_ = var26 + i_7_;
         i_0_ = var74 + i_1_;
         this.anIntArray1834[i_10_] = i_0_;
         this.anIntArray1834[1 + i_10_] = i_1_;
         this.anIntArray1834[i_10_ + 2] = i_2_;
         this.anIntArray1834[3 + i_10_] = i_3_;
         this.anIntArray1834[4 + i_10_] = i_4_;
         this.anIntArray1834[5 + i_10_] = i_5_;
         this.anIntArray1834[i_10_ + 6] = i_6_;
         this.anIntArray1834[7 + i_10_] = i_7_;
      }

      this.method1668(i + 1528001562);
      this.anInt1831 = 256;
   }

   final int method1667(byte b) {
      if (b != -96) {
         return -2;
      } else {
         if (this.anInt1831 == 0) {
            this.method1668(1528019106);
            this.anInt1831 = 256;
         }

         ++anInt1835;
         return 0;
      }
   }

   private final void method1668(int i) {
      ++anInt1837;
      if (i != 1528019106) {
         this.method1666(-91);
      }

      this.anInt1830 += ++this.anInt1839;

      for(int i_11_ = 0; ~i_11_ > -257; ++i_11_) {
         int i_12_ = this.anIntArray1834[i_11_];
         if ((i_11_ & 2) != 0) {
            if (~(1 & i_11_) == -1) {
               this.anInt1836 ^= this.anInt1836 << 2;
            } else {
               this.anInt1836 ^= this.anInt1836 >>> 16;
            }
         } else if ((i_11_ & 1) != 0) {
            this.anInt1836 ^= this.anInt1836 >>> 6;
         } else {
            this.anInt1836 ^= this.anInt1836 << 13;
         }

         this.anInt1836 += this.anIntArray1834[128 + i_11_ & 0xFF];
         int i_13_;
         this.anIntArray1834[i_11_] = i_13_ = this.anInt1830 + this.anIntArray1834[Node_Sub30.method2723(1020, i_12_) >> 2] - -this.anInt1836;
         this.anIntArray1832[i_11_] = this.anInt1830 = this.anIntArray1834[Node_Sub30.method2723(1020, i_13_ >> 8) >> 2] - -i_12_;
      }
   }

   public static void method1669(int i) {
      if (i < 13) {
         method1669(-19);
      }

      aClass54Array1840 = null;
      aClass139_1829 = null;
   }

   final int method1670(byte b) {
      if (b != -21) {
         return 127;
      } else {
         if (this.anInt1831 == 0) {
            this.method1668(b ^ -1528019127);
            this.anInt1831 = 256;
         }

         ++anInt1838;
         return 0;
      }
   }

   IsaacCipher(int[] is) {
      for(int i = 0; i < is.length; ++i) {
         this.anIntArray1832[i] = is[i];
      }

      this.method1666(17544);
   }
}
