package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.WorldTile;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.route.RouteFinder;
import org.rsmapper.game.route.strategy.FixedTileStrategy;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;
import org.rsmapper.utilities.misc.Utils;

@PacketInformation(
   listeners = "12,83"
)
public class WalkingPacketHandler extends PacketHandler {
   public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
      if (player.hasStarted() && player.clientHasLoadedMapRegion() && !player.isDead() && player.getControllerManager().canWalk()) {
         long currentTime = Utils.currentTimeMillis();
         if (player.getLockDelay() <= currentTime) {
            if (player.isFrozen()) {
               player.getPackets().sendGameMessage("A magical force prevents you from moving.");
            } else {
               int x = stream.readUnsignedShortLE128();
               int y = stream.readUnsignedShortLE128();
               boolean forceRun = stream.readUnsignedByte() == 1;
               player.stopAll();
               if (forceRun) {
                  player.setRun(forceRun);
               }

               int steps = RouteFinder.findRoute(0, player.getX(), player.getY(), player.getPlane(), player.getSize(), new FixedTileStrategy(x, y), true);
               int[] bufferX = RouteFinder.getLastPathBufferX();
               int[] bufferY = RouteFinder.getLastPathBufferY();
               int last = -1;

               for(int i = steps - 1; i >= 0 && player.addWalkSteps(bufferX[i], bufferY[i], 25, true); last = i--) {
               }

               if (last != -1) {
                  WorldTile tile = new WorldTile(bufferX[last], bufferY[last], player.getPlane());
                  player.getPackets().sendMinimapFlag(tile.getLocalX(player.getLastLoadedMapRegionTile(), player.getMapSize()), tile.getLocalY(player.getLastLoadedMapRegionTile(), player.getMapSize()));
               } else {
                  player.getPackets().sendResetMinimapFlag();
               }

            }
         }
      }
   }
}
