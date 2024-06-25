public class EntityNode_Sub7 extends EntityNode {
   static int anInt5997;
   private int anInt5998 = 0;
   private long aLong5999;
   static int anInt6000;
   static int anInt6001;
   static int anInt6002;
   protected Class300 aClass300_6003;
   protected int anInt6004;
   protected Class143 aClass143_6005;
   protected Class103 aClass103_6006;
   static int anInt6007;
   static IncommingPacket aClass192_6008 = new IncommingPacket(116, -1);
   protected EntityNode_Sub4 anEntityNode_Sub4_6009;
   static int anInt6010;
   protected Class355 aClass355_6011;
   protected boolean aBoolean6012 = false;
   static int anInt6013;
   private Class143 aClass143_6014;
   private int anInt6015;
   private int anInt6016;
   private int anInt6017;
   private int anInt6018;
   private int anInt6019;
   private boolean aBoolean6020;
   private int anInt6021;
   private int anInt6022;

   static final void method973(byte b, Player player, int i, int i_0_) {
      ++anInt5997;
      int[] is = new int[4];
      Class311.method3604(is, 0, is.length, i_0_);
      Class352.method4011(is, i, false, player, -110);
      if (b != 75) {
         method979(-123);
      }
   }

   final void method974(int i, byte b, boolean bool, long l, GraphicsToolkit graphicstoolkit) {
      if (!this.aBoolean6012) {
         if (~this.aClass355_6011.anInt4379 < ~Node_Sub39.anInt7498) {
            bool = false;
         } else if (Class94.anIntArray1247[Node_Sub39.anInt7498] >= CacheNode_Sub12.anInt9555) {
            if (!this.aBoolean6020) {
               if (~this.aClass355_6011.anInt4411 != 0) {
                  int i_1_ = (int)(-this.aLong5999 + l);
                  if (!this.aClass355_6011.aBoolean4390 && this.aClass355_6011.anInt4411 < i_1_) {
                     bool = false;
                  } else {
                     i_1_ %= this.aClass355_6011.anInt4411;
                  }

                  if (!this.aClass355_6011.aBoolean4375 && i_1_ < this.aClass355_6011.anInt4361) {
                     bool = false;
                  }

                  if (this.aClass355_6011.aBoolean4375 && ~this.aClass355_6011.anInt4361 >= ~i_1_) {
                     bool = false;
                  }
               }
            } else {
               bool = false;
            }
         } else {
            bool = false;
         }
      } else {
         bool = false;
      }

      ++anInt6007;
      if (bool) {
         ++Class228.anInt2719;
         int i_2_ = (this.aClass143_6005.anInt1774 + this.aClass143_6005.anInt1777 + this.aClass143_6005.anInt1779) / 3;
         int i_3_ = (this.aClass143_6005.anInt1765 + this.aClass143_6005.anInt1778 + this.aClass143_6005.anInt1781) / 3;
         int i_4_ = (this.aClass143_6005.anInt1775 + this.aClass143_6005.anInt1766 - -this.aClass143_6005.anInt1772) / 3;
         if (~i_2_ != ~this.aClass143_6005.anInt1767 || i_3_ != this.aClass143_6005.anInt1776 || ~this.aClass143_6005.anInt1769 != ~i_4_) {
            this.aClass143_6005.anInt1776 = i_3_;
            this.aClass143_6005.anInt1769 = i_4_;
            this.aClass143_6005.anInt1767 = i_2_;
            int i_5_ = -this.aClass143_6005.anInt1777 + this.aClass143_6005.anInt1779;
            int i_6_ = this.aClass143_6005.anInt1781 - this.aClass143_6005.anInt1778;
            int i_7_ = this.aClass143_6005.anInt1775 - this.aClass143_6005.anInt1766;
            int i_8_ = -this.aClass143_6005.anInt1777 + this.aClass143_6005.anInt1774;
            int i_9_ = this.aClass143_6005.anInt1765 + -this.aClass143_6005.anInt1778;
            int i_10_ = this.aClass143_6005.anInt1772 - this.aClass143_6005.anInt1766;
            this.anInt6022 = i_5_ * i_9_ + -(i_6_ * i_8_);
            this.anInt6018 = i_6_ * i_10_ - i_7_ * i_9_;

            for(this.anInt6021 = -(i_10_ * i_5_) + i_8_ * i_7_;
               ~this.anInt6018 < -32768
                  || ~this.anInt6021 < -32768
                  || ~this.anInt6022 < -32768
                  || this.anInt6018 < -32767
                  || this.anInt6021 < -32767
                  || ~this.anInt6022 > 32766;
               this.anInt6021 >>= 1
            ) {
               this.anInt6022 >>= 1;
               this.anInt6018 >>= 1;
            }

            int i_11_ = (int)Math.sqrt((double)(this.anInt6018 * this.anInt6018 - (-(this.anInt6021 * this.anInt6021) + -(this.anInt6022 * this.anInt6022))));
            if (i_11_ <= 0) {
               i_11_ = 1;
            }

            this.anInt6021 = this.anInt6021 * 32767 / i_11_;
            this.anInt6018 = this.anInt6018 * 32767 / i_11_;
            this.anInt6022 = this.anInt6022 * 32767 / i_11_;
            if (this.aClass355_6011.aShort4369 > 0 || ~this.aClass355_6011.aShort4382 < -1) {
               int i_12_ = (int)(2607.5945876176133 * Math.atan2((double)this.anInt6022, (double)this.anInt6018));
               int i_13_ = (int)(
                  Math.atan2((double)this.anInt6021, Math.sqrt((double)(this.anInt6018 * this.anInt6018 + this.anInt6022 * this.anInt6022)))
                     * 2607.5945876176133
               );
               this.anInt6016 = this.aClass355_6011.aShort4369 + -this.aClass355_6011.aShort4357;
               this.anInt6015 = -(this.anInt6016 >> 1) + this.aClass355_6011.aShort4357 + i_12_;
               this.anInt6017 = -this.aClass355_6011.aShort4386 + this.aClass355_6011.aShort4382;
               this.anInt6019 = -(this.anInt6017 >> 1) + this.aClass355_6011.aShort4386 + i_13_;
            }
         }

         this.anInt5998 += (int)(
            ((double)this.aClass355_6011.anInt4424 + Math.random() * (double)(-this.aClass355_6011.anInt4424 + this.aClass355_6011.anInt4381)) * (double)i
         );
         if (this.anInt5998 > 63) {
            int i_14_ = this.anInt5998 >> 6;
            this.anInt5998 &= 63;

            for(int i_15_ = 0; ~i_14_ < ~i_15_; ++i_15_) {
               int i_16_;
               int i_17_;
               int i_18_;
               if (this.aClass355_6011.aShort4369 <= 0 && this.aClass355_6011.aShort4382 <= 0) {
                  i_16_ = this.anInt6018;
                  i_17_ = this.anInt6022;
                  i_18_ = this.anInt6021;
               } else {
                  int i_19_ = (int)((double)this.anInt6016 * Math.random()) + this.anInt6015;
                  i_19_ &= 16383;
                  int i_20_ = Class335.anIntArray4167[i_19_];
                  int i_21_ = Class335.anIntArray4165[i_19_];
                  int i_22_ = this.anInt6019 + (int)((double)this.anInt6017 * Math.random());
                  i_22_ &= 8191;
                  int i_23_ = Class335.anIntArray4167[i_22_];
                  int i_24_ = Class335.anIntArray4165[i_22_];
                  int i_25_ = 13;
                  i_16_ = i_21_ * i_23_ >> i_25_;
                  i_18_ = -1 * (i_24_ << 1);
                  i_17_ = i_23_ * i_20_ >> i_25_;
               }

               float f = (float)Math.random();
               float f_26_ = (float)Math.random();
               if (f_26_ + f > 1.0F) {
                  f = 1.0F - f;
                  f_26_ = 1.0F - f_26_;
               }

               float f_27_ = -f_26_ - f + 1.0F;
               int i_28_ = (int)(
                  (float)this.aClass143_6005.anInt1774 * f_27_ + (float)this.aClass143_6005.anInt1779 * f_26_ + f * (float)this.aClass143_6005.anInt1777
               );
               int i_29_ = (int)(
                  (float)this.aClass143_6005.anInt1781 * f_26_ + f * (float)this.aClass143_6005.anInt1778 + f_27_ * (float)this.aClass143_6005.anInt1765
               );
               int i_30_ = (int)(
                  (float)this.aClass143_6005.anInt1766 * f + (float)this.aClass143_6005.anInt1775 * f_26_ + f_27_ * (float)this.aClass143_6005.anInt1772
               );
               int i_31_ = (int)(
                  f_27_ * (float)this.aClass143_6014.anInt1774 + (float)this.aClass143_6014.anInt1779 * f_26_ + (float)this.aClass143_6014.anInt1777 * f
               );
               int i_32_ = (int)(
                  f_27_ * (float)this.aClass143_6014.anInt1765 + f_26_ * (float)this.aClass143_6014.anInt1781 + f * (float)this.aClass143_6014.anInt1778
               );
               int i_33_ = (int)(
                  f_26_ * (float)this.aClass143_6014.anInt1775 + (float)this.aClass143_6014.anInt1766 * f + (float)this.aClass143_6014.anInt1772 * f_27_
               );
               int i_34_ = -i_31_ + i_28_;
               int i_35_ = i_29_ - i_32_;
               int i_36_ = i_30_ + -i_33_;
               int i_37_ = (int)((double)i_34_ * Math.random() + (double)i_31_);
               int i_38_ = (int)((double)i_32_ + (double)i_35_ * Math.random());
               int i_39_ = (int)((double)i_33_ + Math.random() * (double)i_36_);
               int i_40_ = (int)(Math.random() * (double)(this.aClass355_6011.anInt4367 - this.aClass355_6011.anInt4377)) + this.aClass355_6011.anInt4377;
               int i_41_ = (int)(Math.random() * (double)(this.aClass355_6011.anInt4388 + -this.aClass355_6011.anInt4401)) + this.aClass355_6011.anInt4401;
               int i_42_ = (int)(Math.random() * (double)(this.aClass355_6011.anInt4408 + -this.aClass355_6011.anInt4360)) + this.aClass355_6011.anInt4360;
               int i_43_;
               if (this.aClass355_6011.aBoolean4391) {
                  double d = Math.random();
                  i_43_ = (int)((double)this.aClass355_6011.anInt4389 + (double)this.aClass355_6011.anInt4402 * d)
                     | (int)((double)this.aClass355_6011.anInt4403 + d * (double)this.aClass355_6011.anInt4400) << 8
                     | (int)((double)this.aClass355_6011.anInt4383 + (double)this.aClass355_6011.anInt4420 * d) << 16
                     | (int)(Math.random() * (double)this.aClass355_6011.anInt4349 + (double)this.aClass355_6011.anInt4394) << 24;
               } else {
                  i_43_ = (int)((double)this.aClass355_6011.anInt4389 + Math.random() * (double)this.aClass355_6011.anInt4402)
                     | (int)((double)this.aClass355_6011.anInt4403 + Math.random() * (double)this.aClass355_6011.anInt4400) << 8
                     | (int)(Math.random() * (double)this.aClass355_6011.anInt4420 + (double)this.aClass355_6011.anInt4383) << 16
                     | (int)((double)this.aClass355_6011.anInt4394 + (double)this.aClass355_6011.anInt4349 * Math.random()) << 24;
               }

               int i_44_ = this.aClass355_6011.anInt4393;
               if (!graphicstoolkit.x() && !this.aClass355_6011.aBoolean4350) {
                  i_44_ = -1;
               }

               if (WorldItem.anInt11012 == Packet.anInt9386) {
                  new EntityNode_Sub3_Sub2_Sub1(
                     this,
                     i_37_,
                     i_38_,
                     i_39_,
                     i_16_,
                     i_18_,
                     i_17_,
                     i_40_,
                     i_41_,
                     i_43_,
                     i_42_,
                     i_44_,
                     this.aClass355_6011.aBoolean4373,
                     this.aClass355_6011.aBoolean4365
                  );
               } else {
                  EntityNode_Sub3_Sub2_Sub1 entitynode_sub3_sub2_sub1 = Class284.anEntityNode_Sub3_Sub2_Sub1Array3596[WorldItem.anInt11012];
                  WorldItem.anInt11012 = 1 + WorldItem.anInt11012 & 1023;
                  entitynode_sub3_sub2_sub1.method950(
                     this,
                     i_37_,
                     i_38_,
                     i_39_,
                     i_16_,
                     i_18_,
                     i_17_,
                     i_40_,
                     i_41_,
                     i_43_,
                     i_42_,
                     i_44_,
                     this.aClass355_6011.aBoolean4373,
                     this.aClass355_6011.aBoolean4365
                  );
               }
            }
         }
      }

      if (!this.aClass143_6005.method1625(81, this.aClass143_6014)) {
         Class143 class143 = this.aClass143_6014;
         this.aClass143_6014 = this.aClass143_6005;
         this.aClass143_6005 = class143;
         this.aClass143_6005.anInt1772 = this.aClass300_6003.anInt3771;
         this.aClass143_6005.anInt1774 = this.aClass300_6003.anInt3761;
         this.aClass143_6005.anInt1781 = this.aClass300_6003.anInt3756;
         this.aClass143_6005.anInt1779 = this.aClass300_6003.anInt3766;
         this.aClass143_6005.anInt1766 = this.aClass300_6003.anInt3753;
         this.aClass143_6005.anInt1778 = this.aClass300_6003.anInt3751;
         this.aClass143_6005.anInt1775 = this.aClass300_6003.anInt3758;
         this.aClass143_6005.anInt1776 = this.aClass143_6014.anInt1776;
         this.aClass143_6005.anInt1769 = this.aClass143_6014.anInt1769;
         this.aClass143_6005.anInt1777 = this.aClass300_6003.anInt3769;
         this.aClass143_6005.anInt1767 = this.aClass143_6014.anInt1767;
         this.aClass143_6005.anInt1765 = this.aClass300_6003.anInt3752;
      }

      this.anInt6004 = 0;
      if (b == 19) {
         for(EntityNode_Sub3_Sub2_Sub1 entitynode_sub3_sub2_sub1 = (EntityNode_Sub3_Sub2_Sub1)this.aClass103_6006.method1113((byte)105);
            entitynode_sub3_sub2_sub1 != null;
            entitynode_sub3_sub2_sub1 = (EntityNode_Sub3_Sub2_Sub1)this.aClass103_6006.method1108(b ^ 96)
         ) {
            entitynode_sub3_sub2_sub1.method948(l, i);
            ++this.anInt6004;
         }

         Class280.anInt3570 += this.anInt6004;
      }
   }

   public static void method975(boolean bool) {
      if (!bool) {
         method979(41);
      }

      aClass192_6008 = null;
   }

   final void method976(long l, GraphicsToolkit graphicstoolkit, int i) {
      ++anInt6000;

      for(EntityNode_Sub3_Sub2_Sub1 entitynode_sub3_sub2_sub1 = (EntityNode_Sub3_Sub2_Sub1)this.aClass103_6006.method1113((byte)116);
         entitynode_sub3_sub2_sub1 != null;
         entitynode_sub3_sub2_sub1 = (EntityNode_Sub3_Sub2_Sub1)this.aClass103_6006.method1108(98)
      ) {
         entitynode_sub3_sub2_sub1.method949(graphicstoolkit, l);
      }

      if (i != 0) {
         this.aClass143_6014 = null;
      }
   }

   final void method977(byte b) {
      this.aClass143_6005.anInt1781 = this.aClass300_6003.anInt3756;
      this.aClass143_6005.anInt1772 = this.aClass300_6003.anInt3771;
      this.aClass143_6005.anInt1774 = this.aClass300_6003.anInt3761;
      this.aClass143_6005.anInt1778 = this.aClass300_6003.anInt3751;
      this.aClass143_6005.anInt1779 = this.aClass300_6003.anInt3766;
      this.aClass143_6005.anInt1766 = this.aClass300_6003.anInt3753;
      if (b <= 60) {
         this.anInt6022 = 60;
      }

      ++anInt6010;
      this.aClass143_6005.anInt1775 = this.aClass300_6003.anInt3758;
      this.aClass143_6005.anInt1777 = this.aClass300_6003.anInt3769;
      this.aClass143_6005.anInt1765 = this.aClass300_6003.anInt3752;
      if (this.aClass143_6005.anInt1779 == this.aClass143_6005.anInt1777
         && this.aClass143_6005.anInt1774 == this.aClass143_6005.anInt1779
         && this.aClass143_6005.anInt1778 == this.aClass143_6005.anInt1781
         && ~this.aClass143_6005.anInt1781 == ~this.aClass143_6005.anInt1765
         && ~this.aClass143_6005.anInt1766 == ~this.aClass143_6005.anInt1775
         && this.aClass143_6005.anInt1772 == this.aClass143_6005.anInt1775) {
         this.aBoolean6020 = true;
      } else if (this.aBoolean6020) {
         this.aClass143_6014.anInt1778 = this.aClass143_6005.anInt1778;
         this.aClass143_6014.anInt1766 = this.aClass143_6005.anInt1766;
         this.aClass143_6014.anInt1777 = this.aClass143_6005.anInt1777;
         this.aClass143_6014.anInt1781 = this.aClass143_6005.anInt1781;
         this.aClass143_6014.anInt1775 = this.aClass143_6005.anInt1775;
         this.aClass143_6014.anInt1765 = this.aClass143_6005.anInt1765;
         this.aClass143_6014.anInt1772 = this.aClass143_6005.anInt1772;
         this.aBoolean6020 = false;
         this.aClass143_6014.anInt1774 = this.aClass143_6005.anInt1774;
         this.aClass143_6014.anInt1779 = this.aClass143_6005.anInt1779;
      }
   }

   static final void method978(int i, int i_45_) {
      ++anInt6002;
      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 7, (long)i_45_);
      cachenode_sub2.method2291((byte)121);
      if (i > -42) {
         method975(false);
      }
   }

   static final void method979(int i) {
      Class304.method3544(255, -1, 89);
      ++anInt6001;
      if (i != 17285) {
         anInt6013 = 66;
      }
   }

   EntityNode_Sub7(GraphicsToolkit graphicstoolkit, Class300 class300, EntityNode_Sub4 entitynode_sub4, long l) {
      this.aClass143_6005 = new Class143();
      this.aClass143_6014 = new Class143();
      this.aBoolean6020 = false;
      this.aClass300_6003 = class300;
      this.aLong5999 = l;
      this.anEntityNode_Sub4_6009 = entitynode_sub4;
      this.aClass355_6011 = this.aClass300_6003.method3495(99999999);
      if (!graphicstoolkit.x() && ~this.aClass355_6011.anInt4353 != 0) {
         this.aClass355_6011 = NpcDefinition.method3008((byte)55, this.aClass355_6011.anInt4353);
      }

      this.aClass103_6006 = new Class103();
      this.anInt5998 = (int)((double)this.anInt5998 + Math.random() * 64.0);
      this.method977((byte)86);
      this.aClass143_6014.anInt1779 = this.aClass143_6005.anInt1779;
      this.aClass143_6014.anInt1778 = this.aClass143_6005.anInt1778;
      this.aClass143_6014.anInt1775 = this.aClass143_6005.anInt1775;
      this.aClass143_6014.anInt1765 = this.aClass143_6005.anInt1765;
      this.aClass143_6014.anInt1781 = this.aClass143_6005.anInt1781;
      this.aClass143_6014.anInt1772 = this.aClass143_6005.anInt1772;
      this.aClass143_6014.anInt1766 = this.aClass143_6005.anInt1766;
      this.aClass143_6014.anInt1774 = this.aClass143_6005.anInt1774;
      this.aClass143_6014.anInt1777 = this.aClass143_6005.anInt1777;
   }
}
