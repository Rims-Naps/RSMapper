public class Node_Sub51 extends Node {
   static Class61 aClass61_7628 = new Class61(4);
   static int anInt7629;
   static OutgoingPacket aClass318_7630 = new OutgoingPacket(51, -1);
   protected byte[] aByteArray7631;
   static int anInt7632;
   static int anInt7633 = -1;

   public static void method2967(int i) {
      if (i != -4) {
         aClass61_7628 = null;
      }

      aClass61_7628 = null;
      aClass318_7630 = null;
   }

   static final void method2968(int i, int i_0_) {
      Class262_Sub4.anInt7730 = i_0_;
      Class150_Sub3.anInt8963 = -1;
      Class94.anInt1250 = i;
      ++anInt7629;
      Class207.method2039(105);
   }

   static final int method2969(Class377_Sub1 class377_sub1, boolean bool, Class377_Sub1 class377_sub1_1_, int i, int i_2_) {
      ++anInt7632;
      if (~i == -2) {
         int i_3_ = class377_sub1_1_.anInt4671;
         int i_4_ = class377_sub1.anInt4671;
         if (!bool) {
            if (i_3_ == -1) {
               i_3_ = 2001;
            }

            if (~i_4_ == 0) {
               i_4_ = 2001;
            }
         }

         return -i_4_ + i_3_;
      } else if (i == 2) {
         return r.method2359(class377_sub1.method4131((byte)-97).aString678, (byte)-4, Class35.language, class377_sub1_1_.method4131((byte)-97).aString678);
      } else if (~i == -4) {
         if (class377_sub1_1_.aString8780.equals("-")) {
            if (class377_sub1.aString8780.equals("-")) {
               return 0;
            } else {
               return bool ? -1 : 1;
            }
         } else if (class377_sub1.aString8780.equals("-")) {
            return bool ? 1 : -1;
         } else {
            return r.method2359(class377_sub1.aString8780, (byte)-4, Class35.language, class377_sub1_1_.aString8780);
         }
      } else if (i == 4) {
         if (class377_sub1_1_.method4126(true)) {
            return class377_sub1.method4126(true) ? 0 : 1;
         } else {
            return class377_sub1.method4126(true) ? -1 : 0;
         }
      } else if (i == 5) {
         if (class377_sub1_1_.method4120(true)) {
            return class377_sub1.method4120(true) ? 0 : 1;
         } else {
            return !class377_sub1.method4120(true) ? 0 : -1;
         }
      } else if (i_2_ != 1) {
         return 117;
      } else if (~i == -7) {
         if (class377_sub1_1_.method4122(-80)) {
            return class377_sub1.method4122(-43) ? 0 : 1;
         } else {
            return class377_sub1.method4122(-107) ? -1 : 0;
         }
      } else if (~i == -8) {
         if (class377_sub1_1_.method4123(i_2_ ^ 27646)) {
            return class377_sub1.method4123(i_2_ ^ 27646) ? 0 : 1;
         } else {
            return !class377_sub1.method4123(27647) ? 0 : -1;
         }
      } else if (~i == -9) {
         int i_5_ = class377_sub1_1_.anInt8779;
         int i_6_ = class377_sub1.anInt8779;
         if (!bool) {
            if (i_5_ == -1) {
               i_5_ = 1000;
            }

            if (i_6_ == -1) {
               i_6_ = 1000;
            }
         } else {
            if (i_5_ == 1000) {
               i_5_ = -1;
            }

            if (i_6_ == 1000) {
               i_6_ = -1;
            }
         }

         return i_5_ - i_6_;
      } else {
         return -class377_sub1.anInt8777 + class377_sub1_1_.anInt8777;
      }
   }

   Node_Sub51(byte[] bs) {
      this.aByteArray7631 = bs;
   }
}
