public class Class290_Sub5 extends Class290 {
   static IncommingPacket FIRST_CLICK_NPC = new IncommingPacket(9, 10);
   static int anInt8104;
   static int anInt8105;
   static int anInt8106;
   static int anInt8107 = 0;
   static int anInt8108;
   static int anInt8109;
   static int anInt8110;
   static int anInt8111;
   static int anInt8112;
   static int anInt8113;

   @Override
   final void method3411(int i) {
      ++anInt8113;
      if (i == -8668) {
         this.anAbstractToolkit3654.method1356(i + 8669, false);
      }
   }

   static final void method3434(int i, byte b) {
      ++anInt8106;
      if (Node_Sub38_Sub23.method2866(false)) {
         if (b != 27) {
            FIRST_CLICK_NPC = null;
         }

         if (~Class336_Sub2.anInt8586 != ~i) {
            Class188_Sub1_Sub1.aString9327 = "";
         }

         Class336_Sub2.anInt8586 = i;
         Class218.aClass123_2560.method1513(-28176);
         Class48.method478(5, (byte)124);
      }
   }

   static final int method3435(int i) {
      ++anInt8108;
      if (i >= -69) {
         method3435(100);
      }

      synchronized(Node_Sub36_Sub4.aClass61_10065) {
         return Node_Sub36_Sub4.aClass61_10065.method599((byte)74);
      }
   }

   @Override
   final void method3419(Interface13 interface13, int i, byte b) {
      this.anAbstractToolkit3654.method1312((byte)-21, interface13);
      ++anInt8111;
      if (b != 92) {
         method3436(null, (byte)-43);
      }

      this.anAbstractToolkit3654.method1278((byte)-12, i);
   }

   @Override
   final void method3415(boolean bool, int i, int i_0_) {
      if (bool) {
         ++anInt8109;
      }
   }

   @Override
   final boolean method3414(byte b) {
      if (b >= -45) {
         return true;
      } else {
         ++anInt8104;
         return true;
      }
   }

   static final Class150_Sub1 method3436(Buffer buffer, byte b) {
      ++anInt8105;
      int i = -105 / ((10 - b) / 61);
      Class150 class150 = Class338.method3906(buffer, -108);
      int i_1_ = buffer.readInt();
      int i_2_ = buffer.readInt();
      int i_3_ = buffer.readUnsignedShort();
      return new Class150_Sub1(
         class150.aClass379_5079,
         class150.aClass77_5087,
         class150.anInt5092,
         class150.anInt5080,
         class150.anInt5086,
         class150.anInt5081,
         class150.anInt5084,
         class150.anInt5083,
         class150.anInt5090,
         i_1_,
         i_2_,
         i_3_
      );
   }

   @Override
   final void method3422(int i, boolean bool) {
      this.anAbstractToolkit3654.method1356(1, true);
      ++anInt8110;
      if (i >= -84) {
         this.method3414((byte)45);
      }
   }

   public static void method3437(int i) {
      FIRST_CLICK_NPC = null;
      if (i != 0) {
         anInt8107 = 21;
      }
   }

   Class290_Sub5(AbstractToolkit abstracttoolkit) {
      super(abstracttoolkit);
   }

   @Override
   final void method3417(boolean bool, boolean bool_4_) {
      if (bool_4_) {
         anInt8107 = 75;
      }

      ++anInt8112;
   }
}
