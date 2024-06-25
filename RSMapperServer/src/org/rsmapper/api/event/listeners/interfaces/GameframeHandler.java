package org.rsmapper.api.event.listeners.interfaces;

import org.rsmapper.api.event.EventListener;
import org.rsmapper.game.WorldObject;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;

public class GameframeHandler extends EventListener {

   /**
    * Returns the event IDs that this handler will respond to.
    *
    * @return an array of event IDs
    */
   public int[] getEventIds() {
      return new int[]{548, 746};
   }

   /**
    * Handles button clicks on the game interface.
    *
    * @param player the player who clicked the button
    * @param interfaceId the ID of the interface containing the button
    * @param buttonId the ID of the button clicked
    * @param packetId the packet ID sent by the client
    * @param slotId the slot ID of the item (if applicable)
    * @param itemId the item ID (if applicable)
    * @return true if the button click was handled, false otherwise
    */
   public boolean handleButtonClick(Player player, int interfaceId, int buttonId, int packetId, int slotId, int itemId) {
      System.out.println("ButtonID: " + buttonId + " InterfaceID: " + interfaceId);
      if (buttonId == 132 && interfaceId == 548 || buttonId == 42 && interfaceId == 746) {
         return true;
      } else if (buttonId == 130 && interfaceId == 548 || buttonId == 40 && interfaceId == 746) {
         player.getInterfaceManager().sendTaskTab(false);
         return true;
      } else if ((buttonId != 130 || interfaceId != 548) && (buttonId != 40 || interfaceId != 746)) {
         if ((buttonId != 103 || interfaceId != 548) && (buttonId != 51 || interfaceId != 746)) {
            return buttonId == 184 && interfaceId == 548 || buttonId == 175 && interfaceId == 746;
         } else {
            return false;
         }
      } else {
         player.getInterfaceManager().sendTaskTab(false);
         return true;
      }
   }

   /**
    * Handles object clicks in the game world.
    *
    * @param player the player who clicked the object
    * @param objectId the ID of the object clicked
    * @param worldObject the world object clicked
    * @param tile the tile where the object is located
    * @param option the click option used
    * @return always false, as this implementation doesn't handle object clicks
    */
   public boolean handleObjectClick(Player player, int objectId, WorldObject worldObject, WorldTile tile, EventListener.ClickOption option) {
      return false;
   }

   /**
    * Handles NPC clicks in the game world.
    *
    * @param player the player who clicked the NPC
    * @param npc the NPC clicked
    * @param option the click option used
    * @return always false, as this implementation doesn't handle NPC clicks
    */
   public boolean handleNPCClick(Player player, NPC npc, EventListener.ClickOption option) {
      return false;
   }

   /**
    * Handles item clicks in the game world.
    *
    * @param player the player who clicked the item
    * @param item the item clicked
    * @param option the click option used
    * @return always false, as this implementation doesn't handle item clicks
    */
   public boolean handleItemClick(Player player, Item item, EventListener.ClickOption option) {
      return false;
   }
}