public class Class98 implements Interface7 {
   static int anInt5053;
   protected int anInt5054;
   protected int anInt5055;
   protected int anInt5056;
   protected String aString5057;
   static int anInt5058;
   protected int anInt5059;
   static int anInt5060;
   static int cameraPosX;
   protected int anInt5062;
   protected int anInt5063;
   protected int anInt5064;
   protected int anInt5065;
   protected Class379 aClass379_5066;
   protected int anInt5067;
   protected int anInt5068;
   protected Class77 aClass77_5069;
   static int anInt5070;

   static final void method1081(int i, byte b) {
      if (b != -68) {
         cameraPosX = 113;
      }

      ++anInt5070;
      Class320_Sub27.anInt8461 = i;
      Class96.aClass61_1272.method608(false);
   }

   @Override
   public final Class170 method20(int i) {
      ++anInt5053;
      if (i < 81) {
         method1082((byte)-121, -8);
      }

      return Class106.aClass170_1357;
   }

   static final void method1082(byte b, int i) {
      if (Node_Sub38_Sub15.aByteArrayArrayArray10261 == null) {
         Node_Sub38_Sub15.aByteArrayArrayArray10261 = new byte[4][Node_Sub54.GAME_SCENE_WDITH][Class377_Sub1.GAME_SCENE_HEIGHT];
      }

      ++anInt5060;

      for(int i_0_ = 0; i_0_ < 4; ++i_0_) {
         for(int i_1_ = 0; i_1_ < Node_Sub54.GAME_SCENE_WDITH; ++i_1_) {
            for(int i_2_ = 0; Class377_Sub1.GAME_SCENE_HEIGHT > i_2_; ++i_2_) {
               Node_Sub38_Sub15.aByteArrayArrayArray10261[i_0_][i_1_][i_2_] = b;
            }
         }
      }

      if (i != 2395) {
         cameraPosX = 94;
      }
   }

   static final void method1083(int i, int i_3_) {
      Node_Sub15_Sub4.anInt9800 = 100;
      Node_Sub38_Sub19.anInt10296 = i;
      ++anInt5058;
      Class168.anInt2044 = 3;
      int i_4_ = 97 / ((i_3_ - -32) / 58);
      Class253.anInt3201 = -1;
   }

   Class98(
      String string, Class379 class379, Class77 class77, int i, int i_5_, int i_6_, int i_7_, int i_8_, int i_9_, int i_10_, int i_11_, int i_12_, int i_13_
   ) {
      this.anInt5064 = i_12_;
      this.anInt5056 = i_6_;
      this.aString5057 = string;
      this.anInt5068 = i_7_;
      this.anInt5065 = i;
      this.anInt5063 = i_8_;
      this.anInt5062 = i_9_;
      this.anInt5055 = i_10_;
      this.aClass77_5069 = class77;
      this.anInt5059 = i_13_;
      this.aClass379_5066 = class379;
      this.anInt5054 = i_11_;
      this.anInt5067 = i_5_;
   }
}
