package org.rsmapper.networking.management;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

public class ServerManagement {

   // ServerBootstrap instance to manage server configurations and operations
   private ServerBootstrap bootstrap = new ServerBootstrap(
       new NioServerSocketChannelFactory(
           Executors.newCachedThreadPool(), // Boss thread pool
           Executors.newCachedThreadPool(), // Worker thread pool
           1 // Number of I/O threads
       )
   );

   // Singleton instance of ServerManagement
   private static final ServerManagement INSTANCE = new ServerManagement();

   // Port number for the server to listen on
   private static final int PORT = 43595;

   // Private constructor to prevent instantiation from outside
   private ServerManagement() {
   }

   /**
    * Configures and starts the server to listen on the specified port.
    * Sets various options for server performance tuning.
    */
   public void listen() {
      this.bootstrap.setPipelineFactory(new ServerManagementFactory()); // Setting the pipeline factory
      this.bootstrap.setOption("reuseAddress", true); // Enables address reuse
      this.bootstrap.setOption("child.tcpNoDelay", true); // Disables Nagle's algorithm for better latency
      this.bootstrap.setOption("child.connectTimeoutMillis", 999999999999999999L); // Connection timeout setting
      this.bootstrap.setOption("child.TcpAckFrequency", true); // Enables TCP ACK frequency optimization
      this.bootstrap.bind(new InetSocketAddress(PORT)); // Binds the server to the specified port
      System.out.println("Listening on port 43596"); // Logging the listening port
   }

   /**
    * Returns the singleton instance of the ServerManagement class.
    *
    * @return the singleton instance of ServerManagement
    */
   public static ServerManagement getInstance() {
      return INSTANCE;
   }
}