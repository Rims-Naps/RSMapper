abstract class Animable_Sub1 extends Animable {
   static int anInt9095;
   static int anInt9096;
   static int anInt9097;
   static int anInt9098;
   static int anInt9099;
   static int anInt9100;
   static int anInt9101 = -1;
   protected short aShort9102;
   static int anInt9103;
   static int anInt9104;
   static boolean aBoolean9105;

   static final void method824(byte b) {
      ++Client.anInt5471;
      if (b <= 21) {
         aBoolean9105 = false;
      }

      ++anInt9104;
      OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class239.aClass318_2929, Class218.aClass123_2566.issacKeys);
      node_sub13.currentOutgoingPacket.writeInt(Class175.anInt2097);
      Class218.aClass123_2566.sendPacket(127, node_sub13);
   }

   @Override
   final boolean method815(byte b, GraphicsToolkit graphicstoolkit) {
      ++anInt9100;
      if (b != 59) {
         this.aShort9102 = -95;
      }

      return Class313.method3649(true, this.y >> Class36.INT_9, this.aByte5931, this.x >> Class36.INT_9);
   }

   static final void method825(byte b) {
      ++anInt9099;
      if (b != -68) {
         method825((byte)32);
      }

      if (Class235_Sub1.anInterface16Array8978 != null) {
         Interface16[] interface16s = Class235_Sub1.anInterface16Array8978;

         for(int i = 0; ~i > ~interface16s.length; ++i) {
            Interface16 interface16 = interface16s[i];
            interface16.method62(1939);
         }
      }
   }

   @Override
   final boolean method806(int i) {
      ++anInt9095;
      return i != 0
         ? false
         : Class139.aBooleanArrayArray1730[Node_Sub9_Sub1.anInt9656 + (this.x >> Class36.INT_9) - Class216.anInt2551][Node_Sub9_Sub1.anInt9656
            + -EntityNode_Sub7.anInt6013
            + (this.y >> Class36.INT_9)];
   }

   Animable_Sub1(int i, int i_8_, int i_9_, int i_10_, int i_11_, int i_12_) {
      this.plane = (byte)i_10_;
      this.anInt5937 = i_8_;
      this.y = i_9_;
      this.aShort9102 = (short)i_12_;
      this.aByte5931 = (byte)i_11_;
      this.x = i;
   }

   @Override
   final int method819(Node_Sub29[] node_sub29s, int i) {
      ++anInt9103;
      if (i != 1) {
         this.aShort9102 = -111;
      }

      return this.method808(i ^ -23023, node_sub29s, this.y >> Class36.INT_9, this.x >> Class36.INT_9);
   }
}
