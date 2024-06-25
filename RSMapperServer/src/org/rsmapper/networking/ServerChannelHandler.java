package org.rsmapper.networking;

import java.net.InetSocketAddress;
import org.RsMapperServer;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.ChannelException;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.jboss.netty.channel.group.ChannelGroup;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.rsmapper.engine.CoresManager;
import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.management.ServerManagement;
import org.rsmapper.utilities.misc.SessionLimiter;
import org.rsmapper.utilities.misc.Utils;

public final class ServerChannelHandler extends SimpleChannelUpstreamHandler {
   public static ServerBootstrap bootstrap;
   public static ChannelGroup channels;

   public static final void init() {
      new ServerChannelHandler();
   }

   private ServerChannelHandler() {
      bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(CoresManager.serverBossChannelExecutor, CoresManager.serverWorkerChannelExecutor, CoresManager.serverWorkersCount));
      bootstrap.getPipeline().addLast("handler", this);
      bootstrap.setOption("reuseAddress", true);
      bootstrap.setOption("child.tcpNoDelay", true);
      bootstrap.setOption("child.connectTimeoutMillis", 999999999999999999L);
      bootstrap.setOption("child.TcpAckFrequency", true);

      try {
         bootstrap.bind(new InetSocketAddress(43597));
      } catch (ChannelException var2) {
         RsMapperServer.print("<font style=\"color:red\">" + var2.getMessage() + " ...Another instance of the server may already be running! There can only be one.</font>");
      }

      ServerManagement.getInstance().listen();
   }

   public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
      if (SessionLimiter.getConnections(e.getChannel()) >= 10) {
         System.err.println("Several connections from " + Utils.getIP(e.getChannel()) + "! Stopping them...");
         e.getChannel().close();
      } else {
         ctx.setAttachment(new Session(e.getChannel()));
      }
   }

   public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
      Object sessionObject = ctx.getAttachment();
      if (sessionObject != null && sessionObject instanceof Session) {
         Session session = (Session)sessionObject;
         Player player = session.getPlayer();
         if (player != null) {
            player.finish();
         }
      }

   }

   public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
      try {
         if (!(e.getMessage() instanceof ChannelBuffer)) {
            return;
         }

         Object sessionObject = ctx.getAttachment();
         if (sessionObject != null && sessionObject instanceof Session) {
            Session session = (Session)sessionObject;
            if (session.getDecoder() == null) {
               return;
            }

            ChannelBuffer buf = (ChannelBuffer)e.getMessage();
            buf.markReaderIndex();
            int avail = buf.readableBytes();
            if (avail < 1 || avail > 7500) {
               System.out.println("Avail is: " + avail);
               return;
            }

            byte[] buffer = new byte[buf.readableBytes()];
            buf.readBytes(buffer);

            try {
               session.getDecoder().decode(new InputStream(buffer));
            } catch (Throwable var9) {
               var9.printStackTrace();
            }
         }
      } catch (Throwable var10) {
         e.getChannel().close();
      }

   }

   public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
   }

   public void channelOpen(ChannelHandlerContext ctx, ChannelStateEvent e) {
      channels.add(e.getChannel());
      SessionLimiter.addConnection(e.getChannel());
   }

   public void channelClosed(ChannelHandlerContext ctx, ChannelStateEvent e) {
      channels.remove(e.getChannel());
      SessionLimiter.removeConnection(e.getChannel());
   }

   public static final void shutdown() {
      bootstrap.releaseExternalResources();
   }
}
