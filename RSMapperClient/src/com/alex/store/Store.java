package com.alex.store;

import com.alex.io.OutputStream;
import com.alex.util.whirlpool.Whirlpool;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.Arrays;

public final class Store {
   private com.alex.store.Index[] indexes;
   private com.alex.store.MainFile index255;
   private String path;
   private RandomAccessFile data;
   private boolean newProtocol;

   public Store(String path) throws IOException {
      this(path, true);
   }

   public Store(String path, boolean newProtocol) throws IOException {
      this(path, newProtocol, null);
   }

   public Store(String path, boolean newProtocol, int[][] keys) throws IOException {
      this.path = path;
      this.newProtocol = newProtocol;
      this.data = new RandomAccessFile(path + "main_file_cache.dat2", "rw");
      this.index255 = new com.alex.store.MainFile(255, this.data, new RandomAccessFile(path + "main_file_cache.idx255", "rw"), newProtocol);
      int idxsCount = this.index255.getArchivesCount();
      this.indexes = new com.alex.store.Index[idxsCount];

      for(int id = 0; id < idxsCount; ++id) {
         if (id == 5 || id == 8 || id == 16 || id == 23) {
            com.alex.store.Index index = new com.alex.store.Index(
               this.index255,
               new com.alex.store.MainFile(id, this.data, new RandomAccessFile(path + "main_file_cache.idx" + id, "rw"), newProtocol),
               keys != null ? keys[id] : null
            );
            if (index.getTable() != null) {
               this.indexes[id] = index;
            }
         }
      }
   }

   public byte[] generateIndex255Archive255Current(BigInteger grab_server_private_exponent, BigInteger grab_server_modulus) {
      OutputStream stream = new OutputStream();
      stream.writeByte(this.getIndexes().length);

      for(int index = 0; index < this.getIndexes().length; ++index) {
         if (this.getIndexes()[index] == null) {
            stream.writeInt(0);
            stream.writeInt(0);
            stream.writeBytes(new byte[64]);
         } else {
            stream.writeInt(this.getIndexes()[index].getCRC());
            stream.writeInt(this.getIndexes()[index].getTable().getRevision());
            stream.writeBytes(this.getIndexes()[index].getWhirlpool());
            if (this.getIndexes()[index].getKeys() != null) {
               int[] ai;
               for(int key : ai = this.getIndexes()[index].getKeys()) {
                  stream.writeInt(key);
               }
            } else {
               for(int i = 0; i < 4; ++i) {
                  stream.writeInt(0);
               }
            }
         }
      }

      byte[] archive = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(archive, 0, archive.length);
      OutputStream hashStream = new OutputStream(65);
      hashStream.writeByte(0);
      hashStream.writeBytes(Whirlpool.getHash(archive, 0, archive.length));
      byte[] hash = new byte[hashStream.getOffset()];
      hashStream.setOffset(0);
      hashStream.getBytes(hash, 0, hash.length);
      if (grab_server_private_exponent != null && grab_server_modulus != null) {
         hash = com.alex.utils.Utils.cryptRSA(hash, grab_server_private_exponent, grab_server_modulus);
      }

      stream.writeBytes(hash);
      archive = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(archive, 0, archive.length);
      return archive;
   }

   public byte[] generateIndex255Archive255() {
      return this.generateIndex255Archive255Current(null, null);
   }

   public byte[] generateIndex255Archive255Outdated() {
      OutputStream stream = new OutputStream(this.indexes.length * 8);

      for(int index = 0; index < this.indexes.length; ++index) {
         if (this.indexes[index] == null) {
            stream.writeInt(0);
            stream.writeInt(0);
         } else {
            stream.writeInt(this.indexes[index].getCRC());
            stream.writeInt(this.indexes[index].getTable().getRevision());
         }
      }

      byte[] archive = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(archive, 0, archive.length);
      return archive;
   }

   public com.alex.store.Index[] getIndexes() {
      return this.indexes;
   }

   public com.alex.store.MainFile getIndex255() {
      return this.index255;
   }

   public int addIndex(boolean named, boolean usesWhirpool, int tableCompression) throws IOException {
      int id = this.indexes.length;
      com.alex.store.Index[] newIndexes = Arrays.copyOf(this.indexes, this.indexes.length + 1);
      this.resetIndex(id, newIndexes, named, usesWhirpool, tableCompression);
      this.indexes = newIndexes;
      return id;
   }

   public void resetIndex(int id, boolean named, boolean usesWhirpool, int tableCompression) throws FileNotFoundException, IOException {
      this.resetIndex(id, this.indexes, named, usesWhirpool, tableCompression);
   }

   public void resetIndex(int id, com.alex.store.Index[] indexes, boolean named, boolean usesWhirpool, int tableCompression) throws FileNotFoundException, IOException {
      OutputStream stream = new OutputStream(4);
      stream.writeByte(5);
      stream.writeByte((named ? 1 : 0) | (usesWhirpool ? 2 : 0));
      stream.writeShort(0);
      byte[] archiveData = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(archiveData, 0, archiveData.length);
      Archive archive = new Archive(id, tableCompression, -1, archiveData);
      this.index255.putArchiveData(id, archive.compress());
      indexes[id] = new com.alex.store.Index(
         this.index255, new com.alex.store.MainFile(id, this.data, new RandomAccessFile(this.path + "main_file_cache.idx" + id, "rw"), this.newProtocol), null
      );
   }
}
