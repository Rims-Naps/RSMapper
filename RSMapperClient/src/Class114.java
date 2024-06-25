public class Class114 {
   static int anInt1452;
   private int anInt1453;
   private CacheNode aCacheNode1454;
   static int[][] anIntArrayArray1455 = new int[][]{
      {2, 4, 6, 0},
      {0, 2, 4, 6},
      {0, 2, 4},
      {4, 0, 2},
      {2, 4, 0},
      {0, 2, 4},
      {6, 0, 1, 2, 4, 5},
      {0, 4, 7, 6},
      {4, 7, 6, 0},
      {0, 8, 6, 2, 9, 4},
      {2, 9, 4, 0, 8, 6},
      {2, 11, 4, 6, 10, 0},
      {2, 4, 6, 0}
   };
   static int anInt1456;
   static int anInt1457;
   static volatile boolean aBoolean1458 = true;
   static int anInt1459;
   static long aLong1460 = 0L;
   private long aLong1461;
   static int compassId = 1339;
   private CacheNode[] aCacheNodeArray1463;

   public static void method1154(int i) {
      if (i == -1) {
         anIntArrayArray1455 = null;
      }
   }

   static final GraphicsToolkit method1155(d var_d, java.awt.Canvas canvas, int i, int i_0_) {
      ++anInt1457;
      return i_0_ > -35 ? null : new GLToolkit(canvas, var_d, i);
   }

   final void method1156(byte b, CacheNode cachenode, long l) {
      if (b == 91) {
         if (cachenode.aCacheNode7036 != null) {
            cachenode.method2275(-95);
         }

         ++anInt1459;
         CacheNode cachenode_1_ = this.aCacheNodeArray1463[(int)((long)(this.anInt1453 + -1) & l)];
         cachenode.aCacheNode7035 = cachenode_1_;
         cachenode.aCacheNode7036 = cachenode_1_.aCacheNode7036;
         cachenode.aCacheNode7036.aCacheNode7035 = cachenode;
         cachenode.aCacheNode7035.aCacheNode7036 = cachenode;
         cachenode.aLong7037 = l;
      }
   }

   final CacheNode method1157(long l, int i) {
      this.aLong1461 = l;
      ++anInt1456;
      CacheNode cachenode = this.aCacheNodeArray1463[(int)(l & (long)(this.anInt1453 - i))];

      for(this.aCacheNode1454 = cachenode.aCacheNode7035; cachenode != this.aCacheNode1454; this.aCacheNode1454 = this.aCacheNode1454.aCacheNode7035) {
         if (~l == ~this.aCacheNode1454.aLong7037) {
            CacheNode cachenode_2_ = this.aCacheNode1454;
            this.aCacheNode1454 = this.aCacheNode1454.aCacheNode7035;
            return cachenode_2_;
         }
      }

      this.aCacheNode1454 = null;
      return null;
   }

   final CacheNode method1158(int i) {
      ++anInt1452;
      if (this.aCacheNode1454 == null) {
         return null;
      } else {
         for(CacheNode cachenode = this.aCacheNodeArray1463[(int)(this.aLong1461 & (long)(i + this.anInt1453))];
            this.aCacheNode1454 != cachenode;
            this.aCacheNode1454 = this.aCacheNode1454.aCacheNode7035
         ) {
            if (this.aLong1461 == this.aCacheNode1454.aLong7037) {
               CacheNode cachenode_3_ = this.aCacheNode1454;
               this.aCacheNode1454 = this.aCacheNode1454.aCacheNode7035;
               return cachenode_3_;
            }
         }

         this.aCacheNode1454 = null;
         return null;
      }
   }

   Class114(int i) {
      this.aCacheNodeArray1463 = new CacheNode[i];
      this.anInt1453 = i;

      for(int i_4_ = 0; ~i_4_ > ~i; ++i_4_) {
         CacheNode cachenode = this.aCacheNodeArray1463[i_4_] = new CacheNode();
         cachenode.aCacheNode7036 = cachenode;
         cachenode.aCacheNode7035 = cachenode;
      }
   }
}
