public class Node_Sub38_Sub13 extends Node_Sub38 {
   static int[] objectTypeFlags = new int[]{0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3};
   static int anInt10233;
   private int anInt10234 = 1024;
   static int anInt10235;
   static int anInt10236;
   private int anInt10237;
   static int anInt10238;
   private int anInt10239 = 2048;
   static int anInt10240;

   @Override
   final void method2785(int i) {
      if (i != 7) {
         this.method2775(69, 15);
      }

      this.anInt10239 = this.anInt10237 + -this.anInt10234;
      ++anInt10233;
   }

   static final void method2831(int[] is, int i, int[] is_0_, int[] is_1_, Actor actor) {
      ++anInt10235;
      if (i != -31813) {
         objectTypeFlags = null;
      }

      for(int i_2_ = 0; ~is_0_.length < ~i_2_; ++i_2_) {
         int i_3_ = is_0_[i_2_];
         int i_4_ = is[i_2_];
         int i_5_ = is_1_[i_2_];

         for(int i_6_ = 0; i_4_ != 0 && ~actor.anAnimableAnimator_Sub1Array10894.length < ~i_6_; i_4_ >>>= 1) {
            if (~(1 & i_4_) != -1) {
               if (i_3_ == -1) {
                  actor.anAnimableAnimator_Sub1Array10894[i_6_] = null;
               } else {
                  Class48 class48 = Class18.aClass37_306.method395(i_3_, (byte)-101);
                  int i_7_ = class48.anInt706;
                  AnimableAnimator_Sub1 animableanimator_sub1 = actor.anAnimableAnimator_Sub1Array10894[i_6_];
                  if (animableanimator_sub1 != null && animableanimator_sub1.method245(-127)) {
                     if (i_3_ == animableanimator_sub1.getAnimationId()) {
                        if (i_7_ == 0) {
                           animableanimator_sub1 = actor.anAnimableAnimator_Sub1Array10894[i_6_] = null;
                        } else if (i_7_ == 1) {
                           animableanimator_sub1.method235(i ^ -31813);
                           animableanimator_sub1.anInt9094 = i_5_;
                        } else if (i_7_ == 2) {
                           animableanimator_sub1.method251(true);
                        }
                     } else if (class48.anInt710 >= animableanimator_sub1.method243((byte)-24).anInt710) {
                        animableanimator_sub1 = actor.anAnimableAnimator_Sub1Array10894[i_6_] = null;
                     }
                  }

                  if (animableanimator_sub1 == null || !animableanimator_sub1.method245(i ^ 31801)) {
                     animableanimator_sub1 = actor.anAnimableAnimator_Sub1Array10894[i_6_] = new AnimableAnimator_Sub1(actor);
                     animableanimator_sub1.method249(true, i_3_);
                     animableanimator_sub1.anInt9094 = i_5_;
                  }
               }
            }

            ++i_6_;
         }
      }
   }

   public Node_Sub38_Sub13() {
      super(1, false);
      this.anInt10237 = 3072;
   }

   public static void method2832(byte b) {
      if (b == 121) {
         objectTypeFlags = null;
      }
   }

   @Override
   final int[][] method2778(int i, boolean bool) {
      ++anInt10240;
      if (!bool) {
         this.method2775(33, -89);
      }

      int[][] is = this.aClass348_7454.method3981(i, 3168);
      if (this.aClass348_7454.aBoolean4300) {
         int[][] is_8_ = this.method2777(-65, 0, i);
         int[] is_9_ = is_8_[0];
         int[] is_10_ = is_8_[1];
         int[] is_11_ = is_8_[2];
         int[] is_12_ = is[0];
         int[] is_13_ = is[1];
         int[] is_14_ = is[2];

         for(int i_15_ = 0; ~i_15_ > ~Class339_Sub7.anInt8728; ++i_15_) {
            is_12_[i_15_] = this.anInt10234 - -(is_9_[i_15_] * this.anInt10239 >> 12);
            is_13_[i_15_] = (this.anInt10239 * is_10_[i_15_] >> 12) + this.anInt10234;
            is_14_[i_15_] = (this.anInt10239 * is_11_[i_15_] >> 12) + this.anInt10234;
         }
      }

      return is;
   }

   @Override
   final int[] method2775(int i, int i_16_) {
      ++anInt10236;
      int[] is = this.aClass146_7460.method1645(27356, i_16_);
      if (this.aClass146_7460.aBoolean1819) {
         int[] is_17_ = this.method2786(i_16_, 0, 0);

         for(int i_18_ = 0; ~i_18_ > ~Class339_Sub7.anInt8728; ++i_18_) {
            is[i_18_] = (this.anInt10239 * is_17_[i_18_] >> 12) + this.anInt10234;
         }
      }

      if (i < 107) {
         this.anInt10239 = -15;
      }

      return is;
   }

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      if (bool) {
         this.method2785(-19);
      }

      if (i != 0) {
         if (~i != -2) {
            if (i == 2) {
               this.aBoolean7463 = ~buffer.readUnsignedByte() == -2;
            }
         } else {
            this.anInt10237 = buffer.readUnsignedShort();
         }
      } else {
         this.anInt10234 = buffer.readUnsignedShort();
      }

      ++anInt10238;
   }
}
