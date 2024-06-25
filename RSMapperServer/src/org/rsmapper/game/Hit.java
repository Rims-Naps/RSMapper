package org.rsmapper.game;

import org.rsmapper.game.player.Player;

public final class Hit {
   private Entity source;
   private Hit.HitLook look;
   private int damage;
   private boolean critical;
   private Hit soaking;
   private int delay;

   public Hit setCriticalMark() {
      this.critical = true;
      return this;
   }

   public Hit setHealHit() {
      this.look = Hit.HitLook.HEALED_DAMAGE;
      this.critical = false;
      return this;
   }

   public Hit(Entity source, int damage) {
      this(source, damage, Hit.HitLook.REGULAR_DAMAGE);
   }

   public Hit(Entity source, int damage, Hit.HitLook look) {
      this(source, damage, look, 0);
   }

   public Hit(Entity source, int damage, Hit.HitLook look, int delay) {
      this.source = source;
      this.damage = damage;
      this.look = look;
      this.delay = delay;
   }

   public boolean missed() {
      return this.damage == 0;
   }

   public boolean interactingWith(Player player, Entity victm) {
      return player == victm || player == this.source;
   }

   public int getMark(Player player, Entity victm) {
      if (Hit.HitLook.HEALED_DAMAGE == this.look) {
         return this.look.getMark();
      } else if (this.damage == 0) {
         return Hit.HitLook.MISSED.getMark();
      } else {
         int mark = this.look.getMark();
         if (this.critical) {
            mark += 10;
         }

         if (!this.interactingWith(player, victm)) {
            mark += 14;
         }

         return mark;
      }
   }

   public Hit.HitLook getLook() {
      return this.look;
   }

   public int getDamage() {
      return this.damage;
   }

   public Hit setDamage(int damage) {
      this.damage = damage;
      return this;
   }

   public Entity getSource() {
      return this.source;
   }

   public void setSource(Entity source) {
      this.source = source;
   }

   public boolean isCriticalHit() {
      return this.critical;
   }

   public Hit getSoaking() {
      return this.soaking;
   }

   public void setSoaking(Hit soaking) {
      this.soaking = soaking;
   }

   public int getDelay() {
      return this.delay;
   }

   public Hit setLook(Hit.HitLook look) {
      this.look = look;
      return this;
   }

   public static enum HitLook {
      MISSED(8),
      REGULAR_DAMAGE(3),
      MELEE_DAMAGE(0),
      RANGE_DAMAGE(1),
      MAGIC_DAMAGE(2),
      REFLECTED_DAMAGE(4),
      ABSORB_DAMAGE(5),
      POISON_DAMAGE(6),
      DESEASE_DAMAGE(7),
      HEALED_DAMAGE(9),
      CANNON_DAMAGE(13);

      private int mark;

      private HitLook(int mark) {
         this.mark = mark;
      }

      public int getMark() {
         return this.mark;
      }
   }
}
