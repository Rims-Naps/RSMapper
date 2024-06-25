public class Class269 {
   static HashTable aHashTable3465 = new HashTable(16);
   private CacheNode aCacheNode3466;
   static int anInt3467;
   private Class158 aClass158_3468;
   static Class308 aClass308_3469;
   static OutgoingPacket aClass318_3470 = new OutgoingPacket(65, 11);
   static int anInt3471;
   static boolean aBoolean3472 = true;
   static int anInt3473;

   public static void method3293(int i) {
      aClass308_3469 = null;
      aHashTable3465 = null;
      if (i == 65) {
         aClass318_3470 = null;
      }
   }

   final CacheNode method3294(int i) {
      ++anInt3471;
      CacheNode cachenode = this.aCacheNode3466;
      if (cachenode == this.aClass158_3468.aCacheNode1984) {
         this.aCacheNode3466 = null;
         return null;
      } else {
         if (i != 16) {
            aClass318_3470 = null;
         }

         this.aCacheNode3466 = cachenode.aCacheNode7035;
         return cachenode;
      }
   }

   final CacheNode method3295(int i) {
      ++anInt3467;
      if (i != 16) {
         return null;
      } else {
         CacheNode cachenode = this.aClass158_3468.aCacheNode1984.aCacheNode7035;
         if (this.aClass158_3468.aCacheNode1984 == cachenode) {
            this.aCacheNode3466 = null;
            return null;
         } else {
            this.aCacheNode3466 = cachenode.aCacheNode7035;
            return cachenode;
         }
      }
   }

   public Class269() {
   }

   Class269(Class158 class158) {
      this.aClass158_3468 = class158;
   }
}
