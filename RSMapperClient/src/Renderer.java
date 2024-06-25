public class Renderer {
   protected int anInt3656;
   static int anInt3657;
   protected int anInt3658;
   static int anInt3659;
   protected String aString3660;
   protected long aLong3661;
   static IncommingPacket sendInterface = new IncommingPacket(5, 7);
   static int anInt3663;
   protected String aString3664;

   static final void method3446(int i, int i_0_) {
      if (i_0_ != 5) {
         method3447(106);
      }

      ++anInt3657;
      Node_Sub3 node_sub3 = (Node_Sub3)Class56.aHashTable839.get(3512, (long)i);
      if (node_sub3 != null) {
         node_sub3.aClass189_Sub1_6943.method1924((byte)92);
         Class341.method3960(node_sub3.anInt6947, node_sub3.aBoolean6945, (byte)115);
         node_sub3.method2160((byte)83);
      }
   }

   public static void method3447(int i) {
      if (i < -73) {
         sendInterface = null;
      }
   }

   static final Model method3448(int i, int i_1_, int i_2_, Index class302) {
      ++anInt3659;
      byte[] bs = class302.getFile(false, i_2_, i);
      if (bs == null) {
         return null;
      } else {
         return i_1_ != 7 ? null : new Model(bs);
      }
   }

   Renderer(int i, String string, int i_3_, String string_4_, long l) {
      this.aString3664 = string;
      this.aLong3661 = l;
      this.anInt3658 = i_3_;
      this.aString3660 = string_4_;
      this.anInt3656 = i;
   }
}
