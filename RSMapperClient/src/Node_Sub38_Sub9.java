public class Node_Sub38_Sub9 extends Node_Sub38 {
   private int anInt10174;
   private int anInt10175;
   private int anInt10176;
   static int anInt10177;
   static int anInt10178;
   static int anInt10179;
   private int anInt10180;
   static int anInt10181;
   private int anInt10182;
   private int anInt10183 = 0;
   static OutgoingPacket aClass318_10184 = new OutgoingPacket(68, -1);
   private int anInt10185;
   static short[] aShortArray10186 = new short[]{2, 22, 52, 30, 53, 9, 51, 15};
   static int anInt10187;
   private int anInt10188;
   static int anInt10189;
   private int anInt10190 = 0;
   static boolean aBoolean10191 = false;
   static int anInt10192 = 0;

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      if (i != 0) {
         if (~i != -2) {
            if (i == 2) {
               this.anInt10175 = (buffer.readByte() << 12) / 100;
            }
         } else {
            this.anInt10183 = (buffer.readByte() << 12) / 100;
         }
      } else {
         this.anInt10190 = buffer.readShort();
      }

      ++anInt10187;
      if (bool) {
         this.anInt10182 = -61;
      }
   }

   public Node_Sub38_Sub9() {
      super(1, false);
      this.anInt10175 = 0;
   }

   private final void method2819(int i, int i_1_, int i_2_, int i_3_) {
      ++anInt10179;
      if (i_1_ == 2) {
         int i_4_ = i_3_ > 2048 ? -(i_3_ * i_2_ >> 12) + i_3_ + i_2_ : (i_2_ + 4096) * i_3_ >> 12;
         if (i_4_ > 0) {
            i *= 6;
            int i_5_ = -i_4_ + i_3_ + i_3_;
            int i_6_ = (i_4_ - i_5_ << 12) / i_4_;
            int i_7_ = i >> 12;
            int i_8_ = -(i_7_ << 12) + i;
            int i_9_ = i_4_ * i_6_ >> 12;
            i_9_ = i_8_ * i_9_ >> 12;
            int i_10_ = i_5_ - -i_9_;
            int i_11_ = -i_9_ + i_4_;
            if (~i_7_ == -1) {
               this.anInt10182 = i_4_;
               this.anInt10180 = i_10_;
               this.anInt10188 = i_5_;
               return;
            }

            if (~i_7_ == -2) {
               this.anInt10182 = i_11_;
               this.anInt10188 = i_5_;
               this.anInt10180 = i_4_;
               return;
            }

            if (i_7_ == 2) {
               this.anInt10188 = i_10_;
               this.anInt10180 = i_4_;
               this.anInt10182 = i_5_;
               return;
            }

            if (~i_7_ == -4) {
               this.anInt10188 = i_4_;
               this.anInt10182 = i_5_;
               this.anInt10180 = i_11_;
               return;
            }

            if (i_7_ == 4) {
               this.anInt10182 = i_10_;
               this.anInt10188 = i_4_;
               this.anInt10180 = i_5_;
               return;
            }

            if (~i_7_ == -6) {
               this.anInt10182 = i_4_;
               this.anInt10188 = i_11_;
               this.anInt10180 = i_5_;
            }
         } else {
            this.anInt10182 = this.anInt10180 = this.anInt10188 = i_3_;
         }
      }
   }

   static final void method2820(boolean bool) {
      ++anInt10177;
      Class169.anIntArrayArray4954 = null;
      Class200_Sub2.anInt4935 = -1;
      if (!bool) {
         anInt10192 = -85;
      }

      Class61.anInt898 = 0;
      Node_Sub38_Sub7.anInt10153 = 0;
      aa.anInt101 = 0;
      Mobile.aBuffer9128 = null;
      ProducingGraphicsBuffer.method2601(-47);
      Class277.regionY = 0;
      Node_Sub53.gameSceneBaseX = 0;
      Class320_Sub4.gameSceneBaseY = 0;
      Player.regionX = 0;

      for(int i = 0; i < Class320_Sub24.cachedHintIcons.length; ++i) {
         Class320_Sub24.cachedHintIcons[i] = null;
      }

      Class9.method184(-113);

      for(int i = 0; i < 2048; ++i) {
         Class270_Sub2.LOCAL_PLAYERS[i] = null;
      }

      Node_Sub25_Sub3.localNPCsCount = 0;
      Class12.aHashTable187.method1517(false);
      Node_Sub32.cachedNPCcsCount = 0;
      Class266.aHashTable3380.method1517(false);
      Class368.method4080((byte)125);
      Class175.anInt2097 = 0;
      Class24.aClass275_442.method3329((byte)-114);
      Class51.playerGuestClan = null;
      Class66.playerOwnedClan = null;
      Class117.aNode_Sub7_1472 = null;
      Class29.aNode_Sub43_477 = null;
      ItemDefinitions.aNode_Sub43_1925 = null;
      Class359.aLong4466 = 0L;
   }

   public static void method2821(byte b) {
      if (b < 92) {
         aShortArray10186 = null;
      }

      aShortArray10186 = null;
      aClass318_10184 = null;
   }

   static final void method2822(Index class302, int i) {
      ++anInt10189;
      Packet.anInt9386 = i;
      WorldItem.anInt11012 = 0;
      Animable_Sub2.aClass103_9116 = new Class103();
      Class284.anEntityNode_Sub3_Sub2_Sub1Array3596 = new EntityNode_Sub3_Sub2_Sub1[1024];
      Class48.anEntityNode_Sub4Array694 = new EntityNode_Sub4[1 + Class107.anIntArray1359[Node_Sub39.anInt7498]];
      Node_Sub28.anInt7327 = 0;
      Class158.anInt1994 = 0;
      Class373.method4106(true, class302);
      Node_Sub36_Sub3.method2762(false, class302);
   }

   private final void method2823(int i, byte b, int i_13_, int i_14_) {
      ++anInt10178;
      int i_15_ = ~i_14_ > ~i ? i : i_14_;
      int i_16_ = i >= i_14_ ? i_14_ : i;
      i_15_ = i_13_ > i_15_ ? i_13_ : i_15_;
      i_16_ = ~i_13_ <= ~i_16_ ? i_16_ : i_13_;
      this.anInt10176 = (i_15_ + i_16_) / 2;
      int i_17_ = i_15_ + -i_16_;
      if (b == -2) {
         if (~i_17_ < -1) {
            int i_18_ = (i_15_ + -i << 12) / i_17_;
            int i_19_ = (-i_14_ + i_15_ << 12) / i_17_;
            int i_20_ = (-i_13_ + i_15_ << 12) / i_17_;
            if (i_15_ == i) {
               this.anInt10185 = ~i_14_ != ~i_16_ ? 4096 + -i_19_ : 20480 + i_20_;
            } else if (i_15_ == i_14_) {
               this.anInt10185 = i_16_ == i_13_ ? 4096 - -i_18_ : -i_20_ + 12288;
            } else {
               this.anInt10185 = ~i_16_ != ~i ? -i_18_ + 20480 : i_19_ + 12288;
            }

            this.anInt10185 /= 6;
         } else {
            this.anInt10185 = 0;
         }

         if (this.anInt10176 > 0 && ~this.anInt10176 > -4097) {
            this.anInt10174 = (i_17_ << 12) / (this.anInt10176 > 2048 ? 8192 - 2 * this.anInt10176 : 2 * this.anInt10176);
         } else {
            this.anInt10174 = 0;
         }
      }
   }

   @Override
   final int[][] method2778(int i, boolean bool) {
      ++anInt10181;
      if (!bool) {
         this.method2823(-66, (byte)-55, 10, 84);
      }

      int[][] is = this.aClass348_7454.method3981(i, 3168);
      if (this.aClass348_7454.aBoolean4300) {
         int[][] is_21_ = this.method2777(-80, 0, i);
         int[] is_22_ = is_21_[0];
         int[] is_23_ = is_21_[1];
         int[] is_24_ = is_21_[2];
         int[] is_25_ = is[0];
         int[] is_26_ = is[1];
         int[] is_27_ = is[2];

         for(int i_28_ = 0; ~i_28_ > ~Class339_Sub7.anInt8728; ++i_28_) {
            this.method2823(is_22_[i_28_], (byte)-2, is_24_[i_28_], is_23_[i_28_]);
            this.anInt10176 += this.anInt10175;
            this.anInt10174 += this.anInt10183;
            this.anInt10185 += this.anInt10190;

            while(this.anInt10185 < 0) {
               this.anInt10185 += 4096;
            }

            while(~this.anInt10185 < -4097) {
               this.anInt10185 -= 4096;
            }

            if (this.anInt10174 < 0) {
               this.anInt10174 = 0;
            }

            if (~this.anInt10176 > -1) {
               this.anInt10176 = 0;
            }

            if (this.anInt10174 > 4096) {
               this.anInt10174 = 4096;
            }

            if (~this.anInt10176 < -4097) {
               this.anInt10176 = 4096;
            }

            this.method2819(this.anInt10185, 2, this.anInt10174, this.anInt10176);
            is_25_[i_28_] = this.anInt10182;
            is_26_[i_28_] = this.anInt10180;
            is_27_[i_28_] = this.anInt10188;
         }
      }

      return is;
   }
}
