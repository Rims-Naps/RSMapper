public class i extends DrawableModel implements Interface3 {
   protected Class300[] aClass300Array4987;
   private ya aYa4988;
   private oa anOa4989;
   protected long nativeid;
   protected Class218[] aClass218Array4990;

   @Override
   final native void p(int var1, int var2, Plane var3, Plane var4, int var5, int var6, int var7);

   @Override
   final native void LA(int var1);

   @Override
   final native void ia(short var1, short var2);

   @Override
   final native int ua();

   @Override
   final native boolean F();

   @Override
   final native int fa();

   @Override
   final void method629() {
      if (this.anOa4989.anInt5013 > 1) {
         synchronized(this) {
            while(this.aBoolean914) {
               try {
                  this.wait();
               } catch (InterruptedException var3) {
               }
            }

            this.aBoolean914 = true;
         }
      }
   }

   @Override
   final native void C(int var1);

   @Override
   final native void k(int var1);

   @Override
   final boolean method621(int i, int i_6_, Class336 class336, boolean bool, int i_7_, int i_8_) {
      return this.anOa4989.C().method146(this, i, i_6_, class336, bool, i_8_);
   }

   @Override
   final void method636(byte b, byte[] bs) {
      throw new RuntimeException();
   }

   @Override
   final void method626(int i, int i_9_, int i_10_, int i_11_) {
   }

   @Override
   final native void I(int var1, int[] var2, int var3, int var4, int var5, boolean var6, int var7, int[] var8);

   @Override
   final void method637(int i, int[] is, int i_17_, int i_18_, int i_19_, int i_20_, boolean bool) {
      this.l(this.nativeid, i, is, i_17_, i_18_, i_19_, i_20_, bool);
   }

   @Override
   final void method630(Class336 class336, int i, boolean bool) {
      this.J(((ja)class336).nativeid, i, bool);
   }

   @Override
   final boolean method624(int i, int i_21_, Class336 class336, boolean bool, int i_22_) {
      return this.anOa4989.C().method152(this, i, i_21_, class336, bool);
   }

   @Override
   final native int RA();

   @Override
   final native int da();

   @Override
   final native void a(int var1);

   @Override
   final native int V();

   private final native void J(long var1, int var3, boolean var4);

   @Override
   final native int na();

   @Override
   final native void P(int var1, int var2, int var3, int var4);

   @Override
   final void method614(Class336 class336) {
      this.method652(oa.anIntArray4994, class336);
      int i = 0;
      if (this.aClass300Array4987 != null) {
         for(int i_26_ = 0; i_26_ < this.aClass300Array4987.length; ++i_26_) {
            Class300 class300 = this.aClass300Array4987[i_26_];
            class300.anInt3769 = oa.anIntArray4994[i++];
            class300.anInt3751 = oa.anIntArray4994[i++];
            class300.anInt3753 = oa.anIntArray4994[i++];
            class300.anInt3766 = oa.anIntArray4994[i++];
            class300.anInt3756 = oa.anIntArray4994[i++];
            class300.anInt3758 = oa.anIntArray4994[i++];
            class300.anInt3761 = oa.anIntArray4994[i++];
            class300.anInt3752 = oa.anIntArray4994[i++];
            class300.anInt3771 = oa.anIntArray4994[i++];
         }
      }

      if (this.aClass218Array4990 != null) {
         for(int i_27_ = 0; i_27_ < this.aClass218Array4990.length; ++i_27_) {
            Class218 class218 = this.aClass218Array4990[i_27_];
            Class218 class218_28_ = class218;
            if (class218.aClass218_2561 != null) {
               class218_28_ = class218.aClass218_2561;
            }

            if (class218.aClass336_2562 != null) {
               class218.aClass336_2562.method3857(class336);
            } else {
               class218.aClass336_2562 = class336.method3858();
            }

            class218_28_.anInt2559 = oa.anIntArray4994[i++];
            class218_28_.anInt2557 = oa.anIntArray4994[i++];
            class218_28_.anInt2556 = oa.anIntArray4994[i++];
         }
      }
   }

   private final native void R(
      oa var1,
      ya var2,
      int var3,
      int var4,
      int[] var5,
      int[] var6,
      int[] var7,
      int[] var8,
      short[] var9,
      int var10,
      short[] var11,
      short[] var12,
      short[] var13,
      byte[] var14,
      byte[] var15,
      byte[] var16,
      byte[] var17,
      short[] var18,
      short[] var19,
      int[] var20,
      byte var21,
      short[] var22,
      int var23,
      byte[] var24,
      short[] var25,
      short[] var26,
      short[] var27,
      int[] var28,
      int[] var29,
      int[] var30,
      byte[] var31,
      byte[] var32,
      int[] var33,
      int[] var34,
      int[] var35,
      int[] var36,
      int var37,
      int var38,
      int var39,
      int var40,
      int var41,
      int var42,
      int[] var43
   );

   @Override
   public final native void w(boolean var1);

   @Override
   final Class218[] method618() {
      return this.aClass218Array4990;
   }

   @Override
   final native int G();

   @Override
   final native void H(int var1, int var2, int var3);

   private final native void l(long var1, int var3, int[] var4, int var5, int var6, int var7, int var8, boolean var9);

   @Override
   final byte[] method627() {
      throw new RuntimeException();
   }

   @Override
   final native void aa(short var1, short var2);

   @Override
   final native void wa();

   @Override
   final void method617() {
   }

   @Override
   final native int HA();

   @Override
   final native r ba(r var1);

   @Override
   final native void FA(int var1);

   @Override
   final void method622(Class336 class336, EntityNode_Sub5 entitynode_sub5, int i, int i_72_) {
      if (entitynode_sub5 == null) {
         this.anOa4989.C().method150(this, class336, null, i, i_72_);
      } else {
         oa.anIntArray5003[5] = 0;
         this.anOa4989.C().method150(this, class336, oa.anIntArray5003, i, i_72_);
         entitynode_sub5.anInt5985 = oa.anIntArray5003[0];
         entitynode_sub5.anInt5986 = oa.anIntArray5003[1];
         entitynode_sub5.anInt5982 = oa.anIntArray5003[2];
         entitynode_sub5.anInt5984 = oa.anIntArray5003[3];
         entitynode_sub5.anInt5983 = oa.anIntArray5003[4];
         entitynode_sub5.aBoolean5987 = oa.anIntArray5003[5] != 0;
      }
   }

   @Override
   final native boolean r();

   private final void method652(int[] is, Class336 class336) {
      this.anOa4989.C().method156(this, is, class336);
   }

   @Override
   final void method632() {
      if (this.anOa4989.anInt5013 > 1) {
         synchronized(this) {
            this.aBoolean914 = false;
            this.notifyAll();
         }
      }
   }

   final native void ZA(i var1, i var2, int var3, boolean var4, boolean var5);

   @Override
   final native boolean NA();

   @Override
   final native int WA();

   @Override
   final native void s(int var1);

   @Override
   final DrawableModel method633(byte b, int i, boolean bool) {
      return this.anOa4989.C().method144(this, b, i, bool);
   }

   @Override
   protected final void finalize() {
      if (this.nativeid != 0L) {
         Class164.method1739(0, this);
      }
   }

   @Override
   final native int EA();

   @Override
   final boolean method612() {
      return true;
   }

   @Override
   final native void O(int var1, int var2, int var3);

   @Override
   final void method611(Class336 class336, EntityNode_Sub5 entitynode_sub5, int i) {
      if (entitynode_sub5 == null) {
         this.anOa4989.C().method149(this, class336, null, i);
      } else {
         oa.anIntArray5003[5] = 0;
         this.anOa4989.C().method149(this, class336, oa.anIntArray5003, i);
         entitynode_sub5.anInt5985 = oa.anIntArray5003[0];
         entitynode_sub5.anInt5986 = oa.anIntArray5003[1];
         entitynode_sub5.anInt5982 = oa.anIntArray5003[2];
         entitynode_sub5.anInt5984 = oa.anIntArray5003[3];
         entitynode_sub5.anInt5983 = oa.anIntArray5003[4];
         entitynode_sub5.aBoolean5987 = oa.anIntArray5003[5] != 0;
      }
   }

   @Override
   final native int ma();

   private final native void oa(oa var1);

   @Override
   final native void v();

   @Override
   final native void VA(int var1);

   @Override
   final void method619(DrawableModel drawablemodel, int i, int i_78_, int i_79_, boolean bool) {
      this.anOa4989.C().method151(this, drawablemodel, i, i_78_, i_79_, bool);
   }

   @Override
   final Class300[] method620() {
      return this.aClass300Array4987;
   }

   i(oa var_oa, ya var_ya, Model model, int i, int i_80_, int i_81_, int i_82_) {
      this.anOa4989 = var_oa;
      this.aYa4988 = var_ya;
      this.aClass300Array4987 = model.aClass300Array2590;
      this.aClass218Array4990 = model.aClass218Array2620;
      int i_83_ = model.aClass300Array2590 == null ? 0 : model.aClass300Array2590.length;
      int i_84_ = model.aClass218Array2620 == null ? 0 : model.aClass218Array2620.length;
      int i_85_ = 0;
      int[] is = new int[i_83_ * 3 + i_84_];

      for(int i_86_ = 0; i_86_ < i_83_; ++i_86_) {
         is[i_85_++] = this.aClass300Array4987[i_86_].anInt3764;
         is[i_85_++] = this.aClass300Array4987[i_86_].anInt3757;
         is[i_85_++] = this.aClass300Array4987[i_86_].anInt3754;
      }

      for(int i_87_ = 0; i_87_ < i_84_; ++i_87_) {
         is[i_85_++] = this.aClass218Array4990[i_87_].anInt2554;
      }

      int i_88_ = model.aClass17Array2621 == null ? 0 : model.aClass17Array2621.length;
      int[] is_89_ = new int[i_88_ * 8];
      int i_90_ = 0;

      for(int i_91_ = 0; i_91_ < i_88_; ++i_91_) {
         Class17 class17 = model.aClass17Array2621[i_91_];
         Class352 class352 = Class215.method2067(0, class17.anInt279);
         is_89_[i_90_++] = class17.anInt273;
         is_89_[i_90_++] = class352.anInt4334;
         is_89_[i_90_++] = class352.anInt4326;
         is_89_[i_90_++] = class352.anInt4330;
         is_89_[i_90_++] = class352.anInt4336;
         is_89_[i_90_++] = class352.anInt4324;
         is_89_[i_90_++] = class352.aBoolean4325 ? -1 : 0;
      }

      for(int i_92_ = 0; i_92_ < i_88_; ++i_92_) {
         Class17 class17 = model.aClass17Array2621[i_92_];
         is_89_[i_90_++] = class17.anInt274;
      }

      this.R(
         this.anOa4989,
         this.aYa4988,
         model.anInt2599,
         model.anInt2573,
         model.anIntArray2616,
         model.anIntArray2576,
         model.anIntArray2574,
         model.anIntArray2598,
         model.aShortArray2582,
         model.anInt2572,
         model.aShortArray2600,
         model.aShortArray2583,
         model.aShortArray2589,
         model.aByteArray2594,
         model.aByteArray2607,
         model.aByteArray2622,
         model.aByteArray2610,
         model.aShortArray2580,
         model.aShortArray2587,
         model.anIntArray2602,
         model.aByte2619,
         model.aShortArray2575,
         model.anInt2611,
         model.aByteArray2586,
         model.aShortArray2613,
         model.aShortArray2577,
         model.aShortArray2604,
         model.anIntArray2603,
         model.anIntArray2588,
         model.anIntArray2593,
         model.aByteArray2609,
         model.aByteArray2585,
         model.anIntArray2617,
         model.anIntArray2615,
         model.anIntArray2584,
         is,
         i_83_,
         i_84_,
         i,
         i_80_,
         i_81_,
         i_82_,
         is_89_
      );
   }

   i(oa var_oa) {
      this.anOa4989 = var_oa;
      this.aYa4988 = null;
      this.oa(var_oa);
   }
}
