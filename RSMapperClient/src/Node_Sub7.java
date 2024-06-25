import java.io.IOException;
import java.util.Date;

public class Node_Sub7 extends Node {
   volatile int anInt7060 = -1;
   static int anInt7061;
   static int anInt7062;
   static int anInt7063;
   volatile String aString7064;

   static final void method2421(byte b) {
      ++anInt7061;

      for(CacheNode_Sub4 cachenode_sub4 = (CacheNode_Sub4)Class184.aClass158_2189.method1723(13);
         cachenode_sub4 != null;
         cachenode_sub4 = (CacheNode_Sub4)Class184.aClass158_2189.method1721(0)
      ) {
         if (cachenode_sub4.anInt9462 > 1) {
            cachenode_sub4.anInt9462 = 0;
            Class200_Sub2.aClass61_4941
               .method601(cachenode_sub4, b ^ 25532, ((CacheNode_Sub13)cachenode_sub4.aClass158_9457.aCacheNode1984.aCacheNode7035).aLong9564);
            cachenode_sub4.aClass158_9457.method1722(true);
         }
      }

      Class315.anInt4035 = 0;
      Class21.anInt355 = 0;
      if (b != 98) {
         anInt7063 = 47;
      }

      Class368.aClass312_4549.method3614(-601);
      Class261.aHashTable3306.method1517(false);
      Class184.aClass158_2189.method1722(true);
      Client.method114((byte)118, Class277.aCacheNode_Sub13_3509);
   }

   static final void writeToConsole(byte b, String output) {
      ++anInt7062;
      if (Class210.aStringArray2502 == null) {
         Class147.method1647(87);
      }

      Class247.aCalendar3144.setTime(new Date(Class313.method3650(false)));
      int hour = Class247.aCalendar3144.get(11);
      if (b != 43) {
         anInt7063 = -16;
      }

      int minute = Class247.aCalendar3144.get(12);
      int second = Class247.aCalendar3144.get(13);
      String timeStamp = Integer.toString(hour / 10) + hour % 10 + ":" + minute / 10 + minute % 10 + ":" + second / 10 + second % 10;
      String[] strings = Class106.method1120((byte)-113, output, '\n');

      for(int i_3_ = 0; ~i_3_ > ~strings.length; ++i_3_) {
         for(int i_4_ = Class144_Sub4.anInt6848; i_4_ > 0; --i_4_) {
            Class210.aStringArray2502[i_4_] = Class210.aStringArray2502[-1 + i_4_];
         }

         Class210.aStringArray2502[0] = timeStamp + ": " + strings[i_3_];
         if (Class270_Sub1.aFileOutputStream8027 != null) {
            try {
               Class270_Sub1.aFileOutputStream8027.write(Class320_Sub21.method3763(-128, Class210.aStringArray2502[0] + "\n"));
            } catch (IOException var9) {
            }
         }

         if (~Class144_Sub4.anInt6848 > ~(Class210.aStringArray2502.length + -1)) {
            ++Class144_Sub4.anInt6848;
            if (~Class118.anInt5406 < -1) {
               ++Class118.anInt5406;
            }
         }
      }
   }

   Node_Sub7(String string) {
      this.aString7064 = string;
   }
}
