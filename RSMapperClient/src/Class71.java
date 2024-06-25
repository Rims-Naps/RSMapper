import java.util.Hashtable;

public class Class71 {
   Index aClass302_951;
   static int anInt952;
   static int anInt953;
   static int anInt954;
   static int anInt955;
   protected int anInt956;
   static int anInt957;
   static Hashtable aHashtable958 = new Hashtable();
   static int anInt959;
   private Class61 aClass61_960 = new Class61(64);
   protected int anInt961 = 0;
   static IncommingPacket aClass192_962 = new IncommingPacket(11, 3);
   static IncommingPacket aClass192_963 = new IncommingPacket(24, -1);
   static OutgoingPacket aClass318_964 = new OutgoingPacket(7, -1);
   static Class251 aClass251_965 = new Class251(1);
   static int anInt966 = 1;
   static boolean aBoolean967 = false;

   final void method740(byte b) {
      synchronized(this.aClass61_960) {
         if (b > -49) {
            method745(31);
         }

         this.aClass61_960.method608(false);
      }

      ++anInt953;
   }

   static final boolean method741(int i, int i_0_, int i_1_) {
      ++anInt957;
      if (i_0_ != -23003) {
         return false;
      } else {
         return ~(i_1_ & 50560) != -1;
      }
   }

   final void method742(int i) {
      if (i >= -43) {
         aClass318_964 = null;
      }

      synchronized(this.aClass61_960) {
         this.aClass61_960.method602((byte)-127);
      }

      ++anInt952;
   }

   final OverlayDefinition getOverlayDefinitions(int overlayId, byte junk) {
      if (junk < 26) {
         this.method746(83, 27);
      }

      ++anInt954;
      OverlayDefinition overlay;
      synchronized(this.aClass61_960) {
         overlay = (OverlayDefinition)this.aClass61_960.method607((long)overlayId, 0);
      }

      if (overlay != null) {
         return overlay;
      } else {
         byte[] bs;
         synchronized(this.aClass302_951) {
            bs = this.aClass302_951.getFile(false, overlayId, 4);
         }

         overlay = new OverlayDefinition();
         overlay.aClass71_3635 = this;
         overlay.overlayId = overlayId;
         if (bs != null) {
            overlay.decodeOverlay(new Buffer(bs));
         }

         overlay.method3406(-13163);
         synchronized(this.aClass61_960) {
            this.aClass61_960.method601(overlay, 25566, (long)overlayId);
            return overlay;
         }
      }
   }

   public static void method744(int i) {
      aHashtable958 = null;
      aClass318_964 = null;
      aClass251_965 = null;
      aClass192_963 = null;
      aClass192_962 = null;
      if (i != -14980) {
         method744(15);
      }
   }

   static final void method745(int i) {
      Node_Sub46.aFont7555 = null;
      if (i != 22732) {
         method741(15, -78, 20);
      }

      ++anInt959;
      Class54.anImage813 = null;
   }

   final void method746(int i, int i_2_) {
      synchronized(this.aClass61_960) {
         if (i_2_ != -3452) {
            return;
         }

         this.aClass61_960.method598(i, -11819);
      }

      ++anInt955;
   }

   Class71(Class353 class353, int i, Index class302) {
      this.aClass302_951 = class302;
      this.anInt956 = this.aClass302_951.method3537(-2, 4);
   }
}
