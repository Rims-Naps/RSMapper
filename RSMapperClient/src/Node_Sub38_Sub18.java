public class Node_Sub38_Sub18 extends Node_Sub38 {
   static int anInt10275;
   static int anInt10276;
   static IncommingPacket aClass192_10277 = new IncommingPacket(121, 6);
   private int anInt10278 = 6;
   static int anInt10279;
   static int anInt10280;
   static int anInt10281;
   static boolean aBoolean10282 = false;
   static String aString10283 = null;

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      ++anInt10281;
      if (i != 0) {
         if (~i == -2) {
            this.aBoolean7463 = ~buffer.readUnsignedByte() == -2;
         }
      } else {
         this.anInt10278 = buffer.readUnsignedByte();
      }

      if (bool) {
         aClass192_10277 = null;
      }
   }

   @Override
   final int[] method2775(int i, int i_1_) {
      ++anInt10276;
      int[] is = this.aClass146_7460.method1645(27356, i_1_);
      if (i <= 107) {
         aString10283 = null;
      }

      if (this.aClass146_7460.aBoolean1819) {
         int[] is_2_ = this.method2786(i_1_, 0, 0);
         int[] is_3_ = this.method2786(i_1_, 0, 1);
         int i_4_ = this.anInt10278;
         if (i_4_ != 1) {
            if (~i_4_ != -3) {
               if (i_4_ != 3) {
                  if (i_4_ != 4) {
                     if (i_4_ != 5) {
                        if (i_4_ != 6) {
                           if (~i_4_ != -8) {
                              if (~i_4_ != -9) {
                                 if (i_4_ != 9) {
                                    if (i_4_ != 10) {
                                       if (~i_4_ != -12) {
                                          if (~i_4_ == -13) {
                                             for(int var9 = 0; ~var9 > ~Class339_Sub7.anInt8728; ++var9) {
                                                int i_15_ = is_3_[var9];
                                                int i_16_ = is_2_[var9];
                                                is[var9] = i_16_ + i_15_ + -(i_16_ * i_15_ >> 11);
                                             }
                                          }
                                       } else {
                                          for(int var10 = 0; Class339_Sub7.anInt8728 > var10; ++var10) {
                                             int i_13_ = is_2_[var10];
                                             int i_14_ = is_3_[var10];
                                             is[var10] = i_14_ < i_13_ ? -i_14_ + i_13_ : -i_13_ + i_14_;
                                          }
                                       }
                                    } else {
                                       for(int var11 = 0; ~Class339_Sub7.anInt8728 < ~var11; ++var11) {
                                          int i_11_ = is_3_[var11];
                                          int i_12_ = is_2_[var11];
                                          is[var11] = ~i_11_ > ~i_12_ ? i_12_ : i_11_;
                                       }
                                    }
                                 } else {
                                    for(int var12 = 0; ~var12 > ~Class339_Sub7.anInt8728; ++var12) {
                                       int i_9_ = is_2_[var12];
                                       int i_10_ = is_3_[var12];
                                       is[var12] = ~i_10_ < ~i_9_ ? i_9_ : i_10_;
                                    }
                                 }
                              } else {
                                 for(int var13 = 0; var13 < Class339_Sub7.anInt8728; ++var13) {
                                    int i_8_ = is_2_[var13];
                                    is[var13] = ~i_8_ == -1 ? 0 : 4096 - (4096 + -is_3_[var13] << 12) / i_8_;
                                 }
                              }
                           } else {
                              for(int var14 = 0; Class339_Sub7.anInt8728 > var14; ++var14) {
                                 int i_7_ = is_2_[var14];
                                 is[var14] = i_7_ == 4096 ? 4096 : (is_3_[var14] << 12) / (4096 + -i_7_);
                              }
                           }
                        } else {
                           for(int var15 = 0; ~var15 > ~Class339_Sub7.anInt8728; ++var15) {
                              int i_6_ = is_3_[var15];
                              is[var15] = ~i_6_ > -2049 ? i_6_ * is_2_[var15] >> 11 : 4096 - ((-i_6_ + 4096) * (-is_2_[var15] + 4096) >> 11);
                           }
                        }
                     } else {
                        for(int var16 = 0; ~var16 > ~Class339_Sub7.anInt8728; ++var16) {
                           is[var16] = -((4096 + -is_3_[var16]) * (-is_2_[var16] + 4096) >> 12) + 4096;
                        }
                     }
                  } else {
                     for(int var17 = 0; ~var17 > ~Class339_Sub7.anInt8728; ++var17) {
                        int i_5_ = is_3_[var17];
                        is[var17] = i_5_ == 0 ? 4096 : (is_2_[var17] << 12) / i_5_;
                     }
                  }
               } else {
                  for(int var18 = 0; Class339_Sub7.anInt8728 > var18; ++var18) {
                     is[var18] = is_3_[var18] * is_2_[var18] >> 12;
                  }
               }
            } else {
               for(int var19 = 0; Class339_Sub7.anInt8728 > var19; ++var19) {
                  is[var19] = is_2_[var19] - is_3_[var19];
               }
            }
         } else {
            for(int var20 = 0; ~var20 > ~Class339_Sub7.anInt8728; ++var20) {
               is[var20] = is_2_[var20] - -is_3_[var20];
            }
         }
      }

      return is;
   }

   @Override
   final int[][] method2778(int i, boolean bool) {
      ++anInt10279;
      int[][] is = this.aClass348_7454.method3981(i, 3168);
      if (!bool) {
         method2844(-73, true);
      }

      if (this.aClass348_7454.aBoolean4300) {
         int[][] is_17_ = this.method2777(-100, 0, i);
         int[][] is_18_ = this.method2777(-124, 1, i);
         int[] is_19_ = is[0];
         int[] is_20_ = is[1];
         int[] is_21_ = is[2];
         int[] is_22_ = is_17_[0];
         int[] is_23_ = is_17_[1];
         int[] is_24_ = is_17_[2];
         int[] is_25_ = is_18_[0];
         int[] is_26_ = is_18_[1];
         int[] is_27_ = is_18_[2];
         int i_28_ = this.anInt10278;
         if (i_28_ != 1) {
            if (~i_28_ != -3) {
               if (i_28_ != 3) {
                  if (~i_28_ != -5) {
                     if (i_28_ != 5) {
                        if (i_28_ != 6) {
                           if (~i_28_ != -8) {
                              if (i_28_ != 8) {
                                 if (~i_28_ != -10) {
                                    if (~i_28_ != -11) {
                                       if (~i_28_ != -12) {
                                          if (i_28_ == 12) {
                                             for(int var22 = 0; ~var22 > ~Class339_Sub7.anInt8728; ++var22) {
                                                int i_59_ = is_23_[var22];
                                                int i_60_ = is_26_[var22];
                                                int i_61_ = is_27_[var22];
                                                int i_62_ = is_22_[var22];
                                                int i_63_ = is_24_[var22];
                                                int i_64_ = is_25_[var22];
                                                is_19_[var22] = -(i_62_ * i_64_ >> 11) + i_64_ + i_62_;
                                                is_20_[var22] = -(i_60_ * i_59_ >> 11) + i_59_ + i_60_;
                                                is_21_[var22] = i_61_ + i_63_ - (i_61_ * i_63_ >> 11);
                                             }
                                          }
                                       } else {
                                          for(int var23 = 0; var23 < Class339_Sub7.anInt8728; ++var23) {
                                             int i_53_ = is_25_[var23];
                                             int i_54_ = is_23_[var23];
                                             int i_55_ = is_26_[var23];
                                             int i_56_ = is_24_[var23];
                                             int i_57_ = is_22_[var23];
                                             int i_58_ = is_27_[var23];
                                             is_19_[var23] = i_53_ < i_57_ ? i_57_ + -i_53_ : i_53_ - i_57_;
                                             is_20_[var23] = i_55_ >= i_54_ ? i_55_ - i_54_ : i_54_ + -i_55_;
                                             is_21_[var23] = ~i_56_ >= ~i_58_ ? i_58_ - i_56_ : i_56_ - i_58_;
                                          }
                                       }
                                    } else {
                                       for(int var24 = 0; Class339_Sub7.anInt8728 > var24; ++var24) {
                                          int i_47_ = is_27_[var24];
                                          int i_48_ = is_22_[var24];
                                          int i_49_ = is_26_[var24];
                                          int i_50_ = is_25_[var24];
                                          int i_51_ = is_24_[var24];
                                          int i_52_ = is_23_[var24];
                                          is_19_[var24] = ~i_48_ < ~i_50_ ? i_48_ : i_50_;
                                          is_20_[var24] = ~i_49_ > ~i_52_ ? i_52_ : i_49_;
                                          is_21_[var24] = i_51_ <= i_47_ ? i_47_ : i_51_;
                                       }
                                    }
                                 } else {
                                    for(int var25 = 0; ~Class339_Sub7.anInt8728 < ~var25; ++var25) {
                                       int i_41_ = is_23_[var25];
                                       int i_42_ = is_26_[var25];
                                       int i_43_ = is_24_[var25];
                                       int i_44_ = is_25_[var25];
                                       int i_45_ = is_22_[var25];
                                       int i_46_ = is_27_[var25];
                                       is_19_[var25] = i_44_ > i_45_ ? i_45_ : i_44_;
                                       is_20_[var25] = i_42_ <= i_41_ ? i_42_ : i_41_;
                                       is_21_[var25] = i_46_ <= i_43_ ? i_46_ : i_43_;
                                    }
                                 }
                              } else {
                                 for(int var26 = 0; ~var26 > ~Class339_Sub7.anInt8728; ++var26) {
                                    int i_38_ = is_24_[var26];
                                    int i_39_ = is_22_[var26];
                                    int i_40_ = is_23_[var26];
                                    is_19_[var26] = i_39_ == 0 ? 0 : -((-is_25_[var26] + 4096 << 12) / i_39_) + 4096;
                                    is_20_[var26] = ~i_40_ != -1 ? 4096 + -((-is_26_[var26] + 4096 << 12) / i_40_) : 0;
                                    is_21_[var26] = ~i_38_ != -1 ? -((4096 + -is_27_[var26] << 12) / i_38_) + 4096 : 0;
                                 }
                              }
                           } else {
                              for(int var27 = 0; var27 < Class339_Sub7.anInt8728; ++var27) {
                                 int i_35_ = is_24_[var27];
                                 int i_36_ = is_23_[var27];
                                 int i_37_ = is_22_[var27];
                                 is_19_[var27] = ~i_37_ != -4097 ? (is_25_[var27] << 12) / (4096 + -i_37_) : 4096;
                                 is_20_[var27] = i_36_ == 4096 ? 4096 : (is_26_[var27] << 12) / (4096 - i_36_);
                                 is_21_[var27] = ~i_35_ == -4097 ? 4096 : (is_27_[var27] << 12) / (4096 - i_35_);
                              }
                           }
                        } else {
                           for(int var28 = 0; Class339_Sub7.anInt8728 > var28; ++var28) {
                              int i_32_ = is_25_[var28];
                              int i_33_ = is_27_[var28];
                              int i_34_ = is_26_[var28];
                              is_19_[var28] = i_32_ >= 2048 ? -((-i_32_ + 4096) * (4096 + -is_22_[var28]) >> 11) + 4096 : i_32_ * is_22_[var28] >> 11;
                              is_20_[var28] = i_34_ < 2048 ? is_23_[var28] * i_34_ >> 11 : -((-i_34_ + 4096) * (-is_23_[var28] + 4096) >> 11) + 4096;
                              is_21_[var28] = ~i_33_ <= -2049 ? -((4096 - i_33_) * (4096 + -is_24_[var28]) >> 11) + 4096 : i_33_ * is_24_[var28] >> 11;
                           }
                        }
                     } else {
                        for(int var29 = 0; var29 < Class339_Sub7.anInt8728; ++var29) {
                           is_19_[var29] = -((4096 - is_25_[var29]) * (-is_22_[var29] + 4096) >> 12) + 4096;
                           is_20_[var29] = -((4096 - is_26_[var29]) * (4096 - is_23_[var29]) >> 12) + 4096;
                           is_21_[var29] = 4096 + -((-is_24_[var29] + 4096) * (-is_27_[var29] + 4096) >> 12);
                        }
                     }
                  } else {
                     for(int var30 = 0; var30 < Class339_Sub7.anInt8728; ++var30) {
                        int i_29_ = is_26_[var30];
                        int i_30_ = is_27_[var30];
                        int i_31_ = is_25_[var30];
                        is_19_[var30] = i_31_ != 0 ? (is_22_[var30] << 12) / i_31_ : 4096;
                        is_20_[var30] = i_29_ != 0 ? (is_23_[var30] << 12) / i_29_ : 4096;
                        is_21_[var30] = i_30_ != 0 ? (is_24_[var30] << 12) / i_30_ : 4096;
                     }
                  }
               } else {
                  for(int var31 = 0; var31 < Class339_Sub7.anInt8728; ++var31) {
                     is_19_[var31] = is_22_[var31] * is_25_[var31] >> 12;
                     is_20_[var31] = is_26_[var31] * is_23_[var31] >> 12;
                     is_21_[var31] = is_27_[var31] * is_24_[var31] >> 12;
                  }
               }
            } else {
               for(int var32 = 0; ~Class339_Sub7.anInt8728 < ~var32; ++var32) {
                  is_19_[var32] = -is_25_[var32] + is_22_[var32];
                  is_20_[var32] = -is_26_[var32] + is_23_[var32];
                  is_21_[var32] = -is_27_[var32] + is_24_[var32];
               }
            }
         } else {
            for(int var33 = 0; Class339_Sub7.anInt8728 > var33; ++var33) {
               is_19_[var33] = is_25_[var33] + is_22_[var33];
               is_20_[var33] = is_23_[var33] - -is_26_[var33];
               is_21_[var33] = is_27_[var33] + is_24_[var33];
            }
         }
      }

      return is;
   }

   static final boolean method2844(int i, boolean bool) {
      if (!bool) {
         method2844(-113, false);
      }

      ++anInt10280;
      return i >= 12 && i <= 17;
   }

   public static void method2845(byte b) {
      if (b <= 121) {
         aClass192_10277 = null;
      }

      aString10283 = null;
      aClass192_10277 = null;
   }

   static final void method2846(int i, byte b, IComponentDefinitions widget, int i_65_) {
      ++anInt10275;
      if (widget != null) {
         if (widget.anObjectArray4768 != null) {
            Node_Sub37 node_sub37 = new Node_Sub37();
            node_sub37.aWidget7437 = widget;
            node_sub37.parameters = widget.anObjectArray4768;
            ClientScriptsExecutor.sendRunScript(node_sub37);
         }

         Class92.anInt1230 = widget.itemId;
         Node_Sub15_Sub9.anInt9839 = widget.ihash;
         Class87.removeWalkHere = true;
         if (b >= -90) {
            method2845((byte)-18);
         }

         Class324.anInt4087 = i_65_;
         Class201.anInt2444 = widget.anInt4698;
         Class46.anInt681 = widget.anInt4687;
         Class239.anInt2928 = widget.anInt4839;
         Class200_Sub2.anInt4943 = i;
         ClientScript.method2321(-1, widget);
      }
   }

   public Node_Sub38_Sub18() {
      super(2, false);
   }
}
