import java.io.File;

public class Class169_Sub2_Sub1 extends Class169_Sub2 {
   protected boolean aBoolean10562;
   static boolean aBoolean10563 = false;
   protected int anInt10564;
   static int anInt10565;
   protected int anInt10566;
   protected float aFloat10567;
   protected float aFloat10568;

   Class169_Sub2_Sub1(GLToolkit gltoolkit, int i, int i_0_, int i_1_, int i_2_, boolean bool, byte[] bs, int i_3_) {
      super(gltoolkit, i, i_0_, i_1_, i_2_, bool, bs, i_3_, true);
      this.anInt10566 = i_1_;
      this.anInt10564 = i_2_;
      if (~this.anInt4951 != -34038) {
         this.aFloat10567 = this.aFloat10568 = 1.0F;
         this.aBoolean10562 = true;
      } else {
         this.aFloat10568 = (float)i_2_;
         this.aFloat10567 = (float)i_1_;
         this.aBoolean10562 = false;
      }
   }

   Class169_Sub2_Sub1(GLToolkit gltoolkit, int i, int i_4_, int i_5_, int i_6_) {
      super(gltoolkit, i, i_4_, i_5_, i_6_);
      this.anInt10564 = i_6_;
      if (this.anInt4951 != 34037) {
         this.aFloat10567 = this.aFloat10568 = 1.0F;
         this.aBoolean10562 = true;
      } else {
         this.aFloat10568 = (float)i_6_;
         this.aFloat10567 = (float)i_5_;
         this.aBoolean10562 = false;
      }

      this.anInt10566 = i_5_;
   }

   Class169_Sub2_Sub1(GLToolkit gltoolkit, int i, int i_7_, int i_8_, int i_9_, int i_10_, boolean bool) {
      super(gltoolkit, i, i_7_, i_8_, i_9_, i_10_);
      if (~this.anInt4951 == -34038) {
         this.aFloat10568 = (float)i_10_;
         this.aBoolean10562 = false;
         this.aFloat10567 = (float)i_9_;
      } else {
         this.aFloat10567 = this.aFloat10568 = 1.0F;
         this.aBoolean10562 = true;
      }

      this.anInt10564 = i_10_;
      this.anInt10566 = i_9_;
   }

   Class169_Sub2_Sub1(GLToolkit gltoolkit, int i, int i_11_, int i_12_, int i_13_, int i_14_) {
      super(gltoolkit, 3553, i, i_13_, i_14_);
      this.aFloat10568 = (float)i_12_ / (float)i_14_;
      this.anInt10566 = i_11_;
      this.aBoolean10562 = false;
      this.anInt10564 = i_12_;
      this.aFloat10567 = (float)i_11_ / (float)i_13_;
      this.method1776(false, -88, false);
   }

   Class169_Sub2_Sub1(GLToolkit gltoolkit, int i, int i_15_, int i_16_, int i_17_, int i_18_, byte[] bs, int i_19_) {
      super(gltoolkit, 3553, i, i_17_, i_18_);
      this.anInt10564 = i_16_;
      this.anInt10566 = i_15_;
      this.method1775(0, (byte)100, i_19_, i_16_, i_15_, bs, true, 0, 0, 0);
      this.aFloat10567 = (float)i_15_ / (float)i_17_;
      this.aBoolean10562 = false;
      this.aFloat10568 = (float)i_16_ / (float)i_18_;
      this.method1776(false, -101, false);
   }

   Class169_Sub2_Sub1(GLToolkit gltoolkit, int i, int i_20_, int i_21_, int i_22_, int i_23_, int i_24_, boolean bool) {
      super(gltoolkit, 3553, i, i_20_, i_23_, i_24_);
      this.aFloat10567 = (float)i_21_ / (float)i_23_;
      this.aFloat10568 = (float)i_22_ / (float)i_24_;
      this.anInt10566 = i_21_;
      this.aBoolean10562 = false;
      this.anInt10564 = i_22_;
      this.method1776(false, 89, false);
   }

   static final void method1777(File file, String string, int i) {
      Class85.aHashtable1157.put(string, file);
      ++anInt10565;
      if (i != 34037) {
         aBoolean10563 = false;
      }
   }

   Class169_Sub2_Sub1(GLToolkit gltoolkit, int i, int i_25_, int i_26_, boolean bool, int[] is, int i_27_, int i_28_) {
      super(gltoolkit, i, 6408, i_25_, i_26_, bool, is, i_27_, i_28_, true);
      this.anInt10564 = i_26_;
      this.anInt10566 = i_25_;
      if (this.anInt4951 != 34037) {
         this.aBoolean10562 = true;
         this.aFloat10567 = this.aFloat10568 = 1.0F;
      } else {
         this.aFloat10567 = (float)i_25_;
         this.aBoolean10562 = false;
         this.aFloat10568 = (float)i_26_;
      }
   }

   Class169_Sub2_Sub1(GLToolkit gltoolkit, int i, int i_29_, int i_30_, int i_31_, int[] is) {
      super(gltoolkit, 3553, 6408, i_30_, i_31_);
      this.anInt10564 = i_29_;
      this.anInt10566 = i;
      this.method1772((byte)-28, is, true, 0, i_29_, i, 0, 0, 0);
      this.aBoolean10562 = false;
      this.aFloat10568 = (float)i_29_ / (float)i_31_;
      this.aFloat10567 = (float)i / (float)i_30_;
      this.method1776(false, -117, false);
   }
}
