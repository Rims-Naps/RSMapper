public class Class355 {
   protected int anInt4349;
   protected boolean aBoolean4350;
   private int anInt4351;
   protected int[] anIntArray4352;
   protected int anInt4353;
   protected boolean aBoolean4354;
   protected boolean aBoolean4355;
   private int anInt4356;
   protected short aShort4357;
   protected int anInt4358;
   private int anInt4359;
   protected int anInt4360;
   protected int anInt4361 = -1;
   protected int[] anIntArray4362;
   static int anInt4363;
   protected int anInt4364;
   protected boolean aBoolean4365;
   static volatile boolean aBoolean4366 = true;
   protected int anInt4367;
   protected int anInt4368;
   protected short aShort4369;
   private int anInt4370;
   protected int[] anIntArray4371;
   static int anInt4372;
   protected boolean aBoolean4373;
   protected int anInt4374;
   protected boolean aBoolean4375;
   private int anInt4376;
   protected int anInt4377;
   static int anInt4378;
   protected int anInt4379;
   protected int anInt4380;
   protected int anInt4381;
   protected short aShort4382;
   protected int anInt4383;
   protected int anInt4384;
   private int anInt4385;
   protected short aShort4386;
   protected int anInt4387;
   protected int anInt4388;
   protected int anInt4389;
   protected boolean aBoolean4390;
   protected boolean aBoolean4391;
   static int anInt4392;
   protected int anInt4393;
   protected int anInt4394;
   private int anInt4395;
   static OutgoingPacket aClass318_4396 = new OutgoingPacket(40, 11);
   static int anInt4397;
   protected int anInt4398;
   protected int anInt4399;
   protected int anInt4400;
   protected int anInt4401;
   protected int anInt4402;
   protected int anInt4403;
   protected int anInt4404;
   protected int anInt4405;
   protected boolean aBoolean4406;
   protected int anInt4407;
   protected int anInt4408;
   protected int anInt4409;
   protected int anInt4410;
   protected int anInt4411;
   static int anInt4412;
   protected int anInt4413;
   protected int[] anIntArray4414;
   private int anInt4415;
   protected int anInt4416;
   static int anInt4417;
   private int anInt4418;
   protected int anInt4419;
   protected int anInt4420;
   static int anInt4421;
   protected int anInt4422;
   private int anInt4423;
   protected int anInt4424;

   static final int[] method4014(int i, OutgoingPacketBuffer node_sub13) {
      ++anInt4363;
      Buffer buffer = new Buffer(518);
      int[] is = new int[4];

      for(int i_0_ = 0; ~i_0_ > -5; ++i_0_) {
         is[i_0_] = (int)(9.9999999E7 * Math.random());
      }

      if (i != -5410) {
         method4017(38, false, null, true, null);
      }

      buffer.writeByte(10);
      buffer.writeInt(is[0]);
      buffer.writeInt(is[1]);
      buffer.writeInt(is[2]);
      buffer.writeInt(is[3]);

      for(int i_1_ = 0; ~i_1_ > -11; ++i_1_) {
         buffer.writeInt((int)(9.9999999E7 * Math.random()));
      }

      buffer.writeShort((int)(Math.random() * 9.9999999E7));
      buffer.encodeRSA();
      node_sub13.currentOutgoingPacket.writeBytes(buffer.offset, buffer.buffer, 0);
      return is;
   }

   private final void method4015(byte b, Buffer buffer, int i) {
      int i_2_ = 103 / ((b - -38) / 46);
      if (i == 1) {
         this.aShort4357 = (short)buffer.readUnsignedShort();
         this.aShort4369 = (short)buffer.readUnsignedShort();
         this.aShort4386 = (short)buffer.readUnsignedShort();
         this.aShort4382 = (short)buffer.readUnsignedShort();
         int i_3_ = 3;
         this.aShort4382 = (short)(this.aShort4382 << i_3_);
         this.aShort4386 = (short)(this.aShort4386 << i_3_);
         this.aShort4369 = (short)(this.aShort4369 << i_3_);
         this.aShort4357 = (short)(this.aShort4357 << i_3_);
      } else if (i == 2) {
         buffer.readUnsignedByte();
      } else if (i == 3) {
         this.anInt4377 = buffer.readInt();
         this.anInt4367 = buffer.readInt();
      } else if (~i == -5) {
         this.anInt4380 = buffer.readUnsignedByte();
         this.anInt4404 = buffer.readByte();
      } else if (i == 5) {
         this.anInt4360 = this.anInt4408 = buffer.readUnsignedShort() << 12 << 2;
      } else if (~i != -7) {
         if (i != 7) {
            if (i == 8) {
               this.anInt4424 = buffer.readUnsignedShort();
               this.anInt4381 = buffer.readUnsignedShort();
            } else if (~i == -10) {
               int i_4_ = buffer.readUnsignedByte();
               this.anIntArray4362 = new int[i_4_];

               for(int i_5_ = 0; ~i_4_ < ~i_5_; ++i_5_) {
                  this.anIntArray4362[i_5_] = buffer.readUnsignedShort();
               }
            } else if (~i == -11) {
               int i_6_ = buffer.readUnsignedByte();
               this.anIntArray4414 = new int[i_6_];

               for(int i_7_ = 0; i_7_ < i_6_; ++i_7_) {
                  this.anIntArray4414[i_7_] = buffer.readUnsignedShort();
               }
            } else if (~i != -13) {
               if (~i != -14) {
                  if (i != 14) {
                     if (i == 15) {
                        this.anInt4393 = buffer.readUnsignedShort();
                     } else if (~i == -17) {
                        this.aBoolean4375 = ~buffer.readUnsignedByte() == -2;
                        this.anInt4361 = buffer.readUnsignedShort();
                        this.anInt4411 = buffer.readUnsignedShort();
                        this.aBoolean4390 = ~buffer.readUnsignedByte() == -2;
                     } else if (~i == -18) {
                        this.anInt4353 = buffer.readUnsignedShort();
                     } else if (~i != -19) {
                        if (i != 19) {
                           if (~i != -21) {
                              if (~i != -22) {
                                 if (i == 22) {
                                    this.anInt4413 = buffer.readInt();
                                 } else if (~i != -24) {
                                    if (~i == -25) {
                                       this.aBoolean4391 = false;
                                    } else if (~i != -26) {
                                       if (~i == -27) {
                                          this.aBoolean4373 = false;
                                       } else if (i == 27) {
                                          this.anInt4419 = buffer.readUnsignedShort() << 12 << 2;
                                       } else if (~i == -29) {
                                          this.anInt4385 = buffer.readUnsignedByte();
                                       } else if (~i == -30) {
                                          buffer.readShort();
                                       } else if (i != 30) {
                                          if (~i != -32) {
                                             if (~i != -33) {
                                                if (i == 33) {
                                                   this.aBoolean4355 = true;
                                                } else if (~i == -35) {
                                                   this.aBoolean4354 = false;
                                                }
                                             } else {
                                                this.aBoolean4365 = false;
                                             }
                                          } else {
                                             this.anInt4360 = buffer.readUnsignedShort() << 12 << 2;
                                             this.anInt4408 = buffer.readUnsignedShort() << 12 << 2;
                                          }
                                       } else {
                                          this.aBoolean4350 = true;
                                       }
                                    } else {
                                       int i_8_ = buffer.readUnsignedByte();
                                       this.anIntArray4371 = new int[i_8_];

                                       for(int i_9_ = 0; i_9_ < i_8_; ++i_9_) {
                                          this.anIntArray4371[i_9_] = buffer.readUnsignedShort();
                                       }
                                    }
                                 } else {
                                    this.anInt4395 = buffer.readUnsignedByte();
                                 }
                              } else {
                                 this.anInt4376 = buffer.readUnsignedByte();
                              }
                           } else {
                              this.anInt4423 = buffer.readUnsignedByte();
                           }
                        } else {
                           this.anInt4379 = buffer.readUnsignedByte();
                        }
                     } else {
                        this.anInt4409 = buffer.readInt();
                     }
                  } else {
                     this.anInt4358 = buffer.readUnsignedShort();
                  }
               } else {
                  this.anInt4374 = buffer.readByte();
               }
            } else {
               this.anInt4407 = buffer.readByte();
            }
         } else {
            this.anInt4401 = buffer.readUnsignedShort();
            this.anInt4388 = buffer.readUnsignedShort();
         }
      } else {
         this.anInt4359 = buffer.readInt();
         this.anInt4356 = buffer.readInt();
      }

      ++anInt4412;
   }

   final void method4016(int i) {
      this.anInt4383 = this.anInt4359 >> 16 & 0xFF;
      ++anInt4372;
      if (this.anInt4407 > -2 || this.anInt4374 > -2) {
         this.aBoolean4406 = true;
      }

      this.anInt4415 = (this.anInt4356 & 16714917) >> 16;
      this.anInt4420 = this.anInt4415 - this.anInt4383;
      this.anInt4403 = (this.anInt4359 & 65376) >> 8;
      this.anInt4418 = (65320 & this.anInt4356) >> 8;
      if (i == 2) {
         this.anInt4351 = this.anInt4356 & 0xFF;
         this.anInt4400 = -this.anInt4403 + this.anInt4418;
         this.anInt4389 = this.anInt4359 & 0xFF;
         this.anInt4370 = this.anInt4356 >> 24 & 0xFF;
         this.anInt4394 = 0xFF & this.anInt4359 >> 24;
         this.anInt4402 = -this.anInt4389 + this.anInt4351;
         this.anInt4349 = this.anInt4370 + -this.anInt4394;
         if (this.anInt4419 != -1) {
            this.anInt4398 = this.anInt4385 * this.anInt4388 / 100;
            if (~this.anInt4398 == -1) {
               this.anInt4398 = 1;
            }

            this.anInt4399 = (this.anInt4419 + -((-this.anInt4360 + this.anInt4408) / 2) + -this.anInt4360) / this.anInt4398;
         }

         if (this.anInt4413 != -1) {
            this.anInt4384 = this.anInt4388 * this.anInt4395 / 100;
            if (~this.anInt4384 == -1) {
               this.anInt4384 = 1;
            }

            this.anInt4368 = (-((-this.anInt4377 + this.anInt4367) / 2) + -this.anInt4377 + this.anInt4413) / this.anInt4384;
         }

         if (this.anInt4409 != 0) {
            this.anInt4416 = this.anInt4376 * this.anInt4388 / 100;
            this.anInt4387 = this.anInt4388 * this.anInt4423 / 100;
            if (~this.anInt4387 == -1) {
               this.anInt4387 = 1;
            }

            if (~this.anInt4416 == -1) {
               this.anInt4416 = 1;
            }

            this.anInt4422 = (((this.anInt4409 & 16725212) >> 16) + -(this.anInt4420 / 2) + -this.anInt4383 << 8) / this.anInt4387;
            this.anInt4410 = (((this.anInt4409 & 0xFF00) >> 8) - this.anInt4403 - this.anInt4400 / 2 << 8) / this.anInt4387;
            this.anInt4405 = ((0xFF & this.anInt4409) - this.anInt4402 / 2 - this.anInt4389 << 8) / this.anInt4387;
            this.anInt4405 += ~this.anInt4405 >= -1 ? 4 : -4;
            this.anInt4364 = (-(this.anInt4349 / 2) + -this.anInt4394 + (this.anInt4409 >> 24 & 0xFF) << 8) / this.anInt4416;
            this.anInt4422 += ~this.anInt4422 >= -1 ? 4 : -4;
            this.anInt4410 += ~this.anInt4410 < -1 ? -4 : 4;
            this.anInt4364 += ~this.anInt4364 >= -1 ? 4 : -4;
         }
      }
   }

   static final void method4017(int i, boolean bool, String string, boolean bool_14_, SignLink signlink) {
      if (i >= -43) {
         aBoolean4366 = false;
      }

      if (string.contains("&mod=accountappeal&dest=passwordchoice.ws")) {
         string = "";
      }

      ++anInt4392;
      Class140.method1610(0, string, "openjs", signlink, bool, bool_14_);
   }

   final void method4018(byte b, Buffer buffer) {
      while(true) {
         int i = buffer.readUnsignedByte();
         if (~i == -1) {
            i = 117 % ((31 - b) / 42);
            ++anInt4417;
            return;
         }

         this.method4015((byte)33, buffer, i);
      }
   }

   static final void method4019(boolean bool) {
      if (!bool) {
         ++anInt4421;
         if (~SignLink.aString3989.toLowerCase().indexOf("microsoft") == 0) {
            Node_Sub38_Sub24.anIntArray10352[92] = 74;
            Node_Sub38_Sub24.anIntArray10352[47] = 73;
            Node_Sub38_Sub24.anIntArray10352[46] = 72;
            Node_Sub38_Sub24.anIntArray10352[44] = 71;
            Node_Sub38_Sub24.anIntArray10352[45] = 26;
            if (SignLink.aMethod4004 == null) {
               Node_Sub38_Sub24.anIntArray10352[192] = 58;
               Node_Sub38_Sub24.anIntArray10352[222] = 59;
            } else {
               Node_Sub38_Sub24.anIntArray10352[222] = 58;
               Node_Sub38_Sub24.anIntArray10352[192] = 28;
               Node_Sub38_Sub24.anIntArray10352[520] = 59;
            }

            Node_Sub38_Sub24.anIntArray10352[93] = 43;
            Node_Sub38_Sub24.anIntArray10352[91] = 42;
            Node_Sub38_Sub24.anIntArray10352[59] = 57;
            Node_Sub38_Sub24.anIntArray10352[61] = 27;
         } else {
            Node_Sub38_Sub24.anIntArray10352[191] = 73;
            Node_Sub38_Sub24.anIntArray10352[186] = 57;
            Node_Sub38_Sub24.anIntArray10352[219] = 42;
            Node_Sub38_Sub24.anIntArray10352[223] = 28;
            Node_Sub38_Sub24.anIntArray10352[192] = 58;
            Node_Sub38_Sub24.anIntArray10352[189] = 26;
            Node_Sub38_Sub24.anIntArray10352[222] = 59;
            Node_Sub38_Sub24.anIntArray10352[188] = 71;
            Node_Sub38_Sub24.anIntArray10352[187] = 27;
            Node_Sub38_Sub24.anIntArray10352[220] = 74;
            Node_Sub38_Sub24.anIntArray10352[221] = 43;
            Node_Sub38_Sub24.anIntArray10352[190] = 72;
         }
      }
   }

   static final int method4020(int i, String string) {
      ++anInt4397;
      if (string == null) {
         return -1;
      } else {
         for(int i_15_ = 0; ~Node_Sub38_Sub14.anInt10242 < ~i_15_; ++i_15_) {
            if (string.equalsIgnoreCase(Class262_Sub12.aStringArray7793[i_15_])) {
               return i_15_;
            }
         }

         int i_16_ = -70 % ((60 - i) / 51);
         return -1;
      }
   }

   static final void method4021(int i) {
      Class290_Sub7.aClass71_8134.method742(-79);
      ++anInt4378;
      r.aClass58_9578.method579(true);
      Class42.aClass181_643.method1824(64);
      Class186.aClass112_2256.method1140(-103);
      Class366.aClass279_4526.method3373((byte)-52);
      EntityNode_Sub3_Sub1.aClass86_9166.method1004((byte)78);
      Class18.aClass37_306.method397(53);
      Class16.aClass101_228.method1093(false);
      IOException_Sub1.aClass128_85.method1546(-10);
      Class188_Sub2_Sub1.aClass229_9354.method2122(true);
      Class336.aClass315_4173.method3660(6105);
      Class291_Sub1.aClass13_8198.method210(-111);
      InputStream_Sub2.aClass281_83.method3382(1);
      Node_Sub54.aClass338_7671.method3907((byte)-101);
      Class304.aClass215_3834.method2070(2048);
      Class146.aClass32_1812.method352((byte)-75);
      Class188_Sub2_Sub2.aClass36_9366.method389(11);
      Class171.aClass278_2062.method3363(-29945);
      CacheNode_Sub6.aClass57_9480.method570((byte)-96);
      Class32.aClass359_508.method4040((byte)-103);
      Class186.aClass239_2249.method3025((byte)105);
      Node_Sub9_Sub4.aClass180_9727.method1823(true);
      Class296.aClass186_5429.method1872(512);
      Class228.method2120(-124);
      if (i <= 48) {
         aBoolean4366 = true;
      }

      Class300.method3501(99999999);
      Class262_Sub19.method3201(-23303);
      Class82.method798(-1);
      Class64.method713(0);
      Class125.aClass61_1609.method602((byte)-122);
      Node_Sub51.aClass61_7628.method602((byte)-121);
      Class262_Sub18.aClass61_7842.method602((byte)-119);
      CacheNode_Sub12.aClass61_9556.method602((byte)-118);
      ClientScriptsExecutor.aClass61_3867.method602((byte)-127);
   }

   public static void method4022(boolean bool) {
      if (bool) {
         method4021(23);
      }

      aClass318_4396 = null;
   }

   public Class355() {
      this.anInt4353 = -1;
      this.anInt4358 = 0;
      this.anInt4376 = 100;
      this.anInt4379 = 0;
      this.aBoolean4354 = true;
      this.aBoolean4365 = true;
      this.anInt4393 = -1;
      this.anInt4380 = 0;
      this.aBoolean4390 = true;
      this.aBoolean4355 = false;
      this.anInt4374 = -2;
      this.aBoolean4391 = true;
      this.aBoolean4406 = false;
      this.anInt4385 = 100;
      this.anInt4407 = -2;
      this.anInt4395 = 100;
      this.aBoolean4375 = true;
      this.anInt4413 = -1;
      this.aBoolean4350 = false;
      this.anInt4411 = -1;
      this.anInt4419 = -1;
      this.aBoolean4373 = true;
      this.anInt4423 = 100;
   }
}
