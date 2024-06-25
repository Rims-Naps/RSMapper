package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.Graphics;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;

public class NPCGraphicAction extends CutsceneAction {
   private Graphics gfx;

   public NPCGraphicAction(int cachedObjectIndex, Graphics gfx, int actionDelay) {
      super(cachedObjectIndex, actionDelay);
      this.gfx = gfx;
   }

   public void process(Player player, Object[] cache) {
      NPC npc = (NPC)cache[this.getCachedObjectIndex()];
      npc.setNextGraphics(this.gfx);
   }
}
