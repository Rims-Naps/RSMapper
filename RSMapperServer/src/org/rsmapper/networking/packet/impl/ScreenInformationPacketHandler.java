package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;

@PacketInformation(
   listeners = "87"
)
public class ScreenInformationPacketHandler extends PacketHandler {
   public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
      int displayMode = stream.readUnsignedByte();
      player.setScreenWidth(stream.readUnsignedShort());
      player.setScreenHeight(stream.readUnsignedShort());
      stream.readUnsignedByte();
      if (player.hasStarted() && !player.hasFinished() && displayMode != player.getDisplayMode() && player.getInterfaceManager().containsInterface(742)) {
         player.setDisplayMode(displayMode);
         player.getInterfaceManager().removeAll();
         player.getInterfaceManager().sendInterfaces();
         player.getInterfaceManager().sendInterface(742);
      }
   }
}
