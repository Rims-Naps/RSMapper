package org.rsmapper.networking.management.query.impl;

import org.rsmapper.game.World;
import org.rsmapper.networking.management.query.ServerQuery;

public class UpdateQuery extends ServerQuery {
   public String[] getQueryListeners() {
      return new String[]{"update"};
   }

   public String getDescription() {
      return "Shuts down the server after 60 seconds.";
   }

   public String onRequest() {
      World.safeShutdown(false, 60);
      return "Sent successfully... Server shutting down in 60.";
   }
}
