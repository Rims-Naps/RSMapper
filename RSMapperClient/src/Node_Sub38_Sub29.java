public class Node_Sub38_Sub29 extends Node_Sub38 {
   static int anInt10405;
   static Class212 aClass212_10406 = new Class212("", 17);
   static int anInt10407;
   static int anInt10408;
   static int anInt10409;
   private int anInt10410 = 585;

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      ++anInt10405;
      if (i == 0) {
         this.anInt10410 = buffer.readUnsignedShort();
      }

      if (bool) {
         this.method2780(false, null, 11);
      }
   }

   @Override
   final int[] method2775(int i, int i_1_) {
      ++anInt10407;
      if (i <= 107) {
         method2889(null, 60, -47, true, -23, null, true);
      }

      int[] is = this.aClass146_7460.method1645(27356, i_1_);
      if (this.aClass146_7460.aBoolean1819) {
         int i_2_ = Node_Sub25_Sub1.anIntArray9941[i_1_];

         for(int i_3_ = 0; ~i_3_ > ~Class339_Sub7.anInt8728; ++i_3_) {
            int i_4_ = CacheNode_Sub3.anIntArray9442[i_3_];
            if (~i_4_ < ~this.anInt10410 && i_4_ < 4096 + -this.anInt10410 && i_2_ > 2048 + -this.anInt10410 && i_2_ < this.anInt10410 + 2048) {
               int i_5_ = 2048 + -i_4_;
               i_5_ = ~i_5_ <= -1 ? i_5_ : -i_5_;
               i_5_ <<= 12;
               i_5_ /= -this.anInt10410 + 2048;
               is[i_3_] = -i_5_ + 4096;
            } else if (-this.anInt10410 + 2048 < i_4_ && ~i_4_ > ~(2048 + this.anInt10410)) {
               int i_6_ = -2048 + i_2_;
               i_6_ = ~i_6_ > -1 ? -i_6_ : i_6_;
               i_6_ -= this.anInt10410;
               i_6_ <<= 12;
               is[i_3_] = i_6_ / (-this.anInt10410 + 2048);
            } else if (~this.anInt10410 >= ~i_2_ && i_2_ <= -this.anInt10410 + 4096) {
               if (~this.anInt10410 >= ~i_4_ && ~i_4_ >= ~(-this.anInt10410 + 4096)) {
                  is[i_3_] = 0;
               } else {
                  int i_8_ = 2048 - i_2_;
                  i_8_ = ~i_8_ <= -1 ? i_8_ : -i_8_;
                  i_8_ <<= 12;
                  i_8_ /= -this.anInt10410 + 2048;
                  is[i_3_] = -i_8_ + 4096;
               }
            } else {
               int i_7_ = -2048 + i_4_;
               i_7_ = i_7_ < 0 ? -i_7_ : i_7_;
               i_7_ -= this.anInt10410;
               i_7_ <<= 12;
               is[i_3_] = i_7_ / (-this.anInt10410 + 2048);
            }
         }
      }

      return is;
   }

   static final int method2889(Class377_Sub1 class377_sub1, int i, int i_9_, boolean bool, int i_10_, Class377_Sub1 class377_sub1_11_, boolean bool_12_) {
      ++anInt10408;
      if (i_10_ < 14) {
         method2889(null, -49, -123, false, -125, null, true);
      }

      int i_13_ = Node_Sub51.method2969(class377_sub1, bool_12_, class377_sub1_11_, i, 1);
      if (~i_13_ != -1) {
         return !bool_12_ ? i_13_ : -i_13_;
      } else if (i_9_ == -1) {
         return 0;
      } else {
         int i_14_ = Node_Sub51.method2969(class377_sub1, bool, class377_sub1_11_, i_9_, 1);
         return !bool ? i_14_ : -i_14_;
      }
   }

   public Node_Sub38_Sub29() {
      super(0, true);
   }

   public static void method2890(byte b) {
      int i = 24 / ((-81 - b) / 34);
      aClass212_10406 = null;
   }
}
