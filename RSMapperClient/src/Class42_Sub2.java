import java.awt.Component;

public class Class42_Sub2 extends Class42 {
   private int anInt5557;
   private static Interface5 anInterface5_5558;

   @Override
   final void method447(int i) throws Exception {
      if (i > 32768) {
         throw new IllegalArgumentException();
      } else {
         anInterface5_5558.method13(i, this.anInt5557, 65535);
      }
   }

   @Override
   final int method446() {
      return anInterface5_5558.method12(this.anInt5557, 94);
   }

   @Override
   final void method442() {
      anInterface5_5558.method15(this.anInt5557, (byte)126);
   }

   @Override
   final void method452(Component component) throws Exception {
      anInterface5_5558.method14(Class365.anInt4523, DrawableModel.aBoolean913, component, (byte)-100);
   }

   @Override
   final void method449() {
      anInterface5_5558.method16(this.anInt5557, this.anIntArray642);
   }

   @Override
   final void method455() {
      anInterface5_5558.method17(this.anInt5557, true);
   }

   public static void method457() {
      anInterface5_5558 = null;
   }

   Class42_Sub2(SignLink signlink, int i) {
      anInterface5_5558 = (Interface5)signlink.method3626((byte)94);
      this.anInt5557 = i;
   }
}
