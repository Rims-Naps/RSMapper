import com.dropbox.core.v2.DbxClientV2;

public class Class151 {
   static int anInt1841;
   protected int anInt1842;
   static int anInt1843 = 0;
   protected int anInt1844;
   static IncommingPacket aClass192_1845 = new IncommingPacket(86, 0);
   protected int anInt1846;
   protected int anInt1847;
   public static DbxClientV2 aHashTable1923;

   static final void method1671(
      int i,
      int cX,
      int height,
      int cY,
      byte[][][] bs,
      int[] is,
      int[] is_3_,
      int[] is_4_,
      int[] is_5_,
      int[] is_6_,
      int i_7_,
      byte b,
      int pX,
      int pY,
      boolean bool,
      boolean bool_10_,
      int i_11_,
      int i_12_,
      boolean bool_13_
   ) {
      Mobile_Sub1.aBoolean10959 = true;
      Class239.aBoolean2932 = CacheNode_Sub18.aGraphicsToolkit9607.getanInt6367() > 0;
      Class307.aBoolean3898 = bool_10_;
      Class216.anInt2551 = cX >> Class36.INT_9;
      EntityNode_Sub7.anInt6013 = cY >> Class36.INT_9;
      GLPlane.anInt7920 = Class98.cameraPosX;
      Class380.anInt4889 = Node_Sub10.cameraPosY;
      Class194_Sub3.anInt6900 = height;
      Class238.anInt2915 = Class216.anInt2551 - Node_Sub9_Sub1.anInt9656;
      if (Class238.anInt2915 < 0) {
         Class126.anInt1634 = -Class238.anInt2915;
         Class238.anInt2915 = 0;
      } else {
         Class126.anInt1634 = 0;
      }

      Class320_Sub9.anInt8295 = EntityNode_Sub7.anInt6013 - Node_Sub9_Sub1.anInt9656;
      if (Class320_Sub9.anInt8295 < 0) {
         Node_Sub2.anInt6934 = -Class320_Sub9.anInt8295;
         Class320_Sub9.anInt8295 = 0;
      } else {
         Node_Sub2.anInt6934 = 0;
      }

      Class46.anInt679 = Class216.anInt2551 + Node_Sub9_Sub1.anInt9656;
      if (Class46.anInt679 > Class328.SCENE_WIDTH_X) {
         Class46.anInt679 = Class328.SCENE_WIDTH_X;
      }

      Class367.anInt4533 = EntityNode_Sub7.anInt6013 + Node_Sub9_Sub1.anInt9656;
      if (Class367.anInt4533 > Node_Sub50.SCENE_WIDTH_Y) {
         Class367.anInt4533 = Node_Sub50.SCENE_WIDTH_Y;
      }

      boolean[][] bools = Class139.aBooleanArrayArray1730;
      boolean[][] bools_14_ = Class75.aBooleanArrayArray1002;
      if (Class307.aBoolean3898) {
         for(int i_15_ = 0; i_15_ < Node_Sub9_Sub1.anInt9656 + Node_Sub9_Sub1.anInt9656 + 2; ++i_15_) {
            int i_16_ = 0;
            int i_17_ = 0;

            for(int i_18_ = 0; i_18_ < Node_Sub9_Sub1.anInt9656 + Node_Sub9_Sub1.anInt9656 + 2; ++i_18_) {
               if (i_18_ > 1) {
                  Node_Sub38_Sub7.anIntArray10150[i_18_ - 2] = i_16_;
               }

               i_16_ = i_17_;
               int i_19_ = Class216.anInt2551 - Node_Sub9_Sub1.anInt9656 + i_15_;
               int i_20_ = EntityNode_Sub7.anInt6013 - Node_Sub9_Sub1.anInt9656 + i_18_;
               if (i_19_ >= 0 && i_20_ >= 0 && i_19_ < Class328.SCENE_WIDTH_X && i_20_ < Node_Sub50.SCENE_WIDTH_Y) {
                  int i_21_ = i_19_ << Class36.INT_9;
                  int i_22_ = i_20_ << Class36.INT_9;
                  int i_23_ = Node_Sub38_Sub37.aPlaneArray10466[Node_Sub38_Sub37.aPlaneArray10466.length - 1].getVerticeHeight(i_20_, i_19_, (byte)-118)
                     - (1000 << Class36.INT_9 - 7);
                  int i_24_ = (
                        Class368.aPlaneArray4548 != null
                           ? Class368.aPlaneArray4548[0].getVerticeHeight(i_20_, i_19_, (byte)-118) + Class179.INT_18
                           : Node_Sub38_Sub37.aPlaneArray10466[0].getVerticeHeight(i_20_, i_19_, (byte)-118) + Class179.INT_18
                     )
                     + (1000 << Class36.INT_9 - 7);
                  i_17_ = i_11_ >= 0
                     ? CacheNode_Sub18.aGraphicsToolkit9607.r(i_21_, i_23_, i_22_, i_21_, i_24_, i_22_, i_11_)
                     : CacheNode_Sub18.aGraphicsToolkit9607.JA(i_21_, i_23_, i_22_, i_21_, i_24_, i_22_);
                  Class75.aBooleanArrayArray1002[i_15_][i_18_] = i_17_ == 0;
               } else {
                  i_17_ = -1;
                  Class75.aBooleanArrayArray1002[i_15_][i_18_] = false;
               }

               if (i_15_ > 0 && i_18_ > 0) {
                  int i_25_ = Node_Sub38_Sub7.anIntArray10150[i_18_ - 1] & Node_Sub38_Sub7.anIntArray10150[i_18_] & i_16_ & i_17_;
                  Class139.aBooleanArrayArray1730[i_15_ - 1][i_18_ - 1] = i_25_ == 0;
               }
            }

            Node_Sub38_Sub7.anIntArray10150[Node_Sub9_Sub1.anInt9656 + Node_Sub9_Sub1.anInt9656] = i_16_;
            Node_Sub38_Sub7.anIntArray10150[Node_Sub9_Sub1.anInt9656 + Node_Sub9_Sub1.anInt9656 + 1] = i_17_;
         }

         if (i_11_ >= 0) {
            Mobile_Sub1.aBoolean10959 = false;
         } else {
            Class290_Sub11.anIntArray8180 = is;
            aa_Sub3.anIntArray5490 = is_3_;
            EntityNode_Sub3_Sub1.anIntArray9161 = is_4_;
            Class121.anIntArray1528 = is_5_;
            CacheNode_Sub18.anIntArray9605 = is_6_;
            Class385.method4204(CacheNode_Sub18.aGraphicsToolkit9607, i_7_, (byte)-20);
         }
      } else {
         if (Class122.aBooleanArrayArray1555 == null) {
            Class122.aBooleanArrayArray1555 = new boolean[Class328.SCENE_WIDTH_X + Class328.SCENE_WIDTH_X + 1][Node_Sub50.SCENE_WIDTH_Y
               + Class328.SCENE_WIDTH_X
               + 1];
         }

         for(int i_26_ = 0; i_26_ < Class122.aBooleanArrayArray1555.length; ++i_26_) {
            for(int i_27_ = 0; i_27_ < Class122.aBooleanArrayArray1555[0].length; ++i_27_) {
               Class122.aBooleanArrayArray1555[i_26_][i_27_] = true;
            }
         }

         Class75.aBooleanArrayArray1002 = Class122.aBooleanArrayArray1555;
         Class139.aBooleanArrayArray1730 = Class122.aBooleanArrayArray1555;
         Class238.anInt2915 = 0;
         Class320_Sub9.anInt8295 = 0;
         Class46.anInt679 = Class328.SCENE_WIDTH_X;
         Class367.anInt4533 = Node_Sub50.SCENE_WIDTH_Y;
         Mobile_Sub1.aBoolean10959 = false;
      }

      Class266.method3237(0, CacheNode_Sub18.aGraphicsToolkit9607);
      if (!Node_Sub36_Sub3.aClass179_10058.aBoolean2130) {
         Class103 class103 = Node_Sub36_Sub3.aClass179_10058.aClass103_2124;

         for(EntityNode_Sub6 entitynode_sub6 = (EntityNode_Sub6)class103.method1113((byte)108);
            entitynode_sub6 != null;
            entitynode_sub6 = (EntityNode_Sub6)class103.method1108(61)
         ) {
            entitynode_sub6.method803(false);
            Class148.method1650(0, entitynode_sub6);
         }
      }

      if (Class239.aBoolean2932) {
         for(int i_28_ = 0; i_28_ < Class188_Sub1_Sub1.fxCount; ++i_28_) {
            Class143.aLightFXArray1771[i_28_].method3816(bool, i, (byte)114);
         }
      }

      if (Class188_Sub2.BOOL_FALSE) {
         Class20_Sub1.anIntArray5510 = CacheNode_Sub18.aGraphicsToolkit9607.Y();
         CacheNode_Sub18.aGraphicsToolkit9607.K(Class129.anIntArray1669);
         int i_29_ = (Class129.anIntArray1669[2] - Class129.anIntArray1669[0]) / Class290.anInt3655;

         for(int i_30_ = 0; i_30_ < Class290.anInt3655 - 1; ++i_30_) {
            Node_Sub38_Sub25.anIntArray10358[i_30_] = i_29_ * (i_30_ + 1) + Class270_Sub2.anIntArray8039[i_30_];
         }

         for(int i_31_ = 0; i_31_ < GraphicsToolkit.aClass33Array1549.length; ++i_31_) {
            GraphicsToolkit.aClass33Array1549[i_31_].method366();
         }
      }

      if (Class225.aClass261ArrayArrayArray2680 != null) {
         if (Class188_Sub2.BOOL_FALSE) {
            Node_Sub38_Sub16.method2840(0);
         }

         Node_Sub38_Sub17.method2842(true);
         CacheNode_Sub18.aGraphicsToolkit9607.ra(-1, 1583160, 40, 127);
         Class274.method3326(true, bs, i_7_, b, i_11_, i_12_, bool_13_);
         if (Class188_Sub2.BOOL_FALSE) {
            Class134.method1569();
         }

         CacheNode_Sub18.aGraphicsToolkit9607.pa();
         Node_Sub38_Sub17.method2842(false);
      }

      Class274.method3326(false, bs, i_7_, b, i_11_, i_12_, bool_13_);
      if (Class188_Sub2.BOOL_FALSE) {
         for(int i_32_ = 0; i_32_ < Class159.anInt1995; ++i_32_) {
            Class150_Sub2.aBooleanArrayArrayArray8960[i_32_] = Class234.aBooleanArrayArrayArray2790[i_32_];
         }

         Node_Sub38_Sub16.method2840(0);

         for(int i_33_ = 0; i_33_ < GraphicsToolkit.aClass33Array1549.length; ++i_33_) {
            GraphicsToolkit.aClass33Array1549[i_33_].method366();
         }
      }

      if (Class188_Sub2.BOOL_FALSE) {
         Class134.method1569();

         for(int i_34_ = 0; i_34_ < Class159.anInt1995; ++i_34_) {
            Class234.aBooleanArrayArrayArray2790[i_34_] = Class150_Sub2.aBooleanArrayArrayArray8960[i_34_];
         }

         if (Class22.INT_ONE == 2) {
            if (Class270_Sub1.aLongArray8029[0] < Class270_Sub1.aLongArray8029[1]) {
               if (Node_Sub38_Sub25.anIntArray10358[0] + Class270_Sub2.anIntArray8039[0] > Class129.anIntArray1669[0]) {
                  Class270_Sub2.anIntArray8039[0]++;
               }
            } else if (Class270_Sub1.aLongArray8029[0] > Class270_Sub1.aLongArray8029[1]
               && Node_Sub38_Sub25.anIntArray10358[0] + Class270_Sub2.anIntArray8039[0] < Class129.anIntArray1669[2]) {
               Class270_Sub2.anIntArray8039[0]--;
            }
         }
      }

      if (!Class307.aBoolean3898) {
         Class139.aBooleanArrayArray1730 = bools;
         Class75.aBooleanArrayArray1002 = bools_14_;
      }

      Class175.method1803();
   }

   @Override
   public final String toString() {
      ++anInt1841;
      throw new IllegalStateException();
   }

   public static void method1672(int i) {
      if (i == 30781) {
         aClass192_1845 = null;
      }
   }

   Class151(int i, int i_35_, int i_36_, int i_37_) {
      this.anInt1842 = i_37_;
      this.anInt1844 = i;
      this.anInt1847 = i_36_;
      this.anInt1846 = i_35_;
   }
}
