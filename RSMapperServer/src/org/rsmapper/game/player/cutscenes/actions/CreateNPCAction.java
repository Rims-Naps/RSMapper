package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.World;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.cutscenes.Cutscene;

public class CreateNPCAction extends CutsceneAction {
   private int id;
   private int x;
   private int y;
   private int plane;

   public CreateNPCAction(int cachedObjectIndex, int id, int x, int y, int plane, int actionDelay) {
      super(cachedObjectIndex, actionDelay);
      this.id = id;
      this.x = x;
      this.y = y;
      this.plane = plane;
   }

   public void process(Player player, Object[] cache) {
      Cutscene scene = (Cutscene)cache[0];
      if (cache[this.getCachedObjectIndex()] != null) {
         scene.destroyCache(cache[this.getCachedObjectIndex()]);
      }

      NPC npc = (NPC)(cache[this.getCachedObjectIndex()] = World.spawnNPC(this.id, new WorldTile(scene.getBaseX() + this.x, scene.getBaseY() + this.y, this.plane), -1, true, true));
      npc.setRandomWalk(false);
   }
}
