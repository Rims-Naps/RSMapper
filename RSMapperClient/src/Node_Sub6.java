public class Node_Sub6 extends Node {
   static int anInt7042;
   static int anInt7043;
   protected short[] aShortArray7044;
   protected Class240[] aClass240Array7045;
   protected byte[] aByteArray7046;
   static IComponentDefinitions aWidget7047 = null;
   static int anInt7048;
   protected Node_Sub45_Sub1[] aNode_Sub45_Sub1Array7049;
   static Object anObject7050;
   static int anInt7051;
   protected int anInt7052;
   static int anInt7053;
   protected byte[] aByteArray7054;
   private int[] anIntArray7055;
   static int anInt7056 = 0;
   protected byte[] aByteArray7057;
   static int anInt7058;
   static int anInt7059;

   public static void method2414(int i) {
      anObject7050 = null;
      aWidget7047 = null;
      if (i != 1) {
         method2414(-100);
      }
   }

   final void method2415(int i) {
      this.anIntArray7055 = null;
      if (i < -108) {
         ++anInt7053;
      }
   }

   static final void method2416(
      int i, int i_0_, IComponentDefinitions[] widgets, int i_1_, int i_2_, int i_3_, int i_4_, boolean bool, int i_5_, int i_6_, int i_7_
   ) {
      ++anInt7048;
      Class93.aGraphicsToolkit1241.KA(i_1_, i_2_, i_6_, i_3_);

      for(int i_8_ = 0; ~widgets.length < ~i_8_; ++i_8_) {
         IComponentDefinitions widget = widgets[i_8_];
         if (widget != null && (i == widget.parentId || ~i == 1412584498 && Class58.aWidget861 == widget)) {
            int i_9_ = widget.positionX - -i_0_;
            int i_10_ = i_7_ + widget.positionY;
            int i_11_ = 1 + widget.width + i_9_;
            int i_12_ = 1 + i_10_ - -widget.height;
            int i_13_;
            if (i_4_ != -1) {
               i_13_ = i_4_;
            } else {
               Node_Sub38_Sub28.aRectangleArray10404[Node_Sub11.anInt7105]
                  .setBounds(widget.positionX + i_0_, i_7_ + widget.positionY, widget.width, widget.height);
               i_13_ = Node_Sub11.anInt7105++;
            }

            widget.anInt4703 = i_13_;
            widget.anInt4824 = Class174.clientCycle;
            if (!Client.method112(widget)) {
               if (~widget.anInt4814 != -1) {
                  Class194_Sub3.method1978(false, widget);
               }

               int positionX = i_0_ + widget.positionX;
               int positionY = i_7_ + widget.positionY;
               int i_16_ = 0;
               int i_17_ = 0;
               if (Class71.aBoolean967) {
                  i_16_ = Class67.method733(-124);
                  i_17_ = Class226.method2112(256);
               }

               int transparency = widget.transparency;
               if (Class54.aBoolean817 && (~Client.method113(widget).settingsHash != -1 || widget.type == 0) && transparency > 127) {
                  transparency = 127;
               }

               if (Class58.aWidget861 == widget) {
                  if (i != -1412584499 && (~Class188_Sub1.anInt6864 == ~widget.anInt4860 || Class339_Sub4.anInt8679 == widget.anInt4860)) {
                     CacheNode_Sub7.anInt9488 = i_7_;
                     UnderlayDefinition.aWidgetArray2899 = widgets;
                     Class118.anInt5410 = i_0_;
                     continue;
                  }

                  if (Class99.aBoolean1282 && Class180.aBoolean2135) {
                     int i_19_ = i_16_ + Class106.aClass93_1356.getLastMousePosX();
                     int i_20_ = i_17_ + Class106.aClass93_1356.getLastMousePosY(true);
                     i_20_ -= Class83.anInt5179;
                     i_19_ -= Node_Sub5_Sub2.anInt9412;
                     if (Class62.anInt905 > i_19_) {
                        i_19_ = Class62.anInt905;
                     }

                     if (~i_20_ > ~Class339_Sub2.anInt8650) {
                        i_20_ = Class339_Sub2.anInt8650;
                     }

                     if (~(Class62.anInt905 + Class186.aWidget2257.width) > ~(i_19_ - -widget.width)) {
                        i_19_ = Class62.anInt905 - -Class186.aWidget2257.width + -widget.width;
                     }

                     positionX = i_19_;
                     if (~(Class339_Sub2.anInt8650 - -Class186.aWidget2257.height) > ~(i_20_ + widget.height)) {
                        i_20_ = Class339_Sub2.anInt8650 - (-Class186.aWidget2257.height - -widget.height);
                     }

                     positionY = i_20_;
                  }

                  if (~widget.anInt4860 == ~Class339_Sub4.anInt8679) {
                     transparency = 128;
                  }
               }

               int i_23_;
               int i_24_;
               int i_21_;
               int i_22_;
               if (widget.type != 2) {
                  int i_25_ = positionX + widget.width;
                  int i_26_ = positionY - -widget.height;
                  if (widget.type == 9) {
                     ++i_26_;
                     ++i_25_;
                  }

                  i_23_ = i_2_ >= positionY ? i_2_ : positionY;
                  i_21_ = positionX > i_1_ ? positionX : i_1_;
                  i_24_ = ~i_6_ >= ~i_25_ ? i_6_ : i_25_;
                  i_22_ = ~i_26_ > ~i_3_ ? i_26_ : i_3_;
               } else {
                  i_21_ = i_1_;
                  i_22_ = i_3_;
                  i_23_ = i_2_;
                  i_24_ = i_6_;
               }

               if (i_24_ > i_21_ && ~i_23_ > ~i_22_) {
                  if (~widget.anInt4814 != -1) {
                     if (~widget.anInt4814 == ~Class200_Sub1.anInt5146 || widget.anInt4814 == Class107.anInt1366) {
                        Class243.method3059(positionY, (byte)29, positionX, widget);
                        if (!Class71.aBoolean967) {
                           Class157.method1710(-120, positionY, widget.anInt4814 == Class107.anInt1366, widget.width, widget.height, positionX);
                           Class93.aGraphicsToolkit1241.KA(i_1_, i_2_, i_6_, i_3_);
                        }

                        Class195.aBooleanArray2387[i_13_] = true;
                        continue;
                     }

                     if (widget.anInt4814 == Class264.minimapId && ~aa.anInt101 == -1) {
                        if (widget.method4145(Class93.aGraphicsToolkit1241, 1) != null) {
                           CacheNode_Sub16_Sub1.method2387((byte)-114);
                           DrawMiniMapSprites.updateAndDrawMinimapMarkers(positionY, Class93.aGraphicsToolkit1241, 128, widget, positionX);
                           Class320_Sub21.aBooleanArray8403[i_13_] = true;
                           Class93.aGraphicsToolkit1241.KA(i_1_, i_2_, i_6_, i_3_);
                           if (Class71.aBoolean967) {
                              if (bool) {
                                 Class362.method4053(i_10_, i_12_, i_9_, (byte)55, i_11_);
                              } else {
                                 Node_Sub38_Sub27.method2881(i_10_, (byte)112, i_11_, i_12_, i_9_);
                              }
                           }
                        }
                        continue;
                     }

                     if (~widget.anInt4814 == ~Class82.anInt1121) {
                        Node_Sub15_Sub4.method2567(widget, positionX, (byte)-96, positionY, Class93.aGraphicsToolkit1241);
                        continue;
                     }

                     if (~widget.anInt4814 == ~Class180.anInt2136) {
                        Class210.method2049(Class93.aGraphicsToolkit1241, widget.color % 64, (byte)120, widget, positionX, positionY);
                        continue;
                     }

                     if (~widget.anInt4814 == ~Class114.compassId) {
                        if (widget.method4145(Class93.aGraphicsToolkit1241, 1) != null) {
                           Class349.updateCompass(widget, positionX, 1, positionY);
                           Class320_Sub21.aBooleanArray8403[i_13_] = true;
                           Class93.aGraphicsToolkit1241.KA(i_1_, i_2_, i_6_, i_3_);
                           if (Class71.aBoolean967) {
                              if (!bool) {
                                 Node_Sub38_Sub27.method2881(i_10_, (byte)112, i_11_, i_12_, i_9_);
                              } else {
                                 Class362.method4053(i_10_, i_12_, i_9_, (byte)-86, i_11_);
                              }
                           }
                        }
                        continue;
                     }

                     if (~widget.anInt4814 == ~Node_Sub38_Sub4.worldmapId) {
                        Animable_Sub1_Sub1.worldmapLoader(
                           -28557, widget.height, positionX, positionY, TemporaryItemDefinition.aD565, Class93.aGraphicsToolkit1241, widget.width
                        );
                        Class195.aBooleanArray2387[i_13_] = false;
                        Class93.aGraphicsToolkit1241.KA(i_1_, i_2_, i_6_, i_3_);
                        continue;
                     }

                     if (widget.anInt4814 == Class77.anInt1017) {
                        Node_Sub40.method2926((byte)-100, widget.width, Class93.aGraphicsToolkit1241, widget.height, positionX, positionY);
                        Class195.aBooleanArray2387[i_13_] = true;
                        Class93.aGraphicsToolkit1241.KA(i_1_, i_2_, i_6_, i_3_);
                        continue;
                     }

                     if (widget.anInt4814 == AnimableAnimator_Sub1.anInt9093) {
                        if (!Node_Sub15_Sub2.aBoolean9780 && !Class186.aBoolean2259) {
                           continue;
                        }

                        int i_27_ = positionX + widget.width;
                        int i_28_ = positionY + 15;
                        if (Class71.aBoolean967) {
                           if (!bool) {
                              Node_Sub38_Sub27.method2881(i_10_, (byte)112, i_11_, i_12_, i_9_);
                           } else {
                              Class362.method4053(i_10_, i_12_, i_9_, (byte)76, i_11_);
                           }
                        }

                        if (Node_Sub15_Sub2.aBoolean9780) {
                           int i_29_ = -256;
                           if (Node_Sub9_Sub4.anInt9732 < 20) {
                              i_29_ = -65536;
                           }

                           StandardSprite.aClass52_8945.method543((byte)-108, i_27_, "Fps:" + Node_Sub9_Sub4.anInt9732, i_29_, -1, i_28_);
                           i_28_ += 15;
                           Runtime runtime = Runtime.getRuntime();
                           int i_30_ = (int)((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
                           int i_31_ = -256;
                           if (~i_30_ < -98305) {
                              if (Class252.aBoolean3188) {
                                 Class355.method4021(80);

                                 for(int i_32_ = 0; i_32_ < 10; ++i_32_) {
                                    System.gc();
                                 }

                                 i_30_ = (int)((runtime.totalMemory() - runtime.freeMemory()) / 1024L);
                                 if (~i_30_ < -65537) {
                                    Node_Sub7.writeToConsole((byte)43, "WARNING: Memory usage over 64MB! (" + i_30_ + ")");
                                    System.err.println("WARNING: Memory usage over 64MB! (" + i_30_ + ")");
                                    Class41.method436(29459, "WARNING: Memory usage over 64MB! (" + i_30_ + ")", 4);
                                 }
                              }

                              i_31_ = -65536;
                           }

                           StandardSprite.aClass52_8945.method543((byte)-108, i_27_, "Mem:" + i_30_ + "k", i_31_, -1, i_28_);
                           i_28_ += 15;
                           StandardSprite.aClass52_8945
                              .method543(
                                 (byte)-14,
                                 i_27_,
                                 "Game: In:" + Class218.aClass123_2566.anInt1577 + "B/s Out:" + Class218.aClass123_2566.anInt1572 + "B/s",
                                 -256,
                                 -1,
                                 i_28_
                              );
                           i_28_ += 15;
                           StandardSprite.aClass52_8945
                              .method543(
                                 (byte)116,
                                 i_27_,
                                 "Lobby: In:" + Class218.aClass123_2560.anInt1577 + "B/s Out:" + Class218.aClass123_2560.anInt1572 + "B/s",
                                 -256,
                                 -1,
                                 i_28_
                              );
                           i_28_ += 15;
                           int i_33_ = Class93.aGraphicsToolkit1241.E() / 1024;
                           StandardSprite.aClass52_8945.method543((byte)-115, i_27_, "Offheap:" + i_33_ + "k", i_33_ > 65536 ? -65536 : -256, -1, i_28_);
                           i_28_ += 15;
                           int i_34_ = 0;
                           int i_35_ = 0;
                           int i_36_ = 0;

                           for(int i_37_ = 0; i_37_ < GraphicsToolkit.aClass34_Sub1Array1547.length; ++i_37_) {
                              if (GraphicsToolkit.aClass34_Sub1Array1547[i_37_] != null) {
                                 i_34_ += GraphicsToolkit.aClass34_Sub1Array1547[i_37_].method377(-68);
                                 i_35_ += GraphicsToolkit.aClass34_Sub1Array1547[i_37_].method381((byte)29);
                                 i_36_ += GraphicsToolkit.aClass34_Sub1Array1547[i_37_].method379(0);
                              }
                           }

                           int i_38_ = 100 * i_36_ / i_34_;
                           int i_39_ = i_35_ * 10000 / i_34_;
                           String string = "Cache:" + Class301.method3503(0, true, (long)i_39_, 2, true) + "% (" + i_38_ + "%)";
                           CacheNode_Sub18.aClass52_9609.method543((byte)121, i_27_, string, -256, -1, i_28_);
                           i_28_ += 12;
                        }

                        if (Class280.anInt3570 > 0) {
                           CacheNode_Sub18.aClass52_9609
                              .method543((byte)81, i_27_, "Particles: " + za_Sub2.anInt10514 + " / " + Class280.anInt3570, -256, -1, i_28_);
                        }

                        i_28_ += 12;
                        if (Class186.aBoolean2259) {
                           CacheNode_Sub18.aClass52_9609
                              .method543(
                                 (byte)117,
                                 i_27_,
                                 "Polys: " + Class93.aGraphicsToolkit1241.I() + " Models: " + Class93.aGraphicsToolkit1241.M(),
                                 -256,
                                 -1,
                                 i_28_
                              );
                           i_28_ += 12;
                           CacheNode_Sub18.aClass52_9609
                              .method543(
                                 (byte)-109,
                                 i_27_,
                                 "Ls: "
                                    + Class365_Sub1.anInt8769
                                    + " La: "
                                    + Class304.anInt3835
                                    + " NPC: "
                                    + Class258.anInt5291
                                    + " Pl: "
                                    + OutgoingPacketBuffer.anInt7107,
                                 -256,
                                 -1,
                                 i_28_
                              );
                           Class64.method712(25053);
                           i_28_ += 12;
                        }

                        Class195.aBooleanArray2387[i_13_] = true;
                        continue;
                     }
                  }

                  if (widget.type == 0) {
                     if (~widget.anInt4814 == ~Class193.anInt2368 && Class93.aGraphicsToolkit1241.w()) {
                        Class93.aGraphicsToolkit1241.a(positionX, positionY, widget.width, widget.height);
                     }

                     method2416(widget.ihash, positionX + -widget.scrollX, widgets, i_21_, i_23_, i_22_, i_13_, bool, -99, i_24_, positionY + -widget.scrollY);
                     if (widget.aWidgetArray4793 != null) {
                        method2416(
                           widget.ihash,
                           positionX + -widget.scrollX,
                           widget.aWidgetArray4793,
                           i_21_,
                           i_23_,
                           i_22_,
                           i_13_,
                           bool,
                           -87,
                           i_24_,
                           -widget.scrollY + positionY
                        );
                     }

                     Node_Sub2 node_sub2 = (Node_Sub2)OverlayDefinition.aHashTable3630.get(3512, (long)widget.ihash);
                     if (node_sub2 != null) {
                        Class282.method3385(node_sub2.interfaceId, i_21_, i_24_, i_23_, positionY, i_13_, positionX, true, i_22_);
                     }

                     if (~widget.anInt4814 == ~Class193.anInt2368) {
                        if (Class93.aGraphicsToolkit1241.w()) {
                           Class93.aGraphicsToolkit1241.d();
                        }

                        if (aa.anInt101 == 3) {
                           int i_40_ = Canvas.anInt69;
                           int i_41_ = GLDrawableModel.anInt5703;
                           int i_42_ = Class105.anInt5204;
                           int i_43_ = Animable_Sub4.anInt9153;
                           if (~Class174.clientCycle > ~Class1.anInt115) {
                              float f = (float)(Class174.clientCycle + -Class60.anInt881) / (float)(Class1.anInt115 + -Class60.anInt881);
                              i_41_ = (int)((float)Class308.anInt3913 * (-f + 1.0F) + f * (float)GLDrawableModel.anInt5703);
                              i_42_ = (int)(f * (float)Class105.anInt5204 + (float)ReferenceTable.anInt302 * (-f + 1.0F));
                              i_40_ = (int)(f * (float)Canvas.anInt69 + (1.0F - f) * (float)Class170.anInt2055);
                              i_43_ = (int)(f * (float)Animable_Sub4.anInt9153 + (1.0F - f) * (float)Buffer.anInt7023);
                           }

                           if (i_40_ > 0) {
                              Class93.aGraphicsToolkit1241
                                 .method1239(-i_21_ + i_24_, -i_23_ + i_22_, i_23_, (byte)116, i_21_, i_41_ << 16 | i_40_ << 24 | i_42_ << 8 | i_43_);
                           }
                        }
                     }

                     Class93.aGraphicsToolkit1241.KA(i_1_, i_2_, i_6_, i_3_);
                  }

                  if (Class190.aBooleanArray2326[i_13_] || Class12.anInt193 > 1) {
                     if (widget.type == 3) {
                        if (transparency == 0) {
                           if (!widget.filled) {
                              Class93.aGraphicsToolkit1241.d(positionX, positionY, widget.width, widget.height, widget.color, 0);
                           } else {
                              Class93.aGraphicsToolkit1241.aa(positionX, positionY, widget.width, widget.height, widget.color, 0);
                           }
                        } else if (!widget.filled) {
                           Class93.aGraphicsToolkit1241
                              .d(positionX, positionY, widget.width, widget.height, -(transparency & 0xFF) + 255 << 24 | widget.color & 16777215, 1);
                        } else {
                           Class93.aGraphicsToolkit1241
                              .aa(positionX, positionY, widget.width, widget.height, -(transparency & 0xFF) + 255 << 24 | widget.color & 16777215, 1);
                        }

                        if (Class71.aBoolean967) {
                           if (!bool) {
                              Node_Sub38_Sub27.method2881(i_10_, (byte)112, i_11_, i_12_, i_9_);
                           } else {
                              Class362.method4053(i_10_, i_12_, i_9_, (byte)-33, i_11_);
                           }
                        }
                     } else if (widget.type == 4) {
                        Class52 class52 = widget.method4155(true, Class93.aGraphicsToolkit1241);
                        if (class52 != null) {
                           int i_44_ = widget.color;
                           String string = widget.text;
                           if (widget.itemId != -1) {
                              ItemDefinitions itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(widget.itemId);
                              string = itemdefinition.name;
                              if (string == null) {
                                 string = "null";
                              }

                              if ((itemdefinition.stackable == 1 || widget.itemAmount != 1) && widget.itemAmount != -1) {
                                 string = "<col=ff9040>" + string + "</col> x" + Class191.method1947(3, widget.itemAmount);
                              }
                           }

                           if (widget.anInt4694 != -1) {
                              string = Class77.method773(225, widget.anInt4694);
                              if (string == null) {
                                 string = "";
                              }
                           }

                           if (widget == Node_Sub25_Sub3.aWidget9990) {
                              string = Class22.aClass22_394.getStoredString(Class35.language);
                              i_44_ = widget.color;
                           }

                           if (Class204.aBoolean2454) {
                              Class93.aGraphicsToolkit1241.T(positionX, positionY, positionX + widget.width, widget.height + positionY);
                           }

                           class52.method539(
                              widget.textAlignY,
                              2,
                              i_44_ | -(transparency & 0xFF) + 255 << 24,
                              widget.aBoolean4710 ? -(0xFF & transparency) + 255 << 24 : -1,
                              Node_Sub52.aGLSpriteArray7655,
                              widget.anInt4767,
                              0,
                              positionY,
                              widget.height,
                              0,
                              null,
                              widget.anInt4697,
                              widget.width,
                              positionX,
                              widget.textAlignX,
                              null,
                              string
                           );
                           if (Class204.aBoolean2454) {
                              Class93.aGraphicsToolkit1241.KA(i_1_, i_2_, i_6_, i_3_);
                           }

                           if (~string.trim().length() < -1) {
                              if (Class204.aBoolean2454) {
                                 if (Class71.aBoolean967) {
                                    if (!bool) {
                                       Node_Sub38_Sub27.method2881(i_10_, (byte)112, i_11_, i_12_, i_9_);
                                    } else {
                                       Class362.method4053(i_10_, i_12_, i_9_, (byte)-111, i_11_);
                                    }
                                 }
                              } else {
                                 Class357 class357 = Class150_Sub2.method1660((byte)-30, widget.fontId, Class93.aGraphicsToolkit1241);
                                 int i_45_ = class357.method4030(Node_Sub52.aGLSpriteArray7655, 0, string, widget.width);
                                 int i_46_ = class357.method4034(widget.width, widget.anInt4697, string, Node_Sub52.aGLSpriteArray7655, (byte)-65);
                                 if (Class71.aBoolean967) {
                                    if (bool) {
                                       Class362.method4053(positionY, positionY + i_46_, positionX, (byte)-71, positionX - -i_45_);
                                    } else {
                                       Node_Sub38_Sub27.method2881(positionY, (byte)112, positionX + i_45_, i_46_ + positionY, positionX);
                                    }
                                 }
                              }
                           }
                        } else if (Class287.aBoolean3606) {
                           ClientScript.method2321(-1, widget);
                        }
                     } else if (widget.type == 5) {
                        if (widget.anInt4848 < 0) {
                           GLSprite glsprite;
                           if (~widget.itemId == 0) {
                              if (~widget.anInt4694 != 0) {
                                 glsprite = Class352.method4008((byte)125, widget.anInt4694, Class93.aGraphicsToolkit1241);
                              } else {
                                 glsprite = widget.method4135(true, Class93.aGraphicsToolkit1241);
                              }
                           } else {
                              PlayerDefinition playerdefinition = widget.aBoolean4723 ? Class295.myPlayer.aPlayerDefinition11137 : null;
                              glsprite = EntityNode_Sub3_Sub1.aClass86_9166
                                 .method1007(
                                    playerdefinition,
                                    (byte)30,
                                    Class93.aGraphicsToolkit1241,
                                    widget.anInt4714,
                                    widget.itemId,
                                    widget.anInt4744,
                                    widget.itemAmount,
                                    0xFF000000 | widget.anInt4796
                                 );
                           }

                           if (glsprite == null) {
                              if (Class287.aBoolean3606) {
                                 ClientScript.method2321(-1, widget);
                              }
                           } else {
                              int i_47_ = glsprite.method1197();
                              int i_48_ = glsprite.method1186();
                              int i_49_ = 255 + -(0xFF & transparency) << 24 | (widget.color != 0 ? widget.color & 16777215 : 16777215);
                              if (widget.repeatTiling) {
                                 Class93.aGraphicsToolkit1241.T(positionX, positionY, positionX - -widget.width, positionY - -widget.height);
                                 if (widget.angle2D == 0) {
                                    if (~widget.color == -1 && transparency == 0) {
                                       glsprite.method1192(positionX, positionY, widget.width, widget.height);
                                    } else {
                                       glsprite.method1183(positionX, positionY, widget.width, widget.height, 0, i_49_, 1);
                                    }
                                 } else {
                                    int i_50_ = (widget.width + i_47_ - 1) / i_47_;
                                    int i_51_ = (-1 - (-i_48_ - widget.height)) / i_48_;

                                    for(int i_52_ = 0; ~i_50_ < ~i_52_; ++i_52_) {
                                       for(int i_53_ = 0; ~i_53_ > ~i_51_; ++i_53_) {
                                          if (~widget.color != -1) {
                                             glsprite.method1181(
                                                (float)(i_52_ * i_47_ + positionX) + (float)i_47_ / 2.0F,
                                                (float)i_48_ / 2.0F + (float)(i_53_ * i_48_ + positionY),
                                                4096,
                                                widget.angle2D,
                                                0,
                                                i_49_,
                                                1
                                             );
                                          } else {
                                             glsprite.method1180(
                                                (float)(i_52_ * i_47_ + positionX) + (float)i_47_ / 2.0F,
                                                (float)(positionY + i_48_ * i_53_) + (float)i_48_ / 2.0F,
                                                4096,
                                                widget.angle2D
                                             );
                                          }
                                       }
                                    }
                                 }

                                 Class93.aGraphicsToolkit1241.KA(i_1_, i_2_, i_6_, i_3_);
                              } else if (~widget.color != -1 || transparency != 0) {
                                 if (~widget.angle2D == -1) {
                                    if (~i_47_ == ~widget.width && widget.height == i_48_) {
                                       glsprite.method1191(positionX, positionY, 0, i_49_, 1);
                                    } else {
                                       glsprite.method1199(positionX, positionY, widget.width, widget.height, 0, i_49_, 1);
                                    }
                                 } else {
                                    glsprite.method1181(
                                       (float)widget.width / 2.0F + (float)positionX,
                                       (float)widget.height / 2.0F + (float)positionY,
                                       widget.width * 4096 / i_47_,
                                       widget.angle2D,
                                       0,
                                       i_49_,
                                       1
                                    );
                                 }
                              } else if (widget.angle2D != 0) {
                                 glsprite.method1180(
                                    (float)widget.width / 2.0F + (float)positionX,
                                    (float)positionY + (float)widget.height / 2.0F,
                                    widget.width * 4096 / i_47_,
                                    widget.angle2D
                                 );
                              } else if (~i_47_ == ~widget.width && widget.height == i_48_) {
                                 glsprite.method1196(positionX, positionY);
                              } else {
                                 glsprite.method1200(positionX, positionY, widget.width, widget.height);
                              }
                           }
                        } else {
                           widget.method4157(-49253408, CacheNode_Sub6.aClass57_9480, Class171.aClass278_2062)
                              .method1219(
                                 0,
                                 63,
                                 Class93.aGraphicsToolkit1241,
                                 positionY,
                                 0,
                                 positionX,
                                 widget.width,
                                 0,
                                 widget.anInt4826 << 3,
                                 widget.anInt4764 << 3,
                                 widget.height
                              );
                        }

                        if (Class71.aBoolean967) {
                           if (!bool) {
                              Node_Sub38_Sub27.method2881(i_10_, (byte)112, i_11_, i_12_, i_9_);
                           } else {
                              Class362.method4053(i_10_, i_12_, i_9_, (byte)120, i_11_);
                           }
                        }
                     } else if (widget.type == 6) {
                        Class55.method562((byte)18);
                        Class361 class361 = null;
                        DrawableModel drawablemodel = null;
                        int i_54_ = 0;
                        if (widget.itemId == -1) {
                           if (widget.modelType == 5) {
                              int playerIndex = widget.modelId;
                              Player player = playerIndex >= 0 && playerIndex < 2048 ? Class270_Sub2.LOCAL_PLAYERS[playerIndex] : null;
                              if (widget.isFullNPCModel
                                 || player == null
                                 || playerIndex != Class166.myPlayerIndex && Class51_Sub1.method522(player.aString11142, (byte)-104) != widget.anInt4683) {
                                 drawablemodel = Class366.aClass279_4526
                                    .getNPCDefinitions(widget.modelId, (byte)107)
                                    .prepareModel(
                                       Class24.aClass275_442,
                                       Class93.aGraphicsToolkit1241,
                                       InputStream_Sub2.aClass281_83,
                                       (byte)50,
                                       widget.anAnimator4755,
                                       0,
                                       null,
                                       class361,
                                       widget.anAnimator4755,
                                       2048,
                                       null
                                    );
                              } else {
                                 drawablemodel = player.aPlayerDefinition11137
                                    .method3279(
                                       EntityNode_Sub3_Sub1.aClass86_9166,
                                       widget.anAnimator4755,
                                       97,
                                       true,
                                       InputStream_Sub2.aClass281_83,
                                       Class18.aClass37_306,
                                       2048,
                                       null,
                                       Class63.aClass363_922,
                                       Class42.aClass181_643,
                                       Class93.aGraphicsToolkit1241,
                                       Class366.aClass279_4526,
                                       null,
                                       0,
                                       null,
                                       Class24.aClass275_442
                                    );
                              }
                           } else if (widget.modelType == 8 || widget.modelType == 9) {
                              Node_Sub16 node_sub16 = Class295.getItemContainer(widget.modelId, (byte)18, false);
                              if (node_sub16 != null) {
                                 drawablemodel = node_sub16.method2588(
                                    widget.anInt4683,
                                    1,
                                    Class93.aGraphicsToolkit1241,
                                    2048,
                                    widget.modelType == 9,
                                    widget.anAnimator4755,
                                    !widget.aBoolean4723 ? null : Class295.myPlayer.aPlayerDefinition11137
                                 );
                              }
                           } else if (widget.modelType == 10) {
                              if (widget.modelObjectType < 23) {
                                 drawablemodel = Class186.aClass112_2256
                                    .getObjectDefinitionsForId(widget.modelId, 46)
                                    .prepareModel(
                                       Class93.aGraphicsToolkit1241,
                                       2048,
                                       null,
                                       (byte)76,
                                       Node_Sub38_Sub13.objectTypeFlags[widget.modelObjectType],
                                       widget.modelObjectType,
                                       true,
                                       0,
                                       0
                                    );
                              }
                           } else if (widget.anAnimator4755 != null && widget.anAnimator4755.method245(-125)) {
                              drawablemodel = widget.method4153(
                                 Class93.aGraphicsToolkit1241,
                                 widget.anAnimator4755,
                                 InputStream_Sub2.aClass281_83,
                                 Class42.aClass181_643,
                                 Class18.aClass37_306,
                                 Class295.myPlayer.aPlayerDefinition11137,
                                 Class24.aClass275_442,
                                 Class366.aClass279_4526,
                                 EntityNode_Sub3_Sub1.aClass86_9166,
                                 2048,
                                 class361
                              );
                              if (drawablemodel == null && Class287.aBoolean3606) {
                                 ClientScript.method2321(-1, widget);
                              }
                           } else {
                              drawablemodel = widget.method4153(
                                 Class93.aGraphicsToolkit1241,
                                 null,
                                 InputStream_Sub2.aClass281_83,
                                 Class42.aClass181_643,
                                 Class18.aClass37_306,
                                 Class295.myPlayer.aPlayerDefinition11137,
                                 Class24.aClass275_442,
                                 Class366.aClass279_4526,
                                 EntityNode_Sub3_Sub1.aClass86_9166,
                                 2048,
                                 class361
                              );
                              if (drawablemodel == null && Class287.aBoolean3606) {
                                 ClientScript.method2321(-1, widget);
                              }
                           }
                        } else {
                           ItemDefinitions itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(widget.itemId);
                           if (itemdefinition != null) {
                              itemdefinition = itemdefinition.method1674(widget.itemAmount, -119);
                              drawablemodel = itemdefinition.method1689(
                                 widget.anAnimator4755,
                                 2048,
                                 widget.aBoolean4723 ? Class295.myPlayer.aPlayerDefinition11137 : null,
                                 1,
                                 Class93.aGraphicsToolkit1241,
                                 100
                              );
                              if (drawablemodel != null) {
                                 i_54_ = -drawablemodel.fa() >> 1;
                              } else {
                                 ClientScript.method2321(-1, widget);
                              }
                           }
                        }

                        if (drawablemodel != null) {
                           int i_56_;
                           if (widget.anInt4800 <= 0) {
                              i_56_ = 512;
                           } else {
                              i_56_ = (widget.width << 9) / widget.anInt4800;
                           }

                           int i_57_;
                           if (widget.anInt4849 <= 0) {
                              i_57_ = 512;
                           } else {
                              i_57_ = (widget.height << 9) / widget.anInt4849;
                           }

                           int i_58_ = widget.width / 2 + positionX;
                           int i_59_ = widget.height / 2 + positionY;
                           if (!widget.isCustomRenderDistance) {
                              i_58_ += widget.model3dAreaX * i_56_ >> 9;
                              i_59_ += widget.model3dAreaY * i_57_ >> 9;
                           }

                           Class290_Sub6.aClass336_8114.method3862();
                           Class93.aGraphicsToolkit1241.a(Class290_Sub6.aClass336_8114);
                           Class93.aGraphicsToolkit1241.DA(i_58_, i_59_, i_56_, i_57_);
                           Class93.aGraphicsToolkit1241.ya();
                           if (widget.renderThrough) {
                              Class93.aGraphicsToolkit1241.C(false);
                           }

                           if (!widget.isCustomRenderDistance) {
                              int i_60_ = Class335.anIntArray4167[widget.modelRotationX << 3] * (widget.modelZoom << 2) >> 14;
                              int i_61_ = Class335.anIntArray4165[widget.modelRotationX << 3] * (widget.modelZoom << 2) >> 14;
                              Node_Sub5.aClass336_7032.method3861(-widget.modelRotationY << 3);
                              Node_Sub5.aClass336_7032.method3856(widget.modelRotationZ + 100 << 3);
                              Node_Sub5.aClass336_7032
                                 .method3863(widget.modelOffsetX << 2, i_54_ + (widget.modelOffsetY << 2) + i_60_, (widget.modelOffsetY << 2) + i_61_);
                              Node_Sub5.aClass336_7032.method3859(widget.modelRotationX << 3);
                              ((Class336_Sub1)Node_Sub5.aClass336_7032).aFloat8521 += 450.0F;
                           } else {
                              Node_Sub5.aClass336_7032.method3865(widget.modelRotationX);
                              Node_Sub5.aClass336_7032.method3856(widget.modelRotationZ);
                              Node_Sub5.aClass336_7032.method3868(widget.modelRotationY);
                              Node_Sub5.aClass336_7032.method3863(widget.model3dAreaX, widget.model3dAreaY, widget.modelRenderDistance);
                           }

                           widget.method4136(Class93.aGraphicsToolkit1241, drawablemodel, 123, Node_Sub5.aClass336_7032, Class174.clientCycle);
                           if (Class204.aBoolean2454) {
                              Class93.aGraphicsToolkit1241.T(positionX, positionY, positionX - -widget.width, widget.height + positionY);
                           }

                           if (!widget.isCustomRenderDistance) {
                              if (widget.isModelOrthographic) {
                                 drawablemodel.method622(Node_Sub5.aClass336_7032, null, widget.modelZoom << 2, 1);
                              } else {
                                 drawablemodel.method611(Node_Sub5.aClass336_7032, null, 1);
                                 if (widget.anEntityNode_Sub4_4726 != null) {
                                    Class93.aGraphicsToolkit1241.a(widget.anEntityNode_Sub4_4726.method959());
                                 }
                              }
                           } else if (!widget.isModelOrthographic) {
                              drawablemodel.method611(Node_Sub5.aClass336_7032, null, 1);
                              if (widget.anEntityNode_Sub4_4726 != null) {
                                 Class93.aGraphicsToolkit1241.a(widget.anEntityNode_Sub4_4726.method959());
                              }
                           } else {
                              drawablemodel.method622(Node_Sub5.aClass336_7032, null, widget.modelZoom, 1);
                           }

                           if (Class204.aBoolean2454) {
                              Class93.aGraphicsToolkit1241.KA(i_1_, i_2_, i_6_, i_3_);
                           }

                           if (widget.renderThrough) {
                              Class93.aGraphicsToolkit1241.C(true);
                           }
                        }

                        if (Class71.aBoolean967) {
                           if (!bool) {
                              Node_Sub38_Sub27.method2881(i_10_, (byte)112, i_11_, i_12_, i_9_);
                           } else {
                              Class362.method4053(i_10_, i_12_, i_9_, (byte)-50, i_11_);
                           }
                        }
                     } else if (widget.type == 9) {
                        int yPoint2;
                        int yPoint1;
                        int xPoint1;
                        int xPoint2;
                        if (!widget.mirrored) {
                           yPoint1 = widget.height + positionY;
                           yPoint2 = positionY;
                           xPoint2 = positionX;
                           xPoint1 = positionX + widget.width;
                        } else {
                           yPoint2 = widget.height + positionY;
                           yPoint1 = positionY;
                           xPoint1 = positionX + widget.width;
                           xPoint2 = positionX;
                        }

                        if (widget.anInt4752 != 1) {
                           Class93.aGraphicsToolkit1241.a(xPoint2, yPoint2, xPoint1, yPoint1, widget.color, widget.anInt4752, 0);
                        } else {
                           Class93.aGraphicsToolkit1241.a(xPoint2, yPoint2, xPoint1, yPoint1, widget.color, 0);
                        }

                        if (Class71.aBoolean967) {
                           if (!bool) {
                              Node_Sub38_Sub27.method2881(i_10_, (byte)112, i_11_, i_12_, i_9_);
                           } else {
                              Class362.method4053(i_10_, i_12_, i_9_, (byte)-32, i_11_);
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   static final void method2417(int i, byte b) {
      if (b != -74) {
         anObject7050 = null;
      }

      ++anInt7042;
      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(b ^ -75, 21, (long)i);
      cachenode_sub2.method2291((byte)121);
   }

   static final boolean method2418(int i, String string) {
      ++anInt7051;
      if (string == null) {
         return false;
      } else if (i != -27891) {
         return true;
      } else {
         for(int i_67_ = 0; ~i_67_ > ~Class235.anInt5122; ++i_67_) {
            if (string.equalsIgnoreCase(Class240.aStringArray2949[i_67_])) {
               return true;
            }

            if (string.equalsIgnoreCase(DrawableModel.aStringArray911[i_67_])) {
               return true;
            }
         }

         return false;
      }
   }

   static final boolean method2419(int i) {
      ++anInt7059;
      boolean bool = true;
      if (Class223.aClass383_2664 == null) {
         if (!Node_Sub38_Sub39.index8.method3510(Class245.anInt3102, (byte)63)) {
            bool = false;
         } else {
            Class223.aClass383_2664 = Class383.method4191(Node_Sub38_Sub39.index8, Class245.anInt3102);
         }
      }

      if (Class336_Sub3.aClass383_8624 == null) {
         if (!Node_Sub38_Sub39.index8.method3510(Class193.anInt2363, (byte)63)) {
            bool = false;
         } else {
            Class336_Sub3.aClass383_8624 = Class383.method4191(Node_Sub38_Sub39.index8, Class193.anInt2363);
         }
      }

      if (Class44.aClass383_667 == null) {
         if (Node_Sub38_Sub39.index8.method3510(Class9.anInt165, (byte)63)) {
            Class44.aClass383_667 = Class383.method4191(Node_Sub38_Sub39.index8, Class9.anInt165);
         } else {
            bool = false;
         }
      }

      if (i < 78) {
         anInt7056 = 72;
      }

      if (CacheNode_Sub2.aClass357_9438 == null) {
         if (AnimableAnimator_Sub1.index13.method3510(Class169_Sub4.anInt8831, (byte)63)) {
            CacheNode_Sub2.aClass357_9438 = Class129.method1553(-1, Class169_Sub4.anInt8831, AnimableAnimator_Sub1.index13);
         } else {
            bool = false;
         }
      }

      if (Class335.aClass383Array4163 == null) {
         if (Node_Sub38_Sub39.index8.method3510(Class169_Sub4.anInt8831, (byte)63)) {
            Class335.aClass383Array4163 = Class383.method4199(Node_Sub38_Sub39.index8, Class169_Sub4.anInt8831);
         } else {
            bool = false;
         }
      }

      return bool;
   }

   final boolean method2420(byte b, Class96 class96, int[] is, byte[] bs) {
      ++anInt7058;
      boolean bool = true;
      int i = 0;
      Node_Sub45_Sub1 node_sub45_sub1 = null;

      for(int i_68_ = 0; ~i_68_ > -129; ++i_68_) {
         if (bs == null || bs[i_68_] != 0) {
            int i_70_ = this.anIntArray7055[i_68_];
            if (~i_70_ != -1) {
               if (~i_70_ != ~i) {
                  i = i_70_--;
                  if ((1 & i_70_) != 0) {
                     node_sub45_sub1 = class96.method1074(is, (byte)-31, i_70_ >> 2);
                  } else {
                     node_sub45_sub1 = class96.method1073(false, is, i_70_ >> 2);
                  }

                  if (node_sub45_sub1 == null) {
                     bool = false;
                  }
               }

               if (node_sub45_sub1 != null) {
                  this.aNode_Sub45_Sub1Array7049[i_68_] = node_sub45_sub1;
                  this.anIntArray7055[i_68_] = 0;
               }
            }
         }
      }

      return bool;
   }

   public Node_Sub6() {
   }

   Node_Sub6(byte[] bs) {
      this.aClass240Array7045 = new Class240[128];
      this.aNode_Sub45_Sub1Array7049 = new Node_Sub45_Sub1[128];
      this.anIntArray7055 = new int[128];
      this.aByteArray7057 = new byte[128];
      this.aByteArray7054 = new byte[128];
      this.aShortArray7044 = new short[128];
      this.aByteArray7046 = new byte[128];
      Buffer buffer = new Buffer(bs);
      int i = 0;

      while(buffer.buffer[i + buffer.offset] != 0) {
         ++i;
      }

      byte[] bs_71_ = new byte[i];

      for(int i_72_ = 0; ~i_72_ > ~i; ++i_72_) {
         bs_71_[i_72_] = buffer.readByte();
      }

      ++i;
      ++buffer.offset;
      int i_73_ = buffer.offset;
      buffer.offset += i;
      int i_74_ = 0;

      while(buffer.buffer[buffer.offset + i_74_] != 0) {
         ++i_74_;
      }

      byte[] bs_75_ = new byte[i_74_];

      for(int i_76_ = 0; ~i_74_ < ~i_76_; ++i_76_) {
         bs_75_[i_76_] = buffer.readByte();
      }

      ++i_74_;
      ++buffer.offset;
      int i_77_ = buffer.offset;
      buffer.offset += i_74_;
      int i_78_ = 0;

      while(~buffer.buffer[i_78_ + buffer.offset] != -1) {
         ++i_78_;
      }

      byte[] bs_79_ = new byte[i_78_];

      for(int i_80_ = 0; i_80_ < i_78_; ++i_80_) {
         bs_79_[i_80_] = buffer.readByte();
      }

      ++buffer.offset;
      byte[] bs_81_ = new byte[++i_78_];
      int i_82_;
      if (~i_78_ < -2) {
         bs_81_[1] = 1;
         i_82_ = 2;
         int i_83_ = 1;

         for(int i_84_ = 2; ~i_84_ > ~i_78_; ++i_84_) {
            int i_85_ = buffer.readUnsignedByte();
            if (~i_85_ == -1) {
               i_83_ = i_82_++;
            } else {
               if (i_85_ <= i_83_) {
                  --i_85_;
               }

               i_83_ = i_85_;
            }

            bs_81_[i_84_] = (byte)i_83_;
         }
      } else {
         i_82_ = i_78_;
      }

      Class240[] class240s = new Class240[i_82_];

      for(int i_86_ = 0; i_86_ < class240s.length; ++i_86_) {
         Class240 class240 = class240s[i_86_] = new Class240();
         int i_87_ = buffer.readUnsignedByte();
         if (i_87_ > 0) {
            class240.aByteArray2944 = new byte[i_87_ * 2];
         }

         i_87_ = buffer.readUnsignedByte();
         if (~i_87_ < -1) {
            class240.aByteArray2942 = new byte[2 + 2 * i_87_];
            class240.aByteArray2942[1] = 64;
         }
      }

      int i_88_ = buffer.readUnsignedByte();
      byte[] bs_89_ = ~i_88_ >= -1 ? null : new byte[2 * i_88_];
      i_88_ = buffer.readUnsignedByte();
      byte[] bs_90_ = ~i_88_ < -1 ? new byte[i_88_ * 2] : null;
      int i_91_ = 0;

      while(~buffer.buffer[i_91_ + buffer.offset] != -1) {
         ++i_91_;
      }

      byte[] bs_92_ = new byte[i_91_];

      for(int i_93_ = 0; i_91_ > i_93_; ++i_93_) {
         bs_92_[i_93_] = buffer.readByte();
      }

      ++i_91_;
      ++buffer.offset;
      int i_94_ = 0;

      for(int i_95_ = 0; i_95_ < 128; ++i_95_) {
         i_94_ += buffer.readUnsignedByte();
         this.aShortArray7044[i_95_] = (short)i_94_;
      }

      i_94_ = 0;

      for(int i_96_ = 0; i_96_ < 128; ++i_96_) {
         i_94_ += buffer.readUnsignedByte();
         this.aShortArray7044[i_96_] = (short)(this.aShortArray7044[i_96_] + (i_94_ << 8));
      }

      int i_97_ = 0;
      int i_98_ = 0;
      int i_99_ = 0;

      for(int i_100_ = 0; i_100_ < 128; ++i_100_) {
         if (~i_97_ == -1) {
            if (bs_92_.length <= i_98_) {
               i_97_ = -1;
            } else {
               i_97_ = bs_92_[i_98_++];
            }

            i_99_ = buffer.method2239(0);
         }

         this.aShortArray7044[i_100_] = (short)(this.aShortArray7044[i_100_] + (Node_Sub30.method2723(-1 + i_99_, 2) << 14));
         this.anIntArray7055[i_100_] = i_99_;
         --i_97_;
      }

      i_98_ = 0;
      i_97_ = 0;
      int i_101_ = 0;

      for(int i_102_ = 0; i_102_ < 128; ++i_102_) {
         if (~this.anIntArray7055[i_102_] != -1) {
            if (~i_97_ == -1) {
               i_101_ = -1 + buffer.buffer[i_73_++];
               if (bs_71_.length > i_98_) {
                  i_97_ = bs_71_[i_98_++];
               } else {
                  i_97_ = -1;
               }
            }

            this.aByteArray7054[i_102_] = (byte)i_101_;
            --i_97_;
         }
      }

      i_98_ = 0;
      i_97_ = 0;
      int i_103_ = 0;

      for(int i_104_ = 0; ~i_104_ > -129; ++i_104_) {
         if (this.anIntArray7055[i_104_] != 0) {
            if (~i_97_ == -1) {
               if (~bs_75_.length >= ~i_98_) {
                  i_97_ = -1;
               } else {
                  i_97_ = bs_75_[i_98_++];
               }

               i_103_ = buffer.buffer[i_77_++] + 16 << 2;
            }

            --i_97_;
            this.aByteArray7046[i_104_] = (byte)i_103_;
         }
      }

      i_97_ = 0;
      i_98_ = 0;
      Class240 class240 = null;

      for(int i_105_ = 0; i_105_ < 128; ++i_105_) {
         if (this.anIntArray7055[i_105_] != 0) {
            if (i_97_ == 0) {
               class240 = class240s[bs_81_[i_98_]];
               if (bs_79_.length > i_98_) {
                  i_97_ = bs_79_[i_98_++];
               } else {
                  i_97_ = -1;
               }
            }

            this.aClass240Array7045[i_105_] = class240;
            --i_97_;
         }
      }

      i_98_ = 0;
      i_97_ = 0;
      int i_106_ = 0;

      for(int i_107_ = 0; i_107_ < 128; ++i_107_) {
         if (i_97_ == 0) {
            if (~i_98_ <= ~bs_92_.length) {
               i_97_ = -1;
            } else {
               i_97_ = bs_92_[i_98_++];
            }

            if (~this.anIntArray7055[i_107_] < -1) {
               i_106_ = buffer.readUnsignedByte() - -1;
            }
         }

         this.aByteArray7057[i_107_] = (byte)i_106_;
         --i_97_;
      }

      this.anInt7052 = buffer.readUnsignedByte() - -1;

      for(int i_108_ = 0; i_108_ < i_82_; ++i_108_) {
         Class240 class240_109_ = class240s[i_108_];
         if (class240_109_.aByteArray2944 != null) {
            for(int i_110_ = 1; ~class240_109_.aByteArray2944.length < ~i_110_; i_110_ += 2) {
               class240_109_.aByteArray2944[i_110_] = buffer.readByte();
            }
         }

         if (class240_109_.aByteArray2942 != null) {
            for(int i_111_ = 3; class240_109_.aByteArray2942.length - 2 > i_111_; i_111_ += 2) {
               class240_109_.aByteArray2942[i_111_] = buffer.readByte();
            }
         }
      }

      if (bs_89_ != null) {
         for(int i_112_ = 1; ~bs_89_.length < ~i_112_; i_112_ += 2) {
            bs_89_[i_112_] = buffer.readByte();
         }
      }

      if (bs_90_ != null) {
         for(int i_113_ = 1; bs_90_.length > i_113_; i_113_ += 2) {
            bs_90_[i_113_] = buffer.readByte();
         }
      }

      for(int i_114_ = 0; i_82_ > i_114_; ++i_114_) {
         Class240 class240_115_ = class240s[i_114_];
         if (class240_115_.aByteArray2942 != null) {
            i_94_ = 0;

            for(int i_116_ = 2; ~i_116_ > ~class240_115_.aByteArray2942.length; i_116_ += 2) {
               i_94_ = buffer.readUnsignedByte() + i_94_ + 1;
               class240_115_.aByteArray2942[i_116_] = (byte)i_94_;
            }
         }
      }

      for(int i_117_ = 0; i_82_ > i_117_; ++i_117_) {
         Class240 class240_118_ = class240s[i_117_];
         if (class240_118_.aByteArray2944 != null) {
            i_94_ = 0;

            for(int i_119_ = 2; ~class240_118_.aByteArray2944.length < ~i_119_; i_119_ += 2) {
               i_94_ += buffer.readUnsignedByte() + 1;
               class240_118_.aByteArray2944[i_119_] = (byte)i_94_;
            }
         }
      }

      if (bs_89_ != null) {
         i_94_ = buffer.readUnsignedByte();
         bs_89_[0] = (byte)i_94_;

         for(int i_120_ = 2; bs_89_.length > i_120_; i_120_ += 2) {
            i_94_ = buffer.readUnsignedByte() + i_94_ + 1;
            bs_89_[i_120_] = (byte)i_94_;
         }

         int i_121_ = bs_89_[0];
         int i_122_ = bs_89_[1];

         for(int i_123_ = 0; i_123_ < i_121_; ++i_123_) {
            this.aByteArray7057[i_123_] = (byte)(this.aByteArray7057[i_123_] * i_122_ + 32 >> 6);
         }

         for(int i_124_ = 2; i_124_ < bs_89_.length; i_124_ += 2) {
            int i_125_ = bs_89_[i_124_];
            int i_126_ = bs_89_[i_124_ + 1];
            int i_127_ = (-i_121_ + i_125_) / 2 + i_122_ * (-i_121_ + i_125_);

            for(int i_128_ = i_121_; ~i_128_ > ~i_125_; ++i_128_) {
               int i_129_ = Class128.method1550(-13892, i_125_ - i_121_, i_127_);
               i_127_ += -i_122_ + i_126_;
               this.aByteArray7057[i_128_] = (byte)(this.aByteArray7057[i_128_] * i_129_ + 32 >> 6);
            }

            i_122_ = i_126_;
            i_121_ = i_125_;
         }

         for(int i_130_ = i_121_; ~i_130_ > -129; ++i_130_) {
            this.aByteArray7057[i_130_] = (byte)(32 + this.aByteArray7057[i_130_] * i_122_ >> 6);
         }
      }

      if (bs_90_ != null) {
         i_94_ = buffer.readUnsignedByte();
         bs_90_[0] = (byte)i_94_;

         for(int i_131_ = 2; ~i_131_ > ~bs_90_.length; i_131_ += 2) {
            i_94_ += buffer.readUnsignedByte() + 1;
            bs_90_[i_131_] = (byte)i_94_;
         }

         int i_132_ = bs_90_[0];
         int i_133_ = bs_90_[1] << 1;

         for(int i_134_ = 0; i_132_ > i_134_; ++i_134_) {
            int i_135_ = i_133_ + (255 & this.aByteArray7046[i_134_]);
            if (i_135_ < 0) {
               i_135_ = 0;
            }

            if (i_135_ > 128) {
               i_135_ = 128;
            }

            this.aByteArray7046[i_134_] = (byte)i_135_;
         }

         for(int i_136_ = 2; bs_90_.length > i_136_; i_136_ += 2) {
            int i_137_ = bs_90_[i_136_];
            int i_138_ = bs_90_[1 + i_136_] << 1;
            int i_139_ = (-i_132_ + i_137_) / 2 + (i_137_ + -i_132_) * i_133_;

            for(int i_140_ = i_132_; i_137_ > i_140_; ++i_140_) {
               int i_141_ = Class128.method1550(-13892, i_137_ - i_132_, i_139_);
               int i_142_ = (255 & this.aByteArray7046[i_140_]) + i_141_;
               if (i_142_ < 0) {
                  i_142_ = 0;
               }

               if (~i_142_ < -129) {
                  i_142_ = 128;
               }

               this.aByteArray7046[i_140_] = (byte)i_142_;
               i_139_ += i_138_ - i_133_;
            }

            i_132_ = i_137_;
            i_133_ = i_138_;
         }

         for(int i_143_ = i_132_; i_143_ < 128; ++i_143_) {
            int i_144_ = i_133_ + (this.aByteArray7046[i_143_] & 255);
            if (i_144_ < 0) {
               i_144_ = 0;
            }

            if (~i_144_ < -129) {
               i_144_ = 128;
            }

            this.aByteArray7046[i_143_] = (byte)i_144_;
         }
      }

      for(int i_145_ = 0; i_145_ < i_82_; ++i_145_) {
         class240s[i_145_].anInt2933 = buffer.readUnsignedByte();
      }

      for(int i_146_ = 0; i_82_ > i_146_; ++i_146_) {
         Class240 class240_147_ = class240s[i_146_];
         if (class240_147_.aByteArray2944 != null) {
            class240_147_.anInt2940 = buffer.readUnsignedByte();
         }

         if (class240_147_.aByteArray2942 != null) {
            class240_147_.anInt2941 = buffer.readUnsignedByte();
         }

         if (class240_147_.anInt2933 > 0) {
            class240_147_.anInt2934 = buffer.readUnsignedByte();
         }
      }

      for(int i_148_ = 0; i_148_ < i_82_; ++i_148_) {
         class240s[i_148_].anInt2938 = buffer.readUnsignedByte();
      }

      for(int i_149_ = 0; ~i_82_ < ~i_149_; ++i_149_) {
         Class240 class240_150_ = class240s[i_149_];
         if (class240_150_.anInt2938 > 0) {
            class240_150_.anInt2937 = buffer.readUnsignedByte();
         }
      }

      for(int i_151_ = 0; ~i_151_ > ~i_82_; ++i_151_) {
         Class240 class240_152_ = class240s[i_151_];
         if (~class240_152_.anInt2937 < -1) {
            class240_152_.anInt2947 = buffer.readUnsignedByte();
         }
      }
   }
}
