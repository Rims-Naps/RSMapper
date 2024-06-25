package org.rsmapper.cache.scripts;

import com.alex.store.Store;

public class IndexPacker {
   private static final Store matrix718 = new Store("C:/Users/smoke/Desktop/Runescape Private Servers/projects/Who Cares 667/ScapeSoft 667/data/cache/", true);
   private static final Store ours = new Store("C:/Users/smoke/ScapeSoft_Cachev3.0/runescape/", false);
   private static final int INDEX = 8;

   public static void main(String[] args) {
      System.out.println(ours.getIndexes()[8].packIndex(matrix718));
   }
}
