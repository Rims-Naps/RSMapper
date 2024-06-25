package org.rsmapper.cache.scripts;

import com.alex.loaders.items.ItemDefinitions;
import com.alex.store.Store;
import java.io.IOException;
import org.rsmapper.cache.Cache;
import org.rsmapper.utilities.misc.Utils;

public class ItemDefinitionsUpdater {
   public static void main(String[] args) throws IOException {
      Cache.init();
      Store ours = new Store("./data/cache/");

      for(int i = 0; i < Utils.getItemDefinitionsSize(); ++i) {
         ItemDefinitions.getItemDefinition(ours, i);
         if (i % 500 == 0) {
            System.out.println(i + " is finished.");
         }
      }

   }
}
