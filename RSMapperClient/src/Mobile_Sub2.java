public class Mobile_Sub2 extends Mobile implements WorldObject {
   static int anInt10704;
   static int anInt10705;
   static int anInt10706;
   static int anInt10707;
   static int anInt10708;
   static int anInt10709;
   static int anInt10710;
   private Class171 aClass171_10711;
   static int anInt10712;
   static int anInt10713;
   private boolean aBoolean10714;
   static int anInt10715;
   static int anInt10716;
   static int anInt10717;
   private r aR10718;
   private boolean aBoolean10719;
   static int anInt10720;
   private boolean aBoolean10721;
   static int anInt10722 = 0;
   static int anInt10723;
   protected DrawableModel aDrawableModel10724;
   private byte objectRotation;
   static int anInt10726;
   static int anInt10727;
   static int anInt10728;
   private boolean aBoolean10729;
   static int anInt10730;
   private byte objectType;
   static int anInt10732;
   static int anInt10733;
   private int objectId;
   static int anInt10735;

   @Override
   public final void method69(int i) {
      if (this.aDrawableModel10724 != null) {
         this.aDrawableModel10724.method617();
      }

      ++anInt10705;
   }

   @Override
   public final void method70(GraphicsToolkit graphicstoolkit, int i) {
      ++anInt10715;
      r var_r;
      if (this.aR10718 == null && this.aBoolean10714) {
         Class243 class243 = this.method904(graphicstoolkit, (byte)102, true, 262144);
         var_r = class243 != null ? class243.aR3072 : null;
      } else {
         var_r = this.aR10718;
         this.aR10718 = null;
      }

      if (var_r != null) {
         Node_Sub23.method2636(var_r, this.aByte5931, this.x, this.y, null);
      }

      if (i > -42) {
         this.aDrawableModel10724 = null;
      }
   }

   @Override
   public final boolean method73(int i) {
      if (i != -19717) {
         this.aClass171_10711 = null;
      }

      ++anInt10707;
      return this.aBoolean10714;
   }

   @Override
   final boolean method814(byte b) {
      ++anInt10710;
      if (this.aDrawableModel10724 != null) {
         return !this.aDrawableModel10724.r();
      } else {
         return true;
      }
   }

   @Override
   final int method817(int i) {
      ++anInt10704;
      if (i != 2) {
         this.method814((byte)111);
      }

      return this.aDrawableModel10724 != null ? this.aDrawableModel10724.fa() : 0;
   }

   @Override
   final boolean method821(int i) {
      ++anInt10720;
      if (i != 0) {
         this.method811(61);
      }

      return this.aBoolean10729;
   }

   final DrawableModel method902(byte b, GraphicsToolkit graphicstoolkit, int i) {
      if (b != 69) {
         this.aBoolean10729 = true;
      }

      ++anInt10713;
      if (this.aDrawableModel10724 != null && graphicstoolkit.b(this.aDrawableModel10724.ua(), i) == 0) {
         return this.aDrawableModel10724;
      } else {
         Class243 class243 = this.method904(graphicstoolkit, (byte)118, false, i);
         return class243 != null ? class243.aDrawableModel3064 : null;
      }
   }

   @Override
   public final int getId(int i) {
      ++anInt10732;
      if (i != -32136) {
         anInt10722 = -2;
      }

      return this.objectId;
   }

   @Override
   final boolean method810(int i, int i_1_, boolean bool, GraphicsToolkit graphicstoolkit) {
      ++anInt10727;
      DrawableModel drawablemodel = this.method902((byte)69, graphicstoolkit, 131072);
      if (drawablemodel != null) {
         Class336 class336 = graphicstoolkit.A();
         class336.method3854(this.x, this.anInt5937, this.y);
         return !Node_Sub15_Sub10.aBoolean9850
            ? drawablemodel.method624(i_1_, i, class336, false, 0)
            : drawablemodel.method621(i_1_, i, class336, false, 0, Class308.anInt3912);
      } else {
         return bool ? false : false;
      }
   }

   @Override
   final void method811(int i) {
      this.aBoolean10729 = false;
      if (i != 27811) {
         this.aClass171_10711 = null;
      }

      ++anInt10708;
      if (this.aDrawableModel10724 != null) {
         this.aDrawableModel10724.s(-65537 & this.aDrawableModel10724.ua());
      }
   }

   @Override
   public final int getType(int i) {
      ++anInt10730;
      return this.objectType;
   }

   final int method903(int i) {
      ++anInt10706;
      if (i >= -20) {
         anInt10722 = 47;
      }

      return this.aDrawableModel10724 == null ? 15 : this.aDrawableModel10724.na() / 4;
   }

   @Override
   final Class171 method809(GraphicsToolkit graphicstoolkit, int i) {
      if (i > -93) {
         return null;
      } else {
         if (this.aClass171_10711 == null) {
            this.aClass171_10711 = Class167.method1752(0, this.anInt5937, this.x, this.method902((byte)69, graphicstoolkit, 0), this.y);
         }

         ++anInt10728;
         return this.aClass171_10711;
      }
   }

   @Override
   public final void method74(GraphicsToolkit graphicstoolkit, int i) {
      ++anInt10723;
      if (i < -46) {
         r var_r;
         if (this.aR10718 == null && this.aBoolean10714) {
            Class243 class243 = this.method904(graphicstoolkit, (byte)101, true, 262144);
            var_r = class243 != null ? class243.aR3072 : null;
         } else {
            var_r = this.aR10718;
            this.aR10718 = null;
         }

         if (var_r != null) {
            Class320_Sub30.method3797(var_r, this.aByte5931, this.x, this.y, null);
         }
      }
   }

   @Override
   final int method823(byte b) {
      ++anInt10712;
      if (b != -21) {
         return -59;
      } else {
         return this.aDrawableModel10724 != null ? this.aDrawableModel10724.ma() : 0;
      }
   }

   @Override
   final void method820(GraphicsToolkit graphicstoolkit, int i) {
      if (i == -5) {
         ++anInt10733;
      }
   }

   Mobile_Sub2(
      GraphicsToolkit graphicstoolkit,
      ObjectDefinition objectdefinition,
      int i,
      int i_3_,
      int i_4_,
      int i_5_,
      int i_6_,
      boolean bool,
      int i_7_,
      int i_8_,
      int i_9_,
      int i_10_,
      int type,
      int rotation,
      boolean bool_13_
   ) {
      super(i, i_3_, i_4_, i_5_, i_6_, i_7_, i_8_, i_9_, i_10_, objectdefinition.anInt2970 == 1, Class320_Sub7.method3707(type, (byte)125, rotation));
      this.aBoolean10721 = objectdefinition.anInt3057 != 0 && !bool;
      this.aBoolean10719 = bool;
      this.objectRotation = (byte)rotation;
      this.objectId = objectdefinition.objectId;
      this.objectType = (byte)type;
      this.aByte5931 = (byte)i_3_;
      this.aBoolean10729 = bool_13_;
      this.aBoolean10714 = graphicstoolkit.r()
         && objectdefinition.hasShadow
         && !this.aBoolean10719
         && Class213.aNode_Sub27_2512.aClass320_Sub12_7282.method3730(false) != 0;
      int i_14_ = 2048;
      if (this.aBoolean10729) {
         i_14_ |= 65536;
      }

      Class243 class243 = this.method904(graphicstoolkit, (byte)57, this.aBoolean10714, i_14_);
      if (class243 != null) {
         this.aDrawableModel10724 = class243.aDrawableModel3064;
         this.aR10718 = class243.aR3072;
         if (this.aBoolean10729) {
            this.aDrawableModel10724 = this.aDrawableModel10724.method633((byte)0, i_14_, false);
         }
      }
   }

   @Override
   final boolean method813(int i) {
      ++anInt10709;
      if (i != 0) {
         this.aR10718 = null;
      }

      return this.aDrawableModel10724 != null ? this.aDrawableModel10724.F() : false;
   }

   @Override
   final EntityNode_Sub6 method807(int i, GraphicsToolkit graphicstoolkit) {
      ++anInt10726;
      if (this.aDrawableModel10724 == null) {
         return null;
      } else {
         Class336 class336 = graphicstoolkit.A();
         class336.method3854(this.x, this.anInt5937, this.y);
         EntityNode_Sub6 entitynode_sub6 = Class345.method3972(this.aBoolean10721, (byte)95, 1);
         if (!Node_Sub15_Sub10.aBoolean9850) {
            this.aDrawableModel10724.method611(class336, entitynode_sub6.anEntityNode_Sub5Array5995[0], 0);
         } else {
            this.aDrawableModel10724.method622(class336, entitynode_sub6.anEntityNode_Sub5Array5995[0], Class308.anInt3912, 0);
         }

         return entitynode_sub6;
      }
   }

   @Override
   final void method816(int i, boolean bool, GraphicsToolkit graphicstoolkit, int i_16_, byte b, int i_17_, Animable animable) {
      ++anInt10717;
      if (!(animable instanceof Animable_Sub2_Sub2)) {
         if (animable instanceof Mobile_Sub2) {
            Mobile_Sub2 mobile_sub2_18_ = (Mobile_Sub2)animable;
            if (this.aDrawableModel10724 != null && mobile_sub2_18_.aDrawableModel10724 != null) {
               this.aDrawableModel10724.method619(mobile_sub2_18_.aDrawableModel10724, i_17_, i, i_16_, bool);
            }
         }
      } else {
         Animable_Sub2_Sub2 animable_sub2_sub2 = (Animable_Sub2_Sub2)animable;
         if (this.aDrawableModel10724 != null && animable_sub2_sub2.aDrawableModel10756 != null) {
            this.aDrawableModel10724.method619(animable_sub2_sub2.aDrawableModel10756, i_17_, i, i_16_, bool);
         }
      }

      if (b <= 101) {
         this.method809(null, -1);
      }
   }

   private final Class243 method904(GraphicsToolkit graphicstoolkit, byte b, boolean bool, int i) {
      ++anInt10735;
      ObjectDefinition objectdefinition = Class186.aClass112_2256.getObjectDefinitionsForId(this.objectId, 73);
      if (b < 7) {
         this.method811(111);
      }

      Plane plane;
      Plane plane_19_;
      if (!this.aBoolean10719) {
         plane = Node_Sub38_Sub37.aPlaneArray10466[this.aByte5931];
         if (this.aByte5931 >= 3) {
            plane_19_ = null;
         } else {
            plane_19_ = Node_Sub38_Sub37.aPlaneArray10466[1 + this.aByte5931];
         }
      } else {
         plane = Class368.aPlaneArray4548[this.aByte5931];
         plane_19_ = Node_Sub38_Sub37.aPlaneArray10466[0];
      }

      return objectdefinition.method3046(
         this.objectType == 11 ? this.objectRotation + 4 : this.objectRotation,
         this.y,
         this.x,
         plane,
         bool,
         (byte)0,
         this.anInt5937,
         ~this.objectType != -12 ? this.objectType : 10,
         graphicstoolkit,
         null,
         i,
         plane_19_
      );
   }

   @Override
   public final int getRotation(int i) {
      if (i != 23796) {
         return -53;
      } else {
         ++anInt10716;
         return this.objectRotation;
      }
   }
}
