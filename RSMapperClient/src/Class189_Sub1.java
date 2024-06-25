import java.io.IOException;

public class Class189_Sub1 extends Class189 {
   static int anInt6879;
   private Index index36;
   private int anInt6881;
   static Class257 aClass257_6882 = new Class257(8, 7);
   private Buffer aBuffer6883;
   private byte[][] aByteArrayArray6884 = new byte[10][];
   static int anInt6885;
   private int[] anIntArray6886;
   static Class329 aClass329_6887 = new Class329("WTRC", "office", "_rc", 1);
   private int anInt6888;
   private Buffer aBuffer6889;

   public static void method1936(int i) {
      if (i == 1) {
         aClass257_6882 = null;
         aClass329_6887 = null;
      }
   }

   Class189_Sub1(int i, Index index36, int i_0_) {
      super(i);
      this.aBuffer6883 = new Buffer(null);
      this.aBuffer6889 = new Buffer(null);
      this.index36 = index36;
      this.anInt6881 = i_0_;
   }

   final void method1937(int i) {
      ++anInt6879;
      if (this.anIntArray6886 != null) {
         for(int i_1_ = 0; i_1_ < 10 && ~(i_1_ + this.anInt6888) > ~this.anIntArray6886.length; ++i_1_) {
            if (this.aByteArrayArray6884[i_1_] == null && this.index36.method3515(0, this.anIntArray6886[this.anInt6888 - -i_1_], 0)) {
               this.aByteArrayArray6884[i_1_] = this.index36.getFile(false, 0, this.anIntArray6886[this.anInt6888 + i_1_]);
            }
         }

         if (i < 93) {
            this.aByteArrayArray6884 = null;
         }
      }
   }

   @Override
   final int method1929(byte[] bs, int i) throws IOException {
      ++anInt6885;
      if (this.anIntArray6886 == null) {
         if (!this.index36.method3515(0, this.anInt6881, 0)) {
            return 0;
         }

         byte[] bs_2_ = this.index36.getFile(false, 0, this.anInt6881);
         if (bs_2_ == null) {
            throw new IllegalStateException("");
         }

         this.aBuffer6889.buffer = bs_2_;
         this.aBuffer6889.offset = 0;
         int i_3_ = bs_2_.length >> 1;
         this.anIntArray6886 = new int[i_3_];

         for(int i_4_ = 0; ~i_4_ > ~i_3_; ++i_4_) {
            this.anIntArray6886[i_4_] = this.aBuffer6889.readUnsignedShort();
         }
      }

      if (~this.anInt6888 <= ~this.anIntArray6886.length) {
         return -1;
      } else {
         this.method1937(103);
         this.aBuffer6889.buffer = bs;
         this.aBuffer6889.offset = 0;

         while(~this.aBuffer6889.offset > ~this.aBuffer6889.buffer.length) {
            if (this.aBuffer6883.buffer == null) {
               if (this.aByteArrayArray6884[0] == null) {
                  this.aBuffer6889.buffer = null;
                  return this.aBuffer6889.offset;
               }

               this.aBuffer6883.buffer = this.aByteArrayArray6884[0];
            }

            int i_5_ = -this.aBuffer6889.offset + this.aBuffer6889.buffer.length;
            int i_6_ = -this.aBuffer6883.offset + this.aBuffer6883.buffer.length;
            if (~i_6_ < ~i_5_) {
               this.aBuffer6883.readBytes(this.aBuffer6889.buffer, this.aBuffer6889.offset, i_5_);
               this.aBuffer6889.buffer = null;
               return bs.length;
            }

            this.aBuffer6889.writeBytes(i_6_, this.aBuffer6883.buffer, this.aBuffer6883.offset);
            this.aBuffer6883.offset = 0;
            ++this.anInt6888;
            this.aBuffer6883.buffer = null;

            for(int i_7_ = 0; i_7_ < 9; ++i_7_) {
               this.aByteArrayArray6884[i_7_] = this.aByteArrayArray6884[1 + i_7_];
            }

            this.aByteArrayArray6884[9] = null;
            if (~this.anIntArray6886.length >= ~this.anInt6888) {
               this.aBuffer6889.buffer = null;
               return this.aBuffer6889.offset;
            }
         }

         if (i != 1) {
            this.anInt6888 = 98;
         }

         this.aBuffer6889.buffer = null;
         return bs.length;
      }
   }
}
