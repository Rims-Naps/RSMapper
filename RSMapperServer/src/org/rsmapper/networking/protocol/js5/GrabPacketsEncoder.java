package org.rsmapper.networking.protocol.js5;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.channel.ChannelFutureListener;
import org.rsmapper.Constants;
import org.rsmapper.cache.Cache;
import org.rsmapper.networking.Session;
import org.rsmapper.networking.codec.Encoder;
import org.rsmapper.networking.codec.stream.OutputStream;

public final class GrabPacketsEncoder extends Encoder {
   private static byte[] UKEYS_FILE;
   private int encryptionValue;

   public static final OutputStream getUkeysFile() {
      if (UKEYS_FILE == null) {
         UKEYS_FILE = Cache.generateUkeysFile();
      }

      return getContainerPacketData(255, 255, UKEYS_FILE);
   }

   public GrabPacketsEncoder(Session connection) {
      super(connection);
   }

   public final void sendOutdatedClientPacket() {
      OutputStream stream = new OutputStream(1);
      stream.writeByte(6);
      ChannelFuture future = this.session.write(stream);
      if (future != null) {
         future.addListener(ChannelFutureListener.CLOSE);
      } else {
         this.session.getChannel().close();
         System.err.println("Outdated client packet sent and close session.");
      }

   }

   public final void sendStartUpPacket() {
      OutputStream stream = new OutputStream(1 + Constants.GRAB_SERVER_KEYS.length * 4);
      stream.writeByte(0);
      int[] var5;
      int var4 = (var5 = Constants.GRAB_SERVER_KEYS).length;

      for(int var3 = 0; var3 < var4; ++var3) {
         int key = var5[var3];
         stream.writeInt(key);
      }

      this.session.write(stream);
   }

   public final void sendCacheArchive(int indexId, int containerId, boolean priority) {
      if (indexId == 255 && containerId == 255) {
         this.session.write(getUkeysFile());
      } else {
         this.session.write(this.getArchivePacketData(indexId, containerId, priority));
      }

   }

   public final ChannelBuffer getArchivePacketData(int indexId, int archiveId, boolean priority) {
      byte[] archive = indexId == 255 ? Cache.STORE.getIndex255().getArchiveData(archiveId) : Cache.STORE.getIndexes()[indexId].getMainFile().getArchiveData(archiveId);
      if (archive != null && priority) {
         int compression = archive[0] & 255;
         int length = ((archive[1] & 255) << 24) + ((archive[2] & 255) << 16) + ((archive[3] & 255) << 8) + (archive[4] & 255);
         int settings = compression;
         if (!priority) {
            settings = compression | 128;
         }

         ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
         buffer.writeByte(indexId);
         buffer.writeInt(archiveId);
         buffer.writeByte(settings);
         buffer.writeInt(length);
         int realLength = compression != 0 ? length + 4 : length;

         int v;
         for(v = 5; v < realLength + 5; ++v) {
            if (buffer.writerIndex() % 512 == 0) {
               buffer.writeByte(255);
            }

            buffer.writeByte(archive[v]);
         }

         v = this.encryptionValue;
         if (v != 0) {
            for(int i = 0; i < buffer.arrayOffset(); ++i) {
               buffer.setByte(i, buffer.getByte(i) ^ v);
            }
         }

         return buffer;
      } else {
         return null;
      }
   }

   public static final OutputStream getContainerPacketData(int indexFileId, int containerId, byte[] archive) {
      OutputStream stream = new OutputStream(archive.length + 4);
      stream.writeByte(indexFileId);
      stream.writeInt(containerId);
      stream.writeByte(0);
      stream.writeInt(archive.length);
      int offset = 10;
      byte[] var8 = archive;
      int var7 = archive.length;

      for(int var6 = 0; var6 < var7; ++var6) {
         byte element = var8[var6];
         if (offset == 512) {
            stream.writeByte(255);
            offset = 1;
         }

         stream.writeByte(element);
         ++offset;
      }

      return stream;
   }

   public void setEncryptionValue(int encryptionValue) {
      this.encryptionValue = encryptionValue;
   }
}
