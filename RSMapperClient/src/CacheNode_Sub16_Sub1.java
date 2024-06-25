public class CacheNode_Sub16_Sub1 extends CacheNode_Sub16 {
   static int anInt11068;
   protected byte aByte11069;
   protected int position;
   static int anInt11071;
   protected Buffer aBuffer11072;
   static IncommingPacket aClass192_11073 = new IncommingPacket(61, 20);
   static int anInt11074;
   static int anInt11075;
   static Class124 aClass124_11076 = new Class124(0);

   static final void method2387(byte b) {
      if (b != -114) {
         aClass124_11076 = null;
      }

      if (AnimableAnimator.aClass42_5498 != null) {
         AnimableAnimator.aClass42_5498.method453((byte)-112);
      }

      ++anInt11074;
      if (Packet.aClass42_9402 != null) {
         Packet.aClass42_9402.method453((byte)-115);
      }
   }

   @Override
   final byte[] method2385(int i) {
      ++anInt11071;
      if (!this.aBoolean9602 && ~(this.aBuffer11072.buffer.length - this.aByte11069) >= ~this.aBuffer11072.offset) {
         if (i != 15) {
            this.aBuffer11072 = null;
         }

         return this.aBuffer11072.buffer;
      } else {
         throw new RuntimeException();
      }
   }

   public static void method2388(boolean bool) {
      if (bool) {
         method2387((byte)-7);
      }

      aClass192_11073 = null;
      aClass124_11076 = null;
   }

   @Override
   final int method2386(byte b) {
      ++anInt11068;
      if (b != -40) {
         this.aByte11069 = 49;
      }

      return this.aBuffer11072 == null ? 0 : this.aBuffer11072.offset * 100 / (-this.aByte11069 + this.aBuffer11072.buffer.length);
   }

   static final Class377_Sub1 method2389(int i) {
      ++anInt11075;
      if (~Node_Sub5.anInt7029 > ~Class180.aClass377_Sub1Array2143.length) {
         return Class180.aClass377_Sub1Array2143[Node_Sub5.anInt7029++];
      } else {
         if (i != 61) {
            method2388(true);
         }

         return null;
      }
   }

   CacheNode_Sub16_Sub1() {
   }
}
