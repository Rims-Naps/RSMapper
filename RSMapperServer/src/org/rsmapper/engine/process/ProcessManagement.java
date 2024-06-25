package org.rsmapper.engine.process;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import org.rsmapper.engine.process.impl.PacketQueueProcessor;

public class ProcessManagement {
   private final ScheduledExecutorService service = Executors.newScheduledThreadPool(4);
   private static final ProcessManagement INSTANCE = new ProcessManagement();
   private final List<TimedProcess> loadedClasses = new ArrayList();

   public ProcessManagement() {
      try {
         this.loadedClasses.add((TimedProcess)PacketQueueProcessor.class.newInstance());
      } catch (Exception var2) {
         var2.printStackTrace();
      }

   }

   public void registerEvents() {
      this.loadedClasses.forEach((c) -> {
         this.startTimedProcess(c);
      });
   }

   private void startTimedProcess(final TimedProcess process) {
      this.service.scheduleAtFixedRate(new Runnable() {
         public void run() {
            try {
               process.execute();
            } catch (Exception var2) {
               var2.printStackTrace();
            }

         }
      }, 0L, (long)process.getTimer().getDelay(), process.getTimer().getTimeUnit());
   }

   public static ProcessManagement get() {
      return INSTANCE;
   }
}
