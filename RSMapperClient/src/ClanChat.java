import java.io.DataInputStream;
import java.net.URL;

public class ClanChat {
   static int anInt723;
   protected byte aByte724;
   static int anInt725;
   static int anInt726;
   static int anInt727;
   static int anInt728;
   static int anInt729;
   static int anInt730;
   static int anInt731;
   static int anInt732;
   static int anInt733;
   protected int anInt734;
   private HashTable aHashTable735;
   static int anInt736;
   protected int[] anIntArray737;
   protected byte aByte738;
   protected int anInt739;
   protected String[] aStringArray740;
   static int anInt741;
   private boolean aBoolean742;
   static int anInt743;
   private int anInt744;
   static int anInt745;
   static int anInt746;
   protected long aLong747;
   protected byte aByte748;
   protected int anInt749 = -1;
   protected boolean aBoolean750;
   protected byte aByte751;
   static int anInt752;
   private long[] aLongArray753;
   private int[] anIntArray754;
   static int anInt755;
   static Class151 aClass151_756 = new Class151(4, 1, 1, 1);
   protected int anInt757 = 0;
   private boolean aBoolean758;
   static int anInt759;
   static int anInt760;
   static int anInt761;
   static int anInt762;
   protected String aString763;
   static int anInt764;
   protected int anInt765;
   static int anInt766;
   static int anInt767;
   private long[] aLongArray768;
   protected String[] aStringArray769;
   protected byte[] aByteArray770;
   private int[] anIntArray771;

   final int method486(int i, int i_0_, int i_1_, int i_2_, int i_3_) {
      ++anInt743;
      if (i_3_ != 15883) {
         return 72;
      } else {
         int i_4_ = (1 << i_2_) - 1;
         int i_5_ = ~i_1_ == -32 ? -1 : -1 + (1 << i_1_ - -1);
         int i_6_ = i_4_ ^ i_5_;
         i <<= i_2_;
         i &= i_6_;
         int i_7_ = this.anIntArray754[i_0_];
         if (i == (i_6_ & i_7_)) {
            return -1;
         } else {
            i_7_ &= ~i_6_;
            this.anIntArray754[i_0_] = Node_Sub16.method2590(i_7_, i);
            return i_0_;
         }
      }
   }

   private final void method487(byte b, int i) {
      if (this.aBoolean758) {
         if (this.aLongArray768 == null) {
            this.aLongArray768 = new long[i];
         } else {
            Class311.method3607(this.aLongArray768, 0, this.aLongArray768 = new long[i], 0, this.anInt734);
         }
      }

      ++anInt755;
      if (this.aBoolean742) {
         if (this.aStringArray740 == null) {
            this.aStringArray740 = new String[i];
         } else {
            Class311.method3605(this.aStringArray740, 0, this.aStringArray740 = new String[i], 0, this.anInt734);
         }
      }

      if (this.aByteArray770 != null) {
         Class311.method3608(this.aByteArray770, 0, this.aByteArray770 = new byte[i], 0, this.anInt734);
      } else {
         this.aByteArray770 = new byte[i];
      }

      if (this.anIntArray754 != null) {
         Class311.method3609(this.anIntArray754, 0, this.anIntArray754 = new int[i], 0, this.anInt734);
      } else {
         this.anIntArray754 = new int[i];
      }

      if (this.anIntArray737 != null) {
         Class311.method3609(this.anIntArray737, 0, this.anIntArray737 = new int[i], 0, this.anInt734);
      } else {
         this.anIntArray737 = new int[i];
      }

      if (b < 109) {
         this.anInt757 = 94;
      }
   }

   final void method488(int i, String string, long l, int i_8_) {
      if (string != null && ~string.length() == -1) {
         string = null;
      }

      ++anInt767;
      if (this.aBoolean758 != l > 0L) {
         throw new RuntimeException("Invalid UserHash arg to this method - useUserHashes:" + this.aBoolean758 + " but userhash:" + l);
      } else if (!this.aBoolean742 != (string == null)) {
         throw new RuntimeException("Invalid DisplayName arg to this method - useDisplayNames:" + this.aBoolean742 + " but displayname:" + string);
      } else {
         if (l > 0L && (this.aLongArray768 == null || this.anInt734 >= this.aLongArray768.length)
            || string != null && (this.aStringArray740 == null || ~this.aStringArray740.length >= ~this.anInt734)) {
            this.method487((byte)110, 5 + this.anInt734);
         }

         if (this.aLongArray768 != null) {
            this.aLongArray768[this.anInt734] = l;
         }

         if (this.aStringArray740 != null) {
            this.aStringArray740[this.anInt734] = string;
         }

         if (i != ~this.anInt765) {
            this.aByteArray770[this.anInt734] = 0;
         } else {
            this.anInt765 = this.anInt734;
            this.aByteArray770[this.anInt734] = 126;
         }

         this.anIntArray754[this.anInt734] = 0;
         this.anIntArray737[this.anInt734] = i_8_;
         this.anIntArray771 = null;
         ++this.anInt734;
      }
   }

   final Long method489(byte b, int i) {
      ++anInt732;
      if (this.aHashTable735 == null) {
         return null;
      } else {
         Node node = this.aHashTable735.get(3512, (long)i);
         if (b != -24) {
            this.method497(null, -61L, -20);
         }

         return node != null && node instanceof Node_Sub44 ? new Long(((Node_Sub44)node).aLong7550) : null;
      }
   }

   final int method490(String string, byte b) {
      ++anInt733;
      if (string != null && ~string.length() != -1) {
         for(int i = 0; ~i > ~this.anInt734; ++i) {
            if (this.aStringArray740[i].equals(string)) {
               return i;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   public static void method491(byte b) {
      if (b < 111) {
         anInt764 = -62;
      }

      aClass151_756 = null;
   }

   final boolean method492(String string, int i, boolean bool) {
      if (string == null) {
         string = "";
      } else if (string.length() > 80) {
         string = string.substring(0, 80);
      }

      ++anInt726;
      if (this.aHashTable735 != null) {
         Node node = this.aHashTable735.get(3512, (long)i);
         if (node != null) {
            if (node instanceof Node_Sub18) {
               Node_Sub18 node_sub18 = (Node_Sub18)node;
               if (node_sub18.aString7149.equals(string)) {
                  return false;
               }

               node_sub18.aString7149 = string;
               return true;
            }

            node.method2160((byte)104);
         }
      } else {
         this.aHashTable735 = new HashTable(4);
      }

      if (!bool) {
         return true;
      } else {
         this.aHashTable735.put((long)i, new Node_Sub18(string), -125);
         return true;
      }
   }

   private final void method493(byte b) {
      ++anInt730;
      if (~this.anInt734 == -1) {
         this.anInt749 = -1;
         this.anInt765 = -1;
      } else {
         this.anInt749 = -1;
         this.anInt765 = -1;
         if (b <= -115) {
            int i = 0;
            byte b_9_ = this.aByteArray770[0];

            for(int i_10_ = 1; i_10_ < this.anInt734; ++i_10_) {
               if (b_9_ >= this.aByteArray770[i_10_]) {
                  if (this.anInt749 == -1 && ~this.aByteArray770[i_10_] == -126) {
                     this.anInt749 = i_10_;
                  }
               } else {
                  if (b_9_ == 125) {
                     this.anInt749 = i;
                  }

                  i = i_10_;
                  b_9_ = this.aByteArray770[i_10_];
               }
            }

            this.anInt765 = i;
            if (~this.anInt765 != 0) {
               this.aByteArray770[this.anInt765] = 126;
            }
         }
      }
   }

   static final boolean method494(byte b, int i, int i_11_) {
      ++anInt728;
      if (b != 14) {
         return true;
      } else {
         return (2048 & i) != 0;
      }
   }

   final String method495(int i, int i_12_) {
      ++anInt731;
      if (this.aHashTable735 == null) {
         return null;
      } else {
         Node node = this.aHashTable735.get(3512, (long)i_12_);
         return node != null && node instanceof Node_Sub18 ? ((Node_Sub18)node).aString7149 : null;
      }
   }

   final void method496(int i, int i_14_) {
      ++anInt741;
      if (i_14_ <= i && this.anInt734 > i) {
         --this.anInt734;
         this.anIntArray771 = null;
         if (this.anInt734 != 0) {
            Class311.method3608(this.aByteArray770, 1 + i, this.aByteArray770, i, -i + this.anInt734);
            Class311.method3609(this.anIntArray754, 1 + i, this.anIntArray754, i, -i + this.anInt734);
            Class311.method3609(this.anIntArray737, i + 1, this.anIntArray737, i, this.anInt734 + -i);
            if (this.aLongArray768 != null) {
               Class311.method3607(this.aLongArray768, 1 + i, this.aLongArray768, i, -i + this.anInt734);
            }

            if (this.aStringArray740 != null) {
               Class311.method3605(this.aStringArray740, i - -1, this.aStringArray740, i, this.anInt734 - i);
            }

            if (this.anInt765 == i || this.anInt749 == i) {
               this.method493((byte)-126);
            }
         } else {
            this.anIntArray754 = null;
            this.aStringArray740 = null;
            this.aByteArray770 = null;
            this.anInt749 = -1;
            this.aLongArray768 = null;
            this.anIntArray737 = null;
            this.anInt765 = -1;
         }
      } else {
         throw new RuntimeException("Invalid pos in doDeleteMember - pos:" + i + " memberCount:" + this.anInt734);
      }
   }

   final void method497(String string, long l, int i) {
      if (string != null && string.length() == 0) {
         string = null;
      }

      if (i > -40) {
         this.anInt739 = -125;
      }

      ++anInt760;
      if (~l < -1L == !this.aBoolean758) {
         throw new RuntimeException("Invalid UserHash arg to this method - useUserHashes:" + this.aBoolean758 + " but userhash:" + l);
      } else if (this.aBoolean742 == (string == null)) {
         throw new RuntimeException("Invalid DisplayName arg to this method - useDisplayNames:" + this.aBoolean742 + " but displayname:" + string);
      } else {
         if (l > 0L && (this.aLongArray753 == null || ~this.aLongArray753.length >= ~this.anInt739)
            || string != null && (this.aStringArray769 == null || ~this.anInt739 <= ~this.aStringArray769.length)) {
            this.method503(5 + this.anInt739, (byte)-5);
         }

         if (this.aLongArray753 != null) {
            this.aLongArray753[this.anInt739] = l;
         }

         if (this.aStringArray769 != null) {
            this.aStringArray769[this.anInt739] = string;
         }

         ++this.anInt739;
      }
   }

   final int[] method498(int i) {
      if (this.anIntArray771 == null) {
         String[] strings = new String[this.anInt734];
         this.anIntArray771 = new int[this.anInt734];

         for(int i_16_ = 0; ~this.anInt734 < ~i_16_; this.anIntArray771[i_16_] = i_16_++) {
            strings[i_16_] = this.aStringArray740[i_16_];
         }

         Class339_Sub4.method3932((byte)74, this.anIntArray771, strings);
      }

      ++anInt729;
      return this.anIntArray771;
   }

   final boolean method499(byte b, int i, long l) {
      ++anInt736;
      if (b != 89) {
         return false;
      } else {
         if (this.aHashTable735 == null) {
            this.aHashTable735 = new HashTable(4);
         } else {
            Node node = this.aHashTable735.get(3512, (long)i);
            if (node != null) {
               if (node instanceof Node_Sub44) {
                  Node_Sub44 node_sub44 = (Node_Sub44)node;
                  if (~node_sub44.aLong7550 == ~l) {
                     return false;
                  }

                  node_sub44.aLong7550 = l;
                  return true;
               }

               node.method2160((byte)113);
            }
         }

         this.aHashTable735.put((long)i, new Node_Sub44(l), -127);
         return true;
      }
   }

   final int method500(byte b, byte b_17_, int i) {
      ++anInt759;
      if (b != b_17_ && b != 127) {
         if (this.anInt765 != i || ~this.anInt749 != 0 && ~this.aByteArray770[this.anInt749] <= -126) {
            if (b == this.aByteArray770[i]) {
               return -1;
            } else {
               this.aByteArray770[i] = b;
               this.method493((byte)-117);
               return i;
            }
         } else {
            return -1;
         }
      } else {
         return -1;
      }
   }

   final Integer method501(int i, int i_18_) {
      if (i_18_ >= -18) {
         this.anInt739 = -52;
      }

      ++anInt723;
      if (this.aHashTable735 == null) {
         return null;
      } else {
         Node node = this.aHashTable735.get(3512, (long)i);
         return node != null && node instanceof Node_Sub32 ? new Integer(((Node_Sub32)node).anInt7381) : null;
      }
   }

   final void method502(int i, byte b) {
      ++anInt761;
      --this.anInt739;
      if (this.anInt739 != 0) {
         if (this.aLongArray753 != null) {
            Class311.method3607(this.aLongArray753, i + 1, this.aLongArray753, i, -i + this.anInt739);
         }

         if (this.aStringArray769 != null) {
            Class311.method3605(this.aStringArray769, 1 + i, this.aStringArray769, i, this.anInt739 + -i);
         }
      } else {
         this.aStringArray769 = null;
         this.aLongArray753 = null;
      }

      if (b != 23) {
         this.aByte748 = 54;
      }
   }

   private final void method503(int i, byte b) {
      if (this.aBoolean758) {
         if (this.aLongArray753 != null) {
            Class311.method3607(this.aLongArray753, 0, this.aLongArray753 = new long[i], 0, this.anInt739);
         } else {
            this.aLongArray753 = new long[i];
         }
      }

      ++anInt752;
      if (this.aBoolean742) {
         if (this.aStringArray769 == null) {
            this.aStringArray769 = new String[i];
         } else {
            Class311.method3605(this.aStringArray769, 0, this.aStringArray769 = new String[i], 0, this.anInt739);
         }
      }

      if (b != -5) {
         this.anIntArray737 = null;
      }
   }

   final boolean method504(int i, int i_19_, int i_20_, int i_21_, int i_22_) {
      ++anInt745;
      int i_23_ = (1 << i_19_) - 1;
      int i_24_ = i == 31 ? -1 : -1 + (1 << i - -1);
      if (i_22_ != 11226) {
         this.anInt734 = -66;
      }

      int i_25_ = i_23_ ^ i_24_;
      i_20_ <<= i_19_;
      i_20_ &= i_25_;
      if (this.aHashTable735 == null) {
         this.aHashTable735 = new HashTable(4);
      } else {
         Node node = this.aHashTable735.get(3512, (long)i_21_);
         if (node != null) {
            if (node instanceof Node_Sub32) {
               Node_Sub32 node_sub32 = (Node_Sub32)node;
               if ((i_25_ & node_sub32.anInt7381) == i_20_) {
                  return false;
               }

               node_sub32.anInt7381 &= ~i_25_;
               node_sub32.anInt7381 |= i_20_;
               return true;
            }

            node.method2160((byte)71);
         }
      }

      this.aHashTable735.put((long)i_21_, new Node_Sub32(i_20_), -126);
      return true;
   }

   private final void method505(int i, Buffer buffer) {
      ++anInt725;
      int i_26_ = buffer.readUnsignedByte();
      if (i_26_ >= 1 && ~i_26_ >= -6) {
         int i_27_ = buffer.readUnsignedByte();
         if ((2 & i_27_) != 0) {
            this.aBoolean742 = true;
         }

         if (~(1 & i_27_) != -1) {
            this.aBoolean758 = true;
         }

         if (!this.aBoolean742) {
            this.aStringArray740 = null;
            this.aStringArray769 = null;
         }

         if (!this.aBoolean758) {
            this.aLongArray753 = null;
            this.aLongArray768 = null;
         }

         this.anInt757 = buffer.readInt();
         this.anInt744 = buffer.readInt();
         if (i_26_ <= 3 && this.anInt744 != 0) {
            this.anInt744 += 16912800;
         }

         if (i > -89) {
            this.method501(-24, -67);
         }

         this.anInt734 = buffer.readUnsignedShort();
         this.anInt739 = buffer.readUnsignedByte();
         this.aString763 = buffer.readString();
         if (~i_26_ <= -5) {
            buffer.readInt();
         }

         this.aBoolean750 = ~buffer.readUnsignedByte() == -2;
         this.aByte751 = buffer.readByte();
         this.aByte748 = buffer.readByte();
         this.aByte738 = buffer.readByte();
         this.aByte724 = buffer.readByte();
         if (this.anInt734 > 0) {
            if (this.aBoolean758 && (this.aLongArray768 == null || this.aLongArray768.length < this.anInt734)) {
               this.aLongArray768 = new long[this.anInt734];
            }

            if (this.aBoolean742 && (this.aStringArray740 == null || this.anInt734 > this.aStringArray740.length)) {
               this.aStringArray740 = new String[this.anInt734];
            }

            if (this.aByteArray770 == null || this.aByteArray770.length < this.anInt734) {
               this.aByteArray770 = new byte[this.anInt734];
            }

            if (this.anIntArray754 == null || this.anInt734 > this.anIntArray754.length) {
               this.anIntArray754 = new int[this.anInt734];
            }

            if (this.anIntArray737 == null || this.anInt734 > this.anIntArray737.length) {
               this.anIntArray737 = new int[this.anInt734];
            }

            for(int i_28_ = 0; ~this.anInt734 < ~i_28_; ++i_28_) {
               if (this.aBoolean758) {
                  this.aLongArray768[i_28_] = buffer.readLong();
               }

               if (this.aBoolean742) {
                  this.aStringArray740[i_28_] = buffer.readString2();
               }

               this.aByteArray770[i_28_] = buffer.readByte();
               if (~i_26_ <= -3) {
                  this.anIntArray754[i_28_] = buffer.readInt();
               }

               if (i_26_ >= 5) {
                  this.anIntArray737[i_28_] = buffer.readUnsignedShort();
               } else {
                  this.anIntArray737[i_28_] = 0;
               }
            }

            this.method493((byte)-128);
         }

         if (this.anInt739 > 0) {
            if (this.aBoolean758 && (this.aLongArray753 == null || ~this.aLongArray753.length > ~this.anInt739)) {
               this.aLongArray753 = new long[this.anInt739];
            }

            if (this.aBoolean742 && (this.aStringArray769 == null || this.aStringArray769.length < this.anInt739)) {
               this.aStringArray769 = new String[this.anInt739];
            }

            for(int i_29_ = 0; this.anInt739 > i_29_; ++i_29_) {
               if (this.aBoolean758) {
                  this.aLongArray753[i_29_] = buffer.readLong();
               }

               if (this.aBoolean742) {
                  this.aStringArray769[i_29_] = buffer.readString2();
               }
            }
         }

         if (~i_26_ <= -4) {
            int i_30_ = buffer.readUnsignedShort();
            if (i_30_ > 0) {
               this.aHashTable735 = new HashTable(i_30_ >= 16 ? 16 : Class320_Sub19.method3753(i_30_));

               while(~(i_30_--) < -1) {
                  int i_31_ = buffer.readInt();
                  int i_32_ = i_31_ & 1073741823;
                  int i_33_ = i_31_ >>> 30;
                  if (~i_33_ == -1) {
                     int i_34_ = buffer.readInt();
                     this.aHashTable735.put((long)i_32_, new Node_Sub32(i_34_), -124);
                  } else if (~i_33_ == -2) {
                     long l = buffer.readLong();
                     this.aHashTable735.put((long)i_32_, new Node_Sub44(l), -123);
                  } else if (~i_33_ == -3) {
                     String string = buffer.readString();
                     this.aHashTable735.put((long)i_32_, new Node_Sub18(string), -127);
                  }
               }
            }
         }
      } else {
         throw new RuntimeException("Unsupported ClanSettings version: " + i_26_);
      }
   }

   final Integer method506(byte b, int i, int i_35_, int i_36_) {
      ++anInt727;
      if (this.aHashTable735 == null) {
         return null;
      } else {
         Node node = this.aHashTable735.get(3512, (long)i);
         if (node != null && node instanceof Node_Sub32) {
            if (b != 73) {
               this.method501(68, 75);
            }

            int i_37_ = i_35_ != 31 ? -1 + (1 << i_35_ + 1) : -1;
            return new Integer((((Node_Sub32)node).anInt7381 & i_37_) >>> i_36_);
         } else {
            return null;
         }
      }
   }

   static final void method507(Throwable throwable, String string, int i) {
      if (i > -105) {
         aClass151_756 = null;
      }

      ++anInt766;

      try {
         String string_38_ = "";
         if (throwable != null) {
            string_38_ = Class240.method3030(0, throwable);
         }

         if (string != null) {
            if (throwable != null) {
               string_38_ = string_38_ + " | ";
            }

            string_38_ = string_38_ + string;
         }

         Class235_Sub1.method2158((byte)-78, string_38_);
         string_38_ = IComponentDefinitions.method4147(string_38_, false, ":", "%3a");
         string_38_ = IComponentDefinitions.method4147(string_38_, false, "@", "%40");
         string_38_ = IComponentDefinitions.method4147(string_38_, false, "&", "%26");
         string_38_ = IComponentDefinitions.method4147(string_38_, false, "#", "%23");
         if (CacheNode_Sub16.anApplet9601 != null) {
            Class241 class241 = Class152.aSignLink1940
               .method3642(
                  (byte)-80,
                  new URL(
                     CacheNode_Sub16.anApplet9601.getCodeBase(),
                     "clienterror.ws?c="
                        + Class320_Sub14.anInt8347
                        + "&u="
                        + (Node_Sub40.myPlayerDisplayName != null ? Node_Sub40.myPlayerDisplayName : String.valueOf(Node_Sub23.aLong7203))
                        + "&v1="
                        + SignLink.aString3989
                        + "&v2="
                        + SignLink.aString3995
                        + "&e="
                        + string_38_
                  )
               );

            while(class241.anInt2953 == 0) {
               Class262_Sub22.method3208(1L, false);
            }

            if (class241.anInt2953 == 1) {
               DataInputStream datainputstream = (DataInputStream)class241.anObject2956;
               datainputstream.read();
               datainputstream.close();
            }
         }
      } catch (Exception var6) {
      }
   }

   final int method508(int i, int i_39_, int i_40_, int i_41_) {
      if (i_39_ != -23948) {
         this.aByte724 = -88;
      }

      ++anInt746;
      int i_42_ = ~i_40_ != -32 ? (1 << i_40_ - -1) - 1 : -1;
      return (i_42_ & this.anIntArray754[i_41_]) >>> i;
   }

   final boolean method509(int i, int i_43_, int i_44_) {
      if (i_44_ != -553) {
         this.method497(null, 70L, -107);
      }

      ++anInt762;
      if (this.aHashTable735 == null) {
         this.aHashTable735 = new HashTable(4);
      } else {
         Node node = this.aHashTable735.get(i_44_ ^ -3985, (long)i_43_);
         if (node != null) {
            if (node instanceof Node_Sub32) {
               Node_Sub32 node_sub32 = (Node_Sub32)node;
               if (node_sub32.anInt7381 == i) {
                  return false;
               }

               node_sub32.anInt7381 = i;
               return true;
            }

            node.method2160((byte)95);
         }
      }

      this.aHashTable735.put((long)i_43_, new Node_Sub32(i), -127);
      return true;
   }

   ClanChat(Buffer buffer) {
      this.anInt744 = 0;
      this.aString763 = null;
      this.anInt765 = -1;
      this.method505(-102, buffer);
   }

   private ClanChat() {
      this.anInt744 = 0;
      this.aString763 = null;
      this.anInt765 = -1;
   }
}
