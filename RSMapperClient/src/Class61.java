public class Class61 {
   static Node_Sub9_Sub1 aNode_Sub9_Sub1_885;
   private Class158 aClass158_886 = new Class158();
   static int anInt887;
   static int anInt888;
   static int anInt889;
   static int anInt890;
   static int anInt891;
   static int anInt892;
   static int anInt893;
   static int anInt894;
   static int anInt895;
   static int anInt896;
   private int anInt897;
   static int anInt898 = 0;
   static int anInt899;
   static int anInt900;
   private HashTable aHashTable901;
   private int anInt902;
   static int anInt903;

   final int method595(int i) {
      if (i != 1188) {
         return -47;
      } else {
         ++anInt895;
         return this.anInt897;
      }
   }

   final Object method596(int i) {
      ++anInt893;
      int i_0_ = -15 % ((27 - i) / 63);

      CacheNode_Sub20 cachenode_sub20_1_;
      for(CacheNode_Sub20 cachenode_sub20 = (CacheNode_Sub20)this.aHashTable901.method1516(false);
         cachenode_sub20 != null;
         this.anInt897 += cachenode_sub20_1_.anInt9627
      ) {
         Object object = cachenode_sub20.method2409((byte)-105);
         if (object != null) {
            return object;
         }

         cachenode_sub20_1_ = cachenode_sub20;
         cachenode_sub20 = (CacheNode_Sub20)this.aHashTable901.method1520(67);
         cachenode_sub20_1_.method2160((byte)27);
         cachenode_sub20_1_.method2275(-56);
      }

      return null;
   }

   Class61(int i) {
      this(i, i);
   }

   final int method597(int i) {
      ++anInt899;
      return i != 22349 ? 125 : this.anInt902;
   }

   final void method598(int i, int i_2_) {
      if (i_2_ != -11819) {
         this.anInt897 = -40;
      }

      if (Node_Sub34.aClass115_7410 != null) {
         for(CacheNode_Sub20 cachenode_sub20 = (CacheNode_Sub20)this.aClass158_886.method1723(13);
            cachenode_sub20 != null;
            cachenode_sub20 = (CacheNode_Sub20)this.aClass158_886.method1721(0)
         ) {
            if (!cachenode_sub20.method2411(-96)) {
               if (~(++cachenode_sub20.aLong7037) < ~((long)i)) {
                  CacheNode_Sub20 cachenode_sub20_3_ = Node_Sub34.aClass115_7410.method1160(cachenode_sub20, 23);
                  this.aHashTable901.put(cachenode_sub20.scriptId, cachenode_sub20_3_, -126);
                  Node_Sub38_Sub19.method2847(255, cachenode_sub20, cachenode_sub20_3_);
                  cachenode_sub20.method2160((byte)62);
                  cachenode_sub20.method2275(i_2_ + 11738);
               }
            } else if (cachenode_sub20.method2409((byte)-68) == null) {
               cachenode_sub20.method2160((byte)82);
               cachenode_sub20.method2275(-38);
               this.anInt897 += cachenode_sub20.anInt9627;
            }
         }
      }

      ++anInt890;
   }

   final int method599(byte b) {
      ++anInt894;
      int i = 0;

      for(CacheNode_Sub20 cachenode_sub20 = (CacheNode_Sub20)this.aClass158_886.method1723(13);
         cachenode_sub20 != null;
         cachenode_sub20 = (CacheNode_Sub20)this.aClass158_886.method1721(0)
      ) {
         if (!cachenode_sub20.method2411(b + -184)) {
            ++i;
         }
      }

      if (b != 74) {
         this.method601(null, -10, 125L);
      }

      return i;
   }

   private final void method600(int i, CacheNode_Sub20 cachenode_sub20) {
      ++anInt900;
      if (i == -28711 && cachenode_sub20 != null) {
         cachenode_sub20.method2160((byte)86);
         cachenode_sub20.method2275(-52);
         this.anInt897 += cachenode_sub20.anInt9627;
      }
   }

   final void method601(Object object, int i, long l) {
      ++anInt892;
      this.method604(l, object, 1, 79);
      if (i != 25566) {
         this.method604(-34L, null, 104, 85);
      }
   }

   final void method602(byte b) {
      if (b > -116) {
         this.method597(101);
      }

      for(CacheNode_Sub20 cachenode_sub20 = (CacheNode_Sub20)this.aClass158_886.method1723(13);
         cachenode_sub20 != null;
         cachenode_sub20 = (CacheNode_Sub20)this.aClass158_886.method1721(0)
      ) {
         if (cachenode_sub20.method2411(-107)) {
            cachenode_sub20.method2160((byte)78);
            cachenode_sub20.method2275(-103);
            this.anInt897 += cachenode_sub20.anInt9627;
         }
      }

      ++anInt888;
   }

   final Object method603(byte b) {
      ++anInt889;
      if (b != -22) {
         return null;
      } else {
         CacheNode_Sub20 cachenode_sub20_4_;
         for(CacheNode_Sub20 cachenode_sub20 = (CacheNode_Sub20)this.aHashTable901.method1520(b + 107);
            cachenode_sub20 != null;
            this.anInt897 += cachenode_sub20_4_.anInt9627
         ) {
            Object object = cachenode_sub20.method2409((byte)-86);
            if (object != null) {
               return object;
            }

            cachenode_sub20_4_ = cachenode_sub20;
            cachenode_sub20 = (CacheNode_Sub20)this.aHashTable901.method1520(93);
            cachenode_sub20_4_.method2160((byte)61);
            cachenode_sub20_4_.method2275(-106);
         }

         return null;
      }
   }

   final void method604(long l, Object object, int i, int i_5_) {
      ++anInt891;
      if (i > this.anInt902) {
         throw new IllegalStateException("s>cs");
      } else {
         this.method605(l, -13068);
         this.anInt897 -= i;

         while(~this.anInt897 > -1) {
            CacheNode_Sub20 cachenode_sub20 = (CacheNode_Sub20)this.aClass158_886.method1717(-120);
            this.method600(-28711, cachenode_sub20);
         }

         CacheNode_Sub20_Sub1 cachenode_sub20_sub1 = new CacheNode_Sub20_Sub1(object, i);
         this.aHashTable901.put(l, cachenode_sub20_sub1, -128);
         this.aClass158_886.method1719(true, cachenode_sub20_sub1);
         cachenode_sub20_sub1.aLong7037 = 0L;
         int i_6_ = 14 / ((i_5_ - -6) / 35);
      }
   }

   final void method605(long l, int i) {
      if (i == -13068) {
         ++anInt887;
         CacheNode_Sub20 cachenode_sub20 = (CacheNode_Sub20)this.aHashTable901.get(3512, l);
         this.method600(-28711, cachenode_sub20);
      }
   }

   public static void method606(int i) {
      if (i != -26792) {
         method606(19);
      }

      aNode_Sub9_Sub1_885 = null;
   }

   final Object method607(long l, int i) {
      ++anInt896;
      CacheNode_Sub20 cachenode_sub20 = (CacheNode_Sub20)this.aHashTable901.get(i ^ 3512, l);
      if (i != 0) {
         return null;
      } else if (cachenode_sub20 == null) {
         return null;
      } else {
         Object object = cachenode_sub20.method2409((byte)-101);
         if (object == null) {
            cachenode_sub20.method2160((byte)100);
            cachenode_sub20.method2275(-44);
            this.anInt897 += cachenode_sub20.anInt9627;
            return null;
         } else {
            if (!cachenode_sub20.method2411(-92)) {
               this.aClass158_886.method1719(true, cachenode_sub20);
               cachenode_sub20.aLong7037 = 0L;
            } else {
               CacheNode_Sub20_Sub1 cachenode_sub20_sub1 = new CacheNode_Sub20_Sub1(object, cachenode_sub20.anInt9627);
               this.aHashTable901.put(cachenode_sub20.scriptId, cachenode_sub20_sub1, -125);
               this.aClass158_886.method1719(true, cachenode_sub20_sub1);
               cachenode_sub20_sub1.aLong7037 = 0L;
               cachenode_sub20.method2160((byte)94);
               cachenode_sub20.method2275(-61);
            }

            return object;
         }
      }
   }

   final void method608(boolean bool) {
      ++anInt903;
      this.aClass158_886.method1722(!bool);
      this.aHashTable901.method1517(bool);
      this.anInt897 = this.anInt902;
   }

   Class61(int i, int i_7_) {
      this.anInt902 = i;
      this.anInt897 = i;
      int i_8_ = 1;

      while(i > i_8_ + i_8_ && i_8_ < i_7_) {
         i_8_ += i_8_;
      }

      this.aHashTable901 = new HashTable(i_8_);
   }
}
