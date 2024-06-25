package org.rsmapper.networking.protocol.js5;

import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.Session;
import org.rsmapper.networking.codec.Decoder;
import org.rsmapper.networking.codec.stream.InputStream;
import org.rsmapper.utilities.misc.ServerThreadFactory;

/**
 * Responsible for decoding JS5 packets and processing cache requests.
 */
public final class GrabPacketsDecoder extends Decoder {

   /**
    * A list to store cache requests.
    */
   private LinkedList<String> requests = new LinkedList();

   /**
    * Executor service for updating services.
    */
   private static ExecutorService updateService = Executors.newFixedThreadPool(1);

   /**
    * Executor service for processing cache requests.
    */
   private static ExecutorService worker = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors(), new ServerThreadFactory("JS5-Worker"));

   /**
    * Constructs a new GrabPacketsDecoder with the given session.
    *
    * @param connection the session connection
    */
   public GrabPacketsDecoder(Session connection) {
      super(connection);
   }

   /**
    * Decodes the input stream and processes the cache requests.
    *
    * @param stream the input stream to decode
    */
   public final void decode(InputStream stream) {
      while(stream.getRemaining() > 0 && this.session.getChannel().isConnected()) {
         int packetId = stream.readUnsignedByte();
         this.decodeRequestCacheContainer(stream, packetId);
      }

      this.requests.clear();
   }

   /**
    * Decodes a cache request from the input stream based on its priority.
    *
    * @param stream the input stream to decode
    * @param priority the priority of the cache request
    */
   private final void decodeRequestCacheContainer(InputStream stream, int priority) {
      final int indexId = stream.readUnsignedByte();
      final int archiveId = stream.readInt();
      if (archiveId >= 0) {
         if (indexId != 255) {
            if (Cache.STORE.getIndexes().length <= indexId || Cache.STORE.getIndexes()[indexId] == null || !Cache.STORE.getIndexes()[indexId].archiveExists(archiveId)) {
               return;
            }
         } else if (archiveId != 255 && (Cache.STORE.getIndexes().length <= archiveId || Cache.STORE.getIndexes()[archiveId] == null)) {
            return;
         }

         switch(priority) {
         case 0:
            this.requests.add(indexId + "," + archiveId);
            break;
         case 1:
            worker.submit(new Runnable() {
               public void run() {
                  GrabPacketsDecoder.this.session.getGrabPackets().sendCacheArchive(indexId, archiveId, true);
               }
            });
            break;
         case 2:
         case 3:
            this.requests.clear();
            break;
         default:
            System.out.println("[priority=" + priority + "]");
         }

         while(this.requests.size() > 0) {
            String[] request = ((String)this.requests.removeFirst()).split(",");
            this.session.getGrabPackets().sendCacheArchive(Integer.parseInt(request[0]), Integer.parseInt(request[1]), false);
         }

      }
   }
}