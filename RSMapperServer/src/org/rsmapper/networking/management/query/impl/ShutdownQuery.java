package org.rsmapper.networking.management.query.impl;

import java.util.Iterator;
import org.rsmapper.game.World;
import org.rsmapper.game.player.Player;
import org.rsmapper.networking.management.query.ServerQuery;

public class ShutdownQuery extends ServerQuery {
   public String[] getQueryListeners() {
      return new String[]{"shutdown"};
   }

   public String getDescription() {
      return "Shuts down the game server";
   }

   public String onRequest() {
      Iterator var2 = World.getPlayers().iterator();

      while(var2.hasNext()) {
         Player player = (Player)var2.next();
         if (player != null) {
            player.realFinish();
         }
      }

      System.exit(-1);
      return "Kicked all players: " + World.getPlayers();
   }
}
