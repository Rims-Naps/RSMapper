public class Class352 {
   protected int anInt4324 = 2;
   protected boolean aBoolean4325;
   protected int anInt4326;
   static int anInt4327;
   static int anInt4328;
   static Class299 aClass299_4329;
   protected int anInt4330 = -1;
   static int anInt4331;
   static Interface6[] anInterface6Array4332;
   static int anInt4333;
   protected int anInt4334;
   protected boolean aBoolean4335;
   protected int anInt4336;
   static int anInt4337;
   static IncommingPacket INCOMMING_PACKET_43 = new IncommingPacket(43, -2);
   static int anInt4339;
   static int anInt4340;

   private final void method4006(Buffer buffer, int i, byte b, int i_0_) {
      ++anInt4337;
      if (i_0_ != 1) {
         if (~i_0_ != -3) {
            if (~i_0_ == -4) {
               buffer.readByte();
            } else if (~i_0_ == -5) {
               this.anInt4324 = buffer.readUnsignedByte();
            } else if (i_0_ == 5) {
               this.anInt4336 = buffer.readUnsignedByte();
            } else if (~i_0_ == -7) {
               this.aBoolean4335 = true;
            } else if (i_0_ == 7) {
               this.aBoolean4325 = true;
            }
         } else {
            this.anInt4334 = buffer.readUnsignedShort() + 1;
            this.anInt4326 = buffer.readUnsignedShort() + 11;
         }
      } else {
         this.anInt4330 = buffer.readUnsignedShort();
         if (this.anInt4330 == 65535) {
            this.anInt4330 = -1;
         }
      }

      if (b != -2) {
         this.method4007(102, (byte)75, null);
      }
   }

   final void method4007(int i, byte b, Buffer buffer) {
      if (b != 97) {
         this.aBoolean4335 = false;
      }

      while(true) {
         int i_1_ = buffer.readUnsignedByte();
         if (i_1_ == 0) {
            ++anInt4333;
            return;
         }

         this.method4006(buffer, i, (byte)-2, i_1_);
      }
   }

   static final GLSprite method4008(byte b, int i, GraphicsToolkit graphicstoolkit) {
      ++anInt4327;
      int i_2_ = 96 % ((68 - b) / 40);
      Node_Sub3 node_sub3 = (Node_Sub3)Class56.aHashTable839.get(3512, (long)i);
      if (node_sub3 != null) {
         Node_Sub25_Sub3 node_sub25_sub3 = node_sub3.aClass189_Sub1_6943.method1930((byte)-117);
         node_sub3.aBoolean6949 = true;
         if (node_sub25_sub3 != null) {
            return node_sub25_sub3.method2670(graphicstoolkit, -10171);
         }
      }

      return null;
   }

   static final void method4009(int i, int i_3_, int i_4_, int i_5_, Actor actor) {
      ++anInt4328;
      RenderDefinitions class259 = actor.method868((byte)-127);
      if (i_5_ != -1) {
         anInterface6Array4332 = null;
      }

      Animator animator = actor.anAnimator10860;
      int i_6_ = 16383 & -actor.aClass99_10893.anInt1281 + actor.rotation;
      if (i == -1) {
         if (~i_6_ == -1 && ~actor.anInt10877 >= -26) {
            if (!actor.aBoolean10867 || !class259.method3130(animator.getAnimationId(), (byte)-127)) {
               animator.method249(true, class259.method3128(false));
               actor.aBoolean10867 = animator.method245(-127);
            }
         } else if (~i_3_ > -1 && class259.anInt3299 != -1) {
            animator.method249(true, class259.anInt3299);
            actor.aBoolean10867 = false;
         } else if (~i_3_ < -1 && ~class259.anInt3274 != 0) {
            animator.method249(true, class259.anInt3274);
            actor.aBoolean10867 = false;
         } else if (!actor.aBoolean10867 || !class259.method3130(animator.getAnimationId(), (byte)-128)) {
            animator.method249(true, class259.method3128(false));
            actor.aBoolean10867 = actor.anAnimator10860.method245(i_5_ + -123);
         }
      } else if (actor.faceEntity != -1 && (i_6_ >= 10240 || i_6_ <= 2048)) {
         int i_7_ = 16383 & -actor.aClass99_10893.anInt1281 + Node_Sub38_Sub21.anIntArray10318[i_4_];
         if (~i != -3 || ~class259.anInt3252 == 0) {
            if (~i == -1 && class259.anInt3262 != -1) {
               if (i_7_ > 2048 && ~i_7_ >= -6145 && ~class259.anInt3304 != 0) {
                  animator.method249(true, class259.anInt3304);
               } else if (i_7_ >= 10240 && i_7_ < 14336 && class259.anInt3269 != -1) {
                  animator.method249(true, class259.anInt3269);
               } else if (i_7_ > 6144 && i_7_ < 10240 && ~class259.anInt3297 != 0) {
                  animator.method249(true, class259.anInt3297);
               } else {
                  animator.method249(true, class259.anInt3262);
               }
            } else if (~i_7_ < -2049 && ~i_7_ >= -6145 && class259.anInt3287 != -1) {
               animator.method249(true, class259.anInt3287);
            } else if (i_7_ >= 10240 && i_7_ < 14336 && class259.anInt3301 != -1) {
               animator.method249(true, class259.anInt3301);
            } else if (~i_7_ < -6145 && i_7_ < 10240 && class259.anInt3286 != -1) {
               animator.method249(true, class259.anInt3286);
            } else {
               animator.method249(true, class259.walkAnimation);
            }
         } else if (i_7_ > 2048 && i_7_ <= 6144 && ~class259.anInt3293 != 0) {
            animator.method249(true, class259.anInt3293);
         } else if (i_7_ >= 10240 && i_7_ < 14336 && class259.anInt3270 != -1) {
            animator.method249(true, class259.anInt3270);
         } else if (i_7_ > 6144 && ~i_7_ > -10241 && class259.anInt3271 != -1) {
            animator.method249(true, class259.anInt3271);
         } else {
            animator.method249(true, class259.anInt3252);
         }

         actor.aBoolean10867 = false;
      } else if (~i_6_ == -1 && ~actor.anInt10877 >= -26) {
         if (i == 2 && class259.anInt3252 != -1) {
            animator.method249(true, class259.anInt3252);
         } else if (i == 0 && ~class259.anInt3262 != 0) {
            animator.method249(true, class259.anInt3262);
         } else {
            animator.method249(true, class259.walkAnimation);
         }

         actor.aBoolean10867 = false;
      } else {
         if (~i != -3 || class259.anInt3252 == -1) {
            if (~i == -1 && class259.anInt3262 != -1) {
               if (~i_3_ > -1 && class259.anInt3275 != -1) {
                  animator.method249(true, class259.anInt3275);
               } else if (i_3_ > 0 && class259.anInt3260 != -1) {
                  animator.method249(true, class259.anInt3260);
               } else {
                  animator.method249(true, class259.anInt3262);
               }
            } else if (~i_3_ > -1 && ~class259.anInt3298 != 0) {
               animator.method249(true, class259.anInt3298);
            } else if (i_3_ > 0 && class259.anInt3305 != -1) {
               animator.method249(true, class259.anInt3305);
            } else {
               animator.method249(true, class259.walkAnimation);
            }
         } else if (i_3_ < 0 && ~class259.anInt3282 != 0) {
            animator.method249(true, class259.anInt3282);
         } else if (~i_3_ < -1 && ~class259.anInt3253 != 0) {
            animator.method249(true, class259.anInt3253);
         } else {
            animator.method249(true, class259.anInt3252);
         }

         actor.aBoolean10867 = false;
      }
   }

   public static void method4010(int i) {
      anInterface6Array4332 = null;
      aClass299_4329 = null;
      if (i != -9757) {
         drawNPCOptions(false, null);
      }

      INCOMMING_PACKET_43 = null;
   }

   static final void method4011(int[] emotes, int i, boolean bool, Actor actor, int i_8_) {
      ++anInt4331;
      if (actor.anIntArray10817 != null) {
         boolean bool_9_ = true;

         for(int i_10_ = 0; actor.anIntArray10817.length > i_10_; ++i_10_) {
            if (emotes[i_10_] != actor.anIntArray10817[i_10_]) {
               bool_9_ = false;
               break;
            }
         }

         Animator animator = actor.anAnimator10876;
         if (bool_9_ && animator.method245(-128)) {
            Class48 class48 = actor.anAnimator10876.method243((byte)-24);
            int i_11_ = class48.anInt706;
            if (i_11_ == 1) {
               animator.method229((byte)63, i);
            }

            if (~i_11_ == -3) {
               animator.method251(true);
            }
         }
      }

      boolean bool_12_ = true;
      if (i_8_ >= -56) {
         aClass299_4329 = null;
      }

      for(int i_13_ = 0; i_13_ < emotes.length; ++i_13_) {
         if (~emotes[i_13_] != 0) {
            bool_12_ = false;
         }

         if (actor.anIntArray10817 == null
            || actor.anIntArray10817[i_13_] == -1
            || ~Class18.aClass37_306.method395(emotes[i_13_], (byte)-125).anInt710
               <= ~Class18.aClass37_306.method395(actor.anIntArray10817[i_13_], (byte)-100).anInt710) {
            actor.anIntArray10817 = emotes;
            actor.anAnimator10876.method227(i, 119);
            if (bool) {
               actor.anInt10900 = actor.anInt10904;
            }
         }
      }

      if (bool_12_) {
         actor.anIntArray10817 = emotes;
         actor.anAnimator10876.method227(i, 114);
         if (bool) {
            actor.anInt10900 = actor.anInt10904;
         }
      }
   }

   static final boolean method4012(int i) {
      int i_14_ = -7 / ((-59 - i) / 51);
      ++anInt4340;
      return !Node_Sub38_Sub2.method2793(1, "jaclib") ? false : Node_Sub38_Sub2.method2793(1, "hw3d");
   }

   static final void drawNPCOptions(boolean hideOptions, Npc npc) {
      ++anInt4339;
      if (~Class315.anInt4035 > -401) {
         NpcDefinition npcdefinition = npc.definitions;
         String name = npc.name;
         if (npcdefinition.anIntArray2827 != null) {
            npcdefinition = npcdefinition.method2999(65535, Class24.aClass275_442);
            if (npcdefinition == null) {
               return;
            }

            name = npcdefinition.name;
         }

         if (npcdefinition.showOnMinimap) {
            if (npc.combatLevel != 0) {
               String string_15_ = Class169_Sub4.aClass353_8825 != Class209.aClass353_2483
                  ? Class22.aClass22_391.getStoredString(Class35.language)
                  : Class22.aClass22_393.getStoredString(Class35.language);
               name = name + Class368.method4077(Class295.myPlayer.combatLevel, npc.combatLevel) + " (" + string_15_ + npc.combatLevel + ")";
            }

            if (Class87.removeWalkHere && !hideOptions) {
               Class267 class267 = Class324.anInt4087 != -1 ? Class188_Sub2_Sub2.aClass36_9366.method394(Class324.anInt4087, -120) : null;
               if ((2 & Class200_Sub2.anInt4943) != 0
                  && (class267 == null || ~npcdefinition.method3009(86, Class324.anInt4087, class267.anInt3443) != ~class267.anInt3443)) {
                  ++Class13.anInt205;
                  Node_Sub32.drawRightClickOptions(
                     false,
                     -1,
                     (long)npc.index,
                     0,
                     0,
                     Class84.aString1148,
                     23,
                     true,
                     Class201.anInt2444,
                     Class66.aString5177 + " -> <col=ffff00>" + name,
                     (long)npc.index,
                     (byte)-18,
                     false
                  );
               }
            }

            if (!hideOptions) {
               String[] strings = npcdefinition.rightClickActions;
               if (Node_Sub38_Sub9.aBoolean10191) {
                  strings = Class320_Sub10.method3721(0, strings);
               }

               if (strings != null) {
                  for(int i_16_ = strings.length - 1; ~i_16_ <= -1; --i_16_) {
                     if (strings[i_16_] != null
                        && (
                           ~npcdefinition.canClick == -1
                              || !strings[i_16_].equalsIgnoreCase(Class22.aClass22_386.getStoredString(Class35.language))
                                 && !strings[i_16_].equalsIgnoreCase(Class22.aClass22_385.getStoredString(Class35.language))
                        )) {
                        int i_17_ = 0;
                        int i_18_ = Class230_Sub1.anInt9013;
                        if (~i_16_ == -1) {
                           i_17_ = 49;
                        }

                        if (i_16_ == 1) {
                           i_17_ = 59;
                        }

                        if (~i_16_ == -3) {
                           i_17_ = 47;
                        }

                        if (~i_16_ == -4) {
                           i_17_ = 57;
                        }

                        if (~i_16_ == -5) {
                           i_17_ = 3;
                        }

                        if (i_16_ == 5) {
                           i_17_ = 1011;
                        }

                        if (i_16_ == npcdefinition.indexOfOptionSprite1) {
                           i_18_ = npcdefinition.optionSprite1;
                        }

                        if (npcdefinition.indexOfOptionSprite2 == i_16_) {
                           i_18_ = npcdefinition.optionSprite2;
                        }

                        Node_Sub32.drawRightClickOptions(
                           false,
                           -1,
                           (long)npc.index,
                           0,
                           0,
                           strings[i_16_],
                           i_17_,
                           true,
                           strings[i_16_].equalsIgnoreCase(Class22.aClass22_386.getStoredString(Class35.language)) ? npcdefinition.mouseHoverSprite : i_18_,
                           "<col=ffff00>" + name,
                           (long)npc.index,
                           (byte)-18,
                           false
                        );
                        ++Class216.anInt2548;
                     }
                  }

                  if (~npcdefinition.canClick == -2) {
                     for(int i_19_ = 0; strings.length > i_19_; ++i_19_) {
                        if (strings[i_19_] != null
                           && (
                              strings[i_19_].equalsIgnoreCase(Class22.aClass22_386.getStoredString(Class35.language))
                                 || strings[i_19_].equalsIgnoreCase(Class22.aClass22_385.getStoredString(Class35.language))
                           )) {
                           short s = 0;
                           if (~npc.combatLevel < ~Class295.myPlayer.combatLevel) {
                              s = 2000;
                           }

                           short s_20_ = 0;
                           int i_21_ = Class230_Sub1.anInt9013;
                           if (~i_19_ == -1) {
                              s_20_ = 49;
                           }

                           if (i_19_ == 1) {
                              s_20_ = 59;
                           }

                           if (i_19_ == 2) {
                              s_20_ = 47;
                           }

                           if (i_19_ == 3) {
                              s_20_ = 57;
                           }

                           if (~i_19_ == -5) {
                              s_20_ = 3;
                           }

                           if (i_19_ == 5) {
                              s_20_ = 1011;
                           }

                           if (~npcdefinition.indexOfOptionSprite1 == ~i_19_) {
                              i_21_ = npcdefinition.optionSprite1;
                           }

                           if (~s_20_ != -1) {
                              s_20_ += s;
                           }

                           if (npcdefinition.indexOfOptionSprite2 == i_19_) {
                              i_21_ = npcdefinition.optionSprite2;
                           }

                           ++Actor.anInt10847;
                           Node_Sub32.drawRightClickOptions(
                              false,
                              -1,
                              (long)npc.index,
                              0,
                              0,
                              strings[i_19_],
                              s_20_,
                              true,
                              !strings[i_19_].equalsIgnoreCase(Class22.aClass22_386.getStoredString(Class35.language))
                                 ? i_21_
                                 : npcdefinition.mouseHoverSprite,
                              "<col=ffff00>" + name,
                              (long)npc.index,
                              (byte)-18,
                              false
                           );
                        }
                     }
                  }
               }
            }
         }
      }
   }

   public Class352() {
      this.anInt4326 = 64;
      this.aBoolean4325 = false;
      this.aBoolean4335 = false;
      this.anInt4336 = 1;
      this.anInt4334 = 64;
   }
}
