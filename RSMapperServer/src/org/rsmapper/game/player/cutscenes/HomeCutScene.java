package org.rsmapper.game.player.cutscenes;

import java.util.ArrayList;
import org.rsmapper.game.Animation;
import org.rsmapper.game.Graphics;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.cutscenes.actions.ConstructMapAction;
import org.rsmapper.game.player.cutscenes.actions.CreateNPCAction;
import org.rsmapper.game.player.cutscenes.actions.CutsceneAction;
import org.rsmapper.game.player.cutscenes.actions.DestroyCachedObjectAction;
import org.rsmapper.game.player.cutscenes.actions.LookCameraAction;
import org.rsmapper.game.player.cutscenes.actions.MoveNPCAction;
import org.rsmapper.game.player.cutscenes.actions.MovePlayerAction;
import org.rsmapper.game.player.cutscenes.actions.NPCAnimationAction;
import org.rsmapper.game.player.cutscenes.actions.NPCFaceTileAction;
import org.rsmapper.game.player.cutscenes.actions.NPCForceTalkAction;
import org.rsmapper.game.player.cutscenes.actions.NPCGraphicAction;
import org.rsmapper.game.player.cutscenes.actions.PlayerAnimationAction;
import org.rsmapper.game.player.cutscenes.actions.PlayerFaceTileAction;
import org.rsmapper.game.player.cutscenes.actions.PlayerForceTalkAction;
import org.rsmapper.game.player.cutscenes.actions.PlayerGraphicAction;
import org.rsmapper.game.player.cutscenes.actions.PlayerMusicEffectAction;
import org.rsmapper.game.player.cutscenes.actions.PosCameraAction;

public class HomeCutScene extends Cutscene {
   private static int GUTHIX = 1;
   private static int GUARD1 = 2;
   private static int GUARD2 = 3;

   public boolean hiddenMinimap() {
      return true;
   }

   public CutsceneAction[] getActions(Player player) {
      ArrayList<CutsceneAction> actionsList = new ArrayList();
      actionsList.add(new ConstructMapAction(360, 482, 3, 3));
      actionsList.add(new PlayerMusicEffectAction(215, -1));
      actionsList.add(new MovePlayerAction(10, 0, 0, 127, 0));
      actionsList.add(new LookCameraAction(10, 8, 1000, -1));
      actionsList.add(new PosCameraAction(10, 0, 2000, 3));
      actionsList.add(new CreateNPCAction(GUTHIX, 8008, 10, 6, 0, -1));
      actionsList.add(new NPCFaceTileAction(GUTHIX, 10, 5, -1));
      actionsList.add(new NPCGraphicAction(GUTHIX, new Graphics(184), 2));
      actionsList.add(new NPCForceTalkAction(GUTHIX, "Holy Hell", 3));
      actionsList.add(new NPCForceTalkAction(GUTHIX, "ZENITH!", -1));
      actionsList.add(new NPCAnimationAction(GUTHIX, new Animation(2108), 3));
      actionsList.add(new NPCFaceTileAction(GUTHIX, 9, 6, -1));
      actionsList.add(new MovePlayerAction(10, 6, 0, 127, -1));
      actionsList.add(new PlayerFaceTileAction(9, 5, -1));
      actionsList.add(new PlayerAnimationAction(new Animation(2111), -1));
      actionsList.add(new PlayerGraphicAction(new Graphics(184), 1));
      actionsList.add(new DestroyCachedObjectAction(GUTHIX, 0));
      actionsList.add(new PlayerFaceTileAction(9, 7, 1));
      actionsList.add(new PlayerFaceTileAction(8, 6, 1));
      actionsList.add(new PlayerFaceTileAction(10, 6, 1));
      actionsList.add(new PlayerForceTalkAction("Whoa!", 3));
      actionsList.add(new PlayerAnimationAction(new Animation(857), -1));
      actionsList.add(new PlayerForceTalkAction("Where am I?", 2));
      actionsList.add(new CreateNPCAction(GUARD1, 296, 3, 7, 0, -1));
      actionsList.add(new CreateNPCAction(GUARD2, 298, 3, 5, 0, -1));
      actionsList.add(new MoveNPCAction(GUARD1, 9, 7, false, 0));
      actionsList.add(new MoveNPCAction(GUARD2, 9, 5, false, 2));
      actionsList.add(new NPCForceTalkAction(GUARD1, "Noob, What are you Doing Here?!?!", 2));
      actionsList.add(new PlayerForceTalkAction("Doing Where?!", 2));
      actionsList.add(new NPCForceTalkAction(GUARD1, "You must not know, your on Zenith, its da best!", 2));
      actionsList.add(new NPCForceTalkAction(GUARD2, "I cant believe he doesnt know!!!!!", 3));
      actionsList.add(new NPCForceTalkAction(GUARD1, "Lets Bring him to the home, so he can find stuff!", 3));
      actionsList.add(new PlayerForceTalkAction("HOME!?!?!?!?", 2));
      actionsList.add(new NPCForceTalkAction(GUARD2, "He is Definetly a noob.", 2));
      actionsList.add(new NPCForceTalkAction(GUARD2, "Its okay, he will come to like this server!", 2));
      actionsList.add(new MoveNPCAction(GUARD1, 15, 7, false, -1));
      actionsList.add(new MovePlayerAction(15, 6, false, -1));
      actionsList.add(new MoveNPCAction(GUARD2, 15, 5, false, 0));
      actionsList.add(new ConstructMapAction(734, 590, 6, 9));
      actionsList.add(new PlayerMusicEffectAction(214, -1));
      actionsList.add(new CreateNPCAction(GUARD1, 296, 15, 30, 0, -1));
      actionsList.add(new CreateNPCAction(GUARD2, 298, 17, 30, 0, -1));
      actionsList.add(new MovePlayerAction(16, 29, 0, 127, 0));
      actionsList.add(new PosCameraAction(14, 5, 4000, -1));
      actionsList.add(new LookCameraAction(14, 35, 2000, -1));
      actionsList.add(new MovePlayerAction(16, 39, false, -1));
      actionsList.add(new MoveNPCAction(GUARD1, 15, 40, false, -1));
      actionsList.add(new MoveNPCAction(GUARD2, 17, 40, false, -1));
      actionsList.add(new PosCameraAction(14, 35, 3000, 6, 6, 10));
      return (CutsceneAction[])actionsList.toArray(new CutsceneAction[actionsList.size()]);
   }
}
