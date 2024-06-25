package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;

@PacketInformation(
   listeners = "56"
)
public class CloseInterfacePacketHandler extends PacketHandler {
   public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
      if (!player.isRunning()) {
         player.run();
      } else {
         player.stopAll();
      }
   }
}
