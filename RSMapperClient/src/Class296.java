public class Class296 implements Interface18 {
   protected int anInt5427;
   static boolean aBoolean5428 = false;
   static Class186 aClass186_5429;
   static int anInt5430;
   protected int anInt5431;
   protected int anInt5432;
   protected int anInt5433;
   protected int anInt5434;
   protected int anInt5435;
   static int anInt5436;
   static GLSprite aGLSprite5437;
   static int anInt5438;
   static int anInt5439;
   protected boolean aBoolean5440;
   static int anInt5441;
   static Class<?> aClass5442;

   static final boolean method3474(int i, int i_0_, int i_1_, int i_2_) {
      ++anInt5441;
      boolean bool = true;
      WorldObject interface19 = (WorldObject)Node_Sub38_Sub12.method2830(i_1_, i, i_0_);
      if (interface19 != null) {
         bool &= Class243.method3063(119, interface19);
      }

      interface19 = (WorldObject)Class262_Sub20.method3203(i_1_, i, i_0_, aClass5442 == null ? (aClass5442 = method3478("WorldObject")) : aClass5442);
      if (interface19 != null) {
         bool &= Class243.method3063(126, interface19);
      }

      interface19 = (WorldObject)Class270_Sub1_Sub1.method3303(i_1_, i, i_0_);
      if (i_2_ < 27) {
         return false;
      } else {
         if (interface19 != null) {
            bool &= Class243.method3063(115, interface19);
         }

         return bool;
      }
   }

   public static void method3475(int i) {
      if (i == 255) {
         aGLSprite5437 = null;
         aClass186_5429 = null;
      }
   }

   @Override
   public final long method67(int i) {
      ++anInt5436;
      long[] ls = CacheNode_Sub20.aLongArray9626;
      long l = -1L;
      l = ls[(int)(255L & (l ^ (long)this.anInt5431))] ^ l >>> 8;
      l = l >>> 8 ^ ls[(int)((l ^ (long)(this.anInt5432 >> 8)) & 255L)];
      if (i != 26165) {
         method3476(-43);
      }

      l = l >>> 8 ^ ls[(int)(255L & ((long)this.anInt5432 ^ l))];
      l = l >>> 8 ^ ls[(int)((l ^ (long)(this.anInt5427 >> 24)) & 255L)];
      l = ls[(int)(((long)(this.anInt5427 >> 16) ^ l) & 255L)] ^ l >>> 8;
      l = ls[(int)(255L & ((long)(this.anInt5427 >> 8) ^ l))] ^ l >>> 8;
      l = l >>> 8 ^ ls[(int)((l ^ (long)this.anInt5427) & 255L)];
      l = ls[(int)(255L & (l ^ (long)this.anInt5433))] ^ l >>> 8;
      l = ls[(int)((l ^ (long)(this.anInt5435 >> 24)) & 255L)] ^ l >>> 8;
      l = l >>> 8 ^ ls[(int)(255L & ((long)(this.anInt5435 >> 16) ^ l))];
      l = l >>> 8 ^ ls[(int)((l ^ (long)(this.anInt5435 >> 8)) & 255L)];
      l = ls[(int)(255L & (l ^ (long)this.anInt5435))] ^ l >>> 8;
      l = ls[(int)((l ^ (long)this.anInt5434) & 255L)] ^ l >>> 8;
      return l >>> 8 ^ ls[(int)(((long)(!this.aBoolean5440 ? 0 : 1) ^ l) & 255L)];
   }

   static final void method3476(int i) {
      Class155.aClass61_1952.method608(false);
      if (i > -90) {
         method3474(-92, 27, 118, -87);
      }

      ++anInt5439;
   }

   @Override
   public final boolean method66(int i, Interface18 interface18) {
      ++anInt5438;
      if (!(interface18 instanceof Class296)) {
         return false;
      } else {
         Class296 class296_3_ = (Class296)interface18;
         if (this.anInt5431 != class296_3_.anInt5431) {
            return false;
         } else if (class296_3_.anInt5432 != this.anInt5432) {
            return false;
         } else if (~this.anInt5427 != ~class296_3_.anInt5427) {
            return false;
         } else if (~class296_3_.anInt5433 != ~this.anInt5433) {
            return false;
         } else if (this.anInt5435 != class296_3_.anInt5435) {
            return false;
         } else if (~this.anInt5434 != ~class296_3_.anInt5434) {
            return false;
         } else {
            if (i != 28071) {
               this.anInt5431 = 7;
            }

            return !class296_3_.aBoolean5440 != this.aBoolean5440;
         }
      }
   }

   static final void method3477(int i, int i_4_, int i_5_, int i_6_, int i_7_, int i_8_) {
      ++anInt5430;
      int i_9_ = 85 % ((i_8_ - 36) / 63);

      for(int i_10_ = i; ~i_6_ <= ~i_10_; ++i_10_) {
         Class369.method4086(i_7_, i_4_, i_5_, Class169_Sub4.anIntArrayArray8826[i_10_], 0);
      }
   }

   Class296() {
   }

   static Class<?> method3478(String string) {
      try {
         return Class.forName(string);
      } catch (ClassNotFoundException var3) {
         throw (NoClassDefFoundError)new NoClassDefFoundError().initCause(var3);
      }
   }
}
