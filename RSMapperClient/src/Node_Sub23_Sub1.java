import jaggl.OpenGL;

public class Node_Sub23_Sub1 extends Node_Sub23 {
   static int anInt9902;
   private Class145 aClass145_9903;
   private int anInt9904;
   private Class382 aClass382_9905;
   private Class382 aClass382_9906;
   private Class145 aClass145_9907;
   static int anInt9908;
   private int anInt9909;
   static int anInt9910;
   private Class145 aClass145_9911;
   static int anInt9912;
   static int anInt9913;
   private int anInt9914;
   private Class145 aClass145_9915;
   static int anInt9916;
   private int anInt9917;
   static int anInt9918;
   static int anInt9919;
   static OutgoingPacket aClass318_9920 = new OutgoingPacket(58, 2);
   private Class169_Sub2[] aClass169_Sub2Array9921;
   static int anInt9922;
   static int anInt9923;
   private Class169_Sub2 aClass169_Sub2_9924;
   private Class169_Sub2 aClass169_Sub2_9925;
   static int anInt9926 = 0;
   static int anInt9927;
   static int[] DECODE_MASKS_PLAYERS_INDEXES_LIST = new int[2048];
   static int anInt9929;

   static final void method2637(int i, int i_0_, boolean bool) {
      ++anInt9910;
      if (bool) {
         method2637(-62, -22, true);
      }

      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 18, (long)i_0_ << 32 | (long)i);
      cachenode_sub2.method2291((byte)121);
   }

   static final Class371 method2638(int i, byte b) {
      ++anInt9919;
      Class371 class371 = new Class371(i, false);
      if (b != -77) {
         method2638(-99, (byte)-36);
      }

      return class371;
   }

   public static void method2639(byte b) {
      if (b == -16) {
         aClass318_9920 = null;
         DECODE_MASKS_PLAYERS_INDEXES_LIST = null;
      }
   }

   static final boolean method2640(int i, int i_1_) {
      ++anInt9918;

      for(CacheNode_Sub13 cachenode_sub13 = (CacheNode_Sub13)Class368.aClass312_4549.method3613(65280);
         cachenode_sub13 != null;
         cachenode_sub13 = (CacheNode_Sub13)Class368.aClass312_4549.method3620(16776960)
      ) {
         if (OutgoingPacket.method3666(cachenode_sub13.anInt9562, (byte)120) && cachenode_sub13.lastClickedIndex == (long)i) {
            return true;
         }
      }

      return false;
   }

   final boolean method2641(int i) {
      if (i <= 19) {
         this.aClass169_Sub2_9924 = null;
      }

      ++anInt9923;
      return this.aGLToolkit7197.aBoolean6719 && this.aGLToolkit7197.aBoolean6738 && this.aGLToolkit7197.aBoolean6665;
   }

   @Override
   final void method2626(byte b) {
      this.aClass169_Sub2Array9921 = null;
      this.aClass145_9911 = null;
      this.aClass169_Sub2_9924 = null;
      this.aClass382_9906 = null;
      this.aClass382_9905 = null;
      this.aClass145_9903 = null;
      ++anInt9916;
      if (b <= -126) {
         this.aClass169_Sub2_9925 = null;
         this.aClass145_9907 = null;
         this.aClass145_9915 = null;
      }
   }

   @Override
   final boolean method2635(byte b) {
      ++anInt9912;
      if (this.aGLToolkit7197.aBoolean6719 && this.aGLToolkit7197.aBoolean6738 && this.aGLToolkit7197.aBoolean6665) {
         this.aClass382_9905 = new Class382(this.aGLToolkit7197);
         this.aClass169_Sub2_9925 = new Class169_Sub2(this.aGLToolkit7197, 3553, 34842, 256, 256);
         this.aClass169_Sub2_9925.method1776(false, -87, false);
         this.aClass169_Sub2_9924 = new Class169_Sub2(this.aGLToolkit7197, 3553, 34842, 256, 256);
         this.aClass169_Sub2_9924.method1776(false, -123, false);
         this.aGLToolkit7197.method1410(15, this.aClass382_9905);
         this.aClass382_9905.method4181(18264, this.aClass169_Sub2_9925, 0);
         this.aClass382_9905.method4181(18264, this.aClass169_Sub2_9924, 1);
         this.aClass382_9905.method4183(0, (byte)124);
         if (!this.aClass382_9905.method4180(10785)) {
            this.aGLToolkit7197.method1436(this.aClass382_9905, (byte)60);
            return false;
         } else {
            this.aGLToolkit7197.method1436(this.aClass382_9905, (byte)18);
            this.aClass145_9903 = Class290_Sub4.method3431(
               this.aGLToolkit7197,
               0,
               new Class210[]{
                  Class134.method1568(
                     "#extension GL_ARB_texture_rectangle : enable\nuniform vec3 params;\nuniform sampler2DRect sceneTex;\nconst vec3 lumCoef = vec3(0.2126, 0.7152, 0.0722);\nvoid main() {\n    vec4 col = texture2DRect(sceneTex, gl_TexCoord[0].xy);\n    gl_FragColor = col*step(params.x, dot(lumCoef, col.rgb));\n}\n",
                     this.aGLToolkit7197,
                     -399874888,
                     35632
                  )
               }
            );
            this.aClass145_9915 = Class290_Sub4.method3431(
               this.aGLToolkit7197,
               0,
               new Class210[]{
                  Class134.method1568(
                     "uniform vec3 params;\nuniform sampler2D sceneTex;\nconst vec3 lumCoef = vec3(0.2126, 0.7152, 0.0722);\nvoid main() {\n    vec4 col = texture2D(sceneTex, gl_TexCoord[0].xy);\n    gl_FragColor = col*step(params.x, dot(lumCoef, col.rgb));\n}\n",
                     this.aGLToolkit7197,
                     -399874888,
                     35632
                  )
               }
            );
            this.aClass145_9907 = Class290_Sub4.method3431(
               this.aGLToolkit7197,
               0,
               new Class210[]{
                  Class134.method1568(
                     "#extension GL_ARB_texture_rectangle : enable\nuniform vec3 params;\nuniform vec3 dimScale;\nuniform sampler2D bloomTex;\nuniform sampler2DRect sceneTex;\nconst vec3 lumCoef = vec3(0.2126, 0.7152, 0.0722);\nvoid main() {\n\t vec4 bloomCol = texture2D(bloomTex, gl_TexCoord[1].xy);\n\t vec4 sceneCol = texture2DRect(sceneTex, gl_TexCoord[0].xy);\n\t float preLum = 0.99*dot(lumCoef, sceneCol.rgb)+0.01;\n    float postLum = preLum*(1.0+(preLum/params.y))/(preLum+1.0);\n\t gl_FragColor = sceneCol*(postLum/preLum)+bloomCol*params.x;\n}\n",
                     this.aGLToolkit7197,
                     b + -399874975,
                     35632
                  )
               }
            );
            this.aClass145_9911 = Class290_Sub4.method3431(
               this.aGLToolkit7197,
               0,
               new Class210[]{
                  Class134.method1568(
                     "uniform vec3 step;\nuniform sampler2D baseTex;\nvoid main() {\n\tvec4 fragCol = texture2D(baseTex, gl_TexCoord[0].xy)*0.091396265;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+(-1.0*step.xy))*0.088584304;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+( 1.0*step.xy))*0.088584304;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+(-2.0*step.xy))*0.08065692;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+( 2.0*step.xy))*0.08065692;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+(-3.0*step.xy))*0.068989515;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+( 3.0*step.xy))*0.068989515;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+(-4.0*step.xy))*0.055434637;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+( 4.0*step.xy))*0.055434637;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+(-5.0*step.xy))*0.04184426;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+( 5.0*step.xy))*0.04184426;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+(-6.0*step.xy))*0.029672023;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+( 6.0*step.xy))*0.029672023;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+(-7.0*step.xy))*0.019765828;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+( 7.0*step.xy))*0.019765828;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+(-8.0*step.xy))*0.012369139;\n\tfragCol += texture2D(baseTex, gl_TexCoord[0].xy+( 8.0*step.xy))*0.012369139;\n\tgl_FragColor = fragCol;\n}\n",
                     this.aGLToolkit7197,
                     -399874888,
                     35632
                  )
               }
            );
            return this.aClass145_9915 != null && this.aClass145_9903 != null && this.aClass145_9907 != null && this.aClass145_9911 != null;
         }
      } else {
         if (b != 87) {
            method2637(78, 106, false);
         }

         return false;
      }
   }

   @Override
   final void method2629(Class169_Sub2 class169_sub2, Class169_Sub2 class169_sub2_3_, int i, int i_4_) {
      ++anInt9927;
      OpenGL.glPushAttrib(2048);
      OpenGL.glMatrixMode(5889);
      OpenGL.glPushMatrix();
      OpenGL.glLoadIdentity();
      OpenGL.glOrtho(0.0, 1.0, 0.0, 1.0, -1.0, 1.0);
      if (this.aClass169_Sub2Array9921 == null) {
         this.aGLToolkit7197.method1444(-2, class169_sub2_3_);
         this.aGLToolkit7197.method1410(15, this.aClass382_9905);
         this.aClass382_9905.method4183(0, (byte)16);
         OpenGL.glViewport(0, 0, 256, 256);
         long l = this.aClass145_9903.aLong1795;
         OpenGL.glUseProgramObjectARB(l);
         OpenGL.glUniform1iARB(OpenGL.glGetUniformLocationARB(l, "sceneTex"), 0);
         OpenGL.glUniform3fARB(OpenGL.glGetUniformLocationARB(l, "params"), Class144_Sub1.aFloat6808, 0.0F, 0.0F);
         OpenGL.glBegin(7);
         OpenGL.glTexCoord2f(0.0F, 0.0F);
         OpenGL.glVertex2i(0, 0);
         OpenGL.glTexCoord2f((float)this.anInt9914, 0.0F);
         OpenGL.glVertex2i(1, 0);
         OpenGL.glTexCoord2f((float)this.anInt9914, (float)this.anInt9904);
         OpenGL.glVertex2i(1, 1);
         OpenGL.glTexCoord2f(0.0F, (float)this.anInt9904);
         OpenGL.glVertex2i(0, 1);
         OpenGL.glEnd();
      } else {
         this.aGLToolkit7197.method1410(15, this.aClass382_9906);
         int i_5_ = Class215.method2072(this.anInt9914, true);
         int i_6_ = Class215.method2072(this.anInt9904, true);

         int i_7_;
         for(i_7_ = 0; i_5_ > 256 || i_6_ > 256; ++i_7_) {
            OpenGL.glViewport(0, 0, i_5_, i_6_);
            this.aClass382_9906.method4181(i ^ 18264, this.aClass169_Sub2Array9921[i_7_], 0);
            if (i_7_ == 0) {
               this.aGLToolkit7197.method1444(i + -2, class169_sub2_3_);
               OpenGL.glBegin(7);
               OpenGL.glTexCoord2f(0.0F, 0.0F);
               OpenGL.glVertex2i(0, 0);
               OpenGL.glTexCoord2f((float)this.anInt9914, 0.0F);
               OpenGL.glVertex2i(1, 0);
               OpenGL.glTexCoord2f((float)this.anInt9914, (float)this.anInt9904);
               OpenGL.glVertex2i(1, 1);
               OpenGL.glTexCoord2f(0.0F, (float)this.anInt9904);
               OpenGL.glVertex2i(0, 1);
               OpenGL.glEnd();
            } else {
               this.aGLToolkit7197.method1444(-2, this.aClass169_Sub2Array9921[-1 + i_7_]);
               OpenGL.glBegin(7);
               OpenGL.glTexCoord2f(0.0F, 0.0F);
               OpenGL.glVertex2i(0, 0);
               OpenGL.glTexCoord2f(1.0F, 0.0F);
               OpenGL.glVertex2i(1, 0);
               OpenGL.glTexCoord2f(1.0F, 1.0F);
               OpenGL.glVertex2i(1, 1);
               OpenGL.glTexCoord2f(0.0F, 1.0F);
               OpenGL.glVertex2i(0, 1);
               OpenGL.glEnd();
            }

            if (~i_6_ < -257) {
               i_6_ >>= 1;
            }

            if (~i_5_ < -257) {
               i_5_ >>= 1;
            }
         }

         this.aGLToolkit7197.method1436(this.aClass382_9906, (byte)41);
         this.aGLToolkit7197.method1444(-2, this.aClass169_Sub2Array9921[-1 + i_7_]);
         this.aGLToolkit7197.method1410(15, this.aClass382_9905);
         this.aClass382_9905.method4183(0, (byte)124);
         OpenGL.glViewport(0, 0, 256, 256);
         long l = this.aClass145_9915.aLong1795;
         OpenGL.glUseProgramObjectARB(l);
         OpenGL.glUniform1iARB(OpenGL.glGetUniformLocationARB(l, "sceneTex"), 0);
         OpenGL.glUniform3fARB(OpenGL.glGetUniformLocationARB(l, "params"), Class144_Sub1.aFloat6808, 0.0F, 0.0F);
         OpenGL.glBegin(7);
         OpenGL.glTexCoord2f(0.0F, 0.0F);
         OpenGL.glVertex2i(0, 0);
         OpenGL.glTexCoord2f(1.0F, 0.0F);
         OpenGL.glVertex2i(1, 0);
         OpenGL.glTexCoord2f(1.0F, 1.0F);
         OpenGL.glVertex2i(1, 1);
         OpenGL.glTexCoord2f(0.0F, 1.0F);
         OpenGL.glVertex2i(0, 1);
         OpenGL.glEnd();
      }

      this.aClass382_9905.method4183(1, (byte)127);
      this.aGLToolkit7197.method1444(-2, this.aClass169_Sub2_9925);
      long l = this.aClass145_9911.aLong1795;
      OpenGL.glUseProgramObjectARB(l);
      OpenGL.glUniform1iARB(OpenGL.glGetUniformLocationARB(l, "baseTex"), 0);
      OpenGL.glUniform3fARB(OpenGL.glGetUniformLocationARB(l, "step"), 0.00390625F, 0.0F, 0.0F);
      OpenGL.glBegin(7);
      OpenGL.glTexCoord2f(0.0F, 0.0F);
      OpenGL.glVertex2i(0, 0);
      OpenGL.glTexCoord2f(1.0F, 0.0F);
      OpenGL.glVertex2i(1, 0);
      OpenGL.glTexCoord2f(1.0F, 1.0F);
      OpenGL.glVertex2i(1, 1);
      OpenGL.glTexCoord2f(0.0F, 1.0F);
      OpenGL.glVertex2i(0, 1);
      OpenGL.glEnd();
      this.aClass382_9905.method4183(0, (byte)122);
      this.aGLToolkit7197.method1444(i ^ -2, this.aClass169_Sub2_9924);
      OpenGL.glUniform3fARB(OpenGL.glGetUniformLocationARB(l, "step"), 0.0F, 0.00390625F, 0.0F);
      OpenGL.glBegin(7);
      OpenGL.glTexCoord2f(0.0F, 0.0F);
      OpenGL.glVertex2i(0, i);
      OpenGL.glTexCoord2f(1.0F, 0.0F);
      OpenGL.glVertex2i(1, 0);
      OpenGL.glTexCoord2f(1.0F, 1.0F);
      OpenGL.glVertex2i(1, 1);
      OpenGL.glTexCoord2f(0.0F, 1.0F);
      OpenGL.glVertex2i(0, 1);
      OpenGL.glEnd();
      OpenGL.glPopAttrib();
      OpenGL.glPopMatrix();
      OpenGL.glMatrixMode(5888);
      this.aGLToolkit7197.method1436(this.aClass382_9905, (byte)29);
      long l_8_ = this.aClass145_9907.aLong1795;
      OpenGL.glUseProgramObjectARB(l_8_);
      OpenGL.glUniform1iARB(OpenGL.glGetUniformLocationARB(l_8_, "sceneTex"), 0);
      OpenGL.glUniform1iARB(OpenGL.glGetUniformLocationARB(l_8_, "bloomTex"), 1);
      OpenGL.glUniform3fARB(OpenGL.glGetUniformLocationARB(l_8_, "params"), EntityNode_Sub3_Sub2.aFloat9168, Class333.aFloat4152, 0.0F);
      this.aGLToolkit7197.method1457(33984, 1);
      this.aGLToolkit7197.method1444(-2, this.aClass169_Sub2_9925);
      this.aGLToolkit7197.method1457(33984, 0);
      this.aGLToolkit7197.method1444(-2, class169_sub2_3_);
   }

   @Override
   final void method2625(byte b, int i) {
      OpenGL.glUseProgramObjectARB(0L);
      ++anInt9913;
      this.aGLToolkit7197.method1457(33984, 1);
      this.aGLToolkit7197.method1444(-2, null);
      this.aGLToolkit7197.method1457(33984, 0);
   }

   @Override
   final boolean method2627(byte b) {
      if (b >= -115) {
         return false;
      } else {
         ++anInt9902;
         return this.aClass382_9905 != null;
      }
   }

   @Override
   final int method2630(int i) {
      ++anInt9908;
      if (i != 1) {
         this.aClass145_9911 = null;
      }

      return 1;
   }

   @Override
   final void method2632(int i, int i_10_, int i_11_) {
      this.anInt9914 = i;
      ++anInt9922;
      if (i_10_ != 0) {
         this.method2626((byte)91);
      }

      this.anInt9904 = i_11_;
      int i_12_ = Class215.method2072(this.anInt9914, true);
      int i_13_ = Class215.method2072(this.anInt9904, true);
      if (this.anInt9909 != i_12_ || ~this.anInt9917 != ~i_13_) {
         if (this.aClass169_Sub2Array9921 != null) {
            for(int i_14_ = 0; ~i_14_ > ~this.aClass169_Sub2Array9921.length; ++i_14_) {
               this.aClass169_Sub2Array9921[i_14_].method1761((byte)-53);
            }

            this.aClass169_Sub2Array9921 = null;
         }

         if (~i_12_ >= -257 && ~i_13_ >= -257) {
            this.aClass382_9906 = null;
         } else {
            int i_15_ = i_12_;
            int i_16_ = i_13_;
            int i_17_ = 0;
            if (this.aClass382_9906 == null) {
               this.aClass382_9906 = new Class382(this.aGLToolkit7197);
            }

            while(i_15_ > 256 || ~i_16_ < -257) {
               ++i_17_;
               if (i_15_ > 256) {
                  i_15_ >>= 1;
               }

               if (~i_16_ < -257) {
                  i_16_ >>= 1;
               }
            }

            i_16_ = i_13_;
            this.aClass169_Sub2Array9921 = new Class169_Sub2[i_17_];
            i_15_ = i_12_;
            i_17_ = 0;

            while(~i_15_ < -257 || ~i_16_ < -257) {
               this.aClass169_Sub2Array9921[i_17_++] = new Class169_Sub2(this.aGLToolkit7197, 3553, 34842, i_15_, i_16_);
               if (~i_15_ < -257) {
                  i_15_ >>= 1;
               }

               if (i_16_ > 256) {
                  i_16_ >>= 1;
               }
            }
         }

         this.anInt9909 = i_12_;
         this.anInt9917 = i_13_;
      }
   }

   Node_Sub23_Sub1(GLToolkit gltoolkit) {
      super(gltoolkit);
   }
}
