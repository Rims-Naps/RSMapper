public class Class262_Sub15_Sub2 extends Class262_Sub15 {
   static int anInt10525;
   private int anInt10526;
   private int anInt10527;
   private int anInt10528;

   @Override
   final void method3148(int i) {
      if (i > -102) {
         this.anInt10528 = 69;
      }

      Class121.aClass206Array1529[this.anInt10528]
         .method2037(-105)
         .sendGraphics(this.anInt10526, this.anInt7815, false, this.anInt7820 << 16, this.anInt10527, this.anInt7818);
      ++anInt10525;
   }

   Class262_Sub15_Sub2(Buffer buffer) {
      super(buffer);
      this.anInt10528 = buffer.readUnsignedShort();
      this.anInt10526 = buffer.readUnsignedByte();
      this.anInt10527 = buffer.readUnsignedShort();
   }
}
