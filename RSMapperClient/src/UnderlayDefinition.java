public class UnderlayDefinition {
   static int anInt2887;
   protected int anInt2888;
   static int anInt2889;
   protected int anInt2890;
   protected int texture = -1;
   protected boolean aBoolean2892;
   private int anInt2893 = 0;
   protected int anInt2894;
   static int anInt2895;
   protected boolean aBoolean2896;
   protected int anInt2897;
   static Class94 aClass94_2898 = new Class94();
   static IComponentDefinitions[] aWidgetArray2899;
   static int anInt2900;
   protected int anInt2901;
   static int anInt2902;

   public static void method3011(boolean bool) {
      if (bool) {
         anInt2902 = -1;
      }

      aClass94_2898 = null;
      aWidgetArray2899 = null;
   }

   static final boolean method3012(int i, int i_0_, int i_1_) {
      ++anInt2887;
      if (i_0_ != 0) {
         return false;
      } else {
         return CacheNode_Sub3.method2296(i_1_, (byte)109, i) || Class110.method1135(i, i_1_, false);
      }
   }

   private final void readValue(int opcode, Buffer buffer) {
      ++anInt2900;
      if (opcode == 1) {
         this.anInt2893 = buffer.read24BitInteger();
         this.setUnderlayColors(this.anInt2893, 127);
      } else if (opcode == 2) {
         this.texture = buffer.readUnsignedShort();
         if (this.texture == 65535) {
            this.texture = -1;
         }
      } else if (opcode == 3) {
         this.anInt2894 = buffer.readUnsignedShort() << 2;
      } else if (opcode != 4) {
         if (opcode == 5) {
            this.aBoolean2892 = false;
         }
      } else {
         this.aBoolean2896 = false;
      }
   }

   final void decodeUnderlay(Buffer buffer, int i) {
      while(true) {
         int opcode = buffer.readUnsignedByte();
         if (opcode == 0) {
            if (i != -1) {
               this.aBoolean2892 = true;
            }

            ++anInt2895;
            return;
         }

         this.readValue(opcode, buffer);
      }
   }

   public UnderlayDefinition() {
      this.aBoolean2892 = true;
      this.anInt2894 = 512;
      this.aBoolean2896 = true;
   }

   private final void setUnderlayColors(int i, int i_5_) {
      ++anInt2889;
      double d = (double)((16755578 & i) >> 16) / 256.0;
      double d_6_ = (double)((i & 65396) >> 8) / 256.0;
      double d_7_ = (double)(0xFF & i) / 256.0;
      double d_8_ = d;
      if (d > d_6_) {
         d_8_ = d_6_;
      }

      if (d_8_ > d_7_) {
         d_8_ = d_7_;
      }

      double d_9_ = d;
      if (d_6_ > d) {
         d_9_ = d_6_;
      }

      if (d_7_ > d_9_) {
         d_9_ = d_7_;
      }

      double d_10_ = 0.0;
      double d_11_ = 0.0;
      double d_12_ = (d_8_ + d_9_) / 2.0;
      if (d_8_ != d_9_) {
         if (d_12_ < 0.5) {
            d_11_ = (d_9_ - d_8_) / (d_8_ + d_9_);
         }

         if (d == d_9_) {
            d_10_ = (-d_7_ + d_6_) / (-d_8_ + d_9_);
         } else if (d_9_ != d_6_) {
            if (d_9_ == d_7_) {
               d_10_ = 4.0 + (d - d_6_) / (-d_8_ + d_9_);
            }
         } else {
            d_10_ = (-d + d_7_) / (d_9_ - d_8_) + 2.0;
         }

         if (d_12_ >= 0.5) {
            d_11_ = (-d_8_ + d_9_) / (2.0 - d_9_ - d_8_);
         }
      }

      this.anInt2897 = (int)(256.0 * d_11_);
      if (i_5_ >= 126) {
         this.anInt2901 = (int)(d_12_ * 256.0);
         d_10_ /= 6.0;
         if (d_12_ <= 0.5) {
            this.anInt2890 = (int)(512.0 * d_12_ * d_11_);
         } else {
            this.anInt2890 = (int)(512.0 * (1.0 - d_12_) * d_11_);
         }

         if (~this.anInt2901 > -1) {
            this.anInt2901 = 0;
         } else if (~this.anInt2901 < -256) {
            this.anInt2901 = 255;
         }

         if (~this.anInt2897 > -1) {
            this.anInt2897 = 0;
         } else if (this.anInt2897 > 255) {
            this.anInt2897 = 255;
         }

         if (~this.anInt2890 > -2) {
            this.anInt2890 = 1;
         }

         this.anInt2888 = (int)(d_10_ * (double)this.anInt2890);
      }
   }
}
