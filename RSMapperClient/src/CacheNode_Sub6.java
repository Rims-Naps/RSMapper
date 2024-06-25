import java.io.IOException;
import java.net.Socket;

public class CacheNode_Sub6 extends CacheNode {
   static int anInt9478;
   protected int itemsCount = 0;
   static Class57 aClass57_9480;
   static int anInt9481;
   static int anInt9482;
   static int anInt9483;
   static int anInt9484;
   static int anInt9485;

   static final Class365 method2311(Socket socket, int i, byte b) throws IOException {
      ++anInt9478;
      return new Class365_Sub1(socket, i);
   }

   public static void method2312(int i) {
      aClass57_9480 = null;
      if (i <= 120) {
         anInt9485 = -122;
      }
   }

   static final String method2313(byte b, long l) {
      ++anInt9481;
      if (~l < -1L && l < 6582952005840035281L) {
         if (l % 37L == 0L) {
            return null;
         } else {
            int i = 0;

            for(long l_1_ = l; ~l_1_ != -1L; l_1_ /= 37L) {
               ++i;
            }

            char c;
            StringBuffer stringbuffer;
            for(stringbuffer = new StringBuffer(i); ~l != -1L; stringbuffer.append(c)) {
               long l_3_ = l;
               l /= 37L;
               c = Class174.aCharArray2095[(int)(l_3_ + -(37L * l))];
               if (~c == -96) {
                  int i_4_ = -1 + stringbuffer.length();
                  stringbuffer.setCharAt(i_4_, Character.toUpperCase(stringbuffer.charAt(i_4_)));
                  c = 160;
               }
            }

            stringbuffer.reverse();
            stringbuffer.setCharAt(0, Character.toUpperCase(stringbuffer.charAt(0)));
            return stringbuffer.toString();
         }
      } else {
         return null;
      }
   }

   private final void numberOfItemsInInventory(int i, Buffer buffer) {
      if (i == 2) {
         this.itemsCount = buffer.readUnsignedShort();
      }

      ++anInt9484;
   }

   final void method2315(Buffer buffer) {
      while(true) {
         int i_5_ = buffer.readUnsignedByte();
         if (i_5_ == 0) {
            ++anInt9482;
            return;
         }

         this.numberOfItemsInInventory(i_5_, buffer);
      }
   }
}
