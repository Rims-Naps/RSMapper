package org.rsmapper.cache.loaders;

import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;

public final class GeneralRequirementMap {
   private HashMap<Long, Object> values;
   private static final ConcurrentHashMap<Integer, GeneralRequirementMap> maps = new ConcurrentHashMap();

   public static final GeneralRequirementMap getMap(int scriptId) {
      GeneralRequirementMap script = (GeneralRequirementMap)maps.get(scriptId);
      if (script != null) {
         return script;
      } else {
         byte[] data = Cache.STORE.getIndexes()[2].getFile(26, scriptId);
         script = new GeneralRequirementMap();
         if (data != null) {
            script.readValueLoop(new InputStream(data));
         }

         maps.put(scriptId, script);
         return script;
      }
   }

   public HashMap<Long, Object> getValues() {
      return this.values;
   }

   public Object getValue(long key) {
      return this.values == null ? null : this.values.get(key);
   }

   public long getKeyForValue(Object value) {
      Iterator var3 = this.values.keySet().iterator();

      while(var3.hasNext()) {
         Long key = (Long)var3.next();
         if (this.values.get(key).equals(value)) {
            return key;
         }
      }

      return -1L;
   }

   public int getSize() {
      return this.values == null ? 0 : this.values.size();
   }

   public int getIntValue(long key) {
      if (this.values == null) {
         return 0;
      } else {
         Object value = this.values.get(key);
         return value != null && value instanceof Integer ? (Integer)value : 0;
      }
   }

   public String getStringValue(long key) {
      if (this.values == null) {
         return "";
      } else {
         Object value = this.values.get(key);
         return value != null && value instanceof String ? (String)value : "";
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
      if (opcode == 249) {
         int length = stream.readUnsignedByte();
         if (this.values == null) {
            this.values = new HashMap(length);
         }

         for(int index = 0; index < length; ++index) {
            boolean stringInstance = stream.readUnsignedByte() == 1;
            int key = stream.read24BitInt();
            Object value = stringInstance ? stream.readString() : stream.readInt();
            this.values.put((long)key, value);
         }
      }

   }

   private GeneralRequirementMap() {
   }
}
