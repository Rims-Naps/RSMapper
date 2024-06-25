public class Class363 {
   protected int[] anIntArray4501;
   static float aFloat4502;
   static int anInt4503;
   protected int anInt4504 = -1;
   static int[] anIntArray4505 = new int[256];
   protected int anInt4506 = -1;
   protected int[] anIntArray4507;
   protected int[] anIntArray4508;
   static double aDouble4509;
   static int anInt4510;

   static {
      for(int i = 0; i < 256; ++i) {
         int i_5_ = i;

         for(int i_6_ = 0; i_6_ < 8; ++i_6_) {
            if ((i_5_ & 1) == 1) {
               i_5_ = -306674912 ^ i_5_ >>> 1;
            } else {
               i_5_ >>>= 1;
            }
         }

         anIntArray4505[i] = i_5_;
      }
   }

   static final void method4054(int i) {
      ++anInt4503;
      if (i != -21619) {
         method4056(true);
      }

      Class229.aGraphicsToolkit2732.a(Animable.aFloat5932, Class69.aFloat944, Class39.aFloat580);
   }

   private final void method4055(int i, Buffer buffer) {
      if (i < 22) {
         method4054(87);
      }

      while(true) {
         int i_0_ = buffer.readUnsignedByte();
         if (i_0_ == 0) {
            ++anInt4510;
            return;
         }

         if (i_0_ == 1) {
            int i_1_ = buffer.readUnsignedByte();
            this.anIntArray4508 = new int[i_1_];

            for(int i_2_ = 0; this.anIntArray4508.length > i_2_; ++i_2_) {
               this.anIntArray4508[i_2_] = buffer.readUnsignedByte();
            }
         } else if (~i_0_ == -4) {
            this.anInt4506 = buffer.readUnsignedByte();
         } else if (~i_0_ != -5) {
            if (i_0_ != 5) {
               if (i_0_ == 6) {
                  this.anIntArray4507 = new int[buffer.readUnsignedByte()];

                  for(int i_3_ = 0; this.anIntArray4507.length > i_3_; ++i_3_) {
                     this.anIntArray4507[i_3_] = buffer.readUnsignedByte();
                  }
               }
            } else {
               this.anIntArray4501 = new int[buffer.readUnsignedByte()];

               for(int i_4_ = 0; this.anIntArray4501.length > i_4_; ++i_4_) {
                  this.anIntArray4501[i_4_] = buffer.readUnsignedByte();
               }
            }
         } else {
            this.anInt4504 = buffer.readUnsignedByte();
         }
      }
   }

   public static void method4056(boolean bool) {
      if (!bool) {
         anIntArray4505 = null;
      }

      anIntArray4505 = null;
   }

   Class363(Index class302) {
      byte[] bs = class302.method3518((byte)57, 6);
      this.method4055(99, new Buffer(bs));
      if (this.anIntArray4508 == null) {
         throw new RuntimeException("");
      }
   }

   protected Class363() {
      this.anIntArray4508 = new int[0];
   }
}
