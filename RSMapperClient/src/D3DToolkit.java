import jaclib.peer.ti;
import jagdx.D3DADAPTER_IDENTIFIER;
import jagdx.D3DCAPS;
import jagdx.D3DDISPLAYMODE;
import jagdx.D3DLIGHT;
import jagdx.D3DPRESENT_PARAMETERS;
import jagdx.GeometryBuffer;
import jagdx.IDirect3D;
import jagdx.IDirect3DDevice;
import jagdx.IDirect3DEventQuery;
import jagdx.IDirect3DPixelShader;
import jagdx.IDirect3DSurface;
import jagdx.IDirect3DVertexShader;
import jagdx.PixelBuffer;
import jagdx.lh;
import jagdx.sja;
import java.awt.Dimension;
import java.awt.Rectangle;

public class D3DToolkit extends AbstractToolkit {
   private D3DPRESENT_PARAMETERS aD3DPRESENT_PARAMETERS9178;
   private int[] anIntArray9179;
   private boolean[] aBooleanArray9180;
   private Class228[] aClass228Array9181;
   private int anInt9182;
   private D3DLIGHT aD3DLIGHT9183;
   protected GeometryBuffer aGeometryBuffer9184;
   private boolean aBoolean9185 = false;
   protected boolean aBoolean9186;
   protected PixelBuffer aPixelBuffer9187;
   protected D3DCAPS aD3DCAPS9188;
   private boolean[] aBooleanArray9189;
   private boolean[] aBooleanArray9190;
   private boolean[] aBooleanArray9191;
   private static int[] anIntArray9192 = new int[]{77, 80};
   private D3DLIGHT aD3DLIGHT9193;
   private int anInt9194;
   private static float[] aFloatArray9195 = new float[16];
   protected boolean aBoolean9196;
   private IDirect3DVertexShader anIDirect3DVertexShader9197;
   private static int[] anIntArray9198 = new int[]{22, 23};
   protected IDirect3DDevice anIDirect3DDevice9199;
   protected boolean aBoolean9200;
   protected ti aTi9201;
   private D3DLIGHT aD3DLIGHT9202;
   private Class322 aClass322_9203;
   private IDirect3D anIDirect3D9204;
   private int anInt9205 = 0;

   @Override
   final Interface13_Impl1 method1291(Class68 class68, Class372 class372, int i, int i_0_, int i_1_) {
      return new Class265_Sub3(this, class68, class372, i_0_, i);
   }

   @Override
   final Interface13_Impl3 method1262(Class68 class68, byte[] bs, byte b, int i, int i_3_, int i_4_) {
      return b != -57 ? null : new Class265_Sub1(this, class68, i_4_, i, i_3_, bs);
   }

   @Override
   final void method1309(int i) {
      if (i >= -101) {
         this.method1353(false);
      }
   }

   @Override
   final synchronized void e(int i) {
      this.aTi9201.c(-104);
      super.e(i);
   }

   @Override
   final void a(int i, int i_5_, int i_6_, int i_7_) {
   }

   final void method1384(byte b, IDirect3DVertexShader idirect3dvertexshader) {
      this.anIDirect3DVertexShader9197 = idirect3dvertexshader;
      this.anIDirect3DDevice9199.SetVertexShader(idirect3dvertexshader);
      this.method1310((byte)-113);
   }

   @Override
   final void method1265(java.awt.Canvas canvas, Object object, int i) {
      if (canvas == this.aCanvas6251) {
         Dimension dimension = canvas.getSize();
         if (-1 > ~dimension.width && dimension.height > 0) {
            this.anIDirect3DDevice9199.EndScene();
            this.method1389((byte)-12);
            this.anIDirect3DDevice9199.BeginScene();
         }
      }
   }

   private static final int method1385(Class94 class94, boolean bool) {
      if (class94 != Class117_Sub1.aClass94_4924) {
         if (class94 == Class116.aClass94_5075) {
            return 4;
         } else if (Class385.aClass94_4911 != class94) {
            if (class94 != UnderlayDefinition.aClass94_2898) {
               if (GameStub.aClass94_11 == class94) {
                  return 10;
               } else {
                  if (bool) {
                     anIntArray9198 = null;
                  }

                  throw new IllegalArgumentException();
               }
            } else {
               return 7;
            }
         } else {
            return 26;
         }
      } else {
         return 2;
      }
   }

   @Override
   final void method1354(int i, int i_9_, Interface15_Impl2 interface15_impl2) {
      if (i_9_ == 32011) {
         Class80 class80 = (Class80)interface15_impl2;
         this.anIDirect3DDevice9199.SetStreamSource(i, class80.anIDirect3DVertexBuffer9080, 0, class80.method793(i_9_ ^ -21317));
      }
   }

   final void method1386(int i, IDirect3DPixelShader idirect3dpixelshader) {
      this.anIDirect3DDevice9199.SetPixelShader(idirect3dpixelshader);
   }

   @Override
   final void v() {
   }

   @Override
   final Interface13_Impl2 method1287(int i, int[][] is, boolean bool, int i_11_) {
      if (i_11_ != 0) {
         this.aTi9201 = null;
      }

      return new Class265_Sub2(this, i, bool, is);
   }

   @Override
   final boolean method1377(Class372 class372, Class68 class68, byte b) {
      D3DDISPLAYMODE d3ddisplaymode = new D3DDISPLAYMODE();
      if (b != -72) {
         this.aBooleanArray9189 = null;
      }

      return lh.a((byte)75, this.anIDirect3D9204.a(this.anInt9194, d3ddisplaymode))
         && lh.a(
            (byte)89, this.anIDirect3D9204.CheckDeviceFormat(this.anInt9194, this.anInt9182, d3ddisplaymode.Format, 0, 4, method1396(class372, class68, -54))
         );
   }

   private D3DToolkit(
      int i,
      int i_12_,
      java.awt.Canvas canvas,
      ti var_ti,
      IDirect3D idirect3d,
      IDirect3DDevice idirect3ddevice,
      Class322 class322,
      D3DPRESENT_PARAMETERS d3dpresent_parameters,
      D3DCAPS d3dcaps,
      d var_d,
      Index class302,
      int i_13_
   ) {
      super(canvas, class322, var_d, class302, i_13_, 0);

      try {
         this.aD3DCAPS9188 = d3dcaps;
         this.anInt9182 = i_12_;
         this.anIDirect3D9204 = idirect3d;
         this.aD3DPRESENT_PARAMETERS9178 = d3dpresent_parameters;
         this.aClass322_9203 = class322;
         this.aTi9201 = var_ti;
         this.anIDirect3DDevice9199 = idirect3ddevice;
         this.anInt9194 = i;
         this.aD3DLIGHT9183 = new D3DLIGHT(this.aTi9201);
         this.aD3DLIGHT9202 = new D3DLIGHT(this.aTi9201);
         this.aD3DLIGHT9193 = new D3DLIGHT(this.aTi9201);
         this.aPixelBuffer9187 = new PixelBuffer(this.aTi9201);
         this.aGeometryBuffer9184 = new GeometryBuffer(this.aTi9201);
         new GeometryBuffer(this.aTi9201);
         this.anInt6370 = this.aD3DCAPS9188.MaxSimultaneousTextures;
         this.aBoolean9186 = -1 != ~(65536 & this.aD3DCAPS9188.TextureCaps);
         this.aBoolean9200 = (16384 & this.aD3DCAPS9188.TextureCaps) != 0;
         this.anInt6367 = this.aD3DCAPS9188.MaxActiveLights > 0 ? this.aD3DCAPS9188.MaxActiveLights : 8;
         this.aBoolean6310 = ~(this.aD3DCAPS9188.TextureCaps & 2048) != -1;
         this.aBoolean6366 = -1 != ~(this.aD3DCAPS9188.TextureCaps & 8192);
         this.aBoolean9196 = (2 & this.aD3DCAPS9188.TextureCaps) == 0;
         this.aBoolean6342 = this.anInt6319 > 0
            || -1
               == ~this.anIDirect3D9204.CheckDeviceMultiSampleType(this.anInt9194, this.anInt9182, this.aD3DPRESENT_PARAMETERS9178.BackBufferFormat, true, 2);
         this.anIntArray9179 = new int[this.anInt6370];
         this.aBooleanArray9180 = new boolean[this.anInt6370];
         this.aBooleanArray9190 = new boolean[this.anInt6370];
         this.aBooleanArray9189 = new boolean[this.anInt6370];
         this.aClass228Array9181 = new Class228[this.anInt6370];
         this.aBooleanArray9191 = new boolean[this.anInt6370];
         this.anIDirect3DDevice9199.BeginScene();
      } catch (Throwable var14) {
         var14.printStackTrace();
         this.method1233(-7751);
         throw new RuntimeException("");
      }
   }

   @Override
   final void a(Interface6 interface6) {
   }

   @Override
   final void d() {
   }

   @Override
   final boolean method1295(Class68 class68, Class372 class372, int i) {
      if (i != 1) {
         return true;
      } else {
         D3DDISPLAYMODE d3ddisplaymode = new D3DDISPLAYMODE();
         return lh.a((byte)98, this.anIDirect3D9204.a(this.anInt9194, d3ddisplaymode))
            && lh.a(
               (byte)58,
               this.anIDirect3D9204.CheckDeviceFormat(this.anInt9194, this.anInt9182, d3ddisplaymode.Format, 0, 3, method1396(class372, class68, -29))
            );
      }
   }

   @Override
   final Renderer c() {
      D3DADAPTER_IDENTIFIER d3dadapter_identifier = this.anIDirect3D9204.b(this.anInt9194, 0);
      return new Renderer(d3dadapter_identifier.VendorID, "Direct3D", 9, d3dadapter_identifier.Description, d3dadapter_identifier.DriverVersion);
   }

   @Override
   final void method1363(int i, byte b, Class135 class135, boolean bool) {
      int i_14_ = 0;
      int i_16_;
      if (i != 1) {
         if (~i != -3) {
            i_16_ = 5;
         } else {
            i_16_ = 27;
         }
      } else {
         i_16_ = 6;
      }

      if (b < 79) {
         this.aTi9201 = null;
      }

      if (bool) {
         i_14_ |= 16;
      }

      this.anIDirect3DDevice9199.SetTextureStageState(this.anInt6284, i_16_, i_14_ | method1390(class135, (byte)-86));
   }

   @Override
   final void method1308(byte b) {
      this.anIDirect3DDevice9199.a(28, this.aBoolean6338 && this.aBoolean6299 && -1 >= ~this.anInt6355);
      if (b < 74) {
         this.method1365(true, (byte)-67);
      }
   }

   @Override
   final void j() {
      IDirect3DEventQuery idirect3deventquery = this.anIDirect3DDevice9199.b();
      if (lh.a((byte)95, idirect3deventquery.Issue())) {
         while(true) {
            int i = idirect3deventquery.IsSignaled();
            if (i != 1) {
               break;
            }

            Thread.yield();
         }
      }

      idirect3deventquery.a((int)-65);
   }

   @Override
   final void method1302(int i) {
      this.anIDirect3DDevice9199.a(137, this.aBoolean6340 && !this.aBoolean6283);
      if (i != 1) {
         aFloatArray9195 = null;
      }
   }

   private static final boolean method1387(D3DPRESENT_PARAMETERS d3dpresent_parameters, int i, IDirect3D idirect3d, int k, int l, int i1) {
      int j1 = 0;
      int k1 = 0;

      try {
         if (i1 != 20644) {
            return false;
         } else {
            int l1 = 0;
            D3DDISPLAYMODE d3ddisplaymode = new D3DDISPLAYMODE();
            if (lh.a(idirect3d.a(i, d3ddisplaymode), true)) {
               return false;
            } else {
               label82:
               for(; ~l <= -1; --l) {
                  if (1 != l) {
                     l1 = 0 - -l;

                     for(int i2 = 0; ~i2 > ~anIntArray9198.length; ++i2) {
                        if (-1 == ~idirect3d.CheckDeviceType(i, k, d3ddisplaymode.Format, anIntArray9198[i2], true)
                           && -1 == ~idirect3d.CheckDeviceFormat(i, k, d3ddisplaymode.Format, 1, 1, anIntArray9198[i2])
                           && (-1 == ~l || -1 == ~idirect3d.CheckDeviceMultiSampleType(i, k, anIntArray9198[i2], true, l1))) {
                           for(int j2 = 0; ~anIntArray9192.length < ~j2; ++j2) {
                              if (idirect3d.CheckDeviceFormat(i, k, d3ddisplaymode.Format, 2, 1, anIntArray9192[j2]) == 0
                                 && idirect3d.CheckDepthStencilMatch(i, k, d3ddisplaymode.Format, anIntArray9198[i2], anIntArray9192[j2]) == 0
                                 && (l == 0 || ~idirect3d.CheckDeviceMultiSampleType(i, k, anIntArray9192[i2], true, l1) == -1)) {
                                 k1 = anIntArray9198[i2];
                                 j1 = anIntArray9192[j2];
                                 break label82;
                              }
                           }
                        }
                     }
                  }
               }

               if (l >= 0 && ~k1 != -1 && -1 != ~j1) {
                  d3dpresent_parameters.MultiSampleType = l1;
                  d3dpresent_parameters.BackBufferFormat = k1;
                  d3dpresent_parameters.AutoDepthStencilFormat = j1;
                  d3dpresent_parameters.MultiSampleQuality = 0;
                  return true;
               } else {
                  return false;
               }
            }
         }
      } catch (Throwable var12) {
         var12.printStackTrace();
         return false;
      }
   }

   @Override
   final Interface4 a(int i, int i_29_) {
      return null;
   }

   @Override
   final Interface13_Impl1 method1322(Class68 class68, boolean bool, int i, int i_30_, byte b, float[] fs, int i_31_, int i_32_) {
      if (b != 5) {
         this.j();
      }

      return null;
   }

   @Override
   final void b(int i, int i_33_, int i_34_, int i_35_, double d) {
   }

   private static final int method1388(int i, Class228 class228) {
      if (class228 != Node_Sub38_Sub5.aClass228_10123) {
         if (class228 == Class194.aClass228_2377) {
            return 1;
         } else {
            if (i <= 95) {
               aFloatArray9195 = null;
            }

            throw new IllegalArgumentException();
         }
      } else {
         return 2;
      }
   }

   @Override
   final Class290 method1311(int i, int i_36_) {
      if (i != -22838) {
         this.aBoolean9196 = false;
      }

      if (-4 != ~i_36_) {
         if (~i_36_ != -5) {
            return (Class290)(~i_36_ == -9 ? new Class290_Sub10(this, this.aClass302_6167, this.aClass5_6247) : super.method1311(-22838, i_36_));
         } else {
            return new Class290_Sub9(this, this.aClass302_6167, this.aClass5_6247);
         }
      } else {
         return new Class290_Sub8(this, this.aClass302_6167);
      }
   }

   private final boolean method1389(byte b) {
      int i = this.anIDirect3DDevice9199.TestCooperativeLevel();
      if (b != -12) {
         this.aD3DCAPS9188 = null;
      }

      if (~i == -1 || i == -2005530519) {
         Class322 class322 = (Class322)this.anObject6119;
         this.method1285(0);
         class322.method3803(-111);
         this.aD3DPRESENT_PARAMETERS9178.BackBufferWidth = 0;
         this.aD3DPRESENT_PARAMETERS9178.BackBufferHeight = 0;
         if (method1387(this.aD3DPRESENT_PARAMETERS9178, this.anInt9194, this.anIDirect3D9204, this.anInt9182, this.anInt6319, 20644)) {
            int i_38_ = this.anIDirect3DDevice9199.Reset(this.aD3DPRESENT_PARAMETERS9178);
            if (lh.a((byte)95, i_38_)) {
               class322.method3805(this.anIDirect3DDevice9199.c(), this.anIDirect3DDevice9199.b(0), (byte)106);
               this.method1325(b + 11);
               this.method1326(false);
               return true;
            }
         }
      }

      return false;
   }

   @Override
   final void method1300(int i) {
      if (i != 0) {
         this.aBoolean9200 = false;
      }

      this.anIDirect3DDevice9199.SetScissorRect(this.anInt6280 + this.anInt6295, this.anInt6325 + this.anInt6307, this.anInt6294, this.anInt6333);
   }

   @Override
   final void method1370(int i) {
      if (i >= -12) {
         aFloatArray9195 = null;
      }

      this.anIDirect3DDevice9199.a(14, this.aBoolean6275 && this.aBoolean6313);
   }

   static final GraphicsToolkit createToolkit(java.awt.Canvas canvas, d var_d, Index class302, Integer integer) {
      D3DToolkit d3dtoolkit = null;

      try {
         int i = 0;
         int i_40_ = 1;
         ti var_ti = new ti();
         IDirect3D idirect3d = IDirect3D.a(-2147483616, var_ti);
         D3DCAPS d3dcaps = idirect3d.a(i, i_40_);
         if ((16777216 & d3dcaps.RasterCaps) == 0) {
            throw new RuntimeException("");
         } else if (~d3dcaps.MaxSimultaneousTextures > -3) {
            throw new RuntimeException("");
         } else if (-1 == ~(d3dcaps.TextureOpCaps & 2)) {
            throw new RuntimeException("");
         } else if ((8 & d3dcaps.TextureOpCaps) == 0) {
            throw new RuntimeException("");
         } else if (-1 == ~(d3dcaps.TextureOpCaps & 64)) {
            throw new RuntimeException("");
         } else if ((512 & d3dcaps.TextureOpCaps) == 0) {
            throw new RuntimeException("");
         } else if ((33554432 & d3dcaps.TextureOpCaps) == 0) {
            throw new RuntimeException("");
         } else if ((16 & d3dcaps.DestBlendCaps & d3dcaps.SrcBlendCaps) == 0) {
            throw new RuntimeException("");
         } else if ((d3dcaps.SrcBlendCaps & d3dcaps.DestBlendCaps & 32) == 0) {
            throw new RuntimeException("");
         } else if ((2 & d3dcaps.DestBlendCaps & d3dcaps.SrcBlendCaps) == 0) {
            throw new RuntimeException("");
         } else if (-1 > ~d3dcaps.MaxActiveLights && 2 > d3dcaps.MaxActiveLights) {
            throw new RuntimeException("");
         } else if (~d3dcaps.MaxStreams > -6) {
            throw new RuntimeException("");
         } else {
            D3DPRESENT_PARAMETERS d3dpresent_parameters = new D3DPRESENT_PARAMETERS(canvas);
            if (!method1387(d3dpresent_parameters, i, idirect3d, i_40_, integer, 20644)) {
               throw new RuntimeException("");
            } else {
               d3dpresent_parameters.EnableAutoDepthStencil = true;
               d3dpresent_parameters.Windowed = true;
               d3dpresent_parameters.PresentationInterval = Integer.MIN_VALUE;
               int i_41_ = 2;
               if (~(1048576 & d3dcaps.DevCaps) != -1) {
                  i_41_ |= 16;
               }

               IDirect3DDevice idirect3ddevice;
               try {
                  idirect3ddevice = idirect3d.a(i, i_40_, canvas, 64 | i_41_, d3dpresent_parameters);
               } catch (sja var15) {
                  idirect3ddevice = idirect3d.a(i, i_40_, canvas, i_41_ | 32, d3dpresent_parameters);
               }

               Class322 class322 = new Class322(idirect3ddevice.b(0), idirect3ddevice.c());
               d3dtoolkit = new D3DToolkit(
                  i, i_40_, canvas, var_ti, idirect3d, idirect3ddevice, class322, d3dpresent_parameters, d3dcaps, var_d, class302, integer
               );
               d3dtoolkit.method1358(106);
               return d3dtoolkit;
            }
         }
      } catch (RuntimeException var16) {
         if (d3dtoolkit != null) {
            d3dtoolkit.u();
         }

         throw var16;
      }
   }

   @Override
   final void method1259(int i) {
      if (i < 85) {
         this.anIDirect3D9204 = null;
      }

      if (Class47.aClass26_688 == this.aClass26_6301) {
         this.anIDirect3DDevice9199.SetRenderState(19, 5);
         this.anIDirect3DDevice9199.SetRenderState(20, 6);
      } else if (this.aClass26_6301 != Class339_Sub3.aClass26_8664) {
         if (this.aClass26_6301 == Node_Sub15_Sub7.aClass26_9827) {
            this.anIDirect3DDevice9199.SetRenderState(19, 9);
            this.anIDirect3DDevice9199.SetRenderState(20, 2);
         }
      } else {
         this.anIDirect3DDevice9199.SetRenderState(19, 2);
         this.anIDirect3DDevice9199.SetRenderState(20, 2);
      }
   }

   @Override
   final void method1263(boolean bool) {
      if (bool) {
         anIntArray9192 = null;
      }

      int i = !this.aBooleanArray9191[this.anInt6284] ? 1 : method1385(this.aClass94Array6351[this.anInt6284], bool);
      this.anIDirect3DDevice9199.SetTextureStageState(this.anInt6284, 1, i);
   }

   @Override
   final void u() {
      this.aTi9201.b(-23417);
      super.u();
   }

   @Override
   final int I() {
      return 0;
   }

   private static final int method1390(Class135 class135, byte b) {
      if (b != -86) {
         return 50;
      } else if (class135 == Class106.aClass135_1354) {
         return 2;
      } else if (class135 == Class115.aClass135_1465) {
         return 0;
      } else if (class135 == Class200_Sub1.aClass135_5139) {
         return 1;
      } else if (class135 == InterfaceSettings.aClass135_7421) {
         return 3;
      } else {
         throw new IllegalArgumentException();
      }
   }

   @Override
   final Interface15_Impl1 method1346(boolean bool, byte b) {
      return b != 102 ? null : new Class8(this, Class372.aClass372_4595, bool);
   }

   @Override
   final void method1261(byte b) {
      this.anIDirect3DDevice9199.SetViewport(this.anInt6280, this.anInt6307, this.anInt6239, this.anInt6124, 0.0F, 1.0F);
      if (b != -18) {
         this.aBooleanArray9190 = null;
      }
   }

   private static final int method1391(int i, Class346 class346) {
      if (class346 == Animator.aClass346_252) {
         return 1;
      } else if (BufferedConnection.aClass346_615 == class346) {
         return 2;
      } else if (Class55.aClass346_829 != class346) {
         if (Class262_Sub16.aClass346_7824 == class346) {
            return 4;
         } else if (class346 == Node_Sub15_Sub9.aClass346_9842) {
            return 256;
         } else {
            if (i != 0) {
               anIntArray9192 = null;
            }

            return 0;
         }
      } else {
         return 3;
      }
   }

   @Override
   final Interface20 d(int i, int i_42_) {
      return null;
   }

   @Override
   final int[] na(int i, int i_43_, int i_44_, int i_45_) {
      int[] is = null;
      IDirect3DSurface idirect3dsurface = this.anIDirect3DDevice9199.c(0);
      IDirect3DSurface idirect3dsurface_46_ = this.anIDirect3DDevice9199.a(i_44_, i_45_, 21, 0, 0, true);
      if (lh.a((byte)78, this.anIDirect3DDevice9199.StretchRect(idirect3dsurface, i, i_43_, i_44_, i_45_, idirect3dsurface_46_, 0, 0, i_44_, i_45_, 0))
         && lh.a((byte)65, idirect3dsurface_46_.LockRect(0, 0, i_44_, i_45_, 16, this.aPixelBuffer9187))) {
         is = new int[i_44_ * i_45_];
         int i_47_ = this.aPixelBuffer9187.getRowPitch();
         if (i_47_ == 4 * i_44_) {
            this.aPixelBuffer9187.a(is, 0, 0, i_45_ * i_44_);
         } else {
            for(int i_48_ = 0; ~i_45_ < ~i_48_; ++i_48_) {
               this.aPixelBuffer9187.a(is, i_44_ * i_48_, i_48_ * i_47_, i_44_);
            }
         }

         idirect3dsurface_46_.UnlockRect();
      }

      idirect3dsurface.a((int)-90);
      idirect3dsurface_46_.a(104);
      return is;
   }

   @Override
   final Object method1351(java.awt.Canvas canvas, int i) {
      if (i > -70) {
         this.j();
      }

      return null;
   }

   @Override
   final void method1326(boolean bool) {
      for(int i = 0; ~this.anInt6370 < ~i; ++i) {
         this.anIDirect3DDevice9199.SetSamplerState(i, 7, 0);
         this.anIDirect3DDevice9199.SetSamplerState(i, 6, 2);
         this.anIDirect3DDevice9199.SetSamplerState(i, 5, 2);
         this.anIDirect3DDevice9199.SetSamplerState(i, 1, 1);
         this.anIDirect3DDevice9199.SetSamplerState(i, 2, 1);
         this.aClass228Array9181[i] = Node_Sub38_Sub5.aClass228_10123;
         this.aBooleanArray9190[i] = this.aBooleanArray9189[i] = true;
         this.aBooleanArray9180[i] = false;
         this.anIntArray9179[i] = 0;
      }

      this.anIDirect3DDevice9199.SetTextureStageState(0, 6, 1);
      this.anIDirect3DDevice9199.SetRenderState(9, 2);
      this.anIDirect3DDevice9199.SetRenderState(23, 4);
      this.anIDirect3DDevice9199.SetRenderState(25, 5);
      this.anIDirect3DDevice9199.SetRenderState(24, 0);
      this.anIDirect3DDevice9199.SetRenderState(22, 2);
      this.anIDirect3DDevice9199.SetRenderState(147, 1);
      this.anIDirect3DDevice9199.SetRenderState(145, 1);
      this.anIDirect3DDevice9199.a(38, 0.95F);
      this.anIDirect3DDevice9199.SetRenderState(140, 3);
      this.aD3DLIGHT9183.SetType(3);
      this.aD3DLIGHT9202.SetType(3);
      this.aD3DLIGHT9193.SetType(1);
      this.aBoolean9185 = bool;
      super.method1326(bool);
   }

   @Override
   final void F(int i, int i_49_) {
   }

   @Override
   final Interface13_Impl1 method1367(int i, int i_50_, int[] is, int i_51_, int i_52_, boolean bool, int i_53_) {
      return i != -6331 ? null : new Class265_Sub3(this, i_50_, i_53_, bool, is, i_51_, i_52_);
   }

   @Override
   final void method1289(boolean bool) {
      float f = !this.aBoolean6306 ? 0.0F : this.aFloat6274;
      float f_54_ = this.aBoolean6306 ? -this.aFloat6272 : 0.0F;
      this.aD3DLIGHT9183.SetDiffuse(f * this.aFloat6323, this.aFloat6293 * f, this.aFloat6365 * f, 0.0F);
      this.aD3DLIGHT9202.SetDiffuse(this.aFloat6323 * f_54_, f_54_ * this.aFloat6293, this.aFloat6365 * f_54_, 0.0F);
      this.aBoolean9185 = bool;
   }

   @Override
   final void method1374(byte b) {
      this.aFloat6328 = (float)(this.anInt6335 - this.anInt6372);
      this.aFloat6311 = (float)(-this.anInt6355) + this.aFloat6328;
      if (this.aFloat6311 < (float)this.anInt6364) {
         this.aFloat6311 = (float)this.anInt6364;
      }

      this.anIDirect3DDevice9199.a(36, this.aFloat6311);
      this.anIDirect3DDevice9199.a(37, this.aFloat6328);
      this.anIDirect3DDevice9199.SetRenderState(34, this.anInt6276);
   }

   @Override
   final void method1284(int i) {
      this.anIDirect3DDevice9199.a(15, this.aBoolean6279);
      if (i != 14) {
         this.method1389((byte)-115);
      }
   }

   @Override
   final void method1269(byte b) {
      if (b <= 2) {
         this.aBooleanArray9189 = null;
      }

      this.anIDirect3DDevice9199.a(27, this.aBoolean6330);
   }

   @Override
   final void h() {
   }

   @Override
   final void method1360(byte b) {
      if (this.aBoolean6261) {
         aFloatArray9195[9] = 0.0F;
         aFloatArray9195[2] = 0.0F;
         aFloatArray9195[7] = 0.0F;
         aFloatArray9195[15] = 1.0F;
         aFloatArray9195[11] = 0.0F;
         aFloatArray9195[1] = 0.0F;
         aFloatArray9195[6] = 0.0F;
         aFloatArray9195[14] = 0.0F;
         aFloatArray9195[3] = 0.0F;
         aFloatArray9195[12] = 0.0F;
         aFloatArray9195[8] = 0.0F;
         aFloatArray9195[13] = 0.0F;
         aFloatArray9195[0] = 1.0F;
         aFloatArray9195[5] = 1.0F;
         aFloatArray9195[10] = 1.0F;
         aFloatArray9195[4] = 0.0F;
      } else {
         this.aClass336_Sub1_6262.method3884(true, aFloatArray9195);
      }

      this.anIDirect3DDevice9199.SetTransform(256, aFloatArray9195);
      if (b < 36) {
         this.aBooleanArray9191 = null;
      }
   }

   @Override
   final void a(float f, float f_55_, float f_56_) {
   }

   @Override
   final void method1365(boolean bool, byte b) {
      this.anIDirect3DDevice9199.a(161, bool);
      if (b > -112) {
         this.ya();
      }
   }

   @Override
   final void method1310(byte b) {
      if (this.anIDirect3DVertexShader9197 == null && Class119.aClass346_1515 != this.aClass346Array6343[this.anInt6284]) {
         if (this.aClass346Array6343[this.anInt6284] != BufferedConnection.aClass346_615) {
            this.anIDirect3DDevice9199.SetTransform(16 + this.anInt6284, this.aClass336_Sub1Array6327[this.anInt6284].method3884(true, aFloatArray9195));
         } else {
            this.anIDirect3DDevice9199.SetTransform(16 + this.anInt6284, this.aClass336_Sub1Array6327[this.anInt6284].method3874(5, aFloatArray9195));
         }

         int i = method1391(0, this.aClass346Array6343[this.anInt6284]);
         if (~i != ~this.anIntArray9179[this.anInt6284]) {
            this.anIDirect3DDevice9199.SetTextureStageState(this.anInt6284, 24, i);
            this.anIntArray9179[this.anInt6284] = i;
         }
      } else {
         this.anIDirect3DDevice9199.SetTextureStageState(this.anInt6284, 24, 0);
         this.anIntArray9179[this.anInt6284] = 0;
      }

      if (b != -113) {
         method1396(null, null, -128);
      }
   }

   @Override
   final void ya() {
      this.method1307(-117, true);
      this.anIDirect3DDevice9199.Clear(2, 0, 1.0F, 0);
   }

   @Override
   final Class213 method1372(byte b, Class207[] class207s) {
      if (b >= -118) {
         this.aD3DCAPS9188 = null;
      }

      return new dxVertexLayout(this, class207s);
   }

   @Override
   final Interface13_Impl1 method1327(Class68 class68, int i, boolean bool, int i_57_, int i_58_, int i_59_, boolean bool_60_, byte[] bs) {
      if (!bool_60_) {
         this.method1363(-92, (byte)-104, null, false);
      }

      return new Class265_Sub3(this, class68, i, i_59_, bool, bs, i_57_, i_58_);
   }

   @Override
   final Interface6 a(Interface4 interface4, Interface20 interface20) {
      return null;
   }

   @Override
   final void b(boolean bool) {
   }

   @Override
   final float method1379(int i) {
      if (i < 62) {
         this.aD3DLIGHT9193 = null;
      }

      return -0.5F;
   }

   @Override
   final void e(int i, int i_61_) throws Exception_Sub1 {
      this.anIDirect3DDevice9199.EndScene();
      if (!this.aClass322_9203.method3806(0)) {
         if (++this.anInt9205 > 50) {
            throw new Exception_Sub1();
         }

         this.method1389((byte)-12);
      } else {
         this.anInt9205 = 0;
         if (lh.a(this.aClass322_9203.method3804(0, (byte)21), true)) {
            this.method1389((byte)-12);
         }
      }

      this.anIDirect3DDevice9199.BeginScene();
   }

   final void method1392(int i, Class265_Sub3 class265_sub3) {
      this.method1395(class265_sub3, i ^ 127);
      if (!class265_sub3.aBoolean7907 != !this.aBooleanArray9190[this.anInt6284]) {
         this.anIDirect3DDevice9199.SetSamplerState(this.anInt6284, 1, class265_sub3.aBoolean7907 ? 1 : 3);
         this.aBooleanArray9190[this.anInt6284] = class265_sub3.aBoolean7907;
      }

      if (i != 2) {
         this.aPixelBuffer9187 = null;
      }

      if (class265_sub3.aBoolean7904 == !this.aBooleanArray9189[this.anInt6284]) {
         this.anIDirect3DDevice9199.SetSamplerState(this.anInt6284, 2, !class265_sub3.aBoolean7904 ? 3 : 1);
         this.aBooleanArray9189[this.anInt6284] = class265_sub3.aBoolean7904;
      }
   }

   @Override
   final boolean m() {
      return false;
   }

   @Override
   final void method1337(int i) {
      if (i == 6) {
         this.anIDirect3DDevice9199.SetRenderState(60, this.anInt6318);
      }
   }

   @Override
   final void method1319(Object object, java.awt.Canvas canvas, int i) {
      if (i != -30190) {
         this.method1346(false, (byte)25);
      }

      this.aClass322_9203 = (Class322)object;
   }

   @Override
   final void method1353(boolean bool) {
      this.aD3DLIGHT9183.SetAmbient(this.aFloat6300 * this.aFloat6323, this.aFloat6300 * this.aFloat6293, this.aFloat6365 * this.aFloat6300, 0.0F);
      this.aBoolean9185 = bool;
   }

   @Override
   final void method1340(byte b) {
      this.anIDirect3DDevice9199.a(7, this.aBoolean6277);
   }

   @Override
   final void method1251(byte b) {
      if (b <= 59) {
         this.aClass228Array9181 = null;
      }

      if (this.aBooleanArray9191[this.anInt6284]) {
         this.aBooleanArray9191[this.anInt6284] = false;
         this.anIDirect3DDevice9199.SetTexture(this.anInt6284, null);
         this.method1254(true);
         this.method1263(false);
      }
   }

   @Override
   final void method1303(Class104 class104, int i, int i_62_, int i_63_) {
      if (i < 2) {
         this.method1338(null, -36);
      }

      this.anIDirect3DDevice9199.DrawPrimitive(method1393(107, class104), i_62_, i_63_);
   }

   @Override
   final void method1273(int i) {
      int i_64_;
      for(i_64_ = 0; this.anInt6358 > i_64_; ++i_64_) {
         Node_Sub29 node_sub29 = this.aNode_Sub29Array6345[i_64_];
         int i_65_ = 2 + i_64_;
         int i_66_ = node_sub29.getColor((byte)113);
         float f = node_sub29.method2707(1) / 255.0F;
         this.aD3DLIGHT9193.SetPosition((float)node_sub29.getReferenceX(32311), (float)node_sub29.getHeight(30), (float)node_sub29.getReferenceY(27433));
         this.aD3DLIGHT9193.SetDiffuse((float)(0xFF & i_66_ >> 16) * f, f * (float)(0xFF & i_66_ >> 8), f * (float)(0xFF & i_66_), 0.0F);
         this.aD3DLIGHT9193.SetAttenuation(0.0F, 0.0F, 1.0F / (float)(node_sub29.getFlickerType(123) * node_sub29.getFlickerType(125)));
         this.aD3DLIGHT9193.SetRange((float)node_sub29.getFlickerType(119));
         this.anIDirect3DDevice9199.SetLight(i_65_, this.aD3DLIGHT9193);
         this.anIDirect3DDevice9199.LightEnable(i_65_, true);
      }

      if (i > -20) {
         this.m();
      }

      while(~this.anInt6356 < ~i_64_) {
         this.anIDirect3DDevice9199.LightEnable(2 + i_64_, false);
         ++i_64_;
      }

      super.method1273(-69);
   }

   @Override
   final void f() {
   }

   @Override
   final void method1282(int i) {
      if (i != 0) {
         this.method1308((byte)8);
      }

      this.anIDirect3DDevice9199.a(174, this.aBoolean6387);
   }

   @Override
   final void GA(int i) {
      this.anIDirect3DDevice9199.Clear(1, i, 0.0F, 0);
   }

   @Override
   final Interface15_Impl2 method1380(int i, boolean bool) {
      if (i != 2) {
         this.anIDirect3D9204 = null;
      }

      return new Class80(this, bool);
   }

   @Override
   final void method1321(byte b, Class139 class139) {
      int i = 0;
      if (Class191.aClass139_2349 != class139) {
         if (class139 == IsaacCipher.aClass139_1829) {
            i = 131072;
         } else if (class139 == Class168.aClass139_2042) {
            i = 196608;
         }
      } else {
         i = 65536;
      }

      if (b == 102) {
         this.anIDirect3DDevice9199.SetTextureStageState(this.anInt6284, 11, this.anInt6284 | i);
      }
   }

   @Override
   final void method1293(int i) {
      if (i <= 114) {
         this.j();
      }

      if (this.aClass56_6303.method566(108)) {
         this.aClass336_Sub1_6269.method3884(true, aFloatArray9195);
      } else {
         aFloatArray9195[3] = 0.0F;
         aFloatArray9195[8] = 0.0F;
         aFloatArray9195[15] = 1.0F;
         aFloatArray9195[12] = 0.0F;
         aFloatArray9195[11] = 0.0F;
         aFloatArray9195[13] = 0.0F;
         aFloatArray9195[14] = 0.0F;
         aFloatArray9195[1] = 0.0F;
         aFloatArray9195[4] = 0.0F;
         aFloatArray9195[5] = 1.0F;
         aFloatArray9195[0] = 1.0F;
         aFloatArray9195[6] = 0.0F;
         aFloatArray9195[7] = 0.0F;
         aFloatArray9195[9] = 0.0F;
         aFloatArray9195[10] = 1.0F;
         aFloatArray9195[2] = 0.0F;
      }

      this.anIDirect3DDevice9199.SetTransform(2, aFloatArray9195);
   }

   private static final int method1393(int i, Class104 class104) {
      if (StandardSprite.aClass104_8926 == class104) {
         return 2;
      } else if (Class263.aClass104_3337 != class104) {
         if (class104 == Mobile_Sub1.aClass104_10947) {
            return 1;
         } else if (Class55.aClass104_833 == class104) {
            return 4;
         } else if (class104 == Class169_Sub3.aClass104_8818) {
            return 6;
         } else if (Node_Sub15_Sub2.aClass104_9779 == class104) {
            return 5;
         } else {
            throw new IllegalArgumentException("");
         }
      } else {
         return 3;
      }
   }

   @Override
   final void method1333(boolean bool) {
      if (!this.aBoolean9185) {
         this.anIDirect3DDevice9199.LightEnable(0, false);
         this.anIDirect3DDevice9199.LightEnable(1, false);
         this.anIDirect3DDevice9199.SetLight(0, this.aD3DLIGHT9183);
         this.anIDirect3DDevice9199.SetLight(1, this.aD3DLIGHT9202);
         this.anIDirect3DDevice9199.LightEnable(0, true);
         this.anIDirect3DDevice9199.LightEnable(1, true);
         this.aBoolean9185 = true;
      }

      if (bool) {
         this.aClass322_9203 = null;
      }
   }

   @Override
   final void a(Rectangle[] rectangles, int i, int i_68_, int i_69_) throws Exception_Sub1 {
      this.e(i_68_, i_69_);
   }

   @Override
   final void method1382(int i) {
      this.aD3DLIGHT9183.SetDirection(-this.aFloatArray6292[0], -this.aFloatArray6292[1], -this.aFloatArray6292[2]);
      this.aD3DLIGHT9202.SetDirection(-this.aFloatArray6304[0], -this.aFloatArray6304[1], -this.aFloatArray6304[2]);
      this.aBoolean9185 = false;
   }

   final void method1394(Class265_Sub1 class265_sub1, int i) {
      this.method1395(class265_sub1, 125);
      if (!this.aBooleanArray9190[this.anInt6284]) {
         this.anIDirect3DDevice9199.SetSamplerState(this.anInt6284, 1, 1);
         this.aBooleanArray9190[this.anInt6284] = true;
      }

      if (!this.aBooleanArray9189[this.anInt6284]) {
         this.anIDirect3DDevice9199.SetSamplerState(this.anInt6284, 2, 1);
         this.aBooleanArray9189[this.anInt6284] = true;
      }

      if (i != 1) {
         this.anIDirect3DVertexShader9197 = null;
      }
   }

   @Override
   final void method1279(int i, byte b) {
      if (b != -15) {
         this.method1380(78, true);
      }

      this.anIDirect3DDevice9199.SetTextureStageState(this.anInt6284, 11, i);
   }

   @Override
   final void method1334(int i) {
      this.anIDirect3DDevice9199.SetTransform(3, this.aFloatArray6314);
   }

   @Override
   final void method1276(int i, byte b, int i_72_, Interface15_Impl1 interface15_impl1, int i_73_, Class104 class104, int i_74_) {
      this.anIDirect3DDevice9199.SetIndices(((Class8)interface15_impl1).anIDirect3DIndexBuffer9089);
      this.anIDirect3DDevice9199.DrawIndexedPrimitive(method1393(-89, class104), 0, i, i_73_, i_72_, i_74_);
      if (b > -66) {
         this.anIDirect3DDevice9199 = null;
      }
   }

   @Override
   final boolean w() {
      return false;
   }

   @Override
   final void method1338(Class213 class213, int i) {
      dxVertexLayout var_dxVertexLayout = (dxVertexLayout)class213;
      this.anIDirect3DDevice9199.SetVertexDeclaration(var_dxVertexLayout.anIDirect3DVertexDeclaration6910);
      if (i != 9422) {
         this.anInt9194 = 55;
      }
   }

   final void method1395(Class265 class265, int i) {
      this.anIDirect3DDevice9199.SetTexture(this.anInt6284, class265.method3232(-121));
      if (class265.aClass228_3363 == this.aClass228Array9181[this.anInt6284]) {
         if (!class265.aBoolean3364 == this.aBooleanArray9180[this.anInt6284]) {
            this.anIDirect3DDevice9199.SetSamplerState(this.anInt6284, 7, !class265.aBoolean3364 ? 0 : method1388(97, class265.aClass228_3363));
            this.aBooleanArray9180[this.anInt6284] = class265.aBoolean3364;
         }
      } else {
         int i_75_ = method1388(105, class265.aClass228_3363);
         this.anIDirect3DDevice9199.SetSamplerState(this.anInt6284, 6, i_75_);
         this.anIDirect3DDevice9199.SetSamplerState(this.anInt6284, 5, i_75_);
         this.aClass228Array9181[this.anInt6284] = class265.aClass228_3363;
         if (!class265.aBoolean3364 == this.aBooleanArray9180[this.anInt6284]) {
            this.anIDirect3DDevice9199.SetSamplerState(this.anInt6284, 7, !class265.aBoolean3364 ? 0 : method1388(102, class265.aClass228_3363));
            this.aBooleanArray9180[this.anInt6284] = class265.aBoolean3364;
         }
      }

      if (i < 124) {
         this.method1351(null, -39);
      }

      if (!this.aBooleanArray9191[this.anInt6284]) {
         this.aBooleanArray9191[this.anInt6284] = true;
         this.method1254(true);
         this.method1263(false);
      }
   }

   @Override
   final void method1275(int i, java.awt.Canvas canvas, Object object) {
      if (i > -61) {
         this.method1377(null, null, (byte)101);
      }
   }

   @Override
   final Class270 a(Class270 class270, Class270 class270_76_, float f, Class270 class270_77_) {
      return f < 0.5F ? class270 : class270_76_;
   }

   @Override
   final void method1349(Class135 class135, byte b, boolean bool, boolean bool_78_, int i) {
      if (b != 19) {
         this.method1351(null, 6);
      }

      int i_80_;
      if (i != 1) {
         if (~i != -3) {
            i_80_ = 2;
         } else {
            i_80_ = 26;
         }
      } else {
         i_80_ = 3;
      }

      int i_81_ = 0;
      if (bool) {
         i_81_ |= 32;
      }

      if (bool_78_) {
         i_81_ |= 16;
      }

      this.anIDirect3DDevice9199.SetTextureStageState(this.anInt6284, i_80_, method1390(class135, (byte)-86) | i_81_);
   }

   @Override
   final void method1313(byte b) {
      if (b == 108) {
         this.method1289(false);
         this.method1333(false);
      }
   }

   @Override
   final void method1254(boolean bool) {
      int i = !this.aBooleanArray9191[this.anInt6284] ? 1 : method1385(this.aClass94Array6296[this.anInt6284], false);
      this.anIDirect3DDevice9199.SetTextureStageState(this.anInt6284, 4, i);
      if (!bool) {
         this.method1311(-59, -38);
      }
   }

   static final int method1396(Class372 class372, Class68 class68, int i) {
      if (i > -23) {
         return 83;
      } else {
         if (Class372.aClass372_4594 == class372) {
            if (CacheNode_Sub19.aClass68_9621 == class68) {
               return 22;
            }

            if (class68 == Class99.aClass68_1290) {
               return 21;
            }

            if (class68 == Node_Sub52.aClass68_7639) {
               return 28;
            }

            if (class68 == Class188_Sub2.aClass68_6875) {
               return 50;
            }

            if (class68 == RenderDefinitions.aClass68_3268) {
               return 51;
            }

            if (Class262_Sub15_Sub1.aClass68_10521 == class68) {
               return 77;
            }
         }

         throw new IllegalArgumentException("");
      }
   }
}
