package org.rsmapper.game.player.cutscenes;

import java.util.ArrayList;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.cutscenes.actions.CutsceneAction;
import org.rsmapper.game.player.cutscenes.actions.LookCameraAction;
import org.rsmapper.game.player.cutscenes.actions.PosCameraAction;

public class EdgeWilderness extends Cutscene {
   public CutsceneAction[] getActions(Player player) {
      ArrayList<CutsceneAction> actionsList = new ArrayList();
      actionsList.add(new PosCameraAction(80, 75, 5000, 6, 6, -1));
      actionsList.add(new LookCameraAction(30, 75, 1000, 6, 6, 10));
      actionsList.add(new PosCameraAction(30, 75, 5000, 3, 3, 10));
      return (CutsceneAction[])actionsList.toArray(new CutsceneAction[actionsList.size()]);
   }

   public boolean hiddenMinimap() {
      return true;
   }
}
