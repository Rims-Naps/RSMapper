package org.rsmapper.cache.loaders;

import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;

public final class FloorDefinitions {
   private static final ConcurrentHashMap<Integer, FloorDefinitions> defs = new ConcurrentHashMap();
   public int anInt6001;
   public int anInt6002;
   public int anInt6003 = -1;
   public boolean aBool6004 = true;
   public boolean aBool6005 = true;
   public int anInt6006 = 0;
   public int anInt6007;
   public int anInt6008;
   public int anInt6009 = -1;
   private int id;

   public static final FloorDefinitions getFloorDefinitions(int id) {
      FloorDefinitions script = (FloorDefinitions)defs.get(id);
      if (script != null) {
         return script;
      } else {
         byte[] data = Cache.STORE.getIndexes()[2].getFile(1, id);
         script = new FloorDefinitions();
         script.id = id;
         if (data != null) {
            script.readValueLoop(new InputStream(data));
         }

         defs.put(id, script);
         return script;
      }
   }

   private FloorDefinitions() {
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

   void method7486(int i) {
      int red = i >> 16 & 255;
      int green = i >> 8 & 255;
      int blue = i & 255;
      this.anInt6001 = red;
      this.anInt6007 = green;
      this.anInt6002 = blue;
   }

   private void readValues(InputStream stream, int i) {
      if (1 == i) {
         this.anInt6006 = stream.read24BitInt();
         this.method7486(this.anInt6006);
      } else if (i == 2) {
         this.anInt6009 = stream.readUnsignedShort();
         if (65535 == this.anInt6009) {
            this.anInt6009 = -1;
         }
      } else if (3 == i) {
         this.anInt6003 = stream.readUnsignedShort() << 2;
      } else if (i == 4) {
         this.aBool6004 = false;
      } else if (i == 5) {
         this.aBool6005 = false;
      }

   }

   public int getId() {
      return this.id;
   }
}
