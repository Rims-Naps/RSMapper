package com.alex.loaders.items;

import com.alex.io.InputStream;
import com.alex.io.OutputStream;
import com.alex.store.Store;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class ItemDefinitions implements Cloneable {
   public int id;
   private boolean loaded;
   public int invModelId;
   private String name;
   private int opcode14;
   private int opcode9;
   private int opcode27;
   private int opcode66;
   private int opcode116;
   private int opcode157;
   private int opcode244;
   private int opcode53;
   private int opcode215;
   private int opcode171;
   private int opcode3;
   private int opcode170;
   private int opcode226;
   private int opcode52;
   private int opcode151;
   private int invModelZoom;
   public int modelRotation1;
   public int modelRotation2;
   public int modelOffset1;
   public int modelOffset2;
   public int stackable;
   private int value;
   public boolean membersOnly;
   private boolean isTradeable;
   private boolean isExchangeable;
   public int maleEquipModelId1;
   public int femaleEquipModelId1;
   public int maleEquipModelId2;
   public int femaleEquipModelId2;
   public int maleEquipModelId3;
   public int femaleEquipModelId3;
   public String[] groundOptions;
   public String[] inventoryOptions;
   public int[] originalModelColors;
   public int[] modifiedModelColors;
   public int[] originalTextureColors;
   public int[] modifiedTextureColors;
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
   private int unknownInt24;
   private int equipSlot;
   private HashMap<Integer, Object> clientScriptData;

   public static ItemDefinitions getItemDefinition(Store cache, int itemId) {
      return getItemDefinition(cache, itemId, true);
   }

   public static ItemDefinitions getItemDefinition(Store cache, int itemId, boolean load) {
      return new ItemDefinitions(cache, itemId, load);
   }

   public ItemDefinitions(Store cache, int id) {
      this(cache, id, true);
   }

   public ItemDefinitions(Store cache, int id, boolean load) {
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
      ItemDefinitions realItem = getItemDefinition(store, this.switchNoteItemId);
      this.membersOnly = realItem.membersOnly;
      this.value = realItem.value;
      this.name = realItem.name;
      this.stackable = 1;
   }

   private void toLend(Store store) {
      ItemDefinitions realItem = getItemDefinition(store, this.switchLendItemId);
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

   public void setRenderAnimId(int animId) {
      if (this.clientScriptData == null) {
         this.clientScriptData = new HashMap();
      }

      this.clientScriptData.put(644, animId);
   }

   public int getQuestId() {
      if (this.clientScriptData == null) {
         return -1;
      } else {
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

      for(key = 0; key < this.groundOptions.length; ++key) {
         if (this.groundOptions[key] != null && (key != 2 || !this.groundOptions[key].equals("take"))) {
            stream.writeByte(30 + key);
            stream.writeString(this.groundOptions[key]);
         }
      }

      for(key = 0; key < this.inventoryOptions.length; ++key) {
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

      if (this.unknownArray1 != null) {
         stream.writeByte(42);
         stream.writeByte(this.unknownArray1.length);

         for(key = 0; key < this.unknownArray1.length; ++key) {
            stream.writeByte(this.unknownArray1[key]);
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

         for(key = 0; key < this.unknownArray2.length; ++key) {
            stream.writeShort(this.unknownArray2[key]);
         }
      }

      if (this.clientScriptData != null) {
         stream.writeByte(249);
         stream.writeByte(this.clientScriptData.size());
         Iterator var3 = this.clientScriptData.keySet().iterator();

         while(var3.hasNext()) {
            key = (Integer)var3.next();
            Object value = this.clientScriptData.get(key);
            stream.writeByte(value instanceof String ? 1 : 0);
            stream.write24BitInt(key);
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

   public void readValues(InputStream stream, int opcode) {
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
         this.opcode14 = stream.readUnsignedByte();
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
      } else if (opcode == 151) {
         this.opcode151 = stream.readUnsignedByte();
      } else if (opcode == 15) {
         this.isTradeable = stream.readUnsignedByte() == 1;
      } else if (opcode == 17) {
         this.isExchangeable = stream.readUnsignedByte() == 1;
      } else if (opcode == 18) {
         this.unknownInt11 = stream.readUnsignedShort();
      } else if (opcode == 16) {
         this.membersOnly = true;
      } else if (opcode == 18) {
         stream.readUnsignedShort();
      } else if (opcode == 23) {
         this.maleEquipModelId1 = stream.readBigSmart();
      } else if (opcode == 24) {
         this.maleEquipModelId2 = stream.readBigSmart();
      } else if (opcode == 25) {
         this.femaleEquipModelId1 = stream.readBigSmart();
      } else if (opcode == 26) {
         this.femaleEquipModelId2 = stream.readBigSmart();
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
            this.originalTextureColors = new int[length];
            this.modifiedTextureColors = new int[length];

            for(index = 0; index < length; ++index) {
               this.originalTextureColors[index] = stream.readUnsignedShort();
               this.modifiedTextureColors[index] = stream.readUnsignedShort();
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
            length = stream.readUnsignedByte();
         } else if (opcode == 139) {
            length = stream.readUnsignedShort();
         } else if (opcode == 140) {
            length = stream.readUnsignedShort();
         } else {
            if (opcode != 249) {
               throw new RuntimeException("MISSING OPCODE " + opcode + " FOR ITEM " + this.id);
            }

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

   public void changeTextureColor(int originalModelColor, int modifiedModelColor) {
      if (this.originalTextureColors != null) {
         for(int i = 0; i < this.originalTextureColors.length; ++i) {
            if (this.originalTextureColors[i] == originalModelColor) {
               this.modifiedTextureColors[i] = modifiedModelColor;
               return;
            }
         }

         int[] newOriginalModelColors = Arrays.copyOf(this.originalTextureColors, this.originalTextureColors.length + 1);
         int[] newModifiedModelColors = Arrays.copyOf(this.modifiedTextureColors, this.modifiedTextureColors.length + 1);
         newOriginalModelColors[newOriginalModelColors.length - 1] = originalModelColor;
         newModifiedModelColors[newModifiedModelColors.length - 1] = modifiedModelColor;
         this.originalTextureColors = newOriginalModelColors;
         this.modifiedTextureColors = newModifiedModelColors;
      } else {
         this.originalTextureColors = new int[]{originalModelColor};
         this.modifiedTextureColors = new int[]{modifiedModelColor};
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
