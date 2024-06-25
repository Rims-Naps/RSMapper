import jaggl.OpenGL;

public class Class29 {
   static OutgoingPacket aClass318_470 = new OutgoingPacket(48, 0);
   static int anInt471;
   static int anInt472;
   static int anInt473;
   static int anInt474;
   private float[] aFloatArray475 = new float[16];
   private PacketParser aFloatBuffer476 = new PacketParser(786336);
   static Node_Sub43 aNode_Sub43_477;
   static int anInt478;
   private int anInt479 = Node_Sub38_Sub20.method2855(1600, (byte)-74);
   private Class69 aClass69_480;
   static int anInt481;
   private Interface9 anInterface9_482;
   private Class69 aClass69_483;
   private Class69 aClass69_484;
   private int anInt485;
   private EntityNode_Sub3_Sub2[][] anEntityNode_Sub3_Sub2ArrayArray486;
   private EntityNode_Sub3_Sub2[][] anEntityNode_Sub3_Sub2ArrayArray487 = new EntityNode_Sub3_Sub2[64][768];
   private int[] anIntArray488 = new int[1600];
   private int[] anIntArray489;
   private int[] anIntArray490;

   private final void method334(boolean bool, GLToolkit gltoolkit) {
      ++anInt471;
      Node_Sub37.aFloat7446 = gltoolkit.aFloat6737;
      gltoolkit.method1470(1);
      OpenGL.glDisable(16384);
      OpenGL.glDisable(16385);
      gltoolkit.method1415(771, bool);
      OpenGL.glNormal3f(0.0F, -1.0F, 0.0F);
   }

   public static void method335(byte b) {
      aClass318_470 = null;
      if (b <= -66) {
         aNode_Sub43_477 = null;
      }
   }

   private final void method336(byte b, GLToolkit gltoolkit, int i) {
      ++anInt472;
      OpenGL.glGetFloatv(2982, this.aFloatArray475, 0);
      float f = this.aFloatArray475[0];
      float f_0_ = this.aFloatArray475[4];
      if (b > -109) {
         this.method338(-67, null, -27);
      }

      float f_1_ = this.aFloatArray475[8];
      float f_2_ = this.aFloatArray475[1];
      float f_3_ = this.aFloatArray475[5];
      float f_4_ = this.aFloatArray475[9];
      float f_5_ = f_2_ + f;
      float f_6_ = f_3_ + f_0_;
      float f_7_ = f_4_ + f_1_;
      float f_8_ = f - f_2_;
      float f_9_ = -f_3_ + f_0_;
      float f_10_ = f_1_ - f_4_;
      float f_11_ = -f + f_2_;
      float f_12_ = f_3_ - f_0_;
      float f_13_ = f_4_ - f_1_;
      this.aFloatBuffer476.offset = 0;
      if (!gltoolkit.aBoolean6736) {
         for(int i_14_ = i - 1; i_14_ >= 0; --i_14_) {
            int i_15_ = this.anIntArray488[i_14_] <= 64 ? this.anIntArray488[i_14_] : 64;
            if (i_15_ > 0) {
               for(int i_16_ = i_15_ + -1; ~i_16_ <= -1; --i_16_) {
                  EntityNode_Sub3_Sub2 entitynode_sub3_sub2 = this.anEntityNode_Sub3_Sub2ArrayArray486[i_14_][i_16_];
                  int i_17_ = entitynode_sub3_sub2.anInt9176;
                  byte b_18_ = (byte)(i_17_ >> 16);
                  byte b_19_ = (byte)(i_17_ >> 8);
                  byte b_20_ = (byte)i_17_;
                  byte b_21_ = (byte)(i_17_ >>> 24);
                  float f_22_ = (float)(entitynode_sub3_sub2.anInt9174 >> 12);
                  float f_23_ = (float)(entitynode_sub3_sub2.anInt9171 >> 12);
                  float f_24_ = (float)(entitynode_sub3_sub2.anInt9173 >> 12);
                  int i_25_ = entitynode_sub3_sub2.anInt9172 >> 12;
                  this.aFloatBuffer476.method2252(-229385392, 0.0F);
                  this.aFloatBuffer476.method2252(-229385392, 0.0F);
                  this.aFloatBuffer476.method2252(-229385392, f_5_ * (float)(-i_25_) + f_22_);
                  this.aFloatBuffer476.method2252(-229385392, (float)(-i_25_) * f_6_ + f_23_);
                  this.aFloatBuffer476.method2252(-229385392, f_7_ * (float)(-i_25_) + f_24_);
                  this.aFloatBuffer476.writeByte(b_18_);
                  this.aFloatBuffer476.writeByte(b_19_);
                  this.aFloatBuffer476.writeByte(b_20_);
                  this.aFloatBuffer476.writeByte(b_21_);
                  this.aFloatBuffer476.method2252(-229385392, 1.0F);
                  this.aFloatBuffer476.method2252(-229385392, 0.0F);
                  this.aFloatBuffer476.method2252(-229385392, f_8_ * (float)i_25_ + f_22_);
                  this.aFloatBuffer476.method2252(-229385392, f_23_ + (float)i_25_ * f_9_);
                  this.aFloatBuffer476.method2252(-229385392, f_24_ + f_10_ * (float)i_25_);
                  this.aFloatBuffer476.writeByte(b_18_);
                  this.aFloatBuffer476.writeByte(b_19_);
                  this.aFloatBuffer476.writeByte(b_20_);
                  this.aFloatBuffer476.writeByte(b_21_);
                  this.aFloatBuffer476.method2252(-229385392, 1.0F);
                  this.aFloatBuffer476.method2252(-229385392, 1.0F);
                  this.aFloatBuffer476.method2252(-229385392, f_5_ * (float)i_25_ + f_22_);
                  this.aFloatBuffer476.method2252(-229385392, (float)i_25_ * f_6_ + f_23_);
                  this.aFloatBuffer476.method2252(-229385392, f_24_ + (float)i_25_ * f_7_);
                  this.aFloatBuffer476.writeByte(b_18_);
                  this.aFloatBuffer476.writeByte(b_19_);
                  this.aFloatBuffer476.writeByte(b_20_);
                  this.aFloatBuffer476.writeByte(b_21_);
                  this.aFloatBuffer476.method2252(-229385392, 0.0F);
                  this.aFloatBuffer476.method2252(-229385392, 1.0F);
                  this.aFloatBuffer476.method2252(-229385392, (float)i_25_ * f_11_ + f_22_);
                  this.aFloatBuffer476.method2252(-229385392, f_23_ + (float)i_25_ * f_12_);
                  this.aFloatBuffer476.method2252(-229385392, (float)i_25_ * f_13_ + f_24_);
                  this.aFloatBuffer476.writeByte(b_18_);
                  this.aFloatBuffer476.writeByte(b_19_);
                  this.aFloatBuffer476.writeByte(b_20_);
                  this.aFloatBuffer476.writeByte(b_21_);
               }

               if (~this.anIntArray488[i_14_] < -65) {
                  int i_26_ = -65 + this.anIntArray488[i_14_];

                  for(int i_27_ = this.anIntArray490[i_26_] - 1; ~i_27_ <= -1; --i_27_) {
                     EntityNode_Sub3_Sub2 entitynode_sub3_sub2 = this.anEntityNode_Sub3_Sub2ArrayArray487[i_26_][i_27_];
                     int i_28_ = entitynode_sub3_sub2.anInt9176;
                     byte b_29_ = (byte)(i_28_ >> 16);
                     byte b_30_ = (byte)(i_28_ >> 8);
                     byte b_31_ = (byte)i_28_;
                     byte b_32_ = (byte)(i_28_ >>> 24);
                     float f_33_ = (float)(entitynode_sub3_sub2.anInt9174 >> 12);
                     float f_34_ = (float)(entitynode_sub3_sub2.anInt9171 >> 12);
                     float f_35_ = (float)(entitynode_sub3_sub2.anInt9173 >> 12);
                     int i_36_ = entitynode_sub3_sub2.anInt9172 >> 12;
                     this.aFloatBuffer476.method2252(-229385392, 0.0F);
                     this.aFloatBuffer476.method2252(-229385392, 0.0F);
                     this.aFloatBuffer476.method2252(-229385392, f_33_ + f_5_ * (float)(-i_36_));
                     this.aFloatBuffer476.method2252(-229385392, f_6_ * (float)(-i_36_) + f_34_);
                     this.aFloatBuffer476.method2252(-229385392, (float)(-i_36_) * f_7_ + f_35_);
                     this.aFloatBuffer476.writeByte(b_29_);
                     this.aFloatBuffer476.writeByte(b_30_);
                     this.aFloatBuffer476.writeByte(b_31_);
                     this.aFloatBuffer476.writeByte(b_32_);
                     this.aFloatBuffer476.method2252(-229385392, 1.0F);
                     this.aFloatBuffer476.method2252(-229385392, 0.0F);
                     this.aFloatBuffer476.method2252(-229385392, f_8_ * (float)i_36_ + f_33_);
                     this.aFloatBuffer476.method2252(-229385392, (float)i_36_ * f_9_ + f_34_);
                     this.aFloatBuffer476.method2252(-229385392, f_10_ * (float)i_36_ + f_35_);
                     this.aFloatBuffer476.writeByte(b_29_);
                     this.aFloatBuffer476.writeByte(b_30_);
                     this.aFloatBuffer476.writeByte(b_31_);
                     this.aFloatBuffer476.writeByte(b_32_);
                     this.aFloatBuffer476.method2252(-229385392, 1.0F);
                     this.aFloatBuffer476.method2252(-229385392, 1.0F);
                     this.aFloatBuffer476.method2252(-229385392, f_33_ + f_5_ * (float)i_36_);
                     this.aFloatBuffer476.method2252(-229385392, (float)i_36_ * f_6_ + f_34_);
                     this.aFloatBuffer476.method2252(-229385392, (float)i_36_ * f_7_ + f_35_);
                     this.aFloatBuffer476.writeByte(b_29_);
                     this.aFloatBuffer476.writeByte(b_30_);
                     this.aFloatBuffer476.writeByte(b_31_);
                     this.aFloatBuffer476.writeByte(b_32_);
                     this.aFloatBuffer476.method2252(-229385392, 0.0F);
                     this.aFloatBuffer476.method2252(-229385392, 1.0F);
                     this.aFloatBuffer476.method2252(-229385392, f_33_ + f_11_ * (float)i_36_);
                     this.aFloatBuffer476.method2252(-229385392, f_12_ * (float)i_36_ + f_34_);
                     this.aFloatBuffer476.method2252(-229385392, f_35_ + (float)i_36_ * f_13_);
                     this.aFloatBuffer476.writeByte(b_29_);
                     this.aFloatBuffer476.writeByte(b_30_);
                     this.aFloatBuffer476.writeByte(b_31_);
                     this.aFloatBuffer476.writeByte(b_32_);
                  }
               }
            }
         }
      } else {
         for(int i_37_ = i + -1; i_37_ >= 0; --i_37_) {
            int i_38_ = ~this.anIntArray488[i_37_] < -65 ? 64 : this.anIntArray488[i_37_];
            if (~i_38_ < -1) {
               for(int i_39_ = -1 + i_38_; i_39_ >= 0; --i_39_) {
                  EntityNode_Sub3_Sub2 entitynode_sub3_sub2 = this.anEntityNode_Sub3_Sub2ArrayArray486[i_37_][i_39_];
                  int i_40_ = entitynode_sub3_sub2.anInt9176;
                  byte b_41_ = (byte)(i_40_ >> 16);
                  byte b_42_ = (byte)(i_40_ >> 8);
                  byte b_43_ = (byte)i_40_;
                  byte b_44_ = (byte)(i_40_ >>> 24);
                  float f_45_ = (float)(entitynode_sub3_sub2.anInt9174 >> 12);
                  float f_46_ = (float)(entitynode_sub3_sub2.anInt9171 >> 12);
                  float f_47_ = (float)(entitynode_sub3_sub2.anInt9173 >> 12);
                  int i_48_ = entitynode_sub3_sub2.anInt9172 >> 12;
                  this.aFloatBuffer476.method2251(8, 0.0F);
                  this.aFloatBuffer476.method2251(8, 0.0F);
                  this.aFloatBuffer476.method2251(8, f_45_ + (float)(-i_48_) * f_5_);
                  this.aFloatBuffer476.method2251(8, (float)(-i_48_) * f_6_ + f_46_);
                  this.aFloatBuffer476.method2251(8, (float)(-i_48_) * f_7_ + f_47_);
                  this.aFloatBuffer476.writeByte(b_41_);
                  this.aFloatBuffer476.writeByte(b_42_);
                  this.aFloatBuffer476.writeByte(b_43_);
                  this.aFloatBuffer476.writeByte(b_44_);
                  this.aFloatBuffer476.method2251(8, 1.0F);
                  this.aFloatBuffer476.method2251(8, 0.0F);
                  this.aFloatBuffer476.method2251(8, f_45_ + (float)i_48_ * f_8_);
                  this.aFloatBuffer476.method2251(8, (float)i_48_ * f_9_ + f_46_);
                  this.aFloatBuffer476.method2251(8, f_47_ + (float)i_48_ * f_10_);
                  this.aFloatBuffer476.writeByte(b_41_);
                  this.aFloatBuffer476.writeByte(b_42_);
                  this.aFloatBuffer476.writeByte(b_43_);
                  this.aFloatBuffer476.writeByte(b_44_);
                  this.aFloatBuffer476.method2251(8, 1.0F);
                  this.aFloatBuffer476.method2251(8, 1.0F);
                  this.aFloatBuffer476.method2251(8, f_5_ * (float)i_48_ + f_45_);
                  this.aFloatBuffer476.method2251(8, f_46_ + (float)i_48_ * f_6_);
                  this.aFloatBuffer476.method2251(8, f_47_ + f_7_ * (float)i_48_);
                  this.aFloatBuffer476.writeByte(b_41_);
                  this.aFloatBuffer476.writeByte(b_42_);
                  this.aFloatBuffer476.writeByte(b_43_);
                  this.aFloatBuffer476.writeByte(b_44_);
                  this.aFloatBuffer476.method2251(8, 0.0F);
                  this.aFloatBuffer476.method2251(8, 1.0F);
                  this.aFloatBuffer476.method2251(8, f_11_ * (float)i_48_ + f_45_);
                  this.aFloatBuffer476.method2251(8, f_46_ + (float)i_48_ * f_12_);
                  this.aFloatBuffer476.method2251(8, f_47_ + f_13_ * (float)i_48_);
                  this.aFloatBuffer476.writeByte(b_41_);
                  this.aFloatBuffer476.writeByte(b_42_);
                  this.aFloatBuffer476.writeByte(b_43_);
                  this.aFloatBuffer476.writeByte(b_44_);
               }

               if (~this.anIntArray488[i_37_] < -65) {
                  int i_49_ = -65 + this.anIntArray488[i_37_];

                  for(int i_50_ = this.anIntArray490[i_49_] + -1; ~i_50_ <= -1; --i_50_) {
                     EntityNode_Sub3_Sub2 entitynode_sub3_sub2 = this.anEntityNode_Sub3_Sub2ArrayArray487[i_49_][i_50_];
                     int i_51_ = entitynode_sub3_sub2.anInt9176;
                     byte b_52_ = (byte)(i_51_ >> 16);
                     byte b_53_ = (byte)(i_51_ >> 8);
                     byte b_54_ = (byte)i_51_;
                     byte b_55_ = (byte)(i_51_ >>> 24);
                     float f_56_ = (float)(entitynode_sub3_sub2.anInt9174 >> 12);
                     float f_57_ = (float)(entitynode_sub3_sub2.anInt9171 >> 12);
                     float f_58_ = (float)(entitynode_sub3_sub2.anInt9173 >> 12);
                     int i_59_ = entitynode_sub3_sub2.anInt9172 >> 12;
                     this.aFloatBuffer476.method2251(8, 0.0F);
                     this.aFloatBuffer476.method2251(8, 0.0F);
                     this.aFloatBuffer476.method2251(8, (float)(-i_59_) * f_5_ + f_56_);
                     this.aFloatBuffer476.method2251(8, f_6_ * (float)(-i_59_) + f_57_);
                     this.aFloatBuffer476.method2251(8, (float)(-i_59_) * f_7_ + f_58_);
                     this.aFloatBuffer476.writeByte(b_52_);
                     this.aFloatBuffer476.writeByte(b_53_);
                     this.aFloatBuffer476.writeByte(b_54_);
                     this.aFloatBuffer476.writeByte(b_55_);
                     this.aFloatBuffer476.method2251(8, 1.0F);
                     this.aFloatBuffer476.method2251(8, 0.0F);
                     this.aFloatBuffer476.method2251(8, (float)i_59_ * f_8_ + f_56_);
                     this.aFloatBuffer476.method2251(8, f_57_ + f_9_ * (float)i_59_);
                     this.aFloatBuffer476.method2251(8, (float)i_59_ * f_10_ + f_58_);
                     this.aFloatBuffer476.writeByte(b_52_);
                     this.aFloatBuffer476.writeByte(b_53_);
                     this.aFloatBuffer476.writeByte(b_54_);
                     this.aFloatBuffer476.writeByte(b_55_);
                     this.aFloatBuffer476.method2251(8, 1.0F);
                     this.aFloatBuffer476.method2251(8, 1.0F);
                     this.aFloatBuffer476.method2251(8, f_56_ + f_5_ * (float)i_59_);
                     this.aFloatBuffer476.method2251(8, f_57_ + f_6_ * (float)i_59_);
                     this.aFloatBuffer476.method2251(8, f_7_ * (float)i_59_ + f_58_);
                     this.aFloatBuffer476.writeByte(b_52_);
                     this.aFloatBuffer476.writeByte(b_53_);
                     this.aFloatBuffer476.writeByte(b_54_);
                     this.aFloatBuffer476.writeByte(b_55_);
                     this.aFloatBuffer476.method2251(8, 0.0F);
                     this.aFloatBuffer476.method2251(8, 1.0F);
                     this.aFloatBuffer476.method2251(8, f_56_ + f_11_ * (float)i_59_);
                     this.aFloatBuffer476.method2251(8, f_57_ + (float)i_59_ * f_12_);
                     this.aFloatBuffer476.method2251(8, f_13_ * (float)i_59_ + f_58_);
                     this.aFloatBuffer476.writeByte(b_52_);
                     this.aFloatBuffer476.writeByte(b_53_);
                     this.aFloatBuffer476.writeByte(b_54_);
                     this.aFloatBuffer476.writeByte(b_55_);
                  }
               }
            }
         }
      }

      if (~this.aFloatBuffer476.offset != -1) {
         this.anInterface9_482.method22(this.aFloatBuffer476.buffer, this.aFloatBuffer476.offset, 24, (byte)74);
         gltoolkit.method1482((byte)111, this.aClass69_483, null, this.aClass69_480, this.aClass69_484);
         gltoolkit.method1441(7, 0, this.aFloatBuffer476.offset / 24, (byte)-42);
      }
   }

   private final void method337(int i, GLToolkit gltoolkit) {
      gltoolkit.method1415(771, true);
      ++anInt478;
      OpenGL.glEnable(16384);
      OpenGL.glEnable(i);
      if (gltoolkit.aFloat6737 != Node_Sub37.aFloat7446) {
         gltoolkit.xa(Node_Sub37.aFloat7446);
      }
   }

   private final void method338(int i, GLToolkit gltoolkit, int i_60_) {
      ++anInt481;
      Node_Sub37.aFloat7446 = gltoolkit.aFloat6737;
      gltoolkit.method1407((byte)120, (float)i);
      gltoolkit.method1421(1);
      OpenGL.glDisable(16384);
      if (i_60_ != 28322) {
         aNode_Sub43_477 = null;
      }

      OpenGL.glDisable(16385);
      gltoolkit.method1415(771, false);
      OpenGL.glNormal3f(0.0F, -1.0F, 0.0F);
   }

   final void method339(GLToolkit gltoolkit, Class198 class198, int i, boolean bool) {
      ++anInt473;
      if (gltoolkit.aClass336_Sub3_6639 != null) {
         if (~i <= -1) {
            this.method338(i, gltoolkit, 28322);
         } else {
            this.method334(false, gltoolkit);
         }

         float f = gltoolkit.aClass336_Sub3_6639.aFloat8605;
         float f_61_ = gltoolkit.aClass336_Sub3_6639.aFloat8593;
         float f_62_ = gltoolkit.aClass336_Sub3_6639.aFloat8604;
         float f_63_ = gltoolkit.aClass336_Sub3_6639.aFloat8615;

         try {
            int i_64_ = 0;
            int i_65_ = Integer.MAX_VALUE;
            int i_66_ = 0;
            EntityNode_Sub3 entitynode_sub3 = class198.aClass87_2429.anEntityNode_Sub3_1186;

            for(EntityNode_Sub3 entitynode_sub3_67_ = entitynode_sub3.anEntityNode_Sub3_5961;
               entitynode_sub3 != entitynode_sub3_67_;
               entitynode_sub3_67_ = entitynode_sub3_67_.anEntityNode_Sub3_5961
            ) {
               EntityNode_Sub3_Sub2 entitynode_sub3_sub2 = (EntityNode_Sub3_Sub2)entitynode_sub3_67_;
               int i_68_ = (int)(
                  f_63_
                     + f_62_ * (float)(entitynode_sub3_sub2.anInt9173 >> 12)
                     + (float)(entitynode_sub3_sub2.anInt9174 >> 12) * f
                     + (float)(entitynode_sub3_sub2.anInt9171 >> 12) * f_61_
               );
               if (i_68_ > i_66_) {
                  i_66_ = i_68_;
               }

               this.anIntArray489[i_64_++] = i_68_;
               if (i_65_ > i_68_) {
                  i_65_ = i_68_;
               }
            }

            int i_69_ = i_66_ + -i_65_;
            int i_70_;
            if (~(i_69_ - -2) >= -1601) {
               i_70_ = 0;
               i_69_ += 2;
            } else {
               i_70_ = 1 + Node_Sub38_Sub20.method2855(i_69_, (byte)-64) - this.anInt479;
               i_69_ = 2 + (i_69_ >> i_70_);
            }

            i_64_ = 0;
            EntityNode_Sub3 entitynode_sub3_71_ = entitynode_sub3.anEntityNode_Sub3_5961;
            int i_72_ = -2;
            boolean bool_73_ = true;

            for(boolean bool_74_ = bool; entitynode_sub3_71_ != entitynode_sub3; this.method336((byte)-122, gltoolkit, i_69_)) {
               this.anInt485 = 0;

               for(int i_75_ = 0; ~i_75_ > ~i_69_; ++i_75_) {
                  this.anIntArray488[i_75_] = 0;
               }

               for(int i_76_ = 0; ~i_76_ > -65; ++i_76_) {
                  this.anIntArray490[i_76_] = 0;
               }

               for(; entitynode_sub3_71_ != entitynode_sub3; entitynode_sub3_71_ = entitynode_sub3_71_.anEntityNode_Sub3_5961) {
                  EntityNode_Sub3_Sub2 entitynode_sub3_sub2 = (EntityNode_Sub3_Sub2)entitynode_sub3_71_;
                  if (bool_74_) {
                     bool_73_ = entitynode_sub3_sub2.aBoolean9169;
                     i_72_ = entitynode_sub3_sub2.anInt9177;
                     bool_74_ = false;
                  }

                  if (~i_64_ < -1 && (entitynode_sub3_sub2.anInt9177 != i_72_ || entitynode_sub3_sub2.aBoolean9169 == !bool_73_)) {
                     bool_74_ = true;
                     break;
                  }

                  int i_77_ = this.anIntArray489[i_64_++] + -i_65_ >> i_70_;
                  if (i_77_ < 1600) {
                     if (this.anIntArray488[i_77_] >= 64) {
                        if (~this.anIntArray488[i_77_] == -65) {
                           if (~this.anInt485 == -65) {
                              continue;
                           }

                           this.anIntArray488[i_77_] += 1 + this.anInt485++;
                        }

                        this.anEntityNode_Sub3_Sub2ArrayArray487[this.anIntArray488[i_77_] + -65][this.anIntArray490[-64 + this.anIntArray488[i_77_] + -1]++] = entitynode_sub3_sub2;
                     } else {
                        this.anEntityNode_Sub3_Sub2ArrayArray486[i_77_][this.anIntArray488[i_77_]++] = entitynode_sub3_sub2;
                     }
                  }
               }

               if (~i_72_ <= -1) {
                  gltoolkit.method1489(i_72_, -2);
               } else {
                  gltoolkit.method1489(-1, -2);
               }

               if (bool_73_ && Node_Sub37.aFloat7446 != gltoolkit.aFloat6737) {
                  gltoolkit.xa(Node_Sub37.aFloat7446);
               } else if (gltoolkit.aFloat6737 != 1.0F) {
                  gltoolkit.xa(1.0F);
               }
            }
         } catch (Exception var21) {
         }

         this.method337(16385, gltoolkit);
      }
   }

   final void method340(int i, GLToolkit gltoolkit) {
      if (i != 26802) {
         this.anInt485 = -119;
      }

      this.anInterface9_482 = gltoolkit.method1467(true, 196584, null, 24, i ^ -26799);
      ++anInt474;
      this.aClass69_484 = new Class69(this.anInterface9_482, 5126, 2, 0);
      this.aClass69_480 = new Class69(this.anInterface9_482, 5126, 3, 8);
      this.aClass69_483 = new Class69(this.anInterface9_482, 5121, 4, 20);
   }

   Class29() {
      this.anEntityNode_Sub3_Sub2ArrayArray486 = new EntityNode_Sub3_Sub2[1600][64];
      this.anInt485 = 0;
      this.anIntArray489 = new int[8191];
      this.anIntArray490 = new int[64];
   }
}
