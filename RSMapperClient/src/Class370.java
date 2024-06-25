public class Class370 {
   static int anInt4566;
   static int[] anIntArray4567 = new int[]{0, 1, 2, 3, 4, 5, 6, 14};
   static int anInt4568 = -1;
   static int anInt4569;
   static boolean aBoolean4570 = false;
   static int anInt4571;

   public static void method4088(int i) {
      if (i == 16) {
         anIntArray4567 = null;
      }
   }

   static final void method4089(LightFX class326) {
      if (Class188_Sub1_Sub1.fxCount < 65535) {
         Node_Sub29 node_sub29 = class326.aNode_Sub29_4100;
         Class143.aLightFXArray1771[Class188_Sub1_Sub1.fxCount] = class326;
         Class147.aBooleanArray1820[Class188_Sub1_Sub1.fxCount] = false;
         ++Class188_Sub1_Sub1.fxCount;
         int i = class326.plane;
         if (class326.aBoolean4090) {
            i = 0;
         }

         int i_0_ = class326.plane;
         if (class326.aBoolean4102) {
            i_0_ = Class159.anInt1995 - 1;
         }

         for(int i_1_ = i; i_1_ <= i_0_; ++i_1_) {
            int i_2_ = 0;
            int i_3_ = node_sub29.getReferenceY(27433) - node_sub29.getFlickerType(121) + Class135.INT_9_ >> Class36.INT_9;
            if (i_3_ < 0) {
               i_2_ -= i_3_;
               i_3_ = 0;
            }

            int i_4_ = node_sub29.getReferenceY(27433) + node_sub29.getFlickerType(118) - Class135.INT_9_ >> Class36.INT_9;
            if (i_4_ >= Node_Sub50.SCENE_WIDTH_Y) {
               i_4_ = Node_Sub50.SCENE_WIDTH_Y - 1;
            }

            for(int i_5_ = i_3_; i_5_ <= i_4_; ++i_5_) {
               int i_6_ = class326.aShortArray4105[i_2_++];
               int i_7_ = (node_sub29.getReferenceX(32311) - node_sub29.getFlickerType(119) + Class135.INT_9_ >> Class36.INT_9) + (i_6_ >>> 8);
               int i_8_ = i_7_ + (i_6_ & 0xFF) - 1;
               if (i_7_ < 0) {
                  i_7_ = 0;
               }

               if (i_8_ >= Class328.SCENE_WIDTH_X) {
                  i_8_ = Class328.SCENE_WIDTH_X - 1;
               }

               for(int i_9_ = i_7_; i_9_ <= i_8_; ++i_9_) {
                  long l = TextureDefinitions.aLongArrayArrayArray1228[i_1_][i_9_][i_5_];
                  if ((l & 65535L) == 0L) {
                     TextureDefinitions.aLongArrayArrayArray1228[i_1_][i_9_][i_5_] = l | (long)Class188_Sub1_Sub1.fxCount;
                  } else if ((l & 4294901760L) == 0L) {
                     TextureDefinitions.aLongArrayArrayArray1228[i_1_][i_9_][i_5_] = l | (long)Class188_Sub1_Sub1.fxCount << 16;
                  } else if ((l & 281470681743360L) == 0L) {
                     TextureDefinitions.aLongArrayArrayArray1228[i_1_][i_9_][i_5_] = l | (long)Class188_Sub1_Sub1.fxCount << 32;
                  } else if ((l & -281474976710656L) == 0L) {
                     TextureDefinitions.aLongArrayArrayArray1228[i_1_][i_9_][i_5_] = l | (long)Class188_Sub1_Sub1.fxCount << 48;
                  }
               }
            }
         }
      }
   }

   static final void method4090(boolean negativeKey, int key, int junk) {
      if (junk == 0) {
         ++anInt4569;
         Node_Sub16 node_sub16 = Class295.getItemContainer(key, (byte)18, negativeKey);
         if (node_sub16 != null) {
            node_sub16.method2160((byte)99);
         }
      }
   }

   static final void method4091(int i, String string) {
      ++anInt4571;
      if (!string.equals("")) {
         ++anInt4566;
         Class123 class123 = Class262_Sub23.method3213((byte)-100);
         if (i != 16) {
            aBoolean4570 = true;
         }

         OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Node_Sub18.aClass318_7151, class123.issacKeys);
         node_sub13.currentOutgoingPacket.writeByte(Class126.method1536(-20826, string));
         node_sub13.currentOutgoingPacket.writeString(string);
         class123.sendPacket(127, node_sub13);
      }
   }
}
