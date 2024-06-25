package org.rsmapper.networking.protocol;

import org.rsmapper.game.player.Player;
import org.rsmapper.networking.Session;
import org.rsmapper.networking.codec.Decoder;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.utilities.misc.Utils;
import org.rsmapper.utilities.security.IsaacKeyPair;

/**
 * Decoder for handling incoming client packets.
 */
public final class ClientPacketsDecoder extends Decoder {

   /**
    * Constructs a new ClientPacketsDecoder with the specified session.
    *
    * @param connection the session associated with this decoder
    */
   public ClientPacketsDecoder(Session connection) {
      super(connection);
   }

   /**
    * Decodes an incoming packet from the client.
    *
    * @param stream the input stream containing the packet data
    */
   public final void decode(InputStream stream) {
      this.session.setDecoder(-1); // Disable this decoder
      int packetId = stream.readUnsignedByte(); // Read the packet ID
      switch(packetId) {
         case 14:
            this.decodeLogin(stream); // Handle login packet
            break;
         case 15:
            this.decodeGrab(stream); // Handle grab packet
            break;
         case 16:
            this.decodeBotLogin(stream); // Handle bot login packet
            break;
         default:
            this.session.getChannel().close(); // Close session on unknown packet
            System.out.println("Received packetId " + packetId + " so closed session");
      }
   }

   /**
    * Decodes a bot login packet.
    *
    * @param stream the input stream containing the packet data
    */
   public void decodeBotLogin(InputStream stream) {
      this.session.setEncoder(1); // Set encoder
      int[] isaacKeys = new int[4];

      // Read Isaac encryption keys
      for(int i = 0; i < isaacKeys.length; ++i) {
         isaacKeys[i] = stream.readInt();
      }

      if (stream.readLong() != 0L) {
         this.session.getLoginPackets().sendClientPacket(10); // Send client packet
      }

      // Read login details
      String password = stream.readString();
      String username = Utils.formatPlayerNameForProtocol(stream.readString());
      int displayMode = stream.readUnsignedByte();
      int screenWidth = stream.readUnsignedShort();
      int screenHeight = stream.readUnsignedShort();

      // Initialize player and send login details
      Player player = new Player(password);
      player.init(this.session, username, displayMode, screenWidth, screenHeight, new IsaacKeyPair(isaacKeys), "mac");
      this.session.getLoginPackets().sendLoginDetails(player);
      this.session.setDecoder(3, player); // Set decoder for the player
      this.session.setEncoder(2, player); // Set encoder for the player
      player.setPassword(password);
      player.start(System.currentTimeMillis()); // Start player session
   }

   /**
    * Decodes a standard login packet.
    *
    * @param stream the input stream containing the packet data
    */
   private final void decodeLogin(InputStream stream) {
      if (stream.getRemaining() != 0) {
         // Close session if there is remaining data
         this.session.getChannel().close();
         System.err.println("Remaining from decoding login wasnt 0 so closed session");
      } else {
         this.session.setDecoder(2); // Set logical decoder
         this.session.setEncoder(1); // Set logical encoder
         this.session.getLoginPackets().sendStartUpPacket(); // Send startup packet
      }
   }

   /**
    * Decodes a grab packet.
    *
    * @param stream the input stream containing the packet data
    */
   private final void decodeGrab(InputStream stream) {
      if (stream.getRemaining() != 8) {
         System.err.println("Invalid remaining amount: " + stream.getRemaining());
         this.session.getChannel().close(); // Close session on invalid data
      } else {
         this.session.setEncoder(0); // Set encoder
         int build = stream.readInt();
         boolean readsub = true;

         // Check build and sub-build versions
         if (readsub) {
            int sub = stream.readInt();
            if (build != 666 || sub != 3) {
               this.session.setDecoder(-1); // Disable decoder
               this.session.getGrabPackets().sendOutdatedClientPacket(); // Send outdated client packet
               return;
            }
         }

         this.session.setDecoder(1); // Set logical decoder
         this.session.getGrabPackets().sendStartUpPacket(); // Send startup packet
      }
   }
}