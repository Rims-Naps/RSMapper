package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;

/**
 * A packet handler for receiving and processing variable parameter packets (varp packets).
 */
@PacketInformation(
   listeners = "187"
)
public class ReceiveVarpPacket extends PacketHandler {

   /**
    * Handles the incoming varp packet.
    *
    * @param player   the player sending the packet
    * @param packetId the id of the packet
    * @param length   the length of the packet
    * @param stream   the input stream to read the packet data from
    */
   public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
      if (packetId == 187) {
         // Read the first varp id and its value from the input stream
         int varpId1 = stream.readShort();
         int varpValue1 = stream.readInt();

         // Read the second varp id and its value from the input stream
         int varpId2 = stream.readShort();
         int varpValue2 = stream.readInt();

         // Print the varp id and value pairs for debugging purposes
         System.out.println("VARP1[" + varpId1 + "] = " + varpValue1);
         System.out.println("VARP2[" + varpId2 + "] = " + varpValue2);
      }
   }
}