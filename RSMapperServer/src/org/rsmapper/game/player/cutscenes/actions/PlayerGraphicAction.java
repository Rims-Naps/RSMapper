package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.Graphics;
import org.rsmapper.game.player.Player;

public class PlayerGraphicAction extends CutsceneAction {
   private Graphics gfx;

   public PlayerGraphicAction(Graphics gfx, int actionDelay) {
      super(-1, actionDelay);
      this.gfx = gfx;
   }

   public void process(Player player, Object[] cache) {
      player.setNextGraphics(this.gfx);
   }
}
