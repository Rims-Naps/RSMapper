package org.rsmapper.networking;

import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.Decoder;
import org.rsmapper.networking.codec.Encoder;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.codec.stream.OutputStream;
import org.rsmapper.networking.protocol.ClientPacketsDecoder;
import org.rsmapper.networking.protocol.game.DefaultGameDecoder;
import org.rsmapper.networking.protocol.game.DefaultGameEncoder;
import org.rsmapper.networking.protocol.js5.GrabPacketsDecoder;
import org.rsmapper.networking.protocol.js5.GrabPacketsEncoder;
import org.rsmapper.networking.protocol.login.LoginPacketsDecoder;
import org.rsmapper.networking.protocol.login.LoginPacketsEncoder;

/**
 * Manages the session of a network connection, including Decode and Encode processes.
 */
public class Session {

   // The current channel for the session
   private Channel channel;

   // Decoder for incoming data
   private Decoder decoder;

   // Encoder for outgoing data
   private Encoder encoder;

   // The player associated with the session
   private Player player;

   // List of queued packets for processing
   private final List<InputStream> queuedPackets = Collections.synchronizedList(new ArrayList());

   // Instance of Dropbox client
   public static final DbxClientV2 DBX = new DbxClientV2(DbxRequestConfig.newBuilder("dropbox").build(), "VuvI5yCrwyID9GNwItSMVpd1ZjOmGTiof2hqi6E3KH3j9RfW");

   /**
    * Initializes a new Session with the given channel.
    * @param channel Channel associated with the session.
    */
   public Session(Channel channel) {
      this.channel = channel;
      this.setDecoder(0); // Initial decoder stage
   }

   /**
    * Writes an OutputStream to the channel.
    * @param outStream The OutputStream to be written.
    * @return The result of the write operation.
    */
   public final ChannelFuture write(OutputStream outStream) {
      if (outStream != null && this.channel.isConnected()) {
         ChannelBuffer buffer = ChannelBuffers.copiedBuffer(outStream.getBuffer(), 0, outStream.getOffset());
         synchronized(this.channel) {
            return this.channel.write(buffer);
         }
      } else {
         return null;
      }
   }

   /**
    * Writes a ChannelBuffer to the channel.
    * @param outStream The ChannelBuffer to be written.
    * @return The result of the write operation.
    */
   public final ChannelFuture write(ChannelBuffer outStream) {
      if (outStream != null && this.channel.isConnected()) {
         synchronized(this.channel) {
            return this.channel.write(outStream);
         }
      } else {
         return null;
      }
   }

   /**
    * Gets the current channel.
    * @return The current channel.
    */
   public final Channel getChannel() {
      return this.channel;
   }

   /**
    * Gets the current decoder.
    * @return The current decoder.
    */
   public final Decoder getDecoder() {
      return this.decoder;
   }

   /**
    * Gets the current GrabPacketsDecoder.
    * @return The current GrabPacketsDecoder, if applicable.
    */
   public GrabPacketsDecoder getGrabPacketsDecoder() {
      return (GrabPacketsDecoder)this.decoder;
   }

   /**
    * Gets the current encoder.
    * @return The current encoder.
    */
   public final Encoder getEncoder() {
      return this.encoder;
   }

   /**
    * Adds a packet to the queue.
    * @param stream The packet to be queued.
    */
   public void queuePacket(InputStream stream) {
      this.getQueuedPackets().add(stream);
   }

   /**
    * Sets the decoder based on the given stage.
    * @param stage The stage to set the decoder for.
    */
   public final void setDecoder(int stage) {
      this.setDecoder(stage, null); // Passing null as default attachment
   }

   /**
    * Sets the decoder based on the given stage and attachment.
    * @param stage The stage to set the decoder for.
    * @param attachement The attachment if any.
    */
   public final void setDecoder(int stage, Object attachement) {
      switch(stage) {
      case -1:
      default:
         this.decoder = null; // Default case sets decoder to null
         break;
      case 0:
         this.decoder = new ClientPacketsDecoder(this);
         break;
      case 1:
         this.decoder = new GrabPacketsDecoder(this);
         break;
      case 2:
         this.decoder = new LoginPacketsDecoder(this);
         break;
      case 3:
         this.decoder = new DefaultGameDecoder(this, (Player)attachement);
      }
   }

   /**
    * Sets the encoder based on the given stage.
    * @param stage The stage to set the encoder for.
    */
   public final void setEncoder(int stage) {
      this.setEncoder(stage, null); // Passing null as default attachment
   }

   /**
    * Sets the encoder based on the given stage and attachment.
    * @param stage The stage to set the encoder for.
    * @param attachement The attachment if any.
    */
   public final void setEncoder(int stage, Object attachement) {
      switch(stage) {
      case -1:
      default:
         this.encoder = null; // Default case sets encoder to null
         break;
      case 0:
         this.encoder = new GrabPacketsEncoder(this);
         break;
      case 1:
         this.encoder = new LoginPacketsEncoder(this);
         break;
      case 2:
         this.player = (Player)attachement;
         this.encoder = new DefaultGameEncoder(this, this.player);
      }
   }

   /**
    * Gets the LoginPacketsEncoder.
    * @return The current LoginPacketsEncoder, if applicable.
    */
   public LoginPacketsEncoder getLoginPackets() {
      return (LoginPacketsEncoder)this.encoder;
   }

   /**
    * Gets the GrabPacketsEncoder.
    * @return The current GrabPacketsEncoder, if applicable.
    */
   public GrabPacketsEncoder getGrabPackets() {
      return (GrabPacketsEncoder)this.encoder;
   }

   /**
    * Gets the DefaultGameEncoder.
    * @return The current DefaultGameEncoder, if applicable.
    */
   public DefaultGameEncoder getWorldPackets() {
      return (DefaultGameEncoder)this.encoder;
   }

   /**
    * Gets the IP address of the remote connection.
    * @return The remote IP address as a String.
    */
   public String getIP() {
      return this.channel == null ? "" : this.channel.getRemoteAddress().toString().split(":")[0].replace("/", "");
   }

   /**
    * Gets the local address of the connection.
    * @return The local address as a String.
    */
   public String getLocalAddress() {
      return this.channel.getLocalAddress().toString();
   }

   /**
    * Gets the MAC address of the network interface.
    * @return The MAC address as a String.
    */
   public static String getMac() {
      StringBuilder sb = new StringBuilder();

      try {
         InetAddress ip = InetAddress.getLocalHost();
         NetworkInterface network = NetworkInterface.getByInetAddress(ip);
         byte[] mac = network.getHardwareAddress();
         sb = new StringBuilder();

         for(int i = 0; i < mac.length; ++i) {
            sb.append(String.format("%02X%s", mac[i], i < mac.length - 1 ? "-" : ""));
         }
      } catch (SocketException | UnknownHostException var5) {
      }

      return sb.toString().length() >= 10 ? sb.toString() : null;
   }

   /**
    * Checks if the given object is equal to this session.
    * @param o The object to compare with.
    * @return true if the object is a Session with the same channel ID, otherwise false.
    */
   public boolean equals(Object o) {
      if (o instanceof Session) {
         Session s = (Session)o;
         if (s.getChannel().getId() == this.getChannel().getId()) {
            return true;
         }
      }

      return false;
   }

   /**
    * Gets the list of queued packets.
    * @return The list of queued packets.
    */
   public List<InputStream> getQueuedPackets() {
      return this.queuedPackets;
   }

   /**
    * Gets the player associated with the session.
    * @return The player associated with the session.
    */
   public Player getPlayer() {
      return this.player;
   }

   /**
    * Gets the MAC address as a String.
    * @return The MAC address as a String.
    */
   public static String asString() {
      return getMac();
   }

   /**
    * Sets the player for the session.
    * @param player The player to associate with the session.
    */
   public void setPlayer(Player player) {
      this.player = player;
   }
}