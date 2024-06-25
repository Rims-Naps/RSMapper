import com.dropbox.core.v2.DbxClientV2;

public class Class1 {
   protected boolean aBoolean105 = true;
   protected short[][] aShortArrayArray106;
   static int anInt107;
   protected int[] anIntArray108 = null;
   static int[] anIntArray109 = new int[]{19, 55, 38, 155, 255, 110, 137, 205, 76};
   protected int anInt110 = -1;
   protected boolean aBoolean111;
   protected int anInt112;
   protected short[][][] aShortArrayArrayArray113;
   static int anInt114;
   static int anInt115 = -1;
   protected int anInt116;
   protected int anInt117 = 4;
   protected int anInt118;
   protected int[] anIntArray119;
   protected int anInt120;
   public static DbxClientV2 aHashTable1923;

   private final void method163(Buffer buffer, int i) {
      ++anInt114;
      boolean bool = false;

      while(true) {
         int i_0_ = buffer.readUnsignedByte();
         if (~i_0_ == -1) {
            if (!bool) {
               if (this.anIntArray119 == null) {
                  this.anIntArray108 = new int[4];
                  this.anIntArray119 = new int[4];
                  this.anInt117 = 4;
               }

               for(int i_8_ = 0; i_8_ < this.anIntArray119.length; ++i_8_) {
                  this.anIntArray119[i_8_] = 0;
                  this.anIntArray108[i_8_] = i_8_ * 20;
               }
            }

            if (i != 10200) {
               method164(null, (byte)-62, -57);
            }

            return;
         }

         if (~i_0_ != -2) {
            if (~i_0_ == -3) {
               this.anInt110 = buffer.readUnsignedShort();
            } else if (i_0_ == 3) {
               this.anInt117 = buffer.readUnsignedByte();
               this.anIntArray108 = new int[this.anInt117];
               this.anIntArray119 = new int[this.anInt117];
            } else if (i_0_ != 4) {
               if (~i_0_ == -6) {
                  this.anInt120 = buffer.read24BitInteger();
               } else if (~i_0_ == -7) {
                  this.anInt112 = buffer.read24BitInteger();
               } else if (i_0_ != 7) {
                  if (i_0_ != 8) {
                     if (~i_0_ == -10) {
                        this.anInt116 = buffer.readUnsignedByte();
                     } else if (i_0_ != 10) {
                        if (~i_0_ == -12) {
                           this.anInt118 = buffer.readUnsignedByte();
                        }
                     } else {
                        this.aBoolean111 = false;
                     }
                  } else {
                     this.aBoolean105 = false;
                  }
               } else {
                  this.aShortArrayArrayArray113 = new short[10][4][];
                  this.aShortArrayArray106 = new short[10][4];

                  for(int i_1_ = 0; i_1_ < 10; ++i_1_) {
                     for(int i_2_ = 0; ~i_2_ > -5; ++i_2_) {
                        int i_3_ = buffer.readUnsignedShort();
                        if (~i_3_ == -65536) {
                           i_3_ = -1;
                        }

                        this.aShortArrayArray106[i_1_][i_2_] = (short)i_3_;
                        int i_4_ = buffer.readUnsignedShort();
                        this.aShortArrayArrayArray113[i_1_][i_2_] = new short[i_4_];

                        for(int i_5_ = 0; ~i_5_ > ~i_4_; ++i_5_) {
                           int i_6_ = buffer.readUnsignedShort();
                           if (~i_6_ == -65536) {
                              i_6_ = -1;
                           }

                           this.aShortArrayArrayArray113[i_1_][i_2_][i_5_] = (short)i_6_;
                        }
                     }
                  }
               }
            }
         } else {
            if (this.anIntArray119 == null) {
               this.anIntArray119 = new int[4];
               this.anIntArray108 = new int[4];
               this.anInt117 = 4;
            }

            bool = true;

            for(int i_7_ = 0; i_7_ < this.anIntArray119.length; ++i_7_) {
               this.anIntArray119[i_7_] = buffer.readShort();
               this.anIntArray108[i_7_] = buffer.readShort();
            }
         }
      }
   }

   static final short[] method164(short[] ses, byte b, int i) {
      ++anInt107;
      short[] ses_9_ = new short[i];
      if (b > -11) {
         anIntArray109 = null;
      }

      Class311.method3606(ses, 0, ses_9_, 0, i);
      return ses_9_;
   }

   public static void method165(byte b) {
      if (b < -78) {
         anIntArray109 = null;
      }
   }

   Class1(Index class302) {
      this.aBoolean111 = true;
      this.anInt116 = 2;
      this.anIntArray119 = null;
      this.anInt118 = 3;

      try {
         byte[] bs = class302.method3518((byte)126, 3);
         this.method163(new Buffer(bs), 10200);
      } catch (RuntimeException var3) {
         throw Class126.method1537(var3, "aba.<init>(" + (class302 != null ? "{...}" : "null") + ')');
      }
   }
}
