package org.rsmapper.networking.management;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.ExceptionEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelUpstreamHandler;
import org.rsmapper.networking.management.query.ServerQueryHandler;

/**
 * ServerManagementHandler is responsible for handling server management related
 * network events such as connection, disconnection, message reception, and exceptions.
 */
public class ServerManagementHandler extends SimpleChannelUpstreamHandler {

    /**
     * Handles the event when a channel gets connected.
     * @param ctx the channel handler context
     * @param e the channel state event
     */
    public void channelConnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
        System.out.println(e.getChannel() + " connected");
        // Send a welcome message to the channel
        this.sendMessage(e.getChannel(), "Welcome to the Server Management Tool.");
        // Inform the user about the 'commands' command
        this.sendMessage(e.getChannel(), "Type 'commands' to view commands.");
    }

    /**
     * Handles the event when a channel gets disconnected.
     * @param ctx the channel handler context
     * @param e the channel state event
     */
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) {
        System.out.println(e.getChannel() + " disconnected");
    }

    /**
     * Handles the event when a message is received.
     * @param ctx the channel handler context
     * @param e the message event
     */
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) {
        // Process the received message and send the response back to the channel
        this.sendMessage(e.getChannel(), ServerQueryHandler.handleQuery(e.getMessage().toString()));
    }

    /**
     * Handles any exception caught during event processing.
     * @param ctx the channel handler context
     * @param e the exception event
     */
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) {
        // Exception handling logic can be placed here
    }

    /**
     * Sends a message to the specified channel.
     * @param channel the channel to send the message to
     * @param message the message to be sent
     */
    private void sendMessage(Channel channel, String message) {
        channel.write("\t" + message + "\n");
    }
}