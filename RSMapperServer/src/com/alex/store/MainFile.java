package com.alex.store;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public final class MainFile {
   private static final int IDX_BLOCK_LEN = 6;
   private static final int HEADER_LEN = 8;
   private static final int EXPANDED_HEADER_LEN = 10;
   private static final int BLOCK_LEN = 512;
   private static final int EXPANDED_BLOCK_LEN = 510;
   private static final int TOTAL_BLOCK_LEN = 520;
   private static final ByteBuffer tempBuffer = ByteBuffer.allocateDirect(520);
   private int id;
   private FileChannel index;
   private FileChannel data;
   private boolean newProtocol;

   protected MainFile(int id, RandomAccessFile data, RandomAccessFile index, boolean newProtocol) throws IOException {
      this.id = id;
      this.data = data.getChannel();
      this.index = index.getChannel();
      this.newProtocol = newProtocol;
   }

   public Archive getArchive(int id) {
      return this.getArchive(id, (int[])null);
   }

   public Archive getArchive(int id, int[] keys) {
      byte[] data = this.getArchiveData(id);
      return data == null ? null : new Archive(id, data, keys);
   }

   public byte[] getArchiveData(int archiveId) {
      synchronized(this.data) {
         byte[] var10000;
         try {
            tempBuffer.position(0).limit(6);
            this.index.read(tempBuffer, (long)(archiveId * 6));
            tempBuffer.flip();
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
                  return null;
               }

               int blockSize = remaining > blockLen ? blockLen : remaining;
               tempBuffer.position(0).limit(blockSize + headerLen);
               this.data.read(tempBuffer, (long)(block * 520));
               tempBuffer.flip();
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

            var10000 = (byte[])fileBuffer.flip().array();
         } catch (Exception var15) {
            return null;
         }

         return var10000;
      }
   }

   private static int getMediumInt(ByteBuffer buffer) {
      return (buffer.get() & 255) << 16 | (buffer.get() & 255) << 8 | buffer.get() & 255;
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

      return done;
   }

   public boolean putArchiveData(int archiveId, ByteBuffer archive, int size, boolean exists) {
      synchronized(this.data) {
         try {
            int block;
            if (exists) {
               if ((long)(archiveId * 6 + 6) > this.index.size()) {
                  return false;
               }

               tempBuffer.position(0).limit(6);
               this.index.read(tempBuffer, (long)(archiveId * 6));
               tempBuffer.flip().position(3);
               block = getMediumInt(tempBuffer);
               if (block <= 0 || (long)block > this.data.size() / 520L) {
                  return false;
               }
            } else {
               block = (int)(this.data.size() + 520L - 1L) / 520;
               if (block == 0) {
                  block = 1;
               }
            }

            tempBuffer.position(0);
            putMediumInt(tempBuffer, size);
            putMediumInt(tempBuffer, block);
            tempBuffer.flip();
            this.index.write(tempBuffer, (long)(archiveId * 6));
            int remaining = size;
            int chunk = 0;
            int blockLen = this.newProtocol && archiveId > 65535 ? 510 : 512;

            for(int headerLen = this.newProtocol && archiveId > 65535 ? 10 : 8; remaining > 0; ++chunk) {
               int nextBlock = 0;
               int blockSize;
               if (exists) {
                  tempBuffer.position(0).limit(headerLen);
                  this.data.read(tempBuffer, (long)(block * 520));
                  tempBuffer.flip();
                  int currentChunk;
                  int currentIndex;
                  if (this.newProtocol && archiveId > 65535) {
                     blockSize = tempBuffer.getInt();
                     currentChunk = tempBuffer.getShort() & '\uffff';
                     nextBlock = getMediumInt(tempBuffer);
                     currentIndex = tempBuffer.get() & 255;
                  } else {
                     blockSize = tempBuffer.getShort() & '\uffff';
                     currentChunk = tempBuffer.getShort() & '\uffff';
                     nextBlock = getMediumInt(tempBuffer);
                     currentIndex = tempBuffer.get() & 255;
                  }

                  if (archiveId != blockSize && archiveId <= 65535 || chunk != currentChunk || this.id != currentIndex) {
                     return false;
                  }

                  if (nextBlock < 0 || (long)nextBlock > this.data.size() / 520L) {
                     return false;
                  }
               }

               if (nextBlock == 0) {
                  exists = false;
                  nextBlock = (int)((this.data.size() + 520L - 1L) / 520L);
                  if (nextBlock == 0) {
                     nextBlock = 1;
                  }

                  if (nextBlock == block) {
                     ++nextBlock;
                  }
               }

               if (remaining <= blockLen) {
                  nextBlock = 0;
               }

               tempBuffer.position(0).limit(520);
               if (this.newProtocol && archiveId > 65535) {
                  tempBuffer.putInt(archiveId);
                  tempBuffer.putShort((short)chunk);
                  putMediumInt(tempBuffer, nextBlock);
                  tempBuffer.put((byte)this.id);
               } else {
                  tempBuffer.putShort((short)archiveId);
                  tempBuffer.putShort((short)chunk);
                  putMediumInt(tempBuffer, nextBlock);
                  tempBuffer.put((byte)this.id);
               }

               blockSize = remaining > blockLen ? blockLen : remaining;
               archive.limit(archive.position() + blockSize);
               tempBuffer.put(archive);
               tempBuffer.flip();
               this.data.write(tempBuffer, (long)(block * 520));
               remaining -= blockSize;
               block = nextBlock;
            }

            return true;
         } catch (Exception var15) {
            return false;
         }
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
