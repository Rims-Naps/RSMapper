public class CacheNode_Sub15 extends CacheNode {
   static int anInt9585;
   static int[] anIntArray9586 = new int[]{32, 39, 44, 47};
   static int anInt9587;
   static long aLong9588 = (long)(Math.random() * 9.999999999E9);
   static int anInt9589;
   static OutgoingPacket playerOption9 = new OutgoingPacket(43, 3);
   private int anInt9591;
   static int anInt9592;
   static int anInt9593;
   static int anInt9594;
   protected Class222[] aClass222Array9595;
   private byte[][] aByteArrayArray9596;

   final boolean method2378(int i) {
      ++anInt9587;
      if (this.aClass222Array9595 != null) {
         return true;
      } else {
         if (this.aByteArrayArray9596 == null) {
            synchronized(Node_Sub15_Sub11.aClass302_9859) {
               if (!Node_Sub15_Sub11.aClass302_9859.method3536(-1, this.anInt9591)) {
                  return false;
               }

               int[] is = Node_Sub15_Sub11.aClass302_9859.method3532(this.anInt9591, i ^ -419);
               this.aByteArrayArray9596 = new byte[is.length][];

               for(int i_0_ = 0; is.length > i_0_; ++i_0_) {
                  this.aByteArrayArray9596[i_0_] = Node_Sub15_Sub11.aClass302_9859.getFile(false, is[i_0_], this.anInt9591);
               }
            }
         }

         boolean bool = true;

         for(int i_1_ = 0; this.aByteArrayArray9596.length > i_1_; ++i_1_) {
            byte[] bs = this.aByteArrayArray9596[i_1_];
            Buffer buffer = new Buffer(bs);
            buffer.offset = 1;
            int i_2_ = buffer.readUnsignedShort();
            synchronized(Class145.aClass302_1799) {
               bool &= Class145.aClass302_1799.method3510(i_2_, (byte)63);
            }
         }

         if (!bool) {
            return false;
         } else {
            Class312 class312 = new Class312();
            int[] is;
            synchronized(Node_Sub15_Sub11.aClass302_9859) {
               int i_3_ = Node_Sub15_Sub11.aClass302_9859.method3537(-2, this.anInt9591);
               this.aClass222Array9595 = new Class222[i_3_];
               if (i != -419) {
                  this.method2381((byte)47, -27);
               }

               is = Node_Sub15_Sub11.aClass302_9859.method3532(this.anInt9591, 0);
            }

            for(int i_4_ = 0; is.length > i_4_; ++i_4_) {
               byte[] bs = this.aByteArrayArray9596[i_4_];
               Buffer buffer = new Buffer(bs);
               buffer.offset = 1;
               int i_5_ = buffer.readUnsignedShort();
               Node_Sub40 node_sub40 = null;

               for(Node_Sub40 node_sub40_6_ = (Node_Sub40)class312.method3613(i + 65699);
                  node_sub40_6_ != null;
                  node_sub40_6_ = (Node_Sub40)class312.method3620(16776960)
               ) {
                  if (node_sub40_6_.anInt7506 == i_5_) {
                     node_sub40 = node_sub40_6_;
                     break;
                  }
               }

               if (node_sub40 == null) {
                  synchronized(Class145.aClass302_1799) {
                     node_sub40 = new Node_Sub40(i_5_, Class145.aClass302_1799.method3518((byte)-126, i_5_));
                  }

                  class312.method3625((byte)-54, node_sub40);
               }

               this.aClass222Array9595[is[i_4_]] = new Class222(bs, node_sub40);
            }

            this.aByteArrayArray9596 = null;
            return true;
         }
      }
   }

   static final boolean loadInterface(int junk, int interfaceId) {
      ++anInt9593;
      if (interfaceId >= Class169_Sub1.aBooleanArray8788.length) {
         System.out.println("Interface id " + interfaceId + " is out of range!");
         return true;
      } else if (Class169_Sub1.aBooleanArray8788[interfaceId]) {
         return true;
      } else if (!Node_Sub38_Sub31.aClass302_10422.method3536(-1, interfaceId)) {
         return false;
      } else {
         int numComponents = Node_Sub38_Sub31.aClass302_10422.method3537(junk + -7017, interfaceId);
         if (numComponents == 0) {
            Class169_Sub1.aBooleanArray8788[interfaceId] = true;
            return true;
         } else {
            Class134_Sub3.aWidgetArrayArray9035[interfaceId] = new IComponentDefinitions[numComponents];

            for(int component = 0; component < numComponents; ++component) {
               if (interfaceId < Class134_Sub3.aWidgetArrayArray9035.length
                  && component < Class134_Sub3.aWidgetArrayArray9035[interfaceId].length
                  && Class134_Sub3.aWidgetArrayArray9035[interfaceId][component] == null) {
                  byte[] bs = Node_Sub38_Sub31.aClass302_10422.getFile(false, component, interfaceId);
                  if (bs != null) {
                     IComponentDefinitions widget = Class134_Sub3.aWidgetArrayArray9035[interfaceId][component] = new IComponentDefinitions();
                     widget.ihash = component + (interfaceId << 16);
                     if (bs[0] != -1) {
                        throw new IllegalStateException("if1");
                     }

                     if (interfaceId != 744 || component != 23) {
                        widget.decode(new Buffer(bs));
                     }

                     if (interfaceId != 596 && interfaceId != 882) {
                        if (interfaceId != 740 && interfaceId != 744 && (interfaceId < 747 || interfaceId > 754)) {
                           if (interfaceId == 137 || interfaceId == 662 || interfaceId == 182 || interfaceId == 187) {
                              widget.hidden = true;
                           } else if (interfaceId == 464
                              || interfaceId == 261
                              || interfaceId == 1110
                              || interfaceId == 1109
                              || interfaceId == 550
                              || interfaceId == 192
                              || interfaceId == 271
                              || interfaceId == 387
                              || interfaceId == 34
                              || interfaceId == 679
                              || interfaceId == 320
                              || interfaceId == 930
                              || interfaceId == 884) {
                              widget.hidden = true;
                           } else if (interfaceId == 746) {
                              if (component == 175 || component == 176) {
                                 widget.hidden = true;
                                 widget.baseWidth = 0;
                                 widget.baseHeight = 0;
                              }

                              if (component == 228 || component == 229 || component == 183) {
                                 widget.hidden = true;
                              }

                              if (component >= 177 && component <= 180) {
                                 widget.hidden = true;
                              }

                              if (component == 20) {
                                 widget.noClickThrough = false;
                              }

                              if (component == 19 || component >= 71 && component <= 78) {
                                 widget.hidden = true;
                              }

                              if (component >= 24 && component <= 70 || component >= 130 && component <= 163) {
                                 if (component != 67 && component != 51 && component != 35 && component != 156 && component != 157) {
                                    widget.hidden = true;
                                    widget.baseWidth = 0;
                                    widget.baseHeight = 0;
                                 } else {
                                    widget.basePositionX = component == 35 ? 6 : (component != 156 && component != 157 ? 2 : -7);
                                    widget.aspectXType = 2;
                                    if (component == 51) {
                                       widget.anObjectArray4770 = null;
                                    }
                                 }
                              }
                           }
                        } else {
                           widget.hidden = true;
                        }
                     } else {
                        widget.hidden = true;
                     }
                  }
               }
            }

            Class169_Sub1.aBooleanArray8788[interfaceId] = true;
            return true;
         }
      }
   }

   public static void method2380(boolean bool) {
      playerOption9 = null;
      anIntArray9586 = null;
      if (bool) {
         loadInterface(95, 36);
      }
   }

   final boolean method2381(byte b, int i) {
      ++anInt9594;
      if (b <= 61) {
         loadInterface(-47, 72);
      }

      return this.aClass222Array9595[i].aBoolean2640;
   }

   final boolean method2382(int i, int i_10_) {
      ++anInt9585;
      return i != 32 ? true : this.aClass222Array9595[i_10_].aBoolean2646;
   }

   final boolean method2383(int i, int i_11_) {
      if (i_11_ <= 75) {
         return true;
      } else {
         ++anInt9592;
         return this.aClass222Array9595[i].aBoolean2637;
      }
   }

   CacheNode_Sub15(int i) {
      this.anInt9591 = i;
   }
}
