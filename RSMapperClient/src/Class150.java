import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

class Class150 implements Interface7 {
   static int anInt5078;
   protected Class379 aClass379_5079;
   protected int anInt5080;
   protected int anInt5081;
   static int anInt5082;
   protected int anInt5083;
   protected int anInt5084;
   static int anInt5085;
   protected int anInt5086;
   protected Class77 aClass77_5087;
   static int anInt5088;
   static int anInt5089;
   protected int anInt5090;
   static int anInt5091;
   protected int anInt5092;

   static final boolean method1652(int i, int i_0_, int i_1_, int i_2_, int i_3_) {
      ++anInt5089;
      if (Class12.aBoolean194 && Mobile_Sub1.aBoolean10959) {
         if (~Class233.anInt2786 > -101) {
            return false;
         } else if (!Class313.method3649(true, i_3_, i_0_, i_1_)) {
            return false;
         } else if (i_2_ != 0) {
            return false;
         } else {
            int i_4_ = i_1_ << Class36.INT_9;
            int i_5_ = i_3_ << Class36.INT_9;
            if (Node_Sub25.method2653(
               Class179.INT_18, i, i_4_, 255, i_5_, Class320_Sub10.aPlaneArray8300[i_0_].getVerticeHeight(i_3_, i_1_, (byte)-118), Class179.INT_18
            )) {
               ++Class187.anInt2267;
               return true;
            } else {
               return false;
            }
         }
      } else {
         return false;
      }
   }

   static final void method1653(File file, int i, byte[] bs, int i_6_) throws IOException {
      ++anInt5078;
      DataInputStream datainputstream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));

      try {
         datainputstream.readFully(bs, 0, i_6_);
      } catch (EOFException var6) {
      }

      if (i >= 84) {
         datainputstream.close();
      }
   }

   static final float method1654(float f, float f_7_, float f_8_, int i, byte b) {
      int i_9_ = -69 / ((-17 - b) / 33);
      ++anInt5091;
      float[] fs = Class150_Sub3.aFloatArrayArray8967[i];
      return f * fs[2] + fs[0] * f_7_ + f_8_ * fs[1];
   }

   @Override
   public Class170 method20(int i) {
      ++anInt5082;
      if (i <= 81) {
         method1652(43, -71, -15, 90, -71);
      }

      return null;
   }

   Class150(Class379 class379, Class77 class77, int i, int i_10_, int i_11_, int i_12_, int i_13_, int i_14_, int i_15_) {
      this.anInt5081 = i_12_;
      this.anInt5083 = i_14_;
      this.aClass379_5079 = class379;
      this.anInt5084 = i_13_;
      this.aClass77_5087 = class77;
      this.anInt5086 = i_11_;
      this.anInt5092 = i;
      this.anInt5080 = i_10_;
      this.anInt5090 = i_15_;
   }
}
