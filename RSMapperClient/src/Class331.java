public class Class331 {
   static boolean aBoolean4129 = false;
   static int anInt4130 = -1;
   static int anInt4131;
   static int anInt4132;
   private int[] anIntArray4133;
   private int[] anIntArray4134;
   private int[] anIntArray4135;
   static int anInt4136;
   static int anInt4137;
   private int[] anIntArray4138;
   private int[] anIntArray4139;
   static float aFloat4140;
   private int[] anIntArray4141;
   private int[] anIntArray4142;

   final void method3840(int i, int i_0_) {
      ++anInt4131;
      int[][] is = new int[this.anIntArray4139.length << 1][4];
      int i_1_ = 0;
      if (i_0_ != 2) {
         this.anIntArray4134 = null;
      }

      while(this.anIntArray4139.length > i_1_) {
         is[i_1_ * 2][0] = this.anIntArray4139[i_1_];
         is[2 * i_1_][1] = this.anIntArray4142[i_1_];
         is[2 * i_1_][2] = this.anIntArray4138[i_1_];
         is[i_1_ * 2][3] = this.anIntArray4134[i_1_];
         is[2 * i_1_ + 1][0] = this.anIntArray4133[i_1_];
         is[i_1_ * 2 - -1][1] = this.anIntArray4135[i_1_];
         is[2 * i_1_ + 1][2] = this.anIntArray4141[i_1_];
         is[1 + 2 * i_1_][3] = this.anIntArray4134[i_1_];
         ++i_1_;
      }

      Class277_Sub1.anIntArrayArrayArray8042[i] = is;
   }

   static final Class129 method3841(int i, int i_2_) {
      ++anInt4132;
      if (i != 20568) {
         aBoolean4129 = false;
      }

      Class129[] class129s = Node_Sub15_Sub13.method2586(-11746);

      for(int i_3_ = 0; ~class129s.length < ~i_3_; ++i_3_) {
         Class129 class129 = class129s[i_3_];
         if (~class129.anInt1662 == ~i_2_) {
            return class129;
         }
      }

      return null;
   }

   static final void method3842(int i, int i_4_, int i_5_, int i_6_, int i_7_, byte b) {
      ++anInt4136;
      if (b != -54) {
         aBoolean4129 = true;
      }

      if (~Class262_Sub4.anInt7722 >= ~i_4_ && ~za_Sub2.anInt10513 <= ~i && i_7_ >= Class384.anInt4906 && ~Node_Sub25_Sub1.anInt9936 <= ~i_6_) {
         Class296.method3477(i_7_, i_5_, i_4_, i_6_, i, 106);
      } else {
         Class125.method1527(0, i_4_, i, i_5_, i_7_, i_6_);
      }
   }

   static final void sendShiftTeleport(boolean bool, int plane, int y, int x) {
      if (plane != Class295.myPlayer.plane) {
         OutgoingPacket telep = new OutgoingPacket(188, 6);
         OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(telep, Class218.aClass123_2566.issacKeys);
         node_sub13.currentOutgoingPacket.writeByte(1);
         node_sub13.currentOutgoingPacket.writeInt(x);
         node_sub13.currentOutgoingPacket.writeInt(y);
         node_sub13.currentOutgoingPacket.writeByte(plane);
         Class218.aClass123_2566.sendPacket(127, node_sub13);
      } else {
         int localX = new WorldTile(x, y, plane, false).getLocalX();
         int localY = new WorldTile(x, y, plane, false).getLocalY();
         Class333.baseX = localX << 3;
         Node_Sub21.baseY = localY << 3;
         Class50.basePlane = plane;
         Node_Sub23_Sub1.DECODE_MASKS_PLAYERS_INDEXES_LIST[Node_Sub9_Sub4.DECODE_MASKS_PLAYERS_COUNT++] = Class295.myPlayer.index;
         int xOffset = localX - (Class295.myPlayer.x >> 9);
         int yOffset = localY - (Class295.myPlayer.y >> 9);
         int i_19_ = -Node_Sub53.gameSceneBaseX + (Class295.myPlayer.scenePositionXQueue[0] - -Node_Sub53.gameSceneBaseX - -xOffset & 16383);
         int i_20_ = -Class320_Sub4.gameSceneBaseY + (16383 & yOffset + Class295.myPlayer.scenePositionYQueue[0] + Class320_Sub4.gameSceneBaseY);
         Class295.myPlayer.processMovement(i_20_, i_19_, -9380, Class73.movementTypes[Class295.myPlayer.index]);
         Class295.myPlayer.plane = (byte)plane;
         if (Class238.tileHasBridgeFlag(i_20_, i_19_, -108)) {
            Class295.myPlayer.aByte5931 = (byte)(Class295.myPlayer.aByte5931 + 1);
         }

         CacheNode_Sub20_Sub1.myPlayerPlane = plane;
      }

      ++anInt4137;
      String string = "tele " + plane + "," + (x >> 6) + "," + (y >> 6) + "," + (x & 63) + "," + (y & 63);
      Class126.processClientCommand(90, true, bool, string);
   }

   Class331(Buffer buffer) {
      int i = buffer.readSmart();
      this.anIntArray4142 = new int[i];
      this.anIntArray4141 = new int[i];
      this.anIntArray4133 = new int[i];
      this.anIntArray4139 = new int[i];
      this.anIntArray4135 = new int[i];
      this.anIntArray4138 = new int[i];
      this.anIntArray4134 = new int[i];

      for(int i_10_ = 0; i > i_10_; ++i_10_) {
         this.anIntArray4139[i_10_] = buffer.readUnsignedShort() + -5120;
         this.anIntArray4138[i_10_] = -5120 + buffer.readUnsignedShort();
         this.anIntArray4142[i_10_] = buffer.readShort();
         this.anIntArray4133[i_10_] = -5120 + buffer.readUnsignedShort();
         this.anIntArray4141[i_10_] = buffer.readUnsignedShort() - 5120;
         this.anIntArray4135[i_10_] = buffer.readShort();
         this.anIntArray4134[i_10_] = buffer.readShort();
      }
   }
}
