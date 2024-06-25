package org.rsmapper.networking.management.query.impl;

import java.util.Iterator;
import java.util.Map.Entry;
import org.rsmapper.networking.management.query.ServerQuery;
import org.rsmapper.networking.management.query.ServerQueryHandler;

public class CommandsQuery extends ServerQuery {
   public String[] getQueryListeners() {
      return new String[]{"commands"};
   }

   public String getDescription() {
      return "List all commands";
   }

   public String onRequest() {
      String string = new String();

      String result;
      for(Iterator it$ = ServerQueryHandler.getServerQueries().entrySet().iterator(); it$.hasNext(); string = string + result + "\n\t") {
         Entry<String, ServerQuery> entry = (Entry)it$.next();
         ServerQuery query = (ServerQuery)entry.getValue();
         String string1 = new String();

         for(int i = 0; i < query.getQueryListeners().length; ++i) {
            String cmd = query.getQueryListeners()[i];
            string1 = string1 + cmd + (i == query.getQueryListeners().length - 1 ? "" : ", ");
         }

         result = string1 + ":\t" + query.getDescription();
      }

      return string;
   }
}
