public class Class158 {
   static Client aClient1983;
   protected CacheNode aCacheNode1984 = new CacheNode();
   static int anInt1985;
   static int anInt1986;
   static int anInt1987;
   static int anInt1988;
   static int anInt1989;
   private CacheNode aCacheNode1990;
   static int anInt1991;
   static int anInt1992;
   static int anInt1993;
   static int anInt1994 = 0;

   public static void method1716(byte b) {
      aClient1983 = null;
      if (b <= 59) {
         anInt1994 = -116;
      }
   }

   final CacheNode method1717(int i) {
      ++anInt1991;
      CacheNode cachenode = this.aCacheNode1984.aCacheNode7035;
      if (this.aCacheNode1984 == cachenode) {
         return null;
      } else {
         cachenode.method2275(-96);
         if (i > -93) {
            this.aCacheNode1990 = null;
         }

         return cachenode;
      }
   }

   static final void method1718(int i, int i_0_, int i_1_) {
      ++anInt1985;
      if (i == -5091) {
         CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 13, (long)i_0_);
         cachenode_sub2.method2288(0);
         cachenode_sub2.anInt9434 = i_1_;
      }
   }

   final void method1719(boolean bool, CacheNode cachenode) {
      ++anInt1992;
      if (cachenode.aCacheNode7036 != null) {
         cachenode.method2275(-46);
      }

      cachenode.aCacheNode7035 = this.aCacheNode1984;
      cachenode.aCacheNode7036 = this.aCacheNode1984.aCacheNode7036;
      if (!bool) {
         this.aCacheNode1984 = null;
      }

      cachenode.aCacheNode7036.aCacheNode7035 = cachenode;
      cachenode.aCacheNode7035.aCacheNode7036 = cachenode;
   }

   final int method1720(byte b) {
      ++anInt1986;
      int i = 0;

      for(CacheNode cachenode = this.aCacheNode1984.aCacheNode7035; this.aCacheNode1984 != cachenode; ++i) {
         cachenode = cachenode.aCacheNode7035;
      }

      return i;
   }

   final CacheNode method1721(int i) {
      ++anInt1988;
      if (i != 0) {
         return null;
      } else {
         CacheNode cachenode = this.aCacheNode1990;
         if (cachenode == this.aCacheNode1984) {
            this.aCacheNode1990 = null;
            return null;
         } else {
            this.aCacheNode1990 = cachenode.aCacheNode7035;
            return cachenode;
         }
      }
   }

   final void method1722(boolean bool) {
      while(true) {
         CacheNode cachenode = this.aCacheNode1984.aCacheNode7035;
         if (cachenode == this.aCacheNode1984) {
            if (!bool) {
               anInt1994 = 51;
            }

            ++anInt1987;
            this.aCacheNode1990 = null;
            return;
         }

         cachenode.method2275(-109);
      }
   }

   public Class158() {
      this.aCacheNode1984.aCacheNode7035 = this.aCacheNode1984;
      this.aCacheNode1984.aCacheNode7036 = this.aCacheNode1984;
   }

   final CacheNode method1723(int i) {
      if (i != 13) {
         method1725(-79, -71, 120, -17, 93);
      }

      ++anInt1993;
      CacheNode cachenode = this.aCacheNode1984.aCacheNode7035;
      if (cachenode == this.aCacheNode1984) {
         this.aCacheNode1990 = null;
         return null;
      } else {
         this.aCacheNode1990 = cachenode.aCacheNode7035;
         return cachenode;
      }
   }

   static final Class169_Sub2_Sub1 method1724(int i, int i_3_, int i_4_, byte b, int i_5_, GLToolkit gltoolkit) {
      ++anInt1989;
      if (!gltoolkit.aBoolean6652 && (!Class371.method4094(i_4_, false) || !Class371.method4094(i_3_, false))) {
         return !gltoolkit.aBoolean6649
            ? new Class169_Sub2_Sub1(gltoolkit, i, i_5_, i_4_, i_3_, Class320_Sub19.method3753(i_4_), Class320_Sub19.method3753(i_3_), true)
            : new Class169_Sub2_Sub1(gltoolkit, 34037, i, i_5_, i_4_, i_3_, true);
      } else {
         return new Class169_Sub2_Sub1(gltoolkit, 3553, i, i_5_, i_4_, i_3_, true);
      }
   }

   static final void method1725(int i, int i_7_, int i_8_, int i_9_, int i_10_) {
      if (Player.anIntArrayArray11128 != null) {
         Player.anIntArrayArray11128[i][i_7_] = 0xFF000000 | i_8_;
      }

      if (Class146.aShortArrayArray1802 != null) {
         Class146.aShortArrayArray1802[i][i_7_] = (short)i_9_;
      }

      if (Class320_Sub18.aByteArrayArray8379 != null) {
         Class320_Sub18.aByteArrayArray8379[i][i_7_] = (byte)i_10_;
      }
   }
}