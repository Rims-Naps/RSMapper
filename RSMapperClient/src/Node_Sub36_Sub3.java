public class Node_Sub36_Sub3 extends Node_Sub36 {
   static int anInt10054;
   static int anInt10055;
   static int anInt10056;
   static int anInt10057;
   static Class179 aClass179_10058 = Node_Sub36_Sub3.aClass179_10062 = new Class179(false);
   static Class241 aClass241_10059;
   private int anInt10060 = -1;
   static int anInt10061 = -1;
   static Class179 aClass179_10062;

   static final void method2762(boolean bool, Index class302) {
      ++anInt10057;
      if (!bool) {
         Class165.aClass302_2029 = class302;
      }
   }

   public static void method2763(byte b) {
      if (b == 76) {
         aClass179_10062 = null;
         aClass179_10058 = null;
         aClass241_10059 = null;
      }
   }

   @Override
   final void method2756(Buffer buffer, int i) {
      if (i != -1) {
         this.anInt10060 = 68;
      }

      ++anInt10055;
      this.anInt10060 = buffer.readUnsignedShort();
      buffer.readUnsignedByte();
      if (~buffer.readUnsignedByte() != -256) {
         --buffer.offset;
         buffer.readLong();
      }
   }

   @Override
   final void method2751(Node_Sub43 node_sub43, int i) {
      node_sub43.method2942(this.anInt10060, -79);
      if (i != 0) {
         aClass179_10062 = null;
      }

      ++anInt10054;
   }

   Node_Sub36_Sub3() {
   }
}
