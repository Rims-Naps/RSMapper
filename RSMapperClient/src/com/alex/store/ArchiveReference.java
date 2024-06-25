package com.alex.store;

import java.util.Arrays;

public class ArchiveReference {
   private int nameHash;
   private int hash;
   private int compressed;
   private int uncompressed;
   private byte[] whirpool;
   private int flags;
   private int crc;
   private int revision;
   private FileReference[] files;
   private int[] validFileIds;
   private boolean needsFilesSort;
   private boolean updatedRevision;
   public int biggestFileId;

   public void updateRevision() {
      if (!this.updatedRevision) {
         ++this.revision;
         this.updatedRevision = true;
      }
   }

   public int getFlags() {
      return this.flags;
   }

   public void setFlags(int flags) {
      this.flags = flags;
   }

   public int getNameHash() {
      return this.nameHash;
   }

   public int getHash() {
      return this.hash;
   }

   public int getUncompressed() {
      return this.uncompressed;
   }

   public int getCompressed() {
      return this.compressed;
   }

   public void setNameHash(int nameHash) {
      this.nameHash = nameHash;
   }

   public void setHash(int hash) {
      this.hash = hash;
   }

   public void setUncompressed(int uncompressed) {
      this.uncompressed = uncompressed;
   }

   public void setCompressed(int compressed) {
      this.compressed = compressed;
   }

   public byte[] getWhirpool() {
      return this.whirpool;
   }

   public void setWhirpool(byte[] whirpool) {
      this.whirpool = whirpool;
   }

   public int getCRC() {
      return this.crc;
   }

   public void setCrc(int crc) {
      this.crc = crc;
   }

   public int getRevision() {
      return this.revision;
   }

   public FileReference[] getFiles() {
      return this.files;
   }

   public void setFiles(FileReference[] files) {
      this.files = files;
   }

   public void setRevision(int revision) {
      this.revision = revision;
   }

   public int[] getValidFileIds() {
      return this.validFileIds;
   }

   public void setValidFileIds(int[] validFileIds) {
      this.validFileIds = validFileIds;
   }

   public boolean isNeedsFilesSort() {
      return this.needsFilesSort;
   }

   public void setNeedsFilesSort(boolean needsFilesSort) {
      this.needsFilesSort = needsFilesSort;
   }

   public void removeFileReference(int fileId) {
      int[] newValidFileIds = new int[this.validFileIds.length - 1];
      int count = 0;

      for(int id : this.validFileIds) {
         if (id != fileId) {
            newValidFileIds[count++] = id;
         }
      }

      this.validFileIds = newValidFileIds;
      this.files[fileId] = null;
   }

   public void addEmptyFileReference(int fileId) {
      this.needsFilesSort = true;
      int[] newValidFileIds = Arrays.copyOf(this.validFileIds, this.validFileIds.length + 1);
      newValidFileIds[newValidFileIds.length - 1] = fileId;
      this.validFileIds = newValidFileIds;
      if (this.files.length <= fileId) {
         FileReference[] newFiles = Arrays.copyOf(this.files, fileId + 1);
         newFiles[fileId] = new FileReference();
         this.files = newFiles;
      } else {
         this.files[fileId] = new FileReference();
      }
   }

   public void sortFiles() {
      Arrays.sort(this.validFileIds);
      this.needsFilesSort = false;
   }

   public void reset() {
      this.whirpool = null;
      this.updatedRevision = true;
      this.revision = 0;
      this.nameHash = 0;
      this.crc = 0;
      this.files = new FileReference[0];
      this.validFileIds = new int[0];
      this.needsFilesSort = false;
   }

   public void copyHeader(ArchiveReference fromReference) {
      this.setCrc(fromReference.getCRC());
      this.setNameHash(fromReference.getNameHash());
      this.setWhirpool(fromReference.getWhirpool());
      int[] validFiles = fromReference.getValidFileIds();
      this.setValidFileIds(Arrays.copyOf(validFiles, validFiles.length));
      FileReference[] files = fromReference.getFiles();
      this.setFiles(Arrays.copyOf(files, files.length));
   }

   public void setBiggestFileId(int biggestFileId) {
      this.biggestFileId = biggestFileId;
   }
}
