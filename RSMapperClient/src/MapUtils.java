public class MapUtils {
   public static void readEmptyMapDefinitions(Buffer buffer) {
      while(true) {
         int value = buffer.readUnsignedByte();
         if (value != 0) {
            if (value != 1) {
               if (value <= 49) {
                  buffer.readUnsignedByte();
               }
               continue;
            }

            buffer.readUnsignedByte();
         }

         return;
      }
   }
}
