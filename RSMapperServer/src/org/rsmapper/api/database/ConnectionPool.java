package org.rsmapper.api.database;

import java.sql.SQLException;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Manages a pool of database connections for efficient reuse.
 *
 * @param <T> the type of DatabaseConnection
 */
public class ConnectionPool<T extends DatabaseConnection> {
   private DatabaseConfiguration configuration;
   private int maxConnections;
   private int currentConnections;
   private Queue<DatabaseConnection> pool;

   /**
    * Creates a connection pool with a default maximum of 10 connections.
    *
    * @param configuration the database configuration to be used
    */
   public ConnectionPool(DatabaseConfiguration configuration) {
      this(configuration, 10);
   }

   /**
    * Creates a connection pool with the specified maximum number of connections.
    *
    * @param configuration the database configuration to be used
    * @param maxConnections the maximum number of connections allowed in the pool
    */
   public ConnectionPool(DatabaseConfiguration configuration, int maxConnections) {
      this.currentConnections = 0;
      this.pool = new ConcurrentLinkedQueue<>();
      this.configuration = configuration;
      this.maxConnections = maxConnections;
      Executors.newScheduledThreadPool(1).scheduleAtFixedRate(new Runnable() {
         /**
          * Periodically checks the connections in the pool to ensure they are valid.
          */
         public void run() {
            Iterator<DatabaseConnection> it$ = ConnectionPool.this.pool.iterator();
            while (it$.hasNext()) {
               DatabaseConnection connection = it$.next();
               try {
                  connection.getConnection().createStatement().execute("/* ping */ SELECT 1");
               } catch (SQLException var4) {
                  it$.remove();
               }
            }
         }
      }, 0L, 30000L, TimeUnit.MILLISECONDS);
   }

   /**
    * Retrieves the next free connection from the pool. If no valid connection is
    * available and the pool has not reached its maximum size, a new connection is created.
    *
    * @return a valid {@link DatabaseConnection} or null if the pool is at maximum capacity
    */
   public DatabaseConnection nextFree() {
      DatabaseConnection connection = (DatabaseConnection) this.pool.poll();
      if (connection != null) {
         if (!connection.isFresh()) {
            --this.currentConnections;
            return this.nextFree();
         } else {
            return connection;
         }
      } else if (this.currentConnections >= this.maxConnections) {
         return null;
      } else {
         connection = this.configuration.newConnection();
         connection.setPool(this);
         if (!connection.connect()) {
            throw new RuntimeException("Connection was unable to connect!");
         } else {
            ++this.currentConnections;
            return connection;
         }
      }
   }

   /**
    * Returns a connection to the pool for reuse.
    *
    * @param connection the {@link DatabaseConnection} to be returned to the pool
    */
   public void returnConnection(DatabaseConnection connection) {
      this.pool.offer(connection);
   }
}