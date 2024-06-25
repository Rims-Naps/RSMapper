package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.WorldTile;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.cutscenes.Cutscene;

public class MovePlayerAction extends CutsceneAction {
   private int x;
   private int y;
   private int plane;
   private int movementType;

   public MovePlayerAction(int x, int y, boolean run, int actionDelay) {
      this(x, y, -1, run ? 2 : 1, actionDelay);
   }

   public MovePlayerAction(int x, int y, int plane, int movementType, int actionDelay) {
      super(-1, actionDelay);
      this.x = x;
      this.y = y;
      this.plane = plane;
      this.movementType = movementType;
   }

   public void process(Player player, Object[] cache) {
      Cutscene scene = (Cutscene)cache[0];
      if (this.movementType == 127) {
         player.setNextWorldTile(new WorldTile(scene.getBaseX() + this.x, scene.getBaseY() + this.y, this.plane));
      } else {
         player.setRun(this.movementType == 2);
         player.addWalkSteps(scene.getBaseX() + this.x, scene.getBaseY() + this.y);
      }
   }
}
