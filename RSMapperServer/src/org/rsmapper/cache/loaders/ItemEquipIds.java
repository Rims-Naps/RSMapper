package org.rsmapper.cache.loaders;

import java.util.HashMap;
import org.rsmapper.utilities.misc.Utils;

public final class ItemEquipIds {
   private static final HashMap<Integer, Integer> itemsDefinitions = new HashMap();

   public static final void init() {
      int equipId = 0;

      for(int itemId = 0; itemId < Utils.getItemDefinitionsSize(); ++itemId) {
         ItemDefinitions itemDefinitions = ItemDefinitions.getItemDefinitions(itemId);
         if (itemDefinitions.getMaleWornModelId1() >= 0 || itemDefinitions.getFemaleWornModelId1() >= 0) {
            itemsDefinitions.put(itemId, equipId++);
         }
      }

   }

   public static int getEquipId(int itemId) {
      Integer equipId = (Integer)itemsDefinitions.get(itemId);
      return equipId == null ? -1 : equipId;
   }

   private ItemEquipIds() {
   }
}
