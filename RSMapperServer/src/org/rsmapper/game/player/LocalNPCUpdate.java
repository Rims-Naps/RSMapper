package org.rsmapper.game.player;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.rsmapper.game.Hit;
import org.rsmapper.game.World;
import org.rsmapper.game.npc.NPC;
import org.rsmapper.networking.codec.stream.OutputStream;
import org.rsmapper.utilities.misc.Utils;

public final class LocalNPCUpdate {
   private final Player player;
   private final LinkedList<NPC> localNPCs;

   public void reset() {
      this.localNPCs.clear();
   }

   public LocalNPCUpdate(Player player) {
      this.player = player;
      this.localNPCs = new LinkedList();
   }

   public OutputStream createPacketAndProcess() {
      OutputStream stream = new OutputStream();
      OutputStream updateBlockData = new OutputStream();
      stream.writePacketVarShort(this.player, 6);
      this.processLocalNPCsInform(stream, updateBlockData);
      stream.writeBytes(updateBlockData.getBuffer(), 0, updateBlockData.getOffset());
      stream.endPacketVarShort();
      return stream;
   }

   private void processLocalNPCsInform(OutputStream stream, OutputStream updateBlockData) {
      stream.initBitAccess();
      this.processInScreenNPCs(stream, updateBlockData);
      this.addInScreenNPCs(stream, updateBlockData);
      if (updateBlockData.getOffset() > 0) {
         stream.writeBits(15, 32767);
      }

      stream.finishBitAccess();
   }

   private void processInScreenNPCs(OutputStream stream, OutputStream updateBlockData) {
      stream.writeBits(8, this.localNPCs.size());
      Iterator it = this.localNPCs.iterator();

      while(true) {
         while(it.hasNext()) {
            NPC n = (NPC)it.next();
            if (!n.hasFinished() && this.player.withinDistance(n) && !n.hasTeleported()) {
               boolean needUpdate = updateBlockData.getOffset() + stream.getOffset() < 7000 && n.needMasksUpdate();
               boolean walkUpdate = n.getNextWalkDirection() != -1;
               stream.writeBits(1, !needUpdate && !walkUpdate ? 0 : 1);
               if (walkUpdate) {
                  stream.writeBits(2, n.getNextRunDirection() == -1 ? 1 : 2);
                  if (n.getNextRunDirection() != -1) {
                     stream.writeBits(1, 1);
                  }

                  stream.writeBits(3, Utils.getNpcMoveDirection(n.getNextWalkDirection()));
                  if (n.getNextRunDirection() != -1) {
                     stream.writeBits(3, Utils.getNpcMoveDirection(n.getNextRunDirection()));
                  }

                  stream.writeBits(1, needUpdate ? 1 : 0);
               } else if (needUpdate) {
                  stream.writeBits(2, 0);
               }

               if (needUpdate) {
                  this.appendUpdateBlock(n, updateBlockData, false);
               }
            } else {
               stream.writeBits(1, 1);
               stream.writeBits(2, 3);
               it.remove();
            }
         }

         return;
      }
   }

   private void addInScreenNPCs(OutputStream stream, OutputStream updateBlockData) {
      Iterator var4 = this.player.getMapRegionsIds().iterator();

      label85:
      while(true) {
         List indexes;
         do {
            if (!var4.hasNext()) {
               return;
            }

            int regionId = (Integer)var4.next();
            indexes = World.getRegion(regionId).getNPCsIndexes();
         } while(indexes == null);

         Iterator var7 = indexes.iterator();

         while(true) {
            NPC n;
            do {
               do {
                  do {
                     do {
                        do {
                           if (!var7.hasNext()) {
                              continue label85;
                           }

                           int npcIndex = (Integer)var7.next();
                           if (this.localNPCs.size() == 127 || updateBlockData.getOffset() + stream.getOffset() > 7000) {
                              continue label85;
                           }

                           n = (NPC)World.getNPCs().get(npcIndex);
                        } while(n == null);
                     } while(n.hasFinished());
                  } while(this.localNPCs.contains(n));
               } while(!this.player.withinDistance(n));
            } while(n.isDead());

            stream.writeBits(15, n.getIndex());
            stream.writeBits(3, 0);
            boolean needUpdate = n.needMasksUpdate() || n.getLastFaceEntity() != -1;
            stream.writeBits(1, needUpdate ? 1 : 0);
            int y = n.getY() - this.player.getY();
            if (y < 15) {
               y += 32;
            }

            stream.writeBits(5, y);
            stream.writeBits(2, n.getPlane());
            stream.writeBits(15, n.getId());
            int x = n.getX() - this.player.getX();
            if (x < 15) {
               x += 32;
            }

            stream.writeBits(5, x);
            stream.writeBits(1, n.hasTeleported() ? 1 : 0);
            this.localNPCs.add(n);
            if (needUpdate) {
               this.appendUpdateBlock(n, updateBlockData, true);
            }
         }
      }
   }

   private void appendUpdateBlock(NPC n, OutputStream data, boolean added) {
      int maskData = 0;
      if (n.getNextGraphics3() != null) {
         maskData |= 1048576;
      }

      if (n.getNextFaceEntity() != -2 || added && n.getLastFaceEntity() != -1) {
         maskData |= 1;
      }

      if (n.getNextGraphics4() != null) {
         maskData |= 131072;
      }

      if (!n.getNextHits().isEmpty()) {
         maskData |= 64;
      }

      if (n.hasChangedName() || added && n.getCustomName() != null) {
         maskData |= 262144;
      }

      if (n.getNextForceTalk() != null) {
         maskData |= 2;
      }

      if (n.getNextFaceWorldTile() != null && n.getNextRunDirection() == -1 && n.getNextWalkDirection() == -1) {
         maskData |= 8;
      }

      if (n.getNextForceMovement() != null) {
         maskData |= 1024;
      }

      if (n.hasChangedCombatLevel() || added && n.getCustomCombatLevel() >= 0) {
         maskData |= 524288;
      }

      if (n.getNextAnimation() != null) {
         maskData |= 16;
      }

      if (n.getNextGraphics2() != null) {
         maskData |= 4096;
      }

      if (n.getNextGraphics1() != null) {
         maskData |= 4;
      }

      if (maskData >= 256) {
         maskData |= 128;
      }

      if (maskData >= 65536) {
         maskData |= 32768;
      }

      data.writeByte(maskData);
      if (maskData >= 256) {
         data.writeByte(maskData >> 8);
      }

      if (maskData >= 65536) {
         data.writeByte(maskData >> 16);
      }

      if (n.getNextGraphics3() != null) {
         this.applyGraphicsMask3(n, data);
      }

      if (n.getNextFaceEntity() != -2 || added && n.getLastFaceEntity() != -1) {
         this.applyFaceEntityMask(n, data);
      }

      if (n.getNextGraphics4() != null) {
         this.applyGraphicsMask4(n, data);
      }

      if (!n.getNextHits().isEmpty()) {
         this.applyHitMask(n, data);
      }

      if (n.hasChangedName() || added && n.getCustomName() != null) {
         this.applyNameChangeMask(n, data);
      }

      if (n.getNextForceTalk() != null) {
         this.applyForceTalkMask(n, data);
      }

      if (n.getNextFaceWorldTile() != null) {
         this.applyFaceWorldTileMask(n, data);
      }

      if (n.getNextForceMovement() != null) {
         this.applyForceMovementMask(n, data);
      }

      if (n.hasChangedCombatLevel() || added && n.getCustomCombatLevel() >= 0) {
         this.applyChangeLevelMask(n, data);
      }

      if (n.getNextAnimation() != null) {
         this.applyAnimationMask(n, data);
      }

      if (n.getNextGraphics2() != null) {
         this.applyGraphicsMask2(n, data);
      }

      if (n.getNextGraphics1() != null) {
         this.applyGraphicsMask1(n, data);
      }

   }

   private void applyChangeLevelMask(NPC n, OutputStream data) {
      data.writeShortLE(n.getCombatLevel());
   }

   private void applyNameChangeMask(NPC npc, OutputStream data) {
      data.writeString(npc.getName());
   }

   private void applyForceTalkMask(NPC n, OutputStream data) {
      data.writeString(n.getNextForceTalk().getText());
   }

   private void applyForceMovementMask(NPC n, OutputStream data) {
      data.write128Byte(n.getNextForceMovement().getToFirstTile().getX() - n.getX());
      data.write128Byte(n.getNextForceMovement().getToFirstTile().getY() - n.getY());
      data.writeByteC(n.getNextForceMovement().getToSecondTile() == null ? 0 : n.getNextForceMovement().getToSecondTile().getX() - n.getX());
      data.writeByteC(n.getNextForceMovement().getToSecondTile() == null ? 0 : n.getNextForceMovement().getToSecondTile().getY() - n.getY());
      data.writeShort(n.getNextForceMovement().getFirstTileTicketDelay() * 600 / 20);
      data.writeShortLE128(n.getNextForceMovement().getToSecondTile() == null ? 0 : n.getNextForceMovement().getSecondTileTicketDelay() * 600 / 20);
      data.write128Byte(n.getNextForceMovement().getDirection());
   }

   private void applyFaceWorldTileMask(NPC n, OutputStream data) {
      data.writeShortLE(n.getNextFaceWorldTile().getX() * 2 + 1);
      data.writeShortLE(n.getNextFaceWorldTile().getY() * 2 + 1);
   }

   private void applyHitMask(NPC n, OutputStream data) {
      int count = n.getNextHits().size();
      data.writeByteC(count);
      if (count > 0) {
         int hp = n.getHitpoints();
         int maxHp = n.getMaxHitpoints();
         if (hp > maxHp) {
            hp = maxHp;
         }

         int hpBarPercentage = hp * 255 / maxHp;
         Iterator var8 = n.getNextHits().iterator();

         while(var8.hasNext()) {
            Hit hit = (Hit)var8.next();
            boolean interactingWith = hit.interactingWith(this.player, n);
            if (hit.missed() && !interactingWith) {
               data.writeSmart(32766);
            } else if (hit.getSoaking() != null) {
               data.writeSmart(32767);
               data.writeSmart(hit.getMark(this.player, n));
               data.writeSmart(hit.getDamage());
               data.writeSmart(hit.getSoaking().getMark(this.player, n));
               data.writeSmart(hit.getSoaking().getDamage());
            } else {
               data.writeSmart(hit.getMark(this.player, n));
               data.writeSmart(hit.getDamage());
            }

            data.writeSmart(hit.getDelay());
            data.writeByte(hpBarPercentage);
         }
      }

   }

   private void applyFaceEntityMask(NPC n, OutputStream data) {
      data.writeShortLE(n.getNextFaceEntity() == -2 ? n.getLastFaceEntity() : n.getNextFaceEntity());
   }

   private void applyAnimationMask(NPC n, OutputStream data) {
      int[] var6;
      int var5 = (var6 = n.getNextAnimation().getIds()).length;

      for(int var4 = 0; var4 < var5; ++var4) {
         int id = var6[var4];
         data.writeShort(id);
      }

      data.writeByte(n.getNextAnimation().getSpeed());
   }

   private void applyGraphicsMask4(NPC n, OutputStream data) {
      data.writeShort(n.getNextGraphics4().getId());
      data.writeInt(n.getNextGraphics4().getSettingsHash());
      data.writeByte(n.getNextGraphics4().getSettings2Hash());
   }

   private void applyGraphicsMask3(NPC n, OutputStream data) {
      data.writeShort(n.getNextGraphics3().getId());
      data.writeInt(n.getNextGraphics3().getSettingsHash());
      data.writeByte128(n.getNextGraphics3().getSettings2Hash());
   }

   private void applyGraphicsMask2(NPC n, OutputStream data) {
      data.writeShort128(n.getNextGraphics2().getId());
      data.writeInt(n.getNextGraphics2().getSettingsHash());
      data.writeByte(n.getNextGraphics2().getSettings2Hash());
   }

   private void applyGraphicsMask1(NPC n, OutputStream data) {
      data.writeShortLE(n.getNextGraphics1().getId());
      data.writeIntV2(n.getNextGraphics1().getSettingsHash());
      data.writeByteC(n.getNextGraphics1().getSettings2Hash());
   }
}
