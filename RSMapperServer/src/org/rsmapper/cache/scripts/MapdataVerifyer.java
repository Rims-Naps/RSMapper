package org.rsmapper.cache.scripts;

import com.alex.store.Store;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/**
 * A utility class for verifying and handling map data.
 */
public class MapdataVerifyer {
   /**
    * A HashMap storing region keys.
    * The key is the region ID, and the value is an array of integers (XTEA keys).
    */
   private static final HashMap<Integer, int[]> keys = new HashMap<>();

   /**
    * The main method to execute the MapdataVerifier.
    *
    * @param args The command line arguments.
    * @throws IOException If there is an error reading the files.
    */
   public static void main(String[] args) throws IOException {
      Store newMaps = new Store("./data/alotic/");
      loadUnpackedKeys("./data/map/containersXteas/output 667/");
      int regionId = 9515;
      Iterator<Integer> var4 = keys.keySet().iterator();

      while (var4.hasNext()) {
         int i = var4.next();
         if (!verifyMaps(newMaps, i, getKeys(i))) {
            System.out.println("Missing map: " + i);
         }
      }

      System.out.println(verifyMaps(newMaps, regionId, getKeys(regionId)));
   }

   /**
    * Verifies the existence and integrity of the map data for a given region.
    *
    * @param maps     The store containing the map data.
    * @param regionId The region ID to verify.
    * @param keys     The XTEA keys for the region.
    * @return True if the map data is valid, otherwise false.
    */
   public static boolean verifyMaps(Store maps, int regionId, int[] keys) {
      int regionX = (regionId >> 8) * 64;
      int regionY = (regionId & 255) * 64;
      int landArchiveId = maps.getIndexes()[5].getArchiveId("l" + (regionX >> 3) / 8 + "_" + (regionY >> 3) / 8);
      byte[] landContainerData = maps.getIndexes()[5].getFile(landArchiveId, 0, keys);
      return (landContainerData != null || landArchiveId == -1) && (keys != null || landContainerData != null);
   }

   /**
    * Packs old map data into a new store.
    *
    * @param oldMaps   The store containing the old map data.
    * @param newMaps   The store to save the new map data.
    * @param regionId  The region ID to pack.
    * @param oldKeys   The XTEA keys for the old region data.
    * @return True if the map data was successfully packed, otherwise false.
    */
   public static boolean packOldMap(Store oldMaps, Store newMaps, int regionId, int[] oldKeys) {
      int regionX = (regionId >> 8) * 64;
      int regionY = (regionId & 255) * 64;
      int landArchiveId = oldMaps.getIndexes()[5].getArchiveId("l" + (regionX >> 3) / 8 + "_" + (regionY >> 3) / 8);
      byte[] landContainerData = oldMaps.getIndexes()[5].getFile(landArchiveId, 0, oldKeys);
      landArchiveId = newMaps.getIndexes()[5].getArchiveId("l" + (regionX >> 3) / 8 + "_" + (regionY >> 3) / 8);
      return newMaps.getIndexes()[5].putFile(landArchiveId, 0, landContainerData);
   }

   /**
    * Retrieves the XTEA keys for a given region.
    *
    * @param regionId The region ID.
    * @return An array of integers representing the XTEA keys.
    */
   public static int[] getKeys(int regionId) {
      return keys.get(regionId);
   }

   /**
    * Loads XTEA keys from the specified path into the keys HashMap.
    *
    * @param xteaPath The path to the directory containing XTEA key files.
    */
   public static final void loadUnpackedKeys(String xteaPath) {
      try {
         File unpacked = new File(xteaPath);
         File[] xteasFiles = unpacked.listFiles();
         if (xteasFiles != null) {
            for (File region : xteasFiles) {
               String name = region.getName();
               if (!name.contains(".txt")) {
                  region.delete();
               } else {
                  int regionId = Short.parseShort(name.replace(".txt", ""));
                  if (regionId <= 0) {
                     region.delete();
                  } else {
                     try (BufferedReader in = new BufferedReader(new FileReader(region))) {
                        int[] xteas = new int[4];
                        for (int index = 0; index < 4; ++index) {
                           xteas[index] = Integer.parseInt(in.readLine());
                        }
                        keys.put(regionId, xteas);
                     }
                  }
               }
            }
         }
      } catch (IOException var12) {
         var12.printStackTrace();
      }
   }
}