import jaggl.OpenGL;

class Animator {
   static int anInt232;
   protected Class48 aClass48_233;
   private boolean aBoolean234 = false;
   static int anInt235;
   static int anInt236;
   private int anInt237;
   static int anInt238;
   static int anInt239;
   static int anInt240;
   private Class226 aClass226_241;
   static int anInt242;
   private int anInt243;
   static int anInt244;
   static int anInt245;
   static int anInt246;
   protected int anInt247;
   static int anInt248;
   static int anInt249;
   static int anInt250;
   static int anInt251;
   static Class346 aClass346_252 = new Class346();
   private int anInt253 = 0;
   static int anInt254;
   private int anInt255;
   static int anInt256;
   static int anInt257;
   static int anInt258;
   protected int anInt259;
   static int anInt260;
   static int anInt261;
   static int anInt262;
   private boolean aBoolean263 = false;
   static int anInt264;
   static int anInt265;
   static int anInt266;
   static int anInt267;
   static int anInt268;
   static int anInt269;
   protected Class226 aClass226_270;
   static int anInt271;
   static int anInt272;

   void method222(int i, Class48 class48, byte b) {
      if (b < 3) {
         this.method251(true);
      }

      ++anInt269;
   }

   final int method223(int i) {
      ++anInt254;
      int i_0_ = -87 / ((25 - i) / 46);
      return this.anInt237;
   }

   static final Class288 method224(byte b, Class237[] class237s, GLXToolkit glxtoolkit) {
      ++anInt265;

      for(int i = 0; ~i > ~class237s.length; ++i) {
         if (class237s[i] == null || ~class237s[i].aLong2907 >= -1L) {
            return null;
         }
      }

      if (b >= -86) {
         return null;
      } else {
         long l = OpenGL.glCreateProgramObjectARB();

         for(int i = 0; class237s.length > i; ++i) {
            OpenGL.glAttachObjectARB(l, class237s[i].aLong2907);
         }

         OpenGL.glLinkProgramARB(l);
         OpenGL.glGetObjectParameterivARB(l, 35714, Class320_Sub19.anIntArray8392, 0);
         if (Class320_Sub19.anIntArray8392[0] == 0) {
            if (Class320_Sub19.anIntArray8392[0] == 0) {
               System.out.println("Shader linking failed:");
            }

            OpenGL.glGetObjectParameterivARB(l, 35716, Class320_Sub19.anIntArray8392, 1);
            if (Class320_Sub19.anIntArray8392[1] > 1) {
               byte[] bs = new byte[Class320_Sub19.anIntArray8392[1]];
               OpenGL.glGetInfoLogARB(l, Class320_Sub19.anIntArray8392[1], Class320_Sub19.anIntArray8392, 0, bs, 0);
               System.out.println("abit: " + new String(bs));
            }

            if (Class320_Sub19.anIntArray8392[0] == 0) {
               for(int i = 0; class237s.length > i; ++i) {
                  OpenGL.glDetachObjectARB(l, class237s[i].aLong2907);
               }

               OpenGL.glDeleteObjectARB(l);
               return null;
            }
         }

         return new Class288(glxtoolkit, l, class237s);
      }
   }

   final void method225(int i, DrawableModel drawablemodel, int i_1_) {
      ++anInt232;
      if (this.aClass48_233 != null) {
         if (i != 0) {
            method233(-17);
         }

         if (this.method247(29340)) {
            drawablemodel.method625(
               this.aClass226_270.aCacheNode_Sub15_2683,
               this.anInt247,
               this.aClass48_233.anIntArray707[this.anInt259],
               this.aClass226_270.aCacheNode_Sub15_2687,
               this.aClass226_270.anInt2685,
               this.aClass226_270.anInt2688,
               i_1_,
               -114,
               this.aClass48_233.aBoolean691
            );
            if (this.aBoolean234 && this.aClass48_233.anIntArray712 != null && this.aClass226_241.aBoolean2689) {
               drawablemodel.method625(
                  this.aClass226_241.aCacheNode_Sub15_2683,
                  this.anInt247,
                  this.aClass48_233.anIntArray707[this.anInt259],
                  this.aClass226_241.aCacheNode_Sub15_2687,
                  this.aClass226_241.anInt2685,
                  this.aClass226_241.anInt2688,
                  i_1_,
                  -100,
                  this.aClass48_233.aBoolean691
               );
            }
         }
      }
   }

   final boolean method226(byte b, int i) {
      if (b > -57) {
         this.anInt253 = -70;
      }

      ++anInt250;
      int var3;
      return this.aClass48_233 == null | (var3 = i - this.anInt237) <= 0
         ? false
         : this.aClass48_233.aBoolean714 | this.anInt247 + var3 > this.aClass48_233.anIntArray707[this.anInt259];
   }

   final void method227(int i, int i_2_) {
      this.anInt237 = i;
      int i_3_ = -117 % ((57 - i_2_) / 54);
      ++anInt271;
   }

   final void setAnimation(int animationId, int i_4_, byte b, int i_5_, boolean bool) {
      ++anInt244;
      if (this.getAnimationId() != animationId) {
         if (animationId == -1) {
            this.aClass48_233 = null;
         } else {
            if (this.aClass48_233 != null && animationId == this.aClass48_233.anInt711) {
               if (~this.aClass48_233.anInt706 == -1) {
                  return;
               }
            } else {
               this.aClass48_233 = Class367.aClass37_4540.method395(animationId, (byte)-93);
            }

            this.anInt237 = i_4_;
            this.anInt253 = i_5_;
            this.anInt255 = 0;
            if (!bool) {
               this.anInt247 = 0;
               this.anInt259 = 0;
            } else {
               this.anInt259 = (int)((double)this.aClass48_233.anIntArray715.length * Math.random());
               this.anInt247 = (int)(Math.random() * (double)this.aClass48_233.anIntArray707[this.anInt259]);
            }

            this.anInt243 = 1 + this.anInt259;
            if (~this.anInt243 > -1 || this.anInt243 >= this.aClass48_233.anIntArray715.length) {
               this.anInt243 = -1;
            }

            if (this.anInt237 == 0) {
               this.method222(this.anInt259, this.aClass48_233, (byte)10);
            }

            this.aBoolean263 = false;
         }

         this.method244(-109);
      }

      int i_6_ = 50 % ((-15 - b) / 51);
   }

   final void method229(byte b, int i) {
      int i_7_ = -34 % ((-51 - b) / 55);
      this.anInt259 = 0;
      ++anInt268;
      this.anInt243 = this.aClass48_233.anIntArray715.length <= 1 ? -1 : 1;
      this.anInt247 = 0;
      this.aBoolean263 = false;
      this.anInt237 = i;
      this.anInt255 = 0;
      if (this.aClass48_233 != null) {
         this.method222(this.anInt259, this.aClass48_233, (byte)82);
         this.method244(-115);
      }
   }

   static final void method230(int i, int i_8_, int i_9_, int i_10_, int i_11_) {
      ++anInt240;
      int i_12_ = -7 % ((22 - i_9_) / 43);
      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 18, (long)i << 32 | (long)i_10_);
      cachenode_sub2.method2288(0);
      cachenode_sub2.anInt9434 = i_11_;
      cachenode_sub2.anInt9432 = i_8_;
   }

   static final Class256 method231(boolean bool, Mobile mobile) {
      ++anInt246;
      Class256 class256;
      if (Class329.aClass256_4122 != null) {
         class256 = Class329.aClass256_4122;
         Class329.aClass256_4122 = Class329.aClass256_4122.aClass256_3238;
         class256.aClass256_3238 = null;
         --RuntimeException_Sub1.anInt4922;
      } else {
         class256 = new Class256();
      }

      class256.aMobile3239 = mobile;
      if (bool) {
         method230(83, -97, -118, -83, -95);
      }

      return class256;
   }

   final void method232(int i, Animator animator_13_) {
      this.aClass48_233 = animator_13_.aClass48_233;
      this.aBoolean234 = animator_13_.aBoolean234;
      this.aBoolean263 = animator_13_.aBoolean263;
      if (i != 18634) {
         this.method235(-122);
      }

      this.anInt237 = animator_13_.anInt237;
      this.anInt255 = animator_13_.anInt255;
      ++anInt236;
      this.anInt243 = animator_13_.anInt243;
      this.anInt259 = animator_13_.anInt259;
      this.anInt247 = animator_13_.anInt247;
      this.method244(-124);
   }

   public static void method233(int i) {
      aClass346_252 = null;
      if (i != 100) {
         method236(true, 5);
      }
   }

   final void method234(int i, int i_14_, int i_15_) {
      if (i_15_ >= 97) {
         this.setAnimation(i_14_, i, (byte)109, 0, false);
         ++anInt267;
      }
   }

   final void method235(int i) {
      this.method229((byte)-127, i);
      ++anInt256;
   }

   static final int method236(boolean bool, int i) {
      if (bool) {
         aClass346_252 = null;
      }

      ++anInt242;
      return 0xFF & i;
   }

   final int method237(byte b) {
      ++anInt235;
      if (b >= -125) {
         this.method247(-46);
      }

      if (this.method247(29340)) {
         int i = 0;
         if (this.method247(29340)) {
            i |= this.aClass226_270.anInt2691;
            if (this.aBoolean234 && this.aClass48_233.anIntArray712 != null) {
               i |= this.aClass226_241.anInt2691;
            }
         }

         return i;
      } else {
         return 0;
      }
   }

   final boolean method238(int i) {
      ++anInt257;
      if (i > -10) {
         this.method227(-2, -59);
      }

      return this.aBoolean263;
   }

   static final void method239(DrawableModel drawablemodel, int i, int i_16_, int i_17_, Class171 class171, int i_18_) {
      ++anInt264;
      if (i_18_ < -77 && drawablemodel != null) {
         class171.method1793(
            drawablemodel.fa(),
            drawablemodel.HA(),
            i_16_,
            i_17_,
            drawablemodel.G(),
            -45,
            drawablemodel.na(),
            i,
            drawablemodel.EA(),
            drawablemodel.V(),
            drawablemodel.RA()
         );
      }
   }

   final void method240(boolean bool, int i, int i_19_) {
      ++anInt260;
      if (i_19_ != 838828768) {
         this.method240(true, 51, 15);
      }

      this.setAnimation(i, 0, (byte)-78, 0, bool);
   }

   final void method241(DrawableModel drawablemodel, int i) {
      ++anInt238;
      if (this.method247(29340)) {
         drawablemodel.method631(this.aClass226_270.anInt2685, i + 68, this.aClass226_270.aCacheNode_Sub15_2683);
         if (this.aBoolean234 && this.aClass48_233.anIntArray712 != null && this.aClass226_241.aBoolean2689) {
            drawablemodel.method631(this.aClass226_241.anInt2685, 37, this.aClass226_241.aCacheNode_Sub15_2683);
         }
      }

      if (i != 0) {
         this.method222(-63, null, (byte)-38);
      }
   }

   final boolean method242(byte b) {
      if (b != -77) {
         this.anInt255 = -105;
      }

      ++anInt248;
      return ~this.anInt237 != -1;
   }

   final Class48 method243(byte b) {
      ++anInt272;
      if (b != -24) {
         this.method226((byte)-69, -21);
      }

      return this.aClass48_233;
   }

   private final void method244(int i) {
      if (i >= -107) {
         this.anInt237 = 2;
      }

      this.aClass226_270.method2115((byte)-116);
      ++anInt239;
      if (this.aBoolean234) {
         this.aClass226_241.method2115((byte)-110);
      }
   }

   final boolean method245(int i) {
      ++anInt266;
      if (i >= -123) {
         this.method247(-25);
      }

      return this.aClass48_233 != null;
   }

   final void method246(int i, int i_20_, boolean bool, DrawableModel drawablemodel) {
      ++anInt262;
      if (this.method247(29340)) {
         drawablemodel.method634(
            this.anInt247,
            this.aClass226_270.aCacheNode_Sub15_2683,
            this.aClass226_270.aCacheNode_Sub15_2687,
            this.aClass226_270.anInt2685,
            i_20_,
            null,
            (byte)-83,
            this.aClass48_233.anIntArray707[this.anInt259],
            this.aClass48_233.aBoolean691,
            this.aClass226_270.anInt2688,
            i
         );
         if (this.aBoolean234 && this.aClass48_233.anIntArray712 != null && this.aClass226_241.aBoolean2689) {
            drawablemodel.method634(
               this.anInt247,
               this.aClass226_241.aCacheNode_Sub15_2683,
               this.aClass226_241.aCacheNode_Sub15_2687,
               this.aClass226_241.anInt2685,
               i_20_,
               null,
               (byte)-83,
               this.aClass48_233.anIntArray707[this.anInt259],
               this.aClass48_233.aBoolean691,
               this.aClass226_241.anInt2688,
               i
            );
         }
      }

      if (!bool) {
         this.anInt259 = -48;
      }
   }

   final boolean method247(int i) {
      if (i != 29340) {
         return true;
      } else {
         ++anInt245;
         if (this.aClass48_233 == null) {
            return false;
         } else {
            boolean bool = this.aClass226_270
               .method2110(Class367.aClass37_4540, (byte)-93, this.aClass48_233, this.anInt243, this.anInt259, this.aClass48_233.anIntArray715);
            if (bool && this.aBoolean234 && this.aClass48_233.anIntArray712 != null) {
               this.aClass226_241
                  .method2110(Class367.aClass37_4540, (byte)-123, this.aClass48_233, this.anInt243, this.anInt259, this.aClass48_233.anIntArray712);
            }

            return bool;
         }
      }
   }

   final boolean method248(int i, int i_21_) {
      ++anInt249;
      if (i >= -83) {
         this.getAnimationId();
      }

      if (this.aClass48_233 != null && i_21_ != 0) {
         if (this.anInt237 > 0) {
            if (this.anInt237 >= i_21_) {
               this.anInt237 -= i_21_;
               return false;
            }

            i_21_ -= this.anInt237;
            this.anInt237 = 0;
            this.method222(this.anInt259, this.aClass48_233, (byte)87);
         }

         i_21_ += this.anInt247;
         boolean bool = Class320_Sub12.aBoolean8325 | this.aClass48_233.aBoolean714;
         if (i_21_ > 100 && ~this.aClass48_233.anInt696 < -1) {
            int i_22_;
            for(i_22_ = this.aClass48_233.anIntArray715.length - this.aClass48_233.anInt696;
               this.anInt259 < i_22_ && i_21_ > this.aClass48_233.anIntArray707[this.anInt259];
               ++this.anInt259
            ) {
               i_21_ -= this.aClass48_233.anIntArray707[this.anInt259];
            }

            if (~i_22_ >= ~this.anInt259) {
               int i_23_ = 0;

               for(int i_24_ = i_22_; i_24_ < this.aClass48_233.anIntArray715.length; ++i_24_) {
                  i_23_ += this.aClass48_233.anIntArray707[i_24_];
               }

               if (this.anInt253 == 0) {
                  this.anInt255 += i_21_ / i_23_;
               }

               i_21_ %= i_23_;
            }

            this.anInt243 = 1 + this.anInt259;
            bool = true;
            if (~this.anInt243 <= ~this.aClass48_233.anIntArray715.length) {
               this.anInt243 -= this.aClass48_233.anInt696;
               if (~this.anInt243 > -1 || ~this.aClass48_233.anIntArray715.length >= ~this.anInt243) {
                  this.anInt243 = -1;
               }
            }
         }

         while(this.aClass48_233.anIntArray707[this.anInt259] < i_21_) {
            i_21_ -= this.aClass48_233.anIntArray707[this.anInt259++];
            bool = true;
            if (this.aClass48_233.anIntArray715.length <= this.anInt259) {
               if (~this.aClass48_233.anInt696 != 0 && this.anInt253 != 2) {
                  this.anInt259 -= this.aClass48_233.anInt696;
                  if (this.anInt253 == 0) {
                     ++this.anInt255;
                  }
               }

               if (this.anInt255 >= this.aClass48_233.anInt708 || this.anInt259 < 0 || this.anInt259 >= this.aClass48_233.anIntArray715.length) {
                  this.aBoolean263 = true;
                  break;
               }
            }

            this.method222(this.anInt259, this.aClass48_233, (byte)102);
            this.anInt243 = this.anInt259 + 1;
            if (~this.anInt243 <= ~this.aClass48_233.anIntArray715.length) {
               this.anInt243 -= this.aClass48_233.anInt696;
               if (this.anInt243 < 0 || this.anInt243 >= this.aClass48_233.anIntArray715.length) {
                  this.anInt243 = -1;
               }
            }
         }

         this.anInt247 = i_21_;
         if (bool) {
            this.method244(-108);
         }

         return bool;
      } else {
         return false;
      }
   }

   final void method249(boolean bool, int i) {
      ++anInt251;
      if (!bool) {
         this.method240(true, -1, 58);
      }

      this.setAnimation(i, 0, (byte)60, 0, false);
   }

   final int getAnimationId() {
      ++anInt261;
      return this.aClass48_233 != null ? this.aClass48_233.anInt711 : -1;
   }

   final void method251(boolean bool) {
      ++anInt258;
      this.anInt255 = 0;
      if (!bool) {
         this.anInt237 = 98;
      }
   }

   Animator(boolean bool) {
      this.aBoolean234 = bool;
      this.aClass226_270 = new Class226();
      if (!this.aBoolean234) {
         this.aClass226_241 = null;
      } else {
         this.aClass226_241 = new Class226();
      }
   }
}
