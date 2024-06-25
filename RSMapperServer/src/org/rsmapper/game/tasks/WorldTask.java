package org.rsmapper.game.tasks;

public abstract class WorldTask implements Runnable {
   protected boolean needRemove;

   public final void stop() {
      this.needRemove = true;
   }
}
