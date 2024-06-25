import java.io.EOFException;
import java.io.File;
import java.io.IOException;

public class SeekableFile {
   static int anInt3871;
   static int anInt3872;
   static int anInt3873;
   static int anInt3874;
   static int anInt3875;
   static int anInt3876;
   static int anInt3877;
   private long aLong3878;
   private long aLong3879;
   private int anInt3880 = 0;
   static Index index6;
   static int anInt3882;
   static double aDouble3883;
   static Animable[] anAnimableArray3884;
   private byte[] aByteArray3885;
   static int anInt3886;
   private long aLong3887;
   private long aLong3888;
   static int anInt3889;
   private FileOnDisk aFileOnDisk3890;
   private int anInt3891;
   static int anInt3892;
   private long aLong3893 = -1L;
   private byte[] aByteArray3894;
   private long aLong3895 = -1L;

   private final File method3567(int i) {
      if (i != 65536) {
         return null;
      } else {
         ++anInt3871;
         return this.aFileOnDisk3890.method1104(false);
      }
   }

   final void method3568(int i, int i_0_, byte[] bs, int i_1_) throws IOException {
      ++anInt3875;

      try {
         if (bs.length < i_0_ + i_1_) {
            throw new ArrayIndexOutOfBoundsException(i_0_ + i_1_ + -bs.length);
         }

         if (i >= -58) {
            this.method3567(-1);
         }

         if (~this.aLong3895 != 0L && ~this.aLong3878 <= ~this.aLong3895 && ~((long)i_0_ + this.aLong3878) >= ~((long)this.anInt3880 + this.aLong3895)) {
            Class311.method3608(this.aByteArray3894, (int)(-this.aLong3895 + this.aLong3878), bs, i_1_, i_0_);
            this.aLong3878 += (long)i_0_;
            return;
         }

         long l = this.aLong3878;
         int i_2_ = i_1_;
         int i_3_ = i_0_;
         if (this.aLong3878 >= this.aLong3893 && ~this.aLong3878 > ~(this.aLong3893 - -((long)this.anInt3891))) {
            int i_4_ = (int)((long)this.anInt3891 + -this.aLong3878 - -this.aLong3893);
            if (i_0_ < i_4_) {
               i_4_ = i_0_;
            }

            Class311.method3608(this.aByteArray3885, (int)(this.aLong3878 + -this.aLong3893), bs, i_1_, i_4_);
            this.aLong3878 += (long)i_4_;
            i_1_ += i_4_;
            i_0_ -= i_4_;
         }

         if (this.aByteArray3885.length < i_0_) {
            this.aFileOnDisk3890.method1100(true, this.aLong3878);

            int i_5_;
            for(this.aLong3887 = this.aLong3878; i_0_ > 0; this.aLong3887 += (long)i_5_) {
               i_5_ = this.aFileOnDisk3890.method1103((byte)-115, i_0_, bs, i_1_);
               if (i_5_ == -1) {
                  break;
               }

               this.aLong3878 += (long)i_5_;
               i_0_ -= i_5_;
               i_1_ += i_5_;
            }
         } else if (~i_0_ < -1) {
            this.method3572((byte)-128);
            int i_6_ = i_0_;
            if (this.anInt3891 < i_0_) {
               i_6_ = this.anInt3891;
            }

            Class311.method3608(this.aByteArray3885, 0, bs, i_1_, i_6_);
            i_1_ += i_6_;
            this.aLong3878 += (long)i_6_;
            i_0_ -= i_6_;
         }

         if (~this.aLong3895 != 0L) {
            if (this.aLong3895 > this.aLong3878 && i_0_ > 0) {
               int i_7_ = (int)(-this.aLong3878 + this.aLong3895) + i_1_;
               if (~i_7_ < ~(i_0_ + i_1_)) {
                  i_7_ = i_1_ - -i_0_;
               }

               while(~i_7_ < ~i_1_) {
                  --i_0_;
                  bs[i_1_++] = 0;
                  ++this.aLong3878;
               }
            }

            long l_8_ = -1L;
            if (l <= this.aLong3895 && ~this.aLong3895 > ~(l - -((long)i_3_))) {
               l_8_ = this.aLong3895;
            } else if (this.aLong3895 <= l && ~(this.aLong3895 + (long)this.anInt3880) < ~l) {
               l_8_ = l;
            }

            long l_9_ = -1L;
            if (l < this.aLong3895 - -((long)this.anInt3880) && (long)i_3_ + l >= this.aLong3895 + (long)this.anInt3880) {
               l_9_ = (long)this.anInt3880 + this.aLong3895;
            } else if (~this.aLong3895 > ~(l - -((long)i_3_)) && ~((long)this.anInt3880 + this.aLong3895) <= ~(l - -((long)i_3_))) {
               l_9_ = (long)i_3_ + l;
            }

            if (~l_8_ < 0L && l_9_ > l_8_) {
               int i_10_ = (int)(-l_8_ + l_9_);
               Class311.method3608(this.aByteArray3894, (int)(l_8_ + -this.aLong3895), bs, i_2_ - -((int)(-l + l_8_)), i_10_);
               if (l_9_ > this.aLong3878) {
                  i_0_ = (int)((long)i_0_ - (l_9_ - this.aLong3878));
                  this.aLong3878 = l_9_;
               }
            }
         }
      } catch (IOException var14) {
         this.aLong3887 = -1L;
         throw var14;
      }

      if (~i_0_ < -1) {
         throw new EOFException();
      }
   }

   static final int method3569(int i, int i_11_, int i_12_, int i_13_, int i_14_) {
      ++anInt3877;
      int i_15_ = i - Class335.anIntArray4165[i_14_ * 8192 / i_11_] >> 1;
      return (i_15_ * i_13_ >> 16) + (i_12_ * (-i_15_ + 65536) >> 16);
   }

   final void method3570(int i, int i_16_, int i_17_, byte[] bs) throws IOException {
      ++anInt3872;

      try {
         if (this.aLong3888 < (long)i_17_ + this.aLong3878) {
            this.aLong3888 = (long)i_17_ + this.aLong3878;
         }

         if (~this.aLong3895 != 0L && (~this.aLong3895 < ~this.aLong3878 || (long)this.anInt3880 + this.aLong3895 < this.aLong3878)) {
            this.method3576(true);
         }

         if (~this.aLong3895 != 0L && this.aLong3895 - -((long)this.aByteArray3894.length) < this.aLong3878 + (long)i_17_) {
            int i_18_ = (int)(-this.aLong3878 - (-this.aLong3895 - (long)this.aByteArray3894.length));
            Class311.method3608(bs, i_16_, this.aByteArray3894, (int)(this.aLong3878 + -this.aLong3895), i_18_);
            i_16_ += i_18_;
            i_17_ -= i_18_;
            this.aLong3878 += (long)i_18_;
            this.anInt3880 = this.aByteArray3894.length;
            this.method3576(true);
         }

         if (i_17_ > this.aByteArray3894.length) {
            if (~this.aLong3887 != ~this.aLong3878) {
               this.aFileOnDisk3890.method1100(true, this.aLong3878);
               this.aLong3887 = this.aLong3878;
            }

            this.aFileOnDisk3890.method1102((byte)76, bs, i_16_, i_17_);
            this.aLong3887 += (long)i_17_;
            if (this.aLong3887 > this.aLong3879) {
               this.aLong3879 = this.aLong3887;
            }

            long l = -1L;
            if (this.aLong3893 <= this.aLong3878 && this.aLong3878 < (long)this.anInt3891 + this.aLong3893) {
               l = this.aLong3878;
            } else if (~this.aLong3878 >= ~this.aLong3893 && (long)i_17_ + this.aLong3878 > this.aLong3893) {
               l = this.aLong3893;
            }

            long l_19_ = -1L;
            if (this.aLong3893 < (long)i_17_ + this.aLong3878 && this.aLong3893 - -((long)this.anInt3891) >= this.aLong3878 - -((long)i_17_)) {
               l_19_ = (long)i_17_ + this.aLong3878;
            } else if (this.aLong3878 < (long)this.anInt3891 + this.aLong3893 && this.aLong3878 - -((long)i_17_) >= (long)this.anInt3891 + this.aLong3893) {
               l_19_ = this.aLong3893 + (long)this.anInt3891;
            }

            if (l > -1L && l < l_19_) {
               int i_20_ = (int)(-l + l_19_);
               Class311.method3608(bs, (int)(l + (long)i_16_ - this.aLong3878), this.aByteArray3885, (int)(l + -this.aLong3893), i_20_);
            }

            this.aLong3878 += (long)i_17_;
            return;
         }

         if (i_17_ > 0) {
            if (this.aLong3895 == -1L) {
               this.aLong3895 = this.aLong3878;
            }

            Class311.method3608(bs, i_16_, this.aByteArray3894, (int)(-this.aLong3895 + this.aLong3878), i_17_);
            this.aLong3878 += (long)i_17_;
            if (~((long)this.anInt3880) > ~(this.aLong3878 + -this.aLong3895)) {
               this.anInt3880 = (int)(-this.aLong3895 + this.aLong3878);
            }

            return;
         }
      } catch (IOException var10) {
         this.aLong3887 = -1L;
         throw var10;
      }

      if (i != 5033) {
         this.method3567(-38);
      }
   }

   static final boolean method3571(byte b, int i, int i_21_) {
      ++anInt3889;
      if (b != 61) {
         method3578(13);
      }

      return (458752 & i_21_) != 0 | Class321.method3800(i_21_, i, 126) || Class262_Sub15_Sub1.method3192(i, i_21_, 512);
   }

   private final void method3572(byte b) throws IOException {
      ++anInt3886;
      this.anInt3891 = 0;
      if (b > -119) {
         this.anInt3880 = -97;
      }

      if (this.aLong3878 != this.aLong3887) {
         this.aFileOnDisk3890.method1100(true, this.aLong3878);
         this.aLong3887 = this.aLong3878;
      }

      int i_22_;
      for(this.aLong3893 = this.aLong3878; ~this.anInt3891 > ~this.aByteArray3885.length; this.aLong3887 += (long)i_22_) {
         int i = this.aByteArray3885.length - this.anInt3891;
         if (~i < -200000001) {
            i = 200000000;
         }

         i_22_ = this.aFileOnDisk3890.method1103((byte)-115, i, this.aByteArray3885, this.anInt3891);
         if (i_22_ == -1) {
            break;
         }

         this.anInt3891 += i_22_;
      }
   }

   final long method3573(int i) {
      ++anInt3873;
      if (i != -1) {
         this.aByteArray3885 = null;
      }

      return this.aLong3888;
   }

   final void method3574(byte[] bs, byte b) throws IOException {
      this.method3568(-77, bs.length, bs, 0);
      ++anInt3874;
      int i = 23 / ((-64 - b) / 39);
   }

   final void method3575(int i) throws IOException {
      this.method3576(true);
      ++anInt3876;
      this.aFileOnDisk3890.method1098(true);
      if (i != 2) {
         this.anInt3891 = 42;
      }
   }

   private final void method3576(boolean bool) throws IOException {
      if (!bool) {
         this.aLong3888 = 87L;
      }

      if (~this.aLong3895 != 0L) {
         if (~this.aLong3895 != ~this.aLong3887) {
            this.aFileOnDisk3890.method1100(bool, this.aLong3895);
            this.aLong3887 = this.aLong3895;
         }

         this.aFileOnDisk3890.method1102((byte)76, this.aByteArray3894, 0, this.anInt3880);
         this.aLong3887 += (long)this.anInt3880;
         if (this.aLong3887 > this.aLong3879) {
            this.aLong3879 = this.aLong3887;
         }

         long l = -1L;
         long l_23_ = -1L;
         if (~this.aLong3893 >= ~this.aLong3895 && ~this.aLong3895 > ~(this.aLong3893 + (long)this.anInt3891)) {
            l = this.aLong3895;
         } else if (this.aLong3893 >= this.aLong3895 && ~((long)this.anInt3880 + this.aLong3895) < ~this.aLong3893) {
            l = this.aLong3893;
         }

         if (this.aLong3893 < this.aLong3895 - -((long)this.anInt3880) && (long)this.anInt3891 + this.aLong3893 >= this.aLong3895 - -((long)this.anInt3880)) {
            l_23_ = this.aLong3895 + (long)this.anInt3880;
         } else if (this.aLong3895 < this.aLong3893 + (long)this.anInt3891
            && ~((long)this.anInt3880 + this.aLong3895) <= ~(this.aLong3893 - -((long)this.anInt3891))) {
            l_23_ = (long)this.anInt3891 + this.aLong3893;
         }

         if (l > -1L && ~l_23_ < ~l) {
            int i = (int)(l_23_ + -l);
            Class311.method3608(this.aByteArray3894, (int)(l + -this.aLong3895), this.aByteArray3885, (int)(l + -this.aLong3893), i);
         }

         this.anInt3880 = 0;
         this.aLong3895 = -1L;
      }

      ++anInt3882;
   }

   final void method3577(long l, boolean bool) throws IOException {
      ++anInt3892;
      if (~l > -1L) {
         throw new IOException("Invalid seek to " + l + " in file " + this.method3567(65536));
      } else {
         this.aLong3878 = l;
         if (bool) {
            method3578(-99);
         }
      }
   }

   public static void method3578(int i) {
      anAnimableArray3884 = null;
      index6 = null;
      if (i != 65280) {
         method3571((byte)4, 23, 116);
      }
   }

   SeekableFile(FileOnDisk fileondisk, int i, int i_24_) throws IOException {
      this.aFileOnDisk3890 = fileondisk;
      this.aLong3888 = this.aLong3879 = fileondisk.method1101(0);
      this.aLong3878 = 0L;
      this.aByteArray3885 = new byte[i];
      this.aByteArray3894 = new byte[i_24_];
   }
}
