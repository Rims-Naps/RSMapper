package org.rsmapper.game.player;

import org.rsmapper.game.Entity;

public class HintIconsManager {
   private Player player;
   private HintIcon[] loadedIcons;

   public HintIconsManager(Player p) {
      this.player = p;
      this.loadedIcons = new HintIcon[7];
   }

   public int addHintIcon(Entity target, int arrowType, int modelId, boolean saveIcon) {
      int index = saveIcon ? this.getFreeIndex() : 7;
      if (index != -1) {
         HintIcon icon = new HintIcon(target.getIndex(), target instanceof Player ? 10 : 1, arrowType, modelId, index);
         this.player.getPackets().sendHintIcon(icon);
         if (saveIcon) {
            this.loadedIcons[index] = icon;
         }
      }

      return index;
   }

   public int addHintIcon(int coordX, int coordY, int height, int distanceFromFloor, int direction, int arrowType, int modelId, boolean saveIcon) {
      int index = saveIcon ? this.getFreeIndex() : 7;
      if (index != -1) {
         if (direction < 2 || direction > 6) {
            direction = 2;
         }

         HintIcon icon = new HintIcon(coordX, coordY, height, distanceFromFloor, direction, arrowType, modelId, index);
         this.player.getPackets().sendHintIcon(icon);
         if (saveIcon) {
            this.loadedIcons[index] = icon;
         }
      }

      return index;
   }

   public int addHintIcon(int modelId, boolean saveIcon) {
      int index = saveIcon ? this.getFreeIndex() : 7;
      if (index != -1) {
         HintIcon icon = new HintIcon(8, modelId, index);
         this.player.getPackets().sendHintIcon(icon);
         if (saveIcon) {
            this.loadedIcons[index] = icon;
         }
      }

      return index;
   }

   public void removeUnsavedHintIcon() {
      this.player.getPackets().sendHintIcon(new HintIcon());
   }

   public boolean reloadHintIcon(int index) {
      if (index >= this.loadedIcons.length) {
         return false;
      } else if (this.loadedIcons[index] == null) {
         return false;
      } else {
         this.player.getPackets().sendHintIcon(this.loadedIcons[index]);
         return true;
      }
   }

   public boolean removeHintIcon(int index) {
      if (index == 7) {
         this.removeUnsavedHintIcon();
         return true;
      } else if (index >= this.loadedIcons.length) {
         return false;
      } else if (this.loadedIcons[index] == null) {
         return false;
      } else {
         this.loadedIcons[index].setTargetType(0);
         this.player.getPackets().sendHintIcon(this.loadedIcons[index]);
         this.loadedIcons[index] = null;
         return true;
      }
   }

   public void removeAll() {
      for(int index = 0; index < this.loadedIcons.length; ++index) {
         if (this.loadedIcons[index] != null) {
            this.loadedIcons[index].setTargetType(0);
            this.player.getPackets().sendHintIcon(this.loadedIcons[index]);
            this.loadedIcons[index] = null;
         }
      }

   }

   public boolean isEmpty() {
      HintIcon[] var4;
      int var3 = (var4 = this.loadedIcons).length;

      for(int var2 = 0; var2 < var3; ++var2) {
         HintIcon loadedIcon = var4[var2];
         if (loadedIcon != null) {
            return false;
         }
      }

      return true;
   }

   private int getFreeIndex() {
      for(int index = 0; index < this.loadedIcons.length; ++index) {
         if (this.loadedIcons[index] == null) {
            return index;
         }
      }

      return -1;
   }
}
