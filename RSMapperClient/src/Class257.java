public class Class257 {
   static int anInt3242;
   static float cameraRotationVertical = 1024.0F;
   static int anInt3244 = 503;
   static IncommingPacket aClass192_3245 = new IncommingPacket(49, 1);
   static int anInt3246;
   static int anInt3247;

   static final void method3121(int i, boolean bool, int i_0_) {
      ++anInt3242;
      ++Class320_Sub22.anInt8416;
      OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Node_Sub36_Sub1.aClass318_10031, Class218.aClass123_2566.issacKeys);
      if (!bool) {
         method3121(106, true, 87);
      }

      node_sub13.currentOutgoingPacket.writeIntV2(i_0_);
      node_sub13.currentOutgoingPacket.writeShortLE128(i);
      Class218.aClass123_2566.sendPacket(127, node_sub13);
   }

   @Override
   public final String toString() {
      ++anInt3246;
      throw new IllegalStateException();
   }

   Class257(int i, int i_1_) {
   }

   static final void sendModelOnInterface(int modelId, int modelType, int i_3_, int interfaceHash) {
      ++anInt3247;
      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 4, (long)interfaceHash);
      cachenode_sub2.method2288(0);
      cachenode_sub2.anInt9429 = i_3_;
      cachenode_sub2.anInt9434 = modelType;
      cachenode_sub2.anInt9432 = modelId;
   }

   public static void method3123(boolean bool) {
      if (!bool) {
         anInt3244 = -110;
      }

      aClass192_3245 = null;
   }
}
