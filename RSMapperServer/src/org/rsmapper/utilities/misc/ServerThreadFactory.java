package org.rsmapper.utilities.misc;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class ServerThreadFactory implements ThreadFactory {
   private final String name;
   private final int priority;
   private final AtomicInteger threadCount;

   public ServerThreadFactory(String name) {
      this(name, 5);
   }

   public ServerThreadFactory(String name, int priority) {
      this.threadCount = new AtomicInteger();
      this.name = name;
      this.priority = priority;
   }

   public Thread newThread(Runnable r) {
      Thread thread = new Thread(r, this.name + "-" + this.threadCount.getAndIncrement());
      thread.setPriority(this.priority);
      return thread;
   }
}
