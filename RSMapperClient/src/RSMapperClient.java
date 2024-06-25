import com.rs.cache.Cache;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import org.jvnet.substance.skin.SubstanceRavenLookAndFeel;

/**
 * RSMapperClient class manages the client-side operations of the RSMapper
 * service.
 * It initializes the GUI, handles configuration settings, and manages
 * interactions with the server.
 */
public class RSMapperClient extends JApplet implements Serializable, ActionListener, ComponentListener {
   private static final long serialVersionUID = -3815183950296997504L;
   public static JFrame client_frame;
   public static JPanel client_panel;
   public static UIPanels uiPanels;
   public static JPanel homeMenu;
   public static boolean ERRORED_OUT = false;
   public static final boolean DISABLE_USELESS_PACKETS = false;
   public static int PORT_ID = 43596;
   private Properties properties;
   public static Project project;
   public static Editor editor;
   public static Settings settings;
   public static HashMap<Integer, ClientScript> externalCS2;
   public static ArrayList<Integer> decryptedLandFiles;
   public static boolean MAP_LOADED = false;
   public static boolean LOAD_ALL_REGIONS = false;
   public static boolean INTERFACES_LOADED = false;
   public static int regionId;
   public static int mapArchiveId;
   public static int landArchiveId;
   public static int undermapArchiveId;
   public static int underlandArchiveId;

   /**
    * The main method to run the RSMapperClient application.
    *
    * @param strings Command-line arguments (not used).
    * @throws Exception if an error occurs during initialization.
    */
   public static void main(String[] strings) throws Exception {
      SwingUtilities.invokeLater(new Runnable() {
         @Override
         public void run() {
            RSMapperClient loader = new RSMapperClient();
            loader.doFrame();
         }
      });
   }

   /**
    * Initializes the frame and starts the client.
    */
   public void doFrame() {
      settings = new Settings();
      try {
         project = HomeMenu.loadProjectInfo("Workspace");
      } catch (Throwable e) {
         throw new RuntimeException(e);
      }
      this.setParams();
      this.openFrame();
      this.startClient();
      EventQueue.invokeLater(new Runnable() {
         @Override
         public void run() {
            try {
               Cache.init();
               RSMapperClient.homeMenu = new HomeMenu();
               RSMapperClient.client_panel.add(RSMapperClient.homeMenu, "North");
               ((HomeMenu) RSMapperClient.homeMenu).init();
               RSMapperClient.loadCS2();
            } catch (IOException var2) {
               var2.printStackTrace();
            }
         }
      });
   }

   /**
    * Loads external CS2 scripts from the specified directory.
    */
   public static void loadCS2() {
      externalCS2 = new HashMap<>();
      File file = new File("resources" + File.separator + "cs2" + File.separator);
      if (file != null) {
         File[] files = new File(file.toString()).listFiles();
         if (files != null) {
            for (File f : files) {
               try {
                  Integer id = Integer.parseInt(f.getName().split("\\.")[0].trim());
                  if (externalCS2.get(id) == null) {
                     byte[] data = Utils.getDataFromFile(f);
                     ClientScript cs = Class32.loadClientScript(data, false, (long) id.intValue());
                     externalCS2.put(id, cs);
                  }
               } catch (Exception var9) {
                  // Handle exception
               }
            }
         }
      }
   }

   /**
    * Sets focus on the game canvas.
    */
   public static void setFocusOnCanvas() {
      if (Node_Sub38_Sub20.GAME_CANVAS != null) {
         Node_Sub38_Sub20.GAME_CANVAS.requestFocusInWindow();
      }
   }

   /**
    * Opens the main application frame and initializes components.
    */
   private void openFrame() {
      try {
         JFrame.setDefaultLookAndFeelDecorated(true);
         JDialog.setDefaultLookAndFeelDecorated(true);
         UIManager.setLookAndFeel(new SubstanceRavenLookAndFeel());
         UIManager.put("swing.boldMetal", Boolean.FALSE);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

      client_frame = new JFrame();
      client_frame.setTitle("Map Editor");
      client_frame.setLayout(new BorderLayout());
      client_frame.setFocusable(true);
      client_frame.addComponentListener(this);
      client_frame.setMinimumSize(new Dimension(1086, 940));
      client_panel = new JPanel();
      client_panel.setLayout(new BorderLayout());
      client_panel.add(this);
      client_panel.setPreferredSize(new Dimension(900, 600));
      client_panel.setFocusable(true);
      client_panel.setRequestFocusEnabled(true);
      client_frame.getContentPane().add(client_panel, "Center");
      uiPanels = new UIPanels();
      decryptedLandFiles = new ArrayList<>();
      editor = new Editor(true, null, null, null, null);
      client_frame.setDefaultCloseOperation(0);
      client_frame.addWindowListener(
            new WindowAdapter() {
               @Override
               public void windowClosing(WindowEvent we) {
                  boolean[] unsaved = new boolean[] {
                        RSMapperClient.editor.mapEditor.unsavedMapProgress,
                        RSMapperClient.editor.mapEditor.unsavedUndermapProgress,
                        RSMapperClient.editor.objectEditor.unsavedLandProgress,
                        RSMapperClient.editor.objectEditor.unsavedUnderlandProgress
                  };
                  int unsavedCount = 0;

                  for (boolean b : unsaved) {
                     if (b) {
                        ++unsavedCount;
                     }
                  }

                  if (unsavedCount > 0) {
                     String[] ObjButtons = new String[] { "Exit Anyway", "Nevermind" };
                     String message = String.format(
                           "You have potentially unsaved progress in the following files:\n %s%s%s%s",
                           unsaved[0] ? "map" : "",
                           unsaved[0] && unsaved[1] ? ", undermap" : (unsaved[1] ? "undermap" : ""),
                           (unsaved[0] || unsaved[1]) && unsaved[2] ? ", land" : (unsaved[2] ? "land" : ""),
                           (unsaved[0] || unsaved[1] || unsaved[2]) && unsaved[3] ? ", underland"
                                 : (unsaved[3] ? "underland" : ""));
                     int PromptResult = JOptionPane.showOptionDialog(
                           RSMapperClient.client_frame,
                           message,
                           "Are you sure? You have " + unsavedCount + " unsaved files.",
                           -1,
                           2,
                           null,
                           ObjButtons,
                           ObjButtons[1]);
                     if (PromptResult == 0) {
                        System.exit(0);
                     }
                  } else {
                     System.exit(0);
                  }
               }
            });
      client_frame.setIconImage(Utils.getImage("./resources/icon.png"));
      client_frame.setJMenuBar(new ClientMenuBar());
      client_frame.setVisible(true);
      client_frame.setResizable(false);
      client_frame.pack();
      client_frame.setLocationRelativeTo(null);
   }

   /**
    * Starts the client by initializing and starting the Client object.
    */
   private void startClient() {
      GameStub.provideLoaderApplet(this);
      Client c = new Client();
      c.init();
      c.start();
   }

   /**
    * Sets parameters for the applet configuration.
    */
   public void setParams() {
      this.properties = new Properties();
      this.properties.put("cabbase", "g.cab");
      this.properties.put("java_arguments", "-Xmx102m -Dsun.java2d.noddraw=true");
      this.properties.put("colourid", "0");
      this.properties.put("worldid", "1");
      this.properties.put("lobbyid", "1");
      this.properties.put("lobbyaddress", Constants.IP);
      this.properties.put("demoid", "0");
      this.properties.put("demoaddress", "");
      this.properties.put("modewhere", "0");
      this.properties.put("modewhat", "0");
      this.properties.put("lang", "0");
      this.properties.put("objecttag", "0");
      this.properties.put("js", "1");
      this.properties.put("game", "0");
      this.properties.put("affid", "0");
      this.properties.put("advert", "1");
      this.properties.put("settings", "wwGlrZHF5gJcZl7tf7KSRh0MZLhiU0gI0xDX6DwZ-Qk");
      this.properties.put("country", "0");
      this.properties.put("haveie6", "0");
      this.properties.put("havefirefox", "1");
      this.properties.put("cookieprefix", "");
      this.properties.put("cookiehost", Constants.IP);
      this.properties.put("cachesubdirid", "0");
      this.properties.put("crashurl", "");
      this.properties.put("unsignedurl", "");
      this.properties.put("sitesettings_member", "1");
      this.properties.put("frombilling", "false");
      this.properties.put("sskey", "");
      this.properties.put("force64mb", "false");
      this.properties.put("worldflags", "8");
   }

   /**
    * Initializes the applet.
    */
   @Override
   public void init() {
      this.setParams();
      this.startClient();
   }

   /**
    * Gets the parameter value for the specified key.
    *
    * @param paramString The parameter key.
    * @return The parameter value.
    */
   @Override
   public String getParameter(String paramString) {
      return (String) this.properties.get(paramString);
   }

   /**
    * Gets the document base URL.
    *
    * @return The document base URL.
    */
   @Override
   public URL getDocumentBase() {
      return this.getCodeBase();
   }

   /**
    * Gets the code base URL.
    *
    * @return The code base URL.
    */
   @Override
   public URL getCodeBase() {
      try {
         return new URL("http://" + Constants.IP);
      } catch (Exception var2) {
         var2.printStackTrace();
         return null;
      }
   }

   /**
    * Handles component hidden event.
    *
    * @param arg0 The component event.
    */
   @Override
   public void componentHidden(ComponentEvent arg0) {
   }

   /**
    * Handles component moved event.
    *
    * @param arg0 The component event.
    */
   @Override
   public void componentMoved(ComponentEvent arg0) {
   }

   /**
    * Handles component resized event.
    *
    * @param arg0 The component event.
    */
   @Override
   public void componentResized(ComponentEvent arg0) {
      try {
         Component c = (Component) arg0.getSource();
         int addedWidth = c.getWidth() - 1284;
         int addedHeight = c.getHeight() - 946;
         UIPanels.generalComponents.get("toggle_objects").setBounds(c.getWidth() - 513 - 28 - 28, 8, 24, 25);
         UIPanels.generalComponents.get("toggle_player").setBounds(c.getWidth() - 513 - 28, 8, 24, 25);
         UIPanels.generalComponents.get("toggle_env").setBounds(c.getWidth() - 513, 8, 24, 25);
         UIPanels.generalComponents.get("refresh_minimap").setBounds(c.getWidth() - 477, 8, 76, 24);
         UIPanels.generalComponents.get("toggle_multi").setBounds(c.getWidth() - 385, 5, 50, 30);
         UIPanels.generalComponents.get("clear_selected_tiles").setBounds(c.getWidth() - 330, 8, 40, 24);
         UIPanels.generalComponents.get("cb_brushtype").setBounds(c.getWidth() - 280, 5, 130, 30);
         UIPanels.generalComponents.get("slider_brushsize").setBounds(c.getWidth() - 147, 10, 120, 20);
         UIPanels.generalComponents.get("label_brushsize").setBounds(c.getWidth() - 25, 10, 20, 20);
         UIPanels.jtpEditing.setSize(new Dimension(300, UIPanels.jtpEditing.getPreferredSize().height + addedHeight));
         UIPanels.propertiesTabPanel
               .setSize(new Dimension(300, UIPanels.propertiesTabPanel.getPreferredSize().height + addedHeight));
         UIPanels.objectsTabPanel
               .setSize(new Dimension(300, UIPanels.objectsTabPanel.getPreferredSize().height + addedHeight));
         if (UIPanels.bottomPanel != null) {
            if (((BottomMenu) UIPanels.bottomPanel).noteScrollPane != null) {
               ((BottomMenu) UIPanels.bottomPanel).noteScrollPane
                     .setSize(
                           new Dimension(
                                 ((BottomMenu) UIPanels.bottomPanel).noteScrollPane.getPreferredSize().width
                                       + addedWidth,
                                 ((BottomMenu) UIPanels.bottomPanel).noteScrollPane.getPreferredSize().height));
               ((BottomMenu) UIPanels.bottomPanel).selectedNoteTitle
                     .setSize(
                           new Dimension(
                                 ((BottomMenu) UIPanels.bottomPanel).selectedNoteTitle.getPreferredSize().width
                                       + addedWidth,
                                 ((BottomMenu) UIPanels.bottomPanel).selectedNoteTitle.getPreferredSize().height));
               JButton saveNoteButton = (JButton) UIPanels.generalComponents.get("save_note");
               saveNoteButton.setSize(new Dimension(saveNoteButton.getPreferredSize().width + addedWidth,
                     saveNoteButton.getPreferredSize().height));
               JButton deleteNoteButton = (JButton) UIPanels.generalComponents.get("delete_note");
               deleteNoteButton.setBounds(506 + addedWidth, deleteNoteButton.getY(), deleteNoteButton.getWidth(),
                     deleteNoteButton.getHeight());
            }

            int textureButtonShift = addedWidth / 63;
            UIPanels.generalComponents.get("jtp_data").setBounds(656, 4, 618 + addedWidth, 247);
            int shiftX = 0;
            int shiftY = 0;

            for (int i = 0; i < 255; ++i) {
               int x = (textureButtonShift == 0 ? 3 : 2) + shiftX * 65;
               int y = 2 + shiftY * 68;
               JButton button = (JButton) UIPanels.generalComponents.get("btn_overlay_" + (i + 1));
               button.setBounds(x, y, 63, 67);
               if (i < 166) {
                  button = (JButton) UIPanels.generalComponents.get("btn_underlay_" + (i + 1));
                  button.setBounds(x, y, 63, 67);
               }

               if (++shiftX == 9 + textureButtonShift) {
                  shiftX = 0;
                  ++shiftY;
               }
            }

            int newWidth = addedWidth < 0 ? 588 - 67 * -textureButtonShift : 588 + addedWidth;
            ((BottomMenu) UIPanels.bottomPanel).overlaysPanel
                  .setPreferredSize(new Dimension(newWidth,
                        3 + (255 / (9 + textureButtonShift) + (255 % (9 + textureButtonShift) > 0 ? 1 : 0)) * 68));
            ((BottomMenu) UIPanels.bottomPanel).underlaysPanel
                  .setPreferredSize(new Dimension(newWidth,
                        3 + (166 / (9 + textureButtonShift) + (166 % (9 + textureButtonShift) > 0 ? 1 : 0)) * 68));
         }
      } catch (Exception var12) {
         // Handle exception
      }
   }

   /**
    * Handles component shown event.
    *
    * @param arg0 The component event.
    */
   @Override
   public void componentShown(ComponentEvent arg0) {
   }

   /**
    * Handles action performed event.
    *
    * @param e The action event.
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      try {
         String command = e.getActionCommand();
         if (command.equalsIgnoreCase("Exit")) {
            System.exit(1);
         } else {
            System.out.println(command);
         }
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   /**
    * Gets the cache path.
    *
    * @return The cache path as a string.
    */
   public static String getCachePath() {
      return "data/cache";
   }

   /**
    * Gets the external cache path.
    *
    * @return The external cache path as an integer.
    */
   public static int getExternalCachePath() {
      return Integer.parseInt("Unparagoned Development & Community");
   }

   /**
    * Checks if a new interface with the specified ID exists.
    *
    * @param id The interface ID.
    * @return true if the interface exists, false otherwise.
    */
   public static boolean newInterface(int id) {
      if (id > 1144) {
         return true;
      } else {
         switch (id) {
            case 320:
            case 751:
               return true;
            default:
               return false;
         }
      }
   }

   /**
    * Toggles the loading of all regions.
    */
   public static void toggleLoadAllRegions() {
      MAP_LOADED = false;
      LOAD_ALL_REGIONS = !LOAD_ALL_REGIONS;
      r_Sub2.method2376(1);
      Class78.MAP_CHANGED = true;
      refreshMiniMap();
   }

   /**
    * Refreshes the minimap.
    */
   public static void refreshMiniMap() {
      if (Node_Sub38_Sub39.index8 != null && System.currentTimeMillis() >= Class78.MINIMAP_REFRESH_DELAY) {
         Node_Sub38_Sub39.index8.method3523((byte) -46);
         Node_Sub38_Sub39.index8.method3521((byte) -18);
         Node_Sub54.aClass338_7671.method3908(-32478);
         Class304.aClass215_3834.method2071(7);
         Node_Sub18.method2606(126);
         setFocusOnCanvas();
         Class78.setMinimapRefreshDelay();
      }
   }
}
