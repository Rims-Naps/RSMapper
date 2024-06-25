public class Class343 {
   protected Class119 aClass119_4238;
   protected float aFloat4239;
   protected Class270 aClass270_4240;
   static int anInt4241;
   static int anInt4242;
   static int anInt4243;
   protected float aFloat4244 = 1.0F;
   static int anInt4245;
   static int anInt4246;
   protected int sunDistanceZ;
   protected int sunDistanceY;
   protected int sunDistanceX;
   protected float blackpoint;
   protected float aFloat4251 = 1.0F;
   static int anInt4252;
   protected int highlightcolor;
   protected float brightness;
   static short[] aShortArray4255;
   protected float vibrance;
   protected int fogcolor;
   protected int fogDensity;
   static int anInt4259;

   static final Class241 method3962(String string, int i, int i_0_, SignLink signlink) {
      if (i > -102) {
         return null;
      } else {
         ++anInt4259;
         return Class188_Sub2_Sub1.method1910((byte)84, signlink, string, "openjs", i_0_);
      }
   }

   public static void method3963(int i) {
      aShortArray4255 = null;
      if (i != -28381) {
         anInt4252 = 59;
      }
   }

   final void method3964(Buffer buffer, int i) {
      ++anInt4245;
      if (i != -4807) {
         this.aFloat4251 = 0.64789647F;
      }

      int i_1_ = buffer.readUnsignedShort();
      int i_2_ = buffer.readShort();
      int i_3_ = buffer.readShort();
      int i_4_ = buffer.readShort();
      int i_5_ = buffer.readUnsignedShort();
      Class235.anInt5127 = i_5_;
      this.aClass119_4238 = Class181.method1830(false, i_3_, i_1_, i_2_, i_4_);
   }

   final void method3965(Buffer buffer, boolean bool) {
      this.aFloat4244 = (float)(8 * buffer.readUnsignedByte()) / 255.0F;
      if (!bool) {
         method3962(null, -51, 80, null);
      }

      ++anInt4242;
      this.aFloat4239 = (float)(8 * buffer.readUnsignedByte()) / 255.0F;
      this.aFloat4251 = (float)(8 * buffer.readUnsignedByte()) / 255.0F;
   }

   final void decodeEnvironment(Buffer buffer, int junk, int archiveId) {
      ++anInt4241;
      int flag = buffer.readUnsignedByte();
      if (junk != 24176) {
         this.method3964(null, -46);
      }

      if (Class213.aNode_Sub27_2512.aClass320_Sub24_7317.method3773(false) == 1 && Class229.aGraphicsToolkit2732.getanInt6367() > 0) {
         if ((flag & 1) != 0) {
            this.highlightcolor = buffer.readInt();
         } else {
            this.highlightcolor = Class42.anInt649;
         }

         if ((flag & 2) != 0) {
            this.brightness = (float)buffer.readUnsignedShort() / 256.0F;
         } else {
            this.brightness = 1.1523438F;
         }

         if ((flag & 4) != 0) {
            this.vibrance = (float)buffer.readUnsignedShort() / 256.0F;
         } else {
            this.vibrance = 0.69921875F;
         }

         if ((flag & 8) != 0) {
            this.blackpoint = (float)buffer.readUnsignedShort() / 256.0F;
         } else {
            this.blackpoint = 1.2F;
         }
      } else {
         if ((flag & 1) != 0) {
            buffer.readInt();
         }

         if ((flag & 2) != 0) {
            buffer.readUnsignedShort();
         }

         if ((flag & 4) != 0) {
            buffer.readUnsignedShort();
         }

         if ((flag & 8) != 0) {
            buffer.readUnsignedShort();
         }

         this.blackpoint = 1.2F;
         this.brightness = 1.1523438F;
         this.vibrance = 0.69921875F;
         this.highlightcolor = Class42.anInt649;
      }

      if ((flag & 16) != 0) {
         this.sunDistanceX = buffer.readShort();
         this.sunDistanceZ = buffer.readShort();
         this.sunDistanceY = buffer.readShort();
      } else {
         this.sunDistanceX = -50;
         this.sunDistanceY = -50;
         this.sunDistanceZ = -60;
      }

      if ((flag & 32) != 0) {
         this.fogcolor = buffer.readInt();
      } else {
         this.fogcolor = Class320_Sub26.anInt8456;
      }

      if ((flag & 64) != 0) {
         this.fogDensity = buffer.readUnsignedShort();
      } else {
         this.fogDensity = 0;
      }

      int i_7_ = 0;
      int i_8_ = 0;
      int i_9_ = 0;
      int i_10_ = 0;
      int i_11_ = 0;
      int i_12_ = 0;
      if ((flag & 128) != 0) {
         i_7_ = buffer.readUnsignedShort();
         i_8_ = buffer.readUnsignedShort();
         i_9_ = buffer.readUnsignedShort();
         i_10_ = buffer.readUnsignedShort();
         i_11_ = buffer.readUnsignedShort();
         i_12_ = buffer.readUnsignedShort();
      }

      if (archiveId == RSMapperClient.mapArchiveId) {
         if (RSMapperClient.editor.mapEditor.dataLoaded) {
            boolean previewing = RSMapperClient.editor.mapEditor.previewingEnvironment;
            flag = RSMapperClient.editor.mapEditor.environmentFlag[previewing ? 1 : 0];
            this.sunDistanceX = RSMapperClient.editor.mapEditor.sunDistanceX[previewing ? 1 : 0];
            this.sunDistanceY = RSMapperClient.editor.mapEditor.sunDistanceY[previewing ? 1 : 0];
            this.sunDistanceZ = RSMapperClient.editor.mapEditor.sunDistanceZ[previewing ? 1 : 0];
            this.highlightcolor = RSMapperClient.editor.mapEditor.highlightcolor[previewing ? 1 : 0];
            this.brightness = RSMapperClient.editor.mapEditor.brightness[previewing ? 1 : 0];
            this.vibrance = RSMapperClient.editor.mapEditor.vibrance[previewing ? 1 : 0];
            this.blackpoint = RSMapperClient.editor.mapEditor.blackpoint[previewing ? 1 : 0];
            this.fogcolor = RSMapperClient.editor.mapEditor.fogcolor[previewing ? 1 : 0];
            this.fogDensity = RSMapperClient.settings.disabledEnvironment ? -200 : RSMapperClient.editor.mapEditor.fogdensity[previewing ? 1 : 0];
            i_7_ = RSMapperClient.editor.mapEditor.i_7_;
            i_8_ = RSMapperClient.editor.mapEditor.i_8_;
            i_9_ = RSMapperClient.editor.mapEditor.i_9_;
            i_10_ = RSMapperClient.editor.mapEditor.i_10_;
            i_11_ = RSMapperClient.editor.mapEditor.i_11_;
            i_12_ = RSMapperClient.editor.mapEditor.i_12_;
         } else {
            RSMapperClient.editor.mapEditor.environmentFlag[0] = flag;
            RSMapperClient.editor.mapEditor.sunDistanceX[0] = this.sunDistanceX;
            RSMapperClient.editor.mapEditor.sunDistanceY[0] = this.sunDistanceY;
            RSMapperClient.editor.mapEditor.sunDistanceZ[0] = this.sunDistanceZ;
            RSMapperClient.editor.mapEditor.highlightcolor[0] = this.highlightcolor;
            RSMapperClient.editor.mapEditor.brightness[0] = this.brightness;
            RSMapperClient.editor.mapEditor.vibrance[0] = this.vibrance;
            RSMapperClient.editor.mapEditor.blackpoint[0] = this.blackpoint;
            RSMapperClient.editor.mapEditor.fogcolor[0] = this.fogcolor;
            RSMapperClient.editor.mapEditor.fogdensity[0] = this.fogDensity;
            RSMapperClient.editor.mapEditor.i_7_ = i_7_;
            RSMapperClient.editor.mapEditor.i_8_ = i_8_;
            RSMapperClient.editor.mapEditor.i_9_ = i_9_;
            RSMapperClient.editor.mapEditor.i_10_ = i_10_;
            RSMapperClient.editor.mapEditor.i_11_ = i_11_;
            RSMapperClient.editor.mapEditor.i_12_ = i_12_;
         }
      }

      if ((flag & 128) != 0) {
         this.aClass270_4240 = Class320_Sub14.method3736(i_11_, -98, i_8_, i_9_, i_10_, i_12_, i_7_);
      } else {
         this.aClass270_4240 = GraphicsToolkit.aClass270_1548;
      }
   }

   static final boolean method3967(int i, int i_13_, int i_14_) {
      if (i_14_ < 10) {
         aShortArray4255 = null;
      }

      ++anInt4243;
      return ~(262144 & i) != -1 | Class320_Sub7.method3711((byte)76, i, i_13_) || Class110.method1135(i, i_13_, false);
   }

   final boolean method3968(byte b, Class343 class343_15_) {
      ++anInt4246;
      int i = 39 / ((b - -4) / 42);
      return this.highlightcolor == class343_15_.highlightcolor
         && class343_15_.brightness == this.brightness
         && this.vibrance == class343_15_.vibrance
         && this.blackpoint == class343_15_.blackpoint
         && class343_15_.aFloat4239 == this.aFloat4239
         && this.aFloat4244 == class343_15_.aFloat4244
         && this.aFloat4251 == class343_15_.aFloat4251
         && ~this.fogcolor == ~class343_15_.fogcolor
         && ~class343_15_.fogDensity == ~this.fogDensity
         && class343_15_.aClass270_4240 == this.aClass270_4240
         && class343_15_.aClass119_4238 == this.aClass119_4238;
   }

   public Class343() {
      this.aFloat4239 = 0.25F;
      this.sunDistanceZ = -60;
      this.aClass270_4240 = GraphicsToolkit.aClass270_1548;
      this.sunDistanceX = -50;
      this.blackpoint = 1.2F;
      this.aClass119_4238 = Class263.aClass119_3340;
      this.highlightcolor = Class42.anInt649;
      this.vibrance = 0.69921875F;
      this.brightness = 1.1523438F;
      this.sunDistanceY = -50;
      this.fogcolor = Class320_Sub26.anInt8456;
      this.fogDensity = 0;
   }

   Class343(Buffer buffer, int regionId) {
      this.aFloat4239 = 0.25F;
      this.decodeEnvironment(buffer, 24176, regionId);
   }
}
