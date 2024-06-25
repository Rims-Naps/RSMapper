package org.rsmapper.api.database.callback;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ThreadedSQLCallback {
   void queryComplete(ResultSet var1) throws SQLException;

   void queryError(SQLException var1);
}
