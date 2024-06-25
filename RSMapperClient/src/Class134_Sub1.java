import com.rs.cache.loaders.ObjectDefinitions;
import jaggl.OpenGL;
import java.awt.EventQueue;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class Class134_Sub1 extends Class134 implements Interface13_Impl3 {
   static int anInt9014 = 0;
   static int anInt9015;
   static int anInt9016;
   static int anInt9017;
   private int anInt9018;
   private int anInt9019;
   private int anInt9020;

   Class134_Sub1(GLXToolkit glxtoolkit, Class68 class68, int i, int i_0_, int i_1_, byte[] bs) {
      super(glxtoolkit, 32879, class68, Class372.aClass372_4594, i * i_0_ * i_1_, false);
      this.anInt9018 = i_1_;
      this.anInt9020 = i;
      this.anInt9019 = i_0_;
      this.aGLXToolkit5299.method1312((byte)-21, this);
      OpenGL.glPixelStorei(3317, 1);
      OpenGL.glTexImage3Dub(
         this.anInt5296,
         0,
         this.method1570(10242),
         this.anInt9020,
         this.anInt9019,
         this.anInt9018,
         0,
         Node_Sub36.method2753((byte)-18, this.aClass68_5317),
         5121,
         bs,
         0
      );
      OpenGL.glPixelStorei(3317, 4);
   }

   static final void mouseClickExecutor(int i, int i_2_, CacheNode_Sub13 cachenode_sub13, int i_3_) {
      ++anInt9017;
      if (cachenode_sub13 != null && cachenode_sub13 != Class368.aClass312_4549.aNode3958) {
         int localX = cachenode_sub13.lastClickX;
         int localY = cachenode_sub13.lastClickY;
         int opcode = cachenode_sub13.anInt9562;
         int index = (int)cachenode_sub13.lastClickedIndex;
         int actionValue = cachenode_sub13.anInt9569;
         if (opcode >= 2000) {
            opcode -= 2000;
         }

         long l = cachenode_sub13.lastClickedIndex;
         if (~opcode == -45) {
            Player player = Class270_Sub2.LOCAL_PLAYERS[index];
            if (player != null) {
               Node_Sub37.anInt7431 = 0;
               Class93_Sub2.anInt6067 = i_3_;
               ++Class270.anInt3475;
               Node_Sub38_Sub28.anInt10403 = 2;
               Class163.anInt2014 = i;
               OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class355.aClass318_4396, Class218.aClass123_2566.issacKeys);
               node_sub13.currentOutgoingPacket.writeShortLE(index);
               node_sub13.currentOutgoingPacket.writeIntLE(Node_Sub15_Sub9.anInt9839);
               node_sub13.currentOutgoingPacket.writeShort(Class92.anInt1230);
               node_sub13.currentOutgoingPacket.write128Byte(!Class175.aClass291_2100.isKeyHeld(93, 82) ? 0 : 1);
               node_sub13.currentOutgoingPacket.writeShortLE128(Class46.anInt681);
               Class218.aClass123_2566.sendPacket(126, node_sub13);
               Class78.method778(
                  0, player.scenePositionYQueue[0], player.getSize((byte)99), true, player.scenePositionXQueue[0], 0, -2, 32, player.getSize((byte)110)
               );
            }
         }

         if (~opcode == -5) {
            Node_Sub38_Sub28.anInt10403 = 2;
            Class163.anInt2014 = i;
            Node_Sub37.anInt7431 = 0;
            Class93_Sub2.anInt6067 = i_3_;
            ++Class270.anInt3475;
            OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class355.aClass318_4396, Class218.aClass123_2566.issacKeys);
            node_sub13.currentOutgoingPacket.writeShortLE(Class295.myPlayer.index);
            node_sub13.currentOutgoingPacket.writeIntLE(Node_Sub15_Sub9.anInt9839);
            node_sub13.currentOutgoingPacket.writeShort(Class92.anInt1230);
            node_sub13.currentOutgoingPacket.write128Byte(Class175.aClass291_2100.isKeyHeld(i_2_ ^ -33, 82) ? 1 : 0);
            node_sub13.currentOutgoingPacket.writeShortLE128(Class46.anInt681);
            Class218.aClass123_2566.sendPacket(127, node_sub13);
         }

         if (opcode == 12) {
            IComponentDefinitions widget = Node_Sub3.method2169(i_2_ ^ -102, localX, localY);
            if (widget != null) {
               Node_Sub38_Sub23.method2863(i_2_ ^ -19315);
               InterfaceSettings node_sub35 = Client.method113(widget);
               Node_Sub38_Sub18.method2846(node_sub35.method2743(-49), (byte)-109, widget, node_sub35.anInt7413);
               Class84.aString1148 = Class205.method2033(widget, (byte)-104);
               Class66.aString5177 = widget.baseOption + "<col=ffffff>";
               if (Class84.aString1148 == null) {
                  Class84.aString1148 = "Null";
               }
            }
         } else {
            if (opcode == 58) {
               if ((!Class175.aClass291_2100.isKeyHeld(119, 82) || !Class175.aClass291_2100.isKeyHeld(i_2_ ^ 106, 81)) && index != 1) {
                  Class163.anInt2014 = i;
                  Node_Sub38_Sub28.anInt10403 = new WorldTile(localX, localY, 0, true).isWithinRegionBounds() ? 1 : 2;
                  Node_Sub37.anInt7431 = 0;
                  Class93_Sub2.anInt6067 = i_3_;
               }

               Class78.method778(0, localY, 1, true, localX, 0, -4, i_2_ ^ -108, 1);
               if (actionValue == ToolData.ActionValues.LOAD_REGION_DATA.getValue()) {
                  RSMapperClient.editor
                     .loadRegion(Utils.getRegionId(WorldmapDefinitions.mouseHoveredX, WorldmapDefinitions.mouseHoveredY), true, true, true, true, true);
                  return;
               }

               if (actionValue == ToolData.ActionValues.LOAD_REGION.getValue()) {
                  final int regionId = Utils.getRegionId(WorldmapDefinitions.mouseHoveredX, WorldmapDefinitions.mouseHoveredY);
                  if (Utils.getArchiveId("m", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId)) == -1) {
                     EventQueue.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                           JOptionPane.showMessageDialog(null, "Could not load region " + regionId + ", map files do not exist.", "Nothing to load", 1);
                        }
                     });
                  } else {
                     WorldmapDefinitions.closeWorldmap();
                     ((HomeMenu)RSMapperClient.homeMenu).load(Utils.getRegionId(WorldmapDefinitions.mouseHoveredX, WorldmapDefinitions.mouseHoveredY));
                  }

                  return;
               }

               if (localX < 0 || localX >= 104 || localY < 0 || localY >= 104) {
                  return;
               }

               boolean clickedSameTile = localX == RSMapperClient.editor.selectedTile.getLocalX()
                  && localY == RSMapperClient.editor.selectedTile.getLocalY()
                  && Class295.myPlayer.plane == RSMapperClient.editor.selectedTile.getPlane();
               if (actionValue == ToolData.ActionValues.TELEPORT.getValue() || !clickedSameTile && Settings.CLICK_TELEPORT) {
                  Class78.sendTeleport(localX + Node_Sub53.gameSceneBaseX, Class320_Sub4.gameSceneBaseY + localY, Class295.myPlayer.plane, true);
                  return;
               }

               if (actionValue != ToolData.ActionValues.TELEPORT.getValue()) {
                  if (clickedSameTile && actionValue == 1) {
                     RSMapperClient.editor.tool.incrementTimesTileClicked();
                  } else if (!clickedSameTile) {
                     RSMapperClient.editor.tool.setTimesTileClicked(actionValue == 1 ? 1 : 0);
                  }

                  if (Class78.SELECTING_OBJECT) {
                     if (Class78.OBJECT_UNDER_CURSOR != null && Class78.OBJECT_UNDER_CURSOR.anAnimable5990 != null) {
                        WorldObject object = (WorldObject)Class78.OBJECT_UNDER_CURSOR.anAnimable5990;
                        if (object != null) {
                           final ObjectDefinition objectdefinition = Class186.aClass112_2256.getObjectDefinitionsForId(object.getId(-32136), 102);
                           SwingUtilities.invokeLater(
                              new Runnable() {
                                 @Override
                                 public void run() {
                                    ((BottomMenu)UIPanels.bottomPanel).inputDefsObjectIdToFind.setText("" + objectdefinition.objectId);
                                    ((BottomMenu)UIPanels.bottomPanel).listDefsObjectIds.setSelectedIndex(objectdefinition.objectId);
                                    int positionY = ((BottomMenu)UIPanels.bottomPanel).listDefsObjectIds.getSelectedIndex()
                                          < ObjectDefinitions.getObjectDefinitionsSize() - 3
                                       ? ((BottomMenu)UIPanels.bottomPanel).listDefsObjectIds.getSelectedIndex() + 3
                                       : ((BottomMenu)UIPanels.bottomPanel).listDefsObjectIds.getSelectedIndex();
                                    Rectangle bounds = ((BottomMenu)UIPanels.bottomPanel).listDefsObjectIds.getCellBounds(positionY, positionY);
                                    ((BottomMenu)UIPanels.bottomPanel).listDefsObjectIds.scrollRectToVisible(bounds);
                                    if (((BottomMenu)UIPanels.bottomPanel).listDefsObjectIds.getFirstVisibleIndex() > objectdefinition.objectId
                                       || ((BottomMenu)UIPanels.bottomPanel).listDefsObjectIds.getLastVisibleIndex() < objectdefinition.objectId) {
                                       ((BottomMenu)UIPanels.bottomPanel).listDefsObjectIds.ensureIndexIsVisible(objectdefinition.objectId);
                                    }
                                 }
                              }
                           );
                           Class78.SELECTING_OBJECT = false;
                           ((JButton)UIPanels.generalComponents.get("mouse_select_obj")).setBorder(null);
                           if (RSMapperClient.editor.tool != null && ((BottomMenu)UIPanels.bottomPanel).selectTileOnMS.isSelected()) {
                              int lx;
                              int ly;
                              if (!(Class78.OBJECT_UNDER_CURSOR.anAnimable5990 instanceof Mobile)) {
                                 lx = Class78.OBJECT_UNDER_CURSOR.anAnimable5990.x >> 9;
                                 ly = Class78.OBJECT_UNDER_CURSOR.anAnimable5990.y >> 9;
                              } else {
                                 lx = ((Mobile)Class78.OBJECT_UNDER_CURSOR.anAnimable5990).aShort9119;
                                 ly = ((Mobile)Class78.OBJECT_UNDER_CURSOR.anAnimable5990).aShort9120;
                              }

                              RSMapperClient.editor.tool.setEditingTiles(lx, ly, Class295.myPlayer.plane, actionValue);
                           }
                        }
                     }
                  } else {
                     RSMapperClient.editor.tool.handleTileClick(localX, localY, Class295.myPlayer.plane, actionValue);
                  }
               }

               if (!clickedSameTile) {
                  RSMapperClient.editor.setInfoBasedOnSelectedTile();
               }
            }

            if (opcode == 10 && Node_Sub25_Sub3.aWidget9990 == null) {
               Class257.method3121(localX, true, localY);
               Node_Sub25_Sub3.aWidget9990 = Node_Sub3.method2169(-101, localX, localY);
               ClientScript.method2321(-1, Node_Sub25_Sub3.aWidget9990);
            }

            OutgoingPacket class318 = null;
            if (~opcode == -3) {
               class318 = Class228.aClass318_2720;
            } else if (~opcode != -23) {
               if (~opcode == -53) {
                  class318 = OutputStream_Sub2.OUTGOING_PLAYER_TRADE_CLICK;
               } else if (opcode != 30) {
                  if (~opcode != -54) {
                     if (opcode == 9) {
                        class318 = Class290_Sub4.aClass318_8089;
                     } else if (~opcode != -52) {
                        if (~opcode == -16) {
                           class318 = Mobile_Sub4.aClass318_10992;
                        } else if (opcode == 48) {
                           class318 = CacheNode_Sub15.playerOption9;
                        } else if (opcode == 16) {
                           class318 = Node_Sub38_Sub23.aClass318_10329;
                        }
                     } else {
                        class318 = Node_Sub25_Sub1.aClass318_9953;
                     }
                  } else {
                     class318 = Class359.aClass318_4463;
                  }
               } else {
                  class318 = Class312.aClass318_3973;
               }
            } else {
               class318 = Class37.aClass318_557;
            }

            if (class318 != null) {
               Player player = Class270_Sub2.LOCAL_PLAYERS[index];
               if (player != null) {
                  Node_Sub37.anInt7431 = 0;
                  ++Class188_Sub1.anInt6852;
                  Class163.anInt2014 = i;
                  Node_Sub38_Sub28.anInt10403 = 2;
                  Class93_Sub2.anInt6067 = i_3_;
                  OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(class318, Class218.aClass123_2566.issacKeys);
                  node_sub13.currentOutgoingPacket.writeByte(Class175.aClass291_2100.isKeyHeld(-42, 82) ? 1 : 0);
                  node_sub13.currentOutgoingPacket.writeShort(index);
                  Class218.aClass123_2566.sendPacket(i_2_ + 125, node_sub13);
                  Class78.method778(
                     0, player.scenePositionYQueue[0], player.getSize((byte)125), true, player.scenePositionXQueue[0], 0, -2, 127, player.getSize((byte)60)
                  );
               }
            }

            if (i_2_ != 1) {
               anInt9015 = 28;
            }

            OutgoingPacket class318_8_ = null;
            if (opcode != 25) {
               if (opcode != 5) {
                  if (opcode == 50) {
                     class318_8_ = CacheNode_Sub16.aClass318_9599;
                  } else if (~opcode != -7) {
                     if (~opcode != -46) {
                        if (~opcode == -1008) {
                           class318_8_ = Class51_Sub1.aClass318_9061;
                        }
                     } else {
                        class318_8_ = Class50.aClass318_780;
                     }
                  } else {
                     class318_8_ = Class294.aClass318_3685;
                  }
               } else {
                  class318_8_ = Class218.aClass318_2570;
               }
            } else {
               class318_8_ = Class128.aClass318_1658;
            }

            if (class318_8_ != null) {
               Class163.anInt2014 = i;
               Node_Sub37.anInt7431 = 0;
               Node_Sub38_Sub28.anInt10403 = 2;
               Class93_Sub2.anInt6067 = i_3_;
               ++Class282.anInt3587;
               OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(class318_8_, Class218.aClass123_2566.issacKeys);
               node_sub13.currentOutgoingPacket.writeShort128(index);
               node_sub13.currentOutgoingPacket.writeByte(!Class175.aClass291_2100.isKeyHeld(94, 82) ? 0 : 1);
               node_sub13.currentOutgoingPacket.writeShort(localY + Class320_Sub4.gameSceneBaseY);
               node_sub13.currentOutgoingPacket.writeShortLE(Node_Sub53.gameSceneBaseX + localX);
               Class218.aClass123_2566.sendPacket(126, node_sub13);
               Class223.method2104(0, localY, localX);
            }

            if (opcode == 11) {
               if (~Class339_Sub7.rights < -1 && Class175.aClass291_2100.isKeyHeld(-121, 82) && Class175.aClass291_2100.isKeyHeld(111, 81)) {
                  Class331.sendShiftTeleport(false, Class295.myPlayer.plane, Class320_Sub4.gameSceneBaseY + localY, Node_Sub53.gameSceneBaseX + localX);
               } else {
                  Node_Sub37.anInt7431 = 0;
                  ++Class131.anInt5443;
                  Class93_Sub2.anInt6067 = i_3_;
                  Node_Sub38_Sub28.anInt10403 = 1;
                  Class163.anInt2014 = i;
                  OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class144_Sub4.aClass318_6847, Class218.aClass123_2566.issacKeys);
                  node_sub13.currentOutgoingPacket.writeShortLE128(localY + Class320_Sub4.gameSceneBaseY);
                  node_sub13.currentOutgoingPacket.writeShortLE(Node_Sub53.gameSceneBaseX + localX);
                  Class218.aClass123_2566.sendPacket(126, node_sub13);
               }
            }

            if (~opcode == -19) {
               IComponentDefinitions widget = Node_Sub3.method2169(-101, localX, localY);
               if (widget != null) {
                  Class166.method1747((byte)-53, widget);
               }
            }

            OutgoingPacket class318_9_ = null;
            if (opcode != 49) {
               if (opcode != 59) {
                  if (~opcode == -48) {
                     class318_9_ = Class68.aClass318_933;
                  } else if (~opcode == -58) {
                     class318_9_ = Class163.aClass318_2018;
                  } else if (opcode != 3) {
                     if (~opcode == -1012) {
                        class318_9_ = Class66_Sub2_Sub1.NPC_EXAMINE_PACKET;
                     }
                  } else {
                     class318_9_ = Class225.npcOption3;
                  }
               } else {
                  class318_9_ = Node_Sub42.aClass318_7523;
               }
            } else {
               class318_9_ = Class320_Sub13.aClass318_8334;
            }

            if (class318_9_ != null) {
               Node_Sub41 node_sub41 = (Node_Sub41)Class12.aHashTable187.get(3512, (long)index);
               if (node_sub41 != null) {
                  Class93_Sub2.anInt6067 = i_3_;
                  Npc npc = node_sub41.aNpc7518;
                  ++Class260.anInt5228;
                  Node_Sub38_Sub28.anInt10403 = 2;
                  Class163.anInt2014 = i;
                  Node_Sub37.anInt7431 = 0;
                  OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(class318_9_, Class218.aClass123_2566.issacKeys);
                  node_sub13.currentOutgoingPacket.writeByte128(!Class175.aClass291_2100.isKeyHeld(i_2_ ^ 84, 82) ? 0 : 1);
                  node_sub13.currentOutgoingPacket.writeShort128(index);
                  Class218.aClass123_2566.sendPacket(126, node_sub13);
                  Class78.method778(0, npc.scenePositionYQueue[0], npc.getSize((byte)76), true, npc.scenePositionXQueue[0], 0, -2, 116, npc.getSize((byte)103));
               }
            }

            OutgoingPacket class318_10_ = null;
            if (opcode != 19) {
               if (opcode != 13) {
                  if (~opcode != -47) {
                     if (opcode != 8) {
                        if (~opcode == -1011) {
                           class318_10_ = Class194_Sub3_Sub1.aClass318_9373;
                        } else if (~opcode == -1009) {
                           class318_10_ = Animable_Sub2.aClass318_9114;
                        }
                     } else {
                        class318_10_ = Class117_Sub1.aClass318_4932;
                     }
                  } else {
                     class318_10_ = Class215.aClass318_2529;
                  }
               } else {
                  class318_10_ = Class262_Sub4.aClass318_7726;
               }
            } else {
               class318_10_ = Class39.aClass318_584;
            }

            if (class318_10_ != null) {
               Class163.anInt2014 = i;
               Node_Sub38_Sub28.anInt10403 = 2;
               Node_Sub37.anInt7431 = 0;
               Class93_Sub2.anInt6067 = i_3_;
               ++Class317.anInt4039;
               OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(class318_10_, Class218.aClass123_2566.issacKeys);
               node_sub13.currentOutgoingPacket.writeByte128(Class175.aClass291_2100.isKeyHeld(99, 82) ? 1 : 0);
               node_sub13.currentOutgoingPacket.writeShort128(Node_Sub53.gameSceneBaseX + localX);
               node_sub13.currentOutgoingPacket.writeInt((int)(l >>> 32));
               node_sub13.currentOutgoingPacket.writeShortLE(localY - -Class320_Sub4.gameSceneBaseY);
               Class218.aClass123_2566.sendPacket(i_2_ + 125, node_sub13);
               Class25.method306(-43, localX, l, localY);
            }

            if (~opcode == -1004 || ~opcode == -1002 || opcode == 1006 || opcode == 1009 || opcode == 1004) {
               Class262_Sub20.method3204((byte)-121, localX, index, opcode);
            }

            if (~opcode == -22) {
               Class93_Sub2.anInt6067 = i_3_;
               Node_Sub38_Sub28.anInt10403 = 1;
               Class163.anInt2014 = i;
               ++ObjectDefinition.anInt2959;
               Node_Sub37.anInt7431 = 0;
               OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(RuntimeException_Sub1.aClass318_4920, Class218.aClass123_2566.issacKeys);
               node_sub13.currentOutgoingPacket.writeShort128(Node_Sub53.gameSceneBaseX - -localX);
               node_sub13.currentOutgoingPacket.writeShortLE(Class92.anInt1230);
               node_sub13.currentOutgoingPacket.writeIntV1(Node_Sub15_Sub9.anInt9839);
               node_sub13.currentOutgoingPacket.writeShort128(Class320_Sub4.gameSceneBaseY + localY);
               node_sub13.currentOutgoingPacket.writeShort(Class46.anInt681);
               Class218.aClass123_2566.sendPacket(127, node_sub13);
               Class78.method778(0, localY, 1, true, localX, 0, -4, -107, 1);
            }

            if (~opcode == -18) {
               Node_Sub38_Sub28.anInt10403 = 2;
               Node_Sub37.anInt7431 = 0;
               Class163.anInt2014 = i;
               Class93_Sub2.anInt6067 = i_3_;
               ++Class188_Sub1_Sub1.anInt9329;
               OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class102.aClass318_1314, Class218.aClass123_2566.issacKeys);
               node_sub13.currentOutgoingPacket.writeShort(localX + Node_Sub53.gameSceneBaseX);
               node_sub13.currentOutgoingPacket.writeShort(Class320_Sub4.gameSceneBaseY + localY);
               node_sub13.currentOutgoingPacket.writeShortLE128(Class92.anInt1230);
               node_sub13.currentOutgoingPacket.writeIntV2(Node_Sub15_Sub9.anInt9839);
               node_sub13.currentOutgoingPacket.writeShortLE(Class46.anInt681);
               node_sub13.currentOutgoingPacket.writeByte(!Class175.aClass291_2100.isKeyHeld(125, 82) ? 0 : 1);
               node_sub13.currentOutgoingPacket.writeShortLE(index);
               Class218.aClass123_2566.sendPacket(127, node_sub13);
               Class223.method2104(0, localY, localX);
            }

            if (~opcode == -24) {
               Node_Sub41 node_sub41 = (Node_Sub41)Class12.aHashTable187.get(3512, (long)index);
               if (node_sub41 != null) {
                  Npc npc = node_sub41.aNpc7518;
                  Node_Sub37.anInt7431 = 0;
                  ++Class122.anInt1552;
                  Node_Sub38_Sub28.anInt10403 = 2;
                  Class93_Sub2.anInt6067 = i_3_;
                  Class163.anInt2014 = i;
                  OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class269.aClass318_3470, Class218.aClass123_2566.issacKeys);
                  node_sub13.currentOutgoingPacket.writeShortLE128(Class46.anInt681);
                  node_sub13.currentOutgoingPacket.writeShortLE(Class92.anInt1230);
                  node_sub13.currentOutgoingPacket.writeShortLE(index);
                  node_sub13.currentOutgoingPacket.writeIntV2(Node_Sub15_Sub9.anInt9839);
                  node_sub13.currentOutgoingPacket.writeByte(!Class175.aClass291_2100.isKeyHeld(-40, 82) ? 0 : 1);
                  Class218.aClass123_2566.sendPacket(127, node_sub13);
                  Class78.method778(
                     0, npc.scenePositionYQueue[0], npc.getSize((byte)44), true, npc.scenePositionXQueue[0], 0, -2, i_2_ ^ -92, npc.getSize((byte)50)
                  );
               }
            }

            if (opcode == 20 || opcode == 1002) {
               r_Sub1.runScriptBasedOnKeyPressed(-54, localY, localX, cachenode_sub13.aString9558, index);
            }

            if (opcode == 60) {
               Class93_Sub2.anInt6067 = i_3_;
               Node_Sub37.anInt7431 = 0;
               Class163.anInt2014 = i;
               Node_Sub38_Sub28.anInt10403 = 2;
               ++NpcDefinition.anInt2845;
               OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(EntityNode_Sub3_Sub1.aClass318_9159, Class218.aClass123_2566.issacKeys);
               node_sub13.currentOutgoingPacket.writeByteC(Class175.aClass291_2100.isKeyHeld(-61, 82) ? 1 : 0);
               node_sub13.currentOutgoingPacket.writeShortLE(Class320_Sub4.gameSceneBaseY + localY);
               node_sub13.currentOutgoingPacket.writeShortLE(Class46.anInt681);
               node_sub13.currentOutgoingPacket.writeIntLE(Node_Sub15_Sub9.anInt9839);
               node_sub13.currentOutgoingPacket.writeShortLE128(Class92.anInt1230);
               node_sub13.currentOutgoingPacket.writeShortLE(localX - -Node_Sub53.gameSceneBaseX);
               node_sub13.currentOutgoingPacket.writeInt((int)(l >>> 32));
               Class218.aClass123_2566.sendPacket(127, node_sub13);
               Class25.method306(-65, localX, l, localY);
            }

            if (Class87.removeWalkHere) {
               Node_Sub38_Sub23.method2863(-19316);
            }

            if (Class41.aWidget622 != null && GLPlane.anInt7937 == 0) {
               ClientScript.method2321(-1, Class41.aWidget622);
            }
         }
      }
   }

   static final boolean method1581(int i, int i_11_) {
      ++anInt9016;
      if (i_11_ != -25900) {
         anInt9014 = -33;
      }

      return i == 3 || ~i == -5;
   }
}
