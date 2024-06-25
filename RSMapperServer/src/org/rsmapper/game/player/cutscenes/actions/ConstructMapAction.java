package org.rsmapper.game.player.cutscenes.actions;

import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.cutscenes.Cutscene;

public class ConstructMapAction extends CutsceneAction {
   private int baseChunkX;
   private int baseChunkY;
   private int widthChunks;
   private int heightChunks;

   public ConstructMapAction(int baseChunkX, int baseChunkY, int widthChunks, int heightChunks) {
      super(-1, -1);
      this.baseChunkX = baseChunkX;
      this.baseChunkY = baseChunkY;
      this.widthChunks = widthChunks;
      this.heightChunks = heightChunks;
   }

   public void process(Player player, Object[] cache) {
      Cutscene scene = (Cutscene)cache[0];
      scene.constructArea(player, this.baseChunkX, this.baseChunkY, this.widthChunks, this.heightChunks);
   }
}
