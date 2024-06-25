package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.WorldTile;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.cutscenes.Cutscene;

public class NPCFaceTileAction extends CutsceneAction {
   private int x;
   private int y;

   public NPCFaceTileAction(int cachedObjectIndex, int x, int y, int actionDelay) {
      super(cachedObjectIndex, actionDelay);
      this.x = x;
      this.y = y;
   }

   public void process(Player player, Object[] cache) {
      Cutscene scene = (Cutscene)cache[0];
      NPC npc = (NPC)cache[this.getCachedObjectIndex()];
      npc.setNextFaceWorldTile(new WorldTile(scene.getBaseX() + this.x, scene.getBaseY() + this.y, npc.getPlane()));
   }
}
