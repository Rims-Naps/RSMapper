public class WorldmapAreaDetail extends CacheNode {
   protected int anInt9531 = 0;
   static int anInt9532;
   static int anInt9533;
   static int anInt9534;
   protected int centerLocationHash;
   static int anInt9536;
   protected String archivename;
   static Class329 aClass329_9538 = new Class329("WTI", "office", "_wti", 5);
   static int anInt9539;
   protected int anInt9540 = 12800;
   protected int anInt9541 = 12800;
   protected int emptySpaceDisplayType;
   protected String displayName;
   protected boolean canOpenMapLinks = true;
   protected int anInt9545 = 0;
   protected int fileId;
   protected int zoomOnLoad;
   static Class212 aClass212_9548 = new Class212("", 16);
   protected Class312 aClass312_9549;
   static int anInt9551;

   final boolean method2334(int i, int i_0_, int i_1_, int[] is) {
      ++anInt9551;
      if (i != 2048) {
         this.method2340(-86, (byte)-124, 70, null);
      }

      for(Node_Sub52 node_sub52 = (Node_Sub52)this.aClass312_9549.method3613(65280);
         node_sub52 != null;
         node_sub52 = (Node_Sub52)this.aClass312_9549.method3620(i ^ 16774912)
      ) {
         if (node_sub52.method2977(i_0_, (byte)-20, i_1_)) {
            node_sub52.method2970(is, 2, i_0_, i_1_);
            return true;
         }
      }

      return false;
   }

   final boolean method2335(byte b, int i, int i_2_) {
      int i_3_ = 93 / ((b - 39) / 44);
      ++anInt9539;

      for(Node_Sub52 node_sub52 = (Node_Sub52)this.aClass312_9549.method3613(65280);
         node_sub52 != null;
         node_sub52 = (Node_Sub52)this.aClass312_9549.method3620(16776960)
      ) {
         if (node_sub52.method2977(i, (byte)-76, i_2_)) {
            return true;
         }
      }

      return false;
   }

   static final boolean method2336(int i, int i_4_, int i_5_) {
      if (i != -1) {
         Class277.tileFlags = null;
      }

      ++anInt9536;
      return ~(2048 & i_5_) != -1;
   }

   final boolean method2337(int i, int[] is, int i_6_, int i_7_, int i_8_) {
      ++anInt9533;
      if (i != -12584) {
         return true;
      } else {
         for(Node_Sub52 node_sub52 = (Node_Sub52)this.aClass312_9549.method3613(65280);
            node_sub52 != null;
            node_sub52 = (Node_Sub52)this.aClass312_9549.method3620(16776960)
         ) {
            if (node_sub52.method2975(i_6_, (byte)43, i_7_, i_8_)) {
               node_sub52.method2970(is, i ^ -12582, i_8_, i_6_);
               return true;
            }
         }

         return false;
      }
   }

   public static void method2338(byte b) {
      if (b < 48) {
         Class277.tileFlags = null;
      }

      aClass212_9548 = null;
      aClass329_9538 = null;
      Class277.tileFlags = null;
   }

   final void method2339(int i) {
      this.anInt9545 = 0;
      ++anInt9534;
      this.anInt9541 = 12800;
      if (i == 16) {
         this.anInt9540 = 12800;
         this.anInt9531 = 0;

         for(Node_Sub52 node_sub52 = (Node_Sub52)this.aClass312_9549.method3613(65280);
            node_sub52 != null;
            node_sub52 = (Node_Sub52)this.aClass312_9549.method3620(16776960)
         ) {
            if (~node_sub52.minY2 > ~this.anInt9540) {
               this.anInt9540 = node_sub52.minY2;
            }

            if (~this.anInt9531 > ~node_sub52.maxX2) {
               this.anInt9531 = node_sub52.maxX2;
            }

            if (this.anInt9545 < node_sub52.maxY2) {
               this.anInt9545 = node_sub52.maxY2;
            }

            if (~this.anInt9541 < ~node_sub52.minX2) {
               this.anInt9541 = node_sub52.minX2;
            }
         }
      }
   }

   final boolean method2340(int i, byte b, int i_9_, int[] is) {
      ++anInt9532;

      for(Node_Sub52 node_sub52 = (Node_Sub52)this.aClass312_9549.method3613(65280);
         node_sub52 != null;
         node_sub52 = (Node_Sub52)this.aClass312_9549.method3620(16776960)
      ) {
         if (node_sub52.method2973(i, i_9_, 10598)) {
            node_sub52.method2976(i_9_, is, i, 1);
            return true;
         }
      }

      if (b != 17) {
         Class277.tileFlags = null;
      }

      return false;
   }

   WorldmapAreaDetail(int id, String archiveName, String formattedname, int locationHash, int emptySpace, boolean accessibleLinks, int zoom, int i_14_) {
      this.emptySpaceDisplayType = -1;
      this.zoomOnLoad = -1;
      this.archivename = archiveName;
      this.emptySpaceDisplayType = emptySpace;
      this.centerLocationHash = locationHash;
      this.zoomOnLoad = zoom;
      this.fileId = id;
      this.canOpenMapLinks = accessibleLinks;
      this.displayName = formattedname;
      if (this.zoomOnLoad == 255) {
         this.zoomOnLoad = 0;
      }

      this.aClass312_9549 = new Class312();
   }
}
