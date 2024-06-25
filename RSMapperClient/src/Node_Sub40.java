public class Node_Sub40 extends Node {
   protected int[][] anIntArrayArray7499;
   static int anInt7500;
   static int anInt7501;
   protected boolean[] aBooleanArray7502;
   protected int anInt7503;
   static int anInt7504;
   static String[][] aStringArrayArray7505 = new String[][]{
      {"M1", "M2", "S1", "F"}, {"M1", "M2", "M3", "S1", "S2", "F"}, {"M1", "M2", "M3", "M4", "S1", "S2", "S3", "F"}
   };
   protected int anInt7506;
   static int anInt7507;
   static Class170 aClass170_7508 = new Class170(0, 1);
   static int anInt7509;
   protected int[] anIntArray7510;
   protected int[] anIntArray7511;
   static Class212 aClass212_7512 = new Class212("", 13);
   static String myPlayerDisplayName;
   static Class233 aClass233_7514 = Class234.method2144(74);

   static final void method2924(
      int i,
      int i_0_,
      int i_1_,
      int i_2_,
      int i_3_,
      GraphicsToolkit graphicstoolkit,
      int i_4_,
      int i_5_,
      int i_6_,
      int i_7_,
      int i_8_,
      CacheNode_Sub4 cachenode_sub4
   ) {
      ++anInt7500;
      if (i_7_ < i_4_ && i_4_ < i_0_ + i_7_ && ~(i_1_ - 13) > ~i && ~i > ~(3 + i_1_)) {
         i_5_ = i_3_;
      }

      String string = Node_Sub14.method2550(cachenode_sub4, (byte)62);
      if (i_2_ == -9330) {
         Class262_Sub4.aClass52_7721.method536(i_5_, 0, i_1_, string, i_2_ ^ 238953398, i_7_ + 3, Class105.aGLSpriteArray5194, Class290_Sub6.anIntArray8123);
      }
   }

   public static void method2925(int i) {
      if (i != 13) {
         method2928(null, (byte)57);
      }

      aClass170_7508 = null;
      myPlayerDisplayName = null;
      aClass212_7512 = null;
      aStringArrayArray7505 = null;
      aClass233_7514 = null;
   }

   static final void method2926(byte b, int i, GraphicsToolkit graphicstoolkit, int i_9_, int i_10_, int i_11_) {
      graphicstoolkit.KA(i_10_, i_11_, i_10_ - -i, i_9_ + i_11_);
      ++anInt7501;
      if (b > -60) {
         myPlayerDisplayName = null;
      }

      graphicstoolkit.method1239(i, i_9_, i_11_, (byte)116, i_10_, -16777216);
      if (~Node_Sub25_Sub1.worldmapLoaded <= -101) {
         float f = (float)WorldmapDefinitions.totalYTiles / (float)WorldmapDefinitions.totalXTiles;
         int i_12_ = i;
         int i_13_ = i_9_;
         if (f < 1.0F) {
            i_13_ = (int)(f * (float)i);
         } else {
            i_12_ = (int)((float)i_9_ / f);
         }

         i_10_ += (-i_12_ + i) / 2;
         i_11_ += (-i_13_ + i_9_) / 2;
         if (Node_Sub2.aGLSprite6935 == null || Node_Sub2.aGLSprite6935.method1193() != i || Node_Sub2.aGLSprite6935.method1176() != i_9_) {
            WorldmapDefinitions.method272(
               WorldmapDefinitions.regionXWorldCoordinate,
               WorldmapDefinitions.regionYWorldCoordinate + WorldmapDefinitions.totalYTiles,
               WorldmapDefinitions.totalXTiles + WorldmapDefinitions.regionXWorldCoordinate,
               WorldmapDefinitions.regionYWorldCoordinate,
               i_10_,
               i_11_,
               i_10_ + i_12_,
               i_11_ - -i_13_
            );
            WorldmapDefinitions.updateWorldMap(graphicstoolkit);
            Node_Sub2.aGLSprite6935 = graphicstoolkit.a(i_10_, i_11_, i_12_, i_13_, false);
         }

         Node_Sub2.aGLSprite6935.method1196(i_10_, i_11_);
         int i_14_ = i_12_ * GameStub.anInt46 / WorldmapDefinitions.totalXTiles;
         int i_15_ = Class313.anInt4011 * i_13_ / WorldmapDefinitions.totalYTiles;
         int i_16_ = Class282.anInt3584 * i_12_ / WorldmapDefinitions.totalXTiles + i_10_;
         int i_17_ = -i_15_ + i_13_ + i_11_ + -(Class271.anInt3479 * i_13_ / WorldmapDefinitions.totalYTiles);
         int i_18_ = -1996554240;
         if (Class209.aClass353_2483 == Class169_Sub4.aClass353_8825) {
            i_18_ = -1996488705;
         }

         graphicstoolkit.aa(i_16_, i_17_, i_14_, i_15_, i_18_, 1);
         graphicstoolkit.d(i_16_, i_17_, i_14_, i_15_, i_18_, 0);
         if (Class168.anInt2044 > 0) {
            int i_19_;
            if (Node_Sub15_Sub4.anInt9800 > 50) {
               i_19_ = 5 * (100 - Node_Sub15_Sub4.anInt9800);
            } else {
               i_19_ = Node_Sub15_Sub4.anInt9800 * 5;
            }

            for(Node_Sub14 node_sub14 = (Node_Sub14)WorldmapDefinitions.aClass312_331.method3613(65280);
               node_sub14 != null;
               node_sub14 = (Node_Sub14)WorldmapDefinitions.aClass312_331.method3620(16776960)
            ) {
               AreaDefinitions class79 = WorldmapDefinitions.aClass215_322.getAreaDefinitions((byte)115, node_sub14.anInt7128);
               if (Class220.method2099(true, class79)) {
                  if (~Class253.anInt3201 != ~node_sub14.anInt7128) {
                     if (~Node_Sub38_Sub19.anInt10296 != 0 && Node_Sub38_Sub19.anInt10296 == class79.type) {
                        int i_20_ = i_10_ + i_12_ * node_sub14.anInt7125 / WorldmapDefinitions.totalXTiles;
                        int i_21_ = i_11_ - -((-node_sub14.anInt7120 + WorldmapDefinitions.totalYTiles) * i_13_ / WorldmapDefinitions.totalYTiles);
                        graphicstoolkit.method1239(4, 4, -2 + i_21_, (byte)116, -2 + i_20_, i_19_ << 24 | 16776960);
                     }
                  } else {
                     int i_22_ = i_10_ + node_sub14.anInt7125 * i_12_ / WorldmapDefinitions.totalXTiles;
                     int i_23_ = i_11_ + i_13_ * (WorldmapDefinitions.totalYTiles + -node_sub14.anInt7120) / WorldmapDefinitions.totalYTiles;
                     graphicstoolkit.method1239(4, 4, -2 + i_23_, (byte)116, i_22_ - 2, 16776960 | i_19_ << 24);
                  }
               }
            }
         }
      }
   }

   static final void method2927(boolean bool, int id, int volume) {
      ++anInt7509;
      if (Class56.aHashTable839.get(3512, (long)id) == null) {
         if (Class235_Sub1.aBoolean8975) {
            Node_Sub3 node_sub3 = new Node_Sub3(id, new Class189_Sub1(4096, Node_Sub38_Sub38.index36, id), volume, bool);
            node_sub3.aClass189_Sub1_6943.method1926(16, "");
            Class56.aHashTable839.put((long)id, node_sub3, -127);
         } else {
            Class341.method3960(id, bool, (byte)89);
         }
      }
   }

   static final Class235 method2928(Buffer buffer, byte b) {
      ++anInt7504;
      if (b != -24) {
         return null;
      } else {
         int i = buffer.readUnsignedShort();
         Class379 class379 = Class23.method302(1476280292)[buffer.readUnsignedByte()];
         Class77 class77 = PlayerDefinition.method3277(12247)[buffer.readUnsignedByte()];
         int i_27_ = buffer.readShort();
         int i_28_ = buffer.readShort();
         return new Class235(i, class379, class77, i_27_, i_28_);
      }
   }

   static final boolean method2929(int i, int i_29_, int i_30_) {
      if (i_29_ != 0) {
         aStringArrayArray7505 = null;
      }

      ++anInt7507;
      return Class46.method470(i, -47, i_30_) || Node_Sub41.method2932(i_29_ + -97, i_30_, i);
   }

   Node_Sub40(int i, byte[] bs) {
      this.anInt7506 = i;
      Buffer buffer = new Buffer(bs);
      this.anInt7503 = buffer.readUnsignedByte();
      this.anIntArray7510 = new int[this.anInt7503];
      this.aBooleanArray7502 = new boolean[this.anInt7503];
      this.anIntArrayArray7499 = new int[this.anInt7503][];
      this.anIntArray7511 = new int[this.anInt7503];

      for(int i_31_ = 0; ~i_31_ > ~this.anInt7503; ++i_31_) {
         this.anIntArray7511[i_31_] = buffer.readUnsignedByte();
         if (this.anIntArray7511[i_31_] == 6) {
            this.anIntArray7511[i_31_] = 2;
         }
      }

      for(int i_32_ = 0; i_32_ < this.anInt7503; ++i_32_) {
         this.aBooleanArray7502[i_32_] = buffer.readUnsignedByte() == 1;
      }

      for(int i_33_ = 0; ~i_33_ > ~this.anInt7503; ++i_33_) {
         this.anIntArray7510[i_33_] = buffer.readUnsignedShort();
      }

      for(int i_34_ = 0; ~this.anInt7503 < ~i_34_; ++i_34_) {
         this.anIntArrayArray7499[i_34_] = new int[buffer.readUnsignedByte()];
      }

      for(int i_35_ = 0; i_35_ < this.anInt7503; ++i_35_) {
         for(int i_36_ = 0; ~i_36_ > ~this.anIntArrayArray7499[i_35_].length; ++i_36_) {
            this.anIntArrayArray7499[i_35_][i_36_] = buffer.readUnsignedByte();
         }
      }
   }
}
