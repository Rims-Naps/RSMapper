package org.rsmapper.game;

public class SecondaryBar {
   private int beginningOffset;
   private int totalUnits;
   private int incrementalUnits;
   private boolean permanent;

   public SecondaryBar(int beginningOffset, int totalUnits, int incrementalUnits, boolean permanent) {
      this.beginningOffset = beginningOffset;
      this.totalUnits = totalUnits;
      this.incrementalUnits = incrementalUnits;
      this.permanent = permanent;
   }

   public int getBeginningOffset() {
      return this.beginningOffset;
   }

   public int getTotalUnits() {
      return this.totalUnits;
   }

   public int getIncrementalUnits() {
      return this.incrementalUnits;
   }

   public boolean isPermenant() {
      return this.permanent;
   }
}
