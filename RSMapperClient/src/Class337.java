import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class Class337 implements Runnable {
   static int anInt4174;
   private Class295[] aClass295Array4175;
   static int anInt4176;
   private volatile boolean aBoolean4177;
   private Class241 aClass241_4178;
   private Thread aThread4179;
   static IncommingPacket aClass192_4180 = new IncommingPacket(94, -1);
   static Class52 aClass52_4181;
   static int anInt4182;
   static int anInt4183;

   final Class295 method3902(int i, int i_0_) {
      ++anInt4182;
      if (this.aClass295Array4175 != null && i_0_ >= 0 && ~this.aClass295Array4175.length < ~i_0_) {
         if (i != 3) {
            this.aBoolean4177 = true;
         }

         return this.aClass295Array4175[i_0_];
      } else {
         return null;
      }
   }

   @Override
   public final void run() {
      ++anInt4176;

      try {
         BufferedReader bufferedreader = new BufferedReader(new InputStreamReader((DataInputStream)this.aClass241_4178.anObject2956));
         String string = bufferedreader.readLine();

         Class371 class371;
         for(class371 = Node_Sub29_Sub3.method2718(-27615); string != null; string = bufferedreader.readLine()) {
            class371.method4093(string, (byte)-105);
         }

         String[] strings = class371.method4095(-15202);
         if (strings.length % 3 != 0) {
            return;
         }

         this.aClass295Array4175 = new Class295[strings.length / 3];

         for(int i = 0; i < strings.length; i += 3) {
            this.aClass295Array4175[i / 3] = new Class295(strings[i], strings[i - -1], strings[i + 2]);
         }
      } catch (IOException var6) {
      }

      this.aBoolean4177 = true;
   }

   public static void method3903(int i) {
      aClass52_4181 = null;
      aClass192_4180 = null;
      if (i != 30694) {
         aClass192_4180 = null;
      }
   }

   static final byte[] method3904(byte b, File file) {
      int i = -56 / ((b - 19) / 54);
      ++anInt4174;
      return WorldItem.method924((byte)22, file, (int)file.length());
   }

   final boolean method3905(int i) {
      ++anInt4183;
      if (this.aBoolean4177) {
         return true;
      } else {
         if (this.aClass241_4178 == null) {
            try {
               if (Class240.aClass329_2943 != Node_Sub38_Sub1.aClass329_10086) {
                  int var10000 = Class320_Sub24.aClass197_8443.id + 7000;
               } else {
                  boolean var4 = true;
               }

               this.aClass241_4178 = Class240.aSignLink2946.method3642((byte)-80, new URL("http://www.google.com"));
            } catch (MalformedURLException var3) {
               return true;
            }
         }

         if (this.aClass241_4178 != null && this.aClass241_4178.anInt2953 != 2) {
            if (~this.aClass241_4178.anInt2953 != -2) {
               return false;
            } else {
               if (i > -103) {
                  this.method3902(21, 82);
               }

               if (this.aThread4179 == null) {
                  this.aThread4179 = new Thread(this);
                  this.aThread4179.start();
               }

               return this.aBoolean4177;
            }
         } else {
            return true;
         }
      }
   }
}
