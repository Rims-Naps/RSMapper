package org.rsmapper.networking.protocol.login;

import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.rsmapper.game.player.Player;
import org.rsmapper.networking.Session;
import org.rsmapper.networking.codec.Encoder;
import org.rsmapper.networking.codec.stream.OutputStream;
import org.rsmapper.utilities.game.player.ReturnCode;

public final class LoginPacketsEncoder extends Encoder {
   public LoginPacketsEncoder(Session connection) {
      super(connection);
   }

   public final void sendStartUpPacket() {
      OutputStream stream = new OutputStream(1);
      stream.writeByte(0);
      this.session.write(stream);
   }

   public final void sendClientPacket(Object object) {
      OutputStream stream = new OutputStream(1);
      stream.writeByte(object instanceof ReturnCode ? ((ReturnCode)object).getOpcode() : (Integer)object);
      ChannelFuture future = this.session.write(stream);
      if (future != null) {
         future.addListener(ChannelFutureListener.CLOSE);
      } else {
         this.session.getChannel().close();
      }

   }

   public final void sendLoginDetails(Player player) {
      OutputStream stream = new OutputStream();
      stream.writePacketVarByte(player, 2);
      stream.writeByte(player.getRights());
      stream.writeByte(0);
      stream.writeByte(0);
      stream.writeByte(0);
      stream.writeByte(1);
      stream.writeByte(0);
      stream.writeShort(player.getIndex());
      stream.writeByte(1);
      stream.write24BitInteger(0);
      stream.writeByte(1);
      stream.writeString(player.getUsername());
      stream.endPacketVarByte();
      this.session.write(stream);
   }
}
