public class EntityNode_Sub1 extends EntityNode {
   protected int anInt5922;
   protected int anInt5923;
   static int anInt5924;
   protected Actor anActor5925;
   protected int anInt5926;
   static OutgoingPacket aClass318_5927 = new OutgoingPacket(38, -1);
   protected int anInt5928;
   static Node_Sub9_Sub1 aNode_Sub9_Sub1_5929;

   public static void method804(boolean bool) {
      aNode_Sub9_Sub1_5929 = null;
      aClass318_5927 = null;
      if (!bool) {
         aClass318_5927 = null;
      }
   }

   EntityNode_Sub1() {
   }

   static final Class253 method805(int i, int i_0_) {
      ++anInt5924;
      if (i_0_ != -26296) {
         aNode_Sub9_Sub1_5929 = null;
      }

      return ~i <= -1 && i < 100 ? r_Sub2.aClass253Array11063[i] : null;
   }
}
