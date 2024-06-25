import com.alex.store.ArchiveReference;
import com.alex.store.FileReference;
import com.rs.cache.Cache;
import com.rs.cache.io.InputStream;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import javax.swing.BorderFactory;
import javax.swing.DefaultCellEditor;
import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class HomeMenu
extends JPanel {
    private static final long serialVersionUID = 3152624250188412760L;
    public static final Integer[] IGNORED_EMPTY_REGIONS = new Integer[]{6720, 7240, 8019};
    boolean canShow;
    boolean alreadyLoggedIn = false;
    int width;
    int height;
    int selectedRegion;
    static int lastEmptyRegionRow = 0;
    JFrame projectExplorer;
    private JLabel areaNameLabel;
    private JTextField areaNameText;
    private JLabel chunkCoordLabelX;
    private JLabel chunkCoordLabelY1;
    private JTextField chunkCoordXTxt;
    private JTextField chunkCoordYTxt;
    private JTextField coordXTxt;
    private JTextField coordYTxt;
    private JLabel createProject;
    private JButton exportArea;
    private JButton exportLand;
    private JButton exportMap;
    private JButton exportUnderland;
    private JButton exportUndermap;
    private JButton findEmptyMap;
    private JCheckBox findEmptyWithUnderland;
    private JCheckBox findEmptyWithUndermap;
    private JTextField keysField;
    private JLabel keysLabel;
    private JTextField landArchiveId;
    private JLabel landArchiveLabel;
    private JPanel listRegionsPanel;
    private JButton loadRegionButton;
    JButton addRemoveProjectButton;
    private JTextField mapArchiveId;
    private JLabel mapArchiveLabel;
    private JPanel menuBarPanel;
    private JLabel menuTitle;
    private JTextField objectsInRegion;
    private JButton checkObjectSpawns;
    private JLabel objectsInRegionLabel;
    private JPanel projectPanel;
    JLabel projectLabel;
    private JScrollPane projectScrollPane;
    JTable projectMapsTable;
    private JLabel regionIdLabel;
    private JTextField regionIdTxt;
    private JLabel regionInfoLabel;
    private JLabel returnButton;
    private JLabel exploreProjects;
    private JPanel regionInfoPanel;
    private JScrollPane regionsScrollPane;
    private JLabel regionsScrollPaneLabel;
    private JTable regionsTable;
    private JButton searchChunkButton;
    private JButton searchCoordButton;
    private JButton searchRegionIdButton;
    private JTextField underlandArchiveId;
    private JLabel underlandArchiveLabel;
    private JTextField undermapArchiveId;
    private JLabel undermapArchiveLabel;
    private JLabel withLabel;
    private JLabel worldCoordLabelX;
    private JLabel worldCoordLabelY;
    private JLabel areaFileLabel;
    private JTextField areaFileText;

    public void init() {
        this.showMenu(false);
    }

    public void showMenu(final boolean visible) {
        if (visible && !this.canShow) {
            return;
        }
        this.setVisible(visible);
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                try {
                    RSMapperClient.client_frame.setResizable(!visible);
                    if (visible) {
                        HomeMenu.this.width = Node_Sub38_Sub20.GAME_CANVAS.getPreferredSize().width;
                        HomeMenu.this.height = UIPanels.rightPanel.getHeight();
                        HomeMenu.this.setPreferredSize(new Dimension(HomeMenu.this.width, HomeMenu.this.height));
                        if (HomeMenu.this.alreadyLoggedIn) {
                            HomeMenu.this.returnButton.setEnabled(true);
                        }
                    }
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HomeMenu() {
        this.setPreferredSize(new Dimension(900, 600));
        this.listRegionsPanel = new JPanel();
        this.regionsScrollPane = new JScrollPane();
        this.regionsTable = new JTable();
        this.regionsScrollPaneLabel = new JLabel();
        this.regionIdLabel = new JLabel();
        this.regionIdTxt = new JTextField();
        this.searchRegionIdButton = new JButton();
        this.worldCoordLabelX = new JLabel();
        this.worldCoordLabelY = new JLabel();
        this.coordXTxt = new JTextField();
        this.coordYTxt = new JTextField();
        this.searchCoordButton = new JButton();
        this.chunkCoordLabelX = new JLabel();
        this.chunkCoordLabelY1 = new JLabel();
        this.chunkCoordXTxt = new JTextField();
        this.chunkCoordYTxt = new JTextField();
        this.searchChunkButton = new JButton();
        this.findEmptyMap = new JButton();
        this.withLabel = new JLabel();
        this.findEmptyWithUndermap = new JCheckBox();
        this.findEmptyWithUnderland = new JCheckBox();
        this.regionInfoPanel = new JPanel();
        this.regionInfoLabel = new JLabel();
        this.areaNameLabel = new JLabel();
        this.areaNameText = new JTextField();
        this.areaFileLabel = new JLabel();
        this.areaFileText = new JTextField();
        this.mapArchiveLabel = new JLabel();
        this.mapArchiveId = new JTextField();
        this.landArchiveLabel = new JLabel();
        this.landArchiveId = new JTextField();
        this.undermapArchiveLabel = new JLabel();
        this.undermapArchiveId = new JTextField();
        this.underlandArchiveLabel = new JLabel();
        this.underlandArchiveId = new JTextField();
        this.exportMap = new JButton();
        this.exportLand = new JButton();
        this.exportUndermap = new JButton();
        this.exportUnderland = new JButton();
        this.exportArea = new JButton();
        this.keysLabel = new JLabel();
        this.keysField = new JTextField();
        this.objectsInRegionLabel = new JLabel();
        this.objectsInRegion = new JTextField();
        this.loadRegionButton = new JButton();
        this.addRemoveProjectButton = new JButton();
        this.checkObjectSpawns = new JButton();
        this.menuBarPanel = new JPanel();
        this.menuTitle = new JLabel();
        this.returnButton = new JLabel();
        this.exploreProjects = new JLabel();
        this.createProject = new JLabel();
        this.projectPanel = new JPanel();
        this.projectLabel = new JLabel();
        this.projectScrollPane = new JScrollPane();
        this.projectMapsTable = new JTable();
        this.setBackground(new Color(175, 175, 175));
        this.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 3));
        this.setName("listRegionsPanel");
        this.setLayout(new GridBagLayout());
        this.listRegionsPanel.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        this.listRegionsPanel.setName("");
        this.listRegionsPanel.setPreferredSize(new Dimension(350, 400));
        this.regionsScrollPane.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        this.regionsTable.setBackground(new Color(133, 127, 123));
        ArrayList<Object[]> regionsList = new ArrayList<Object[]>();
        int region = 0;
        while (region < 24000) {
            int mapArchive = Cache.STORE.getIndexes()[5].getArchiveId("m" + Utils.getLocalX(region) + "_" + Utils.getLocalY(region));
            int landArchive = Cache.STORE.getIndexes()[5].getArchiveId("l" + Utils.getLocalX(region) + "_" + Utils.getLocalY(region));
            int undermapArchive = Cache.STORE.getIndexes()[5].getArchiveId("um" + Utils.getLocalX(region) + "_" + Utils.getLocalY(region));
            int underlandArchive = Cache.STORE.getIndexes()[5].getArchiveId("ul" + Utils.getLocalX(region) + "_" + Utils.getLocalY(region));
            if (mapArchive != -1) {
                Object[] r2 = new Object[]{region, Character.valueOf('Y'), Character.valueOf(landArchive == -1 ? (char)'N' : 'Y'), Character.valueOf(undermapArchive == -1 ? (char)'N' : 'Y'), Character.valueOf(underlandArchive == -1 ? (char)'N' : 'Y')};
                regionsList.add(r2);
            }
            ++region;
        }
        Object[][] regions = new Object[regionsList.size()][5];
        int i2 = 0;
        while (i2 < regionsList.size()) {
            regions[i2] = (Object[])regionsList.get(i2);
            ++i2;
        }
        this.regionsTable.setDefaultRenderer(Character.class, new DefaultTableCellRenderer(){

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                c.setForeground(((Character)value).charValue() == 'N' ? Color.RED : Color.GREEN);
                ((JLabel)c).setHorizontalAlignment(0);
                return c;
            }
        });
        this.regionsTable.setModel(new DefaultTableModel(regions, new String[]{"Region", "M", "L", "UM", "UL"}){
            Class<?>[] types;
            boolean[] canEdit;
            {
                this.types = new Class[]{Integer.class, Character.class, Character.class, Character.class, Character.class};
                this.canEdit = new boolean[5];
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(0);
        centerRenderer.setFont(new Font("", 0, 18));
        this.regionsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        this.regionsTable.setCursor(new Cursor(0));
        this.regionsTable.setGridColor(new Color(0, 0, 0));
        this.regionsTable.setRowHeight(26);
        this.regionsTable.setRowMargin(3);
        this.regionsTable.setShowVerticalLines(false);
        this.regionsTable.addKeyListener(new KeyListener(){

            @Override
            public void keyPressed(KeyEvent arg0) {
                if (arg0.getKeyCode() == 40) {
                    HomeMenu.this.setSelectedRegion(HomeMenu.this.regionsTable.getSelectedRow() + 1, false, false, false);
                } else if (arg0.getKeyCode() == 38) {
                    HomeMenu.this.setSelectedRegion(HomeMenu.this.regionsTable.getSelectedRow() - 1, false, false, false);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });
        final JPopupMenu popupMenu = new JPopupMenu();
        JMenuItem load = new JMenuItem("Load");
        JMenuItem addProject = new JMenuItem("Add to Project");
        popupMenu.add(load);
        popupMenu.add(addProject);
        this.regionsTable.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent me) {
                int row = HomeMenu.this.regionsTable.rowAtPoint(me.getPoint());
                HomeMenu.this.setSelectedRegion(row, true, false, false);
                if (SwingUtilities.isRightMouseButton(me)) {
                    popupMenu.show(HomeMenu.this.regionsTable, me.getX(), me.getY());
                }
                if (SwingUtilities.isLeftMouseButton(me) && me.getClickCount() == 2) {
                    HomeMenu.this.load(HomeMenu.this.selectedRegion);
                }
                HomeMenu.this.projectMapsTable.clearSelection();
            }
        });
        load.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                HomeMenu.this.load(HomeMenu.this.selectedRegion);
                System.out.println("Loading: " + HomeMenu.this.selectedRegion);
            }
        });
        addProject.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                HomeMenu.this.addToProjectQuickloads(HomeMenu.this.selectedRegion);
            }
        });
        this.regionsScrollPane.setViewportView(this.regionsTable);
        if (this.regionsTable.getColumnModel().getColumnCount() > 0) {
            this.regionsTable.getColumnModel().getColumn(0).setMinWidth(60);
            this.regionsTable.getColumnModel().getColumn(0).setPreferredWidth(130);
            this.regionsTable.getColumnModel().getColumn(1).setMinWidth(30);
            this.regionsTable.getColumnModel().getColumn(2).setMinWidth(30);
            this.regionsTable.getColumnModel().getColumn(3).setMinWidth(30);
            this.regionsTable.getColumnModel().getColumn(4).setMinWidth(30);
        }
        this.regionsScrollPaneLabel.setBackground(new Color(102, 102, 102));
        this.regionsScrollPaneLabel.setFont(new Font("Tahoma", 1, 13));
        this.regionsScrollPaneLabel.setForeground(new Color(255, 255, 255));
        this.regionsScrollPaneLabel.setHorizontalAlignment(0);
        this.regionsScrollPaneLabel.setLabelFor(this.regionsScrollPane);
        this.regionsScrollPaneLabel.setText("Cached Regions");
        this.regionsScrollPaneLabel.setIcon(new ImageIcon("resources/images/region_browser_icon.png"));
        this.regionsScrollPaneLabel.setOpaque(true);
        this.regionIdLabel.setHorizontalAlignment(0);
        this.regionIdLabel.setText("Region Id:");
        this.regionIdLabel.setHorizontalTextPosition(4);
        this.searchRegionIdButton.setText("Search");
        this.searchRegionIdButton.setIcon(new ImageIcon("resources/images/search_icon_small.png"));
        this.searchRegionIdButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeMenu.this.searchRegionIdButtonActionPerformed(evt);
            }
        });
        this.worldCoordLabelX.setHorizontalAlignment(0);
        this.worldCoordLabelX.setText("World X:");
        this.worldCoordLabelX.setHorizontalTextPosition(4);
        this.worldCoordLabelY.setHorizontalAlignment(11);
        this.worldCoordLabelY.setText("Y:");
        this.worldCoordLabelY.setHorizontalTextPosition(4);
        this.searchCoordButton.setText("Search");
        this.searchCoordButton.setIcon(new ImageIcon("resources/images/search_icon_small.png"));
        this.searchCoordButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeMenu.this.searchCoordButtonActionPerformed(evt);
            }
        });
        this.chunkCoordLabelX.setHorizontalAlignment(0);
        this.chunkCoordLabelX.setText("Chunk X:");
        this.chunkCoordLabelX.setHorizontalTextPosition(4);
        this.chunkCoordLabelY1.setHorizontalAlignment(11);
        this.chunkCoordLabelY1.setText("Y:");
        this.chunkCoordLabelY1.setHorizontalTextPosition(4);
        this.searchChunkButton.setText("Search");
        this.searchChunkButton.setIcon(new ImageIcon("resources/images/search_icon_small.png"));
        this.searchChunkButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeMenu.this.searchChunkButtonActionPerformed(evt);
            }
        });
        this.findEmptyMap.setText("Find Empty Region");
        this.findEmptyMap.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeMenu.this.findEmptyMapActionPerformed(evt);
            }
        });
        this.withLabel.setText("With:");
        this.findEmptyWithUndermap.setFont(new Font("Tahoma", 0, 9));
        this.findEmptyWithUndermap.setText("UM");
        this.findEmptyWithUndermap.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeMenu.this.findEmptyWithUndermapActionPerformed(evt);
            }
        });
        this.findEmptyWithUnderland.setFont(new Font("Tahoma", 0, 9));
        this.findEmptyWithUnderland.setText("UL");
        this.findEmptyWithUnderland.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeMenu.this.findEmptyWithUnderlandActionPerformed(evt);
            }
        });
        GroupLayout listRegionsPanelLayout = new GroupLayout(this.listRegionsPanel);
        this.listRegionsPanel.setLayout(listRegionsPanelLayout);
        listRegionsPanelLayout.setHorizontalGroup(listRegionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(listRegionsPanelLayout.createSequentialGroup().addContainerGap().addGroup(listRegionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.regionsScrollPaneLabel, -1, -1, Short.MAX_VALUE).addComponent(this.regionsScrollPane, -2, 0, Short.MAX_VALUE).addGroup(listRegionsPanelLayout.createSequentialGroup().addGroup(listRegionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(listRegionsPanelLayout.createSequentialGroup().addComponent(this.chunkCoordLabelX, -2, 60, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.chunkCoordXTxt, -2, 61, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.chunkCoordLabelY1, -2, 14, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.chunkCoordYTxt, -2, 51, -2)).addComponent(this.findEmptyMap, -1, -1, Short.MAX_VALUE)).addGroup(listRegionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(listRegionsPanelLayout.createSequentialGroup().addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addComponent(this.withLabel).addGap(2, 2, 2).addComponent(this.findEmptyWithUndermap).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.findEmptyWithUnderland, -1, -1, Short.MAX_VALUE).addGap(2, 2, 2)).addGroup(listRegionsPanelLayout.createSequentialGroup().addGap(6, 6, 6).addComponent(this.searchChunkButton, -1, -1, Short.MAX_VALUE)))).addGroup(GroupLayout.Alignment.TRAILING, listRegionsPanelLayout.createSequentialGroup().addGap(0, 0, Short.MAX_VALUE).addGroup(listRegionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.worldCoordLabelX, -1, -1, Short.MAX_VALUE).addComponent(this.regionIdLabel, -1, 60, Short.MAX_VALUE)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(listRegionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(listRegionsPanelLayout.createSequentialGroup().addComponent(this.coordXTxt, -2, 61, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.worldCoordLabelY, -2, 14, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.coordYTxt, -2, 51, -2)).addComponent(this.regionIdTxt, -2, 138, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(listRegionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.searchCoordButton, -1, 119, Short.MAX_VALUE).addComponent(this.searchRegionIdButton, -1, -1, Short.MAX_VALUE)))).addContainerGap()));
        listRegionsPanelLayout.setVerticalGroup(listRegionsPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(listRegionsPanelLayout.createSequentialGroup().addContainerGap().addComponent(this.regionsScrollPaneLabel, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(listRegionsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.findEmptyMap, -2, 28, -2).addComponent(this.withLabel).addComponent(this.findEmptyWithUndermap).addComponent(this.findEmptyWithUnderland)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(listRegionsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.chunkCoordLabelX, -2, 30, -2).addComponent(this.chunkCoordLabelY1, -2, 28, -2).addComponent(this.chunkCoordXTxt, -2, 28, -2).addComponent(this.chunkCoordYTxt, -2, 28, -2).addComponent(this.searchChunkButton, -2, 28, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(listRegionsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.coordYTxt, -2, 28, -2).addComponent(this.coordXTxt, -2, 28, -2).addComponent(this.worldCoordLabelY, -2, 28, -2).addComponent(this.searchCoordButton, -2, 28, -2).addComponent(this.worldCoordLabelX, -2, 30, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(listRegionsPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.regionIdTxt, -2, 28, -2).addComponent(this.regionIdLabel, -1, -1, Short.MAX_VALUE).addComponent(this.searchRegionIdButton, -2, 28, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.regionsScrollPane, -1, 364, Short.MAX_VALUE)));
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = 3;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 20.0;
        this.add((Component)this.listRegionsPanel, gridBagConstraints);
        this.regionInfoPanel.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        this.regionInfoPanel.setAutoscrolls(true);
        this.regionInfoPanel.setPreferredSize(new Dimension(400, 300));
        this.regionInfoPanel.setLayout(new GridBagLayout());
        this.regionInfoLabel.setBackground(new Color(102, 102, 102));
        this.regionInfoLabel.setFont(new Font("Tahoma", 1, 13));
        this.regionInfoLabel.setForeground(new Color(255, 255, 255));
        this.regionInfoLabel.setHorizontalAlignment(0);
        this.regionInfoLabel.setLabelFor(this.regionsScrollPane);
        this.regionInfoLabel.setText("Region Info and Options");
        this.regionInfoLabel.setIcon(new ImageIcon("resources/images/information_icon.png"));
        this.regionInfoLabel.setOpaque(true);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 164;
        gridBagConstraints.ipadx = 323;
        gridBagConstraints.ipady = 13;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(12, 11, 0, 11);
        this.regionInfoPanel.add((Component)this.regionInfoLabel, gridBagConstraints);
        this.areaNameLabel.setFont(new Font("Tahoma", 0, 12));
        this.areaNameLabel.setHorizontalAlignment(0);
        this.areaNameLabel.setText("Area:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(13, 36, 0, 0);
        this.regionInfoPanel.add((Component)this.areaNameLabel, gridBagConstraints);
        this.areaNameText.setEditable(false);
        this.areaNameText.setBackground(new Color(176, 175, 170));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 155;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(11, 4, 0, 0);
        this.regionInfoPanel.add((Component)this.areaNameText, gridBagConstraints);
        this.areaFileLabel.setFont(new Font("Tahoma", 0, 12));
        this.areaFileLabel.setText("Area File:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(14, 18, 0, 0);
        this.regionInfoPanel.add((Component)this.areaFileLabel, gridBagConstraints);
        this.areaFileText.setEditable(false);
        this.areaFileText.setBackground(new Color(176, 175, 170));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 32;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 34;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(12, 4, 0, 0);
        this.regionInfoPanel.add((Component)this.areaFileText, gridBagConstraints);
        this.mapArchiveLabel.setFont(new Font("Tahoma", 0, 12));
        this.mapArchiveLabel.setHorizontalAlignment(0);
        this.mapArchiveLabel.setText("Map:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.ipadx = 14;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(14, 36, 0, 0);
        this.regionInfoPanel.add((Component)this.mapArchiveLabel, gridBagConstraints);
        this.mapArchiveId.setEditable(false);
        this.mapArchiveId.setBackground(new Color(176, 175, 170));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(12, 4, 0, 0);
        this.regionInfoPanel.add((Component)this.mapArchiveId, gridBagConstraints);
        this.landArchiveLabel.setFont(new Font("Tahoma", 0, 12));
        this.landArchiveLabel.setHorizontalAlignment(0);
        this.landArchiveLabel.setText("Land:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.ipadx = 10;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(14, 36, 0, 0);
        this.regionInfoPanel.add((Component)this.landArchiveLabel, gridBagConstraints);
        this.landArchiveId.setEditable(false);
        this.landArchiveId.setBackground(new Color(176, 175, 170));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(12, 4, 0, 0);
        this.regionInfoPanel.add((Component)this.landArchiveId, gridBagConstraints);
        this.undermapArchiveLabel.setFont(new Font("Tahoma", 0, 12));
        this.undermapArchiveLabel.setText("Undermap:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(14, 18, 0, 0);
        this.regionInfoPanel.add((Component)this.undermapArchiveLabel, gridBagConstraints);
        this.undermapArchiveId.setEditable(false);
        this.undermapArchiveId.setBackground(new Color(176, 175, 170));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 32;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 34;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(12, 4, 0, 0);
        this.regionInfoPanel.add((Component)this.undermapArchiveId, gridBagConstraints);
        this.underlandArchiveLabel.setFont(new Font("Tahoma", 0, 12));
        this.underlandArchiveLabel.setText("Underland:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 20;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(14, 18, 0, 0);
        this.regionInfoPanel.add((Component)this.underlandArchiveLabel, gridBagConstraints);
        this.underlandArchiveId.setEditable(false);
        this.underlandArchiveId.setBackground(new Color(176, 175, 170));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 32;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 34;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 59;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(12, 4, 0, 0);
        this.regionInfoPanel.add((Component)this.underlandArchiveId, gridBagConstraints);
        this.exportMap.setText("Export");
        this.exportMap.setIcon(new ImageIcon("resources/images/export_icon_small.png"));
        this.exportMap.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeMenu.this.exportMapActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(11, 6, 0, 0);
        this.regionInfoPanel.add((Component)this.exportMap, gridBagConstraints);
        this.exportLand.setText("Export");
        this.exportLand.setIcon(new ImageIcon("resources/images/export_icon_small.png"));
        this.exportLand.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeMenu.this.exportLandActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 25;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(11, 6, 0, 0);
        this.regionInfoPanel.add((Component)this.exportLand, gridBagConstraints);
        this.exportUndermap.setText("Export");
        this.exportUndermap.setIcon(new ImageIcon("resources/images/export_icon_small.png"));
        this.exportUndermap.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeMenu.this.exportUndermapActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 98;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(11, 6, 0, 0);
        this.regionInfoPanel.add((Component)this.exportUndermap, gridBagConstraints);
        this.exportUnderland.setText("Export");
        this.exportUnderland.setIcon(new ImageIcon("resources/images/export_icon_small.png"));
        this.exportUnderland.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeMenu.this.exportUnderlandActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 98;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(11, 6, 0, 0);
        this.regionInfoPanel.add((Component)this.exportUnderland, gridBagConstraints);
        this.exportArea.setText("Export");
        this.exportArea.setIcon(new ImageIcon("resources/images/export_icon_small.png"));
        this.exportArea.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeMenu.this.exportAreaActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 98;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.ipadx = 23;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(11, 6, 0, 0);
        this.regionInfoPanel.add((Component)this.exportArea, gridBagConstraints);
        this.keysLabel.setFont(new Font("Tahoma", 0, 12));
        this.keysLabel.setHorizontalAlignment(0);
        this.keysLabel.setText("Keys:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(20, 36, 0, 0);
        this.regionInfoPanel.add((Component)this.keysLabel, gridBagConstraints);
        this.keysField.setEditable(false);
        this.keysField.setBackground(new Color(176, 175, 170));
        this.keysField.setHorizontalAlignment(0);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 98;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 396;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(18, 4, 0, 0);
        this.regionInfoPanel.add((Component)this.keysField, gridBagConstraints);
        this.objectsInRegionLabel.setFont(new Font("Tahoma", 0, 12));
        this.objectsInRegionLabel.setHorizontalAlignment(0);
        this.objectsInRegionLabel.setText("Object Spawns:");
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.ipadx = 11;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(14, 36, 0, 0);
        this.regionInfoPanel.add((Component)this.objectsInRegionLabel, gridBagConstraints);
        this.objectsInRegion.setEditable(false);
        this.objectsInRegion.setBackground(new Color(176, 175, 170));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 64;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(12, 4, 0, 0);
        this.regionInfoPanel.add((Component)this.objectsInRegion, gridBagConstraints);
        this.checkObjectSpawns.setText("Check");
        this.checkObjectSpawns.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeMenu.this.checkObjectSpawnsActionPerformed(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 10;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.gridheight = 3;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.insets = new Insets(11, 6, 0, 0);
        this.regionInfoPanel.add((Component)this.checkObjectSpawns, gridBagConstraints);
        this.loadRegionButton.setFont(new Font("Tahoma", 1, 14));
        this.loadRegionButton.setText("Load Region");
        this.loadRegionButton.setIcon(new ImageIcon("resources/images/expand_icon2.png"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 33;
        gridBagConstraints.ipadx = 216;
        gridBagConstraints.ipady = 36;
        gridBagConstraints.anchor = 16;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(29, 11, 10, 0);
        this.regionInfoPanel.add((Component)this.loadRegionButton, gridBagConstraints);
        this.addRemoveProjectButton.setFont(new Font("Tahoma", 1, 14));
        this.addRemoveProjectButton.setText("Add to Project");
        this.addRemoveProjectButton.setActionCommand("Create Project");
        this.addRemoveProjectButton.setIcon(new ImageIcon("resources/images/blue_star_icon.png"));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 65;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.gridwidth = 99;
        gridBagConstraints.ipady = 36;
        gridBagConstraints.anchor = 16;
        gridBagConstraints.weighty = 0.2;
        gridBagConstraints.insets = new Insets(29, 6, 10, 11);
        this.regionInfoPanel.add((Component)this.addRemoveProjectButton, gridBagConstraints);
        GroupLayout regionInfoPanelLayout = new GroupLayout(this.regionInfoPanel);
        this.regionInfoPanel.setLayout(regionInfoPanelLayout);
        regionInfoPanelLayout.setHorizontalGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(regionInfoPanelLayout.createSequentialGroup().addContainerGap().addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.regionInfoLabel, -1, -1, Short.MAX_VALUE).addGroup(regionInfoPanelLayout.createSequentialGroup().addComponent(this.loadRegionButton, -2, 335, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.addRemoveProjectButton, -1, 236, Short.MAX_VALUE))).addContainerGap()).addGroup(regionInfoPanelLayout.createSequentialGroup().addGap(35, 35, 35).addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false).addGroup(GroupLayout.Alignment.LEADING, regionInfoPanelLayout.createSequentialGroup().addComponent(this.keysLabel, -2, 40, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.keysField)).addGroup(regionInfoPanelLayout.createSequentialGroup().addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(regionInfoPanelLayout.createSequentialGroup().addComponent(this.objectsInRegionLabel, -2, 98, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.objectsInRegion, -2, 70, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.checkObjectSpawns)).addGroup(regionInfoPanelLayout.createSequentialGroup().addComponent(this.areaNameLabel, -2, 40, -2).addGap(4, 4, 4).addComponent(this.areaNameText, -2, 161, -2).addGap(18, 18, 18).addComponent(this.areaFileLabel, -2, 60, -2)).addGroup(regionInfoPanelLayout.createSequentialGroup().addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.mapArchiveLabel, -2, 40, -2).addComponent(this.landArchiveLabel, -2, 40, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.mapArchiveId, GroupLayout.Alignment.TRAILING, -2, 65, -2).addComponent(this.landArchiveId, -2, 65, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addGroup(regionInfoPanelLayout.createSequentialGroup().addComponent(this.exportLand, -2, 90, -2).addGap(18, 18, 18).addComponent(this.underlandArchiveLabel, -2, 60, -2)).addGroup(regionInfoPanelLayout.createSequentialGroup().addComponent(this.exportMap, -2, 90, -2).addGap(18, 18, 18).addComponent(this.undermapArchiveLabel, -2, 60, -2))))).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false).addComponent(this.undermapArchiveId, -2, 65, -2).addComponent(this.underlandArchiveId, -2, 65, -2).addComponent(this.areaFileText, -2, 65, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.exportArea, -2, 88, -2).addComponent(this.exportUndermap, -2, 88, -2).addComponent(this.exportUnderland, -2, 88, -2)))).addContainerGap(-1, Short.MAX_VALUE)));
        regionInfoPanelLayout.setVerticalGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(regionInfoPanelLayout.createSequentialGroup().addContainerGap().addComponent(this.regionInfoLabel, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(regionInfoPanelLayout.createSequentialGroup().addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.areaNameLabel).addComponent(this.areaNameText, -2, -1, -2)).addGap(14, 14, 14)).addGroup(GroupLayout.Alignment.TRAILING, regionInfoPanelLayout.createSequentialGroup().addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.areaFileLabel).addComponent(this.areaFileText, -2, -1, -2).addComponent(this.exportArea)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED))).addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.mapArchiveLabel).addComponent(this.mapArchiveId, -2, -1, -2).addComponent(this.undermapArchiveLabel).addComponent(this.exportUndermap).addComponent(this.exportMap).addComponent(this.undermapArchiveId, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.landArchiveLabel).addComponent(this.landArchiveId, -2, -1, -2).addComponent(this.underlandArchiveId, -2, -1, -2).addComponent(this.exportLand).addComponent(this.exportUnderland).addComponent(this.underlandArchiveLabel)).addGap(18, 18, 18).addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.keysLabel).addComponent(this.keysField, -2, -1, -2)).addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED).addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.objectsInRegionLabel).addComponent(this.objectsInRegion, -2, -1, -2).addComponent(this.checkObjectSpawns)).addGap(29, 29, 29).addGroup(regionInfoPanelLayout.createParallelGroup(GroupLayout.Alignment.BASELINE).addComponent(this.loadRegionButton, -1, 60, Short.MAX_VALUE).addComponent(this.addRemoveProjectButton, -2, 60, -2)).addContainerGap()));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = 1;
        gridBagConstraints.anchor = 15;
        gridBagConstraints.weightx = 20.0;
        gridBagConstraints.weighty = 20.0;
        this.add((Component)this.regionInfoPanel, gridBagConstraints);
        this.loadRegionButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                HomeMenu.this.load(HomeMenu.this.selectedRegion);
            }
        });
        this.addRemoveProjectButton.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent evt) {
                if (RSMapperClient.project.containsRegion(HomeMenu.this.selectedRegion)) {
                    HomeMenu.this.removeFromProjectQuickLoad(HomeMenu.this.selectedRegion);
                } else {
                    HomeMenu.this.addToProjectQuickloads(HomeMenu.this.selectedRegion);
                }
            }
        });
        this.menuBarPanel.setBorder(BorderFactory.createLineBorder(new Color(0, 0, 0)));
        this.menuBarPanel.setPreferredSize(new Dimension(600, 30));
        this.menuBarPanel.setLayout(new GridBagLayout());
        this.menuTitle.setBackground(new Color(102, 102, 102));
        this.menuTitle.setFont(new Font("Tahoma", 1, 16));
        this.menuTitle.setForeground(new Color(255, 255, 255));
        this.menuTitle.setHorizontalAlignment(0);
        this.menuTitle.setLabelFor(this.regionsScrollPane);
        this.menuTitle.setText("Stuggers Map Editor - Main Menu");
        this.menuTitle.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 60));
        this.menuTitle.setOpaque(true);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = 1;
        gridBagConstraints.weightx = 100.0;
        gridBagConstraints.weighty = 0.1;
        this.menuBarPanel.add((Component)this.menuTitle, gridBagConstraints);
        this.returnButton.setBackground(new Color(151, 148, 144));
        this.returnButton.setFont(new Font("Tahoma", 1, 11));
        this.returnButton.setForeground(new Color(165, 213, 248));
        this.returnButton.setEnabled(false);
        this.returnButton.setHorizontalAlignment(0);
        this.returnButton.setText("Return");
        this.returnButton.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        this.returnButton.setHorizontalTextPosition(0);
        this.returnButton.setMaximumSize(new Dimension(80, 14));
        this.returnButton.setMinimumSize(new Dimension(80, 14));
        this.returnButton.setOpaque(true);
        this.returnButton.setPreferredSize(new Dimension(80, 14));
        this.returnButton.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseEntered(MouseEvent evt) {
                HomeMenu.this.returnButtonMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                HomeMenu.this.returnButtonMouseExited(evt);
            }

            @Override
            public void mousePressed(MouseEvent evt) {
                HomeMenu.this.returnButtonMousePressed(evt);
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                HomeMenu.this.returnButtonMouseReleased(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = 3;
        gridBagConstraints.anchor = 13;
        this.menuBarPanel.add((Component)this.returnButton, gridBagConstraints);
        this.exploreProjects.setBackground(new Color(151, 148, 144));
        this.exploreProjects.setFont(new Font("Tahoma", 1, 11));
        this.exploreProjects.setForeground(new Color(165, 213, 248));
        this.exploreProjects.setHorizontalAlignment(0);
        this.exploreProjects.setText("Project Explorer");
        this.exploreProjects.setBorder(new LineBorder(new Color(102, 102, 102), 1, true));
        this.exploreProjects.setHorizontalTextPosition(0);
        this.exploreProjects.setMaximumSize(new Dimension(110, 14));
        this.exploreProjects.setMinimumSize(new Dimension(110, 14));
        this.exploreProjects.setOpaque(true);
        this.exploreProjects.setPreferredSize(new Dimension(110, 14));
        this.exploreProjects.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseEntered(MouseEvent evt) {
                HomeMenu.this.projectExplorerMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                HomeMenu.this.projectExplorerMouseExited(evt);
            }

            @Override
            public void mousePressed(MouseEvent evt) {
                HomeMenu.this.projectExplorerMousePressed(evt);
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                HomeMenu.this.projectExplorerMouseReleased(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = 3;
        gridBagConstraints.anchor = 21;
        this.menuBarPanel.add((Component)this.exploreProjects, gridBagConstraints);
        this.createProject.setBackground(new Color(151, 148, 144));
        this.createProject.setFont(new Font("Tahoma", 1, 11));
        this.createProject.setForeground(new Color(165, 213, 248));
        this.createProject.setHorizontalAlignment(0);
        this.createProject.setText("Create Project");
        this.createProject.setBorder(new LineBorder(new Color(102, 102, 102), 1, true));
        this.createProject.setHorizontalTextPosition(0);
        this.createProject.setMaximumSize(new Dimension(120, 14));
        this.createProject.setMinimumSize(new Dimension(120, 14));
        this.createProject.setOpaque(true);
        this.createProject.setPreferredSize(new Dimension(120, 14));
        this.createProject.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseEntered(MouseEvent evt) {
                HomeMenu.this.createProjectMouseEntered(evt);
            }

            @Override
            public void mouseExited(MouseEvent evt) {
                HomeMenu.this.createProjectMouseExited(evt);
            }

            @Override
            public void mousePressed(MouseEvent evt) {
                HomeMenu.this.createProjectMousePressed(evt);
            }

            @Override
            public void mouseReleased(MouseEvent evt) {
                HomeMenu.this.createProjectMouseReleased(evt);
            }
        });
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = 3;
        gridBagConstraints.anchor = 17;
        gridBagConstraints.weightx = 0.1;
        this.menuBarPanel.add((Component)this.createProject, gridBagConstraints);
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 0;
        gridBagConstraints.fill = 2;
        gridBagConstraints.anchor = 18;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        this.add((Component)this.menuBarPanel, gridBagConstraints);
        this.projectPanel.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        this.projectPanel.setPreferredSize(new Dimension(303, 252));
        this.projectLabel.setBackground(new Color(102, 102, 102));
        this.projectLabel.setFont(new Font("Tahoma", 1, 13));
        this.projectLabel.setForeground(new Color(255, 255, 255));
        this.projectLabel.setHorizontalAlignment(0);
        this.projectLabel.setLabelFor(this.regionsScrollPane);
        this.projectLabel.setText("<html>Project<font color='#28b5ed'> Workspace</font> Regions</html>");
        this.projectLabel.setIcon(new ImageIcon("resources/images/quickload_browser_icon.png"));
        this.projectLabel.setOpaque(true);
        this.projectScrollPane.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102)));
        this.projectScrollPane.setPreferredSize(new Dimension(520, 200));
        this.projectMapsTable.setBackground(new Color(133, 127, 123));
        regionsList = new ArrayList();
        if (RSMapperClient.project != null && RSMapperClient.project.getRegionIds() != null) {
            for (int region2 : RSMapperClient.project.getRegionIds()) {
                int mapArchive = Cache.STORE.getIndexes()[5].getArchiveId("m" + Utils.getLocalX(region2) + "_" + Utils.getLocalY(region2));
                int landArchive = Cache.STORE.getIndexes()[5].getArchiveId("l" + Utils.getLocalX(region2) + "_" + Utils.getLocalY(region2));
                int undermapArchive = Cache.STORE.getIndexes()[5].getArchiveId("um" + Utils.getLocalX(region2) + "_" + Utils.getLocalY(region2));
                int underlandArchive = Cache.STORE.getIndexes()[5].getArchiveId("ul" + Utils.getLocalX(region2) + "_" + Utils.getLocalY(region2));
                if (mapArchive != -1) {
                    Object[] r3 = new Object[]{region2, RSMapperClient.project.getNoteAtIndex(RSMapperClient.project.getIndexOfQuickLoad(new Object[]{region2, ""}, false)), Character.valueOf('Y'), Character.valueOf(landArchive == -1 ? (char)'N' : 'Y'), Character.valueOf(undermapArchive == -1 ? (char)'N' : 'Y'), Character.valueOf(underlandArchive == -1 ? (char)'N' : 'Y')};
                    regionsList.add(r3);
                    continue;
                }
                RSMapperClient.project.removeQuickLoad(new Object[]{region2, ""});
            }
        }
        regions = new Object[regionsList.size()][6];
        int i3 = 0;
        while (i3 < regionsList.size()) {
            regions[i3] = (Object[])regionsList.get(i3);
            ++i3;
        }
        this.projectMapsTable.setDefaultRenderer(Character.class, new DefaultTableCellRenderer(){

            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (!(value instanceof Character)) {
                    return c;
                }
                c.setForeground(((Character)value).charValue() == 'N' ? Color.RED : Color.GREEN);
                ((JLabel)c).setHorizontalAlignment(0);
                return c;
            }
        });
        this.projectMapsTable.setModel(new DefaultTableModel(regions, new String[]{"Region", "Note", "M", "L", "UM", "UL"}){
            Class[] types;
            boolean[] canEdit;
            {
                this.types = new Class[]{Integer.class, String.class, Character.class, Character.class, Character.class, Character.class};
                boolean[] blArray = new boolean[6];
                blArray[1] = true;
                this.canEdit = blArray;
            }

            public Class getColumnClass(int columnIndex) {
                return this.types[columnIndex];
            }

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return this.canEdit[columnIndex];
            }
        });
        this.projectMapsTable.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        this.projectMapsTable.setCursor(new Cursor(0));
        this.projectMapsTable.setGridColor(new Color(0, 0, 0));
        this.projectMapsTable.setRowHeight(26);
        this.projectMapsTable.setRowMargin(3);
        this.projectMapsTable.setShowVerticalLines(false);
        this.projectScrollPane.setViewportView(this.projectMapsTable);
        if (this.projectMapsTable.getColumnModel().getColumnCount() > 0) {
            this.projectMapsTable.getColumnModel().getColumn(0).setMinWidth(60);
            this.projectMapsTable.getColumnModel().getColumn(0).setPreferredWidth(130);
            this.projectMapsTable.getColumnModel().getColumn(1).setPreferredWidth(280);
            this.projectMapsTable.getColumnModel().getColumn(2).setMinWidth(30);
            this.projectMapsTable.getColumnModel().getColumn(3).setMinWidth(30);
            this.projectMapsTable.getColumnModel().getColumn(4).setMinWidth(30);
            this.projectMapsTable.getColumnModel().getColumn(5).setMinWidth(30);
        }
        this.projectMapsTable.addKeyListener(new KeyListener(){

            @Override
            public void keyPressed(KeyEvent arg0) {
                if (arg0.getKeyCode() == 40) {
                    HomeMenu.this.setSelectedRegion(HomeMenu.this.projectMapsTable.getSelectedRow() + 1, false, true, false);
                } else if (arg0.getKeyCode() == 38) {
                    HomeMenu.this.setSelectedRegion(HomeMenu.this.projectMapsTable.getSelectedRow() - 1, false, true, false);
                } else {
                    JTextField editor = null;
                    if (HomeMenu.this.projectMapsTable.getCellEditor(HomeMenu.this.projectMapsTable.getSelectedRow(), 1) != null) {
                        editor = (JTextField)((DefaultCellEditor)HomeMenu.this.projectMapsTable.getCellEditor(HomeMenu.this.projectMapsTable.getSelectedRow(), 1)).getComponent();
                        String text = editor.getText();
                        System.out.println(text);
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }

            @Override
            public void keyTyped(KeyEvent e) {
            }
        });
        final JPopupMenu popupMenu2 = new JPopupMenu();
        JMenuItem load2 = new JMenuItem("Load");
        JMenuItem remove = new JMenuItem("Remove from Project");
        popupMenu2.add(load2);
        popupMenu2.add(remove);
        DefaultCellEditor dce = (DefaultCellEditor)this.projectMapsTable.getDefaultEditor(Object.class);
        final JTextField editor = (JTextField)dce.getComponent();
        editor.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void changedUpdate(DocumentEvent e) {
                if (!editor.getText().isEmpty()) {
                    RSMapperClient.project.setNoteForRegion(HomeMenu.this.selectedRegion, editor.getText());
                    HomeMenu.writeProjectInfo(RSMapperClient.project.name, RSMapperClient.project);
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {
                if (!editor.getText().isEmpty()) {
                    RSMapperClient.project.setNoteForRegion(HomeMenu.this.selectedRegion, editor.getText());
                    HomeMenu.writeProjectInfo(RSMapperClient.project.name, RSMapperClient.project);
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                if (!editor.getText().isEmpty()) {
                    RSMapperClient.project.setNoteForRegion(HomeMenu.this.selectedRegion, editor.getText());
                    HomeMenu.writeProjectInfo(RSMapperClient.project.name, RSMapperClient.project);
                }
            }
        });
        this.projectMapsTable.addMouseListener(new MouseAdapter(){

            @Override
            public void mouseClicked(MouseEvent me) {
                int row = HomeMenu.this.projectMapsTable.rowAtPoint(me.getPoint());
                HomeMenu.this.setSelectedRegion(row, true, true, false);
                if (SwingUtilities.isRightMouseButton(me)) {
                    popupMenu2.show(HomeMenu.this.projectMapsTable, me.getX(), me.getY());
                }
                if (SwingUtilities.isLeftMouseButton(me) && me.getClickCount() == 2 && HomeMenu.this.projectMapsTable.columnAtPoint(me.getPoint()) != 1) {
                    HomeMenu.this.load(HomeMenu.this.selectedRegion);
                }
                HomeMenu.this.regionsTable.clearSelection();
            }
        });
        load2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                HomeMenu.this.load(HomeMenu.this.selectedRegion);
                System.out.println("Loading (QUICK): " + HomeMenu.this.selectedRegion);
            }
        });
        remove.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent arg0) {
                HomeMenu.this.removeFromProjectQuickLoad(HomeMenu.this.selectedRegion);
            }
        });
        GroupLayout projectPanelLayout = new GroupLayout(this.projectPanel);
        this.projectPanel.setLayout(projectPanelLayout);
        projectPanelLayout.setHorizontalGroup(projectPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(projectPanelLayout.createSequentialGroup().addContainerGap().addGroup(projectPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(this.projectLabel, -1, -1, Short.MAX_VALUE).addComponent(this.projectScrollPane, -1, 577, Short.MAX_VALUE)).addContainerGap()));
        projectPanelLayout.setVerticalGroup(projectPanelLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(projectPanelLayout.createSequentialGroup().addContainerGap().addComponent(this.projectLabel, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).addComponent(this.projectScrollPane, -1, 193, Short.MAX_VALUE).addContainerGap()));
        gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = 1;
        this.add((Component)this.projectPanel, gridBagConstraints);
    }

    private void findEmptyMapActionPerformed(ActionEvent evt) {
        if (lastEmptyRegionRow >= this.regionsTable.getRowCount()) {
            lastEmptyRegionRow = 0;
        }
        int r2 = lastEmptyRegionRow + 1;
        while (r2 < this.regionsTable.getRowCount()) {
            int region = (Integer)this.regionsTable.getValueAt(r2, 0);
            int archiveId = Cache.STORE.getIndexes()[5].getArchiveId("l" + Utils.getLocalX(region) + "_" + Utils.getLocalY(region));
            if (archiveId != -1) {
                int[] keys = null;
                if (!RSMapperClient.decryptedLandFiles.contains(region) && (keys = ObjectSpawnEditor.databaseKeys.getKeys(region)) != null) {
                    HashSet<Integer> set = new HashSet<Integer>(RSMapperClient.decryptedLandFiles);
                    set.add(region);
                    RSMapperClient.decryptedLandFiles.clear();
                    RSMapperClient.decryptedLandFiles.addAll(set);
                }
                int count = 0;
                byte[] data = Cache.STORE.getIndexes()[5].getFile(archiveId, 0, keys);
                if (data != null) {
                    int objectIdIncrement;
                    InputStream buffer = new InputStream(data);
                    block1: while ((objectIdIncrement = buffer.readSmart2()) != 0) {
                        while (true) {
                            int positionIncrement = buffer.readUnsignedSmart();
                            ++count;
                            if (positionIncrement == 0) continue block1;
                            buffer.readUnsignedByte();
                        }
                    }
                    if (!(count > 20 || this.findEmptyWithUndermap.isSelected() && Cache.STORE.getIndexes()[5].getArchiveId("um" + Utils.getLocalX(region) + "_" + Utils.getLocalY(region)) == -1 || this.findEmptyWithUnderland.isSelected() && Cache.STORE.getIndexes()[5].getArchiveId("ul" + Utils.getLocalX(region) + "_" + Utils.getLocalY(region)) == -1 || Arrays.asList(IGNORED_EMPTY_REGIONS).contains(this.regionsTable.getValueAt(r2, 0)))) {
                        this.setSelectedRegion(r2, true, false, true);
                        this.objectsInRegion.setText("" + count);
                        break;
                    }
                }
            }
            ++r2;
        }
    }

    private void searchRegionIdButtonActionPerformed(ActionEvent evt) {
        if (!this.regionIdTxt.getText().trim().isEmpty()) {
            try {
                int regionId = Integer.parseInt(this.regionIdTxt.getText());
                int r2 = 0;
                while (r2 < this.regionsTable.getRowCount()) {
                    if ((Integer)this.regionsTable.getValueAt(r2, 0) == regionId) {
                        this.setSelectedRegion(r2, true, false, true);
                        break;
                    }
                    ++r2;
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
    }

    public void setSelectedRegion(int row, boolean selectRow, boolean quickLoad, boolean scroll) {
        if (quickLoad) {
            if (row < 0 || row > this.projectMapsTable.getRowCount() - 1) {
                return;
            }
            this.selectedRegion = (Integer)this.projectMapsTable.getValueAt(row, 0);
            if (selectRow) {
                this.projectMapsTable.setRowSelectionInterval(row, row);
            }
        } else {
            if (row < 0 || row > this.regionsTable.getRowCount() - 1) {
                return;
            }
            this.selectedRegion = (Integer)this.regionsTable.getValueAt(row, 0);
            if (selectRow) {
                this.regionsTable.setRowSelectionInterval(row, row);
            }
            lastEmptyRegionRow = row;
        }
        this.regionInfoLabel.setText("Region " + this.selectedRegion + " - Info and Options");
        if (scroll) {
            if (quickLoad) {
                this.projectMapsTable.scrollRectToVisible(this.projectMapsTable.getCellRect(row, 0, true));
            } else {
                this.regionsTable.scrollRectToVisible(this.regionsTable.getCellRect(row, 0, true));
            }
        }
        this.setRegionInfo(this.selectedRegion);
    }

    public void setRegionInfo(int regionId) {
        int mapArchive = Cache.STORE.getIndexes()[5].getArchiveId("m" + Utils.getLocalX(regionId) + "_" + Utils.getLocalY(regionId));
        int landArchive = Cache.STORE.getIndexes()[5].getArchiveId("l" + Utils.getLocalX(regionId) + "_" + Utils.getLocalY(regionId));
        int undermapArchive = Cache.STORE.getIndexes()[5].getArchiveId("um" + Utils.getLocalX(regionId) + "_" + Utils.getLocalY(regionId));
        int underlandArchive = Cache.STORE.getIndexes()[5].getArchiveId("ul" + Utils.getLocalX(regionId) + "_" + Utils.getLocalY(regionId));
        int details_archiveId = Cache.getStore().getIndexes()[23].getArchiveId("details");
        int details_fileId = -1;
        int area_archiveId = -1;
        int area_fileId = -1;
        String displayname = "Null";
        String archivename = "Null";
        byte[] data = Cache.getStore().getIndexes()[23].getFile(details_archiveId, 0);
        if (data != null) {
            int validFiles = Cache.getStore().getIndexes()[23].getValidFilesCount(details_archiveId);
            int i2 = 0;
            while (i2 < validFiles) {
                InputStream buffer = new InputStream(Cache.getStore().getIndexes()[23].getFile(details_archiveId, i2));
                String an = buffer.readString();
                String dn = buffer.readString();
                buffer.readInt();
                buffer.readInt();
                buffer.readUnsignedByte();
                buffer.readUnsignedByte();
                buffer.readUnsignedByte();
                int areas = buffer.readUnsignedByte();
                int area = 0;
                while (area < areas) {
                    int plane = buffer.readUnsignedByte();
                    int minX = buffer.readUnsignedShort();
                    int minY = buffer.readUnsignedShort();
                    int maxX = buffer.readUnsignedShort();
                    int maxY = buffer.readUnsignedShort();
                    boolean found = false;
                    int x = minX;
                    while (x < maxX) {
                        int y = minY;
                        while (y < maxY) {
                            if (Utils.getRegionId(x, y) == regionId) {
                                archivename = an;
                                displayname = dn;
                                details_fileId = i2;
                                int ar = 0;
                                ArchiveReference[] archiveReferenceArray = Cache.getStore().getIndexes()[23].getTable().getArchives();
                                int n2 = archiveReferenceArray.length;
                                int n3 = 0;
                                while (n3 < n2) {
                                    ArchiveReference a2 = archiveReferenceArray[n3];
                                    if (Cache.getStore().getIndexes()[23].archiveExists(ar) && a2.getNameHash() == an.hashCode()) {
                                        area_archiveId = ar;
                                        break;
                                    }
                                    ++ar;
                                    ++n3;
                                }
                                int fi = 0;
                                FileReference[] fileReferenceArray = Cache.getStore().getIndexes()[23].getTable().getArchives()[area_archiveId].getFiles();
                                int n4 = fileReferenceArray.length;
                                n2 = 0;
                                while (n2 < n4) {
                                    FileReference f = fileReferenceArray[n2];
                                    if (Cache.getStore().getIndexes()[23].fileExists(area_archiveId, fi) && f.getNameHash() == "area".hashCode()) {
                                        area_fileId = fi;
                                        break;
                                    }
                                    ++fi;
                                    ++n2;
                                }
                                found = true;
                                break;
                            }
                            ++y;
                        }
                        if (found) break;
                        ++x;
                    }
                    buffer.readUnsignedShort();
                    buffer.readUnsignedShort();
                    buffer.readUnsignedShort();
                    buffer.readUnsignedShort();
                    ++area;
                }
                ++i2;
            }
        }
        this.areaNameText.setText(displayname.equalsIgnoreCase("null") ? "Null" : String.valueOf(displayname) + " (" + archivename + ")");
        this.areaNameText.setEnabled(!displayname.equalsIgnoreCase("null"));
        this.areaFileText.setText(area_archiveId == -1 || area_fileId == -1 ? "Null" : String.valueOf(area_archiveId) + "_" + area_fileId);
        this.exportArea.setEnabled(area_archiveId != -1 && area_fileId != -1);
        this.areaFileText.setEnabled(area_archiveId != -1 && area_fileId != -1);
        this.mapArchiveId.setText("" + mapArchive);
        this.landArchiveId.setText("" + landArchive);
        this.undermapArchiveId.setText("" + undermapArchive);
        this.underlandArchiveId.setText("" + underlandArchive);
        this.exportMap.setEnabled(mapArchive != -1);
        this.mapArchiveId.setEnabled(mapArchive != -1);
        this.exportLand.setEnabled(landArchive != -1);
        this.landArchiveId.setEnabled(landArchive != -1);
        this.exportUndermap.setEnabled(undermapArchive != -1);
        this.undermapArchiveId.setEnabled(undermapArchive != -1);
        this.exportUnderland.setEnabled(underlandArchive != -1);
        this.underlandArchiveId.setEnabled(underlandArchive != -1);
        int[] keys = ObjectSpawnEditor.databaseKeys.getKeys(regionId);
        if (keys != null) {
            this.keysField.setText("{" + keys[0] + ", " + keys[1] + ", " + keys[2] + ", " + keys[3] + "}");
        } else {
            this.keysField.setText("Null");
        }
        this.keysField.setEnabled(keys != null);
        if (RSMapperClient.project.containsRegion(this.selectedRegion)) {
            this.addRemoveProjectButton.setText("Remove from Project");
            this.addRemoveProjectButton.setIcon(new ImageIcon("resources/images/red_star_icon.png"));
        } else {
            this.addRemoveProjectButton.setText("Add to Project");
            this.addRemoveProjectButton.setIcon(new ImageIcon("resources/images/blue_star_icon.png"));
        }
        this.objectsInRegion.setText("");
    }

    private void searchCoordButtonActionPerformed(ActionEvent evt) {
        if (!this.coordXTxt.getText().trim().isEmpty() && !this.coordYTxt.getText().trim().isEmpty()) {
            try {
                int regionId = Utils.getRegionId(Integer.parseInt(this.coordXTxt.getText()), Integer.parseInt(this.coordYTxt.getText()));
                int r2 = 0;
                while (r2 < this.regionsTable.getRowCount()) {
                    if ((Integer)this.regionsTable.getValueAt(r2, 0) == regionId) {
                        this.setSelectedRegion(r2, true, false, true);
                        break;
                    }
                    ++r2;
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
    }

    private void searchChunkButtonActionPerformed(ActionEvent evt) {
        if (!this.chunkCoordXTxt.getText().trim().isEmpty() && !this.chunkCoordYTxt.getText().trim().isEmpty()) {
            try {
                int regionId = Utils.getRegionId(Integer.parseInt(this.chunkCoordXTxt.getText()) << 3, Integer.parseInt(this.chunkCoordYTxt.getText()) << 3);
                int r2 = 0;
                while (r2 < this.regionsTable.getRowCount()) {
                    if ((Integer)this.regionsTable.getValueAt(r2, 0) == regionId) {
                        this.setSelectedRegion(r2, true, false, true);
                        break;
                    }
                    ++r2;
                }
            }
            catch (NumberFormatException numberFormatException) {
                // empty catch block
            }
        }
    }

    private void findEmptyWithUndermapActionPerformed(ActionEvent evt) {
        lastEmptyRegionRow = 0;
    }

    private void findEmptyWithUnderlandActionPerformed(ActionEvent evt) {
        lastEmptyRegionRow = 0;
    }

    private void exportMapActionPerformed(ActionEvent evt) {
        if (this.exportMap.isEnabled()) {
            try {
                RSMapperClient.editor.mapEditor.exportFile(this.selectedRegion, true, false);
            } catch (Throwable ignore) {
            }
        }
    }

    private void exportLandActionPerformed(ActionEvent evt) {
        if (this.exportLand.isEnabled()) {
            try {
                RSMapperClient.editor.objectEditor.exportFile(this.selectedRegion, true, false);
            } catch (Throwable ignore) {
            }
        }
    }

    private void exportUndermapActionPerformed(ActionEvent evt) {
        if (this.exportUndermap.isEnabled()) {
            try {
                RSMapperClient.editor.mapEditor.exportFile(this.selectedRegion, true, true);
            } catch (Throwable ignore) {
            }
        }
    }

    private void exportUnderlandActionPerformed(ActionEvent evt) {
        if (this.exportUndermap.isEnabled()) {
            try {
                RSMapperClient.editor.objectEditor.exportFile(this.selectedRegion, true, true);
            } catch (Throwable ignore) {
            }
        }
    }

    private void exportAreaActionPerformed(ActionEvent evt) {
        if (this.exportArea.isEnabled()) {
            if (this.areaFileText.getText().isEmpty()) {
                JOptionPane.showMessageDialog(RSMapperClient.client_frame, "No area file exists", "ERROR", 0);
                return;
            }
            try {
                int archiveId = Integer.parseInt(this.areaFileText.getText().split("_")[0].trim());
                int fileId = Integer.parseInt(this.areaFileText.getText().split("_")[1].trim());
                byte[] data = Cache.STORE.getIndexes()[23].getFile(archiveId, fileId);
                if (data == null) {
                    JOptionPane.showMessageDialog(RSMapperClient.client_frame, "No area file exists", "ERROR", 0);
                    return;
                }
                File file = null;
                file = new File("data/projects/" + RSMapperClient.project.name + "/exports/" + this.selectedRegion + "/");
                if (!file.exists()) {
                    file.mkdirs();
                }
                file = new File(String.valueOf(file.toString()) + "/" + archiveId + "_" + fileId + "_area");
                try {
                    Throwable throwable = null;
                    Object var7_10 = null;
                    try (FileOutputStream fos = new FileOutputStream(file);){
                        fos.write(data);
                        fos.close();
                        JOptionPane.showMessageDialog(RSMapperClient.client_frame, "Compiled worldmap area file " + archiveId + "_" + fileId + " to " + file.toString(), "SUCCESS", 1);
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
                catch (Throwable e) {
                    e.printStackTrace();
                }
            }
            catch (Exception exception) {
                // empty catch block
            }
        }
    }

    private void checkObjectSpawnsActionPerformed(ActionEvent evt) {
        int archiveId = Cache.STORE.getIndexes()[5].getArchiveId("l" + Utils.getLocalX(this.selectedRegion) + "_" + Utils.getLocalY(this.selectedRegion));
        if (archiveId != -1) {
            int[] keys = ObjectSpawnEditor.databaseKeys.getKeys(this.selectedRegion);
            if (keys != null && RSMapperClient.decryptedLandFiles.contains(this.selectedRegion)) {
                keys = null;
            } else if (keys != null) {
                HashSet<Integer> set = new HashSet<Integer>(RSMapperClient.decryptedLandFiles);
                set.add(this.selectedRegion);
                RSMapperClient.decryptedLandFiles.clear();
                RSMapperClient.decryptedLandFiles.addAll(set);
            }
            int count = 0;
            byte[] data = Cache.STORE.getIndexes()[5].getFile(archiveId, 0, keys);
            if (data != null) {
                int objectIdIncrement;
                InputStream buffer = new InputStream(data);
                block0: while ((objectIdIncrement = buffer.readSmart2()) != 0) {
                    while (true) {
                        int positionIncrement = buffer.readUnsignedSmart();
                        ++count;
                        if (positionIncrement == 0) continue block0;
                        buffer.readUnsignedByte();
                    }
                }
                this.objectsInRegion.setText("" + count);
            } else {
                this.objectsInRegion.setText("Null Data");
            }
        }
    }

    private void returnButtonMouseEntered(MouseEvent evt) {
        if (this.returnButton.isEnabled()) {
            this.returnButton.setBorder(BorderFactory.createLineBorder(new Color(165, 213, 248), 1, true));
            this.returnButton.setBackground(new Color(220, 220, 220));
            this.returnButton.setForeground(new Color(185, 223, 252));
        }
    }

    private void returnButtonMouseExited(MouseEvent evt) {
        this.returnButton.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 1, false));
        this.returnButton.setBackground(new Color(151, 148, 144));
        this.returnButton.setForeground(new Color(165, 213, 248));
    }

    private void returnButtonMousePressed(MouseEvent evt) {
        if (this.returnButton.isEnabled()) {
            this.returnButton.setBackground(new Color(120, 120, 120));
        }
    }

    private void returnButtonMouseReleased(MouseEvent evt) {
        if (this.returnButton.isEnabled()) {
            this.returnButton.setBackground(new Color(151, 148, 144));
            if (this.projectExplorer != null) {
                this.projectExplorer.dispose();
                this.projectExplorer = null;
            }
            this.showMenu(false);
        }
    }

    private void projectExplorerMouseEntered(MouseEvent evt) {
        this.exploreProjects.setBorder(BorderFactory.createLineBorder(new Color(165, 213, 248), 1, true));
        this.exploreProjects.setBackground(new Color(220, 220, 220));
        this.exploreProjects.setForeground(new Color(185, 223, 252));
    }

    private void projectExplorerMouseExited(MouseEvent evt) {
        this.exploreProjects.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 1, false));
        this.exploreProjects.setBackground(new Color(151, 148, 144));
        this.exploreProjects.setForeground(new Color(165, 213, 248));
    }

    private void projectExplorerMousePressed(MouseEvent evt) {
        this.exploreProjects.setBackground(new Color(120, 120, 120));
    }

    private void projectExplorerMouseReleased(MouseEvent evt) {
        this.exploreProjects.setBackground(new Color(151, 148, 144));
        this.openProjectExplorer();
    }

    private void createProjectMouseEntered(MouseEvent evt) {
        this.createProject.setBorder(BorderFactory.createLineBorder(new Color(165, 213, 248), 1, true));
        this.createProject.setBackground(new Color(220, 220, 220));
        this.createProject.setForeground(new Color(185, 223, 252));
    }

    private void createProjectMouseExited(MouseEvent evt) {
        this.createProject.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 1, false));
        this.createProject.setBackground(new Color(151, 148, 144));
        this.createProject.setForeground(new Color(165, 213, 248));
    }

    private void createProjectMousePressed(MouseEvent evt) {
        this.createProject.setBackground(new Color(120, 120, 120));
    }

    private void createProjectMouseReleased(MouseEvent evt) {
        this.createProject.setBackground(new Color(151, 148, 144));
        if (this.projectExplorer != null) {
            this.projectExplorer.dispose();
            this.projectExplorer = null;
        }
        this.createProject();
    }

    public void openProjectExplorer() {
        if (this.projectExplorer == null) {
            EventQueue.invokeLater(new Runnable(){

                @Override
                public void run() {
                    HomeMenu.this.projectExplorer = new ProjectExplorer(RSMapperClient.project);
                    HomeMenu.this.projectExplorer.setVisible(true);
                }
            });
        } else {
            this.projectExplorer.dispose();
            this.projectExplorer = null;
        }
    }

    public void createProject() {
        JPanel al = new JPanel();
        al.setLayout(null);
        al.setSize(130, 50);
        al.setPreferredSize(new Dimension(130, 50));
        JTextField projectName = new JTextField("");
        projectName.setBounds(10, 10, 220, 32);
        projectName.setHorizontalAlignment(0);
        al.add(projectName);
        int choice = JOptionPane.showOptionDialog(RSMapperClient.client_frame, al, "Enter a project name", 0, -1, null, new Object[]{"Cancel", "Create"}, "Create");
        if (choice == 1) {
            File mainFolder = new File("data/projects/");
            String name = projectName.getText().trim().replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
            if (name != null && name.length() > 0) {
                int replace;
                File projectFolder = new File(String.valueOf(mainFolder.toString()) + "/" + name + "/");
                if (projectFolder.exists() && (replace = JOptionPane.showOptionDialog(RSMapperClient.client_frame, "Replace the existing project?", "Project Already Exists", 0, 2, null, new Object[]{"Yes", "Cancel"}, "Cancel")) != 0) {
                    return;
                }
                projectFolder.mkdirs();
                RSMapperClient.project = new Project(name);
                HomeMenu.writeProjectInfo(name, RSMapperClient.project);
                this.projectLabel.setText("<html>Project<font color='#28b5ed'> " + name + "</font> Maps</html>");
                DefaultTableModel dtm = (DefaultTableModel)this.projectMapsTable.getModel();
                dtm.setRowCount(0);
                this.projectMapsTable.setModel(dtm);
                this.projectMapsTable.validate();
                this.projectMapsTable.repaint();
            }
        }
    }

    private void addToProjectQuickloads(int regionId) {
        if (regionId <= 0) {
            return;
        }
        if (!RSMapperClient.project.containsRegion(regionId)) {
            RSMapperClient.project.addToQuickLoad(new Object[]{regionId, ""});
            DefaultTableModel dtm = (DefaultTableModel)this.projectMapsTable.getModel();
            dtm.setRowCount(0);
            int count = 0;
            while (count < RSMapperClient.project.quickLoads.size()) {
                int reg = RSMapperClient.project.getRegionAtIndex(count);
                int mapArchive = Cache.STORE.getIndexes()[5].getArchiveId("m" + Utils.getLocalX(reg) + "_" + Utils.getLocalY(reg));
                int landArchive = Cache.STORE.getIndexes()[5].getArchiveId("l" + Utils.getLocalX(reg) + "_" + Utils.getLocalY(reg));
                int undermapArchive = Cache.STORE.getIndexes()[5].getArchiveId("um" + Utils.getLocalX(reg) + "_" + Utils.getLocalY(reg));
                int underlandArchive = Cache.STORE.getIndexes()[5].getArchiveId("ul" + Utils.getLocalX(reg) + "_" + Utils.getLocalY(reg));
                if (mapArchive != -1) {
                    Object[] r2 = new Object[1];
                    r2 = new Object[]{reg, RSMapperClient.project.getNoteAtIndex(RSMapperClient.project.getIndexOfQuickLoad(new Object[]{r2[0], ""}, false)), Character.valueOf('Y'), Character.valueOf(landArchive == -1 ? (char)'N' : 'Y'), Character.valueOf(undermapArchive == -1 ? (char)'N' : 'Y'), Character.valueOf(underlandArchive == -1 ? (char)'N' : 'Y')};
                    dtm.addRow(r2);
                }
                ++count;
            }
            this.projectMapsTable.setModel(dtm);
            this.projectMapsTable.validate();
            this.projectMapsTable.repaint();
            if (this.selectedRegion == regionId) {
                this.addRemoveProjectButton.setText("Remove from Project");
                this.addRemoveProjectButton.setIcon(new ImageIcon("resources/images/red_star_icon.png"));
            }
            RSMapperClient.project.setDateModified();
            HomeMenu.writeProjectInfo(RSMapperClient.project.name, RSMapperClient.project);
        }
    }

    private void removeFromProjectQuickLoad(int regionId) {
        if (regionId <= 0) {
            return;
        }
        if (RSMapperClient.project.containsRegion(regionId)) {
            RSMapperClient.project.removeQuickLoad(new Object[]{regionId, ""});
            DefaultTableModel dtm = (DefaultTableModel)this.projectMapsTable.getModel();
            int count = 0;
            while (count < dtm.getRowCount()) {
                if ((Integer)this.projectMapsTable.getValueAt(count, 0) == regionId) {
                    dtm.removeRow(count);
                    break;
                }
                ++count;
            }
            this.projectMapsTable.setModel(dtm);
            this.projectMapsTable.validate();
            this.projectMapsTable.repaint();
            if (this.selectedRegion == regionId) {
                this.addRemoveProjectButton.setText("Add to Project");
                this.addRemoveProjectButton.setIcon(new ImageIcon("resources/images/blue_star_icon.png"));
            }
            RSMapperClient.project.setDateModified();
            HomeMenu.writeProjectInfo(RSMapperClient.project.name, RSMapperClient.project);
        }
    }

    public void load(final int regionId) {
        if (!this.canShow) {
            return;
        }
        if (this.projectExplorer != null) {
            this.projectExplorer.dispose();
            this.projectExplorer = null;
        }
        EventQueue.invokeLater(new Runnable(){

            @Override
            public void run() {
                boolean skip = false;
                if (HomeMenu.this.alreadyLoggedIn) {
                    try {
                        if (Utils.getArchiveId("m", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId)) == -1) {
                            JOptionPane.showMessageDialog(RSMapperClient.client_frame, "Could not load region " + regionId + ", map files do not exist.", "Nothing to load", 1);
                            skip = true;
                        }
                        if (WorldmapDefinitions.worldmapIsOpen()) {
                            JOptionPane.showMessageDialog(RSMapperClient.client_frame, "Please close the worldmap before doing this.", "Close Worldmap", 2);
                            skip = true;
                        }
                        if (!skip && RSMapperClient.editor.mapEditor.unsavedMapProgress && JOptionPane.showOptionDialog(RSMapperClient.client_frame, "You have unsaved \"map\" progress!", "ARE YOU SURE?", 0, 2, null, new Object[]{"Yes", "Cancel"}, "Cancel") != 0) {
                            skip = true;
                        }
                        if (!skip && RSMapperClient.editor.mapEditor.unsavedUndermapProgress && JOptionPane.showOptionDialog(RSMapperClient.client_frame, "You have unsaved \"undermap\" progress!", "ARE YOU SURE?", 0, 2, null, new Object[]{"Yes", "Cancel"}, "Cancel") != 0) {
                            skip = true;
                        }
                        if (!skip && RSMapperClient.editor.objectEditor.unsavedLandProgress && JOptionPane.showOptionDialog(RSMapperClient.client_frame, "You have unsaved \"land\" progress!", "ARE YOU SURE?", 0, 2, null, new Object[]{"Yes", "Cancel"}, "Cancel") != 0) {
                            skip = true;
                        }
                        if (!skip && RSMapperClient.editor.objectEditor.unsavedUnderlandProgress && JOptionPane.showOptionDialog(RSMapperClient.client_frame, "You have unsaved \"underland\" progress!", "ARE YOU SURE?", 0, 2, null, new Object[]{"Yes", "Cancel"}, "Cancel") != 0) {
                            skip = true;
                        }
                        if (!skip && !WorldmapDefinitions.worldmapIsOpen()) {
                            Class127.logout(11582, false);
                            RSMapperClient.regionId = 0;
                            RSMapperClient.MAP_LOADED = false;
                            RSMapperClient.mapArchiveId = -1;
                            RSMapperClient.landArchiveId = -1;
                            RSMapperClient.undermapArchiveId = -1;
                            RSMapperClient.underlandArchiveId = -1;
                            Class<?> clazz = Class.forName(RSMapperClient.editor.tool.getClass().getName());
                            RSMapperClient.editor = new Editor(false, RSMapperClient.editor.brush, (Tool)clazz.newInstance(), RSMapperClient.editor.editing, RSMapperClient.editor.dataSelection);
                        }
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (skip) {
                    HomeMenu.this.showMenu(false);
                    return;
                }
                try {
                    if (RSMapperClient.mapArchiveId != Utils.getArchiveId("m", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId))) {
                        RSMapperClient.mapArchiveId = Utils.getArchiveId("m", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                    }
                    if (RSMapperClient.undermapArchiveId != Utils.getArchiveId("um", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId))) {
                        RSMapperClient.undermapArchiveId = Utils.getArchiveId("um", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                    }
                    if (RSMapperClient.landArchiveId != Utils.getArchiveId("l", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId))) {
                        RSMapperClient.landArchiveId = Utils.getArchiveId("l", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                    }
                    if (RSMapperClient.underlandArchiveId != Utils.getArchiveId("ul", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId))) {
                        RSMapperClient.underlandArchiveId = Utils.getArchiveId("ul", Utils.getRegionCoordX(regionId), Utils.getRegionCoordY(regionId));
                    }
                    if (RSMapperClient.mapArchiveId == -1 && RSMapperClient.landArchiveId == -1) {
                        JOptionPane.showMessageDialog(RSMapperClient.client_frame, "Could not load region, map files do not exist.", "Nothing to load", 1);
                        return;
                    }
                    RSMapperClient.regionId = regionId;
                    HomeMenu.writeProjectInfo(RSMapperClient.project.name, RSMapperClient.project);
                    RSMapperClient.client_frame.setTitle("Map Editor - Region: " + RSMapperClient.regionId + " - Center: (" + (Utils.getRegionCoordX(RSMapperClient.regionId) + 32) + ", " + (Utils.getRegionCoordY(RSMapperClient.regionId) + 32) + ")" + " - [Map: " + RSMapperClient.mapArchiveId + " - Land: " + RSMapperClient.landArchiveId + " - UnderMap: " + RSMapperClient.undermapArchiveId + " - UnderLand: " + RSMapperClient.underlandArchiveId + "]" + " - Encrypted: " + (ObjectSpawnEditor.databaseKeys.getKeys(regionId) != null ? "True" : "False"));
                    Class39.login(1, "pass", "user" + new Random().nextInt(25), -113);
                    RSMapperClient.editor.login(HomeMenu.this.alreadyLoggedIn);
                    if (!HomeMenu.this.alreadyLoggedIn) {
                        HomeMenu.this.alreadyLoggedIn = true;
                    }
                    HomeMenu.this.showMenu(false);
                }
                catch (Exception e) {
                    e.printStackTrace();
                }
                RSMapperClient.setFocusOnCanvas();
            }
        });
    }

    public static void writeProjectInfo(String projectname, Project project) {
        try {
            Throwable throwable = null;
            Object var3_5 = null;
            try (FileOutputStream fileOut = new FileOutputStream("data/projects/" + projectname + "/project.info");){
                Throwable throwable2 = null;
                Object var6_10 = null;
                try (ObjectOutputStream out = new ObjectOutputStream(fileOut);){
                    out.writeObject(project);
                    out.close();
                }
                catch (Throwable throwable3) {
                    if (throwable2 == null) {
                        throwable2 = throwable3;
                    } else if (throwable2 != throwable3) {
                        throwable2.addSuppressed(throwable3);
                    }
                    throw throwable2;
                }
                fileOut.close();
            }
            catch (Throwable throwable4) {
                if (throwable == null) {
                    throwable = throwable4;
                } else if (throwable != throwable4) {
                    throwable.addSuppressed(throwable4);
                }
                throw throwable;
            }
        }
        catch (Throwable i2) {
            i2.printStackTrace();
        }
    }

    public static boolean deleteProjectInfo(String projectname) {
        File file;
        block3: {
            try {
                file = new File("data/projects/" + projectname + "/project.info");
                System.out.println("Deleting: " + file.toString());
                if (file.exists()) break block3;
                return true;
            }
            catch (Exception i2) {
                i2.printStackTrace();
                return false;
            }
        }
        return file.delete();
    }

    public static Project loadProjectInfo(String projectname) {
        Project project = null;
        try {
            File file = new File("data/projects/" + projectname + "/project.info");
            if (!file.exists()) {
                HomeMenu.writeProjectInfo(projectname, new Project(projectname));
            }
            Throwable throwable = null;
            Object var4_7 = null;
            try (FileInputStream fileIn = new FileInputStream(file);){
                Throwable throwable2 = null;
                Object var7_12 = null;
                try (ObjectInputStream in = new ObjectInputStream(fileIn);){
                    project = (Project)in.readObject();
                    in.close();
                }
                catch (Throwable throwable3) {
                    if (throwable2 == null) {
                        throwable2 = throwable3;
                    } else if (throwable2 != throwable3) {
                        throwable2.addSuppressed(throwable3);
                    }
                    throw throwable2;
                }
                fileIn.close();
            }
            catch (Throwable throwable4) {
                if (throwable == null) {
                    throwable = throwable4;
                } else if (throwable != throwable4) {
                    throwable.addSuppressed(throwable4);
                }
                throw throwable;
            }
        }
        catch (Throwable i2) {
            System.err.println("project IO exception");
            return null;
        }
        return project;
    }
}

