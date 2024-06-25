import java.util.Random;

public class Class250 {
   static boolean[][] aBooleanArrayArray3168 = new boolean[][]{
      new boolean[4],
      {false, true, true, false},
      {true, false, true, false},
      {true, false, true, false},
      {false, false, true, false},
      {false, false, true, false},
      {true, false, true, false},
      {true, false, false, true},
      {true, false, false, true},
      {true, true, false, false},
      new boolean[4],
      {false, true, false, true},
      new boolean[4]
   };
   static int anInt3169;
   static int anInt3170;
   static int anInt3171;
   private int[][] anIntArrayArray3172;
   private boolean[] aBooleanArray3173;
   static int anInt3174;
   static boolean aBoolean3175 = false;
   static int anInt3176;
   private Index aClass302_3177;
   private int anInt3178;
   static Index index10;

   final int[] method3091(int i, byte b) {
      ++anInt3174;
      if (i >= 0 && ~this.anIntArrayArray3172.length < ~i) {
         if (this.aBooleanArray3173[i] && this.anIntArrayArray3172[i].length > 1) {
            int i_0_ = this.anInt3178 != -1 ? 1 : 0;
            Random random = new Random();
            int[] is = new int[this.anIntArrayArray3172[i].length];
            Class311.method3609(this.anIntArrayArray3172[i], 0, is, 0, is.length);
            if (b <= 97) {
               this.method3091(13, (byte)-73);
            }

            for(int i_1_ = i_0_; is.length > i_1_; ++i_1_) {
               int i_2_ = i_0_ + Class330.method3838(-5208, -i_0_ + is.length, random);
               int i_3_ = is[i_1_];
               is[i_1_] = is[i_2_];
               is[i_2_] = i_3_;
            }

            return is;
         } else {
            return this.anIntArrayArray3172[i];
         }
      } else {
         return ~this.anInt3178 != 0 ? new int[]{this.anInt3178} : new int[0];
      }
   }

   final boolean method3092(boolean bool) {
      if (bool) {
         method3095(88, -67);
      }

      ++anInt3170;
      return this.anInt3178 != -1;
   }

   final Class55 method3093(int i, boolean bool) {
      try {
         ++anInt3176;
         byte[] bs = this.aClass302_3177.getFile(bool, i, 1);
         Class55 class55 = new Class55();
         class55.method561(new Buffer(bs), (byte)31);
         return class55;
      } catch (RuntimeException var5) {
         throw Class126.method1537(var5, "oka.D(" + i + ',' + bool + ')');
      }
   }

   public static void method3094(byte b) {
      if (b < -52) {
         aBooleanArrayArray3168 = null;
         index10 = null;
      }
   }

   static final Class329 method3095(int i, int i_4_) {
      ++anInt3169;
      Class329[] class329s = Class154.method1698(54);

      for(int i_5_ = i_4_; ~i_5_ > ~class329s.length; ++i_5_) {
         Class329 class329 = class329s[i_5_];
         if (class329.anInt4123 == i) {
            return class329;
         }
      }

      return null;
   }

   static final boolean method3096(int i, int i_6_) {
      if (i_6_ >= -60) {
         return false;
      } else {
         ++anInt3171;
         return i == 0 || ~i == -3;
      }
   }

   Class250(Class353 class353, int i, Index class302) {
      this.aClass302_3177 = class302;
      this.aClass302_3177.method3537(-2, 1);
      Buffer buffer = new Buffer(this.aClass302_3177.getFile(false, 0, 0));
      int i_7_ = buffer.readUnsignedByte();
      if (i_7_ <= 3) {
         int i_8_ = buffer.readUnsignedByte();
         Class170[] class170s = Class262_Sub13.method3184(0);
         boolean bool = true;
         if (i_8_ == class170s.length) {
            for(int i_9_ = 0; ~i_9_ > ~class170s.length; ++i_9_) {
               int i_10_ = buffer.readUnsignedByte();
               if (i_10_ != class170s[i_9_].anInt2047) {
                  bool = false;
                  break;
               }
            }
         } else {
            bool = false;
         }

         if (bool) {
            int i_11_ = buffer.readUnsignedByte();
            int i_12_ = buffer.readUnsignedByte();
            if (i_7_ > 2) {
               this.anInt3178 = buffer.readShort();
            } else {
               this.anInt3178 = -1;
            }

            this.anIntArrayArray3172 = new int[1 + i_12_][];
            this.aBooleanArray3173 = new boolean[i_12_ + 1];

            for(int i_13_ = 0; i_11_ > i_13_; ++i_13_) {
               int i_14_ = buffer.readUnsignedByte();
               this.aBooleanArray3173[i_14_] = ~buffer.readUnsignedByte() == -2;
               int i_15_ = buffer.readUnsignedShort();
               if (this.anInt3178 != -1) {
                  this.anIntArrayArray3172[i_14_] = new int[1 + i_15_];
                  this.anIntArrayArray3172[i_14_][0] = this.anInt3178;

                  for(int i_16_ = 0; i_16_ < i_15_; ++i_16_) {
                     this.anIntArrayArray3172[i_14_][1 + i_16_] = buffer.readUnsignedShort();
                  }
               } else {
                  this.anIntArrayArray3172[i_14_] = new int[i_15_];

                  for(int i_17_ = 0; ~i_15_ < ~i_17_; ++i_17_) {
                     this.anIntArrayArray3172[i_14_][i_17_] = buffer.readUnsignedShort();
                  }
               }
            }

            for(int i_18_ = 0; i_18_ < i_12_ + 1; ++i_18_) {
               if (this.anIntArrayArray3172[i_18_] == null) {
                  if (~this.anInt3178 == 0) {
                     this.anIntArrayArray3172[i_18_] = new int[0];
                  } else {
                     this.anIntArrayArray3172[i_18_] = new int[]{this.anInt3178};
                  }
               }
            }
         } else {
            this.aBooleanArray3173 = new boolean[0];
            this.anIntArrayArray3172 = new int[0][];
            this.anInt3178 = -1;
         }
      } else {
         this.aBooleanArray3173 = new boolean[0];
         this.anInt3178 = -1;
         this.anIntArrayArray3172 = new int[0][];
      }
   }
}
