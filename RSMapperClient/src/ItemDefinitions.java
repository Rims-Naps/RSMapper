public class ItemDefinitions {
   public static final byte SLOT_HAT = 0;
   public static final byte SLOT_CAPE = 1;
   public static final byte SLOT_AMULET = 2;
   public static final byte SLOT_WEAPON = 3;
   public static final byte SLOT_CHEST = 4;
   public static final byte SLOT_SHIELD = 5;
   public static final byte SLOT_LEGS = 7;
   public static final byte SLOT_HANDS = 9;
   public static final byte SLOT_FEET = 10;
   public static final byte SLOT_RING = 12;
   public static final byte SLOT_ARROWS = 13;
   public static final byte SLOT_AURA = 14;
   static int anInt1848;
   protected int indexOfGroundOptionSprite2;
   private short[] originalTextureColors;
   protected int groundOptionSprite2 = -1;
   protected int lendTemplateId;
   protected int maleEquip1;
   static int anInt1854;
   static int anInt1855;
   private short[] originalModelColors;
   protected int certTemplateId;
   static int anInt1858;
   protected int inventoryOptionSprite1;
   protected String name;
   static int anInt1861;
   protected int inventoryOptionSprite2;
   protected int femaleDialogueModel;
   protected int indexOfInventoryOptionSprite2;
   protected short[] modifiedModelColors;
   protected int rotationZoom;
   protected int maleEquipModelId3;
   protected Class86 aClass86_1868;
   protected int modelRotation2;
   static int anInt1870;
   protected boolean membersOnly;
   protected int[] stackAmounts;
   protected HashTable clientScriptData;
   protected int modelZoom;
   protected int modelOffset2;
   private int modelLighting;
   protected int dummyItem;
   protected int maleEquip2;
   protected int unknownInt11;
   protected int femaleEquip1;
   static int anInt1881;
   private byte[] recolourPallete;
   protected int femaleEquip2;
   protected int modelRotation1;
   static int anInt1885;
   private int modelShadowing;
   protected int certId;
   protected int maleDialogueHat;
   protected int groundOptionSprite1;
   private int unknownInt15;
   protected int unknownValue2;
   protected int stackable;
   private int unknownInt16;
   static int anInt1894;
   private int unknownInt14;
   private int modelVerticesZ;
   protected int femaleDialogueHat;
   private int modelId;
   protected int teamId;
   protected int indexOfInventoryOptionSprite1;
   protected String[] inventoryOptions;
   static int anInt1902;
   static int anInt1903;
   private int modelVerticesX;
   protected int modelOffset1;
   static int anInt1906;
   static int anInt1907;
   protected int indexOfGroundOptionSprite1;
   protected int unknownInt20;
   protected int unknownInt21;
   protected short[] modifiedTextureColors;
   static int anInt1910;
   private int modelVerticesY;
   static int anInt1912;
   protected int maleDialogueModel;
   protected int anInt1914;
   protected int femaleEquipModelId3;
   private int unknownInt17;
   static int anInt1917;
   protected int[] stackIds;
   protected int groundInteractRadius;
   protected String[] groundOptions;
   static int anInt1921;
   static int anInt1922;
   static int anInt1923;
   protected int value;
   static Node_Sub43 aNode_Sub43_1925;
   protected int[] rightClickImages;
   protected int lendId;
   protected int unknownValue1;
   static int anInt1929;
   private int unknownInt13;
   private int unknownInt12;
   static int anInt1932;
   protected boolean showInGrandExchange;
   protected int equipSlot;
   protected int equipType;
   protected boolean isTradeable;
   protected boolean isExchangeable;
   public static int id;

   static final void method1673(int i, int i_0_) {
      ++anInt1855;
      if (~Class151.anInt1843 == -8 && ~Node_Sub38_Sub8.anInt10163 == -1 && Class4.anInt124 == 0) {
         Node_Sub38_Sub23.anInt10347 = i;
         if (i_0_ != 2) {
            method1690((byte)19);
         }

         Class48.method478(9, (byte)113);
      }
   }

   final ItemDefinitions method1674(int i, int i_1_) {
      if (i_1_ >= -68) {
         return null;
      } else {
         ++anInt1902;
         if (this.stackIds != null && ~i < -2) {
            int i_2_ = -1;

            for(int i_3_ = 0; ~i_3_ > -11; ++i_3_) {
               if (~this.stackAmounts[i_3_] >= ~i && ~this.stackAmounts[i_3_] != -1) {
                  i_2_ = this.stackIds[i_3_];
               }
            }

            if (i_2_ != -1) {
               return this.aClass86_1868.getItemDefinitionForId(i_2_);
            }
         }

         return this;
      }
   }

   final void decode(Buffer buffer) {
      ++anInt1861;

      while(true) {
         int opcode = buffer.readUnsignedByte();
         if (opcode == 0) {
            id = -1;
            return;
         }

         this.parseItemDefs(buffer, opcode);
      }
   }

   final void toLend(byte b, ItemDefinitions realItem, ItemDefinitions itemdefinition_6_) {
      this.modifiedModelColors = realItem.modifiedModelColors;
      this.maleDialogueModel = realItem.maleDialogueModel;
      this.maleDialogueHat = realItem.maleDialogueHat;
      this.maleEquipModelId3 = realItem.maleEquipModelId3;
      this.teamId = realItem.teamId;
      this.clientScriptData = realItem.clientScriptData;
      this.membersOnly = realItem.membersOnly;
      this.modifiedTextureColors = realItem.modifiedTextureColors;
      this.unknownInt13 = realItem.unknownInt13;
      this.femaleEquip2 = realItem.femaleEquip2;
      this.rotationZoom = itemdefinition_6_.rotationZoom;
      this.groundOptions = realItem.groundOptions;
      ++anInt1923;
      this.femaleDialogueHat = realItem.femaleDialogueHat;
      this.recolourPallete = realItem.recolourPallete;
      if (b < 74) {
         method1673(-71, 35);
      }

      this.unknownInt16 = realItem.unknownInt16;
      this.modelRotation1 = itemdefinition_6_.modelRotation1;
      this.femaleEquip1 = realItem.femaleEquip1;
      this.modelId = itemdefinition_6_.modelId;
      this.inventoryOptions = new String[5];
      this.modelRotation2 = itemdefinition_6_.modelRotation2;
      this.modelOffset2 = itemdefinition_6_.modelOffset2;
      this.originalTextureColors = realItem.originalTextureColors;
      this.unknownInt15 = realItem.unknownInt15;
      this.maleEquip2 = realItem.maleEquip2;
      this.value = 0;
      this.unknownInt14 = realItem.unknownInt14;
      this.originalModelColors = realItem.originalModelColors;
      this.modelOffset1 = itemdefinition_6_.modelOffset1;
      this.unknownInt17 = realItem.unknownInt17;
      this.femaleDialogueModel = realItem.femaleDialogueModel;
      this.modelZoom = itemdefinition_6_.modelZoom;
      this.name = realItem.name;
      this.femaleEquipModelId3 = realItem.femaleEquipModelId3;
      this.maleEquip1 = realItem.maleEquip1;
      this.unknownInt12 = realItem.unknownInt12;
      this.equipSlot = realItem.equipSlot;
      this.equipType = realItem.equipType;
      if (realItem.inventoryOptions != null) {
         for(int i = 0; ~i > -5; ++i) {
            this.inventoryOptions[i] = realItem.inventoryOptions[i];
         }
      }

      this.inventoryOptions[4] = Class22.aClass22_369.getStoredString(this.aClass86_1868.anInt1161);
   }

   final void toNote(ItemDefinitions itemdefinition_7_, int i, ItemDefinitions itemdefinition_8_) {
      this.modelOffset2 = itemdefinition_7_.modelOffset2;
      this.originalModelColors = itemdefinition_7_.originalModelColors;
      this.value = itemdefinition_8_.value;
      this.name = itemdefinition_8_.name;
      this.modifiedTextureColors = itemdefinition_7_.modifiedTextureColors;
      this.modelRotation2 = itemdefinition_7_.modelRotation2;
      this.rotationZoom = itemdefinition_7_.rotationZoom;
      this.originalTextureColors = itemdefinition_7_.originalTextureColors;
      this.modelId = itemdefinition_7_.modelId;
      this.modelZoom = itemdefinition_7_.modelZoom;
      this.recolourPallete = itemdefinition_7_.recolourPallete;
      this.stackable = 1;
      this.modelRotation1 = itemdefinition_7_.modelRotation1;
      this.modelOffset1 = itemdefinition_7_.modelOffset1;
      this.membersOnly = itemdefinition_8_.membersOnly;
      this.modifiedModelColors = itemdefinition_7_.modifiedModelColors;
      ++anInt1894;
   }

   final int method1678(int i, int i_10_, int i_11_) {
      ++anInt1870;
      if (this.clientScriptData == null) {
         return i_10_;
      } else {
         Node_Sub32 node_sub32 = (Node_Sub32)this.clientScriptData.get(i_11_ ^ 9663, (long)i);
         if (i_11_ != 10247) {
            this.indexOfInventoryOptionSprite1 = 69;
         }

         return node_sub32 == null ? i_10_ : node_sub32.anInt7381;
      }
   }

   private final int[] method1679(int i, int i_12_, int[] is) {
      ++anInt1912;
      int[] is_13_ = new int[1152];
      int i_14_ = 0;

      for(int i_15_ = 0; ~i_15_ > -33; ++i_15_) {
         for(int i_16_ = 0; ~i_16_ > -37; ++i_16_) {
            int i_17_ = is[i_14_];
            if (i_17_ == 0) {
               if (~i_16_ < -1 && ~is[-1 + i_14_] != -1) {
                  i_17_ = i_12_;
               } else if (i_15_ > 0 && ~is[i_14_ - 36] != -1) {
                  i_17_ = i_12_;
               } else if (~i_16_ > -36 && ~is[i_14_ - -1] != -1) {
                  i_17_ = i_12_;
               } else if (~i_15_ > -32 && is[36 + i_14_] != 0) {
                  i_17_ = i_12_;
               }
            }

            is_13_[i_14_++] = i_17_;
         }
      }

      if (i != -1) {
         this.originalModelColors = null;
      }

      return is_13_;
   }

   public static void method1680(byte b) {
      if (b <= 84) {
         anInt1858 = -85;
      }

      aNode_Sub43_1925 = null;
   }

   public boolean canExchange(int itemId) {
      return this.isExchangeable;
   }

   public boolean isTradeable() {
      return this.isTradeable;
   }

   public boolean isWearItem() {
      return this.equipSlot != -1;
   }

   public boolean isWearItem(boolean male) {
      if (this.equipSlot >= 12 || (male ? this.maleEquip1 != -1 : this.femaleEquip1 != -1)) {
         return this.equipSlot != -1;
      } else {
         return false;
      }
   }

   private final void parseItemDefs(Buffer stream, int opcode) {
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
      } else if (opcode == 40) {
         int length = stream.readUnsignedByte();
         this.originalModelColors = new short[length];
         this.modifiedModelColors = new short[length];

         for(int index = 0; length > index; ++index) {
            this.originalModelColors[index] = (short)stream.readUnsignedShort();
            this.modifiedModelColors[index] = (short)stream.readUnsignedShort();
         }
      } else if (opcode == 41) {
         int length = stream.readUnsignedByte();
         this.originalTextureColors = new short[length];
         this.modifiedTextureColors = new short[length];

         for(int index = 0; index < length; ++index) {
            this.originalTextureColors[index] = (short)stream.readUnsignedShort();
            this.modifiedTextureColors[index] = (short)stream.readUnsignedShort();
         }
      } else if (opcode == 42) {
         int length = stream.readUnsignedByte();
         this.recolourPallete = new byte[length];

         for(int index = 0; index < length; ++index) {
            this.recolourPallete[index] = stream.readByte();
         }
      } else if (opcode == 65) {
         this.showInGrandExchange = true;
      } else if (opcode == 78) {
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
         this.indexOfGroundOptionSprite1 = stream.readUnsignedByte();
         this.groundOptionSprite1 = stream.readUnsignedShort();
      } else if (opcode == 128) {
         this.indexOfGroundOptionSprite2 = stream.readUnsignedByte();
         this.groundOptionSprite2 = stream.readUnsignedShort();
      } else if (opcode == 129) {
         this.indexOfInventoryOptionSprite1 = stream.readUnsignedByte();
         this.inventoryOptionSprite1 = stream.readUnsignedShort();
      } else if (opcode == 130) {
         this.indexOfInventoryOptionSprite2 = stream.readUnsignedByte();
         this.inventoryOptionSprite2 = stream.readUnsignedShort();
      } else if (opcode == 132) {
         int length = stream.readUnsignedByte();
         this.rightClickImages = new int[length];

         for(int index = 0; index < length; ++index) {
            this.rightClickImages[index] = stream.readUnsignedShort();
         }
      } else if (opcode == 134) {
         this.groundInteractRadius = stream.readUnsignedByte();
      } else if (opcode == 139) {
         this.unknownValue2 = stream.readUnsignedShort();
      } else if (opcode == 140) {
         this.unknownValue1 = stream.readUnsignedShort();
      } else {
         if (opcode != 249) {
            throw new RuntimeException("MISSING OPCODE " + opcode + " FOR ITEM " + this.name);
         }

         int length = stream.readUnsignedByte();
         if (this.clientScriptData == null) {
            int size = Class320_Sub19.method3753(length);
            this.clientScriptData = new HashTable(size);
         }

         for(int index = 0; length > index; ++index) {
            boolean isString = stream.readUnsignedByte() == 1;
            int key = stream.read24BitInteger();
            Node node;
            if (!isString) {
               node = new Node_Sub32(stream.readInt());
            } else {
               node = new Node_Sub18(stream.readString());
            }

            this.clientScriptData.put((long)key, node, -127);
         }
      }

      ++anInt1922;
   }

   final int[] drawInventoryModel(
      int i,
      GraphicsToolkit graphicstoolkit,
      int i_31_,
      byte b,
      int i_32_,
      boolean bool,
      PlayerDefinition playerdefinition,
      GraphicsToolkit graphicstoolkit_33_,
      Class52 class52,
      int i_34_
   ) {
      ++anInt1854;
      Model model = Renderer.method3448(this.modelId, 7, 0, this.aClass86_1868.aClass302_1168);
      if (model == null) {
         return null;
      } else {
         if (~model.anInt2614 > -14) {
            model.method2081(2, 0);
         }

         if (this.originalModelColors != null) {
            for(int i_35_ = 0; ~i_35_ > ~this.originalModelColors.length; ++i_35_) {
               if (this.recolourPallete != null && ~i_35_ > ~this.recolourPallete.length) {
                  model.method2089(this.originalModelColors[i_35_], Class129.aShortArray1665[255 & this.recolourPallete[i_35_]], -89);
               } else {
                  model.method2089(this.originalModelColors[i_35_], this.modifiedModelColors[i_35_], -126);
               }
            }
         }

         if (this.originalTextureColors != null) {
            for(int i_36_ = 0; ~this.originalTextureColors.length < ~i_36_; ++i_36_) {
               model.method2087(this.originalTextureColors[i_36_], this.modifiedTextureColors[i_36_], -78);
            }
         }

         if (playerdefinition != null) {
            for(int i_37_ = 0; i_37_ < 10; ++i_37_) {
               for(int i_38_ = 0; ~Class45.aShortArrayArray5265[i_37_].length < ~i_38_; ++i_38_) {
                  if (~playerdefinition.anIntArray3430[i_37_] > ~Class117_Sub2.aShortArrayArrayArray5151[i_37_][i_38_].length) {
                     model.method2089(
                        Class45.aShortArrayArray5265[i_37_][i_38_],
                        Class117_Sub2.aShortArrayArrayArray5151[i_37_][i_38_][playerdefinition.anIntArray3430[i_37_]],
                        -60
                     );
                  }
               }
            }
         }

         int i_39_ = 2048;
         boolean bool_40_ = false;
         if (~this.modelVerticesX != -129 || ~this.modelVerticesY != -129 || this.modelVerticesZ != 128) {
            bool_40_ = true;
            i_39_ |= 7;
         }

         DrawableModel drawablemodel = graphicstoolkit_33_.a(model, i_39_, 64, this.modelLighting + 64, this.modelShadowing + 768);
         if (!drawablemodel.method612()) {
            return null;
         } else {
            if (bool_40_) {
               drawablemodel.O(this.modelVerticesX, this.modelVerticesY, this.modelVerticesZ);
            }

            GLSprite glsprite = null;
            if (this.certTemplateId != -1) {
               glsprite = this.aClass86_1868
                  .method1002(1, graphicstoolkit_33_, graphicstoolkit, playerdefinition, true, 0, 10, true, 0, class52, this.certId, -16139);
               if (glsprite == null) {
                  return null;
               }
            } else if (this.lendTemplateId != -1) {
               glsprite = this.aClass86_1868
                  .method1002(i_34_, graphicstoolkit_33_, graphicstoolkit, playerdefinition, true, i_32_, i_31_, false, 0, class52, this.lendId, -16139);
               if (glsprite == null) {
                  return null;
               }
            } else if (this.unknownValue1 != -1) {
               glsprite = this.aClass86_1868
                  .method1002(i_34_, graphicstoolkit_33_, graphicstoolkit, playerdefinition, true, i_32_, i_31_, false, 0, class52, this.unknownValue2, -16139);
               if (glsprite == null) {
                  return null;
               }
            }

            int i_42_;
            if (bool) {
               i_42_ = (int)(1.5 * (double)this.modelZoom) << 2;
            } else if (i_34_ != 2) {
               i_42_ = this.modelZoom << 2;
            } else {
               i_42_ = (int)((double)this.modelZoom * 1.04) << 2;
            }

            graphicstoolkit_33_.DA(16, 16, 512, 512);
            Class336 class336 = graphicstoolkit_33_.y();
            class336.method3862();
            graphicstoolkit_33_.a(class336);
            graphicstoolkit_33_.xa(1.0F);
            graphicstoolkit_33_.ZA(16777215, 1.0F, 1.0F, -50.0F, -10.0F, -50.0F);
            Class336 class336_43_ = graphicstoolkit_33_.A();
            class336_43_.method3861(-this.rotationZoom << 3);
            class336_43_.method3856(this.modelRotation2 << 3);
            class336_43_.method3863(
               this.modelOffset1 << 2,
               (Class335.anIntArray4167[this.modelRotation1 << 3] * i_42_ >> 14) + -(drawablemodel.fa() / 2) - -(this.modelOffset2 << 2),
               (Class335.anIntArray4165[this.modelRotation1 << 3] * i_42_ >> 14) - -(this.modelOffset2 << 2)
            );
            class336_43_.method3859(this.modelRotation1 << 3);
            int i_44_ = graphicstoolkit_33_.i();
            int i_45_ = graphicstoolkit_33_.XA();
            graphicstoolkit_33_.f(50, Integer.MAX_VALUE);
            graphicstoolkit_33_.ya();
            graphicstoolkit_33_.la();
            graphicstoolkit_33_.aa(0, 0, 36, 32, 0, 0);
            drawablemodel.method611(class336_43_, null, 1);
            graphicstoolkit_33_.f(i_44_, i_45_);
            int[] is = graphicstoolkit_33_.na(0, 0, 36, 32);
            if (i_34_ >= 1) {
               is = this.method1679(-1, -16777214, is);
               if (i_34_ >= 2) {
                  is = this.method1679(-1, -1, is);
               }
            }

            if (i_32_ != 0) {
               this.method1688(i_32_, is, -7048);
            }

            graphicstoolkit_33_.method1235(36, 36, 32, is, 0, 7468).method1196(0, 0);
            if (this.certTemplateId == -1) {
               if (this.lendTemplateId != -1) {
                  glsprite.method1196(0, 0);
               } else if (this.unknownValue1 != -1) {
                  glsprite.method1196(0, 0);
               }
            } else {
               glsprite.method1196(0, 0);
            }

            if (~i == -2 || ~i == -3 && (~this.stackable == -2 || ~i_31_ != -2) && i_31_ != -1) {
               class52.method538(0, 9, this.method1687(22050, i_31_), -16777215, 1, -256);
            }

            is = graphicstoolkit_33_.na(0, 0, 36, 32);

            for(int i_46_ = 0; ~is.length < ~i_46_; ++i_46_) {
               if (~(16777215 & is[i_46_]) == -1) {
                  is[i_46_] = 0;
               } else {
                  is[i_46_] = Node_Sub16.method2590(is[i_46_], -16777216);
               }
            }

            return is;
         }
      }
   }

   final Model method1683(TemporaryItemDefinition class38, boolean bool, int i) {
      ++anInt1917;
      int i_47_;
      int i_48_;
      int i_49_;
      if (!bool) {
         if (class38 != null && class38.maleWornModelIds != null) {
            i_47_ = class38.maleWornModelIds[0];
            i_48_ = class38.maleWornModelIds[1];
            i_49_ = class38.maleWornModelIds[2];
         } else {
            i_49_ = this.maleEquipModelId3;
            i_47_ = this.maleEquip1;
            i_48_ = this.maleEquip2;
         }
      } else if (class38 != null && class38.femaleWornModelIds != null) {
         i_49_ = class38.femaleWornModelIds[2];
         i_47_ = class38.femaleWornModelIds[0];
         i_48_ = class38.femaleWornModelIds[1];
      } else {
         i_47_ = this.femaleEquip1;
         i_48_ = this.femaleEquip2;
         i_49_ = this.femaleEquipModelId3;
      }

      if (i_47_ == -1) {
         return null;
      } else {
         Model model = Renderer.method3448(i_47_, 7, 0, this.aClass86_1868.aClass302_1168);
         if (model == null) {
            return null;
         } else {
            if (model.anInt2614 < 13) {
               model.method2081(2, 0);
            }

            if (~i_48_ != 0) {
               Model model_50_ = Renderer.method3448(i_48_, 7, 0, this.aClass86_1868.aClass302_1168);
               if (~model_50_.anInt2614 > -14) {
                  model_50_.method2081(2, 0);
               }

               if (~i_49_ != 0) {
                  Model model_51_ = Renderer.method3448(i_49_, 7, 0, this.aClass86_1868.aClass302_1168);
                  if (model_51_.anInt2614 < 13) {
                     model_51_.method2081(2, 0);
                  }

                  Model[] models = new Model[]{model, model_50_, model_51_};
                  model = new Model(models, 3);
               } else {
                  Model[] models = new Model[]{model, model_50_};
                  model = new Model(models, 2);
               }
            }

            if (!bool && (this.unknownInt12 != 0 || ~this.unknownInt13 != -1 || ~this.unknownInt14 != -1)) {
               model.method2082(this.unknownInt12, this.unknownInt13, -102, this.unknownInt14);
            }

            if (bool && (~this.unknownInt15 != -1 || ~this.unknownInt16 != -1 || this.unknownInt17 != 0)) {
               model.method2082(this.unknownInt15, this.unknownInt16, 96, this.unknownInt17);
            }

            if (this.originalModelColors != null) {
               short[] ses;
               if (class38 != null && class38.modifiedModelColors != null) {
                  ses = class38.modifiedModelColors;
               } else {
                  ses = this.modifiedModelColors;
               }

               for(int i_52_ = 0; i_52_ < this.originalModelColors.length; ++i_52_) {
                  model.method2089(this.originalModelColors[i_52_], ses[i_52_], 76);
               }
            }

            if (this.originalTextureColors != null) {
               short[] ses;
               if (class38 != null && class38.modifiedTextureColors != null) {
                  ses = class38.modifiedTextureColors;
               } else {
                  ses = this.modifiedTextureColors;
               }

               for(int i_53_ = 0; i_53_ < this.originalTextureColors.length; ++i_53_) {
                  model.method2087(this.originalTextureColors[i_53_], ses[i_53_], -84);
               }
            }

            return i >= -34 ? null : model;
         }
      }
   }

   final String method1684(String string, int i, int i_54_) {
      ++anInt1881;
      if (this.clientScriptData == null) {
         return string;
      } else {
         Node_Sub18 node_sub18 = (Node_Sub18)this.clientScriptData.get(3512, (long)i_54_);
         if (i != -32525) {
            return null;
         } else {
            return node_sub18 == null ? string : node_sub18.aString7149;
         }
      }
   }

   final Model method1685(boolean bool, TemporaryItemDefinition class38, int i) {
      ++anInt1848;
      int i_55_;
      int i_56_;
      if (!bool) {
         if (class38 != null && class38.anIntArray564 != null) {
            i_55_ = class38.anIntArray564[0];
            i_56_ = class38.anIntArray564[1];
         } else {
            i_56_ = this.maleDialogueHat;
            i_55_ = this.maleDialogueModel;
         }
      } else if (class38 != null && class38.anIntArray568 != null) {
         i_56_ = class38.anIntArray568[1];
         i_55_ = class38.anIntArray568[0];
      } else {
         i_55_ = this.femaleDialogueModel;
         i_56_ = this.femaleDialogueHat;
      }

      if (~i_55_ == 0) {
         return null;
      } else if (i > -33) {
         return null;
      } else {
         Model model = Renderer.method3448(i_55_, 7, 0, this.aClass86_1868.aClass302_1168);
         if (model.anInt2614 < 13) {
            model.method2081(2, 0);
         }

         if (i_56_ != -1) {
            Model model_57_ = Renderer.method3448(i_56_, 7, 0, this.aClass86_1868.aClass302_1168);
            if (~model_57_.anInt2614 > -14) {
               model_57_.method2081(2, 0);
            }

            Model[] models = new Model[]{model, model_57_};
            model = new Model(models, 2);
         }

         if (this.originalModelColors != null) {
            short[] ses;
            if (class38 != null && class38.modifiedModelColors != null) {
               ses = class38.modifiedModelColors;
            } else {
               ses = this.modifiedModelColors;
            }

            for(int i_58_ = 0; ~i_58_ > ~this.originalModelColors.length; ++i_58_) {
               model.method2089(this.originalModelColors[i_58_], ses[i_58_], 115);
            }
         }

         if (this.originalTextureColors != null) {
            short[] ses;
            if (class38 != null && class38.modifiedTextureColors != null) {
               ses = class38.modifiedTextureColors;
            } else {
               ses = this.modifiedTextureColors;
            }

            for(int i_59_ = 0; ~this.originalTextureColors.length < ~i_59_; ++i_59_) {
               model.method2087(this.originalTextureColors[i_59_], ses[i_59_], 101);
            }
         }

         return model;
      }
   }

   final boolean method1686(boolean bool, TemporaryItemDefinition class38, int i) {
      ++anInt1885;
      int i_60_;
      int i_61_;
      int i_62_;
      if (bool) {
         if (class38 != null && class38.femaleWornModelIds != null) {
            i_61_ = class38.femaleWornModelIds[0];
            i_62_ = class38.femaleWornModelIds[1];
            i_60_ = class38.femaleWornModelIds[2];
         } else {
            i_61_ = this.femaleEquip1;
            i_60_ = this.femaleEquipModelId3;
            i_62_ = this.femaleEquip2;
         }
      } else if (class38 != null && class38.maleWornModelIds != null) {
         i_62_ = class38.maleWornModelIds[1];
         i_60_ = class38.maleWornModelIds[2];
         i_61_ = class38.maleWornModelIds[0];
      } else {
         i_60_ = this.maleEquipModelId3;
         i_61_ = this.maleEquip1;
         i_62_ = this.maleEquip2;
      }

      if (i_61_ == -1) {
         return true;
      } else {
         boolean bool_64_ = true;
         if (!this.aClass86_1868.aClass302_1168.method3515(0, i_61_, 0)) {
            bool_64_ = false;
         }

         if (i_62_ != -1 && !this.aClass86_1868.aClass302_1168.method3515(0, i_62_, 0)) {
            bool_64_ = false;
         }

         if (i_60_ != -1 && !this.aClass86_1868.aClass302_1168.method3515(0, i_60_, 0)) {
            bool_64_ = false;
         }

         return bool_64_;
      }
   }

   private final String method1687(int i, int i_65_) {
      if (i != 22050) {
         this.method1693(null, (byte)39, null);
      }

      ++anInt1932;
      if (i_65_ < 100000) {
         return "<col=ffff00>" + i_65_ + "</col>";
      } else {
         return ~i_65_ > -10000001
            ? "<col=ffffff>" + i_65_ / 1000 + Class22.aClass22_399.getStoredString(this.aClass86_1868.anInt1161) + "</col>"
            : "<col=00ff80>" + i_65_ / 1000000 + Class22.aClass22_397.getStoredString(this.aClass86_1868.anInt1161) + "</col>";
      }
   }

   private final void method1688(int i, int[] is, int i_66_) {
      if (i_66_ != -7048) {
         this.unknownInt14 = -54;
      }

      for(int i_67_ = 31; ~i_67_ < -1; --i_67_) {
         int i_68_ = 36 * i_67_;

         for(int i_69_ = 35; i_69_ > 0; --i_69_) {
            if (~is[i_69_ - -i_68_] == -1 && is[i_68_ + i_69_ + -1 - 36] != 0) {
               is[i_69_ + i_68_] = i;
            }
         }
      }

      ++anInt1907;
   }

   final DrawableModel method1689(Animator animator, int i, PlayerDefinition playerdefinition, int i_70_, GraphicsToolkit graphicstoolkit, int i_71_) {
      ++anInt1906;
      if (this.stackIds != null && ~i_70_ < -2) {
         int i_72_ = -1;

         for(int i_73_ = 0; i_73_ < 10; ++i_73_) {
            if (~i_70_ <= ~this.stackAmounts[i_73_] && ~this.stackAmounts[i_73_] != -1) {
               i_72_ = this.stackIds[i_73_];
            }
         }

         if (i_72_ != -1) {
            return this.aClass86_1868.getItemDefinitionForId(i_72_).method1689(animator, i, playerdefinition, 1, graphicstoolkit, 87);
         }
      }

      int i_74_ = i;
      if (animator != null) {
         i_74_ = i | animator.method237((byte)-128);
      }

      DrawableModel drawablemodel;
      synchronized(this.aClass86_1868.aClass61_1176) {
         drawablemodel = (DrawableModel)this.aClass86_1868.aClass61_1176.method607((long)(this.anInt1914 | graphicstoolkit.anInt1537 << 29), 0);
      }

      if (i_71_ <= 64) {
         return null;
      } else {
         if (drawablemodel == null || ~graphicstoolkit.b(drawablemodel.ua(), i_74_) != -1) {
            if (drawablemodel != null) {
               i_74_ = graphicstoolkit.c(i_74_, drawablemodel.ua());
            }

            int i_75_ = i_74_;
            if (this.originalTextureColors != null) {
               i_75_ = i_74_ | 32768;
            }

            if (this.originalModelColors != null || playerdefinition != null) {
               i_75_ |= 16384;
            }

            if (~this.modelVerticesX != -129) {
               i_75_ |= 1;
            }

            if (~this.modelVerticesX != -129) {
               i_75_ |= 2;
            }

            if (this.modelVerticesX != 128) {
               i_75_ |= 4;
            }

            Model model = Renderer.method3448(this.modelId, 7, 0, this.aClass86_1868.aClass302_1168);
            if (model == null) {
               return null;
            }

            if (~model.anInt2614 > -14) {
               model.method2081(2, 0);
            }

            drawablemodel = graphicstoolkit.a(model, i_75_, this.aClass86_1868.anInt1181, 64 + this.modelLighting, 850 - -this.modelShadowing);
            if (~this.modelVerticesX != -129 || this.modelVerticesY != 128 || ~this.modelVerticesZ != -129) {
               drawablemodel.O(this.modelVerticesX, this.modelVerticesY, this.modelVerticesZ);
            }

            if (this.originalModelColors != null) {
               for(int i_76_ = 0; this.originalModelColors.length > i_76_; ++i_76_) {
                  if (this.recolourPallete != null && ~this.recolourPallete.length < ~i_76_) {
                     drawablemodel.ia(this.originalModelColors[i_76_], Class129.aShortArray1665[this.recolourPallete[i_76_] & 255]);
                  } else {
                     drawablemodel.ia(this.originalModelColors[i_76_], this.modifiedModelColors[i_76_]);
                  }
               }
            }

            if (this.originalTextureColors != null) {
               for(int i_77_ = 0; ~this.originalTextureColors.length < ~i_77_; ++i_77_) {
                  drawablemodel.aa(this.originalTextureColors[i_77_], this.modifiedTextureColors[i_77_]);
               }
            }

            if (playerdefinition != null) {
               for(int i_78_ = 0; ~i_78_ > -11; ++i_78_) {
                  for(int i_79_ = 0; ~Class45.aShortArrayArray5265[i_78_].length < ~i_79_; ++i_79_) {
                     if (~Class117_Sub2.aShortArrayArrayArray5151[i_78_][i_79_].length < ~playerdefinition.anIntArray3430[i_78_]) {
                        drawablemodel.ia(
                           Class45.aShortArrayArray5265[i_78_][i_79_],
                           Class117_Sub2.aShortArrayArrayArray5151[i_78_][i_79_][playerdefinition.anIntArray3430[i_78_]]
                        );
                     }
                  }
               }
            }

            drawablemodel.s(i_74_);
            synchronized(this.aClass86_1868.aClass61_1176) {
               this.aClass86_1868.aClass61_1176.method601(drawablemodel, 25566, (long)(this.anInt1914 | graphicstoolkit.anInt1537 << 29));
            }
         }

         if (animator != null) {
            drawablemodel = drawablemodel.method633((byte)1, i_74_, true);
            animator.method225(0, drawablemodel, 0);
         }

         drawablemodel.s(i);
         return drawablemodel;
      }
   }

   static final void method1690(byte b) {
      Class274.method3325(~Class213.aNode_Sub27_2512.aClass320_Sub17_7311.method3747(false) == -2, 122, 22050, 2);
      if (b <= -102) {
         ++anInt1903;
         AnimableAnimator.aClass42_5498 = Class262_Sub22.method3207(Class240.aSignLink2946, (byte)-27, 0, 22050, Node_Sub38_Sub20.GAME_CANVAS);
         AnimableAnimator_Sub1.method256(true, 1405, Class32.method359(null, -9293));
         Packet.aClass42_9402 = Class262_Sub22.method3207(Class240.aSignLink2946, (byte)-27, 1, 2048, Node_Sub38_Sub20.GAME_CANVAS);
         Class176.aNode_Sub9_Sub3_2106 = new Node_Sub9_Sub3();
         Packet.aClass42_9402.method441(11757, Class176.aNode_Sub9_Sub3_2106);
         Class361.aClass191_4486 = new Class191(22050, Class365.anInt4523);
         EntityNode_Sub7.method979(17285);
      }
   }

   final void method1691(byte b) {
      if (b <= 77) {
         this.showInGrandExchange = true;
      }

      ++anInt1910;
   }

   final boolean method1692(int i, TemporaryItemDefinition class38, boolean bool) {
      ++anInt1921;
      int i_80_;
      int i_81_;
      if (bool) {
         if (class38 != null && class38.anIntArray568 != null) {
            i_81_ = class38.anIntArray568[0];
            i_80_ = class38.anIntArray568[1];
         } else {
            i_81_ = this.femaleDialogueModel;
            i_80_ = this.femaleDialogueHat;
         }
      } else if (class38 != null && class38.anIntArray564 != null) {
         i_80_ = class38.anIntArray564[1];
         i_81_ = class38.anIntArray564[0];
      } else {
         i_80_ = this.maleDialogueHat;
         i_81_ = this.maleDialogueModel;
      }

      if (i_81_ == -1) {
         return true;
      } else {
         boolean bool_82_ = true;
         if (!this.aClass86_1868.aClass302_1168.method3515(i, i_81_, 0)) {
            bool_82_ = false;
         }

         if (~i_80_ != 0 && !this.aClass86_1868.aClass302_1168.method3515(0, i_80_, 0)) {
            bool_82_ = false;
         }

         return bool_82_;
      }
   }

   final void method1693(ItemDefinitions itemdefinition_83_, byte b, ItemDefinitions realItem) {
      this.value = 0;
      this.maleEquipModelId3 = realItem.maleEquipModelId3;
      this.stackable = realItem.stackable;
      this.membersOnly = realItem.membersOnly;
      this.recolourPallete = realItem.recolourPallete;
      this.modelOffset2 = itemdefinition_83_.modelOffset2;
      this.teamId = realItem.teamId;
      this.maleEquip2 = realItem.maleEquip2;
      this.inventoryOptions = new String[5];
      this.groundOptions = realItem.groundOptions;
      this.unknownInt13 = realItem.unknownInt13;
      this.maleDialogueModel = realItem.maleDialogueModel;
      this.unknownInt16 = realItem.unknownInt16;
      this.name = realItem.name;
      this.modelZoom = itemdefinition_83_.modelZoom;
      this.originalModelColors = realItem.originalModelColors;
      this.femaleDialogueHat = realItem.femaleDialogueHat;
      this.clientScriptData = realItem.clientScriptData;
      this.femaleEquip1 = realItem.femaleEquip1;
      ++anInt1929;
      this.modelRotation1 = itemdefinition_83_.modelRotation1;
      this.modelRotation2 = itemdefinition_83_.modelRotation2;
      this.unknownInt15 = realItem.unknownInt15;
      this.maleDialogueHat = realItem.maleDialogueHat;
      this.femaleEquipModelId3 = realItem.femaleEquipModelId3;
      this.modifiedTextureColors = realItem.modifiedTextureColors;
      this.unknownInt12 = realItem.unknownInt12;
      this.femaleDialogueModel = realItem.femaleDialogueModel;
      this.modelId = itemdefinition_83_.modelId;
      this.modifiedModelColors = realItem.modifiedModelColors;
      this.femaleEquip2 = realItem.femaleEquip2;
      this.modelOffset1 = itemdefinition_83_.modelOffset1;
      this.rotationZoom = itemdefinition_83_.rotationZoom;
      if (b > -104) {
         this.method1687(-128, -32);
      }

      this.maleEquip1 = realItem.maleEquip1;
      this.unknownInt17 = realItem.unknownInt17;
      this.unknownInt14 = realItem.unknownInt14;
      this.equipSlot = realItem.equipSlot;
      this.equipType = realItem.equipType;
      this.originalTextureColors = realItem.originalTextureColors;
      if (realItem.inventoryOptions != null) {
         for(int i = 0; i < 4; ++i) {
            this.inventoryOptions[i] = realItem.inventoryOptions[i];
         }
      }

      this.inventoryOptions[4] = Class22.aClass22_370.getStoredString(this.aClass86_1868.anInt1161);
   }

   public ItemDefinitions() {
      this.indexOfGroundOptionSprite2 = -1;
      this.maleEquip1 = -1;
      this.indexOfInventoryOptionSprite2 = -1;
      this.maleEquip2 = -1;
      this.rotationZoom = 0;
      this.lendTemplateId = -1;
      this.inventoryOptionSprite2 = -1;
      this.unknownValue2 = -1;
      this.maleEquipModelId3 = -1;
      this.modelLighting = 0;
      this.modelShadowing = 0;
      this.femaleDialogueModel = -1;
      this.modelZoom = 2000;
      this.unknownInt11 = -1;
      this.teamId = 0;
      this.membersOnly = false;
      this.modelVerticesY = 128;
      this.modelOffset1 = 0;
      this.name = "null";
      this.inventoryOptionSprite1 = -1;
      this.modelVerticesX = 128;
      this.maleDialogueHat = -1;
      this.femaleDialogueHat = -1;
      this.indexOfGroundOptionSprite1 = -1;
      this.unknownInt20 = -1;
      this.unknownInt21 = -1;
      this.modelRotation2 = 0;
      this.unknownInt14 = 0;
      this.groundOptionSprite1 = -1;
      this.indexOfInventoryOptionSprite1 = -1;
      this.unknownInt16 = 0;
      this.femaleEquip2 = -1;
      this.modelOffset2 = 0;
      this.unknownInt15 = 0;
      this.maleDialogueModel = -1;
      this.groundInteractRadius = 0;
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
      this.showInGrandExchange = true;
   }
}
