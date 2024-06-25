public class Class34_Sub1 extends Class34 {
   static int anInt5513;
   private HashTable aHashTable5514;
   static int anInt5515;
   static int anInt5516;
   static int anInt5517;
   static int anInt5518;
   private CacheNode_Sub16 aCacheNode_Sub16_5519;
   private MainFile aClass6_5520;
   static int anInt5521;
   private int anInt5522;
   static int anInt5523;
   private int anInt5524;
   private byte[] aByteArray5525;
   private byte[] aByteArray5526;
   static int anInt5527;
   static int[] SKILL_REAL_LEVEL = new int[25];
   static int anInt5529;
   private Class141 aClass141_5530;
   static int anInt5531;
   static int anInt5532;
   static int anInt5533;
   static int anInt5534;
   private Class266 aClass266_5535;
   private int anInt5536;
   private int anInt5537 = 0;
   static int anInt5538;
   private MainFile aClass6_5539;
   private ReferenceTable anArchive5540;
   private Class312 aClass312_5541;
   private int anInt5542;
   private boolean aBoolean5543;
   private Class312 aClass312_5544;
   private boolean aBoolean5545;
   private boolean aBoolean5546;
   private long aLong5547;

   static final void method375(int i, boolean bool, int i_0_, int i_1_, byte b, int i_2_) {
      ++anInt5523;
      if (~i_2_ > -2) {
         i_2_ = 1;
      }

      if (~i_1_ > -2) {
         i_1_ = 1;
      }

      if (b <= -80) {
         int i_3_ = i_1_ + -334;
         if (i_3_ < 0) {
            i_3_ = 0;
         } else if (~i_3_ < -101) {
            i_3_ = 100;
         }

         int i_4_ = (Node_Sub29_Sub3.aShort10026 + -Node_Sub29_Sub3.aShort10027) * i_3_ / 100 + Node_Sub29_Sub3.aShort10027;
         if (Class18.aShort310 <= i_4_) {
            if (OutgoingPacket.aShort4053 < i_4_) {
               i_4_ = OutgoingPacket.aShort4053;
            }
         } else {
            i_4_ = Class18.aShort310;
         }

         int i_5_ = i_1_ * i_4_ * 512 / (334 * i_2_);
         if (~i_5_ <= ~Class291.aShort3667) {
            if (Animable_Sub2_Sub2.aShort10750 < i_5_) {
               int var11 = Animable_Sub2_Sub2.aShort10750;
               i_4_ = 334 * var11 * i_2_ / (512 * i_1_);
               if (~Class18.aShort310 < ~i_4_) {
                  i_4_ = Class18.aShort310;
                  int i_6_ = 334 * i_2_ * var11 / (i_4_ * 512);
                  int i_7_ = (i_1_ + -i_6_) / 2;
                  if (bool) {
                     Class93.aGraphicsToolkit1241.la();
                     Class93.aGraphicsToolkit1241.method1239(i_2_, i_7_, i_0_, (byte)116, i, -16777216);
                     Class93.aGraphicsToolkit1241.method1239(i_2_, i_7_, i_0_ - -i_1_ + -i_7_, (byte)116, i, -16777216);
                  }

                  i_1_ -= 2 * i_7_;
                  i_0_ += i_7_;
               }
            }
         } else {
            int var12 = Class291.aShort3667;
            i_4_ = var12 * i_2_ * 334 / (512 * i_1_);
            if (OutgoingPacket.aShort4053 < i_4_) {
               i_4_ = OutgoingPacket.aShort4053;
               int i_8_ = i_4_ * i_1_ * 512 / (var12 * 334);
               int i_9_ = (-i_8_ + i_2_) / 2;
               if (bool) {
                  Class93.aGraphicsToolkit1241.la();
                  Class93.aGraphicsToolkit1241.method1239(i_9_, i_1_, i_0_, (byte)116, i, -16777216);
                  Class93.aGraphicsToolkit1241.method1239(i_9_, i_1_, i_0_, (byte)116, -i_9_ + i_2_ + i, -16777216);
               }

               i += i_9_;
               i_2_ -= 2 * i_9_;
            }
         }

         Class22.anInt428 = i;
         Class111.anInt1418 = (short)i_1_;
         Class339_Sub6.anInt8713 = i_4_ * i_1_ / 334;
         Mobile_Sub2.anInt10722 = i_0_;
         Class132.anInt1684 = (short)i_2_;
      }
   }

   final int method376(int i) {
      ++anInt5533;
      if (i != 100) {
         return 111;
      } else if (this.method374((byte)0) == null) {
         return this.aCacheNode_Sub16_5519 == null ? 0 : this.aCacheNode_Sub16_5519.method2386((byte)-40);
      } else {
         return 100;
      }
   }

   final int method377(int i) {
      ++anInt5515;
      return this.anArchive5540 == null ? 0 : this.anArchive5540.validArchivesCount;
   }

   static final void method378(int i) {
      Node_Sub38_Sub8.method2813(-1);
      ++anInt5521;
      if (i != -4) {
         method382(null, -11, 36);
      }

      int i_11_ = Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false);
      if (i_11_ != 2) {
         if (i_11_ == 3) {
            Class64.method711(
               Class93.aGraphicsToolkit1241, 2, Class360.canvasWidth, Class22.anInt432, Node_Sub36_Sub1.anInt10039, 2, (byte)-128, Class205.canvasHeight
            );
         }
      } else {
         CacheNode.method2279(-1, Class205.canvasHeight, 100, Class360.canvasWidth, 100, Class93.aGraphicsToolkit1241);
      }

      if (Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3689((byte)122)) {
         Index.method3535(Node_Sub38_Sub20.GAME_CANVAS, true);
      }

      if (Class93.aGraphicsToolkit1241 != null) {
         Class116.method1163(2);
      }

      Node_Sub15_Sub10.aBoolean9850 = Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3691(false) != 0;
      Class71.aBoolean967 = Class213.aNode_Sub27_2512.aClass320_Sub3_7298.method3689((byte)125);
   }

   @Override
   final void method368(int i, int i_12_) {
      ++anInt5527;
      if (this.aClass6_5539 != null) {
         if (i != 0) {
            this.method381((byte)122);
         }

         for(Node node = this.aClass312_5541.method3613(65280); node != null; node = this.aClass312_5541.method3620(16776960)) {
            if (~node.scriptId == ~((long)i_12_)) {
               return;
            }
         }

         Node node = new Node();
         node.scriptId = (long)i_12_;
         this.aClass312_5541.method3625((byte)-54, node);
      }
   }

   final int method379(int i) {
      ++anInt5538;
      if (i != 0) {
         this.anInt5542 = 2;
      }

      if (this.anArchive5540 == null) {
         return 0;
      } else if (!this.aBoolean5543) {
         return this.anArchive5540.validArchivesCount;
      } else {
         Node node = this.aClass312_5544.method3613(65280);
         return node == null ? 0 : (int)node.scriptId;
      }
   }

   final void method380(int i) {
      ++anInt5532;
      if (this.aClass312_5544 != null) {
         if (this.method374((byte)0) == null) {
            return;
         }

         if (!this.aBoolean5543) {
            if (!this.aBoolean5545) {
               this.aClass312_5544 = null;
            } else {
               boolean bool = true;

               for(Node node = this.aClass312_5544.method3613(65280); node != null; node = this.aClass312_5544.method3620(16776960)) {
                  int i_13_ = (int)node.scriptId;
                  if (this.aByteArray5525[i_13_] != 1) {
                     this.method383(i_13_, 2, -1);
                  }

                  if (this.aByteArray5525[i_13_] != 1) {
                     bool = false;
                  } else {
                     node.method2160((byte)108);
                  }
               }

               while(this.anArchive5540.anIntArray295.length > this.anInt5542) {
                  if (this.anArchive5540.anIntArray295[this.anInt5542] == 0) {
                     ++this.anInt5542;
                  } else {
                     if (this.aClass266_5535.method3239(255)) {
                        bool = false;
                        break;
                     }

                     if (~this.aByteArray5525[this.anInt5542] != -2) {
                        this.method383(this.anInt5542, 2, i + -1);
                     }

                     if (~this.aByteArray5525[this.anInt5542] != -2) {
                        Node node = new Node();
                        node.scriptId = (long)this.anInt5542;
                        this.aClass312_5544.method3625((byte)-54, node);
                        bool = false;
                     }

                     ++this.anInt5542;
                  }
               }

               if (bool) {
                  this.anInt5542 = 0;
                  this.aBoolean5545 = false;
               }
            }
         } else {
            boolean bool = true;

            for(Node node = this.aClass312_5544.method3613(65280); node != null; node = this.aClass312_5544.method3620(16776960)) {
               int i_14_ = (int)node.scriptId;
               if (this.aByteArray5525[i_14_] == 0) {
                  this.method383(i_14_, 1, -1);
               }

               if (~this.aByteArray5525[i_14_] == -1) {
                  bool = false;
               } else {
                  node.method2160((byte)122);
               }
            }

            while(this.anArchive5540.anIntArray295.length > this.anInt5542) {
               if (~this.anArchive5540.anIntArray295[this.anInt5542] == -1) {
                  ++this.anInt5542;
               } else {
                  if (this.aClass141_5530.anInt1753 >= 250) {
                     bool = false;
                     break;
                  }

                  if (~this.aByteArray5525[this.anInt5542] == -1) {
                     this.method383(this.anInt5542, 1, -1);
                  }

                  if (~this.aByteArray5525[this.anInt5542] == -1) {
                     Node node = new Node();
                     node.scriptId = (long)this.anInt5542;
                     bool = false;
                     this.aClass312_5544.method3625((byte)-54, node);
                  }

                  ++this.anInt5542;
               }
            }

            if (bool) {
               this.anInt5542 = 0;
               this.aBoolean5543 = false;
            }
         }
      }

      if (this.aBoolean5546 && ~Class313.method3650(false) <= ~this.aLong5547) {
         for(CacheNode_Sub16 cachenode_sub16 = (CacheNode_Sub16)this.aHashTable5514.method1516(false);
            cachenode_sub16 != null;
            cachenode_sub16 = (CacheNode_Sub16)this.aHashTable5514.method1520(99)
         ) {
            if (!cachenode_sub16.aBoolean9602) {
               if (cachenode_sub16.aBoolean9597) {
                  if (!cachenode_sub16.aBoolean9598) {
                     throw new RuntimeException();
                  }

                  cachenode_sub16.method2160((byte)121);
               } else {
                  cachenode_sub16.aBoolean9597 = true;
               }
            }
         }

         this.aLong5547 = 1000L + Class313.method3650(false);
      }

      if (i != 0) {
         this.method380(-72);
      }
   }

   final int method381(byte b) {
      if (b != 29) {
         SKILL_REAL_LEVEL = null;
      }

      ++anInt5534;
      return this.anInt5537;
   }

   static final void method382(Animable[] animables, int i, int i_15_) {
      if (i < i_15_) {
         int i_16_ = (i + i_15_) / 2;
         int i_17_ = i;
         Animable animable = animables[i_16_];
         animables[i_16_] = animables[i_15_];
         animables[i_15_] = animable;
         int i_18_ = animable.anInt5944;

         for(int i_19_ = i; i_19_ < i_15_; ++i_19_) {
            if (animables[i_19_].anInt5944 > i_18_ + (i_19_ & 1)) {
               Animable animable_20_ = animables[i_19_];
               animables[i_19_] = animables[i_17_];
               animables[i_17_++] = animable_20_;
            }
         }

         animables[i_15_] = animables[i_17_];
         animables[i_17_] = animable;
         method382(animables, i, i_17_ - 1);
         method382(animables, i_17_ + 1, i_15_);
      }
   }

   @Override
   final byte[] method373(int i, byte b) {
      ++anInt5513;
      CacheNode_Sub16 cachenode_sub16 = this.method383(i, 0, -1);
      if (cachenode_sub16 == null) {
         return null;
      } else {
         if (b < 46) {
            this.anInt5537 = 39;
         }

         byte[] bs = cachenode_sub16.method2385(15);
         cachenode_sub16.method2160((byte)100);
         return bs;
      }
   }

   private final CacheNode_Sub16 method383(int i, int i_21_, int i_22_) {
      ++anInt5516;
      if (i_22_ != -1) {
         return null;
      } else {
         CacheNode_Sub16 cachenode_sub16 = (CacheNode_Sub16)this.aHashTable5514.get(3512, (long)i);
         if (cachenode_sub16 != null && i_21_ == 0 && !cachenode_sub16.aBoolean9598 && cachenode_sub16.aBoolean9602) {
            cachenode_sub16.method2160((byte)57);
            cachenode_sub16 = null;
         }

         if (cachenode_sub16 == null) {
            if (~i_21_ == -1) {
               if (this.aClass6_5539 != null && this.aByteArray5525[i] != -1) {
                  cachenode_sub16 = this.aClass141_5530.method1612(this.aClass6_5539, i, true);
               } else {
                  if (this.aClass266_5535.method3244(24365)) {
                     return null;
                  }

                  cachenode_sub16 = this.aClass266_5535.method3247(this.anInt5524, i, (byte)-79, true, (byte)2);
               }
            } else if (~i_21_ == -2) {
               if (this.aClass6_5539 == null) {
                  throw new RuntimeException();
               }

               cachenode_sub16 = this.aClass141_5530.method1617(this.aClass6_5539, 13006, i);
            } else {
               if (~i_21_ != -3) {
                  throw new RuntimeException();
               }

               if (this.aClass6_5539 == null) {
                  throw new RuntimeException();
               }

               if (this.aByteArray5525[i] != -1) {
                  throw new RuntimeException();
               }

               if (this.aClass266_5535.method3239(i_22_ ^ -256)) {
                  return null;
               }

               cachenode_sub16 = this.aClass266_5535.method3247(this.anInt5524, i, (byte)-79, false, (byte)2);
            }

            this.aHashTable5514.put((long)i, cachenode_sub16, i_22_ + -125);
         }

         if (cachenode_sub16.aBoolean9602) {
            return null;
         } else {
            byte[] bs = cachenode_sub16.method2385(15);
            if (cachenode_sub16 instanceof CacheNode_Sub16_Sub2) {
               try {
                  if (bs != null && bs.length > 2) {
                     Class7.aCRC32_163.reset();
                     Class7.aCRC32_163.update(bs, 0, bs.length - 2);
                     int i_23_ = (int)Class7.aCRC32_163.getValue();
                     if (this.anArchive5540.aByteArrayArray298 != null && this.anArchive5540.aByteArrayArray298[i] != null) {
                        byte[] bs_24_ = this.anArchive5540.aByteArrayArray298[i];
                        byte[] bs_25_ = GLXToolkit.generateWhirpoolHash((byte)126, bs, -2 + bs.length, 0);
                        int i_26_ = 0;

                        while(~i_26_ > -65) {
                           ++i_26_;
                        }
                     }

                     int i_27_ = (bs[-1 + bs.length] & 255) + (0xFF00 & bs[bs.length + -2] << 8);
                     if (this.aByteArray5525[i] != 1) {
                        ++this.anInt5537;
                        this.aByteArray5525[i] = 1;
                     }

                     if (!cachenode_sub16.aBoolean9598) {
                        cachenode_sub16.method2160((byte)81);
                     }

                     return cachenode_sub16;
                  } else {
                     throw new RuntimeException();
                  }
               } catch (Exception var10) {
                  this.aByteArray5525[i] = -1;
                  cachenode_sub16.method2160((byte)67);
                  if (cachenode_sub16.aBoolean9598 && !this.aClass266_5535.method3244(24365)) {
                     CacheNode_Sub16_Sub1 cachenode_sub16_sub1 = this.aClass266_5535.method3247(this.anInt5524, i, (byte)-79, true, (byte)2);
                     this.aHashTable5514.put((long)i, cachenode_sub16_sub1, -123);
                  }

                  return null;
               }
            } else {
               try {
                  if (bs == null || ~bs.length >= -3) {
                     throw new RuntimeException();
                  }

                  Class7.aCRC32_163.reset();
                  Class7.aCRC32_163.update(bs, 0, -2 + bs.length);
                  int i_28_ = (int)Class7.aCRC32_163.getValue();
                  if (this.anArchive5540.aByteArrayArray298 != null && this.anArchive5540.aByteArrayArray298[i] != null) {
                     byte[] bs_29_ = this.anArchive5540.aByteArrayArray298[i];
                     byte[] bs_30_ = GLXToolkit.generateWhirpoolHash((byte)127, bs, -2 + bs.length, 0);
                     int i_31_ = 0;

                     while(~i_31_ > -65) {
                        ++i_31_;
                     }
                  }

                  this.aClass266_5535.anInt3394 = 0;
                  this.aClass266_5535.anInt3393 = 0;
               } catch (RuntimeException var11) {
                  this.aClass266_5535.method3233((byte)98);
                  cachenode_sub16.method2160((byte)118);
                  if (cachenode_sub16.aBoolean9598 && !this.aClass266_5535.method3244(24365)) {
                     CacheNode_Sub16_Sub1 cachenode_sub16_sub1 = this.aClass266_5535.method3247(this.anInt5524, i, (byte)-79, true, (byte)2);
                     this.aHashTable5514.put((long)i, cachenode_sub16_sub1, -124);
                  }
               }

               bs[bs.length + -2] = (byte)(this.anArchive5540.anIntArray293[i] >>> 8);
               bs[bs.length - 1] = (byte)this.anArchive5540.anIntArray293[i];
               if (this.aClass6_5539 != null) {
                  this.aClass141_5530.method1616((byte)-124, bs, i, this.aClass6_5539);
                  if (this.aByteArray5525[i] != 1) {
                     ++this.anInt5537;
                     this.aByteArray5525[i] = 1;
                  }
               }

               if (!cachenode_sub16.aBoolean9598) {
                  cachenode_sub16.method2160((byte)112);
               }

               return cachenode_sub16;
            }
         }
      }
   }

   public static void method384(int i) {
      SKILL_REAL_LEVEL = null;
      if (i != -21352) {
         SKILL_REAL_LEVEL = null;
      }
   }

   @Override
   final int method369(byte b, int i) {
      if (b != -4) {
         this.aByteArray5526 = null;
      }

      ++anInt5518;
      CacheNode_Sub16 cachenode_sub16 = (CacheNode_Sub16)this.aHashTable5514.get(3512, (long)i);
      return cachenode_sub16 != null ? cachenode_sub16.method2386((byte)-40) : 0;
   }

   final void method385(boolean bool) {
      ++anInt5517;
      if (this.aClass312_5544 != null && this.method374((byte)0) != null) {
         for(Node node = this.aClass312_5541.method3613(65280); node != null; node = this.aClass312_5541.method3620(16776960)) {
            int i = (int)node.scriptId;
            if (i >= 0 && i < this.anArchive5540.archivesLength && this.anArchive5540.anIntArray295[i] != 0) {
               if (this.aByteArray5525[i] == 0) {
                  this.method383(i, 1, -1);
               }

               if (~this.aByteArray5525[i] == 0) {
                  this.method383(i, 2, -1);
               }

               if (~this.aByteArray5525[i] == -2) {
                  node.method2160((byte)67);
               }
            } else {
               node.method2160((byte)98);
            }
         }

         if (bool) {
            method382(null, -92, -16);
         }
      }
   }

   @Override
   final ReferenceTable method374(byte b) {
      ++anInt5529;
      if (this.anArchive5540 != null) {
         return this.anArchive5540;
      } else if (b != 0) {
         return null;
      } else {
         if (this.aCacheNode_Sub16_5519 == null) {
            if (this.aClass266_5535.method3244(24365)) {
               return null;
            }

            this.aCacheNode_Sub16_5519 = this.aClass266_5535.method3247(255, this.anInt5524, (byte)-79, true, (byte)0);
         }

         if (this.aCacheNode_Sub16_5519.aBoolean9602) {
            return null;
         } else {
            byte[] bs = this.aCacheNode_Sub16_5519.method2385(15);
            if (this.aCacheNode_Sub16_5519 instanceof CacheNode_Sub16_Sub2) {
               try {
                  if (bs == null) {
                     throw new RuntimeException();
                  }

                  this.anArchive5540 = new ReferenceTable(bs, this.anInt5522, this.aByteArray5526);
                  if (~this.anInt5536 != ~this.anArchive5540.revision) {
                     throw new RuntimeException();
                  }
               } catch (RuntimeException var4) {
                  this.anArchive5540 = null;
                  if (!this.aClass266_5535.method3244(24365)) {
                     this.aCacheNode_Sub16_5519 = this.aClass266_5535.method3247(255, this.anInt5524, (byte)-79, true, (byte)0);
                  } else {
                     this.aCacheNode_Sub16_5519 = null;
                  }

                  return null;
               }
            } else {
               try {
                  if (bs == null) {
                     throw new RuntimeException();
                  }

                  this.anArchive5540 = new ReferenceTable(bs, this.anInt5522, this.aByteArray5526);
               } catch (RuntimeException var5) {
                  this.aClass266_5535.method3233((byte)98);
                  this.anArchive5540 = null;
                  if (!this.aClass266_5535.method3244(b ^ 24365)) {
                     this.aCacheNode_Sub16_5519 = this.aClass266_5535.method3247(255, this.anInt5524, (byte)-79, true, (byte)0);
                  } else {
                     this.aCacheNode_Sub16_5519 = null;
                  }

                  return null;
               }

               if (this.aClass6_5520 != null) {
                  this.aClass141_5530.method1616((byte)-124, bs, this.anInt5524, this.aClass6_5520);
               }
            }

            if (this.aClass6_5539 != null) {
               this.aByteArray5525 = new byte[this.anArchive5540.archivesLength];
               this.anInt5537 = 0;
            }

            this.aCacheNode_Sub16_5519 = null;
            return this.anArchive5540;
         }
      }
   }

   final void method386(byte b) {
      ++anInt5531;
      if (this.aClass6_5539 != null) {
         this.aBoolean5545 = true;
         if (b != 119) {
            this.aLong5547 = -99L;
         }

         if (this.aClass312_5544 == null) {
            this.aClass312_5544 = new Class312();
         }
      }
   }

   Class34_Sub1(int i, MainFile class6, MainFile class6_32_, Class266 class266, Class141 class141, int i_33_, byte[] bs, int i_34_, boolean bool) {
      this.aHashTable5514 = new HashTable(16);
      this.anInt5542 = 0;
      this.aClass312_5541 = new Class312();
      this.aLong5547 = 0L;
      this.anInt5524 = i;
      this.aClass6_5539 = class6;
      if (this.aClass6_5539 != null) {
         this.aBoolean5543 = true;
         this.aClass312_5544 = new Class312();
      } else {
         this.aBoolean5543 = false;
      }

      this.aBoolean5546 = bool;
      this.aClass266_5535 = class266;
      this.anInt5522 = i_33_;
      this.anInt5536 = i_34_;
      this.aClass141_5530 = class141;
      this.aByteArray5526 = bs;
      this.aClass6_5520 = class6_32_;
      if (this.aClass6_5520 != null) {
         this.aCacheNode_Sub16_5519 = this.aClass141_5530.method1612(this.aClass6_5520, this.anInt5524, true);
      }
   }
}
