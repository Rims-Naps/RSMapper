package com.alex.store;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public final class MainFile {
   private static final int IDX_BLOCK_LEN = 6;
   private static final int HEADER_LEN = 8;
   private static final int EXPANDED_HEADER_LEN = 10;
   private static final int BLOCK_LEN = 512;
   private static final int EXPANDED_BLOCK_LEN = 510;
   private static final int TOTAL_BLOCK_LEN = 520;
   private static final ByteBuffer tempBuffer = ByteBuffer.allocateDirect(520);
   private byte[][] cachedArchives;
   private int id;
   private FileChannel index;
   private FileChannel data;
   private boolean newProtocol;

   protected MainFile(int id, RandomAccessFile data, RandomAccessFile index, boolean newProtocol) throws IOException {
      this.id = id;
      this.data = data.getChannel();
      this.index = index.getChannel();
      this.newProtocol = newProtocol;
      this.resetCachedArchives();
   }

   public Archive getArchive(int id) {
      return this.getArchive(id, null);
   }

   public Archive getArchive(int id, int[] keys) {
      byte[] data = this.getCachedArchiveData(id);
      return data == null ? null : new Archive(id, data, keys);
   }

   public byte[] getCachedArchiveData(int id) {
      byte[] data;
      if (this.cachedArchives[id] == null) {
         data = this.cachedArchives[id] = this.getArchiveData(id);
      } else {
         data = this.cachedArchives[id];
      }

      return data;
   }

   public void resetCachedArchives() throws IOException {
      this.cachedArchives = new byte[this.getArchivesCount()][];
   }

   public byte[] getArchiveData(int archiveId) {
      synchronized(this.data) {
         byte[] var10000;
         try {
            ((java.nio.Buffer)tempBuffer).position(0).limit(6);
            this.index.read(tempBuffer, (long)archiveId * 6L);
            ((java.nio.Buffer)tempBuffer).flip();
            int size = getMediumInt(tempBuffer);
            int block = getMediumInt(tempBuffer);
            if (size < 0) {
               return null;
            }

            if (block <= 0 || (long)block > this.data.size() / 520L) {
               return null;
            }

            ByteBuffer fileBuffer = ByteBuffer.allocate(size);
            int remaining = size;
            int chunk = 0;
            int blockLen = this.newProtocol && archiveId > 65535 ? 510 : 512;

            for(int headerLen = this.newProtocol && archiveId > 65535 ? 10 : 8; remaining > 0; ++chunk) {
               if (block == 0) {
                  System.out.println(archiveId + ", " + this.newProtocol);
                  return null;
               }

               int blockSize = remaining > blockLen ? blockLen : remaining;
               ((java.nio.Buffer)tempBuffer).position(0).limit(blockSize + headerLen);
               this.data.read(tempBuffer, (long)block * 520L);
               ((java.nio.Buffer)tempBuffer).flip();
               int currentFile;
               int currentChunk;
               int nextBlock;
               int currentIndex;
               if (this.newProtocol && archiveId > 65535) {
                  currentFile = tempBuffer.getInt();
                  currentChunk = tempBuffer.getShort() & '\uffff';
                  nextBlock = getMediumInt(tempBuffer);
                  currentIndex = tempBuffer.get() & 255;
               } else {
                  currentFile = tempBuffer.getShort() & '\uffff';
                  currentChunk = tempBuffer.getShort() & '\uffff';
                  nextBlock = getMediumInt(tempBuffer);
                  currentIndex = tempBuffer.get() & 255;
               }

               if (archiveId != currentFile && archiveId <= 65535 || chunk != currentChunk || this.id != currentIndex) {
                  return null;
               }

               if (nextBlock < 0 || (long)nextBlock > this.data.size() / 520L) {
                  return null;
               }

               fileBuffer.put(tempBuffer);
               remaining -= blockSize;
               block = nextBlock;
            }

            var10000 = (byte[])((java.nio.Buffer)fileBuffer).flip().array();
         } catch (Exception var15) {
            var15.printStackTrace();
            return null;
         }

         return var10000;
      }
   }

   private static int getMediumInt(ByteBuffer buffer) {
      return (buffer.get() & 0xFF) << 16 | (buffer.get() & 0xFF) << 8 | buffer.get() & 0xFF;
   }

   private static void putMediumInt(ByteBuffer buffer, int val) {
      buffer.put((byte)(val >> 16));
      buffer.put((byte)(val >> 8));
      buffer.put((byte)val);
   }

   public boolean putArchive(Archive archive) {
      return this.putArchiveData(archive.getId(), archive.getData());
   }

   public boolean putArchiveData(int id, byte[] archive) {
      ByteBuffer buffer = ByteBuffer.wrap(archive);
      boolean done = this.putArchiveData(id, buffer, archive.length, true);
      if (!done) {
         done = this.putArchiveData(id, buffer, archive.length, false);
      }

      if (id >= this.cachedArchives.length) {
         this.cachedArchives = Arrays.copyOf((byte[][])this.cachedArchives, id + 1);
      }

      this.cachedArchives[id] = archive;
      return done;
   }

   public boolean putArchiveData(int archiveId, ByteBuffer archive, int size, boolean exists) {
      synchronized(this.data) {
         try {
            long block;
            if (exists) {
               if ((long)archiveId * 6L + 6L > this.index.size()) {
                  return false;
               }

               ((java.nio.Buffer)tempBuffer).position(0).limit(6);
               this.index.read(tempBuffer, (long)archiveId * 6L);
               ((java.nio.Buffer)tempBuffer).flip().position(3);
               block = (long)getMediumInt(tempBuffer);
               if (block <= 0L || block > this.data.size() / 520L) {
                  return false;
               }
            } else {
               block = (this.data.size() + 520L - 1L) / 520L;
               if (block == 0L) {
                  block = 1L;
               }
            }

            ((java.nio.Buffer)tempBuffer).position(0);
            putMediumInt(tempBuffer, size);
            putMediumInt(tempBuffer, (int)block);
            ((java.nio.Buffer)tempBuffer).flip();
            this.index.write(tempBuffer, (long)archiveId * 6L);
            int remaining = size;
            int chunk = 0;
            int blockLen = this.newProtocol && archiveId > 65535 ? 510 : 512;

            for(int headerLen = this.newProtocol && archiveId > 65535 ? 10 : 8; remaining > 0; ++chunk) {
               long nextBlock = 0L;
               if (exists) {
                  ((java.nio.Buffer)tempBuffer).position(0).limit(headerLen);
                  this.data.read(tempBuffer, block * 520L);
                  ((java.nio.Buffer)tempBuffer).flip();
                  int currentFile;
                  int currentChunk;
                  int currentIndex;
                  if (this.newProtocol && archiveId > 65535) {
                     currentFile = tempBuffer.getInt();
                     currentChunk = tempBuffer.getShort() & '\uffff';
                     nextBlock = (long)getMediumInt(tempBuffer);
                     currentIndex = tempBuffer.get() & 255;
                  } else {
                     currentFile = tempBuffer.getShort() & '\uffff';
                     currentChunk = tempBuffer.getShort() & '\uffff';
                     nextBlock = (long)getMediumInt(tempBuffer);
                     currentIndex = tempBuffer.get() & 255;
                  }

                  if (archiveId != currentFile && archiveId <= 65535 || chunk != currentChunk || this.id != currentIndex) {
                     return false;
                  }

                  if (nextBlock < 0L || nextBlock > this.data.size() / 520L) {
                     return false;
                  }
               }

               if (nextBlock == 0L) {
                  exists = false;
                  nextBlock = (this.data.size() + 520L - 1L) / 520L;
                  if (nextBlock == 0L) {
                     nextBlock = 1L;
                  }

                  if (nextBlock == block) {
                     ++nextBlock;
                  }
               }

               if (remaining <= blockLen) {
                  nextBlock = 0L;
               }

               ((java.nio.Buffer)tempBuffer).position(0).limit(520);
               if (this.newProtocol && archiveId > 65535) {
                  tempBuffer.putInt(archiveId);
                  tempBuffer.putShort((short)chunk);
                  putMediumInt(tempBuffer, (int)nextBlock);
                  tempBuffer.put((byte)this.id);
               } else {
                  tempBuffer.putShort((short)archiveId);
                  tempBuffer.putShort((short)chunk);
                  putMediumInt(tempBuffer, (int)nextBlock);
                  tempBuffer.put((byte)this.id);
               }

               int blockSize = remaining > blockLen ? blockLen : remaining;
               ((java.nio.Buffer)archive).limit(archive.position() + blockSize);
               tempBuffer.put(archive);
               ((java.nio.Buffer)tempBuffer).flip();
               this.data.write(tempBuffer, block * 520L);
               remaining -= blockSize;
               block = nextBlock;
            }
         } catch (Exception var17) {
            var17.printStackTrace();
            return false;
         }

         return true;
      }
   }

   public int getId() {
      return this.id;
   }

   public int getArchivesCount() throws IOException {
      synchronized(this.index) {
         return (int)(this.index.size() / 6L);
      }
   }
}
