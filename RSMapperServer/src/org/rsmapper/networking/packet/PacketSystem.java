package org.rsmapper.networking.packet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;
import org.rsmapper.networking.packet.impl.ButtonPacketHandler;
import org.rsmapper.networking.packet.impl.CloseInterfacePacketHandler;
import org.rsmapper.networking.packet.impl.FrameInteractionPacketHandler;
import org.rsmapper.networking.packet.impl.IdlePacketHandler;
import org.rsmapper.networking.packet.impl.InputPacketHandler;
import org.rsmapper.networking.packet.impl.InterfacePacketHandler;
import org.rsmapper.networking.packet.impl.KeyEventPacketHandler;
import org.rsmapper.networking.packet.impl.PlayerOptionPacket;
import org.rsmapper.networking.packet.impl.ReceiveVarpPacket;
import org.rsmapper.networking.packet.impl.RecieveCoordinatesPacket;
import org.rsmapper.networking.packet.impl.ScreenInformationPacketHandler;
import org.rsmapper.networking.packet.impl.WalkingPacketHandler;
import org.rsmapper.networking.packet.impl.WorldMapPacketHandler;

public class PacketSystem {
   private static final Map<Integer, PacketHandler> LISTENERS = new HashMap();

   public static void load() {
      ArrayList loadedClasses = new ArrayList();

      try {
         loadedClasses.add((PacketHandler)ButtonPacketHandler.class.newInstance());
         loadedClasses.add((PacketHandler)CloseInterfacePacketHandler.class.newInstance());
         loadedClasses.add((PacketHandler)FrameInteractionPacketHandler.class.newInstance());
         loadedClasses.add((PacketHandler)IdlePacketHandler.class.newInstance());
         loadedClasses.add((PacketHandler)InputPacketHandler.class.newInstance());
         loadedClasses.add((PacketHandler)InterfacePacketHandler.class.newInstance());
         loadedClasses.add((PacketHandler)KeyEventPacketHandler.class.newInstance());
         loadedClasses.add((PacketHandler)PlayerOptionPacket.class.newInstance());
         loadedClasses.add((PacketHandler)ReceiveVarpPacket.class.newInstance());
         loadedClasses.add((PacketHandler)RecieveCoordinatesPacket.class.newInstance());
         loadedClasses.add((PacketHandler)ScreenInformationPacketHandler.class.newInstance());
         loadedClasses.add((PacketHandler)WalkingPacketHandler.class.newInstance());
         loadedClasses.add((PacketHandler)WorldMapPacketHandler.class.newInstance());
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      loadedClasses.stream().forEach((packet) -> {
         if (packet.getClass().getAnnotations().length == 0) {
            throw new RuntimeException(packet.getClass() + " has no @PacketInfo attribute.");
         } else {
            Stream.of(packet.getClass().getAnnotations()).filter((a) -> {
               return a instanceof PacketInformation;
            }).forEach((a) -> {
               PacketInformation info = (PacketInformation)a;
               String listeners = info.listeners();
               String[] split = listeners.split(",");
               String[] var8 = split;
               int var7 = split.length;

               for(int var6 = 0; var6 < var7; ++var6) {
                  String listener = var8[var6];
                  Integer packetId = Integer.valueOf(listener);
                  LISTENERS.put(packetId, packet);
               }

            });
         }
      });
   }

   public static PacketHandler getHandler(int packetId) {
      PacketHandler handler = (PacketHandler)LISTENERS.get(packetId);
      return handler;
   }
}
