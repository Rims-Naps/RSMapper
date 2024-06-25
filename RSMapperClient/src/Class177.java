public class Class177 {
   private int[] anIntArray2107;
   private int anInt2108 = 2;
   protected int anInt2109;
   private int[] anIntArray2110;
   protected int anInt2111;
   protected int anInt2112;
   private int anInt2113;
   private int anInt2114;
   private int anInt2115;
   private int anInt2116;
   private int anInt2117;

   final void method1807(Buffer buffer) {
      this.anInt2108 = buffer.readUnsignedByte();
      this.anIntArray2107 = new int[this.anInt2108];
      this.anIntArray2110 = new int[this.anInt2108];

      for(int i = 0; i < this.anInt2108; ++i) {
         this.anIntArray2107[i] = buffer.readUnsignedShort();
         this.anIntArray2110[i] = buffer.readUnsignedShort();
      }
   }

   final void method1808() {
      this.anInt2115 = 0;
      this.anInt2113 = 0;
      this.anInt2117 = 0;
      this.anInt2114 = 0;
      this.anInt2116 = 0;
   }

   final int method1809(int i) {
      if (this.anInt2116 >= this.anInt2115) {
         this.anInt2114 = this.anIntArray2110[this.anInt2113++] << 15;
         if (this.anInt2113 >= this.anInt2108) {
            this.anInt2113 = this.anInt2108 - 1;
         }

         this.anInt2115 = (int)((double)this.anIntArray2107[this.anInt2113] / 65536.0 * (double)i);
         if (this.anInt2115 > this.anInt2116) {
            this.anInt2117 = ((this.anIntArray2110[this.anInt2113] << 15) - this.anInt2114) / (this.anInt2115 - this.anInt2116);
         }
      }

      this.anInt2114 += this.anInt2117;
      ++this.anInt2116;
      return this.anInt2114 - this.anInt2117 >> 15;
   }

   final void method1810(Buffer buffer) {
      this.anInt2112 = buffer.readUnsignedByte();
      this.anInt2109 = buffer.readInt();
      this.anInt2111 = buffer.readInt();
      this.method1807(buffer);
   }

   public Class177() {
      this.anIntArray2107 = new int[2];
      this.anIntArray2110 = new int[2];
      this.anIntArray2107[0] = 0;
      this.anIntArray2107[1] = 65535;
      this.anIntArray2110[0] = 0;
      this.anIntArray2110[1] = 65535;
   }
}
