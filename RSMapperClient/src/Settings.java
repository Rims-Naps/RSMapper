import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Settings {
   public boolean HIDE_CAMERA_ICON = false;
   public static boolean FORCE_NO_MARK;
   public static boolean CLICK_TELEPORT;
   boolean disabledEnvironment;
   public static final String[] hoverOverlayTextOptions = new String[]{
      "None", "Distance", "World Coords", "Local Coords", "Height", "Tile Flag", "Overlay", "Underlay", "Shape", "Rotation"
   };
   public static final String[] markPropertyOptions = new String[]{"None", "No Walk", "Bridge", "Hide Roof", "Objects", "Light FX"};
   public boolean performanceMode;
   public boolean displaySelectedTileOverlay;
   public int overlayTextHeight;
   public int selectedOverlayColor;
   public String markPropertyText;
   public boolean markByObjectId;
   public boolean markByObjectType;
   public int idToMark;
   public int typeToMark;
   public int hoverSize;
   public boolean displayHoverOverlay;
   public String hoverOverlayText;
   public int hoverOverlayColor;
   public boolean displayTextOnAllHovered;

   public Settings() {
      FORCE_NO_MARK = false;
      CLICK_TELEPORT = false;
      this.disabledEnvironment = true;
      this.performanceMode = false;
      this.displaySelectedTileOverlay = true;
      this.overlayTextHeight = 0;
      this.markPropertyText = "None";
      this.idToMark = 0;
      this.typeToMark = 0;
      this.displayHoverOverlay = true;
      this.displayTextOnAllHovered = true;
      this.hoverOverlayText = "None";
      this.hoverOverlayColor = 2537950;
      this.selectedOverlayColor = 16774912;
   }

   public void displayGeneralOverlaySettings() {
      JPanel al = new JPanel();
      al.setLayout(null);
      al.setSize(50, 225);
      al.setPreferredSize(new Dimension(100, al.getPreferredSize().height));
      JCheckBox displayEdit = new JCheckBox("Display selected tile border");
      displayEdit.setSelected(this.displaySelectedTileOverlay);
      displayEdit.setBounds(24, 5, 190, 24);
      al.add(displayEdit);
      JTextField markTitle = new JTextField("Mark all tiles with");
      markTitle.setBounds(24, 34, 180, 24);
      markTitle.setEditable(false);
      al.add(markTitle);
      JComboBox<String> cb = new JComboBox<>(markPropertyOptions);
      cb.setBounds(24, 56, 180, 24);

      for(int i = 0; i < markPropertyOptions.length; ++i) {
         if (this.markPropertyText.equalsIgnoreCase(markPropertyOptions[i])) {
            cb.setSelectedIndex(i);
            break;
         }
      }

      final JCheckBox markId = new JCheckBox("ID");
      markId.setSelected(this.markByObjectId);
      final JTextField textObjectId = new JTextField(Integer.toString(this.idToMark));
      textObjectId.setBounds(105, 88, 80, 24);
      textObjectId.setEditable(this.markByObjectId);
      al.add(textObjectId);
      markId.setBounds(24, 88, 80, 24);
      markId.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            textObjectId.setEditable(markId.isSelected());
         }
      });
      al.add(markId);
      final JCheckBox markType = new JCheckBox("TYPE");
      markType.setSelected(this.markByObjectType);
      final JTextField textObjectType = new JTextField(Integer.toString(this.typeToMark));
      textObjectType.setBounds(105, 114, 80, 24);
      textObjectType.setEditable(this.markByObjectType);
      al.add(textObjectType);
      markType.setBounds(24, 114, 80, 24);
      markType.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            textObjectType.setEditable(markType.isSelected());
         }
      });
      al.add(markType);
      JTextField textHeightTitle = new JTextField("Text height above/below tiles");
      textHeightTitle.setBounds(24, 146, 180, 24);
      textHeightTitle.setEditable(false);
      al.add(textHeightTitle);
      JTextField textHeight = new JTextField(Integer.toString(this.overlayTextHeight));
      textHeight.setBounds(24, 168, 180, 24);
      al.add(textHeight);
      if (this.markPropertyText.equalsIgnoreCase("Objects")) {
         markId.setVisible(true);
         markType.setVisible(true);
         textObjectType.setVisible(true);
         textObjectId.setVisible(true);
         System.out.println("Yeet");
      } else {
         markId.setVisible(false);
         markType.setVisible(false);
         textObjectType.setVisible(false);
         textObjectId.setVisible(false);
      }

      cb.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (((JComboBox)e.getSource()).getSelectedIndex() >= 0) {
               if (Settings.markPropertyOptions[((JComboBox)e.getSource()).getSelectedIndex()].equalsIgnoreCase("Objects")) {
                  markId.setVisible(true);
                  markType.setVisible(true);
                  textObjectType.setVisible(true);
                  textObjectId.setVisible(true);
               } else {
                  markId.setVisible(false);
                  markType.setVisible(false);
                  textObjectType.setVisible(false);
                  textObjectId.setVisible(false);
               }
            }
         }
      });
      al.add(cb);
      int choice = JOptionPane.showOptionDialog(
         RSMapperClient.client_frame, al, "General Overlay Settings", 0, -1, null, new Object[]{"Save", "Cancel"}, "Save"
      );
      if (choice == 0) {
         this.displaySelectedTileOverlay = displayEdit.isSelected();
         this.markByObjectId = markId.isSelected();
         this.markPropertyText = cb.getItemAt(cb.getSelectedIndex());
         this.markByObjectType = markType.isSelected();
         this.idToMark = Integer.parseInt(textObjectId.getText().trim());
         this.typeToMark = Integer.parseInt(textObjectType.getText().trim());
         this.overlayTextHeight = textHeight.getText().isEmpty() ? 60 : Integer.parseInt(textHeight.getText());
      }
   }

   public void displayHoverOverlaySettings() {
      JPanel al = new JPanel();
      al.setLayout(null);
      al.setSize(50, 155);
      al.setPreferredSize(new Dimension(100, al.getPreferredSize().height));
      JCheckBox displayHover = new JCheckBox("Enable hover border overlays");
      displayHover.setSelected(this.displayHoverOverlay);
      displayHover.setBounds(24, 0, 190, 24);
      al.add(displayHover);
      JTextField textColorTitle = new JTextField("Hover border color");
      textColorTitle.setBounds(24, 26, 190, 24);
      textColorTitle.setEditable(false);
      al.add(textColorTitle);
      JTextField textColor = new JTextField(Integer.toString(this.hoverOverlayColor));
      textColor.setBounds(24, 48, 190, 24);
      al.add(textColor);
      JTextField textTitle = new JTextField("Text displayed on hovered tile(s)");
      textTitle.setBounds(24, 78, 190, 24);
      textTitle.setEditable(false);
      al.add(textTitle);
      JComboBox<String> cb = new JComboBox<>(hoverOverlayTextOptions);
      cb.setBounds(24, 100, 190, 24);

      for(int i = 0; i < hoverOverlayTextOptions.length; ++i) {
         if (this.hoverOverlayText.equalsIgnoreCase(hoverOverlayTextOptions[i])) {
            cb.setSelectedIndex(i);
            break;
         }
      }

      al.add(cb);
      JCheckBox displayHoverTextOnPaint = new JCheckBox("Display text on all hovered");
      displayHoverTextOnPaint.setSelected(this.displayTextOnAllHovered);
      displayHoverTextOnPaint.setBounds(24, 128, 200, 24);
      al.add(displayHoverTextOnPaint);
      int choice = JOptionPane.showOptionDialog(RSMapperClient.client_frame, al, "Hover Overlay Settings", 0, -1, null, new Object[]{"Save", "Cancel"}, "Save");
      if (choice == 0) {
         this.displayHoverOverlay = displayHover.isSelected();
         this.hoverOverlayColor = textColor.getText().isEmpty() ? 16774912 : Integer.parseInt(textColor.getText());
         this.hoverOverlayText = cb.getItemAt(cb.getSelectedIndex());
         this.displayTextOnAllHovered = displayHoverTextOnPaint.isSelected();
      }
   }

   public String getOverlayText(int x, int y, int plane) {
      String text = "";
      int localX = Utils.getLocalXFromCoordX(x, RSMapperClient.regionId);
      int localY = Utils.getLocalYFromCoordY(y, RSMapperClient.regionId);
      WorldTile tile = new WorldTile(x, y, plane, false);
      if (this.hoverOverlayText != null && !this.hoverOverlayText.equalsIgnoreCase("none")) {
         if (this.hoverOverlayText.equalsIgnoreCase("Distance")) {
            String[] color = new String[]{"", "", ""};
            int[] differences = new int[2];
            if (x > RSMapperClient.editor.selectedTile.getX()) {
               color[0] = "51db1a";
               differences[0] = x - RSMapperClient.editor.selectedTile.getX();
            } else if (x < RSMapperClient.editor.selectedTile.getX()) {
               color[0] = "d12f0f";
               differences[0] = RSMapperClient.editor.selectedTile.getX() - x;
            }

            if (y > RSMapperClient.editor.selectedTile.getY()) {
               color[1] = "51db1a";
               differences[1] = y - RSMapperClient.editor.selectedTile.getY();
            } else if (y < RSMapperClient.editor.selectedTile.getY()) {
               color[1] = "d12f0f";
               differences[1] = RSMapperClient.editor.selectedTile.getY() - y;
            }

            if (plane > RSMapperClient.editor.selectedTile.getPlane()) {
               color[2] = "51db1a";
            } else if (plane < RSMapperClient.editor.selectedTile.getPlane()) {
               color[2] = "d12f0f";
            }

            text = "(<col="
               + color[0]
               + ">"
               + differences[0]
               + "</col>, <col="
               + color[1]
               + ">"
               + differences[1]
               + "</col>, <col="
               + color[2]
               + ">"
               + plane
               + "</col>)";
         } else if (this.hoverOverlayText.equalsIgnoreCase("Local Coords")) {
            text = "(" + localX + ", " + localY + ")";
         } else if (this.hoverOverlayText.equalsIgnoreCase("World Coords")) {
            text = "(" + x + ", " + y + ", " + plane + ")";
         } else if (this.hoverOverlayText.equalsIgnoreCase("Height") && RSMapperClient.editor.mapEditor.dataLoaded) {
            text = "" + RSMapperClient.editor.mapEditor.getMapValueFromTile(tile, MapEditor.PropertyType.HEIGHT);
         } else if (this.hoverOverlayText.equalsIgnoreCase("Tile Flag") && RSMapperClient.editor.mapEditor.dataLoaded) {
            text = "" + RSMapperClient.editor.mapEditor.getMapValueFromTile(tile, MapEditor.PropertyType.TILE_FLAG);
         } else if (this.hoverOverlayText.equalsIgnoreCase("Overlay") && RSMapperClient.editor.mapEditor.dataLoaded) {
            text = "" + RSMapperClient.editor.mapEditor.getMapValueFromTile(tile, MapEditor.PropertyType.OVERLAY);
         } else if (this.hoverOverlayText.equalsIgnoreCase("Underlay") && RSMapperClient.editor.mapEditor.dataLoaded) {
            text = "" + RSMapperClient.editor.mapEditor.getMapValueFromTile(tile, MapEditor.PropertyType.UNDERLAY);
         } else if (this.hoverOverlayText.equalsIgnoreCase("Shape") && RSMapperClient.editor.mapEditor.dataLoaded) {
            text = "" + RSMapperClient.editor.mapEditor.getMapValueFromTile(tile, MapEditor.PropertyType.SHAPE);
         } else if (this.hoverOverlayText.equalsIgnoreCase("Rotation") && RSMapperClient.editor.mapEditor.dataLoaded) {
            text = "" + RSMapperClient.editor.mapEditor.getMapValueFromTile(tile, MapEditor.PropertyType.ROTATION);
         }
      }

      return text;
   }

   public boolean canMarkTile(int x, int y, int plane) {
      if (FORCE_NO_MARK) {
         return false;
      } else {
         try {
            if (this.markPropertyText != null && !this.markPropertyText.equalsIgnoreCase("none")) {
               WorldTile tile = new WorldTile(x, y, plane, false);
               if ((
                     this.markPropertyText.equalsIgnoreCase("No Walk")
                        || this.markPropertyText.equalsIgnoreCase("Bridge")
                        || this.markPropertyText.equalsIgnoreCase("Hide Roof")
                  )
                  && RSMapperClient.editor.mapEditor.dataLoaded) {
                  int flag = RSMapperClient.editor.mapEditor.getMapValueFromTile(tile, MapEditor.PropertyType.TILE_FLAG);
                  if (this.markPropertyText.equalsIgnoreCase("No Walk")) {
                     if (flag != 1 && flag != 3) {
                        return false;
                     }

                     return true;
                  }

                  if (this.markPropertyText.equalsIgnoreCase("Bridge")) {
                     if (flag != 2 && flag != 6) {
                        return false;
                     }

                     return true;
                  }

                  if (this.markPropertyText.equalsIgnoreCase("Hide Roof")) {
                     if (flag == 4) {
                        return true;
                     }

                     return false;
                  }
               } else if (this.markPropertyText.equalsIgnoreCase("Light FX") && RSMapperClient.editor.mapEditor.dataLoaded) {
                  if (RSMapperClient.editor.mapEditor.effects == null || RSMapperClient.editor.mapEditor.effects.size() <= 0) {
                     return false;
                  }

                  Iterator<Entry<WorldTile, CachedEffect>> it = Collections.synchronizedSet(RSMapperClient.editor.mapEditor.effects.entrySet()).iterator();
                  synchronized(it) {
                     while(it.hasNext()) {
                        Entry<WorldTile, CachedEffect> pair = it.next();
                        WorldTile spawnTile = pair.getKey();
                        if (tile.equals(spawnTile)) {
                           return true;
                        }
                     }
                  }
               } else if (this.markPropertyText.equalsIgnoreCase("Objects") && RSMapperClient.editor.objectEditor.cachedObjects != null) {
                  Map<Integer, ArrayList<CachedObject>> synchMap = Collections.synchronizedMap(RSMapperClient.editor.objectEditor.cachedObjects);
                  synchronized(synchMap) {
                     Iterator<Entry<Integer, ArrayList<CachedObject>>> it = Collections.synchronizedSet(synchMap.entrySet()).iterator();
                     synchronized(it) {
                        while(it.hasNext()) {
                           Entry<Integer, ArrayList<CachedObject>> pair = it.next();
                           int objectId = pair.getKey();
                           if (!this.markByObjectId || this.markByObjectId && objectId == this.idToMark) {
                              ArrayList<CachedObject> objects = pair.getValue();
                              if (objects != null) {
                                 for(CachedObject object : objects) {
                                    if (object.getX() == x
                                       && object.getY() == y
                                       && object.getPlane() == plane
                                       && (!this.markByObjectType || this.markByObjectType && object.getType() == this.typeToMark)) {
                                       return true;
                                    }
                                 }
                              }
                           }
                        }

                        return false;
                     }
                  }
               }
            }
         } catch (Exception var17) {
         }

         return false;
      }
   }

   public void openReplaceTextureSettings(boolean overlays) {
      JPanel al = new JPanel();
      al.setLayout(null);
      al.setSize(50, 110);
      al.setPreferredSize(new Dimension(100, al.getPreferredSize().height));
      JTextField textureToReplaceTitle = new JTextField("Replace " + (overlays ? "Overlay" : "Underlay"));
      textureToReplaceTitle.setBounds(24, 0, 190, 24);
      textureToReplaceTitle.setEditable(false);
      al.add(textureToReplaceTitle);
      JTextField textureToReplace = new JTextField("0");
      textureToReplace.setBounds(24, 23, 190, 24);
      al.add(textureToReplace);
      JTextField textureReplacementTitle = new JTextField("With " + (overlays ? "Overlay" : "Underlay"));
      textureReplacementTitle.setBounds(24, 55, 190, 24);
      textureReplacementTitle.setEditable(false);
      al.add(textureReplacementTitle);
      JTextField textureReplacement = new JTextField("0");
      textureReplacement.setBounds(24, 78, 190, 24);
      al.add(textureReplacement);
      int choice = JOptionPane.showOptionDialog(
         RSMapperClient.client_frame,
         al,
         "Replace " + (overlays ? "Overlay" : "Underlay") + " Settings",
         0,
         -1,
         null,
         new Object[]{"Replace", "Cancel"},
         "Cancel"
      );
      if (choice == 0) {
         int findTexture = 0;
         int replacementTexture = 0;

         try {
            findTexture = Integer.parseInt(textureToReplace.getText().trim());
            replacementTexture = Integer.parseInt(textureReplacement.getText().trim());
         } catch (NumberFormatException var16) {
            var16.printStackTrace();
            return;
         }

         ArrayList<WorldTile> affectedTiles = new ArrayList<>();

         for(int p = 0; p < 4; ++p) {
            for(int x = 0; x < 104; ++x) {
               for(int y = 0; y < 104; ++y) {
                  if (overlays && RSMapperClient.editor.mapEditor.overlays[p][x][y] == findTexture) {
                     affectedTiles.add(new WorldTile(x, y, p, true));
                  } else if (!overlays && RSMapperClient.editor.mapEditor.underlays[p][x][y] == findTexture) {
                     affectedTiles.add(new WorldTile(x, y, p, true));
                  }
               }
            }
         }

         if (affectedTiles.size() > 0) {
            RSMapperClient.editor.saveMapState(false, affectedTiles);

            for(WorldTile t : affectedTiles) {
               int p = t.getPlane();
               int x = t.getLocalX();
               int y = t.getLocalY();
               if (overlays && RSMapperClient.editor.mapEditor.overlays[p][x][y] == findTexture) {
                  RSMapperClient.editor.mapEditor.overlays[p][x][y] = (byte)replacementTexture;
               } else if (!overlays && RSMapperClient.editor.mapEditor.underlays[p][x][y] == findTexture) {
                  RSMapperClient.editor.mapEditor.underlays[p][x][y] = (byte)replacementTexture;
               }
            }

            Class78.MAP_CHANGED = true;
         }
      }
   }

   public void openReplaceObjectsSettings() {
      int shiftY = 30;
      JPanel al = new JPanel();
      al.setLayout(null);
      al.setSize(50, 200);
      al.setPreferredSize(new Dimension(100, al.getPreferredSize().height));
      JCheckBox underland = new JCheckBox("Replace Underland", false);
      underland.setBounds(26, 0, 190, 24);
      al.add(underland);
      JTextField objectToReplaceTitle = new JTextField("Replace Object");
      objectToReplaceTitle.setBounds(30, shiftY + 3, 190, 24);
      objectToReplaceTitle.setEditable(false);
      al.add(objectToReplaceTitle);
      JLabel idLabel1 = new JLabel("Id:");
      idLabel1.setBounds(0, shiftY + 26, 30, 24);
      al.add(idLabel1);
      JTextField objectToReplaceId = new JTextField("0");
      objectToReplaceId.setBounds(30, shiftY + 26, 190, 24);
      al.add(objectToReplaceId);
      JLabel typeLabel1 = new JLabel("Type:");
      typeLabel1.setBounds(0, shiftY + 52, 30, 24);
      al.add(typeLabel1);
      JTextField objectToReplaceType = new JTextField("0");
      objectToReplaceType.setBounds(30, shiftY + 52, 190, 24);
      al.add(objectToReplaceType);
      JTextField objectReplacementTitle = new JTextField("With Object");
      objectReplacementTitle.setBounds(30, shiftY + 54 + 30, 190, 24);
      objectReplacementTitle.setEditable(false);
      al.add(objectReplacementTitle);
      JLabel idLabel2 = new JLabel("Id:");
      idLabel2.setBounds(0, shiftY + 55 + 27 + 26, 30, 24);
      al.add(idLabel2);
      JTextField objectReplacementId = new JTextField("0");
      objectReplacementId.setBounds(30, shiftY + 55 + 27 + 26, 190, 24);
      al.add(objectReplacementId);
      JLabel typeLabel2 = new JLabel("Type:");
      typeLabel2.setBounds(0, shiftY + 55 + 27 + 26 + 26, 30, 24);
      al.add(typeLabel2);
      JTextField objectReplacementType = new JTextField("0");
      objectReplacementType.setBounds(30, shiftY + 55 + 27 + 26 + 26, 190, 24);
      al.add(objectReplacementType);
      int choice = JOptionPane.showOptionDialog(
         RSMapperClient.client_frame, al, "Replace Object Settings", 0, -1, null, new Object[]{"Replace", "Cancel"}, "Cancel"
      );
      if (choice == 0) {
         int replacedObjectId = Integer.parseInt(objectToReplaceId.getText().trim());
         int replacedObjectType = Integer.parseInt(objectToReplaceType.getText().trim());
         int replacementObjectId = Integer.parseInt(objectReplacementId.getText().trim());
         int replacementObjectType = Integer.parseInt(objectReplacementType.getText().trim());
         ArrayList<WorldTile> removeLocations = new ArrayList<>();
         ArrayList<Object[]> spawnLocations = new ArrayList<>();
         ArrayList<WorldTile> affectedTiles = new ArrayList<>();
         Iterator<Entry<Integer, ArrayList<CachedObject>>> it = underland.isSelected()
            ? RSMapperClient.editor.objectEditor.cachedUnderObjects.entrySet().iterator()
            : RSMapperClient.editor.objectEditor.cachedObjects.entrySet().iterator();

         while(it.hasNext()) {
            Entry<Integer, ArrayList<CachedObject>> pair = it.next();
            int objectId = pair.getKey();
            if (objectId == replacedObjectId) {
               for(CachedObject object : pair.getValue()) {
                  if (object.getType() == replacedObjectType) {
                     removeLocations.add(object.getTile());
                  }

                  if (object.getType() == replacementObjectType) {
                     spawnLocations.add(new Object[]{object.getTile(), object.getRotation()});
                  }

                  affectedTiles.add(object.getTile());
               }
            }
         }

         if (affectedTiles.size() > 0) {
            RSMapperClient.editor.saveMapState(false, affectedTiles);
            boolean isUnderland = underland.isSelected();
            if (removeLocations.size() > 0) {
               int count = 0;

               for(WorldTile t : removeLocations) {
                  RSMapperClient.editor.objectEditor.removeObject(t, replacedObjectType, isUnderland, count >= removeLocations.size() - 1);
                  ++count;
               }
            }

            if (spawnLocations.size() > 0) {
               int count = 0;

               for(Object[] o : spawnLocations) {
                  RSMapperClient.editor
                     .objectEditor
                     .placeObject((WorldTile)o[0], replacementObjectId, replacementObjectType, (int) o[1], isUnderland, count >= spawnLocations.size() - 1);
                  ++count;
               }
            }
         }

         Class78.MAP_CHANGED = true;
      }
   }
}
