public class Mobile_Sub1 extends Mobile {
   static int anInt10911;
   private double aDouble10912;
   static int anInt10913;
   private int anInt10914 = 0;
   private boolean aBoolean10915;
   private double aDouble10916;
   private double aDouble10917;
   static int anInt10918;
   private int anInt10919;
   private int anInt10920;
   private double aDouble10921;
   static int anInt10922;
   protected int anInt10923;
   static int anInt10924;
   private double aDouble10925;
   static int anInt10926;
   private double aDouble10927;
   static int anInt10928;
   static int anInt10929;
   static int anInt10930 = 0;
   private int anInt10931;
   static int anInt10932;
   private int anInt10933;
   private int anInt10934;
   static int anInt10935;
   static int anInt10936;
   private int anInt10937;
   protected int anInt10938;
   private double aDouble10939;
   private boolean aBoolean10940 = false;
   static int anInt10941;
   protected int anInt10942;
   private EntityNode_Sub4 anEntityNode_Sub4_10943;
   static int anInt10944;
   static int anInt10945;
   static int anInt10946;
   static Class104 aClass104_10947 = new Class104();
   private int anInt10948;
   static int anInt10949;
   private int anInt10950 = 0;
   private boolean aBoolean10951 = false;
   static int anInt10952;
   static int anInt10953;
   static int anInt10954;
   private Animator anAnimator10955;
   private int anInt10956;
   private double aDouble10957;
   protected int anInt10958;
   static boolean aBoolean10959 = true;
   static int anInt10960 = 0;
   static boolean aBoolean10961 = false;

   @Override
   final int method817(int i) {
      if (i != 2) {
         this.aBoolean10915 = false;
      }

      ++anInt10941;
      return this.anInt10950;
   }

   final void method895(int i, boolean bool, int i_0_, int i_1_, int i_2_) {
      if (!this.aBoolean10951) {
         double d = (double)(-this.x + i_2_);
         double d_3_ = (double)(-this.y + i_1_);
         double d_4_ = Math.sqrt(d_3_ * d_3_ + d * d);
         this.aDouble10921 = (double)this.anInt10937 * d_3_ / d_4_ + (double)this.y;
         this.aDouble10957 = (double)this.x + d * (double)this.anInt10937 / d_4_;
         if (!this.aBoolean10915) {
            this.aDouble10925 = (double)this.anInt5937;
         } else {
            this.aDouble10925 = (double)(
               Node_Sub38_Sub7.getTileMedianHeight(this.plane, -29754, (int)this.aDouble10921, (int)this.aDouble10957) - this.anInt10956
            );
         }
      }

      ++anInt10913;
      double d = (double)(this.anInt10923 - -1 - i_0_);
      this.aDouble10916 = ((double)i_1_ - this.aDouble10921) / d;
      this.aDouble10939 = ((double)i_2_ - this.aDouble10957) / d;
      if (bool) {
         this.anInt10942 = -124;
      }

      this.aDouble10927 = Math.sqrt(this.aDouble10939 * this.aDouble10939 + this.aDouble10916 * this.aDouble10916);
      if (~this.anInt10933 != 0) {
         if (!this.aBoolean10951) {
            this.aDouble10912 = -this.aDouble10927 * Math.tan(0.02454369 * (double)this.anInt10933);
         }

         this.aDouble10917 = 2.0 * (-(d * this.aDouble10912) + -this.aDouble10925 + (double)i) / (d * d);
      } else {
         this.aDouble10912 = (-this.aDouble10925 + (double)i) / d;
      }
   }

   @Override
   final Class171 method809(GraphicsToolkit graphicstoolkit, int i) {
      ++anInt10935;
      if (i >= -93) {
         this.aDouble10957 = 1.3103535335051488;
      }

      return null;
   }

   @Override
   final void method845(int i) {
      this.aShort9119 = this.aShort9130 = (short)((int)(this.aDouble10957 / 512.0));
      ++anInt10954;
      this.aShort9120 = this.aShort9124 = (short)((int)(this.aDouble10921 / 512.0));
   }

   @Override
   final void method811(int i) {
      ++anInt10944;
      if (i != 27811) {
         this.anInt10920 = -9;
      }

      throw new IllegalStateException();
   }

   @Override
   final void method816(int i, boolean bool, GraphicsToolkit graphicstoolkit, int i_6_, byte b, int i_7_, Animable animable) {
      if (b >= 101) {
         ++anInt10918;
         throw new IllegalStateException();
      }
   }

   private final DrawableModel method896(int i, GraphicsToolkit graphicstoolkit, int i_8_) {
      ++anInt10952;
      Class195 class195 = Class16.aClass101_228.method1090(116, this.anInt10948);
      return class195.method1989(this.anAnimator10955, (byte)2, i, (byte)87, graphicstoolkit);
   }

   final void method897(int i) {
      if (i > -30) {
         this.method807(18, null);
      }

      ++anInt10953;
      if (this.anEntityNode_Sub4_10943 != null) {
         this.anEntityNode_Sub4_10943.method953();
      }
   }

   @Override
   final boolean method813(int i) {
      if (i != 0) {
         return true;
      } else {
         ++anInt10932;
         return this.aBoolean10940;
      }
   }

   final void method898(boolean bool) {
      ++anInt10928;
      if (bool) {
         this.anInt10914 = -84;
      }

      if (!this.aBoolean10951 && this.anInt10934 != 0) {
         Actor actor = null;
         if (aa.anInt101 != 3) {
            if (this.anInt10934 < 0) {
               int i = -1 + -this.anInt10934;
               if (Class166.myPlayerIndex == i) {
                  actor = Class295.myPlayer;
               } else {
                  actor = Class270_Sub2.LOCAL_PLAYERS[i];
               }
            } else {
               int i = this.anInt10934 + -1;
               Node_Sub41 node_sub41 = (Node_Sub41)Class12.aHashTable187.get(3512, (long)i);
               if (node_sub41 != null) {
                  actor = node_sub41.aNpc7518;
               }
            }
         } else {
            actor = Class121.aClass206Array1529[this.anInt10934 - 1].method2037(-61);
         }

         if (actor != null) {
            this.y = actor.y;
            this.x = actor.x;
            this.anInt5937 = Node_Sub38_Sub7.getTileMedianHeight(this.plane, -29754, actor.y, actor.x) - this.anInt10956;
            if (this.anInt10920 >= 0) {
               RenderDefinitions class259 = actor.method868((byte)-128);
               int i = 0;
               int i_10_ = 0;
               if (class259.anIntArrayArray3273 != null && class259.anIntArrayArray3273[this.anInt10920] != null) {
                  i_10_ += class259.anIntArrayArray3273[this.anInt10920][2];
                  i += class259.anIntArrayArray3273[this.anInt10920][0];
               }

               if (class259.anIntArrayArray3249 != null && class259.anIntArrayArray3249[this.anInt10920] != null) {
                  i_10_ += class259.anIntArrayArray3249[this.anInt10920][2];
                  i += class259.anIntArrayArray3249[this.anInt10920][0];
               }

               if (~i != -1 || i_10_ != 0) {
                  int i_11_ = actor.aClass99_10893.method1086(16383);
                  int i_12_ = i_11_;
                  if (actor.anIntArray10881 != null && ~actor.anIntArray10881[this.anInt10920] != 0) {
                     i_12_ = actor.anIntArray10881[this.anInt10920];
                  }

                  int i_13_ = -i_11_ + i_12_ & 16383;
                  int i_14_ = Class335.anIntArray4167[i_13_];
                  int i_15_ = Class335.anIntArray4165[i_13_];
                  int i_16_ = i_14_ * i_10_ - -(i_15_ * i) >> 14;
                  i_10_ = i_10_ * i_15_ - i_14_ * i >> 14;
                  this.y += i_10_;
                  this.x += i_16_;
               }
            }
         }
      }
   }

   @Override
   final boolean method814(byte b) {
      ++anInt10936;
      return false;
   }

   @Override
   final int method823(byte b) {
      if (b != -21) {
         return 39;
      } else {
         ++anInt10922;
         return this.anInt10914;
      }
   }

   private final void method899(byte b, GraphicsToolkit graphicstoolkit, Class336 class336, DrawableModel drawablemodel) {
      drawablemodel.method614(class336);
      ++anInt10924;
      Class300[] class300s = drawablemodel.method620();
      Class218[] class218s = drawablemodel.method618();
      if ((this.anEntityNode_Sub4_10943 == null || this.anEntityNode_Sub4_10943.aBoolean5972) && (class300s != null || class218s != null)) {
         this.anEntityNode_Sub4_10943 = EntityNode_Sub4.method963(Class174.clientCycle, true);
      }

      if (b == -75 && this.anEntityNode_Sub4_10943 != null) {
         this.anEntityNode_Sub4_10943.method952(graphicstoolkit, (long)Class174.clientCycle, class300s, class218s, false);
         this.anEntityNode_Sub4_10943.method967(this.plane, this.aShort9119, this.aShort9130, this.aShort9120, this.aShort9124);
      }
   }

   public static void method900(int i) {
      if (i > -95) {
         anInt10960 = -48;
      }

      aClass104_10947 = null;
   }

   @Override
   final boolean method821(int i) {
      if (i != 0) {
         return true;
      } else {
         ++anInt10929;
         return false;
      }
   }

   @Override
   final void method820(GraphicsToolkit graphicstoolkit, int i) {
      if (i != -5) {
         aClass104_10947 = null;
      }

      ++anInt10949;
      DrawableModel drawablemodel = this.method896(0, graphicstoolkit, i + 75);
      if (drawablemodel != null) {
         Class336 class336 = graphicstoolkit.A();
         class336.method3865(this.anInt10931);
         class336.method3856(this.anInt10919);
         class336.method3863((int)this.aDouble10957, (int)this.aDouble10925, (int)this.aDouble10921);
         this.anInt10950 = drawablemodel.fa();
         this.anInt10914 = drawablemodel.ma();
         this.method899((byte)-75, graphicstoolkit, class336, drawablemodel);
      }
   }

   @Override
   final EntityNode_Sub6 method807(int i, GraphicsToolkit graphicstoolkit) {
      ++anInt10945;
      DrawableModel drawablemodel = this.method896(2048, graphicstoolkit, 46);
      if (drawablemodel == null) {
         return null;
      } else {
         Class336 class336 = graphicstoolkit.A();
         class336.method3865(this.anInt10931);
         class336.method3856(this.anInt10919);
         class336.method3863((int)this.aDouble10957, (int)this.aDouble10925, (int)this.aDouble10921);
         this.method899((byte)-75, graphicstoolkit, class336, drawablemodel);
         EntityNode_Sub6 entitynode_sub6 = Class345.method3972(false, (byte)-118, 1);
         if (!Node_Sub15_Sub10.aBoolean9850) {
            drawablemodel.method611(class336, entitynode_sub6.anEntityNode_Sub5Array5995[0], 0);
         } else {
            drawablemodel.method622(class336, entitynode_sub6.anEntityNode_Sub5Array5995[0], Class308.anInt3912, 0);
         }

         if (this.anEntityNode_Sub4_10943 != null) {
            Class198 class198 = this.anEntityNode_Sub4_10943.method954();
            if (Node_Sub15_Sub10.aBoolean9850) {
               graphicstoolkit.a(class198, Class308.anInt3912);
            } else {
               graphicstoolkit.a(class198);
            }
         }

         this.aBoolean10940 = drawablemodel.F();
         this.anInt10950 = drawablemodel.fa();
         this.anInt10914 = drawablemodel.ma();
         return entitynode_sub6;
      }
   }

   @Override
   protected final void finalize() {
      if (this.anEntityNode_Sub4_10943 != null) {
         this.anEntityNode_Sub4_10943.method953();
      }

      ++anInt10926;
   }

   @Override
   final boolean method810(int i, int i_18_, boolean bool, GraphicsToolkit graphicstoolkit) {
      if (bool) {
         this.aDouble10925 = -0.10988590233715705;
      }

      ++anInt10946;
      return false;
   }

   final void method901(byte b, int i) {
      this.aDouble10957 += (double)i * this.aDouble10939;
      this.aBoolean10951 = true;
      this.aDouble10921 += (double)i * this.aDouble10916;
      ++anInt10911;
      if (!this.aBoolean10915) {
         if (~this.anInt10933 == 0) {
            this.aDouble10925 += this.aDouble10912 * (double)i;
         } else {
            this.aDouble10925 += (double)i * this.aDouble10912 + this.aDouble10917 * 0.5 * (double)i * (double)i;
            this.aDouble10912 += (double)i * this.aDouble10917;
         }
      } else {
         this.aDouble10925 = (double)(
            Node_Sub38_Sub7.getTileMedianHeight(this.plane, -29754, (int)this.aDouble10921, (int)this.aDouble10957) + -this.anInt10956
         );
      }

      this.anInt10919 = 16383 & 8192 + (int)(Math.atan2(this.aDouble10939, this.aDouble10916) * 2607.5945876176133);
      if (b == 56) {
         this.anInt10931 = 16383 & (int)(Math.atan2(this.aDouble10912, this.aDouble10927) * 2607.5945876176133);
         if (this.anAnimator10955.method248(-100, 1) && this.anAnimator10955.method238(-28)) {
            this.anAnimator10955.method235(0);
         }
      }
   }

   Mobile_Sub1(
      int i,
      int i_19_,
      int i_20_,
      int i_21_,
      int i_22_,
      int i_23_,
      int i_24_,
      int i_25_,
      int i_26_,
      int i_27_,
      int i_28_,
      int i_29_,
      int i_30_,
      boolean bool,
      int i_31_
   ) {
      super(
         i_19_,
         i_20_,
         i_21_,
         -i_23_ + Node_Sub38_Sub7.getTileMedianHeight(i_19_, -29754, i_22_, i_21_),
         i_22_,
         i_21_ >> 9,
         i_21_ >> 9,
         i_22_ >> 9,
         i_22_ >> 9,
         false,
         (byte)0
      );
      this.anInt10956 = i_23_;
      this.anInt10948 = i;
      this.anInt10958 = i_24_;
      this.anInt10920 = i_31_;
      this.aBoolean10915 = bool;
      this.anInt10942 = i_29_;
      this.aBoolean10951 = false;
      this.anInt10923 = i_25_;
      this.anInt10938 = i_30_;
      this.anInt10934 = i_28_;
      this.anInt10933 = i_26_;
      this.anInt10937 = i_27_;
      int i_32_ = Class16.aClass101_228.method1090(-111, this.anInt10948).anInt2394;
      this.anAnimator10955 = new AnimableAnimator(this, false);
      this.anAnimator10955.method249(true, i_32_);
   }
}
