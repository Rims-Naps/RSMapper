import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;

public abstract class Tool {
   int timesTileIsClicked = 1;
   int[] doubleClickActionValue;
   ConcurrentHashMap<String, JComponent> propertyComponents;
   ConcurrentHashMap<String, JComponent> objectComponents;

   public abstract void setupUI();

   public abstract EditorType getType();

   public abstract String[] getActionText();

   public abstract int[] getActionValues();

   public abstract void setDoubleClickAction(int var1, boolean var2, boolean var3);

   public abstract BrushType[] getAllowedBrushes();

   public abstract void applyAction(int var1);

   public boolean supportsMulti() {
      return false;
   }

   public ConcurrentHashMap<String, JComponent> getComponents(EditorType type) {
      return type == EditorType.OBJECTS ? this.objectComponents : this.propertyComponents;
   }

   public void init() {
      if (RSMapperClient.editor != null && RSMapperClient.editor.editing != null) {
         this.setupDoubleClickActionCB();
      }

      this.setFields();
   }

   public void setFields() {
      if (RSMapperClient.editor != null
         && RSMapperClient.editor.objectEditor != null
         && RSMapperClient.editor.objectEditor.cachedObjects != null
         && RSMapperClient.editor.selectedTile != null
         && RSMapperClient.editor.selectedTile.getX() > 0
         && RSMapperClient.editor.selectedTile.getY() > 0) {
         RSMapperClient.editor.objectEditor.populateTable(RSMapperClient.editor.selectedTile);
      }

      if (RSMapperClient.editor != null
         && RSMapperClient.editor.mapEditor != null
         && RSMapperClient.editor.mapEditor.dataLoaded
         && RSMapperClient.editor.selectedTile != null
         && RSMapperClient.editor.selectedTile.getX() > 0
         && RSMapperClient.editor.selectedTile.getY() > 0) {
         RSMapperClient.editor.mapEditor.populateTable(RSMapperClient.editor.selectedTile);
      }
   }

   public int getTimesTileClicked() {
      return this.timesTileIsClicked;
   }

   public void setTimesTileClicked(int count) {
      this.timesTileIsClicked = count;
   }

   public void incrementTimesTileClicked() {
      ++this.timesTileIsClicked;
   }

   public void setEditingTiles(int localX, int localY, int plane, int actionValue) {
      RSMapperClient.editor.setSelectedTile(new WorldTile(localX, localY, plane, true));
      if (RSMapperClient.editor.brush.isMulti() && RSMapperClient.editor.tool.supportsMulti()) {
         int[] ints = RSMapperClient.editor.tool.getActionValues();
         List<Integer> values = null;
         if (ints != null) {
            values = new ArrayList<>(ints.length);

            for(int i : ints) {
               values.add(i);
            }
         }

         if (values != null && !values.contains(actionValue)) {
            for(WorldTile t : RSMapperClient.editor.brush.getTilesBasedOnBrushAndSize(localX, localY, plane, true)) {
               RSMapperClient.editor.addToSelectedTiles(t);
            }
         }
      }
   }

   public boolean handleTileClick(int localX, int localY, int plane, int actionValue) {
      boolean doubleClick = RSMapperClient.editor.getClickedTile().getLocalX() == localX
         && RSMapperClient.editor.getClickedTile().getLocalY() == localY
         && RSMapperClient.editor.getClickedTile().getPlane() == plane;
      this.setEditingTiles(localX, localY, plane, actionValue);
      if (actionValue > 2) {
         this.applyAction(actionValue);
      } else if (doubleClick && actionValue == 1 && RSMapperClient.editor.isDoubleClickActionActivated()) {
         if (this.doubleClickActionValue[RSMapperClient.editor.editing.ordinal()] == ToolData.ActionValues.TELEPORT.getValue()) {
            Class78.sendTeleport(localX + Node_Sub53.gameSceneBaseX, Class320_Sub4.gameSceneBaseY + localY, plane, true);
         } else {
            this.applyAction(this.doubleClickActionValue[RSMapperClient.editor.editing.ordinal()]);
         }
      }

      return true;
   }

   public void handleTileHover(int localX, int localY) {
      if (Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false) == 1) {
         for(WorldTile tile : RSMapperClient.editor.brush.getTilesBasedOnBrushAndSize(localX, localY, Class295.myPlayer.plane, true)) {
            if (tile.isWithinRegionBounds()) {
               r.createTileMarker(tile.getLocalX(), tile.getLocalY(), Class295.myPlayer.plane, 0, RSMapperClient.settings.hoverOverlayColor, 0);
            } else {
               r.createTileMarker(tile.getLocalX(), tile.getLocalY(), tile.getPlane(), 0, 5987416, 0);
            }
         }
      } else {
         ArrayList<WorldTile> inBounds = new ArrayList<>();

         for(WorldTile tile : RSMapperClient.editor.brush.getTilesBasedOnBrushAndSize(localX, localY, Class295.myPlayer.plane, true)) {
            if (!tile.equals(RSMapperClient.editor.selectedTile)
               && (!RSMapperClient.editor.brush.isMulti() || !RSMapperClient.editor.selectedTiles.contains(tile))) {
               int x = tile.getLocalX();
               int y = tile.getLocalY();
               int p = tile.getPlane();
               if (x < 104 && x >= 0 && y < 104 && y >= 0 && p >= 0 && p < 4) {
                  if (tile.isWithinRegionBounds()) {
                     inBounds.add(tile);
                  } else if (Class167.anInt2033 < Node_Sub25_Sub2.aClass54Array9959.length - 2) {
                     Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asTileBorder(21, x, y, p);
                     Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asVerticeHighlight(21, x, y, p);
                  }
               }
            }
         }

         for(WorldTile tile : inBounds) {
            if (!tile.equals(RSMapperClient.editor.selectedTile)
               && (!RSMapperClient.editor.brush.isMulti() || !RSMapperClient.editor.selectedTiles.contains(tile))) {
               int x = tile.getLocalX();
               int y = tile.getLocalY();
               int p = tile.getPlane();
               if (Class167.anInt2033 < Node_Sub25_Sub2.aClass54Array9959.length - 2) {
                  Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asTileBorder(
                     !tile.equals(RSMapperClient.editor.selectedTile)
                           && (!RSMapperClient.editor.brush.isMulti() || !RSMapperClient.editor.selectedTiles.contains(tile))
                        ? 20
                        : 23,
                     x,
                     y,
                     p
                  );
                  Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asVerticeHighlight(22, x, y, p);
               }
            }
         }

         RSMapperClient.editor.tool.createTileMarkers();
      }
   }

   public void createTileMarkers() {
      if (Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false) == 1) {
         if (RSMapperClient.editor.brush.isMulti() && RSMapperClient.editor.tool.supportsMulti()) {
            for(WorldTile tile : RSMapperClient.editor.selectedTiles) {
               if (tile.isWithinRegionBounds()) {
                  r.createTileMarker(tile.getLocalX(), tile.getLocalY(), tile.getPlane(), 0, RSMapperClient.settings.selectedOverlayColor, 1);
               } else {
                  r.createTileMarker(tile.getLocalX(), tile.getLocalY(), tile.getPlane(), 0, 14878985, 1);
                  r.createTextMarker(
                     "" + Utils.getRegionId(tile.getX(), tile.getY()),
                     Utils.getLocalXFromCoordX(tile.getX(), RSMapperClient.regionId),
                     Utils.getLocalYFromCoordY(tile.getY(), RSMapperClient.regionId),
                     Class295.myPlayer.plane,
                     30,
                     16777215,
                     1
                  );
               }
            }
         } else if (RSMapperClient.editor.selectedTile.isWithinRegionBounds()) {
            r.createTileMarker(
               RSMapperClient.editor.selectedTile.getLocalX(),
               RSMapperClient.editor.selectedTile.getLocalY(),
               RSMapperClient.editor.selectedTile.getPlane(),
               0,
               RSMapperClient.settings.selectedOverlayColor,
               1
            );
         } else {
            r.createTileMarker(
               RSMapperClient.editor.selectedTile.getLocalX(),
               RSMapperClient.editor.selectedTile.getLocalY(),
               RSMapperClient.editor.selectedTile.getPlane(),
               0,
               14878985,
               1
            );
            r.createTextMarker(
               "" + Utils.getRegionId(RSMapperClient.editor.selectedTile.getX(), RSMapperClient.editor.selectedTile.getY()),
               RSMapperClient.editor.selectedTile.getLocalX(),
               RSMapperClient.editor.selectedTile.getLocalY(),
               Class295.myPlayer.plane,
               30,
               16777215,
               1
            );
         }
      } else {
         ArrayList<WorldTile> inBoundTiles = new ArrayList<>();
         ArrayList<WorldTile> outBoundTiles = new ArrayList<>();
         if (RSMapperClient.editor.brush.isMulti() && RSMapperClient.editor.tool.supportsMulti()) {
            for(WorldTile tile : RSMapperClient.editor.selectedTiles) {
               if (tile.isWithinRegionBounds()) {
                  inBoundTiles.add(tile);
               } else {
                  outBoundTiles.add(tile);
               }
            }
         } else if (RSMapperClient.editor.selectedTile.isWithinRegionBounds()) {
            inBoundTiles.add(RSMapperClient.editor.selectedTile);
         } else {
            outBoundTiles.add(RSMapperClient.editor.selectedTile);
         }

         for(WorldTile t : outBoundTiles) {
            if (t.equals(RSMapperClient.editor.selectedTile)) {
               r.createTextMarker("" + Utils.getRegionId(t.getX(), t.getY()), t.getLocalX(), t.getLocalY(), t.getPlane(), 30, 16777215, 1);
            }

            int x = t.getLocalX();
            int y = t.getLocalY();
            int p = t.getPlane();
            if (x < 104 && x >= 0 && y < 104 && y >= 0 && Class167.anInt2033 < Node_Sub25_Sub2.aClass54Array9959.length - 2) {
               Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asTileBorder(22, x, y, t.getPlane());
               Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asVerticeHighlight(22, x, y, p);
            }
         }

         for(WorldTile t : inBoundTiles) {
            int x = t.getLocalX();
            int y = t.getLocalY();
            int p = t.getPlane();
            if (x < 104 && x >= 0 && y < 104 && y >= 0 && Class167.anInt2033 < Node_Sub25_Sub2.aClass54Array9959.length - 2) {
               Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asTileBorder(23, x, y, t.getPlane());
               Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asVerticeHighlight(22, x, y, p);
            }
         }
      }
   }

   public void setTabStates() {
      if (UIPanels.jtpEditing != null) {
         String tab = UIPanels.jtpEditing.getSelectedIndex() == -1 ? "properties" : UIPanels.jtpEditing.getTitleAt(UIPanels.jtpEditing.getSelectedIndex());
         UIPanels.jtpEditing.removeAll();
         if (this.getType() == EditorType.BOTH) {
            UIPanels.jtpEditing
               .addTab("Properties", new ImageIcon("resources/images/tileproperties_icon.png"), UIPanels.propertiesTabPanel, "Edit tile properties");
            UIPanels.jtpEditing.addTab("Objects", new ImageIcon("resources/images/objects_icon.png"), UIPanels.objectsTabPanel, "Edit object spawns");
            if (tab.equalsIgnoreCase("Properties")) {
               UIPanels.jtpEditing.setSelectedIndex(0);
            } else if (tab.equalsIgnoreCase("Objects")) {
               UIPanels.jtpEditing.setSelectedIndex(1);
            }
         } else if (this.getType() == EditorType.PROPERTIES) {
            UIPanels.jtpEditing
               .addTab("Properties", new ImageIcon("resources/images/tileproperties_icon.png"), UIPanels.propertiesTabPanel, "Edit tile properties");
         } else if (this.getType() == EditorType.OBJECTS) {
            UIPanels.jtpEditing.addTab("Objects", new ImageIcon("resources/images/objects_icon.png"), UIPanels.objectsTabPanel, "Edit object spawns");
         }
      }
   }

   public boolean canUseBrush(BrushType type) {
      BrushType[] allowedBrushes = this.getAllowedBrushes();

      for(BrushType bt : allowedBrushes) {
         if (type == bt) {
            return true;
         }
      }

      return false;
   }

   public void setupDoubleClickActionCB() {
      EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            JComboBox<String> cb = (JComboBox)UIPanels.generalComponents.get("cb_doubleclick_action");
            JCheckBox chck = (JCheckBox)UIPanels.generalComponents.get("toggle_doubleclick");
            cb.removeAllItems();
            String[] values = Tool.this.getActionText();
            if (values != null) {
               for(int i = 0; i < values.length; ++i) {
                  cb.addItem(values[i].contains("<") ? values[i].substring(values[i].indexOf(">") + 1, values[i].lastIndexOf("<")) : values[i]);
               }

               cb.addItem("Teleport");
               cb.setEnabled(true);
               chck.setEnabled(true);
            } else {
               cb.setEnabled(false);
               chck.setSelected(false);
               chck.setEnabled(false);
            }

            if (!chck.isSelected()) {
               cb.setEnabled(false);
            }

            if (Tool.this.doubleClickActionValue[RSMapperClient.editor.editing.ordinal()] == ToolData.ActionValues.TELEPORT.getValue()) {
               cb.setSelectedIndex(cb.getItemCount() - 1);
            } else {
               for(int i = 0; i < Tool.this.getActionValues().length; ++i) {
                  int action = Tool.this.getActionValues()[i];
                  if (action == Tool.this.doubleClickActionValue[RSMapperClient.editor.editing.ordinal()]) {
                     cb.setSelectedIndex(i);
                     break;
                  }
               }
            }

            UIPanels.generalComponents.put("toggle_doubleclick", chck);
            UIPanels.generalComponents.put("cb_doubleclick_action", cb);
         }
      });
   }

   public void setupBrushTypeCB(BrushType current) {
      JComboBox<BrushType> cb = (JComboBox)UIPanels.generalComponents.get("cb_brushtype");
      cb.removeAllItems();

      BrushType[] var6;
      for(BrushType brush : var6 = this.getAllowedBrushes()) {
         cb.addItem(brush);
      }

      if (!this.canUseBrush(current)) {
         RSMapperClient.editor.brush.setType(BrushType.SQUARE);
         cb.setSelectedIndex(0);
      } else {
         cb.setSelectedItem(current);
      }

      UIPanels.generalComponents.put("cb_brushtype", cb);
   }
}
