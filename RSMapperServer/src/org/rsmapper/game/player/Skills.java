package org.rsmapper.game.player;

import java.io.Serializable;
import org.rsmapper.game.item.Item;
import org.rsmapper.utilities.misc.Utils;

public final class Skills implements Serializable {
   private static final long serialVersionUID = -7086829989489745985L;
   public static final double MAXIMUM_EXP = 2.0E8D;
   public static final int ATTACK = 0;
   public static final int DEFENCE = 1;
   public static final int STRENGTH = 2;
   public static final int HITPOINTS = 3;
   public static final int RANGE = 4;
   public static final int PRAYER = 5;
   public static final int MAGIC = 6;
   public static final int COOKING = 7;
   public static final int WOODCUTTING = 8;
   public static final int FLETCHING = 9;
   public static final int FISHING = 10;
   public static final int FIREMAKING = 11;
   public static final int CRAFTING = 12;
   public static final int SMITHING = 13;
   public static final int MINING = 14;
   public static final int HERBLORE = 15;
   public static final int AGILITY = 16;
   public static final int THIEVING = 17;
   public static final int SLAYER = 18;
   public static final int FARMING = 19;
   public static final int RUNECRAFTING = 20;
   public static final int HUNTER = 21;
   public static final int ROYALTY = 22;
   public static final int SUMMONING = 23;
   public static final int DUNGEONEERING = 24;
   public static final String[] SKILL_NAME = new String[]{"Attack", "Defence", "Strength", "Constitution", "Ranging", "Prayer", "", "Cooking", "Woodcutting", "Fletching", "Fishing", "Firemaking", "Crafting", "Smithing", "Mining", "Herblore", "Agility", "Thieving", "Slayer", "Farming", "Runecraft", "Hunter", "Royalty", "Summoning", "Dungeoneering"};
   public static final int[] SKILL_SPRITES = new int[]{197, 199, 198, 203, 200, 201, 202, 212, 214, 208, 211, 213, 207, 210, 209, 205, 204, 206, 216, 217, 215, 220, 221, 222, 3028};
   public static final byte[] XP_COUNTER_STAT_ORDER = new byte[]{0, 2, 1, 4, 6, 3, 5, 16, 15, 17, 12, 9, 14, 13, 10, 7, 11, 8, 20, 18, 19, 22, 21, 23, 24};
   public short[] level = new short[25];
   private double[] xp = new double[25];
   public static double[] exp;
   private double xpCounter;
   private transient Player player;

   public void passLevels(Player p) {
      this.level = p.getSkills().level;
      this.xp = p.getSkills().xp;
   }

   public Skills() {
      for(int i = 0; i < this.level.length; ++i) {
         this.level[i] = 1;
         this.xp[i] = 0.0D;
      }

      this.level[3] = 10;
      this.xp[3] = 1184.0D;
      this.level[15] = 3;
      this.xp[15] = 250.0D;
      exp = this.xp;
   }

   public void restoreSkills() {
      for(int skill = 0; skill < this.level.length; ++skill) {
         this.level[skill] = (short)this.getLevelForXp(skill);
         this.refresh(skill);
      }

   }

   public void setPlayer(Player player) {
      this.player = player;
   }

   public int getLevel(int skill) {
      return this.level[skill];
   }

   public double getXp(int skill) {
      return this.xp[skill];
   }

   public int getCombatLevel() {
      int attack = this.getLevelForXp(0);
      int defence = this.getLevelForXp(1);
      int strength = this.getLevelForXp(2);
      int hp = this.getLevelForXp(3);
      int prayer = this.getLevelForXp(5);
      int ranged = this.getLevelForXp(4);
      int magic = this.getLevelForXp(6);
      int combatLevel = true;
      int combatLevel = (int)(((double)(defence + hp) + Math.floor((double)(prayer / 2))) * 0.25D) + 1;
      double melee = (double)(attack + strength) * 0.325D;
      double ranger = Math.floor((double)ranged * 1.5D) * 0.325D;
      double mage = Math.floor((double)magic * 1.5D) * 0.325D;
      if (melee >= ranger && melee >= mage) {
         combatLevel = (int)((double)combatLevel + melee);
      } else if (ranger >= melee && ranger >= mage) {
         combatLevel = (int)((double)combatLevel + ranger);
      } else if (mage >= melee && mage >= ranger) {
         combatLevel = (int)((double)combatLevel + mage);
      }

      return combatLevel;
   }

   public void set(int skill, int newLevel) {
      this.level[skill] = (short)newLevel;
      this.refresh(skill);
   }

   public int drainLevel(int skill, int drain) {
      int drainLeft = drain - this.level[skill];
      if (drainLeft < 0) {
         drainLeft = 0;
      }

      short[] var10000 = this.level;
      var10000[skill] = (short)(var10000[skill] - drain);
      if (this.level[skill] < 0) {
         this.level[skill] = 0;
      }

      this.refresh(skill);
      return drainLeft;
   }

   public int getCombatLevelWithSummoning() {
      return this.getCombatLevel() + this.getSummoningCombatLevel();
   }

   public int getSummoningCombatLevel() {
      return this.getLevelForXp(23) / 8;
   }

   public void drainSummoning(int amt) {
      int level = this.getLevel(23);
      if (level != 0) {
         this.set(23, amt > level ? 0 : level - amt);
      }
   }

   public static int getXPForLevel(int level) {
      int points = 0;
      int output = 0;

      for(int lvl = 1; lvl <= level; ++lvl) {
         points = (int)((double)points + Math.floor((double)lvl + 300.0D * Math.pow(2.0D, (double)lvl / 7.0D)));
         if (lvl >= level) {
            return output;
         }

         output = (int)Math.floor((double)(points / 4));
      }

      return 0;
   }

   public int getLevelForXp(int skill) {
      double exp = this.xp[skill];
      int points = 0;
      int output = false;

      for(int lvl = 1; lvl <= (skill == 24 ? 120 : 99); ++lvl) {
         points = (int)((double)points + Math.floor((double)lvl + 300.0D * Math.pow(2.0D, (double)lvl / 7.0D)));
         int output = (int)Math.floor((double)(points / 4));
         if ((double)(output - 1) >= exp) {
            return lvl;
         }
      }

      return skill == 24 ? 120 : 99;
   }

   public void init() {
      for(int skill = 0; skill < this.level.length; ++skill) {
         this.refresh(skill);
      }

      this.refreshXpCounter();
   }

   private void refreshXpCounter() {
      this.player.getPackets().sendConfig(1801, (int)(this.xpCounter * 10.0D));
   }

   public void resetXpCounter() {
      this.xpCounter = 0.0D;
      this.refreshXpCounter();
   }

   public void refresh(int skill) {
      this.player.getPackets().sendSkillLevel(skill);
   }

   public void addExpNoModifier(int skill, double exp) {
      int oldLevel = this.getLevelForXp(skill);
      double[] var10000 = this.xp;
      var10000[skill] += exp;
      this.level[skill] = (short)this.getLevelForXp(skill);
      int newLevel = this.getLevelForXp(skill);
      int levelDiff = newLevel - oldLevel;
      if (newLevel > oldLevel && (skill == 23 || skill >= 0 && skill <= 6)) {
         this.player.getAppearence().generateAppearenceData();
         if (skill == 3) {
            this.player.heal(levelDiff * 10);
         }
      }

      this.refresh(skill);
   }

   public static String getColorFormattedNameFor(int skillId) {
      return (exp != null && !(exp[skillId] <= 0.0D) ? Utils.StatusColor.TRAINED.getColor() : Utils.StatusColor.UNTRAINED.getColor()) + SKILL_NAME[skillId];
   }

   public void addXp(int skill, double exp, boolean... ignoreParam) {
      if (this.player.getFacade().isExpLocked()) {
         if (this.player.getAttributes().get("gave_lock_notif") == null) {
            this.player.sendMessage("<col=800000>Your experience is locked so you will not receive any experience.");
            this.player.getAttributes().put("gave_lock_notif", true);
         }

      } else {
         this.player.getControllerManager().trackXP(skill, (int)exp);
         boolean ignore = false;
         if (ignoreParam.length > 0 && ignoreParam[0]) {
            ignore = true;
         }

         if (!ignore && this.player.getFacade().getModifiers() != null) {
            switch(skill) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 22:
            }
         }

         int oldLevel = this.getLevelForXp(skill);
         double[] var10000 = this.xp;
         var10000[skill] += exp;
         this.xpCounter += exp;
         this.refreshXpCounter();
         if (this.xp[skill] > 2.0E8D) {
            this.xp[skill] = 2.0E8D;
         }

         int newLevel = this.getLevelForXp(skill);
         int levelDiff = newLevel - oldLevel;
         if (newLevel > oldLevel) {
            short[] var9 = this.level;
            var9[skill] = (short)(var9[skill] + levelDiff);
            if (skill == 3) {
               this.player.heal(levelDiff * 10);
            }

            if (skill == 23 || skill >= 0 && skill <= 6) {
               this.player.getAppearence().generateAppearenceData();
            }
         }

         this.refresh(skill);
      }
   }

   public boolean isMaxed() {
      int maxlevels = 0;

      for(int ji = 0; ji < this.level.length; ++ji) {
         if (this.getLevel(ji) == 99) {
            ++maxlevels;
         }
      }

      if (maxlevels >= 23) {
         return true;
      } else {
         return false;
      }
   }

   public void addSkillXpRefresh(int skill, double xp) {
      double[] var10000 = this.xp;
      var10000[skill] += xp;
      this.level[skill] = (short)this.getLevelForXp(skill);
   }

   public void resetSkillNoRefresh(int skill) {
      this.xp[skill] = 0.0D;
      this.level[skill] = 1;
   }

   public void setXp(int skill, double exp) {
      this.xp[skill] = exp;
      this.refresh(skill);
   }

   public void setStat(int skill, int newLevel) {
      this.level[skill] = (short)newLevel;
      this.xp[skill] = (double)getXPForLevel(newLevel);
   }

   public int getTotalLevel() {
      int level = 0;

      for(int i = 0; i < 25; ++i) {
         level += this.getLevel(i);
      }

      return level;
   }

   public long getTotalExp() {
      int exp = 0;
      double[] var6;
      int var5 = (var6 = this.xp).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         double element = var6[var4];
         exp = (int)((double)exp + element);
      }

      return (long)exp;
   }

   public Item[] getSkillCape(int skill) {
      boolean shouldReceiveTrimmed = this.player.isDonator();
      String capeName = SKILL_NAME[skill];
      if (skill == 22) {
         capeName = "Construct.";
      }

      if (shouldReceiveTrimmed) {
         switch(skill) {
         case 8:
            capeName = "Woodcut.";
         }
      }

      Item[] rewards = new Item[2];
      Item[] element;
      int var6;
      int var7;
      Item[][] var8;
      String name;
      int j;
      if (shouldReceiveTrimmed) {
         var7 = (var8 = Utils.TRIMMED_CAPES).length;

         for(var6 = 0; var6 < var7; ++var6) {
            element = var8[var6];
            name = element[0].getDefinitions().getName().toLowerCase();
            if (name.split(" ")[0].contains(capeName.toLowerCase())) {
               for(j = 0; j < rewards.length; ++j) {
                  rewards[j] = element[j];
               }
            }
         }
      } else {
         var7 = (var8 = Utils.UNTRIMMED_CAPES).length;

         for(var6 = 0; var6 < var7; ++var6) {
            element = var8[var6];
            name = element[0].getDefinitions().getName().toLowerCase();
            if (name.split(" ")[0].contains(capeName.toLowerCase())) {
               for(j = 0; j < rewards.length; ++j) {
                  rewards[j] = element[j];
               }
            }
         }
      }

      return rewards;
   }
}
