package org.rsmapper.game.player;

import java.io.Serializable;

public class Facade implements Serializable {
   private boolean acceptingAid;
   private boolean expLocked;
   private boolean hasYellOff;
   private long goldPoints;
   private long totalPointsPurchased;
   private long lastDisplayNameChange;
   private double[] modifiers = new double[3];
   private String title;
   private String email;
   private String yellTag;
   private String yellColour;
   public static final int COMBAT_MODIFIER_INDEX = 0;
   public static final int SKILL_MODIFIER_INDEX = 1;
   public static final int LOOT_MODIFIER_INDEX = 2;
   private static final long serialVersionUID = -3187404322997250838L;

   public boolean isAcceptingAid() {
      return this.acceptingAid;
   }

   public void setAcceptingAid(boolean acceptingAid) {
      this.acceptingAid = acceptingAid;
   }

   public long getGoldPoints() {
      return this.goldPoints;
   }

   public void setGoldPoints(long goldPoints) {
      this.goldPoints = goldPoints;
   }

   public void rewardCoins(int goldPoints) {
      this.goldPoints += (long)goldPoints;
   }

   public double[] getModifiers() {
      return this.modifiers;
   }

   public void setModifier(double[] modifier) {
      this.modifiers = modifier;
   }

   public long getTotalPointsPurchased() {
      return this.totalPointsPurchased;
   }

   public void setTotalPointsPurchased(long totalPointsPurchased) {
      this.totalPointsPurchased = totalPointsPurchased;
   }

   public String getTitle() {
      return this.title;
   }

   public void setTitle(String title) {
      this.title = title;
   }

   public long getLastDisplayNameChange() {
      return this.lastDisplayNameChange;
   }

   public void setLastDisplayNameChange(long lastDisplayNameChange) {
      this.lastDisplayNameChange = lastDisplayNameChange;
   }

   public boolean isExpLocked() {
      return this.expLocked;
   }

   public void setExpLocked(boolean expLocked) {
      this.expLocked = expLocked;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public boolean hasYellOff() {
      return this.hasYellOff;
   }

   public void setYellOff(boolean hasYellOff) {
      this.hasYellOff = hasYellOff;
   }

   public String getYellTag() {
      return this.yellTag;
   }

   public void setYellTag(String yellTag) {
      this.yellTag = yellTag;
   }

   public String getYellColour() {
      return this.yellColour;
   }

   public void setYellColour(String yellColour) {
      this.yellColour = yellColour;
   }
}
