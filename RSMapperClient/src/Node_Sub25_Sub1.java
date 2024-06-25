import jagtheora.ogg.OggPacket;
import jagtheora.ogg.OggStreamState;
import jagtheora.vorbis.DSPState;
import jagtheora.vorbis.VorbisBlock;
import jagtheora.vorbis.VorbisComment;
import jagtheora.vorbis.VorbisInfo;

public class Node_Sub25_Sub1 extends Node_Sub25 {
   private Node_Sub9_Sub5 aNode_Sub9_Sub5_9930;
   private VorbisInfo aVorbisInfo9931 = new VorbisInfo();
   static int anInt9932;
   static int anInt9933;
   static int anInt9934;
   private DSPState aDSPState9935;
   static int anInt9936 = 100;
   private int anInt9937;
   static int anInt9938;
   private Class191 aClass191_9939;
   static int anInt9940;
   static int[] anIntArray9941;
   private VorbisComment aVorbisComment9942 = new VorbisComment();
   static int anInt9943;
   static int anInt9944;
   static int anInt9945;
   static int anInt9946;
   static int worldmapLoaded = 0;
   static IncommingPacket aClass192_9948 = new IncommingPacket(1, -1);
   private double aDouble9949;
   static boolean aBoolean9950 = true;
   private VorbisBlock aVorbisBlock9951;
   static boolean aBoolean9952 = true;
   static OutgoingPacket aClass318_9953 = new OutgoingPacket(49, 3);

   static final void method2657(int i, int i_0_) {
      int i_1_ = -87 % ((i_0_ - -46) / 51);
      ++anInt9945;
      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 16, (long)i);
      cachenode_sub2.method2291((byte)121);
   }

   @Override
   final void method2656(int i) {
      if (this.aVorbisBlock9951 != null) {
         this.aVorbisBlock9951.a();
      }

      if (i != 100) {
         this.aDSPState9935 = null;
      }

      ++anInt9944;
      if (this.aDSPState9935 != null) {
         this.aDSPState9935.a();
      }

      this.aVorbisComment9942.a();
      this.aVorbisInfo9931.a();
      if (this.aNode_Sub9_Sub5_9930 != null) {
         this.aNode_Sub9_Sub5_9930.method2530(false);
      }
   }

   final Node_Sub9_Sub5 method2658(int i) {
      if (i != 27624) {
         return null;
      } else {
         ++anInt9938;
         return this.aNode_Sub9_Sub5_9930;
      }
   }

   static final void method2659(Node_Sub9_Sub1 node_sub9_sub1, boolean bool, int i, int i_2_, Index class302, int i_3_, int i_4_) {
      Class339_Sub8.method3946(i_2_, i_4_, i_3_, class302, bool, i + -8613);
      ++anInt9933;
      Class61.aNode_Sub9_Sub1_885 = node_sub9_sub1;
      if (i != 32345) {
         method2662(-3);
      }
   }

   @Override
   final void method2654(int i, OggPacket oggpacket) {
      ++anInt9943;
      if (~this.anInt7234 <= -4) {
         if (~this.aVorbisBlock9951.synthesis(oggpacket) == -1) {
            this.aDSPState9935.blockIn(this.aVorbisBlock9951);
         }

         float[][] fs = this.aDSPState9935.pcmOut(this.aVorbisInfo9931.channels);
         this.aDouble9949 = this.aDSPState9935.granuleTime();
         if (this.aDouble9949 == -1.0) {
            this.aDouble9949 = (double)((float)this.anInt9937 / (float)this.aVorbisInfo9931.rate);
         }

         this.aDSPState9935.read(fs[0].length);
         this.anInt9937 += fs[0].length;
         CacheNode_Sub8 cachenode_sub8 = this.aNode_Sub9_Sub5_9930.method2531(fs[0].length, this.aDouble9949, 0);
         Class320_Sub14.method3735(0, fs, cachenode_sub8.aShortArrayArray9491);

         for(int i_5_ = 0; ~this.aVorbisInfo9931.channels < ~i_5_; ++i_5_) {
            cachenode_sub8.aShortArrayArray9491[i_5_] = this.aClass191_9939.method1951(cachenode_sub8.aShortArrayArray9491[i_5_], 30664);
         }

         this.aNode_Sub9_Sub5_9930.method2532(cachenode_sub8, (byte)-73);
      } else {
         int i_6_ = this.aVorbisInfo9931.headerIn(this.aVorbisComment9942, oggpacket);
         if (i_6_ < 0) {
            throw new IllegalStateException(String.valueOf(i_6_));
         }

         if (this.anInt7234 == 2) {
            if (~this.aVorbisInfo9931.channels < -3 || ~this.aVorbisInfo9931.channels > -2) {
               throw new RuntimeException(String.valueOf(this.aVorbisInfo9931.channels));
            }

            this.aDSPState9935 = new DSPState(this.aVorbisInfo9931);
            this.aVorbisBlock9951 = new VorbisBlock(this.aDSPState9935);
            this.aClass191_9939 = new Class191(this.aVorbisInfo9931.rate, Class365.anInt4523);
            this.aNode_Sub9_Sub5_9930 = new Node_Sub9_Sub5(this.aVorbisInfo9931.channels);
         }
      }

      if (i != 18986) {
         method2664(-105, -33, 38, 83);
      }
   }

   static final OutgoingPacketBuffer method2660(int i) {
      ++anInt9934;
      OutgoingPacketBuffer node_sub13 = Class320_Sub5.method3699(93);
      node_sub13.aClass318_7109 = null;
      node_sub13.anInt7110 = i;
      node_sub13.currentOutgoingPacket = new Packet(5000);
      return node_sub13;
   }

   final double method2661(byte b) {
      ++anInt9932;
      if (b <= 120) {
         aBoolean9952 = false;
      }

      double d = this.aDouble9949;
      if (this.aNode_Sub9_Sub5_9930 != null) {
         d = this.aNode_Sub9_Sub5_9930.method2526(false);
         if (d < 0.0) {
            d = this.aDouble9949;
         }
      }

      return (double)(-(256.0F / (float)Class365.anInt4523)) + d;
   }

   public static void method2662(int i) {
      aClass318_9953 = null;
      if (i != -25081) {
         worldmapLoaded = 102;
      }

      aClass192_9948 = null;
      anIntArray9941 = null;
   }

   final int method2663(int i) {
      ++anInt9940;
      if (i >= -82) {
         return -128;
      } else {
         return this.aNode_Sub9_Sub5_9930 == null ? 0 : this.aNode_Sub9_Sub5_9930.method2529(0);
      }
   }

   static final int method2664(int i, int i_7_, int i_8_, int i_9_) {
      ++anInt9946;
      if (i_9_ == i) {
         return i_9_;
      } else {
         int i_10_ = -i_8_ + i_7_;
         int i_11_ = i_10_ * (i_9_ & 127) - -((i & 127) * i_8_) >> 7;
         int i_12_ = (i_9_ & 896) * i_10_ + (896 & i) * i_8_ >> 7;
         int i_13_ = i_8_ * (64512 & i) + i_10_ * (i_9_ & 64512) >> 7;
         return i_12_ & 896 | i_13_ & 64512 | 127 & i_11_;
      }
   }

   Node_Sub25_Sub1(OggStreamState oggstreamstate) {
      super(oggstreamstate);
   }
}
