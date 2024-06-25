import jagtheora.ogg.OggPacket;
import jagtheora.ogg.OggStreamState;
import java.awt.Frame;

public class Node_Sub25_Sub4 extends Node_Sub25 {
   private String aString9992;
   private String aString9993;
   static int anInt9994;
   private int anInt9995;
   private float aFloat9996;
   private String aString9997;
   static IncommingPacket aClass192_9998 = new IncommingPacket(18, 4);
   static int anInt9999;
   static int anInt10000;
   static int anInt10001;
   static int anInt10002;
   private float aFloat10003;
   static int anInt10004;
   static int anInt10005 = -1;
   static Class110[] aClass110Array10006;
   private int anInt10007;
   static int anInt10008;
   static int anInt10009 = 0;
   static Class353 aClass353_10010 = new Class353("game4", "Game 4", 3);
   static int anInt10011 = 0;

   static {
      new Class353("game5", "Game 5", 4);
   }

   final float method2678(int i) {
      ++anInt10000;
      return i != 13192 ? 1.7027419F : this.aFloat10003;
   }

   static final void method2679(SignLink signlink, int i, Frame frame) {
      ++anInt10001;

      while(true) {
         Class241 class241 = signlink.method3639(frame, i + 14438);

         while(class241.anInt2953 == 0) {
            Class262_Sub22.method3208(10L, false);
         }

         if (class241.anInt2953 == 1) {
            if (i != 0) {
               method2681(-37);
            }

            frame.setVisible(false);
            frame.dispose();
            return;
         }

         Class262_Sub22.method3208(100L, false);
      }
   }

   final String method2680(int i) {
      ++anInt10002;
      if (i != -22478) {
         this.anInt9995 = -93;
      }

      return this.aString9993;
   }

   Node_Sub25_Sub4(OggStreamState oggstreamstate) {
      super(oggstreamstate);
   }

   @Override
   final void method2654(int i, OggPacket oggpacket) {
      if (i != 18986) {
         this.aFloat9996 = -1.0769852F;
      }

      ++anInt9999;
      if (this.anInt7234 <= 0 || "SUB".equals(this.aString9997)) {
         Buffer buffer = new Buffer(oggpacket.getData());
         int i_0_ = buffer.readUnsignedByte();
         if (this.anInt7234 > 8) {
            if (i_0_ == 0) {
               long l = buffer.method2196((byte)-104);
               long l_1_ = buffer.method2196((byte)-104);
               long l_2_ = buffer.method2196((byte)-104);
               if (~l > -1L || l_1_ < 0L || ~l_2_ > -1L || ~l > ~l_2_) {
                  throw new IllegalStateException();
               }

               this.aFloat9996 = (float)((long)this.anInt9995 * (l - -l_1_)) / (float)this.anInt10007;
               this.aFloat10003 = (float)((long)this.anInt9995 * l) / (float)this.anInt10007;
               int i_3_ = buffer.method2188(119);
               if (i_3_ < 0 || ~(buffer.buffer.length - buffer.offset) > ~i_3_) {
                  throw new IllegalStateException();
               }

               this.aString9992 = Class197.method2001((byte)-124, i_3_, buffer.buffer, buffer.offset);
            }

            if ((i_0_ | 128) != 0) {
               return;
            }
         } else {
            if (~(128 | i_0_) == -1) {
               throw new IllegalStateException();
            }

            if (this.anInt7234 == 0) {
               buffer.offset += 23;
               this.anInt10007 = buffer.method2188(125);
               this.anInt9995 = buffer.method2188(112);
               if (~this.anInt10007 == -1 || this.anInt9995 == 0) {
                  throw new IllegalStateException();
               }

               Buffer buffer_4_ = new Buffer(16);
               buffer.readBytes(buffer_4_.buffer, 0, 16);
               this.aString9993 = buffer_4_.readString();
               buffer_4_.offset = 0;
               buffer.readBytes(buffer_4_.buffer, 0, 16);
               this.aString9997 = buffer_4_.readString();
            }
         }
      }
   }

   public static void method2681(int i) {
      if (i <= 26) {
         anInt10011 = -57;
      }

      aClass110Array10006 = null;
      aClass192_9998 = null;
      aClass353_10010 = null;
   }

   final String method2682(int i) {
      ++anInt10008;
      int i_5_ = 24 / ((63 - i) / 39);
      return this.aString9992;
   }

   final float method2683(int i) {
      ++anInt10004;
      if (i > -47) {
         this.method2656(-1);
      }

      return this.aFloat9996;
   }

   @Override
   final void method2656(int i) {
      ++anInt9994;
      if (i != 100) {
         this.method2683(121);
      }
   }
}
