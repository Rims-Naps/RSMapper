package org.rsmapper.engine;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class DecoderThreadFactory implements ThreadFactory {
   private static final AtomicInteger poolNumber = new AtomicInteger(1);
   private final ThreadGroup group;
   private final AtomicInteger threadNumber = new AtomicInteger(1);
   private final String namePrefix;

   public DecoderThreadFactory() {
      SecurityManager s = System.getSecurityManager();
      this.group = s != null ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
      this.namePrefix = "Decoder Pool-" + poolNumber.getAndIncrement() + "-thread-";
   }

   public Thread newThread(Runnable r) {
      Thread t = new Thread(this.group, r, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
      if (t.isDaemon()) {
         t.setDaemon(false);
      }

      if (t.getPriority() != 9) {
         t.setPriority(9);
      }

      return t;
   }
}
