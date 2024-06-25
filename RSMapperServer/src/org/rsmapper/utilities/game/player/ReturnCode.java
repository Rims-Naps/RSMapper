package org.rsmapper.utilities.game.player;

public enum ReturnCode {
   INVALID_USERNAME_OR_PASSWORD(3),
   YOUR_ACCOUNT_HAS_BEEN_DISABLED(4),
   YOUR_ACCOUNT_IS_STILL_ONLINE(5),
   HAS_BEEN_UPDATED(6),
   WORLD_IS_FULL(7),
   UNABLE_TO_CONNECT_LOGINSERVER(8),
   LOGIN_LIMIT_EXCEEDED(9),
   INVALID_SESSION_ID(10),
   SERVER_IS_UPDATING(14),
   NULLED_ACCOUNT(20),
   UNREGISTERED_FORUM_ACCOUNT(26),
   INVALID_USERNAME(27),
   DATABASE_CONNECTION_ERROR(35);

   private final int opcode;

   private ReturnCode(int opcode) {
      this.opcode = opcode;
   }

   public int getOpcode() {
      return this.opcode;
   }
}
