public class Class184 {
   protected int anInt2188 = -1;
   static Class158 aClass158_2189 = new Class158();
   private int[] anIntArray2190;
   private int[] anIntArray2191;
   static int anInt2192;
   private int[][] anIntArrayArray2193;
   private HashTable aHashTable2194;
   private int[] anIntArray2195;
   static int anInt2196;
   static long[] aLongArray2197;
   private String[] aStringArray2198;
   private int[] anIntArray2199;
   private int[] anIntArray2200;
   private String[] aStringArray2201;
   private String aString2202;
   static int[] minimapAreaIconLocalYPositions = new int[1000];
   private int[] anIntArray2204;
   static int anInt2205;
   static int anInt2206;
   private int[] anIntArray2207;
   private int[][] anIntArrayArray2208;
   private int[] anIntArray2209;
   private int[][] anIntArrayArray2210;
   private String aString2211;

   final void method1843(int i) {
      if (i != -18) {
         this.anIntArray2204 = null;
      }

      ++anInt2196;
      if (this.aString2202 == null) {
         this.aString2202 = this.aString2211;
      }
   }

   static final int method1844(int i, int i_0_) {
      return Class146.aShortArrayArray1802 != null ? Class146.aShortArrayArray1802[i][i_0_] & 65535 : 0;
   }

   private final void method1845(int i, Buffer buffer, byte b) {
      if (b < 46) {
         aClass158_2189 = null;
      }

      if (~i != -2) {
         if (~i != -3) {
            if (~i == -4) {
               int i_1_ = buffer.readUnsignedByte();
               this.anIntArrayArray2208 = new int[i_1_][3];

               for(int i_2_ = 0; ~i_1_ < ~i_2_; ++i_2_) {
                  this.anIntArrayArray2208[i_2_][0] = buffer.readUnsignedShort();
                  this.anIntArrayArray2208[i_2_][1] = buffer.readInt();
                  this.anIntArrayArray2208[i_2_][2] = buffer.readInt();
               }
            } else if (~i != -5) {
               if (i != 5) {
                  if (~i != -7) {
                     if (i != 7) {
                        if (i != 8) {
                           if (~i != -10) {
                              if (i == 10) {
                                 int i_3_ = buffer.readUnsignedByte();
                                 this.anIntArray2209 = new int[i_3_];

                                 for(int i_4_ = 0; i_3_ > i_4_; ++i_4_) {
                                    this.anIntArray2209[i_4_] = buffer.readInt();
                                 }
                              } else if (~i != -13) {
                                 if (i != 13) {
                                    if (~i != -15) {
                                       if (i == 15) {
                                          buffer.readUnsignedShort();
                                       } else if (~i == -18) {
                                          this.anInt2188 = buffer.readUnsignedShort();
                                       } else if (~i != -19) {
                                          if (i != 19) {
                                             if (~i == -250) {
                                                int i_5_ = buffer.readUnsignedByte();
                                                if (this.aHashTable2194 == null) {
                                                   int i_6_ = Class320_Sub19.method3753(i_5_);
                                                   this.aHashTable2194 = new HashTable(i_6_);
                                                }

                                                for(int i_7_ = 0; i_5_ > i_7_; ++i_7_) {
                                                   boolean bool = buffer.readUnsignedByte() == 1;
                                                   int i_8_ = buffer.read24BitInteger();
                                                   Node node;
                                                   if (!bool) {
                                                      node = new Node_Sub32(buffer.readInt());
                                                   } else {
                                                      node = new Node_Sub18(buffer.readString());
                                                   }

                                                   this.aHashTable2194.put((long)i_8_, node, -126);
                                                }
                                             }
                                          } else {
                                             int i_9_ = buffer.readUnsignedByte();
                                             this.anIntArray2204 = new int[i_9_];
                                             this.aStringArray2198 = new String[i_9_];
                                             this.anIntArray2195 = new int[i_9_];
                                             this.anIntArray2190 = new int[i_9_];

                                             for(int i_10_ = 0; ~i_9_ < ~i_10_; ++i_10_) {
                                                this.anIntArray2204[i_10_] = buffer.readInt();
                                                this.anIntArray2195[i_10_] = buffer.readInt();
                                                this.anIntArray2190[i_10_] = buffer.readInt();
                                                this.aStringArray2198[i_10_] = buffer.readString();
                                             }
                                          }
                                       } else {
                                          int i_11_ = buffer.readUnsignedByte();
                                          this.aStringArray2201 = new String[i_11_];
                                          this.anIntArray2200 = new int[i_11_];
                                          this.anIntArray2199 = new int[i_11_];
                                          this.anIntArray2191 = new int[i_11_];

                                          for(int i_12_ = 0; ~i_12_ > ~i_11_; ++i_12_) {
                                             this.anIntArray2200[i_12_] = buffer.readInt();
                                             this.anIntArray2191[i_12_] = buffer.readInt();
                                             this.anIntArray2199[i_12_] = buffer.readInt();
                                             this.aStringArray2201[i_12_] = buffer.readString();
                                          }
                                       }
                                    } else {
                                       int i_13_ = buffer.readUnsignedByte();
                                       this.anIntArrayArray2210 = new int[i_13_][2];

                                       for(int i_14_ = 0; ~i_13_ < ~i_14_; ++i_14_) {
                                          this.anIntArrayArray2210[i_14_][0] = buffer.readUnsignedByte();
                                          this.anIntArrayArray2210[i_14_][1] = buffer.readUnsignedByte();
                                       }
                                    }
                                 } else {
                                    int i_15_ = buffer.readUnsignedByte();
                                    this.anIntArray2207 = new int[i_15_];

                                    for(int i_16_ = 0; ~i_15_ < ~i_16_; ++i_16_) {
                                       this.anIntArray2207[i_16_] = buffer.readUnsignedShort();
                                    }
                                 }
                              } else {
                                 buffer.readInt();
                              }
                           } else {
                              buffer.readUnsignedByte();
                           }
                        }
                     } else {
                        buffer.readUnsignedByte();
                     }
                  } else {
                     buffer.readUnsignedByte();
                  }
               } else {
                  buffer.readUnsignedShort();
               }
            } else {
               int i_17_ = buffer.readUnsignedByte();
               this.anIntArrayArray2193 = new int[i_17_][3];

               for(int i_18_ = 0; ~i_17_ < ~i_18_; ++i_18_) {
                  this.anIntArrayArray2193[i_18_][0] = buffer.readUnsignedShort();
                  this.anIntArrayArray2193[i_18_][1] = buffer.readInt();
                  this.anIntArrayArray2193[i_18_][2] = buffer.readInt();
               }
            }
         } else {
            this.aString2202 = buffer.method2180((byte)125);
         }
      } else {
         this.aString2211 = buffer.method2180((byte)99);
      }

      ++anInt2206;
   }

   static final String method1846(int i, byte[] bs, int i_19_, byte b) {
      if (b > -100) {
         aClass158_2189 = null;
      }

      ++anInt2192;
      char[] cs = new char[i_19_];
      int i_20_ = 0;

      for(int i_21_ = 0; i_21_ < i_19_; ++i_21_) {
         int i_22_ = 255 & bs[i_21_ + i];
         if (i_22_ != 0) {
            if (i_22_ >= 128 && i_22_ < 160) {
               int i_23_ = Class204.aCharArray2455[-128 + i_22_];
               if (i_23_ == 0) {
                  i_23_ = 63;
               }

               i_22_ = i_23_;
            }

            cs[i_20_++] = (char)i_22_;
         }
      }

      String toReturn = new String(cs, 0, i_20_);
      if (toReturn.equals("Give assistance")) {
         toReturn = "Open URL";
      }

      return toReturn;
   }

   final void method1847(Buffer buffer, int i) {
      while(true) {
         int i_24_ = buffer.readUnsignedByte();
         if (i_24_ == 0) {
            if (i == 6991) {
               ++anInt2205;
            }

            return;
         }

         this.method1845(i_24_, buffer, (byte)100);
      }
   }

   public static void method1848(int i) {
      aClass158_2189 = null;
      if (i != 0) {
         aClass158_2189 = null;
      }

      aLongArray2197 = null;
      minimapAreaIconLocalYPositions = null;
   }
}
