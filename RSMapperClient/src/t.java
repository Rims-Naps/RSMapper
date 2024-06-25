public class t extends Plane implements Interface3 {
   protected long nativeid;
   private Class312 aClass312_5019 = new Class312();
   private oa anOa5020;
   private int anInt5021 = -1;

   @Override
   protected final void finalize() {
      if (this.nativeid != 0L) {
         Class164.method1739(0, this);
      }
   }

   @Override
   final native void U(
      int var1,
      int var2,
      int[] var3,
      int[] var4,
      int[] var5,
      int[] var6,
      int[] var7,
      int[] var8,
      int[] var9,
      int[] var10,
      int var11,
      int var12,
      int var13,
      boolean var14
   );

   @Override
   final void method3252(int i, int i_11_, int i_12_, boolean[][] bools, boolean bool, int i_13_) {
      this.anInt5021 = -1;
      int i_14_ = 0;
      float[] fs = new float[this.aClass312_5019.method3615(-87)];

      for(Node_Sub29 node_sub29 = (Node_Sub29)this.aClass312_5019.method3613(65280);
         node_sub29 != null;
         node_sub29 = (Node_Sub29)this.aClass312_5019.method3620(16776960)
      ) {
         fs[i_14_++] = node_sub29.method2707(1);
      }

      this.q(fs);

      for(int i_15_ = 0; i_15_ < i_12_ + i_12_; ++i_15_) {
         for(int i_16_ = 0; i_16_ < i_12_ + i_12_; ++i_16_) {
            if (bools[i_15_][i_16_]) {
               int i_17_ = i - i_12_ + i_15_;
               int i_18_ = i_11_ - i_12_ + i_16_;
               if (i_17_ >= 0 && i_17_ < this.anInt3408 && i_18_ >= 0 && i_18_ < this.anInt3404) {
                  this.method3257(i_17_, i_18_);
               }
            }
         }
      }
   }

   @Override
   final void method3250(Node_Sub29 node_sub29, int[] is) {
      this.aClass312_5019.method3625((byte)-54, node_sub29);
      this.V(
         node_sub29.hashCode(),
         node_sub29.getReferenceX(32311),
         node_sub29.getHeight(30),
         node_sub29.getReferenceY(27433),
         node_sub29.getFlickerType(123),
         node_sub29.getColor((byte)-61),
         is
      );
   }

   private final native void q(float[] var1);

   @Override
   final void method3257(int i, int i_19_) {
      if (this.anInt5021 < 0) {
         this.anOa5020.C().method143(this, i, i_19_);
      } else {
         this.anOa5020.C().method147(this, i, i_19_, this.anInt5021);
      }
   }

   @Override
   final void method3259(int i, int i_20_, int i_21_, boolean[][] bools, boolean bool, int i_22_, int i_23_) {
      this.anInt5021 = i_22_;
      int i_24_ = 0;
      float[] fs = new float[this.aClass312_5019.method3615(-115)];

      for(Node_Sub29 node_sub29 = (Node_Sub29)this.aClass312_5019.method3613(65280);
         node_sub29 != null;
         node_sub29 = (Node_Sub29)this.aClass312_5019.method3620(16776960)
      ) {
         fs[i_24_++] = node_sub29.method2707(1);
      }

      this.q(fs);

      for(int i_25_ = 0; i_25_ < i_21_ + i_21_; ++i_25_) {
         for(int i_26_ = 0; i_26_ < i_21_ + i_21_; ++i_26_) {
            if (bools[i_25_][i_26_]) {
               int i_27_ = i - i_21_ + i_25_;
               int i_28_ = i_20_ - i_21_ + i_26_;
               if (i_27_ >= 0 && i_27_ < this.anInt3408 && i_28_ >= 0 && i_28_ < this.anInt3404) {
                  this.method3257(i_27_, i_28_);
               }
            }
         }
      }
   }

   @Override
   final native void YA();

   @Override
   final void method3253(
      int i,
      int i_29_,
      int[] is,
      int[] is_30_,
      int[] is_31_,
      int[] is_32_,
      int[] is_33_,
      int[] is_34_,
      int[] is_35_,
      int[] is_36_,
      int[] is_37_,
      int[] is_38_,
      int[] is_39_,
      int i_40_,
      int i_41_,
      int i_42_,
      boolean bool
   ) {
      boolean bool_43_ = false;
      if (is_36_ != null) {
         int[] is_44_ = is_36_;

         for(int i_45_ = 0; i_45_ < is_44_.length; ++i_45_) {
            int i_46_ = is_44_[i_45_];
            if (i_46_ != -1) {
               bool_43_ = true;
               break;
            }
         }
      }

      int i_47_ = is_36_.length;
      int[] is_48_ = new int[i_47_ * 3];
      int[] is_49_ = new int[i_47_ * 3];
      int[] is_50_ = new int[i_47_ * 3];
      int[] is_51_ = new int[i_47_ * 3];
      int[] is_52_ = new int[i_47_ * 3];
      int[] is_53_ = is_37_ != null ? new int[i_47_ * 3] : null;
      int[] is_54_ = is_30_ != null ? new int[i_47_ * 3] : null;
      int[] is_55_ = is_32_ != null ? new int[i_47_ * 3] : null;
      int i_56_ = 0;

      for(int i_57_ = 0; i_57_ < i_47_; ++i_57_) {
         int i_58_ = is_33_[i_57_];
         int i_59_ = is_34_[i_57_];
         int i_60_ = is_35_[i_57_];
         is_48_[i_56_] = is[i_58_];
         is_49_[i_56_] = is_31_[i_58_];
         is_50_[i_56_] = is_36_[i_57_];
         is_51_[i_56_] = is_38_[i_57_];
         is_52_[i_56_] = is_39_[i_57_];
         if (is_37_ != null) {
            is_53_[i_56_] = is_37_[i_57_];
         }

         if (is_30_ != null) {
            is_54_[i_56_] = is_30_[i_58_];
         }

         if (is_32_ != null) {
            is_55_[i_56_] = is_32_[i_58_];
         }

         ++i_56_;
         is_48_[i_56_] = is[i_59_];
         is_49_[i_56_] = is_31_[i_59_];
         is_50_[i_56_] = is_36_[i_57_];
         is_51_[i_56_] = is_38_[i_57_];
         is_52_[i_56_] = is_39_[i_57_];
         if (is_37_ != null) {
            is_53_[i_56_] = is_37_[i_57_];
         }

         if (is_30_ != null) {
            is_54_[i_56_] = is_30_[i_59_];
         }

         if (is_32_ != null) {
            is_55_[i_56_] = is_32_[i_59_];
         }

         ++i_56_;
         is_48_[i_56_] = is[i_60_];
         is_49_[i_56_] = is_31_[i_60_];
         is_50_[i_56_] = is_36_[i_57_];
         is_51_[i_56_] = is_38_[i_57_];
         is_52_[i_56_] = is_39_[i_57_];
         if (is_37_ != null) {
            is_53_[i_56_] = is_37_[i_57_];
         }

         if (is_30_ != null) {
            is_54_[i_56_] = is_30_[i_60_];
         }

         if (is_32_ != null) {
            is_55_[i_56_] = is_32_[i_60_];
         }

         ++i_56_;
      }

      if (bool_43_ || is_53_ != null) {
         this.U(i, i_29_, is_48_, is_54_, is_49_, is_55_, is_50_, is_53_, is_51_, is_52_, i_40_, i_41_, i_42_, bool);
      }
   }

   @Override
   final boolean method3256(r var_r, int i, int i_61_, int i_62_, int i_63_, boolean bool) {
      return true;
   }

   @Override
   final native void wa(r var1, int var2, int var3, int var4, int var5, boolean var6);

   @Override
   final native void CA(r var1, int var2, int var3, int var4, int var5, boolean var6);

   @Override
   final native void ka(int var1, int var2, int var3);

   t(oa var_oa, ya var_ya, int i, int i_72_, int[][] is, int[][] is_73_, int i_74_, int i_75_, int i_76_) {
      super(i, i_72_, i_74_, is);
      this.anOa5020 = var_oa;
      this.ga(this.anOa5020, var_ya, i, i_72_, this.tileVerticeHeights, is_73_, i_74_, i_75_, i_76_);
   }

   private final native void V(int var1, int var2, int var3, int var4, int var5, int var6, int[] var7);

   @Override
   public final native void w(boolean var1);

   @Override
   final native r fa(int var1, int var2, r var3);

   @Override
   final void method3255(int i, int i_83_, int i_84_, int i_85_, int i_86_, int i_87_, int i_88_, boolean[][] bools) {
      this.anOa5020.C().method154(this, i, i_83_, i_84_, i_85_, i_86_, i_87_, i_88_, bools);
   }

   private final native void ga(oa var1, ya var2, int var3, int var4, int[][] var5, int[][] var6, int var7, int var8, int var9);
}
