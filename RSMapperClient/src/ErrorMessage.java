import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class ErrorMessage extends JFrame {
   private JButton copyButton;
   private JLabel informationLabel;
   private JScrollPane messageScroll;
   private JTextArea errorMessage;

   public ErrorMessage(String message) {
      this.initComponents(message);
   }

   private void initComponents(String message) {
      try {
         if (message == null || message.trim().isEmpty()) {
            this.dispose();
            return;
         }

         this.copyButton = new JButton();
         this.messageScroll = new JScrollPane();
         this.errorMessage = new JTextArea(message);
         this.informationLabel = new JLabel();
         this.setDefaultCloseOperation(2);
         this.setTitle("Oops, an error occurred!");
         this.copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               StringSelection string = new StringSelection(ErrorMessage.this.errorMessage.getText());
               Toolkit.getDefaultToolkit().getSystemClipboard().setContents(string, null);
            }
         });
         this.copyButton.setText("Copy to Clipboard");
         this.errorMessage.setEditable(false);
         this.errorMessage.setColumns(20);
         this.errorMessage.setLineWrap(true);
         this.errorMessage.setRows(5);
         this.messageScroll.setViewportView(this.errorMessage);
         this.informationLabel
            .setText(
               "Oh no, an error has occurred! If the editor canvas is no longer reponsive and you haven't saved your work, you can still do so now before restarting!"
            );
         GroupLayout layout = new GroupLayout(this.getContentPane());
         this.getContentPane().setLayout(layout);
         layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
               .addGroup(
                  Alignment.TRAILING,
                  layout.createSequentialGroup()
                     .addGap(18, 18, 18)
                     .addGroup(layout.createParallelGroup(Alignment.TRAILING).addComponent(this.messageScroll).addComponent(this.copyButton, -1, -1, 32767))
                     .addContainerGap()
               )
               .addGroup(layout.createSequentialGroup().addGap(50, 50, 50).addComponent(this.informationLabel).addContainerGap(74, 32767))
         );
         layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
               .addGroup(
                  Alignment.TRAILING,
                  layout.createSequentialGroup()
                     .addGap(20, 20, 20)
                     .addComponent(this.informationLabel)
                     .addGap(18, 18, 18)
                     .addComponent(this.messageScroll, -1, 245, 32767)
                     .addPreferredGap(ComponentPlacement.RELATED)
                     .addComponent(this.copyButton)
                     .addContainerGap()
               )
         );
         this.pack();
         this.setVisible(true);
      } catch (Exception var3) {
         var3.printStackTrace();
      }
   }

   public static void main(String[] args) {
      new ErrorMessage("    f");
   }
}
