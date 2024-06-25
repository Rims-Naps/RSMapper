abstract class Class10 {
   static int anInt168;
   static Class124 aClass124_169 = new Class124(13);
   static int anInt170;
   static int anInt171;
   static GLSprite aGLSprite172;
   static GLSprite aGLSprite173;
   static int anInt174;
   static IncommingPacket aClass192_175 = new IncommingPacket(51, 0);
   static Class96 aClass96_176;

   abstract long method186(int var1);

   static final int method187(String string, int i, boolean bool) {
      ++anInt171;
      if (!bool) {
         aGLSprite173 = null;
      }

      return Class145.method1638(21642, string, i, true);
   }

   static final int method188(byte b, int i, int i_0_, byte[] bs) {
      if (b != -58) {
         return 33;
      } else {
         ++anInt170;
         int i_1_ = -1;

         for(int i_2_ = i_0_; i > i_2_; ++i_2_) {
            i_1_ = i_1_ >>> 8 ^ Class363.anIntArray4505[0xFF & (i_1_ ^ bs[i_2_])];
         }

         return ~i_1_;
      }
   }

   static final void method189(Buffer buffer, int i) {
      if (i < 1) {
         method188((byte)-113, -117, 99, null);
      }

      ++anInt168;

      while(true) {
         int i_3_ = buffer.readUnsignedByte();
         if (~i_3_ != -1) {
            if (~i_3_ == -256) {
               return;
            }
         } else {
            RenderDefinitions.anInt3254 = buffer.readUnsignedShort();
            Class270_Sub1.anInt8034 = buffer.readUnsignedShort();
         }
      }
   }

   public static void method190(int i) {
      aGLSprite172 = null;
      aClass96_176 = null;
      aClass192_175 = null;
      aGLSprite173 = null;
      aClass124_169 = null;
      int i_5_ = -77 / ((i - 57) / 58);
   }

   public Class10() {
   }
}
