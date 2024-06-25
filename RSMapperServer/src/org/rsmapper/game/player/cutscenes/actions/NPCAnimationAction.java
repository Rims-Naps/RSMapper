package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.Animation;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;

public class NPCAnimationAction extends CutsceneAction {
   private Animation anim;

   public NPCAnimationAction(int cachedObjectIndex, Animation anim, int actionDelay) {
      super(cachedObjectIndex, actionDelay);
      this.anim = anim;
   }

   public void process(Player player, Object[] cache) {
      NPC npc = (NPC)cache[this.getCachedObjectIndex()];
      npc.setNextAnimation(this.anim);
   }
}
