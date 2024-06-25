import java.io.File;
import java.io.IOException;

public class WorldItem extends Animable_Sub3 {
   protected int anInt10996;
   static int anInt10997;
   static int anInt10998;
   static int anInt10999;
   static int anInt11000;
   protected int anInt11001;
   private boolean aBoolean11002;
   protected int anInt11003;
   static OutgoingPacket aClass318_11004 = new OutgoingPacket(37, -1);
   protected int anInt11005;
   static int anInt11006;
   protected int anInt11007 = -1;
   static Model[] aModelArray11008 = new Model[4];
   static int anInt11009;
   protected int anInt11010;
   private int anInt11011;
   static int anInt11012 = 0;
   static int anInt11013;
   static float aFloat11014;
   static int anInt11015;
   static int anInt11016;
   static Class234 aClass234_11017;
   static int anInt11018;
   protected int anInt11019;

   public static void method923(int i) {
      aModelArray11008 = null;
      if (i != 7528) {
         method923(100);
      }

      aClass234_11017 = null;
      aClass318_11004 = null;
   }

   @Override
   final int method818(byte b) {
      ++anInt11015;
      ItemDefinitions itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(this.anInt10996);
      int i = itemdefinition.groundInteractRadius;
      if (this.anInt11010 != -1) {
         ItemDefinitions itemdefinition_0_ = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(this.anInt11010);
         if (itemdefinition_0_.groundInteractRadius > i) {
            i = itemdefinition_0_.groundInteractRadius;
         }
      }

      if (~this.anInt11007 != 0) {
         ItemDefinitions itemdefinition_2_ = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(this.anInt11007);
         if (~itemdefinition_2_.groundInteractRadius < ~i) {
            i = itemdefinition_2_.groundInteractRadius;
         }
      }

      return i;
   }

   static final byte[] method924(byte b, File file, int i) {
      ++anInt11006;

      try {
         byte[] bs = new byte[i];
         if (b != 22) {
            method923(82);
         }

         Class150.method1653(file, 127, bs, i);
         return bs;
      } catch (IOException var4) {
         return null;
      }
   }

   @Override
   final boolean method813(int i) {
      ++anInt10997;
      if (i != 0) {
         this.anInt11011 = -87;
      }

      return this.aBoolean11002;
   }

   @Override
   final int method823(byte b) {
      ++anInt10998;
      return b != -21 ? -65 : this.anInt11011;
   }

   @Override
   final void method820(GraphicsToolkit graphicstoolkit, int i) {
      if (i == -5) {
         ++anInt11013;
      }
   }

   @Override
   final Class171 method809(GraphicsToolkit graphicstoolkit, int i) {
      if (i > -93) {
         this.method809(null, 61);
      }

      ++anInt10999;
      return null;
   }

   @Override
   final int method817(int i) {
      if (i != 2) {
         return -14;
      } else {
         ++anInt11016;
         return -10;
      }
   }

   @Override
   final boolean method810(int i, int i_3_, boolean bool, GraphicsToolkit graphicstoolkit) {
      ++anInt11009;
      if (bool) {
         this.method809(null, 104);
      }

      Class336 class336 = graphicstoolkit.A();
      class336.method3854(this.x, this.anInt5937 + -10, this.y);
      ItemDefinitions itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(this.anInt10996);
      DrawableModel drawablemodel = itemdefinition.method1689(null, 131072, null, this.anInt11003, graphicstoolkit, 89);
      if (drawablemodel == null
         || (
            !Node_Sub15_Sub10.aBoolean9850
               ? !drawablemodel.method624(i_3_, i, class336, true, itemdefinition.groundInteractRadius)
               : !drawablemodel.method621(i_3_, i, class336, true, itemdefinition.groundInteractRadius, Class308.anInt3912)
         )) {
         if (~this.anInt11010 != 0) {
            ItemDefinitions itemdefinition_4_ = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(this.anInt11010);
            drawablemodel = itemdefinition_4_.method1689(null, 131072, null, this.anInt11005, graphicstoolkit, 116);
            if (drawablemodel != null
               && (
                  Node_Sub15_Sub10.aBoolean9850
                     ? drawablemodel.method621(i_3_, i, class336, true, itemdefinition_4_.groundInteractRadius, Class308.anInt3912)
                     : drawablemodel.method624(i_3_, i, class336, true, itemdefinition_4_.groundInteractRadius)
               )) {
               return true;
            }
         }

         if (~this.anInt11007 != 0) {
            ItemDefinitions itemdefinition_5_ = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(this.anInt11007);
            drawablemodel = itemdefinition_5_.method1689(null, 131072, null, this.anInt11001, graphicstoolkit, 118);
            if (drawablemodel != null
               && (
                  !Node_Sub15_Sub10.aBoolean9850
                     ? drawablemodel.method624(i_3_, i, class336, true, itemdefinition_5_.groundInteractRadius)
                     : drawablemodel.method621(i_3_, i, class336, true, itemdefinition_5_.groundInteractRadius, Class308.anInt3912)
               )) {
               return true;
            }
         }

         return false;
      } else {
         return true;
      }
   }

   @Override
   final boolean method814(byte b) {
      ++anInt11018;
      return false;
   }

   WorldItem(int i, int i_6_, int i_7_, int i_8_, int i_9_) {
      super(i, i_6_, i_7_, i_8_, i_9_);
      this.aBoolean11002 = false;
      this.anInt11011 = 0;
      this.anInt11010 = -1;
      this.anInt11019 = 0;
   }

   @Override
   final EntityNode_Sub6 method807(int i, GraphicsToolkit graphicstoolkit) {
      ++anInt11000;
      Class256 class256 = Class290_Sub7.method3442(this.plane, this.x >> Class36.INT_9, this.y >> Class36.INT_9);
      Animable_Sub1 animable_sub1 = Class270_Sub1_Sub1.method3303(this.plane, this.x >> Class36.INT_9, this.y >> Class36.INT_9);
      int i_10_ = 0;
      if (class256 != null && class256.aMobile3239.aBoolean9121) {
         i_10_ = class256.aMobile3239.method817(2);
      }

      if (animable_sub1 != null && ~(-i_10_) > ~animable_sub1.aShort9102) {
         i_10_ = -animable_sub1.aShort9102;
      }

      if (i_10_ != this.anInt11019) {
         this.anInt5937 -= this.anInt11019;
         this.anInt11019 = i_10_;
         this.anInt5937 += i_10_;
      }

      Class336 class336 = graphicstoolkit.A();
      class336.method3862();
      if (this.anInt11019 == 0) {
         Plane plane = Class320_Sub10.aPlaneArray8300[this.aByte5931];
         int i_14_ = this.anInt11011 << 1;
         int i_16_ = -i_14_ / 2;
         int i_17_ = -i_14_ / 2;
         int i_18_ = plane.getMedianHeightFromVertices(this.y + i_17_, -122, i_16_ + this.x);
         int i_19_ = i_14_ / 2;
         int i_20_ = -i_14_ / 2;
         int i_21_ = plane.getMedianHeightFromVertices(this.y - -i_20_, -125, i_19_ + this.x);
         int i_22_ = -i_14_ / 2;
         int i_23_ = i_14_ / 2;
         int i_24_ = plane.getMedianHeightFromVertices(i_23_ + this.y, -117, this.x + i_22_);
         int i_25_ = i_14_ / 2;
         int i_26_ = i_14_ / 2;
         int i_27_ = plane.getMedianHeightFromVertices(this.y - -i_26_, -123, i_25_ + this.x);
         int i_28_ = ~i_21_ < ~i_18_ ? i_18_ : i_21_;
         int i_29_ = i_27_ > i_24_ ? i_24_ : i_27_;
         int i_30_ = ~i_21_ > ~i_27_ ? i_21_ : i_27_;
         int i_31_ = i_18_ >= i_24_ ? i_24_ : i_18_;
         if (i_14_ != 0) {
            int i_32_ = 16383 & (int)(2607.5945876176133 * Math.atan2((double)(-i_29_ + i_28_), (double)i_14_));
            if (~i_32_ != -1) {
               class336.method3859(i_32_);
            }
         }

         if (i_14_ != 0) {
            int i_33_ = 16383 & (int)(Math.atan2((double)(-i_30_ + i_31_), (double)i_14_) * 2607.5945876176133);
            if (i_33_ != 0) {
               class336.method3868(-i_33_);
            }
         }

         int i_34_ = i_27_ + i_18_;
         if (~(i_24_ + i_21_) > ~i_34_) {
            i_34_ = i_21_ + i_24_;
         }

         i_34_ = (i_34_ >> 1) + -this.anInt5937;
         if (~i_34_ != -1) {
            class336.method3863(0, i_34_, 0);
         }
      }

      class336.method3863(this.x, -10 + this.anInt5937, this.y);
      EntityNode_Sub6 entitynode_sub6 = Class345.method3972(true, (byte)69, 3);
      this.anInt11011 = 0;
      this.aBoolean11002 = false;
      if (this.anInt11007 != -1) {
         DrawableModel drawablemodel = EntityNode_Sub3_Sub1.aClass86_9166
            .getItemDefinitionForId(this.anInt11007)
            .method1689(null, 2048, null, this.anInt11001, graphicstoolkit, 83);
         if (drawablemodel != null) {
            if (!Node_Sub15_Sub10.aBoolean9850) {
               drawablemodel.method611(class336, entitynode_sub6.anEntityNode_Sub5Array5995[2], 0);
            } else {
               drawablemodel.method622(class336, entitynode_sub6.anEntityNode_Sub5Array5995[2], Class308.anInt3912, 0);
            }

            this.aBoolean11002 |= drawablemodel.F();
            this.anInt11011 = drawablemodel.ma();
         }
      }

      if (~this.anInt11010 != 0) {
         DrawableModel drawablemodel = EntityNode_Sub3_Sub1.aClass86_9166
            .getItemDefinitionForId(this.anInt11010)
            .method1689(null, 2048, null, this.anInt11005, graphicstoolkit, 68);
         if (drawablemodel != null) {
            if (!Node_Sub15_Sub10.aBoolean9850) {
               drawablemodel.method611(class336, entitynode_sub6.anEntityNode_Sub5Array5995[1], 0);
            } else {
               drawablemodel.method622(class336, entitynode_sub6.anEntityNode_Sub5Array5995[1], Class308.anInt3912, 0);
            }

            this.aBoolean11002 |= drawablemodel.F();
            if (drawablemodel.ma() > this.anInt11011) {
               this.anInt11011 = drawablemodel.ma();
            }
         }
      }

      DrawableModel drawablemodel = EntityNode_Sub3_Sub1.aClass86_9166
         .getItemDefinitionForId(this.anInt10996)
         .method1689(null, 2048, null, this.anInt11003, graphicstoolkit, 127);
      if (drawablemodel != null) {
         if (!Node_Sub15_Sub10.aBoolean9850) {
            drawablemodel.method611(class336, entitynode_sub6.anEntityNode_Sub5Array5995[0], 0);
         } else {
            drawablemodel.method622(class336, entitynode_sub6.anEntityNode_Sub5Array5995[0], Class308.anInt3912, 0);
         }

         this.aBoolean11002 |= drawablemodel.F();
         if (~drawablemodel.ma() < ~this.anInt11011) {
            this.anInt11011 = drawablemodel.ma();
         }
      }

      return entitynode_sub6;
   }
}
