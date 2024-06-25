package org.rsmapper.game.player.content;

import org.rsmapper.game.Entity;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;
import org.rsmapper.utilities.misc.Utils;

public final class Combat {
   public static boolean hasAntiDragProtection(Entity target) {
      if (target instanceof NPC) {
         return false;
      } else {
         Player p2 = (Player)target;
         int shieldId = p2.getEquipment().getShieldId();
         return shieldId == 1540 || shieldId == 11283 || shieldId == 11284;
      }
   }

   public static int getDefenceEmote(Entity target) {
      return 424;
   }

   private Combat() {
   }

   public static boolean rollHit(double att, double def) {
      if (att < 0.0D) {
         return false;
      } else if (def < 0.0D) {
         return true;
      } else {
         int total = (int)(att + def);
         if (total <= 0) {
            total = 1;
         }

         return (double)Utils.random(total) >= def;
      }
   }
}
