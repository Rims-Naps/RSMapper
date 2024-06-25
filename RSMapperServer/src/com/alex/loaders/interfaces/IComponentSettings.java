package com.alex.loaders.interfaces;

public final class IComponentSettings {
   private int settingsHash;
   private int defaultHash;

   public IComponentSettings(int settingsHash, int defaultHash) {
      this.settingsHash = settingsHash;
      this.defaultHash = defaultHash;
   }
}
