public class Class66_Sub2_Sub1 extends Class66_Sub2 {
   static int anInt10577;
   static Interface21[] anInterface21Array10578 = new Interface21[75];
   static int anInt10579;
   static int anInt10580;
   static OutgoingPacket NPC_EXAMINE_PACKET = new OutgoingPacket(92, 3);
   static int anInt10582 = 0;
   static long[] aLongArray10583 = new long[11];
   static long[][] aLongArrayArray10584 = new long[8][256];

   static {
      for(int i = 0; ~i > -257; ++i) {
         int i_11_ = "\u1823\uC6E8\u87B8\u014F\u36A6\uD2F5\u796F\u9152\u60BC\u9B8E\uA30C\u7B35\u1DE0\uD7C2\u2E4B\uFE57\u1577\u37E5\u9FF0\u4ADA\u58C9\u290A\uB1A0\u6B85\uBD5D\u10F4\uCB3E\u0567\ue427\u418B\uA77D\u95D8\uFBEE\u7C66\udd17\u479E\uCA2D\uBF07\uAD5A\u8333\u6302\uAA71\uC819\u49D9\uf2e3\u5B88\u9A26\u32B0\ue90f\uD580\uBECD\u3448\uFF7A\u905F\u2068\u1aae\uB454\u9322\u64F1\u7312\u4008\uC3EC\udba1\u8D3D\u9700\uCF2B\u7682\uD61B\uB5AF\u6A50\u45F3\u30EF\u3F55\uA2EA\u65BA\u2FC0\ude1c\uFD4D\u9275\u068A\uB2E6\u0E1F\u62D4\uA896\uF9C5\u2559\u8472\u394C\u5E78\u388C\uD1A5\ue261\uB321\u9C1E\u43C7\uFC04\u5199\u6D0D\ufadf\u7E24\u3BAB\uCE11\u8F4E\uB7EB\u3C81\u94F7\uB913\u2CD3\ue76e\uC403\u5644\u7FA9\u2ABB\uC153\udc0b\u9D6C\u3174\uf646\uAC89\u14E1\u163A\u6909\u70B6\uD0ED\uCC42\u98A4\u285C\uf886"
            .charAt(i / 2);
         long l = (long)(~(1 & i) != -1 ? 0xFF & i_11_ : i_11_ >>> 8);
         long l_12_ = l << 1;
         if (l_12_ >= 256L) {
            l_12_ ^= 285L;
         }

         long l_13_ = l_12_ << 1;
         if (~l_13_ <= -257L) {
            l_13_ ^= 285L;
         }

         long l_14_ = l_13_ ^ l;
         long l_15_ = l_13_ << 1;
         if (l_15_ >= 256L) {
            l_15_ ^= 285L;
         }

         long l_16_ = l_15_ ^ l;
         aLongArrayArray10584[0][i] = Class379.method4162(
            Class379.method4162(
               l_12_ << 8,
               Class379.method4162(
                  Class379.method4162(Class379.method4162(l << 32, Class379.method4162(Class379.method4162(l << 48, l << 56), l_13_ << 40)), l_15_ << 24),
                  l_14_ << 16
               )
            ),
            l_16_
         );

         for(int i_17_ = 1; i_17_ < 8; ++i_17_) {
            aLongArrayArray10584[i_17_][i] = Class379.method4162(aLongArrayArray10584[i_17_ + -1][i] >>> 8, aLongArrayArray10584[i_17_ + -1][i] << 56);
         }
      }

      aLongArray10583[0] = 0L;

      for(int i = 1; i <= 10; ++i) {
         int i_18_ = i * 8 - 8;
         aLongArray10583[i] = Class262_Sub11.method3177(
            Class300.method3496(aLongArrayArray10584[7][i_18_ - -7], 255L),
            Class262_Sub11.method3177(
               Class300.method3496(aLongArrayArray10584[6][6 + i_18_], 65280L),
               Class262_Sub11.method3177(
                  Class262_Sub11.method3177(
                     Class262_Sub11.method3177(
                        Class262_Sub11.method3177(
                           Class300.method3496(280375465082880L, aLongArrayArray10584[2][i_18_ + 2]),
                           Class262_Sub11.method3177(
                              Class300.method3496(aLongArrayArray10584[0][i_18_], -72057594037927936L),
                              Class300.method3496(aLongArrayArray10584[1][i_18_ + 1], 71776119061217280L)
                           )
                        ),
                        Class300.method3496(1095216660480L, aLongArrayArray10584[3][3 + i_18_])
                     ),
                     Class300.method3496(aLongArrayArray10584[4][4 + i_18_], 4278190080L)
                  ),
                  Class300.method3496(aLongArrayArray10584[5][5 + i_18_], 16711680L)
               )
            )
         );
      }
   }

   @Override
   final void method726(int i, int i_0_, int i_1_, int i_2_, int i_3_) {
      if (i_1_ != 4) {
         anInt10582 = -78;
      }

      ++anInt10579;
      int i_4_ = this.aGLSprite8999.method1197();
      int i_5_ = ((Class150_Sub3_Sub1)this.aClass150_5171).anInt10574 * Class295.method3471((byte)-65) / 10 % i_4_;
      this.aGLSprite8999.method1192(i_0_ - (i_4_ - i_5_), i, -i_5_ + i_2_ + i_4_, i_3_);
   }

   Class66_Sub2_Sub1(Index class302, Index class302_6_, Class150_Sub3_Sub1 class150_sub3_sub1) {
      super(class302, class302_6_, class150_sub3_sub1);
   }

   static final void method727(int i, int i_7_, int i_8_, int i_9_, int i_10_) {
      if (i_9_ <= -92) {
         ++anInt10580;
         if (~Class262_Sub4.anInt7722 >= ~i && ~za_Sub2.anInt10513 <= ~i) {
            i_8_ = Node_Sub38_Sub32.method2894(Class384.anInt4906, Node_Sub25_Sub1.anInt9936, 929798380, i_8_);
            i_10_ = Node_Sub38_Sub32.method2894(Class384.anInt4906, Node_Sub25_Sub1.anInt9936, 929798380, i_10_);
            Class50.method511(i_10_, i_8_, i_7_, i, 1);
         }
      }
   }

   static final int method728(int i, boolean bool, byte[] bs) {
      ++anInt10577;
      return bool ? 102 : Class10.method188((byte)-58, i, 0, bs);
   }

   public static void method729(byte b) {
      aLongArray10583 = null;
      NPC_EXAMINE_PACKET = null;
      if (b >= -5) {
         method728(36, true, null);
      }

      anInterface21Array10578 = null;
      aLongArrayArray10584 = null;
   }
}
