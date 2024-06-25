import com.rs.cache.Cache;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Editor {
   EditorType editing;
   ObjectSpawnEditor objectEditor;
   MapEditor mapEditor;
   WorldmapEditor worldmapEditor;
   DataType dataSelection;
   WorldTile selectedTile;
   Tool tool;
   Brush brush;
   ArrayList<WorldTile> selectedTiles;
   int loadedRegion = -1;
   int loadingRegionProgress = 0;
   String[] loadedRegionFileNames = new String[5];
   int currentMapState;
   MapState[] mapStates;

   public Editor(boolean initial, Brush brush, Tool tool, EditorType editingType, DataType dataType) {
      this.objectEditor = new ObjectSpawnEditor();
      this.mapEditor = new MapEditor();
      this.worldmapEditor = new WorldmapEditor();
      this.selectedTile = new WorldTile(0, 0, 0, false);
      this.selectedTiles = new ArrayList<>();
      this.currentMapState = 0;
      this.mapStates = new MapState[4];
      if (initial) {
         this.editing = EditorType.PROPERTIES;
         this.setTool(new DefaultTool());
         this.setBrush(BrushType.SQUARE, 1, false);
         this.setDataSelection(DataType.NOTES);
      } else {
         this.editing = editingType;
         this.setTool(tool);
         this.setBrush(brush.type, brush.size, brush.isMulti());
         this.setDataSelection(dataType);
      }

      this.setSelectedTile(this.selectedTile);
   }

   public void login(final boolean alreadyLoggedIn) {
      EventQueue.invokeLater(
         new Runnable() {
            @Override
            public void run() {
               try {
                  if (!alreadyLoggedIn) {
                     ((BottomMenu)UIPanels.bottomPanel).drawObjectDefsTree(-2);
                     ((JCheckBox)UIPanels.generalComponents.get("ortho_toggle"))
                        .setSelected(Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false) == 1);
                  } else {
                     JButton buttonTogglePlayer = (JButton)UIPanels.generalComponents.get("toggle_player");
                     if (Class295.myPlayer != null) {
                        Class295.myPlayer.isHidden = true;
                     }
   
                     buttonTogglePlayer.setIcon(new ImageIcon("resources/images/player_hidden_icon.png"));
                     buttonTogglePlayer.setToolTipText("Show Player Model");
                     JButton buttonToggleObj = (JButton)UIPanels.generalComponents.get("toggle_objects");
                     Editor.this.objectEditor.HIDE_OBJECTS = false;
                     buttonToggleObj.setIcon(new ImageIcon("resources/images/objects_shown_icon.png"));
                     buttonToggleObj.setToolTipText("Hide Objects");
                     JButton buttonToggleEnv = (JButton)UIPanels.generalComponents.get("toggle_env");
                     buttonToggleEnv.setIcon(
                        RSMapperClient.settings.disabledEnvironment
                           ? new ImageIcon("resources/images/disable_env.png")
                           : new ImageIcon("resources/images/enable_env.png")
                     );
                     buttonToggleEnv.setToolTipText(RSMapperClient.settings.disabledEnvironment ? "Show Atmosphere" : "Hide Atmosphere");
                  }
   
                  Editor.this.worldmapEditor.load(RSMapperClient.regionId);
                  Editor.this.setSelectedTile(new WorldTile(48, 48, 0, true));
                  synchronized(this) {
                     while(!Editor.this.objectEditor.dataLoaded) {
                        this.wait(100L);
                     }
   
                     Editor.this.setInfoBasedOnSelectedTile();
                  }
               } catch (Exception var5) {
                  var5.printStackTrace();
               }
            }
         }
      );
   }

   public void process() {
      EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            if (Editor.this.loadingRegionProgress == 100) {
               Editor.this.loadingRegionProgress = 0;
               if (WorldmapDefinitions.worldmapIsOpen()) {
                  Class78.MAP_CHANGED = false;
                  Node_Sub25_Sub1.worldmapLoaded = 0;
               } else {
                  Class78.MAP_CHANGED = true;
                  Class78.REFRESH_MINIMAP = true;
               }
            } else if (RSMapperClient.MAP_LOADED) {
               Editor.this.checkForPendingSavingFile();
               KeybindHandler.checkWASD();
               if (Client.ticksSinceDelayedProcess >= 2000L) {
                  Class339_Sub8.method3946(Class313.anInt4013, 0, 0, SeekableFile.index6, false, 23732);
                  Class213.aNode_Sub27_2512.method2690(42, 0, Class213.aNode_Sub27_2512.aClass320_Sub25_7295);
                  Class213.aNode_Sub27_2512.method2690(23, 0, Class213.aNode_Sub27_2512.aClass320_Sub25_7265);
                  Client.ticksSinceDelayedProcess = 0L;
               } else {
                  ++Client.ticksSinceDelayedProcess;
               }
            }
         }
      });
   }

   public void checkForPendingSavingFile() {
      if (!Class78.MAP_CHANGED && !Class78.REFRESH_MINIMAP && this.loadingRegionProgress <= 0) {
         if (this.mapEditor.PACK_MAP) {
            this.mapEditor.PACK_MAP = false;
            this.mapEditor.packToCache(false);
         } else if (this.objectEditor.PACK_LAND) {
            this.objectEditor.PACK_LAND = false;
            this.objectEditor.packToCache(false);
         } else if (this.mapEditor.PACK_UNDERMAP) {
            this.mapEditor.PACK_UNDERMAP = false;
            this.mapEditor.packToCache(true);
         } else if (this.objectEditor.PACK_UNDERLAND) {
            this.objectEditor.PACK_UNDERLAND = false;
            this.objectEditor.packToCache(true);
         }
      }
   }

   public void setTool(Tool tool) {
      this.tool = tool;
      if (this.brush != null) {
         tool.setupBrushTypeCB(this.brush.getType());
         this.brush.setMulti(this.brush.multi);
         this.selectedTiles.clear();
         this.selectedTiles = this.brush.getTilesBasedOnBrushAndSize(this.selectedTile);
      }

      tool.setupUI();
      UIPanels.clearComponents(3);
      UIPanels.clearComponents(2);
      switch(tool.getType()) {
         case PROPERTIES:
            UIPanels.propertyComponents = tool.getComponents(EditorType.PROPERTIES);
            UIPanels.propertiesTabPanel.repaint();
            break;
         case OBJECTS:
            UIPanels.objectComponents = tool.getComponents(EditorType.OBJECTS);
            UIPanels.objectsTabPanel.repaint();
            break;
         case BOTH:
            UIPanels.propertyComponents = tool.getComponents(EditorType.PROPERTIES);
            UIPanels.objectComponents = tool.getComponents(EditorType.OBJECTS);
            UIPanels.propertiesTabPanel.repaint();
            UIPanels.objectsTabPanel.repaint();
      }

      tool.init();
      tool.setTabStates();
      this.setToolButtonBorders();
      RSMapperClient.setFocusOnCanvas();
   }

   public void setEditing(EditorType type) {
      if (this.editing != type) {
         this.editing = type;
         if (this.tool != null) {
            this.tool.init();
         }
      }
   }

   public void setDataSelection(DataType type) {
      if (this.dataSelection != type) {
         this.dataSelection = type;
      }
   }

   public void setBrush(BrushType type, int size, boolean multi) {
      if (this.tool != null && this.brush != null && !this.tool.canUseBrush(type)) {
         this.tool.setupBrushTypeCB(type);
         this.brush.setMulti(this.brush.multi);
      } else {
         this.brush = new Brush(type, size, multi);
      }

      this.selectedTiles.clear();
      this.selectedTiles = this.brush.getTilesBasedOnBrushAndSize(this.selectedTile);
   }

   public void setSelectedTile(int x, int y, int plane, boolean localCoords) {
      this.selectedTile = new WorldTile(x, y, plane, localCoords);
      if (x == 0 && y == 0 && plane == 0) {
         ((JTextField)UIPanels.generalComponents.get("select_x")).setText("");
         ((JTextField)UIPanels.generalComponents.get("select_y")).setText("");
         ((JTextField)UIPanels.generalComponents.get("select_p")).setText("");
      } else {
         ((JTextField)UIPanels.generalComponents.get("select_x")).setText("" + this.selectedTile.getX());
         ((JTextField)UIPanels.generalComponents.get("select_y")).setText("" + this.selectedTile.getY());
         ((JTextField)UIPanels.generalComponents.get("select_p")).setText("" + this.selectedTile.getPlane());
      }

      if (!this.brush.isMulti()) {
         this.selectedTiles.clear();
         this.selectedTiles = this.brush.getTilesBasedOnBrushAndSize(this.selectedTile);
      }
   }

   public void setSelectedTile(WorldTile tile) {
      this.setSelectedTile(tile.getX(), tile.getY(), tile.getPlane(), false);
   }

   public void addToSelectedTiles(WorldTile tile) {
      Iterator<WorldTile> it = this.selectedTiles.iterator();

      while(it.hasNext()) {
         if (tile.equals(it.next())) {
            it.remove();
            return;
         }
      }

      this.selectedTiles.add(tile);
   }

   public ArrayList<WorldTile> getSelectedTiles() {
      return this.selectedTiles;
   }

   public WorldTile getClickedTile() {
      return this.selectedTile;
   }

   public boolean isDoubleClickActionActivated() {
      return !this.brush.isMulti()
         && ((JCheckBox)UIPanels.generalComponents.get("toggle_doubleclick")).isSelected()
         && this.tool.getActionValues() != null
         && this.tool.getActionValues().length > 0;
   }

   public void setInfoBasedOnSelectedTile() {
      RSMapperClient.editor.tool.setFields();
      RSMapperClient.editor.objectEditor.populateTable(RSMapperClient.editor.selectedTile);
      ((BottomMenu)UIPanels.bottomPanel).updateOverlaysPanel(true);
      ((BottomMenu)UIPanels.bottomPanel).updateUnderlaysPanel(true);
   }

   public void setToolButtonBorders() {
      for(Entry<String, JComponent> pair : UIPanels.generalComponents.entrySet()) {
         String name = pair.getKey();
         JComponent component = pair.getValue();
         if (component instanceof JButton && name.contains("_tool_button")) {
            if (name.equalsIgnoreCase("single_tool_button")) {
               if (this.tool instanceof DefaultTool) {
                  ((JButton)component).setBorder(BorderFactory.createLineBorder(Color.GREEN));
               } else {
                  ((JButton)component).setBorder(null);
               }
            }

            if (name.equalsIgnoreCase("brush_tool_button")) {
               if (this.tool instanceof BrushTool) {
                  ((JButton)component).setBorder(BorderFactory.createLineBorder(Color.GREEN));
               } else {
                  ((JButton)component).setBorder(null);
               }
            }

            if (name.equalsIgnoreCase("height_tool_button")) {
               if (this.tool instanceof HeightTool) {
                  ((JButton)component).setBorder(BorderFactory.createLineBorder(Color.GREEN));
               } else {
                  ((JButton)component).setBorder(null);
               }
            }

            if (name.equalsIgnoreCase("bridge_tool_button")) {
               if (this.tool instanceof BridgeTool) {
                  ((JButton)component).setBorder(BorderFactory.createLineBorder(Color.GREEN));
               } else {
                  ((JButton)component).setBorder(null);
               }
            }

            if (name.equalsIgnoreCase("shape_tool_button")) {
               if (this.tool instanceof ShapeTool) {
                  ((JButton)component).setBorder(BorderFactory.createLineBorder(Color.GREEN));
               } else {
                  ((JButton)component).setBorder(null);
               }
            }

            if (name.equalsIgnoreCase("fx_tool_button")) {
               if (this.tool instanceof FXTool) {
                  ((JButton)component).setBorder(BorderFactory.createLineBorder(Color.GREEN));
               } else {
                  ((JButton)component).setBorder(null);
               }
            }
         }
      }
   }

   public void saveMapState(boolean atmosphere) {
      this.saveMapState(atmosphere, this.selectedTiles);
   }

   public void saveMapState(boolean atmosphere, ArrayList<WorldTile> tiles) {
      if (RSMapperClient.MAP_LOADED) {
         if (this.currentMapState < this.mapStates.length - 1 && this.mapStates[this.currentMapState] != null) {
            if (this.currentMapState == 0 && this.mapStates[1] != null) {
               this.mapStates[1] = null;
               this.mapStates[2] = null;
               this.mapStates[3] = null;
            } else if (this.currentMapState == 1 && this.mapStates[2] != null) {
               this.mapStates[0] = this.mapStates[2];
               this.mapStates[2] = this.mapStates[3];
               this.mapStates[3] = null;
            }
         }

         if (this.currentMapState == this.mapStates.length - 1) {
            this.mapStates[0] = null;

            for(int i = 1; i < this.mapStates.length; ++i) {
               MapState ms = this.mapStates[i];
               this.mapStates[i - 1] = ms;
            }

            this.mapStates[this.mapStates.length - 1] = null;
            this.mapStates[this.mapStates.length - 2] = null;
            --this.currentMapState;
         }

         this.mapStates[this.currentMapState] = new MapState(atmosphere, atmosphere ? null : tiles);
         ++this.currentMapState;
      }
   }

   public void undo() {
      if (RSMapperClient.MAP_LOADED) {
         if (this.currentMapState != 0) {
            boolean worldmap = WorldmapDefinitions.worldmapIsOpen();
            boolean atmo = this.mapStates[this.currentMapState - 1].atmosphere;
            ArrayList<WorldTile> tiles = null;
            if (!atmo) {
               tiles = new ArrayList<>();

               for(TileState ts : this.mapStates[this.currentMapState - 1].tileStates) {
                  if (ts.tile.getPlane() == 0) {
                     tiles.add(ts.tile);
                  }
               }
            }

            this.mapStates[this.currentMapState] = new MapState(atmo, tiles);
            --this.currentMapState;
            if (!atmo) {
               for(TileState ts : this.mapStates[this.currentMapState].tileStates) {
                  this.restoreTileState(ts);
               }
            } else {
               this.mapEditor.createdEnvironment = this.mapStates[this.currentMapState].createdEnvironment;
               this.mapEditor.environmentFlag[0] = this.mapStates[this.currentMapState].environmentFlag;
               this.mapEditor.sunDistanceX[0] = this.mapStates[this.currentMapState].sunDistanceX;
               this.mapEditor.sunDistanceY[0] = this.mapStates[this.currentMapState].sunDistanceY;
               this.mapEditor.sunDistanceZ[0] = this.mapStates[this.currentMapState].sunDistanceZ;
               this.mapEditor.highlightcolor[0] = this.mapStates[this.currentMapState].highlightcolor;
               this.mapEditor.brightness[0] = this.mapStates[this.currentMapState].brightness;
               this.mapEditor.vibrance[0] = this.mapStates[this.currentMapState].vibrance;
               this.mapEditor.blackpoint[0] = this.mapStates[this.currentMapState].blackpoint;
               this.mapEditor.fogcolor[0] = this.mapStates[this.currentMapState].fogcolor;
               this.mapEditor.fogdensity[0] = this.mapStates[this.currentMapState].fogdensity;
               this.mapEditor.i_7_ = this.mapStates[this.currentMapState].i_7_;
               this.mapEditor.i_8_ = this.mapStates[this.currentMapState].i_8_;
               this.mapEditor.i_9_ = this.mapStates[this.currentMapState].i_9_;
               this.mapEditor.i_10_ = this.mapStates[this.currentMapState].i_10_;
               this.mapEditor.i_11_ = this.mapStates[this.currentMapState].i_11_;
               this.mapEditor.i_12_ = this.mapStates[this.currentMapState].i_12_;
            }

            this.mapEditor.populateTable(this.selectedTile);
            this.objectEditor.populateTable(this.selectedTile);
            Class78.MAP_CHANGED = !worldmap;
         }
      }
   }

   public void redo() {
      if (RSMapperClient.MAP_LOADED) {
         if (this.currentMapState != this.mapStates.length - 1) {
            if (this.mapStates[this.currentMapState + 1] != null) {
               boolean worldmap = WorldmapDefinitions.worldmapIsOpen();
               boolean atmo = this.mapStates[this.currentMapState + 1].atmosphere;
               ArrayList<WorldTile> tiles = null;
               if (!atmo) {
                  tiles = new ArrayList<>();

                  for(TileState ts : this.mapStates[this.currentMapState + 1].tileStates) {
                     if (ts.tile.getPlane() == 0) {
                        tiles.add(ts.tile);
                     }
                  }
               }

               this.mapStates[this.currentMapState] = new MapState(atmo, tiles);
               ++this.currentMapState;
               if (!atmo) {
                  for(TileState ts : this.mapStates[this.currentMapState].tileStates) {
                     this.restoreTileState(ts);
                  }
               } else {
                  this.mapEditor.createdEnvironment = this.mapStates[this.currentMapState].createdEnvironment;
                  this.mapEditor.environmentFlag[0] = this.mapStates[this.currentMapState].environmentFlag;
                  this.mapEditor.sunDistanceX[0] = this.mapStates[this.currentMapState].sunDistanceX;
                  this.mapEditor.sunDistanceY[0] = this.mapStates[this.currentMapState].sunDistanceY;
                  this.mapEditor.sunDistanceZ[0] = this.mapStates[this.currentMapState].sunDistanceZ;
                  this.mapEditor.highlightcolor[0] = this.mapStates[this.currentMapState].highlightcolor;
                  this.mapEditor.brightness[0] = this.mapStates[this.currentMapState].brightness;
                  this.mapEditor.vibrance[0] = this.mapStates[this.currentMapState].vibrance;
                  this.mapEditor.blackpoint[0] = this.mapStates[this.currentMapState].blackpoint;
                  this.mapEditor.fogcolor[0] = this.mapStates[this.currentMapState].fogcolor;
                  this.mapEditor.fogdensity[0] = this.mapStates[this.currentMapState].fogdensity;
                  this.mapEditor.i_7_ = this.mapStates[this.currentMapState].i_7_;
                  this.mapEditor.i_8_ = this.mapStates[this.currentMapState].i_8_;
                  this.mapEditor.i_9_ = this.mapStates[this.currentMapState].i_9_;
                  this.mapEditor.i_10_ = this.mapStates[this.currentMapState].i_10_;
                  this.mapEditor.i_11_ = this.mapStates[this.currentMapState].i_11_;
                  this.mapEditor.i_12_ = this.mapStates[this.currentMapState].i_12_;
               }

               this.mapEditor.populateTable(this.selectedTile);
               this.objectEditor.populateTable(this.selectedTile);
               Class78.MAP_CHANGED = !worldmap;
            }
         }
      }
   }

   private void restoreTileState(TileState ts) {
      WorldTile t = ts.tile;
      int x = t.getLocalX();
      int y = t.getLocalY();
      int p = t.getPlane();
      this.mapEditor.heights[p][x][y] = ts.height;
      this.mapEditor.overlays[p][x][y] = ts.overlay;
      this.mapEditor.flags[p][x][y] = ts.flag;
      this.mapEditor.underlays[p][x][y] = ts.underlay;
      this.mapEditor.shapes[p][x][y] = ts.shape;
      this.mapEditor.rotations[p][x][y] = ts.rotation;
      if (p == 0 && RSMapperClient.undermapArchiveId != -1) {
         this.mapEditor.um_heights[p][x][y] = ts.um_height;
         this.mapEditor.um_overlays[p][x][y] = ts.um_overlay;
         this.mapEditor.um_underlays[p][x][y] = ts.um_underlay;
         this.mapEditor.um_shapes[p][x][y] = ts.um_shape;
         this.mapEditor.um_rotations[p][x][y] = ts.um_rotation;
      }

      if (ts.effect == null) {
         this.mapEditor.effects.remove(t);
      } else {
         this.mapEditor.saveEffect(t, ts.effect, false);
      }

      for(int obj = 0; obj < ts.objects.length; ++obj) {
         if (ts.objects[obj][0] > -1 && ts.objects[obj][1] > -1) {
            int type = ts.objects[obj][1];
            int rotation = ts.objects[obj][2];
            if (type == 2) {
               rotation = rotation != 7 && rotation != 0 ? rotation - 1 : 3;
            } else if (type != 6 && type != 8) {
               if (type == 7) {
                  rotation = rotation != 4 && rotation != 5 ? rotation - 6 : rotation - 2;
               }
            } else {
               rotation -= 4;
            }

            this.objectEditor.placeObject(t, ts.objects[obj][0], type, rotation, false, false);
         } else {
            WorldObject objOnTile = WorldmapDefinitions.worldmapIsOpen()
               ? null
               : Class277_Sub1.getWorldObjectWithTypeAtCoordinates(ts.tile.getLocalX(), ts.tile.getLocalY(), ts.tile.getPlane(), obj, true);
            if (objOnTile != null
               && (
                  objOnTile.getId(-32136) != ts.objects[obj][0]
                     || objOnTile.getType(69) != ts.objects[obj][1]
                     || objOnTile.getRotation(23796) != ts.objects[obj][2]
               )) {
               this.objectEditor.removeObject(t, ObjectSpawnEditor.objectTypes[obj], false, false);
            }
         }
      }

      if (p == 0 && RSMapperClient.underlandArchiveId != -1) {
         for(int obj = 0; obj < ts.ul_objects.length; ++obj) {
            if ((ts.ul_objects[obj][0] != 0 || ts.ul_objects[obj][1] != 0) && ts.ul_objects[obj][0] > -1 && ts.ul_objects[obj][1] > -1) {
               this.objectEditor.placeObject(t, ts.ul_objects[obj][0], ts.ul_objects[obj][1], ts.ul_objects[obj][2], true, false);
            } else {
               this.objectEditor.removeObject(t, ObjectSpawnEditor.objectTypes[obj], true, false);
            }
         }
      }

      this.objectEditor.populateTable(this.selectedTile);
   }

   public void loadRegionFromFile() {
      if (!RSMapperClient.MAP_LOADED) {
         JOptionPane.showMessageDialog(RSMapperClient.client_frame, "You must be in a region in order to load data into it.", "No region loaded", 1);
      } else {
         final int choiceType = JOptionPane.showOptionDialog(
            RSMapperClient.client_frame, "Load From Cache or External File", "Choose", 0, -1, null, new Object[]{"Cache", "External"}, "Cache"
         );
         if (choiceType != -1) {
            JPanel al = new JPanel();
            al.setLayout(null);
            al.setSize(50, 100);
            al.setPreferredSize(new Dimension(100, al.getPreferredSize().height));
            JTextField title = new JTextField("Enter region");
            title.setHorizontalAlignment(0);
            title.setBounds(24, 5, 180, 24);
            title.setEditable(false);
            al.add(title);
            final JTextField txtRegion = new JTextField();
            txtRegion.setHorizontalAlignment(0);
            txtRegion.setBounds(24, 30, 125, 24);
            al.add(txtRegion);
            final JCheckBox includeMap = new JCheckBox("M");
            includeMap.setSelected(true);
            includeMap.setBounds(24, 65, 40, 24);
            al.add(includeMap);
            final JCheckBox includeLand = new JCheckBox("L");
            includeLand.setSelected(true);
            includeLand.setBounds(68, 65, 40, 24);
            al.add(includeLand);
            final JCheckBox includeUndermap = new JCheckBox("UM");
            includeUndermap.setSelected(true);
            includeUndermap.setBounds(108, 65, 49, 24);
            al.add(includeUndermap);
            final JCheckBox includeUnderland = new JCheckBox("UL");
            includeUnderland.setSelected(true);
            includeUnderland.setBounds(158, 65, 45, 24);
            al.add(includeUnderland);
            JButton checkFiles = new JButton(choiceType == 0 ? "Check" : "Select");
            checkFiles.setBounds(149, 30, 55, 24);
            checkFiles.addActionListener(
               new ActionListener() {
                  @Override
                  public void actionPerformed(ActionEvent arg0) {
                     try {
                        int regionId = -1;
                        int mapFileArchive = -1;
                        int landFileArchive = -1;
                        int undermapFileArchive = -1;
                        int underlandFileArchive = -1;
                        if (choiceType == 0) {
                           try {
                              regionId = Integer.parseInt(txtRegion.getText().trim());
                           } catch (NumberFormatException var16) {
                              txtRegion.setBorder(BorderFactory.createLineBorder(Color.RED));
                              return;
                           }
   
                           mapFileArchive = Utils.getArchiveId("m", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                           landFileArchive = Utils.getArchiveId("l", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                           undermapFileArchive = Utils.getArchiveId("um", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                           underlandFileArchive = Utils.getArchiveId("ul", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                           if (mapFileArchive == -1 && landFileArchive == -1 && undermapFileArchive == -1 && underlandFileArchive == -1) {
                              txtRegion.setBorder(BorderFactory.createLineBorder(Color.RED));
                              return;
                           }
                        } else if (choiceType == 1) {
                           JFileChooser chooser = new JFileChooser();
                           chooser.setCurrentDirectory(new File("data/maps/import/"));
                           chooser.setDialogTitle("Select a region folder");
                           chooser.setFileSelectionMode(1);
                           chooser.setAcceptAllFileFilterUsed(false);
                           int returnValue = chooser.showOpenDialog(null);
                           if (returnValue == 0) {
                              File folder = chooser.getSelectedFile();
   
                              try {
                                 String name = folder.getName();
                                 Editor.this.loadedRegionFileNames[0] = name;
                                 if (name.contains("_")) {
                                    name = name.split("_")[0].trim();
                                 }
   
                                 regionId = Integer.parseInt(name);
                                 File[] mapFiles = folder.listFiles();
   
                                 for(File f : mapFiles) {
                                    if (f.getName().split("_")[1].trim().equalsIgnoreCase("map") || f.getName().split("_")[1].trim().equalsIgnoreCase("m")) {
                                       mapFileArchive = 1;
                                       Editor.this.loadedRegionFileNames[1] = f.getName();
                                    } else if (f.getName().split("_")[1].trim().equalsIgnoreCase("land")
                                       || f.getName().split("_")[1].trim().equalsIgnoreCase("l")) {
                                       landFileArchive = 1;
                                       Editor.this.loadedRegionFileNames[2] = f.getName();
                                    } else if (f.getName().split("_")[1].trim().equalsIgnoreCase("undermap")
                                       || f.getName().split("_")[1].trim().equalsIgnoreCase("um")) {
                                       undermapFileArchive = 1;
                                       Editor.this.loadedRegionFileNames[3] = f.getName();
                                    } else if (f.getName().split("_")[1].trim().equalsIgnoreCase("underland")
                                       || f.getName().split("_")[1].trim().equalsIgnoreCase("ul")) {
                                       underlandFileArchive = 1;
                                       Editor.this.loadedRegionFileNames[4] = f.getName();
                                    }
                                 }
                              } catch (NumberFormatException var17) {
                                 JOptionPane.showMessageDialog(
                                    RSMapperClient.client_frame,
                                    "Region folder name must consist of a regionid Format: \"id_note\" (Example: \"11817_homeisland\")",
                                    "ERROR",
                                    0
                                 );
                                 return;
                              }
   
                              txtRegion.setText("" + regionId);
                           }
   
                           if (mapFileArchive == -1 && landFileArchive == -1 && undermapFileArchive == -1 && underlandFileArchive == -1) {
                              txtRegion.setBorder(BorderFactory.createLineBorder(Color.RED));
                              return;
                           }
                        }
   
                        if (mapFileArchive == -1 || mapFileArchive != -1 && RSMapperClient.mapArchiveId == -1) {
                           includeMap.setSelected(false);
                           includeMap.setEnabled(false);
                        }
   
                        if (landFileArchive == -1 || landFileArchive != -1 && RSMapperClient.landArchiveId == -1) {
                           includeLand.setSelected(false);
                           includeLand.setEnabled(false);
                        }
   
                        if (undermapFileArchive == -1 || undermapFileArchive != -1 && RSMapperClient.undermapArchiveId == -1) {
                           includeUndermap.setSelected(false);
                           includeUndermap.setEnabled(false);
                        }
   
                        if (underlandFileArchive == -1 || underlandFileArchive != -1 && RSMapperClient.underlandArchiveId == -1) {
                           includeUnderland.setSelected(false);
                           includeUnderland.setEnabled(false);
                        }
   
                        txtRegion.setBorder(BorderFactory.createLineBorder(Color.GREEN));
                     } catch (Exception var18) {
                        var18.printStackTrace();
                     }
                  }
               }
            );
            al.add(checkFiles);
            int choiceLoad = JOptionPane.showOptionDialog(
               RSMapperClient.client_frame, al, "Load Region", 0, -1, null, new Object[]{"Load", "Cancel"}, "Cancel"
            );
            if (choiceLoad == 0) {
               int regionId = -1;

               try {
                  regionId = Integer.parseInt(txtRegion.getText().trim());
               } catch (NumberFormatException var16) {
                  txtRegion.setBorder(BorderFactory.createLineBorder(Color.RED));
                  return;
               }

               if (choiceType == 0) {
                  int mapFileArchive = Utils.getArchiveId("m", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                  int landFileArchive = Utils.getArchiveId("l", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                  int undermapFileArchive = Utils.getArchiveId("um", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                  int underlandFileArchive = Utils.getArchiveId("ul", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                  if (mapFileArchive == -1 && landFileArchive == -1 && undermapFileArchive == -1 && underlandFileArchive == -1) {
                     txtRegion.setBorder(BorderFactory.createLineBorder(Color.RED));
                     return;
                  }
               }

               this.loadRegion(
                  regionId, choiceType == 0, includeMap.isSelected(), includeLand.isSelected(), includeUndermap.isSelected(), includeUnderland.isSelected()
               );
               this.loadedRegion = regionId == RSMapperClient.regionId ? -1 : regionId;
            }
         }
      }
   }

   public void loadRegion(
      final int regionId,
      final boolean fromCache,
      final boolean includeMap,
      final boolean includeLand,
      final boolean includeUndermap,
      final boolean includeUnderland
   ) {
      EventQueue.invokeLater(
         new Runnable() {
            @Override
            public void run() {
               if (!Editor.this.mapEditor.unsavedMapProgress
                  || JOptionPane.showOptionDialog(
                        RSMapperClient.client_frame,
                        "You have unsaved \"map\" progress!",
                        "ARE YOU SURE?",
                        0,
                        2,
                        null,
                        new Object[]{"Yes", "Cancel"},
                        "Cancel"
                     )
                     == 0) {
                  if (!Editor.this.mapEditor.unsavedUndermapProgress
                     || JOptionPane.showOptionDialog(
                           RSMapperClient.client_frame,
                           "You have unsaved \"undermap\" progress!",
                           "ARE YOU SURE?",
                           0,
                           2,
                           null,
                           new Object[]{"Yes", "Cancel"},
                           "Cancel"
                        )
                        == 0) {
                     if (!Editor.this.objectEditor.unsavedLandProgress
                        || JOptionPane.showOptionDialog(
                              RSMapperClient.client_frame,
                              "You have unsaved \"land\" progress!",
                              "ARE YOU SURE?",
                              0,
                              2,
                              null,
                              new Object[]{"Yes", "Cancel"},
                              "Cancel"
                           )
                           == 0) {
                        if (!Editor.this.objectEditor.unsavedUnderlandProgress
                           || JOptionPane.showOptionDialog(
                                 RSMapperClient.client_frame,
                                 "You have unsaved \"underland\" progress!",
                                 "ARE YOU SURE?",
                                 0,
                                 2,
                                 null,
                                 new Object[]{"Yes", "Cancel"},
                                 "Cancel"
                              )
                              == 0) {
                           final int mapFileArchive = Utils.getArchiveId("m", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                           final int landFileArchive = Utils.getArchiveId("l", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                           final int undermapFileArchive = Utils.getArchiveId("um", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                           final int underlandFileArchive = Utils.getArchiveId("ul", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                           if (mapFileArchive != -1 || landFileArchive != -1 || undermapFileArchive != -1 || underlandFileArchive != -1) {
                              Editor.this.loadingRegionProgress = 0;
                              if (fromCache) {
                                 System.out.println("Loading from cache");
                                 EventQueue.invokeLater(
                                    new Runnable() {
                                       @Override
                                       public void run() {
                                          try {
                                             byte[] data = includeMap && mapFileArchive != -1
                                                ? Cache.STORE.getIndexes()[5].getArchive(mapFileArchive).getData()
                                                : new byte[1];
                                             Editor.this.mapEditor.loadFile(data, regionId, false);
                                             data = includeUndermap && undermapFileArchive != -1
                                                ? Cache.STORE.getIndexes()[5].getArchive(undermapFileArchive).getData()
                                                : new byte[1];
                                             Editor.this.mapEditor.loadFile(data, regionId, true);
                                          } catch (Exception var2) {
                                             var2.printStackTrace();
                                          }
                                       }
                                    }
                                 );
                                 EventQueue.invokeLater(
                                    new Runnable() {
                                       @Override
                                       public void run() {
                                          try {
                                             int[] keys = null;
                                             if (includeLand && landFileArchive != -1) {
                                                if (RSMapperClient.decryptedLandFiles.size() > 1) {
                                                   Set<Integer> set = new HashSet<>(RSMapperClient.decryptedLandFiles);
                                                   RSMapperClient.decryptedLandFiles.clear();
                                                   RSMapperClient.decryptedLandFiles.addAll(set);
                                                }
      
                                                if (!RSMapperClient.decryptedLandFiles.contains(regionId)) {
                                                   keys = ObjectSpawnEditor.databaseKeys.getKeys(regionId);
                                                }
      
                                                if (keys != null) {
                                                   RSMapperClient.decryptedLandFiles.add(regionId);
                                                }
                                             }
      
                                             byte[] data = includeLand && landFileArchive != -1
                                                ? Cache.STORE.getIndexes()[5].getArchive(landFileArchive, keys).getData()
                                                : new byte[1];
                                             Editor.this.objectEditor.loadFile(data, false);
                                             data = includeUnderland && underlandFileArchive != -1
                                                ? Cache.STORE.getIndexes()[5].getArchive(underlandFileArchive).getData()
                                                : new byte[1];
                                             Editor.this.objectEditor.loadFile(data, true);
                                          } catch (Exception var3) {
                                             var3.printStackTrace();
                                          }
                                       }
                                    }
                                 );
                              } else {
                                 System.out.println("Loading from external file");
                                 final File folder = new File("data/maps/import/" + Editor.this.loadedRegionFileNames[0] + "/");
                                 if (!folder.exists()) {
                                    JOptionPane.showMessageDialog(RSMapperClient.client_frame, "No folder associated with region", "ERROR", 0);
                                    return;
                                 }
   
                                 EventQueue.invokeLater(new Runnable() {
                                    @Override
                                    public void run() {
                                       byte[] mapData = null;
                                       byte[] undermapData = null;
                                       byte[] landData = null;
                                       byte[] underlandData = null;
                                       if (includeMap && RSMapperClient.mapArchiveId != -1) {
                                          File mapFile = new File(folder.toString() + "/" + Editor.this.loadedRegionFileNames[1]);
                                          System.out.println(Editor.this.loadedRegionFileNames[0]);
                                          if (mapFile.exists()) {
                                             mapData = Utils.getDataFromFile(mapFile);
                                          }
                                       }
   
                                       if (includeUndermap && RSMapperClient.undermapArchiveId != -1) {
                                          File undermapFile = new File(folder.toString() + "/" + Editor.this.loadedRegionFileNames[3]);
                                          if (undermapFile.exists()) {
                                             undermapData = Utils.getDataFromFile(undermapFile);
                                          }
                                       }
   
                                       if (includeLand && RSMapperClient.landArchiveId != -1) {
                                          File landFile = new File(folder.toString() + "/" + Editor.this.loadedRegionFileNames[2]);
                                          if (landFile.exists()) {
                                             landData = Utils.getDataFromFile(landFile);
                                          }
                                       }
   
                                       if (includeUnderland && RSMapperClient.underlandArchiveId != -1) {
                                          File underlandFile = new File(folder.toString() + "/" + Editor.this.loadedRegionFileNames[4]);
                                          if (underlandFile.exists()) {
                                             underlandData = Utils.getDataFromFile(underlandFile);
                                          }
                                       }
   
                                       final byte[] data1 = mapData;
                                       final byte[] data2 = undermapData;
                                       EventQueue.invokeLater(new Runnable() {
                                          @Override
                                          public void run() {
                                             try {
                                                Editor.this.mapEditor.loadFile(data1 == null ? new byte[1] : data1, regionId, false);
                                                Editor.this.mapEditor.loadFile(data2 == null ? new byte[1] : data2, regionId, true);
                                             } catch (Exception var2) {
                                                var2.printStackTrace();
                                             }
                                          }
                                       });
                                       final byte[] data3 = landData;
                                       final byte[] data4 = underlandData;
                                       EventQueue.invokeLater(new Runnable() {
                                          @Override
                                          public void run() {
                                             try {
                                                Editor.this.objectEditor.loadFile(data3 == null ? new byte[1] : data3, false);
                                                Editor.this.objectEditor.loadFile(data4 == null ? new byte[1] : data4, true);
                                             } catch (Exception var2) {
                                                var2.printStackTrace();
                                             }
                                          }
                                       });
                                    }
                                 });
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      );
   }
}
