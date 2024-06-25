package org.rsmapper.utilities.misc;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class FileClassLoader {

   /**
    * Loads all classes from a specified directory.
    *
    * @param directory The directory to search for class files.
    * @return A list of instantiated objects for each class found in the directory.
    */
   public static List<Object> getClassesInDirectory(String directory) {
      // List to hold all the instantiated classes
      List<Object> classes = new ArrayList<>();

      // Convert the directory path to match file system format and list the files
      File[] files = new File("./bin/" + directory.replace(".", "/")).listFiles();

      // Loop through all the files in the directory
      for (File file : files) {
         // Only consider files that are not inner classes and not 'desktop.ini'
         if (!file.getName().contains("$") && !file.getName().contains("desktop.ini")) {
            try {
               // Load and instantiate the class
               Object objectEvent = Class.forName(directory + "." + file.getName().replace(".class", "")).newInstance();
               // Add the instantiated class to the list
               classes.add(objectEvent);
            } catch (IllegalAccessException | ClassNotFoundException | InstantiationException e) {
               e.printStackTrace();
            }
         }
      }

      // Return the list of instantiated classes
      return classes;
   }
}