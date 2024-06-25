package org.rsmapper.networking.management.query;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.rsmapper.utilities.misc.FileClassLoader;

/**
 * Handles server queries by loading and processing them.
 */
public class ServerQueryHandler {

   // Map to hold server queries with their associated listeners
   private static final Map<String, ServerQuery> SERVER_QUERIES = new HashMap<>();

   /**
    * Loads all classes implementing ServerQuery from the specified package and registers them.
    */
   public static void load() {
      // Iterate through all classes in the specified package
      Iterator<?> classesIterator = FileClassLoader.getClassesInDirectory(ServerQueryHandler.class.getPackage().getName() + ".impl").iterator();

      // Register each class
      while (classesIterator.hasNext()) {
         Object clazz = classesIterator.next();

         try {
            ServerQuery skeleton = (ServerQuery) clazz;
            if (skeleton.getQueryListeners() == null) {
               throw new IllegalStateException("Could not register " + skeleton.getClass().getCanonicalName() + "; no parameters");
            }

            // Register each listener for the ServerQuery
            String[] listeners = skeleton.getQueryListeners();
            for (String parameter : listeners) {
               getServerQueries().put(parameter.toLowerCase(), skeleton);
            }
         } catch (Throwable e) {
            e.printStackTrace(); // Print the error stack trace if something goes wrong
         }
      }
   }

   /**
    * Handles the query string by finding the appropriate ServerQuery and executing it.
    *
    * @param query the query string
    * @return the result of the query execution
    */
   public static String handleQuery(String query) {
      // Split query into its components
      String[] split = query.split(" ");

      // Find the ServerQuery associated with the first part of the query
      ServerQuery serverQuery = getServerQueries().get(split[0].toLowerCase());

      // If no ServerQuery is found, return error message
      if (serverQuery == null) {
         return "No such query " + query + "...";
      }

      // Set query and execute
      serverQuery.setQuery(query);
      return serverQuery.onRequest();
   }

   /**
    * Gets the map of server queries.
    *
    * @return the map of server queries
    */
   public static Map<String, ServerQuery> getServerQueries() {
      return SERVER_QUERIES;
   }
}