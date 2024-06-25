public class Class255 {
   protected int anInt3214;
   protected int anInt3215 = -1;
   private int anInt3216;
   protected Class186 aClass186_3217;
   static boolean aBoolean3218 = false;
   private int anInt3219;
   static int anInt3220;
   private int anInt3221;
   private String aString3222 = "";
   protected int anInt3223;
   static int anInt3224;
   static int anInt3225;
   private int anInt3226;
   static int anInt3227;
   static int anInt3228;
   protected int anInt3229;
   protected int anInt3230;
   protected int anInt3231;
   static int anInt3232;
   static int anInt3233;
   protected int anInt3234;
   protected int anInt3235;
   static int anInt3236;

   final GLSprite method3111(GraphicsToolkit graphicstoolkit, int i) {
      ++anInt3225;
      if (i < ~this.anInt3219) {
         return null;
      } else {
         GLSprite glsprite = (GLSprite)this.aClass186_3217.aClass61_2258.method607((long)this.anInt3219, 0);
         if (glsprite == null) {
            this.method3115(-1, graphicstoolkit);
            glsprite = (GLSprite)this.aClass186_3217.aClass61_2258.method607((long)this.anInt3219, 0);
         }

         return glsprite;
      }
   }

   final GLSprite method3112(int i, GraphicsToolkit graphicstoolkit) {
      ++anInt3224;
      if (this.anInt3216 < 0) {
         return null;
      } else {
         if (i < 64) {
            this.method3116(null, (byte)62, -12);
         }

         GLSprite glsprite = (GLSprite)this.aClass186_3217.aClass61_2258.method607((long)this.anInt3216, 0);
         if (glsprite == null) {
            this.method3115(-1, graphicstoolkit);
            glsprite = (GLSprite)this.aClass186_3217.aClass61_2258.method607((long)this.anInt3216, 0);
         }

         return glsprite;
      }
   }

   final GLSprite method3113(GraphicsToolkit graphicstoolkit, byte b) {
      ++anInt3232;
      if (this.anInt3226 < 0) {
         return null;
      } else {
         if (b >= -81) {
            this.anInt3214 = -124;
         }

         GLSprite glsprite = (GLSprite)this.aClass186_3217.aClass61_2258.method607((long)this.anInt3226, 0);
         if (glsprite == null) {
            this.method3115(-1, graphicstoolkit);
            glsprite = (GLSprite)this.aClass186_3217.aClass61_2258.method607((long)this.anInt3226, 0);
         }

         return glsprite;
      }
   }

   final GLSprite method3114(int i, GraphicsToolkit graphicstoolkit) {
      ++anInt3233;
      if (this.anInt3221 < i) {
         return null;
      } else {
         GLSprite glsprite = (GLSprite)this.aClass186_3217.aClass61_2258.method607((long)this.anInt3221, 0);
         if (glsprite == null) {
            this.method3115(i + -1, graphicstoolkit);
            glsprite = (GLSprite)this.aClass186_3217.aClass61_2258.method607((long)this.anInt3221, 0);
         }

         return glsprite;
      }
   }

   private final void method3115(int i, GraphicsToolkit graphicstoolkit) {
      ++anInt3220;
      Index class302 = this.aClass186_3217.aClass302_2260;
      if (this.anInt3221 >= 0 && this.aClass186_3217.aClass61_2258.method607((long)this.anInt3221, 0) == null && class302.method3510(this.anInt3221, (byte)63)
         )
       {
         Class383 class383 = Class383.method4191(class302, this.anInt3221);
         this.aClass186_3217.aClass61_2258.method601(graphicstoolkit.a(class383, true), 25566, (long)this.anInt3221);
      }

      if (i >= ~this.anInt3219
         && this.aClass186_3217.aClass61_2258.method607((long)this.anInt3219, 0) == null
         && class302.method3510(this.anInt3219, (byte)63)) {
         Class383 class383 = Class383.method4191(class302, this.anInt3219);
         this.aClass186_3217.aClass61_2258.method601(graphicstoolkit.a(class383, true), 25566, (long)this.anInt3219);
      }

      if (~this.anInt3216 <= -1
         && this.aClass186_3217.aClass61_2258.method607((long)this.anInt3216, 0) == null
         && class302.method3510(this.anInt3216, (byte)63)) {
         Class383 class383 = Class383.method4191(class302, this.anInt3216);
         this.aClass186_3217.aClass61_2258.method601(graphicstoolkit.a(class383, true), 25566, (long)this.anInt3216);
      }

      if (~this.anInt3226 <= -1
         && this.aClass186_3217.aClass61_2258.method607((long)this.anInt3226, 0) == null
         && class302.method3510(this.anInt3226, (byte)63)) {
         Class383 class383 = Class383.method4191(class302, this.anInt3226);
         this.aClass186_3217.aClass61_2258.method601(graphicstoolkit.a(class383, true), i + 25567, (long)this.anInt3226);
      }
   }

   private final void method3116(Buffer buffer, byte b, int i) {
      if (~i == -2) {
         this.anInt3235 = buffer.readUnsignedShort();
      } else if (i == 2) {
         this.anInt3229 = buffer.read24BitInteger();
      } else if (~i != -4) {
         if (~i != -5) {
            if (i == 5) {
               this.anInt3219 = buffer.readUnsignedShort();
            } else if (~i != -7) {
               if (i != 7) {
                  if (i == 8) {
                     this.aString3222 = buffer.method2180((byte)101);
                  } else if (~i != -10) {
                     if (i != 10) {
                        if (~i == -12) {
                           this.anInt3215 = 0;
                        } else if (i == 12) {
                           this.anInt3234 = buffer.readUnsignedByte();
                        } else if (i != 13) {
                           if (~i == -15) {
                              this.anInt3215 = buffer.readUnsignedShort();
                           }
                        } else {
                           this.anInt3214 = buffer.readShort();
                        }
                     } else {
                        this.anInt3230 = buffer.readShort();
                     }
                  } else {
                     this.anInt3231 = buffer.readUnsignedShort();
                  }
               } else {
                  this.anInt3223 = buffer.readShort();
               }
            } else {
               this.anInt3226 = buffer.readUnsignedShort();
            }
         } else {
            this.anInt3216 = buffer.readUnsignedShort();
         }
      } else {
         this.anInt3221 = buffer.readUnsignedShort();
      }

      ++anInt3228;
      if (b >= -12) {
         this.method3115(-43, null);
      }
   }

   final String method3117(int i, boolean bool) {
      ++anInt3227;
      String string = this.aString3222;

      while(true) {
         int i_0_ = string.indexOf("%1");
         if (~i_0_ > -1) {
            if (!bool) {
               this.method3117(-15, true);
            }

            return string;
         }

         string = string.substring(0, i_0_) + Node_Sub29_Sub2.method2715((byte)9, false, i) + string.substring(2 + i_0_);
      }
   }

   final void method3118(boolean bool, Buffer buffer) {
      while(true) {
         int i = buffer.readUnsignedByte();
         if (i == 0) {
            ++anInt3236;
            if (bool) {
               this.method3111(null, 93);
            }

            return;
         }

         this.method3116(buffer, (byte)-16, i);
      }
   }

   public Class255() {
      this.anInt3221 = -1;
      this.anInt3223 = 0;
      this.anInt3226 = -1;
      this.anInt3216 = -1;
      this.anInt3230 = 0;
      this.anInt3229 = 16777215;
      this.anInt3231 = 70;
      this.anInt3214 = 0;
      this.anInt3219 = -1;
      this.anInt3235 = -1;
      this.anInt3234 = -1;
   }
}
