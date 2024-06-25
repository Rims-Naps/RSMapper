package org.rsmapper.networking.management.query;

/**
 * The ServerQuery class represents a framework for server query operations.
 */
public abstract class ServerQuery {
   private String query; // Stores the query string

   /**
    * Gets the listeners associated with the query.
    *
    * @return an array of query listener identifiers
    */
   public abstract String[] getQueryListeners();

   /**
    * Gets the description of the server query.
    *
    * @return a description of the query
    */
   public abstract String getDescription();

   /**
    * Handles the query request and returns the result.
    *
    * @return result of handling the query request
    */
   public abstract String onRequest();

   /**
    * Gets the query string.
    *
    * @return the current query string
    */
   public String getQuery() {
      return this.query;
   }

   /**
    * Sets a new query string.
    *
    * @param query the new query string to set
    */
   public void setQuery(String query) {
      this.query = query;
   }
}