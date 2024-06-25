package org.rsmapper.cache;

import com.alex.store.Store;
import com.alex.util.whirlpool.Whirlpool;
import java.io.IOException;
import org.rsmapper.networking.codec.stream.OutputStream;

/**
 * The {@code Cache} class provides operations for initializing and managing cache data.
 * It includes methods to initialize the cache store, generate ukeys file, and a main method to demonstrate usage.
 */
public final class Cache {

   /**
    * The {@code STORE} variable holds the instance of the {@code Store} class.
    */
   public static Store STORE;

   /**
    * Private constructor to prevent instantiation of the {@code Cache} class.
    */
   private Cache() {
   }

   /**
    * Initializes the {@code STORE} variable by loading cache data from the specified directory.
    *
    * @throws IOException if there is an issue loading the cache data.
    */
   public static void init() throws IOException {
      STORE = new Store("data/cache/");
   }

   /**
    * The main method to demonstrate the initialization of the cache and output the sums of bytes in index 255 archive 255.
    *
    * @param args command-line arguments (not used).
    * @throws IOException if there is an issue during the initialization.
    */
   public static void main(String... args) throws IOException {
      init();
      StringBuilder bldr = new StringBuilder();
      int total = 0;
      byte[] var6;
      int var5 = (var6 = STORE.generateIndex255Archive255()).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         byte b = var6[var4];
         bldr.append(b + ",");
         System.out.println(total += b);
      }

      System.out.println(bldr);
   }

   /**
    * Generates the ukeys file representing unique keys for indexes in the cache store.
    *
    * @return a byte array containing the generated ukeys file data.
    */
   public static final byte[] generateUkeysFile() {
      OutputStream stream = new OutputStream();
      stream.writeByte(STORE.getIndexes().length);

      for(int index = 0; index < STORE.getIndexes().length; ++index) {
         if (STORE.getIndexes()[index] == null) {
            stream.writeInt(0);
            stream.writeInt(0);
            stream.writeBytes(new byte[64]);
         } else {
            stream.writeInt(STORE.getIndexes()[index].getCRC());
            stream.writeInt(STORE.getIndexes()[index].getTable().getRevision());
            stream.writeBytes(STORE.getIndexes()[index].getWhirlpool());
         }
      }

      byte[] archive = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(archive, 0, archive.length);
      OutputStream hashStream = new OutputStream(65);
      hashStream.writeByte(0);
      hashStream.writeBytes(Whirlpool.getHash(archive, 0, archive.length));
      byte[] hash = new byte[hashStream.getOffset()];
      hashStream.setOffset(0);
      hashStream.getBytes(hash, 0, hash.length);
      stream.writeBytes(hash);
      archive = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(archive, 0, archive.length);
      return archive;
   }
}