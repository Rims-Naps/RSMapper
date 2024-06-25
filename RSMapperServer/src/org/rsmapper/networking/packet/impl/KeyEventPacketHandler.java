package org.rsmapper.networking.packet.impl;

import org.rsmapper.game.player.Player;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;

@PacketInformation(
   listeners = "186"
)
public class KeyEventPacketHandler extends PacketHandler {
   public static final int ESC_KEY = 27;
   public static final int CONSOLE_KEY = 192;
   public static final int TAB_KEY = 9;
   public static final int SHIFT_KEY = 16;
   public static final int CTRL_KEY = 17;
   public static final int ALT_KEY = 18;
   public static final int ENTER_KEY = 10;
   public static final int SPACE_KEY = 32;
   public static final int BKSPACE_KEY = 8;
   public static final int ARROW_UP_KEY = 38;
   public static final int ARROW_DOWN_KEY = 40;
   public static final int ARROW_LEFT_KEY = 37;
   public static final int ARROW_RIGHT_KEY = 39;

   public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
      if (packetId == 186) {
         int key = stream.readUnsignedShort();
         int mouseLocalX = stream.readUnsignedShort();
         int mouseLocalY = stream.readUnsignedShort();
         int mouseCoordX = stream.readInt();
         int mouseCoordY = stream.readInt();
         if (key != 65535 && (key < 65 || key > 90)) {
            System.out.println("[KEY]: " + key + " [MOUSE] local X: " + mouseLocalX + ", Y: " + mouseLocalY + " - coordinate X: " + mouseCoordX + ", Y: " + mouseCoordY);
            if (!player.getInterfaceManager().containsInterface(762) && player.getInterfaceManager().containsScreenInterface() && key == 27) {
               player.getInterfaceManager().closeScreenInterface();
               if (player.getCloseInterfacesEvent() != null) {
                  player.getCloseInterfacesEvent().run();
                  player.setCloseInterfacesEvent((Runnable)null);
               }

            }
         }
      }
   }
}
