import java.util.Date;

public class Class187 {
   private int anInt2263;
   private int anInt2264;
   static IncommingPacket aClass192_2265 = new IncommingPacket(2, 6);
   private boolean aBoolean2266;
   static int anInt2267;
   static int anInt2268;
   private boolean aBoolean2269;
   static int anInt2270;
   static int anInt2271;
   static int anInt2272;
   static int anInt2273;
   static int anInt2274;
   static long aLong2275 = 1L;
   static int anInt2276 = -1;
   static OutgoingPacket aClass318_2277 = new OutgoingPacket(23, 1);

   static final void method1876(int i, long l) {
      if (i == -1) {
         ++anInt2272;
         Class141.LAUNCH_DATE.setTime(new Date(l));
      }
   }

   final int method1877(byte b) {
      if (b != 71) {
         return 27;
      } else {
         ++anInt2271;
         return this.anInt2264;
      }
   }

   final boolean method1878(byte b) {
      if (b != 60) {
         return false;
      } else {
         ++anInt2268;
         return this.aBoolean2266;
      }
   }

   static final int method1879(int i) {
      int i_0_ = -1;

      for(int i_1_ = 0; i_1_ < Class290.anInt3655 - 1; ++i_1_) {
         if (i < Node_Sub38_Sub25.anIntArray10358[i_1_] + Class270_Sub2.anIntArray8039[i_1_]) {
            i_0_ = i_1_;
            break;
         }
      }

      if (i_0_ == -1) {
         i_0_ = Class290.anInt3655 - 1;
      }

      return i_0_;
   }

   public static void method1880(byte b) {
      aClass192_2265 = null;
      if (b > -126) {
         method1882(-3, -66);
      }

      aClass318_2277 = null;
   }

   final int method1881(byte b) {
      if (b != 25) {
         return 8;
      } else {
         ++anInt2273;
         return this.anInt2263;
      }
   }

   Class187(boolean bool, int i, int i_2_, boolean bool_3_) {
      this.aBoolean2269 = bool;
      this.anInt2263 = i_2_;
      this.aBoolean2266 = bool_3_;
      this.anInt2264 = i;
   }

   static final boolean method1882(int i, int i_4_) {
      if (i > 0) {
         return true;
      } else {
         ++anInt2274;
         return i_4_ == 2 || i_4_ == 3;
      }
   }

   final boolean method1883(int i) {
      ++anInt2270;
      if (i <= 26) {
         this.aBoolean2266 = false;
      }

      return this.aBoolean2269;
   }
}
