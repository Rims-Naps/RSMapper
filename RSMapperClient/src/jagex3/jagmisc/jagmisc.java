package jagex3.jagmisc;

public class jagmisc {
   private static native int ping0(byte var0, byte var1, byte var2, byte var3, long var4);

   public static native boolean init();

   private static native void Quit0();

   public static native long nanoTime();

   public static native long getTotalPhysicalMemory();

   public static native long getAvailablePhysicalMemory();

   public static void quit() {
      Quit0();
   }

   public static int ping(byte b, byte b_3_, byte b_4_, byte b_5_, long l) throws Throwable {
      int i = ping0(b, b_3_, b_4_, b_5_, l);
      if (i < 0) {
         throw new Exception(String.valueOf(i));
      } else {
         return i;
      }
   }
}
