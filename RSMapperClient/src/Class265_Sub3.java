import jagdx.IDirect3DBaseTexture;
import jagdx.IDirect3DTexture;
import jagdx.PixelBuffer;
import jagdx.lh;

public class Class265_Sub3 extends Class265 implements Interface13_Impl1 {
   private int anInt7903;
   protected boolean aBoolean7904;
   private int anInt7905;
   private IDirect3DTexture anIDirect3DTexture7906;
   protected boolean aBoolean7907;

   @Override
   public final int method46(byte b) {
      if (b != 122) {
         this.aBoolean7907 = false;
      }

      return this.anInt7905;
   }

   @Override
   final IDirect3DBaseTexture method3232(int i) {
      if (i > -46) {
         this.anIDirect3DTexture7906 = null;
      }

      return this.anIDirect3DTexture7906;
   }

   Class265_Sub3(D3DToolkit d3dtoolkit, int i, int i_0_, boolean bool, int[] is, int i_1_, int i_2_) {
      super(d3dtoolkit, Class99.aClass68_1290, Class372.aClass372_4594, bool && d3dtoolkit.aBoolean9200, i_0_ * i);
      if (this.aD3DToolkit3365.aBoolean9196) {
         this.anInt7903 = i;
         this.anInt7905 = i_0_;
      } else {
         this.anInt7903 = Class320_Sub19.method3753(i);
         this.anInt7905 = Class320_Sub19.method3753(i_0_);
      }

      if (bool) {
         this.anIDirect3DTexture7906 = this.aD3DToolkit3365.anIDirect3DDevice9199.a(this.anInt7903, this.anInt7905, 0, 1024, 21, 1);
      } else {
         this.anIDirect3DTexture7906 = this.aD3DToolkit3365.anIDirect3DDevice9199.a(this.anInt7903, this.anInt7905, 1, 0, 21, 1);
      }

      PixelBuffer pixelbuffer = this.aD3DToolkit3365.aPixelBuffer9187;
      int i_3_ = this.anIDirect3DTexture7906.LockRect(0, 0, 0, i, i_0_, 0, pixelbuffer);
      if (lh.a((byte)84, i_3_)) {
         if (-1 == ~i_2_) {
            i_2_ = i;
         }

         int i_4_ = pixelbuffer.getRowPitch();
         if (4 * i == i_4_ && ~i_2_ == ~i) {
            pixelbuffer.b(is, i_1_, 0, i * i_0_);
         } else {
            for(int i_5_ = 0; ~i_5_ > ~i_0_; ++i_5_) {
               pixelbuffer.b(is, i_1_ + i_5_ * i_2_, i_5_ * i_4_, i);
            }
         }

         this.anIDirect3DTexture7906.UnlockRect(0);
      }
   }

   @Override
   public final void method51(boolean bool, boolean bool_6_, boolean bool_7_) {
      if (bool_7_) {
         this.method43((byte)-58, -35, 103, null, -32, -116, -79);
      }

      this.aBoolean7904 = bool_6_;
      this.aBoolean7907 = bool;
   }

   @Override
   public final void method50(int i, int i_8_, int i_9_, int i_10_, byte[] bs, int i_11_, Class68 class68, int i_12_, int i_13_) {
      if (class68 == this.aClass68_3367 && Class372.aClass372_4594 == this.aClass372_3366) {
         PixelBuffer pixelbuffer = this.aD3DToolkit3365.aPixelBuffer9187;
         int i_14_ = this.anIDirect3DTexture7906.LockRect(0, i_12_, i_11_, i_13_, i_9_, 0, pixelbuffer);
         if (lh.a((byte)106, i_14_)) {
            i_8_ *= this.aClass68_3367.anInt934;
            i_13_ *= this.aClass68_3367.anInt934;
            int i_15_ = pixelbuffer.getRowPitch();
            if (~i_13_ == ~i_15_ && i_13_ == i_8_) {
               pixelbuffer.a(bs, i, 0, i_13_ * i_9_);
            } else {
               for(int i_16_ = 0; ~i_16_ > ~i_9_; ++i_16_) {
                  pixelbuffer.a(bs, i_16_ * i_8_ + i, i_15_ * i_16_, i_13_);
               }
            }

            this.anIDirect3DTexture7906.UnlockRect(0);
         }

         if (i_10_ != -15178) {
            this.method48(-27);
         }
      } else {
         throw new RuntimeException();
      }
   }

   Class265_Sub3(D3DToolkit d3dtoolkit, Class68 class68, Class372 class372, int i, int i_17_) {
      super(d3dtoolkit, class68, class372, false, i_17_ * i);
      if (this.aD3DToolkit3365.aBoolean9196) {
         this.anInt7905 = i_17_;
         this.anInt7903 = i;
      } else {
         this.anInt7903 = Class320_Sub19.method3753(i);
         this.anInt7905 = Class320_Sub19.method3753(i_17_);
      }

      this.anIDirect3DTexture7906 = this.aD3DToolkit3365
         .anIDirect3DDevice9199
         .a(i, i_17_, 1, 0, D3DToolkit.method1396(this.aClass372_3366, this.aClass68_3367, -103), 1);
   }

   @Override
   public final void method41(byte b, Class228 class228) {
      if (b >= -104) {
         this.method46((byte)-33);
      }

      super.method41((byte)-118, class228);
   }

   @Override
   public final float method45(float f, int i) {
      int i_18_ = -75 / ((i - 17) / 63);
      return f / (float)this.anInt7903;
   }

   @Override
   public final void method42(boolean bool) {
      if (!bool) {
         this.aD3DToolkit3365.method1392(2, this);
      }
   }

   Class265_Sub3(D3DToolkit d3dtoolkit, Class68 class68, int i, int i_19_, boolean bool, byte[] bs, int i_20_, int i_21_) {
      super(d3dtoolkit, class68, Class372.aClass372_4594, bool && d3dtoolkit.aBoolean9200, i_19_ * i);
      if (!this.aD3DToolkit3365.aBoolean9196) {
         this.anInt7903 = Class320_Sub19.method3753(i);
         this.anInt7905 = Class320_Sub19.method3753(i_19_);
      } else {
         this.anInt7905 = i_19_;
         this.anInt7903 = i;
      }

      if (!bool) {
         this.anIDirect3DTexture7906 = this.aD3DToolkit3365
            .anIDirect3DDevice9199
            .a(this.anInt7903, this.anInt7905, 1, 0, D3DToolkit.method1396(Class372.aClass372_4594, this.aClass68_3367, -32), 1);
      } else {
         this.anIDirect3DTexture7906 = this.aD3DToolkit3365
            .anIDirect3DDevice9199
            .a(this.anInt7903, this.anInt7905, 0, 1024, D3DToolkit.method1396(Class372.aClass372_4594, this.aClass68_3367, -31), 1);
      }

      PixelBuffer pixelbuffer = this.aD3DToolkit3365.aPixelBuffer9187;
      int i_22_ = this.anIDirect3DTexture7906.LockRect(0, 0, 0, i, i_19_, 0, pixelbuffer);
      if (lh.a((byte)104, i_22_)) {
         if (i_21_ == 0) {
            i_21_ = i;
         }

         i *= this.aClass68_3367.anInt934;
         i_21_ *= this.aClass68_3367.anInt934;
         int i_23_ = pixelbuffer.getRowPitch();
         if (~i == ~i_23_ && ~i == ~i_21_) {
            pixelbuffer.a(bs, i_20_, 0, i * i_19_);
         } else {
            for(int i_24_ = 0; i_24_ < i_19_; ++i_24_) {
               pixelbuffer.a(bs, i_21_ * i_24_ + i_20_, i_24_ * i_23_, i);
            }
         }

         this.anIDirect3DTexture7906.UnlockRect(0);
      }
   }

   @Override
   public final void method43(byte b, int i, int i_25_, int[] is, int i_26_, int i_27_, int i_28_) {
      if (Class99.aClass68_1290 == this.aClass68_3367 && Class372.aClass372_4594 == this.aClass372_3366) {
         if (b != 64) {
            this.method49(0.5192189F, (byte)26);
         }

         PixelBuffer pixelbuffer = this.aD3DToolkit3365.aPixelBuffer9187;
         int i_29_ = this.anIDirect3DTexture7906.LockRect(0, i_26_, i_25_, i_27_, i_28_, 16, pixelbuffer);
         if (lh.a((byte)63, i_29_)) {
            int i_30_ = pixelbuffer.getRowPitch();
            if (4 * i_27_ == i_30_) {
               pixelbuffer.a(is, i, 0, is.length);
            } else {
               for(int i_31_ = 0; ~i_31_ > ~i_28_; ++i_31_) {
                  pixelbuffer.a(is, i - -(i_27_ * i_31_), i_31_ * i_30_, i_27_);
               }
            }

            this.anIDirect3DTexture7906.UnlockRect(0);
         }
      } else {
         throw new RuntimeException();
      }
   }

   @Override
   public final boolean method48(int i) {
      if (i != 30986) {
         this.aBoolean7904 = true;
      }

      return true;
   }

   @Override
   public final void method47(int[] is, int i, int i_32_, int i_33_, int i_34_, int i_35_, int i_36_, int i_37_) {
      if (Class99.aClass68_1290 == this.aClass68_3367 && Class372.aClass372_4594 == this.aClass372_3366) {
         PixelBuffer pixelbuffer = this.aD3DToolkit3365.aPixelBuffer9187;
         int i_38_ = this.anIDirect3DTexture7906.LockRect(0, i, i_32_, i_35_, i_33_, 0, pixelbuffer);
         if (i_34_ != 23110) {
            this.method51(true, true, true);
         }

         if (lh.a((byte)123, i_38_)) {
            int i_39_ = pixelbuffer.getRowPitch();
            if (i_39_ == 4 * i_35_ && ~i_35_ == ~i_37_) {
               pixelbuffer.b(is, i_36_, 0, i_35_ * i_33_);
            } else {
               for(int i_40_ = 0; ~i_40_ > ~i_33_; ++i_40_) {
                  pixelbuffer.b(is, i_36_ + i_37_ * i_40_, i_40_ * i_39_, i_35_);
               }
            }

            this.anIDirect3DTexture7906.UnlockRect(0);
         }
      } else {
         throw new RuntimeException();
      }
   }

   @Override
   public final float method49(float f, byte b) {
      if (b > -6) {
         this.method44(-88);
      }

      return f / (float)this.anInt7905;
   }

   @Override
   public final int method44(int i) {
      if (i != 19809) {
         this.method43((byte)-121, -46, 83, null, 20, 59, 68);
      }

      return this.anInt7903;
   }
}
