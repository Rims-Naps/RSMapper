package com.alex.util.bzip2;

import com.apache.CBZip2OutputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class BZip2Compressor {
   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   public static final byte[] compress(byte[] data) {
      ByteArrayOutputStream compressedBytes = new ByteArrayOutputStream();

      try {
         Throwable e = null;
         Object var3 = null;

         try {
            CBZip2OutputStream out = new CBZip2OutputStream(compressedBytes);

            try {
               out.write(data);
               out.close();
            } finally {
               if (out != null) {
                  out.close();
               }
            }
         } catch (Throwable var12) {
            if (e == null) {
               e = var12;
            } else if (e != var12) {
               e.addSuppressed(var12);
            }

            throw e;
         }

         return compressedBytes.toByteArray();
      } catch (Throwable var13) {
         var13.printStackTrace();
         return null;
      }
   }
}
