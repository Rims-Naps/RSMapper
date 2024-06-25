public class Node_Sub38_Sub36 extends Node_Sub38 {
   static int anInt10456;
   private int anInt10457;
   private int anInt10458 = 1365;
   private int anInt10459;
   static int anInt10460;
   private int anInt10461;
   static long aLong10462;
   static int anInt10463;

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      if (~i != -1) {
         if (~i != -2) {
            if (i != 2) {
               if (~i == -4) {
                  this.anInt10461 = buffer.readUnsignedShort();
               }
            } else {
               this.anInt10459 = buffer.readUnsignedShort();
            }
         } else {
            this.anInt10457 = buffer.readUnsignedShort();
         }
      } else {
         this.anInt10458 = buffer.readUnsignedShort();
      }

      ++anInt10463;
      if (bool) {
         method2904(-90, null);
      }
   }

   public Node_Sub38_Sub36() {
      super(0, true);
      this.anInt10457 = 20;
      this.anInt10459 = 0;
      this.anInt10461 = 0;
   }

   static final void method2904(int i, Buffer buffer) {
      for(int i_1_ = 0; i_1_ < Class254.anInt3212; ++i_1_) {
         int i_2_ = buffer.readSmart();
         int i_3_ = buffer.readUnsignedShort();
         if (i_3_ == 65535) {
            i_3_ = -1;
         }

         if (Class56.aClass377_Sub1Array841[i_2_] != null) {
            Class56.aClass377_Sub1Array841[i_2_].anInt4671 = i_3_;
         }
      }

      if (i != -1) {
         method2904(-83, null);
      }

      ++anInt10456;
   }

   @Override
   final int[] method2775(int i, int i_4_) {
      ++anInt10460;
      int[] is = this.aClass146_7460.method1645(27356, i_4_);
      if (this.aClass146_7460.aBoolean1819) {
         for(int i_5_ = 0; Class339_Sub7.anInt8728 > i_5_; ++i_5_) {
            int i_6_ = this.anInt10459 + (CacheNode_Sub3.anIntArray9442[i_5_] << 12) / this.anInt10458;
            int i_7_ = (Node_Sub25_Sub1.anIntArray9941[i_4_] << 12) / this.anInt10458 + this.anInt10461;
            int i_8_ = i_6_;
            int i_9_ = i_7_;
            int i_10_ = i_6_;
            int i_11_ = i_7_;
            int i_12_ = i_6_ * i_6_ >> 12;
            int i_13_ = i_7_ * i_7_ >> 12;

            int i_14_;
            for(i_14_ = 0; i_12_ + i_13_ < 16384 && ~this.anInt10457 < ~i_14_; i_13_ = i_11_ * i_11_ >> 12) {
               i_11_ = i_9_ + (i_11_ * i_10_ >> 12) * 2;
               i_10_ = i_8_ + i_12_ - i_13_;
               ++i_14_;
               i_12_ = i_10_ * i_10_ >> 12;
            }

            is[i_5_] = i_14_ >= this.anInt10457 + -1 ? 0 : (i_14_ << 12) / this.anInt10457;
         }
      }

      if (i < 107) {
         method2904(-124, null);
      }

      return is;
   }
}
