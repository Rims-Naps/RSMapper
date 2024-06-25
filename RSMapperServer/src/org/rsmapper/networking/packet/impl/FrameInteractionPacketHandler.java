package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;

/**
 * Handles various interaction packets related to the UI frame.
 *
 * Packet IDs this handler listens to:
 *  - 84: Activates client interface
 *  - 68: Activates client interface
 *  - 93: Toggles client interface active status
 */
@PacketInformation(
   listeners = "84,29,68,75,93"
)
public class FrameInteractionPacketHandler extends PacketHandler {
   private static final int WINDOW_SWITCH_PACKET = 93;  // Constant for window switch packet ID

   /**
    * Handles the packet based on its ID.
    *
    * @param player The player associated with the packet
    * @param packetId The ID of the packet
    * @param length The length of the packet
    * @param stream The input stream to read the packet data from
    */
   public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
      // If packet ID is 68 or 84, set client interface as active and activate player.
      if (packetId == 68 || packetId == 84) {
         player.getInterfaceManager().setClientActive(true);
         player.setActivated();
      }

      // If packet ID is 93, read a byte from the stream and set client interface active status.
      if (packetId == 93) {
         int active = stream.readByte(); // Read the active status from the stream
         player.getInterfaceManager().setClientActive(active == 1); // Set client active if stream byte is 1
      }
   }
}