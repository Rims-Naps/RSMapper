import java.awt.Dimension;

public class Index {
   static int anInt3781;
   static int anInt3782;
   private Object[] anObjectArray3783;
   static int anInt3784;
   static int anInt3785;
   private Object[][] cachedFiles;
   static int anInt3787;
   static int anInt3788;
   static int anInt3789;
   static int anInt3790;
   static int anInt3791;
   static int anInt3792;
   static int anInt3793;
   static int anInt3794;
   protected int anInt3795;
   static int anInt3796;
   private ReferenceTable anArchive3797 = null;
   static int anInt3798;
   static int anInt3799;
   static int anInt3800;
   static int anInt3801;
   static int anInt3802;
   static int anInt3803;
   private Class34 aClass34_3804;
   static int anInt3805;
   static int anInt3806;
   static int anInt3807;
   static int anInt3808;
   static int anInt3809;
   static int anInt3810;
   static int anInt3811;
   static int anInt3812;
   static int anInt3813;
   static int anInt3814;
   static int anInt3815;
   static int anInt3816;
   static int anInt3817;
   static int anInt3818;
   private boolean aBoolean3819;
   static int anInt3820;

   final void method3504(boolean bool, byte b, boolean bool_0_) {
      ++anInt3810;
      if (this.method3530(0)) {
         if (bool) {
            this.anArchive3797.aClass75_301 = null;
            this.anArchive3797.archives = null;
         }

         if (b != 31) {
            this.anInt3795 = -39;
         }

         if (bool_0_) {
            this.anArchive3797.nameHashes = null;
            this.anArchive3797.aClass75Array288 = null;
         }
      }
   }

   final int method3505(boolean bool) {
      if (bool) {
         return 36;
      } else {
         ++anInt3798;
         if (!this.method3530(0)) {
            throw new IllegalStateException("");
         } else {
            return this.anArchive3797.anInt291;
         }
      }
   }

   final boolean method3506(String string, boolean bool, String string_1_) {
      ++anInt3812;
      if (!this.method3530(0)) {
         return false;
      } else {
         string = string.toLowerCase();
         string_1_ = string_1_.toLowerCase();
         int i = this.anArchive3797.aClass75_301.method766(-1, Class336_Sub1.method3887(false, string));
         if (i < 0) {
            return false;
         } else {
            int i_2_ = this.anArchive3797.aClass75Array288[i].method766(-1, Class336_Sub1.method3887(false, string_1_));
            if (i_2_ < 0) {
               return false;
            } else {
               if (!bool) {
                  this.cachedFiles = null;
               }

               return true;
            }
         }
      }
   }

   final boolean method3507(byte b, String string) {
      ++anInt3791;
      if (b >= -116) {
         return true;
      } else {
         int i = this.method3519("", (byte)35);
         return i != -1 ? this.method3533(false, "", string) : this.method3533(false, string, "");
      }
   }

   private final void method3508(int i, int i_3_) {
      if (!this.aBoolean3819) {
         this.anObjectArray3783[i] = Class135.method1588(this.aClass34_3804.method373(i, (byte)55));
      } else {
         this.anObjectArray3783[i] = this.aClass34_3804.method373(i, (byte)118);
      }

      if (i_3_ != 0) {
         this.aBoolean3819 = true;
      }

      ++anInt3814;
   }

   private final int method3509(boolean bool, int i) {
      ++anInt3794;
      if (!this.method3525((byte)-86, i)) {
         return 0;
      } else if (this.anObjectArray3783[i] != null) {
         return 100;
      } else {
         if (bool) {
            this.anObjectArray3783 = null;
         }

         return this.aClass34_3804.method369((byte)-4, i);
      }
   }

   final boolean method3510(int i, byte b) {
      ++anInt3788;
      if (!this.method3530(b + -63)) {
         return false;
      } else if (this.anArchive3797.anIntArray285.length == 1) {
         return this.method3515(i, 0, 0);
      } else if (!this.method3525((byte)-86, i)) {
         return false;
      } else if (this.anArchive3797.anIntArray285[i] == 1) {
         return this.method3515(0, i, 0);
      } else {
         if (b != 63) {
            this.anObjectArray3783 = null;
         }

         throw new RuntimeException();
      }
   }

   final int method3511(int i) {
      if (i != 19492) {
         return 48;
      } else {
         ++anInt3803;
         if (!this.method3530(0)) {
            return 0;
         } else {
            int i_4_ = 0;
            int i_5_ = 0;

            for(int i_6_ = 0; this.anObjectArray3783.length > i_6_; ++i_6_) {
               if (~this.anArchive3797.anIntArray295[i_6_] < -1) {
                  i_4_ += 100;
                  i_5_ += this.method3509(false, i_6_);
               }
            }

            return i_4_ == 0 ? 100 : i_5_ * 100 / i_4_;
         }
      }
   }

   final byte[] getFile(int[] keys, int fileId, int junk, int archiveId) {
      ++anInt3813;
      if (!this.fileExists(fileId, archiveId, (byte)127)) {
         return null;
      } else {
         if (this.cachedFiles[archiveId] == null || this.cachedFiles[archiveId][fileId] == null) {
            boolean bool = this.method3514(0, keys, fileId, archiveId);
            if (!bool) {
               this.method3508(archiveId, 0);
               bool = this.method3514(0, keys, fileId, archiveId);
               if (!bool) {
                  return null;
               }
            }
         }

         byte[] file = Class320_Sub15.method3739((byte)-48, false, this.cachedFiles[archiveId][fileId]);
         if (this.anInt3795 != 1) {
            if (this.anInt3795 == 2) {
               this.cachedFiles[archiveId] = null;
            }
         } else {
            this.cachedFiles[archiveId][fileId] = null;
            if (this.anArchive3797.anIntArray285[archiveId] == 1) {
               this.cachedFiles[archiveId] = null;
            }
         }

         return file;
      }
   }

   private final boolean fileExists(int fileId, int archiveId, byte b) {
      ++anInt3781;
      if (!this.method3530(0)) {
         return false;
      } else if (archiveId >= 0 && fileId >= 0 && archiveId < this.anArchive3797.anIntArray285.length && this.anArchive3797.anIntArray285[archiveId] > fileId) {
         if (b < 126) {
            this.method3508(-92, 27);
         }

         return true;
      } else if (Class144_Sub3.aBoolean6833) {
         throw new IllegalArgumentException(String.valueOf(archiveId) + "," + fileId);
      } else {
         return false;
      }
   }

   private final boolean method3514(int i, int[] keys, int fileId, int archiveId) {
      if (i != 0) {
         this.aClass34_3804 = null;
      }

      ++anInt3817;
      if (!this.method3525((byte)-86, archiveId)) {
         return false;
      } else if (this.anObjectArray3783[archiveId] == null) {
         return false;
      } else {
         int i_14_ = this.anArchive3797.anIntArray295[archiveId];
         int[] is_15_ = this.anArchive3797.anIntArrayArray290[archiveId];
         if (this.cachedFiles[archiveId] == null) {
            this.cachedFiles[archiveId] = new Object[this.anArchive3797.anIntArray285[archiveId]];
         }

         Object[] objects = this.cachedFiles[archiveId];
         boolean bool = true;

         for(int i_16_ = 0; i_14_ > i_16_; ++i_16_) {
            int i_17_;
            if (is_15_ != null) {
               i_17_ = is_15_[i_16_];
            } else {
               i_17_ = i_16_;
            }

            if (objects[i_17_] == null) {
               bool = false;
               break;
            }
         }

         if (bool) {
            return true;
         } else {
            byte[] bs;
            if (keys != null && (keys[0] != 0 || keys[1] != 0 || keys[2] != 0 || keys[3] != 0)) {
               bs = Class320_Sub15.method3739((byte)127, true, this.anObjectArray3783[archiveId]);
               Buffer buffer = new Buffer(bs);
               buffer.method2231(5, keys, buffer.buffer.length, -4901);
            } else {
               bs = Class320_Sub15.method3739((byte)126, false, this.anObjectArray3783[archiveId]);
            }

            byte[] bs_18_ = Node_Sub38_Sub26.method2875(bs, (byte)-104);
            if (this.aBoolean3819) {
               this.anObjectArray3783[archiveId] = null;
            }

            if (i_14_ <= 1) {
               int i_19_;
               if (is_15_ == null) {
                  i_19_ = 0;
               } else {
                  i_19_ = is_15_[0];
               }

               if (this.anInt3795 == 0) {
                  objects[i_19_] = Class135.method1588(bs_18_);
               } else {
                  objects[i_19_] = bs_18_;
               }
            } else if (this.anInt3795 != 2) {
               int i_20_ = bs_18_.length;
               int i_21_ = 255 & bs_18_[--i_20_];
               i_20_ -= i_21_ * i_14_ * 4;
               Buffer buffer = new Buffer(bs_18_);
               buffer.offset = i_20_;
               int[] is_22_ = new int[i_14_];

               for(int i_23_ = 0; i_21_ > i_23_; ++i_23_) {
                  int i_24_ = 0;

                  for(int i_25_ = 0; ~i_25_ > ~i_14_; ++i_25_) {
                     i_24_ += buffer.readInt();
                     is_22_[i_25_] += i_24_;
                  }
               }

               byte[][] bs_26_ = new byte[i_14_][];

               for(int i_27_ = 0; ~i_27_ > ~i_14_; ++i_27_) {
                  bs_26_[i_27_] = new byte[is_22_[i_27_]];
                  is_22_[i_27_] = 0;
               }

               buffer.offset = i_20_;
               int i_28_ = 0;

               for(int i_29_ = 0; i_29_ < i_21_; ++i_29_) {
                  int i_30_ = 0;

                  for(int i_31_ = 0; i_31_ < i_14_; ++i_31_) {
                     i_30_ += buffer.readInt();
                     Class311.method3608(bs_18_, i_28_, bs_26_[i_31_], is_22_[i_31_], i_30_);
                     is_22_[i_31_] += i_30_;
                     i_28_ += i_30_;
                  }
               }

               for(int i_32_ = 0; i_14_ > i_32_; ++i_32_) {
                  int i_33_;
                  if (is_15_ == null) {
                     i_33_ = i_32_;
                  } else {
                     i_33_ = is_15_[i_32_];
                  }

                  if (~this.anInt3795 == -1) {
                     objects[i_33_] = Class135.method1588(bs_26_[i_32_]);
                  } else {
                     objects[i_33_] = bs_26_[i_32_];
                  }
               }
            } else {
               int i_34_ = bs_18_.length;
               int i_35_ = 255 & bs_18_[--i_34_];
               i_34_ -= i_35_ * i_14_ * 4;
               Buffer buffer = new Buffer(bs_18_);
               int i_36_ = 0;
               buffer.offset = i_34_;
               int i_37_ = 0;

               for(int i_38_ = 0; i_38_ < i_35_; ++i_38_) {
                  int i_39_ = 0;

                  for(int i_40_ = 0; ~i_40_ > ~i_14_; ++i_40_) {
                     i_39_ += buffer.readInt();
                     int i_41_;
                     if (is_15_ != null) {
                        i_41_ = is_15_[i_40_];
                     } else {
                        i_41_ = i_40_;
                     }

                     if (~fileId == ~i_41_) {
                        i_37_ = i_41_;
                        i_36_ += i_39_;
                     }
                  }
               }

               if (i_36_ == 0) {
                  return true;
               }

               byte[] bs_42_ = new byte[i_36_];
               buffer.offset = i_34_;
               i_36_ = 0;
               int i_43_ = 0;

               for(int i_44_ = 0; ~i_44_ > ~i_35_; ++i_44_) {
                  int i_45_ = 0;

                  for(int i_46_ = 0; ~i_46_ > ~i_14_; ++i_46_) {
                     i_45_ += buffer.readInt();
                     int i_47_;
                     if (is_15_ != null) {
                        i_47_ = is_15_[i_46_];
                     } else {
                        i_47_ = i_46_;
                     }

                     if (~i_47_ == ~fileId) {
                        Class311.method3608(bs_18_, i_43_, bs_42_, i_36_, i_45_);
                        i_36_ += i_45_;
                     }

                     i_43_ += i_45_;
                  }
               }

               objects[i_37_] = bs_42_;
            }

            return true;
         }
      }
   }

   final boolean method3515(int i, int i_48_, int i_49_) {
      ++anInt3785;
      if (!this.fileExists(i, i_48_, (byte)127)) {
         return false;
      } else if (this.cachedFiles[i_48_] != null && this.cachedFiles[i_48_][i] != null) {
         return true;
      } else if (this.anObjectArray3783[i_48_] != null) {
         return true;
      } else {
         this.method3508(i_48_, i_49_);
         return this.anObjectArray3783[i_48_] != null;
      }
   }

   final boolean method3516(String string, int i) {
      ++anInt3799;
      if (!this.method3530(0)) {
         return false;
      } else {
         if (i >= -72) {
            this.aBoolean3819 = true;
         }

         string = string.toLowerCase();
         int i_50_ = this.anArchive3797.aClass75_301.method766(-1, Class336_Sub1.method3887(false, string));
         return ~i_50_ <= -1;
      }
   }

   private final void method3517(int i, int i_51_) {
      ++anInt3807;
      if (i > -103) {
         this.anObjectArray3783 = null;
      }

      this.aClass34_3804.method368(0, i_51_);
   }

   final byte[] method3518(byte b, int i) {
      ++anInt3790;
      if (!this.method3530(0)) {
         return null;
      } else if (this.anArchive3797.anIntArray285.length == 1) {
         return this.getFile(false, i, 0);
      } else if (!this.method3525((byte)-86, i)) {
         return null;
      } else if (this.anArchive3797.anIntArray285[i] == 1) {
         return this.getFile(false, 0, i);
      } else {
         throw new RuntimeException();
      }
   }

   final int method3519(String string, byte b) {
      ++anInt3787;
      if (!this.method3530(0)) {
         return -1;
      } else if (b <= 4) {
         return 19;
      } else {
         string = string.toLowerCase();
         int i = this.anArchive3797.aClass75_301.method766(-1, Class336_Sub1.method3887(false, string));
         return !this.method3525((byte)-86, i) ? -1 : i;
      }
   }

   final boolean method3520(byte b) {
      ++anInt3793;
      if (!this.method3530(b ^ 15)) {
         return false;
      } else {
         if (b != 15) {
            this.aClass34_3804 = null;
         }

         boolean bool = true;

         for(int i = 0; this.anArchive3797.validArchiveIds.length > i; ++i) {
            int i_53_ = this.anArchive3797.validArchiveIds[i];
            if (this.anObjectArray3783[i_53_] == null) {
               this.method3508(i_53_, 0);
               if (this.anObjectArray3783[i_53_] == null) {
                  bool = false;
               }
            }
         }

         return bool;
      }
   }

   final void method3521(byte b) {
      if (this.cachedFiles != null) {
         for(int i = 0; ~this.cachedFiles.length < ~i; ++i) {
            this.cachedFiles[i] = null;
         }
      }

      if (b != -18) {
         this.method3522((byte)-82, null);
      }

      ++anInt3818;
   }

   final int method3522(byte b, String string) {
      ++anInt3789;
      if (!this.method3530(0)) {
         return 0;
      } else {
         if (b <= 26) {
            this.method3533(true, null, null);
         }

         string = string.toLowerCase();
         int i = this.anArchive3797.aClass75_301.method766(-1, Class336_Sub1.method3887(false, string));
         return this.method3509(false, i);
      }
   }

   final void method3523(byte b) {
      ++anInt3796;
      if (b != -46) {
         this.method3527(null, 1);
      }

      if (this.anObjectArray3783 != null) {
         for(int i = 0; ~this.anObjectArray3783.length < ~i; ++i) {
            this.anObjectArray3783[i] = null;
         }
      }
   }

   final byte[] getFile(boolean bool, int fileId, int archiveId) {
      if (bool) {
         this.aClass34_3804 = null;
      }

      ++anInt3784;
      return this.getFile(null, fileId, -126, archiveId);
   }

   private final boolean method3525(byte b, int i) {
      ++anInt3792;
      if (!this.method3530(0)) {
         return false;
      } else if (i >= 0 && i < this.anArchive3797.anIntArray285.length && this.anArchive3797.anIntArray285[i] != 0) {
         if (b != -86) {
            this.getFile(false, 111, -26);
         }

         return true;
      } else if (!Class144_Sub3.aBoolean6833) {
         return false;
      } else {
         throw new IllegalArgumentException(Integer.toString(i));
      }
   }

   final int method3526(int i) {
      ++anInt3782;
      if (i != -20871) {
         this.method3532(-99, -38);
      }

      return !this.method3530(0) ? -1 : this.anArchive3797.anIntArray285.length;
   }

   final boolean method3527(String string, int i) {
      ++anInt3800;
      if (!this.method3530(i)) {
         return false;
      } else {
         string = string.toLowerCase();
         int i_55_ = this.anArchive3797.aClass75_301.method766(-1, Class336_Sub1.method3887(false, string));
         return this.method3536(-1, i_55_);
      }
   }

   final int method3528(byte b, int i) {
      ++anInt3815;
      if (!this.method3530(0)) {
         return -1;
      } else {
         int i_56_ = this.anArchive3797.aClass75_301.method766(-1, i);
         if (b != -48) {
            this.method3507((byte)-79, null);
         }

         return !this.method3525((byte)-86, i_56_) ? -1 : i_56_;
      }
   }

   final byte[] method3529(String string, String string_57_, int i) {
      ++anInt3820;
      if (!this.method3530(0)) {
         return null;
      } else {
         string = string.toLowerCase();
         string_57_ = string_57_.toLowerCase();
         int i_58_ = this.anArchive3797.aClass75_301.method766(-1, Class336_Sub1.method3887(false, string));
         if (!this.method3525((byte)-86, i_58_)) {
            return null;
         } else {
            if (i != 1) {
               this.method3517(45, -91);
            }

            int i_59_ = this.anArchive3797.aClass75Array288[i_58_].method766(-1, Class336_Sub1.method3887(false, string_57_));
            if (string_57_.equals("area")) {
               System.out.println("Archive: " + i_58_ + " File: " + i_59_);
            }

            return this.getFile(false, i_59_, i_58_);
         }
      }
   }

   private final boolean method3530(int i) {
      if (i != 0) {
         return false;
      } else {
         ++anInt3808;
         if (this.anArchive3797 == null) {
            this.anArchive3797 = this.aClass34_3804.method374((byte)0);
            if (this.anArchive3797 == null) {
               return false;
            }

            this.cachedFiles = new Object[this.anArchive3797.archivesLength][];
            this.anObjectArray3783 = new Object[this.anArchive3797.archivesLength];
         }

         return true;
      }
   }

   final void method3531(String string, int i) {
      ++anInt3809;
      if (this.method3530(0)) {
         string = string.toLowerCase();
         if (i != -18758) {
            this.aClass34_3804 = null;
         }

         int i_60_ = this.anArchive3797.aClass75_301.method766(-1, Class336_Sub1.method3887(false, string));
         this.method3517(-120, i_60_);
      }
   }

   final int[] method3532(int i, int i_61_) {
      ++anInt3811;
      if (!this.method3525((byte)-86, i)) {
         return null;
      } else {
         int[] is = this.anArchive3797.anIntArrayArray290[i];
         if (is == null) {
            is = new int[this.anArchive3797.anIntArray295[i]];
            int i_62_ = 0;

            while(i_62_ < is.length) {
               is[i_62_] = i_62_++;
            }
         }

         return i_61_ != 0 ? null : is;
      }
   }

   private final boolean method3533(boolean bool, String string, String string_63_) {
      ++anInt3816;
      if (!this.method3530(0)) {
         return false;
      } else {
         string = string.toLowerCase();
         string_63_ = string_63_.toLowerCase();
         int i = this.anArchive3797.aClass75_301.method766(-1, Class336_Sub1.method3887(bool, string));
         if (!this.method3525((byte)-86, i)) {
            return false;
         } else {
            int i_64_ = this.anArchive3797.aClass75Array288[i].method766(-1, Class336_Sub1.method3887(bool, string_63_));
            return this.method3515(i_64_, i, 0);
         }
      }
   }

   final void method3534(byte b, int i) {
      ++anInt3805;
      if (this.method3525((byte)-86, i) && this.cachedFiles != null) {
         this.cachedFiles[i] = null;
      }
   }

   static final void method3535(java.awt.Canvas canvas, boolean bool) {
      ++anInt3806;
      Dimension dimension = canvas.getSize();
      if (bool) {
         Node_Sub15_Sub8.method2575(dimension.height, dimension.width, 110);
         if (Class320_Sub20.anInt8397 != 1) {
            Class44.aGraphicsToolkit668.a(canvas, Animable_Sub1_Sub2.anInt10668, Class148.anInt1825);
         } else {
            Class44.aGraphicsToolkit668.a(canvas, CacheNode_Sub15.anInt9589, Class303.anInt3831);
         }
      }
   }

   final boolean method3536(int i, int i_66_) {
      ++anInt3801;
      if (!this.method3525((byte)-86, i_66_)) {
         return false;
      } else if (this.anObjectArray3783[i_66_] != null) {
         return true;
      } else {
         if (i != -1) {
            this.method3511(-127);
         }

         this.method3508(i_66_, 0);
         return this.anObjectArray3783[i_66_] != null;
      }
   }

   final int method3537(int i, int i_67_) {
      if (i != -2) {
         this.anInt3795 = 123;
      }

      ++anInt3802;
      return !this.method3525((byte)-86, i_67_) ? 0 : this.anArchive3797.anIntArray285[i_67_];
   }

   Index(Class34 class34, boolean bool, int i) {
      if (i >= 0 && ~i >= -3) {
         this.aClass34_3804 = class34;
         this.aBoolean3819 = bool;
         this.anInt3795 = i;
      } else {
         throw new IllegalArgumentException("js5: Invalid value " + i + " supplied for discardunpacked");
      }
   }
}
