package jagdx;

import jaclib.peer.IUnknown;
import jaclib.peer.ti;

public class IDirect3D extends IUnknown {
   private ti b;

   public final native int CheckDeviceFormat(int var1, int var2, int var3, int var4, int var5, int var6);

   private static final native int _Direct3DCreate(int var0, IDirect3D var1);

   private IDirect3D(ti var_ti) {
      super(var_ti);
      this.b = var_ti;
   }

   public final IDirect3DDevice a(int i, int i_5_, java.awt.Canvas canvas, int i_6_, D3DPRESENT_PARAMETERS d3dpresent_parameters) {
      IDirect3DDevice idirect3ddevice = new IDirect3DDevice(this.b);
      int i_7_ = this._CreateDevice(i, i_5_, canvas, i_6_, d3dpresent_parameters, idirect3ddevice);
      if (lh.a(i_7_, true)) {
         throw new sja(String.valueOf(i_7_));
      } else {
         return idirect3ddevice;
      }
   }

   public final int a(int i, D3DDISPLAYMODE d3ddisplaymode) {
      return this._GetAdapterDisplayMode(i, d3ddisplaymode);
   }

   private final native int _GetAdapterDisplayMode(int var1, D3DDISPLAYMODE var2);

   private final native int _GetAdapterIdentifier(int var1, int var2, D3DADAPTER_IDENTIFIER var3);

   public static final IDirect3D a(int i, ti var_ti) {
      IDirect3D idirect3d = new IDirect3D(var_ti);
      int i_9_ = _Direct3DCreate(i, idirect3d);
      if (lh.a(i_9_, true)) {
         throw new sja(String.valueOf(i_9_));
      } else {
         return idirect3d;
      }
   }

   public final native int CheckDepthStencilMatch(int var1, int var2, int var3, int var4, int var5);

   private final native int _GetDeviceCaps(int var1, int var2, D3DCAPS var3);

   public final D3DADAPTER_IDENTIFIER b(int i, int i_15_) {
      D3DADAPTER_IDENTIFIER d3dadapter_identifier = new D3DADAPTER_IDENTIFIER();
      int i_16_ = this._GetAdapterIdentifier(i, i_15_, d3dadapter_identifier);
      if (lh.a(i_16_, true)) {
         throw new sja(String.valueOf(i_16_));
      } else {
         return d3dadapter_identifier;
      }
   }

   public final native int CheckDeviceMultiSampleType(int var1, int var2, int var3, boolean var4, int var5);

   private final native int _CreateDevice(int var1, int var2, java.awt.Canvas var3, int var4, D3DPRESENT_PARAMETERS var5, IDirect3DDevice var6);

   public final D3DCAPS a(int i, int i_22_) {
      D3DCAPS d3dcaps = new D3DCAPS();
      int i_23_ = this._GetDeviceCaps(i, i_22_, d3dcaps);
      if (lh.a(i_23_, true)) {
         throw new sja(String.valueOf(i_23_));
      } else {
         return d3dcaps;
      }
   }

   public final native int CheckDeviceType(int var1, int var2, int var3, int var4, boolean var5);
}
