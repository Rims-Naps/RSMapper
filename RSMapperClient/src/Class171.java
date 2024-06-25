import com.dropbox.core.v2.DbxClientV2;

public class Class171 {
   static int anInt2057;
   static boolean aBoolean2058 = true;
   protected int anInt2059;
   private int anInt2060;
   protected int anInt2061;
   static Class278 aClass278_2062;
   protected int anInt2063;
   static int anInt2064;
   private int anInt2065;
   static int anInt2066;
   private int anInt2067;
   protected int anInt2068;
   private int anInt2069;
   static int[] anIntArray2070 = new int[500];
   static long aLong2071 = 20000000L;
   protected int anInt2072;
   protected int anInt2073;
   static int anInt2074;
   public static DbxClientV2 aHashTable1923 = null;

   static final Class52 method1792(boolean bool, boolean bool_0_, int i, int i_1_, GraphicsToolkit graphicstoolkit) {
      ++anInt2057;
      if (i_1_ > -88) {
         aBoolean2058 = false;
      }

      Class49 class49 = Class268.method3290(bool, (byte)75, graphicstoolkit, bool_0_, i);
      return class49 == null ? null : class49.aClass52_721;
   }

   final void method1793(int i, int i_2_, int i_3_, int i_4_, int i_5_, int i_6_, int i_7_, int i_8_, int i_9_, int i_10_, int i_11_) {
      this.anInt2067 = i_8_;
      this.anInt2065 = i_3_;
      this.anInt2069 = i_7_ * i_7_;
      this.anInt2060 = i_4_;
      ++anInt2074;
      this.anInt2072 = i + this.anInt2065;
      this.anInt2068 = i_2_ + this.anInt2067;
      this.anInt2073 = this.anInt2065 - -i_9_;
      this.anInt2063 = i_11_ + this.anInt2060;
      this.anInt2059 = i_10_ + this.anInt2060;
      this.anInt2061 = i_5_ + this.anInt2067;
      if (i_6_ > -35) {
         method1792(true, false, -33, 54, null);
      }
   }

   public static void method1794(int i) {
      aClass278_2062 = null;
      anIntArray2070 = null;
      if (i != 29383) {
         method1792(true, false, -107, -126, null);
      }
   }

   final boolean method1795(int i, byte b, int i_12_, int i_13_) {
      ++anInt2064;
      if (this.anInt2059 <= i_13_ && this.anInt2063 >= i_13_) {
         if (~this.anInt2072 >= ~i && i <= this.anInt2073) {
            if (b < 105) {
               this.method1793(87, 15, -33, 83, -55, -120, -79, 45, -10, -121, 6);
            }

            if (i_12_ >= this.anInt2068 && ~this.anInt2061 <= ~i_12_) {
               int i_14_ = -this.anInt2060 + i_13_;
               int i_15_ = i_12_ - this.anInt2067;
               return ~(i_15_ * i_15_ + i_14_ * i_14_) > ~this.anInt2069;
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   Class171(int i, int i_16_, int i_17_, int i_18_, int i_19_, int i_20_, int i_21_, int i_22_, int i_23_, int i_24_) {
      this.anInt2060 = i;
      this.anInt2067 = i_17_;
      this.anInt2065 = i_16_;
      this.anInt2069 = i_18_ * i_18_;
      this.anInt2059 = this.anInt2060 + i_19_;
      this.anInt2063 = i_20_ + this.anInt2060;
      this.anInt2068 = this.anInt2067 - -i_23_;
      this.anInt2061 = i_24_ + this.anInt2067;
      this.anInt2073 = this.anInt2065 + i_22_;
      this.anInt2072 = i_21_ + this.anInt2065;
   }
}
