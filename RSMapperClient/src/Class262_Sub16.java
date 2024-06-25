public class Class262_Sub16 extends Class262 {
   private int anInt7822;
   static int anInt7823;
   static Class346 aClass346_7824 = new Class346();
   private int anInt7825;
   static int anInt7826;
   static int anInt7827;
   private int anInt7828;
   private int anInt7829;
   static boolean aBoolean7830;
   private int anInt7831;

   static final boolean method3193(int i, int i_0_, byte b) {
      ++anInt7826;
      int i_1_ = 15 % ((b - 14) / 36);
      return (16 & i_0_) != 0;
   }

   public static void method3194(byte b) {
      if (b == 82) {
         aClass346_7824 = null;
      }
   }

   static final void method3195(int i) {
      Class364.anInt4514 = i;
   }

   static final void method3196(int i, byte[] bs, int i_2_, byte b, int i_3_, int i_4_) {
      ++anInt7823;
      if (i_4_ < i) {
         i_2_ += i_4_;
         i_3_ = i - i_4_ >> 2;
         if (b != -24) {
            method3193(-8, -82, (byte)-41);
         }

         while(~(--i_3_) <= -1) {
            bs[i_2_++] = 1;
            bs[i_2_++] = 1;
            bs[i_2_++] = 1;
            bs[i_2_++] = 1;
         }

         i_3_ = 3 & i + -i_4_;

         while(~(--i_3_) <= -1) {
            bs[i_2_++] = 1;
         }
      }
   }

   Class262_Sub16(Buffer buffer) {
      super(buffer);
      this.anInt7822 = buffer.readUnsignedShort();
      int i = buffer.readInt();
      this.anInt7825 = 65535 & i;
      this.anInt7828 = i >>> 16;
      this.anInt7831 = buffer.readUnsignedByte();
      this.anInt7829 = buffer.readUnsignedByte();
   }

   @Override
   final void method3148(int i) {
      ++anInt7827;
      if (i >= -102) {
         this.anInt7828 = -73;
      }

      Node_Sub39.aClass369Array7497[this.anInt7822].method4087(this.anInt7828, this.anInt7829, (byte)46, this.anInt7825, this.anInt7831);
   }
}
