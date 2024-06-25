import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class Class156 implements Runnable {
   private int anInt1956 = 0;
   private int anInt1957;
   static int anInt1958;
   static int anInt1959;
   private int anInt1960 = 0;
   private Thread aThread1961;
   static IncommingPacket sendDynamicRegion = new IncommingPacket(128, -2);
   static int anInt1963;
   static HashTable aHashTable1964 = new HashTable(512);
   private InputStream anInputStream1965;
   static int anInt1966;
   static int anInt1967;
   private IOException anIOException1968;
   static GLSprite[] aGLSpriteArray1969;
   static int anInt1970;
   private byte[] aByteArray1971;

   final boolean method1703(int i, int i_0_) throws IOException {
      ++anInt1959;
      if (i_0_ > 0 && ~i_0_ > ~this.anInt1957) {
         int i_1_ = 125 / ((59 - i) / 40);
         synchronized(this) {
            int i_2_;
            if (this.anInt1956 > this.anInt1960) {
               i_2_ = -this.anInt1956 + this.anInt1957 - -this.anInt1960;
            } else {
               i_2_ = this.anInt1960 + -this.anInt1956;
            }

            if (~i_0_ >= ~i_2_) {
               return true;
            } else if (this.anIOException1968 != null) {
               throw new IOException(this.anIOException1968.toString());
            } else {
               this.notifyAll();
               return false;
            }
         }
      } else {
         throw new IOException();
      }
   }

   final void method1704(boolean bool) {
      if (bool) {
         this.aByteArray1971 = null;
      }

      ++anInt1966;
      this.anInputStream1965 = new InputStream_Sub1();
   }

   static final int method1705(int i, int i_3_) {
      if (i != -983162425) {
         method1705(73, -108);
      }

      ++anInt1970;
      return i_3_ >>> 7;
   }

   final void method1706(byte b) {
      synchronized(this) {
         if (b > -75) {
            return;
         }

         if (this.anIOException1968 == null) {
            this.anIOException1968 = new IOException("");
         }

         this.notifyAll();
      }

      ++anInt1958;

      try {
         this.aThread1961.join();
      } catch (InterruptedException var3) {
      }
   }

   @Override
   public final void run() {
      ++anInt1963;

      while(true) {
         int i;
         synchronized(this) {
            while(true) {
               if (this.anIOException1968 != null) {
                  return;
               }

               if (~this.anInt1956 == -1) {
                  i = -1 + this.anInt1957 - this.anInt1960;
               } else if (~this.anInt1960 <= ~this.anInt1956) {
                  i = this.anInt1957 - this.anInt1960;
               } else {
                  i = -1 + this.anInt1956 + -this.anInt1960;
               }

               if (~i < -1) {
                  break;
               }

               try {
                  this.wait();
               } catch (InterruptedException var6) {
               }
            }
         }

         int i_4_;
         try {
            i_4_ = this.anInputStream1965.read(this.aByteArray1971, this.anInt1960, i);
            if (i_4_ == -1) {
               throw new EOFException();
            }
         } catch (IOException var8) {
            IOException ioexception = var8;
            synchronized(this) {
               this.anIOException1968 = ioexception;
               return;
            }
         }

         synchronized(this) {
            this.anInt1960 = (i_4_ + this.anInt1960) % this.anInt1957;
         }
      }
   }

   public static void method1704() {
      aHashTable1964 = null;
   }

   public static void method1707(int i) {
      aHashTable1964 = null;
      if (i != 512) {
         sendDynamicRegion = null;
      }

      aGLSpriteArray1969 = null;
      sendDynamicRegion = null;
   }

   final int method1708(int i, int i_5_, int i_6_, byte[] bs) throws IOException {
      ++anInt1967;
      if (~i_5_ <= -1 && ~i_6_ <= -1 && i_5_ + i_6_ <= bs.length) {
         synchronized(this) {
            int i_7_;
            if (~this.anInt1960 <= ~this.anInt1956) {
               i_7_ = this.anInt1960 - this.anInt1956;
            } else {
               i_7_ = this.anInt1960 + this.anInt1957 - this.anInt1956;
            }

            if (i_7_ < i_5_) {
               i_5_ = i_7_;
            }

            if (i != 1) {
               this.method1706((byte)78);
            }

            if (~i_5_ == -1 && this.anIOException1968 != null) {
               throw new IOException(this.anIOException1968.toString());
            } else {
               if (this.anInt1957 >= this.anInt1956 - -i_5_) {
                  Class311.method3608(this.aByteArray1971, this.anInt1956, bs, i_6_, i_5_);
               } else {
                  int i_8_ = this.anInt1957 - this.anInt1956;
                  Class311.method3608(this.aByteArray1971, this.anInt1956, bs, i_6_, i_8_);
                  Class311.method3608(this.aByteArray1971, 0, bs, i_8_ + i_6_, i_5_ + -i_8_);
               }

               this.anInt1956 = (i_5_ + this.anInt1956) % this.anInt1957;
               this.notifyAll();
               return i_5_;
            }
         }
      } else {
         throw new IOException();
      }
   }

   Class156(InputStream inputstream, int i) {
      this.anInputStream1965 = inputstream;
      this.anInt1957 = 1 + i;
      this.aByteArray1971 = new byte[this.anInt1957];
      this.aThread1961 = new Thread(this);
      this.aThread1961.setDaemon(true);
      this.aThread1961.start();
   }
}
