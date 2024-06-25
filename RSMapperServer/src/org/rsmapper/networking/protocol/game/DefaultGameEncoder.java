package org.rsmapper.networking.protocol.game;

import java.util.Iterator;
import java.util.stream.Stream;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.rsmapper.Constants;
import org.rsmapper.api.input.IntegerInputAction;
import org.rsmapper.api.input.StringInputAction;
import org.rsmapper.game.Animation;
import org.rsmapper.game.DynamicRegion;
import org.rsmapper.game.Entity;
import org.rsmapper.game.Graphics;
import org.rsmapper.game.Region;
import org.rsmapper.game.World;
import org.rsmapper.game.WorldObject;
import org.rsmapper.game.WorldTile;
import org.rsmapper.game.item.FloorItem;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.item.ItemsContainer;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.game.player.HintIcon;
import org.rsmapper.game.player.Player;
import org.rsmapper.networking.Session;
import org.rsmapper.networking.codec.Encoder;
import org.rsmapper.networking.codec.stream.OutputStream;
import org.rsmapper.utilities.game.cache.MapXTEA;
import org.rsmapper.utilities.misc.Stopwatch;
import org.rsmapper.utilities.misc.Utils;

public class DefaultGameEncoder extends Encoder {
   private Player player;

   public DefaultGameEncoder(Session session, Player player) {
      super(session);
      this.player = player;
   }

   public void sendResetMinimapFlag() {
      OutputStream stream = new OutputStream(3);
      stream.writePacket(this.player, 55);
      stream.writeByte(255);
      stream.writeByte128(255);
      this.session.write(stream);
   }

   public void sendRuntimeMessage(String message) {
      this.sendMessage(1337, message, (Player)null);
   }

   public void sendOpenURL(String website) {
      this.sendMessage(1338, website, (Player)null);
   }

   public void sendMinimapFlag(int x, int y) {
      OutputStream stream = new OutputStream(3);
      stream.writePacket(this.player, 55);
      stream.writeByte(x);
      stream.writeByte128(y);
      this.session.write(stream);
   }

   public void sendNPCMessage(int border, NPC npc, String message) {
      this.sendGameMessage(message);
   }

   public void sendItems(int key, ItemsContainer<Item> items) {
      this.sendItems(key, key < 0, items);
   }

   public void sendItems(int key, boolean keyLessIntegerSize, ItemsContainer<Item> items) {
      this.sendItems(key, keyLessIntegerSize, items.getItems());
   }

   public void sendItems(int key, Item[] items) {
      this.sendItems(key, key < 0, items);
   }

   public void sendItems(int key, boolean negativeKey, Item[] items) {
      OutputStream stream = new OutputStream();
      stream.writePacketVarShort(this.player, 37);
      stream.writeShort(negativeKey ? key : key);
      stream.writeByte(negativeKey ? 1 : 0);
      stream.writeShort(items.length);
      Stream.of(items).forEach((item) -> {
         int id = -1;
         int amount = 0;
         if (item != null) {
            id = item.getId();
            amount = item.getAmount();
         }

         stream.writeByte(amount >= 255 ? 255 : amount);
         if (amount >= 255) {
            stream.writeInt(amount);
         }

         stream.writeShortLE(id + 1);
      });
      stream.endPacketVarShort();
      this.session.write(stream);
   }

   public void sendPlayerUnderNPCPriority(boolean priority) {
      OutputStream stream = new OutputStream(2);
      stream.writePacket(this.player, 123);
      stream.write128Byte(priority ? 1 : 0);
      this.session.write(stream);
   }

   public void sendInputIntegerScript(String message, IntegerInputAction onInputGivenAction) {
      this.player.getTemporaryAttributes().put("integer_input_action", onInputGivenAction);
      this.sendRunScript(108, message);
   }

   public void sendInputNameScript(String message, StringInputAction onInputGivenAction) {
      this.player.getTemporaryAttributes().put("string_input_action", onInputGivenAction);
      this.sendRunScript(109, message);
   }

   public void sendInputLongTextScript(String message, StringInputAction onInputGivenAction) {
      this.player.getTemporaryAttributes().put("long_string_input_action", onInputGivenAction);
      this.sendRunScript(110, message);
   }

   public void sendHintIcon(HintIcon icon) {
      OutputStream stream = new OutputStream(13);
      stream.writePacket(this.player, 81);
      stream.writeByte(icon.getTargetType() & 31 | icon.getIndex() << 5);
      if (icon.getTargetType() == 0) {
         stream.skip(11);
      } else {
         stream.writeByte(icon.getArrowType());
         if (icon.getTargetType() != 1 && icon.getTargetType() != 10) {
            if (icon.getTargetType() >= 2 && icon.getTargetType() <= 6) {
               stream.writeByte(0);
               stream.writeShort(icon.getCoordX());
               stream.writeShort(icon.getCoordY());
               stream.writeByte(icon.getDistanceFromFloor() * 4 >> 2);
               stream.writeShort(0);
            }
         } else {
            stream.writeShort(icon.getTargetIndex());
            stream.writeShort(0);
            stream.skip(4);
         }

         stream.writeShort(icon.getModelId());
      }

      this.session.write(stream);
   }

   public void sendCameraShake(int slotId, int b, int c, int d, int e) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 34);
      stream.write128Byte(b);
      stream.writeByte128(slotId);
      stream.writeShortLE128(e);
      stream.write128Byte(c);
      stream.write128Byte(d);
      this.session.write(stream);
   }

   public void sendStopCameraShake() {
      OutputStream stream = new OutputStream(1);
      stream.writePacket(this.player, 15);
      this.session.write(stream);
   }

   public void sendICreateSprite(int interfaceId, int componentIdToAddChild, int childId, int spriteId, int posX, int posY, int width, int height, boolean vFlip, boolean hFlip, boolean repeat) {
      this.sendRunScript(2994, 0, !repeat ? 0 : 1, !vFlip ? 0 : 1, !hFlip ? 0 : 1, spriteId, posY, posX, height, width, childId, interfaceId << 16 | componentIdToAddChild);
   }

   public void sendICreateText(int interfaceId, int componentIdToAddChild, int childId, String text, int font, int colorHex, int posX, int posY, int width, int height, int alignX, int alignY, int multi) {
      this.sendRunScript(2995, 1, multi, alignY, alignX, font, colorHex, text, posY, posX, height, width, childId, interfaceId << 16 | componentIdToAddChild);
   }

   public void sendICreateRectangle(int interfaceId, int componentIdToAddChild, int childId, int posX, int posY, int width, int height, int colorHex, int transparency, boolean filled) {
      this.sendRunScript(2996, transparency, !filled ? 0 : 1, colorHex, posY, posX, height, width, childId, interfaceId << 16 | componentIdToAddChild);
   }

   public void sendIComponentsScrollMaxY(int interfaceId, int containerId, int scrollbarcontainerId, int height, boolean addToHeight) {
      this.sendRunScript(1208, addToHeight ? 1 : 0, height, interfaceId << 16 | containerId, interfaceId << 16 | scrollbarcontainerId);
   }

   public void sendIRectangleFilled(int interfaceId, int componentId, boolean filled) {
      this.sendRunScript(filled ? 533 : 534, interfaceId << 16 | componentId);
   }

   public void sendIComponentColor(int interfaceId, int componentId, int colorHex) {
      this.sendRunScript(45, colorHex, interfaceId << 16 | componentId);
   }

   public void sendIComponentSprite(int interfaceId, int componentId, int spriteId) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 2);
      stream.writeShortLE(spriteId);
      stream.writeInt(interfaceId << 16 | componentId);
      this.session.write(stream);
   }

   public void sendIComponentModel(int interfaceId, int componentId, int modelId) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 58);
      stream.writeIntV1(interfaceId << 16 | componentId);
      stream.writeShort128(modelId);
      this.session.write(stream);
   }

   public void sendScrollIComponent(int interfaceId, int componentId, int value) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 8);
      stream.writeShort128(value);
      stream.writeIntLE(interfaceId << 16 | componentId);
      this.session.write(stream);
   }

   public void sendHideIComponent(int interfaceId, int componentId, boolean hidden) {
      OutputStream stream = new OutputStream(6);
      stream.writePacket(this.player, 117);
      stream.writeIntV1(interfaceId << 16 | componentId);
      stream.writeByte128(hidden ? 1 : 0);
      this.session.write(stream);
   }

   public void sendRemoveGroundItem(FloorItem item) {
      this.sendWorldTile(item.getTile());
      int localX = item.getTile().getLocalX(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize());
      int localY = item.getTile().getLocalY(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize());
      int offsetX = localX - (localX >> 3 << 3);
      int offsetY = localY - (localY >> 3 << 3);
      OutputStream stream = new OutputStream(4);
      stream.writePacket(this.player, 16);
      stream.writeShort(item.getId());
      stream.writeByte(offsetX << 4 | offsetY);
      this.session.write(stream);
   }

   public void sendGroundItem(FloorItem item) {
      this.sendWorldTile(item.getTile());
      int localX = item.getTile().getLocalX(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize());
      int localY = item.getTile().getLocalY(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize());
      int offsetX = localX - (localX >> 3 << 3);
      int offsetY = localY - (localY >> 3 << 3);
      OutputStream stream = new OutputStream(6);
      stream.writePacket(this.player, 48);
      stream.writeByteC(offsetX << 4 | offsetY);
      stream.writeShort128(item.getId());
      stream.writeShort(item.getAmount());
      this.session.write(stream);
   }

   public void sendProjectile(Entity receiver, WorldTile startTile, WorldTile endTile, int gfxId, int startHeight, int endHeight, int speed, int delay, int curve, int startDistanceOffset, int creatorSize) {
      this.sendWorldTile(startTile);
      OutputStream stream = new OutputStream(17);
      stream.writePacket(this.player, 62);
      int localX = startTile.getLocalX(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize());
      int localY = startTile.getLocalY(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize());
      int offsetX = localX - (localX >> 3 << 3);
      int offsetY = localY - (localY >> 3 << 3);
      stream.writeByte(offsetX << 3 | offsetY);
      stream.writeByte(endTile.getX() - startTile.getX());
      stream.writeByte(endTile.getY() - startTile.getY());
      stream.writeShort(receiver == null ? 0 : (receiver instanceof Player ? -(receiver.getIndex() + 1) : receiver.getIndex() + 1));
      stream.writeShort(gfxId);
      stream.writeByte(startHeight);
      stream.writeByte(endHeight);
      stream.writeShort(delay);
      int duration = Utils.getDistance(startTile.getX(), startTile.getY(), endTile.getX(), endTile.getY()) * 30 / (speed / 10 < 1 ? 1 : speed / 10) + delay;
      stream.writeShort(duration);
      stream.writeByte(curve);
      stream.writeShort(creatorSize * 64 + startDistanceOffset);
      this.session.write(stream);
   }

   public void sendUnlockIComponentOptionSlots(int interfaceId, int componentId, int fromSlot, int toSlot, int... optionsSlots) {
      int settingsHash = 0;
      int[] var10 = optionsSlots;
      int var9 = optionsSlots.length;

      for(int var8 = 0; var8 < var9; ++var8) {
         int slot = var10[var8];
         settingsHash |= 2 << slot;
      }

      this.sendIComponentSettings(interfaceId, componentId, fromSlot, toSlot, settingsHash);
   }

   public void sendIComponentSettings(int interfaceId, int componentId, int fromSlot, int toSlot, int settingsHash) {
      OutputStream stream = new OutputStream(13);
      stream.writePacket(this.player, 3);
      stream.writeShortLE(fromSlot);
      stream.writeIntV2(interfaceId << 16 | componentId);
      stream.writeShort128(toSlot);
      stream.writeIntLE(settingsHash);
      this.session.write(stream);
   }

   public void sendInterSetItemsOptionsScript(int interfaceId, int componentId, int key, int width, int height, String... options) {
      Object[] parameters = new Object[6 + options.length];
      int index = 0;

      for(int count = options.length - 1; count >= 0; --count) {
         parameters[index++] = options[count];
      }

      parameters[index++] = -1;
      parameters[index++] = 0;
      parameters[index++] = height;
      parameters[index++] = width;
      parameters[index++] = key;
      parameters[index++] = interfaceId << 16 | componentId;
      this.sendRunScript(150, parameters);
   }

   public void sendRunScriptpz(int id, Object[] params, String types) {
      if (params.length == types.length()) {
         OutputStream packet = new OutputStream();
         packet.writePacketVarShort(this.player, 70);
         packet.writeString(types);
         int idx = 0;

         for(int i = types.length() - 1; i >= 0; --i) {
            if (types.charAt(i) == 's') {
               packet.writeString((String)params[idx]);
            } else {
               packet.writeInt((Integer)params[idx]);
            }

            ++idx;
         }

         packet.writeInt(id);
         packet.endPacketVarShort();
         this.session.write(packet);
      }
   }

   public void sendRunScript(int scriptId, Object... params) {
      try {
         OutputStream stream = new OutputStream();
         stream.writePacketVarShort(this.player, 50);
         String parameterTypes = "";
         int count;
         if (params != null) {
            for(count = params.length - 1; count >= 0; --count) {
               if (params[count] instanceof String) {
                  parameterTypes = parameterTypes + "s";
               } else {
                  parameterTypes = parameterTypes + "i";
               }
            }
         }

         stream.writeString(parameterTypes);
         if (params != null) {
            count = 0;

            for(int count = parameterTypes.length() - 1; count >= 0; --count) {
               if (parameterTypes.charAt(count) == 's') {
                  stream.writeString((String)params[count++]);
               } else {
                  stream.writeInt((Integer)params[count++]);
               }
            }
         }

         stream.writeInt(scriptId);
         stream.endPacketVarShort();
         this.session.write(stream);
      } catch (Exception var7) {
         var7.printStackTrace();
      }
   }

   public void sendGlobalConfig(int id, int value) {
      if (value >= -128 && value <= 127) {
         this.sendGlobalConfig1(id, value);
      } else {
         this.sendGlobalConfig2(id, value);
      }

   }

   public void sendGlobalConfig1(int id, int value) {
      OutputStream stream = new OutputStream(4);
      stream.writePacket(this.player, 111);
      stream.writeShortLE128(id);
      stream.write128Byte(value);
      this.session.write(stream);
   }

   public void sendGlobalConfig2(int id, int value) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 112);
      stream.writeShortLE(id);
      stream.writeInt(value);
      this.session.write(stream);
   }

   public void sendConfig(int id, int value) {
      if (value >= -128 && value <= 127) {
         this.sendConfig1(id, value);
      } else {
         this.sendConfig2(id, value);
      }

   }

   public void sendConfigByFile(int fileId, int value) {
      if (value >= -128 && value <= 127) {
         this.sendConfigByFile1(fileId, value);
      } else {
         this.sendConfigByFile2(fileId, value);
      }

   }

   public void sendConfig1(int id, int value) {
      OutputStream stream = new OutputStream(4);
      stream.writePacket(this.player, 101);
      stream.writeShort(id);
      stream.writeByte128(value);
      this.session.write(stream);
   }

   public void sendConfig2(int id, int value) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 39);
      stream.writeIntV2(value);
      stream.writeShort128(id);
      this.session.write(stream);
   }

   public void sendConfigByFile1(int fileId, int value) {
      OutputStream stream = new OutputStream(4);
      stream.writePacket(this.player, 14);
      stream.write128Byte(value);
      stream.writeShort128(fileId);
      this.session.write(stream);
   }

   public void sendConfigByFile2(int fileId, int value) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 84);
      stream.writeInt(value);
      stream.writeShort(fileId);
      this.session.write(stream);
   }

   public void sendRunEnergy() {
      OutputStream stream = new OutputStream(2);
      stream.writePacket(this.player, 13);
      stream.writeByte(this.player.getRunEnergy());
      this.session.write(stream);
   }

   public void sendIComponentFont(int interfaceId, int componentId, int font) {
      OutputStream stream = new OutputStream();
      stream.writePacket(this.player, 95);
      stream.writeIntV1(interfaceId << 16 | componentId);
      stream.writeShortLE128(font);
      this.session.write(stream);
   }

   public void sendIComponentText(int interfaceId, int componentId, String text) {
      OutputStream stream = new OutputStream();
      stream.writePacketVarShort(this.player, 33);
      stream.writeInt(interfaceId << 16 | componentId);
      stream.writeString(text);
      stream.endPacketVarShort();
      this.session.write(stream);
   }

   public void sendIComponentText(int interfaceId, int componentId, String text, int font) {
      this.sendIComponentFont(interfaceId, componentId, font);
      this.sendIComponentText(interfaceId, componentId, text);
   }

   public void sendIComponentAnimation(int emoteId, int interfaceId, int componentId) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 23);
      stream.writeShortLE128(emoteId);
      stream.writeIntV1(interfaceId << 16 | componentId);
      this.session.write(stream);
   }

   public void sendItemOnIComponent(int interfaceid, int componentId, int id, int amount) {
      OutputStream stream = new OutputStream(11);
      stream.writePacket(this.player, 9);
      stream.writeShortLE(id);
      stream.writeInt(amount);
      stream.writeIntV2(interfaceid << 16 | componentId);
      this.session.write(stream);
   }

   public void sendItemOnIComponent(int interfaceid, int componentId, int itemId, int count, String examine) {
      this.sendRunScript(4599, interfaceid << 16 | componentId, examine, count, itemId);
   }

   public void sendEntityOnIComponent(boolean isPlayer, int entityId, int interfaceId, int componentId) {
      if (isPlayer) {
         this.sendPlayerHeadOnIComponent(interfaceId, componentId);
      } else {
         this.sendNPCHeadOnIComponent(interfaceId, componentId, entityId);
      }

   }

   public void sendWorldTile(WorldTile tile) {
      OutputStream stream = new OutputStream(3);
      stream.writePacket(this.player, 46);
      stream.writeByte128(tile.getLocalX(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize()) >> 3);
      stream.writeByte(tile.getLocalY(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize()) >> 3);
      stream.write128Byte(tile.getPlane());
      this.session.write(stream);
   }

   public void sendObjectAnimation(WorldObject object, Animation animation) {
      OutputStream stream = new OutputStream(8);
      stream.writePacket(this.player, 96);
      stream.writeIntV2(object.getTileHash());
      stream.writeShort128(animation.getIds()[0]);
      stream.write128Byte((object.getType() << 2) + (object.getRotation() & 3));
      this.session.write(stream);
   }

   public void sendTileMessage(String message, WorldTile tile, int color) {
      this.sendTileMessage(message, tile, 5000, 255, color);
   }

   public void sendTileMessage(String message, WorldTile tile, int delay, int height, int color) {
      this.sendWorldTile(tile);
      OutputStream stream = new OutputStream();
      stream.writePacketVarByte(this.player, 32);
      stream.skip(1);
      int localX = tile.getLocalX(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize());
      int localY = tile.getLocalY(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize());
      int offsetX = localX - (localX >> 3 << 3);
      int offsetY = localY - (localY >> 3 << 3);
      stream.writeByte(offsetX << 4 | offsetY);
      stream.writeShort(delay / 30);
      stream.writeByte(height);
      stream.write24BitInteger(color);
      stream.writeString(message);
      stream.endPacketVarByte();
      this.session.write(stream);
   }

   public void sendSpawnedObject(WorldObject object) {
      this.sendWorldTile(object);
      int localX = object.getLocalX(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize());
      int localY = object.getLocalY(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize());
      int offsetX = localX - (localX >> 3 << 3);
      int offsetY = localY - (localY >> 3 << 3);
      OutputStream stream = new OutputStream(5);
      stream.writePacket(this.player, 28);
      stream.writeByte(offsetX << 4 | offsetY);
      stream.writeByte((object.getType() << 2) + (object.getRotation() & 3));
      stream.writeShort128(object.getId());
      this.session.write(stream);
   }

   public void sendDestroyObject(WorldObject object) {
      this.sendWorldTile(object);
      int localX = object.getLocalX(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize());
      int localY = object.getLocalY(this.player.getLastLoadedMapRegionTile(), this.player.getMapSize());
      int offsetX = localX - (localX >> 3 << 3);
      int offsetY = localY - (localY >> 3 << 3);
      OutputStream stream = new OutputStream(3);
      stream.writePacket(this.player, 45);
      stream.writeByteC(offsetX << 4 | offsetY);
      stream.writeByte((object.getType() << 2) + (object.getRotation() & 3));
      this.session.write(stream);
   }

   public void sendPlayerHeadOnIComponent(int interfaceId, int componentId) {
      OutputStream stream = new OutputStream(5);
      stream.writePacket(this.player, 114);
      stream.writeIntLE(interfaceId << 16 | componentId);
      this.session.write(stream);
   }

   public void sendNPCHeadOnIComponent(int interfaceId, int componentId, int npcId) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 98);
      stream.writeInt(interfaceId << 16 | componentId);
      stream.writeShortLE(npcId);
      this.session.write(stream);
   }

   public void sendFullNPCOnIComponent(int interfaceId, int componentId, int npcId, int animationId) {
      OutputStream stream = new OutputStream(11);
      stream.writePacket(this.player, 109);
      stream.writeIntV1(interfaceId << 16 | componentId);
      stream.writeShort(npcId);
      stream.writeIntV2(1);
      this.session.write(stream);
      this.sendIComponentAnimation(animationId, interfaceId, componentId);
   }

   public void sendIComponent3DView(int interfaceId, int componentId, int zoom, int rotation1, int rotation2) {
      OutputStream stream = new OutputStream(11);
      stream.writePacket(this.player, 122);
      stream.writeShort128(zoom);
      stream.writeShortLE128(rotation1);
      stream.writeIntLE(interfaceId << 16 | componentId);
      stream.writeShortLE128(rotation2);
      this.session.write(stream);
   }

   public void sendRandomOnIComponent(int interfaceId, int componentId, int id) {
   }

   public void sendFaceOnIComponent(int interfaceId, int componentId, int look1, int look2, int look3) {
   }

   public void sendUnlockIgnoreList() {
      OutputStream stream = new OutputStream(1);
      stream.writePacket(this.player, 135);
      this.session.write(stream);
   }

   public void sendUnlockFriendList() {
      OutputStream stream = new OutputStream(1);
      stream.writePacketVarShort(this.player, 85);
      this.session.write(stream);
   }

   public void sendDynamicMapRegion(boolean wasAtDynamicRegion) {
      OutputStream stream = new OutputStream();
      stream.writePacketVarShort(this.player, 128);
      int middleChunkX = this.player.getChunkX();
      int middleChunkY = this.player.getChunkY();
      stream.writeShort(middleChunkY);
      stream.writeByte(this.player.getMapSize());
      stream.write128Byte(this.player.isForceNextMapLoadRefresh() ? 1 : 0);
      stream.write128Byte(2);
      stream.writeShortLE(middleChunkX);
      stream.initBitAccess();
      int sceneLength = Constants.MAP_SIZES[this.player.getMapSize()] >> 4;
      int[] regionIds = new int[4 * sceneLength * sceneLength];
      int newRegionIdsCount = 0;

      int plane;
      int keyIndex;
      for(plane = 0; plane < 4; ++plane) {
         for(int realChunkX = middleChunkX - sceneLength; realChunkX <= middleChunkX + sceneLength; ++realChunkX) {
            keyIndex = realChunkX / 8;

            label72:
            for(int realChunkY = middleChunkY - sceneLength; realChunkY <= middleChunkY + sceneLength; ++realChunkY) {
               int regionY = realChunkY / 8;
               int regionId = (keyIndex << 8) + regionY;
               Region region = (Region)World.getRegions().get(regionId);
               int newChunkX;
               int newChunkY;
               int newPlane;
               int rotation;
               if (region instanceof DynamicRegion) {
                  DynamicRegion dynamicRegion = (DynamicRegion)region;
                  int[] pallete = dynamicRegion.getRegionCoords()[plane][realChunkX - keyIndex * 8][realChunkY - regionY * 8];
                  newChunkX = pallete[0];
                  newChunkY = pallete[1];
                  newPlane = pallete[2];
                  rotation = pallete[3];
               } else {
                  newChunkX = realChunkX;
                  newChunkY = realChunkY;
                  newPlane = plane;
                  rotation = 0;
               }

               if (newChunkX != 0 && newChunkY != 0) {
                  stream.writeBits(1, 1);
                  stream.writeBits(26, rotation << 1 | newPlane << 24 | newChunkX << 14 | newChunkY << 3);
                  int newRegionId = (newChunkX / 8 << 8) + newChunkY / 8;

                  for(int index = 0; index < newRegionIdsCount; ++index) {
                     if (regionIds[index] == newRegionId) {
                        continue label72;
                     }
                  }

                  regionIds[newRegionIdsCount++] = newRegionId;
               } else {
                  stream.writeBits(1, 0);
               }
            }
         }
      }

      stream.finishBitAccess();

      for(plane = 0; plane < newRegionIdsCount; ++plane) {
         int[] xteas = MapXTEA.getKey(regionIds[plane]);
         if (xteas == null) {
            xteas = new int[4];
         }

         for(keyIndex = 0; keyIndex < 4; ++keyIndex) {
            stream.writeInt(xteas[keyIndex]);
         }
      }

      stream.endPacketVarShort();
      this.session.write(stream);
   }

   public void sendMapRegion(boolean sendLswp) {
      OutputStream stream = new OutputStream();
      stream.writePacketVarShort(this.player, 43);
      if (sendLswp) {
         this.player.getLocalPlayerUpdate().init(stream);
      }

      stream.writeByteC(this.player.getMapSize());
      stream.writeByte(this.player.isForceNextMapLoadRefresh() ? 1 : 0);
      stream.writeShortLE(this.player.getChunkX());
      stream.writeShort(this.player.getChunkY());
      Iterator var4 = this.player.getMapRegionsIds().iterator();

      while(var4.hasNext()) {
         int regionId = (Integer)var4.next();
         int[] xteas = MapXTEA.getKey(regionId);
         if (xteas == null) {
            xteas = new int[4];
         }

         for(int index = 0; index < 4; ++index) {
            stream.writeInt(xteas[index]);
         }
      }

      stream.endPacketVarShort();
      this.session.write(stream);
   }

   public void sendCutscene(int id) {
      OutputStream stream = new OutputStream();
      stream.writePacketVarShort(this.player, 132);
      stream.writeShort(id);
      stream.writeShort(20);

      for(int count = 0; count < 20; ++count) {
         for(int i = 0; i < 4; ++i) {
            stream.writeInt(0);
         }
      }

      byte[] appearence = this.player.getAppearence().getAppeareanceData();
      stream.writeByte(appearence.length);
      stream.writeBytes(appearence);
      stream.endPacketVarShort();
      this.session.write(stream);
   }

   public void sendWindowsPane(int id, int type) {
      this.player.getInterfaceManager().setWindowsPane(id);
      OutputStream stream = new OutputStream(4);
      stream.writePacket(this.player, 67);
      stream.writeShortLE128(id);
      stream.write128Byte(type);
      this.session.write(stream);
   }

   public void sendPlayerOption(String option, int slot, boolean top) {
      this.sendPlayerOption(option, slot, top, -1);
   }

   public void sendPlayerOption(String option, int slot, boolean top, int cursor) {
      OutputStream stream = new OutputStream();
      stream.writePacketVarByte(this.player, 1);
      stream.writeByte128(top ? 1 : 0);
      stream.writeShortLE(cursor);
      stream.writeString(option);
      stream.writeByteC(slot);
      stream.endPacketVarByte();
      this.session.write(stream);
   }

   public void sendLocalPlayersUpdate() {
      Stopwatch s = Stopwatch.start();
      this.session.write(this.player.getLocalPlayerUpdate().createPacketAndProcess());
      if (s.elapsed() > 200L) {
         System.err.println("Players took: " + s.elapsed());
      }

   }

   public void sendLocalNPCsUpdate() {
      this.session.write(this.player.getLocalNPCUpdate().createPacketAndProcess());
   }

   public void sendGraphics(Graphics graphics, Object target) {
      OutputStream stream = new OutputStream(13);
      int hash = false;
      int hash;
      if (target instanceof WorldTile) {
         WorldTile tile = (WorldTile)target;
         hash = tile.getPlane() << 28 | tile.getX() << 14 | tile.getY() & 16383 | 1073741824;
      } else if (target instanceof Player) {
         Player p = (Player)target;
         hash = p.getIndex() & '\uffff' | 268435456;
      } else {
         NPC n = (NPC)target;
         hash = n.getIndex() & '\uffff';
      }

      stream.writePacket(this.player, 108);
      stream.writeShort128(graphics.getSpeed());
      stream.writeIntV2(hash);
      stream.writeByte128(0);
      stream.writeByte128(graphics.getSettings2Hash());
      stream.writeShort(graphics.getHeight());
      stream.writeShortLE(graphics.getId());
      this.session.write(stream);
   }

   public void sendDelayedGraphics(Graphics graphics, int delay, WorldTile tile) {
   }

   public void closeInterface(int windowComponentId) {
      this.closeInterface(this.player.getInterfaceManager().getTabWindow(windowComponentId), windowComponentId);
      this.player.getInterfaceManager().removeTab(windowComponentId);
   }

   public void closeInterface(int windowId, int windowComponentId) {
      OutputStream stream = new OutputStream(5);
      stream.writePacket(this.player, 73);
      stream.writeIntLE(windowId << 16 | windowComponentId);
      this.session.write(stream);
   }

   public void sendInterface(boolean nocliped, int windowId, int windowComponentId, int interfaceId) {
      if (windowId != 752 || windowComponentId != 9 && windowComponentId != 12) {
         if (this.player.getInterfaceManager().containsInterface(windowComponentId, interfaceId)) {
            this.closeInterface(windowComponentId);
         }

         if (!this.player.getInterfaceManager().addInterface(windowId, windowComponentId, interfaceId)) {
            System.err.println("Error adding interface: " + windowId + " , " + windowComponentId + " , " + interfaceId);
            return;
         }
      }

      OutputStream stream = new OutputStream(8);
      stream.writePacket(this.player, 5);
      stream.writeShortLE128(interfaceId);
      stream.writeIntLE(windowId << 16 | windowComponentId);
      stream.writeByte(nocliped ? 1 : 0);
      this.session.write(stream);
   }

   public void sendSystemUpdate(int delay) {
      OutputStream stream = new OutputStream(2);
      stream.writePacket(this.player, 125);
      stream.writeShort(delay * 50 / 30);
      this.session.write(stream);
   }

   public void sendUpdateItems(int key, ItemsContainer<Item> items, int... slots) {
      this.sendUpdateItems(key, items.getItems(), slots);
   }

   public void sendUpdateItems(int key, Item[] items, int... slots) {
      this.sendUpdateItems(key, key < 0, items, slots);
   }

   public void sendUpdateItems(int key, boolean negativeKey, ItemsContainer<Item> items, int... slots) {
      this.sendUpdateItems(key, negativeKey, items.getItems(), slots);
   }

   public void sendUpdateItems(int key, boolean negativeKey, Item[] items, int... slots) {
      OutputStream stream = new OutputStream();
      stream.writePacketVarShort(this.player, 80);
      stream.writeShort(key);
      stream.writeByte(negativeKey ? 1 : 0);
      int[] var9 = slots;
      int var8 = slots.length;

      for(int var7 = 0; var7 < var8; ++var7) {
         int slotId = var9[var7];
         if (slotId < items.length) {
            stream.writeSmart(slotId);
            int id = -1;
            int amount = 0;
            Item item = items[slotId];
            if (item != null) {
               id = item.getId();
               amount = item.getAmount();
            }

            stream.writeShort(id + 1);
            if (id != -1) {
               stream.writeByte(amount >= 255 ? 255 : amount);
               if (amount >= 255) {
                  stream.writeInt(amount);
               }
            }
         }
      }

      stream.endPacketVarShort();
      this.session.write(stream);
   }

   public void sendGlobalString(int id, String string) {
      OutputStream stream = new OutputStream();
      stream.writePacketVarByte(this.player, 54);
      stream.writeShortLE128(id);
      stream.writeString(string);
      stream.endPacketVarByte();
      this.session.write(stream);
   }

   public void sendLogout() {
      OutputStream stream = new OutputStream();
      stream.writePacket(this.player, 51);
      ChannelFuture future = this.session.write(stream);
      if (future != null) {
         future.addListener(ChannelFutureListener.CLOSE);
      } else {
         this.session.getChannel().close();
      }

   }

   public void sendGameMessage(String text) {
      this.sendGameMessage(text, false);
   }

   public void sendGameMessage(String text, boolean filter) {
      this.sendMessage(filter ? 109 : 0, text, (Player)null);
   }

   public void sendPanelBoxMessage(String text) {
      this.sendMessage(99, text, (Player)null);
   }

   public void sendURLMessage(String suffix, String url) {
      this.sendURLMessage(102, suffix + ": " + "<col=" + "000FF" + ">" + url + "</col>", url);
   }

   public void sendURLMessage(int type, String message, String url) {
      int maskData = 0;
      int maskData = maskData | 1;
      maskData |= 2;
      OutputStream stream = new OutputStream();
      stream.writePacketVarByte(this.player, 102);
      stream.writeSmart(type);
      stream.writeInt(0);
      stream.writeByte(maskData);
      stream.writeString("");
      stream.writeString(url);
      stream.writeString(message);
      stream.endPacketVarByte();
      this.session.write(stream);
   }

   public void sendTradeRequestMessage(Player p) {
      this.sendMessage(100, "wishes to trade with you.", p);
   }

   public void sendClanWarsRequestMessage(Player p) {
      this.sendMessage(101, "wishes to challenge your clan to a clan war.", p);
   }

   public void sendDuelChallengeRequestMessage(Player p, boolean friendly) {
      this.sendMessage(101, "wishes to duel with you(" + (friendly ? "friendly" : "stake") + ").", p);
   }

   public void sendMessage(int type, String text, Player p) {
      int maskData = 0;
      if (p != null) {
         maskData |= 1;
         if (p.hasDisplayName()) {
            maskData |= 2;
         }
      }

      OutputStream stream = new OutputStream();
      stream.writePacketVarByte(this.player, 102);
      stream.writeSmart(type);
      stream.writeInt(0);
      stream.writeByte(maskData);
      if ((maskData & 1) != 0) {
         stream.writeString(Utils.formatPlayerNameForDisplay(p.getUsername()));
         if (p.hasDisplayName()) {
            stream.writeString(p.getDisplayName());
         }
      }

      stream.writeString(text);
      stream.endPacketVarByte();
      this.session.write(stream);
   }

   public void sendSound(int id, int delay, int effectType) {
      if (effectType == 1) {
         this.sendIndex14Sound(id, delay);
      } else if (effectType == 2) {
         this.sendIndex15Sound(id, delay);
      }

   }

   public void sendVoice(int id) {
      this.resetSounds();
      this.sendSound(id, 0, 2);
   }

   public void resetSounds() {
      OutputStream stream = new OutputStream(1);
      stream.writePacket(this.player, 142);
      this.session.write(stream);
   }

   public void sendIndex14Sound(int id, int delay) {
      OutputStream stream = new OutputStream(9);
      stream.writePacket(this.player, 106);
      stream.writeShort(id);
      stream.writeByte(1);
      stream.writeShort(delay);
      stream.writeByte(255);
      stream.writeShort(256);
      this.session.write(stream);
   }

   public void sendIndex15Sound(int id, int delay) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 121);
      stream.writeShort(id);
      stream.writeByte(1);
      stream.writeShort(delay);
      stream.writeByte(0);
      this.session.write(stream);
   }

   public void sendMusicEffect(int id) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 0);
      stream.writeShort128(id);
      stream.write24BitInteger(0);
      stream.writeByteC(255);
      this.session.write(stream);
   }

   public void sendMusic(int id) {
      this.sendMusic(id, 100, 255);
   }

   public void sendMusic(int id, int delay, int volume) {
      OutputStream stream = new OutputStream(5);
      stream.writePacket(this.player, 31);
      stream.write128Byte(delay);
      stream.writeShortLE(id);
      stream.writeByteC(volume);
      this.session.write(stream);
   }

   public void sendSkillLevel(int skill) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 93);
      stream.write128Byte(this.player.getSkills().getLevel(skill));
      stream.writeByte128(skill);
      stream.writeIntLE((int)this.player.getSkills().getXp(skill));
      this.session.write(stream);
   }

   public void sendBlackOut(int area) {
      OutputStream out = new OutputStream(2);
      out.writePacket(this.player, 68);
      out.writeByte(area);
      this.session.write(out);
   }

   public void sendCameraLook(int viewLocalX, int viewLocalY, int viewZ) {
      this.sendCameraLook(viewLocalX, viewLocalY, viewZ, -1, -1);
   }

   public void sendCameraLook(int viewLocalX, int viewLocalY, int viewZ, int speed1, int speed2) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 127);
      stream.writeByteC(viewLocalY);
      stream.writeShortLE128(viewZ >> 2);
      stream.write128Byte(viewLocalX);
      stream.writeByte(speed1);
      stream.write128Byte(speed2);
      this.session.write(stream);
   }

   public void sendResetCamera() {
      OutputStream stream = new OutputStream(1);
      stream.writePacket(this.player, 10);
      this.session.write(stream);
   }

   public void sendCameraRotation(int unknown1, int unknown2) {
      OutputStream stream = new OutputStream(5);
      stream.writeShortLE128(unknown1);
      stream.writeShort128(unknown1);
      stream.writePacket(this.player, 107);
      this.session.write(stream);
   }

   public void sendCameraPos(int moveLocalX, int moveLocalY, int moveZ) {
      this.sendCameraPos(moveLocalX, moveLocalY, moveZ, -1, -1);
   }

   public void sendCameraPos(int moveLocalX, int moveLocalY, int moveZ, int speed1, int speed2) {
      OutputStream stream = new OutputStream(7);
      stream.writePacket(this.player, 29);
      stream.write128Byte(speed1);
      stream.writeByteC(moveLocalY);
      stream.writeByteC(moveLocalX);
      stream.writeByteC(speed2);
      stream.writeShortLE128(moveZ >> 2);
      this.session.write(stream);
   }

   public void sendInterFlashScript(int interfaceId, int componentId, int width, int height, int slot) {
      Object[] parameters = new Object[4];
      int index = 0;
      int var9 = index + 1;
      parameters[index] = slot;
      parameters[var9++] = height;
      parameters[var9++] = width;
      parameters[var9++] = interfaceId << 16 | componentId;
      this.sendRunScript(143, parameters);
   }

   public void sendInterSetItemsOptionsScript(int interfaceId, int componentId, int key, boolean negativeKey, int width, int height, String... options) {
      Object[] parameters = new Object[6 + options.length];
      int index = 0;

      for(int count = options.length - 1; count >= 0; --count) {
         parameters[index++] = options[count];
      }

      parameters[index++] = -1;
      parameters[index++] = 0;
      parameters[index++] = height;
      parameters[index++] = width;
      parameters[index++] = key;
      parameters[index++] = interfaceId << 16 | componentId;
      this.sendRunScript(negativeKey ? 695 : 150, parameters);
   }
}
