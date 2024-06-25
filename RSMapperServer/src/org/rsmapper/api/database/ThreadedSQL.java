package org.rsmapper.api.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.rsmapper.api.database.callback.ThreadedSQLCallback;

public class ThreadedSQL {
   private ExecutorService service;
   private ConnectionPool<DatabaseConnection> pool;

   public ThreadedSQL(DatabaseConfiguration configuration) {
      this.service = Executors.newCachedThreadPool();
      this.pool = new ConnectionPool(configuration, 10);
   }

   public ThreadedSQL(DatabaseConfiguration configuration, int threads) {
      this(configuration, threads, threads);
   }

   public ThreadedSQL(DatabaseConfiguration configuration, int threads, int connections) {
      this.service = Executors.newFixedThreadPool(threads);
      this.pool = new ConnectionPool(configuration, threads);
   }

   public void executeQuery(final PreparedStatement statement, final ThreadedSQLCallback callback) {
      this.service.execute(new Runnable() {
         public void run() {
            try {
               ThreadedSQL.this.query(statement, callback);
            } catch (SQLException var2) {
               callback.queryError(var2);
            }

         }
      });
   }

   public void executeQuery(final String query, final ThreadedSQLCallback callback) {
      this.service.execute(new Runnable() {
         public void run() {
            try {
               ThreadedSQL.this.query(query, callback);
            } catch (SQLException var2) {
               callback.queryError(var2);
            }

         }
      });
   }

   public PreparedStatement prepareStatement(String string) throws SQLException {
      DatabaseConnection conn = this.pool.nextFree();
      Connection c = conn.getConnection();

      PreparedStatement var5;
      try {
         var5 = c.prepareStatement(string);
      } finally {
         conn.returnConnection();
      }

      return var5;
   }

   private void query(PreparedStatement statement, ThreadedSQLCallback callback) throws SQLException {
      statement.execute();
      ResultSet result = statement.getResultSet();

      try {
         callback.queryComplete(result);
      } finally {
         result.close();
      }

   }

   private void query(String query, ThreadedSQLCallback callback) throws SQLException {
      DatabaseConnection conn = this.pool.nextFree();
      Connection c = conn.getConnection();
      Statement statement = c.createStatement();
      statement.execute(query);
      ResultSet result = statement.getResultSet();

      try {
         callback.queryComplete(result);
      } finally {
         result.close();
         conn.returnConnection();
      }

   }

   public ConnectionPool<DatabaseConnection> getConnectionPool() {
      return this.pool;
   }
}
