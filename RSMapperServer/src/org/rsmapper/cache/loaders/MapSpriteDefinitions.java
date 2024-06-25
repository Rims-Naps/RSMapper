package org.rsmapper.cache.loaders;

import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;

public final class MapSpriteDefinitions {
   private static final ConcurrentHashMap<Integer, MapSpriteDefinitions> defs = new ConcurrentHashMap();
   public boolean aBool7726 = false;
   public int anInt7727;
   public int spriteId = -1;
   int[] anIntArray7730;
   private int id;

   public int getId() {
      return this.id;
   }

   public static final MapSpriteDefinitions getMapSpriteDefinitions(int id) {
      MapSpriteDefinitions script = (MapSpriteDefinitions)defs.get(id);
      if (script != null) {
         return script;
      } else {
         byte[] data = Cache.STORE.getIndexes()[2].getFile(34, id);
         script = new MapSpriteDefinitions();
         script.id = id;
         if (data != null) {
            script.readValueLoop(new InputStream(data));
         }

         defs.put(id, script);
         return script;
      }
   }

   private MapSpriteDefinitions() {
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

   private void readValues(InputStream stream, int i) {
      if (i == 1) {
         this.spriteId = stream.readBigSmart();
      } else if (2 == i) {
         this.anInt7727 = stream.read24BitInt();
      } else if (i == 3) {
         this.aBool7726 = true;
      } else if (4 == i) {
         this.spriteId = -1;
      }

   }
}
