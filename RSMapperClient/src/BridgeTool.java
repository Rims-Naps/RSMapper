import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class BridgeTool extends Tool {
    public WorldTile point1;
    public WorldTile point2;
    public ArrayList<WorldTile> selectedTiles;

    public BridgeTool() {
        this.doubleClickActionValue = ToolData.bridgeDoubleClickAction;
        this.propertyComponents = new ConcurrentHashMap();
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
        return new String[]{"<col=edb75a>Bridge</col>", "<col=db0d30>Clear</col>"};
    }

    @Override
    public int[] getActionValues() {
        return new int[]{ToolData.ActionValues.BRIDGE_MAKE.getValue(), ToolData.ActionValues.BRIDGE_CLEAR_POINTS.getValue()};
    }

    @Override
    public void setDoubleClickAction(int actionValue, boolean forProperties, boolean storeValue) {
        this.doubleClickActionValue[forProperties ? 0 : 1] = actionValue;
        if (storeValue) {
            ToolData.bridgeDoubleClickAction[forProperties ? 0 : 1] = actionValue;
        }
    }

    @Override
    public BrushType[] getAllowedBrushes() {
        return new BrushType[]{BrushType.SQUARE};
    }

    @Override
    public void applyAction(int actionValue) {
        if (actionValue == ToolData.ActionValues.BRIDGE_MAKE.getValue()) {
            if (this.bothPointsPlaced()) {
                RSMapperClient.editor.saveMapState(false, RSMapperClient.editor.mapEditor.getAllTilesForBridge(this.point1, this.point2));
                RSMapperClient.editor.mapEditor.makeBridge(this.point1, this.point2, this.selectedTiles, true, false);
            } else {
                System.out.println("Both points must be placed");
            }
        } else if (actionValue == ToolData.ActionValues.BRIDGE_CLEAR_POINTS.getValue()) {
            this.point1 = null;
            this.point2 = null;
            this.selectedTiles = null;
        }
    }

    @Override
    public void handleTileHover(int localX, int localY) {
        if (this.point1 == null && this.point2 == null) {
            super.handleTileHover(localX, localY);
        } else if (this.point1 == null || this.point2 == null) {
            if (this.point2 != null && this.point1 == null) {
                this.point1 = this.point2;
                this.point2 = null;
            }
            if (this.point1 != null) {
                if (localX == this.point1.getLocalX() && localY == this.point1.getLocalY()) {
                    return;
                }
                boolean ortho = Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false) == 1;
                ArrayList<WorldTile> markedTiles = new ArrayList<WorldTile>();
                if (localY == this.point1.getLocalY()) {
                    int x = this.point1.getLocalX() > localX ? localX : this.point1.getLocalX();
                    while (x <= (this.point1.getLocalX() > localX ? this.point1.getLocalX() : localX)) {
                        if (ortho) {
                            r.createTileMarker(x, localY, Class295.myPlayer.plane, RSMapperClient.settings.overlayTextHeight, RSMapperClient.settings.hoverOverlayColor, 1);
                        } else {
                            markedTiles.add(new WorldTile(x, localY, Class295.myPlayer.plane, true));
                        }
                        ++x;
                    }
                } else if (localX == this.point1.getLocalX()) {
                    int y = this.point1.getLocalY() > localY ? localY : this.point1.getLocalY();
                    while (y <= (this.point1.getLocalY() > localY ? this.point1.getLocalY() : localY)) {
                        if (ortho) {
                            r.createTileMarker(localX, y, Class295.myPlayer.plane, RSMapperClient.settings.overlayTextHeight, RSMapperClient.settings.hoverOverlayColor, 1);
                        } else {
                            markedTiles.add(new WorldTile(localX, y, Class295.myPlayer.plane, true));
                        }
                        ++y;
                    }
                } else {
                    boolean cursorYGreater;
                    int yDiff;
                    boolean cursorXGreater = Math.max(this.point1.getLocalX(), localX) == localX;
                    int xDiff = (cursorXGreater ? localX : this.point1.getLocalX()) - (cursorXGreater ? this.point1.getLocalX() : localX);
                    if ((xDiff + 1) * ((yDiff = ((cursorYGreater = Math.max(this.point1.getLocalY(), localY) == localY) ? localY : this.point1.getLocalY()) - (cursorYGreater ? this.point1.getLocalY() : localY)) + 1) < 1000) {
                        int x = cursorXGreater ? this.point1.getLocalX() : localX;
                        while (x <= (cursorXGreater ? localX : this.point1.getLocalX())) {
                            int y = cursorYGreater ? this.point1.getLocalY() : localY;
                            while (y <= (cursorYGreater ? localY : this.point1.getLocalY())) {
                                if (ortho) {
                                    r.createTileMarker(x, y, Class295.myPlayer.plane, RSMapperClient.settings.overlayTextHeight, RSMapperClient.settings.hoverOverlayColor, 1);
                                } else {
                                    markedTiles.add(new WorldTile(x, y, Class295.myPlayer.plane, true));
                                }
                                ++y;
                            }
                            ++x;
                        }
                    }
                }
                if (!ortho && markedTiles.size() > 0) {
                    for (WorldTile t2 : markedTiles) {
                        int x = t2.getLocalX();
                        int y = t2.getLocalY();
                        if (x == this.point1.getLocalX() && y == this.point1.getLocalY() || x >= 104 || x < 0 || y >= 104 || y < 0 || Class167.anInt2033 >= Node_Sub25_Sub2.aClass54Array9959.length - 1) continue;
                        Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asTileBorder(t2.isWithinRegionBounds() ? 20 : 21, x, y, t2.getPlane());
                    }
                    if (Class167.anInt2033 < Node_Sub25_Sub2.aClass54Array9959.length - 2) {
                        Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asTileBorder(23, this.point1.getLocalX(), this.point1.getLocalY(), this.point1.getPlane());
                        Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asVerticeHighlight(22, this.point1.getLocalX(), this.point1.getLocalY(), this.point1.getPlane());
                    }
                }
            }
        }
    }

    @Override
    public boolean handleTileClick(int localX, int localY, int plane, int actionValue) {
        if (actionValue == 1) {
            if (this.point1 != null && this.point2 != null && RSMapperClient.editor.isDoubleClickActionActivated()) {
                for (WorldTile t2 : this.selectedTiles) {
                    if (t2.getLocalX() != localX || t2.getLocalY() != localY || t2.getPlane() != plane) continue;
                    if (!(localX == this.point1.getLocalX() && localY == this.point1.getLocalY() || localX == this.point2.getLocalX() && localY == this.point2.getLocalY())) {
                        this.applyAction(this.doubleClickActionValue[0]);
                        if (this.doubleClickActionValue[0] == ToolData.ActionValues.BRIDGE_CLEAR_POINTS.getValue()) {
                            this.setEditingTiles(localX, localY, plane, actionValue);
                        }
                        return true;
                    }
                    break;
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
                    this.selectedTiles = new ArrayList();
                } else {
                    this.selectedTiles.clear();
                }
                if (this.point1.getLocalY() == this.point2.getLocalY()) {
                    int x = this.point1.getLocalX() > this.point2.getLocalX() ? this.point2.getLocalX() : this.point1.getLocalX();
                    while (x <= (this.point1.getLocalX() > this.point2.getLocalX() ? this.point1.getLocalX() : this.point2.getLocalX())) {
                        System.out.println("added: " + new WorldTile(x, this.point1.getLocalY(), this.point1.getPlane(), true).toString());
                        this.selectedTiles.add(new WorldTile(x, this.point1.getLocalY(), this.point1.getPlane(), true));
                        ++x;
                    }
                } else if (this.point1.getLocalX() == this.point2.getLocalX()) {
                    int y = this.point1.getLocalY() > this.point2.getLocalY() ? this.point2.getLocalY() : this.point1.getLocalY();
                    while (y <= (this.point1.getLocalY() > this.point2.getLocalY() ? this.point1.getLocalY() : this.point2.getLocalY())) {
                        this.selectedTiles.add(new WorldTile(this.point1.getLocalX(), y, this.point1.getPlane(), true));
                        ++y;
                    }
                } else {
                    boolean point2XGreater = Math.max(this.point1.getLocalX(), this.point2.getLocalX()) == this.point2.getLocalX();
                    boolean point2YGreater = Math.max(this.point1.getLocalY(), this.point2.getLocalY()) == this.point2.getLocalY();
                    int x = point2XGreater ? this.point1.getLocalX() : this.point2.getLocalX();
                    while (x <= (point2XGreater ? this.point2.getLocalX() : this.point1.getLocalX())) {
                        int y = point2YGreater ? this.point1.getLocalY() : this.point2.getLocalY();
                        while (y <= (point2YGreater ? this.point2.getLocalY() : this.point1.getLocalY())) {
                            this.selectedTiles.add(new WorldTile(x, y, this.point1.getPlane(), true));
                            ++y;
                        }
                        ++x;
                    }
                }
            }
        } else {
            this.applyAction(actionValue);
        }
        return true;
    }

    @Override
    public void createTileMarkers() {
        if (this.point1 != null && this.point2 != null && this.selectedTiles != null) {
            for (WorldTile tile : this.selectedTiles) {
                if (!tile.isWithinRegionBounds()) continue;
                if (this.point1.equals(tile) || this.point2.equals(tile)) {
                    r.createTextMarker(this.point1.equals(tile) ? "1" : "2", tile.getLocalX(), tile.getLocalY(), tile.getPlane(), 0, 573195, 1);
                }
                int x = tile.getLocalX();
                int y = tile.getLocalY();
                if (Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false) == 1) {
                    r.createTileMarker(tile.getLocalX(), tile.getLocalY(), tile.getPlane(), 0, RSMapperClient.settings.selectedOverlayColor, 1);
                    continue;
                }
                if (x >= 104 || x < 0 || y >= 104 || y < 0 || Class167.anInt2033 >= Node_Sub25_Sub2.aClass54Array9959.length - 2) continue;
                Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asTileBorder(23, x, y, tile.getPlane());
                Node_Sub25_Sub2.aClass54Array9959[Class167.anInt2033++] = Class54.asVerticeHighlight(22, x, y, tile.getPlane());
            }
        }
        super.createTileMarkers();
    }

    @Override
    public void setupUI() {
        int shiftY = 0;
        JTextField propertiesTitle = new JTextField();
        propertiesTitle.setBounds(4, 4, 285, 24);
        propertiesTitle.setHorizontalAlignment(0);
        propertiesTitle.setEditable(false);
        propertiesTitle.setText("BRIDGE SETTINGS");
        propertiesTitle.setFont(new Font("", 1, 16));
        UIPanels.propertiesTabPanel.add(propertiesTitle);
        this.propertyComponents.put("properties_title", propertiesTitle);
        JTextField txt_overlay_title = new JTextField("OVERLAY");
        txt_overlay_title.setHorizontalAlignment(0);
        txt_overlay_title.setBounds(4, shiftY + 32, 100, 24);
        txt_overlay_title.setEditable(false);
        UIPanels.propertiesTabPanel.add(txt_overlay_title);
        this.propertyComponents.put("txt_overlay_title", txt_overlay_title);
        JTextField txt_overlay = new JTextField("" + ToolData.bridgeOverlay);
        txt_overlay.setBounds(102, shiftY + 32, 70, 24);
        UIPanels.propertiesTabPanel.add(txt_overlay);
        this.propertyComponents.put("txt_overlay", txt_overlay);
        this.addPropertyTextChangedListeners(txt_overlay, 0);
        JButton shiftOverlayLeft = this.makeShiftPropertyButton("", null, new ImageIcon("resources/images/decrement.png"), false, 176, shiftY + 32, 55, 24, 0, true);
        UIPanels.propertiesTabPanel.add(shiftOverlayLeft);
        this.propertyComponents.put("decrement_overlay", shiftOverlayLeft);
        JButton shiftOverlayRight = this.makeShiftPropertyButton("", null, new ImageIcon("resources/images/increment.png"), false, 231, shiftY + 32, 55, 24, 0, false);
        UIPanels.propertiesTabPanel.add(shiftOverlayRight);
        this.propertyComponents.put("increment_overlay", shiftOverlayRight);
        JTextField txt_floor_title = new JTextField("FLOOR OBJECT");
        txt_floor_title.setHorizontalAlignment(0);
        txt_floor_title.setBounds(4, (shiftY += 26) + 32, 100, 24);
        txt_floor_title.setEditable(false);
        UIPanels.propertiesTabPanel.add(txt_floor_title);
        this.propertyComponents.put("txt_floor_title", txt_floor_title);
        JTextField txt_floorobject = new JTextField("" + ToolData.bridgeFloorObjectId);
        txt_floorobject.setBounds(102, shiftY + 32, 70, 24);
        UIPanels.propertiesTabPanel.add(txt_floorobject);
        this.propertyComponents.put("txt_floorobject", txt_floorobject);
        this.addPropertyTextChangedListeners(txt_floorobject, 1);
        JTextField txt_floorrot_title = new JTextField("ROTATE");
        txt_floorrot_title.setHorizontalAlignment(0);
        txt_floorrot_title.setBounds(176, shiftY + 32, 55, 24);
        txt_floorrot_title.setEditable(false);
        UIPanels.propertiesTabPanel.add(txt_floorrot_title);
        this.propertyComponents.put("txt_floorrot_title", txt_floorrot_title);
        JTextField txt_floorobjectrot = new JTextField("" + ToolData.bridgeFloorObjectRotation);
        txt_floorobjectrot.setBounds(230, shiftY + 32, 56, 24);
        UIPanels.propertiesTabPanel.add(txt_floorobjectrot);
        this.propertyComponents.put("txt_floorobjectrot", txt_floorobjectrot);
        this.addPropertyTextChangedListeners(txt_floorobjectrot, 2);
        final JCheckBox manualHeights = new JCheckBox("Manual Heights", ToolData.bridgeManualHeights);
        manualHeights.setBounds(4, shiftY + 32 + 32, 120, 24);
        JLabel height1Label = new JLabel("Height Point 1:");
        height1Label.setBounds(12, shiftY + 32 + 30 + 28, 88, 24);
        UIPanels.propertiesTabPanel.add(height1Label);
        this.propertyComponents.put("height1_label", height1Label);
        final JTextField height1 = new JTextField("" + ToolData.bridgeHeightPoint1);
        height1.setBounds(92, shiftY + 32 + 30 + 28, 81, 24);
        height1.setEnabled(ToolData.bridgeManualHeights);
        UIPanels.propertiesTabPanel.add(height1);
        this.propertyComponents.put("height1", height1);
        this.addPropertyTextChangedListeners(height1, 3);
        final JButton loadHeight1 = new JButton("Load Selected");
        loadHeight1.setBounds(177, shiftY + 32 + 30 + 28, 109, 24);
        loadHeight1.setEnabled(ToolData.bridgeManualHeights);
        loadHeight1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (BridgeTool.this.point2 != null) {
                    height1.setText("" + RSMapperClient.editor.mapEditor.getValueFromTile(BridgeTool.this.point2, MapEditor.PropertyType.HEIGHT, false));
                }
            }
        });
        UIPanels.propertiesTabPanel.add(loadHeight1);
        this.propertyComponents.put("load_height1", loadHeight1);
        JLabel height2Label = new JLabel("Height Point 2:");
        height2Label.setBounds(12, shiftY + 32 + 30 + 28 + 28, 88, 24);
        UIPanels.propertiesTabPanel.add(height2Label);
        this.propertyComponents.put("height2_label", height2Label);
        final JTextField height2 = new JTextField("" + ToolData.bridgeHeightPoint2);
        height2.setBounds(92, shiftY + 32 + 30 + 28 + 28, 81, 24);
        height2.setEnabled(ToolData.bridgeManualHeights);
        UIPanels.propertiesTabPanel.add(height2);
        this.propertyComponents.put("height2", height2);
        this.addPropertyTextChangedListeners(height2, 4);
        final JButton loadHeight2 = new JButton("Load Selected");
        loadHeight2.setBounds(177, shiftY + 32 + 30 + 28 + 28, 109, 24);
        loadHeight2.setEnabled(ToolData.bridgeManualHeights);
        loadHeight2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (BridgeTool.this.point2 != null) {
                    height2.setText("" + RSMapperClient.editor.mapEditor.getValueFromTile(BridgeTool.this.point2, MapEditor.PropertyType.HEIGHT, false));
                }
            }
        });
        UIPanels.propertiesTabPanel.add(loadHeight2);
        this.propertyComponents.put("load_height2", loadHeight2);
        manualHeights.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                ToolData.bridgeManualHeights = manualHeights.isSelected();
                height1.setEnabled(manualHeights.isSelected());
                height2.setEnabled(manualHeights.isSelected());
                loadHeight1.setEnabled(manualHeights.isSelected());
                loadHeight2.setEnabled(manualHeights.isSelected());
            }
        });
        UIPanels.propertiesTabPanel.add(manualHeights);
        this.propertyComponents.put("manual_height", manualHeights);
        JButton construct = new JButton("Construct Bridge");
        construct.setBounds(6, shiftY + 32 + 24 + 100, 281, 26);
        construct.setFont(new Font("Tahoma", 1, 16));
        construct.setForeground(Color.GREEN);
        construct.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                BridgeTool.this.applyAction(ToolData.ActionValues.BRIDGE_MAKE.getValue());
            }
        });
        UIPanels.propertiesTabPanel.add(construct);
        this.propertyComponents.put("construct_bridge", construct);
        JButton clearPoints = new JButton("Clear Selected Points");
        clearPoints.setBounds(6, shiftY + 32 + 24 + 100 + 26 + 4, 281, 26);
        clearPoints.setFont(new Font("Tahoma", 1, 16));
        clearPoints.setForeground(Color.RED);
        clearPoints.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                BridgeTool.this.point1 = null;
                BridgeTool.this.point2 = null;
                BridgeTool.this.selectedTiles = null;
            }
        });
        UIPanels.propertiesTabPanel.add(clearPoints);
        this.propertyComponents.put("clear_points", clearPoints);
    }

    private void addPropertyTextChangedListeners(final JTextField field, final int type) {
        field.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void changedUpdate(DocumentEvent arg0) {
            }

            @Override
            public void insertUpdate(DocumentEvent arg0) {
                if (!field.getText().isEmpty()) {
                    Runnable doChange = new Runnable(){

                        @Override
                        public void run() {
                            try {
                                int value = Integer.parseInt(field.getText());
                                if (type == 0) {
                                    ToolData.bridgeOverlay = value;
                                } else if (type == 1) {
                                    ToolData.bridgeFloorObjectId = value;
                                } else if (type == 2) {
                                    int n2 = value > 3 ? 3 : (ToolData.bridgeFloorObjectRotation = value < 0 ? 0 : value);
                                    if (value > 3 || value < 0) {
                                        field.setText("" + ToolData.bridgeFloorObjectRotation);
                                    }
                                } else if (type == 3) {
                                    ToolData.bridgeHeightPoint1 = value;
                                } else if (type == 4) {
                                    ToolData.bridgeHeightPoint2 = value;
                                }
                            }
                            catch (NumberFormatException e) {
                                return;
                            }
                        }
                    };
                    SwingUtilities.invokeLater(doChange);
                } else if (type == 0) {
                    ToolData.bridgeOverlay = 0;
                } else if (type == 1) {
                    ToolData.bridgeFloorObjectId = -1;
                } else if (type == 2) {
                    ToolData.bridgeFloorObjectRotation = 0;
                } else if (type == 3) {
                    ToolData.bridgeHeightPoint1 = 0;
                } else if (type == 4) {
                    ToolData.bridgeHeightPoint2 = 0;
                }
            }

            @Override
            public void removeUpdate(DocumentEvent arg0) {
                if (!field.getText().isEmpty()) {
                    Runnable doChange = new Runnable(){

                        @Override
                        public void run() {
                            try {
                                int value = Integer.parseInt(field.getText());
                                if (type == 0) {
                                    ToolData.bridgeOverlay = value;
                                } else if (type == 1) {
                                    ToolData.bridgeFloorObjectId = value;
                                } else if (type == 2) {
                                    int n2 = value > 3 ? 3 : (ToolData.bridgeFloorObjectRotation = value < 0 ? 0 : value);
                                    if (value > 3 || value < 0) {
                                        field.setText("" + ToolData.bridgeFloorObjectRotation);
                                    }
                                } else if (type == 3) {
                                    ToolData.bridgeHeightPoint1 = value;
                                } else if (type == 4) {
                                    ToolData.bridgeHeightPoint2 = value;
                                }
                            }
                            catch (NumberFormatException e) {
                                return;
                            }
                        }
                    };
                    SwingUtilities.invokeLater(doChange);
                } else if (type == 0) {
                    ToolData.bridgeOverlay = 0;
                } else if (type == 1) {
                    ToolData.bridgeFloorObjectId = -1;
                } else if (type == 2) {
                    ToolData.bridgeFloorObjectRotation = 0;
                } else if (type == 3) {
                    ToolData.bridgeHeightPoint1 = 0;
                } else if (type == 4) {
                    ToolData.bridgeHeightPoint2 = 0;
                }
            }
        });
    }

    private JButton makeShiftPropertyButton(String text, String tooltip, ImageIcon icon, boolean rightSideIcon, int x, int y, int width, int height, final int type, final boolean reduce) {
        JButton button = new JButton(text, icon);
        if (rightSideIcon) {
            button.setHorizontalTextPosition(10);
        }
        if (tooltip != null) {
            button.setToolTipText(tooltip);
        }
        button.setBounds(x, y, width, height);
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    switch (type) {
                        case 0: {
                            ToolData.bridgeOverlay += reduce ? -1 : 1;
                            if (BridgeTool.this.bothPointsPlaced()) {
                                BridgeTool.this.applyAction(ToolData.ActionValues.BRIDGE_MAKE.getValue());
                            }
                            ((JTextField)BridgeTool.this.propertyComponents.get("txt_overlay")).setText("" + ToolData.bridgeOverlay);
                        }
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        return button;
    }
}

