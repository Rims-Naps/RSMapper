package org.rsmapper.networking.protocol.login;

import org.RsMapperServer;
import org.rsmapper.Constants;
import org.rsmapper.cache.Cache;
import org.rsmapper.engine.service.login.LoginService;
import org.rsmapper.engine.service.login.LoginServiceTask;
import org.rsmapper.game.World;
import org.rsmapper.networking.Session;
import org.rsmapper.networking.codec.Decoder;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.utilities.game.player.ReturnCode;
import org.rsmapper.utilities.misc.Utils;
import org.rsmapper.utilities.security.IsaacKeyPair;

public final class LoginPacketsDecoder extends Decoder {
   public LoginPacketsDecoder(Session session) {
      super(session);
   }

   public void decode(InputStream stream) {
      this.session.setDecoder(-1);
      if (RsMapperServer.STARTUP_TIME == -1L && World.updateIn < 60L) {
         this.session.getLoginPackets().sendClientPacket(ReturnCode.SERVER_IS_UPDATING);
      } else {
         int packetId = stream.readUnsignedByte();
         if (packetId == 16) {
            this.decodeWorldLogin(stream);
         } else if (packetId != 186) {
            if (Constants.DEBUG) {
               System.out.println("PacketId " + packetId);
            }

            this.session.getChannel().close();
            System.out.println("Didnt receive login packet of 16[" + packetId + "] so closed session");
         }

      }
   }

   public void decodeWorldLogin(InputStream stream) {
      if (World.exiting_start != 0L && World.updateIn < 60L) {
         this.session.getLoginPackets().sendClientPacket(ReturnCode.SERVER_IS_UPDATING);
      } else {
         int packetSize = stream.readUnsignedShort();
         if (packetSize != stream.getRemaining()) {
            System.err.println("Packet size is whacko! " + packetSize);
            this.session.getChannel().close();
         } else if (stream.readInt() == 666 && stream.readInt() == 3) {
            stream.readUnsignedByte();
            if (stream.readUnsignedByte() != 10) {
               this.session.getLoginPackets().sendClientPacket(ReturnCode.INVALID_SESSION_ID);
            } else {
               int[] isaacKeys = new int[4];

               for(int i = 0; i < isaacKeys.length; ++i) {
                  isaacKeys[i] = stream.readInt();
               }

               if (stream.readLong() != 0L) {
                  this.session.getLoginPackets().sendClientPacket(ReturnCode.INVALID_SESSION_ID);
               } else {
                  String password = stream.readString();
                  Utils.longToString(stream.readLong());
                  stream.readLong();
                  stream.decodeXTEA(isaacKeys, stream.getOffset(), stream.getLength());
                  String username = Utils.formatPlayerNameForProtocol(stream.readString());
                  String macAddress = stream.readString();
                  stream.readUnsignedByte();
                  int displayMode = stream.readUnsignedByte();
                  int screenWidth = stream.readUnsignedShort();
                  int screenHeight = stream.readUnsignedShort();
                  stream.readUnsignedByte();
                  stream.skip(24);
                  stream.readString();
                  stream.readInt();
                  stream.skip(stream.readUnsignedByte());
                  if (stream.readUnsignedByte() != 5) {
                     this.session.getLoginPackets().sendClientPacket(ReturnCode.INVALID_SESSION_ID);
                  } else {
                     stream.readUnsignedByte();
                     stream.readUnsignedByte();
                     stream.readUnsignedByte();
                     stream.readUnsignedByte();
                     stream.readUnsignedByte();
                     stream.readUnsignedByte();
                     stream.readUnsignedByte();
                     stream.readUnsignedByte();
                     stream.readUnsignedShort();
                     stream.readUnsignedByte();
                     stream.read24BitInt();
                     stream.readUnsignedShort();
                     stream.readUnsignedByte();
                     stream.readUnsignedByte();
                     stream.readUnsignedByte();
                     stream.readJagString();
                     stream.readJagString();
                     stream.readJagString();
                     stream.readJagString();
                     stream.readUnsignedByte();
                     stream.readUnsignedShort();
                     stream.readInt();
                     stream.readLong();
                     boolean hasAdditionalInformation = stream.readUnsignedByte() == 1;
                     if (hasAdditionalInformation) {
                        stream.readString();
                     }

                     stream.readUnsignedByte();
                     stream.readUnsignedByte();
                     stream.readUnsignedByte();
                     int x = stream.readInt();
                     int y = stream.readInt();
                     int plane = stream.readByte();

                     for(int index = 0; index < Cache.STORE.getIndexes().length; ++index) {
                        int crc = Cache.STORE.getIndexes()[index] == null ? 0 : Cache.STORE.getIndexes()[index].getCRC();
                        int receivedCRC = stream.readInt();
                        if (crc != receivedCRC && index < 32) {
                           this.session.getLoginPackets().sendClientPacket(ReturnCode.HAS_BEEN_UPDATED);
                           return;
                        }
                     }

                     LoginService.getSingleton().submit(new LoginServiceTask(username, password, macAddress, this.session, new IsaacKeyPair(isaacKeys), new int[]{displayMode, screenWidth, screenHeight}, x, y, plane));
                  }
               }
            }
         } else {
            this.session.getLoginPackets().sendClientPacket(ReturnCode.HAS_BEEN_UPDATED);
         }
      }
   }
}
