public class Class229 {
   static int anInt2722;
   protected int anInt2723;
   static int anInt2724;
   static boolean aBoolean2725;
   private Class61 aClass61_2726 = new Class61(64);
   static int anInt2727;
   private Index aClass302_2728;
   static int anInt2729;
   static Class329 aClass329_2730 = new Class329("WTWIP", "office", "_wip", 3);
   static OutgoingPacket aClass318_2731 = new OutgoingPacket(41, -1);
   static GraphicsToolkit aGraphicsToolkit2732;
   static Class270 aClass270_2733;

   final void method2122(boolean bool) {
      synchronized(this.aClass61_2726) {
         if (!bool) {
            this.method2122(true);
         }

         this.aClass61_2726.method602((byte)-128);
      }

      ++anInt2724;
   }

   final Class293 method2123(int i, int i_0_) {
      ++anInt2727;
      Class293 class293;
      synchronized(this.aClass61_2726) {
         class293 = (Class293)this.aClass61_2726.method607((long)i_0_, 0);
      }

      if (class293 != null) {
         return class293;
      } else {
         byte[] bs;
         synchronized(this.aClass302_2728) {
            bs = this.aClass302_2728.getFile(false, i_0_, i);
         }

         class293 = new Class293();
         if (bs != null) {
            class293.method3463(new Buffer(bs), (byte)-114);
         }

         synchronized(this.aClass61_2726) {
            this.aClass61_2726.method601(class293, 25566, (long)i_0_);
            return class293;
         }
      }
   }

   public static void method2124(byte b) {
      aGraphicsToolkit2732 = null;
      aClass318_2731 = null;
      if (b != 39) {
         aClass270_2733 = null;
      }

      aClass270_2733 = null;
      aClass329_2730 = null;
   }

   final void method2125(byte b) {
      if (b != 95) {
         method2124((byte)-56);
      }

      ++anInt2729;
      synchronized(this.aClass61_2726) {
         this.aClass61_2726.method608(false);
      }
   }

   final void method2126(int i, byte b) {
      ++anInt2722;
      if (b >= 71) {
         synchronized(this.aClass61_2726) {
            this.aClass61_2726.method598(i, -11819);
         }
      }
   }

   Class229(Class353 class353, int i, Index class302) {
      this.aClass302_2728 = class302;
      if (this.aClass302_2728 == null) {
         this.anInt2723 = 0;
      } else {
         this.anInt2723 = this.aClass302_2728.method3537(-2, 16);
      }
   }
}
