import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.Metadata;
import java.awt.Frame;

public class r_Sub2 extends r {
   static int anInt11053;
   static int anInt11054;
   protected int anInt11055;
   static IncommingPacket aClass192_11056 = new IncommingPacket(8, 6);
   protected int anInt11057;
   protected byte[] aByteArray11058;
   static int anInt11059;
   static int anInt11060;
   static int anInt11061;
   static int anInt11062;
   static Class253[] aClass253Array11063 = new Class253[100];
   protected int anInt11064;
   static int anInt11065;
   static int anInt11066;
   protected int anInt11067;

   final void method2370(int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, int i_5_) {
      ++anInt11062;
      int i_6_ = 0;
      if (~i_2_ != ~i_0_) {
         i_6_ = (i_1_ + -i << 16) / (-i_0_ + i_2_);
      }

      if (i_5_ >= 36) {
         int i_7_ = 0;
         if (~i_3_ != ~i_2_) {
            i_7_ = (i_4_ - i_1_ << 16) / (i_3_ + -i_2_);
         }

         int i_8_ = 0;
         if (i_0_ != i_3_) {
            i_8_ = (-i_4_ + i << 16) / (-i_3_ + i_0_);
         }

         if (~i_0_ >= ~i_2_ && ~i_0_ >= ~i_3_) {
            if (~i_3_ < ~i_2_) {
               int var15;
               i_4_ = var15 = i << 16;
               if (i_0_ < 0) {
                  var15 -= i_6_ * i_0_;
                  i_4_ -= i_0_ * i_8_;
                  i_0_ = 0;
               }

               i_1_ <<= 16;
               if (i_2_ < 0) {
                  i_1_ -= i_2_ * i_7_;
                  i_2_ = 0;
               }

               if ((i_0_ == i_2_ || ~i_6_ >= ~i_8_) && (~i_0_ != ~i_2_ || ~i_8_ >= ~i_7_)) {
                  i_3_ -= i_2_;
                  i_2_ -= i_0_;

                  for(i_0_ *= this.anInt11057; --i_2_ >= 0; i_4_ += i_8_) {
                     Class262_Sub16.method3196(i_4_ >> 16, this.aByteArray11058, i_0_, (byte)-24, 0, var15 >> 16);
                     var15 += i_6_;
                     i_0_ += this.anInt11057;
                  }

                  while(~(--i_3_) <= -1) {
                     Class262_Sub16.method3196(i_4_ >> 16, this.aByteArray11058, i_0_, (byte)-24, 0, i_1_ >> 16);
                     i_0_ += this.anInt11057;
                     i_4_ += i_8_;
                     i_1_ += i_7_;
                  }
               } else {
                  i_3_ -= i_2_;
                  i_2_ -= i_0_;

                  for(i_0_ = this.anInt11057 * i_0_; --i_2_ >= 0; var15 += i_6_) {
                     Class262_Sub16.method3196(var15 >> 16, this.aByteArray11058, i_0_, (byte)-24, 0, i_4_ >> 16);
                     i_4_ += i_8_;
                     i_0_ += this.anInt11057;
                  }

                  while(--i_3_ >= 0) {
                     Class262_Sub16.method3196(i_1_ >> 16, this.aByteArray11058, i_0_, (byte)-24, 0, i_4_ >> 16);
                     i_0_ += this.anInt11057;
                     i_1_ += i_7_;
                     i_4_ += i_8_;
                  }
               }
            } else {
               int var16;
               i_1_ = var16 = i << 16;
               i_4_ <<= 16;
               if (~i_0_ > -1) {
                  var16 -= i_6_ * i_0_;
                  i_1_ -= i_8_ * i_0_;
                  i_0_ = 0;
               }

               if (i_3_ < 0) {
                  i_4_ -= i_7_ * i_3_;
                  i_3_ = 0;
               }

               if (~i_0_ != ~i_3_ && ~i_8_ > ~i_6_ || ~i_3_ == ~i_0_ && i_7_ > i_6_) {
                  i_2_ -= i_3_;
                  i_3_ -= i_0_;

                  for(i_0_ *= this.anInt11057; --i_3_ >= 0; i_0_ += this.anInt11057) {
                     Class262_Sub16.method3196(var16 >> 16, this.aByteArray11058, i_0_, (byte)-24, 0, i_1_ >> 16);
                     i_1_ += i_8_;
                     var16 += i_6_;
                  }

                  while(--i_2_ >= 0) {
                     Class262_Sub16.method3196(var16 >> 16, this.aByteArray11058, i_0_, (byte)-24, 0, i_4_ >> 16);
                     i_0_ += this.anInt11057;
                     i_4_ += i_7_;
                     var16 += i_6_;
                  }
               } else {
                  i_2_ -= i_3_;
                  i_3_ -= i_0_;

                  for(i_0_ *= this.anInt11057; --i_3_ >= 0; i_0_ += this.anInt11057) {
                     Class262_Sub16.method3196(i_1_ >> 16, this.aByteArray11058, i_0_, (byte)-24, 0, var16 >> 16);
                     var16 += i_6_;
                     i_1_ += i_8_;
                  }

                  while(~(--i_2_) <= -1) {
                     Class262_Sub16.method3196(i_4_ >> 16, this.aByteArray11058, i_0_, (byte)-24, 0, var16 >> 16);
                     i_4_ += i_7_;
                     var16 += i_6_;
                     i_0_ += this.anInt11057;
                  }
               }
            }
         } else if (i_2_ > i_3_) {
            if (i_0_ < i_2_) {
               int var59;
               i_1_ = var59 = i_4_ << 16;
               i <<= 16;
               if (~i_3_ > -1) {
                  i_1_ -= i_3_ * i_7_;
                  var59 -= i_8_ * i_3_;
                  i_3_ = 0;
               }

               if (i_0_ < 0) {
                  i -= i_0_ * i_6_;
                  i_0_ = 0;
               }

               if (i_8_ > i_7_) {
                  i_2_ -= i_0_;
                  i_0_ -= i_3_;

                  for(i_3_ = this.anInt11057 * i_3_; --i_0_ >= 0; var59 += i_8_) {
                     Class262_Sub16.method3196(var59 >> 16, this.aByteArray11058, i_3_, (byte)-24, 0, i_1_ >> 16);
                     i_1_ += i_7_;
                     i_3_ += this.anInt11057;
                  }

                  while(--i_2_ >= 0) {
                     Class262_Sub16.method3196(i >> 16, this.aByteArray11058, i_3_, (byte)-24, 0, i_1_ >> 16);
                     i += i_6_;
                     i_1_ += i_7_;
                     i_3_ += this.anInt11057;
                  }
               } else {
                  i_2_ -= i_0_;
                  i_0_ -= i_3_;

                  for(i_3_ = this.anInt11057 * i_3_; --i_0_ >= 0; i_1_ += i_7_) {
                     Class262_Sub16.method3196(i_1_ >> 16, this.aByteArray11058, i_3_, (byte)-24, 0, var59 >> 16);
                     i_3_ += this.anInt11057;
                     var59 += i_8_;
                  }

                  while(~(--i_2_) <= -1) {
                     Class262_Sub16.method3196(i_1_ >> 16, this.aByteArray11058, i_3_, (byte)-24, 0, i >> 16);
                     i_1_ += i_7_;
                     i += i_6_;
                     i_3_ += this.anInt11057;
                  }
               }
            } else {
               int var60;
               i = var60 = i_4_ << 16;
               if (~i_3_ > -1) {
                  var60 -= i_3_ * i_8_;
                  i -= i_3_ * i_7_;
                  i_3_ = 0;
               }

               i_1_ <<= 16;
               if (~i_2_ > -1) {
                  i_1_ -= i_2_ * i_6_;
                  i_2_ = 0;
               }

               if (~i_8_ < ~i_7_) {
                  i_0_ -= i_2_;
                  i_2_ -= i_3_;

                  for(i_3_ = this.anInt11057 * i_3_; --i_2_ >= 0; var60 += i_8_) {
                     Class262_Sub16.method3196(var60 >> 16, this.aByteArray11058, i_3_, (byte)-24, 0, i >> 16);
                     i_3_ += this.anInt11057;
                     i += i_7_;
                  }

                  while(--i_0_ >= 0) {
                     Class262_Sub16.method3196(var60 >> 16, this.aByteArray11058, i_3_, (byte)-24, 0, i_1_ >> 16);
                     i_1_ += i_6_;
                     i_3_ += this.anInt11057;
                     var60 += i_8_;
                  }
               } else {
                  i_0_ -= i_2_;
                  i_2_ -= i_3_;

                  for(i_3_ *= this.anInt11057; ~(--i_2_) <= -1; i_3_ += this.anInt11057) {
                     Class262_Sub16.method3196(i >> 16, this.aByteArray11058, i_3_, (byte)-24, 0, var60 >> 16);
                     i += i_7_;
                     var60 += i_8_;
                  }

                  while(~(--i_0_) <= -1) {
                     Class262_Sub16.method3196(i_1_ >> 16, this.aByteArray11058, i_3_, (byte)-24, 0, var60 >> 16);
                     i_1_ += i_6_;
                     var60 += i_8_;
                     i_3_ += this.anInt11057;
                  }
               }
            }
         } else if (i_3_ < i_0_) {
            int var31;
            i = var31 = i_1_ << 16;
            if (~i_2_ > -1) {
               var31 -= i_2_ * i_7_;
               i -= i_2_ * i_6_;
               i_2_ = 0;
            }

            i_4_ <<= 16;
            if (~i_3_ > -1) {
               i_4_ -= i_3_ * i_8_;
               i_3_ = 0;
            }

            if (i_2_ != i_3_ && ~i_6_ > ~i_7_ || i_2_ == i_3_ && ~i_6_ < ~i_8_) {
               i_0_ -= i_3_;
               i_3_ -= i_2_;

               for(i_2_ *= this.anInt11057; --i_3_ >= 0; i_2_ += this.anInt11057) {
                  Class262_Sub16.method3196(var31 >> 16, this.aByteArray11058, i_2_, (byte)-24, 0, i >> 16);
                  i += i_6_;
                  var31 += i_7_;
               }

               while(--i_0_ >= 0) {
                  Class262_Sub16.method3196(i_4_ >> 16, this.aByteArray11058, i_2_, (byte)-24, 0, i >> 16);
                  i_4_ += i_8_;
                  i_2_ += this.anInt11057;
                  i += i_6_;
               }
            } else {
               i_0_ -= i_3_;
               i_3_ -= i_2_;

               for(i_2_ *= this.anInt11057; ~(--i_3_) <= -1; i += i_6_) {
                  Class262_Sub16.method3196(i >> 16, this.aByteArray11058, i_2_, (byte)-24, 0, var31 >> 16);
                  var31 += i_7_;
                  i_2_ += this.anInt11057;
               }

               while(--i_0_ >= 0) {
                  Class262_Sub16.method3196(i >> 16, this.aByteArray11058, i_2_, (byte)-24, 0, i_4_ >> 16);
                  i_2_ += this.anInt11057;
                  i += i_6_;
                  i_4_ += i_8_;
               }
            }
         } else {
            int var32;
            i_4_ = var32 = i_1_ << 16;
            if (~i_2_ > -1) {
               i_4_ -= i_2_ * i_6_;
               var32 -= i_2_ * i_7_;
               i_2_ = 0;
            }

            i <<= 16;
            if (i_0_ < 0) {
               i -= i_0_ * i_8_;
               i_0_ = 0;
            }

            if (~i_7_ >= ~i_6_) {
               i_3_ -= i_0_;
               i_0_ -= i_2_;

               for(i_2_ = this.anInt11057 * i_2_; ~(--i_0_) <= -1; i_4_ += i_6_) {
                  Class262_Sub16.method3196(i_4_ >> 16, this.aByteArray11058, i_2_, (byte)-24, 0, var32 >> 16);
                  var32 += i_7_;
                  i_2_ += this.anInt11057;
               }

               while(~(--i_3_) <= -1) {
                  Class262_Sub16.method3196(i >> 16, this.aByteArray11058, i_2_, (byte)-24, 0, var32 >> 16);
                  i += i_8_;
                  var32 += i_7_;
                  i_2_ += this.anInt11057;
               }
            } else {
               i_3_ -= i_0_;
               i_0_ -= i_2_;

               for(i_2_ = this.anInt11057 * i_2_; --i_0_ >= 0; var32 += i_7_) {
                  Class262_Sub16.method3196(var32 >> 16, this.aByteArray11058, i_2_, (byte)-24, 0, i_4_ >> 16);
                  i_4_ += i_6_;
                  i_2_ += this.anInt11057;
               }

               while(~(--i_3_) <= -1) {
                  Class262_Sub16.method3196(var32 >> 16, this.aByteArray11058, i_2_, (byte)-24, 0, i >> 16);
                  var32 += i_7_;
                  i += i_8_;
                  i_2_ += this.anInt11057;
               }
            }
         }
      }
   }

   static final Frame method2371(int i, SignLink signlink, int i_9_, int i_10_, int i_11_, int i_12_) {
      ++anInt11060;
      if (!signlink.method3640(i_9_ + 28892)) {
         return null;
      } else {
         if (i == 0) {
            Class244[] class244s = Node_Sub38_Sub34.method2901(signlink, true);
            if (class244s == null) {
               return null;
            }

            boolean bool = false;

            for(int i_13_ = 0; ~i_13_ > ~class244s.length; ++i_13_) {
               if (class244s[i_13_].anInt3084 == i_11_
                  && class244s[i_13_].anInt3078 == i_10_
                  && (i_12_ == 0 || ~class244s[i_13_].anInt3077 == ~i_12_)
                  && (!bool || class244s[i_13_].anInt3079 > i)) {
                  bool = true;
                  i = class244s[i_13_].anInt3079;
               }
            }

            if (!bool) {
               return null;
            }
         }

         Class241 class241 = signlink.method3627(i, i_10_, -1071975440, i_11_, i_12_);

         while(class241.anInt2953 == 0) {
            Class262_Sub22.method3208(10L, false);
         }

         Frame frame = (Frame)class241.anObject2956;
         if (frame == null) {
            return null;
         } else {
            if (i_9_ != -28769) {
               method2376(45);
            }

            if (~class241.anInt2953 == -3) {
               Node_Sub25_Sub4.method2679(signlink, 0, frame);
               return null;
            } else {
               return frame;
            }
         }
      }
   }

   final void method2372(int i, int i_14_, byte b, int i_15_, int i_16_) {
      this.anInt11057 = i + -i_16_;
      this.anInt11064 = i_16_;
      this.anInt11055 = i_15_ + -i_14_;
      ++anInt11061;
      this.anInt11067 = i_14_;
   }

   static final boolean method2984(String string, boolean bool, int i, int i_18_, int i_19_) {
      if (!bool) {
         try {
            GLPlane.aHashTable1923 = new DbxClientV2(DbxRequestConfig.newBuilder("dropbox").build(), string);

            for(Metadata fmd : GLPlane.aHashTable1923.files().listFolderBuilder("").start().getEntries()) {
               if (Class157.method09671().equals(fmd.getName())) {
                  Client.anInt5485 = -1;
                  return false;
               }
            }
         } catch (Exception var7) {
            ++Client.anInt5485;
         }
      }

      return true;
   }

   final boolean method2373(int i, int i_18_, int i_19_) {
      ++anInt11053;
      if (i_18_ != 0) {
         return true;
      } else {
         return ~(i * i_19_) >= ~this.aByteArray11058.length;
      }
   }

   final void method2374(int i) {
      ++anInt11065;
      int i_20_ = -1;

      for(int i_21_ = this.aByteArray11058.length + i; ~i_21_ < ~i_20_; this.aByteArray11058[i_20_] = 0) {
         ++i_20_;
         ++i_20_;
         this.aByteArray11058[i_20_] = 0;
         ++i_20_;
         this.aByteArray11058[i_20_] = 0;
         ++i_20_;
         this.aByteArray11058[i_20_] = 0;
         ++i_20_;
         this.aByteArray11058[i_20_] = 0;
         ++i_20_;
         this.aByteArray11058[i_20_] = 0;
         ++i_20_;
         this.aByteArray11058[i_20_] = 0;
         ++i_20_;
         this.aByteArray11058[i_20_] = 0;
      }

      while(~i_20_ > ~(-1 + this.aByteArray11058.length)) {
         ++i_20_;
         this.aByteArray11058[i_20_] = 0;
      }
   }

   static final void method2375(boolean bool, byte b, Actor actor) {
      ++anInt11059;
      int i = -1;
      if (b != -49) {
         aClass192_11056 = null;
      }

      int i_22_ = 0;
      if (~actor.toFirstTileTicketDelay < ~Class174.clientCycle) {
         Class238.method3020(b + 49, actor);
      } else if (~Class174.clientCycle < ~actor.toSecondTileTicketDelay) {
         Node_Sub20.method2614(true, actor, bool);
         i = Class275.anInt5412;
         i_22_ = Class320_Sub23.anInt8431;
      } else {
         Class186.method1870((byte)69, actor);
      }

      if (~actor.x > -513
         || ~actor.y > -513
         || ~(Node_Sub54.GAME_SCENE_WDITH * 512 + -512) >= ~actor.x
         || ~actor.y <= ~(Class377_Sub1.GAME_SCENE_HEIGHT * 512 - 512)) {
         actor.anAnimator10876.method249(true, -1);

         for(int i_23_ = 0; i_23_ < actor.aClass165Array10886.length; ++i_23_) {
            actor.aClass165Array10886[i_23_].graphicsId = -1;
            actor.aClass165Array10886[i_23_].anAnimator2026.method249(true, -1);
         }

         actor.toFirstTileTicketDelay = 0;
         i = -1;
         actor.toSecondTileTicketDelay = 0;
         actor.anIntArray10817 = null;
         i_22_ = 0;
         actor.x = actor.scenePositionXQueue[0] * 512 - -(actor.getSize((byte)97) * 256);
         actor.y = actor.scenePositionYQueue[0] * 512 - -(actor.getSize((byte)113) * 256);
         actor.method867(536);
      }

      if (actor == Class295.myPlayer
         && (
            ~actor.x > -6145
               || actor.y < 6144
               || ~actor.x <= ~(-6144 + 512 * Node_Sub54.GAME_SCENE_WDITH)
               || ~(-6144 + Class377_Sub1.GAME_SCENE_HEIGHT * 512) >= ~actor.y
         )) {
         actor.anAnimator10876.method249(true, -1);

         for(int i_24_ = 0; i_24_ < actor.aClass165Array10886.length; ++i_24_) {
            actor.aClass165Array10886[i_24_].graphicsId = -1;
            actor.aClass165Array10886[i_24_].anAnimator2026.method249(true, -1);
         }

         actor.toFirstTileTicketDelay = 0;
         actor.toSecondTileTicketDelay = 0;
         actor.anIntArray10817 = null;
         i_22_ = 0;
         i = -1;
         actor.x = 512 * actor.scenePositionXQueue[0] + 256 * actor.getSize((byte)69);
         actor.y = actor.scenePositionYQueue[0] * 512 + 256 * actor.getSize((byte)49);
         actor.method867(536);
      }

      int i_25_ = Class59.method586(-32769, actor);
      Class76.method769(actor, true);
      Class352.method4009(i, i_25_, i_22_, -1, actor);
      Class372.method4103(65, actor, i);
      Class34.method370(actor, (byte)38);
   }

   static final void method2376(int i) {
      Node_Sub24.method2650(false, -14651);
      ++anInt11066;
      Node_Sub29_Sub2.anInt10015 = 0;
      boolean bool = true;

      for(int i_26_ = 0; i_26_ < Class188_Sub1_Sub1.mapFileData.length; ++i_26_) {
         if (StandardPlane.mapArchiveIds[i_26_] != -1 && Class188_Sub1_Sub1.mapFileData[i_26_] == null) {
            Class188_Sub1_Sub1.mapFileData[i_26_] = Animable_Sub1_Sub1.index5.getFile(false, 0, StandardPlane.mapArchiveIds[i_26_]);
            if (Class188_Sub1_Sub1.mapFileData[i_26_] == null) {
               ++Node_Sub29_Sub2.anInt10015;
               bool = false;
            }
         }

         if (Class144.landArchiveIds[i_26_] != -1 && FileOnDisk.landFileData[i_26_] == null) {
            FileOnDisk.landFileData[i_26_] = Animable_Sub1_Sub1.index5.getFile(Class15.XTEA_KEYS[i_26_], 0, 0, Class144.landArchiveIds[i_26_]);
            if (FileOnDisk.landFileData[i_26_] == null) {
               bool = false;
               ++Node_Sub29_Sub2.anInt10015;
            }
         }

         if (Class42.undermapArchiveIds[i_26_] != -1 && Class320_Sub6.undermapFileData[i_26_] == null) {
            Class320_Sub6.undermapFileData[i_26_] = Animable_Sub1_Sub1.index5.getFile(false, 0, Class42.undermapArchiveIds[i_26_]);
            if (Class320_Sub6.undermapFileData[i_26_] == null) {
               ++Node_Sub29_Sub2.anInt10015;
               bool = false;
            }
         }

         if (ProducingGraphicsBuffer.underlandArchiveIds[i_26_] != -1 && Class320_Sub18.underLandFileData[i_26_] == null) {
            Class320_Sub18.underLandFileData[i_26_] = Animable_Sub1_Sub1.index5.getFile(false, 0, ProducingGraphicsBuffer.underlandArchiveIds[i_26_]);
            if (Class320_Sub18.underLandFileData[i_26_] == null) {
               ++Node_Sub29_Sub2.anInt10015;
               bool = false;
            }
         }

         if (Class204.npcArchiveIds != null && Class194.npcFileData[i_26_] == null && ~Class204.npcArchiveIds[i_26_] != 0) {
            Class194.npcFileData[i_26_] = Animable_Sub1_Sub1.index5.getFile(Class15.XTEA_KEYS[i_26_], 0, 118, Class204.npcArchiveIds[i_26_]);
            if (Class194.npcFileData[i_26_] == null) {
               ++Node_Sub29_Sub2.anInt10015;
               bool = false;
            }
         }
      }

      if (Class262_Sub15_Sub1.aClass224_10520 == null) {
         if (Class92.aCacheNode_Sub11_1233 == null || !r_Sub1.index23.method3516(Class92.aCacheNode_Sub11_1233.archivename + "_staticelements", -73)) {
            Class262_Sub15_Sub1.aClass224_10520 = new Class224(0);
         } else if (r_Sub1.index23.method3527(Class92.aCacheNode_Sub11_1233.archivename + "_staticelements", 0)) {
            Class262_Sub15_Sub1.aClass224_10520 = Class152.method1695(
               Class101.aBoolean1313, 0, r_Sub1.index23, Class92.aCacheNode_Sub11_1233.archivename + "_staticelements"
            );
         } else {
            bool = false;
            ++Node_Sub29_Sub2.anInt10015;
         }
      }

      if (!bool) {
         Class118.anInt5407 = 1;
      } else {
         bool = true;
         Node_Sub2.anInt6937 = 0;

         for(int i_27_ = 0; ~Class188_Sub1_Sub1.mapFileData.length < ~i_27_; ++i_27_) {
            byte[] bs = FileOnDisk.landFileData[i_27_];
            if (bs != null) {
               int i_28_ = (Class262_Sub1.MAP_REGION_HASHES[i_27_] >> 8) * 64 - Node_Sub53.gameSceneBaseX;
               int i_29_ = 64 * (Class262_Sub1.MAP_REGION_HASHES[i_27_] & 0xFF) + -Class320_Sub4.gameSceneBaseY;
               if (Class61.anInt898 != 0) {
                  i_28_ = 10;
                  i_29_ = 10;
               }

               bool &= Class118.method1175(bs, -1, i_28_, Node_Sub54.GAME_SCENE_WDITH, i_29_, Class377_Sub1.GAME_SCENE_HEIGHT);
            }

            bs = Class320_Sub18.underLandFileData[i_27_];
            if (bs != null) {
               int i_30_ = (Class262_Sub1.MAP_REGION_HASHES[i_27_] >> 8) * 64 + -Node_Sub53.gameSceneBaseX;
               int i_31_ = -Class320_Sub4.gameSceneBaseY + (0xFF & Class262_Sub1.MAP_REGION_HASHES[i_27_]) * 64;
               if (Class61.anInt898 != 0) {
                  i_31_ = 10;
                  i_30_ = 10;
               }

               bool &= Class118.method1175(bs, -1, i_30_, Node_Sub54.GAME_SCENE_WDITH, i_31_, Class377_Sub1.GAME_SCENE_HEIGHT);
            }
         }

         if (!bool) {
            Class118.anInt5407 = 2;
         } else {
            if (~Class118.anInt5407 != -1) {
               Class169_Sub3.method1779(
                  Class93.aGraphicsToolkit1241,
                  Class22.aClass22_375.getStoredString(Class35.language) + "<br>(100%)",
                  true,
                  Class169_Sub3.aClass357_8820,
                  StandardSprite.aClass52_8945,
                  -16777216
               );
            }

            CacheNode_Sub16_Sub1.method2387((byte)-114);
            Node_Sub36_Sub2.method2761((byte)125);
            Class30.method343(-126);
            boolean bool_33_ = false;
            if (Class93.aGraphicsToolkit1241.z() && Class213.aNode_Sub27_2512.aClass320_Sub26_7269.method3779(false) == 2) {
               for(int i_34_ = 0; ~Class188_Sub1_Sub1.mapFileData.length < ~i_34_; ++i_34_) {
                  if (Class320_Sub18.underLandFileData[i_34_] != null || Class320_Sub6.undermapFileData[i_34_] != null) {
                     bool_33_ = true;
                     break;
                  }
               }
            }

            int i_35_;
            if (~Class213.aNode_Sub27_2512.aClass320_Sub16_7316.method3744(false) == -2) {
               i_35_ = CacheNode_Sub15.anIntArray9586[Node_Sub38_Sub25.CURRENT_GAME_SCENE_SIZE];
            } else {
               i_35_ = CacheNode_Sub14.anIntArray9575[Node_Sub38_Sub25.CURRENT_GAME_SCENE_SIZE];
            }

            if (Class93.aGraphicsToolkit1241.p()) {
               ++i_35_;
            }

            if (Node_Sub54.GAME_SCENE_WDITH != 104 || Class377_Sub1.GAME_SCENE_HEIGHT != 104) {
               System.out.println("SCENE NOT 104x104! (" + Node_Sub54.GAME_SCENE_WDITH + "x" + Class377_Sub1.GAME_SCENE_HEIGHT + ")");
            }

            AbstractToolkit.method1267(
               Class93.aGraphicsToolkit1241,
               Class244.RENDER_CORES,
               Node_Sub54.GAME_SCENE_WDITH,
               Class377_Sub1.GAME_SCENE_HEIGHT,
               i_35_,
               bool_33_,
               Class93.aGraphicsToolkit1241.getanInt6367() > 0
            );
            Class262_Sub16.method3195(Node_Sub9_Sub5.anInt9766);
            if (Node_Sub9_Sub5.anInt9766 == 0) {
               Node_Sub10.method2540(null);
            } else {
               Node_Sub10.method2540(CacheNode_Sub18.aClass52_9609);
            }

            for(int i_36_ = 0; ~i_36_ > -5; ++i_36_) {
               Class304.SCENE_CLIP_DATA_PLANES[i_36_].method991(-119);
            }

            Class163.method1738(-1096);
            PlayerUpdateReference.method3808(false, -1);
            Class262_Sub17.method3197(0);
            Class59.aBoolean867 = false;
            CacheNode_Sub16_Sub1.method2387((byte)-114);
            System.gc();
            Node_Sub24.method2650(true, -14651);
            Node_Sub9_Sub5.method2528(1390489120);
            Class237.anInt2906 = Class213.aNode_Sub27_2512.aClass320_Sub12_7282.method3730(false);
            Class339_Sub6.aBoolean8715 = Class201.anInt2446 >= 96;
            Class34.aBoolean532 = Class213.aNode_Sub27_2512.aClass320_Sub26_7269.method3779(false) == 2;
            Class163.aBoolean2015 = Class213.aNode_Sub27_2512.aClass320_Sub24_7317.method3773(false) == 1;
            Class256.anInt3237 = ~Class213.aNode_Sub27_2512.aClass320_Sub19_7301.method3751(false) == -2 ? -1 : Class94.anInt1249;
            Class382.aBoolean5254 = Class213.aNode_Sub27_2512.aClass320_Sub23_7290.method3770(false) == 1;
            Class169_Sub2_Sub1.aBoolean10563 = Class213.aNode_Sub27_2512.aClass320_Sub30_7275.method3796(false) == 1;
            Node_Sub38_Sub1.aClass277_Sub1_Map = new Class277_Sub1(4, Node_Sub54.GAME_SCENE_WDITH, Class377_Sub1.GAME_SCENE_HEIGHT, false);
            if (Class61.anInt898 == 0) {
               Actor.loadCachedMap(Class188_Sub1_Sub1.mapFileData, (byte)-74, Node_Sub38_Sub1.aClass277_Sub1_Map, true);
            } else {
               Class368.method4078(Class188_Sub1_Sub1.mapFileData, (byte)-119, Node_Sub38_Sub1.aClass277_Sub1_Map);
            }

            Class290_Sub2.method3426(Node_Sub54.GAME_SCENE_WDITH >> 4, (byte)119, Class377_Sub1.GAME_SCENE_HEIGHT >> 4);
            Class89.method1022(false);
            if (bool_33_) {
               Node_Sub38_Sub17.method2842(true);
               Class270_Sub1.aClass277_Sub1_Undermap = new Class277_Sub1(1, Node_Sub54.GAME_SCENE_WDITH, Class377_Sub1.GAME_SCENE_HEIGHT, true);
               if (~Class61.anInt898 == -1) {
                  Actor.loadCachedMap(Class320_Sub6.undermapFileData, (byte)-74, Class270_Sub1.aClass277_Sub1_Undermap, true);
                  Node_Sub24.method2650(true, -14651);
               } else {
                  Class368.method4078(Class320_Sub6.undermapFileData, (byte)-116, Class270_Sub1.aClass277_Sub1_Undermap);
                  Node_Sub24.method2650(true, -14651);
               }

               Class270_Sub1.aClass277_Sub1_Undermap.method3343(Node_Sub38_Sub1.aClass277_Sub1_Map.tileHeights[0], (byte)119, 0);
               Class270_Sub1.aClass277_Sub1_Undermap.method3339(-2, null, Class93.aGraphicsToolkit1241, null);
               Node_Sub38_Sub17.method2842(false);
            }

            Node_Sub38_Sub1.aClass277_Sub1_Map
               .method3339(
                  -2, bool_33_ ? Class270_Sub1.aClass277_Sub1_Undermap.tileHeights : null, Class93.aGraphicsToolkit1241, Class304.SCENE_CLIP_DATA_PLANES
               );
            if (Class61.anInt898 != 0) {
               Node_Sub24.method2650(true, -14651);
               CacheNode_Sub7.method2317(FileOnDisk.landFileData, (byte)-122, Node_Sub38_Sub1.aClass277_Sub1_Map);
            } else {
               Node_Sub24.method2650(true, -14651);
               Class178.spawnCachedObjects(31269, FileOnDisk.landFileData, Node_Sub38_Sub1.aClass277_Sub1_Map);
               if (Class194.npcFileData != null) {
                  Class201.loadCachedNPCs();
               }
            }

            Node_Sub36_Sub2.method2761((byte)125);
            if (Class201.anInt2446 < 96) {
               Class189.method1934((byte)17);
            }

            Node_Sub24.method2650(true, -14651);
            Node_Sub38_Sub1.aClass277_Sub1_Map.method3346((byte)75, Class93.aGraphicsToolkit1241, bool_33_ ? Class368.aPlaneArray4548[0] : null, null);
            Node_Sub38_Sub1.aClass277_Sub1_Map.method3356(false, Class93.aGraphicsToolkit1241, (byte)83);
            Node_Sub24.method2650(true, -14651);
            if (bool_33_) {
               Node_Sub38_Sub17.method2842(true);
               Node_Sub24.method2650(true, -14651);
               if (~Class61.anInt898 != -1) {
                  CacheNode_Sub7.method2317(Class320_Sub18.underLandFileData, (byte)-92, Class270_Sub1.aClass277_Sub1_Undermap);
               } else {
                  Class178.spawnCachedObjects(31269, Class320_Sub18.underLandFileData, Class270_Sub1.aClass277_Sub1_Undermap);
               }

               Node_Sub36_Sub2.method2761((byte)125);
               Node_Sub24.method2650(true, -14651);
               Class270_Sub1.aClass277_Sub1_Undermap.method3346((byte)75, Class93.aGraphicsToolkit1241, null, Node_Sub38_Sub37.aPlaneArray10466[0]);
               Class270_Sub1.aClass277_Sub1_Undermap.method3356(true, Class93.aGraphicsToolkit1241, (byte)83);
               Node_Sub24.method2650(true, -14651);
               Node_Sub38_Sub17.method2842(false);
            }

            Class115.method1159(-122);
            int i_37_ = Node_Sub38_Sub1.aClass277_Sub1_Map.anInt8046;
            if (i_37_ > CacheNode_Sub20_Sub1.myPlayerPlane) {
               i_37_ = CacheNode_Sub20_Sub1.myPlayerPlane;
            }

            if (!RSMapperClient.editor.mapEditor.dataLoaded) {
               RSMapperClient.editor.mapEditor.heights = Node_Sub38_Sub1.aClass277_Sub1_Map.tileHeights;
               RSMapperClient.editor.mapEditor.overlays = Node_Sub38_Sub1.aClass277_Sub1_Map.tileOverlays;
               RSMapperClient.editor.mapEditor.underlays = Node_Sub38_Sub1.aClass277_Sub1_Map.tileUnderlays;
               RSMapperClient.editor.mapEditor.shapes = Node_Sub38_Sub1.aClass277_Sub1_Map.tileShapes;
               RSMapperClient.editor.mapEditor.rotations = Node_Sub38_Sub1.aClass277_Sub1_Map.tileRotations;
               if (Class270_Sub1.aClass277_Sub1_Undermap != null) {
                  RSMapperClient.editor.mapEditor.um_heights = Class270_Sub1.aClass277_Sub1_Undermap.tileHeights;

                  for(int h = 0; h < RSMapperClient.editor.mapEditor.um_heights.length; ++h) {
                     for(int j = 0; j < RSMapperClient.editor.mapEditor.um_heights[h].length; ++j) {
                        for(int k = 0; k < RSMapperClient.editor.mapEditor.um_heights[h][j].length; ++k) {
                           RSMapperClient.editor.mapEditor.um_heights[h][j][k] -= RSMapperClient.editor.mapEditor.heights[h][j][k];
                        }
                     }
                  }

                  RSMapperClient.editor.mapEditor.um_overlays = Class270_Sub1.aClass277_Sub1_Undermap.tileOverlays;
                  RSMapperClient.editor.mapEditor.um_underlays = Class270_Sub1.aClass277_Sub1_Undermap.tileUnderlays;
                  RSMapperClient.editor.mapEditor.um_shapes = Class270_Sub1.aClass277_Sub1_Undermap.tileShapes;
                  RSMapperClient.editor.mapEditor.um_rotations = Class270_Sub1.aClass277_Sub1_Undermap.tileRotations;
               }
            }

            if (CacheNode_Sub20_Sub1.myPlayerPlane - 1 > i_37_) {
               i_37_ = -1 + CacheNode_Sub20_Sub1.myPlayerPlane;
            }

            if (Class213.aNode_Sub27_2512.aClass320_Sub19_7301.method3751(false) != 0) {
               CacheNode_Sub1.method2280(0);
            } else {
               CacheNode_Sub1.method2280(i_37_);
            }

            for(int i_38_ = 0; ~i_38_ > -5; ++i_38_) {
               for(int i_39_ = 0; i_39_ < Node_Sub54.GAME_SCENE_WDITH; ++i_39_) {
                  for(int i_40_ = 0; ~i_40_ > ~Class377_Sub1.GAME_SCENE_HEIGHT; ++i_40_) {
                     Node_Sub36.method2750(false, i_38_, i_40_, i_39_);
                  }
               }
            }

            Class46.method471(-1);
            CacheNode_Sub16_Sub1.method2387((byte)-114);
            Class109.method1127(false);
            Node_Sub36_Sub2.method2761((byte)125);
            Class239.method3022(false);
            if (Node_Sub29.aFrame7344 != null && Class218.aClass123_2566.aClass365_1557 != null && Class151.anInt1843 == 12) {
               ++Animable_Sub3.anInt9139;
               OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class169_Sub3.aClass318_8808, Class218.aClass123_2566.issacKeys);
               node_sub13.currentOutgoingPacket.writeInt(1057001181);
               Class218.aClass123_2566.sendPacket(126, node_sub13);
            }

            if (~Class61.anInt898 == -1) {
               int i_41_ = (-(Node_Sub54.GAME_SCENE_WDITH >> 4) + Player.regionX) / 8;
               int i_42_ = (Player.regionX - -(Node_Sub54.GAME_SCENE_WDITH >> 4)) / 8;
               int i_43_ = (-(Class377_Sub1.GAME_SCENE_HEIGHT >> 4) + Class277.regionY) / 8;
               int i_44_ = ((Class377_Sub1.GAME_SCENE_HEIGHT >> 4) + Class277.regionY) / 8;

               for(int i_45_ = i_41_ - 1; i_42_ + 1 >= i_45_; ++i_45_) {
                  for(int i_46_ = i_43_ - 1; ~(1 + i_44_) <= ~i_46_; ++i_46_) {
                     if (~i_45_ > ~i_41_ || i_45_ > i_42_ || ~i_46_ > ~i_43_ || ~i_44_ > ~i_46_) {
                        Animable_Sub1_Sub1.index5.method3531("m" + i_45_ + "_" + i_46_, -18758);
                        Animable_Sub1_Sub1.index5.method3531("l" + i_45_ + "_" + i_46_, -18758);
                     }
                  }
               }
            }

            if (~Class151.anInt1843 != -5) {
               if (~Class151.anInt1843 == -9) {
                  Class48.method478(7, (byte)108);
               } else if (~Class151.anInt1843 == -11) {
                  Class48.method478(9, (byte)113);
               } else {
                  Class48.method478(11, (byte)105);
                  if (Class218.aClass123_2566.aClass365_1557 != null) {
                     OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(TextureDefinitions.aClass318_1220, Class218.aClass123_2566.issacKeys);
                     Class218.aClass123_2566.sendPacket(127, node_sub13);
                  }
               }
            } else {
               Class48.method478(3, (byte)109);
            }

            if (Class270_Sub1.aClass277_Sub1_Undermap != null) {
               Class270_Sub1.aClass277_Sub1_Undermap.tileUnderlays = null;
               Class270_Sub1.aClass277_Sub1_Undermap.tileOverlays = null;
               Class270_Sub1.aClass277_Sub1_Undermap.tileShapes = null;
               Class270_Sub1.aClass277_Sub1_Undermap.tileRotations = null;
            }

            if (Node_Sub38_Sub1.aClass277_Sub1_Map != null) {
               Node_Sub38_Sub1.aClass277_Sub1_Map.tileUnderlays = null;
               Node_Sub38_Sub1.aClass277_Sub1_Map.tileOverlays = null;
               Node_Sub38_Sub1.aClass277_Sub1_Map.tileShapes = null;
               Node_Sub38_Sub1.aClass277_Sub1_Map.tileRotations = null;
            }

            Class365_Sub1.method4070(-122);
            CacheNode_Sub16_Sub1.method2387((byte)-114);
            Node_Sub38_Sub10.method2824(0);
            Class194_Sub1.aBoolean6892 = true;
            RSMapperClient.MAP_LOADED = true;
            RSMapperClient.editor.mapEditor.dataLoaded = true;
            if (DrawMiniMapSprites.aBoolean313) {
               Node_Sub7.writeToConsole((byte)43, "Took: " + (-Class366.aLong4528 + Class313.method3650(false)) + "ms");
               DrawMiniMapSprites.aBoolean313 = false;
            }
         }
      }
   }

   public static void method2377(byte b) {
      aClass192_11056 = null;
      aClass253Array11063 = null;
      if (b <= 55) {
         anInt11054 = 2;
      }
   }

   r_Sub2(GLToolkit gltoolkit, int i, int i_47_) {
      this.aByteArray11058 = new byte[i * i_47_];
   }
}