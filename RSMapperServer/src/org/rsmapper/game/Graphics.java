package org.rsmapper.game;

public final class Graphics {
   private int id;
   private int height;
   private int speed;
   private int rotation;

   public Graphics(int id) {
      this(id, 0, 0, 0);
   }

   public Graphics(int id, int speed, int height) {
      this(id, speed, height, 0);
   }

   public Graphics(int id, int speed, int height, int rotation) {
      this.id = id;
      this.speed = speed;
      this.height = height;
      this.rotation = rotation;
   }

   public int hashCode() {
      int prime = true;
      int result = 1;
      int result = 31 * result + this.height;
      result = 31 * result + this.id;
      result = 31 * result + this.rotation;
      result = 31 * result + this.speed;
      return result;
   }

   public boolean equals(Object obj) {
      if (this == obj) {
         return true;
      } else if (obj != null && this.getClass() == obj.getClass()) {
         Graphics other = (Graphics)obj;
         return this.height == other.height && this.id == other.id && this.rotation == other.rotation && this.speed == other.speed;
      } else {
         return false;
      }
   }

   public int getId() {
      return this.id;
   }

   public int getSettingsHash() {
      return this.speed & '\uffff' | this.height << 16;
   }

   public int getSettings2Hash() {
      int hash = 0;
      int hash = hash | this.rotation & 7;
      return hash;
   }

   public int getSpeed() {
      return this.speed;
   }

   public int getHeight() {
      return this.height;
   }
}
