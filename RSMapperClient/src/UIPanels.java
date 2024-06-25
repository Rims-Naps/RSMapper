import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class UIPanels extends RSMapperClient {
   private static final long serialVersionUID = -6287270377186749053L;
   static final int GENERAL_COMPONENTS = 1;
   static final int PROPERTY_COMPONENTS = 3;
   static final int OBJECT_COMPONENTS = 2;
   static JPanel topPanel;
   static JPanel rightPanel;
   static JPanel leftPanel;
   static JPanel bottomPanel;
   static JTabbedPane jtpEditing;
   static JPanel propertiesTabPanel;
   static JPanel objectsTabPanel;
   static ConcurrentHashMap<String, JComponent> generalComponents;
   static ConcurrentHashMap<String, JComponent> propertyComponents;
   static ConcurrentHashMap<String, JComponent> objectComponents;

   public UIPanels() {
      generalComponents = new ConcurrentHashMap<>();
      propertyComponents = new ConcurrentHashMap<>();
      objectComponents = new ConcurrentHashMap<>();
      topPanel = new JPanel();
      topPanel.setLayout(null);
      topPanel.setPreferredSize(new Dimension(784, 40));
      topPanel.setBackground(new Color(130, 130, 130));
      topPanel.setBorder(BorderFactory.createLineBorder(Color.black));
      client_frame.getContentPane().add(topPanel, "North");
      rightPanel = new JPanel();
      rightPanel.setLayout(null);
      rightPanel.setPreferredSize(new Dimension(300, 600));
      rightPanel.setBackground(new Color(190, 190, 190));
      client_frame.getContentPane().add(rightPanel, "East");
      leftPanel = new JPanel();
      leftPanel.setLayout(null);
      leftPanel.setPreferredSize(new Dimension(76, 544));
      leftPanel.setBackground(new Color(160, 160, 160));
      leftPanel.setBorder(BorderFactory.createLineBorder(Color.black));
      client_frame.getContentPane().add(leftPanel, "West");
      bottomPanel = new BottomMenu();
      bottomPanel.setLayout(null);
      bottomPanel.setPreferredSize(new Dimension(784, 252));
      bottomPanel.setBackground(new Color(190, 190, 190));
      client_frame.getContentPane().add(bottomPanel, "South");
      jtpEditing = new JTabbedPane();
      jtpEditing.setLayout(new BorderLayout());
      jtpEditing.setPreferredSize(new Dimension(300, 517));
      jtpEditing.setBounds(0, 83, 300, 517);
      propertiesTabPanel = new JPanel(false);
      propertiesTabPanel.setPreferredSize(new Dimension(300, 470));
      propertiesTabPanel.setLayout(null);
      jtpEditing.addTab("Properties", new ImageIcon("resources/images/tileproperties_icon.png"), propertiesTabPanel, "Edit tile properties");
      jtpEditing.setMnemonicAt(0, 49);
      objectsTabPanel = new JPanel(false);
      objectsTabPanel.setPreferredSize(new Dimension(300, 470));
      objectsTabPanel.setLayout(null);
      jtpEditing.addTab("Objects", new ImageIcon("resources/images/objects_icon.png"), objectsTabPanel, "Edit object spawns");
      jtpEditing.setMnemonicAt(1, 50);
      jtpEditing.addChangeListener(
         new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
               if (RSMapperClient.editor != null && RSMapperClient.editor.editing != null && UIPanels.jtpEditing.getSelectedIndex() >= 0) {
                  RSMapperClient.editor
                     .setEditing(
                        UIPanels.jtpEditing.getTitleAt(UIPanels.jtpEditing.getSelectedIndex()).equalsIgnoreCase("properties")
                           ? EditorType.PROPERTIES
                           : EditorType.OBJECTS
                     );
               }
            }
         }
      );
      rightPanel.add(jtpEditing);
      jtpEditing.setTabLayoutPolicy(1);
      this.makeToolModeDisplay();
      this.makeAtmosphereSettingsButton();
      this.makeDoubleClickActionCB();
      this.makeCameraSpeedDisplay();
      this.makeToggleOrthoButton();
      this.makeToggleObjectsButton();
      this.makeTogglePlayerButton();
      this.makeToggleAtmosphereButton();
      this.makeRefreshMinimapButton();
      this.makeMultiCheckboxAndClearButton();
      this.makeBrushSelection();
      this.makeCoordinateDisplay();
      this.makeCoordinateButtons();
      ((BottomMenu)bottomPanel).setup();
   }

   public void makeToolModeDisplay() {
      JLabel toolsLabel = (JLabel)makeLabel("Modes", new ImageIcon("resources/images/tools_icon.png"), 0, 0, 80, 40, leftPanel);
      toolsLabel.setBorder(new EmptyBorder(0, 6, 0, 0));
      toolsLabel.setOpaque(true);
      toolsLabel.setFont(new Font("", 1, 12));
      JSeparator sep = new JSeparator(0);
      sep.setBounds(0, 35, 80, 3);
      leftPanel.add(sep);
      generalComponents.put("tools_sep1", sep);
      this.makeDefaultToolButton();
      this.makeBrushToolButton();
      this.makeHeightToolButton();
      this.makeBridgeToolButton();
      this.makeShapeToolButton();
      this.makeFXToolButton();
   }

   public void makeDefaultToolButton() {
      JButton defaultButton = (JButton)this.makeButton("Single", null, null, 6, 48, 62, 24, true, leftPanel);
      generalComponents.put("single_tool_button", defaultButton);
      defaultButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               RSMapperClient.editor.setTool(new DefaultTool());
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }
      });
   }

   public void makeBrushToolButton() {
      JButton paintButton = (JButton)this.makeButton("Brush", null, null, 6, 78, 62, 24, true, leftPanel);
      generalComponents.put("brush_tool_button", paintButton);
      paintButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               RSMapperClient.editor.setTool(new BrushTool());
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }
      });
   }

   public void makeHeightToolButton() {
      JButton heightButton = (JButton)this.makeButton("Height", null, null, 6, 108, 62, 24, true, leftPanel);
      generalComponents.put("height_tool_button", heightButton);
      heightButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               RSMapperClient.editor.setTool(new HeightTool());
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }
      });
   }

   public void makeBridgeToolButton() {
      JButton bridgeTool = (JButton)this.makeButton("Bridge", null, null, 6, 138, 62, 24, true, leftPanel);
      generalComponents.put("bridge_tool_button", bridgeTool);
      bridgeTool.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               RSMapperClient.editor.setTool(new BridgeTool());
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }
      });
   }

   public void makeShapeToolButton() {
      JButton shapeTool = (JButton)this.makeButton("Shape", null, null, 6, 168, 62, 24, true, leftPanel);
      generalComponents.put("shape_tool_button", shapeTool);
      shapeTool.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               RSMapperClient.editor.setTool(new ShapeTool());
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }
      });
   }

   public void makeFXToolButton() {
      JButton FXTool = (JButton)this.makeButton("Light FX", null, null, 6, 198, 62, 24, true, leftPanel);
      generalComponents.put("fx_tool_button", FXTool);
      FXTool.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               RSMapperClient.editor.setTool(new FXTool());
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }
      });
   }

   protected void makeCoordinateDisplay() {
      makeLabel("MOUSE:", null, 10, 0, 60, 24, rightPanel);
      makeLabel("SELECTED:", null, 6, 25, 60, 24, rightPanel);
      this.makeTextField("X", Color.red, 70, 0, 20, 24, false, rightPanel);
      generalComponents.put("mouse_x", this.makeTextField("", null, 90, 0, 45, 24, false, rightPanel));
      this.makeTextField("Y", Color.green, 135, 0, 20, 24, false, rightPanel);
      generalComponents.put("mouse_y", this.makeTextField("", null, 155, 0, 45, 24, false, rightPanel));
      this.makeTextField("P", Color.blue, 200, 0, 20, 24, false, rightPanel);
      generalComponents.put("mouse_p", this.makeTextField("", null, 220, 0, 45, 24, false, rightPanel));
      this.makeTextField("X", Color.red, 70, 24, 20, 24, false, rightPanel);
      generalComponents.put("select_x", this.makeTextField("", null, 90, 24, 45, 24, false, rightPanel));
      this.makeTextField("Y", Color.green, 135, 24, 20, 24, false, rightPanel);
      generalComponents.put("select_y", this.makeTextField("", null, 155, 24, 45, 24, false, rightPanel));
      this.makeTextField("P", Color.blue, 200, 24, 20, 24, false, rightPanel);
      generalComponents.put("select_p", this.makeTextField("", null, 220, 24, 45, 24, false, rightPanel));
   }

   protected void makeCoordinateButtons() {
      JButton buttonDX = (JButton)this.makeButton("X", new ImageIcon("resources/images/decrement.png"), null, 18, 53, 40, 24, true, rightPanel);
      generalComponents.put("decrement_x", buttonDX);
      buttonDX.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               try {
                  int shift = RSMapperClient.editor.brush.isMulti() && RSMapperClient.editor.tool.supportsMulti() ? RSMapperClient.editor.brush.getSize() : 1;
                  RSMapperClient.editor
                     .setSelectedTile(
                        RSMapperClient.editor.selectedTile.getX() - shift,
                        RSMapperClient.editor.selectedTile.getY(),
                        RSMapperClient.editor.selectedTile.getPlane(),
                        false
                     );
                  ((JTextField)UIPanels.generalComponents.get("select_x")).setText("" + RSMapperClient.editor.selectedTile.getX());
                  if (RSMapperClient.editor.tool != null) {
                     RSMapperClient.editor.tool.setFields();
                     if (RSMapperClient.editor.brush.isMulti() && RSMapperClient.editor.tool.supportsMulti()) {
                        for(WorldTile t : RSMapperClient.editor
                           .brush
                           .getTilesBasedOnBrushAndSize(
                              RSMapperClient.editor.selectedTile.getLocalX(),
                              RSMapperClient.editor.selectedTile.getLocalY(),
                              RSMapperClient.editor.selectedTile.getPlane(),
                              true
                           )) {
                           RSMapperClient.editor.addToSelectedTiles(t);
                        }
                     }
                  }
   
                  RSMapperClient.setFocusOnCanvas();
               } catch (Exception var5) {
                  var5.printStackTrace();
               }
            }
         }
      );
      JButton buttonIX = (JButton)this.makeButton("X", new ImageIcon("resources/images/increment.png"), null, 58, 53, 40, 24, true, rightPanel);
      buttonIX.setHorizontalTextPosition(10);
      generalComponents.put("increment_x", buttonIX);
      buttonIX.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               try {
                  int shift = RSMapperClient.editor.brush.isMulti() && RSMapperClient.editor.tool.supportsMulti() ? RSMapperClient.editor.brush.getSize() : 1;
                  RSMapperClient.editor
                     .setSelectedTile(
                        RSMapperClient.editor.selectedTile.getX() + shift,
                        RSMapperClient.editor.selectedTile.getY(),
                        RSMapperClient.editor.selectedTile.getPlane(),
                        false
                     );
                  ((JTextField)UIPanels.generalComponents.get("select_x")).setText("" + RSMapperClient.editor.selectedTile.getX());
                  if (RSMapperClient.editor.tool != null) {
                     RSMapperClient.editor.tool.setFields();
                     if (RSMapperClient.editor.brush.isMulti() && RSMapperClient.editor.tool.supportsMulti()) {
                        for(WorldTile t : RSMapperClient.editor
                           .brush
                           .getTilesBasedOnBrushAndSize(
                              RSMapperClient.editor.selectedTile.getLocalX(),
                              RSMapperClient.editor.selectedTile.getLocalY(),
                              RSMapperClient.editor.selectedTile.getPlane(),
                              true
                           )) {
                           RSMapperClient.editor.addToSelectedTiles(t);
                        }
                     }
                  }
   
                  RSMapperClient.setFocusOnCanvas();
               } catch (Exception var5) {
                  var5.printStackTrace();
               }
            }
         }
      );
      JButton buttonDY = (JButton)this.makeButton("Y", new ImageIcon("resources/images/decrement.png"), null, 108, 53, 40, 24, true, rightPanel);
      generalComponents.put("decrement_y", buttonDY);
      buttonDY.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               try {
                  int shift = RSMapperClient.editor.brush.isMulti() && RSMapperClient.editor.tool.supportsMulti() ? RSMapperClient.editor.brush.getSize() : 1;
                  RSMapperClient.editor
                     .setSelectedTile(
                        RSMapperClient.editor.selectedTile.getX(),
                        RSMapperClient.editor.selectedTile.getY() - shift,
                        RSMapperClient.editor.selectedTile.getPlane(),
                        false
                     );
                  ((JTextField)UIPanels.generalComponents.get("select_y")).setText("" + RSMapperClient.editor.selectedTile.getY());
                  if (RSMapperClient.editor.tool != null) {
                     RSMapperClient.editor.tool.setFields();
                     if (RSMapperClient.editor.brush.isMulti() && RSMapperClient.editor.tool.supportsMulti()) {
                        for(WorldTile t : RSMapperClient.editor
                           .brush
                           .getTilesBasedOnBrushAndSize(
                              RSMapperClient.editor.selectedTile.getLocalX(),
                              RSMapperClient.editor.selectedTile.getLocalY(),
                              RSMapperClient.editor.selectedTile.getPlane(),
                              true
                           )) {
                           RSMapperClient.editor.addToSelectedTiles(t);
                        }
                     }
                  }
   
                  RSMapperClient.setFocusOnCanvas();
               } catch (Exception var5) {
                  var5.printStackTrace();
               }
            }
         }
      );
      JButton buttonIY = (JButton)this.makeButton("Y", new ImageIcon("resources/images/increment.png"), null, 148, 53, 40, 24, true, rightPanel);
      buttonIY.setHorizontalTextPosition(10);
      generalComponents.put("increment_y", buttonIY);
      buttonIY.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               try {
                  int shift = RSMapperClient.editor.brush.isMulti() && RSMapperClient.editor.tool.supportsMulti() ? RSMapperClient.editor.brush.getSize() : 1;
                  RSMapperClient.editor
                     .setSelectedTile(
                        RSMapperClient.editor.selectedTile.getX(),
                        RSMapperClient.editor.selectedTile.getY() + shift,
                        RSMapperClient.editor.selectedTile.getPlane(),
                        false
                     );
                  ((JTextField)UIPanels.generalComponents.get("select_y")).setText("" + RSMapperClient.editor.selectedTile.getY());
                  if (RSMapperClient.editor.tool != null) {
                     RSMapperClient.editor.tool.setFields();
                     if (RSMapperClient.editor.brush.isMulti() && RSMapperClient.editor.tool.supportsMulti()) {
                        for(WorldTile t : RSMapperClient.editor
                           .brush
                           .getTilesBasedOnBrushAndSize(
                              RSMapperClient.editor.selectedTile.getLocalX(),
                              RSMapperClient.editor.selectedTile.getLocalY(),
                              RSMapperClient.editor.selectedTile.getPlane(),
                              true
                           )) {
                           RSMapperClient.editor.addToSelectedTiles(t);
                        }
                     }
                  }
   
                  RSMapperClient.setFocusOnCanvas();
               } catch (Exception var5) {
                  var5.printStackTrace();
               }
            }
         }
      );
      JButton buttonDP = (JButton)this.makeButton("P", new ImageIcon("resources/images/decrement.png"), null, 198, 53, 40, 24, true, rightPanel);
      generalComponents.put("decrement_p", buttonDP);
      buttonDP.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               try {
                  RSMapperClient.editor
                     .setSelectedTile(
                        RSMapperClient.editor.selectedTile.getX(),
                        RSMapperClient.editor.selectedTile.getY(),
                        RSMapperClient.editor.selectedTile.getPlane() - 1,
                        false
                     );
                  ((JTextField)UIPanels.generalComponents.get("select_p")).setText("" + RSMapperClient.editor.selectedTile.getPlane());
                  if (RSMapperClient.editor.tool != null) {
                     RSMapperClient.editor.tool.setFields();
                     if (RSMapperClient.editor.brush.isMulti() && RSMapperClient.editor.tool.supportsMulti()) {
                        for(WorldTile t : RSMapperClient.editor
                           .brush
                           .getTilesBasedOnBrushAndSize(
                              RSMapperClient.editor.selectedTile.getLocalX(),
                              RSMapperClient.editor.selectedTile.getLocalY(),
                              RSMapperClient.editor.selectedTile.getPlane(),
                              true
                           )) {
                           RSMapperClient.editor.addToSelectedTiles(t);
                        }
                     }
                  }
   
                  RSMapperClient.setFocusOnCanvas();
               } catch (Exception var4) {
                  var4.printStackTrace();
               }
            }
         }
      );
      JButton buttonIP = (JButton)this.makeButton("P", new ImageIcon("resources/images/increment.png"), null, 238, 53, 40, 24, true, rightPanel);
      buttonIP.setHorizontalTextPosition(10);
      generalComponents.put("increment_p", buttonIP);
      buttonIP.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               try {
                  RSMapperClient.editor
                     .setSelectedTile(
                        RSMapperClient.editor.selectedTile.getX(),
                        RSMapperClient.editor.selectedTile.getY(),
                        RSMapperClient.editor.selectedTile.getPlane() + 1,
                        false
                     );
                  ((JTextField)UIPanels.generalComponents.get("select_p")).setText("" + RSMapperClient.editor.selectedTile.getPlane());
                  if (RSMapperClient.editor.tool != null) {
                     RSMapperClient.editor.tool.setFields();
                     if (RSMapperClient.editor.brush.isMulti() && RSMapperClient.editor.tool.supportsMulti()) {
                        for(WorldTile t : RSMapperClient.editor
                           .brush
                           .getTilesBasedOnBrushAndSize(
                              RSMapperClient.editor.selectedTile.getLocalX(),
                              RSMapperClient.editor.selectedTile.getLocalY(),
                              RSMapperClient.editor.selectedTile.getPlane(),
                              true
                           )) {
                           RSMapperClient.editor.addToSelectedTiles(t);
                        }
                     }
                  }
   
                  RSMapperClient.setFocusOnCanvas();
               } catch (Exception var4) {
                  var4.printStackTrace();
               }
            }
         }
      );
   }

   public void makeDoubleClickActionCB() {
      final JComboBox<String> cb = new JComboBox<>();
      cb.setBounds(183, 5, 80, 30);
      cb.setEnabled(false);
      cb.setLightWeightPopupEnabled(false);
      cb.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (((JComboBox)e.getSource()).getSelectedIndex() < 0) {
                  cb.setEnabled(false);
               } else {
                  if (e.getModifiers() != 0 && RSMapperClient.editor != null && RSMapperClient.editor.tool != null) {
                     if (((JComboBox)e.getSource()).getSelectedItem() == "Teleport") {
                        RSMapperClient.editor
                           .tool
                           .setDoubleClickAction(ToolData.ActionValues.TELEPORT.getValue(), RSMapperClient.editor.editing == EditorType.PROPERTIES, true);
                     } else if (RSMapperClient.editor.tool.getActionValues() != null) {
                        RSMapperClient.editor
                           .tool
                           .setDoubleClickAction(
                              RSMapperClient.editor.tool.getActionValues()[((JComboBox)e.getSource()).getSelectedIndex()],
                              RSMapperClient.editor.editing == EditorType.PROPERTIES,
                              true
                           );
                     }
   
                     RSMapperClient.setFocusOnCanvas();
                  }
               }
            }
         }
      );
      topPanel.add(cb);
      generalComponents.put("cb_doubleclick_action", cb);
      final JCheckBox toggleDoubleClick = new JCheckBox("Double Click:");
      toggleDoubleClick.setBorder(BorderFactory.createLineBorder(Color.BLACK));
      toggleDoubleClick.setBorderPainted(true);
      toggleDoubleClick.setBounds(84, 5, 100, 30);
      toggleDoubleClick.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (RSMapperClient.editor.tool != null) {
               if (toggleDoubleClick.isSelected()) {
                  RSMapperClient.editor.tool.setupDoubleClickActionCB();
                  RSMapperClient.editor.tool.setTimesTileClicked(1);
               }
            } else {
               toggleDoubleClick.setSelected(false);
            }

            if (!toggleDoubleClick.isSelected()) {
               cb.setEnabled(false);
            }

            RSMapperClient.setFocusOnCanvas();
         }
      });
      topPanel.add(toggleDoubleClick);
      generalComponents.put("toggle_doubleclick", toggleDoubleClick);
   }

   public void makeBrushSelection() {
      final JComboBox<BrushType> cb = new JComboBox<>(
         new BrushType[]{BrushType.SQUARE, BrushType.RHOMBUS, BrushType.CIRCLE, BrushType.LINE_X, BrushType.LINE_Y}
      );
      cb.setBounds(975, 5, 130, 30);
      cb.setSelectedIndex(0);
      cb.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if (((JComboBox)e.getSource()).getSelectedIndex() >= 0) {
                  if (RSMapperClient.editor != null
                     && RSMapperClient.editor.tool != null
                     && RSMapperClient.editor.brush != null
                     && !RSMapperClient.editor.tool.canUseBrush(BrushType.values()[((JComboBox)e.getSource()).getSelectedIndex()])) {
                     RSMapperClient.editor.brush.setType(BrushType.SQUARE);
                     cb.setSelectedIndex(0);
                  } else if (RSMapperClient.editor != null && RSMapperClient.editor.brush != null) {
                     RSMapperClient.editor.brush.setType(BrushType.values()[((JComboBox)e.getSource()).getSelectedIndex()]);
                  }
   
                  RSMapperClient.setFocusOnCanvas();
               }
            }
         }
      );
      topPanel.add(cb);
      generalComponents.put("cb_brushtype", cb);
      JSlider slider = new JSlider(0, 1, Brush.MAX_SIZE, 1);
      slider.setBounds(1110, 10, 120, 20);
      slider.setMajorTickSpacing(2);
      slider.setMinorTickSpacing(0);
      slider.setSnapToTicks(true);
      slider.setPaintTicks(true);
      slider.setPaintLabels(true);
      final JLabel sizeLabel = (JLabel)makeLabel("1", null, 1232, 10, 20, 20, topPanel);
      generalComponents.put("label_brushsize", sizeLabel);
      slider.addChangeListener(new ChangeListener() {
         @Override
         public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
               RSMapperClient.editor.brush.setSize(source.getValue());
               sizeLabel.setText("" + RSMapperClient.editor.brush.getSize());
            }

            RSMapperClient.setFocusOnCanvas();
         }
      });
      topPanel.add(slider);
      generalComponents.put("slider_brushsize", slider);
   }

   public void makeMultiCheckboxAndClearButton() {
      final JButton buttonClear = (JButton)this.makeButton("Clear", null, null, 832, 8, 40, 24, true, topPanel);
      buttonClear.setEnabled(false);
      buttonClear.setFont(new Font("Arial", 0, 10));
      buttonClear.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
      generalComponents.put("clear_selected_tiles", buttonClear);
      buttonClear.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               if (RSMapperClient.editor != null && RSMapperClient.editor.selectedTiles != null && RSMapperClient.editor.brush != null) {
                  RSMapperClient.editor.selectedTiles.clear();
                  RSMapperClient.editor.selectedTiles = RSMapperClient.editor.brush.getTilesBasedOnBrushAndSize(RSMapperClient.editor.selectedTile);
               }

               RSMapperClient.setFocusOnCanvas();
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }
      });
      final JCheckBox toggleMulti = new JCheckBox("Multi");
      toggleMulti.setBounds(765, 5, 50, 30);
      toggleMulti.setFont(new Font("Arial", 0, 10));
      toggleMulti.setSelected(false);
      toggleMulti.setEnabled(false);
      toggleMulti.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent e) {
            if (RSMapperClient.editor.brush != null) {
               RSMapperClient.editor.brush.setMulti(RSMapperClient.editor.tool == null ? false : toggleMulti.isSelected());
               buttonClear.setEnabled(true);
               RSMapperClient.setFocusOnCanvas();
            }
         }
      });
      topPanel.add(toggleMulti);
      generalComponents.put("toggle_multi", toggleMulti);
   }

   public static void clearComponents(int type) {
      Iterator<Entry<String, JComponent>> it$ = null;
      if (type == 3 && propertyComponents != null) {
         it$ = propertyComponents.entrySet().iterator();
      } else if (type == 2 && objectComponents != null) {
         it$ = objectComponents.entrySet().iterator();
      } else if (type == 1 && generalComponents != null) {
         it$ = generalComponents.entrySet().iterator();
      }

      if (it$ != null) {
         while(it$.hasNext()) {
            Entry<String, JComponent> entry = it$.next();
            JComponent comp = entry.getValue();
            comp.removeAll();
            if (type == 3) {
               propertiesTabPanel.remove(comp);
            } else if (type == 2) {
               objectsTabPanel.remove(comp);
            } else if (type == 1) {
               topPanel.remove(comp);
            }

            comp.removeAll();
            it$.remove();
         }
      }

      if (type == 3) {
         propertiesTabPanel.revalidate();
         propertiesTabPanel.repaint();
      } else if (type == 2) {
         objectsTabPanel.revalidate();
         objectsTabPanel.repaint();
      } else if (type == 1) {
         topPanel.revalidate();
         topPanel.repaint();
      }
   }

   protected JComponent makeButton(String text, ImageIcon image, Color color, int x, int y, int width, int height, boolean enabled, JPanel dock) {
      JButton button = image == null ? new JButton(text) : new JButton(text, image);
      button.setBounds(x, y, width, height);
      button.setEnabled(enabled);
      if (color != null) {
         button.setForeground(color);
      }

      dock.add(button);
      return button;
   }

   protected JComponent makeTextField(String text, Color color, int x, int y, int width, int height, boolean editable, JPanel dock) {
      JTextField textfield = new JTextField(text);
      textfield.setBounds(x, y, width, height);
      textfield.setEditable(editable);
      if (color != null) {
         textfield.setForeground(color);
      }

      dock.add(textfield);
      return textfield;
   }

   public static JComponent makeLabel(String text, ImageIcon icon, int x, int y, int width, int height, JPanel dock) {
      JLabel label = new JLabel(text);
      if (icon != null) {
         label.setIcon(icon);
      }

      label.setBounds(x, y, width, height);
      dock.add(label);
      return label;
   }

   protected void makeAtmosphereSettingsButton() {
      int shiftX = 5;
      JButton button = new JButton(new ImageIcon("resources/images/env_icon.png"));
      button.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
      button.setText("Settings");
      button.setIconTextGap(0);
      button.setToolTipText("Edit Atmosphere");
      button.setBounds(shiftX, 8, 68, 24);
      button.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               if (!RSMapperClient.MAP_LOADED) {
                  JOptionPane.showMessageDialog(
                     RSMapperClient.client_frame, "You need to first load a region in order to edit its atmosphere.", "No Map Region Loaded", 1
                  );
               } else {
                  JPanel al = new JPanel();
                  al.setLayout(null);
                  al.setSize(255, 465);
                  al.setPreferredSize(new Dimension(255, al.getPreferredSize().height));
                  int shiftY = -20;
                  JLabel hlLabel = new JLabel("Highlight Color");
                  hlLabel.setBounds(5, shiftY + 20, 100, 24);
                  al.add(hlLabel);
                  JLabel hlRLabel = new JLabel("R");
                  hlRLabel.setForeground(Color.RED);
                  hlRLabel.setBounds(5, shiftY + 43, 10, 24);
                  al.add(hlRLabel);
                  final JTextField txtHighlightR = new JTextField("" + Utils.getRGBFromInt(RSMapperClient.editor.mapEditor.highlightcolor[0])[0]);
                  txtHighlightR.setBounds(16, shiftY + 43, 40, 22);
                  al.add(txtHighlightR);
                  JLabel hlGLabel = new JLabel("G");
                  hlGLabel.setForeground(Color.GREEN);
                  hlGLabel.setBounds(60, shiftY + 43, 10, 24);
                  al.add(hlGLabel);
                  final JTextField txtHighlightG = new JTextField("" + Utils.getRGBFromInt(RSMapperClient.editor.mapEditor.highlightcolor[0])[1]);
                  txtHighlightG.setBounds(72, shiftY + 43, 40, 22);
                  al.add(txtHighlightG);
                  JLabel hlBLabel = new JLabel("B");
                  hlBLabel.setForeground(Color.BLUE);
                  hlBLabel.setBounds(115, shiftY + 43, 10, 24);
                  al.add(hlBLabel);
                  final JTextField txtHighlightB = new JTextField("" + Utils.getRGBFromInt(RSMapperClient.editor.mapEditor.highlightcolor[0])[2]);
                  txtHighlightB.setBounds(126, shiftY + 43, 40, 22);
                  al.add(txtHighlightB);
                  JButton buttonFindHighlightColor = (JButton)UIPanels.this.makeButton("Choose", null, null, 170, shiftY + 43, 75, 22, true, UIPanels.topPanel);
                  buttonFindHighlightColor.setForeground(Color.ORANGE);
                  buttonFindHighlightColor.addActionListener(
                     new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                           try {
                              Color colorToShow = new Color(
                                 Integer.parseInt(txtHighlightR.getText()),
                                 Integer.parseInt(txtHighlightG.getText()),
                                 Integer.parseInt(txtHighlightB.getText())
                              );
                              Color color = JColorChooser.showDialog(null, "Choose a color", colorToShow);
                              if (color != null) {
                                 txtHighlightR.setText("" + color.getRed());
                                 txtHighlightG.setText("" + color.getGreen());
                                 txtHighlightB.setText("" + color.getBlue());
                              }
                           } catch (NumberFormatException var4) {
                           }
                        }
                     }
                  );
                  al.add(buttonFindHighlightColor);
                  JLabel bLabel = new JLabel("Brightness");
                  bLabel.setBounds(5, shiftY + 67, 100, 24);
                  al.add(bLabel);
                  final JTextField txtBrightness = new JTextField("" + (int)(RSMapperClient.editor.mapEditor.brightness[0] * 256.0F));
                  txtBrightness.setBounds(10, shiftY + 90, 100, 22);
                  al.add(txtBrightness);
                  final JSlider brightnessSlider = new JSlider(0, -300, 750, (int)(RSMapperClient.editor.mapEditor.brightness[0] * 256.0F));
                  brightnessSlider.setBounds(115, shiftY + 88, 134, 22);
                  brightnessSlider.setBorder(BorderFactory.createMatteBorder(0, -10, 0, -10, Color.black));
                  brightnessSlider.setMajorTickSpacing(100);
                  brightnessSlider.setMinorTickSpacing(10);
                  brightnessSlider.setSnapToTicks(true);
                  brightnessSlider.setPaintTicks(true);
                  brightnessSlider.setPaintLabels(true);
                  brightnessSlider.addChangeListener(new ChangeListener() {
                     @Override
                     public void stateChanged(ChangeEvent e) {
                        JSlider source = (JSlider)e.getSource();
                        txtBrightness.setText("" + source.getValue());
                     }
                  });
                  al.add(brightnessSlider);
                  JLabel vLabel = new JLabel("Vibrance");
                  vLabel.setBounds(5, shiftY + 115, 100, 24);
                  al.add(vLabel);
                  final JTextField txtVibrance = new JTextField("" + (int)(RSMapperClient.editor.mapEditor.vibrance[0] * 256.0F));
                  txtVibrance.setBounds(10, shiftY + 137, 100, 22);
                  al.add(txtVibrance);
                  final JSlider vibranceSlider = new JSlider(0, -750, 1500, (int)(RSMapperClient.editor.mapEditor.vibrance[0] * 256.0F));
                  vibranceSlider.setBounds(115, shiftY + 135, 134, 22);
                  vibranceSlider.setBorder(BorderFactory.createMatteBorder(0, -10, 0, -10, Color.black));
                  vibranceSlider.setMajorTickSpacing(100);
                  vibranceSlider.setMinorTickSpacing(10);
                  vibranceSlider.setSnapToTicks(true);
                  vibranceSlider.setPaintTicks(true);
                  vibranceSlider.setPaintLabels(true);
                  vibranceSlider.addChangeListener(new ChangeListener() {
                     @Override
                     public void stateChanged(ChangeEvent e) {
                        JSlider source = (JSlider)e.getSource();
                        txtVibrance.setText("" + source.getValue());
                     }
                  });
                  al.add(vibranceSlider);
                  JLabel bpLabel = new JLabel("Blackpoint");
                  bpLabel.setBounds(5, shiftY + 161, 100, 24);
                  al.add(bpLabel);
                  final JTextField txtBlackpoint = new JTextField("" + (int)(RSMapperClient.editor.mapEditor.blackpoint[0] * 256.0F));
                  txtBlackpoint.setBounds(10, shiftY + 184, 100, 22);
                  al.add(txtBlackpoint);
                  final JSlider blackpointSlider = new JSlider(0, -300, 600, (int)(RSMapperClient.editor.mapEditor.blackpoint[0] * 256.0F));
                  blackpointSlider.setBounds(115, shiftY + 182, 134, 22);
                  blackpointSlider.setBorder(BorderFactory.createMatteBorder(0, -10, 0, -10, Color.black));
                  blackpointSlider.setMajorTickSpacing(100);
                  blackpointSlider.setMinorTickSpacing(10);
                  blackpointSlider.setSnapToTicks(true);
                  blackpointSlider.setPaintTicks(true);
                  blackpointSlider.setPaintLabels(true);
                  blackpointSlider.addChangeListener(new ChangeListener() {
                     @Override
                     public void stateChanged(ChangeEvent e) {
                        JSlider source = (JSlider)e.getSource();
                        txtBlackpoint.setText("" + source.getValue());
                     }
                  });
                  al.add(blackpointSlider);
                  JLabel sunXLabel = new JLabel("Sun X");
                  sunXLabel.setBounds(5, shiftY + 207, 100, 24);
                  al.add(sunXLabel);
                  final JTextField txtSunX = new JTextField("" + RSMapperClient.editor.mapEditor.sunDistanceX[0]);
                  txtSunX.setBounds(10, shiftY + 230, 100, 22);
                  al.add(txtSunX);
                  final JSlider sunXSlider = new JSlider(0, -100, 100, RSMapperClient.editor.mapEditor.sunDistanceX[0]);
                  sunXSlider.setBounds(115, shiftY + 228, 134, 22);
                  sunXSlider.setBorder(BorderFactory.createMatteBorder(0, -10, 0, -10, Color.black));
                  sunXSlider.setMajorTickSpacing(10);
                  sunXSlider.setMinorTickSpacing(1);
                  sunXSlider.setSnapToTicks(true);
                  sunXSlider.setPaintTicks(true);
                  sunXSlider.setPaintLabels(true);
                  sunXSlider.addChangeListener(new ChangeListener() {
                     @Override
                     public void stateChanged(ChangeEvent e) {
                        JSlider source = (JSlider)e.getSource();
                        txtSunX.setText("" + source.getValue());
                     }
                  });
                  al.add(sunXSlider);
                  JLabel sunYLabel = new JLabel("Sun Y");
                  sunYLabel.setBounds(5, shiftY + 253, 100, 24);
                  al.add(sunYLabel);
                  final JTextField txtSunY = new JTextField("" + RSMapperClient.editor.mapEditor.sunDistanceY[0]);
                  txtSunY.setBounds(10, shiftY + 276, 100, 22);
                  al.add(txtSunY);
                  final JSlider sunYSlider = new JSlider(0, -100, 100, RSMapperClient.editor.mapEditor.sunDistanceY[0]);
                  sunYSlider.setBounds(115, shiftY + 274, 134, 22);
                  sunYSlider.setBorder(BorderFactory.createMatteBorder(0, -10, 0, -10, Color.black));
                  sunYSlider.setMajorTickSpacing(10);
                  sunYSlider.setMinorTickSpacing(1);
                  sunYSlider.setSnapToTicks(true);
                  sunYSlider.setPaintTicks(true);
                  sunYSlider.setPaintLabels(true);
                  sunYSlider.addChangeListener(new ChangeListener() {
                     @Override
                     public void stateChanged(ChangeEvent e) {
                        JSlider source = (JSlider)e.getSource();
                        txtSunY.setText("" + source.getValue());
                     }
                  });
                  al.add(sunYSlider);
                  JLabel sunZLabel = new JLabel("Sun Z");
                  sunZLabel.setBounds(5, shiftY + 299, 100, 24);
                  al.add(sunZLabel);
                  final JTextField txtSunZ = new JTextField("" + RSMapperClient.editor.mapEditor.sunDistanceZ[0]);
                  txtSunZ.setBounds(10, shiftY + 322, 100, 22);
                  al.add(txtSunZ);
                  final JSlider sunZSlider = new JSlider(0, -100, 100, RSMapperClient.editor.mapEditor.sunDistanceZ[0]);
                  sunZSlider.setBounds(115, shiftY + 320, 134, 22);
                  sunZSlider.setBorder(BorderFactory.createMatteBorder(0, -10, 0, -10, Color.black));
                  sunZSlider.setMajorTickSpacing(10);
                  sunZSlider.setMinorTickSpacing(1);
                  sunZSlider.setSnapToTicks(true);
                  sunZSlider.setPaintTicks(true);
                  sunZSlider.setPaintLabels(true);
                  sunZSlider.addChangeListener(new ChangeListener() {
                     @Override
                     public void stateChanged(ChangeEvent e) {
                        JSlider source = (JSlider)e.getSource();
                        txtSunZ.setText("" + source.getValue());
                     }
                  });
                  al.add(sunZSlider);
                  JLabel fcLabel = new JLabel("Fog Color");
                  fcLabel.setBounds(5, shiftY + 345, 100, 24);
                  al.add(fcLabel);
                  JLabel fcRLabel = new JLabel("R");
                  fcRLabel.setForeground(Color.RED);
                  fcRLabel.setBounds(5, shiftY + 368, 10, 24);
                  al.add(fcRLabel);
                  final JTextField txtFogColorR = new JTextField("" + Utils.getRGBFromInt(RSMapperClient.editor.mapEditor.fogcolor[0])[0]);
                  txtFogColorR.setBounds(16, shiftY + 368, 40, 22);
                  al.add(txtFogColorR);
                  JLabel fcGLabel = new JLabel("G");
                  fcGLabel.setForeground(Color.GREEN);
                  fcGLabel.setBounds(60, shiftY + 368, 10, 24);
                  al.add(fcGLabel);
                  final JTextField txtFogColorG = new JTextField("" + Utils.getRGBFromInt(RSMapperClient.editor.mapEditor.fogcolor[0])[1]);
                  txtFogColorG.setBounds(72, shiftY + 368, 40, 22);
                  al.add(txtFogColorG);
                  JLabel fcBLabel = new JLabel("B");
                  fcBLabel.setForeground(Color.BLUE);
                  fcBLabel.setBounds(115, shiftY + 368, 10, 24);
                  al.add(fcBLabel);
                  final JTextField txtFogColorB = new JTextField("" + Utils.getRGBFromInt(RSMapperClient.editor.mapEditor.fogcolor[0])[2]);
                  txtFogColorB.setBounds(126, shiftY + 368, 40, 22);
                  al.add(txtFogColorB);
                  JButton buttonFindFogColor = (JButton)UIPanels.this.makeButton("Choose", null, null, 170, shiftY + 368, 75, 22, true, UIPanels.topPanel);
                  buttonFindFogColor.setForeground(Color.ORANGE);
                  buttonFindFogColor.addActionListener(
                     new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                           try {
                              Color colorToShow = new Color(
                                 Integer.parseInt(txtFogColorR.getText()), Integer.parseInt(txtFogColorG.getText()), Integer.parseInt(txtFogColorB.getText())
                              );
                              Color color = JColorChooser.showDialog(null, "Choose a color", colorToShow);
                              if (color != null) {
                                 txtFogColorR.setText("" + color.getRed());
                                 txtFogColorG.setText("" + color.getGreen());
                                 txtFogColorB.setText("" + color.getBlue());
                              }
                           } catch (NumberFormatException var4) {
                           }
                        }
                     }
                  );
                  al.add(buttonFindFogColor);
                  JLabel fdLabel = new JLabel("Fog Density");
                  fdLabel.setBounds(5, shiftY + 368 + 23, 100, 24);
                  al.add(fdLabel);
                  final JTextField txtFogDensity = new JTextField("" + RSMapperClient.editor.mapEditor.fogdensity[0]);
                  txtFogDensity.setBounds(10, shiftY + 368 + 46, 100, 22);
                  al.add(txtFogDensity);
                  final JSlider fogSlider = new JSlider(0, -150, 4000, RSMapperClient.editor.mapEditor.fogdensity[0]);
                  fogSlider.setBounds(115, shiftY + 368 + 44, 134, 22);
                  fogSlider.setBorder(BorderFactory.createMatteBorder(0, -10, 0, -10, Color.black));
                  fogSlider.setMajorTickSpacing(400);
                  fogSlider.setMinorTickSpacing(100);
                  fogSlider.setSnapToTicks(true);
                  fogSlider.setPaintTicks(true);
                  fogSlider.setPaintLabels(true);
                  fogSlider.addChangeListener(new ChangeListener() {
                     @Override
                     public void stateChanged(ChangeEvent e) {
                        JSlider source = (JSlider)e.getSource();
                        txtFogDensity.setText("" + source.getValue());
                     }
                  });
                  al.add(fogSlider);
                  JButton reloadButton = new JButton("Reload Values");
                  reloadButton.setToolTipText("The values will be reset to the saved values.");
                  reloadButton.setBounds(6, shiftY + 368 + 46 + 37, 118, 28);
                  reloadButton.addActionListener(new ActionListener() {
                     @Override
                     public void actionPerformed(ActionEvent arg0) {
                        txtHighlightR.setText("" + Utils.getRGBFromInt(RSMapperClient.editor.mapEditor.highlightcolor[0])[0]);
                        txtHighlightG.setText("" + Utils.getRGBFromInt(RSMapperClient.editor.mapEditor.highlightcolor[0])[1]);
                        txtHighlightB.setText("" + Utils.getRGBFromInt(RSMapperClient.editor.mapEditor.highlightcolor[0])[2]);
                        txtBrightness.setText("" + (int)(RSMapperClient.editor.mapEditor.brightness[0] * 256.0F));
                        brightnessSlider.setValue((int)(RSMapperClient.editor.mapEditor.brightness[0] * 256.0F));
                        txtVibrance.setText("" + (int)(RSMapperClient.editor.mapEditor.vibrance[0] * 256.0F));
                        vibranceSlider.setValue((int)(RSMapperClient.editor.mapEditor.vibrance[0] * 256.0F));
                        txtBlackpoint.setText("" + (int)(RSMapperClient.editor.mapEditor.blackpoint[0] * 256.0F));
                        blackpointSlider.setValue((int)(RSMapperClient.editor.mapEditor.blackpoint[0] * 256.0F));
                        txtSunX.setText("" + RSMapperClient.editor.mapEditor.sunDistanceX[0]);
                        sunXSlider.setValue(RSMapperClient.editor.mapEditor.sunDistanceX[0]);
                        txtSunY.setText("" + RSMapperClient.editor.mapEditor.sunDistanceY[0]);
                        sunYSlider.setValue(RSMapperClient.editor.mapEditor.sunDistanceY[0]);
                        txtSunZ.setText("" + RSMapperClient.editor.mapEditor.sunDistanceZ[0]);
                        sunZSlider.setValue(RSMapperClient.editor.mapEditor.sunDistanceZ[0]);
                        txtFogColorR.setText("" + Utils.getRGBFromInt(RSMapperClient.editor.mapEditor.fogcolor[0])[0]);
                        txtFogColorG.setText("" + Utils.getRGBFromInt(RSMapperClient.editor.mapEditor.fogcolor[0])[1]);
                        txtFogColorB.setText("" + Utils.getRGBFromInt(RSMapperClient.editor.mapEditor.fogcolor[0])[2]);
                        txtFogDensity.setText("" + RSMapperClient.editor.mapEditor.fogdensity[0]);
                        fogSlider.setValue(RSMapperClient.editor.mapEditor.fogdensity[0]);
                        RSMapperClient.editor.mapEditor.previewingEnvironment = false;
                        Class78.MAP_CHANGED = true;
                     }
                  });
                  al.add(reloadButton);
                  JButton previewButton = new JButton("Preview");
                  previewButton.setBounds(129, shiftY + 368 + 46 + 37, 118, 28);
                  previewButton.setToolTipText("The atmosphere will reflect the input values.");
                  previewButton.addActionListener(
                     new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent arg0) {
                           RSMapperClient.editor.mapEditor.environmentFlag[1] = 127;
                           RSMapperClient.editor.mapEditor.highlightcolor[1] = Utils.getIntFromRGB(
                              Integer.parseInt(txtHighlightR.getText().trim()),
                              Integer.parseInt(txtHighlightG.getText().trim()),
                              Integer.parseInt(txtHighlightB.getText().trim())
                           );
                           RSMapperClient.editor.mapEditor.brightness[1] = (float)(
                              txtBrightness.getText().isEmpty() ? 1.0 : (double)(Float.parseFloat(txtBrightness.getText().trim()) / 256.0F)
                           );
                           RSMapperClient.editor.mapEditor.vibrance[1] = (float)(
                              txtVibrance.getText().isEmpty() ? 1.0 : (double)(Float.parseFloat(txtVibrance.getText().trim()) / 256.0F)
                           );
                           RSMapperClient.editor.mapEditor.blackpoint[1] = (float)(
                              txtBlackpoint.getText().isEmpty() ? 1.0 : (double)(Float.parseFloat(txtBlackpoint.getText().trim()) / 256.0F)
                           );
                           RSMapperClient.editor.mapEditor.sunDistanceX[1] = txtSunX.getText().isEmpty() ? 1 : Integer.parseInt(txtSunX.getText().trim());
                           RSMapperClient.editor.mapEditor.sunDistanceY[1] = txtSunY.getText().isEmpty() ? 1 : Integer.parseInt(txtSunY.getText().trim());
                           RSMapperClient.editor.mapEditor.sunDistanceZ[1] = txtSunZ.getText().isEmpty() ? 1 : Integer.parseInt(txtSunZ.getText().trim());
                           RSMapperClient.editor.mapEditor.fogcolor[1] = Utils.getIntFromRGB(
                              Integer.parseInt(txtFogColorR.getText().trim()),
                              Integer.parseInt(txtFogColorG.getText().trim()),
                              Integer.parseInt(txtFogColorB.getText().trim())
                           );
                           RSMapperClient.editor.mapEditor.fogdensity[1] = txtFogDensity.getText().isEmpty()
                              ? 1
                              : Integer.parseInt(txtFogDensity.getText().trim());
                           RSMapperClient.editor.mapEditor.previewingEnvironment = true;
                           Class78.MAP_CHANGED = true;
                        }
                     }
                  );
                  al.add(previewButton);
                  int choice = JOptionPane.showOptionDialog(UIPanels.rightPanel, al, "Atmosphere Settings", 0, -1, null, new Object[]{"Close", "Save"}, "Save");
                  if (choice == 1) {
                     RSMapperClient.editor.saveMapState(true);
                     RSMapperClient.editor.mapEditor.environmentFlag[0] = 127;
                     RSMapperClient.editor.mapEditor.highlightcolor[0] = Utils.getIntFromRGB(
                        Integer.parseInt(txtHighlightR.getText().trim()),
                        Integer.parseInt(txtHighlightG.getText().trim()),
                        Integer.parseInt(txtHighlightB.getText().trim())
                     );
                     RSMapperClient.editor.mapEditor.brightness[0] = (float)(
                        txtBrightness.getText().isEmpty() ? 1.0 : (double)(Float.parseFloat(txtBrightness.getText().trim()) / 256.0F)
                     );
                     RSMapperClient.editor.mapEditor.vibrance[0] = (float)(
                        txtVibrance.getText().isEmpty() ? 1.0 : (double)(Float.parseFloat(txtVibrance.getText().trim()) / 256.0F)
                     );
                     RSMapperClient.editor.mapEditor.blackpoint[0] = (float)(
                        txtBlackpoint.getText().isEmpty() ? 1.0 : (double)(Float.parseFloat(txtBlackpoint.getText().trim()) / 256.0F)
                     );
                     RSMapperClient.editor.mapEditor.sunDistanceX[0] = txtSunX.getText().isEmpty() ? 1 : Integer.parseInt(txtSunX.getText().trim());
                     RSMapperClient.editor.mapEditor.sunDistanceY[0] = txtSunY.getText().isEmpty() ? 1 : Integer.parseInt(txtSunY.getText().trim());
                     RSMapperClient.editor.mapEditor.sunDistanceZ[0] = txtSunZ.getText().isEmpty() ? 1 : Integer.parseInt(txtSunZ.getText().trim());
                     RSMapperClient.editor.mapEditor.fogcolor[0] = Utils.getIntFromRGB(
                        Integer.parseInt(txtFogColorR.getText().trim()),
                        Integer.parseInt(txtFogColorG.getText().trim()),
                        Integer.parseInt(txtFogColorB.getText().trim())
                     );
                     RSMapperClient.editor.mapEditor.fogdensity[0] = txtFogDensity.getText().isEmpty() ? 1 : Integer.parseInt(txtFogDensity.getText().trim());
                     RSMapperClient.editor.mapEditor.previewingEnvironment = false;
                     RSMapperClient.editor.mapEditor.createdEnvironment = true;
                     RSMapperClient.editor.mapEditor.unsavedMapProgress = true;
                     Class78.MAP_CHANGED = true;
                     RSMapperClient.setFocusOnCanvas();
                  } else {
                     RSMapperClient.editor.mapEditor.previewingEnvironment = false;
                     Class78.MAP_CHANGED = true;
                     RSMapperClient.setFocusOnCanvas();
                  }
               }
            }
         }
      );
      generalComponents.put("env_settings", button);
      topPanel.add(button);
   }

   protected void makeCameraSpeedDisplay() {
      int shiftX = 275;
      JLabel camTitle = (JLabel)makeLabel("", new ImageIcon("resources/images/camera_speed_icon.png"), shiftX, 8, 48, 26, topPanel);
      camTitle.setBorder(BorderFactory.createLineBorder(Color.black));
      generalComponents.put("cam_title", camTitle);
      final JLabel speedLabel = (JLabel)makeLabel("1", null, shiftX + 28, 9, 48, 24, topPanel);
      generalComponents.put("cam_speed_label", speedLabel);
      JButton incrementSpeed = (JButton)this.makeButton("+", null, Color.GREEN, shiftX + 30 + 18, 8, 22, 13, true, topPanel);
      incrementSpeed.setFont(new Font("", 0, 10));
      generalComponents.put("increment_cam_speed", incrementSpeed);
      incrementSpeed.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               try {
                  Class291.cameraRotationHorizontalMultiplier = Class291.cameraRotationHorizontalMultiplier >= 5.0F
                     ? 5.0F
                     : Class291.cameraRotationHorizontalMultiplier + 0.5F;
                  Node_Sub36_Sub1.cameraRotationVerticalMultiplier = Node_Sub36_Sub1.cameraRotationVerticalMultiplier >= 5.0F
                     ? 5.0F
                     : Node_Sub36_Sub1.cameraRotationVerticalMultiplier + 0.5F;
                  speedLabel.setText(new DecimalFormat("#.#").format((double)Class291.cameraRotationHorizontalMultiplier));
               } catch (Exception var3) {
                  var3.printStackTrace();
               }
   
               RSMapperClient.setFocusOnCanvas();
            }
         }
      );
      JButton reduceSpeed = (JButton)this.makeButton("-", null, Color.RED, shiftX + 30 + 18, 21, 22, 13, true, topPanel);
      reduceSpeed.setFont(new Font("", 0, 10));
      generalComponents.put("decrement_cam_speed", reduceSpeed);
      reduceSpeed.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               try {
                  Class291.cameraRotationHorizontalMultiplier = Class291.cameraRotationHorizontalMultiplier <= 0.5F
                     ? 0.5F
                     : Class291.cameraRotationHorizontalMultiplier - 0.5F;
                  Node_Sub36_Sub1.cameraRotationVerticalMultiplier = Node_Sub36_Sub1.cameraRotationVerticalMultiplier <= 0.5F
                     ? 0.5F
                     : Node_Sub36_Sub1.cameraRotationVerticalMultiplier - 0.5F;
                  speedLabel.setText(new DecimalFormat("#.#").format((double)Class291.cameraRotationHorizontalMultiplier));
               } catch (Exception var3) {
                  var3.printStackTrace();
               }
   
               RSMapperClient.setFocusOnCanvas();
            }
         }
      );
   }

   protected void makeRefreshMinimapButton() {
      int shiftX = 400;
      JButton refreshMinimap = (JButton)this.makeButton(
         "Refresh", new ImageIcon("resources/images/redraw_minimap_icon.png"), null, shiftX + 410, 8, 76, 24, true, topPanel
      );
      refreshMinimap.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black));
      generalComponents.put("refresh_minimap", refreshMinimap);
      refreshMinimap.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            try {
               RSMapperClient.refreshMiniMap();
               System.gc();
               RSMapperClient.setFocusOnCanvas();
            } catch (Exception var3) {
               var3.printStackTrace();
            }
         }
      });
   }

   protected void makeToggleOrthoButton() {
      int shiftX = 350;
      final JCheckBox ortho = new JCheckBox("Ortho");
      ortho.setBounds(shiftX, 8, 60, 26);
      ortho.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent arg0) {
            if (Class213.aNode_Sub27_2512 != null && Class213.aNode_Sub27_2512.aClass320_Sub3_7298 != null) {
               try {
                  int i_35_ = ortho.isSelected() ? 1 : 0;
                  if (i_35_ == 1) {
                     Node_Sub25_Sub2.aClass54Array9959 = new Class54[Node_Sub25_Sub2.aClass54Array9959.length];
                     Class167.anInt2033 = 0;
                     Node_Sub44.aClass54Array7548 = new Class54[Node_Sub44.aClass54Array7548.length];
                     Class320_Sub21.anInt8406 = 0;
                  }

                  Class213.aNode_Sub27_2512.method2690(119, i_35_, Class213.aNode_Sub27_2512.aClass320_Sub3_7298);
                  Node_Sub38_Sub31.method2893(1);
                  Class269.aBoolean3472 = false;
                  Class34_Sub1.method378(-4);
                  if (i_35_ != Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false)) {
                     System.err.println("Failed to enter ortho mode");
                  } else if (i_35_ == 1) {
                     Class339_Sub8.mouseNotches = 0;
                     Constants.ZOOM_MODIFIER = 0;
                     if (Class308.orthoZoom == 7000) {
                        Class308.orthoZoom = 35000;
                     }

                     Class336_Sub2.orthoLocked = false;
                  } else {
                     Class339_Sub8.mouseNotches = 0;
                     Constants.ZOOM_MODIFIER = 5;
                  }

                  RSMapperClient.setFocusOnCanvas();
               } catch (Exception var3) {
                  var3.printStackTrace();
               }
            } else {
               ortho.setSelected(false);
            }
         }
      });
      topPanel.add(ortho);
      generalComponents.put("ortho_toggle", ortho);
   }

   protected void makeToggleObjectsButton() {
      int shiftX = 566;
      final JButton buttonShowObjects = (JButton)this.makeButton(
         "", new ImageIcon("resources/images/objects_shown_icon.png"), null, shiftX + 60 + 32 + 28, 8, 24, 25, true, topPanel
      );
      buttonShowObjects.setToolTipText("Hide Objects");
      generalComponents.put("toggle_objects", buttonShowObjects);
      buttonShowObjects.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               if (RSMapperClient.editor.objectEditor != null && RSMapperClient.editor.objectEditor.dataLoaded) {
                  RSMapperClient.editor.objectEditor.HIDE_OBJECTS = !RSMapperClient.editor.objectEditor.HIDE_OBJECTS;
                  buttonShowObjects.setIcon(
                     RSMapperClient.editor.objectEditor.HIDE_OBJECTS
                        ? new ImageIcon("resources/images/objects_hidden_icon.png")
                        : new ImageIcon("resources/images/objects_shown_icon.png")
                  );
                  buttonShowObjects.setToolTipText(RSMapperClient.editor.objectEditor.HIDE_OBJECTS ? "Show Objects" : "Hide Objects");
                  Class78.MAP_CHANGED = true;
                  RSMapperClient.setFocusOnCanvas();
               }
            }
         }
      );
   }

   protected void makeTogglePlayerButton() {
      int shiftX = 594;
      final JButton buttonShowPlayer = (JButton)this.makeButton(
         "", new ImageIcon("resources/images/player_hidden_icon.png"), null, shiftX + 60 + 32, 8, 24, 25, true, topPanel
      );
      buttonShowPlayer.setToolTipText("Show Player Model");
      generalComponents.put("toggle_player", buttonShowPlayer);
      buttonShowPlayer.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               Class295.myPlayer.isHidden = !Class295.myPlayer.isHidden;
               buttonShowPlayer.setIcon(
                  Class295.myPlayer.isHidden
                     ? new ImageIcon("resources/images/player_hidden_icon.png")
                     : new ImageIcon("resources/images/player_shown_icon.png")
               );
               buttonShowPlayer.setToolTipText(Class295.myPlayer.isHidden ? "Show Player Model" : "Hide Player Model");
               RSMapperClient.setFocusOnCanvas();
            }
         }
      );
   }

   protected void makeToggleAtmosphereButton() {
      int shiftX = 622;
      final JButton buttonEnv = (JButton)this.makeButton(
         "", new ImageIcon("resources/images/disable_env.png"), null, shiftX + 60 + 32 + 28 + 28, 8, 24, 25, true, topPanel
      );
      buttonEnv.setToolTipText("Show Atmosphere");
      generalComponents.put("toggle_env", buttonEnv);
      buttonEnv.addActionListener(
         new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) {
               try {
                  RSMapperClient.settings.disabledEnvironment = !RSMapperClient.settings.disabledEnvironment;
                  buttonEnv.setIcon(
                     RSMapperClient.settings.disabledEnvironment
                        ? new ImageIcon("resources/images/disable_env.png")
                        : new ImageIcon("resources/images/enable_env.png")
                  );
                  buttonEnv.setToolTipText(RSMapperClient.settings.disabledEnvironment ? "Show Atmosphere" : "Hide Atmosphere");
                  if (RSMapperClient.editor.mapEditor.dataLoaded) {
                     Class116.method1163(RSMapperClient.settings.disabledEnvironment ? 4 : 2);
                     Class78.MAP_CHANGED = true;
                  }
   
                  RSMapperClient.setFocusOnCanvas();
               } catch (Exception var3) {
                  var3.printStackTrace();
               }
            }
         }
      );
   }
}
