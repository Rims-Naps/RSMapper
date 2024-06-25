package org.rsmapper.engine.service.login;

import org.rsmapper.Constants;
import org.rsmapper.game.World;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.player.Player;
import org.rsmapper.networking.Session;
import org.rsmapper.utilities.game.player.ReturnCode;
import org.rsmapper.utilities.misc.Utils;
import org.rsmapper.utilities.security.IsaacKeyPair;

public class LoginServiceTask {
   private final String username;
   private final String password;
   private final String macAddress;
   private int x;
   private int y;
   private int plane;
   private final Session session;
   private final IsaacKeyPair isaacKeyPair;
   private final int[] screenInformation;

   public LoginServiceTask(String username, String password, String macAddress, Session session, IsaacKeyPair isaacKeyPair, int[] screenInformation, int x, int y, int plane) {
      this.username = username;
      this.password = password;
      this.macAddress = macAddress;
      this.session = session;
      this.isaacKeyPair = isaacKeyPair;
      this.screenInformation = screenInformation;
      this.x = x;
      this.y = y;
      this.plane = plane;
   }

   public void execute() {
      if (this.username.length() >= 3 && this.username.length() <= 12 && !Utils.invalidAccountName(this.username)) {
         if (World.containsPlayer(this.username)) {
            this.session.getLoginPackets().sendClientPacket(ReturnCode.YOUR_ACCOUNT_IS_STILL_ONLINE);
         } else {
            boolean newPlayer = false;
            Constants.HOME_TILE = new WorldTile(this.x, this.y, this.plane);
            Player player = new Player(this.password);
            newPlayer = true;
            player.init(this.session, this.username, this.screenInformation[0], this.screenInformation[1], this.screenInformation[2], this.isaacKeyPair, this.macAddress);
            this.session.getLoginPackets().sendLoginDetails(player);
            this.session.setDecoder(3, player);
            this.session.setEncoder(2, player);
            player.start(System.currentTimeMillis());
         }
      } else {
         this.session.getLoginPackets().sendClientPacket(ReturnCode.INVALID_USERNAME);
      }
   }
}
