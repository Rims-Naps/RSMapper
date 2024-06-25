public class Class13 {
   static int anInt200;
   static int anInt201;
   private Index aClass302_202;
   static IncommingPacket aClass192_203 = new IncommingPacket(106, 8);
   static int anInt204;
   static int anInt205;
   static int anInt206;
   private Class61 aClass61_207 = new Class61(64);
   static int anInt208;
   static String[][] aStringArrayArray209 = new String[][]{
      {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"},
      {"Jan", "Feb", "Mär", "Apr", "Mai", "Jun", "Jul", "Aug", "Sep", "Okt", "Nov", "Dez"},
      {"jan", "fév", "mars", "avr", "mai", "juin", "juil", "août", "sept", "oct", "nov", "déc"},
      {"jan", "fev", "mar", "abr", "mai", "jun", "jul", "ago", "set", "out", "nov", "dez"},
      {"jan", "feb", "mrt", "apr", "mei", "jun", "jul", "aug", "sep", "okt", "nov", "dec"}
   };
   static int anInt210;
   static int anInt211;

   static final boolean method206(char c, int i) {
      if (i <= 3) {
         method208(21, 86, -113);
      }

      ++anInt200;
      return ~c == -161 || ~c == -33 || c == '_' || ~c == -46;
   }

   final Class314 method207(int i, int i_0_) {
      ++anInt206;
      Class314 class314;
      synchronized(this.aClass61_207) {
         class314 = (Class314)this.aClass61_207.method607((long)i, i_0_);
      }

      if (class314 != null) {
         return class314;
      } else {
         byte[] bs;
         synchronized(this.aClass302_202) {
            bs = this.aClass302_202.getFile(false, i, 54);
         }

         class314 = new Class314();
         if (bs != null) {
            class314.method3654(new Buffer(bs), -1050722685);
         }

         synchronized(this.aClass61_207) {
            this.aClass61_207.method601(class314, 25566, (long)i);
            return class314;
         }
      }
   }

   static final boolean method208(int i, int i_1_, int i_2_) {
      if (i_2_ != 0) {
         return false;
      } else {
         ++anInt211;
         return Class179.method1816(i_1_, i_2_ + -1, i) | (458752 & i_1_) != 0 || OutgoingPacket.method3669(i_1_, (byte)120, i);
      }
   }

   static final void method209(boolean bool, int i, int i_3_, int i_4_, int i_5_) {
      ++anInt204;
      if (CacheNode_Sub15.loadInterface(7015, i)) {
         Class320_Sub9.method3716(true, i_5_, bool, i_4_, Class134_Sub3.aWidgetArrayArray9035[i], -1);
         if (i_3_ > -28) {
            aClass192_203 = null;
         }
      }
   }

   final void method210(int i) {
      ++anInt210;
      synchronized(this.aClass61_207) {
         this.aClass61_207.method602((byte)-118);
      }

      int i_6_ = -25 % ((-39 - i) / 43);
   }

   final void method211(int i, byte b) {
      if (b == 94) {
         ++anInt208;
         synchronized(this.aClass61_207) {
            this.aClass61_207.method598(i, -11819);
         }
      }
   }

   public static void method212(byte b) {
      if (b <= -11) {
         aStringArrayArray209 = null;
         aClass192_203 = null;
      }
   }

   final void method213(byte b) {
      ++anInt201;
      synchronized(this.aClass61_207) {
         if (b == -72) {
            this.aClass61_207.method608(false);
         }
      }
   }

   Class13(Class353 class353, int i, Index class302) {
      this.aClass302_202 = class302;
      if (this.aClass302_202 != null) {
         this.aClass302_202.method3537(-2, 54);
      }
   }
}
