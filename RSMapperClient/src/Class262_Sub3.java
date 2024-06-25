public class Class262_Sub3 extends Class262 {
   private int anInt7711;
   private int anInt7712;
   static int[] anIntArray7713 = new int[5];
   private int anInt7714;
   static Index index29;
   static int anInt7716;
   private int anInt7717;
   private int anInt7718;
   static int anInt7719;
   static int anInt7720;

   static final int method3156(int i) {
      if (i < 56) {
         return 118;
      } else {
         ++anInt7719;
         return Class251.anInt3185;
      }
   }

   Class262_Sub3(Buffer buffer) {
      super(buffer);
      this.anInt7718 = buffer.readUnsignedShort();
      int i = buffer.readInt();
      this.anInt7711 = i >>> 16;
      this.anInt7714 = 65535 & i;
      this.anInt7712 = buffer.readUnsignedByte();
      this.anInt7717 = buffer.method2197(-129);
   }

   static final boolean method3157(int i, byte b) {
      if (b != 28) {
         return false;
      } else {
         ++anInt7720;
         return i == 1 || ~i == -4 || i == 5;
      }
   }

   public static void method3158(int i) {
      index29 = null;
      if (i == 1) {
         anIntArray7713 = null;
      }
   }

   @Override
   final void method3148(int i) {
      Class121.aClass206Array1529[this.anInt7718].method2038((byte)67, this.anInt7717, this.anInt7712, this.anInt7711, this.anInt7714);
      if (i > -102) {
         method3156(-127);
      }

      ++anInt7716;
   }
}
