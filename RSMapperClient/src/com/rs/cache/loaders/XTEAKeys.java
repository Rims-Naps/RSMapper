package com.rs.cache.loaders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class XTEAKeys {
   private HashMap<Integer, int[]> keys;

   public void loadKeys() {
      String file = "data/xteas/667.txt";

      try {
         this.keys = new HashMap<>();
         BufferedReader reader = new BufferedReader(new FileReader(file));

         String line;
         while((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.length() >= 1) {
               int thisRegionId = Integer.parseInt(line.split("\\:")[0].trim());
               String[] stringKeys = line.split("\\:")[1].replace("[", "").replace("]", "").split("\\,");
               int[] xteas = new int[stringKeys.length];
               int count = 0;

               for(String k : stringKeys) {
                  xteas[count] = Integer.parseInt(k.trim());
                  ++count;
               }

               this.keys.put(thisRegionId, xteas);
            }
         }

         reader.close();
      } catch (FileNotFoundException var12) {
         var12.printStackTrace();
      } catch (NumberFormatException var13) {
         var13.printStackTrace();
      } catch (IOException var14) {
         var14.printStackTrace();
      }
   }

   public int[] getKeys(int regionId) {
      return this.keys.get(regionId);
   }
}
