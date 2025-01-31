public class Packet extends Buffer {
   static int anInt9386 = 0;
   static int anInt9387;
   static int anInt9388;
   static int anInt9389;
   static int anInt9390;
   static int anInt9391;
   static int anInt9392;
   static int anInt9393;
   static Class299 aClass299_9394;
   static int anInt9395;
   static int anInt9396;
   static int anInt9397;
   static int anInt9398;
   private int bitPosition;
   static int anInt9401;
   static Class42 aClass42_9402;

   public static void method2254(byte b) {
      aClass299_9394 = null;
      if (b > -27) {
         method2254((byte)-73);
      }

      aClass42_9402 = null;
   }

   final void finishBitAccess() {
      this.offset = (7 + this.bitPosition) / 8;
   }

   final int readBits(int numBits) {
      int i_0_ = this.bitPosition >> 3;
      int i_1_ = 8 + -(this.bitPosition & 7);
      int i_2_ = 0;

      for(this.bitPosition += numBits; i_1_ < numBits; i_1_ = 8) {
         i_2_ += (CacheNode_Sub17.BIT_FLAGS[i_1_] & this.buffer[i_0_++]) << -i_1_ + numBits;
         numBits -= i_1_;
      }

      if (numBits != i_1_) {
         i_2_ += this.buffer[i_0_] >> i_1_ + -numBits & CacheNode_Sub17.BIT_FLAGS[numBits];
      } else {
         i_2_ += this.buffer[i_0_] & CacheNode_Sub17.BIT_FLAGS[i_1_];
      }

      return i_2_;
   }

   Packet(int i) {
      super(i);
   }

   final boolean method2257(boolean bool) {
      if (!bool) {
         return false;
      } else {
         ++anInt9390;
         int i = 255 & this.buffer[this.offset];
         return ~i <= -129;
      }
   }

   static final void method2258(boolean bool, int i) {
      ++anInt9395;
      synchronized(Node_Sub36_Sub4.aClass61_10065) {
         Node_Sub36_Sub4.aClass61_10065.method598(i, -11819);
      }

      synchronized(CacheNode_Sub3.aClass61_9446) {
         CacheNode_Sub3.aClass61_9446.method598(i, -11819);
         if (bool) {
            method2263(56);
         }
      }
   }

   final void method2259(int[] is, byte b) {
      new IsaacCipher(is);
      if (b != -20) {
         aClass42_9402 = null;
      }

      ++anInt9401;
   }

   final void method2260(byte[] bs, int i, int i_4_, boolean bool) {
      ++anInt9391;

      for(int i_5_ = 0; ~i_5_ > ~i; ++i_5_) {
         bs[i_5_ + i_4_] = this.buffer[this.offset++];
      }
   }

   final void initBitAccess() {
      this.bitPosition = 8 * this.offset;
   }

   final void method2262(int i_6_) {
      ++anInt9396;
      this.buffer[this.offset++] = (byte)i_6_;
   }

   final void method2262(int i, int i_6_) {
      ++anInt9396;
      if (i == 1) {
         this.buffer[this.offset++] = (byte)i_6_;
      }
   }

   static final Class257[] method2263(int i) {
      if (i != 31303) {
         method2263(-5);
      }

      ++anInt9387;
      return new Class257[]{
         Node_Sub15_Sub9.aClass257_9838,
         Node_Sub37.aClass257_7443,
         Node_Sub38_Sub17.aClass257_10270,
         Class225.aClass257_2674,
         Node_Sub38_Sub15.aClass257_10262,
         Class169_Sub2.aClass257_8804,
         Actor.aClass257_10823,
         Class66_Sub1.aClass257_8984,
         Class189_Sub1.aClass257_6882,
         Class262_Sub13.aClass257_7801,
         CacheNode_Sub1.aClass257_9421,
         Client.aClass257_5467,
         Class262_Sub23.aClass257_7883,
         Class46.aClass257_674,
         Class12.aClass257_198
      };
   }

   final int method2264(int i, int i_7_) {
      ++anInt9392;
      if (i_7_ >= -4) {
         method2254((byte)-75);
      }

      return 8 * i - this.bitPosition;
   }

   final int readPacket() {
      int i_8_ = 255 & this.buffer[this.offset++];
      return i_8_ < 128 ? i_8_ : 0xFF & this.buffer[this.offset++];
   }

   final void method2266(IsaacCipher isaaccipher, int i) {
      ++anInt9393;
      if (i >= -44) {
         aClass299_9394 = null;
      }
   }
}
