import java.util.Random;

public class Node_Sub38_Sub11 extends Node_Sub38 {
   static int anInt10200;
   private int anInt10201 = 204;
   static int anInt10202;
   private int[][] anIntArrayArray10203;
   private int anInt10204;
   private int anInt10205;
   private int anInt10206;
   static int anInt10207;
   private int anInt10208;
   private int anInt10209;
   private int[] anIntArray10210;
   private int anInt10211;
   static int anInt10212;
   private int anInt10213 = 1024;
   static int anInt10214;
   static long aLong10215;
   static int anInt10216;
   static int[] anIntArray10217 = new int[32];
   static int[] anIntArray10218 = new int[4096];
   private int anInt10219;
   private int anInt10220;
   static OutgoingPacket aClass318_10221 = new OutgoingPacket(36, -1);
   private int anInt10222;
   private int[][] anIntArrayArray10223;

   static final void method2826(boolean bool, double d) {
      ++anInt10214;
      Class113.aClass336_1440.method3857(Class225.aClass336_2678);
      if (bool) {
         Class113.aClass336_1440.method3863(0, 0, (int)d);
         Class44.aGraphicsToolkit668.a(Class113.aClass336_1440);
      }
   }

   private final void method2827(int i) {
      ++anInt10202;
      Random random = new Random((long)this.anInt10204);
      this.anInt10206 = 4096 / this.anInt10222;
      this.anInt10219 = 4096 / this.anInt10204;
      this.anInt10211 = this.anInt10205 / 2;
      int i_0_ = this.anInt10206 / 2;
      this.anIntArrayArray10203 = new int[this.anInt10204][this.anInt10222 - -1];
      if (i != 25428) {
         anIntArray10218 = null;
      }

      this.anIntArray10210 = new int[this.anInt10204 + 1];
      int i_1_ = this.anInt10219 / 2;
      this.anIntArrayArray10223 = new int[this.anInt10204][this.anInt10222];
      this.anIntArray10210[0] = 0;

      for(int i_2_ = 0; this.anInt10204 > i_2_; ++i_2_) {
         if (i_2_ > 0) {
            int i_3_ = this.anInt10219;
            int i_4_ = (Class330.method3838(-5208, 4096, random) + -2048) * this.anInt10201 >> 12;
            i_3_ += i_4_ * i_1_ >> 12;
            this.anIntArray10210[i_2_] = this.anIntArray10210[i_2_ + -1] - -i_3_;
         }

         this.anIntArrayArray10203[i_2_][0] = 0;

         for(int i_5_ = 0; ~this.anInt10222 < ~i_5_; ++i_5_) {
            if (~i_5_ < -1) {
               int i_6_ = this.anInt10206;
               int i_7_ = (Class330.method3838(-5208, 4096, random) + -2048) * this.anInt10220 >> 12;
               i_6_ += i_0_ * i_7_ >> 12;
               this.anIntArrayArray10203[i_2_][i_5_] = i_6_ + this.anIntArrayArray10203[i_2_][i_5_ - 1];
            }

            this.anIntArrayArray10223[i_2_][i_5_] = this.anInt10209 > 0
               ? 4096 - Class330.method3838(Node_Sub19.method2612(i, -30468), this.anInt10209, random)
               : 4096;
         }

         this.anIntArrayArray10203[i_2_][this.anInt10222] = 4096;
      }

      this.anIntArray10210[this.anInt10204] = 4096;
   }

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      if (~i != -1) {
         if (~i != -2) {
            if (i != 2) {
               if (i != 3) {
                  if (i != 4) {
                     if (i != 5) {
                        if (~i != -7) {
                           if (~i == -8) {
                              this.anInt10209 = buffer.readUnsignedShort();
                           }
                        } else {
                           this.anInt10205 = buffer.readUnsignedShort();
                        }
                     } else {
                        this.anInt10208 = buffer.readUnsignedShort();
                     }
                  } else {
                     this.anInt10213 = buffer.readUnsignedShort();
                  }
               } else {
                  this.anInt10201 = buffer.readUnsignedShort();
               }
            } else {
               this.anInt10220 = buffer.readUnsignedShort();
            }
         } else {
            this.anInt10204 = buffer.readUnsignedByte();
         }
      } else {
         this.anInt10222 = buffer.readUnsignedByte();
      }

      if (bool) {
         aClass318_10221 = null;
      }

      ++anInt10216;
   }

   @Override
   final void method2785(int i) {
      if (i != 7) {
         this.method2780(true, null, 83);
      }

      this.method2827(i + 25421);
      ++anInt10200;
   }

   static final boolean isRightMouseClickButton(int i, int i_9_) {
      ++anInt10207;
      return i == 0 || i == 1 || i == 2;
   }

   public Node_Sub38_Sub11() {
      super(0, true);
      this.anInt10205 = 81;
      this.anInt10209 = 1024;
      this.anInt10208 = 0;
      this.anInt10204 = 8;
      this.anInt10220 = 409;
      this.anInt10222 = 4;
   }

   @Override
   final int[] method2775(int i, int i_10_) {
      ++anInt10212;
      if (i < 107) {
         anIntArray10217 = null;
      }

      int[] is = this.aClass146_7460.method1645(27356, i_10_);
      if (this.aClass146_7460.aBoolean1819) {
         int i_11_ = 0;
         int i_12_ = this.anInt10208 + Node_Sub25_Sub1.anIntArray9941[i_10_];

         while(i_12_ < 0) {
            i_12_ += 4096;
         }

         while(~i_12_ < -4097) {
            i_12_ -= 4096;
         }

         while(~i_11_ > ~this.anInt10204 && ~this.anIntArray10210[i_11_] >= ~i_12_) {
            ++i_11_;
         }

         int i_13_ = i_11_ + -1;
         boolean bool = (1 & i_11_) == 0;
         int i_14_ = this.anIntArray10210[i_11_];
         int i_15_ = this.anIntArray10210[i_11_ - 1];
         if (~(this.anInt10211 + i_15_) > ~i_12_ && i_12_ < -this.anInt10211 + i_14_) {
            for(int i_16_ = 0; ~i_16_ > ~Class339_Sub7.anInt8728; ++i_16_) {
               int i_17_ = 0;
               int i_18_ = !bool ? -this.anInt10213 : this.anInt10213;
               int i_19_ = CacheNode_Sub3.anIntArray9442[i_16_] + (i_18_ * this.anInt10206 >> 12);

               while(~i_19_ > -1) {
                  i_19_ += 4096;
               }

               while(i_19_ > 4096) {
                  i_19_ -= 4096;
               }

               while(~i_17_ > ~this.anInt10222 && ~this.anIntArrayArray10203[i_13_][i_17_] >= ~i_19_) {
                  ++i_17_;
               }

               int i_20_ = i_17_ - 1;
               int i_21_ = this.anIntArrayArray10203[i_13_][i_17_];
               int i_22_ = this.anIntArrayArray10203[i_13_][i_20_];
               if (i_19_ > this.anInt10211 + i_22_ && ~i_19_ > ~(i_21_ + -this.anInt10211)) {
                  is[i_16_] = this.anIntArrayArray10223[i_13_][i_20_];
               } else {
                  is[i_16_] = 0;
               }
            }
         } else {
            Class311.method3604(is, 0, Class339_Sub7.anInt8728, 0);
         }
      }

      return is;
   }

   public static void method2829(byte b) {
      int i = 109 / ((47 - b) / 38);
      anIntArray10217 = null;
      anIntArray10218 = null;
      aClass318_10221 = null;
   }
}
