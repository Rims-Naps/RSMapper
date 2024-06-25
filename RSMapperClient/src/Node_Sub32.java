public class Node_Sub32 extends Node {
   static IncommingPacket aClass192_7376 = new IncommingPacket(58, 6);
   static boolean aBoolean7377 = false;
   static String aString7378;
   static boolean aBoolean7379 = false;
   static int cachedNPCcsCount = 0;
   protected int anInt7381;
   static long aLong7382;
   static int anInt7383;
   static int anInt7384;
   static long aLong7385 = 0L;

   static final void method2729(boolean bool) {
      ++anInt7384;

      for(int i = 0; ~NpcDefinition.anInt2885 < ~i; ++i) {
         GLXToolkit.aClass54Array9292[i] = null;
      }

      NpcDefinition.anInt2885 = 0;

      for(int i = 0; i < Class159.anInt1995; ++i) {
         for(int i_0_ = 0; Class328.SCENE_WIDTH_X > i_0_; ++i_0_) {
            for(int i_1_ = 0; i_1_ < Node_Sub50.SCENE_WIDTH_Y; ++i_1_) {
               Class261 class261 = Class175.aClass261ArrayArrayArray2099[i][i_1_][i_0_];
               if (class261 != null) {
                  if (class261.aShort3313 > 0) {
                     class261.aShort3313 = (short)(class261.aShort3313 * -1);
                  }

                  if (~class261.aShort3318 < -1) {
                     class261.aShort3318 = (short)(class261.aShort3318 * -1);
                  }
               }
            }
         }
      }

      for(int plane = 0; Class159.anInt1995 > plane; ++plane) {
         for(int localY = 0; Class328.SCENE_WIDTH_X > localY; ++localY) {
            for(int localX = 0; ~Node_Sub50.SCENE_WIDTH_Y < ~localX; ++localX) {
               Class261 class261 = Class175.aClass261ArrayArrayArray2099[plane][localX][localY];
               if (class261 != null) {
                  boolean bool_4_ = Class175.aClass261ArrayArrayArray2099[0][localX][localY] != null
                     && Class175.aClass261ArrayArrayArray2099[0][localX][localY].aClass261_3310 != null;
                  if (~class261.aShort3318 > -1) {
                     int i_5_ = localY;
                     int i_6_ = localY;
                     int i_8_ = plane;
                     Class261 class261_9_ = Class175.aClass261ArrayArrayArray2099[plane][localX][localY - 1];
                     int i_10_ = Node_Sub38_Sub37.aPlaneArray10466[plane].getVerticeHeight(localY, localX, (byte)-118);

                     while(
                        ~i_5_ < -1
                           && class261_9_ != null
                           && class261_9_.aShort3318 < 0
                           && class261.aShort3318 == class261_9_.aShort3318
                           && ~class261.aShort3322 == ~class261_9_.aShort3322
                           && ~Node_Sub38_Sub37.aPlaneArray10466[plane].getVerticeHeight(i_5_ - 1, localX, (byte)-118) == ~i_10_
                           && (i_5_ - 1 <= 0 || i_10_ == Node_Sub38_Sub37.aPlaneArray10466[plane].getVerticeHeight(i_5_ + -2, localX, (byte)-118))
                     ) {
                        class261_9_ = Class175.aClass261ArrayArrayArray2099[plane][localX][-1 + --i_5_];
                     }

                     class261_9_ = Class175.aClass261ArrayArrayArray2099[plane][localX][localY - -1];

                     while(
                        Node_Sub50.SCENE_WIDTH_Y > i_6_
                           && class261_9_ != null
                           && class261_9_.aShort3318 < 0
                           && class261.aShort3318 == class261_9_.aShort3318
                           && class261.aShort3322 == class261_9_.aShort3322
                           && i_10_ == Node_Sub38_Sub37.aPlaneArray10466[plane].getVerticeHeight(i_6_ + 1, localX, (byte)-118)
                           && (
                              Node_Sub50.SCENE_WIDTH_Y <= i_6_ + 1
                                 || ~i_10_ == ~Node_Sub38_Sub37.aPlaneArray10466[plane].getVerticeHeight(2 + i_6_, localX, (byte)-118)
                           )
                     ) {
                        class261_9_ = Class175.aClass261ArrayArrayArray2099[plane][localX][1 + ++i_6_];
                     }

                     int i_11_ = plane - plane - -1;
                     int i_12_ = Node_Sub38_Sub37.aPlaneArray10466[bool_4_ ? 1 + plane : plane].getVerticeHeight(i_5_, localX, (byte)-118);
                     int i_13_ = i_12_ + class261.aShort3318 * i_11_;
                     int i_14_ = Node_Sub38_Sub37.aPlaneArray10466[!bool_4_ ? plane : plane - -1].getVerticeHeight(1 + i_6_, localX, (byte)-118);
                     int i_15_ = i_14_ - -(class261.aShort3318 * i_11_);
                     int i_16_ = localX << Class36.INT_9;
                     int i_17_ = i_5_ << Class36.INT_9;
                     int i_18_ = (i_6_ << Class36.INT_9) + Class179.INT_18;
                     GLXToolkit.aClass54Array9292[NpcDefinition.anInt2885++] = new Class54(
                        1,
                        plane,
                        class261.aShort3322 + i_16_,
                        i_16_ - -class261.aShort3322,
                        class261.aShort3322 + i_16_,
                        class261.aShort3322 + i_16_,
                        i_12_,
                        i_14_,
                        i_15_,
                        i_13_,
                        i_17_,
                        i_18_,
                        i_18_,
                        i_17_
                     );

                     for(int i_19_ = plane; ~i_8_ <= ~i_19_; ++i_19_) {
                        for(int i_20_ = i_5_; ~i_6_ <= ~i_20_; ++i_20_) {
                           Class175.aClass261ArrayArrayArray2099[i_19_][localX][i_20_].aShort3318 = (short)(
                              Class175.aClass261ArrayArrayArray2099[i_19_][localX][i_20_].aShort3318 * -1
                           );
                        }
                     }
                  }

                  if (class261.aShort3313 < 0) {
                     int i_21_ = localX;
                     int i_22_ = localX;
                     int i_24_ = plane;
                     Class261 class261_25_ = Class175.aClass261ArrayArrayArray2099[plane][-1 + localX][localY];

                     int i_26_;
                     for(i_26_ = Node_Sub38_Sub37.aPlaneArray10466[plane].getVerticeHeight(localY, localX, (byte)-118);
                        i_21_ > 0
                           && class261_25_ != null
                           && class261_25_.aShort3313 < 0
                           && class261_25_.aShort3313 == class261.aShort3313
                           && class261_25_.aShort3320 == class261.aShort3320
                           && i_26_ == Node_Sub38_Sub37.aPlaneArray10466[plane].getVerticeHeight(localY, -1 + i_21_, (byte)-118)
                           && (-1 + i_21_ <= 0 || ~i_26_ == ~Node_Sub38_Sub37.aPlaneArray10466[plane].getVerticeHeight(localY, i_21_ + -2, (byte)-118));
                        class261_25_ = Class175.aClass261ArrayArrayArray2099[plane][i_21_ - 1][localY]
                     ) {
                        --i_21_;
                     }

                     class261_25_ = Class175.aClass261ArrayArrayArray2099[plane][1 + localX][localY];

                     while(
                        i_22_ < Class328.SCENE_WIDTH_X
                           && class261_25_ != null
                           && class261_25_.aShort3313 < 0
                           && ~class261.aShort3313 == ~class261_25_.aShort3313
                           && class261.aShort3320 == class261_25_.aShort3320
                           && ~Node_Sub38_Sub37.aPlaneArray10466[plane].getVerticeHeight(localY, 1 + i_22_, (byte)-118) == ~i_26_
                           && (
                              1 + i_22_ >= Class328.SCENE_WIDTH_X
                                 || ~i_26_ == ~Node_Sub38_Sub37.aPlaneArray10466[plane].getVerticeHeight(localY, i_22_ + 2, (byte)-118)
                           )
                     ) {
                        class261_25_ = Class175.aClass261ArrayArrayArray2099[plane][1 + ++i_22_][localY];
                     }

                     int i_27_ = 1 + plane + -plane;
                     int startBottomHeight = Node_Sub38_Sub37.aPlaneArray10466[bool_4_ ? 1 + plane : plane].getVerticeHeight(localY, i_21_, (byte)-118);
                     int startTopHeight = i_27_ * class261.aShort3313 + startBottomHeight;
                     int endBottomHeight = Node_Sub38_Sub37.aPlaneArray10466[bool_4_ ? 1 + plane : plane].getVerticeHeight(localY, 1 + i_22_, (byte)-118);
                     int endTopHeight = class261.aShort3313 * i_27_ + endBottomHeight;
                     int startLocalXUnshifted = i_21_ << Class36.INT_9;
                     int endLocalXUnshifted = Class179.INT_18 + (i_22_ << Class36.INT_9);
                     int localYUnshifted = localY << Class36.INT_9;
                     int combined = localYUnshifted + class261.aShort3320;
                     GLXToolkit.aClass54Array9292[NpcDefinition.anInt2885++] = new Class54(
                        2,
                        plane,
                        startLocalXUnshifted,
                        endLocalXUnshifted,
                        endLocalXUnshifted,
                        startLocalXUnshifted,
                        startBottomHeight,
                        endBottomHeight,
                        endTopHeight,
                        startTopHeight,
                        combined,
                        combined,
                        combined,
                        combined
                     );

                     for(int i_35_ = plane; ~i_24_ <= ~i_35_; ++i_35_) {
                        for(int i_36_ = i_21_; i_22_ >= i_36_; ++i_36_) {
                           Class175.aClass261ArrayArrayArray2099[i_35_][i_36_][localY].aShort3313 = (short)(
                              Class175.aClass261ArrayArrayArray2099[i_35_][i_36_][localY].aShort3313 * -1
                           );
                        }
                     }
                  }
               }
            }
         }
      }

      Class239.aBoolean2930 = bool;
   }

   public static void method2719(String string) {
      aString7378 = string;
      Class338.method3913(string, 3);
   }

   public static void method2730(int i) {
      aString7378 = null;
      if (i > -76) {
         drawRightClickOptions(true, 82, -55L, -127, 90, null, 19, false, 52, null, 60L, (byte)71, true);
      }

      aClass192_7376 = null;
   }

   static final void drawRightClickOptions(
      boolean bool,
      int i,
      long l,
      int lastClickX,
      int lastClickY,
      String string,
      int opcode,
      boolean bool_40_,
      int cursorSpriteId,
      String string_42_,
      long l_43_,
      byte b,
      boolean bool_44_
   ) {
      ++anInt7383;
      if (!Class213.rightClickDialogueIsOpen && Class315.anInt4035 < 500) {
         cursorSpriteId = cursorSpriteId != -1 ? cursorSpriteId : Class239.anInt2928;
         CacheNode_Sub13 cachenode_sub13 = new CacheNode_Sub13(
            string, string_42_, cursorSpriteId, opcode, i, l, lastClickX, lastClickY, bool_40_, bool, l_43_, bool_44_
         );
         Client.method114((byte)-109, cachenode_sub13);
         if (b != -18) {
            aString7378 = null;
         }
      }
   }

   public Node_Sub32() {
   }

   Node_Sub32(int i) {
      this.anInt7381 = i;
   }
}
