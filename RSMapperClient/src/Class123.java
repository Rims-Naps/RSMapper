import java.io.IOException;

public class Class123 {
   protected Class365 aClass365_1557;
   private Class312 aClass312_1558 = new Class312();
   static int anInt1559;
   static int anInt1560;
   static int anInt1561;
   static IncommingPacket aClass192_1562 = new IncommingPacket(57, -2);
   static int anInt1563;
   static Class129 aClass129_1564 = new Class129("WIP", 2);
   protected Class241 aClass241_1565;
   private Buffer aBuffer1566;
   private int anInt1567 = 0;
   static int anInt1568;
   static int anInt1569;
   protected Packet aPacket1570;
   protected IsaacCipher issacKeys;
   protected int anInt1572;
   protected IncommingPacket aClass192_1573;
   protected IncommingPacket aClass192_1574;
   protected int anInt1575;
   protected IncommingPacket incomming_packet;
   protected int anInt1577;
   protected int anInt1578;
   protected int anInt1579;
   protected boolean aBoolean1580;
   protected int anInt1581;
   protected IncommingPacket aClass192_1582;
   private int anInt1583;
   protected boolean aBoolean1584;

   public static void method1509(int i) {
      aClass192_1562 = null;
      int i_0_ = 36 % ((-23 - i) / 47);
      aClass129_1564 = null;
   }

   final void method1510(int i) {
      if (Class174.clientCycle % 50 == 0) {
         this.anInt1572 = this.anInt1583;
         this.anInt1577 = this.anInt1575;
         this.anInt1583 = 0;
         this.anInt1575 = 0;
      }

      if (i > -62) {
         this.anInt1572 = -99;
      }

      ++anInt1560;
   }

   final void method1511(byte b) {
      ++anInt1563;
      this.aClass312_1558.method3614(-601);
      this.anInt1567 = 0;
      if (b <= 35) {
         this.anInt1583 = -42;
      }
   }

   final void method1512(byte b) throws IOException {
      ++anInt1561;
      if (this.aClass365_1557 != null && this.anInt1567 > 0) {
         this.aBuffer1566.offset = 0;

         while(true) {
            OutgoingPacketBuffer node_sub13 = (OutgoingPacketBuffer)this.aClass312_1558.method3613(65280);
            if (node_sub13 == null || ~node_sub13.anInt7114 < ~(this.aBuffer1566.buffer.length + -this.aBuffer1566.offset)) {
               this.aClass365_1557.method4067(this.aBuffer1566.buffer, this.aBuffer1566.offset, (byte)-29, 0);
               this.anInt1579 = 0;
               this.anInt1583 += this.aBuffer1566.offset;
               break;
            }

            this.aBuffer1566.writeBytes(node_sub13.anInt7114, node_sub13.currentOutgoingPacket.buffer, 0);
            this.anInt1567 -= node_sub13.anInt7114;
            node_sub13.method2160((byte)36);
            node_sub13.currentOutgoingPacket.method2202(b ^ 42);
            node_sub13.method2547(false);
         }
      }

      if (b != -89) {
         this.method1513(23);
      }
   }

   final void method1513(int i) {
      ++anInt1569;
      if (this.aClass365_1557 != null) {
         this.aClass365_1557.method4062(-2);
         this.aClass365_1557 = null;
      }

      if (i != -28176) {
         this.method1511((byte)11);
      }
   }

   final void sendPacket(int i, OutgoingPacketBuffer node_sub13) {
      ++anInt1559;
      this.aClass312_1558.method3625((byte)-54, node_sub13);
      node_sub13.anInt7114 = node_sub13.currentOutgoingPacket.offset;
      node_sub13.currentOutgoingPacket.offset = 0;
      this.anInt1567 += node_sub13.anInt7114;
      if (i <= 125) {
         this.method1510(57);
      }
   }

   public Class123() {
      this.aBuffer1566 = new Buffer(1350);
      this.aPacket1570 = new Packet(15000);
      this.incomming_packet = null;
      this.anInt1581 = 0;
      this.anInt1579 = 0;
      this.aBoolean1580 = false;
      this.aBoolean1584 = true;
      this.anInt1578 = 0;
   }
}
