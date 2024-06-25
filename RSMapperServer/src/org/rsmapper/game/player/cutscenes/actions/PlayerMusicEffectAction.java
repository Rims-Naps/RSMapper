package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.player.Player;

public class PlayerMusicEffectAction extends CutsceneAction {
   private int id;

   public PlayerMusicEffectAction(int id, int actionDelay) {
      super(-1, actionDelay);
      this.id = id;
   }

   public void process(Player player, Object[] cache) {
      player.getPackets().sendMusicEffect(this.id);
   }
}
