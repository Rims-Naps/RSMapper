public class Class206 {
   protected int anInt2462;
   static int[] anIntArray2463 = new int[]{0, 2, 2, 2, 1, 1, 3, 3, 1, 3, 3, 4, 4};
   static long[] aLongArray2464;
   static int anInt2465;
   static int anInt2466;
   static int anInt2467;
   private Player aPlayer2468;
   private Npc aNpc2469;
   static int anInt2470;
   private int anInt2471;
   protected boolean aBoolean2472 = false;

   final void method2034(int i, byte b, int i_0_, int i_1_) {
      if (this.aNpc2469 == null) {
         this.aPlayer2468.plane = this.aPlayer2468.aByte5931 = (byte)i_0_;
         this.aPlayer2468.method888(i, -117, i_1_);
      } else {
         this.aNpc2469.method877(-15694, true, i_1_, i, i_0_, this.aNpc2469.getSize((byte)44));
      }

      ++anInt2470;
   }

   final void method2035(byte b) {
      this.aNpc2469 = null;
      if (b >= -12) {
         this.method2037(-6);
      }

      this.aBoolean2472 = false;
      ++anInt2465;
      this.aPlayer2468 = null;
   }

   public static void method2036(int i) {
      anIntArray2463 = null;
      aLongArray2464 = null;
   }

   final Actor method2037(int i) {
      ++anInt2466;
      if (i >= -55) {
         this.method2034(-42, (byte)-70, -78, 52);
      }

      return (Actor)(this.aNpc2469 != null ? this.aNpc2469 : this.aPlayer2468);
   }

   final void method2038(byte b, int i, int i_4_, int i_5_, int i_6_) {
      if (!this.aBoolean2472) {
         this.aBoolean2472 = true;
         if (this.anInt2462 >= 0) {
            this.aNpc2469 = new Npc(25);
            this.aNpc2469.anInt10880 = Class174.clientCycle;
            this.aNpc2469.index = this.anInt2471;
            this.aNpc2469.method879(Class366.aClass279_4526.getNPCDefinitions(this.anInt2462, (byte)107), true);
            this.aNpc2469.method861(b ^ -933, this.aNpc2469.definitions.size);
            this.aNpc2469.anInt10890 = this.aNpc2469.definitions.anInt2876 << 3;
            this.aNpc2469.anInt10857 = Class246.anInt3108++;
         } else {
            this.aPlayer2468 = new Player(25);
            this.aPlayer2468.decodeAppearence(Mobile.aBuffer9128, 0);
            this.aPlayer2468.anInt10880 = Class174.clientCycle;
            this.aPlayer2468.anInt10857 = Class246.anInt3108++;
            this.aPlayer2468.index = this.anInt2471;
         }
      }

      if (b == 67) {
         ++anInt2467;
         if (~this.anInt2462 > -1) {
            this.aPlayer2468.plane = this.aPlayer2468.aByte5931 = (byte)i_4_;
            this.aPlayer2468.method888(i_5_, -101, i_6_);
            this.aPlayer2468.method849(i, -78, true);
         } else {
            this.aNpc2469.method877(-15694, true, i_6_, i_5_, i_4_, this.aNpc2469.getSize((byte)71));
            this.aNpc2469.method849(i, b + -177, true);
         }
      }
   }

   Class206(Buffer buffer, int i) {
      this.aNpc2469 = null;
      this.aPlayer2468 = null;
      this.anInt2471 = i;
      int i_7_ = buffer.readUnsignedByte();
      if (~i_7_ != -1) {
         if (~i_7_ != -2) {
            this.anInt2462 = -1;
         } else {
            this.anInt2462 = -1;
         }
      } else {
         this.anInt2462 = buffer.method2183();
      }

      buffer.readString();
   }
}
