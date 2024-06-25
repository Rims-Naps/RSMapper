public class Class128 {
   static int anInt1647;
   static int anInt1648;
   static int anInt1649;
   private Index index22;
   static OutgoingPacket aClass318_1651 = new OutgoingPacket(5, 4);
   static int anInt1652;
   static int anInt1653;
   static int anInt1654;
   static int anInt1655;
   private Class61 aClass61_1656 = new Class61(64);
   static int anInt1657;
   static OutgoingPacket aClass318_1658 = new OutgoingPacket(45, 7);
   static int anInt1659;
   static OutgoingPacket aClass318_1660 = new OutgoingPacket(75, 4);

   final void method1543(int i, int i_0_) {
      synchronized(this.aClass61_1656) {
         this.aClass61_1656.method608(false);
         this.aClass61_1656 = new Class61(i_0_);
         if (i != 16509) {
            aClass318_1660 = null;
         }
      }

      ++anInt1649;
   }

   static final void method1544(int localY, int type, int rotation, int localX, int animationId, int typeFlag, int plane, int junk, int objectId) {
      ++anInt1653;
      if (localX > 1 && localY >= 1 && ~(-2 + Node_Sub54.GAME_SCENE_WDITH) <= ~localX && ~(-2 + Class377_Sub1.GAME_SCENE_HEIGHT) <= ~localY) {
         if (Class213.aNode_Sub27_2512.aClass320_Sub19_7301.method3751(false) == 0 && !Class369.method4085(localY, 0, Class94.anInt1249, localX, plane)
            || Class175.aClass261ArrayArrayArray2099 == null) {
            return;
         }

         Node_Sub38_Sub1.aClass277_Sub1_Map
            .method3359(typeFlag, (byte)102, localY, Class304.SCENE_CLIP_DATA_PLANES[plane], plane, localX, Class93.aGraphicsToolkit1241);
         if (objectId >= 0) {
            int i_10_ = Class213.aNode_Sub27_2512.aClass320_Sub6_7267.method3701(false);
            Class213.aNode_Sub27_2512.method2690(108, 1, Class213.aNode_Sub27_2512.aClass320_Sub6_7267);
            Node_Sub38_Sub1.aClass277_Sub1_Map
               .drawWorldObject(
                  type,
                  objectId,
                  Class304.SCENE_CLIP_DATA_PLANES[plane],
                  localY,
                  Class93.aGraphicsToolkit1241,
                  localX,
                  rotation,
                  -102,
                  plane,
                  plane,
                  animationId
               );
            Class213.aNode_Sub27_2512.method2690(33, i_10_, Class213.aNode_Sub27_2512.aClass320_Sub6_7267);
         }
      }
   }

   public static void method1545(boolean bool) {
      aClass318_1660 = null;
      aClass318_1651 = null;
      if (!bool) {
         method1545(true);
      }

      aClass318_1658 = null;
   }

   final void method1546(int i) {
      synchronized(this.aClass61_1656) {
         this.aClass61_1656.method602((byte)-128);
      }

      ++anInt1652;
   }

   static final boolean method1547(int i, int i_13_, int i_14_) {
      ++anInt1657;
      if (i_14_ == 11) {
         i_14_ = 10;
      }

      if (i_13_ != 1) {
         return true;
      } else {
         ObjectDefinition objectdefinition = Class186.aClass112_2256.getObjectDefinitionsForId(i, 61);
         if (~i_14_ <= -6 && ~i_14_ >= -9) {
            i_14_ = 4;
         }

         return objectdefinition.method3041(i_14_, 31);
      }
   }

   static final Class262 method1548(Buffer buffer, byte b) {
      ++anInt1647;
      int i = buffer.readUnsignedByte();
      Class124 class124 = Node_Sub38_Sub24.method2869(i, -96);
      Class262 class262 = null;
      if (Class194_Sub1_Sub1.aClass124_9368 != class124) {
         if (EntityNode_Sub8.aClass124_6024 != class124) {
            if (Node_Sub16.aClass124_7132 != class124) {
               if (class124 != Class262_Sub21.aClass124_7865) {
                  if (Class233.aClass124_2784 != class124) {
                     if (Class320_Sub6.aClass124_8267 != class124) {
                        if (class124 != Animable_Sub3.aClass124_9141) {
                           if (class124 != Class262_Sub6.aClass124_7745) {
                              if (class124 != Class320_Sub5.aClass124_8253) {
                                 if (class124 != Class144_Sub4.aClass124_6846) {
                                    if (Class155.aClass124_1955 != class124) {
                                       if (class124 != CacheNode_Sub16_Sub1.aClass124_11076) {
                                          if (Class144_Sub4.aClass124_6838 != class124) {
                                             if (class124 != CacheNode_Sub4.aClass124_9463) {
                                                if (Class188.aClass124_2291 != class124) {
                                                   if (class124 != Class10.aClass124_169) {
                                                      if (class124 != Node_Sub25_Sub2.aClass124_9957) {
                                                         if (class124 != Class274.aClass124_4975) {
                                                            if (Class127.aClass124_1638 != class124) {
                                                               if (Animable_Sub3.aClass124_9135 != class124) {
                                                                  if (Node_Sub38_Sub23.aClass124_10344 != class124) {
                                                                     if (class124 != Class260.aClass124_5230) {
                                                                        if (class124 != Class64.aClass124_5036) {
                                                                           if (class124 != OutputStream_Sub1.aClass124_88) {
                                                                              if (AnimableAnimator.aClass124_5500 != class124) {
                                                                                 if (Class362.aClass124_4494 != class124) {
                                                                                    if (Class262_Sub12.aClass124_7785 != class124) {
                                                                                       if (class124 == Node_Sub15_Sub4.aClass124_9793) {
                                                                                          class262 = new Class262_Sub22(buffer);
                                                                                       }
                                                                                    } else {
                                                                                       class262 = new Class262_Sub7(buffer);
                                                                                    }
                                                                                 } else {
                                                                                    class262 = new Class262_Sub19(buffer, true);
                                                                                 }
                                                                              } else {
                                                                                 class262 = new Class262_Sub19(buffer, false);
                                                                              }
                                                                           } else {
                                                                              class262 = new Class262_Sub23(buffer, 1, 0);
                                                                           }
                                                                        } else {
                                                                           class262 = new Class262_Sub23(buffer, 0, 0);
                                                                        }
                                                                     } else {
                                                                        class262 = new Class262_Sub23(buffer, 0, 1);
                                                                     }
                                                                  } else {
                                                                     class262 = new Class262_Sub23(buffer, 1, 1);
                                                                  }
                                                               } else {
                                                                  class262 = new Class262_Sub15_Sub2(buffer);
                                                               }
                                                            } else {
                                                               class262 = new Class262_Sub11(buffer);
                                                            }
                                                         } else {
                                                            class262 = new Class262_Sub9(buffer);
                                                         }
                                                      } else {
                                                         class262 = new Class262_Sub17(buffer);
                                                      }
                                                   } else {
                                                      class262 = new Class262_Sub1(buffer);
                                                   }
                                                } else {
                                                   class262 = new Class262_Sub21(buffer);
                                                }
                                             } else {
                                                class262 = new Class262_Sub20(buffer);
                                             }
                                          } else {
                                             class262 = new Class262_Sub3(buffer);
                                          }
                                       } else {
                                          class262 = new Class262_Sub10(buffer);
                                       }
                                    } else {
                                       class262 = new Class262_Sub18(buffer);
                                    }
                                 } else {
                                    class262 = new Class262_Sub4(buffer);
                                 }
                              } else {
                                 class262 = new Class262_Sub5(buffer);
                              }
                           } else {
                              class262 = new Class262_Sub15_Sub1(buffer);
                           }
                        } else {
                           class262 = new Class262_Sub14(buffer);
                        }
                     } else {
                        class262 = new Class262_Sub8(buffer);
                     }
                  } else {
                     class262 = new Class262_Sub13(buffer);
                  }
               } else {
                  class262 = new Class262_Sub12(buffer);
               }
            } else {
               class262 = new Class262_Sub6(buffer);
            }
         } else {
            class262 = new Class262_Sub2(buffer);
         }
      } else {
         class262 = new Class262_Sub16(buffer);
      }

      return class262;
   }

   final ConfigDefinitions getConfigDefinitions(int i) {
      ++anInt1655;
      ConfigDefinitions class70;
      synchronized(this.aClass61_1656) {
         class70 = (ConfigDefinitions)this.aClass61_1656.method607((long)i, 0);
      }

      if (class70 != null) {
         return class70;
      } else {
         byte[] bs;
         synchronized(this.index22) {
            bs = this.index22.getFile(false, Class169.method1762((byte)114, i), Class273.method3315(-989325398, i));
         }

         class70 = new ConfigDefinitions();
         if (bs != null) {
            class70.method737(122, new Buffer(bs));
         }

         synchronized(this.aClass61_1656) {
            this.aClass61_1656.method601(class70, 25566, (long)i);
            return class70;
         }
      }
   }

   static final int method1550(int i, int i_18_, int i_19_) {
      if (i != -13892) {
         return 98;
      } else {
         ++anInt1654;
         int i_20_ = i_19_ >>> 31;
         return -i_20_ + (i_20_ + i_19_) / i_18_;
      }
   }

   final void method1551(int i, int i_21_) {
      synchronized(this.aClass61_1656) {
         if (i != 75) {
            aClass318_1651 = null;
         }

         this.aClass61_1656.method598(i_21_, i ^ -11874);
      }

      ++anInt1659;
   }

   final void method1552(byte b) {
      ++anInt1648;
      synchronized(this.aClass61_1656) {
         this.aClass61_1656.method608(false);
         if (b != 101) {
            this.method1552((byte)-56);
         }
      }
   }

   Class128(Class353 class353, int i, Index class302) {
      this.index22 = class302;
      if (this.index22 != null) {
         int i_22_ = this.index22.method3526(-20871) - 1;
         this.index22.method3537(-2, i_22_);
      }
   }
}
