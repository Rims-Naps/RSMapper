package org.rsmapper.game.item;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.rsmapper.cache.Cache;
import org.rsmapper.cache.loaders.ItemDefinitions;
import org.rsmapper.game.player.Equipment;
import org.rsmapper.game.player.Player;

public class ItemConstants {
   private static List<Integer> unexchangeables;
   private static final String[] forceTradeable = new String[0];
   private static final String[] RARE_NAMES = new String[]{"hilt", "shard", "whip", "visage", "vesta", "statius", "darkmeyer", "blood necklace shard", "morrigan", "bandos", "armadyl helmet", "armadyl chestplate", "armadyl chainskirt", "virtus", "pernix", "torva", "virtus", "sigil", "steadfast", "ragefire", "glaiven", "elixir", "third age"};

   public static int getDegradeItemWhenWear(int id) {
      return id != 13958 && id != 13961 && id != 13964 && id != 13967 && id != 13970 && id != 13973 && id != 13908 && id != 13911 && id != 13914 && id != 13917 && id != 13920 && id != 13923 && id != 13941 && id != 13944 && id != 13947 && id != 13950 && id != 13958 && id != 13938 && id != 13926 && id != 13929 && id != 13932 && id != 13935 ? -1 : id + 2;
   }

   public static int getItemDefaultCharges(int id) {
      if (id != 13910 && id != 13913 && id != 13916 && id != 13919 && id != 13922 && id != 13925 && id != 13928 && id != 13931 && id != 13934 && id != 13937 && id != 13940 && id != 13943 && id != 13946 && id != 13949 && id != 13952) {
         if (id != 13960 && id != 13963 && id != 13966 && id != 13969 && id != 13972 && id != 13975) {
            return id != 13860 && id != 13863 && id != 13866 && id != 13869 && id != 13872 && id != 13875 && id != 13878 && id != 13886 && id != 13889 && id != 13892 && id != 13895 && id != 13898 && id != 13901 && id != 13904 && id != 13907 && id != 13960 ? -1 : 6000;
         } else {
            return 2000;
         }
      } else {
         return 1500;
      }
   }

   public static int getItemDegrade(int id) {
      return id != 20137 && id != 20141 && id != 20145 && id != 20149 && id != 20153 && id != 20157 && id != 20161 && id != 20165 && id != 20169 && id != 20173 ? -1 : id + 1;
   }

   public static int getDegradeItemWhenCombating(int id) {
      return id != 20135 && id != 20139 && id != 20143 && id != 20147 && id != 20151 && id != 20155 && id != 20159 && id != 20163 && id != 20167 && id != 20171 && id != 13858 && id != 13861 && id != 13864 && id != 13867 && id != 13870 && id != 13873 && id != 13876 && id != 13884 && id != 13887 && id != 13890 && id != 13893 && id != 13896 && id != 13905 && id != 13902 && id != 13899 ? -1 : id + 2;
   }

   public static boolean itemDegradesWhileHit(int id) {
      return id == 2550;
   }

   public static boolean itemDegradesWhileWearing(int id) {
      String name = ItemDefinitions.getItemDefinitions(id).getName().toLowerCase();
      return name.contains("c. dragon") || name.contains("corrupt dragon") || name.contains("vesta's") || name.contains("statius'") || name.contains("morrigan's") || name.contains("zuriel's");
   }

   public static boolean itemDegradesWhileCombating(int id) {
      return false;
   }

   public static boolean isDestroy(Item item) {
      return item.getDefinitions().isDestroyItem() || item.getDefinitions().isLended();
   }

   public static boolean isLendable(Item item) {
      return !item.getDefinitions().isLended() && item.getDefinitions().getLendId() > -1;
   }

   public static void main(String[] args) throws IOException {
      Cache.init();
      Item item = new Item(16933);
      System.out.println(item.getName() + ", " + item.getDefinitions().getEquipSlot());
      System.out.println(canExchange(item.getId()));
      System.out.println(canExchange(item, (Player)null));
   }

   public static boolean canExchange(Item item, Player player) {
      if (item.getDefinitions().isExchangeable()) {
         return true;
      } else if (!item.getDefinitions().isExchangeable()) {
         return false;
      } else if (!item.getDefinitions().isWearItem()) {
         return false;
      } else if (!item.getDefinitions().isTradeable()) {
         return false;
      } else {
         return Equipment.canWear(item, player);
      }
   }

   public static boolean isTradeable(Object object) {
      int itemId = true;
      int itemId;
      if (object instanceof Item) {
         itemId = ((Item)object).getId();
      } else {
         if (!(object instanceof Integer)) {
            throw new IllegalStateException("Invalid parameters! Only Item or Integer can be specified");
         }

         itemId = (Integer)object;
      }

      ItemDefinitions definitions = ItemDefinitions.getItemDefinitions(itemId);
      String[] var6;
      int var5 = (var6 = forceTradeable).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         String n = var6[var4];
         if (definitions.getName().toLowerCase().contains(n.toLowerCase())) {
            return true;
         }
      }

      return definitions.isTradeable();
   }

   public static List<Integer> getUnexchangeables() {
      if (unexchangeables == null) {
         unexchangeables = new ArrayList();

         try {
            List<String> text = (ArrayList)Files.readAllLines((new File("./data/exchange/full_exchange_list.txt")).toPath(), Charset.defaultCharset());
            Iterator var2 = text.iterator();

            while(var2.hasNext()) {
               String line = (String)var2.next();
               if (!line.startsWith("//")) {
                  String[] split = line.split(": ");
                  unexchangeables.add(Integer.parseInt(split[1]));
               }
            }
         } catch (IOException var4) {
            var4.printStackTrace();
         }
      }

      return unexchangeables;
   }

   public static boolean shouldExchange(int itemId) {
      return getUnexchangeables().contains(itemId);
   }

   public static boolean canExchange(int itemId) {
      if (!isTradeable(itemId)) {
         return false;
      } else {
         ItemDefinitions definitions = ItemDefinitions.getItemDefinitions(itemId);
         if (definitions.isNoted()) {
            return false;
         } else {
            return definitions.isExchangeable();
         }
      }
   }

   public static boolean isRare(Item item) {
      String name = item.getName().toLowerCase();
      String[] var5;
      int var4 = (var5 = RARE_NAMES).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         String rare = var5[var3];
         if (name.contains(rare.toLowerCase())) {
            return true;
         }
      }

      return false;
   }
}
