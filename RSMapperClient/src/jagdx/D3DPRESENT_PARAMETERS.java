package jagdx;

public class D3DPRESENT_PARAMETERS {
   public int BackBufferHeight = 0;
   public java.awt.Canvas DeviceWindow;
   public int MultiSampleQuality;
   public int BackBufferWidth = 0;
   public int PresentationInterval = 0;
   public boolean Windowed;
   public int Flags;
   public int BackBufferCount = 0;
   public int BackBufferFormat;
   public int FullScreen_RefreshRateInHz;
   public int MultiSampleType;
   public int AutoDepthStencilFormat;
   public boolean EnableAutoDepthStencil;
   public int SwapEffect;

   public D3DPRESENT_PARAMETERS(java.awt.Canvas canvas) {
      this.MultiSampleQuality = 0;
      this.BackBufferFormat = 0;
      this.MultiSampleType = 0;
      this.SwapEffect = 1;
      this.AutoDepthStencilFormat = 0;
      this.DeviceWindow = canvas;
   }
}
