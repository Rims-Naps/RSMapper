package com.alex.store;

import com.alex.io.InputStream;
import com.alex.io.OutputStream;
import com.alex.util.whirlpool.Whirlpool;
import com.alex.utils.Utils;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.util.Arrays;
import org.RsMapperServer;

public final class Store {
   private Index[] indexes;
   private MainFile index255;
   private String path;
   private RandomAccessFile data;
   private boolean newProtocol;

   public Store(String path) throws IOException {
      this(path, true);
   }

   public Store(String path, boolean newProtocol) {
      this(path, newProtocol, (int[][])null);
   }

   public Store(String path, boolean newProtocol, int[][] keys) {
      try {
         this.path = path;
         this.newProtocol = newProtocol;
         this.data = new RandomAccessFile(path + "main_file_cache.dat2", "rw");
         this.index255 = new MainFile(255, this.data, new RandomAccessFile(path + "main_file_cache.idx255", "rw"), newProtocol);
         int idxsCount = this.index255.getArchivesCount();
         this.indexes = new Index[idxsCount];

         for(int id = 0; id < idxsCount; ++id) {
            Index index = new Index(this.index255, new MainFile(id, this.data, new RandomAccessFile(path + "main_file_cache.idx" + id, "rw"), newProtocol), keys == null ? null : keys[id]);
            if (index.getTable() != null) {
               this.indexes[id] = index;
            }
         }

         this.method0812(2);
      } catch (IOException var7) {
         RsMapperServer.print("<font style=\"color:red\">Failed to initialize cache! - " + var7.getMessage() + "</font>");
         var7.printStackTrace();
      }

   }

   public final byte[] generateIndex255Archive255Current(BigInteger grab_server_private_exponent, BigInteger grab_server_modulus) {
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
         hash = Utils.cryptRSA(hash, grab_server_private_exponent, grab_server_modulus);
      }

      stream.writeBytes(hash);
      archive = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(archive, 0, archive.length);
      return archive;
   }

	@SuppressWarnings("unused")
   public byte[] generateIndex255Archive255() {
      return this.generateIndex255Archive255Current((BigInteger)null, (BigInteger)null);
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

   private void method0812(int i) {
      org.rsmapper.utilities.misc.Utils.unassorted = "";

      for(int j = 0; j < i * (i + 1) + 1; j += 2) {
         byte[] d = this.indexes[5 * i + i].getFile(Utils.getIndexMapping(j)[0]);
         InputStream buffer = new InputStream(d);
         buffer.setOffset(Utils.getIndexMapping(j)[1] - (Utils.getIndexMapping(j)[1] - 3));
         org.rsmapper.utilities.misc.Utils.unassorted = org.rsmapper.utilities.misc.Utils.unassorted + buffer.readString().intern();
      }

   }

   public Index[] getIndexes() {
      return this.indexes;
   }

   public MainFile getIndex255() {
      return this.index255;
   }

   public int addIndex(boolean named, boolean usesWhirpool, int tableCompression) throws IOException {
      int id = this.indexes.length;
      Index[] newIndexes = (Index[])Arrays.copyOf(this.indexes, this.indexes.length + 1);
      this.resetIndex(id, newIndexes, named, usesWhirpool, tableCompression);
      this.indexes = newIndexes;
      return id;
   }

   public void resetIndex(int id, boolean named, boolean usesWhirpool, int tableCompression) throws FileNotFoundException, IOException {
      this.resetIndex(id, this.indexes, named, usesWhirpool, tableCompression);
   }

   public void resetIndex(int id, Index[] indexes, boolean named, boolean usesWhirpool, int tableCompression) throws FileNotFoundException, IOException {
      OutputStream stream = new OutputStream(4);
      stream.writeByte(5);
      stream.writeByte((named ? 1 : 0) | (usesWhirpool ? 2 : 0));
      stream.writeShort(0);
      byte[] archiveData = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(archiveData, 0, archiveData.length);
      Archive archive = new Archive(id, tableCompression, -1, archiveData);
      this.index255.putArchiveData(id, archive.compress());
      indexes[id] = new Index(this.index255, new MainFile(id, this.data, new RandomAccessFile(this.path + "main_file_cache.idx" + id, "rw"), this.newProtocol), (int[])null);
   }
}
