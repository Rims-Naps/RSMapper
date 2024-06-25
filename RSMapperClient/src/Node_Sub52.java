public class Node_Sub52 extends Node {
   static int anInt7634;
   protected int maxY2;
   protected int minX2;
   static int anInt7637;
   static int anInt7638;
   static Class68 aClass68_7639 = new Class68(1);
   static int anInt7640;
   protected int maxX2;
   private int minY1;
   private int maxX1;
   static int anInt7644;
   private int plane;
   protected int minY2;
   static int anInt7647;
   static Mobile[] aMobileArray7648;
   private int maxY1;
   static IncommingPacket aClass192_7650 = new IncommingPacket(63, 5);
   static int anInt7651;
   static int anInt7652;
   private int minX1;
   static Class244[] aClass244Array7654;
   static GLSprite[] aGLSpriteArray7655;
   static int anInt7656;

   final void method2970(int[] is, int i, int i_0_, int i_1_) {
      is[1] = i_0_ - -this.minX2 - this.minX1;
      ++anInt7634;
      is[i] = i_1_ - (-this.minY2 + this.minY1);
      is[0] = 0;
   }

   public static void method2971(byte b) {
      if (b != 73) {
         method2972(true);
      }

      aClass244Array7654 = null;
      aClass192_7650 = null;
      aClass68_7639 = null;
      aGLSpriteArray7655 = null;
      aMobileArray7648 = null;
   }

   static final int method2972(boolean bool) {
      if (bool) {
         aClass244Array7654 = null;
      }

      ++anInt7638;
      if (Class58.aWidget861 == null) {
         if (!Class213.rightClickDialogueIsOpen && Node_Sub38_Sub23.aCacheNode_Sub13_10343 != null) {
            return Node_Sub38_Sub23.aCacheNode_Sub13_10343.cursorSprite;
         }

         int i = Class106.aClass93_1356.getLastMousePosX();
         int i_2_ = Class106.aClass93_1356.getLastMousePosY(!bool);
         if (!Class194_Sub3_Sub1.aBoolean9375) {
            if (i > Node_Sub6.anInt7043 && Node_Sub6.anInt7043 + Class362.anInt4492 > i) {
               int i_3_ = -1;

               for(int i_4_ = 0; i_4_ < Class315.anInt4035; ++i_4_) {
                  if (!Node_Sub38_Sub5.aBoolean10130) {
                     int i_5_ = Client.anInt5481 + 31 + 16 * (-i_4_ + Class315.anInt4035 + -1);
                     if (i_2_ > -13 + i_5_ && i_5_ + 3 >= i_2_) {
                        i_3_ = i_4_;
                     }
                  } else {
                     int i_6_ = 16 * (-1 + Class315.anInt4035 - i_4_) + 33 + Client.anInt5481;
                     if (i_2_ > i_6_ + -13 && 3 + i_6_ >= i_2_) {
                        i_3_ = i_4_;
                     }
                  }
               }

               if (~i_3_ != 0) {
                  int i_7_ = 0;
                  Class157 class157 = new Class157(Class368.aClass312_4549);

                  for(CacheNode_Sub13 cachenode_sub13 = (CacheNode_Sub13)class157.method1714(2);
                     cachenode_sub13 != null;
                     cachenode_sub13 = (CacheNode_Sub13)class157.method1713((byte)-34)
                  ) {
                     if (i_3_ == i_7_++) {
                        return cachenode_sub13.cursorSprite;
                     }
                  }
               }
            }
         } else if (~Node_Sub6.anInt7043 > ~i && Node_Sub6.anInt7043 + Class362.anInt4492 > i) {
            int i_13_ = -1;

            for(int i_14_ = 0; Class21.anInt355 > i_14_; ++i_14_) {
               if (!Node_Sub38_Sub5.aBoolean10130) {
                  int i_15_ = Client.anInt5481 - -31 - -(i_14_ * 16);
                  if (~i_2_ < ~(i_15_ + -13) && 3 + i_15_ >= i_2_) {
                     i_13_ = i_14_;
                  }
               } else {
                  int i_16_ = 33 + Client.anInt5481 - -(16 * i_14_);
                  if (~i_2_ < ~(i_16_ + -13) && i_2_ <= 3 + i_16_) {
                     i_13_ = i_14_;
                  }
               }
            }

            if (i_13_ != -1) {
               int i_17_ = 0;
               Class269 class269 = new Class269(Class184.aClass158_2189);

               for(CacheNode_Sub4 cachenode_sub4 = (CacheNode_Sub4)class269.method3295(16);
                  cachenode_sub4 != null;
                  cachenode_sub4 = (CacheNode_Sub4)class269.method3294(16)
               ) {
                  if (~(i_17_++) == ~i_13_) {
                     return ((CacheNode_Sub13)cachenode_sub4.aClass158_9457.aCacheNode1984.aCacheNode7035).cursorSprite;
                  }
               }
            }
         } else if (Class73.aCacheNode_Sub4_988 != null && Class367.anInt4539 < i && i < CacheNode.anInt7033 + Class367.anInt4539) {
            int i_8_ = -1;

            for(int i_9_ = 0; Class73.aCacheNode_Sub4_988.anInt9462 > i_9_; ++i_9_) {
               if (Node_Sub38_Sub5.aBoolean10130) {
                  int i_10_ = 16 * i_9_ + 33 + ReferenceTable.anInt286;
                  if (-13 + i_10_ < i_2_ && ~(i_10_ + 3) <= ~i_2_) {
                     i_8_ = i_9_;
                  }
               } else {
                  int i_11_ = 31 + ReferenceTable.anInt286 - -(16 * i_9_);
                  if (~i_2_ < ~(i_11_ - 13) && i_2_ <= i_11_ - -3) {
                     i_8_ = i_9_;
                  }
               }
            }

            if (~i_8_ != 0) {
               int i_12_ = 0;
               Class269 class269 = new Class269(Class73.aCacheNode_Sub4_988.aClass158_9457);

               for(CacheNode_Sub13 cachenode_sub13 = (CacheNode_Sub13)class269.method3295(16);
                  cachenode_sub13 != null;
                  cachenode_sub13 = (CacheNode_Sub13)class269.method3294(16)
               ) {
                  if (i_12_++ == i_8_) {
                     return cachenode_sub13.cursorSprite;
                  }
               }
            }
         }
      }

      return -1;
   }

   final boolean method2973(int i, int i_18_, int i_19_) {
      if (i_19_ != 10598) {
         anInt7651 = -60;
      }

      ++anInt7637;
      return ~i_18_ <= ~this.minX2 && ~i_18_ >= ~this.maxX2 && ~i <= ~this.minY2 && ~i >= ~this.maxY2;
   }

   static final void method2974(int i, CacheNode_Sub13 cachenode_sub13) {
      ++anInt7656;
      if (!Class213.rightClickDialogueIsOpen) {
         cachenode_sub13.method2160((byte)95);
         --Class315.anInt4035;
         if (cachenode_sub13.aBoolean9567) {
            for(CacheNode_Sub4 cachenode_sub4 = (CacheNode_Sub4)Class184.aClass158_2189.method1723(13);
               cachenode_sub4 != null;
               cachenode_sub4 = (CacheNode_Sub4)Class184.aClass158_2189.method1721(0)
            ) {
               if (cachenode_sub4.aString9458.equals(cachenode_sub13.aString9558)) {
                  boolean bool = false;

                  for(CacheNode_Sub13 cachenode_sub13_20_ = (CacheNode_Sub13)cachenode_sub4.aClass158_9457.method1723(13);
                     cachenode_sub13_20_ != null;
                     cachenode_sub13_20_ = (CacheNode_Sub13)cachenode_sub4.aClass158_9457.method1721(0)
                  ) {
                     if (cachenode_sub13_20_ == cachenode_sub13) {
                        bool = true;
                        if (cachenode_sub4.method2301(39, cachenode_sub13)) {
                           GLSprite_Sub1.method1205(cachenode_sub4, (byte)50);
                        }
                        break;
                     }
                  }

                  if (bool) {
                     break;
                  }
               }
            }
         } else {
            long l = cachenode_sub13.aLong9564;
            CacheNode_Sub4 cachenode_sub4 = (CacheNode_Sub4)Class261.aHashTable3306.get(3512, l);

            while(cachenode_sub4 != null && !cachenode_sub4.aString9458.equals(cachenode_sub13.aString9558)) {
               cachenode_sub4 = (CacheNode_Sub4)Class261.aHashTable3306.method1524((byte)84);
            }

            if (cachenode_sub4 != null && cachenode_sub4.method2301(13, cachenode_sub13)) {
               GLSprite_Sub1.method1205(cachenode_sub4, (byte)-93);
            }
         }

         if (i != -1) {
            method2971((byte)-62);
         }
      }
   }

   final boolean method2975(int i, byte b, int i_21_, int i_22_) {
      ++anInt7640;
      if (b < 29) {
         aGLSpriteArray7655 = null;
      }

      return ~this.plane == ~i_21_ && ~i_22_ <= ~this.minX1 && i_22_ <= this.maxX1 && i >= this.minY1 && i <= this.maxY1;
   }

   final void method2976(int i, int[] is, int i_23_, int i_24_) {
      is[2] = -this.minY2 + this.minY1 + i_23_;
      is[i_24_] = this.minX1 + -this.minX2 + i;
      is[0] = this.plane;
      ++anInt7652;
   }

   final boolean method2977(int i, byte b, int i_25_) {
      ++anInt7647;
      if (b >= -19) {
         anInt7651 = -85;
      }

      return ~i <= ~this.minX1 && i <= this.maxX1 && i_25_ >= this.minY1 && ~i_25_ >= ~this.maxY1;
   }

   Node_Sub52(int plane, int i_26_, int i_27_, int i_28_, int i_29_, int i_30_, int i_31_, int i_32_, int i_33_) {
      this.plane = plane;
      this.minX1 = i_26_;
      this.minY1 = i_27_;
      this.maxX1 = i_28_;
      this.maxY1 = i_29_;
      this.minX2 = i_30_;
      this.minY2 = i_31_;
      this.maxX2 = i_32_;
      this.maxY2 = i_33_;
   }
}
