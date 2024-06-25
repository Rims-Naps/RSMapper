import jaggl.OpenGL;
import java.awt.Color;

public class Class382 implements Interface11 {
   static int anInt5232;
   static int anInt5233;
   private int anInt5234 = -1;
   static int anInt5235;
   static int anInt5236;
   static int anInt5237;
   private int anInt5238;
   private int anInt5239 = 0;
   static int anInt5240;
   private int anInt5241;
   static int anInt5242;
   private GLToolkit aGLToolkit5243;
   static int anInt5244;
   static int anInt5245;
   static Class142 aClass142_5246;
   static int anInt5247;
   static int anInt5248;
   static IncommingPacket aClass192_5249 = new IncommingPacket(133, -1);
   private Interface2[] anInterface2Array5250 = new Interface2[9];
   static int anInt5251;
   static int anInt5252;
   static int anInt5253;
   static boolean aBoolean5254 = false;
   static int anInt5255;
   private int anInt5256;
   static int anInt5257;
   static Color[] aColorArray5258 = new Color[]{new Color(9179409), new Color(3289650), new Color(3289650), new Color(3289650)};
   private int anInt5259;
   static boolean aBoolean5260;
   static int anInt5261;
   static int anInt5262;

   final void method4175(int i, int i_0_) {
      ++anInt5251;
      if (this.anInterface2Array5250[i] != null) {
         this.anInterface2Array5250[i].method5(0);
      }

      this.anInt5259 &= ~(1 << i);
      if (i_0_ != -25845) {
         this.anInt5241 = 63;
      }

      this.anInterface2Array5250[i] = null;
   }

   @Override
   public final void method33(int i) {
      ++anInt5242;
      if (i != 404) {
         this.method30(36);
      }

      OpenGL.glBindFramebufferEXT(36009, this.anInt5241);
      this.anInt5239 |= 2;
      this.anInt5234 = this.method4177(36009);
   }

   private final void method4176(int i, Class169_Sub1 class169_sub1, int i_1_, int i_2_, boolean bool) {
      ++anInt5235;
      if (bool) {
         aBoolean5254 = true;
      }

      if (this.anInt5234 == -1) {
         throw new RuntimeException();
      } else {
         int i_3_ = 1 << i_1_;
         if ((~i_3_ & this.anInt5259) != 0) {
            if (this.anInt5256 != class169_sub1.anInt8793 || this.anInt5238 != class169_sub1.anInt8793) {
               throw new RuntimeException();
            }
         } else {
            this.anInt5238 = class169_sub1.anInt8793;
            this.anInt5256 = class169_sub1.anInt8793;
         }

         class169_sub1.method1767(i, (byte)-126, Node_Sub38_Sub2.anIntArray10096[i_1_], this.anInt5234, i_2_);
         this.anInterface2Array5250[i_1_] = class169_sub1;
         this.anInt5259 |= i_3_;
      }
   }

   @Override
   public final void method29(int i) {
      ++anInt5232;
      OpenGL.glBindFramebufferEXT(36160, 0);
      this.anInt5239 &= -5;
      if (i > -39) {
         this.anInt5239 = -114;
      }

      this.anInt5234 = this.method4177(36009);
   }

   private final int method4177(int i) {
      ++anInt5237;
      if ((this.anInt5239 & 4) != 0) {
         return 36160;
      } else if ((2 & this.anInt5239) != 0) {
         return 36009;
      } else if ((this.anInt5239 & 1) != 0) {
         return 36008;
      } else {
         if (i != 36009) {
            this.aGLToolkit5243 = null;
         }

         return -1;
      }
   }

   final void method4178(CacheNode_Sub17 cachenode_sub17, int i, int i_4_) {
      ++anInt5248;
      if (~this.anInt5234 == 0) {
         throw new RuntimeException();
      } else {
         int i_5_ = i_4_ << i;
         if (~(this.anInt5259 & ~i_5_) == -1) {
            this.anInt5238 = cachenode_sub17.anInt8850;
            this.anInt5256 = cachenode_sub17.anInt8837;
         } else if (~this.anInt5256 != ~cachenode_sub17.anInt8837 || ~cachenode_sub17.anInt8850 != ~this.anInt5238) {
            throw new RuntimeException();
         }

         cachenode_sub17.method2396(Node_Sub38_Sub2.anIntArray10096[i], this.anInt5234, i_4_ ^ -30);
         this.anInterface2Array5250[i] = cachenode_sub17;
         this.anInt5259 |= i_5_;
      }
   }

   static final int method4179(OverlayDefinition class289, byte b, GraphicsToolkit graphicstoolkit) {
      int i = -55 / ((-77 - b) / 43);
      ++anInt5255;
      if (class289.mapColor != -1) {
         return class289.mapColor;
      } else {
         if (~class289.texture != 0) {
            TextureDefinitions class91 = graphicstoolkit.aD1543.getTexture(class289.texture, -8217);
            if (!class91.meshGround) {
               return class91.colorIndex;
            }
         }

         return class289.anInt3631;
      }
   }

   @Override
   public final void method28(byte b) {
      if (b != -106) {
         aBoolean5260 = true;
      }

      ++anInt5233;
      OpenGL.glBindFramebufferEXT(36009, 0);
      this.anInt5239 &= -3;
      this.anInt5234 = this.method4177(b ^ -36033);
   }

   @Override
   public final void method32(int i) {
      ++anInt5257;
      OpenGL.glBindFramebufferEXT(36008, 0);
      this.anInt5239 &= -2;
      this.anInt5234 = this.method4177(36009);
      if (i != 8372) {
         this.anInt5259 = -59;
      }
   }

   final boolean method4180(int i) {
      if (i != 10785) {
         aBoolean5254 = true;
      }

      ++anInt5262;
      int i_6_ = OpenGL.glCheckFramebufferStatusEXT(this.anInt5234);
      return i_6_ == 36053;
   }

   final void method4181(int i, Class169_Sub2 class169_sub2, int i_7_) {
      ++anInt5261;
      this.method4184(i_7_, 0, 0, class169_sub2);
      if (i != 18264) {
         this.anInt5241 = 124;
      }
   }

   final void method4182(int i, Class169_Sub1 class169_sub1, int i_8_, int i_9_) {
      this.method4176(i_8_, class169_sub1, i, 0, false);
      ++anInt5247;
      if (i_9_ < 28) {
         method4185(false);
      }
   }

   final void method4183(int i, byte b) {
      int i_10_ = 127 % ((73 - b) / 48);
      ++anInt5236;
      if (this.anInt5234 == -1) {
         throw new RuntimeException();
      } else {
         OpenGL.glDrawBuffer(Node_Sub38_Sub2.anIntArray10096[i]);
      }
   }

   @Override
   protected final void finalize() throws Throwable {
      ++anInt5252;
      this.aGLToolkit5243.method1411(this.anInt5241, 20010);
      super.finalize();
   }

   private final void method4184(int i, int i_11_, int i_12_, Class169_Sub2 class169_sub2) {
      ++anInt5253;
      if (this.anInt5234 == -1) {
         throw new RuntimeException();
      } else {
         int i_13_ = 1 << i;
         if ((~i_13_ & this.anInt5259) == i_12_) {
            this.anInt5256 = class169_sub2.anInt8795;
            this.anInt5238 = class169_sub2.anInt8803;
         } else if (this.anInt5256 != class169_sub2.anInt8795 || this.anInt5238 != class169_sub2.anInt8803) {
            throw new RuntimeException();
         }

         class169_sub2.method1774(i_11_, 3314, this.anInt5234, Node_Sub38_Sub2.anIntArray10096[i]);
         this.anInterface2Array5250[i] = class169_sub2;
         this.anInt5259 |= i_13_;
      }
   }

   public static void method4185(boolean bool) {
      aClass192_5249 = null;
      aColorArray5258 = null;
      aClass142_5246 = null;
      if (bool) {
         aClass142_5246 = null;
      }
   }

   final void method4186(int i, byte b) {
      ++anInt5244;
      if (this.anInt5234 == -1) {
         throw new RuntimeException();
      } else {
         OpenGL.glReadBuffer(Node_Sub38_Sub2.anIntArray10096[i]);
         if (b <= 89) {
            aBoolean5260 = true;
         }
      }
   }

   @Override
   public final void method30(int i) {
      ++anInt5245;
      OpenGL.glBindFramebufferEXT(36160, this.anInt5241);
      this.anInt5239 |= 4;
      int i_14_ = -56 / ((i - 24) / 36);
      this.anInt5234 = this.method4177(36009);
   }

   @Override
   public final void method31(byte b) {
      ++anInt5240;
      OpenGL.glBindFramebufferEXT(36008, this.anInt5241);
      this.anInt5239 |= 1;
      int i = 27 / ((-73 - b) / 50);
      this.anInt5234 = this.method4177(36009);
   }

   Class382(GLToolkit gltoolkit) {
      if (!gltoolkit.aBoolean6719) {
         throw new IllegalStateException("");
      } else {
         this.aGLToolkit5243 = gltoolkit;
         OpenGL.glGenFramebuffersEXT(1, Class321.anIntArray4067, 0);
         this.anInt5241 = Class321.anIntArray4067[0];
      }
   }
}
