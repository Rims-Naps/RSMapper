package org.rsmapper.game.player;

import java.io.Serializable;
import org.rsmapper.cache.loaders.ItemEquipIds;
import org.rsmapper.cache.loaders.NPCDefinitions;
import org.rsmapper.game.World;
import org.rsmapper.game.item.Item;
import org.rsmapper.networking.codec.stream.OutputStream;
import org.rsmapper.utilities.misc.Utils;

public class Appearence implements Serializable {
   private static final long serialVersionUID = 7655608569741626586L;
   private transient int renderEmote = -1;
   private int title = -1;
   private int[] lookI;
   private byte[] colour;
   private boolean male = true;
   private transient boolean glowRed;
   private transient byte[] appeareanceData;
   private transient byte[] md5AppeareanceDataHash;
   private transient short transformedNpcId;
   private transient boolean hidePlayer;
   private transient Player player;

   public Appearence() {
      this.resetAppearence();
   }

   public void setGlowRed(boolean glowRed) {
      this.glowRed = glowRed;
      this.generateAppearenceData();
   }

   public void setPlayer(Player player) {
      this.player = player;
      this.transformedNpcId = -1;
      this.renderEmote = -1;
      if (this.lookI == null) {
         this.resetAppearence();
      }

   }

   public void transformIntoNPC(int id) {
      this.transformedNpcId = (short)id;
      this.generateAppearenceData();
   }

   public void switchHidden() {
      this.hidePlayer = !this.hidePlayer;
      this.generateAppearenceData();
   }

   public void setHidden(boolean hide) {
      this.hidePlayer = hide;
      this.generateAppearenceData();
   }

   public boolean isHidden() {
      return this.hidePlayer;
   }

   public void generateAppearenceData() {
      OutputStream stream = new OutputStream();
      int flag = 0;
      if (!this.male) {
         flag |= 1;
      }

      if (this.transformedNpcId >= 0 && NPCDefinitions.getNPCDefinitions(this.transformedNpcId).aBoolean3190) {
         flag |= 2;
      }

      stream.writeByte(flag);
      stream.writeByte(this.title);
      stream.writeString("");
      stream.writeByte(-1);
      stream.writeByte(-1);
      stream.writeByte(this.hidePlayer ? 1 : 0);
      int hash;
      int pos;
      if (this.transformedNpcId >= 0) {
         stream.writeShort(-1);
         stream.writeShort(this.transformedNpcId);
         stream.writeByte(0);
      } else {
         for(int index = 0; index < 4; ++index) {
            Item item = this.player.getEquipment().getItems().get(index);
            if (this.glowRed) {
               if (index == 0) {
                  stream.writeShort('耀' + ItemEquipIds.getEquipId(2910));
                  continue;
               }

               if (index == 1) {
                  stream.writeShort('耀' + ItemEquipIds.getEquipId(14641));
                  continue;
               }
            }

            if (item == null) {
               stream.writeByte(0);
            } else {
               stream.writeShort('耀' + item.getEquipId());
            }
         }

         Item item = this.player.getEquipment().getItems().get(4);
         stream.writeShort(item == null ? 256 + this.lookI[2] : '耀' + item.getEquipId());
         item = this.player.getEquipment().getItems().get(5);
         if (item == null) {
            stream.writeByte(0);
         } else {
            stream.writeShort('耀' + item.getEquipId());
         }

         item = this.player.getEquipment().getItems().get(4);
         if (item != null && Equipment.hideArms(item)) {
            stream.writeByte(0);
         } else {
            stream.writeShort(256 + this.lookI[3]);
         }

         item = this.player.getEquipment().getItems().get(7);
         stream.writeShort(this.glowRed ? '耀' + ItemEquipIds.getEquipId(2908) : (item == null ? 256 + this.lookI[5] : '耀' + item.getEquipId()));
         item = this.player.getEquipment().getItems().get(0);
         if (this.glowRed || item != null && Equipment.hideHair(item)) {
            stream.writeByte(0);
         } else {
            stream.writeShort(256 + this.lookI[0]);
         }

         item = this.player.getEquipment().getItems().get(9);
         stream.writeShort(this.glowRed ? '耀' + ItemEquipIds.getEquipId(2912) : (item == null ? 256 + this.lookI[4] : '耀' + item.getEquipId()));
         item = this.player.getEquipment().getItems().get(10);
         stream.writeShort(this.glowRed ? '耀' + ItemEquipIds.getEquipId(2904) : (item == null ? 256 + this.lookI[6] : '耀' + item.getEquipId()));
         item = this.player.getEquipment().getItems().get(this.male ? 0 : 4);
         if (item != null && (!this.male || !Equipment.showBeard(item))) {
            stream.writeByte(0);
         } else {
            stream.writeShort(256 + this.lookI[1]);
         }

         item = this.player.getEquipment().getItems().get(14);
         if (item == null) {
            stream.writeByte(0);
         } else {
            stream.writeShort('耀' + item.getEquipId());
         }

         pos = stream.getOffset();
         stream.writeShort(0);
         hash = 0;
         int slotFlag = -1;

         int slotId;
         for(slotId = 0; slotId < this.player.getEquipment().getItems().getSize(); ++slotId) {
            if (Equipment.DISABLED_SLOTS[slotId] == 0) {
               ++slotFlag;
               if (slotId == 0) {
                  int hatId = this.player.getEquipment().getHatId();
                  if (hatId == 20768 || hatId == 20770 || hatId == 20772) {
                     hash |= 1 << slotFlag;
                     stream.writeByte(4);
                     int slots = 12816;
                     stream.writeShort(slots);

                     for(int i = 0; i < 4; ++i) {
                        stream.writeShort(0);
                     }
                  }
               } else if (slotId != 3 && slotId != 1) {
               }
            }
         }

         slotId = stream.getOffset();
         stream.setOffset(pos);
         stream.writeShort(hash);
         stream.setOffset(slotId);
      }

      byte[] var16;
      hash = (var16 = this.colour).length;

      for(pos = 0; pos < hash; ++pos) {
         byte element = var16[pos];
         stream.writeByte(element);
      }

      stream.writeShort(this.getRenderEmote());
      stream.writeString(this.player.getDisplayName());
      boolean pvpArea = World.isPvpArea(this.player);
      stream.writeByte(pvpArea ? this.player.getSkills().getCombatLevel() : this.player.getSkills().getCombatLevelWithSummoning());
      stream.writeByte(pvpArea ? this.player.getSkills().getCombatLevelWithSummoning() : 0);
      stream.writeByte(-1);
      stream.writeByte(this.transformedNpcId >= 0 ? 1 : 0);
      if (this.transformedNpcId >= 0) {
         NPCDefinitions defs = NPCDefinitions.getNPCDefinitions(this.transformedNpcId);
         stream.writeShort(defs.anInt876);
         stream.writeShort(defs.anInt842);
         stream.writeShort(defs.anInt884);
         stream.writeShort(defs.anInt875);
         stream.writeByte(defs.anInt875);
      }

      byte[] appeareanceData = new byte[stream.getOffset()];
      System.arraycopy(stream.getBuffer(), 0, appeareanceData, 0, appeareanceData.length);
      byte[] md5Hash = Utils.encryptUsingMD5(appeareanceData);
      this.appeareanceData = appeareanceData;
      this.md5AppeareanceDataHash = md5Hash;
   }

   public int getSize() {
      return this.transformedNpcId >= 0 ? NPCDefinitions.getNPCDefinitions(this.transformedNpcId).size : 1;
   }

   public void setRenderEmote(int id) {
      this.renderEmote = id;
      this.generateAppearenceData();
   }

   public int getRenderEmote() {
      if (this.renderEmote >= 0) {
         return this.renderEmote;
      } else {
         return this.transformedNpcId >= 0 ? NPCDefinitions.getNPCDefinitions(this.transformedNpcId).renderEmote : this.player.getEquipment().getWeaponRenderEmote();
      }
   }

   public void resetAppearence() {
      this.lookI = new int[7];
      this.colour = new byte[10];
      this.male();
   }

   public void male() {
      this.lookI[0] = 3;
      this.lookI[1] = 14;
      this.lookI[2] = 18;
      this.lookI[3] = 26;
      this.lookI[4] = 34;
      this.lookI[5] = 38;
      this.lookI[6] = 42;
      this.colour[2] = 16;
      this.colour[1] = 16;
      this.colour[0] = 3;
      this.male = true;
   }

   public void female() {
      this.lookI[0] = 48;
      this.lookI[1] = 57;
      this.lookI[2] = 57;
      this.lookI[3] = 65;
      this.lookI[4] = 68;
      this.lookI[5] = 77;
      this.lookI[6] = 80;
      this.colour[2] = 16;
      this.colour[1] = 16;
      this.colour[0] = 3;
      this.male = false;
   }

   public byte[] getAppeareanceData() {
      return this.appeareanceData;
   }

   public byte[] getMD5AppeareanceDataHash() {
      return this.md5AppeareanceDataHash;
   }

   public boolean isMale() {
      return this.male;
   }

   public void setLook(int i, int i2) {
      this.lookI[i] = i2;
   }

   public void setColor(int i, int i2) {
      this.colour[i] = (byte)i2;
   }

   public void setMale(boolean male) {
      this.male = male;
   }

   public void setHairStyle(int i) {
      this.lookI[0] = i;
   }

   public void setTopStyle(int i) {
      this.lookI[2] = i;
   }

   public int getTopStyle() {
      return this.lookI[2];
   }

   public void setArmsStyle(int i) {
      this.lookI[3] = i;
   }

   public void setWristsStyle(int i) {
      this.lookI[4] = i;
   }

   public void setLegsStyle(int i) {
      this.lookI[5] = i;
   }

   public void setBootsStyle(int i) {
      this.lookI[6] = i;
   }

   public int getHairStyle() {
      return this.lookI[0];
   }

   public void setBeardStyle(int i) {
      this.lookI[1] = i;
   }

   public int getBeardStyle() {
      return this.lookI[1];
   }

   public void setFacialHair(int i) {
      this.lookI[1] = i;
   }

   public int getFacialHair() {
      return this.lookI[1];
   }

   public void setSkinColor(int color) {
      this.colour[4] = (byte)color;
   }

   public void setBootsColor(int color) {
      this.colour[3] = (byte)color;
   }

   public int getSkinColor() {
      return this.colour[4];
   }

   public void setHairColor(int color) {
      this.colour[0] = (byte)color;
   }

   public void setTopColor(int color) {
      this.colour[1] = (byte)color;
   }

   public void setLegsColor(int color) {
      this.colour[2] = (byte)color;
   }

   public int getHairColor() {
      return this.colour[0];
   }

   public void forceTitle(int title) {
      this.title = title;
   }

   public void setTitle(int title) {
      this.title = title;
      this.generateAppearenceData();
   }

   public boolean isNPC() {
      return this.transformedNpcId != -1;
   }

   public void setLooks(short[] look) {
      for(byte i = 0; i < this.lookI.length; ++i) {
         if (look[i] != -1) {
            this.lookI[i] = look[i];
         }
      }

   }

   public void copyColors(short[] colors) {
      for(byte i = 0; i < this.colour.length; ++i) {
         if (colors[i] != -1) {
            this.colour[i] = (byte)colors[i];
         }
      }

   }
}
