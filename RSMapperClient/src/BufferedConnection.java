import com.dropbox.core.v2.DbxClientV2;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BufferedConnection implements Runnable {
   static int anInt595;
   private Class241 aClass241_596;
   static int anInt597;
   static int anInt598;
   static int anInt599;
   static int anInt600;
   private boolean aBoolean601 = false;
   private byte[] aByteArray602;
   private int anInt603;
   private InputStream anInputStream604;
   private Socket aSocket605;
   static int anInt606;
   static int anInt607;
   private int anInt608;
   private int anInt609 = 0;
   static int anInt610;
   static int anInt611;
   private OutputStream anOutputStream612;
   static int anInt613;
   private boolean aBoolean614;
   static Class346 aClass346_615 = new Class346();
   static int anInt616;
   private SignLink aSignLink617;
   public static DbxClientV2 aHashTable1923 = null;

   public static void method421(int i) {
      aClass346_615 = null;
      if (i != -22344) {
         method422(-55, 65, -73, 64, 7, -93, -81, 49, -103, 50, -16, 107);
      }
   }

   static final void method422(int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, int i_5_, int i_6_, int i_7_, int i_8_, int i_9_, int i_10_) {
      ++anInt597;
      if (CacheNode_Sub15.loadInterface(7015, i_7_) && i_1_ == -1) {
         if (AreaDefinitions.aWidgetArrayArray1082[i_7_] == null) {
            Client.method121(Class134_Sub3.aWidgetArrayArray9035[i_7_], -1, i_10_, i_2_, i_5_, i, i_6_, i_0_, i_8_, i_3_, i_9_, i_4_);
         } else {
            Client.method121(AreaDefinitions.aWidgetArrayArray1082[i_7_], -1, i_10_, i_2_, i_5_, i, i_6_, i_0_, i_8_, i_3_, i_9_, i_4_);
         }
      }
   }

   final void method423(int i) throws IOException {
      if (i != -1650936088) {
         this.anInt603 = 99;
      }

      ++anInt607;
      if (!this.aBoolean601 && this.aBoolean614) {
         this.aBoolean614 = false;
         throw new IOException();
      }
   }

   final int method424(int i) throws IOException {
      ++anInt610;
      if (this.aBoolean601) {
         return 0;
      } else {
         return i != -1 ? 7 : this.anInputStream604.read();
      }
   }

   @Override
   public final void run() {
      try {
         while(true) {
            label83: {
               int i;
               int i_11_;
               synchronized(this) {
                  if (~this.anInt608 == ~this.anInt609) {
                     if (this.aBoolean601) {
                        break label83;
                     }

                     try {
                        this.wait();
                     } catch (InterruptedException var8) {
                     }
                  }

                  i = this.anInt608;
                  if (this.anInt609 >= this.anInt608) {
                     i_11_ = -this.anInt608 + this.anInt609;
                  } else {
                     i_11_ = -this.anInt608 + this.anInt603;
                  }
               }

               if (~i_11_ >= -1) {
                  continue;
               }

               try {
                  this.anOutputStream612.write(this.aByteArray602, i, i_11_);
               } catch (IOException var7) {
                  this.aBoolean614 = true;
               }

               this.anInt608 = (this.anInt608 - -i_11_) % this.anInt603;

               try {
                  if (this.anInt609 == this.anInt608) {
                     this.anOutputStream612.flush();
                  }
               } catch (IOException var6) {
                  this.aBoolean614 = true;
               }
               continue;
            }

            try {
               if (this.anInputStream604 != null) {
                  this.anInputStream604.close();
               }

               if (this.anOutputStream612 != null) {
                  this.anOutputStream612.close();
               }

               if (this.aSocket605 != null) {
                  this.aSocket605.close();
               }
            } catch (IOException var5) {
            }

            this.aByteArray602 = null;
            break;
         }
      } catch (Exception var10) {
         ClanChat.method507(var10, null, -115);
      }

      ++anInt613;
   }

   final void method425(int i, byte b, int i_12_, byte[] bs) throws IOException {
      ++anInt606;
      if (b < 47) {
         method421(-53);
      }

      if (!this.aBoolean601) {
         while(~i < -1) {
            int i_13_ = this.anInputStream604.read(bs, i_12_, i);
            if (~i_13_ >= -1) {
               throw new EOFException();
            }

            i_12_ += i_13_;
            i -= i_13_;
         }
      }
   }

   final void method426(byte b) {
      ++anInt595;
      if (!this.aBoolean601) {
         if (b >= -61) {
            aClass346_615 = null;
         }

         this.anInputStream604 = new InputStream_Sub2();
         this.anOutputStream612 = new OutputStream_Sub2();
      }
   }

   @Override
   protected final void finalize() {
      ++anInt611;
      this.method430(20692);
   }

   static final void method427(Class48 class48, int i, Animable animable, byte b) {
      ++anInt600;
      if (~Class23.anInt434 > -51
         && class48 != null
         && class48.anIntArrayArray700 != null
         && ~class48.anIntArrayArray700.length < ~i
         && class48.anIntArrayArray700[i] != null) {
         if (b != -63) {
            aClass346_615 = null;
         }

         int i_14_ = class48.anIntArrayArray700[i][0];
         int i_15_ = i_14_ >> 8;
         int i_16_ = 7 & i_14_ >> 5;
         if (~class48.anIntArrayArray700[i].length < -2) {
            int i_17_ = (int)(Math.random() * (double)class48.anIntArrayArray700[i].length);
            if (i_17_ > 0) {
               i_15_ = class48.anIntArrayArray700[i][i_17_];
            }
         }

         int i_18_ = i_14_ & 31;
         int i_19_ = 256;
         if (class48.anIntArray690 != null && class48.anIntArray692 != null) {
            i_19_ = class48.anIntArray690[i] + (int)((double)(-class48.anIntArray690[i] + class48.anIntArray692[i]) * Math.random());
         }

         int i_20_ = class48.anIntArray701 == null ? 255 : class48.anIntArray701[i];
         if (~i_18_ == -1) {
            if (animable == Class295.myPlayer) {
               if (!class48.aBoolean699) {
                  TextureDefinitions.method1033(i_19_, 0, i_15_, i_16_, i_20_, 0);
               } else {
                  Class105.method1116(i_15_, i_16_, i_19_, (byte)97, 0, i_20_, false);
               }
            }
         } else if (~Class213.aNode_Sub27_2512.aClass320_Sub25_7265.method3776(false) != -1) {
            int i_21_ = animable.x + -256 >> 9;
            int i_22_ = -256 + animable.y >> 9;
            int i_23_ = animable == Class295.myPlayer ? 0 : i_18_ + (i_22_ << 8) + (i_21_ << 16) + (animable.plane << 24);
            Node_Sub38_Sub19.aClass78Array10284[Class23.anInt434++] = new Class78(
               (byte)(class48.aBoolean699 ? 2 : 1), i_15_, i_16_, 0, i_20_, i_23_, i_19_, animable
            );
         }
      }
   }

   final int method428(int i) throws IOException {
      ++anInt599;
      if (i != 0) {
         method422(-76, 68, 102, -65, -42, 100, 0, 89, -69, -43, 81, -50);
      }

      return this.aBoolean601 ? 0 : this.anInputStream604.available();
   }

   final void method429(int i, int i_24_, byte[] bs, byte b) throws IOException {
      ++anInt598;
      if (b == 78 && !this.aBoolean601) {
         if (this.aBoolean614) {
            this.aBoolean614 = false;
            throw new IOException();
         }

         if (this.aByteArray602 == null) {
            this.aByteArray602 = new byte[this.anInt603];
         }

         synchronized(this) {
            for(int i_25_ = 0; i_24_ > i_25_; ++i_25_) {
               this.aByteArray602[this.anInt609] = bs[i + i_25_];
               this.anInt609 = (this.anInt609 + 1) % this.anInt603;
               if ((this.anInt603 + this.anInt608 - 100) % this.anInt603 == this.anInt609) {
                  throw new IOException();
               }
            }

            if (this.aClass241_596 == null) {
               this.aClass241_596 = this.aSignLink617.method3641((byte)50, this, 3);
            }

            this.notifyAll();
         }
      }
   }

   BufferedConnection(Socket socket, SignLink signlink, int i) throws IOException {
      this.anInt608 = 0;
      this.aBoolean614 = false;
      this.aSignLink617 = signlink;
      this.aSocket605 = socket;
      this.aSocket605.setSoTimeout(30000);
      this.aSocket605.setTcpNoDelay(true);
      this.anInputStream604 = this.aSocket605.getInputStream();
      this.anOutputStream612 = this.aSocket605.getOutputStream();
      this.anInt603 = i;
   }

   final void method430(int i) {
      ++anInt616;
      if (!this.aBoolean601) {
         synchronized(this) {
            if (i != 20692) {
               this.run();
            }

            this.aBoolean601 = true;
            this.notifyAll();
         }

         if (this.aClass241_596 != null) {
            while(~this.aClass241_596.anInt2953 == -1) {
               Class262_Sub22.method3208(1L, false);
            }

            if (~this.aClass241_596.anInt2953 == -2) {
               try {
                  ((Thread)this.aClass241_596.anObject2956).join();
               } catch (InterruptedException var3) {
               }
            }
         }

         this.aClass241_596 = null;
      }
   }
}
