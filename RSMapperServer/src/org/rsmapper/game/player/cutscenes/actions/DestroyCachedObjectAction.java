package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.cutscenes.Cutscene;

public class DestroyCachedObjectAction extends CutsceneAction {
   public DestroyCachedObjectAction(int cachedObjectIndex, int actionDelay) {
      super(cachedObjectIndex, actionDelay);
   }

   public void process(Player player, Object[] cache) {
      Cutscene scene = (Cutscene)cache[0];
      scene.destroyCache(cache[this.getCachedObjectIndex()]);
   }
}
