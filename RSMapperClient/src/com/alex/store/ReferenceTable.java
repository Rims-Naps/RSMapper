package com.alex.store;

import com.alex.io.InputStream;
import com.alex.io.OutputStream;
import java.util.Arrays;

public final class ReferenceTable {
   public static boolean NEW_PROTOCOL = false;
   private Archive archive;
   private int revision;
   private boolean named;
   private boolean usesWhirpool;
   private ArchiveReference[] archives;
   private int[] validArchiveIds;
   private boolean updatedRevision;
   private boolean needsArchivesSort;

   protected ReferenceTable(Archive archive) {
      this.archive = archive;
      this.decodeHeader();
   }

   public void setKeys(int[] keys) {
      this.archive.setKeys(keys);
   }

   public int[] getKeys() {
      return this.archive.getKeys();
   }

   public void sortArchives() {
      Arrays.sort(this.validArchiveIds);
      this.needsArchivesSort = false;
   }

   public void addEmptyArchiveReference(int archiveId) {
      this.needsArchivesSort = true;
      int[] newValidArchiveIds = Arrays.copyOf(this.validArchiveIds, this.validArchiveIds.length + 1);
      newValidArchiveIds[newValidArchiveIds.length - 1] = archiveId;
      this.validArchiveIds = newValidArchiveIds;
      ArchiveReference reference;
      if (this.archives.length <= archiveId) {
         ArchiveReference[] newArchives = Arrays.copyOf(this.archives, archiveId + 1);
         reference = newArchives[archiveId] = new ArchiveReference();
         this.archives = newArchives;
      } else {
         reference = this.archives[archiveId] = new ArchiveReference();
      }

      reference.reset();
   }

   public void sortTable() {
      if (this.needsArchivesSort) {
         this.sortArchives();
      }

      for(int index = 0; index < this.validArchiveIds.length; ++index) {
         ArchiveReference archive = this.archives[this.validArchiveIds[index]];
         if (archive.isNeedsFilesSort()) {
            archive.sortFiles();
         }
      }
   }

   public Object[] encodeHeader(com.alex.store.MainFile mainFile) {
      OutputStream stream = new OutputStream();

      try {
         int protocol = this.getProtocol();
         stream.writeByte(protocol);
         if (protocol >= 6) {
            stream.writeInt(this.revision);
         }

         stream.writeByte((this.named ? 1 : 0) | (this.usesWhirpool ? 2 : 0));
         if (protocol >= 7) {
            stream.writeBigSmart(this.validArchiveIds.length);
         } else {
            stream.writeShort(this.validArchiveIds.length);
         }

         for(int index = 0; index < this.validArchiveIds.length; ++index) {
            int offset = this.validArchiveIds[index];
            if (index != 0) {
               offset -= this.validArchiveIds[index - 1];
            }

            if (protocol >= 7) {
               stream.writeBigSmart(offset);
            } else {
               stream.writeShort(offset);
            }
         }

         int pHash = this.archive.getHash();
         boolean flag4 = (pHash & 4) != 0;
         boolean flag8 = (pHash & 8) != 0;
         if (this.named) {
            for(int index = 0; index < this.validArchiveIds.length; ++index) {
               stream.writeInt(this.archives[this.validArchiveIds[index]].getNameHash());
            }
         }

         for(int index = 0; index < this.validArchiveIds.length; ++index) {
            stream.writeInt(this.archives[this.validArchiveIds[index]].getCRC());
         }

         if (flag8) {
            for(int index = 0; index < this.validArchiveIds.length; ++index) {
               stream.writeInt(this.archives[this.validArchiveIds[index]].getHash());
            }
         }

         if (this.usesWhirpool) {
            for(int index = 0; index < this.validArchiveIds.length; ++index) {
               stream.writeBytes(this.archives[this.validArchiveIds[index]].getWhirpool());
            }
         }

         if (flag4) {
            for(int index = 0; index < this.validArchiveIds.length; ++index) {
               stream.writeInt(this.archives[this.validArchiveIds[index]].getCompressed());
               stream.writeInt(this.archives[this.validArchiveIds[index]].getUncompressed());
            }
         }

         for(int index = 0; index < this.validArchiveIds.length; ++index) {
            stream.writeInt(this.archives[this.validArchiveIds[index]].getRevision());
         }

         for(int index = 0; index < this.validArchiveIds.length; ++index) {
            int value = this.archives[this.validArchiveIds[index]].getValidFileIds().length;
            if (protocol >= 7) {
               stream.writeBigSmart(value);
            } else {
               stream.writeShort(value);
            }
         }

         for(int index = 0; index < this.validArchiveIds.length; ++index) {
            ArchiveReference archive = this.archives[this.validArchiveIds[index]];

            for(int index2 = 0; index2 < archive.getValidFileIds().length; ++index2) {
               int offset = archive.getValidFileIds()[index2];
               if (index2 != 0) {
                  offset -= archive.getValidFileIds()[index2 - 1];
               }

               if (protocol >= 7) {
                  stream.writeBigSmart(offset);
               } else {
                  stream.writeShort(offset);
               }
            }
         }

         if (this.named) {
            for(int index = 0; index < this.validArchiveIds.length; ++index) {
               ArchiveReference archive = this.archives[this.validArchiveIds[index]];

               for(int index2 = 0; index2 < archive.getValidFileIds().length; ++index2) {
                  stream.writeInt(archive.getFiles()[archive.getValidFileIds()[index2]].getNameHash());
               }
            }
         }

         byte[] data = new byte[stream.getOffset()];
         stream.setOffset(0);
         stream.getBytes(data, 0, data.length);
         return this.archive.editNoRevision(data, mainFile);
      } catch (Exception var11) {
         return this.archives;
      }
   }

   public int getProtocol() {
      if (this.archives.length > 65535) {
         return 7;
      } else {
         for(int index = 0; index < this.validArchiveIds.length; ++index) {
            if (index > 0 && this.validArchiveIds[index] - this.validArchiveIds[index - 1] > 65535) {
               return 7;
            }

            if (this.archives[this.validArchiveIds[index]].getValidFileIds().length > 65535) {
               return 7;
            }
         }

         return this.revision != 0 ? 6 : 5;
      }
   }

   public void setRevision(int revision) {
      this.updatedRevision = true;
      this.revision = revision;
   }

   public void updateRevision() {
      if (!this.updatedRevision) {
         ++this.revision;
         this.updatedRevision = true;
      }
   }

   public void removeArchiveReference(int archiveId) {
      int[] newValidFileIds = new int[this.validArchiveIds.length - 1];
      int count = 0;

      for(int id : this.validArchiveIds) {
         if (id != archiveId) {
            newValidFileIds[count++] = id;
         }
      }

      this.validArchiveIds = newValidFileIds;
      this.archives[archiveId] = null;
      this.needsArchivesSort = true;
   }

   private void decodeHeader() {
      InputStream stream = new InputStream(this.archive.getData());
      int protocol = stream.readUnsignedByte();
      if (protocol >= 5 && protocol <= 7) {
         if (protocol >= 6) {
            this.revision = stream.readInt();
         }

         this.archive.setHash(stream.readUnsignedByte());
         this.named = (1 & this.archive.getHash()) != 0;
         this.usesWhirpool = (2 & this.archive.getHash()) != 0;
         boolean flag4 = (this.archive.getHash() & 4) != 0;
         boolean flag8 = (this.archive.getHash() & 8) != 0;
         int validArchivesCount = protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
         this.validArchiveIds = new int[validArchivesCount];
         int lastArchiveId = 0;
         int biggestArchiveId = 0;

         for(int index = 0; index < validArchivesCount; ++index) {
            int archiveId = lastArchiveId += protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
            if (archiveId > biggestArchiveId) {
               biggestArchiveId = archiveId;
            }

            this.validArchiveIds[index] = archiveId;
         }

         this.archives = new ArchiveReference[biggestArchiveId + 1];

         for(int index = 0; index < validArchivesCount; ++index) {
            this.archives[this.validArchiveIds[index]] = new ArchiveReference();
         }

         if (this.named) {
            for(int index = 0; index < validArchivesCount; ++index) {
               this.archives[this.validArchiveIds[index]].setNameHash(stream.readInt());
            }
         }

         if (NEW_PROTOCOL) {
            for(int index = 0; index < validArchivesCount; ++index) {
               this.archives[this.validArchiveIds[index]].setCrc(stream.readInt());
            }
         }

         if (flag8) {
            for(int i = 0; i < validArchivesCount; ++i) {
               this.archives[this.validArchiveIds[i]].setHash(stream.readInt());
            }
         }

         if (this.usesWhirpool) {
            for(int index = 0; index < validArchivesCount; ++index) {
               byte[] whirpool = new byte[64];
               stream.getBytes(whirpool, 0, 64);
               this.archives[this.validArchiveIds[index]].setWhirpool(whirpool);
            }
         }

         if (flag4) {
            for(int i = 0; i < validArchivesCount; ++i) {
               this.archives[this.validArchiveIds[i]].setCompressed(stream.readInt());
               this.archives[this.validArchiveIds[i]].setUncompressed(stream.readInt());
            }
         }

         if (!NEW_PROTOCOL) {
            for(int index = 0; index < validArchivesCount; ++index) {
               this.archives[this.validArchiveIds[index]].setCrc(stream.readInt());
            }
         }

         for(int index = 0; index < validArchivesCount; ++index) {
            this.archives[this.validArchiveIds[index]].setRevision(stream.readInt());
         }

         for(int index = 0; index < validArchivesCount; ++index) {
            int size = protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
            this.archives[this.validArchiveIds[index]].setValidFileIds(new int[size]);
         }

         for(int index = 0; index < validArchivesCount; ++index) {
            int lastFileId = 0;
            int biggestFileId = 0;
            ArchiveReference archive = this.archives[this.validArchiveIds[index]];

            for(int index2 = 0; index2 < archive.getValidFileIds().length; ++index2) {
               int fileId = lastFileId += protocol >= 7 ? stream.readBigSmart() : stream.readUnsignedShort();
               if (fileId > biggestFileId) {
                  biggestFileId = fileId;
               }

               archive.getValidFileIds()[index2] = fileId;
            }

            archive.setFiles(new FileReference[biggestFileId + 1]);

            for(int index2 = 0; index2 < archive.getValidFileIds().length; ++index2) {
               archive.getFiles()[archive.getValidFileIds()[index2]] = new FileReference();
            }

            archive.setBiggestFileId(biggestFileId + 1);
         }

         if (this.named) {
            for(int index = 0; index < validArchivesCount; ++index) {
               ArchiveReference archive = this.archives[this.validArchiveIds[index]];

               for(int index2 = 0; index2 < archive.getValidFileIds().length; ++index2) {
                  archive.getFiles()[archive.getValidFileIds()[index2]].setNameHash(stream.readInt());
               }
            }
         }
      } else {
         throw new RuntimeException("INVALID PROTOCOL" + protocol);
      }
   }

   public int getRevision() {
      return this.revision;
   }

   public ArchiveReference[] getArchives() {
      return this.archives;
   }

   public int[] getValidArchiveIds() {
      return this.validArchiveIds;
   }

   public boolean isNamed() {
      return this.named;
   }

   public boolean usesWhirpool() {
      return this.usesWhirpool;
   }

   public int getCompression() {
      return this.archive.getCompression();
   }
}
