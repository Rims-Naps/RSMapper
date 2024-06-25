public class Class238 {
   static int anInt2910;
   static int anInt2911;
   static GLSprite[] aGLSpriteArray2912;
   static IncommingPacket aClass192_2913 = new IncommingPacket(20, -1);
   static int anInt2914;
   static int anInt2915;
   static int anInt2916;

   public static void method3018(byte b) {
      aGLSpriteArray2912 = null;
      if (b >= 40) {
         aClass192_2913 = null;
      }
   }

   static final void method3019(int i, int i_0_, int[] is, Object[] objects, boolean bool) {
      ++anInt2914;
      if (~i_0_ > ~i) {
         int i_1_ = (i_0_ + i) / 2;
         int i_2_ = i_0_;
         int i_3_ = is[i_1_];
         is[i_1_] = is[i];
         is[i] = i_3_;
         Object object = objects[i_1_];
         objects[i_1_] = objects[i];
         objects[i] = object;
         int i_4_ = ~i_3_ != Integer.MIN_VALUE ? 1 : 0;

         for(int i_5_ = i_0_; ~i < ~i_5_; ++i_5_) {
            if (i_3_ + (i_5_ & i_4_) > is[i_5_]) {
               int i_6_ = is[i_5_];
               is[i_5_] = is[i_2_];
               is[i_2_] = i_6_;
               Object object_7_ = objects[i_5_];
               objects[i_5_] = objects[i_2_];
               objects[i_2_++] = object_7_;
            }
         }

         is[i] = is[i_2_];
         is[i_2_] = i_3_;
         objects[i] = objects[i_2_];
         objects[i_2_] = object;
         method3019(-1 + i_2_, i_0_, is, objects, false);
         method3019(i, i_2_ - -1, is, objects, false);
      }

      if (bool) {
         method3018((byte)60);
      }
   }

   static final void method3020(int i, Actor actor) {
      ++anInt2910;
      int i_8_ = -Class174.clientCycle + actor.toFirstTileTicketDelay;
      int i_9_ = actor.toFirstTileX * 512 + 256 * actor.getSize((byte)99);
      int i_10_ = actor.toFirstTileY * 512 - -(actor.getSize((byte)58) * 256);
      actor.y += (-actor.y + i_10_) / i_8_;
      actor.x += (-actor.x + i_9_) / i_8_;
      actor.anInt10901 = i;
      if (~actor.forceMovementDirection == -1) {
         actor.method856((byte)-115, 8192);
      }

      if (actor.forceMovementDirection == 1) {
         actor.method856((byte)-112, 12288);
      }

      if (~actor.forceMovementDirection == -3) {
         actor.method856((byte)23, 0);
      }

      if (actor.forceMovementDirection == 3) {
         actor.method856((byte)-74, 4096);
      }
   }

   static final boolean tileHasBridgeFlag(int localX, int localY, int junk) {
      ++anInt2916;
      if (localY >= 0 && localX >= 0 && localY < Class277.tileFlags[1].length && localX < Class277.tileFlags[1][localY].length) {
         int i_13_ = 90 % ((junk - 38) / 41);
         return (Class277.tileFlags[1][localY][localX] & 2) != 0;
      } else {
         return false;
      }
   }
}
