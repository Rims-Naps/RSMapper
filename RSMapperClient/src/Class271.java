import java.util.zip.Inflater;

public class Class271 {
   static int anInt3478;
   static int anInt3479;
   private Inflater anInflater3480;
   static int anInt3481;
   static int anInt3482;

   final void method3311(int i, Buffer buffer, byte[] bs) {
      ++anInt3481;
      if (~buffer.buffer[buffer.offset] == -32 && buffer.buffer[buffer.offset + 1] == -117) {
         if (this.anInflater3480 == null) {
            this.anInflater3480 = new Inflater(true);
         }

         try {
            this.anInflater3480.setInput(buffer.buffer, i + buffer.offset, -8 - buffer.offset - (10 - buffer.buffer.length));
            this.anInflater3480.inflate(bs);
         } catch (Exception var5) {
            this.anInflater3480.reset();
            if (~buffer.buffer[buffer.offset] != -32 || buffer.buffer[buffer.offset + 1] != -117) {
               bs = new byte[100];
               return;
            }
         }

         this.anInflater3480.reset();
      } else {
         bs = new byte[100];
      }
   }

   final byte[] method3312(byte[] bs, boolean bool) {
      ++anInt3482;
      Buffer buffer = new Buffer(bs);
      if (!bool) {
         return null;
      } else {
         buffer.offset = bs.length - 4;
         int i = buffer.method2188(117);
         byte[] bs_0_ = new byte[i];
         buffer.offset = 0;
         this.method3311(10, buffer, bs_0_);
         return bs_0_;
      }
   }

   static final void method3313(Object[] objects, int[] is, byte b) {
      Class238.method3019(is.length - 1, 0, is, objects, false);
      ++anInt3478;
      if (b != -83) {
         method3313(null, null, (byte)102);
      }
   }

   private Class271(int i, int i_1_, int i_2_) {
   }

   public Class271() {
      this(-1, 1000000, 1000000);
   }
}
