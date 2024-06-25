public class Class65 {
   private Class227[] aClass227Array925 = new Class227[10];
   private int anInt926;
   private int anInt927;

   static final Class65 method714(Index class302, int i, int i_0_) {
      byte[] bs = class302.getFile(false, i_0_, i);
      return bs == null ? null : new Class65(new Buffer(bs));
   }

   private final byte[] method715() {
      int i = 0;

      for(int i_1_ = 0; i_1_ < 10; ++i_1_) {
         if (this.aClass227Array925[i_1_] != null && this.aClass227Array925[i_1_].anInt2698 + this.aClass227Array925[i_1_].anInt2707 > i) {
            i = this.aClass227Array925[i_1_].anInt2698 + this.aClass227Array925[i_1_].anInt2707;
         }
      }

      if (i == 0) {
         return new byte[0];
      } else {
         int i_2_ = 22050 * i / 1000;
         byte[] bs = new byte[i_2_];

         for(int i_3_ = 0; i_3_ < 10; ++i_3_) {
            if (this.aClass227Array925[i_3_] != null) {
               int i_4_ = this.aClass227Array925[i_3_].anInt2698 * 22050 / 1000;
               int i_5_ = this.aClass227Array925[i_3_].anInt2707 * 22050 / 1000;
               int[] is = this.aClass227Array925[i_3_].method2117(i_4_, this.aClass227Array925[i_3_].anInt2698);

               for(int i_6_ = 0; i_6_ < i_4_; ++i_6_) {
                  int i_7_ = bs[i_6_ + i_5_] + (is[i_6_] >> 8);
                  if ((i_7_ + 128 & -256) != 0) {
                     i_7_ = i_7_ >> 31 ^ 127;
                  }

                  bs[i_6_ + i_5_] = (byte)i_7_;
               }
            }
         }

         return bs;
      }
   }

   final Node_Sub45_Sub1 method716() {
      byte[] bs = this.method715();
      return new Node_Sub45_Sub1(22050, bs, 22050 * this.anInt926 / 1000, 22050 * this.anInt927 / 1000);
   }

   final int method717() {
      int i = 9999999;

      for(int i_8_ = 0; i_8_ < 10; ++i_8_) {
         if (this.aClass227Array925[i_8_] != null && this.aClass227Array925[i_8_].anInt2707 / 20 < i) {
            i = this.aClass227Array925[i_8_].anInt2707 / 20;
         }
      }

      if (this.anInt926 < this.anInt927 && this.anInt926 / 20 < i) {
         i = this.anInt926 / 20;
      }

      if (i != 9999999 && i != 0) {
         for(int i_9_ = 0; i_9_ < 10; ++i_9_) {
            if (this.aClass227Array925[i_9_] != null) {
               this.aClass227Array925[i_9_].anInt2707 -= i * 20;
            }
         }

         if (this.anInt926 < this.anInt927) {
            this.anInt926 -= i * 20;
            this.anInt927 -= i * 20;
         }

         return i;
      } else {
         return 0;
      }
   }

   private Class65(Buffer buffer) {
      for(int i = 0; i < 10; ++i) {
         int i_10_ = buffer.readUnsignedByte();
         if (i_10_ != 0) {
            --buffer.offset;
            this.aClass227Array925[i] = new Class227();
            this.aClass227Array925[i].method2116(buffer);
         }
      }

      this.anInt926 = buffer.readUnsignedShort();
      this.anInt927 = buffer.readUnsignedShort();
   }

   private Class65() {
   }
}
