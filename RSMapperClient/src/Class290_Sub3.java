import jaggl.OpenGL;

public class Class290_Sub3 extends Class290 {
   static int anInt8076;
   static int[] anIntArray8077 = new int[4];
   static int anInt8078;
   private Class288 aClass288_8079;
   static int anInt8080;
   static int anInt8081;
   static int anInt8082;
   private boolean aBoolean8083;
   static int anInt8084;
   static int anInt8085;
   private boolean aBoolean8086;
   static int anInt8087;
   private Class5 aClass5_8088;

   static final void method3427(int i, int i_0_, int i_1_, int i_2_, int i_3_) {
      ++anInt8080;
      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 19, (long)i_1_ << 32 | (long)i_2_);
      cachenode_sub2.method2288(0);
      cachenode_sub2.anInt9434 = i_0_;
      cachenode_sub2.anInt9432 = i_3_;
   }

   @Override
   final void method3415(boolean bool, int i, int i_5_) {
      if (this.aBoolean8086) {
         int i_6_ = 1 << (3 & i);
         float f = (float)(1 << (7 & i >> 3)) / 32.0F;
         int i_7_ = 65535 & i_5_;
         float f_8_ = (float)(3 & i_5_ >> 16) / 8.0F;
         long l = this.aClass288_8079.aLong3626;
         OpenGL.glUniform1fARB(OpenGL.glGetUniformLocationARB(l, "time"), (float)(i_6_ * this.anAbstractToolkit3654.anInt6332 % 40000) / 40000.0F);
         OpenGL.glUniform1fARB(OpenGL.glGetUniformLocationARB(l, "scale"), f);
         OpenGL.glUniform1fARB(OpenGL.glGetUniformLocationARB(l, "breakWaterDepth"), (float)i_7_);
         OpenGL.glUniform1fARB(OpenGL.glGetUniformLocationARB(l, "breakWaterOffset"), f_8_);
      }

      ++anInt8078;
      if (!bool) {
         this.method3415(false, 29, 71);
      }
   }

   public static void method3428(byte b) {
      anIntArray8077 = null;
   }

   @Override
   final boolean method3414(byte b) {
      ++anInt8076;
      return b > -45 ? true : this.aBoolean8083;
   }

   @Override
   final void method3417(boolean bool, boolean bool_9_) {
      if (!bool_9_) {
         ++anInt8081;
      }
   }

   @Override
   final void method3419(Interface13 interface13, int i, byte b) {
      ++anInt8084;
      if (b != 92) {
         this.aClass288_8079 = null;
      }

      if (!this.aBoolean8086) {
         this.anAbstractToolkit3654.method1312((byte)-21, interface13);
         this.anAbstractToolkit3654.method1278((byte)-12, i);
      }
   }

   static final Class10 method3429(boolean bool) {
      ++anInt8087;
      if (!bool) {
         return null;
      } else {
         try {
            return (Class10)Class.forName("Class10_Sub2").newInstance();
         } catch (Throwable var2) {
            return new Class10_Sub1();
         }
      }
   }

   @Override
   final void method3422(int i, boolean bool) {
      if (i > -84) {
         this.method3414((byte)32);
      }

      ++anInt8085;
      Interface13_Impl2 interface13_impl2 = this.anAbstractToolkit3654.method1369(-104);
      if (this.aBoolean8083 && interface13_impl2 != null) {
         this.anAbstractToolkit3654.method1362(255, 1);
         this.anAbstractToolkit3654.method1312((byte)-21, interface13_impl2);
         this.anAbstractToolkit3654.method1362(255, 0);
         this.anAbstractToolkit3654.method1312((byte)-21, this.aClass5_8088.anInterface13_Impl3_129);
         long l = this.aClass288_8079.aLong3626;
         OpenGL.glUseProgramObjectARB(l);
         OpenGL.glUniform1iARB(OpenGL.glGetUniformLocationARB(l, "normalSampler"), 0);
         OpenGL.glUniform1iARB(OpenGL.glGetUniformLocationARB(l, "envMapSampler"), 1);
         OpenGL.glUniform3fARB(
            OpenGL.glGetUniformLocationARB(l, "sunDir"),
            -this.anAbstractToolkit3654.aFloatArray6292[0],
            -this.anAbstractToolkit3654.aFloatArray6292[1],
            -this.anAbstractToolkit3654.aFloatArray6292[2]
         );
         OpenGL.glUniform4fARB(
            OpenGL.glGetUniformLocationARB(l, "sunColour"),
            this.anAbstractToolkit3654.aFloat6323,
            this.anAbstractToolkit3654.aFloat6293,
            this.anAbstractToolkit3654.aFloat6365,
            1.0F
         );
         OpenGL.glUniform1fARB(OpenGL.glGetUniformLocationARB(l, "sunExponent"), Math.abs(this.anAbstractToolkit3654.aFloatArray6292[1]) * 928.0F + 96.0F);
         this.aBoolean8086 = true;
      }
   }

   @Override
   final void method3411(int i) {
      ++anInt8082;
      if (this.aBoolean8086) {
         this.anAbstractToolkit3654.method1362(255, 1);
         this.anAbstractToolkit3654.method1312((byte)-21, null);
         this.anAbstractToolkit3654.method1362(i ^ -8485, 0);
         this.anAbstractToolkit3654.method1312((byte)-21, null);
         OpenGL.glUseProgramObjectARB(0L);
         this.aBoolean8086 = false;
      }

      if (i != -8668) {
         method3427(-69, 76, 29, 58, -27);
      }
   }

   Class290_Sub3(GLXToolkit glxtoolkit, Index class302, Class5 class5) {
      super(glxtoolkit);
      this.aClass5_8088 = class5;
      if (class302 != null && glxtoolkit.aBoolean9315 && glxtoolkit.aBoolean9322) {
         Class237 class237 = Class24.method304(35633, -11847, class302.method3529("gl", "environment_mapped_water_v", 1), glxtoolkit);
         Class237 class237_10_ = Class24.method304(35632, -11847, class302.method3529("gl", "environment_mapped_water_f", 1), glxtoolkit);
         this.aClass288_8079 = Animator.method224((byte)-113, new Class237[]{class237, class237_10_}, glxtoolkit);
         this.aBoolean8083 = this.aClass288_8079 != null && this.aClass5_8088.method172(10103);
      } else {
         this.aBoolean8083 = false;
      }
   }
}
