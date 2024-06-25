package org.rsmapper.networking.management.query.impl;

import org.rsmapper.game.World;
import org.rsmapper.networking.management.query.ServerQuery;
import org.rsmapper.utilities.misc.ServerInformation;
import org.rsmapper.utilities.misc.Utils;

public class InformationQuery extends ServerQuery {
   public String[] getQueryListeners() {
      return new String[]{"serverinfo"};
   }

   public String getDescription() {
      return "Prints out information about the server";
   }

   public String onRequest() {
      StringBuilder bldr = new StringBuilder();
      Runtime runtime = Runtime.getRuntime();
      long inUse = Runtime.getRuntime().totalMemory();
      bldr.append("Uptime: " + ServerInformation.get().getGameUptime() + ". Ticks: " + World.getGameWorker().getDelay() + "ms\n");
      bldr.append("\tCores: " + runtime.availableProcessors() + ". Memory Usage: " + ServerInformation.get().readable(inUse, true) + ". Free Memory: " + Utils.format(runtime.freeMemory()) + ". Maximum Memory: " + Utils.format(runtime.maxMemory()) + ". Total Available: " + Utils.format(runtime.totalMemory()));
      return bldr.toString();
   }
}
