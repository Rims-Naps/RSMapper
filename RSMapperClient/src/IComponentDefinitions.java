public class IComponentDefinitions {
   public static final int CONTAINER = 0;
   public static final int RECTANGLE = 3;
   public static final int TEXT = 4;
   public static final int SPRITE = 5;
   public static final int MODEL = 6;
   public static final int LINE = 9;
   private static int skillCount = 24;
   protected int positionX;
   protected Object[] anObjectArray4680;
   protected int modelOffsetX;
   protected int modelRotationY;
   protected int anInt4683;
   static int anInt4684;
   static int anInt4685;
   protected String[] rightClickActions;
   protected int anInt4687;
   protected Object[] anObjectArray4688;
   protected boolean hidden;
   private short[] modifiedColors;
   protected int scrollMaxY;
   protected int parentId;
   protected int baseWidth;
   protected int anInt4694 = -1;
   protected int height;
   static int anInt4696;
   protected int anInt4697;
   protected int anInt4698;
   static IncommingPacket aClass192_4699 = new IncommingPacket(38, 0);
   protected int anInt4700;
   protected Object[] anObjectArray4701;
   static int anInt4702;
   protected int anInt4703;
   static int anInt4704;
   protected int[] anIntArray4705;
   protected Object[] anObjectArray4706;
   protected boolean isModelOrthographic;
   protected int anInt4708;
   protected int model3dAreaX = 0;
   protected boolean aBoolean4710;
   protected Object[] anObjectArray4711;
   protected Object[] anObjectArray4712;
   static int anInt4713;
   protected int anInt4714;
   static int anInt4715;
   static int anInt4716;
   private short[] modifiedTextures;
   protected int itemId;
   protected int anInt4719;
   protected byte aspectXType;
   protected boolean mirrored;
   protected int baseHeight;
   protected boolean aBoolean4723;
   protected int anInt4724;
   static int anInt4725 = 0;
   protected EntityNode_Sub4 anEntityNode_Sub4_4726;
   protected boolean renderThrough;
   protected int angle2D;
   static int anInt4729;
   protected boolean aBoolean4730;
   static int anInt4731;
   protected boolean vFlip;
   protected byte[] aByteArray4733;
   protected int scrollY;
   protected int scrollMaxX;
   static int anInt4736;
   static int anInt4737;
   protected boolean aBoolean4738;
   static int anInt4739;
   protected Object[] anObjectArray4740;
   protected byte aspectHeightType;
   protected Object[] anObjectArray4742;
   protected boolean hFlip;
   protected int anInt4744;
   protected Object[] anObjectArray4745;
   protected int anInt4746;
   protected int anInt4747;
   protected int anInt4748;
   static int anInt4749;
   protected byte aspectWidthType;
   protected Object[] anObjectArray4751;
   protected int anInt4752;
   protected Object[] anObjectArray4753;
   protected int color;
   protected Animator anAnimator4755;
   protected Object[] anObjectArray4756;
   protected int transparency;
   protected Object[] anObjectArray4758;
   protected int fontId;
   protected int anInt4760;
   protected int mouseOverCursor;
   protected int positionY;
   static int anInt4763;
   protected int anInt4764;
   protected String aString4765;
   static int anInt4766;
   protected int anInt4767;
   protected Object[] anObjectArray4768;
   protected boolean filled;
   protected Object[] anObjectArray4770;
   protected Object[] anObjectArray4771;
   protected int[] anIntArray4772;
   protected int animationId;
   protected Object[] anObjectArray4774;
   protected Object[] anObjectArray4775;
   static int anInt4776;
   protected Object[] anObjectArray4777;
   protected Object[] anObjectArray4778;
   protected String baseOption;
   protected int anInt4780;
   static int anInt4781;
   protected boolean aBoolean4782;
   protected int anInt4783;
   protected String aString4784;
   private short[] originalColors;
   protected String aString4786;
   protected int modelZoom;
   protected Object[] anObjectArray4788;
   protected int[] anIntArray4789;
   protected String text;
   static int anInt4791;
   protected int anInt4792;
   protected IComponentDefinitions[] aWidgetArray4793;
   protected int anInt4794;
   protected int anInt4795;
   protected int anInt4796;
   protected int model3dAreaY;
   protected Object[] anObjectArray4798;
   protected Object[] anObjectArray4799;
   protected int anInt4800;
   protected int anInt4801;
   protected boolean aBoolean4802;
   protected Object[] anObjectArray4803;
   protected IComponentDefinitions[] aWidgetArray4804;
   protected int[] anIntArray4805;
   protected byte[] aByteArray4806;
   protected Object[] anObjectArray4807;
   protected boolean hasScripts;
   protected int width;
   protected int anInt4810;
   protected int modelOffsetY;
   protected int[] anIntArray4812;
   protected int anInt4813;
   protected int anInt4814;
   protected int modelRotationX;
   protected int basePositionY;
   protected int scrollX;
   protected Object[] anObjectArray4818;
   protected boolean aBoolean4819;
   protected int spriteId;
   protected int modelRotationZ;
   protected int ihash;
   private HashTable aHashTable4823;
   protected int anInt4824;
   protected int textAlignY;
   protected int anInt4826;
   static HashTable aHashTable4827 = new HashTable(8);
   protected Object[] anObjectArray4828;
   protected int[] anIntArray4829;
   static int anInt4830;
   protected int itemAmount;
   protected boolean aBoolean4832;
   protected int[] anIntArray4833;
   protected Object[] popupScript;
   protected int textAlignX;
   protected IComponentDefinitions aWidget4836;
   private short[] originalTextures;
   protected int[] anIntArray4838;
   protected int anInt4839;
   protected InterfaceSettings aNode_Sub35_4840;
   protected int type;
   protected int modelRenderDistance;
   static int anInt4843;
   protected int modelType;
   static Class92 aClass92_4845;
   protected Object[] anObjectArray4846;
   static Class212 aClass212_4847 = new Class212("", 21);
   protected int anInt4848;
   protected int anInt4849;
   protected int basePositionX;
   protected byte aspectYType;
   protected Object[] anObjectArray4852;
   static int anInt4853;
   protected Object[] anObjectArray4854;
   static int anInt4855;
   protected Object[] anObjectArray4856;
   protected Object[] anObjectArray4857;
   protected boolean noClickThrough;
   static int anInt4859;
   protected int anInt4860;
   protected boolean repeatTiling;
   protected Object[] anObjectArray4862;
   protected int[] anIntArray4863;
   protected int modelId;
   protected boolean isCustomRenderDistance;
   protected boolean isFullNPCModel;
   protected int modelObjectType;

   final GLSprite method4135(boolean bool, GraphicsToolkit graphicstoolkit) {
      ++anInt4704;
      Class287.aBoolean3606 = false;
      long l = ((long)this.anInt4796 << 40)
         + ((!this.aBoolean4738 ? 0L : 1L) << 35)
         + (long)this.spriteId
         - (-((long)this.anInt4744 << 36) + -((this.vFlip ? 1L : 0L) << 38))
         - -((this.hFlip ? 1L : 0L) << 39);
      GLSprite glsprite = (GLSprite)Class252.aClass61_3190.method607(l, 0);
      if (glsprite != null) {
         return glsprite;
      } else {
         Class383 class383 = Class383.method4194(Class262_Sub10.aClass302_7776, this.spriteId, 0);
         if (class383 == null) {
            Class287.aBoolean3606 = true;
            return null;
         } else {
            if (this.vFlip) {
               class383.method4189();
            }

            if (this.hFlip) {
               class383.method4200();
            }

            if (this.anInt4744 > 0) {
               class383.method4192(this.anInt4744);
            } else if (~this.anInt4796 != -1) {
               class383.method4192(1);
            }

            if (~this.anInt4744 <= -2) {
               class383.method4197(1);
            }

            if (~this.anInt4744 <= -3) {
               class383.method4197(16777215);
            }

            if (this.anInt4796 != 0) {
               class383.method4193(this.anInt4796 | 0xFF000000);
            }

            glsprite = graphicstoolkit.a(class383, bool);
            Class252.aClass61_3190.method604(l, glsprite, glsprite.method1193() * glsprite.method1176() * 4, 98);
            return glsprite;
         }
      }
   }

   static GLSprite getSprite(int spriteId, boolean vFlip, boolean hFlip, boolean bool, GraphicsToolkit graphicstoolkit) {
      boolean abool = false;
      int anInt4744 = 0;
      int anInt4796 = 0;
      long l = ((long)anInt4796 << 40)
         + ((!abool ? 0L : 1L) << 35)
         + (long)spriteId
         - (-((long)anInt4744 << 36) + -((vFlip ? 1L : 0L) << 38))
         - -((hFlip ? 1L : 0L) << 39);
      GLSprite glsprite = (GLSprite)Class252.aClass61_3190.method607(l, 0);
      if (glsprite != null) {
         return glsprite;
      } else {
         Class383 class383 = Class383.method4194(Class262_Sub10.aClass302_7776, spriteId, 0);
         if (class383 == null) {
            Class287.aBoolean3606 = true;
            return null;
         } else {
            if (vFlip) {
               class383.method4189();
            }

            if (hFlip) {
               class383.method4200();
            }

            if (anInt4744 > 0) {
               class383.method4192(anInt4744);
            } else if (anInt4796 != 0) {
               class383.method4192(1);
            }

            if (anInt4744 >= 1) {
               class383.method4197(1);
            }

            if (anInt4744 >= 2) {
               class383.method4197(16777215);
            }

            if (anInt4796 != 0) {
               class383.method4193(anInt4796 | 0xFF000000);
            }

            glsprite = graphicstoolkit.a(class383, bool);
            Class252.aClass61_3190.method604(l, glsprite, glsprite.method1193() * glsprite.method1176() * 4, 98);
            return glsprite;
         }
      }
   }

   final void method4136(GraphicsToolkit graphicstoolkit, DrawableModel drawablemodel, int i, Class336 class336, int i_0_) {
      ++anInt4843;
      drawablemodel.method614(class336);
      Class300[] class300s = drawablemodel.method620();
      if (i <= 85) {
         this.method4135(false, null);
      }

      Class218[] class218s = drawablemodel.method618();
      if ((this.anEntityNode_Sub4_4726 == null || this.anEntityNode_Sub4_4726.aBoolean5972) && (class300s != null || class218s != null)) {
         this.anEntityNode_Sub4_4726 = EntityNode_Sub4.method963(i_0_, false);
      }

      if (this.anEntityNode_Sub4_4726 != null) {
         this.anEntityNode_Sub4_4726.method952(graphicstoolkit, (long)i_0_, class300s, class218s, false);
      }
   }

   final void method4137(int i, int i_1_, int i_2_) {
      ++anInt4684;
      if (this.aHashTable4823 == null) {
         this.aHashTable4823 = new HashTable(16);
         this.aHashTable4823.put((long)i, new Node_Sub32(i_2_), -127);
      } else {
         Node_Sub32 node_sub32 = (Node_Sub32)this.aHashTable4823.get(i_1_ + 3496, (long)i);
         if (node_sub32 != null) {
            node_sub32.anInt7381 = i_2_;
         } else {
            this.aHashTable4823.put((long)i, new Node_Sub32(i_2_), i_1_ ^ -111);
         }

         if (i_1_ != 16) {
            this.positionX = -101;
         }
      }
   }

   private final Object[] decodeScript(Buffer buffer) {
      int i = buffer.readUnsignedByte();
      if (~i == -1) {
         return null;
      } else {
         Object[] objects = new Object[i];

         for(int i_3_ = 0; i > i_3_; ++i_3_) {
            int i_4_ = buffer.readUnsignedByte();
            if (i_4_ == 0) {
               objects[i_3_] = new Integer(buffer.readInt());
            } else if (~i_4_ == -2) {
               objects[i_3_] = buffer.readString();
            }
         }

         this.hasScripts = true;
         return objects;
      }
   }

   static final void method4139(
      GraphicsToolkit graphicstoolkit,
      int i,
      int i_5_,
      int i_6_,
      int i_7_,
      int i_8_,
      CacheNode_Sub13 cachenode_sub13,
      int i_9_,
      int i_10_,
      int i_11_,
      int i_12_,
      int i_13_
   ) {
      if (i_13_ == -4392) {
         ++anInt4766;
         if (~i_11_ > ~i_12_ && ~(i + i_11_) < ~i_12_ && i_10_ > i_7_ + -13 && i_7_ - -3 > i_10_ && cachenode_sub13.aBoolean9571) {
            i_9_ = i_8_;
         }

         int[] is = null;
         if (!Class134.method1574(false, cachenode_sub13.anInt9562)) {
            if (cachenode_sub13.anInt9569 == -1) {
               if (!OutgoingPacket.method3666(cachenode_sub13.anInt9562, (byte)120)) {
                  if (Class194_Sub3.method1973(cachenode_sub13.anInt9562, 31922)) {
                     ObjectDefinition objectdefinition = Class186.aClass112_2256
                        .getObjectDefinitionsForId((int)(2147483647L & cachenode_sub13.lastClickedIndex >>> 32), i_13_ + 4491);
                     if (objectdefinition.anIntArray2984 != null) {
                        objectdefinition = objectdefinition.method3038(13, Class24.aClass275_442);
                     }

                     if (objectdefinition != null) {
                        is = objectdefinition.rightClickImages;
                     }
                  }
               } else {
                  Node_Sub41 node_sub41 = (Node_Sub41)Class12.aHashTable187.get(3512, (long)((int)cachenode_sub13.lastClickedIndex));
                  if (node_sub41 != null) {
                     Npc npc = node_sub41.aNpc7518;
                     NpcDefinition npcdefinition = npc.definitions;
                     if (npcdefinition.anIntArray2827 != null) {
                        npcdefinition = npcdefinition.method2999(65535, Class24.aClass275_442);
                     }

                     if (npcdefinition != null) {
                        is = npcdefinition.rightClickImages;
                     }
                  }
               }
            } else {
               is = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(cachenode_sub13.anInt9569).rightClickImages;
            }
         } else {
            is = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId((int)cachenode_sub13.lastClickedIndex).rightClickImages;
         }

         String string = Mobile.method844(cachenode_sub13, (byte)126);
         if (is != null) {
            string = string + Class43.method458(4923, is);
         }

         Class262_Sub4.aClass52_7721.method536(i_9_, 0, i_7_, string, -238946248, 3 + i_11_, Class105.aGLSpriteArray5194, Class290_Sub6.anIntArray8123);
         if (cachenode_sub13.aBoolean9572) {
            Class274.aGLSprite4981.method1196(i_11_ + 5 + Class262_Sub15_Sub1.aClass357_10524.method4033((byte)-6, string), i_7_ + -12);
         }
      }
   }

   final void setReplaceColors(short withColor, int index, short replaceColor) {
      ++anInt4855;
      if (index < 5) {
         if (this.originalColors == null) {
            this.modifiedColors = new short[5];
            this.originalColors = new short[5];
         }

         this.originalColors[index] = replaceColor;
         this.modifiedColors[index] = withColor;
      }
   }

   final void setReplaceTextures(short replaceTexture, int index, short withTexture) {
      ++anInt4781;
      if (index < 5) {
         if (this.originalTextures == null) {
            this.modifiedTextures = new short[5];
            this.originalTextures = new short[5];
         }

         this.originalTextures[index] = replaceTexture;
         this.modifiedTextures[index] = withTexture;
      }
   }

   final String method4141(String string, int i, int i_16_) {
      ++anInt4702;
      if (this.aHashTable4823 == null) {
         return string;
      } else {
         Node_Sub18 node_sub18 = (Node_Sub18)this.aHashTable4823.get(3512, (long)i);
         if (i_16_ < 43) {
            this.baseWidth = -75;
         }

         return node_sub18 == null ? string : node_sub18.aString7149;
      }
   }

   final void decode(Buffer stream) {
      int newInt = stream.readUnsignedByte();
      if (newInt == 255) {
         newInt = -1;
      }

      this.type = stream.readUnsignedByte();
      if (~(this.type & 128) != -1) {
         this.type &= 127;
         this.aString4765 = stream.readString();
      }

      this.anInt4814 = stream.readUnsignedShort();
      this.basePositionX = stream.readShort();
      this.basePositionY = stream.readShort();
      this.baseWidth = stream.readUnsignedShort();
      this.baseHeight = stream.readUnsignedShort();
      this.aspectWidthType = stream.readByte();
      this.aspectHeightType = stream.readByte();
      this.aspectXType = stream.readByte();
      this.aspectYType = stream.readByte();
      this.parentId = stream.readUnsignedShort();
      if (this.parentId != 65535) {
         this.parentId += this.ihash & -65536;
      } else {
         this.parentId = -1;
      }

      int i_17_ = stream.readUnsignedByte();
      this.hidden = ~(1 & i_17_) != -1;
      if (newInt >= 0) {
         this.noClickThrough = (i_17_ & 2) != 0;
      }

      if (this.type == 0) {
         this.scrollMaxX = stream.readUnsignedShort();
         this.scrollMaxY = stream.readUnsignedShort();
         if (~newInt > -1) {
            this.noClickThrough = stream.readUnsignedByte() == 1;
         }
      }

      if (this.type == 5) {
         this.spriteId = stream.readInt();
         this.angle2D = stream.readUnsignedShort();
         int i_18_ = stream.readUnsignedByte();
         this.repeatTiling = ~(i_18_ & 1) != -1;
         this.aBoolean4738 = (i_18_ & 2) != 0;
         this.transparency = stream.readUnsignedByte();
         this.anInt4744 = stream.readUnsignedByte();
         this.anInt4796 = stream.readInt();
         this.vFlip = stream.readUnsignedByte() == 1;
         this.hFlip = stream.readUnsignedByte() == 1;
         this.color = stream.readInt();
         if (~newInt <= -4) {
            this.aBoolean4782 = ~stream.readUnsignedByte() == -2;
         }
      }

      if (this.type == 6) {
         this.modelType = 1;
         if (RSMapperClient.newInterface(this.ihash >> 16)) {
            this.modelId = stream.readBigSmart();
         } else {
            this.modelId = stream.readUnsignedShort();
            if (this.modelId == 65535) {
               this.modelId = -1;
            }
         }

         int modelFlag = stream.readUnsignedByte();
         this.isModelOrthographic = (4 & modelFlag) == 4;
         boolean regularRendering = (1 & modelFlag) == 1;
         this.isCustomRenderDistance = (modelFlag & 2) == 2;
         this.renderThrough = (8 & modelFlag) == 8;
         if (regularRendering) {
            this.model3dAreaX = stream.readShort();
            this.model3dAreaY = stream.readShort();
            this.modelRotationX = stream.readUnsignedShort();
            this.modelRotationZ = stream.readUnsignedShort();
            this.modelRotationY = stream.readUnsignedShort();
            this.modelZoom = stream.readUnsignedShort();
         } else if (this.isCustomRenderDistance) {
            this.model3dAreaX = stream.readShort();
            this.model3dAreaY = stream.readShort();
            this.modelRenderDistance = stream.readShort();
            this.modelRotationX = stream.readUnsignedShort();
            this.modelRotationZ = stream.readUnsignedShort();
            this.modelRotationY = stream.readUnsignedShort();
            this.modelZoom = stream.readShort();
         }

         if (RSMapperClient.newInterface(this.ihash >> 16)) {
            this.animationId = stream.readBigSmart();
         } else {
            this.animationId = stream.readUnsignedShort();
            if (this.animationId == 65535) {
               this.animationId = -1;
            }
         }

         if (this.aspectWidthType != 0) {
            this.anInt4800 = stream.readUnsignedShort();
         }

         if (~this.aspectHeightType != -1) {
            this.anInt4849 = stream.readUnsignedShort();
         }
      }

      if (this.type == 4) {
         if (RSMapperClient.newInterface(this.ihash >> 16)) {
            this.fontId = stream.readBigSmart();
         } else {
            this.fontId = stream.readUnsignedShort();
            if (~this.fontId == -65536) {
               this.fontId = -1;
            }
         }

         if (newInt >= 2) {
            this.aBoolean4832 = stream.readUnsignedByte() == 1;
         }

         this.text = stream.readString();
         if (this.text.toLowerCase().contains("runescape")) {
            this.text = this.text.replace("RuneScape", "Map Editor").replace("runescape", "Map Editor").replace("Runescape", "Map Editor");
         }

         this.anInt4697 = stream.readUnsignedByte();
         this.textAlignX = stream.readUnsignedByte();
         this.textAlignY = stream.readUnsignedByte();
         this.aBoolean4710 = stream.readUnsignedByte() == 1;
         this.color = stream.readInt();
         this.transparency = stream.readUnsignedByte();
         if (~newInt <= -1) {
            this.anInt4767 = stream.readUnsignedByte();
         }
      }

      if (this.type == 3) {
         this.color = stream.readInt();
         this.filled = stream.readUnsignedByte() == 1;
         this.transparency = stream.readUnsignedByte();
      }

      if (this.type == 9) {
         this.anInt4752 = stream.readUnsignedByte();
         this.color = stream.readInt();
         this.mirrored = stream.readUnsignedByte() == 1;
      }

      int i_20_ = stream.read24BitInteger();
      int i_21_ = stream.readUnsignedByte();
      if (~i_21_ != -1) {
         this.aByteArray4806 = new byte[11];
         this.aByteArray4733 = new byte[11];

         for(this.anIntArray4705 = new int[11]; i_21_ != 0; i_21_ = stream.readUnsignedByte()) {
            int i_22_ = (i_21_ >> 4) - 1;
            i_21_ = stream.readUnsignedByte() | i_21_ << 8;
            i_21_ &= 4095;
            if (i_21_ == 4095) {
               i_21_ = -1;
            }

            byte b_23_ = stream.readByte();
            if (~b_23_ != -1) {
               this.aBoolean4802 = true;
            }

            byte b_24_ = stream.readByte();
            this.anIntArray4705[i_22_] = i_21_;
            this.aByteArray4806[i_22_] = b_23_;
            this.aByteArray4733[i_22_] = b_24_;
         }
      }

      this.baseOption = stream.readString();
      int i_25_ = stream.readUnsignedByte();
      int actionCount = 15 & i_25_;
      if (actionCount > 0) {
         this.rightClickActions = new String[actionCount];

         for(int idx = 0; idx < actionCount; ++idx) {
            if (skillCount < 0) {
               skillCount = 24;
            }

            this.rightClickActions[idx] = stream.readString();
            if (this.rightClickActions[idx].toLowerCase().contains("set level target")) {
               this.rightClickActions[idx] = "Say Levels";
            } else if (this.rightClickActions[idx].toLowerCase().contains("set xp target")) {
               this.rightClickActions[idx] = null;
            } else if (this.rightClickActions[idx].toLowerCase().contains("clear target")) {
               this.rightClickActions[idx] = "Reset Experience";
               --skillCount;
            }
         }
      }

      int i_28_ = i_25_ >> 4;
      if (~i_28_ < -1) {
         int i_29_ = stream.readUnsignedByte();
         this.anIntArray4863 = new int[i_29_ - -1];

         for(int i_30_ = 0; ~i_30_ > ~this.anIntArray4863.length; ++i_30_) {
            this.anIntArray4863[i_30_] = -1;
         }

         this.anIntArray4863[i_29_] = stream.readUnsignedShort();
      }

      if (~i_28_ < -2) {
         int i_31_ = stream.readUnsignedByte();
         this.anIntArray4863[i_31_] = stream.readUnsignedShort();
      }

      this.aString4784 = stream.readString();
      if (this.aString4784.equals("")) {
         this.aString4784 = null;
      }

      this.anInt4708 = stream.readUnsignedByte();
      this.anInt4795 = stream.readUnsignedByte();
      this.anInt4860 = stream.readUnsignedByte();
      this.aString4786 = stream.readString();
      int i_32_ = -1;
      if (~Animable_Sub4.method925(i_20_, 34933) != -1) {
         i_32_ = stream.readUnsignedShort();
         if (i_32_ == 65535) {
            i_32_ = -1;
         }

         this.anInt4698 = stream.readUnsignedShort();
         if (~this.anInt4698 == -65536) {
            this.anInt4698 = -1;
         }

         this.anInt4839 = stream.readUnsignedShort();
         if (this.anInt4839 == 65535) {
            this.anInt4839 = -1;
         }
      }

      if (newInt >= 0) {
         this.mouseOverCursor = stream.readUnsignedShort();
         if (this.mouseOverCursor == 65535) {
            this.mouseOverCursor = -1;
         }
      }

      this.aNode_Sub35_4840 = new InterfaceSettings(i_20_, i_32_);
      if (newInt >= 0) {
         int i_33_ = stream.readUnsignedByte();

         for(int i_34_ = 0; i_33_ > i_34_; ++i_34_) {
            int i_35_ = stream.read24BitInteger();
            int i_36_ = stream.readInt();
            this.aHashTable4823.put((long)i_35_, new Node_Sub32(i_36_), -128);
         }

         int i_37_ = stream.readUnsignedByte();

         for(int i_38_ = 0; i_38_ < i_37_; ++i_38_) {
            int i_39_ = stream.read24BitInteger();
            String string = stream.method2180((byte)92);
            this.aHashTable4823.put((long)i_39_, new Node_Sub18(string), -124);
         }
      }

      this.anObjectArray4758 = this.decodeScript(stream);
      this.anObjectArray4706 = this.decodeScript(stream);
      this.anObjectArray4818 = this.decodeScript(stream);
      this.anObjectArray4771 = this.decodeScript(stream);
      this.anObjectArray4768 = this.decodeScript(stream);
      this.anObjectArray4807 = this.decodeScript(stream);
      this.anObjectArray4742 = this.decodeScript(stream);
      this.anObjectArray4788 = this.decodeScript(stream);
      this.anObjectArray4701 = this.decodeScript(stream);
      this.anObjectArray4770 = this.decodeScript(stream);
      if (~newInt <= -1) {
         this.anObjectArray4751 = this.decodeScript(stream);
      }

      this.popupScript = this.decodeScript(stream);
      this.anObjectArray4774 = this.decodeScript(stream);
      this.anObjectArray4803 = this.decodeScript(stream);
      this.anObjectArray4680 = this.decodeScript(stream);
      this.anObjectArray4856 = this.decodeScript(stream);
      this.anObjectArray4852 = this.decodeScript(stream);
      this.anObjectArray4711 = this.decodeScript(stream);
      this.anObjectArray4753 = this.decodeScript(stream);
      this.anObjectArray4688 = this.decodeScript(stream);
      this.anObjectArray4775 = this.decodeScript(stream);
      this.anIntArray4838 = this.method4150(stream);
      this.anIntArray4833 = this.method4150(stream);
      this.anIntArray4789 = this.method4150(stream);
      this.anIntArray4829 = this.method4150(stream);
      this.anIntArray4805 = this.method4150(stream);
   }

   final void setRightClickOption(String option, int slot) {
      if (this.rightClickActions == null || slot >= this.rightClickActions.length) {
         String[] strings = new String[slot + 1];
         if (this.rightClickActions != null) {
            for(int i_42_ = 0; i_42_ < this.rightClickActions.length; ++i_42_) {
               strings[i_42_] = this.rightClickActions[i_42_];
            }
         }

         this.rightClickActions = strings;
      }

      ++anInt4731;
      this.rightClickActions[slot] = option;
   }

   static final void method4144(int i) {
      ++anInt4736;

      try {
         if (i != 0) {
            method4144(-46);
         }

         if (Class52.anInt800 == 1) {
            int i_43_ = Class307.aNode_Sub9_Sub1_3902.method2471(15);
            if (i_43_ > 0 && Class307.aNode_Sub9_Sub1_3902.method2445((byte)-116)) {
               i_43_ -= Class107.anInt1362;
               if (i_43_ < 0) {
                  i_43_ = 0;
               }

               Class307.aNode_Sub9_Sub1_3902.method2439(i ^ -12651, i_43_);
               return;
            }

            Class307.aNode_Sub9_Sub1_3902.method2435(false);
            Class307.aNode_Sub9_Sub1_3902.method2450((byte)117);
            Class10.aClass96_176 = null;
            Player.aNode_Sub4_11155 = null;
            if (Class93_Sub2.aClass302_6049 == null) {
               Class52.anInt800 = 0;
            } else {
               Class52.anInt800 = 2;
            }
         }

         if (~Class52.anInt800 == -4) {
            int i_44_ = Class307.aNode_Sub9_Sub1_3902.method2471(i + 15);
            if (i_44_ < Class17.anInt282 && Class307.aNode_Sub9_Sub1_3902.method2445((byte)-84)) {
               i_44_ += Class339_Sub8.anInt8733;
               if (~i_44_ < ~Class17.anInt282) {
                  i_44_ = Class17.anInt282;
               }

               Class307.aNode_Sub9_Sub1_3902.method2439(-12651, i_44_);
            } else {
               Class339_Sub8.anInt8733 = 0;
               Class52.anInt800 = 0;
            }
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         Class307.aNode_Sub9_Sub1_3902.method2435(false);
         Class61.aNode_Sub9_Sub1_885 = null;
         Player.aNode_Sub4_11155 = null;
         Class52.anInt800 = 0;
         Class93_Sub2.aClass302_6049 = null;
         Class10.aClass96_176 = null;
      }
   }

   final Class127 method4145(GraphicsToolkit graphicstoolkit, int i) {
      ++anInt4696;
      long l = 4294967295L & (long)this.anInt4687 | (long)this.ihash << 32;
      Class127 class127 = (Class127)Class243.aClass61_3065.method607(l, 0);
      if (class127 != null) {
         if (~class127.anInt1645 != ~this.spriteId) {
            class127 = null;
            Class243.aClass61_3065.method605(l, i ^ -13067);
         }

         if (class127 != null) {
            return class127;
         }
      }

      Class383 class383 = Class383.method4194(Class262_Sub10.aClass302_7776, this.spriteId, 0);
      if (class383 == null) {
         return null;
      } else {
         if (i != 1) {
            this.method4149(52, -3, false);
         }

         int i_45_ = class383.anInt4902 + class383.anInt4897 + class383.anInt4901;
         int i_46_ = class383.anInt4900 + class383.anInt4898 + class383.anInt4899;
         int[] is = new int[i_46_];
         int[] is_47_ = new int[i_46_];

         for(int i_48_ = 0; class383.anInt4900 > i_48_; ++i_48_) {
            int i_49_ = 0;

            for(int i_50_ = 0; class383.anInt4897 > i_50_; ++i_50_) {
               if (class383.aByteArray4903[i_50_ + class383.anInt4897 * i_48_] != 0) {
                  i_49_ = i_50_;
                  break;
               }
            }

            int i_51_ = class383.anInt4897;

            for(int i_52_ = class383.anInt4897 - 1; i_49_ <= i_52_; --i_52_) {
               if (class383.aByteArray4903[i_52_ + class383.anInt4897 * i_48_] != 0) {
                  i_51_ = i_52_ - -1;
                  break;
               }
            }

            is[class383.anInt4898 + i_48_] = class383.anInt4902 + i_49_;
            is_47_[class383.anInt4898 + i_48_] = -i_49_ + i_51_;
         }

         aa var_aa = graphicstoolkit.a(i_45_, i_46_, is, is_47_);
         if (var_aa == null) {
            return null;
         } else {
            class127 = new Class127(i_45_, i_46_, is_47_, is, var_aa, this.spriteId);
            Class243.aClass61_3065.method601(class127, 25566, l);
            return class127;
         }
      }
   }

   public static void method4146(byte b) {
      aClass192_4699 = null;
      aClass212_4847 = null;
      aHashTable4827 = null;
      aClass92_4845 = null;
   }

   static final String method4147(String string, boolean bool, String string_53_, String string_54_) {
      ++anInt4737;
      if (bool) {
         return null;
      } else {
         for(int i = string.indexOf(string_53_); ~i != 0; i = string.indexOf(string_53_, i - -string_54_.length())) {
            string = string.substring(0, i) + string_54_ + string.substring(string_53_.length() + i);
         }

         return string;
      }
   }

   final void method4148(String string, int i, int i_55_) {
      ++anInt4749;
      if (this.aHashTable4823 == null) {
         this.aHashTable4823 = new HashTable(16);
         this.aHashTable4823.put((long)i, new Node_Sub18(string), -125);
      } else {
         Node_Sub18 node_sub18 = (Node_Sub18)this.aHashTable4823.get(3512, (long)i);
         if (node_sub18 != null) {
            node_sub18.aString7149 = string;
         } else {
            this.aHashTable4823.put((long)i, new Node_Sub18(string), -124);
         }
      }
   }

   final void method4149(int i, int i_57_, boolean bool) {
      if (!bool) {
         this.method4149(42, 8, true);
      }

      ++anInt4715;
      if (this.anIntArray4863 == null || ~i <= ~this.anIntArray4863.length) {
         int[] is = new int[i - -1];
         if (this.anIntArray4863 != null) {
            for(int i_58_ = 0; this.anIntArray4863.length > i_58_; ++i_58_) {
               is[i_58_] = this.anIntArray4863[i_58_];
            }

            for(int i_59_ = this.anIntArray4863.length; ~i < ~i_59_; ++i_59_) {
               is[i_59_] = -1;
            }
         }

         this.anIntArray4863 = is;
      }

      this.anIntArray4863[i] = i_57_;
   }

   private final int[] method4150(Buffer buffer) {
      int i = buffer.readUnsignedByte();
      if (i == 0) {
         return null;
      } else {
         int[] is = new int[i];

         for(int i_60_ = 0; i_60_ < i; ++i_60_) {
            is[i_60_] = buffer.readInt();
         }

         return is;
      }
   }

   final void method4151(int i) {
      this.anObjectArray4751 = null;
      this.anObjectArray4778 = null;
      this.anObjectArray4711 = null;
      this.anObjectArray4680 = null;
      this.anIntArray4833 = null;
      this.anObjectArray4768 = null;
      this.anIntArray4829 = null;
      this.anObjectArray4774 = null;
      this.anIntArray4838 = null;
      this.anObjectArray4688 = null;
      this.anObjectArray4852 = null;
      this.anObjectArray4777 = null;
      this.anObjectArray4753 = null;
      this.anIntArray4805 = null;
      this.anObjectArray4770 = null;
      this.anObjectArray4771 = null;
      this.anObjectArray4799 = null;
      this.anObjectArray4828 = null;
      this.anObjectArray4742 = null;
      this.anObjectArray4854 = null;
      this.anObjectArray4856 = null;
      this.anObjectArray4818 = null;
      this.anObjectArray4706 = null;
      this.anObjectArray4807 = null;
      this.anIntArray4789 = null;
      this.anObjectArray4758 = null;
      if (i > -98) {
         method4146((byte)87);
      }

      this.anObjectArray4745 = null;
      this.anObjectArray4798 = null;
      this.anObjectArray4712 = null;
      this.anObjectArray4846 = null;
      this.anObjectArray4803 = null;
      this.anObjectArray4701 = null;
      this.anObjectArray4740 = null;
      this.anObjectArray4788 = null;
      ++anInt4776;
      this.anObjectArray4862 = null;
      this.anObjectArray4775 = null;
      this.popupScript = null;
   }

   static final boolean method4152(int i) {
      ++anInt4791;
      Node_Sub53 node_sub53 = (Node_Sub53)CacheNode_Sub16.aClass312_9600.method3613(65280);
      if (node_sub53 == null) {
         return false;
      } else if (i != 1869940680) {
         return false;
      } else {
         for(int i_61_ = 0; ~node_sub53.anInt7658 < ~i_61_; ++i_61_) {
            if (node_sub53.aClass241Array7657[i_61_] != null && ~node_sub53.aClass241Array7657[i_61_].anInt2953 == -1) {
               return false;
            }

            if (node_sub53.aClass241Array7664[i_61_] != null && node_sub53.aClass241Array7664[i_61_].anInt2953 == 0) {
               return false;
            }
         }

         return true;
      }
   }

   final DrawableModel method4153(
      GraphicsToolkit graphicstoolkit,
      Animator animator,
      Class281 class281,
      Class181 class181,
      Class37 class37,
      PlayerDefinition playerdefinition,
      Interface17 interface17,
      Class279 class279,
      Class86 class86,
      int i,
      Class361 class361
   ) {
      Class287.aBoolean3606 = false;
      ++anInt4830;
      if (this.modelType == 0) {
         return null;
      } else if (this.modelType == 1 && this.modelId == -1) {
         return null;
      } else if (this.modelType == 1) {
         int i_62_ = i;
         if (animator != null) {
            i |= animator.method237((byte)-128);
         }

         long l = -1L;
         long[] ls = CacheNode_Sub20.aLongArray9626;
         if (this.originalColors != null) {
            for(int i_63_ = 0; ~i_63_ > ~this.originalColors.length; ++i_63_) {
               l = l >>> 8 ^ ls[(int)(((long)(this.originalColors[i_63_] >> 8) ^ l) & 255L)];
               l = l >>> 8 ^ ls[(int)(255L & ((long)this.originalColors[i_63_] ^ l))];
               l = ls[(int)(255L & ((long)(this.modifiedColors[i_63_] >> 8) ^ l))] ^ l >>> 8;
               l = ls[(int)(((long)this.modifiedColors[i_63_] ^ l) & 255L)] ^ l >>> 8;
            }

            i |= 16384;
         }

         if (this.originalTextures != null) {
            for(int i_64_ = 0; ~i_64_ > ~this.originalTextures.length; ++i_64_) {
               l = ls[(int)(255L & ((long)(this.originalTextures[i_64_] >> 8) ^ l))] ^ l >>> 8;
               l = ls[(int)(((long)this.originalTextures[i_64_] ^ l) & 255L)] ^ l >>> 8;
               l = l >>> 8 ^ ls[(int)(((long)(this.modifiedTextures[i_64_] >> 8) ^ l) & 255L)];
               l = l >>> 8 ^ ls[(int)(((long)this.modifiedTextures[i_64_] ^ l) & 255L)];
            }

            i |= 32768;
         }

         long l_65_ = l & 274877906943L | (long)this.modelId << 38 | (long)this.modelType << 54 | (long)graphicstoolkit.anInt1537 << 59;
         DrawableModel drawablemodel = (DrawableModel)Class166.aClass61_5097.method607(l_65_, 0);
         if (drawablemodel == null || graphicstoolkit.b(drawablemodel.ua(), i) != 0) {
            if (drawablemodel != null) {
               i = graphicstoolkit.c(i, drawablemodel.ua());
            }

            Model model = Renderer.method3448(this.modelId, 7, 0, GLXToolkit.aClass302_9274);
            if (model == null) {
               Class287.aBoolean3606 = true;
               return null;
            }

            if (model.anInt2614 > 13) {
               model.method2081(2, 0);
            }

            drawablemodel = graphicstoolkit.a(model, i, Node_Sub15_Sub3.anInt9787, 64, 768);
            if (this.originalColors != null) {
               for(int i_66_ = 0; ~this.originalColors.length < ~i_66_; ++i_66_) {
                  drawablemodel.ia(this.originalColors[i_66_], this.modifiedColors[i_66_]);
               }
            }

            if (this.originalTextures != null) {
               for(int i_67_ = 0; i_67_ < this.originalTextures.length; ++i_67_) {
                  drawablemodel.aa(this.originalTextures[i_67_], this.modifiedTextures[i_67_]);
               }
            }

            Class166.aClass61_5097.method601(drawablemodel, 25566, l_65_);
         }

         if (animator != null) {
            drawablemodel = drawablemodel.method633((byte)1, i, true);
            animator.method225(0, drawablemodel, 0);
         }

         drawablemodel.s(i_62_);
         return drawablemodel;
      } else if (this.modelType == 2) {
         DrawableModel drawablemodel = class279.getNPCDefinitions(this.modelId, (byte)107)
            .prepareModelToInterface(i, animator, class361, 412761072, graphicstoolkit, interface17);
         if (drawablemodel == null) {
            Class287.aBoolean3606 = true;
            return null;
         } else {
            return drawablemodel;
         }
      } else if (this.modelType == 3) {
         if (playerdefinition == null) {
            return null;
         } else {
            DrawableModel drawablemodel = playerdefinition.prepareModelToInterface(
               class181, (byte)-82, class37, interface17, animator, class86, class279, graphicstoolkit, i
            );
            if (drawablemodel == null) {
               Class287.aBoolean3606 = true;
               return null;
            } else {
               return drawablemodel;
            }
         }
      } else if (this.modelType == 4) {
         ItemDefinitions itemdefinition = class86.getItemDefinitionForId(this.modelId);
         DrawableModel drawablemodel = itemdefinition.method1689(animator, i, playerdefinition, 10, graphicstoolkit, 75);
         if (drawablemodel == null) {
            Class287.aBoolean3606 = true;
            return null;
         } else {
            return drawablemodel;
         }
      } else if (this.modelType == 6) {
         DrawableModel drawablemodel = class279.getNPCDefinitions(this.modelId, (byte)107)
            .prepareModel(interface17, graphicstoolkit, class281, (byte)50, animator, 0, null, class361, null, i, null);
         if (drawablemodel == null) {
            Class287.aBoolean3606 = true;
            return null;
         } else {
            return drawablemodel;
         }
      } else if (this.modelType == 7) {
         if (playerdefinition == null) {
            return null;
         } else {
            int i_68_ = this.modelId >>> 16;
            int i_69_ = this.modelId & 65535;
            int i_70_ = this.anInt4683;
            DrawableModel drawablemodel = playerdefinition.method3283(animator, i_68_, i_70_, class37, graphicstoolkit, (byte)125, class181, i_69_, i);
            if (drawablemodel == null) {
               Class287.aBoolean3606 = true;
               return null;
            } else {
               return drawablemodel;
            }
         }
      } else {
         return null;
      }
   }

   final void method4154(int i, int i_71_) {
      if (i_71_ == 5) {
         if (this.aHashTable4823 != null) {
            Node node = this.aHashTable4823.get(3512, (long)i);
            if (node != null) {
               node.method2160((byte)120);
            }
         }

         ++anInt4713;
      }
   }

   final Class52 method4155(boolean bool, GraphicsToolkit graphicstoolkit) {
      if (!bool) {
         return null;
      } else {
         ++anInt4685;
         Class52 class52 = Class171.method1792(this.aBoolean4832, false, this.fontId, -99, graphicstoolkit);
         Class287.aBoolean3606 = class52 == null;
         return class52;
      }
   }

   final int method4156(int i, int i_72_, int i_73_) {
      ++anInt4763;
      if (this.aHashTable4823 == null) {
         return i;
      } else {
         Node_Sub32 node_sub32 = (Node_Sub32)this.aHashTable4823.get(3512, (long)i_73_);
         if (i_72_ != 18131) {
            this.anIntArray4863 = null;
         }

         return node_sub32 == null ? i : node_sub32.anInt7381;
      }
   }

   final Class119 method4157(int i, Class57 class57, Class278 class278) {
      ++anInt4729;
      if (this.anInt4848 == -1) {
         return null;
      } else if (i != -49253408) {
         return null;
      } else {
         long l = 65535L & (long)this.anInt4848
            | (65535L & (long)this.anInt4760) << 16
            | ((long)this.anInt4724 & 65535L) << 48
            | 281470681743360L & (long)this.anInt4794 << 32;
         Class119 class119 = (Class119)NpcDefinition.aClass61_2805.method607(l, 0);
         if (class119 == null) {
            class119 = class278.method3366(class57, this.anInt4760, this.anInt4848, this.anInt4794, this.anInt4724, true);
            NpcDefinition.aClass61_2805.method601(class119, 25566, l);
         }

         return class119;
      }
   }

   public IComponentDefinitions() {
      this.anInt4698 = -1;
      this.aBoolean4730 = false;
      this.anInt4747 = 0;
      this.isModelOrthographic = false;
      this.modelRotationY = 0;
      this.anInt4752 = 1;
      this.angle2D = 0;
      this.fontId = -1;
      this.renderThrough = false;
      this.filled = false;
      this.baseWidth = 0;
      this.anInt4767 = 0;
      this.aspectWidthType = 0;
      this.positionX = 0;
      this.mouseOverCursor = -1;
      this.baseOption = "";
      this.aspectHeightType = 0;
      this.anInt4780 = 0;
      this.aBoolean4782 = true;
      this.transparency = 0;
      this.color = 0;
      this.anInt4687 = -1;
      this.anInt4783 = -1;
      this.animationId = -1;
      this.anInt4795 = 0;
      this.anInt4796 = 0;
      this.modelOffsetX = 0;
      this.anInt4714 = 2;
      this.aBoolean4802 = false;
      this.hasScripts = false;
      this.anInt4744 = 0;
      this.aString4786 = "";
      this.anInt4700 = 1;
      this.anInt4697 = 0;
      this.aBoolean4819 = false;
      this.ihash = -1;
      this.modelRotationZ = 0;
      this.modelRotationX = 0;
      this.itemId = -1;
      this.spriteId = -1;
      this.mirrored = false;
      this.aspectXType = 0;
      this.scrollX = 0;
      this.anInt4708 = 0;
      this.anInt4810 = 0;
      this.modelZoom = 100;
      this.aBoolean4738 = false;
      this.scrollMaxY = 0;
      this.aBoolean4710 = false;
      this.textAlignY = 0;
      this.anInt4719 = 0;
      this.scrollY = 0;
      this.text = "";
      this.aBoolean4832 = true;
      this.positionY = 0;
      this.anInt4792 = 1;
      this.scrollMaxX = 0;
      this.itemAmount = 0;
      this.anInt4800 = 0;
      this.anInt4748 = -1;
      this.width = 0;
      this.textAlignX = 0;
      this.height = 0;
      this.anInt4813 = 0;
      this.modelType = 1;
      this.aNode_Sub35_4840 = Animable_Sub1_Sub1.aNode_Sub35_10613;
      this.anInt4814 = 0;
      this.modelOffsetY = 0;
      this.baseHeight = 0;
      this.anInt4849 = 0;
      this.anInt4683 = -1;
      this.parentId = -1;
      this.anInt4801 = 0;
      this.anInt4824 = -1;
      this.aWidget4836 = null;
      this.anInt4703 = -1;
      this.noClickThrough = false;
      this.hidden = false;
      this.basePositionX = 0;
      this.repeatTiling = false;
      this.anInt4848 = -1;
      this.model3dAreaY = 0;
      this.anInt4860 = Class339_Sub4.anInt8679;
      this.aBoolean4723 = false;
      this.aspectYType = 0;
      this.basePositionY = 0;
      this.modelRenderDistance = 0;
      this.anInt4839 = -1;
      this.isFullNPCModel = false;
      this.modelObjectType = 0;
   }
}
