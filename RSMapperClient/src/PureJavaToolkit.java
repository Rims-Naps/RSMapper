import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Rectangle;

public class PureJavaToolkit extends GraphicsToolkit {
   private int anInt6752;
   private HashTable aHashTable6753;
   private int anInt6754;
   private java.awt.Canvas aCanvas6755;
   protected GraphicsBuffer aGraphicsBuffer6756;
   private boolean aBoolean6757;
   private int anInt6758;
   private boolean aBoolean6759 = false;
   protected int anInt6760;
   protected int anInt6761;
   private Class61 aClass61_6762;
   protected int anInt6763;
   protected int anInt6764;
   private int anInt6765;
   protected int anInt6766;
   protected int anInt6767;
   protected int anInt6768;
   protected int anInt6769;
   private int anInt6770;
   private Class64 aClass64_6771;
   protected int anInt6772;
   private int anInt6773;
   protected int anInt6774;
   protected int anInt6775;
   protected int anInt6776;
   private Class374[] aClass374Array6777;
   protected int anInt6778;
   protected int anInt6779;
   protected int anInt6780;
   private Class61 aClass61_6781;
   protected float[] aFloatArray6782;
   private int anInt6783;
   protected int anInt6784;
   protected int anInt6785;
   protected int anInt6786;
   protected int[] anIntArray6787;
   protected Class336_Sub2 aClass336_Sub2_6788;
   protected int anInt6789;
   protected int anInt6790;
   private int anInt6791;
   protected float[] aFloatArray6792;
   protected int anInt6793;
   private boolean aBoolean6794;
   protected int anInt6795;
   private int anInt6796;
   private int anInt6797;
   protected int anInt6798;
   private GLSprite aGLSprite6799;
   private int anInt6800;

   @Override
   final void u() {
      if (this.aBoolean6757) {
         Class160.method1727(true, (byte)122, false);
         this.aBoolean6757 = false;
      }

      this.aGraphicsBuffer6756 = null;
      this.aCanvas6755 = null;
      this.anInt6752 = 0;
      this.anInt6758 = 0;
      this.aHashTable6753 = null;
      this.aBoolean6759 = true;
   }

   @Override
   final void a(int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, aa var_aa, int i_5_, int i_6_) {
      aa_Sub1 var_aa_Sub1 = (aa_Sub1)var_aa;
      int[] is = var_aa_Sub1.anIntArray5487;
      int[] is_7_ = var_aa_Sub1.anIntArray5488;
      int i_8_ = this.anInt6760 > i_6_ ? this.anInt6760 : i_6_;
      int i_9_ = this.anInt6772 < i_6_ + is.length ? this.anInt6772 : i_6_ + is.length;
      i_1_ -= i;
      i_2_ -= i_0_;
      if (i_1_ + i_2_ < 0) {
         i += i_1_;
         i_1_ = -i_1_;
         i_0_ += i_2_;
         i_2_ = -i_2_;
      }

      if (i_1_ > i_2_) {
         i_0_ <<= 16;
         i_0_ += 32768;
         i_2_ <<= 16;
         int i_10_ = (int)Math.floor((double)i_2_ / (double)i_1_ + 0.5);
         i_1_ += i;
         if (i < this.anInt6767) {
            i_0_ += i_10_ * (this.anInt6767 - i);
            i = this.anInt6767;
         }

         if (i_1_ >= this.anInt6778) {
            i_1_ = this.anInt6778 - 1;
         }

         int i_11_ = i_3_ >>> 24;
         if (i_4_ == 0 || i_4_ == 1 && i_11_ == 255) {
            while(i <= i_1_) {
               int i_12_ = i_0_ >> 16;
               int i_13_ = i_12_ - i_6_;
               if (i_12_ >= i_8_ && i_12_ < i_9_) {
                  int i_14_ = i_5_ + is[i_13_];
                  if (i >= i_14_ && i < i_14_ + is_7_[i_13_]) {
                     this.anIntArray6787[i + i_12_ * this.anInt6789] = i_3_;
                  }
               }

               i_0_ += i_10_;
               ++i;
            }
         } else if (i_4_ == 1) {
            i_3_ = ((i_3_ & 16711935) * i_11_ >> 8 & 16711935) + ((i_3_ & 0xFF00) * i_11_ >> 8 & 0xFF00) + (i_11_ << 24);

            for(int i_15_ = 256 - i_11_; i <= i_1_; ++i) {
               int i_16_ = i_0_ >> 16;
               int i_17_ = i_16_ - i_6_;
               if (i_16_ >= i_8_ && i_16_ < i_9_) {
                  int i_18_ = i_5_ + is[i_17_];
                  if (i >= i_18_ && i < i_18_ + is_7_[i_17_]) {
                     int i_19_ = i + i_16_ * this.anInt6789;
                     int i_20_ = this.anIntArray6787[i_19_];
                     i_20_ = ((i_20_ & 16711935) * i_15_ >> 8 & 16711935) + ((i_20_ & 0xFF00) * i_15_ >> 8 & 0xFF00);
                     this.anIntArray6787[i_19_] = i_3_ + i_20_;
                  }
               }

               i_0_ += i_10_;
            }
         } else if (i_4_ == 2) {
            while(i <= i_1_) {
               int i_21_ = i_0_ >> 16;
               int i_22_ = i_21_ - i_6_;
               if (i_21_ >= i_8_ && i_21_ < i_9_) {
                  int i_23_ = i_5_ + is[i_22_];
                  if (i >= i_23_ && i < i_23_ + is_7_[i_22_]) {
                     int i_24_ = i + i_21_ * this.anInt6789;
                     int i_25_ = this.anIntArray6787[i_24_];
                     int i_26_ = i_3_ + i_25_;
                     int i_27_ = (i_3_ & 16711935) + (i_25_ & 16711935);
                     i_25_ = (i_27_ & 16777472) + (i_26_ - i_27_ & 65536);
                     this.anIntArray6787[i_24_] = i_26_ - i_25_ | i_25_ - (i_25_ >>> 8);
                  }
               }

               i_0_ += i_10_;
               ++i;
            }
         } else {
            throw new IllegalArgumentException();
         }
      } else {
         i <<= 16;
         i += 32768;
         i_1_ <<= 16;
         int i_28_ = (int)Math.floor((double)i_1_ / (double)i_2_ + 0.5);
         i_2_ += i_0_;
         if (i_0_ < i_8_) {
            i += i_28_ * (i_8_ - i_0_);
            i_0_ = i_8_;
         }

         if (i_2_ >= i_9_) {
            i_2_ = i_9_ - 1;
         }

         int i_29_ = i_3_ >>> 24;
         if (i_4_ == 0 || i_4_ == 1 && i_29_ == 255) {
            while(i_0_ <= i_2_) {
               int i_30_ = i >> 16;
               int i_31_ = i_0_ - i_6_;
               int i_32_ = i_5_ + is[i_31_];
               if (i_30_ >= this.anInt6767 && i_30_ < this.anInt6778 && i_30_ >= i_32_ && i_30_ < i_32_ + is_7_[i_31_]) {
                  this.anIntArray6787[i_30_ + i_0_ * this.anInt6789] = i_3_;
               }

               i += i_28_;
               ++i_0_;
            }
         } else if (i_4_ == 1) {
            i_3_ = ((i_3_ & 16711935) * i_29_ >> 8 & 16711935) + ((i_3_ & 0xFF00) * i_29_ >> 8 & 0xFF00) + (i_29_ << 24);

            for(int i_33_ = 256 - i_29_; i_0_ <= i_2_; ++i_0_) {
               int i_34_ = i >> 16;
               int i_35_ = i_0_ - i_6_;
               int i_36_ = i_5_ + is[i_35_];
               if (i_34_ >= this.anInt6767 && i_34_ < this.anInt6778 && i_34_ >= i_36_ && i_34_ < i_36_ + is_7_[i_35_]) {
                  int i_37_ = i_34_ + i_0_ * this.anInt6789;
                  int i_38_ = this.anIntArray6787[i_37_];
                  i_38_ = ((i_38_ & 16711935) * i_33_ >> 8 & 16711935) + ((i_38_ & 0xFF00) * i_33_ >> 8 & 0xFF00);
                  this.anIntArray6787[i_34_ + i_0_ * this.anInt6789] = i_3_ + i_38_;
               }

               i += i_28_;
            }
         } else {
            if (i_4_ != 2) {
               throw new IllegalArgumentException();
            }

            while(i_0_ <= i_2_) {
               int i_39_ = i >> 16;
               int i_40_ = i_0_ - i_6_;
               int i_41_ = i_5_ + is[i_40_];
               if (i_39_ >= this.anInt6767 && i_39_ < this.anInt6778 && i_39_ >= i_41_ && i_39_ < i_41_ + is_7_[i_40_]) {
                  int i_42_ = i_39_ + i_0_ * this.anInt6789;
                  int i_43_ = this.anIntArray6787[i_42_];
                  int i_44_ = i_3_ + i_43_;
                  int i_45_ = (i_3_ & 16711935) + (i_43_ & 16711935);
                  i_43_ = (i_45_ & 16777472) + (i_44_ - i_45_ & 65536);
                  this.anIntArray6787[i_42_] = i_44_ - i_43_ | i_43_ - (i_43_ >>> 8);
               }

               i += i_28_;
               ++i_0_;
            }
         }
      }
   }

   @Override
   final void xa(float f) {
      this.anInt6780 = (int)(f * 65535.0F);
   }

   @Override
   final int M() {
      int i = this.anInt6797;
      this.anInt6797 = 0;
      return i;
   }

   @Override
   final void a(int i, int i_46_, int i_47_, int i_48_, int i_49_, int i_50_, int i_51_) {
      Class374 class374 = this.method1494(Thread.currentThread());
      Class185 class185 = class374.aClass185_4627;
      int i_52_ = i_47_ - i;
      int i_53_ = i_48_ - i_46_;
      int i_54_ = i_52_ >= 0 ? i_52_ : -i_52_;
      int i_55_ = i_53_ >= 0 ? i_53_ : -i_53_;
      int i_56_ = i_54_;
      if (i_54_ < i_55_) {
         i_56_ = i_55_;
      }

      if (i_56_ != 0) {
         int i_57_ = (i_52_ << 16) / i_56_;
         int i_58_ = (i_53_ << 16) / i_56_;
         i_52_ += i_57_ >> 16;
         i_53_ += i_58_ >> 16;
         if (i_58_ <= i_57_) {
            i_57_ = -i_57_;
         } else {
            i_58_ = -i_58_;
         }

         int i_59_ = i_50_ * i_58_ >> 17;
         int i_60_ = i_50_ * i_58_ + 1 >> 17;
         int i_61_ = i_50_ * i_57_ >> 17;
         int i_62_ = i_50_ * i_57_ + 1 >> 17;
         i -= class185.method1869();
         i_46_ -= class185.method1849();
         int i_63_ = i + i_59_;
         int i_64_ = i - i_60_;
         int i_65_ = i + i_52_ - i_60_;
         int i_66_ = i + i_52_ + i_59_;
         int i_67_ = i_46_ + i_61_;
         int i_68_ = i_46_ - i_62_;
         int i_69_ = i_46_ + i_53_ - i_62_;
         int i_70_ = i_46_ + i_53_ + i_61_;
         if (i_51_ == 0) {
            class185.anInt2220 = 0;
         } else {
            if (i_51_ != 1) {
               throw new IllegalArgumentException();
            }

            class185.anInt2220 = 255 - (i_49_ >>> 24);
         }

         this.C(false);
         class185.aBoolean2217 = i_63_ < 0 || i_63_ > class185.anInt2222 || i_64_ < 0 || i_64_ > class185.anInt2222 || i_65_ < 0 || i_65_ > class185.anInt2222;
         class185.method1867((float)i_67_, (float)i_68_, (float)i_69_, (float)i_63_, (float)i_64_, (float)i_65_, 100.0F, 100.0F, 100.0F, i_49_);
         class185.aBoolean2217 = i_63_ < 0 || i_63_ > class185.anInt2222 || i_65_ < 0 || i_65_ > class185.anInt2222 || i_66_ < 0 || i_66_ > class185.anInt2222;
         class185.method1867((float)i_67_, (float)i_69_, (float)i_70_, (float)i_63_, (float)i_65_, (float)i_66_, 100.0F, 100.0F, 100.0F, i_49_);
         this.C(true);
      }
   }

   @Override
   final void a(java.awt.Canvas canvas) {
      if (canvas != null) {
         GraphicsBuffer graphicsbuffer = (GraphicsBuffer)this.aHashTable6753.get(3512, (long)canvas.hashCode());
         if (graphicsbuffer != null) {
            this.aCanvas6755 = canvas;
            Dimension dimension = canvas.getSize();
            this.anInt6752 = dimension.width;
            this.anInt6758 = dimension.height;
            this.aGraphicsBuffer6756 = graphicsbuffer;
            if (this.aClass64_6771 == null) {
               this.anIntArray6787 = graphicsbuffer.anIntArray7145;
               this.anInt6789 = graphicsbuffer.anInt7146;
               this.anInt6791 = graphicsbuffer.anInt7142;
               if (this.anInt6789 != this.anInt6765 || this.anInt6791 != this.anInt6783) {
                  this.anInt6773 = this.anInt6765 = this.anInt6789;
                  this.anInt6770 = this.anInt6783 = this.anInt6791;
                  this.aFloatArray6792 = this.aFloatArray6782 = new float[this.anInt6765 * this.anInt6783];
               }

               this.method1496();
            }
         }
      } else {
         this.aCanvas6755 = null;
         this.aGraphicsBuffer6756 = null;
         if (this.aClass64_6771 == null) {
            this.anIntArray6787 = null;
            this.anInt6789 = this.anInt6791 = 1;
            this.anInt6765 = this.anInt6783 = 1;
            this.method1496();
         }
      }
   }

   private final void method1490(int i, int i_71_, int i_72_, int i_73_, int i_74_, int i_75_, int i_76_, int i_77_) {
      if (i >= this.anInt6767 && i < this.anInt6778) {
         int i_78_ = i + i_71_ * this.anInt6789;
         int i_79_ = i_73_ >>> 24;
         int i_80_ = i_75_ + i_76_;
         int i_81_ = i_77_ % i_80_;
         if (i_74_ == 0 || i_74_ == 1 && i_79_ == 255) {
            for(int i_82_ = 0; i_82_ < i_72_; i_81_ = ++i_81_ % i_80_) {
               if (i_71_ + i_82_ >= this.anInt6760 && i_71_ + i_82_ < this.anInt6772 && i_81_ < i_75_) {
                  this.anIntArray6787[i_78_ + i_82_ * this.anInt6789] = i_73_;
               }

               ++i_82_;
            }
         } else if (i_74_ == 1) {
            i_73_ = ((i_73_ & 16711935) * i_79_ >> 8 & 16711935) + ((i_73_ & 0xFF00) * i_79_ >> 8 & 0xFF00) + (i_79_ << 24);
            int i_83_ = 256 - i_79_;

            for(int i_84_ = 0; i_84_ < i_72_; i_81_ = ++i_81_ % i_80_) {
               if (i_71_ + i_84_ >= this.anInt6760 && i_71_ + i_84_ < this.anInt6772 && i_81_ < i_75_) {
                  int i_85_ = i_78_ + i_84_ * this.anInt6789;
                  int i_86_ = this.anIntArray6787[i_85_];
                  i_86_ = ((i_86_ & 16711935) * i_83_ >> 8 & 16711935) + ((i_86_ & 0xFF00) * i_83_ >> 8 & 0xFF00);
                  this.anIntArray6787[i_85_] = i_73_ + i_86_;
               }

               ++i_84_;
            }
         } else {
            if (i_74_ != 2) {
               throw new IllegalArgumentException();
            }

            for(int i_87_ = 0; i_87_ < i_72_; i_81_ = ++i_81_ % i_80_) {
               if (i_71_ + i_87_ >= this.anInt6760 && i_71_ + i_87_ < this.anInt6772 && i_81_ < i_75_) {
                  int i_88_ = i_78_ + i_87_ * this.anInt6789;
                  int i_89_ = this.anIntArray6787[i_88_];
                  int i_90_ = i_73_ + i_89_;
                  int i_91_ = (i_73_ & 16711935) + (i_89_ & 16711935);
                  i_89_ = (i_91_ & 16777472) + (i_90_ - i_91_ & 65536);
                  this.anIntArray6787[i_88_] = i_90_ - i_89_ | i_89_ - (i_89_ >>> 8);
               }

               ++i_87_;
            }
         }
      }
   }

   @Override
   final void ya() {
      if (this.anInt6767 == 0 && this.anInt6778 == this.anInt6789 && this.anInt6760 == 0 && this.anInt6772 == this.anInt6791) {
         int i = this.aFloatArray6782.length;
         int i_92_ = i - (i & 7);

         int i_93_;
         for(i_93_ = 0; i_93_ < i_92_; this.aFloatArray6782[i_93_++] = 2.1474836E9F) {
            this.aFloatArray6782[i_93_++] = 2.1474836E9F;
            this.aFloatArray6782[i_93_++] = 2.1474836E9F;
            this.aFloatArray6782[i_93_++] = 2.1474836E9F;
            this.aFloatArray6782[i_93_++] = 2.1474836E9F;
            this.aFloatArray6782[i_93_++] = 2.1474836E9F;
            this.aFloatArray6782[i_93_++] = 2.1474836E9F;
            this.aFloatArray6782[i_93_++] = 2.1474836E9F;
         }

         while(i_93_ < i) {
            this.aFloatArray6782[i_93_++] = 2.1474836E9F;
         }
      } else {
         int i = this.anInt6778 - this.anInt6767;
         int i_94_ = this.anInt6772 - this.anInt6760;
         int i_95_ = this.anInt6789 - i;
         int i_96_ = this.anInt6767 + this.anInt6760 * this.anInt6789;
         int i_97_ = i >> 3;
         int i_98_ = i & 7;
         i = i_96_ - 1;

         for(int i_99_ = -i_94_; i_99_ < 0; ++i_99_) {
            if (i_97_ > 0) {
               int i_100_ = i_97_;

               do {
                  ++i;
                  this.aFloatArray6782[i] = 2.1474836E9F;
                  ++i;
                  this.aFloatArray6782[i] = 2.1474836E9F;
                  ++i;
                  this.aFloatArray6782[i] = 2.1474836E9F;
                  ++i;
                  this.aFloatArray6782[i] = 2.1474836E9F;
                  ++i;
                  this.aFloatArray6782[i] = 2.1474836E9F;
                  ++i;
                  this.aFloatArray6782[i] = 2.1474836E9F;
                  ++i;
                  this.aFloatArray6782[i] = 2.1474836E9F;
                  ++i;
                  this.aFloatArray6782[i] = 2.1474836E9F;
               } while(--i_100_ > 0);
            }

            if (i_98_ > 0) {
               int i_101_ = i_98_;

               do {
                  ++i;
                  this.aFloatArray6782[i] = 2.1474836E9F;
               } while(--i_101_ > 0);
            }

            i += i_95_;
         }
      }
   }

   @Override
   final void a(Interface6 interface6) {
      Class64 class64 = (Class64)interface6;
      this.anInt6789 = class64.anInt5041;
      this.anInt6791 = class64.anInt5037;
      this.anIntArray6787 = class64.anIntArray5042;
      this.aClass64_6771 = class64;
      this.anInt6765 = class64.anInt5041;
      this.anInt6783 = class64.anInt5037;
      this.aFloatArray6782 = class64.aFloatArray5049;
      this.method1496();
   }

   @Override
   final boolean b() {
      return true;
   }

   @Override
   final void a(Class198 class198, int i) {
      Class374 class374 = this.method1494(Thread.currentThread());
      EntityNode_Sub3 entitynode_sub3 = class198.aClass87_2429.anEntityNode_Sub3_1186;

      for(EntityNode_Sub3 entitynode_sub3_102_ = entitynode_sub3.anEntityNode_Sub3_5961;
         entitynode_sub3_102_ != entitynode_sub3;
         entitynode_sub3_102_ = entitynode_sub3_102_.anEntityNode_Sub3_5961
      ) {
         EntityNode_Sub3_Sub2 entitynode_sub3_sub2 = (EntityNode_Sub3_Sub2)entitynode_sub3_102_;
         int i_103_ = entitynode_sub3_sub2.anInt9174 >> 12;
         int i_104_ = entitynode_sub3_sub2.anInt9171 >> 12;
         int i_105_ = entitynode_sub3_sub2.anInt9173 >> 12;
         float f = this.aClass336_Sub2_6788.aFloat8589
            + this.aClass336_Sub2_6788.aFloat8577 * (float)i_103_
            + this.aClass336_Sub2_6788.aFloat8567 * (float)i_104_
            + this.aClass336_Sub2_6788.aFloat8584 * (float)i_105_;
         if (f >= (float)this.anInt6798 && f <= (float)class374.anInt4618) {
            int i_106_ = this.anInt6786
               + (int)(
                  (float)this.anInt6785
                     * (
                        this.aClass336_Sub2_6788.aFloat8583
                           + this.aClass336_Sub2_6788.aFloat8580 * (float)i_103_
                           + this.aClass336_Sub2_6788.aFloat8571 * (float)i_104_
                           + this.aClass336_Sub2_6788.aFloat8566 * (float)i_105_
                     )
                     / (float)i
               );
            int i_107_ = this.anInt6769
               + (int)(
                  (float)this.anInt6763
                     * (
                        this.aClass336_Sub2_6788.aFloat8579
                           + this.aClass336_Sub2_6788.aFloat8578 * (float)i_103_
                           + this.aClass336_Sub2_6788.aFloat8561 * (float)i_104_
                           + this.aClass336_Sub2_6788.aFloat8558 * (float)i_105_
                     )
                     / (float)i
               );
            if (i_106_ >= this.anInt6767 && i_106_ <= this.anInt6778 && i_107_ >= this.anInt6760 && i_107_ <= this.anInt6772) {
               if (f == 0.0F) {
                  f = 1.0F;
               }

               this.method1491(entitynode_sub3_sub2, i_106_, i_107_, (int)f, (entitynode_sub3_sub2.anInt9172 * this.anInt6785 >> 12) / i);
            }
         }
      }
   }

   private final void method1491(EntityNode_Sub3_Sub2 entitynode_sub3_sub2, int i, int i_108_, int i_109_, int i_110_) {
      int i_111_ = entitynode_sub3_sub2.anInt9177;
      i_110_ <<= 1;
      if (i_111_ == -1) {
         this.method1497(i, i_108_, i_109_, i_110_, entitynode_sub3_sub2.anInt9176, 1);
      } else {
         if (this.anInt6800 != i_111_) {
            GLSprite glsprite = (GLSprite)this.aClass61_6762.method607((long)i_111_, 0);
            if (glsprite == null) {
               int[] is = this.method1495(i_111_);
               if (is == null) {
                  return;
               }

               int i_113_ = this.method1505(i_111_) ? 64 : this.anInt6775;
               glsprite = this.method1235(i_113_, i_113_, i_113_, is, 0, 7468);
               this.aClass61_6762.method601(glsprite, 25566, (long)i_111_);
            }

            this.anInt6800 = i_111_;
            this.aGLSprite6799 = glsprite;
         }

         ((GLSprite_Sub2)this.aGLSprite6799).method1208(i - i_110_, i_108_ - i_110_, i_109_, i_110_, ++i_110_, 0, entitynode_sub3_sub2.anInt9176, 1, 1);
      }
   }

   @Override
   final void F(int i, int i_114_) {
      int i_115_ = i_114_ * this.anInt6789 + i;
      int i_116_ = i_114_ * this.anInt6765 + i;
      if (i_115_ != 0 || i_116_ != 0) {
         int[] is = this.anIntArray6787;
         float[] fs = this.aFloatArray6782;
         if (i_115_ < 0) {
            int i_117_ = is.length + i_115_;
            Class311.method3609(is, -i_115_, is, 0, i_117_);
         } else if (i_115_ > 0) {
            int i_118_ = is.length - i_115_;
            Class311.method3609(is, 0, is, i_115_, i_118_);
         }

         if (i_116_ < 0) {
            int i_119_ = fs.length + i_116_;
            Class311.method3603(fs, -i_116_, fs, 0, i_119_);
         } else if (i_116_ > 0) {
            int i_120_ = fs.length - i_116_;
            Class311.method3603(fs, 0, fs, i_116_, i_120_);
         }
      }
   }

   final boolean method1492() {
      return this.aBoolean6759;
   }

   @Override
   final void za(int i, int i_121_, int i_122_, int i_123_, int i_124_) {
      if (i_122_ < 0) {
         i_122_ = -i_122_;
      }

      int i_125_ = i_121_ - i_122_;
      if (i_125_ < this.anInt6760) {
         i_125_ = this.anInt6760;
      }

      int i_126_ = i_121_ + i_122_ + 1;
      if (i_126_ > this.anInt6772) {
         i_126_ = this.anInt6772;
      }

      int i_127_ = i_125_;
      int i_128_ = i_122_ * i_122_;
      int i_129_ = 0;
      int i_130_ = i_121_ - i_125_;
      int i_131_ = i_130_ * i_130_;
      int i_132_ = i_131_ - i_130_;
      if (i_121_ > i_126_) {
         i_121_ = i_126_;
      }

      int i_133_ = i_123_ >>> 24;
      if (i_124_ == 0 || i_124_ == 1 && i_133_ == 255) {
         while(i_127_ < i_121_) {
            while(i_132_ <= i_128_ || i_131_ <= i_128_) {
               i_131_ += i_129_ + i_129_;
               i_132_ += i_129_++ + i_129_;
            }

            int i_134_ = i - i_129_ + 1;
            if (i_134_ < this.anInt6767) {
               i_134_ = this.anInt6767;
            }

            int i_135_ = i + i_129_;
            if (i_135_ > this.anInt6778) {
               i_135_ = this.anInt6778;
            }

            int i_136_ = i_134_ + i_127_ * this.anInt6789;

            for(int i_137_ = i_134_; i_137_ < i_135_; ++i_137_) {
               this.anIntArray6787[i_136_++] = i_123_;
            }

            ++i_127_;
            i_131_ -= i_130_-- + i_130_;
            i_132_ -= i_130_ + i_130_;
         }

         i_129_ = i_122_;
         i_130_ = i_127_ - i_121_;
         i_132_ = i_130_ * i_130_ + i_128_;
         i_131_ = i_132_ - i_122_;

         for(int var37 = i_132_ - i_130_; i_127_ < i_126_; i_131_ += i_130_++ + i_130_) {
            while(var37 > i_128_ && i_131_ > i_128_) {
               var37 -= i_129_-- + i_129_;
               i_131_ -= i_129_ + i_129_;
            }

            int i_138_ = i - i_129_;
            if (i_138_ < this.anInt6767) {
               i_138_ = this.anInt6767;
            }

            int i_139_ = i + i_129_;
            if (i_139_ > this.anInt6778 - 1) {
               i_139_ = this.anInt6778 - 1;
            }

            int i_140_ = i_138_ + i_127_ * this.anInt6789;

            for(int i_141_ = i_138_; i_141_ <= i_139_; ++i_141_) {
               this.anIntArray6787[i_140_++] = i_123_;
            }

            ++i_127_;
            var37 += i_130_ + i_130_;
         }

         return;
      } else if (i_124_ == 1) {
         i_123_ = ((i_123_ & 16711935) * i_133_ >> 8 & 16711935) + ((i_123_ & 0xFF00) * i_133_ >> 8 & 0xFF00) + (i_133_ << 24);

         int i_142_;
         for(i_142_ = 256 - i_133_; i_127_ < i_121_; i_132_ -= i_130_ + i_130_) {
            while(i_132_ <= i_128_ || i_131_ <= i_128_) {
               i_131_ += i_129_ + i_129_;
               i_132_ += i_129_++ + i_129_;
            }

            int i_143_ = i - i_129_ + 1;
            if (i_143_ < this.anInt6767) {
               i_143_ = this.anInt6767;
            }

            int i_144_ = i + i_129_;
            if (i_144_ > this.anInt6778) {
               i_144_ = this.anInt6778;
            }

            int i_145_ = i_143_ + i_127_ * this.anInt6789;

            for(int i_146_ = i_143_; i_146_ < i_144_; ++i_146_) {
               int i_147_ = this.anIntArray6787[i_145_];
               i_147_ = ((i_147_ & 16711935) * i_142_ >> 8 & 16711935) + ((i_147_ & 0xFF00) * i_142_ >> 8 & 0xFF00);
               this.anIntArray6787[i_145_++] = i_123_ + i_147_;
            }

            ++i_127_;
            i_131_ -= i_130_-- + i_130_;
         }

         i_129_ = i_122_;
         i_130_ = -i_130_;
         i_132_ = i_130_ * i_130_ + i_128_;
         i_131_ = i_132_ - i_122_;

         for(int var33 = i_132_ - i_130_; i_127_ < i_126_; i_131_ += i_130_++ + i_130_) {
            while(var33 > i_128_ && i_131_ > i_128_) {
               var33 -= i_129_-- + i_129_;
               i_131_ -= i_129_ + i_129_;
            }

            int i_148_ = i - i_129_;
            if (i_148_ < this.anInt6767) {
               i_148_ = this.anInt6767;
            }

            int i_149_ = i + i_129_;
            if (i_149_ > this.anInt6778 - 1) {
               i_149_ = this.anInt6778 - 1;
            }

            int i_150_ = i_148_ + i_127_ * this.anInt6789;

            for(int i_151_ = i_148_; i_151_ <= i_149_; ++i_151_) {
               int i_152_ = this.anIntArray6787[i_150_];
               i_152_ = ((i_152_ & 16711935) * i_142_ >> 8 & 16711935) + ((i_152_ & 0xFF00) * i_142_ >> 8 & 0xFF00);
               this.anIntArray6787[i_150_++] = i_123_ + i_152_;
            }

            ++i_127_;
            var33 += i_130_ + i_130_;
         }
      } else {
         if (i_124_ != 2) {
            throw new IllegalArgumentException();
         }

         while(i_127_ < i_121_) {
            while(i_132_ <= i_128_ || i_131_ <= i_128_) {
               i_131_ += i_129_ + i_129_;
               i_132_ += i_129_++ + i_129_;
            }

            int i_153_ = i - i_129_ + 1;
            if (i_153_ < this.anInt6767) {
               i_153_ = this.anInt6767;
            }

            int i_154_ = i + i_129_;
            if (i_154_ > this.anInt6778) {
               i_154_ = this.anInt6778;
            }

            int i_155_ = i_153_ + i_127_ * this.anInt6789;

            for(int i_156_ = i_153_; i_156_ < i_154_; ++i_156_) {
               int i_157_ = this.anIntArray6787[i_155_];
               int i_158_ = i_123_ + i_157_;
               int i_159_ = (i_123_ & 16711935) + (i_157_ & 16711935);
               i_157_ = (i_159_ & 16777472) + (i_158_ - i_159_ & 65536);
               this.anIntArray6787[i_155_++] = i_158_ - i_157_ | i_157_ - (i_157_ >>> 8);
            }

            ++i_127_;
            i_131_ -= i_130_-- + i_130_;
            i_132_ -= i_130_ + i_130_;
         }

         i_129_ = i_122_;
         i_130_ = -i_130_;
         i_132_ = i_130_ * i_130_ + i_128_;
         i_131_ = i_132_ - i_122_;

         for(int var35 = i_132_ - i_130_; i_127_ < i_126_; i_131_ += i_130_++ + i_130_) {
            while(var35 > i_128_ && i_131_ > i_128_) {
               var35 -= i_129_-- + i_129_;
               i_131_ -= i_129_ + i_129_;
            }

            int i_160_ = i - i_129_;
            if (i_160_ < this.anInt6767) {
               i_160_ = this.anInt6767;
            }

            int i_161_ = i + i_129_;
            if (i_161_ > this.anInt6778 - 1) {
               i_161_ = this.anInt6778 - 1;
            }

            int i_162_ = i_160_ + i_127_ * this.anInt6789;

            for(int i_163_ = i_160_; i_163_ <= i_161_; ++i_163_) {
               int i_164_ = this.anIntArray6787[i_162_];
               int i_165_ = i_123_ + i_164_;
               int i_166_ = (i_123_ & 16711935) + (i_164_ & 16711935);
               i_164_ = (i_166_ & 16777472) + (i_165_ - i_166_ & 65536);
               this.anIntArray6787[i_162_++] = i_165_ - i_164_ | i_164_ - (i_164_ >>> 8);
            }

            ++i_127_;
            var35 += i_130_ + i_130_;
         }
      }
   }

   @Override
   final boolean o() {
      return false;
   }

   @Override
   final boolean l() {
      return true;
   }

   @Override
   final void DA(int i, int i_167_, int i_168_, int i_169_) {
      this.anInt6786 = i;
      this.anInt6769 = i_167_;
      this.anInt6785 = i_168_;
      this.anInt6763 = i_169_;
      this.method1506();
   }

   @Override
   final void aa(int i, int i_170_, int i_171_, int i_172_, int i_173_, int i_174_) {
      if (i < this.anInt6767) {
         i_171_ -= this.anInt6767 - i;
         i = this.anInt6767;
      }

      if (i_170_ < this.anInt6760) {
         i_172_ -= this.anInt6760 - i_170_;
         i_170_ = this.anInt6760;
      }

      if (i + i_171_ > this.anInt6778) {
         i_171_ = this.anInt6778 - i;
      }

      if (i_170_ + i_172_ > this.anInt6772) {
         i_172_ = this.anInt6772 - i_170_;
      }

      if (i_171_ > 0 && i_172_ > 0 && i <= this.anInt6778 && i_170_ <= this.anInt6772) {
         int i_175_ = this.anInt6789 - i_171_;
         int i_176_ = i + i_170_ * this.anInt6789;
         int i_177_ = i_173_ >>> 24;
         if (i_174_ == 0 || i_174_ == 1 && i_177_ == 255) {
            int i_178_ = i_171_ >> 3;
            int i_179_ = i_171_ & 7;
            i_171_ = i_176_ - 1;

            for(int i_180_ = -i_172_; i_180_ < 0; ++i_180_) {
               if (i_178_ > 0) {
                  i = i_178_;

                  do {
                     ++i_171_;
                     this.anIntArray6787[i_171_] = i_173_;
                     ++i_171_;
                     this.anIntArray6787[i_171_] = i_173_;
                     ++i_171_;
                     this.anIntArray6787[i_171_] = i_173_;
                     ++i_171_;
                     this.anIntArray6787[i_171_] = i_173_;
                     ++i_171_;
                     this.anIntArray6787[i_171_] = i_173_;
                     ++i_171_;
                     this.anIntArray6787[i_171_] = i_173_;
                     ++i_171_;
                     this.anIntArray6787[i_171_] = i_173_;
                     ++i_171_;
                     this.anIntArray6787[i_171_] = i_173_;
                  } while(--i > 0);
               }

               if (i_179_ > 0) {
                  i = i_179_;

                  do {
                     ++i_171_;
                     this.anIntArray6787[i_171_] = i_173_;
                  } while(--i > 0);
               }

               i_171_ += i_175_;
            }
         } else if (i_174_ == 1) {
            i_173_ = ((i_173_ & 16711935) * i_177_ >> 8 & 16711935) + (((i_173_ & -16711936) >>> 8) * i_177_ & -16711936);
            int i_181_ = 256 - i_177_;

            for(int i_182_ = 0; i_182_ < i_172_; ++i_182_) {
               for(int i_183_ = -i_171_; i_183_ < 0; ++i_183_) {
                  int i_184_ = this.anIntArray6787[i_176_];
                  i_184_ = ((i_184_ & 16711935) * i_181_ >> 8 & 16711935) + (((i_184_ & -16711936) >>> 8) * i_181_ & -16711936);
                  this.anIntArray6787[i_176_++] = i_173_ + i_184_;
               }

               i_176_ += i_175_;
            }
         } else {
            if (i_174_ != 2) {
               throw new IllegalArgumentException();
            }

            for(int i_185_ = 0; i_185_ < i_172_; ++i_185_) {
               for(int i_186_ = -i_171_; i_186_ < 0; ++i_186_) {
                  int i_187_ = this.anIntArray6787[i_176_];
                  int i_188_ = i_173_ + i_187_;
                  int i_189_ = (i_173_ & 16711935) + (i_187_ & 16711935);
                  i_187_ = (i_189_ & 16777472) + (i_188_ - i_189_ & 65536);
                  this.anIntArray6787[i_176_++] = i_188_ - i_187_ | i_187_ - (i_187_ >>> 8);
               }

               i_176_ += i_175_;
            }
         }
      }
   }

   @Override
   final void GA(int i) {
      this.aa(0, 0, this.anInt6789, this.anInt6791, i, 0);
   }

   @Override
   final void a(java.awt.Canvas canvas, int i, int i_190_) {
      GraphicsBuffer graphicsbuffer = (GraphicsBuffer)this.aHashTable6753.get(3512, (long)canvas.hashCode());
      if (graphicsbuffer != null) {
         graphicsbuffer.method2160((byte)56);
         graphicsbuffer = Class284.method3391(i_190_, canvas, 38, i);
         this.aHashTable6753.put((long)canvas.hashCode(), graphicsbuffer, -125);
         if (this.aCanvas6755 == canvas && this.aClass64_6771 == null) {
            Dimension dimension = canvas.getSize();
            this.anInt6752 = dimension.width;
            this.anInt6758 = dimension.height;
            this.aGraphicsBuffer6756 = graphicsbuffer;
            this.anIntArray6787 = graphicsbuffer.anIntArray7145;
            this.anInt6789 = graphicsbuffer.anInt7146;
            this.anInt6791 = graphicsbuffer.anInt7142;
            if (this.anInt6789 != this.anInt6765 || this.anInt6791 != this.anInt6783) {
               this.anInt6773 = this.anInt6765 = this.anInt6789;
               this.anInt6770 = this.anInt6783 = this.anInt6791;
               this.aFloatArray6792 = this.aFloatArray6782 = new float[this.anInt6765 * this.anInt6783];
            }

            this.method1496();
         }
      }
   }

   @Override
   final Interface20 d(int i, int i_191_) {
      return new Class131(i, i_191_);
   }

   @Override
   final Class336 n() {
      return this.aClass336_Sub2_6788;
   }

   @Override
   final void h() {
   }

   @Override
   final void a(
      int i, int i_192_, int i_193_, int i_194_, int i_195_, int i_196_, int i_197_, int i_198_, int i_199_, int i_200_, int i_201_, int i_202_, int i_203_
   ) {
      Class374 class374 = this.method1494(Thread.currentThread());
      Class185 class185 = class374.aClass185_4627;
      class185.aBoolean2226 = false;
      i -= this.anInt6793;
      i_194_ -= this.anInt6793;
      i_197_ -= this.anInt6793;
      i_192_ -= this.anInt6790;
      i_195_ -= this.anInt6790;
      i_198_ -= this.anInt6790;
      class185.aBoolean2217 = i < 0 || i > class185.anInt2222 || i_194_ < 0 || i_194_ > class185.anInt2222 || i_197_ < 0 || i_197_ > class185.anInt2222;
      int i_204_ = i_200_ >>> 24;
      if (i_203_ != 0 && (i_203_ != 1 || i_204_ != 255)) {
         if (i_203_ == 1) {
            class185.anInt2220 = 255 - i_204_;
            class185.aBoolean2212 = false;
            class185.method1850(
               (float)i_192_,
               (float)i_195_,
               (float)i_198_,
               (float)i,
               (float)i_194_,
               (float)i_197_,
               (float)i_193_,
               (float)i_196_,
               (float)i_199_,
               i_200_,
               i_201_,
               i_202_
            );
         } else {
            if (i_203_ != 2) {
               throw new IllegalArgumentException();
            }

            class185.anInt2220 = 128;
            class185.aBoolean2212 = true;
            class185.method1850(
               (float)i_192_,
               (float)i_195_,
               (float)i_198_,
               (float)i,
               (float)i_194_,
               (float)i_197_,
               (float)i_193_,
               (float)i_196_,
               (float)i_199_,
               i_200_,
               i_201_,
               i_202_
            );
         }
      } else {
         class185.anInt2220 = 0;
         class185.aBoolean2212 = false;
         class185.method1850(
            (float)i_192_,
            (float)i_195_,
            (float)i_198_,
            (float)i,
            (float)i_194_,
            (float)i_197_,
            (float)i_193_,
            (float)i_196_,
            (float)i_199_,
            i_200_,
            i_201_,
            i_202_
         );
      }

      class185.aBoolean2226 = true;
   }

   @Override
   final int XA() {
      return this.anInt6776;
   }

   @Override
   final int b(int i, int i_205_) {
      i |= 133120;
      return i & i_205_ ^ i_205_;
   }

   @Override
   final int[] Y() {
      return new int[]{this.anInt6786, this.anInt6769, this.anInt6785, this.anInt6763};
   }

   @Override
   final DrawableModel a(Model model, int i, int i_206_, int i_207_, int i_208_) {
      return new PureJavaDrawableModel(this, model, i, i_207_, i_208_, i_206_);
   }

   @Override
   final boolean B() {
      return false;
   }

   final boolean method1493(int i) {
      return this.aD1543.method7(9900, i);
   }

   final Class374 method1494(Runnable runnable) {
      for(int i = 0; i < this.anInt6795; ++i) {
         if (this.aClass374Array6777[i].aRunnable4622 == runnable) {
            return this.aClass374Array6777[i];
         }
      }

      return null;
   }

   @Override
   final void f(int i, int i_209_) {
      Class374 class374 = this.method1494(Thread.currentThread());
      this.anInt6798 = i;
      this.anInt6776 = i_209_;
      class374.anInt4618 = this.anInt6776 - 255;
   }

   @Override
   final void P(int i, int i_210_, int i_211_, int i_212_, int i_213_) {
      if (i >= this.anInt6767 && i < this.anInt6778) {
         if (i_210_ < this.anInt6760) {
            i_211_ -= this.anInt6760 - i_210_;
            i_210_ = this.anInt6760;
         }

         if (i_210_ + i_211_ > this.anInt6772) {
            i_211_ = this.anInt6772 - i_210_;
         }

         int i_214_ = i + i_210_ * this.anInt6789;
         int i_215_ = i_212_ >>> 24;
         if (i_213_ == 0 || i_213_ == 1 && i_215_ == 255) {
            for(int i_216_ = 0; i_216_ < i_211_; ++i_216_) {
               this.anIntArray6787[i_214_ + i_216_ * this.anInt6789] = i_212_;
            }
         } else if (i_213_ == 1) {
            i_212_ = ((i_212_ & 16711935) * i_215_ >> 8 & 16711935) + ((i_212_ & 0xFF00) * i_215_ >> 8 & 0xFF00) + (i_215_ << 24);
            int i_217_ = 256 - i_215_;

            for(int i_218_ = 0; i_218_ < i_211_; ++i_218_) {
               int i_219_ = i_214_ + i_218_ * this.anInt6789;
               int i_220_ = this.anIntArray6787[i_219_];
               i_220_ = ((i_220_ & 16711935) * i_217_ >> 8 & 16711935) + ((i_220_ & 0xFF00) * i_217_ >> 8 & 0xFF00);
               this.anIntArray6787[i_219_] = i_212_ + i_220_;
            }
         } else {
            if (i_213_ != 2) {
               throw new IllegalArgumentException();
            }

            for(int i_221_ = 0; i_221_ < i_211_; ++i_221_) {
               int i_222_ = i_214_ + i_221_ * this.anInt6789;
               int i_223_ = this.anIntArray6787[i_222_];
               int i_224_ = i_212_ + i_223_;
               int i_225_ = (i_212_ & 16711935) + (i_223_ & 16711935);
               i_223_ = (i_225_ & 16777472) + (i_224_ - i_225_ & 65536);
               this.anIntArray6787[i_222_] = i_224_ - i_223_ | i_223_ - (i_223_ >>> 8);
            }
         }
      }
   }

   @Override
   final void a(boolean bool) {
      this.aBoolean6794 = bool;
      this.aClass61_6781.method608(false);
   }

   @Override
   final Class336 A() {
      Class374 class374 = this.method1494(Thread.currentThread());
      return class374.aClass336_Sub2_4619;
   }

   @Override
   final void d() {
   }

   @Override
   final void d(int i, int i_226_, int i_227_, int i_228_, int i_229_, int i_230_) {
      this.U(i, i_226_, i_227_, i_229_, i_230_);
      this.U(i, i_226_ + i_228_ - 1, i_227_, i_229_, i_230_);
      this.P(i, i_226_ + 1, i_228_ - 2, i_229_, i_230_);
      this.P(i + i_227_ - 1, i_226_ + 1, i_228_ - 2, i_229_, i_230_);
   }

   @Override
   final void U(int i, int i_231_, int i_232_, int i_233_, int i_234_) {
      if (i_231_ >= this.anInt6760 && i_231_ < this.anInt6772) {
         if (i < this.anInt6767) {
            i_232_ -= this.anInt6767 - i;
            i = this.anInt6767;
         }

         if (i + i_232_ > this.anInt6778) {
            i_232_ = this.anInt6778 - i;
         }

         int i_235_ = i + i_231_ * this.anInt6789;
         int i_236_ = i_233_ >>> 24;
         if (i_234_ == 0 || i_234_ == 1 && i_236_ == 255) {
            for(int i_237_ = 0; i_237_ < i_232_; ++i_237_) {
               this.anIntArray6787[i_235_ + i_237_] = i_233_;
            }
         } else if (i_234_ == 1) {
            i_233_ = ((i_233_ & 16711935) * i_236_ >> 8 & 16711935) + ((i_233_ & 0xFF00) * i_236_ >> 8 & 0xFF00) + (i_236_ << 24);
            int i_238_ = 256 - i_236_;

            for(int i_239_ = 0; i_239_ < i_232_; ++i_239_) {
               int i_240_ = this.anIntArray6787[i_235_ + i_239_];
               i_240_ = ((i_240_ & 16711935) * i_238_ >> 8 & 16711935) + ((i_240_ & 0xFF00) * i_238_ >> 8 & 0xFF00);
               this.anIntArray6787[i_235_ + i_239_] = i_233_ + i_240_;
            }
         } else {
            if (i_234_ != 2) {
               throw new IllegalArgumentException();
            }

            for(int i_241_ = 0; i_241_ < i_232_; ++i_241_) {
               int i_242_ = this.anIntArray6787[i_235_ + i_241_];
               int i_243_ = i_233_ + i_242_;
               int i_244_ = (i_233_ & 16711935) + (i_242_ & 16711935);
               i_242_ = (i_244_ & 16777472) + (i_243_ - i_244_ & 65536);
               this.anIntArray6787[i_235_ + i_241_] = i_243_ - i_242_ | i_242_ - (i_242_ >>> 8);
            }
         }
      }
   }

   @Override
   final void ZA(int i, float f, float f_245_, float f_246_, float f_247_, float f_248_) {
      this.anInt6766 = (int)(f * 65535.0F);
      this.anInt6761 = (int)(f_245_ * 65535.0F);
      float f_249_ = (float)Math.sqrt((double)(f_246_ * f_246_ + f_247_ * f_247_ + f_248_ * f_248_));
      this.anInt6764 = (int)(f_246_ * 65535.0F / f_249_);
      this.anInt6784 = (int)(f_247_ * 65535.0F / f_249_);
      this.anInt6774 = (int)(f_248_ * 65535.0F / f_249_);
   }

   @Override
   final void C(boolean bool) {
      Class374 class374 = this.method1494(Thread.currentThread());
      class374.aBoolean4615 = bool;
   }

   @Override
   final void q() {
      this.aClass61_6781.method608(false);
      this.aClass61_6762.method608(false);
   }

   final int[] method1495(int i) {
      Node_Sub22 node_sub22;
      synchronized(this.aClass61_6781) {
         node_sub22 = (Node_Sub22)this.aClass61_6781.method607((long)i | Long.MIN_VALUE, 0);
         if (node_sub22 == null) {
            if (!this.aD1543.method7(9900, i)) {
               return null;
            }

            TextureDefinitions class91 = this.aD1543.getTexture(i, -8217);
            int i_250_ = !class91.skipTriangles && !this.aBoolean6794 ? this.anInt6775 : 64;
            node_sub22 = new Node_Sub22(i, i_250_, this.aD1543.method8(0.7F, i, i_250_, false, true, i_250_), class91.unknown1 != 1);
            this.aClass61_6781.method601(node_sub22, 25566, (long)i | Long.MIN_VALUE);
         }
      }

      node_sub22.aBoolean7193 = true;
      return node_sub22.method2619();
   }

   @Override
   final void f() {
   }

   @Override
   final void A(int i, aa var_aa, int i_251_, int i_252_) {
      aa_Sub1 var_aa_Sub1 = (aa_Sub1)var_aa;
      int[] is = var_aa_Sub1.anIntArray5487;
      int[] is_253_ = var_aa_Sub1.anIntArray5488;
      int i_254_;
      if (this.anInt6772 < i_252_ + is.length) {
         i_254_ = this.anInt6772 - i_252_;
      } else {
         i_254_ = is.length;
      }

      int i_255_;
      if (this.anInt6760 > i_252_) {
         i_255_ = this.anInt6760 - i_252_;
         i_252_ = this.anInt6760;
      } else {
         i_255_ = 0;
      }

      if (i_254_ - i_255_ > 0) {
         int i_256_ = i_252_ * this.anInt6789;

         for(int i_257_ = i_255_; i_257_ < i_254_; ++i_257_) {
            int i_258_ = i_251_ + is[i_257_];
            int i_259_ = is_253_[i_257_];
            if (this.anInt6767 > i_258_) {
               i_259_ -= this.anInt6767 - i_258_;
               i_258_ = this.anInt6767;
            }

            if (this.anInt6778 < i_258_ + i_259_) {
               i_259_ = this.anInt6778 - i_258_;
            }

            i_258_ += i_256_;

            for(int i_260_ = -i_259_; i_260_ < 0; ++i_260_) {
               this.anIntArray6787[i_258_++] = i;
            }

            i_256_ += this.anInt6789;
         }
      }
   }

   @Override
   final void a(int i, int i_261_, int i_262_, int i_263_, int i_264_, int i_265_, int i_266_, int i_267_, int i_268_) {
      i_262_ -= i;
      i_263_ -= i_261_;
      if (i_263_ == 0) {
         if (i_262_ >= 0) {
            this.method1501(i, i_261_, i_262_ + 1, i_264_, i_265_, i_266_, i_267_, i_268_);
         } else {
            int i_269_ = i_266_ + i_267_;
            i_268_ %= i_269_;
            i_268_ = i_269_ + i_266_ - i_268_ - (-i_262_ + 1) % i_269_;
            i_268_ %= i_269_;
            if (i_268_ < 0) {
               i_268_ += i_269_;
            }

            this.method1501(i + i_262_, i_261_, -i_262_ + 1, i_264_, i_265_, i_266_, i_267_, i_268_);
         }
      } else if (i_262_ == 0) {
         if (i_263_ >= 0) {
            this.method1490(i, i_261_, i_263_ + 1, i_264_, i_265_, i_266_, i_267_, i_268_);
         } else {
            int i_270_ = i_266_ + i_267_;
            i_268_ %= i_270_;
            i_268_ = i_270_ + i_266_ - i_268_ - (-i_263_ + 1) % i_270_;
            i_268_ %= i_270_;
            if (i_268_ < 0) {
               i_268_ += i_270_;
            }

            this.method1490(i, i_261_ + i_263_, -i_263_ + 1, i_264_, i_265_, i_266_, i_267_, i_268_);
         }
      } else {
         i_268_ <<= 8;
         i_266_ <<= 8;
         i_267_ <<= 8;
         int i_271_ = i_266_ + i_267_;
         i_268_ %= i_271_;
         if (i_262_ + i_263_ < 0) {
            int i_272_ = (int)(Math.sqrt((double)(i_262_ * i_262_ + i_263_ * i_263_)) * 256.0);
            int i_273_ = i_272_ % i_271_;
            i_268_ = i_271_ + i_266_ - i_268_ - i_273_;
            i_268_ %= i_271_;
            if (i_268_ < 0) {
               i_268_ += i_271_;
            }

            i += i_262_;
            i_262_ = -i_262_;
            i_261_ += i_263_;
            i_263_ = -i_263_;
         }

         if (i_262_ > i_263_) {
            i_261_ <<= 16;
            i_261_ += 32768;
            i_263_ <<= 16;
            int i_274_ = (int)Math.floor((double)i_263_ / (double)i_262_ + 0.5);
            i_262_ += i;
            int i_275_ = i_264_ >>> 24;
            int i_276_ = (int)Math.sqrt((double)(65536 + (i_274_ >> 8) * (i_274_ >> 8)));
            if (i_265_ == 0 || i_265_ == 1 && i_275_ == 255) {
               while(i <= i_262_) {
                  int i_277_ = i_261_ >> 16;
                  if (i >= this.anInt6767 && i < this.anInt6778 && i_277_ >= this.anInt6760 && i_277_ < this.anInt6772 && i_268_ < i_266_) {
                     this.anIntArray6787[i + i_277_ * this.anInt6789] = i_264_;
                  }

                  i_261_ += i_274_;
                  ++i;
                  i_268_ += i_276_;
                  i_268_ %= i_271_;
               }

               return;
            }

            if (i_265_ == 1) {
               i_264_ = ((i_264_ & 16711935) * i_275_ >> 8 & 16711935) + ((i_264_ & 0xFF00) * i_275_ >> 8 & 0xFF00) + (i_275_ << 24);

               for(int i_278_ = 256 - i_275_; i <= i_262_; i_268_ %= i_271_) {
                  int i_279_ = i_261_ >> 16;
                  if (i >= this.anInt6767 && i < this.anInt6778 && i_279_ >= this.anInt6760 && i_279_ < this.anInt6772 && i_268_ < i_266_) {
                     int i_280_ = i + i_279_ * this.anInt6789;
                     int i_281_ = this.anIntArray6787[i_280_];
                     i_281_ = ((i_281_ & 16711935) * i_278_ >> 8 & 16711935) + ((i_281_ & 0xFF00) * i_278_ >> 8 & 0xFF00);
                     this.anIntArray6787[i_280_] = i_264_ + i_281_;
                  }

                  i_261_ += i_274_;
                  ++i;
                  i_268_ += i_276_;
               }

               return;
            }

            if (i_265_ == 2) {
               while(i <= i_262_) {
                  int i_282_ = i_261_ >> 16;
                  if (i >= this.anInt6767 && i < this.anInt6778 && i_282_ >= this.anInt6760 && i_282_ < this.anInt6772 && i_268_ < i_266_) {
                     int i_283_ = i + i_282_ * this.anInt6789;
                     int i_284_ = this.anIntArray6787[i_283_];
                     int i_285_ = i_264_ + i_284_;
                     int i_286_ = (i_264_ & 16711935) + (i_284_ & 16711935);
                     i_284_ = (i_286_ & 16777472) + (i_285_ - i_286_ & 65536);
                     this.anIntArray6787[i_283_] = i_285_ - i_284_ | i_284_ - (i_284_ >>> 8);
                  }

                  i_261_ += i_274_;
                  ++i;
                  i_268_ += i_276_;
                  i_268_ %= i_271_;
               }

               return;
            }

            throw new IllegalArgumentException();
         }

         i <<= 16;
         i += 32768;
         i_262_ <<= 16;
         int i_287_ = (int)Math.floor((double)i_262_ / (double)i_263_ + 0.5);
         i_263_ += i_261_;
         int i_288_ = i_264_ >>> 24;
         int i_289_ = (int)Math.sqrt((double)(65536 + (i_287_ >> 8) * (i_287_ >> 8)));
         if (i_265_ == 0 || i_265_ == 1 && i_288_ == 255) {
            while(i_261_ <= i_263_) {
               int i_290_ = i >> 16;
               if (i_261_ >= this.anInt6760 && i_261_ < this.anInt6772 && i_290_ >= this.anInt6767 && i_290_ < this.anInt6778 && i_268_ < i_266_) {
                  this.anIntArray6787[i_290_ + i_261_ * this.anInt6789] = i_264_;
               }

               i += i_287_;
               ++i_261_;
               i_268_ += i_289_;
               i_268_ %= i_271_;
            }
         } else if (i_265_ == 1) {
            i_264_ = ((i_264_ & 16711935) * i_288_ >> 8 & 16711935) + ((i_264_ & 0xFF00) * i_288_ >> 8 & 0xFF00) + (i_288_ << 24);

            for(int i_291_ = 256 - i_288_; i_261_ <= i_263_; i_268_ %= i_271_) {
               int i_292_ = i >> 16;
               if (i_261_ >= this.anInt6760 && i_261_ < this.anInt6772 && i_292_ >= this.anInt6767 && i_292_ < this.anInt6778 && i_268_ < i_266_) {
                  int i_293_ = i_292_ + i_261_ * this.anInt6789;
                  int i_294_ = this.anIntArray6787[i_293_];
                  i_294_ = ((i_294_ & 16711935) * i_291_ >> 8 & 16711935) + ((i_294_ & 0xFF00) * i_291_ >> 8 & 0xFF00);
                  this.anIntArray6787[i_292_ + i_261_ * this.anInt6789] = i_264_ + i_294_;
               }

               i += i_287_;
               ++i_261_;
               i_268_ += i_289_;
            }
         } else {
            if (i_265_ != 2) {
               throw new IllegalArgumentException();
            }

            while(i_261_ <= i_263_) {
               int i_295_ = i >> 16;
               if (i_261_ >= this.anInt6760 && i_261_ < this.anInt6772 && i_295_ >= this.anInt6767 && i_295_ < this.anInt6778 && i_268_ < i_266_) {
                  int i_296_ = i_295_ + i_261_ * this.anInt6789;
                  int i_297_ = this.anIntArray6787[i_296_];
                  int i_298_ = i_264_ + i_297_;
                  int i_299_ = (i_264_ & 16711935) + (i_297_ & 16711935);
                  i_297_ = (i_299_ & 16777472) + (i_298_ - i_299_ & 65536);
                  this.anIntArray6787[i_296_] = i_298_ - i_297_ | i_297_ - (i_297_ >>> 8);
               }

               i += i_287_;
               ++i_261_;
               i_268_ += i_289_;
               i_268_ %= i_271_;
            }
         }
      }
   }

   @Override
   final void K(int[] is) {
      is[0] = this.anInt6767;
      is[1] = this.anInt6760;
      is[2] = this.anInt6778;
      is[3] = this.anInt6772;
   }

   @Override
   final int i() {
      return this.anInt6798;
   }

   @Override
   final Renderer c() {
      return new Renderer(0, "Pure Java", 1, "CPU", 0L);
   }

   @Override
   final void f(int i) {
      this.anInt6775 = i;
      this.aClass61_6781.method608(false);
   }

   @Override
   final void a(Rectangle[] rectangles, int i, int i_300_, int i_301_) throws Exception_Sub1 {
      if (this.aCanvas6755 != null && this.aGraphicsBuffer6756 != null) {
         try {
            Graphics graphics = this.aCanvas6755.getGraphics();

            for(int i_302_ = 0; i_302_ < i; ++i_302_) {
               Rectangle rectangle = rectangles[i_302_];
               if (rectangle.x + i_300_ <= this.anInt6789
                  && rectangle.y + i_301_ <= this.anInt6791
                  && rectangle.x + i_300_ + rectangle.width > 0
                  && rectangle.y + i_301_ + rectangle.height > 0) {
                  this.aGraphicsBuffer6756
                     .method2597(rectangle.width, rectangle.x + i_300_, rectangle.x, false, graphics, rectangle.height, rectangle.y, rectangle.y + i_301_);
               }
            }
         } catch (Exception var8) {
            this.aCanvas6755.repaint();
         }
      } else {
         throw new IllegalStateException("off");
      }
   }

   private final void method1496() {
      for(int i = 0; i < this.anInt6795; ++i) {
         this.aClass374Array6777[i].method4109(false);
      }

      this.la();
   }

   @Override
   final void a(za var_za) {
   }

   @Override
   final void k(int i) {
      this.aClass374Array6777[i].method4111(Thread.currentThread(), 0);
   }

   @Override
   final boolean p() {
      return false;
   }

   @Override
   final void a(int[] is) {
      is[0] = this.anInt6789;
      is[1] = this.anInt6791;
   }

   private PureJavaToolkit(d var_d) {
      super(var_d);
      this.aBoolean6757 = false;
      this.aHashTable6753 = new HashTable(4);
      this.anInt6760 = 0;
      this.anInt6763 = 512;
      this.anInt6780 = 75518;
      this.anInt6778 = 0;
      this.anInt6776 = 3500;
      this.anInt6775 = 128;
      this.anInt6772 = 0;
      this.anInt6766 = 45823;
      this.anInt6767 = 0;
      this.anInt6761 = 78642;
      this.aBoolean6794 = false;
      this.anInt6796 = 0;
      this.anInt6797 = 0;
      this.anInt6798 = 50;
      this.anInt6785 = 512;
      this.aClass61_6762 = new Class61(16);
      this.anInt6800 = -1;

      try {
         this.aClass61_6781 = new Class61(256);
         this.aClass336_Sub2_6788 = new Class336_Sub2();
         this.j(1);
         this.k(0);
         Class110.method1132(0, true, true);
         this.aBoolean6757 = true;
         this.anInt6754 = (int)Class313.method3650(false);
      } catch (Throwable var3) {
         var3.printStackTrace();
         this.method1233(-7751);
         throw new RuntimeException("");
      }
   }

   @Override
   final void a(int i, int i_303_, int i_304_, int i_305_) {
   }

   @Override
   final int c(int i, int i_306_) {
      return i | i_306_;
   }

   @Override
   final Interface4 a(int i, int i_307_) {
      return this.a(i, i_307_, false);
   }

   @Override
   final void H(int i, int i_308_, int i_309_, int[] is) {
      float f = this.aClass336_Sub2_6788.aFloat8589
         + this.aClass336_Sub2_6788.aFloat8577 * (float)i
         + this.aClass336_Sub2_6788.aFloat8567 * (float)i_308_
         + this.aClass336_Sub2_6788.aFloat8584 * (float)i_309_;
      if (f == 0.0F) {
         is[0] = is[1] = is[2] = -1;
      } else {
         int i_310_ = (int)(
            (float)this.anInt6785
               * (
                  this.aClass336_Sub2_6788.aFloat8583
                     + this.aClass336_Sub2_6788.aFloat8580 * (float)i
                     + this.aClass336_Sub2_6788.aFloat8571 * (float)i_308_
                     + this.aClass336_Sub2_6788.aFloat8566 * (float)i_309_
               )
               / f
         );
         int i_311_ = (int)(
            (float)this.anInt6763
               * (
                  this.aClass336_Sub2_6788.aFloat8579
                     + this.aClass336_Sub2_6788.aFloat8578 * (float)i
                     + this.aClass336_Sub2_6788.aFloat8561 * (float)i_308_
                     + this.aClass336_Sub2_6788.aFloat8558 * (float)i_309_
               )
               / f
         );
         is[0] = i_310_ - this.anInt6793;
         is[1] = i_311_ - this.anInt6790;
         is[2] = (int)f;
      }
   }

   @Override
   final boolean x() {
      return false;
   }

   @Override
   final void ra(int i, int i_312_, int i_313_, int i_314_) {
      for(int i_315_ = 0; i_315_ < this.aClass374Array6777.length; ++i_315_) {
         this.aClass374Array6777[i_315_].anInt4616 = this.aClass374Array6777[i_315_].anInt4611;
         this.aClass374Array6777[i_315_].anInt4624 = i;
         this.aClass374Array6777[i_315_].anInt4611 = i_312_;
         this.aClass374Array6777[i_315_].anInt4620 = i_313_;
         this.aClass374Array6777[i_315_].aBoolean4617 = true;
      }
   }

   private final void method1497(int i, int i_316_, int i_317_, int i_318_, int i_319_, int i_320_) {
      if (i_318_ < 0) {
         i_318_ = -i_318_;
      }

      int i_321_ = i_316_ - i_318_;
      if (i_321_ < this.anInt6760) {
         i_321_ = this.anInt6760;
      }

      int i_322_ = i_316_ + i_318_ + 1;
      if (i_322_ > this.anInt6772) {
         i_322_ = this.anInt6772;
      }

      int i_323_ = i_321_;
      int i_324_ = i_318_ * i_318_;
      int i_325_ = 0;
      int i_326_ = i_316_ - i_321_;
      int i_327_ = i_326_ * i_326_;
      int i_328_ = i_327_ - i_326_;
      if (i_316_ > i_322_) {
         i_316_ = i_322_;
      }

      int i_329_ = i_319_ >>> 24;
      if (i_320_ == 0 || i_320_ == 1 && i_329_ == 255) {
         while(i_323_ < i_316_) {
            while(i_328_ <= i_324_ || i_327_ <= i_324_) {
               i_327_ += i_325_ + i_325_;
               i_328_ += i_325_++ + i_325_;
            }

            int i_330_ = i - i_325_ + 1;
            if (i_330_ < this.anInt6767) {
               i_330_ = this.anInt6767;
            }

            int i_331_ = i + i_325_;
            if (i_331_ > this.anInt6778) {
               i_331_ = this.anInt6778;
            }

            int i_332_ = i_330_ + i_323_ * this.anInt6789;

            for(int i_333_ = i_330_; i_333_ < i_331_; ++i_333_) {
               if ((float)i_317_ < this.aFloatArray6782[i_332_]) {
                  this.anIntArray6787[i_332_] = i_319_;
               }

               ++i_332_;
            }

            ++i_323_;
            i_327_ -= i_326_-- + i_326_;
            i_328_ -= i_326_ + i_326_;
         }

         i_325_ = i_318_;
         i_326_ = i_323_ - i_316_;
         i_328_ = i_326_ * i_326_ + i_324_;
         i_327_ = i_328_ - i_318_;

         for(int var38 = i_328_ - i_326_; i_323_ < i_322_; i_327_ += i_326_++ + i_326_) {
            while(var38 > i_324_ && i_327_ > i_324_) {
               var38 -= i_325_-- + i_325_;
               i_327_ -= i_325_ + i_325_;
            }

            int i_334_ = i - i_325_;
            if (i_334_ < this.anInt6767) {
               i_334_ = this.anInt6767;
            }

            int i_335_ = i + i_325_;
            if (i_335_ > this.anInt6778 - 1) {
               i_335_ = this.anInt6778 - 1;
            }

            int i_336_ = i_334_ + i_323_ * this.anInt6789;

            for(int i_337_ = i_334_; i_337_ <= i_335_; ++i_337_) {
               if ((float)i_317_ < this.aFloatArray6782[i_336_]) {
                  this.anIntArray6787[i_336_] = i_319_;
               }

               ++i_336_;
            }

            ++i_323_;
            var38 += i_326_ + i_326_;
         }

         return;
      } else if (i_320_ == 1) {
         i_319_ = ((i_319_ & 16711935) * i_329_ >> 8 & 16711935) + ((i_319_ & 0xFF00) * i_329_ >> 8 & 0xFF00) + (i_329_ << 24);

         int i_338_;
         for(i_338_ = 256 - i_329_; i_323_ < i_316_; i_328_ -= i_326_ + i_326_) {
            while(i_328_ <= i_324_ || i_327_ <= i_324_) {
               i_327_ += i_325_ + i_325_;
               i_328_ += i_325_++ + i_325_;
            }

            int i_339_ = i - i_325_ + 1;
            if (i_339_ < this.anInt6767) {
               i_339_ = this.anInt6767;
            }

            int i_340_ = i + i_325_;
            if (i_340_ > this.anInt6778) {
               i_340_ = this.anInt6778;
            }

            int i_341_ = i_339_ + i_323_ * this.anInt6789;

            for(int i_342_ = i_339_; i_342_ < i_340_; ++i_342_) {
               if ((float)i_317_ < this.aFloatArray6782[i_341_]) {
                  int i_343_ = this.anIntArray6787[i_341_];
                  i_343_ = ((i_343_ & 16711935) * i_338_ >> 8 & 16711935) + ((i_343_ & 0xFF00) * i_338_ >> 8 & 0xFF00);
                  this.anIntArray6787[i_341_] = i_319_ + i_343_;
               }

               ++i_341_;
            }

            ++i_323_;
            i_327_ -= i_326_-- + i_326_;
         }

         i_325_ = i_318_;
         i_326_ = -i_326_;
         i_328_ = i_326_ * i_326_ + i_324_;
         i_327_ = i_328_ - i_318_;

         for(int var34 = i_328_ - i_326_; i_323_ < i_322_; i_327_ += i_326_++ + i_326_) {
            while(var34 > i_324_ && i_327_ > i_324_) {
               var34 -= i_325_-- + i_325_;
               i_327_ -= i_325_ + i_325_;
            }

            int i_344_ = i - i_325_;
            if (i_344_ < this.anInt6767) {
               i_344_ = this.anInt6767;
            }

            int i_345_ = i + i_325_;
            if (i_345_ > this.anInt6778 - 1) {
               i_345_ = this.anInt6778 - 1;
            }

            int i_346_ = i_344_ + i_323_ * this.anInt6789;

            for(int i_347_ = i_344_; i_347_ <= i_345_; ++i_347_) {
               if ((float)i_317_ < this.aFloatArray6782[i_346_]) {
                  int i_348_ = this.anIntArray6787[i_346_];
                  i_348_ = ((i_348_ & 16711935) * i_338_ >> 8 & 16711935) + ((i_348_ & 0xFF00) * i_338_ >> 8 & 0xFF00);
                  this.anIntArray6787[i_346_] = i_319_ + i_348_;
               }

               ++i_346_;
            }

            ++i_323_;
            var34 += i_326_ + i_326_;
         }
      } else {
         if (i_320_ != 2) {
            throw new IllegalArgumentException();
         }

         while(i_323_ < i_316_) {
            while(i_328_ <= i_324_ || i_327_ <= i_324_) {
               i_327_ += i_325_ + i_325_;
               i_328_ += i_325_++ + i_325_;
            }

            int i_349_ = i - i_325_ + 1;
            if (i_349_ < this.anInt6767) {
               i_349_ = this.anInt6767;
            }

            int i_350_ = i + i_325_;
            if (i_350_ > this.anInt6778) {
               i_350_ = this.anInt6778;
            }

            int i_351_ = i_349_ + i_323_ * this.anInt6789;

            for(int i_352_ = i_349_; i_352_ < i_350_; ++i_352_) {
               if ((float)i_317_ < this.aFloatArray6782[i_351_]) {
                  int i_353_ = this.anIntArray6787[i_351_];
                  int i_354_ = i_319_ + i_353_;
                  int i_355_ = (i_319_ & 16711935) + (i_353_ & 16711935);
                  i_353_ = (i_355_ & 16777472) + (i_354_ - i_355_ & 65536);
                  this.anIntArray6787[i_351_] = i_354_ - i_353_ | i_353_ - (i_353_ >>> 8);
               }

               ++i_351_;
            }

            ++i_323_;
            i_327_ -= i_326_-- + i_326_;
            i_328_ -= i_326_ + i_326_;
         }

         i_325_ = i_318_;
         i_326_ = -i_326_;
         i_328_ = i_326_ * i_326_ + i_324_;
         i_327_ = i_328_ - i_318_;

         for(int var36 = i_328_ - i_326_; i_323_ < i_322_; i_327_ += i_326_++ + i_326_) {
            while(var36 > i_324_ && i_327_ > i_324_) {
               var36 -= i_325_-- + i_325_;
               i_327_ -= i_325_ + i_325_;
            }

            int i_356_ = i - i_325_;
            if (i_356_ < this.anInt6767) {
               i_356_ = this.anInt6767;
            }

            int i_357_ = i + i_325_;
            if (i_357_ > this.anInt6778 - 1) {
               i_357_ = this.anInt6778 - 1;
            }

            int i_358_ = i_356_ + i_323_ * this.anInt6789;

            for(int i_359_ = i_356_; i_359_ <= i_357_; ++i_359_) {
               if ((float)i_317_ < this.aFloatArray6782[i_358_]) {
                  int i_360_ = this.anIntArray6787[i_358_];
                  int i_361_ = i_319_ + i_360_;
                  int i_362_ = (i_319_ & 16711935) + (i_360_ & 16711935);
                  i_360_ = (i_362_ & 16777472) + (i_361_ - i_362_ & 65536);
                  this.anIntArray6787[i_358_] = i_361_ - i_360_ | i_360_ - (i_360_ >>> 8);
               }

               ++i_358_;
            }

            ++i_323_;
            var36 += i_326_ + i_326_;
         }
      }
   }

   @Override
   final void KA(int i, int i_363_, int i_364_, int i_365_) {
      if (i < 0) {
         i = 0;
      }

      if (i_363_ < 0) {
         i_363_ = 0;
      }

      if (i_364_ > this.anInt6789) {
         i_364_ = this.anInt6789;
      }

      if (i_365_ > this.anInt6791) {
         i_365_ = this.anInt6791;
      }

      this.anInt6767 = i;
      this.anInt6778 = i_364_;
      this.anInt6760 = i_363_;
      this.anInt6772 = i_365_;
      this.method1506();
   }

   @Override
   final aa a(int i, int i_366_, int[] is, int[] is_367_) {
      return new aa_Sub1(i, i_366_, is, is_367_);
   }

   @Override
   final Class270 a(Class270 class270, Class270 class270_368_, float f, Class270 class270_369_) {
      return null;
   }

   @Override
   final Node_Sub29 a(int i, int i_370_, int i_371_, int i_372_, int i_373_, float f) {
      return null;
   }

   @Override
   final void da(int i, int i_374_, int i_375_, int[] is) {
      float f = this.aClass336_Sub2_6788.aFloat8589
         + this.aClass336_Sub2_6788.aFloat8577 * (float)i
         + this.aClass336_Sub2_6788.aFloat8567 * (float)i_374_
         + this.aClass336_Sub2_6788.aFloat8584 * (float)i_375_;
      if (!(f < (float)this.anInt6798) && !(f > (float)this.anInt6776)) {
         int i_376_ = (int)(
            (float)this.anInt6785
               * (
                  this.aClass336_Sub2_6788.aFloat8583
                     + this.aClass336_Sub2_6788.aFloat8580 * (float)i
                     + this.aClass336_Sub2_6788.aFloat8571 * (float)i_374_
                     + this.aClass336_Sub2_6788.aFloat8566 * (float)i_375_
               )
               / f
         );
         int i_377_ = (int)(
            (float)this.anInt6763
               * (
                  this.aClass336_Sub2_6788.aFloat8579
                     + this.aClass336_Sub2_6788.aFloat8578 * (float)i
                     + this.aClass336_Sub2_6788.aFloat8561 * (float)i_374_
                     + this.aClass336_Sub2_6788.aFloat8558 * (float)i_375_
               )
               / f
         );
         if (i_376_ >= this.anInt6793 && i_376_ <= this.anInt6768 && i_377_ >= this.anInt6790 && i_377_ <= this.anInt6779) {
            is[0] = i_376_ - this.anInt6793;
            is[1] = i_377_ - this.anInt6790;
            is[2] = (int)f;
         } else {
            is[0] = is[1] = is[2] = -1;
         }
      } else {
         is[0] = is[1] = is[2] = -1;
      }
   }

   @Override
   final void HA(int i, int i_378_, int i_379_, int i_380_, int[] is) {
      float f = this.aClass336_Sub2_6788.aFloat8589
         + this.aClass336_Sub2_6788.aFloat8577 * (float)i
         + this.aClass336_Sub2_6788.aFloat8567 * (float)i_378_
         + this.aClass336_Sub2_6788.aFloat8584 * (float)i_379_;
      if (!(f < (float)this.anInt6798) && !(f > (float)this.anInt6776)) {
         int i_381_ = (int)(
            (float)this.anInt6785
               * (
                  this.aClass336_Sub2_6788.aFloat8583
                     + this.aClass336_Sub2_6788.aFloat8580 * (float)i
                     + this.aClass336_Sub2_6788.aFloat8571 * (float)i_378_
                     + this.aClass336_Sub2_6788.aFloat8566 * (float)i_379_
               )
               / (float)i_380_
         );
         int i_382_ = (int)(
            (float)this.anInt6763
               * (
                  this.aClass336_Sub2_6788.aFloat8579
                     + this.aClass336_Sub2_6788.aFloat8578 * (float)i
                     + this.aClass336_Sub2_6788.aFloat8561 * (float)i_378_
                     + this.aClass336_Sub2_6788.aFloat8558 * (float)i_379_
               )
               / (float)i_380_
         );
         if (i_381_ >= this.anInt6793 && i_381_ <= this.anInt6768 && i_382_ >= this.anInt6790 && i_382_ <= this.anInt6779) {
            is[0] = i_381_ - this.anInt6793;
            is[1] = i_382_ - this.anInt6790;
            is[2] = (int)f;
         } else {
            is[0] = is[1] = is[2] = -1;
         }
      } else {
         is[0] = is[1] = is[2] = -1;
      }
   }

   @Override
   final boolean k() {
      return false;
   }

   @Override
   final void c(int i) {
      this.aClass374Array6777[i].method4111(null, 0);
   }

   @Override
   final void j(int i) {
      this.anInt6795 = i;
      this.aClass374Array6777 = new Class374[this.anInt6795];

      for(int i_383_ = 0; i_383_ < this.anInt6795; ++i_383_) {
         this.aClass374Array6777[i_383_] = new Class374(this);
      }
   }

   @Override
   final void b(int i) {
      PureJavaDrawableModel.anInt5724 = i;
      PureJavaDrawableModel.anInt5742 = i;
      if (this.anInt6795 > 1) {
         throw new IllegalStateException("No MT");
      } else {
         this.j(this.anInt6795);
         this.k(0);
      }
   }

   @Override
   final GLSprite a(int[] is, int i, int i_384_, int i_385_, int i_386_, boolean bool) {
      boolean bool_387_ = false;
      int i_388_ = i;

      for(int i_389_ = 0; i_389_ < i_386_; ++i_389_) {
         for(int i_390_ = 0; i_390_ < i_385_; ++i_390_) {
            int i_391_ = is[i_388_++] >>> 24;
            if (i_391_ != 0 && i_391_ != 255) {
               bool_387_ = true;
               return (GLSprite)(bool_387_
                  ? new GLSprite_Sub2_Sub2(this, is, i, i_384_, i_385_, i_386_, bool)
                  : new GLSprite_Sub2_Sub1(this, is, i, i_384_, i_385_, i_386_, bool));
            }
         }
      }

      return (GLSprite)(bool_387_
         ? new GLSprite_Sub2_Sub2(this, is, i, i_384_, i_385_, i_386_, bool)
         : new GLSprite_Sub2_Sub1(this, is, i, i_384_, i_385_, i_386_, bool));
   }

   @Override
   final int E() {
      return 0;
   }

   @Override
   final void a(Class270 class270) {
   }

   @Override
   final boolean s() {
      return true;
   }

   @Override
   final void e(int i) {
      int i_392_ = i - this.anInt6754;

      for(Object object = this.aClass61_6781.method596(102); object != null; object = this.aClass61_6781.method603((byte)-22)) {
         Node_Sub22 node_sub22 = (Node_Sub22)object;
         if (node_sub22.aBoolean7193) {
            node_sub22.anInt7189 += i_392_;
            int i_393_ = node_sub22.anInt7189 / 20;
            if (i_393_ > 0) {
               TextureDefinitions class91 = this.aD1543.getTexture(node_sub22.anInt7188, -8217);
               node_sub22.method2620(class91.speedU * i_392_ * 50 / 1000, class91.speedV * i_392_ * 50 / 1000);
               node_sub22.anInt7189 -= i_393_ * 20;
            }

            node_sub22.aBoolean7193 = false;
         }
      }

      this.anInt6754 = i;
      this.aClass61_6762.method598(5, -11819);
      this.aClass61_6781.method598(5, -11819);
   }

   @Override
   final void a(float f, float f_394_, float f_395_) {
   }

   final void method1498(int i, int i_396_, int i_397_, int i_398_, int i_399_, int i_400_, int i_401_, int i_402_, int i_403_, int i_404_) {
      if (i_398_ != 0 && i_399_ != 0) {
         if (i_401_ != 65535 && !this.aD1543.getTexture(i_401_, -8217).meshGround) {
            if (this.anInt6800 != i_401_) {
               GLSprite glsprite = (GLSprite)this.aClass61_6762.method607((long)i_401_, 0);
               if (glsprite == null) {
                  int[] is = this.method1495(i_401_);
                  if (is == null) {
                     return;
                  }

                  int i_405_ = this.method1505(i_401_) ? 64 : this.anInt6775;
                  glsprite = this.method1235(i_405_, i_405_, i_405_, is, 0, 7468);
                  this.aClass61_6762.method601(glsprite, 25566, (long)i_401_);
               }

               this.anInt6800 = i_401_;
               this.aGLSprite6799 = glsprite;
            }

            ((GLSprite_Sub2)this.aGLSprite6799).method1208(i - i_398_, i_396_ - i_399_, i_397_, i_398_ << 1, i_399_ << 1, i_403_, i_402_, i_404_, 1);
         } else {
            this.method1497(i, i_396_, i_397_, i_398_, i_402_, i_404_);
         }
      }
   }

   @Override
   final GLSprite a(int i, int i_406_, int i_407_, int i_408_, boolean bool) {
      int[] is = new int[i_407_ * i_408_];
      int i_409_ = i_406_ * this.anInt6789 + i;
      int i_410_ = this.anInt6789 - i_407_;

      for(int i_411_ = 0; i_411_ < i_408_; ++i_411_) {
         int i_412_ = i_411_ * i_407_;

         for(int i_413_ = 0; i_413_ < i_407_; ++i_413_) {
            is[i_412_ + i_413_] = this.anIntArray6787[i_409_++];
         }

         i_409_ += i_410_;
      }

      return (GLSprite)(bool ? new GLSprite_Sub2_Sub2(this, is, i_407_, i_408_) : new GLSprite_Sub2_Sub1(this, is, i_407_, i_408_));
   }

   @Override
   final void T(int i, int i_414_, int i_415_, int i_416_) {
      if (this.anInt6767 < i) {
         this.anInt6767 = i;
      }

      if (this.anInt6760 < i_414_) {
         this.anInt6760 = i_414_;
      }

      if (this.anInt6778 > i_415_) {
         this.anInt6778 = i_415_;
      }

      if (this.anInt6772 > i_416_) {
         this.anInt6772 = i_416_;
      }

      this.method1506();
   }

   @Override
   final GLSprite a(Class383 class383, boolean bool) {
      int[] is = class383.anIntArray4904;
      byte[] bs = class383.aByteArray4903;
      int i = class383.anInt4897;
      int i_417_ = class383.anInt4900;
      GLSprite_Sub2 glsprite_sub2;
      if (bool && class383.aByteArray4905 == null) {
         int[] is_418_ = new int[is.length];
         byte[] bs_419_ = new byte[i * i_417_];

         for(int i_420_ = 0; i_420_ < i_417_; ++i_420_) {
            int i_421_ = i_420_ * i;

            for(int i_422_ = 0; i_422_ < i; ++i_422_) {
               bs_419_[i_421_ + i_422_] = bs[i_421_ + i_422_];
            }
         }

         for(int i_423_ = 0; i_423_ < is.length; ++i_423_) {
            is_418_[i_423_] = is[i_423_];
         }

         glsprite_sub2 = new GLSprite_Sub2_Sub3(this, bs_419_, is_418_, i, i_417_);
      } else {
         int[] is_424_ = new int[i * i_417_];
         byte[] bs_425_ = class383.aByteArray4905;
         if (bs_425_ != null) {
            for(int i_426_ = 0; i_426_ < i_417_; ++i_426_) {
               int i_427_ = i_426_ * i;

               for(int i_428_ = 0; i_428_ < i; ++i_428_) {
                  is_424_[i_427_ + i_428_] = is[bs[i_427_ + i_428_] & 255] | bs_425_[i_427_ + i_428_] << 24;
               }
            }

            glsprite_sub2 = new GLSprite_Sub2_Sub2(this, is_424_, i, i_417_);
         } else {
            for(int i_429_ = 0; i_429_ < i_417_; ++i_429_) {
               int i_430_ = i_429_ * i;

               for(int i_431_ = 0; i_431_ < i; ++i_431_) {
                  int i_432_ = is[bs[i_430_ + i_431_] & 255];
                  is_424_[i_430_ + i_431_] = i_432_ != 0 ? 0xFF000000 | i_432_ : 0;
               }
            }

            glsprite_sub2 = new GLSprite_Sub2_Sub1(this, is_424_, i, i_417_);
         }
      }

      glsprite_sub2.method1178(class383.anInt4902, class383.anInt4898, class383.anInt4901, class383.anInt4899);
      return glsprite_sub2;
   }

   @Override
   final Plane a(int i, int i_433_, int[][] is, int[][] is_434_, int i_435_, int i_436_, int i_437_) {
      return new Plane_Sub1(this, i_436_, i_437_, i, i_433_, is, is_434_, i_435_);
   }

   @Override
   final int JA(int i, int i_438_, int i_439_, int i_440_, int i_441_, int i_442_) {
      int i_443_ = 0;
      float f = this.aClass336_Sub2_6788.aFloat8577 * (float)i
         + this.aClass336_Sub2_6788.aFloat8567 * (float)i_438_
         + this.aClass336_Sub2_6788.aFloat8584 * (float)i_439_
         + this.aClass336_Sub2_6788.aFloat8589;
      if (f < 1.0F) {
         f = 1.0F;
      }

      float f_444_ = this.aClass336_Sub2_6788.aFloat8577 * (float)i_440_
         + this.aClass336_Sub2_6788.aFloat8567 * (float)i_441_
         + this.aClass336_Sub2_6788.aFloat8584 * (float)i_442_
         + this.aClass336_Sub2_6788.aFloat8589;
      if (f_444_ < 1.0F) {
         f_444_ = 1.0F;
      }

      if (f < (float)this.anInt6798 && f_444_ < (float)this.anInt6798) {
         i_443_ |= 16;
      } else if (f > (float)this.anInt6776 && f_444_ > (float)this.anInt6776) {
         i_443_ |= 32;
      }

      int i_445_ = (int)(
         (float)this.anInt6785
            * (
               this.aClass336_Sub2_6788.aFloat8580 * (float)i
                  + this.aClass336_Sub2_6788.aFloat8571 * (float)i_438_
                  + this.aClass336_Sub2_6788.aFloat8566 * (float)i_439_
                  + this.aClass336_Sub2_6788.aFloat8583
            )
            / f
      );
      int i_446_ = (int)(
         (float)this.anInt6785
            * (
               this.aClass336_Sub2_6788.aFloat8580 * (float)i_440_
                  + this.aClass336_Sub2_6788.aFloat8571 * (float)i_441_
                  + this.aClass336_Sub2_6788.aFloat8566 * (float)i_442_
                  + this.aClass336_Sub2_6788.aFloat8583
            )
            / f_444_
      );
      if (i_445_ < this.anInt6793 && i_446_ < this.anInt6793) {
         i_443_ |= 1;
      } else if (i_445_ > this.anInt6768 && i_446_ > this.anInt6768) {
         i_443_ |= 2;
      }

      int i_447_ = (int)(
         (float)this.anInt6763
            * (
               this.aClass336_Sub2_6788.aFloat8578 * (float)i
                  + this.aClass336_Sub2_6788.aFloat8561 * (float)i_438_
                  + this.aClass336_Sub2_6788.aFloat8558 * (float)i_439_
                  + this.aClass336_Sub2_6788.aFloat8579
            )
            / f
      );
      int i_448_ = (int)(
         (float)this.anInt6763
            * (
               this.aClass336_Sub2_6788.aFloat8578 * (float)i_440_
                  + this.aClass336_Sub2_6788.aFloat8561 * (float)i_441_
                  + this.aClass336_Sub2_6788.aFloat8558 * (float)i_442_
                  + this.aClass336_Sub2_6788.aFloat8579
            )
            / f_444_
      );
      if (i_447_ < this.anInt6790 && i_448_ < this.anInt6790) {
         i_443_ |= 4;
      } else if (i_447_ > this.anInt6779 && i_448_ > this.anInt6779) {
         i_443_ |= 8;
      }

      return i_443_;
   }

   @Override
   final void a(int i, int i_449_, int i_450_, int i_451_, int i_452_, int i_453_) {
      i_450_ -= i;
      i_451_ -= i_449_;
      if (i_451_ == 0) {
         if (i_450_ >= 0) {
            this.U(i, i_449_, i_450_ + 1, i_452_, i_453_);
         } else {
            this.U(i + i_450_, i_449_, -i_450_ + 1, i_452_, i_453_);
         }
      } else if (i_450_ == 0) {
         if (i_451_ >= 0) {
            this.P(i, i_449_, i_451_ + 1, i_452_, i_453_);
         } else {
            this.P(i, i_449_ + i_451_, -i_451_ + 1, i_452_, i_453_);
         }
      } else {
         if (i_450_ + i_451_ < 0) {
            i += i_450_;
            i_450_ = -i_450_;
            i_449_ += i_451_;
            i_451_ = -i_451_;
         }

         if (i_450_ > i_451_) {
            i_449_ <<= 16;
            i_449_ += 32768;
            i_451_ <<= 16;
            int i_454_ = (int)Math.floor((double)i_451_ / (double)i_450_ + 0.5);
            i_450_ += i;
            if (i < this.anInt6767) {
               i_449_ += i_454_ * (this.anInt6767 - i);
               i = this.anInt6767;
            }

            if (i_450_ >= this.anInt6778) {
               i_450_ = this.anInt6778 - 1;
            }

            int i_455_ = i_452_ >>> 24;
            if (i_453_ == 0 || i_453_ == 1 && i_455_ == 255) {
               while(i <= i_450_) {
                  int i_456_ = i_449_ >> 16;
                  if (i_456_ >= this.anInt6760 && i_456_ < this.anInt6772) {
                     this.anIntArray6787[i + i_456_ * this.anInt6789] = i_452_;
                  }

                  i_449_ += i_454_;
                  ++i;
               }

               return;
            }

            if (i_453_ == 1) {
               i_452_ = ((i_452_ & 16711935) * i_455_ >> 8 & 16711935) + ((i_452_ & 0xFF00) * i_455_ >> 8 & 0xFF00) + (i_455_ << 24);

               for(int i_457_ = 256 - i_455_; i <= i_450_; ++i) {
                  int i_458_ = i_449_ >> 16;
                  if (i_458_ >= this.anInt6760 && i_458_ < this.anInt6772) {
                     int i_459_ = i + i_458_ * this.anInt6789;
                     int i_460_ = this.anIntArray6787[i_459_];
                     i_460_ = ((i_460_ & 16711935) * i_457_ >> 8 & 16711935) + ((i_460_ & 0xFF00) * i_457_ >> 8 & 0xFF00);
                     this.anIntArray6787[i_459_] = i_452_ + i_460_;
                  }

                  i_449_ += i_454_;
               }

               return;
            }

            if (i_453_ == 2) {
               while(i <= i_450_) {
                  int i_461_ = i_449_ >> 16;
                  if (i_461_ >= this.anInt6760 && i_461_ < this.anInt6772) {
                     int i_462_ = i + i_461_ * this.anInt6789;
                     int i_463_ = this.anIntArray6787[i_462_];
                     int i_464_ = i_452_ + i_463_;
                     int i_465_ = (i_452_ & 16711935) + (i_463_ & 16711935);
                     i_463_ = (i_465_ & 16777472) + (i_464_ - i_465_ & 65536);
                     this.anIntArray6787[i_462_] = i_464_ - i_463_ | i_463_ - (i_463_ >>> 8);
                  }

                  i_449_ += i_454_;
                  ++i;
               }

               return;
            }

            throw new IllegalArgumentException();
         }

         i <<= 16;
         i += 32768;
         i_450_ <<= 16;
         int i_466_ = (int)Math.floor((double)i_450_ / (double)i_451_ + 0.5);
         i_451_ += i_449_;
         if (i_449_ < this.anInt6760) {
            i += i_466_ * (this.anInt6760 - i_449_);
            i_449_ = this.anInt6760;
         }

         if (i_451_ >= this.anInt6772) {
            i_451_ = this.anInt6772 - 1;
         }

         int i_467_ = i_452_ >>> 24;
         if (i_453_ == 0 || i_453_ == 1 && i_467_ == 255) {
            while(i_449_ <= i_451_) {
               int i_468_ = i >> 16;
               if (i_468_ >= this.anInt6767 && i_468_ < this.anInt6778) {
                  this.anIntArray6787[i_468_ + i_449_ * this.anInt6789] = i_452_;
               }

               i += i_466_;
               ++i_449_;
            }
         } else if (i_453_ == 1) {
            i_452_ = ((i_452_ & 16711935) * i_467_ >> 8 & 16711935) + ((i_452_ & 0xFF00) * i_467_ >> 8 & 0xFF00) + (i_467_ << 24);

            for(int i_469_ = 256 - i_467_; i_449_ <= i_451_; ++i_449_) {
               int i_470_ = i >> 16;
               if (i_470_ >= this.anInt6767 && i_470_ < this.anInt6778) {
                  int i_471_ = i_470_ + i_449_ * this.anInt6789;
                  int i_472_ = this.anIntArray6787[i_471_];
                  i_472_ = ((i_472_ & 16711935) * i_469_ >> 8 & 16711935) + ((i_472_ & 0xFF00) * i_469_ >> 8 & 0xFF00);
                  this.anIntArray6787[i_470_ + i_449_ * this.anInt6789] = i_452_ + i_472_;
               }

               i += i_466_;
            }
         } else {
            if (i_453_ != 2) {
               throw new IllegalArgumentException();
            }

            while(i_449_ <= i_451_) {
               int i_473_ = i >> 16;
               if (i_473_ >= this.anInt6767 && i_473_ < this.anInt6778) {
                  int i_474_ = i_473_ + i_449_ * this.anInt6789;
                  int i_475_ = this.anIntArray6787[i_474_];
                  int i_476_ = i_452_ + i_475_;
                  int i_477_ = (i_452_ & 16711935) + (i_475_ & 16711935);
                  i_475_ = (i_477_ & 16777472) + (i_476_ - i_477_ & 65536);
                  this.anIntArray6787[i_474_] = i_476_ - i_475_ | i_475_ - (i_475_ >>> 8);
               }

               i += i_466_;
               ++i_449_;
            }
         }
      }
   }

   @Override
   final void b(boolean bool) {
   }

   final int[] method1499(int i) {
      Node_Sub22 node_sub22;
      synchronized(this.aClass61_6781) {
         node_sub22 = (Node_Sub22)this.aClass61_6781.method607((long)i, 0);
         if (node_sub22 == null) {
            if (!this.aD1543.method7(9900, i)) {
               return null;
            }

            TextureDefinitions class91 = this.aD1543.getTexture(i, -8217);
            int i_478_ = !class91.skipTriangles && !this.aBoolean6794 ? this.anInt6775 : 64;
            node_sub22 = new Node_Sub22(i, i_478_, this.aD1543.method11(i_478_, true, i_478_, i, (byte)0, 0.7F), class91.unknown1 != 1);
            this.aClass61_6781.method601(node_sub22, 25566, (long)i);
         }
      }

      node_sub22.aBoolean7193 = true;
      return node_sub22.method2619();
   }

   @Override
   final boolean r() {
      return false;
   }

   @Override
   final int r(int i, int i_479_, int i_480_, int i_481_, int i_482_, int i_483_, int i_484_) {
      float f = this.aClass336_Sub2_6788.aFloat8577 * (float)i
         + this.aClass336_Sub2_6788.aFloat8567 * (float)i_479_
         + this.aClass336_Sub2_6788.aFloat8584 * (float)i_480_
         + this.aClass336_Sub2_6788.aFloat8589;
      float f_485_ = this.aClass336_Sub2_6788.aFloat8577 * (float)i_481_
         + this.aClass336_Sub2_6788.aFloat8567 * (float)i_482_
         + this.aClass336_Sub2_6788.aFloat8584 * (float)i_483_
         + this.aClass336_Sub2_6788.aFloat8589;
      int i_486_ = 0;
      if (f < (float)this.anInt6798 && f_485_ < (float)this.anInt6798) {
         i_486_ |= 16;
      } else if (f > (float)this.anInt6776 && f_485_ > (float)this.anInt6776) {
         i_486_ |= 32;
      }

      int i_487_ = (int)(
         (float)this.anInt6785
            * (
               this.aClass336_Sub2_6788.aFloat8580 * (float)i
                  + this.aClass336_Sub2_6788.aFloat8571 * (float)i_479_
                  + this.aClass336_Sub2_6788.aFloat8566 * (float)i_480_
                  + this.aClass336_Sub2_6788.aFloat8583
            )
            / (float)i_484_
      );
      int i_488_ = (int)(
         (float)this.anInt6785
            * (
               this.aClass336_Sub2_6788.aFloat8580 * (float)i_481_
                  + this.aClass336_Sub2_6788.aFloat8571 * (float)i_482_
                  + this.aClass336_Sub2_6788.aFloat8566 * (float)i_483_
                  + this.aClass336_Sub2_6788.aFloat8583
            )
            / (float)i_484_
      );
      if (i_487_ < this.anInt6793 && i_488_ < this.anInt6793) {
         i_486_ |= 1;
      } else if (i_487_ > this.anInt6768 && i_488_ > this.anInt6768) {
         i_486_ |= 2;
      }

      int i_489_ = (int)(
         (float)this.anInt6763
            * (
               this.aClass336_Sub2_6788.aFloat8578 * (float)i
                  + this.aClass336_Sub2_6788.aFloat8561 * (float)i_479_
                  + this.aClass336_Sub2_6788.aFloat8558 * (float)i_480_
                  + this.aClass336_Sub2_6788.aFloat8579
            )
            / (float)i_484_
      );
      int i_490_ = (int)(
         (float)this.anInt6763
            * (
               this.aClass336_Sub2_6788.aFloat8578 * (float)i_481_
                  + this.aClass336_Sub2_6788.aFloat8561 * (float)i_482_
                  + this.aClass336_Sub2_6788.aFloat8558 * (float)i_483_
                  + this.aClass336_Sub2_6788.aFloat8579
            )
            / (float)i_484_
      );
      if (i_489_ < this.anInt6790 && i_490_ < this.anInt6790) {
         i_486_ |= 4;
      } else if (i_489_ > this.anInt6779 && i_490_ > this.anInt6779) {
         i_486_ |= 8;
      }

      return i_486_;
   }

   @Override
   final void pa() {
      for(int i = 0; i < this.aClass374Array6777.length; ++i) {
         this.aClass374Array6777[i].anInt4611 = this.aClass374Array6777[i].anInt4616;
         this.aClass374Array6777[i].aBoolean4617 = false;
      }
   }

   final int method1500(int i) {
      return this.aD1543.getTexture(i, -8217).colorIndex & 65535;
   }

   @Override
   final void X(int i) {
   }

   private final void method1501(int i, int i_491_, int i_492_, int i_493_, int i_494_, int i_495_, int i_496_, int i_497_) {
      if (i_491_ >= this.anInt6760 && i_491_ < this.anInt6772) {
         int i_498_ = i + i_491_ * this.anInt6789;
         int i_499_ = i_493_ >>> 24;
         int i_500_ = i_495_ + i_496_;
         int i_501_ = i_497_ % i_500_;
         if (i_494_ == 0 || i_494_ == 1 && i_499_ == 255) {
            for(int i_502_ = 0; i_502_ < i_492_; i_501_ = ++i_501_ % i_500_) {
               if (i + i_502_ >= this.anInt6767 && i + i_502_ < this.anInt6778 && i_501_ < i_495_) {
                  this.anIntArray6787[i_498_ + i_502_] = i_493_;
               }

               ++i_502_;
            }
         } else if (i_494_ == 1) {
            i_493_ = ((i_493_ & 16711935) * i_499_ >> 8 & 16711935) + ((i_493_ & 0xFF00) * i_499_ >> 8 & 0xFF00) + (i_499_ << 24);
            int i_503_ = 256 - i_499_;

            for(int i_504_ = 0; i_504_ < i_492_; i_501_ = ++i_501_ % i_500_) {
               if (i + i_504_ >= this.anInt6767 && i + i_504_ < this.anInt6778 && i_501_ < i_495_) {
                  int i_505_ = this.anIntArray6787[i_498_ + i_504_];
                  i_505_ = ((i_505_ & 16711935) * i_503_ >> 8 & 16711935) + ((i_505_ & 0xFF00) * i_503_ >> 8 & 0xFF00);
                  this.anIntArray6787[i_498_ + i_504_] = i_493_ + i_505_;
               }

               ++i_504_;
            }
         } else {
            if (i_494_ != 2) {
               throw new IllegalArgumentException();
            }

            for(int i_506_ = 0; i_506_ < i_492_; i_501_ = ++i_501_ % i_500_) {
               if (i + i_506_ >= this.anInt6767 && i + i_506_ < this.anInt6778 && i_501_ < i_495_) {
                  int i_507_ = this.anIntArray6787[i_498_ + i_506_];
                  int i_508_ = i_493_ + i_507_;
                  int i_509_ = (i_493_ & 16711935) + (i_507_ & 16711935);
                  i_507_ = (i_509_ & 16777472) + (i_508_ - i_509_ & 65536);
                  this.anIntArray6787[i_498_ + i_506_] = i_508_ - i_507_ | i_507_ - (i_507_ >>> 8);
               }

               ++i_506_;
            }
         }
      }
   }

   @Override
   final void e(int i, int i_510_) throws Exception_Sub1 {
      if (this.aCanvas6755 != null && this.aGraphicsBuffer6756 != null) {
         try {
            Graphics graphics = this.aCanvas6755.getGraphics();
            this.aGraphicsBuffer6756.method2597(this.anInt6752, i, 0, false, graphics, this.anInt6758, 0, i_510_);
         } catch (Exception var4) {
            this.aCanvas6755.repaint();
         }
      } else {
         throw new IllegalStateException("off");
      }
   }

   @Override
   final void b(int i, int i_511_, int i_512_, int i_513_, double d) {
      int i_514_ = this.anInt6765 - i_512_;
      int i_515_ = i_511_ * this.anInt6765 + i;
      float[] fs = this.aFloatArray6782;

      for(int i_516_ = 0; i_516_ < i_513_; i_515_ += i_514_) {
         for(int i_517_ = 0; i_517_ < i_512_; ++i_515_) {
            float f = fs[i_515_];
            if (f != 2.1474836E9F) {
               fs[i_515_] = (float)((double)f + d);
            }

            ++i_517_;
         }

         ++i_516_;
      }
   }

   @Override
   final Class52 a(Class357 class357, Class383[] class383s, boolean bool) {
      int[] is = new int[class383s.length];
      int[] is_518_ = new int[class383s.length];
      boolean bool_519_ = false;

      for(int i = 0; i < class383s.length; ++i) {
         is[i] = class383s[i].anInt4897;
         is_518_[i] = class383s[i].anInt4900;
         if (class383s[i].aByteArray4905 != null) {
            bool_519_ = true;
         }
      }

      if (bool) {
         return (Class52)(bool_519_ ? new Class52_Sub4(this, class357, class383s, is, is_518_) : new Class52_Sub5(this, class357, class383s, is, is_518_));
      } else if (bool_519_) {
         throw new IllegalArgumentException("");
      } else {
         return new Class52_Sub3(this, class357, class383s, is, is_518_);
      }
   }

   @Override
   final void Q(int i, int i_520_, int i_521_, int i_522_, int i_523_, int i_524_, byte[] bs, int i_525_, int i_526_) {
      if (i_521_ > 0 && i_522_ > 0) {
         int i_527_ = 0;
         int i_528_ = 0;
         int i_529_ = (i_525_ << 16) / i_521_;
         int i_530_ = (bs.length / i_525_ << 16) / i_522_;
         int i_531_ = i + i_520_ * this.anInt6789;
         int i_532_ = this.anInt6789 - i_521_;
         if (i_520_ + i_522_ > this.anInt6772) {
            i_522_ -= i_520_ + i_522_ - this.anInt6772;
         }

         if (i_520_ < this.anInt6760) {
            int i_533_ = this.anInt6760 - i_520_;
            i_522_ -= i_533_;
            i_531_ += i_533_ * this.anInt6789;
            i_528_ += i_530_ * i_533_;
         }

         if (i + i_521_ > this.anInt6778) {
            int i_534_ = i + i_521_ - this.anInt6778;
            i_521_ -= i_534_;
            i_532_ += i_534_;
         }

         if (i < this.anInt6767) {
            int i_535_ = this.anInt6767 - i;
            i_521_ -= i_535_;
            i_531_ += i_535_;
            i_527_ += i_529_ * i_535_;
            i_532_ += i_535_;
         }

         int i_536_ = i_523_ >>> 24;
         int i_537_ = i_524_ >>> 24;
         if (i_526_ == 0 || i_526_ == 1 && i_536_ == 255 && i_537_ == 255) {
            int i_538_ = i_527_;

            for(int i_539_ = -i_522_; i_539_ < 0; ++i_539_) {
               int i_540_ = (i_528_ >> 16) * i_525_;

               for(int i_541_ = -i_521_; i_541_ < 0; ++i_541_) {
                  if (bs[(i_527_ >> 16) + i_540_] != 0) {
                     this.anIntArray6787[i_531_++] = i_524_;
                  } else {
                     this.anIntArray6787[i_531_++] = i_523_;
                  }

                  i_527_ += i_529_;
               }

               i_528_ += i_530_;
               i_527_ = i_538_;
               i_531_ += i_532_;
            }
         } else if (i_526_ == 1) {
            int i_542_ = i_527_;

            for(int i_543_ = -i_522_; i_543_ < 0; ++i_543_) {
               int i_544_ = (i_528_ >> 16) * i_525_;

               for(int i_545_ = -i_521_; i_545_ < 0; ++i_545_) {
                  int i_546_ = i_523_;
                  if (bs[(i_527_ >> 16) + i_544_] != 0) {
                     i_546_ = i_524_;
                  }

                  int i_547_ = i_546_ >>> 24;
                  int i_548_ = 255 - i_547_;
                  int i_549_ = this.anIntArray6787[i_531_];
                  this.anIntArray6787[i_531_++] = ((i_546_ & 16711935) * i_547_ + (i_549_ & 16711935) * i_548_ & -16711936)
                        + ((i_546_ & 0xFF00) * i_547_ + (i_549_ & 0xFF00) * i_548_ & 0xFF0000)
                     >> 8;
                  i_527_ += i_529_;
               }

               i_528_ += i_530_;
               i_527_ = i_542_;
               i_531_ += i_532_;
            }
         } else {
            if (i_526_ != 2) {
               throw new IllegalArgumentException();
            }

            int i_550_ = i_527_;

            for(int i_551_ = -i_522_; i_551_ < 0; ++i_551_) {
               int i_552_ = (i_528_ >> 16) * i_525_;

               for(int i_553_ = -i_521_; i_553_ < 0; ++i_553_) {
                  int i_554_ = i_523_;
                  if (bs[(i_527_ >> 16) + i_552_] != 0) {
                     i_554_ = i_524_;
                  }

                  if (i_554_ != 0) {
                     int i_555_ = this.anIntArray6787[i_531_];
                     int i_556_ = i_554_ + i_555_;
                     int i_557_ = (i_554_ & 16711935) + (i_555_ & 16711935);
                     i_555_ = (i_557_ & 16777472) + (i_556_ - i_557_ & 65536);
                     this.anIntArray6787[i_531_++] = i_556_ - i_555_ | i_555_ - (i_555_ >>> 8);
                  } else {
                     ++i_531_;
                  }

                  i_527_ += i_529_;
               }

               i_528_ += i_530_;
               i_527_ = i_550_;
               i_531_ += i_532_;
            }
         }
      }
   }

   @Override
   final void j() {
   }

   @Override
   final boolean m() {
      return false;
   }

   @Override
   final void a(int i, int i_558_, int i_559_, int i_560_, int i_561_, int i_562_, aa var_aa, int i_563_, int i_564_, int i_565_, int i_566_, int i_567_) {
      aa_Sub1 var_aa_Sub1 = (aa_Sub1)var_aa;
      int[] is = var_aa_Sub1.anIntArray5487;
      int[] is_568_ = var_aa_Sub1.anIntArray5488;
      int i_569_ = this.anInt6760 > i_564_ ? this.anInt6760 : i_564_;
      int i_570_ = this.anInt6772 < i_564_ + is.length ? this.anInt6772 : i_564_ + is.length;
      i_567_ <<= 8;
      i_565_ <<= 8;
      i_566_ <<= 8;
      int i_571_ = i_565_ + i_566_;
      i_567_ %= i_571_;
      i_559_ -= i;
      i_560_ -= i_558_;
      if (i_559_ + i_560_ < 0) {
         int i_572_ = (int)(Math.sqrt((double)(i_559_ * i_559_ + i_560_ * i_560_)) * 256.0);
         int i_573_ = i_572_ % i_571_;
         i_567_ = i_571_ + i_565_ - i_567_ - i_573_;
         i_567_ %= i_571_;
         if (i_567_ < 0) {
            i_567_ += i_571_;
         }

         i += i_559_;
         i_559_ = -i_559_;
         i_558_ += i_560_;
         i_560_ = -i_560_;
      }

      if (i_559_ > i_560_) {
         i_558_ <<= 16;
         i_558_ += 32768;
         i_560_ <<= 16;
         int i_574_ = (int)Math.floor((double)i_560_ / (double)i_559_ + 0.5);
         i_559_ += i;
         int i_575_ = i_561_ >>> 24;
         int i_576_ = (int)Math.sqrt((double)(65536 + (i_574_ >> 8) * (i_574_ >> 8)));
         if (i_562_ == 0 || i_562_ == 1 && i_575_ == 255) {
            while(i <= i_559_) {
               int i_577_ = i_558_ >> 16;
               int i_578_ = i_577_ - i_564_;
               if (i >= this.anInt6767 && i < this.anInt6778 && i_577_ >= i_569_ && i_577_ < i_570_ && i_567_ < i_565_) {
                  int i_579_ = i_563_ + is[i_578_];
                  if (i >= i_579_ && i < i_579_ + is_568_[i_578_]) {
                     this.anIntArray6787[i + i_577_ * this.anInt6789] = i_561_;
                  }
               }

               i_558_ += i_574_;
               ++i;
               i_567_ += i_576_;
               i_567_ %= i_571_;
            }
         } else if (i_562_ == 1) {
            i_561_ = ((i_561_ & 16711935) * i_575_ >> 8 & 16711935) + ((i_561_ & 0xFF00) * i_575_ >> 8 & 0xFF00) + (i_575_ << 24);

            for(int i_580_ = 256 - i_575_; i <= i_559_; i_567_ %= i_571_) {
               int i_581_ = i_558_ >> 16;
               int i_582_ = i_581_ - i_564_;
               if (i >= this.anInt6767 && i < this.anInt6778 && i_581_ >= i_569_ && i_581_ < i_570_ && i_567_ < i_565_) {
                  int i_583_ = i_563_ + is[i_582_];
                  if (i >= i_583_ && i < i_583_ + is_568_[i_582_]) {
                     int i_584_ = i + i_581_ * this.anInt6789;
                     int i_585_ = this.anIntArray6787[i_584_];
                     i_585_ = ((i_585_ & 16711935) * i_580_ >> 8 & 16711935) + ((i_585_ & 0xFF00) * i_580_ >> 8 & 0xFF00);
                     this.anIntArray6787[i_584_] = i_561_ + i_585_;
                  }
               }

               i_558_ += i_574_;
               ++i;
               i_567_ += i_576_;
            }
         } else if (i_562_ == 2) {
            while(i <= i_559_) {
               int i_586_ = i_558_ >> 16;
               int i_587_ = i_586_ - i_564_;
               if (i >= this.anInt6767 && i < this.anInt6778 && i_586_ >= i_569_ && i_586_ < i_570_ && i_567_ < i_565_) {
                  int i_588_ = i_563_ + is[i_587_];
                  if (i >= i_588_ && i < i_588_ + is_568_[i_587_]) {
                     int i_589_ = i + i_586_ * this.anInt6789;
                     int i_590_ = this.anIntArray6787[i_589_];
                     int i_591_ = i_561_ + i_590_;
                     int i_592_ = (i_561_ & 16711935) + (i_590_ & 16711935);
                     i_590_ = (i_592_ & 16777472) + (i_591_ - i_592_ & 65536);
                     this.anIntArray6787[i_589_] = i_591_ - i_590_ | i_590_ - (i_590_ >>> 8);
                  }
               }

               i_558_ += i_574_;
               ++i;
               i_567_ += i_576_;
               i_567_ %= i_571_;
            }
         } else {
            throw new IllegalArgumentException();
         }
      } else {
         i <<= 16;
         i += 32768;
         i_559_ <<= 16;
         int i_593_ = (int)Math.floor((double)i_559_ / (double)i_560_ + 0.5);
         int i_594_ = (int)Math.sqrt((double)(65536 + (i_593_ >> 8) * (i_593_ >> 8)));
         i_560_ += i_558_;
         int i_595_ = i_561_ >>> 24;
         if (i_562_ == 0 || i_562_ == 1 && i_595_ == 255) {
            while(i_558_ <= i_560_) {
               int i_596_ = i >> 16;
               int i_597_ = i_558_ - i_564_;
               if (i_558_ >= i_569_
                  && i_558_ < i_570_
                  && i_596_ >= this.anInt6767
                  && i_596_ < this.anInt6778
                  && i_567_ < i_565_
                  && i_596_ >= i_563_ + is[i_597_]
                  && i_596_ < i_563_ + is[i_597_] + is_568_[i_597_]) {
                  this.anIntArray6787[i_596_ + i_558_ * this.anInt6789] = i_561_;
               }

               i += i_593_;
               ++i_558_;
               i_567_ += i_594_;
               i_567_ %= i_571_;
            }
         } else if (i_562_ == 1) {
            i_561_ = ((i_561_ & 16711935) * i_595_ >> 8 & 16711935) + ((i_561_ & 0xFF00) * i_595_ >> 8 & 0xFF00) + (i_595_ << 24);

            for(int i_598_ = 256 - i_595_; i_558_ <= i_560_; i_567_ %= i_571_) {
               int i_599_ = i >> 16;
               int i_600_ = i_558_ - i_564_;
               if (i_558_ >= i_569_
                  && i_558_ < i_570_
                  && i_599_ >= this.anInt6767
                  && i_599_ < this.anInt6778
                  && i_567_ < i_565_
                  && i_599_ >= i_563_ + is[i_600_]
                  && i_599_ < i_563_ + is[i_600_] + is_568_[i_600_]) {
                  int i_601_ = i_599_ + i_558_ * this.anInt6789;
                  int i_602_ = this.anIntArray6787[i_601_];
                  i_602_ = ((i_602_ & 16711935) * i_598_ >> 8 & 16711935) + ((i_602_ & 0xFF00) * i_598_ >> 8 & 0xFF00);
                  this.anIntArray6787[i_599_ + i_558_ * this.anInt6789] = i_561_ + i_602_;
               }

               i += i_593_;
               ++i_558_;
               i_567_ += i_594_;
            }
         } else {
            if (i_562_ != 2) {
               throw new IllegalArgumentException();
            }

            while(i_558_ <= i_560_) {
               int i_603_ = i >> 16;
               int i_604_ = i_558_ - i_564_;
               if (i_558_ >= i_569_
                  && i_558_ < i_570_
                  && i_603_ >= this.anInt6767
                  && i_603_ < this.anInt6778
                  && i_567_ < i_565_
                  && i_603_ >= i_563_ + is[i_604_]
                  && i_603_ < i_563_ + is[i_604_] + is_568_[i_604_]) {
                  int i_605_ = i_603_ + i_558_ * this.anInt6789;
                  int i_606_ = this.anIntArray6787[i_605_];
                  int i_607_ = i_561_ + i_606_;
                  int i_608_ = (i_561_ & 16711935) + (i_606_ & 16711935);
                  i_606_ = (i_608_ & 16777472) + (i_607_ - i_608_ & 65536);
                  this.anIntArray6787[i_605_] = i_607_ - i_606_ | i_606_ - (i_606_ >>> 8);
               }

               i += i_593_;
               ++i_558_;
               i_567_ += i_594_;
               i_567_ %= i_571_;
            }
         }
      }
   }

   final int method1502(int i) {
      return this.aD1543.getTexture(i, -8217).unknown1;
   }

   @Override
   final boolean z() {
      return true;
   }

   @Override
   final Interface6 a(Interface4 interface4, Interface20 interface20) {
      return new Class64(this, (GLSprite)interface4, (Class131)interface20);
   }

   @Override
   final int getanInt6367() {
      return 0;
   }

   @Override
   final boolean t() {
      return false;
   }

   @Override
   final GLSprite a(int i, int i_609_, boolean bool) {
      return (GLSprite)(bool ? new GLSprite_Sub2_Sub2(this, i, i_609_) : new GLSprite_Sub2_Sub1(this, i, i_609_));
   }

   @Override
   final boolean a() {
      return false;
   }

   @Override
   final void v() {
      if (this.aCanvas6755 != null) {
         this.anIntArray6787 = this.aGraphicsBuffer6756.anIntArray7145;
         this.anInt6789 = this.aGraphicsBuffer6756.anInt7146;
         this.anInt6791 = this.aGraphicsBuffer6756.anInt7142;
         this.aFloatArray6782 = this.aFloatArray6792;
         this.anInt6765 = this.anInt6773;
         this.anInt6783 = this.anInt6770;
      } else {
         this.anInt6789 = 1;
         this.anInt6791 = 1;
         this.anIntArray6787 = null;
         this.anInt6765 = 1;
         this.anInt6783 = 1;
         this.aFloatArray6782 = null;
      }

      this.aClass64_6771 = null;
      this.method1496();
   }

   @Override
   final void L(int i, int i_610_, int i_611_) {
      for(int i_612_ = 0; i_612_ < this.aClass374Array6777.length; ++i_612_) {
         Class374 class374 = this.aClass374Array6777[i_612_];
         class374.anInt4611 = i & 16777215;
         int i_613_ = class374.anInt4611 >>> 16 & 0xFF;
         if (i_613_ < 2) {
            i_613_ = 2;
         }

         int i_614_ = class374.anInt4611 >> 8 & 0xFF;
         if (i_614_ < 2) {
            i_614_ = 2;
         }

         int i_615_ = class374.anInt4611 & 0xFF;
         if (i_615_ < 2) {
            i_615_ = 2;
         }

         class374.anInt4611 = i_613_ << 16 | i_614_ << 8 | i_615_;
         if (i_610_ < 0) {
            class374.aBoolean4621 = false;
         } else {
            class374.aBoolean4621 = true;
         }
      }
   }

   @Override
   final void a(int i, Node_Sub29[] node_sub29s) {
   }

   PureJavaToolkit(java.awt.Canvas canvas, d var_d, int i, int i_616_) {
      this(var_d);

      try {
         this.b(canvas, i, i_616_);
         this.a(canvas);
      } catch (Throwable var6) {
         var6.printStackTrace();
         this.method1233(-7751);
         throw new RuntimeException("");
      }
   }

   final boolean method1503(int i) {
      return this.aD1543.getTexture(i, -8217).repeatSides || this.aD1543.getTexture(i, -8217).repeatTop;
   }

   @Override
   final int I() {
      int i = this.anInt6796;
      this.anInt6796 = 0;
      return i;
   }

   final void method1504(int i, int i_617_, int i_618_, int i_619_, int i_620_, int i_621_, int i_622_, int i_623_, int i_624_, int i_625_) {
      if (i_619_ != 0 && i_620_ != 0) {
         if (i_622_ != 65535 && !this.aD1543.getTexture(i_622_, -8217).meshGround) {
            if (this.anInt6800 != i_622_) {
               GLSprite glsprite = (GLSprite)this.aClass61_6762.method607((long)i_622_, 0);
               if (glsprite == null) {
                  int[] is = this.method1495(i_622_);
                  if (is == null) {
                     return;
                  }

                  int i_626_ = this.method1505(i_622_) ? 64 : this.anInt6775;
                  glsprite = this.method1235(i_626_, i_626_, i_626_, is, 0, 7468);
                  this.aClass61_6762.method601(glsprite, 25566, (long)i_622_);
               }

               this.anInt6800 = i_622_;
               this.aGLSprite6799 = glsprite;
            }

            ((GLSprite_Sub2)this.aGLSprite6799).method1207(i - i_619_, i_617_ - i_620_, i_618_, i_619_ << 1, i_620_ << 1, i_624_, i_623_, i_625_, 1);
         } else {
            this.method1497(i, i_617_, i_618_, i_619_, i_623_, i_625_);
         }
      }
   }

   @Override
   final void la() {
      this.anInt6767 = 0;
      this.anInt6760 = 0;
      this.anInt6778 = this.anInt6789;
      this.anInt6772 = this.anInt6791;
      this.method1506();
   }

   final boolean method1505(int i) {
      return this.aBoolean6794 || this.aD1543.getTexture(i, -8217).skipTriangles;
   }

   @Override
   final boolean w() {
      return false;
   }

   private final void method1506() {
      this.anInt6793 = this.anInt6767 - this.anInt6786;
      this.anInt6768 = this.anInt6778 - this.anInt6786;
      this.anInt6790 = this.anInt6760 - this.anInt6769;
      this.anInt6779 = this.anInt6772 - this.anInt6769;

      for(int i = 0; i < this.anInt6795; ++i) {
         Class185 class185 = this.aClass374Array6777[i].aClass185_4627;
         class185.anInt2216 = this.anInt6786 - this.anInt6767;
         class185.anInt2213 = this.anInt6769 - this.anInt6760;
         class185.anInt2222 = this.anInt6778 - this.anInt6767;
         class185.anInt2225 = this.anInt6772 - this.anInt6760;
      }

      int i = this.anInt6760 * this.anInt6789 + this.anInt6767;

      for(int i_627_ = this.anInt6760; i_627_ < this.anInt6772; ++i_627_) {
         for(int i_628_ = 0; i_628_ < this.anInt6795; ++i_628_) {
            this.aClass374Array6777[i_628_].aClass185_4627.anIntArray2224[i_627_ - this.anInt6760] = i;
         }

         i += this.anInt6789;
      }
   }

   @Override
   final void b(java.awt.Canvas canvas, int i, int i_629_) {
      GraphicsBuffer graphicsbuffer = (GraphicsBuffer)this.aHashTable6753.get(3512, (long)canvas.hashCode());
      if (graphicsbuffer == null) {
         graphicsbuffer = Class284.method3391(i_629_, canvas, 67, i);
         this.aHashTable6753.put((long)canvas.hashCode(), graphicsbuffer, -127);
      } else if (graphicsbuffer.anInt7146 != i || graphicsbuffer.anInt7142 != i_629_) {
         this.a(canvas, i, i_629_);
      }
   }

   @Override
   final void a(Class336 class336) {
      this.aClass336_Sub2_6788 = (Class336_Sub2)class336;
   }

   @Override
   final int[] na(int i, int i_630_, int i_631_, int i_632_) {
      int[] is = new int[i_631_ * i_632_];
      int i_633_ = 0;

      for(int i_634_ = 0; i_634_ < i_632_; ++i_634_) {
         int i_635_ = (i_630_ + i_634_) * this.anInt6789 + i;

         for(int i_636_ = 0; i_636_ < i_631_; ++i_636_) {
            is[i_633_++] = this.anIntArray6787[i_635_ + i_636_];
         }
      }

      return is;
   }

   @Override
   final void a(Class198 class198) {
      Class374 class374 = this.method1494(Thread.currentThread());
      EntityNode_Sub3 entitynode_sub3 = class198.aClass87_2429.anEntityNode_Sub3_1186;

      for(EntityNode_Sub3 entitynode_sub3_637_ = entitynode_sub3.anEntityNode_Sub3_5961;
         entitynode_sub3_637_ != entitynode_sub3;
         entitynode_sub3_637_ = entitynode_sub3_637_.anEntityNode_Sub3_5961
      ) {
         EntityNode_Sub3_Sub2 entitynode_sub3_sub2 = (EntityNode_Sub3_Sub2)entitynode_sub3_637_;
         int i = entitynode_sub3_sub2.anInt9174 >> 12;
         int i_638_ = entitynode_sub3_sub2.anInt9171 >> 12;
         int i_639_ = entitynode_sub3_sub2.anInt9173 >> 12;
         float f = this.aClass336_Sub2_6788.aFloat8589
            + this.aClass336_Sub2_6788.aFloat8577 * (float)i
            + this.aClass336_Sub2_6788.aFloat8567 * (float)i_638_
            + this.aClass336_Sub2_6788.aFloat8584 * (float)i_639_;
         if (f >= (float)this.anInt6798 && f <= (float)class374.anInt4618) {
            int i_640_ = this.anInt6786
               + (int)(
                  (float)this.anInt6785
                     * (
                        this.aClass336_Sub2_6788.aFloat8583
                           + this.aClass336_Sub2_6788.aFloat8580 * (float)i
                           + this.aClass336_Sub2_6788.aFloat8571 * (float)i_638_
                           + this.aClass336_Sub2_6788.aFloat8566 * (float)i_639_
                     )
                     / f
               );
            int i_641_ = this.anInt6769
               + (int)(
                  (float)this.anInt6763
                     * (
                        this.aClass336_Sub2_6788.aFloat8579
                           + this.aClass336_Sub2_6788.aFloat8578 * (float)i
                           + this.aClass336_Sub2_6788.aFloat8561 * (float)i_638_
                           + this.aClass336_Sub2_6788.aFloat8558 * (float)i_639_
                     )
                     / f
               );
            if (i_640_ >= this.anInt6767 && i_640_ <= this.anInt6778 && i_641_ >= this.anInt6760 && i_641_ <= this.anInt6772) {
               if (f == 0.0F) {
                  f = 1.0F;
               }

               this.method1491(entitynode_sub3_sub2, i_640_, i_641_, (int)f, (int)((float)(entitynode_sub3_sub2.anInt9172 * this.anInt6785 >> 12) / f));
            }
         }
      }
   }

   @Override
   final Class270 c(int i, int i_642_, int i_643_, int i_644_, int i_645_, int i_646_) {
      return null;
   }

   @Override
   final void b(java.awt.Canvas canvas) {
      if (this.aCanvas6755 == canvas) {
         this.a((Canvas) null);
      }

      GraphicsBuffer graphicsbuffer = (GraphicsBuffer)this.aHashTable6753.get(3512, (long)canvas.hashCode());
      if (graphicsbuffer != null) {
         graphicsbuffer.method2160((byte)83);
      }
   }

   @Override
   final void EA(int i, int i_647_, int i_648_, int i_649_) {
      Class374 class374 = this.method1494(Thread.currentThread());
      class374.anInt4624 = i;
      class374.anInt4611 = i_647_;
      class374.anInt4620 = i_648_;
   }

   @Override
   final Class336 y() {
      return new Class336_Sub2();
   }

   @Override
   final za a(int i) {
      return null;
   }
}
