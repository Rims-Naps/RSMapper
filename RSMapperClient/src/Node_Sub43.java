import java.util.Date;

public class Node_Sub43 extends Node {
   static int anInt7528;
   static int anInt7529;
   static int anInt7530;
   protected int anInt7531;
   protected byte aByte7532;
   protected Class24[] aClass24Array7533;
   static int anInt7534;
   private int[] anIntArray7535;
   static int anInt7536;
   protected long aLong7537;
   static int[][] anIntArrayArray7538 = new int[][]{
      {6, 6},
      {6, 6},
      {6, 5, 5},
      {5, 6, 5},
      {5, 5, 6},
      {6, 5, 5},
      {5, 0, 4, 1},
      {7, 7, 1, 2},
      {7, 1, 2, 7},
      {8, 9, 4, 0, 8, 9},
      {0, 8, 9, 8, 9, 4},
      {11, 0, 10, 11, 4, 2},
      {6, 6},
      {7, 7, 1, 2},
      {7, 7, 1, 2}
   };
   static boolean aBoolean7231;
   static int anInt7539 = 0;
   protected byte aByte7540;
   static Class312 aClass312_7541;
   private boolean aBoolean7542;
   static int anInt7543;
   protected String aString7544;
   static int anInt7545;
   private boolean aBoolean7546 = true;

   final int[] method2937(int i) {
      if (i != 8669) {
         return null;
      } else {
         if (this.anIntArray7535 == null) {
            this.anIntArray7535 = new int[this.anInt7531];
            String[] strings = new String[this.anInt7531];

            for(int i_0_ = 0; ~this.anInt7531 < ~i_0_; this.anIntArray7535[i_0_] = i_0_++) {
               strings[i_0_] = this.aClass24Array7533[i_0_].aString437;
            }

            Class339_Sub4.method3932((byte)74, this.anIntArray7535, strings);
         }

         ++anInt7530;
         return this.anIntArray7535;
      }
   }

   final void method2938(byte b, Class24 class24) {
      ++anInt7543;
      if (b >= -69) {
         this.aByte7540 = 51;
      }

      if (this.aClass24Array7533 == null || ~this.aClass24Array7533.length >= ~this.anInt7531) {
         this.method2940((byte)-79, 5 + this.anInt7531);
      }

      this.aClass24Array7533[this.anInt7531++] = class24;
      this.anIntArray7535 = null;
   }

   private final void method2939(int i, Buffer buffer) {
      ++anInt7545;
      int i_1_ = buffer.readUnsignedByte();
      if ((i_1_ & 2) != 0) {
         this.aBoolean7546 = true;
      }

      if (~(1 & i_1_) != -1) {
         this.aBoolean7542 = true;
      }

      this.scriptId = buffer.readLong();
      this.aLong7537 = buffer.readLong();
      this.aString7544 = buffer.readString();
      buffer.readUnsignedByte();
      this.aByte7532 = buffer.readByte();
      this.aByte7540 = buffer.readByte();
      this.anInt7531 = buffer.readUnsignedShort();
      if (this.anInt7531 > 0) {
         this.aClass24Array7533 = new Class24[this.anInt7531];

         for(int i_3_ = 0; this.anInt7531 > i_3_; ++i_3_) {
            Class24 class24 = new Class24();
            if (this.aBoolean7542) {
               buffer.readLong();
            }

            if (this.aBoolean7546) {
               class24.aString437 = buffer.readString();
            }

            class24.aByte438 = buffer.readByte();
            class24.anInt441 = buffer.readUnsignedShort();
            this.aClass24Array7533[i_3_] = class24;
         }
      }
   }

   private final void method2940(byte b, int i) {
      if (b == -79) {
         ++anInt7528;
         if (this.aClass24Array7533 == null) {
            this.aClass24Array7533 = new Class24[i];
         } else {
            Class311.method3605(this.aClass24Array7533, 0, this.aClass24Array7533 = new Class24[i], 0, this.anInt7531);
         }
      }
   }

   static final void method2941(int i, long l) {
      ++anInt7536;
      if (i == 6) {
         Class141.aCalendar1756.setTime(new Date(l));
      }
   }

   final void method2942(int i, int i_4_) {
      ++anInt7534;
      --this.anInt7531;
      if (this.anInt7531 == 0) {
         this.aClass24Array7533 = null;
      } else {
         Class311.method3605(this.aClass24Array7533, 1 + i, this.aClass24Array7533, i, -i + this.anInt7531);
      }

      this.anIntArray7535 = null;
      if (i_4_ >= -1) {
         this.method2943(null, (byte)-105);
      }
   }

   final int method2943(String string, byte b) {
      ++anInt7529;

      for(int i_5_ = 0; ~this.anInt7531 < ~i_5_; ++i_5_) {
         if (this.aClass24Array7533[i_5_].aString437.equalsIgnoreCase(string)) {
            return i_5_;
         }
      }

      return -1;
   }

   public static void method2944(int i) {
      if (i == 6) {
         aClass312_7541 = null;
         anIntArrayArray7538 = null;
      }
   }

   Node_Sub43(Buffer buffer) {
      this.anInt7531 = 0;
      this.aString7544 = null;
      this.method2939(-62, buffer);
   }
}
