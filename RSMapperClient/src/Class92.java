public class Class92 implements Runnable {
   static int anInt1229;
   static int anInt1230 = -1;
   volatile boolean aBoolean1231;
   volatile boolean aBoolean1232;
   static WorldmapAreaDetail aCacheNode_Sub11_1233;
   volatile Class42[] aClass42Array1234 = new Class42[2];
   static int anInt1235 = -1;
   static int anInt1236;
   protected SignLink aSignLink1237;

   @Override
   public final void run() {
      ++anInt1236;
      this.aBoolean1232 = true;

      try {
         while(!this.aBoolean1231) {
            for(int i = 0; i < 2; ++i) {
               Class42 class42 = this.aClass42Array1234[i];
               if (class42 != null) {
                  class42.method453((byte)-105);
               }
            }

            Class262_Sub22.method3208(10L, false);
            ObjectDefinition.method3049(this.aSignLink1237, null, (byte)93);
         }
      } catch (Exception var6) {
         ClanChat.method507(var6, null, -115);
      } finally {
         this.aBoolean1232 = false;
      }
   }

   public static void method1037(int i) {
      aCacheNode_Sub11_1233 = null;
      if (i != -29003) {
         Node_Sub43.aBoolean7231 = !Node_Sub43.aBoolean7231;
         Class88.aString5297 = "";
         aCacheNode_Sub11_1233 = null;
      }
   }

   public static void method1038(int i) {
      if (i != 28) {
         Node_Sub43.aBoolean7231 = true;
      }
   }

   Class92() {
      this.aBoolean1231 = false;
      this.aBoolean1232 = false;
   }
}
