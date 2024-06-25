package org.rsmapper.engine.process;

import java.util.concurrent.TimeUnit;

public interface TimedProcess {
   TimedProcess.Timer getTimer();

   void execute();

   public static class Timer {
      private final int delay;
      private final TimeUnit timeUnit;
      // $FF: synthetic field
      private static int[] $SWITCH_TABLE$java$util$concurrent$TimeUnit;

      public Timer(int delay, TimeUnit timeUnit) {
         this.delay = delay;
         this.timeUnit = timeUnit;
      }

      public long getDelayInMs() {
         switch($SWITCH_TABLE$java$util$concurrent$TimeUnit()[this.timeUnit.ordinal()]) {
         case 3:
            return (long)this.delay;
         case 4:
            return TimeUnit.SECONDS.toMillis((long)this.delay);
         case 5:
            return TimeUnit.MINUTES.toMillis((long)this.delay);
         case 6:
            return TimeUnit.MILLISECONDS.toMillis((long)this.delay);
         case 7:
            return TimeUnit.DAYS.toMillis((long)this.delay);
         default:
            return (long)this.delay;
         }
      }

      public TimeUnit getTimeUnit() {
         return this.timeUnit;
      }

      public int getDelay() {
         return this.delay;
      }

      // $FF: synthetic method
      static int[] $SWITCH_TABLE$java$util$concurrent$TimeUnit() {
         int[] var10000 = $SWITCH_TABLE$java$util$concurrent$TimeUnit;
         if (var10000 != null) {
            return var10000;
         } else {
            int[] var0 = new int[TimeUnit.values().length];

            try {
               var0[TimeUnit.DAYS.ordinal()] = 7;
            } catch (NoSuchFieldError var7) {
            }

            try {
               var0[TimeUnit.HOURS.ordinal()] = 6;
            } catch (NoSuchFieldError var6) {
            }

            try {
               var0[TimeUnit.MICROSECONDS.ordinal()] = 2;
            } catch (NoSuchFieldError var5) {
            }

            try {
               var0[TimeUnit.MILLISECONDS.ordinal()] = 3;
            } catch (NoSuchFieldError var4) {
            }

            try {
               var0[TimeUnit.MINUTES.ordinal()] = 5;
            } catch (NoSuchFieldError var3) {
            }

            try {
               var0[TimeUnit.NANOSECONDS.ordinal()] = 1;
            } catch (NoSuchFieldError var2) {
            }

            try {
               var0[TimeUnit.SECONDS.ordinal()] = 4;
            } catch (NoSuchFieldError var1) {
            }

            $SWITCH_TABLE$java$util$concurrent$TimeUnit = var0;
            return var0;
         }
      }
   }
}
