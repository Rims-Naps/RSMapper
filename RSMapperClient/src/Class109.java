public class Class109 {
   static int anInt1367 = -1;
   private Index aClass302_1368;
   protected int anInt1369 = 0;
   private Class61 aClass61_1370;
   static int anInt1371;
   static int anInt1372;
   protected int anInt1373 = 0;
   static int anInt1374;
   private Index aClass302_1375;
   private Interface14 anInterface14_1376;

   final String method1126(Class151 class151, long l, int[] is, int i) {
      if (i != 1) {
         this.aClass61_1370 = null;
      }

      ++anInt1372;
      if (this.anInterface14_1376 != null) {
         String string = this.anInterface14_1376.method52(0, l, class151, is);
         if (string != null) {
            return string;
         }
      }

      return Long.toString(l);
   }

   static final void method1127(boolean bool) {
      ++anInt1374;

      for(Node_Sub19 node_sub19 = (Node_Sub19)Class89.aClass312_1199.method3613(65280);
         node_sub19 != null;
         node_sub19 = (Node_Sub19)Class89.aClass312_1199.method3620(16776960)
      ) {
         if (node_sub19.aBoolean7156) {
            node_sub19.method2160((byte)97);
         } else {
            node_sub19.aBoolean7159 = true;
            if (node_sub19.x >= 0 && ~node_sub19.y <= -1 && Node_Sub54.GAME_SCENE_WDITH > node_sub19.x && ~Class377_Sub1.GAME_SCENE_HEIGHT < ~node_sub19.y) {
               PacketParser.method2247(103, node_sub19);
            }
         }
      }

      if (!bool) {
         for(Node_Sub19 node_sub19 = (Node_Sub19)Class262_Sub8.aClass312_7755.method3613(65280);
            node_sub19 != null;
            node_sub19 = (Node_Sub19)Class262_Sub8.aClass312_7755.method3620(16776960)
         ) {
            if (node_sub19.aBoolean7156) {
               node_sub19.method2160((byte)30);
            } else {
               node_sub19.aBoolean7159 = true;
            }
         }
      }
   }

   final CacheNode_Sub10 method1128(int i, boolean bool) {
      ++anInt1371;
      CacheNode_Sub10 cachenode_sub10 = (CacheNode_Sub10)this.aClass61_1370.method607((long)i, 0);
      if (cachenode_sub10 != null) {
         return cachenode_sub10;
      } else {
         byte[] bs;
         if (i >= 32768) {
            bs = this.aClass302_1375.getFile(false, 32767 & i, 1);
         } else {
            bs = this.aClass302_1368.getFile(false, i, 1);
         }

         cachenode_sub10 = new CacheNode_Sub10();
         cachenode_sub10.aClass109_9516 = this;
         if (bs != null) {
            cachenode_sub10.method2325(new Buffer(bs), -958);
         }

         if (~i <= -32769) {
            cachenode_sub10.method2328(51);
         }

         if (bool) {
            this.aClass61_1370 = null;
         }

         this.aClass61_1370.method601(cachenode_sub10, 25566, (long)i);
         return cachenode_sub10;
      }
   }

   Class109(int i, Index class302, Index class302_0_, Interface14 interface14) {
      this.aClass61_1370 = new Class61(64);
      this.anInterface14_1376 = null;
      this.anInterface14_1376 = interface14;
      this.aClass302_1368 = class302;
      this.aClass302_1375 = class302_0_;
      if (this.aClass302_1368 != null) {
         this.anInt1373 = this.aClass302_1368.method3537(-2, 1);
      }

      if (this.aClass302_1375 != null) {
         this.anInt1369 = this.aClass302_1375.method3537(-2, 1);
      }
   }
}
