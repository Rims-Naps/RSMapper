abstract class r extends CacheNode {
   static Class58 aClass58_9578;
   static int anInt9579;
   static int[] anIntArray9580 = new int[]{7, 8, 9, 10, 11, 12, 13, 15};
   static int anInt9581;
   static int anInt9582;
   static int anInt9583;
   static int anInt9584;

   static final boolean method2357(byte b, char c) {
      ++anInt9581;
      if (b != -117) {
         anIntArray9580 = null;
      }

      if (Character.isISOControl(c)) {
         return false;
      } else if (Class316.method3662(false, c)) {
         return true;
      } else {
         char[] cs = Class175.aCharArray2098;

         for(int i = 0; ~i > ~cs.length; ++i) {
            int i_0_ = cs[i];
            if (i_0_ == c) {
               return true;
            }
         }

         char[] cs_1_ = Node_Sub28.aCharArray7331;

         for(int i = 0; i < cs_1_.length; ++i) {
            int i_2_ = cs_1_[i];
            if (~c == ~i_2_) {
               return true;
            }
         }

         return false;
      }
   }

   static final void method2358(int i, byte b, int i_3_) {
      ++anInt9582;
      if (b == -106) {
         CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(b ^ -107, 1, (long)i_3_);
         cachenode_sub2.method2288(0);
         cachenode_sub2.anInt9434 = i;
      }
   }

   static final int method2359(String string, byte b, int i, String string_4_) {
      ++anInt9583;
      int i_5_ = string_4_.length();
      int i_6_ = string.length();
      int i_7_ = 0;
      int i_8_ = 0;
      if (b != -4) {
         anIntArray9580 = null;
      }

      char c = 0;
      char c_9_ = 0;

      while(-c + i_7_ < i_5_ || i_6_ > -c_9_ + i_8_) {
         if (i_7_ - c >= i_5_) {
            return -1;
         }

         if (i_6_ <= i_8_ + -c_9_) {
            return 1;
         }

         char c_10_;
         if (~c != -1) {
            c_10_ = c;
         } else {
            c_10_ = string_4_.charAt(i_7_++);
         }

         char c_11_;
         if (~c_9_ != -1) {
            c_11_ = c_9_;
         } else {
            c_11_ = string.charAt(i_8_++);
         }

         c = GLPlane.method3264(c_10_, true);
         c_9_ = GLPlane.method3264(c_11_, true);
         c_10_ = Class169.method1755(6272, i, c_10_);
         c_11_ = Class169.method1755(b + 6276, i, c_11_);
         if (~c_10_ != ~c_11_ && ~Character.toUpperCase(c_10_) != ~Character.toUpperCase(c_11_)) {
            c_10_ = Character.toLowerCase(c_10_);
            c_11_ = Character.toLowerCase(c_11_);
            if (~c_11_ != ~c_10_) {
               return Class320_Sub22.method3766((byte)119, i, c_10_) + -Class320_Sub22.method3766((byte)101, i, c_11_);
            }
         }
      }

      int i_12_ = Math.min(i_5_, i_6_);

      for(int i_13_ = 0; ~i_12_ < ~i_13_; ++i_13_) {
         if (~i != -3) {
            i_8_ = i_13_;
            i_7_ = i_13_;
         } else {
            i_7_ = -1 + i_5_ + -i_13_;
            i_8_ = -1 + i_6_ + -i_13_;
         }

         char c_14_ = string_4_.charAt(i_7_);
         char c_15_ = string.charAt(i_8_);
         if (~c_14_ != ~c_15_ && ~Character.toUpperCase(c_14_) != ~Character.toUpperCase(c_15_)) {
            c_14_ = Character.toLowerCase(c_14_);
            c_15_ = Character.toLowerCase(c_15_);
            if (~c_14_ != ~c_15_) {
               return Class320_Sub22.method3766((byte)106, i, c_14_) - Class320_Sub22.method3766((byte)109, i, c_15_);
            }
         }
      }

      int i_16_ = -i_6_ + i_5_;
      if (i_16_ != 0) {
         return i_16_;
      } else {
         for(int i_17_ = 0; i_17_ < i_12_; ++i_17_) {
            char c_18_ = string_4_.charAt(i_17_);
            char c_19_ = string.charAt(i_17_);
            if (c_18_ != c_19_) {
               return Class320_Sub22.method3766((byte)103, i, c_18_) + -Class320_Sub22.method3766((byte)105, i, c_19_);
            }
         }

         return 0;
      }
   }

   public r() {
   }

   static final void createHeightMarker(int pointX, int pointY, boolean gridPoints, int height, int x, int y, int plane, int color, int delayCycles) {
      ++anInt9579;
      TileMarker entitynode_sub2 = new TileMarker();
      entitynode_sub2.type = TileMarker.Type.HEIGHT;
      entitynode_sub2.x = x;
      entitynode_sub2.y = y;
      entitynode_sub2.plane = plane;
      entitynode_sub2.height = height;
      entitynode_sub2.color = color;
      entitynode_sub2.message = "|";
      entitynode_sub2.completeCycle = Class174.clientCycle + delayCycles;
      entitynode_sub2.pointX1 = pointX;
      entitynode_sub2.pointY1 = pointY;
      entitynode_sub2.gridPoints = gridPoints;
      Class226.aClass103_2684.method1110(false, entitynode_sub2);
   }

   static final void createShapeMarker(
      int pointX1, int pointY1, int pointX2, int pointY2, boolean gridPoints, int x, int y, int plane, int height, int color, int delayCycles
   ) {
      ++anInt9579;
      TileMarker entitynode_sub2 = new TileMarker();
      entitynode_sub2.type = TileMarker.Type.SHAPE;
      entitynode_sub2.x = x;
      entitynode_sub2.y = y;
      entitynode_sub2.plane = plane;
      entitynode_sub2.height = height;
      entitynode_sub2.color = color;
      entitynode_sub2.message = ".";
      entitynode_sub2.completeCycle = Class174.clientCycle + delayCycles;
      entitynode_sub2.pointX1 = pointX1;
      entitynode_sub2.pointY1 = pointY1;
      entitynode_sub2.pointX2 = pointX2;
      entitynode_sub2.pointY2 = pointY2;
      entitynode_sub2.gridPoints = gridPoints;
      Class226.aClass103_2684.method1110(false, entitynode_sub2);
   }

   static final void createLineMarker(int pointX1, int pointY1, int pointX2, int pointY2, int x, int y, int plane, int height, int color, int delayCycles) {
      ++anInt9579;
      TileMarker entitynode_sub2 = new TileMarker();
      entitynode_sub2.type = TileMarker.Type.LINE;
      entitynode_sub2.x = x;
      entitynode_sub2.y = y;
      entitynode_sub2.plane = plane;
      entitynode_sub2.height = height;
      entitynode_sub2.color = color;
      entitynode_sub2.message = ".";
      entitynode_sub2.completeCycle = Class174.clientCycle + delayCycles;
      entitynode_sub2.pointX1 = pointX1;
      entitynode_sub2.pointY1 = pointY1;
      entitynode_sub2.pointX2 = pointX2;
      entitynode_sub2.pointY2 = pointY2;
      entitynode_sub2.gridPoints = false;
      Class226.aClass103_2684.method1110(false, entitynode_sub2);
   }

   static final void createTextMarker(String text, int x, int y, int plane, int height, int color, int delayCycles) {
      ++anInt9579;
      TileMarker entitynode_sub2 = new TileMarker();
      entitynode_sub2.type = TileMarker.Type.TEXT;
      entitynode_sub2.x = x;
      entitynode_sub2.y = y;
      entitynode_sub2.plane = plane;
      entitynode_sub2.height = height;
      entitynode_sub2.color = color;
      entitynode_sub2.message = text;
      entitynode_sub2.completeCycle = Class174.clientCycle + delayCycles;
      Class226.aClass103_2684.method1110(false, entitynode_sub2);
   }

   static final void createTileMarker(int x, int y, int plane, int height, int color, int delayCycles) {
      ++anInt9579;
      TileMarker entitynode_sub2 = new TileMarker();
      entitynode_sub2.type = TileMarker.Type.TILE;
      entitynode_sub2.x = x;
      entitynode_sub2.y = y;
      entitynode_sub2.plane = plane;
      entitynode_sub2.height = height;
      entitynode_sub2.color = color;
      entitynode_sub2.message = ".";
      entitynode_sub2.completeCycle = Class174.clientCycle + delayCycles;
      Class226.aClass103_2684.method1110(false, entitynode_sub2);
   }

   static final void sendSpriteOnTile(
      int spriteId, int x, int y, int plane, int height, int delayCycles, int pointX1, int pointY1, int pointX2, int pointY2, boolean gridPoints
   ) {
      ++anInt9579;
      TileMarker entitynode_sub2 = new TileMarker();
      entitynode_sub2.x = x;
      entitynode_sub2.y = y;
      entitynode_sub2.plane = plane;
      entitynode_sub2.height = height;
      entitynode_sub2.color = 0;
      entitynode_sub2.message = "";
      entitynode_sub2.completeCycle = Class174.clientCycle + delayCycles;
      entitynode_sub2.pointX1 = pointX1;
      entitynode_sub2.pointY1 = pointY1;
      entitynode_sub2.pointX2 = pointX2;
      entitynode_sub2.pointY2 = pointY2;
      entitynode_sub2.spriteId = spriteId;
      entitynode_sub2.gridPoints = gridPoints;
      Class226.aClass103_2684.method1110(false, entitynode_sub2);
   }

   static final boolean method2361(int i, int i_26_) {
      if (i_26_ < 1) {
         method2361(-95, -35);
      }

      ++anInt9584;
      return i >= 0 && ~i >= -4 || ~i == -10;
   }

   public static void method2362() {
      aClass58_9578 = null;
      anIntArray9580 = null;
   }
}
