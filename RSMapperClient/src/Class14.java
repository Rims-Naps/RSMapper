public class Class14 {
   protected int anInt212;
   protected int anInt213;
   static int anInt214;
   static int anInt215;
   protected int anInt216 = 128;
   protected int anInt217;
   protected int anInt218 = 128;
   static Index index17;
   protected int anInt220;

   final Class14 method214(byte b) {
      ++anInt215;
      if (b >= -108) {
         method216(100);
      }

      return new Class14(this.anInt220, this.anInt218, this.anInt216, this.anInt212, this.anInt213, this.anInt217);
   }

   final void method215(boolean bool, Class14 class14_0_) {
      this.anInt213 = class14_0_.anInt213;
      this.anInt220 = class14_0_.anInt220;
      ++anInt214;
      this.anInt217 = class14_0_.anInt217;
      this.anInt218 = class14_0_.anInt218;
      if (!bool) {
         index17 = null;
      }

      this.anInt216 = class14_0_.anInt216;
      this.anInt212 = class14_0_.anInt212;
   }

   public static void method216(int i) {
      index17 = null;
      if (i != 20185) {
         method216(-125);
      }
   }

   Class14(int i) {
      this.anInt220 = i;
   }

   private Class14(int i, int i_1_, int i_2_, int i_3_, int i_4_, int i_5_) {
      this.anInt212 = i_3_;
      this.anInt213 = i_4_;
      this.anInt216 = i_2_;
      this.anInt220 = i;
      this.anInt217 = i_5_;
      this.anInt218 = i_1_;
   }
}
