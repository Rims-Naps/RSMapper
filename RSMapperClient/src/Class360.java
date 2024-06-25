import java.io.IOException;
import java.io.OutputStream;

public class Class360 implements Runnable {
   private int anInt4469 = 0;
   private int anInt4470 = 0;
   static int anInt4471;
   static int anInt4472;
   static int anInt4473;
   private IOException anIOException4474;
   private int anInt4475;
   static int anInt4476;
   private byte[] aByteArray4477;
   private OutputStream anOutputStream4478;
   private Thread aThread4479;
   static int canvasWidth;
   static int anInt4481;

   final void method4041(int i) {
      synchronized(this) {
         if (this.anIOException4474 == null) {
            this.anIOException4474 = new IOException("");
         }

         this.notifyAll();
      }

      ++anInt4476;

      try {
         this.aThread4479.join();
      } catch (InterruptedException var3) {
      }

      if (i != -14303) {
         this.anInt4470 = 113;
      }
   }

   @Override
   public final void run() {
      ++anInt4472;

      while(true) {
         int i;
         synchronized(this) {
            while(true) {
               if (this.anIOException4474 != null) {
                  return;
               }

               if (this.anInt4470 < this.anInt4469) {
                  i = this.anInt4470 + -this.anInt4469 + this.anInt4475;
               } else {
                  i = -this.anInt4469 + this.anInt4470;
               }

               if (~i < -1) {
                  break;
               }

               try {
                  this.anOutputStream4478.flush();
               } catch (IOException var8) {
                  this.anIOException4474 = var8;
                  return;
               }

               try {
                  this.wait();
               } catch (InterruptedException var7) {
               }
            }
         }

         try {
            if (~this.anInt4475 > ~(this.anInt4469 + i)) {
               int i_0_ = -this.anInt4469 + this.anInt4475;
               this.anOutputStream4478.write(this.aByteArray4477, this.anInt4469, i_0_);
               this.anOutputStream4478.write(this.aByteArray4477, 0, i + -i_0_);
            } else {
               this.anOutputStream4478.write(this.aByteArray4477, this.anInt4469, i);
            }
         } catch (IOException var6) {
            IOException ioexception = var6;
            synchronized(this) {
               this.anIOException4474 = ioexception;
               return;
            }
         }

         synchronized(this) {
            this.anInt4469 = (this.anInt4469 + i) % this.anInt4475;
         }
      }
   }

   final void method4042(byte[] bs, int i, int i_1_, int i_2_) throws IOException {
      ++anInt4471;
      if (~i <= -1 && i_2_ >= 0 && bs.length >= i_2_ + i) {
         if (i_1_ == -19032) {
            synchronized(this) {
               if (this.anIOException4474 != null) {
                  throw new IOException(this.anIOException4474.toString());
               }

               int i_3_;
               if (this.anInt4470 < this.anInt4469) {
                  i_3_ = -1 + this.anInt4469 + -this.anInt4470;
               } else {
                  i_3_ = -1 + this.anInt4469 + -this.anInt4470 + this.anInt4475;
               }

               if (~i < ~i_3_) {
                  throw new IOException("");
               }

               if (i + this.anInt4470 > this.anInt4475) {
                  int i_4_ = -this.anInt4470 + this.anInt4475;
                  Class311.method3608(bs, i_2_, this.aByteArray4477, this.anInt4470, i_4_);
                  Class311.method3608(bs, i_2_ + i_4_, this.aByteArray4477, 0, -i_4_ + i);
               } else {
                  Class311.method3608(bs, i_2_, this.aByteArray4477, this.anInt4470, i);
               }

               this.anInt4470 = (i + this.anInt4470) % this.anInt4475;
               this.notifyAll();
            }
         }
      } else {
         throw new IOException();
      }
   }

   static final Node_Sub6 method4043(Index class302, int i, boolean bool) {
      ++anInt4473;
      byte[] bs = class302.method3518((byte)-124, i);
      if (bool) {
         return null;
      } else {
         return bs == null ? null : new Node_Sub6(bs);
      }
   }

   final void method4044(int i) {
      if (i == 0) {
         ++anInt4481;
         this.anOutputStream4478 = new OutputStream_Sub1();
      }
   }

   Class360(OutputStream outputstream, int i) {
      this.anOutputStream4478 = outputstream;
      this.anInt4475 = i + 1;
      this.aByteArray4477 = new byte[this.anInt4475];
      this.aThread4479 = new Thread(this);
      this.aThread4479.setDaemon(true);
      this.aThread4479.start();
   }
}
