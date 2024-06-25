import java.awt.event.KeyEvent;
import javax.swing.JButton;
import javax.swing.JTextField;

public class KeybindHandler {
   public static int WASD_MOVE_DELAY = 2;
   public static long WASD_TIME_SINCE = 0L;

   public static void checkWASD() {
      if (!GLXToolkit.consoleIsOpen(-6279) && Class175.aClass291_2100 != null && RSMapperClient.MAP_LOADED) {
         if (!Class175.aClass291_2100.isKeyHeld(104, 33)
            && !Class175.aClass291_2100.isKeyHeld(104, 48)
            && !Class175.aClass291_2100.isKeyHeld(104, 49)
            && !Class175.aClass291_2100.isKeyHeld(104, 50)) {
            RSMapperClient.settings.HIDE_CAMERA_ICON = false;
         } else if (System.currentTimeMillis() >= WASD_TIME_SINCE) {
            boolean shift = Class175.aClass291_2100.isKeyHeld(-67, 81);
            if (Class175.aClass291_2100.isKeyHeld(104, 33)) {
               if (shift && RSMapperClient.editor.selectedTile != null) {
                  Class78.handleMoveTileSelection('w');
               } else {
                  Class78.handleCameraMove('w');
               }
            } else if (Class175.aClass291_2100.isKeyHeld(104, 48)) {
               if (shift && RSMapperClient.editor.selectedTile != null) {
                  Class78.handleMoveTileSelection('a');
               } else {
                  Class78.handleCameraMove('a');
               }
            } else if (Class175.aClass291_2100.isKeyHeld(104, 49)) {
               if (shift && RSMapperClient.editor.selectedTile != null) {
                  Class78.handleMoveTileSelection('s');
               } else {
                  Class78.handleCameraMove('s');
               }
            } else if (Class175.aClass291_2100.isKeyHeld(104, 50)) {
               if (shift && RSMapperClient.editor.selectedTile != null) {
                  Class78.handleMoveTileSelection('d');
               } else {
                  Class78.handleCameraMove('d');
               }
            }

            WASD_TIME_SINCE = System.currentTimeMillis() + 90L + (long)(10 * WASD_MOVE_DELAY * 2);
         }
      } else {
         RSMapperClient.settings.HIDE_CAMERA_ICON = false;
      }
   }

   public static void handleKeyPressed(KeyEvent keyevent) {
      if (!GLXToolkit.consoleIsOpen(-6279)) {
         int keycode = keyevent.getKeyCode();
         char keychar = keyevent.getKeyChar();
         boolean holdingCtrl = Class175.aClass291_2100.isKeyHeld(-67, 82);
         if (holdingCtrl && keycode != 17) {
            if (keycode == 90) {
               RSMapperClient.editor.undo();
            } else if (keycode == 89) {
               RSMapperClient.editor.redo();
            }
         } else {
            if (keychar == 'f'
               && RSMapperClient.editor.tool != null
               && RSMapperClient.editor.tool instanceof ShapeTool
               && ((ShapeTool)RSMapperClient.editor.tool).bothPointsPlaced()) {
               ((ShapeTool)RSMapperClient.editor.tool).applyAction(ToolData.ActionValues.SHAPE_REVERSE.getValue());
            }
         }
      }
   }

   public static void handleKeyReleased(KeyEvent keyevent) {
      if (!GLXToolkit.consoleIsOpen(-6279)) {
         int keycode = keyevent.getKeyCode();
         char keychar = keyevent.getKeyChar();
         if (keycode == 9) {
            RSMapperClient.toggleLoadAllRegions();
         } else if (keycode != 32 && keycode != 33) {
            if (keycode != 18 && keycode != 34) {
               if (keycode != 18 && keycode != 20 && keycode != 27 && keycode != 16) {
                  if (keychar != 'q' && keychar != 'Q') {
                     if (keychar == 'e' || keychar == 'E') {
                        RSMapperClient.editor.tool.applyAction(RSMapperClient.editor.tool.doubleClickActionValue[RSMapperClient.editor.editing.ordinal()]);
                     } else if (keychar == 'c') {
                        if (RSMapperClient.editor.selectedTile != null && RSMapperClient.editor.tool != null) {
                           if (RSMapperClient.editor.tool instanceof DefaultTool) {
                              ((DefaultTool)RSMapperClient.editor.tool)
                                 .applyAction(
                                    RSMapperClient.editor.editing == EditorType.PROPERTIES
                                       ? ToolData.ActionValues.SINGLE_COPY.getValue()
                                       : ToolData.ActionValues.SINGLE_OBJ_COPY.getValue()
                                 );
                           } else if (RSMapperClient.editor.tool instanceof BrushTool && RSMapperClient.editor.editing == EditorType.OBJECTS) {
                              ((BrushTool)RSMapperClient.editor.tool).applyAction(ToolData.ActionValues.BRUSH_OBJ_COPY.getValue());
                           } else if (RSMapperClient.editor.tool instanceof ShapeTool) {
                              ((ShapeTool)RSMapperClient.editor.tool).applyAction(ToolData.ActionValues.SHAPE_COPY.getValue());
                           } else if (RSMapperClient.editor.tool instanceof FXTool) {
                              ((FXTool)RSMapperClient.editor.tool).applyAction(ToolData.ActionValues.EFFECTS_COPY.getValue());
                           }
                        }
                     } else if (keychar == 'v') {
                        if (RSMapperClient.editor.selectedTile != null && RSMapperClient.editor.tool != null) {
                           if (RSMapperClient.editor.tool instanceof DefaultTool) {
                              ((DefaultTool)RSMapperClient.editor.tool)
                                 .applyAction(
                                    RSMapperClient.editor.editing == EditorType.PROPERTIES
                                       ? ToolData.ActionValues.SINGLE_PASTE.getValue()
                                       : ToolData.ActionValues.SINGLE_OBJ_PASTE.getValue()
                                 );
                           } else if (RSMapperClient.editor.tool instanceof BrushTool && RSMapperClient.editor.editing == EditorType.OBJECTS) {
                              ((BrushTool)RSMapperClient.editor.tool).applyAction(ToolData.ActionValues.BRUSH_OBJ_PASTE.getValue());
                           } else if (RSMapperClient.editor.tool instanceof FXTool) {
                              ((FXTool)RSMapperClient.editor.tool).applyAction(ToolData.ActionValues.EFFECTS_PASTE.getValue());
                           }
                        }
                     } else if (keychar == 'x') {
                        if (RSMapperClient.editor.selectedTile != null && RSMapperClient.editor.tool != null) {
                           if (RSMapperClient.editor.tool instanceof DefaultTool && RSMapperClient.editor.editing == EditorType.OBJECTS) {
                              ((DefaultTool)RSMapperClient.editor.tool).applyAction(ToolData.ActionValues.SINGLE_REMOVE.getValue());
                           } else if (RSMapperClient.editor.tool instanceof BrushTool && RSMapperClient.editor.editing == EditorType.OBJECTS) {
                              ((BrushTool)RSMapperClient.editor.tool).applyAction(ToolData.ActionValues.BRUSH_REMOVE.getValue());
                           } else if (RSMapperClient.editor.tool instanceof HeightTool) {
                              if (ToolData.heightMode == HeightTool.Mode.RAMP) {
                                 ((BridgeTool)RSMapperClient.editor.tool).applyAction(ToolData.ActionValues.HEIGHT_RAMP_CLEAR.getValue());
                              }
                           } else if (RSMapperClient.editor.tool instanceof BridgeTool) {
                              ((BridgeTool)RSMapperClient.editor.tool).applyAction(ToolData.ActionValues.BRIDGE_CLEAR_POINTS.getValue());
                           } else if (RSMapperClient.editor.tool instanceof ShapeTool) {
                              ((ShapeTool)RSMapperClient.editor.tool).applyAction(ToolData.ActionValues.SHAPE_CLEAR_POINTS.getValue());
                           }
                        }
                     } else if (keychar == 'r') {
                        if (RSMapperClient.editor.selectedTile != null
                           && RSMapperClient.editor.tool != null
                           && RSMapperClient.editor.tool instanceof DefaultTool) {
                           if (RSMapperClient.editor.editing == EditorType.PROPERTIES) {
                              RSMapperClient.editor.saveMapState(false);
                              if (ToolData.defaultMapRotation >= 3) {
                                 ToolData.defaultMapRotation = 0;
                              } else {
                                 ++ToolData.defaultMapRotation;
                              }

                              RSMapperClient.editor
                                 .mapEditor
                                 .saveTileWithNewProperty(
                                    RSMapperClient.editor.selectedTile, MapEditor.PropertyType.ROTATION, ToolData.defaultMapRotation, false, true, true
                                 );
                           } else {
                              int[][] objectsOnTile = RSMapperClient.editor
                                 .objectEditor
                                 .getObjectsOnTile(RSMapperClient.editor.selectedTile, ToolData.defaultSpawnUnderland);
                              if (objectsOnTile != null) {
                                 int[] objectOnTile = null;

                                 for(int[] object : objectsOnTile) {
                                    if (object[1] >= 0
                                       && ObjectSpawnEditor.objectTypeFlags[object[1]] == ObjectSpawnEditor.objectTypeFlags[ToolData.defaultObjectType]) {
                                       objectOnTile = object;
                                       break;
                                    }
                                 }

                                 if (objectOnTile != null) {
                                    RSMapperClient.editor.saveMapState(false);
                                    ToolData.defaultObjectRotation = objectOnTile[2];
                                    if (ToolData.defaultObjectRotation == 3) {
                                       ToolData.defaultObjectRotation = 0;
                                    } else {
                                       ++ToolData.defaultObjectRotation;
                                    }

                                    RSMapperClient.editor
                                       .objectEditor
                                       .placeObject(
                                          RSMapperClient.editor.selectedTile,
                                          objectOnTile[0],
                                          objectOnTile[1],
                                          ToolData.defaultObjectRotation,
                                          ToolData.defaultSpawnUnderland,
                                          true
                                       );
                                 }

                                 ((JTextField)UIPanels.objectComponents.get("input_rotation")).setText("" + ToolData.defaultObjectRotation);
                              }
                           }
                        }
                     } else if (keychar == '1') {
                        if (RSMapperClient.editor != null) {
                           RSMapperClient.editor.setTool(new DefaultTool());
                        }
                     } else if (keychar == '2') {
                        if (RSMapperClient.editor != null) {
                           RSMapperClient.editor.setTool(new BrushTool());
                        }
                     } else if (keychar == '3') {
                        if (RSMapperClient.editor != null) {
                           RSMapperClient.editor.setTool(new HeightTool());
                        }
                     } else if (keychar == '4') {
                        if (RSMapperClient.editor != null) {
                           RSMapperClient.editor.setTool(new BridgeTool());
                        }
                     } else if (keychar == '5') {
                        if (RSMapperClient.editor != null) {
                           RSMapperClient.editor.setTool(new ShapeTool());
                        }
                     } else if (keychar == '6' && RSMapperClient.editor != null) {
                        RSMapperClient.editor.setTool(new FXTool());
                     }
                  } else if (Class78.SELECTING_OBJECT) {
                     Class78.SELECTING_OBJECT = false;
                     ((JButton)UIPanels.generalComponents.get("mouse_select_obj")).setBorder(null);
                  }
               }
            } else {
               Class78.sendTeleport(0, 0, Class295.myPlayer.plane == 0 ? 3 : Class295.myPlayer.plane - 1, false);
            }
         } else {
            Class78.sendTeleport(0, 0, Class295.myPlayer.plane == 3 ? 0 : Class295.myPlayer.plane + 1, false);
         }
      }
   }
}
