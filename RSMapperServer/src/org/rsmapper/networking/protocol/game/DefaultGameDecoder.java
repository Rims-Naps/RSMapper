package org.rsmapper.networking.protocol.game;

import org.rsmapper.game.player.Player;
import org.rsmapper.networking.Session;
import org.rsmapper.networking.codec.Decoder;
import org.rsmapper.networking.codec.stream.InputStream;

public final class DefaultGameDecoder extends Decoder {
   public static final byte[] PACKET_SIZES = new byte[256];
   private Player player;
   public static final int ACTION_BUTTON1_PACKET = 61;
   public static final int ACTION_BUTTON2_PACKET = 64;
   public static final int ACTION_BUTTON3_PACKET = 4;
   public static final int ACTION_BUTTON4_PACKET = 52;
   public static final int ACTION_BUTTON5_PACKET = 81;
   public static final int ACTION_BUTTON6_PACKET = 18;
   public static final int ACTION_BUTTON7_PACKET = 10;
   public static final int ACTION_BUTTON8_PACKET = 25;
   public static final int ACTION_BUTTON9_PACKET = 91;
   public static final int ACTION_BUTTON10_PACKET = 20;

   static {
      loadPacketSizes();
   }

   public static void loadPacketSizes() {
      for(int id = 0; id < 256; ++id) {
         PACKET_SIZES[id] = -4;
      }

      PACKET_SIZES[64] = 8;
      PACKET_SIZES[18] = 8;
      PACKET_SIZES[25] = 8;
      PACKET_SIZES[41] = -1;
      PACKET_SIZES[14] = 3;
      PACKET_SIZES[46] = 3;
      PACKET_SIZES[87] = 6;
      PACKET_SIZES[47] = 9;
      PACKET_SIZES[57] = 3;
      PACKET_SIZES[67] = 3;
      PACKET_SIZES[91] = 8;
      PACKET_SIZES[24] = 7;
      PACKET_SIZES[73] = 16;
      PACKET_SIZES[40] = 11;
      PACKET_SIZES[36] = -1;
      PACKET_SIZES[74] = -1;
      PACKET_SIZES[31] = 3;
      PACKET_SIZES[54] = 6;
      PACKET_SIZES[12] = 5;
      PACKET_SIZES[23] = 1;
      PACKET_SIZES[9] = 3;
      PACKET_SIZES[17] = -1;
      PACKET_SIZES[44] = -1;
      PACKET_SIZES[88] = -1;
      PACKET_SIZES[42] = 17;
      PACKET_SIZES[49] = 3;
      PACKET_SIZES[21] = 15;
      PACKET_SIZES[59] = -1;
      PACKET_SIZES[37] = -1;
      PACKET_SIZES[6] = 8;
      PACKET_SIZES[55] = 7;
      PACKET_SIZES[69] = 9;
      PACKET_SIZES[26] = 16;
      PACKET_SIZES[39] = 12;
      PACKET_SIZES[71] = 4;
      PACKET_SIZES[22] = 2;
      PACKET_SIZES[32] = -1;
      PACKET_SIZES[79] = -1;
      PACKET_SIZES[89] = 4;
      PACKET_SIZES[90] = -1;
      PACKET_SIZES[15] = 4;
      PACKET_SIZES[72] = -2;
      PACKET_SIZES[20] = 8;
      PACKET_SIZES[92] = 3;
      PACKET_SIZES[82] = 3;
      PACKET_SIZES[28] = 3;
      PACKET_SIZES[81] = 8;
      PACKET_SIZES[7] = -1;
      PACKET_SIZES[4] = 8;
      PACKET_SIZES[60] = -1;
      PACKET_SIZES[13] = 2;
      PACKET_SIZES[52] = 8;
      PACKET_SIZES[65] = 11;
      PACKET_SIZES[85] = 2;
      PACKET_SIZES[86] = 7;
      PACKET_SIZES[78] = -1;
      PACKET_SIZES[83] = 18;
      PACKET_SIZES[27] = 7;
      PACKET_SIZES[2] = 9;
      PACKET_SIZES[93] = 1;
      PACKET_SIZES[70] = -1;
      PACKET_SIZES[1] = -1;
      PACKET_SIZES[8] = -1;
      PACKET_SIZES[11] = 9;
      PACKET_SIZES[0] = 9;
      PACKET_SIZES[51] = -1;
      PACKET_SIZES[5] = 4;
      PACKET_SIZES[45] = 7;
      PACKET_SIZES[75] = 4;
      PACKET_SIZES[53] = 3;
      PACKET_SIZES[33] = 0;
      PACKET_SIZES[50] = 3;
      PACKET_SIZES[76] = 9;
      PACKET_SIZES[80] = -1;
      PACKET_SIZES[77] = 3;
      PACKET_SIZES[68] = -1;
      PACKET_SIZES[43] = 3;
      PACKET_SIZES[30] = -1;
      PACKET_SIZES[19] = 3;
      PACKET_SIZES[16] = 0;
      PACKET_SIZES[34] = 4;
      PACKET_SIZES[48] = 0;
      PACKET_SIZES[56] = 0;
      PACKET_SIZES[58] = 2;
      PACKET_SIZES[10] = 8;
      PACKET_SIZES[35] = 7;
      PACKET_SIZES[84] = 6;
      PACKET_SIZES[66] = 3;
      PACKET_SIZES[61] = 8;
      PACKET_SIZES[29] = -1;
      PACKET_SIZES[62] = 3;
      PACKET_SIZES[3] = 4;
      PACKET_SIZES[63] = 4;
      PACKET_SIZES[73] = 16;
      PACKET_SIZES[38] = -1;
      PACKET_SIZES[186] = 6;
      PACKET_SIZES[187] = 5;
   }

   public DefaultGameDecoder(Session session, Player player) {
      super(session);
      this.player = player;
   }

   public void decode(InputStream stream) {
      this.player.getSession().queuePacket(stream);
   }
}
