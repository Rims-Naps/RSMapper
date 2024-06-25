import java.util.Date;

abstract class Class93 {
   static float[] aFloatArray1238 = new float[16384];
   static int anInt1239;
   static int anInt1240;
   static GraphicsToolkit aGraphicsToolkit1241;
   static float[] aFloatArray1242 = new float[16384];
   static int anInt1243;
   static byte[][] aByteArrayArray1244;
   static int anInt1245;
   static int anInt1246;

   static {
      double d = 3.834951969714103E-4;

      for(int i = 0; i < 16384; ++i) {
         aFloatArray1238[i] = (float)Math.sin(d * (double)i);
         aFloatArray1242[i] = (float)Math.cos(d * (double)i);
      }
   }

   abstract void method1038();

   abstract boolean method1039();

   abstract boolean method1040();

   final boolean method1041(byte b) {
      if (b < 15) {
         return false;
      } else {
         ++anInt1243;
         return this.method1039() || this.method1044() || this.method1040();
      }
   }

   public static void method1042(byte b) {
      aFloatArray1238 = null;
      if (b != 48) {
         method1046(null, -73);
      }

      aByteArrayArray1244 = null;
      aGraphicsToolkit1241 = null;
      aFloatArray1242 = null;
   }

   static final String method1043(long l, int i) {
      if (i != 10) {
         return null;
      } else {
         Class247.aCalendar3144.setTime(new Date(l));
         ++anInt1246;
         Class247.aCalendar3144.get(7);
         int i_1_ = Class247.aCalendar3144.get(5);
         Class247.aCalendar3144.get(2);
         int i_3_ = Class247.aCalendar3144.get(1);
         int i_4_ = Class247.aCalendar3144.get(11);
         int i_5_ = Class247.aCalendar3144.get(12);
         int i_6_ = Class247.aCalendar3144.get(13);
         return ", " + i_1_ / 10 + i_1_ % 10 + "-" + i_3_ + " " + i_4_ / 10 + i_4_ % 10 + ":" + i_5_ / 10 + i_5_ % 10 + ":" + i_6_ / 10 + i_6_ % 10 + " PST";
      }
   }

   public Class93() {
   }

   abstract boolean method1044();

   abstract void method1045();

   static final byte[] method1046(byte[] bs, int i) {
      ++anInt1245;
      if (i != 7348) {
         aFloatArray1242 = null;
      }

      int i_7_ = bs.length;
      byte[] bs_8_ = new byte[i_7_];
      Class311.method3608(bs, 0, bs_8_, 0, i_7_);
      return bs_8_;
   }

   static final Node_Sub2 method1047(int i, int id, int i_10_, int i_11_, boolean isWindowPane, boolean external) {
      ++anInt1239;
      Node_Sub2 node_sub2 = new Node_Sub2();
      node_sub2.interfaceId = id;
      node_sub2.cliped = i;
      OverlayDefinition.aHashTable3630.put((long)i_10_, node_sub2, -126);
      Node_Sub11.method2543(id, i_11_);
      IComponentDefinitions widget = Class76.getInterfaceFromHash((byte)107, i_10_);
      if (widget != null) {
         ClientScript.method2321(-1, widget);
      }

      if (Node_Sub25_Sub3.aWidget9990 != null) {
         ClientScript.method2321(-1, Node_Sub25_Sub3.aWidget9990);
         Node_Sub25_Sub3.aWidget9990 = null;
      }

      Node_Sub8.method2423();
      if (widget != null) {
         Class270_Sub1.method3300(widget, (byte)-38, !isWindowPane);
      }

      if (!isWindowPane) {
         ClientScriptsExecutor.parseIComponentScript(id);
      } else if (external) {
         ClientScriptsExecutor.parseExternalIComponentScript(id);
      }

      if (!isWindowPane && ~Class320_Sub15.WINDOWS_PANE_ID != 0) {
         Class76.method770(i_11_ + 115, 1, Class320_Sub15.WINDOWS_PANE_ID);
      }

      return node_sub2;
   }

   abstract Node_Sub5 method1048();

   static final void method1049(int[] is, int i, int[] is_12_, int i_13_, int i_14_) {
      if (i_14_ == 28627) {
         if (i_13_ < i) {
            int i_15_ = (i + i_13_) / 2;
            int i_16_ = i_13_;
            int i_17_ = is[i_15_];
            is[i_15_] = is[i];
            is[i] = i_17_;
            int i_18_ = is_12_[i_15_];
            is_12_[i_15_] = is_12_[i];
            is_12_[i] = i_18_;
            int i_19_ = i_17_ == Integer.MAX_VALUE ? 0 : 1;

            for(int i_20_ = i_13_; i_20_ < i; ++i_20_) {
               if ((i_19_ & i_20_) + i_17_ > is[i_20_]) {
                  int i_21_ = is[i_20_];
                  is[i_20_] = is[i_16_];
                  is[i_16_] = i_21_;
                  int i_22_ = is_12_[i_20_];
                  is_12_[i_20_] = is_12_[i_16_];
                  is_12_[i_16_++] = i_22_;
               }
            }

            is[i] = is[i_16_];
            is[i_16_] = i_17_;
            is_12_[i] = is_12_[i_16_];
            is_12_[i_16_] = i_18_;
            method1049(is, i_16_ - 1, is_12_, i_13_, 28627);
            method1049(is, i, is_12_, 1 + i_16_, 28627);
         }

         ++anInt1240;
      }
   }

   abstract int getLastMousePosX();

   abstract int getLastMousePosY(boolean var1);
}
