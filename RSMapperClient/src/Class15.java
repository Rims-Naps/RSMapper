public class Class15 {
   static int anInt221;
   private Class312 aClass312_222;
   private long aLong223;
   static int[][] XTEA_KEYS;
   static int anInt225;
   private int anInt226 = -1;
   static int anInt227;

   private final void method217(Buffer buffer, byte b) {
      if (b != -20) {
         XTEA_KEYS = null;
      }

      this.aLong223 = buffer.readLong();
      ++anInt225;
      this.anInt226 = buffer.readInt();

      for(int i = buffer.readUnsignedByte(); i != 0; i = buffer.readUnsignedByte()) {
         Node_Sub15 node_sub15;
         if (~i != -4) {
            if (i == 1) {
               node_sub15 = new Node_Sub15_Sub2();
            } else if (i == 13) {
               node_sub15 = new Node_Sub15_Sub7();
            } else if (~i == -5) {
               node_sub15 = new Node_Sub15_Sub6();
            } else if (~i != -7) {
               if (~i != -6) {
                  if (~i != -3) {
                     if (i != 7) {
                        if (i != 8) {
                           if (i == 9) {
                              node_sub15 = new Node_Sub15_Sub1();
                           } else if (i == 10) {
                              node_sub15 = new Node_Sub15_Sub12();
                           } else if (~i == -12) {
                              node_sub15 = new Node_Sub15_Sub9();
                           } else {
                              if (~i != -13) {
                                 throw new RuntimeException("Unrecognised ClanSettingsDelta type in decode()");
                              }

                              node_sub15 = new Node_Sub15_Sub3();
                           }
                        } else {
                           node_sub15 = new Node_Sub15_Sub11();
                        }
                     } else {
                        node_sub15 = new Node_Sub15_Sub10();
                     }
                  } else {
                     node_sub15 = new Node_Sub15_Sub5();
                  }
               } else {
                  node_sub15 = new Node_Sub15_Sub8();
               }
            } else {
               node_sub15 = new Node_Sub15_Sub13();
            }
         } else {
            node_sub15 = new Node_Sub15_Sub4();
         }

         node_sub15.method2554(29147, buffer);
         this.aClass312_222.method3625((byte)-54, node_sub15);
      }
   }

   public static void method218(boolean bool) {
      XTEA_KEYS = null;
      if (!bool) {
         method220(8, -114, null, null, 55, null, 49, -98, null, 70, -7, 108, -36);
      }
   }

   final void method219(int i, ClanChat clanchat) {
      ++anInt227;
      if (~this.aLong223 == ~clanchat.aLong747 && ~this.anInt226 == ~clanchat.anInt757) {
         if (i != 0) {
            this.method219(119, null);
         }

         for(Node_Sub15 node_sub15 = (Node_Sub15)this.aClass312_222.method3613(65280);
            node_sub15 != null;
            node_sub15 = (Node_Sub15)this.aClass312_222.method3620(16776960)
         ) {
            node_sub15.method2556(clanchat, i + 16);
         }

         ++clanchat.anInt757;
      } else {
         throw new RuntimeException(
            "ClanSettingsDelta.applyToClanSettings(): Credentials do not match! Settings.owner:"
               + Class154.method1699(clanchat.aLong747, i + 25589)
               + " updateNum:"
               + clanchat.anInt757
               + " delta.owner:"
               + Class154.method1699(this.aLong223, 25589)
               + " updateNum:"
               + this.anInt226
         );
      }
   }

   static final void method220(
      int i, int i_0_, float[] fs, int[] is, int i_1_, float[] fs_2_, int i_3_, int i_4_, int[] is_5_, int i_6_, int i_7_, int i_8_, int i_9_
   ) {
      if (i_8_ == -5) {
         ++anInt221;
         int i_10_ = i_9_ * i_1_ - -i_7_;
         int i_11_ = i * i_3_ + i_4_;
         int i_12_ = -i_0_ + i_1_;
         int i_13_ = -i_0_ + i_3_;
         if (is != null) {
            if (fs != null) {
               for(int i_14_ = 0; ~i_14_ > ~i_6_; ++i_14_) {
                  for(int i_15_ = i_0_ + i_10_; ~i_15_ < ~i_10_; fs_2_[i_11_++] = fs[i_10_++]) {
                     is_5_[i_11_] = is[i_10_];
                  }

                  i_10_ += i_12_;
                  i_11_ += i_13_;
               }
            } else {
               for(int i_16_ = 0; i_6_ > i_16_; ++i_16_) {
                  int i_17_ = i_10_ + i_0_;

                  while(i_17_ > i_10_) {
                     is_5_[i_11_++] = is[i_10_++];
                  }

                  i_11_ += i_13_;
                  i_10_ += i_12_;
               }
            }
         } else {
            for(int i_18_ = 0; i_18_ < i_6_; ++i_18_) {
               int i_19_ = i_0_ + i_10_;

               while(~i_10_ > ~i_19_) {
                  fs_2_[i_11_++] = fs[i_10_++];
               }

               i_10_ += i_12_;
               i_11_ += i_13_;
            }
         }
      }
   }

   Class15(Buffer buffer) {
      this.aClass312_222 = new Class312();
      this.method217(buffer, (byte)-20);
   }
}
