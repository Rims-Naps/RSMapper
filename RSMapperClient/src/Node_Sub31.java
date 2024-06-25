public class Node_Sub31 extends Node {
   protected int anInt7363;
   protected int anInt7364;
   protected int anInt7365;
   protected int anInt7366 = Integer.MIN_VALUE;
   static int anInt7367;
   static int anInt7368;
   protected int anInt7369;
   protected int anInt7370;
   protected int anInt7371;
   static int anInt7372;
   static int anInt7373;
   protected int anInt7374;
   protected Node_Sub14 aNode_Sub14_7375;

   static final byte[] method2725(int i, byte b, byte[] bs) {
      int i_0_ = 48 / ((40 - b) / 48);
      ++anInt7373;
      byte[] bs_1_ = new byte[i];
      Class311.method3608(bs, 0, bs_1_, 0, i);
      return bs_1_;
   }

   static final void method2726(int i) {
      ++anInt7372;
      ++Class370.anInt4566;
      Class123 class123 = Class262_Sub23.method3213((byte)-123);
      OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Node_Sub18.aClass318_7151, class123.issacKeys);
      node_sub13.currentOutgoingPacket.writeByte(i);
      class123.sendPacket(127, node_sub13);
   }

   static final Class144_Sub3 method2727(Buffer buffer, byte b) {
      ++anInt7368;
      if (b != 120) {
         method2727(null, (byte)-7);
      }

      return new Class144_Sub3(
         buffer.readShort(),
         buffer.readShort(),
         buffer.readShort(),
         buffer.readShort(),
         buffer.readShort(),
         buffer.readShort(),
         buffer.readShort(),
         buffer.readShort(),
         buffer.read24BitInteger(),
         buffer.readUnsignedByte()
      );
   }

   final boolean method2728(int i, byte b, int i_2_) {
      ++anInt7367;
      if (b <= 11) {
         this.anInt7370 = -117;
      }

      if (~i <= ~this.anInt7374 && i <= this.anInt7369 && ~i_2_ <= ~this.anInt7365 && ~i_2_ >= ~this.anInt7370) {
         return true;
      } else {
         return ~this.anInt7371 >= ~i && i <= this.anInt7364 && ~this.anInt7363 >= ~i_2_ && i_2_ <= this.anInt7366;
      }
   }

   Node_Sub31(Node_Sub14 node_sub14) {
      this.anInt7365 = Integer.MAX_VALUE;
      this.anInt7364 = Integer.MIN_VALUE;
      this.anInt7370 = Integer.MIN_VALUE;
      this.anInt7363 = Integer.MAX_VALUE;
      this.anInt7369 = Integer.MIN_VALUE;
      this.anInt7374 = Integer.MAX_VALUE;
      this.anInt7371 = Integer.MAX_VALUE;
      this.aNode_Sub14_7375 = node_sub14;
   }
}
