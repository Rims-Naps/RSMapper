package org.rsmapper.game.player.cutscenes;

import java.util.ArrayList;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.cutscenes.actions.CutsceneAction;
import org.rsmapper.game.player.cutscenes.actions.LookCameraAction;
import org.rsmapper.game.player.cutscenes.actions.PosCameraAction;

public class TowersPkCutscene extends Cutscene {
   public CutsceneAction[] getActions(Player player) {
      ArrayList<CutsceneAction> actionsList = new ArrayList();
      actionsList.add(new PosCameraAction(getX(player, player.getX() - 5), getY(player, player.getY() + 7), 8000, 6, 6, -1));
      actionsList.add(new LookCameraAction(getX(player, player.getX()), getY(player, player.getY() + 7), 6000, 6, 6, 10));
      return (CutsceneAction[])actionsList.toArray(new CutsceneAction[actionsList.size()]);
   }

   public boolean hiddenMinimap() {
      return true;
   }
}
