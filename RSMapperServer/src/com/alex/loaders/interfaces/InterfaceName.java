package com.alex.loaders.interfaces;

import com.alex.store.Store;
import com.alex.utils.Utils;
import java.io.IOException;

public class InterfaceName {
   public static final char[] VALID_CHARS = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

   public static void printAllCombinations4Letters() {
   }

   public static void main(String[] args) throws IOException {
      Store rscache = new Store("cache697/", false);
      System.out.println(rscache.getIndexes()[3].getTable().isNamed());
      System.out.println(rscache.getIndexes()[3].getArchiveId("chat"));
      System.out.println(Utils.getNameHash("price checker"));
   }
}
