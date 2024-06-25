package org.rsmapper.game.player.cutscenes;

import java.util.ArrayList;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.cutscenes.actions.CutsceneAction;
import org.rsmapper.game.player.cutscenes.actions.LookCameraAction;
import org.rsmapper.game.player.cutscenes.actions.PosCameraAction;

public class HomeGazer extends Cutscene {
   public boolean hiddenMinimap() {
      return false;
   }

   public CutsceneAction[] getActions(Player player) {
      ArrayList<CutsceneAction> actionsList = new ArrayList();
      actionsList.add(new PosCameraAction(30, 75, 5000, 0, 3, -1));
      actionsList.add(new LookCameraAction(30, -75, 1000, 0, 3, 6));
      return (CutsceneAction[])actionsList.toArray(new CutsceneAction[actionsList.size()]);
   }
}
