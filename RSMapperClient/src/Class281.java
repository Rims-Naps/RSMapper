public class Class281 {
   static int anInt3571;
   private Index aClass302_3572;
   static int anInt3573;
   static int anInt3574;
   static IncommingPacket aClass192_3575 = new IncommingPacket(114, 4);
   private Class61 aClass61_3576 = new Class61(64);
   static int anInt3577;
   protected Class363 aClass363_3578;
   static int[] minimapAreaIconObjectIds = new int[1000];
   static int anInt3580;

   final void method3379(byte junk) {
      synchronized(this.aClass61_3576) {
         this.aClass61_3576.method608(false);
      }

      ++anInt3571;
   }

   final void method3380(int i, boolean bool) {
      ++anInt3574;
      if (!bool) {
         this.method3379((byte)46);
      }

      synchronized(this.aClass61_3576) {
         this.aClass61_3576.method598(i, -11819);
      }
   }

   public static void method3381(int i) {
      aClass192_3575 = null;
      minimapAreaIconObjectIds = null;
   }

   final void method3382(int i) {
      synchronized(this.aClass61_3576) {
         this.aClass61_3576.method602((byte)-123);
      }

      if (i != 1) {
         minimapAreaIconObjectIds = null;
      }

      ++anInt3577;
   }

   final RenderDefinitions getAnimationAndSoundDefinitionsFor(int emoteFileId) {
      ++anInt3573;
      RenderDefinitions animationDefs;
      synchronized(this.aClass61_3576) {
         animationDefs = (RenderDefinitions)this.aClass61_3576.method607((long)emoteFileId, 0);
      }

      if (animationDefs != null) {
         return animationDefs;
      } else {
         byte[] bs;
         synchronized(this.aClass302_3572) {
            bs = this.aClass302_3572.getFile(false, emoteFileId, 32);
         }

         animationDefs = new RenderDefinitions();
         animationDefs.aClass281_3265 = this;
         if (bs != null) {
            animationDefs.method3134((byte)-33, new Buffer(bs));
         }

         synchronized(this.aClass61_3576) {
            this.aClass61_3576.method601(animationDefs, 25566, (long)emoteFileId);
            return animationDefs;
         }
      }
   }

   static final void method3384(byte b) {
      ++anInt3580;

      for(CacheNode_Sub4 cachenode_sub4 = (CacheNode_Sub4)Class184.aClass158_2189.method1723(13);
         cachenode_sub4 != null;
         cachenode_sub4 = (CacheNode_Sub4)Class184.aClass158_2189.method1721(0)
      ) {
         if (cachenode_sub4.anInt9462 > 1) {
            cachenode_sub4.anInt9462 = 0;
            Class200_Sub2.aClass61_4941
               .method601(cachenode_sub4, 25566, ((CacheNode_Sub13)cachenode_sub4.aClass158_9457.aCacheNode1984.aCacheNode7035).aLong9564);
            cachenode_sub4.aClass158_9457.method1722(true);
         }
      }

      Class21.anInt355 = 0;
      Class315.anInt4035 = 0;
      Class368.aClass312_4549.method3614(-601);
      Class261.aHashTable3306.method1517(false);
      Class184.aClass158_2189.method1722(true);
      Class213.rightClickDialogueIsOpen = false;
   }

   Class281(Class353 class353, int i, Index class302, Class363 class363) {
      this.aClass302_3572 = class302;
      this.aClass302_3572.method3537(-2, 32);
      this.aClass363_3578 = class363;
   }
}
