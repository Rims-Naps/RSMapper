package org.rsmapper.networking.management.query.impl;

import org.rsmapper.game.World;
import org.rsmapper.game.player.Player;
import org.rsmapper.networking.management.query.ServerQuery;

public class KickQuery extends ServerQuery {
   public String[] getQueryListeners() {
      return new String[]{"kick"};
   }

   public String getDescription() {
      return "Kicks a player from the server";
   }

   public String onRequest() {
      String[] split = this.getQuery().split(" ");
      String name = "";

      for(int i = 0; i < split.length; ++i) {
         if (i != 0) {
            char[] var7;
            int var6 = (var7 = split[i].toCharArray()).length;

            for(int var5 = 0; var5 < var6; ++var5) {
               char c = var7[var5];
               name = name + c;
            }
         }
      }

      Player target = World.getPlayer(name);
      if (target == null) {
         return "No such player " + name + "..";
      } else {
         target.forceLogout();
         return "Successfully booted " + name;
      }
   }
}
