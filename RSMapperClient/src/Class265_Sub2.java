import jagdx.IDirect3DBaseTexture;
import jagdx.IDirect3DCubeTexture;
import jagdx.PixelBuffer;
import jagdx.lh;

public class Class265_Sub2 extends Class265 implements Interface13_Impl2 {
   private int anInt7901;
   private IDirect3DCubeTexture anIDirect3DCubeTexture7902;

   @Override
   public final void method42(boolean bool) {
      this.aD3DToolkit3365.method1395(this, 125);
      if (bool) {
         this.method42(false);
      }
   }

   @Override
   public final void method41(byte b, Class228 class228) {
      if (b < -104) {
         super.method41((byte)-105, class228);
      }
   }

   Class265_Sub2(D3DToolkit d3dtoolkit, int i, boolean bool, int[][] is) {
      super(d3dtoolkit, Class99.aClass68_1290, Class372.aClass372_4594, bool && d3dtoolkit.aBoolean9186, 6 * i * i);
      this.anInt7901 = i;
      if (this.aBoolean3364) {
         this.anIDirect3DCubeTexture7902 = this.aD3DToolkit3365.anIDirect3DDevice9199.a(this.anInt7901, 0, 1024, 21, 1);
      } else {
         this.anIDirect3DCubeTexture7902 = this.aD3DToolkit3365.anIDirect3DDevice9199.a(this.anInt7901, 1, 0, 21, 1);
      }

      PixelBuffer pixelbuffer = this.aD3DToolkit3365.aPixelBuffer9187;

      for(int i_0_ = 0; -7 < ~i_0_; ++i_0_) {
         int i_1_ = this.anIDirect3DCubeTexture7902.LockRect(i_0_, 0, 0, 0, this.anInt7901, this.anInt7901, 0, pixelbuffer);
         if (lh.a((byte)84, i_1_)) {
            int i_2_ = pixelbuffer.getRowPitch();
            if (~i_2_ != ~(this.anInt7901 * 4)) {
               for(int i_3_ = 0; i_3_ < this.anInt7901; ++i_3_) {
                  pixelbuffer.b(is[i_0_], this.anInt7901 * i_3_, i_2_ * i_3_, this.anInt7901);
               }
            } else {
               pixelbuffer.b(is[i_0_], 0, 0, this.anInt7901 * this.anInt7901);
            }

            this.anIDirect3DCubeTexture7902.UnlockRect(i_0_, 0);
         }
      }
   }

   @Override
   final IDirect3DBaseTexture method3232(int i) {
      if (i >= -46) {
         this.anInt7901 = 102;
      }

      return this.anIDirect3DCubeTexture7902;
   }
}
