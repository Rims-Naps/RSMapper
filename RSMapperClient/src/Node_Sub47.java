import jaggl.OpenGL;

public class Node_Sub47 extends Node {
   protected Node_Sub9_Sub2 aNode_Sub9_Sub2_7556;
   static int anInt7557;
   static Class312 aClass312_7558 = new Class312();
   protected int anInt7559;
   protected int anInt7560;
   protected int anInt7561;
   protected ObjectDefinition anObjectDefinition7562;
   protected int anInt7563;
   protected int anInt7564;
   protected int anInt7565;
   protected int anInt7566;
   protected int anInt7567;
   protected Node_Sub9_Sub2 aNode_Sub9_Sub2_7568;
   protected int anInt7569;
   protected int anInt7570;
   protected int anInt7571;
   protected int anInt7572;
   protected Player aPlayer7573;
   protected boolean aBoolean7574;
   protected Node_Sub45_Sub1 aNode_Sub45_Sub1_7575;
   protected Node_Sub45_Sub1 aNode_Sub45_Sub1_7576;
   static int anInt7577;
   protected Node_Sub49 aNode_Sub49_7578;
   protected int[] anIntArray7579;
   protected boolean aBoolean7580;
   protected Node_Sub49 aNode_Sub49_7581;
   protected int anInt7582;
   protected Npc aNpc7583;
   protected boolean aBoolean7584;
   static int anInt7585;
   protected int anInt7586 = 0;
   protected int anInt7587;

   public static void method2950(int i) {
      aClass312_7558 = null;
      if (i != 256) {
         method2950(-93);
      }
   }

   final void method2951() {
      ++anInt7577;
      int i_0_ = this.anInt7564;
      boolean bool = this.aBoolean7580;
      if (this.anObjectDefinition7562 == null) {
         if (this.aNpc7583 != null) {
            int i_1_ = Class266.method3243(-69, this.aNpc7583);
            if (i_1_ != i_0_) {
               this.anInt7564 = i_1_;
               NpcDefinition npcdefinition = this.aNpc7583.definitions;
               if (npcdefinition.anIntArray2827 != null) {
                  npcdefinition = npcdefinition.method2999(65535, Class24.aClass275_442);
               }

               if (npcdefinition != null) {
                  this.anInt7572 = npcdefinition.anInt2852;
                  this.anInt7570 = npcdefinition.anInt2828;
                  this.anInt7567 = npcdefinition.anInt2864 << 9;
                  this.anInt7571 = npcdefinition.anInt2844;
                  this.aBoolean7580 = npcdefinition.aBoolean2883;
                  this.anInt7566 = npcdefinition.anInt2862 << 9;
               } else {
                  this.aBoolean7580 = this.aNpc7583.definitions.aBoolean2883;
                  this.anInt7571 = 256;
                  this.anInt7572 = 256;
                  this.anInt7570 = this.anInt7567 = this.anInt7566 = 0;
               }
            }
         } else if (this.aPlayer7573 != null) {
            this.anInt7564 = Class172.method1797(-1, this.aPlayer7573);
            this.anInt7570 = this.aPlayer7573.anInt11173;
            this.anInt7566 = 0;
            this.anInt7571 = 256;
            this.anInt7567 = this.aPlayer7573.anInt11164 << 9;
            this.aBoolean7580 = this.aPlayer7573.hasDisplayName;
            this.anInt7572 = 256;
         }
      } else {
         ObjectDefinition objectdefinition = this.anObjectDefinition7562
            .method3038(13, (Interface17)(aa.anInt101 != 3 ? Class24.aClass275_442 : ProducingGraphicsBuffer.anInterface17_9901));
         if (objectdefinition != null) {
            this.aBoolean7580 = objectdefinition.aBoolean2961;
            this.anInt7572 = objectdefinition.mapSpriteOffset2;
            this.anInt7571 = objectdefinition.mapSpriteOffset1;
            this.anInt7567 = objectdefinition.anInt3012 << 9;
            this.anInt7570 = objectdefinition.anInt3024;
            this.anInt7565 = objectdefinition.anInt2971;
            this.anInt7564 = objectdefinition.anInt3015;
            this.anIntArray7579 = objectdefinition.anIntArray3036;
            this.aBoolean7584 = objectdefinition.aBoolean2993;
            this.anInt7587 = objectdefinition.anInt2989;
         } else {
            this.anIntArray7579 = null;
            this.anInt7564 = -1;
            this.aBoolean7580 = false;
            this.anInt7570 = 0;
            this.anInt7571 = 256;
            this.anInt7565 = 0;
            this.anInt7566 = 0;
            this.aBoolean7584 = false;
            this.anInt7572 = 256;
            this.anInt7587 = 0;
            this.anInt7567 = 0;
         }
      }

      if ((this.anInt7564 != i_0_ || !this.aBoolean7580 == bool) && this.aNode_Sub9_Sub2_7568 != null) {
         Class176.aNode_Sub9_Sub3_2106.method2514(this.aNode_Sub9_Sub2_7568);
         this.aNode_Sub9_Sub2_7568 = null;
         this.aNode_Sub45_Sub1_7576 = null;
         this.aNode_Sub49_7581 = null;
      }
   }

   static final int method2952(boolean bool, int i) {
      ++anInt7585;
      return bool ? -87 : 127 & i;
   }

   static final void method2953(int i, int i_2_, boolean bool, int i_3_, int i_4_, float[] fs, int i_5_) {
      ++anInt7557;
      if (~i_3_ < -1 && !Class371.method4094(i_3_, false)) {
         throw new IllegalArgumentException("");
      } else if (~i_2_ < -1 && !Class371.method4094(i_2_, false)) {
         throw new IllegalArgumentException("");
      } else {
         int i_6_ = Class349.method3989(i, (byte)-71);
         int i_7_ = 0;
         int i_8_ = i_3_ < i_2_ ? i_3_ : i_2_;
         int i_9_ = i_3_ >> 1;
         int i_10_ = i_2_ >> 1;
         float[] fs_11_ = fs;
         if (bool) {
            float[] fs_12_ = new float[i_6_ * i_10_ * i_9_];

            while(true) {
               OpenGL.glTexImage2Df(i_4_, i_7_, i_5_, i_3_, i_2_, 0, i, 5126, fs_11_, 0);
               if (~i_8_ >= -2) {
                  break;
               }

               int i_13_ = i_3_ * i_6_;

               for(int i_14_ = 0; i_6_ > i_14_; ++i_14_) {
                  int i_15_ = i_14_;
                  int i_16_ = i_14_;
                  int i_17_ = i_14_ + i_13_;

                  for(int i_18_ = 0; i_10_ > i_18_; ++i_18_) {
                     for(int i_19_ = 0; i_9_ > i_19_; ++i_19_) {
                        float f = fs_11_[i_16_];
                        i_16_ += i_6_;
                        f += fs_11_[i_16_];
                        i_16_ += i_6_;
                        f += fs_11_[i_17_];
                        i_17_ += i_6_;
                        f += fs_11_[i_17_];
                        i_17_ += i_6_;
                        fs_12_[i_15_] = f * 0.25F;
                        i_15_ += i_6_;
                     }

                     i_16_ += i_13_;
                     i_17_ += i_13_;
                  }
               }

               float[] fs_20_ = fs_12_;
               fs_12_ = fs_11_;
               i_3_ = i_9_;
               fs_11_ = fs_20_;
               i_2_ = i_10_;
               i_8_ >>= 1;
               ++i_7_;
               i_10_ >>= 1;
               i_9_ >>= 1;
            }
         }
      }
   }
}
