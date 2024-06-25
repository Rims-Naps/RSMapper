import com.rs.cache.Cache;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileView;
import javax.swing.table.DefaultTableModel;

public class ProjectExplorer extends JFrame {
   private static final long serialVersionUID = -7591122712778338489L;
   private JButton archiveButton;
   private JButton browseButton;
   private JLabel createdLabel;
   private JLabel createdText;
   private JButton deleteButton;
   private JButton loadButton;
   private JLabel modifiedLabel;
   private JLabel modifiedText;
   private JLabel projectLabel;
   private JTextField projectText;
   private JLabel regionsLabel;
   private JLabel regionsText;
   private JButton renameButton;

   public ProjectExplorer(Project project) {
      this.initComponents(project);
   }

   private void initComponents(Project project) {
      this.addWindowListener(new WindowAdapter() {
         @Override
         public void windowClosing(WindowEvent e) {
            ((HomeMenu)RSMapperClient.homeMenu).projectExplorer = null;
         }
      });
      this.projectLabel = new JLabel();
      this.projectText = new JTextField();
      this.browseButton = new JButton();
      this.createdLabel = new JLabel();
      this.createdText = new JLabel();
      this.modifiedLabel = new JLabel();
      this.modifiedText = new JLabel();
      this.regionsLabel = new JLabel();
      this.regionsText = new JLabel();
      this.renameButton = new JButton();
      this.deleteButton = new JButton();
      this.archiveButton = new JButton();
      this.loadButton = new JButton();
      this.setDefaultCloseOperation(2);
      this.setTitle("Project Explorer");
      this.getContentPane().setLayout(new GridBagLayout());
      this.projectLabel.setFont(new Font("Tahoma", 1, 11));
      this.projectLabel.setText("Project:");
      GridBagConstraints gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 0;
      gridBagConstraints.insets = new Insets(25, 20, 5, 4);
      this.getContentPane().add(this.projectLabel, gridBagConstraints);
      this.projectText.setEditable(false);
      this.projectText.setBackground(new Color(176, 175, 170));
      this.projectText.setFont(new Font("Tahoma", 1, 13));
      this.projectText.setForeground(new Color(40, 181, 237));
      this.projectText.setHorizontalAlignment(0);
      this.projectText.setPreferredSize(new Dimension(200, 26));
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 1;
      gridBagConstraints.gridwidth = 2;
      gridBagConstraints.fill = 2;
      gridBagConstraints.insets = new Insets(25, 0, 5, 0);
      this.getContentPane().add(this.projectText, gridBagConstraints);
      this.browseButton.setFont(new Font("Tahoma", 1, 11));
      this.browseButton.setText("Browse");
      this.browseButton.setPreferredSize(new Dimension(75, 26));
      this.browseButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            ProjectExplorer.this.browseButtonActionPerformed(evt);
         }
      });
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 3;
      gridBagConstraints.fill = 3;
      gridBagConstraints.anchor = 21;
      gridBagConstraints.insets = new Insets(25, 0, 5, 20);
      this.getContentPane().add(this.browseButton, gridBagConstraints);
      this.createdLabel.setFont(new Font("Tahoma", 1, 11));
      this.createdLabel.setText("Created:");
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 1;
      gridBagConstraints.gridy = 1;
      gridBagConstraints.insets = new Insets(15, 0, 0, 6);
      this.getContentPane().add(this.createdLabel, gridBagConstraints);
      this.createdText.setFont(new Font("Tahoma", 2, 11));
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 2;
      gridBagConstraints.gridy = 1;
      gridBagConstraints.fill = 2;
      gridBagConstraints.insets = new Insets(15, 0, 0, 0);
      this.getContentPane().add(this.createdText, gridBagConstraints);
      this.modifiedLabel.setFont(new Font("Tahoma", 1, 11));
      this.modifiedLabel.setText("Modified:");
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 1;
      gridBagConstraints.gridy = 2;
      gridBagConstraints.insets = new Insets(7, 0, 0, 6);
      this.getContentPane().add(this.modifiedLabel, gridBagConstraints);
      this.modifiedText.setFont(new Font("Tahoma", 2, 11));
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 2;
      gridBagConstraints.gridy = 2;
      gridBagConstraints.fill = 2;
      gridBagConstraints.insets = new Insets(7, 0, 0, 0);
      this.getContentPane().add(this.modifiedText, gridBagConstraints);
      this.regionsLabel.setFont(new Font("Tahoma", 1, 11));
      this.regionsLabel.setText("Regions:");
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 1;
      gridBagConstraints.gridy = 3;
      gridBagConstraints.insets = new Insets(7, 0, 0, 6);
      this.getContentPane().add(this.regionsLabel, gridBagConstraints);
      this.regionsText.setFont(new Font("Tahoma", 2, 11));
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 2;
      gridBagConstraints.gridy = 3;
      gridBagConstraints.fill = 2;
      gridBagConstraints.insets = new Insets(7, 0, 0, 0);
      this.getContentPane().add(this.regionsText, gridBagConstraints);
      this.renameButton.setText("Rename");
      this.renameButton.setPreferredSize(new Dimension(78, 28));
      this.renameButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            ProjectExplorer.this.renameButtonActionPerformed(evt);
         }
      });
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 2;
      gridBagConstraints.gridy = 4;
      gridBagConstraints.insets = new Insets(30, 45, 25, 0);
      this.getContentPane().add(this.renameButton, gridBagConstraints);
      this.deleteButton.setText("Delete");
      this.deleteButton.setPreferredSize(new Dimension(78, 28));
      this.deleteButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            ProjectExplorer.this.deleteButtonActionPerformed(evt);
         }
      });
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 0;
      gridBagConstraints.gridy = 4;
      gridBagConstraints.gridwidth = 2;
      gridBagConstraints.insets = new Insets(30, 19, 25, 22);
      this.getContentPane().add(this.deleteButton, gridBagConstraints);
      this.archiveButton.setText("Archive");
      this.archiveButton.setPreferredSize(new Dimension(78, 28));
      this.archiveButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            ProjectExplorer.this.archiveButtonActionPerformed(evt);
         }
      });
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 1;
      gridBagConstraints.gridy = 4;
      gridBagConstraints.gridwidth = 2;
      gridBagConstraints.insets = new Insets(30, 0, 25, 56);
      this.getContentPane().add(this.archiveButton, gridBagConstraints);
      this.loadButton.setFont(new Font("Tahoma", 1, 11));
      this.loadButton.setText("Load");
      this.loadButton.setPreferredSize(new Dimension(78, 28));
      this.loadButton.addActionListener(new ActionListener() {
         @Override
         public void actionPerformed(ActionEvent evt) {
            ProjectExplorer.this.loadButtonActionPerformed(evt);
         }
      });
      gridBagConstraints = new GridBagConstraints();
      gridBagConstraints.gridx = 2;
      gridBagConstraints.gridy = 4;
      gridBagConstraints.gridwidth = 2;
      gridBagConstraints.ipadx = 7;
      gridBagConstraints.anchor = 17;
      gridBagConstraints.insets = new Insets(30, 134, 25, 0);
      this.getContentPane().add(this.loadButton, gridBagConstraints);
      this.pack();
      this.setLocationRelativeTo(null);
      this.setFields(project);
   }

   public void setFields(Project project) {
      if (project != null) {
         this.projectText.setText(project.name);
         String pattern = "MMM dd, yyyy - h:mma";
         DateFormat df = new SimpleDateFormat(pattern);
         String monthDayYear = df.format(project.dateCreated.getTime()).split("-")[0];
         String hoursSeconds = df.format(project.dateCreated.getTime()).split("-")[1];
         String dateString = monthDayYear + " at " + hoursSeconds;
         this.createdText.setText(dateString);
         monthDayYear = df.format(project.dateModified.getTime()).split("-")[0];
         hoursSeconds = df.format(project.dateModified.getTime()).split("-")[1];
         dateString = monthDayYear + " at " + hoursSeconds;
         this.modifiedText.setText(dateString);
         this.regionsText.setText("" + project.quickLoads.size());
      }
   }

   private void browseButtonActionPerformed(ActionEvent evt) {
      if (!RSMapperClient.homeMenu.isVisible()) {
         ((HomeMenu)RSMapperClient.homeMenu).projectExplorer = null;
         this.dispose();
      } else {
         final File dirToLock = new File("data/projects/");
         JFileChooser chooser = new JFileChooser() {
            private static final long serialVersionUID = 7623141395023774685L;

            @Override
            public File getCurrentDirectory() {
               File dir = super.getCurrentDirectory();
               if (dir != null) {
                  String name = dir.toString().split("\\\\")[dir.toString().split("\\\\").length - 1];
                  return name.equals("projects") ? new File("data/projects/") : new File(name);
               } else {
                  return new File("data/projects/");
               }
            }

            @Override
            public File getSelectedFile() {
               return super.getSelectedFile() != null ? new File("data/projects/" + super.getSelectedFile().getName()) : new File("data/projects/");
            }

            @Override
            public String getName(File f) {
               return f.toString().split("\\\\")[f.toString().split("\\\\").length - 1];
            }
         };
         chooser.setCurrentDirectory(dirToLock);
         chooser.setDialogTitle("Select a project");
         chooser.setFileSelectionMode(1);
         chooser.setAcceptAllFileFilterUsed(false);
         chooser.setFileView(new FileView() {
            @Override
            public Boolean isTraversable(File f) {
               return f.isDirectory() && f.toString().contains(dirToLock.toString()) ? true : false;
            }
         });
         int returnValue = chooser.showDialog(null, "Select");
         if (returnValue == 0) {
            if (!RSMapperClient.homeMenu.isVisible()) {
               ((HomeMenu)RSMapperClient.homeMenu).projectExplorer = null;
               this.dispose();
            } else {
               File folder = chooser.getSelectedFile();

               try {
                  String name = folder.getName();
                  if (!name.equalsIgnoreCase("projects") && name.length() > 0) {
                     if (!name.equalsIgnoreCase("archived")) {
                        this.setFields(HomeMenu.loadProjectInfo(name));
                     } else {
                        JOptionPane.showMessageDialog(null, "The 'Archived' folder is for projects that have been archived.", "ERROR", 0);
                     }
                  }
               } catch (Exception var7) {
                  var7.printStackTrace();
               }
            }
         }
      }
   }

   private void renameButtonActionPerformed(ActionEvent evt) {
      if (!RSMapperClient.homeMenu.isVisible()) {
         ((HomeMenu)RSMapperClient.homeMenu).projectExplorer = null;
         this.dispose();
      } else if (!this.projectText.getText().isEmpty()) {
         String name = this.projectText.getText().trim();
         if (name.length() > 0 && !name.equals("Workspace")) {
            Project project = HomeMenu.loadProjectInfo(name);
            if (project == null) {
               JOptionPane.showMessageDialog(null, "project is null", "ERROR", 0);
            } else {
               JPanel al = new JPanel();
               al.setLayout(null);
               al.setSize(130, 50);
               al.setPreferredSize(new Dimension(130, 50));
               JTextField projectName = new JTextField(name);
               projectName.setBounds(10, 10, 220, 32);
               projectName.setHorizontalAlignment(0);
               al.add(projectName);
               int choice = JOptionPane.showOptionDialog(null, al, "Enter a new name", 0, -1, null, new Object[]{"Rename", "Cancel"}, "Cancel");
               if (choice == 0) {
                  File mainFolder = new File("data/projects/");
                  String newName = projectName.getText().trim().replaceAll("[^a-zA-Z0-9\\.\\-]", "_");
                  if (newName == null || newName.length() <= 0) {
                     return;
                  }

                  boolean isCurrentProject = name.equals(RSMapperClient.project.name);
                  File oldProjectFolder = new File(mainFolder.toString() + "/" + name + "/");
                  if (!oldProjectFolder.exists()) {
                     return;
                  }

                  File newProjectFolder = new File(mainFolder.toString() + "/" + newName + "/");
                  if (newProjectFolder.exists()) {
                     if (!newName.equals(name)) {
                        JOptionPane.showMessageDialog(null, "Project with name \"" + newName + "\" already exists", "ERROR", 0);
                     }

                     return;
                  }

                  oldProjectFolder.renameTo(newProjectFolder);
                  if (isCurrentProject) {
                     RSMapperClient.project.name = newName;
                     RSMapperClient.project.setDateModified();
                     HomeMenu.writeProjectInfo(newName, RSMapperClient.project);
                     this.setFields(RSMapperClient.project);
                     ((HomeMenu)RSMapperClient.homeMenu).projectLabel.setText("<html>Project<font color='#28b5ed'> " + newName + "</font> Maps</html>");
                  } else {
                     project.name = newName;
                     project.setDateModified();
                     HomeMenu.writeProjectInfo(newName, project);
                     this.setFields(project);
                  }
               }
            }
         } else {
            if (name.length() > 0) {
               JOptionPane.showMessageDialog(null, "You cannot rename the workspace", "ERROR", 0);
            }
         }
      }
   }

   private void deleteButtonActionPerformed(ActionEvent evt) {
      if (!RSMapperClient.homeMenu.isVisible()) {
         ((HomeMenu)RSMapperClient.homeMenu).projectExplorer = null;
         this.dispose();
      } else if (!this.projectText.getText().isEmpty()) {
         String name = this.projectText.getText().trim();
         if (name.length() > 0 && !name.equals("Workspace")) {
            Project project = HomeMenu.loadProjectInfo(name);
            if (project == null) {
               JOptionPane.showMessageDialog(null, "project is null", "ERROR", 0);
            } else {
               File projectFolder = new File("data/projects/" + name + "/");
               if (!projectFolder.exists()) {
                  JOptionPane.showMessageDialog(null, "Project folder " + name + " could not be found", "ERROR", 0);
               } else {
                  int delete = JOptionPane.showOptionDialog(
                     null, "This cannot be undone!", "Are you sure?", 0, 2, null, new Object[]{"Yes", "Cancel"}, "Cancel"
                  );
                  if (delete == 0) {
                     File[] var9;
                     for(File f : var9 = projectFolder.listFiles()) {
                        f.delete();
                     }

                     projectFolder.delete();
                     JOptionPane.showMessageDialog(null, "Deleted project " + name, "Project Deleted", 1);
                     if (RSMapperClient.project.name.equals(name) && !name.equalsIgnoreCase("Workspace")) {
                        this.loadProject(HomeMenu.loadProjectInfo("Workspace"), true, true);
                     }

                     this.setFields(RSMapperClient.project);
                  }
               }
            }
         } else {
            if (name.length() > 0) {
               JOptionPane.showMessageDialog(null, "You cannot delete the workspace", "ERROR", 0);
            }
         }
      }
   }

   private void archiveButtonActionPerformed(ActionEvent evt) {
      if (!RSMapperClient.homeMenu.isVisible()) {
         ((HomeMenu)RSMapperClient.homeMenu).projectExplorer = null;
         this.dispose();
      } else if (!this.projectText.getText().isEmpty()) {
         String name = this.projectText.getText().trim();
         if (name.length() > 0) {
            if (name.equalsIgnoreCase("Workspace")) {
               JOptionPane.showMessageDialog(null, "You cannot archive the workspace.", "ERROR", 0);
            } else if (name.equalsIgnoreCase("Archived")) {
               JOptionPane.showMessageDialog(null, "You cannot archive the archive.", "ERROR", 0);
            } else {
               Project project = HomeMenu.loadProjectInfo(name);
               if (project != null) {
                  File projectFolder = new File("data/projects/" + name);
                  File destination = new File("data/projects/Archived/" + name);
                  if (!destination.exists()) {
                     destination.mkdirs();
                  }

                  if (new File(projectFolder.toString() + "/project.info").renameTo(new File(destination.toString() + "/project.info"))) {
                     if (projectFolder.listFiles().length == 0) {
                        projectFolder.delete();
                     }

                     JOptionPane.showMessageDialog(null, name + " has been archived. (NOT FULLY. FUCNTIONALITY UNFINISHED)", "ERROR", 0);
                     if (name.equals(RSMapperClient.project.name)) {
                        this.loadProject(HomeMenu.loadProjectInfo("Workspace"), true, true);
                     } else {
                        ((HomeMenu)RSMapperClient.homeMenu).projectExplorer = null;
                        this.dispose();
                     }
                  } else {
                     System.out.println("Faied");
                  }
               } else {
                  JOptionPane.showMessageDialog(null, "project is null", "ERROR", 0);
               }
            }
         }
      }
   }

   private void loadButtonActionPerformed(ActionEvent evt) {
      if (!RSMapperClient.homeMenu.isVisible()) {
         ((HomeMenu)RSMapperClient.homeMenu).projectExplorer = null;
         this.dispose();
      } else if (!this.projectText.getText().isEmpty()) {
         String name = this.projectText.getText().trim();
         if (name.length() > 0 && !name.equals(RSMapperClient.project.name)) {
            this.loadProject(HomeMenu.loadProjectInfo(name), true, true);
         } else {
            ((HomeMenu)RSMapperClient.homeMenu).projectExplorer = null;
            this.dispose();
         }
      }
   }

   public void loadProject(Project project, boolean clearTable, boolean refreshTable) {
      if (project == null) {
         JOptionPane.showMessageDialog(null, "project is null", "ERROR", 0);
      } else {
         RSMapperClient.project = project;
         DefaultTableModel dtm = (DefaultTableModel)((HomeMenu)RSMapperClient.homeMenu).projectMapsTable.getModel();
         if (clearTable) {
            dtm.setRowCount(0);
         }

         if (refreshTable && RSMapperClient.project.quickLoads != null) {
            for(int count = 0; count < RSMapperClient.project.quickLoads.size(); ++count) {
               int reg = project.getRegionAtIndex(count);
               int mapArchive = Cache.STORE.getIndexes()[5].getArchiveId("m" + Utils.getLocalX(reg) + "_" + Utils.getLocalY(reg));
               int landArchive = Cache.STORE.getIndexes()[5].getArchiveId("l" + Utils.getLocalX(reg) + "_" + Utils.getLocalY(reg));
               int undermapArchive = Cache.STORE.getIndexes()[5].getArchiveId("um" + Utils.getLocalX(reg) + "_" + Utils.getLocalY(reg));
               int underlandArchive = Cache.STORE.getIndexes()[5].getArchiveId("ul" + Utils.getLocalX(reg) + "_" + Utils.getLocalY(reg));
               if (mapArchive != -1) {
                  Object[] r = new Object[6];
                  r[0] = reg;
                  r[1] = project.getNoteAtIndex(RSMapperClient.project.getIndexOfQuickLoad(new Object[]{r[0], ""}, false));
                  r[2] = 'Y';
                  r[3] = Character.valueOf((char)(landArchive == -1 ? 'N' : 'Y'));
                  r[4] = Character.valueOf((char)(undermapArchive == -1 ? 'N' : 'Y'));
                  r[5] = Character.valueOf((char)(underlandArchive == -1 ? 'N' : 'Y'));
                  dtm.addRow(r);
               }

               if (((HomeMenu)RSMapperClient.homeMenu).selectedRegion == reg) {
                  ((HomeMenu)RSMapperClient.homeMenu).addRemoveProjectButton.setText("Remove from Project");
                  ((HomeMenu)RSMapperClient.homeMenu).addRemoveProjectButton.setIcon(new ImageIcon("resources/images/red_star_icon.png"));
               }
            }

            ((HomeMenu)RSMapperClient.homeMenu).projectMapsTable.setModel(dtm);
            ((HomeMenu)RSMapperClient.homeMenu).projectMapsTable.validate();
            ((HomeMenu)RSMapperClient.homeMenu).projectMapsTable.repaint();
         }

         ((HomeMenu)RSMapperClient.homeMenu).projectLabel.setText("<html>Project<font color='#28b5ed'> " + project.name + "</font> Maps</html>");
         ((HomeMenu)RSMapperClient.homeMenu).projectExplorer = null;
         this.dispose();
      }
   }
}
