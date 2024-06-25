import jaggl.OpenGL;

public class CacheNode_Sub17 extends CacheNode implements Interface2 {
   static int anInt8832;
   private int anInt8833;
   static int anInt8834;
   static int anInt8835 = 0;
   private GLToolkit aGLToolkit8836;
   protected int anInt8837;
   private int anInt8838;
   static int anInt8839;
   static int[] anIntArray8840 = new int[4096];
   private int anInt8841;
   private int anInt8842 = -1;
   static int anInt8843;
   static int anInt8844;
   static int anInt8845;
   static int[] BIT_FLAGS;
   static float aFloat8847;
   private int anInt8848;
   static int anInt8849;
   protected int anInt8850;

   static {
      for(int i = 0; ~i > -4097; ++i) {
         anIntArray8840[i] = ObjectDefinition.method3047(i, -1);
      }

      BIT_FLAGS = new int[]{
         0,
         1,
         3,
         7,
         15,
         31,
         63,
         127,
         255,
         511,
         1023,
         2047,
         4095,
         8191,
         16383,
         32767,
         65535,
         131071,
         262143,
         524287,
         1048575,
         2097151,
         4194303,
         8388607,
         16777215,
         33554431,
         67108863,
         134217727,
         268435455,
         536870911,
         1073741823,
         Integer.MAX_VALUE,
         -1
      };
   }

   static final int method2393(int i, int i_0_, int i_1_) {
      if (i_1_ != 2097151) {
         return 26;
      } else {
         ++anInt8845;
         int i_2_ = 57 * i + i_0_;
         i_2_ ^= i_2_ << 13;
         int i_3_ = 2147483647 & 1376312589 + i_2_ * (15731 * i_2_ * i_2_ + 789221);
         return i_3_ >> 19 & 0xFF;
      }
   }

   static final String method2394(byte b) {
      ++anInt8834;
      if (b != 47) {
         method2397((byte)-89);
      }

      String string = "www";
      if (Node_Sub38_Sub1.aClass329_10086 != Class189_Sub1.aClass329_6887) {
         if (Node_Sub38_Sub1.aClass329_10086 != Class379.aClass329_4873) {
            if (Node_Sub38_Sub1.aClass329_10086 == Class229.aClass329_2730) {
               string = "www-wtwip";
            }
         } else {
            string = "www-wtqa";
         }
      } else {
         string = "www-wtrc";
      }

      String string_4_ = "";
      if (Class83.aString5186 != null) {
         string_4_ = "/p=" + Class83.aString5186;
      }

      return "http://"
         + string.replace("runescape", "Map Editor")
         + "."
         + Class209.aClass353_2483.aString4341
         + ".com/l="
         + Class35.language
         + "/a="
         + Class170.anInt2056
         + string_4_
         + "/";
   }

   public static void method2395(int i) {
      if (i <= -83) {
         anIntArray8840 = null;
         BIT_FLAGS = null;
      }
   }

   @Override
   protected final void finalize() throws Throwable {
      this.method2398((byte)16);
      ++anInt8849;
      super.finalize();
   }

   final void method2396(int i, int i_5_, int i_6_) {
      ++anInt8839;
      OpenGL.glFramebufferRenderbufferEXT(i_5_, i, 36161, this.anInt8838);
      this.anInt8842 = i;
      this.anInt8841 = i_5_;
      if (i_6_ > -17) {
         method2397((byte)32);
      }
   }

   @Override
   public final void method5(int i) {
      OpenGL.glFramebufferRenderbufferEXT(this.anInt8841, this.anInt8842, 36161, i);
      ++anInt8832;
      this.anInt8842 = -1;
      this.anInt8841 = -1;
   }

   static final Buffer method2397(byte b) {
      ++anInt8844;
      Buffer buffer = Class300.method3500(3);
      buffer.writeLong(0L);
      buffer.writeString(Node_Sub5.password);
      if (b != 27) {
         BIT_FLAGS = null;
      }

      buffer.writeLong(Class188_Sub1_Sub2.aLong9342);
      buffer.writeLong(CacheNode_Sub15.aLong9588);
      buffer.encodeRSA();
      return buffer;
   }

   final void method2398(byte b) {
      int i = -98 % ((-19 - b) / 32);
      if (~this.anInt8838 < -1) {
         this.aGLToolkit8836.method1426(this.anInt8838, (byte)-32, this.anInt8833);
         this.anInt8838 = 0;
      }

      ++anInt8843;
   }

   CacheNode_Sub17(GLToolkit gltoolkit, int i, int i_7_, int i_8_) {
      this.anInt8841 = -1;
      this.anInt8848 = i;
      this.aGLToolkit8836 = gltoolkit;
      this.anInt8837 = i_7_;
      this.anInt8850 = i_8_;
      OpenGL.glGenRenderbuffersEXT(1, Class376.anIntArray4660, 0);
      this.anInt8838 = Class376.anIntArray4660[0];
      OpenGL.glBindRenderbufferEXT(36161, this.anInt8838);
      OpenGL.glRenderbufferStorageEXT(36161, this.anInt8848, this.anInt8837, this.anInt8850);
      this.anInt8833 = this.anInt8837 * this.anInt8850 * this.aGLToolkit8836.method1471(this.anInt8848, 118);
   }

   CacheNode_Sub17(GLToolkit gltoolkit, int i, int i_9_, int i_10_, int i_11_) {
      this.anInt8841 = -1;
      this.aGLToolkit8836 = gltoolkit;
      this.anInt8848 = i;
      this.anInt8837 = i_9_;
      this.anInt8850 = i_10_;
      OpenGL.glGenRenderbuffersEXT(1, Class376.anIntArray4660, 0);
      this.anInt8838 = Class376.anIntArray4660[0];
      OpenGL.glBindRenderbufferEXT(36161, this.anInt8838);
      OpenGL.glRenderbufferStorageMultisampleEXT(36161, i_11_, this.anInt8848, this.anInt8837, this.anInt8850);
      this.anInt8833 = this.anInt8850 * this.anInt8837 * this.aGLToolkit8836.method1471(this.anInt8848, 87);
   }
}
