package org.rsmapper.networking.management.query.impl;

import org.rsmapper.networking.management.query.ServerQuery;
import org.rsmapper.networking.management.query.ServerQueryHandler;

public class ReloadQueriesQuery extends ServerQuery {
   public String[] getQueryListeners() {
      return new String[]{"rlq"};
   }

   public String getDescription() {
      return "Reloads the queries";
   }

   public String onRequest() {
      ServerQueryHandler.getServerQueries().clear();
      ServerQueryHandler.load();
      return "Loaded " + ServerQueryHandler.getServerQueries().size() + " queries...";
   }
}
