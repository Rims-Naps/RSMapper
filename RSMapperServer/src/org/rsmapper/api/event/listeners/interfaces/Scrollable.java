package org.rsmapper.api.event.listeners.interfaces;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.rsmapper.api.event.EventListener;
import org.rsmapper.game.WorldObject;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;
import org.rsmapper.utilities.misc.Utils;

public class Scrollable extends EventListener {
   public int[] getEventIds() {
      return new int[]{1142};
   }

   public static void sendScroll(Player player, String title, String... messageList) {
      player.closeInterfaces();
      int interfaceId = 1142;
      String text = "";
      int entries = 0;
      String[] var9 = messageList;
      int var8 = messageList.length;

      for(int var7 = 0; var7 < var8; ++var7) {
         String message = var9[var7];
         if (entries++ >= 66) {
            break;
         }

         text = text + message + "<br>";
      }

      player.getPackets().sendIComponentText(interfaceId, 2, title);
      player.getPackets().sendIComponentText(interfaceId, 5, text);
      player.getInterfaceManager().sendInterface(interfaceId);
   }

   public static void sendQuestScroll(Player player, String title, String... messageList) {
      player.closeInterfaces();
      List<String> messages = new ArrayList();
      int interfaceId = true;
      int endLine = true;
      int maxLength = true;
      int lineCount = Utils.getInterfaceDefinitionsComponentsSize(275);
      int startLine = 16;

      int k;
      for(k = 0; k < messageList.length; ++k) {
         String message = messageList[k];
         char[] unformatted = message.toCharArray();
         String[] newMessage = new String[(int)Math.ceil((double)unformatted.length / 65.0D) + 1];

         int index;
         for(int j = 0; j < unformatted.length; ++j) {
            index = j == 0 ? 1 : (int)Math.ceil((double)j / 65.0D);
            char character = unformatted[j];
            newMessage[index] = newMessage[index] + character;
         }

         String[] var16 = newMessage;
         int var20 = newMessage.length;

         for(index = 0; index < var20; ++index) {
            String m = var16[index];
            if (m != null) {
               messages.add(m.replaceAll("null", ""));
            }
         }
      }

      for(k = 0; k < lineCount; ++k) {
         player.getPackets().sendIComponentText(275, k, "");
      }

      for(Iterator var17 = messages.iterator(); var17.hasNext(); ++startLine) {
         String message = (String)var17.next();
         if (startLine > 315) {
            break;
         }

         player.getPackets().sendIComponentText(275, startLine, message);
      }

      player.getPackets().sendHideIComponent(275, 14, true);
      player.getPackets().sendRunScript(1207, messages.size());
      player.getPackets().sendIComponentText(275, 2, title);
      player.getInterfaceManager().sendInterface(275);
   }

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
}
