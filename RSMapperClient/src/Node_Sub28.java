public class Node_Sub28 extends Node {
   protected int anInt7319;
   protected int anInt7320;
   static int anInt7321;
   static int anInt7322;
   protected int anInt7323;
   protected int anInt7324;
   protected int anInt7325;
   protected int anInt7326;
   static int anInt7327 = 0;
   protected int anInt7328;
   static int[] anIntArray7329;
   protected int anInt7330;
   static char[] aCharArray7331 = new char[]{'[', ']', '#'};
   protected int anInt7332;
   static int anInt7333;

   static final void method2701(int i, int i_0_, Index class302, int i_1_, boolean bool, int i_2_, long l, byte b) {
      Class17.anInt282 = i_1_;
      ++anInt7322;
      Class52.anInt800 = 1;
      Class339_Sub8.anInt8733 = i_0_;
      CacheNode_Sub6.anInt9485 = i_2_;
      Class266.aBoolean3385 = bool;
      Class107.anInt1362 = 10000;
      Class61.aNode_Sub9_Sub1_885 = null;
      Class101.anInt1306 = i;
      Class77.aLong1018 = l;
      Class93_Sub2.aClass302_6049 = class302;
   }

   public static void method2702(int i) {
      aCharArray7331 = null;
      anIntArray7329 = null;
   }

   Node_Sub28(Buffer buffer) {
      int i = buffer.readInt();
      this.anInt7326 = 16383 & i;
      this.anInt7330 = i >>> 28;
      this.anInt7325 = (i & 268431605) >>> 14;
      this.anInt7320 = buffer.readUnsignedByte();
      this.anInt7328 = buffer.readUnsignedByte();
      this.anInt7324 = buffer.readUnsignedByte();
      this.anInt7319 = buffer.readUnsignedByte();
      this.anInt7332 = buffer.readUnsignedByte();
      this.anInt7323 = buffer.readUnsignedByte();
   }

   static final void method2703(boolean bool, long l) {
      ++anInt7333;
      int i = Class234.anInt2792;
      if (~Mobile_Sub4.playerPositionX != ~i) {
         int i_5_ = i + -Mobile_Sub4.playerPositionX;
         int i_6_ = (int)(l * (long)i_5_ / 320L);
         if (i_5_ > 0) {
            if (i_6_ == 0) {
               i_6_ = 1;
            } else if (~i_5_ > ~i_6_) {
               i_6_ = i_5_;
            }
         } else if (i_6_ == 0) {
            i_6_ = -1;
         } else if (~i_5_ < ~i_6_) {
            i_6_ = i_5_;
         }

         Mobile_Sub4.playerPositionX += i_6_;
      }

      int i_7_ = Node_Sub19.anInt7173;
      if (~i_7_ != ~Class25.playerPositionY) {
         int i_8_ = i_7_ + -Class25.playerPositionY;
         int i_9_ = (int)((long)i_8_ * l / 320L);
         if (i_8_ <= 0) {
            if (~i_9_ != -1) {
               if (i_8_ > i_9_) {
                  i_9_ = i_8_;
               }
            } else {
               i_9_ = -1;
            }
         } else if (i_9_ == 0) {
            i_9_ = 1;
         } else if (i_8_ < i_9_) {
            i_9_ = i_8_;
         }

         Class25.playerPositionY += i_9_;
      }

      Node_Sub12.cameraRotationHorizontal += Class291.cameraRotationHorizontalIncrement * (float)l / 40.0F * 8.0F;
      Class257.cameraRotationVertical += Node_Sub36_Sub1.cameraRotationVerticalIncrement * (float)l / 40.0F * 8.0F;
      Class169_Sub4.method1787((byte)-78);
      if (bool) {
         anInt7327 = -77;
      }
   }
}
