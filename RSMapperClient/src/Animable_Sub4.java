import jaggl.OpenGL;

abstract class Animable_Sub4 extends Animable {
   protected short aShort9145;
   static int anInt9146;
   protected short aShort9147;
   static int anInt9148;
   static int anInt9149;
   static int anInt9150;
   static int anInt9151;
   static int anInt9152;
   static int anInt9153 = 0;
   static int anInt9154;
   static int anInt9155;

   @Override
   final boolean method815(byte b, GraphicsToolkit graphicstoolkit) {
      ++anInt9146;
      if (b != 59) {
         this.aShort9145 = -126;
      }

      return Class150.method1652(this.method817(2), this.aByte5931, this.x >> Class36.INT_9, 0, this.y >> Class36.INT_9);
   }

   @Override
   final void method811(int i) {
      ++anInt9155;
      if (i == 27811) {
         throw new IllegalStateException();
      }
   }

   @Override
   final void method816(int i, boolean bool, GraphicsToolkit graphicstoolkit, int i_0_, byte b, int i_1_, Animable animable) {
      if (b < 101) {
         anInt9153 = -26;
      }

      ++anInt9150;
      throw new IllegalStateException();
   }

   static final int method925(int i, int i_2_) {
      if (i_2_ != 34933) {
         method926(null, 59, null, (byte)88);
      }

      ++anInt9149;
      return (i & 261544) >> 11;
   }

   static final Class50 method926(String string, int i, GLToolkit gltoolkit, byte b) {
      ++anInt9154;
      if (b <= 97) {
         return null;
      } else {
         int i_3_ = OpenGL.glGenProgramARB();
         OpenGL.glBindProgramARB(i, i_3_);
         OpenGL.glProgramStringARB(i, 34933, string);
         OpenGL.glGetIntegerv(34379, Class96.anIntArray1271, 0);
         if (~Class96.anIntArray1271[0] != 0) {
            OpenGL.glBindProgramARB(i, 0);
            return null;
         } else {
            OpenGL.glBindProgramARB(i, 0);
            return new Class50(gltoolkit, i, i_3_);
         }
      }
   }

   @Override
   final boolean method821(int i) {
      ++anInt9148;
      if (i != 0) {
         method926(null, 109, null, (byte)91);
      }

      return false;
   }

   @Override
   final int method819(Node_Sub29[] node_sub29s, int i) {
      if (i != 1) {
         return -69;
      } else {
         ++anInt9152;
         return this.method808(-23024, node_sub29s, this.y >> Class36.INT_9, this.x >> Class36.INT_9);
      }
   }

   Animable_Sub4(int i, int i_4_, int i_5_, int i_6_, int i_7_, int i_8_, int i_9_) {
      this.plane = (byte)i_6_;
      this.aShort9145 = (short)i_8_;
      this.y = i_5_;
      this.aShort9147 = (short)i_9_;
      this.x = i;
      this.aByte5931 = (byte)i_7_;
      this.anInt5937 = i_4_;
   }

   @Override
   final boolean method806(int i) {
      if (i != 0) {
         this.aShort9145 = 74;
      }

      ++anInt9151;
      return Class139.aBooleanArrayArray1730[-Class216.anInt2551 + (this.x >> Class36.INT_9) - -Node_Sub9_Sub1.anInt9656][-EntityNode_Sub7.anInt6013
         + (this.y >> Class36.INT_9)
         + Node_Sub9_Sub1.anInt9656];
   }
}
