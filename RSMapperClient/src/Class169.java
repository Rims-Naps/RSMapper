import jaggl.OpenGL;

abstract class Class169 implements Interface2 {
   private int anInt4944;
   private boolean aBoolean4945;
   static int anInt4946;
   protected GLToolkit aGLToolkit4947;
   private boolean aBoolean4948 = false;
   static int anInt4949;
   protected int anInt4950;
   protected int anInt4951;
   static int anInt4952;
   static int anInt4953;
   static int[][] anIntArrayArray4954;
   static int anInt4955;
   static int anInt4956;
   static int anInt4957;
   static int anInt4958;
   static int anInt4959;
   protected int anInt4960;
   static short aShort4961;
   static int anInt4962;
   static int anInt4963;
   static int anInt4964;
   static int[] anIntArray4965 = new int[32];

   static final char method1755(int i, int i_0_, char c) {
      ++anInt4959;
      if (c >= 192 && c <= 255) {
         if (~c <= -193 && c <= 198) {
            return 'A';
         }

         if (c == 199) {
            return 'C';
         }

         if (~c <= -201 && c <= 203) {
            return 'E';
         }

         if (~c <= -205 && c <= 207) {
            return 'I';
         }

         if (c >= 210 && c <= 214) {
            return 'O';
         }

         if (c >= 217 && ~c >= -221) {
            return 'U';
         }

         if (c == 221) {
            return 'Y';
         }

         if (c == 223) {
            return 's';
         }

         if (c >= 224 && ~c >= -231) {
            return 'a';
         }

         if (~c == -232) {
            return 'c';
         }

         if (c >= 232 && c <= 235) {
            return 'e';
         }

         if (~c <= -237 && ~c >= -240) {
            return 'i';
         }

         if (~c <= -243 && ~c >= -247) {
            return 'o';
         }

         if (~c <= -250 && c <= 252) {
            return 'u';
         }

         if (c == 253 || c == 255) {
            return 'y';
         }
      }

      if (i != 6272) {
         return 'e';
      } else if (~c == -339) {
         return 'O';
      } else if (~c == -340) {
         return 'o';
      } else {
         return ~c == -377 ? 'Y' : c;
      }
   }

   private final void method1756(byte b, int i) {
      this.aGLToolkit4947.anInt6624 -= i;
      ++anInt4958;
      if (b <= 32) {
         this.aBoolean4945 = true;
      }

      this.aGLToolkit4947.anInt6624 += this.method1763(-70);
   }

   final void method1757(boolean bool, boolean bool_1_) {
      if (!bool) {
         if (this.aBoolean4948 == !bool_1_) {
            this.aBoolean4948 = bool_1_;
            this.method1758(false);
         }

         ++anInt4957;
      }
   }

   private final void method1758(boolean bool) {
      ++anInt4956;
      this.aGLToolkit4947.method1444(-2, this);
      if (!this.aBoolean4948) {
         OpenGL.glTexParameteri(this.anInt4951, 10241, this.aBoolean4945 ? 9984 : 9728);
         OpenGL.glTexParameteri(this.anInt4951, 10240, 9728);
      } else {
         OpenGL.glTexParameteri(this.anInt4951, 10241, this.aBoolean4945 ? 9987 : 9729);
         OpenGL.glTexParameteri(this.anInt4951, 10240, 9729);
      }

      if (bool) {
         method1764(-112);
      }
   }

   final int method1759(byte b) {
      int i = -66 % ((-37 - b) / 52);
      ++anInt4953;
      return this.anInt4960;
   }

   static final void method1760(boolean bool) {
      Class48.method478(12, (byte)105);
      if (!bool) {
         anIntArray4965 = null;
      }

      ++anInt4962;
      Class160.method1730(112);
      System.gc();
   }

   final void method1761(byte b) {
      if (b == -53) {
         ++anInt4949;
         if (this.anInt4960 > 0) {
            this.aGLToolkit4947.method1473(this.anInt4960, this.method1763(b + 2), b + -22249);
            this.anInt4960 = 0;
         }
      }
   }

   static final int method1762(byte b, int i) {
      if (b != 114) {
         return 89;
      } else {
         ++anInt4952;
         return 1023 & i;
      }
   }

   private final int method1763(int i) {
      if (i > -46) {
         this.anInt4951 = -105;
      }

      ++anInt4946;
      int i_2_ = this.aGLToolkit4947.method1471(this.anInt4950, 123) * this.anInt4944;
      return this.aBoolean4945 ? i_2_ * 4 / 3 : i_2_;
   }

   public static void method1764(int i) {
      anIntArrayArray4954 = null;
      anIntArray4965 = null;
      if (i > -46) {
         anIntArray4965 = null;
      }
   }

   @Override
   protected final void finalize() throws Throwable {
      this.method1761((byte)-53);
      ++anInt4964;
      super.finalize();
   }

   final boolean method1765(int i) {
      if (i != -231) {
         anIntArrayArray4954 = null;
      }

      ++anInt4955;
      if (this.aGLToolkit4947.aBoolean6719) {
         int i_3_ = this.method1763(-51);
         this.aGLToolkit4947.method1444(i ^ 231, this);
         OpenGL.glGenerateMipmapEXT(this.anInt4951);
         this.aBoolean4945 = true;
         this.method1758(false);
         this.method1756((byte)80, i_3_);
         return true;
      } else {
         return false;
      }
   }

   final void method1766(byte b, boolean bool) {
      if (bool != this.aBoolean4945) {
         int i = this.method1763(-88);
         this.aBoolean4945 = true;
         this.method1758(false);
         this.method1756((byte)98, i);
      }

      if (b <= 64) {
         this.method1757(false, true);
      }

      ++anInt4963;
   }

   Class169(GLToolkit gltoolkit, int i, int i_4_, int i_5_, boolean bool) {
      this.aBoolean4945 = bool;
      this.anInt4951 = i;
      this.anInt4944 = i_5_;
      this.aGLToolkit4947 = gltoolkit;
      this.anInt4950 = i_4_;
      OpenGL.glGenTextures(1, Node_Sub12.anIntArray5459, 0);
      this.anInt4960 = Node_Sub12.anIntArray5459[0];
      this.method1756((byte)48, 0);
   }

   @Override
   public abstract void method5(int var1);
}
