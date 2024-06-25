import java.util.zip.CRC32;

public class Class7 {
   static int anInt149;
   protected int anInt150 = 8;
   protected int anInt151;
   protected int anInt152;
   protected int anInt153;
   static int anInt154;
   protected int anInt155;
   protected int anInt156;
   static Class179 aClass179_157 = new Class179(true);
   protected int anInt158;
   protected int anInt159 = 16777215;
   protected int anInt160;
   protected int anInt161;
   protected boolean aBoolean162;
   static CRC32 aCRC32_163 = new CRC32();
   static String[] aStringArray164 = new String[100];

   private final void method180(int i, Buffer buffer, int i_0_) {
      if (i_0_ >= -119) {
         this.method180(-41, null, -52);
      }

      if (~i == -2) {
         this.anInt150 = buffer.readUnsignedShort();
      } else if (~i != -3) {
         if (i == 3) {
            this.anInt152 = buffer.readShort();
            this.anInt158 = buffer.readShort();
            this.anInt160 = buffer.readShort();
         } else if (i == 4) {
            this.anInt156 = buffer.readUnsignedByte();
         } else if (i == 5) {
            this.anInt151 = buffer.readUnsignedShort();
         } else if (~i != -7) {
            if (i == 7) {
               this.anInt155 = buffer.readShort();
               this.anInt161 = buffer.readShort();
               this.anInt153 = buffer.readShort();
            }
         } else {
            this.anInt159 = buffer.read24BitInteger();
         }
      } else {
         this.aBoolean162 = true;
      }

      ++anInt154;
   }

   static final void method181(int i, int i_1_, int i_2_, Class var_class) {
      Class261 class261 = Class175.aClass261ArrayArrayArray2099[i][i_1_][i_2_];
      if (class261 != null) {
         for(Class256 class256 = class261.aClass256_3312; class256 != null; class256 = class256.aClass256_3238) {
            Mobile mobile = class256.aMobile3239;
            if (var_class.isAssignableFrom(mobile.getClass()) && mobile.aShort9119 == i_1_ && mobile.aShort9120 == i_2_) {
               Class290.method3418(mobile, false);
               break;
            }
         }
      }
   }

   final void method182(Buffer buffer, int i) {
      if (i != 16777215) {
         this.anInt155 = 84;
      }

      while(true) {
         int i_3_ = buffer.readUnsignedByte();
         if (~i_3_ == -1) {
            ++anInt149;
            return;
         }

         this.method180(i_3_, buffer, -121);
      }
   }

   public static void method183(boolean bool) {
      aStringArray164 = null;
      aCRC32_163 = null;
      aClass179_157 = null;
      if (bool) {
         aStringArray164 = null;
      }
   }
}
