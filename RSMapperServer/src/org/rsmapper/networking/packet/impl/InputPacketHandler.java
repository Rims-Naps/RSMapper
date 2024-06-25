package org.rsmapper.networking.packet.impl;

import org.rsmapper.api.input.IntegerInputAction;
import org.rsmapper.api.input.StringInputAction;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.Skills;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;

@PacketInformation(
   listeners = "3,59,7"
)
public class InputPacketHandler extends PacketHandler {
   private static final int ENTER_INTEGER_PACKET = 3;
   private static final int ENTER_STRING_PACKET = 59;
   private static final int ENTER_LONG_STRING_PACKET = 7;

   public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
      switch(packetId) {
      case 3:
         this.handleIntegerInput(player, packetId, length, stream);
         break;
      case 7:
         String value = stream.readString();
         if (player.getTemporaryAttributes().get("long_string_input_action") != null) {
            StringInputAction action = (StringInputAction)player.getTemporaryAttributes().remove("long_string_input_action");
            action.handle(value);
            return;
         }
         break;
      case 59:
         this.handleStringInput(player, packetId, length, stream);
      }

   }

   private void handleIntegerInput(Player player, Integer packetId, Integer length, InputStream stream) {
      if (player.isRunning() && !player.isDead()) {
         int value = stream.readInt();
         if (player.getTemporaryAttributes().get("integer_input_action") != null) {
            IntegerInputAction action = (IntegerInputAction)player.getTemporaryAttributes().remove("integer_input_action");
            action.handle(value);
         } else {
            Integer bob_item_X_Slot;
            if ((!player.getInterfaceManager().containsInterface(762) || !player.getInterfaceManager().containsInterface(763)) && !player.getInterfaceManager().containsInterface(11)) {
               if (player.getInterfaceManager().containsInterface(206) && player.getInterfaceManager().containsInterface(207)) {
                  if (value < 0) {
                     return;
                  }

                  bob_item_X_Slot = (Integer)player.getTemporaryAttributes().remove("pc_item_X_Slot");
                  if (bob_item_X_Slot == null) {
                     return;
                  }
               } else if (player.getInterfaceManager().containsInterface(671) && player.getInterfaceManager().containsInterface(665)) {
                  if (value < 0) {
                     return;
                  }

                  bob_item_X_Slot = (Integer)player.getTemporaryAttributes().remove("bob_item_X_Slot");
                  if (bob_item_X_Slot == null) {
                     return;
                  }
               } else if (player.getTemporaryAttributes().get("skillId") != null) {
                  int skillId = (Integer)player.getTemporaryAttributes().remove("skillId");
                  if (skillId == 3 && value == 1) {
                     value = 10;
                  } else if (value < 1) {
                     value = 1;
                  } else if (value > 99) {
                     value = 99;
                  }

                  player.getSkills().set(skillId, value);
                  player.getSkills().setXp(skillId, (double)Skills.getXPForLevel(value));
                  player.getAppearence().generateAppearenceData();
               }
            } else {
               if (value < 0) {
                  return;
               }

               bob_item_X_Slot = (Integer)player.getTemporaryAttributes().remove("bank_item_X_Slot");
               if (bob_item_X_Slot == null) {
                  return;
               }

               if (player.getTemporaryAttributes().remove("bank_isWithdraw") != null) {
                  player.getBank().withdrawItem(bob_item_X_Slot, value);
               } else {
                  player.getBank().depositItem(bob_item_X_Slot, value, !player.getInterfaceManager().containsInterface(11));
               }
            }

         }
      }
   }

   private void handleStringInput(Player player, Integer packetId, Integer length, InputStream stream) {
      if (player.isRunning() && !player.isDead()) {
         String value = stream.readString();
         if (player.getTemporaryAttributes().get("string_input_action") != null) {
            StringInputAction action = (StringInputAction)player.getTemporaryAttributes().remove("string_input_action");
            action.handle(value);
         }
      }
   }
}
