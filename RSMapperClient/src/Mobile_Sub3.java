public class Mobile_Sub3 extends Mobile implements WorldObject {
   static int anInt10768;
   static int anInt10769;
   static int anInt10770;
   static int anInt10771;
   static int anInt10772;
   static int anInt10773;
   private Class171 aClass171_10774;
   static int anInt10775;
   static int anInt10776;
   protected Class310 aClass310_10777;
   static IncommingPacket aClass192_10778 = new IncommingPacket(12, -2);
   static int anInt10779;
   private boolean aBoolean10780;
   static int anInt10781;
   static int anInt10782;
   static int anInt10783;
   static int anInt10784 = 0;
   static int anInt10785;
   private boolean aBoolean10786 = true;
   static int anInt10787;
   static int anInt10788;
   static int anInt10789;
   static int anInt10790;
   static int anInt10791;
   static int anInt10792;

   public static void method905(byte b) {
      aClass192_10778 = null;
      if (b <= 88) {
         anInt10784 = 44;
      }
   }

   @Override
   final void method816(int i, boolean bool, GraphicsToolkit graphicstoolkit, int i_0_, byte b, int i_1_, Animable animable) {
      if (b < 101) {
         aClass192_10778 = null;
      }

      ++anInt10789;
      throw new IllegalStateException();
   }

   @Override
   final boolean method810(int i, int i_2_, boolean bool, GraphicsToolkit graphicstoolkit) {
      ++anInt10781;
      DrawableModel drawablemodel = this.aClass310_10777.method3597(graphicstoolkit, false, true, bool, 131072);
      if (drawablemodel == null) {
         return false;
      } else {
         Class336 class336 = graphicstoolkit.A();
         class336.method3854(this.x, this.anInt5937, this.y);
         return Node_Sub15_Sub10.aBoolean9850
            ? drawablemodel.method621(i_2_, i, class336, false, 0, Class308.anInt3912)
            : drawablemodel.method624(i_2_, i, class336, false, 0);
      }
   }

   @Override
   final EntityNode_Sub6 method807(int i, GraphicsToolkit graphicstoolkit) {
      ++anInt10783;
      DrawableModel drawablemodel = this.aClass310_10777.method3597(graphicstoolkit, false, true, true, 2048);
      if (drawablemodel == null) {
         return null;
      } else {
         Class336 class336 = graphicstoolkit.A();
         class336.method3854(this.x, this.anInt5937, this.y);
         EntityNode_Sub6 entitynode_sub6 = Class345.method3972(this.aBoolean10780, (byte)116, 1);
         this.aClass310_10777
            .method3600(this.aShort9124, drawablemodel, true, -9827, graphicstoolkit, this.aShort9130, this.aShort9119, this.aShort9120, class336);
         if (Node_Sub15_Sub10.aBoolean9850) {
            drawablemodel.method622(class336, entitynode_sub6.anEntityNode_Sub5Array5995[0], Class308.anInt3912, 0);
         } else {
            drawablemodel.method611(class336, entitynode_sub6.anEntityNode_Sub5Array5995[0], 0);
         }

         if (this.aClass310_10777.anEntityNode_Sub4_3931 != null) {
            Class198 class198 = this.aClass310_10777.anEntityNode_Sub4_3931.method954();
            if (Node_Sub15_Sub10.aBoolean9850) {
               graphicstoolkit.a(class198, Class308.anInt3912);
            } else {
               graphicstoolkit.a(class198);
            }
         }

         this.aBoolean10786 = drawablemodel.F() || this.aClass310_10777.anEntityNode_Sub4_3931 != null;
         if (this.aClass171_10774 != null) {
            Animator.method239(drawablemodel, this.y, this.anInt5937, this.x, this.aClass171_10774, -107);
         } else {
            this.aClass171_10774 = Class167.method1752(0, this.anInt5937, this.x, drawablemodel, this.y);
         }

         return entitynode_sub6;
      }
   }

   @Override
   final boolean method813(int i) {
      ++anInt10769;
      if (i != 0) {
         this.aClass171_10774 = null;
      }

      return this.aBoolean10786;
   }

   @Override
   public final int getRotation(int i) {
      ++anInt10775;
      if (i != 23796) {
         this.aBoolean10780 = false;
      }

      return this.aClass310_10777.anInt3951;
   }

   @Override
   public final boolean method73(int i) {
      if (i != -19717) {
         this.aBoolean10780 = false;
      }

      ++anInt10779;
      return this.aClass310_10777.method3594(i ^ -19727);
   }

   @Override
   final boolean method821(int i) {
      if (i != 0) {
         return false;
      } else {
         ++anInt10768;
         return false;
      }
   }

   @Override
   final void method820(GraphicsToolkit graphicstoolkit, int i) {
      ++anInt10782;
      DrawableModel drawablemodel = this.aClass310_10777.method3597(graphicstoolkit, true, true, true, 262144);
      if (i == -5 && drawablemodel != null) {
         Class336 class336 = graphicstoolkit.A();
         class336.method3854(this.x, this.anInt5937, this.y);
         this.aClass310_10777
            .method3600(this.aShort9124, drawablemodel, false, -9827, graphicstoolkit, this.aShort9130, this.aShort9119, this.aShort9120, class336);
      }
   }

   @Override
   public final int getType(int i) {
      ++anInt10773;
      return this.aClass310_10777.anInt3926;
   }

   @Override
   public final int getId(int i) {
      if (i != -32136) {
         this.aClass310_10777 = null;
      }

      ++anInt10772;
      return this.aClass310_10777.anInt3933;
   }

   @Override
   final Class171 method809(GraphicsToolkit graphicstoolkit, int i) {
      if (i >= -93) {
         this.aClass310_10777 = null;
      }

      ++anInt10791;
      return this.aClass171_10774;
   }

   @Override
   final void method811(int i) {
      if (i != 27811) {
         this.aBoolean10780 = false;
      }

      ++anInt10790;
      throw new IllegalStateException();
   }

   final void method906(int i, Class121 class121) {
      ++anInt10771;
      this.aClass310_10777.method3598(class121, -12);
   }

   @Override
   final boolean method814(byte b) {
      ++anInt10787;
      return false;
   }

   @Override
   public final void method70(GraphicsToolkit graphicstoolkit, int i) {
      if (i >= -42) {
         this.method816(72, true, null, -2, (byte)37, -105, null);
      }

      this.aClass310_10777.method3588(graphicstoolkit, (byte)16);
      ++anInt10792;
   }

   @Override
   final int method823(byte b) {
      ++anInt10776;
      if (b != -21) {
         this.aBoolean10780 = true;
      }

      return this.aClass310_10777.method3592(true);
   }

   Mobile_Sub3(
      GraphicsToolkit graphicstoolkit,
      ObjectDefinition objectdefinition,
      int i,
      int i_6_,
      int i_7_,
      int i_8_,
      int i_9_,
      boolean bool,
      int i_10_,
      int i_11_,
      int i_12_,
      int i_13_,
      int i_14_,
      int i_15_,
      int i_16_
   ) {
      super(i, i_6_, i_7_, i_8_, i_9_, i_10_, i_11_, i_12_, i_13_, objectdefinition.anInt2970 == 1, PlayerUpdateReference.method3810(i_14_, false, i_15_));
      this.aClass310_10777 = new Class310(graphicstoolkit, objectdefinition, i_14_, i_15_, this.plane, i_6_, this, bool, i_16_);
      this.aBoolean10780 = ~objectdefinition.anInt3057 != -1 && !bool;
   }

   @Override
   public final void method74(GraphicsToolkit graphicstoolkit, int i) {
      ++anInt10770;
      if (i > -46) {
         this.method69(-83);
      }

      this.aClass310_10777.method3587(graphicstoolkit, 262144);
   }

   @Override
   public final void method69(int i) {
      ++anInt10788;
   }

   @Override
   final int method817(int i) {
      if (i != 2) {
         this.aClass171_10774 = null;
      }

      ++anInt10785;
      return this.aClass310_10777.method3590((byte)-112);
   }
}
