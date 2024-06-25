import java.awt.Frame;

abstract class Node_Sub29 extends Node {
   static int anInt7334;
   static int anInt7335;
   private int type;
   static int anInt7337;
   static boolean showNpcs = false;
   protected float aFloat7339;
   protected int referenceY;
   private int color;
   protected int referenceX;
   static int anInt7343;
   static Frame aFrame7344;
   static int[] anIntArray7345 = new int[]{1, 2, 4, 8};
   protected int height;
   static IncommingPacket aClass192_7347 = new IncommingPacket(30, -2);
   static int anInt7348;
   static int anInt7349;
   static int anInt7350;

   final int getHeight(int i) {
      if (i != 30) {
         this.referenceX = -123;
      }

      ++anInt7348;
      return this.height;
   }

   final int getReferenceX(int i) {
      ++anInt7350;
      if (i != 32311) {
         this.referenceX = -86;
      }

      return this.referenceX;
   }

   abstract void setReferencePositionsAndHeight(int var1, int var2, int var3, int var4);

   final float method2707(int i) {
      ++anInt7335;
      if (i != 1) {
         this.getReferenceY(-90);
      }

      return this.aFloat7339;
   }

   final int getReferenceY(int i) {
      ++anInt7349;
      return i != 27433 ? 121 : this.referenceY;
   }

   static final Class150_Sub3_Sub1 method2709(Buffer buffer, byte b) {
      ++anInt7334;
      Class150_Sub3 class150_sub3 = Class380.method4169((byte)110, buffer);
      if (b != -23) {
         aClass192_7347 = null;
      }

      int i = buffer.readShort();
      return new Class150_Sub3_Sub1(
         class150_sub3.aClass379_5079,
         class150_sub3.aClass77_5087,
         class150_sub3.anInt5092,
         class150_sub3.anInt5080,
         class150_sub3.anInt5086,
         class150_sub3.anInt5081,
         class150_sub3.anInt5084,
         class150_sub3.anInt5083,
         class150_sub3.anInt5090,
         class150_sub3.anInt8971,
         class150_sub3.anInt8974,
         class150_sub3.anInt8972,
         class150_sub3.anInt8968,
         class150_sub3.anInt8965,
         class150_sub3.anInt8964,
         i
      );
   }

   Node_Sub29(int xref, int height, int yref, int type, int color, float f) {
      this.type = type;
      this.color = color;
      this.aFloat7339 = f;
      this.referenceX = xref;
      this.referenceY = yref;
      this.height = height;
   }

   final int getColor(byte b) {
      ++anInt7343;
      int i = -17 % ((b - 28) / 36);
      return this.color;
   }

   final int getFlickerType(int i) {
      ++anInt7337;
      if (i <= 115) {
         this.getReferenceX(6);
      }

      return this.type;
   }

   abstract void method2712(byte var1, float var2);

   public static void method2713(int i) {
      anIntArray7345 = null;
      if (i != 1) {
         aClass192_7347 = null;
      }

      aClass192_7347 = null;
      aFrame7344 = null;
   }
}
