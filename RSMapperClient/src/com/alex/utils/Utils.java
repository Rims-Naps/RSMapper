package com.alex.utils;

import com.alex.io.OutputStream;
import com.alex.store.Store;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;

public final class Utils {
   public static byte[] cryptRSA(byte[] data, BigInteger exponent, BigInteger modulus) {
      return new BigInteger(data).modPow(exponent, modulus).toByteArray();
   }

   public static byte[] getArchivePacketData(int indexId, int archiveId, byte[] archive) {
      OutputStream stream = new OutputStream(archive.length + 4);
      stream.writeByte(indexId);
      stream.writeShort(archiveId);
      stream.writeByte(0);
      stream.writeInt(archive.length);
      int offset = 8;

      for(int index = 0; index < archive.length; ++index) {
         if (offset == 102400) {
            stream.writeByte(-1);
            offset = 1;
         }

         stream.writeByte(archive[index]);
         ++offset;
      }

      byte[] packet = new byte[stream.getOffset()];
      stream.setOffset(0);
      stream.getBytes(packet, 0, packet.length);
      return packet;
   }

   public static int getNameHash(String name) {
      return name.toLowerCase().hashCode();
   }

   public static int getInterfaceDefinitionsSize(Store store) {
      return store.getIndexes()[3].getLastArchiveId();
   }

   public static int getInterfaceDefinitionsComponentsSize(Store store, int interfaceId) {
      return store.getIndexes()[3].getLastFileId(interfaceId);
   }

   public static int getItemDefinitionsSize(Store store) {
      return getDefinitionsSize(store.getIndexes()[19], com.alex.utils.Utils.Js5ConfigGroup.ObjectsConfigGroup);
   }

   public static int getDefinitionsSize(com.alex.store.Index index, com.alex.utils.Utils.Js5ConfigGroup configGroup) {
      if (index != null) {
         if (configGroup.method1306() > 1) {
            int i = index.getLastArchiveId();
            return i * configGroup.method1306() + index.getTable().getArchives()[i].biggestFileId;
         } else {
            return index.getTable().getArchives()[configGroup.archiveId].biggestFileId;
         }
      } else {
         return 0;
      }
   }

   private Utils() {
   }

   public static int getItemDefinitionsSize() {
      return 0;
   }

   public static int getHashMapSize(int size) {
      size = --size | size >>> -1810941663;
      size |= size >>> 2010624802;
      size |= size >>> 10996420;
      size |= size >>> 491045480;
      size |= size >>> 1388313616;
      return 1 + size;
   }

   public static byte[] getBytesFromFile(File file) throws IOException {
      FileInputStream is = new FileInputStream(file);
      long length = file.length();
      byte[] bytes = new byte[(int)length];
      int offset = 0;
      boolean numRead = false;

      int numRead1;
      while(offset < bytes.length && (numRead1 = is.read(bytes, offset, bytes.length - offset)) >= 0) {
         offset += numRead1;
      }

      if (offset < bytes.length) {
         throw new IOException("Could not completely read file " + file.getName());
      } else {
         is.close();
         return bytes;
      }
   }

   public static int getNPCDefinitionsSize(Store store) {
      int lastArchiveId = store.getIndexes()[18].getLastArchiveId();
      return lastArchiveId * 128 + store.getIndexes()[18].getValidFilesCount(lastArchiveId);
   }

   public static int getOSRSNPCDefinitionsSize(Store store) {
      return store.getIndexes()[2].getValidFilesCount(9);
   }

   public static int getOSRSItemDefinitionsSize(Store store) {
      return store.getIndexes()[2].getValidFilesCount(10);
   }

   public static int getObjectDefinitionsSize(Store store) {
      int lastArchiveId = store.getIndexes()[16].getLastArchiveId();
      return lastArchiveId * 256 + store.getIndexes()[16].getValidFilesCount(lastArchiveId);
   }

   public static int getAnimationDefinitionsSize(Store store) {
      int lastArchiveId = store.getIndexes()[20].getLastArchiveId();
      return lastArchiveId * 128 + store.getIndexes()[20].getValidFilesCount(lastArchiveId);
   }

   public static int getGraphicsDefinitionsSize(Store store) {
      int lastArchiveId = store.getIndexes()[21].getLastArchiveId();
      return lastArchiveId * 256 + store.getIndexes()[21].getValidFilesCount(lastArchiveId);
   }

   public static class Js5ConfigGroup {
      public static com.alex.utils.Utils.Js5ConfigGroup ObjectsConfigGroup = new com.alex.utils.Utils.Js5ConfigGroup(6, 8);
      int groupSize;
      public int archiveId;

      Js5ConfigGroup(int var1, int var2) {
         this.archiveId = var1;
         this.groupSize = var2;
      }

      public int method1305(int var1) {
         return var1 & (1 << this.groupSize) - 1;
      }

      public int method1306() {
         return 1 << this.groupSize;
      }

      public int method1307(int var1) {
         return var1 >>> this.groupSize;
      }
   }
}
