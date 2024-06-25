public class Animable_Sub1_Sub2 extends Animable_Sub1 implements WorldObject {
   static int anInt10648;
   static boolean aBoolean10649 = false;
   static int anInt10650;
   static int anInt10651;
   protected Class310 aClass310_10652;
   static int anInt10653;
   static int anInt10654;
   static int anInt10655;
   static int anInt10656;
   static int anInt10657;
   private boolean aBoolean10658 = true;
   static int anInt10659;
   static int anInt10660;
   private Class171 aClass171_10661;
   static int anInt10662;
   static int anInt10663;
   static int anInt10664;
   static int anInt10665;
   static int anInt10666;
   static int anInt10667;
   static int anInt10668;
   static int anInt10669;
   static int anInt10670;
   static int anInt10671;
   private boolean aBoolean10672;

   @Override
   final boolean method810(int i, int i_0_, boolean bool, GraphicsToolkit graphicstoolkit) {
      ++anInt10665;
      DrawableModel drawablemodel = this.aClass310_10652.method3597(graphicstoolkit, false, true, bool, 131072);
      if (drawablemodel == null) {
         return false;
      } else {
         Class336 class336 = graphicstoolkit.A();
         class336.method3854(this.x, this.anInt5937, this.y);
         return Node_Sub15_Sub10.aBoolean9850
            ? drawablemodel.method621(i_0_, i, class336, false, 0, Class308.anInt3912)
            : drawablemodel.method624(i_0_, i, class336, false, 0);
      }
   }

   @Override
   final boolean method821(int i) {
      if (i != 0) {
         this.aClass171_10661 = null;
      }

      ++anInt10671;
      return false;
   }

   @Override
   final void method820(GraphicsToolkit graphicstoolkit, int i) {
      if (i != -5) {
         this.method833(null, -120);
      }

      ++anInt10653;
      DrawableModel drawablemodel = this.aClass310_10652.method3597(graphicstoolkit, true, true, true, 262144);
      if (drawablemodel != null) {
         int i_1_ = this.x >> 9;
         int i_2_ = this.y >> 9;
         Class336 class336 = graphicstoolkit.A();
         class336.method3854(this.x, this.anInt5937, this.y);
         this.aClass310_10652.method3600(i_2_, drawablemodel, false, -9827, graphicstoolkit, i_1_, i_1_, i_2_, class336);
      }
   }

   final void method833(Class121 class121, int i) {
      this.aClass310_10652.method3598(class121, -12);
      if (i > -59) {
         this.method810(-55, -88, true, null);
      }

      ++anInt10655;
   }

   @Override
   public final void method70(GraphicsToolkit graphicstoolkit, int i) {
      this.aClass310_10652.method3588(graphicstoolkit, (byte)16);
      if (i > -42) {
         this.method813(-38);
      }

      ++anInt10670;
   }

   @Override
   public final void method74(GraphicsToolkit graphicstoolkit, int i) {
      this.aClass310_10652.method3587(graphicstoolkit, 262144);
      if (i < -46) {
         ++anInt10662;
      }
   }

   @Override
   final void method816(int i, boolean bool, GraphicsToolkit graphicstoolkit, int i_3_, byte b, int i_4_, Animable animable) {
      if (b < 101) {
         this.aBoolean10658 = true;
      }

      ++anInt10667;
      throw new IllegalStateException();
   }

   @Override
   public final int getId(int i) {
      if (i != -32136) {
         this.method813(69);
      }

      ++anInt10660;
      return this.aClass310_10652.anInt3933;
   }

   @Override
   final boolean method814(byte b) {
      ++anInt10651;
      return false;
   }

   @Override
   final Class171 method809(GraphicsToolkit graphicstoolkit, int i) {
      if (i >= -93) {
         aBoolean10649 = true;
      }

      ++anInt10666;
      return this.aClass171_10661;
   }

   @Override
   final int method817(int i) {
      ++anInt10648;
      if (i != 2) {
         this.method70(null, 33);
      }

      return this.aClass310_10652.method3590((byte)-112);
   }

   @Override
   public final boolean method73(int i) {
      if (i != -19717) {
         this.aClass310_10652 = null;
      }

      ++anInt10663;
      return this.aClass310_10652.method3594(i + 19727);
   }

   @Override
   final void method811(int i) {
      if (i != 27811) {
         this.method73(81);
      }

      ++anInt10650;
      throw new IllegalStateException();
   }

   Animable_Sub1_Sub2(
      GraphicsToolkit graphicstoolkit, ObjectDefinition objectdefinition, int i, int i_5_, int i_6_, int i_7_, int i_8_, boolean bool, int i_9_, int i_10_
   ) {
      super(i_6_, i_7_, i_8_, i, i_5_, objectdefinition.standingOnHeightOffset);
      this.aClass310_10652 = new Class310(graphicstoolkit, objectdefinition, 22, i_9_, i, i_5_, this, bool, i_10_);
      this.aBoolean10672 = ~objectdefinition.anInt3057 != -1 && !bool;
   }

   @Override
   final EntityNode_Sub6 method807(int i, GraphicsToolkit graphicstoolkit) {
      ++anInt10654;
      DrawableModel drawablemodel = this.aClass310_10652.method3597(graphicstoolkit, false, true, true, 2048);
      if (drawablemodel == null) {
         return null;
      } else {
         Class336 class336 = graphicstoolkit.A();
         class336.method3854(this.x, this.anInt5937, this.y);
         EntityNode_Sub6 entitynode_sub6 = Class345.method3972(this.aBoolean10672, (byte)105, 1);
         int i_12_ = this.x >> 9;
         int i_13_ = this.y >> 9;
         this.aClass310_10652.method3600(i_13_, drawablemodel, true, -9827, graphicstoolkit, i_12_, i_12_, i_13_, class336);
         if (!Node_Sub15_Sub10.aBoolean9850) {
            drawablemodel.method611(class336, entitynode_sub6.anEntityNode_Sub5Array5995[0], 0);
         } else {
            drawablemodel.method622(class336, entitynode_sub6.anEntityNode_Sub5Array5995[0], Class308.anInt3912, 0);
         }

         if (this.aClass310_10652.anEntityNode_Sub4_3931 != null) {
            Class198 class198 = this.aClass310_10652.anEntityNode_Sub4_3931.method954();
            if (!Node_Sub15_Sub10.aBoolean9850) {
               graphicstoolkit.a(class198);
            } else {
               graphicstoolkit.a(class198, Class308.anInt3912);
            }
         }

         this.aBoolean10658 = drawablemodel.F() || this.aClass310_10652.anEntityNode_Sub4_3931 != null;
         if (this.aClass171_10661 != null) {
            Animator.method239(drawablemodel, this.y, this.anInt5937, this.x, this.aClass171_10661, -98);
         } else {
            this.aClass171_10661 = Class167.method1752(0, this.anInt5937, this.x, drawablemodel, this.y);
         }

         return entitynode_sub6;
      }
   }

   @Override
   public final int getRotation(int i) {
      ++anInt10669;
      if (i != 23796) {
         aBoolean10649 = false;
      }

      return this.aClass310_10652.anInt3951;
   }

   @Override
   final int method823(byte b) {
      if (b != -21) {
         this.aBoolean10658 = true;
      }

      ++anInt10657;
      return this.aClass310_10652.method3592(true);
   }

   @Override
   final boolean method813(int i) {
      ++anInt10664;
      return i != 0 ? true : this.aBoolean10658;
   }

   @Override
   public final int getType(int i) {
      ++anInt10659;
      return this.aClass310_10652.anInt3926;
   }

   @Override
   public final void method69(int i) {
      ++anInt10656;
   }
}
