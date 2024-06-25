package org.rsmapper.networking.management;

import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.frame.DelimiterBasedFrameDecoder;
import org.jboss.netty.handler.codec.frame.Delimiters;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

/**
 * Factory class for creating the ChannelPipeline
 * for server management.
 */
public class ServerManagementFactory implements ChannelPipelineFactory {

   /**
    * Creates and returns a new ChannelPipeline for server management.
    *
    * @return ChannelPipeline The pipeline with the necessary handlers added.
    * @throws Exception If there's an issue creating the pipeline.
    */
   public ChannelPipeline getPipeline() throws Exception {
      // Create a default pipeline implementation.
      ChannelPipeline pipeline = Channels.pipeline();

      // Add frame decoder to handle frames based on delimiters.
      pipeline.addLast("framer", new DelimiterBasedFrameDecoder(8192, Delimiters.lineDelimiter()));

      // Add decoder to convert ByteBuf to String.
      pipeline.addLast("decoder", new StringDecoder());

      // Add encoder to convert String to ByteBuf.
      pipeline.addLast("encoder", new StringEncoder());

      // Add custom handler for server management logic.
      pipeline.addLast("handler", new ServerManagementHandler());

      return pipeline;
   }
}