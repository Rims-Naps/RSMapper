public class Node_Sub38_Sub30 extends Node_Sub38 {
   private int anInt10411;
   static int anInt10412;
   static int anInt10413;
   static int anInt10414;
   private int anInt10415 = 4;

   @Override
   final int[][] method2778(int i, boolean bool) {
      if (!bool) {
         this.anInt10411 = -56;
      }

      ++anInt10412;
      int[][] is = this.aClass348_7454.method3981(i, 3168);
      if (this.aClass348_7454.aBoolean4300) {
         int i_0_ = Class339_Sub7.anInt8728 / this.anInt10415;
         int i_1_ = Node_Sub38_Sub1.anInt10083 / this.anInt10411;
         int[][] is_2_;
         if (i_1_ > 0) {
            int i_3_ = i % i_1_;
            is_2_ = this.method2777(-98, 0, i_3_ * Node_Sub38_Sub1.anInt10083 / i_1_);
         } else {
            is_2_ = this.method2777(-84, 0, 0);
         }

         int[] is_4_ = is_2_[0];
         int[] is_5_ = is_2_[1];
         int[] is_6_ = is_2_[2];
         int[] is_7_ = is[0];
         int[] is_8_ = is[1];
         int[] is_9_ = is[2];

         for(int i_10_ = 0; i_10_ < Class339_Sub7.anInt8728; ++i_10_) {
            int i_11_;
            if (i_0_ <= 0) {
               i_11_ = 0;
            } else {
               int i_12_ = i_10_ % i_0_;
               i_11_ = i_12_ * Class339_Sub7.anInt8728 / i_0_;
            }

            is_7_[i_10_] = is_4_[i_11_];
            is_8_[i_10_] = is_5_[i_11_];
            is_9_[i_10_] = is_6_[i_11_];
         }
      }

      return is;
   }

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      ++anInt10414;
      if (~i != -1) {
         if (i == 1) {
            this.anInt10411 = buffer.readUnsignedByte();
         }
      } else {
         this.anInt10415 = buffer.readUnsignedByte();
      }

      if (bool) {
         this.method2780(true, null, -94);
      }
   }

   public Node_Sub38_Sub30() {
      super(1, false);
      this.anInt10411 = 4;
   }

   @Override
   final int[] method2775(int i, int i_14_) {
      ++anInt10413;
      int[] is = this.aClass146_7460.method1645(27356, i_14_);
      if (i < 107) {
         this.method2775(94, -126);
      }

      if (this.aClass146_7460.aBoolean1819) {
         int i_15_ = Class339_Sub7.anInt8728 / this.anInt10415;
         int i_16_ = Node_Sub38_Sub1.anInt10083 / this.anInt10411;
         int[] is_17_;
         if (i_16_ > 0) {
            int i_18_ = i_14_ % i_16_;
            is_17_ = this.method2786(Node_Sub38_Sub1.anInt10083 * i_18_ / i_16_, 0, 0);
         } else {
            is_17_ = this.method2786(0, 0, 0);
         }

         for(int i_19_ = 0; ~Class339_Sub7.anInt8728 < ~i_19_; ++i_19_) {
            if (i_15_ > 0) {
               int i_20_ = i_19_ % i_15_;
               is[i_19_] = is_17_[i_20_ * Class339_Sub7.anInt8728 / i_15_];
            } else {
               is[i_19_] = is_17_[0];
            }
         }
      }

      return is;
   }
}
