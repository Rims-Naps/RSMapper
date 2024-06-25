package org.rsmapper.cache.loaders;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;

public final class VarBitDefinitions {
   private static final ConcurrentHashMap<Integer, VarBitDefinitions> varpbitDefs = new ConcurrentHashMap();
   public int id;
   public int baseVar;
   public int startBit;
   public int endBit;

   public static final void main(String[] args) throws IOException {
      Cache.init();
      System.out.println("There are currently: " + Cache.STORE.getIndexes()[22].getLastArchiveId() * 1023 + " bitConfigs.");

      for(int i = 0; i < Cache.STORE.getIndexes()[22].getLastArchiveId() * 1023; ++i) {
         VarBitDefinitions cd = getClientVarpBitDefinitions(i);
         if (cd.baseVar == 563) {
            System.out.println("BitConfig: " + i + ", from bitshift:" + cd.startBit + ", till bitshift: " + cd.endBit + ", " + cd.baseVar);
         }
      }

   }

   public static final VarBitDefinitions getClientVarpBitDefinitions(int id) {
      VarBitDefinitions script = (VarBitDefinitions)varpbitDefs.get(id);
      if (script != null) {
         return script;
      } else {
         byte[] data = Cache.STORE.getIndexes()[22].getFile(id >>> 1416501898, id & 1023);
         script = new VarBitDefinitions();
         script.id = id;
         if (data != null) {
            script.readValueLoop(new InputStream(data));
         }

         varpbitDefs.put(id, script);
         return script;
      }
   }

   private void readValueLoop(InputStream stream) {
      while(true) {
         int opcode = stream.readUnsignedByte();
         if (opcode == 0) {
            return;
         }

         this.readValues(stream, opcode);
      }
   }

   private void readValues(InputStream stream, int opcode) {
      if (opcode == 1) {
         this.baseVar = stream.readUnsignedShort();
         this.startBit = stream.readUnsignedByte();
         this.endBit = stream.readUnsignedByte();
      }

   }

   private VarBitDefinitions() {
   }
}
