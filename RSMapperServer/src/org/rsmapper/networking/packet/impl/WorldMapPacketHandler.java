package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;

@PacketInformation(
   listeners = "89"
)
public class WorldMapPacketHandler extends PacketHandler {
   public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
      int coordinateHash = stream.readInt();
      int x = coordinateHash >> 14;
      int y = coordinateHash & 16383;
      int plane = coordinateHash >> 28;
      Integer hash = (Integer)player.getTemporaryAttributes().get("worldHash");
      if (hash != null && coordinateHash == hash) {
         player.getTemporaryAttributes().remove("worldHash");
         player.getHintIconsManager().addHintIcon(x, y, plane, 20, 0, 2, -1, true);
         player.getVarsManager().sendVar(1159, coordinateHash);
      } else {
         player.getTemporaryAttributes().put("worldHash", coordinateHash);
      }

   }
}
