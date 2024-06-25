import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

public class ClientScriptsExecutor {
   public static int TESTING_SCRIPT = 717;
   private static long[] longValues = new long[1000];
   static int anInt3838;
   private static String[] stringArguments;
   private static int[] intValues = new int[1000];
   private static int stringValueIndex = 0;
   private static Class113[] aClass113Array3842 = new Class113[50];
   private static int anInt3843 = 0;
   static int anInt3844;
   private static int[] anIntArray3845 = new int[3];
   private static int intValueIndex = 0;
   private static int[] intArguments;
   static int anInt3848;
   private static IComponentDefinitions aWidget3849;
   static int anInt3850;
   private static long[] longArguments;
   static int anInt3852;
   static int anInt3853;
   static int anInt3854;
   private static String[] stringValues = new String[1000];
   private static Class16 aClass16_3856;
   private static Node_Sub43 aNode_Sub43_3857;
   static int anInt3858;
   private static int[][] anIntArrayArray3859 = new int[5][5000];
   private static ClanChat aClanChat3860;
   static int anInt3861;
   static int anInt3862;
   static int anInt3863;
   private static int longValueIndex = 0;
   private static IComponentDefinitions aWidget3865;
   private static int[] anIntArray3866 = new int[5];
   static Class61 aClass61_3867 = new Class61(4);
   static boolean aBoolean3868 = false;
   private static int anInt3869 = 0;
   static String aString3870 = null;

   private static final int method3547(int i) {
      Class314 class314 = Class291_Sub1.aClass13_8198.method207(i, 0);
      if (class314 == null) {
         throw new RuntimeException("sr-c113");
      } else {
         Integer integer = aClanChat3860.method506(
            (byte)73, Class209.aClass353_2483.anInt4344 << 16 | class314.anInt4021, class314.anInt4023, class314.anInt4018
         );
         return integer == null ? 0 : integer;
      }
   }

   private static final int method3548(int i) {
      Class314 class314 = Class291_Sub1.aClass13_8198.method207(i, 0);
      if (class314 == null) {
         throw new RuntimeException("sr-c112");
      } else {
         Integer integer = aClanChat3860.method501(Class209.aClass353_2483.anInt4344 << 16 | i, -87);
         if (integer == null) {
            return class314.aChar4022 != 105 && class314.aChar4022 != 49 ? -1 : 0;
         } else {
            return integer;
         }
      }
   }

   private static final long method3549(int i) {
      Long var_long = aClanChat3860.method489((byte)-24, Class209.aClass353_2483.anInt4344 << 16 | i);
      return var_long == null ? -1L : var_long;
   }

   static final void parseIComponentScript(int i) {
      if (i != -1 && CacheNode_Sub15.loadInterface(7015, i)) {
         IComponentDefinitions[] widgets = Class134_Sub3.aWidgetArrayArray9035[i];

         for(int i_0_ = 0; i_0_ < widgets.length; ++i_0_) {
            IComponentDefinitions widget = widgets[i_0_];
            if (widget.anObjectArray4758 != null) {
               Node_Sub37 node_sub37 = new Node_Sub37();
               node_sub37.aWidget7437 = widget;
               node_sub37.parameters = widget.anObjectArray4758;
               executeScript(node_sub37, 2000000);
            }
         }
      }
   }

   static final void parseExternalIComponentScript(int i) {
      if (i != -1) {
         IComponentDefinitions[] widgets = Class134_Sub3.aWidgetArrayArray9035[i];

         for(int i_0_ = 0; i_0_ < widgets.length; ++i_0_) {
            IComponentDefinitions widget = widgets[i_0_];
            if (widget.anObjectArray4758 != null) {
               Node_Sub37 node_sub37 = new Node_Sub37();
               node_sub37.aWidget7437 = widget;
               node_sub37.parameters = widget.anObjectArray4758;
               executeScript(node_sub37, 2000000);
            }
         }
      }
   }

   static final void runExternalInterfaceScript(Object[] objects) {
      Node_Sub37 node_sub37 = new Node_Sub37();
      node_sub37.parameters = objects;
      sendRunScript(node_sub37);
   }

   private static final void method3551(IComponentDefinitions widget) {
      if (widget != null) {
         if (widget.anInt4687 != -1) {
            IComponentDefinitions widget_1_ = Class76.getInterfaceFromHash((byte)107, widget.parentId);
            if (widget_1_ != null) {
               if (widget_1_.aWidgetArray4793 == widget_1_.aWidgetArray4804) {
                  widget_1_.aWidgetArray4793 = new IComponentDefinitions[widget_1_.aWidgetArray4804.length];
                  widget_1_.aWidgetArray4793[widget_1_.aWidgetArray4793.length - 1] = widget;
                  Class311.method3605(widget_1_.aWidgetArray4804, 0, widget_1_.aWidgetArray4793, 0, widget.anInt4687);
                  Class311.method3605(
                     widget_1_.aWidgetArray4804,
                     widget.anInt4687 + 1,
                     widget_1_.aWidgetArray4793,
                     widget.anInt4687,
                     widget_1_.aWidgetArray4804.length - widget.anInt4687 - 1
                  );
               } else {
                  int i = 0;
                  IComponentDefinitions[] widgets = widget_1_.aWidgetArray4793;

                  while(i < widgets.length && widgets[i] != widget) {
                     ++i;
                  }

                  if (i < widgets.length) {
                     Class311.method3605(widgets, i + 1, widgets, i, widgets.length - i - 1);
                     widgets[widget_1_.aWidgetArray4793.length - 1] = widget;
                  }
               }
            }
         } else {
            int i = widget.ihash >>> 16;
            IComponentDefinitions[] widgets = AreaDefinitions.aWidgetArrayArray1082[i];
            if (widgets == null) {
               IComponentDefinitions[] widgets_2_ = Class134_Sub3.aWidgetArrayArray9035[i];
               int i_3_ = widgets_2_.length;
               widgets = AreaDefinitions.aWidgetArrayArray1082[i] = new IComponentDefinitions[i_3_];
               Class311.method3605(widgets_2_, 0, widgets, 0, widgets_2_.length);
            }

            int i_4_ = 0;

            while(i_4_ < widgets.length && widgets[i_4_] != widget) {
               ++i_4_;
            }

            if (i_4_ < widgets.length) {
               Class311.method3605(widgets, i_4_ + 1, widgets, i_4_, widgets.length - i_4_ - 1);
               widgets[widgets.length - 1] = widget;
            }
         }
      }
   }

   public static final void runOpcode(int command, boolean bool, int scriptId) {
      if (command < 300) {
         if (command == 150) {
            intValueIndex -= 3;
            int componentHash = intValues[intValueIndex];
            int type = intValues[intValueIndex + 1];
            int childId = intValues[intValueIndex + 2];
            if (type == 0) {
               throw new RuntimeException();
            }

            if (scriptId == TESTING_SCRIPT) {
               System.out.println("COMMAND == 150 -> i_5_: " + componentHash + " - i_6_: " + type + " - i_7_: " + childId);
            }

            IComponentDefinitions widget = Class76.getInterfaceFromHash((byte)107, componentHash);
            if (widget.aWidgetArray4804 == null) {
               widget.aWidgetArray4804 = new IComponentDefinitions[childId + 1];
               widget.aWidgetArray4793 = widget.aWidgetArray4804;
            }

            if (widget.aWidgetArray4804.length <= childId) {
               if (widget.aWidgetArray4804 == widget.aWidgetArray4793) {
                  IComponentDefinitions[] widgets = new IComponentDefinitions[childId + 1];

                  for(int i_8_ = 0; i_8_ < widget.aWidgetArray4804.length; ++i_8_) {
                     widgets[i_8_] = widget.aWidgetArray4804[i_8_];
                  }

                  widget.aWidgetArray4804 = widget.aWidgetArray4793 = widgets;
               } else {
                  IComponentDefinitions[] widgets = new IComponentDefinitions[childId + 1];
                  IComponentDefinitions[] widgets_9_ = new IComponentDefinitions[childId + 1];

                  for(int i_10_ = 0; i_10_ < widget.aWidgetArray4804.length; ++i_10_) {
                     widgets[i_10_] = widget.aWidgetArray4804[i_10_];
                     widgets_9_[i_10_] = widget.aWidgetArray4793[i_10_];
                  }

                  widget.aWidgetArray4804 = widgets;
                  widget.aWidgetArray4793 = widgets_9_;
               }
            }

            if (childId > 0 && widget.aWidgetArray4804[childId - 1] == null) {
               throw new RuntimeException("Gap at:" + (childId - 1));
            }

            IComponentDefinitions widget_11_ = new IComponentDefinitions();
            widget_11_.type = type;
            widget_11_.parentId = widget_11_.ihash = widget.ihash;
            widget_11_.anInt4687 = childId;
            widget.aWidgetArray4804[childId] = widget_11_;
            if (widget.aWidgetArray4793 != widget.aWidgetArray4804) {
               widget.aWidgetArray4793[childId] = widget_11_;
            }

            if (bool) {
               aWidget3865 = widget_11_;
            } else {
               aWidget3849 = widget_11_;
            }

            ClientScript.method2321(-1, widget);
            return;
         }

         if (command == 151) {
            IComponentDefinitions widget = bool ? aWidget3865 : aWidget3849;
            if (widget.anInt4687 == -1) {
               if (bool) {
                  throw new RuntimeException("Tried to .cc_delete static .active-component!");
               }

               throw new RuntimeException("Tried to cc_delete static active-component!");
            }

            IComponentDefinitions widget_12_ = Class76.getInterfaceFromHash((byte)107, widget.ihash);
            widget_12_.aWidgetArray4804[widget.anInt4687] = null;
            ClientScript.method2321(-1, widget_12_);
            return;
         }

         if (command == 152) {
            IComponentDefinitions widget = Class76.getInterfaceFromHash((byte)107, intValues[--intValueIndex]);
            widget.aWidgetArray4804 = null;
            widget.aWidgetArray4793 = null;
            ClientScript.method2321(-1, widget);
            return;
         }

         if (command == 200) {
            intValueIndex -= 2;
            int i_13_ = intValues[intValueIndex];
            int i_14_ = intValues[intValueIndex + 1];
            IComponentDefinitions widget = Node_Sub3.method2169(-101, i_14_, i_13_);
            if (widget != null && i_14_ != -1) {
               intValues[intValueIndex++] = 1;
               if (bool) {
                  aWidget3865 = widget;
               } else {
                  aWidget3849 = widget;
               }

               return;
            }

            intValues[intValueIndex++] = 0;
            return;
         }

         if (command == 201) {
            int i_15_ = intValues[--intValueIndex];
            IComponentDefinitions widget = Class76.getInterfaceFromHash((byte)107, i_15_);
            if (widget != null) {
               intValues[intValueIndex++] = 1;
               if (bool) {
                  aWidget3865 = widget;
               } else {
                  aWidget3849 = widget;
               }

               return;
            }

            intValues[intValueIndex++] = 0;
            return;
         }

         if (command != 202 && command != 204) {
            if (command != 203 && command != 205) {
               throw new IllegalStateException(String.valueOf(command));
            }

            IComponentDefinitions widget;
            if (command == 203) {
               int i_17_ = intValues[--intValueIndex];
               widget = Class76.getInterfaceFromHash((byte)107, i_17_);
            } else {
               widget = bool ? aWidget3865 : aWidget3849;
            }

            method3553(widget);
            return;
         }

         IComponentDefinitions widget;
         if (command == 202) {
            int i_16_ = intValues[--intValueIndex];
            widget = Class76.getInterfaceFromHash((byte)107, i_16_);
         } else {
            widget = bool ? aWidget3865 : aWidget3849;
         }

         method3551(widget);
         return;
      } else if (command < 500) {
         if (command == 403) {
            intValueIndex -= 2;
            int i_18_ = intValues[intValueIndex];
            int i_19_ = intValues[intValueIndex + 1];
            if (Class295.myPlayer.aPlayerDefinition11137 == null) {
               return;
            }

            for(int i_20_ = 0; i_20_ < Class370.anIntArray4567.length; ++i_20_) {
               if (Class370.anIntArray4567[i_20_] == i_18_) {
                  Class295.myPlayer.aPlayerDefinition11137.method3281(i_19_, (byte)97, Class42.aClass181_643, i_20_);
                  return;
               }
            }

            for(int i_21_ = 0; i_21_ < r.anIntArray9580.length; ++i_21_) {
               if (r.anIntArray9580[i_21_] == i_18_) {
                  Class295.myPlayer.aPlayerDefinition11137.method3281(i_19_, (byte)96, Class42.aClass181_643, i_21_);
                  break;
               }
            }

            return;
         }

         if (command == 404) {
            intValueIndex -= 2;
            int i_22_ = intValues[intValueIndex];
            int i_23_ = intValues[intValueIndex + 1];
            if (Class295.myPlayer.aPlayerDefinition11137 != null) {
               Class295.myPlayer.aPlayerDefinition11137.method3282(i_22_, i_23_, (byte)-92);
               return;
            }

            return;
         }

         if (command == 410) {
            boolean bool_24_ = intValues[--intValueIndex] != 0;
            if (Class295.myPlayer.aPlayerDefinition11137 != null) {
               Class295.myPlayer.aPlayerDefinition11137.method3280(26328, bool_24_);
               return;
            }

            return;
         }

         if (command == 411) {
            intValueIndex -= 2;
            int i_25_ = intValues[intValueIndex];
            int i_26_ = intValues[intValueIndex + 1];
            if (Class295.myPlayer.aPlayerDefinition11137 != null) {
               Class295.myPlayer.aPlayerDefinition11137.method3284((byte)-82, i_26_, i_25_, EntityNode_Sub3_Sub1.aClass86_9166);
               return;
            }

            return;
         }
      } else if ((command < 1000 || command >= 1100) && (command < 2000 || command >= 2100)) {
         if ((command < 1100 || command >= 1200) && (command < 2100 || command >= 2200)) {
            if ((command < 1200 || command >= 1300) && (command < 2200 || command >= 2300)) {
               if ((command < 1300 || command >= 1400) && (command < 2300 || command >= 2400)) {
                  if (command >= 1400 && command < 1500 || command >= 2400 && command < 2500) {
                     IComponentDefinitions widget;
                     if (command >= 2000) {
                        command -= 1000;
                        widget = Class76.getInterfaceFromHash((byte)107, intValues[--intValueIndex]);
                     } else {
                        widget = bool ? aWidget3865 : aWidget3849;
                     }

                     if (command == 1499) {
                        widget.method4151(-104);
                        return;
                     }

                     String string = stringValues[--stringValueIndex];
                     int[] is = null;
                     if (string.length() > 0 && string.charAt(string.length() - 1) == 'Y') {
                        int i_57_ = intValues[--intValueIndex];
                        if (i_57_ > 0) {
                           is = new int[i_57_];

                           while(i_57_-- > 0) {
                              is[i_57_] = intValues[--intValueIndex];
                           }
                        }

                        string = string.substring(0, string.length() - 1);
                     }

                     Object[] objects = new Object[string.length() + 1];

                     for(int i_58_ = objects.length - 1; i_58_ >= 1; --i_58_) {
                        if (string.charAt(i_58_ - 1) == 's') {
                           objects[i_58_] = stringValues[--stringValueIndex];
                        } else if (string.charAt(i_58_ - 1) == 167) {
                           objects[i_58_] = new Long(longValues[--longValueIndex]);
                        } else {
                           objects[i_58_] = new Integer(intValues[--intValueIndex]);
                        }
                     }

                     int hookedScriptId = intValues[--intValueIndex];
                     if (hookedScriptId != -1) {
                        objects[0] = new Integer(hookedScriptId);
                     } else {
                        objects = null;
                     }

                     if (command == 1400) {
                        widget.anObjectArray4774 = objects;
                     } else if (command == 1401) {
                        widget.anObjectArray4856 = objects;
                     } else if (command == 1402) {
                        widget.anObjectArray4680 = objects;
                     } else if (command == 1403) {
                        widget.anObjectArray4706 = objects;
                     } else if (command == 1404) {
                        widget.anObjectArray4818 = objects;
                     } else if (command == 1405) {
                        widget.anObjectArray4852 = objects;
                     } else if (command == 1406) {
                        widget.anObjectArray4771 = objects;
                     } else if (command == 1407) {
                        widget.anObjectArray4807 = objects;
                        widget.anIntArray4838 = is;
                     } else if (command == 1408) {
                        widget.anObjectArray4701 = objects;
                     } else if (command == 1409) {
                        widget.anObjectArray4770 = objects;
                     } else if (command == 1410) {
                        widget.anObjectArray4711 = objects;
                     } else if (command == 1411) {
                        widget.anObjectArray4803 = objects;
                     } else if (command == 1412) {
                        widget.popupScript = objects;
                     } else if (command == 1414) {
                        widget.anObjectArray4742 = objects;
                        widget.anIntArray4833 = is;
                     } else if (command == 1415) {
                        widget.anObjectArray4788 = objects;
                        widget.anIntArray4789 = is;
                     } else if (command == 1416) {
                        widget.anObjectArray4768 = objects;
                     } else if (command == 1417) {
                        widget.anObjectArray4753 = objects;
                     } else if (command == 1418) {
                        widget.anObjectArray4740 = objects;
                     } else if (command == 1419) {
                        widget.anObjectArray4798 = objects;
                     } else if (command == 1420) {
                        widget.anObjectArray4846 = objects;
                     } else if (command == 1421) {
                        widget.anObjectArray4828 = objects;
                     } else if (command == 1422) {
                        widget.anObjectArray4862 = objects;
                     } else if (command == 1423) {
                        widget.anObjectArray4778 = objects;
                     } else if (command == 1424) {
                        widget.anObjectArray4712 = objects;
                     } else if (command == 1425) {
                        widget.anObjectArray4745 = objects;
                     } else if (command == 1426) {
                        widget.anObjectArray4854 = objects;
                     } else if (command == 1427) {
                        widget.anObjectArray4777 = objects;
                     } else if (command == 1428) {
                        widget.anObjectArray4688 = objects;
                        widget.anIntArray4829 = is;
                     } else if (command == 1429) {
                        widget.anObjectArray4775 = objects;
                        widget.anIntArray4805 = is;
                     } else if (command == 1430) {
                        widget.anObjectArray4751 = objects;
                     } else if (command == 1431) {
                        widget.anObjectArray4799 = objects;
                     } else if (command == 1432) {
                        widget.anObjectArray4756 = objects;
                     } else if (command == 1433) {
                        widget.anObjectArray4857 = objects;
                     }

                     widget.hasScripts = true;
                     return;
                  }

                  if (command < 1600) {
                     IComponentDefinitions widget = bool ? aWidget3865 : aWidget3849;
                     if (command == 1500) {
                        intValues[intValueIndex++] = widget.positionX;
                        return;
                     }

                     if (command == 1501) {
                        intValues[intValueIndex++] = widget.positionY;
                        return;
                     }

                     if (command == 1502) {
                        intValues[intValueIndex++] = widget.width;
                        return;
                     }

                     if (command == 1503) {
                        intValues[intValueIndex++] = widget.height;
                        return;
                     }

                     if (command == 1504) {
                        intValues[intValueIndex++] = widget.hidden ? 1 : 0;
                        return;
                     }

                     if (command == 1505) {
                        intValues[intValueIndex++] = widget.parentId;
                        return;
                     }

                     if (command == 1506) {
                        IComponentDefinitions widget_60_ = Class295.method3468((byte)-104, widget);
                        intValues[intValueIndex++] = widget_60_ == null ? -1 : widget_60_.ihash;
                        return;
                     }

                     if (command == 1507) {
                        intValues[intValueIndex++] = widget.color;
                        return;
                     }
                  } else if (command < 1700) {
                     IComponentDefinitions widget = bool ? aWidget3865 : aWidget3849;
                     if (command == 1600) {
                        intValues[intValueIndex++] = widget.scrollX;
                        return;
                     }

                     if (command == 1601) {
                        intValues[intValueIndex++] = widget.scrollY;
                        return;
                     }

                     if (command == 1602) {
                        stringValues[stringValueIndex++] = widget.text;
                        return;
                     }

                     if (command == 1603) {
                        intValues[intValueIndex++] = widget.scrollMaxX;
                        return;
                     }

                     if (command == 1604) {
                        intValues[intValueIndex++] = widget.scrollMaxY;
                        return;
                     }

                     if (command == 1605) {
                        intValues[intValueIndex++] = widget.modelZoom;
                        return;
                     }

                     if (command == 1606) {
                        intValues[intValueIndex++] = widget.modelRotationX;
                        return;
                     }

                     if (command == 1607) {
                        intValues[intValueIndex++] = widget.modelRotationY;
                        return;
                     }

                     if (command == 1608) {
                        intValues[intValueIndex++] = widget.modelRotationZ;
                        return;
                     }

                     if (command == 1609) {
                        intValues[intValueIndex++] = widget.transparency;
                        return;
                     }

                     if (command == 1610) {
                        intValues[intValueIndex++] = widget.modelOffsetX;
                        return;
                     }

                     if (command == 1611) {
                        intValues[intValueIndex++] = widget.modelOffsetY;
                        return;
                     }

                     if (command == 1612) {
                        intValues[intValueIndex++] = widget.spriteId;
                        return;
                     }

                     if (command == 1613) {
                        int i_61_ = intValues[--intValueIndex];
                        Class267 class267 = Class188_Sub2_Sub2.aClass36_9366.method394(i_61_, -79);
                        if (class267.method3287((byte)110)) {
                           stringValues[stringValueIndex++] = widget.method4141(class267.aString3450, i_61_, 121);
                           return;
                        }

                        intValues[intValueIndex++] = widget.method4156(class267.anInt3443, 18131, i_61_);
                        return;
                     }

                     if (command == 1614) {
                        intValues[intValueIndex++] = widget.angle2D;
                        return;
                     }

                     if (command == 2614) {
                        intValues[intValueIndex++] = widget.modelType == 1 ? widget.modelId : -1;
                        return;
                     }

                     if (command == 1618) {
                        intValues[intValueIndex++] = widget.fontId;
                        return;
                     }
                  } else if (command < 1800) {
                     IComponentDefinitions widget = bool ? aWidget3865 : aWidget3849;
                     if (command == 1700) {
                        intValues[intValueIndex++] = widget.itemId;
                        return;
                     }

                     if (command == 1701) {
                        if (widget.itemId != -1) {
                           intValues[intValueIndex++] = widget.itemAmount;
                           return;
                        }

                        intValues[intValueIndex++] = 0;
                        return;
                     }

                     if (command == 1702) {
                        intValues[intValueIndex++] = widget.anInt4687;
                        return;
                     }
                  } else if (command < 1900) {
                     IComponentDefinitions widget = bool ? aWidget3865 : aWidget3849;
                     if (command == 1800) {
                        intValues[intValueIndex++] = Client.method113(widget).method2743(-59);
                        return;
                     }

                     if (command == 1801) {
                        int i_62_ = intValues[--intValueIndex];
                        --i_62_;
                        if (widget.rightClickActions != null && i_62_ < widget.rightClickActions.length && widget.rightClickActions[i_62_] != null) {
                           stringValues[stringValueIndex++] = widget.rightClickActions[i_62_];
                           return;
                        }

                        stringValues[stringValueIndex++] = "";
                        return;
                     }

                     if (command == 1802) {
                        if (widget.baseOption == null) {
                           stringValues[stringValueIndex++] = "";
                           return;
                        }

                        stringValues[stringValueIndex++] = widget.baseOption;
                        return;
                     }
                  } else if (command >= 2000 && (command < 2900 || command >= 3000)) {
                     if (command < 2600) {
                        IComponentDefinitions widget = Class76.getInterfaceFromHash((byte)107, intValues[--intValueIndex]);
                        if (command == 2500) {
                           intValues[intValueIndex++] = widget.positionX;
                           return;
                        }

                        if (command == 2501) {
                           intValues[intValueIndex++] = widget.positionY;
                           return;
                        }

                        if (command == 2502) {
                           intValues[intValueIndex++] = widget.width;
                           return;
                        }

                        if (command == 2503) {
                           intValues[intValueIndex++] = widget.height;
                           return;
                        }

                        if (command == 2504) {
                           intValues[intValueIndex++] = widget.hidden ? 1 : 0;
                           return;
                        }

                        if (command == 2505) {
                           intValues[intValueIndex++] = widget.parentId;
                           return;
                        }

                        if (command == 2506) {
                           IComponentDefinitions widget_63_ = Class295.method3468((byte)-93, widget);
                           intValues[intValueIndex++] = widget_63_ == null ? -1 : widget_63_.ihash;
                           return;
                        }

                        if (command == 2507) {
                           intValues[intValueIndex++] = widget.color;
                           return;
                        }
                     } else if (command < 2700) {
                        IComponentDefinitions widget = Class76.getInterfaceFromHash((byte)107, intValues[--intValueIndex]);
                        if (command == 2600) {
                           intValues[intValueIndex++] = widget.scrollX;
                           return;
                        }

                        if (command == 2601) {
                           intValues[intValueIndex++] = widget.scrollY;
                           return;
                        }

                        if (command == 2602) {
                           stringValues[stringValueIndex++] = widget.text;
                           return;
                        }

                        if (command == 2603) {
                           intValues[intValueIndex++] = widget.scrollMaxX;
                           return;
                        }

                        if (command == 2604) {
                           intValues[intValueIndex++] = widget.scrollMaxY;
                           return;
                        }

                        if (command == 2605) {
                           intValues[intValueIndex++] = widget.modelZoom;
                           return;
                        }

                        if (command == 2606) {
                           intValues[intValueIndex++] = widget.modelRotationX;
                           return;
                        }

                        if (command == 2607) {
                           intValues[intValueIndex++] = widget.modelRotationY;
                           return;
                        }

                        if (command == 2608) {
                           intValues[intValueIndex++] = widget.modelRotationZ;
                           return;
                        }

                        if (command == 2609) {
                           intValues[intValueIndex++] = widget.transparency;
                           return;
                        }

                        if (command == 2610) {
                           intValues[intValueIndex++] = widget.modelOffsetX;
                           return;
                        }

                        if (command == 2611) {
                           intValues[intValueIndex++] = widget.modelOffsetY;
                           return;
                        }

                        if (command == 2612) {
                           intValues[intValueIndex++] = widget.spriteId;
                           return;
                        }

                        if (command == 2613) {
                           intValues[intValueIndex++] = widget.angle2D;
                           return;
                        }

                        if (command == 2614) {
                           intValues[intValueIndex++] = widget.modelType == 1 ? widget.modelId : -1;
                           return;
                        }

                        if (command == 2617) {
                           intValues[intValueIndex++] = widget.fontId;
                           return;
                        }
                     } else if (command < 2800) {
                        if (command == 2700) {
                           IComponentDefinitions widget = Class76.getInterfaceFromHash((byte)107, intValues[--intValueIndex]);
                           intValues[intValueIndex++] = widget.itemId;
                           return;
                        }

                        if (command == 2701) {
                           IComponentDefinitions widget = Class76.getInterfaceFromHash((byte)107, intValues[--intValueIndex]);
                           if (widget.itemId != -1) {
                              intValues[intValueIndex++] = widget.itemAmount;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 2702) {
                           int i_64_ = intValues[--intValueIndex];
                           Node_Sub2 node_sub2 = (Node_Sub2)OverlayDefinition.aHashTable3630.get(3512, (long)i_64_);
                           if (node_sub2 != null) {
                              intValues[intValueIndex++] = 1;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 2703) {
                           IComponentDefinitions widget = Class76.getInterfaceFromHash((byte)107, intValues[--intValueIndex]);
                           if (widget.aWidgetArray4804 == null) {
                              intValues[intValueIndex++] = 0;
                              return;
                           }

                           int i_65_ = widget.aWidgetArray4804.length;

                           for(int i_66_ = 0; i_66_ < widget.aWidgetArray4804.length; ++i_66_) {
                              if (widget.aWidgetArray4804[i_66_] == null) {
                                 i_65_ = i_66_;
                                 break;
                              }
                           }

                           intValues[intValueIndex++] = i_65_;
                           return;
                        }

                        if (command == 2704 || command == 2705) {
                           intValueIndex -= 2;
                           int i_67_ = intValues[intValueIndex];
                           int i_68_ = intValues[intValueIndex + 1];
                           Node_Sub2 node_sub2 = (Node_Sub2)OverlayDefinition.aHashTable3630.get(3512, (long)i_67_);
                           if (node_sub2 != null && node_sub2.interfaceId == i_68_) {
                              intValues[intValueIndex++] = 1;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 2706) {
                           intValueIndex -= 2;
                           IComponentDefinitions widget = Class76.getInterfaceFromHash((byte)107, intValues[intValueIndex]);
                           int childToFind = intValues[intValueIndex + 1];
                           if (widget != null) {
                              intValues[intValueIndex++] = widget.aWidgetArray4804[childToFind].ihash;
                           } else {
                              intValues[intValueIndex++] = -1;
                           }

                           return;
                        }
                     } else if (command < 2900) {
                        IComponentDefinitions widget = Class76.getInterfaceFromHash((byte)107, intValues[--intValueIndex]);
                        if (command == 2800) {
                           intValues[intValueIndex++] = Client.method113(widget).method2743(-36);
                           return;
                        }

                        if (command == 2801) {
                           int i_69_ = intValues[--intValueIndex];
                           --i_69_;
                           if (widget.rightClickActions != null && i_69_ < widget.rightClickActions.length && widget.rightClickActions[i_69_] != null) {
                              stringValues[stringValueIndex++] = widget.rightClickActions[i_69_];
                              return;
                           }

                           stringValues[stringValueIndex++] = "";
                           return;
                        }

                        if (command == 2802) {
                           if (widget.baseOption == null) {
                              stringValues[stringValueIndex++] = "";
                              return;
                           }

                           stringValues[stringValueIndex++] = widget.baseOption;
                           return;
                        }
                     } else if (command < 3200) {
                        if (command == 3100) {
                           String string = stringValues[--stringValueIndex];
                           CacheNode_Sub20.method2406(string, 119);
                           return;
                        }

                        if (command == 3101) {
                           intValueIndex -= 2;
                           EntityNode_Sub7.method973((byte)75, Class295.myPlayer, intValues[intValueIndex + 1], intValues[intValueIndex]);
                           return;
                        }

                        if (command == 3103) {
                           Class46.method467(-1, true);
                           return;
                        }

                        if (command == 3104) {
                           String string = stringValues[--stringValueIndex];
                           int i_70_ = 0;
                           if (Class290_Sub7.method3441(2, string)) {
                              i_70_ = Class350.method3998(string, -1);
                           }

                           ++anInt3858;
                           OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(
                              Class262_Sub12.aClass318_7788, Class218.aClass123_2566.issacKeys
                           );
                           node_sub13.currentOutgoingPacket.writeInt(i_70_);
                           Class218.aClass123_2566.sendPacket(127, node_sub13);
                           return;
                        }

                        if (command == 3105) {
                           String string = stringValues[--stringValueIndex];
                           ++anInt3850;
                           OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class194_Sub2.aClass318_6897, Class218.aClass123_2566.issacKeys);
                           node_sub13.currentOutgoingPacket.writeByte(string.length() + 1);
                           node_sub13.currentOutgoingPacket.writeString(string);
                           Class218.aClass123_2566.sendPacket(127, node_sub13);
                           return;
                        }

                        if (command == 3106) {
                           String string = stringValues[--stringValueIndex];
                           ++anInt3848;
                           OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class71.aClass318_964, Class218.aClass123_2566.issacKeys);
                           node_sub13.currentOutgoingPacket.writeByte(string.length() + 1);
                           node_sub13.currentOutgoingPacket.writeString(string);
                           Class218.aClass123_2566.sendPacket(127, node_sub13);
                           return;
                        }

                        if (command == 3107) {
                           int i_71_ = intValues[--intValueIndex];
                           String string = stringValues[--stringValueIndex];
                           Class132.method1565(string, i_71_, -28537);
                           return;
                        }

                        if (command == 3108) {
                           intValueIndex -= 3;
                           int i_72_ = intValues[intValueIndex];
                           int i_73_ = intValues[intValueIndex + 1];
                           int i_74_ = intValues[intValueIndex + 2];
                           IComponentDefinitions widget = Class76.getInterfaceFromHash((byte)107, i_74_);
                           Class317.method3665(i_73_, widget, true, i_72_);
                           return;
                        }

                        if (command == 3109) {
                           intValueIndex -= 2;
                           int i_75_ = intValues[intValueIndex];
                           int i_76_ = intValues[intValueIndex + 1];
                           IComponentDefinitions widget = bool ? aWidget3865 : aWidget3849;
                           Class317.method3665(i_76_, widget, true, i_75_);
                           return;
                        }

                        if (command == 3110) {
                           int itemId = intValues[--intValueIndex];
                           ++anInt3854;
                           OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(
                              Class116.grandexchangeSelection, Class218.aClass123_2566.issacKeys
                           );
                           node_sub13.currentOutgoingPacket.writeShort(itemId);
                           Class218.aClass123_2566.sendPacket(127, node_sub13);
                           return;
                        }

                        if (command == 3111) {
                           intValueIndex -= 2;
                           int i_78_ = intValues[intValueIndex];
                           int interfaceId = intValues[intValueIndex + 1];
                           Node_Sub2 node_sub2 = (Node_Sub2)OverlayDefinition.aHashTable3630.get(3512, (long)i_78_);
                           if (node_sub2 != null) {
                              Class243.method3060((byte)112, true, node_sub2.interfaceId != interfaceId, node_sub2);
                           }

                           Class93.method1047(3, interfaceId, i_78_, 0, true, false);
                           return;
                        }

                        if (command == 3112) {
                           --intValueIndex;
                           int interfaceId = intValues[intValueIndex];
                           Node_Sub2 node_sub2 = (Node_Sub2)OverlayDefinition.aHashTable3630.get(3512, (long)interfaceId);
                           if (node_sub2 != null && node_sub2.cliped == 3) {
                              Class243.method3060((byte)56, true, true, node_sub2);
                           }

                           if (RSMapperClient.editor.objectEditor != null && RSMapperClient.editor.objectEditor.VIEWER_OPEN) {
                              ExternalInterfaceLoader.reloadInterface(ExternalInterfaceLoader.getInterfaceName(interfaceId));
                           }

                           return;
                        }

                        if (command == 3113) {
                           Class39.method414(30482, stringValues[--stringValueIndex]);
                           return;
                        }

                        if (command == 3114) {
                           intValueIndex -= 2;
                           int channel = intValues[intValueIndex];
                           int i_82_ = intValues[intValueIndex + 1];
                           String message = stringValues[--stringValueIndex];
                           Class28.method331(message, "", 103, i_82_, "", "", channel);
                           return;
                        }

                        if (command == 3115) {
                           intValueIndex -= 11;
                           Class379[] class379s = Class23.method302(1476280292);
                           Class77[] class77s = PlayerDefinition.method3277(12247);
                           Class262_Sub2.method3153(
                              intValues[intValueIndex + 7],
                              intValues[intValueIndex + 2],
                              intValues[intValueIndex + 9],
                              intValues[intValueIndex + 4],
                              class77s[intValues[intValueIndex + 1]],
                              intValues[intValueIndex + 5],
                              intValues[intValueIndex + 8],
                              intValues[intValueIndex + 6],
                              intValues[intValueIndex + 3],
                              126,
                              class379s[intValues[intValueIndex]],
                              intValues[intValueIndex + 10]
                           );
                           return;
                        }

                        if (command == 3116) {
                           int i_83_ = intValues[--intValueIndex];
                           ++anInt3858;
                           OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class235.aClass318_5119, Class218.aClass123_2566.issacKeys);
                           node_sub13.currentOutgoingPacket.writeShort(i_83_);
                           Class218.aClass123_2566.sendPacket(127, node_sub13);
                           return;
                        }

                        if (command == 3117) {
                           String string = stringValues[--stringValueIndex];
                           OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class188.aClass318_2279, Class218.aClass123_2566.issacKeys);
                           node_sub13.currentOutgoingPacket.writeByte(string.length() + 1);
                           node_sub13.currentOutgoingPacket.writeString(string);
                           Class218.aClass123_2566.sendPacket(127, node_sub13);
                           return;
                        }

                        if (command == 3118) {
                           intValueIndex -= 2;
                           int varpId1 = intValues[intValueIndex];
                           int varpId2 = intValues[intValueIndex + 1];
                           OutgoingPacket varpPacket = new OutgoingPacket(187, 3);
                           OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(varpPacket, Class218.aClass123_2566.issacKeys);
                           node_sub13.currentOutgoingPacket.writeShort(varpId1);
                           node_sub13.currentOutgoingPacket.writeInt(varpId1 >= 0 ? Class24.aClass275_442.CONFIG_VALUES[varpId1] : -1);
                           node_sub13.currentOutgoingPacket.writeShort(varpId2);
                           node_sub13.currentOutgoingPacket.writeInt(varpId2 >= 0 ? Class24.aClass275_442.CONFIG_VALUES[varpId2] : -1);
                           Class218.aClass123_2566.sendPacket(127, node_sub13);
                           return;
                        }
                     } else if (command < 3300) {
                        if (command == 3200) {
                           intValueIndex -= 3;
                           TextureDefinitions.method1033(256, intValues[intValueIndex + 2], intValues[intValueIndex], intValues[intValueIndex + 1], 255, 0);
                           return;
                        }

                        if (command == 3201) {
                           Class40.playMusic(255, 113, intValues[--intValueIndex], 50);
                           return;
                        }

                        if (command == 3202) {
                           intValueIndex -= 2;
                           RenderDefinitions.method3132(255, intValues[intValueIndex], intValues[intValueIndex + 1], (byte)110);
                           return;
                        }

                        if (command == 3203) {
                           intValueIndex -= 4;
                           TextureDefinitions.method1033(
                              256, intValues[intValueIndex + 2], intValues[intValueIndex], intValues[intValueIndex + 1], intValues[intValueIndex + 3], 0
                           );
                           return;
                        }

                        if (command == 3204) {
                           intValueIndex -= 3;
                           Class40.playMusic(intValues[intValueIndex + 1], 120, intValues[intValueIndex], intValues[intValueIndex + 2]);
                           return;
                        }

                        if (command == 3205) {
                           intValueIndex -= 3;
                           RenderDefinitions.method3132(intValues[intValueIndex + 2], intValues[intValueIndex], intValues[intValueIndex + 1], (byte)110);
                           return;
                        }

                        if (command == 3206) {
                           intValueIndex -= 4;
                           Class105.method1116(
                              intValues[intValueIndex],
                              intValues[intValueIndex + 1],
                              256,
                              (byte)-65,
                              intValues[intValueIndex + 2],
                              intValues[intValueIndex + 3],
                              false
                           );
                           return;
                        }

                        if (command == 3207) {
                           intValueIndex -= 4;
                           Class105.method1116(
                              intValues[intValueIndex],
                              intValues[intValueIndex + 1],
                              256,
                              (byte)61,
                              intValues[intValueIndex + 2],
                              intValues[intValueIndex + 3],
                              true
                           );
                           return;
                        }

                        if (command == 3208) {
                           intValueIndex -= 5;
                           TextureDefinitions.method1033(
                              intValues[intValueIndex + 4],
                              intValues[intValueIndex + 2],
                              intValues[intValueIndex],
                              intValues[intValueIndex + 1],
                              intValues[intValueIndex + 3],
                              0
                           );
                           return;
                        }

                        if (command == 3209) {
                           intValueIndex -= 5;
                           Class105.method1116(
                              intValues[intValueIndex],
                              intValues[intValueIndex + 1],
                              intValues[intValueIndex + 4],
                              (byte)96,
                              intValues[intValueIndex + 2],
                              intValues[intValueIndex + 3],
                              false
                           );
                           return;
                        }
                     } else if (command < 3400) {
                        if (command == 3300) {
                           intValues[intValueIndex++] = Class174.clientCycle;
                           return;
                        }

                        if (command == 3301) {
                           intValueIndex -= 2;
                           int key = intValues[intValueIndex];
                           int slot = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = Class317.getItemIdInSlot(key, -1, slot, false);
                           return;
                        }

                        if (command == 3302) {
                           intValueIndex -= 2;
                           int key = intValues[intValueIndex];
                           int slot = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = Class283.getItemAmountInSlotWithKey(slot, false, (byte)63, key);
                           return;
                        }

                        if (command == 3303) {
                           intValueIndex -= 2;
                           int key = intValues[intValueIndex];
                           int itemId = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = Class41.getItemAmountInContainerWithKey(itemId, key, false, (byte)66);
                           return;
                        }

                        if (command == 3304) {
                           int key = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Class269.aClass308_3469.method3584(key, -13798).itemsCount;
                           return;
                        }

                        if (command == 3305) {
                           int i_91_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Class307.SKILL_LEVEL[i_91_];
                           return;
                        }

                        if (command == 3306) {
                           int i_92_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Class34_Sub1.SKILL_REAL_LEVEL[i_92_];
                           return;
                        }

                        if (command == 3307) {
                           int i_93_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Class188_Sub1.SKILL_XP[i_93_];
                           return;
                        }

                        if (command == 3308) {
                           int i_94_ = Class295.myPlayer.plane;
                           int i_95_ = (Class295.myPlayer.x >> 9) + Node_Sub53.gameSceneBaseX;
                           int i_96_ = (Class295.myPlayer.y >> 9) + Class320_Sub4.gameSceneBaseY;
                           intValues[intValueIndex++] = (i_94_ << 28) + (i_95_ << 14) + i_96_;
                           return;
                        }

                        if (command == 3309) {
                           int i_97_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = i_97_ >> 14 & 16383;
                           return;
                        }

                        if (command == 3310) {
                           int i_98_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = i_98_ >> 28;
                           return;
                        }

                        if (command == 3311) {
                           int i_99_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = i_99_ & 16383;
                           return;
                        }

                        if (command == 3312) {
                           intValues[intValueIndex++] = Class101.aBoolean1313 ? 1 : 0;
                           return;
                        }

                        if (command == 3313) {
                           intValueIndex -= 2;
                           int i_100_ = intValues[intValueIndex];
                           int i_101_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = Class317.getItemIdInSlot(i_100_, -1, i_101_, true);
                           return;
                        }

                        if (command == 3314) {
                           intValueIndex -= 2;
                           int i_102_ = intValues[intValueIndex];
                           int i_103_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = Class283.getItemAmountInSlotWithKey(i_103_, true, (byte)86, i_102_);
                           return;
                        }

                        if (command == 3315) {
                           intValueIndex -= 2;
                           int i_104_ = intValues[intValueIndex];
                           int i_105_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = Class41.getItemAmountInContainerWithKey(i_105_, i_104_, true, (byte)111);
                           return;
                        }

                        if (command == 3316) {
                           if (Class339_Sub7.rights >= 2) {
                              intValues[intValueIndex++] = Class339_Sub7.rights;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3317) {
                           intValues[intValueIndex++] = Node_Sub19.anInt7163;
                           return;
                        }

                        if (command == 3318) {
                           intValues[intValueIndex++] = Class181.aClass197_2155.id;
                           return;
                        }

                        if (command == 3321) {
                           intValues[intValueIndex++] = Class373.RUN_ENERGY;
                           return;
                        }

                        if (command == 3322) {
                           intValues[intValueIndex++] = Mobile_Sub4.anInt10981;
                           return;
                        }

                        if (command == 3323) {
                           if (Class25.anInt452 >= 5 && Class25.anInt452 <= 9) {
                              intValues[intValueIndex++] = 1;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3324) {
                           if (Class25.anInt452 >= 5 && Class25.anInt452 <= 9) {
                              intValues[intValueIndex++] = Class25.anInt452;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3325) {
                           intValues[intValueIndex++] = Class64.aBoolean5046 ? 1 : 0;
                           return;
                        }

                        if (command == 3326) {
                           intValues[intValueIndex++] = Class295.myPlayer.combatLevel;
                           return;
                        }

                        if (command == 3327) {
                           intValues[intValueIndex++] = Class295.myPlayer.aPlayerDefinition11137 != null
                                 && Class295.myPlayer.aPlayerDefinition11137.aBoolean3434
                              ? 1
                              : 0;
                           return;
                        }

                        if (command == 3329) {
                           intValues[intValueIndex++] = Class290_Sub11.aBoolean8175 ? 1 : 0;
                           return;
                        }

                        if (command == 3330) {
                           int key = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Class30.getTotalFreeSlotsInContainerWithKey((byte)88, false, key);
                           return;
                        }

                        if (command == 3331) {
                           intValueIndex -= 2;
                           int i_107_ = intValues[intValueIndex];
                           int i_108_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = Node_Sub25_Sub3.method2673(88, false, i_108_, false, i_107_);
                           return;
                        }

                        if (command == 3332) {
                           intValueIndex -= 2;
                           int i_109_ = intValues[intValueIndex];
                           int i_110_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = Node_Sub25_Sub3.method2673(63, true, i_110_, false, i_109_);
                           return;
                        }

                        if (command == 3333) {
                           intValues[intValueIndex++] = Class369.method4083(false);
                           return;
                        }

                        if (command == 3335) {
                           intValues[intValueIndex++] = Class35.language;
                           return;
                        }

                        if (command == 3336) {
                           intValueIndex -= 4;
                           int i_111_ = intValues[intValueIndex];
                           int i_112_ = intValues[intValueIndex + 1];
                           int i_113_ = intValues[intValueIndex + 2];
                           int i_114_ = intValues[intValueIndex + 3];
                           i_111_ += i_112_ << 14;
                           i_111_ += i_113_ << 28;
                           i_111_ += i_114_;
                           intValues[intValueIndex++] = i_111_;
                           return;
                        }

                        if (command == 3337) {
                           intValues[intValueIndex++] = Class170.anInt2056;
                           return;
                        }

                        if (command == 3338) {
                           intValues[intValueIndex++] = CacheNode_Sub4.method2302((byte)88);
                           return;
                        }

                        if (command == 3339) {
                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3340) {
                           intValues[intValueIndex++] = Class51.hasWindowFocus ? 1 : 0;
                           return;
                        }

                        if (command == 3341) {
                           intValues[intValueIndex++] = Mobile_Sub1.aBoolean10961 ? 1 : 0;
                           return;
                        }

                        if (command == 3342) {
                           intValues[intValueIndex++] = Class106.aClass93_1356.getLastMousePosX();
                           return;
                        }

                        if (command == 3343) {
                           intValues[intValueIndex++] = Class106.aClass93_1356.getLastMousePosY(true);
                           return;
                        }

                        if (command == 3344) {
                           stringValues[stringValueIndex++] = Class67.method731((byte)115);
                           return;
                        }

                        if (command == 3345) {
                           stringValues[stringValueIndex++] = Class366.method4073(false);
                           return;
                        }

                        if (command == 3346) {
                           intValues[intValueIndex++] = Class178.method1812(5);
                           return;
                        }

                        if (command == 3347) {
                           intValues[intValueIndex++] = Node_Sub38_Sub23.anInt10346;
                           return;
                        }

                        if (command == 3349) {
                           intValues[intValueIndex++] = Class295.myPlayer.aClass99_10893.method1086(16383) >> 3;
                           return;
                        }

                        if (command == 3350) {
                           String string = stringValues[--stringValueIndex];
                           if (Node_Sub32.aString7378 != null && Node_Sub32.aString7378.equalsIgnoreCase(string)) {
                              intValues[intValueIndex++] = 1;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3351) {
                           intValues[intValueIndex++] = Class106.aClass93_1356.method1039() ? 1 : 0;
                           intValues[intValueIndex++] = Class106.aClass93_1356.method1044() ? 1 : 0;
                           intValues[intValueIndex++] = Class106.aClass93_1356.method1040() ? 1 : 0;
                           return;
                        }
                     } else if (command < 3500) {
                        if (command == 3400) {
                           intValueIndex -= 2;
                           int i_115_ = intValues[intValueIndex];
                           int i_116_ = intValues[intValueIndex + 1];
                           Class39 class39 = Class328.aClass362_4112.method4051(i_115_);
                           stringValues[stringValueIndex++] = class39.method412(-3470, i_116_);
                           return;
                        }

                        if (command == 3408) {
                           intValueIndex -= 4;
                           int keyType = intValues[intValueIndex];
                           int valueType = intValues[intValueIndex + 1];
                           int definition = intValues[intValueIndex + 2];
                           int key = intValues[intValueIndex + 3];
                           Class39 class39 = Class328.aClass362_4112.method4051(definition);
                           if (class39.aChar592 == keyType) {
                              ;
                           }

                           if (valueType == 115) {
                              stringValues[stringValueIndex++] = class39.method412(-3470, key);
                              return;
                           }

                           intValues[intValueIndex++] = class39.method410(key);
                           return;
                        }

                        if (command == 3409) {
                           intValueIndex -= 3;
                           int i_121_ = intValues[intValueIndex];
                           int i_122_ = intValues[intValueIndex + 1];
                           int i_123_ = intValues[intValueIndex + 2];
                           Class39 class39 = Class328.aClass362_4112.method4051(i_122_);
                           intValues[intValueIndex++] = class39.method416(-90, i_123_) ? 1 : 0;
                           return;
                        }

                        if (command == 3410) {
                           int i_124_ = intValues[--intValueIndex];
                           String string = stringValues[--stringValueIndex];
                           Class39 class39 = Class328.aClass362_4112.method4051(i_124_);
                           intValues[intValueIndex++] = class39.method404(string, (byte)91) ? 1 : 0;
                           return;
                        }

                        if (command == 3411) {
                           int i_125_ = intValues[--intValueIndex];
                           Class39 class39 = Class328.aClass362_4112.method4051(i_125_);
                           intValues[intValueIndex++] = class39.method411(0);
                           return;
                        }

                        if (command == 3412) {
                           intValueIndex -= 3;
                           int i_126_ = intValues[intValueIndex];
                           int i_127_ = intValues[intValueIndex + 1];
                           int i_128_ = intValues[intValueIndex + 2];
                           if (i_127_ == -1) {
                              throw new RuntimeException();
                           }

                           Class39 class39 = Class328.aClass362_4112.method4051(i_127_);
                           Node_Sub34 node_sub34 = class39.method406(-4, i_128_);
                           int i_129_ = 0;
                           if (node_sub34 != null) {
                              i_129_ = node_sub34.anIntArray7411.length;
                           }

                           intValues[intValueIndex++] = i_129_;
                           return;
                        }

                        if (command == 3413) {
                           int i_130_ = intValues[--intValueIndex];
                           String string = stringValues[--stringValueIndex];
                           if (i_130_ == -1) {
                              throw new RuntimeException();
                           }

                           Class39 class39 = Class328.aClass362_4112.method4051(i_130_);
                           Node_Sub20 node_sub20 = class39.method420(string, (byte)118);
                           int i_131_ = 0;
                           if (node_sub20 != null) {
                              i_131_ = node_sub20.anIntArray7177.length;
                           }

                           intValues[intValueIndex++] = i_131_;
                           return;
                        }

                        if (command == 3414) {
                           intValueIndex -= 5;
                           int i_132_ = intValues[intValueIndex];
                           int i_133_ = intValues[intValueIndex + 1];
                           int i_134_ = intValues[intValueIndex + 2];
                           int i_135_ = intValues[intValueIndex + 3];
                           int i_136_ = intValues[intValueIndex + 4];
                           if (i_134_ == -1) {
                              throw new RuntimeException();
                           }

                           Class39 class39 = Class328.aClass362_4112.method4051(i_134_);
                           Node_Sub34 node_sub34 = class39.method406(-4, i_135_);
                           if (i_136_ >= 0 && node_sub34 != null && node_sub34.anIntArray7411.length > i_136_) {
                              intValues[intValueIndex++] = node_sub34.anIntArray7411[i_136_];
                              return;
                           }

                           throw new RuntimeException();
                        }

                        if (command == 3415) {
                           intValueIndex -= 3;
                           int i_137_ = intValues[intValueIndex];
                           int i_138_ = intValues[intValueIndex + 1];
                           int i_139_ = intValues[intValueIndex + 2];
                           String string = stringValues[--stringValueIndex];
                           if (i_138_ == -1) {
                              throw new RuntimeException();
                           }

                           Class39 class39 = Class328.aClass362_4112.method4051(i_138_);
                           Node_Sub20 node_sub20 = class39.method420(string, (byte)119);
                           if (i_139_ >= 0 && node_sub20 != null && node_sub20.anIntArray7177.length > i_139_) {
                              intValues[intValueIndex++] = node_sub20.anIntArray7177[i_139_];
                              return;
                           }

                           throw new RuntimeException();
                        }
                     } else if (command < 3700) {
                        if (command == 3600) {
                           if (Class138.anInt1724 == 0) {
                              intValues[intValueIndex++] = -2;
                              return;
                           }

                           if (Class138.anInt1724 == 1) {
                              intValues[intValueIndex++] = -1;
                              return;
                           }

                           intValues[intValueIndex++] = Node_Sub38_Sub14.anInt10242;
                           return;
                        }

                        if (command == 3601) {
                           int i_140_ = intValues[--intValueIndex];
                           if (Class138.anInt1724 == 2 && i_140_ < Node_Sub38_Sub14.anInt10242) {
                              stringValues[stringValueIndex++] = Class262_Sub12.aStringArray7793[i_140_];
                              if (Plane.aStringArray3403[i_140_] != null) {
                                 stringValues[stringValueIndex++] = Plane.aStringArray3403[i_140_];
                              } else {
                                 stringValues[stringValueIndex++] = "";
                              }

                              return;
                           }

                           stringValues[stringValueIndex++] = "";
                           stringValues[stringValueIndex++] = "";
                           return;
                        }

                        if (command == 3602) {
                           int i_141_ = intValues[--intValueIndex];
                           if (Class138.anInt1724 == 2 && i_141_ < Node_Sub38_Sub14.anInt10242) {
                              intValues[intValueIndex++] = Class202.anIntArray2448[i_141_];
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3603) {
                           int i_142_ = intValues[--intValueIndex];
                           if (Class138.anInt1724 == 2 && i_142_ < Node_Sub38_Sub14.anInt10242) {
                              intValues[intValueIndex++] = Class380.anIntArray4887[i_142_];
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3604) {
                           String string = stringValues[--stringValueIndex];
                           int i_143_ = intValues[--intValueIndex];
                           Class188_Sub1_Sub2.method1901(string, -92, i_143_);
                           return;
                        }

                        if (command == 3605) {
                           String string = stringValues[--stringValueIndex];
                           Node_Sub38_Sub37.method2912(string, true);
                           return;
                        }

                        if (command == 3606) {
                           String string = stringValues[--stringValueIndex];
                           Node_Sub38_Sub8_Sub1.method2818(27, string);
                           return;
                        }

                        if (command == 3607) {
                           String string = stringValues[--stringValueIndex];
                           Class126.method1539(false, string, (byte)-54);
                           return;
                        }

                        if (command == 3608) {
                           String string = stringValues[--stringValueIndex];
                           za.method2991(string, true);
                           return;
                        }

                        if (command == 3609) {
                           String string = stringValues[--stringValueIndex];
                           if (string.startsWith("<img=0>") || string.startsWith("<img=1>")) {
                              string = string.substring(7);
                           }

                           intValues[intValueIndex++] = Class193.method1955(0, string) ? 1 : 0;
                           return;
                        }

                        if (command == 3610) {
                           int i_144_ = intValues[--intValueIndex];
                           if (Class138.anInt1724 == 2 && i_144_ < Node_Sub38_Sub14.anInt10242) {
                              stringValues[stringValueIndex++] = EntityNode_Sub3_Sub1.aStringArray9157[i_144_];
                              return;
                           }

                           stringValues[stringValueIndex++] = "";
                           return;
                        }

                        if (command == 3611) {
                           if (Class169_Sub4.clanChatDisplayName != null) {
                              stringValues[stringValueIndex++] = Class362.method4049(36, Class169_Sub4.clanChatDisplayName);
                              return;
                           }

                           stringValues[stringValueIndex++] = "";
                           return;
                        }

                        if (command == 3612) {
                           if (Class169_Sub4.clanChatDisplayName != null) {
                              intValues[intValueIndex++] = Node_Sub38_Sub37.anInt10473;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3613) {
                           int i_145_ = intValues[--intValueIndex];
                           if (Class169_Sub4.clanChatDisplayName != null && i_145_ < Node_Sub38_Sub37.anInt10473) {
                              stringValues[stringValueIndex++] = Class50.aClass211Array782[i_145_].aString2507;
                              return;
                           }

                           stringValues[stringValueIndex++] = "";
                           return;
                        }

                        if (command == 3614) {
                           int i_146_ = intValues[--intValueIndex];
                           if (Class169_Sub4.clanChatDisplayName != null && i_146_ < Node_Sub38_Sub37.anInt10473) {
                              intValues[intValueIndex++] = Class50.aClass211Array782[i_146_].anInt2505;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3615) {
                           int i_147_ = intValues[--intValueIndex];
                           if (Class169_Sub4.clanChatDisplayName != null && i_147_ < Node_Sub38_Sub37.anInt10473) {
                              intValues[intValueIndex++] = Class50.aClass211Array782[i_147_].aByte2503;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3616) {
                           intValues[intValueIndex++] = Node_Sub38_Sub34.aByte10445;
                           return;
                        }

                        if (command == 3617) {
                           String string = stringValues[--stringValueIndex];
                           Class66.method722(-124, string);
                           return;
                        }

                        if (command == 3618) {
                           intValues[intValueIndex++] = Class362.aByte4500;
                           return;
                        }

                        if (command == 3619) {
                           String string = stringValues[--stringValueIndex];
                           Class370.method4091(16, string);
                           return;
                        }

                        if (command == 3620) {
                           Node_Sub31.method2726(0);
                           return;
                        }

                        if (command == 3621) {
                           if (Class138.anInt1724 == 0) {
                              intValues[intValueIndex++] = -1;
                              return;
                           }

                           intValues[intValueIndex++] = Class235.anInt5122;
                           return;
                        }

                        if (command == 3622) {
                           int i_148_ = intValues[--intValueIndex];
                           if (Class138.anInt1724 != 0 && i_148_ < Class235.anInt5122) {
                              stringValues[stringValueIndex++] = Class338.aStringArray4197[i_148_];
                              if (Class7.aStringArray164[i_148_] != null) {
                                 stringValues[stringValueIndex++] = Class7.aStringArray164[i_148_];
                              } else {
                                 stringValues[stringValueIndex++] = "";
                              }

                              return;
                           }

                           stringValues[stringValueIndex++] = "";
                           stringValues[stringValueIndex++] = "";
                           return;
                        }

                        if (command == 3623) {
                           String string = stringValues[--stringValueIndex];
                           if (string.startsWith("<img=0>") || string.startsWith("<img=1>")) {
                              string = string.substring(7);
                           }

                           intValues[intValueIndex++] = Node_Sub6.method2418(-27891, string) ? 1 : 0;
                           return;
                        }

                        if (command == 3624) {
                           int i_149_ = intValues[--intValueIndex];
                           if (Class50.aClass211Array782 != null
                              && i_149_ < Node_Sub38_Sub37.anInt10473
                              && Class50.aClass211Array782[i_149_].aString2506.equalsIgnoreCase(Class295.myPlayer.aString11142)) {
                              intValues[intValueIndex++] = 1;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3625) {
                           if (Class88.friendsChatOwner != null) {
                              stringValues[stringValueIndex++] = Class88.friendsChatOwner;
                              return;
                           }

                           stringValues[stringValueIndex++] = "";
                           return;
                        }

                        if (command == 3626) {
                           int i_150_ = intValues[--intValueIndex];
                           if (Class169_Sub4.clanChatDisplayName != null && i_150_ < Node_Sub38_Sub37.anInt10473) {
                              stringValues[stringValueIndex++] = Class50.aClass211Array782[i_150_].aString2504;
                              return;
                           }

                           stringValues[stringValueIndex++] = "";
                           return;
                        }

                        if (command == 3627) {
                           int i_151_ = intValues[--intValueIndex];
                           if (Class138.anInt1724 == 2 && i_151_ >= 0 && i_151_ < Node_Sub38_Sub14.anInt10242) {
                              intValues[intValueIndex++] = Class330.aBooleanArray4127[i_151_] ? 1 : 0;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3628) {
                           String string = stringValues[--stringValueIndex];
                           if (string.startsWith("<img=0>") || string.startsWith("<img=1>")) {
                              string = string.substring(7);
                           }

                           intValues[intValueIndex++] = Class355.method4020(-100, string);
                           return;
                        }

                        if (command == 3629) {
                           intValues[intValueIndex++] = Class320_Sub27.anInt8460;
                           return;
                        }

                        if (command == 3630) {
                           String string = stringValues[--stringValueIndex];
                           Class126.method1539(true, string, (byte)-54);
                           return;
                        }

                        if (command == 3631) {
                           int i_152_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = CacheNode_Sub4.aBooleanArray9454[i_152_] ? 1 : 0;
                           return;
                        }

                        if (command == 3632) {
                           int i_153_ = intValues[--intValueIndex];
                           if (Class169_Sub4.clanChatDisplayName != null && i_153_ < Node_Sub38_Sub37.anInt10473) {
                              stringValues[stringValueIndex++] = Class50.aClass211Array782[i_153_].aString2506;
                              return;
                           }

                           stringValues[stringValueIndex++] = "";
                           return;
                        }

                        if (command == 3633) {
                           int i_154_ = intValues[--intValueIndex];
                           if (Class138.anInt1724 != 0 && i_154_ < Class235.anInt5122) {
                              stringValues[stringValueIndex++] = Class240.aStringArray2949[i_154_];
                              return;
                           }

                           stringValues[stringValueIndex++] = "";
                           return;
                        }

                        if (command == 3634) {
                           int i_155_ = intValues[--intValueIndex];
                           if (Class138.anInt1724 == 2 && i_155_ < Node_Sub38_Sub14.anInt10242) {
                              intValues[intValueIndex++] = Class232.aBooleanArray2781[i_155_] ? 1 : 0;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }
                     } else if (command < 3800) {
                        if (command == 3700) {
                           if (Class51.playerGuestClan != null) {
                              intValues[intValueIndex++] = 1;
                              aClanChat3860 = Class51.playerGuestClan;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3701) {
                           if (Class66.playerOwnedClan != null) {
                              intValues[intValueIndex++] = 1;
                              aClanChat3860 = Class66.playerOwnedClan;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3702) {
                           stringValues[stringValueIndex++] = aClanChat3860.aString763;
                           return;
                        }

                        if (command == 3703) {
                           intValues[intValueIndex++] = aClanChat3860.aBoolean750 ? 1 : 0;
                           return;
                        }

                        if (command == 3704) {
                           intValues[intValueIndex++] = aClanChat3860.aByte751;
                           return;
                        }

                        if (command == 3705) {
                           intValues[intValueIndex++] = aClanChat3860.aByte748;
                           return;
                        }

                        if (command == 3706) {
                           intValues[intValueIndex++] = aClanChat3860.aByte738;
                           return;
                        }

                        if (command == 3707) {
                           intValues[intValueIndex++] = aClanChat3860.aByte724;
                           return;
                        }

                        if (command == 3709) {
                           intValues[intValueIndex++] = aClanChat3860.anInt734;
                           return;
                        }

                        if (command == 3710) {
                           int i_156_ = intValues[--intValueIndex];
                           stringValues[stringValueIndex++] = aClanChat3860.aStringArray740[i_156_];
                           return;
                        }

                        if (command == 3711) {
                           int i_157_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = aClanChat3860.aByteArray770[i_157_];
                           return;
                        }

                        if (command == 3712) {
                           intValues[intValueIndex++] = aClanChat3860.anInt739;
                           return;
                        }

                        if (command == 3713) {
                           int i_158_ = intValues[--intValueIndex];
                           stringValues[stringValueIndex++] = aClanChat3860.aStringArray769[i_158_];
                           return;
                        }

                        if (command == 3714) {
                           intValueIndex -= 3;
                           int i_159_ = intValues[intValueIndex];
                           int i_160_ = intValues[intValueIndex + 1];
                           int i_161_ = intValues[intValueIndex + 2];
                           intValues[intValueIndex++] = aClanChat3860.method508(i_160_, -23948, i_161_, i_159_);
                           return;
                        }

                        if (command == 3715) {
                           intValues[intValueIndex++] = aClanChat3860.anInt765;
                           return;
                        }

                        if (command == 3716) {
                           intValues[intValueIndex++] = aClanChat3860.anInt749;
                           return;
                        }

                        if (command == 3717) {
                           intValues[intValueIndex++] = aClanChat3860.method490(stringValues[--stringValueIndex], (byte)114);
                           return;
                        }

                        if (command == 3718) {
                           intValues[intValueIndex - 1] = aClanChat3860.method498(94)[intValues[intValueIndex - 1]];
                           return;
                        }

                        if (command == 3719) {
                           Class262_Sub4.method3159(7, intValues[--intValueIndex]);
                           return;
                        }

                        if (command == 3720) {
                           int i_162_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = aClanChat3860.anIntArray737[i_162_];
                           return;
                        }

                        if (command == 3750) {
                           if (ItemDefinitions.aNode_Sub43_1925 != null) {
                              intValues[intValueIndex++] = 1;
                              aNode_Sub43_3857 = ItemDefinitions.aNode_Sub43_1925;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3751) {
                           if (Class29.aNode_Sub43_477 != null) {
                              intValues[intValueIndex++] = 1;
                              aNode_Sub43_3857 = Class29.aNode_Sub43_477;
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 3752) {
                           stringValues[stringValueIndex++] = aNode_Sub43_3857.aString7544;
                           return;
                        }

                        if (command == 3753) {
                           intValues[intValueIndex++] = aNode_Sub43_3857.aByte7532;
                           return;
                        }

                        if (command == 3754) {
                           intValues[intValueIndex++] = aNode_Sub43_3857.aByte7540;
                           return;
                        }

                        if (command == 3755) {
                           intValues[intValueIndex++] = aNode_Sub43_3857.anInt7531;
                           return;
                        }

                        if (command == 3756) {
                           int i_163_ = intValues[--intValueIndex];
                           stringValues[stringValueIndex++] = aNode_Sub43_3857.aClass24Array7533[i_163_].aString437;
                           return;
                        }

                        if (command == 3757) {
                           int i_164_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = aNode_Sub43_3857.aClass24Array7533[i_164_].aByte438;
                           return;
                        }

                        if (command == 3758) {
                           int i_165_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = aNode_Sub43_3857.aClass24Array7533[i_165_].anInt441;
                           return;
                        }

                        if (command == 3759) {
                           int i_166_ = intValues[--intValueIndex];
                           Class277.method3344(1420162185, aNode_Sub43_3857 == Class29.aNode_Sub43_477, i_166_);
                           return;
                        }

                        if (command == 3760) {
                           intValues[intValueIndex++] = aNode_Sub43_3857.method2943(stringValues[--stringValueIndex], (byte)-93);
                           return;
                        }

                        if (command == 3761) {
                           intValues[intValueIndex - 1] = aNode_Sub43_3857.method2937(8669)[intValues[intValueIndex - 1]];
                           return;
                        }

                        if (command == 3790) {
                           intValues[intValueIndex++] = Class147.anObjectArray1821 != null ? 1 : 0;
                           return;
                        }
                     } else if (command < 4000) {
                        if (command == 3903) {
                           int i_167_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Node_Sub15_Sub2.aClass138Array9784[i_167_].method1601(false);
                           return;
                        }

                        if (command == 3904) {
                           int i_168_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Node_Sub15_Sub2.aClass138Array9784[i_168_].anInt1721;
                           return;
                        }

                        if (command == 3905) {
                           int i_169_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Node_Sub15_Sub2.aClass138Array9784[i_169_].anInt1729;
                           return;
                        }

                        if (command == 3906) {
                           int i_170_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Node_Sub15_Sub2.aClass138Array9784[i_170_].anInt1722;
                           return;
                        }

                        if (command == 3907) {
                           int i_171_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Node_Sub15_Sub2.aClass138Array9784[i_171_].anInt1723;
                           return;
                        }

                        if (command == 3908) {
                           int i_172_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Node_Sub15_Sub2.aClass138Array9784[i_172_].anInt1720;
                           return;
                        }

                        if (command == 3910) {
                           int i_173_ = intValues[--intValueIndex];
                           int i_174_ = Node_Sub15_Sub2.aClass138Array9784[i_173_].method1602(28771);
                           intValues[intValueIndex++] = i_174_ == 0 ? 1 : 0;
                           return;
                        }

                        if (command == 3911) {
                           int i_175_ = intValues[--intValueIndex];
                           int i_176_ = Node_Sub15_Sub2.aClass138Array9784[i_175_].method1602(28771);
                           intValues[intValueIndex++] = i_176_ == 2 ? 1 : 0;
                           return;
                        }

                        if (command == 3912) {
                           int i_177_ = intValues[--intValueIndex];
                           int i_178_ = Node_Sub15_Sub2.aClass138Array9784[i_177_].method1602(28771);
                           intValues[intValueIndex++] = i_178_ == 5 ? 1 : 0;
                           return;
                        }

                        if (command == 3913) {
                           int i_179_ = intValues[--intValueIndex];
                           int i_180_ = Node_Sub15_Sub2.aClass138Array9784[i_179_].method1602(28771);
                           intValues[intValueIndex++] = i_180_ == 1 ? 1 : 0;
                           return;
                        }
                     } else if (command < 4100) {
                        if (command == 4000) {
                           intValueIndex -= 2;
                           int i_181_ = intValues[intValueIndex];
                           int i_182_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = i_181_ + i_182_;
                           return;
                        }

                        if (command == 4001) {
                           intValueIndex -= 2;
                           int i_183_ = intValues[intValueIndex];
                           int i_184_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = i_183_ - i_184_;
                           return;
                        }

                        if (command == 4002) {
                           intValueIndex -= 2;
                           int i_185_ = intValues[intValueIndex];
                           int i_186_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = i_185_ * i_186_;
                           return;
                        }

                        if (command == 4003) {
                           intValueIndex -= 2;
                           int i_187_ = intValues[intValueIndex];
                           int i_188_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = i_187_ / i_188_;
                           return;
                        }

                        if (command == 4004) {
                           int i_189_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = (int)(Math.random() * (double)i_189_);
                           return;
                        }

                        if (command == 4005) {
                           int i_190_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = (int)(Math.random() * (double)(i_190_ + 1));
                           return;
                        }

                        if (command == 4006) {
                           intValueIndex -= 5;
                           int i_191_ = intValues[intValueIndex];
                           int i_192_ = intValues[intValueIndex + 1];
                           int i_193_ = intValues[intValueIndex + 2];
                           int i_194_ = intValues[intValueIndex + 3];
                           int i_195_ = intValues[intValueIndex + 4];
                           intValues[intValueIndex++] = i_191_ + (i_192_ - i_191_) * (i_195_ - i_193_) / (i_194_ - i_193_);
                           return;
                        }

                        if (command == 4007) {
                           intValueIndex -= 2;
                           long l = (long)intValues[intValueIndex];
                           long l_196_ = (long)intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = (int)(l + l * l_196_ / 100L);
                           return;
                        }

                        if (command == 4008) {
                           intValueIndex -= 2;
                           int i_197_ = intValues[intValueIndex];
                           int i_198_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = i_197_ | 1 << i_198_;
                           return;
                        }

                        if (command == 4009) {
                           intValueIndex -= 2;
                           int i_199_ = intValues[intValueIndex];
                           int i_200_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = i_199_ & -1 - (1 << i_200_);
                           return;
                        }

                        if (command == 4010) {
                           intValueIndex -= 2;
                           int i_201_ = intValues[intValueIndex];
                           int i_202_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = (i_201_ & 1 << i_202_) != 0 ? 1 : 0;
                           return;
                        }

                        if (command == 4011) {
                           intValueIndex -= 2;
                           int i_203_ = intValues[intValueIndex];
                           int i_204_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = i_203_ % i_204_;
                           return;
                        }

                        if (command == 4012) {
                           intValueIndex -= 2;
                           int i_205_ = intValues[intValueIndex];
                           int i_206_ = intValues[intValueIndex + 1];
                           if (i_205_ == 0) {
                              intValues[intValueIndex++] = 0;
                              return;
                           }

                           intValues[intValueIndex++] = (int)Math.pow((double)i_205_, (double)i_206_);
                           return;
                        }

                        if (command == 4013) {
                           intValueIndex -= 2;
                           int i_207_ = intValues[intValueIndex];
                           int i_208_ = intValues[intValueIndex + 1];
                           if (i_207_ == 0) {
                              intValues[intValueIndex++] = 0;
                              return;
                           }

                           if (i_208_ == 0) {
                              intValues[intValueIndex++] = Integer.MAX_VALUE;
                              return;
                           }

                           intValues[intValueIndex++] = (int)Math.pow((double)i_207_, 1.0 / (double)i_208_);
                           return;
                        }

                        if (command == 4014) {
                           intValueIndex -= 2;
                           int i_209_ = intValues[intValueIndex];
                           int i_210_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = i_209_ & i_210_;
                           return;
                        }

                        if (command == 4015) {
                           intValueIndex -= 2;
                           int i_211_ = intValues[intValueIndex];
                           int i_212_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = i_211_ | i_212_;
                           return;
                        }

                        if (command == 4016) {
                           intValueIndex -= 2;
                           int i_213_ = intValues[intValueIndex];
                           int i_214_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = i_213_ < i_214_ ? i_213_ : i_214_;
                           return;
                        }

                        if (command == 4017) {
                           intValueIndex -= 2;
                           int i_215_ = intValues[intValueIndex];
                           int i_216_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = i_215_ > i_216_ ? i_215_ : i_216_;
                           return;
                        }

                        if (command == 4018) {
                           intValueIndex -= 3;
                           long l = (long)intValues[intValueIndex];
                           long l_217_ = (long)intValues[intValueIndex + 1];
                           long l_218_ = (long)intValues[intValueIndex + 2];
                           intValues[intValueIndex++] = (int)(l * l_218_ / l_217_);
                           return;
                        }

                        if (command == 4019) {
                           intValueIndex -= 2;
                           int i_219_ = intValues[intValueIndex];
                           int i_220_ = intValues[intValueIndex + 1];
                           if (i_219_ > 700 || i_220_ > 700) {
                              intValues[intValueIndex++] = 256;
                           }

                           double d = (Math.random() * (double)(i_220_ + i_219_) - (double)i_219_ + 800.0) / 100.0;
                           intValues[intValueIndex++] = (int)(Math.pow(2.0, d) + 0.5);
                           return;
                        }

                        if (command == 4020) {
                           int i_221_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Class170.anIntArray2054[Node_Sub15_Sub2.method2560(5310, i_221_) & '\uffff'];
                           return;
                        }
                     } else if (command < 4200) {
                        if (command == 4100) {
                           String string = stringValues[--stringValueIndex];
                           int i_222_ = intValues[--intValueIndex];
                           stringValues[stringValueIndex++] = string + i_222_;
                           return;
                        }

                        if (command == 4101) {
                           stringValueIndex -= 2;
                           String string = stringValues[stringValueIndex];
                           String string_223_ = stringValues[stringValueIndex + 1];
                           stringValues[stringValueIndex++] = string + string_223_;
                           return;
                        }

                        if (command == 4102) {
                           String string = stringValues[--stringValueIndex];
                           int i_224_ = intValues[--intValueIndex];
                           stringValues[stringValueIndex++] = string + Node_Sub29_Sub2.method2715((byte)9, true, i_224_);
                           return;
                        }

                        if (command == 4103) {
                           String string = stringValues[--stringValueIndex];
                           stringValues[stringValueIndex++] = string.toLowerCase();
                           return;
                        }

                        if (command == 4104) {
                           stringValues[stringValueIndex++] = GLToolkit.method1437(
                              17578, Class35.language, Class25.method308(intValues[--intValueIndex], false)
                           );
                           return;
                        }

                        if (command == 4105) {
                           stringValueIndex -= 2;
                           String string = stringValues[stringValueIndex];
                           String string_225_ = stringValues[stringValueIndex + 1];
                           if (Class295.myPlayer.aPlayerDefinition11137 != null && Class295.myPlayer.aPlayerDefinition11137.aBoolean3434) {
                              stringValues[stringValueIndex++] = string_225_;
                              return;
                           }

                           stringValues[stringValueIndex++] = string;
                           return;
                        }

                        if (command == 4106) {
                           int i_226_ = intValues[--intValueIndex];
                           stringValues[stringValueIndex++] = Integer.toString(i_226_);
                           return;
                        }

                        if (command == 4107) {
                           stringValueIndex -= 2;
                           intValues[intValueIndex++] = r.method2359(
                              stringValues[stringValueIndex + 1], (byte)-4, Class35.language, stringValues[stringValueIndex]
                           );
                           return;
                        }

                        if (command == 4108) {
                           String string = stringValues[--stringValueIndex];
                           intValueIndex -= 2;
                           int i_227_ = intValues[intValueIndex];
                           int i_228_ = intValues[intValueIndex + 1];
                           Class357 class357 = Class44.method461(0, 19, i_228_, AnimableAnimator_Sub1.index13);
                           intValues[intValueIndex++] = class357.method4028(string, Node_Sub52.aGLSpriteArray7655, (byte)-46, i_227_);
                           return;
                        }

                        if (command == 4109) {
                           String string = stringValues[--stringValueIndex];
                           intValueIndex -= 2;
                           int i_229_ = intValues[intValueIndex];
                           int i_230_ = intValues[intValueIndex + 1];
                           Class357 class357 = Class44.method461(0, 123, i_230_, AnimableAnimator_Sub1.index13);
                           intValues[intValueIndex++] = class357.method4030(Node_Sub52.aGLSpriteArray7655, 0, string, i_229_);
                           return;
                        }

                        if (command == 4110) {
                           stringValueIndex -= 2;
                           String string = stringValues[stringValueIndex];
                           String string_231_ = stringValues[stringValueIndex + 1];
                           if (intValues[--intValueIndex] == 1) {
                              stringValues[stringValueIndex++] = string;
                              return;
                           }

                           stringValues[stringValueIndex++] = string_231_;
                           return;
                        }

                        if (command == 4111) {
                           String string = stringValues[--stringValueIndex];
                           stringValues[stringValueIndex++] = Class67.method730(false, string);
                           return;
                        }

                        if (command == 4112) {
                           String string = stringValues[--stringValueIndex];
                           int i_232_ = intValues[--intValueIndex];
                           if (i_232_ == -1) {
                              throw new RuntimeException("null char");
                           }

                           stringValues[stringValueIndex++] = string + (char)i_232_;
                           return;
                        }

                        if (command == 4113) {
                           int i_233_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = method3559((char)i_233_);
                           return;
                        }

                        if (command == 4114) {
                           int i_234_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Class316.method3662(false, (char)i_234_) ? 1 : 0;
                           return;
                        }

                        if (command == 4115) {
                           int i_235_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Class134.method1567((char)i_235_, 4493) ? 1 : 0;
                           return;
                        }

                        if (command == 4116) {
                           int i_236_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Animable_Sub4_Sub1.method930(-31853, (char)i_236_) ? 1 : 0;
                           return;
                        }

                        if (command == 4117) {
                           String string = stringValues[--stringValueIndex];
                           if (string != null) {
                              intValues[intValueIndex++] = string.length();
                              return;
                           }

                           intValues[intValueIndex++] = 0;
                           return;
                        }

                        if (command == 4118) {
                           String string = stringValues[--stringValueIndex];
                           intValueIndex -= 2;
                           int i_237_ = intValues[intValueIndex];
                           int i_238_ = intValues[intValueIndex + 1];
                           stringValues[stringValueIndex++] = string.substring(i_237_, i_238_);
                           return;
                        }

                        if (command == 4119) {
                           String string = stringValues[--stringValueIndex];
                           StringBuffer stringbuffer = new StringBuffer(string.length());
                           boolean dontInclude = false;

                           for(int i_240_ = 0; i_240_ < string.length(); ++i_240_) {
                              char c = string.charAt(i_240_);
                              if (c == '<') {
                                 dontInclude = true;
                              } else if (c == '>') {
                                 dontInclude = false;
                              } else if (!dontInclude) {
                                 stringbuffer.append(c);
                              }
                           }

                           stringValues[stringValueIndex++] = stringbuffer.toString();
                           return;
                        }

                        if (command == 4120) {
                           String string = stringValues[--stringValueIndex];
                           intValueIndex -= 2;
                           int i_241_ = intValues[intValueIndex];
                           int i_242_ = intValues[intValueIndex + 1];
                           intValues[intValueIndex++] = string.indexOf(i_241_, i_242_);
                           return;
                        }

                        if (command == 4121) {
                           stringValueIndex -= 2;
                           String string = stringValues[stringValueIndex];
                           String string_243_ = stringValues[stringValueIndex + 1];
                           int i_244_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = string.indexOf(string_243_, i_244_);
                           return;
                        }

                        if (command == 4122) {
                           int i_245_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Character.toLowerCase((char)i_245_);
                           return;
                        }

                        if (command == 4123) {
                           int i_246_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Character.toUpperCase((char)i_246_);
                           return;
                        }

                        if (command == 4124) {
                           boolean bool_247_ = intValues[--intValueIndex] != 0;
                           int i_248_ = intValues[--intValueIndex];
                           stringValues[stringValueIndex++] = Class301.method3503(Class35.language, bool_247_, (long)i_248_, 0, true);
                           return;
                        }

                        if (command == 4125) {
                           String string = stringValues[--stringValueIndex];
                           int i_249_ = intValues[--intValueIndex];
                           Class357 class357 = Class44.method461(0, 120, i_249_, AnimableAnimator_Sub1.index13);
                           intValues[intValueIndex++] = class357.method4031(104, Node_Sub52.aGLSpriteArray7655, string);
                           return;
                        }

                        if (command == 4126) {
                           stringValues[stringValueIndex++] = Class350.method3999((long)intValues[--intValueIndex] * 60000L, true, Class35.language, 1)
                              + " UTC";
                           return;
                        }

                        if (command == 4127) {
                           long l = longValues[--longValueIndex];
                           stringValues[stringValueIndex++] = l == -1L ? "" : Long.toString(l, 36).toUpperCase();
                           return;
                        }

                        if (command == 4128) {
                           String string = stringValues[--stringValueIndex];
                           int i_222_ = intValues[--intValueIndex];
                           stringValues[stringValueIndex++] = i_222_ + string;
                           return;
                        }

                        if (command == 4129) {
                           intValueIndex -= 3;
                           int red = intValues[intValueIndex];
                           int green = intValues[intValueIndex + 1];
                           int blue = intValues[intValueIndex + 2];
                           String hex = String.format("%02X%02X%02X", red, green, blue);
                           intValues[intValueIndex++] = Integer.parseInt(hex, 16);
                           return;
                        }
                     } else if (command < 4300) {
                        if (command == 4200) {
                           int i_250_ = intValues[--intValueIndex];
                           stringValues[stringValueIndex++] = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(i_250_).name;
                           return;
                        }

                        if (command == 4201) {
                           intValueIndex -= 2;
                           int i_251_ = intValues[intValueIndex];
                           int i_252_ = intValues[intValueIndex + 1];
                           ItemDefinitions itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(i_251_);
                           if (i_252_ >= 1 && i_252_ <= 5 && itemdefinition.groundOptions[i_252_ - 1] != null) {
                              stringValues[stringValueIndex++] = itemdefinition.groundOptions[i_252_ - 1];
                              return;
                           }

                           stringValues[stringValueIndex++] = "";
                           return;
                        }

                        if (command == 4202) {
                           intValueIndex -= 2;
                           int i_253_ = intValues[intValueIndex];
                           int i_254_ = intValues[intValueIndex + 1];
                           ItemDefinitions itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(i_253_);
                           if (i_254_ >= 1 && i_254_ <= 5 && itemdefinition.inventoryOptions[i_254_ - 1] != null) {
                              stringValues[stringValueIndex++] = itemdefinition.inventoryOptions[i_254_ - 1];
                              return;
                           }

                           stringValues[stringValueIndex++] = "";
                           return;
                        }

                        if (command == 4203) {
                           int i_255_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(i_255_).value;
                           return;
                        }

                        if (command == 4204) {
                           int i_256_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(i_256_).stackable == 1 ? 1 : 0;
                           return;
                        }

                        if (command == 4205) {
                           int i_257_ = intValues[--intValueIndex];
                           ItemDefinitions itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(i_257_);
                           if (itemdefinition.certTemplateId == -1 && itemdefinition.certId >= 0) {
                              intValues[intValueIndex++] = itemdefinition.certId;
                              return;
                           }

                           intValues[intValueIndex++] = i_257_;
                           return;
                        }

                        if (command == 4206) {
                           int i_258_ = intValues[--intValueIndex];
                           ItemDefinitions itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(i_258_);
                           if (itemdefinition.certTemplateId >= 0 && itemdefinition.certId >= 0) {
                              intValues[intValueIndex++] = itemdefinition.certId;
                              return;
                           }

                           intValues[intValueIndex++] = i_258_;
                           return;
                        }

                        if (command == 4207) {
                           int i_259_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(i_259_).membersOnly ? 1 : 0;
                           return;
                        }

                        if (command == 4208) {
                           intValueIndex -= 2;
                           int i_260_ = intValues[intValueIndex];
                           int i_261_ = intValues[intValueIndex + 1];
                           Class267 class267 = Class188_Sub2_Sub2.aClass36_9366.method394(i_261_, -82);
                           if (class267.method3287((byte)99)) {
                              stringValues[stringValueIndex++] = EntityNode_Sub3_Sub1.aClass86_9166
                                 .getItemDefinitionForId(i_260_)
                                 .method1684(class267.aString3450, -32525, i_261_);
                              return;
                           }

                           intValues[intValueIndex++] = EntityNode_Sub3_Sub1.aClass86_9166
                              .getItemDefinitionForId(i_260_)
                              .method1678(i_261_, class267.anInt3443, 10247);
                           return;
                        }

                        if (command == 4209) {
                           intValueIndex -= 2;
                           int i_262_ = intValues[intValueIndex];
                           int i_263_ = intValues[intValueIndex + 1] - 1;
                           ItemDefinitions itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(i_262_);
                           if (itemdefinition.indexOfInventoryOptionSprite1 == i_263_) {
                              intValues[intValueIndex++] = itemdefinition.inventoryOptionSprite1;
                              return;
                           }

                           if (itemdefinition.indexOfInventoryOptionSprite2 == i_263_) {
                              intValues[intValueIndex++] = itemdefinition.inventoryOptionSprite2;
                              return;
                           }

                           intValues[intValueIndex++] = -1;
                           return;
                        }

                        if (command == 4210) {
                           String string = stringValues[--stringValueIndex];
                           int i_264_ = intValues[--intValueIndex];
                           Class173.method1799(i_264_ == 1, string, (byte)-96);
                           intValues[intValueIndex++] = Class365_Sub1.anInt8759;
                           return;
                        }

                        if (command == 4211) {
                           if (Node_Sub20.aShortArray7175 != null && Animable_Sub1.anInt9096 < Class365_Sub1.anInt8759) {
                              intValues[intValueIndex++] = Node_Sub20.aShortArray7175[Animable_Sub1.anInt9096++] & '\uffff';
                              return;
                           }

                           intValues[intValueIndex++] = -1;
                           return;
                        }

                        if (command == 4212) {
                           Animable_Sub1.anInt9096 = 0;
                           return;
                        }

                        if (command == 4213) {
                           int i_265_ = intValues[--intValueIndex];
                           intValues[intValueIndex++] = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(i_265_).unknownInt11;
                           return;
                        }

                        if (command == 4214) {
                           String string = stringValues[--stringValueIndex];
                           intValueIndex -= 3;
                           int i_266_ = intValues[intValueIndex];
                           int i_267_ = intValues[intValueIndex + 1];
                           int i_268_ = intValues[intValueIndex + 2];
                           Class142.method1620(i_266_ == 1, 117, i_268_, i_267_, string);
                           intValues[intValueIndex++] = Class365_Sub1.anInt8759;
                           return;
                        }

                        if (command == 4215) {
                           stringValueIndex -= 2;
                           intValueIndex -= 2;
                           String string = stringValues[stringValueIndex];
                           int i_269_ = intValues[intValueIndex];
                           int i_270_ = intValues[intValueIndex + 1];
                           String string_271_ = stringValues[stringValueIndex + 1];
                           Class380.method4170(string, i_270_, string_271_, 8, i_269_ == 1);
                           intValues[intValueIndex++] = Class365_Sub1.anInt8759;
                           return;
                        }
                     } else if (command < 4400) {
                        if (command == 4300) {
                           intValueIndex -= 2;
                           int npcId = intValues[intValueIndex];
                           int key = intValues[intValueIndex + 1];
                           Class267 class267 = Class188_Sub2_Sub2.aClass36_9366.method394(key, -121);
                           if (class267.method3287((byte)-88)) {
                              stringValues[stringValueIndex++] = Class366.aClass279_4526
                                 .getNPCDefinitions(npcId, (byte)107)
                                 .method3005((byte)-124, class267.aString3450, key);
                              return;
                           }

                           intValues[intValueIndex++] = Class366.aClass279_4526.getNPCDefinitions(npcId, (byte)107).method3009(66, key, class267.anInt3443);
                           return;
                        }
                     } else if (command < 4500) {
                        if (command == 4400) {
                           intValueIndex -= 2;
                           int i_274_ = intValues[intValueIndex];
                           int i_275_ = intValues[intValueIndex + 1];
                           Class267 class267 = Class188_Sub2_Sub2.aClass36_9366.method394(i_275_, -89);
                           if (class267.method3287((byte)-50)) {
                              stringValues[stringValueIndex++] = Class186.aClass112_2256
                                 .getObjectDefinitionsForId(i_274_, 46)
                                 .method3034(class267.aString3450, i_275_, false);
                              return;
                           }

                           intValues[intValueIndex++] = Class186.aClass112_2256
                              .getObjectDefinitionsForId(i_274_, 59)
                              .method3053(class267.anInt3443, 53, i_275_);
                           return;
                        }
                     } else if (command < 4600) {
                        if (command == 4500) {
                           intValueIndex -= 2;
                           int i_276_ = intValues[intValueIndex];
                           int i_277_ = intValues[intValueIndex + 1];
                           Class267 class267 = Class188_Sub2_Sub2.aClass36_9366.method394(i_277_, -121);
                           if (class267.method3287((byte)-78)) {
                              stringValues[stringValueIndex++] = Node_Sub9_Sub4.aClass180_9727
                                 .method1821(24, i_276_)
                                 .method2284(i_277_, class267.aString3450, 27908);
                              return;
                           }

                           intValues[intValueIndex++] = Node_Sub9_Sub4.aClass180_9727.method1821(24, i_276_).method2282(class267.anInt3443, 86, i_277_);
                           return;
                        }
                     } else if (command < 4700) {
                        if (command == 4600) {
                           int i_278_ = intValues[--intValueIndex];
                           RenderDefinitions animationDefs = InputStream_Sub2.aClass281_83.getAnimationAndSoundDefinitionsFor(i_278_);
                           if (animationDefs.anIntArray3294 != null && animationDefs.anIntArray3294.length > 0) {
                              int i_279_ = 0;
                              int i_280_ = animationDefs.anIntArray3302[0];

                              for(int i_281_ = 1; i_281_ < animationDefs.anIntArray3294.length; ++i_281_) {
                                 if (animationDefs.anIntArray3302[i_281_] > i_280_) {
                                    i_279_ = i_281_;
                                    i_280_ = animationDefs.anIntArray3302[i_281_];
                                 }
                              }

                              intValues[intValueIndex++] = animationDefs.anIntArray3294[i_279_];
                              return;
                           }

                           intValues[intValueIndex++] = animationDefs.idleAnimation;
                           return;
                        }

                        if (command == 4601) {
                           int npcId = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Class366.aClass279_4526.getNPCDefinitions(npcId, (byte)107).renderEmote;
                           return;
                        }

                        if (command == 4603) {
                           int objectId = intValues[--intValueIndex];
                           intValues[intValueIndex++] = Class186.aClass112_2256.getObjectDefinitionsForId(objectId, 42).getFirstAnimation();
                           return;
                        }

                        if (command == 4602) {
                           int animation = intValues[--intValueIndex];

                           for(int i = 0; i < 30000; ++i) {
                              RenderDefinitions animationDefs = InputStream_Sub2.aClass281_83.getAnimationAndSoundDefinitionsFor(i);
                              if (animationDefs.idleAnimation == animation) {
                                 intValues[intValueIndex++] = i;
                                 return;
                              }

                              if (animationDefs.anIntArray3294 != null && animationDefs.anIntArray3294.length > 0) {
                                 for(int j : animationDefs.anIntArray3294) {
                                    if (j == animation) {
                                       intValues[intValueIndex++] = i;
                                       return;
                                    }
                                 }
                              }
                           }

                           return;
                        }
                     } else if (command < 4800) {
                        if (command == 4700) {
                           intValues[intValueIndex++] = Class312.aBoolean3960 ? 1 : 0;
                           return;
                        }

                        if (command == 4701) {
                           String string = stringValues[--stringValueIndex];
                           if (Class151.anInt1843 == 7 && !Class132.method1561(-1)) {
                              if (string.length() > 20) {
                                 Class144_Sub3.aByte6822 = -4;
                                 return;
                              }

                              Class144_Sub3.aByte6822 = -1;
                              OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class232.aClass318_2772, Class218.aClass123_2560.issacKeys);
                              node_sub13.currentOutgoingPacket.writeByte(0);
                              int i_282_ = node_sub13.currentOutgoingPacket.offset;
                              node_sub13.currentOutgoingPacket.writeString(string);
                              node_sub13.currentOutgoingPacket.method2217(node_sub13.currentOutgoingPacket.offset - i_282_);
                              Class218.aClass123_2560.sendPacket(126, node_sub13);
                              return;
                           }

                           Class144_Sub3.aByte6822 = -5;
                           return;
                        }

                        if (command == 4702) {
                           intValues[intValueIndex++] = Class144_Sub3.aByte6822;
                           if (Class144_Sub3.aByte6822 != -1) {
                              Class144_Sub3.aByte6822 = -6;
                           }

                           return;
                        }
                     }
                  } else {
                     IComponentDefinitions widget;
                     if (command >= 2000) {
                        widget = Class76.getInterfaceFromHash((byte)107, intValues[--intValueIndex]);
                        command -= 1000;
                     } else {
                        widget = bool ? aWidget3865 : aWidget3849;
                     }

                     if (anInt3869 >= 10) {
                        throw new RuntimeException("C29xx-1");
                     }

                     if (command == 1927) {
                        if (widget.anObjectArray4777 != null) {
                           Node_Sub37 node_sub37 = new Node_Sub37();
                           node_sub37.aWidget7437 = widget;
                           node_sub37.parameters = widget.anObjectArray4777;
                           node_sub37.anInt7442 = anInt3869 + 1;
                           Class275.aClass312_5419.method3625((byte)-54, node_sub37);
                           return;
                        }

                        return;
                     }
                  }
               } else {
                  IComponentDefinitions widget;
                  if (command >= 2000) {
                     command -= 1000;
                     widget = Class76.getInterfaceFromHash((byte)107, intValues[--intValueIndex]);
                  } else {
                     widget = bool ? aWidget3865 : aWidget3849;
                  }

                  if (command == 1300) {
                     int slot = intValues[--intValueIndex] - 1;
                     if (slot >= 0 && slot <= 9) {
                        widget.setRightClickOption(stringValues[--stringValueIndex], slot);
                        return;
                     }

                     --stringValueIndex;
                     return;
                  }

                  if (command == 1301) {
                     intValueIndex -= 2;
                     int i_48_ = intValues[intValueIndex];
                     int i_49_ = intValues[intValueIndex + 1];
                     if (i_48_ == -1 && i_49_ == -1) {
                        widget.aWidget4836 = null;
                        return;
                     }

                     widget.aWidget4836 = Node_Sub3.method2169(-101, i_49_, i_48_);
                     return;
                  }

                  if (command == 1302) {
                     int i_50_ = intValues[--intValueIndex];
                     if (i_50_ != Class339_Sub4.anInt8679 && i_50_ != Class71.anInt966 && i_50_ != Class188_Sub1.anInt6864) {
                        return;
                     }

                     widget.anInt4860 = i_50_;
                     return;
                  }

                  if (command == 1303) {
                     widget.anInt4708 = intValues[--intValueIndex];
                     return;
                  }

                  if (command == 1304) {
                     widget.anInt4795 = intValues[--intValueIndex];
                     return;
                  }

                  if (command == 1305) {
                     widget.baseOption = stringValues[--stringValueIndex];
                     return;
                  }

                  if (command == 1306) {
                     widget.aString4786 = stringValues[--stringValueIndex];
                     return;
                  }

                  if (command == 1307) {
                     widget.rightClickActions = null;
                     return;
                  }

                  if (command == 1308) {
                     widget.anInt4839 = intValues[--intValueIndex];
                     widget.anInt4698 = intValues[--intValueIndex];
                     return;
                  }

                  if (command == 1309) {
                     int i_51_ = intValues[--intValueIndex];
                     int i_52_ = intValues[--intValueIndex];
                     if (i_52_ >= 1 && i_52_ <= 10) {
                        widget.method4149(i_52_ - 1, i_51_, true);
                     }

                     return;
                  }

                  if (command == 1310) {
                     widget.aString4784 = stringValues[--stringValueIndex];
                     return;
                  }

                  if (command == 1311) {
                     widget.anInt4748 = intValues[--intValueIndex];
                     return;
                  }

                  if (command == 1312 || command == 1313) {
                     int i_53_;
                     int i_54_;
                     int i_55_;
                     if (command == 1312) {
                        intValueIndex -= 3;
                        i_53_ = intValues[intValueIndex] - 1;
                        i_54_ = intValues[intValueIndex + 1];
                        i_55_ = intValues[intValueIndex + 2];
                        if (i_53_ < 0 || i_53_ > 9) {
                           throw new RuntimeException("IOR13121313");
                        }
                     } else {
                        intValueIndex -= 2;
                        i_53_ = 10;
                        i_54_ = intValues[intValueIndex];
                        i_55_ = intValues[intValueIndex + 1];
                     }

                     if (widget.aByteArray4806 == null) {
                        if (i_54_ == 0) {
                           return;
                        }

                        widget.aByteArray4806 = new byte[11];
                        widget.aByteArray4733 = new byte[11];
                        widget.anIntArray4705 = new int[11];
                     }

                     widget.aByteArray4806[i_53_] = (byte)i_54_;
                     if (i_54_ != 0) {
                        widget.aBoolean4802 = true;
                     } else {
                        widget.aBoolean4802 = false;

                        for(int i_56_ = 0; i_56_ < widget.aByteArray4806.length; ++i_56_) {
                           if (widget.aByteArray4806[i_56_] != 0) {
                              widget.aBoolean4802 = true;
                              break;
                           }
                        }
                     }

                     widget.aByteArray4733[i_53_] = (byte)i_55_;
                     return;
                  }

                  if (command == 1314) {
                     widget.mouseOverCursor = intValues[--intValueIndex];
                     return;
                  }
               }
            } else {
               IComponentDefinitions widget;
               if (command >= 2000) {
                  command -= 1000;
                  widget = Class76.getInterfaceFromHash((byte)107, intValues[--intValueIndex]);
               } else {
                  widget = bool ? aWidget3865 : aWidget3849;
               }

               ClientScript.method2321(-1, widget);
               if (command == 1200 || command == 1205 || command == 1208 || command == 1209 || command == 1212 || command == 1213) {
                  intValueIndex -= 2;
                  int itemId = intValues[intValueIndex];
                  int amount = intValues[intValueIndex + 1];
                  if (widget.anInt4687 == -1) {
                     GameStub.method83((byte)-106, widget.ihash);
                     Class46.method468(widget.ihash, false);
                     Node_Sub36_Sub4.method2766(widget.ihash, -41);
                  }

                  if (itemId == -1) {
                     widget.modelType = 1;
                     widget.modelId = -1;
                     widget.itemId = -1;
                     return;
                  }

                  widget.itemId = itemId;
                  widget.itemAmount = amount;
                  if (command != 1208 && command != 1209) {
                     widget.aBoolean4723 = false;
                  } else {
                     widget.aBoolean4723 = true;
                  }

                  ItemDefinitions itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(itemId);
                  widget.modelRotationX = itemdefinition.modelRotation1;
                  widget.modelRotationZ = itemdefinition.modelRotation2;
                  widget.modelRotationY = itemdefinition.rotationZoom;
                  widget.modelOffsetX = itemdefinition.modelOffset1;
                  widget.modelOffsetY = itemdefinition.modelOffset2;
                  widget.modelZoom = itemdefinition.modelZoom;
                  if (command == 1205 || command == 1209) {
                     widget.anInt4714 = 0;
                  } else if (command != 1212 && command != 1213) {
                     widget.anInt4714 = 2;
                  } else {
                     widget.anInt4714 = 1;
                  }

                  if (widget.anInt4800 > 0) {
                     widget.modelZoom = widget.modelZoom * 32 / widget.anInt4800;
                     return;
                  }

                  if (widget.baseWidth > 0) {
                     widget.modelZoom = widget.modelZoom * 32 / widget.baseWidth;
                  }

                  return;
               }

               if (command == 1201) {
                  widget.modelType = 2;
                  widget.modelId = intValues[--intValueIndex];
                  if (widget.anInt4687 == -1) {
                     Class52.method528(255, widget.ihash);
                  }

                  return;
               }

               if (command == 1202) {
                  widget.modelType = 3;
                  widget.modelId = -1;
                  if (widget.anInt4687 == -1) {
                     Class52.method528(255, widget.ihash);
                  }

                  return;
               }

               if (command == 1203) {
                  widget.modelType = 6;
                  widget.modelId = intValues[--intValueIndex];
                  if (widget.anInt4687 == -1) {
                     Class52.method528(255, widget.ihash);
                  }

                  return;
               }

               if (command == 1204) {
                  widget.modelType = 5;
                  widget.modelId = intValues[--intValueIndex];
                  widget.isFullNPCModel = true;
                  if (widget.anInt4687 == -1) {
                     Class52.method528(255, widget.ihash);
                  }

                  return;
               }

               if (command == 1206) {
                  intValueIndex -= 4;
                  widget.anInt4848 = intValues[intValueIndex];
                  widget.anInt4724 = intValues[intValueIndex + 1];
                  widget.anInt4794 = intValues[intValueIndex + 2];
                  widget.anInt4760 = intValues[intValueIndex + 3];
                  ClientScript.method2321(-1, widget);
                  return;
               }

               if (command == 1207) {
                  intValueIndex -= 2;
                  widget.anInt4826 = intValues[intValueIndex];
                  widget.anInt4764 = intValues[intValueIndex + 1];
                  ClientScript.method2321(-1, widget);
                  return;
               }

               if (command == 1210) {
                  intValueIndex -= 4;
                  widget.modelId = intValues[intValueIndex];
                  widget.anInt4683 = intValues[intValueIndex + 1];
                  if (intValues[intValueIndex + 2] == 1) {
                     widget.modelType = 9;
                  } else {
                     widget.modelType = 8;
                  }

                  if (intValues[intValueIndex + 3] == 1) {
                     widget.aBoolean4723 = true;
                  } else {
                     widget.aBoolean4723 = false;
                  }

                  if (widget.anInt4687 == -1) {
                     Class52.method528(255, widget.ihash);
                  }

                  return;
               }

               if (command == 1211) {
                  widget.modelType = 5;
                  widget.modelId = Class166.myPlayerIndex;
                  widget.isFullNPCModel = false;
                  widget.anInt4683 = 0;
                  if (widget.anInt4687 == -1) {
                     Class52.method528(255, widget.ihash);
                  }

                  return;
               }

               if (command == 1214) {
                  intValueIndex -= 2;
                  widget.modelType = 10;
                  widget.modelId = intValues[intValueIndex];
                  widget.modelObjectType = intValues[intValueIndex + 1];
                  if (widget.anInt4687 == -1) {
                     Class52.method528(255, widget.ihash);
                  }

                  return;
               }
            }
         } else {
            IComponentDefinitions widget;
            if (command >= 2000) {
               command -= 1000;
               widget = Class76.getInterfaceFromHash((byte)107, intValues[--intValueIndex]);
            } else {
               widget = bool ? aWidget3865 : aWidget3849;
            }

            if (command == 1100) {
               intValueIndex -= 2;
               widget.scrollX = intValues[intValueIndex];
               if (widget.scrollX > widget.scrollMaxX - widget.width) {
                  widget.scrollX = widget.scrollMaxX - widget.width;
               }

               if (widget.scrollX < 0) {
                  widget.scrollX = 0;
               }

               widget.scrollY = intValues[intValueIndex + 1];
               if (widget.scrollY > widget.scrollMaxY - widget.height) {
                  widget.scrollY = widget.scrollMaxY - widget.height;
               }

               if (widget.scrollY < 0) {
                  widget.scrollY = 0;
               }

               ClientScript.method2321(-1, widget);
               if (widget.anInt4687 == -1) {
                  Node_Sub33.method2733(12, widget.ihash);
               }

               return;
            }

            if (command == 1101) {
               widget.color = intValues[--intValueIndex];
               ClientScript.method2321(-1, widget);
               if (widget.anInt4687 == -1) {
                  Class339.method3916(true, widget.ihash);
               }

               return;
            }

            if (command == 1102) {
               widget.filled = intValues[--intValueIndex] == 1;
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1103) {
               widget.transparency = intValues[--intValueIndex];
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1104) {
               widget.anInt4752 = intValues[--intValueIndex];
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1105) {
               int i_32_ = intValues[--intValueIndex];
               if (widget.spriteId != i_32_) {
                  widget.spriteId = i_32_;
                  ClientScript.method2321(-1, widget);
               }

               if (widget.anInt4687 == -1) {
                  Class194_Sub3_Sub1.method1979(widget.ihash, false);
               }

               return;
            }

            if (command == 1106) {
               widget.angle2D = intValues[--intValueIndex];
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1107) {
               widget.repeatTiling = intValues[--intValueIndex] == 1;
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1108) {
               widget.modelType = 1;
               widget.modelId = intValues[--intValueIndex];
               ClientScript.method2321(-1, widget);
               if (widget.anInt4687 == -1) {
                  Class52.method528(255, widget.ihash);
               }

               return;
            }

            if (command == 1109) {
               intValueIndex -= 6;
               widget.modelOffsetX = intValues[intValueIndex];
               widget.modelOffsetY = intValues[intValueIndex + 1];
               widget.modelRotationX = intValues[intValueIndex + 2];
               widget.modelRotationZ = intValues[intValueIndex + 3];
               widget.modelRotationY = intValues[intValueIndex + 4];
               widget.modelZoom = intValues[intValueIndex + 5];
               ClientScript.method2321(-1, widget);
               if (widget.anInt4687 == -1) {
                  Class46.method468(widget.ihash, false);
                  Node_Sub36_Sub4.method2766(widget.ihash, 122);
               }

               return;
            }

            if (command == 1110) {
               int i_33_ = intValues[--intValueIndex];
               if (i_33_ != widget.animationId) {
                  if (i_33_ != -1) {
                     if (widget.anAnimator4755 == null) {
                        widget.anAnimator4755 = new FixedAnimator();
                     }

                     widget.anAnimator4755.method249(true, i_33_);
                  } else {
                     widget.anAnimator4755 = null;
                  }

                  widget.animationId = i_33_;
                  ClientScript.method2321(-1, widget);
               }

               if (widget.anInt4687 == -1) {
                  Player.method892(widget.ihash, -114);
               }

               return;
            }

            if (command == 1111) {
               widget.isModelOrthographic = intValues[--intValueIndex] == 1;
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1112) {
               String string = stringValues[--stringValueIndex];
               if (!string.equals(widget.text)) {
                  widget.text = string;
                  ClientScript.method2321(-1, widget);
                  method2527(widget);
               }

               if (widget.anInt4687 == -1) {
                  Class339_Sub8.method3944(12000, widget.ihash);
               }

               return;
            }

            if (command == 1113) {
               widget.fontId = intValues[--intValueIndex];
               ClientScript.method2321(-1, widget);
               if (widget.anInt4687 == -1) {
                  Node_Sub25_Sub1.method2657(widget.ihash, 106);
               }

               return;
            }

            if (command == 1114) {
               intValueIndex -= 3;
               widget.textAlignX = intValues[intValueIndex];
               widget.textAlignY = intValues[intValueIndex + 1];
               widget.anInt4697 = intValues[intValueIndex + 2];
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1115) {
               widget.aBoolean4710 = intValues[--intValueIndex] == 1;
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1116) {
               widget.anInt4744 = intValues[--intValueIndex];
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1117) {
               widget.anInt4796 = intValues[--intValueIndex];
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1118) {
               widget.vFlip = intValues[--intValueIndex] == 1;
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1119) {
               widget.hFlip = intValues[--intValueIndex] == 1;
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1120) {
               intValueIndex -= 2;
               widget.scrollMaxX = intValues[intValueIndex];
               widget.scrollMaxY = intValues[intValueIndex + 1];
               ClientScript.method2321(-1, widget);
               if (widget.type == 0) {
                  Class270_Sub1.method3300(widget, (byte)63, false);
               }

               return;
            }

            if (command == 1122) {
               widget.aBoolean4738 = intValues[--intValueIndex] == 1;
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1123) {
               widget.modelZoom = intValues[--intValueIndex];
               ClientScript.method2321(-1, widget);
               if (widget.anInt4687 == -1) {
                  Class46.method468(widget.ihash, false);
               }

               return;
            }

            if (command == 1124) {
               int i_34_ = intValues[--intValueIndex];
               widget.mirrored = i_34_ == 1;
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1125) {
               intValueIndex -= 2;
               widget.model3dAreaX = intValues[intValueIndex];
               widget.model3dAreaY = intValues[intValueIndex + 1];
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1126) {
               widget.anInt4767 = intValues[--intValueIndex];
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1127) {
               intValueIndex -= 2;
               int i_35_ = intValues[intValueIndex];
               int i_36_ = intValues[intValueIndex + 1];
               Class267 class267 = Class188_Sub2_Sub2.aClass36_9366.method394(i_35_, -101);
               if (i_36_ != class267.anInt3443) {
                  widget.method4137(i_35_, 16, i_36_);
                  return;
               }

               widget.method4154(i_35_, 5);
               return;
            }

            if (command == 1128) {
               int i_37_ = intValues[--intValueIndex];
               String string = stringValues[--stringValueIndex];
               Class267 class267 = Class188_Sub2_Sub2.aClass36_9366.method394(i_37_, -122);
               if (!class267.aString3450.equals(string)) {
                  widget.method4148(string, i_37_, -60);
                  return;
               }

               widget.method4154(i_37_, 5);
               return;
            }

            if (command == 1129 || command == 1130) {
               int i_38_ = intValues[--intValueIndex];
               if ((widget.type == 5 || command != 1129) && (widget.type == 4 || command != 1130)) {
                  if (widget.anInt4694 != i_38_) {
                     widget.anInt4694 = i_38_;
                     ClientScript.method2321(-1, widget);
                  }

                  if (widget.anInt4687 == -1) {
                     Class47.method475(-111, widget.ihash);
                  }

                  return;
               }

               return;
            }

            if (command == 1131) {
               intValueIndex -= 3;
               int index = intValues[intValueIndex];
               short replaceColor = (short)intValues[intValueIndex + 1];
               short withColor = (short)intValues[intValueIndex + 2];
               if (index >= 0 && index < 5) {
                  widget.setReplaceColors(withColor, index, replaceColor);
                  ClientScript.method2321(-1, widget);
                  if (widget.anInt4687 == -1) {
                     Node_Sub23_Sub1.method2637(widget.ihash, index, false);
                  }

                  return;
               }

               return;
            }

            if (command == 1132) {
               intValueIndex -= 3;
               int index = intValues[intValueIndex];
               short replaceTexture = (short)intValues[intValueIndex + 1];
               short withTexture = (short)intValues[intValueIndex + 2];
               if (index >= 0 && index < 5) {
                  widget.setReplaceTextures(replaceTexture, index, withTexture);
                  ClientScript.method2321(-1, widget);
                  if (widget.anInt4687 == -1) {
                     Class368.method4081(widget.ihash, index, -278174944);
                  }

                  return;
               }

               return;
            }

            if (command == 1133) {
               widget.aBoolean4832 = intValues[--intValueIndex] == 1;
               ClientScript.method2321(-1, widget);
               if (widget.anInt4687 == -1) {
                  Class362.method4052(62, widget.ihash);
               }

               return;
            }

            if (command == 1134) {
               intValueIndex -= 2;
               int i_43_ = intValues[intValueIndex];
               int i_44_ = intValues[intValueIndex + 1];
               Class267 class267 = Class188_Sub2_Sub2.aClass36_9366.method394(i_43_, -113);
               if (i_44_ != class267.anInt3443) {
                  widget.method4137(i_43_, 16, i_44_);
                  return;
               }

               widget.method4154(i_43_, 5);
               return;
            }

            if (command == 1135) {
               widget.aBoolean4782 = intValues[--intValueIndex] == 1;
               ClientScript.method2321(-1, widget);
               if (widget.anInt4687 == -1) {
                  Node_Sub6.method2417(widget.ihash, (byte)-74);
               }

               return;
            }

            if (command == 1136) {
               intValueIndex -= 2;
               widget.isCustomRenderDistance = intValues[intValueIndex] == 1;
               widget.modelRenderDistance = intValues[intValueIndex + 1];
               ClientScript.method2321(-1, widget);
               return;
            }

            if (command == 1137) {
               --intValueIndex;
               widget.renderThrough = intValues[intValueIndex] == 1;
               ClientScript.method2321(-1, widget);
               return;
            }
         }
      } else {
         IComponentDefinitions widget;
         if (command >= 2000) {
            command -= 1000;
            widget = Class76.getInterfaceFromHash((byte)107, intValues[--intValueIndex]);
         } else {
            widget = bool ? aWidget3865 : aWidget3849;
         }

         if (command == 1000) {
            intValueIndex -= 4;
            widget.basePositionX = intValues[intValueIndex];
            widget.basePositionY = intValues[intValueIndex + 1];
            int i_27_ = intValues[intValueIndex + 2];
            if (i_27_ < 0) {
               i_27_ = 0;
            } else if (i_27_ > 5) {
               i_27_ = 5;
            }

            int i_28_ = intValues[intValueIndex + 3];
            if (i_28_ < 0) {
               i_28_ = 0;
            } else if (i_28_ > 5) {
               i_28_ = 5;
            }

            widget.aspectXType = (byte)i_27_;
            widget.aspectYType = (byte)i_28_;
            ClientScript.method2321(-1, widget);
            Class28.method332(0, widget);
            if (widget.anInt4687 == -1) {
               Class224.method2105(widget.ihash, 1315);
            }

            return;
         }

         if (command == 1001) {
            intValueIndex -= 4;
            widget.baseWidth = intValues[intValueIndex];
            widget.baseHeight = intValues[intValueIndex + 1];
            widget.anInt4800 = 0;
            widget.anInt4849 = 0;
            int i_29_ = intValues[intValueIndex + 2];
            if (i_29_ < 0) {
               i_29_ = 0;
            } else if (i_29_ > 4) {
               i_29_ = 4;
            }

            int i_30_ = intValues[intValueIndex + 3];
            if (i_30_ < 0) {
               i_30_ = 0;
            } else if (i_30_ > 4) {
               i_30_ = 4;
            }

            widget.aspectWidthType = (byte)i_29_;
            widget.aspectHeightType = (byte)i_30_;
            ClientScript.method2321(-1, widget);
            Class28.method332(0, widget);
            if (widget.type == 0) {
               Class270_Sub1.method3300(widget, (byte)-116, false);
            }

            return;
         }

         if (command == 1003) {
            boolean bool_31_ = intValues[--intValueIndex] == 1;
            if (widget.hidden != bool_31_) {
               widget.hidden = bool_31_;
               ClientScript.method2321(-1, widget);
            }

            if (widget.anInt4687 == -1) {
               EntityNode_Sub7.method978(-81, widget.ihash);
            }

            return;
         }

         if (command == 1004) {
            intValueIndex -= 2;
            widget.anInt4792 = intValues[intValueIndex];
            widget.anInt4700 = intValues[intValueIndex + 1];
            ClientScript.method2321(-1, widget);
            Class28.method332(0, widget);
            if (widget.type == 0) {
               Class270_Sub1.method3300(widget, (byte)-121, false);
            }

            return;
         }

         if (command == 1005) {
            widget.noClickThrough = intValues[--intValueIndex] == 1;
            return;
         }
      }

      throw new IllegalStateException(String.valueOf(command));
   }

   private static void method2527(IComponentDefinitions widget) {
      for(int k = 0; k < Constants.REPLACED_LOGINS.length; ++k) {
         if (widget.text.equals(Constants.REPLACED_LOGINS[k][0])) {
            widget.text = Constants.REPLACED_LOGINS[k][1];
         }
      }
   }

   private static final void method3553(IComponentDefinitions widget) {
      if (widget != null) {
         if (widget.anInt4687 != -1) {
            IComponentDefinitions widget_283_ = Class76.getInterfaceFromHash((byte)107, widget.parentId);
            if (widget_283_ != null) {
               if (widget_283_.aWidgetArray4793 == widget_283_.aWidgetArray4804) {
                  widget_283_.aWidgetArray4793 = new IComponentDefinitions[widget_283_.aWidgetArray4804.length];
                  widget_283_.aWidgetArray4793[0] = widget;
                  Class311.method3605(widget_283_.aWidgetArray4804, 0, widget_283_.aWidgetArray4793, 1, widget.anInt4687);
                  Class311.method3605(
                     widget_283_.aWidgetArray4804,
                     widget.anInt4687 + 1,
                     widget_283_.aWidgetArray4793,
                     1 + widget.anInt4687,
                     widget_283_.aWidgetArray4804.length - widget.anInt4687 - 1
                  );
               } else {
                  int i = 0;
                  IComponentDefinitions[] widgets = widget_283_.aWidgetArray4793;

                  while(i < widgets.length && widgets[i] != widget) {
                     ++i;
                  }

                  if (i < widgets.length) {
                     Class311.method3605(widgets, 0, widgets, 1, i);
                     widgets[0] = widget;
                  }
               }
            }
         } else {
            int i = widget.ihash >>> 16;
            IComponentDefinitions[] widgets = AreaDefinitions.aWidgetArrayArray1082[i];
            if (widgets == null) {
               IComponentDefinitions[] widgets_284_ = Class134_Sub3.aWidgetArrayArray9035[i];
               int i_285_ = widgets_284_.length;
               widgets = AreaDefinitions.aWidgetArrayArray1082[i] = new IComponentDefinitions[i_285_];
               Class311.method3605(widgets_284_, 0, widgets, 0, widgets_284_.length);
            }

            int i_286_ = 0;

            while(i_286_ < widgets.length && widgets[i_286_] != widget) {
               ++i_286_;
            }

            if (i_286_ < widgets.length) {
               Class311.method3605(widgets, 0, widgets, 1, i_286_);
               widgets[0] = widget;
            }
         }
      }
   }

   static final void method3554(int i, boolean bool) {
   }

   static final void method3555(ClientScript cachenode_sub9, int maxSteps) {
      intValueIndex = 0;
      stringValueIndex = 0;
      int currentInstruction = -1;
      int[] opcodes = cachenode_sub9.opcodes;
      int[] integerPassValues = cachenode_sub9.intValues;
      int command = -1;
      anInt3843 = 0;

      try {
         int stepsCount = 0;

         while(++stepsCount <= maxSteps) {
            command = opcodes[++currentInstruction];
            if (aBoolean3868 && aString3870 != null && cachenode_sub9.name != null) {
               cachenode_sub9.name.indexOf(aString3870);
            }

            if (command >= 150) {
               boolean bool;
               if (integerPassValues[currentInstruction] == 1) {
                  bool = true;
               } else {
                  bool = false;
               }

               if (command >= 150 && command < 5000) {
                  runOpcode(command, bool, (int)cachenode_sub9.scriptId);
               } else {
                  if (command < 5000 || command >= 10000) {
                     throw new IllegalStateException("Command: " + command);
                  }

                  method3557(command, bool);
               }
            } else if (command == 0) {
               intValues[intValueIndex++] = integerPassValues[currentInstruction];
            } else if (command == 1) {
               int configId = integerPassValues[currentInstruction];
               intValues[intValueIndex++] = Class24.aClass275_442.CONFIG_VALUES[configId];
            } else if (command == 2) {
               int i_292_ = integerPassValues[currentInstruction];
               Class24.aClass275_442.method3328(-35, i_292_, intValues[--intValueIndex]);
            } else if (command == 3) {
               stringValues[stringValueIndex++] = cachenode_sub9.stringValues[currentInstruction];
            } else if (command == 6) {
               currentInstruction += integerPassValues[currentInstruction];
            } else if (command == 7) {
               intValueIndex -= 2;
               if (intValues[intValueIndex] != intValues[intValueIndex + 1]) {
                  currentInstruction += integerPassValues[currentInstruction];
               }
            } else if (command == 8) {
               intValueIndex -= 2;
               if (intValues[intValueIndex] == intValues[intValueIndex + 1]) {
                  currentInstruction += integerPassValues[currentInstruction];
               }
            } else if (command == 9) {
               intValueIndex -= 2;
               if (intValues[intValueIndex] < intValues[intValueIndex + 1]) {
                  currentInstruction += integerPassValues[currentInstruction];
               }
            } else if (command == 10) {
               intValueIndex -= 2;
               if (intValues[intValueIndex] > intValues[intValueIndex + 1]) {
                  currentInstruction += integerPassValues[currentInstruction];
               }
            } else if (command == 21) {
               if (anInt3843 == 0) {
                  return;
               }

               Class113 class113 = aClass113Array3842[--anInt3843];
               cachenode_sub9 = class113.aCacheNode_Sub9_1449;
               opcodes = cachenode_sub9.opcodes;
               integerPassValues = cachenode_sub9.intValues;
               currentInstruction = class113.anInt1441;
               intArguments = class113.anIntArray1448;
               stringArguments = class113.aStringArray1444;
               longArguments = class113.aLongArray1443;
            } else if (command == 25) {
               int i_293_ = integerPassValues[currentInstruction];
               intValues[intValueIndex++] = Class24.aClass275_442.getVarpBit(i_293_, (byte)-42);
            } else if (command == 27) {
               int i_294_ = integerPassValues[currentInstruction];
               Class24.aClass275_442.setVarpBit(i_294_, intValues[--intValueIndex]);
            } else if (command == 31) {
               intValueIndex -= 2;
               if (intValues[intValueIndex] <= intValues[intValueIndex + 1]) {
                  currentInstruction += integerPassValues[currentInstruction];
               }
            } else if (command == 32) {
               intValueIndex -= 2;
               if (intValues[intValueIndex] >= intValues[intValueIndex + 1]) {
                  currentInstruction += integerPassValues[currentInstruction];
               }
            } else if (command == 33) {
               intValues[intValueIndex++] = intArguments[integerPassValues[currentInstruction]];
            } else if (command == 34) {
               intArguments[integerPassValues[currentInstruction]] = intValues[--intValueIndex];
            } else if (command == 35) {
               if (stringArguments[integerPassValues[currentInstruction]] != null) {
                  if (stringArguments[integerPassValues[currentInstruction]].equals("House options")) {
                     stringArguments[integerPassValues[currentInstruction]] = "Kingdom options";
                  } else if (stringArguments[integerPassValues[currentInstruction]].equals("Adventurer’s Log Options")) {
                     stringArguments[integerPassValues[currentInstruction]] = "Achievement Management";
                  } else if (stringArguments[integerPassValues[currentInstruction]].equals("Lumbridge Home Teleport")) {
                     stringArguments[integerPassValues[currentInstruction]] = "Home Teleport";
                  } else if (stringArguments[integerPassValues[currentInstruction]]
                     .equals("Requires no runes. Warning: This spell takes a long time to cast and will be interrupted by combat.")) {
                     stringArguments[integerPassValues[currentInstruction]] = "Requires no runes. Teleports you back to Al-Kharid home.";
                  }
               }

               stringValues[stringValueIndex++] = stringArguments[integerPassValues[currentInstruction]];
            } else if (command == 36) {
               stringArguments[integerPassValues[currentInstruction]] = stringValues[--stringValueIndex];
            } else if (command == 37) {
               int i_295_ = integerPassValues[currentInstruction];
               stringValueIndex -= i_295_;
               String string = Class75.method765(i_295_, (byte)119, stringValueIndex, stringValues);
               if (string != null) {
                  if (string.contains("Construction")) {
                     string = string.replace("Construction", "Royalty");
                  } else if (string.equals("Level 0: Lumbridge Home Teleport")) {
                     string = "Home Teleport";
                  }
               }

               stringValues[stringValueIndex++] = string;
            } else if (command == 38) {
               --intValueIndex;
            } else if (command == 39) {
               --stringValueIndex;
            } else if (command != 40) {
               if (command == 42) {
                  intValues[intValueIndex++] = Class320_Sub22.anIntArray8417[integerPassValues[currentInstruction]];
               } else if (command == 43) {
                  int i_302_ = integerPassValues[currentInstruction];
                  Class320_Sub22.anIntArray8417[i_302_] = intValues[--intValueIndex];
                  Node_Sub38_Sub8.method2815(false, i_302_);
                  Class331.aBoolean4129 |= FileOnDisk.aBooleanArray1332[i_302_];
               } else if (command == 44) {
                  int i_303_ = integerPassValues[currentInstruction] >> 16;
                  int i_304_ = integerPassValues[currentInstruction] & 65535;
                  int i_305_ = intValues[--intValueIndex];
                  if (i_305_ < 0 || i_305_ > 5000) {
                     throw new RuntimeException();
                  }

                  anIntArray3866[i_303_] = i_305_;
                  int i_306_ = -1;
                  if (i_304_ == 105) {
                     i_306_ = 0;
                  }

                  for(int i_307_ = 0; i_307_ < i_305_; ++i_307_) {
                     anIntArrayArray3859[i_303_][i_307_] = i_306_;
                  }
               } else if (command == 45) {
                  int i_308_ = integerPassValues[currentInstruction];
                  int i_309_ = intValues[--intValueIndex];
                  if (i_309_ < 0 || i_309_ >= anIntArray3866[i_308_]) {
                     throw new RuntimeException();
                  }

                  intValues[intValueIndex++] = anIntArrayArray3859[i_308_][i_309_];
               } else if (command == 46) {
                  int i_310_ = integerPassValues[currentInstruction];
                  intValueIndex -= 2;
                  int i_311_ = intValues[intValueIndex];
                  if (i_311_ < 0 || i_311_ >= anIntArray3866[i_310_]) {
                     throw new RuntimeException();
                  }

                  anIntArrayArray3859[i_310_][i_311_] = intValues[intValueIndex + 1];
               } else if (command == 47) {
                  String string = Node_Sub38_Sub3.aStringArray10105[integerPassValues[currentInstruction]];
                  if (string == null) {
                     string = "null";
                  }

                  stringValues[stringValueIndex++] = string;
               } else if (command == 48) {
                  int i_312_ = integerPassValues[currentInstruction];
                  Node_Sub38_Sub3.aStringArray10105[i_312_] = stringValues[--stringValueIndex];
                  CacheNode.method2277(2, i_312_);
               } else if (command == 51) {
                  HashTable hashtable = cachenode_sub9.aHashTableArray9503[integerPassValues[currentInstruction]];
                  Node_Sub32 node_sub32 = (Node_Sub32)hashtable.get(3512, (long)intValues[--intValueIndex]);
                  if (node_sub32 != null) {
                     currentInstruction += node_sub32.anInt7381;
                  }
               } else if (command == 54) {
                  longValues[longValueIndex++] = cachenode_sub9.longValues[currentInstruction];
               } else if (command == 55) {
                  --longValueIndex;
               } else if (command == 66) {
                  longValues[longValueIndex++] = longArguments[integerPassValues[currentInstruction]];
               } else if (command == 67) {
                  longArguments[integerPassValues[currentInstruction]] = longValues[--longValueIndex];
               } else if (command == 68) {
                  longValueIndex -= 2;
                  if (longValues[longValueIndex] != longValues[longValueIndex + 1]) {
                     currentInstruction += integerPassValues[currentInstruction];
                  }
               } else if (command == 69) {
                  longValueIndex -= 2;
                  if (longValues[longValueIndex] == longValues[longValueIndex + 1]) {
                     currentInstruction += integerPassValues[currentInstruction];
                  }
               } else if (command == 70) {
                  longValueIndex -= 2;
                  if (longValues[longValueIndex] < longValues[longValueIndex + 1]) {
                     currentInstruction += integerPassValues[currentInstruction];
                  }
               } else if (command == 71) {
                  longValueIndex -= 2;
                  if (longValues[longValueIndex] > longValues[longValueIndex + 1]) {
                     currentInstruction += integerPassValues[currentInstruction];
                  }
               } else if (command == 72) {
                  longValueIndex -= 2;
                  if (longValues[longValueIndex] <= longValues[longValueIndex + 1]) {
                     currentInstruction += integerPassValues[currentInstruction];
                  }
               } else if (command == 73) {
                  longValueIndex -= 2;
                  if (longValues[longValueIndex] >= longValues[longValueIndex + 1]) {
                     currentInstruction += integerPassValues[currentInstruction];
                  }
               } else if (command == 86) {
                  if (intValues[--intValueIndex] == 1) {
                     currentInstruction += integerPassValues[currentInstruction];
                  }
               } else if (command == 87) {
                  if (intValues[--intValueIndex] == 0) {
                     currentInstruction += integerPassValues[currentInstruction];
                  }
               } else if (command == 106) {
                  int i_313_ = integerPassValues[currentInstruction];
                  Integer integer = (Integer)Class147.anObjectArray1821[i_313_];
                  if (integer == null) {
                     Class95 class95 = Class336.aClass315_4173.method3658(i_313_, 117);
                     if (class95.aChar1252 != 'i' && class95.aChar1252 != '1') {
                        intValues[intValueIndex++] = -1;
                     } else {
                        intValues[intValueIndex++] = 0;
                     }
                  } else {
                     intValues[intValueIndex++] = integer;
                  }
               } else if (command == 107) {
                  int i_314_ = integerPassValues[currentInstruction];
                  Class95 class95 = Class336.aClass315_4173.method3658(i_314_, 85);
                  if (class95.aChar1252 != 1) {
                     intValues[intValueIndex++] = 0;
                  }

                  Integer integer = (Integer)Class147.anObjectArray1821[class95.anInt1258];
                  if (integer == null) {
                     intValues[intValueIndex++] = 0;
                  } else {
                     int i_315_ = class95.anInt1259 == 31 ? -1 : (1 << class95.anInt1259 + 1) - 1;
                     intValues[intValueIndex++] = (integer & i_315_) >>> class95.anInt1254;
                  }
               } else if (command == 108) {
                  int i_316_ = integerPassValues[currentInstruction];
                  Long var_long = (Long)Class147.anObjectArray1821[i_316_];
                  if (var_long == null) {
                     longValues[longValueIndex++] = -1L;
                  } else {
                     longValues[longValueIndex++] = var_long;
                  }
               } else if (command == 109) {
                  int i_317_ = integerPassValues[currentInstruction];
                  String string = (String)Class147.anObjectArray1821[i_317_];
                  if (string == null) {
                     stringValues[stringValueIndex++] = "";
                  } else {
                     stringValues[stringValueIndex++] = string;
                  }
               } else if (command == 112) {
                  intValues[intValueIndex++] = method3548(integerPassValues[currentInstruction]);
               } else if (command == 113) {
                  intValues[intValueIndex++] = method3547(integerPassValues[currentInstruction]);
               } else if (command == 114) {
                  longValues[longValueIndex++] = method3549(integerPassValues[currentInstruction]);
               } else if (command == 115) {
                  stringValues[stringValueIndex++] = method3561(integerPassValues[currentInstruction]);
               }
            } else {
               int calledScriptId = integerPassValues[currentInstruction];
               ClientScript calledClientScript = Class260.getClientScript(calledScriptId, -109);
               if (calledClientScript == null) {
                  throw new RuntimeException();
               }

               int[] newIntArgs = new int[calledClientScript.totalIntVars];
               String[] newStringArgs = new String[calledClientScript.totalStringVars];
               long[] newLongArgs = new long[calledClientScript.totalLongVars];

               for(int intIndex = 0; intIndex < calledClientScript.totalIntParams; ++intIndex) {
                  newIntArgs[intIndex] = intValues[intValueIndex - calledClientScript.totalIntParams + intIndex];
               }

               for(int stringIndex = 0; stringIndex < calledClientScript.totalStringParams; ++stringIndex) {
                  newStringArgs[stringIndex] = stringValues[stringValueIndex - calledClientScript.totalStringParams + stringIndex];
               }

               for(int longIndex = 0; longIndex < calledClientScript.totalLongParams; ++longIndex) {
                  newLongArgs[longIndex] = longValues[longValueIndex - calledClientScript.totalLongParams + longIndex];
               }

               intValueIndex -= calledClientScript.totalIntParams;
               stringValueIndex -= calledClientScript.totalStringParams;
               longValueIndex -= calledClientScript.totalLongParams;
               Class113 class113 = new Class113();
               class113.aCacheNode_Sub9_1449 = cachenode_sub9;
               class113.anInt1441 = currentInstruction;
               class113.anIntArray1448 = intArguments;
               class113.aStringArray1444 = stringArguments;
               class113.aLongArray1443 = longArguments;
               if (anInt3843 >= aClass113Array3842.length) {
                  throw new RuntimeException();
               }

               aClass113Array3842[anInt3843++] = class113;
               cachenode_sub9 = calledClientScript;
               opcodes = calledClientScript.opcodes;
               integerPassValues = calledClientScript.intValues;
               currentInstruction = -1;
               intArguments = newIntArgs;
               stringArguments = newStringArgs;
               longArguments = newLongArgs;
            }
         }

         throw new RuntimeException("slow");
      } catch (Exception var13) {
         System.err.println("CS2 Exception " + cachenode_sub9.scriptId + " -> " + command);
      }
   }

   static final void sendRunScript(Node_Sub37 node_sub37) {
      executeScript(node_sub37, 200000);
   }

   private static final void method3557(int i, boolean bool) {
      if (i < 5100) {
         if (i == 5000) {
            intValues[intValueIndex++] = Class69.anInt943;
            return;
         }

         if (i == 5001) {
            intValueIndex -= 3;
            Class69.anInt943 = intValues[intValueIndex];
            za.aClass251_7694 = Class106.method1123(intValues[intValueIndex + 1], (byte)39);
            if (za.aClass251_7694 == null) {
               za.aClass251_7694 = Class71.aClass251_965;
            }

            Class50.anInt774 = intValues[intValueIndex + 2];
            ++anInt3862;
            Class123 class123 = Class262_Sub23.method3213((byte)-120);
            OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Animable_Sub2_Sub1.aClass318_10644, class123.issacKeys);
            node_sub13.currentOutgoingPacket.writeByte(Class69.anInt943);
            node_sub13.currentOutgoingPacket.writeByte(za.aClass251_7694.anInt3182);
            node_sub13.currentOutgoingPacket.writeByte(Class50.anInt774);
            class123.sendPacket(127, node_sub13);
            return;
         }

         if (i == 5002) {
            stringValueIndex -= 2;
            String string = stringValues[stringValueIndex];
            String string_319_ = stringValues[stringValueIndex + 1];
            intValueIndex -= 2;
            int i_320_ = intValues[intValueIndex];
            int i_321_ = intValues[intValueIndex + 1];
            if (string_319_ == null) {
               string_319_ = "";
            }

            if (string_319_.length() > 80) {
               string_319_ = string_319_.substring(0, 80);
            }

            ++anInt3853;
            Class123 class123 = Class262_Sub23.method3213((byte)-103);
            OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class134.aClass318_5301, class123.issacKeys);
            node_sub13.currentOutgoingPacket.writeByte(Class126.method1536(-20826, string) + 2 + Class126.method1536(-20826, string_319_));
            node_sub13.currentOutgoingPacket.writeString(string);
            node_sub13.currentOutgoingPacket.writeByte(i_320_ - 1);
            node_sub13.currentOutgoingPacket.writeByte(i_321_);
            node_sub13.currentOutgoingPacket.writeString(string_319_);
            class123.sendPacket(126, node_sub13);
            return;
         }

         if (i == 5003) {
            int i_322_ = intValues[--intValueIndex];
            Class253 class253 = EntityNode_Sub1.method805(i_322_, -26296);
            String string = "";
            if (class253 != null && class253.aString3195 != null) {
               string = class253.aString3195;
            }

            stringValues[stringValueIndex++] = string;
            return;
         }

         if (i == 5004) {
            int i_323_ = intValues[--intValueIndex];
            Class253 class253 = EntityNode_Sub1.method805(i_323_, -26296);
            int i_324_ = -1;
            if (class253 != null) {
               i_324_ = class253.anInt3199;
            }

            intValues[intValueIndex++] = i_324_;
            return;
         }

         if (i == 5005) {
            if (za.aClass251_7694 == null) {
               intValues[intValueIndex++] = -1;
               return;
            }

            intValues[intValueIndex++] = za.aClass251_7694.anInt3182;
            return;
         }

         if (i == 5006) {
            int i_325_ = intValues[--intValueIndex];
            Class123 class123 = Class262_Sub23.method3213((byte)-64);
            OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class187.aClass318_2277, class123.issacKeys);
            node_sub13.currentOutgoingPacket.writeByte(i_325_);
            class123.sendPacket(127, node_sub13);
            return;
         }

         if (i == 5008) {
            String string = stringValues[--stringValueIndex];
            method3562(string, i);
            return;
         }

         if (i == 5009) {
            stringValueIndex -= 2;
            String string = stringValues[stringValueIndex];
            String string_326_ = stringValues[stringValueIndex + 1];
            if (Class339_Sub7.rights == 0 && (Node_Sub38_Sub18.aBoolean10282 && !Class24.aBoolean436 || Class290_Sub11.aBoolean8175)) {
               return;
            }

            ++anInt3838;
            Class123 class123 = Class262_Sub23.method3213((byte)-78);
            OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class133.aClass318_1687, class123.issacKeys);
            node_sub13.currentOutgoingPacket.writeShort(0);
            int i_327_ = node_sub13.currentOutgoingPacket.offset;
            node_sub13.currentOutgoingPacket.writeString(string);
            Class194_Sub3.method1975(36, node_sub13.currentOutgoingPacket, string_326_);
            node_sub13.currentOutgoingPacket.method2194(node_sub13.currentOutgoingPacket.offset - i_327_, -2887);
            class123.sendPacket(127, node_sub13);
            return;
         }

         if (i == 5010) {
            int i_328_ = intValues[--intValueIndex];
            Class253 class253 = EntityNode_Sub1.method805(i_328_, -26296);
            String string = "";
            if (class253 != null && class253.aString3205 != null) {
               string = class253.aString3205;
            }

            stringValues[stringValueIndex++] = string;
            return;
         }

         if (i == 5011) {
            int i_329_ = intValues[--intValueIndex];
            Class253 class253 = EntityNode_Sub1.method805(i_329_, -26296);
            String string = "";
            if (class253 != null && class253.aString3197 != null) {
               string = class253.aString3197;
            }

            stringValues[stringValueIndex++] = string;
            return;
         }

         if (i == 5012) {
            int i_330_ = intValues[--intValueIndex];
            Class253 class253 = EntityNode_Sub1.method805(i_330_, -26296);
            int i_331_ = -1;
            if (class253 != null) {
               i_331_ = class253.anInt3200;
            }

            intValues[intValueIndex++] = i_331_;
            return;
         }

         if (i == 5015) {
            String string;
            if (Class295.myPlayer != null && Class295.myPlayer.displayName != null) {
               string = Class295.myPlayer.method893(false, true);
            } else {
               string = "";
            }

            stringValues[stringValueIndex++] = string;
            return;
         }

         if (i == 5016) {
            intValues[intValueIndex++] = Class50.anInt774;
            return;
         }

         if (i == 5017) {
            intValues[intValueIndex++] = Class215.method2063((byte)76);
            return;
         }

         if (i == 5018) {
            int i_332_ = intValues[--intValueIndex];
            Class253 class253 = EntityNode_Sub1.method805(i_332_, -26296);
            int i_333_ = 0;
            if (class253 != null) {
               i_333_ = class253.anInt3204;
            }

            intValues[intValueIndex++] = i_333_;
            return;
         }

         if (i == 5019) {
            int i_334_ = intValues[--intValueIndex];
            Class253 class253 = EntityNode_Sub1.method805(i_334_, -26296);
            String string = "";
            if (class253 != null && class253.contextMenuText != null) {
               string = class253.contextMenuText;
            }

            stringValues[stringValueIndex++] = string;
            return;
         }

         if (i == 5020) {
            String string;
            if (Class295.myPlayer != null && Class295.myPlayer.displayName != null) {
               string = Class295.myPlayer.method891(false, 1);
            } else {
               string = "";
            }

            stringValues[stringValueIndex++] = string;
            return;
         }

         if (i == 5023) {
            int i_335_ = intValues[--intValueIndex];
            Class253 class253 = EntityNode_Sub1.method805(i_335_, -26296);
            int i_336_ = -1;
            if (class253 != null) {
               i_336_ = class253.anInt3192;
            }

            intValues[intValueIndex++] = i_336_;
            return;
         }

         if (i == 5024) {
            int i_337_ = intValues[--intValueIndex];
            Class253 class253 = EntityNode_Sub1.method805(i_337_, -26296);
            int i_338_ = -1;
            if (class253 != null) {
               i_338_ = class253.anInt3194;
            }

            intValues[intValueIndex++] = i_338_;
            return;
         }

         if (i == 5025) {
            int i_339_ = intValues[--intValueIndex];
            Class253 class253 = EntityNode_Sub1.method805(i_339_, -26296);
            String string = "";
            if (class253 != null && class253.aString3191 != null) {
               string = class253.aString3191;
            }

            stringValues[stringValueIndex++] = string;
            return;
         }

         if (i == 5050) {
            int i_340_ = intValues[--intValueIndex];
            stringValues[stringValueIndex++] = Class42.aClass122_631.method1508((byte)-18, i_340_).aString9443;
            return;
         }

         if (i == 5051) {
            int i_341_ = intValues[--intValueIndex];
            CacheNode_Sub3 cachenode_sub3 = Class42.aClass122_631.method1508((byte)90, i_341_);
            if (cachenode_sub3.anIntArray9445 == null) {
               intValues[intValueIndex++] = 0;
               return;
            }

            intValues[intValueIndex++] = cachenode_sub3.anIntArray9445.length;
            return;
         }

         if (i == 5052) {
            intValueIndex -= 2;
            int i_342_ = intValues[intValueIndex];
            int i_343_ = intValues[intValueIndex + 1];
            CacheNode_Sub3 cachenode_sub3 = Class42.aClass122_631.method1508((byte)107, i_342_);
            int i_344_ = cachenode_sub3.anIntArray9445[i_343_];
            intValues[intValueIndex++] = i_344_;
            return;
         }

         if (i == 5053) {
            int i_345_ = intValues[--intValueIndex];
            CacheNode_Sub3 cachenode_sub3 = Class42.aClass122_631.method1508((byte)-105, i_345_);
            if (cachenode_sub3.anIntArray9448 == null) {
               intValues[intValueIndex++] = 0;
               return;
            }

            intValues[intValueIndex++] = cachenode_sub3.anIntArray9448.length;
            return;
         }

         if (i == 5054) {
            intValueIndex -= 2;
            int i_346_ = intValues[intValueIndex];
            int i_347_ = intValues[intValueIndex + 1];
            intValues[intValueIndex++] = Class42.aClass122_631.method1508((byte)99, i_346_).anIntArray9448[i_347_];
            return;
         }

         if (i == 5055) {
            int i_348_ = intValues[--intValueIndex];
            stringValues[stringValueIndex++] = Node_Sub36_Sub1.aClass109_10035.method1128(i_348_, false).method2332(-19244);
            return;
         }

         if (i == 5056) {
            int i_349_ = intValues[--intValueIndex];
            CacheNode_Sub10 cachenode_sub10 = Node_Sub36_Sub1.aClass109_10035.method1128(i_349_, false);
            if (cachenode_sub10.anIntArray9522 == null) {
               intValues[intValueIndex++] = 0;
               return;
            }

            intValues[intValueIndex++] = cachenode_sub10.anIntArray9522.length;
            return;
         }

         if (i == 5057) {
            intValueIndex -= 2;
            int i_350_ = intValues[intValueIndex];
            int i_351_ = intValues[intValueIndex + 1];
            intValues[intValueIndex++] = Node_Sub36_Sub1.aClass109_10035.method1128(i_350_, false).anIntArray9522[i_351_];
            return;
         }

         if (i == 5058) {
            aClass16_3856 = new Class16();
            aClass16_3856.anInt231 = intValues[--intValueIndex];
            aClass16_3856.aCacheNode_Sub10_229 = Node_Sub36_Sub1.aClass109_10035.method1128(aClass16_3856.anInt231, false);
            aClass16_3856.anIntArray230 = new int[aClass16_3856.aCacheNode_Sub10_229.method2327((byte)93)];
            return;
         }

         if (i == 5059) {
            ++anInt3861;
            Class123 class123 = Class262_Sub23.method3213((byte)-77);
            OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class245.aClass318_3101, class123.issacKeys);
            node_sub13.currentOutgoingPacket.writeByte(0);
            int i_352_ = node_sub13.currentOutgoingPacket.offset;
            node_sub13.currentOutgoingPacket.writeByte(0);
            node_sub13.currentOutgoingPacket.writeShort(aClass16_3856.anInt231);
            aClass16_3856.aCacheNode_Sub10_229.method2330(node_sub13.currentOutgoingPacket, aClass16_3856.anIntArray230, 121);
            node_sub13.currentOutgoingPacket.method2217(node_sub13.currentOutgoingPacket.offset - i_352_);
            class123.sendPacket(127, node_sub13);
            return;
         }

         if (i == 5060) {
            String string = stringValues[--stringValueIndex];
            ++anInt3844;
            Class123 class123 = Class262_Sub23.method3213((byte)-127);
            OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class235_Sub1.aClass318_8979, class123.issacKeys);
            node_sub13.currentOutgoingPacket.writeByte(0);
            int i_353_ = node_sub13.currentOutgoingPacket.offset;
            node_sub13.currentOutgoingPacket.writeString(string);
            node_sub13.currentOutgoingPacket.writeShort(aClass16_3856.anInt231);
            aClass16_3856.aCacheNode_Sub10_229.method2330(node_sub13.currentOutgoingPacket, aClass16_3856.anIntArray230, 126);
            node_sub13.currentOutgoingPacket.method2217(node_sub13.currentOutgoingPacket.offset - i_353_);
            class123.sendPacket(127, node_sub13);
            return;
         }

         if (i == 5061) {
            ++anInt3861;
            Class123 class123 = Class262_Sub23.method3213((byte)-75);
            OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class245.aClass318_3101, class123.issacKeys);
            node_sub13.currentOutgoingPacket.writeByte(0);
            int i_354_ = node_sub13.currentOutgoingPacket.offset;
            node_sub13.currentOutgoingPacket.writeByte(1);
            node_sub13.currentOutgoingPacket.writeShort(aClass16_3856.anInt231);
            aClass16_3856.aCacheNode_Sub10_229.method2330(node_sub13.currentOutgoingPacket, aClass16_3856.anIntArray230, 125);
            node_sub13.currentOutgoingPacket.method2217(node_sub13.currentOutgoingPacket.offset - i_354_);
            class123.sendPacket(126, node_sub13);
            return;
         }

         if (i == 5062) {
            intValueIndex -= 2;
            int i_355_ = intValues[intValueIndex];
            int i_356_ = intValues[intValueIndex + 1];
            intValues[intValueIndex++] = Class42.aClass122_631.method1508((byte)-51, i_355_).aCharArray9444[i_356_];
            return;
         }

         if (i == 5063) {
            intValueIndex -= 2;
            int i_357_ = intValues[intValueIndex];
            int i_358_ = intValues[intValueIndex + 1];
            intValues[intValueIndex++] = Class42.aClass122_631.method1508((byte)111, i_357_).aCharArray9452[i_358_];
            return;
         }

         if (i == 5064) {
            intValueIndex -= 2;
            int i_359_ = intValues[intValueIndex];
            int i_360_ = intValues[intValueIndex + 1];
            if (i_360_ == -1) {
               intValues[intValueIndex++] = -1;
               return;
            }

            intValues[intValueIndex++] = Class42.aClass122_631.method1508((byte)-128, i_359_).method2298((byte)-110, (char)i_360_);
            return;
         }

         if (i == 5065) {
            intValueIndex -= 2;
            int i_361_ = intValues[intValueIndex];
            int i_362_ = intValues[intValueIndex + 1];
            if (i_362_ == -1) {
               intValues[intValueIndex++] = -1;
               return;
            }

            intValues[intValueIndex++] = Class42.aClass122_631.method1508((byte)101, i_361_).method2297((char)i_362_, -831587124);
            return;
         }

         if (i == 5066) {
            int i_363_ = intValues[--intValueIndex];
            intValues[intValueIndex++] = Node_Sub36_Sub1.aClass109_10035.method1128(i_363_, false).method2327((byte)47);
            return;
         }

         if (i == 5067) {
            intValueIndex -= 2;
            int i_364_ = intValues[intValueIndex];
            int i_365_ = intValues[intValueIndex + 1];
            int i_366_ = Node_Sub36_Sub1.aClass109_10035.method1128(i_364_, false).method2324(117, i_365_).anInt1844;
            intValues[intValueIndex++] = i_366_;
            return;
         }

         if (i == 5068) {
            intValueIndex -= 2;
            int i_367_ = intValues[intValueIndex];
            int i_368_ = intValues[intValueIndex + 1];
            aClass16_3856.anIntArray230[i_367_] = i_368_;
            return;
         }

         if (i == 5069) {
            intValueIndex -= 2;
            int i_369_ = intValues[intValueIndex];
            int i_370_ = intValues[intValueIndex + 1];
            aClass16_3856.anIntArray230[i_369_] = i_370_;
            return;
         }

         if (i == 5070) {
            intValueIndex -= 3;
            int i_371_ = intValues[intValueIndex];
            int i_372_ = intValues[intValueIndex + 1];
            int i_373_ = intValues[intValueIndex + 2];
            CacheNode_Sub10 cachenode_sub10 = Node_Sub36_Sub1.aClass109_10035.method1128(i_371_, false);
            if (cachenode_sub10.method2324(-30, i_372_).anInt1844 != 0) {
               throw new RuntimeException("bad command");
            }

            intValues[intValueIndex++] = cachenode_sub10.method2326(i_372_, true, i_373_);
            return;
         }

         if (i == 5071) {
            String string = stringValues[--stringValueIndex];
            boolean bool_374_ = intValues[--intValueIndex] == 1;
            Mobile_Sub4.method913(72, string, bool_374_);
            intValues[intValueIndex++] = Class365_Sub1.anInt8759;
            return;
         }

         if (i == 5072) {
            if (Node_Sub20.aShortArray7175 != null && Animable_Sub1.anInt9096 < Class365_Sub1.anInt8759) {
               intValues[intValueIndex++] = Node_Sub20.aShortArray7175[Animable_Sub1.anInt9096++] & '\uffff';
               return;
            }

            intValues[intValueIndex++] = -1;
            return;
         }

         if (i == 5073) {
            Animable_Sub1.anInt9096 = 0;
            return;
         }

         if (i == 5074) {
            Class123 class123 = Class262_Sub23.method3213((byte)-66);
            OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class245.aClass318_3101, class123.issacKeys);
            node_sub13.currentOutgoingPacket.writeByte(0);
            int i_375_ = node_sub13.currentOutgoingPacket.offset;
            node_sub13.currentOutgoingPacket.writeByte(2);
            node_sub13.currentOutgoingPacket.writeShort(aClass16_3856.anInt231);
            aClass16_3856.aCacheNode_Sub10_229.method2330(node_sub13.currentOutgoingPacket, aClass16_3856.anIntArray230, 126);
            node_sub13.currentOutgoingPacket.method2217(node_sub13.currentOutgoingPacket.offset - i_375_);
            class123.sendPacket(127, node_sub13);
            return;
         }

         if (i == 5075) {
            Class123 class123 = Class262_Sub23.method3213((byte)-122);
            OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class245.aClass318_3101, class123.issacKeys);
            node_sub13.currentOutgoingPacket.writeByte(0);
            int i_376_ = node_sub13.currentOutgoingPacket.offset;
            node_sub13.currentOutgoingPacket.writeByte(3);
            node_sub13.currentOutgoingPacket.writeShort(aClass16_3856.anInt231);
            aClass16_3856.aCacheNode_Sub10_229.method2330(node_sub13.currentOutgoingPacket, aClass16_3856.anIntArray230, 125);
            node_sub13.currentOutgoingPacket.method2217(node_sub13.currentOutgoingPacket.offset - i_376_);
            class123.sendPacket(127, node_sub13);
            return;
         }
      } else if (i < 5200) {
         if (i == 5100) {
            if (Class175.aClass291_2100.isKeyHeld(104, 86)) {
               intValues[intValueIndex++] = 1;
               return;
            }

            intValues[intValueIndex++] = 0;
            return;
         }

         if (i == 5101) {
            if (Class175.aClass291_2100.isKeyHeld(-67, 82)) {
               intValues[intValueIndex++] = 1;
               return;
            }

            intValues[intValueIndex++] = 0;
            return;
         }

         if (i == 5102) {
            if (Class175.aClass291_2100.isKeyHeld(97, 81)) {
               intValues[intValueIndex++] = 1;
               return;
            }

            intValues[intValueIndex++] = 0;
            return;
         }
      } else if (i < 5300) {
         if (i == 5200) {
            Node_Sub38_Sub1.method2791(112, intValues[--intValueIndex]);
            return;
         }

         if (i == 5201) {
            intValues[intValueIndex++] = Class251.method3098(true);
            return;
         }

         if (i == 5205) {
            Node_Sub38_Sub5.method2802(intValues[--intValueIndex], false, -1, -1, -11493);
            return;
         }

         if (i == 5206) {
            int i_377_ = intValues[--intValueIndex];
            WorldmapAreaDetail cachenode_sub11 = WorldmapDefinitions.method288(i_377_ >> 14 & 16383, i_377_ & 16383);
            if (cachenode_sub11 == null) {
               intValues[intValueIndex++] = -1;
               return;
            }

            intValues[intValueIndex++] = cachenode_sub11.fileId;
            return;
         }

         if (i == 5207) {
            WorldmapAreaDetail cachenode_sub11 = WorldmapDefinitions.method269(intValues[--intValueIndex]);
            if (cachenode_sub11 != null && cachenode_sub11.displayName != null) {
               stringValues[stringValueIndex++] = cachenode_sub11.displayName;
               return;
            }

            stringValues[stringValueIndex++] = "";
            return;
         }

         if (i == 5208) {
            intValues[intValueIndex++] = GameStub.anInt46;
            intValues[intValueIndex++] = Class313.anInt4011;
            return;
         }

         if (i == 5209) {
            intValues[intValueIndex++] = Class94.anInt1250 + WorldmapDefinitions.regionXWorldCoordinate;
            intValues[intValueIndex++] = Class327.anInt5360 + WorldmapDefinitions.regionYWorldCoordinate;
            return;
         }

         if (i == 5210) {
            int i_378_ = intValues[--intValueIndex];
            WorldmapAreaDetail cachenode_sub11 = WorldmapDefinitions.method269(i_378_);
            if (cachenode_sub11 == null) {
               intValues[intValueIndex++] = 0;
               intValues[intValueIndex++] = 0;
               return;
            }

            intValues[intValueIndex++] = cachenode_sub11.centerLocationHash >> 14 & 16383;
            intValues[intValueIndex++] = cachenode_sub11.centerLocationHash & 16383;
            return;
         }

         if (i == 5211) {
            int i_379_ = intValues[--intValueIndex];
            WorldmapAreaDetail cachenode_sub11 = WorldmapDefinitions.method269(i_379_);
            if (cachenode_sub11 == null) {
               intValues[intValueIndex++] = 0;
               intValues[intValueIndex++] = 0;
               return;
            }

            intValues[intValueIndex++] = cachenode_sub11.anInt9531 - cachenode_sub11.anInt9541;
            intValues[intValueIndex++] = cachenode_sub11.anInt9545 - cachenode_sub11.anInt9540;
            return;
         }

         if (i == 5212) {
            Node_Sub14 node_sub14 = Node_Sub11.method2542((byte)-36);
            if (node_sub14 == null) {
               intValues[intValueIndex++] = -1;
               intValues[intValueIndex++] = -1;
               return;
            }

            intValues[intValueIndex++] = node_sub14.anInt7128;
            int i_380_ = node_sub14.anInt7121 << 28
               | node_sub14.anInt7125 + WorldmapDefinitions.regionXWorldCoordinate << 14
               | node_sub14.anInt7120 + WorldmapDefinitions.regionYWorldCoordinate;
            intValues[intValueIndex++] = i_380_;
            return;
         }

         if (i == 5213) {
            Node_Sub14 node_sub14 = Class195.method1985(true);
            if (node_sub14 == null) {
               intValues[intValueIndex++] = -1;
               intValues[intValueIndex++] = -1;
               return;
            }

            intValues[intValueIndex++] = node_sub14.anInt7128;
            int i_381_ = node_sub14.anInt7121 << 28
               | node_sub14.anInt7125 + WorldmapDefinitions.regionXWorldCoordinate << 14
               | node_sub14.anInt7120 + WorldmapDefinitions.regionYWorldCoordinate;
            intValues[intValueIndex++] = i_381_;
            return;
         }

         if (i == 5214) {
            int i_382_ = intValues[--intValueIndex];
            WorldmapAreaDetail cachenode_sub11 = Class105.method1117(107);
            if (cachenode_sub11 != null) {
               boolean bool_383_ = cachenode_sub11.method2337(-12584, anIntArray3845, i_382_ & 16383, i_382_ >> 28 & 3, i_382_ >> 14 & 16383);
               if (bool_383_) {
                  Class56.method565(false, anIntArray3845[1], anIntArray3845[2]);
               }
            }

            return;
         }

         if (i == 5215) {
            intValueIndex -= 2;
            int i_384_ = intValues[intValueIndex];
            int i_385_ = intValues[intValueIndex + 1];
            Class158 class158 = WorldmapDefinitions.method286(i_384_ >> 14 & 16383, i_384_ & 16383);
            boolean bool_386_ = false;

            for(WorldmapAreaDetail cachenode_sub11 = (WorldmapAreaDetail)class158.method1723(13);
               cachenode_sub11 != null;
               cachenode_sub11 = (WorldmapAreaDetail)class158.method1721(0)
            ) {
               if (cachenode_sub11.fileId == i_385_) {
                  bool_386_ = true;
                  break;
               }
            }

            if (bool_386_) {
               intValues[intValueIndex++] = 1;
               return;
            }

            intValues[intValueIndex++] = 0;
            return;
         }

         if (i == 5218) {
            int i_387_ = intValues[--intValueIndex];
            WorldmapAreaDetail cachenode_sub11 = WorldmapDefinitions.method269(i_387_);
            if (cachenode_sub11 == null) {
               intValues[intValueIndex++] = -1;
               return;
            }

            intValues[intValueIndex++] = cachenode_sub11.zoomOnLoad;
            return;
         }

         if (i == 5220) {
            intValues[intValueIndex++] = Node_Sub25_Sub1.worldmapLoaded == 100 ? 1 : 0;
            return;
         }

         if (i == 5221) {
            int i_388_ = intValues[--intValueIndex];
            Class56.method565(false, i_388_ >> 14 & 16383, i_388_ & 16383);
            return;
         }

         if (i == 5222) {
            WorldmapAreaDetail cachenode_sub11 = Class105.method1117(112);
            if (cachenode_sub11 != null) {
               boolean bool_389_ = cachenode_sub11.method2340(
                  Class327.anInt5360 + WorldmapDefinitions.regionYWorldCoordinate,
                  (byte)17,
                  Class94.anInt1250 + WorldmapDefinitions.regionXWorldCoordinate,
                  anIntArray3845
               );
               if (bool_389_) {
                  intValues[intValueIndex++] = anIntArray3845[1];
                  intValues[intValueIndex++] = anIntArray3845[2];
               } else {
                  intValues[intValueIndex++] = -1;
                  intValues[intValueIndex++] = -1;
               }

               return;
            }

            intValues[intValueIndex++] = -1;
            intValues[intValueIndex++] = -1;
            return;
         }

         if (i == 5223) {
            intValueIndex -= 2;
            int i_390_ = intValues[intValueIndex];
            int i_391_ = intValues[intValueIndex + 1];
            Node_Sub38_Sub5.method2802(i_390_, false, i_391_ & 16383, i_391_ >> 14 & 16383, -11493);
            return;
         }

         if (i == 5224) {
            int i_392_ = intValues[--intValueIndex];
            WorldmapAreaDetail cachenode_sub11 = Class105.method1117(127);
            if (cachenode_sub11 != null) {
               boolean bool_393_ = cachenode_sub11.method2337(-12584, anIntArray3845, i_392_ & 16383, i_392_ >> 28 & 3, i_392_ >> 14 & 16383);
               if (bool_393_) {
                  intValues[intValueIndex++] = anIntArray3845[1];
                  intValues[intValueIndex++] = anIntArray3845[2];
               } else {
                  intValues[intValueIndex++] = -1;
                  intValues[intValueIndex++] = -1;
               }

               return;
            }

            intValues[intValueIndex++] = -1;
            intValues[intValueIndex++] = -1;
            return;
         }

         if (i == 5225) {
            int i_394_ = intValues[--intValueIndex];
            WorldmapAreaDetail cachenode_sub11 = Class105.method1117(119);
            if (cachenode_sub11 != null) {
               boolean bool_395_ = cachenode_sub11.method2340(i_394_ & 16383, (byte)17, i_394_ >> 14 & 16383, anIntArray3845);
               if (bool_395_) {
                  intValues[intValueIndex++] = anIntArray3845[1];
                  intValues[intValueIndex++] = anIntArray3845[2];
               } else {
                  intValues[intValueIndex++] = -1;
                  intValues[intValueIndex++] = -1;
               }

               return;
            }

            intValues[intValueIndex++] = -1;
            intValues[intValueIndex++] = -1;
            return;
         }

         if (i == 5226) {
            CacheNode_Sub16_Sub2.method2392((byte)-99, intValues[--intValueIndex]);
            return;
         }

         if (i == 5227) {
            intValueIndex -= 2;
            int i_396_ = intValues[intValueIndex];
            int i_397_ = intValues[intValueIndex + 1];
            Node_Sub38_Sub5.method2802(i_396_, true, i_397_ & 16383, i_397_ >> 14 & 16383, -11493);
            return;
         }

         if (i == 5228) {
            ClientScript.aBoolean9510 = intValues[--intValueIndex] == 1;
            return;
         }

         if (i == 5229) {
            intValues[intValueIndex++] = ClientScript.aBoolean9510 ? 1 : 0;
            return;
         }

         if (i == 5230) {
            int i_398_ = intValues[--intValueIndex];
            Class98.method1083(i_398_, -126);
            return;
         }

         if (i == 5231) {
            intValueIndex -= 2;
            int i_399_ = intValues[intValueIndex];
            boolean bool_400_ = intValues[intValueIndex + 1] == 1;
            if (IComponentDefinitions.aHashTable4827 != null) {
               Node node = IComponentDefinitions.aHashTable4827.get(3512, (long)i_399_);
               if (node != null && !bool_400_) {
                  node.method2160((byte)127);
               } else if (node == null && bool_400_) {
                  node = new Node();
                  IComponentDefinitions.aHashTable4827.put((long)i_399_, node, -123);
               }
            }

            return;
         }

         if (i == 5232) {
            int i_401_ = intValues[--intValueIndex];
            if (IComponentDefinitions.aHashTable4827 != null) {
               Node node = IComponentDefinitions.aHashTable4827.get(3512, (long)i_401_);
               intValues[intValueIndex++] = node != null ? 1 : 0;
               return;
            }

            intValues[intValueIndex++] = 0;
            return;
         }

         if (i == 5233) {
            intValueIndex -= 2;
            int i_402_ = intValues[intValueIndex];
            boolean bool_403_ = intValues[intValueIndex + 1] == 1;
            if (CacheNode_Sub10.aHashTable9530 != null) {
               Node node = CacheNode_Sub10.aHashTable9530.get(3512, (long)i_402_);
               if (node != null && !bool_403_) {
                  node.method2160((byte)106);
               } else if (node == null && bool_403_) {
                  node = new Node();
                  CacheNode_Sub10.aHashTable9530.put((long)i_402_, node, -123);
               }
            }

            return;
         }

         if (i == 5234) {
            int i_404_ = intValues[--intValueIndex];
            if (CacheNode_Sub10.aHashTable9530 != null) {
               Node node = CacheNode_Sub10.aHashTable9530.get(3512, (long)i_404_);
               intValues[intValueIndex++] = node != null ? 1 : 0;
               return;
            }

            intValues[intValueIndex++] = 0;
            return;
         }

         if (i == 5235) {
            intValues[intValueIndex++] = WorldmapDefinitions.currentWorldmapArea != null ? WorldmapDefinitions.currentWorldmapArea.fileId : -1;
            return;
         }

         if (i == 5236) {
            intValueIndex -= 2;
            int i_405_ = intValues[intValueIndex];
            int i_406_ = intValues[intValueIndex + 1];
            int i_407_ = i_406_ >> 14 & 16383;
            int i_408_ = i_406_ & 16383;
            int i_409_ = Class270_Sub1_Sub1.method3301(i_405_, i_408_, -57, i_407_);
            if (i_409_ < 0) {
               intValues[intValueIndex++] = -1;
               return;
            }

            intValues[intValueIndex++] = i_409_;
            return;
         }

         if (i == 5237) {
            Class169.method1760(true);
            return;
         }
      } else if (i < 5400) {
         if (i == 5300) {
            intValueIndex -= 2;
            int i_410_ = intValues[intValueIndex];
            int i_411_ = intValues[intValueIndex + 1];
            Node_Sub38_Sub19.method2850(3, 3, i_410_, false, i_411_);
            intValues[intValueIndex++] = DrawableModel.aFrame907 != null ? 1 : 0;
            return;
         }

         if (i == 5301) {
            if (DrawableModel.aFrame907 != null) {
               Node_Sub38_Sub19.method2850(3, Class213.aNode_Sub27_2512.aClass320_Sub1_7287.method3678(false), -1, false, -1);
            }

            return;
         }

         if (i == 5302) {
            Class244[] class244s = Class312.method3624(0);
            intValues[intValueIndex++] = class244s.length;
            return;
         }

         if (i == 5303) {
            int i_412_ = intValues[--intValueIndex];
            Class244[] class244s = Class312.method3624(0);
            intValues[intValueIndex++] = class244s[i_412_].anInt3084;
            intValues[intValueIndex++] = class244s[i_412_].anInt3078;
            return;
         }

         if (i == 5305) {
            int i_413_ = Node_Sub38_Sub15.anInt10263;
            int i_414_ = Node_Sub10.anInt7083;
            int i_415_ = -1;
            Class244[] class244s = Class312.method3624(0);

            for(int i_416_ = 0; i_416_ < class244s.length; ++i_416_) {
               Class244 class244 = class244s[i_416_];
               if (class244.anInt3084 == i_413_ && class244.anInt3078 == i_414_) {
                  i_415_ = i_416_;
                  break;
               }
            }

            intValues[intValueIndex++] = i_415_;
            return;
         }

         if (i == 5306) {
            intValues[intValueIndex++] = Class188_Sub2_Sub1.getDisplayMode(3);
            return;
         }

         if (i == 5307) {
            int i_417_ = intValues[--intValueIndex];
            if (i_417_ >= 1 && i_417_ <= 2) {
               Node_Sub38_Sub19.method2850(3, i_417_, -1, false, -1);
               return;
            }

            return;
         }

         if (i == 5308) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub1_7287.method3678(false);
            return;
         }

         if (i == 5309) {
            int i_418_ = intValues[--intValueIndex];
            if (i_418_ >= 1 && i_418_ <= 2) {
               Class213.aNode_Sub27_2512.method2690(105, i_418_, Class213.aNode_Sub27_2512.aClass320_Sub1_7287);
               Class213.aNode_Sub27_2512.method2690(82, i_418_, Class213.aNode_Sub27_2512.aClass320_Sub1_7313);
               Node_Sub38_Sub31.method2893(1);
               return;
            }

            return;
         }
      } else if (i < 5500) {
         if (i == 5400) {
            stringValueIndex -= 2;
            String string = stringValues[stringValueIndex];
            String string_419_ = stringValues[stringValueIndex + 1];
            int i_420_ = intValues[--intValueIndex];
            ++anInt3863;
            Class123 class123 = Class262_Sub23.method3213((byte)-108);
            OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class320_Sub26.aClass318_8459, class123.issacKeys);
            node_sub13.currentOutgoingPacket.writeByte(Class126.method1536(-20826, string) + Class126.method1536(-20826, string_419_) + 1);
            node_sub13.currentOutgoingPacket.writeString(string);
            node_sub13.currentOutgoingPacket.writeString(string_419_);
            node_sub13.currentOutgoingPacket.writeByte(i_420_);
            class123.sendPacket(127, node_sub13);
            return;
         }

         if (i == 5401) {
            intValueIndex -= 2;
            Class343.aShortArray4255[intValues[intValueIndex]] = (short)Class96.getColorFromInt(-43, intValues[intValueIndex + 1]);
            EntityNode_Sub3_Sub1.aClass86_9166.method1006(-1);
            EntityNode_Sub3_Sub1.aClass86_9166.method1008(50);
            Class366.aClass279_4526.method3375((byte)118);
            Class320_Sub21.method3764(-103);
            return;
         }

         if (i == 5405) {
            intValueIndex -= 2;
            int i_421_ = intValues[intValueIndex];
            int i_422_ = intValues[intValueIndex + 1];
            if (i_421_ >= 0 && i_421_ < 2) {
               Class277_Sub1.anIntArrayArrayArray8042[i_421_] = new int[i_422_ << 1][4];
            }

            return;
         }

         if (i == 5406) {
            intValueIndex -= 7;
            int i_423_ = intValues[intValueIndex];
            int i_424_ = intValues[intValueIndex + 1] << 1;
            int i_425_ = intValues[intValueIndex + 2];
            int i_426_ = intValues[intValueIndex + 3];
            int i_427_ = intValues[intValueIndex + 4];
            int i_428_ = intValues[intValueIndex + 5];
            int i_429_ = intValues[intValueIndex + 6];
            if (i_423_ >= 0
               && i_423_ < 2
               && Class277_Sub1.anIntArrayArrayArray8042[i_423_] != null
               && i_424_ >= 0
               && i_424_ < Class277_Sub1.anIntArrayArrayArray8042[i_423_].length) {
               Class277_Sub1.anIntArrayArrayArray8042[i_423_][i_424_] = new int[]{(i_425_ >> 14 & 16383) << 9, i_426_ << 2, (i_425_ & 16383) << 9, i_429_};
               Class277_Sub1.anIntArrayArrayArray8042[i_423_][i_424_ + 1] = new int[]{(i_427_ >> 14 & 16383) << 9, i_428_ << 2, (i_427_ & 16383) << 9};
            }

            return;
         }

         if (i == 5407) {
            int i_430_ = Class277_Sub1.anIntArrayArrayArray8042[intValues[--intValueIndex]].length >> 1;
            intValues[intValueIndex++] = i_430_;
            return;
         }

         if (i == 5411) {
            if (DrawableModel.aFrame907 != null) {
               Node_Sub38_Sub19.method2850(3, Class213.aNode_Sub27_2512.aClass320_Sub1_7287.method3678(false), -1, false, -1);
            }

            if (Node_Sub29.aFrame7344 != null) {
               Class144.method1631((byte)125);
               System.exit(0);
               return;
            }

            String string = Class191.aString2350 != null ? Class191.aString2350 : CacheNode_Sub17.method2394((byte)47);
            Class355.method4017(-53, Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false) == 1, string, false, Class240.aSignLink2946);
            return;
         }

         if (i == 5419) {
            String string = "";
            if (Class237.aClass241_2904 != null) {
               if (Class237.aClass241_2904.anObject2956 != null) {
                  string = (String)Class237.aClass241_2904.anObject2956;
               } else {
                  string = EntityNode_Sub3_Sub1.method943((byte)-88, Class237.aClass241_2904.anInt2952);
               }
            }

            stringValues[stringValueIndex++] = string;
            return;
         }

         if (i == 5420) {
            intValues[intValueIndex++] = Class240.aSignLink2946.aBoolean4005 ? 0 : 1;
            return;
         }

         if (i == 5421) {
            if (DrawableModel.aFrame907 != null) {
               Node_Sub38_Sub19.method2850(3, Class213.aNode_Sub27_2512.aClass320_Sub1_7287.method3678(false), -1, false, -1);
            }

            String string = stringValues[--stringValueIndex];
            boolean bool_431_ = intValues[--intValueIndex] == 1;
            String string_432_ = CacheNode_Sub17.method2394((byte)47) + string;
            Class355.method4017(-117, Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false) == 1, string_432_, bool_431_, Class240.aSignLink2946);
            return;
         }

         if (i == 5422) {
            stringValueIndex -= 2;
            String string = stringValues[stringValueIndex];
            String string_433_ = stringValues[stringValueIndex + 1];
            int i_434_ = intValues[--intValueIndex];
            if (string.length() > 0) {
               if (CacheNode_Sub19.aStringArray9622 == null) {
                  CacheNode_Sub19.aStringArray9622 = new String[Node_Sub25_Sub3.anIntArray9966[Class209.aClass353_2483.anInt4344]];
               }

               CacheNode_Sub19.aStringArray9622[i_434_] = string;
            }

            if (string_433_.length() > 0) {
               if (Class320_Sub15.aStringArray8354 == null) {
                  Class320_Sub15.aStringArray8354 = new String[Node_Sub25_Sub3.anIntArray9966[Class209.aClass353_2483.anInt4344]];
               }

               Class320_Sub15.aStringArray8354[i_434_] = string_433_;
            }

            return;
         }

         if (i == 5423) {
            return;
         }

         if (i == 5424) {
            intValueIndex -= 11;
            AnimableAnimator.anInt5501 = intValues[intValueIndex];
            Node_Sub36_Sub3.anInt10056 = intValues[intValueIndex + 1];
            Class262_Sub5.anInt7737 = intValues[intValueIndex + 2];
            Class218.anInt2569 = intValues[intValueIndex + 3];
            Class40.anInt620 = intValues[intValueIndex + 4];
            Class150.anInt5085 = intValues[intValueIndex + 5];
            GLDrawableModel.anInt5710 = intValues[intValueIndex + 6];
            EntityNode_Sub3.anInt5965 = intValues[intValueIndex + 7];
            Class150.anInt5088 = intValues[intValueIndex + 8];
            Class320_Sub26.anInt8451 = intValues[intValueIndex + 9];
            Class340.anInt4209 = intValues[intValueIndex + 10];
            Node_Sub38_Sub39.index8.method3510(Class40.anInt620, (byte)63);
            Node_Sub38_Sub39.index8.method3510(Class150.anInt5085, (byte)63);
            Node_Sub38_Sub39.index8.method3510(GLDrawableModel.anInt5710, (byte)63);
            Node_Sub38_Sub39.index8.method3510(EntityNode_Sub3.anInt5965, (byte)63);
            Node_Sub38_Sub39.index8.method3510(Class150.anInt5088, (byte)63);
            Class290_Sub1.aGLSprite8062 = null;
            Class296.aGLSprite5437 = null;
            Exception_Sub1.aGLSprite98 = null;
            Class339_Sub7.aGLSprite8718 = null;
            aa.aGLSprite102 = null;
            Class247.aGLSprite3141 = null;
            Class286.aGLSprite3604 = null;
            Class40.aGLSprite621 = null;
            Node_Sub38_Sub5.aBoolean10130 = true;
            return;
         }

         if (i == 5425) {
            GameStub.method101(-15332);
            Node_Sub38_Sub5.aBoolean10130 = false;
            return;
         }

         if (i == 5426) {
            intValueIndex -= 2;
            Animable_Sub4_Sub1.anInt10687 = intValues[intValueIndex];
            Class230_Sub1.anInt9013 = intValues[intValueIndex + 1];
            return;
         }

         if (i == 5427) {
            intValueIndex -= 2;
            return;
         }

         if (i == 5428) {
            intValueIndex -= 2;
            int i_435_ = intValues[intValueIndex];
            int i_436_ = intValues[intValueIndex + 1];
            intValues[intValueIndex++] = Class138.method1603((byte)95, i_435_, i_436_) ? 1 : 0;
            return;
         }

         if (i == 5429) {
            Class126.processClientCommand(100, false, false, stringValues[--stringValueIndex]);
            return;
         }

         if (i == 5430) {
            try {
               Class2.method167("accountcreated", Class96.anApplet1270, (byte)-128);
            } catch (Throwable var9) {
            }

            return;
         }

         if (i == 5431) {
            try {
               Class2.method167("accountcreatestarted", Class96.anApplet1270, (byte)-112);
            } catch (Throwable var10) {
            }

            return;
         }

         if (i == 5432) {
            String string = "";
            if (Class102.aClipboard1315 != null) {
               Transferable transferable = Class102.aClipboard1315.getContents(null);
               if (transferable != null) {
                  try {
                     string = (String)transferable.getTransferData(DataFlavor.stringFlavor);
                     if (string == null) {
                        string = "";
                     }
                  } catch (Exception var11) {
                  }
               }
            }

            stringValues[stringValueIndex++] = string;
            return;
         }

         if (i == 5433) {
            Animable_Sub1.anInt9101 = intValues[--intValueIndex];
            return;
         }

         if (i == 5435) {
            intValues[intValueIndex++] = Animable_Sub2_Sub1.aBoolean10628 ? 1 : 0;
            return;
         }

         if (i == 5436) {
            if (Node_Sub23.aNode_Sub39_7201.anInt7474 < 6) {
               intValues[intValueIndex++] = 0;
               return;
            }

            if (Node_Sub23.aNode_Sub39_7201.anInt7474 == 6 && Node_Sub23.aNode_Sub39_7201.anInt7480 < 10) {
               intValues[intValueIndex++] = 0;
               return;
            }

            intValues[intValueIndex++] = 1;
            return;
         }
      } else if (i < 5600) {
         if (i == 5500) {
            intValueIndex -= 4;
            int i_437_ = intValues[intValueIndex];
            int i_438_ = intValues[intValueIndex + 1];
            int i_439_ = intValues[intValueIndex + 2];
            int i_440_ = intValues[intValueIndex + 3];
            Class188_Sub1_Sub1.method1895(
               (i_437_ >> 14 & 16383) - Node_Sub53.gameSceneBaseX,
               false,
               i_439_,
               (byte)103,
               i_438_ << 2,
               (i_437_ & 16383) - Class320_Sub4.gameSceneBaseY,
               i_440_
            );
            return;
         }

         if (i == 5501) {
            intValueIndex -= 4;
            int i_441_ = intValues[intValueIndex];
            int i_442_ = intValues[intValueIndex + 1];
            int i_443_ = intValues[intValueIndex + 2];
            int i_444_ = intValues[intValueIndex + 3];
            Class262_Sub22.method3210(
               i_443_, (i_441_ & 16383) - Class320_Sub4.gameSceneBaseY, -1, (i_441_ >> 14 & 16383) - Node_Sub53.gameSceneBaseX, i_442_ << 2, i_444_
            );
            return;
         }

         if (i == 5502) {
            intValueIndex -= 6;
            int i_445_ = intValues[intValueIndex];
            if (i_445_ >= 2) {
               throw new RuntimeException();
            }

            Class109.anInt1367 = i_445_;
            int i_446_ = intValues[intValueIndex + 1];
            if (i_446_ + 1 >= Class277_Sub1.anIntArrayArrayArray8042[Class109.anInt1367].length >> 1) {
               throw new RuntimeException();
            }

            Class290_Sub5.anInt8107 = i_446_;
            Class141.anInt1758 = 0;
            Node_Sub6.anInt7056 = intValues[intValueIndex + 2];
            Class221.anInt2633 = intValues[intValueIndex + 3];
            int i_447_ = intValues[intValueIndex + 4];
            if (i_447_ >= 2) {
               throw new RuntimeException();
            }

            Class203.anInt2452 = i_447_;
            int i_448_ = intValues[intValueIndex + 5];
            if (i_448_ + 1 >= Class277_Sub1.anIntArrayArrayArray8042[Class203.anInt2452].length >> 1) {
               throw new RuntimeException();
            }

            Class66_Sub2_Sub1.anInt10582 = i_448_;
            Class320_Sub22.anInt8415 = 3;
            Class368.anInt4551 = -1;
            Class367.anInt4541 = -1;
            return;
         }

         if (i == 5503) {
            Class368.method4080((byte)115);
            return;
         }

         if (i == 5504) {
            intValueIndex -= 2;
            Node_Sub38_Sub24.setCameraRotation(3, 0, intValues[intValueIndex + 1], intValues[intValueIndex]);
            return;
         }

         if (i == 5505) {
            intValues[intValueIndex++] = (int)Class257.cameraRotationVertical >> 3;
            return;
         }

         if (i == 5506) {
            intValues[intValueIndex++] = (int)Node_Sub12.cameraRotationHorizontal >> 3;
            return;
         }

         if (i == 5507) {
            Class320_Sub28.method3784((byte)-7);
            return;
         }

         if (i == 5508) {
            Mobile_Sub4.method910(0);
            return;
         }

         if (i == 5509) {
            Class320_Sub11.method3725(0);
            return;
         }

         if (i == 5510) {
            Node_Sub38_Sub23.method2865((byte)-68);
            return;
         }

         if (i == 5511) {
            int i_449_ = intValues[--intValueIndex];
            int i_450_ = i_449_ >> 14 & 16383;
            int i_451_ = i_449_ & 16383;
            i_450_ -= Node_Sub53.gameSceneBaseX;
            if (i_450_ < 0) {
               i_450_ = 0;
            } else if (i_450_ >= Node_Sub54.GAME_SCENE_WDITH) {
               i_450_ = Node_Sub54.GAME_SCENE_WDITH;
            }

            i_451_ -= Class320_Sub4.gameSceneBaseY;
            if (i_451_ < 0) {
               i_451_ = 0;
            } else if (i_451_ >= Class377_Sub1.GAME_SCENE_HEIGHT) {
               i_451_ = Class377_Sub1.GAME_SCENE_HEIGHT;
            }

            Class234.anInt2792 = (i_450_ << 9) + 256;
            Node_Sub19.anInt7173 = (i_451_ << 9) + 256;
            Class320_Sub22.anInt8415 = 4;
            Class368.anInt4551 = -1;
            Class367.anInt4541 = -1;
            return;
         }

         if (i == 5512) {
            Class76.method768(-147);
            return;
         }

         if (i == 5514) {
            Class308.orthoZoom = intValues[--intValueIndex];
            return;
         }

         if (i == 5516) {
            intValues[intValueIndex++] = Class308.orthoZoom;
            return;
         }

         if (i == 5517) {
            int i_452_ = intValues[--intValueIndex];
            if (i_452_ == -1) {
               int i_453_ = i_452_ >> 14 & 16383;
               int i_454_ = i_452_ & 16383;
               i_453_ -= Node_Sub53.gameSceneBaseX;
               if (i_453_ < 0) {
                  i_453_ = 0;
               } else if (i_453_ >= Node_Sub54.GAME_SCENE_WDITH) {
                  i_453_ = Node_Sub54.GAME_SCENE_WDITH;
               }

               i_454_ -= Class320_Sub4.gameSceneBaseY;
               if (i_454_ < 0) {
                  i_454_ = 0;
               } else if (i_454_ >= Class377_Sub1.GAME_SCENE_HEIGHT) {
                  i_454_ = Class377_Sub1.GAME_SCENE_HEIGHT;
               }

               Class367.anInt4541 = (i_453_ << 9) + 256;
               Class368.anInt4551 = (i_454_ << 9) + 256;
               return;
            }

            Class367.anInt4541 = -1;
            Class368.anInt4551 = -1;
            return;
         }

         if (i == 5547) {
            intValues[intValueIndex++] = Class320_Sub22.anInt8415 == 1 ? 1 : 0;
            return;
         }
      } else if (i < 5700) {
         if (i == 5600) {
            stringValueIndex -= 2;
            String string = stringValues[stringValueIndex];
            String string_455_ = stringValues[stringValueIndex + 1];
            int i_456_ = intValues[--intValueIndex];
            Class39.login(i_456_, string_455_, string, -113);
            return;
         }

         if (i == 5601) {
            Class320_Sub1.method3681(11439);
            return;
         }

         if (i == 5602) {
            if (!Class132.method1561(-1)) {
               Class375.method4115((byte)-43);
            }

            return;
         }

         if (i == 5604) {
            --stringValueIndex;
            if (Class151.anInt1843 == 3 && !Class132.method1561(-1) && Class4.anInt124 == 0) {
               Class55.method558((byte)-119, stringValues[stringValueIndex]);
               return;
            }

            return;
         }

         if (i == 5605) {
            stringValueIndex -= 2;
            intValueIndex -= 2;
            if (Class151.anInt1843 == 3 && !Class132.method1561(-1) && Class4.anInt124 == 0) {
               Class48.method483(
                  stringValues[stringValueIndex], intValues[intValueIndex], stringValues[stringValueIndex + 1], intValues[intValueIndex + 1] == 1, 3
               );
               return;
            }

            return;
         }

         if (i == 5606) {
            if (Class4.anInt124 == 0) {
               Node_Sub36_Sub4.anInt10073 = -2;
            }

            return;
         }

         if (i == 5607) {
            intValues[intValueIndex++] = Class339_Sub2.anInt8653;
            return;
         }

         if (i == 5608) {
            intValues[intValueIndex++] = FileOnDisk.anInt1326;
            return;
         }

         if (i == 5609) {
            intValues[intValueIndex++] = Node_Sub36_Sub4.anInt10073;
            return;
         }

         if (i == 5611) {
            intValues[intValueIndex++] = GameStub.anInt45;
            return;
         }

         if (i == 5612) {
            int i_457_ = intValues[--intValueIndex];
            ItemDefinitions.method1673(i_457_, 2);
            return;
         }

         if (i == 5613) {
            intValues[intValueIndex++] = Class339_Sub2.anInt8653;
            return;
         }

         if (i == 5615) {
            stringValueIndex -= 2;
            String string = stringValues[stringValueIndex];
            String string_458_ = stringValues[stringValueIndex + 1];
            Class120.method1229(string_458_, string, (byte)88);
            return;
         }

         if (i == 5616) {
            Class127.logout(11582, false);
            return;
         }

         if (i == 5617) {
            intValues[intValueIndex++] = Class152.anInt1941;
            return;
         }

         if (i == 5618) {
            --intValueIndex;
            return;
         }

         if (i == 5619) {
            --intValueIndex;
            return;
         }

         if (i == 5620) {
            intValues[intValueIndex++] = 0;
            return;
         }

         if (i == 5621) {
            stringValueIndex -= 2;
            intValueIndex -= 2;
            return;
         }

         if (i == 5622) {
            return;
         }

         if (i == 5623) {
            if (Class143.aByteArray1773 != null) {
               intValues[intValueIndex++] = 1;
               return;
            }

            intValues[intValueIndex++] = 0;
            return;
         }

         if (i == 5624) {
            intValues[intValueIndex++] = (int)(Node_Sub32.aLong7385 >> 32);
            intValues[intValueIndex++] = (int)(Node_Sub32.aLong7385 & -1L);
            return;
         }

         if (i == 5625) {
            intValues[intValueIndex++] = Class255.aBoolean3218 ? 1 : 0;
            return;
         }

         if (i == 5626) {
            Class255.aBoolean3218 = true;
            Class189.method1933(-9014);
            return;
         }

         if (i == 5627) {
            intValues[intValueIndex++] = Class270_Sub2_Sub1.anInt10548;
            intValues[intValueIndex++] = Class339_Sub5.anInt8684;
            intValues[intValueIndex++] = Node_Sub38_Sub34.anInt10447;
            Class270_Sub2_Sub1.anInt10548 = -2;
            Class339_Sub5.anInt8684 = -1;
            Node_Sub38_Sub34.anInt10447 = -1;
            return;
         }

         if (i == 5628) {
            intValues[intValueIndex++] = Class132.method1561(-1) ? 1 : 0;
            return;
         }

         if (i == 5629) {
            intValues[intValueIndex++] = Node_Sub15_Sub13.anInt9874;
            return;
         }

         if (i == 5630) {
            TemporaryItemDefinition.method403(0);
            return;
         }

         if (i == 5631) {
            intValueIndex -= 2;
            int i_459_ = intValues[intValueIndex];
            int i_460_ = intValues[intValueIndex + 1];
            Animable.method822(i_459_, i_460_, 4);
            return;
         }

         if (i == 5632) {
            int i_461_ = intValues[--intValueIndex];
            Class290_Sub5.method3434(i_461_, (byte)27);
            return;
         }

         if (i == 5633) {
            intValues[intValueIndex++] = Class187.anInt2276;
            return;
         }
      } else if (i < 6100) {
         if (i == 6001) {
            int i_462_ = intValues[--intValueIndex];
            Class213.aNode_Sub27_2512.method2690(31, i_462_, Class213.aNode_Sub27_2512.aClass320_Sub22_7299);
            Class243.method3061(7);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6002) {
            boolean bool_463_ = intValues[--intValueIndex] == 1;
            Class213.aNode_Sub27_2512.method2690(121, bool_463_ ? 1 : 0, Class213.aNode_Sub27_2512.aClass320_Sub19_7277);
            Class213.aNode_Sub27_2512.method2690(18, bool_463_ ? 1 : 0, Class213.aNode_Sub27_2512.aClass320_Sub19_7301);
            Class243.method3061(7);
            Class46.method471(-1);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6003) {
            boolean bool_464_ = intValues[--intValueIndex] == 1;
            Class213.aNode_Sub27_2512.method2690(79, bool_464_ ? 2 : 1, Class213.aNode_Sub27_2512.aClass320_Sub4_7302);
            Class213.aNode_Sub27_2512.method2690(22, bool_464_ ? 2 : 1, Class213.aNode_Sub27_2512.aClass320_Sub4_7304);
            Class46.method471(-1);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6005) {
            Class213.aNode_Sub27_2512.method2690(122, intValues[--intValueIndex] == 1 ? 1 : 0, Class213.aNode_Sub27_2512.aClass320_Sub6_7267);
            Class243.method3061(7);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6007) {
            Class213.aNode_Sub27_2512.method2690(22, intValues[--intValueIndex], Class213.aNode_Sub27_2512.aClass320_Sub27_7266);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6008) {
            Class213.aNode_Sub27_2512.method2690(60, intValues[--intValueIndex] == 1 ? 1 : 0, Class213.aNode_Sub27_2512.aClass320_Sub8_7280);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6010) {
            Class213.aNode_Sub27_2512.method2690(31, intValues[--intValueIndex] == 1 ? 1 : 0, Class213.aNode_Sub27_2512.aClass320_Sub7_7308);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6011) {
            Class213.aNode_Sub27_2512.method2690(118, intValues[--intValueIndex], Class213.aNode_Sub27_2512.aClass320_Sub12_7282);
            Class243.method3061(7);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6012) {
            Class213.aNode_Sub27_2512.method2690(95, intValues[--intValueIndex] == 1 ? 1 : 0, Class213.aNode_Sub27_2512.aClass320_Sub24_7317);
            Class320_Sub12.method3728(0);
            Class120.method1228(-108);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6014) {
            Class213.aNode_Sub27_2512.method2690(81, intValues[--intValueIndex] == 1 ? 2 : 0, Class213.aNode_Sub27_2512.aClass320_Sub26_7269);
            Class243.method3061(7);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6015) {
            Class213.aNode_Sub27_2512.method2690(17, intValues[--intValueIndex] == 1 ? 1 : 0, Class213.aNode_Sub27_2512.aClass320_Sub16_7316);
            Class243.method3061(7);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6016) {
            Class213.aNode_Sub27_2512.method2690(96, intValues[--intValueIndex], Class213.aNode_Sub27_2512.aClass320_Sub13_7283);
            Class22.method300(Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false), true, false);
            Node_Sub38_Sub31.method2893(1);
            return;
         }

         if (i == 6017) {
            Class213.aNode_Sub27_2512.method2690(50, intValues[--intValueIndex] == 1 ? 1 : 0, Class213.aNode_Sub27_2512.aClass320_Sub17_7311);
            Class83.method800((byte)106);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6018) {
            Class213.aNode_Sub27_2512.method2690(42, intValues[--intValueIndex], Class213.aNode_Sub27_2512.aClass320_Sub25_7295);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6019) {
            int i_465_ = intValues[--intValueIndex];
            int i_466_ = Class213.aNode_Sub27_2512.aClass320_Sub25_7274.method3776(false);
            if (i_465_ != i_466_) {
               if (Class58.method577(Class151.anInt1843, -22906)) {
                  if (i_466_ == 0 && Class313.anInt4013 != -1) {
                     Class339_Sub8.method3946(Class313.anInt4013, 0, i_465_, SeekableFile.index6, false, 23732);
                     EntityNode_Sub7.method979(17285);
                     Class377_Sub1.aBoolean8775 = false;
                  } else if (i_465_ == 0) {
                     Class320_Sub2.method3685(-86);
                     Class377_Sub1.aBoolean8775 = false;
                  } else {
                     Class64.method710((byte)-90, i_465_);
                  }
               }

               Class213.aNode_Sub27_2512.method2690(123, i_465_, Class213.aNode_Sub27_2512.aClass320_Sub25_7274);
               Node_Sub38_Sub31.method2893(1);
               Class269.aBoolean3472 = false;
            }

            return;
         }

         if (i == 6020) {
            Class213.aNode_Sub27_2512.method2690(23, intValues[--intValueIndex], Class213.aNode_Sub27_2512.aClass320_Sub25_7265);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6021) {
            int i_467_ = Class213.aNode_Sub27_2512.aClass320_Sub4_7302.method3694(false);
            Class213.aNode_Sub27_2512.method2690(69, intValues[--intValueIndex] == 1 ? 0 : i_467_, Class213.aNode_Sub27_2512.aClass320_Sub4_7304);
            Class46.method471(-1);
            return;
         }

         if (i == 6023) {
            int i_468_ = intValues[--intValueIndex];
            Class213.aNode_Sub27_2512.method2690(111, i_468_, Class213.aNode_Sub27_2512.aClass320_Sub28_7305);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6024) {
            Class213.aNode_Sub27_2512.method2690(103, intValues[--intValueIndex], Class213.aNode_Sub27_2512.aClass320_Sub13_7284);
            Node_Sub38_Sub31.method2893(1);
            return;
         }

         if (i == 6025) {
            Class213.aNode_Sub27_2512.method2690(60, intValues[--intValueIndex], Class213.aNode_Sub27_2512.aClass320_Sub5_7297);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6027) {
            int i_469_ = intValues[--intValueIndex];
            if (i_469_ < 0 || i_469_ > 1) {
               i_469_ = 0;
            }

            Node_Sub19.method2610((byte)-58, i_469_ == 1);
            return;
         }

         if (i == 6028) {
            Class213.aNode_Sub27_2512.method2690(93, intValues[--intValueIndex] != 0 ? 1 : 0, Class213.aNode_Sub27_2512.aClass320_Sub14_7268);
            Node_Sub38_Sub31.method2893(1);
            return;
         }

         if (i == 6029) {
            Class213.aNode_Sub27_2512.method2690(45, intValues[--intValueIndex], Class213.aNode_Sub27_2512.aClass320_Sub27_7266);
            Node_Sub38_Sub31.method2893(1);
            return;
         }

         if (i == 6030) {
            Class213.aNode_Sub27_2512.method2690(48, intValues[--intValueIndex] != 0 ? 1 : 0, Class213.aNode_Sub27_2512.aClass320_Sub23_7290);
            Node_Sub38_Sub31.method2893(1);
            Class243.method3061(7);
            return;
         }

         if (i == 6031) {
            int i_470_ = intValues[--intValueIndex];
            if (i_470_ < 0 || i_470_ > 5) {
               i_470_ = 2;
            }

            Class22.method300(i_470_, true, false);
            return;
         }

         if (i == 6032) {
            intValueIndex -= 2;
            int i_471_ = intValues[intValueIndex];
            boolean bool_472_ = intValues[intValueIndex + 1] == 1;
            Class213.aNode_Sub27_2512.method2690(46, i_471_, Class213.aNode_Sub27_2512.aClass320_Sub29_7291);
            if (!bool_472_) {
               Class213.aNode_Sub27_2512.method2690(112, 0, Class213.aNode_Sub27_2512.aClass320_Sub15_7273);
            }

            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6033) {
            Class213.aNode_Sub27_2512.method2690(81, intValues[--intValueIndex], Class213.aNode_Sub27_2512.aClass320_Sub21_7293);
            Node_Sub38_Sub31.method2893(1);
            return;
         }

         if (i == 6034) {
            Class213.aNode_Sub27_2512.method2690(44, intValues[--intValueIndex] == 1 ? 1 : 0, Class213.aNode_Sub27_2512.aClass320_Sub30_7275);
            Node_Sub38_Sub31.method2893(1);
            Class320_Sub12.method3728(0);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6035) {
            int i_473_ = Class213.aNode_Sub27_2512.aClass320_Sub19_7277.method3751(false);
            Class213.aNode_Sub27_2512.method2690(92, intValues[--intValueIndex] == 1 ? 1 : i_473_, Class213.aNode_Sub27_2512.aClass320_Sub19_7301);
            Class243.method3061(7);
            Class46.method471(-1);
            return;
         }

         if (i == 6036) {
            Class213.aNode_Sub27_2512.method2690(69, intValues[--intValueIndex], Class213.aNode_Sub27_2512.aClass320_Sub18_7303);
            Node_Sub38_Sub31.method2893(1);
            Class152.aBoolean1942 = true;
            return;
         }

         if (i == 6037) {
            Class213.aNode_Sub27_2512.method2690(49, intValues[--intValueIndex], Class213.aNode_Sub27_2512.aClass320_Sub25_7276);
            Node_Sub38_Sub31.method2893(1);
            Class269.aBoolean3472 = false;
            return;
         }

         if (i == 6038) {
            int i_474_ = intValues[--intValueIndex];
            int i_475_ = Class213.aNode_Sub27_2512.aClass320_Sub25_7309.method3776(false);
            if (i_474_ != i_475_ && Class313.anInt4013 == Class317.anInt4038) {
               if (!Class58.method577(Class151.anInt1843, -22906)) {
                  if (i_475_ == 0) {
                     Class339_Sub8.method3946(Class313.anInt4013, 0, i_474_, SeekableFile.index6, false, 23732);
                     EntityNode_Sub7.method979(17285);
                     Class377_Sub1.aBoolean8775 = false;
                  } else if (i_474_ == 0) {
                     Class320_Sub2.method3685(-119);
                     Class377_Sub1.aBoolean8775 = false;
                  } else {
                     Class64.method710((byte)-90, i_474_);
                  }
               }

               Class213.aNode_Sub27_2512.method2690(126, i_474_, Class213.aNode_Sub27_2512.aClass320_Sub25_7309);
               Node_Sub38_Sub31.method2893(1);
               Class269.aBoolean3472 = false;
            }

            return;
         }

         if (i == 6039) {
            int i_476_ = intValues[--intValueIndex];
            if (i_476_ > 255 || i_476_ < 0) {
               i_476_ = 0;
            }

            if (i_476_ != Class213.aNode_Sub27_2512.aClass320_Sub11_7264.method3722(false)) {
               Class213.aNode_Sub27_2512.method2690(32, i_476_, Class213.aNode_Sub27_2512.aClass320_Sub11_7264);
               Node_Sub38_Sub31.method2893(1);
               Class269.aBoolean3472 = false;
            }

            return;
         }

         if (i == 6040) {
            int i_477_ = intValues[--intValueIndex];
            if (i_477_ != Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false)) {
               Class213.aNode_Sub27_2512.method2690(89, i_477_, Class213.aNode_Sub27_2512.aClass320_Sub3_7298);
               Node_Sub38_Sub31.method2893(1);
               Class269.aBoolean3472 = false;
               Class34_Sub1.method378(-4);
            }

            return;
         }

         if (i == 6041) {
            int i_478_ = intValues[--intValueIndex];
            if (i_478_ != Class213.aNode_Sub27_2512.aClass320_Sub2_7272.method3686(false)) {
               Class213.aNode_Sub27_2512.method2690(53, i_478_, Class213.aNode_Sub27_2512.aClass320_Sub2_7272);
               Node_Sub38_Sub31.method2893(1);
               Class269.aBoolean3472 = false;
            }

            return;
         }
      } else if (i < 6200) {
         if (i == 6101) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub22_7299.method3765(false);
            return;
         }

         if (i == 6102) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub19_7277.method3751(false) == 1 ? 1 : 0;
            return;
         }

         if (i == 6103) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub4_7302.method3694(false) == 2 ? 1 : 0;
            return;
         }

         if (i == 6105) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub6_7267.method3701(false) == 1 ? 1 : 0;
            return;
         }

         if (i == 6107) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub27_7266.method3783(false);
            return;
         }

         if (i == 6108) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub8_7280.method3712(false) == 1 ? 1 : 0;
            return;
         }

         if (i == 6110) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub7_7308.method3708(false) == 1 ? 1 : 0;
            return;
         }

         if (i == 6111) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub12_7282.method3730(false);
            return;
         }

         if (i == 6112) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub24_7317.method3773(false) == 1 ? 1 : 0;
            return;
         }

         if (i == 6114) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub26_7269.method3779(false) == 2 ? 1 : 0;
            return;
         }

         if (i == 6115) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub16_7316.method3744(false) == 1 ? 1 : 0;
            return;
         }

         if (i == 6116) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub13_7283.method3734(false);
            return;
         }

         if (i == 6117) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub17_7311.method3747(false) == 1 ? 1 : 0;
            return;
         }

         if (i == 6118) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub25_7295.method3776(false);
            return;
         }

         if (i == 6119) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub25_7274.method3776(false);
            return;
         }

         if (i == 6120) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub25_7265.method3776(false);
            return;
         }

         if (i == 6123) {
            intValues[intValueIndex++] = Class235.method2156(-10532);
            return;
         }

         if (i == 6124) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub13_7284.method3734(false);
            return;
         }

         if (i == 6125) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub5_7297.method3697(false);
            return;
         }

         if (i == 6127) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub20_7306.method3758(false) == 1 ? 1 : 0;
            return;
         }

         if (i == 6128) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub14_7268.method3737(false) == 1 ? 1 : 0;
            return;
         }

         if (i == 6129) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub27_7266.method3783(false);
            return;
         }

         if (i == 6130) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub23_7290.method3770(false) == 1 ? 1 : 0;
            return;
         }

         if (i == 6131) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false);
            return;
         }

         if (i == 6132) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub29_7291.method3791(false);
            return;
         }

         if (i == 6133) {
            intValues[intValueIndex++] = Class240.aSignLink2946.aBoolean4005 && !Class240.aSignLink2946.aBoolean3985 ? 1 : 0;
            return;
         }

         if (i == 6135) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub21_7293.method3762(false);
            return;
         }

         if (i == 6136) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub30_7275.method3796(false) == 1 ? 1 : 0;
            return;
         }

         if (i == 6138) {
            intValues[intValueIndex++] = Class194.method1961(200, Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false), 13968);
            return;
         }

         if (i == 6139) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub18_7303.method3749(false);
            return;
         }

         if (i == 6142) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub25_7276.method3776(false);
            return;
         }

         if (i == 6143) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub25_7309.method3776(false);
            return;
         }

         if (i == 6144) {
            intValues[intValueIndex++] = CacheNode_Sub1.aBoolean9425 ? 1 : 0;
            return;
         }

         if (i == 6145) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub11_7264.method3722(false);
            return;
         }

         if (i == 6146) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false);
            return;
         }

         if (i == 6147) {
            intValues[intValueIndex++] = Node_Sub23.aNode_Sub39_7201.anInt7484 >= 512 && !CacheNode_Sub1.aBoolean9425 && !Node_Sub12.aBoolean5456 ? 0 : 1;
            return;
         }

         if (i == 6148) {
            intValues[intValueIndex++] = Node_Sub32.aBoolean7377 ? 1 : 0;
            return;
         }

         if (i == 6149) {
            intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub2_7272.method3686(false);
            return;
         }
      } else if (i < 6300) {
         if (i == 6200) {
            intValueIndex -= 2;
            Node_Sub29_Sub3.aShort10027 = (short)intValues[intValueIndex];
            if (Node_Sub29_Sub3.aShort10027 <= 0) {
               Node_Sub29_Sub3.aShort10027 = 256;
            }

            Node_Sub29_Sub3.aShort10026 = (short)intValues[intValueIndex + 1];
            if (Node_Sub29_Sub3.aShort10026 <= 0) {
               Node_Sub29_Sub3.aShort10026 = 205;
            }

            return;
         }

         if (i == 6201) {
            intValueIndex -= 2;
            Class144_Sub1.aShort6804 = (short)intValues[intValueIndex];
            if (Class144_Sub1.aShort6804 <= 0) {
               Class144_Sub1.aShort6804 = 256;
            }

            Class268.aShort3455 = (short)intValues[intValueIndex + 1];
            if (Class268.aShort3455 <= 0) {
               Class268.aShort3455 = 320;
            }

            return;
         }

         if (i == 6202) {
            intValueIndex -= 4;
            Class18.aShort310 = (short)intValues[intValueIndex];
            if (Class18.aShort310 <= 0) {
               Class18.aShort310 = 1;
            }

            OutgoingPacket.aShort4053 = (short)intValues[intValueIndex + 1];
            if (OutgoingPacket.aShort4053 <= 0) {
               OutgoingPacket.aShort4053 = 32767;
            } else if (OutgoingPacket.aShort4053 < Class18.aShort310) {
               OutgoingPacket.aShort4053 = Class18.aShort310;
            }

            Class291.aShort3667 = (short)intValues[intValueIndex + 2];
            if (Class291.aShort3667 <= 0) {
               Class291.aShort3667 = 1;
            }

            Animable_Sub2_Sub2.aShort10750 = (short)intValues[intValueIndex + 3];
            if (Animable_Sub2_Sub2.aShort10750 <= 0) {
               Animable_Sub2_Sub2.aShort10750 = 32767;
               return;
            }

            if (Animable_Sub2_Sub2.aShort10750 < Class291.aShort3667) {
               Animable_Sub2_Sub2.aShort10750 = Class291.aShort3667;
            }

            return;
         }

         if (i == 6203) {
            Class34_Sub1.method375(0, false, 0, Class324.aWidget4085.height, (byte)-98, Class324.aWidget4085.width);
            intValues[intValueIndex++] = Class132.anInt1684;
            intValues[intValueIndex++] = Class111.anInt1418;
            return;
         }

         if (i == 6204) {
            intValues[intValueIndex++] = Class144_Sub1.aShort6804;
            intValues[intValueIndex++] = Class268.aShort3455;
            return;
         }

         if (i == 6205) {
            intValues[intValueIndex++] = Node_Sub29_Sub3.aShort10027;
            intValues[intValueIndex++] = Node_Sub29_Sub3.aShort10026;
            return;
         }
      } else if (i < 6400) {
         if (i == 6300) {
            intValues[intValueIndex++] = (int)(Class313.method3650(false) / 60000L);
            return;
         }

         if (i == 6301) {
            intValues[intValueIndex++] = (int)(Class313.method3650(false) / 86400000L) - 11745;
            return;
         }

         if (i == 6302) {
            intValueIndex -= 3;
            int i_479_ = intValues[intValueIndex];
            int i_480_ = intValues[intValueIndex + 1];
            int i_481_ = intValues[intValueIndex + 2];
            long l = TileMarker.getTimeSinceLaunch(i_480_, 0, i_481_, 0, i_479_, 12, (byte)76);
            int i_482_ = Class42.method444(l, false);
            if (i_481_ < 1970) {
               --i_482_;
            }

            intValues[intValueIndex++] = i_482_;
            return;
         }

         if (i == 6303) {
            intValues[intValueIndex++] = LightFX.method3817(true, Class313.method3650(false));
            return;
         }

         if (i == 6304) {
            int i_483_ = intValues[--intValueIndex];
            boolean bool_484_ = true;
            if (i_483_ < 0) {
               bool_484_ = (i_483_ + 1) % 4 == 0;
            } else if (i_483_ < 1582) {
               bool_484_ = i_483_ % 4 == 0;
            } else if (i_483_ % 4 != 0) {
               bool_484_ = false;
            } else if (i_483_ % 100 != 0) {
               bool_484_ = true;
            } else if (i_483_ % 400 != 0) {
               bool_484_ = false;
            }

            intValues[intValueIndex++] = bool_484_ ? 1 : 0;
            return;
         }

         if (i == 6305) {
            int i_485_ = intValues[--intValueIndex];
            int[] is = Node_Sub15_Sub4.method2566(i_485_, 2);
            Class311.method3609(is, 0, intValues, intValueIndex, 3);
            intValueIndex += 3;
            return;
         }

         if (i == 6306) {
            int i_486_ = intValues[--intValueIndex];
            intValues[intValueIndex++] = (int)(Class25.method308(i_486_, false) / 60000L);
            return;
         }
      } else if (i < 6500) {
         if (i == 6405) {
            intValues[intValueIndex++] = AbstractToolkit.method1343((byte)66) ? 1 : 0;
            return;
         }

         if (i == 6406) {
            intValues[intValueIndex++] = GLSprite_Sub1.method1202((byte)21) ? 1 : 0;
            return;
         }
      } else if (i < 6600) {
         if (i == 6500) {
            if (Class151.anInt1843 == 7 && !Class132.method1561(-1) && Class4.anInt124 == 0) {
               if (Class82.aBoolean1122) {
                  intValues[intValueIndex++] = 0;
                  return;
               }

               if (Class194.aLong2374 > Class313.method3650(false) - 1000L) {
                  intValues[intValueIndex++] = 1;
                  return;
               }

               Class82.aBoolean1122 = true;
               OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class126.aClass318_1632, Class218.aClass123_2560.issacKeys);
               node_sub13.currentOutgoingPacket.writeInt(Node_Sub38_Sub17.anInt10274);
               Class218.aClass123_2560.sendPacket(127, node_sub13);
               intValues[intValueIndex++] = 0;
               return;
            }

            intValues[intValueIndex++] = 1;
            return;
         }

         if (i == 6501) {
            Class377_Sub1 class377_sub1 = Class384.method4202((byte)-92);
            if (class377_sub1 != null) {
               intValues[intValueIndex++] = class377_sub1.anInt8777;
               intValues[intValueIndex++] = class377_sub1.anInt4673;
               stringValues[stringValueIndex++] = class377_sub1.aString8780;
               Class46 class46 = class377_sub1.method4131((byte)-97);
               intValues[intValueIndex++] = class46.anInt675;
               stringValues[stringValueIndex++] = class46.aString678;
               intValues[intValueIndex++] = class377_sub1.anInt4671;
               intValues[intValueIndex++] = class377_sub1.anInt8779;
               stringValues[stringValueIndex++] = class377_sub1.aString8773;
               return;
            }

            intValues[intValueIndex++] = -1;
            intValues[intValueIndex++] = 0;
            stringValues[stringValueIndex++] = "";
            intValues[intValueIndex++] = 0;
            stringValues[stringValueIndex++] = "";
            intValues[intValueIndex++] = 0;
            intValues[intValueIndex++] = 0;
            stringValues[stringValueIndex++] = "";
            return;
         }

         if (i == 6502) {
            Class377_Sub1 class377_sub1 = CacheNode_Sub16_Sub1.method2389(61);
            if (class377_sub1 != null) {
               intValues[intValueIndex++] = class377_sub1.anInt8777;
               intValues[intValueIndex++] = class377_sub1.anInt4673;
               stringValues[stringValueIndex++] = class377_sub1.aString8780;
               Class46 class46 = class377_sub1.method4131((byte)-97);
               intValues[intValueIndex++] = class46.anInt675;
               stringValues[stringValueIndex++] = class46.aString678;
               intValues[intValueIndex++] = class377_sub1.anInt4671;
               intValues[intValueIndex++] = class377_sub1.anInt8779;
               stringValues[stringValueIndex++] = class377_sub1.aString8773;
               return;
            }

            intValues[intValueIndex++] = -1;
            intValues[intValueIndex++] = 0;
            stringValues[stringValueIndex++] = "";
            intValues[intValueIndex++] = 0;
            stringValues[stringValueIndex++] = "";
            intValues[intValueIndex++] = 0;
            intValues[intValueIndex++] = 0;
            stringValues[stringValueIndex++] = "";
            return;
         }

         if (i == 6503) {
            int i_487_ = intValues[--intValueIndex];
            String string = stringValues[--stringValueIndex];
            if (Class151.anInt1843 == 7 && !Class132.method1561(-1) && Class4.anInt124 == 0) {
               intValues[intValueIndex++] = Class188_Sub1_Sub2.method1899(i_487_, (byte)27, string) ? 1 : 0;
               return;
            }

            intValues[intValueIndex++] = 0;
            return;
         }

         if (i == 6506) {
            int i_488_ = intValues[--intValueIndex];
            Class377_Sub1 class377_sub1 = Class327.method3823(100, i_488_);
            if (class377_sub1 != null) {
               intValues[intValueIndex++] = class377_sub1.anInt4673;
               stringValues[stringValueIndex++] = class377_sub1.aString8780;
               Class46 class46 = class377_sub1.method4131((byte)-97);
               intValues[intValueIndex++] = class46.anInt675;
               stringValues[stringValueIndex++] = class46.aString678;
               intValues[intValueIndex++] = class377_sub1.anInt4671;
               intValues[intValueIndex++] = class377_sub1.anInt8779;
               stringValues[stringValueIndex++] = class377_sub1.aString8773;
               return;
            }

            intValues[intValueIndex++] = -1;
            stringValues[stringValueIndex++] = "";
            intValues[intValueIndex++] = 0;
            stringValues[stringValueIndex++] = "";
            intValues[intValueIndex++] = 0;
            intValues[intValueIndex++] = 0;
            stringValues[stringValueIndex++] = "";
            return;
         }

         if (i == 6507) {
            intValueIndex -= 4;
            int i_489_ = intValues[intValueIndex];
            boolean bool_490_ = intValues[intValueIndex + 1] == 1;
            int i_491_ = intValues[intValueIndex + 2];
            boolean bool_492_ = intValues[intValueIndex + 3] == 1;
            Class66_Sub1.method723((byte)57, bool_490_, i_491_, i_489_, bool_492_);
            return;
         }

         if (i == 6508) {
            EntityNode.method802(2126);
            return;
         }

         if (i == 6509) {
            if (Class151.anInt1843 == 7) {
               Node_Sub38_Sub5.aBoolean10125 = intValues[--intValueIndex] == 1;
               return;
            }

            return;
         }

         if (i == 6510) {
            intValues[intValueIndex++] = Class380.anInt4877;
            return;
         }
      } else if (i >= 6700) {
         if (i < 6800 && OutgoingPacket.aClass129_4051 == Class123.aClass129_1564) {
            if (i == 6700) {
               int i_493_ = OverlayDefinition.aHashTable3630.method1519((byte)-90);
               if (Class320_Sub15.WINDOWS_PANE_ID != -1) {
                  ++i_493_;
               }

               intValues[intValueIndex++] = i_493_;
               return;
            }

            if (i == 6701) {
               int i_494_ = intValues[--intValueIndex];
               if (Class320_Sub15.WINDOWS_PANE_ID != -1) {
                  if (i_494_ == 0) {
                     intValues[intValueIndex++] = Class320_Sub15.WINDOWS_PANE_ID;
                     return;
                  }

                  --i_494_;
               }

               Node_Sub2 node_sub2 = (Node_Sub2)OverlayDefinition.aHashTable3630.method1516(false);

               while(i_494_-- > 0) {
                  node_sub2 = (Node_Sub2)OverlayDefinition.aHashTable3630.method1520(116);
               }

               intValues[intValueIndex++] = node_sub2.interfaceId;
               return;
            }

            if (i == 6702) {
               int i_495_ = intValues[--intValueIndex];
               if (Class134_Sub3.aWidgetArrayArray9035[i_495_] == null) {
                  stringValues[stringValueIndex++] = "";
                  return;
               }

               String string = Class134_Sub3.aWidgetArrayArray9035[i_495_][0].aString4765;
               if (string == null) {
                  stringValues[stringValueIndex++] = "";
                  return;
               }

               stringValues[stringValueIndex++] = string.substring(0, string.indexOf(58));
               return;
            }

            if (i == 6703) {
               int i_496_ = intValues[--intValueIndex];
               if (Class134_Sub3.aWidgetArrayArray9035[i_496_] == null) {
                  intValues[intValueIndex++] = 0;
                  return;
               }

               intValues[intValueIndex++] = Class134_Sub3.aWidgetArrayArray9035[i_496_].length;
               return;
            }

            if (i == 6704) {
               intValueIndex -= 2;
               int i_497_ = intValues[intValueIndex];
               int i_498_ = intValues[intValueIndex + 1];
               if (Class134_Sub3.aWidgetArrayArray9035[i_497_] == null) {
                  stringValues[stringValueIndex++] = "";
                  return;
               }

               String string = Class134_Sub3.aWidgetArrayArray9035[i_497_][i_498_].aString4765;
               if (string == null) {
                  stringValues[stringValueIndex++] = "";
                  return;
               }

               stringValues[stringValueIndex++] = string;
               return;
            }

            if (i == 6705) {
               intValueIndex -= 2;
               int i_499_ = intValues[intValueIndex];
               int i_500_ = intValues[intValueIndex + 1];
               if (Class134_Sub3.aWidgetArrayArray9035[i_499_] == null) {
                  intValues[intValueIndex++] = 0;
                  return;
               }

               intValues[intValueIndex++] = Class134_Sub3.aWidgetArrayArray9035[i_499_][i_500_].anInt4746;
               return;
            }

            if (i == 6706) {
               return;
            }

            if (i == 6707) {
               intValueIndex -= 3;
               int i_501_ = intValues[intValueIndex];
               int i_502_ = intValues[intValueIndex + 1];
               int i_503_ = intValues[intValueIndex + 2];
               r_Sub1.runScriptBasedOnKeyPressed(123, i_501_ << 16 | i_502_, i_503_, "", 1);
               return;
            }

            if (i == 6708) {
               intValueIndex -= 3;
               int i_504_ = intValues[intValueIndex];
               int i_505_ = intValues[intValueIndex + 1];
               int i_506_ = intValues[intValueIndex + 2];
               r_Sub1.runScriptBasedOnKeyPressed(125, i_504_ << 16 | i_505_, i_506_, "", 2);
               return;
            }

            if (i == 6709) {
               intValueIndex -= 3;
               int i_507_ = intValues[intValueIndex];
               int i_508_ = intValues[intValueIndex + 1];
               int i_509_ = intValues[intValueIndex + 2];
               r_Sub1.runScriptBasedOnKeyPressed(-113, i_507_ << 16 | i_508_, i_509_, "", 3);
               return;
            }

            if (i == 6710) {
               intValueIndex -= 3;
               int i_510_ = intValues[intValueIndex];
               int i_511_ = intValues[intValueIndex + 1];
               int i_512_ = intValues[intValueIndex + 2];
               r_Sub1.runScriptBasedOnKeyPressed(127, i_510_ << 16 | i_511_, i_512_, "", 4);
               return;
            }

            if (i == 6711) {
               intValueIndex -= 3;
               int i_513_ = intValues[intValueIndex];
               int i_514_ = intValues[intValueIndex + 1];
               int i_515_ = intValues[intValueIndex + 2];
               r_Sub1.runScriptBasedOnKeyPressed(-101, i_513_ << 16 | i_514_, i_515_, "", 5);
               return;
            }

            if (i == 6712) {
               intValueIndex -= 3;
               int i_516_ = intValues[intValueIndex];
               int i_517_ = intValues[intValueIndex + 1];
               int i_518_ = intValues[intValueIndex + 2];
               r_Sub1.runScriptBasedOnKeyPressed(-11, i_516_ << 16 | i_517_, i_518_, "", 6);
               return;
            }

            if (i == 6713) {
               intValueIndex -= 3;
               int i_519_ = intValues[intValueIndex];
               int i_520_ = intValues[intValueIndex + 1];
               int i_521_ = intValues[intValueIndex + 2];
               r_Sub1.runScriptBasedOnKeyPressed(-91, i_519_ << 16 | i_520_, i_521_, "", 7);
               return;
            }

            if (i == 6714) {
               intValueIndex -= 3;
               int i_522_ = intValues[intValueIndex];
               int i_523_ = intValues[intValueIndex + 1];
               int i_524_ = intValues[intValueIndex + 2];
               r_Sub1.runScriptBasedOnKeyPressed(124, i_522_ << 16 | i_523_, i_524_, "", 8);
               return;
            }

            if (i == 6715) {
               intValueIndex -= 3;
               int i_525_ = intValues[intValueIndex];
               int i_526_ = intValues[intValueIndex + 1];
               int i_527_ = intValues[intValueIndex + 2];
               r_Sub1.runScriptBasedOnKeyPressed(123, i_525_ << 16 | i_526_, i_527_, "", 9);
               return;
            }

            if (i == 6716) {
               intValueIndex -= 3;
               int i_528_ = intValues[intValueIndex];
               int i_529_ = intValues[intValueIndex + 1];
               int i_530_ = intValues[intValueIndex + 2];
               r_Sub1.runScriptBasedOnKeyPressed(4, i_528_ << 16 | i_529_, i_530_, "", 10);
               return;
            }

            if (i == 6717) {
               intValueIndex -= 3;
               int i_531_ = intValues[intValueIndex];
               int i_532_ = intValues[intValueIndex + 1];
               int i_533_ = intValues[intValueIndex + 2];
               IComponentDefinitions widget = Node_Sub3.method2169(-101, i_533_, i_531_ << 16 | i_532_);
               Node_Sub38_Sub23.method2863(-19316);
               InterfaceSettings node_sub35 = Client.method113(widget);
               Node_Sub38_Sub18.method2846(node_sub35.method2743(-79), (byte)-121, widget, node_sub35.anInt7413);
               return;
            }
         } else if (i < 6900) {
            if (i == 6800) {
               int i_534_ = intValues[--intValueIndex];
               AreaDefinitions class79 = Class304.aClass215_3834.getAreaDefinitions((byte)110, i_534_);
               if (class79.nameLabel == null) {
                  stringValues[stringValueIndex++] = "";
                  return;
               }

               stringValues[stringValueIndex++] = class79.nameLabel;
               return;
            }

            if (i == 6801) {
               int i_535_ = intValues[--intValueIndex];
               AreaDefinitions class79 = Class304.aClass215_3834.getAreaDefinitions((byte)103, i_535_);
               intValues[intValueIndex++] = class79.spriteId;
               return;
            }

            if (i == 6802) {
               int i_536_ = intValues[--intValueIndex];
               AreaDefinitions class79 = Class304.aClass215_3834.getAreaDefinitions((byte)110, i_536_);
               intValues[intValueIndex++] = class79.anInt1090;
               return;
            }

            if (i == 6803) {
               int i_537_ = intValues[--intValueIndex];
               AreaDefinitions class79 = Class304.aClass215_3834.getAreaDefinitions((byte)100, i_537_);
               intValues[intValueIndex++] = class79.type;
               return;
            }

            if (i == 6804) {
               intValueIndex -= 2;
               int i_538_ = intValues[intValueIndex];
               int i_539_ = intValues[intValueIndex + 1];
               Class267 class267 = Class188_Sub2_Sub2.aClass36_9366.method394(i_539_, -86);
               if (class267.method3287((byte)-97)) {
                  stringValues[stringValueIndex++] = Class304.aClass215_3834
                     .getAreaDefinitions((byte)106, i_538_)
                     .method785(i_539_, -18740, class267.aString3450);
                  return;
               }

               intValues[intValueIndex++] = Class304.aClass215_3834.getAreaDefinitions((byte)116, i_538_).method786(0, class267.anInt3443, i_539_);
               return;
            }
         } else if (i < 7000) {
            if (i == 6900) {
               intValues[intValueIndex++] = Node_Sub38_Sub18.aBoolean10282 && !Class24.aBoolean436 ? 1 : 0;
               return;
            }

            if (i == 6901) {
               intValues[intValueIndex++] = (int)(Node_Sub32.aLong7382 / 60000L);
               intValues[intValueIndex++] = (int)((Node_Sub32.aLong7382 - Class313.method3650(false) - Node_Sub8.aLong7068) / 60000L);
               intValues[intValueIndex++] = Class229.aBoolean2725 ? 1 : 0;
               return;
            }

            if (i == 6902) {
               intValues[intValueIndex++] = Node_Sub38_Sub35.anInt10454;
               return;
            }

            if (i == 6903) {
               intValues[intValueIndex++] = Class254.anInt3209;
               return;
            }

            if (i == 6904) {
               intValues[intValueIndex++] = Class170.anInt2052;
               return;
            }

            if (i == 6905) {
               String string = "";
               if (Class237.aClass241_2904 != null) {
                  if (Class237.aClass241_2904.anObject2956 != null) {
                     string = (String)Class237.aClass241_2904.anObject2956;
                  } else {
                     string = EntityNode_Sub3_Sub1.method943((byte)-113, Class237.aClass241_2904.anInt2952);
                  }
               }

               stringValues[stringValueIndex++] = string;
               return;
            }

            if (i == 6906) {
               intValues[intValueIndex++] = Class144_Sub2.anInt6812;
               return;
            }

            if (i == 6907) {
               intValues[intValueIndex++] = Class333.anInt4149;
               return;
            }

            if (i == 6908) {
               intValues[intValueIndex++] = Class342.anInt4234;
               return;
            }

            if (i == 6909) {
               intValues[intValueIndex++] = Class225.aBoolean2676 ? 1 : 0;
               return;
            }

            if (i == 6910) {
               intValues[intValueIndex++] = Class56.anInt837;
               return;
            }

            if (i == 6911) {
               intValues[intValueIndex++] = Node_Sub38_Sub29.anInt10409;
               return;
            }

            if (i == 6912) {
               intValues[intValueIndex++] = UnderlayDefinition.anInt2902;
               return;
            }

            if (i == 6913) {
               intValues[intValueIndex++] = Node_Sub33.anInt7402;
               return;
            }

            if (i == 6914) {
               intValues[intValueIndex++] = Class364.aBoolean4512 ? 1 : 0;
               return;
            }

            if (i == 6915) {
               intValues[intValueIndex++] = Class270_Sub1.anInt8030;
               return;
            }
         } else if (i < 7100) {
            if (i == 7000) {
               int i_540_ = Node_Sub41.autoSetupGraphics((byte)126);
               intValues[intValueIndex++] = Class95.anInt1251 = Class213.aNode_Sub27_2512.aClass320_Sub29_7270.method3791(false);
               intValues[intValueIndex++] = i_540_;
               Class243.method3061(7);
               Node_Sub38_Sub31.method2893(1);
               Class269.aBoolean3472 = false;
               return;
            }

            if (i == 7001) {
               Class262_Sub15.method3188(18896);
               Class243.method3061(7);
               Node_Sub38_Sub31.method2893(1);
               Class269.aBoolean3472 = false;
               return;
            }

            if (i == 7002) {
               Class69.method736(32159);
               Class243.method3061(7);
               Node_Sub38_Sub31.method2893(1);
               Class269.aBoolean3472 = false;
               return;
            }

            if (i == 7003) {
               Class194_Sub1.method1965((byte)-95);
               Class243.method3061(7);
               Node_Sub38_Sub31.method2893(1);
               Class269.aBoolean3472 = false;
               return;
            }

            if (i == 7004) {
               Node_Sub36.method2752(true, true);
               Class243.method3061(7);
               Node_Sub38_Sub31.method2893(1);
               Class269.aBoolean3472 = false;
               return;
            }

            if (i == 7005) {
               Class213.aNode_Sub27_2512.method2690(45, 0, Class213.aNode_Sub27_2512.aClass320_Sub15_7273);
               Node_Sub38_Sub31.method2893(1);
               Class269.aBoolean3472 = false;
               return;
            }

            if (i == 7006) {
               if (Class95.anInt1251 == 2) {
                  Class243.aBoolean3075 = true;
                  return;
               }

               if (Class95.anInt1251 == 1) {
                  Class370.aBoolean4570 = true;
                  return;
               }

               if (Class95.anInt1251 == 3) {
                  Class270_Sub2_Sub1.aBoolean10549 = true;
               }

               return;
            }

            if (i == 7007) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub15_7273.method3738(false);
               return;
            }
         } else if (i < 7200) {
            if (i == 7100) {
               intValueIndex -= 2;
               int i_541_ = intValues[intValueIndex];
               int i_542_ = intValues[intValueIndex + 1];
               if (i_541_ != -1) {
                  if (i_542_ > 255) {
                     i_542_ = 255;
                  } else if (i_542_ < 0) {
                     i_542_ = 0;
                  }

                  Node_Sub40.method2927(false, i_541_, i_542_);
               }

               return;
            }

            if (i == 7101) {
               int i_543_ = intValues[--intValueIndex];
               if (i_543_ != -1) {
                  Renderer.method3446(i_543_, 5);
               }

               return;
            }

            if (i == 7102) {
               int i_544_ = intValues[--intValueIndex];
               if (i_544_ != -1) {
                  CacheNode_Sub20.method2408(i_544_, true);
               }

               return;
            }

            if (i == 7103) {
               intValues[intValueIndex++] = Class262_Sub5.method3163("jagtheora", false) ? 1 : 0;
               return;
            }
         } else if (i < 7300) {
            if (i == 7201) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub6_7267.method3702((byte)75) ? 1 : 0;
               return;
            }

            if (i == 7202) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub7_7308.method3709((byte)106) ? 1 : 0;
               return;
            }

            if (i == 7203) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub12_7282.method3726((byte)68) ? 1 : 0;
               return;
            }

            if (i == 7204) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub26_7269.method3780((byte)82) ? 1 : 0;
               return;
            }

            if (i == 7205) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub13_7284.method3733((byte)124) && Class93.aGraphicsToolkit1241.t() ? 1 : 0;
               return;
            }

            if (i == 7206) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub28_7305.method3786((byte)98) ? 1 : 0;
               return;
            }

            if (i == 7207) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub5_7297.method3698((byte)126) ? 1 : 0;
               return;
            }

            if (i == 7208) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub20_7306.method3757((byte)116) && Class93.aGraphicsToolkit1241.o() ? 1 : 0;
               return;
            }

            if (i == 7209) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub23_7290.method3769((byte)104) ? 1 : 0;
               return;
            }

            if (i == 7210) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub30_7275.method3795((byte)90) ? 1 : 0;
               return;
            }

            if (i == 7211) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub18_7303.method3750((byte)77) ? 1 : 0;
               return;
            }

            if (i == 7212) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub16_7316.method3741((byte)87) ? 1 : 0;
               return;
            }

            if (i == 7213) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3688((byte)107) ? 1 : 0;
               return;
            }

            if (i == 7214) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub29_7291.method3793((byte)92) ? 1 : 0;
               return;
            }

            if (i == 7215) {
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub2_7272.method3682((byte)88) ? 1 : 0;
               return;
            }
         } else if (i < 7400) {
            if (i == 7301) {
               int i_545_ = intValues[--intValueIndex];
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub6_7267.method3675(i_545_, (byte)54);
               return;
            }

            if (i == 7302) {
               int i_546_ = intValues[--intValueIndex];
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub7_7308.method3675(i_546_, (byte)54);
               return;
            }

            if (i == 7303) {
               int i_547_ = intValues[--intValueIndex];
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub12_7282.method3675(i_547_, (byte)54);
               return;
            }

            if (i == 7304) {
               int i_548_ = intValues[--intValueIndex];
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub26_7269.method3675(i_548_, (byte)54);
               return;
            }

            if (i == 7305) {
               int i_549_ = intValues[--intValueIndex];
               if (!Class93.aGraphicsToolkit1241.t()) {
                  intValues[intValueIndex++] = 3;
                  return;
               }

               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub13_7284.method3675(i_549_, (byte)54);
               return;
            }

            if (i == 7306) {
               int i_550_ = intValues[--intValueIndex];
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub28_7305.method3675(i_550_, (byte)54);
               return;
            }

            if (i == 7307) {
               int i_551_ = intValues[--intValueIndex];
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub5_7297.method3675(i_551_, (byte)54);
               return;
            }

            if (i == 7308) {
               int i_552_ = intValues[--intValueIndex];
               if (!Class93.aGraphicsToolkit1241.o()) {
                  intValues[intValueIndex++] = 3;
                  return;
               }

               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub20_7306.method3675(i_552_, (byte)54);
               return;
            }

            if (i == 7309) {
               int i_553_ = intValues[--intValueIndex];
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub23_7290.method3675(i_553_, (byte)54);
               return;
            }

            if (i == 7310) {
               int i_554_ = intValues[--intValueIndex];
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub30_7275.method3675(i_554_, (byte)54);
               return;
            }

            if (i == 7311) {
               int i_555_ = intValues[--intValueIndex];
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub18_7303.method3675(i_555_, (byte)54);
               return;
            }

            if (i == 7312) {
               int i_556_ = intValues[--intValueIndex];
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub16_7316.method3675(i_556_, (byte)54);
               return;
            }

            if (i == 7313) {
               int i_557_ = intValues[--intValueIndex];
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3675(i_557_, (byte)54);
               return;
            }

            if (i == 7314) {
               int i_558_ = intValues[--intValueIndex];
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub29_7291.method3675(i_558_, (byte)54);
               return;
            }

            if (i == 7315) {
               int i_559_ = intValues[--intValueIndex];
               intValues[intValueIndex++] = Class213.aNode_Sub27_2512.aClass320_Sub2_7272.method3675(i_559_, (byte)54);
               return;
            }
         }
      }

      throw new IllegalStateException(String.valueOf(i));
   }

   private static final void executeScript(Node_Sub37 node_sub37, int i) {
      Object[] parameters = node_sub37.parameters;
      int scriptId = (int) parameters[0];
      ClientScript script = Class260.getClientScript(scriptId, -125);
      if (script != null) {
         intArguments = new int[script.totalIntVars];
         int i_561_ = 0;
         stringArguments = new String[script.totalStringVars];
         int i_562_ = 0;
         longArguments = new long[script.totalLongVars];
         int i_563_ = 0;

         for(int index = 1; index < parameters.length; ++index) {
            if (parameters[index] instanceof Integer) {
               int integerParameter = (int) parameters[index];
               if (integerParameter == -2147483647) {
                  integerParameter = node_sub37.anInt7439;
               }

               if (integerParameter == -2147483646) {
                  integerParameter = node_sub37.notches;
               }

               if (integerParameter == -2147483645) {
                  integerParameter = node_sub37.aWidget7437 != null ? node_sub37.aWidget7437.ihash : -1;
               }

               if (integerParameter == -2147483644) {
                  integerParameter = node_sub37.clickedOptionIndex;
               }

               if (integerParameter == -2147483643) {
                  integerParameter = node_sub37.aWidget7437 != null ? node_sub37.aWidget7437.anInt4687 : -1;
               }

               if (integerParameter == -2147483642) {
                  integerParameter = node_sub37.aWidget7432 != null ? node_sub37.aWidget7432.ihash : -1;
               }

               if (integerParameter == -2147483641) {
                  integerParameter = node_sub37.aWidget7432 != null ? node_sub37.aWidget7432.anInt4687 : -1;
               }

               if (integerParameter == -2147483640) {
                  integerParameter = node_sub37.anInt7435;
               }

               if (integerParameter == -2147483639) {
                  integerParameter = node_sub37.anInt7444;
               }

               intArguments[i_561_++] = integerParameter;
            } else if (parameters[index] instanceof String) {
               String string = (String)parameters[index];
               if (string.equals("event_opbase")) {
                  string = node_sub37.aString7440;
               }

               stringArguments[i_562_++] = string;
            } else if (parameters[index] instanceof Long) {
               long longParameter = (long) parameters[index];
               longArguments[i_563_++] = longParameter;
            }
         }

         anInt3869 = node_sub37.anInt7442;
         if (scriptId == TESTING_SCRIPT) {
            if (stringArguments != null) {
               for(String string : stringArguments) {
                  System.out.println("CSE stringval: " + string);
               }

               System.out.println("--------------------");
            }

            if (intArguments != null) {
               for(int i2 : intArguments) {
                  System.out.println("CSE intval: " + i2);
               }

               System.out.println("--------------------");
            }

            if (longArguments != null) {
               for(long l : longArguments) {
                  System.out.println("CSE longval: " + l);
               }

               System.out.println("--------------------");
            }
         }

         method3555(script, i);
      }
   }

   private static final int method3559(char c) {
      return Class321.method3801((byte)127, c) ? 1 : 0;
   }

   public static void method3560() {
      intArguments = null;
      stringArguments = null;
      longArguments = null;
      anIntArray3866 = null;
      anIntArrayArray3859 = null;
      intValues = null;
      stringValues = null;
      longValues = null;
      aClass113Array3842 = null;
      aWidget3849 = null;
      aWidget3865 = null;
      aClass16_3856 = null;
      aClanChat3860 = null;
      aNode_Sub43_3857 = null;
      anIntArray3845 = null;
      aClass61_3867 = null;
      aString3870 = null;
   }

   private static final String method3561(int i) {
      String string = aClanChat3860.method495(-116, Class209.aClass353_2483.anInt4344 << 16 | i);
      return string == null ? "" : string;
   }

   private static final void method3562(String string, int i) {
      if (Class339_Sub7.rights != 0 || (!Node_Sub38_Sub18.aBoolean10282 || Class24.aBoolean436) && !Class290_Sub11.aBoolean8175) {
         String string_566_ = string.toLowerCase();
         int colorEffect = 0;
         if (string_566_.startsWith(Class22.aClass22_410.getStoredString(0))) {
            colorEffect = 0;
            string = string.substring(Class22.aClass22_410.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_411.getStoredString(0))) {
            colorEffect = 1;
            string = string.substring(Class22.aClass22_411.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_412.getStoredString(0))) {
            colorEffect = 2;
            string = string.substring(Class22.aClass22_412.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_413.getStoredString(0))) {
            colorEffect = 3;
            string = string.substring(Class22.aClass22_413.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_414.getStoredString(0))) {
            colorEffect = 4;
            string = string.substring(Class22.aClass22_414.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_415.getStoredString(0))) {
            colorEffect = 5;
            string = string.substring(Class22.aClass22_415.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_416.getStoredString(0))) {
            colorEffect = 6;
            string = string.substring(Class22.aClass22_416.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_417.getStoredString(0))) {
            colorEffect = 7;
            string = string.substring(Class22.aClass22_417.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_418.getStoredString(0))) {
            colorEffect = 8;
            string = string.substring(Class22.aClass22_418.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_419.getStoredString(0))) {
            colorEffect = 9;
            string = string.substring(Class22.aClass22_419.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_420.getStoredString(0))) {
            colorEffect = 10;
            string = string.substring(Class22.aClass22_420.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_421.getStoredString(0))) {
            colorEffect = 11;
            string = string.substring(Class22.aClass22_421.getStoredString(0).length());
         } else if (Class35.language != 0) {
            if (string_566_.startsWith(Class22.aClass22_410.getStoredString(Class35.language))) {
               colorEffect = 0;
               string = string.substring(Class22.aClass22_410.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_411.getStoredString(Class35.language))) {
               colorEffect = 1;
               string = string.substring(Class22.aClass22_411.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_412.getStoredString(Class35.language))) {
               colorEffect = 2;
               string = string.substring(Class22.aClass22_412.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_413.getStoredString(Class35.language))) {
               colorEffect = 3;
               string = string.substring(Class22.aClass22_413.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_414.getStoredString(Class35.language))) {
               colorEffect = 4;
               string = string.substring(Class22.aClass22_414.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_415.getStoredString(Class35.language))) {
               colorEffect = 5;
               string = string.substring(Class22.aClass22_415.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_416.getStoredString(Class35.language))) {
               colorEffect = 6;
               string = string.substring(Class22.aClass22_416.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_417.getStoredString(Class35.language))) {
               colorEffect = 7;
               string = string.substring(Class22.aClass22_417.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_418.getStoredString(Class35.language))) {
               colorEffect = 8;
               string = string.substring(Class22.aClass22_418.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_419.getStoredString(Class35.language))) {
               colorEffect = 9;
               string = string.substring(Class22.aClass22_419.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_420.getStoredString(Class35.language))) {
               colorEffect = 10;
               string = string.substring(Class22.aClass22_420.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_421.getStoredString(Class35.language))) {
               colorEffect = 11;
               string = string.substring(Class22.aClass22_421.getStoredString(Class35.language).length());
            }
         }

         string_566_ = string.toLowerCase();
         int moveEffect = 0;
         if (string_566_.startsWith(Class22.aClass22_422.getStoredString(0))) {
            moveEffect = 1;
            string = string.substring(Class22.aClass22_422.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_423.getStoredString(0))) {
            moveEffect = 2;
            string = string.substring(Class22.aClass22_423.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_424.getStoredString(0))) {
            moveEffect = 3;
            string = string.substring(Class22.aClass22_424.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_425.getStoredString(0))) {
            moveEffect = 4;
            string = string.substring(Class22.aClass22_425.getStoredString(0).length());
         } else if (string_566_.startsWith(Class22.aClass22_426.getStoredString(0))) {
            moveEffect = 5;
            string = string.substring(Class22.aClass22_426.getStoredString(0).length());
         } else if (Class35.language != 0) {
            if (string_566_.startsWith(Class22.aClass22_422.getStoredString(Class35.language))) {
               moveEffect = 1;
               string = string.substring(Class22.aClass22_422.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_423.getStoredString(Class35.language))) {
               moveEffect = 2;
               string = string.substring(Class22.aClass22_423.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_424.getStoredString(Class35.language))) {
               moveEffect = 3;
               string = string.substring(Class22.aClass22_424.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_425.getStoredString(Class35.language))) {
               moveEffect = 4;
               string = string.substring(Class22.aClass22_425.getStoredString(Class35.language).length());
            } else if (string_566_.startsWith(Class22.aClass22_426.getStoredString(Class35.language))) {
               moveEffect = 5;
               string = string.substring(Class22.aClass22_426.getStoredString(Class35.language).length());
            }
         }

         ++anInt3852;
         Class123 class123 = Class262_Sub23.method3213((byte)-110);
         OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Node_Sub38_Sub11.aClass318_10221, class123.issacKeys);
         node_sub13.currentOutgoingPacket.writeByte(0);
         int i_569_ = node_sub13.currentOutgoingPacket.offset;
         node_sub13.currentOutgoingPacket.writeByte(colorEffect);
         node_sub13.currentOutgoingPacket.writeByte(moveEffect);
         Class194_Sub3.method1975(56, node_sub13.currentOutgoingPacket, string);
         node_sub13.currentOutgoingPacket.method2217(node_sub13.currentOutgoingPacket.offset - i_569_);
         class123.sendPacket(127, node_sub13);
      }
   }

   static final void method3563(int i, String string, int i_570_) {
      ClientScript cachenode_sub9 = Node_Sub38_Sub25.method2871(Class262_Sub15_Sub1.aClass212_10519, i, -1, -37);
      if (cachenode_sub9 != null) {
         intArguments = new int[cachenode_sub9.totalIntVars];
         stringArguments = new String[cachenode_sub9.totalStringVars];
         stringArguments[0] = string;
         intArguments[0] = i_570_;
         method3555(cachenode_sub9, 200000);
      }
   }

   static final void method3564() {
   }

   static final void method3565(Class212 class212, int i, int i_571_) {
      ClientScript cachenode_sub9 = Node_Sub38_Sub25.method2871(class212, i, i_571_, -67);
      if (cachenode_sub9 != null) {
         intArguments = new int[cachenode_sub9.totalIntVars];
         stringArguments = new String[cachenode_sub9.totalStringVars];
         if (cachenode_sub9.aClass212_9505 == Class3.aClass212_5159
            || cachenode_sub9.aClass212_9505 == Node_Sub38_Sub29.aClass212_10406
            || cachenode_sub9.aClass212_9505 == WorldmapAreaDetail.aClass212_9548) {
            int i_572_ = 0;
            int i_573_ = 0;
            if (Class66_Sub1.aWidget8983 != null) {
               i_572_ = Class66_Sub1.aWidget8983.positionX;
               i_573_ = Class66_Sub1.aWidget8983.positionY;
            }

            intArguments[0] = Class106.aClass93_1356.getLastMousePosX() - i_572_;
            intArguments[1] = Class106.aClass93_1356.getLastMousePosY(true) - i_573_;
         }

         method3555(cachenode_sub9, 200000);
      }
   }
}
