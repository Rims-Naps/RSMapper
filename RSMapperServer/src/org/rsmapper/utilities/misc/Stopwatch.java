package org.rsmapper.utilities.misc;

import java.util.concurrent.TimeUnit;

public final class Stopwatch {
   private final long time;

   private Stopwatch(long time) {
      this.time = time;
   }

   public long elapsed() {
      return System.currentTimeMillis() - this.time;
   }

   public long elapsed(TimeUnit desiredUnit) {
      return desiredUnit.convert(this.elapsed(), TimeUnit.MILLISECONDS);
   }

   public void printElapsed(String format) {
      System.err.printf(format, this.elapsed());
   }

   public void printElapsed() {
      this.printElapsed("Time elapsed: %sms\n");
   }

   public static Stopwatch start() {
      return new Stopwatch(System.currentTimeMillis());
   }
}
