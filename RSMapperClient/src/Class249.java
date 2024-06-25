public class Class249 {
   protected int anInt3148;
   static int anInt3149;
   protected int anInt3150;
   static int[] anIntArray3151 = new int[]{4, 4, 1, 2, 6, 4, 2, 44, 2, 2, 2, 2, 2, 1, 2, 2, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1};
   protected int anInt3152;
   static int anInt3153;
   static Buffer[] cachedAppearences = new Buffer[2048];
   protected int anInt3155 = 0;
   protected long aLong3156;
   protected int anInt3157;
   protected int anInt3158;
   static int anInt3159;
   protected int anInt3160;
   static int anInt3161;
   protected int anInt3162 = 0;
   protected int anInt3163;
   protected int anInt3164;
   private boolean aBoolean3165 = false;
   protected int anInt3166;
   private int anInt3167;

   static final int method3086(int i, int i_0_, byte b) {
      ++anInt3159;
      int i_1_ = i >>> 24;
      i = (-16711936 & (16711935 & i) * i_1_ | 0xFF0000 & (i & 0xFF00) * i_1_) >>> 8;
      if (b != -56) {
         method3086(30, -58, (byte)18);
      }

      int i_2_ = -i_1_ + 255;
      return i + ((0xFF0000 & i_2_ * (i_0_ & 0xFF00) | i_2_ * (i_0_ & 16711935) & -16711936) >>> 8);
   }

   private final void method3087(Buffer buffer, int i, int i_3_) {
      if (i_3_ != 1) {
         if (~i_3_ == -3) {
            buffer.readUnsignedByte();
         } else if (~i_3_ == -4) {
            this.anInt3157 = buffer.readInt();
            this.anInt3166 = buffer.readInt();
            this.anInt3150 = buffer.readInt();
         } else if (~i_3_ != -5) {
            if (i_3_ == 6) {
               this.anInt3160 = buffer.readUnsignedByte();
            } else if (~i_3_ != -9) {
               if (~i_3_ != -10) {
                  if (i_3_ == 10) {
                     this.aBoolean3165 = true;
                  }
               } else {
                  this.anInt3162 = 1;
               }
            } else {
               this.anInt3155 = 1;
            }
         } else {
            this.anInt3163 = buffer.readUnsignedByte();
            this.anInt3148 = buffer.readInt();
         }
      } else {
         this.anInt3167 = buffer.readUnsignedShort();
      }

      ++anInt3153;
      if (i != 2) {
         this.anInt3152 = 73;
      }
   }

   public static void method3088(byte b) {
      if (b < 92) {
         method3086(99, -54, (byte)56);
      }

      cachedAppearences = null;
      anIntArray3151 = null;
   }

   final void method3089(byte b) {
      ++anInt3161;
      this.anInt3152 = Class335.anIntArray4165[this.anInt3167 << 3];
      long l = (long)this.anInt3157;
      long l_4_ = (long)this.anInt3166;
      long l_5_ = (long)this.anInt3150;
      if (b <= 111) {
         this.aBoolean3165 = false;
      }

      this.anInt3164 = (int)Math.sqrt((double)(l * l - (-(l_4_ * l_4_) + -(l_5_ * l_5_))));
      if (this.anInt3148 == 0) {
         this.anInt3148 = 1;
      }

      if (this.anInt3163 == 0) {
         this.aLong3156 = 2147483647L;
      } else if (~this.anInt3163 != -2) {
         if (~this.anInt3163 == -3) {
            this.aLong3156 = (long)(8 * this.anInt3164 / this.anInt3148);
         }
      } else {
         this.aLong3156 = (long)(this.anInt3164 * 8 / this.anInt3148);
         this.aLong3156 *= this.aLong3156;
      }

      if (this.aBoolean3165) {
         this.anInt3164 *= -1;
      }
   }

   final void method3090(byte b, Buffer buffer) {
      ++anInt3149;
      if (b > -16) {
         method3086(58, -104, (byte)30);
      }

      while(true) {
         int i = buffer.readUnsignedByte();
         if (~i == -1) {
            return;
         }

         this.method3087(buffer, 2, i);
      }
   }
}
