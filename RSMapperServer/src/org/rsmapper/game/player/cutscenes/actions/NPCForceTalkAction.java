package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.ForceTalk;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;

public class NPCForceTalkAction extends CutsceneAction {
   private String text;

   public NPCForceTalkAction(int cachedObjectIndex, String text, int actionDelay) {
      super(cachedObjectIndex, actionDelay);
      this.text = text;
   }

   public void process(Player player, Object[] cache) {
      NPC npc = (NPC)cache[this.getCachedObjectIndex()];
      npc.setNextForceTalk(new ForceTalk(this.text));
   }
}
