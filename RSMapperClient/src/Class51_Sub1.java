import jaclib.memory.Source;

public class Class51_Sub1 extends Class51 implements Interface15_Impl2 {
   static int anInt9053;
   static IncommingPacket aClass192_9054 = new IncommingPacket(144, 5);
   static int anInt9055;
   static int anInt9056;
   static int anInt9057;
   static int anInt9058;
   private byte aByte9059;
   static int anInt9060;
   static OutgoingPacket aClass318_9061 = new OutgoingPacket(27, 7);
   static int anInt9062;
   static int anInt9063;
   static int anInt9064 = -1;

   @Override
   public final boolean method39(int i) {
      int i_0_ = 28 % ((70 - i) / 45);
      ++anInt9063;
      return super.method517(0, this.aGLXToolkit5332.aMapBuffer9314);
   }

   @Override
   public final boolean method37(int i, int i_1_, int i_2_) {
      ++anInt9060;
      if (i_2_ != -12093) {
         return true;
      } else {
         this.aByte9059 = (byte)i;
         super.method56(i_2_ ^ 10659, i_1_);
         return true;
      }
   }

   final int method521(int i) {
      ++anInt9053;
      if (i != -11856) {
         this.aByte9059 = -123;
      }

      return this.aByte9059;
   }

   @Override
   public final boolean method36(int i, int i_3_, Source source, int i_4_) {
      ++anInt9057;
      if (i_4_ != 1965) {
         return false;
      } else {
         this.aByte9059 = (byte)i;
         super.method516(i_3_, source, true);
         return true;
      }
   }

   Class51_Sub1(GLXToolkit glxtoolkit, boolean bool) {
      super(glxtoolkit, 34962, bool);
   }

   static final int method522(String string, byte b) {
      ++anInt9062;
      int i = string.length();
      if (b != -104) {
         method523(true);
      }

      int i_5_ = 0;

      for(int i_6_ = 0; ~i < ~i_6_; ++i_6_) {
         i_5_ = string.charAt(i_6_) + (i_5_ << 5) + -i_5_;
      }

      return i_5_;
   }

   public static void method523(boolean bool) {
      aClass192_9054 = null;
      aClass318_9061 = null;
      if (!bool) {
         method522(null, (byte)32);
      }
   }

   @Override
   public final int method57(byte b) {
      ++anInt9055;
      if (b >= -56) {
         anInt9064 = -61;
      }

      return super.method57((byte)-79);
   }

   @Override
   public final void method38(boolean bool) {
      ++anInt9056;
      super.method38(bool);
   }

   @Override
   public final jaclib.memory.Buffer method40(int i, boolean bool) {
      ++anInt9058;
      int i_7_ = 86 / ((i - 56) / 48);
      return super.method519(bool, this.aGLXToolkit5332.aMapBuffer9314, -5934);
   }
}
