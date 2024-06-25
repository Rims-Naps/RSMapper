public class ConfigDefinitions {
   static int anInt945;
   protected int anInt946;
   static int anInt947;
   protected int anInt948;
   static int anInt949;
   protected int anInt950;

   final void method737(int i, Buffer buffer) {
      while(true) {
         int i_1_ = buffer.readUnsignedByte();
         if (~i_1_ == -1) {
            ++anInt945;
            return;
         }

         this.method739(-31, buffer, i_1_);
      }
   }

   static final void method738(int i, int i_2_, int i_3_, int i_4_, int i_5_, int i_6_, int i_7_, int i_8_) {
      if (i_7_ == 1) {
         ++anInt947;
         if (~i_8_ == ~i_3_) {
            OutputStream_Sub2.method138(i_2_, i_8_, i_5_, (byte)91, i, i_4_, i_6_);
         } else if (Class262_Sub4.anInt7722 <= i_4_ + -i_8_
            && ~(i_8_ + i_4_) >= ~za_Sub2.anInt10513
            && ~Class384.anInt4906 >= ~(i - i_3_)
            && ~Node_Sub25_Sub1.anInt9936 <= ~(i_3_ + i)) {
            Class188_Sub2.method1903(i_6_, i_8_, i_5_, i_3_, i_2_, 3, i, i_4_);
         } else {
            Class263.method3223(i_4_, i_8_, -21595, i_3_, i_5_, i, i_6_, i_2_);
         }
      }
   }

   private final void method739(int i, Buffer buffer, int i_9_) {
      ++anInt949;
      if (i_9_ == 1) {
         this.anInt950 = buffer.readUnsignedShort();
         this.anInt946 = buffer.readUnsignedByte();
         this.anInt948 = buffer.readUnsignedByte();
      }
   }
}
