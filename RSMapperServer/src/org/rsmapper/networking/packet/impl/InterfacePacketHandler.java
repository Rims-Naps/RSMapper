package org.rsmapper.networking.packet.impl;

import org.rsmapper.Constants;
import org.rsmapper.game.World;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.Player;
import org.rsmapper.game.player.RouteEvent;
import org.rsmapper.game.player.content.Magic;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.packet.PacketHandler;
import org.rsmapper.networking.packet.PacketInformation;
import org.rsmapper.utilities.misc.Utils;

@PacketInformation(
   listeners = "40,65,22,26,54"
)
public class InterfacePacketHandler extends PacketHandler {
   private static final int INTERFACE_ON_PLAYER = 40;
   private static final int INTERFACE_ON_NPC = 65;
   private static final int COLOR_ID_PACKET = 22;
   private static final int SWITCH_INTERFACE_ITEM_PACKET = 26;
   private static final int DIALOGUE_CONTINUE_PACKET = 54;

   public void handle(Player player, Integer packetId, Integer length, InputStream stream) {
      switch(packetId) {
      case 22:
         if (!player.hasStarted()) {
            return;
         }
         break;
      case 26:
         stream.readUnsignedShort();
         int fromSlot = stream.readUnsignedShortLE();
         stream.readUnsignedShort128();
         int interface1Hash = stream.readIntV1();
         int toSlot = stream.readUnsignedShortLE();
         int interface2Hash = stream.readIntV2();
         int fromInterfaceId = interface1Hash >> 16;
         int fromComponentId = interface1Hash - (fromInterfaceId << 16);
         int toInterfaceId = interface2Hash >> 16;
         int toComponentId = interface2Hash - (toInterfaceId << 16);
         if (Utils.getInterfaceDefinitionsSize() <= fromInterfaceId || Utils.getInterfaceDefinitionsSize() <= toInterfaceId) {
            return;
         }

         if (!player.getInterfaceManager().containsInterface(fromInterfaceId) || !player.getInterfaceManager().containsInterface(toInterfaceId)) {
            return;
         }

         if (fromComponentId != -1 && Utils.getInterfaceDefinitionsComponentsSize(fromInterfaceId) <= fromComponentId) {
            return;
         }

         if (toComponentId != -1 && Utils.getInterfaceDefinitionsComponentsSize(toInterfaceId) <= toComponentId) {
            return;
         }

         if (fromInterfaceId == 679 && fromComponentId == 0 && toInterfaceId == 679 && toComponentId == 0) {
            toSlot -= 28;
            if (toSlot < 0 || toSlot >= player.getInventory().getItemsContainerSize() || fromSlot >= player.getInventory().getItemsContainerSize()) {
               return;
            }

            player.getInventory().switchItem(fromSlot, toSlot);
         } else if (fromInterfaceId == 763 && fromComponentId == 0 && toInterfaceId == 763 && toComponentId == 0) {
            if (toSlot >= player.getInventory().getItemsContainerSize() || fromSlot >= player.getInventory().getItemsContainerSize()) {
               return;
            }

            player.getInventory().switchItem(fromSlot, toSlot);
         } else if (fromInterfaceId == 762 && toInterfaceId == 762) {
            player.getBank().switchItem(fromSlot, toSlot, fromComponentId, toComponentId);
         }

         if (Constants.DEBUG) {
            System.out.println("Switch item " + fromInterfaceId + ", " + fromSlot + ", " + toSlot);
         }
         break;
      case 40:
         this.handleInterfaceOnPlayer(player, packetId, length, stream);
         break;
      case 54:
         this.handleDialogue(player, packetId, length, stream);
         break;
      case 65:
         this.handleInterfaceOnNPC(player, packetId, length, stream);
      }

   }

   private void handleDialogue(Player player, Integer packetId, Integer length, InputStream stream) {
      int interfaceHash = stream.readIntV2();
      stream.readShortLE128();
      int interfaceId = interfaceHash >> 16;
      if (Utils.getInterfaceDefinitionsSize() > interfaceId) {
         if (!player.isRunning() || !player.getInterfaceManager().containsInterface(interfaceId)) {
            ;
         }
      }
   }

   private void handleInterfaceOnPlayer(final Player player, Integer packetId, Integer length, InputStream stream) {
      if (player.hasStarted() && player.clientHasLoadedMapRegion() && !player.isDead()) {
         if (player.getLockDelay() <= Utils.currentTimeMillis()) {
            int playerIndex = stream.readUnsignedShortLE();
            int interfaceHash = stream.readIntLE();
            int itemId = stream.readUnsignedShort();
            boolean forceRun = stream.read128Byte() == 1;
            int interfaceSlot = stream.readUnsignedShortLE128();
            int interfaceId = interfaceHash >> 16;
            int componentId = interfaceHash - (interfaceId << 16);
            if (Utils.getInterfaceDefinitionsSize() > interfaceId) {
               if (player.getInterfaceManager().containsInterface(interfaceId)) {
                  if (componentId == 65535) {
                     componentId = -1;
                  }

                  if (componentId == -1 || Utils.getInterfaceDefinitionsComponentsSize(interfaceId) > componentId) {
                     final Player p2 = (Player)World.getPlayers().get(playerIndex);
                     if (p2 != null && !p2.isDead() && !p2.hasFinished() && player.getMapRegionsIds().contains(p2.getRegionId())) {
                        player.stopAll(false);
                        if (forceRun) {
                           player.setRun(forceRun);
                        }

                        label125:
                        switch(interfaceId) {
                        case 192:
                           switch(componentId) {
                           case 25:
                           case 28:
                           case 30:
                           case 32:
                           case 34:
                           case 36:
                           case 39:
                           case 42:
                           case 45:
                           case 49:
                           case 52:
                           case 55:
                           case 58:
                           case 63:
                           case 66:
                           case 67:
                           case 68:
                           case 70:
                           case 73:
                           case 77:
                           case 80:
                           case 81:
                           case 84:
                           case 86:
                           case 87:
                           case 89:
                           case 91:
                           case 99:
                              if (Magic.checkCombatSpell(player, componentId, 1, false)) {
                                 player.setNextFaceWorldTile(new WorldTile(p2.getCoordFaceX(p2.getSize()), p2.getCoordFaceY(p2.getSize()), p2.getPlane()));
                                 if (!player.getControllerManager().canAttack(p2)) {
                                    return;
                                 }

                                 if (!p2.isAtMultiArea() || !player.isAtMultiArea()) {
                                    if (player.getAttackedBy() != p2 && player.getAttackedByDelay() > Utils.currentTimeMillis()) {
                                       player.getPackets().sendGameMessage("That " + (player.getAttackedBy() instanceof Player ? "player" : "npc") + " is already in combat.");
                                       return;
                                    }

                                    if (p2.getAttackedBy() != player && p2.getAttackedByDelay() > Utils.currentTimeMillis()) {
                                       if (!(p2.getAttackedBy() instanceof NPC)) {
                                          player.getPackets().sendGameMessage("That player is already in combat.");
                                          return;
                                       }

                                       p2.setAttackedBy(player);
                                    }
                                 }
                              }
                           default:
                              break label125;
                           }
                        case 193:
                           switch(componentId) {
                           case 20:
                           case 21:
                           case 22:
                           case 23:
                           case 24:
                           case 25:
                           case 26:
                           case 27:
                           case 28:
                           case 29:
                           case 30:
                           case 31:
                           case 32:
                           case 33:
                           case 34:
                           case 35:
                           case 36:
                           case 37:
                           case 38:
                           case 39:
                              if (Magic.checkCombatSpell(player, componentId, 1, false)) {
                                 player.setNextFaceWorldTile(new WorldTile(p2.getCoordFaceX(p2.getSize()), p2.getCoordFaceY(p2.getSize()), p2.getPlane()));
                                 if (!player.getControllerManager().canAttack(p2)) {
                                    return;
                                 }

                                 if (!p2.isAtMultiArea() || !player.isAtMultiArea()) {
                                    if (player.getAttackedBy() != p2 && player.getAttackedByDelay() > Utils.currentTimeMillis()) {
                                       player.getPackets().sendGameMessage("That " + (player.getAttackedBy() instanceof Player ? "player" : "npc") + " is already in combat.");
                                       return;
                                    }

                                    if (p2.getAttackedBy() != player && p2.getAttackedByDelay() > Utils.currentTimeMillis()) {
                                       if (!(p2.getAttackedBy() instanceof NPC)) {
                                          player.getPackets().sendGameMessage("That player is already in combat.");
                                          return;
                                       }

                                       p2.setAttackedBy(player);
                                    }
                                 }
                              }
                           }
                        case 662:
                        case 747:
                        case 1110:
                        default:
                           break;
                        case 679:
                           final Item item = player.getInventory().getItem(interfaceSlot);
                           if (item == null || item.getId() != itemId) {
                              return;
                           }

                           player.setRouteEvent(new RouteEvent(p2, new Runnable() {
                              public void run() {
                                 if (player.getControllerManager().processItemOnPlayer(p2, item)) {
                                    ;
                                 }
                              }
                           }));
                        }

                        if (Constants.DEBUG) {
                           System.out.println("Spell:" + componentId);
                        }

                     }
                  }
               }
            }
         }
      }
   }

   private void handleInterfaceOnNPC(Player player, Integer packetId, Integer length, InputStream stream) {
      if (player.hasStarted() && player.clientHasLoadedMapRegion() && !player.isDead()) {
         if (player.getLockDelay() <= Utils.currentTimeMillis()) {
            int slot = stream.readUnsignedShortLE128();
            stream.readUnsignedShortLE();
            int npcIndex = stream.readUnsignedShortLE();
            int interfaceHash = stream.readIntV2();
            stream.readByte();
            int interfaceId = interfaceHash >> 16;
            int componentId = interfaceHash - (interfaceId << 16);
            if (Utils.getInterfaceDefinitionsSize() > interfaceId) {
               if (player.getInterfaceManager().containsInterface(interfaceId)) {
                  if (componentId == 65535) {
                     componentId = -1;
                  }

                  if (componentId == -1 || Utils.getInterfaceDefinitionsComponentsSize(interfaceId) > componentId) {
                     NPC npc = (NPC)World.getNPCs().get(npcIndex);
                     if (npc != null && !npc.isDead() && !npc.hasFinished() && player.getMapRegionsIds().contains(npc.getRegionId())) {
                        player.stopAll(false);
                        switch(interfaceId) {
                        case 193:
                           switch(componentId) {
                           case 20:
                           case 21:
                           case 22:
                           case 23:
                           case 24:
                           case 25:
                           case 26:
                           case 27:
                           case 28:
                           case 29:
                           case 30:
                           case 31:
                           case 32:
                           case 33:
                           case 34:
                           case 35:
                           case 36:
                           case 37:
                           case 38:
                           case 39:
                              if (Magic.checkCombatSpell(player, componentId, 1, false)) {
                                 player.setNextFaceWorldTile(new WorldTile(npc.getCoordFaceX(npc.getSize()), npc.getCoordFaceY(npc.getSize()), npc.getPlane()));
                                 if (!player.getControllerManager().canAttack(npc)) {
                                    return;
                                 }

                                 if (!npc.isForceMultiAttacked() && (!npc.isAtMultiArea() || !player.isAtMultiArea())) {
                                    if (player.getAttackedBy() != npc && player.getAttackedByDelay() > Utils.currentTimeMillis()) {
                                       player.getPackets().sendGameMessage("You are already in combat.");
                                       return;
                                    }

                                    if (npc.getAttackedBy() != player && npc.getAttackedByDelay() > Utils.currentTimeMillis()) {
                                       player.getPackets().sendGameMessage("This npc is already in combat.");
                                       return;
                                    }
                                 }
                              }
                           }
                        case 192:
                           switch(componentId) {
                           case 25:
                           case 28:
                           case 30:
                           case 32:
                           case 34:
                           case 36:
                           case 39:
                           case 42:
                           case 45:
                           case 49:
                           case 52:
                           case 55:
                           case 58:
                           case 63:
                           case 66:
                           case 67:
                           case 68:
                           case 70:
                           case 73:
                           case 77:
                           case 80:
                           case 81:
                           case 84:
                           case 87:
                           case 89:
                           case 91:
                           case 93:
                           case 98:
                           case 99:
                              if (Magic.checkCombatSpell(player, componentId, 1, false)) {
                                 player.setNextFaceWorldTile(new WorldTile(npc.getCoordFaceX(npc.getSize()), npc.getCoordFaceY(npc.getSize()), npc.getPlane()));
                                 if (!player.getControllerManager().canAttack(npc)) {
                                    return;
                                 }

                                 if (!npc.isForceMultiAttacked() && (!npc.isAtMultiArea() || !player.isAtMultiArea())) {
                                    if (player.getAttackedBy() != npc && player.getAttackedByDelay() > Utils.currentTimeMillis()) {
                                       player.getPackets().sendGameMessage("You are already in combat.");
                                       return;
                                    }

                                    if (npc.getAttackedBy() != player && npc.getAttackedByDelay() > Utils.currentTimeMillis()) {
                                       player.getPackets().sendGameMessage("This npc is already in combat.");
                                       return;
                                    }
                                 }
                              }
                           }
                        case 662:
                        case 747:
                        }

                        if (Constants.DEBUG) {
                           System.out.println("Spell:" + componentId);
                        }

                     }
                  }
               }
            }
         }
      }
   }
}
