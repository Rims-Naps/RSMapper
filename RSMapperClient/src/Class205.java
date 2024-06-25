public class Class205 implements Interface7 {
   static int anInt5101;
   protected boolean aBoolean5102;
   protected int anInt5103;
   static Index index19;
   protected int anInt5105;
   protected Class77 aClass77_5106;
   protected int anInt5107;
   static int anInt5108;
   protected Class379 aClass379_5109;
   protected int anInt5110;
   protected int anInt5111;
   protected int anInt5112;
   protected int anInt5113;
   protected int anInt5114;
   static int canvasHeight;

   public static void method2032(byte b) {
      index19 = null;
      if (b <= 31) {
         method2032((byte)-86);
         Node_Sub43.aBoolean7231 = !Node_Sub43.aBoolean7231;
      }
   }

   @Override
   public final Class170 method20(int i) {
      if (i < 81) {
         this.method20(69);
      }

      ++anInt5108;
      return Class96.aClass170_1273;
   }

   static final String method2033(IComponentDefinitions widget, byte b) {
      if (b != -104) {
         return null;
      } else {
         ++anInt5101;
         if (~Client.method113(widget).method2743(-70) == -1) {
            return null;
         } else if (widget.aString4786 != null && ~widget.aString4786.trim().length() != -1) {
            return widget.aString4786;
         } else {
            return Class54.aBoolean817 ? "Hidden-use" : null;
         }
      }
   }

   Class205(int i, Class379 class379, Class77 class77, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, int i_5_, int i_6_, boolean bool) {
      this.anInt5103 = i_3_;
      this.anInt5105 = i_4_;
      this.aClass77_5106 = class77;
      this.anInt5113 = i_0_;
      this.anInt5107 = i_6_;
      this.anInt5112 = i_2_;
      this.anInt5110 = i_1_;
      this.aClass379_5109 = class379;
      this.anInt5114 = i;
      this.aBoolean5102 = bool;
      this.anInt5111 = i_5_;
   }
}
