import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class FXTool extends Tool {
   WorldTile positioningTile;

   public FXTool() {
      this.doubleClickActionValue = ToolData.FXDoubleClickAction;
      this.propertyComponents = new ConcurrentHashMap<>();
      this.setEffect();
   }

   public void setEffect() {
      if (RSMapperClient.editor.selectedTile != null && RSMapperClient.editor.mapEditor.getEffectOnTile(RSMapperClient.editor.selectedTile) != null) {
         ToolData.FXToolEffectOnTile = RSMapperClient.editor.mapEditor.getEffectOnTile(RSMapperClient.editor.selectedTile);
      } else if (ToolData.FXToolEffectOnTile == null
         || RSMapperClient.editor.selectedTile == null
         || RSMapperClient.editor.mapEditor.getEffectOnTile(RSMapperClient.editor.selectedTile) == null) {
         ToolData.FXToolEffectOnTile = new CachedEffect(
            RSMapperClient.editor.selectedTile == null ? 0 : MapEditor.findReferenceCoord(RSMapperClient.editor.selectedTile.getLocalX(), 0),
            RSMapperClient.editor.selectedTile == null ? 0 : MapEditor.findReferenceCoord(RSMapperClient.editor.selectedTile.getLocalY(), 0),
            Class295.myPlayer == null ? 0 : Class295.myPlayer.plane,
            Class295.myPlayer == null ? 0 : Class295.myPlayer.plane,
            0,
            1,
            new int[3],
            0,
            31
         );
         ToolData.FXToolEffectOnTile.setFlickerType(0);
      }
   }

   @Override
   public EditorType getType() {
      return EditorType.PROPERTIES;
   }

   @Override
   public String[] getActionText() {
      return new String[]{"<col=edb75a>Position</col>", "<col=db0d30>Delete</col>", "<col=2a74eb>Copy</col>", "<col=17bd17>Paste</col>"};
   }

   @Override
   public int[] getActionValues() {
      return new int[]{
         ToolData.ActionValues.EFFECTS_POSITION.getValue(),
         ToolData.ActionValues.EFFECTS_DELETE.getValue(),
         ToolData.ActionValues.EFFECTS_COPY.getValue(),
         ToolData.ActionValues.EFFECTS_PASTE.getValue()
      };
   }

   @Override
   public void setDoubleClickAction(int actionValue, boolean forProperties, boolean storeValue) {
      this.doubleClickActionValue[forProperties ? 0 : 1] = actionValue;
      if (storeValue) {
         ToolData.FXDoubleClickAction[forProperties ? 0 : 1] = actionValue;
      }
   }

   @Override
   public BrushType[] getAllowedBrushes() {
      return new BrushType[]{BrushType.SQUARE};
   }

   @Override
   public void applyAction(int actionValue) {
      if (actionValue == ToolData.ActionValues.EFFECTS_POSITION.getValue()) {
         this.positioningTile = ToolData.FXToolEffectOnTile != null ? RSMapperClient.editor.selectedTile : null;
      } else if (actionValue == ToolData.ActionValues.EFFECTS_DELETE.getValue()) {
         RSMapperClient.editor.saveMapState(false);
         if (ToolData.FXToolEffectOnTile != null) {
            RSMapperClient.editor.mapEditor.effects.remove(RSMapperClient.editor.selectedTile);
            Class78.MAP_CHANGED = true;
            this.setFields();
         }
      } else if (actionValue == ToolData.ActionValues.EFFECTS_COPY.getValue()) {
         if (ToolData.FXToolEffectOnTile != null) {
            ToolData.FXToolCopiedEffect = new CachedEffect(
               ToolData.FXToolEffectOnTile.referenceX,
               ToolData.FXToolEffectOnTile.referenceY,
               ToolData.FXToolEffectOnTile.plane,
               ToolData.FXToolEffectOnTile.planeflag,
               ToolData.FXToolEffectOnTile.height,
               ToolData.FXToolEffectOnTile.spread,
               ToolData.FXToolEffectOnTile.coverage,
               ToolData.FXToolEffectOnTile.colorIndex,
               ToolData.FXToolEffectOnTile.flickerType2
            );
            ToolData.FXToolCopiedEffect.setFlickerType(ToolData.FXToolEffectOnTile.flickerType);
         }
      } else if (actionValue == ToolData.ActionValues.EFFECTS_PASTE.getValue() && ToolData.FXToolCopiedEffect != null) {
         RSMapperClient.editor.saveMapState(false);
         CachedEffect newFx = new CachedEffect(
            ToolData.FXToolCopiedEffect.referenceX,
            ToolData.FXToolCopiedEffect.referenceY,
            ToolData.FXToolCopiedEffect.plane,
            ToolData.FXToolCopiedEffect.planeflag,
            ToolData.FXToolCopiedEffect.height,
            ToolData.FXToolCopiedEffect.spread,
            ToolData.FXToolCopiedEffect.coverage,
            ToolData.FXToolCopiedEffect.colorIndex,
            ToolData.FXToolCopiedEffect.flickerType2
         );
         newFx.setFlickerType(ToolData.FXToolCopiedEffect.flickerType);
         RSMapperClient.editor.mapEditor.saveEffect(RSMapperClient.editor.selectedTile, newFx, true);
         this.setFields();
      }
   }

   @Override
   public void createTileMarkers() {
      WorldTile tile = RSMapperClient.editor.selectedTile;
      if (RSMapperClient.editor.mapEditor.getEffectOnTile(tile) != null) {
         r.createShapeMarker(
            ToolData.FXToolEffectOnTile.offsetX,
            0,
            ToolData.FXToolEffectOnTile.offsetX,
            512,
            false,
            tile.getLocalX(),
            tile.getLocalY(),
            tile.getPlane(),
            0,
            RSMapperClient.settings.selectedOverlayColor,
            this.positioningTile == null ? 1 : 0
         );
         r.createShapeMarker(
            0,
            ToolData.FXToolEffectOnTile.offsetY,
            512,
            ToolData.FXToolEffectOnTile.offsetY,
            false,
            tile.getLocalX(),
            tile.getLocalY(),
            tile.getPlane(),
            0,
            RSMapperClient.settings.selectedOverlayColor,
            this.positioningTile == null ? 1 : 0
         );
         if (this.positioningTile == null) {
            r.createHeightMarker(
               ToolData.FXToolEffectOnTile.offsetX,
               ToolData.FXToolEffectOnTile.offsetY,
               false,
               ToolData.FXToolEffectOnTile.height,
               tile.getLocalX(),
               tile.getLocalY(),
               tile.getPlane(),
               RSMapperClient.settings.selectedOverlayColor,
               1
            );
         }
      }

      super.createTileMarkers();
   }

   @Override
   public void handleTileHover(int localX, int localY) {
      if (this.positioningTile != null) {
         if (this.positioningTile.getLocalX() == localX && this.positioningTile.getLocalY() == localY) {
            r.createShapeMarker(
               Class93_Sub2.mouseCoordXOnTile, 0, Class93_Sub2.mouseCoordXOnTile, 512, false, localX, localY, Class295.myPlayer.plane, 0, 573195, 0
            );
            r.createShapeMarker(
               0, Class93_Sub2.mouseCoordYOnTile, 512, Class93_Sub2.mouseCoordYOnTile, false, localX, localY, Class295.myPlayer.plane, 0, 15401517, 0
            );
            r.createHeightMarker(
               Class93_Sub2.mouseCoordXOnTile,
               Class93_Sub2.mouseCoordYOnTile,
               false,
               ToolData.FXToolEffectOnTile.height,
               localX,
               localY,
               Class295.myPlayer.plane,
               255,
               0
            );
         }
      } else {
         super.handleTileHover(localX, localY);
      }
   }

   @Override
   public boolean handleTileClick(int localX, int localY, int plane, int actionValue) {
      if (actionValue == 1) {
         if (this.positioningTile != null && this.positioningTile.getLocalX() == localX && this.positioningTile.getLocalY() == localY) {
            this.setOffsets(Class93_Sub2.mouseCoordXOnTile, Class93_Sub2.mouseCoordYOnTile);
            this.positioningTile = null;
         } else {
            if (this.timesTileIsClicked <= 1) {
               this.positioningTile = null;
               this.setEditingTiles(localX, localY, plane, actionValue);
               return true;
            }

            if (RSMapperClient.editor.isDoubleClickActionActivated()) {
               if (this.timesTileIsClicked % 2 != 0) {
                  if (this.positioningTile != null && this.doubleClickActionValue[0] == ToolData.ActionValues.EFFECTS_POSITION.getValue()) {
                     this.setOffsets(Class93_Sub2.mouseCoordXOnTile, Class93_Sub2.mouseCoordYOnTile);
                     this.positioningTile = null;
                  } else {
                     this.applyAction(this.doubleClickActionValue[0]);
                  }
               } else if (this.timesTileIsClicked % 2 == 0) {
                  if (this.doubleClickActionValue[RSMapperClient.editor.editing.ordinal()] == ToolData.ActionValues.TELEPORT.getValue()) {
                     Class78.sendTeleport(localX + Node_Sub53.gameSceneBaseX, Class320_Sub4.gameSceneBaseY + localY, Class295.myPlayer.plane, true);
                  } else {
                     this.applyAction(this.doubleClickActionValue[0]);
                  }
               }
            }
         }
      } else if (actionValue > 2) {
         boolean handled = false;
         if (actionValue == ToolData.ActionValues.EFFECTS_POSITION.getValue()
            && this.positioningTile != null
            && this.positioningTile.getLocalX() == localX
            && this.positioningTile.getLocalY() == localY) {
            this.setOffsets(Class93_Sub2.mouseCoordXOnTile, Class93_Sub2.mouseCoordYOnTile);
            handled = true;
         }

         this.positioningTile = null;
         if (!handled) {
            this.setEditingTiles(localX, localY, plane, actionValue);
            this.setEffect();
            this.applyAction(actionValue);
         }

         this.timesTileIsClicked = 1;
         return true;
      }

      return false;
   }

   private void setOffsets(int offsetX, int offsetY) {
      RSMapperClient.editor.saveMapState(false);
      if (offsetX > 0 && offsetX < 508) {
         ToolData.FXToolEffectOnTile.offsetX = offsetX;
      } else {
         ToolData.FXToolEffectOnTile.offsetX = ToolData.FXToolEffectOnTile.offsetX <= 0 ? 0 : 508;
      }

      if (offsetY > 0 && offsetY < 508) {
         ToolData.FXToolEffectOnTile.offsetY = offsetY;
      } else {
         ToolData.FXToolEffectOnTile.offsetY = ToolData.FXToolEffectOnTile.offsetY <= 0 ? 0 : 508;
      }

      RSMapperClient.editor.mapEditor.saveEffect(this.positioningTile, ToolData.FXToolEffectOnTile, true);
      ((JTextField)UIPanels.propertyComponents.get("txt_fx_offsetx")).setText("" + ToolData.FXToolEffectOnTile.offsetX);
      ((JTextField)UIPanels.propertyComponents.get("txt_fx_offsety")).setText("" + ToolData.FXToolEffectOnTile.offsetY);
   }

   @Override
   public void setupUI() {
      JTextField effectsInRegion = new JTextField();
      effectsInRegion.setBounds(4, 4, 285, 24);
      effectsInRegion.setEditable(false);
      effectsInRegion.setHorizontalAlignment(0);
      effectsInRegion.setFont(new Font("", 1, 13));
      effectsInRegion.setText("Effects in Region:");
      UIPanels.propertiesTabPanel.add(effectsInRegion);
      this.propertyComponents.put("effects_in_region", effectsInRegion);
      this.updateEffectsCountLabel();
      int shiftY = 26;
      JTextField propertiesTitle = new JTextField();
      propertiesTitle.setBounds(4, 4 + shiftY, 285, 24);
      propertiesTitle.setHorizontalAlignment(0);
      propertiesTitle.setEditable(false);
      propertiesTitle.setText("LIGHTING EFFECT ON TILE");
      propertiesTitle.setFont(new Font("", 1, 16));
      UIPanels.propertiesTabPanel.add(propertiesTitle);
      this.propertyComponents.put("properties_title", propertiesTitle);
      JTextField txt_plane_title = new JTextField("Plane");
      txt_plane_title.setHorizontalAlignment(0);
      txt_plane_title.setBounds(4, shiftY + 32, 100, 24);
      txt_plane_title.setEditable(false);
      UIPanels.propertiesTabPanel.add(txt_plane_title);
      this.propertyComponents.put("txt_plane_title", txt_plane_title);
      final JCheckBox chckPlane0 = new JCheckBox("0");
      chckPlane0.setBounds(104, shiftY + 32, 32, 24);
      chckPlane0.setFont(new Font("", 0, 10));
      UIPanels.propertiesTabPanel.add(chckPlane0);
      this.propertyComponents.put("chck_plane0", chckPlane0);
      final JCheckBox chckPlane1 = new JCheckBox("1");
      chckPlane1.setBounds(134, shiftY + 32, 32, 24);
      chckPlane1.setFont(new Font("", 0, 10));
      UIPanels.propertiesTabPanel.add(chckPlane1);
      this.propertyComponents.put("chck_plane1", chckPlane1);
      final JCheckBox chckPlane2 = new JCheckBox("2");
      chckPlane2.setBounds(164, shiftY + 32, 32, 24);
      chckPlane2.setFont(new Font("", 0, 10));
      UIPanels.propertiesTabPanel.add(chckPlane2);
      this.propertyComponents.put("chck_plane2", chckPlane2);
      final JCheckBox chckPlane3 = new JCheckBox("3");
      chckPlane3.setBounds(194, shiftY + 32, 32, 24);
      chckPlane3.setFont(new Font("", 0, 10));
      UIPanels.propertiesTabPanel.add(chckPlane3);
      this.propertyComponents.put("chck_plane3", chckPlane3);
      final JCheckBox chckPlaneSpread = new JCheckBox("Spread");
      chckPlaneSpread.setBounds(224, shiftY + 32, 70, 24);
      chckPlaneSpread.setFont(new Font("", 0, 11));
      UIPanels.propertiesTabPanel.add(chckPlaneSpread);
      this.propertyComponents.put("chck_plane_spread", chckPlaneSpread);
      chckPlane0.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            chckPlane0.setSelected(true);
            chckPlane1.setSelected(false);
            chckPlane2.setSelected(false);
            chckPlane3.setSelected(false);
            if (ToolData.FXToolEffectOnTile != null) {
               ToolData.FXToolEffectOnTile.planeflag = chckPlaneSpread.isSelected() ? 8 : 0;
               Class78.MAP_CHANGED = true;
               RSMapperClient.setFocusOnCanvas();
               System.out.println("New Planeflag: " + ToolData.FXToolEffectOnTile.planeflag);
            }
         }
      });
      chckPlane1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            chckPlane1.setSelected(true);
            chckPlane0.setSelected(false);
            chckPlane2.setSelected(false);
            chckPlane3.setSelected(false);
            if (ToolData.FXToolEffectOnTile != null) {
               ToolData.FXToolEffectOnTile.planeflag = chckPlaneSpread.isSelected() ? 9 : 1;
               Class78.MAP_CHANGED = true;
               RSMapperClient.setFocusOnCanvas();
            }
         }
      });
      chckPlane2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            chckPlane2.setSelected(true);
            chckPlane0.setSelected(false);
            chckPlane1.setSelected(false);
            chckPlane3.setSelected(false);
            if (ToolData.FXToolEffectOnTile != null) {
               ToolData.FXToolEffectOnTile.planeflag = chckPlaneSpread.isSelected() ? 10 : 2;
               Class78.MAP_CHANGED = true;
               RSMapperClient.setFocusOnCanvas();
            }
         }
      });
      chckPlane3.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            chckPlane3.setSelected(true);
            chckPlane0.setSelected(false);
            chckPlane1.setSelected(false);
            chckPlane2.setSelected(false);
            if (ToolData.FXToolEffectOnTile != null) {
               ToolData.FXToolEffectOnTile.planeflag = chckPlaneSpread.isSelected() ? 11 : 3;
               Class78.MAP_CHANGED = true;
               RSMapperClient.setFocusOnCanvas();
            }
         }
      });
      chckPlaneSpread.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (ToolData.FXToolEffectOnTile != null) {
               if (chckPlane0.isSelected()) {
                  ToolData.FXToolEffectOnTile.planeflag = chckPlaneSpread.isSelected() ? 8 : 0;
               } else if (chckPlane1.isSelected()) {
                  ToolData.FXToolEffectOnTile.planeflag = chckPlaneSpread.isSelected() ? 9 : 1;
               } else if (chckPlane2.isSelected()) {
                  ToolData.FXToolEffectOnTile.planeflag = chckPlaneSpread.isSelected() ? 10 : 2;
               } else if (chckPlane3.isSelected()) {
                  ToolData.FXToolEffectOnTile.planeflag = chckPlaneSpread.isSelected() ? 11 : 3;
               }

               Class78.MAP_CHANGED = true;
               RSMapperClient.setFocusOnCanvas();
            }
         }
      });
      JTextField txt_height_title = new JTextField("Height");
      txt_height_title.setHorizontalAlignment(0);
      txt_height_title.setBounds(4, shiftY + 32 + 26, 100, 24);
      txt_height_title.setEditable(false);
      UIPanels.propertiesTabPanel.add(txt_height_title);
      this.propertyComponents.put("txt_height_title", txt_height_title);
      final JTextField txt_height = new JTextField("" + (ToolData.FXToolEffectOnTile.height >> 2));
      txt_height.setEditable(false);
      txt_height.setBackground(new Color(70, 70, 70));
      txt_height.setBounds(102, shiftY + 32 + 26, 70, 24);
      UIPanels.propertiesTabPanel.add(txt_height);
      this.propertyComponents.put("txt_fx_height", txt_height);
      this.addPropertyTextChangedListeners(txt_height, 1);
      JSlider heightSlider = new JSlider(0, 0, 400, ToolData.FXToolEffectOnTile.height >> 2);
      heightSlider.setBounds(176, shiftY + 32 + 26, 110, 22);
      heightSlider.setBorder(BorderFactory.createMatteBorder(0, -10, 0, -10, Color.black));
      heightSlider.setMajorTickSpacing(64);
      heightSlider.setMinorTickSpacing(32);
      heightSlider.setSnapToTicks(true);
      heightSlider.setPaintTicks(true);
      heightSlider.setPaintLabels(true);
      heightSlider.addChangeListener(new ChangeListener() {
         @Override
         public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            txt_height.setText("" + source.getValue());
         }
      });
      UIPanels.propertiesTabPanel.add(heightSlider);
      this.propertyComponents.put("txt_fx_height_slider", heightSlider);
      JTextField offsetX_title = new JTextField("Offset X");
      offsetX_title.setHorizontalAlignment(0);
      offsetX_title.setBounds(4, shiftY + 32 + 52, 100, 24);
      offsetX_title.setEditable(false);
      UIPanels.propertiesTabPanel.add(offsetX_title);
      this.propertyComponents.put("txt_fx_offsetx_title", offsetX_title);
      JTextField txt_offsetX = new JTextField("" + ToolData.FXToolEffectOnTile.offsetX);
      txt_offsetX.setBounds(102, shiftY + 32 + 52, 70, 24);
      UIPanels.propertiesTabPanel.add(txt_offsetX);
      this.propertyComponents.put("txt_fx_offsetx", txt_offsetX);
      this.addPropertyTextChangedListeners(txt_offsetX, 2);
      JButton shiftOffsetXLeft = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 32 + 52, 55, 24, 2, true
      );
      UIPanels.propertiesTabPanel.add(shiftOffsetXLeft);
      this.propertyComponents.put("decrement_offsetx", shiftOffsetXLeft);
      JButton shiftOffsetXRight = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 32 + 52, 55, 24, 2, false
      );
      UIPanels.propertiesTabPanel.add(shiftOffsetXRight);
      this.propertyComponents.put("increment_offsetx", shiftOffsetXRight);
      JTextField offsetY_title = new JTextField("Offset Y");
      offsetY_title.setHorizontalAlignment(0);
      offsetY_title.setBounds(4, shiftY + 32 + 52 + 26, 100, 24);
      offsetY_title.setEditable(false);
      UIPanels.propertiesTabPanel.add(offsetY_title);
      this.propertyComponents.put("txt_fx_offsety_title", offsetY_title);
      JTextField txt_offsetY = new JTextField("" + ToolData.FXToolEffectOnTile.offsetY);
      txt_offsetY.setBounds(102, shiftY + 32 + 52 + 26, 70, 24);
      UIPanels.propertiesTabPanel.add(txt_offsetY);
      this.propertyComponents.put("txt_fx_offsety", txt_offsetY);
      this.addPropertyTextChangedListeners(txt_offsetY, 3);
      JButton shiftOffsetYLeft = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 32 + 52 + 26, 55, 24, 3, true
      );
      UIPanels.propertiesTabPanel.add(shiftOffsetYLeft);
      this.propertyComponents.put("decrement_offsety", shiftOffsetYLeft);
      JButton shiftOffsetYRight = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 32 + 52 + 26, 55, 24, 3, false
      );
      UIPanels.propertiesTabPanel.add(shiftOffsetYRight);
      this.propertyComponents.put("increment_offsety", shiftOffsetYRight);
      JTextField txt_color_title = new JTextField("Color Index");
      txt_color_title.setHorizontalAlignment(0);
      txt_color_title.setBounds(4, shiftY + 32 + 52 + 26 + 26, 100, 24);
      txt_color_title.setEditable(false);
      UIPanels.propertiesTabPanel.add(txt_color_title);
      this.propertyComponents.put("txt_color_title", txt_color_title);
      final JTextField txt_fx_color = new JTextField("" + ToolData.FXToolEffectOnTile.colorIndex);
      txt_fx_color.setBounds(102, shiftY + 32 + 52 + 26 + 26, 38, 24);
      UIPanels.propertiesTabPanel.add(txt_fx_color);
      this.propertyComponents.put("txt_fx_color", txt_fx_color);
      this.addPropertyTextChangedListeners(txt_fx_color, 4);
      JButton findColor = new JButton("Find");
      findColor.setFont(new Font("", 0, 9));
      findColor.setForeground(Color.BLUE);
      findColor.setBounds(138, shiftY + 32 + 52 + 26 + 26, 34, 24);
      findColor.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            Color colorToShow = new Color(Class85.colors[ToolData.FXToolEffectOnTile.colorIndex]);
            Color color = JColorChooser.showDialog(null, "Choose a color", colorToShow);
            if (color != null) {
               int index = Class96.getColorFromInt(-71, color.getRGB());
               txt_fx_color.setText("" + index);
               if (RSMapperClient.editor.mapEditor.getEffectOnTile(RSMapperClient.editor.selectedTile) != null) {
                  RSMapperClient.editor.saveMapState(false);
                  ToolData.FXToolEffectOnTile.colorIndex = index;
                  RSMapperClient.editor.mapEditor.saveEffect(RSMapperClient.editor.selectedTile, ToolData.FXToolEffectOnTile, true);
               }
            }
         }
      });
      UIPanels.propertiesTabPanel.add(findColor);
      this.propertyComponents.put("txt_fx_findcolor", findColor);
      JButton shiftColorLeft = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 32 + 52 + 26 + 26, 55, 24, 4, true
      );
      UIPanels.propertiesTabPanel.add(shiftColorLeft);
      this.propertyComponents.put("decrement_color", shiftColorLeft);
      JButton shiftColorRight = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 32 + 52 + 26 + 26, 55, 24, 4, false
      );
      UIPanels.propertiesTabPanel.add(shiftColorRight);
      this.propertyComponents.put("increment_color", shiftColorRight);
      JTextField txt_flicker_title = new JTextField("Type (1)");
      txt_flicker_title.setHorizontalAlignment(0);
      txt_flicker_title.setBounds(4, shiftY + 32 + 52 + 52 + 26, 100, 24);
      txt_flicker_title.setEditable(false);
      UIPanels.propertiesTabPanel.add(txt_flicker_title);
      this.propertyComponents.put("txt_flicker_title", txt_flicker_title);
      JTextField txt_fx_flicker = new JTextField("" + ToolData.FXToolEffectOnTile.flickerType);
      txt_fx_flicker.setBounds(102, shiftY + 32 + 52 + 52 + 26, 70, 24);
      UIPanels.propertiesTabPanel.add(txt_fx_flicker);
      this.propertyComponents.put("txt_fx_flicker", txt_fx_flicker);
      this.addPropertyTextChangedListeners(txt_fx_flicker, 5);
      JButton shiftFlickerTypeLeft = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 32 + 52 + 52 + 26, 55, 24, 5, true
      );
      UIPanels.propertiesTabPanel.add(shiftFlickerTypeLeft);
      this.propertyComponents.put("decrement_flicker", shiftFlickerTypeLeft);
      JButton shiftFlickerTypeRight = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 32 + 52 + 52 + 26, 55, 24, 5, false
      );
      UIPanels.propertiesTabPanel.add(shiftFlickerTypeRight);
      this.propertyComponents.put("increment_flicker", shiftFlickerTypeRight);
      JTextField txt_flickerType2_title = new JTextField("Type (2)");
      txt_flickerType2_title.setHorizontalAlignment(0);
      txt_flickerType2_title.setBounds(4, shiftY + 32 + 104 + 52, 100, 24);
      txt_flickerType2_title.setEditable(false);
      UIPanels.propertiesTabPanel.add(txt_flickerType2_title);
      this.propertyComponents.put("txt_fx_flicker2_title", txt_flickerType2_title);
      JTextField txt_flickerType2 = new JTextField("" + ToolData.FXToolEffectOnTile.flickerType2);
      txt_flickerType2.setBounds(102, shiftY + 32 + 104 + 52, 70, 24);
      UIPanels.propertiesTabPanel.add(txt_flickerType2);
      this.propertyComponents.put("txt_fx_flicker2", txt_flickerType2);
      this.addPropertyTextChangedListeners(txt_flickerType2, 6);
      JButton shiftflickerType2Left = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 32 + 104 + 52, 55, 24, 6, true
      );
      UIPanels.propertiesTabPanel.add(shiftflickerType2Left);
      this.propertyComponents.put("decrement_flicker2", shiftflickerType2Left);
      JButton shiftflickerType2Right = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 32 + 104 + 52, 55, 24, 6, false
      );
      UIPanels.propertiesTabPanel.add(shiftflickerType2Right);
      this.propertyComponents.put("increment_flicker2", shiftflickerType2Right);
      JTextField txt_spread_title = new JTextField("Spread");
      txt_spread_title.setHorizontalAlignment(0);
      txt_spread_title.setBounds(4, shiftY + 32 + 104 + 52 + 26, 100, 24);
      txt_spread_title.setEditable(false);
      UIPanels.propertiesTabPanel.add(txt_spread_title);
      this.propertyComponents.put("txt_spread_title", txt_spread_title);
      JTextField txt_spread = new JTextField("" + ToolData.FXToolEffectOnTile.spread);
      txt_spread.setBounds(102, shiftY + 32 + 104 + 52 + 26, 70, 24);
      UIPanels.propertiesTabPanel.add(txt_spread);
      this.propertyComponents.put("txt_fx_spread", txt_spread);
      this.addPropertyTextChangedListeners(txt_spread, 7);
      JButton shiftSpreadLeft = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 32 + 104 + 52 + 26, 55, 24, 7, true
      );
      UIPanels.propertiesTabPanel.add(shiftSpreadLeft);
      this.propertyComponents.put("decrement_spread", shiftSpreadLeft);
      JButton shiftSpreadRight = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 32 + 104 + 52 + 26, 55, 24, 7, false
      );
      UIPanels.propertiesTabPanel.add(shiftSpreadRight);
      this.propertyComponents.put("increment_spread", shiftSpreadRight);
      JTextField coverageTitle = new JTextField();
      coverageTitle.setBounds(4, shiftY + 162 + 104 - 26, 285, 24);
      coverageTitle.setHorizontalAlignment(0);
      coverageTitle.setEditable(false);
      coverageTitle.setText("Coverage Based on Spread");
      coverageTitle.setFont(new Font("", 1, 14));
      UIPanels.propertiesTabPanel.add(coverageTitle);
      this.propertyComponents.put("coverage_title", coverageTitle);
      JTextField[] coverageTitles = new JTextField[15];
      JTextField[] txt_coverage = new JTextField[15];
      int column = 0;
      int row = 0;

      for(int i = 0; i < 15; ++i) {
         coverageTitles[i] = new JTextField();
         coverageTitles[i].setEditable(false);
         coverageTitles[i].setText("[" + i + "]");
         UIPanels.propertiesTabPanel.add(coverageTitles[i]);
         this.propertyComponents.put("coverageTitles_" + i, coverageTitles[i]);
         txt_coverage[i] = new JTextField();
         UIPanels.propertiesTabPanel.add(txt_coverage[i]);
         this.propertyComponents.put("txt_coverage_" + i, txt_coverage[i]);
         this.addCoverageTextFieldListener(txt_coverage[i], i);
         if (i < ToolData.FXToolEffectOnTile.coverage.length) {
            coverageTitles[i].setBounds(4 + 29 * row + 27 * row, shiftY + 214 + 52 + column * 26, 28, 24);
            txt_coverage[i].setBounds(coverageTitles[i].getX() + 28, shiftY + 214 + 52 + column * 26, 28, 24);
            txt_coverage[i].setText("" + ToolData.FXToolEffectOnTile.coverage[i]);
            if (++row == 5) {
               row = 0;
               ++column;
            }
         } else {
            coverageTitles[i].setBounds(0, 0, 0, 0);
            txt_coverage[i].setBounds(0, 0, 0, 0);
         }
      }

      JButton positionEffect = new JButton("Set Position");
      positionEffect.setBounds(6, shiftY + 400 - 19 - 30, 281, 26);
      positionEffect.setFont(new Font("Tahoma", 1, 16));
      positionEffect.setForeground(Color.ORANGE);
      positionEffect.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            FXTool.this.applyAction(ToolData.ActionValues.EFFECTS_POSITION.getValue());
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.propertiesTabPanel.add(positionEffect);
      this.propertyComponents.put("position_effect", positionEffect);
      JButton createEffect = new JButton("Create / Save Effect");
      createEffect.setBounds(6, shiftY + 400 - 19, 281, 26);
      createEffect.setFont(new Font("Tahoma", 1, 16));
      createEffect.setForeground(Color.GREEN);
      createEffect.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            RSMapperClient.editor.saveMapState(false);
            RSMapperClient.editor.mapEditor.saveEffect(RSMapperClient.editor.selectedTile, ToolData.FXToolEffectOnTile, true);
            FXTool.this.updateEffectsCountLabel();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.propertiesTabPanel.add(createEffect);
      this.propertyComponents.put("create_effect", createEffect);
      JButton deleteEffect = new JButton("Delete Effect");
      deleteEffect.setBounds(6, shiftY + 411, 281, 26);
      deleteEffect.setFont(new Font("Tahoma", 1, 16));
      deleteEffect.setForeground(Color.RED);
      deleteEffect.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            FXTool.this.applyAction(ToolData.ActionValues.EFFECTS_DELETE.getValue());
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.propertiesTabPanel.add(deleteEffect);
      this.propertyComponents.put("delete_effect", deleteEffect);
   }

   @Override
   public void setFields() {
      this.setEffect();
      int column = 0;
      int row = 0;

      for(int i = 0; i < 15; ++i) {
         JTextField coverageTitle = (JTextField)this.propertyComponents.get("coverageTitles_" + i) == null
            ? new JTextField()
            : (JTextField)this.propertyComponents.get("coverageTitles_" + i);
         coverageTitle.setText("[" + i + "]");
         JTextField txt_coverage = (JTextField)this.propertyComponents.get("txt_coverage_" + i) == null
            ? new JTextField()
            : (JTextField)this.propertyComponents.get("txt_coverage_" + i);
         this.addCoverageTextFieldListener(txt_coverage, i);
         if (i < ToolData.FXToolEffectOnTile.coverage.length) {
            coverageTitle.setBounds(4 + 29 * row + 27 * row, 292 + column * 26, 28, 24);
            txt_coverage.setBounds(coverageTitle.getX() + 28, 292 + column * 26, 28, 24);
            txt_coverage.setText("" + ToolData.FXToolEffectOnTile.coverage[i]);
            if (++row == 5) {
               row = 0;
               ++column;
            }
         } else {
            coverageTitle.setBounds(0, 0, 0, 0);
            txt_coverage.setBounds(0, 0, 0, 0);
         }

         UIPanels.propertiesTabPanel.remove(this.propertyComponents.get("coverageTitles_" + i));
         UIPanels.propertiesTabPanel.revalidate();
         UIPanels.propertiesTabPanel.add(coverageTitle);
         UIPanels.propertiesTabPanel.revalidate();
         this.propertyComponents.replace("coverageTitles_" + i, coverageTitle);
         UIPanels.propertyComponents.replace("coverageTitles_" + i, coverageTitle);
         UIPanels.propertiesTabPanel.remove(this.propertyComponents.get("txt_coverage_" + i));
         UIPanels.propertiesTabPanel.revalidate();
         UIPanels.propertiesTabPanel.add(txt_coverage);
         UIPanels.propertiesTabPanel.revalidate();
         this.propertyComponents.replace("txt_coverage_" + i, txt_coverage);
         UIPanels.propertyComponents.replace("txt_coverage_" + i, txt_coverage);
      }

      UIPanels.propertiesTabPanel.revalidate();
      UIPanels.propertiesTabPanel.repaint();
      if (RSMapperClient.editor != null
         && RSMapperClient.editor.mapEditor != null
         && RSMapperClient.editor.mapEditor.dataLoaded
         && RSMapperClient.editor.selectedTile != null
         && RSMapperClient.editor.selectedTile.getX() > 0
         && RSMapperClient.editor.selectedTile.getY() > 0) {
         RSMapperClient.editor.mapEditor.populateTable(RSMapperClient.editor.selectedTile);
      }

      this.updateEffectsCountLabel();
      super.setFields();
   }

   private void addCoverageTextFieldListener(final JTextField field, final int index) {
      field.getDocument().addDocumentListener(new DocumentListener() {
         @Override
         public void changedUpdate(DocumentEvent arg0) {
         }

         @Override
         public void insertUpdate(DocumentEvent arg0) {
            if (!field.getText().isEmpty()) {
               Runnable doChange = new Runnable() {
                  @Override
                  public void run() {
                     try {
                        int value = Integer.parseInt(field.getText());
                        if (value < 0) {
                           value = 0;
                        }

                        if (index < ToolData.FXToolEffectOnTile.coverage.length) {
                           ToolData.FXToolEffectOnTile.coverage[index] = value;
                        }
                     } catch (NumberFormatException var2) {
                     }
                  }
               };
               SwingUtilities.invokeLater(doChange);
            }
         }

         @Override
         public void removeUpdate(DocumentEvent arg0) {
            if (!field.getText().isEmpty()) {
               Runnable doChange = new Runnable() {
                  @Override
                  public void run() {
                     try {
                        int value = Integer.parseInt(field.getText());
                        if (value < 0) {
                           value = 0;
                        }

                        if (index < ToolData.FXToolEffectOnTile.coverage.length) {
                           ToolData.FXToolEffectOnTile.coverage[index] = value;
                        }
                     } catch (NumberFormatException var2) {
                     }
                  }
               };
               SwingUtilities.invokeLater(doChange);
            }
         }
      });
   }

   private void addPropertyTextChangedListeners(final JTextField field, final int type) {
      field.getDocument().addDocumentListener(new DocumentListener() {
         @Override
         public void changedUpdate(DocumentEvent arg0) {
         }

         @Override
         public void insertUpdate(DocumentEvent arg0) {
            if (!field.getText().isEmpty()) {
               Runnable doChange = new Runnable() {
                  @Override
                  public void run() {
                     try {
                        int value = Integer.parseInt(field.getText());
                        if (type == 0) {
                           ToolData.FXToolEffectOnTile.planeflag = (value & 7) > 0 && (value & 7) < 4 ? value : ToolData.FXToolEffectOnTile.planeflag;
                        } else if (type == 1) {
                           ToolData.FXToolEffectOnTile.height = value << 2;
                        } else if (type == 2) {
                           ToolData.FXToolEffectOnTile.offsetX = value <= 0 ? 0 : (value >= 512 ? 508 : value);
                        } else if (type == 3) {
                           ToolData.FXToolEffectOnTile.offsetY = value <= 0 ? 0 : (value >= 512 ? 508 : value);
                        } else if (type == 4) {
                           if (value < 0) {
                              value = 0;
                           } else if (Class85.colors != null && value >= Class85.colors.length) {
                              value = Class85.colors.length - 1;
                           }

                           ToolData.FXToolEffectOnTile.colorIndex = value;
                        } else if (type == 5) {
                           ToolData.FXToolEffectOnTile.flickerType = value;
                        } else if (type == 6) {
                           ToolData.FXToolEffectOnTile.flickerType2 = value;
                        } else if (type == 7) {
                           boolean changed = ToolData.FXToolEffectOnTile.spread != value;
                           if (changed) {
                              int[] coverage = ToolData.FXToolEffectOnTile.coverage;
                              int[] newCoverage = new int[2 * value + 1];

                              for(int i = 0; i < newCoverage.length; ++i) {
                                 if (value < 1 || value > 7) {
                                    value = value < 1 ? 1 : 7;
                                 }

                                 if (i < coverage.length) {
                                    newCoverage[i] = coverage[i];
                                 } else {
                                    newCoverage[i] = newCoverage.length;
                                 }
                              }

                              ToolData.FXToolEffectOnTile.spread = value;
                              ToolData.FXToolEffectOnTile.coverage = newCoverage;
                              FXTool.this.setFields();
                           }
                        }
                     } catch (NumberFormatException var6) {
                     }
                  }
               };
               SwingUtilities.invokeLater(doChange);
            }
         }

         @Override
         public void removeUpdate(DocumentEvent arg0) {
            if (!field.getText().isEmpty()) {
               Runnable doChange = new Runnable() {
                  @Override
                  public void run() {
                     try {
                        int value = Integer.parseInt(field.getText());
                        if (type == 0) {
                           ToolData.FXToolEffectOnTile.planeflag = (value & 7) > 0 && (value & 7) < 4 ? value : ToolData.FXToolEffectOnTile.planeflag;
                        } else if (type == 1) {
                           ToolData.FXToolEffectOnTile.height = value << 2;
                        } else if (type == 2) {
                           ToolData.FXToolEffectOnTile.offsetX = value <= 0 ? 0 : (value >= 512 ? 508 : value);
                        } else if (type == 3) {
                           ToolData.FXToolEffectOnTile.offsetY = value <= 0 ? 0 : (value >= 512 ? 508 : value);
                        } else if (type == 4) {
                           if (value < 0) {
                              value = 0;
                           } else if (Class85.colors != null && value >= Class85.colors.length) {
                              value = Class85.colors.length - 1;
                           }

                           ToolData.FXToolEffectOnTile.colorIndex = value;
                        } else if (type == 5) {
                           ToolData.FXToolEffectOnTile.flickerType = value;
                        } else if (type == 6) {
                           ToolData.FXToolEffectOnTile.flickerType2 = value;
                        } else if (type == 7) {
                           boolean changed = ToolData.FXToolEffectOnTile.spread != value;
                           if (changed) {
                              int[] coverage = ToolData.FXToolEffectOnTile.coverage;
                              int[] newCoverage = new int[2 * value + 1];

                              for(int i = 0; i < newCoverage.length; ++i) {
                                 if (value < 1 || value > 7) {
                                    value = value < 1 ? 1 : 7;
                                 }

                                 if (i < coverage.length) {
                                    newCoverage[i] = coverage[i];
                                 } else {
                                    newCoverage[i] = newCoverage.length;
                                 }
                              }

                              ToolData.FXToolEffectOnTile.spread = value;
                              ToolData.FXToolEffectOnTile.coverage = newCoverage;
                              FXTool.this.setFields();
                           }
                        }
                     } catch (NumberFormatException var6) {
                     }
                  }
               };
               SwingUtilities.invokeLater(doChange);
            }
         }
      });
   }

   private JButton makeShiftPropertyButton(
      String text, String tooltip, ImageIcon icon, boolean rightSideIcon, int x, int y, int width, int height, final int type, final boolean reduce
   ) {
      JButton button = new JButton(text, icon);
      if (rightSideIcon) {
         button.setHorizontalTextPosition(10);
      }

      if (tooltip != null) {
         button.setToolTipText(tooltip);
      }

      button.setBounds(x, y, width, height);
      button.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               if (type >= 0 && type <= 7) {
                  RSMapperClient.editor.saveMapState(false);
                  switch(type) {
                     case 0:
                        int newPlaneFlag = ToolData.FXToolEffectOnTile.planeflag + (reduce ? -1 : 1);
                        if (newPlaneFlag < 0) {
                           newPlaneFlag = 0;
                        } else if ((newPlaneFlag & 7) > 3) {
                           newPlaneFlag = 3;
                        }

                        ToolData.FXToolEffectOnTile.planeflag = newPlaneFlag;
                        RSMapperClient.editor.mapEditor.saveEffect(RSMapperClient.editor.selectedTile, ToolData.FXToolEffectOnTile, true);
                        ((JTextField)FXTool.this.propertyComponents.get("txt_planeflag")).setText("" + ToolData.FXToolEffectOnTile.planeflag);
                        break;
                     case 1:
                        ToolData.FXToolEffectOnTile.height += reduce ? -22 : 22;
                        RSMapperClient.editor.mapEditor.saveEffect(RSMapperClient.editor.selectedTile, ToolData.FXToolEffectOnTile, true);
                        ((JTextField)FXTool.this.propertyComponents.get("txt_fx_height")).setText("" + (ToolData.FXToolEffectOnTile.height >> 2));
                        break;
                     case 2:
                        ToolData.FXToolEffectOnTile.offsetX += reduce ? -4 : 4;
                        if (ToolData.FXToolEffectOnTile.offsetX <= 0 || ToolData.FXToolEffectOnTile.offsetX >= 512) {
                           ToolData.FXToolEffectOnTile.offsetX = ToolData.FXToolEffectOnTile.offsetX <= 0 ? 0 : 508;
                        }

                        RSMapperClient.editor.mapEditor.saveEffect(RSMapperClient.editor.selectedTile, ToolData.FXToolEffectOnTile, true);
                        ((JTextField)FXTool.this.propertyComponents.get("txt_fx_offsetx")).setText("" + ToolData.FXToolEffectOnTile.offsetX);
                        break;
                     case 3:
                        ToolData.FXToolEffectOnTile.offsetY += reduce ? -4 : 4;
                        if (ToolData.FXToolEffectOnTile.offsetY <= 0 || ToolData.FXToolEffectOnTile.offsetY >= 512) {
                           ToolData.FXToolEffectOnTile.offsetY = ToolData.FXToolEffectOnTile.offsetY <= 0 ? 0 : 508;
                        }

                        RSMapperClient.editor.mapEditor.saveEffect(RSMapperClient.editor.selectedTile, ToolData.FXToolEffectOnTile, true);
                        ((JTextField)FXTool.this.propertyComponents.get("txt_fx_offsety")).setText("" + ToolData.FXToolEffectOnTile.offsetY);
                        break;
                     case 4:
                        ToolData.FXToolEffectOnTile.colorIndex += reduce ? -5 : 5;
                        if (ToolData.FXToolEffectOnTile.colorIndex < 0) {
                           ToolData.FXToolEffectOnTile.colorIndex = 0;
                        } else if (Class85.colors != null && ToolData.FXToolEffectOnTile.colorIndex >= Class85.colors.length) {
                           ToolData.FXToolEffectOnTile.colorIndex = Class85.colors.length - 1;
                        }

                        RSMapperClient.editor.mapEditor.saveEffect(RSMapperClient.editor.selectedTile, ToolData.FXToolEffectOnTile, true);
                        ((JTextField)FXTool.this.propertyComponents.get("txt_fx_color")).setText("" + ToolData.FXToolEffectOnTile.colorIndex);
                        break;
                     case 5:
                        ToolData.FXToolEffectOnTile.flickerType += reduce ? -1 : 1;
                        RSMapperClient.editor.mapEditor.saveEffect(RSMapperClient.editor.selectedTile, ToolData.FXToolEffectOnTile, true);
                        ((JTextField)FXTool.this.propertyComponents.get("txt_fx_flicker")).setText("" + ToolData.FXToolEffectOnTile.flickerType);
                        break;
                     case 6:
                        ToolData.FXToolEffectOnTile.flickerType2 += reduce ? -1 : 1;
                        RSMapperClient.editor.mapEditor.saveEffect(RSMapperClient.editor.selectedTile, ToolData.FXToolEffectOnTile, true);
                        ((JTextField)FXTool.this.propertyComponents.get("txt_fx_flicker2")).setText("" + ToolData.FXToolEffectOnTile.flickerType2);
                        break;
                     case 7:
                        ToolData.FXToolEffectOnTile.spread += reduce ? -1 : 1;
                        if (ToolData.FXToolEffectOnTile.spread < 1 || ToolData.FXToolEffectOnTile.spread > 7) {
                           ToolData.FXToolEffectOnTile.spread = ToolData.FXToolEffectOnTile.spread < 1 ? 1 : 7;
                        }

                        int[] newCoverage = new int[2 * ToolData.FXToolEffectOnTile.spread + 1];

                        for(int i = 0; i < newCoverage.length; ++i) {
                           newCoverage[i] = newCoverage.length;
                        }

                        ToolData.FXToolEffectOnTile.coverage = newCoverage;
                        RSMapperClient.editor.mapEditor.saveEffect(RSMapperClient.editor.selectedTile, ToolData.FXToolEffectOnTile, false);
                        ((JTextField)FXTool.this.propertyComponents.get("txt_fx_spread")).setText("" + ToolData.FXToolEffectOnTile.spread);
                        FXTool.this.setFields();
                        Class78.MAP_CHANGED = true;
                  }
               }
            } catch (Exception var5) {
               var5.printStackTrace();
            }
         }
      });
      return button;
   }

   public void updateEffectsCountLabel() {
      if (this.propertyComponents.get("effects_in_region") != null) {
         String text = ((JTextField)this.propertyComponents.get("effects_in_region")).getText().toString().split(":")[0].trim();
         if (RSMapperClient.editor.mapEditor.effects != null && RSMapperClient.editor.mapEditor.effects.size() > 0) {
            ((JTextField)this.propertyComponents.get("effects_in_region")).setText(text + ": " + RSMapperClient.editor.mapEditor.effects.size());
         } else {
            ((JTextField)this.propertyComponents.get("effects_in_region")).setText(text + ": 0");
         }
      }
   }
}
