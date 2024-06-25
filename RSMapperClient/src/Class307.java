public class Class307 {
   static int[] anIntArray3896 = new int[1];
   private d aD3897;
   static boolean aBoolean3898;
   private Class61 aClass61_3899 = new Class61(256);
   static int anInt3900;
   static int anInt3901;
   static Node_Sub9_Sub1 aNode_Sub9_Sub1_3902;
   private AbstractToolkit anAbstractToolkit3903;
   static int anInt3904;
   static int[] SKILL_LEVEL = new int[25];

   public static void method3579(int i) {
      SKILL_LEVEL = null;
      aNode_Sub9_Sub1_3902 = null;
      anIntArray3896 = null;
   }

   final void method3580(byte b) {
      this.aClass61_3899.method608(false);
      ++anInt3901;
   }

   final Interface13_Impl1 method3581(byte b, int i) {
      ++anInt3904;
      Object object = this.aClass61_3899.method607((long)i, b + 45);
      if (object != null) {
         return (Interface13_Impl1)object;
      } else if (!this.aD3897.method7(b ^ -9857, i)) {
         return null;
      } else {
         TextureDefinitions class91 = this.aD3897.getTexture(i, -8217);
         int i_1_ = class91.skipTriangles ? 64 : this.anAbstractToolkit3903.anInt6368;
         Interface13_Impl1 interface13_impl1;
         if (class91.hdr && this.anAbstractToolkit3903.w()) {
            float[] fs = this.aD3897.method9(i_1_, i, 0.7F, (byte)-114, i_1_, false);
            interface13_impl1 = this.anAbstractToolkit3903.method1345(i_1_, fs, Class99.aClass68_1290, false, ~class91.mipmaps != -1, i_1_);
         } else {
            int[] is;
            if (~class91.unknown1 != -3 && Class377_Sub1.method4129((byte)83, class91.effect)) {
               is = this.aD3897.method11(i_1_, true, i_1_, i, (byte)0, 0.7F);
            } else {
               is = this.aD3897.method8(0.7F, i, i_1_, false, false, i_1_);
            }

            interface13_impl1 = this.anAbstractToolkit3903.method1258(class91.mipmaps != 0, i_1_, true, i_1_, is);
         }

         interface13_impl1.method51(class91.repeatSides, class91.repeatTop, false);
         this.aClass61_3899.method601(interface13_impl1, 25566, (long)i);
         return b != -45 ? null : interface13_impl1;
      }
   }

   final void method3582(byte b) {
      ++anInt3900;
      this.aClass61_3899.method598(5, -11819);
      if (b != -3) {
         this.method3580((byte)-12);
      }
   }

   Class307(AbstractToolkit abstracttoolkit, d var_d) {
      this.aD3897 = var_d;
      this.anAbstractToolkit3903 = abstracttoolkit;
   }
}
