import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class ClientMenuBar extends JMenuBar implements ActionListener {
   private final JMenu file = new JMenu("File");
   private final JMenu settings;
   private final JMenuItem openMenu;
   private final JMenuItem saveMapFile;
   private final JMenuItem saveLandFile;
   private final JMenuItem saveUndermapFile;
   private final JMenuItem saveUnderlandFile;
   private final JMenuItem saveWorldmapArea;
   private final JMenuItem loadRegion;
   private final JMenuItem exit;
   private final JMenuItem objects;
   private final JMenuItem overlays;
   private final JMenuItem underlays;
   private final JMenuItem generalOverlays;
   private final JMenuItem hoverOverlays;
   private final JButton record;

   public ClientMenuBar() {
      this.file.getPopupMenu().setLightWeightPopupEnabled(false);
      this.add(this.file);
      this.openMenu = new JMenuItem("Menu");
      this.file.add(this.openMenu);
      this.file.addSeparator();
      JMenu saveMenu = new JMenu("Save to Cache");
      this.saveMapFile = new JMenuItem("Save Map");
      saveMenu.add(this.saveMapFile);
      saveMenu.addSeparator();
      this.saveLandFile = new JMenuItem("Save Land");
      saveMenu.add(this.saveLandFile);
      saveMenu.addSeparator();
      this.saveUndermapFile = new JMenuItem("Save Undermap");
      saveMenu.add(this.saveUndermapFile);
      saveMenu.addSeparator();
      this.saveUnderlandFile = new JMenuItem("Save Underland");
      saveMenu.add(this.saveUnderlandFile);
      saveMenu.addSeparator();
      this.saveWorldmapArea = new JMenuItem("Save Worldmap Area");
      saveMenu.add(this.saveWorldmapArea);
      this.file.add((JMenuItem)saveMenu);
      this.file.addSeparator();
      this.loadRegion = new JMenuItem("Load Region Data");
      this.file.add(this.loadRegion);
      this.file.addSeparator();
      this.exit = new JMenuItem("Exit");
      this.file.add(this.exit);
      this.settings = new JMenu("Settings");
      this.settings.getPopupMenu().setLightWeightPopupEnabled(false);
      this.add(this.settings);
      JMenu overlaySettings = new JMenu("Overlays");
      this.generalOverlays = new JMenuItem("General");
      overlaySettings.add(this.generalOverlays);
      overlaySettings.addSeparator();
      this.hoverOverlays = new JMenuItem("Hover");
      overlaySettings.add(this.hoverOverlays);
      this.settings.add((JMenuItem)overlaySettings);
      this.settings.addSeparator();
      JMenu replaceSettings = new JMenu("Replace");
      this.overlays = new JMenuItem("Overlays");
      replaceSettings.add(this.overlays);
      replaceSettings.addSeparator();
      this.underlays = new JMenuItem("Underlays");
      replaceSettings.add(this.underlays);
      replaceSettings.addSeparator();
      this.objects = new JMenuItem("Objects");
      replaceSettings.add(this.objects);
      this.settings.add((JMenuItem)replaceSettings);
      this.record = new JButton("Record", new ImageIcon("resources/images/record_icon.png"));
      this.add(this.record);
      this.setAction(
         this.openMenu,
         this.saveMapFile,
         this.saveLandFile,
         this.saveUndermapFile,
         this.saveUnderlandFile,
         this.saveWorldmapArea,
         this.loadRegion,
         this.exit,
         this.objects,
         this.overlays,
         this.underlays,
         this.generalOverlays,
         this.hoverOverlays,
         this.record
      );
   }

   private void setAction(AbstractButton... button) {
      for(AbstractButton b : button) {
         b.addActionListener(this);
      }
   }

   @Override
   public void actionPerformed(ActionEvent e) {
      String name = e.getActionCommand();
      if (name.equalsIgnoreCase("exit")) {
         System.exit(0);
      }

      if (name.equalsIgnoreCase("Menu")) {
         ((HomeMenu)RSMapperClient.homeMenu).showMenu(true);
      } else if (name.equalsIgnoreCase("Load Region Data")) {
         RSMapperClient.editor.loadRegionFromFile();
      } else if (name.equalsIgnoreCase("Save Map")) {
         EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               if (RSMapperClient.ERRORED_OUT) {
                  RSMapperClient.editor.mapEditor.packToCache(false);
               } else {
                  RSMapperClient.editor.mapEditor.PACK_MAP = true;
               }
            }
         });
      } else if (name.equalsIgnoreCase("Save Undermap")) {
         EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               if (RSMapperClient.ERRORED_OUT) {
                  RSMapperClient.editor.mapEditor.packToCache(true);
               } else {
                  RSMapperClient.editor.mapEditor.PACK_UNDERMAP = true;
               }
            }
         });
      } else if (name.equalsIgnoreCase("Save Land")) {
         EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               if (RSMapperClient.ERRORED_OUT) {
                  RSMapperClient.editor.objectEditor.packToCache(false);
               } else {
                  RSMapperClient.editor.objectEditor.PACK_LAND = true;
               }
            }
         });
      } else if (name.equalsIgnoreCase("Save Underland")) {
         EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
               if (RSMapperClient.ERRORED_OUT) {
                  RSMapperClient.editor.objectEditor.packToCache(true);
               } else {
                  RSMapperClient.editor.objectEditor.PACK_UNDERLAND = true;
               }
            }
         });
      } else if (name.equalsIgnoreCase("Save Worldmap Area")) {
         RSMapperClient.editor.worldmapEditor.packToCache("area");
      } else if (name.equalsIgnoreCase("General")) {
         RSMapperClient.settings.displayGeneralOverlaySettings();
      } else if (name.equalsIgnoreCase("Hover")) {
         RSMapperClient.settings.displayHoverOverlaySettings();
      } else if (name.equalsIgnoreCase("Overlays")) {
         RSMapperClient.settings.openReplaceTextureSettings(true);
      } else if (name.equalsIgnoreCase("Underlays")) {
         RSMapperClient.settings.openReplaceTextureSettings(false);
      } else if (name.equalsIgnoreCase("Objects")) {
         RSMapperClient.settings.openReplaceObjectsSettings();
      } else if (!name.equalsIgnoreCase("record") && !name.equalsIgnoreCase("recording..")) {
         System.out.println(name);
      } else {
         try {
            if (!Recorder.record) {
               int choice = JOptionPane.showOptionDialog(null, "Record entire editor?", "Choose Ratio", 0, 3, null, new Object[]{"Yes", "No"}, "No");
               if (choice == 0 || choice == 1) {
                  RSMapperClient.setFocusOnCanvas();
                  Recorder.record(choice == 0);
                  ((JButton)e.getSource()).setText("Recording..");
                  ((JButton)e.getSource()).setIcon(new ImageIcon("resources/images/stop_record_icon.png"));
               }
            } else {
               ((JButton)e.getSource()).setText("Record");
               ((JButton)e.getSource()).setIcon(new ImageIcon("resources/images/record_icon.png"));
               Recorder.makeVideo();
            }
         } catch (Exception var4) {
            var4.printStackTrace();
         }
      }

      RSMapperClient.setFocusOnCanvas();
   }

   private void openURL(String url) {
      try {
         Desktop.getDesktop().browse(new URI(url));
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }
}
