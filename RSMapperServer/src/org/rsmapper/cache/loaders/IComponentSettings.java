package org.rsmapper.cache.loaders;

public class IComponentSettings {
   public int settings;
   public int anInt4602;

   public boolean method1879(boolean arg0) {
      return ~((3058242 & this.settings) >> -1445214219) != -1;
   }

   public boolean unlockedSlot(int slot, byte arg1) {
      return ~(this.settings >> 1 + slot & 1) != -1;
   }

   public boolean method1881(int arg0) {
      return ~((1442209717 & this.settings) >> 1601172318) != -1;
   }

   public boolean method1882(int arg0) {
      return ~((this.settings & 530827295) >> -233371236) != -1;
   }

   public boolean method1883(byte arg0) {
      return ~(1 & this.settings >> 111606079) != -1;
   }

   public boolean method1884(int arg0) {
      return ~(1 & this.settings) != -1;
   }

   public boolean method1885(byte arg0) {
      return ~(1 & this.settings >> 1361505174) != -1;
   }

   public int method1887(int arg0) {
      return (this.settings & 2066237) >> 1483551026;
   }

   public int method1888(byte arg0) {
      return 127 & this.settings >> -809958741;
   }

   public IComponentSettings(int arg0, int arg1) {
      this.settings = arg0;
      this.anInt4602 = arg1;
   }
}
