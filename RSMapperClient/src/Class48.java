public class Class48 {
   protected int[] anIntArray690;
   protected boolean aBoolean691;
   protected int[] anIntArray692;
   static int anInt693;
   static EntityNode_Sub4[] anEntityNode_Sub4Array694;
   static int anInt695;
   protected int anInt696 = -1;
   static int anInt697;
   protected int anInt698;
   protected boolean aBoolean699;
   protected int[][] anIntArrayArray700;
   protected int[] anIntArray701;
   static int anInt702;
   protected boolean[] aBooleanArray703;
   static int anInt704;
   static int anInt705;
   protected int anInt706;
   protected int[] anIntArray707;
   protected int anInt708;
   static int anInt709;
   protected int anInt710;
   protected int anInt711;
   protected int[] anIntArray712;
   protected int anInt713;
   protected boolean aBoolean714;
   protected int[] anIntArray715;
   protected int anInt716;
   static int anInt717;
   protected int anInt718;

   final void method476(int i) {
      if (this.anInt718 == -1) {
         if (this.aBooleanArray703 != null) {
            this.anInt718 = 2;
         } else {
            this.anInt718 = 0;
         }
      }

      if (this.anInt698 == -1) {
         if (this.aBooleanArray703 == null) {
            this.anInt698 = 0;
         } else {
            this.anInt698 = 2;
         }
      }

      if (i != 2) {
         this.method476(-82);
      }

      ++anInt702;
   }

   final void method477(Buffer buffer, int i) {
      while(true) {
         int i_0_ = buffer.readUnsignedByte();
         if (~i_0_ == -1) {
            if (i == -14) {
               ++anInt705;
            }

            return;
         }

         this.method480(i_0_, (byte)-95, buffer);
      }
   }

   static final void method478(int i, byte b) {
      ++anInt709;
      if (Class151.anInt1843 != i) {
         if (i == 14 || i == 15) {
            Node_Sub38_Sub32.method2897(29);
         }

         if (i != 14 && Class290_Sub7.aClass365_8135 != null) {
            Class290_Sub7.aClass365_8135.method4062(-2);
            Class290_Sub7.aClass365_8135 = null;
         }

         if (i == 3) {
            Class245.method3069(-1, CacheNode_Sub4.aClass1_9466.anInt120 != Class320_Sub15.WINDOWS_PANE_ID);
         }

         if (i == 7) {
            Class18.method266(CacheNode_Sub4.aClass1_9466.anInt112 != Class320_Sub15.WINDOWS_PANE_ID, true);
         }

         if (i != 5 && i != 13) {
            if (i == 6 || i == 9 && Class151.anInt1843 != 10) {
               Node_Sub38_Sub32.method2897(29);
            }
         } else {
            Class201.method2024((byte)-91);
         }

         if (Class151.anInt1843 == 4 || Class151.anInt1843 == 8 || Class151.anInt1843 == 12 || Class151.anInt1843 == 10) {
            Class4.index2.anInt3795 = 2;
            Class14.index17.anInt3795 = 2;
            Class247.index16.anInt3795 = 2;
            Class174.index18.anInt3795 = 2;
            Class205.index19.anInt3795 = 2;
            Class262_Sub23.index20.anInt3795 = 2;
            Node_Sub15_Sub5.index21.anInt3795 = 2;
         }

         if (i == 4 || i == 8 || i == 12 || i == 10) {
            Node_Sub29_Sub2.anInt10015 = 0;
            Class188.anInt2287 = 1;
            Class320_Sub19.anInt8388 = 1;
            Class118.anInt5407 = 0;
            Node_Sub2.anInt6937 = 0;
            Class262_Sub23.method3212(true, 1295);
            Class4.index2.anInt3795 = 1;
            Class14.index17.anInt3795 = 1;
            Class247.index16.anInt3795 = 1;
            Class174.index18.anInt3795 = 1;
            Class205.index19.anInt3795 = 1;
            Class262_Sub23.index20.anInt3795 = 1;
            Node_Sub15_Sub5.index21.anInt3795 = 1;
         }

         if (i == 12 || i == 3) {
            Node_Sub24.method2644((byte)-42);
         }

         if (b < 96) {
            anInt704 = 65;
         }

         boolean bool = i >= 2 && i <= 10;
         boolean bool_1_ = Class151.anInt1843 >= 2 && Class151.anInt1843 <= 10;
         if (!bool_1_ == bool) {
            if (!bool) {
               Class166.method1746(2, -1);
               Class267.aClass266_3449.method3240(true, 0);
            } else {
               Class313.anInt4013 = Class317.anInt4038;
               if (Class213.aNode_Sub27_2512.aClass320_Sub25_7309.method3776(false) != 0) {
                  Class39.method408(
                     2, Class317.anInt4038, 0, false, Class213.aNode_Sub27_2512.aClass320_Sub25_7309.method3776(false), SeekableFile.index6, false
                  );
                  EntityNode_Sub7.method979(17285);
               } else {
                  Class166.method1746(2, -1);
               }

               Class267.aClass266_3449.method3240(false, 0);
            }
         }

         if (i == 4 || i == 8 || i == 10 || i == 12 || i == 14 || i == 15) {
            Class93.aGraphicsToolkit1241.h();
         }

         Class151.anInt1843 = i;
      }

      if (i == 11 && !WorldmapDefinitions.worldmapIsOpen()) {
         Class78.MAP_CHANGED = true;
      }
   }

   static final CacheNode_Sub2 method479(int i) {
      if (i != 1) {
         anEntityNode_Sub4Array694 = null;
      }

      ++anInt693;
      CacheNode_Sub2 cachenode_sub2 = (CacheNode_Sub2)Class72.aClass158_974.method1723(13);
      if (cachenode_sub2 != null) {
         cachenode_sub2.method2160((byte)73);
         cachenode_sub2.method2275(i ^ -80);
         return cachenode_sub2;
      } else {
         do {
            cachenode_sub2 = (CacheNode_Sub2)Node_Sub5.aClass158_7027.method1723(i ^ 12);
            if (cachenode_sub2 == null) {
               return null;
            }

            if (cachenode_sub2.method2287(13) > Class313.method3650(false)) {
               return null;
            }

            cachenode_sub2.method2160((byte)114);
            cachenode_sub2.method2275(-106);
         } while(~(cachenode_sub2.aLong7037 & Long.MIN_VALUE) == -1L);

         return cachenode_sub2;
      }
   }

   private final void method480(int i, byte b, Buffer buffer) {
      int i_2_ = -8 / ((-14 - b) / 62);
      ++anInt697;
      if (~i == -2) {
         int i_3_ = buffer.readUnsignedShort();
         this.anIntArray707 = new int[i_3_];

         for(int i_4_ = 0; i_4_ < i_3_; ++i_4_) {
            this.anIntArray707[i_4_] = buffer.readUnsignedShort();
         }

         this.anIntArray715 = new int[i_3_];

         for(int i_5_ = 0; i_5_ < i_3_; ++i_5_) {
            this.anIntArray715[i_5_] = buffer.readUnsignedShort();
         }

         for(int i_6_ = 0; i_3_ > i_6_; ++i_6_) {
            this.anIntArray715[i_6_] = (buffer.readUnsignedShort() << 16) - -this.anIntArray715[i_6_];
         }
      } else if (~i != -3) {
         if (i == 3) {
            this.aBooleanArray703 = new boolean[256];
            int i_7_ = buffer.readUnsignedByte();

            for(int i_8_ = 0; i_7_ > i_8_; ++i_8_) {
               this.aBooleanArray703[buffer.readUnsignedByte()] = true;
            }
         } else if (~i == -6) {
            this.anInt710 = buffer.readUnsignedByte();
         } else if (~i != -7) {
            if (i == 7) {
               this.anInt713 = buffer.readUnsignedShort();
            } else if (~i == -9) {
               this.anInt708 = buffer.readUnsignedByte();
            } else if (i != 9) {
               if (~i != -11) {
                  if (i != 11) {
                     if (~i == -13) {
                        int i_9_ = buffer.readUnsignedByte();
                        this.anIntArray712 = new int[i_9_];

                        for(int i_10_ = 0; i_9_ > i_10_; ++i_10_) {
                           this.anIntArray712[i_10_] = buffer.readUnsignedShort();
                        }

                        for(int i_11_ = 0; i_9_ > i_11_; ++i_11_) {
                           this.anIntArray712[i_11_] += buffer.readUnsignedShort() << 16;
                        }
                     } else if (i == 13) {
                        int i_12_ = buffer.readUnsignedShort();
                        this.anIntArrayArray700 = new int[i_12_][];

                        for(int i_13_ = 0; i_13_ < i_12_; ++i_13_) {
                           int i_14_ = buffer.readUnsignedByte();
                           if (i_14_ > 0) {
                              this.anIntArrayArray700[i_13_] = new int[i_14_];
                              this.anIntArrayArray700[i_13_][0] = buffer.read24BitInteger();

                              for(int i_15_ = 1; i_14_ > i_15_; ++i_15_) {
                                 this.anIntArrayArray700[i_13_][i_15_] = buffer.readUnsignedShort();
                              }
                           }
                        }
                     } else if (~i == -15) {
                        this.aBoolean691 = true;
                     } else if (~i != -16) {
                        if (i != 16) {
                           if (i != 18) {
                              if (~i == -20) {
                                 if (this.anIntArray701 == null) {
                                    this.anIntArray701 = new int[this.anIntArrayArray700.length];

                                    for(int i_16_ = 0; ~this.anIntArrayArray700.length < ~i_16_; ++i_16_) {
                                       this.anIntArray701[i_16_] = 255;
                                    }
                                 }

                                 this.anIntArray701[buffer.readUnsignedByte()] = buffer.readUnsignedByte();
                              } else if (~i == -21) {
                                 if (this.anIntArray690 == null || this.anIntArray692 == null) {
                                    this.anIntArray690 = new int[this.anIntArrayArray700.length];
                                    this.anIntArray692 = new int[this.anIntArrayArray700.length];

                                    for(int i_17_ = 0; ~this.anIntArrayArray700.length < ~i_17_; ++i_17_) {
                                       this.anIntArray690[i_17_] = 256;
                                       this.anIntArray692[i_17_] = 256;
                                    }
                                 }

                                 int i_18_ = buffer.readUnsignedByte();
                                 this.anIntArray690[i_18_] = buffer.readUnsignedShort();
                                 this.anIntArray692[i_18_] = buffer.readUnsignedShort();
                              }
                           } else {
                              this.aBoolean699 = true;
                           }
                        }
                     } else {
                        this.aBoolean714 = true;
                     }
                  } else {
                     this.anInt706 = buffer.readUnsignedByte();
                  }
               } else {
                  this.anInt718 = buffer.readUnsignedByte();
               }
            } else {
               this.anInt698 = buffer.readUnsignedByte();
            }
         } else {
            this.anInt716 = buffer.readUnsignedShort();
         }
      } else {
         this.anInt696 = buffer.readUnsignedShort();
      }
   }

   static final void method481(int i) {
      ++anInt695;
      Class182.method1832();
      if (i != 0) {
         anInt704 = 16;
      }
   }

   public static void method482(int i) {
      if (i != 0) {
         anEntityNode_Sub4Array694 = null;
      }

      anEntityNode_Sub4Array694 = null;
   }

   static final void method483(String string, int i, String string_19_, boolean bool, int i_20_) {
      ++anInt717;
      OutgoingPacketBuffer node_sub13 = Node_Sub25_Sub1.method2660(i_20_ ^ i_20_);
      node_sub13.currentOutgoingPacket.writeByte(Plane.aClass133_3414.packetId);
      node_sub13.currentOutgoingPacket.writeShort(0);
      int i_21_ = node_sub13.currentOutgoingPacket.offset;
      node_sub13.currentOutgoingPacket.writeShort(667);
      int[] is = Class355.method4014(i_20_ ^ -5411, node_sub13);
      int i_22_ = node_sub13.currentOutgoingPacket.offset;
      node_sub13.currentOutgoingPacket.writeString(string);
      node_sub13.currentOutgoingPacket.writeShort(Class170.anInt2056);
      node_sub13.currentOutgoingPacket.writeString(string_19_);
      node_sub13.currentOutgoingPacket.writeLong(Node_Sub32.aLong7385);
      node_sub13.currentOutgoingPacket.writeByte(Class35.language);
      node_sub13.currentOutgoingPacket.writeByte(Class209.aClass353_2483.anInt4344);
      EntityNode_Sub3.method941(i_20_ ^ 27, node_sub13.currentOutgoingPacket);
      String string_23_ = Node_Sub38_Sub18.aString10283;
      node_sub13.currentOutgoingPacket.writeByte(string_23_ != null ? 1 : 0);
      if (string_23_ != null) {
         node_sub13.currentOutgoingPacket.writeString(string_23_);
      }

      node_sub13.currentOutgoingPacket.writeByte(i);
      node_sub13.currentOutgoingPacket.writeByte(bool ? 1 : 0);
      node_sub13.currentOutgoingPacket.offset += 7;
      node_sub13.currentOutgoingPacket.encryptXteas(is, i_22_, false, node_sub13.currentOutgoingPacket.offset);
      node_sub13.currentOutgoingPacket.method2194(node_sub13.currentOutgoingPacket.offset - i_21_, -2887);
      Class218.aClass123_2560.sendPacket(126, node_sub13);
      Node_Sub54.anInt7683 = 0;
      Node_Sub36_Sub4.anInt10073 = -3;
      Class51_Sub2.anInt9069 = 0;
      Class4.anInt124 = 1;
      if (~i > -14) {
         Class255.aBoolean3218 = true;
         Class189.method1933(-9014);
      }
   }

   public Class48() {
      this.aBoolean691 = false;
      this.anInt706 = 2;
      this.anInt698 = -1;
      this.anInt708 = 99;
      this.anInt710 = 5;
      this.aBoolean699 = false;
      this.aBoolean714 = false;
      this.anInt713 = -1;
      this.anInt716 = -1;
      this.anInt718 = -1;
   }
}
