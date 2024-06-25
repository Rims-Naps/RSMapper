package com.alex.tools.clientCacheUpdater;

import com.alex.store.Store;
import com.alex.utils.Utils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class CheckMap {
   public static void main(String[] args) throws IOException {
      File[] files = (new File("data/map/containersXteas/output 667")).listFiles();
      File[] var5 = files;
      int var4 = files.length;

      for(int var3 = 0; var3 < var4; ++var3) {
         File f = var5[var3];
         BufferedReader reader = new BufferedReader(new FileReader(f));
         String regionId = f.toString().substring(f.toString().lastIndexOf("\\") + 1, f.toString().indexOf("."));
         String output = regionId + " : [";
         int count = 0;

         String line;
         while((line = reader.readLine()) != null) {
            line = line.trim();
            if (line.length() >= 1) {
               output = output + line + (count == 3 ? "]" : ", ");
               ++count;
            }
         }

         System.out.println(output);
      }

   }

   public static boolean passArchive(int regionId, Store store1, Store store2, String nameHash, int i, int[] keys1, int[] keys2) {
      if (keys2 != null) {
         System.out.println(keys2);
      }

      int archiveId = store1.getIndexes()[i].getArchiveId(nameHash);
      if (archiveId == -1) {
         return false;
      } else {
         int oldArchiveId = store2.getIndexes()[i].getArchiveId(nameHash);
         if (oldArchiveId == -1) {
            oldArchiveId = store2.getIndexes()[i].getLastArchiveId() + 1;
         }

         byte[] data = store1.getIndexes()[i].getFile(archiveId, 0, keys1);
         if (data == null) {
            return false;
         } else {
            try {
               boolean pass = store2.getIndexes()[i].putFile(oldArchiveId, 0, 2, data, keys2, false, false, Utils.getNameHash(nameHash), -1);
               if (!pass) {
                  return false;
               } else {
                  int[] keys = writeKeys(regionId);
                  return store2.getIndexes()[i].encryptArchive(oldArchiveId, keys2, keys, false, false);
               }
            } catch (Error var12) {
               return false;
            } catch (Exception var13) {
               var13.printStackTrace();
               return false;
            }
         }
      }
   }

   public static int[] generateKeys() {
      int[] keys = new int[4];

      for(int index = 0; index < keys.length; ++index) {
         keys[index] = (new Random()).nextInt();
      }

      return keys;
   }

   public static int[] writeKeys(int regionId) throws IOException {
      BufferedWriter writer = new BufferedWriter(new FileWriter("cache667_protected/keys/" + regionId + ".txt"));
      int[] keys = generateKeys();

      for(int index = 0; index < keys.length; ++index) {
         writer.write("" + keys[index]);
         writer.newLine();
         writer.flush();
      }

      System.out.println("Region: " + regionId + ", " + Arrays.toString(keys));
      return keys;
   }
}
