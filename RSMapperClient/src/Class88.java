public class Class88 implements Interface12 {
   private Index aClass302_5273;
   static String friendsChatOwner = null;
   static String aString5297 = null;
   static int anInt5275;
   static int anInt5276;
   private String aString5277;
   static int anInt5278;
   static int anInt5279;
   static GraphicsToolkit aGraphicsToolkit5280;
   static Object anObject5281;

   static final void method1016(int i) {
      Node_Sub5_Sub2.aClass49Array9413 = null;
      ++anInt5278;
      if (i != 892) {
         friendsChatOwner = null;
      }
   }

   public static void method1017(byte b) {
      anObject5281 = null;
      aGraphicsToolkit5280 = null;
      if (b >= -72) {
         method1018(-123, -27, -116, 95, -104);
      }

      friendsChatOwner = null;
   }

   @Override
   public final int method35(int i) {
      ++anInt5276;
      if (i >= -4) {
         this.method35(118);
      }

      return this.aClass302_5273.method3527(this.aString5277, 0) ? 100 : this.aClass302_5273.method3522((byte)33, this.aString5277);
   }

   @Override
   public final Class172 method34(byte b) {
      ++anInt5279;
      int i = 21 / ((15 - b) / 48);
      return Class172.aClass172_2079;
   }

   static final void method1018(int i, int i_0_, int i_1_, int i_2_, int i_3_) {
      if (i_3_ > -90) {
         anObject5281 = null;
      }

      ++anInt5275;
      int i_4_ = 0;
      int i_5_ = i_0_;
      int i_6_ = -i_0_;
      int i_7_ = -1;
      int i_8_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, i_0_ + i_2_);
      int i_9_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, -i_0_ + i_2_);
      Class369.method4086(i_8_, i_1_, i_9_, Class169_Sub4.anIntArrayArray8826[i], 0);

      while(~i_4_ > ~i_5_) {
         i_7_ += 2;
         i_6_ += i_7_;
         if (i_6_ > 0) {
            --i_5_;
            i_6_ -= i_5_ << 1;
            int i_10_ = -i_5_ + i;
            int i_11_ = i_5_ + i;
            if (~i_11_ <= ~Class384.anInt4906 && i_10_ <= Node_Sub25_Sub1.anInt9936) {
               int i_12_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, i_2_ - -i_4_);
               int i_13_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, -i_4_ + i_2_);
               if (i_11_ <= Node_Sub25_Sub1.anInt9936) {
                  Class369.method4086(i_12_, i_1_, i_13_, Class169_Sub4.anIntArrayArray8826[i_11_], 0);
               }

               if (Class384.anInt4906 <= i_10_) {
                  Class369.method4086(i_12_, i_1_, i_13_, Class169_Sub4.anIntArrayArray8826[i_10_], 0);
               }
            }
         }

         int i_14_ = -(++i_4_) + i;
         int i_15_ = i_4_ + i;
         if (~Class384.anInt4906 >= ~i_15_ && ~i_14_ >= ~Node_Sub25_Sub1.anInt9936) {
            int i_16_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, i_2_ + i_5_);
            int i_17_ = Node_Sub38_Sub32.method2894(Class262_Sub4.anInt7722, za_Sub2.anInt10513, 929798380, i_2_ + -i_5_);
            if (Node_Sub25_Sub1.anInt9936 >= i_15_) {
               Class369.method4086(i_16_, i_1_, i_17_, Class169_Sub4.anIntArrayArray8826[i_15_], 0);
            }

            if (Class384.anInt4906 <= i_14_) {
               Class369.method4086(i_16_, i_1_, i_17_, Class169_Sub4.anIntArrayArray8826[i_14_], 0);
            }
         }
      }
   }

   Class88(Index class302, String string) {
      this.aString5277 = string;
      this.aClass302_5273 = class302;
   }
}
