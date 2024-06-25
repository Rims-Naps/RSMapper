package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.player.Player;

public abstract class CutsceneAction {
   private int actionDelay;
   private int cachedObjectIndex;

   public CutsceneAction(int cachedObjectIndex, int actionDelay) {
      this.cachedObjectIndex = cachedObjectIndex;
      this.actionDelay = actionDelay;
   }

   public int getActionDelay() {
      return this.actionDelay;
   }

   public int getCachedObjectIndex() {
      return this.cachedObjectIndex;
   }

   public abstract void process(Player var1, Object[] var2);
}
