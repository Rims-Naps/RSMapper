public class Class374 {
   private PureJavaToolkit aPureJavaToolkit4610;
   protected int anInt4611 = 0;
   static int anInt4612;
   static int anInt4613;
   static Class151 aClass151_4614 = new Class151(15, 0, 1, 0);
   protected boolean aBoolean4615 = true;
   protected int anInt4616;
   protected boolean aBoolean4617;
   protected int anInt4618;
   protected Class336_Sub2 aClass336_Sub2_4619;
   protected int anInt4620 = 0;
   protected boolean aBoolean4621;
   protected Runnable aRunnable4622;
   static int anInt4623;
   protected int anInt4624 = 0;
   static int anInt4625;
   protected int[] anIntArray4626;
   protected Class185 aClass185_4627;
   protected int[] anIntArray4628;
   protected int[] anIntArray4629;
   protected int[] anIntArray4630;
   protected int[] anIntArray4631;
   protected int[] anIntArray4632;
   protected int anInt4633;
   protected int[] anIntArray4634;
   protected int anInt4635;
   protected int[] anIntArray4636;
   protected int[] anIntArray4637;
   protected float[] aFloatArray4638;
   protected int[] anIntArray4639;
   protected int[] anIntArray4640;
   protected int[] anIntArray4641;
   protected int[] anIntArray4642;
   protected int[] anIntArray4643;
   protected int[] anIntArray4644;
   protected int[] anIntArray4645;
   protected int[] anIntArray4646;
   protected int[] anIntArray4647;
   protected int[] anIntArray4648;
   protected int[] anIntArray4649;
   protected int[] anIntArray4650;
   protected PureJavaDrawableModel[] aPureJavaDrawableModelArray4651;
   protected PureJavaDrawableModel[] aPureJavaDrawableModelArray4652;
   protected int anInt4653;

   final void method4109(boolean bool) {
      ++anInt4613;
      this.aClass185_4627 = new Class185(this.aPureJavaToolkit4610, this);
      if (bool) {
         this.method4111(null, 99);
      }
   }

   public static void method4110(int i) {
      if (i == 0) {
         aClass151_4614 = null;
      }
   }

   final void method4111(Runnable runnable, int i) {
      ++anInt4612;
      this.aRunnable4622 = runnable;
      if (i != 0) {
         method4112(-128, -87);
      }
   }

   static final int method4112(int i, int i_0_) {
      ++anInt4625;
      if (i != 1) {
         aClass151_4614 = null;
      }

      return i_0_ >>> 8;
   }

   static final int method4113(int i, int i_1_, int i_2_, int i_3_) {
      if (i_1_ != -1145) {
         aClass151_4614 = null;
      }

      ++anInt4623;
      if (~(Class277.tileFlags[i_3_][i_2_][i] & 8) != -1) {
         return 0;
      } else {
         return i_3_ > 0 && (Class277.tileFlags[1][i_2_][i] & 2) != 0 ? i_3_ - 1 : i_3_;
      }
   }

   Class374(PureJavaToolkit purejavatoolkit) {
      this.aBoolean4617 = false;
      this.anInt4616 = 0;
      this.aClass336_Sub2_4619 = new Class336_Sub2();
      this.anIntArray4636 = new int[8];
      this.anIntArray4630 = new int[PureJavaDrawableModel.anInt5724];
      this.anIntArray4632 = new int[64];
      this.anIntArray4629 = new int[8];
      this.anIntArray4639 = new int[8];
      this.anIntArray4626 = new int[10000];
      this.anIntArray4640 = new int[PureJavaDrawableModel.anInt5724];
      this.aFloatArray4638 = new float[2];
      this.anIntArray4641 = new int[PureJavaDrawableModel.anInt5724];
      this.anIntArray4628 = new int[10000];
      this.anIntArray4637 = new int[64];
      this.anIntArray4643 = new int[10];
      this.anIntArray4642 = new int[10];
      this.anIntArray4645 = new int[10];
      this.anIntArray4644 = new int[PureJavaDrawableModel.anInt5724];
      this.anIntArray4646 = new int[PureJavaDrawableModel.anInt5724];
      this.anIntArray4649 = new int[PureJavaDrawableModel.anInt5724];
      this.anIntArray4631 = new int[PureJavaDrawableModel.anInt5724];
      this.anIntArray4650 = new int[64];
      this.anIntArray4647 = new int[64];
      this.anIntArray4634 = new int[10];
      this.aPureJavaDrawableModelArray4652 = new PureJavaDrawableModel[7];
      this.aPureJavaDrawableModelArray4651 = new PureJavaDrawableModel[7];
      this.aPureJavaToolkit4610 = purejavatoolkit;
      this.anInt4618 = -255 + this.aPureJavaToolkit4610.anInt6776;
      this.aClass185_4627 = new Class185(purejavatoolkit, this);

      for(int i = 0; ~i > -8; ++i) {
         this.aPureJavaDrawableModelArray4652[i] = new PureJavaDrawableModel(this.aPureJavaToolkit4610);
         this.aPureJavaDrawableModelArray4651[i] = new PureJavaDrawableModel(this.aPureJavaToolkit4610);
      }

      this.anIntArray4648 = new int[PureJavaDrawableModel.anInt5742];

      for(int i = 0; i < PureJavaDrawableModel.anInt5742; ++i) {
         this.anIntArray4648[i] = -1;
      }
   }
}
