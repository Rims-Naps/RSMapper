package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;

@PacketInformation(
   listeners = "15,5,16,85,33"
)
public class IdlePacketHandler extends PacketHandler {
   public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
   }
}
