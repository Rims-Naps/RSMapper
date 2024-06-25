package org.rsmapper.game.player.actions;

import org.rsmapper.game.player.Player;

public abstract class Action {
   public abstract boolean start(Player var1);

   public abstract boolean process(Player var1);

   public abstract int processWithDelay(Player var1);

   public abstract void stop(Player var1);

   protected final void setActionDelay(Player player, int delay) {
      player.getActionManager().setActionDelay(delay);
   }
}
