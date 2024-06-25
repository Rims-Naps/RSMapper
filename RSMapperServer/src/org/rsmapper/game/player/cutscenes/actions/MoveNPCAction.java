package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.WorldTile;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.cutscenes.Cutscene;

public class MoveNPCAction extends CutsceneAction {
   private int x;
   private int y;
   private int plane;
   private int movementType;

   public MoveNPCAction(int cachedObjectIndex, int x, int y, boolean run, int actionDelay) {
      this(cachedObjectIndex, x, y, -1, run ? 2 : 1, actionDelay);
   }

   public MoveNPCAction(int cachedObjectIndex, int x, int y, int plane, int movementType, int actionDelay) {
      super(cachedObjectIndex, actionDelay);
      this.x = x;
      this.y = y;
      this.plane = plane;
      this.movementType = movementType;
   }

   public void process(Player player, Object[] cache) {
      NPC npc = (NPC)cache[this.getCachedObjectIndex()];
      Cutscene scene = (Cutscene)cache[0];
      if (this.movementType == 127) {
         npc.setNextWorldTile(new WorldTile(scene.getBaseX() + this.x, scene.getBaseY() + this.y, this.plane));
      } else {
         npc.setRun(this.movementType == 2);
         npc.addWalkSteps(scene.getBaseX() + this.x, scene.getBaseY() + this.y);
      }
   }
}
