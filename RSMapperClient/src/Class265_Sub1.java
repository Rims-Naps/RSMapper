import jagdx.IDirect3DBaseTexture;
import jagdx.IDirect3DVolumeTexture;
import jagdx.PixelBuffer;
import jagdx.lh;

public class Class265_Sub1 extends Class265 implements Interface13_Impl3 {
   private int anInt7897;
   private IDirect3DVolumeTexture anIDirect3DVolumeTexture7898;
   private int anInt7899;
   private int anInt7900;

   Class265_Sub1(D3DToolkit d3dtoolkit, Class68 class68, int i, int i_0_, int i_1_, byte[] bs) {
      super(d3dtoolkit, class68, Class372.aClass372_4594, false, i_1_ * i * i_0_);
      this.anInt7899 = i_1_;
      this.anInt7900 = i;
      this.anInt7897 = i_0_;
      this.anIDirect3DVolumeTexture7898 = this.aD3DToolkit3365
         .anIDirect3DDevice9199
         .a(i, i_0_, i_1_, 1, 0, D3DToolkit.method1396(this.aClass372_3366, class68, -106), 1);
      PixelBuffer pixelbuffer = this.aD3DToolkit3365.aPixelBuffer9187;
      int i_2_ = this.anIDirect3DVolumeTexture7898.LockBox(0, 0, 0, 0, i, i_0_, i_1_, 0, pixelbuffer);
      if (lh.a((byte)107, i_2_)) {
         int i_3_ = this.anInt7900 * this.aClass68_3367.anInt934;
         int i_4_ = i_3_ * this.anInt7897;
         int i_5_ = pixelbuffer.getSlicePitch();
         if (i_4_ == i_5_) {
            pixelbuffer.a(bs, 0, 0, this.anInt7897 * i_3_ * this.anInt7899);
         } else {
            int i_6_ = pixelbuffer.getRowPitch();
            if (~i_3_ == ~i_6_) {
               for(int i_9_ = 0; this.anInt7899 > i_9_; ++i_9_) {
                  pixelbuffer.a(bs, i_4_ * i_9_, i_9_ * i_5_, i_4_);
               }
            } else {
               for(int i_7_ = 0; this.anInt7899 > i_7_; ++i_7_) {
                  for(int i_8_ = 0; this.anInt7897 > i_8_; ++i_8_) {
                     pixelbuffer.a(bs, i_4_ * i_7_ + i_3_ * i_8_, i_8_ * i_6_ + i_5_ * i_7_, i_3_);
                  }
               }
            }
         }

         this.anIDirect3DVolumeTexture7898.UnlockBox(0);
      }
   }

   @Override
   public final void method41(byte b, Class228 class228) {
      super.method41((byte)-127, class228);
      if (b >= -104) {
         this.anIDirect3DVolumeTexture7898 = null;
      }
   }

   @Override
   public final void method42(boolean bool) {
      if (bool) {
         this.anInt7900 = 7;
      }

      this.aD3DToolkit3365.method1394(this, 1);
   }

   @Override
   final IDirect3DBaseTexture method3232(int i) {
      if (i >= -46) {
         this.method42(false);
      }

      return this.anIDirect3DVolumeTexture7898;
   }
}
