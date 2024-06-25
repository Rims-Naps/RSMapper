package org.rsmapper.engine;

import java.util.Timer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class CoresManager {
   public static volatile boolean shutdown;
   public static ExecutorService serverWorkerChannelExecutor;
   public static ExecutorService serverBossChannelExecutor;
   public static Timer fastExecutor;
   public static ScheduledExecutorService slowExecutor;
   public static int serverWorkersCount;

   public static void init() {
      int availableProcessors = Runtime.getRuntime().availableProcessors();
      serverWorkersCount = availableProcessors;
      serverWorkerChannelExecutor = serverWorkersCount > 1 ? Executors.newFixedThreadPool(serverWorkersCount, new DecoderThreadFactory()) : Executors.newSingleThreadExecutor(new DecoderThreadFactory());
      serverBossChannelExecutor = Executors.newSingleThreadExecutor(new DecoderThreadFactory());
      fastExecutor = new Timer("Fast Executor");
      slowExecutor = Executors.newScheduledThreadPool(2, new SlowThreadFactory());
   }

   public static void shutdown() {
      serverWorkerChannelExecutor.shutdown();
      serverBossChannelExecutor.shutdown();
      fastExecutor.cancel();
      slowExecutor.shutdown();
      shutdown = true;
   }

   private CoresManager() {
   }
}
