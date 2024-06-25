public class Class320_Sub21 extends Class320 {
   static boolean[] aBooleanArray8403 = new boolean[100];
   static int anInt8404;
   static int anInt8405;
   static int anInt8406 = 0;
   static int anInt8407;
   static int anInt8408;
   static int anInt8409;
   static int anInt8410;
   static int anInt8411;
   static int anInt8412;
   static int anInt8413;

   Class320_Sub21(int i, Node_Sub27 node_sub27) {
      super(i, node_sub27);
   }

   public static void method3759(boolean bool) {
      if (bool) {
         aBooleanArray8403 = null;
      }

      aBooleanArray8403 = null;
   }

   @Override
   final void method3676(boolean bool, int i) {
      this.anInt4064 = i;
      if (!bool) {
         ++anInt8407;
      }
   }

   static final void method3760(boolean bool, GraphicsToolkit graphicstoolkit) {
      CacheNode_Sub18.aClass52_9609 = Class171.method1792(true, true, Node_Sub50.anInt7625, -115, graphicstoolkit);
      ++anInt8408;
      Class85.aClass357_1159 = Class150_Sub2.method1660((byte)-23, Node_Sub50.anInt7625, graphicstoolkit);
      StandardSprite.aClass52_8945 = Class171.method1792(true, true, Class285.anInt3600, -101, graphicstoolkit);
      Class169_Sub3.aClass357_8820 = Class150_Sub2.method1660((byte)-69, Class285.anInt3600, graphicstoolkit);
      Class262_Sub4.aClass52_7721 = Class171.method1792(true, bool, Class340.anInt4220, -108, graphicstoolkit);
      Class262_Sub15_Sub1.aClass357_10524 = Class150_Sub2.method1660((byte)109, Class340.anInt4220, graphicstoolkit);
   }

   static final Class169_Sub2_Sub1 method3761(int i, int i_0_, int i_1_, byte[] bs, int i_2_, GLToolkit gltoolkit, int i_3_, boolean bool) {
      if (i_1_ != 8222) {
         anInt8406 = -66;
      }

      ++anInt8409;
      if (!gltoolkit.aBoolean6652 && (!Class371.method4094(i_3_, false) || !Class371.method4094(i, false))) {
         return !gltoolkit.aBoolean6649
            ? new Class169_Sub2_Sub1(gltoolkit, i_0_, i_3_, i, Class320_Sub19.method3753(i_3_), Class320_Sub19.method3753(i), bs, i_2_)
            : new Class169_Sub2_Sub1(gltoolkit, 34037, i_0_, i_3_, i, bool, bs, i_2_);
      } else {
         return new Class169_Sub2_Sub1(gltoolkit, 3553, i_0_, i_3_, i, bool, bs, i_2_);
      }
   }

   Class320_Sub21(Node_Sub27 node_sub27) {
      super(node_sub27);
   }

   @Override
   final void method3673(byte b) {
      if (this.anInt4064 < 0 && this.anInt4064 > 4) {
         this.anInt4064 = this.method3677(0);
      }

      if (b >= -35) {
         method3759(true);
      }

      ++anInt8410;
   }

   final int method3762(boolean bool) {
      if (bool) {
         return -53;
      } else {
         ++anInt8412;
         return this.anInt4064;
      }
   }

   @Override
   final int method3675(int i, byte b) {
      if (b != 54) {
         return -123;
      } else {
         ++anInt8405;
         return 1;
      }
   }

   @Override
   final int method3677(int i) {
      ++anInt8413;
      if (i != 0) {
         return -123;
      } else {
         return ~this.aNode_Sub27_4063.method2694(i + -13725).method1881((byte)25) < -2 ? 4 : 2;
      }
   }

   static final byte[] method3763(int i, String string) {
      ++anInt8404;
      int i_4_ = string.length();
      byte[] bs = new byte[i_4_];
      int i_5_ = 18 / ((-69 - i) / 54);

      for(int i_6_ = 0; ~i_6_ > ~i_4_; ++i_6_) {
         int i_7_ = string.charAt(i_6_);
         if ((~i_7_ >= -1 || i_7_ >= 128) && (i_7_ < 160 || i_7_ > 255)) {
            if (i_7_ == 8364) {
               bs[i_6_] = -128;
            } else if (i_7_ == 8218) {
               bs[i_6_] = -126;
            } else if (i_7_ != 402) {
               if (i_7_ != 8222) {
                  if (i_7_ == 8230) {
                     bs[i_6_] = -123;
                  } else if (~i_7_ != -8225) {
                     if (i_7_ == 8225) {
                        bs[i_6_] = -121;
                     } else if (i_7_ == 710) {
                        bs[i_6_] = -120;
                     } else if (i_7_ == 8240) {
                        bs[i_6_] = -119;
                     } else if (i_7_ != 352) {
                        if (i_7_ != 8249) {
                           if (~i_7_ == -339) {
                              bs[i_6_] = -116;
                           } else if (~i_7_ != -382) {
                              if (i_7_ == 8216) {
                                 bs[i_6_] = -111;
                              } else if (~i_7_ != -8218) {
                                 if (~i_7_ != -8221) {
                                    if (~i_7_ != -8222) {
                                       if (i_7_ == 8226) {
                                          bs[i_6_] = -107;
                                       } else if (~i_7_ == -8212) {
                                          bs[i_6_] = -106;
                                       } else if (~i_7_ != -8213) {
                                          if (i_7_ != 732) {
                                             if (~i_7_ != -8483) {
                                                if (i_7_ != 353) {
                                                   if (i_7_ == 8250) {
                                                      bs[i_6_] = -101;
                                                   } else if (~i_7_ != -340) {
                                                      if (i_7_ == 382) {
                                                         bs[i_6_] = -98;
                                                      } else if (~i_7_ == -377) {
                                                         bs[i_6_] = -97;
                                                      } else {
                                                         bs[i_6_] = 63;
                                                      }
                                                   } else {
                                                      bs[i_6_] = -100;
                                                   }
                                                } else {
                                                   bs[i_6_] = -102;
                                                }
                                             } else {
                                                bs[i_6_] = -103;
                                             }
                                          } else {
                                             bs[i_6_] = -104;
                                          }
                                       } else {
                                          bs[i_6_] = -105;
                                       }
                                    } else {
                                       bs[i_6_] = -108;
                                    }
                                 } else {
                                    bs[i_6_] = -109;
                                 }
                              } else {
                                 bs[i_6_] = -110;
                              }
                           } else {
                              bs[i_6_] = -114;
                           }
                        } else {
                           bs[i_6_] = -117;
                        }
                     } else {
                        bs[i_6_] = -118;
                     }
                  } else {
                     bs[i_6_] = -122;
                  }
               } else {
                  bs[i_6_] = -124;
               }
            } else {
               bs[i_6_] = -125;
            }
         } else {
            bs[i_6_] = (byte)i_7_;
         }
      }

      return bs;
   }

   static final void method3764(int i) {
      for(int i_8_ = 0; i_8_ < 100; ++i_8_) {
         Class195.aBooleanArray2387[i_8_] = true;
      }

      if (i > -68) {
         method3764(-15);
      }

      ++anInt8411;
   }
}
