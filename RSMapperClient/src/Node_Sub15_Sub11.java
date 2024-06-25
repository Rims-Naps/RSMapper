public class Node_Sub15_Sub11 extends Node_Sub15 {
   private int anInt9854;
   static int anInt9855;
   static int anInt9856 = 4;
   static int anInt9857;
   static int anInt9858;
   static Index aClass302_9859;
   private int anInt9860;

   static final void handleWorldmapRightClickOptions(byte b, int i, int i_0_) {
      ++anInt9855;
      if (b != -114) {
         aClass302_9859 = null;
      }

      if (WorldmapDefinitions.zoomFactorPrecise > WorldmapDefinitions.adjustingZoomFactor) {
         WorldmapDefinitions.adjustingZoomFactor = (float)(
            (double)WorldmapDefinitions.adjustingZoomFactor + (double)WorldmapDefinitions.adjustingZoomFactor / 30.0
         );
         if (WorldmapDefinitions.zoomFactorPrecise < WorldmapDefinitions.adjustingZoomFactor) {
            WorldmapDefinitions.adjustingZoomFactor = WorldmapDefinitions.zoomFactorPrecise;
         }

         Class207.method2039(b ^ -66);
         WorldmapDefinitions.zoomFactor = (int)WorldmapDefinitions.adjustingZoomFactor >> 1;
         WorldmapDefinitions.aByteArrayArrayArray332 = Node_Sub29_Sub3.method2719(-7499, WorldmapDefinitions.zoomFactor);
      } else if (WorldmapDefinitions.adjustingZoomFactor > WorldmapDefinitions.zoomFactorPrecise) {
         WorldmapDefinitions.adjustingZoomFactor = (float)(
            (double)WorldmapDefinitions.adjustingZoomFactor - (double)WorldmapDefinitions.adjustingZoomFactor / 30.0
         );
         if (WorldmapDefinitions.zoomFactorPrecise > WorldmapDefinitions.adjustingZoomFactor) {
            WorldmapDefinitions.adjustingZoomFactor = WorldmapDefinitions.zoomFactorPrecise;
         }

         Class207.method2039(93);
         WorldmapDefinitions.zoomFactor = (int)WorldmapDefinitions.adjustingZoomFactor >> 1;
         WorldmapDefinitions.aByteArrayArrayArray332 = Node_Sub29_Sub3.method2719(-7499, WorldmapDefinitions.zoomFactor);
      }

      if (~Class262_Sub4.anInt7730 != 0 && ~Class150_Sub3.anInt8963 != 0) {
         int i_1_ = -Class94.anInt1250 + Class262_Sub4.anInt7730;
         if (~i_1_ > -3 || i_1_ > 2) {
            i_1_ /= 8;
         }

         int i_2_ = -Class327.anInt5360 + Class150_Sub3.anInt8963;
         Class94.anInt1250 += i_1_;
         if (i_2_ < 2 || ~i_2_ < -3) {
            i_2_ /= 8;
         }

         if (~i_1_ == -1 && i_2_ == 0) {
            Class150_Sub3.anInt8963 = -1;
            Class262_Sub4.anInt7730 = -1;
         }

         Class327.anInt5360 -= -i_2_;
         Class207.method2039(8);
      }

      if (Class168.anInt2044 > 0) {
         --Node_Sub15_Sub4.anInt9800;
         if (Node_Sub15_Sub4.anInt9800 == 0) {
            --Class168.anInt2044;
            Node_Sub15_Sub4.anInt9800 = 100;
         }
      } else {
         Class253.anInt3201 = -1;
         Node_Sub38_Sub19.anInt10296 = -1;
      }

      if (Class336_Sub1.aBoolean8543 && Node_Sub43.aClass312_7541 != null) {
         for(Node_Sub31 node_sub31 = (Node_Sub31)Node_Sub43.aClass312_7541.method3613(65280);
            node_sub31 != null;
            node_sub31 = (Node_Sub31)Node_Sub43.aClass312_7541.method3620(16776960)
         ) {
            AreaDefinitions area = WorldmapDefinitions.aClass215_322.getAreaDefinitions((byte)113, node_sub31.aNode_Sub14_7375.anInt7128);
            if (node_sub31.method2728(i, (byte)36, i_0_)) {
               if (area.rightClickOptions != null) {
                  if (area.rightClickOptions[4] != null) {
                     Node_Sub32.drawRightClickOptions(
                        false,
                        -1,
                        (long)node_sub31.aNode_Sub14_7375.anInt7128,
                        area.type,
                        0,
                        area.rightClickOptions[4],
                        1004,
                        true,
                        -1,
                        area.baseOption,
                        (long)node_sub31.aNode_Sub14_7375.anInt7128,
                        (byte)-18,
                        false
                     );
                  }

                  if (area.rightClickOptions[3] != null) {
                     Node_Sub32.drawRightClickOptions(
                        false,
                        -1,
                        (long)node_sub31.aNode_Sub14_7375.anInt7128,
                        area.type,
                        0,
                        area.rightClickOptions[3],
                        1009,
                        true,
                        -1,
                        area.baseOption,
                        (long)node_sub31.aNode_Sub14_7375.anInt7128,
                        (byte)-18,
                        false
                     );
                  }

                  if (area.rightClickOptions[2] != null) {
                     Node_Sub32.drawRightClickOptions(
                        false,
                        -1,
                        (long)node_sub31.aNode_Sub14_7375.anInt7128,
                        area.type,
                        0,
                        area.rightClickOptions[2],
                        1006,
                        true,
                        -1,
                        area.baseOption,
                        (long)node_sub31.aNode_Sub14_7375.anInt7128,
                        (byte)-18,
                        false
                     );
                  }

                  if (area.rightClickOptions[1] != null) {
                     Node_Sub32.drawRightClickOptions(
                        false,
                        -1,
                        (long)node_sub31.aNode_Sub14_7375.anInt7128,
                        area.type,
                        0,
                        area.rightClickOptions[1],
                        1001,
                        true,
                        -1,
                        area.baseOption,
                        (long)node_sub31.aNode_Sub14_7375.anInt7128,
                        (byte)-18,
                        false
                     );
                  }

                  if (area.rightClickOptions[0] != null) {
                     Node_Sub32.drawRightClickOptions(
                        false,
                        -1,
                        (long)node_sub31.aNode_Sub14_7375.anInt7128,
                        area.type,
                        0,
                        area.rightClickOptions[0],
                        1003,
                        true,
                        -1,
                        area.baseOption,
                        (long)node_sub31.aNode_Sub14_7375.anInt7128,
                        (byte)-18,
                        false
                     );
                  }
               }

               if (!node_sub31.aNode_Sub14_7375.aBoolean7127) {
                  node_sub31.aNode_Sub14_7375.aBoolean7127 = true;
                  ClientScriptsExecutor.method3565(Class3.aClass212_5159, node_sub31.aNode_Sub14_7375.anInt7128, area.type);
               }

               if (node_sub31.aNode_Sub14_7375.aBoolean7127) {
                  ClientScriptsExecutor.method3565(Node_Sub38_Sub29.aClass212_10406, node_sub31.aNode_Sub14_7375.anInt7128, area.type);
               }
            } else if (node_sub31.aNode_Sub14_7375.aBoolean7127) {
               node_sub31.aNode_Sub14_7375.aBoolean7127 = false;
               ClientScriptsExecutor.method3565(WorldmapAreaDetail.aClass212_9548, node_sub31.aNode_Sub14_7375.anInt7128, area.type);
            }
         }
      }
   }

   @Override
   final void method2556(ClanChat clanchat, int i) {
      if (i == 16) {
         ++anInt9857;
         clanchat.method509(this.anInt9854, this.anInt9860, -553);
      }
   }

   public static void method2581(int i) {
      aClass302_9859 = null;
      if (i < 13) {
         method2581(96);
      }
   }

   @Override
   final void method2554(int i, Buffer buffer) {
      ++anInt9858;
      this.anInt9860 = buffer.readInt();
      this.anInt9854 = buffer.readInt();
      if (i != 29147) {
         this.method2554(23, null);
      }
   }

   Node_Sub15_Sub11() {
   }
}
