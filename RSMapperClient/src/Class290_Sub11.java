import jaggl.OpenGL;

public class Class290_Sub11 extends Class290 {
   private Class106 aClass106_8160;
   private Class106 aClass106_8161;
   static int anInt8162;
   static int anInt8163;
   private float[] aFloatArray8164 = new float[4];
   static int anInt8165;
   static int anInt8166;
   static int anInt8167;
   private Class106 aClass106_8168;
   static int anInt8169;
   private boolean aBoolean8170;
   private Class106 aClass106_8171;
   private static char[] aCharArray8172 = new char[64];
   private Interface13_Impl1 anInterface13_Impl1_8173;
   private boolean aBoolean8174 = false;
   static boolean aBoolean8175 = false;
   private boolean aBoolean8176;
   static int anInt8177;
   static int anInt8178;
   static int anInt8179;
   static int[] anIntArray8180;
   static int anInt8181;
   private boolean aBoolean8182;
   static float[] aFloatArray8183;
   static IncommingPacket aClass192_8184;

   static {
      for(int i = 0; i < 26; ++i) {
         aCharArray8172[i] = (char)(65 + i);
      }

      for(int i = 26; i < 52; ++i) {
         aCharArray8172[i] = (char)(97 + i - 26);
      }

      for(int i = 52; ~i > -63; ++i) {
         aCharArray8172[i] = (char)(i + -4);
      }

      aCharArray8172[63] = '-';
      aCharArray8172[62] = '*';
      aFloatArray8183 = new float[4];
      aClass192_8184 = new IncommingPacket(111, 3);
   }

   public static void method3444(int i) {
      aFloatArray8183 = null;
      anIntArray8180 = null;
      aClass192_8184 = null;
      int i_0_ = 54 / ((-5 - i) / 61);
      aCharArray8172 = null;
   }

   @Override
   final boolean method3414(byte b) {
      ++anInt8165;
      if (b >= -45) {
         anInt8181 = -112;
      }

      return this.aBoolean8176;
   }

   static final float[] method3445(int i, float[] fs, boolean bool) {
      if (bool) {
         return null;
      } else {
         ++anInt8179;
         float[] fs_1_ = new float[i];
         Class311.method3603(fs, 0, fs_1_, 0, i);
         return fs_1_;
      }
   }

   @Override
   final void method3419(Interface13 interface13, int i, byte b) {
      if (b != 92) {
         method3444(112);
      }

      ++anInt8167;
      if (interface13 == null) {
         if (!this.aBoolean8174) {
            this.anAbstractToolkit3654.method1312((byte)-21, this.anAbstractToolkit3654.anInterface13_6357);
            this.anAbstractToolkit3654.method1278((byte)-12, 1);
            this.anAbstractToolkit3654.method1304(0, 0, Class200_Sub1.aClass135_5139);
            this.anAbstractToolkit3654.method1366((byte)123, Class200_Sub1.aClass135_5139, 0);
            this.aBoolean8174 = true;
         }
      } else {
         if (this.aBoolean8174) {
            this.anAbstractToolkit3654.method1304(0, 0, Class106.aClass135_1354);
            this.anAbstractToolkit3654.method1366((byte)92, Class106.aClass135_1354, 0);
            this.aBoolean8174 = false;
         }

         this.anAbstractToolkit3654.method1312((byte)-21, interface13);
         this.anAbstractToolkit3654.method1278((byte)-12, i);
      }
   }

   @Override
   final void method3416(byte b) {
      ++anInt8166;
      if (b != -56) {
         this.method3422(-120, true);
      }

      if (this.aBoolean8170) {
         int i = this.anAbstractToolkit3654.XA();
         int i_2_ = this.anAbstractToolkit3654.i();
         float f = (float)i - (float)(-i_2_ + i) * 0.125F;
         float f_3_ = -(0.25F * (float)(i + -i_2_)) + (float)i;
         OpenGL.glProgramLocalParameter4fARB(
            34336, 0, f_3_, f, 1.0F / (float)this.anAbstractToolkit3654.method1329(512), (float)this.anAbstractToolkit3654.method1344(-113) / 255.0F
         );
         this.anAbstractToolkit3654.method1362(255, 1);
         this.anAbstractToolkit3654.method1336(-2, this.anAbstractToolkit3654.method1249((byte)114));
         this.anAbstractToolkit3654.method1362(255, 0);
      }
   }

   @Override
   final void method3411(int i) {
      ++anInt8178;
      this.anAbstractToolkit3654.method1362(255, 1);
      this.anAbstractToolkit3654.method1312((byte)-21, null);
      this.anAbstractToolkit3654.method1318(i + 8638, Class116.aClass94_5075, Class116.aClass94_5075);
      this.anAbstractToolkit3654.method1304(0, 0, Class106.aClass135_1354);
      this.anAbstractToolkit3654.method1304(2, i + 8668, InterfaceSettings.aClass135_7421);
      this.anAbstractToolkit3654.method1366((byte)89, Class106.aClass135_1354, 0);
      this.anAbstractToolkit3654.method1362(255, 0);
      if (this.aBoolean8174) {
         this.anAbstractToolkit3654.method1304(0, 0, Class106.aClass135_1354);
         this.anAbstractToolkit3654.method1366((byte)-58, Class106.aClass135_1354, 0);
         this.aBoolean8174 = false;
      }

      if (i != -8668) {
         anInt8181 = -99;
      }

      if (this.aBoolean8170) {
         OpenGL.glBindProgramARB(34336, 0);
         OpenGL.glDisable(34820);
         OpenGL.glDisable(34336);
         this.aBoolean8170 = false;
      }
   }

   @Override
   final void method3417(boolean bool, boolean bool_4_) {
      ++anInt8177;
      if (bool_4_) {
         anInt8181 = -44;
      }
   }

   Class290_Sub11(GLXToolkit glxtoolkit, Index class302) {
      super(glxtoolkit);
      if (class302 != null && glxtoolkit.aBoolean9326) {
         this.aClass106_8160 = Class157.method1709(glxtoolkit, 34336, -113, class302.method3529("gl", "uw_ground_unlit", 1));
         this.aClass106_8161 = Class157.method1709(glxtoolkit, 34336, -92, class302.method3529("gl", "uw_ground_lit", 1));
         this.aClass106_8171 = Class157.method1709(glxtoolkit, 34336, -124, class302.method3529("gl", "uw_model_unlit", 1));
         this.aClass106_8168 = Class157.method1709(glxtoolkit, 34336, -71, class302.method3529("gl", "uw_model_lit", 1));
         if (!(this.aClass106_8168 != null & this.aClass106_8160 != null & this.aClass106_8161 != null & this.aClass106_8171 != null)) {
            this.aBoolean8176 = false;
         } else {
            this.anInterface13_Impl1_8173 = this.anAbstractToolkit3654.method1258(false, 1, true, 2, new int[]{0, -1});
            this.anInterface13_Impl1_8173.method51(false, false, false);
            this.aBoolean8176 = true;
         }
      } else {
         this.aBoolean8176 = false;
      }
   }

   @Override
   final void method3415(boolean bool, int i, int i_5_) {
      ++anInt8162;
      if (!bool) {
         this.method3415(false, 113, 88);
      }
   }

   @Override
   final void method3420(int i) {
      ++anInt8163;
      int i_6_ = this.anAbstractToolkit3654.method1316(-2);
      Class336_Sub1 class336_sub1 = this.anAbstractToolkit3654.method1342(118);
      if (!this.aBoolean8182) {
         OpenGL.glBindProgramARB(34336, i_6_ == Integer.MAX_VALUE ? this.aClass106_8160.anInt1350 : this.aClass106_8171.anInt1350);
      } else {
         OpenGL.glBindProgramARB(34336, ~i_6_ == Integer.MIN_VALUE ? this.aClass106_8161.anInt1350 : this.aClass106_8168.anInt1350);
      }

      OpenGL.glEnable(34336);
      if (i >= 4) {
         this.aBoolean8170 = true;
         class336_sub1.method3872((float)i_6_, -1.0F, (byte)86, 0.0F, this.aFloatArray8164, 0.0F);
         OpenGL.glProgramLocalParameter4fARB(34336, 1, this.aFloatArray8164[0], this.aFloatArray8164[1], this.aFloatArray8164[2], this.aFloatArray8164[3]);
         this.method3416((byte)-56);
      }
   }

   @Override
   final void method3422(int i, boolean bool) {
      ++anInt8169;
      this.aBoolean8182 = bool;
      this.anAbstractToolkit3654.method1362(255, 1);
      if (i < -84) {
         this.anAbstractToolkit3654.method1312((byte)-21, this.anInterface13_Impl1_8173);
         this.anAbstractToolkit3654.method1318(-30, Class117_Sub1.aClass94_4924, Class385.aClass94_4911);
         this.anAbstractToolkit3654.method1304(0, 0, InterfaceSettings.aClass135_7421);
         this.anAbstractToolkit3654.method1349(Class106.aClass135_1354, (byte)19, true, false, 2);
         this.anAbstractToolkit3654.method1366((byte)126, Class200_Sub1.aClass135_5139, 0);
         this.anAbstractToolkit3654.method1362(255, 0);
         this.method3420(102);
      }
   }
}
