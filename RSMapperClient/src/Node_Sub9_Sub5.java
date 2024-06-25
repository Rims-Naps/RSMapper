public class Node_Sub9_Sub5 extends Node_Sub9 {
   static int anInt9741;
   static int anInt9742;
   static int anInt9743;
   private int anInt9744;
   static int anInt9745;
   static int anInt9746;
   static int anInt9747;
   static int anInt9748;
   static int anInt9749;
   static IncommingPacket aClass192_9750 = new IncommingPacket(0, 6);
   private Class312 aClass312_9751 = new Class312();
   static int anInt9752;
   static int anInt9753;
   static int anInt9754;
   static int anInt9755;
   static int anInt9756;
   static int anInt9757;
   static int anInt9758;
   private boolean aBoolean9759;
   private int anInt9760;
   private int anInt9761 = 0;
   private int anInt9762;
   private int anInt9763 = 256;
   static int anInt9764;
   static float[] aFloatArray9765 = new float[16];
   static int anInt9766 = 0;
   static int anInt9767;
   private boolean aBoolean9768;

   final synchronized double method2526(boolean bool) {
      ++anInt9752;
      if (this.anInt9761 < 1) {
         return -1.0;
      } else {
         CacheNode_Sub8 cachenode_sub8 = (CacheNode_Sub8)this.aClass312_9751.method3613(65280);
         if (cachenode_sub8 == null) {
            return -1.0;
         } else {
            if (bool) {
               this.method2426(87);
            }

            return cachenode_sub8.aDouble9495 - (double)((float)cachenode_sub8.aShortArrayArray9491[0].length / (float)Class365.anInt4523);
         }
      }
   }

   public static void method2527(int i) {
      aClass192_9750 = null;
      if (i <= 87) {
         anInt9766 = -21;
      }

      aFloatArray9765 = null;
   }

   static final void method2528(int i) {
      ++anInt9754;
      if (i != 1390489120) {
         anInt9766 = -17;
      }

      Class217.aBoolean2552 = true;
   }

   @Override
   final Node_Sub9 method2431() {
      ++anInt9746;
      return null;
   }

   final synchronized int method2529(int i) {
      ++anInt9747;
      return i != 0 ? -122 : this.anInt9761;
   }

   final synchronized void method2530(boolean bool) {
      if (!bool) {
         ++anInt9749;
         this.aBoolean9768 = true;
      }
   }

   @Override
   final synchronized void method2426(int i) {
      ++anInt9755;
      if (!this.aBoolean9759) {
         while(true) {
            CacheNode_Sub8 cachenode_sub8 = this.method2534((byte)-10);
            if (cachenode_sub8 == null) {
               if (this.aBoolean9768) {
                  this.method2160((byte)46);
                  Node_Sub38_Sub16.aClass335_10268.method3852((byte)121);
               }
               break;
            }

            if (~(-this.anInt9762 + cachenode_sub8.aShortArrayArray9491[0].length) < ~i) {
               this.anInt9762 += i;
               break;
            }

            i -= cachenode_sub8.aShortArrayArray9491[0].length - this.anInt9762;
            this.method2533((byte)92);
         }
      }
   }

   final CacheNode_Sub8 method2531(int i, double d, int i_0_) {
      ++anInt9743;
      long l = (long)(i | this.anInt9744 << 0);
      CacheNode_Sub8 cachenode_sub8 = (CacheNode_Sub8)Node_Sub38_Sub16.aClass335_10268.method3849(l, true);
      if (cachenode_sub8 != null) {
         cachenode_sub8.aDouble9495 = d;
         Node_Sub38_Sub16.aClass335_10268.method3851(16384, l);
      } else {
         cachenode_sub8 = new CacheNode_Sub8(new short[this.anInt9744][i], d);
      }

      if (i_0_ != 0) {
         this.method2428();
      }

      return cachenode_sub8;
   }

   final synchronized void method2532(CacheNode_Sub8 cachenode_sub8, byte b) {
      ++anInt9741;

      while(~this.anInt9761 <= -101) {
         this.aClass312_9751.method3619(-101);
         --this.anInt9761;
      }

      this.aClass312_9751.method3625((byte)-54, cachenode_sub8);
      if (b != -73) {
         this.method2526(true);
      }

      ++this.anInt9761;
   }

   private final synchronized void method2533(byte b) {
      ++anInt9748;
      CacheNode_Sub8 cachenode_sub8 = this.method2534((byte)-10);
      if (cachenode_sub8 != null) {
         cachenode_sub8.method2160((byte)99);
         --this.anInt9761;
         this.anInt9762 = 0;
         int i = 58 % ((-7 - b) / 48);
         Node_Sub38_Sub16.aClass335_10268.method3848((byte)-128, cachenode_sub8, cachenode_sub8.method2319(false));
      }
   }

   @Override
   final int method2428() {
      ++anInt9756;
      return 1;
   }

   @Override
   final Node_Sub9 method2429() {
      ++anInt9745;
      return null;
   }

   private final synchronized CacheNode_Sub8 method2534(byte b) {
      if (b != -10) {
         this.method2526(true);
      }

      ++anInt9758;
      return (CacheNode_Sub8)this.aClass312_9751.method3613(65280);
   }

   final synchronized void method2535(int i, boolean bool) {
      ++anInt9764;
      this.aBoolean9759 = bool;
      if (i != 0) {
         this.method2431();
      }
   }

   final void method2536(int i, byte b) {
      if (b != -108) {
         this.method2534((byte)-20);
      }

      this.anInt9763 = i;
      ++anInt9753;
      this.anInt9760 = i;
   }

   @Override
   final synchronized void method2427(int[] is, int i, int i_1_) {
      ++anInt9742;
      if (!this.aBoolean9759) {
         if (this.method2534((byte)-10) == null) {
            if (this.aBoolean9768) {
               this.method2160((byte)45);
               Node_Sub38_Sub16.aClass335_10268.method3852((byte)110);
            }
         } else {
            int i_2_ = i_1_ + i;
            if (DrawableModel.aBoolean913) {
               i_2_ <<= 1;
            }

            int i_3_ = 0;
            int i_4_ = 0;
            if (this.anInt9744 == 2) {
               i_4_ = 1;
            }

            while(~i > ~i_2_) {
               CacheNode_Sub8 cachenode_sub8 = this.method2534((byte)-10);
               if (cachenode_sub8 == null) {
                  break;
               }

               short[][] ses;
               for(ses = cachenode_sub8.aShortArrayArray9491; i_2_ > i && this.anInt9762 < ses[0].length; ++this.anInt9762) {
                  if (!DrawableModel.aBoolean913) {
                     int var10001 = i++;
                     is[var10001] += this.anInt9763 * ses[i_4_][this.anInt9762] + ses[i_3_][this.anInt9762] * this.anInt9760;
                  } else {
                     is[i++] = ses[i_3_][this.anInt9762] * this.anInt9760;
                     is[i++] = this.anInt9763 * ses[i_4_][this.anInt9762];
                  }
               }

               if (~this.anInt9762 <= ~ses[0].length) {
                  this.method2533((byte)-84);
               }
            }
         }
      }
   }

   Node_Sub9_Sub5(int i) {
      this.anInt9760 = 256;
      this.anInt9744 = i;
   }
}
