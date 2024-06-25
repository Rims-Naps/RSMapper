import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class HeightTool extends Tool {
   public WorldTile point1;
   public WorldTile point2;
   public ArrayList<WorldTile> selectedTiles;

   public HeightTool() {
      this.doubleClickActionValue = ToolData.heightDoubleClickAction;
      this.propertyComponents = new ConcurrentHashMap<>();
      this.objectComponents = new ConcurrentHashMap<>();
   }

   public boolean bothPointsPlaced() {
      return this.point1 != null && this.point2 != null;
   }

   @Override
   public EditorType getType() {
      return EditorType.PROPERTIES;
   }

   @Override
   public String[] getActionText() {
      switch(ToolData.heightMode) {
         case SMOOTH:
            return new String[]{"<col=edb75a>Smooth</col>"};
         case HILL:
            return new String[]{"<col=edb75a>Hill</col>"};
         case RAMP:
            return new String[]{"<col=edb75a>Ramp</col>", "<col=db0d30>Clear</col>"};
         case ADJUST:
            return new String[]{"<col=edb75a>Adjust</col>"};
         case SAME_HEIGHT_PLANES:
            return new String[]{"<col=edb75a>Apply</col>"};
         default:
            return null;
      }
   }

   @Override
   public int[] getActionValues() {
      switch(ToolData.heightMode) {
         case SMOOTH:
            return new int[]{ToolData.ActionValues.HEIGHT_SMOOTH.getValue()};
         case HILL:
            return new int[]{ToolData.ActionValues.HEIGHT_HILL.getValue()};
         case RAMP:
            return new int[]{ToolData.ActionValues.HEIGHT_RAMP.getValue(), ToolData.ActionValues.HEIGHT_RAMP_CLEAR.getValue()};
         case ADJUST:
            return new int[]{ToolData.ActionValues.HEIGHT_ADJUST.getValue()};
         case SAME_HEIGHT_PLANES:
            return new int[]{ToolData.ActionValues.HEIGHT_SAME.getValue()};
         default:
            return null;
      }
   }

   @Override
   public void setDoubleClickAction(int actionValue, boolean forProperties, boolean storeValue) {
      this.doubleClickActionValue[forProperties ? 0 : 1] = actionValue;
      if (storeValue) {
         ToolData.heightDoubleClickAction[forProperties ? 0 : 1] = actionValue;
      }
   }

   @Override
   public BrushType[] getAllowedBrushes() {
      return new BrushType[]{
         BrushType.SQUARE,
         BrushType.RHOMBUS,
         BrushType.CIRCLE,
         BrushType.LINE_X,
         BrushType.LINE_Y,
         BrushType.CHECKERED,
         BrushType.SQUARE_BORDER,
         BrushType.RHOMBUS_BORDER,
         BrushType.CIRCLE_BORDER
      };
   }

   @Override
   public void applyAction(int actionValue) {
      if (actionValue == ToolData.ActionValues.HEIGHT_SMOOTH.getValue()) {
         if (RSMapperClient.editor.brush.type == BrushType.SQUARE) {
            RSMapperClient.editor.saveMapState(false);
         } else {
            RSMapperClient.editor
               .saveMapState(
                  false, new Brush(BrushType.SQUARE, RSMapperClient.editor.brush.size, false).getTilesBasedOnBrushAndSize(RSMapperClient.editor.selectedTile)
               );
         }

         RSMapperClient.editor.mapEditor.smoothVerticeHeights(RSMapperClient.editor.selectedTile, ToolData.heightSmoothUndermap, true);
      } else if (actionValue == ToolData.ActionValues.HEIGHT_RAMP.getValue() && this.bothPointsPlaced()) {
         RSMapperClient.editor.saveMapState(false, RSMapperClient.editor.mapEditor.getAllTilesForBridge(this.point1, this.point2));
         RSMapperClient.editor.mapEditor.makeBridge(this.point1, this.point2, this.selectedTiles, false, ToolData.heightRampUndermap);
      } else if (actionValue == ToolData.ActionValues.HEIGHT_RAMP_CLEAR.getValue()) {
         this.point1 = null;
         this.point2 = null;
         this.selectedTiles = null;
      } else if (actionValue == ToolData.ActionValues.HEIGHT_HILL.getValue()) {
         if (RSMapperClient.editor.brush.type == BrushType.SQUARE) {
            RSMapperClient.editor.saveMapState(false);
         } else {
            RSMapperClient.editor
               .saveMapState(
                  false, new Brush(BrushType.SQUARE, RSMapperClient.editor.brush.size, false).getTilesBasedOnBrushAndSize(RSMapperClient.editor.selectedTile)
               );
         }

         RSMapperClient.editor
            .mapEditor
            .makeHill(RSMapperClient.editor.selectedTile, ToolData.heightHillIntensity, ToolData.heightInverseHill, ToolData.heightHillUndermap, true);
      } else if (actionValue == ToolData.ActionValues.HEIGHT_ADJUST.getValue()) {
         RSMapperClient.editor.saveMapState(false);

         for(WorldTile t : RSMapperClient.editor.selectedTiles) {
            int height = RSMapperClient.editor.mapEditor.getValueFromTile(t, MapEditor.PropertyType.HEIGHT, ToolData.heightAdjustUndermap);
            height = ToolData.heightAdjustDown ? height + ToolData.heightAdjustValue * 32 : height - ToolData.heightAdjustValue * 32;
            RSMapperClient.editor.mapEditor.saveTileWithNewProperty(t, MapEditor.PropertyType.HEIGHT, height, ToolData.heightAdjustUndermap, false, false);
         }

         Class78.MAP_CHANGED = true;
      } else if (actionValue == ToolData.ActionValues.HEIGHT_SAME.getValue()) {
         RSMapperClient.editor.saveMapState(false);

         for(WorldTile t : RSMapperClient.editor.selectedTiles) {
            int height = RSMapperClient.editor
               .mapEditor
               .getValueFromTile(new WorldTile(t.getLocalX(), t.getLocalY(), 0, true), MapEditor.PropertyType.HEIGHT, false);

            for(int i = 1; i < 4; ++i) {
               if (ToolData.HeightSameincludedPlanes[i - 1]) {
                  RSMapperClient.editor.mapEditor.heights[i][t.getLocalX()][t.getLocalY()] = height;
               }
            }
         }

         Class78.MAP_CHANGED = true;
      }
   }

   @Override
   public void handleTileHover(int localX, int localY) {
      if (this.point1 == null && this.point2 == null) {
         super.handleTileHover(localX, localY);
      }

      if (ToolData.heightMode == HeightTool.Mode.RAMP) {
         if (this.point1 == null || this.point2 == null) {
            if (this.point2 != null && this.point1 == null) {
               this.point1 = this.point2;
               this.point2 = null;
            }

            if (this.point1 != null) {
               if (localX == this.point1.getLocalX() && localY == this.point1.getLocalY()) {
                  return;
               }

               boolean ortho = Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false) == 1;
               ArrayList<WorldTile> markedTiles = new ArrayList<>();
               if (localY == this.point1.getLocalY()) {
                  for(int x = this.point1.getLocalX() > localX ? localX : this.point1.getLocalX();
                     x <= (this.point1.getLocalX() > localX ? this.point1.getLocalX() : localX);
                     ++x
                  ) {
                     if (ortho) {
                        r.createTileMarker(
                           x, localY, Class295.myPlayer.plane, RSMapperClient.settings.overlayTextHeight, RSMapperClient.settings.hoverOverlayColor, 1
                        );
                     } else {
                        markedTiles.add(new WorldTile(x, localY, Class295.myPlayer.plane, true));
                     }
                  }
               } else if (localX == this.point1.getLocalX()) {
                  for(int y = this.point1.getLocalY() > localY ? localY : this.point1.getLocalY();
                     y <= (this.point1.getLocalY() > localY ? this.point1.getLocalY() : localY);
                     ++y
                  ) {
                     if (ortho) {
                        r.createTileMarker(
                           localX, y, Class295.myPlayer.plane, RSMapperClient.settings.overlayTextHeight, RSMapperClient.settings.hoverOverlayColor, 1
                        );
                     } else {
                        markedTiles.add(new WorldTile(localX, y, Class295.myPlayer.plane, true));
                     }
                  }
               } else {
                  boolean cursorXGreater = Math.max(this.point1.getLocalX(), localX) == localX;
                  boolean cursorYGreater = Math.max(this.point1.getLocalY(), localY) == localY;
                  int xDiff = (cursorXGreater ? localX : this.point1.getLocalX()) - (cursorXGreater ? this.point1.getLocalX() : localX);
                  int yDiff = (cursorYGreater ? localY : this.point1.getLocalY()) - (cursorYGreater ? this.point1.getLocalY() : localY);
                  if ((xDiff + 1) * (yDiff + 1) < 1000) {
                     for(int x = cursorXGreater ? this.point1.getLocalX() : localX; x <= (cursorXGreater ? localX : this.point1.getLocalX()); ++x) {
                        for(int y = cursorYGreater ? this.point1.getLocalY() : localY; y <= (cursorYGreater ? localY : this.point1.getLocalY()); ++y) {
                           if (ortho) {
                              r.createTileMarker(
                                 x, y, Class295.myPlayer.plane, RSMapperClient.settings.overlayTextHeight, RSMapperClient.settings.hoverOverlayColor, 1
                              );
                           } else {
                              markedTiles.add(new WorldTile(x, y, Class295.myPlayer.plane, true));
                           }
                        }
                     }
                  }
               }

               if (!ortho && markedTiles.size() > 0) {
                  for(WorldTile t : markedTiles) {
                     int x = t.getLocalX();
                     int y = t.getLocalY();
                     if ((x != this.point1.getLocalX() || y != this.point1.getLocalY())
                        && x < 104
                        && x >= 0
                        && y < 104
                        && y >= 0
                        && Class167.anInt2033 < Node_Sub25_Sub2.aClass54Array9959.length - 1) {
                        Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asTileBorder(t.isWithinRegionBounds() ? 20 : 21, x, y, t.getPlane());
                     }
                  }

                  if (Class167.anInt2033 < Node_Sub25_Sub2.aClass54Array9959.length - 2) {
                     Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asTileBorder(
                        23, this.point1.getLocalX(), this.point1.getLocalY(), this.point1.getPlane()
                     );
                     Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asVerticeHighlight(
                        22, this.point1.getLocalX(), this.point1.getLocalY(), this.point1.getPlane()
                     );
                  }
               }
            }
         }
      } else {
         super.handleTileHover(localX, localY);
      }
   }

   @Override
   public boolean handleTileClick(int localX, int localY, int plane, int actionValue) {
      if (ToolData.heightMode == HeightTool.Mode.RAMP) {
         if (actionValue != 1) {
            this.applyAction(actionValue);
         } else {
            if (this.point1 != null && this.point2 != null && RSMapperClient.editor.isDoubleClickActionActivated()) {
               for(WorldTile t : this.selectedTiles) {
                  if (t.getLocalX() == localX && t.getLocalY() == localY && t.getPlane() == plane) {
                     if ((localX != this.point1.getLocalX() || localY != this.point1.getLocalY())
                        && (localX != this.point2.getLocalX() || localY != this.point2.getLocalY())) {
                        this.applyAction(this.doubleClickActionValue[0]);
                        if (this.doubleClickActionValue[0] == ToolData.ActionValues.HEIGHT_RAMP_CLEAR.getValue()) {
                           this.setEditingTiles(localX, localY, plane, actionValue);
                        }

                        return true;
                     }
                     break;
                  }
               }
            } else if (this.point1 == null && this.point2 == null) {
               this.setEditingTiles(localX, localY, plane, actionValue);
               this.point1 = RSMapperClient.editor.getClickedTile();
               return true;
            }

            boolean pointHandled = false;
            if (this.point1 != null && this.point1.equals(new WorldTile(localX, localY, Class295.myPlayer.plane, true))) {
               this.point1 = null;
               if (this.point2 != null) {
                  this.setEditingTiles(this.point2.getLocalX(), this.point2.getLocalY(), this.point2.getPlane(), actionValue);
               }

               pointHandled = true;
            }

            if (!pointHandled && this.point2 != null && this.point2.equals(new WorldTile(localX, localY, Class295.myPlayer.plane, true))) {
               this.point2 = null;
               if (this.point1 != null) {
                  this.setEditingTiles(this.point1.getLocalX(), this.point1.getLocalY(), this.point1.getPlane(), actionValue);
               }

               pointHandled = true;
            }

            if (!pointHandled) {
               if (this.point1 == null) {
                  this.point1 = new WorldTile(localX, localY, Class295.myPlayer.plane, true);
               } else if (this.point2 == null) {
                  this.point2 = new WorldTile(localX, localY, Class295.myPlayer.plane, true);
               }
            }

            if (this.point1 != null && this.point2 != null) {
               if (this.selectedTiles == null) {
                  this.selectedTiles = new ArrayList<>();
               } else {
                  this.selectedTiles.clear();
               }

               boolean point2XGreater = Math.max(this.point1.getLocalX(), this.point2.getLocalX()) == this.point2.getLocalX();
               boolean point2YGreater = Math.max(this.point1.getLocalY(), this.point2.getLocalY()) == this.point2.getLocalY();

               for(int x = point2XGreater ? this.point1.getLocalX() : this.point2.getLocalX();
                  x <= (point2XGreater ? this.point2.getLocalX() : this.point1.getLocalX());
                  ++x
               ) {
                  for(int y = point2YGreater ? this.point1.getLocalY() : this.point2.getLocalY();
                     y <= (point2YGreater ? this.point2.getLocalY() : this.point1.getLocalY());
                     ++y
                  ) {
                     this.selectedTiles.add(new WorldTile(x, y, this.point1.getPlane(), true));
                  }
               }
            }
         }
      } else {
         super.handleTileClick(localX, localY, plane, actionValue);
      }

      return true;
   }

   @Override
   public void createTileMarkers() {
      if (ToolData.heightMode == HeightTool.Mode.RAMP && this.point1 != null && this.point2 != null && this.selectedTiles != null) {
         for(WorldTile tile : this.selectedTiles) {
            if (tile.isWithinRegionBounds()) {
               if (this.point1.equals(tile) || this.point2.equals(tile)) {
                  r.createTextMarker(this.point1.equals(tile) ? "1" : "2", tile.getLocalX(), tile.getLocalY(), tile.getPlane(), 0, 573195, 1);
               }

               int x = tile.getLocalX();
               int y = tile.getLocalY();
               if (Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false) == 1) {
                  r.createTileMarker(tile.getLocalX(), tile.getLocalY(), tile.getPlane(), 0, RSMapperClient.settings.selectedOverlayColor, 1);
               } else if (x < 104 && x >= 0 && y < 104 && y >= 0 && Class167.anInt2033 < Node_Sub25_Sub2.aClass54Array9959.length - 2) {
                  Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asTileBorder(23, x, y, tile.getPlane());
                  Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asVerticeHighlight(22, x, y, tile.getPlane());
               }
            }
         }
      }

      super.createTileMarkers();
   }

   @Override
   public void setupUI() {
      if (ToolData.heightMode == null) {
         ToolData.heightMode = HeightTool.Mode.SMOOTH;
      }

      JTextField propertiesTitle = new JTextField();
      propertiesTitle.setBounds(4, 4, 285, 24);
      propertiesTitle.setHorizontalAlignment(0);
      propertiesTitle.setEditable(false);
      propertiesTitle.setText("HEIGHT MODES");
      propertiesTitle.setFont(new Font("", 1, 16));
      UIPanels.propertiesTabPanel.add(propertiesTitle);
      this.propertyComponents.put("properties_title", propertiesTitle);
      int shiftY = 22;
      JButton smoothMode = new JButton("Smooth");
      smoothMode.setBounds(6, shiftY + 10, 281, 26);
      smoothMode.setFont(new Font("", 1, 16));
      smoothMode.setForeground(new Color(237, 183, 90));
      smoothMode.setBorder(ToolData.heightMode == HeightTool.Mode.SMOOTH ? BorderFactory.createLineBorder(Color.GREEN) : null);
      smoothMode.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.heightMode = HeightTool.Mode.SMOOTH;
            HeightTool.this.setFields();
            HeightTool.this.setDoubleClickAction(ToolData.ActionValues.HEIGHT_SMOOTH.getValue(), true, true);
            HeightTool.this.setupDoubleClickActionCB();
         }
      });
      UIPanels.propertiesTabPanel.add(smoothMode);
      this.propertyComponents.put("smooth_mode_button", smoothMode);
      final JCheckBox smoothUndermap = new JCheckBox("UM");
      smoothUndermap.setSelected(ToolData.heightSmoothUndermap);
      smoothUndermap.setBounds(6, shiftY + 40, 50, 24);
      UIPanels.propertiesTabPanel.add(smoothUndermap);
      this.propertyComponents.put("smooth_um", smoothUndermap);
      smoothUndermap.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.heightSmoothUndermap = smoothUndermap.isSelected();
         }
      });
      JButton adjustMode = new JButton("Adjust");
      adjustMode.setBounds(6, shiftY + 55 + 20, 281, 26);
      adjustMode.setFont(new Font("", 1, 16));
      adjustMode.setForeground(new Color(237, 183, 90));
      adjustMode.setBorder(ToolData.heightMode == HeightTool.Mode.ADJUST ? BorderFactory.createLineBorder(Color.GREEN) : null);
      adjustMode.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.heightMode = HeightTool.Mode.ADJUST;
            HeightTool.this.setFields();
            HeightTool.this.setDoubleClickAction(ToolData.ActionValues.HEIGHT_ADJUST.getValue(), true, true);
            HeightTool.this.setupDoubleClickActionCB();
         }
      });
      UIPanels.propertiesTabPanel.add(adjustMode);
      this.propertyComponents.put("adjust_mode_button", adjustMode);
      final JCheckBox adjustUndermap = new JCheckBox("UM");
      adjustUndermap.setSelected(ToolData.heightAdjustUndermap);
      adjustUndermap.setBounds(4, shiftY + 85 + 20, 50, 24);
      UIPanels.propertiesTabPanel.add(adjustUndermap);
      this.propertyComponents.put("adjust_um", adjustUndermap);
      adjustUndermap.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.heightAdjustUndermap = adjustUndermap.isSelected();
         }
      });
      final JCheckBox adjustDown = new JCheckBox("Down");
      adjustDown.setSelected(ToolData.heightAdjustDown);
      adjustDown.setBounds(56, shiftY + 85 + 20, 60, 24);
      UIPanels.propertiesTabPanel.add(adjustDown);
      this.propertyComponents.put("adjust_down", adjustDown);
      adjustDown.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.heightAdjustDown = adjustDown.isSelected();
         }
      });
      JSlider adjustValue = new JSlider(0, 1, 20, ToolData.heightAdjustValue);
      adjustValue.setBounds(115, shiftY + 85 + 20, 150, 20);
      adjustValue.setMajorTickSpacing(2);
      adjustValue.setMinorTickSpacing(1);
      adjustValue.setSnapToTicks(true);
      adjustValue.setPaintTicks(true);
      adjustValue.setPaintLabels(true);
      final JLabel adjustValueLabel = new JLabel("" + ToolData.heightAdjustValue);
      adjustValueLabel.setBounds(265, shiftY + 85 + 20, 20, 20);
      UIPanels.propertiesTabPanel.add(adjustValueLabel);
      this.propertyComponents.put("adjust_value_label", adjustValueLabel);
      adjustValue.addChangeListener(new ChangeListener() {
         @Override
         public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
               ToolData.heightAdjustValue = source.getValue();
               adjustValueLabel.setText("" + ToolData.heightAdjustValue);
            }
         }
      });
      UIPanels.propertiesTabPanel.add(adjustValue);
      this.propertyComponents.put("adjust_value", adjustValue);
      JButton rampMode = new JButton("Ramp");
      rampMode.setBounds(6, shiftY + 125 + 20, 281, 26);
      rampMode.setFont(new Font("", 1, 16));
      rampMode.setForeground(new Color(237, 183, 90));
      rampMode.setBorder(ToolData.heightMode == HeightTool.Mode.RAMP ? BorderFactory.createLineBorder(Color.GREEN) : null);
      rampMode.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.heightMode = HeightTool.Mode.RAMP;
            HeightTool.this.setFields();
            HeightTool.this.setDoubleClickAction(ToolData.ActionValues.HEIGHT_RAMP.getValue(), true, true);
            HeightTool.this.setupDoubleClickActionCB();
         }
      });
      UIPanels.propertiesTabPanel.add(rampMode);
      this.propertyComponents.put("ramp_mode_button", rampMode);
      final JCheckBox rampUndermap = new JCheckBox("UM");
      rampUndermap.setSelected(ToolData.heightRampUndermap);
      rampUndermap.setBounds(6, shiftY + 154 + 20, 50, 24);
      UIPanels.propertiesTabPanel.add(rampUndermap);
      this.propertyComponents.put("ramp_um", rampUndermap);
      rampUndermap.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.heightRampUndermap = rampUndermap.isSelected();
         }
      });
      JButton hillMode = new JButton("Hill");
      hillMode.setBounds(6, shiftY + 120 + 50 + 20 + 20, 281, 26);
      hillMode.setFont(new Font("", 1, 16));
      hillMode.setForeground(new Color(237, 183, 90));
      hillMode.setBorder(ToolData.heightMode == HeightTool.Mode.HILL ? BorderFactory.createLineBorder(Color.GREEN) : null);
      hillMode.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.heightMode = HeightTool.Mode.HILL;
            HeightTool.this.setFields();
            HeightTool.this.setDoubleClickAction(ToolData.ActionValues.HEIGHT_HILL.getValue(), true, true);
            HeightTool.this.setupDoubleClickActionCB();
         }
      });
      UIPanels.propertiesTabPanel.add(hillMode);
      this.propertyComponents.put("hill_mode_button", hillMode);
      final JCheckBox undermapHill = new JCheckBox("UM");
      undermapHill.setSelected(ToolData.heightHillUndermap);
      undermapHill.setBounds(4, shiftY + 120 + 80 + 20 + 20, 50, 24);
      UIPanels.propertiesTabPanel.add(undermapHill);
      this.propertyComponents.put("undermap_hill", undermapHill);
      undermapHill.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.heightHillUndermap = undermapHill.isSelected();
         }
      });
      final JCheckBox inverseHill = new JCheckBox("Down");
      inverseHill.setSelected(ToolData.heightInverseHill);
      inverseHill.setBounds(56, shiftY + 120 + 80 + 20 + 20, 60, 24);
      UIPanels.propertiesTabPanel.add(inverseHill);
      this.propertyComponents.put("inverse_hill", inverseHill);
      inverseHill.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.heightInverseHill = inverseHill.isSelected();
         }
      });
      JSlider hillIntensity = new JSlider(0, 1, 10, ToolData.heightHillIntensity);
      hillIntensity.setBounds(115, shiftY + 120 + 80 + 20 + 20, 150, 20);
      hillIntensity.setMajorTickSpacing(5);
      hillIntensity.setMinorTickSpacing(1);
      hillIntensity.setSnapToTicks(true);
      hillIntensity.setPaintTicks(true);
      hillIntensity.setPaintLabels(true);
      final JLabel hillIntensityLabel = new JLabel("" + ToolData.heightHillIntensity);
      hillIntensityLabel.setBounds(265, shiftY + 120 + 80 + 20 + 20, 20, 20);
      UIPanels.propertiesTabPanel.add(hillIntensityLabel);
      this.propertyComponents.put("hill_intensity_label", hillIntensityLabel);
      hillIntensity.addChangeListener(new ChangeListener() {
         @Override
         public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
               ToolData.heightHillIntensity = source.getValue();
               hillIntensityLabel.setText("" + ToolData.heightHillIntensity);
            }
         }
      });
      UIPanels.propertiesTabPanel.add(hillIntensity);
      this.propertyComponents.put("hill_intensity", hillIntensity);
      JButton sameHeightMode = new JButton("Same Height As Plane 0");
      sameHeightMode.setBounds(6, shiftY + 120 + 80 + 20 + 20 + 40, 281, 26);
      sameHeightMode.setFont(new Font("", 1, 16));
      sameHeightMode.setForeground(new Color(237, 183, 90));
      sameHeightMode.setBorder(ToolData.heightMode == HeightTool.Mode.SAME_HEIGHT_PLANES ? BorderFactory.createLineBorder(Color.GREEN) : null);
      sameHeightMode.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.heightMode = HeightTool.Mode.SAME_HEIGHT_PLANES;
            HeightTool.this.setFields();
            HeightTool.this.setDoubleClickAction(ToolData.ActionValues.HEIGHT_SAME.getValue(), true, true);
            HeightTool.this.setupDoubleClickActionCB();
         }
      });
      UIPanels.propertiesTabPanel.add(sameHeightMode);
      this.propertyComponents.put("sameheight_mode_button", sameHeightMode);
      JLabel planesLabel = new JLabel("Planes:");
      planesLabel.setBounds(10, shiftY + 120 + 80 + 50 + 20 + 40, 50, 20);
      UIPanels.propertiesTabPanel.add(planesLabel);
      this.propertyComponents.put("planes_label", planesLabel);
      final JCheckBox heightPlane1 = new JCheckBox("1");
      heightPlane1.setSelected(ToolData.HeightSameincludedPlanes[0]);
      heightPlane1.setBounds(66, shiftY + 120 + 80 + 50 + 20 + 40, 35, 24);
      UIPanels.propertiesTabPanel.add(heightPlane1);
      this.propertyComponents.put("height_plane_1", heightPlane1);
      heightPlane1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.HeightSameincludedPlanes[0] = heightPlane1.isSelected();
         }
      });
      final JCheckBox heightPlane2 = new JCheckBox("2");
      heightPlane2.setSelected(ToolData.HeightSameincludedPlanes[1]);
      heightPlane2.setBounds(106, shiftY + 120 + 80 + 50 + 20 + 40, 35, 24);
      UIPanels.propertiesTabPanel.add(heightPlane2);
      this.propertyComponents.put("height_plane_2", heightPlane2);
      heightPlane2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.HeightSameincludedPlanes[1] = heightPlane2.isSelected();
         }
      });
      final JCheckBox heightPlane3 = new JCheckBox("3");
      heightPlane3.setSelected(ToolData.HeightSameincludedPlanes[2]);
      heightPlane3.setBounds(146, shiftY + 120 + 80 + 50 + 20 + 40, 35, 24);
      UIPanels.propertiesTabPanel.add(heightPlane3);
      this.propertyComponents.put("height_plane_3", heightPlane3);
      heightPlane3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.HeightSameincludedPlanes[2] = heightPlane3.isSelected();
         }
      });
   }

   @Override
   public void init() {
      if (RSMapperClient.editor != null && RSMapperClient.editor.editing != null) {
         this.setupDoubleClickActionCB();
      }
   }

   @Override
   public void setFields() {
      for(Entry<String, JComponent> pair : this.propertyComponents.entrySet()) {
         String name = pair.getKey();
         JComponent component = pair.getValue();
         if (component instanceof JButton && name.contains("_mode_button")) {
            if (name.equalsIgnoreCase("smooth_mode_button")) {
               if (ToolData.heightMode == HeightTool.Mode.SMOOTH) {
                  ((JButton)component).setBorder(BorderFactory.createLineBorder(Color.GREEN));
               } else {
                  ((JButton)component).setBorder(null);
               }
            }

            if (name.equalsIgnoreCase("adjust_mode_button")) {
               if (ToolData.heightMode == HeightTool.Mode.ADJUST) {
                  ((JButton)component).setBorder(BorderFactory.createLineBorder(Color.GREEN));
               } else {
                  ((JButton)component).setBorder(null);
               }
            }

            if (name.equalsIgnoreCase("hill_mode_button")) {
               if (ToolData.heightMode == HeightTool.Mode.HILL) {
                  ((JButton)component).setBorder(BorderFactory.createLineBorder(Color.GREEN));
               } else {
                  ((JButton)component).setBorder(null);
               }
            }

            if (name.equalsIgnoreCase("ramp_mode_button")) {
               if (ToolData.heightMode == HeightTool.Mode.RAMP) {
                  ((JButton)component).setBorder(BorderFactory.createLineBorder(Color.GREEN));
               } else {
                  ((JButton)component).setBorder(null);
               }
            }

            if (name.equalsIgnoreCase("sameheight_mode_button")) {
               if (ToolData.heightMode == HeightTool.Mode.SAME_HEIGHT_PLANES) {
                  ((JButton)component).setBorder(BorderFactory.createLineBorder(Color.GREEN));
               } else {
                  ((JButton)component).setBorder(null);
               }
            }
         }
      }

      super.setFields();
   }

   public static enum Mode {
      SMOOTH,
      HILL,
      RAMP,
      ADJUST,
      SAME_HEIGHT_PLANES;
   }
}
