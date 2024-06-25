import jagdx.IDirect3DIndexBuffer;
import jagdx.lh;

public class Class8 implements Interface15_Impl1 {
   private D3DToolkit aD3DToolkit9083;
   private boolean aBoolean9084;
   private Class372 aClass372_9085;
   private int anInt9086;
   private boolean aBoolean9087 = false;
   private int anInt9088;
   protected IDirect3DIndexBuffer anIDirect3DIndexBuffer9089;

   @Override
   public final jaclib.memory.Buffer method54(boolean bool, byte b) {
      if (b < 66) {
         this.method53(-44);
      }

      if (this.anIDirect3DIndexBuffer9089 == null) {
         return null;
      } else {
         bool &= this.aBoolean9084;
         if (!this.aBoolean9087
            && lh.a((byte)86, this.anIDirect3DIndexBuffer9089.Lock(0, this.anInt9088, !bool ? 0 : 8192, this.aD3DToolkit9083.aGeometryBuffer9184))) {
            this.aBoolean9087 = true;
            return this.aD3DToolkit9083.aGeometryBuffer9184;
         } else {
            return null;
         }
      }
   }

   @Override
   public final int method57(byte b) {
      if (b > -56) {
         this.aClass372_9085 = null;
      }

      return this.anInt9086;
   }

   @Override
   public final void method56(int i, int i_0_) {
      if (i != -1696) {
         this.anInt9088 = 0;
      }

      this.anInt9086 = i_0_ * this.aClass372_9085.anInt4591;
      if (~this.anInt9088 > ~this.anInt9086) {
         int i_1_ = 8;
         int i_2_;
         if (!this.aBoolean9084) {
            i_2_ = 1;
         } else {
            i_1_ |= 512;
            i_2_ = 0;
         }

         if (this.anIDirect3DIndexBuffer9089 != null) {
            this.anIDirect3DIndexBuffer9089.a(110);
         }

         this.anIDirect3DIndexBuffer9089 = this.aD3DToolkit9083
            .anIDirect3DDevice9199
            .a(this.anInt9086, i_1_, this.aClass372_9085 != Class372.aClass372_4595 ? 102 : 101, i_2_, this.anIDirect3DIndexBuffer9089);
         this.anInt9088 = this.anInt9086;
      }
   }

   @Override
   public final Class372 method55(int i) {
      int i_3_ = -90 % ((i - 55) / 39);
      return this.aClass372_9085;
   }

   @Override
   public final boolean method53(int i) {
      if (this.aBoolean9087 && lh.a((byte)61, this.anIDirect3DIndexBuffer9089.Unlock())) {
         this.aBoolean9087 = false;
         return true;
      } else {
         if (i != -3308) {
            this.method53(-29);
         }

         return false;
      }
   }

   Class8(D3DToolkit d3dtoolkit, Class372 class372, boolean bool) {
      this.aClass372_9085 = class372;
      this.aD3DToolkit9083 = d3dtoolkit;
      this.aBoolean9084 = bool;
   }

   @Override
   public final void method38(boolean bool) {
      if (!bool) {
         if (this.anIDirect3DIndexBuffer9089 != null) {
            this.anIDirect3DIndexBuffer9089.a(39);
            this.anIDirect3DIndexBuffer9089 = null;
         }

         this.anInt9088 = 0;
         this.anInt9086 = 0;
      }
   }
}
