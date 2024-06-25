import jaclib.memory.Source;
import jagdx.IDirect3DVertexBuffer;
import jagdx.lh;

public class Class80 implements Interface15_Impl2 {
   private int anInt9076;
   private int anInt9077;
   private boolean aBoolean9078;
   private byte aByte9079;
   protected IDirect3DVertexBuffer anIDirect3DVertexBuffer9080;
   private D3DToolkit aD3DToolkit9081;
   private boolean aBoolean9082 = false;

   @Override
   public final boolean method39(int i) {
      if (this.aBoolean9082 && lh.a((byte)96, this.anIDirect3DVertexBuffer9080.Unlock())) {
         this.aBoolean9082 = false;
         return true;
      } else {
         return false;
      }
   }

   @Override
   public final boolean method37(int i, int i_1_, int i_2_) {
      this.aByte9079 = (byte)i;
      this.anInt9076 = i_1_;
      if (~this.anInt9077 > ~this.anInt9076) {
         int i_3_ = 8;
         int i_4_;
         if (this.aBoolean9078) {
            i_3_ |= 512;
            i_4_ = 0;
         } else {
            i_4_ = 1;
         }

         if (this.anIDirect3DVertexBuffer9080 != null) {
            this.anIDirect3DVertexBuffer9080.a(111);
         }

         this.anIDirect3DVertexBuffer9080 = this.aD3DToolkit9081.anIDirect3DDevice9199.a(this.anInt9076, i_3_, 0, i_4_, this.anIDirect3DVertexBuffer9080);
         this.anInt9077 = this.anInt9076;
      }

      if (i_2_ != -12093) {
         this.method39(46);
      }

      return this.anIDirect3DVertexBuffer9080 != null;
   }

   @Override
   public final boolean method36(int i, int i_5_, Source source, int i_6_) {
      if (this.method37(i, i_5_, -12093)) {
         return this.anIDirect3DVertexBuffer9080.a(source, 0, 0, this.anInt9076, !this.aBoolean9078 ? 0 : 8192);
      } else {
         return i_6_ != 1965 ? false : false;
      }
   }

   @Override
   public final jaclib.memory.Buffer method40(int i, boolean bool) {
      if (this.anIDirect3DVertexBuffer9080 == null) {
         return null;
      } else {
         bool &= this.aBoolean9078;
         if (!this.aBoolean9082
            && lh.a((byte)108, this.anIDirect3DVertexBuffer9080.Lock(0, this.anInt9077, !bool ? 0 : 8192, this.aD3DToolkit9081.aGeometryBuffer9184))) {
            this.aBoolean9082 = true;
            return this.aD3DToolkit9081.aGeometryBuffer9184;
         } else {
            return null;
         }
      }
   }

   @Override
   public final void method38(boolean bool) {
      if (this.anIDirect3DVertexBuffer9080 != null) {
         this.anIDirect3DVertexBuffer9080.a(31);
         this.anIDirect3DVertexBuffer9080 = null;
      }

      this.anInt9077 = 0;
      if (!bool) {
         this.anInt9076 = 0;
      }
   }

   final int method793(int i) {
      return i != -11856 ? -40 : this.aByte9079;
   }

   @Override
   public final int method57(byte b) {
      return b >= -56 ? 17 : this.anInt9076;
   }

   Class80(D3DToolkit d3dtoolkit, boolean bool) {
      this.aD3DToolkit9081 = d3dtoolkit;
      this.aBoolean9078 = bool;
   }
}
