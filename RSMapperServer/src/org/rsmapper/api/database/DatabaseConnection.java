package org.rsmapper.api.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class DatabaseConnection {
   protected DatabaseConfiguration configuration;
   private ConnectionPool<DatabaseConnection> pool;
   private long lastUse = System.currentTimeMillis();
   protected Connection connection = null;

   public DatabaseConnection(DatabaseConfiguration configuration) {
      this.configuration = configuration;
   }

   public DatabaseConnection(DatabaseConfiguration configuration, ConnectionPool<DatabaseConnection> pool) {
      this.configuration = configuration;
      this.pool = pool;
   }

   public abstract boolean connect();

   public static void loadDriver(String driverName) {
      try {
         Class.forName(driverName);
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public void close() {
      try {
         this.connection.close();
      } catch (SQLException var2) {
         var2.printStackTrace();
      }

   }

   public Statement createStatement() throws SQLException {
      if (this.connection == null) {
         throw new SQLException("Database not connected yet!");
      } else if (this.connection.isClosed()) {
         throw new SQLException("Connection closed!");
      } else {
         return this.connection.createStatement();
      }
   }

   public PreparedStatement prepareStatement(String string) throws SQLException {
      return this.connection.prepareStatement(string);
   }

   public Connection getConnection() {
      return this.connection;
   }

   public boolean isClosed() {
      try {
         return this.connection.isClosed();
      } catch (SQLException var2) {
         var2.printStackTrace();
         return true;
      }
   }

   public boolean isFresh() {
      return System.currentTimeMillis() - this.lastUse < 60000L && !this.isClosed();
   }

   public void returnConnection() {
      this.lastUse = System.currentTimeMillis();
      if (this.pool != null) {
         this.pool.returnConnection(this);
      }

   }

   public void setPool(ConnectionPool<DatabaseConnection> connectionPool) {
      this.pool = connectionPool;
   }
}
