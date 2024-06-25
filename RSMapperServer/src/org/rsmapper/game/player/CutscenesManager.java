package org.rsmapper.game.player;

import org.rsmapper.game.player.cutscenes.Cutscene;
import org.rsmapper.game.player.cutscenes.CutscenesHandler;

public final class CutscenesManager {
   private Player player;
   private Cutscene cutscene;

   public CutscenesManager(Player player) {
      this.player = player;
   }

   public void process() {
      if (this.cutscene != null) {
         if (!this.cutscene.process(this.player)) {
            this.cutscene = null;
         }
      }
   }

   public void logout() {
      if (this.hasCutscene()) {
         this.cutscene.logout(this.player);
      }

   }

   public boolean hasCutscene() {
      return this.cutscene != null;
   }

   public boolean play(Object key) {
      if (this.hasCutscene()) {
         return false;
      } else {
         Cutscene cutscene = (Cutscene)(key instanceof Cutscene ? key : CutscenesHandler.getCutscene(key));
         if (cutscene == null) {
            return false;
         } else {
            cutscene.createCache(this.player);
            this.cutscene = cutscene;
            return true;
         }
      }
   }
}
