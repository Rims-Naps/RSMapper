package org.rsmapper.utilities.misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HumanWorld {

   /**
    * Fetches news data in RSS format from Google's news service.
    *
    * @return A single line of the RSS data as a String, or null if an error occurs.
    */
   private static String getNewsData() {
      try {
         String line = null;

         try {
            URL url = new URL("http://news.google.com/news?pz=1&cf=all&ned=us&hl=en&topic=w&output=rss");
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.addRequestProperty("User-Agent", "Mozilla/4.76");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            line = in.readLine();
            in.close();
         } catch (IOException var4) {
            var4.printStackTrace();
         }

         return line;
      } catch (Exception var5) {
         var5.printStackTrace();
         return null;
      }
   }

   /**
    * Extracts news headlines from the RSS data fetched by getNewsData.
    *
    * @return An array of the extracted news headlines, or null if the RSS data couldn't be fetched.
    */
   public static String[] getNewsHeadlines() {
      String p = getNewsData();
      String[] data = null;
      if (p == null) {
         return null;
      } else {
         data = p.split(">");

         for(int i = 0; i < data.length; ++i) {
            data[i] = data[i].replaceAll("<", "");
            data[i] = data[i].replaceAll(">", "");
            data[i] = data[i].replaceAll("/title", "");
            data[i] = data[i].replaceAll("&apos;", "'");
         }

         String[] headlines = new String[]{data[28], data[42], data[56], data[70], data[84], data[98], data[112], data[126], data[140], data[154]};
         return headlines;
      }
   }
}