abstract class Plane {
   protected int anInt3398;
   static int anInt3399;
   static int anInt3400;
   static boolean[] aBooleanArray3401 = new boolean[5];
   static int anInt3402;
   static String[] aStringArray3403 = new String[200];
   protected int anInt3404;
   static int anInt3405;
   static Class133 aClass133_3406 = new Class133(14, 0);
   protected int[][] tileVerticeHeights;
   protected int anInt3408;
   static Class133 aClass133_3409 = new Class133(15, 4);
   protected int anInt3410;
   static Class133 aClass133_3411 = new Class133(16, -2);
   static Class133 aClass133_3412 = new Class133(17, 0);
   static Class133 aClass133_3413 = new Class133(19, -2);
   static Class133 aClass133_3414 = new Class133(22, -2);
   static Class133 aClass133_3415 = new Class133(23, 4);
   static Class133 aClass133_3416 = new Class133(24, -1);
   static Class133 aClass133_3417 = new Class133(26, 0);
   static Class133 aClass133_3418 = new Class133(27, 0);
   static Class133 aClass133_3419 = new Class133(28, -2);
   static Class133 aClass133_3420 = new Class133(29, -2);
   static Class133 aClass133_3421 = new Class133(30, -2);
   private static Class133[] aClass133Array3422 = new Class133[32];
   static int anInt3423;

   static {
      Class133[] class133s = Class320_Sub11.method3723(0);

      for(int i = 0; i < class133s.length; ++i) {
         aClass133Array3422[class133s[i].packetId] = class133s[i];
      }

      anInt3423 = 0;
   }

   abstract void wa(r var1, int var2, int var3, int var4, int var5, boolean var6);

   abstract void CA(r var1, int var2, int var3, int var4, int var5, boolean var6);

   static final int method3249(int i, int i_6_, int i_7_, int i_8_) {
      if (i_6_ < 18) {
         anInt3423 = 33;
      }

      ++anInt3405;
      int i_9_ = -i_8_ + 255;
      i = (0xFF0000 & (0xFF00 & i) * i_8_ | (i & 16711935) * i_8_ & -16711936) >>> 8;
      return i + ((0xFF0000 & i_9_ * (0xFF00 & i_7_) | -16711936 & (i_7_ & 16711935) * i_9_) >>> 8);
   }

   abstract void method3250(Node_Sub29 var1, int[] var2);

   final int getVerticeHeight(int y, int x, byte junk) {
      if (junk != -118) {
         this.method3255(2, 101, 8, 52, -36, 105, 3, null);
      }

      ++anInt3400;
      return this.tileVerticeHeights[x][y];
   }

   abstract void method3252(int var1, int var2, int var3, boolean[][] var4, boolean var5, int var6);

   abstract void method3253(
      int var1,
      int var2,
      int[] var3,
      int[] var4,
      int[] var5,
      int[] var6,
      int[] var7,
      int[] var8,
      int[] var9,
      int[] var10,
      int[] var11,
      int[] var12,
      int[] var13,
      int var14,
      int var15,
      int var16,
      boolean var17
   );

   public static void method3254(byte b) {
      aClass133_3409 = null;
      aClass133_3418 = null;
      aStringArray3403 = null;
      aClass133_3406 = null;
      aBooleanArray3401 = null;
      aClass133_3411 = null;
      aClass133_3420 = null;
      aClass133_3414 = null;
      aClass133_3416 = null;
      aClass133_3412 = null;
      aClass133_3419 = null;
      aClass133_3415 = null;
      aClass133_3421 = null;
      aClass133Array3422 = null;
      aClass133_3417 = null;
      aClass133_3413 = null;
   }

   abstract void method3255(int var1, int var2, int var3, int var4, int var5, int var6, int var7, boolean[][] var8);

   abstract boolean method3256(r var1, int var2, int var3, int var4, int var5, boolean var6);

   abstract void ka(int var1, int var2, int var3);

   abstract r fa(int var1, int var2, r var3);

   abstract void U(
      int var1,
      int var2,
      int[] var3,
      int[] var4,
      int[] var5,
      int[] var6,
      int[] var7,
      int[] var8,
      int[] var9,
      int[] var10,
      int var11,
      int var12,
      int var13,
      boolean var14
   );

   abstract void YA();

   abstract void method3257(int var1, int var2);

   Plane(int i, int i_52_, int i_53_, int[][] is) {
      this.anInt3408 = i;
      this.anInt3404 = i_52_;

      int i_54_;
      for(i_54_ = 0; i_53_ > 1; i_53_ >>= 1) {
         ++i_54_;
      }

      this.anInt3398 = 1 << i_54_;
      this.anInt3410 = i_54_;
      this.tileVerticeHeights = is;
   }

   static final void method3258(int i, int i_55_, int i_56_) {
      ++anInt3402;
      int i_57_ = Class262_Sub15_Sub1.aClass357_10524.method4033((byte)-6, Class22.aClass22_387.getStoredString(Class35.language));
      int i_58_;
      if (Class194_Sub3_Sub1.aBoolean9375) {
         for(CacheNode_Sub4 cachenode_sub4 = (CacheNode_Sub4)Class184.aClass158_2189.method1723(13);
            cachenode_sub4 != null;
            cachenode_sub4 = (CacheNode_Sub4)Class184.aClass158_2189.method1721(0)
         ) {
            int i_59_;
            if (cachenode_sub4.anInt9462 != 1) {
               i_59_ = Node_Sub14.method2551(cachenode_sub4, -1);
            } else {
               i_59_ = Node_Sub19.method2609((byte)-88, (CacheNode_Sub13)cachenode_sub4.aClass158_9457.aCacheNode1984.aCacheNode7035);
            }

            if (i_59_ > i_57_) {
               i_57_ = i_59_;
            }
         }

         i_57_ += 8;
         Class219.anInt2627 = (Node_Sub38_Sub5.aBoolean10130 ? 26 : 22) + Class21.anInt355 * 16;
         i_58_ = 21 + Class21.anInt355 * 16;
      } else {
         for(CacheNode_Sub13 cachenode_sub13 = (CacheNode_Sub13)Class368.aClass312_4549.method3613(65280);
            cachenode_sub13 != null;
            cachenode_sub13 = (CacheNode_Sub13)Class368.aClass312_4549.method3620(16776960)
         ) {
            int i_60_ = Node_Sub19.method2609((byte)110, cachenode_sub13);
            if (i_57_ < i_60_) {
               i_57_ = i_60_;
            }
         }

         i_57_ += 8;
         Class219.anInt2627 = (Node_Sub38_Sub5.aBoolean10130 ? 26 : 22) + 16 * Class315.anInt4035;
         i_58_ = Class315.anInt4035 * 16 + 21;
      }

      int i_61_ = -(i_57_ / 2) + i_56_;
      if (~Class360.canvasWidth > ~(i_57_ + i_61_)) {
         i_61_ = -i_57_ + Class360.canvasWidth;
      }

      if (i_61_ < 0) {
         i_61_ = 0;
      }

      int i_63_ = i_55_;
      if (i_55_ - -i_58_ > Class205.canvasHeight) {
         i_63_ = -i_58_ + Class205.canvasHeight;
      }

      if (i_63_ < 0) {
         i_63_ = 0;
      }

      Node_Sub6.anInt7043 = i_61_;
      Class213.rightClickDialogueIsOpen = true;
      Client.anInt5481 = i_63_;
      Class362.anInt4492 = i_57_;
   }

   abstract void method3259(int var1, int var2, int var3, boolean[][] var4, boolean var5, int var6, int var7);

   final int getMedianHeightFromVertices(int y, int junk, int x) {
      ++anInt3399;
      int localX = x >> this.anInt3410;
      int localY = y >> this.anInt3410;
      if (localX >= 0 && localY >= 0 && this.anInt3408 - 1 >= localX && this.anInt3404 - 1 >= localY) {
         int i_72_ = this.anInt3398 - 1 & x;
         if (junk >= -108) {
            method3249(43, -34, -123, 59);
         }

         int i_73_ = this.anInt3398 - 1 & y;
         int i_74_ = i_72_ * this.tileVerticeHeights[1 + localX][localY] + (this.anInt3398 - i_72_) * this.tileVerticeHeights[localX][localY]
            >> this.anInt3410;
         int i_75_ = this.tileVerticeHeights[localX][localY + 1] * (this.anInt3398 + -i_72_) - -(i_72_ * this.tileVerticeHeights[localX + 1][localY + 1])
            >> this.anInt3410;
         return (-i_73_ + this.anInt3398) * i_74_ - -(i_73_ * i_75_) >> this.anInt3410;
      } else {
         return 0;
      }
   }
}
