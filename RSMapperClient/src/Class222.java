public class Class222 {
   protected Node_Sub40 aNode_Sub40_2634;
   protected short[] aShortArray2635;
   protected short[] aShortArray2636;
   protected boolean aBoolean2637 = false;
   private static byte[] aByteArray2638 = new byte[500];
   private static short[] aShortArray2639 = new short[500];
   protected boolean aBoolean2640;
   protected byte[] aByteArray2641;
   protected int anInt2642;
   protected short[] aShortArray2643;
   private static short[] aShortArray2644 = new short[500];
   private static short[] aShortArray2645 = new short[500];
   protected boolean aBoolean2646;
   private static short[] aShortArray2647 = new short[500];
   protected short[] aShortArray2648;
   protected short[] aShortArray2649;
   private static short[] aShortArray2650 = new short[500];

   public static void method2101() {
      aShortArray2647 = null;
      aShortArray2645 = null;
      aShortArray2639 = null;
      aShortArray2644 = null;
      aShortArray2650 = null;
      aByteArray2638 = null;
   }

   Class222(byte[] bs, Node_Sub40 node_sub40) {
      this.aNode_Sub40_2634 = null;
      this.aBoolean2640 = false;
      this.anInt2642 = 0;
      this.aBoolean2646 = false;
      this.aNode_Sub40_2634 = node_sub40;

      try {
         Buffer buffer = new Buffer(bs);
         Buffer buffer_0_ = new Buffer(bs);
         buffer.readUnsignedByte();
         buffer.offset += 2;
         int i = buffer.readUnsignedByte();
         int i_1_ = 0;
         int i_2_ = -1;
         int i_3_ = -1;
         buffer_0_.offset = buffer.offset + i;

         for(int i_4_ = 0; i_4_ < i; ++i_4_) {
            int i_5_ = this.aNode_Sub40_2634.anIntArray7511[i_4_];
            if (i_5_ == 0) {
               i_2_ = i_4_;
            }

            int i_6_ = buffer.readUnsignedByte();
            if (i_6_ > 0) {
               if (i_5_ == 0) {
                  i_3_ = i_4_;
               }

               aShortArray2647[i_1_] = (short)i_4_;
               short s = 0;
               if (i_5_ == 3 || i_5_ == 10) {
                  s = 128;
               }

               if ((i_6_ & 1) != 0) {
                  aShortArray2645[i_1_] = (short)buffer_0_.method2197(-129);
               } else {
                  aShortArray2645[i_1_] = s;
               }

               if ((i_6_ & 2) != 0) {
                  aShortArray2639[i_1_] = (short)buffer_0_.method2197(-129);
               } else {
                  aShortArray2639[i_1_] = s;
               }

               if ((i_6_ & 4) != 0) {
                  aShortArray2644[i_1_] = (short)buffer_0_.method2197(-129);
               } else {
                  aShortArray2644[i_1_] = s;
               }

               aByteArray2638[i_1_] = (byte)(i_6_ >>> 3 & 3);
               if (i_5_ == 2 || i_5_ == 9) {
                  aShortArray2645[i_1_] = (short)(aShortArray2645[i_1_] << 2 & 16383);
                  aShortArray2639[i_1_] = (short)(aShortArray2639[i_1_] << 2 & 16383);
                  aShortArray2644[i_1_] = (short)(aShortArray2644[i_1_] << 2 & 16383);
               }

               aShortArray2650[i_1_] = -1;
               if (i_5_ != 1 && i_5_ != 2 && i_5_ != 3) {
                  if (i_5_ == 5) {
                     this.aBoolean2640 = true;
                  } else if (i_5_ == 7) {
                     this.aBoolean2637 = true;
                  } else if (i_5_ == 9 || i_5_ == 10 || i_5_ == 8) {
                     this.aBoolean2646 = true;
                  }
               } else if (i_2_ > i_3_) {
                  aShortArray2650[i_1_] = (short)i_2_;
                  i_3_ = i_2_;
               }

               ++i_1_;
            }
         }

         if (buffer_0_.offset != bs.length) {
            throw new RuntimeException();
         }

         this.anInt2642 = i_1_;
         this.aShortArray2636 = new short[i_1_];
         this.aShortArray2648 = new short[i_1_];
         this.aShortArray2649 = new short[i_1_];
         this.aShortArray2643 = new short[i_1_];
         this.aShortArray2635 = new short[i_1_];
         this.aByteArray2641 = new byte[i_1_];

         for(int i_7_ = 0; i_7_ < i_1_; ++i_7_) {
            this.aShortArray2636[i_7_] = aShortArray2647[i_7_];
            this.aShortArray2648[i_7_] = aShortArray2645[i_7_];
            this.aShortArray2649[i_7_] = aShortArray2639[i_7_];
            this.aShortArray2643[i_7_] = aShortArray2644[i_7_];
            this.aShortArray2635[i_7_] = aShortArray2650[i_7_];
            this.aByteArray2641[i_7_] = aByteArray2638[i_7_];
         }
      } catch (Exception var13) {
         this.anInt2642 = 0;
         this.aBoolean2640 = false;
         this.aBoolean2637 = false;
      }
   }
}
