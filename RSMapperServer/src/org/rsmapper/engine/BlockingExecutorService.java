package org.rsmapper.engine;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BlockingExecutorService implements ExecutorService {
   private ExecutorService service;
   private BlockingQueue<Future<?>> pendingTasks = new LinkedBlockingQueue();

   public BlockingExecutorService(ExecutorService service) {
      this.service = service;
   }

   public BlockingExecutorService waitForPendingTasks() throws ExecutionException {
      while(this.pendingTasks.size() > 0) {
         if (this.isShutdown()) {
            return this;
         }

         try {
            ((Future)this.pendingTasks.take()).get();
         } catch (InterruptedException var2) {
            var2.printStackTrace();
         }
      }

      return this;
   }

   public int getPendingTaskAmount() {
      return this.pendingTasks.size();
   }

   public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
      return this.service.awaitTermination(timeout, unit);
   }

   public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks) throws InterruptedException {
      List<Future<T>> futures = this.service.invokeAll(tasks);
      futures.forEach((future) -> {
         this.pendingTasks.add(future);
      });
      return futures;
   }

   public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException {
      List<Future<T>> futures = this.service.invokeAll(tasks, timeout, unit);
      futures.forEach((future) -> {
         this.pendingTasks.add(future);
      });
      return futures;
   }

   public <T> T invokeAny(Collection<? extends Callable<T>> tasks) throws InterruptedException, ExecutionException {
      return this.service.invokeAny(tasks);
   }

   public <T> T invokeAny(Collection<? extends Callable<T>> tasks, long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
      return this.service.invokeAny(tasks, timeout, unit);
   }

   public boolean isShutdown() {
      return this.service.isShutdown();
   }

   public boolean isTerminated() {
      return this.service.isTerminated();
   }

   public void shutdown() {
      this.service.shutdown();
   }

   public List<Runnable> shutdownNow() {
      return this.service.shutdownNow();
   }

   public <T> Future<T> submit(Callable<T> task) {
      Future<T> future = this.service.submit(task);
      this.pendingTasks.add(future);
      return future;
   }

   public Future<?> submit(Runnable task) {
      Future<?> future = this.service.submit(task);
      this.pendingTasks.add(future);
      return future;
   }

   public <T> Future<T> submit(Runnable task, T result) {
      Future<T> future = this.service.submit(task, result);
      this.pendingTasks.add(future);
      return future;
   }

   public void execute(Runnable command) {
      this.service.execute(command);
   }
}
