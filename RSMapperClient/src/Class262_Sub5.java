public class Class262_Sub5 extends Class262 {
   static Class199[] aClass199Array7732;
   private String aString7733;
   static int anInt7734;
   private int anInt7735;
   private int anInt7736;
   static int anInt7737;
   static int anInt7738;
   static int anInt7739 = 0;
   private int anInt7740;
   private int anInt7741;

   public static void method3162(int i) {
      if (i != 0) {
         aClass199Array7732 = null;
      }

      aClass199Array7732 = null;
   }

   static final boolean method3163(String string, boolean bool) {
      if (bool) {
         anInt7737 = -72;
      }

      ++anInt7738;
      return Class71.aHashtable958.containsKey(string);
   }

   Class262_Sub5(Buffer buffer) {
      super(buffer);
      this.anInt7740 = buffer.readUnsignedShort();
      this.anInt7735 = buffer.readUnsignedShort();
      this.aString7733 = buffer.readString();
      this.anInt7741 = buffer.readInt();
      this.anInt7736 = buffer.readUnsignedShort();
   }

   @Override
   final void method3148(int i) {
      r.createTextMarker(
         this.aString7733,
         this.anInt7740,
         this.anInt7735,
         CacheNode_Sub20_Sub1.myPlayerPlane,
         Node_Sub38_Sub7.getTileMedianHeight(CacheNode_Sub20_Sub1.myPlayerPlane, -29754, this.anInt7735, this.anInt7740),
         this.anInt7741,
         this.anInt7736
      );
      if (i <= -102) {
         ++anInt7734;
      }
   }
}
