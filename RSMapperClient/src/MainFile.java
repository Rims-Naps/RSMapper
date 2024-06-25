import java.io.EOFException;
import java.io.IOException;

public class MainFile {
   private SeekableFile aSeekableFile134 = null;
   static int[] anIntArray135 = new int[2];
   static IncommingPacket aClass192_136 = new IncommingPacket(98, 6);
   private SeekableFile aSeekableFile137 = null;
   static int anInt138;
   private int anInt139 = 65000;
   static int anInt140;
   static int anInt141;
   static int anInt142;
   private int anInt143;
   static float aFloat144;
   static int anInt145;
   static int[] anIntArray146 = new int[3];
   static int anInt147;
   static int anInt148;

   static final void method174(byte b) {
      Class315.aClass61_4031.method608(false);
      ++anInt141;
      int i = -61 / ((-52 - b) / 45);
   }

   static final void method175(byte[] bs, boolean bool) {
      if (bool) {
         ++anInt142;
         Buffer buffer = new Buffer(bs);

         while(true) {
            int i = buffer.readUnsignedByte();
            if (~i == -1) {
               break;
            }

            if (~i == -2) {
               int i_0_ = buffer.readUnsignedShort();
               if (Class317.anInt4038 == -1) {
                  Class317.anInt4038 = i_0_;
               }
            }
         }
      }
   }

   @Override
   public final String toString() {
      ++anInt138;
      return "Cache:" + this.anInt143;
   }

   final boolean method176(int i, byte[] bs, int i_1_, boolean bool) {
      ++anInt140;
      synchronized(this.aSeekableFile134) {
         if (~i <= -1 && i <= this.anInt139) {
            boolean bool_2_ = this.method179(bs, 11233, i_1_, i, bool);
            if (!bool_2_) {
               bool_2_ = this.method179(bs, 11233, i_1_, i, false);
            }

            return bool_2_;
         } else {
            throw new IllegalArgumentException();
         }
      }
   }

   final byte[] method177(int archiveId, int i_3_) {
      ++anInt145;
      synchronized(this.aSeekableFile134) {
         byte[] var10000;
         try {
            if (~this.aSeekableFile137.method3573(-1) > ~((long)(archiveId * 6 - -6))) {
               return null;
            }

            this.aSeekableFile137.method3577((long)(archiveId * 6), false);
            this.aSeekableFile137.method3568(-63, 6, Class157.aByteArray1973, 0);
            int archiveLength = ((255 & Class157.aByteArray1973[1]) << 8) + (0xFF0000 & Class157.aByteArray1973[0] << 16) + (255 & Class157.aByteArray1973[2]);
            int sector = (Class157.aByteArray1973[5] & 255) + ((255 & Class157.aByteArray1973[4]) << 8) + ((255 & Class157.aByteArray1973[3]) << 16);
            if (archiveLength < 0 || archiveLength > this.anInt139) {
               return null;
            }

            if (~sector >= -1 || this.aSeekableFile134.method3573(-1) / 520L < (long)sector) {
               return null;
            }

            byte[] bs = new byte[archiveLength];
            int readBytesCount = 0;
            if (i_3_ != 512) {
               method178(-80);
            }

            int i_11_;
            for(int i_7_ = 0; ~archiveLength < ~readBytesCount; sector = i_11_) {
               if (sector == 0) {
                  return null;
               }

               this.aSeekableFile134.method3577((long)(sector * 520), false);
               int i_8_ = archiveLength - readBytesCount;
               if (~i_8_ < -513) {
                  i_8_ = 512;
               }

               this.aSeekableFile134.method3568(-92, i_8_ - -8, Class157.aByteArray1973, 0);
               int currentArchive = ((Class157.aByteArray1973[0] & 255) << 8) + (Class157.aByteArray1973[1] & 255);
               int i_10_ = (Class157.aByteArray1973[3] & 255) + ((255 & Class157.aByteArray1973[2]) << 8);
               i_11_ = (Class157.aByteArray1973[5] << 8 & 0xFF00) + (Class157.aByteArray1973[4] << 16 & 0xFF0000) + (Class157.aByteArray1973[6] & 255);
               int i_12_ = 255 & Class157.aByteArray1973[7];
               if (archiveId <= 65535 && archiveId != currentArchive || ~i_7_ != ~i_10_ || ~i_12_ != ~this.anInt143) {
                  return null;
               }

               if (~i_11_ > -1 || (long)i_11_ > this.aSeekableFile134.method3573(-1) / 520L) {
                  return null;
               }

               ++i_7_;

               for(int i_13_ = 0; i_8_ > i_13_; ++i_13_) {
                  bs[readBytesCount++] = Class157.aByteArray1973[8 + i_13_];
               }
            }

            var10000 = bs;
         } catch (IOException var15) {
            return null;
         }

         return var10000;
      }
   }

   public static void method178(int i) {
      anIntArray135 = null;
      anIntArray146 = null;
      aClass192_136 = null;
      if (i <= 14) {
         aFloat144 = -1.2132012F;
      }
   }

   private final boolean method179(byte[] bs, int i, int archiveId, int i_15_, boolean bool) {
      ++anInt147;
      synchronized(this.aSeekableFile134) {
         if (i != 11233) {
            this.method177(114, 33);
         }

         try {
            int i_16_;
            if (bool) {
               if (~this.aSeekableFile137.method3573(-1) > ~((long)(6 + archiveId * 6))) {
                  return false;
               }

               this.aSeekableFile137.method3577((long)(archiveId * 6), false);
               this.aSeekableFile137.method3568(i + -11299, 6, Class157.aByteArray1973, 0);
               i_16_ = (255 & Class157.aByteArray1973[5]) + (0xFF0000 & Class157.aByteArray1973[3] << 16) - -(Class157.aByteArray1973[4] << 8 & 0xFF00);
               if (i_16_ <= 0 || this.aSeekableFile134.method3573(-1) / 520L < (long)i_16_) {
                  return false;
               }
            } else {
               i_16_ = (int)((519L + this.aSeekableFile134.method3573(-1)) / 520L);
               if (i_16_ == 0) {
                  i_16_ = 1;
               }
            }

            Class157.aByteArray1973[3] = (byte)(i_16_ >> 16);
            Class157.aByteArray1973[2] = (byte)i_15_;
            Class157.aByteArray1973[0] = (byte)(i_15_ >> 16);
            Class157.aByteArray1973[1] = (byte)(i_15_ >> 8);
            Class157.aByteArray1973[5] = (byte)i_16_;
            Class157.aByteArray1973[4] = (byte)(i_16_ >> 8);
            this.aSeekableFile137.method3577((long)(archiveId * 6), false);
            this.aSeekableFile137.method3570(5033, 0, 6, Class157.aByteArray1973);
            int i_17_ = 0;

            for(int i_18_ = 0; i_17_ < i_15_; ++i_18_) {
               int i_19_ = 0;
               if (bool) {
                  this.aSeekableFile134.method3577((long)(i_16_ * 520), false);

                  try {
                     this.aSeekableFile134.method3568(-116, 8, Class157.aByteArray1973, 0);
                  } catch (EOFException var14) {
                     break;
                  }

                  int currentArchive = (255 & Class157.aByteArray1973[1]) + ((255 & Class157.aByteArray1973[0]) << 8);
                  int i_21_ = (Class157.aByteArray1973[3] & 255) + (Class157.aByteArray1973[2] << 8 & 0xFF00);
                  i_19_ = (255 & Class157.aByteArray1973[6]) + ((255 & Class157.aByteArray1973[4]) << 16) - -((255 & Class157.aByteArray1973[5]) << 8);
                  int i_22_ = Class157.aByteArray1973[7] & 255;
                  if (archiveId <= 65535 && archiveId != currentArchive || ~i_18_ != ~i_21_ || i_22_ != this.anInt143) {
                     return false;
                  }

                  if (~i_19_ > -1 || ~(this.aSeekableFile134.method3573(i + -11234) / 520L) > ~((long)i_19_)) {
                     return false;
                  }
               }

               if (~i_19_ == -1) {
                  bool = false;
                  i_19_ = (int)((519L + this.aSeekableFile134.method3573(i + -11234)) / 520L);
                  if (~i_19_ == -1) {
                     ++i_19_;
                  }

                  if (~i_19_ == ~i_16_) {
                     ++i_19_;
                  }
               }

               if (~(i_15_ + -i_17_) >= -513) {
                  i_19_ = 0;
               }

               Class157.aByteArray1973[3] = (byte)i_18_;
               Class157.aByteArray1973[2] = (byte)(i_18_ >> 8);
               Class157.aByteArray1973[1] = (byte)archiveId;
               Class157.aByteArray1973[0] = (byte)(archiveId >> 8);
               Class157.aByteArray1973[4] = (byte)(i_19_ >> 16);
               Class157.aByteArray1973[5] = (byte)(i_19_ >> 8);
               Class157.aByteArray1973[6] = (byte)i_19_;
               Class157.aByteArray1973[7] = (byte)this.anInt143;
               this.aSeekableFile134.method3577((long)(520 * i_16_), false);
               this.aSeekableFile134.method3570(5033, 0, 8, Class157.aByteArray1973);
               int i_23_ = -i_17_ + i_15_;
               if (~i_23_ < -513) {
                  i_23_ = 512;
               }

               this.aSeekableFile134.method3570(5033, i_17_, i_23_, bs);
               i_16_ = i_19_;
               i_17_ += i_23_;
            }
         } catch (IOException var15) {
            return false;
         }

         return true;
      }
   }

   MainFile(int i, SeekableFile seekablefile, SeekableFile seekablefile_24_, int i_25_) {
      this.aSeekableFile137 = seekablefile_24_;
      this.anInt143 = i;
      this.anInt139 = i_25_;
      this.aSeekableFile134 = seekablefile;
   }
}
