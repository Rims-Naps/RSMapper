import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class FileOnDisk {
   static int anInt1317;
   static double aDouble1318;
   static boolean aBoolean1319 = false;
   static int anInt1320;
   static int anInt1321;
   static int[] anIntArray1322 = new int[1000];
   static int anInt1323;
   static int anInt1324;
   private RandomAccessFile aRandomAccessFile1325;
   static int anInt1326 = 0;
   static int anInt1327;
   private long aLong1328;
   static int[] anIntArray1329 = new int[2];
   private File aFile1330;
   static byte[][] landFileData;
   static boolean[] aBooleanArray1332;
   static int anInt1333;
   private long aLong1334;

   final void method1098(boolean bool) throws IOException {
      ++anInt1327;
      if (!bool) {
         anIntArray1329 = null;
      }

      if (this.aRandomAccessFile1325 != null) {
         this.aRandomAccessFile1325.close();
         this.aRandomAccessFile1325 = null;
      }
   }

   public static void method1099(int i) {
      if (i != 2) {
         method1099(42);
      }

      landFileData = null;
      aBooleanArray1332 = null;
      anIntArray1329 = null;
      anIntArray1322 = null;
   }

   final void method1100(boolean bool, long l) throws IOException {
      this.aRandomAccessFile1325.seek(l);
      ++anInt1333;
      this.aLong1334 = l;
      if (!bool) {
         this.aLong1328 = -78L;
      }
   }

   final long method1101(int i) throws IOException {
      if (i != 0) {
         this.aLong1334 = -18L;
      }

      ++anInt1317;
      return this.aRandomAccessFile1325.length();
   }

   @Override
   protected final void finalize() throws Throwable {
      ++anInt1321;
      if (this.aRandomAccessFile1325 != null) {
         this.method1098(true);
      }
   }

   final void method1102(byte b, byte[] bs, int i, int i_0_) throws IOException {
      ++anInt1324;
      if (this.aLong1334 + (long)i_0_ > this.aLong1328) {
         this.aRandomAccessFile1325.seek(this.aLong1328);
         this.aRandomAccessFile1325.write(1);
         throw new EOFException();
      } else {
         if (b != 76) {
            method1099(-84);
         }

         this.aRandomAccessFile1325.write(bs, i, i_0_);
         this.aLong1334 += (long)i_0_;
      }
   }

   final int method1103(byte b, int i, byte[] bs, int i_1_) throws IOException {
      if (b != -115) {
         this.method1104(true);
      }

      ++anInt1323;
      int i_2_ = this.aRandomAccessFile1325.read(bs, i_1_, i);
      if (i_2_ > 0) {
         this.aLong1334 += (long)i_2_;
      }

      return i_2_;
   }

   final File method1104(boolean bool) {
      ++anInt1320;
      if (bool) {
         method1099(-16);
      }

      return this.aFile1330;
   }

   FileOnDisk(File file, String string, long l) throws IOException {
      l = Long.MAX_VALUE;
      if (file.length() > l) {
         file.delete();
      }

      this.aRandomAccessFile1325 = new RandomAccessFile(file, string);
      this.aLong1334 = 0L;
      this.aFile1330 = file;
      this.aLong1328 = l;
      int i = this.aRandomAccessFile1325.read();
      if (~i != 0 && !string.equals("r")) {
         this.aRandomAccessFile1325.seek(0L);
         this.aRandomAccessFile1325.write(i);
      }

      this.aRandomAccessFile1325.seek(0L);
   }
}
