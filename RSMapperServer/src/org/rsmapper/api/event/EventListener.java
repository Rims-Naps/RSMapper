package org.rsmapper.api.event;

import org.rsmapper.game.WorldObject;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;

public abstract class EventListener {
   public abstract int[] getEventIds();

   public boolean handleButtonClick(Player player, int interfaceId, int buttonId, int packetId, int slotId, int itemId) {
      return false;
   }

   public boolean handleObjectClick(Player player, int objectId, WorldObject worldObject, WorldTile tile, EventListener.ClickOption option) {
      return false;
   }

   public boolean handleNPCClick(Player player, NPC npc, EventListener.ClickOption option) {
      return false;
   }

   public boolean handleItemClick(Player player, Item item, EventListener.ClickOption option) {
      return false;
   }

   public static enum ClickOption {
      FIRST,
      SECOND,
      THIRD,
      FOURTH,
      FIFTH;
   }

   public static enum EventType {
      INTERFACE("interfaces"),
      OBJECT("objects"),
      NPC("npc"),
      ITEM("items");

      public final String tag;

      private EventType(String tag) {
         this.tag = tag;
      }
   }
}
