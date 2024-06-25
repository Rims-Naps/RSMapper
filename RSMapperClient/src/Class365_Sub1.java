import java.io.IOException;
import java.net.Socket;

public class Class365_Sub1 extends Class365 {
   private Class360 aClass360_8757;
   static int anInt8758;
   static int anInt8759;
   private Class156 aClass156_8760;
   static int anInt8761;
   static int anInt8762;
   static int anInt8763;
   static int anInt8764;
   static int anInt8765;
   static IncommingPacket aClass192_8766 = new IncommingPacket(31, 4);
   private Socket aSocket8767;
   static int anInt8768;
   static int anInt8769 = 0;

   @Override
   final void method4067(byte[] bs, int i, byte b, int i_0_) throws IOException {
      if (b != -29) {
         this.aSocket8767 = null;
      }

      this.aClass360_8757.method4042(bs, i, -19032, i_0_);
      ++anInt8763;
   }

   @Override
   final int method4065(byte b, byte[] bs, int i, int i_1_) throws IOException {
      ++anInt8765;
      return b >= -51 ? -89 : this.aClass156_8760.method1708(1, i, i_1_, bs);
   }

   @Override
   final boolean method4068(int i, int i_2_) throws IOException {
      ++anInt8764;
      if (i_2_ <= 17) {
         anInt8769 = -84;
      }

      return this.aClass156_8760.method1703(113, i);
   }

   @Override
   final void method4062(int i) {
      try {
         this.aSocket8767.close();
         if (i != -2) {
            this.method4062(94);
         }
      } catch (IOException var3) {
      }

      ++anInt8761;
      this.aClass156_8760.method1706((byte)-94);
      this.aClass360_8757.method4041(-14303);
   }

   public static void method4069(int i) {
      if (i != 30000) {
         method4069(110);
      }

      aClass192_8766 = null;
   }

   @Override
   protected final void finalize() {
      this.method4062(-2);
      ++anInt8762;
   }

   Class365_Sub1(Socket socket, int i) throws IOException {
      this.aSocket8767 = socket;
      this.aSocket8767.setSoTimeout(30000);
      this.aSocket8767.setTcpNoDelay(true);
      this.aClass156_8760 = new Class156(this.aSocket8767.getInputStream(), i);
      this.aClass360_8757 = new Class360(this.aSocket8767.getOutputStream(), i);
   }

   @Override
   final void method4063(int i) {
      ++anInt8768;
      this.aClass156_8760.method1704(false);
      this.aClass360_8757.method4044(i + i);
   }

   static final void method4070(int i) {
      if (Class188.anInt2281 != -1) {
         Node_Sub38_Sub5.method2802(Class188.anInt2281, false, -1, -1, -11493);
         Class188.anInt2281 = -1;
      }

      ++anInt8758;
      int i_3_ = 38 / ((i - -39) / 49);
   }
}
