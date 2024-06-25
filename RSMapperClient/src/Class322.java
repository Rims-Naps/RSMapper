import jagdx.IDirect3DSurface;
import jagdx.IDirect3DSwapChain;

public class Class322 {
   private IDirect3DSwapChain anIDirect3DSwapChain4071;
   private IDirect3DSurface anIDirect3DSurface4072;
   private IDirect3DSurface anIDirect3DSurface4073;

   final void method3803(int i) {
      if (this.anIDirect3DSurface4073 != null) {
         this.anIDirect3DSurface4073.a((int)-92);
         this.anIDirect3DSurface4073 = null;
      }

      if (this.anIDirect3DSurface4072 != null) {
         this.anIDirect3DSurface4072.a((int)-116);
         this.anIDirect3DSurface4072 = null;
      }

      if (i <= -74 && this.anIDirect3DSwapChain4071 != null) {
         this.anIDirect3DSwapChain4071.a(58);
         this.anIDirect3DSwapChain4071 = null;
      }
   }

   final int method3804(int i, byte b) {
      int i_0_ = -125 % ((b - 58) / 37);
      return this.anIDirect3DSwapChain4071.Present(i);
   }

   final void method3805(IDirect3DSurface idirect3dsurface, IDirect3DSwapChain idirect3dswapchain, byte b) {
      this.anIDirect3DSwapChain4071 = idirect3dswapchain;
      this.anIDirect3DSurface4072 = idirect3dsurface;
      int i = 76 / ((44 - b) / 46);
      this.anIDirect3DSurface4073 = this.anIDirect3DSwapChain4071.a(0, 0);
   }

   Class322(IDirect3DSwapChain idirect3dswapchain, IDirect3DSurface idirect3dsurface) {
      this.method3805(idirect3dsurface, idirect3dswapchain, (byte)117);
   }

   final boolean method3806(int i) {
      if (i != 0) {
         this.method3804(16, (byte)19);
      }

      return this.anIDirect3DSwapChain4071 != null;
   }
}
