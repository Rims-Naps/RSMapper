public class Class197 {
   static int anInt2412;
   static int anInt2413;
   private boolean aBoolean2414;
   static int anInt2415 = -1;
   protected int secondPort = RSMapperClient.PORT_ID;
   protected int firstPort = RSMapperClient.PORT_ID;
   static int anInt2418;
   protected int id;
   private boolean aBoolean2420;
   static int anInt2421;
   protected String ipadress;
   static int anInt2423 = 0;
   static int anInt2424;
   static int anInt2425;

   final void method1997(int i) {
      if (this.aBoolean2420) {
         if (!this.aBoolean2414) {
            this.aBoolean2420 = false;
         } else {
            this.aBoolean2414 = false;
         }
      } else {
         this.aBoolean2414 = true;
         this.aBoolean2420 = true;
      }

      ++anInt2413;
      if (i != 17418) {
         this.secondPort = -19;
      }
   }

   static final String method1998(String string, String string_0_, byte b, char c) {
      int i = 111 / ((-28 - b) / 50);
      ++anInt2424;
      int i_1_ = string.length();
      int i_2_ = string_0_.length();
      int i_3_ = i_1_;
      int i_4_ = i_2_ - 1;
      if (i_4_ != 0) {
         int i_5_ = 0;

         while(true) {
            i_5_ = string.indexOf(c, i_5_);
            if (~i_5_ > -1) {
               break;
            }

            i_3_ += i_4_;
            ++i_5_;
         }
      }

      StringBuffer stringbuffer = new StringBuffer(i_3_);
      int i_6_ = 0;

      while(true) {
         int i_7_ = string.indexOf(c, i_6_);
         if (i_7_ < 0) {
            stringbuffer.append(string.substring(i_6_));
            return stringbuffer.toString();
         }

         stringbuffer.append(string.substring(i_6_, i_7_));
         i_6_ = 1 + i_7_;
         stringbuffer.append(string_0_);
      }
   }

   static final boolean method1999(int i, int i_8_) {
      if (i_8_ != 128) {
         anInt2415 = 13;
      }

      ++anInt2421;
      return i == 3 || ~i == -6 || i == 6;
   }

   final Class241 method2000(byte b, SignLink signlink) {
      ++anInt2418;
      if (b > -18) {
         this.ipadress = null;
      }

      return signlink.method3629(this.ipadress, true, this.aBoolean2414, !this.aBoolean2420 ? this.firstPort : this.secondPort);
   }

   static final String method2001(byte b, int i, byte[] bs, int i_9_) {
      ++anInt2412;
      char[] cs = new char[i];
      int i_10_ = 0;
      if (b != -124) {
         return null;
      } else {
         int i_11_ = i_9_;

         int i_14_;
         for(int i_12_ = i + i_9_; i_12_ > i_11_; cs[i_10_++] = (char)i_14_) {
            int i_13_ = bs[i_11_++] & 255;
            if (~i_13_ > -129) {
               if (~i_13_ != -1) {
                  i_14_ = i_13_;
               } else {
                  i_14_ = 65533;
               }
            } else if (~i_13_ <= -193) {
               if (~i_13_ <= -225) {
                  if (i_13_ >= 240) {
                     if (~i_13_ <= -249) {
                        i_14_ = 65533;
                     } else if (~(i_11_ - -2) > ~i_12_ && ~(bs[i_11_] & 192) == -129 && ~(192 & bs[i_11_ + 1]) == -129 && (192 & bs[2 + i_11_]) == 128) {
                        i_14_ = 258048 & bs[i_11_++] << 12 | (i_13_ & 7) << 18 | 4032 & bs[i_11_++] << 6 | bs[i_11_++] & 63;
                        if (i_14_ >= 65536 && ~i_14_ >= -1114112) {
                           i_14_ = 65533;
                        } else {
                           i_14_ = 65533;
                        }
                     } else {
                        i_14_ = 65533;
                     }
                  } else if (~i_12_ < ~(i_11_ + 1) && ~(192 & bs[i_11_]) == -129 && (192 & bs[i_11_ + 1]) == 128) {
                     i_14_ = (i_13_ & 15) << 12 | bs[i_11_++] << 6 & 4032 | 63 & bs[i_11_++];
                     if (~i_14_ > -2049) {
                        i_14_ = 65533;
                     }
                  } else {
                     i_14_ = 65533;
                  }
               } else if (~i_11_ > ~i_12_ && ~(192 & bs[i_11_]) == -129) {
                  i_14_ = 1984 & i_13_ << 6 | bs[i_11_++] & 63;
                  if (~i_14_ > -129) {
                     i_14_ = 65533;
                  }
               } else {
                  i_14_ = 65533;
               }
            } else {
               i_14_ = 65533;
            }
         }

         return new String(cs, 0, i_10_);
      }
   }

   final boolean method2002(int i, Class197 class197_15_) {
      ++anInt2425;
      if (i != -129) {
         this.method1997(2);
      }

      if (class197_15_ != null) {
         return ~class197_15_.id == ~this.id && this.ipadress.equals(class197_15_.ipadress);
      } else {
         return false;
      }
   }

   public Class197() {
      this.secondPort = RSMapperClient.PORT_ID;
      this.aBoolean2414 = false;
      this.aBoolean2420 = true;
   }
}
