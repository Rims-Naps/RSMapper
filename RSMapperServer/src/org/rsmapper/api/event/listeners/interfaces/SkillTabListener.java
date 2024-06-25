package org.rsmapper.api.event.listeners.interfaces;

import org.rsmapper.api.event.EventListener;
import org.rsmapper.game.ForceTalk;
import org.rsmapper.game.WorldObject;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.Skills;

public class SkillTabListener extends EventListener {
   public int[] getEventIds() {
      return new int[]{320};
   }

   public boolean handleButtonClick(Player player, int interfaceId, int buttonId, int packetId, int slotId, int itemId) {
      int skillId = this.getSkillId(buttonId);
      switch(packetId) {
      case 52:
         return true;
      case 61:
         player.stopAll();
         int lvlupSkill = true;
         int skillMenu = true;
         switch(buttonId) {
         case 11:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[2]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 2);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 20);
            }

            return false;
         case 19:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[16]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 8);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 65);
            }

            return false;
         case 28:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[1]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 5);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 40);
            }

            return false;
         case 36:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[15]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 9);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 75);
            }

            return false;
         case 44:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[10]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 15);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 120);
            }

            return false;
         case 52:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[4]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 3);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 30);
            }

            return false;
         case 60:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[17]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 10);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 80);
            }

            return false;
         case 68:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[7]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 16);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 641);
            }

            return false;
         case 76:
            if (player.getTemporaryAttributes().remove("leveledUp[5]") != Boolean.TRUE) {
               skillMenu = true;
               player.getPackets().sendConfig(965, 7);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 60);
            }

            return false;
         case 84:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[12]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 11);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 90);
            }

            return false;
         case 93:
            if (player.getTemporaryAttributes().remove("leveledUp[6]") != Boolean.TRUE) {
               skillMenu = true;
               player.getPackets().sendConfig(965, 4);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 33);
            }

            return false;
         case 101:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[9]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 19);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 665);
            }

            return false;
         case 110:
            if (player.getTemporaryAttributes().remove("leveledUp[20]") != Boolean.TRUE) {
               skillMenu = true;
               player.getPackets().sendConfig(965, 12);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 100);
            }

            return false;
         case 118:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[18]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 20);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 673);
            }

            return false;
         case 126:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[19]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 21);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 681);
            }

            return false;
         case 134:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[21]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 22);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 698);
            }

            return false;
         case 142:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[22]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 23);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 689);
            }

            return false;
         case 150:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[23]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 24);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 705);
            }

            return false;
         case 158:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[24]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 25);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 705);
            }

            return false;
         case 165:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[8]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 18);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 660);
            }

            return false;
         case 172:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[11]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 17);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 649);
            }

            return false;
         case 179:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[13]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 14);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 115);
            }

            return false;
         case 186:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[14]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 13);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 110);
            }

            return false;
         case 193:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[3]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 6);
            } else {
               lvlupSkill = true;
               player.getPackets().sendConfig(1230, 50);
            }

            return false;
         case 200:
            skillMenu = true;
            if (player.getTemporaryAttributes().remove("leveledUp[0]") != Boolean.TRUE) {
               player.getPackets().sendConfig(965, 1);
            } else {
               lvlupSkill = false;
               player.getPackets().sendConfig(1230, 10);
            }

            return false;
         default:
            return false;
         }
      case 64:
         player.setNextForceTalk(new ForceTalk("<col=0066CC>My " + Skills.SKILL_NAME[skillId] + " level is: " + player.getSkills().getLevelForXp(skillId) + ".</col>"));
      }

      return false;
   }

   private int getSkillId(int buttonId) {
      switch(buttonId) {
      case 11:
         return 2;
      case 19:
         return 16;
      case 28:
         return 1;
      case 36:
         return 15;
      case 44:
         return 10;
      case 52:
         return 4;
      case 60:
         return 17;
      case 68:
         return 7;
      case 76:
         return 5;
      case 84:
         return 12;
      case 93:
         return 6;
      case 101:
         return 9;
      case 110:
         return 20;
      case 118:
         return 18;
      case 126:
         return 19;
      case 134:
         return 22;
      case 142:
         return 21;
      case 150:
         return 23;
      case 158:
         return 24;
      case 165:
         return 8;
      case 172:
         return 11;
      case 179:
         return 13;
      case 186:
         return 14;
      case 193:
         return 3;
      case 200:
         return 0;
      default:
         System.out.println(buttonId);
         return 0;
      }
   }

   public boolean handleObjectClick(Player player, int objectId, WorldObject worldObject, WorldTile tile, EventListener.ClickOption option) {
      return false;
   }

   public boolean handleNPCClick(Player player, NPC npc, EventListener.ClickOption option) {
      return false;
   }

   public boolean handleItemClick(Player player, Item item, EventListener.ClickOption option) {
      return false;
   }
}
