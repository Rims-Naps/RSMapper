package org.rsmapper.game.player;

import org.rsmapper.cache.Cache;
import org.rsmapper.cache.loaders.VarBitDefinitions;

public class VarsManager {
   private static final int[] masklookup = new int[32];
   private int[] values;
   private Player player;

   static {
      int i = 2;

      for(int i2 = 0; i2 < 32; ++i2) {
         masklookup[i2] = i - 1;
         i += i;
      }

   }

   public VarsManager(Player player) {
      this.player = player;
      this.values = new int[Cache.STORE.getIndexes()[2].getLastFileId(16) + 1];
   }

   public void sendVar(int id, int value) {
      this.sendVar(id, value, false);
   }

   public void forceSendVar(int id, int value) {
      this.sendVar(id, value, true);
   }

   private void sendVar(int id, int value, boolean force) {
      if (id >= 0 && id < this.values.length) {
         if (!force && this.values[id] != value) {
            this.setVar(id, value);
            this.sendClientVarp(id);
         }
      }
   }

   public void setVar(int id, int value) {
      if (id != -1) {
         this.values[id] = value;
      }
   }

   public int getValue(int id) {
      return this.values[id];
   }

   public void forceSendVarBit(int id, int value) {
      this.setVarBit(id, value, 3);
   }

   public void sendVarBit(int id, int value) {
      this.setVarBit(id, value, 1);
   }

   public void setVarBit(int id, int value) {
      this.setVarBit(id, value, 0);
   }

   public int getBitValue(int id) {
      VarBitDefinitions defs = VarBitDefinitions.getClientVarpBitDefinitions(id);
      return this.values[defs.baseVar] >> defs.startBit & masklookup[defs.endBit - defs.startBit];
   }

   private void setVarBit(int id, int value, int flag) {
      if (id != -1) {
         VarBitDefinitions defs = VarBitDefinitions.getClientVarpBitDefinitions(id);
         int mask = masklookup[defs.endBit - defs.startBit];
         if (value < 0 || value > mask) {
            value = 0;
         }

         mask <<= defs.startBit;
         int varpValue = this.values[defs.baseVar] & ~mask | value << defs.startBit & mask;
         if ((flag & 2) != 0 || varpValue != this.values[defs.baseVar]) {
            this.setVar(defs.baseVar, varpValue);
            if ((flag & 1) != 0) {
               this.sendClientVarp(defs.baseVar);
            }
         }

      }
   }

   private void sendClientVarp(int id) {
      this.player.getPackets().sendConfig(id, this.values[id]);
   }
}
