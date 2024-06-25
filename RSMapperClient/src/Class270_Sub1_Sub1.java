public class Class270_Sub1_Sub1 extends Class270_Sub1 {
   private int anInt10529;
   private int anInt10530;
   private AbstractToolkit anAbstractToolkit10531;
   static int anInt10532;
   private int anInt10533;
   static int anInt10534;
   static int anInt10535;
   private Interface13_Impl2 anInterface13_Impl2_10536;
   private int anInt10537;
   private int anInt10538;
   private int anInt10539;

   @Override
   final Interface13_Impl2 method3298(byte b) {
      ++anInt10532;
      if (this.anInterface13_Impl2_10536 == null) {
         Class319.anIntArray4058[4] = this.anInt10530;
         Class319.anIntArray4058[5] = this.anInt10538;
         Class319.anIntArray4058[1] = this.anInt10529;
         Class319.anIntArray4058[0] = this.anInt10537;
         Class319.anIntArray4058[2] = this.anInt10533;
         Class319.anIntArray4058[3] = this.anInt10539;
         d var_d = this.anAbstractToolkit10531.aD1543;
         boolean bool = false;
         int i = 0;

         for(int i_0_ = 0; i_0_ < 6; ++i_0_) {
            if (!var_d.method7(b ^ 9955, Class319.anIntArray4058[i_0_])) {
               return null;
            }

            TextureDefinitions class91 = var_d.getTexture(Class319.anIntArray4058[i_0_], -8217);
            int i_1_ = !class91.skipTriangles ? 128 : 64;
            if (~i_1_ < ~i) {
               i = i_1_;
            }

            if (~class91.mipmaps < -1) {
               bool = true;
            }
         }

         for(int i_2_ = 0; ~i_2_ > -7; ++i_2_) {
            Mobile.anIntArrayArray9122[i_2_] = var_d.method11(i, false, i, Class319.anIntArray4058[i_2_], (byte)0, 1.0F);
         }

         this.anInterface13_Impl2_10536 = this.anAbstractToolkit10531.method1287(i, Mobile.anIntArrayArray9122, bool, b + -79);
      }

      if (b != 79) {
         this.anInterface13_Impl2_10536 = null;
      }

      return this.anInterface13_Impl2_10536;
   }

   static final int method3301(int i, int i_3_, int i_4_, int i_5_) {
      ++anInt10535;
      if (~Node_Sub25_Sub1.worldmapLoaded > -101) {
         return -2;
      } else {
         int i_6_ = -2;
         int i_7_ = Integer.MAX_VALUE;
         int i_8_ = i_5_ - WorldmapDefinitions.regionXWorldCoordinate;
         int i_9_ = i_3_ - WorldmapDefinitions.regionYWorldCoordinate;
         if (i_4_ > -46) {
            return 25;
         } else {
            for(Node_Sub14 node_sub14 = (Node_Sub14)WorldmapDefinitions.aClass312_331.method3613(65280);
               node_sub14 != null;
               node_sub14 = (Node_Sub14)WorldmapDefinitions.aClass312_331.method3620(16776960)
            ) {
               if (~node_sub14.anInt7128 == ~i) {
                  int i_10_ = node_sub14.anInt7125;
                  int i_11_ = node_sub14.anInt7120;
                  int i_12_ = WorldmapDefinitions.regionYWorldCoordinate + i_11_ | WorldmapDefinitions.regionXWorldCoordinate + i_10_ << 14;
                  int i_13_ = (-i_11_ + i_9_) * (i_9_ - i_11_) + (i_8_ + -i_10_) * (-i_10_ + i_8_);
                  if (~i_6_ > -1 || ~i_7_ < ~i_13_) {
                     i_7_ = i_13_;
                     i_6_ = i_12_;
                  }
               }
            }

            return i_6_;
         }
      }
   }

   static final void method3302(int localX, int plane, byte b, int i_15_, int localY) {
      if (b >= 90) {
         ++anInt10534;
         if (i_15_ != 8 && ~i_15_ != -17) {
            Class261 class261 = Class175.aClass261ArrayArrayArray2099[plane][localX][localY];
            if (class261 != null) {
               if (~i_15_ != -2) {
                  if (~i_15_ == -3) {
                     class261.aShort3313 = 0;
                  }
               } else {
                  class261.aShort3318 = 0;
               }
            }

            Node_Sub32.method2729(true);
         } else {
            for(int i_17_ = 0; ~Class83.anInt5183 < ~i_17_; ++i_17_) {
               Class54 class54 = IsaacCipher.aClass54Array1840[i_17_];
               if (class54.type == i_15_ && ~localX == ~class54.aShort821 && ~localY == ~class54.aShort815
                  || ~class54.aShort818 == ~localX && localY == class54.aShort815) {
                  if (~i_17_ != ~Class83.anInt5183) {
                     Class311.method3605(
                        IsaacCipher.aClass54Array1840, 1 + i_17_, IsaacCipher.aClass54Array1840, i_17_, -i_17_ + -1 + IsaacCipher.aClass54Array1840.length
                     );
                  }

                  --Class83.anInt5183;
                  break;
               }
            }
         }
      }
   }

   static final Animable_Sub1 method3303(int i, int i_18_, int i_19_) {
      Class261 class261 = Class175.aClass261ArrayArrayArray2099[i][i_18_][i_19_];
      return class261 != null && class261.anAnimable_Sub1_3317 != null ? class261.anAnimable_Sub1_3317 : null;
   }

   Class270_Sub1_Sub1(AbstractToolkit abstracttoolkit, int i, int i_20_, int i_21_, int i_22_, int i_23_, int i_24_) {
      this.anInt10529 = i_20_;
      this.anInt10533 = i_21_;
      this.anInt10538 = i_24_;
      this.anInt10530 = i_23_;
      this.anInt10537 = i;
      this.anInt10539 = i_22_;
      this.anAbstractToolkit10531 = abstracttoolkit;
   }
}
