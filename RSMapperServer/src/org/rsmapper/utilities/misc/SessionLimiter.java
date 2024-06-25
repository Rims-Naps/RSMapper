package org.rsmapper.utilities.misc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.jboss.netty.channel.Channel;

public class SessionLimiter {
   private static final Map<String, Integer> CURRENT_CONNECTIONS = Collections.synchronizedMap(new HashMap());

   public static Integer getConnections(Channel channel) {
      Integer count = (Integer)CURRENT_CONNECTIONS.get(Utils.getIP(channel));
      return count == null ? 0 : count;
   }

   public static void addConnection(Channel channel) {
      addIp(Utils.getIP(channel));
   }

   public static void removeConnection(Channel channel) {
      CURRENT_CONNECTIONS.remove(Utils.getIP(channel));
   }

   private static void addIp(String ip) {
      Integer count = (Integer)CURRENT_CONNECTIONS.get(ip);
      if (count == null) {
         CURRENT_CONNECTIONS.put(ip, 1);
      } else {
         CURRENT_CONNECTIONS.replace(ip, count + 1);
      }

   }
}
