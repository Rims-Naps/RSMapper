import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;

public class Class240 {
   protected int anInt2933;
   protected int anInt2934;
   static int anInt2935;
   static int anInt2936;
   protected int anInt2937;
   protected int anInt2938;
   static int anInt2939;
   protected int anInt2940;
   protected int anInt2941;
   protected byte[] aByteArray2942;
   static Class329 aClass329_2943 = new Class329("LIVE", "", "", 0);
   protected byte[] aByteArray2944;
   static IncommingPacket aClass192_2945 = new IncommingPacket(87, -2);
   static SignLink aSignLink2946;
   protected int anInt2947;
   static int[][][] anIntArrayArrayArray2948;
   static String[] aStringArray2949 = new String[100];
   static int anInt2950;

   static final Class151 method3028(byte b, int i) {
      ++anInt2950;
      Class151[] class151s = Node_Sub42.method2934(-46);

      for(int i_0_ = 0; i_0_ < class151s.length; ++i_0_) {
         if (class151s[i_0_].anInt1844 == i) {
            return class151s[i_0_];
         }
      }

      return b < 4 ? null : null;
   }

   public static void method3029(int i) {
      aClass192_2945 = null;
      aSignLink2946 = null;
      aStringArray2949 = null;
      aClass329_2943 = null;
      if (i <= -112) {
         anIntArrayArrayArray2948 = null;
      }
   }

   // $VF: Could not inline inconsistent finally blocks
   // Please report this to the Vineflower issue tracker, at https://github.com/Vineflower/vineflower/issues with a copy of the class file (if you have the rights to distribute it!)
   static final String method3030(int i, Throwable throwable) throws IOException {
      ++anInt2936;
      if (i != 0) {
         method3029(-11);
      }

      String string;
      if (!(throwable instanceof RuntimeException_Sub1)) {
         string = "";
      } else {
         RuntimeException_Sub1 runtimeexception_sub1 = (RuntimeException_Sub1)throwable;
         string = runtimeexception_sub1.aString4919 + " | ";
         throwable = runtimeexception_sub1.aThrowable4921;
      }

      StringWriter stringwriter = new StringWriter();
      Throwable string_1_ = null;
      BufferedReader bufferedreader = null;

      try {
         PrintWriter printwriter = new PrintWriter(stringwriter);

         try {
            throwable.printStackTrace(printwriter);
            printwriter.close();
         } finally {
            if (printwriter != null) {
               printwriter.close();
            }
         }
      } catch (Throwable var17) {
         if (string_1_ == null) {
            string_1_ = var17;
         } else if (string_1_ != var17) {
            string_1_.addSuppressed(var17);
         }

          try {
              throw string_1_;
          } catch (Throwable e) {
              throw new RuntimeException(e);
          }
      }

      String string_1_x = stringwriter.toString();
      bufferedreader = new BufferedReader(new StringReader(string_1_x));
      String string_2_ = bufferedreader.readLine();

      while(true) {
         String string_3_ = bufferedreader.readLine();
         if (string_3_ == null) {
            return string + "| " + string_2_;
         }

         int i_4_ = string_3_.indexOf(40);
         int i_5_ = string_3_.indexOf(41, 1 + i_4_);
         String string_6_;
         if (i_4_ != -1) {
            string_6_ = string_3_.substring(0, i_4_);
         } else {
            string_6_ = string_3_;
         }

         string_6_ = string_6_.trim();
         string_6_ = string_6_.substring(string_6_.lastIndexOf(32) - -1);
         string_6_ = string_6_.substring(string_6_.lastIndexOf(9) + 1);
         string = string + string_6_;
         if (~i_4_ != 0 && i_5_ != -1) {
            int i_7_ = string_3_.indexOf(".java:", i_4_);
            if (~i_7_ <= -1) {
               string = string + string_3_.substring(5 + i_7_, i_5_);
            }
         }

         string = string + ' ';
      }
   }

   static final void method3031(int i, int i_8_, int i_9_, boolean bool, int i_10_, int i_11_, int i_12_, int i_13_) {
      ++anInt2935;
      int i_14_ = i_12_ + i_13_;
      if (!bool) {
         int i_15_ = -i_12_ + i;

         for(int i_16_ = i_13_; ~i_14_ < ~i_16_; ++i_16_) {
            Class369.method4086(i_8_, i_9_, i_11_, Class169_Sub4.anIntArrayArray8826[i_16_], 0);
         }

         int i_17_ = i_11_ + i_12_;
         int i_18_ = i_8_ + -i_12_;

         for(int i_19_ = i; i_15_ < i_19_; --i_19_) {
            Class369.method4086(i_8_, i_9_, i_11_, Class169_Sub4.anIntArrayArray8826[i_19_], 0);
         }

         for(int i_20_ = i_14_; i_15_ >= i_20_; ++i_20_) {
            int[] is = Class169_Sub4.anIntArrayArray8826[i_20_];
            Class369.method4086(i_17_, i_9_, i_11_, is, 0);
            Class369.method4086(i_18_, i_10_, i_17_, is, 0);
            Class369.method4086(i_8_, i_9_, i_18_, is, 0);
         }
      }
   }
}
