package org.rsmapper.cache.loaders;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.utilities.misc.Utils;

public final class ClientScriptMap {
   private char aChar6337;
   private char aChar6345;
   private String defaultStringValue = "null";
   private int defaultIntValue;
   private HashMap<Long, Object> values;
   private static final ConcurrentHashMap<Integer, ClientScriptMap> interfaceScripts = new ConcurrentHashMap();

   public static void main(String[] args) throws IOException {
      Cache.init();
      ClientScriptMap names = getMap(1320);
      getMap(952);
      getMap(1349);
      System.out.println(names.values);
   }

   public static final ClientScriptMap getMap(int scriptId) {
      ClientScriptMap script = (ClientScriptMap)interfaceScripts.get(scriptId);
      if (script != null) {
         return script;
      } else {
         byte[] data = Cache.STORE.getIndexes()[17].getFile(scriptId >>> -1163995736, scriptId & 255);
         script = new ClientScriptMap();
         if (data != null) {
            script.readValueLoop(new InputStream(data));
         }

         interfaceScripts.put(scriptId, script);
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
      return this.values.size();
   }

   public int getIntValue(long key) {
      if (this.values == null) {
         return this.defaultIntValue;
      } else {
         Object value = this.values.get(key);
         return value != null && value instanceof Integer ? (Integer)value : this.defaultIntValue;
      }
   }

   public String getStringValue(long key) {
      if (this.values == null) {
         return this.defaultStringValue;
      } else {
         Object value = this.values.get(key);
         return value != null && value instanceof String ? (String)value : this.defaultStringValue;
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
         this.aChar6337 = Utils.method2782((byte)stream.readByte());
      } else if (opcode == 2) {
         this.aChar6345 = Utils.method2782((byte)stream.readByte());
      } else if (opcode == 3) {
         this.defaultStringValue = stream.readString();
      } else if (opcode == 4) {
         this.defaultIntValue = stream.readInt();
      } else if (opcode == 5 || opcode == 6 || opcode == 7 || opcode == 8) {
         int count = stream.readUnsignedShort();
         int loop = opcode != 7 && opcode != 8 ? count : stream.readUnsignedShort();
         this.values = new HashMap(Utils.getHashMapSize(count));

         for(int i = 0; i < loop; ++i) {
            int key = opcode != 7 && opcode != 8 ? stream.readInt() : stream.readUnsignedShort();
            Object value = opcode != 5 && opcode != 7 ? stream.readInt() : stream.readString();
            this.values.put((long)key, value);
         }
      }

   }

   private ClientScriptMap() {
   }
}
