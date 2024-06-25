package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.Animation;
import org.rsmapper.game.player.Player;

public class PlayerAnimationAction extends CutsceneAction {
   private Animation anim;

   public PlayerAnimationAction(Animation anim, int actionDelay) {
      super(-1, actionDelay);
      this.anim = anim;
   }

   public void process(Player player, Object[] cache) {
      player.setNextAnimation(this.anim);
   }
}
