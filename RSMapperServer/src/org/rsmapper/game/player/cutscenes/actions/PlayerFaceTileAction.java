package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.WorldTile;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.cutscenes.Cutscene;

public class PlayerFaceTileAction extends CutsceneAction {
   private int x;
   private int y;

   public PlayerFaceTileAction(int x, int y, int actionDelay) {
      super(-1, actionDelay);
      this.x = x;
      this.y = y;
   }

   public void process(Player player, Object[] cache) {
      Cutscene scene = (Cutscene)cache[0];
      player.setNextFaceWorldTile(new WorldTile(scene.getBaseX() + this.x, scene.getBaseY() + this.y, player.getPlane()));
   }
}
