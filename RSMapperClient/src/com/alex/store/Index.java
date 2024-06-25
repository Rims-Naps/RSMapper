package com.alex.store;

import com.alex.io.InputStream;
import com.alex.io.OutputStream;
import com.alex.util.crc32.CRC32HGenerator;
import com.alex.util.whirlpool.Whirlpool;
import java.util.Random;

public final class Index {
   private com.alex.store.MainFile mainFile;
   private com.alex.store.MainFile index255;
   private com.alex.store.ReferenceTable table;
   private byte[][][] cachedFiles;
   private int crc;
   private byte[] whirlpool;

   protected Index(com.alex.store.MainFile index255, com.alex.store.MainFile mainFile, int[] keys) {
      this.mainFile = mainFile;
      this.index255 = index255;
      byte[] archiveData = index255.getArchiveData(this.getId());
      if (archiveData != null) {
         this.crc = CRC32HGenerator.getHash(archiveData);
         this.whirlpool = Whirlpool.getHash(archiveData, 0, archiveData.length);
         Archive archive = new Archive(this.getId(), archiveData, keys);
         if (archive.getData() == null) {
            System.out.println("The data in the archive is null. " + archive.getId());
         } else {
            this.table = new com.alex.store.ReferenceTable(archive);
            if (this.table == null) {
               System.out.println("The table in the archive is null. " + archive.getId());
            }

            this.resetCachedFiles();
         }
      }
   }

   public void resetCachedFiles() {
      this.cachedFiles = new byte[this.getLastArchiveId() + 1][][];
   }

   public int getLastFileId(int archiveId) {
      return !this.archiveExists(archiveId) ? -1 : this.table.getArchives()[archiveId].getFiles().length - 1;
   }

   public int getLastArchiveId() {
      return this.table.getArchives().length - 1;
   }

   public int getValidArchivesCount() {
      return this.table.getValidArchiveIds().length;
   }

   public int getValidFilesCount(int archiveId) {
      return !this.archiveExists(archiveId) ? -1 : this.table.getArchives()[archiveId].getValidFileIds().length;
   }

   public boolean archiveExists(int archiveId) {
      if (archiveId < 0) {
         return false;
      } else {
         ArchiveReference[] archives = this.table.getArchives();
         return archives.length > archiveId && archives[archiveId] != null;
      }
   }

   public boolean fileExists(int archiveId, int fileId) {
      if (!this.archiveExists(archiveId)) {
         return false;
      } else {
         FileReference[] files = this.table.getArchives()[archiveId].getFiles();
         return files.length > fileId && files[fileId] != null;
      }
   }

   public int getArchiveId(String name) {
      int nameHash = com.alex.utils.Utils.getNameHash(name);
      ArchiveReference[] archives = this.table.getArchives();
      int[] validArchiveIds = this.table.getValidArchiveIds();

      for(int archiveId : validArchiveIds) {
         if (archives[archiveId].getNameHash() == nameHash) {
            return archiveId;
         }
      }

      return -1;
   }

   public int getFileId(int archiveId, String name) {
      if (!this.archiveExists(archiveId)) {
         return -1;
      } else {
         int nameHash = com.alex.utils.Utils.getNameHash(name);
         FileReference[] files = this.table.getArchives()[archiveId].getFiles();
         int[] validFileIds = this.table.getArchives()[archiveId].getValidFileIds();

         for(int index = 0; index < validFileIds.length; ++index) {
            int fileId = validFileIds[index];
            if (files[fileId].getNameHash() == nameHash) {
               return fileId;
            }
         }

         return -1;
      }
   }

   public byte[] getFile(int archiveId) {
      return !this.archiveExists(archiveId) ? null : this.getFile(archiveId, this.table.getArchives()[archiveId].getValidFileIds()[0]);
   }

   public byte[] getFile(int archiveId, int fileId) {
      return this.getFile(archiveId, fileId, null);
   }

   public byte[] getFile(String archiveName, String fileName) {
      int ar = 0;
      int archiveId = -1;

      ArchiveReference[] var8;
      for(ArchiveReference a : var8 = this.table.getArchives()) {
         if (this.archiveExists(ar) && a.getNameHash() == archiveName.hashCode()) {
            archiveId = ar;
            break;
         }

         ++ar;
      }

      int fi = 0;
      int fileId = -1;

      FileReference[] var10;
      for(FileReference f : var10 = this.table.getArchives()[archiveId].getFiles()) {
         if (this.fileExists(archiveId, fi) && f.getNameHash() == fileName.hashCode()) {
            fileId = fi;
            break;
         }

         ++fi;
      }

      return this.getFile(archiveId, fileId);
   }

   public byte[] getFile(int archiveId, int fileId, int[] keys) {
      try {
         if (!this.fileExists(archiveId, fileId)) {
            return null;
         } else {
            if (this.cachedFiles[archiveId] == null || this.cachedFiles[archiveId][fileId] == null) {
               this.cacheArchiveFiles(archiveId, keys);
            }

            byte[] file = this.cachedFiles[archiveId][fileId];
            this.cachedFiles[archiveId][fileId] = null;
            return file;
         }
      } catch (Throwable var5) {
         var5.printStackTrace();
         return null;
      }
   }

   public boolean packIndex(Store originalStore) {
      return this.packIndex(originalStore, false);
   }

   public boolean packIndex(Store originalStore, boolean checkCRC) {
      try {
         return this.packIndex(this.getId(), originalStore, checkCRC);
      } catch (Exception var4) {
         var4.printStackTrace();
         return this.packIndex(this.getId(), originalStore, checkCRC);
      }
   }

   public boolean packIndex(int id, Store originalStore, boolean checkCRC) {
      try {
         com.alex.store.Index originalIndex = originalStore.getIndexes()[id];

         int[] var8;
         for(int archiveId : var8 = originalIndex.table.getValidArchiveIds()) {
            if ((
                  !checkCRC
                     || !this.archiveExists(archiveId)
                     || originalIndex.table.getArchives()[archiveId].getCRC() != this.table.getArchives()[archiveId].getCRC()
               )
               && !this.putArchive(id, archiveId, originalStore, false, false)) {
               return false;
            }
         }

         if (!this.rewriteTable()) {
            return false;
         } else {
            this.resetCachedFiles();
            return true;
         }
      } catch (Exception var9) {
         return true;
      }
   }

   public boolean putArchive(int archiveId, Store originalStore) {
      return this.putArchive(this.getId(), archiveId, originalStore, true, true);
   }

   public boolean putArchive(int archiveId, Store originalStore, boolean rewriteTable, boolean resetCache) {
      return this.putArchive(this.getId(), archiveId, originalStore, rewriteTable, resetCache);
   }

   public boolean putArchive(int id, int archiveId, Store originalStore, boolean rewriteTable, boolean resetCache) {
      try {
         com.alex.store.Index originalIndex = originalStore.getIndexes()[id];
         byte[] data = originalIndex.getMainFile().getArchiveData(archiveId);
         if (data == null) {
            return false;
         } else {
            if (!this.archiveExists(archiveId)) {
               this.table.addEmptyArchiveReference(archiveId);
            }

            ArchiveReference reference = this.table.getArchives()[archiveId];
            reference.updateRevision();
            ArchiveReference originalReference = originalIndex.table.getArchives()[archiveId];
            reference.copyHeader(originalReference);
            int revision = reference.getRevision();
            data[data.length - 2] = (byte)(revision >> 8);
            data[data.length - 1] = (byte)revision;
            if (!this.mainFile.putArchiveData(archiveId, data)) {
               return false;
            } else if (rewriteTable && !this.rewriteTable()) {
               return false;
            } else {
               if (resetCache) {
                  this.resetCachedFiles();
               }

               return true;
            }
         }
      } catch (Exception var11) {
         return true;
      }
   }

   public boolean putFile(int archiveId, int fileId, byte[] data) {
      return this.putFile(archiveId, fileId, 2, data, null, true, true, -1, -1);
   }

   public boolean removeFile(int archiveId, int fileId) {
      return this.removeFile(archiveId, fileId, 2, null);
   }

   public boolean removeFile(int archiveId, int fileId, int compression, int[] keys) {
      if (!this.fileExists(archiveId, fileId)) {
         return false;
      } else {
         this.cacheArchiveFiles(archiveId, keys);
         ArchiveReference reference = this.table.getArchives()[archiveId];
         reference.removeFileReference(fileId);
         int filesCount = this.getValidFilesCount(archiveId);
         byte[] archiveData;
         if (filesCount == 1) {
            archiveData = this.getFile(archiveId, reference.getValidFileIds()[0], keys);
         } else {
            int[] filesSize = new int[filesCount];
            OutputStream stream = new OutputStream();

            for(int index = 0; index < filesCount; ++index) {
               int id = reference.getValidFileIds()[index];
               byte[] fileData = this.getFile(archiveId, id, keys);
               filesSize[index] = fileData.length;
               stream.writeBytes(fileData);
            }

            for(int index = 0; index < filesSize.length; ++index) {
               int offset = filesSize[index];
               if (index != 0) {
                  offset -= filesSize[index - 1];
               }

               stream.writeInt(offset);
            }

            stream.writeByte(1);
            archiveData = new byte[stream.getOffset()];
            stream.setOffset(0);
            stream.getBytes(archiveData, 0, archiveData.length);
         }

         reference.updateRevision();
         Archive archive = new Archive(archiveId, compression, reference.getRevision(), archiveData);
         byte[] closedArchive = archive.compress();
         reference.setCrc(CRC32HGenerator.getHash(closedArchive, 0, closedArchive.length - 2));
         reference.setWhirpool(Whirlpool.getHash(closedArchive, 0, closedArchive.length - 2));
         if (!this.mainFile.putArchiveData(archiveId, closedArchive)) {
            return false;
         } else if (!this.rewriteTable()) {
            return false;
         } else {
            this.resetCachedFiles();
            return true;
         }
      }
   }

   public boolean putFile(
      int archiveId, int fileId, int compression, byte[] data, int[] keys, boolean rewriteTable, boolean resetCache, int archiveName, int fileName
   ) {
      if (!this.archiveExists(archiveId)) {
         this.table.addEmptyArchiveReference(archiveId);
         this.resetCachedFiles();
         this.cachedFiles[archiveId] = new byte[1][];
      } else {
         this.cacheArchiveFiles(archiveId, keys);
      }

      ArchiveReference reference = this.table.getArchives()[archiveId];
      if (!this.fileExists(archiveId, fileId)) {
         reference.addEmptyFileReference(fileId);
      }

      reference.sortFiles();
      int filesCount = this.getValidFilesCount(archiveId);
      byte[] archiveData;
      if (filesCount == 1) {
         archiveData = data;
      } else {
         int[] filesSize = new int[filesCount];
         OutputStream stream = new OutputStream();

         for(int index = 0; index < filesCount; ++index) {
            int id = reference.getValidFileIds()[index];
            byte[] fileData;
            if (id == fileId) {
               fileData = data;
            } else {
               fileData = this.getFile(archiveId, id, keys);
            }

            filesSize[index] = fileData.length;
            stream.writeBytes(fileData);
         }

         for(int index = 0; index < filesCount; ++index) {
            int offset = filesSize[index];
            if (index != 0) {
               offset -= filesSize[index - 1];
            }

            stream.writeInt(offset);
         }

         stream.writeByte(1);
         archiveData = new byte[stream.getOffset()];
         stream.setOffset(0);
         stream.getBytes(archiveData, 0, archiveData.length);
      }

      reference.updateRevision();
      Archive archive = new Archive(archiveId, compression, reference.getRevision(), archiveData);
      byte[] closedArchive = archive.compress();
      reference.setCrc(CRC32HGenerator.getHash(closedArchive, 0, closedArchive.length - 2));
      reference.setWhirpool(Whirlpool.getHash(closedArchive, 0, closedArchive.length - 2));
      if (archiveName != -1) {
         reference.setNameHash(archiveName);
      }

      if (fileName != -1) {
         reference.getFiles()[fileId].setNameHash(fileName);
      }

      if (!this.mainFile.putArchiveData(archiveId, closedArchive)) {
         return false;
      } else if (rewriteTable && !this.rewriteTable()) {
         return false;
      } else {
         if (resetCache) {
            this.resetCachedFiles();
         }

         return true;
      }
   }

   public int[] generateKeys() {
      int[] keys = new int[4];

      for(int index = 0; index < keys.length; ++index) {
         keys[index] = new Random().nextInt();
      }

      return keys;
   }

   public boolean encryptArchive(int archiveId, int[] keys) {
      return this.encryptArchive(archiveId, null, keys, true, true);
   }

   public boolean encryptArchive(int archiveId, int[] oldKeys, int[] keys, boolean rewriteTable, boolean resetCache) {
      if (!this.archiveExists(archiveId)) {
         return false;
      } else {
         Archive archive = this.mainFile.getArchive(archiveId, oldKeys);
         if (archive == null) {
            return false;
         } else {
            ArchiveReference reference = this.table.getArchives()[archiveId];
            if (reference.getRevision() != archive.getRevision()) {
               throw new RuntimeException("ERROR REVISION");
            } else {
               reference.updateRevision();
               archive.setRevision(reference.getRevision());
               archive.setKeys(keys);
               byte[] closedArchive = archive.compress();
               reference.setCrc(CRC32HGenerator.getHash(closedArchive, 0, closedArchive.length - 2));
               reference.setWhirpool(Whirlpool.getHash(closedArchive, 0, closedArchive.length - 2));
               if (!this.mainFile.putArchiveData(archiveId, closedArchive)) {
                  return false;
               } else if (rewriteTable && !this.rewriteTable()) {
                  return false;
               } else {
                  if (resetCache) {
                     this.resetCachedFiles();
                  }

                  return true;
               }
            }
         }
      }
   }

   public boolean rewriteTable() {
      this.table.updateRevision();
      this.table.sortTable();
      Object[] hashes = this.table.encodeHeader(this.index255);
      if (hashes == null) {
         return false;
      } else {
         this.whirlpool = (byte[])hashes[1];
         return true;
      }
   }

   public void setKeys(int[] keys) {
      this.table.setKeys(keys);
   }

   public int[] getKeys() {
      return this.table.getKeys();
   }

   private void cacheArchiveFiles(int archiveId, int[] keys) {
      Archive archive = this.getArchive(archiveId, keys);
      int lastFileId = this.getLastFileId(archiveId);
      this.cachedFiles[archiveId] = new byte[lastFileId + 1][];
      if (archive != null) {
         byte[] data = archive.getData();
         if (data != null) {
            int filesCount = this.getValidFilesCount(archiveId);
            if (filesCount == 1) {
               this.cachedFiles[archiveId][lastFileId] = data;
            } else {
               int readPosition = data.length;
               int amtOfLoops = data[--readPosition] & 255;
               readPosition -= amtOfLoops * filesCount * 4;
               InputStream stream = new InputStream(data);
               stream.setOffset(readPosition);
               int[] filesSize = new int[filesCount];

               for(int loop = 0; loop < amtOfLoops; ++loop) {
                  int offset = 0;

                  for(int i = 0; i < filesCount; ++i) {
                     filesSize[i] += offset += stream.readInt();
                  }
               }

               byte[][] filesData = new byte[filesCount][];

               for(int i = 0; i < filesCount; ++i) {
                  filesData[i] = new byte[filesSize[i]];
                  filesSize[i] = 0;
               }

               stream.setOffset(readPosition);
               int sourceOffset = 0;

               for(int loop = 0; loop < amtOfLoops; ++loop) {
                  int dataRead = 0;

                  for(int i = 0; i < filesCount; ++i) {
                     dataRead += stream.readInt();
                     System.arraycopy(data, sourceOffset, filesData[i], filesSize[i], dataRead);
                     sourceOffset += dataRead;
                     filesSize[i] += dataRead;
                  }
               }

               int count = 0;

               int[] var17;
               for(int fileId : var17 = this.table.getArchives()[archiveId].getValidFileIds()) {
                  this.cachedFiles[archiveId][fileId] = filesData[count++];
               }
            }
         }
      }
   }

   public int getId() {
      return this.mainFile.getId();
   }

   public com.alex.store.ReferenceTable getTable() {
      return this.table;
   }

   public com.alex.store.MainFile getMainFile() {
      return this.mainFile;
   }

   public Archive getArchive(int id) {
      return this.mainFile.getArchive(id, null);
   }

   public Archive getArchive(int id, int[] keys) {
      return this.mainFile.getArchive(id, keys);
   }

   public int getCRC() {
      return this.crc;
   }

   public byte[] getWhirlpool() {
      return this.whirlpool;
   }

   public boolean putArchive(int id, int archiveId, int targetArchiveId, Store originalStore, boolean rewriteTable, boolean resetCache) {
      try {
         com.alex.store.Index originalIndex = originalStore.getIndexes()[id];
         byte[] data = originalIndex.getMainFile().getArchiveData(archiveId);
         if (data == null) {
            return false;
         } else {
            if (!this.archiveExists(targetArchiveId)) {
               this.table.addEmptyArchiveReference(targetArchiveId);
            }

            ArchiveReference reference = this.table.getArchives()[targetArchiveId];
            reference.updateRevision();
            ArchiveReference originalReference = originalIndex.table.getArchives()[archiveId];
            reference.copyHeader(originalReference);
            int revision = reference.getRevision();
            data[data.length - 2] = (byte)(revision >> 8);
            data[data.length - 1] = (byte)revision;
            if (!this.mainFile.putArchiveData(targetArchiveId, data)) {
               return false;
            } else if (rewriteTable && !this.rewriteTable()) {
               return false;
            } else {
               if (resetCache) {
                  this.resetCachedFiles();
               }

               return true;
            }
         }
      } catch (Exception var12) {
         return true;
      }
   }
}
