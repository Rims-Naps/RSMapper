package org.rsmapper.game.player.content;

import java.util.TimerTask;
import org.rsmapper.engine.CoresManager;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTask;
import org.rsmapper.game.tasks.WorldTasksManager;
import org.rsmapper.utilities.misc.Utils;

public final class FadingScreen {
   private FadingScreen() {
   }

   public static void fade(Player player, long fadeTime, Runnable event) {
      unfade(player, fade(player, fadeTime), event);
   }

   public static void fade(Player player, Runnable event) {
      unfade(player, fade(player), event);
   }

   public static void unfade(Player player, long startTime, Runnable event) {
      unfade(player, 2500L, startTime, event);
   }

   public static void unfade(final Player player, long endTime, long startTime, final Runnable event) {
      long leftTime = endTime - (Utils.currentTimeMillis() - startTime);
      if (leftTime > 0L) {
         CoresManager.fastExecutor.schedule(new TimerTask() {
            public void run() {
               try {
                  FadingScreen.unfade(player, event);
               } catch (Throwable var2) {
                  var2.printStackTrace();
               }

            }
         }, leftTime);
      } else {
         unfade(player, event);
      }

   }

   public static void unfade(final Player player, Runnable event) {
      event.run();
      WorldTasksManager.schedule(new WorldTask() {
         public void run() {
            player.getInterfaceManager().setFadingInterface(170);
            CoresManager.fastExecutor.schedule(new TimerTask() {
               public void run() {
                  try {
                     player.getInterfaceManager().closeFadingInterface();
                  } catch (Throwable var2) {
                     var2.printStackTrace();
                  }

               }
            }, 2000L);
         }
      });
   }

   public static long fade(Player player, long fadeTime) {
      player.getInterfaceManager().setFadingInterface(115);
      return Utils.currentTimeMillis() + fadeTime;
   }

   public static long fade(Player player) {
      return fade(player, 0L);
   }
}
