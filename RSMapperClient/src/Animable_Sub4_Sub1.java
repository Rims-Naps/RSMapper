public class Animable_Sub4_Sub1 extends Animable_Sub4 implements WorldObject {
   private boolean aBoolean10673;
   static int anInt10674;
   static int anInt10675;
   private r aR10676;
   private int aShort10677;
   static int anInt10678;
   static int anInt10679;
   static int anInt10680;
   static int anInt10681;
   static int anInt10682;
   static int anInt10683;
   private boolean aBoolean10684;
   static int anInt10685;
   private byte aByte10686;
   static int anInt10687 = -1;
   static int anInt10688;
   static int anInt10689;
   static int anInt10690;
   static int anInt10691;
   static int anInt10692;
   static int anInt10693;
   static int anInt10694;
   static int anInt10695;
   private DrawableModel aDrawableModel10696;
   static int anInt10697;
   private byte aByte10698;
   static int anInt10699;
   static int anInt10700;
   private Class171 aClass171_10701;
   private boolean aBoolean10702;
   static int anInt10703;

   @Override
   public final int getRotation(int i) {
      if (i != 23796) {
         this.getType(-18);
      }

      ++anInt10679;
      return this.aByte10698;
   }

   static final void method927(int i, int i_0_, int i_1_, OutgoingPacketBuffer node_sub13, int i_2_) {
      ++anInt10681;
      node_sub13.currentOutgoingPacket.writeIntV2(i);
      node_sub13.currentOutgoingPacket.writeShortLE128(i_0_);
      node_sub13.currentOutgoingPacket.writeShort(i_2_);
   }

   private final DrawableModel method928(int i, int i_4_, GraphicsToolkit graphicstoolkit) {
      ++anInt10695;
      if (this.aDrawableModel10696 != null && graphicstoolkit.b(this.aDrawableModel10696.ua(), i) == 0) {
         return this.aDrawableModel10696;
      } else {
         if (i_4_ != 25524) {
            this.method820(null, -111);
         }

         Class243 class243 = this.method932((byte)24, graphicstoolkit, i, false);
         return class243 == null ? null : class243.aDrawableModel3064;
      }
   }

   @Override
   public final void method69(int i) {
      ++anInt10692;
      if (this.aDrawableModel10696 != null) {
         this.aDrawableModel10696.method617();
      }
   }

   @Override
   final int method817(int i) {
      ++anInt10683;
      if (i != 2) {
         this.aDrawableModel10696 = null;
      }

      return this.aDrawableModel10696 != null ? this.aDrawableModel10696.fa() : 0;
   }

   static final long method929(WorldObject interface19, int i, int i_6_, boolean bool) {
      ++anInt10694;
      long l = 4194304L;
      if (!bool) {
         method927(-86, -65, -50, null, 40);
      }

      long l_7_ = Long.MIN_VALUE;
      ObjectDefinition objectdefinition = Class186.aClass112_2256.getObjectDefinitionsForId(interface19.getId(-32136), 44);
      long l_8_ = (long)(i_6_ | i << 7 | interface19.getType(-126) << 14 | interface19.getRotation(23796) << 20 | 1073741824);
      if (objectdefinition.anInt3057 == 0) {
         l_8_ |= l_7_;
      }

      if (~objectdefinition.anInt2970 == -2) {
         l_8_ |= l;
      }

      return l_8_ | (long)interface19.getId(-32136) << 32;
   }

   @Override
   public final boolean method73(int i) {
      ++anInt10690;
      return i != -19717 ? true : this.aBoolean10684;
   }

   @Override
   final boolean method810(int i, int i_9_, boolean bool, GraphicsToolkit graphicstoolkit) {
      ++anInt10703;
      if (bool) {
         this.method70(null, 39);
      }

      DrawableModel drawablemodel = this.method928(131072, 25524, graphicstoolkit);
      if (drawablemodel != null) {
         Class336 class336 = graphicstoolkit.A();
         class336.method3854(this.x, this.anInt5937, this.y);
         return !Node_Sub15_Sub10.aBoolean9850
            ? drawablemodel.method624(i_9_, i, class336, false, 0)
            : drawablemodel.method621(i_9_, i, class336, false, 0, Class308.anInt3912);
      } else {
         return false;
      }
   }

   @Override
   final Class171 method809(GraphicsToolkit graphicstoolkit, int i) {
      if (i >= -93) {
         this.getRotation(-71);
      }

      ++anInt10685;
      if (this.aClass171_10701 == null) {
         this.aClass171_10701 = Class167.method1752(0, this.anInt5937, this.x, this.method928(0, 25524, graphicstoolkit), this.y);
      }

      return this.aClass171_10701;
   }

   static final boolean method930(int i, char c) {
      if (i != -31853) {
         anInt10687 = -94;
      }

      ++anInt10680;
      return ~c <= -49 && c <= '9';
   }

   @Override
   public final void method74(GraphicsToolkit graphicstoolkit, int i) {
      ++anInt10689;
      if (i >= -46) {
         this.getRotation(22);
      }

      r var_r;
      if (this.aR10676 == null && this.aBoolean10684) {
         Class243 class243 = this.method932((byte)24, graphicstoolkit, 262144, true);
         var_r = class243 != null ? class243.aR3072 : null;
      } else {
         var_r = this.aR10676;
         this.aR10676 = null;
      }

      if (var_r != null) {
         Class320_Sub30.method3797(var_r, this.aByte5931, this.x, this.y, null);
      }
   }

   @Override
   final void method820(GraphicsToolkit graphicstoolkit, int i) {
      if (i != -5) {
         this.aByte10698 = 89;
      }

      ++anInt10700;
   }

   @Override
   final boolean method813(int i) {
      ++anInt10693;
      if (i != 0) {
         return false;
      } else {
         return this.aDrawableModel10696 == null ? false : this.aDrawableModel10696.F();
      }
   }

   @Override
   public final void method70(GraphicsToolkit graphicstoolkit, int i) {
      ++anInt10699;
      r var_r;
      if (this.aR10676 == null && this.aBoolean10684) {
         Class243 class243 = this.method932((byte)24, graphicstoolkit, 262144, true);
         var_r = class243 == null ? null : class243.aR3072;
      } else {
         var_r = this.aR10676;
         this.aR10676 = null;
      }

      if (i < -42 && var_r != null) {
         Node_Sub23.method2636(var_r, this.aByte5931, this.x, this.y, null);
      }
   }

   @Override
   public final int getId(int i) {
      if (i != -32136) {
         return 109;
      } else {
         ++anInt10688;
         return this.aShort10677;
      }
   }

   Animable_Sub4_Sub1(
      GraphicsToolkit graphicstoolkit,
      ObjectDefinition objectdefinition,
      int i,
      int i_10_,
      int i_11_,
      int i_12_,
      int i_13_,
      boolean bool,
      int i_14_,
      int i_15_,
      int i_16_,
      int i_17_
   ) {
      super(i_11_, i_12_, i_13_, i, i_10_, i_14_, i_15_);
      this.y = i_13_;
      this.aShort10677 = objectdefinition.objectId;
      this.aByte10698 = (byte)i_17_;
      this.x = i_11_;
      this.aByte10686 = (byte)i_16_;
      this.aBoolean10702 = ~objectdefinition.anInt3057 != -1 && !bool;
      this.aBoolean10673 = bool;
      this.aBoolean10684 = graphicstoolkit.r()
         && objectdefinition.hasShadow
         && !this.aBoolean10673
         && ~Class213.aNode_Sub27_2512.aClass320_Sub12_7282.method3730(false) != -1;
      Class243 class243 = this.method932((byte)24, graphicstoolkit, 2048, this.aBoolean10684);
      if (class243 != null) {
         this.aDrawableModel10696 = class243.aDrawableModel3064;
         this.aR10676 = class243.aR3072;
      }
   }

   static final boolean method931(int i, boolean bool, int i_18_) {
      ++anInt10674;
      if (!bool) {
         method930(122, '.');
      }

      return (2048 & i) != 0;
   }

   @Override
   final boolean method814(byte b) {
      ++anInt10697;
      if (this.aDrawableModel10696 == null) {
         return true;
      } else {
         return !this.aDrawableModel10696.r();
      }
   }

   private final Class243 method932(byte b, GraphicsToolkit graphicstoolkit, int i, boolean bool) {
      if (b != 24) {
         return null;
      } else {
         ++anInt10678;
         ObjectDefinition objectdefinition = Class186.aClass112_2256.getObjectDefinitionsForId(this.aShort10677, 42);
         Plane plane;
         Plane plane_19_;
         if (this.aBoolean10673) {
            plane_19_ = Node_Sub38_Sub37.aPlaneArray10466[0];
            plane = Class368.aPlaneArray4548[this.aByte5931];
         } else {
            plane = Node_Sub38_Sub37.aPlaneArray10466[this.aByte5931];
            if (this.aByte5931 < 3) {
               plane_19_ = Node_Sub38_Sub37.aPlaneArray10466[1 + this.aByte5931];
            } else {
               plane_19_ = null;
            }
         }

         return objectdefinition.method3046(
            this.aByte10698, this.y, this.x, plane, bool, (byte)0, this.anInt5937, this.aByte10686, graphicstoolkit, null, i, plane_19_
         );
      }
   }

   @Override
   public final int getType(int i) {
      ++anInt10675;
      return this.aByte10686;
   }

   @Override
   final EntityNode_Sub6 method807(int i, GraphicsToolkit graphicstoolkit) {
      ++anInt10682;
      if (this.aDrawableModel10696 == null) {
         return null;
      } else {
         Class336 class336 = graphicstoolkit.A();
         class336.method3854(this.x - -this.aShort9145, this.anInt5937, this.aShort9147 + this.y);
         EntityNode_Sub6 entitynode_sub6 = Class345.method3972(this.aBoolean10702, (byte)111, 1);
         if (!Node_Sub15_Sub10.aBoolean9850) {
            this.aDrawableModel10696.method611(class336, entitynode_sub6.anEntityNode_Sub5Array5995[0], 0);
         } else {
            this.aDrawableModel10696.method622(class336, entitynode_sub6.anEntityNode_Sub5Array5995[0], Class308.anInt3912, 0);
         }

         return entitynode_sub6;
      }
   }

   @Override
   final int method823(byte b) {
      ++anInt10691;
      if (b != -21) {
         this.aByte10686 = 110;
      }

      return this.aDrawableModel10696 != null ? this.aDrawableModel10696.ma() : 0;
   }
}
