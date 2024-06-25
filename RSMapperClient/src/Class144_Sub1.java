public class Class144_Sub1 extends Class144 {
   private int anInt6801;
   static Class232 aClass232_6802;
   static int anInt6803;
   static short aShort6804 = 256;
   private int anInt6805;
   static int anInt6806 = -1;
   private int anInt6807;
   static float aFloat6808 = 1.0F;
   static int anInt6809;
   private int anInt6810;
   static int anInt6811;

   Class144_Sub1(int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, int i_5_) {
      super(i_3_, i_4_, i_5_);
      this.anInt6805 = i_0_;
      this.anInt6807 = i;
      this.anInt6810 = i_1_;
      this.anInt6801 = i_2_;
   }

   @Override
   final void method1629(int i, int i_6_, int i_7_) {
      ++anInt6803;
      int i_8_ = i_7_ * this.anInt6807 >> 12;
      int i_9_ = this.anInt6810 * i_7_ >> 12;
      if (i_6_ == -12850) {
         int i_10_ = i * this.anInt6805 >> 12;
         int i_11_ = this.anInt6801 * i >> 12;
         Class97.method1080(i_11_, (byte)107, this.anInt1787, this.anInt1788, i_9_, i_10_, i_8_);
      }
   }

   @Override
   final void method1630(int i, int i_12_, int i_13_) {
      ++anInt6809;
      if (i_12_ == -1) {
         int i_14_ = this.anInt6807 * i_13_ >> 12;
         int i_15_ = i_13_ * this.anInt6810 >> 12;
         int i_16_ = i * this.anInt6805 >> 12;
         int i_17_ = i * this.anInt6801 >> 12;
         Node.method2162(this.anInt1785, i_15_, this.anInt1787, i_12_ + 32022, i_16_, i_17_, i_14_, this.anInt1788);
      }
   }

   public static void method1632(int i) {
      if (i != 256) {
         anInt6806 = 37;
      }

      aClass232_6802 = null;
   }

   @Override
   final void method1626(int i, int i_18_, int i_19_) {
      ++anInt6811;
      int i_20_ = this.anInt6807 * i >> 12;
      if (i_19_ == 3) {
         int i_21_ = i * this.anInt6810 >> 12;
         int i_22_ = this.anInt6805 * i_18_ >> 12;
         int i_23_ = i_18_ * this.anInt6801 >> 12;
         Class331.method3842(i_21_, i_20_, this.anInt1785, i_23_, i_22_, (byte)-54);
      }
   }
}
