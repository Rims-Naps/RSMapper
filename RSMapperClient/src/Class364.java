public class Class364 {
   protected int registerHoverPositionX;
   static boolean aBoolean4512;
   static Class273[] aClass273Array4513;
   static int anInt4514 = 0;
   private int mouseCursorSprite;
   protected Class239 aClass239_4516;
   static int anInt4517;
   static int anInt4518;
   protected int registerHoverPositionY;
   static int anInt4520;
   static int anInt4521;

   static final void method4057(boolean bool, int regionX, int i_0_, int regionY, byte b) {
      if (aa.anInt101 == 4) {
         aa.anInt101 = 0;
         Class200_Sub2.anInt4935 = -1;
      }

      ++anInt4521;
      if (bool
         || ~Player.regionX != ~regionX
         || Class277.regionY != regionY
         || Class94.anInt1249 != CacheNode_Sub20_Sub1.myPlayerPlane && Class213.aNode_Sub27_2512.aClass320_Sub19_7301.method3751(false) != 1) {
         Class277.regionY = regionY;
         Player.regionX = regionX;
         Class94.anInt1249 = CacheNode_Sub20_Sub1.myPlayerPlane;
         if (Class213.aNode_Sub27_2512.aClass320_Sub19_7301.method3751(false) == 1) {
            Class94.anInt1249 = 0;
         }

         Class48.method478(i_0_, (byte)97);
         int i_2_ = Node_Sub53.gameSceneBaseX;
         Node_Sub53.gameSceneBaseX = 8 * (-(Node_Sub54.GAME_SCENE_WDITH >> 4) + Player.regionX);
         int i_3_ = Class320_Sub4.gameSceneBaseY;
         Class320_Sub4.gameSceneBaseY = (Class277.regionY + -(Class377_Sub1.GAME_SCENE_HEIGHT >> 4)) * 8;
         Class92.aCacheNode_Sub11_1233 = WorldmapDefinitions.method288(Player.regionX * 8, Class277.regionY * 8);
         Class262_Sub15_Sub1.aClass224_10520 = null;
         int i_4_ = Node_Sub53.gameSceneBaseX + -i_2_;
         int i_5_ = Class320_Sub4.gameSceneBaseY - i_3_;
         if (~i_0_ != -13) {
            boolean bool_6_ = false;
            Node_Sub25_Sub3.localNPCsCount = 0;
            int i_7_ = (-1 + Node_Sub54.GAME_SCENE_WDITH) * 512;
            int i_8_ = Class377_Sub1.GAME_SCENE_HEIGHT * 512 + -512;

            for(int i_9_ = 0; ~Node_Sub32.cachedNPCcsCount < ~i_9_; ++i_9_) {
               Node_Sub41 node_sub41 = Class314.LocalNPCs[i_9_];
               if (node_sub41 != null) {
                  Npc npc = node_sub41.aNpc7518;
                  npc.y -= i_5_ * 512;
                  npc.x -= 512 * i_4_;
                  if (~npc.x <= -1 && ~i_7_ <= ~npc.x && npc.y >= 0 && i_8_ >= npc.y) {
                     boolean bool_10_ = true;

                     for(int i_11_ = 0; ~npc.scenePositionXQueue.length < ~i_11_; ++i_11_) {
                        npc.scenePositionXQueue[i_11_] -= i_4_;
                        npc.scenePositionYQueue[i_11_] -= i_5_;
                        if (npc.scenePositionXQueue[i_11_] < 0
                           || npc.scenePositionXQueue[i_11_] >= Node_Sub54.GAME_SCENE_WDITH
                           || npc.scenePositionYQueue[i_11_] < 0
                           || Class377_Sub1.GAME_SCENE_HEIGHT <= npc.scenePositionYQueue[i_11_]) {
                           bool_10_ = false;
                        }
                     }

                     if (!bool_10_) {
                        npc.method879(null, true);
                        bool_6_ = true;
                        node_sub41.method2160((byte)29);
                     } else {
                        Class54.LocalNPCsIndexes[Node_Sub25_Sub3.localNPCsCount++] = npc.index;
                     }
                  } else {
                     npc.method879(null, true);
                     bool_6_ = true;
                     node_sub41.method2160((byte)29);
                  }
               }
            }

            if (bool_6_) {
               Node_Sub32.cachedNPCcsCount = Class12.aHashTable187.method1519((byte)-90);
               Class12.aHashTable187.method1523((byte)-125, Class314.LocalNPCs);
            }
         } else {
            for(int i_12_ = 0; ~i_12_ > ~Node_Sub32.cachedNPCcsCount; ++i_12_) {
               Node_Sub41 node_sub41 = Class314.LocalNPCs[i_12_];
               if (node_sub41 != null) {
                  Npc npc = node_sub41.aNpc7518;

                  for(int i_13_ = 0; ~npc.scenePositionXQueue.length < ~i_13_; ++i_13_) {
                     npc.scenePositionXQueue[i_13_] -= i_4_;
                     npc.scenePositionYQueue[i_13_] -= i_5_;
                  }

                  npc.x -= 512 * i_4_;
                  npc.y -= i_5_ * 512;
               }
            }
         }

         if (b != -36) {
            method4058(-108);
         }

         for(int i_14_ = 0; ~i_14_ > -2049; ++i_14_) {
            Player player = Class270_Sub2.LOCAL_PLAYERS[i_14_];
            if (player != null) {
               for(int i_15_ = 0; ~i_15_ > ~player.scenePositionXQueue.length; ++i_15_) {
                  player.scenePositionXQueue[i_15_] -= i_4_;
                  player.scenePositionYQueue[i_15_] -= i_5_;
               }

               player.y -= 512 * i_5_;
               player.x -= i_4_ * 512;
            }
         }

         Class223[] class223s = Class320_Sub24.cachedHintIcons;

         for(int i_16_ = 0; i_16_ < class223s.length; ++i_16_) {
            Class223 class223 = class223s[i_16_];
            if (class223 != null) {
               class223.anInt2653 -= 512 * i_5_;
               class223.anInt2662 -= 512 * i_4_;
            }
         }

         for(Node_Sub19 node_sub19 = (Node_Sub19)Class89.aClass312_1199.method3613(b + '\uFF24');
             node_sub19 != null;
             node_sub19 = (Node_Sub19)Class89.aClass312_1199.method3620(b ^ -16776996)
         ) {
            node_sub19.x -= i_4_;
            node_sub19.y -= i_5_;
            if (Class61.anInt898 != 4 && node_sub19.x >= 0 && node_sub19.y >= 0 && ~node_sub19.x > ~Node_Sub54.GAME_SCENE_WDITH) {
               ;
            }
         }

         for(Node_Sub19 node_sub19 = (Node_Sub19)Class262_Sub8.aClass312_7755.method3613(65280);
            node_sub19 != null;
            node_sub19 = (Node_Sub19)Class262_Sub8.aClass312_7755.method3620(b ^ -16776996)
         ) {
            node_sub19.y -= i_5_;
            node_sub19.x -= i_4_;
            if (Class61.anInt898 != 4 && node_sub19.x >= 0 && node_sub19.y >= 0 && node_sub19.x < Node_Sub54.GAME_SCENE_WDITH) {
               ;
            }
         }

         if (Class61.anInt898 != 4) {
            for(Node_Sub11 node_sub11 = (Node_Sub11)Class266.aHashTable3380.method1516(false);
               node_sub11 != null;
               node_sub11 = (Node_Sub11)Class266.aHashTable3380.method1520(b ^ -121)
            ) {
               int i_17_ = (int)(16383L & node_sub11.scriptId);
               int i_18_ = i_17_ - Node_Sub53.gameSceneBaseX;
               int i_19_ = (int)(node_sub11.scriptId >> 14 & 16383L);
               int i_20_ = i_19_ + -Class320_Sub4.gameSceneBaseY;
               if (i_18_ >= 0 && ~i_20_ <= -1 && i_18_ < Node_Sub54.GAME_SCENE_WDITH) {
                  ;
               }
            }
         }

         if (Class359.minimapFlagLocalX != 0) {
            Node_Sub15_Sub4.minimapFlagLocalY -= i_5_;
            Class359.minimapFlagLocalX -= i_4_;
         }

         Class199.method2010((byte)120);
         if (~i_0_ == -13) {
            if (~Class320_Sub22.anInt8415 != -5) {
               Class368.anInt4551 = -1;
               Class367.anInt4541 = -1;
               Class320_Sub22.anInt8415 = 1;
            } else {
               Class234.anInt2792 -= i_4_ * 512;
               Class25.playerPositionY -= i_5_ * 512;
               Node_Sub19.anInt7173 -= i_5_ * 512;
               Mobile_Sub4.playerPositionX -= 512 * i_4_;
            }
         } else {
            Class238.anInt2911 -= i_4_;
            Renderer.anInt3663 -= i_4_;
            Node_Sub38_Sub38.anInt10490 -= i_5_;
            Node_Sub10.cameraPosY -= i_5_ * 512;
            Class98.cameraPosX -= i_4_ * 512;
            Class10.anInt174 -= i_5_;
            if (Math.abs(i_4_) > Node_Sub54.GAME_SCENE_WDITH || ~Math.abs(i_5_) < ~Class377_Sub1.GAME_SCENE_HEIGHT) {
               Class120.method1228(-97);
            }
         }
      }
   }

   public static void method4058(int i) {
      aClass273Array4513 = null;
      int i_21_ = 56 / ((-43 - i) / 47);
   }

   private final void decodeMouseCursor(Buffer buffer, int junk, int i_22_) {
      if (junk < 45) {
         this.registerHoverPositionX = 118;
      }

      if (i_22_ == 1) {
         this.mouseCursorSprite = buffer.readUnsignedShort();
      } else if (i_22_ == 2) {
         this.registerHoverPositionX = buffer.readUnsignedByte();
         this.registerHoverPositionY = buffer.readUnsignedByte();
      }

      ++anInt4518;
   }

   final synchronized Class383 method4060(byte b) {
      ++anInt4517;
      Class383 class383 = (Class383)this.aClass239_4516.aClass61_2925.method607((long)this.mouseCursorSprite, 0);
      if (class383 != null) {
         return class383;
      } else {
         if (b <= 68) {
            this.registerHoverPositionY = 105;
         }

         class383 = Class383.method4194(this.aClass239_4516.aClass302_2918, this.mouseCursorSprite, 0);
         if (class383 != null) {
            this.aClass239_4516.aClass61_2925.method601(class383, 25566, (long)this.mouseCursorSprite);
         }

         return class383;
      }
   }

   final void loadMouseCursorDefs(Buffer buffer, int i) {
      if (i != 0) {
         this.decodeMouseCursor(null, 90, -110);
      }

      ++anInt4520;

      while(true) {
         int i_23_ = buffer.readUnsignedByte();
         if (i_23_ == 0) {
            return;
         }

         this.decodeMouseCursor(buffer, i + 110, i_23_);
      }
   }
}
