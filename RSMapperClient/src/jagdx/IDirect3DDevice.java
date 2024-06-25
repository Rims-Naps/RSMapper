package jagdx;

import jaclib.peer.IUnknown;
import jaclib.peer.ti;

public class IDirect3DDevice extends IUnknown {
   private static float[] c = new float[4];
   private ti b;

   public final native int SetLight(int var1, D3DLIGHT var2);

   public final native int SetPixelShaderConstantF(int var1, float[] var2, int var3);

   private final native int _GetDepthStencilSurface(IDirect3DSurface var1);

   public final IDirect3DPixelShader a(byte[] bs) {
      if (bs == null) {
         return null;
      } else {
         IDirect3DPixelShader idirect3dpixelshader = new IDirect3DPixelShader(this.b);
         int i = this._CreatePixelShader(bs, idirect3dpixelshader);
         if (lh.a(i, true)) {
            throw new sja(String.valueOf(i));
         } else {
            return idirect3dpixelshader;
         }
      }
   }

   public final native int SetTextureStageState(int var1, int var2, int var3);

   private final native int _CreateEventQuery(IDirect3DEventQuery var1);

   private final native int _CreateDepthStencilSurface(int var1, int var2, int var3, int var4, int var5, boolean var6, IDirect3DSurface var7);

   public final IDirect3DVertexBuffer a(int i, int i_7_, int i_8_, int i_9_, IDirect3DVertexBuffer idirect3dvertexbuffer) {
      if (idirect3dvertexbuffer != null) {
         idirect3dvertexbuffer.a((int)-117);
      } else {
         idirect3dvertexbuffer = new IDirect3DVertexBuffer(this.b);
      }

      int i_10_ = this._CreateVertexBuffer(i, i_7_, i_8_, i_9_, idirect3dvertexbuffer);
      if (lh.a(i_10_, true)) {
         throw new sja(String.valueOf(i_10_));
      } else {
         idirect3dvertexbuffer.b = i;
         return idirect3dvertexbuffer;
      }
   }

   private final native int _GetSwapChain(int var1, IDirect3DSwapChain var2);

   public final int a(int i, float f) {
      return this.SetRenderStatef(i, f);
   }

   public final IDirect3DSurface c() {
      IDirect3DSurface idirect3dsurface = new IDirect3DSurface(this.b);
      int i = this._GetDepthStencilSurface(idirect3dsurface);
      if (lh.a(i, true)) {
         throw new sja(String.valueOf(i));
      } else {
         return idirect3dsurface;
      }
   }

   public final native int SetRenderState(int var1, int var2);

   public final IDirect3DTexture a(int i, int i_12_, int i_13_, int i_14_, int i_15_, int i_16_) {
      IDirect3DTexture idirect3dtexture = new IDirect3DTexture(this.b);
      int i_17_ = this._CreateTexture(i, i_12_, i_13_, i_14_, i_15_, i_16_, idirect3dtexture);
      if (lh.a(i_17_, true)) {
         throw new sja(String.valueOf(i_17_));
      } else {
         return idirect3dtexture;
      }
   }

   public final native boolean LightEnable(int var1, boolean var2);

   public final native int SetTransform(int var1, float[] var2);

   private final native int _GetBackBuffer(int var1, int var2, int var3, IDirect3DSurface var4);

   public final IDirect3DCubeTexture a(int i, int i_20_, int i_21_, int i_22_, int i_23_) {
      IDirect3DCubeTexture idirect3dcubetexture = new IDirect3DCubeTexture(this.b);
      int i_24_ = this._CreateCubeTexture(i, i_20_, i_21_, i_22_, i_23_, idirect3dcubetexture);
      if (lh.a(i_24_, true)) {
         throw new sja(String.valueOf(i_24_));
      } else {
         return idirect3dcubetexture;
      }
   }

   private final native int _CreateIndexBuffer(int var1, int var2, int var3, int var4, IDirect3DIndexBuffer var5);

   private final native int SetRenderStatef(int var1, float var2);

   public final native int DrawIndexedPrimitive(int var1, int var2, int var3, int var4, int var5, int var6);

   public final native int _CreateTexture(int var1, int var2, int var3, int var4, int var5, int var6, IDirect3DTexture var7);

   public final IDirect3DVolumeTexture a(int i, int i_38_, int i_39_, int i_40_, int i_41_, int i_42_, int i_43_) {
      IDirect3DVolumeTexture idirect3dvolumetexture = new IDirect3DVolumeTexture(this.b);
      int i_44_ = this._CreateVolumeTexture(i, i_38_, i_39_, i_40_, i_41_, i_42_, i_43_, idirect3dvolumetexture);
      if (lh.a(i_44_, true)) {
         throw new sja(String.valueOf(i_44_));
      } else {
         return idirect3dvolumetexture;
      }
   }

   public final native int SetSamplerState(int var1, int var2, int var3);

   IDirect3DDevice(ti var_ti) {
      super(var_ti);
      this.b = var_ti;
   }

   public final int a(int i, float f, float f_47_, float f_48_, float f_49_) {
      c[1] = f_47_;
      c[2] = f_48_;
      c[0] = f;
      c[3] = f_49_;
      return this.SetVertexShaderConstantF(i, c, 1);
   }

   private final native int SetRenderStateb(int var1, boolean var2);

   public final native int _CreatePixelShader(byte[] var1, IDirect3DPixelShader var2);

   public final native int SetVertexShaderConstantF(int var1, float[] var2, int var3);

   public final native int Reset(D3DPRESENT_PARAMETERS var1);

   public final native int SetStreamSource(int var1, IDirect3DVertexBuffer var2, int var3, int var4);

   public final IDirect3DEventQuery b() {
      IDirect3DEventQuery idirect3deventquery = new IDirect3DEventQuery(this.b);
      if (lh.a((byte)68, this._CreateEventQuery(idirect3deventquery))) {
         return !idirect3deventquery.a((byte)-127) ? null : idirect3deventquery;
      } else {
         return null;
      }
   }

   public final native int BeginScene();

   public final native int SetVertexShader(IDirect3DVertexShader var1);

   public final native int TestCooperativeLevel();

   public final int b(int i, float f, float f_53_, float f_54_, float f_55_) {
      c[0] = f;
      c[2] = f_54_;
      c[1] = f_53_;
      c[3] = f_55_;
      return this.SetPixelShaderConstantF(i, c, 1);
   }

   public final IDirect3DSurface c(int i) {
      IDirect3DSurface idirect3dsurface = new IDirect3DSurface(this.b);
      int i_56_ = this._GetRenderTarget(i, idirect3dsurface);
      if (lh.a(i_56_, true)) {
         throw new sja(String.valueOf(i_56_));
      } else {
         return idirect3dsurface;
      }
   }

   public final IDirect3DVertexShader b(byte[] bs) {
      if (bs == null) {
         return null;
      } else {
         IDirect3DVertexShader idirect3dvertexshader = new IDirect3DVertexShader(this.b);
         int i = this._CreateVertexShader(bs, idirect3dvertexshader);
         if (lh.a(i, true)) {
            throw new sja(String.valueOf(i));
         } else {
            return idirect3dvertexshader;
         }
      }
   }

   private final native int _GetRenderTarget(int var1, IDirect3DSurface var2);

   public final IDirect3DVertexDeclaration a(VertexElementCollection vertexelementcollection, IDirect3DVertexDeclaration idirect3dvertexdeclaration) {
      if (idirect3dvertexdeclaration != null) {
         idirect3dvertexdeclaration.a((int)-109);
      } else {
         idirect3dvertexdeclaration = new IDirect3DVertexDeclaration(this.b);
      }

      int i = this._CreateVertexDeclaration(vertexelementcollection, idirect3dvertexdeclaration);
      if (lh.a(i, true)) {
         throw new sja(String.valueOf(i));
      } else {
         return idirect3dvertexdeclaration;
      }
   }

   public final native int SetViewport(int var1, int var2, int var3, int var4, float var5, float var6);

   public final IDirect3DSwapChain b(int i) {
      IDirect3DSwapChain idirect3dswapchain = new IDirect3DSwapChain(this.b);
      int i_61_ = this._GetSwapChain(i, idirect3dswapchain);
      if (lh.a(i_61_, true)) {
         throw new sja(String.valueOf(i_61_));
      } else {
         return idirect3dswapchain;
      }
   }

   public final native int DrawPrimitive(int var1, int var2, int var3);

   private final native int _CreateVertexBuffer(int var1, int var2, int var3, int var4, IDirect3DVertexBuffer var5);

   public final IDirect3DIndexBuffer a(int i, int i_67_, int i_68_, int i_69_, IDirect3DIndexBuffer idirect3dindexbuffer) {
      if (idirect3dindexbuffer != null) {
         idirect3dindexbuffer.a(47);
      } else {
         idirect3dindexbuffer = new IDirect3DIndexBuffer(this.b);
      }

      int i_70_ = this._CreateIndexBuffer(i, i_67_, i_68_, i_69_, idirect3dindexbuffer);
      if (lh.a(i_70_, true)) {
         throw new sja(String.valueOf(i_70_));
      } else {
         return idirect3dindexbuffer;
      }
   }

   public final native int SetTexture(int var1, IDirect3DBaseTexture var2);

   public final native int StretchRect(
      IDirect3DSurface var1, int var2, int var3, int var4, int var5, IDirect3DSurface var6, int var7, int var8, int var9, int var10, int var11
   );

   private final native int _CreateVertexDeclaration(VertexElementCollection var1, IDirect3DVertexDeclaration var2);

   private final native int _CreateRenderTarget(int var1, int var2, int var3, int var4, int var5, boolean var6, IDirect3DSurface var7);

   public final native int SetFVF(int var1);

   public final native int SetScissorRect(int var1, int var2, int var3, int var4);

   private final native int _CreateOffscreenPlainSurface(int var1, int var2, int var3, int var4, IDirect3DSurface var5);

   public final int a(int i, float[] fs) {
      return this.SetVertexShaderConstantF(i, fs, fs.length / 4);
   }

   public final native int SetVertexDeclaration(IDirect3DVertexDeclaration var1);

   public final int a(int i, boolean bool) {
      return this.SetRenderStateb(i, bool);
   }

   public final native int Clear(int var1, int var2, float var3, int var4);

   public final native int _CreateCubeTexture(int var1, int var2, int var3, int var4, int var5, IDirect3DCubeTexture var6);

   public final native int SetIndices(IDirect3DIndexBuffer var1);

   public final IDirect3DSurface a(int i, int i_96_, int i_97_, int i_98_, int i_99_, boolean bool) {
      IDirect3DSurface idirect3dsurface = new IDirect3DSurface(this.b);
      int i_100_ = this._CreateRenderTarget(i, i_96_, i_97_, i_98_, i_99_, bool, idirect3dsurface);
      if (lh.a(i_100_, true)) {
         throw new sja(String.valueOf(i_100_));
      } else {
         return idirect3dsurface;
      }
   }

   public final native int EndScene();

   public final native int _CreateVertexShader(byte[] var1, IDirect3DVertexShader var2);

   public final native int SetPixelShader(IDirect3DPixelShader var1);

   public final native int _CreateVolumeTexture(int var1, int var2, int var3, int var4, int var5, int var6, int var7, IDirect3DVolumeTexture var8);
}
