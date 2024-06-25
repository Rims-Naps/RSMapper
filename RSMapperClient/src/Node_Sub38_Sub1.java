public class Node_Sub38_Sub1 extends Node_Sub38 {
   static int anInt10074;
   static int anInt10075;
   static int anInt10076;
   static int anInt10077;
   static int anInt10078;
   private int anInt10079;
   static int anInt10080;
   static int anInt10081;
   static int anInt10082;
   static int anInt10083;
   static Class277_Sub1 aClass277_Sub1_Map;
   static int anInt10085;
   static Class329 aClass329_10086;
   private int anInt10087 = -1;
   static int anInt10088;
   private int[] anIntArray10089;
   private int anInt10090;

   static final void method2788(int i, int i_0_, int i_1_) {
      ++anInt10077;
      CacheNode_Sub2 cachenode_sub2 = Class320_Sub19.method3754(3, 6, (long)i_1_);
      cachenode_sub2.method2288(0);
      cachenode_sub2.anInt9434 = i_0_;
      if (i < 38) {
         aClass329_10086 = null;
      }
   }

   @Override
   final void method2787(int i) {
      super.method2787(107);
      ++anInt10082;
      this.anIntArray10089 = null;
   }

   @Override
   final int[][] method2778(int i, boolean bool) {
      ++anInt10078;
      if (!bool) {
         return null;
      } else {
         int[][] is = this.aClass348_7454.method3981(i, 3168);
         if (this.aClass348_7454.aBoolean4300) {
            int i_3_ = (~this.anInt10079 == ~anInt10083 ? i : i * this.anInt10079 / anInt10083) * this.anInt10090;
            int[] is_4_ = is[0];
            int[] is_5_ = is[1];
            int[] is_6_ = is[2];
            if (~this.anInt10090 != ~Class339_Sub7.anInt8728) {
               for(int i_7_ = 0; ~Class339_Sub7.anInt8728 < ~i_7_; ++i_7_) {
                  int i_8_ = i_7_ * this.anInt10090 / Class339_Sub7.anInt8728;
                  int i_9_ = this.anIntArray10089[i_8_ + i_3_];
                  is_6_[i_7_] = Node_Sub30.method2723(4080, i_9_ << 4);
                  is_5_[i_7_] = Node_Sub30.method2723(65280, i_9_) >> 4;
                  is_4_[i_7_] = Node_Sub30.method2723(4080, i_9_ >> 12);
               }
            } else {
               for(int i_10_ = 0; Class339_Sub7.anInt8728 > i_10_; ++i_10_) {
                  int i_11_ = this.anIntArray10089[i_3_++];
                  is_6_[i_10_] = Node_Sub30.method2723(255, i_11_) << 4;
                  is_5_[i_10_] = Node_Sub30.method2723(4080, i_11_ >> 4);
                  is_4_[i_10_] = Node_Sub30.method2723(i_11_ >> 12, 4080);
               }
            }
         }

         return is;
      }
   }

   static final void method2789(int i, byte b, int i_12_, int i_13_, Node_Sub8 node_sub8) {
      ++anInt10074;
      long l = (long)(i_12_ << 14 | i << 28 | i_13_);
      Node_Sub11 node_sub11 = (Node_Sub11)Class266.aHashTable3380.get(3512, l);
      if (node_sub11 == null) {
         node_sub11 = new Node_Sub11();
         Class266.aHashTable3380.put(l, node_sub11, -127);
         node_sub11.aClass312_7104.method3625((byte)-54, node_sub8);
      } else {
         ItemDefinitions itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(node_sub8.anInt7065);
         int i_14_ = itemdefinition.value;
         if (itemdefinition.stackable == 1) {
            i_14_ *= 1 + node_sub8.anInt7067;
         }

         for(Node_Sub8 node_sub8_15_ = (Node_Sub8)node_sub11.aClass312_7104.method3613(65280);
            node_sub8_15_ != null;
            node_sub8_15_ = (Node_Sub8)node_sub11.aClass312_7104.method3620(b + 16777068)
         ) {
            itemdefinition = EntityNode_Sub3_Sub1.aClass86_9166.getItemDefinitionForId(node_sub8_15_.anInt7065);
            int i_16_ = itemdefinition.value;
            if (itemdefinition.stackable == 1) {
               i_16_ *= 1 + node_sub8_15_.anInt7067;
            }

            if (~i_14_ < ~i_16_) {
               Buffer.method2205(b + 228, node_sub8_15_, node_sub8);
               return;
            }
         }

         if (b == -108) {
            node_sub11.aClass312_7104.method3625((byte)-54, node_sub8);
         }
      }
   }

   public static void method2790(boolean bool) {
      aClass329_10086 = null;
      if (bool) {
         method2789(8, (byte)-45, -49, -88, null);
      }

      aClass277_Sub1_Map = null;
   }

   @Override
   final void method2780(boolean bool, Buffer buffer, int i) {
      ++anInt10080;
      if (bool) {
         this.anInt10087 = -36;
      }

      if (~i == -1) {
         this.anInt10087 = buffer.readUnsignedShort();
      }
   }

   public Node_Sub38_Sub1() {
      super(0, false);
   }

   static final void method2791(int i, int i_17_) {
      ++anInt10076;
      if (~i_17_ == -38) {
         WorldmapDefinitions.zoomFactorPrecise = 3.0F;
      } else if (~i_17_ == -51) {
         WorldmapDefinitions.zoomFactorPrecise = 4.0F;
      } else if (i_17_ == 75) {
         WorldmapDefinitions.zoomFactorPrecise = 6.0F;
      } else if (~i_17_ == -101) {
         WorldmapDefinitions.zoomFactorPrecise = 8.0F;
      } else if (~i_17_ == -201) {
         WorldmapDefinitions.zoomFactorPrecise = 16.0F;
      }

      Class150_Sub3.anInt8963 = -1;
      Class150_Sub3.anInt8963 = -1;
   }

   @Override
   final void method2782(int i, int i_19_, boolean bool) {
      ++anInt10085;
      super.method2782(i, i_19_, bool);
      if (bool) {
         method2789(1, (byte)-69, 44, -98, null);
      }

      if (this.anInt10087 >= 0 && Node_Sub38_Sub35.aD10455 != null) {
         int i_20_ = !Node_Sub38_Sub35.aD10455.getTexture(this.anInt10087, -8217).skipTriangles ? 128 : 64;
         this.anIntArray10089 = Node_Sub38_Sub35.aD10455.method11(i_20_, false, i_20_, this.anInt10087, (byte)0, 1.0F);
         this.anInt10079 = i_20_;
         this.anInt10090 = i_20_;
      }
   }

   static final boolean method2792(int i, int i_21_, int i_22_) {
      if (i_22_ != -1) {
         method2791(22, 59);
      }

      ++anInt10088;
      return ~(55 & i_21_) != -1;
   }

   @Override
   final int method2783(int i) {
      if (i != -1) {
         this.method2780(true, null, 82);
      }

      ++anInt10081;
      return this.anInt10087;
   }
}
