import java.awt.Rectangle;

public class Node_Sub38_Sub28 extends Node_Sub38 {
   private int[] anIntArray10391;
   private int anInt10392 = 2048;
   private int anInt10393 = 0;
   static int anInt10394;
   static int anInt10395;
   static int anInt10396;
   static int anInt10397;
   static int anInt10398;
   private int anInt10399 = 10;
   private int[] anIntArray10400;
   static int anInt10401;
   static IncommingPacket aClass192_10402 = new IncommingPacket(40, -1);
   static int anInt10403 = 0;
   static Rectangle[] aRectangleArray10404 = new Rectangle[100];

   static {
      for(int i = 0; ~i > -101; ++i) {
         aRectangleArray10404[i] = new Rectangle();
      }
   }

   public static void method2885(byte b) {
      if (b < 69) {
         aClass192_10402 = null;
      }

      aRectangleArray10404 = null;
      aClass192_10402 = null;
   }

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      if (!bool) {
         if (i != 0) {
            if (~i != -2) {
               if (~i == -3) {
                  this.anInt10393 = buffer.readUnsignedByte();
               }
            } else {
               this.anInt10392 = buffer.readUnsignedShort();
            }
         } else {
            this.anInt10399 = buffer.readUnsignedByte();
         }

         ++anInt10397;
      }
   }

   private final void method2886(int i) {
      ++anInt10396;
      this.anIntArray10400 = new int[this.anInt10399 - -1];
      this.anIntArray10391 = new int[this.anInt10399 - -1];
      int i_1_ = 0;
      int i_2_ = 4096 / this.anInt10399;
      int i_3_ = i_2_ * this.anInt10392 >> 12;

      for(int i_4_ = 0; i_4_ < this.anInt10399; ++i_4_) {
         this.anIntArray10391[i_4_] = i_1_;
         this.anIntArray10400[i_4_] = i_1_ + i_3_;
         i_1_ += i_2_;
      }

      this.anIntArray10391[this.anInt10399] = 4096;
      if (i != -3749) {
         this.method2780(true, null, 96);
      }

      this.anIntArray10400[this.anInt10399] = 4096 - -this.anIntArray10400[0];
   }

   static final void loginToLobby(String password, String username, byte b) {
      Node_Sub38_Sub23.anInt10347 = -1;
      Class320_Sub23.aClass123_8432 = Class218.aClass123_2566;
      Class159.loginType = 2;
      Class129.method1556(false, username, true, false, password);
   }

   @Override
   final int[] method2775(int i, int i_6_) {
      ++anInt10401;
      int[] is = this.aClass146_7460.method1645(27356, i_6_);
      if (i <= 107) {
         aRectangleArray10404 = null;
      }

      if (this.aClass146_7460.aBoolean1819) {
         int i_7_ = Node_Sub25_Sub1.anIntArray9941[i_6_];
         if (this.anInt10393 != 0) {
            for(int i_8_ = 0; ~Class339_Sub7.anInt8728 < ~i_8_; ++i_8_) {
               int i_9_ = 0;
               int i_10_ = 0;
               int i_11_ = CacheNode_Sub3.anIntArray9442[i_8_];
               int i_12_ = this.anInt10393;
               if (i_12_ != 1) {
                  if (~i_12_ != -3) {
                     if (i_12_ == 3) {
                        i_9_ = (i_11_ + -i_7_ >> 1) + 2048;
                     }
                  } else {
                     i_9_ = 2048 + (i_11_ + -4096 + i_7_ >> 1);
                  }
               } else {
                  i_9_ = i_11_;
               }

               for(int var12 = 0; this.anInt10399 > var12; ++var12) {
                  if (~i_9_ <= ~this.anIntArray10391[var12] && i_9_ < this.anIntArray10391[1 + var12]) {
                     if (this.anIntArray10400[var12] > i_9_) {
                        i_10_ = 4096;
                     }
                     break;
                  }
               }

               is[i_8_] = i_10_;
            }
         } else {
            int i_13_ = 0;

            for(int i_14_ = 0; this.anInt10399 > i_14_; ++i_14_) {
               if (~this.anIntArray10391[i_14_] >= ~i_7_ && this.anIntArray10391[1 + i_14_] > i_7_) {
                  if (this.anIntArray10400[i_14_] > i_7_) {
                     i_13_ = 4096;
                  }
                  break;
               }
            }

            Class311.method3604(is, 0, Class339_Sub7.anInt8728, i_13_);
         }
      }

      return is;
   }

   public Node_Sub38_Sub28() {
      super(0, true);
   }

   static final void method2888(byte b, Index class302) {
      Node_Sub50.anInt7625 = class302.method3519("p11_full", (byte)46);
      ++anInt10394;
      if (b >= 53) {
         Class285.anInt3600 = class302.method3519("p12_full", (byte)26);
         Class340.anInt4220 = class302.method3519("b12_full", (byte)54);
      }
   }

   @Override
   final void method2785(int i) {
      ++anInt10395;
      if (i != 7) {
         this.anInt10393 = -7;
      }

      this.method2886(-3749);
   }
}
