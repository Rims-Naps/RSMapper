package org.rsmapper.engine;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ConcurrentThreadFactory implements ThreadFactory {
   private final String name;
   private final AtomicInteger threadCount = new AtomicInteger();

   public ConcurrentThreadFactory(String name) {
      this.name = name;
   }

   public Thread newThread(Runnable r) {
      Thread thread = new Thread(r, this.name + "-" + this.threadCount.getAndIncrement());
      return thread;
   }
}
