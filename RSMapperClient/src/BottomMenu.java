import com.rs.cache.Cache;
import com.rs.cache.loaders.ObjectDefinitions;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class BottomMenu
extends JPanel {
    private static final long serialVersionUID = 1L;
    public static final int TOTAL_OVERLAYS = 255;
    public static final int TOTAL_UNDERLAYS = 166;
    protected JScrollPane defsObjectsScrollPane;
    protected JList<?> listDefsObjectIds;
    protected JTextField inputDefsObjectIdToFind;
    int selectedDefsObjectId;
    protected JCheckBox searchDefinitionsByName;
    protected JCheckBox searchDefinitionsByOption;
    protected JCheckBox viewModelOnSelect;
    protected JCheckBox selectTileOnMS;
    JTextField[] defTitles = new JTextField[8];
    JTextField[] defValues = new JTextField[7];
    protected JComboBox<String> defsObjectsOptions;
    Object[] objectDefinitionFilters;
    protected JTabbedPane jtpData;
    protected JPanel notesPanel;
    protected JPanel overlaysPanel;
    protected JPanel underlaysPanel;
    protected JLabel selectedNoteTitle;
    protected JScrollPane notesScrollPane;
    protected JScrollPane noteScrollPane;
    protected JList<?> listNotes;
    protected JTextArea noteBody;
    protected JTextField inputNoteToFind;
    String selectedNoteFile;

    public void setup() {
        this.makeObjectsOnTilePanel();
        JSeparator jsep1 = new JSeparator();
        jsep1.setBounds(313, 0, 5, 253);
        jsep1.setOrientation(1);
        this.add(jsep1);
        UIPanels.generalComponents.put("bottom_jsep1", jsep1);
        this.makeObjectDefsPanel(320);
        JSeparator jsep2 = new JSeparator();
        jsep2.setBounds(650, 0, 5, 253);
        jsep2.setOrientation(1);
        this.add(jsep2);
        UIPanels.generalComponents.put("bottom_jsep2", jsep2);
        this.jtpData = new JTabbedPane();
        this.jtpData.setLayout(null);
        this.jtpData.setPreferredSize(new Dimension(618, 247));
        this.jtpData.setBounds(657, 4, 618, 247);
        this.overlaysPanel = new JPanel(false);
        this.overlaysPanel.setLayout(null);
        this.overlaysPanel.setPreferredSize(new Dimension(500, 1975));
        this.underlaysPanel = new JPanel(false);
        this.underlaysPanel.setLayout(null);
        this.underlaysPanel.setPreferredSize(new Dimension(500, 1295));
        this.notesPanel = new JPanel(false);
        this.notesPanel.setLayout(null);
        this.jtpData.addChangeListener(new ChangeListener(){

            @Override
            public void stateChanged(ChangeEvent e) {
                if (RSMapperClient.editor != null && RSMapperClient.editor.editing != null && BottomMenu.this.jtpData.getSelectedIndex() >= 0) {
                    if (BottomMenu.this.jtpData.getTitleAt(BottomMenu.this.jtpData.getSelectedIndex()).equalsIgnoreCase("Overlays")) {
                        RSMapperClient.editor.setDataSelection(DataType.OVERLAYS);
                        BottomMenu.this.updateOverlaysPanel(false);
                    } else if (BottomMenu.this.jtpData.getTitleAt(BottomMenu.this.jtpData.getSelectedIndex()).equalsIgnoreCase("Underlays")) {
                        RSMapperClient.editor.setDataSelection(DataType.UNDERLAYS);
                        BottomMenu.this.updateUnderlaysPanel(false);
                    } else if (BottomMenu.this.jtpData.getTitleAt(BottomMenu.this.jtpData.getSelectedIndex()).equalsIgnoreCase("Notes")) {
                        RSMapperClient.editor.setDataSelection(DataType.NOTES);
                    }
                }
            }
        });
        this.add(this.jtpData);
        UIPanels.generalComponents.put("jtp_data", this.jtpData);
        this.jtpData.setTabLayoutPolicy(1);
        this.makeOverlaysPanel();
        this.makeUnderlaysPanel();
        this.makeNotesPanel();
    }

    private void makeObjectsOnTilePanel() {
        JTextField[][] objectTitles = new JTextField[4][3];
        JTextField[][] objectsOnTile = new JTextField[4][3];
        int shiftY = -146;
        JTextField editingTileTitle = new JTextField();
        editingTileTitle.setBounds(4, shiftY + 150, 306, 24);
        editingTileTitle.setHorizontalAlignment(0);
        editingTileTitle.setEditable(false);
        editingTileTitle.setText("OBJECTS ON SELECTED TILE");
        editingTileTitle.setFont(new Font("", 1, 16));
        this.add(editingTileTitle);
        UIPanels.generalComponents.put("objects_on_tile_title", editingTileTitle);
        int i2 = 0;
        while (i2 < 4) {
            int index = i2;
            int j2 = 0;
            while (j2 < 3) {
                objectTitles[i2][j2] = new JTextField();
                objectTitles[i2][j2].setBounds(4 + j2 * 86 + (j2 == 1 ? -9 : (j2 == 2 ? -29 : 0)), shiftY + 178 + 1 * i2 * 25, j2 == 2 ? 58 : 36, 24);
                objectTitles[i2][j2].setEditable(false);
                this.add(objectTitles[i2][j2]);
                UIPanels.generalComponents.put("object_title" + i2 + "_" + j2, objectTitles[i2][j2]);
                objectsOnTile[i2][j2] = new JTextField();
                objectsOnTile[i2][j2].setBounds(47 + 35 * j2 * 2 + (j2 == 0 ? -7 : (j2 == 1 ? -1 : (j2 == 2 ? 18 : 0))), shiftY + 178 + i2 * 25, j2 == 0 ? 40 : 30, 24);
                objectsOnTile[i2][j2].setText("");
                objectsOnTile[i2][j2].setEditable(false);
                objectsOnTile[i2][j2].setBackground(new Color(191, 190, 186));
                this.add(objectsOnTile[i2][j2]);
                UIPanels.generalComponents.put("objects_on_tile" + i2 + "_" + j2, objectsOnTile[i2][j2]);
                ++j2;
            }
            objectTitles[i2][0].setText("ID:");
            objectTitles[i2][0].setFont(new Font("", 0, 10));
            objectTitles[i2][1].setText("TYPE:");
            objectTitles[i2][1].setFont(new Font("", 0, 9));
            objectTitles[i2][2].setText("ROTATION:");
            objectTitles[i2][2].setFont(new Font("", 0, 9));
            this.makeObjectsOnTileButton(0, index, new ImageIcon("resources/images/4560_0.png"), 235, shiftY + 180 + i2 * 25, 18, 18, false);
            this.makeObjectsOnTileButton(1, index, new ImageIcon("resources/images/rotate_icon.png"), 254, shiftY + 180 + i2 * 25, 18, 18, false);
            this.makeObjectsOnTileButton(2, index, new ImageIcon("resources/images/expand_icon.png"), 273, shiftY + 180 + i2 * 25, 18, 18, false);
            this.makeObjectsOnTileButton(3, index, new ImageIcon("resources/images/definitions_icon.png"), 292, shiftY + 180 + i2 * 25, 18, 18, false);
            ++i2;
        }
        JTextField[][] underObjectTitles = new JTextField[4][3];
        JTextField[][] underObjectsOnTile = new JTextField[4][3];
        shiftY = -13;
        JTextField UnderlandTitle = new JTextField();
        UnderlandTitle.setBounds(4, shiftY + 153, 306, 24);
        UnderlandTitle.setHorizontalAlignment(0);
        UnderlandTitle.setEditable(false);
        UnderlandTitle.setText("UNDERLAND OBJECTS");
        UnderlandTitle.setFont(new Font("", 1, 16));
        this.add(UnderlandTitle);
        UIPanels.generalComponents.put("under_objects_on_tile_title", UnderlandTitle);
        int i3 = 0;
        while (i3 < 3) {
            int index = i3;
            int j3 = 0;
            while (j3 < 3) {
                underObjectTitles[i3][j3] = new JTextField();
                underObjectTitles[i3][j3].setBounds(4 + j3 * 86 + (j3 == 1 ? -9 : (j3 == 2 ? -29 : 0)), shiftY + 181 + 1 * i3 * 25, j3 == 2 ? 58 : 36, 24);
                underObjectTitles[i3][j3].setEditable(false);
                this.add(underObjectTitles[i3][j3]);
                UIPanels.generalComponents.put("under_object_title" + i3 + "_" + j3, underObjectTitles[i3][j3]);
                underObjectsOnTile[i3][j3] = new JTextField();
                underObjectsOnTile[i3][j3].setBounds(47 + 35 * j3 * 2 + (j3 == 0 ? -7 : (j3 == 1 ? -1 : (j3 == 2 ? 18 : 0))), shiftY + 181 + i3 * 25, j3 == 0 ? 40 : 30, 24);
                underObjectsOnTile[i3][j3].setText("");
                underObjectsOnTile[i3][j3].setEditable(false);
                underObjectsOnTile[i3][j3].setBackground(new Color(191, 190, 186));
                this.add(underObjectsOnTile[i3][j3]);
                UIPanels.generalComponents.put("under_objects_on_tile" + i3 + "_" + j3, underObjectsOnTile[i3][j3]);
                ++j3;
            }
            underObjectTitles[i3][0].setText("ID:");
            underObjectTitles[i3][0].setFont(new Font("", 0, 10));
            underObjectTitles[i3][1].setText("TYPE:");
            underObjectTitles[i3][1].setFont(new Font("", 0, 9));
            underObjectTitles[i3][2].setText("ROTATION:");
            underObjectTitles[i3][2].setFont(new Font("", 0, 9));
            this.makeObjectsOnTileButton(0, index, new ImageIcon("resources/images/4560_0.png"), 235, shiftY + 183 + i3 * 25, 18, 18, true);
            this.makeObjectsOnTileButton(1, index, new ImageIcon("resources/images/rotate_icon.png"), 254, shiftY + 183 + i3 * 25, 18, 18, true);
            this.makeObjectsOnTileButton(2, index, new ImageIcon("resources/images/expand_icon.png"), 273, shiftY + 183 + i3 * 25, 18, 18, true);
            this.makeObjectsOnTileButton(3, index, new ImageIcon("resources/images/definitions_icon.png"), 292, shiftY + 183 + i3 * 25, 18, 18, true);
            ++i3;
        }
    }

    private void makeObjectsOnTileButton(final int type, final int index, ImageIcon icon, int x, int y, int width, int height, final boolean underland) {
        JButton button = new JButton("", icon);
        button.setBounds(x, y, width, height);
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                JTextField idField = (JTextField)UIPanels.generalComponents.get(String.valueOf(underland ? "under_objects_on_tile" : "objects_on_tile") + index + "_0");
                JTextField typeField = (JTextField)UIPanels.generalComponents.get(String.valueOf(underland ? "under_objects_on_tile" : "objects_on_tile") + index + "_1");
                JTextField rotationField = (JTextField)UIPanels.generalComponents.get(String.valueOf(underland ? "under_objects_on_tile" : "objects_on_tile") + index + "_2");
                if (idField.getText().isEmpty() && typeField.getText().isEmpty() && rotationField.getText().isEmpty()) {
                    return;
                }
                switch (type) {
                    case 0: {
                        if (typeField.getText().isEmpty()) break;
                        RSMapperClient.editor.saveMapState(false);
                        RSMapperClient.editor.objectEditor.removeObject(RSMapperClient.editor.selectedTile, Integer.parseInt(typeField.getText().trim()), underland, true);
                        break;
                    }
                    case 1: {
                        if (rotationField.getText().isEmpty()) break;
                        int newRotation = Integer.parseInt(rotationField.getText().trim()) + 1;
                        if (newRotation > 3) {
                            newRotation = 0;
                        }
                        RSMapperClient.editor.saveMapState(false);
                        RSMapperClient.editor.objectEditor.placeObject(RSMapperClient.editor.selectedTile, Integer.parseInt(idField.getText().trim()), Integer.parseInt(typeField.getText().trim()), newRotation, underland, true);
                        break;
                    }
                    case 2: {
                        if (idField.getText().isEmpty() || typeField.getText().isEmpty()) break;
                        int id = Integer.parseInt(idField.getText().trim());
                        if (RSMapperClient.editor.objectEditor.VIEWER_OPEN && RSMapperClient.editor.objectEditor.viewingObject == id) {
                            ExternalInterfaceLoader.closeInterface("ModelViewer");
                            break;
                        }
                        RSMapperClient.editor.objectEditor.displayObjectOnModelViewer(id, Integer.parseInt(typeField.getText().trim()));
                        break;
                    }
                    case 3: {
                        if (idField.getText().isEmpty()) break;
                        BottomMenu.this.searchDefinitions(Integer.parseInt(idField.getText().trim()));
                    }
                }
                RSMapperClient.setFocusOnCanvas();
            }
        });
        this.add(button);
        UIPanels.generalComponents.put(String.valueOf(underland ? "under_objects_on_tile_button" : "objects_on_tile_button") + type + "_" + index, button);
    }

    private void makeObjectDefsPanel(int baseX) {
        JTextField objectDefsTitle = new JTextField();
        objectDefsTitle.setBounds(baseX, 4, 328, 24);
        objectDefsTitle.setHorizontalAlignment(0);
        objectDefsTitle.setEditable(false);
        objectDefsTitle.setText("OBJECT DEFINITIONS");
        objectDefsTitle.setFont(new Font("", 1, 16));
        this.add(objectDefsTitle);
        UIPanels.generalComponents.put("obj_defs_title", objectDefsTitle);
        final JButton mouseSelectObject = new JButton("MS");
        mouseSelectObject.setBounds(baseX, 32, 26, 24);
        mouseSelectObject.setBorder(null);
        mouseSelectObject.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                Class78.SELECTING_OBJECT = !Class78.SELECTING_OBJECT;
                mouseSelectObject.setBorder(Class78.SELECTING_OBJECT ? BorderFactory.createLineBorder(Color.GREEN, 2) : null);
            }
        });
        this.add(mouseSelectObject);
        UIPanels.generalComponents.put("mouse_select_obj", mouseSelectObject);
        this.inputDefsObjectIdToFind = new JTextField();
        this.inputDefsObjectIdToFind.setBounds(baseX + 28, 32, 106, 24);
        this.add(this.inputDefsObjectIdToFind);
        UIPanels.generalComponents.put("defs_input_id", this.inputDefsObjectIdToFind);
        JButton btnSearchObjectDefs = new JButton("Search");
        btnSearchObjectDefs.setBounds(baseX + 136, 32, 50, 24);
        btnSearchObjectDefs.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                try {
                    int id = BottomMenu.this.inputDefsObjectIdToFind.getText().isEmpty() ? -3 : (BottomMenu.this.searchDefinitionsByName.isSelected() || BottomMenu.this.searchDefinitionsByOption.isSelected() ? -1 : Integer.parseInt(BottomMenu.this.inputDefsObjectIdToFind.getText()));
                    BottomMenu.this.searchDefinitions(id);
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Invalid object id", "ERROR", 0);
                }
            }
        });
        this.add(btnSearchObjectDefs);
        UIPanels.generalComponents.put("defs_search", btnSearchObjectDefs);
        JButton btnFilterObjectDefs = new JButton("Filters");
        btnFilterObjectDefs.setBounds(baseX + 188, 32, 50, 24);
        btnFilterObjectDefs.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                BottomMenu.this.openObjectDefinitionFilters();
            }
        });
        this.add(btnFilterObjectDefs);
        UIPanels.generalComponents.put("defs_filter", btnFilterObjectDefs);
        this.searchDefinitionsByName = new JCheckBox("By Name");
        this.searchDefinitionsByName.setSelected(false);
        this.searchDefinitionsByName.setBounds(baseX + 153 + 86, 32, 90, 25);
        this.searchDefinitionsByName.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                BottomMenu.this.searchDefinitionsByOption.setSelected(false);
            }
        });
        this.add(this.searchDefinitionsByName);
        UIPanels.generalComponents.put("defs_search_by_name", this.searchDefinitionsByName);
        this.searchDefinitionsByOption = new JCheckBox("By Option");
        this.searchDefinitionsByOption.setSelected(false);
        this.searchDefinitionsByOption.setBounds(baseX + 153 + 86, 52, 90, 25);
        this.searchDefinitionsByOption.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                BottomMenu.this.searchDefinitionsByName.setSelected(false);
            }
        });
        this.add(this.searchDefinitionsByOption);
        UIPanels.generalComponents.put("defs_search_by_option", this.searchDefinitionsByOption);
        this.viewModelOnSelect = new JCheckBox("Show Model");
        this.viewModelOnSelect.setSelected(false);
        this.viewModelOnSelect.setBounds(baseX, 60, 100, 25);
        this.viewModelOnSelect.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (!RSMapperClient.MAP_LOADED) {
                    return;
                }
                if (BottomMenu.this.viewModelOnSelect.isSelected()) {
                    if (BottomMenu.this.selectedDefsObjectId > -1) {
                        ObjectDefinition objectdefinition;
                        ObjectDefinition objectDefinition = objectdefinition = Class186.aClass112_2256 == null ? null : Class186.aClass112_2256.getObjectDefinitionsForId(BottomMenu.this.selectedDefsObjectId, 42);
                        if (objectdefinition != null) {
                            int type = objectdefinition.possibleTypes == null ? 10 : objectdefinition.possibleTypes[0];
                            RSMapperClient.editor.objectEditor.displayObjectOnModelViewer(BottomMenu.this.selectedDefsObjectId, type);
                        }
                    } else {
                        RSMapperClient.editor.objectEditor.displayObjectOnModelViewer(0, 0);
                    }
                } else {
                    ExternalInterfaceLoader.closeInterface("ModelViewer");
                }
            }
        });
        this.add(this.viewModelOnSelect);
        UIPanels.generalComponents.put("defs_view_model_select", this.viewModelOnSelect);
        this.selectTileOnMS = new JCheckBox("Select Tile on MS");
        this.selectTileOnMS.setSelected(false);
        this.selectTileOnMS.setBounds(baseX + 102, 60, 120, 25);
        this.add(this.selectTileOnMS);
        UIPanels.generalComponents.put("defs_select_tile_ms", this.selectTileOnMS);
        this.defsObjectsOptions = new JComboBox();
        this.defsObjectsOptions.setBounds(baseX + 141 + 87, 133, 100, 21);
        this.add(this.defsObjectsOptions);
        UIPanels.generalComponents.put("cb_defs_options", this.defsObjectsOptions);
        this.defsObjectsScrollPane = new JScrollPane();
        this.defsObjectsScrollPane.setBounds(baseX, 87, 165, 158);
        this.add(this.defsObjectsScrollPane);
        UIPanels.generalComponents.put("defs_scroll_pane", this.defsObjectsScrollPane);
        int i2 = 0;
        while (i2 < this.defTitles.length) {
            if (this.defTitles[i2] == null) {
                this.defTitles[i2] = new JTextField();
            }
            if (i2 == 2) {
                this.defTitles[i2].setBounds(baseX + 171 + 91 + 4, 87 + (i2 - 1) * 23, 24, 21);
            } else {
                this.defTitles[i2].setBounds(baseX + 171, (i2 > 2 ? 64 : 87) + i2 * 23, 55, 21);
            }
            this.defTitles[i2].setEditable(false);
            this.add(this.defTitles[i2]);
            UIPanels.generalComponents.put("defs_titles" + i2, this.defTitles[i2]);
            this.defTitles[i2].repaint();
            ++i2;
        }
        this.defTitles[0].setText("Type(s)");
        this.defTitles[1].setText("Size      X");
        this.defTitles[2].setText("Y");
        this.defTitles[3].setText("Options");
        this.defTitles[4].setText("Map");
        this.defTitles[5].setText("Area");
        this.defTitles[6].setText("Render");
        this.defTitles[7].setText("Noclip");
        JLabel spriteImgLabel = new JLabel("", 0);
        spriteImgLabel.setBounds(baseX + 141 + 87 + 50, 156, 50, 21);
        spriteImgLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        spriteImgLabel.setOpaque(true);
        spriteImgLabel.setBackground(Color.white);
        this.add(spriteImgLabel);
        UIPanels.generalComponents.put("sprite_img_label", spriteImgLabel);
        JLabel areaImgLabel = new JLabel("", 0);
        areaImgLabel.setBounds(baseX + 141 + 87 + 50, 179, 50, 21);
        areaImgLabel.setBorder(BorderFactory.createLineBorder(Color.black));
        areaImgLabel.setOpaque(true);
        areaImgLabel.setBackground(Color.white);
        this.add(areaImgLabel);
        UIPanels.generalComponents.put("area_img_label", areaImgLabel);
        int i3 = 0;
        while (i3 < this.defValues.length) {
            this.defValues[i3] = new JTextField();
            if (i3 == 1 || i3 == 2) {
                this.defValues[i3].setBounds(baseX + 141 + (i3 == 2 ? 151 : 87), 87 + (i3 - (i3 == 2 ? 1 : 0)) * 23, 36, 21);
            } else if (i3 >= 3) {
                this.defValues[i3].setBounds(baseX + 141 + 87, 87 + i3 * 23, i3 == 3 || i3 == 4 ? 50 : 100, 21);
            } else {
                this.defValues[i3].setBounds(baseX + 141 + 87, (i3 > 2 ? 64 : 87) + i3 * 23, 100, 21);
            }
            this.defValues[i3].setEditable(false);
            this.defValues[i3].setBackground(new Color(191, 190, 186));
            this.add(this.defValues[i3]);
            UIPanels.generalComponents.put("def_values" + i3, this.defValues[i3]);
            this.defValues[i3].repaint();
            ++i3;
        }
        this.defValues[3].setHorizontalAlignment(0);
        this.defValues[4].setHorizontalAlignment(0);
    }

    public void openObjectDefinitionFilters() {
        int i2;
        JPanel al = new JPanel();
        al.setLayout(null);
        al.setSize(100, 268);
        al.setPreferredSize(new Dimension(100, al.getPreferredSize().height));
        JLabel typesLabel = new JLabel("Must Include Type(s):");
        typesLabel.setBounds(4, 0, 115, 24);
        al.add(typesLabel);
        final JCheckBox allTypesCheckbox = new JCheckBox("Any");
        allTypesCheckbox.setBounds(120, 0, 50, 24);
        final JTextField typesTextField = new JTextField("");
        typesTextField.setBounds(4, 30, 232, 24);
        allTypesCheckbox.setSelected(this.objectDefinitionFilters == null);
        if (!allTypesCheckbox.isSelected()) {
            i2 = 0;
            while (i2 < 23) {
                if (this.objectDefinitionFilters[i2] == null || !((Boolean)this.objectDefinitionFilters[i2]).booleanValue()) break;
                if (i2 == 22) {
                    allTypesCheckbox.setSelected(true);
                }
                ++i2;
            }
        }
        allTypesCheckbox.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                typesTextField.setEnabled(!allTypesCheckbox.isSelected());
                if (!allTypesCheckbox.isSelected()) {
                    typesTextField.setText("");
                } else {
                    int i2 = 0;
                    while (i2 < 23) {
                        typesTextField.setText(String.valueOf(typesTextField.getText()) + i2 + ",");
                        ++i2;
                    }
                }
            }
        });
        al.add(allTypesCheckbox);
        if (allTypesCheckbox.isSelected()) {
            typesTextField.setEnabled(false);
        }
        i2 = 0;
        while (i2 < 23) {
            if (this.objectDefinitionFilters == null || this.objectDefinitionFilters[i2] != null && ((Boolean)this.objectDefinitionFilters[i2]).booleanValue()) {
                typesTextField.setText(String.valueOf(typesTextField.getText()) + i2 + ",");
            }
            ++i2;
        }
        al.add(typesTextField);
        JLabel containsOptionLabel = new JLabel("Has Option");
        containsOptionLabel.setBounds(4, 60, 80, 24);
        al.add(containsOptionLabel);
        final JCheckBox ignoreOptionCheckBox = new JCheckBox("Any");
        ignoreOptionCheckBox.setBounds(86, 60, 50, 24);
        ignoreOptionCheckBox.setSelected(this.objectDefinitionFilters == null || this.objectDefinitionFilters[29] == null || ((String)this.objectDefinitionFilters[29]).isEmpty());
        final JTextField optionTextField = new JTextField("");
        optionTextField.setBounds(140, 60, 96, 24);
        if (this.objectDefinitionFilters != null && this.objectDefinitionFilters[29] != null && !((String)this.objectDefinitionFilters[29]).isEmpty()) {
            optionTextField.setText((String)this.objectDefinitionFilters[29]);
        }
        ignoreOptionCheckBox.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                optionTextField.setEnabled(!ignoreOptionCheckBox.isSelected());
                if (!ignoreOptionCheckBox.isSelected()) {
                    optionTextField.setText(BottomMenu.this.objectDefinitionFilters != null && BottomMenu.this.objectDefinitionFilters[29] != null && !((String)BottomMenu.this.objectDefinitionFilters[29]).isEmpty() ? (String)BottomMenu.this.objectDefinitionFilters[29] : "");
                } else {
                    optionTextField.setText("");
                }
            }
        });
        al.add(ignoreOptionCheckBox);
        if (ignoreOptionCheckBox.isSelected()) {
            optionTextField.setEnabled(false);
        }
        optionTextField.setText(this.objectDefinitionFilters != null && this.objectDefinitionFilters[29] != null && !((String)this.objectDefinitionFilters[29]).isEmpty() ? (String)this.objectDefinitionFilters[29] : "");
        al.add(optionTextField);
        JLabel sizeXLabel = new JLabel("Size X:");
        sizeXLabel.setBounds(4, 90, 80, 24);
        al.add(sizeXLabel);
        final JCheckBox ignoreSizeXCheckBox = new JCheckBox("Any");
        ignoreSizeXCheckBox.setBounds(86, 90, 50, 24);
        ignoreSizeXCheckBox.setSelected(this.objectDefinitionFilters == null || this.objectDefinitionFilters[23] == null || (Integer)this.objectDefinitionFilters[23] <= 0);
        final JTextField sizeXTextField = new JTextField("");
        sizeXTextField.setBounds(140, 90, 96, 24);
        if (this.objectDefinitionFilters != null && this.objectDefinitionFilters[23] != null && (Integer)this.objectDefinitionFilters[23] > 0) {
            sizeXTextField.setText("" + (Integer)this.objectDefinitionFilters[23]);
        }
        ignoreSizeXCheckBox.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                sizeXTextField.setEnabled(!ignoreSizeXCheckBox.isSelected());
                if (!ignoreSizeXCheckBox.isSelected()) {
                    sizeXTextField.setText("" + (BottomMenu.this.objectDefinitionFilters != null && BottomMenu.this.objectDefinitionFilters[23] != null && (Integer)BottomMenu.this.objectDefinitionFilters[23] > 0 ? (Integer)BottomMenu.this.objectDefinitionFilters[23] : ""));
                } else {
                    sizeXTextField.setText("");
                }
            }
        });
        al.add(ignoreSizeXCheckBox);
        if (ignoreSizeXCheckBox.isSelected()) {
            sizeXTextField.setEnabled(false);
        }
        sizeXTextField.setText("" + (this.objectDefinitionFilters != null && this.objectDefinitionFilters[23] != null && (Integer)this.objectDefinitionFilters[23] > 0 ? (Integer)this.objectDefinitionFilters[23] : ""));
        al.add(sizeXTextField);
        JLabel sizeYLabel = new JLabel("Size Y:");
        sizeYLabel.setBounds(4, 120, 80, 24);
        al.add(sizeYLabel);
        final JCheckBox ignoreSizeYCheckBox = new JCheckBox("Any");
        ignoreSizeYCheckBox.setBounds(86, 120, 50, 24);
        ignoreSizeYCheckBox.setSelected(this.objectDefinitionFilters == null || this.objectDefinitionFilters[24] == null || (Integer)this.objectDefinitionFilters[24] <= 0);
        final JTextField sizeYTextField = new JTextField("");
        sizeYTextField.setBounds(140, 120, 96, 24);
        if (this.objectDefinitionFilters != null && this.objectDefinitionFilters[24] != null && (Integer)this.objectDefinitionFilters[24] > 0) {
            sizeYTextField.setText("" + (Integer)this.objectDefinitionFilters[24]);
        }
        ignoreSizeYCheckBox.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                sizeYTextField.setEnabled(!ignoreSizeYCheckBox.isSelected());
                if (!ignoreSizeYCheckBox.isSelected()) {
                    sizeYTextField.setText("" + (BottomMenu.this.objectDefinitionFilters != null && BottomMenu.this.objectDefinitionFilters[24] != null && (Integer)BottomMenu.this.objectDefinitionFilters[24] > 0 ? (Integer)BottomMenu.this.objectDefinitionFilters[24] : ""));
                } else {
                    sizeYTextField.setText("");
                }
            }
        });
        al.add(ignoreSizeYCheckBox);
        if (ignoreSizeYCheckBox.isSelected()) {
            sizeYTextField.setEnabled(false);
        }
        sizeYTextField.setText("" + (this.objectDefinitionFilters != null && this.objectDefinitionFilters[24] != null && (Integer)this.objectDefinitionFilters[24] > 0 ? (Integer)this.objectDefinitionFilters[24] : ""));
        al.add(sizeYTextField);
        JLabel mapSpriteLabel = new JLabel("Map Sprite:");
        mapSpriteLabel.setBounds(4, 150, 80, 24);
        al.add(mapSpriteLabel);
        final JCheckBox mapSpriteCheckBox = new JCheckBox("Any");
        mapSpriteCheckBox.setBounds(86, 150, 50, 24);
        mapSpriteCheckBox.setSelected(this.objectDefinitionFilters == null || this.objectDefinitionFilters[25] == null || (Integer)this.objectDefinitionFilters[25] < -1);
        final JTextField mapSpriteTextField = new JTextField("");
        mapSpriteTextField.setBounds(140, 150, 96, 24);
        if (this.objectDefinitionFilters != null && this.objectDefinitionFilters[25] != null && (Integer)this.objectDefinitionFilters[25] >= -1) {
            mapSpriteTextField.setText("" + (Integer)this.objectDefinitionFilters[25]);
        }
        mapSpriteCheckBox.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                mapSpriteTextField.setEnabled(!mapSpriteCheckBox.isSelected());
                if (!mapSpriteCheckBox.isSelected()) {
                    mapSpriteTextField.setText("" + (BottomMenu.this.objectDefinitionFilters != null && BottomMenu.this.objectDefinitionFilters[25] != null && (Integer)BottomMenu.this.objectDefinitionFilters[25] >= -1 ? (Integer)BottomMenu.this.objectDefinitionFilters[25] : ""));
                } else {
                    mapSpriteTextField.setText("");
                }
            }
        });
        al.add(mapSpriteCheckBox);
        if (mapSpriteCheckBox.isSelected()) {
            mapSpriteTextField.setEnabled(false);
        }
        mapSpriteTextField.setText("" + (this.objectDefinitionFilters != null && this.objectDefinitionFilters[25] != null && (Integer)this.objectDefinitionFilters[25] >= -1 ? (Integer)this.objectDefinitionFilters[25] : ""));
        al.add(mapSpriteTextField);
        JLabel areaSpriteLabel = new JLabel("Area Sprite:");
        areaSpriteLabel.setBounds(4, 180, 80, 24);
        al.add(areaSpriteLabel);
        final JCheckBox areaSpriteCheckBox = new JCheckBox("Any");
        areaSpriteCheckBox.setBounds(86, 180, 50, 24);
        areaSpriteCheckBox.setSelected(this.objectDefinitionFilters == null || this.objectDefinitionFilters[26] == null || (Integer)this.objectDefinitionFilters[26] < -1);
        final JTextField areaSpriteTextField = new JTextField("");
        areaSpriteTextField.setBounds(140, 180, 96, 24);
        if (this.objectDefinitionFilters != null && this.objectDefinitionFilters[26] != null && (Integer)this.objectDefinitionFilters[26] >= -1) {
            areaSpriteTextField.setText("" + (Integer)this.objectDefinitionFilters[26]);
        }
        areaSpriteCheckBox.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                areaSpriteTextField.setEnabled(!areaSpriteCheckBox.isSelected());
                if (!areaSpriteCheckBox.isSelected()) {
                    areaSpriteTextField.setText("" + (BottomMenu.this.objectDefinitionFilters != null && BottomMenu.this.objectDefinitionFilters[26] != null && (Integer)BottomMenu.this.objectDefinitionFilters[26] >= -1 ? (Integer)BottomMenu.this.objectDefinitionFilters[26] : ""));
                } else {
                    areaSpriteTextField.setText("");
                }
            }
        });
        al.add(areaSpriteCheckBox);
        if (areaSpriteCheckBox.isSelected()) {
            areaSpriteTextField.setEnabled(false);
        }
        areaSpriteTextField.setText("" + (this.objectDefinitionFilters != null && this.objectDefinitionFilters[26] != null && (Integer)this.objectDefinitionFilters[26] >= -1 ? (Integer)this.objectDefinitionFilters[26] : ""));
        al.add(areaSpriteTextField);
        JLabel renderAnimLabel = new JLabel("Render Anim:");
        renderAnimLabel.setBounds(4, 210, 80, 24);
        al.add(renderAnimLabel);
        final JCheckBox renderAnimAllCheckBox = new JCheckBox("Any");
        renderAnimAllCheckBox.setBounds(86, 210, 50, 24);
        renderAnimAllCheckBox.setSelected(this.objectDefinitionFilters == null || this.objectDefinitionFilters[27] == null || (Integer)this.objectDefinitionFilters[27] < -1);
        final JTextField renderAnimTextField = new JTextField("");
        renderAnimTextField.setBounds(140, 210, 96, 24);
        if (this.objectDefinitionFilters != null && this.objectDefinitionFilters[27] != null && (Integer)this.objectDefinitionFilters[27] >= -1) {
            renderAnimTextField.setText("" + (Integer)this.objectDefinitionFilters[27]);
        }
        renderAnimAllCheckBox.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                renderAnimTextField.setEnabled(!renderAnimAllCheckBox.isSelected());
                if (!renderAnimAllCheckBox.isSelected()) {
                    renderAnimTextField.setText("" + (BottomMenu.this.objectDefinitionFilters != null && BottomMenu.this.objectDefinitionFilters[27] != null && (Integer)BottomMenu.this.objectDefinitionFilters[27] >= -1 ? (Integer)BottomMenu.this.objectDefinitionFilters[27] : ""));
                } else {
                    renderAnimTextField.setText("");
                }
            }
        });
        al.add(renderAnimAllCheckBox);
        if (renderAnimAllCheckBox.isSelected()) {
            renderAnimTextField.setEnabled(false);
        }
        renderAnimTextField.setText("" + (this.objectDefinitionFilters != null && this.objectDefinitionFilters[27] != null && (Integer)this.objectDefinitionFilters[27] >= -1 ? (Integer)this.objectDefinitionFilters[27] : ""));
        al.add(renderAnimTextField);
        JLabel clippingLabel = new JLabel("Clipping:");
        clippingLabel.setBounds(4, 240, 80, 24);
        al.add(clippingLabel);
        final JCheckBox clippingAnyCheckbox = new JCheckBox("Any");
        clippingAnyCheckbox.setBounds(52, 240, 50, 24);
        clippingAnyCheckbox.setSelected(this.objectDefinitionFilters == null || this.objectDefinitionFilters[28] == null || (Integer)this.objectDefinitionFilters[28] <= 0);
        final JCheckBox clippingClippedCheckBox = new JCheckBox("Clipped");
        clippingClippedCheckBox.setBounds(102, 240, 70, 24);
        if (this.objectDefinitionFilters != null && this.objectDefinitionFilters[28] != null && (Integer)this.objectDefinitionFilters[28] == 1) {
            clippingClippedCheckBox.setSelected(true);
        }
        final JCheckBox clippingNoclipCheckBox = new JCheckBox("Noclip");
        clippingNoclipCheckBox.setBounds(172, 240, 65, 24);
        if (this.objectDefinitionFilters != null && this.objectDefinitionFilters[28] != null && (Integer)this.objectDefinitionFilters[28] == 2) {
            clippingNoclipCheckBox.setSelected(true);
        }
        clippingAnyCheckbox.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (clippingAnyCheckbox.isSelected()) {
                    clippingClippedCheckBox.setSelected(false);
                    clippingNoclipCheckBox.setSelected(false);
                } else if (!clippingClippedCheckBox.isSelected() && !clippingNoclipCheckBox.isSelected()) {
                    clippingAnyCheckbox.setSelected(true);
                }
            }
        });
        al.add(clippingAnyCheckbox);
        clippingClippedCheckBox.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (clippingClippedCheckBox.isSelected()) {
                    clippingAnyCheckbox.setSelected(false);
                    clippingNoclipCheckBox.setSelected(false);
                } else if (!clippingClippedCheckBox.isSelected() && !clippingNoclipCheckBox.isSelected()) {
                    clippingAnyCheckbox.setSelected(true);
                }
            }
        });
        al.add(clippingClippedCheckBox);
        clippingNoclipCheckBox.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (clippingNoclipCheckBox.isSelected()) {
                    clippingAnyCheckbox.setSelected(false);
                    clippingClippedCheckBox.setSelected(false);
                } else if (!clippingClippedCheckBox.isSelected() && !clippingNoclipCheckBox.isSelected()) {
                    clippingAnyCheckbox.setSelected(true);
                }
            }
        });
        al.add(clippingNoclipCheckBox);
        int choice = JOptionPane.showOptionDialog(RSMapperClient.client_frame, al, "Object Definition Filters", 0, -1, null, new Object[]{"Save", "Cancel"}, "Save");
        if (choice == 0) {
            boolean usingFilters;
            block66: {
                block65: {
                    block64: {
                        block63: {
                            block62: {
                                if (this.objectDefinitionFilters == null) {
                                    this.objectDefinitionFilters = new Object[30];
                                }
                                usingFilters = false;
                                if (allTypesCheckbox.isSelected()) {
                                    int i3 = 0;
                                    while (i3 < 23) {
                                        this.objectDefinitionFilters[i3] = true;
                                        ++i3;
                                    }
                                } else {
                                    String typesText = typesTextField.getText();
                                    boolean[] included = new boolean[23];
                                    if (!typesText.isEmpty()) {
                                        String[] types;
                                        String[] stringArray = types = typesText.split("\\,");
                                        int n2 = types.length;
                                        int n3 = 0;
                                        while (n3 < n2) {
                                            String s = stringArray[n3];
                                            try {
                                                int type = Integer.parseInt(s.trim());
                                                this.objectDefinitionFilters[type] = true;
                                                included[type] = true;
                                            }
                                            catch (NumberFormatException numberFormatException) {
                                                // empty catch block
                                            }
                                            ++n3;
                                        }
                                    }
                                    int i4 = 0;
                                    while (i4 < 23) {
                                        if (!included[i4]) {
                                            this.objectDefinitionFilters[i4] = false;
                                            usingFilters = true;
                                        }
                                        ++i4;
                                    }
                                }
                                if (!ignoreOptionCheckBox.isSelected() && !optionTextField.getText().trim().isEmpty()) {
                                    this.objectDefinitionFilters[29] = optionTextField.getText().trim();
                                    usingFilters = true;
                                } else {
                                    this.objectDefinitionFilters[29] = null;
                                }
                                if (!ignoreSizeXCheckBox.isSelected() && !sizeXTextField.getText().isEmpty()) {
                                    try {
                                        int sizeX = Integer.parseInt(sizeXTextField.getText().trim());
                                        if (sizeX > 0) {
                                            this.objectDefinitionFilters[23] = sizeX;
                                            usingFilters = true;
                                            break block62;
                                        }
                                        this.objectDefinitionFilters[23] = null;
                                    }
                                    catch (NumberFormatException e) {
                                        this.objectDefinitionFilters[23] = null;
                                    }
                                } else {
                                    this.objectDefinitionFilters[23] = null;
                                }
                            }
                            if (!ignoreSizeYCheckBox.isSelected() && !sizeYTextField.getText().isEmpty()) {
                                try {
                                    int sizeY = Integer.parseInt(sizeYTextField.getText().trim());
                                    if (sizeY > 0) {
                                        this.objectDefinitionFilters[24] = sizeY;
                                        usingFilters = true;
                                        break block63;
                                    }
                                    this.objectDefinitionFilters[24] = null;
                                }
                                catch (NumberFormatException e) {
                                    this.objectDefinitionFilters[24] = null;
                                }
                            } else {
                                this.objectDefinitionFilters[24] = null;
                            }
                        }
                        if (!mapSpriteCheckBox.isSelected() && !mapSpriteTextField.getText().isEmpty()) {
                            try {
                                int mapSpriteId = Integer.parseInt(mapSpriteTextField.getText().trim());
                                if (mapSpriteId >= -1) {
                                    this.objectDefinitionFilters[25] = mapSpriteId;
                                    usingFilters = true;
                                    break block64;
                                }
                                this.objectDefinitionFilters[25] = null;
                            }
                            catch (NumberFormatException e) {
                                this.objectDefinitionFilters[25] = null;
                            }
                        } else {
                            this.objectDefinitionFilters[25] = null;
                        }
                    }
                    if (!areaSpriteCheckBox.isSelected() && !areaSpriteTextField.getText().isEmpty()) {
                        try {
                            int areaSpriteId = Integer.parseInt(areaSpriteTextField.getText().trim());
                            if (areaSpriteId >= -1) {
                                this.objectDefinitionFilters[26] = areaSpriteId;
                                usingFilters = true;
                                break block65;
                            }
                            this.objectDefinitionFilters[26] = null;
                        }
                        catch (NumberFormatException e) {
                            this.objectDefinitionFilters[26] = null;
                        }
                    } else {
                        this.objectDefinitionFilters[26] = null;
                    }
                }
                if (!renderAnimAllCheckBox.isSelected() && !renderAnimTextField.getText().isEmpty()) {
                    try {
                        int animId = Integer.parseInt(renderAnimTextField.getText().trim());
                        if (animId >= -1) {
                            this.objectDefinitionFilters[27] = animId;
                            usingFilters = true;
                            break block66;
                        }
                        this.objectDefinitionFilters[27] = null;
                    }
                    catch (NumberFormatException e) {
                        this.objectDefinitionFilters[27] = null;
                    }
                } else {
                    this.objectDefinitionFilters[27] = null;
                }
            }
            if (!clippingAnyCheckbox.isSelected()) {
                this.objectDefinitionFilters[28] = clippingClippedCheckBox.isSelected() ? Integer.valueOf(1) : 2;
                usingFilters = true;
            } else {
                this.objectDefinitionFilters[28] = null;
            }
            ((JButton)UIPanels.generalComponents.get("defs_filter")).setText(usingFilters ? "*Filters" : "Filters");
            try {
                int id = this.inputDefsObjectIdToFind.getText().isEmpty() ? -3 : (this.searchDefinitionsByName.isSelected() || this.searchDefinitionsByOption.isSelected() ? -1 : Integer.parseInt(this.inputDefsObjectIdToFind.getText()));
                this.searchDefinitions(id);
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    public void drawObjectDefsTree(int objectId) {
        this.listDefsObjectIds = new JList(this.populateDefsList(objectId));
        this.defsObjectsScrollPane.setViewportView(this.listDefsObjectIds);
        this.listDefsObjectIds.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                int id;
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                String selectedValue = BottomMenu.this.listDefsObjectIds.getSelectedValue().toString();
                BottomMenu.this.selectedDefsObjectId = id = Integer.parseInt(selectedValue.substring(0, selectedValue.indexOf("-")).trim());
                if (id > -1) {
                    BottomMenu.this.setSelectedObjectDefValues();
                    if (BottomMenu.this.viewModelOnSelect.isSelected()) {
                        ObjectDefinition objectdefinition;
                        ObjectDefinition objectDefinition = objectdefinition = Class186.aClass112_2256 == null ? null : Class186.aClass112_2256.getObjectDefinitionsForId(BottomMenu.this.selectedDefsObjectId, 42);
                        if (objectdefinition != null) {
                            int type = objectdefinition.possibleTypes == null ? 10 : objectdefinition.possibleTypes[0];
                            RSMapperClient.editor.objectEditor.displayObjectOnModelViewer(id, type);
                        }
                    }
                }
            }
        });
        final JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem select = new JMenuItem("Select for Spawn");
        popupMenu.add(select);
        this.listDefsObjectIds.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent me) {
                if (SwingUtilities.isRightMouseButton(me) && !BottomMenu.this.listDefsObjectIds.isSelectionEmpty() && BottomMenu.this.listDefsObjectIds.locationToIndex(me.getPoint()) == BottomMenu.this.listDefsObjectIds.getSelectedIndex()) {
                    popupMenu.show(BottomMenu.this.listDefsObjectIds, me.getX(), me.getY());
                }
            }
        });
        select.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                int type;
                ObjectDefinition objectdefinition = Class186.aClass112_2256 == null ? null : Class186.aClass112_2256.getObjectDefinitionsForId(BottomMenu.this.selectedDefsObjectId, 42);
                int n2 = type = objectdefinition.possibleTypes == null ? 10 : objectdefinition.possibleTypes[0];
                if (RSMapperClient.editor.tool instanceof DefaultTool) {
                    ToolData.defaultObjectId = BottomMenu.this.selectedDefsObjectId;
                    ToolData.defaultObjectType = type;
                    if (UIPanels.objectComponents.get("input_id") != null) {
                        ((JTextField)UIPanels.objectComponents.get("input_id")).setText("" + BottomMenu.this.selectedDefsObjectId);
                    }
                    if (UIPanels.objectComponents.get("input_type") != null) {
                        ((JTextField)UIPanels.objectComponents.get("input_type")).setText("" + type);
                    }
                    if (UIPanels.objectComponents.get("input_rotation") != null && ((JTextField)UIPanels.objectComponents.get("input_rotation")).getText().isEmpty()) {
                        ((JTextField)UIPanels.objectComponents.get("input_rotation")).setText("" + ToolData.defaultObjectRotation);
                    }
                } else if (RSMapperClient.editor != null && RSMapperClient.editor.tool != null && RSMapperClient.editor.tool instanceof BrushTool) {
                    int i2 = ToolData.brushIncludedObjectId.length - 1;
                    while (i2 >= 0) {
                        if (ToolData.brushIncludedObjectSlots[i2]) {
                            ToolData.brushIncludedObjectId[i2] = BottomMenu.this.selectedDefsObjectId;
                            ToolData.brushIncludedObjectType[i2] = type;
                            if (UIPanels.objectComponents.get("input_id" + (i2 == 0 ? "" : Integer.valueOf(i2))) != null) {
                                ((JTextField)UIPanels.objectComponents.get("input_id" + (i2 == 0 ? "" : Integer.valueOf(i2)))).setText("" + BottomMenu.this.selectedDefsObjectId);
                            }
                            if (UIPanels.objectComponents.get("input_type" + (i2 == 0 ? "" : Integer.valueOf(i2))) != null) {
                                ((JTextField)UIPanels.objectComponents.get("input_type" + (i2 == 0 ? "" : Integer.valueOf(i2)))).setText("" + type);
                            }
                            if (UIPanels.objectComponents.get("input_rotation" + (i2 == 0 ? "" : Integer.valueOf(i2))) == null || !((JTextField)UIPanels.objectComponents.get("input_rotation" + (i2 == 0 ? "" : Integer.valueOf(i2)))).getText().isEmpty()) break;
                            ((JTextField)UIPanels.objectComponents.get("input_rotation" + (i2 == 0 ? "" : Integer.valueOf(i2)))).setText("" + ToolData.brushIncludedObjectRotation[i2]);
                            break;
                        }
                        --i2;
                    }
                }
            }
        });
    }

    public void setSelectedObjectDefValues() {
        int n2;
        byte[] byArray;
        ObjectDefinition objectdefinition;
        if (this.selectedDefsObjectId < 0) {
            return;
        }
        ObjectDefinition objectDefinition = objectdefinition = Class186.aClass112_2256 == null ? null : Class186.aClass112_2256.getObjectDefinitionsForId(this.selectedDefsObjectId, 42);
        if (objectdefinition == null) {
            return;
        }
        if (objectdefinition.possibleTypes == null) {
            byte[] byArray2 = new byte[1];
            byArray = byArray2;
            byArray2[0] = 10;
        } else {
            byArray = objectdefinition.possibleTypes;
        }
        byte[] types = byArray;
        int sizeX = objectdefinition.sizeX;
        int sizeY = objectdefinition.sizeY;
        String[] options = objectdefinition.options;
        int mapSprite = objectdefinition.mapSpriteId;
        int areaId = objectdefinition.mapAreaId;
        int animationId = objectdefinition.getFirstAnimation();
        int clipType = objectdefinition.clipType;
        String typeString = "";
        int i2 = 0;
        while (i2 < types.length) {
            typeString = String.valueOf(typeString) + types[i2] + (types.length == 1 || i2 == types.length - 1 ? "" : ", ");
            ++i2;
        }
        this.defValues[0].setText(typeString);
        this.defValues[1].setText("" + sizeX);
        this.defValues[2].setText("" + sizeY);
        this.defsObjectsOptions.removeAllItems();
        this.defsObjectsOptions.validate();
        if (options != null && options.length > 0) {
            String[] stringArray = options;
            n2 = options.length;
            int n3 = 0;
            while (n3 < n2) {
                String s = stringArray[n3];
                if (s != null && s.length() > 0) {
                    this.defsObjectsOptions.addItem(s);
                }
                ++n3;
            }
        }
        this.defsObjectsOptions.validate();
        this.defsObjectsOptions.repaint();
        this.defValues[3].setText("" + mapSprite);
        ((JLabel)UIPanels.generalComponents.get("sprite_img_label")).setIcon(null);
        if (mapSprite > -1) {
            int spriteId = Node_Sub54.aClass338_7671.method3909((int)objectdefinition.mapSpriteId, (int)34).spriteId;
            if (Cache.STORE.getIndexes()[8].getFile(spriteId) != null) {
                Image img = Utils.getImageFromSprite(16, 16, spriteId);
                ((JLabel)UIPanels.generalComponents.get("sprite_img_label")).setIcon(new ImageIcon(img));
            }
        }
        this.defValues[4].setText("" + areaId);
        ((JLabel)UIPanels.generalComponents.get("area_img_label")).setIcon(null);
        if (areaId > -1) {
            int spriteId = Class304.aClass215_3834.getAreaDefinitions((byte)101, (int)areaId).spriteId;
            if (Cache.STORE.getIndexes()[8].getFile(spriteId) != null) {
                Image img = Utils.getImageFromSprite(16, 16, spriteId);
                ((JLabel)UIPanels.generalComponents.get("area_img_label")).setIcon(new ImageIcon(img));
            }
        }
        this.defValues[5].setText("" + animationId);
        boolean handled = false;
        byte[] byArray3 = types;
        int n4 = types.length;
        n2 = 0;
        while (n2 < n4) {
            byte i3 = byArray3[n2];
            if (i3 == 22) {
                this.defValues[6].setText("True");
                handled = true;
            }
            ++n2;
        }
        if (!handled) {
            if (clipType == 0) {
                this.defValues[6].setText("True");
            } else {
                this.defValues[6].setText("False");
            }
        }
    }

    public DefaultListModel populateDefsList(int objectId) {
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        int size = ObjectDefinitions.getObjectDefinitionsSize();
        int i2 = 0;
        while (i2 < size) {
            block20: {
                try {
                    int n2;
                    int n3;
                    Object[] objectArray;
                    ObjectDefinitions objDefs = ObjectDefinitions.getObjectDefinitions(i2);
                    if (objDefs == null) break block20;
                    if (this.objectDefinitionFilters != null && ((JButton)UIPanels.generalComponents.get("defs_filter")).getText().startsWith("*")) {
                        boolean go;
                        if (objDefs.possibleTypes == null) {
                            if (!((Boolean)this.objectDefinitionFilters[10]).booleanValue() || this.objectDefinitionFilters[28] != null && (Integer)this.objectDefinitionFilters[28] == 2 && objDefs.clipType != 0) {
                                break block20;
                            }
                        } else {
                            go = false;
                            objectArray = new byte[][]{objDefs.possibleTypes};
                            n3 = objDefs.possibleTypes.length;
                            n2 = 0;
                            while (n2 < n3) {
                                byte b = (byte) objectArray[n2];
                                if (((Boolean)this.objectDefinitionFilters[b]).booleanValue()) {
                                    go = true;
                                    break;
                                }
                                ++n2;
                            }
                            if (!go) break block20;
                            if (this.objectDefinitionFilters[28] != null && (Integer)this.objectDefinitionFilters[28] > 0) {
                                boolean mustBeClipped = (Integer)this.objectDefinitionFilters[28] == 1;
                                boolean is22 = false;
                                byte[] byArray = objDefs.possibleTypes;
                                int n4 = objDefs.possibleTypes.length;
                                int n5 = 0;
                                while (n5 < n4) {
                                    byte b = byArray[n5];
                                    if (b == 22) {
                                        is22 = true;
                                        break;
                                    }
                                    ++n5;
                                }
                                if (mustBeClipped && (is22 || objDefs.clipType == 0) || !mustBeClipped && !is22 && objDefs.clipType > 0) break block20;
                            }
                        }
                        if (this.objectDefinitionFilters[23] != null && (Integer)this.objectDefinitionFilters[23] != objDefs.sizeX || this.objectDefinitionFilters[24] != null && (Integer)this.objectDefinitionFilters[24] != objDefs.sizeY || this.objectDefinitionFilters[25] != null && (Integer)this.objectDefinitionFilters[25] != objDefs.mapSpriteId || this.objectDefinitionFilters[26] != null && (Integer)this.objectDefinitionFilters[26] != objDefs.mapAreaId || this.objectDefinitionFilters[27] != null && ((Integer)this.objectDefinitionFilters[27]).intValue() != objDefs.getFirstAnimation() && Class186.aClass112_2256 != null && Class186.aClass112_2256.getObjectDefinitionsForId(i2, 42).getFirstAnimation() != ((Integer)this.objectDefinitionFilters[27]).intValue()) break block20;
                        if (this.objectDefinitionFilters[29] != null && !((String)this.objectDefinitionFilters[29]).isEmpty() && objDefs.options != null) {
                            go = false;
                            objectArray = objDefs.options;
                            n3 = objDefs.options.length;
                            n2 = 0;
                            while (n2 < n3) {
                                String s = (String) objectArray[n2]; // Changed byte to String to resolve the incompatible types error
                                if (((String)this.objectDefinitionFilters[29]).equalsIgnoreCase(s)) { // Fixed the comparison with String type
                                    go = true;
                                    break;
                                }
                                ++n2;
                            }
                            if (!go) break block20;
                        }
                    }
                    if (objectId == -1) {
                        String lowerName = objDefs.name.toLowerCase();
                        if (this.searchDefinitionsByName.isSelected()) {
                            if (lowerName.contains(this.inputDefsObjectIdToFind.getText().trim().toLowerCase())) {
                                listModel.addElement(String.valueOf(i2) + "  -  " + objDefs.name);
                            }
                            break block20;
                        }
                        if (!this.searchDefinitionsByOption.isSelected() || objDefs.options == null || objDefs.options.length <= 0) break block20;
                        objectArray = objDefs.options;
                        n3 = objDefs.options.length;
                        n2 = 0;
                        while (n2 < n3) {
                            byte option = (byte) objectArray[n2];
                            if (option != 0) { // Fixed the comparison with 0 instead of null
                                listModel.addElement(String.valueOf(i2) + "  -  " + objDefs.name);
                                break block20;
                            }
                            ++n2;
                        }
                        break block20;
                    }
                    listModel.addElement(String.valueOf(i2) + "  -  " + objDefs.name);
                }
                catch (Exception exception) {
                    // empty catch block
                }
            }
            ++i2;
        }
        return listModel;
    }

    public void searchDefinitions(int objectId) {
        this.selectedDefsObjectId = objectId;
        if (objectId > -1) {
            this.selectedDefsObjectId = objectId;
            this.setSelectedObjectDefValues();
        }
        this.drawObjectDefsTree(objectId);
        if (objectId > -1) {
            this.listDefsObjectIds.setSelectedIndex(objectId);
            int positionY = this.listDefsObjectIds.getSelectedIndex() < ObjectDefinitions.getObjectDefinitionsSize() - 3 ? this.listDefsObjectIds.getSelectedIndex() + 3 : this.listDefsObjectIds.getSelectedIndex();
            Rectangle bounds = this.listDefsObjectIds.getCellBounds(positionY, positionY);
            this.listDefsObjectIds.scrollRectToVisible(bounds);
            if (this.listDefsObjectIds.getFirstVisibleIndex() > objectId || this.listDefsObjectIds.getLastVisibleIndex() < objectId) {
                this.listDefsObjectIds.ensureIndexIsVisible(objectId);
            }
        }
    }

    public void makeNotesPanel() {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                int baseX = 0;
                BottomMenu.this.selectedNoteTitle = new JLabel();
                BottomMenu.this.selectedNoteTitle.setPreferredSize(new Dimension(451, 24));
                BottomMenu.this.selectedNoteTitle.setBounds(baseX + 155, 2, 451, 24);
                BottomMenu.this.selectedNoteTitle.setHorizontalAlignment(0);
                BottomMenu.this.selectedNoteTitle.setFont(new Font("Tahoma", 1, 13));
                BottomMenu.this.selectedNoteTitle.setBackground(new Color(151, 148, 144));
                BottomMenu.this.selectedNoteTitle.setForeground(new Color(200, 200, 200));
                BottomMenu.this.selectedNoteTitle.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
                BottomMenu.this.selectedNoteTitle.setOpaque(true);
                BottomMenu.this.notesPanel.add(BottomMenu.this.selectedNoteTitle);
                UIPanels.generalComponents.put("notes_note_title", BottomMenu.this.selectedNoteTitle);
                BottomMenu.this.inputNoteToFind = new JTextField();
                BottomMenu.this.inputNoteToFind.setBounds(baseX + 2, 4, 120, 24);
                BottomMenu.this.notesPanel.add(BottomMenu.this.inputNoteToFind);
                UIPanels.generalComponents.put("notes_input_name", BottomMenu.this.inputNoteToFind);
                JButton btnSearchNotes = new JButton(new ImageIcon("resources/images/search_icon_small.png"));
                btnSearchNotes.setBounds(baseX + 123, 4, 30, 24);
                btnSearchNotes.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        //BottomMenu.this.drawFoundNotesTree((this).BottomMenu.this.inputNoteToFind.getText(););
                    }
                });
                BottomMenu.this.notesPanel.add(btnSearchNotes);
                UIPanels.generalComponents.put("notes_search", btnSearchNotes);
                JButton btnAddNote = new JButton("New Note");
                btnAddNote.setBounds(baseX + 2, 179, 150, 26);
                btnAddNote.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        BottomMenu.this.addNewEmptyNote();
                    }
                });
                BottomMenu.this.notesPanel.add(btnAddNote);
                UIPanels.generalComponents.put("add_note", btnAddNote);
                BottomMenu.this.notesScrollPane = new JScrollPane();
                BottomMenu.this.notesScrollPane.setBounds(baseX, 32, 152, 145);
                BottomMenu.this.notesPanel.add(BottomMenu.this.notesScrollPane);
                UIPanels.generalComponents.put("notes_scroll_pane", BottomMenu.this.notesScrollPane);
                BottomMenu.this.noteBody = new JTextArea("");
                BottomMenu.this.noteBody.setEditable(false);
                BottomMenu.this.noteBody.setLineWrap(true);
                BottomMenu.this.noteBody.setWrapStyleWord(true);
                BottomMenu.this.noteBody.setFont(new Font("Tahoma", 0, 11));
                UIPanels.generalComponents.put("note_textarea", BottomMenu.this.noteBody);
                BottomMenu.this.noteScrollPane = new JScrollPane(BottomMenu.this.noteBody, 22, 30);
                BottomMenu.this.noteScrollPane.setPreferredSize(new Dimension(452, 151));
                BottomMenu.this.noteScrollPane.setBounds(baseX + 154, 27, 452, 151);
                BottomMenu.this.notesPanel.add(BottomMenu.this.noteScrollPane);
                UIPanels.generalComponents.put("note_scroll_pane", BottomMenu.this.noteScrollPane);
                BottomMenu.this.jtpData.addTab("Notes", new ImageIcon("resources/images/notes_icon.png"), BottomMenu.this.notesPanel);
                JButton btnRenameNote = new JButton("RENAME");
                btnRenameNote.setBounds(baseX + 154, 179, 100, 26);
                btnRenameNote.setForeground(Color.BLUE);
                btnRenameNote.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        BottomMenu.this.renameSelectedNote();
                    }
                });
                BottomMenu.this.notesPanel.add(btnRenameNote);
                UIPanels.generalComponents.put("rename_note", btnRenameNote);
                JButton btnSaveNote = new JButton("SAVE");
                btnSaveNote.setPreferredSize(new Dimension(248, 26));
                btnSaveNote.setBounds(baseX + 154 + 102, 179, 248, 26);
                btnSaveNote.setForeground(Color.GREEN);
                btnSaveNote.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        BottomMenu.this.saveSelectedNote();
                    }
                });
                BottomMenu.this.notesPanel.add(btnSaveNote);
                UIPanels.generalComponents.put("save_note", btnSaveNote);
                JButton btnDeleteNote = new JButton("DELETE");
                btnDeleteNote.setBounds(baseX + 154 + 102 + 250, 179, 100, 26);
                btnDeleteNote.setForeground(Color.RED);
                btnDeleteNote.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent arg0) {
                        BottomMenu.this.deleteSelectedNote();
                    }
                });
                BottomMenu.this.notesPanel.add(btnDeleteNote);
                UIPanels.generalComponents.put("delete_note", btnDeleteNote);
                BottomMenu.this.drawFoundNotesTree(null);
            }
        });
    }

    public DefaultListModel populateNotesList(String name) {
        DefaultListModel<String> listModel = new DefaultListModel<String>();
        File[] notes = new File("data/notes/").listFiles();
        int size = notes.length;
        int i2 = 0;
        while (i2 < size) {
            try {
                if (name == null) {
                    listModel.addElement(notes[i2].getName().replace(".txt", ""));
                } else if (notes[i2].getName().toLowerCase().contains(name.toLowerCase())) {
                    listModel.addElement(notes[i2].getName().replace(".txt", ""));
                }
            }
            catch (Exception ex) {
                System.err.format("Exception: %s%n", ex);
            }
            ++i2;
        }
        return listModel;
    }

    public void drawFoundNotesTree(String name) {
        this.listNotes = new JList(this.populateNotesList(name));
        this.notesScrollPane.setViewportView(this.listNotes);
        this.listNotes.addListSelectionListener(new ListSelectionListener(){

            @Override
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting()) {
                    return;
                }
                BottomMenu.this.selectedNoteFile = BottomMenu.this.listNotes.getSelectedValue().toString();
                BottomMenu.this.selectedNoteTitle.setText(BottomMenu.this.selectedNoteFile);
                try {
                    BottomMenu.this.sendNoteToTextArea(BottomMenu.this.selectedNoteFile);
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    public void sendNoteToTextArea(String noteFileName) throws Throwable {
        File noteFile;
        if (!noteFileName.contains(".txt")) {
            noteFileName = String.valueOf(noteFileName) + ".txt";
        }
        if (!(noteFile = new File("data/notes/" + noteFileName)).exists()) {
            return;
        }
        String allText = "";
        try {
            Throwable throwable = null;
            Object var5_7 = null;
            try (BufferedReader reader = new BufferedReader(new FileReader(noteFile));){
                String line;
                while ((line = reader.readLine()) != null) {
                    allText = String.valueOf(allText) + line + "\n";
                }
                reader.close();
            }
            catch (Throwable throwable2) {
                if (throwable == null) {
                    throwable = throwable2;
                } else if (throwable != throwable2) {
                    throwable.addSuppressed(throwable2);
                }
                throw throwable;
            }
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }
        this.noteBody.setText(allText);
        this.noteBody.setEditable(true);
        this.noteBody.setBackground(new Color(67, 60, 53));
    }

    public void addNewEmptyNote() {
        String noteName = "New note";
        int counter = 1;
        while (new File("data/notes/" + noteName + ".txt").exists()) {
            noteName = "New note (" + counter + ")";
            ++counter;
        }
        try {
            new File("data/notes/" + noteName + ".txt").createNewFile();
            this.drawFoundNotesTree(null);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteSelectedNote() {
        File noteFile;
        String noteFileName = this.selectedNoteFile;
        if (!noteFileName.contains(".txt")) {
            noteFileName = String.valueOf(noteFileName) + ".txt";
        }
        if (!(noteFile = new File("data/notes/" + noteFileName)).exists()) {
            return;
        }
        int choiceDelete = JOptionPane.showOptionDialog(null, "This note will be permanently deleted.", "Are you sure?", 0, -1, null, new Object[]{"Cancel", "Yes"}, "Cancel");
        if (choiceDelete == 1 && noteFile.delete()) {
            this.noteBody.setText("");
            this.noteBody.setEditable(false);
            this.selectedNoteTitle.setText("");
            this.selectedNoteFile = "";
            this.drawFoundNotesTree(null);
        }
    }

    public void renameSelectedNote() {
        File noteFile;
        String noteFileName = this.selectedNoteFile;
        if (!noteFileName.contains(".txt")) {
            noteFileName = String.valueOf(noteFileName) + ".txt";
        }
        if (!(noteFile = new File("data/notes/" + noteFileName)).exists()) {
            return;
        }
        JPanel al = new JPanel();
        al.setLayout(null);
        al.setSize(24, 86);
        al.setPreferredSize(new Dimension(50, al.getPreferredSize().height));
        JTextField title = new JTextField("Enter A New Name");
        title.setHorizontalAlignment(0);
        title.setBounds(25, 5, 185, 24);
        title.setEditable(false);
        al.add(title);
        final JTextField txtNewName = new JTextField();
        txtNewName.setHorizontalAlignment(0);
        txtNewName.setBounds(25, 30, 125, 24);
        al.add(txtNewName);
        JButton renameButton = new JButton("Check");
        renameButton.setBounds(151, 30, 60, 24);
        renameButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                File checkFile = new File("data/notes/" + txtNewName.getText());
                if (checkFile.exists()) {
                    txtNewName.setBorder(BorderFactory.createLineBorder(Color.RED, 2));
                } else {
                    txtNewName.setBorder(BorderFactory.createLineBorder(Color.GREEN, 2));
                }
            }
        });
        al.add(renameButton);
        int choiceRename = JOptionPane.showOptionDialog(null, al, "Rename Note File", 0, -1, null, new Object[]{"Cancel", "Rename"}, "Cancel");
        if (choiceRename == 1) {
            String newName = txtNewName.getText().replaceAll(" ", "_");
            noteFile.renameTo(new File("data/notes/" + newName + ".txt"));
            this.selectedNoteTitle.setText(newName);
            this.drawFoundNotesTree(null);
        }
    }

    public void saveSelectedNote() {
        File noteFile;
        String noteFileName = this.selectedNoteFile;
        if (!noteFileName.contains(".txt")) {
            noteFileName = String.valueOf(noteFileName) + ".txt";
        }
        if (!(noteFile = new File("data/notes/" + noteFileName)).exists()) {
            return;
        }
        String text = this.noteBody.getText();
        Throwable throwable = null;
        Object var5_7 = null;
        try (FileWriter writer = new FileWriter(noteFile);){
            writer.write(text);
            writer.close();
        }
        catch (Throwable throwable2) {
            if (throwable == null) {
                throwable = throwable2;
            } else if (throwable != throwable2) {
                throwable.addSuppressed(throwable2);
            }
            try {
                throw throwable;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void makeOverlaysPanel() {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                int shiftX = 0;
                int shiftY = 0;
                int i2 = 0;
                while (i2 < 255) {
                    int x = 3 + shiftX * 65;
                    int y = 2 + shiftY * 68;
                    JButton button = BottomMenu.this.createOverlayButton(i2 + 1, x, y);
                    BottomMenu.this.overlaysPanel.add(button);
                    UIPanels.generalComponents.put("btn_overlay_" + (i2 + 1), button);
                    if (++shiftX == 9) {
                        shiftX = 0;
                        ++shiftY;
                    }
                    ++i2;
                }
                BottomMenu.this.overlaysPanel.setBackground(Color.WHITE);
                JScrollPane scroll = new JScrollPane(BottomMenu.this.overlaysPanel);
                scroll.setPreferredSize(new Dimension(500, 1889));
                scroll.getVerticalScrollBar().setUnitIncrement(16);
                Image img = new ImageIcon("resources/overlays/19.png").getImage();
                Image newimg = img.getScaledInstance(20, 20, 4);
                BottomMenu.this.jtpData.addTab("Overlays", new ImageIcon(newimg), scroll, "Tile overlays");
            }
        });
    }

    private JButton createOverlayButton(final int overlay, int x, int y) {
        JButton button = new JButton();
        button.setBounds(x, y, 63, 67);
        try {
            Image img = ImageIO.read(new File("resources/overlays/" + overlay + ".png")).getScaledInstance(66, 66, 4);
            button.setIcon(new ImageIcon(img));
            img.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setContentAreaFilled(false);
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (UIPanels.propertyComponents.get("txt_overlay") != null) {
                    ((JTextField)UIPanels.propertyComponents.get("txt_overlay")).setText("" + (byte)overlay);
                    if (RSMapperClient.editor.mapEditor.dataLoaded && RSMapperClient.editor.tool instanceof DefaultTool) {
                        RSMapperClient.editor.saveMapState(false);
                        RSMapperClient.editor.mapEditor.saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.OVERLAY, (byte)overlay, false, true, false);
                    }
                    BottomMenu.this.updateOverlaysPanel(false);
                }
            }
        });
        return button;
    }

    public void updateOverlaysPanel(boolean fromClick) {
        if (RSMapperClient.editor.dataSelection != DataType.OVERLAYS) {
            return;
        }
        JTextField field = (JTextField)UIPanels.propertyComponents.get("txt_overlay");
        if (fromClick || !fromClick && field != null && !field.getText().isEmpty()) {
            try {
                byte overlay = fromClick ? (byte)RSMapperClient.editor.mapEditor.getValueFromTile(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.OVERLAY, false) : (byte)Integer.parseInt(field.getText().trim());
                int overlayInt = Utils.getIntFromByte(overlay);
                int i2 = 0;
                while (i2 < 255) {
                    if (UIPanels.generalComponents.get("btn_overlay_" + i2) != null) {
                        if (overlayInt == i2) {
                            ((JButton)UIPanels.generalComponents.get("btn_overlay_" + i2)).setBorderPainted(true);
                            ((JButton)UIPanels.generalComponents.get("btn_overlay_" + i2)).setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
                        } else {
                            ((JButton)UIPanels.generalComponents.get("btn_overlay_" + i2)).setBorderPainted(false);
                            ((JButton)UIPanels.generalComponents.get("btn_overlay_" + i2)).setBorder(null);
                        }
                    }
                    ++i2;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void makeUnderlaysPanel() {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                int shiftX = 0;
                int shiftY = 0;
                int i2 = 0;
                while (i2 < 166) {
                    int x = 3 + shiftX * 65;
                    int y = 2 + shiftY * 68;
                    JButton button = BottomMenu.this.createUnderlayButton(i2 + 1, x, y);
                    BottomMenu.this.underlaysPanel.add(button);
                    UIPanels.generalComponents.put("btn_underlay_" + (i2 + 1), button);
                    if (++shiftX == 9) {
                        shiftX = 0;
                        ++shiftY;
                    }
                    ++i2;
                }
                BottomMenu.this.underlaysPanel.setBackground(Color.WHITE);
                JScrollPane scroll = new JScrollPane(BottomMenu.this.underlaysPanel);
                scroll.setPreferredSize(new Dimension(500, 1889));
                scroll.getVerticalScrollBar().setUnitIncrement(16);
                Image img = new ImageIcon("resources/images/underlays_icon.png").getImage();
                Image newimg = img.getScaledInstance(20, 20, 4);
                BottomMenu.this.jtpData.addTab("Underlays", new ImageIcon(newimg), scroll, "Tile underlays");
            }
        });
    }

    private JButton createUnderlayButton(final int underlay, int x, int y) {
        JButton button = new JButton();
        button.setBounds(x, y, 63, 67);
        try {
            Image img = ImageIO.read(new File("resources/underlays/" + underlay + ".png")).getScaledInstance(66, 66, 4);
            button.setIcon(new ImageIcon(img));
            img.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        button.setBorderPainted(false);
        button.setBorder(null);
        button.setContentAreaFilled(false);
        button.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                if (UIPanels.propertyComponents.get("txt_underlay") != null) {
                    ((JTextField)UIPanels.propertyComponents.get("txt_underlay")).setText("" + underlay);
                    if (RSMapperClient.editor.mapEditor.dataLoaded && RSMapperClient.editor.tool instanceof DefaultTool) {
                        RSMapperClient.editor.saveMapState(false);
                        RSMapperClient.editor.mapEditor.saveTileWithNewProperty(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.UNDERLAY, underlay, false, true, false);
                    }
                    BottomMenu.this.updateUnderlaysPanel(false);
                }
            }
        });
        return button;
    }

    public void updateUnderlaysPanel(boolean fromClick) {
        if (RSMapperClient.editor.dataSelection != DataType.UNDERLAYS) {
            return;
        }
        JTextField field = (JTextField)UIPanels.propertyComponents.get("txt_underlay");
        if (fromClick || !fromClick && field != null && !field.getText().isEmpty()) {
            try {
                byte underlay = fromClick ? (byte)RSMapperClient.editor.mapEditor.getValueFromTile(RSMapperClient.editor.selectedTile, MapEditor.PropertyType.UNDERLAY, false) : (byte)Integer.parseInt(field.getText().trim());
                int underlayInt = Utils.getIntFromByte(underlay);
                int i2 = 0;
                while (i2 < 166) {
                    if (UIPanels.generalComponents.get("btn_underlay_" + i2) != null) {
                        if (underlayInt == i2) {
                            ((JButton)UIPanels.generalComponents.get("btn_underlay_" + i2)).setBorderPainted(true);
                            ((JButton)UIPanels.generalComponents.get("btn_underlay_" + i2)).setBorder(BorderFactory.createLineBorder(Color.GREEN, 4));
                        } else {
                            ((JButton)UIPanels.generalComponents.get("btn_underlay_" + i2)).setBorderPainted(false);
                            ((JButton)UIPanels.generalComponents.get("btn_underlay_" + i2)).setBorder(null);
                        }
                    }
                    ++i2;
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

