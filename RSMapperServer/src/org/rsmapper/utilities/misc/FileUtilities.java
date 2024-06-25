package org.rsmapper.utilities.misc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class FileUtilities {
   public static final int BUFFER = 1024;

   /**
    * Checks if a file exists at the given path.
    *
    * @param name the file path to check
    * @return true if the file exists, false otherwise
    */
   public static boolean exists(String name) {
      File file = new File(name);
      return file.exists();
   }

   /**
    * Reads the content of a file into a ByteBuffer.
    *
    * @param name the file path
    * @return ByteBuffer with the file content, or null if the file does not exist
    * @throws IOException if an I/O error occurs
    */
   public static ByteBuffer fileBuffer(String name) throws IOException {
      File file = new File(name);
      if (!file.exists()) {
         return null;
      } else {
         FileInputStream in = new FileInputStream(name);
         byte[] data = new byte[1024];

         try {
            ByteBuffer buffer = ByteBuffer.allocate(in.available() + 1);

            int read;
            while((read = in.read(data, 0, 1024)) != -1) {
               buffer.put(data, 0, read);
            }

            buffer.flip();
            ByteBuffer var7 = buffer;
            return var7;
         } finally {
            if (in != null) {
               in.close();
            }

            in = null;
         }
      }
   }

   /**
    * Writes the content of a ByteBuffer to a file.
    *
    * @param name the file path
    * @param buffer the ByteBuffer containing the data to write
    * @throws IOException if an I/O error occurs
    */
   public static void writeBufferToFile(String name, ByteBuffer buffer) throws IOException {
      File file = new File(name);
      if (!file.exists()) {
         file.createNewFile();
      }

      FileOutputStream out = new FileOutputStream(name);
      out.write(buffer.array(), 0, buffer.remaining());
      out.flush();
      out.close();
   }

   /**
    * Reads the lines of a text file into a List<String>.
    *
    * @param file the file path
    * @return a List<String> containing the lines of the file
    */
   public static List<String> getFileText(String file) {
      ArrayList text = new ArrayList();

      try {
         BufferedReader reader = new BufferedReader(new FileReader(file));

         while(true) {
            String line;
            do {
               do {
                  do {
                     if ((line = reader.readLine()) == null) {
                        reader.close();
                        return text;
                     }
                  } while(line.equals(""));
               } while(line.equals(" "));
            } while(line.length() >= 2 && line.toCharArray()[0] == '/' && line.toCharArray()[1] == '/');

            text.add(line);
         }
      } catch (Exception var4) {
         var4.printStackTrace();
         return text;
      }
   }

   /**
    * Fetches the source code of a web page.
    *
    * @param page the URL of the web page
    * @return an ArrayList<String> containing the lines of the web page source
    * @throws IOException if an I/O error occurs
    */
   public static ArrayList<String> getPageSource(String page) throws IOException {
      ArrayList<String> text = new ArrayList();
      URL url = new URL(page);
      HttpURLConnection connection = (HttpURLConnection)url.openConnection();
      connection.setRequestMethod("GET");
      connection.setRequestProperty("User-Agent", "Mozilla Firefox");
      connection.setDoOutput(true);
      connection.setDoInput(true);
      InputStream input;
      if (connection.getResponseCode() >= 400) {
         input = connection.getErrorStream();
      } else {
         input = connection.getInputStream();
      }

      BufferedReader reader = new BufferedReader(new InputStreamReader(input));

      String line;
      while((line = reader.readLine()) != null) {
         text.add(line);
      }

      reader.close();
      return text;
   }

   /**
    * Reads a file from the specified directory into a LinkedList<String>.
    *
    * @param directory the directory path of the file
    * @return a LinkedList<String> containing the lines of the file
    * @throws IOException if an I/O error occurs
    */
   public static LinkedList<String> readFile(String directory) throws IOException {
      LinkedList<String> fileLines = new LinkedList();
      BufferedReader reader = null;

      try {
         reader = new BufferedReader(new FileReader(directory));

         String string;
         while((string = reader.readLine()) != null) {
            fileLines.add(string);
         }
      } finally {
         if (reader != null) {
            reader.close();
            reader = null;
         }

      }

      return fileLines;
   }
}