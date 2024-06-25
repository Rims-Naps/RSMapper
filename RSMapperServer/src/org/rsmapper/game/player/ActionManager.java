package org.rsmapper.game.player;

import org.rsmapper.game.player.actions.Action;
import org.rsmapper.utilities.misc.Utils;

public final class ActionManager {
   private long startTime;
   private Player player;
   private Action action;
   private int actionDelay;

   public ActionManager(Player player) {
      this.player = player;
   }

   public void process() {
      if (this.action != null) {
         if (this.player.isDead()) {
            this.forceStop();
         } else if (!this.action.process(this.player)) {
            this.forceStop();
         }
      }

      if (this.actionDelay > 0) {
         --this.actionDelay;
      } else if (this.action != null) {
         int delay = this.action.processWithDelay(this.player);
         if (delay == -1) {
            this.forceStop();
         } else {
            this.actionDelay += delay;
         }
      }
   }

   public boolean setAction(Action skill) {
      this.startTime = Utils.currentTimeMillis();
      this.forceStop();
      if (!skill.start(this.player)) {
         return false;
      } else {
         this.action = skill;
         return true;
      }
   }

   public Action getAction() {
      return this.action;
   }

   public void forceStop() {
      if (this.action != null) {
         this.action.stop(this.player);
         this.player.setActionTime(this.player.getActionTime() + Utils.currentTimeMillis() - this.startTime);
         this.action = null;
      }
   }

   public int getActionDelay() {
      return this.actionDelay;
   }

   public void addActionDelay(int actionDelay) {
      this.actionDelay += actionDelay;
   }

   public void setActionDelay(int actionDelay) {
      this.actionDelay = actionDelay;
   }

   public boolean hasSkillWorking() {
      return this.action != null;
   }
}
