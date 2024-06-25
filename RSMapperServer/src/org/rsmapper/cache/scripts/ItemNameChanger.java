package org.rsmapper.cache.scripts;

import com.alex.loaders.items.ItemDefinitions;
import com.alex.store.Store;
import java.io.IOException;
import org.rsmapper.cache.Cache;
import org.rsmapper.utilities.misc.Utils;

public class ItemNameChanger {
   private static final Object[][] OBJECTS = new Object[][]{{10025, "Lucky Box"}, {6183, "Godwars Box"}};

   public static void main(String... args) throws IOException {
      Cache.init();
      Store ours = new Store("data/cache/");

      for(int i = 0; i < Utils.getItemDefinitionsSize(); ++i) {
         if (i == 20706) {
            ItemDefinitions definitions = ItemDefinitions.getItemDefinition(ours, i);
            String prevName = definitions.getName();
            definitions.setName("Magic Imbuents");
            String[] options = definitions.getInventoryOptions();
            options[0] = null;
            options[1] = null;
            System.out.println("Set the name of " + i + "[ " + prevName + "] to " + definitions.getName());
         }
      }

   }
}
