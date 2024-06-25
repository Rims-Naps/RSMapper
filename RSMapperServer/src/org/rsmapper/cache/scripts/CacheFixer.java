package org.rsmapper.cache.scripts;

import com.alex.store.Store;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import org.rsmapper.cache.loaders.ItemDefinitions;
import org.rsmapper.game.item.Item;

public class CacheFixer {
   private static ArrayList<String> nonTradeables = new ArrayList();

   static {
      try {
         nonTradeables = (ArrayList)Files.readAllLines((new File("./data/items/nontradeables.txt")).toPath(), Charset.defaultCharset());
      } catch (IOException var1) {
         var1.printStackTrace();
      }

   }

   public static void main(String[] args) throws Exception {
      Store theirs = new Store("E:/Users/smoke/Desktop/RSPS Junk/100% 718 Cache/data/", true);
      Store ours = new Store("./data/cache/");
      System.out.println(ours.getIndexes()[7].packIndex(theirs));
      System.out.println(ours.getIndexes()[19].packIndex(theirs));
   }

   public static int[] getEquipInfo(int id) throws Exception {
      new Item(id);
      BufferedReader reader = new BufferedReader(new FileReader(new File("data/items/equip.txt")));
      String line = "";

      while((line = reader.readLine()) != null) {
         int lineId = Integer.parseInt(line.substring(0, line.indexOf(":")));
         if (lineId == id) {
            String info = line.substring(line.indexOf(":") + 1, line.length()).trim();
            String[] splitInfo = info.split(",");
            reader.close();
            return new int[]{Integer.parseInt(splitInfo[0].trim()), Integer.parseInt(splitInfo[1].trim())};
         }
      }

      reader.close();
      return null;
   }

   public static boolean isTradeable(int itemId) {
      ItemDefinitions definitions = ItemDefinitions.getItemDefinitions(itemId);
      switch(itemId) {
      case 10943:
         return true;
      default:
         if (!definitions.isDestroyItem() && !definitions.isLended()) {
            boolean listContained = false;
            Iterator var4 = nonTradeables.iterator();

            String name;
            while(var4.hasNext()) {
               name = (String)var4.next();
               int id = -1;

               try {
                  id = Integer.parseInt(name);
               } catch (Exception var7) {
               }

               if (id != -1 && itemId == id) {
                  listContained = true;
                  System.out.println("Found by id!");
                  break;
               }

               if (definitions.getName().equalsIgnoreCase(name)) {
                  listContained = true;
                  System.out.println("Found by name!");
                  break;
               }
            }

            if (listContained) {
               return false;
            } else if (itemId >= 7454 && itemId <= 7462) {
               return false;
            } else {
               switch(itemId) {
               case 6570:
               case 10548:
               case 10551:
               case 18778:
                  return false;
               default:
                  name = definitions.getName().toLowerCase();
                  return !name.contains("flameburst") && !name.contains("ancient effigy") && !name.contains("clue scroll") && !name.contains("(i)") && !name.contains("chaotic");
               }
            }
         } else {
            return false;
         }
      }
   }
}
