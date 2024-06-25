import jaclib.memory.Stream;
import jaclib.memory.heap.NativeHeapBuffer;
import java.io.IOException;

public class Node_Sub24 extends Node {
   private float[][] aFloatArrayArray7206;
   static int anInt7207;
   private Interface15_Impl1 anInterface15_Impl1_7208;
   private HashTable aHashTable7209;
   private int anInt7210;
   private Stream aStream7211;
   private int anInt7212;
   private int anInt7213;
   static IncommingPacket aClass192_7214 = new IncommingPacket(27, 0);
   private int anInt7215;
   static int anInt7216;
   private StandardPlane aStandardPlane7217;
   private Interface15_Impl2 anInterface15_Impl2_7218;
   private int anInt7219;
   private float[][] aFloatArrayArray7220;
   private int anInt7221;
   static int anInt7222;
   static int anInt7223;
   static int anInt7224;
   static int anInt7225;
   static int anInt7226;
   private float[][] aFloatArrayArray7227;
   static int anInt7228;
   static int anInt7229;
   private AbstractToolkit anAbstractToolkit7230;
   private Node_Sub29 aNode_Sub29_7231;
   private Stream aStream7232;

   static final void method2642(byte b) {
      ++anInt7225;
      synchronized(Node_Sub36_Sub4.aClass61_10065) {
         if (b < 33) {
            return;
         }

         Node_Sub36_Sub4.aClass61_10065.method608(false);
      }

      synchronized(CacheNode_Sub3.aClass61_9446) {
         CacheNode_Sub3.aClass61_9446.method608(false);
      }
   }

   private final void method2643(byte b, short s) {
      if (!Stream.b()) {
         this.aStream7211.c(s);
      } else {
         this.aStream7211.b(s);
      }

      ++anInt7226;
      if (b != 19) {
         method2642((byte)-26);
      }
   }

   static final void method2644(byte b) {
      ++anInt7224;
      if (Node_Sub38_Sub1.aClass329_10086 != CacheNode_Sub2.aClass329_9436) {
         try {
            Class2.method167("tbrefresh", Class158.aClient1983, (byte)-85);
            if (b != -42) {
               method2647((byte)-4, -0.23702288F, -0.5243241F, 2.32522F, 0.43047276F, 76, null, -8, 103, -0.710538F, 110, null, 59);
            }
         } catch (Throwable var2) {
         }
      }
   }

   private final void method2645(int i, int i_0_, int i_1_, int i_2_, int i_3_, int i_4_, int i_5_) {
      ++anInt7207;
      long l = -1L;
      int i_6_ = (i_3_ << this.aStandardPlane7217.anInt3410) + i_4_;
      int i_7_ = (i_1_ << this.aStandardPlane7217.anInt3410) + i_2_;
      int i_8_ = this.aStandardPlane7217.getMedianHeightFromVertices(i_7_, -115, i_6_);
      if ((127 & i_4_) == 0 || ~(i_2_ & 127) == -1) {
         l = (long)i_6_ & 65535L | 4294901760L & (long)i_7_ << 16;
         Node node = this.aHashTable7209.get(3512, l);
         if (node != null) {
            this.method2643((byte)19, ((Node_Sub46)node).aShort7554);
            return;
         }
      }

      short s = (short)(this.anInt7221++);
      if (l != -1L) {
         this.aHashTable7209.put(l, new Node_Sub46(s), -125);
      }

      float f;
      float f_9_;
      float f_10_;
      if (i_4_ == 0 && i_2_ == 0) {
         f_10_ = this.aFloatArrayArray7220[i_0_][i_5_];
         f_9_ = this.aFloatArrayArray7206[i_0_][i_5_];
         f = this.aFloatArrayArray7227[i_0_][i_5_];
      } else if (~this.aStandardPlane7217.anInt3398 == ~i_4_ && ~i_2_ == -1) {
         f = this.aFloatArrayArray7227[i_0_ - -1][i_5_];
         f_9_ = this.aFloatArrayArray7206[i_0_ - -1][i_5_];
         f_10_ = this.aFloatArrayArray7220[i_0_ + 1][i_5_];
      } else if (this.aStandardPlane7217.anInt3398 == i_4_ && ~i_2_ == ~this.aStandardPlane7217.anInt3398) {
         f = this.aFloatArrayArray7227[1 + i_0_][1 + i_5_];
         f_10_ = this.aFloatArrayArray7220[1 + i_0_][i_5_ + 1];
         f_9_ = this.aFloatArrayArray7206[1 + i_0_][1 + i_5_];
      } else if (i_4_ == 0 && ~i_2_ == ~this.aStandardPlane7217.anInt3398) {
         f_9_ = this.aFloatArrayArray7206[i_0_][i_5_ - -1];
         f = this.aFloatArrayArray7227[i_0_][i_5_ + 1];
         f_10_ = this.aFloatArrayArray7220[i_0_][1 + i_5_];
      } else {
         float f_11_ = (float)i_4_ / (float)this.aStandardPlane7217.anInt3398;
         float f_12_ = (float)i_2_ / (float)this.aStandardPlane7217.anInt3398;
         float f_13_ = this.aFloatArrayArray7227[i_0_][i_5_];
         float f_14_ = this.aFloatArrayArray7220[i_0_][i_5_];
         float f_15_ = this.aFloatArrayArray7206[i_0_][i_5_];
         float f_16_ = this.aFloatArrayArray7227[i_0_ + 1][i_5_];
         float f_17_ = this.aFloatArrayArray7220[1 + i_0_][i_5_];
         f_17_ += (-f_17_ + this.aFloatArrayArray7220[1 + i_0_][i_5_ + 1]) * f_11_;
         f_16_ += (-f_16_ + this.aFloatArrayArray7227[i_0_ + 1][1 + i_5_]) * f_11_;
         f_15_ += f_11_ * (-f_15_ + this.aFloatArrayArray7206[i_0_][i_5_ - -1]);
         float f_18_ = this.aFloatArrayArray7206[i_0_ + 1][i_5_];
         f_13_ += (this.aFloatArrayArray7227[i_0_][i_5_ - -1] - f_13_) * f_11_;
         f_14_ += (-f_14_ + this.aFloatArrayArray7220[i_0_][1 + i_5_]) * f_11_;
         f_18_ += f_11_ * (this.aFloatArrayArray7206[i_0_ + 1][i_5_ + 1] - f_18_);
         f_10_ = (-f_14_ + f_17_) * f_12_ + f_14_;
         f = (-f_13_ + f_16_) * f_12_ + f_13_;
         f_9_ = (-f_15_ + f_18_) * f_12_ + f_15_;
      }

      float f_19_ = (float)(this.aNode_Sub29_7231.getReferenceX(32311) + -i_6_);
      float f_20_ = (float)(this.aNode_Sub29_7231.getHeight(i + -14165) - i_8_);
      float f_21_ = (float)(-i_7_ + this.aNode_Sub29_7231.getReferenceY(27433));
      float f_22_ = (float)Math.sqrt((double)(f_20_ * f_20_ + f_19_ * f_19_ + f_21_ * f_21_));
      float f_23_ = 1.0F / f_22_;
      f_19_ *= f_23_;
      f_20_ *= f_23_;
      f_21_ *= f_23_;
      float f_24_ = f_22_ / (float)this.aNode_Sub29_7231.getFlickerType(117);
      float f_25_ = -(f_24_ * f_24_) + 1.0F;
      if (f_25_ < 0.0F) {
         f_25_ = 0.0F;
      }

      float f_26_ = f_20_ * f_10_ + f_19_ * f + f_9_ * f_21_;
      if (i != 14195) {
         method2648((byte)-60);
      }

      if (f_26_ < 0.0F) {
         f_26_ = 0.0F;
      }

      float f_27_ = f_26_ * f_25_ * 2.0F;
      if (f_27_ > 1.0F) {
         f_27_ = 1.0F;
      }

      int i_28_ = this.aNode_Sub29_7231.getColor((byte)66);
      int i_29_ = (int)((float)(i_28_ >> 16 & 0xFF) * f_27_);
      if (i_29_ > 255) {
         i_29_ = 255;
      }

      int i_30_ = (int)((float)(i_28_ >> 8 & 0xFF) * f_27_);
      if (~i_30_ < -256) {
         i_30_ = 255;
      }

      int i_31_ = (int)((float)(i_28_ & 0xFF) * f_27_);
      if (Stream.b()) {
         this.aStream7232.a((float)i_6_);
         this.aStream7232.a((float)i_8_);
         this.aStream7232.a((float)i_7_);
      } else {
         this.aStream7232.b((float)i_6_);
         this.aStream7232.b((float)i_8_);
         this.aStream7232.b((float)i_7_);
      }

      if (~i_31_ < -256) {
         i_31_ = 255;
      }

      if (~this.anAbstractToolkit7230.anInt6360 == -1) {
         this.aStream7232.d(i_31_);
         this.aStream7232.d(i_30_);
         this.aStream7232.d(i_29_);
      } else {
         this.aStream7232.d(i_29_);
         this.aStream7232.d(i_30_);
         this.aStream7232.d(i_31_);
      }

      this.aStream7232.d(255);
      this.method2643((byte)19, s);
   }

   final void method2646(int i, int i_32_, byte b, int i_33_, boolean[][] bools) {
      ++anInt7223;
      if (this.anInterface15_Impl1_7208 != null
         && ~(i_33_ + i) <= ~this.anInt7210
         && ~(-i_33_ + i) >= ~this.anInt7215
         && i_32_ - -i_33_ >= this.anInt7213
         && i_32_ + -i_33_ <= this.anInt7219) {
         for(int i_34_ = this.anInt7213; this.anInt7219 >= i_34_; ++i_34_) {
            for(int i_35_ = this.anInt7210; i_35_ <= this.anInt7215; ++i_35_) {
               int i_36_ = i_35_ + -i;
               int i_37_ = -i_32_ + i_34_;
               if (-i_33_ < i_36_ && ~i_36_ > ~i_33_ && ~(-i_33_) > ~i_37_ && ~i_37_ > ~i_33_ && bools[i_33_ + i_36_][i_37_ - -i_33_]) {
                  this.anAbstractToolkit7230.method1274((byte)((int)(255.0F * this.aNode_Sub29_7231.method2707(1))), false);
                  this.anAbstractToolkit7230.method1354(0, 32011, this.anInterface15_Impl2_7218);
                  this.anAbstractToolkit7230.method1338(this.anAbstractToolkit7230.aClass213_6383, 9422);
                  this.anAbstractToolkit7230
                     .method1276(0, (byte)-113, 0, this.anInterface15_Impl1_7208, this.anInt7221, Class55.aClass104_833, this.anInt7212 / 3);
                  return;
               }
            }
         }

         if (b <= 43) {
            this.method2646(119, 109, (byte)93, 25, null);
         }
      }
   }

   static final void method2647(
      byte b, float f, float f_38_, float f_39_, float f_40_, int i, byte[] bs, int i_41_, int i_42_, float f_43_, int i_44_, Class328 class328, int i_45_
   ) {
      ++anInt7216;

      for(int i_46_ = 0; i > i_46_; ++i_46_) {
         Class195.method1988(i_41_, f, f_40_, i_46_, class328, bs, f_43_, i, (byte)-125, f_38_, i_44_, i_45_, i_42_, f_39_);
         i_42_ += i_41_ * i_44_;
      }

      int i_47_ = 47 / ((83 - b) / 34);
   }

   public static void method2648(byte b) {
      aClass192_7214 = null;
      if (b != 47) {
         aClass192_7214 = null;
      }
   }

   static final void method2649(boolean bool) {
      ++anInt7222;
      if (Class270_Sub1.aFileOutputStream8027 != null) {
         try {
            Class270_Sub1.aFileOutputStream8027.close();
         } catch (IOException var2) {
         }
      }

      if (!bool) {
         method2649(false);
      }

      Class270_Sub1.aFileOutputStream8027 = null;
   }

   static final void method2650(boolean bool, int i) {
      ++anInt7228;
      CacheNode_Sub16_Sub1.method2387((byte)-114);
      if (Class58.method577(Class151.anInt1843, -22906)) {
         Class123[] class123s = Class218.aClass123Array2567;

         for(int i_48_ = 0; ~class123s.length < ~i_48_; ++i_48_) {
            Class123 class123 = class123s[i_48_];
            ++class123.anInt1579;
            if (~class123.anInt1579 > -51 && !bool) {
               return;
            }

            class123.anInt1579 = 0;
            if (!class123.aBoolean1580 && class123.aClass365_1557 != null) {
               ++Class365.anInt4524;
               OutgoingPacketBuffer node_sub13 = PacketParser.createOutgoingPacket(Class224.OUTCOMMING_PACKET_16, class123.issacKeys);
               class123.sendPacket(126, node_sub13);

               try {
                  class123.method1512((byte)-89);
               } catch (IOException var7) {
                  class123.aBoolean1580 = true;
               }
            }
         }

         if (i != -14651) {
            aClass192_7214 = null;
         }

         CacheNode_Sub16_Sub1.method2387((byte)-114);
      }
   }

   Node_Sub24(AbstractToolkit abstracttoolkit, StandardPlane standardplane, Node_Sub29 node_sub29, int[] is) {
      try {
         this.anAbstractToolkit7230 = abstracttoolkit;
         this.aStandardPlane7217 = standardplane;
         this.aNode_Sub29_7231 = node_sub29;
         int i = this.aNode_Sub29_7231.getFlickerType(120) + -(standardplane.anInt3398 >> 1);
         this.anInt7210 = -i + this.aNode_Sub29_7231.getReferenceX(32311) >> standardplane.anInt3410;
         this.anInt7215 = i + this.aNode_Sub29_7231.getReferenceX(32311) >> standardplane.anInt3410;
         this.anInt7213 = -i + this.aNode_Sub29_7231.getReferenceY(27433) >> standardplane.anInt3410;
         this.anInt7219 = i + this.aNode_Sub29_7231.getReferenceY(27433) >> standardplane.anInt3410;
         int i_49_ = 1 + -this.anInt7210 + this.anInt7215;
         int i_50_ = this.anInt7219 + -this.anInt7213 - -1;
         this.aFloatArrayArray7220 = new float[1 + i_49_][1 + i_50_];
         this.aFloatArrayArray7227 = new float[1 + i_49_][1 + i_50_];
         this.aFloatArrayArray7206 = new float[i_49_ + 1][i_50_ + 1];

         for(int i_51_ = 0; i_51_ <= i_50_; ++i_51_) {
            int i_52_ = i_51_ + this.anInt7213;
            if (~i_52_ < -1 && i_52_ < this.aStandardPlane7217.anInt3404 + -1) {
               for(int i_53_ = 0; i_49_ >= i_53_; ++i_53_) {
                  int i_54_ = this.anInt7210 + i_53_;
                  if (i_54_ > 0 && ~i_54_ > ~(this.aStandardPlane7217.anInt3408 - 1)) {
                     int i_55_ = standardplane.getVerticeHeight(i_52_, 1 + i_54_, (byte)-118) + -standardplane.getVerticeHeight(i_52_, i_54_ - 1, (byte)-118);
                     int i_56_ = standardplane.getVerticeHeight(1 + i_52_, i_54_, (byte)-118) + -standardplane.getVerticeHeight(-1 + i_52_, i_54_, (byte)-118);
                     float f = (float)(1.0 / Math.sqrt((double)(i_56_ * i_56_ + i_55_ * i_55_ + 65536)));
                     this.aFloatArrayArray7227[i_53_][i_51_] = (float)i_55_ * f;
                     this.aFloatArrayArray7220[i_53_][i_51_] = f * -256.0F;
                     this.aFloatArrayArray7206[i_53_][i_51_] = f * (float)i_56_;
                  }
               }
            }
         }

         int i_57_ = 0;

         for(int i_58_ = this.anInt7213; this.anInt7219 >= i_58_; ++i_58_) {
            if (~i_58_ <= -1 && ~i_58_ > ~standardplane.anInt3404) {
               for(int i_59_ = this.anInt7210; i_59_ <= this.anInt7215; ++i_59_) {
                  if (~i_59_ <= -1 && ~standardplane.anInt3408 < ~i_59_) {
                     int i_60_ = is[i_57_];
                     int[] is_61_ = standardplane.anIntArrayArrayArray8006[i_59_][i_58_];
                     if (is_61_ != null && i_60_ != 0) {
                        if (i_60_ == 1) {
                           int i_62_ = 0;

                           while(is_61_.length > i_62_) {
                              if (is_61_[i_62_++] != -1 && ~is_61_[i_62_++] != 0 && ~is_61_[i_62_++] != 0) {
                                 this.anInt7212 += 3;
                              }
                           }
                        } else {
                           this.anInt7212 += 3;
                        }
                     }
                  }

                  ++i_57_;
               }
            } else {
               i_57_ += this.anInt7215 - this.anInt7210;
            }
         }

         if (~this.anInt7212 >= -1) {
            this.anInterface15_Impl2_7218 = null;
            this.anInterface15_Impl1_7208 = null;
         } else {
            this.aHashTable7209 = new HashTable(Class320_Sub19.method3753(this.anInt7212));
            this.anInterface15_Impl1_7208 = this.anAbstractToolkit7230.method1346(false, (byte)102);
            this.anInterface15_Impl1_7208.method56(-1696, this.anInt7212);
            NativeHeapBuffer nativeheapbuffer = this.anAbstractToolkit7230.method1330(false, 84, this.anInt7212 * 16);
            this.aStream7232 = new Stream(nativeheapbuffer);

            while(true) {
               jaclib.memory.Buffer buffer = this.anInterface15_Impl1_7208.method54(true, (byte)119);
               if (buffer != null) {
                  this.aStream7211 = new Stream(buffer);
                  int i_63_ = 0;
                  i_57_ = 0;

                  for(int i_64_ = this.anInt7213; ~this.anInt7219 <= ~i_64_; ++i_64_) {
                     if (i_64_ >= 0 && ~i_64_ > ~standardplane.anInt3404) {
                        int i_65_ = 0;

                        for(int i_66_ = this.anInt7210; i_66_ <= this.anInt7215; ++i_66_) {
                           if (~i_66_ <= -1 && ~standardplane.anInt3408 < ~i_66_) {
                              int i_67_ = is[i_57_];
                              int[] is_68_ = standardplane.anIntArrayArrayArray8006[i_66_][i_64_];
                              if (is_68_ != null && i_67_ != 0) {
                                 if (~i_67_ != -2) {
                                    if (i_67_ == 3) {
                                       this.method2645(14195, i_65_, i_64_, 0, i_66_, 0, i_63_);
                                       this.method2645(14195, i_65_, i_64_, 0, i_66_, standardplane.anInt3398, i_63_);
                                       this.method2645(14195, i_65_, i_64_, standardplane.anInt3398, i_66_, 0, i_63_);
                                    } else if (~i_67_ == -3) {
                                       this.method2645(14195, i_65_, i_64_, 0, i_66_, standardplane.anInt3398, i_63_);
                                       this.method2645(14195, i_65_, i_64_, standardplane.anInt3398, i_66_, standardplane.anInt3398, i_63_);
                                       this.method2645(14195, i_65_, i_64_, 0, i_66_, 0, i_63_);
                                    } else if (~i_67_ == -6) {
                                       this.method2645(14195, i_65_, i_64_, standardplane.anInt3398, i_66_, standardplane.anInt3398, i_63_);
                                       this.method2645(14195, i_65_, i_64_, standardplane.anInt3398, i_66_, 0, i_63_);
                                       this.method2645(14195, i_65_, i_64_, 0, i_66_, standardplane.anInt3398, i_63_);
                                    } else if (~i_67_ == -5) {
                                       this.method2645(14195, i_65_, i_64_, standardplane.anInt3398, i_66_, 0, i_63_);
                                       this.method2645(14195, i_65_, i_64_, 0, i_66_, 0, i_63_);
                                       this.method2645(14195, i_65_, i_64_, standardplane.anInt3398, i_66_, standardplane.anInt3398, i_63_);
                                    }
                                 } else {
                                    int[] is_69_ = standardplane.anIntArrayArrayArray7986[i_66_][i_64_];
                                    int[] is_70_ = standardplane.anIntArrayArrayArray7997[i_66_][i_64_];
                                    int i_71_ = 0;

                                    while(is_68_.length > i_71_) {
                                       if (is_68_[i_71_] != -1 && is_68_[1 + i_71_] != -1 && is_68_[i_71_ - -2] != -1) {
                                          this.method2645(14195, i_65_, i_64_, is_70_[i_71_], i_66_, is_69_[i_71_], i_63_);
                                          this.method2645(14195, i_65_, i_64_, is_70_[++i_71_], i_66_, is_69_[i_71_], i_63_);
                                          this.method2645(14195, i_65_, i_64_, is_70_[++i_71_], i_66_, is_69_[i_71_], i_63_);
                                          ++i_71_;
                                       } else {
                                          i_71_ += 3;
                                       }
                                    }
                                 }
                              }
                           }

                           ++i_57_;
                           ++i_65_;
                        }
                     } else {
                        i_57_ += -this.anInt7210 + this.anInt7215;
                     }

                     ++i_63_;
                  }

                  this.aStream7211.c();
                  if (this.anInterface15_Impl1_7208.method53(-3308)) {
                     this.aStream7232.c();
                     this.anInterface15_Impl2_7218 = this.anAbstractToolkit7230.method1380(2, false);
                     this.anInterface15_Impl2_7218.method36(16, 16 * this.anInt7221, nativeheapbuffer, 1965);
                     break;
                  }

                  this.aStream7232.f(0);
                  this.aHashTable7209.method1517(false);
               }
            }
         }

         this.aHashTable7209 = null;
         this.aFloatArrayArray7227 = this.aFloatArrayArray7220 = this.aFloatArrayArray7206 = null;
         this.aStream7211 = null;
         this.aStream7232 = null;
      } catch (RuntimeException var20) {
         throw Class126.method1537(
            var20,
            "jw.<init>("
               + (abstracttoolkit != null ? "{...}" : "null")
               + ','
               + (standardplane != null ? "{...}" : "null")
               + ','
               + (node_sub29 != null ? "{...}" : "null")
               + ','
               + (is != null ? "{...}" : "null")
               + ')'
         );
      }
   }
}
