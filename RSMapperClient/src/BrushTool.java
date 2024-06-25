import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Random;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class BrushTool extends Tool {
   public BrushTool() {
      this.doubleClickActionValue = ToolData.brushDoubleClickAction;
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
         return new String[]{"<col=edb75a>Apply</col>"};
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
         return new int[]{ToolData.ActionValues.BRUSH_APPLY.getValue()};
      } else {
         return selectedType == EditorType.OBJECTS
            ? new int[]{
               ToolData.ActionValues.BRUSH_SPAWN.getValue(),
               ToolData.ActionValues.BRUSH_REMOVE.getValue(),
               ToolData.ActionValues.BRUSH_OBJ_COPY.getValue(),
               ToolData.ActionValues.BRUSH_OBJ_PASTE.getValue()
            }
            : null;
      }
   }

   @Override
   public void setDoubleClickAction(int actionValue, boolean forProperties, boolean storeValue) {
      this.doubleClickActionValue[forProperties ? 0 : 1] = actionValue;
      if (storeValue) {
         ToolData.brushDoubleClickAction[forProperties ? 0 : 1] = actionValue;
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
   public boolean supportsMulti() {
      return true;
   }

   @Override
   public void applyAction(int actionValue) {
      if (actionValue == ToolData.ActionValues.BRUSH_APPLY.getValue()) {
         RSMapperClient.editor.saveMapState(false);

         for(WorldTile t : RSMapperClient.editor.selectedTiles) {
            if (ToolData.includedBrushProperties[0][0]) {
               RSMapperClient.editor.mapEditor.saveTileWithNewProperty(t, MapEditor.PropertyType.HEIGHT, ToolData.brushProperties[0][0], false, false, false);
            }

            if (ToolData.includedBrushProperties[0][1]) {
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(t, MapEditor.PropertyType.TILE_FLAG, ToolData.brushProperties[0][1], false, false, false);
            }

            if (ToolData.includedBrushProperties[0][2]) {
               RSMapperClient.editor.mapEditor.saveTileWithNewProperty(t, MapEditor.PropertyType.OVERLAY, ToolData.brushProperties[0][2], false, false, false);
            }

            if (ToolData.includedBrushProperties[0][3]) {
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(t, MapEditor.PropertyType.UNDERLAY, ToolData.brushProperties[0][3], false, false, false);
            }

            if (ToolData.includedBrushProperties[0][4]) {
               RSMapperClient.editor.mapEditor.saveTileWithNewProperty(t, MapEditor.PropertyType.SHAPE, ToolData.brushProperties[0][4], false, false, false);
            }

            if (ToolData.includedBrushProperties[0][5]) {
               RSMapperClient.editor
                  .mapEditor
                  .saveTileWithNewProperty(t, MapEditor.PropertyType.ROTATION, ToolData.brushProperties[0][5], false, false, false);
            }

            if (ToolData.includedBrushProperties[1][0]) {
               RSMapperClient.editor.mapEditor.saveTileWithNewProperty(t, MapEditor.PropertyType.HEIGHT, ToolData.brushProperties[1][0], true, false, false);
            }

            if (ToolData.includedBrushProperties[1][1]) {
               RSMapperClient.editor.mapEditor.saveTileWithNewProperty(t, MapEditor.PropertyType.OVERLAY, ToolData.brushProperties[1][1], true, false, false);
            }

            if (ToolData.includedBrushProperties[1][2]) {
               RSMapperClient.editor.mapEditor.saveTileWithNewProperty(t, MapEditor.PropertyType.UNDERLAY, ToolData.brushProperties[1][2], true, false, false);
            }

            if (ToolData.includedBrushProperties[1][3]) {
               RSMapperClient.editor.mapEditor.saveTileWithNewProperty(t, MapEditor.PropertyType.SHAPE, ToolData.brushProperties[1][3], true, false, false);
            }

            if (ToolData.includedBrushProperties[1][4]) {
               RSMapperClient.editor.mapEditor.saveTileWithNewProperty(t, MapEditor.PropertyType.ROTATION, ToolData.brushProperties[1][4], true, false, false);
            }
         }

         Class78.MAP_CHANGED = Class66_Sub1.aWidget8983 == null || Class66_Sub1.aWidget8983.ihash >> 16 != 755;
      } else {
         int totalToggledObjectSlots = 0;
         int dominantSlot = -1;

         for(int i = 0; i < ToolData.brushIncludedObjectSlots.length; ++i) {
            if (ToolData.brushIncludedObjectSlots[i]) {
               if (dominantSlot == -1) {
                  dominantSlot = i;
               }

               ++totalToggledObjectSlots;
            }
         }

         if (dominantSlot == -1 || totalToggledObjectSlots == 0) {
            System.err.println("No objects were toggled for use in brush tool");
            return;
         }

         if (actionValue == ToolData.ActionValues.BRUSH_SPAWN.getValue()) {
            RSMapperClient.editor.saveMapState(false);

            for(WorldTile t : RSMapperClient.editor.selectedTiles) {
               if (totalToggledObjectSlots > 1) {
                  int slot = 0;

                  do {
                     slot = new Random().nextInt(ToolData.brushIncludedObjectSlots.length);
                  } while(!ToolData.brushIncludedObjectSlots[slot]);

                  int rotation = ToolData.brushObjectRandomizeRotation ? new Random().nextInt(4) : ToolData.brushIncludedObjectRotation[slot];
                  RSMapperClient.editor
                     .objectEditor
                     .placeObject(t, ToolData.brushIncludedObjectId[slot], ToolData.brushIncludedObjectType[slot], rotation, false, false);
               } else {
                  int rotation = ToolData.brushObjectRandomizeRotation ? new Random().nextInt(4) : ToolData.brushIncludedObjectRotation[dominantSlot];
                  RSMapperClient.editor
                     .objectEditor
                     .placeObject(t, ToolData.brushIncludedObjectId[dominantSlot], ToolData.brushIncludedObjectType[dominantSlot], rotation, false, false);
               }
            }
         } else if (actionValue == ToolData.ActionValues.BRUSH_REMOVE.getValue()) {
            RSMapperClient.editor.saveMapState(false);

            for(WorldTile t : RSMapperClient.editor.selectedTiles) {
               if (ToolData.brushObjectRemoveAll) {
                  int[][] objects = RSMapperClient.editor.objectEditor.getObjectsOnTile(t, false);

                  for(int c = 0; c < 4; ++c) {
                     if (objects[c][1] >= 0) {
                        RSMapperClient.editor.objectEditor.removeObject(t, objects[c][1], false, false);
                     }
                  }
               } else {
                  RSMapperClient.editor.objectEditor.removeObject(t, ToolData.brushIncludedObjectType[dominantSlot], false, false);
               }
            }
         } else if (actionValue == ToolData.ActionValues.BRUSH_OBJ_COPY.getValue()) {
            if (RSMapperClient.editor.brush.isMulti()) {
               System.err.println("Cannot copy while in multi brush mode");
               return;
            }

            ToolData.brushCopiedObjects = new HashMap<>();
            ToolData.brushObjectsCopiedFromPlane = RSMapperClient.editor.selectedTile.getPlane();
            if (ToolData.brushObjectDeleteOnCopy) {
               RSMapperClient.editor.saveMapState(false);
            }

            for(int p = RSMapperClient.editor.selectedTile.getPlane();
               p < (ToolData.brushObjectCopyAbovePlanes ? 4 : RSMapperClient.editor.selectedTile.getPlane() + 1);
               ++p
            ) {
               for(int y = 0; y < RSMapperClient.editor.brush.size; ++y) {
                  for(int x = 0; x < RSMapperClient.editor.brush.size; ++x) {
                     WorldTile thisTile = new WorldTile(
                        RSMapperClient.editor.selectedTile.getLocalX() - (RSMapperClient.editor.brush.size - 1) / 2 + x,
                        RSMapperClient.editor.selectedTile.getLocalY() - (RSMapperClient.editor.brush.size - 1) / 2 + y,
                        p,
                        true
                     );
                     int[] coordinates = new int[]{RSMapperClient.editor.brush.size, x, y, p};
                     int[][] objects = null;
                     if (RSMapperClient.editor
                        .selectedTiles
                        .contains(
                           ToolData.brushObjectCopyAbovePlanes
                              ? new WorldTile(thisTile.getLocalX(), thisTile.getLocalY(), RSMapperClient.editor.selectedTile.getPlane(), true)
                              : thisTile
                        )) {
                        objects = RSMapperClient.editor.objectEditor.getObjectsOnTile(thisTile, false);
                        if (ToolData.brushObjectDeleteOnCopy) {
                           for(int type : ObjectSpawnEditor.objectTypes) {
                              RSMapperClient.editor.objectEditor.removeObject(thisTile, type, false, false);
                           }
                        }
                     }

                     ToolData.brushCopiedObjects.put(coordinates, objects);
                  }
               }
            }
         } else if (actionValue == ToolData.ActionValues.BRUSH_OBJ_PASTE.getValue()) {
            if (RSMapperClient.editor.brush.isMulti()) {
               System.err.println("Cannot paste while in multi brush mode");
               return;
            }

            if (ToolData.brushCopiedObjects == null) {
               System.err.println("no objects have been copied");
               return;
            }

            boolean savedState = false;

            for(Entry<int[], int[][]> pair : ToolData.brushCopiedObjects.entrySet()) {
               int[][] objects = (int[][])pair.getValue();
               if (objects != null) {
                  int[] coords = (int[])pair.getKey();
                  if (!savedState) {
                     RSMapperClient.editor
                        .saveMapState(false, new Brush(BrushType.SQUARE, coords[0], false).getTilesBasedOnBrushAndSize(RSMapperClient.editor.selectedTile));
                     savedState = true;
                  }

                  WorldTile thisTile = new WorldTile(
                     RSMapperClient.editor.selectedTile.getLocalX() - (coords[0] - 1) / 2 + coords[1],
                     RSMapperClient.editor.selectedTile.getLocalY() - (coords[0] - 1) / 2 + coords[2],
                     coords[3],
                     true
                  );
                  int difference = ToolData.brushObjectsCopiedFromPlane - RSMapperClient.editor.selectedTile.getPlane();
                  if (thisTile.getPlane() - difference < 4 && thisTile.getPlane() - difference >= 0) {
                     if (difference != 0) {
                        thisTile = new WorldTile(thisTile.getLocalX(), thisTile.getLocalY(), thisTile.getPlane() - difference, true);
                     }

                     if (ToolData.brushObjectCopyAbovePlanes
                        || !ToolData.brushObjectCopyAbovePlanes && thisTile.getPlane() == ToolData.brushObjectsCopiedFromPlane - difference) {
                        for(int i = 0; i < 4; ++i) {
                           RSMapperClient.editor.objectEditor.placeObject(thisTile, objects[i][0], objects[i][1], objects[i][2], false, false);
                        }
                     }
                  }
               }
            }
         }
      }

      RSMapperClient.editor.objectEditor.populateTable(RSMapperClient.editor.selectedTile);
   }

   @Override
   public void setupUI() {
      int shiftX = 25;
      int shiftY = 40;
      JTextField propertiesTitle = new JTextField();
      propertiesTitle.setBounds(4, 4, 285, 24);
      propertiesTitle.setHorizontalAlignment(0);
      propertiesTitle.setEditable(false);
      propertiesTitle.setText("BRUSH PROPERTIES");
      propertiesTitle.setFont(new Font("", 1, 16));
      UIPanels.propertiesTabPanel.add(propertiesTitle);
      this.propertyComponents.put("properties_title", propertiesTitle);
      JTextField mapTitle = new JTextField("   Map");
      mapTitle.setBounds(29, shiftY - 6, 104, 24);
      mapTitle.setEditable(false);
      mapTitle.setBackground(Color.DARK_GRAY);
      mapTitle.setFont(new Font("", 1, 13));
      UIPanels.propertiesTabPanel.add(mapTitle);
      this.propertyComponents.put("map_title", mapTitle);
      JCheckBox mSelectAll = new JCheckBox("");
      mSelectAll.setSelected(ToolData.includedBrushProperties[0][1]);
      mSelectAll.setBounds(4, shiftY - 6, 24, 24);
      UIPanels.propertiesTabPanel.add(mSelectAll);
      this.propertyComponents.put("chck_selectallmap", mSelectAll);
      this.addSelectAllCheckBoxListener(mSelectAll, 0, "chck_selectallmap");
      JCheckBox mHeight = new JCheckBox("Height (M)");
      mHeight.setSelected(ToolData.includedBrushProperties[0][0]);
      mHeight.setBounds(4, shiftY + 20, 125, 24);
      UIPanels.propertiesTabPanel.add(mHeight);
      this.propertyComponents.put("chck_height", mHeight);
      this.addCheckboxListener(mHeight, 0, 0, "chck_height");
      JTextField txtMHeight = new JTextField("" + ToolData.brushProperties[0][0]);
      txtMHeight.setBounds(9, shiftY + 43, 125, 22);
      txtMHeight.setEditable(ToolData.includedBrushProperties[0][0]);
      UIPanels.propertiesTabPanel.add(txtMHeight);
      this.propertyComponents.put("txt_height", txtMHeight);
      this.addPropertyTextChangedListeners(txtMHeight, 0, 0);
      JCheckBox mFlag = new JCheckBox("Flag (M)");
      mFlag.setSelected(ToolData.includedBrushProperties[0][1]);
      mFlag.setBounds(4, shiftY + 67, 125, 24);
      UIPanels.propertiesTabPanel.add(mFlag);
      this.propertyComponents.put("chck_tileflag", mFlag);
      this.addCheckboxListener(mFlag, 0, 1, "chck_tileflag");
      JTextField txtMFlag = new JTextField("" + ToolData.brushProperties[0][1]);
      txtMFlag.setBounds(9, shiftY + 90, 125, 22);
      txtMFlag.setEditable(ToolData.includedBrushProperties[0][1]);
      UIPanels.propertiesTabPanel.add(txtMFlag);
      this.propertyComponents.put("txt_tileflag", txtMFlag);
      this.addPropertyTextChangedListeners(txtMFlag, 0, 1);
      JCheckBox mOverlay = new JCheckBox("Overlay (M)");
      mOverlay.setSelected(ToolData.includedBrushProperties[0][2]);
      mOverlay.setBounds(4, shiftY + 115, 125, 24);
      UIPanels.propertiesTabPanel.add(mOverlay);
      this.propertyComponents.put("chck_overlay", mOverlay);
      this.addCheckboxListener(mOverlay, 0, 2, "chck_overlay");
      JTextField txtMOverlay = new JTextField("" + ToolData.brushProperties[0][2]);
      txtMOverlay.setBounds(9, shiftY + 137, 125, 22);
      txtMOverlay.setEditable(ToolData.includedBrushProperties[0][2]);
      UIPanels.propertiesTabPanel.add(txtMOverlay);
      this.propertyComponents.put("txt_overlay", txtMOverlay);
      this.addPropertyTextChangedListeners(txtMOverlay, 0, 2);
      JCheckBox mUnderlay = new JCheckBox("Underlay (M)");
      mUnderlay.setSelected(ToolData.includedBrushProperties[0][3]);
      mUnderlay.setBounds(4, shiftY + 161, 125, 24);
      UIPanels.propertiesTabPanel.add(mUnderlay);
      this.propertyComponents.put("chck_underlay", mUnderlay);
      this.addCheckboxListener(mUnderlay, 0, 3, "chck_underlay");
      JTextField txtMUnderlay = new JTextField("" + ToolData.brushProperties[0][3]);
      txtMUnderlay.setBounds(9, shiftY + 184, 125, 22);
      txtMUnderlay.setEditable(ToolData.includedBrushProperties[0][3]);
      UIPanels.propertiesTabPanel.add(txtMUnderlay);
      this.propertyComponents.put("txt_underlay", txtMUnderlay);
      this.addPropertyTextChangedListeners(txtMUnderlay, 0, 3);
      JCheckBox mShape = new JCheckBox("Shape (M)");
      mShape.setSelected(ToolData.includedBrushProperties[0][4]);
      mShape.setBounds(4, shiftY + 207, 125, 24);
      UIPanels.propertiesTabPanel.add(mShape);
      this.propertyComponents.put("chck_shape", mShape);
      this.addCheckboxListener(mShape, 0, 4, "chck_shape");
      JTextField txtMShape = new JTextField("" + ToolData.brushProperties[0][4]);
      txtMShape.setBounds(9, shiftY + 230, 125, 22);
      txtMShape.setEditable(ToolData.includedBrushProperties[0][4]);
      UIPanels.propertiesTabPanel.add(txtMShape);
      this.propertyComponents.put("txt_shape", txtMShape);
      this.addPropertyTextChangedListeners(txtMShape, 0, 4);
      JCheckBox mRotation = new JCheckBox("Rotation (M)");
      mRotation.setSelected(ToolData.includedBrushProperties[0][5]);
      mRotation.setBounds(4, shiftY + 253, 125, 24);
      UIPanels.propertiesTabPanel.add(mRotation);
      this.propertyComponents.put("chck_rotation", mRotation);
      this.addCheckboxListener(mRotation, 0, 5, "chck_rotation");
      JTextField txtMRotation = new JTextField("" + ToolData.brushProperties[0][5]);
      txtMRotation.setBounds(9, shiftY + 276, 125, 22);
      txtMRotation.setEditable(ToolData.includedBrushProperties[0][5]);
      UIPanels.propertiesTabPanel.add(txtMRotation);
      this.propertyComponents.put("txt_rotation", txtMRotation);
      this.addPropertyTextChangedListeners(txtMRotation, 0, 5);
      JSeparator jsep = new JSeparator();
      jsep.setBounds(shiftX + 117, shiftY + 0, 4, 300);
      jsep.setOrientation(1);
      UIPanels.propertiesTabPanel.add(jsep);
      this.propertyComponents.put("sep1", jsep);
      JTextField undermapTitle = new JTextField("   Undermap");
      undermapTitle.setBounds(shiftX + 148, shiftY - 6, 104, 24);
      undermapTitle.setEditable(false);
      undermapTitle.setFont(new Font("", 1, 13));
      undermapTitle.setBackground(Color.DARK_GRAY);
      UIPanels.propertiesTabPanel.add(undermapTitle);
      this.propertyComponents.put("undermap_title", undermapTitle);
      JCheckBox umSelectAll = new JCheckBox("");
      umSelectAll.setSelected(ToolData.includedBrushProperties[0][1]);
      umSelectAll.setBounds(shiftX + 117 + 5, shiftY - 6, 24, 24);
      UIPanels.propertiesTabPanel.add(umSelectAll);
      this.propertyComponents.put("chck_selectallundermap", umSelectAll);
      this.addSelectAllCheckBoxListener(umSelectAll, 1, "chck_selectallundermap");
      JCheckBox umHeight = new JCheckBox("Height (UM)");
      umHeight.setSelected(ToolData.includedBrushProperties[1][0]);
      umHeight.setBounds(shiftX + 117 + 5, shiftY + 20, 125, 24);
      UIPanels.propertiesTabPanel.add(umHeight);
      this.propertyComponents.put("chck_uHeight", umHeight);
      this.addCheckboxListener(umHeight, 1, 0, "chck_uHeight");
      JTextField txtuMHeight = new JTextField("" + ToolData.brushProperties[1][0]);
      txtuMHeight.setBounds(shiftX + 117 + 10, shiftY + 43, 125, 22);
      txtuMHeight.setEditable(ToolData.includedBrushProperties[1][0]);
      UIPanels.propertiesTabPanel.add(txtuMHeight);
      this.propertyComponents.put("txt_uHeight", txtuMHeight);
      this.addPropertyTextChangedListeners(txtuMHeight, 1, 0);
      JCheckBox umOverlay = new JCheckBox("Overlay (UM)");
      umOverlay.setSelected(ToolData.includedBrushProperties[1][1]);
      umOverlay.setBounds(shiftX + 117 + 5, shiftY + 115, 125, 24);
      UIPanels.propertiesTabPanel.add(umOverlay);
      this.propertyComponents.put("chck_uOverlay", umOverlay);
      this.addCheckboxListener(umOverlay, 1, 1, "chck_uOverlay");
      JTextField txtuMOverlay = new JTextField("" + ToolData.brushProperties[1][1]);
      txtuMOverlay.setBounds(shiftX + 117 + 10, shiftY + 137, 125, 22);
      txtuMOverlay.setEditable(ToolData.includedBrushProperties[1][1]);
      UIPanels.propertiesTabPanel.add(txtuMOverlay);
      this.propertyComponents.put("txt_uOverlay", txtuMOverlay);
      this.addPropertyTextChangedListeners(txtuMOverlay, 1, 1);
      JCheckBox umUnderlay = new JCheckBox("Underlay (UM)");
      umUnderlay.setSelected(ToolData.includedBrushProperties[1][2]);
      umUnderlay.setBounds(shiftX + 117 + 5, shiftY + 161, 135, 24);
      UIPanels.propertiesTabPanel.add(umUnderlay);
      this.propertyComponents.put("chck_uUnderlay", umUnderlay);
      this.addCheckboxListener(umUnderlay, 1, 2, "chck_uUnderlay");
      JTextField txtuMUnderlay = new JTextField("" + ToolData.brushProperties[1][2]);
      txtuMUnderlay.setBounds(shiftX + 117 + 10, shiftY + 184, 125, 22);
      txtuMUnderlay.setEditable(ToolData.includedBrushProperties[1][2]);
      UIPanels.propertiesTabPanel.add(txtuMUnderlay);
      this.propertyComponents.put("txt_uUnderlay", txtuMUnderlay);
      this.addPropertyTextChangedListeners(txtuMUnderlay, 1, 2);
      JCheckBox umShape = new JCheckBox("Shape (UM)");
      umShape.setSelected(ToolData.includedBrushProperties[1][3]);
      umShape.setBounds(shiftX + 117 + 5, shiftY + 207, 125, 24);
      UIPanels.propertiesTabPanel.add(umShape);
      this.propertyComponents.put("chck_uShape", umShape);
      this.addCheckboxListener(umShape, 1, 3, "chck_uShape");
      JTextField txtuMShape = new JTextField("" + ToolData.brushProperties[1][3]);
      txtuMShape.setBounds(shiftX + 117 + 10, shiftY + 230, 125, 22);
      txtuMShape.setEditable(ToolData.includedBrushProperties[1][3]);
      UIPanels.propertiesTabPanel.add(txtuMShape);
      this.propertyComponents.put("txt_uShape", txtuMShape);
      this.addPropertyTextChangedListeners(txtuMShape, 1, 3);
      JCheckBox umRotation = new JCheckBox("Rotation (UM)");
      umRotation.setSelected(ToolData.includedBrushProperties[1][4]);
      umRotation.setBounds(shiftX + 117 + 5, shiftY + 253, 135, 24);
      UIPanels.propertiesTabPanel.add(umRotation);
      this.propertyComponents.put("chck_uRotation", umRotation);
      this.addCheckboxListener(umRotation, 1, 4, "chck_uRotation");
      JTextField txtuMRotation = new JTextField("" + ToolData.brushProperties[1][4]);
      txtuMRotation.setBounds(shiftX + 117 + 10, shiftY + 276, 125, 22);
      txtuMRotation.setEditable(ToolData.includedBrushProperties[1][4]);
      UIPanels.propertiesTabPanel.add(txtuMRotation);
      this.propertyComponents.put("txt_uRotation", txtuMRotation);
      this.addPropertyTextChangedListeners(txtuMRotation, 1, 4);
      JButton applyPropertiesAction = new JButton("Apply to Selected");
      applyPropertiesAction.setBounds(6, shiftY + 303, 281, 26);
      applyPropertiesAction.setFont(new Font("Tahoma", 1, 16));
      applyPropertiesAction.setForeground(new Color(237, 183, 90));
      applyPropertiesAction.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            BrushTool.this.applyAction(ToolData.ActionValues.BRUSH_APPLY.getValue());
         }
      });
      UIPanels.propertiesTabPanel.add(applyPropertiesAction);
      this.propertyComponents.put("apply_properties", applyPropertiesAction);
      shiftY -= 15;
      JButton resetFields = new JButton("Reset Fields");
      resetFields.setBounds(6, shiftY + 348, 281, 26);
      resetFields.setFont(new Font("Tahoma", 1, 16));
      resetFields.setForeground(Color.RED);
      resetFields.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ((JTextField)BrushTool.this.propertyComponents.get("txt_height")).setText("0");
            ((JTextField)BrushTool.this.propertyComponents.get("txt_tileflag")).setText("0");
            ((JTextField)BrushTool.this.propertyComponents.get("txt_overlay")).setText("0");
            ((JTextField)BrushTool.this.propertyComponents.get("txt_underlay")).setText("0");
            ((JTextField)BrushTool.this.propertyComponents.get("txt_shape")).setText("0");
            ((JTextField)BrushTool.this.propertyComponents.get("txt_rotation")).setText("0");
            ((JTextField)BrushTool.this.propertyComponents.get("txt_uHeight")).setText("0");
            ((JTextField)BrushTool.this.propertyComponents.get("txt_uOverlay")).setText("0");
            ((JTextField)BrushTool.this.propertyComponents.get("txt_uUnderlay")).setText("0");
            ((JTextField)BrushTool.this.propertyComponents.get("txt_uShape")).setText("0");
            ((JTextField)BrushTool.this.propertyComponents.get("txt_uRotation")).setText("0");
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.propertiesTabPanel.add(resetFields);
      this.propertyComponents.put("reset_fields", resetFields);
      JButton loadTile = new JButton("Load Last Selected Tile");
      loadTile.setBounds(6, shiftY + 385, 281, 26);
      loadTile.setFont(new Font("Tahoma", 1, 16));
      loadTile.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               WorldTile tile = RSMapperClient.editor.selectedTile;
               if (tile != null) {
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_height"))
                     .setText("" + RSMapperClient.editor.mapEditor.getMapValueFromTile(tile, MapEditor.PropertyType.HEIGHT));
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_tileflag"))
                     .setText("" + RSMapperClient.editor.mapEditor.getMapValueFromTile(tile, MapEditor.PropertyType.TILE_FLAG));
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_overlay"))
                     .setText("" + RSMapperClient.editor.mapEditor.getMapValueFromTile(tile, MapEditor.PropertyType.OVERLAY));
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_underlay"))
                     .setText("" + RSMapperClient.editor.mapEditor.getMapValueFromTile(tile, MapEditor.PropertyType.UNDERLAY));
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_shape"))
                     .setText("" + RSMapperClient.editor.mapEditor.getMapValueFromTile(tile, MapEditor.PropertyType.SHAPE));
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_rotation"))
                     .setText("" + RSMapperClient.editor.mapEditor.getMapValueFromTile(tile, MapEditor.PropertyType.ROTATION));
                  if (tile.getPlane() == 0) {
                     ((JTextField)BrushTool.this.propertyComponents.get("txt_uHeight"))
                        .setText("" + RSMapperClient.editor.mapEditor.getUndermapValueFromTile(tile, MapEditor.PropertyType.HEIGHT));
                     ((JTextField)BrushTool.this.propertyComponents.get("txt_uOverlay"))
                        .setText("" + RSMapperClient.editor.mapEditor.getUndermapValueFromTile(tile, MapEditor.PropertyType.OVERLAY));
                     ((JTextField)BrushTool.this.propertyComponents.get("txt_uUnderlay"))
                        .setText("" + RSMapperClient.editor.mapEditor.getUndermapValueFromTile(tile, MapEditor.PropertyType.UNDERLAY));
                     ((JTextField)BrushTool.this.propertyComponents.get("txt_uShape"))
                        .setText("" + RSMapperClient.editor.mapEditor.getUndermapValueFromTile(tile, MapEditor.PropertyType.SHAPE));
                     ((JTextField)BrushTool.this.propertyComponents.get("txt_uRotation"))
                        .setText("" + RSMapperClient.editor.mapEditor.getUndermapValueFromTile(tile, MapEditor.PropertyType.ROTATION));
                  } else {
                     ((JTextField)BrushTool.this.propertyComponents.get("txt_uHeight")).setText("0");
                     ((JTextField)BrushTool.this.propertyComponents.get("txt_uOverlay")).setText("0");
                     ((JTextField)BrushTool.this.propertyComponents.get("txt_uUnderlay")).setText("0");
                     ((JTextField)BrushTool.this.propertyComponents.get("txt_uShape")).setText("0");
                     ((JTextField)BrushTool.this.propertyComponents.get("txt_uRotation")).setText("0");
                  }
   
                  RSMapperClient.setFocusOnCanvas();
               }
            }
         }
      );
      UIPanels.propertiesTabPanel.add(loadTile);
      this.propertyComponents.put("load_tile_properties", loadTile);
      JButton loadCopied = new JButton("Load Copied Properties");
      loadCopied.setBounds(6, shiftY + 415, 281, 26);
      loadCopied.setFont(new Font("Tahoma", 1, 16));
      loadCopied.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            WorldTile tile = RSMapperClient.editor.selectedTile;
            if (tile != null) {
               ((JTextField)BrushTool.this.propertyComponents.get("txt_height")).setText("" + ToolData.copiedProperties[0][0]);
               ((JTextField)BrushTool.this.propertyComponents.get("txt_tileflag")).setText("" + ToolData.copiedProperties[0][1]);
               ((JTextField)BrushTool.this.propertyComponents.get("txt_overlay")).setText("" + ToolData.copiedProperties[0][2]);
               ((JTextField)BrushTool.this.propertyComponents.get("txt_underlay")).setText("" + ToolData.copiedProperties[0][3]);
               ((JTextField)BrushTool.this.propertyComponents.get("txt_shape")).setText("" + ToolData.copiedProperties[0][4]);
               ((JTextField)BrushTool.this.propertyComponents.get("txt_rotation")).setText("" + ToolData.copiedProperties[0][5]);
               if (tile.getPlane() == 0) {
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_uHeight")).setText("" + ToolData.copiedProperties[1][0]);
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_uOverlay")).setText("" + ToolData.copiedProperties[1][1]);
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_uUnderlay")).setText("" + ToolData.copiedProperties[1][2]);
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_uShape")).setText("" + ToolData.copiedProperties[1][3]);
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_uRotation")).setText("" + ToolData.copiedProperties[1][4]);
               } else {
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_uHeight")).setText("0");
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_uOverlay")).setText("0");
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_uUnderlay")).setText("0");
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_uShape")).setText("0");
                  ((JTextField)BrushTool.this.propertyComponents.get("txt_uRotation")).setText("0");
               }

               RSMapperClient.setFocusOnCanvas();
            }
         }
      });
      UIPanels.propertiesTabPanel.add(loadCopied);
      this.propertyComponents.put("load_copied_properties", loadCopied);
      JTextField objectsTitle = new JTextField();
      objectsTitle.setBounds(4, 4, 285, 24);
      objectsTitle.setHorizontalAlignment(0);
      objectsTitle.setEditable(false);
      objectsTitle.setText("BRUSH OBJECTS");
      objectsTitle.setFont(new Font("", 1, 16));
      UIPanels.objectsTabPanel.add(objectsTitle);
      this.objectComponents.put("objects_title", objectsTitle);
      int var64 = 22;
      JTextField[] objectInputTitles = new JTextField[3];

      for(int j = 0; j < 3; ++j) {
         objectInputTitles[j] = new JTextField();
         objectInputTitles[j].setBounds((j > 0 ? 26 : 30) + j * 86, var64 + 10, j == 0 ? 30 : (j == 2 ? 60 : 43), 24);
         objectInputTitles[j].setEditable(false);
         UIPanels.objectsTabPanel.add(objectInputTitles[j]);
         this.objectComponents.put("object_input_title" + j, objectInputTitles[j]);
      }

      objectInputTitles[0].setText("ID:");
      objectInputTitles[1].setText("TYPE:");
      objectInputTitles[2].setText("ROTATE:");
      final JTextField inputId = new JTextField("" + ToolData.brushIncludedObjectId[0]);
      inputId.setEditable(ToolData.brushIncludedObjectSlots[0]);
      inputId.setBounds(59, var64 + 10, 53, 24);
      this.addObjectChangedListeners(inputId, 0, 0);
      UIPanels.objectsTabPanel.add(inputId);
      this.objectComponents.put("input_id", inputId);
      final JTextField inputType = new JTextField("" + ToolData.brushIncludedObjectType[0]);
      inputType.setEditable(ToolData.brushIncludedObjectSlots[0]);
      inputType.setBounds(154, var64 + 10, 44, 24);
      this.addObjectChangedListeners(inputType, 0, 1);
      UIPanels.objectsTabPanel.add(inputType);
      this.objectComponents.put("input_type", inputType);
      final JTextField inputRotation = new JTextField("" + ToolData.brushIncludedObjectRotation[0]);
      inputRotation.setEditable(ToolData.brushIncludedObjectSlots[0]);
      inputRotation.setBounds(256, var64 + 10, 32, 24);
      this.addObjectChangedListeners(inputRotation, 0, 2);
      UIPanels.objectsTabPanel.add(inputRotation);
      this.objectComponents.put("input_rotation", inputRotation);
      JTextField[] objectInputTitles2 = new JTextField[3];

      for(int j = 0; j < 3; ++j) {
         objectInputTitles2[j] = new JTextField();
         objectInputTitles2[j].setBounds((j > 0 ? 26 : 30) + j * 86, var64 + 38, j == 0 ? 30 : (j == 2 ? 60 : 43), 24);
         objectInputTitles2[j].setEditable(false);
         UIPanels.objectsTabPanel.add(objectInputTitles2[j]);
         this.objectComponents.put("object_input1_title" + j, objectInputTitles2[j]);
      }

      objectInputTitles2[0].setText("ID:");
      objectInputTitles2[1].setText("TYPE:");
      objectInputTitles2[2].setText("ROTATE:");
      final JTextField inputId1 = new JTextField("" + ToolData.brushIncludedObjectId[1]);
      inputId1.setEditable(ToolData.brushIncludedObjectSlots[1]);
      inputId1.setBounds(59, var64 + 38, 53, 24);
      this.addObjectChangedListeners(inputId1, 1, 0);
      UIPanels.objectsTabPanel.add(inputId1);
      this.objectComponents.put("input_id1", inputId1);
      final JTextField inputType1 = new JTextField("" + ToolData.brushIncludedObjectType[1]);
      inputType1.setEditable(ToolData.brushIncludedObjectSlots[1]);
      inputType1.setBounds(154, var64 + 38, 44, 24);
      this.addObjectChangedListeners(inputType1, 1, 1);
      UIPanels.objectsTabPanel.add(inputType1);
      this.objectComponents.put("input_type1", inputType1);
      final JTextField inputRotation1 = new JTextField("" + ToolData.brushIncludedObjectRotation[1]);
      inputRotation1.setEditable(ToolData.brushIncludedObjectSlots[1]);
      inputRotation1.setBounds(256, var64 + 38, 32, 24);
      this.addObjectChangedListeners(inputRotation1, 1, 2);
      UIPanels.objectsTabPanel.add(inputRotation1);
      this.objectComponents.put("input_rotation1", inputRotation1);
      JTextField[] objectInputTitles3 = new JTextField[3];

      for(int j = 0; j < 3; ++j) {
         objectInputTitles3[j] = new JTextField();
         objectInputTitles3[j].setBounds((j > 0 ? 26 : 30) + j * 86, var64 + 67, j == 0 ? 30 : (j == 2 ? 60 : 43), 24);
         objectInputTitles3[j].setEditable(false);
         UIPanels.objectsTabPanel.add(objectInputTitles3[j]);
         this.objectComponents.put("object_input2_title" + j, objectInputTitles3[j]);
      }

      objectInputTitles3[0].setText("ID:");
      objectInputTitles3[1].setText("TYPE:");
      objectInputTitles3[2].setText("ROTATE:");
      final JTextField inputId2 = new JTextField("" + ToolData.brushIncludedObjectId[2]);
      inputId2.setEditable(ToolData.brushIncludedObjectSlots[2]);
      inputId2.setBounds(59, var64 + 67, 53, 24);
      this.addObjectChangedListeners(inputId2, 2, 0);
      UIPanels.objectsTabPanel.add(inputId2);
      this.objectComponents.put("input_id2", inputId2);
      final JTextField inputType2 = new JTextField("" + ToolData.brushIncludedObjectType[2]);
      inputType2.setEditable(ToolData.brushIncludedObjectSlots[2]);
      inputType2.setBounds(154, var64 + 67, 44, 24);
      this.addObjectChangedListeners(inputType2, 2, 1);
      UIPanels.objectsTabPanel.add(inputType2);
      this.objectComponents.put("input_type2", inputType2);
      final JTextField inputRotation2 = new JTextField("" + ToolData.brushIncludedObjectRotation[2]);
      inputRotation2.setEditable(ToolData.brushIncludedObjectSlots[2]);
      inputRotation2.setBounds(256, var64 + 67, 32, 24);
      this.addObjectChangedListeners(inputRotation2, 2, 2);
      UIPanels.objectsTabPanel.add(inputRotation2);
      this.objectComponents.put("input_rotation2", inputRotation2);
      final JCheckBox randomize0 = new JCheckBox();
      final JCheckBox randomize1 = new JCheckBox();
      final JCheckBox randomize2 = new JCheckBox();
      randomize0.setSelected(ToolData.brushIncludedObjectSlots[0]);
      randomize0.setBounds(4, var64 + 7, 26, 30);
      randomize0.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (!randomize0.isSelected()) {
               boolean cannotDeselect = true;

               for(int i = 0; i < ToolData.brushIncludedObjectSlots.length; ++i) {
                  if (i != 0 && ToolData.brushIncludedObjectSlots[i]) {
                     cannotDeselect = false;
                     break;
                  }
               }

               if (cannotDeselect) {
                  randomize0.setSelected(true);
               }
            }

            inputId.setEditable(randomize0.isSelected());
            inputType.setEditable(randomize0.isSelected());
            inputRotation.setEditable(randomize0.isSelected());
            ToolData.brushIncludedObjectSlots[0] = randomize0.isSelected();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(randomize0);
      this.objectComponents.put("toggle_obj0", randomize0);
      randomize1.setSelected(ToolData.brushIncludedObjectSlots[1]);
      randomize1.setBounds(4, var64 + 35, 26, 30);
      randomize1.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (!randomize1.isSelected()) {
               boolean cannotDeselect = true;

               for(int i = 0; i < ToolData.brushIncludedObjectSlots.length; ++i) {
                  if (i != 1 && ToolData.brushIncludedObjectSlots[i]) {
                     cannotDeselect = false;
                     break;
                  }
               }

               if (cannotDeselect) {
                  randomize1.setSelected(true);
               }
            }

            inputId1.setEditable(randomize1.isSelected());
            inputType1.setEditable(randomize1.isSelected());
            inputRotation1.setEditable(randomize1.isSelected());
            ToolData.brushIncludedObjectSlots[1] = randomize1.isSelected();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(randomize1);
      this.objectComponents.put("toggle_obj1", randomize1);
      randomize2.setSelected(ToolData.brushIncludedObjectSlots[2]);
      randomize2.setBounds(4, var64 + 63, 26, 30);
      randomize2.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (!randomize2.isSelected()) {
               boolean cannotDeselect = true;

               for(int i = 0; i < ToolData.brushIncludedObjectSlots.length; ++i) {
                  if (i != 2 && ToolData.brushIncludedObjectSlots[i]) {
                     cannotDeselect = false;
                     break;
                  }
               }

               if (cannotDeselect) {
                  randomize2.setSelected(true);
               }
            }

            inputId2.setEditable(randomize2.isSelected());
            inputType2.setEditable(randomize2.isSelected());
            inputRotation2.setEditable(randomize2.isSelected());
            ToolData.brushIncludedObjectSlots[2] = randomize2.isSelected();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(randomize2);
      this.objectComponents.put("toggle_obj2", randomize2);
      JButton btnSpawn = new JButton("Spawn Object(s)");
      btnSpawn.setBounds(4, var64 + 95, 285, 24);
      btnSpawn.setFont(new Font("Tahoma", 1, 16));
      btnSpawn.setForeground(Color.GREEN);
      btnSpawn.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            BrushTool.this.applyAction(ToolData.ActionValues.BRUSH_SPAWN.getValue());
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(btnSpawn);
      this.objectComponents.put("spawn_object", btnSpawn);
      JButton btnRemove = new JButton("Remove Object(s)");
      btnRemove.setBounds(4, var64 + 121, 285, 24);
      btnRemove.setFont(new Font("Tahoma", 1, 16));
      btnRemove.setForeground(Color.red);
      btnRemove.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            BrushTool.this.applyAction(ToolData.ActionValues.BRUSH_REMOVE.getValue());
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(btnRemove);
      this.objectComponents.put("remove_object", btnRemove);
      JTextField[][] objectTitles = new JTextField[4][3];
      final JTextField[][] objectsOnTile = new JTextField[4][3];
      JButton[] selectButtons = new JButton[4];
      var64 = 20;
      JTextField editingTileTitle = new JTextField();
      editingTileTitle.setBounds(4, var64 + 150, 285, 24);
      editingTileTitle.setHorizontalAlignment(0);
      editingTileTitle.setEditable(false);
      editingTileTitle.setText("OBJECTS ON SELECTED TILE");
      editingTileTitle.setFont(new Font("", 1, 16));
      UIPanels.objectsTabPanel.add(editingTileTitle);
      this.objectComponents.put("object_editing_title", editingTileTitle);

      for(int i = 0; i < 4; ++i) {
         for(int j = 0; j < 3; ++j) {
            objectTitles[i][j] = new JTextField();
            objectTitles[i][j].setBounds(4 + j * 86 + (j == 1 ? -9 : (j == 2 ? -29 : 0)), var64 + 178 + 1 * i * 25, j == 2 ? 58 : 36, 24);
            objectTitles[i][j].setEditable(false);
            UIPanels.objectsTabPanel.add(objectTitles[i][j]);
            this.objectComponents.put("object_title" + i + "_" + j, objectTitles[i][j]);
            objectsOnTile[i][j] = new JTextField();
            objectsOnTile[i][j].setBounds(47 + 35 * j * 2 + (j == 0 ? -7 : (j == 1 ? -1 : (j == 2 ? 18 : 0))), var64 + 178 + i * 25, j == 0 ? 40 : 30, 24);
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
         selectButtons[i].setBounds(235, var64 + 176 + i * 25, 52, 24);
         selectButtons[i].setForeground(Color.BLUE);
         selectButtons[i].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               for(int i = ToolData.brushIncludedObjectId.length - 1; i >= 0; --i) {
                  if (ToolData.brushIncludedObjectSlots[i]) {
                     if (!objectsOnTile[i][0].getText().isEmpty()) {
                        int id = Integer.parseInt(objectsOnTile[i][0].getText().trim());
                        ToolData.brushIncludedObjectId[i] = id;
                        ((JTextField)UIPanels.objectComponents.get("input_id" + (i == 0 ? "" : i))).setText("" + id);
                     }

                     if (!objectsOnTile[i][1].getText().isEmpty()) {
                        int type = Integer.parseInt(objectsOnTile[i][1].getText().trim());
                        ToolData.brushIncludedObjectType[i] = type;
                        ((JTextField)UIPanels.objectComponents.get("input_type" + (i == 0 ? "" : i))).setText("" + type);
                     }

                     if (!objectsOnTile[i][2].getText().isEmpty()) {
                        int rotation = Integer.parseInt(objectsOnTile[i][2].getText().trim());
                        ToolData.brushIncludedObjectRotation[i] = rotation;
                        ((JTextField)UIPanels.objectComponents.get("input_rotation" + (i == 0 ? "" : i))).setText("" + rotation);
                     }
                     break;
                  }
               }

               RSMapperClient.setFocusOnCanvas();
            }
         });
         UIPanels.objectsTabPanel.add(selectButtons[i]);
         this.objectComponents.put("select_button" + i, selectButtons[i]);
      }

      JTextField settingsTitle = new JTextField();
      settingsTitle.setBounds(4, var64 + 283, 285, 24);
      settingsTitle.setHorizontalAlignment(0);
      settingsTitle.setEditable(false);
      settingsTitle.setText("SETTINGS");
      settingsTitle.setFont(new Font("", 1, 16));
      UIPanels.objectsTabPanel.add(settingsTitle);
      this.objectComponents.put("object_settings_title", settingsTitle);
      final JCheckBox toggleRandomRotation = new JCheckBox("Random rotation");
      toggleRandomRotation.setToolTipText("Randomize rotation on spawn");
      toggleRandomRotation.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      toggleRandomRotation.setBorderPainted(true);
      toggleRandomRotation.setSelected(ToolData.brushObjectRandomizeRotation);
      toggleRandomRotation.setBounds(5, var64 + 312, 136, 30);
      toggleRandomRotation.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ToolData.brushObjectRandomizeRotation = toggleRandomRotation.isSelected();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(toggleRandomRotation);
      this.objectComponents.put("toggle_random_rotation", toggleRandomRotation);
      final JCheckBox removeAll = new JCheckBox("Remove all");
      removeAll.setToolTipText("Removes all rather than selected type");
      removeAll.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      removeAll.setBorderPainted(true);
      removeAll.setSelected(ToolData.brushObjectRemoveAll);
      removeAll.setBounds(5, var64 + 312 + 30, 136, 30);
      removeAll.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ToolData.brushObjectRemoveAll = removeAll.isSelected();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(removeAll);
      this.objectComponents.put("toggle_obj_remove_all", removeAll);
      JSeparator sepSettings = new JSeparator(1);
      sepSettings.setBounds(145, var64 + 306, 3, 150);
      UIPanels.objectsTabPanel.add(sepSettings);
      this.objectComponents.put("settings_sep1", sepSettings);
      final JCheckBox copyAbovePlanes = new JCheckBox("C / P above planes");
      copyAbovePlanes.setToolTipText("Copy objects on all planes above selected");
      copyAbovePlanes.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      copyAbovePlanes.setBorderPainted(true);
      copyAbovePlanes.setSelected(ToolData.brushObjectCopyAbovePlanes);
      copyAbovePlanes.setBounds(151, var64 + 312, 136, 30);
      copyAbovePlanes.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ToolData.brushObjectCopyAbovePlanes = copyAbovePlanes.isSelected();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(copyAbovePlanes);
      this.objectComponents.put("toggle_obj_copy_above_planes", copyAbovePlanes);
      final JCheckBox deleteOnCopy = new JCheckBox("Remove on copy");
      deleteOnCopy.setToolTipText("Remove all objects on tiles when copied");
      deleteOnCopy.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      deleteOnCopy.setBorderPainted(true);
      deleteOnCopy.setSelected(ToolData.brushObjectDeleteOnCopy);
      deleteOnCopy.setBounds(151, var64 + 312 + 30, 136, 30);
      deleteOnCopy.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            ToolData.brushObjectDeleteOnCopy = deleteOnCopy.isSelected();
            RSMapperClient.setFocusOnCanvas();
         }
      });
      UIPanels.objectsTabPanel.add(deleteOnCopy);
      this.objectComponents.put("toggle_obj_delete_on_copy", deleteOnCopy);
   }

   private void addCheckboxListener(final JCheckBox checkbox, final int type, final int property, final String name) {
      checkbox.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            ToolData.includedBrushProperties[type][property] = checkbox.isSelected();

            for(String n : BrushTool.this.propertyComponents.keySet()) {
               if (n.contains("txt_") && n.contains(name.substring(name.indexOf("_"), name.length()))) {
                  ((JTextField)BrushTool.this.propertyComponents.get(n)).setEditable(checkbox.isSelected());
                  break;
               }
            }
         }
      });
   }

   private void addSelectAllCheckBoxListener(final JCheckBox checkbox, final int type, String name) {
      checkbox.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            for(JComponent next : BrushTool.this.propertyComponents.values()) {
               if (next instanceof JCheckBox && ((JCheckBox)next).getText().contains(type == 0 ? "(M)" : "(UM)")) {
                  JCheckBox iterCheckBox = (JCheckBox)next;
                  if (checkbox.isSelected()) {
                     if (!iterCheckBox.isSelected()) {
                        iterCheckBox.doClick();
                     }
                  } else if (iterCheckBox.isSelected()) {
                     iterCheckBox.doClick();
                  }
               }
            }
         }
      });
   }

   private void addPropertyTextChangedListeners(final JTextField field, final int type, final int property) {
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
                        ToolData.brushProperties[type][property] = value;
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
                        ToolData.brushProperties[type][property] = value;
                     } catch (NumberFormatException var2) {
                     }
                  }
               };
               SwingUtilities.invokeLater(doChange);
            }
         }
      });
   }

   private void addObjectChangedListeners(final JTextField field, final int fieldIndex, final int index) {
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
                        switch(index) {
                           case 0:
                              ToolData.brushIncludedObjectId[fieldIndex] = value;
                              break;
                           case 1:
                              if (value > 22) {
                                 value = 22;
                              } else if (value < 0) {
                                 value = 0;
                              }

                              ToolData.brushIncludedObjectType[fieldIndex] = value;
                              break;
                           case 2:
                              if (value > 3) {
                                 value = 3;
                              } else if (value < 0) {
                                 value = 0;
                              }

                              ToolData.brushIncludedObjectRotation[fieldIndex] = value;
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
                        switch(index) {
                           case 0:
                              ToolData.brushIncludedObjectId[fieldIndex] = value;
                              break;
                           case 1:
                              if (value > 22) {
                                 value = 22;
                              } else if (value < 0) {
                                 value = 0;
                              }

                              ToolData.brushIncludedObjectType[fieldIndex] = value;
                              break;
                           case 2:
                              if (value > 3) {
                                 value = 3;
                              } else if (value < 0) {
                                 value = 0;
                              }

                              ToolData.brushIncludedObjectRotation[fieldIndex] = value;
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
