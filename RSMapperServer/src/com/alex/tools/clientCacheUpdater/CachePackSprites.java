package com.alex.tools.clientCacheUpdater;

import com.alex.loaders.images.IndexedColorImageFile;
import com.alex.store.Store;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;

public class CachePackSprites {
   public static boolean packSprite(Store cache, int id) {
      try {
         cache.getIndexes()[8].putFile(id, 0, (new IndexedColorImageFile(new BufferedImage[]{ImageIO.read(new File("data/sprites/" + id + "_0.png"))})).encodeFile());
         System.out.println("Packed sprite: " + id);
         return true;
      } catch (IOException var3) {
         var3.printStackTrace();
         System.err.println("Failed packing sprite: " + id);
         return false;
      }
   }

   public static byte[] getImage(File file) throws IOException {
      ImageOutputStream stream = ImageIO.createImageOutputStream(file);
      byte[] data = new byte[(int)stream.length()];
      stream.read(data);
      return data;
   }

   public static void main(String[] args) throws IOException {
      Store cache = new Store("data/cache/", false);

      for(int i = 3778; i <= 3786; ++i) {
         packSprite(cache, i);
         cache.getIndexes()[8].rewriteTable();
      }

   }
}
