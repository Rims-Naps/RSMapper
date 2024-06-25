package com.alex.tools.clientCacheUpdater;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public final class OriginalXteas {
   public static final HashMap<Integer, int[]> mapContainersXteas = new HashMap();

   public static final int[] getXteas(int regionId) {
      return (int[])mapContainersXteas.get(regionId);
   }

   public static void init() {
      loadUnpackedXteas();
   }

   public static final void delete() {
   }

   public static final void loadUnpackedXteas() {
      try {
         File unpacked = new File("cache667_protected/keys");
         File[] xteasFiles = unpacked.listFiles();
         File[] var5 = xteasFiles;
         int var4 = xteasFiles.length;

         for(int var3 = 0; var3 < var4; ++var3) {
            File region = var5[var3];
            String name = region.getName();
            if (!name.contains(".txt")) {
               region.delete();
            } else {
               int regionId = Short.parseShort(name.replace(".txt", ""));
               if (regionId <= 0) {
                  region.delete();
               } else {
                  BufferedReader in = new BufferedReader(new FileReader(region));
                  int[] xteas = new int[4];

                  for(int index = 0; index < 4; ++index) {
                     xteas[index] = Integer.parseInt(in.readLine());
                  }

                  mapContainersXteas.put(Integer.valueOf(regionId), xteas);
                  in.close();
               }
            }
         }
      } catch (IOException var11) {
         var11.printStackTrace();
      }

   }

   private OriginalXteas() {
   }
}
