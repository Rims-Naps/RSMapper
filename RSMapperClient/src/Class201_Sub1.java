import java.nio.ByteBuffer;

public class Class201_Sub1 extends Class201 {
   private ByteBuffer aByteBuffer6909;

   @Override
   final void method2021(byte[] bs, int i) {
      this.aByteBuffer6909 = ByteBuffer.allocateDirect(bs.length);
      ((java.nio.Buffer)this.aByteBuffer6909).position(i);
      this.aByteBuffer6909.put(bs);
   }

   Class201_Sub1() {
   }

   @Override
   final byte[] method2020(byte b, int i, int i_0_) {
      byte[] bs = new byte[i];
      ((java.nio.Buffer)this.aByteBuffer6909).position(i_0_);
      this.aByteBuffer6909.get(bs, 0, i);
      int i_1_ = 75 % ((b - 44) / 45);
      return bs;
   }

   @Override
   final byte[] method2022(byte b) {
      byte[] bs = new byte[this.aByteBuffer6909.capacity()];
      ((java.nio.Buffer)this.aByteBuffer6909).position(0);
      if (b < 73) {
         this.aByteBuffer6909 = null;
      }

      this.aByteBuffer6909.get(bs);
      return bs;
   }
}
