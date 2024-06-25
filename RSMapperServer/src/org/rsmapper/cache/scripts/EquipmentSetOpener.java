package org.rsmapper.cache.scripts;

import java.io.IOException;
import org.rsmapper.cache.Cache;
import org.rsmapper.cache.loaders.NPCDefinitions;
import org.rsmapper.utilities.misc.Utils;

public class EquipmentSetOpener {
   public static void main(String... args) throws IOException {
      Cache.init();
      int biggestSize = 0;
      int id = 0;

      for(int i = 0; i < Utils.getNPCDefinitionsSize(); ++i) {
         NPCDefinitions definitions = NPCDefinitions.getNPCDefinitions(2745);
         int size = definitions.size;
         if (size > biggestSize) {
            biggestSize = size;
            id = i;
         }
      }

      System.out.println(id + ", " + biggestSize);
   }
}
