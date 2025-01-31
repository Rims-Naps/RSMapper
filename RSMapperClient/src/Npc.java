import java.awt.Container;
import java.awt.Insets;

public class Npc extends Actor {
   static int anInt11098;
   protected String name;
   protected int anInt11100;
   static int anInt11101;
   static int anInt11102;
   static int anInt11103;
   static int anInt11104;
   static int anInt11105;
   static int anInt11106;
   protected int anInt11107 = -1;
   static int anInt11108;
   static int anInt11109;
   static int anInt11110;
   static int anInt11111;
   static int anInt11112;
   static Class336 aClass336_11113;
   static int anInt11114;
   static int anInt11115;
   static int anInt11116;
   static int anInt11117;
   protected Class361 aClass361_11118;
   static int anInt11119;
   static int anInt11120;
   static int anInt11121;
   protected NpcDefinition definitions;
   static int anInt11123;
   protected int anInt11124;
   static int anInt11125;
   protected int anInt11126;
   protected int combatLevel;

   @Override
   final void method811(int i) {
      ++anInt11123;
      if (i != 27811) {
         method872(true);
      }

      throw new IllegalStateException();
   }

   public static void method872(boolean bool) {
      if (bool) {
         method880((byte)-95);
      }

      aClass336_11113 = null;
   }

   final boolean definitionsExist(byte b) {
      ++anInt11121;
      return this.definitions != null;
   }

   public Npc() {
      this.anInt11100 = -1;
      this.anInt11124 = 1;
      this.anInt11126 = 1;
   }

   @Override
   final void method816(int i, boolean bool, GraphicsToolkit graphicstoolkit, int i_0_, byte b, int i_1_, Animable animable) {
      ++anInt11112;
      if (b <= 101) {
         method880((byte)99);
      }

      throw new IllegalStateException();
   }

   @Override
   final boolean method810(int i, int i_2_, boolean bool, GraphicsToolkit graphicstoolkit) {
      ++anInt11104;
      if (this.definitions != null && this.method875(131072, true, graphicstoolkit)) {
         Class336 class336 = graphicstoolkit.A();
         int i_3_ = this.aClass99_10893.method1086(16383);
         class336.method3860(i_3_);
         class336.method3863(this.x, this.anInt5937, this.y);
         boolean bool_4_ = bool;

         for(int i_5_ = 0; ~i_5_ > ~this.aDrawableModelArray10909.length; ++i_5_) {
            if (this.aDrawableModelArray10909[i_5_] != null) {
               boolean bool_6_ = ~this.definitions.registerClickRadius < -1
                  || (~this.definitions.anInt2803 == 0 ? this.definitions.size == 1 : ~this.definitions.anInt2803 == -2);
               boolean bool_7_;
               if (Node_Sub15_Sub10.aBoolean9850) {
                  bool_7_ = this.aDrawableModelArray10909[i_5_]
                     .method621(i_2_, i, class336, bool_6_, this.definitions.registerClickRadius, Class308.anInt3912);
               } else {
                  bool_7_ = this.aDrawableModelArray10909[i_5_].method624(i_2_, i, class336, bool_6_, this.definitions.registerClickRadius);
               }

               if (bool_7_) {
                  bool_4_ = true;
                  break;
               }
            }
         }

         for(int i_8_ = 0; ~i_8_ > ~this.aDrawableModelArray10909.length; ++i_8_) {
            this.aDrawableModelArray10909[i_8_] = null;
         }

         return bool_4_;
      } else {
         return false;
      }
   }

   static final void method874() {
      for(int i = 0; i < Class63.anInt923; ++i) {
         Mobile mobile = Node_Sub52.aMobileArray7648[i];
         Class290.method3418(mobile, true);
         Node_Sub52.aMobileArray7648[i] = null;
      }

      Class63.anInt923 = 0;
   }

   @Override
   final EntityNode_Sub6 method807(int i, GraphicsToolkit graphicstoolkit) {
      ++anInt11101;
      if (this.definitions != null && this.method875(2048, true, graphicstoolkit)) {
         Class336 class336 = graphicstoolkit.A();
         int i_9_ = this.aClass99_10893.method1086(16383);
         class336.method3860(i_9_);
         Class261 class261 = Class175.aClass261ArrayArrayArray2099[this.plane][this.x >> Class36.INT_9][this.y >> Class36.INT_9];
         if (class261 != null && class261.anAnimable_Sub1_3317 != null) {
            int i_10_ = this.anInt10849 - class261.anAnimable_Sub1_3317.aShort9102;
            this.anInt10849 = (int)((float)this.anInt10849 - (float)i_10_ / 10.0F);
         } else {
            this.anInt10849 = (int)((float)this.anInt10849 - (float)this.anInt10849 / 10.0F);
         }

         class336.method3863(this.x, -this.anInt10849 + -20 + this.anInt5937, this.y);
         RenderDefinitions class259 = this.method868((byte)-123);
         NpcDefinition npcdefinition = this.definitions.anIntArray2827 != null ? this.definitions.method2999(65535, Class24.aClass275_442) : this.definitions;
         this.aBoolean10903 = false;
         EntityNode_Sub6 entitynode_sub6 = null;
         if (Class213.aNode_Sub27_2512.aClass320_Sub7_7308.method3708(false) == 1 && npcdefinition.hasShadow && class259.aBoolean3267) {
            Animator animator = this.anAnimator10876.method245(-126) && this.anAnimator10876.method242((byte)-77) ? this.anAnimator10876 : null;
            Animator animator_11_ = !this.anAnimator10860.method245(-128) || this.aBoolean10867 && animator != null ? null : this.anAnimator10860;
            DrawableModel drawablemodel = CacheNode_Sub14_Sub2.method2356(
               255 & this.definitions.outerShadowBrightness,
               this.aDrawableModelArray10909[0],
               this.anInt10862,
               this.definitions.outerShadowColor & '\uffff',
               this.anInt10832,
               this.definitions.size,
               true,
               graphicstoolkit,
               255 & this.definitions.innerShadowBrightness,
               animator_11_ != null ? animator_11_ : animator,
               this.anInt10872,
               i_9_,
               this.definitions.innerShadowColor & '\uffff'
            );
            if (drawablemodel != null) {
               entitynode_sub6 = Class345.method3972(this.method881(75), (byte)-71, this.aDrawableModelArray10909.length + 1);
               this.aBoolean10903 = true;
               graphicstoolkit.C(false);
               if (!Node_Sub15_Sub10.aBoolean9850) {
                  drawablemodel.method611(class336, entitynode_sub6.anEntityNode_Sub5Array5995[this.aDrawableModelArray10909.length], 0);
               } else {
                  drawablemodel.method622(class336, entitynode_sub6.anEntityNode_Sub5Array5995[this.aDrawableModelArray10909.length], Class308.anInt3912, 0);
               }

               graphicstoolkit.C(true);
            }
         }

         class336.method3860(i_9_);
         class336.method3863(this.x, -this.anInt10849 + this.anInt5937 + -5, this.y);
         if (entitynode_sub6 == null) {
            entitynode_sub6 = Class345.method3972(this.method881(-20), (byte)-76, this.aDrawableModelArray10909.length);
         }

         this.method870(graphicstoolkit, (byte)45, false, this.aDrawableModelArray10909, class336);
         if (Node_Sub15_Sub10.aBoolean9850) {
            for(int i_12_ = 0; ~i_12_ > ~this.aDrawableModelArray10909.length; ++i_12_) {
               if (this.aDrawableModelArray10909[i_12_] != null) {
                  this.aDrawableModelArray10909[i_12_].method622(class336, entitynode_sub6.anEntityNode_Sub5Array5995[i_12_], Class308.anInt3912, 0);
               }
            }
         } else {
            for(int i_13_ = 0; i_13_ < this.aDrawableModelArray10909.length; ++i_13_) {
               if (this.aDrawableModelArray10909[i_13_] != null) {
                  this.aDrawableModelArray10909[i_13_].method611(class336, entitynode_sub6.anEntityNode_Sub5Array5995[i_13_], 0);
               }
            }
         }

         if (this.anEntityNode_Sub4_10902 != null) {
            Class198 class198 = this.anEntityNode_Sub4_10902.method954();
            if (!Node_Sub15_Sub10.aBoolean9850) {
               graphicstoolkit.a(class198);
            } else {
               graphicstoolkit.a(class198, Class308.anInt3912);
            }
         }

         for(int i_15_ = 0; ~i_15_ > ~this.aDrawableModelArray10909.length; ++i_15_) {
            if (this.aDrawableModelArray10909[i_15_] != null) {
               this.aBoolean10903 |= this.aDrawableModelArray10909[i_15_].F();
            }

            this.aDrawableModelArray10909[i_15_] = null;
         }

         this.anInt10815 = Class110.anInt1412;
         return entitynode_sub6;
      } else {
         return null;
      }
   }

   private final boolean method875(int i, boolean bool, GraphicsToolkit toolkit) {
      ++anInt11114;
      int i_16_ = i;
      RenderDefinitions class259 = this.method868((byte)-127);
      Animator animator = this.anAnimator10876.method245(-124) && !this.anAnimator10876.method242((byte)-77) ? this.anAnimator10876 : null;
      Animator animator_17_ = this.anAnimator10860.method245(-128) && (!this.aBoolean10867 || animator == null) ? this.anAnimator10860 : null;
      int i_18_ = class259.modelHeightOffset1;
      int i_19_ = class259.anInt3266;
      if (i_18_ != 0 || i_19_ != 0 || class259.anInt3250 != 0 || class259.anInt3285 != 0) {
         i |= 7;
      }

      boolean bool_20_ = this.aByte10888 != 0 && this.anInt10895 <= Class174.clientCycle && this.anInt10882 < Class174.clientCycle;
      if (bool_20_) {
         i |= 524288;
      }

      int i_21_ = this.aClass99_10893.method1086(16383);
      DrawableModel drawablemodel = this.aDrawableModelArray10909[0] = this.definitions
         .prepareModel(
            Class24.aClass275_442,
            toolkit,
            InputStream_Sub2.aClass281_83,
            (byte)61,
            animator,
            i_21_,
            this.anIntArray10881,
            this.aClass361_11118,
            animator_17_,
            i,
            this.anAnimableAnimator_Sub1Array10894
         );
      if (drawablemodel == null) {
         return false;
      } else {
         this.anInt10875 = drawablemodel.fa();
         this.anInt10844 = drawablemodel.ma();
         this.method857(drawablemodel, false);
         if (i_18_ == 0 && i_19_ == 0) {
            this.method865(i_21_, 0, 0, this.getSize((byte)116) << 9, this.getSize((byte)79) << 9, -86);
         } else {
            this.method865(i_21_, class259.anInt3263, class259.anInt3291, i_18_, i_19_, -119);
            if (this.anInt10872 != 0) {
               this.aDrawableModelArray10909[0].FA(this.anInt10872);
            }

            if (this.anInt10862 != 0) {
               this.aDrawableModelArray10909[0].VA(this.anInt10862);
            }

            if (this.anInt10832 != 0) {
               this.aDrawableModelArray10909[0].H(0, this.anInt10832, 0);
            }
         }

         if (bool_20_) {
            drawablemodel.method626(this.aByte10896, this.aByte10878, this.aByte10884, this.aByte10888 & 255);
         }

         if (!bool) {
            return true;
         } else {
            this.method848(i_16_, i_19_, toolkit, class259, i_21_, i_18_, -69);
            return true;
         }
      }
   }

   @Override
   final int method850(byte b) {
      if (b <= 46) {
         return -127;
      } else {
         ++anInt11125;
         if (this.definitions.anIntArray2827 != null) {
            NpcDefinition npcdefinition = this.definitions.method2999(65535, Class24.aClass275_442);
            if (npcdefinition != null && ~npcdefinition.anInt2804 != 0) {
               return npcdefinition.anInt2804;
            }
         }

         return this.definitions.anInt2804 == -1 ? super.method850((byte)47) : this.definitions.anInt2804;
      }
   }

   @Override
   final Class171 method809(GraphicsToolkit graphicstoolkit, int i) {
      if (i >= -93) {
         this.method871(98);
      }

      ++anInt11102;
      return null;
   }

   @Override
   final Class59 method869(int i) {
      ++anInt11111;
      if (i != -3109) {
         return null;
      } else {
         return this.aClass59_10861 != null && this.aClass59_10861.aString877 == null ? null : this.aClass59_10861;
      }
   }

   @Override
   final boolean method862(byte b) {
      ++anInt11103;
      if (b != -93) {
         aClass336_11113 = null;
      }

      return CacheNode_Sub4.aClass1_9466.aBoolean105;
   }

   @Override
   final int method855(byte b) {
      ++anInt11108;
      if (b >= -48) {
         this.method821(117);
      }

      if (this.definitions.anIntArray2827 != null) {
         NpcDefinition npcdefinition = this.definitions.method2999(65535, Class24.aClass275_442);
         if (npcdefinition != null && ~npcdefinition.stackSpriteId != 0) {
            return npcdefinition.stackSpriteId;
         }
      }

      return this.definitions.stackSpriteId;
   }

   final void method876(int i, int i_22_, byte b) {
      ++anInt11117;
      int dx = this.scenePositionXQueue[0];
      if (b < -95) {
         int dy = this.scenePositionYQueue[0];
         if (~i_22_ == -1) {
            ++dy;
         }

         if (~i_22_ == -2) {
            ++dy;
            ++dx;
         }

         if (~i_22_ == -3) {
            ++dx;
         }

         if (i_22_ == 3) {
            --dy;
            ++dx;
         }

         if (i_22_ == 4) {
            --dy;
         }

         if (~i_22_ == -6) {
            --dy;
            --dx;
         }

         if (~i_22_ == -7) {
            --dx;
         }

         if (i_22_ == 7) {
            --dx;
            ++dy;
         }

         if (this.anAnimator10876.method245(-124) && ~this.anAnimator10876.method243((byte)-24).anInt718 == -2) {
            this.anIntArray10817 = null;
            this.anAnimator10876.method249(true, -1);
         }

         for(int i_25_ = 0; ~i_25_ > ~this.aClass165Array10886.length; ++i_25_) {
            if (~this.aClass165Array10886[i_25_].graphicsId != 0) {
               Class195 class195 = Class16.aClass101_228.method1090(103, this.aClass165Array10886[i_25_].graphicsId);
               if (class195.aBoolean2402 && class195.anInt2394 != -1 && ~Class18.aClass37_306.method395(class195.anInt2394, (byte)-102).anInt718 == -2) {
                  this.aClass165Array10886[i_25_].anAnimator2026.method249(true, -1);
                  this.aClass165Array10886[i_25_].graphicsId = -1;
               }
            }
         }

         if (this.anInt10904 < this.scenePositionXQueue.length - 1) {
            ++this.anInt10904;
         }

         for(int i_26_ = this.anInt10904; i_26_ > 0; --i_26_) {
            this.scenePositionXQueue[i_26_] = this.scenePositionXQueue[i_26_ - 1];
            this.scenePositionYQueue[i_26_] = this.scenePositionYQueue[i_26_ + -1];
            this.movementTypeQueue[i_26_] = this.movementTypeQueue[-1 + i_26_];
         }

         this.scenePositionXQueue[0] = dx;
         this.scenePositionYQueue[0] = dy;
         this.movementTypeQueue[0] = (byte)i;
      }
   }

   final void method877(int i, boolean bool, int i_27_, int i_28_, int i_29_, int i_30_) {
      if (i != -15694) {
         this.method862((byte)31);
      }

      this.plane = this.aByte5931 = (byte)i_29_;
      ++anInt11109;
      if (Class238.tileHasBridgeFlag(i_27_, i_28_, -23)) {
         ++this.aByte5931;
      }

      if (this.anAnimator10876.method245(-127) && ~this.anAnimator10876.method243((byte)-24).anInt718 == -2) {
         this.anIntArray10817 = null;
         this.anAnimator10876.method249(true, -1);
      }

      for(int i_31_ = 0; i_31_ < this.aClass165Array10886.length; ++i_31_) {
         if (~this.aClass165Array10886[i_31_].graphicsId != 0) {
            Class195 class195 = Class16.aClass101_228.method1090(i ^ 15648, this.aClass165Array10886[i_31_].graphicsId);
            if (class195.aBoolean2402 && class195.anInt2394 != -1 && Class18.aClass37_306.method395(class195.anInt2394, (byte)-83).anInt718 == 1) {
               this.aClass165Array10886[i_31_].anAnimator2026.method249(true, -1);
               this.aClass165Array10886[i_31_].graphicsId = -1;
            }
         }
      }

      if (!bool) {
         int i_32_ = i_28_ + -this.scenePositionXQueue[0];
         int i_33_ = -this.scenePositionYQueue[0] + i_27_;
         if (i_32_ >= -8 && i_32_ <= 8 && i_33_ >= -8 && ~i_33_ >= -9) {
            if (this.scenePositionXQueue.length + -1 > this.anInt10904) {
               ++this.anInt10904;
            }

            for(int i_34_ = this.anInt10904; i_34_ > 0; --i_34_) {
               this.scenePositionXQueue[i_34_] = this.scenePositionXQueue[-1 + i_34_];
               this.scenePositionYQueue[i_34_] = this.scenePositionYQueue[i_34_ - 1];
               this.movementTypeQueue[i_34_] = this.movementTypeQueue[i_34_ + -1];
            }

            this.scenePositionXQueue[0] = i_28_;
            this.movementTypeQueue[0] = 1;
            this.scenePositionYQueue[0] = i_27_;
            return;
         }
      }

      this.anInt10904 = 0;
      this.anInt10901 = 0;
      this.scenePositionXQueue[0] = i_28_;
      this.anInt10900 = 0;
      this.scenePositionYQueue[0] = i_27_;
      this.x = (i_30_ << 8) + (this.scenePositionXQueue[0] << 9);
      this.y = (this.scenePositionYQueue[0] << 9) - -(i_30_ << 8);
      if (this.anEntityNode_Sub4_10902 != null) {
         this.anEntityNode_Sub4_10902.method965();
      }
   }

   Npc(int i) {
      super(i);
      this.anInt11100 = -1;
      this.anInt11124 = 1;
      this.anInt11126 = 1;
   }

   final void method878(int i, int i_35_, String string, byte b) {
      ++anInt11105;
      int i_37_ = Node_Sub15_Sub10.method2578((byte)-128) * CacheNode_Sub4.aClass1_9466.anInt116;
      this.method864(i_37_, string, false, i_35_, i);
   }

   @Override
   final void method820(GraphicsToolkit graphicstoolkit, int i) {
      ++anInt11116;
      if (this.definitions != null && (this.aBoolean10906 || this.method875(0, true, graphicstoolkit))) {
         Class336 class336 = graphicstoolkit.A();
         class336.method3860(this.aClass99_10893.method1086(16383));
         class336.method3863(this.x, this.anInt5937 + -20, this.y);
         this.method870(graphicstoolkit, (byte)45, this.aBoolean10906, this.aDrawableModelArray10909, class336);

         for(int i_38_ = 0; i_38_ < this.aDrawableModelArray10909.length; ++i_38_) {
            this.aDrawableModelArray10909[i_38_] = null;
         }

         if (i != -5) {
            this.method809(null, -21);
         }
      }
   }

   @Override
   final boolean method821(int i) {
      ++anInt11119;
      if (i != 0) {
         this.definitionsExist((byte)-51);
      }

      return false;
   }

   final void method879(NpcDefinition npcdefinition, boolean bool) {
      if (!bool) {
         this.method810(72, -105, false, null);
      }

      if (npcdefinition != this.definitions && Class213.rightClickDialogueIsOpen && Node_Sub23_Sub1.method2640(this.index, -60)) {
         Class260.method3137(0);
      }

      ++anInt11110;
      this.definitions = npcdefinition;
      if (this.definitions != null) {
         this.name = this.definitions.name;
         this.combatLevel = this.definitions.combatLevel;
      }

      if (this.anEntityNode_Sub4_10902 != null) {
         this.anEntityNode_Sub4_10902.method965();
      }
   }

   @Override
   final int method871(int i) {
      ++anInt11115;
      if (this.definitions.anIntArray2827 != null) {
         NpcDefinition npcdefinition = this.definitions.method2999(i + 65535, Class24.aClass275_442);
         if (npcdefinition != null && npcdefinition.renderEmote != -1) {
            return npcdefinition.renderEmote;
         }
      }

      if (i != 0) {
         this.anInt11107 = -66;
      }

      return this.definitions.renderEmote;
   }

   static final void method880(byte b) {
      ++anInt11106;
      synchronized(Class158.aClient1983) {
         if (DrawableModel.aFrame907 != null) {
            return;
         }

         Container container;
         if (Node_Sub29.aFrame7344 == null) {
            if (Class96.anApplet1270 != null) {
               container = Class96.anApplet1270;
            } else {
               container = Class82.aGameStub1123;
            }
         } else {
            container = Node_Sub29.aFrame7344;
         }

         Class36.anInt542 = container.getSize().width;
         CacheNode_Sub3.anInt9441 = container.getSize().height;
         if (container == Node_Sub29.aFrame7344) {
            Insets insets = Node_Sub29.aFrame7344.getInsets();
            CacheNode_Sub3.anInt9441 -= insets.top + insets.bottom;
            Class36.anInt542 -= insets.right + insets.left;
         }

         if (Class188_Sub2_Sub1.getDisplayMode(b + -8) != 1) {
            Class170.method1789(-64);
         } else {
            Class131.canvasOffsetY = 0;
            Class205.canvasHeight = Class257.anInt3244;
            Class270_Sub1.canvasOffsetX = (-Node_Sub38_Sub12.anInt10225 + Class36.anInt542) / 2;
            Class360.canvasWidth = Node_Sub38_Sub12.anInt10225;
         }

         if (Node_Sub38_Sub1.aClass329_10086 != Class240.aClass329_2943 && Class360.canvasWidth < 1024) {
            ;
         }

         Node_Sub38_Sub20.GAME_CANVAS.setSize(Class360.canvasWidth, Class205.canvasHeight);
         if (Class93.aGraphicsToolkit1241 != null) {
            if (!Class71.aBoolean967) {
               Class93.aGraphicsToolkit1241.a(Node_Sub38_Sub20.GAME_CANVAS, Class360.canvasWidth, Class205.canvasHeight);
            } else {
               Index.method3535(Node_Sub38_Sub20.GAME_CANVAS, true);
            }
         }

         if (container != Node_Sub29.aFrame7344) {
            Node_Sub38_Sub20.GAME_CANVAS.setLocation(Class270_Sub1.canvasOffsetX, Class131.canvasOffsetY);
         } else {
            Insets insets = Node_Sub29.aFrame7344.getInsets();
            Node_Sub38_Sub20.GAME_CANVAS.setLocation(insets.left - -Class270_Sub1.canvasOffsetX, insets.top + Class131.canvasOffsetY);
         }

         if (~Class320_Sub15.WINDOWS_PANE_ID != 0) {
            Node_Sub29_Sub3.method2717(1, true);
         }

         Node_Sub36_Sub1.method2758(100);
      }

      if (b != 11) {
         aClass336_11113 = null;
      }
   }

   private final boolean method881(int i) {
      ++anInt11120;
      return this.definitions.showOnMinimap;
   }

   @Override
   final int method818(byte b) {
      ++anInt11098;
      return this.definitions == null ? 0 : this.definitions.registerClickRadius;
   }
}
