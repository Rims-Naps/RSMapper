package org.rsmapper.utilities.game.cache;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapXTEA {
   private static Map<Integer, int[]> mapKeys = new HashMap();

   public static void init() {
      try {
         loadKeys();
      } catch (Throwable var1) {
         var1.printStackTrace();
      }

   }

   public static void loadKeys() throws IOException {
      String file = "data/xteas/667.txt";

      try {
         mapKeys = new HashMap();
         BufferedReader reader = new BufferedReader(new FileReader(file));

         while(true) {
            String line;
            do {
               if ((line = reader.readLine()) == null) {
                  reader.close();
                  return;
               }

               line = line.trim();
            } while(line.length() < 1);

            int thisRegionId = Integer.parseInt(line.split("\\:")[0].trim());
            String[] stringKeys = line.split("\\:")[1].replace("[", "").replace("]", "").split("\\,");
            int[] xteas = new int[stringKeys.length];
            int count = 0;
            String[] var10 = stringKeys;
            int var9 = stringKeys.length;

            for(int var8 = 0; var8 < var9; ++var8) {
               String k = var10[var8];
               xteas[count] = Integer.parseInt(k.trim());
               ++count;
            }

            mapKeys.put(thisRegionId, xteas);
         }
      } catch (FileNotFoundException var11) {
         var11.printStackTrace();
      } catch (NumberFormatException var12) {
         var12.printStackTrace();
      } catch (IOException var13) {
         var13.printStackTrace();
      }

   }

   public static int[] getKey(int region) {
      return (int[])mapKeys.get(region);
   }

   public static Map<Integer, int[]> getMapKeys() {
      return mapKeys;
   }
}
