import jagdx.IDirect3DDevice;
import jagdx.IDirect3DPixelShader;
import jagdx.IDirect3DVertexShader;

public class Class290_Sub10 extends Class290 {
   private boolean aBoolean8153;
   private IDirect3DPixelShader anIDirect3DPixelShader8154;
   private boolean aBoolean8155;
   private Class5 aClass5_8156;
   private IDirect3DVertexShader anIDirect3DVertexShader8157;
   private D3DToolkit aD3DToolkit8158;
   private static float[] aFloatArray8159 = new float[16];

   @Override
   final void method3422(int i, boolean bool) {
      Interface13_Impl2 interface13_impl2 = this.anAbstractToolkit3654.method1369(-116);
      if (this.aBoolean8153 && interface13_impl2 != null) {
         IDirect3DDevice idirect3ddevice = this.aD3DToolkit8158.anIDirect3DDevice9199;
         this.aD3DToolkit8158.method1384((byte)-124, this.anIDirect3DVertexShader8157);
         this.aD3DToolkit8158.method1386(122, this.anIDirect3DPixelShader8154);
         this.anAbstractToolkit3654.method1362(255, 1);
         this.anAbstractToolkit3654.method1312((byte)-21, interface13_impl2);
         this.anAbstractToolkit3654.method1362(255, 0);
         this.anAbstractToolkit3654.method1312((byte)-21, this.aClass5_8156.anInterface13_Impl3_129);
         this.aBoolean8155 = true;
         this.method3413(-124);
         this.method3421(false);
         this.method3412(0);
         this.method3416((byte)-56);
         idirect3ddevice.b(
            1,
            -this.anAbstractToolkit3654.aFloatArray6292[0],
            -this.anAbstractToolkit3654.aFloatArray6292[1],
            -this.anAbstractToolkit3654.aFloatArray6292[2],
            0.0F
         );
         idirect3ddevice.b(2, this.anAbstractToolkit3654.aFloat6323, this.anAbstractToolkit3654.aFloat6293, this.anAbstractToolkit3654.aFloat6365, 1.0F);
         idirect3ddevice.b(3, 96.0F + Math.abs(this.anAbstractToolkit3654.aFloatArray6292[1]) * 928.0F, 0.0F, 0.0F, 0.0F);
      }

      if (i > -84) {
         this.method3413(29);
      }
   }

   @Override
   final void method3413(int i) {
      if (this.aBoolean8155) {
         IDirect3DDevice idirect3ddevice = this.aD3DToolkit8158.anIDirect3DDevice9199;
         Class336_Sub1 class336_sub1 = this.aD3DToolkit8158.method1342(-47);
         Class336_Sub1 class336_sub1_0_ = this.aD3DToolkit8158.method1378(50);
         idirect3ddevice.a(0, class336_sub1_0_.method3881((byte)-104, aFloatArray8159));
         idirect3ddevice.a(4, class336_sub1.method3885(0, aFloatArray8159));
      }

      int i_1_ = -36 % ((i - -60) / 61);
   }

   @Override
   final void method3419(Interface13 interface13, int i, byte b) {
      if (b != 92) {
         this.method3414((byte)125);
      }
   }

   @Override
   final void method3411(int i) {
      if (this.aBoolean8155) {
         this.aD3DToolkit8158.method1384((byte)62, null);
         this.aD3DToolkit8158.method1386(-39, null);
         this.anAbstractToolkit3654.method1362(255, 1);
         this.anAbstractToolkit3654.method1312((byte)-21, null);
         this.anAbstractToolkit3654.method1362(i ^ -8485, 0);
         this.anAbstractToolkit3654.method1312((byte)-21, null);
         this.aBoolean8155 = false;
      }

      if (i != -8668) {
         this.method3415(true, -21, -31);
      }
   }

   @Override
   final void method3410(int i) {
      if (this.aBoolean8155) {
         IDirect3DDevice idirect3ddevice = this.aD3DToolkit8158.anIDirect3DDevice9199;
         Class336_Sub1 class336_sub1 = this.aD3DToolkit8158.method1378(50);
         idirect3ddevice.a(0, class336_sub1.method3881((byte)-117, aFloatArray8159));
      }

      if (i < 10) {
         this.aBoolean8153 = false;
      }
   }

   @Override
   final void method3417(boolean bool, boolean bool_2_) {
      if (bool_2_) {
         this.anIDirect3DVertexShader8157 = null;
      }
   }

   @Override
   final void method3415(boolean bool, int i, int i_3_) {
      if (this.aBoolean8155) {
         IDirect3DDevice idirect3ddevice = this.aD3DToolkit8158.anIDirect3DDevice9199;
         int i_4_ = 1 << (i & 3);
         float f = (float)(1 << (i >> 3 & 7)) / 32.0F;
         int i_5_ = i_3_ & 65535;
         float f_6_ = (float)(3 & i_3_ >> 16) / 8.0F;
         idirect3ddevice.a(14, (float)(i_4_ * this.anAbstractToolkit3654.anInt6332 % 40000) / 40000.0F, 0.0F, 0.0F, 0.0F);
         idirect3ddevice.a(15, f, 0.0F, 0.0F, 0.0F);
         idirect3ddevice.b(4, (float)i_5_, 0.0F, 0.0F, 0.0F);
         idirect3ddevice.b(5, f_6_, 0.0F, 0.0F, 0.0F);
      }

      if (!bool) {
         this.method3413(-43);
      }
   }

   @Override
   final void method3412(int i) {
      if (i != 0) {
         this.method3417(false, true);
      }

      if (this.aBoolean8155) {
         IDirect3DDevice idirect3ddevice = this.aD3DToolkit8158.anIDirect3DDevice9199;
         idirect3ddevice.a(8, this.anAbstractToolkit3654.method1361(aFloatArray8159, 7));
      }
   }

   @Override
   final void method3416(byte b) {
      if (this.aBoolean8155) {
         IDirect3DDevice idirect3ddevice = this.aD3DToolkit8158.anIDirect3DDevice9199;
         if (~this.anAbstractToolkit3654.anInt6355 < -1) {
            float f = this.anAbstractToolkit3654.aFloat6328;
            float f_7_ = this.anAbstractToolkit3654.aFloat6311;
            idirect3ddevice.a(16, f, 1.0F / (-f_7_ + f), 0.0F, 0.0F);
         } else {
            idirect3ddevice.a(16, 0.0F, 0.0F, 0.0F, 0.0F);
         }

         idirect3ddevice.b(
            0,
            (float)((this.anAbstractToolkit3654.anInt6276 & 16738988) >> 16) / 255.0F,
            (float)(0xFF & this.anAbstractToolkit3654.anInt6276 >> 8) / 255.0F,
            (float)(this.anAbstractToolkit3654.anInt6276 & 0xFF) / 255.0F,
            0.0F
         );
      }

      if (b != -56) {
         this.method3412(26);
      }
   }

   Class290_Sub10(D3DToolkit d3dtoolkit, Index class302, Class5 class5) {
      super(d3dtoolkit);
      this.aD3DToolkit8158 = d3dtoolkit;
      this.aClass5_8156 = class5;
      if (class302 != null
         && this.anAbstractToolkit3654.aBoolean6310
         && this.anAbstractToolkit3654.aBoolean6366
         && -258 >= ~(65535 & this.aD3DToolkit8158.aD3DCAPS9188.VertexShaderVersion)) {
         this.anIDirect3DVertexShader8157 = this.aD3DToolkit8158.anIDirect3DDevice9199.b(class302.method3529("dx", "environment_mapped_water_v", 1));
         this.anIDirect3DPixelShader8154 = this.aD3DToolkit8158.anIDirect3DDevice9199.a(class302.method3529("dx", "environment_mapped_water_f", 1));
         this.aBoolean8153 = this.anIDirect3DVertexShader8157 != null && this.anIDirect3DPixelShader8154 != null && this.aClass5_8156.method172(10103);
      } else {
         this.aBoolean8153 = false;
         this.anIDirect3DPixelShader8154 = null;
         this.anIDirect3DVertexShader8157 = null;
      }
   }

   @Override
   final boolean method3414(byte b) {
      if (b > -45) {
         this.anIDirect3DVertexShader8157 = null;
      }

      return this.aBoolean8153;
   }

   @Override
   final void method3421(boolean bool) {
      if (this.aBoolean8155) {
         IDirect3DDevice idirect3ddevice = this.aD3DToolkit8158.anIDirect3DDevice9199;
         Class336_Sub1 class336_sub1 = this.anAbstractToolkit3654.method1290((byte)86);
         idirect3ddevice.SetVertexShaderConstantF(12, class336_sub1.method3891(aFloatArray8159, true), 2);
      }

      if (bool) {
         this.aD3DToolkit8158 = null;
      }
   }
}
