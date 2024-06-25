import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class ShapeTool extends Tool {
   public java.awt.Point point1;
   public java.awt.Point point2;
   public int shape = -1;
   public int rotation = 0;
   boolean reversed = false;

   public ShapeTool() {
      this.doubleClickActionValue = ToolData.shapeDoubleClickAction;
      this.propertyComponents = new ConcurrentHashMap<>();
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
      return new String[]{
         "<col=edb75a>Apply</col>", "<col=17bd17>Flip</col>", "<col=2a74eb>Copy</col>", "<col=db0d30>Remove</col>", "<col=db0d30>Clear</col>"
      };
   }

   @Override
   public int[] getActionValues() {
      return new int[]{
         ToolData.ActionValues.SHAPE_APPLY.getValue(),
         ToolData.ActionValues.SHAPE_REVERSE.getValue(),
         ToolData.ActionValues.SHAPE_COPY.getValue(),
         ToolData.ActionValues.SHAPE_REMOVE.getValue(),
         ToolData.ActionValues.SHAPE_CLEAR_POINTS.getValue()
      };
   }

   @Override
   public void setDoubleClickAction(int actionValue, boolean forProperties, boolean storeValue) {
      this.doubleClickActionValue[forProperties ? 0 : 1] = actionValue;
      if (storeValue) {
         ToolData.shapeDoubleClickAction[forProperties ? 0 : 1] = actionValue;
      }
   }

   @Override
   public BrushType[] getAllowedBrushes() {
      return new BrushType[]{BrushType.SQUARE};
   }

   @Override
   public void applyAction(int actionValue) {
      if (actionValue == ToolData.ActionValues.SHAPE_APPLY.getValue()) {
         if (this.bothPointsPlaced() && this.shape != -1) {
            RSMapperClient.editor.saveMapState(false);
            if (ToolData.shapeUseOverlay) {
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.OVERLAY, ToolData.shapeOverlay, false, true, false);
            }

            if (ToolData.shapeUseUnderlay) {
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.UNDERLAY, ToolData.shapeUnderlay, false, true, false);
            }

            RSMapperClient.editor
               .mapEditor
               .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.SHAPE, this.shape, false, false, false);
            RSMapperClient.editor
               .mapEditor
               .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.ROTATION, this.rotation, false, true, false);
         } else {
            System.out.println("Both points must be placed");
         }
      } else if (actionValue == ToolData.ActionValues.SHAPE_REVERSE.getValue()) {
         if (this.bothPointsPlaced() && this.shape != -1) {
            RSMapperClient.editor.saveMapState(false);
            this.reversed = !this.reversed;
            this.shape = Shape.getShapeFromPoints(this.point1, this.point2, this.reversed).getShapeValue();
            this.rotation = Shape.getRotationFromPoints(this.point1, this.point2, this.reversed);
            RSMapperClient.editor
               .mapEditor
               .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.SHAPE, this.shape, false, false, false);
            RSMapperClient.editor
               .mapEditor
               .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.ROTATION, this.rotation, false, true, false);
         } else {
            System.out.println("Both points must be placed");
         }
      } else if (actionValue == ToolData.ActionValues.SHAPE_COPY.getValue()) {
         if (RSMapperClient.editor.selectedTile != null) {
            int shapeOnTile = RSMapperClient.editor.mapEditor.getValueFromTile(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.SHAPE, false);
            if (shapeOnTile > 0 && shapeOnTile < 12) {
               int rotationOnTile = RSMapperClient.editor
                  .mapEditor
                  .getValueFromTile(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.ROTATION, false);
               java.awt.Point[] shapePoints = Shape.getPointsFromShapeAndRotation(shapeOnTile, rotationOnTile);
               this.point1 = shapePoints[0];
               this.point2 = shapePoints[1];
               this.shape = shapeOnTile;
            } else {
               this.point1 = null;
               this.point2 = null;
               this.shape = -1;
            }
         }
      } else if (actionValue == ToolData.ActionValues.SHAPE_REMOVE.getValue()) {
         RSMapperClient.editor.saveMapState(false);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.SHAPE, 0, false, false, false);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.ROTATION, 0, false, false, false);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.SHAPE, 0, true, false, false);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.ROTATION, 0, true, true, false);
         if (ToolData.shapeUseOverlay) {
            RSMapperClient.editor
               .mapEditor
               .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.OVERLAY, ToolData.shapeOverlay, false, true, false);
         }

         if (ToolData.shapeUseUnderlay) {
            RSMapperClient.editor
               .mapEditor
               .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.UNDERLAY, ToolData.shapeUnderlay, false, true, false);
         }
      } else if (actionValue == ToolData.ActionValues.SHAPE_CLEAR_POINTS.getValue()) {
         this.point1 = null;
         this.point2 = null;
         this.shape = -1;
      }
   }

   @Override
   public void handleTileHover(int localX, int localY) {
      super.handleTileHover(localX, localY);
      int playerPlane = Class295.myPlayer.plane;
      if (ToolData.shapeShowOnHover) {
         WorldTile hoveredTile = new WorldTile(localX, localY, playerPlane, true);

         for(WorldTile t : RSMapperClient.editor.brush.getTilesBasedOnBrushAndSize(hoveredTile)) {
            if (t.getLocalX() >= 0 && t.getLocalX() < 104 && t.getLocalY() >= 0 && t.getLocalY() < 104) {
               int shapeOnTile = RSMapperClient.editor.mapEditor.getValueFromTile(t, MapEditor.PropertyType.SHAPE, false);
               if (shapeOnTile > 0 && shapeOnTile < 12) {
                  int rotationOnTile = RSMapperClient.editor.mapEditor.getValueFromTile(t, MapEditor.PropertyType.ROTATION, false);
                  java.awt.Point[] points = Shape.getPointsFromShapeAndRotation(shapeOnTile, rotationOnTile);
                  if (points != null) {
                     r.createShapeMarker(
                        points[0].x,
                        points[0].y,
                        points[1].x,
                        points[1].y,
                        true,
                        t.getLocalX(),
                        t.getLocalY(),
                        playerPlane,
                        0,
                        RSMapperClient.editor.selectedTile.equals(t)
                           ? RSMapperClient.settings.selectedOverlayColor
                           : RSMapperClient.settings.hoverOverlayColor,
                        0
                     );
                  }
               }
            }
         }
      }

      if (this.point1 != null && this.point2 != null) {
         if (this.point1 != null && this.point2 != null) {
            if (this.point1.x == this.point2.x && this.point1.y == this.point2.y
               || this.point1.x == 1 && this.point2.x == 1 && this.point1.y == 1 && this.point2.y == 1) {
               return;
            }

            r.createShapeMarker(this.point1.x, this.point1.y, this.point2.x, this.point2.y, true, localX, localY, playerPlane, 0, 573195, 1);
         }
      } else {
         if (this.point2 != null && this.point1 == null) {
            this.point1 = this.point2;
            this.point2 = null;
         }

         if (this.point1 != null) {
            java.awt.Point pointOnTile = Class93_Sub2.mousePointOnTile;
            if (pointOnTile.x == this.point1.x && pointOnTile.y == this.point1.y) {
               return;
            }

            r.createShapeMarker(this.point1.x, this.point1.y, pointOnTile.x, pointOnTile.y, true, localX, localY, playerPlane, 0, 573195, 0);
         }
      }
   }

   @Override
   public boolean handleTileClick(int localX, int localY, int plane, int actionValue) {
      super.handleTileClick(localX, localY, plane, actionValue);
      if (actionValue == 1) {
         boolean pointHandled = false;
         if (actionValue == ToolData.ActionValues.SHAPE_REMOVE.getValue() || actionValue == ToolData.ActionValues.SHAPE_CLEAR_POINTS.getValue()) {
            this.applyAction(actionValue);
            return true;
         }

         if (Class93_Sub2.mousePointOnTile.x == 1 && Class93_Sub2.mousePointOnTile.y == 1) {
            System.out.println("Handle center click functionality");
            if (this.point1 != null
               && this.point2 != null
               && (this.point1.x != this.point2.x || this.point1.y != this.point2.y)
               && (this.point1.x != 1 || this.point1.y != 1)
               && (this.point2.x != 1 || this.point2.y != 1)) {
               Shape shape = Shape.getShapeFromPoints(this.point1, this.point2, this.reversed);
               if (shape != null) {
                  this.rotation = Shape.getRotationFromPoints(this.point1, this.point2, this.reversed);
                  this.shape = shape.getShapeValue();
                  this.applyAction(ToolData.ActionValues.SHAPE_APPLY.getValue());
               }
            }
         } else {
            if (this.point1 != null && this.point1.equals(Class93_Sub2.mousePointOnTile)) {
               this.point1 = null;
               pointHandled = true;
            }

            if (!pointHandled && this.point2 != null && this.point2.equals(Class93_Sub2.mousePointOnTile)) {
               this.point2 = null;
               pointHandled = true;
            }

            if (!pointHandled) {
               if (this.point1 == null) {
                  this.point1 = Class93_Sub2.mousePointOnTile;
               } else if (this.point2 == null) {
                  this.point2 = Class93_Sub2.mousePointOnTile;
               }
            }

            if (this.point1 != null
               && this.point2 != null
               && (this.point1.x != this.point2.x || this.point1.y != this.point2.y)
               && (this.point1.x != 1 || this.point1.y != 1)
               && (this.point2.x != 1 || this.point2.y != 1)) {
               Shape shape = Shape.getShapeFromPoints(this.point1, this.point2, this.reversed);
               if (shape != null) {
                  this.rotation = Shape.getRotationFromPoints(this.point1, this.point2, this.reversed);
                  this.shape = shape.getShapeValue();
                  this.applyAction(ToolData.ActionValues.SHAPE_APPLY.getValue());
               } else {
                  System.out.println("Unhandled shape");
                  this.point1 = null;
                  this.point2 = null;
               }
            }
         }
      }

      return true;
   }

   @Override
   public void setupUI() {
      int shiftY = 0;
      JTextField propertiesTitle = new JTextField();
      propertiesTitle.setBounds(4, 4, 285, 24);
      propertiesTitle.setHorizontalAlignment(0);
      propertiesTitle.setEditable(false);
      propertiesTitle.setText("SHAPE SETTINGS");
      propertiesTitle.setFont(new Font("", 1, 16));
      UIPanels.propertiesTabPanel.add(propertiesTitle);
      this.propertyComponents.put("properties_title", propertiesTitle);
      final JCheckBox applyOverlay = new JCheckBox("", ToolData.shapeUseOverlay);
      applyOverlay.setBounds(4, shiftY + 34, 30, 24);
      final JTextField txt_overlay_title = new JTextField("OVERLAY");
      txt_overlay_title.setHorizontalAlignment(0);
      txt_overlay_title.setBounds(30, shiftY + 34, 73, 24);
      txt_overlay_title.setEditable(false);
      txt_overlay_title.setEnabled(ToolData.shapeUseOverlay);
      UIPanels.propertiesTabPanel.add(txt_overlay_title);
      this.propertyComponents.put("txt_overlay_title", txt_overlay_title);
      final JTextField txt_overlay = new JTextField("" + ToolData.shapeOverlay);
      txt_overlay.setBounds(102, shiftY + 34, 70, 24);
      txt_overlay.setEnabled(ToolData.shapeUseOverlay);
      UIPanels.propertiesTabPanel.add(txt_overlay);
      this.propertyComponents.put("txt_overlay", txt_overlay);
      this.addPropertyTextChangedListeners(txt_overlay, 0);
      JButton shiftOverlayLeft = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 34, 55, 24, 0, true
      );
      UIPanels.propertiesTabPanel.add(shiftOverlayLeft);
      this.propertyComponents.put("decrement_overlay", shiftOverlayLeft);
      JButton shiftOverlayRight = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 34, 55, 24, 0, false
      );
      UIPanels.propertiesTabPanel.add(shiftOverlayRight);
      this.propertyComponents.put("increment_overlay", shiftOverlayRight);
      applyOverlay.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.shapeUseOverlay = applyOverlay.isSelected();
            txt_overlay_title.setEnabled(applyOverlay.isSelected());
            txt_overlay.setEnabled(applyOverlay.isSelected());
         }
      });
      UIPanels.propertiesTabPanel.add(applyOverlay);
      this.propertyComponents.put("apply_overlay", applyOverlay);
      shiftY += 32;
      final JCheckBox applyUnderlay = new JCheckBox("", ToolData.shapeUseUnderlay);
      applyUnderlay.setBounds(4, shiftY + 32, 30, 24);
      final JTextField txt_underlay_title = new JTextField("UNDERLAY");
      txt_underlay_title.setHorizontalAlignment(0);
      txt_underlay_title.setBounds(30, shiftY + 32, 73, 24);
      txt_underlay_title.setEditable(false);
      txt_underlay_title.setEnabled(ToolData.shapeUseUnderlay);
      UIPanels.propertiesTabPanel.add(txt_underlay_title);
      this.propertyComponents.put("txt_underlay_title", txt_underlay_title);
      final JTextField txt_underlay = new JTextField("" + ToolData.shapeUnderlay);
      txt_underlay.setBounds(102, shiftY + 32, 70, 24);
      txt_underlay.setEnabled(ToolData.shapeUseUnderlay);
      UIPanels.propertiesTabPanel.add(txt_underlay);
      this.propertyComponents.put("txt_underlay", txt_underlay);
      this.addPropertyTextChangedListeners(txt_underlay, 1);
      JButton shiftUnderlayLeft = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 32, 55, 24, 1, true
      );
      UIPanels.propertiesTabPanel.add(shiftUnderlayLeft);
      this.propertyComponents.put("decrement_underlay", shiftUnderlayLeft);
      JButton shiftUnderlayRight = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 32, 55, 24, 1, false
      );
      UIPanels.propertiesTabPanel.add(shiftUnderlayRight);
      this.propertyComponents.put("increment_underlay", shiftUnderlayRight);
      applyUnderlay.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.shapeUseUnderlay = applyUnderlay.isSelected();
            txt_underlay_title.setEnabled(applyUnderlay.isSelected());
            txt_underlay.setEnabled(applyUnderlay.isSelected());
         }
      });
      UIPanels.propertiesTabPanel.add(applyUnderlay);
      this.propertyComponents.put("apply_underlay", applyUnderlay);
      final JCheckBox showShapeOnTile = new JCheckBox("Show Hovered Shape", ToolData.shapeShowOnHover);
      showShapeOnTile.setBounds(4, shiftY + 64, 150, 24);
      showShapeOnTile.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.shapeShowOnHover = showShapeOnTile.isSelected();
         }
      });
      UIPanels.propertiesTabPanel.add(showShapeOnTile);
      this.propertyComponents.put("show_hovered_shape", showShapeOnTile);
      JButton apply = new JButton("Apply Shape");
      apply.setBounds(6, shiftY + 32 + 24 + 45, 281, 26);
      apply.setFont(new Font("Tahoma", 1, 16));
      apply.setForeground(Color.GREEN);
      apply.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ShapeTool.this.applyAction(ToolData.ActionValues.SHAPE_APPLY.getValue());
         }
      });
      UIPanels.propertiesTabPanel.add(apply);
      this.propertyComponents.put("apply_shape", apply);
      JButton clearPoints = new JButton("Clear Selected Points");
      clearPoints.setBounds(6, shiftY + 32 + 24 + 45 + 30, 281, 26);
      clearPoints.setFont(new Font("Tahoma", 1, 16));
      clearPoints.setForeground(Color.RED);
      clearPoints.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ShapeTool.this.applyAction(ToolData.ActionValues.SHAPE_CLEAR_POINTS.getValue());
         }
      });
      UIPanels.propertiesTabPanel.add(clearPoints);
      this.propertyComponents.put("clear_points", clearPoints);
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
                           ToolData.shapeOverlay = value;
                        } else if (type == 1) {
                           ToolData.shapeUnderlay = value;
                        }
                     } catch (NumberFormatException var2) {
                     }
                  }
               };
               SwingUtilities.invokeLater(doChange);
            } else if (type == 0) {
               ToolData.shapeOverlay = 0;
            } else if (type == 1) {
               ToolData.shapeUnderlay = 0;
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
                           ToolData.shapeOverlay = value;
                        } else if (type == 1) {
                           ToolData.shapeUnderlay = value;
                        }
                     } catch (NumberFormatException var2) {
                     }
                  }
               };
               SwingUtilities.invokeLater(doChange);
            } else if (type == 0) {
               ToolData.shapeOverlay = 0;
            } else if (type == 1) {
               ToolData.shapeUnderlay = 0;
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
               switch(type) {
                  case 0:
                     if (ToolData.shapeUseOverlay) {
                        ToolData.shapeOverlay += reduce ? -1 : 1;
                        if (ShapeTool.this.bothPointsPlaced()) {
                           ShapeTool.this.applyAction(ToolData.ActionValues.SHAPE_APPLY.getValue());
                        }

                        ((JTextField)ShapeTool.this.propertyComponents.get("txt_overlay")).setText("" + ToolData.shapeOverlay);
                     }
                     break;
                  case 1:
                     if (ToolData.shapeUseUnderlay) {
                        ToolData.shapeUnderlay += reduce ? -1 : 1;
                        if (ShapeTool.this.bothPointsPlaced()) {
                           ShapeTool.this.applyAction(ToolData.ActionValues.SHAPE_APPLY.getValue());
                        }

                        ((JTextField)ShapeTool.this.propertyComponents.get("txt_underlay")).setText("" + ToolData.shapeUnderlay);
                     }
               }
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }
      });
      return button;
   }
}
