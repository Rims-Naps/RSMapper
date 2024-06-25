package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.handlers.ButtonHandler;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;

@PacketInformation(
   listeners = "61,64,4,52,81,18,10,25,91,20"
)
public class ButtonPacketHandler extends PacketHandler {
   public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
      ButtonHandler.handleButtons(player, stream, packetId);
   }
}
