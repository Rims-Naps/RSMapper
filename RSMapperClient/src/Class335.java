public class Class335 {
   static int anInt4160;
   static Class61 aClass61_4161 = new Class61(20);
   static int anInt4162;
   static Class383[] aClass383Array4163;
   static int anInt4164;
   static int[] anIntArray4165 = new int[16384];
   private CacheNode aCacheNode4166 = new CacheNode();
   static int[] anIntArray4167 = new int[16384];
   static int anInt4168;
   private int anInt4169;
   private HashTable aHashTable4170;
   private Class158 aClass158_4171 = new Class158();
   private int anInt4172;

   static {
      double d = 3.834951969714103E-4;

      for(int i = 0; i < 16384; ++i) {
         anIntArray4167[i] = (int)(16384.0 * Math.sin((double)i * d));
         anIntArray4165[i] = (int)(16384.0 * Math.cos(d * (double)i));
      }
   }

   final void method3848(byte b, CacheNode cachenode, long l) {
      if (b > -110) {
         this.aCacheNode4166 = null;
      }

      ++anInt4162;
      if (this.anInt4169 == 0) {
         CacheNode cachenode_0_ = this.aClass158_4171.method1717(-97);
         cachenode_0_.method2160((byte)118);
         cachenode_0_.method2275(-112);
         if (this.aCacheNode4166 == cachenode_0_) {
            cachenode_0_ = this.aClass158_4171.method1717(-108);
            cachenode_0_.method2160((byte)66);
            cachenode_0_.method2275(-124);
         }
      } else {
         --this.anInt4169;
      }

      this.aHashTable4170.put(l, cachenode, -125);
      this.aClass158_4171.method1719(true, cachenode);
   }

   final CacheNode method3849(long l, boolean bool) {
      ++anInt4160;
      if (!bool) {
         return null;
      } else {
         CacheNode cachenode = (CacheNode)this.aHashTable4170.get(3512, l);
         if (cachenode != null) {
            this.aClass158_4171.method1719(true, cachenode);
         }

         return cachenode;
      }
   }

   public static void method3850(int i) {
      if (i != -14731) {
         aClass61_4161 = null;
      }

      anIntArray4167 = null;
      aClass383Array4163 = null;
      anIntArray4165 = null;
      aClass61_4161 = null;
   }

   final void method3851(int i, long l) {
      ++anInt4168;
      if (i != 16384) {
         this.aHashTable4170 = null;
      }

      CacheNode cachenode = (CacheNode)this.aHashTable4170.get(3512, l);
      if (cachenode != null) {
         cachenode.method2160((byte)37);
         cachenode.method2275(-96);
         ++this.anInt4169;
      }
   }

   final void method3852(byte b) {
      this.aClass158_4171.method1722(true);
      ++anInt4164;
      this.aHashTable4170.method1517(false);
      if (b <= 65) {
         this.method3851(79, 58L);
      }

      this.aCacheNode4166 = new CacheNode();
      this.anInt4169 = this.anInt4172;
   }

   Class335(int i) {
      this.anInt4169 = i;
      this.anInt4172 = i;
      int i_1_ = 1;

      while(i_1_ + i_1_ < i) {
         i_1_ += i_1_;
      }

      this.aHashTable4170 = new HashTable(i_1_);
   }
}
