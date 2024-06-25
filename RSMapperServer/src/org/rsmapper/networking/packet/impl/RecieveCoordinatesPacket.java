package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.ForceMovement;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTask;
import org.rsmapper.game.tasks.WorldTasksManager;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;

@PacketInformation(
   listeners = "188"
)
public class RecieveCoordinatesPacket extends PacketHandler {
   public void handle(final Player player, Integer packetId, Integer length, InputStream stream) {
      if (packetId == 188) {
         boolean fullCoords = stream.readByte() == 1;
         int x = false;
         int y = false;
         int x;
         int y;
         if (fullCoords) {
            x = stream.readInt();
            y = stream.readInt();
         } else {
            x = stream.readUnsignedByte();
            y = stream.readUnsignedByte();
         }

         int plane = stream.readByte();
         if (fullCoords) {
            player.setNextWorldTile(new WorldTile(x, y, plane));
         } else if (player.getAttributes().get("moving") == null || !(Boolean)player.getAttributes().get("moving")) {
            player.setNextWorldTile(new WorldTile(player.getX() + (x == 255 ? -1 : x), player.getY() + (y == 255 ? -1 : y), plane));
            final WorldTile startTile = new WorldTile(player.getX(), player.getY(), player.getPlane());
            final WorldTile destTile = new WorldTile(player.getX() + (x == 255 ? -1 : x), player.getY() + (y == 255 ? -1 : y), player.getPlane());
            player.getAttributes().put("moving", true);
            player.setNextFaceWorldTile(destTile);
            WorldTasksManager.schedule(new WorldTask() {
               int ticks;

               public void run() {
                  switch(this.ticks) {
                  case 0:
                     player.setNextForceMovement(new ForceMovement(startTile, 0, destTile, 1, 0));
                     break;
                  case 1:
                     player.getAttributes().put("moving", false);
                     this.stop();
                  }

                  ++this.ticks;
               }
            }, 0, 0);
         }

      }
   }
}
