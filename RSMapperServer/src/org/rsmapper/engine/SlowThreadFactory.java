package org.rsmapper.engine;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class SlowThreadFactory implements ThreadFactory {
   private static final AtomicInteger poolNumber = new AtomicInteger(1);
   private final ThreadGroup group;
   private final AtomicInteger threadNumber = new AtomicInteger(1);
   private final String namePrefix;

   public SlowThreadFactory() {
      SecurityManager s = System.getSecurityManager();
      this.group = s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
      this.namePrefix = "Slow Pool-" + poolNumber.getAndIncrement() + "-thread-";
   }

   public Thread newThread(Runnable r) {
      Thread t = new Thread(this.group, r, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
      if (t.isDaemon()) {
         t.setDaemon(false);
      }

      if (t.getPriority() != 1) {
         t.setPriority(1);
      }

      return t;
   }
}
