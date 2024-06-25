package org;

import com.dropbox.core.v2.DbxClientV2;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.ExecutionException;
import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.HTML.Tag;
import org.rsmapper.Constants;
import org.rsmapper.engine.CoresManager;
import org.rsmapper.engine.game.GameLoader;
import org.rsmapper.networking.ServerChannelHandler;
import org.rsmapper.utilities.misc.Stopwatch;

/**
 * Main class for initializing and managing the RSMapper Server application.
 */
public class RsMapperServer extends JFrame {

    private static final long serialVersionUID = -4839712424564486491L;

    // Main panel to hold the client GUI components
    public static JPanel client_panel;
    // Text pane for output messages
    private static JEditorPane output;
    // Dropbox client (placeholder, as it's set to null)
    public static final DbxClientV2 DBXCLIENT = null;
    // Holds the server startup time in milliseconds
    public static long STARTUP_TIME = -1L;
    // Stopwatch to measure startup time
    public static final Stopwatch STOPWATCH = Stopwatch.start();

    /**
     * Main method to start the RSMapper server.
     */
    public static void main(String[] args) {
        try {
            new RsMapperServer();
        } catch (Exception e) {
            print(e.toString());
            e.printStackTrace();
        }
    }

    /**
     * Initializes the RSMapper server application.
     */
    public RsMapperServer() {
        try {
            // Set frame properties
            this.setTitle("RSMapper Server");
            this.setLayout(new BorderLayout());
            this.setFocusable(true);

            // Initialize the client panel
            client_panel = new JPanel();
            client_panel.setLayout((LayoutManager) null);
            client_panel.setPreferredSize(new Dimension(480, 200));
            client_panel.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 3));
            client_panel.setFocusable(true);
            client_panel.setRequestFocusEnabled(true);

            // Create and add title label
            JLabel titleLabel = this.createTitleLabel();
            output = this.createOutputTextPane();
            output.setBounds(0, 30, 480, 170);

            // Scroll pane for the output text area
            JScrollPane outputScrollPane = new JScrollPane(output, 22, 32);
            outputScrollPane.setBounds(4, 30, 483, 177);
            client_panel.add(titleLabel);
            client_panel.add(outputScrollPane);
            this.getContentPane().add(client_panel, "Center");

            // Finalize frame properties
            this.setVisible(true);
            this.setResizable(false);
            this.pack();
            this.setLocationRelativeTo((Component) null);
            this.setDefaultCloseOperation(0);
            this.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent we) {
                    RsMapperServer.shutdown();
                    System.exit(-1);
                }
            });

            // Load the server and measure startup time
            print("Loading the RSMapper Server...");
            GameLoader.get().getBackgroundLoader().waitForPendingTasks().shutdown();
            print("...Server Successfully Loaded (<font style=\"color:green\">" + STOPWATCH.elapsed() + "</font> ms).");
            System.out.println("...Server Successfully Loaded. (" + STOPWATCH.elapsed() + " ms)");
            STARTUP_TIME = System.currentTimeMillis();
        } catch (ExecutionException e) {
            print("...<font style=\"color:red\">The server failed to load!</font>");
            e.printStackTrace();
        }
    }

    /**
     * Creates a label with the server title and information.
     * @return JLabel with title and info.
     */
    public JLabel createTitleLabel() {
        JLabel title = new JLabel("<html>This <u>MUST</u> be opened <u>first</u> and <u>remain open until the client is closed.</u></html>");
        title.setBounds(0, 0, 490, 30);
        title.setHorizontalAlignment(0);
        title.setBorder(BorderFactory.createLineBorder(new Color(102, 102, 102), 3));
        title.setOpaque(true);
        title.setBackground(new Color(220, 220, 220));
        return title;
    }

    /**
     * Creates a read-only HTML formatted text pane for output messages.
     * @return JEditorPane configured for output.
     */
    public JEditorPane createOutputTextPane() {
        JEditorPane outputArea = new JEditorPane();
        outputArea.setContentType("text/html");
        outputArea.setEditable(false);
        return outputArea;
    }

    /**
     * Logs a message to the output text pane, with optional class and line number if debugging.
     * @param message the message to log.
     */
    public static void print(String message) {
        Throwable throwable = new Throwable();
        String name = throwable.getStackTrace()[2].getFileName().replaceAll(".java", "");
        String line = String.valueOf(throwable.getStackTrace()[2].getLineNumber());
        log(Constants.DEBUG ? name + ":" + line : "", message);
    }

    /**
     * Logs a boolean message to the output text pane.
     * @param message the boolean message to log.
     */
    public static void print(boolean message) {
        Throwable throwable = new Throwable();
        String name = throwable.getStackTrace()[2].getFileName().replaceAll(".java", "");
        String line = String.valueOf(throwable.getStackTrace()[2].getLineNumber());
        log(Constants.DEBUG ? name + ":" + line : "", "" + message);
    }

    /**
     * Logs an integer message to the output text pane.
     * @param message the integer message to log.
     */
    public static void print(int message) {
        Throwable throwable = new Throwable();
        String name = throwable.getStackTrace()[2].getFileName().replaceAll(".java", "");
        String line = String.valueOf(throwable.getStackTrace()[2].getLineNumber());
        log(Constants.DEBUG ? name + ":" + line : "", "" + message);
    }

    /**
     * Helper method to log messages to the output text pane.
     * @param className optional class name and line number for debug mode.
     * @param text the message text to log.
     */
    private static void log(String className, String text) {
        HTMLDocument doc = (HTMLDocument) output.getDocument();
        HTMLEditorKit editorKit = (HTMLEditorKit) output.getEditorKit();

        try {
            editorKit.insertHTML(doc, doc.getLength(), "<b>" + (Constants.DEBUG ? "[" + className.replace("RsMapperServer", "Server").replace("GameLoader", "Loader") + "]" : "") + "[" + getDate() + "]</b> " + text + "\n", 0, 0, (Tag) null);
            output.setCaretPosition(output.getDocument().getLength());
        } catch (IOException | BadLocationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the current date and time formatted for logging.
     * @return formatted date and time string.
     */
    private static String getDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("America/Toronto"));
        Date date = cal.getTime();
        int hours = date.getHours();
        String formatted = (hours > 12 ? hours - 12 : hours) + ":" + date.getMinutes() + ":" + date.getSeconds() + " " + (hours > 12 ? "PM" : "AM");
        return formatted;
    }

    /**
     * Shuts down the server and logs the shutdown message.
     */
    public static void shutdown() {
        print("Shutting down...");
        closeServices();
        System.out.println("Shutting down...");
    }

    /**
     * Closes all services associated with the server.
     */
    public static void closeServices() {
        ServerChannelHandler.shutdown();
        CoresManager.shutdown();
    }

    /**
     * Restarts the server application.
     */
    public static void restart() {
        closeServices();
        System.exit(-1);
    }
}