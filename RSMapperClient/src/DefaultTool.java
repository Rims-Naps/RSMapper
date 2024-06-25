import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class DefaultTool extends Tool {
   public DefaultTool() {
      this.doubleClickActionValue = RSMapperClient.editor != null && ToolData.defaultDoubleClickAction != null
         ? ToolData.defaultDoubleClickAction
         : new int[]{ToolData.ActionValues.SINGLE_COPY.getValue(), ToolData.ActionValues.SINGLE_SPAWN.getValue()};
      this.propertyComponents = new ConcurrentHashMap<>();
      this.objectComponents = new ConcurrentHashMap<>();
   }

   @Override
   public EditorType getType() {
      return EditorType.BOTH;
   }

   @Override
   public String[] getActionText() {
      EditorType selectedType = RSMapperClient.editor.editing;
      if (selectedType == EditorType.PROPERTIES) {
         return new String[]{"<col=2a74eb>Copy</col>", "<col=17bd17>Paste</col>"};
      } else {
         return selectedType == EditorType.OBJECTS
            ? new String[]{"<col=10de3c>Spawn</col>", "<col=db0d30>Remove</col>", "<col=2a74eb>Copy</col>", "<col=17bd17>Paste</col>"}
            : null;
      }
   }

   @Override
   public int[] getActionValues() {
      EditorType selectedType = RSMapperClient.editor.editing;
      if (selectedType == EditorType.PROPERTIES) {
         return new int[]{ToolData.ActionValues.SINGLE_COPY.getValue(), ToolData.ActionValues.SINGLE_PASTE.getValue()};
      } else {
         return selectedType == EditorType.OBJECTS
            ? new int[]{
               ToolData.ActionValues.SINGLE_SPAWN.getValue(),
               ToolData.ActionValues.SINGLE_REMOVE.getValue(),
               ToolData.ActionValues.SINGLE_OBJ_COPY.getValue(),
               ToolData.ActionValues.SINGLE_OBJ_PASTE.getValue()
            }
            : null;
      }
   }

   @Override
   public void setDoubleClickAction(int actionValue, boolean forProperties, boolean storeValue) {
      this.doubleClickActionValue[forProperties ? 0 : 1] = actionValue;
      if (storeValue) {
         ToolData.defaultDoubleClickAction[forProperties ? 0 : 1] = actionValue;
      }
   }

   @Override
   public BrushType[] getAllowedBrushes() {
      return new BrushType[]{BrushType.SQUARE, BrushType.RHOMBUS, BrushType.CIRCLE, BrushType.LINE_X, BrushType.LINE_Y};
   }

   @Override
   public void applyAction(int actionValue) {
      WorldTile tile = RSMapperClient.editor.selectedTile;
      if (actionValue == ToolData.ActionValues.SINGLE_COPY.getValue()) {
         ToolData.copiedProperties[0][0] = RSMapperClient.editor.mapEditor.getValueFromTile(tile, MapEditor.PropertyType.HEIGHT, false);
         ToolData.copiedProperties[0][1] = RSMapperClient.editor.mapEditor.getValueFromTile(tile, MapEditor.PropertyType.TILE_FLAG, false);
         ToolData.copiedProperties[0][2] = RSMapperClient.editor.mapEditor.getValueFromTile(tile, MapEditor.PropertyType.OVERLAY, false);
         ToolData.copiedProperties[0][3] = RSMapperClient.editor.mapEditor.getValueFromTile(tile, MapEditor.PropertyType.UNDERLAY, false);
         ToolData.copiedProperties[0][4] = RSMapperClient.editor.mapEditor.getValueFromTile(tile, MapEditor.PropertyType.SHAPE, false);
         ToolData.copiedProperties[0][5] = RSMapperClient.editor.mapEditor.getValueFromTile(tile, MapEditor.PropertyType.ROTATION, false);
         ToolData.copiedProperties[1][0] = RSMapperClient.editor.mapEditor.getValueFromTile(tile, MapEditor.PropertyType.HEIGHT, true);
         ToolData.copiedProperties[1][1] = RSMapperClient.editor.mapEditor.getValueFromTile(tile, MapEditor.PropertyType.OVERLAY, true);
         ToolData.copiedProperties[1][2] = RSMapperClient.editor.mapEditor.getValueFromTile(tile, MapEditor.PropertyType.UNDERLAY, true);
         ToolData.copiedProperties[1][3] = RSMapperClient.editor.mapEditor.getValueFromTile(tile, MapEditor.PropertyType.SHAPE, true);
         ToolData.copiedProperties[1][4] = RSMapperClient.editor.mapEditor.getValueFromTile(tile, MapEditor.PropertyType.ROTATION, true);
      } else if (actionValue == ToolData.ActionValues.SINGLE_PASTE.getValue()) {
         RSMapperClient.editor.saveMapState(false);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(tile, MapEditor.PropertyType.HEIGHT, ToolData.copiedProperties[0][0], false, false, true);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(tile, MapEditor.PropertyType.TILE_FLAG, ToolData.copiedProperties[0][1], false, false, true);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(tile, MapEditor.PropertyType.OVERLAY, ToolData.copiedProperties[0][2], false, false, true);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(tile, MapEditor.PropertyType.UNDERLAY, ToolData.copiedProperties[0][3], false, false, true);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(tile, MapEditor.PropertyType.SHAPE, ToolData.copiedProperties[0][4], false, false, true);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(tile, MapEditor.PropertyType.ROTATION, ToolData.copiedProperties[0][5], false, false, true);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(tile, MapEditor.PropertyType.HEIGHT, ToolData.copiedProperties[1][0], true, false, true);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(tile, MapEditor.PropertyType.OVERLAY, ToolData.copiedProperties[1][1], true, false, true);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(tile, MapEditor.PropertyType.UNDERLAY, ToolData.copiedProperties[1][2], true, false, true);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(tile, MapEditor.PropertyType.SHAPE, ToolData.copiedProperties[1][3], true, false, true);
         RSMapperClient.editor.mapEditor.saveTileWithNewProperty(tile, MapEditor.PropertyType.ROTATION, ToolData.copiedProperties[1][4], true, false, true);
         Class78.MAP_CHANGED = true;
      } else if (actionValue == ToolData.ActionValues.SINGLE_SPAWN.getValue()) {
         RSMapperClient.editor.saveMapState(false);
         int rotation = ToolData.defaultObjectRotation;
         if (ToolData.defaultObjectRandomizeRotation) {
            rotation = new Random().nextInt(4);
         }

         RSMapperClient.editor
            .objectEditor
            .placeObject(tile, ToolData.defaultObjectId, (int) ToolData.defaultObjectType, rotation, ToolData.defaultSpawnUnderland, true); // here is   line 112 where they mentioned error is located
      } else if (actionValue == ToolData.ActionValues.SINGLE_REMOVE.getValue()) {
         RSMapperClient.editor.saveMapState(false);
         boolean delete = ToolData.defaultObjectRemoveAll;
         if (delete) {
            int[][] objects = RSMapperClient.editor
               .objectEditor
               .getObjectsOnTile(new WorldTile(tile.getX(), tile.getY(), tile.getPlane(), false), ToolData.defaultSpawnUnderland);

            for(int c = 0; c < 4; ++c) {
               if (objects[c][1] >= 0) {
                  RSMapperClient.editor
                     .objectEditor
                     .removeObject(new WorldTile(tile.getX(), tile.getY(), tile.getPlane(), false), objects[c][1], ToolData.defaultSpawnUnderland, false);
               }
            }
         } else {
            RSMapperClient.editor.objectEditor.removeObject(tile, ToolData.defaultObjectType, ToolData.defaultSpawnUnderland, false);
         }

         RSMapperClient.editor.objectEditor.populateTable(RSMapperClient.editor.selectedTile);
      } else if (actionValue == ToolData.ActionValues.SINGLE_OBJ_COPY.getValue()) {
         boolean abovePlanes = ToolData.defaultObjectCopyAbovePlanes;
         boolean delete = ToolData.defaultObjectDeleteOnCopy;
         if (delete) {
            RSMapperClient.editor.saveMapState(false);
         }

         for(int p = 0; p < (abovePlanes ? 4 : 1); ++p) {
            ToolData.defaultCopiedObjects[p] = RSMapperClient.editor
               .objectEditor
               .getObjectsOnTile(new WorldTile(tile.getX(), tile.getY(), tile.getPlane() + p, false), false);
            if (delete) {
               for(int c = 0; c < 4; ++c) {
                  if (ToolData.defaultCopiedObjects[p][c][0] > 0 && ToolData.defaultCopiedObjects[p][c][1] >= 0) {
                     RSMapperClient.editor
                        .objectEditor
                        .removeObject(
                           new WorldTile(tile.getX(), tile.getY(), tile.getPlane() + p, false), ToolData.defaultCopiedObjects[p][c][1], false, false
                        );
                  }
               }
            }
         }

         RSMapperClient.editor.objectEditor.populateTable(RSMapperClient.editor.selectedTile);
      } else if (actionValue == ToolData.ActionValues.SINGLE_OBJ_PASTE.getValue()) {
         RSMapperClient.editor.saveMapState(false);
         boolean allPlanes = ToolData.defaultObjectCopyAbovePlanes;

         for(int p = 0; p < (allPlanes ? 4 : 1); ++p) {
            for(int c = 0; c < 4; ++c) {
               if (ToolData.defaultCopiedObjects[p][c][0] > 0 && ToolData.defaultCopiedObjects[p][c][1] >= 0) {
                  RSMapperClient.editor
                     .objectEditor
                     .placeObject(
                        new WorldTile(tile.getX(), tile.getY(), tile.getPlane() + p, false),
                        ToolData.defaultCopiedObjects[p][c][0],
                        ToolData.defaultCopiedObjects[p][c][1],
                        ToolData.defaultObjectPasteInputRotation ? ToolData.defaultObjectRotation : ToolData.defaultCopiedObjects[p][c][2],
                        false,
                        false
                     );
               }
            }
         }

         RSMapperClient.editor.objectEditor.populateTable(RSMapperClient.editor.selectedTile);
      }
   }

   @Override
   public void setupUI() {
      JTextField propertiesTitle = new JTextField();
      propertiesTitle.setBounds(4, 4, 285, 24);
      propertiesTitle.setHorizontalAlignment(0);
      propertiesTitle.setEditable(false);
      propertiesTitle.setText("SELECTED TILE PROPERTIES");
      propertiesTitle.setFont(new Font("", 1, 16));
      UIPanels.propertiesTabPanel.add(propertiesTitle);
      this.propertyComponents.put("properties_title", propertiesTitle);
      JTextField mTitle = new JTextField();
      mTitle.setBounds(80, 30, 43, 24);
      mTitle.setHorizontalAlignment(0);
      mTitle.setEditable(false);
      mTitle.setText("M");
      UIPanels.propertiesTabPanel.add(mTitle);
      this.propertyComponents.put("m_title", mTitle);
      JTextField umTitle = new JTextField();
      umTitle.setBounds(123, 30, 43, 24);
      umTitle.setHorizontalAlignment(0);
      umTitle.setEditable(false);
      umTitle.setText("UM");
      UIPanels.propertiesTabPanel.add(umTitle);
      this.propertyComponents.put("um_title", umTitle);
      JTextField shiftersTitle = new JTextField();
      shiftersTitle.setBounds(174, 30, 113, 24);
      shiftersTitle.setHorizontalAlignment(0);
      shiftersTitle.setEditable(false);
      shiftersTitle.setText("SHIFTERS ( M )");
      UIPanels.propertiesTabPanel.add(shiftersTitle);
      this.propertyComponents.put("shifters_title", shiftersTitle);
      JTextField height_title = this.createTitle("HEIGHT", "0 or 1 for default height, 32 for height 1", 4, 58, 76, 24);
      UIPanels.propertiesTabPanel.add(height_title);
      this.propertyComponents.put("height_title", height_title);
      JTextField flag_title = this.createTitle("FLAG", "Sets the behaviour of the tile, for example 1 is no walk", 4, 83, 76, 24);
      UIPanels.propertiesTabPanel.add(flag_title);
      this.propertyComponents.put("flag_title", flag_title);
      JTextField overlay_title = this.createTitle("OVERLAY", "The overlayed texture", 4, 108, 76, 24);
      UIPanels.propertiesTabPanel.add(overlay_title);
      this.propertyComponents.put("overlay_title", overlay_title);
      JTextField underlay_title = this.createTitle("UNDERLAY", "The underlayed texture", 4, 133, 76, 24);
      UIPanels.propertiesTabPanel.add(underlay_title);
      this.propertyComponents.put("underlay_title", underlay_title);
      JTextField shape_title = this.createTitle("SHAPE", "The rendered shape", 4, 158, 76, 24);
      UIPanels.propertiesTabPanel.add(shape_title);
      this.propertyComponents.put("shape_title", shape_title);
      JTextField rotation_title = this.createTitle("ROTATION", "The rotation of the shape", 4, 183, 76, 24);
      UIPanels.propertiesTabPanel.add(rotation_title);
      this.propertyComponents.put("rotation_title", rotation_title);
      int shiftX = 0;
      int shiftY = -161;
      JTextField txt_height = new JTextField("" + ToolData.defaultMapHeight);
      txt_height.setBounds(shiftX + 80, shiftY + 220 + 0, 43, 24);
      UIPanels.propertiesTabPanel.add(txt_height);
      this.propertyComponents.put("txt_height", txt_height);
      this.addTextChangedListeners(txt_height, true, 0);
      JButton shiftHeightLeft = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 220 + 0, 55, 24, 0, true
      );
      UIPanels.propertiesTabPanel.add(shiftHeightLeft);
      this.propertyComponents.put("decrement_height", shiftHeightLeft);
      JButton shiftHeightRight = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 220 + 0, 55, 24, 0, false
      );
      UIPanels.propertiesTabPanel.add(shiftHeightRight);
      this.propertyComponents.put("increment_height", shiftHeightRight);
      JTextField txt_tileflag = new JTextField("" + ToolData.defaultMapFlag);
      txt_tileflag.setBounds(shiftX + 80, shiftY + 220 + 25, 43, 24);
      UIPanels.propertiesTabPanel.add(txt_tileflag);
      this.propertyComponents.put("txt_tileflag", txt_tileflag);
      this.addTextChangedListeners(txt_tileflag, true, 1);
      JButton shiftFlagLeft = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 220 + 25, 55, 24, 1, true
      );
      UIPanels.propertiesTabPanel.add(shiftFlagLeft);
      this.propertyComponents.put("decrement_flag", shiftFlagLeft);
      JButton shiftFlagRight = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 220 + 25, 55, 24, 1, false
      );
      UIPanels.propertiesTabPanel.add(shiftFlagRight);
      this.propertyComponents.put("increment_flag", shiftFlagRight);
      JTextField txt_overlay = new JTextField("" + ToolData.defaultMapOverlay);
      txt_overlay.setBounds(shiftX + 80, shiftY + 220 + 50, 43, 24);
      UIPanels.propertiesTabPanel.add(txt_overlay);
      this.propertyComponents.put("txt_overlay", txt_overlay);
      this.addTextChangedListeners(txt_overlay, true, 2);
      JButton shiftOverlayLeft = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 220 + 50, 55, 24, 2, true
      );
      UIPanels.propertiesTabPanel.add(shiftOverlayLeft);
      this.propertyComponents.put("decrement_overlay", shiftOverlayLeft);
      JButton shiftOverlayRight = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 220 + 50, 55, 24, 2, false
      );
      UIPanels.propertiesTabPanel.add(shiftOverlayRight);
      this.propertyComponents.put("increment_overlay", shiftOverlayRight);
      JTextField txt_underlay = new JTextField("" + ToolData.defaultMapUnderlay);
      txt_underlay.setBounds(shiftX + 80, shiftY + 220 + 75, 43, 24);
      UIPanels.propertiesTabPanel.add(txt_underlay);
      this.propertyComponents.put("txt_underlay", txt_underlay);
      this.addTextChangedListeners(txt_underlay, true, 3);
      JButton shiftUnderlayLeft = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 220 + 75, 55, 24, 3, true
      );
      UIPanels.propertiesTabPanel.add(shiftUnderlayLeft);
      this.propertyComponents.put("decrement_underlay", shiftUnderlayLeft);
      JButton shiftUnderlayRight = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 220 + 75, 55, 24, 3, false
      );
      UIPanels.propertiesTabPanel.add(shiftUnderlayRight);
      this.propertyComponents.put("increment_underlay", shiftUnderlayRight);
      JTextField txt_shape = new JTextField("" + ToolData.defaultMapShape);
      txt_shape.setBounds(shiftX + 80, shiftY + 220 + 100, 43, 24);
      UIPanels.propertiesTabPanel.add(txt_shape);
      this.propertyComponents.put("txt_shape", txt_shape);
      this.addTextChangedListeners(txt_shape, true, 4);
      JButton shiftShapeLeft = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 220 + 100, 55, 24, 4, true
      );
      UIPanels.propertiesTabPanel.add(shiftShapeLeft);
      this.propertyComponents.put("decrement_shape", shiftShapeLeft);
      JButton shiftShapeRight = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 220 + 100, 55, 24, 4, false
      );
      UIPanels.propertiesTabPanel.add(shiftShapeRight);
      this.propertyComponents.put("increment_shape", shiftShapeRight);
      JTextField txt_rotation = new JTextField("" + ToolData.defaultMapRotation);
      txt_rotation.setBounds(shiftX + 80, shiftY + 220 + 125, 43, 24);
      UIPanels.propertiesTabPanel.add(txt_rotation);
      this.propertyComponents.put("txt_rotation", txt_rotation);
      this.addTextChangedListeners(txt_rotation, true, 5);
      JButton shiftRotationLeft = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 220 + 125, 55, 24, 5, true
      );
      UIPanels.propertiesTabPanel.add(shiftRotationLeft);
      this.propertyComponents.put("decrement_rotation", shiftRotationLeft);
      JButton shiftRotationRight = this.makeShiftPropertyButton(
         "", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 220 + 125, 55, 24, 5, false
      );
      UIPanels.propertiesTabPanel.add(shiftRotationRight);
      this.propertyComponents.put("increment_rotation", shiftRotationRight);
      JTextField txt_uHeight = new JTextField("" + ToolData.defaultUMapHeight);
      txt_uHeight.setBounds(shiftX + 123, shiftY + 220 + 0, 43, 24);
      UIPanels.propertiesTabPanel.add(txt_uHeight);
      this.propertyComponents.put("txt_uHeight", txt_uHeight);
      this.addTextChangedListeners(txt_uHeight, true, 6);
      JTextField txt_uFlagEmpty = new JTextField();
      txt_uFlagEmpty.setBounds(shiftX + 123, shiftY + 220 + 25, 43, 24);
      txt_uFlagEmpty.setEditable(false);
      UIPanels.propertiesTabPanel.add(txt_uFlagEmpty);
      this.propertyComponents.put("txt_uFlagEmpty", txt_uFlagEmpty);
      JTextField txt_uOverlay = new JTextField("" + ToolData.defaultUMapOverlay);
      txt_uOverlay.setBounds(shiftX + 123, shiftY + 220 + 50, 43, 24);
      UIPanels.propertiesTabPanel.add(txt_uOverlay);
      this.propertyComponents.put("txt_uOverlay", txt_uOverlay);
      this.addTextChangedListeners(txt_uOverlay, true, 7);
      JTextField txt_uUnderlay = new JTextField("" + ToolData.defaultUMapUnderlay);
      txt_uUnderlay.setBounds(shiftX + 123, shiftY + 220 + 75, 43, 24);
      UIPanels.propertiesTabPanel.add(txt_uUnderlay);
      this.propertyComponents.put("txt_uUnderlay", txt_uUnderlay);
      this.addTextChangedListeners(txt_uUnderlay, true, 8);
      JTextField txt_uShape = new JTextField("" + ToolData.defaultUMapShape);
      txt_uShape.setBounds(shiftX + 123, shiftY + 220 + 100, 43, 24);
      UIPanels.propertiesTabPanel.add(txt_uShape);
      this.propertyComponents.put("txt_uShape", txt_uShape);
      this.addTextChangedListeners(txt_uShape, true, 9);
      JTextField txt_uRotation = new JTextField("" + ToolData.defaultUMapRotation);
      txt_uRotation.setBounds(shiftX + 123, shiftY + 220 + 125, 43, 24);
      UIPanels.propertiesTabPanel.add(txt_uRotation);
      this.propertyComponents.put("txt_uRotation", txt_uRotation);
      this.addTextChangedListeners(txt_uRotation, true, 10);
      shiftY += 2;
      JButton btnSaveTile = new JButton("Save Tile / Refresh Map");
      btnSaveTile.setFont(new Font("Tahoma", 1, 16));
      btnSaveTile.setBounds(4, shiftY + 225 + 150, 285, 26);
      btnSaveTile.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               RSMapperClient.editor.saveMapState(false);
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.HEIGHT, ToolData.defaultMapHeight, false, false, true);
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.TILE_FLAG, ToolData.defaultMapFlag, false, false, true);
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.OVERLAY, ToolData.defaultMapOverlay, false, false, true);
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(
                     RSMapperClient.editor.selectedTile, MapEditor.PropertyType.UNDERLAY, ToolData.defaultMapUnderlay, false, false, true
                  );
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.SHAPE, ToolData.defaultMapShape, false, false, true);
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(
                     RSMapperClient.editor.selectedTile, MapEditor.PropertyType.ROTATION, ToolData.defaultMapRotation, false, false, true
                  );
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.HEIGHT, ToolData.defaultUMapHeight, true, false, true);
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.OVERLAY, ToolData.defaultUMapOverlay, true, false, true);
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(
                     RSMapperClient.editor.selectedTile, MapEditor.PropertyType.UNDERLAY, ToolData.defaultUMapUnderlay, true, false, true
                  );
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.SHAPE, ToolData.defaultUMapShape, true, false, true);
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(
                     RSMapperClient.editor.selectedTile, MapEditor.PropertyType.ROTATION, ToolData.defaultUMapRotation, true, false, true
                  );
               RSMapperClient.setFocusOnCanvas();
               Class78.MAP_CHANGED = true;
            }
         }
      );
      UIPanels.propertiesTabPanel.add(btnSaveTile);
      this.propertyComponents.put("save_properties", btnSaveTile);
      JButton btnCopy = new JButton("Copy Properties");
      btnCopy.setFont(new Font("Tahoma", 1, 13));
      btnCopy.setForeground(Color.BLUE);
      btnCopy.setBounds(4, shiftY + 228 + 175, 142, 26);
      btnCopy.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            DefaultTool.this.applyAction(ToolData.ActionValues.SINGLE_COPY.getValue());
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.propertiesTabPanel.add(btnCopy);
      this.propertyComponents.put("copy_properties", btnCopy);
      JButton btnPaste = new JButton("Paste Properties");
      btnPaste.setFont(new Font("Tahoma", 1, 13));
      btnPaste.setForeground(Color.GREEN);
      btnPaste.setBounds(148, shiftY + 228 + 175, 140, 26);
      btnPaste.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            DefaultTool.this.applyAction(ToolData.ActionValues.SINGLE_PASTE.getValue());
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.propertiesTabPanel.add(btnPaste);
      this.propertyComponents.put("paste_properties", btnPaste);
      JButton shape0 = this.createShapeButton(0, 15, shiftY + 228 + 225);
      UIPanels.propertiesTabPanel.add(shape0);
      this.propertyComponents.put("button_shape0", shape0);
      JButton shape1 = this.createShapeButton(1, 67, shiftY + 228 + 225);
      UIPanels.propertiesTabPanel.add(shape1);
      this.propertyComponents.put("button_shape1", shape1);
      JButton shape2 = this.createShapeButton(2, 119, shiftY + 228 + 225);
      UIPanels.propertiesTabPanel.add(shape2);
      this.propertyComponents.put("button_shape2", shape2);
      JButton shape3 = this.createShapeButton(3, 171, shiftY + 228 + 225);
      UIPanels.propertiesTabPanel.add(shape3);
      this.propertyComponents.put("button_shape3", shape3);
      JButton shape4 = this.createShapeButton(4, 223, shiftY + 228 + 225);
      UIPanels.propertiesTabPanel.add(shape4);
      this.propertyComponents.put("button_shape4", shape4);
      shiftY += 52;
      JButton shape5 = this.createShapeButton(5, 15, shiftY + 228 + 225);
      UIPanels.propertiesTabPanel.add(shape5);
      this.propertyComponents.put("button_shape5", shape5);
      JButton shape6 = this.createShapeButton(6, 67, shiftY + 228 + 225);
      UIPanels.propertiesTabPanel.add(shape6);
      this.propertyComponents.put("button_shape6", shape6);
      JButton shape7 = this.createShapeButton(7, 119, shiftY + 228 + 225);
      UIPanels.propertiesTabPanel.add(shape7);
      this.propertyComponents.put("button_shape7", shape7);
      JButton shape8 = this.createShapeButton(8, 171, shiftY + 228 + 225);
      UIPanels.propertiesTabPanel.add(shape8);
      this.propertyComponents.put("button_shape8", shape8);
      JButton shape9 = this.createShapeButton(9, 223, shiftY + 228 + 225);
      UIPanels.propertiesTabPanel.add(shape9);
      this.propertyComponents.put("button_shape9", shape9);
      shiftY += 52;
      JButton shape10 = this.createShapeButton(10, 67, shiftY + 228 + 225);
      UIPanels.propertiesTabPanel.add(shape10);
      this.propertyComponents.put("button_shape10", shape10);
      JButton shape11 = this.createShapeButton(11, 119, shiftY + 228 + 225);
      UIPanels.propertiesTabPanel.add(shape11);
      this.propertyComponents.put("button_shape11", shape11);
      JButton shape12 = this.createShapeButton(12, 171, shiftY + 228 + 225);
      UIPanels.propertiesTabPanel.add(shape12);
      this.propertyComponents.put("button_shape12", shape12);
      JTextField objectsTitle = new JTextField();
      objectsTitle.setBounds(4, 4, 285, 24);
      objectsTitle.setHorizontalAlignment(0);
      objectsTitle.setEditable(false);
      objectsTitle.setText("EDIT OBJECTS ON TILE");
      objectsTitle.setFont(new Font("", 1, 16));
      UIPanels.objectsTabPanel.add(objectsTitle);
      this.objectComponents.put("objects_title", objectsTitle);
      JTextField[][] objectTitles = new JTextField[4][3];
      final JTextField[][] objectsOnTile = new JTextField[4][3];
      JButton[] selectButtons = new JButton[4];
      int var83 = 20;
      JTextField editingTileTitle = new JTextField();
      editingTileTitle.setBounds(4, var83 + 150, 285, 24);
      editingTileTitle.setHorizontalAlignment(0);
      editingTileTitle.setEditable(false);
      editingTileTitle.setText("OBJECTS ON TILE");
      editingTileTitle.setFont(new Font("", 1, 16));
      UIPanels.objectsTabPanel.add(editingTileTitle);
      this.objectComponents.put("object_editing_title", editingTileTitle);

      for(int i = 0; i < 4; ++i) {
         for(int j = 0; j < 3; ++j) {
            objectTitles[i][j] = new JTextField();
            objectTitles[i][j].setBounds(4 + j * 86 + (j == 1 ? -9 : (j == 2 ? -29 : 0)), var83 + 178 + 1 * i * 25, j == 2 ? 58 : 36, 24);
            objectTitles[i][j].setEditable(false);
            UIPanels.objectsTabPanel.add(objectTitles[i][j]);
            this.objectComponents.put("object_title" + i + "_" + j, objectTitles[i][j]);
            objectsOnTile[i][j] = new JTextField();
            objectsOnTile[i][j].setBounds(47 + 35 * j * 2 + (j == 0 ? -7 : (j == 1 ? -1 : (j == 2 ? 18 : 0))), var83 + 178 + i * 25, j == 0 ? 40 : 30, 24);
            objectsOnTile[i][j].setText("");
            objectsOnTile[i][j].setEditable(false);
            objectsOnTile[i][j].setBackground(new Color(191, 190, 186));
            UIPanels.objectsTabPanel.add(objectsOnTile[i][j]);
            this.objectComponents.put("objects_on_tile" + i + "_" + j, objectsOnTile[i][j]);
         }

         objectTitles[i][0].setText("ID:");
         objectTitles[i][0].setFont(new Font("", 0, 10));
         objectTitles[i][1].setText("TYPE:");
         objectTitles[i][1].setFont(new Font("", 0, 9));
         objectTitles[i][2].setText("ROTATION:");
         objectTitles[i][2].setFont(new Font("", 0, 9));
         selectButtons[i] = new JButton("SELECT");
         selectButtons[i].setBounds(235, var83 + 176 + i * 25, 52, 24);
         selectButtons[i].setForeground(Color.BLUE);
         final int i2 = i;
         selectButtons[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               if (!objectsOnTile[i2][0].getText().isEmpty()) {
                  int id = Integer.parseInt(objectsOnTile[i2][0].getText().trim());
                  ToolData.defaultObjectId = id;
                  ((JTextField)DefaultTool.this.objectComponents.get("input_id")).setText("" + id);
               }

               if (!objectsOnTile[i2][1].getText().isEmpty()) {
                  int type = Integer.parseInt(objectsOnTile[i2][1].getText().trim());
                  ToolData.defaultObjectType = type;
                  ((JTextField)DefaultTool.this.objectComponents.get("input_type")).setText("" + type);
               }

               if (!objectsOnTile[i2][2].getText().isEmpty()) {
                  int rotation = Integer.parseInt(objectsOnTile[i2][2].getText().trim());
                  ToolData.defaultObjectRotation = rotation;
                  ((JTextField)DefaultTool.this.objectComponents.get("input_rotation")).setText("" + rotation);
               }

               RSMapperClient.setFocusOnCanvas();
            }
         });
         UIPanels.objectsTabPanel.add(selectButtons[i]);
         this.objectComponents.put("select_button" + i, selectButtons[i]);
      }

      JTextField settingsTitle = new JTextField();
      settingsTitle.setBounds(4, var83 + 283, 285, 24);
      settingsTitle.setHorizontalAlignment(0);
      settingsTitle.setEditable(false);
      settingsTitle.setText("SETTINGS");
      settingsTitle.setFont(new Font("", 1, 16));
      UIPanels.objectsTabPanel.add(settingsTitle);
      this.objectComponents.put("object_settings_title", settingsTitle);
      final JCheckBox underland = new JCheckBox("Underland");
      underland.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      underland.setBorderPainted(true);
      underland.setSelected(ToolData.defaultSpawnUnderland);
      underland.setBounds(5, var83 + 312, 136, 30);
      underland.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ToolData.defaultSpawnUnderland = underland.isSelected();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(underland);
      this.objectComponents.put("toggle_obj_underland", underland);
      final JCheckBox toggleRandomRotation = new JCheckBox("Random rotation");
      toggleRandomRotation.setToolTipText("Randomize rotation on spawn");
      toggleRandomRotation.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      toggleRandomRotation.setBorderPainted(true);
      toggleRandomRotation.setSelected(ToolData.defaultObjectRandomizeRotation);
      toggleRandomRotation.setBounds(5, var83 + 312 + 30, 136, 30);
      toggleRandomRotation.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ToolData.defaultObjectRandomizeRotation = toggleRandomRotation.isSelected();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(toggleRandomRotation);
      this.objectComponents.put("toggle_random_rotation", toggleRandomRotation);
      final JCheckBox removeAll = new JCheckBox("Remove all");
      removeAll.setToolTipText("Removes all rather than selected type");
      removeAll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      removeAll.setBorderPainted(true);
      removeAll.setSelected(ToolData.defaultObjectRemoveAll);
      removeAll.setBounds(5, var83 + 312 + 60, 136, 30);
      removeAll.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ToolData.defaultObjectRemoveAll = removeAll.isSelected();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(removeAll);
      this.objectComponents.put("toggle_obj_remove_all", removeAll);
      JSeparator sepSettings = new JSeparator(1);
      sepSettings.setBounds(145, var83 + 306, 3, 150);
      UIPanels.objectsTabPanel.add(sepSettings);
      this.objectComponents.put("settings_sep1", sepSettings);
      final JCheckBox copyAbovePlanes = new JCheckBox("C / P above planes");
      copyAbovePlanes.setToolTipText("Copy objects on all planes above selected");
      copyAbovePlanes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      copyAbovePlanes.setBorderPainted(true);
      copyAbovePlanes.setSelected(ToolData.defaultObjectCopyAbovePlanes);
      copyAbovePlanes.setBounds(151, var83 + 312, 136, 30);
      copyAbovePlanes.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ToolData.defaultObjectCopyAbovePlanes = copyAbovePlanes.isSelected();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(copyAbovePlanes);
      this.objectComponents.put("toggle_obj_copy_above_planes", copyAbovePlanes);
      final JCheckBox deleteOnCopy = new JCheckBox("Remove on copy");
      deleteOnCopy.setToolTipText("Remove all objects on tile when copied");
      deleteOnCopy.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      deleteOnCopy.setBorderPainted(true);
      deleteOnCopy.setSelected(ToolData.defaultObjectDeleteOnCopy);
      deleteOnCopy.setBounds(151, var83 + 312 + 30, 136, 30);
      deleteOnCopy.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ToolData.defaultObjectDeleteOnCopy = deleteOnCopy.isSelected();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(deleteOnCopy);
      this.objectComponents.put("toggle_obj_delete_on_copy", deleteOnCopy);
      final JCheckBox pasteInputRotation = new JCheckBox("Paste input rotation");
      pasteInputRotation.setToolTipText("Paste with rotation input rather than copy");
      pasteInputRotation.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      pasteInputRotation.setBorderPainted(true);
      pasteInputRotation.setSelected(ToolData.defaultObjectPasteInputRotation);
      pasteInputRotation.setBounds(151, var83 + 312 + 30 + 30, 136, 30);
      pasteInputRotation.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ToolData.defaultObjectPasteInputRotation = pasteInputRotation.isSelected();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(pasteInputRotation);
      this.objectComponents.put("toggle_obj_paste_rot", pasteInputRotation);
      JTextField[] objectInputTitles = new JTextField[3];

      for(int j = 0; j < 3; ++j) {
         objectInputTitles[j] = new JTextField();
         objectInputTitles[j].setBounds((j > 0 ? 10 : 0) + 4 + j * 86, 32, j == 2 ? 70 : 43, 24);
         objectInputTitles[j].setEditable(false);
         UIPanels.objectsTabPanel.add(objectInputTitles[j]);
         this.objectComponents.put("object_input_title" + j, objectInputTitles[j]);
      }

      objectInputTitles[0].setText("ID:");
      objectInputTitles[1].setText("TYPE:");
      objectInputTitles[2].setText("ROTATION:");
      JTextField inputId = new JTextField("" + ToolData.defaultObjectId);
      inputId.setBounds(47, 32, 53, 24);
      this.addTextChangedListeners(inputId, false, 0);
      UIPanels.objectsTabPanel.add(inputId);
      this.objectComponents.put("input_id", inputId);
      JTextField inputType = new JTextField("" + ToolData.defaultObjectType);
      inputType.setBounds(143, 32, 44, 24);
      this.addTextChangedListeners(inputType, false, 1);
      UIPanels.objectsTabPanel.add(inputType);
      this.objectComponents.put("input_type", inputType);
      JTextField inputRotation = new JTextField("" + ToolData.defaultObjectRotation);
      inputRotation.setBounds(256, 32, 32, 24);
      this.addTextChangedListeners(inputRotation, false, 2);
      UIPanels.objectsTabPanel.add(inputRotation);
      this.objectComponents.put("input_rotation", inputRotation);
      JButton shiftIdLeft = this.makeShiftObjectValueButton("I", null, new ImageIcon("resources/images/decrement.png"), false, 17, 59, 35, 20, 0, true);
      UIPanels.objectsTabPanel.add(shiftIdLeft);
      this.objectComponents.put("decrement_id", shiftIdLeft);
      JButton shiftIdRight = this.makeShiftObjectValueButton("I", null, new ImageIcon("resources/images/increment.png"), true, 53, 59, 35, 20, 0, false);
      UIPanels.objectsTabPanel.add(shiftIdRight);
      this.objectComponents.put("increment_id", shiftIdRight);
      JButton shiftTypeLeft = this.makeShiftObjectValueButton("T", null, new ImageIcon("resources/images/decrement.png"), false, 108, 59, 35, 20, 1, true);
      UIPanels.objectsTabPanel.add(shiftTypeLeft);
      this.objectComponents.put("decrement_type", shiftTypeLeft);
      JButton shiftTypeRight = this.makeShiftObjectValueButton("T", null, new ImageIcon("resources/images/increment.png"), true, 144, 59, 35, 20, 1, false);
      UIPanels.objectsTabPanel.add(shiftTypeRight);
      this.objectComponents.put("increment_type", shiftTypeRight);
      JButton shiftObjRotationLeft = this.makeShiftObjectValueButton(
         "R", null, new ImageIcon("resources/images/decrement.png"), false, 200, 59, 37, 20, 2, true
      );
      UIPanels.objectsTabPanel.add(shiftObjRotationLeft);
      this.objectComponents.put("decrement_objrotation", shiftObjRotationLeft);
      JButton shiftObjRotationRight = this.makeShiftObjectValueButton(
         "R", null, new ImageIcon("resources/images/increment.png"), true, 238, 59, 37, 20, 2, false
      );
      UIPanels.objectsTabPanel.add(shiftObjRotationRight);
      this.objectComponents.put("increment_objrotation", shiftObjRotationRight);
      JButton btnSpawn = new JButton("Spawn Object");
      btnSpawn.setBounds(4, 84, 285, 24);
      btnSpawn.setFont(new Font("Tahoma", 1, 16));
      btnSpawn.setForeground(Color.GREEN);
      btnSpawn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            DefaultTool.this.applyAction(ToolData.ActionValues.SINGLE_SPAWN.getValue());
         }
      });
      UIPanels.objectsTabPanel.add(btnSpawn);
      this.objectComponents.put("spawn_object", btnSpawn);
      JButton btnRemove = new JButton("Remove Object");
      btnRemove.setBounds(4, 110, 285, 24);
      btnRemove.setFont(new Font("Tahoma", 1, 16));
      btnRemove.setForeground(Color.red);
      btnRemove.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            DefaultTool.this.applyAction(ToolData.ActionValues.SINGLE_REMOVE.getValue());
         }
      });
      UIPanels.objectsTabPanel.add(btnRemove);
      this.objectComponents.put("remove_object", btnRemove);
      JButton btnDisplay = new JButton("   View Model", new ImageIcon("resources/images/expand_icon.png"));
      btnDisplay.setBounds(4, 140, 142, 24);
      btnDisplay.setFont(new Font("Tahoma", 1, 14));
      btnDisplay.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            if (RSMapperClient.editor.objectEditor != null) {
               RSMapperClient.editor.objectEditor.displayObjectOnModelViewer(ToolData.defaultObjectId, ToolData.defaultObjectType);
            }
         }
      });
      UIPanels.objectsTabPanel.add(btnDisplay);
      this.objectComponents.put("view_model_button", btnDisplay);
      JButton btnClose = new JButton("  Close Viewer", new ImageIcon("resources/images/hide_icon.png"));
      btnClose.setBounds(148, 140, 140, 24);
      btnClose.setFont(new Font("Tahoma", 1, 14));
      btnClose.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ExternalInterfaceLoader.closeInterface("ModelViewer");
         }
      });
      UIPanels.objectsTabPanel.add(btnClose);
      this.objectComponents.put("close_viewer_button", btnClose);
   }

   @Override
   public void handleTileHover(int localX, int localY) {
      super.handleTileHover(localX, localY);
   }

   private JTextField createTitle(String title, String tooltip, int x, int y, int width, int height) {
      JTextField textfield = new JTextField(title);
      textfield.setBounds(x, y, width, height);
      textfield.setEditable(false);
      textfield.setVisible(true);
      if (tooltip != null) {
         textfield.setToolTipText(tooltip);
      }

      return textfield;
   }

   private JButton createShapeButton(final int shape, int x, int y) {
      JButton button = new JButton();
      button.setBounds(x, y, 50, 50);
      Image img = new ImageIcon("resources/images/shape_" + shape + ".png").getImage();
      Image newimg = img.getScaledInstance(60, 60, 4);
      button.setIcon(new ImageIcon(newimg));
      button.setBorderPainted(false);
      button.setBorder(null);
      button.setContentAreaFilled(false);
      button.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               if (UIPanels.propertyComponents.get("txt_shape") != null) {
                  ((JTextField)UIPanels.propertyComponents.get("txt_shape")).setText("" + (byte)shape);
                  if (RSMapperClient.editor.mapEditor.dataLoaded) {
                     RSMapperClient.editor.saveMapState(false);
                     RSMapperClient.editor
                        .mapEditor
                        .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.SHAPE, (byte)shape, false, true, false);
                  }
               }
            }
         }
      );
      return button;
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
      button.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               try {
                  if (type >= 0 && type <= 5) {
                     RSMapperClient.editor.saveMapState(false);
                     switch(type) {
                        case 0:
                           int height = Integer.parseInt(((JTextField)DefaultTool.this.propertyComponents.get("txt_height")).getText());
   
                           for(int i = 1; i <= 32; ++i) {
                              int value = 8 * -(-((height + (reduce ? -i : i)) / 8 >> 2)) << 2;
                              if (reduce && value < height) {
                                 height = value;
                                 break;
                              }
   
                              if (!reduce && value > height) {
                                 height = value;
                                 break;
                              }
                           }
   
                           ToolData.defaultMapHeight = height;
                           RSMapperClient.editor
                              .mapEditor
                              .saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.HEIGHT, height, false, true, true);
                           break;
                        case 1:
                           if (ToolData.defaultMapFlag == 0 && reduce) {
                              ToolData.defaultMapFlag = 0;
                           } else {
                              ToolData.defaultMapFlag += reduce ? -1 : 1;
                           }
   
                           RSMapperClient.editor
                              .mapEditor
                              .saveTileWithNewProperty(
                                 RSMapperClient.editor.selectedTile, MapEditor.PropertyType.TILE_FLAG, ToolData.defaultMapFlag, false, true, true
                              );
                           break;
                        case 2:
                           ToolData.defaultMapOverlay += reduce ? -1 : 1;
                           RSMapperClient.editor
                              .mapEditor
                              .saveTileWithNewProperty(
                                 RSMapperClient.editor.selectedTile, MapEditor.PropertyType.OVERLAY, ToolData.defaultMapOverlay, false, true, true
                              );
                           break;
                        case 3:
                           ToolData.defaultMapUnderlay += reduce ? -1 : 1;
                           RSMapperClient.editor
                              .mapEditor
                              .saveTileWithNewProperty(
                                 RSMapperClient.editor.selectedTile, MapEditor.PropertyType.UNDERLAY, ToolData.defaultMapUnderlay, false, true, true
                              );
                           break;
                        case 4:
                           if (ToolData.defaultMapShape <= 0 && reduce) {
                              ToolData.defaultMapShape = 12;
                           } else if (ToolData.defaultMapShape >= 12 && !reduce) {
                              ToolData.defaultMapShape = 0;
                           } else {
                              ToolData.defaultMapShape += reduce ? -1 : 1;
                           }
   
                           RSMapperClient.editor
                              .mapEditor
                              .saveTileWithNewProperty(
                                 RSMapperClient.editor.selectedTile, MapEditor.PropertyType.SHAPE, ToolData.defaultMapShape, false, true, true
                              );
                           break;
                        case 5:
                           if (ToolData.defaultMapRotation <= 0 && reduce) {
                              ToolData.defaultMapRotation = 3;
                           } else if (ToolData.defaultMapRotation >= 3 && !reduce) {
                              ToolData.defaultMapRotation = 0;
                           } else {
                              ToolData.defaultMapRotation += reduce ? -1 : 1;
                           }
   
                           RSMapperClient.editor
                              .mapEditor
                              .saveTileWithNewProperty(
                                 RSMapperClient.editor.selectedTile, MapEditor.PropertyType.ROTATION, ToolData.defaultMapRotation, false, true, true
                              );
                     }
                  }
               } catch (Exception var5) {
                  var5.printStackTrace();
               }
            }
         }
      );
      return button;
   }

   private JButton makeShiftObjectValueButton(
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
      button.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               try {
                  int previousType = ToolData.defaultObjectType;
                  boolean removePrevious = false;
                  RSMapperClient.editor.saveMapState(false);
                  switch(type) {
                     case 0:
                        ToolData.defaultObjectId += ToolData.defaultObjectId > -1 && reduce ? -1 : (ToolData.defaultObjectId < 65534 && !reduce ? 1 : 0);
                        RSMapperClient.editor
                           .objectEditor
                           .placeObject(
                              RSMapperClient.editor.selectedTile,
                              ToolData.defaultObjectId,
                              ToolData.defaultObjectType,
                              ToolData.defaultObjectRotation,
                              ToolData.defaultSpawnUnderland,
                              true
                           );
                        ((JTextField)DefaultTool.this.objectComponents.get("input_id")).setText("" + ToolData.defaultObjectId);
                        break;
                     case 1:
                        if (ToolData.defaultObjectType == 22 && !reduce) {
                           ToolData.defaultObjectType = 22;
                        } else if (ToolData.defaultObjectType == 0 && reduce) {
                           ToolData.defaultObjectType = 0;
                        } else {
                           ToolData.defaultObjectType += ToolData.defaultObjectType > 0 && reduce ? -1 : (ToolData.defaultObjectType < 22 && !reduce ? 1 : 0);
                           removePrevious = ObjectSpawnEditor.objectTypeFlags[previousType] != ObjectSpawnEditor.objectTypeFlags[ToolData.defaultObjectType];
                           System.out.println(previousType + " = " + ToolData.defaultObjectType + " (" + removePrevious + ")");
                        }
   
                        if (removePrevious) {
                           RSMapperClient.editor
                              .objectEditor
                              .removeObject(RSMapperClient.editor.selectedTile, previousType, ToolData.defaultSpawnUnderland, true);
                        }
   
                        RSMapperClient.editor
                           .objectEditor
                           .placeObject(
                              RSMapperClient.editor.selectedTile,
                              ToolData.defaultObjectId,
                              ToolData.defaultObjectType,
                              ToolData.defaultObjectRotation,
                              ToolData.defaultSpawnUnderland,
                              true
                           );
                        ((JTextField)DefaultTool.this.objectComponents.get("input_type")).setText("" + ToolData.defaultObjectType);
                        break;
                     case 2:
                        if (ToolData.defaultObjectRotation == 3 && !reduce) {
                           ToolData.defaultObjectRotation = 0;
                        } else if (ToolData.defaultObjectRotation == 0 && reduce) {
                           ToolData.defaultObjectRotation = 3;
                        } else {
                           ToolData.defaultObjectRotation += ToolData.defaultObjectRotation > 0 && reduce
                              ? -1
                              : (ToolData.defaultObjectRotation < 4 && !reduce ? 1 : 0);
                        }
   
                        RSMapperClient.editor
                           .objectEditor
                           .placeObject(
                              RSMapperClient.editor.selectedTile,
                              ToolData.defaultObjectId,
                              ToolData.defaultObjectType,
                              ToolData.defaultObjectRotation,
                              ToolData.defaultSpawnUnderland,
                              true
                           );
                        ((JTextField)DefaultTool.this.objectComponents.get("input_rotation")).setText("" + ToolData.defaultObjectRotation);
                  }
               } catch (Exception var4) {
               }
            }
         }
      );
      return button;
   }

   private void addTextChangedListeners(final JTextField field, final boolean properties, final int type) {
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
                        if (!properties) {
                           switch(type) {
                              case 0:
                                 ToolData.defaultObjectId = value;
                                 break;
                              case 1:
                                 ToolData.defaultObjectType = value;
                                 break;
                              case 2:
                                 ToolData.defaultObjectRotation = value;
                           }
                        } else {
                           switch(type) {
                              case 0:
                                 ToolData.defaultMapHeight = value;
                                 break;
                              case 1:
                                 ToolData.defaultMapFlag = value;
                                 break;
                              case 2:
                                 ToolData.defaultMapOverlay = value;
                                 break;
                              case 3:
                                 ToolData.defaultMapUnderlay = value;
                                 break;
                              case 4:
                                 ToolData.defaultMapShape = value;
                                 break;
                              case 5:
                                 ToolData.defaultMapRotation = value;
                                 break;
                              case 6:
                                 ToolData.defaultUMapHeight = value;
                                 break;
                              case 7:
                                 ToolData.defaultUMapOverlay = value;
                                 break;
                              case 8:
                                 ToolData.defaultUMapUnderlay = value;
                                 break;
                              case 9:
                                 ToolData.defaultUMapShape = value;
                                 break;
                              case 10:
                                 ToolData.defaultUMapRotation = value;
                           }
                        }
                     } catch (NumberFormatException var2) {
                     }
                  }
               };
               SwingUtilities.invokeLater(doChange);
            } else if (!properties) {
               switch(type) {
                  case 0:
                     ToolData.defaultObjectId = -1;
                     break;
                  case 1:
                     ToolData.defaultObjectType = 0;
                     break;
                  case 2:
                     ToolData.defaultObjectRotation = 0;
               }
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
                        if (!properties) {
                           switch(type) {
                              case 0:
                                 ToolData.defaultObjectId = value;
                                 break;
                              case 1:
                                 ToolData.defaultObjectType = value;
                                 break;
                              case 2:
                                 ToolData.defaultObjectRotation = value;
                           }
                        } else {
                           switch(type) {
                              case 0:
                                 ToolData.defaultMapHeight = value;
                                 break;
                              case 1:
                                 ToolData.defaultMapFlag = value;
                                 break;
                              case 2:
                                 ToolData.defaultMapOverlay = value;
                                 break;
                              case 3:
                                 ToolData.defaultMapUnderlay = value;
                                 break;
                              case 4:
                                 ToolData.defaultMapShape = value;
                                 break;
                              case 5:
                                 ToolData.defaultMapRotation = value;
                                 break;
                              case 6:
                                 ToolData.defaultUMapHeight = value;
                                 break;
                              case 7:
                                 ToolData.defaultUMapOverlay = value;
                                 break;
                              case 8:
                                 ToolData.defaultUMapUnderlay = value;
                                 break;
                              case 9:
                                 ToolData.defaultUMapShape = value;
                                 break;
                              case 10:
                                 ToolData.defaultUMapRotation = value;
                           }
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
}
