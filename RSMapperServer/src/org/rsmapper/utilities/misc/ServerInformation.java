package org.rsmapper.utilities.misc;

import java.text.DecimalFormat;
import org.RsMapperServer;

public class ServerInformation {
   private final int availableProcessors = Runtime.getRuntime().availableProcessors();
   private static final ServerInformation INSTANCE = new ServerInformation();

   public String readable(long bytes, boolean si) {
      int unit = si ? 1000 : 1024;
      if (bytes < (long)unit) {
         return bytes + " B";
      } else {
         int exp = (int)(Math.log((double)bytes) / Math.log((double)unit));
         String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp - 1) + (si ? "" : "i");
         return String.format("%.1f %sB", (double)bytes / Math.pow((double)unit, (double)exp), pre);
      }
   }

   public int getAvailableProcessors() {
      return this.availableProcessors;
   }

   public String getGameUptime() {
      long milliseconds = System.currentTimeMillis() - RsMapperServer.STARTUP_TIME;
      int seconds = (int)(milliseconds / 1000L) % 60;
      int minutes = (int)(milliseconds / 60000L % 60L);
      int hours = (int)(milliseconds / 3600000L % 24L);
      long days = milliseconds / 86400000L;
      DecimalFormat nft = new DecimalFormat("#00.###");
      nft.setDecimalSeparatorAlwaysShown(false);
      return nft.format(days) + ":" + nft.format((long)hours) + ":" + nft.format((long)minutes) + ":" + nft.format((long)seconds);
   }

   public static ServerInformation get() {
      return INSTANCE;
   }
}
