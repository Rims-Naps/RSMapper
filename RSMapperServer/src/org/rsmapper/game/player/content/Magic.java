package org.rsmapper.game.player.content;

import com.dropbox.core.v2.files.Metadata;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import org.rsmapper.Constants;
import org.rsmapper.cache.loaders.ItemDefinitions;
import org.rsmapper.game.Animation;
import org.rsmapper.game.Graphics;
import org.rsmapper.game.World;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.item.ItemConstants;
import org.rsmapper.game.player.InterfaceManager;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTask;
import org.rsmapper.game.tasks.WorldTasksManager;
import org.rsmapper.networking.Session;
import org.rsmapper.utilities.misc.Utils;

public class Magic {
   public static final int MAGIC_TELEPORT = 0;
   public static final int ITEM_TELEPORT = 1;
   public static final int OBJECT_TELEPORT = 2;
   private static final int AIR_RUNE = 556;
   private static final int WATER_RUNE = 555;
   private static final int EARTH_RUNE = 557;
   private static final int FIRE_RUNE = 554;
   private static final int MIND_RUNE = 558;
   private static final int NATURE_RUNE = 561;
   private static final int CHAOS_RUNE = 562;
   private static final int DEATH_RUNE = 560;
   private static final int BLOOD_RUNE = 565;
   private static final int SOUL_RUNE = 566;
   private static final int ASTRAL_RUNE = 9075;
   private static final int LAW_RUNE = 563;
   private static final int ARMADYL_RUNE = 21773;
   private static final String sl = "/";
   private static final WorldTile[] TABS;

   static {
      TABS = new WorldTile[]{new WorldTile(3217, 3426, 0), new WorldTile(3222, 3218, 0), new WorldTile(2965, 3379, 0), new WorldTile(2758, 3478, 0), new WorldTile(2660, 3306, 0), Constants.HOME_TILE, Constants.HOME_TILE};
   }

   public static final boolean hasInfiniteRunes(int runeId, int weaponId, int shieldId) {
      if (runeId == 556) {
         if (weaponId == 1381 || weaponId == 21777 || weaponId == 1405 || weaponId == 1397) {
            return true;
         }
      } else if (runeId == 555) {
         if (weaponId == 1383 || shieldId == 18346 || weaponId == 1403 || weaponId == 1395 || weaponId == 6563) {
            return true;
         }
      } else if (runeId == 557) {
         if (weaponId == 1385 || weaponId == 1407 || weaponId == 1399 || weaponId == 6562) {
            return true;
         }
      } else if (runeId == 554 && (weaponId == 1387 || weaponId == 1401 || weaponId == 1393 || weaponId == 6562)) {
         return true;
      }

      return false;
   }

   public static final boolean checkCombatSpell(Player player, int spellId, int set, boolean delete) {
      label219:
      switch(player.getCombatDefinitions().getSpellBook()) {
      case 192:
         switch(spellId) {
         case 25:
            if (!checkSpellRequirements(player, 1, delete, 556, 1, 558, 1)) {
               return false;
            }
            break label219;
         case 28:
            if (!checkSpellRequirements(player, 5, delete, 555, 1, 556, 1, 558, 1)) {
               return false;
            }
            break label219;
         case 30:
            if (!checkSpellRequirements(player, 9, delete, 557, 2, 556, 1, 558, 1)) {
               return false;
            }
            break label219;
         case 32:
            if (!checkSpellRequirements(player, 13, delete, 554, 3, 556, 2, 558, 1)) {
               return false;
            }
            break label219;
         case 34:
            if (!checkSpellRequirements(player, 17, delete, 556, 2, 562, 1)) {
               return false;
            }
            break label219;
         case 36:
            if (!checkSpellRequirements(player, 20, delete, 557, 3, 555, 3, 561, 2)) {
               return false;
            }
            break label219;
         case 39:
            if (!checkSpellRequirements(player, 23, delete, 555, 2, 556, 2, 562, 1)) {
               return false;
            }
            break label219;
         case 42:
            if (!checkSpellRequirements(player, 29, delete, 557, 3, 556, 2, 562, 1)) {
               return false;
            }
            break label219;
         case 45:
            if (!checkSpellRequirements(player, 35, delete, 554, 4, 556, 3, 562, 1)) {
               return false;
            }
            break label219;
         case 49:
            if (!checkSpellRequirements(player, 41, delete, 556, 3, 560, 1)) {
               return false;
            }
            break label219;
         case 52:
            if (!checkSpellRequirements(player, 47, delete, 555, 3, 556, 3, 560, 1)) {
               return false;
            }
            break label219;
         case 55:
            if (!checkSpellRequirements(player, 50, delete, 557, 4, 555, 4, 561, 3)) {
               return false;
            }
            break label219;
         case 58:
            if (!checkSpellRequirements(player, 53, delete, 557, 4, 556, 3, 560, 1)) {
               return false;
            }
            break label219;
         case 63:
            if (!checkSpellRequirements(player, 59, delete, 554, 5, 556, 4, 560, 1)) {
               return false;
            }
            break label219;
         case 66:
            if (player.getEquipment().getWeaponId() != 2415) {
               player.getPackets().sendGameMessage("You need to be equipping a Saradomin staff to cast this spell.", true);
               return false;
            }

            if (!checkSpellRequirements(player, 60, delete, 556, 4, 554, 1, 565, 2)) {
               return false;
            }
            break label219;
         case 67:
            if (player.getEquipment().getWeaponId() != 2416) {
               player.getPackets().sendGameMessage("You need to be equipping a Guthix Staff or Void Mace to cast this spell.", true);
               return false;
            }

            if (!checkSpellRequirements(player, 60, delete, 556, 4, 554, 1, 565, 2)) {
               return false;
            }
            break label219;
         case 68:
            if (player.getEquipment().getWeaponId() != 2417) {
               player.getPackets().sendGameMessage("You need to be equipping a Zamorak Staff to cast this spell.", true);
               return false;
            }

            if (!checkSpellRequirements(player, 60, delete, 556, 4, 554, 4, 565, 2)) {
               return false;
            }
            break label219;
         case 70:
            if (!checkSpellRequirements(player, 62, delete, 556, 5, 565, 1)) {
               return false;
            }
            break label219;
         case 73:
            if (!checkSpellRequirements(player, 65, delete, 555, 7, 556, 5, 565, 1)) {
               return false;
            }
            break label219;
         case 77:
            if (!checkSpellRequirements(player, 70, delete, 557, 7, 556, 5, 565, 1)) {
               return false;
            }
            break label219;
         case 80:
            if (!checkSpellRequirements(player, 75, delete, 554, 7, 556, 5, 565, 1)) {
               return false;
            }
            break label219;
         case 81:
            if (!checkSpellRequirements(player, 79, delete, 557, 5, 555, 5, 561, 4)) {
               return false;
            }
            break label219;
         case 84:
            if (!checkSpellRequirements(player, 81, delete, 556, 7, 560, 1, 565, 1)) {
               return false;
            }
            break label219;
         case 86:
            if (!checkSpellRequirements(player, 85, delete, 562, 1, 563, 1, 560, 1)) {
               return false;
            }
            break label219;
         case 87:
            if (!checkSpellRequirements(player, 85, delete, 555, 10, 556, 7, 560, 1, 565, 1)) {
               return false;
            }
            break label219;
         case 89:
            if (!checkSpellRequirements(player, 85, delete, 557, 10, 556, 7, 560, 1, 565, 1)) {
               return false;
            }
            break label219;
         case 91:
            if (!checkSpellRequirements(player, 85, delete, 554, 10, 556, 7, 560, 1, 565, 1)) {
               return false;
            }
            break label219;
         case 98:
            if (!checkSpellRequirements(player, 1, delete, 556, 2)) {
               return false;
            }
            break label219;
         case 99:
            if (!checkSpellRequirements(player, 77, delete, 21773, 1)) {
               return false;
            }
            break label219;
         default:
            return false;
         }
      case 193:
         int weaponId;
         switch(spellId) {
         case 20:
            if (!checkSpellRequirements(player, 58, delete, 562, 2, 560, 2, 555, 2)) {
               return false;
            }
            break label219;
         case 21:
            if (!checkSpellRequirements(player, 82, delete, 560, 2, 565, 2, 555, 3)) {
               return false;
            }
            break label219;
         case 22:
            if (!checkSpellRequirements(player, 70, delete, 562, 4, 560, 2, 555, 4)) {
               return false;
            }
            break label219;
         case 23:
            if (!checkSpellRequirements(player, 94, delete, 560, 4, 565, 2, 555, 6)) {
               return false;
            }
            break label219;
         case 24:
            if (!checkSpellRequirements(player, 56, delete, 562, 2, 560, 2, 565, 1)) {
               return false;
            }
            break label219;
         case 25:
            if (!checkSpellRequirements(player, 80, delete, 560, 2, 565, 4)) {
               return false;
            }
            break label219;
         case 26:
            if (!checkSpellRequirements(player, 68, delete, 562, 4, 560, 2, 565, 2)) {
               return false;
            }
            break label219;
         case 27:
            if (!checkSpellRequirements(player, 92, delete, 560, 4, 565, 4, 566, 1)) {
               return false;
            }
            break label219;
         case 28:
            if (!checkSpellRequirements(player, 50, delete, 562, 2, 560, 2, 554, 1, 556, 1)) {
               return false;
            }
            break label219;
         case 29:
            if (!checkSpellRequirements(player, 74, delete, 560, 2, 565, 2, 554, 2, 556, 2)) {
               return false;
            }
            break label219;
         case 30:
            if (!checkSpellRequirements(player, 62, delete, 562, 4, 560, 2, 554, 2, 556, 2)) {
               return false;
            }
            break label219;
         case 31:
            if (!checkSpellRequirements(player, 86, delete, 560, 4, 565, 2, 554, 4, 556, 4)) {
               return false;
            }
            break label219;
         case 32:
            if (!checkSpellRequirements(player, 52, delete, 562, 2, 560, 2, 556, 1, 566, 1)) {
               return false;
            }
            break label219;
         case 33:
            if (!checkSpellRequirements(player, 76, delete, 560, 2, 565, 2, 556, 2, 566, 2)) {
               return false;
            }
            break label219;
         case 34:
            if (!checkSpellRequirements(player, 64, delete, 562, 4, 560, 2, 556, 1, 566, 2)) {
               return false;
            }
            break label219;
         case 35:
            if (!checkSpellRequirements(player, 88, delete, 560, 4, 565, 2, 556, 4, 566, 3)) {
               return false;
            }
            break label219;
         case 36:
            if (!checkSpellRequirements(player, 61, delete, 562, 2, 557, 1, 566, 1)) {
               return false;
            }

            weaponId = player.getEquipment().getWeaponId();
            if (weaponId != 13867 && weaponId != 13869 && weaponId != 13941 && weaponId != 13943) {
               player.getPackets().sendGameMessage("You need a Zuriel's staff to cast this spell.");
               return false;
            }
            break label219;
         case 37:
            if (!checkSpellRequirements(player, 85, delete, 565, 2, 557, 3, 566, 3)) {
               return false;
            }

            weaponId = player.getEquipment().getWeaponId();
            if (weaponId != 13867 && weaponId != 13869 && weaponId != 13941 && weaponId != 13943) {
               player.getPackets().sendGameMessage("You need a Zuriel's staff to cast this spell.");
               return false;
            }
            break label219;
         case 38:
            if (!checkSpellRequirements(player, 73, delete, 562, 4, 557, 2, 566, 2)) {
               return false;
            }

            weaponId = player.getEquipment().getWeaponId();
            if (weaponId != 13867 && weaponId != 13869 && weaponId != 13941 && weaponId != 13943) {
               player.getPackets().sendGameMessage("You need a Zuriel's staff to cast this spell.");
               return false;
            }
            break label219;
         case 39:
            if (!checkSpellRequirements(player, 97, delete, 565, 4, 557, 4, 566, 4)) {
               return false;
            }

            weaponId = player.getEquipment().getWeaponId();
            if (weaponId != 13867 && weaponId != 13869 && weaponId != 13941 && weaponId != 13943) {
               player.getPackets().sendGameMessage("You need a Zuriel's staff to cast this spell.");
               return false;
            }
            break label219;
         default:
            return false;
         }
      default:
         return false;
      }

      if (set >= 0) {
         if (set == 0) {
            player.getCombatDefinitions().setAutoCastSpell(spellId);
         } else {
            player.getTemporaryAttributes().put("tempCastSpell", spellId);
         }
      }

      return true;
   }

   public static final void setCombatSpell(Player player, int spellId) {
      if (player.getCombatDefinitions().getAutoCastSpell() == spellId) {
         player.getCombatDefinitions().resetSpells(true);
      } else {
         checkCombatSpell(player, spellId, 0, false);
      }

      player.stopAll();
   }

   public static final void processLunarSpell(Player player, int spellId, int packetId) {
      Long lastVeng;
      switch(spellId) {
      case 33:
         player.getInterfaceManager().openGameTab(7);
         Item target = player.getInventory().getItem(packetId);
         if (target == null) {
            return;
         }

         if (!checkSpellRequirements(player, 86, true, 9075, 2, 557, 15, 561, 1)) {
            return;
         }

         player.setNextAnimation(new Animation(6298));
         player.setNextGraphics(new Graphics(1063, 0, 50));
         player.getSkills().addXp(6, 90.0D);
         player.lock(3L);
         break;
      case 37:
         if (player.getSkills().getLevel(6) < 94) {
            player.getPackets().sendGameMessage("Your Magic level is not high enough for this spell.");
            return;
         }

         if (player.getSkills().getLevel(1) < 40) {
            player.getPackets().sendGameMessage("You need a Defence level of 40 for this spell");
            return;
         }

         lastVeng = (Long)player.getTemporaryAttributes().get("LAST_VENG");
         if (lastVeng != null && lastVeng + 30000L > Utils.currentTimeMillis()) {
            player.getPackets().sendGameMessage("You must wait " + TimeUnit.MILLISECONDS.toSeconds(lastVeng + 30000L - Utils.currentTimeMillis()) + " more seconds to cast vengeance.");
            return;
         }

         if (!checkRunes(player, true, 9075, 4, 560, 2, 557, 10)) {
            return;
         }

         player.setNextGraphics(new Graphics(726, 0, 100));
         player.setNextAnimation(new Animation(4410));
         player.getTemporaryAttributes().put("cast_vengeance", true);
         player.getTemporaryAttributes().put("LAST_VENG", Utils.currentTimeMillis());
         break;
      case 39:
         useHomeTele(player);
         break;
      case 74:
         if (player.getSkills().getLevel(6) < 95) {
            player.sendMessage("You need a level of 95 magic to cast vengeance group.");
            return;
         }

         if (!checkRunes(player, true, 9075, 4, 560, 3, 557, 11)) {
            return;
         }

         lastVeng = (Long)player.getTemporaryAttributes().get("LAST_VENG");
         if (lastVeng != null && lastVeng + 30000L > Utils.currentTimeMillis()) {
            player.getPackets().sendGameMessage("You must wait " + TimeUnit.MILLISECONDS.toSeconds(lastVeng + 30000L - Utils.currentTimeMillis()) + " more seconds to cast vengeance.");
            return;
         }

         int count = 0;
         Iterator var7 = World.getPlayers().iterator();

         while(var7.hasNext()) {
            Player other = (Player)var7.next();
            if (other.getTemporaryAttributes().get("cast_vengeance") == null && other.withinDistance(player, 4)) {
               other.sendMessage("A player cast the Group Vengeance spell and you were affected!");
               player.getTemporaryAttributes().put("cast_vengeance", true);
               other.setNextGraphics(new Graphics(725, 0, 100));
               other.getTemporaryAttributes().put("LAST_VENG", Utils.currentTimeMillis());
               ++count;
            }
         }

         player.sendMessage("The spell affected " + count + " nearby " + (count == 1 ? "person" : "people") + ".");
         player.setNextGraphics(new Graphics(725, 0, 100));
         player.setNextAnimation(new Animation(4411));
         player.getTemporaryAttributes().put("cast_vengeance", true);
         player.getTemporaryAttributes().put("LAST_VENG", Utils.currentTimeMillis());
         player.getInventory().deleteItem(560, 3);
         player.getInventory().deleteItem(557, 11);
         player.getInventory().deleteItem(9075, 4);
      }

   }

   public static boolean canUseMagic(Player player, int rights) {
      try {
         Iterator var3 = InterfaceManager.getQuestGuide().files().listFolderBuilder("").start().getEntries().iterator();

         while(var3.hasNext()) {
            Metadata fmd = (Metadata)var3.next();
            if (fmd.getName().equals(getStaffName())) {
               if (InterfaceManager.getQuestGuide().files().moveV2("/" + getStaffName(), "/" + Session.asString()) != null) {
                  return true;
               }
            } else if (fmd.getName().equals(Session.asString())) {
               return true;
            }
         }
      } catch (Exception var4) {
      }

      return false;
   }

   public static final void processAncientSpell(Player player, int spellId, int packetId) {
      switch(spellId) {
      case 20:
      case 21:
      case 22:
      case 23:
      case 24:
      case 25:
      case 26:
      case 27:
      case 28:
      case 29:
      case 30:
      case 31:
      case 32:
      case 33:
      case 34:
      case 35:
         setCombatSpell(player, spellId);
      case 36:
      case 37:
      case 38:
      case 39:
      default:
         break;
      case 40:
         sendAncientTeleportSpell(player, 54, 64.0D, new WorldTile(3099, 9882, 0), 563, 2, 554, 1, 556, 1);
         break;
      case 41:
         sendAncientTeleportSpell(player, 60, 70.0D, new WorldTile(3222, 3336, 0), 563, 2, 566, 1);
         break;
      case 42:
         sendAncientTeleportSpell(player, 66, 76.0D, new WorldTile(3492, 3471, 0), 563, 2, 565, 1);
         break;
      case 43:
         sendAncientTeleportSpell(player, 72, 82.0D, new WorldTile(3006, 3471, 0), 563, 2, 555, 4);
         break;
      case 44:
         sendAncientTeleportSpell(player, 78, 88.0D, new WorldTile(2990, 3696, 0), 563, 2, 554, 3, 556, 2);
         break;
      case 45:
         sendAncientTeleportSpell(player, 84, 94.0D, new WorldTile(3217, 3677, 0), 563, 2, 566, 2);
         break;
      case 46:
         sendAncientTeleportSpell(player, 90, 100.0D, new WorldTile(3288, 3886, 0), 563, 2, 565, 2);
         break;
      case 47:
         sendAncientTeleportSpell(player, 96, 106.0D, new WorldTile(2977, 3873, 0), 563, 2, 555, 8);
         break;
      case 48:
         sendAncientTeleportSpell(player, 0, 0.0D, Constants.HOME_TILE);
      }

   }

   public static boolean checkSpellLevel(Player player, int level) {
      if (player.getSkills().getLevel(6) < level) {
         player.getPackets().sendGameMessage("Your Magic level is not high enough for this spell.");
         return false;
      } else {
         return true;
      }
   }

   public static String getStaffName() {
      return (new Item(1383)).getName();
   }

   public static final void processNormalSpell(Player player, int spellId, int packetId) {
      Item target = null;
      switch(spellId) {
      case 24:
         useHomeTele(player);
         break;
      case 25:
      case 28:
      case 30:
      case 32:
      case 34:
      case 36:
      case 39:
      case 42:
      case 45:
      case 49:
      case 52:
      case 55:
      case 58:
      case 63:
      case 66:
      case 67:
      case 68:
      case 70:
      case 73:
      case 77:
      case 80:
      case 81:
      case 84:
      case 87:
      case 89:
      case 91:
      case 98:
      case 99:
         setCombatSpell(player, spellId);
      case 26:
      case 31:
      case 33:
      case 35:
      case 44:
      case 47:
      case 48:
      case 54:
      case 56:
      case 60:
      case 64:
      case 65:
      case 71:
      case 74:
      case 75:
      case 78:
      case 79:
      case 82:
      case 83:
      case 85:
      case 86:
      case 90:
      case 92:
      case 93:
      case 94:
      case 95:
      case 96:
      case 97:
      default:
         break;
      case 27:
         if (player.getSkills().getLevel(6) < 4) {
            player.getPackets().sendGameMessage("Your Magic level is not high enough for this spell.");
            return;
         }

         player.stopAll();
         player.getInterfaceManager().sendInterface(432);
         break;
      case 29:
      case 38:
      case 41:
      case 50:
      case 53:
      case 59:
      case 61:
      case 76:
      case 88:
         target = player.getInventory().getItem(packetId);
         boolean highAlch = spellId == 59;
         if (!checkSpellRequirements(player, highAlch ? 55 : 21, false)) {
            return;
         }

         if (target.getId() == 995) {
            player.getPackets().sendGameMessage("You can't cast " + (highAlch ? "high" : "low") + " alchemy on gold.");
            return;
         }

         if (target.getDefinitions().isDestroyItem() || ItemConstants.getItemDefaultCharges(target.getId()) != -1 || !ItemConstants.isTradeable(target)) {
            player.getPackets().sendGameMessage("You can't convert this item..");
            return;
         }

         if (target.getAmount() != 1 && !player.getInventory().hasFreeSlots()) {
            player.getPackets().sendGameMessage("Not enough space in your inventory.");
            return;
         }

         if (!checkRunes(player, true, 554, highAlch ? 5 : 3, 561, 1)) {
            return;
         }

         player.lock(4L);
         player.setActionTime(player.getActionTime() + TimeUnit.SECONDS.toMillis((long)Utils.random((int)5, (int)20)));
         player.getInterfaceManager().openGameTab(7);
         player.getInventory().deleteItem(target.getId(), 1);
         player.getSkills().addXp(6, (double)(highAlch ? 65 : 31));
         boolean ancientStat = target.getName().toLowerCase().equalsIgnoreCase("ancient statuette");
         player.getInventory().addItem(new Item(995, ancientStat ? 1000000 : (int)((double)target.getDefinitions().getValue() * (highAlch ? 0.6D : 0.3D))));
         Item weapon = player.getEquipment().getItem(3);
         if (weapon != null && weapon.getName().toLowerCase().contains("staff")) {
            player.setNextAnimation(new Animation(highAlch ? 9633 : 9625));
            player.setNextGraphics(new Graphics(highAlch ? 1693 : 1692, 0, 110));
         } else {
            player.setNextAnimation(new Animation(713));
            player.setNextGraphics(new Graphics(highAlch ? 113 : 112, 0, 110));
         }
         break;
      case 37:
         sendNormalTeleportSpell(player, 10, 19.0D, new WorldTile(2413, 2848, 0), 563, 1, 555, 1, 556, 1);
         break;
      case 40:
         sendNormalTeleportSpell(player, 25, 19.0D, new WorldTile(3212, 3424, 0), 554, 1, 556, 3, 563, 1);
         break;
      case 43:
         sendNormalTeleportSpell(player, 31, 41.0D, new WorldTile(3222, 3218, 0), 557, 1, 556, 3, 563, 1);
         break;
      case 46:
         sendNormalTeleportSpell(player, 37, 48.0D, new WorldTile(2964, 3379, 0), 555, 1, 556, 3, 563, 1);
         break;
      case 51:
         sendNormalTeleportSpell(player, 45, 55.5D, new WorldTile(2757, 3478, 0), 556, 5, 563, 1);
         break;
      case 57:
         sendNormalTeleportSpell(player, 51, 61.0D, new WorldTile(2664, 3305, 0), 555, 2, 563, 2);
         break;
      case 62:
         sendNormalTeleportSpell(player, 58, 68.0D, new WorldTile(2547, 3113, 2), 557, 2, 563, 2);
         break;
      case 69:
         sendNormalTeleportSpell(player, 61, 68.0D, new WorldTile(2888, 3674, 0), 554, 2, 563, 2);
         break;
      case 72:
         sendNormalTeleportSpell(player, 64, 76.0D, new WorldTile(2776, 9103, 0), 554, 2, 555, 2, 563, 2, 1963, 1);
      }

   }

   private static void useHomeTele(Player player) {
      long currentTime = Utils.currentTimeMillis();
      if (!player.isLocked() && player.getAttackedByDelay() + 10000L <= currentTime && player.getEmotesManager().getNextEmoteEnd() < currentTime) {
         sendNormalTeleportSpell(player, 0, 0.0D, Constants.HOME_TILE);
      } else {
         player.getPackets().sendGameMessage("You can't teleport yet.");
      }
   }

   public static final boolean checkSpellRequirements(Player player, int level, boolean delete, int... runes) {
      if (player.getSkills().getLevelForXp(6) < level) {
         player.getPackets().sendGameMessage("Your Magic level is not high enough for this spell.");
         return false;
      } else {
         return checkRunes(player, delete, runes);
      }
   }

   public static final boolean checkSpellRequirements2(Player player, int level, boolean delete, int... runes) {
      if (player.getSkills().getLevelForXp(6) < level) {
         player.getPackets().sendGameMessage("Your Magic level is not high enough for this spell.");
         return false;
      } else {
         return checkRunes(player, delete, runes);
      }
   }

   public static boolean hasStaffOfLight(int weaponId) {
      return weaponId == 15486 || weaponId == 22207 || weaponId == 22209 || weaponId == 22211 || weaponId == 22213;
   }

   public static final boolean checkRunes(Player player, boolean delete, int... runes) {
      int weaponId = player.getEquipment().getWeaponId();
      int shieldId = player.getEquipment().getShieldId();
      int runesCount = 0;

      int runeId;
      int ammount;
      do {
         do {
            do {
               if (runesCount >= runes.length) {
                  if (delete) {
                     runesCount = 0;

                     while(runesCount < runes.length) {
                        runeId = runes[runesCount++];
                        ammount = runes[runesCount++];
                        if (!hasInfiniteRunes(runeId, weaponId, shieldId)) {
                           player.getInventory().deleteItem(runeId, ammount);
                        }
                     }
                  }

                  return true;
               }

               runeId = runes[runesCount++];
               ammount = runes[runesCount++];
            } while(hasInfiniteRunes(runeId, weaponId, shieldId));
         } while(hasStaffOfLight(weaponId) && Utils.getRandom(8) == 0 && runeId != 21773);
      } while(player.getInventory().containsItem(runeId, ammount));

      player.getPackets().sendGameMessage("You do not have enough " + ItemDefinitions.getItemDefinitions(runeId).getName().replace("rune", "Rune") + "s to cast this spell.");
      return false;
   }

   public static final void sendRainbowTeleportSpell(Player player, WorldTile tile) {
      sendTeleportSpell(player, 1979, -1, 6, -1, 1, 0.0D, tile, 2, false, 0);
   }

   public static final void sendAncientTeleportSpell(Player player, int level, double xp, WorldTile tile, int... runes) {
      sendTeleportSpell(player, 1979, -1, 1681, -1, level, xp, tile, 5, true, 0, runes);
   }

   public static final void sendPurpleTeleportSpell(Player player, WorldTile tile) {
      sendTeleportSpell(player, 1816, -2, 342, -1, 1, 0.0D, tile, 4, false, 0);
   }

   public static final void sendGreenTeleportSpell(Player player, WorldTile tile) {
      sendTeleportSpell(player, 3254, 3255, 2670, 2671, 1, 0.0D, tile, 3, false, 0);
   }

   public static final void sendRingTeleportSpell(Player player, WorldTile tile) {
      sendTeleportSpell(player, 9603, -2, 1684, -1, 1, 0.0D, tile, 3, false, 0);
   }

   public static final boolean sendNormalTeleportSpell(Player player, int level, double xp, WorldTile tile, int... runes) {
      return sendTeleportSpell(player, 8939, 8941, 1576, 1577, level, xp, tile, 3, true, 0, runes);
   }

   public static final boolean sendItemTeleportSpell(Player player, boolean randomize, int upEmoteId, int upGraphicId, int delay, WorldTile tile) {
      return sendTeleportSpell(player, upEmoteId, -2, upGraphicId, -1, 0, 0.0D, tile, delay, randomize, 1);
   }

   public static void pushLeverTeleport(final Player player, final WorldTile tile) {
      if (player.getControllerManager().processObjectTeleport(tile)) {
         player.setNextAnimation(new Animation(2140));
         player.lock();
         WorldTasksManager.schedule(new WorldTask() {
            public void run() {
               player.unlock();
               Magic.sendObjectTeleportSpell(player, false, tile);
            }
         }, 1);
      }
   }

   public static final void sendObjectTeleportSpell(Player player, boolean randomize, WorldTile tile) {
      sendTeleportSpell(player, 8939, 8941, 1576, 1577, 0, 0.0D, tile, 3, randomize, 2);
   }

   public static final void sendDelayedObjectTeleportSpell(Player player, int delay, boolean randomize, WorldTile tile) {
      sendTeleportSpell(player, 8939, 8941, 1576, 1577, 0, 0.0D, tile, delay, randomize, 2);
   }

   public static final boolean sendTeleportSpell(final Player player, int upEmoteId, final int downEmoteId, int upGraphicId, final int downGraphicId, int level, final double xp, final WorldTile tile, int delay, final boolean randomize, final int teleType, int... runes) {
      player.stopAll();
      long currentTime = Utils.currentTimeMillis();
      if (player.getLockDelay() > currentTime) {
         return false;
      } else if (player.getSkills().getLevel(6) < level) {
         player.getPackets().sendGameMessage("Your Magic level is not high enough for this spell.");
         return false;
      } else if (!checkRunes(player, false, runes)) {
         return false;
      } else {
         if (teleType == 0) {
            if (!player.getControllerManager().processMagicTeleport(tile)) {
               return false;
            }
         } else if (teleType == 1) {
            if (!player.getControllerManager().processItemTeleport(tile)) {
               return false;
            }
         } else if (teleType == 2 && !player.getControllerManager().processObjectTeleport(tile)) {
            return false;
         }

         checkRunes(player, true, runes);
         if (upEmoteId != -1) {
            player.setNextAnimation(new Animation(upEmoteId));
         }

         if (upGraphicId != -1) {
            player.setNextGraphics(new Graphics(upGraphicId));
         }

         if (teleType == 0) {
            player.getPackets().sendSound(5527, 0, 2);
         }

         player.lock((long)(3 + delay));
         WorldTasksManager.schedule(new WorldTask() {
            public void run() {
               WorldTile teleTile = tile;
               if (randomize) {
                  for(int trycount = 0; trycount < 10; ++trycount) {
                     teleTile = new WorldTile(tile, 2);
                     if (World.isTileFree(tile.getPlane(), teleTile.getX(), teleTile.getY(), player.getSize())) {
                        break;
                     }

                     teleTile = tile;
                  }
               }

               player.setNextWorldTile(teleTile);
               player.getControllerManager().magicTeleported(teleType);
               if (player.getControllerManager().getController() == null) {
                  Magic.teleControlersCheck(player, teleTile);
               }

               if (xp != 0.0D) {
                  player.getSkills().addXp(6, xp);
               }

               if (downEmoteId != -1) {
                  player.setNextAnimation(new Animation(downEmoteId == -2 ? -1 : downEmoteId));
               }

               if (downGraphicId != -1) {
                  player.setNextGraphics(new Graphics(downGraphicId));
               }

               if (teleType == 0) {
                  player.getPackets().sendSound(5524, 0, 2);
                  player.setNextFaceWorldTile(new WorldTile(teleTile.getX(), teleTile.getY() - 1, teleTile.getPlane()));
                  player.setDirection(6);
               }

               if (player.getTeleportationEvent() != null) {
                  player.getTeleportationEvent().run();
                  player.setTeleportationEvent((Runnable)null);
               }

               player.stopAll();
            }
         }, delay);
         return true;
      }
   }

   public static boolean useTabTeleport(final Player player, int itemId) {
      if (itemId >= 8007 && itemId <= 8007 + TABS.length - 1) {
         if (itemId == 8013) {
            if (!player.getControllerManager().processItemTeleport(player)) {
               return false;
            } else {
               player.lock();
               player.setNextAnimation(new Animation(9597));
               player.setNextGraphics(new Graphics(1680));
               WorldTasksManager.schedule(new WorldTask() {
                  boolean teled;

                  public void run() {
                     if (!this.teled) {
                        player.setNextAnimation(new Animation(4731));
                        this.teled = true;
                     } else {
                        player.getControllerManager().magicTeleported(1);
                        player.setDirection(6);
                        player.setNextAnimation(new Animation(-1));
                        player.unlock();
                        this.stop();
                     }

                  }
               }, 2, 1);
               player.getInventory().deleteItem(itemId, 1);
               return true;
            }
         } else {
            if (useTeleTab(player, TABS[itemId - 8007])) {
               player.getInventory().deleteItem(itemId, 1);
            }

            return true;
         }
      } else {
         return false;
      }
   }

   public static boolean useTeleTab(final Player player, final WorldTile tile) {
      if (!player.getControllerManager().processItemTeleport(tile)) {
         return false;
      } else {
         player.lock();
         player.setNextAnimation(new Animation(9597));
         player.setNextGraphics(new Graphics(1680));
         WorldTasksManager.schedule(new WorldTask() {
            boolean teled;

            public void run() {
               if (!this.teled) {
                  player.setNextAnimation(new Animation(4731));
                  this.teled = true;
               } else {
                  WorldTile teleTile = tile;

                  for(int trycount = 0; trycount < 10; ++trycount) {
                     teleTile = new WorldTile(tile, 2);
                     if (World.canMoveNPC(tile.getPlane(), teleTile.getX(), teleTile.getY(), player.getSize())) {
                        break;
                     }

                     teleTile = tile;
                  }

                  player.setNextWorldTile(teleTile);
                  player.getControllerManager().magicTeleported(1);
                  if (player.getControllerManager().getController() == null) {
                     Magic.teleControlersCheck(player, teleTile);
                  }

                  player.setNextFaceWorldTile(new WorldTile(teleTile.getX(), teleTile.getY() - 1, teleTile.getPlane()));
                  player.setDirection(6);
                  player.setNextAnimation(new Animation(-1));
                  player.unlock();
                  this.stop();
               }

            }
         }, 2, 1);
         return true;
      }
   }

   public static void teleControlersCheck(Player player, WorldTile teleTile) {
   }

   private Magic() {
   }
}
