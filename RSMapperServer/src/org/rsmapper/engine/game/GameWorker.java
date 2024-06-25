package org.rsmapper.engine.game;

import java.util.Iterator;
import java.util.stream.Stream;
import org.rsmapper.engine.CoresManager;
import org.rsmapper.game.World;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.tasks.WorldTasksManager;
import org.rsmapper.networking.Session;
import org.rsmapper.utilities.misc.Stopwatch;
import org.rsmapper.utilities.misc.Utils;

public class GameWorker implements Runnable {
   private long delay;
   private static final boolean DEBUGGING = false;

   public GameWorker() {
      Thread.currentThread().setName("Game Worker");
      Thread.currentThread().setPriority(10);
   }

   public final void run() {
      label68:
      while(!CoresManager.shutdown) {
         long currentTime = Utils.currentTimeMillis();

         try {
            StringBuilder b = new StringBuilder();
            Stopwatch w = Stopwatch.start();
            WorldTasksManager.processTasks(b);
            b.append("Tasks took: " + w.elapsed() + "ms\n");
            w = Stopwatch.start();
            new StringBuilder();
            Iterator var7 = World.getPlayers().iterator();

            while(true) {
               Player player;
               do {
                  do {
                     if (!var7.hasNext()) {
                        b.append("Process(Player) took: " + w.elapsed() + "ms\n");
                        w = Stopwatch.start();
                        World.npcs().forEach((n) -> {
                           n.processEntity();
                        });
                        b.append("Process(NPC) took: " + w.elapsed() + "ms\n");
                        w = Stopwatch.start();
                        var7 = World.getPlayers().iterator();

                        while(var7.hasNext()) {
                           player = (Player)var7.next();
                           if (player != null && player.hasStarted() && !player.hasFinished()) {
                              player.getPackets().sendLocalPlayersUpdate();
                              player.getPackets().sendLocalNPCsUpdate();
                           }
                        }

                        b.append("Updating took: " + w.elapsed() + "ms\n");
                        w = Stopwatch.start();
                        ((Stream)World.entities().parallel()).forEach((e) -> {
                           e.resetMasks();
                        });
                        b.append("Reset took: " + w.elapsed() + "ms\n");
                        this.setDelay(Utils.currentTimeMillis() - currentTime);
                        long sleepTime = 600L + currentTime - Utils.currentTimeMillis();
                        if (sleepTime > 0L) {
                           Thread.sleep(sleepTime);
                        }
                        continue label68;
                     }

                     player = (Player)var7.next();
                  } while(player == null);
               } while(!player.hasStarted());

               Session session = player.getSession();
               boolean first = player.isActivated() && !session.getChannel().isWritable();
               boolean second = false;
               if (first || second) {
                  player.finish();
               }

               player.processEntity();
            }
         } catch (Throwable var11) {
            var11.printStackTrace();
         }
      }

   }

   public long getDelay() {
      return this.delay;
   }

   public void setDelay(long delay) {
      this.delay = delay;
      if (delay > 600L) {
         System.err.println("Dangerous game cycle: " + delay + "ms");
      }

   }
}
