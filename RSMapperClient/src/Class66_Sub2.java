class Class66_Sub2 extends Class66 {
   static int anInt8989;
   private GLSprite aGLSprite8990;
   static int anInt8991;
   private GLSprite aGLSprite8992;
   private GLSprite aGLSprite8993;
   static int anInt8994;
   static int anInt8995;
   private GLSprite aGLSprite8996;
   static long[] aLongArray8997 = new long[32];
   private GLSprite aGLSprite8998;
   protected GLSprite aGLSprite8999;
   static int anInt9000;

   @Override
   final void method719(boolean bool, int i, byte b, int i_0_) {
      ++anInt8991;
      if (bool) {
         int[] is = new int[4];
         Class93.aGraphicsToolkit1241.K(is);
         Class93.aGraphicsToolkit1241.KA(i, i_0_, i - -this.aClass150_5171.anInt5086, this.aClass150_5171.anInt5081 + i_0_);
         int i_1_ = this.aGLSprite8992.method1197();
         int i_2_ = this.aGLSprite8992.method1186();
         int i_3_ = this.aGLSprite8990.method1197();
         int i_4_ = this.aGLSprite8990.method1186();
         this.aGLSprite8992.method1196(i, (this.aClass150_5171.anInt5081 - i_2_) / 2 + i_0_);
         this.aGLSprite8990.method1196(-i_3_ + this.aClass150_5171.anInt5086 + i, (-i_4_ + this.aClass150_5171.anInt5081) / 2 + i_0_);
         Class93.aGraphicsToolkit1241.KA(i, i_0_, this.aClass150_5171.anInt5086 + i, this.aGLSprite8993.method1186() + i_0_);
         this.aGLSprite8993.method1192(i_1_ + i, i_0_, -i_3_ + this.aClass150_5171.anInt5086 - i_1_, this.aClass150_5171.anInt5081);
         int i_5_ = this.aGLSprite8996.method1186();
         Class93.aGraphicsToolkit1241
            .KA(i, this.aClass150_5171.anInt5081 + i_0_ + -i_5_, i + this.aClass150_5171.anInt5086, i_0_ - -this.aClass150_5171.anInt5081);
         this.aGLSprite8996
            .method1192(i_1_ + i, this.aClass150_5171.anInt5081 + i_0_ + -i_5_, this.aClass150_5171.anInt5086 + -i_1_ - i_3_, this.aClass150_5171.anInt5081);
         Class93.aGraphicsToolkit1241.KA(is[0], is[1], is[2], is[3]);
      }

      if (b != -16) {
         this.method26(-123);
      }
   }

   Class66_Sub2(Index class302, Index class302_6_, Class150_Sub3 class150_sub3) {
      super(class302, class302_6_, class150_sub3);
   }

   @Override
   final void method721(int i, int i_7_, boolean bool, int i_8_) {
      ++anInt8995;
      int i_9_ = i + this.aGLSprite8992.method1197();
      int i_10_ = 69 / ((i_7_ - -10) / 40);
      int i_11_ = i + this.aClass150_5171.anInt5086 - this.aGLSprite8990.method1197();
      int i_12_ = this.aGLSprite8993.method1186() + i_8_;
      int i_13_ = i_8_ - -this.aClass150_5171.anInt5081 + -this.aGLSprite8996.method1186();
      int i_14_ = -i_9_ + i_11_;
      int i_15_ = i_13_ + -i_12_;
      int i_16_ = this.method720(100) * i_14_ / 10000;
      int[] is = new int[4];
      Class93.aGraphicsToolkit1241.K(is);
      Class93.aGraphicsToolkit1241.KA(i_9_, i_12_, i_16_ + i_9_, i_13_);
      this.method726(i_12_, i_9_, 4, i_14_, i_15_);
      Class93.aGraphicsToolkit1241.KA(i_16_ + i_9_, i_12_, i_11_, i_13_);
      this.aGLSprite8998.method1192(i_9_, i_12_, i_14_, i_15_);
      Class93.aGraphicsToolkit1241.KA(is[0], is[1], is[2], is[3]);
   }

   public static void method725(int i) {
      if (i != 3) {
         method725(25);
      }

      aLongArray8997 = null;
   }

   void method726(int i, int i_17_, int i_18_, int i_19_, int i_20_) {
      this.aGLSprite8999.method1192(i_17_, i, i_19_, i_20_);
      ++anInt8994;
      if (i_18_ != 4) {
         this.method25(-108);
      }
   }

   @Override
   public final void method26(int i) {
      ++anInt9000;
      super.method26(i);
      Class150_Sub3 class150_sub3 = (Class150_Sub3)this.aClass150_5171;
      this.aGLSprite8999 = Node_Sub9_Sub4.method2523((byte)102, class150_sub3.anInt8971, this.aClass302_5168);
      this.aGLSprite8998 = Node_Sub9_Sub4.method2523((byte)90, class150_sub3.anInt8974, this.aClass302_5168);
      this.aGLSprite8992 = Node_Sub9_Sub4.method2523((byte)127, class150_sub3.anInt8972, this.aClass302_5168);
      this.aGLSprite8990 = Node_Sub9_Sub4.method2523((byte)107, class150_sub3.anInt8968, this.aClass302_5168);
      this.aGLSprite8993 = Node_Sub9_Sub4.method2523((byte)126, class150_sub3.anInt8965, this.aClass302_5168);
      this.aGLSprite8996 = Node_Sub9_Sub4.method2523((byte)106, class150_sub3.anInt8964, this.aClass302_5168);
   }

   @Override
   public final boolean method25(int i) {
      ++anInt8989;
      if (!super.method25(i)) {
         return false;
      } else {
         Class150_Sub3 class150_sub3 = (Class150_Sub3)this.aClass150_5171;
         if (!this.aClass302_5168.method3510(class150_sub3.anInt8971, (byte)63)) {
            return false;
         } else if (!this.aClass302_5168.method3510(class150_sub3.anInt8974, (byte)63)) {
            return false;
         } else if (!this.aClass302_5168.method3510(class150_sub3.anInt8972, (byte)63)) {
            return false;
         } else if (!this.aClass302_5168.method3510(class150_sub3.anInt8968, (byte)63)) {
            return false;
         } else if (!this.aClass302_5168.method3510(class150_sub3.anInt8965, (byte)63)) {
            return false;
         } else {
            return this.aClass302_5168.method3510(class150_sub3.anInt8964, (byte)63);
         }
      }
   }
}
