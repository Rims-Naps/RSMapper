public class Node_Sub38_Sub27 extends Node_Sub38 {
   private byte[] aByteArray10371 = new byte[512];
   static int[] anIntArray10372 = new int[1];
   static int anInt10373;
   private short[] aShortArray10374;
   static int anInt10375;
   static int anInt10376;
   protected boolean aBoolean10377 = true;
   protected int anInt10378;
   static int anInt10379;
   static int anInt10380;
   static int anInt10381;
   protected int anInt10382 = 4;
   static int anInt10383;
   protected int anInt10384 = 4;
   static int anInt10385;
   private short[] aShortArray10386;
   static int anInt10387;
   static int anInt10388;
   protected int anInt10389;
   protected int anInt10390;

   static final void method2878(int i, String string, boolean bool, int i_0_) {
      Class94.method1065(-81);
      ++anInt10379;
      if (~i_0_ == -1) {
         Class93.aGraphicsToolkit1241 = Class262_Sub9.method3171(
            Class262_Sub2.index31,
            (byte)55,
            TemporaryItemDefinition.aD565,
            0,
            Node_Sub38_Sub20.GAME_CANVAS,
            2 * Class213.aNode_Sub27_2512.aClass320_Sub13_7283.method3734(false)
         );
         if (string != null) {
            Class93.aGraphicsToolkit1241.GA(0);
            Class357 class357 = Class44.method461(0, 125, Class285.anInt3600, AnimableAnimator_Sub1.index13);
            Class52 class52 = Class93.aGraphicsToolkit1241.a(class357, Class383.method4187(Node_Sub38_Sub39.index8, Class285.anInt3600, 0), true);
            Node_Sub36_Sub1.method2758(-80);
            Class169_Sub3.method1779(Class93.aGraphicsToolkit1241, string, true, class357, class52, -16777216);
         }
      } else {
         label161: {
            GraphicsToolkit graphicstoolkit = null;
            if (string != null) {
               graphicstoolkit = Class262_Sub9.method3171(Class262_Sub2.index31, (byte)-82, TemporaryItemDefinition.aD565, 0, Node_Sub38_Sub20.GAME_CANVAS, 0);
               graphicstoolkit.GA(0);
               Class357 class357 = Class44.method461(0, -30, Class285.anInt3600, AnimableAnimator_Sub1.index13);
               Class52 class52 = graphicstoolkit.a(class357, Class383.method4187(Node_Sub38_Sub39.index8, Class285.anInt3600, 0), true);
               Node_Sub36_Sub1.method2758(109);
               Class169_Sub3.method1779(graphicstoolkit, string, true, class357, class52, -16777216);
            }

            try {
               int i_2_;
               try {
                  Class93.aGraphicsToolkit1241 = Class262_Sub9.method3171(
                     Class262_Sub2.index31,
                     (byte)-113,
                     TemporaryItemDefinition.aD565,
                     i_0_,
                     Node_Sub38_Sub20.GAME_CANVAS,
                     2 * Class213.aNode_Sub27_2512.aClass320_Sub13_7283.method3734(false)
                  );
                  if (string != null) {
                     graphicstoolkit.GA(0);
                     Class357 class357 = Class44.method461(0, -5, Class285.anInt3600, AnimableAnimator_Sub1.index13);
                     Class52 class52 = graphicstoolkit.a(class357, Class383.method4187(Node_Sub38_Sub39.index8, Class285.anInt3600, 0), true);
                     Node_Sub36_Sub1.method2758(-50);
                     Class169_Sub3.method1779(graphicstoolkit, string, true, class357, class52, -16777216);
                  }

                  if (Class93.aGraphicsToolkit1241.k()) {
                     boolean bool_1_ = true;

                     try {
                        bool_1_ = Node_Sub23.aNode_Sub39_7201.anInt7484 > 256;
                     } catch (Throwable var16) {
                     }

                     za var_za;
                     if (bool_1_) {
                        var_za = Class93.aGraphicsToolkit1241.a(146800640);
                     } else {
                        var_za = Class93.aGraphicsToolkit1241.a(104857600);
                     }

                     Class93.aGraphicsToolkit1241.a(var_za);
                  }
                  break label161;
               } catch (Throwable var17) {
                  i_2_ = Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false);
                  if (~i_2_ == -3) {
                     Node_Sub12.aBoolean5456 = true;
                  }
               }

               Class213.aNode_Sub27_2512.method2690(75, 0, Class213.aNode_Sub27_2512.aClass320_Sub29_7270);
               method2878(60, string, bool, i_2_);
            } finally {
               if (graphicstoolkit != null) {
                  try {
                     graphicstoolkit.method1233(-7751);
                  } catch (Throwable var15) {
                  }
               }
            }

            return;
         }
      }

      Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3794(!bool, (byte)99);
      Class213.aNode_Sub27_2512.method2690(32, i_0_, Class213.aNode_Sub27_2512.aClass320_Sub29_7270);
      Class59.method591(-6194);
      Class93.aGraphicsToolkit1241.b(10000);
      Class93.aGraphicsToolkit1241.X(32);
      Class290_Sub6.aClass336_8114 = Class93.aGraphicsToolkit1241.y();
      Node_Sub5.aClass336_7032 = Class93.aGraphicsToolkit1241.y();
      Class116.method1163(2);
      Class93.aGraphicsToolkit1241.a(Class213.aNode_Sub27_2512.aClass320_Sub9_7315.method3715(false) == 1);
      if (Class93.aGraphicsToolkit1241.o()) {
         Node_Sub19.method2610((byte)-58, ~Class213.aNode_Sub27_2512.aClass320_Sub20_7306.method3758(false) == -2);
      }

      if (i <= 54) {
         anIntArray10372 = null;
      }

      Class325.method3814(Class93.aGraphicsToolkit1241, 18521, Class377_Sub1.GAME_SCENE_HEIGHT >> 3, Node_Sub54.GAME_SCENE_WDITH >> 3);
      Class120.method1228(-127);
      Class152.aBoolean1942 = true;
      Node_Sub52.aClass244Array7654 = null;
      Class269.aBoolean3472 = false;
      Class34_Sub1.method378(-4);
   }

   public static void method2879(boolean bool) {
      if (!bool) {
         anIntArray10372 = null;
      }
   }

   final void method2880(int i, int[] is, int i_3_) {
      if (i_3_ <= -32) {
         ++anInt10387;
         int i_4_ = this.anInt10384 * Node_Sub25_Sub1.anIntArray9941[i];
         if (this.anInt10382 == 1) {
            int i_5_ = this.aShortArray10386[0];
            int i_6_ = this.aShortArray10374[0] << 12;
            int i_7_ = i_4_ * i_6_ >> 12;
            int i_8_ = this.anInt10384 * i_6_ >> 12;
            int i_9_ = this.anInt10390 * i_6_ >> 12;
            int i_10_ = i_7_ >> 12;
            int i_11_ = i_10_ + 1;
            i_7_ &= 4095;
            if (i_8_ <= i_11_) {
               i_11_ = 0;
            }

            int i_12_ = 255 & this.aByteArray10371[0xFF & i_10_];
            int i_13_ = CacheNode_Sub17.anIntArray8840[i_7_];
            int i_14_ = 255 & this.aByteArray10371[0xFF & i_11_];
            if (this.aBoolean10377) {
               for(int i_15_ = 0; i_15_ < Class339_Sub7.anInt8728; ++i_15_) {
                  int i_16_ = this.anInt10390 * CacheNode_Sub3.anIntArray9442[i_15_];
                  int i_17_ = this.method2883(i_9_, i_12_, -28740, i_6_ * i_16_ >> 12, i_7_, i_13_, i_14_);
                  i_17_ = i_17_ * i_5_ >> 12;
                  is[i_15_] = 2048 - -(i_17_ >> 1);
               }
            } else {
               for(int i_18_ = 0; ~i_18_ > ~Class339_Sub7.anInt8728; ++i_18_) {
                  int i_19_ = CacheNode_Sub3.anIntArray9442[i_18_] * this.anInt10390;
                  int i_20_ = this.method2883(i_9_, i_12_, -28740, i_6_ * i_19_ >> 12, i_7_, i_13_, i_14_);
                  is[i_18_] = i_20_ * i_5_ >> 12;
               }
            }
         } else {
            int i_21_ = this.aShortArray10386[0];
            if (~i_21_ < -9 || ~i_21_ > 7) {
               int i_22_ = this.aShortArray10374[0] << 12;
               int i_23_ = i_22_ * this.anInt10390 >> 12;
               int i_24_ = i_22_ * i_4_ >> 12;
               int i_25_ = this.anInt10384 * i_22_ >> 12;
               int i_26_ = i_24_ >> 12;
               int i_27_ = i_26_ + 1;
               if (i_25_ <= i_27_) {
                  i_27_ = 0;
               }

               i_24_ &= 4095;
               int i_28_ = 255 & this.aByteArray10371[i_26_ & 0xFF];
               int i_29_ = CacheNode_Sub17.anIntArray8840[i_24_];
               int i_30_ = 255 & this.aByteArray10371[0xFF & i_27_];

               for(int i_31_ = 0; Class339_Sub7.anInt8728 > i_31_; ++i_31_) {
                  int i_32_ = this.anInt10390 * CacheNode_Sub3.anIntArray9442[i_31_];
                  int i_33_ = this.method2883(i_23_, i_28_, -28740, i_32_ * i_22_ >> 12, i_24_, i_29_, i_30_);
                  is[i_31_] = i_33_ * i_21_ >> 12;
               }
            }

            for(int i_34_ = 1; i_34_ < this.anInt10382; ++i_34_) {
               int var20 = this.aShortArray10386[i_34_];
               if (~var20 < -9 || ~var20 > 7) {
                  int i_35_ = this.aShortArray10374[i_34_] << 12;
                  int i_36_ = i_35_ * this.anInt10390 >> 12;
                  int i_37_ = i_35_ * this.anInt10384 >> 12;
                  int i_38_ = i_35_ * i_4_ >> 12;
                  int i_39_ = i_38_ >> 12;
                  int i_40_ = i_39_ - -1;
                  i_38_ &= 4095;
                  if (~i_37_ >= ~i_40_) {
                     i_40_ = 0;
                  }

                  int i_41_ = 255 & this.aByteArray10371[0xFF & i_40_];
                  int i_42_ = CacheNode_Sub17.anIntArray8840[i_38_];
                  int i_43_ = 255 & this.aByteArray10371[0xFF & i_39_];
                  if (this.aBoolean10377 && -1 + this.anInt10382 == i_34_) {
                     for(int i_47_ = 0; ~i_47_ > ~Class339_Sub7.anInt8728; ++i_47_) {
                        int i_48_ = CacheNode_Sub3.anIntArray9442[i_47_] * this.anInt10390;
                        int i_49_ = this.method2883(i_36_, i_43_, -28740, i_48_ * i_35_ >> 12, i_38_, i_42_, i_41_);
                        i_49_ = (i_49_ * var20 >> 12) + is[i_47_];
                        is[i_47_] = 2048 + (i_49_ >> 1);
                     }
                  } else {
                     for(int i_44_ = 0; ~i_44_ > ~Class339_Sub7.anInt8728; ++i_44_) {
                        int i_45_ = CacheNode_Sub3.anIntArray9442[i_44_] * this.anInt10390;
                        int i_46_ = this.method2883(i_36_, i_43_, -28740, i_35_ * i_45_ >> 12, i_38_, i_42_, i_41_);
                        is[i_44_] += i_46_ * var20 >> 12;
                     }
                  }
               }
            }
         }
      }
   }

   @Override
   final int[] method2775(int i, int i_50_) {
      ++anInt10380;
      int[] is = this.aClass146_7460.method1645(27356, i_50_);
      if (i <= 107) {
         this.aShortArray10374 = null;
      }

      if (this.aClass146_7460.aBoolean1819) {
         this.method2880(i_50_, is, -88);
      }

      return is;
   }

   @Override
   final void method2785(int i) {
      ++anInt10375;
      this.aByteArray10371 = Class169_Sub3.method1778(this.anInt10389, true);
      this.method2884(i + -8);
      int i_51_ = -1 + this.anInt10382;
      if (i == 7) {
         while(~i_51_ <= -2) {
            short s = this.aShortArray10386[i_51_];
            if (s > 8 || ~s > 7) {
               break;
            }

            --this.anInt10382;
            --i_51_;
         }
      }
   }

   static final void method2881(int i, byte b, int i_52_, int i_53_, int i_54_) {
      ++anInt10385;
      int i_55_ = Node_Sub53.anInt7669;
      if (~i_55_ != -1) {
         if (i_55_ != 1) {
            if (~i_55_ == -3) {
               if (Class168.anInt2046 > i) {
                  Class168.anInt2046 = i;
               }

               if (Node_Sub33.anInt7405 > i_54_) {
                  Node_Sub33.anInt7405 = i_54_;
               }

               if (Class320_Sub28.anInt8469 < i_52_) {
                  Class320_Sub28.anInt8469 = i_52_;
               }

               if (~Class308.anInt3914 > ~i_53_) {
                  Class308.anInt3914 = i_53_;
               }
            } else {
               if (b != 112) {
                  method2878(-57, null, false, 91);
               }
            }
         } else {
            Class320_Sub28.anInt8469 = i_52_;
            Node_Sub53.anInt7669 = 2;
            Node_Sub33.anInt7405 = i_54_;
            Class168.anInt2046 = i;
            Class308.anInt3914 = i_53_;
         }
      }
   }

   static final TemporaryItemDefinition method2882(Buffer buffer, ItemDefinitions itemdefinition, int i) {
      ++anInt10373;
      TemporaryItemDefinition class38 = new TemporaryItemDefinition(itemdefinition);
      int i_56_ = buffer.readUnsignedByte();
      boolean bool = (i_56_ & 1) != 0;
      boolean bool_57_ = ~(i_56_ & 2) != -1;
      boolean bool_58_ = ~(i_56_ & 4) != -1;
      boolean bool_59_ = (8 & i_56_) != i;
      if (bool) {
         class38.maleWornModelIds[0] = buffer.method2183();
         class38.femaleWornModelIds[0] = buffer.method2183();
         if (itemdefinition.maleEquip2 != -1 || itemdefinition.femaleEquip2 != -1) {
            class38.maleWornModelIds[1] = buffer.method2183();
            class38.femaleWornModelIds[1] = buffer.method2183();
         }

         if (~itemdefinition.maleEquipModelId3 != 0 || itemdefinition.femaleEquipModelId3 != -1) {
            class38.maleWornModelIds[2] = buffer.method2183();
            class38.femaleWornModelIds[2] = buffer.method2183();
         }
      }

      if (bool_57_) {
         class38.anIntArray564[0] = buffer.method2183();
         class38.anIntArray568[0] = buffer.method2183();
         if (itemdefinition.maleDialogueHat != -1 || itemdefinition.femaleDialogueHat != -1) {
            class38.anIntArray564[1] = buffer.method2183();
            class38.anIntArray568[1] = buffer.method2183();
         }
      }

      if (bool_58_) {
         int i_60_ = buffer.readUnsignedShort();
         int[] is = new int[]{Node_Sub30.method2723(i_60_, 15), 0, 0, Node_Sub30.method2723(15, i_60_ >> 12)};
         is[1] = Node_Sub30.method2723(15, i_60_ >> 4);
         is[2] = Node_Sub30.method2723(i_60_, 3921) >> 8;

         for(int i_61_ = 0; ~i_61_ > -5; ++i_61_) {
            if (~is[i_61_] != -16) {
               class38.modifiedModelColors[is[i_61_]] = (short)buffer.readUnsignedShort();
            }
         }
      }

      if (bool_59_) {
         int i_62_ = buffer.readUnsignedByte();
         int[] is = new int[]{Node_Sub30.method2723(i_62_, 15), Node_Sub30.method2723(i_62_ >> 4, 15)};

         for(int i_63_ = 0; ~i_63_ > -3; ++i_63_) {
            if (~is[i_63_] != -16) {
               class38.modifiedTextureColors[is[i_63_]] = (short)buffer.readUnsignedShort();
            }
         }
      }

      return class38;
   }

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      ++anInt10381;
      if (bool) {
         this.method2775(17, -97);
      }

      if (~i != -1) {
         if (~i == -2) {
            this.anInt10382 = buffer.readUnsignedByte();
         } else {
            if (~i != -3) {
               if (~i == -4) {
                  this.anInt10390 = this.anInt10384 = buffer.readUnsignedByte();
                  return;
               }

               if (i == 4) {
                  this.anInt10389 = buffer.readUnsignedByte();
                  return;
               }

               if (~i == -6) {
                  this.anInt10390 = buffer.readUnsignedByte();
                  return;
               }

               if (~i == -7) {
                  this.anInt10384 = buffer.readUnsignedByte();
               }
            } else {
               this.anInt10378 = buffer.readShort();
               if (this.anInt10378 < 0) {
                  this.aShortArray10386 = new short[this.anInt10382];

                  for(int i_64_ = 0; i_64_ < this.anInt10382; ++i_64_) {
                     this.aShortArray10386[i_64_] = (short)buffer.readShort();
                  }
               }
            }
         }
      } else {
         this.aBoolean10377 = ~buffer.readUnsignedByte() == -2;
      }
   }

   private final int method2883(int i, int i_65_, int i_66_, int i_67_, int i_68_, int i_69_, int i_70_) {
      ++anInt10383;
      int i_71_ = i_67_ >> 12;
      int i_72_ = 1 + i_71_;
      i_67_ &= 4095;
      if (~i >= ~i_72_) {
         i_72_ = 0;
      }

      i_71_ &= 255;
      int i_73_ = i_67_ + -4096;
      i_72_ &= 255;
      int i_74_ = i_68_ - 4096;
      int i_75_ = CacheNode_Sub17.anIntArray8840[i_67_];
      if (i_66_ != -28740) {
         this.method2880(-110, null, -123);
      }

      int i_76_ = 3 & this.aByteArray10371[i_65_ + i_71_];
      int i_77_;
      if (~i_76_ >= -2) {
         i_77_ = i_76_ == 0 ? i_67_ + i_68_ : -i_67_ + i_68_;
      } else {
         i_77_ = ~i_76_ == -3 ? i_67_ - i_68_ : -i_68_ + -i_67_;
      }

      i_76_ = 3 & this.aByteArray10371[i_72_ - -i_65_];
      int i_78_;
      if (i_76_ > 1) {
         i_78_ = ~i_76_ != -3 ? -i_68_ + -i_73_ : -i_68_ + i_73_;
      } else {
         i_78_ = i_76_ != 0 ? -i_73_ + i_68_ : i_68_ + i_73_;
      }

      i_76_ = 3 & this.aByteArray10371[i_71_ - -i_70_];
      int i_79_ = ((i_78_ - i_77_) * i_75_ >> 12) + i_77_;
      if (i_76_ <= 1) {
         i_77_ = i_76_ != 0 ? i_74_ + -i_67_ : i_74_ + i_67_;
      } else {
         i_77_ = ~i_76_ != -3 ? -i_67_ + -i_74_ : -i_74_ + i_67_;
      }

      i_76_ = this.aByteArray10371[i_70_ + i_72_] & 3;
      if (~i_76_ < -2) {
         i_78_ = ~i_76_ == -3 ? -i_74_ + i_73_ : -i_73_ + -i_74_;
      } else {
         i_78_ = ~i_76_ != -1 ? -i_73_ + i_74_ : i_74_ + i_73_;
      }

      int i_80_ = i_77_ - -(i_75_ * (i_78_ - i_77_) >> 12);
      return (i_69_ * (i_80_ - i_79_) >> 12) + i_79_;
   }

   public Node_Sub38_Sub27() {
      super(0, true);
      this.anInt10378 = 1638;
      this.anInt10390 = 4;
      this.anInt10389 = 0;
   }

   private final void method2884(int i) {
      if (i > ~this.anInt10378) {
         this.aShortArray10374 = new short[this.anInt10382];
         this.aShortArray10386 = new short[this.anInt10382];

         for(int i_81_ = 0; i_81_ < this.anInt10382; ++i_81_) {
            this.aShortArray10386[i_81_] = (short)((int)(4096.0 * Math.pow((double)((float)this.anInt10378 / 4096.0F), (double)i_81_)));
            this.aShortArray10374[i_81_] = (short)((int)Math.pow(2.0, (double)i_81_));
         }
      } else if (this.aShortArray10386 != null && this.anInt10382 == this.aShortArray10386.length) {
         this.aShortArray10374 = new short[this.anInt10382];

         for(int i_82_ = 0; i_82_ < this.anInt10382; ++i_82_) {
            this.aShortArray10374[i_82_] = (short)((int)Math.pow(2.0, (double)i_82_));
         }
      }

      ++anInt10376;
   }
}
