package org.rsmapper.cache.tools;

import com.alex.store.Store;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.networking.codec.stream.OutputStream;

public class CacheItemDefinitions implements Cloneable {
   public int id;
   private boolean loaded;
   public int invModelId;
   private String name;
   private int invModelZoom;
   private int modelRotation1;
   private int modelRotation2;
   private int modelOffset1;
   private int modelOffset2;
   private int opcode3;
   private int opcode199;
   private int opcode223;
   private int opcode198;
   private int opcode186;
   private int opcode29;
   private int opcode238;
   private int opcode153;
   private int opcode155;
   private int opcode99;
   private int opcode251;
   private int opcode22;
   private int opcode192;
   private int opcode245;
   private int opcode45;
   private int opcode56;
   private int opcode248;
   private int opcode237;
   private int opcode243;
   private int opcode185;
   private int opcode221;
   private int opcode240;
   private int opcode154;
   private int opcode158;
   private int opcode137;
   private int opcode143;
   private int opcode61;
   private int opcode80;
   private int opcode196;
   private int opcode85;
   private int opcode239;
   private int opcode177;
   private int opcode163;
   private int opcode150;
   private int opcode152;
   private int opcode135;
   private int opcode120;
   private int opcode204;
   private int opcode81;
   private int opcode208;
   private int opcode242;
   private int opcode15;
   private int opcode233;
   private int opcode213;
   private int opcode207;
   private int opcode216;
   private int opcode206;
   private int opcode50;
   private int opcode193;
   private int opcode71;
   private int opcode10;
   private int opcode55;
   private int opcode144;
   private int opcode235;
   private int opcode188;
   private int opcode241;
   private int opcode236;
   private int opcode182;
   private int opcode169;
   private int opcode190;
   private int opcode178;
   private int opcode88;
   private int opcode200;
   private int opcode184;
   private int opcode176;
   private int opcode197;
   private int opcode247;
   private int opcode218;
   private int opcode250;
   private int opcode174;
   private int opcode210;
   private int opcode164;
   private int opcode142;
   private int opcode148;
   private int opcode133;
   private int opcode222;
   private int opcode138;
   private int opcode194;
   private int opcode119;
   private int opcode202;
   private int opcode149;
   private int opcode64;
   private int opcode147;
   private int opcode214;
   private int opcode74;
   private int opcode86;
   private int opcode167;
   private int opcode161;
   private int opcode58;
   private int opcode59;
   private int opcode187;
   private int opcode77;
   private int opcode229;
   private int opcode230;
   private int opcode17;
   private int opcode67;
   private int opcode131;
   private int opcode225;
   private int opcode203;
   private int opcode19;
   private int opcode43;
   private int opcode168;
   private int opcode46;
   private int opcode209;
   private int opcode166;
   private int opcode54;
   private int opcode21;
   private int opcode73;
   private int opcode159;
   private int opcode123;
   private int opcode146;
   private int opcode180;
   private int opcode20;
   private int opcode165;
   private int opcode84;
   private int opcode28;
   private int opcode175;
   private int opcode141;
   private int opcode205;
   private int opcode220;
   private int opcode136;
   private int opcode212;
   private int opcode49;
   private int opcode69;
   private int opcode72;
   private int opcode60;
   private int opcode62;
   private int opcode219;
   private int opcode44;
   private int opcode227;
   private int opcode76;
   private int opcode234;
   private int opcode57;
   private int opcode51;
   private int opcode124;
   private int opcode70;
   private int opcode231;
   private int opcode162;
   private int opcode160;
   private int opcode181;
   private int opcode183;
   private int opcode191;
   private int opcode189;
   private int opcode179;
   private int opcode173;
   private int opcode48;
   private int opcode172;
   private int opcode42;
   private int opcode47;
   private int opcode246;
   private int opcode89;
   private int opcode195;
   private int opcode145;
   private int opcode224;
   private int opcode63;
   private int opcode94;
   private int opcode201;
   private int opcode217;
   public int equipSlot;
   private int opcode52;
   private int opcode53;
   private int opcode82;
   private int opcode83;
   private int opcode87;
   private int opcode117;
   private int opcode66;
   private int opcode116;
   private int opcode157;
   private int opcode68;
   private int opcode244;
   private int opcode170;
   private int opcode151;
   private int opcode75;
   public int equipType;
   private int opcode27;
   private int opcode9;
   private int opcode232;
   private int opcode211;
   private int opcode254;
   private int opcode118;
   private int opcode228;
   private int opcode226;
   private int opcode255;
   private int opcode253;
   private int opcode252;
   private int opcode156;
   private int opcode215;
   private int opcode171;
   private int stackable;
   public int value;
   public boolean membersOnly;
   public int maleEquipModelId1;
   public int femaleEquipModelId1;
   public int maleEquipModelId2;
   public int femaleEquipModelId2;
   public int maleEquipModelId3;
   public int femaleEquipModelId3;
   private String[] groundOptions;
   public String[] inventoryOptions;
   public int[] originalModelColors;
   public int[] modifiedModelColors;
   public short[] originalTextureColors;
   public short[] modifiedTextureColors;
   private byte[] unknownArray1;
   private int[] unknownArray2;
   private boolean unnoted;
   private int unknownInt1;
   private int unknownInt2;
   private int unknownInt3;
   private int unknownInt4;
   private int unknownInt5;
   private int unknownInt6;
   public int switchNoteItemId;
   public int notedItemId;
   private int[] stackIds;
   private int[] stackAmounts;
   private int unknownInt7;
   private int unknownInt8;
   private int unknownInt9;
   private int unknownInt10;
   private int unknownInt11;
   public int teamId;
   public int switchLendItemId;
   public int lendedItemId;
   private int unknownInt12;
   private int unknownInt13;
   private int unknownInt14;
   private int unknownInt15;
   private int unknownInt16;
   private int unknownInt17;
   private int unknownInt18;
   private int unknownInt19;
   private int unknownInt20;
   private int unknownInt21;
   private int unknownInt22;
   private int unknownInt23;
   private int unknownValue1;
   private int unknownValue2;
   private HashMap<Integer, Object> clientScriptData;

   public static CacheItemDefinitions getItemDefinition(Store cache, int itemId) {
      return getItemDefinition(cache, itemId, true);
   }

   public static CacheItemDefinitions getItemDefinition(Store cache, int itemId, boolean load) {
      return new CacheItemDefinitions(cache, itemId, load);
   }

   public CacheItemDefinitions(Store cache, int id) {
      this(cache, id, true);
   }

   public CacheItemDefinitions(Store cache, int id, boolean load) {
      this.id = id;
      this.setDefaultsVariableValules();
      this.setDefaultOptions();
      if (load) {
         this.loadItemDefinition(cache);
      }

   }

   public boolean isLoaded() {
      return this.loaded;
   }

   public void write(Store store) {
      store.getIndexes()[19].putFile(this.getArchiveId(), this.getFileId(), this.encode());
   }

   private void loadItemDefinition(Store cache) {
      byte[] data = cache.getIndexes()[19].getFile(this.getArchiveId(), this.getFileId());
      if (data == null) {
         System.out.println("FAILED LOADING ITEM " + this.id);
      } else {
         try {
            this.readOpcodeValues(new InputStream(data));
         } catch (RuntimeException var4) {
            var4.printStackTrace();
         }

         if (this.notedItemId != -1) {
            this.toNote(cache);
         }

         if (this.lendedItemId != -1) {
            this.toLend(cache);
         }

         this.loaded = true;
      }
   }

   private void toNote(Store store) {
      CacheItemDefinitions realItem = getItemDefinition(store, this.switchNoteItemId);
      this.membersOnly = realItem.membersOnly;
      this.value = realItem.value;
      this.name = realItem.name;
      this.stackable = 1;
   }

   private void toLend(Store store) {
      CacheItemDefinitions realItem = getItemDefinition(store, this.switchLendItemId);
      this.originalModelColors = realItem.originalModelColors;
      this.modifiedModelColors = realItem.modifiedModelColors;
      this.teamId = realItem.teamId;
      this.value = 0;
      this.membersOnly = realItem.membersOnly;
      this.name = realItem.name;
      this.inventoryOptions = new String[5];
      this.groundOptions = realItem.groundOptions;
      if (realItem.inventoryOptions != null) {
         for(int optionIndex = 0; optionIndex < 4; ++optionIndex) {
            this.inventoryOptions[optionIndex] = realItem.inventoryOptions[optionIndex];
         }
      }

      this.inventoryOptions[4] = "Discard";
      this.maleEquipModelId1 = realItem.maleEquipModelId1;
      this.maleEquipModelId2 = realItem.maleEquipModelId2;
      this.femaleEquipModelId1 = realItem.femaleEquipModelId1;
      this.femaleEquipModelId2 = realItem.femaleEquipModelId2;
      this.maleEquipModelId3 = realItem.maleEquipModelId3;
      this.femaleEquipModelId3 = realItem.femaleEquipModelId3;
      this.equipType = realItem.equipType;
      this.equipSlot = realItem.equipSlot;
   }

   public int getArchiveId() {
      return this.id >>> 8;
   }

   public int getFileId() {
      return 255 & this.id;
   }

   public boolean hasSpecialBar() {
      if (this.clientScriptData == null) {
         return false;
      } else {
         Object specialBar = this.clientScriptData.get(686);
         if (specialBar != null && specialBar instanceof Integer) {
            return (Integer)specialBar == 1;
         } else {
            return false;
         }
      }
   }

   public int getRenderAnimId() {
      if (this.clientScriptData == null) {
         return 1426;
      } else {
         Object animId = this.clientScriptData.get(644);
         return animId != null && animId instanceof Integer ? (Integer)animId : 1426;
      }
   }

   public int getQuestId() {
      if (this.clientScriptData == null) {
         return -1;
      } else {
         System.out.println(this.clientScriptData.toString());
         Object questId = this.clientScriptData.get(861);
         return questId != null && questId instanceof Integer ? (Integer)questId : -1;
      }
   }

   public HashMap<Integer, Integer> getWearingSkillRequiriments() {
      if (this.clientScriptData == null) {
         return null;
      } else {
         HashMap<Integer, Integer> skills = new HashMap();
         int nextLevel = -1;
         int nextSkill = -1;
         Iterator var5 = this.clientScriptData.keySet().iterator();

         while(var5.hasNext()) {
            int key = (Integer)var5.next();
            Object value = this.clientScriptData.get(key);
            if (!(value instanceof String)) {
               if (key == 23) {
                  skills.put(4, (Integer)value);
                  skills.put(11, 61);
               } else if (key >= 749 && key < 797) {
                  if (key % 2 == 0) {
                     nextLevel = (Integer)value;
                  } else {
                     nextSkill = (Integer)value;
                  }

                  if (nextLevel != -1 && nextSkill != -1) {
                     skills.put(nextSkill, nextLevel);
                     nextLevel = -1;
                     nextSkill = -1;
                  }
               }
            }
         }

         return skills;
      }
   }

   public void printClientScriptData() {
      Iterator var2 = this.clientScriptData.keySet().iterator();

      while(var2.hasNext()) {
         int key = (Integer)var2.next();
         Object value = this.clientScriptData.get(key);
         System.out.println("KEY: " + key + ", VALUE: " + value);
      }

      HashMap<Integer, Integer> requiriments = this.getWearingSkillRequiriments();
      if (requiriments == null) {
         System.out.println("null.");
      } else {
         System.out.println(requiriments.keySet().size());
         Iterator var7 = requiriments.keySet().iterator();

         while(var7.hasNext()) {
            int key = (Integer)var7.next();
            Object value = requiriments.get(key);
            System.out.println("SKILL: " + key + ", LEVEL: " + value);
         }

      }
   }

   private void setDefaultOptions() {
      this.groundOptions = new String[]{null, null, "take", null, null};
      this.inventoryOptions = new String[]{null, null, null, null, "drop"};
   }

   private void setDefaultsVariableValules() {
      this.name = "null";
      this.maleEquipModelId1 = -1;
      this.maleEquipModelId2 = -1;
      this.femaleEquipModelId1 = -1;
      this.femaleEquipModelId2 = -1;
      this.invModelZoom = 2000;
      this.switchLendItemId = -1;
      this.lendedItemId = -1;
      this.switchNoteItemId = -1;
      this.notedItemId = -1;
      this.unknownInt9 = 128;
      this.value = 1;
      this.maleEquipModelId3 = -1;
      this.femaleEquipModelId3 = -1;
      this.teamId = -1;
      this.equipType = -1;
      this.equipSlot = -1;
   }

   public byte[] encode() {
      OutputStream stream = new OutputStream();
      stream.writeByte(1);
      stream.writeBigSmart(this.invModelId);
      if (!this.name.equals("null") && this.notedItemId == -1) {
         stream.writeByte(2);
         stream.writeString(this.name);
      }

      if (this.invModelZoom != 2000) {
         stream.writeByte(4);
         stream.writeShort(this.invModelZoom);
      }

      if (this.modelRotation1 != 0) {
         stream.writeByte(5);
         stream.writeShort(this.modelRotation1);
      }

      if (this.modelRotation2 != 0) {
         stream.writeByte(6);
         stream.writeShort(this.modelRotation2);
      }

      int key;
      if (this.modelOffset1 != 0) {
         stream.writeByte(7);
         key = this.modelOffset1 >>= 0;
         if (key < 0) {
            key += 65536;
         }

         stream.writeShort(key);
      }

      if (this.modelOffset2 != 0) {
         stream.writeByte(8);
         key = this.modelOffset2 >>= 0;
         if (key < 0) {
            key += 65536;
         }

         stream.writeShort(key);
      }

      if (this.stackable >= 1 && this.notedItemId == -1) {
         stream.writeByte(11);
      }

      if (this.value != 1 && this.lendedItemId == -1) {
         stream.writeByte(12);
         stream.writeInt(this.value);
      }

      if (this.equipSlot != -1) {
         stream.writeByte(13);
         stream.writeByte(this.equipSlot);
      }

      if (this.equipType != -1) {
         stream.writeByte(14);
         stream.writeByte(this.equipType);
      }

      if (this.membersOnly && this.notedItemId == -1) {
         stream.writeByte(16);
      }

      if (this.maleEquipModelId1 != -1) {
         stream.writeByte(23);
         stream.writeBigSmart(this.maleEquipModelId1);
      }

      if (this.maleEquipModelId2 != -1) {
         stream.writeByte(24);
         stream.writeBigSmart(this.maleEquipModelId2);
      }

      if (this.femaleEquipModelId1 != -1) {
         stream.writeByte(25);
         stream.writeBigSmart(this.femaleEquipModelId1);
      }

      if (this.femaleEquipModelId2 != -1) {
         stream.writeByte(26);
         stream.writeBigSmart(this.femaleEquipModelId2);
      }

      for(key = 0; key < 4; ++key) {
         if (this.groundOptions[key] != null && (key != 2 || !this.groundOptions[key].equals("take"))) {
            stream.writeByte(30 + key);
            stream.writeString(this.groundOptions[key]);
         }
      }

      for(key = 0; key < 4; ++key) {
         if (this.inventoryOptions[key] != null && (key != 4 || !this.inventoryOptions[key].equals("drop"))) {
            stream.writeByte(35 + key);
            stream.writeString(this.inventoryOptions[key]);
         }
      }

      if (this.originalModelColors != null && this.modifiedModelColors != null) {
         stream.writeByte(40);
         stream.writeByte(this.originalModelColors.length);

         for(key = 0; key < this.originalModelColors.length; ++key) {
            stream.writeShort(this.originalModelColors[key]);
            stream.writeShort(this.modifiedModelColors[key]);
         }
      }

      if (this.originalTextureColors != null && this.modifiedTextureColors != null) {
         stream.writeByte(41);
         stream.writeByte(this.originalTextureColors.length);

         for(key = 0; key < this.originalTextureColors.length; ++key) {
            stream.writeShort(this.originalTextureColors[key]);
            stream.writeShort(this.modifiedTextureColors[key]);
         }
      }

      int var3;
      int var4;
      if (this.unknownArray1 != null) {
         stream.writeByte(42);
         stream.writeByte(this.unknownArray1.length);
         byte[] var5;
         var4 = (var5 = this.unknownArray1).length;

         for(var3 = 0; var3 < var4; ++var3) {
            byte element = var5[var3];
            stream.writeByte(element);
         }
      }

      if (this.unnoted) {
         stream.writeByte(65);
      }

      if (this.maleEquipModelId3 != -1) {
         stream.writeByte(78);
         stream.writeBigSmart(this.maleEquipModelId3);
      }

      if (this.femaleEquipModelId3 != -1) {
         stream.writeByte(79);
         stream.writeBigSmart(this.femaleEquipModelId3);
      }

      if (this.switchNoteItemId != -1) {
         stream.writeByte(97);
         stream.writeShort(this.switchNoteItemId);
      }

      if (this.notedItemId != -1) {
         stream.writeByte(98);
         stream.writeShort(this.notedItemId);
      }

      if (this.stackIds != null && this.stackAmounts != null) {
         for(key = 0; key < this.stackIds.length; ++key) {
            if (this.stackIds[key] != 0 || this.stackAmounts[key] != 0) {
               stream.writeByte(100 + key);
               stream.writeShort(this.stackIds[key]);
               stream.writeShort(this.stackAmounts[key]);
            }
         }
      }

      if (this.teamId != 0) {
         stream.writeByte(115);
         stream.writeByte(this.teamId);
      }

      if (this.switchLendItemId != -1) {
         stream.writeByte(121);
         stream.writeShort(this.switchLendItemId);
      }

      if (this.lendedItemId != -1) {
         stream.writeByte(122);
         stream.writeShort(this.lendedItemId);
      }

      if (this.unknownArray2 != null) {
         stream.writeByte(132);
         stream.writeByte(this.unknownArray2.length);
         int[] var8;
         var4 = (var8 = this.unknownArray2).length;

         for(var3 = 0; var3 < var4; ++var3) {
            key = var8[var3];
            stream.writeShort(key);
         }
      }

      if (this.clientScriptData != null) {
         stream.writeByte(249);
         stream.writeByte(this.clientScriptData.size());
         Iterator var6 = this.clientScriptData.keySet().iterator();

         while(var6.hasNext()) {
            key = (Integer)var6.next();
            Object value = this.clientScriptData.get(key);
            stream.writeByte(value instanceof String ? 1 : 0);
            stream.write24BitInteger(key);
            if (value instanceof String) {
               stream.writeString((String)value);
            } else {
               stream.writeInt((Integer)value);
            }
         }
      }

      stream.writeByte(0);
      byte[] data = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(data, 0, data.length);
      return data;
   }

   public int getInvModelId() {
      return this.invModelId;
   }

   public void setInvModelId(int modelId) {
      this.invModelId = modelId;
   }

   public int getInvModelZoom() {
      return this.invModelZoom;
   }

   public void setInvModelZoom(int modelZoom) {
      this.invModelZoom = modelZoom;
   }

   private final void readValues(InputStream stream, int opcode) {
      if (opcode == 1) {
         this.invModelId = stream.readBigSmart();
      } else if (opcode == 2) {
         this.name = stream.readString();
      } else if (opcode == 4) {
         this.invModelZoom = stream.readUnsignedShort();
      } else if (opcode == 5) {
         this.modelRotation1 = stream.readUnsignedShort();
      } else if (opcode == 6) {
         this.modelRotation2 = stream.readUnsignedShort();
      } else if (opcode == 7) {
         this.modelOffset1 = stream.readUnsignedShort();
         if (this.modelOffset1 > 32767) {
            this.modelOffset1 -= 65536;
         }

         this.modelOffset1 <<= 0;
      } else if (opcode == 8) {
         this.modelOffset2 = stream.readUnsignedShort();
         if (this.modelOffset2 > 32767) {
            this.modelOffset2 -= 65536;
         }

         this.modelOffset2 <<= 0;
      } else if (opcode == 11) {
         this.stackable = 1;
      } else if (opcode == 12) {
         this.value = stream.readInt();
      } else if (opcode == 13) {
         this.equipSlot = stream.readUnsignedByte();
      } else if (opcode == 14) {
         this.equipType = stream.readUnsignedByte();
      } else if (opcode == 16) {
         this.membersOnly = true;
      } else if (opcode == 18) {
         stream.readUnsignedShortLE();
      } else if (opcode == 23) {
         this.maleEquipModelId1 = stream.readBigSmart();
      } else if (opcode == 24) {
         this.maleEquipModelId2 = stream.readBigSmart();
      } else if (opcode == 25) {
         this.femaleEquipModelId1 = stream.readBigSmart();
      } else if (opcode == 26) {
         this.femaleEquipModelId2 = stream.readBigSmart();
      } else if (opcode == 27) {
         stream.readUnsignedByte();
      } else if (opcode >= 30 && opcode < 35) {
         this.groundOptions[opcode - 30] = stream.readString();
      } else if (opcode >= 35 && opcode < 40) {
         this.inventoryOptions[opcode - 35] = stream.readString();
      } else {
         int length;
         int index;
         if (opcode == 40) {
            length = stream.readUnsignedByte();
            this.originalModelColors = new int[length];
            this.modifiedModelColors = new int[length];

            for(index = 0; index < length; ++index) {
               this.originalModelColors[index] = stream.readUnsignedShort();
               this.modifiedModelColors[index] = stream.readUnsignedShort();
            }
         } else if (opcode == 41) {
            length = stream.readUnsignedByte();
            this.originalTextureColors = new short[length];
            this.modifiedTextureColors = new short[length];

            for(index = 0; index < length; ++index) {
               this.originalTextureColors[index] = (short)stream.readUnsignedShort();
               this.modifiedTextureColors[index] = (short)stream.readUnsignedShort();
            }
         } else if (opcode == 42) {
            length = stream.readUnsignedByte();
            this.unknownArray1 = new byte[length];

            for(index = 0; index < length; ++index) {
               this.unknownArray1[index] = (byte)stream.readByte();
            }
         } else if (opcode == 65) {
            this.unnoted = true;
         } else if (opcode == 78) {
            this.maleEquipModelId3 = stream.readBigSmart();
         } else if (opcode == 79) {
            this.femaleEquipModelId3 = stream.readBigSmart();
         } else if (opcode == 90) {
            this.unknownInt1 = stream.readBigSmart();
         } else if (opcode == 91) {
            this.unknownInt2 = stream.readBigSmart();
         } else if (opcode == 92) {
            this.unknownInt3 = stream.readBigSmart();
         } else if (opcode == 93) {
            this.unknownInt4 = stream.readBigSmart();
         } else if (opcode == 95) {
            this.unknownInt5 = stream.readUnsignedShort();
         } else if (opcode == 96) {
            this.unknownInt6 = stream.readUnsignedByte();
         } else if (opcode == 97) {
            this.switchNoteItemId = stream.readUnsignedShort();
         } else if (opcode == 98) {
            this.notedItemId = stream.readUnsignedShort();
         } else if (opcode >= 100 && opcode < 110) {
            if (this.stackIds == null) {
               this.stackIds = new int[10];
               this.stackAmounts = new int[10];
            }

            this.stackIds[opcode - 100] = stream.readUnsignedShort();
            this.stackAmounts[opcode - 100] = stream.readUnsignedShort();
         } else if (opcode == 110) {
            this.unknownInt7 = stream.readUnsignedShort();
         } else if (opcode == 111) {
            this.unknownInt8 = stream.readUnsignedShort();
         } else if (opcode == 112) {
            this.unknownInt9 = stream.readUnsignedShort();
         } else if (opcode == 113) {
            this.unknownInt10 = stream.readByte();
         } else if (opcode == 114) {
            this.unknownInt11 = stream.readByte() * 5;
         } else if (opcode == 115) {
            this.teamId = stream.readUnsignedByte();
         } else if (opcode == 121) {
            this.switchLendItemId = stream.readUnsignedShort();
         } else if (opcode == 122) {
            this.lendedItemId = stream.readUnsignedShort();
         } else if (opcode == 125) {
            this.unknownInt12 = stream.readByte() << 0;
            this.unknownInt13 = stream.readByte() << 0;
            this.unknownInt14 = stream.readByte() << 0;
         } else if (opcode == 126) {
            this.unknownInt15 = stream.readByte() << 0;
            this.unknownInt16 = stream.readByte() << 0;
            this.unknownInt17 = stream.readByte() << 0;
         } else if (opcode == 127) {
            this.unknownInt18 = stream.readUnsignedByte();
            this.unknownInt19 = stream.readUnsignedShort();
         } else if (opcode == 128) {
            this.unknownInt20 = stream.readUnsignedByte();
            this.unknownInt21 = stream.readUnsignedShort();
         } else if (opcode == 129) {
            this.unknownInt20 = stream.readUnsignedByte();
            this.unknownInt21 = stream.readUnsignedShort();
         } else if (opcode == 130) {
            this.unknownInt22 = stream.readUnsignedByte();
            this.unknownInt23 = stream.readUnsignedShort();
         } else if (opcode == 132) {
            length = stream.readUnsignedByte();
            this.unknownArray2 = new int[length];

            for(index = 0; index < length; ++index) {
               this.unknownArray2[index] = stream.readUnsignedShort();
            }
         } else if (opcode == 134) {
            stream.readUnsignedByte();
         } else if (opcode == 139) {
            this.unknownValue2 = stream.readUnsignedShort();
         } else if (opcode == 140) {
            this.unknownValue1 = stream.readUnsignedShort();
         } else if (opcode == 249) {
            length = stream.readUnsignedByte();
            if (this.clientScriptData == null) {
               this.clientScriptData = new HashMap(length);
            }

            for(index = 0; index < length; ++index) {
               boolean stringInstance = stream.readUnsignedByte() == 1;
               int key = stream.read24BitInt();
               Object value = stringInstance ? stream.readString() : stream.readInt();
               this.clientScriptData.put(key, value);
            }
         } else if (opcode == 44) {
            this.opcode44 = stream.readUnsignedShort();
         } else if (opcode == 117) {
            this.opcode117 = stream.readUnsignedByte();
         } else if (opcode == 211) {
            this.opcode211 = stream.readUnsignedByte();
         } else if (opcode == 255) {
            this.opcode255 = stream.readUnsignedByte();
         } else if (opcode == 75) {
            this.opcode75 = stream.readUnsignedByte();
         } else if (opcode == 87) {
            this.opcode87 = stream.readUnsignedByte();
         } else if (opcode == 68) {
            this.opcode68 = stream.readUnsignedByte();
         } else if (opcode == 118) {
            this.opcode118 = stream.readUnsignedByte();
         } else if (opcode == 83) {
            this.opcode83 = stream.readUnsignedByte();
         } else if (opcode == 254) {
            this.opcode254 = stream.readUnsignedByte();
         } else if (opcode == 156) {
            this.opcode156 = stream.readUnsignedByte();
         } else if (opcode == 232) {
            this.opcode232 = stream.readUnsignedByte();
         } else if (opcode == 199) {
            this.opcode199 = stream.readUnsignedByte();
         } else if (opcode == 253) {
            this.opcode253 = stream.readUnsignedByte();
         } else if (opcode == 223) {
            this.opcode223 = stream.readUnsignedByte();
         } else if (opcode == 198) {
            this.opcode198 = stream.readUnsignedByte();
         } else if (opcode == 186) {
            this.opcode186 = stream.readUnsignedByte();
         } else if (opcode == 29) {
            this.opcode29 = stream.readUnsignedByte();
         } else if (opcode == 238) {
            this.opcode238 = stream.readUnsignedByte();
         } else if (opcode == 153) {
            this.opcode153 = stream.readUnsignedByte();
         } else if (opcode == 155) {
            this.opcode155 = stream.readUnsignedByte();
         } else if (opcode == 99) {
            this.opcode99 = stream.readUnsignedByte();
         } else if (opcode == 251) {
            this.opcode251 = stream.readUnsignedByte();
         } else if (opcode == 22) {
            this.opcode22 = stream.readUnsignedByte();
         } else if (opcode == 192) {
            this.opcode192 = stream.readUnsignedByte();
         } else if (opcode == 245) {
            this.opcode245 = stream.readUnsignedByte();
         } else if (opcode == 45) {
            this.opcode45 = stream.readUnsignedByte();
         } else if (opcode == 56) {
            this.opcode56 = stream.readUnsignedByte();
         } else if (opcode == 248) {
            this.opcode248 = stream.readUnsignedByte();
         } else if (opcode == 237) {
            this.opcode237 = stream.readUnsignedByte();
         } else if (opcode == 243) {
            this.opcode243 = stream.readUnsignedByte();
         } else if (opcode == 185) {
            this.opcode185 = stream.readUnsignedByte();
         } else if (opcode == 221) {
            this.opcode221 = stream.readUnsignedByte();
         } else if (opcode == 240) {
            this.opcode240 = stream.readUnsignedByte();
         } else if (opcode == 154) {
            this.opcode154 = stream.readUnsignedByte();
         } else if (opcode == 158) {
            this.opcode158 = stream.readUnsignedByte();
         } else if (opcode == 137) {
            this.opcode137 = stream.readUnsignedByte();
         } else if (opcode == 143) {
            this.opcode143 = stream.readUnsignedByte();
         } else if (opcode == 61) {
            this.opcode61 = stream.readUnsignedByte();
         } else if (opcode == 80) {
            this.opcode80 = stream.readUnsignedByte();
         } else if (opcode == 196) {
            this.opcode196 = stream.readUnsignedByte();
         } else if (opcode == 85) {
            this.opcode85 = stream.readUnsignedByte();
         } else if (opcode == 239) {
            this.opcode239 = stream.readUnsignedByte();
         } else if (opcode == 177) {
            this.opcode177 = stream.readUnsignedByte();
         } else if (opcode == 163) {
            this.opcode163 = stream.readUnsignedByte();
         } else if (opcode == 150) {
            this.opcode150 = stream.readUnsignedByte();
         } else if (opcode == 152) {
            this.opcode152 = stream.readUnsignedByte();
         } else if (opcode == 135) {
            this.opcode135 = stream.readUnsignedByte();
         } else if (opcode == 120) {
            this.opcode120 = stream.readUnsignedByte();
         } else if (opcode == 204) {
            this.opcode204 = stream.readUnsignedByte();
         } else if (opcode == 81) {
            this.opcode81 = stream.readUnsignedByte();
         } else if (opcode == 208) {
            this.opcode208 = stream.readUnsignedByte();
         } else if (opcode == 242) {
            this.opcode242 = stream.readUnsignedByte();
         } else if (opcode == 15) {
            this.opcode15 = stream.readUnsignedByte();
         } else if (opcode == 233) {
            this.opcode233 = stream.readUnsignedByte();
         } else if (opcode == 213) {
            this.opcode213 = stream.readUnsignedByte();
         } else if (opcode == 207) {
            this.opcode207 = stream.readUnsignedByte();
         } else if (opcode == 216) {
            this.opcode216 = stream.readUnsignedByte();
         } else if (opcode == 206) {
            this.opcode206 = stream.readUnsignedByte();
         } else if (opcode == 50) {
            this.opcode50 = stream.readUnsignedByte();
         } else if (opcode == 193) {
            this.opcode193 = stream.readUnsignedByte();
         } else if (opcode == 71) {
            this.opcode71 = stream.readUnsignedByte();
         } else if (opcode == 10) {
            this.opcode10 = stream.readUnsignedByte();
         } else if (opcode == 55) {
            this.opcode55 = stream.readUnsignedByte();
         } else if (opcode == 144) {
            this.opcode144 = stream.readUnsignedByte();
         } else if (opcode == 235) {
            this.opcode235 = stream.readUnsignedByte();
         } else if (opcode == 188) {
            this.opcode188 = stream.readUnsignedByte();
         } else if (opcode == 241) {
            this.opcode241 = stream.readUnsignedByte();
         } else if (opcode == 236) {
            this.opcode236 = stream.readUnsignedByte();
         } else if (opcode == 182) {
            this.opcode182 = stream.readUnsignedByte();
         } else if (opcode == 169) {
            this.opcode169 = stream.readUnsignedByte();
         } else if (opcode == 190) {
            this.opcode190 = stream.readUnsignedByte();
         } else if (opcode == 178) {
            this.opcode178 = stream.readUnsignedByte();
         } else if (opcode == 88) {
            this.opcode88 = stream.readUnsignedByte();
         } else if (opcode == 200) {
            this.opcode200 = stream.readUnsignedByte();
         } else if (opcode == 184) {
            this.opcode184 = stream.readUnsignedByte();
         } else if (opcode == 176) {
            this.opcode176 = stream.readUnsignedByte();
         } else if (opcode == 197) {
            this.opcode197 = stream.readUnsignedByte();
         } else if (opcode == 247) {
            this.opcode247 = stream.readUnsignedByte();
         } else if (opcode == 218) {
            this.opcode218 = stream.readUnsignedByte();
         } else if (opcode == 250) {
            this.opcode250 = stream.readUnsignedByte();
         } else if (opcode == 174) {
            this.opcode174 = stream.readUnsignedByte();
         } else if (opcode == 210) {
            this.opcode210 = stream.readUnsignedByte();
         } else if (opcode == 164) {
            this.opcode164 = stream.readUnsignedByte();
         } else if (opcode == 142) {
            this.opcode142 = stream.readUnsignedByte();
         } else if (opcode == 148) {
            this.opcode148 = stream.readUnsignedByte();
         } else if (opcode == 133) {
            this.opcode133 = stream.readUnsignedByte();
         } else if (opcode == 222) {
            this.opcode222 = stream.readUnsignedByte();
         } else if (opcode == 138) {
            this.opcode138 = stream.readUnsignedByte();
         } else if (opcode == 194) {
            this.opcode194 = stream.readUnsignedByte();
         } else if (opcode == 119) {
            this.opcode119 = stream.readUnsignedByte();
         } else if (opcode == 202) {
            this.opcode202 = stream.readUnsignedByte();
         } else if (opcode == 149) {
            this.opcode149 = stream.readUnsignedByte();
         } else if (opcode == 64) {
            this.opcode64 = stream.readUnsignedByte();
         } else if (opcode == 147) {
            this.opcode147 = stream.readUnsignedByte();
         } else if (opcode == 214) {
            this.opcode214 = stream.readUnsignedByte();
         } else if (opcode == 74) {
            this.opcode74 = stream.readUnsignedByte();
         } else if (opcode == 86) {
            this.opcode86 = stream.readUnsignedByte();
         } else if (opcode == 167) {
            this.opcode167 = stream.readUnsignedByte();
         } else if (opcode == 161) {
            this.opcode161 = stream.readUnsignedByte();
         } else if (opcode == 58) {
            this.opcode58 = stream.readUnsignedByte();
         } else if (opcode == 59) {
            this.opcode59 = stream.readUnsignedByte();
         } else if (opcode == 187) {
            this.opcode187 = stream.readUnsignedByte();
         } else if (opcode == 77) {
            this.opcode77 = stream.readUnsignedByte();
         } else if (opcode == 229) {
            this.opcode229 = stream.readUnsignedByte();
         } else if (opcode == 230) {
            this.opcode230 = stream.readUnsignedByte();
         } else if (opcode == 17) {
            this.opcode17 = stream.readUnsignedByte();
         } else if (opcode == 67) {
            this.opcode67 = stream.readUnsignedByte();
         } else if (opcode == 131) {
            this.opcode131 = stream.readUnsignedByte();
         } else if (opcode == 225) {
            this.opcode225 = stream.readUnsignedByte();
         } else if (opcode == 203) {
            this.opcode203 = stream.readUnsignedByte();
         } else if (opcode == 19) {
            this.opcode19 = stream.readUnsignedByte();
         } else if (opcode == 43) {
            this.opcode43 = stream.readUnsignedByte();
         } else if (opcode == 168) {
            this.opcode168 = stream.readUnsignedByte();
         } else if (opcode == 46) {
            this.opcode46 = stream.readUnsignedByte();
         } else if (opcode == 209) {
            this.opcode209 = stream.readUnsignedByte();
         } else if (opcode == 166) {
            this.opcode166 = stream.readUnsignedByte();
         } else if (opcode == 54) {
            this.opcode54 = stream.readUnsignedByte();
         } else if (opcode == 21) {
            this.opcode21 = stream.readUnsignedByte();
         } else if (opcode == 73) {
            this.opcode73 = stream.readUnsignedByte();
         } else if (opcode == 159) {
            this.opcode159 = stream.readUnsignedByte();
         } else if (opcode == 123) {
            this.opcode123 = stream.readUnsignedByte();
         } else if (opcode == 146) {
            this.opcode146 = stream.readUnsignedByte();
         } else if (opcode == 180) {
            this.opcode180 = stream.readUnsignedByte();
         } else if (opcode == 20) {
            this.opcode20 = stream.readUnsignedByte();
         } else if (opcode == 165) {
            this.opcode165 = stream.readUnsignedByte();
         } else if (opcode == 84) {
            this.opcode84 = stream.readUnsignedByte();
         } else if (opcode == 28) {
            this.opcode28 = stream.readUnsignedByte();
         } else if (opcode == 175) {
            this.opcode175 = stream.readUnsignedByte();
         } else if (opcode == 141) {
            this.opcode141 = stream.readUnsignedByte();
         } else if (opcode == 205) {
            this.opcode205 = stream.readUnsignedByte();
         } else if (opcode == 220) {
            this.opcode220 = stream.readUnsignedByte();
         } else if (opcode == 136) {
            this.opcode136 = stream.readUnsignedByte();
         } else if (opcode == 212) {
            this.opcode212 = stream.readUnsignedByte();
         } else if (opcode == 49) {
            this.opcode49 = stream.readUnsignedByte();
         } else if (opcode == 69) {
            this.opcode69 = stream.readUnsignedByte();
         } else if (opcode == 72) {
            this.opcode72 = stream.readUnsignedByte();
         } else if (opcode == 60) {
            this.opcode60 = stream.readUnsignedByte();
         } else if (opcode == 62) {
            this.opcode62 = stream.readUnsignedByte();
         } else if (opcode == 219) {
            this.opcode219 = stream.readUnsignedByte();
         } else if (opcode == 44) {
            this.opcode44 = stream.readUnsignedByte();
         } else if (opcode == 227) {
            this.opcode227 = stream.readUnsignedByte();
         } else if (opcode == 76) {
            this.opcode76 = stream.readUnsignedByte();
         } else if (opcode == 234) {
            this.opcode234 = stream.readUnsignedByte();
         } else if (opcode == 57) {
            this.opcode57 = stream.readUnsignedByte();
         } else if (opcode == 51) {
            this.opcode51 = stream.readUnsignedByte();
         } else if (opcode == 124) {
            this.opcode124 = stream.readUnsignedByte();
         } else if (opcode == 70) {
            this.opcode70 = stream.readUnsignedByte();
         } else if (opcode == 231) {
            this.opcode231 = stream.readUnsignedByte();
         } else if (opcode == 162) {
            this.opcode162 = stream.readUnsignedByte();
         } else if (opcode == 160) {
            this.opcode160 = stream.readUnsignedByte();
         } else if (opcode == 181) {
            this.opcode181 = stream.readUnsignedByte();
         } else if (opcode == 183) {
            this.opcode183 = stream.readUnsignedByte();
         } else if (opcode == 191) {
            this.opcode191 = stream.readUnsignedByte();
         } else if (opcode == 189) {
            this.opcode189 = stream.readUnsignedByte();
         } else if (opcode == 179) {
            this.opcode179 = stream.readUnsignedByte();
         } else if (opcode == 173) {
            this.opcode173 = stream.readUnsignedByte();
         } else if (opcode == 48) {
            this.opcode48 = stream.readUnsignedByte();
         } else if (opcode == 172) {
            this.opcode172 = stream.readUnsignedByte();
         } else if (opcode == 42) {
            this.opcode42 = stream.readUnsignedByte();
         } else if (opcode == 47) {
            this.opcode47 = stream.readUnsignedByte();
         } else if (opcode == 246) {
            this.opcode246 = stream.readUnsignedByte();
         } else if (opcode == 89) {
            this.opcode89 = stream.readUnsignedByte();
         } else if (opcode == 195) {
            this.opcode195 = stream.readUnsignedByte();
         } else if (opcode == 145) {
            this.opcode145 = stream.readUnsignedByte();
         } else if (opcode == 224) {
            this.opcode224 = stream.readUnsignedByte();
         } else if (opcode == 63) {
            this.opcode63 = stream.readUnsignedByte();
         } else if (opcode == 94) {
            this.opcode94 = stream.readUnsignedByte();
         } else if (opcode == 201) {
            this.opcode201 = stream.readUnsignedByte();
         } else if (opcode == 217) {
            this.opcode217 = stream.readUnsignedByte();
         } else if (opcode == 252) {
            this.opcode252 = stream.readUnsignedByte();
         } else if (opcode == 228) {
            this.opcode228 = stream.readUnsignedByte();
         } else if (opcode == 82) {
            this.opcode82 = stream.readUnsignedByte();
         } else if (opcode == 9) {
            this.opcode9 = stream.readUnsignedByte();
         } else if (opcode == 27) {
            this.opcode27 = stream.readUnsignedByte();
         } else if (opcode == 66) {
            this.opcode66 = stream.readUnsignedByte();
         } else if (opcode == 116) {
            this.opcode116 = stream.readUnsignedByte();
         } else if (opcode == 157) {
            this.opcode157 = stream.readUnsignedByte();
         } else if (opcode == 244) {
            this.opcode244 = stream.readUnsignedByte();
         } else if (opcode == 53) {
            this.opcode53 = stream.readUnsignedByte();
         } else if (opcode == 215) {
            this.opcode215 = stream.readUnsignedByte();
         } else if (opcode == 171) {
            this.opcode171 = stream.readUnsignedByte();
         } else if (opcode == 3) {
            this.opcode3 = stream.readUnsignedByte();
         } else if (opcode == 170) {
            this.opcode170 = stream.readUnsignedByte();
         } else if (opcode == 226) {
            this.opcode226 = stream.readUnsignedByte();
         } else if (opcode == 52) {
            this.opcode52 = stream.readUnsignedByte();
         } else {
            if (opcode != 151) {
               throw new RuntimeException("MISSING OPCODE " + opcode + " FOR ITEM " + this.id);
            }

            this.opcode151 = stream.readUnsignedByte();
         }
      }

   }

   private void readOpcodeValues(InputStream stream) {
      while(true) {
         int opcode = stream.readUnsignedByte();
         if (opcode == 0) {
            return;
         }

         this.readValues(stream, opcode);
      }
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getName() {
      return this.name;
   }

   public void resetTextureColors() {
      this.originalTextureColors = null;
      this.modifiedTextureColors = null;
   }

   public boolean isWearItem() {
      return this.equipSlot != -1;
   }

   public void changeTextureColor(short originalModelColor, short modifiedModelColor) {
      if (this.originalTextureColors != null) {
         for(int i = 0; i < this.originalTextureColors.length; ++i) {
            if (this.originalTextureColors[i] == originalModelColor) {
               this.modifiedTextureColors[i] = modifiedModelColor;
               return;
            }
         }

         short[] newOriginalModelColors = Arrays.copyOf(this.originalTextureColors, this.originalTextureColors.length + 1);
         short[] newModifiedModelColors = Arrays.copyOf(this.modifiedTextureColors, this.modifiedTextureColors.length + 1);
         newOriginalModelColors[newOriginalModelColors.length - 1] = originalModelColor;
         newModifiedModelColors[newModifiedModelColors.length - 1] = modifiedModelColor;
         this.originalTextureColors = newOriginalModelColors;
         this.modifiedTextureColors = newModifiedModelColors;
      } else {
         this.originalTextureColors = new short[]{originalModelColor};
         this.modifiedTextureColors = new short[]{modifiedModelColor};
      }

   }

   public void resetModelColors() {
      this.originalModelColors = null;
      this.modifiedModelColors = null;
   }

   public void changeModelColor(int originalModelColor, int modifiedModelColor) {
      if (this.originalModelColors != null) {
         for(int i = 0; i < this.originalModelColors.length; ++i) {
            if (this.originalModelColors[i] == originalModelColor) {
               this.modifiedModelColors[i] = modifiedModelColor;
               return;
            }
         }

         int[] newOriginalModelColors = Arrays.copyOf(this.originalModelColors, this.originalModelColors.length + 1);
         int[] newModifiedModelColors = Arrays.copyOf(this.modifiedModelColors, this.modifiedModelColors.length + 1);
         newOriginalModelColors[newOriginalModelColors.length - 1] = originalModelColor;
         newModifiedModelColors[newModifiedModelColors.length - 1] = modifiedModelColor;
         this.originalModelColors = newOriginalModelColors;
         this.modifiedModelColors = newModifiedModelColors;
      } else {
         this.originalModelColors = new int[]{originalModelColor};
         this.modifiedModelColors = new int[]{modifiedModelColor};
      }

   }

   public String[] getGroundOptions() {
      return this.groundOptions;
   }

   public String[] getInventoryOptions() {
      return this.inventoryOptions;
   }

   public int getEquipSlot() {
      return this.equipSlot;
   }

   public int getEquipType() {
      return this.equipType;
   }

   public Object clone() {
      try {
         return super.clone();
      } catch (CloneNotSupportedException var2) {
         var2.printStackTrace();
         return null;
      }
   }

   public String toString() {
      return this.id + " - " + this.name;
   }
}
