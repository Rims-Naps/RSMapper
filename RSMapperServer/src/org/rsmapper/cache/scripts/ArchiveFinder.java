package org.rsmapper.cache.scripts;

import com.alex.store.Index;
import com.alex.store.Store;
import java.io.IOException;
import java.util.HashMap;

public class ArchiveFinder {
   public static final HashMap<Integer, byte[]> ours = new HashMap();
   public static final HashMap<Integer, byte[]> theirs = new HashMap();

   public static void main(String[] args) throws IOException {
      Store our = new Store("./data/cache/");
      Store their = new Store("C:/Users/smoke/Desktop/cache/");
      Index ours = our.getIndexes()[23];
      Index theirs = their.getIndexes()[23];
      ours.getFile(ours.getArchiveId("main"));
      theirs.getFile(ours.getArchiveId("main"));
      System.out.println(ours.getFile(ours.getArchiveId("main")).length);
      System.out.println(theirs.getFile(theirs.getArchiveId("main")).length);
   }
}
