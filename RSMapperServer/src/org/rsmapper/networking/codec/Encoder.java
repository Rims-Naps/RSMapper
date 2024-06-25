package org.rsmapper.networking.codec;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.rsmapper.networking.Session;

public abstract class Encoder {
   protected Session session;
   protected Map<Integer, Integer> requests;

   public Encoder(Session session) {
      this.session = session;
      this.requests = Collections.synchronizedMap(new HashMap());
   }

   public Map<Integer, Integer> getRequests() {
      if (this.requests == null) {
         this.requests = Collections.synchronizedMap(new HashMap());
      }

      return this.requests;
   }
}
