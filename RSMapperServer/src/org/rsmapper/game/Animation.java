package org.rsmapper.game;

import java.util.Arrays;
import org.rsmapper.utilities.misc.Utils;

public final class Animation {
   private int[] ids;
   private int speed;

   public Animation(int id) {
      this(id, 0);
   }

   public Animation(int id, int speed) {
      this(id, id, id, id, speed);
   }

   public Animation(int id1, int id2, int id3, int id4, int speed) {
      int[] anims = new int[]{id1, id2, id3, id4};
      int[] var10 = anims;
      int var9 = anims.length;

      for(int var8 = 0; var8 < var9; ++var8) {
         int id = var10[var8];
         if (!Utils.animationExists(id) && id != -1) {
            Arrays.fill(anims, -1);
         }
      }

      this.ids = anims;
      this.speed = speed;
   }

   public int[] getIds() {
      return this.ids;
   }

   public int getSpeed() {
      return this.speed;
   }
}
