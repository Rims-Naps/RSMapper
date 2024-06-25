public class Player extends Actor {
   static int[][] anIntArrayArray11128;
   protected int skullId = -1;
   protected int prayIconId;
   protected boolean isHidden;
   protected String displayName;
   static int anInt11133;
   protected int anInt11134;
   protected boolean aBoolean11135;
   static int anInt11136;
   protected PlayerDefinition aPlayerDefinition11137;
   static int anInt11138;
   protected int anInt11139;
   static Node_Sub4 aNode_Sub4_11140 = null;
   protected int combatLevelWithSummoning;
   protected String aString11142;
   static int anInt11143;
   static int anInt11144;
   private byte aByte11145;
   static int anInt11146;
   protected int anInt11147;
   static int anInt11148;
   protected boolean hasDisplayName;
   private byte genderId = 0;
   private int renderEmoteId;
   protected int combatLevel;
   protected int anInt11153;
   private byte titleId;
   private String titleString;
   static Node_Sub4 aNode_Sub4_11155;
   protected boolean aBoolean11156;
   protected boolean aBoolean11157;
   static int anInt11158;
   static int anInt11159;
   protected int anInt11160;
   static int anInt11161;
   static int anInt11162;
   static int anInt11163;
   protected int anInt11164;
   static int anInt11165;
   static int anInt11166;
   protected int anInt11167;
   static int anInt11168;
   protected boolean aBoolean11169;
   static int anInt11170;
   static int anInt11171;
   protected int anInt11172;
   protected int anInt11173;
   static int anInt11174;
   static int anInt11175;
   static int anInt11176;
   static int anInt11177;
   static int regionX;
   static int anInt11179;
   protected int anInt11180;
   static int anInt11181;
   protected int anInt11182;
   static int anInt11183;
   protected int anInt11184;

   @Override
   final void method820(GraphicsToolkit graphicstoolkit, int i) {
      ++anInt11158;
      if (this.aPlayerDefinition11137 != null && (this.aBoolean10906 || this.method890(0, -119, graphicstoolkit))) {
         Class336 class336 = graphicstoolkit.A();
         class336.method3860(this.aClass99_10893.method1086(i ^ -16380));
         class336.method3863(this.x, i + this.anInt5937, this.y);
         this.method870(graphicstoolkit, (byte)45, this.aBoolean10906, this.aDrawableModelArray10909, class336);

         for(int i_0_ = 0; ~i_0_ > ~this.aDrawableModelArray10909.length; ++i_0_) {
            this.aDrawableModelArray10909[i_0_] = null;
         }
      }
   }

   final void method882(int i, int i_1_, String string, byte b) {
      this.method864(Node_Sub15_Sub10.method2578((byte)124) * CacheNode_Sub4.aClass1_9466.anInt118, string, false, i_1_, i);
      ++anInt11183;
   }

   private final void method883(byte b, int i, int i_3_, int i_4_, DrawableModel drawablemodel, Class336 class336, GraphicsToolkit graphicstoolkit, int i_5_) {
      ++anInt11159;
      if (b != -74) {
         this.method820(null, 41);
      }

      int i_6_ = i_5_ * i_5_ + i * i;
      if (~i_6_ <= -262145 && ~i_6_ >= ~i_3_) {
         int i_7_ = (int)(2607.5945876176133 * Math.atan2((double)i, (double)i_5_) - (double)this.aClass99_10893.method1086(16383)) & 16383;
         DrawableModel drawablemodel_8_ = Node_Sub53.method2978(this.anInt10872, this.anInt10862, 76, i_4_, this.anInt10832, i_7_, graphicstoolkit);
         if (drawablemodel_8_ != null) {
            graphicstoolkit.C(false);
            drawablemodel_8_.method611(class336, null, 0);
            graphicstoolkit.C(true);
         }
      }
   }

   public static void method884(int i) {
      anIntArrayArray11128 = null;
      if (i != 16053) {
         method892(-8, -121);
      }

      aNode_Sub4_11155 = null;
      aNode_Sub4_11140 = null;
   }

   @Override
   final Class171 method809(GraphicsToolkit graphicstoolkit, int i) {
      ++anInt11163;
      if (i > -93) {
         this.method893(true, true);
      }

      return null;
   }

   @Override
   final boolean method810(int i, int i_9_, boolean bool, GraphicsToolkit graphicstoolkit) {
      ++anInt11170;
      if (this.aPlayerDefinition11137 != null && this.method890(131072, -113, graphicstoolkit)) {
         Class336 class336 = graphicstoolkit.A();
         int i_10_ = this.aClass99_10893.method1086(16383);
         class336.method3860(i_10_);
         class336.method3863(this.x, this.anInt5937, this.y);
         boolean bool_11_ = bool;

         for(int i_12_ = 0; ~i_12_ > ~this.aDrawableModelArray10909.length; ++i_12_) {
            if (this.aDrawableModelArray10909[i_12_] != null
               && (
                  !Node_Sub15_Sub10.aBoolean9850
                     ? this.aDrawableModelArray10909[i_12_].method624(i_9_, i, class336, true, 0)
                     : this.aDrawableModelArray10909[i_12_].method621(i_9_, i, class336, true, 0, Class308.anInt3912)
               )) {
               bool_11_ = true;
               break;
            }
         }

         for(int i_13_ = 0; i_13_ < this.aDrawableModelArray10909.length; ++i_13_) {
            this.aDrawableModelArray10909[i_13_] = null;
         }

         return bool_11_;
      } else {
         return false;
      }
   }

   @Override
   final boolean method821(int i) {
      ++anInt11177;
      if (i != 0) {
         this.method883((byte)124, 20, -110, 30, null, null, null, 15);
      }

      return false;
   }

   @Override
   final int method855(byte b) {
      ++anInt11161;
      if (b > -48) {
         this.method869(-126);
      }

      return -1;
   }

   @Override
   final void method816(int i, boolean bool, GraphicsToolkit graphicstoolkit, int i_14_, byte b, int i_15_, Animable animable) {
      if (b >= 101) {
         ++anInt11133;
         throw new IllegalStateException();
      }
   }

   @Override
   final int method871(int i) {
      ++anInt11162;
      if (i != 0) {
         this.combatLevel = -112;
      }

      return this.renderEmoteId;
   }

   private final void method885(
      DrawableModel drawablemodel, int i, byte b, GraphicsToolkit graphicstoolkit, int i_16_, int i_17_, Class336 class336, int i_18_, int i_19_
   ) {
      ++anInt11174;
      int i_20_ = i_17_ * i_17_ - -(i_19_ * i_19_);
      if (~i_20_ <= -262145 && ~i_20_ >= ~i) {
         if (b > -15) {
            this.anInt11172 = -60;
         }

         int i_21_ = (int)(Math.atan2((double)i_17_, (double)i_19_) * 2607.5945876176133 - (double)this.aClass99_10893.method1086(16383)) & 16383;
         DrawableModel drawablemodel_22_ = Node_Sub53.method2978(this.anInt10872, this.anInt10862, 104, i_16_, this.anInt10832, i_21_, graphicstoolkit);
         if (drawablemodel_22_ != null) {
            graphicstoolkit.C(false);
            drawablemodel_22_.method622(class336, null, i_18_, 0);
            graphicstoolkit.C(true);
         }
      }
   }

   final boolean method886(byte b) {
      ++anInt11165;
      return this.aPlayerDefinition11137 != null;
   }

   final void method887(int i, int i_23_, int i_24_, byte b) {
      if (this.anInt10904 < this.scenePositionXQueue.length - 1) {
         ++this.anInt10904;
      }

      ++anInt11138;

      for(int i_25_ = this.anInt10904; i_25_ > 0; --i_25_) {
         this.scenePositionXQueue[i_25_] = this.scenePositionXQueue[-1 + i_25_];
         this.scenePositionYQueue[i_25_] = this.scenePositionYQueue[-1 + i_25_];
         this.movementTypeQueue[i_25_] = this.movementTypeQueue[i_25_ - 1];
      }

      this.scenePositionXQueue[0] = i_24_;
      this.movementTypeQueue[0] = b;
      if (i != -24527) {
         this.method855((byte)-13);
      }

      this.scenePositionYQueue[0] = i_23_;
   }

   @Override
   final int getSize(byte b) {
      return this.aPlayerDefinition11137 != null && ~this.aPlayerDefinition11137.toNPCId != 0
         ? Class366.aClass279_4526.getNPCDefinitions(this.aPlayerDefinition11137.toNPCId, (byte)107).size
         : super.getSize((byte)76);
   }

   final void method888(int i, int i_26_, int i_27_) {
      this.anInt10904 = 0;
      this.scenePositionXQueue[0] = i;
      ++anInt11176;
      this.anInt10901 = 0;
      this.anInt10900 = 0;
      this.scenePositionYQueue[0] = i_27_;
      int i_28_ = this.getSize((byte)84);
      if (i_26_ < -69) {
         this.x = i_28_ * 256 + 512 * this.scenePositionXQueue[0];
         this.y = 512 * this.scenePositionYQueue[0] - -(i_28_ * 256);
         if (Class295.myPlayer == this) {
            Class120.method1228(-125);
         }

         if (this.anEntityNode_Sub4_10902 != null) {
            this.anEntityNode_Sub4_10902.method965();
         }
      }
   }

   @Override
   final void method811(int i) {
      if (i != 27811) {
         this.aBoolean11156 = true;
      }

      ++anInt11168;
      throw new IllegalStateException();
   }

   @Override
   final EntityNode_Sub6 method807(int i, GraphicsToolkit graphicstoolkit) {
      ++anInt11171;
      if (this.aPlayerDefinition11137 != null && this.method890(2048, -112, graphicstoolkit)) {
         Class336 class336 = graphicstoolkit.A();
         int i_29_ = this.aClass99_10893.method1086(16383);
         class336.method3860(i_29_);
         Class261 class261 = Class175.aClass261ArrayArrayArray2099[this.plane][this.x >> Class36.INT_9][this.y >> Class36.INT_9];
         if (class261 != null && class261.anAnimable_Sub1_3317 != null) {
            int i_31_ = this.anInt10849 + -class261.anAnimable_Sub1_3317.aShort9102;
            this.anInt10849 = (int)((float)this.anInt10849 - (float)i_31_ / 10.0F);
         } else {
            this.anInt10849 = (int)((float)this.anInt10849 - (float)this.anInt10849 / 10.0F);
         }

         class336.method3863(this.x, -this.anInt10849 + this.anInt5937 + -20, this.y);
         this.aBoolean10903 = false;
         EntityNode_Sub6 entitynode_sub6 = null;
         if (~Class213.aNode_Sub27_2512.aClass320_Sub7_7308.method3708(false) == -2) {
            RenderDefinitions class259 = this.method868((byte)-126);
            if (class259.aBoolean3267
               && (
                  this.aPlayerDefinition11137.toNPCId == -1
                     || Class366.aClass279_4526.getNPCDefinitions(this.aPlayerDefinition11137.toNPCId, (byte)107).hasShadow
               )) {
               Animator animator = this.anAnimator10876.method245(-125) && this.anAnimator10876.method242((byte)-77) ? this.anAnimator10876 : null;
               Animator animator_32_ = !this.anAnimator10860.method245(-128) || this.aBoolean10867 && animator != null ? null : this.anAnimator10860;
               DrawableModel drawablemodel = CacheNode_Sub14_Sub2.method2356(
                  240,
                  this.aDrawableModelArray10909[0],
                  this.anInt10862,
                  0,
                  this.anInt10832,
                  1,
                  true,
                  graphicstoolkit,
                  160,
                  animator_32_ != null ? animator_32_ : animator,
                  this.anInt10872,
                  i_29_,
                  0
               );
               if (drawablemodel != null) {
                  entitynode_sub6 = Class345.method3972(true, (byte)72, this.aDrawableModelArray10909.length + 1);
                  this.aBoolean10903 = true;
                  graphicstoolkit.C(false);
                  if (Node_Sub15_Sub10.aBoolean9850) {
                     drawablemodel.method622(class336, entitynode_sub6.anEntityNode_Sub5Array5995[this.aDrawableModelArray10909.length], Class308.anInt3912, 0);
                  } else {
                     drawablemodel.method611(class336, entitynode_sub6.anEntityNode_Sub5Array5995[this.aDrawableModelArray10909.length], 0);
                  }

                  graphicstoolkit.C(true);
               }
            }
         }

         if (Class295.myPlayer == this) {
            for(int i_33_ = Class320_Sub24.cachedHintIcons.length + -1; ~i_33_ <= -1; --i_33_) {
               Class223 class223 = Class320_Sub24.cachedHintIcons[i_33_];
               if (class223 != null && ~class223.anInt2666 != 0) {
                  if (class223.anInt2654 == 1) {
                     Node_Sub41 node_sub41 = (Node_Sub41)Class12.aHashTable187.get(3512, (long)class223.anInt2658);
                     if (node_sub41 != null) {
                        Npc npc = node_sub41.aNpc7518;
                        int i_34_ = -Class295.myPlayer.x + npc.x;
                        int i_35_ = npc.y - Class295.myPlayer.y;
                        if (Node_Sub15_Sub10.aBoolean9850) {
                           this.method885(
                              this.aDrawableModelArray10909[0],
                              92160000,
                              (byte)-57,
                              graphicstoolkit,
                              class223.anInt2666,
                              i_34_,
                              class336,
                              Class308.anInt3912,
                              i_35_
                           );
                        } else {
                           this.method883((byte)-74, i_34_, 92160000, class223.anInt2666, this.aDrawableModelArray10909[0], class336, graphicstoolkit, i_35_);
                        }
                     }
                  }

                  if (class223.anInt2654 == 2) {
                     int i_36_ = -Class295.myPlayer.x + class223.anInt2662;
                     int i_37_ = -Class295.myPlayer.y + class223.anInt2653;
                     int i_38_ = class223.anInt2655 << 9;
                     i_38_ *= i_38_;
                     if (!Node_Sub15_Sub10.aBoolean9850) {
                        this.method883((byte)-74, i_36_, i_38_, class223.anInt2666, this.aDrawableModelArray10909[0], class336, graphicstoolkit, i_37_);
                     } else {
                        this.method885(
                           this.aDrawableModelArray10909[0], i_38_, (byte)-36, graphicstoolkit, class223.anInt2666, i_36_, class336, Class308.anInt3912, i_37_
                        );
                     }
                  }

                  if (class223.anInt2654 == 10 && class223.anInt2658 >= 0 && class223.anInt2658 < Class270_Sub2.LOCAL_PLAYERS.length) {
                     Player player_39_ = Class270_Sub2.LOCAL_PLAYERS[class223.anInt2658];
                     if (player_39_ != null) {
                        int i_40_ = player_39_.x - Class295.myPlayer.x;
                        int i_41_ = -Class295.myPlayer.y + player_39_.y;
                        if (Node_Sub15_Sub10.aBoolean9850) {
                           this.method885(
                              this.aDrawableModelArray10909[0],
                              92160000,
                              (byte)-23,
                              graphicstoolkit,
                              class223.anInt2666,
                              i_40_,
                              class336,
                              Class308.anInt3912,
                              i_41_
                           );
                        } else {
                           this.method883((byte)-74, i_40_, 92160000, class223.anInt2666, this.aDrawableModelArray10909[0], class336, graphicstoolkit, i_41_);
                        }
                     }
                  }
               }
            }

            class336.method3860(i_29_);
            class336.method3863(this.x, this.anInt5937, this.y);
         }

         class336.method3860(i_29_);
         class336.method3863(this.x, -this.anInt10849 + this.anInt5937 - 5, this.y);
         if (entitynode_sub6 == null) {
            entitynode_sub6 = Class345.method3972(true, (byte)103, this.aDrawableModelArray10909.length);
         }

         this.method870(graphicstoolkit, (byte)45, false, this.aDrawableModelArray10909, class336);
         if (Node_Sub15_Sub10.aBoolean9850) {
            for(int i_42_ = 0; i_42_ < this.aDrawableModelArray10909.length; ++i_42_) {
               if (this.aDrawableModelArray10909[i_42_] != null) {
                  this.aDrawableModelArray10909[i_42_]
                     .method622(class336, entitynode_sub6.anEntityNode_Sub5Array5995[i_42_], Class308.anInt3912, this == Class295.myPlayer ? 1 : 0);
               }
            }
         } else {
            for(int i_43_ = 0; i_43_ < this.aDrawableModelArray10909.length; ++i_43_) {
               if (this.aDrawableModelArray10909[i_43_] != null) {
                  this.aDrawableModelArray10909[i_43_]
                     .method611(class336, entitynode_sub6.anEntityNode_Sub5Array5995[i_43_], Class295.myPlayer == this ? 1 : 0);
               }
            }
         }

         if (this.anEntityNode_Sub4_10902 != null) {
            Class198 class198 = this.anEntityNode_Sub4_10902.method954();
            if (Node_Sub15_Sub10.aBoolean9850) {
               graphicstoolkit.a(class198, Class308.anInt3912);
            } else {
               graphicstoolkit.a(class198);
            }
         }

         for(int i_44_ = 0; ~i_44_ > ~this.aDrawableModelArray10909.length; ++i_44_) {
            if (this.aDrawableModelArray10909[i_44_] != null) {
               this.aBoolean10903 |= this.aDrawableModelArray10909[i_44_].F();
            }

            this.aDrawableModelArray10909[i_44_] = null;
         }

         this.anInt10815 = Class110.anInt1412;
         return entitynode_sub6;
      } else {
         return null;
      }
   }

   final void decodeAppearence(Buffer stream, int i) {
      stream.offset = 0;
      ++anInt11181;
      int hash = 0;
      stream.readUnsignedByte();
      this.genderId = 1;
      boolean bool = this.hasDisplayName;
      this.hasDisplayName = false;
      boolean bool_46_ = false;
      int i_47_ = super.getSize((byte)85);
      this.method861(-1000, 1 + (7 & hash >> 3));
      this.aByte11145 = (byte)((242 & hash) >> 6);
      this.x += -i_47_ + this.getSize((byte)44) << 8;
      this.y += -i_47_ + this.getSize((byte)111) << 8;
      this.titleId = -1;
      stream.readByte();
      this.titleString = "";
      stream.readString();
      this.skullId = -1;
      stream.readByte();
      this.prayIconId = -1;
      stream.readByte();
      this.isHidden = true;
      stream.readByte();
      this.anInt11134 = 0;
      int npcId = -1;
      int[] equipIds = new int[Class63.aClass363_922.anIntArray4508.length];
      TemporaryItemDefinition[] class38s = new TemporaryItemDefinition[Class63.aClass363_922.anIntArray4508.length];
      ItemDefinitions[] itemdefinitions = new ItemDefinitions[Class63.aClass363_922.anIntArray4508.length];

      for(int i_49_ = 0; Class63.aClass363_922.anIntArray4508.length > i_49_; ++i_49_) {
         if (Class63.aClass363_922.anIntArray4508[i_49_] != 1) {
            int i_50_ = stream.readUnsignedByte();
            if (~i_50_ == -1) {
               equipIds[i_49_] = 0;
            } else {
               int i_51_ = stream.readUnsignedByte();
               int itemId = (i_50_ << 8) - -i_51_;
               if (i_49_ == 0 && itemId == 65535) {
                  npcId = stream.readUnsignedShort();
                  this.anInt11134 = stream.readUnsignedByte();
                  break;
               }

               if (itemId >= 32768) {
                  itemId = Node_Sub28.anIntArray7329[-32768 + itemId];
                  equipIds[i_49_] = Node_Sub16.method2590(1073741824, itemId);
                  itemdefinitions[i_49_] = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(itemId);
                  int i_53_ = itemdefinitions[i_49_].teamId;
                  if (~i_53_ != -1) {
                     this.anInt11134 = i_53_;
                  }
               } else {
                  equipIds[i_49_] = Node_Sub16.method2590(itemId + -256, Integer.MIN_VALUE);
               }
            }
         }
      }

      if (npcId == -1) {
         int flagHash = stream.readUnsignedShort();
         int i_55_ = 0;

         for(int i_56_ = 0; ~Class63.aClass363_922.anIntArray4508.length < ~i_56_; ++i_56_) {
            if (~Class63.aClass363_922.anIntArray4508[i_56_] == -1) {
               if (~(flagHash & 1 << i_55_) != -1) {
                  class38s[i_56_] = Node_Sub38_Sub27.method2882(stream, itemdefinitions[i_56_], 0);
               }

               ++i_55_;
            }
         }
      }

      int[] colorIds = new int[10];

      for(int i_58_ = i; i_58_ < 10; ++i_58_) {
         int i_59_ = 0;
         stream.readUnsignedByte();
         if (~i_58_ <= ~Class117_Sub2.aShortArrayArrayArray5151.length || i_59_ < 0 || ~Class117_Sub2.aShortArrayArrayArray5151[i_58_][0].length >= ~i_59_) {
            i_59_ = 0;
         }

         colorIds[i_58_] = i_59_;
      }

      this.renderEmoteId = -1;
      stream.readUnsignedShort();
      this.displayName = "";
      stream.readString();
      if (this == Class295.myPlayer) {
         Node_Sub40.myPlayerDisplayName = this.displayName;
      }

      this.aString11142 = this.displayName;
      this.combatLevel = 126;
      stream.readUnsignedByte();
      if (!bool_46_) {
         this.anInt11139 = 0;
         this.combatLevelWithSummoning = 0;
         stream.readUnsignedByte();
         this.anInt11184 = -1;
         stream.readUnsignedByte();
      } else {
         this.anInt11139 = 0;
         stream.readUnsignedShort();
         this.combatLevelWithSummoning = this.combatLevel;
         if (this.anInt11139 == 65535) {
            this.anInt11139 = -1;
         }

         this.anInt11184 = -1;
      }

      int i_60_ = this.anInt11164;
      this.anInt11164 = 0;
      stream.readUnsignedByte();
      if (this.anInt11164 == 0) {
         Class45.method462((byte)69, this);
      } else {
         int i_61_ = this.anInt11167;
         int i_62_ = this.anInt11172;
         int i_63_ = this.anInt11153;
         int i_64_ = this.anInt11182;
         int i_65_ = this.anInt11173;
         this.anInt11167 = stream.readUnsignedShort();
         this.anInt11172 = stream.readUnsignedShort();
         this.anInt11153 = stream.readUnsignedShort();
         this.anInt11182 = stream.readUnsignedShort();
         this.anInt11173 = stream.readUnsignedByte();
         if (this.hasDisplayName == !bool
            || ~this.anInt11164 != ~i_60_
            || i_61_ != this.anInt11167
            || ~i_62_ != ~this.anInt11172
            || this.anInt11153 != i_63_
            || ~this.anInt11182 != ~i_64_
            || i_65_ != this.anInt11173) {
            Class135.method1587(this);
         }
      }

      if (this.aPlayerDefinition11137 == null) {
         this.aPlayerDefinition11137 = new PlayerDefinition();
      }

      int i_66_ = this.aPlayerDefinition11137.toNPCId;
      int[] is_67_ = this.aPlayerDefinition11137.anIntArray3430;
      this.aPlayerDefinition11137.method3278(colorIds, equipIds, class38s, npcId, this.method871(0), ~this.genderId == -2, (byte)-110);
      if (npcId != i_66_) {
         this.x = (this.scenePositionXQueue[0] << 9) - -(this.getSize((byte)83) << 8);
         this.y = (this.scenePositionYQueue[0] << 9) + (this.getSize((byte)45) << 8);
      }

      if (Class166.myPlayerIndex == this.index && is_67_ != null) {
         for(int i_68_ = 0; i_68_ < colorIds.length; ++i_68_) {
            if (colorIds[i_68_] != is_67_[i_68_]) {
               EntityNode_Sub3_Sub1.aClass86_9166.method1008(50);
               break;
            }
         }
      }

      if (this.anEntityNode_Sub4_10902 != null) {
         this.anEntityNode_Sub4_10902.method965();
      }

      if (this.anAnimator10860.method245(-128) && this.aBoolean10867) {
         RenderDefinitions class259 = this.method868((byte)-123);
         if (!class259.method3130(this.anAnimator10860.getAnimationId(), (byte)-127)) {
            this.anAnimator10860.method249(true, -1);
            this.aBoolean10867 = false;
         }
      }
   }

   private final boolean method890(int i, int i_69_, GraphicsToolkit graphicstoolkit) {
      ++anInt11144;
      int i_70_ = i;
      if (i_69_ >= -110) {
         return true;
      } else {
         RenderDefinitions class259 = this.method868((byte)-128);
         Animator animator = this.anAnimator10876.method245(-125) && !this.anAnimator10876.method242((byte)-77) ? this.anAnimator10876 : null;
         Animator animator_71_ = !this.anAnimator10860.method245(-127) || this.aBoolean11169 || this.aBoolean10867 && animator != null
            ? null
            : this.anAnimator10860;
         int i_72_ = class259.modelHeightOffset1;
         int i_73_ = class259.anInt3266;
         if (~i_72_ != -1 || i_73_ != 0 || class259.anInt3250 != 0 || ~class259.anInt3285 != -1) {
            i |= 7;
         }

         int i_74_ = this.aClass99_10893.method1086(16383);
         boolean bool = this.aByte10888 != 0 && ~Class174.clientCycle <= ~this.anInt10895 && Class174.clientCycle < this.anInt10882;
         if (bool) {
            i |= 524288;
         }

         DrawableModel drawablemodel = this.aDrawableModelArray10909[0] = this.aPlayerDefinition11137
            .method3279(
               EntityNode_Sub3_Sub1.aClass86_9166,
               animator,
               77,
               true,
               InputStream_Sub2.aClass281_83,
               Class18.aClass37_306,
               i,
               this.anIntArray10881,
               Class63.aClass363_922,
               Class42.aClass181_643,
               graphicstoolkit,
               Class366.aClass279_4526,
               this.anAnimableAnimator_Sub1Array10894,
               i_74_,
               animator_71_,
               Class24.aClass275_442
            );
         int i_75_ = Class290_Sub5.method3435(-85);
         if (~Class201.anInt2446 > -97 && i_75_ > 50) {
            Class189.method1934((byte)17);
         }

         if (Class240.aClass329_2943 != Node_Sub38_Sub1.aClass329_10086 && i_75_ < 50) {
            int i_76_;
            for(i_76_ = 50 - i_75_; ~Class57.anInt849 > ~i_76_; ++Class57.anInt849) {
               Class93.aByteArrayArray1244[Class57.anInt849] = new byte[102400];
            }

            while(i_76_ < Class57.anInt849) {
               --Class57.anInt849;
               Class93.aByteArrayArray1244[Class57.anInt849] = null;
            }
         } else if (Class240.aClass329_2943 != Node_Sub38_Sub1.aClass329_10086) {
            Class57.anInt849 = 0;
            Class93.aByteArrayArray1244 = new byte[50][];
         }

         if (drawablemodel == null) {
            return false;
         } else {
            this.anInt10875 = drawablemodel.fa();
            this.anInt10844 = drawablemodel.ma();
            this.method857(drawablemodel, false);
            if (~i_72_ == -1 && ~i_73_ == -1) {
               this.method865(i_74_, 0, 0, this.getSize((byte)59) << 9, this.getSize((byte)126) << 9, -81);
            } else {
               this.method865(i_74_, class259.anInt3263, class259.anInt3291, i_72_, i_73_, -104);
               if (this.anInt10872 != 0) {
                  drawablemodel.FA(this.anInt10872);
               }

               if (this.anInt10862 != 0) {
                  drawablemodel.VA(this.anInt10862);
               }

               if (this.anInt10832 != 0) {
                  drawablemodel.H(0, this.anInt10832, 0);
               }
            }

            if (bool) {
               drawablemodel.method626(this.aByte10896, this.aByte10878, this.aByte10884, 255 & this.aByte10888);
            }

            if (!this.aBoolean11169) {
               this.method848(i_70_, i_73_, graphicstoolkit, class259, i_74_, i_72_, -105);
            }

            return true;
         }
      }
   }

   @Override
   final boolean method862(byte b) {
      ++anInt11175;
      if (b != -93) {
         this.anInt11172 = -110;
      }

      return CacheNode_Sub4.aClass1_9466.aBoolean111;
   }

   final String method891(boolean bool, int i) {
      if (i != 1) {
         return null;
      } else {
         ++anInt11179;
         return !bool ? this.aString11142 : this.displayName;
      }
   }

   static final void method892(int i, int i_77_) {
      ++anInt11166;
      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 5, (long)i);
      cachenode_sub2.method2291((byte)121);
   }

   Player(int i) {
      super(i);
      this.isHidden = false;
      this.titleId = 0;
      this.anInt11134 = 0;
      this.aBoolean11135 = false;
      this.prayIconId = -1;
      this.hasDisplayName = false;
      this.combatLevelWithSummoning = 0;
      this.anInt11139 = 0;
      this.anInt11164 = 0;
      this.aBoolean11156 = false;
      this.anInt11167 = -1;
      this.aBoolean11169 = false;
      this.combatLevel = 0;
      this.aBoolean11157 = false;
      this.aByte11145 = 0;
      this.anInt11172 = -1;
      this.anInt11173 = 255;
      this.anInt11153 = -1;
      this.anInt11182 = -1;
      this.anInt11180 = -1;
      this.anInt11184 = -1;
   }

   public Player() {
      this.isHidden = false;
      this.titleId = 0;
      this.anInt11134 = 0;
      this.aBoolean11135 = false;
      this.prayIconId = -1;
      this.hasDisplayName = false;
      this.combatLevelWithSummoning = 0;
      this.anInt11139 = 0;
      this.anInt11164 = 0;
      this.aBoolean11156 = false;
      this.anInt11167 = -1;
      this.aBoolean11169 = false;
      this.combatLevel = 0;
      this.aBoolean11157 = false;
      this.aByte11145 = 0;
      this.anInt11172 = -1;
      this.anInt11173 = 255;
      this.anInt11153 = -1;
      this.anInt11182 = -1;
      this.anInt11180 = -1;
      this.anInt11184 = -1;
   }

   public String title() {
      ++anInt11136;
      String title = "";
      int[] is;
      if (~this.genderId == -2 && Class83.anIntArray5188 != null) {
         is = Class83.anIntArray5188;
      } else {
         is = InputStream_Sub1.anIntArray77;
         if (is == null) {
            is = new int[]{1093};
         }
      }

      if (is != null && ~is[this.aByte11145] != 0) {
         Class39 class39 = Class328.aClass362_4112.method4051(is[this.aByte11145]);
         if (class39.aChar587 == 's') {
            title = title + class39.method412(-3470, this.titleId & 255);
         }
      }

      return title.length() != 0 ? title : "";
   }

   final String method893(boolean bool, boolean bool_79_) {
      ++anInt11136;
      String string = "";
      if (CacheNode_Sub19.aStringArray9622 != null) {
         string = string + CacheNode_Sub19.aStringArray9622[this.aByte11145];
      }

      if (bool) {
         this.method821(106);
      }

      int[] is;
      if (~this.genderId == -2 && Class83.anIntArray5188 != null) {
         is = Class83.anIntArray5188;
      } else {
         is = InputStream_Sub1.anIntArray77;
         if (is == null) {
            is = new int[]{1093};
         }
      }

      if (is != null && ~is[this.aByte11145] != 0) {
         Class39 class39 = Class328.aClass362_4112.method4051(is[this.aByte11145]);
         if (class39.aChar587 == 's') {
            string = string + class39.method412(-3470, this.titleId & 255);
         } else {
            ClanChat.method507(new Throwable(), "gdn1", -125);
            is[this.aByte11145] = -1;
         }
      }

      if (!bool_79_) {
         string = string + this.aString11142;
      } else {
         string = string + "<col=" + this.getRankColour() + ">";
         string = string + this.displayName;
         string = string + "</col>";
      }

      if (Class320_Sub15.aStringArray8354 != null) {
         string = string + Class320_Sub15.aStringArray8354[this.aByte11145];
      }

      return string;
   }

   final String fixedName(boolean bool, boolean bool_79_) {
      ++anInt11136;
      String string = "";
      if (CacheNode_Sub19.aStringArray9622 != null) {
         string = string + CacheNode_Sub19.aStringArray9622[this.aByte11145];
      }

      if (bool) {
         this.method821(106);
      }

      int[] is;
      if (~this.genderId == -2 && Class83.anIntArray5188 != null) {
         is = Class83.anIntArray5188;
      } else {
         is = InputStream_Sub1.anIntArray77;
         if (is == null) {
            is = new int[]{1093};
         }
      }

      if (is != null && ~is[this.aByte11145] != 0) {
         Class39 class39 = Class328.aClass362_4112.method4051(is[this.aByte11145]);
         if (class39.aChar587 == 's') {
            string = string + class39.method412(-3470, this.titleId & 255) + "<col=ffffff>";
         } else {
            ClanChat.method507(new Throwable(), "gdn1", -125);
            is[this.aByte11145] = -1;
         }
      }

      if (!bool_79_) {
         string = string + this.aString11142;
      } else {
         string = string + "<col=" + this.getRankColour() + ">";
         string = string + this.displayName;
         string = string + "</col>";
      }

      if (Class320_Sub15.aStringArray8354 != null) {
         string = string + Class320_Sub15.aStringArray8354[this.aByte11145];
      }

      return string;
   }

   private String getRankColour() {
      if (this.titleString == null) {
         return "";
      } else if (this.titleString.equals("Easy")) {
         return "2AF214";
      } else if (this.titleString.equals("Normal")) {
         return "087F88";
      } else if (this.titleString.equals("Hard")) {
         return "FF930D";
      } else if (this.titleString.equals("Legend")) {
         return "B00A0A";
      } else {
         return this.titleString.equals("Elite") ? "FF0000" : "";
      }
   }

   @Override
   final Class59 method869(int i) {
      if (i != -3109) {
         this.aBoolean11157 = false;
      }

      ++anInt11148;
      if (this.aClass59_10861 != null) {
         if (this.aClass59_10861.aString877 == null) {
            return null;
         }

         if (~Class69.anInt943 == -1 || ~Class69.anInt943 == -4 || Class69.anInt943 == 1 && Class193.method1955(i + 3109, this.aString11142)) {
            return this.aClass59_10861;
         }
      }

      return null;
   }

   final void processMovement(int i, int i_80_, int i_81_, byte b) {
      if (this.anAnimator10876.method245(-126) && ~this.anAnimator10876.method243((byte)-24).anInt718 == -2) {
         this.anIntArray10817 = null;
         this.anAnimator10876.method249(true, -1);
      }

      ++anInt11143;

      for(int i_82_ = 0; ~i_82_ > ~this.aClass165Array10886.length; ++i_82_) {
         if (~this.aClass165Array10886[i_82_].graphicsId != 0) {
            Class195 class195 = Class16.aClass101_228.method1090(i_81_ ^ -9412, this.aClass165Array10886[i_82_].graphicsId);
            if (class195.aBoolean2402 && ~class195.anInt2394 != 0 && Class18.aClass37_306.method395(class195.anInt2394, (byte)-107).anInt718 == 1) {
               this.aClass165Array10886[i_82_].anAnimator2026.method249(true, -1);
               this.aClass165Array10886[i_82_].graphicsId = -1;
            }
         }
      }

      if (i_81_ != -9380) {
         this.getSize((byte)-74);
      }

      this.anInt11180 = -1;
      if (i_80_ >= 0 && ~Node_Sub54.GAME_SCENE_WDITH < ~i_80_ && ~i <= -1 && ~Class377_Sub1.GAME_SCENE_HEIGHT < ~i) {
         if (~this.scenePositionXQueue[0] <= -1
            && ~this.scenePositionXQueue[0] > ~Node_Sub54.GAME_SCENE_WDITH
            && this.scenePositionYQueue[0] >= 0
            && ~Class377_Sub1.GAME_SCENE_HEIGHT < ~this.scenePositionYQueue[0]) {
            if (~b == -3) {
               Class191.method1946(this, i_80_, true, (byte)2, i);
            }

            this.method888(i_80_, -117, i);
         } else {
            this.method888(i_80_, -97, i);
         }
      } else {
         this.method888(i_80_, -117, i);
      }
   }
}
