import com.dropbox.core.v2.DbxClientV2;

public class Class207 {
   static int anInt2473;
   static int anInt2474;
   private int anInt2475;
   private long aLong2476;
   static int anInt2477;
   static int anInt2478;
   static int anInt2479;
   static int anInt2480;
   public static DbxClientV2 aHashTable1923 = null;

   static final void method2039(int i) {
      if (Class94.anInt1250 < 0) {
         Class262_Sub4.anInt7730 = -1;
         Class150_Sub3.anInt8963 = -1;
         Class94.anInt1250 = 0;
      }

      if (i <= 5) {
         method2040(null, 31, 8);
      }

      ++anInt2477;
      if (WorldmapDefinitions.totalXTiles < Class94.anInt1250) {
         Class262_Sub4.anInt7730 = -1;
         Class94.anInt1250 = WorldmapDefinitions.totalXTiles;
         Class150_Sub3.anInt8963 = -1;
      }

      if (~Class327.anInt5360 > -1) {
         Class150_Sub3.anInt8963 = -1;
         Class262_Sub4.anInt7730 = -1;
         Class327.anInt5360 = 0;
      }

      if (~WorldmapDefinitions.totalYTiles > ~Class327.anInt5360) {
         Class150_Sub3.anInt8963 = -1;
         Class262_Sub4.anInt7730 = -1;
         Class327.anInt5360 = WorldmapDefinitions.totalYTiles;
      }
   }

   static final String method2040(Buffer buffer, int i, int i_0_) {
      ++anInt2480;

      try {
         int i_1_ = buffer.readSmart();
         if (~i > ~i_1_) {
            i_1_ = i;
         }

         byte[] bs = new byte[i_1_];
         buffer.offset += Class342.aClass163_4236.method1735(bs, -1, buffer.buffer, i_1_, buffer.offset, 0);
         if (i_0_ != -24709) {
            method2040(null, -44, 108);
         }

         return Class184.method1846(0, bs, i_1_, (byte)-109);
      } catch (Exception var6) {
         return "Cabbage";
      }
   }

   private final int method2041(int i, int i_2_) {
      if (i != 12053) {
         this.method2044(76, 34);
      }

      ++anInt2474;
      return (int)(this.aLong2476 >> Class126.anInt1631 * i_2_) & 15;
   }

   final int method2042(int i) {
      ++anInt2478;
      if (i != -1) {
         method2040(null, -50, -36);
      }

      return this.anInt2475;
   }

   private final void method2043(Class126 class126, int i) {
      ++anInt2479;
      if (i < -114) {
         this.aLong2476 |= (long)(class126.anInt1621 << this.anInt2475++ * Class126.anInt1631);
      }
   }

   Class207(Class126 class126) {
      this.aLong2476 = (long)class126.anInt1621;
      this.anInt2475 = 1;
   }

   final Class126 method2044(int i, int i_3_) {
      ++anInt2473;
      return i != 15 ? null : Class126.method1534(this.method2041(12053, i_3_), -126);
   }

   Class207(Class126[] class126s) {
      for(int i = 0; ~i > ~class126s.length; ++i) {
         this.method2043(class126s[i], -121);
      }
   }
}
