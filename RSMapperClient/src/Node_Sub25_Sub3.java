import jagtheora.ogg.OggPacket;
import jagtheora.ogg.OggStreamState;
import jagtheora.theora.DecoderContext;
import jagtheora.theora.Frame;
import jagtheora.theora.GranulePos;
import jagtheora.theora.SetupInfo;
import jagtheora.theora.TheoraComment;
import jagtheora.theora.TheoraInfo;

public class Node_Sub25_Sub3 extends Node_Sub25 {
   static int anInt9960;
   private DecoderContext aDecoderContext9961;
   static int anInt9962;
   private int anInt9963;
   private boolean aBoolean9964;
   static int anInt9965;
   static int[] anIntArray9966 = new int[]{1, 4, 1, 2, 1};
   private GLSprite aGLSprite9967;
   private SetupInfo aSetupInfo9968 = new SetupInfo();
   private boolean aBoolean9969;
   static int anInt9970;
   static int anInt9971;
   private TheoraInfo aTheoraInfo9972 = new TheoraInfo();
   private long aLong9973;
   private boolean aBoolean9974;
   private int anInt9975;
   static int anInt9976;
   static int anInt9977;
   static IncommingPacket aClass192_9978 = new IncommingPacket(53, -1);
   static int anInt9979;
   static Class299 aClass299_9980;
   private TheoraComment aTheoraComment9981 = new TheoraComment();
   static int anInt9982;
   private double aDouble9983;
   static int anInt9984;
   static int anInt9985;
   private Frame aFrame9986;
   static int localNPCsCount = 0;
   static int anInt9988;
   private GranulePos aGranulePos9989;
   static IComponentDefinitions aWidget9990 = null;
   private boolean aBoolean9991;

   final float method2667(int i) {
      ++anInt9960;
      if (this.aBoolean9991 && !this.aTheoraInfo9972.b()) {
         if (i != 0) {
            this.aLong9973 = -77L;
         }

         return (float)this.aTheoraInfo9972.fpsNumerator / (float)this.aTheoraInfo9972.fpsDenominator;
      } else {
         return 0.0F;
      }
   }

   public static void method2668(byte b) {
      aClass299_9980 = null;
      aClass192_9978 = null;
      if (b == -77) {
         aWidget9990 = null;
         anIntArray9966 = null;
      }
   }

   private final void method2669(byte b, int i) {
      this.anInt9975 = i;
      ++anInt9988;
      if (this.aBoolean9991) {
         if (~this.anInt9975 < ~this.anInt9963) {
            this.anInt9975 = this.anInt9963;
         }

         if (~this.anInt9975 > -1) {
            this.anInt9975 = 0;
         }

         this.aDecoderContext9961.setPostProcessingLevel(this.anInt9975);
      }
   }

   final GLSprite method2670(GraphicsToolkit graphicstoolkit, int i) {
      ++anInt9979;
      if (i != -10171) {
         return null;
      } else if (this.aFrame9986 == null) {
         return null;
      } else if (!this.aBoolean9974 && this.aGLSprite9967 != null) {
         return this.aGLSprite9967;
      } else {
         this.aGLSprite9967 = graphicstoolkit.a(this.aFrame9986.pixels, 0, this.aFrame9986.b, this.aFrame9986.b, this.aFrame9986.a, false);
         this.aBoolean9974 = false;
         return this.aGLSprite9967;
      }
   }

   static final String method2671(int i, String string) {
      ++anInt9985;
      if (string == null) {
         return null;
      } else {
         int i_1_ = 0;
         int i_2_ = string.length();

         while(i_1_ < i_2_ && Class13.method206(string.charAt(i_1_), 18)) {
            ++i_1_;
         }

         if (i != -13472) {
            return null;
         } else {
            while(~i_1_ > ~i_2_ && Class13.method206(string.charAt(-1 + i_2_), 10)) {
               --i_2_;
            }

            int i_3_ = -i_1_ + i_2_;
            if (~i_3_ <= -2 && ~i_3_ >= -13) {
               StringBuffer stringbuffer = new StringBuffer(i_3_);

               for(int i_4_ = i_1_; i_4_ < i_2_; ++i_4_) {
                  char c = string.charAt(i_4_);
                  if (r.method2357((byte)-117, c)) {
                     char c_5_ = Class77.method772((byte)-109, c);
                     if (c_5_ != 0) {
                        stringbuffer.append(c_5_);
                     }
                  }
               }

               return stringbuffer.length() == 0 ? null : stringbuffer.toString();
            } else {
               return null;
            }
         }
      }
   }

   static final Class299 method2672(boolean bool, int i) {
      if (!bool) {
         anIntArray9966 = null;
      }

      ++anInt9977;
      if (i != 0) {
         if (i == 1) {
            if ((double)WorldmapDefinitions.adjustingZoomFactor == 3.0) {
               return Class75.aClass299_1007;
            }

            if ((double)WorldmapDefinitions.adjustingZoomFactor == 4.0) {
               return Class352.aClass299_4329;
            }

            if ((double)WorldmapDefinitions.adjustingZoomFactor == 6.0) {
               return Class150_Sub2.aClass299_8962;
            }

            if ((double)WorldmapDefinitions.adjustingZoomFactor >= 8.0) {
               return aClass299_9980;
            }
         } else if (i == 2) {
            if ((double)WorldmapDefinitions.adjustingZoomFactor == 3.0) {
               return Class150_Sub2.aClass299_8962;
            }

            if ((double)WorldmapDefinitions.adjustingZoomFactor == 4.0) {
               return aClass299_9980;
            }

            if ((double)WorldmapDefinitions.adjustingZoomFactor == 6.0) {
               return Class195.aClass299_2380;
            }

            if ((double)WorldmapDefinitions.adjustingZoomFactor >= 8.0) {
               return Class190.aClass299_2330;
            }
         }
      } else {
         if ((double)WorldmapDefinitions.adjustingZoomFactor == 3.0) {
            return Packet.aClass299_9394;
         }

         if ((double)WorldmapDefinitions.adjustingZoomFactor == 4.0) {
            return EntityNode_Sub6.aClass299_5988;
         }

         if ((double)WorldmapDefinitions.adjustingZoomFactor == 6.0) {
            return Class75.aClass299_1007;
         }

         if ((double)WorldmapDefinitions.adjustingZoomFactor >= 8.0) {
            return Class352.aClass299_4329;
         }
      }

      return null;
   }

   @Override
   final void method2656(int i) {
      if (i != 100) {
         this.method2670(null, 90);
      }

      ++anInt9970;
      if (this.aFrame9986 != null) {
         this.aFrame9986.a();
      }

      if (this.aDecoderContext9961 != null) {
         this.aDecoderContext9961.a();
         this.aDecoderContext9961 = null;
      }

      if (this.aGranulePos9989 != null) {
         this.aGranulePos9989.a();
         this.aGranulePos9989 = null;
      }

      this.aTheoraInfo9972.a();
      this.aTheoraComment9981.a();
      this.aSetupInfo9968.a();
   }

   static final int method2673(int i, boolean bool, int i_6_, boolean bool_7_, int i_8_) {
      if (i <= 54) {
         method2674(100, -17, 53);
      }

      ++anInt9976;
      Node_Sub16 node_sub16 = Class295.getItemContainer(i_8_, (byte)18, bool_7_);
      if (node_sub16 == null) {
         return 0;
      } else {
         int i_9_ = 0;

         for(int slot = 0; ~slot > ~node_sub16.slotItemIds.length; ++slot) {
            if (node_sub16.slotItemIds[slot] >= 0 && ~node_sub16.slotItemIds[slot] > ~EntityNode_Sub3_Sub1.aClass86_9166.anInt1175) {
               ItemDefinitions itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(node_sub16.slotItemIds[slot]);
               int i_11_ = itemdefinition.method1678(i_6_, Class188_Sub2_Sub2.aClass36_9366.method394(i_6_, -78).anInt3443, 10247);
               if (bool) {
                  i_9_ += i_11_ * node_sub16.slotItemAmounts[slot];
               } else {
                  i_9_ += i_11_;
               }
            }
         }

         return i_9_;
      }
   }

   Node_Sub25_Sub3(OggStreamState oggstreamstate) {
      super(oggstreamstate);
   }

   static final boolean method2674(int i, int i_12_, int i_13_) {
      ++anInt9982;
      if (i_12_ != 393216) {
         aWidget9990 = null;
      }

      return Class262_Sub16.method3193(i_13_, i, (byte)-109) | ~(i & 393216) != -1
         || Class110.method1135(i, i_13_, false)
         || Class188_Sub1_Sub1.method1894(i, (byte)-29, i_13_);
   }

   final long method2675(int i) {
      if (i != -3744) {
         localNPCsCount = -126;
      }

      ++anInt9984;
      return this.aLong9973;
   }

   final double method2676(int i) {
      ++anInt9971;
      return this.aDouble9983;
   }

   final boolean method2677(byte b) {
      if (b < 82) {
         return true;
      } else {
         ++anInt9962;
         return this.aBoolean9991;
      }
   }

   @Override
   final void method2654(int i, OggPacket oggpacket) {
      ++anInt9965;
      if (this.aBoolean9991) {
         this.aLong9973 = Class313.method3650(false);
         int i_15_ = this.aDecoderContext9961.decodePacketIn(oggpacket, this.aGranulePos9989);
         if (~i_15_ > -1) {
            throw new IllegalStateException(String.valueOf(i_15_));
         }

         this.aDecoderContext9961.granuleFrame(this.aGranulePos9989);
         this.aDouble9983 = this.aDecoderContext9961.granuleTime(this.aGranulePos9989);
         if (this.aBoolean9964) {
            boolean bool = ~oggpacket.isKeyFrame() == -2;
            if (!bool) {
               return;
            }

            this.aBoolean9964 = false;
         }

         if (!this.aBoolean9969 || ~oggpacket.isKeyFrame() == -2) {
            if (this.aDecoderContext9961.decodeFrame(this.aFrame9986) != 0) {
               throw new IllegalStateException(String.valueOf(i_15_));
            }

            this.aBoolean9974 = true;
         }
      } else {
         int i_16_ = this.aSetupInfo9968.decodeHeader(this.aTheoraInfo9972, this.aTheoraComment9981, oggpacket);
         if (i_16_ == 0) {
            this.aBoolean9991 = true;
            if (~this.aTheoraInfo9972.frameWidth < -2049 || this.aTheoraInfo9972.frameHeight > 1024) {
               throw new IllegalStateException();
            }

            this.aDecoderContext9961 = new DecoderContext(this.aTheoraInfo9972, this.aSetupInfo9968);
            this.aGranulePos9989 = new GranulePos();
            this.aFrame9986 = new Frame(this.aTheoraInfo9972.frameWidth, this.aTheoraInfo9972.frameHeight);
            this.anInt9963 = this.aDecoderContext9961.getMaxPostProcessingLevel();
            this.method2669((byte)-125, this.anInt9975);
         } else if (~i_16_ > -1) {
            throw new IllegalStateException(String.valueOf(i_16_));
         }
      }

      if (i != 18986) {
         this.method2670(null, -63);
      }
   }
}
