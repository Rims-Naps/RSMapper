package org.rsmapper.game.player;

import java.io.Serializable;
import org.rsmapper.cache.loaders.ItemDefinitions;
import org.rsmapper.game.item.Item;

public final class CombatDefinitions implements Serializable {
   private static final long serialVersionUID = 2102201264836121104L;
   public static final int STAB_ATTACK = 0;
   public static final int SLASH_ATTACK = 1;
   public static final int CRUSH_ATTACK = 2;
   public static final int RANGE_ATTACK = 4;
   public static final int MAGIC_ATTACK = 3;
   public static final int STAB_DEF = 5;
   public static final int SLASH_DEF = 6;
   public static final int CRUSH_DEF = 7;
   public static final int RANGE_DEF = 9;
   public static final int MAGIC_DEF = 8;
   public static final int SUMMONING_DEF = 10;
   public static final int STRENGTH_BONUS = 14;
   public static final int RANGED_STR_BONUS = 15;
   public static final int MAGIC_DAMAGE = 17;
   public static final int PRAYER_BONUS = 16;
   public static final int ABSORVE_MELEE_BONUS = 11;
   public static final int ABSORVE_RANGE_BONUS = 13;
   public static final int ABSORVE_MAGE_BONUS = 12;
   public static final int AOE_MELEE = 1;
   public static final int AOE_MAGIC = 2;
   public static final int AOE_RANGE = 3;
   public static final int SHARED = -1;
   private transient Player player;
   private transient boolean usingSpecialAttack;
   private transient int[] bonuses;
   private byte attackStyle;
   private byte specialAttackPercentage = 100;
   private boolean autoRelatie = true;
   private byte sortSpellBook;
   private boolean showCombatSpells = true;
   private boolean showSkillSpells = true;
   private boolean showMiscallaneousSpells = true;
   private boolean showTeleportSpells = true;
   private boolean defensiveCasting;
   private transient boolean instantAttack;
   private transient boolean dungeonneringSpellBook;
   private byte spellBook;
   private byte autoCastSpell;

   public int getSpellId() {
      Integer tempCastSpell = (Integer)this.player.getTemporaryAttributes().get("tempCastSpell");
      return tempCastSpell != null ? tempCastSpell + 256 : this.autoCastSpell;
   }

   public int getAutoCastSpell() {
      return this.autoCastSpell;
   }

   public void resetSpells(boolean removeAutoSpell) {
      this.player.getTemporaryAttributes().remove("tempCastSpell");
      if (removeAutoSpell) {
         this.setAutoCastSpell(0);
         this.refreshAutoCastSpell();
      }

   }

   public void setAutoCastSpell(int id) {
      this.autoCastSpell = (byte)id;
      this.refreshAutoCastSpell();
   }

   public void refreshAutoCastSpell() {
      this.refreshAttackStyle();
      this.player.getPackets().sendConfig(108, this.getSpellAutoCastConfigValue());
   }

   public int getSpellAutoCastConfigValue() {
      if (this.dungeonneringSpellBook) {
         return 0;
      } else if (this.spellBook == 0) {
         switch(this.autoCastSpell) {
         case 25:
            return 3;
         case 28:
            return 5;
         case 30:
            return 7;
         case 32:
            return 9;
         case 34:
            return 11;
         case 39:
            return 13;
         case 42:
            return 15;
         case 45:
            return 17;
         case 49:
            return 19;
         case 52:
            return 21;
         case 58:
            return 23;
         case 63:
            return 25;
         case 66:
            return 41;
         case 67:
            return 39;
         case 68:
            return 43;
         case 70:
            return 27;
         case 73:
            return 29;
         case 77:
            return 31;
         case 80:
            return 33;
         case 84:
            return 47;
         case 87:
            return 49;
         case 89:
            return 51;
         case 91:
            return 53;
         case 98:
            return 143;
         case 99:
            return 145;
         default:
            return 0;
         }
      } else if (this.spellBook == 1) {
         switch(this.autoCastSpell) {
         case 20:
            return 69;
         case 21:
            return 85;
         case 22:
            return 77;
         case 23:
            return 93;
         case 24:
            return 67;
         case 25:
            return 83;
         case 26:
            return 75;
         case 27:
            return 91;
         case 28:
            return 63;
         case 29:
            return 79;
         case 30:
            return 71;
         case 31:
            return 87;
         case 32:
            return 65;
         case 33:
            return 81;
         case 34:
            return 73;
         case 35:
            return 89;
         default:
            return 0;
         }
      } else {
         return 0;
      }
   }

   public void setSpellBook(int id) {
      if (id == 3) {
         this.dungeonneringSpellBook = true;
      } else {
         this.spellBook = (byte)id;
      }

      this.refreshSpellBookScrollBar_DefCast();
      this.player.getInterfaceManager().sendMagicBook();
   }

   public void refreshSpellBookScrollBar_DefCast() {
      this.player.getPackets().sendConfig(439, (this.dungeonneringSpellBook ? 3 : this.spellBook) + (!this.isDefensiveCasting() ? 0 : 256));
   }

   public int getSpellBook() {
      if (this.dungeonneringSpellBook) {
         return 950;
      } else if (this.spellBook == 0) {
         return 192;
      } else {
         return this.spellBook == 1 ? 193 : 430;
      }
   }

   public void switchShowCombatSpells() {
      this.showCombatSpells = !this.showCombatSpells;
      this.refreshSpellBook();
   }

   public void switchShowSkillSpells() {
      this.showSkillSpells = !this.showSkillSpells;
      this.refreshSpellBook();
   }

   public void switchShowMiscallaneousSpells() {
      this.showMiscallaneousSpells = !this.showMiscallaneousSpells;
      this.refreshSpellBook();
   }

   public void switchShowTeleportSkillSpells() {
      this.showTeleportSpells = !this.showTeleportSpells;
      this.refreshSpellBook();
   }

   public void switchDefensiveCasting() {
      this.defensiveCasting = !this.defensiveCasting;
      this.refreshSpellBookScrollBar_DefCast();
   }

   public void setDefensiveCasting(boolean state) {
      this.defensiveCasting = state;
   }

   public void setSortSpellBook(int sortId) {
      this.sortSpellBook = (byte)sortId;
      this.refreshSpellBook();
   }

   public boolean isDefensiveCasting() {
      return this.defensiveCasting;
   }

   public void refreshSpellBook() {
      if (this.spellBook == 0) {
         this.player.getPackets().sendConfig(1376, this.sortSpellBook | (this.showCombatSpells ? 0 : 512) | (this.showSkillSpells ? 0 : 1024) | (this.showMiscallaneousSpells ? 0 : 2048) | (this.showTeleportSpells ? 0 : 4096));
      } else if (this.spellBook == 1) {
         this.player.getPackets().sendConfig(1376, this.sortSpellBook << 3 | (this.showCombatSpells ? 0 : 65536) | (this.showTeleportSpells ? 0 : 131072));
      } else if (this.spellBook == 2) {
         this.player.getPackets().sendConfig(1376, this.sortSpellBook << 6 | (this.showCombatSpells ? 0 : 8192) | (this.showMiscallaneousSpells ? 0 : 16384) | (this.showTeleportSpells ? 0 : '耀'));
      }

   }

   public static final int getMeleeDefenceBonus(int bonusId) {
      if (bonusId == 0) {
         return 5;
      } else {
         return bonusId == 6 ? 6 : 7;
      }
   }

   public static final int getMeleeBonusStyle(int weaponId, int attackStyle) {
      if (weaponId != -1) {
         String weaponName = ItemDefinitions.getItemDefinitions(weaponId).getName().toLowerCase();
         if (weaponName.contains("whip")) {
            return 1;
         } else if (weaponName.contains("staff of light")) {
            switch(attackStyle) {
            case 0:
               return 0;
            case 1:
               return 1;
            default:
               return 2;
            }
         } else if (!weaponName.contains("staff") && !weaponName.contains("granite mace") && !weaponName.contains("warhammer") && !weaponName.contains("tzhaar-ket-em") && !weaponName.contains("tzhaar-ket-om") && !weaponName.contains("maul")) {
            if (weaponName.contains("scimitar") || weaponName.contains("korasi's sword") || weaponName.contains("hatchet") || weaponName.contains("claws") || weaponName.contains("longsword")) {
               switch(attackStyle) {
               case 2:
                  return 0;
               default:
                  return 1;
               }
            } else if (weaponName.contains("mace") || weaponName.contains("anchor")) {
               switch(attackStyle) {
               case 2:
                  return 0;
               default:
                  return 2;
               }
            } else if (weaponName.contains("halberd")) {
               switch(attackStyle) {
               case 1:
                  return 1;
               default:
                  return 0;
               }
            } else if (weaponName.contains("spear")) {
               switch(attackStyle) {
               case 1:
                  return 1;
               case 2:
                  return 2;
               default:
                  return 0;
               }
            } else if (weaponName.contains("pickaxe")) {
               switch(attackStyle) {
               case 2:
                  return 2;
               default:
                  return 0;
               }
            } else if (!weaponName.contains("dagger") && !weaponName.contains("rapier")) {
               if (!weaponName.contains("godsword") && !weaponName.contains("greataxe") && !weaponName.contains("2h sword") && !weaponName.equals("saradomin sword")) {
                  return 2;
               } else {
                  switch(attackStyle) {
                  case 2:
                     return 2;
                  default:
                     return 1;
                  }
               }
            } else {
               switch(attackStyle) {
               case 2:
                  return 1;
               default:
                  return 0;
               }
            }
         } else {
            return 2;
         }
      } else {
         return 2;
      }
   }

   public static final int getXpStyle(int weaponId, int attackStyle) {
      if (weaponId != -1) {
         String weaponName = ItemDefinitions.getItemDefinitions(weaponId).getName().toLowerCase();
         if (weaponName.contains("whip")) {
            switch(attackStyle) {
            case 0:
               return 0;
            case 1:
               return -1;
            case 2:
            default:
               return 1;
            }
         }

         if (weaponName.contains("halberd")) {
            switch(attackStyle) {
            case 0:
               return -1;
            case 1:
               return 2;
            case 2:
            default:
               return 1;
            }
         }

         if (weaponName.contains("staff")) {
            switch(attackStyle) {
            case 0:
               return 0;
            case 1:
               return 2;
            case 2:
            default:
               return 1;
            }
         }

         if (weaponName.contains("godsword") || weaponName.contains("sword") || weaponName.contains("2h")) {
            switch(attackStyle) {
            case 0:
               return 0;
            case 1:
               return 2;
            case 2:
               return 2;
            case 3:
            default:
               return 1;
            }
         }
      }

      switch(weaponId) {
      case -1:
         switch(attackStyle) {
         case 0:
            return 0;
         case 1:
            return 2;
         case 2:
         default:
            return 1;
         }
      default:
         switch(attackStyle) {
         case 0:
            return 0;
         case 1:
            return 2;
         case 2:
            return -1;
         case 3:
         default:
            return 1;
         }
      }
   }

   public void setPlayer(Player player) {
      this.player = player;
      this.bonuses = new int[18];
   }

   public int[] getBonuses() {
      return this.bonuses;
   }

   public void refreshBonuses() {
      this.bonuses = new int[18];
      Item[] var4;
      int var3 = (var4 = this.player.getEquipment().getItems().getItems()).length;

      for(int var2 = 0; var2 < var3; ++var2) {
         Item item = var4[var2];
         if (item != null) {
            int[] bonuses = null;
            if (bonuses != null) {
               for(int id = 0; id < ((Object[])bonuses).length; ++id) {
                  if (id != 15 || this.bonuses[id] == 0) {
                     int[] var10000 = this.bonuses;
                     var10000[id] += ((Object[])bonuses)[id];
                  }
               }
            }
         }
      }

   }

   public void resetSpecialAttack() {
      this.desecreaseSpecialAttack(0);
      this.specialAttackPercentage = 100;
      this.refreshSpecialAttackPercentage();
   }

   public void setSpecialAttack(int special) {
      this.desecreaseSpecialAttack(0);
      this.specialAttackPercentage = (byte)special;
      this.refreshSpecialAttackPercentage();
   }

   public void restoreSpecialAttack() {
      this.restoreSpecialAttack(10);
   }

   public void restoreSpecialAttack(int percentage) {
      if (this.specialAttackPercentage < 100 && !this.player.getInterfaceManager().containsScreenInterface()) {
         this.specialAttackPercentage = (byte)(this.specialAttackPercentage + (this.specialAttackPercentage > 100 - percentage ? 100 - this.specialAttackPercentage : percentage));
         this.refreshSpecialAttackPercentage();
      }
   }

   public void init() {
      this.refreshUsingSpecialAttack();
      this.refreshSpecialAttackPercentage();
      this.refreshAutoRelatie();
      this.refreshAttackStyle();
      this.refreshSpellBook();
      this.refreshAutoCastSpell();
      this.refreshSpellBookScrollBar_DefCast();
   }

   public void checkAttackStyle() {
      if (this.autoCastSpell == 0) {
         this.setAttackStyle(this.attackStyle);
      }

   }

   public void setAttackStyle(int style) {
      int maxSize = 3;
      int weaponId = this.player.getEquipment().getWeaponId();
      if (weaponId == -1) {
         String var10000 = "";
      } else {
         ItemDefinitions.getItemDefinitions(weaponId).getName().toLowerCase();
      }

      if (style > maxSize) {
         style = maxSize;
      }

      if (style != this.attackStyle) {
         this.attackStyle = (byte)style;
         if (this.autoCastSpell > 1) {
            this.resetSpells(true);
         } else {
            this.refreshAttackStyle();
         }
      } else if (this.autoCastSpell > 1) {
         this.resetSpells(true);
      }

   }

   public void refreshAttackStyle() {
      this.player.getPackets().sendConfig(43, this.autoCastSpell > 0 ? 4 : this.attackStyle);
   }

   public void sendUnlockAttackStylesButtons() {
      for(int componentId = 11; componentId <= 14; ++componentId) {
         this.player.getPackets().sendUnlockIComponentOptionSlots(884, componentId, -1, 0, 0);
      }

   }

   public void switchUsingSpecialAttack() {
      this.usingSpecialAttack = !this.usingSpecialAttack;
      this.refreshUsingSpecialAttack();
   }

   public void desecreaseSpecialAttack(int ammount) {
      this.usingSpecialAttack = false;
      this.refreshUsingSpecialAttack();
      if (ammount > 0) {
         this.specialAttackPercentage = (byte)(this.specialAttackPercentage - ammount);
         this.refreshSpecialAttackPercentage();
      }

   }

   public boolean hasRingOfVigour() {
      return this.player.getEquipment().getRingId() == 19669;
   }

   public int getSpecialAttackPercentage() {
      return this.specialAttackPercentage;
   }

   public void refreshUsingSpecialAttack() {
      this.player.getPackets().sendConfig(301, this.usingSpecialAttack ? 1 : 0);
   }

   public void refreshSpecialAttackPercentage() {
      this.player.getPackets().sendConfig(300, this.specialAttackPercentage * 10);
   }

   public void switchAutoRelatie() {
      this.autoRelatie = !this.autoRelatie;
      this.refreshAutoRelatie();
   }

   public void refreshAutoRelatie() {
      this.player.getPackets().sendConfig(172, this.autoRelatie ? 0 : 1);
   }

   public boolean isUsingSpecialAttack() {
      return this.usingSpecialAttack;
   }

   public int getAttackStyle() {
      return this.attackStyle;
   }

   public boolean isAutoRetaliating() {
      return this.autoRelatie;
   }

   public void setAutoRelatie(boolean autoRelatie) {
      this.autoRelatie = autoRelatie;
   }

   public boolean isDungeonneringSpellBook() {
      return this.dungeonneringSpellBook;
   }

   public void removeDungeonneringBook() {
      if (this.dungeonneringSpellBook) {
         this.dungeonneringSpellBook = false;
         this.player.getInterfaceManager().sendMagicBook();
      }

   }

   public boolean isInstantAttack() {
      return this.instantAttack;
   }

   public void setInstantAttack(boolean instantAttack) {
      this.instantAttack = instantAttack;
   }
}
