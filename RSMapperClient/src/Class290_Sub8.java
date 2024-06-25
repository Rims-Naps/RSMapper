import jagdx.IDirect3DDevice;
import jagdx.IDirect3DVertexShader;

public class Class290_Sub8 extends Class290 {
   private IDirect3DVertexShader anIDirect3DVertexShader8137;
   private boolean aBoolean8138 = false;
   private Interface13_Impl1 anInterface13_Impl1_8139;
   private IDirect3DVertexShader anIDirect3DVertexShader8140;
   private boolean aBoolean8141;
   private IDirect3DVertexShader anIDirect3DVertexShader8142;
   private IDirect3DVertexShader anIDirect3DVertexShader8143;
   private boolean aBoolean8144;
   private static float[] aFloatArray8145 = new float[16];
   private IDirect3DVertexShader anIDirect3DVertexShader8146;
   private D3DToolkit aD3DToolkit8147;
   private static float[] aFloatArray8148 = new float[4];

   private final void method3443(int i) {
      if (this.anIDirect3DVertexShader8140 != null && this.aBoolean8144) {
         Class336_Sub1 class336_sub1 = this.anAbstractToolkit3654.method1292((byte)-82);
         IDirect3DDevice idirect3ddevice = this.aD3DToolkit8147.anIDirect3DDevice9199;
         idirect3ddevice.a(
            13,
            this.anAbstractToolkit3654.aFloat6323 * this.anAbstractToolkit3654.aFloat6300,
            this.anAbstractToolkit3654.aFloat6293 * this.anAbstractToolkit3654.aFloat6300,
            this.anAbstractToolkit3654.aFloat6300 * this.anAbstractToolkit3654.aFloat6365,
            1.0F
         );
         idirect3ddevice.a(
            14,
            this.anAbstractToolkit3654.aFloat6274 * this.anAbstractToolkit3654.aFloat6323,
            this.anAbstractToolkit3654.aFloat6274 * this.anAbstractToolkit3654.aFloat6293,
            this.anAbstractToolkit3654.aFloat6365 * this.anAbstractToolkit3654.aFloat6274,
            1.0F
         );
         idirect3ddevice.a(
            16,
            this.anAbstractToolkit3654.aFloat6323 * this.anAbstractToolkit3654.aFloat6272,
            this.anAbstractToolkit3654.aFloat6293 * this.anAbstractToolkit3654.aFloat6272,
            this.anAbstractToolkit3654.aFloat6365 * this.anAbstractToolkit3654.aFloat6272,
            1.0F
         );
         class336_sub1.method3890(
            this.anAbstractToolkit3654.aFloatArray6292[0],
            aFloatArray8148,
            this.anAbstractToolkit3654.aFloatArray6292[1],
            this.anAbstractToolkit3654.aFloatArray6292[2],
            (byte)-108
         );
         idirect3ddevice.SetVertexShaderConstantF(15, aFloatArray8148, 1);
         class336_sub1.method3890(
            this.anAbstractToolkit3654.aFloatArray6304[0],
            aFloatArray8148,
            this.anAbstractToolkit3654.aFloatArray6304[1],
            this.anAbstractToolkit3654.aFloatArray6304[2],
            (byte)91
         );
         idirect3ddevice.SetVertexShaderConstantF(17, aFloatArray8148, 1);
      }

      if (i != -14771) {
         this.method3411(-14);
      }
   }

   @Override
   final void method3416(byte b) {
      if (b == -56 && this.anIDirect3DVertexShader8140 != null) {
         IDirect3DDevice idirect3ddevice = this.aD3DToolkit8147.anIDirect3DDevice9199;
         int i = this.anAbstractToolkit3654.XA();
         int i_0_ = this.anAbstractToolkit3654.i();
         float f = -(0.125F * (float)(-i_0_ + i)) + (float)i;
         float f_1_ = (float)i - (float)(i + -i_0_) * 0.25F;
         idirect3ddevice.a(10, f_1_, 1.0F / (-f_1_ + f), f, 1.0F / (-f + (float)i));
         idirect3ddevice.a(
            11,
            1.0F / (float)this.anAbstractToolkit3654.method1329(512),
            (float)this.anAbstractToolkit3654.method1344(-119) / 255.0F,
            this.anAbstractToolkit3654.aFloat6328,
            1.0F / (this.anAbstractToolkit3654.aFloat6328 - this.anAbstractToolkit3654.aFloat6311)
         );
         this.anAbstractToolkit3654.method1336(b + 54, this.anAbstractToolkit3654.method1249((byte)114));
      }
   }

   Class290_Sub8(D3DToolkit d3dtoolkit, Index class302) {
      super(d3dtoolkit);
      this.aD3DToolkit8147 = d3dtoolkit;
      if (class302 != null && (65535 & this.aD3DToolkit8147.aD3DCAPS9188.VertexShaderVersion) >= 257) {
         this.anIDirect3DVertexShader8142 = this.aD3DToolkit8147.anIDirect3DDevice9199.b(class302.method3529("dx", "uw_ground_unlit", 1));
         this.anIDirect3DVertexShader8143 = this.aD3DToolkit8147.anIDirect3DDevice9199.b(class302.method3529("dx", "uw_ground_lit", 1));
         this.anIDirect3DVertexShader8146 = this.aD3DToolkit8147.anIDirect3DDevice9199.b(class302.method3529("dx", "uw_model_unlit", 1));
         this.anIDirect3DVertexShader8137 = this.aD3DToolkit8147.anIDirect3DDevice9199.b(class302.method3529("dx", "uw_model_lit", 1));
         if (!(
            this.anIDirect3DVertexShader8137 != null
               & this.anIDirect3DVertexShader8146 != null
               & this.anIDirect3DVertexShader8143 != null
               & this.anIDirect3DVertexShader8142 != null
         )) {
            this.aBoolean8141 = false;
         } else {
            this.anInterface13_Impl1_8139 = this.anAbstractToolkit3654.method1258(false, 1, true, 2, new int[]{0, -1});
            this.anInterface13_Impl1_8139.method51(false, false, false);
            this.aBoolean8141 = true;
         }
      } else {
         this.aBoolean8141 = false;
      }
   }

   @Override
   final boolean method3414(byte b) {
      return b > -45 ? true : this.aBoolean8141;
   }

   @Override
   final void method3417(boolean bool, boolean bool_2_) {
      if (bool_2_) {
         this.method3415(false, -92, 99);
      }
   }

   @Override
   final void method3412(int i) {
      if (i != 0) {
         this.anInterface13_Impl1_8139 = null;
      }

      if (this.anIDirect3DVertexShader8140 != null) {
         IDirect3DDevice idirect3ddevice = this.aD3DToolkit8147.anIDirect3DDevice9199;
         idirect3ddevice.a(4, this.anAbstractToolkit3654.method1361(aFloatArray8145, 7));
      }
   }

   @Override
   final void method3419(Interface13 interface13, int i, byte b) {
      if (interface13 != null) {
         if (this.aBoolean8138) {
            this.anAbstractToolkit3654.method1304(0, b + -92, Class106.aClass135_1354);
            this.anAbstractToolkit3654.method1366((byte)-104, Class106.aClass135_1354, 0);
            this.aBoolean8138 = false;
         }

         this.anAbstractToolkit3654.method1312((byte)-21, interface13);
         this.anAbstractToolkit3654.method1278((byte)-12, i);
      } else if (!this.aBoolean8138) {
         this.anAbstractToolkit3654.method1312((byte)-21, this.anAbstractToolkit3654.anInterface13_6357);
         this.anAbstractToolkit3654.method1278((byte)-12, 1);
         this.anAbstractToolkit3654.method1304(0, 0, Class200_Sub1.aClass135_5139);
         this.anAbstractToolkit3654.method1366((byte)-116, Class200_Sub1.aClass135_5139, 0);
         this.aBoolean8138 = true;
      }

      if (b != 92) {
         this.method3422(64, false);
      }
   }

   @Override
   final void method3415(boolean bool, int i, int i_3_) {
      if (!bool) {
         this.method3422(-19, false);
      }
   }

   @Override
   final void method3422(int i, boolean bool) {
      this.aBoolean8144 = bool;
      this.anAbstractToolkit3654.method1362(255, 1);
      this.anAbstractToolkit3654.method1312((byte)-21, this.anInterface13_Impl1_8139);
      this.anAbstractToolkit3654.method1318(-30, Class117_Sub1.aClass94_4924, Class385.aClass94_4911);
      this.anAbstractToolkit3654.method1304(0, 0, InterfaceSettings.aClass135_7421);
      this.anAbstractToolkit3654.method1349(Class106.aClass135_1354, (byte)19, true, false, 2);
      this.anAbstractToolkit3654.method1366((byte)-71, Class200_Sub1.aClass135_5139, 0);
      this.anAbstractToolkit3654.method1362(255, 0);
      this.method3420(20);
      if (i >= -84) {
         this.aD3DToolkit8147 = null;
      }
   }

   @Override
   final void method3421(boolean bool) {
      if (this.anIDirect3DVertexShader8140 != null) {
         IDirect3DDevice idirect3ddevice = this.aD3DToolkit8147.anIDirect3DDevice9199;
         Class336_Sub1 class336_sub1 = this.anAbstractToolkit3654.method1290((byte)86);
         idirect3ddevice.SetVertexShaderConstantF(8, class336_sub1.method3891(aFloatArray8145, true), 2);
      }

      if (bool) {
         aFloatArray8148 = null;
      }
   }

   @Override
   final void method3411(int i) {
      this.anAbstractToolkit3654.method1362(255, 1);
      this.anAbstractToolkit3654.method1312((byte)-21, null);
      this.anAbstractToolkit3654.method1318(-30, Class116.aClass94_5075, Class116.aClass94_5075);
      this.anAbstractToolkit3654.method1304(0, 0, Class106.aClass135_1354);
      this.anAbstractToolkit3654.method1304(2, i ^ i, InterfaceSettings.aClass135_7421);
      this.anAbstractToolkit3654.method1366((byte)-108, Class106.aClass135_1354, 0);
      this.anAbstractToolkit3654.method1362(255, 0);
      if (this.aBoolean8138) {
         this.anAbstractToolkit3654.method1304(0, i ^ -8668, Class106.aClass135_1354);
         this.anAbstractToolkit3654.method1366((byte)-73, Class106.aClass135_1354, 0);
         this.aBoolean8138 = false;
      }

      if (this.anIDirect3DVertexShader8140 != null) {
         this.aD3DToolkit8147.method1384((byte)72, null);
         this.anIDirect3DVertexShader8140 = null;
      }
   }

   @Override
   final void method3410(int i) {
      if (this.anIDirect3DVertexShader8140 != null) {
         IDirect3DDevice idirect3ddevice = this.aD3DToolkit8147.anIDirect3DDevice9199;
         Class336_Sub1 class336_sub1 = this.aD3DToolkit8147.method1378(50);
         idirect3ddevice.a(0, class336_sub1.method3881((byte)-111, aFloatArray8145));
      }

      if (i <= 10) {
         this.method3421(true);
      }
   }

   @Override
   final void method3413(int i) {
      if (this.anIDirect3DVertexShader8140 != null) {
         IDirect3DDevice idirect3ddevice = this.aD3DToolkit8147.anIDirect3DDevice9199;
         Class336_Sub1 class336_sub1 = this.aD3DToolkit8147.method1378(50);
         idirect3ddevice.a(0, class336_sub1.method3881((byte)52, aFloatArray8145));
      }

      int i_4_ = 4 / ((i - -60) / 61);
   }

   @Override
   final void method3420(int i) {
      IDirect3DDevice idirect3ddevice = this.aD3DToolkit8147.anIDirect3DDevice9199;
      int i_5_ = this.anAbstractToolkit3654.method1316(-2);
      Class336_Sub1 class336_sub1 = this.anAbstractToolkit3654.method1342(-49);
      IDirect3DVertexShader idirect3dvertexshader;
      if (this.aBoolean8144) {
         idirect3dvertexshader = ~i_5_ == Integer.MIN_VALUE ? this.anIDirect3DVertexShader8143 : this.anIDirect3DVertexShader8137;
      } else {
         idirect3dvertexshader = i_5_ != Integer.MAX_VALUE ? this.anIDirect3DVertexShader8146 : this.anIDirect3DVertexShader8142;
      }

      if (this.anIDirect3DVertexShader8140 != idirect3dvertexshader) {
         this.anIDirect3DVertexShader8140 = idirect3dvertexshader;
         this.aD3DToolkit8147.method1384((byte)122, idirect3dvertexshader);
         this.method3443(-14771);
         this.method3412(0);
         this.method3421(false);
         this.method3410(107);
         this.method3413(-121);
         this.method3416((byte)-56);
      }

      if (i <= 4) {
         this.anIDirect3DVertexShader8146 = null;
      }

      class336_sub1.method3872((float)i_5_, -1.0F, (byte)86, 0.0F, aFloatArray8148, 0.0F);
      idirect3ddevice.a(12, aFloatArray8148);
   }
}
