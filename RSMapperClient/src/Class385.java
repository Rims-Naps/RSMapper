public class Class385 {
   static int anInt4909;
   static int anInt4910;
   static Class94 aClass94_4911 = new Class94();
   static int anInt4912;
   static int anInt4913 = -1;
   static int[] anIntArray4914 = new int[13];

   static final void method4204(GraphicsToolkit graphicstoolkit, int i, byte b) {
      ++anInt4909;
      if (Class12.aBoolean194 && Mobile_Sub1.aBoolean10959) {
         if (Class373.aBoolean4608) {
            Class224.aLong2672 = Class146.aClass10_1815.method186(-69);
         }

         ProducingGraphicsBuffer.anInt9880 = 0;
         Class187.anInt2267 = 0;
         Node_Sub52.anInt7651 = 0;
         int[] is = graphicstoolkit.Y();
         aa.anInt100 = (int)((float)is[2] / 3.0F);
         OutputStream_Sub2.anInt96 = (int)((float)is[3] / 3.0F);
         graphicstoolkit.a(FileOnDisk.anIntArray1329);
         if (~Class144_Sub1.anInt6806 != ~((int)((float)FileOnDisk.anIntArray1329[0] / 3.0F))
            || ~((int)((float)FileOnDisk.anIntArray1329[1] / 3.0F)) != ~Class331.anInt4130) {
            Class144_Sub1.anInt6806 = (int)((float)FileOnDisk.anIntArray1329[0] / 3.0F);
            Class331.anInt4130 = (int)((float)FileOnDisk.anIntArray1329[1] / 3.0F);
            Class219.anInt2624 = Class331.anInt4130 >> 1;
            Class290_Sub6.anInt8124 = Class144_Sub1.anInt6806 >> 1;
            Node_Sub38.anIntArray7451 = new int[Class144_Sub1.anInt6806 * Class331.anInt4130];
         }

         Class57.aClass336_850 = graphicstoolkit.n();
         Class320_Sub21.anInt8406 = 0;

         for(int i_0_ = 0; ~Class167.anInt2033 < ~i_0_; ++i_0_) {
            Mobile_Sub4.method915(i, Node_Sub25_Sub2.aClass54Array9959[i_0_], 16, graphicstoolkit);
         }

         for(int i_1_ = 0; ~NpcDefinition.anInt2885 < ~i_1_; ++i_1_) {
            Mobile_Sub4.method915(i, GLXToolkit.aClass54Array9292[i_1_], 16, graphicstoolkit);
         }

         for(int i_2_ = 0; ~i_2_ > ~Class83.anInt5183; ++i_2_) {
            Mobile_Sub4.method915(i, IsaacCipher.aClass54Array1840[i_2_], 16, graphicstoolkit);
         }

         Class233.anInt2786 = 0;
         if (~Class320_Sub21.anInt8406 < -1) {
            int i_3_ = Node_Sub38.anIntArray7451.length;
            int i_4_ = i_3_ + -i_3_ & 7;

            int i_5_;
            for(i_5_ = 0; ~i_5_ > ~i_4_; Node_Sub38.anIntArray7451[i_5_++] = Integer.MAX_VALUE) {
               Node_Sub38.anIntArray7451[i_5_++] = Integer.MAX_VALUE;
               Node_Sub38.anIntArray7451[i_5_++] = Integer.MAX_VALUE;
               Node_Sub38.anIntArray7451[i_5_++] = Integer.MAX_VALUE;
               Node_Sub38.anIntArray7451[i_5_++] = Integer.MAX_VALUE;
               Node_Sub38.anIntArray7451[i_5_++] = Integer.MAX_VALUE;
               Node_Sub38.anIntArray7451[i_5_++] = Integer.MAX_VALUE;
               Node_Sub38.anIntArray7451[i_5_++] = Integer.MAX_VALUE;
            }

            while(~i_5_ > ~i_3_) {
               Node_Sub38.anIntArray7451[i_5_++] = Integer.MAX_VALUE;
            }

            Class320_Sub11.anInt8315 = 1;
            Node_Sub25_Sub2.aClass54Array9959 = new Class54[2000];
            Class167.anInt2033 = 0;
            Class320_Sub11.anInt8315 = 2;
         }

         if (Class373.aBoolean4608) {
            Node_Sub38_Sub31.aLong10420 = Class146.aClass10_1815.method186(-89) - Class224.aLong2672;
         }
      } else {
         Class320_Sub21.anInt8406 = 0;
      }
   }

   static final void method4205(boolean bool, double d) {
      if (bool) {
         aClass94_4911 = null;
      }

      ++anInt4910;
      if (GLSprite_Sub1.aDouble8857 != d) {
         for(int i = 0; ~i > -257; ++i) {
            int i_7_ = (int)(Math.pow((double)i / 255.0, d) * 255.0);
            PlayerUpdateReference.anIntArray4084[i] = ~i_7_ < -256 ? 255 : i_7_;
         }

         GLSprite_Sub1.aDouble8857 = d;
      }
   }

   public static void method4206(byte b) {
      aClass94_4911 = null;
      anIntArray4914 = null;
      if (b != 77) {
         method4205(false, -0.395281652712193);
      }
   }
}
