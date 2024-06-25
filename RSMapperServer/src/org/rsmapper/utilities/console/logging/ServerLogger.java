package org.rsmapper.utilities.console.logging;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.RsMapperServer;

/**
 * Custom logger to capture server logs with detailed information such as the source class, line number,
 * and timestamp. Extends PrintStream to override print methods for different types of messages.
 */
public class ServerLogger extends PrintStream {

    /**
     * Constructs a new ServerLogger with the specified OutputStream.
     *
     * @param out the output stream to receive log messages
     */
    public ServerLogger(OutputStream out) {
        super(out);
    }

    /**
     * Overrides the print method for boolean messages to include additional logging details.
     *
     * @param message the boolean message to log
     */
    public void print(boolean message) {
        Throwable throwable = new Throwable();
        String name = throwable.getStackTrace()[2].getFileName().replaceAll(".java", "");
        String line = String.valueOf(throwable.getStackTrace()[2].getLineNumber());
        this.log(name + ":" + line, "" + message);
    }

    /**
     * Overrides the print method for integer messages to include additional logging details.
     *
     * @param message the integer message to log
     */
    public void print(int message) {
        Throwable throwable = new Throwable();
        String name = throwable.getStackTrace()[2].getFileName().replaceAll(".java", "");
        String line = String.valueOf(throwable.getStackTrace()[2].getLineNumber());
        this.log(name + ":" + line, "" + message);
    }

    /**
     * Overrides the print method for string messages to include additional logging details.
     *
     * @param message the string message to log
     */
    public void print(String message) {
        Throwable throwable = new Throwable();
        String name = throwable.getStackTrace()[2].getFileName().replaceAll(".java", "");
        String line = String.valueOf(throwable.getStackTrace()[2].getLineNumber());
        this.log(name + ":" + line, message);
    }

    /**
     * Logs the message with class name, line number, and timestamp.
     *
     * @param className the name of the class where the log originated
     * @param text the message to log
     */
    private void log(String className, String text) {
        super.print("[" + className + "][" + this.getDate() + "]" + text);
        RsMapperServer.print("[" + className + "][" + this.getDate() + "]" + text);
    }

    /**
     * Returns the current date and time in the format MM/dd/yyyy, HH:mm:ss a.
     *
     * @return the formatted current date and time
     */
    private String getDate() {
        Calendar cal = Calendar.getInstance();
        cal.setTimeZone(TimeZone.getTimeZone("America/Toronto"));
        Date date = cal.getTime();
        String formatted = new String(date.getMonth() + "/" + date.getDay() + "/" + cal.get(1));
        int hours = date.getHours();
        formatted = formatted + ", " + (hours > 12 ? hours - 12 : hours) + ":" + date.getMinutes() + ":" + date.getSeconds() + " " + (hours > 12 ? "PM" : "AM");
        return formatted;
    }
}