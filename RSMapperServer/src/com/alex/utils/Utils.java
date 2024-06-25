package com.alex.utils;

import com.alex.io.OutputStream;
import com.alex.store.Store;
import java.math.BigInteger;

public final class Utils {

	public static byte[] cryptRSA(byte[] data, BigInteger exponent,
			BigInteger modulus) {
		return new BigInteger(data).modPow(exponent, modulus).toByteArray();
   }

	public static byte[] getArchivePacketData(int indexId, int archiveId,
			byte[] archive) {
      OutputStream stream = new OutputStream(archive.length + 4);
      stream.writeByte(indexId);
      stream.writeShort(archiveId);
      stream.writeByte(0);
      stream.writeInt(archive.length);
      int offset = 8;

      for(int index = 0; index < archive.length; ++index) {
         if (offset == 512) {
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

   public static final int getInterfaceDefinitionsSize(Store store) {
      return store.getIndexes()[3].getLastArchiveId();
   }

   public static final int getInterfaceDefinitionsComponentsSize(Store store, int interfaceId) {
      return store.getIndexes()[3].getLastFileId(interfaceId);
   }

   public static final int getItemDefinitionsSize(Store store) {
      int lastArchiveId = store.getIndexes()[19].getLastArchiveId();
      return lastArchiveId * 256 + store.getIndexes()[19].getValidFilesCount(lastArchiveId);
   }

   public static final int getObjectDefinitionsSize(Store store) {
      int lastArchiveId = store.getIndexes()[16].getLastArchiveId();
      return lastArchiveId * 256 + store.getIndexes()[16].getValidFilesCount(lastArchiveId);
   }

   public static final int[] getIndexMapping(int map) {
      switch(map) {
      case 0:
         return new int[]{5098, 22};
      case 1:
         return new int[]{8361, 24};
      case 2:
         return new int[]{4226, 22};
      case 3:
         return new int[]{9213, 23};
      case 4:
         return new int[]{2602, 21};
      case 5:
         return new int[]{4201, 16};
      case 6:
         return new int[]{1659, 15};
      default:
         return null;
      }
   }

   private Utils() {
   }
}
