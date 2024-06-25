import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;

public class Node_Sub36_Sub1 extends Node_Sub36 {
   static int anInt10028;
   private byte aByte10029;
   static boolean aBoolean10030 = false;
   static OutgoingPacket aClass318_10031 = new OutgoingPacket(54, 6);
   private long aLong10032;
   private String aString10033 = null;
   static int anInt10034;
   static Class109 aClass109_10035;
   static int anInt10036;
   private int anInt10037;
   static float cameraRotationVerticalIncrement = 0.0F;
   static float cameraRotationVerticalMultiplier = 1.0F;
   static int anInt10039 = 100;
   static int cameraAntiBotRotation = 0;

   static final void method2758(int i) {
      ++anInt10028;
      if (DrawableModel.aFrame907 == null) {
         int i_1_ = Class270_Sub1.canvasOffsetX;
         int i_2_ = Class131.canvasOffsetY;
         int i_3_ = -i_1_ + Class36.anInt542 + -Class360.canvasWidth;
         int i_4_ = -i_2_ + CacheNode_Sub3.anInt9441 - Class205.canvasHeight;
         if (i_1_ > 0 || ~i_3_ < -1 || i_2_ > 0 || i_4_ > 0) {
            try {
               Container container;
               if (Node_Sub29.aFrame7344 == null) {
                  if (Class96.anApplet1270 != null) {
                     container = Class96.anApplet1270;
                  } else {
                     container = Class82.aGameStub1123;
                  }
               } else {
                  container = Node_Sub29.aFrame7344;
               }

               int i_5_ = 0;
               int i_6_ = 0;
               if (container == Node_Sub29.aFrame7344) {
                  Insets insets = Node_Sub29.aFrame7344.getInsets();
                  i_5_ = insets.left;
                  i_6_ = insets.top;
               }

               Graphics graphics = container.getGraphics();
               graphics.setColor(Color.black);
               if (~i_1_ < -1) {
                  graphics.fillRect(i_5_, i_6_, i_1_, CacheNode_Sub3.anInt9441);
               }

               if (i_2_ > 0) {
                  graphics.fillRect(i_5_, i_6_, Class36.anInt542, i_2_);
               }

               if (i_3_ > 0) {
                  graphics.fillRect(-i_3_ + Class36.anInt542 + i_5_, i_6_, i_3_, CacheNode_Sub3.anInt9441);
               }

               if (~i_4_ < -1) {
                  graphics.fillRect(i_5_, -i_4_ + i_6_ - -CacheNode_Sub3.anInt9441, Class36.anInt542, i_4_);
               }
            } catch (Exception var9) {
            }
         }
      }
   }

   @Override
   final void method2751(Node_Sub43 node_sub43, int i) {
      ++anInt10036;
      Class24 class24 = new Class24();
      class24.anInt441 = this.anInt10037;
      class24.aByte438 = this.aByte10029;
      class24.aString437 = this.aString10033;
      if (i != 0) {
         anInt10039 = -114;
      }

      node_sub43.method2938((byte)-118, class24);
   }

   public static void method2759(byte b) {
      aClass109_10035 = null;
      aClass318_10031 = null;
   }

   @Override
   final void method2756(Buffer buffer, int i) {
      ++anInt10034;
      if (buffer.readUnsignedByte() != 255) {
         --buffer.offset;
         this.aLong10032 = buffer.readLong();
      }

      this.aString10033 = buffer.readString2();
      this.anInt10037 = buffer.readUnsignedShort();
      this.aByte10029 = buffer.readByte();
      buffer.readLong();
      if (i == -1) {
         ;
      }
   }

   Node_Sub36_Sub1() {
      this.aLong10032 = -1L;
   }
}
