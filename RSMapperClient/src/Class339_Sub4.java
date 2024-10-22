import jaggl.OpenGL;

public class Class339_Sub4 extends Class339 {
   static int anInt8666;
   static int anInt8667;
   static int[] anIntArray8668 = new int[8];
   static int anInt8669;
   private Class145 aClass145_8670;
   static long aLong8671 = -1L;
   private boolean aBoolean8672;
   static int anInt8673;
   static int anInt8674;
   static int anInt8675;
   static int anInt8676;
   private Class301 aClass301_8677;
   private boolean aBoolean8678 = false;
   static int anInt8679 = 0;
   static int anInt8680;

   @Override
   final void method3917(Class169 class169, int i, int i_0_) {
      if (i_0_ != -28289) {
         this.method3923(false, -10);
      }

      ++anInt8669;
      if (!this.aBoolean8672) {
         this.aGLToolkit4202.method1444(i_0_ ^ 28289, class169);
         this.aGLToolkit4202.method1434((byte)-77, i);
      }
   }

   Class339_Sub4(GLToolkit gltoolkit, Class301 class301) {
      super(gltoolkit);
      this.aBoolean8672 = false;
      this.aClass301_8677 = class301;
      if (this.aClass301_8677.aClass169_Sub3_3778 != null && this.aGLToolkit4202.aBoolean6725 && this.aGLToolkit4202.aBoolean6738) {
         Class210 class210 = Class134.method1568(
            "uniform float time;\nuniform float scale;\nvarying vec3 wvVertex;\nvarying float waterDepth;\nvoid main() {\nwaterDepth = gl_MultiTexCoord0.z;\nvec4 ecVertex = gl_ModelViewMatrix*gl_Vertex;\nwvVertex.x = dot(gl_NormalMatrix[0], ecVertex.xyz);\nwvVertex.y = dot(gl_NormalMatrix[1], ecVertex.xyz);\nwvVertex.z = dot(gl_NormalMatrix[2], ecVertex.xyz);\ngl_TexCoord[0].x = dot(gl_TextureMatrix[0][0], gl_MultiTexCoord0)*scale;\ngl_TexCoord[0].y = dot(gl_TextureMatrix[0][1], gl_MultiTexCoord0)*scale;\ngl_TexCoord[0].z = time;\ngl_TexCoord[0].w = 1.0;\ngl_FogFragCoord = 1.0-clamp((gl_Fog.end+ecVertex.z)*gl_Fog.scale, 0.0, 1.0);\ngl_Position = ftransform();\n}\n",
            this.aGLToolkit4202,
            -399874888,
            35633
         );
         Class210 class210_1_ = Class134.method1568(
            "varying vec3 wvVertex;\nvarying float waterDepth;\nuniform vec3 sunDir;\nuniform vec4 sunColour;\nuniform float sunExponent;\nuniform float breakWaterDepth;\nuniform float breakWaterOffset;\nuniform sampler3D normalSampler;\nuniform samplerCube envMapSampler;\nvoid main() {\nvec4 wnNormal = texture3D(normalSampler, gl_TexCoord[0].xyz).rbga;\nwnNormal.xyz = 2.0*wnNormal.xyz-1.0;\nvec3 wnVector = normalize(wvVertex);\nvec3 wnReflection = reflect(wnVector, wnNormal.xyz);\nvec3 envColour = textureCube(envMapSampler, wnReflection).rgb;\nvec4 specularColour = sunColour*pow(clamp(-dot(sunDir, wnReflection), 0.0, 1.0), sunExponent);\nfloat shoreFactor = clamp(waterDepth/breakWaterDepth-breakWaterOffset*wnNormal.w, 0.0, 1.0);\nfloat ndote = dot(wnVector, wnNormal.xyz);\nfloat fresnel = pow(1.0-abs(ndote), 2.0);\nvec4 surfaceColour = vec4(envColour, fresnel*shoreFactor)+specularColour*shoreFactor;\ngl_FragColor = vec4(mix(surfaceColour.rgb, gl_Fog.color.rgb, gl_FogFragCoord), surfaceColour.a);\n}\n",
            this.aGLToolkit4202,
            -399874888,
            35632
         );
         this.aClass145_8670 = Class290_Sub4.method3431(this.aGLToolkit4202, 0, new Class210[]{class210, class210_1_});
         this.aBoolean8678 = this.aClass145_8670 != null;
      }
   }

   static final void method3932(byte b, int[] is, String[] strings) {
      ++anInt8673;
      DrawableModel.method638(-20788, strings, is, strings.length + -1, 0);
      if (b != 74) {
         aLong8671 = 2L;
      }
   }

   static final boolean method3933(GraphicsToolkit graphicstoolkit, int i, AreaDefinitions class79, int i_2_, Node_Sub14 node_sub14, int i_3_) {
      ++anInt8675;
      int i_4_ = Integer.MAX_VALUE;
      int i_5_ = Integer.MIN_VALUE;
      int i_6_ = Integer.MAX_VALUE;
      int i_7_ = Integer.MIN_VALUE;
      if (class79.anIntArray1049 != null) {
         i_7_ = WorldmapDefinitions.anInt339
            - (-WorldmapDefinitions.baseY + node_sub14.anInt7120 + class79.anInt1051)
               * (-WorldmapDefinitions.anInt350 + WorldmapDefinitions.anInt339)
               / (WorldmapDefinitions.maxHeight - WorldmapDefinitions.baseY);
         i_6_ = -(
               (node_sub14.anInt7120 + class79.anInt1060 - WorldmapDefinitions.baseY)
                  * (WorldmapDefinitions.anInt339 + -WorldmapDefinitions.anInt350)
                  / (-WorldmapDefinitions.baseY + WorldmapDefinitions.maxHeight)
            )
            + WorldmapDefinitions.anInt339;
         i_4_ = WorldmapDefinitions.anInt344
            - -(
               (WorldmapDefinitions.anInt348 + -WorldmapDefinitions.anInt344)
                  * (-WorldmapDefinitions.baseX + class79.anInt1068 - -node_sub14.anInt7125)
                  / (-WorldmapDefinitions.baseX + WorldmapDefinitions.maxWidth)
            );
         i_5_ = WorldmapDefinitions.anInt344
            + (class79.anInt1089 + node_sub14.anInt7125 - WorldmapDefinitions.baseX)
               * (-WorldmapDefinitions.anInt344 + WorldmapDefinitions.anInt348)
               / (WorldmapDefinitions.maxWidth + -WorldmapDefinitions.baseX);
      }

      GLSprite glsprite = null;
      int i_8_ = 0;
      int i_9_ = 0;
      int i_10_ = 0;
      int i_11_ = 0;
      if (class79.spriteId != -1) {
         if (node_sub14.aBoolean7127 && class79.hoverSpriteId != -1) {
            glsprite = class79.method790(true, (byte)-121, graphicstoolkit);
         } else {
            glsprite = class79.method790(false, (byte)-101, graphicstoolkit);
         }

         if (glsprite != null) {
            i_8_ = node_sub14.anInt7126 + -(glsprite.method1197() - -1 >> 1);
            i_9_ = node_sub14.anInt7126 - -(1 + glsprite.method1197() >> 1);
            if (i_4_ > i_8_) {
               i_4_ = i_8_;
            }

            if (i_9_ > i_5_) {
               i_5_ = i_9_;
            }

            i_10_ = node_sub14.anInt7118 + -(1 + glsprite.method1186() >> 1);
            if (i_6_ > i_10_) {
               i_6_ = i_10_;
            }

            i_11_ = node_sub14.anInt7118 + (1 + glsprite.method1186() >> 1);
            if (~i_11_ < ~i_7_) {
               i_7_ = i_11_;
            }
         }
      }

      Class299 class299 = null;
      int i_12_ = 0;
      int i_13_ = 0;
      int i_14_ = 0;
      int i_15_ = 0;
      int i_16_ = -4 / ((i_2_ - -58) / 58);
      int i_17_ = 0;
      int i_18_ = 0;
      int i_19_ = 0;
      int i_20_ = 0;
      if (class79.nameLabel != null) {
         class299 = Node_Sub25_Sub3.method2672(true, class79.anInt1090);
         if (class299 != null) {
            i_12_ = Class85.aClass357_1159.method4029(Node_Sub38_Sub3.aStringArray10107, null, -100, null, class79.nameLabel);
            i_14_ = node_sub14.anInt7118
               - class79.anInt1092
                  * (WorldmapDefinitions.anInt339 + -WorldmapDefinitions.anInt350)
                  / (-WorldmapDefinitions.baseY + WorldmapDefinitions.maxHeight);
            i_13_ = class79.anInt1071
                  * (WorldmapDefinitions.anInt348 + -WorldmapDefinitions.anInt344)
                  / (-WorldmapDefinitions.baseX + WorldmapDefinitions.maxWidth)
               + node_sub14.anInt7126;
            if (glsprite != null) {
               i_14_ -= (glsprite.method1186() >> 1) - -(class299.method3487() * i_12_);
            } else {
               i_14_ -= i_12_ * class299.method3489() / 2;
            }

            for(int i_21_ = 0; i_12_ > i_21_; ++i_21_) {
               String string = Node_Sub38_Sub3.aStringArray10107[i_21_];
               if (i_21_ < -1 + i_12_) {
                  string = string.substring(0, -4 + string.length());
               }

               int i_22_ = class299.method3490(string);
               if (i_22_ > i_15_) {
                  i_15_ = i_22_;
               }
            }

            i_17_ = i_13_ + -(i_15_ / 2) - -i;
            i_18_ = i + i_15_ / 2 + i_13_;
            if (i_4_ > i_17_) {
               i_4_ = i_17_;
            }

            if (~i_5_ > ~i_18_) {
               i_5_ = i_18_;
            }

            i_19_ = i_14_ - -i_3_;
            i_20_ = i_3_ + i_14_ + i_12_ * class299.method3487();
            if (~i_6_ < ~i_19_) {
               i_6_ = i_19_;
            }

            if (~i_20_ < ~i_7_) {
               i_7_ = i_20_;
            }
         }
      }

      if (i_5_ >= WorldmapDefinitions.anInt344
         && ~WorldmapDefinitions.anInt348 <= ~i_4_
         && WorldmapDefinitions.anInt350 <= i_7_
         && ~i_6_ >= ~WorldmapDefinitions.anInt339) {
         WorldmapDefinitions.method281(graphicstoolkit, node_sub14, class79);
         if (glsprite != null) {
            if (Class168.anInt2044 > 0
               && (
                  ~Class253.anInt3201 != 0 && node_sub14.anInt7128 == Class253.anInt3201
                     || ~Node_Sub38_Sub19.anInt10296 != 0 && class79.type == Node_Sub38_Sub19.anInt10296
               )) {
               int i_23_;
               if (Node_Sub15_Sub4.anInt9800 > 50) {
                  i_23_ = 200 + -(2 * Node_Sub15_Sub4.anInt9800);
               } else {
                  i_23_ = Node_Sub15_Sub4.anInt9800 * 2;
               }

               int i_24_ = i_23_ << 24 | 16776960;
               graphicstoolkit.method1238(node_sub14.anInt7118, i_24_, node_sub14.anInt7126, (byte)86, 7 + glsprite.method1193() / 2);
               graphicstoolkit.method1238(node_sub14.anInt7118, i_24_, node_sub14.anInt7126, (byte)86, 5 + glsprite.method1193() / 2);
               graphicstoolkit.method1238(node_sub14.anInt7118, i_24_, node_sub14.anInt7126, (byte)86, 3 + glsprite.method1193() / 2);
               graphicstoolkit.method1238(node_sub14.anInt7118, i_24_, node_sub14.anInt7126, (byte)86, glsprite.method1193() / 2 - -1);
               graphicstoolkit.method1238(node_sub14.anInt7118, i_24_, node_sub14.anInt7126, (byte)86, glsprite.method1193() / 2);
            }

            glsprite.method1196(node_sub14.anInt7126 - (glsprite.method1197() >> 1), node_sub14.anInt7118 - (glsprite.method1186() >> 1));
         }

         if (class79.nameLabel != null && class299 != null) {
            Node_Sub54.method2981(i_12_, node_sub14, i_13_, class79, class299, i_15_, (byte)118, graphicstoolkit, i_14_);
         }

         if (class79.spriteId != -1 || class79.nameLabel != null) {
            Node_Sub31 node_sub31 = new Node_Sub31(node_sub14);
            node_sub31.anInt7364 = i_18_;
            node_sub31.anInt7365 = i_10_;
            node_sub31.anInt7371 = i_17_;
            node_sub31.anInt7369 = i_9_;
            node_sub31.anInt7370 = i_11_;
            node_sub31.anInt7363 = i_19_;
            node_sub31.anInt7366 = i_20_;
            node_sub31.anInt7374 = i_8_;
            Node_Sub43.aClass312_7541.method3625((byte)-54, node_sub31);
         }

         return false;
      } else {
         return true;
      }
   }

   @Override
   final void method3918(int i) {
      ++anInt8676;
      if (i != 20937) {
         this.method3919(-89, -79, 117);
      }

      if (this.aBoolean8672) {
         this.aGLToolkit4202.method1457(i + 13047, 1);
         this.aGLToolkit4202.method1444(i + -20939, null);
         this.aGLToolkit4202.method1457(33984, 0);
         this.aGLToolkit4202.method1444(-2, null);
         OpenGL.glUseProgramObjectARB(0L);
         this.aBoolean8672 = false;
      }
   }

   @Override
   final void method3923(boolean bool, int i) {
      ++anInt8674;
      if (i == 0) {
         Class169_Sub1 class169_sub1 = this.aGLToolkit4202.method1406((byte)-90);
         if (this.aBoolean8678 && class169_sub1 != null) {
            this.aGLToolkit4202.method1457(33984, 1);
            this.aGLToolkit4202.method1444(-2, class169_sub1);
            this.aGLToolkit4202.method1457(i + 33984, 0);
            this.aGLToolkit4202.method1444(-2, this.aClass301_8677.aClass169_Sub3_3778);
            long l = this.aClass145_8670.aLong1795;
            OpenGL.glUseProgramObjectARB(l);
            OpenGL.glUniform1iARB(OpenGL.glGetUniformLocationARB(l, "normalSampler"), 0);
            OpenGL.glUniform1iARB(OpenGL.glGetUniformLocationARB(l, "envMapSampler"), 1);
            OpenGL.glUniform3fARB(
               OpenGL.glGetUniformLocationARB(l, "sunDir"),
               -this.aGLToolkit4202.aFloatArray6664[0],
               -this.aGLToolkit4202.aFloatArray6664[1],
               -this.aGLToolkit4202.aFloatArray6664[2]
            );
            OpenGL.glUniform4fARB(
               OpenGL.glGetUniformLocationARB(l, "sunColour"),
               this.aGLToolkit4202.aFloat6734,
               this.aGLToolkit4202.aFloat6707,
               this.aGLToolkit4202.aFloat6672,
               1.0F
            );
            OpenGL.glUniform1fARB(OpenGL.glGetUniformLocationARB(l, "sunExponent"), 928.0F * Math.abs(this.aGLToolkit4202.aFloatArray6664[1]) + 96.0F);
            this.aBoolean8672 = true;
         }
      }
   }

   @Override
   final boolean method3922(byte b) {
      if (b >= -44) {
         this.aClass301_8677 = null;
      }

      ++anInt8667;
      return false;
   }

   public static void method3934(int i) {
      anIntArray8668 = null;
      if (i > -22) {
         anIntArray8668 = null;
      }
   }

   @Override
   final void method3919(int i, int i_25_, int i_26_) {
      if (i != -13437) {
         method3933(null, 114, null, 95, null, -85);
      }

      if (this.aBoolean8672) {
         int i_27_ = 1 << (3 & i_26_);
         float f = (float)(1 << (i_26_ >> 3 & 7)) / 32.0F;
         int i_28_ = i_25_ & 65535;
         float f_29_ = (float)((232438 & i_25_) >> 16) / 8.0F;
         long l = this.aClass145_8670.aLong1795;
         OpenGL.glUniform1fARB(OpenGL.glGetUniformLocationARB(l, "time"), (float)(this.aGLToolkit4202.anInt6605 * i_27_ % 40000) / 40000.0F);
         OpenGL.glUniform1fARB(OpenGL.glGetUniformLocationARB(l, "scale"), f);
         OpenGL.glUniform1fARB(OpenGL.glGetUniformLocationARB(l, "breakWaterDepth"), (float)i_28_);
         OpenGL.glUniform1fARB(OpenGL.glGetUniformLocationARB(l, "breakWaterOffset"), f_29_);
      }

      ++anInt8680;
   }

   @Override
   final void method3920(int i, boolean bool) {
      ++anInt8666;
      if (i != -1) {
         this.aBoolean8678 = false;
      }
   }
}
