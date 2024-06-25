package org.rsmapper.cache.loaders;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.rsmapper.cache.Cache;
import org.rsmapper.game.item.Item;
import org.rsmapper.game.player.Equipment;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.utilities.misc.Utils;

public final class ItemDefinitions {
   public static final ItemDefinitions[] itemsDefinitions = new ItemDefinitions[Utils.getItemDefinitionsSize()];
   public int id;
   private boolean loaded;
   public int modelId;
   public String name;
   private int modelZoom;
   private int modelRotation1;
   private int modelRotation2;
   private int modelOffset1;
   private int modelOffset2;
   private int stackable;
   private int value;
   private boolean membersOnly;
   private int maleEquip1;
   private int femaleEquip1;
   private int maleEquip2;
   private int femaleEquip2;
   private String[] groundOptions;
   public String[] inventoryOptions;
   public int[] originalModelColors;
   public int[] modifiedModelColors;
   public short[] originalTextureColors;
   public short[] modifiedTextureColors;
   private byte[] recolourPallete;
   private int[] unknownArray2;
   private int maleEquipModelId3;
   private int femaleEquipModelId3;
   private int certId;
   private int certTemplateId;
   private int[] stackIds;
   private int[] stackAmounts;
   private int modelShadowing;
   private int teamId;
   private int lendId;
   private int lendTemplateId;
   private int maleDialogueModel;
   private int femaleDialogueModel;
   private int maleDialogueHat;
   private int femaleDialogueHat;
   private int rotationZoom;
   private int dummyItem;
   private int modelVerticesX;
   private int modelVerticesY;
   private int modelVerticesZ;
   private int modelLighting;
   private int unknownInt11;
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
   private int unknownInt25;
   private int equipSlot;
   private int equipType;
   private int unknownValue1;
   private int unknownValue2;
   private int unknownValue3;
   private boolean noted;
   private boolean lended;
   private boolean isTradeable;
   private boolean isExchangeable;
   private HashMap<Integer, Object> clientScriptData;
   private HashMap<Integer, Integer> itemRequiriments;

   public static final ItemDefinitions getItemDefinitions(int itemId) {
      if (itemId < 0 || itemId >= itemsDefinitions.length) {
         itemId = 0;
      }

      ItemDefinitions def = itemsDefinitions[itemId];
      if (def == null) {
         itemsDefinitions[itemId] = def = new ItemDefinitions(itemId);
      }

      return def;
   }

   public static final void clearItemsDefinitions() {
      for(int i = 0; i < itemsDefinitions.length; ++i) {
         itemsDefinitions[i] = null;
      }

   }

   public ItemDefinitions(int id) {
      this.id = id;
      this.setDefaultsVariableValues();
      this.setDefaultOptions();
      this.loadItemDefinitions();
   }

   public static boolean isInteger(String i) {
      try {
         Integer.parseInt(i);
         return true;
      } catch (NumberFormatException var2) {
         return false;
      }
   }

   public boolean isLoaded() {
      return this.loaded;
   }

   private final void loadItemDefinitions() {
      byte[] data = Cache.STORE.getIndexes()[19].getFile(this.getArchiveId(), this.getFileId());
      if (data != null) {
         this.readOpcodeValues(new InputStream(data));
         if (this.certTemplateId != -1) {
            this.toNote();
         }

         if (this.lendTemplateId != -1) {
            this.toLend();
         }

         if (this.unknownValue1 != -1) {
            this.toLendBind();
         }

         this.loaded = true;
      }
   }

   private void toNote() {
      ItemDefinitions realItem = getItemDefinitions(this.certId);
      this.membersOnly = realItem.membersOnly;
      this.value = realItem.value;
      this.name = realItem.name;
      this.stackable = 1;
      this.noted = true;
   }

   public static ItemDefinitions forName(String name) {
      ItemDefinitions[] var4;
      int var3 = (var4 = itemsDefinitions).length;

      for(int var2 = 0; var2 < var3; ++var2) {
         ItemDefinitions definition = var4[var2];
         if (definition.name.equalsIgnoreCase(name)) {
            return definition;
         }
      }

      return null;
   }

   private void toLendBind() {
      ItemDefinitions realItem = getItemDefinitions(this.unknownValue2);
      this.originalModelColors = realItem.originalModelColors;
      this.maleEquipModelId3 = realItem.maleEquipModelId3;
      this.femaleEquipModelId3 = realItem.femaleEquipModelId3;
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
      this.maleEquip1 = realItem.maleEquip1;
      this.maleEquip2 = realItem.maleEquip2;
      this.femaleEquip1 = realItem.femaleEquip1;
      this.femaleEquip2 = realItem.femaleEquip2;
      this.clientScriptData = realItem.clientScriptData;
      this.equipSlot = realItem.equipSlot;
      this.equipType = realItem.equipType;
      this.lended = true;
   }

   public int getValue() {
      return this.value <= 0 ? 1 : this.value;
   }

   public void setValue(int value) {
      this.value = value;
   }

   private void toLend() {
      ItemDefinitions realItem = getItemDefinitions(this.lendId);
      this.originalModelColors = realItem.originalModelColors;
      this.maleEquipModelId3 = realItem.maleEquipModelId3;
      this.femaleEquipModelId3 = realItem.femaleEquipModelId3;
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
      this.maleEquip1 = realItem.maleEquip1;
      this.maleEquip2 = realItem.maleEquip2;
      this.femaleEquip1 = realItem.femaleEquip1;
      this.femaleEquip2 = realItem.femaleEquip2;
      this.clientScriptData = realItem.clientScriptData;
      this.equipSlot = realItem.equipSlot;
      this.equipType = realItem.equipType;
      this.lended = true;
   }

   public int getArchiveId() {
      return this.id >>> 8;
   }

   public int getFileId() {
      return 255 & this.id;
   }

   public boolean isDestroyItem() {
      if (this.inventoryOptions == null) {
         return false;
      } else {
         String[] var4;
         int var3 = (var4 = this.inventoryOptions).length;

         for(int var2 = 0; var2 < var3; ++var2) {
            String option = var4[var2];
            if (option != null && option.equalsIgnoreCase("destroy")) {
               return true;
            }
         }

         return false;
      }
   }

   public boolean isWearItem() {
      if (this.inventoryOptions == null) {
         return false;
      } else {
         String[] var4;
         int var3 = (var4 = this.inventoryOptions).length;

         for(int var2 = 0; var2 < var3; ++var2) {
            String option = var4[var2];
            if (option != null && (option.equalsIgnoreCase("wield") || option.equalsIgnoreCase("wear") || option.equalsIgnoreCase("equip"))) {
               return this.equipSlot != -1;
            }
         }

         return false;
      }
   }

   public boolean isWearItem(boolean male) {
      if (this.inventoryOptions == null) {
         return false;
      } else {
         if (Equipment.getItemSlot(this.id) != 12 && Equipment.getItemSlot(this.id) != 13 && Equipment.getItemSlot(this.id) != 14) {
            label63: {
               if (male) {
                  if (this.getMaleWornModelId1() != -1) {
                     break label63;
                  }
               } else if (this.getFemaleWornModelId1() != -1) {
                  break label63;
               }

               return false;
            }
         }

         String[] var5;
         int var4 = (var5 = this.inventoryOptions).length;

         for(int var3 = 0; var3 < var4; ++var3) {
            String option = var5[var3];
            if (option != null && (option.equalsIgnoreCase("wield") || option.equalsIgnoreCase("wear") || option.equalsIgnoreCase("equip"))) {
               return this.equipSlot != -1 ? true : true;
            }
         }

         return false;
      }
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
      } else if (this.id == 20821) {
         return 2122;
      } else {
         Object animId = this.clientScriptData.get(644);
         return animId != null && animId instanceof Integer ? (Integer)animId : 1426;
      }
   }

   public int getQuestId() {
      if (this.clientScriptData == null) {
         return -1;
      } else {
         Object questId = this.clientScriptData.get(861);
         return questId != null && questId instanceof Integer ? (Integer)questId : -1;
      }
   }

   public List<Item> getCreateItemRequirements(boolean infusingScroll) {
      if (this.clientScriptData == null) {
         return null;
      } else {
         List<Item> items = new ArrayList();
         int requiredId = -1;
         int requiredAmount = -1;
         Iterator var6 = this.clientScriptData.keySet().iterator();

         while(var6.hasNext()) {
            int key = (Integer)var6.next();
            Object value = this.clientScriptData.get(key);
            if (!(value instanceof String) && key >= 536 && key <= 770) {
               if (key % 2 == 0) {
                  requiredId = (Integer)value;
               } else {
                  requiredAmount = (Integer)value;
               }

               if (requiredId != -1 && requiredAmount != -1) {
                  if (infusingScroll) {
                     requiredId = this.getId();
                     requiredAmount = 1;
                  }

                  if (items.size() == 0 && !infusingScroll) {
                     items.add(new Item(requiredAmount, 1));
                  } else {
                     items.add(new Item(requiredId, requiredAmount));
                  }

                  requiredId = -1;
                  requiredAmount = -1;
                  if (infusingScroll) {
                     break;
                  }
               }
            }
         }

         return items;
      }
   }

   public HashMap<Integer, Integer> getCreateItemRequirements() {
      if (this.clientScriptData == null) {
         return null;
      } else {
         HashMap<Integer, Integer> items = new HashMap();
         int requiredId = -1;
         int requiredAmount = -1;
         Iterator var5 = this.clientScriptData.keySet().iterator();

         while(var5.hasNext()) {
            int key = (Integer)var5.next();
            Object value = this.clientScriptData.get(key);
            if (!(value instanceof String) && key >= 538 && key <= 770) {
               if (key % 2 == 0) {
                  requiredId = (Integer)value;
               } else {
                  requiredAmount = (Integer)value;
               }

               if (requiredId != -1 && requiredAmount != -1) {
                  items.put(requiredAmount, requiredId);
                  requiredId = -1;
                  requiredAmount = -1;
               }
            }
         }

         return items;
      }
   }

   public HashMap<Integer, Object> getClientScriptData() {
      return this.clientScriptData;
   }

   public HashMap<Integer, Integer> getWearingSkillRequiriments() {
      if (this.clientScriptData == null) {
         return null;
      } else {
         if (this.itemRequiriments == null) {
            HashMap<Integer, Integer> skills = new HashMap();

            for(int i = 0; i < 10; ++i) {
               Integer skill = (Integer)this.clientScriptData.get(749 + i * 2);
               if (skill != null) {
                  Integer level = (Integer)this.clientScriptData.get(750 + i * 2);
                  if (level != null) {
                     skills.put(skill, level);
                  }
               }
            }

            Integer maxedSkill = (Integer)this.clientScriptData.get(277);
            if (maxedSkill != null) {
               skills.put(maxedSkill, this.id == 19709 ? 120 : 99);
            }

            this.itemRequiriments = skills;
            if (this.id == 7462) {
               this.itemRequiriments.put(1, 40);
            } else if (this.name.equals("Dragon defender")) {
               this.itemRequiriments.put(0, 60);
               this.itemRequiriments.put(1, 60);
            }
         }

         return this.itemRequiriments;
      }
   }

   private void setDefaultOptions() {
      this.groundOptions = new String[]{null, null, "take", null, null};
      this.inventoryOptions = new String[]{null, null, null, null, "destroy"};
   }

   private void setDefaultsVariableValues() {
      this.maleEquip1 = -1;
      this.unknownInt24 = -1;
      this.maleEquip2 = -1;
      this.rotationZoom = 0;
      this.lendTemplateId = -1;
      this.unknownInt25 = -1;
      this.unknownValue2 = -1;
      this.maleEquipModelId3 = -1;
      this.modelLighting = 0;
      this.modelShadowing = 0;
      this.femaleDialogueModel = -1;
      this.modelZoom = 2000;
      this.unknownInt18 = -1;
      this.teamId = 0;
      this.membersOnly = false;
      this.modelVerticesY = 128;
      this.modelOffset1 = 0;
      this.name = "null";
      this.unknownInt23 = -1;
      this.modelVerticesX = 128;
      this.maleDialogueHat = -1;
      this.femaleDialogueHat = -1;
      this.unknownInt18 = -1;
      this.unknownInt20 = -1;
      this.unknownInt21 = -1;
      this.modelRotation2 = 0;
      this.unknownInt14 = 0;
      this.unknownInt19 = -1;
      this.unknownInt22 = -1;
      this.unknownInt16 = 0;
      this.femaleEquip2 = -1;
      this.modelOffset2 = 0;
      this.unknownInt15 = 0;
      this.maleDialogueModel = -1;
      this.unknownValue3 = 0;
      this.stackable = 0;
      this.modelVerticesZ = 128;
      this.femaleEquipModelId3 = -1;
      this.certTemplateId = -1;
      this.certId = -1;
      this.value = 1;
      this.dummyItem = 0;
      this.unknownValue1 = -1;
      this.modelRotation1 = 0;
      this.lendId = -1;
      this.femaleEquip1 = -1;
      this.unknownInt13 = 0;
      this.unknownInt17 = 0;
      this.unknownInt12 = 0;
      this.equipSlot = -1;
      this.equipType = -1;
   }

   private final void readValues(InputStream stream, int opcode) {
      if (opcode == 1) {
         this.modelId = stream.readUnsignedShort();
      } else if (opcode == 2) {
         this.name = stream.readString();
      } else if (opcode == 4) {
         this.modelZoom = stream.readUnsignedShort();
      } else if (opcode == 5) {
         this.modelRotation1 = stream.readUnsignedShort();
      } else if (opcode == 6) {
         this.modelRotation2 = stream.readUnsignedShort();
      } else if (opcode == 7) {
         this.modelOffset1 = stream.readUnsignedShort();
         if (this.modelOffset1 > 32767) {
            this.modelOffset1 -= 65536;
         }
      } else if (opcode == 8) {
         this.modelOffset2 = stream.readUnsignedShort();
         if (this.modelOffset2 > 32767) {
            this.modelOffset2 -= 65536;
         }
      } else if (opcode == 11) {
         this.stackable = 1;
      } else if (opcode == 12) {
         this.value = stream.readInt();
      } else if (opcode == 13) {
         this.equipSlot = stream.readUnsignedByte();
      } else if (opcode == 14) {
         this.equipType = stream.readUnsignedByte();
      } else if (opcode == 15) {
         this.isTradeable = stream.readUnsignedByte() == 1;
      } else if (opcode == 17) {
         this.isExchangeable = stream.readUnsignedByte() == 1;
      } else if (opcode == 16) {
         this.membersOnly = true;
      } else if (opcode == 18) {
         this.unknownInt11 = stream.readUnsignedShort();
      } else if (opcode == 23) {
         this.maleEquip1 = stream.readUnsignedShort();
      } else if (opcode == 24) {
         this.maleEquip2 = stream.readUnsignedShort();
      } else if (opcode == 25) {
         this.femaleEquip1 = stream.readUnsignedShort();
      } else if (opcode == 26) {
         this.femaleEquip2 = stream.readUnsignedShort();
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

            for(index = 0; length > index; ++index) {
               this.originalModelColors[index] = (short)stream.readUnsignedShort();
               this.modifiedModelColors[index] = (short)stream.readUnsignedShort();
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
            this.recolourPallete = new byte[length];

            for(index = 0; index < length; ++index) {
               this.recolourPallete[index] = (byte)stream.readByte();
            }
         } else if (opcode != 65) {
            if (opcode == 78) {
               this.maleEquipModelId3 = stream.readUnsignedShort();
            } else if (opcode == 79) {
               this.femaleEquipModelId3 = stream.readUnsignedShort();
            } else if (opcode == 90) {
               this.maleDialogueModel = stream.readUnsignedShort();
            } else if (opcode == 91) {
               this.femaleDialogueModel = stream.readUnsignedShort();
            } else if (opcode == 92) {
               this.maleDialogueHat = stream.readUnsignedShort();
            } else if (opcode == 93) {
               this.femaleDialogueHat = stream.readUnsignedShort();
            } else if (opcode == 95) {
               this.rotationZoom = stream.readUnsignedShort();
            } else if (opcode == 96) {
               this.dummyItem = stream.readUnsignedByte();
            } else if (opcode == 97) {
               this.certId = stream.readUnsignedShort();
            } else if (opcode == 98) {
               this.certTemplateId = stream.readUnsignedShort();
            } else if (opcode >= 100 && opcode < 110) {
               if (this.stackIds == null) {
                  this.stackIds = new int[10];
                  this.stackAmounts = new int[10];
               }

               this.stackIds[opcode - 100] = stream.readUnsignedShort();
               this.stackAmounts[opcode - 100] = stream.readUnsignedShort();
            } else if (opcode == 110) {
               this.modelVerticesX = stream.readUnsignedShort();
            } else if (opcode == 111) {
               this.modelVerticesY = stream.readUnsignedShort();
            } else if (opcode == 112) {
               this.modelVerticesZ = stream.readUnsignedShort();
            } else if (opcode == 113) {
               this.modelLighting = stream.readByte();
            } else if (opcode == 114) {
               this.modelShadowing = stream.readByte() * 5;
            } else if (opcode == 115) {
               this.teamId = stream.readUnsignedByte();
            } else if (opcode == 121) {
               this.lendId = stream.readUnsignedShort();
            } else if (opcode == 122) {
               this.lendTemplateId = stream.readUnsignedShort();
            } else if (opcode == 125) {
               this.unknownInt12 = stream.readByte() << 2;
               this.unknownInt13 = stream.readByte() << 2;
               this.unknownInt14 = stream.readByte() << 2;
            } else if (opcode == 126) {
               this.unknownInt15 = stream.readByte() << 2;
               this.unknownInt16 = stream.readByte() << 2;
               this.unknownInt17 = stream.readByte() << 2;
            } else if (opcode == 127) {
               this.unknownInt18 = stream.readUnsignedByte();
               this.unknownInt19 = stream.readUnsignedShort();
            } else if (opcode == 128) {
               this.unknownInt20 = stream.readUnsignedByte();
               this.unknownInt21 = stream.readUnsignedShort();
            } else if (opcode == 129) {
               this.unknownInt22 = stream.readUnsignedByte();
               this.unknownInt23 = stream.readUnsignedShort();
            } else if (opcode == 130) {
               this.unknownInt24 = stream.readUnsignedByte();
               this.unknownInt25 = stream.readUnsignedShort();
            } else if (opcode == 132) {
               length = stream.readUnsignedByte();
               this.unknownArray2 = new int[length];

               for(index = 0; index < length; ++index) {
                  this.unknownArray2[index] = stream.readUnsignedShort();
               }
            } else if (opcode == 134) {
               this.unknownValue3 = stream.readUnsignedByte();
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
            }
         }
      }

   }

   private final void readOpcodeValues(InputStream stream) {
      while(true) {
         int opcode = stream.readUnsignedByte();
         if (opcode == 0) {
            return;
         }

         this.readValues(stream, opcode);
      }
   }

   public String getName() {
      return this.name;
   }

   public int getFemaleWornModelId1() {
      return this.femaleEquip1;
   }

   public int getFemaleWornModelId2() {
      return this.femaleEquip2;
   }

   public int getMaleWornModelId1() {
      return this.maleEquip1;
   }

   public int getMaleWornModelId2() {
      return this.maleEquip2;
   }

   public boolean isLended() {
      return this.lended;
   }

   public boolean isStackable() {
      return this.stackable == 1 || this.id == 10943 || this.id == 10944;
   }

   public boolean isNoted() {
      return this.noted;
   }

   public boolean isTradeable() {
      return this.isTradeable;
   }

   public boolean isExchangeable() {
      return this.isExchangeable;
   }

   public int getLendId() {
      return this.lendId;
   }

   public int getCertId() {
      return this.certId;
   }

   public int getEquipSlot() {
      return this.equipSlot;
   }

   public int getEquipType() {
      return this.equipType;
   }

   public int getId() {
      return this.id;
   }

   public int getStageOnDeath() {
      if (this.clientScriptData == null) {
         return 0;
      } else {
         Object protectedOnDeath = this.clientScriptData.get(1397);
         return protectedOnDeath != null && protectedOnDeath instanceof Integer ? (Integer)protectedOnDeath : 0;
      }
   }

   public int getAttackSpeed() {
      if (this.id >= 24455 && this.id <= 24457) {
         return 6;
      } else if (this.clientScriptData == null) {
         return 4;
      } else {
         Object attackSpeed = this.clientScriptData.get(14);
         return attackSpeed != null && attackSpeed instanceof Integer ? (Integer)attackSpeed : 4;
      }
   }

   public int getStabAttack() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(0);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getSlashAttack() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(1);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getCrushAttack() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(2);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getMagicAttack() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(3);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getRangeAttack() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(4);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getStabDef() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(5);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getSlashDef() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(6);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getCrushDef() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(7);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getMagicDef() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(8);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getRangeDef() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(9);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getSummoningDef() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(417);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getAbsorveMeleeBonus() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(967);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getAbsorveMageBonus() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(969);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getAbsorveRangeBonus() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(968);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getStrengthBonus() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(641);
         return value != null && value instanceof Integer ? (Integer)value / 10 : 0;
      } else {
         return 0;
      }
   }

   public int getRangedStrBonus() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(643);
         return value != null && value instanceof Integer ? (Integer)value / 10 : 0;
      } else {
         return 0;
      }
   }

   public int getMagicDamage() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(685);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }

   public int getPrayerBonus() {
      if (this.id <= 25439 && this.clientScriptData != null) {
         Object value = this.clientScriptData.get(11);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      } else {
         return 0;
      }
   }
}
