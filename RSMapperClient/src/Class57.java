public class Class57 {
   static int anInt842;
   private Index aClass302_843;
   static int anInt844;
   static int anInt845;
   private Class61 aClass61_846 = new Class61(16);
   static int anInt847;
   static int anInt848;
   static int anInt849 = 0;
   static Class336 aClass336_850;
   static int anInt851;

   public static void method567(int i) {
      aClass336_850 = null;
      int i_0_ = -30 % ((i - -26) / 44);
   }

   final Class7 method568(int i, int i_1_) {
      ++anInt851;
      Class7 class7;
      synchronized(this.aClass61_846) {
         class7 = (Class7)this.aClass61_846.method607((long)i_1_, 0);
      }

      if (class7 != null) {
         return class7;
      } else {
         byte[] bs;
         synchronized(this.aClass302_843) {
            bs = this.aClass302_843.getFile(false, i_1_, 30);
         }

         class7 = new Class7();
         if (bs != null) {
            class7.method182(new Buffer(bs), 16777215);
         }

         synchronized(this.aClass61_846) {
            this.aClass61_846.method601(class7, i, (long)i_1_);
            return class7;
         }
      }
   }

   final void method569(int i) {
      if (i != 24895) {
         this.aClass302_843 = null;
      }

      ++anInt844;
      synchronized(this.aClass61_846) {
         this.aClass61_846.method608(false);
      }
   }

   final void method570(byte b) {
      synchronized(this.aClass61_846) {
         this.aClass61_846.method602((byte)-124);
      }

      ++anInt845;
      if (b > -85) {
         anInt849 = 55;
      }
   }

   static final byte[] method571(String string, boolean bool) {
      ++anInt848;
      int i = string.length();
      if (bool) {
         return null;
      } else if (~i == -1) {
         return new byte[0];
      } else {
         int i_2_ = i - -3 & -4;
         int i_3_ = 3 * (i_2_ / 4);
         if (~(i_2_ + -2) <= ~i || ~Node_Sub16.method2591((byte)-115, string.charAt(i_2_ + -2)) == 0) {
            i_3_ -= 2;
         } else if (i <= i_2_ + -1 || ~Node_Sub16.method2591((byte)-115, string.charAt(-1 + i_2_)) == 0) {
            --i_3_;
         }

         byte[] bs = new byte[i_3_];
         Class111.method1138(string, bs, (byte)-83, 0);
         return bs;
      }
   }

   final void method572(int i, byte b) {
      if (b > -107) {
         anInt849 = 73;
      }

      synchronized(this.aClass61_846) {
         this.aClass61_846.method598(i, -11819);
      }

      ++anInt847;
   }

   Class57(Class353 class353, int i, Index class302) {
      this.aClass302_843 = class302;
      this.aClass302_843.method3537(-2, 30);
   }
}
