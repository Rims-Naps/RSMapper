package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.ForceTalk;
import org.rsmapper.game.player.Player;

public class PlayerForceTalkAction extends CutsceneAction {
   private String text;

   public PlayerForceTalkAction(String text, int actionDelay) {
      super(-1, actionDelay);
      this.text = text;
   }

   public void process(Player player, Object[] cache) {
      player.setNextForceTalk(new ForceTalk(this.text));
   }
}
