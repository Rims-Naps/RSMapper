class Class150_Sub3 extends Class150 {
   static int anInt8963 = -1;
   protected int anInt8964;
   protected int anInt8965;
   static int anInt8966;
   static float[][] aFloatArrayArray8967 = new float[][]{
      {-0.333333F, -0.333333F, -0.333333F},
      {0.333333F, -0.333333F, -0.333333F},
      {-0.333333F, 0.333333F, -0.333333F},
      {0.333333F, 0.333333F, -0.333333F},
      {-0.333333F, -0.333333F, 0.333333F},
      {0.333333F, -0.333333F, 0.333333F},
      {-0.333333F, 0.333333F, 0.333333F},
      {0.333333F, 0.333333F, 0.333333F}
   };
   protected int anInt8968;
   static int anInt8969;
   static int anInt8970 = 0;
   protected int anInt8971;
   protected int anInt8972;
   static GLSprite[] aGLSpriteArray8973;
   protected int anInt8974;

   @Override
   public Class170 method20(int i) {
      if (i < 81) {
         return null;
      } else {
         ++anInt8969;
         return Class336_Sub3.aClass170_8613;
      }
   }

   Class150_Sub3(
      Class379 class379,
      Class77 class77,
      int i,
      int i_0_,
      int i_1_,
      int i_2_,
      int i_3_,
      int i_4_,
      int i_5_,
      int i_6_,
      int i_7_,
      int i_8_,
      int i_9_,
      int i_10_,
      int i_11_
   ) {
      super(class379, class77, i, i_0_, i_1_, i_2_, i_3_, i_4_, i_5_);
      this.anInt8964 = i_11_;
      this.anInt8971 = i_6_;
      this.anInt8972 = i_8_;
      this.anInt8974 = i_7_;
      this.anInt8968 = i_9_;
      this.anInt8965 = i_10_;
   }

   public static void method1662(int i) {
      aFloatArrayArray8967 = null;
      if (i != -1) {
         anInt8963 = 87;
      }

      aGLSpriteArray8973 = null;
   }

   static final boolean method1663(byte b, int i, int i_12_) {
      int i_13_ = 99 / ((b - 51) / 38);
      ++anInt8966;
      return (32768 & i) != 0;
   }
}
