package org.rsmapper.engine.process.impl;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rsmapper.Constants;
import org.rsmapper.engine.process.TimedProcess;
import org.rsmapper.game.World;
import org.rsmapper.game.player.Player;
import org.rsmapper.networking.Session;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketSystem;
import org.rsmapper.networking.protocol.game.DefaultGameDecoder;
import org.rsmapper.utilities.misc.Utils;

public class PacketQueueProcessor implements TimedProcess {
   private Object lock = new Object();

   public TimedProcess.Timer getTimer() {
      return new TimedProcess.Timer(1, TimeUnit.MILLISECONDS);
   }

   public void execute() {
      synchronized(this.lock) {
         try {
            Iterator var3 = World.getPlayers().iterator();

            while(var3.hasNext()) {
               Player player = (Player)var3.next();
               if (player != null && player.hasStarted()) {
                  player.getSession().getQueuedPackets().removeIf((e) -> {
                     this.processStream(player, player.getSession(), e);
                     return true;
                  });
               }
            }
         } catch (Exception var4) {
            var4.printStackTrace();
         }

      }
   }

   public void processStream(Player player, Session session, InputStream stream) {
      int length;
      int startOffset;
      for(; stream.getRemaining() > 0 && session.getChannel().isConnected() && !player.hasFinished(); stream.setOffset(startOffset + length)) {
         int packetId = stream.readUnsignedByte();
         if (packetId >= DefaultGameDecoder.PACKET_SIZES.length && Constants.DEBUG) {
            System.out.println("PacketId " + packetId + " has fake packet id.");
            break;
         }

         length = DefaultGameDecoder.PACKET_SIZES[packetId];
         if (length == -1) {
            length = stream.readUnsignedByte();
         } else if (length == -2) {
            length = stream.readUnsignedShort();
         } else if (length == -3) {
            length = stream.readInt();
         } else if (length == -4) {
            length = stream.getRemaining();
            if (Constants.DEBUG) {
               System.out.println("Invalid size for PacketId " + packetId + ". Size guessed to be " + length);
            }
         }

         if (length > stream.getRemaining()) {
            length = stream.getRemaining();
            if (Constants.DEBUG) {
               System.out.println("PacketId " + packetId + " has fake size. - expected size " + length);
            }
         }

         startOffset = stream.getOffset();
         PacketHandler handler = PacketSystem.getHandler(packetId);
         player.setPacketsDecoderPing(Utils.currentTimeMillis());
         if (handler != null) {
            try {
               switch(packetId) {
               case 68:
               case 84:
                  player.getAttributes().put("last_real_packet_time", System.currentTimeMillis());
               default:
                  handler.handle(player, packetId, length, stream);
               }
            } catch (Exception var9) {
               var9.printStackTrace();
            }
         } else {
            boolean var10000 = Constants.DEBUG;
         }
      }

   }
}
