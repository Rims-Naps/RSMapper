package org.rsmapper.game.player;

import java.security.MessageDigest;
import java.util.Iterator;
import org.rsmapper.game.Hit;
import org.rsmapper.game.World;
import org.rsmapper.networking.codec.stream.OutputStream;
import org.rsmapper.utilities.misc.Utils;

public final class LocalPlayerUpdate {
   private static final int MAX_PLAYER_ADD = 1;
   private static final int MAX_PLAYERS_UPDATED = 255;
   private Player player;
   private Player[] localPlayers;
   private int[] localPlayersIndexes;
   private int localPlayersIndexesCount;
   private int[] outPlayersIndexes;
   private int outPlayersIndexesCount;
   private int[] regionHashes;
   private byte[][] cachedAppearencesHashes;
   private int totalRenderDataSentLength;
   private int localAddedPlayers;

   public Player[] getLocalPlayers() {
      return this.localPlayers;
   }

   public boolean needAppearenceUpdate(int index, byte[] hash) {
      if (this.totalRenderDataSentLength <= 3500 && hash != null) {
         return this.cachedAppearencesHashes[index] == null || !MessageDigest.isEqual(this.cachedAppearencesHashes[index], hash);
      } else {
         return false;
      }
   }

   public LocalPlayerUpdate(Player player) {
      this.player = player;
      this.localPlayers = new Player[2048];
      this.localPlayersIndexes = new int[2048];
      this.outPlayersIndexes = new int[2048];
      this.regionHashes = new int[2048];
      this.cachedAppearencesHashes = new byte[2048][];
   }

   public void init(OutputStream stream) {
      stream.initBitAccess();
      stream.writeBits(30, this.player.getTileHash());
      this.localPlayers[this.player.getIndex()] = this.player;
      this.localPlayersIndexes[this.localPlayersIndexesCount++] = this.player.getIndex();

      for(int playerIndex = 1; playerIndex < 2048; ++playerIndex) {
         if (playerIndex != this.player.getIndex()) {
            Player player = (Player)World.getPlayers().get(playerIndex);
            stream.writeBits(18, this.regionHashes[playerIndex] = player == null ? 0 : player.getRegionHash());
            this.outPlayersIndexes[this.outPlayersIndexesCount++] = playerIndex;
         }
      }

      stream.finishBitAccess();
   }

   private boolean needsRemove(Player p) {
      return p.hasFinished() || !this.player.withinDistance(p, 14);
   }

   private boolean needsAdd(Player p) {
      return p != null && !p.hasFinished() && this.player.withinDistance(p, 14) && this.localAddedPlayers < 1;
   }

   private void updateRegionHash(OutputStream stream, int lastRegionHash, int currentRegionHash) {
      int lastRegionX = lastRegionHash >> 8;
      int lastRegionY = 255 & lastRegionHash;
      int lastPlane = lastRegionHash >> 16;
      int currentRegionX = currentRegionHash >> 8;
      int currentRegionY = 255 & currentRegionHash;
      int currentPlane = currentRegionHash >> 16;
      int planeOffset = currentPlane - lastPlane;
      if (lastRegionX == currentRegionX && lastRegionY == currentRegionY) {
         stream.writeBits(2, 1);
         stream.writeBits(2, planeOffset);
      } else {
         int dx;
         if (Math.abs(currentRegionX - lastRegionX) <= 1 && Math.abs(currentRegionY - lastRegionY) <= 1) {
            dx = currentRegionX - lastRegionX;
            int dy = currentRegionY - lastRegionY;
            byte opcode;
            if (dx == -1 && dy == -1) {
               opcode = 0;
            } else if (dx == 1 && dy == -1) {
               opcode = 2;
            } else if (dx == -1 && dy == 1) {
               opcode = 5;
            } else if (dx == 1 && dy == 1) {
               opcode = 7;
            } else if (dy == -1) {
               opcode = 1;
            } else if (dx == -1) {
               opcode = 3;
            } else if (dx == 1) {
               opcode = 4;
            } else {
               opcode = 6;
            }

            stream.writeBits(2, 2);
            stream.writeBits(5, (planeOffset << 3) + (opcode & 7));
         } else {
            int xOffset = currentRegionX - lastRegionX;
            dx = currentRegionY - lastRegionY;
            stream.writeBits(2, 3);
            stream.writeBits(18, (dx & 255) + ((xOffset & 255) << 8) + (planeOffset << 16));
         }
      }

   }

   private void processOutsidePlayers(OutputStream stream, OutputStream updateBlockData) {
      stream.initBitAccess();
      int skip = 0;
      this.localAddedPlayers = 0;

      for(int i = 0; i < this.outPlayersIndexesCount; ++i) {
         int playerIndex = this.outPlayersIndexes[i];
         if (skip > 0) {
            --skip;
         } else {
            Player p = (Player)World.getPlayers().get(playerIndex);
            int hash;
            if (this.needsAdd(p)) {
               stream.writeBits(1, 1);
               stream.writeBits(2, 0);
               hash = p.getRegionHash();
               if (hash == this.regionHashes[playerIndex]) {
                  stream.writeBits(1, 0);
               } else {
                  stream.writeBits(1, 1);
                  this.updateRegionHash(stream, this.regionHashes[playerIndex], hash);
                  this.regionHashes[playerIndex] = hash;
               }

               stream.writeBits(6, p.getXInRegion());
               stream.writeBits(6, p.getYInRegion());
               boolean needAppearenceUpdate = this.needAppearenceUpdate(p.getIndex(), p.getAppearence().getMD5AppeareanceDataHash());
               this.appendUpdateBlock(p, updateBlockData, needAppearenceUpdate, true);
               stream.writeBits(1, 1);
               ++this.localAddedPlayers;
               this.localPlayers[p.getIndex()] = p;
            } else {
               hash = p == null ? this.regionHashes[playerIndex] : p.getRegionHash();
               if (p != null && hash != this.regionHashes[playerIndex]) {
                  stream.writeBits(1, 1);
                  this.updateRegionHash(stream, this.regionHashes[playerIndex], hash);
                  this.regionHashes[playerIndex] = hash;
               } else {
                  stream.writeBits(1, 0);

                  for(int i2 = i + 1; i2 < this.outPlayersIndexesCount; ++i2) {
                     int p2Index = this.outPlayersIndexes[i2];
                     Player p2 = (Player)World.getPlayers().get(p2Index);
                     if (this.needsAdd(p2) || p2 != null && p2.getRegionHash() != this.regionHashes[p2Index]) {
                        break;
                     }

                     ++skip;
                  }

                  this.skipPlayers(stream, skip);
               }
            }
         }
      }

      stream.finishBitAccess();
   }

   private void processLocalPlayers(OutputStream stream, OutputStream updateBlockData) {
      stream.initBitAccess();
      int skip = 0;
      int max = this.localPlayersIndexesCount > 255 ? 255 : this.localPlayersIndexesCount;

      for(int i = 0; i < max; ++i) {
         int playerIndex = this.localPlayersIndexes[i];
         if (skip > 0) {
            --skip;
         } else {
            Player p = this.localPlayers[playerIndex];
            if (this.needsRemove(p)) {
               stream.writeBits(1, 1);
               stream.writeBits(1, 0);
               stream.writeBits(2, 0);
               this.regionHashes[playerIndex] = p.getLastWorldTile() == null ? p.getRegionHash() : p.getLastWorldTile().getRegionHash();
               int hash = p.getRegionHash();
               if (hash == this.regionHashes[playerIndex]) {
                  stream.writeBits(1, 0);
               } else {
                  stream.writeBits(1, 1);
                  this.updateRegionHash(stream, this.regionHashes[playerIndex], hash);
                  this.regionHashes[playerIndex] = hash;
               }

               this.localPlayers[playerIndex] = null;
            } else {
               boolean needAppearenceUpdate = this.needAppearenceUpdate(p.getIndex(), p.getAppearence().getMD5AppeareanceDataHash());
               boolean needUpdate = p.needMasksUpdate() || needAppearenceUpdate;
               if (needUpdate) {
                  this.appendUpdateBlock(p, updateBlockData, needAppearenceUpdate, false);
               }

               int i2;
               int p2Index;
               if (p.hasTeleported()) {
                  stream.writeBits(1, 1);
                  stream.writeBits(1, needUpdate ? 1 : 0);
                  stream.writeBits(2, 3);
                  i2 = p.getX() - p.getLastWorldTile().getX();
                  p2Index = p.getY() - p.getLastWorldTile().getY();
                  int planeOffset = p.getPlane() - p.getLastWorldTile().getPlane();
                  if (Math.abs(p.getX() - p.getLastWorldTile().getX()) <= 14 && Math.abs(p.getY() - p.getLastWorldTile().getY()) <= 14) {
                     stream.writeBits(1, 0);
                     if (i2 < 0) {
                        i2 += 32;
                     }

                     if (p2Index < 0) {
                        p2Index += 32;
                     }

                     stream.writeBits(12, p2Index + (i2 << 5) + (planeOffset << 10));
                  } else {
                     stream.writeBits(1, 1);
                     stream.writeBits(30, (p2Index & 16383) + ((i2 & 16383) << 14) + ((planeOffset & 3) << 28));
                  }
               } else if (p.getNextWalkDirection() != -1) {
                  i2 = Utils.DIRECTION_DELTA_X[p.getNextWalkDirection()];
                  p2Index = Utils.DIRECTION_DELTA_Y[p.getNextWalkDirection()];
                  int opcode;
                  boolean running;
                  if (p.getNextRunDirection() != -1) {
                     i2 += Utils.DIRECTION_DELTA_X[p.getNextRunDirection()];
                     p2Index += Utils.DIRECTION_DELTA_Y[p.getNextRunDirection()];
                     opcode = Utils.getPlayerRunningDirection(i2, p2Index);
                     if (opcode == -1) {
                        running = false;
                        opcode = Utils.getPlayerWalkingDirection(i2, p2Index);
                     } else {
                        running = true;
                     }
                  } else {
                     running = false;
                     opcode = Utils.getPlayerWalkingDirection(i2, p2Index);
                  }

                  stream.writeBits(1, 1);
                  if (i2 == 0 && p2Index == 0) {
                     stream.writeBits(1, 1);
                     stream.writeBits(2, 0);
                     if (!needUpdate) {
                        this.appendUpdateBlock(p, updateBlockData, needAppearenceUpdate, false);
                     }
                  } else {
                     stream.writeBits(1, needUpdate ? 1 : 0);
                     stream.writeBits(2, running ? 2 : 1);
                     stream.writeBits(running ? 4 : 3, opcode);
                  }
               } else if (needUpdate) {
                  stream.writeBits(1, 1);
                  stream.writeBits(1, 1);
                  stream.writeBits(2, 0);
               } else {
                  stream.writeBits(1, 0);

                  for(i2 = i + 1; i2 < max; ++i2) {
                     p2Index = this.localPlayersIndexes[i2];
                     Player p2 = this.localPlayers[p2Index];
                     if (this.needsRemove(p2) || p2.hasTeleported() || p2.getNextWalkDirection() != -1 || p2.needMasksUpdate() || this.needAppearenceUpdate(p2.getIndex(), p2.getAppearence().getMD5AppeareanceDataHash())) {
                        break;
                     }

                     ++skip;
                  }

                  this.skipPlayers(stream, skip);
               }
            }
         }
      }

      stream.finishBitAccess();
   }

   private void skipPlayers(OutputStream stream, int amount) {
      stream.writeBits(2, amount == 0 ? 0 : (amount > 255 ? 3 : (amount > 31 ? 2 : 1)));
      if (amount > 0) {
         stream.writeBits(amount > 255 ? 11 : (amount > 31 ? 8 : 5), amount);
      }

   }

   private void appendUpdateBlock(Player p, OutputStream data, boolean needAppearenceUpdate, boolean added) {
      int maskData = 0;
      if (p.getNextAnimation() != null) {
         maskData |= 64;
      }

      if (p.getNextGraphics3() != null) {
         maskData |= 262144;
      }

      if (p.getTemporaryMoveType() != -1) {
         maskData |= 512;
      }

      if (p.getNextGraphics4() != null) {
         maskData |= 524288;
      }

      if (!p.getNextHits().isEmpty()) {
         maskData |= 4;
      }

      if (needAppearenceUpdate) {
         maskData |= 8;
      }

      if (p.getNextForceTalk() != null) {
         maskData |= 16384;
      }

      if (added || p.isUpdateMovementType()) {
         maskData |= 1;
      }

      if (p.getNextFaceEntity() != -2 || added && p.getLastFaceEntity() != -1) {
         maskData |= 16;
      }

      if (p.getNextForceMovement() != null) {
         maskData |= 4096;
      }

      if (added || p.getNextFaceWorldTile() != null && p.getNextRunDirection() == -1 && p.getNextWalkDirection() == -1) {
         maskData |= 32;
      }

      if (p.getNextGraphics1() != null) {
         maskData |= 2;
      }

      if (p.getNextGraphics2() != null) {
         maskData |= 256;
      }

      if (maskData >= 256) {
         maskData |= 128;
      }

      if (maskData >= 65536) {
         maskData |= 2048;
      }

      data.writeByte(maskData);
      if (maskData >= 256) {
         data.writeByte(maskData >> 8);
      }

      if (maskData >= 65536) {
         data.writeByte(maskData >> 16);
      }

      if (p.getNextAnimation() != null) {
         this.applyAnimationMask(p, data);
      }

      if (p.getNextGraphics3() != null) {
         this.applyGraphicsMask3(p, data);
      }

      if (p.getTemporaryMoveType() != -1) {
         this.applyTemporaryMoveTypeMask(p, data);
      }

      if (p.getNextGraphics4() != null) {
         this.applyGraphicsMask4(p, data);
      }

      if (!p.getNextHits().isEmpty()) {
         this.applyHitsMask(p, data);
      }

      if (needAppearenceUpdate) {
         this.applyAppearanceMask(p, data);
      }

      if (p.getNextForceTalk() != null && p.getNextForceTalk().getText() != null && !p.getNextForceTalk().getText().isEmpty()) {
         this.applyForceTalkMask(p, data);
      }

      if (added || p.isUpdateMovementType()) {
         this.applyMoveTypeMask(p, data);
      }

      if (p.getNextFaceEntity() != -2 || added && p.getLastFaceEntity() != -1) {
         this.applyFaceEntityMask(p, data);
      }

      if (p.getNextForceMovement() != null) {
         this.applyForceMovementMask(p, data);
      }

      if (added || p.getNextFaceWorldTile() != null && p.getNextRunDirection() == -1 && p.getNextWalkDirection() == -1) {
         this.applyFaceDirectionMask(p, data);
      }

      if (p.getNextGraphics1() != null) {
         this.applyGraphicsMask1(p, data);
      }

      if (p.getNextGraphics2() != null) {
         this.applyGraphicsMask2(p, data);
      }

   }

   private void applyForceTalkMask(Player p, OutputStream data) {
      data.writeString(p.getNextForceTalk().getText());
   }

   private void applyHitsMask(Player p, OutputStream data) {
      int count = p.getNextHits().size();
      data.writeByte(count);
      if (count > 0) {
         int hp = p.getHitpoints();
         int maxHp = p.getMaxHitpoints();
         if (hp > maxHp) {
            hp = maxHp;
         }

         int hpBarPercentage = hp != 0 && maxHp != 0 ? hp * 255 / maxHp : 0;
         Iterator var8 = p.getNextHits().iterator();

         while(var8.hasNext()) {
            Hit hit = (Hit)var8.next();
            boolean interactingWith = hit.interactingWith(this.player, p);
            if (hit.missed() && !interactingWith) {
               data.writeSmart(32766);
            } else if (hit.getSoaking() != null) {
               data.writeSmart(32767);
               data.writeSmart(hit.getMark(this.player, p));
               data.writeSmart(hit.getDamage());
               data.writeSmart(hit.getSoaking().getMark(this.player, p));
               data.writeSmart(hit.getSoaking().getDamage());
            } else {
               data.writeSmart(hit.getMark(this.player, p));
               data.writeSmart(hit.getDamage());
            }

            data.writeSmart(hit.getDelay());
            data.writeByteC(hpBarPercentage);
         }
      }

   }

   private void applyFaceEntityMask(Player p, OutputStream data) {
      data.writeShort128(p.getNextFaceEntity() == -2 ? p.getLastFaceEntity() : p.getNextFaceEntity());
   }

   private void applyFaceDirectionMask(Player p, OutputStream data) {
      data.writeShort(p.getDirection());
   }

   private void applyMoveTypeMask(Player p, OutputStream data) {
      data.write128Byte(p.getRun() ? 2 : 1);
   }

   private void applyTemporaryMoveTypeMask(Player p, OutputStream data) {
      data.writeByteC(p.getTemporaryMoveType());
   }

   private void applyGraphicsMask1(Player p, OutputStream data) {
      data.writeShort(p.getNextGraphics1().getId());
      data.writeIntLE(p.getNextGraphics1().getSettingsHash());
      data.writeByte128(p.getNextGraphics1().getSettings2Hash());
   }

   private void applyGraphicsMask2(Player p, OutputStream data) {
      data.writeShortLE128(p.getNextGraphics2().getId());
      data.writeIntV2(p.getNextGraphics2().getSettingsHash());
      data.writeByteC(p.getNextGraphics2().getSettings2Hash());
   }

   private void applyGraphicsMask3(Player p, OutputStream data) {
      data.writeShortLE128(p.getNextGraphics3().getId());
      data.writeIntV2(p.getNextGraphics3().getSettingsHash());
      data.writeByteC(p.getNextGraphics3().getSettings2Hash());
   }

   private void applyGraphicsMask4(Player p, OutputStream data) {
      data.writeShortLE(p.getNextGraphics4().getId());
      data.writeIntV2(p.getNextGraphics4().getSettingsHash());
      data.writeByteC(p.getNextGraphics4().getSettings2Hash());
   }

   private void applyAnimationMask(Player p, OutputStream data) {
      int[] var6;
      int var5 = (var6 = p.getNextAnimation().getIds()).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         int id = var6[var4];
         data.writeShortLE(id);
      }

      data.writeByte128(p.getNextAnimation().getSpeed());
   }

   private void applyAppearanceMask(Player p, OutputStream data) {
      byte[] renderData = p.getAppearence().getAppeareanceData();
      this.totalRenderDataSentLength += renderData.length;
      this.cachedAppearencesHashes[p.getIndex()] = p.getAppearence().getMD5AppeareanceDataHash();
      data.write128Byte(renderData.length);
      data.writeBytes(renderData);
   }

   private void applyForceMovementMask(Player p, OutputStream data) {
      data.write128Byte(p.getNextForceMovement().getToFirstTile().getX() - p.getX());
      data.writeByte(p.getNextForceMovement().getToFirstTile().getY() - p.getY());
      data.writeByte128(p.getNextForceMovement().getToSecondTile() == null ? 0 : p.getNextForceMovement().getToSecondTile().getX() - p.getX());
      data.writeByte128(p.getNextForceMovement().getToSecondTile() == null ? 0 : p.getNextForceMovement().getToSecondTile().getY() - p.getY());
      data.writeShortLE(p.getNextForceMovement().getFirstTileTicketDelay() * 30);
      data.writeShortLE128(p.getNextForceMovement().getToSecondTile() == null ? 0 : p.getNextForceMovement().getSecondTileTicketDelay() * 30);
      data.writeByte128(p.getNextForceMovement().getDirection());
   }

   public OutputStream createPacketAndProcess() {
      OutputStream stream = new OutputStream();
      OutputStream updateBlockData = new OutputStream();
      stream.writePacketVarShort(this.player, 69);
      this.processLocalPlayers(stream, updateBlockData);
      this.processOutsidePlayers(stream, updateBlockData);
      stream.writeBytes(updateBlockData.getBuffer(), 0, updateBlockData.getOffset());
      stream.endPacketVarShort();
      this.totalRenderDataSentLength = 0;
      this.localPlayersIndexesCount = 0;
      this.outPlayersIndexesCount = 0;

      for(int playerIndex = 1; playerIndex < 2048; ++playerIndex) {
         Player player = this.localPlayers[playerIndex];
         if (player == null) {
            this.outPlayersIndexes[this.outPlayersIndexesCount++] = playerIndex;
         } else {
            this.localPlayersIndexes[this.localPlayersIndexesCount++] = playerIndex;
         }
      }

      return stream;
   }
}
