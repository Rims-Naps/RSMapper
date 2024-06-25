public class Class293 {
   static int anInt3680;
   static Index index3;
   protected int anInt3682 = 0;
   static int anInt3683;
   static int anInt3684;

   static final void method3461(String[] strings, short[] ses, int i) {
      Class225.method2108(strings.length + -1, ses, 0, strings, -25575);
      ++anInt3680;
   }

   private final void method3462(byte b, Buffer buffer, int i) {
      ++anInt3684;
      if (~i == -6) {
         this.anInt3682 = buffer.readUnsignedShort();
      }
   }

   final void method3463(Buffer buffer, byte b) {
      ++anInt3683;

      while(true) {
         int i = buffer.readUnsignedByte();
         if (~i == -1) {
            if (b != -114) {
               method3461(null, null, -80);
            }

            return;
         }

         this.method3462((byte)22, buffer, i);
      }
   }

   public static void method3464(int i) {
      index3 = null;
      if (i != 10196) {
         method3464(-116);
      }
   }
}
